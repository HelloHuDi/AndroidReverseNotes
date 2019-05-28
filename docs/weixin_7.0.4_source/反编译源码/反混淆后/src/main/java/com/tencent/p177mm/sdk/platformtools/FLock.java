package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.mm.sdk.platformtools.FLock */
public class FLock {
    private File gUc;
    private volatile int xyi;

    private static native void nativeFree(int i);

    private static native int nativeInit(String str);

    private static native int nativeLockRead(int i, boolean z);

    private static native int nativeLockWrite(int i, boolean z);

    private static native int nativeUnlock(int i);

    public FLock(String str) {
        this(new File(str));
        AppMethodBeat.m2504i(115178);
        AppMethodBeat.m2505o(115178);
    }

    public FLock(File file) {
        AppMethodBeat.m2504i(115179);
        this.gUc = null;
        this.xyi = -1;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                IllegalStateException illegalStateException = new IllegalStateException(e);
                AppMethodBeat.m2505o(115179);
                throw illegalStateException;
            }
        } else if (!file.isFile()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("target is not a file.");
            AppMethodBeat.m2505o(115179);
            throw illegalArgumentException;
        }
        this.gUc = file;
        AppMethodBeat.m2505o(115179);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(115180);
        super.finalize();
        unlock();
        AppMethodBeat.m2505o(115180);
    }

    private synchronized int init() {
        int i;
        AppMethodBeat.m2504i(115181);
        if (!this.gUc.exists()) {
            try {
                this.gUc.createNewFile();
            } catch (IOException e) {
            }
            this.xyi = -1;
        }
        if (this.xyi == -1) {
            this.xyi = FLock.nativeInit(this.gUc.getAbsolutePath());
        }
        i = this.xyi;
        AppMethodBeat.m2505o(115181);
        return i;
    }

    private synchronized void free() {
        AppMethodBeat.m2504i(115182);
        if (this.xyi != -1) {
            FLock.nativeFree(this.xyi);
            this.xyi = -1;
        }
        AppMethodBeat.m2505o(115182);
    }

    public final synchronized void lockRead() {
        AppMethodBeat.m2504i(115183);
        int init = init();
        while (true) {
            IllegalStateException illegalStateException;
            switch (FLock.nativeLockRead(init, true)) {
                case 4:
                case 11:
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                    }
                case 9:
                    illegalStateException = new IllegalStateException("bad file descriptor.");
                    AppMethodBeat.m2505o(115183);
                    throw illegalStateException;
                case 22:
                    illegalStateException = new IllegalStateException("bad operation.");
                    AppMethodBeat.m2505o(115183);
                    throw illegalStateException;
                case 46:
                    illegalStateException = new IllegalStateException("kernel lock spaces ran out.");
                    AppMethodBeat.m2505o(115183);
                    throw illegalStateException;
                default:
                    AppMethodBeat.m2505o(115183);
            }
        }
    }

    public final synchronized boolean dob() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(115184);
            int init = init();
            while (true) {
                IllegalStateException illegalStateException;
                switch (FLock.nativeLockWrite(init, false)) {
                    case 4:
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e) {
                        }
                    case 9:
                        illegalStateException = new IllegalStateException("bad file descriptor.");
                        AppMethodBeat.m2505o(115184);
                        throw illegalStateException;
                    case 11:
                        AppMethodBeat.m2505o(115184);
                        break;
                    case 22:
                        illegalStateException = new IllegalStateException("bad operation.");
                        AppMethodBeat.m2505o(115184);
                        throw illegalStateException;
                    case 46:
                        illegalStateException = new IllegalStateException("kernel lock spaces ran out.");
                        AppMethodBeat.m2505o(115184);
                        throw illegalStateException;
                    default:
                        z = true;
                        AppMethodBeat.m2505o(115184);
                        break;
                }
            }
        }
        return z;
    }

    public final synchronized void doc() {
        AppMethodBeat.m2504i(115185);
        int init = init();
        while (true) {
            IllegalStateException illegalStateException;
            switch (FLock.nativeLockWrite(init, true)) {
                case 4:
                case 11:
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                    }
                case 9:
                    illegalStateException = new IllegalStateException("bad file descriptor.");
                    AppMethodBeat.m2505o(115185);
                    throw illegalStateException;
                case 22:
                    illegalStateException = new IllegalStateException("bad operation.");
                    AppMethodBeat.m2505o(115185);
                    throw illegalStateException;
                case 46:
                    illegalStateException = new IllegalStateException("kernel lock spaces ran out.");
                    AppMethodBeat.m2505o(115185);
                    throw illegalStateException;
                default:
                    AppMethodBeat.m2505o(115185);
            }
        }
    }

    public final synchronized void unlock() {
        AppMethodBeat.m2504i(115186);
        if (this.xyi == -1) {
            AppMethodBeat.m2505o(115186);
        } else {
            try {
                int nativeUnlock = FLock.nativeUnlock(this.xyi);
                switch (nativeUnlock) {
                    case 0:
                        free();
                        AppMethodBeat.m2505o(115186);
                        break;
                    case 9:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(this.xyi + " is not a valid fd.");
                        AppMethodBeat.m2505o(115186);
                        throw illegalArgumentException;
                    case 22:
                        IllegalStateException illegalStateException = new IllegalStateException("bad operation.");
                        AppMethodBeat.m2505o(115186);
                        throw illegalStateException;
                    default:
                        IllegalStateException illegalStateException2 = new IllegalStateException("other err: ".concat(String.valueOf(nativeUnlock)));
                        AppMethodBeat.m2505o(115186);
                        throw illegalStateException2;
                }
            } catch (Throwable th) {
                free();
                AppMethodBeat.m2505o(115186);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(115187);
        try {
            System.loadLibrary("wechatcommon");
            AppMethodBeat.m2505o(115187);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.FLock", th, "fail to load so.", new Object[0]);
            AppMethodBeat.m2505o(115187);
        }
    }
}
