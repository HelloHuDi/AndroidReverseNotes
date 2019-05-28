package com.tencent.p177mm.plugin.bbom;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.firebase.analytics.FirebaseAnalytics.C8740a;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.bbom.C20006k.C200052;
import com.tencent.p177mm.plugin.bbom.C20006k.C200071;
import com.tencent.p177mm.plugin.bbom.C20006k.C200084;
import com.tencent.p177mm.plugin.bbom.C20006k.C200093;
import com.tencent.p177mm.plugin.bbom.p922a.C27498b;
import com.tencent.p177mm.plugin.emoji.model.C38883b;
import com.tencent.p177mm.plugin.favorite.C45940a;
import com.tencent.p177mm.plugin.notification.p477d.C28624a;
import com.tencent.p177mm.plugin.wenote.model.C23180a;

/* renamed from: com.tencent.mm.plugin.bbom.PluginCompatOldStructure */
public class PluginCompatOldStructure extends C7597f implements C27498b {
    public void dependency() {
        AppMethodBeat.m2504i(18320);
        super.dependency();
        AppMethodBeat.m2505o(18320);
    }

    public void execute(C1681g c1681g) {
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(18321);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            new C200071().alone();
            new C200052().alone();
            new C200093().alone();
            new C200084().alone();
            C9204c.m16715b(Scopes.PROFILE, null);
            C9204c.m16715b("setting", null);
            C9204c.m16715b("subapp", null);
            C9204c.m16715b("sandbox", null);
            C9204c.m16715b("nearby", null);
            C9204c.m16715b("brandservice", null);
            C9204c.m16715b("favorite", new C45940a());
            C9204c.m16715b("scanner", null);
            C9204c.m16715b("shake", null);
            C9204c.m16715b("voip", null);
            C9204c.m16715b("radar", null);
            C9204c.m16715b("ext", null);
            C9204c.m16715b("emoji", new C38883b());
            C9204c.m16715b("emoticon", null);
            C9204c.m16715b("account", null);
            C9204c.m16715b("qqmail", null);
            C9204c.m16715b("readerapp", null);
            C9204c.m16715b("talkroom", null);
            C9204c.m16715b("bottle", null);
            C9204c.m16715b("masssend", null);
            C9204c.m16715b("chatroom", null);
            C9204c.m16715b(C8741b.LOCATION, null);
            C9204c.m16715b("clean", null);
            C9204c.m16715b("card", null);
            C9204c.m16715b(C8740a.SEARCH, new C42782f());
            C9204c.m16715b("translate", null);
            C9204c.m16715b("extqlauncher", null);
            C9204c.m16715b("nearlife", null);
            C9204c.m16715b("webview", null);
            C9204c.m16715b("exdevice", null);
            C9204c.m16715b("freewifi", null);
            C9204c.m16715b("pwdgroup", null);
            C9204c.m16715b("gallery", null);
            C9204c.m16715b("label", null);
            C9204c.m16715b("address", null);
            C9204c.m16715b("backup", null);
            C9204c.m16715b("record", null);
            C9204c.m16715b("webwx", null);
            C9204c.m16715b("notification", new C28624a());
            C9204c.m16715b("extaccessories", null);
            C9204c.m16715b("voiceprint", null);
            C9204c.m16715b(PutDataRequest.WEAR_URI_SCHEME, null);
            C9204c.m16715b("auto", null);
            C9204c.m16715b("gai", null);
            C9204c.m16715b("nfc", null);
            C9204c.m16715b("tmassistant", null);
            C9204c.m16715b("nfc_open", null);
            C9204c.m16715b("ipcall", null);
            C9204c.m16715b("voip_cs", null);
            C9204c.m16715b("multitalk", null);
            C9204c.m16715b("wenote", new C23180a());
            C9204c.m16715b("dbbackup", null);
            C9204c.m16715b("soter_mp", null);
            C9204c.m16715b("sl_warpgate", null);
            C9204c.m16715b("aa", null);
            C9204c.m16715b("sport", null);
            C9204c.m16715b("fps_lighter", null);
            C9204c.m16715b("mmsight", null);
            C9204c.m16715b("login_exdevice", null);
        }
        AppMethodBeat.m2505o(18321);
    }
}
