package com.bumptech.glide.p086c.p092d.p093a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* renamed from: com.bumptech.glide.c.d.a.k */
final class C31962k {
    private static volatile C31962k aFA;
    private static final File aFx = new File("/proc/self/fd");
    private volatile int aFy;
    private volatile boolean aFz = true;

    static {
        AppMethodBeat.m2504i(92241);
        AppMethodBeat.m2505o(92241);
    }

    /* renamed from: nt */
    static C31962k m51936nt() {
        AppMethodBeat.m2504i(92239);
        if (aFA == null) {
            synchronized (C31962k.class) {
                try {
                    if (aFA == null) {
                        aFA = new C31962k();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(92239);
                    }
                }
            }
        }
        C31962k c31962k = aFA;
        AppMethodBeat.m2505o(92239);
        return c31962k;
    }

    private C31962k() {
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: nu */
    public final synchronized boolean mo52068nu() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(92240);
            int i = this.aFy + 1;
            this.aFy = i;
            if (i >= 50) {
                this.aFy = 0;
                i = aFx.list().length;
                if (i < 700) {
                    z = true;
                }
                this.aFz = z;
                if (!this.aFz && Log.isLoggable("Downsampler", 5)) {
                    new StringBuilder("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ").append(i).append(", limit 700");
                }
            }
            z = this.aFz;
            AppMethodBeat.m2505o(92240);
        }
        return z;
    }
}
