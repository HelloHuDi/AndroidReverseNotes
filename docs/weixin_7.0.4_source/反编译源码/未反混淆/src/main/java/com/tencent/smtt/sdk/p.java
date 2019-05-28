package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread.UncaughtExceptionHandler;

public class p implements UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th) {
        AppMethodBeat.i(64079);
        if (th instanceof SQLiteException) {
            AppMethodBeat.o(64079);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(th);
        AppMethodBeat.o(64079);
        throw runtimeException;
    }
}
