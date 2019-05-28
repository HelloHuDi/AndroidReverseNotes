package org.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import org.b.a.a.b;
import org.b.c.e;
import org.b.d.c;
import org.b.d.g;
import org.b.d.h;
import org.b.d.i;
import org.b.d.j;
import org.b.d.k;
import org.b.f.d;

public final class a implements b {
    private static /* synthetic */ int[] BZl;
    private org.b.d.a BZj;
    private b BZk;

    private static /* synthetic */ int[] enk() {
        AppMethodBeat.i(77299);
        int[] iArr = BZl;
        if (iArr != null) {
            AppMethodBeat.o(77299);
        } else {
            iArr = new int[h.values().length];
            try {
                iArr[h.Header.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[h.QueryString.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            BZl = iArr;
            AppMethodBeat.o(77299);
        }
        return iArr;
    }

    public a(b bVar, org.b.d.a aVar) {
        this.BZk = bVar;
        this.BZj = aVar;
    }

    public final i enj() {
        AppMethodBeat.i(77292);
        this.BZj.log("obtaining request token from " + this.BZk.emV());
        c cVar = new c(j.POST, this.BZk.emV());
        this.BZj.log("setting oauth_callback to " + this.BZj.BYG);
        cVar.jl("oauth_callback", this.BZj.BYG);
        a(cVar, org.b.d.b.BYM);
        b(cVar);
        this.BZj.log("sending request...");
        g enc = cVar.enc();
        String body = enc.getBody();
        this.BZj.log("response status code: " + enc.code);
        this.BZj.log("response body: ".concat(String.valueOf(body)));
        i awU = new org.b.c.g().awU(body);
        AppMethodBeat.o(77292);
        return awU;
    }

    private void a(c cVar, i iVar) {
        AppMethodBeat.i(77293);
        cVar.jl("oauth_timestamp", new d().enm());
        cVar.jl("oauth_nonce", new d().getNonce());
        cVar.jl("oauth_consumer_key", this.BZj.BYE);
        cVar.jl("oauth_signature_method", new org.b.f.a().enl());
        cVar.jl("oauth_version", "1.0");
        if (this.BZj.emX()) {
            cVar.jl("scope", this.BZj.scope);
        }
        cVar.jl("oauth_signature", b(cVar, iVar));
        this.BZj.log("appended additional OAuth parameters: " + org.b.g.b.x(cVar.BYN));
        AppMethodBeat.o(77293);
    }

    public final i a(i iVar, k kVar) {
        AppMethodBeat.i(77294);
        this.BZj.log("obtaining access token from " + this.BZk.emW());
        c cVar = new c(j.POST, this.BZk.emW());
        cVar.jl("oauth_token", iVar.token);
        cVar.jl("oauth_verifier", kVar.value);
        this.BZj.log("setting token to: " + iVar + " and verifier to: " + kVar);
        a(cVar, iVar);
        b(cVar);
        i awU = new org.b.c.g().awU(cVar.enc().getBody());
        AppMethodBeat.o(77294);
        return awU;
    }

    public final void a(i iVar, c cVar) {
        Object obj;
        AppMethodBeat.i(77295);
        this.BZj.log("signing request: " + cVar.ena());
        if ("".equals(iVar.token) && "".equals(iVar.wFn)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            cVar.jl("oauth_token", iVar.token);
        }
        this.BZj.log("setting token to: ".concat(String.valueOf(iVar)));
        a(cVar, iVar);
        b(cVar);
        AppMethodBeat.o(77295);
    }

    public final String b(i iVar) {
        AppMethodBeat.i(77296);
        String b = this.BZk.b(iVar);
        AppMethodBeat.o(77296);
        return b;
    }

    private String b(c cVar, i iVar) {
        AppMethodBeat.i(77297);
        this.BZj.log("generating signature...");
        String a = new org.b.c.c().a(cVar);
        String aL = new org.b.f.a().aL(a, this.BZj.BYF, iVar.wFn);
        this.BZj.log("base string is: ".concat(String.valueOf(a)));
        this.BZj.log("signature is: ".concat(String.valueOf(aL)));
        AppMethodBeat.o(77297);
        return aL;
    }

    private void b(c cVar) {
        AppMethodBeat.i(77298);
        switch (enk()[this.BZj.BYI.ordinal()]) {
            case 1:
                this.BZj.log("using Http Header signature");
                cVar.addHeader("Authorization", new e().a(cVar));
                AppMethodBeat.o(77298);
                return;
            case 2:
                this.BZj.log("using Querystring signature");
                for (Entry entry : cVar.BYN.entrySet()) {
                    cVar.jm((String) entry.getKey(), (String) entry.getValue());
                }
                break;
        }
        AppMethodBeat.o(77298);
    }
}
