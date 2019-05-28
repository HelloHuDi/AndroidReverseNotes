package com.tencent.p177mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.azf;
import com.tencent.p177mm.protocal.protobuf.azg;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.view.C31128d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.model.app.an */
public final class C46493an implements C1202f, C14887t {
    private static C46493an vcV;
    public String lang;
    public boolean vcW = false;
    public boolean vcX = false;
    private List<String> vcY = new LinkedList();
    public long vcZ;
    private final int vda = 20;
    private int vdb = 0;
    public boolean vdc = false;
    private long vdd;

    private C46493an() {
        AppMethodBeat.m2504i(79397);
        AppMethodBeat.m2505o(79397);
    }

    public static C46493an dhQ() {
        AppMethodBeat.m2504i(79398);
        if (vcV == null) {
            vcV = new C46493an();
        }
        C46493an c46493an = vcV;
        AppMethodBeat.m2505o(79398);
        return c46493an;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x010e A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo9876a(int i, int i2, String str, C40442x c40442x) {
        AppMethodBeat.m2504i(79399);
        if (C1720g.m3531RK()) {
            this.vcW = false;
            C4990ab.m7411d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (c40442x == null) {
                C4990ab.m7412e("MicroMsg.SuggestionAppListLogic", "scene == null");
                AppMethodBeat.m2505o(79399);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (c40442x.getType()) {
                    case 4:
                        C4990ab.m7411d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", Integer.valueOf(((C35794ae) c40442x).dhJ()));
                        LinkedList linkedList = r13.vct;
                        if (linkedList != null && linkedList.size() > 0) {
                            if (C4996ah.getContext() != null && C3753a.bYQ() != null) {
                                C40439f c40439f;
                                LinkedList linkedList2 = new LinkedList();
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    c40439f = (C40439f) it.next();
                                    String str2 = "MicroMsg.SuggestionAppListLogic";
                                    String str3 = "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]";
                                    Object[] objArr = new Object[5];
                                    objArr[0] = c40439f.field_appName;
                                    objArr[1] = c40439f.field_packageName;
                                    objArr[2] = c40439f.field_signature;
                                    objArr[3] = c40439f.dni;
                                    objArr[4] = Boolean.valueOf(c40439f.dnh != null);
                                    C4990ab.m7411d(str2, str3, objArr);
                                    linkedList2.add(c40439f.field_appId);
                                }
                                C3753a.bYQ().mo25137ah(linkedList2);
                                List<C40439f> fJ = C46494g.m87745fJ(C4996ah.getContext());
                                if (fJ.size() > 0) {
                                    C35796i bYO = C3753a.bYQ().bYO();
                                    for (C40439f c40439f2 : fJ) {
                                        if (c40439f2.field_appId != null) {
                                            Object obj;
                                            Iterator it2 = linkedList.iterator();
                                            while (it2.hasNext()) {
                                                c40439f = (C40439f) it2.next();
                                                if (c40439f.field_appId != null && c40439f2.field_appId.equals(c40439f.field_appId)) {
                                                    obj = 1;
                                                    if (obj == null) {
                                                        if (C46494g.m87726a(C4996ah.getContext(), c40439f2)) {
                                                            c40439f2.field_status = 1;
                                                        } else {
                                                            c40439f2.field_status = 4;
                                                        }
                                                        bYO.mo56566a(c40439f2, new String[0]);
                                                    }
                                                }
                                            }
                                            obj = null;
                                            if (obj == null) {
                                            }
                                        }
                                    }
                                }
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().setLong(352275, System.currentTimeMillis());
                                this.vcZ = System.currentTimeMillis();
                                break;
                            }
                            C4990ab.m7412e("MicroMsg.SuggestionAppListLogic", "wrong environment");
                            AppMethodBeat.m2505o(79399);
                            return;
                        }
                        C4990ab.m7420w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
                        AppMethodBeat.m2505o(79399);
                        return;
                        break;
                }
            }
            AppMethodBeat.m2505o(79399);
            return;
        }
        AppMethodBeat.m2505o(79399);
    }

