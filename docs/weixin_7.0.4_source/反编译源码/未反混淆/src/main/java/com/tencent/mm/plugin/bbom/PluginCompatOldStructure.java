package com.tencent.mm.plugin.bbom;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.bp.c;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.q;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.plugin.bbom.a.b;
import com.tencent.mm.pluginsdk.model.app.am;

public class PluginCompatOldStructure extends f implements b {
    public void dependency() {
        AppMethodBeat.i(18320);
        super.dependency();
        AppMethodBeat.o(18320);
    }

    public void execute(g gVar) {
    }

    public void configure(g gVar) {
        AppMethodBeat.i(18321);
        if (((h) com.tencent.mm.kernel.g.RM().Rn()).SG()) {
            new a() {
                public final void execute(g gVar) {
                    AppMethodBeat.i(18262);
                    q qVar = new q(d.class);
                    AppMethodBeat.o(18262);
                }
            }.alone();
            new a() {
                public final void execute(g gVar) {
                    AppMethodBeat.i(18263);
                    q qVar = new q(am.class);
                    AppMethodBeat.o(18263);
                }
            }.alone();
            new a() {
                public final void execute(g gVar) {
                    AppMethodBeat.i(18264);
                    e eVar = new e();
                    AppMethodBeat.o(18264);
                }
            }.alone();
            new a() {
                public final void execute(g gVar) {
                    AppMethodBeat.i(18265);
                    q qVar = new q(n.class);
                    AppMethodBeat.o(18265);
                }
            }.alone();
            c.b(Scopes.PROFILE, null);
            c.b("setting", null);
            c.b("subapp", null);
            c.b("sandbox", null);
            c.b("nearby", null);
            c.b("brandservice", null);
            c.b("favorite", new com.tencent.mm.plugin.favorite.a());
            c.b("scanner", null);
            c.b("shake", null);
            c.b("voip", null);
            c.b("radar", null);
            c.b("ext", null);
            c.b("emoji", new com.tencent.mm.plugin.emoji.model.b());
            c.b("emoticon", null);
            c.b("account", null);
            c.b("qqmail", null);
            c.b("readerapp", null);
            c.b("talkroom", null);
            c.b("bottle", null);
            c.b("masssend", null);
            c.b("chatroom", null);
            c.b(FirebaseAnalytics.b.LOCATION, null);
            c.b("clean", null);
            c.b("card", null);
            c.b(FirebaseAnalytics.a.SEARCH, new f());
            c.b("translate", null);
            c.b("extqlauncher", null);
            c.b("nearlife", null);
            c.b("webview", null);
            c.b("exdevice", null);
            c.b("freewifi", null);
            c.b("pwdgroup", null);
            c.b("gallery", null);
            c.b("label", null);
            c.b("address", null);
            c.b("backup", null);
            c.b("record", null);
            c.b("webwx", null);
            c.b("notification", new com.tencent.mm.plugin.notification.d.a());
            c.b("extaccessories", null);
            c.b("voiceprint", null);
            c.b(PutDataRequest.WEAR_URI_SCHEME, null);
            c.b("auto", null);
            c.b("gai", null);
            c.b("nfc", null);
            c.b("tmassistant", null);
            c.b("nfc_open", null);
            c.b("ipcall", null);
            c.b("voip_cs", null);
            c.b("multitalk", null);
            c.b("wenote", new com.tencent.mm.plugin.wenote.model.a());
            c.b("dbbackup", null);
            c.b("soter_mp", null);
            c.b("sl_warpgate", null);
            c.b("aa", null);
            c.b("sport", null);
            c.b("fps_lighter", null);
            c.b("mmsight", null);
            c.b("login_exdevice", null);
        }
        AppMethodBeat.o(18321);
    }
}
