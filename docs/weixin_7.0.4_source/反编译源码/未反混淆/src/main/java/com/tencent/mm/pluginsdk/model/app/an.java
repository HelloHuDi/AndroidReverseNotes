package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.view.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class an implements f, t {
    private static an vcV;
    public String lang;
    public boolean vcW = false;
    public boolean vcX = false;
    private List<String> vcY = new LinkedList();
    public long vcZ;
    private final int vda = 20;
    private int vdb = 0;
    public boolean vdc = false;
    private long vdd;

    private an() {
        AppMethodBeat.i(79397);
        AppMethodBeat.o(79397);
    }

    public static an dhQ() {
        AppMethodBeat.i(79398);
        if (vcV == null) {
            vcV = new an();
        }
        an anVar = vcV;
        AppMethodBeat.o(79398);
        return anVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x010e A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, String str, x xVar) {
        AppMethodBeat.i(79399);
        if (g.RK()) {
            this.vcW = false;
            ab.d("MicroMsg.SuggestionAppListLogic", "Suggestion onSceneEnd errType=%s errCode=%s", Integer.valueOf(i), Integer.valueOf(i2));
            if (xVar == null) {
                ab.e("MicroMsg.SuggestionAppListLogic", "scene == null");
                AppMethodBeat.o(79399);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (xVar.getType()) {
                    case 4:
                        ab.d("MicroMsg.SuggestionAppListLogic", "get suggestion appList, AppCount = %s", Integer.valueOf(((ae) xVar).dhJ()));
                        LinkedList linkedList = r13.vct;
                        if (linkedList != null && linkedList.size() > 0) {
                            if (ah.getContext() != null && a.bYQ() != null) {
                                f fVar;
                                LinkedList linkedList2 = new LinkedList();
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    fVar = (f) it.next();
                                    String str2 = "MicroMsg.SuggestionAppListLogic";
                                    String str3 = "suggestion appName=%s, packageName=%s, signature [%s], introUrl [%s], has iconUrl [%s]";
                                    Object[] objArr = new Object[5];
                                    objArr[0] = fVar.field_appName;
                                    objArr[1] = fVar.field_packageName;
                                    objArr[2] = fVar.field_signature;
                                    objArr[3] = fVar.dni;
                                    objArr[4] = Boolean.valueOf(fVar.dnh != null);
                                    ab.d(str2, str3, objArr);
                                    linkedList2.add(fVar.field_appId);
                                }
                                a.bYQ().ah(linkedList2);
                                List<f> fJ = g.fJ(ah.getContext());
                                if (fJ.size() > 0) {
                                    i bYO = a.bYQ().bYO();
                                    for (f fVar2 : fJ) {
                                        if (fVar2.field_appId != null) {
                                            Object obj;
                                            Iterator it2 = linkedList.iterator();
                                            while (it2.hasNext()) {
                                                fVar = (f) it2.next();
                                                if (fVar.field_appId != null && fVar2.field_appId.equals(fVar.field_appId)) {
                                                    obj = 1;
                                                    if (obj == null) {
                                                        if (g.a(ah.getContext(), fVar2)) {
                                                            fVar2.field_status = 1;
                                                        } else {
                                                            fVar2.field_status = 4;
                                                        }
                                                        bYO.a(fVar2, new String[0]);
                                                    }
                                                }
                                            }
                                            obj = null;
                                            if (obj == null) {
                                            }
                                        }
                                    }
                                }
                                g.RQ();
                                g.RP().Ry().setLong(352275, System.currentTimeMillis());
                                this.vcZ = System.currentTimeMillis();
                                break;
                            }
                            ab.e("MicroMsg.SuggestionAppListLogic", "wrong environment");
                            AppMethodBeat.o(79399);
                            return;
                        }
                        ab.w("MicroMsg.SuggestionAppListLogic", "empty suggestAppList");
                        AppMethodBeat.o(79399);
                        return;
                        break;
                }
            }
            AppMethodBeat.o(79399);
            return;
        }
        AppMethodBeat.o(79399);
    }

    public final void fL(Context context) {
        AppMethodBeat.i(79400);
        if (!g.RK()) {
            AppMethodBeat.o(79400);
        } else if (context == null) {
            AppMethodBeat.o(79400);
        } else if (this.vcX) {
            ab.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            AppMethodBeat.o(79400);
        } else {
            this.vcX = true;
            if (System.currentTimeMillis() - this.vdd < 43200000) {
                ab.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
                this.vcX = false;
                AppMethodBeat.o(79400);
                return;
            }
            g.RQ();
            this.vdd = g.RP().Ry().Mm(352276);
            if (System.currentTimeMillis() - this.vdd < 43200000) {
                ab.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
                this.vcX = false;
                AppMethodBeat.o(79400);
                return;
            }
            if (this.lang == null) {
                this.lang = aa.g(context.getSharedPreferences(ah.doA(), 0));
            }
            dZ(this.lang, this.vdb);
            AppMethodBeat.o(79400);
        }
    }

    public final void fM(Context context) {
        AppMethodBeat.i(79401);
        if (!g.RK()) {
            AppMethodBeat.o(79401);
        } else if (context == null) {
            AppMethodBeat.o(79401);
        } else if (this.vcX) {
            ab.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
            AppMethodBeat.o(79401);
        } else {
            this.vcX = true;
            if (this.lang == null) {
                this.lang = aa.g(context.getSharedPreferences(ah.doA(), 0));
            }
            ab.i("MicroMsg.SuggestionAppListLogic", "getServiceAppListImmediately");
            dZ(this.lang, this.vdb);
            AppMethodBeat.o(79401);
        }
    }

    private static void dZ(String str, int i) {
        AppMethodBeat.i(79402);
        ab.i("MicroMsg.SuggestionAppListLogic", "get service app, offset = %d, lang = %s", Integer.valueOf(i), str);
        m adVar = new ad(i, str);
        g.RQ();
        g.RO().eJo.a(adVar, 0);
        AppMethodBeat.o(79402);
    }

    public final void reset() {
        AppMethodBeat.i(79403);
        ab.i("MicroMsg.SuggestionAppListLogic", "reset getServiceAppList");
        g.RQ();
        g.RP().Ry().setLong(352276, 0);
        this.vdd = 0;
        this.vdc = true;
        AppMethodBeat.o(79403);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(79404);
        if (g.RK()) {
            this.vcX = false;
            if (mVar == null) {
                ab.e("MicroMsg.SuggestionAppListLogic", "scene == null");
                this.vdb = 0;
                this.vcY.clear();
                AppMethodBeat.o(79404);
                return;
            } else if (i == 0 && i2 == 0) {
                azf azf;
                ab.i("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                ad adVar = (ad) mVar;
                if (adVar.ehh == null || adVar.ehh.fsH.fsP == null) {
                    azf = null;
                } else {
                    azf = (azf) adVar.ehh.fsH.fsP;
                }
                if (azf == null) {
                    ab.e("MicroMsg.SuggestionAppListLogic", "resp == null");
                    this.vdb = 0;
                    this.vcY.clear();
                    AppMethodBeat.o(79404);
                    return;
                } else if (azf.wCZ == null || azf.wCZ.size() <= 0) {
                    ab.e("MicroMsg.SuggestionAppListLogic", "Service_appinfo empty");
                    a(a.bYQ().bYO(), this.vcY);
                    this.vdb = 0;
                    this.vcY.clear();
                    g.RQ();
                    g.RP().Ry().setLong(352276, System.currentTimeMillis());
                    this.vdd = System.currentTimeMillis();
                    AppMethodBeat.o(79404);
                    return;
                } else {
                    ab.i("MicroMsg.SuggestionAppListLogic", "offset = %d, count = %s", Integer.valueOf(this.vdb), Integer.valueOf(azf.wCZ.size()));
                    i bYO = a.bYQ().bYO();
                    LinkedList linkedList = new LinkedList();
                    Iterator it = azf.wCZ.iterator();
                    while (it.hasNext()) {
                        azg azg = (azg) it.next();
                        ab.i("MicroMsg.SuggestionAppListLogic", "service info: %s, %s, %s, %s, %s, %s", azg.kKY, Integer.valueOf(azg.kLb), Integer.valueOf(azg.wDh), Integer.valueOf(azg.wDg), Integer.valueOf(azg.wDe), azg.csB);
                        if (!(bo.isNullOrNil(azg.csB) || bo.isNullOrNil(azg.kKY))) {
                            int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                            if (f.vbT.equals(azg.csB)) {
                                azg.wDe = (azg.wDe ^ d.MIC_PTU_ZIPAI_OKINAWA) ^ -1;
                                ab.d("MicroMsg.SuggestionAppListLogic", "aa change: %s", Integer.valueOf(azg.wDe));
                            } else if (f.vbS.equals(azg.csB)) {
                                if (azg.wDh <= 0) {
                                    if (r.YI() && r.YG() == 0 && intValue == 1) {
                                        h.pYm.k(965, 33, 1);
                                    } else {
                                        h.pYm.k(965, 35, 1);
                                    }
                                }
                            } else if (f.vbQ.equals(azg.csB) && azg.wDh <= 0) {
                                if (r.YI() && r.YG() == 0 && intValue == 1) {
                                    h.pYm.k(965, 32, 1);
                                } else {
                                    h.pYm.k(965, 34, 1);
                                }
                            }
                            this.vcY.add(azg.csB);
                            f bT = g.bT(azg.csB, true);
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
                                } else if (!bo.nullAsNil(bT.field_appName).equals(bo.nullAsNil(azg.kKY))) {
                                    obj = 1;
                                } else if (!bo.nullAsNil(bT.field_appName_en).equals(bo.nullAsNil(azg.wDa))) {
                                    obj = 1;
                                } else if (!bo.nullAsNil(bT.field_appName_tw).equals(bo.nullAsNil(azg.wDb))) {
                                    obj = 1;
                                } else if (!bo.nullAsNil(bT.field_appName_hk).equals(bo.nullAsNil(azg.wDl))) {
                                    obj = 1;
                                } else if (!bo.nullAsNil(bT.dnt).equals(bo.nullAsNil(azg.wDd))) {
                                    obj = 1;
                                } else if (!bo.nullAsNil(bT.dns).equals(bo.nullAsNil(azg.wDc))) {
                                    obj = 1;
                                } else if (bo.nullAsNil(bT.dnu).equals(bo.nullAsNil(azg.wDf))) {
                                    obj = null;
                                } else {
                                    obj = 1;
                                }
                                if (obj != null) {
                                    String str2 = bT.dnt;
                                    String str3 = bT.dns;
                                    a(bT, azg);
                                    boolean a = bYO.a(bT, new String[0]);
                                    if (!bo.nullAsNil(str2).equals(bo.nullAsNil(azg.wDd))) {
                                        ab.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_list" + bo.nullAsNil(azg.wDd));
                                        com.tencent.mm.plugin.s.a.bYH().dW(bT.field_appId, 5);
                                    }
                                    if (!bo.nullAsNil(str3).equals(bo.nullAsNil(azg.wDc))) {
                                        ab.i("MicroMsg.SuggestionAppListLogic", "update serviceApp.app_icon_url_panel" + bo.nullAsNil(azg.wDc));
                                        com.tencent.mm.plugin.s.a.bYH().dW(bT.field_appId, 4);
                                    }
                                    ab.i("MicroMsg.SuggestionAppListLogic", "update app: AppID = %s, ret = %s", azg.csB, Boolean.valueOf(a));
                                }
                            } else {
                                bT = new f();
                                bT.field_appId = azg.csB;
                                a(bT, azg);
                                boolean n = bYO.n(bT);
                                ab.i("MicroMsg.SuggestionAppListLogic", "insert app: AppID = %s, ret = %s", azg.csB, Boolean.valueOf(n));
                            }
                            if (bo.isNullOrNil(bT.field_openId)) {
                                linkedList.add(azg.csB);
                            }
                            for (f fVar : g.gJ(0, 3)) {
                                if (f.vbQ.equals(fVar.field_appId)) {
                                    ab.i("MicroMsg.SuggestionAppListLogic", "remittance: %s, %s", Integer.valueOf(fVar.field_serviceShowFlag), Integer.valueOf(fVar.field_appInfoFlag));
                                } else if (f.vbS.equals(fVar.field_appId)) {
                                    ab.i("MicroMsg.SuggestionAppListLogic", "lucky: %s, %s", Integer.valueOf(fVar.field_serviceShowFlag), Integer.valueOf(fVar.field_appInfoFlag));
                                }
                            }
                        }
                    }
                    if (linkedList.size() > 0) {
                        ab.i("MicroMsg.SuggestionAppListLogic", "needGetOpenIdList %d", Integer.valueOf(linkedList.size()));
                        com.tencent.mm.plugin.s.a.bYL().addAll(linkedList);
                    }
                    if (azf.wCZ.size() == 20) {
                        this.vdb += 20;
                        dZ(this.lang, this.vdb);
                    } else {
                        a(bYO, this.vcY);
                        this.vdb = 0;
                        this.vcY.clear();
                    }
                    g.RQ();
                    g.RP().Ry().setLong(352276, System.currentTimeMillis());
                    this.vdd = System.currentTimeMillis();
                    AppMethodBeat.o(79404);
                    return;
                }
            } else {
                ab.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd : errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                this.vdb = 0;
                this.vcY.clear();
                AppMethodBeat.o(79404);
                return;
            }
        }
        ab.e("MicroMsg.SuggestionAppListLogic", "getServiceAppList onSceneEnd account not ready");
        this.vdb = 0;
        this.vcY.clear();
        AppMethodBeat.o(79404);
    }

    private static void a(i iVar, List<String> list) {
        AppMethodBeat.i(79405);
        if (iVar == null || list == null || list.size() <= 0) {
            AppMethodBeat.o(79405);
            return;
        }
        ab.d("MicroMsg.SuggestionAppListLogic", "removeExpiredServiceApp");
        List<f> dhB = g.dhB();
        ab.i("MicroMsg.SuggestionAppListLogic", "oldList %d", Integer.valueOf(dhB.size()));
        if (dhB.size() > 0) {
            for (f fVar : dhB) {
                if (fVar.field_appId != null) {
                    int i;
                    for (String equals : list) {
                        if (fVar.field_appId.equals(equals)) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        boolean b = iVar.b(fVar, new String[0]);
                        ab.i("MicroMsg.SuggestionAppListLogic", "delete old service : %s, %s", fVar.field_appId, Boolean.valueOf(b));
                    }
                }
            }
        }
        AppMethodBeat.o(79405);
    }

    private static void a(f fVar, azg azg) {
        AppMethodBeat.i(79406);
        fVar.field_appName = azg.kKY;
        fVar.field_appName_en = azg.wDa;
        fVar.field_appName_tw = azg.wDb;
        fVar.field_appName_hk = azg.wDl;
        fVar.iu(azg.wDc);
        fVar.iv(azg.wDd);
        fVar.iw(azg.wDf);
        fVar.field_serviceAppInfoFlag = azg.wDe;
        fVar.field_serviceAppType = azg.kLb;
        fVar.hs(azg.wDg);
        fVar.field_serviceShowFlag = azg.wDh;
        AppMethodBeat.o(79406);
    }
}
