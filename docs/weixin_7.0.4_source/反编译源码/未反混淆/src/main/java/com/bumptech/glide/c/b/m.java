package com.bumptech.glide.c.b;

import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.util.Map;

final class m implements h {
    private final h aAb;
    private final j aAd;
    private final Class<?> aAf;
    private final Map<Class<?>, com.bumptech.glide.c.m<?>> aAh;
    private int aBR;
    private final Class<?> awY;
    private final Object axb;
    private final int height;
    private final int width;

    m(Object obj, h hVar, int i, int i2, Map<Class<?>, com.bumptech.glide.c.m<?>> map, Class<?> cls, Class<?> cls2, j jVar) {
        AppMethodBeat.i(91832);
        this.axb = i.d(obj, "Argument must not be null");
        this.aAb = (h) i.d(hVar, "Signature must not be null");
        this.width = i;
        this.height = i2;
        this.aAh = (Map) i.d(map, "Argument must not be null");
        this.aAf = (Class) i.d(cls, "Resource class must not be null");
        this.awY = (Class) i.d(cls2, "Transcode class must not be null");
        this.aAd = (j) i.d(jVar, "Argument must not be null");
        AppMethodBeat.o(91832);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(91833);
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.axb.equals(mVar.axb) && this.aAb.equals(mVar.aAb) && this.height == mVar.height && this.width == mVar.width && this.aAh.equals(mVar.aAh) && this.aAf.equals(mVar.aAf) && this.awY.equals(mVar.awY) && this.aAd.equals(mVar.aAd)) {
                AppMethodBeat.o(91833);
                return true;
            }
            AppMethodBeat.o(91833);
            return false;
        }
        AppMethodBeat.o(91833);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(91834);
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
        AppMethodBeat.o(91834);
        return i;
    }

    public final String toString() {
        AppMethodBeat.i(91835);
        String str = "EngineKey{model=" + this.axb + ", width=" + this.width + ", height=" + this.height + ", resourceClass=" + this.aAf + ", transcodeClass=" + this.awY + ", signature=" + this.aAb + ", hashCode=" + this.aBR + ", transformations=" + this.aAh + ", options=" + this.aAd + '}';
        AppMethodBeat.o(91835);
        return str;
    }

    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(91836);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(91836);
        throw unsupportedOperationException;
    }
}
