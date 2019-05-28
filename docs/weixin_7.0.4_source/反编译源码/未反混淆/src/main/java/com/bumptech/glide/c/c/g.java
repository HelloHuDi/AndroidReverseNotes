package com.bumptech.glide.c.c;

import com.bumptech.glide.c.h;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;
import java.security.MessageDigest;

public class g implements h {
    private int aBR;
    public final h aDZ;
    public final String aEa;
    public String aEb;
    public URL aEc;
    private volatile byte[] aEd;
    public final URL url;

    public g(URL url) {
        this(url, h.aEf);
    }

    public g(String str) {
        this(str, h.aEf);
    }

    private g(URL url, h hVar) {
        AppMethodBeat.i(92068);
        this.url = (URL) i.d(url, "Argument must not be null");
        this.aEa = null;
        this.aDZ = (h) i.d(hVar, "Argument must not be null");
        AppMethodBeat.o(92068);
    }

    private g(String str, h hVar) {
        AppMethodBeat.i(92069);
        this.url = null;
        this.aEa = i.checkNotEmpty(str);
        this.aDZ = (h) i.d(hVar, "Argument must not be null");
        AppMethodBeat.o(92069);
    }

    private String getCacheKey() {
        AppMethodBeat.i(92070);
        String str;
        if (this.aEa != null) {
            str = this.aEa;
            AppMethodBeat.o(92070);
            return str;
        }
        str = ((URL) i.d(this.url, "Argument must not be null")).toString();
        AppMethodBeat.o(92070);
        return str;
    }

    public String toString() {
        AppMethodBeat.i(92071);
        String cacheKey = getCacheKey();
        AppMethodBeat.o(92071);
        return cacheKey;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(92073);
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (getCacheKey().equals(gVar.getCacheKey()) && this.aDZ.equals(gVar.aDZ)) {
                AppMethodBeat.o(92073);
                return true;
            }
            AppMethodBeat.o(92073);
            return false;
        }
        AppMethodBeat.o(92073);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.i(92074);
        if (this.aBR == 0) {
            this.aBR = getCacheKey().hashCode();
            this.aBR = (this.aBR * 31) + this.aDZ.hashCode();
        }
        int i = this.aBR;
        AppMethodBeat.o(92074);
        return i;
    }

    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(92072);
        if (this.aEd == null) {
            this.aEd = getCacheKey().getBytes(azc);
        }
        messageDigest.update(this.aEd);
        AppMethodBeat.o(92072);
    }
}
