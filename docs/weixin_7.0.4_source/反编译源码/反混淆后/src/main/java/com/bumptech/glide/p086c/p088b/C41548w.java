package com.bumptech.glide.p086c.p088b;

import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p095h.C0780f;
import com.bumptech.glide.p095h.C45002j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.c.b.w */
final class C41548w implements C0779h {
    private static final C0780f<Class<?>, byte[]> aCi = new C0780f(50);
    private final C0779h aAb;
    private final C31967j aAd;
    private final Class<?> aCj;
    private final C31970m<?> aCk;
    private final C8515b awk;
    private final C0779h azW;
    private final int height;
    private final int width;

    static {
        AppMethodBeat.m2504i(91886);
        AppMethodBeat.m2505o(91886);
    }

    C41548w(C8515b c8515b, C0779h c0779h, C0779h c0779h2, int i, int i2, C31970m<?> c31970m, Class<?> cls, C31967j c31967j) {
        this.awk = c8515b;
        this.azW = c0779h;
        this.aAb = c0779h2;
        this.width = i;
        this.height = i2;
        this.aCk = c31970m;
        this.aCj = cls;
        this.aAd = c31967j;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(91882);
        if (obj instanceof C41548w) {
            C41548w c41548w = (C41548w) obj;
            if (this.height == c41548w.height && this.width == c41548w.width && C45002j.m82421h(this.aCk, c41548w.aCk) && this.aCj.equals(c41548w.aCj) && this.azW.equals(c41548w.azW) && this.aAb.equals(c41548w.aAb) && this.aAd.equals(c41548w.aAd)) {
                AppMethodBeat.m2505o(91882);
                return true;
            }
            AppMethodBeat.m2505o(91882);
            return false;
        }
        AppMethodBeat.m2505o(91882);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(91883);
        int hashCode = (((((this.azW.hashCode() * 31) + this.aAb.hashCode()) * 31) + this.width) * 31) + this.height;
        if (this.aCk != null) {
            hashCode = (hashCode * 31) + this.aCk.hashCode();
        }
        hashCode = (((hashCode * 31) + this.aCj.hashCode()) * 31) + this.aAd.hashCode();
        AppMethodBeat.m2505o(91883);
        return hashCode;
    }

    /* renamed from: a */
    public final void mo2242a(MessageDigest messageDigest) {
        AppMethodBeat.m2504i(91884);
        byte[] bArr = (byte[]) this.awk.mo18610o(byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.width).putInt(this.height).array();
        this.aAb.mo2242a(messageDigest);
        this.azW.mo2242a(messageDigest);
        messageDigest.update(bArr);
        if (this.aCk != null) {
            this.aCk.mo2242a(messageDigest);
        }
        this.aAd.mo2242a(messageDigest);
        byte[] bArr2 = (byte[]) aCi.get(this.aCj);
        if (bArr2 == null) {
            bArr2 = this.aCj.getName().getBytes(azc);
            aCi.put(this.aCj, bArr2);
        }
        messageDigest.update(bArr2);
        this.awk.put(bArr);
        AppMethodBeat.m2505o(91884);
    }

    public final String toString() {
        AppMethodBeat.m2504i(91885);
        String str = "ResourceCacheKey{sourceKey=" + this.azW + ", signature=" + this.aAb + ", width=" + this.width + ", height=" + this.height + ", decodedResourceClass=" + this.aCj + ", transformation='" + this.aCk + '\'' + ", options=" + this.aAd + '}';
        AppMethodBeat.m2505o(91885);
        return str;
    }
}
