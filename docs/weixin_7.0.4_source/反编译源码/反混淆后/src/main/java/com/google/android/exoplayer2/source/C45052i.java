package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C37253f;
import com.google.android.exoplayer2.C45054w;
import com.google.android.exoplayer2.p110h.C32053b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

/* renamed from: com.google.android.exoplayer2.source.i */
public interface C45052i {

    /* renamed from: com.google.android.exoplayer2.source.i$a */
    public interface C37281a {
        /* renamed from: a */
        void mo42822a(C45054w c45054w, Object obj);
    }

    /* renamed from: com.google.android.exoplayer2.source.i$b */
    public static final class C45051b {
        public static final C45051b bhp = new C45051b(-1, -1, -1);
        public final int bhq;
        public final int bhr;
        public final int bhs;

        static {
            AppMethodBeat.m2504i(95514);
            AppMethodBeat.m2505o(95514);
        }

        public C45051b(int i) {
            this(i, -1, -1);
        }

        public C45051b(int i, int i2, int i3) {
            this.bhq = i;
            this.bhr = i2;
            this.bhs = i3;
        }

        /* renamed from: em */
        public final C45051b mo72567em(int i) {
            AppMethodBeat.m2504i(95512);
            if (this.bhq == i) {
                AppMethodBeat.m2505o(95512);
                return this;
            }
            C45051b c45051b = new C45051b(i, this.bhr, this.bhs);
            AppMethodBeat.m2505o(95512);
            return c45051b;
        }

        /* renamed from: sh */
        public final boolean mo72570sh() {
            return this.bhr != -1;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(95513);
            if (this == obj) {
                AppMethodBeat.m2505o(95513);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.m2505o(95513);
                return false;
            } else {
                C45051b c45051b = (C45051b) obj;
                if (this.bhq == c45051b.bhq && this.bhr == c45051b.bhr && this.bhs == c45051b.bhs) {
                    AppMethodBeat.m2505o(95513);
                    return true;
                }
                AppMethodBeat.m2505o(95513);
                return false;
            }
        }

        public final int hashCode() {
            return ((((this.bhq + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.bhr) * 31) + this.bhs;
        }
    }

    /* renamed from: a */
    C37279h mo42820a(C45051b c45051b, C32053b c32053b);

    /* renamed from: a */
    void mo42821a(C37253f c37253f, C37281a c37281a);

    /* renamed from: b */
    void mo42823b(C37279h c37279h);

    /* renamed from: rX */
    void mo42824rX();

    /* renamed from: rY */
    void mo42825rY();
}