    /* renamed from: fL */
    public final void mo74710fL(Context context) {
        AppMethodBeat.m2504i(79400);
        if (!C1720g.m3531RK()) {
            AppMethodBeat.m2505o(79400);
        } else if (context == null) {
            AppMethodBeat.m2505o(79400);
        } else if (this.vcX) {
            C4990ab.m7410d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            AppMethodBeat.m2505o(79400);
        } else {
            this.vcX = true;
            if (System.currentTimeMillis() - this.vdd < 43200000) {
                C4990ab.m7410d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
                this.vcX = false;
                AppMethodBeat.m2505o(79400);
                return;
            }
            C1720g.m3537RQ();
            this.vdd = C1720g.m3536RP().mo5239Ry().mo16813Mm(352276);
            if (System.currentTimeMillis() - this.vdd < 43200000) {
                C4990ab.m7410d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
                this.vcX = false;
                AppMethodBeat.m2505o(79400);
                return;
            }
            if (this.lang == null) {
                this.lang = C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0));
            }
            C46493an.m87716dZ(this.lang, this.vdb);
            AppMethodBeat.m2505o(79400);
        }
    }

    /* renamed from: fM */
    public final void mo74711fM(Context context) {
        AppMethodBeat.m2504i(79401);
        if (!C1720g.m3531RK()) {
            AppMethodBeat.m2505o(79401);
        } else if (context == null) {
            AppMethodBeat.m2505o(79401);
        } else if (this.vcX) {
            C4990ab.m7410d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            AppMethodBeat.m2505o(79401);
        } else {
            this.vcX = true;
            if (this.lang == null) {
                this.lang = C4988aa.m7402g(context.getSharedPreferences(C4996ah.doA(), 0));
            }
            C4990ab.m7416i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
            C46493an.m87716dZ(this.lang, this.vdb);
            AppMethodBeat.m2505o(79401);
        }
    }

    /* renamed from: dZ */
    private static void m87716dZ(String str, int i) {
        AppMethodBeat.m2504i(79402);
        C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", Integer.valueOf(i), str);
        C1207m c14872ad = new C14872ad(i, str);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c14872ad, 0);
        AppMethodBeat.m2505o(79402);
    }

    public final void reset() {
        AppMethodBeat.m2504i(79403);
        C4990ab.m7416i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().setLong(352276, 0);
        this.vdd = 0;
        this.vdc = true;
        AppMethodBeat.m2505o(79403);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(79404);
        if (C1720g.m3531RK()) {
            this.vcX = false;
            if (c1207m == null) {
                C4990ab.m7412e("MicroMsg.SuggestionAppListLogic", "scene == null");
                this.vdb = 0;
                this.vcY.clear();
                AppMethodBeat.m2505o(79404);
                return;
            } else if (i == 0 && i2 == 0) {
                azf azf;
                C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C14872ad c14872ad = (C14872ad) c1207m;
                if (c14872ad.ehh == null || c14872ad.ehh.fsH.fsP == null) {
                    azf = null;
                } else {
                    azf = (azf) c14872ad.ehh.fsH.fsP;
                }
                if (azf == null) {
                    C4990ab.m7412e("MicroMsg.SuggestionAppListLogic", "resp == null");
                    this.vdb = 0;
                    this.vcY.clear();
                    AppMethodBeat.m2505o(79404);
                    return;
                } else if (azf.wCZ == null || azf.wCZ.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
                    C46493an.m87715a(C3753a.bYQ().bYO(), this.vcY);
                    this.vdb = 0;
                    this.vcY.clear();
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().setLong(352276, System.currentTimeMillis());
                    this.vdd = System.currentTimeMillis();
                    AppMethodBeat.m2505o(79404);
                    return;
                } else {
                    C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", Integer.valueOf(this.vdb), Integer.valueOf(azf.wCZ.size()));
                    C35796i bYO = C3753a.bYQ().bYO();
                    LinkedList linkedList = new LinkedList();
                    Iterator it = azf.wCZ.iterator();
                    while (it.hasNext()) {
                        azg azg = (azg) it.next();
                        C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", azg.kKY, Integer.valueOf(azg.kLb), Integer.valueOf(azg.wDh), Integer.valueOf(azg.wDg), Integer.valueOf(azg.wDe), azg.csB);
                        if (!(C5046bo.isNullOrNil(azg.csB) || C5046bo.isNullOrNil(azg.kKY))) {
                            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                            if (C40439f.vbT.equals(azg.csB)) {
                                azg.wDe = (azg.wDe ^ C31128d.MIC_PTU_ZIPAI_OKINAWA) ^ -1;
                                C4990ab.m7411d("MicroMsg.SuggestionAppListLogic", "aa change: %s", Integer.valueOf(azg.wDe));
                            } else if (C40439f.vbS.equals(azg.csB)) {
                                if (azg.wDh <= 0) {
                                    if (C1853r.m3827YI() && C1853r.m3825YG() == 0 && intValue == 1) {
                                        C7060h.pYm.mo15419k(965, 33, 1);
                                    } else {
                                        C7060h.pYm.mo15419k(965, 35, 1);
                                    }
                                }
                            } else if (C40439f.vbQ.equals(azg.csB) && azg.wDh <= 0) {
                                if (C1853r.m3827YI() && C1853r.m3825YG() == 0 && intValue == 1) {
                                    C7060h.pYm.mo15419k(965, 32, 1);
                                } else {
                                    C7060h.pYm.mo15419k(965, 34, 1);
                                }
                            }
                            this.vcY.add(azg.csB);
                            C40439f bT = C46494g.m87739bT(azg.csB, true);
                            if (bT != null) {
                                Object obj;
                                if (bT.field_serviceAppInfoFlag != azg.wDe) {
                                    obj = 1;
                                } else if (bT.field_serviceAppType != azg.kLb) {
                                    obj = 1;
                                } else if (bT.dnv != azg.wDg) {
                                    obj = 1;
                                } else if (bT.field_serviceShowFlag != azg.wDh) {
                                    obj = 1;
                                } else if (!C5046bo.nullAsNil(bT.field_appName).equals(C5046bo.nullAsNil(azg.kKY))) {
                                    obj = 1;
                                } else if (!C5046bo.nullAsNil(bT.field_appName_en).equals(C5046bo.nullAsNil(azg.wDa))) {
                                    obj = 1;
                                } else if (!C5046bo.nullAsNil(bT.field_appName_tw).equals(C5046bo.nullAsNil(azg.wDb))) {
                                    obj = 1;
                                } else if (!C5046bo.nullAsNil(bT.field_appName_hk).equals(C5046bo.nullAsNil(azg.wDl))) {
                                    obj = 1;
                                } else if (!C5046bo.nullAsNil(bT.dnt).equals(C5046bo.nullAsNil(azg.wDd))) {
                                    obj = 1;
                                } else if (!C5046bo.nullAsNil(bT.dns).equals(C5046bo.nullAsNil(azg.wDc))) {
                                    obj = 1;
                                } else if (C5046bo.nullAsNil(bT.dnu).equals(C5046bo.nullAsNil(azg.wDf))) {
                                    obj = null;
                                } else {
                                    obj = 1;
                                }
                                if (obj != null) {
                                    String str2 = bT.dnt;
                                    String str3 = bT.dns;
                                    C46493an.m87714a(bT, azg);
                                    boolean a = bYO.mo56566a(bT, new String[0]);
                                    if (!C5046bo.nullAsNil(str2).equals(C5046bo.nullAsNil(azg.wDd))) {
                                        C4990ab.m7416i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + C5046bo.nullAsNil(azg.wDd));
                                        C34832a.bYH().mo48331dW(bT.field_appId, 5);
                                    }
                                    if (!C5046bo.nullAsNil(str3).equals(C5046bo.nullAsNil(azg.wDc))) {
                                        C4990ab.m7416i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + C5046bo.nullAsNil(azg.wDc));
                                        C34832a.bYH().mo48331dW(bT.field_appId, 4);
                                    }
                                    C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", azg.csB, Boolean.valueOf(a));
                                }
                            } else {
                                bT = new C40439f();
                                bT.field_appId = azg.csB;
                                C46493an.m87714a(bT, azg);
                                boolean n = bYO.mo56573n(bT);
                                C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", azg.csB, Boolean.valueOf(n));
                            }
                            if (C5046bo.isNullOrNil(bT.field_openId)) {
                                linkedList.add(azg.csB);
                            }
                            for (C40439f c40439f : C46494g.m87748gJ(0, 3)) {
                                if (C40439f.vbQ.equals(c40439f.field_appId)) {
                                    C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "remittance: %s, %s", Integer.valueOf(c40439f.field_serviceShowFlag), Integer.valueOf(c40439f.field_appInfoFlag));
                                } else if (C40439f.vbS.equals(c40439f.field_appId)) {
                                    C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "lucky: %s, %s", Integer.valueOf(c40439f.field_serviceShowFlag), Integer.valueOf(c40439f.field_appInfoFlag));
                                }
                            }
                        }
                    }
                    if (linkedList.size() > 0) {
                        C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", Integer.valueOf(linkedList.size()));
                        C34832a.bYL().addAll(linkedList);
                    }
                    if (azf.wCZ.size() == 20) {
                        this.vdb += 20;
                        C46493an.m87716dZ(this.lang, this.vdb);
                    } else {
                        C46493an.m87715a(bYO, this.vcY);
                        this.vdb = 0;
                        this.vcY.clear();
                    }
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().setLong(352276, System.currentTimeMillis());
                    this.vdd = System.currentTimeMillis();
                    AppMethodBeat.m2505o(79404);
                    return;
                }
            } else {
                C4990ab.m7413e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                this.vdb = 0;
                this.vcY.clear();
                AppMethodBeat.m2505o(79404);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
        this.vdb = 0;
        this.vcY.clear();
        AppMethodBeat.m2505o(79404);
    }

    /* renamed from: a */
    private static void m87715a(C35796i c35796i, List<String> list) {
        AppMethodBeat.m2504i(79405);
        if (c35796i == null || list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(79405);
            return;
        }
        C4990ab.m7410d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
        List<C40439f> dhB = C46494g.dhB();
        C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "oldList %d", Integer.valueOf(dhB.size()));
        if (dhB.size() > 0) {
            for (C40439f c40439f : dhB) {
                if (c40439f.field_appId != null) {
                    int i;
                    for (String equals : list) {
                        if (c40439f.field_appId.equals(equals)) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        boolean b = c35796i.mo56568b(c40439f, new String[0]);
                        C4990ab.m7417i("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", c40439f.field_appId, Boolean.valueOf(b));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(79405);
    }

    /* renamed from: a */
    private static void m87714a(C40439f c40439f, azg azg) {
        AppMethodBeat.m2504i(79406);
        c40439f.field_appName = azg.kKY;
        c40439f.field_appName_en = azg.wDa;
        c40439f.field_appName_tw = azg.wDb;
        c40439f.field_appName_hk = azg.wDl;
        c40439f.mo44089iu(azg.wDc);
        c40439f.mo44090iv(azg.wDd);
        c40439f.mo44091iw(azg.wDf);
        c40439f.field_serviceAppInfoFlag = azg.wDe;
        c40439f.field_serviceAppType = azg.kLb;
        c40439f.mo44073hs(azg.wDg);
        c40439f.field_serviceShowFlag = azg.wDh;
        AppMethodBeat.m2505o(79406);
    }
}
