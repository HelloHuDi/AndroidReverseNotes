package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.tencent.smtt.sdk.p */
public class C36439p implements UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th) {
        AppMethodBeat.m2504i(64079);
        if (th instanceof SQLiteException) {
            AppMethodBeat.m2505o(64079);
            return;
        }
        RuntimeException runtimeException = new RuntimeException(th);
        AppMethodBeat.m2505o(64079);
        throw runtimeException;
    }
}
