package com.bumptech.glide.c.b;

import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.h;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.m;
import com.bumptech.glide.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class w implements h {
    private static final f<Class<?>, byte[]> aCi = new f(50);
    private final h aAb;
    private final j aAd;
    private final Class<?> aCj;
    private final m<?> aCk;
    private final b awk;
    private final h azW;
    private final int height;
    private final int width;

    static {
        AppMethodBeat.i(91886);
        AppMethodBeat.o(91886);
    }

    w(b bVar, h hVar, h hVar2, int i, int i2, m<?> mVar, Class<?> cls, j jVar) {
        this.awk = bVar;
        this.azW = hVar;
        this.aAb = hVar2;
        this.width = i;
        this.height = i2;
        this.aCk = mVar;
        this.aCj = cls;
        this.aAd = jVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(91882);
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.height == wVar.height && this.width == wVar.width && com.bumptech.glide.h.j.h(this.aCk, wVar.aCk) && this.aCj.equals(wVar.aCj) && this.azW.equals(wVar.azW) && this.aAb.equals(wVar.aAb) && this.aAd.equals(wVar.aAd)) {
                AppMethodBeat.o(91882);
                return true;
            }
            AppMethodBeat.o(91882);
            return false;
        }
        AppMethodBeat.o(91882);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(91883);
        int hashCode = (((((this.azW.hashCode() * 31) + this.aAb.hashCode()) * 31) + this.width) * 31) + this.height;
        if (this.aCk != null) {
            hashCode = (hashCode * 31) + this.aCk.hashCode();
        }
        hashCode = (((hashCode * 31) + this.aCj.hashCode()) * 31) + this.aAd.hashCode();
        AppMethodBeat.o(91883);
        return hashCode;
    }

    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(91884);
        byte[] bArr = (byte[]) this.awk.o(byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.width).putInt(this.height).array();
        this.aAb.a(messageDigest);
        this.azW.a(messageDigest);
        messageDigest.update(bArr);
        if (this.aCk != null) {
            this.aCk.a(messageDigest);
        }
        this.aAd.a(messageDigest);
        byte[] bArr2 = (byte[]) aCi.get(this.aCj);
        if (bArr2 == null) {
            bArr2 = this.aCj.getName().getBytes(azc);
            aCi.put(this.aCj, bArr2);
        }
        messageDigest.update(bArr2);
        this.awk.put(bArr);
        AppMethodBeat.o(91884);
    }

    public final String toString() {
        AppMethodBeat.i(91885);
        String str = "ResourceCacheKey{sourceKey=" + this.azW + ", signature=" + this.aAb + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.aCj + ", transformation='" + this.aCk + '\'' + ", options=" + this.aAd + '}';
        AppMethodBeat.o(91885);
        return str;
    }
}
