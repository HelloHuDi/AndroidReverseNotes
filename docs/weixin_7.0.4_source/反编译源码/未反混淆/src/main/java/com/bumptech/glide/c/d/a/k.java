package com.bumptech.glide.c.d.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class k {
    private static volatile k aFA;
    private static final File aFx = new File("/proc/self/fd");
    private volatile int aFy;
    private volatile boolean aFz = true;

    static {
        AppMethodBeat.i(92241);
        AppMethodBeat.o(92241);
    }

    static k nt() {
        AppMethodBeat.i(92239);
        if (aFA == null) {
            synchronized (k.class) {
                try {
                    if (aFA == null) {
                        aFA = new k();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(92239);
                    }
                }
            }
        }
        k kVar = aFA;
        AppMethodBeat.o(92239);
        return kVar;
    }

    private k() {
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized boolean nu() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(92240);
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
            AppMethodBeat.o(92240);
        }
        return z;
    }
}
