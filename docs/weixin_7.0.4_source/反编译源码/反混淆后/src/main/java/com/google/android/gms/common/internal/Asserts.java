package com.google.android.gms.common.internal;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Asserts {
    private Asserts() {
        AppMethodBeat.m2504i(89569);
        AssertionError assertionError = new AssertionError("Uninstantiable");
        AppMethodBeat.m2505o(89569);
        throw assertionError;
    }

    public static void checkMainThread(String str) {
        AppMethodBeat.m2504i(89567);
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            new StringBuilder((String.valueOf(valueOf).length() + 57) + String.valueOf(valueOf2).length()).append("checkMainThread: current thread ").append(valueOf).append(" IS NOT the main thread ").append(valueOf2).append("!");
            IllegalStateException illegalStateException = new IllegalStateException(str);
            AppMethodBeat.m2505o(89567);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(89567);
    }

    public static void checkNotMainThread(String str) {
        AppMethodBeat.m2504i(89568);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            new StringBuilder((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length()).append("checkNotMainThread: current thread ").append(valueOf).append(" IS the main thread ").append(valueOf2).append("!");
            IllegalStateException illegalStateException = new IllegalStateException(str);
            AppMethodBeat.m2505o(89568);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(89568);
    }

    public static void checkNotNull(Object obj) {
        AppMethodBeat.m2504i(89561);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("null reference");
            AppMethodBeat.m2505o(89561);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89561);
    }

    public static void checkNotNull(Object obj, Object obj2) {
        AppMethodBeat.m2504i(89562);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj2));
            AppMethodBeat.m2505o(89562);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89562);
    }

    public static void checkNull(Object obj) {
        AppMethodBeat.m2504i(89560);
        if (obj != null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("non-null reference");
            AppMethodBeat.m2505o(89560);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(89560);
    }

    public static void checkState(boolean z) {
        AppMethodBeat.m2504i(89563);
        if (z) {
            AppMethodBeat.m2505o(89563);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.m2505o(89563);
        throw illegalStateException;
    }

    public static void checkState(boolean z, Object obj) {
        AppMethodBeat.m2504i(89564);
        if (z) {
            AppMethodBeat.m2505o(89564);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(obj));
        AppMethodBeat.m2505o(89564);
        throw illegalStateException;
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        AppMethodBeat.m2504i(89565);
        if (z) {
            AppMethodBeat.m2505o(89565);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.format(str, objArr));
        AppMethodBeat.m2505o(89565);
        throw illegalStateException;
    }

    public static void fail(Object obj) {
        AppMethodBeat.m2504i(89566);
        IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(obj));
        AppMethodBeat.m2505o(89566);
        throw illegalStateException;
    }
}
