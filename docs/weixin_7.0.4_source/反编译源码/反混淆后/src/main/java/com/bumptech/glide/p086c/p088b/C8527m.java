package com.bumptech.glide.p086c.p088b;

import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.b.m */
final class C8527m implements C0779h {
    private final C0779h aAb;
    private final C31967j aAd;
    private final Class<?> aAf;
    private final Map<Class<?>, C31970m<?>> aAh;
    private int aBR;
    private final Class<?> awY;
    private final Object axb;
    private final int height;
    private final int width;

    C8527m(Object obj, C0779h c0779h, int i, int i2, Map<Class<?>, C31970m<?>> map, Class<?> cls, Class<?> cls2, C31967j c31967j) {
        AppMethodBeat.m2504i(91832);
        this.axb = C8561i.m15217d(obj, "Argument must not be null");
        this.aAb = (C0779h) C8561i.m15217d(c0779h, "Signature must not be null");
        this.width = i;
        this.height = i2;
        this.aAh = (Map) C8561i.m15217d(map, "Argument must not be null");
        this.aAf = (Class) C8561i.m15217d(cls, "Resource class must not be null");
        this.awY = (Class) C8561i.m15217d(cls2, "Transcode class must not be null");
        this.aAd = (C31967j) C8561i.m15217d(c31967j, "Argument must not be null");
        AppMethodBeat.m2505o(91832);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(91833);
        if (obj instanceof C8527m) {
            C8527m c8527m = (C8527m) obj;
            if (this.axb.equals(c8527m.axb) && this.aAb.equals(c8527m.aAb) && this.height == c8527m.height && this.width == c8527m.width && this.aAh.equals(c8527m.aAh) && this.aAf.equals(c8527m.aAf) && this.awY.equals(c8527m.awY) && this.aAd.equals(c8527m.aAd)) {
                AppMethodBeat.m2505o(91833);
                return true;
            }
            AppMethodBeat.m2505o(91833);
            return false;
        }
        AppMethodBeat.m2505o(91833);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(91834);
        if (this.aBR == 0) {
            this.aBR = this.axb.hashCode();
            this.aBR = (this.aBR * 31) + this.aAb.hashCode();
            this.aBR = (this.aBR * 31) + this.width;
            this.aBR = (this.aBR * 31) + this.height;
            this.aBR = (this.aBR * 31) + this.aAh.hashCode();
            this.aBR = (this.aBR * 31) + this.aAf.hashCode();
            this.aBR = (this.aBR * 31) + this.awY.hashCode();
            this.aBR = (this.aBR * 31) + this.aAd.hashCode();
        }
        int i = this.aBR;
        AppMethodBeat.m2505o(91834);
        return i;
    }

    public final String toString() {
        AppMethodBeat.m2504i(91835);
        String str = "EngineKey{model=" + this.axb + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.aAf + ", transcodeClass=" + this.awY + ", signature=" + this.aAb + ", hashCode=" + this.aBR + ", transformations=" + this.aAh + ", options=" + this.aAd + '}';
        AppMethodBeat.m2505o(91835);
        return str;
    }

    /* renamed from: a */
    public final void mo2242a(MessageDigest messageDigest) {
        AppMethodBeat.m2504i(91836);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(91836);
        throw unsupportedOperationException;
    }
}
