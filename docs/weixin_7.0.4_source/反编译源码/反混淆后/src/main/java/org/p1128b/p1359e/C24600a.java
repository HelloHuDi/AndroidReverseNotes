package org.p1128b.p1359e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import org.p1128b.p1129a.p1432a.C41170b;
import org.p1128b.p1131c.C16473e;
import org.p1128b.p1131c.C16474g;
import org.p1128b.p1131c.C41171c;
import org.p1128b.p1132d.C24599c;
import org.p1128b.p1132d.C41172g;
import org.p1128b.p1132d.C41173i;
import org.p1128b.p1132d.C41174j;
import org.p1128b.p1132d.C44625a;
import org.p1128b.p1132d.C44626b;
import org.p1128b.p1132d.C46859h;
import org.p1128b.p1132d.C46860k;
import org.p1128b.p1133f.C31540a;
import org.p1128b.p1133f.C46861d;
import org.p1128b.p1134g.C36643b;

/* renamed from: org.b.e.a */
public final class C24600a implements C31207b {
    private static /* synthetic */ int[] BZl;
    private C44625a BZj;
    private C41170b BZk;

    private static /* synthetic */ int[] enk() {
        AppMethodBeat.m2504i(77299);
        int[] iArr = BZl;
        if (iArr != null) {
            AppMethodBeat.m2505o(77299);
        } else {
            iArr = new int[C46859h.values().length];
            try {
                iArr[C46859h.Header.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[C46859h.QueryString.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            BZl = iArr;
            AppMethodBeat.m2505o(77299);
        }
        return iArr;
    }

    public C24600a(C41170b c41170b, C44625a c44625a) {
        this.BZk = c41170b;
        this.BZj = c44625a;
    }

    public final C41173i enj() {
        AppMethodBeat.m2504i(77292);
        this.BZj.log("obtaining request token from " + this.BZk.emV());
        C24599c c24599c = new C24599c(C41174j.POST, this.BZk.emV());
        this.BZj.log("setting oauth_callback to " + this.BZj.BYG);
        c24599c.mo41405jl("oauth_callback", this.BZj.BYG);
        m38260a(c24599c, C44626b.BYM);
        m38262b(c24599c);
        this.BZj.log("sending request...");
        C41172g enc = c24599c.enc();
        String body = enc.getBody();
        this.BZj.log("response status code: " + enc.code);
        this.BZj.log("response body: ".concat(String.valueOf(body)));
        C41173i awU = new C16474g().awU(body);
        AppMethodBeat.m2505o(77292);
        return awU;
    }

    /* renamed from: a */
    private void m38260a(C24599c c24599c, C41173i c41173i) {
        AppMethodBeat.m2504i(77293);
        c24599c.mo41405jl("oauth_timestamp", new C46861d().enm());
        c24599c.mo41405jl("oauth_nonce", new C46861d().getNonce());
        c24599c.mo41405jl("oauth_consumer_key", this.BZj.BYE);
        c24599c.mo41405jl("oauth_signature_method", new C31540a().enl());
        c24599c.mo41405jl("oauth_version", "1.0");
        if (this.BZj.emX()) {
            c24599c.mo41405jl("scope", this.BZj.scope);
        }
        c24599c.mo41405jl("oauth_signature", m38261b(c24599c, c41173i));
        this.BZj.log("appended additional OAuth parameters: " + C36643b.m60743x(c24599c.BYN));
        AppMethodBeat.m2505o(77293);
    }

    /* renamed from: a */
    public final C41173i mo41408a(C41173i c41173i, C46860k c46860k) {
        AppMethodBeat.m2504i(77294);
        this.BZj.log("obtaining access token from " + this.BZk.emW());
        C24599c c24599c = new C24599c(C41174j.POST, this.BZk.emW());
        c24599c.mo41405jl("oauth_token", c41173i.token);
        c24599c.mo41405jl("oauth_verifier", c46860k.value);
        this.BZj.log("setting token to: " + c41173i + " and verifier to: " + c46860k);
        m38260a(c24599c, c41173i);
        m38262b(c24599c);
        C41173i awU = new C16474g().awU(c24599c.enc().getBody());
        AppMethodBeat.m2505o(77294);
        return awU;
    }

    /* renamed from: a */
    public final void mo41409a(C41173i c41173i, C24599c c24599c) {
        Object obj;
        AppMethodBeat.m2504i(77295);
        this.BZj.log("signing request: " + c24599c.ena());
        if ("".equals(c41173i.token) && "".equals(c41173i.wFn)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            c24599c.mo41405jl("oauth_token", c41173i.token);
        }
        this.BZj.log("setting token to: ".concat(String.valueOf(c41173i)));
        m38260a(c24599c, c41173i);
        m38262b(c24599c);
        AppMethodBeat.m2505o(77295);
    }

    /* renamed from: b */
    public final String mo41410b(C41173i c41173i) {
        AppMethodBeat.m2504i(77296);
        String b = this.BZk.mo65770b(c41173i);
        AppMethodBeat.m2505o(77296);
        return b;
    }

    /* renamed from: b */
    private String m38261b(C24599c c24599c, C41173i c41173i) {
        AppMethodBeat.m2504i(77297);
        this.BZj.log("generating signature...");
        String a = new C41171c().mo65771a(c24599c);
        String aL = new C31540a().mo50990aL(a, this.BZj.BYF, c41173i.wFn);
        this.BZj.log("base string is: ".concat(String.valueOf(a)));
        this.BZj.log("signature is: ".concat(String.valueOf(aL)));
        AppMethodBeat.m2505o(77297);
        return aL;
    }

    /* renamed from: b */
    private void m38262b(C24599c c24599c) {
        AppMethodBeat.m2504i(77298);
        switch (C24600a.enk()[this.BZj.BYI.ordinal()]) {
            case 1:
                this.BZj.log("using Http Header signature");
                c24599c.addHeader("Authorization", new C16473e().mo30361a(c24599c));
                AppMethodBeat.m2505o(77298);
                return;
            case 2:
                this.BZj.log("using Querystring signature");
                for (Entry entry : c24599c.BYN.entrySet()) {
                    c24599c.mo41406jm((String) entry.getKey(), (String) entry.getValue());
                }
                break;
        }
        AppMethodBeat.m2505o(77298);
    }
}
