package com.tencent.p177mm.plugin.nearby.p1001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.nearby.a.b */
public enum C43333b {
    ;

    /* renamed from: com.tencent.mm.plugin.nearby.a.b$1 */
    static class C126961 implements C1827a {
        C126961() {
        }

        /* renamed from: JU */
        public final boolean mo5405JU() {
            return false;
        }

        /* renamed from: JV */
        public final void mo5406JV() {
        }
    }

    private C43333b(String str) {
    }

    static {
        AppMethodBeat.m2505o(55362);
    }

    /* renamed from: fr */
    public static boolean m77313fr(String str, String str2) {
        AppMethodBeat.m2504i(55355);
        C7616ad c7616ad = new C7616ad();
        c7616ad.mo14703iB(str2);
        c7616ad.setUsername(str);
        C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
        C4990ab.m7410d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + c7616ad.field_username);
        if (!XM.aoQ(c7616ad.field_username)) {
            XM.mo15702Z(c7616ad);
        }
        C1720g.m3536RP().mo5239Ry().set(143873, (Object) str);
        C1720g.m3536RP().mo5239Ry().set(143874, Long.valueOf(C5046bo.anT()));
        AppMethodBeat.m2505o(55355);
        return true;
    }

    /* renamed from: cK */
    public static void m77312cK(String str, int i) {
        AppMethodBeat.m2504i(55356);
        C1720g.m3540Rg().mo14541a(new C39454d(str, (int) C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(143874, Long.valueOf(0)))), i), 0);
        AppMethodBeat.m2505o(55356);
    }

    /* renamed from: zY */
    public static void m77314zY(int i) {
        AppMethodBeat.m2504i(55357);
        String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(143873, (Object) ""));
        if (!nullAsNil.equals("")) {
            if (C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(143874, Long.valueOf(0)))) < 7200) {
                C43333b.m77312cK(nullAsNil, i);
                AppMethodBeat.m2505o(55357);
                return;
            }
            C43333b.m77311TA(nullAsNil);
        }
        AppMethodBeat.m2505o(55357);
    }

    public static boolean bUU() {
        AppMethodBeat.m2504i(55358);
        if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(143875, Integer.valueOf(0))) == 1) {
            AppMethodBeat.m2505o(55358);
            return true;
        }
        AppMethodBeat.m2505o(55358);
        return false;
    }

    public static void bUV() {
        AppMethodBeat.m2504i(55359);
        C1720g.m3536RP().mo5239Ry().set(143875, Integer.valueOf(1));
        AppMethodBeat.m2505o(55359);
    }

    public static void bUW() {
        AppMethodBeat.m2504i(55360);
        C1720g.m3536RP().mo5239Ry().set(143875, Integer.valueOf(0));
        AppMethodBeat.m2505o(55360);
    }

    /* renamed from: TA */
    public static void m77311TA(String str) {
        AppMethodBeat.m2504i(55361);
        C7309bd XM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
        if (XM.aoQ(str)) {
            XM.aoU(str);
        }
        C1829bf.m3741a(str, new C126961());
        C1720g.m3536RP().mo5239Ry().set(143873, (Object) "");
        C1720g.m3536RP().mo5239Ry().set(143874, Long.valueOf(0));
        C43333b.bUW();
        AppMethodBeat.m2505o(55361);
    }
}
