package com.bumptech.glide.p086c.p092d.p093a;

import com.bumptech.glide.p086c.C17546i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.a.g */
public abstract class C31955g {
    public static final C31955g aFa = new C25441e();
    public static final C31955g aFb = new C31957d();
    public static final C31955g aFc = new C31958a();
    public static final C31955g aFd = new C31956b();
    public static final C31955g aFe = new C31959c();
    public static final C31955g aFf = new C17540f();
    public static final C31955g aFg = aFb;
    public static final C17546i<C31955g> aFh = C17546i.m27397c("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", aFg);

    /* renamed from: com.bumptech.glide.c.d.a.g$f */
    static class C17540f extends C31955g {
        C17540f() {
        }

        /* renamed from: l */
        public final float mo31963l(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        /* renamed from: nq */
        public final C25442g mo31964nq() {
            return C25442g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.g$e */
    static class C25441e extends C31955g {
        C25441e() {
        }

        /* renamed from: l */
        public final float mo31963l(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(92219);
            float min = Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
            AppMethodBeat.m2505o(92219);
            return min;
        }

        /* renamed from: nq */
        public final C25442g mo31964nq() {
            return C25442g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.g$g */
    public enum C25442g {
        MEMORY,
        QUALITY;

        static {
            AppMethodBeat.m2505o(92222);
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.g$b */
    static class C31956b extends C31955g {
        C31956b() {
        }

        /* renamed from: l */
        public final float mo31963l(int i, int i2, int i3, int i4) {
            int i5 = 1;
            AppMethodBeat.m2504i(92216);
            int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i5 = 0;
            }
            float f = 1.0f / ((float) (max << i5));
            AppMethodBeat.m2505o(92216);
            return f;
        }

        /* renamed from: nq */
        public final C25442g mo31964nq() {
            return C25442g.MEMORY;
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.g$d */
    static class C31957d extends C31955g {
        C31957d() {
        }

        /* renamed from: l */
        public final float mo31963l(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(92218);
            float max = Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
            AppMethodBeat.m2505o(92218);
            return max;
        }

        /* renamed from: nq */
        public final C25442g mo31964nq() {
            return C25442g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.g$a */
    static class C31958a extends C31955g {
        C31958a() {
        }

        /* renamed from: l */
        public final float mo31963l(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(92215);
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                AppMethodBeat.m2505o(92215);
                return 1.0f;
            }
            float highestOneBit = 1.0f / ((float) Integer.highestOneBit(min));
            AppMethodBeat.m2505o(92215);
            return highestOneBit;
        }

        /* renamed from: nq */
        public final C25442g mo31964nq() {
            return C25442g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.c.d.a.g$c */
    static class C31959c extends C31955g {
        C31959c() {
        }

        /* renamed from: l */
        public final float mo31963l(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(92217);
            float min = Math.min(1.0f, aFa.mo31963l(i, i2, i3, i4));
            AppMethodBeat.m2505o(92217);
            return min;
        }

        /* renamed from: nq */
        public final C25442g mo31964nq() {
            return C25442g.QUALITY;
        }
    }

    /* renamed from: l */
    public abstract float mo31963l(int i, int i2, int i3, int i4);

    /* renamed from: nq */
    public abstract C25442g mo31964nq();
}
