package com.tencent.p177mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.bcm;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.t */
public final class C1855t {
    private static C1811ah fkO = null;
    public static final String fkP = C1855t.m3886b("rconversation.username", new String[]{"@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com"});
    public static final String fkQ = C1855t.m3886b("rconversation.username", new String[]{"@chatroom", "@micromsg.qq.com"});
    public static final String fkR = C1855t.m3886b("rconversation.username", new String[]{"@t.qq.com"});
    public static final String fkS = C1855t.m3886b("rconversation.username", new String[]{"@qqim"});
    public static final String fkT = C1855t.m3886b("rconversation.username", new String[]{"@chatroom_exclusive"});
    public static final String fkU = C1855t.m3886b("rconversation.username", new String[]{"@micromsg.qq.com"});
    public static final String fkV = C1855t.m3886b("rconversation.username", new String[]{"@app"});
    public static final String fkW = C1855t.m3886b("rconversation.username", new String[]{"@chatroom"});
    public static final String fkX = C1855t.m3886b("rconversation.username", new String[]{"@im.chatroom"});
    public static final String[] fkY = new String[]{"qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg"};

    static {
        AppMethodBeat.m2504i(59878);
        AppMethodBeat.m2505o(59878);
    }

    /* renamed from: a */
    public static void m3880a(C1811ah c1811ah) {
        fkO = c1811ah;
    }

