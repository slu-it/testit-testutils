package info.novatec.testit.testutils.logrecorder.internal.logback;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ch.qos.logback.classic.Level;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import info.novatec.testit.testutils.logrecorder.api.LogLevel;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogLevelConverter {

    public static final Map<Level, LogLevel> CACHE = new HashMap<>();

    public static LogLevel convert(Level level) {
        return CACHE.computeIfAbsent(level, LogLevelConverter::doConvert);
    }

    private static LogLevel doConvert(Level level) {
        return Arrays.stream(LogLevel.values())
            .filter(logLevel -> logLevel.name().equalsIgnoreCase(level.levelStr))
            .findFirst()
            .orElse(LogLevel.UNKNOWN);
    }

}
