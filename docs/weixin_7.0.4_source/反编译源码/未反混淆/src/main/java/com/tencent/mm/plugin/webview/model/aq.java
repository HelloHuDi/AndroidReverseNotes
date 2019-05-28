package com.tencent.mm.plugin.webview.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class aq {
    private static int umY = 0;
    private static int umZ = 0;
    public o umJ;
    public m umK;
    public n umL;
    public l umM;
    private a umN;
    public h umO;
    public c umP;
    public i umQ;
    public e umR;
    private f umS;
    private k umT;
    private j umU;
    private d umV;
    public b umW;
    private g umX;

    public static class a {
        public long edh = System.currentTimeMillis();
        public String fjS;
        public long iBA;
        public long lastResumeTime = -1;
        public int rCb = com.tencent.mm.bz.a.ge(ah.getContext());
        public int scene;
        public int una = com.tencent.mm.bz.a.ge(ah.getContext());

        public a() {
            AppMethodBeat.i(6759);
            AppMethodBeat.o(6759);
        }
    }

    public class h {
        public int cSQ;
        public boolean cph = false;
        public long startTime = bo.anU();
        public String uni;
        public String url;

        public h() {
            AppMethodBeat.i(6767);
            AppMethodBeat.o(6767);
        }
    }

    public static class i {
        public Object[] une = null;

        public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
            AppMethodBeat.i(6768);
            if (dVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.g.a(dVar, 11576, this.une);
            }
            AppMethodBeat.o(6768);
        }
    }

    public static class j {
        public List<String> unk;
    }

    public class o {
        public int cSQ;
        public boolean cxT = true;
        public long iBv;
        public String uni;
        public String url;
    }

    public static class g {
        public int errCode;
        public SnsAdClick pmI;
        private ArrayList<String> unj = new ArrayList();

        public g() {
            AppMethodBeat.i(6764);
            AppMethodBeat.o(6764);
        }

        public final void L(String... strArr) {
            AppMethodBeat.i(6765);
            for (int i = 0; i < 3; i++) {
                this.unj.add(strArr[i]);
            }
            AppMethodBeat.o(6765);
        }

        public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
            AppMethodBeat.i(6766);
            try {
                if (!this.unj.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("reportAdH5Load", this.unj);
                    bundle.putInt("errCode", this.errCode);
                    bundle.putParcelable("snsAdClick", this.pmI);
                    dVar.g(204, bundle);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WebviewReporter", e, "", new Object[0]);
            }
            this.pmI = null;
            this.unj.clear();
            AppMethodBeat.o(6766);
        }
    }

    public static class c {
        public String cOG;
        public boolean loadFinished = false;
        public boolean unc = false;
    }

    public static class d {
        public boolean mlA = false;
        public boolean und = false;
    }

    public class f {
        public int cSQ;
        public String iCz = "";
        public HashMap<String, Long> unf = new HashMap();
        public HashMap<String, Long> ung = new HashMap();
        public boolean unh = true;
        public String uni;

        public f() {
            AppMethodBeat.i(6762);
            AppMethodBeat.o(6762);
        }

        public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
            AppMethodBeat.i(6763);
            if (dVar != null) {
                String str;
                long longValue;
                String str2;
                Object[] objArr;
                int aEn = aq.aEn();
                for (Entry entry : this.unf.entrySet()) {
                    str = (String) entry.getKey();
                    longValue = ((Long) entry.getValue()).longValue();
                    if (longValue < 0 || longValue > 180000) {
                        AppMethodBeat.o(6763);
                        return;
                    }
                    str2 = this.uni;
                    objArr = new Object[11];
                    objArr[0] = Integer.valueOf(5);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(aEn);
                    if (str != null) {
                        str = str.replace(",", "!");
                    }
                    objArr[3] = str;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(aq.umY);
                    objArr[8] = Integer.valueOf(aq.umZ);
                    objArr[9] = Integer.valueOf(this.cSQ);
                    objArr[10] = this.uni;
                    aq.b(dVar, str2, objArr);
                    if (aq.umY == 1) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(32, 18, 1, true);
                        com.tencent.mm.plugin.report.service.h.pYm.a(32, 19, longValue, true);
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.a(32, 8, 1, true);
                    com.tencent.mm.plugin.report.service.h.pYm.a(32, 9, longValue, true);
                    ab.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", Long.valueOf(longValue), Integer.valueOf(aEn), Integer.valueOf(aq.umY), Integer.valueOf(aq.umZ), Integer.valueOf(this.cSQ), this.uni);
                }
                for (Entry entry2 : this.ung.entrySet()) {
                    str = (String) entry2.getKey();
                    longValue = ((Long) entry2.getValue()).longValue();
                    if (longValue < 0 || longValue > 180000) {
                        AppMethodBeat.o(6763);
                        return;
                    }
                    str2 = this.uni;
                    objArr = new Object[11];
                    objArr[0] = Integer.valueOf(6);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(aEn);
                    if (str != null) {
                        str = str.replace(",", "!");
                    }
                    objArr[3] = str;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(aq.umY);
                    objArr[8] = Integer.valueOf(aq.umZ);
                    objArr[9] = Integer.valueOf(this.cSQ);
                    objArr[10] = this.uni;
                    aq.b(dVar, str2, objArr);
                    if (aq.umY == 1) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(32, 20, 1, true);
                        com.tencent.mm.plugin.report.service.h.pYm.a(32, 21, longValue, true);
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.a(32, 10, 1, true);
                    com.tencent.mm.plugin.report.service.h.pYm.a(32, 11, longValue, true);
                    ab.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", Long.valueOf(longValue), Integer.valueOf(aEn), Integer.valueOf(aq.umY), Integer.valueOf(aq.umZ), Integer.valueOf(this.cSQ), this.uni);
                }
            }
            AppMethodBeat.o(6763);
        }
    }

    public static class k {
        public List<String> unk;
    }

    public static class l {
        public String appId;
        public String cOG;
        public String dJE;
        long edh = (System.currentTimeMillis() / 1000);
        public String fjS;
        public long iBA;
        public long lastResumeTime = -1;
        public String rjC;
        public int scene;
        public String title;
        public String unl;
        public String unm;
        public long unn;
        public int uno;
        public String unp;
        public String unq;
        public String unr;
        public int uns;
        public int unt;
        public String username;

        public l() {
            AppMethodBeat.i(6769);
            AppMethodBeat.o(6769);
        }
    }

    public class m {
        public int cSQ;
        public String uni;
        public HashMap<String, Long> unu = new HashMap();

        public m() {
            AppMethodBeat.i(6770);
            AppMethodBeat.o(6770);
        }

        public final void bE(String str, boolean z) {
            AppMethodBeat.i(6771);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
                AppMethodBeat.o(6771);
                return;
            }
            if (this.unu.containsKey(str)) {
                if (z) {
                    this.unu.put(str, Long.valueOf(bo.anU() - ((Long) this.unu.get(str)).longValue()));
                    AppMethodBeat.o(6771);
                    return;
                }
                this.unu.put(str, Long.valueOf(-1));
            }
            AppMethodBeat.o(6771);
        }

        public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
            AppMethodBeat.i(6772);
            if (dVar == null) {
                AppMethodBeat.o(6772);
                return;
            }
            int aEn = aq.aEn();
            for (Entry entry : this.unu.entrySet()) {
                String str = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                com.tencent.mm.plugin.report.service.h.pYm.a(32, 2, 1, true);
                if (longValue == -1) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(32, 13, 1, true);
                    ab.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", str, Integer.valueOf(aEn));
                }
                if (longValue >= 0 && longValue <= 60000) {
                    String str2 = this.uni;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(2);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(aEn);
                    objArr[3] = str == null ? str : str.replace(",", "!");
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(aq.umY);
                    objArr[8] = Integer.valueOf(aq.umZ);
                    objArr[9] = Integer.valueOf(this.cSQ);
                    objArr[10] = this.uni;
                    aq.b(dVar, str2, objArr);
                    ab.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", str, Long.valueOf(longValue), Integer.valueOf(aEn), Integer.valueOf(this.cSQ), this.uni);
                    com.tencent.mm.plugin.report.service.h.pYm.a(32, 6, longValue, true);
                }
            }
            AppMethodBeat.o(6772);
        }
    }

    public class n {
        public int cSQ;
        public String uni;
        public HashMap<String, Long> unv = new HashMap();

        public n() {
            AppMethodBeat.i(6773);
            AppMethodBeat.o(6773);
        }
    }

    public class b {
        public Bundle mqu = null;

        public b(Bundle bundle) {
            this.mqu = bundle;
        }

        public final void putValue(String str, Object obj) {
            AppMethodBeat.i(6760);
            if (this.mqu != null) {
                if (obj instanceof String) {
                    this.mqu.putString(str, (String) obj);
                    AppMethodBeat.o(6760);
                    return;
                } else if (obj instanceof Boolean) {
                    this.mqu.putBoolean(str, ((Boolean) obj).booleanValue());
                    AppMethodBeat.o(6760);
                    return;
                } else if (obj instanceof Integer) {
                    this.mqu.putInt(str, ((Integer) obj).intValue());
                    AppMethodBeat.o(6760);
                    return;
                } else {
                    ab.w("MicroMsg.WebviewReporter", "put unknow type value.");
                }
            }
            AppMethodBeat.o(6760);
        }
    }

    public static class e {
        public Object[] une = null;

        public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
            AppMethodBeat.i(6761);
            if (dVar != null) {
                com.tencent.mm.plugin.webview.ui.tools.g.a(dVar, 11577, this.une);
            }
            AppMethodBeat.o(6761);
        }
    }

    public static /* synthetic */ void b(com.tencent.mm.plugin.webview.stub.d dVar, String str, Object[] objArr) {
        AppMethodBeat.i(6795);
        a(dVar, str, objArr);
        AppMethodBeat.o(6795);
    }

    public static int aEn() {
        AppMethodBeat.i(6774);
        if (at.is4G(ah.getContext())) {
            AppMethodBeat.o(6774);
            return 5;
        }
        switch (at.getNetType(ah.getContext())) {
            case -1:
                AppMethodBeat.o(6774);
                return 255;
            case 0:
                AppMethodBeat.o(6774);
                return 1;
            case 1:
            case 6:
            case 8:
                AppMethodBeat.o(6774);
                return 3;
            case 2:
            case 5:
            case 7:
                AppMethodBeat.o(6774);
                return 2;
            case 3:
            case 4:
                AppMethodBeat.o(6774);
                return 4;
            default:
                AppMethodBeat.o(6774);
                return 6;
        }
    }

    public static String cXS() {
        AppMethodBeat.i(6775);
        ConnectivityManager connectivityManager = (ConnectivityManager) ah.getContext().getSystemService("connectivity");
        String str;
        if (connectivityManager == null) {
            str = "no";
            AppMethodBeat.o(6775);
            return str;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            str = "no";
            AppMethodBeat.o(6775);
            return str;
        } else if (activeNetworkInfo.getType() == 1) {
            str = "WIFI";
            AppMethodBeat.o(6775);
            return str;
        } else {
            ab.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo());
            if (activeNetworkInfo.getExtraInfo() != null) {
                str = activeNetworkInfo.getExtraInfo().toLowerCase();
                AppMethodBeat.o(6775);
                return str;
            }
            str = "no";
            AppMethodBeat.o(6775);
            return str;
        }
    }

    public final o cXT() {
        AppMethodBeat.i(6776);
        if (this.umJ == null) {
            this.umJ = new o();
        }
        o oVar = this.umJ;
        AppMethodBeat.o(6776);
        return oVar;
    }

    public final m cXU() {
        AppMethodBeat.i(6777);
        if (this.umK == null) {
            this.umK = new m();
        }
        m mVar = this.umK;
        AppMethodBeat.o(6777);
        return mVar;
    }

    public final n cXV() {
        AppMethodBeat.i(6778);
        if (this.umL == null) {
            this.umL = new n();
        }
        n nVar = this.umL;
        AppMethodBeat.o(6778);
        return nVar;
    }

    public final f cXW() {
        AppMethodBeat.i(6779);
        if (this.umS == null) {
            this.umS = new f();
        }
        f fVar = this.umS;
        AppMethodBeat.o(6779);
        return fVar;
    }

    public final l cXX() {
        AppMethodBeat.i(6780);
        if (this.umM == null) {
            this.umM = new l();
        }
        l lVar = this.umM;
        AppMethodBeat.o(6780);
        return lVar;
    }

    public final a cXY() {
        AppMethodBeat.i(6781);
        if (this.umN == null) {
            this.umN = new a();
        }
        a aVar = this.umN;
        AppMethodBeat.o(6781);
        return aVar;
    }

    public final h cXZ() {
        AppMethodBeat.i(6782);
        if (this.umO == null) {
            this.umO = new h();
        }
        h hVar = this.umO;
        AppMethodBeat.o(6782);
        return hVar;
    }

    public final c cYa() {
        AppMethodBeat.i(6783);
        if (this.umP == null) {
            this.umP = new c();
        }
        c cVar = this.umP;
        AppMethodBeat.o(6783);
        return cVar;
    }

    public final i cYb() {
        AppMethodBeat.i(6784);
        if (this.umQ == null) {
            this.umQ = new i();
        }
        i iVar = this.umQ;
        AppMethodBeat.o(6784);
        return iVar;
    }

    public final e cYc() {
        AppMethodBeat.i(6785);
        if (this.umR == null) {
            this.umR = new e();
        }
        e eVar = this.umR;
        AppMethodBeat.o(6785);
        return eVar;
    }

    public final k cYd() {
        AppMethodBeat.i(6786);
        if (this.umT == null) {
            this.umT = new k();
        }
        k kVar = this.umT;
        AppMethodBeat.o(6786);
        return kVar;
    }

    public final j cYe() {
        AppMethodBeat.i(6787);
        if (this.umU == null) {
            this.umU = new j();
        }
        j jVar = this.umU;
        AppMethodBeat.o(6787);
        return jVar;
    }

    public final d cYf() {
        AppMethodBeat.i(6788);
        if (this.umV == null) {
            this.umV = new d();
        }
        d dVar = this.umV;
        AppMethodBeat.o(6788);
        return dVar;
    }

    public final g cYg() {
        AppMethodBeat.i(6789);
        if (this.umX == null) {
            this.umX = new g();
        }
        g gVar = this.umX;
        AppMethodBeat.o(6789);
        return gVar;
    }

    public final void q(String str, Object obj) {
        AppMethodBeat.i(6790);
        if (this.umW != null) {
            try {
                this.umW.putValue(str, obj);
                AppMethodBeat.o(6790);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(6790);
    }

    public final void aeG(String str) {
        AppMethodBeat.i(6791);
        if (this.umW != null) {
            try {
                b bVar = this.umW;
                if (bVar.mqu.containsKey(str)) {
                    try {
                        bVar.putValue(str, Integer.valueOf(bVar.mqu.getInt(str) + 1));
                        AppMethodBeat.o(6791);
                        return;
                    } catch (Exception e) {
                        AppMethodBeat.o(6791);
                        return;
                    }
                }
                bVar.putValue(str, Integer.valueOf(1));
                AppMethodBeat.o(6791);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(6791);
    }

    public static void V(boolean z, boolean z2) {
        if (z) {
            umY = 1;
        } else {
            umY = 0;
        }
        if (z2) {
            umZ = 1;
        } else {
            umZ = 0;
        }
    }

    public final void b(com.tencent.mm.plugin.webview.stub.d dVar) {
        String str;
        String str2;
        AppMethodBeat.i(6792);
        n cXV = cXV();
        if (dVar != null) {
            int aEn = aEn();
            for (Entry entry : cXV.unv.entrySet()) {
                String str3 = (String) entry.getKey();
                long longValue = ((Long) entry.getValue()).longValue();
                com.tencent.mm.plugin.report.service.h.pYm.a(32, 0, 1, true);
                if (longValue >= 0 && longValue <= 180000) {
                    str = cXV.uni;
                    Object[] objArr = new Object[11];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(aEn);
                    if (str3 == null) {
                        str2 = str3;
                    } else {
                        str2 = str3.replace(",", "!");
                    }
                    objArr[3] = str2;
                    objArr[4] = Integer.valueOf(0);
                    objArr[5] = Integer.valueOf(0);
                    objArr[6] = Integer.valueOf(0);
                    objArr[7] = Integer.valueOf(umY);
                    objArr[8] = Integer.valueOf(umZ);
                    objArr[9] = Integer.valueOf(cXV.cSQ);
                    objArr[10] = cXV.uni;
                    a(dVar, str, objArr);
                    com.tencent.mm.plugin.report.service.h.pYm.a(160, 0, 1, false);
                    if (-1 != com.tencent.mm.plugin.webview.ui.tools.b.lS(longValue)) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(160, (long) com.tencent.mm.plugin.webview.ui.tools.b.lS(longValue), 1, false);
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.a(32, 3, 1, true);
                    com.tencent.mm.plugin.report.service.h.pYm.a(32, 7, longValue, true);
                    if (umZ == 1) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(32, 16, 1, true);
                        com.tencent.mm.plugin.report.service.h.pYm.a(32, 17, longValue, true);
                    }
                    ab.i("MicroMsg.WebviewReporter", "WebviewOpenUrlReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", str3, Long.valueOf(longValue), Integer.valueOf(aEn), Integer.valueOf(umY), Integer.valueOf(umZ), Integer.valueOf(cXV.cSQ), cXV.uni);
                }
            }
        }
        l cXX = cXX();
        if (!bo.isNullOrNil(cXX.unm)) {
            ab.d("MicroMsg.WebviewReporter", "WebViewVisitReporter report viewID = %s", cXX.unm);
        }
        if (dVar != null) {
            Object obj;
            str2 = "";
            try {
                Bundle g = dVar.g(23, new Bundle(0));
                if (g != null) {
                    str2 = g.getString("config_info_username");
                }
                obj = str2;
            } catch (RemoteException e) {
                ab.w("MicroMsg.WebviewReporter", "invokeAsResult error, %s", e);
                str = str2;
            }
            PString pString = new PString();
            ab.d("MicroMsg.WebviewReporter", "report 10643(%s), username : %s, msgId : %s, msgIndex : %s, scene : %s, enterTime : %s, stayTime : %s, rawUrl : %s, publisher : %s, viewId : %s, publishId : %s,appId : %s, newMsgId : %s, preUsername : %s, curUsername : %s, referUrl : %s, statExtStr:%s(%s), chatType:%d, title:%s, expidstr[chatting_exp]:%s, sourceAppId:%s, allStayTime %d", Integer.valueOf(10643), cXX.username, Long.valueOf(cXX.unn), Integer.valueOf(cXX.uno), Integer.valueOf(cXX.scene), Long.valueOf(cXX.edh), Long.valueOf(cXX.iBA), cXX.cOG, cXX.unl, cXX.unm, cXX.fjS, cXX.appId, cXX.unp, cXX.unq, obj, cXX.unr, cXX.rjC, ((com.tencent.mm.plugin.sns.b.i) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.sns.b.i.class)).a(cXX.rjC, pString), Integer.valueOf(cXX.uns), cXX.title, cXX.dJE, pString.value, Long.valueOf(System.currentTimeMillis() - cXX.edh));
            str2 = cXX.title;
            try {
                str2 = URLEncoder.encode(cXX.title, "UTF-8");
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.WebviewReporter", e2, "", new Object[0]);
            }
            Object[] objArr2 = new Object[26];
            objArr2[0] = cXX.username;
            objArr2[1] = Long.valueOf(cXX.unn);
            objArr2[2] = Integer.valueOf(cXX.uno);
            objArr2[3] = Integer.valueOf(cXX.scene);
            objArr2[4] = Long.valueOf(cXX.edh);
            objArr2[5] = Long.valueOf(cXX.iBA);
            objArr2[6] = cXX.cOG == null ? cXX.cOG : cXX.cOG.replace(",", "!");
            objArr2[7] = cXX.unl;
            objArr2[8] = cXX.unm;
            objArr2[9] = cXX.fjS;
            objArr2[10] = cXX.appId;
            objArr2[11] = cXX.unp;
            objArr2[12] = cXX.unq;
            objArr2[13] = obj;
            if (cXX.unr == null) {
                str = cXX.unr;
            } else {
                str = cXX.unr.replace(",", "!");
            }
            objArr2[14] = str;
            objArr2[15] = r7;
            objArr2[16] = Integer.valueOf(cXX.uns);
            objArr2[17] = str2;
            objArr2[18] = cXX.dJE;
            objArr2[19] = pString.value;
            objArr2[20] = "";
            objArr2[21] = "";
            objArr2[22] = "";
            objArr2[23] = Long.valueOf(System.currentTimeMillis() - cXX.edh);
            objArr2[24] = Long.valueOf(System.currentTimeMillis());
            objArr2[25] = Integer.valueOf(cXX.unt);
            com.tencent.mm.plugin.webview.ui.tools.g.a(dVar, 10643, objArr2);
        }
        a cXY = cXY();
        if (!bo.isNullOrNil(cXY.fjS) && cXY.fjS.startsWith("wrd")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("iswebviewreadtime=1");
            stringBuffer.append("&publishid=");
            stringBuffer.append(cXY.fjS);
            stringBuffer.append("&staytime=");
            stringBuffer.append(cXY.iBA);
            stringBuffer.append("&allstaytime=");
            stringBuffer.append(System.currentTimeMillis() - cXY.edh);
            stringBuffer.append("&maxscrolly=");
            stringBuffer.append(cXY.una);
            stringBuffer.append("&totalscrolly=");
            stringBuffer.append(cXY.rCb);
            stringBuffer.append("&scene=");
            stringBuffer.append(cXY.scene);
            stringBuffer.append("&entertime=");
            stringBuffer.append(cXY.edh);
            stringBuffer.append("&screenheight=");
            stringBuffer.append(com.tencent.mm.bz.a.ge(ah.getContext()));
            Bundle bundle = new Bundle();
            bundle.putString("reportString", stringBuffer.toString());
            try {
                dVar.j(6, bundle);
            } catch (Exception e3) {
                ab.printErrStackTrace("MicroMsg.WebviewReporter", e3, "TopStory report", new Object[0]);
            }
        }
        cXU().b(dVar);
        cXW().b(dVar);
        c cYa = cYa();
        if (dVar != null) {
            int aEn2 = aEn();
            if (!cYa.unc) {
                com.tencent.mm.plugin.webview.ui.tools.g.a(dVar, 11575, cYa.cOG, Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(aEn2));
            } else if (cYa.loadFinished) {
                com.tencent.mm.plugin.webview.ui.tools.g.a(dVar, 11575, cYa.cOG, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(aEn2));
                AppMethodBeat.o(6792);
                return;
            } else {
                com.tencent.mm.plugin.webview.ui.tools.g.a(dVar, 11575, cYa.cOG, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(aEn2));
                AppMethodBeat.o(6792);
                return;
            }
        }
        AppMethodBeat.o(6792);
    }

    public static void lP(long j) {
        AppMethodBeat.i(6793);
        if (j <= 0) {
            AppMethodBeat.o(6793);
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - j);
        if (currentTimeMillis >= 0 && currentTimeMillis < com.tencent.mm.hardcoder.i.sHCENCODEVIDEOTIMEOUT) {
            com.tencent.mm.plugin.report.service.h.pYm.e(16269, Integer.valueOf(currentTimeMillis), Integer.valueOf((int) (j / 1000)));
        }
        AppMethodBeat.o(6793);
    }

    private static void a(com.tencent.mm.plugin.webview.stub.d dVar, String str, Object... objArr) {
        AppMethodBeat.i(6794);
        if (dVar == null) {
            AppMethodBeat.o(6794);
            return;
        }
        com.tencent.mm.plugin.webview.ui.tools.g.a(dVar, 11215, objArr);
        if (str != null && str.startsWith("official_mall")) {
            com.tencent.mm.plugin.webview.ui.tools.g.a(dVar, 14919, objArr);
        }
        AppMethodBeat.o(6794);
    }
}
