package com.bumptech.glide.c.d.a;

import com.bumptech.glide.c.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class g {
    public static final g aFa = new e();
    public static final g aFb = new d();
    public static final g aFc = new a();
    public static final g aFd = new b();
    public static final g aFe = new c();
    public static final g aFf = new f();
    public static final g aFg = aFb;
    public static final i<g> aFh = i.c("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", aFg);

    static class f extends g {
        f() {
        }

        public final float l(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        public final g nq() {
            return g.QUALITY;
        }
    }

    static class e extends g {
        e() {
        }

        public final float l(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(92219);
            float min = Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
            AppMethodBeat.o(92219);
            return min;
        }

        public final g nq() {
            return g.QUALITY;
        }
    }

    public enum g {
        MEMORY,
        QUALITY;

        static {
            AppMethodBeat.o(92222);
        }
    }

    static class b extends g {
        b() {
        }

        public final float l(int i, int i2, int i3, int i4) {
            int i5 = 1;
            AppMethodBeat.i(92216);
            int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i5 = 0;
            }
            float f = 1.0f / ((float) (max << i5));
            AppMethodBeat.o(92216);
            return f;
        }

        public final g nq() {
            return g.MEMORY;
        }
    }

    static class d extends g {
        d() {
        }

        public final float l(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(92218);
            float max = Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
            AppMethodBeat.o(92218);
            return max;
        }

        public final g nq() {
            return g.QUALITY;
        }
    }

    static class a extends g {
        a() {
        }

        public final float l(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(92215);
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                AppMethodBeat.o(92215);
                return 1.0f;
            }
            float highestOneBit = 1.0f / ((float) Integer.highestOneBit(min));
            AppMethodBeat.o(92215);
            return highestOneBit;
        }

        public final g nq() {
            return g.QUALITY;
        }
    }

    static class c extends g {
        c() {
        }

        public final float l(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(92217);
            float min = Math.min(1.0f, aFa.l(i, i2, i3, i4));
            AppMethodBeat.o(92217);
            return min;
        }

        public final g nq() {
            return g.QUALITY;
        }
    }

    public abstract float l(int i, int i2, int i3, int i4);

    public abstract g nq();
}
