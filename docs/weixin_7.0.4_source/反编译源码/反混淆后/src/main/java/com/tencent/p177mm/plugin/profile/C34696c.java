package com.tencent.p177mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.profile.p1287b.C21453e;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1289a.C21496a;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1499d.C34740a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.profile.c */
public final class C34696c implements C1816at {
    private static HashMap<Integer, C1366d> eaA = new HashMap();
    private volatile C34740a pkw;
    private C3473o pkx = new C214542();

    /* renamed from: com.tencent.mm.plugin.profile.c$2 */
    class C214542 implements C3473o {
        C214542() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(23243);
            if (C5046bo.nullAsNil(str).equals("NewXmlOpenIMFriReqAcceptedInWxWork")) {
                new C21453e(map).aip();
            }
            AppMethodBeat.m2505o(23243);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.c$1 */
    static class C346971 implements C1366d {
        C346971() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C34740a.fjY;
        }
    }

    public C34696c() {
        AppMethodBeat.m2504i(23244);
        AppMethodBeat.m2505o(23244);
    }

    static {
        AppMethodBeat.m2504i(23250);
        C44042b.m79163a(new C21496a(), "//usenewprofile");
        eaA.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new C346971());
        AppMethodBeat.m2505o(23250);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    public static C34740a cap() {
        AppMethodBeat.m2504i(23245);
        C1720g.m3534RN().mo5159QU();
        if (C34696c.caq().pkw == null) {
            C34696c caq = C34696c.caq();
            C9638aw.m17190ZK();
            caq.pkw = new C34740a(C18628c.m29069Ru());
        }
        C34740a c34740a = C34696c.caq().pkw;
        AppMethodBeat.m2505o(23245);
        return c34740a;
    }

    private static C34696c caq() {
        AppMethodBeat.m2504i(23246);
        C9638aw.m17184ZE();
        C34696c c34696c = (C34696c) C45439bw.m83697oJ("plugin.profile");
        if (c34696c == null) {
            C4990ab.m7420w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
            c34696c = new C34696c();
            C9638aw.m17184ZE().mo73244a("plugin.freewifi", c34696c);
        }
        AppMethodBeat.m2505o(23246);
        return c34696c;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(23247);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("NewXmlOpenIMFriReqAcceptedInWxWork", this.pkx);
        AppMethodBeat.m2505o(23247);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(23248);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("NewXmlOpenIMFriReqAcceptedInWxWork", this.pkx);
        AppMethodBeat.m2505o(23248);
    }

    /* renamed from: am */
    public static int m56965am(Intent intent) {
        AppMethodBeat.m2504i(23249);
        if (intent != null) {
            int intExtra = intent.getIntExtra("CONTACT_INFO_UI_SOURCE", 0);
            C4990ab.m7410d("MicroMsg.SubCoreProfile", "[getPrefixAddScene] source:".concat(String.valueOf(intExtra)));
            AppMethodBeat.m2505o(23249);
            return intExtra;
        }
        AppMethodBeat.m2505o(23249);
        return 0;
    }
}
