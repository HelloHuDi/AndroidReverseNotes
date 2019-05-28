package com.tencent.p177mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p217ci.C41931h;
import com.tencent.p177mm.p230g.p231a.C32648tu;
import com.tencent.p177mm.p230g.p231a.C45378va;
import com.tencent.p177mm.p230g.p231a.C6533on;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C22565a;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C22566g;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C22567h;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C22568i;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C22569j;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C29620f;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C40097c;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C43791d;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C43792e;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.protocal.protobuf.bic;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
import com.tencent.p177mm.wallet_core.p760d.C46722e;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.r */
public class C14241r implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C1837a old = new C142587();
    private volatile C4397t tBM = new C4397t();
    private C41931h<C22587ak> tBN = new C41931h(new C142541());
    private volatile C43803ae tBO = null;
    private C41931h<C22585ah> tBP = new C41931h(new C1426312());
    private C41931h<C22569j> tBQ = new C41931h(new C1424318());
    private C41931h<C40097c> tBR = new C41931h(new C1425119());
    private C41931h<C22565a> tBS = new C41931h(new C1425220());
    private C41931h<C29620f> tBT = new C41931h(new C439421());
    private C41931h<C43791d> tBU = new C41931h(new C1424422());
    private C35483x tBV = new C35483x();
    private C41931h<C43792e> tBW = new C41931h(new C439523());
    private C41931h<C22568i> tBX = new C41931h(new C439624());
    private C41931h<C22567h> tBY = new C41931h(new C142502());
    private C41931h<C22566g> tBZ = new C41931h(new C142453());
    private C43795a tCa = new C43795a();
    private C4884c tCb = new C142464();
    private String tCc = "";
    private C4884c<C32648tu> tCd = new C142475();
    private C4884c<C45378va> tCe = new C142576();

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$21 */
    class C439421 implements C32467c<C29620f> {
        C439421() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46861);
            C1720g.m3537RQ();
            C29620f c29620f = new C29620f(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(46861);
            return c29620f;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$23 */
    class C439523 implements C32467c<C43792e> {
        C439523() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46863);
            C1720g.m3537RQ();
            C43792e c43792e = new C43792e(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(46863);
            return c43792e;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$24 */
    class C439624 implements C32467c<C22568i> {
        C439624() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46864);
            C1720g.m3537RQ();
            C22568i c22568i = new C22568i(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(46864);
            return c22568i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$11 */
    static class C1424011 implements C1366d {
        C1424011() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C29620f.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$16 */
    static class C1424216 implements C1366d {
        C1424216() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C22568i.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$18 */
    class C1424318 implements C32467c<C22569j> {
        C1424318() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46858);
            C1720g.m3537RQ();
            C22569j c22569j = new C22569j(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(46858);
            return c22569j;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$22 */
    class C1424422 implements C32467c<C43791d> {
        C1424422() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46862);
            C1720g.m3537RQ();
            C43791d c43791d = new C43791d(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(46862);
            return c43791d;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$3 */
    class C142453 implements C32467c<C22566g> {
        C142453() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46848);
            C1720g.m3537RQ();
            C22566g c22566g = new C22566g(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(46848);
            return c22566g;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$4 */
    class C142464 extends C4884c<C6533on> {
        C142464() {
            AppMethodBeat.m2504i(46849);
            this.xxI = C6533on.class.getName().hashCode();
            AppMethodBeat.m2505o(46849);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(46850);
            C6533on c6533on = (C6533on) c4883b;
            C14241r.m22433B(c6533on.cKQ.context, c6533on.cKQ.intent);
            AppMethodBeat.m2505o(46850);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$5 */
    class C142475 extends C4884c<C32648tu> {
        C142475() {
            AppMethodBeat.m2504i(46851);
            this.xxI = C32648tu.class.getName().hashCode();
            AppMethodBeat.m2505o(46851);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(46852);
            C32648tu c32648tu = (C32648tu) c4883b;
            if (c32648tu.cPV.cvz == 11) {
                List list = c32648tu.cPV.cPW;
                if (list == null || list.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.UpdateMassSendPlaceTopListener", "empty UpdatePackageEvent");
                } else {
                    byte[] a = C1946aa.m4150a(((bic) list.get(0)).vFG);
                    if (a == null || a.length == 0) {
                        AppMethodBeat.m2505o(46852);
                        return false;
                    }
                    String str = new String(a);
                    if (str.equals(C14241r.this.tCc)) {
                        C4990ab.m7416i("MicroMsg.UpdateMassSendPlaceTopListener", "the same result : %s".concat(String.valueOf(str)));
                    } else {
                        C4990ab.m7417i("MicroMsg.UpdateMassSendPlaceTopListener", "UpdatePackageEvent: %s", str);
                        C46362b.acL(str);
                        C14241r.this.tCc = str;
                    }
                }
            }
            AppMethodBeat.m2505o(46852);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$10 */
    static class C1424810 implements C1366d {
        C1424810() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C22565a.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$17 */
    static class C1424917 implements C1366d {
        C1424917() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C22566g.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$2 */
    class C142502 implements C32467c<C22567h> {
        C142502() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46847);
            C1720g.m3537RQ();
            C22567h c22567h = new C22567h(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(46847);
            return c22567h;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$19 */
    class C1425119 implements C32467c<C40097c> {
        C1425119() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46859);
            C1720g.m3537RQ();
            C40097c c40097c = new C40097c(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(46859);
            return c40097c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$20 */
    class C1425220 implements C32467c<C22565a> {
        C1425220() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46860);
            C1720g.m3537RQ();
            C22565a c22565a = new C22565a(C1720g.m3536RP().eJN);
            AppMethodBeat.m2505o(46860);
            return c22565a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$13 */
    static class C1425313 implements C1366d {
        C1425313() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C43791d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$1 */
    class C142541 implements C32467c<C22587ak> {
        C142541() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46846);
            C22587ak c22587ak = new C22587ak();
            AppMethodBeat.m2505o(46846);
            return c22587ak;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$14 */
    static class C1425514 implements C1366d {
        C1425514() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C22567h.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$15 */
    static class C1425615 implements C1366d {
        C1425615() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C43792e.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$6 */
    class C142576 extends C4884c<C45378va> {
        C142576() {
            AppMethodBeat.m2504i(46853);
            this.xxI = C45378va.class.getName().hashCode();
            AppMethodBeat.m2505o(46853);
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            C22583ab c22583ab;
            AppMethodBeat.m2504i(46854);
            C45378va c45378va = (C45378va) c4883b;
            C22566g cPF = C14241r.cPF();
            String str = c45378va.cRQ.cRS;
            if (!C5046bo.isNullOrNil(str)) {
                if (C22566g.gms.containsKey(str)) {
                    c22583ab = (C22583ab) C22566g.gms.get(str);
                } else {
                    c22583ab = cPF.acN(str);
                    if (c22583ab != null) {
                        C22566g.gms.put(str, c22583ab);
                    }
                }
                if (c22583ab != null) {
                    c45378va.cRR.cRT = c22583ab.field_hbType;
                    c45378va.cRR.cRU = c22583ab.field_hbStatus;
                    c45378va.cRR.cRV = c22583ab.field_receiveStatus;
                }
                AppMethodBeat.m2505o(46854);
                return false;
            }
            c22583ab = null;
            if (c22583ab != null) {
            }
            AppMethodBeat.m2505o(46854);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$7 */
    class C142587 implements C1837a {
        C142587() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(46856);
            final Map z = C5049br.m7595z(C1946aa.m4148a(c1197a.eAB.vED), "sysmsg");
            if (z == null) {
                AppMethodBeat.m2505o(46856);
                return;
            }
            int i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            C4990ab.m7416i("MicroMsg.SubCoreWalletCore", "got a pay msg, type = ".concat(String.valueOf(i)));
            switch (i) {
                case 16:
                    i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.Flag"), 0);
                    C4990ab.m7416i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
                    if (i == 1) {
                        C4990ab.m7416i("MicroMsg.SubCoreWalletCore", "open wallet");
                        C1853r.m3828YJ();
                        AppMethodBeat.m2505o(46856);
                        return;
                    } else if (i == 2) {
                        C4990ab.m7416i("MicroMsg.SubCoreWalletCore", "close wallet");
                        i = C1853r.m3824YF() & -32769;
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(i));
                        AppMethodBeat.m2505o(46856);
                        return;
                    }
                    break;
                case 17:
                    i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.WalletType"), -1);
                    C4990ab.m7416i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i)));
                    if (i >= 0) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(339975, Integer.valueOf(i));
                        AppMethodBeat.m2505o(46856);
                        return;
                    }
                    break;
                case C2275g.CTRL_INDEX /*37*/:
                    C4990ab.m7417i("MicroMsg.SubCoreWalletCore", "receive c2c content update msg: %s", r1);
                    C1720g.m3537RQ();
                    C1720g.m3539RS().mo10302aa(new Runnable() {
                        /* JADX WARNING: Removed duplicated region for block: B:43:0x0136  */
                        /* JADX WARNING: Removed duplicated region for block: B:43:0x0136  */
                        /* JADX WARNING: Removed duplicated region for block: B:43:0x0136  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            Exception e;
                            Throwable th;
                            AppMethodBeat.m2504i(46855);
                            Cursor cursor = null;
                            Cursor Rz;
                            try {
                                String str;
                                String str2;
                                C7620bi c7620bi;
                                Cursor cursor2;
                                Cursor cursor3;
                                String str3 = (String) z.get(".sysmsg.paymsg.fromusername");
                                String str4 = (String) z.get(".sysmsg.paymsg.tousername");
                                String str5 = (String) z.get(".sysmsg.paymsg.paymsgid");
                                String decode = URLDecoder.decode((String) z.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                                if (C5046bo.isNullOrNil(str3) || str3.equals(C1853r.m3846Yz())) {
                                    str = str4;
                                } else {
                                    str = str3;
                                }
                                if (C1855t.m3896kH(str3)) {
                                    str2 = str3;
                                } else if (C1855t.m3896kH(str4)) {
                                    str2 = str4;
                                } else {
                                    str2 = str;
                                }
                                C4990ab.m7417i("MicroMsg.SubCoreWalletCore", "username: %s, fromUsername: %s, toUsername: %s, talker: %s, payMsgId: %s", C1853r.m3846Yz(), str3, str4, str2, str5);
                                C8910b me = C8910b.m16064me(decode);
                                C4990ab.m7417i("MicroMsg.SubCoreWalletCore", "appMsgContent: %s, appMsg: %s", decode, me);
                                ArrayList<C7620bi> arrayList = new ArrayList();
                                if (me != null) {
                                    Rz = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15272Rz(str2);
                                    if (Rz != null) {
                                        while (Rz.moveToNext()) {
                                            try {
                                                c7620bi = new C7620bi();
                                                c7620bi.mo8995d(Rz);
                                                C8910b me2 = C8910b.m16064me(c7620bi.field_content);
                                                if (!(me2 == null || C5046bo.isNullOrNil(me2.fib) || !me2.fib.equals(me.fib))) {
                                                    C4990ab.m7417i("MicroMsg.SubCoreWalletCore", "update find msg id: %s, talker: %s, sender: %s", Long.valueOf(c7620bi.field_msgId), c7620bi.field_talker, Integer.valueOf(c7620bi.field_isSend));
                                                    if (C1855t.m3896kH(c7620bi.field_talker)) {
                                                        c7620bi.setContent(C1829bf.m3744al(decode, C1829bf.m3762oy(c7620bi.field_content)));
                                                    } else {
                                                        c7620bi.setContent(decode);
                                                    }
                                                    arrayList.add(c7620bi);
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                            }
                                        }
                                    }
                                    cursor2 = Rz;
                                } else {
                                    cursor2 = null;
                                }
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                        cursor2 = null;
                                    } catch (Exception e3) {
                                        cursor3 = cursor2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        AppMethodBeat.m2505o(46855);
                                        throw th;
                                    }
                                }
                                cursor3 = cursor2;
                                try {
                                    C4990ab.m7417i("MicroMsg.SubCoreWalletCore", "updateMsg: %s", arrayList);
                                    if (arrayList.size() > 0) {
                                        for (C7620bi c7620bi2 : arrayList) {
                                            C4990ab.m7417i("MicroMsg.SubCoreWalletCore", "do update msg: %s %s", Long.valueOf(c7620bi2.field_msgId), c7620bi2.field_content);
                                            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c7620bi2.field_msgId, c7620bi2);
                                        }
                                    }
                                    if (cursor3 != null) {
                                        cursor3.close();
                                        AppMethodBeat.m2505o(46855);
                                        return;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    Rz = cursor3;
                                    try {
                                        C4990ab.printErrStackTrace("MicroMsg.SubCoreWalletCore", e, "parse c2c content update msg error", e.getMessage());
                                        if (Rz != null) {
                                            Rz.close();
                                            AppMethodBeat.m2505o(46855);
                                            return;
                                        }
                                        AppMethodBeat.m2505o(46855);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor = Rz;
                                        if (cursor != null) {
                                        }
                                        AppMethodBeat.m2505o(46855);
                                        throw th;
                                    }
                                } catch (Throwable th32) {
                                    th = th32;
                                    cursor = cursor3;
                                    if (cursor != null) {
                                    }
                                    AppMethodBeat.m2505o(46855);
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                Rz = null;
                            } catch (Throwable th322) {
                                th = th322;
                                if (cursor != null) {
                                }
                                AppMethodBeat.m2505o(46855);
                                throw th;
                            }
                            AppMethodBeat.m2505o(46855);
                        }
                    });
                    break;
            }
            AppMethodBeat.m2505o(46856);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$8 */
    static class C142608 implements C1366d {
        C142608() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C22569j.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$9 */
    static class C142619 implements C1366d {
        C142619() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C40097c.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$a */
    static class C14262a implements C44041a {
        C14262a() {
        }

        /* renamed from: a */
        public final boolean mo7165a(Context context, String[] strArr, String str) {
            AppMethodBeat.m2504i(46865);
            String str2 = strArr[0];
            int i = -1;
            switch (str2.hashCode()) {
                case -1912590262:
                    if (str2.equals("//cleanpaycn")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    C40928b.dNJ();
                    C40928b.clean();
                    AppMethodBeat.m2505o(46865);
                    return true;
                default:
                    AppMethodBeat.m2505o(46865);
                    return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.r$12 */
    class C1426312 implements C32467c<C22585ah> {
        C1426312() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(46857);
            C22585ah c22585ah = new C22585ah();
            AppMethodBeat.m2505o(46857);
            return c22585ah;
        }
    }

    public C14241r() {
        AppMethodBeat.m2504i(46866);
        AppMethodBeat.m2505o(46866);
    }

    static {
        AppMethodBeat.m2504i(46886);
        C1449k.m3079a("tenpay_utils", C14241r.class.getClassLoader());
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new C142608());
        eaA.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new C142619());
        eaA.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new C1424810());
        eaA.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new C1424011());
        eaA.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new C1425313());
        eaA.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new C1425514());
        eaA.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new C1425615());
        eaA.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new C1424216());
        eaA.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new C1424917());
        AppMethodBeat.m2505o(46886);
    }

    public static C14241r cPD() {
        AppMethodBeat.m2504i(46867);
        C14241r c14241r = (C14241r) C7485q.m12925Y(C14241r.class);
        AppMethodBeat.m2505o(46867);
        return c14241r;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    public static C22569j cPE() {
        AppMethodBeat.m2504i(46868);
        if (C1720g.m3531RK()) {
            C22569j c22569j = (C22569j) C14241r.cPD().tBQ.get();
            AppMethodBeat.m2505o(46868);
            return c22569j;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46868);
        throw c1819b;
    }

    public static C22566g cPF() {
        AppMethodBeat.m2504i(46869);
        if (C1720g.m3531RK()) {
            C22566g c22566g = (C22566g) C14241r.cPD().tBZ.get();
            AppMethodBeat.m2505o(46869);
            return c22566g;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46869);
        throw c1819b;
    }

    public static C40097c cPG() {
        AppMethodBeat.m2504i(46870);
        if (C1720g.m3531RK()) {
            C40097c c40097c = (C40097c) C14241r.cPD().tBR.get();
            AppMethodBeat.m2505o(46870);
            return c40097c;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46870);
        throw c1819b;
    }

    public static C22567h cPH() {
        AppMethodBeat.m2504i(46871);
        if (C1720g.m3531RK()) {
            C22567h c22567h = (C22567h) C14241r.cPD().tBY.get();
            AppMethodBeat.m2505o(46871);
            return c22567h;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46871);
        throw c1819b;
    }

    public static C22587ak cPI() {
        AppMethodBeat.m2504i(46872);
        if (C1720g.m3531RK()) {
            C22587ak c22587ak = (C22587ak) C14241r.cPD().tBN.get();
            AppMethodBeat.m2505o(46872);
            return c22587ak;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46872);
        throw c1819b;
    }

    public static C22585ah cPJ() {
        AppMethodBeat.m2504i(46873);
        if (C1720g.m3531RK()) {
            C22585ah c22585ah = (C22585ah) C14241r.cPD().tBP.get();
            AppMethodBeat.m2505o(46873);
            return c22585ah;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46873);
        throw c1819b;
    }

    public static C22565a cPK() {
        AppMethodBeat.m2504i(46874);
        if (C1720g.m3531RK()) {
            C22565a c22565a = (C22565a) C14241r.cPD().tBS.get();
            AppMethodBeat.m2505o(46874);
            return c22565a;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46874);
        throw c1819b;
    }

    public static C29620f cPL() {
        AppMethodBeat.m2504i(46875);
        if (C1720g.m3531RK()) {
            C29620f c29620f = (C29620f) C14241r.cPD().tBT.get();
            AppMethodBeat.m2505o(46875);
            return c29620f;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46875);
        throw c1819b;
    }

    public static C43791d cPM() {
        AppMethodBeat.m2504i(46876);
        if (C1720g.m3531RK()) {
            C43791d c43791d = (C43791d) C14241r.cPD().tBU.get();
            AppMethodBeat.m2505o(46876);
            return c43791d;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46876);
        throw c1819b;
    }

    public static C43792e cPN() {
        AppMethodBeat.m2504i(46877);
        if (C1720g.m3531RK()) {
            C43792e c43792e = (C43792e) C14241r.cPD().tBW.get();
            AppMethodBeat.m2505o(46877);
            return c43792e;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46877);
        throw c1819b;
    }

    public static C22568i cPO() {
        AppMethodBeat.m2504i(46878);
        if (C1720g.m3531RK()) {
            C22568i c22568i = (C22568i) C14241r.cPD().tBX.get();
            AppMethodBeat.m2505o(46878);
            return c22568i;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(46878);
        throw c1819b;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public static C43803ae cPP() {
        AppMethodBeat.m2504i(46879);
        C43803ae c43803ae = C14241r.cPD().tBO;
        AppMethodBeat.m2505o(46879);
        return c43803ae;
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(46880);
        C4990ab.m7416i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
        C40928b.dNJ();
        C40928b.init(C4996ah.getContext());
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("paymsg", this.old, true);
        C14241r.cPI().cQv();
        this.tBO = C43803ae.cPT();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("paymsg", this.tBO.kBx, true);
        C4879a.xxA.mo10051b(this.tCb);
        C4879a.xxA.mo10051b(this.tBV);
        C4879a.xxA.mo10051b(this.tCe);
        C4879a.xxA.mo10051b(this.tCd);
        C44042b.m79163a(new C14262a(), "//cleanpaycn");
        AppMethodBeat.m2505o(46880);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(46881);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("paymsg", this.old, true);
        C14241r.cPI().mo38129Km();
        C22585ah cPJ = C14241r.cPJ();
        cPJ.tCO = null;
        cPJ.tCN.clear();
        cPJ.tCN = new ArrayList();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("paymsg", this.tBO.kBx, true);
        if (C43803ae.lUV != null) {
            C43803ae.lUV.clear();
        }
        this.tBO = null;
        C4879a.xxA.mo10053d(this.tCb);
        C4879a.xxA.mo10053d(this.tBV);
        C4879a.xxA.mo10053d(this.tCe);
        C4879a.xxA.mo10053d(this.tCd);
        AppMethodBeat.m2505o(46881);
    }

    /* renamed from: B */
    public static void m22433B(Context context, Intent intent) {
        AppMethodBeat.m2504i(46882);
        if (intent == null) {
            intent = new Intent();
        }
        if (C1853r.m3832YN()) {
            intent.setFlags(536870912);
            C4990ab.m7416i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
            C25985d.m41467b(context, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", intent);
            AppMethodBeat.m2505o(46882);
        } else if (C1853r.m3833YO()) {
            intent.setFlags(536870912);
            C25985d.m41467b(context, "mall", ".ui.MallIndexOSUI", intent);
            AppMethodBeat.m2505o(46882);
        } else {
            C4990ab.m7416i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
            intent.setFlags(536870912);
            C25985d.m41467b(context, "mall", ".ui.MallIndexUI", intent);
            C1720g.m3537RQ();
            if (C1720g.m3536RP().isSDCardAvailable()) {
                C1207m c45181k = new C45181k(11);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c45181k, 0);
            }
            AppMethodBeat.m2505o(46882);
        }
    }

    public static C4397t cPQ() {
        AppMethodBeat.m2504i(46883);
        C4397t c4397t = C14241r.cPD().tBM;
        AppMethodBeat.m2505o(46883);
        return c4397t;
    }

    /* renamed from: a */
    public static boolean m22436a(MMActivity mMActivity, C46722e c46722e) {
        AppMethodBeat.m2504i(46884);
        boolean a = C14241r.cPD().tCa.mo69477a(mMActivity, c46722e, 1008);
        AppMethodBeat.m2505o(46884);
        return a;
    }

    /* renamed from: b */
    public static boolean m22437b(MMActivity mMActivity, C46722e c46722e) {
        AppMethodBeat.m2504i(46885);
        boolean a = C14241r.cPD().tCa.mo69477a(mMActivity, c46722e, 1006);
        AppMethodBeat.m2505o(46885);
        return a;
    }
}
