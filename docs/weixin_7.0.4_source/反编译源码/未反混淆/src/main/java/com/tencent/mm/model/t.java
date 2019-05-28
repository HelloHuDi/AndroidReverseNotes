package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bcm;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class t {
    private static ah fkO = null;
    public static final String fkP = b("rconversation.username", new String[]{"@im.chatroom", "@chatroom", "@openim", "@micromsg.qq.com"});
    public static final String fkQ = b("rconversation.username", new String[]{"@chatroom", "@micromsg.qq.com"});
    public static final String fkR = b("rconversation.username", new String[]{"@t.qq.com"});
    public static final String fkS = b("rconversation.username", new String[]{"@qqim"});
    public static final String fkT = b("rconversation.username", new String[]{"@chatroom_exclusive"});
    public static final String fkU = b("rconversation.username", new String[]{"@micromsg.qq.com"});
    public static final String fkV = b("rconversation.username", new String[]{"@app"});
    public static final String fkW = b("rconversation.username", new String[]{"@chatroom"});
    public static final String fkX = b("rconversation.username", new String[]{"@im.chatroom"});
    public static final String[] fkY = new String[]{"qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg"};

    static {
        AppMethodBeat.i(59878);
        AppMethodBeat.o(59878);
    }

    public static void a(ah ahVar) {
        fkO = ahVar;
    }

    public static boolean mM(String str) {
        AppMethodBeat.i(59780);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59780);
            return false;
        } else if (!str.contains("@") || str.endsWith("@micromsg.qq.com")) {
            AppMethodBeat.o(59780);
            return true;
        } else {
            AppMethodBeat.o(59780);
            return false;
        }
    }

    public static boolean mN(String str) {
        AppMethodBeat.i(59781);
        if (mO(str) || mP(str)) {
            AppMethodBeat.o(59781);
            return true;
        }
        AppMethodBeat.o(59781);
        return false;
    }

    public static boolean mO(String str) {
        AppMethodBeat.i(59782);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59782);
            return false;
        }
        boolean endsWith = str.endsWith("@chatroom");
        AppMethodBeat.o(59782);
        return endsWith;
    }

    public static boolean kH(String str) {
        AppMethodBeat.i(59783);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59783);
            return false;
        } else if (str.endsWith("@chatroom") || str.endsWith("@im.chatroom")) {
            AppMethodBeat.o(59783);
            return true;
        } else {
            AppMethodBeat.o(59783);
            return false;
        }
    }

    public static boolean mP(String str) {
        AppMethodBeat.i(59784);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59784);
            return false;
        }
        boolean endsWith = str.endsWith("@im.chatroom");
        AppMethodBeat.o(59784);
        return endsWith;
    }

    public static boolean mQ(String str) {
        AppMethodBeat.i(59785);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59785);
            return false;
        }
        boolean endsWith = str.endsWith("@qy_u");
        AppMethodBeat.o(59785);
        return endsWith;
    }

    public static boolean mR(String str) {
        AppMethodBeat.i(59786);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59786);
            return false;
        }
        boolean endsWith = str.endsWith("@bottle");
        AppMethodBeat.o(59786);
        return endsWith;
    }

    public static boolean mS(String str) {
        AppMethodBeat.i(59787);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59787);
            return false;
        }
        boolean endsWith = str.endsWith("@qqim");
        AppMethodBeat.o(59787);
        return endsWith;
    }

    public static boolean mT(String str) {
        AppMethodBeat.i(59788);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59788);
            return false;
        }
        boolean endsWith = str.endsWith("@lbsroom");
        AppMethodBeat.o(59788);
        return endsWith;
    }

    public static boolean e(ad adVar) {
        AppMethodBeat.i(59789);
        if (adVar == null) {
            AppMethodBeat.o(59789);
            return false;
        } else if (!mN(adVar.field_username)) {
            AppMethodBeat.o(59789);
            return false;
        } else if (a.jh(adVar.field_type)) {
            AppMethodBeat.o(59789);
            return true;
        } else {
            AppMethodBeat.o(59789);
            return false;
        }
    }

    public static boolean mU(String str) {
        AppMethodBeat.i(59790);
        boolean equals = "gh_43f2581f6fd6".equals(str);
        AppMethodBeat.o(59790);
        return equals;
    }

    public static boolean mV(String str) {
        AppMethodBeat.i(59791);
        boolean equals = "downloaderapp".equals(str);
        AppMethodBeat.o(59791);
        return equals;
    }

    public static boolean mW(String str) {
        AppMethodBeat.i(59792);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59792);
            return false;
        } else if (mN(str)) {
            ad aoO = ((j) g.K(j.class)).XM().aoO(str);
            if (aoO == null || !a.jh(aoO.field_type)) {
                AppMethodBeat.o(59792);
                return false;
            }
            AppMethodBeat.o(59792);
            return true;
        } else {
            AppMethodBeat.o(59792);
            return false;
        }
    }

    public static boolean mX(String str) {
        AppMethodBeat.i(59793);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59793);
            return false;
        }
        boolean endsWith = str.endsWith("@stranger");
        AppMethodBeat.o(59793);
        return endsWith;
    }

    public static List<String> Zh() {
        AppMethodBeat.i(59794);
        List dsr = ((j) g.K(j.class)).XM().dsr();
        AppMethodBeat.o(59794);
        return dsr;
    }

    public static List<ad> Zi() {
        AppMethodBeat.i(59795);
        ArrayList arrayList = new ArrayList();
        Cursor dss = ((j) g.K(j.class)).XM().dss();
        if (dss.moveToFirst()) {
            do {
                ad adVar = new ad();
                adVar.d(dss);
                arrayList.add(adVar);
            } while (dss.moveToNext());
        }
        dss.close();
        AppMethodBeat.o(59795);
        return arrayList;
    }

    public static String a(ad adVar, String str) {
        AppMethodBeat.i(59796);
        if (adVar == null) {
            AppMethodBeat.o(59796);
            return str;
        }
        if (mN(str) && bo.isNullOrNil(adVar.field_nickname)) {
            String mJ = ((c) g.K(c.class)).XV().mJ(str);
            if (!bo.isNullOrNil(mJ)) {
                AppMethodBeat.o(59796);
                return mJ;
            }
        }
        if (adVar.Oj() == null || adVar.Oj().length() <= 0) {
            AppMethodBeat.o(59796);
            return str;
        }
        str = adVar.Oj();
        AppMethodBeat.o(59796);
        return str;
    }

    public static boolean mY(String str) {
        AppMethodBeat.i(59797);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59797);
            return true;
        }
        boolean jh = a.jh(((j) g.K(j.class)).XM().aoO(str).field_type);
        AppMethodBeat.o(59797);
        return jh;
    }

    public static boolean mZ(String str) {
        AppMethodBeat.i(59798);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59798);
            return false;
        }
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.o(59798);
            return false;
        }
        boolean Mn = ad.Mn(aoO.field_verifyFlag);
        AppMethodBeat.o(59798);
        return Mn;
    }

    public static boolean kv(int i) {
        AppMethodBeat.i(59799);
        boolean Mn = ad.Mn(i);
        AppMethodBeat.o(59799);
        return Mn;
    }

    public static void f(ad adVar) {
        AppMethodBeat.i(59800);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (!(aoO == null || bo.isNullOrNil(aoO.field_username))) {
            adVar = aoO;
        }
        adVar.NH();
        u(adVar);
        AppMethodBeat.o(59800);
    }

    public static void v(String str, boolean z) {
        AppMethodBeat.i(59801);
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            AppMethodBeat.o(59801);
            return;
        }
        if (z) {
            aoO.NQ();
        } else {
            aoO.NR();
        }
        t(aoO);
        AppMethodBeat.o(59801);
    }

    public static void g(ad adVar) {
        AppMethodBeat.i(59802);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (!(aoO == null || bo.isNullOrNil(aoO.field_username))) {
            adVar = aoO;
        }
        adVar.NF();
        u(adVar);
        AppMethodBeat.o(59802);
    }

    public static void h(ad adVar) {
        AppMethodBeat.i(59803);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (!(aoO == null || bo.isNullOrNil(aoO.field_username))) {
            adVar = aoO;
        }
        adVar.NG();
        u(adVar);
        AppMethodBeat.o(59803);
    }

    public static void i(ad adVar) {
        AppMethodBeat.i(59804);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            aoO = adVar;
        }
        aoO.ND();
        if (ad.aox(adVar.field_username) && fkO != null) {
            fkO.ok(adVar.field_username);
        }
        u(aoO);
        AppMethodBeat.o(59804);
    }

    public static void j(ad adVar) {
        AppMethodBeat.i(59805);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            aoO = adVar;
        }
        aoO.NE();
        if (ad.aox(adVar.field_username) && fkO != null) {
            fkO.ol(adVar.field_username);
        }
        u(aoO);
        ak aoZ = ((j) g.K(j.class)).XR().aoZ(adVar.field_username);
        if (aoZ != null && "@blacklist".equals(aoZ.field_parentRef)) {
            ((j) g.K(j.class)).XR().c(new String[]{aoZ.field_username}, "");
        }
        AppMethodBeat.o(59805);
    }

    public static void k(ad adVar) {
        AppMethodBeat.i(59806);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            aoO = adVar;
        }
        aoO.NQ();
        aoO.hu(adVar.Ny());
        t(aoO);
        AppMethodBeat.o(59806);
    }

    public static void l(ad adVar) {
        AppMethodBeat.i(59807);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            aoO = adVar;
        }
        aoO.NR();
        aoO.hu(adVar.Ny());
        t(aoO);
        AppMethodBeat.o(59807);
    }

    public static void m(ad adVar) {
        AppMethodBeat.i(59808);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            aoO = adVar;
        }
        aoO.NM();
        aoO.hu(adVar.Ny());
        if (ad.aox(adVar.field_username) && fkO != null) {
            fkO.om(adVar.field_username);
        }
        u(aoO);
        AppMethodBeat.o(59808);
    }

    public static void n(ad adVar) {
        AppMethodBeat.i(59809);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            aoO = adVar;
        }
        aoO.NN();
        aoO.hu(adVar.Ny());
        if (ad.aox(adVar.field_username) && fkO != null) {
            fkO.on(adVar.field_username);
        }
        u(aoO);
        AppMethodBeat.o(59809);
    }

    public static void w(String str, boolean z) {
        AppMethodBeat.i(59810);
        Assert.assertTrue(!bo.isNullOrNil(str));
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            AppMethodBeat.o(59810);
            return;
        }
        aoO.setType(aoO.field_type | 2048);
        if ((ad.aox(str) || mP(str)) && fkO != null) {
            fkO.oi(str);
        }
        u(aoO);
        if (z) {
            ((j) g.K(j.class)).XR().apf(str);
        }
        AppMethodBeat.o(59810);
    }

    public static void na(String str) {
        AppMethodBeat.i(59811);
        ak aoZ = ((j) g.K(j.class)).XR().aoZ(str);
        Object obj = null;
        if (aoZ == null) {
            aoZ = new ak();
            aoZ.dsI();
            obj = 1;
            aoZ.setUsername(str);
        }
        aoZ.eD(System.currentTimeMillis());
        if (obj != null) {
            ((j) g.K(j.class)).XR().d(aoZ);
            AppMethodBeat.o(59811);
            return;
        }
        ((j) g.K(j.class)).XR().a(aoZ, str);
        AppMethodBeat.o(59811);
    }

    public static void x(String str, boolean z) {
        AppMethodBeat.i(59812);
        Assert.assertTrue(!bo.isNullOrNil(str));
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            AppMethodBeat.o(59812);
            return;
        }
        aoO.setType(aoO.field_type & -2049);
        if ((ad.aox(str) || mP(str)) && fkO != null) {
            fkO.oj(str);
        }
        u(aoO);
        if (z) {
            ((j) g.K(j.class)).XR().apg(str);
        }
        AppMethodBeat.o(59812);
    }

    public static void o(ad adVar) {
        AppMethodBeat.i(59813);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            aoO = adVar;
        }
        aoO.NO();
        if (ad.aox(adVar.field_username) && fkO != null) {
            fkO.oo(adVar.field_username);
        }
        u(aoO);
        AppMethodBeat.o(59813);
    }

    public static void p(ad adVar) {
        AppMethodBeat.i(59814);
        Assert.assertTrue(adVar != null);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        if (aoO == null || bo.isNullOrNil(aoO.field_username)) {
            aoO = adVar;
        }
        aoO.NP();
        if (ad.aox(adVar.field_username) && fkO != null) {
            fkO.op(adVar.field_username);
        }
        u(aoO);
        AppMethodBeat.o(59814);
    }

    public static void q(ad adVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(59815);
        Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", adVar != null);
        String str = "MicroMsg.ContactStorageLogic: contactId == 0";
        if (((int) adVar.ewQ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        String str2 = "MicroMsg.ContactStorageLogic: username length <= 0";
        if (adVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        adVar.NB();
        ((j) g.K(j.class)).XM().b(adVar.field_username, adVar);
        AppMethodBeat.o(59815);
    }

    public static void r(ad adVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(59816);
        if (adVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) adVar.ewQ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (adVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        adVar.NB();
        ((j) g.K(j.class)).XM().b(adVar.field_username, adVar);
        u(adVar);
        AppMethodBeat.o(59816);
    }

    public static void b(ad adVar, String str) {
        AppMethodBeat.i(59817);
        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        boolean z = (aoO == null || str == null) ? false : true;
        Assert.assertTrue(z);
        aoO.iz(str);
        if (ad.aox(adVar.field_username) && fkO != null) {
            fkO.ah(adVar.field_username, str);
        }
        u(aoO);
        AppMethodBeat.o(59817);
    }

    public static void s(ad adVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(59818);
        if (adVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) adVar.ewQ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (adVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        adVar.Og();
        u(adVar);
        AppMethodBeat.o(59818);
    }

    private static void t(ad adVar) {
        boolean z;
        AppMethodBeat.i(59819);
        if (adVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) adVar.ewQ) == 0) {
            ((j) g.K(j.class)).XM().aa(adVar);
            ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        }
        ((j) g.K(j.class)).XM().b(adVar.field_username, adVar);
        bcm bcm = new bcm();
        bcm.wGA = adVar.field_username;
        if (adVar.Od()) {
            bcm.wGN = 1;
        } else {
            bcm.wGN = 2;
        }
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(52, bcm));
        AppMethodBeat.o(59819);
    }

    public static void u(ad adVar) {
        boolean z;
        AppMethodBeat.i(59820);
        if (adVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (((int) adVar.ewQ) == 0) {
            ((j) g.K(j.class)).XM().aa(adVar);
            ((j) g.K(j.class)).XM().aoO(adVar.field_username);
        }
        ((j) g.K(j.class)).XM().b(adVar.field_username, adVar);
        if (!ad.aox(adVar.field_username)) {
            v(adVar);
        }
        AppMethodBeat.o(59820);
    }

    public static void v(ad adVar) {
        AppMethodBeat.i(59821);
        ab.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", adVar.field_username, adVar.field_conRemark, Integer.valueOf(adVar.field_type));
        bbv bbv = new bbv();
        bbv.wcB = new bts().alV(bo.nullAsNil(adVar.field_username));
        bbv.wyX = new bts().alV(bo.nullAsNil(adVar.field_nickname));
        bbv.wce = new bts().alV(bo.nullAsNil(adVar.Ht()));
        bbv.wcf = new bts().alV(bo.nullAsNil(adVar.Hu()));
        bbv.guN = adVar.dtS;
        bbv.wbu = 561023;
        bbv.wbv = adVar.field_type;
        bbv.wFK = new bts().alV(bo.nullAsNil(adVar.field_conRemark));
        bbv.wFL = new bts().alV(bo.nullAsNil(adVar.field_conRemarkPYShort));
        bbv.wFM = new bts().alV(bo.nullAsNil(adVar.field_conRemarkPYFull));
        bbv.wbA = adVar.dtX;
        bbv.wGf = new bts().alV(bo.nullAsNil(adVar.field_domainList));
        bbv.wbE = adVar.dua;
        bbv.guR = adVar.dub;
        bbv.guQ = bo.nullAsNil(adVar.signature);
        bbv.guP = bo.nullAsNil(adVar.getCityCode());
        bbv.guO = bo.nullAsNil(adVar.dsj());
        bbv.wBV = bo.nullAsNil(adVar.dug);
        bbv.wBX = adVar.field_weiboFlag;
        bbv.wGb = 0;
        bbv.vEF = new SKBuiltinBuffer_t();
        bbv.guW = bo.nullAsNil(adVar.getCountryCode());
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(2, bbv));
        AppMethodBeat.o(59821);
    }

    public static void nb(String str) {
        AppMethodBeat.i(59822);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59822);
            return;
        }
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.o(59822);
            return;
        }
        aoO.setSource(0);
        aoO.Nz();
        ((j) g.K(j.class)).XM().b(str, aoO);
        AppMethodBeat.o(59822);
    }

    public static int[] a(String str, String str2, List<String> list, String str3) {
        AppMethodBeat.i(59823);
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((j) g.K(j.class)).XM().b(str, str2, str3, (List) list);
        ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            AppMethodBeat.o(59823);
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] c = ((j) g.K(j.class)).XM().c(str, str2, str3, (List) list);
        ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (c == null) {
            AppMethodBeat.o(59823);
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
        AppMethodBeat.o(59823);
        return iArr;
    }

    public static int[] V(List<String> list) {
        AppMethodBeat.i(59824);
        long currentTimeMillis = System.currentTimeMillis();
        int[] eF = ((j) g.K(j.class)).XM().eF(list);
        ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (eF.length <= 0) {
            AppMethodBeat.o(59824);
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] eG = ((j) g.K(j.class)).XM().eG(list);
        ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (eG == null) {
            AppMethodBeat.o(59824);
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
        AppMethodBeat.o(59824);
        return iArr;
    }

    public static int[] a(String str, String str2, List<String> list, String[] strArr) {
        AppMethodBeat.i(59825);
        int[] b = ((j) g.K(j.class)).XM().b(str, str2, strArr, (List) list);
        if (b.length <= 0) {
            AppMethodBeat.o(59825);
            return null;
        }
        int[] c = ((j) g.K(j.class)).XM().c(str, str2, strArr, (List) list);
        if (c == null) {
            AppMethodBeat.o(59825);
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
        AppMethodBeat.o(59825);
        return iArr;
    }

    public static String[] a(String str, String str2, String[] strArr, List<String> list) {
        int i = 0;
        AppMethodBeat.i(59826);
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((j) g.K(j.class)).XM().b(str, str2, strArr, (List) list);
        ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            AppMethodBeat.o(59826);
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
                AppMethodBeat.o(59826);
                return strArr2;
            }
        }
    }

    public static String[] a(String str, String str2, String str3, List<String> list) {
        int i = 0;
        AppMethodBeat.i(59827);
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((j) g.K(j.class)).XM().b(str, str2, str3, (List) list);
        ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            AppMethodBeat.o(59827);
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
                AppMethodBeat.o(59827);
                return strArr;
            }
        }
    }

    public static String[] W(List<String> list) {
        int i = 0;
        AppMethodBeat.i(59828);
        long currentTimeMillis = System.currentTimeMillis();
        int[] eF = ((j) g.K(j.class)).XM().eF(list);
        ab.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (eF.length <= 0) {
            AppMethodBeat.o(59828);
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
                AppMethodBeat.o(59828);
                return strArr;
            }
        }
    }

    public static boolean nc(String str) {
        AppMethodBeat.i(59829);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("qqmail");
            AppMethodBeat.o(59829);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59829);
        return false;
    }

    public static boolean nd(String str) {
        AppMethodBeat.i(59830);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("fmessage");
            AppMethodBeat.o(59830);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59830);
        return false;
    }

    public static boolean ne(String str) {
        AppMethodBeat.i(59831);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("tmessage");
            AppMethodBeat.o(59831);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59831);
        return false;
    }

    public static boolean nf(String str) {
        AppMethodBeat.i(59832);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("floatbottle");
            AppMethodBeat.o(59832);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59832);
        return false;
    }

    public static boolean ng(String str) {
        AppMethodBeat.i(59833);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("qmessage");
            AppMethodBeat.o(59833);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59833);
        return false;
    }

    public static boolean nh(String str) {
        AppMethodBeat.i(59834);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("facebookapp");
            AppMethodBeat.o(59834);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59834);
        return false;
    }

    public static boolean ni(String str) {
        AppMethodBeat.i(59835);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("masssendapp");
            AppMethodBeat.o(59835);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59835);
        return false;
    }

    public static boolean Zj() {
        return false;
    }

    public static boolean nj(String str) {
        AppMethodBeat.i(59836);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("feedsapp");
            AppMethodBeat.o(59836);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59836);
        return false;
    }

    public static boolean nk(String str) {
        AppMethodBeat.i(59837);
        boolean equalsIgnoreCase = "qqsync".equalsIgnoreCase(str);
        AppMethodBeat.o(59837);
        return equalsIgnoreCase;
    }

    public static boolean nl(String str) {
        AppMethodBeat.i(59838);
        if (str == null) {
            AppMethodBeat.o(59838);
            return false;
        } else if (str.equalsIgnoreCase("weixin") || str.equalsIgnoreCase("gh_9639b5a92773")) {
            AppMethodBeat.o(59838);
            return true;
        } else {
            AppMethodBeat.o(59838);
            return false;
        }
    }

    public static boolean nm(String str) {
        AppMethodBeat.i(59839);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("lbsapp");
            AppMethodBeat.o(59839);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59839);
        return false;
    }

    public static boolean nn(String str) {
        AppMethodBeat.i(59840);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("shakeapp");
            AppMethodBeat.o(59840);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59840);
        return false;
    }

    public static boolean no(String str) {
        AppMethodBeat.i(59841);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("medianote");
            AppMethodBeat.o(59841);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59841);
        return false;
    }

    public static boolean np(String str) {
        AppMethodBeat.i(59842);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("newsapp");
            AppMethodBeat.o(59842);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59842);
        return false;
    }

    public static boolean nq(String str) {
        AppMethodBeat.i(59843);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("topstoryapp");
            AppMethodBeat.o(59843);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59843);
        return false;
    }

    public static boolean nr(String str) {
        AppMethodBeat.i(59844);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("voipapp");
            AppMethodBeat.o(59844);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59844);
        return false;
    }

    public static boolean ns(String str) {
        AppMethodBeat.i(59845);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("voicevoipapp");
            AppMethodBeat.o(59845);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59845);
        return false;
    }

    public static boolean nt(String str) {
        AppMethodBeat.i(59846);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("voiceinputapp");
            AppMethodBeat.o(59846);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59846);
        return false;
    }

    public static boolean nu(String str) {
        AppMethodBeat.i(59847);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("linkedinplugin");
            AppMethodBeat.o(59847);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59847);
        return false;
    }

    public static boolean nv(String str) {
        AppMethodBeat.i(59848);
        boolean nw = nw(str);
        AppMethodBeat.o(59848);
        return nw;
    }

    public static boolean nw(String str) {
        AppMethodBeat.i(59849);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("gh_22b87fa7cb3c");
            AppMethodBeat.o(59849);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59849);
        return false;
    }

    public static boolean nx(String str) {
        AppMethodBeat.i(59850);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("blogapp");
            AppMethodBeat.o(59850);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59850);
        return false;
    }

    public static boolean ny(String str) {
        AppMethodBeat.i(59851);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("officialaccounts");
            AppMethodBeat.o(59851);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59851);
        return false;
    }

    public static boolean nz(String str) {
        AppMethodBeat.i(59852);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("helper_entry");
            AppMethodBeat.o(59852);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59852);
        return false;
    }

    public static boolean nA(String str) {
        AppMethodBeat.i(59853);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("qqfriend");
            AppMethodBeat.o(59853);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59853);
        return false;
    }

    public static boolean nB(String str) {
        AppMethodBeat.i(59854);
        boolean equalsIgnoreCase = "filehelper".equalsIgnoreCase(str);
        AppMethodBeat.o(59854);
        return equalsIgnoreCase;
    }

    public static boolean nC(String str) {
        AppMethodBeat.i(59855);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("pc_share");
            AppMethodBeat.o(59855);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59855);
        return false;
    }

    public static boolean nD(String str) {
        AppMethodBeat.i(59856);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("notifymessage");
            AppMethodBeat.o(59856);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59856);
        return false;
    }

    public static boolean nE(String str) {
        AppMethodBeat.i(59857);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("notification_messages");
            AppMethodBeat.o(59857);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59857);
        return false;
    }

    public static boolean nF(String str) {
        AppMethodBeat.i(59858);
        if (nG(str)) {
            AppMethodBeat.o(59858);
            return true;
        } else if (nI(str)) {
            AppMethodBeat.o(59858);
            return true;
        } else if (ny(str)) {
            AppMethodBeat.o(59858);
            return true;
        } else if (nz(str)) {
            AppMethodBeat.o(59858);
            return true;
        } else {
            AppMethodBeat.o(59858);
            return false;
        }
    }

    public static boolean nG(String str) {
        AppMethodBeat.i(59859);
        g.RQ();
        String str2 = (String) g.RP().Ry().get(21, null);
        if ((str2 == null || !str2.equalsIgnoreCase(str)) && !str.equalsIgnoreCase("weixin")) {
            AppMethodBeat.o(59859);
            return false;
        }
        AppMethodBeat.o(59859);
        return true;
    }

    public static boolean nH(String str) {
        AppMethodBeat.i(59860);
        if (str != null) {
            boolean equalsIgnoreCase = str.equalsIgnoreCase("appbrandcustomerservicemsg");
            AppMethodBeat.o(59860);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(59860);
        return false;
    }

    public static boolean nI(String str) {
        AppMethodBeat.i(59861);
        for (String equalsIgnoreCase : fkY) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                AppMethodBeat.o(59861);
                return true;
            }
        }
        AppMethodBeat.o(59861);
        return false;
    }

    public static boolean nJ(String str) {
        AppMethodBeat.i(59862);
        if (nI(str)) {
            AppMethodBeat.o(59862);
            return true;
        } else if (ad.aow(str)) {
            AppMethodBeat.o(59862);
            return true;
        } else if (ad.aou(str)) {
            AppMethodBeat.o(59862);
            return true;
        } else if (ad.mR(str)) {
            AppMethodBeat.o(59862);
            return true;
        } else {
            AppMethodBeat.o(59862);
            return false;
        }
    }

    public static int nK(String str) {
        AppMethodBeat.i(59863);
        Assert.assertTrue(bo.nullAsNil(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            AppMethodBeat.o(59863);
            return 1;
        } else if (ad.aou(toLowerCase)) {
            AppMethodBeat.o(59863);
            return 11;
        } else if (ad.aow(toLowerCase)) {
            AppMethodBeat.o(59863);
            return 36;
        } else if (ad.mR(toLowerCase)) {
            AppMethodBeat.o(59863);
            return 1;
        } else {
            AppMethodBeat.o(59863);
            return 1;
        }
    }

    public static int nL(String str) {
        AppMethodBeat.i(59864);
        Assert.assertTrue(bo.nullAsNil(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            AppMethodBeat.o(59864);
            return 3;
        } else if (ad.aou(toLowerCase)) {
            AppMethodBeat.o(59864);
            return 13;
        } else if (ad.aow(toLowerCase)) {
            AppMethodBeat.o(59864);
            return 39;
        } else if (ad.mR(toLowerCase)) {
            AppMethodBeat.o(59864);
            return 3;
        } else if (toLowerCase.contains("@")) {
            AppMethodBeat.o(59864);
            return 3;
        } else {
            AppMethodBeat.o(59864);
            return 3;
        }
    }

    public static boolean nM(String str) {
        AppMethodBeat.i(59865);
        if (((j) g.K(j.class)).XM().aoO(str).dua != 1) {
            AppMethodBeat.o(59865);
            return false;
        }
        AppMethodBeat.o(59865);
        return true;
    }

    public static boolean nN(String str) {
        AppMethodBeat.i(59866);
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null || !aoO.DX()) {
            AppMethodBeat.o(59866);
            return false;
        }
        AppMethodBeat.o(59866);
        return true;
    }

    public static boolean nO(String str) {
        AppMethodBeat.i(59867);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(59867);
            return false;
        } else if (str.startsWith("t.qq.com/") || str.startsWith("http://t.qq.com/")) {
            AppMethodBeat.o(59867);
            return true;
        } else {
            AppMethodBeat.o(59867);
            return false;
        }
    }

    public static String nP(String str) {
        AppMethodBeat.i(59868);
        String replace;
        if (nO(str)) {
            replace = str.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
            AppMethodBeat.o(59868);
            return replace;
        }
        replace = "";
        AppMethodBeat.o(59868);
        return replace;
    }

    public static boolean Zk() {
        AppMethodBeat.i(59869);
        if (r.Ze()) {
            bq RA = ((j) g.K(j.class)).XU().RA("@t.qq.com");
            if (RA == null || bo.isNullOrNil(RA.name)) {
                AppMethodBeat.o(59869);
                return false;
            }
            AppMethodBeat.o(59869);
            return true;
        }
        AppMethodBeat.o(59869);
        return false;
    }

    public static boolean Zl() {
        AppMethodBeat.i(59870);
        if (r.Ze()) {
            bq RA = ((j) g.K(j.class)).XU().RA("@t.qq.com");
            if (RA == null || bo.nullAsNil(RA.name).length() == 0) {
                AppMethodBeat.o(59870);
                return false;
            }
            AppMethodBeat.o(59870);
            return true;
        }
        AppMethodBeat.o(59870);
        return false;
    }

    public static List<ad> Zm() {
        AppMethodBeat.i(59871);
        LinkedList linkedList = new LinkedList();
        Cursor dsv = ((j) g.K(j.class)).XM().dsv();
        if (dsv.getCount() == 0) {
            dsv.close();
            AppMethodBeat.o(59871);
            return linkedList;
        }
        dsv.moveToFirst();
        do {
            ad adVar = new ad();
            adVar.d(dsv);
            linkedList.add(adVar);
        } while (dsv.moveToNext());
        dsv.close();
        ab.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + linkedList.size());
        AppMethodBeat.o(59871);
        return linkedList;
    }

    public static List<String> Zn() {
        AppMethodBeat.i(59872);
        LinkedList linkedList = new LinkedList();
        Cursor dst = ((j) g.K(j.class)).XM().dst();
        if (dst.getCount() == 0) {
            dst.close();
            AppMethodBeat.o(59872);
            return linkedList;
        }
        dst.moveToFirst();
        do {
            ad adVar = new ad();
            adVar.d(dst);
            linkedList.add(adVar.field_username);
        } while (dst.moveToNext());
        dst.close();
        ab.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + linkedList.size());
        AppMethodBeat.o(59872);
        return linkedList;
    }

    public static int Zo() {
        AppMethodBeat.i(59875);
        int b = ((j) g.K(j.class)).XM().b(fkY, r.Yz(), "weixin", "helper_entry", "filehelper");
        AppMethodBeat.o(59875);
        return b;
    }

    private static String b(String str, String[] strArr) {
        AppMethodBeat.i(59876);
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
        AppMethodBeat.o(59876);
        return str2;
    }

    public static boolean nQ(String str) {
        AppMethodBeat.i(59877);
        if (str.equals("weixinsrc") || str.equalsIgnoreCase("gh_6e99ff560306")) {
            AppMethodBeat.o(59877);
            return true;
        }
        AppMethodBeat.o(59877);
        return false;
    }

    public static boolean w(ad adVar) {
        return (adVar.field_weiboFlag & 1) != 0;
    }

    public static boolean a(ak akVar) {
        AppMethodBeat.i(59873);
        String str = akVar.field_username;
        if (nI(str)) {
            AppMethodBeat.o(59873);
            return false;
        } else if (nG(str)) {
            AppMethodBeat.o(59873);
            return false;
        } else if (ny(str)) {
            AppMethodBeat.o(59873);
            return false;
        } else if (nz(str)) {
            AppMethodBeat.o(59873);
            return false;
        } else if (akVar.field_conversationTime == -1) {
            AppMethodBeat.o(59873);
            return false;
        } else if (mZ(str)) {
            AppMethodBeat.o(59873);
            return true;
        } else {
            AppMethodBeat.o(59873);
            return true;
        }
    }

    public static boolean b(ak akVar) {
        AppMethodBeat.i(59874);
        String str = akVar.field_username;
        if (ny(str)) {
            AppMethodBeat.o(59874);
            return false;
        } else if (nH(str)) {
            AppMethodBeat.o(59874);
            return false;
        } else {
            AppMethodBeat.o(59874);
            return true;
        }
    }
}
