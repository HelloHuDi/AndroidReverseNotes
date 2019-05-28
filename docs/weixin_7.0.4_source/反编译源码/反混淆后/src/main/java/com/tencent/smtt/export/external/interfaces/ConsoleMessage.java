package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ConsoleMessage {

    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG;

        static {
            AppMethodBeat.m2505o(63800);
        }
    }

    int lineNumber();

    String message();

    MessageLevel messageLevel();

    String sourceId();
}