    /* renamed from: mM */
    public static boolean m3900mM(String str) {
        AppMethodBeat.m2504i(59780);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59780);
            return false;
        } else if (!str.contains("@") || str.endsWith("@micromsg.qq.com")) {
            AppMethodBeat.m2505o(59780);
            return true;
        } else {
            AppMethodBeat.m2505o(59780);
            return false;
        }
    }

    /* renamed from: mN */
    public static boolean m3901mN(String str) {
        AppMethodBeat.m2504i(59781);
        if (C1855t.m3902mO(str) || C1855t.m3903mP(str)) {
            AppMethodBeat.m2505o(59781);
            return true;
        }
        AppMethodBeat.m2505o(59781);
        return false;
    }

    /* renamed from: mO */
    public static boolean m3902mO(String str) {
        AppMethodBeat.m2504i(59782);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59782);
            return false;
        }
        boolean endsWith = str.endsWith("@chatroom");
        AppMethodBeat.m2505o(59782);
        return endsWith;
    }

    /* renamed from: kH */
    public static boolean m3896kH(String str) {
        AppMethodBeat.m2504i(59783);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59783);
            return false;
        } else if (str.endsWith("@chatroom") || str.endsWith("@im.chatroom")) {
            AppMethodBeat.m2505o(59783);
            return true;
        } else {
            AppMethodBeat.m2505o(59783);
            return false;
        }
    }

    /* renamed from: mP */
    public static boolean m3903mP(String str) {
        AppMethodBeat.m2504i(59784);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59784);
            return false;
        }
        boolean endsWith = str.endsWith("@im.chatroom");
        AppMethodBeat.m2505o(59784);
        return endsWith;
    }

    /* renamed from: mQ */
    public static boolean m3904mQ(String str) {
        AppMethodBeat.m2504i(59785);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59785);
            return false;
        }
        boolean endsWith = str.endsWith("@qy_u");
        AppMethodBeat.m2505o(59785);
        return endsWith;
    }

    /* renamed from: mR */
    public static boolean m3905mR(String str) {
        AppMethodBeat.m2504i(59786);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59786);
            return false;
        }
        boolean endsWith = str.endsWith("@bottle");
        AppMethodBeat.m2505o(59786);
        return endsWith;
    }

    /* renamed from: mS */
    public static boolean m3906mS(String str) {
        AppMethodBeat.m2504i(59787);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59787);
            return false;
        }
        boolean endsWith = str.endsWith("@qqim");
        AppMethodBeat.m2505o(59787);
        return endsWith;
    }

    /* renamed from: mT */
    public static boolean m3907mT(String str) {
        AppMethodBeat.m2504i(59788);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59788);
            return false;
        }
        boolean endsWith = str.endsWith("@lbsroom");
        AppMethodBeat.m2505o(59788);
        return endsWith;
    }

    /* renamed from: e */
    public static boolean m3889e(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59789);
        if (c7616ad == null) {
            AppMethodBeat.m2505o(59789);
            return false;
        } else if (!C1855t.m3901mN(c7616ad.field_username)) {
            AppMethodBeat.m2505o(59789);
            return false;
        } else if (C7486a.m12942jh(c7616ad.field_type)) {
            AppMethodBeat.m2505o(59789);
            return true;
        } else {
            AppMethodBeat.m2505o(59789);
            return false;
        }
    }

    /* renamed from: mU */
    public static boolean m3908mU(String str) {
        AppMethodBeat.m2504i(59790);
        boolean equals = "gh_43f2581f6fd6".equals(str);
        AppMethodBeat.m2505o(59790);
        return equals;
    }

    /* renamed from: mV */
    public static boolean m3909mV(String str) {
        AppMethodBeat.m2504i(59791);
        boolean equals = "downloaderapp".equals(str);
        AppMethodBeat.m2505o(59791);
        return equals;
    }

    /* renamed from: mW */
    public static boolean m3910mW(String str) {
        AppMethodBeat.m2504i(59792);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59792);
            return false;
        } else if (C1855t.m3901mN(str)) {
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
            if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                AppMethodBeat.m2505o(59792);
                return false;
            }
            AppMethodBeat.m2505o(59792);
            return true;
        } else {
            AppMethodBeat.m2505o(59792);
            return false;
        }
    }

    /* renamed from: mX */
    public static boolean m3911mX(String str) {
        AppMethodBeat.m2504i(59793);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59793);
            return false;
        }
        boolean endsWith = str.endsWith("@stranger");
        AppMethodBeat.m2505o(59793);
        return endsWith;
    }

    /* renamed from: Zh */
    public static List<String> m3871Zh() {
        AppMethodBeat.m2504i(59794);
        List dsr = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().dsr();
        AppMethodBeat.m2505o(59794);
        return dsr;
    }

    /* renamed from: Zi */
    public static List<C7616ad> m3872Zi() {
        AppMethodBeat.m2504i(59795);
        ArrayList arrayList = new ArrayList();
        Cursor dss = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().dss();
        if (dss.moveToFirst()) {
            do {
                C7616ad c7616ad = new C7616ad();
                c7616ad.mo8995d(dss);
                arrayList.add(c7616ad);
            } while (dss.moveToNext());
        }
        dss.close();
        AppMethodBeat.m2505o(59795);
        return arrayList;
    }

    /* renamed from: a */
    public static String m3879a(C7616ad c7616ad, String str) {
        AppMethodBeat.m2504i(59796);
        if (c7616ad == null) {
            AppMethodBeat.m2505o(59796);
            return str;
        }
        if (C1855t.m3901mN(str) && C5046bo.isNullOrNil(c7616ad.field_nickname)) {
            String mJ = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14883mJ(str);
            if (!C5046bo.isNullOrNil(mJ)) {
                AppMethodBeat.m2505o(59796);
                return mJ;
            }
        }
        if (c7616ad.mo16707Oj() == null || c7616ad.mo16707Oj().length() <= 0) {
            AppMethodBeat.m2505o(59796);
            return str;
        }
        str = c7616ad.mo16707Oj();
        AppMethodBeat.m2505o(59796);
        return str;
    }

    /* renamed from: mY */
    public static boolean m3912mY(String str) {
        AppMethodBeat.m2504i(59797);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59797);
            return true;
        }
        boolean jh = C7486a.m12942jh(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str).field_type);
        AppMethodBeat.m2505o(59797);
        return jh;
    }

    /* renamed from: mZ */
    public static boolean m3913mZ(String str) {
        AppMethodBeat.m2504i(59798);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59798);
            return false;
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.m2505o(59798);
            return false;
        }
        boolean Mn = C7616ad.m13547Mn(aoO.field_verifyFlag);
        AppMethodBeat.m2505o(59798);
        return Mn;
    }

    /* renamed from: kv */
    public static boolean m3897kv(int i) {
        AppMethodBeat.m2504i(59799);
        boolean Mn = C7616ad.m13547Mn(i);
        AppMethodBeat.m2505o(59799);
        return Mn;
    }

    /* renamed from: f */
    public static void m3890f(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59800);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (!(aoO == null || C5046bo.isNullOrNil(aoO.field_username))) {
            c7616ad = aoO;
        }
        c7616ad.mo16682NH();
        C1855t.m3964u(c7616ad);
        AppMethodBeat.m2505o(59800);
    }

    /* renamed from: v */
    public static void m3966v(String str, boolean z) {
        AppMethodBeat.m2504i(59801);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            AppMethodBeat.m2505o(59801);
            return;
        }
        if (z) {
            aoO.mo16691NQ();
        } else {
            aoO.mo16692NR();
        }
        C1855t.m3963t(aoO);
        AppMethodBeat.m2505o(59801);
    }

    /* renamed from: g */
    public static void m3891g(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59802);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (!(aoO == null || C5046bo.isNullOrNil(aoO.field_username))) {
            c7616ad = aoO;
        }
        c7616ad.mo16680NF();
        C1855t.m3964u(c7616ad);
        AppMethodBeat.m2505o(59802);
    }

    /* renamed from: h */
    public static void m3892h(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59803);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (!(aoO == null || C5046bo.isNullOrNil(aoO.field_username))) {
            c7616ad = aoO;
        }
        c7616ad.mo16681NG();
        C1855t.m3964u(c7616ad);
        AppMethodBeat.m2505o(59803);
    }

    /* renamed from: i */
    public static void m3893i(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59804);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            aoO = c7616ad;
        }
        aoO.mo16678ND();
        if (C7616ad.aox(c7616ad.field_username) && fkO != null) {
            fkO.mo5379ok(c7616ad.field_username);
        }
        C1855t.m3964u(aoO);
        AppMethodBeat.m2505o(59804);
    }

    /* renamed from: j */
    public static void m3894j(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59805);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            aoO = c7616ad;
        }
        aoO.mo16679NE();
        if (C7616ad.aox(c7616ad.field_username) && fkO != null) {
            fkO.mo5380ol(c7616ad.field_username);
        }
        C1855t.m3964u(aoO);
        C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c7616ad.field_username);
        if (aoZ != null && "@blacklist".equals(aoZ.field_parentRef)) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15806c(new String[]{aoZ.field_username}, "");
        }
        AppMethodBeat.m2505o(59805);
    }

    /* renamed from: k */
    public static void m3895k(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59806);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            aoO = c7616ad;
        }
        aoO.mo16691NQ();
        aoO.mo14696hu(c7616ad.mo16696Ny());
        C1855t.m3963t(aoO);
        AppMethodBeat.m2505o(59806);
    }

    /* renamed from: l */
    public static void m3898l(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59807);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            aoO = c7616ad;
        }
        aoO.mo16692NR();
        aoO.mo14696hu(c7616ad.mo16696Ny());
        C1855t.m3963t(aoO);
        AppMethodBeat.m2505o(59807);
    }

    /* renamed from: m */
    public static void m3899m(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59808);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            aoO = c7616ad;
        }
        aoO.mo16687NM();
        aoO.mo14696hu(c7616ad.mo16696Ny());
        if (C7616ad.aox(c7616ad.field_username) && fkO != null) {
            fkO.mo5381om(c7616ad.field_username);
        }
        C1855t.m3964u(aoO);
        AppMethodBeat.m2505o(59808);
    }

    /* renamed from: n */
    public static void m3914n(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59809);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            aoO = c7616ad;
        }
        aoO.mo16688NN();
        aoO.mo14696hu(c7616ad.mo16696Ny());
        if (C7616ad.aox(c7616ad.field_username) && fkO != null) {
            fkO.mo5382on(c7616ad.field_username);
        }
        C1855t.m3964u(aoO);
        AppMethodBeat.m2505o(59809);
    }

    /* renamed from: w */
    public static void m3967w(String str, boolean z) {
        AppMethodBeat.m2504i(59810);
        Assert.assertTrue(!C5046bo.isNullOrNil(str));
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            AppMethodBeat.m2505o(59810);
            return;
        }
        aoO.setType(aoO.field_type | 2048);
        if ((C7616ad.aox(str) || C1855t.m3903mP(str)) && fkO != null) {
            fkO.mo5377oi(str);
        }
        C1855t.m3964u(aoO);
        if (z) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apf(str);
        }
        AppMethodBeat.m2505o(59810);
    }

    /* renamed from: na */
    public static void m3932na(String str) {
        AppMethodBeat.m2504i(59811);
        C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(str);
        Object obj = null;
        if (aoZ == null) {
            aoZ = new C7617ak();
            aoZ.dsI();
            obj = 1;
            aoZ.setUsername(str);
        }
        aoZ.mo14742eD(System.currentTimeMillis());
        if (obj != null) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(aoZ);
            AppMethodBeat.m2505o(59811);
            return;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, str);
        AppMethodBeat.m2505o(59811);
    }

    /* renamed from: x */
    public static void m3969x(String str, boolean z) {
        AppMethodBeat.m2504i(59812);
        Assert.assertTrue(!C5046bo.isNullOrNil(str));
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            AppMethodBeat.m2505o(59812);
            return;
        }
        aoO.setType(aoO.field_type & -2049);
        if ((C7616ad.aox(str) || C1855t.m3903mP(str)) && fkO != null) {
            fkO.mo5378oj(str);
        }
        C1855t.m3964u(aoO);
        if (z) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apg(str);
        }
        AppMethodBeat.m2505o(59812);
    }

    /* renamed from: o */
    public static void m3958o(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59813);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            aoO = c7616ad;
        }
        aoO.mo16689NO();
        if (C7616ad.aox(c7616ad.field_username) && fkO != null) {
            fkO.mo5383oo(c7616ad.field_username);
        }
        C1855t.m3964u(aoO);
        AppMethodBeat.m2505o(59813);
    }

    /* renamed from: p */
    public static void m3959p(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59814);
        Assert.assertTrue(c7616ad != null);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        if (aoO == null || C5046bo.isNullOrNil(aoO.field_username)) {
            aoO = c7616ad;
        }
        aoO.mo16690NP();
        if (C7616ad.aox(c7616ad.field_username) && fkO != null) {
            fkO.mo5384op(c7616ad.field_username);
        }
        C1855t.m3964u(aoO);
        AppMethodBeat.m2505o(59814);
    }

    /* renamed from: q */
    public static void m3960q(C7616ad c7616ad) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(59815);
        Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", c7616ad != null);
        String str = "MicroMsg.ContactStorageLogic: contactId == 0";
        if (((int) c7616ad.ewQ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        String str2 = "MicroMsg.ContactStorageLogic: username length <= 0";
        if (c7616ad.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        c7616ad.mo16676NB();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(c7616ad.field_username, c7616ad);
        AppMethodBeat.m2505o(59815);
    }

    /* renamed from: r */
    public static void m3961r(C7616ad c7616ad) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(59816);
        if (c7616ad != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) c7616ad.ewQ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (c7616ad.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        c7616ad.mo16676NB();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(c7616ad.field_username, c7616ad);
        C1855t.m3964u(c7616ad);
        AppMethodBeat.m2505o(59816);
    }

    /* renamed from: b */
    public static void m3887b(C7616ad c7616ad, String str) {
        AppMethodBeat.m2504i(59817);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        boolean z = (aoO == null || str == null) ? false : true;
        Assert.assertTrue(z);
        aoO.mo14729iz(str);
        if (C7616ad.aox(c7616ad.field_username) && fkO != null) {
            fkO.mo5376ah(c7616ad.field_username, str);
        }
        C1855t.m3964u(aoO);
        AppMethodBeat.m2505o(59817);
    }

    /* renamed from: s */
    public static void m3962s(C7616ad c7616ad) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(59818);
        if (c7616ad != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) c7616ad.ewQ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (c7616ad.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        c7616ad.mo16704Og();
        C1855t.m3964u(c7616ad);
        AppMethodBeat.m2505o(59818);
    }

    /* renamed from: t */
    private static void m3963t(C7616ad c7616ad) {
        boolean z;
        AppMethodBeat.m2504i(59819);
        if (c7616ad != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) c7616ad.ewQ) == 0) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15708aa(c7616ad);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(c7616ad.field_username, c7616ad);
        bcm bcm = new bcm();
        bcm.wGA = c7616ad.field_username;
        if (c7616ad.mo16701Od()) {
            bcm.wGN = 1;
        } else {
            bcm.wGN = 2;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(52, bcm));
        AppMethodBeat.m2505o(59819);
    }

    /* renamed from: u */
    public static void m3964u(C7616ad c7616ad) {
        boolean z;
        AppMethodBeat.m2504i(59820);
        if (c7616ad != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) c7616ad.ewQ) == 0) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15708aa(c7616ad);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad.field_username);
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(c7616ad.field_username, c7616ad);
        if (!C7616ad.aox(c7616ad.field_username)) {
            C1855t.m3965v(c7616ad);
        }
        AppMethodBeat.m2505o(59820);
    }

    /* renamed from: v */
    public static void m3965v(C7616ad c7616ad) {
        AppMethodBeat.m2504i(59821);
        C4990ab.m7417i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", c7616ad.field_username, c7616ad.field_conRemark, Integer.valueOf(c7616ad.field_type));
        bbv bbv = new bbv();
        bbv.wcB = new bts().alV(C5046bo.nullAsNil(c7616ad.field_username));
        bbv.wyX = new bts().alV(C5046bo.nullAsNil(c7616ad.field_nickname));
        bbv.wce = new bts().alV(C5046bo.nullAsNil(c7616ad.mo14676Ht()));
        bbv.wcf = new bts().alV(C5046bo.nullAsNil(c7616ad.mo14677Hu()));
        bbv.guN = c7616ad.dtS;
        bbv.wbu = 561023;
        bbv.wbv = c7616ad.field_type;
        bbv.wFK = new bts().alV(C5046bo.nullAsNil(c7616ad.field_conRemark));
        bbv.wFL = new bts().alV(C5046bo.nullAsNil(c7616ad.field_conRemarkPYShort));
        bbv.wFM = new bts().alV(C5046bo.nullAsNil(c7616ad.field_conRemarkPYFull));
        bbv.wbA = c7616ad.dtX;
        bbv.wGf = new bts().alV(C5046bo.nullAsNil(c7616ad.field_domainList));
        bbv.wbE = c7616ad.dua;
        bbv.guR = c7616ad.dub;
        bbv.guQ = C5046bo.nullAsNil(c7616ad.signature);
        bbv.guP = C5046bo.nullAsNil(c7616ad.getCityCode());
        bbv.guO = C5046bo.nullAsNil(c7616ad.dsj());
        bbv.wBV = C5046bo.nullAsNil(c7616ad.dug);
        bbv.wBX = c7616ad.field_weiboFlag;
        bbv.wGb = 0;
        bbv.vEF = new SKBuiltinBuffer_t();
        bbv.guW = C5046bo.nullAsNil(c7616ad.getCountryCode());
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(2, bbv));
        AppMethodBeat.m2505o(59821);
    }

    /* renamed from: nb */
    public static void m3933nb(String str) {
        AppMethodBeat.m2504i(59822);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59822);
            return;
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.m2505o(59822);
            return;
        }
        aoO.setSource(0);
        aoO.mo16697Nz();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15724b(str, aoO);
        AppMethodBeat.m2505o(59822);
    }

    /* renamed from: a */
    public static int[] m3882a(String str, String str2, List<String> list, String str3) {
        AppMethodBeat.m2504i(59823);
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15730b(str, str2, str3, (List) list);
        C4990ab.m7410d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            AppMethodBeat.m2505o(59823);
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] c = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15736c(str, str2, str3, (List) list);
        C4990ab.m7410d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (c == null) {
            AppMethodBeat.m2505o(59823);
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        AppMethodBeat.m2505o(59823);
        return iArr;
    }

    /* renamed from: V */
    public static int[] m3869V(List<String> list) {
        AppMethodBeat.m2504i(59824);
        long currentTimeMillis = System.currentTimeMillis();
        int[] eF = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15756eF(list);
        C4990ab.m7410d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (eF.length <= 0) {
            AppMethodBeat.m2505o(59824);
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] eG = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15757eG(list);
        C4990ab.m7410d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (eG == null) {
            AppMethodBeat.m2505o(59824);
            return null;
        }
        Assert.assertTrue(eF.length == eG.length);
        int[] iArr = new int[eG.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < eF.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += eG[i];
            i++;
            i3 = i4;
        }
        AppMethodBeat.m2505o(59824);
        return iArr;
    }

    /* renamed from: a */
    public static int[] m3883a(String str, String str2, List<String> list, String[] strArr) {
        AppMethodBeat.m2504i(59825);
        int[] b = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15731b(str, str2, strArr, (List) list);
        if (b.length <= 0) {
            AppMethodBeat.m2505o(59825);
            return null;
        }
        int[] c = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15737c(str, str2, strArr, (List) list);
        if (c == null) {
            AppMethodBeat.m2505o(59825);
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        AppMethodBeat.m2505o(59825);
        return iArr;
    }

    /* renamed from: a */
    public static String[] m3885a(String str, String str2, String[] strArr, List<String> list) {
        int i = 0;
        AppMethodBeat.m2504i(59826);
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15731b(str, str2, strArr, (List) list);
        C4990ab.m7410d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            AppMethodBeat.m2505o(59826);
            return null;
        }
        String[] strArr2 = new String[b.length];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < b.length) {
                char c = (char) b[i2];
                if (c == '{') {
                    i = i3 + 1;
                    strArr2[i3] = "#";
                } else if (c == ' ') {
                    i = i3 + 1;
                    strArr2[i3] = "$";
                } else {
                    i = i3 + 1;
                    strArr2[i3] = String.valueOf(c);
                }
                i2++;
            } else {
                AppMethodBeat.m2505o(59826);
                return strArr2;
            }
        }
    }

    /* renamed from: a */
    public static String[] m3884a(String str, String str2, String str3, List<String> list) {
        int i = 0;
        AppMethodBeat.m2504i(59827);
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15730b(str, str2, str3, (List) list);
        C4990ab.m7410d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            AppMethodBeat.m2505o(59827);
            return null;
        }
        String[] strArr = new String[b.length];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < b.length) {
                char c = (char) b[i2];
                if (c == '{') {
                    i = i3 + 1;
                    strArr[i3] = "#";
                } else if (c == ' ') {
                    i = i3 + 1;
                    strArr[i3] = "$";
                } else {
                    i = i3 + 1;
                    strArr[i3] = String.valueOf(c);
                }
                i2++;
            } else {
                AppMethodBeat.m2505o(59827);
                return strArr;
            }
        }
    }

    /* renamed from: W */
    public static String[] m3870W(List<String> list) {
        int i = 0;
        AppMethodBeat.m2504i(59828);
        long currentTimeMillis = System.currentTimeMillis();
        int[] eF = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15756eF(list);
        C4990ab.m7410d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (eF.length <= 0) {
            AppMethodBeat.m2505o(59828);
            return null;
        }
        String[] strArr = new String[eF.length];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < eF.length) {
                char c = (char) eF[i2];
                if (c == '{') {
                    i = i3 + 1;
                    strArr[i3] = "#";
                } else if (c == ' ') {
                    i = i3 + 1;
                    strArr[i3] = "$";
                } else {
                    i = i3 + 1;
                    strArr[i3] = String.valueOf(c);
                }
                i2++;
            } else {
                AppMethodBeat.m2505o(59828);
                return strArr;
            }
        }
    }

    /* renamed from: nc */
    public static boolean m3934nc(String str) {
        AppMethodBeat.m2504i(59829);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("qqmail");
            AppMethodBeat.m2505o(59829);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59829);
        return false;
    }

    /* renamed from: nd */
    public static boolean m3935nd(String str) {
        AppMethodBeat.m2504i(59830);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("fmessage");
            AppMethodBeat.m2505o(59830);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59830);
        return false;
    }

    /* renamed from: ne */
    public static boolean m3936ne(String str) {
        AppMethodBeat.m2504i(59831);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("tmessage");
            AppMethodBeat.m2505o(59831);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59831);
        return false;
    }

    /* renamed from: nf */
    public static boolean m3937nf(String str) {
        AppMethodBeat.m2504i(59832);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("floatbottle");
            AppMethodBeat.m2505o(59832);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59832);
        return false;
    }

    /* renamed from: ng */
    public static boolean m3938ng(String str) {
        AppMethodBeat.m2504i(59833);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("qmessage");
            AppMethodBeat.m2505o(59833);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59833);
        return false;
    }

    /* renamed from: nh */
    public static boolean m3939nh(String str) {
        AppMethodBeat.m2504i(59834);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("facebookapp");
            AppMethodBeat.m2505o(59834);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59834);
        return false;
    }

    /* renamed from: ni */
    public static boolean m3940ni(String str) {
        AppMethodBeat.m2504i(59835);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("masssendapp");
            AppMethodBeat.m2505o(59835);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59835);
        return false;
    }

    /* renamed from: Zj */
    public static boolean m3873Zj() {
        return false;
    }

    /* renamed from: nj */
    public static boolean m3941nj(String str) {
        AppMethodBeat.m2504i(59836);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("feedsapp");
            AppMethodBeat.m2505o(59836);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59836);
        return false;
    }

    /* renamed from: nk */
    public static boolean m3942nk(String str) {
        AppMethodBeat.m2504i(59837);
        boolean equalsIgnoreCase = "qqsync".equalsIgnoreCase(str);
        AppMethodBeat.m2505o(59837);
        return equalsIgnoreCase;
    }

    /* renamed from: nl */
    public static boolean m3943nl(String str) {
        AppMethodBeat.m2504i(59838);
        if (str == null) {
            AppMethodBeat.m2505o(59838);
            return false;
        } else if (str.equalsIgnoreCase("weixin") || str.equalsIgnoreCase("gh_9639b5a92773")) {
            AppMethodBeat.m2505o(59838);
            return true;
        } else {
            AppMethodBeat.m2505o(59838);
            return false;
        }
    }

    /* renamed from: nm */
    public static boolean m3944nm(String str) {
        AppMethodBeat.m2504i(59839);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("lbsapp");
            AppMethodBeat.m2505o(59839);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59839);
        return false;
    }

    /* renamed from: nn */
    public static boolean m3945nn(String str) {
        AppMethodBeat.m2504i(59840);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("shakeapp");
            AppMethodBeat.m2505o(59840);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59840);
        return false;
    }

    /* renamed from: no */
    public static boolean m3946no(String str) {
        AppMethodBeat.m2504i(59841);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("medianote");
            AppMethodBeat.m2505o(59841);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59841);
        return false;
    }

    /* renamed from: np */
    public static boolean m3947np(String str) {
        AppMethodBeat.m2504i(59842);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("newsapp");
            AppMethodBeat.m2505o(59842);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59842);
        return false;
    }

    /* renamed from: nq */
    public static boolean m3948nq(String str) {
        AppMethodBeat.m2504i(59843);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("topstoryapp");
            AppMethodBeat.m2505o(59843);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59843);
        return false;
    }

    /* renamed from: nr */
    public static boolean m3949nr(String str) {
        AppMethodBeat.m2504i(59844);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("voipapp");
            AppMethodBeat.m2505o(59844);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59844);
        return false;
    }

    /* renamed from: ns */
    public static boolean m3950ns(String str) {
        AppMethodBeat.m2504i(59845);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("voicevoipapp");
            AppMethodBeat.m2505o(59845);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59845);
        return false;
    }

    /* renamed from: nt */
    public static boolean m3951nt(String str) {
        AppMethodBeat.m2504i(59846);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("voiceinputapp");
            AppMethodBeat.m2505o(59846);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59846);
        return false;
    }

    /* renamed from: nu */
    public static boolean m3952nu(String str) {
        AppMethodBeat.m2504i(59847);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("linkedinplugin");
            AppMethodBeat.m2505o(59847);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59847);
        return false;
    }

    /* renamed from: nv */
    public static boolean m3953nv(String str) {
        AppMethodBeat.m2504i(59848);
        boolean nw = C1855t.m3954nw(str);
        AppMethodBeat.m2505o(59848);
        return nw;
    }

    /* renamed from: nw */
    public static boolean m3954nw(String str) {
        AppMethodBeat.m2504i(59849);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("gh_22b87fa7cb3c");
            AppMethodBeat.m2505o(59849);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59849);
        return false;
    }

    /* renamed from: nx */
    public static boolean m3955nx(String str) {
        AppMethodBeat.m2504i(59850);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("blogapp");
            AppMethodBeat.m2505o(59850);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59850);
        return false;
    }

    /* renamed from: ny */
    public static boolean m3956ny(String str) {
        AppMethodBeat.m2504i(59851);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("officialaccounts");
            AppMethodBeat.m2505o(59851);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59851);
        return false;
    }

    /* renamed from: nz */
    public static boolean m3957nz(String str) {
        AppMethodBeat.m2504i(59852);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("helper_entry");
            AppMethodBeat.m2505o(59852);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59852);
        return false;
    }

    /* renamed from: nA */
    public static boolean m3915nA(String str) {
        AppMethodBeat.m2504i(59853);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("qqfriend");
            AppMethodBeat.m2505o(59853);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59853);
        return false;
    }

    /* renamed from: nB */
    public static boolean m3916nB(String str) {
        AppMethodBeat.m2504i(59854);
        boolean equalsIgnoreCase = "filehelper".equalsIgnoreCase(str);
        AppMethodBeat.m2505o(59854);
        return equalsIgnoreCase;
    }

    /* renamed from: nC */
    public static boolean m3917nC(String str) {
        AppMethodBeat.m2504i(59855);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("pc_share");
            AppMethodBeat.m2505o(59855);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59855);
        return false;
    }

    /* renamed from: nD */
    public static boolean m3918nD(String str) {
        AppMethodBeat.m2504i(59856);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("notifymessage");
            AppMethodBeat.m2505o(59856);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59856);
        return false;
    }

    /* renamed from: nE */
    public static boolean m3919nE(String str) {
        AppMethodBeat.m2504i(59857);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("notification_messages");
            AppMethodBeat.m2505o(59857);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59857);
        return false;
    }

    /* renamed from: nF */
    public static boolean m3920nF(String str) {
        AppMethodBeat.m2504i(59858);
        if (C1855t.m3921nG(str)) {
            AppMethodBeat.m2505o(59858);
            return true;
        } else if (C1855t.m3923nI(str)) {
            AppMethodBeat.m2505o(59858);
            return true;
        } else if (C1855t.m3956ny(str)) {
            AppMethodBeat.m2505o(59858);
            return true;
        } else if (C1855t.m3957nz(str)) {
            AppMethodBeat.m2505o(59858);
            return true;
        } else {
            AppMethodBeat.m2505o(59858);
            return false;
        }
    }

    /* renamed from: nG */
    public static boolean m3921nG(String str) {
        AppMethodBeat.m2504i(59859);
        C1720g.m3537RQ();
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(21, null);
        if ((str2 == null || !str2.equalsIgnoreCase(str)) && !str.equalsIgnoreCase("weixin")) {
            AppMethodBeat.m2505o(59859);
            return false;
        }
        AppMethodBeat.m2505o(59859);
        return true;
    }

    /* renamed from: nH */
    public static boolean m3922nH(String str) {
        AppMethodBeat.m2504i(59860);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("appbrandcustomerservicemsg");
            AppMethodBeat.m2505o(59860);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(59860);
        return false;
    }

    /* renamed from: nI */
    public static boolean m3923nI(String str) {
        AppMethodBeat.m2504i(59861);
        for (String equalsIgnoreCase : fkY) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                AppMethodBeat.m2505o(59861);
                return true;
            }
        }
        AppMethodBeat.m2505o(59861);
        return false;
    }

    /* renamed from: nJ */
    public static boolean m3924nJ(String str) {
        AppMethodBeat.m2504i(59862);
        if (C1855t.m3923nI(str)) {
            AppMethodBeat.m2505o(59862);
            return true;
        } else if (C7616ad.aow(str)) {
            AppMethodBeat.m2505o(59862);
            return true;
        } else if (C7616ad.aou(str)) {
            AppMethodBeat.m2505o(59862);
            return true;
        } else if (C7616ad.m13548mR(str)) {
            AppMethodBeat.m2505o(59862);
            return true;
        } else {
            AppMethodBeat.m2505o(59862);
            return false;
        }
    }

    /* renamed from: nK */
    public static int m3925nK(String str) {
        AppMethodBeat.m2504i(59863);
        Assert.assertTrue(C5046bo.nullAsNil(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            AppMethodBeat.m2505o(59863);
            return 1;
        } else if (C7616ad.aou(toLowerCase)) {
            AppMethodBeat.m2505o(59863);
            return 11;
        } else if (C7616ad.aow(toLowerCase)) {
            AppMethodBeat.m2505o(59863);
            return 36;
        } else if (C7616ad.m13548mR(toLowerCase)) {
            AppMethodBeat.m2505o(59863);
            return 1;
        } else {
            AppMethodBeat.m2505o(59863);
            return 1;
        }
    }

    /* renamed from: nL */
    public static int m3926nL(String str) {
        AppMethodBeat.m2504i(59864);
        Assert.assertTrue(C5046bo.nullAsNil(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            AppMethodBeat.m2505o(59864);
            return 3;
        } else if (C7616ad.aou(toLowerCase)) {
            AppMethodBeat.m2505o(59864);
            return 13;
        } else if (C7616ad.aow(toLowerCase)) {
            AppMethodBeat.m2505o(59864);
            return 39;
        } else if (C7616ad.m13548mR(toLowerCase)) {
            AppMethodBeat.m2505o(59864);
            return 3;
        } else if (toLowerCase.contains("@")) {
            AppMethodBeat.m2505o(59864);
            return 3;
        } else {
            AppMethodBeat.m2505o(59864);
            return 3;
        }
    }

    /* renamed from: nM */
    public static boolean m3927nM(String str) {
        AppMethodBeat.m2504i(59865);
        if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str).dua != 1) {
            AppMethodBeat.m2505o(59865);
            return false;
        }
        AppMethodBeat.m2505o(59865);
        return true;
    }

    /* renamed from: nN */
    public static boolean m3928nN(String str) {
        AppMethodBeat.m2504i(59866);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || !aoO.mo16673DX()) {
            AppMethodBeat.m2505o(59866);
            return false;
        }
        AppMethodBeat.m2505o(59866);
        return true;
    }

    /* renamed from: nO */
    public static boolean m3929nO(String str) {
        AppMethodBeat.m2504i(59867);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(59867);
            return false;
        } else if (str.startsWith("t.qq.com/") || str.startsWith("http://t.qq.com/")) {
            AppMethodBeat.m2505o(59867);
            return true;
        } else {
            AppMethodBeat.m2505o(59867);
            return false;
        }
    }

    /* renamed from: nP */
    public static String m3930nP(String str) {
        AppMethodBeat.m2504i(59868);
        String replace;
        if (C1855t.m3929nO(str)) {
            replace = str.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
            AppMethodBeat.m2505o(59868);
            return replace;
        }
        replace = "";
        AppMethodBeat.m2505o(59868);
        return replace;
    }

    /* renamed from: Zk */
    public static boolean m3874Zk() {
        AppMethodBeat.m2504i(59869);
        if (C1853r.m3851Ze()) {
            C5140bq RA = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com");
            if (RA == null || C5046bo.isNullOrNil(RA.name)) {
                AppMethodBeat.m2505o(59869);
                return false;
            }
            AppMethodBeat.m2505o(59869);
            return true;
        }
        AppMethodBeat.m2505o(59869);
        return false;
    }

    /* renamed from: Zl */
    public static boolean m3875Zl() {
        AppMethodBeat.m2504i(59870);
        if (C1853r.m3851Ze()) {
            C5140bq RA = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com");
            if (RA == null || C5046bo.nullAsNil(RA.name).length() == 0) {
                AppMethodBeat.m2505o(59870);
                return false;
            }
            AppMethodBeat.m2505o(59870);
            return true;
        }
        AppMethodBeat.m2505o(59870);
        return false;
    }

    /* renamed from: Zm */
    public static List<C7616ad> m3876Zm() {
        AppMethodBeat.m2504i(59871);
        LinkedList linkedList = new LinkedList();
        Cursor dsv = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().dsv();
        if (dsv.getCount() == 0) {
            dsv.close();
            AppMethodBeat.m2505o(59871);
            return linkedList;
        }
        dsv.moveToFirst();
        do {
            C7616ad c7616ad = new C7616ad();
            c7616ad.mo8995d(dsv);
            linkedList.add(c7616ad);
        } while (dsv.moveToNext());
        dsv.close();
        C4990ab.m7410d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + linkedList.size());
        AppMethodBeat.m2505o(59871);
        return linkedList;
    }

    /* renamed from: Zn */
    public static List<String> m3877Zn() {
        AppMethodBeat.m2504i(59872);
        LinkedList linkedList = new LinkedList();
        Cursor dst = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().dst();
        if (dst.getCount() == 0) {
            dst.close();
            AppMethodBeat.m2505o(59872);
            return linkedList;
        }
        dst.moveToFirst();
        do {
            C7616ad c7616ad = new C7616ad();
            c7616ad.mo8995d(dst);
            linkedList.add(c7616ad.field_username);
        } while (dst.moveToNext());
        dst.close();
        C4990ab.m7410d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + linkedList.size());
        AppMethodBeat.m2505o(59872);
        return linkedList;
    }

    /* renamed from: Zo */
    public static int m3878Zo() {
        AppMethodBeat.m2504i(59875);
        int b = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15725b(fkY, C1853r.m3846Yz(), "weixin", "helper_entry", "filehelper");
        AppMethodBeat.m2505o(59875);
        return b;
    }

    /* renamed from: b */
    private static String m3886b(String str, String[] strArr) {
        AppMethodBeat.m2504i(59876);
        String str2 = " and ( 1 != 1 ";
        for (Object obj : strArr) {
            if ("@all.android".equals(obj)) {
                str2 = str2 + " or 1 = 1";
            } else if ("@micromsg.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " not like '%@%'";
            } else if ("@chatroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@chatroom'";
            } else if ("@talkroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@talkroom'";
            } else if ("@t.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@t.qq.com'";
            } else if ("@qqim".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@qqim'";
            } else if ("@chatroom_exclusive".equals(obj)) {
                str2 = str2 + " or " + str + "not like %@chatroom";
            } else if ("@app".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@app'";
            } else if ("@openim".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@openim'";
            } else if ("@im.chatroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@im.chatroom'";
            }
        }
        str2 = str2 + " ) ";
        AppMethodBeat.m2505o(59876);
        return str2;
    }

    /* renamed from: nQ */
    public static boolean m3931nQ(String str) {
        AppMethodBeat.m2504i(59877);
        if (str.equals("weixinsrc") || str.equalsIgnoreCase("gh_6e99ff560306")) {
            AppMethodBeat.m2505o(59877);
            return true;
        }
        AppMethodBeat.m2505o(59877);
        return false;
    }

    /* renamed from: w */
    public static boolean m3968w(C7616ad c7616ad) {
        return (c7616ad.field_weiboFlag & 1) != 0;
    }

    /* renamed from: a */
    public static boolean m3881a(C7617ak c7617ak) {
        AppMethodBeat.m2504i(59873);
        String str = c7617ak.field_username;
        if (C1855t.m3923nI(str)) {
            AppMethodBeat.m2505o(59873);
            return false;
        } else if (C1855t.m3921nG(str)) {
            AppMethodBeat.m2505o(59873);
            return false;
        } else if (C1855t.m3956ny(str)) {
            AppMethodBeat.m2505o(59873);
            return false;
        } else if (C1855t.m3957nz(str)) {
            AppMethodBeat.m2505o(59873);
            return false;
        } else if (c7617ak.field_conversationTime == -1) {
            AppMethodBeat.m2505o(59873);
            return false;
        } else if (C1855t.m3913mZ(str)) {
            AppMethodBeat.m2505o(59873);
            return true;
        } else {
            AppMethodBeat.m2505o(59873);
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m3888b(C7617ak c7617ak) {
        AppMethodBeat.m2504i(59874);
        String str = c7617ak.field_username;
        if (C1855t.m3956ny(str)) {
            AppMethodBeat.m2505o(59874);
            return false;
        } else if (C1855t.m3922nH(str)) {
            AppMethodBeat.m2505o(59874);
            return false;
        } else {
            AppMethodBeat.m2505o(59874);
            return true;
        }
    }
}
