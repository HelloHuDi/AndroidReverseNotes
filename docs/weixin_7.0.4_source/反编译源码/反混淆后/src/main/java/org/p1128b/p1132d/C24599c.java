package org.p1128b.p1132d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: org.b.d.c */
public final class C24599c extends C36642f {
    public Map<String, String> BYN = new HashMap();

    public final /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        AppMethodBeat.m2504i(77286);
        super.addHeader(str, str2);
        AppMethodBeat.m2505o(77286);
    }

    public final /* bridge */ /* synthetic */ C16475e emY() {
        AppMethodBeat.m2504i(77283);
        C16475e emY = super.emY();
        AppMethodBeat.m2505o(77283);
        return emY;
    }

    public final /* bridge */ /* synthetic */ C41174j emZ() {
        AppMethodBeat.m2504i(139055);
        C41174j emZ = super.emZ();
        AppMethodBeat.m2505o(139055);
        return emZ;
    }

    public final /* bridge */ /* synthetic */ String ena() {
        AppMethodBeat.m2504i(77287);
        String ena = super.ena();
        AppMethodBeat.m2505o(77287);
        return ena;
    }

    public final /* bridge */ /* synthetic */ String enb() {
        AppMethodBeat.m2504i(77288);
        String enb = super.enb();
        AppMethodBeat.m2505o(77288);
        return enb;
    }

    public final /* bridge */ /* synthetic */ C41172g enc() {
        AppMethodBeat.m2504i(77289);
        C41172g enc = super.enc();
        AppMethodBeat.m2505o(77289);
        return enc;
    }

    public final /* bridge */ /* synthetic */ C16475e ene() {
        AppMethodBeat.m2504i(77290);
        C16475e ene = super.ene();
        AppMethodBeat.m2505o(77290);
        return ene;
    }

    public final /* bridge */ /* synthetic */ String enf() {
        AppMethodBeat.m2504i(77291);
        String enf = super.enf();
        AppMethodBeat.m2505o(77291);
        return enf;
    }

    public final /* bridge */ /* synthetic */ String getUrl() {
        AppMethodBeat.m2504i(139054);
        String url = super.getUrl();
        AppMethodBeat.m2505o(139054);
        return url;
    }

    /* renamed from: jm */
    public final /* bridge */ /* synthetic */ void mo41406jm(String str, String str2) {
        AppMethodBeat.m2504i(77285);
        super.mo41406jm(str, str2);
        AppMethodBeat.m2505o(77285);
    }

    public C24599c(C41174j c41174j, String str) {
        super(c41174j, str);
        AppMethodBeat.m2504i(77279);
        AppMethodBeat.m2505o(77279);
    }

    /* renamed from: jl */
    public final void mo41405jl(String str, String str2) {
        AppMethodBeat.m2504i(77280);
        Map map = this.BYN;
        if (str.startsWith("oauth_") || str.equals("scope")) {
            map.put(str, str2);
            AppMethodBeat.m2505o(77280);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[]{"scope", "oauth_"}));
        AppMethodBeat.m2505o(77280);
        throw illegalArgumentException;
    }

    public final String toString() {
        AppMethodBeat.m2504i(77281);
        String format = String.format("@OAuthRequest(%s, %s)", new Object[]{super.emZ(), super.getUrl()});
        AppMethodBeat.m2505o(77281);
        return format;
    }
}
