package com.bumptech.glide.p086c.p090c;

import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.c.c.g */
public class C31950g implements C0779h {
    private int aBR;
    public final C0762h aDZ;
    public final String aEa;
    public String aEb;
    public URL aEc;
    private volatile byte[] aEd;
    public final URL url;

    public C31950g(URL url) {
        this(url, C0762h.aEf);
    }

    public C31950g(String str) {
        this(str, C0762h.aEf);
    }

    private C31950g(URL url, C0762h c0762h) {
        AppMethodBeat.m2504i(92068);
        this.url = (URL) C8561i.m15217d(url, "Argument must not be null");
        this.aEa = null;
        this.aDZ = (C0762h) C8561i.m15217d(c0762h, "Argument must not be null");
        AppMethodBeat.m2505o(92068);
    }

    private C31950g(String str, C0762h c0762h) {
        AppMethodBeat.m2504i(92069);
        this.url = null;
        this.aEa = C8561i.checkNotEmpty(str);
        this.aDZ = (C0762h) C8561i.m15217d(c0762h, "Argument must not be null");
        AppMethodBeat.m2505o(92069);
    }

    private String getCacheKey() {
        AppMethodBeat.m2504i(92070);
        String str;
        if (this.aEa != null) {
            str = this.aEa;
            AppMethodBeat.m2505o(92070);
            return str;
        }
        str = ((URL) C8561i.m15217d(this.url, "Argument must not be null")).toString();
        AppMethodBeat.m2505o(92070);
        return str;
    }

    public String toString() {
        AppMethodBeat.m2504i(92071);
        String cacheKey = getCacheKey();
        AppMethodBeat.m2505o(92071);
        return cacheKey;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(92073);
        if (obj instanceof C31950g) {
            C31950g c31950g = (C31950g) obj;
            if (getCacheKey().equals(c31950g.getCacheKey()) && this.aDZ.equals(c31950g.aDZ)) {
                AppMethodBeat.m2505o(92073);
                return true;
            }
            AppMethodBeat.m2505o(92073);
            return false;
        }
        AppMethodBeat.m2505o(92073);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(92074);
        if (this.aBR == 0) {
            this.aBR = getCacheKey().hashCode();
            this.aBR = (this.aBR * 31) + this.aDZ.hashCode();
        }
        int i = this.aBR;
        AppMethodBeat.m2505o(92074);
        return i;
    }

    /* renamed from: a */
    public final void mo2242a(MessageDigest messageDigest) {
        AppMethodBeat.m2504i(92072);
        if (this.aEd == null) {
            this.aEd = getCacheKey().getBytes(azc);
        }
        messageDigest.update(this.aEd);
        AppMethodBeat.m2505o(92072);
    }
}
