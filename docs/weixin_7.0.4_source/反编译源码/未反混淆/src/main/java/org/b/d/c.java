package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c extends f {
    public Map<String, String> BYN = new HashMap();

    public final /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        AppMethodBeat.i(77286);
        super.addHeader(str, str2);
        AppMethodBeat.o(77286);
    }

    public final /* bridge */ /* synthetic */ e emY() {
        AppMethodBeat.i(77283);
        e emY = super.emY();
        AppMethodBeat.o(77283);
        return emY;
    }

    public final /* bridge */ /* synthetic */ j emZ() {
        AppMethodBeat.i(139055);
        j emZ = super.emZ();
        AppMethodBeat.o(139055);
        return emZ;
    }

    public final /* bridge */ /* synthetic */ String ena() {
        AppMethodBeat.i(77287);
        String ena = super.ena();
        AppMethodBeat.o(77287);
        return ena;
    }

    public final /* bridge */ /* synthetic */ String enb() {
        AppMethodBeat.i(77288);
        String enb = super.enb();
        AppMethodBeat.o(77288);
        return enb;
    }

    public final /* bridge */ /* synthetic */ g enc() {
        AppMethodBeat.i(77289);
        g enc = super.enc();
        AppMethodBeat.o(77289);
        return enc;
    }

    public final /* bridge */ /* synthetic */ e ene() {
        AppMethodBeat.i(77290);
        e ene = super.ene();
        AppMethodBeat.o(77290);
        return ene;
    }

    public final /* bridge */ /* synthetic */ String enf() {
        AppMethodBeat.i(77291);
        String enf = super.enf();
        AppMethodBeat.o(77291);
        return enf;
    }

    public final /* bridge */ /* synthetic */ String getUrl() {
        AppMethodBeat.i(139054);
        String url = super.getUrl();
        AppMethodBeat.o(139054);
        return url;
    }

    public final /* bridge */ /* synthetic */ void jm(String str, String str2) {
        AppMethodBeat.i(77285);
        super.jm(str, str2);
        AppMethodBeat.o(77285);
    }

    public c(j jVar, String str) {
        super(jVar, str);
        AppMethodBeat.i(77279);
        AppMethodBeat.o(77279);
    }

    public final void jl(String str, String str2) {
        AppMethodBeat.i(77280);
        Map map = this.BYN;
        if (str.startsWith("oauth_") || str.equals("scope")) {
            map.put(str, str2);
            AppMethodBeat.o(77280);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[]{"scope", "oauth_"}));
        AppMethodBeat.o(77280);
        throw illegalArgumentException;
    }

    public final String toString() {
        AppMethodBeat.i(77281);
        String format = String.format("@OAuthRequest(%s, %s)", new Object[]{super.emZ(), super.getUrl()});
        AppMethodBeat.o(77281);
        return format;
    }
}
