package com.tencent.mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.g.b.a.cz;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.webview.luggage.s;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.ui.tools.bag.l;
import com.tencent.mm.pluginsdk.model.v.a;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public class g implements at {
    private static final HashMap<Integer, d> eaA;
    private c<bf> fAP = new c<bf>() {
        {
            AppMethodBeat.i(6980);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(6980);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6981);
            bf bfVar = (bf) bVar;
            if (49 != bfVar.cus.cut) {
                AppMethodBeat.o(6981);
                return false;
            } else if (1 != bfVar.cus.cuu) {
                AppMethodBeat.o(6981);
                return false;
            } else if (bfVar.cus.cuw) {
                ab.i("MicroMsg.SubCoreTools", "receive xweb get config  notify!!");
                ah.getContext();
                a.Kv(5);
                AppMethodBeat.o(6981);
                return true;
            } else {
                ab.i("MicroMsg.SubCoreTools", "receive xweb get config  notify!! fileUpdated == false ignore");
                AppMethodBeat.o(6981);
                return false;
            }
        }
    };
    public boolean isAppActive = true;
    private bz.a jCX = new bz.a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(6990);
            final String a = aa.a(aVar.eAB.vED);
            final m cYG = g.cYG();
            new Thread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6989);
                    ab.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
                    Map z = br.z(a, "sysmsg");
                    long j = bo.getLong((String) z.get(".sysmsg.hijackconfig.expiretime"), Long.MAX_VALUE);
                    String str = ".sysmsg.hijackconfig.domainlist.domain";
                    String str2 = str;
                    int i = 0;
                    while (true) {
                        String str3;
                        if (i > 0) {
                            str3 = str + i;
                        } else {
                            str3 = str2;
                        }
                        i++;
                        str2 = (String) z.get(str3);
                        if (bo.isNullOrNil(str2)) {
                            AppMethodBeat.o(6989);
                            return;
                        }
                        i iVar = new i();
                        iVar.field_expireTime = j;
                        iVar.field_host = str2;
                        cYG.b((com.tencent.mm.sdk.e.c) iVar);
                        str2 = str3;
                    }
                }
            }).start();
            AppMethodBeat.o(6990);
        }
    };
    c kBB = new c<k>() {
        {
            AppMethodBeat.i(6970);
            this.xxI = k.class.getName().hashCode();
            AppMethodBeat.o(6970);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6971);
            k kVar = (k) bVar;
            if (kVar.csh == null) {
                AppMethodBeat.o(6971);
            } else {
                ab.i("MicroMsg.SubCoreTools", "appActiveListener isActive:%b", Boolean.valueOf(kVar.csh.csi));
                if (kVar.csh.csi) {
                    l.uzq.nU(true);
                } else {
                    l.uzq.dbi();
                }
                g.this.isAppActive = kVar.csh.csi;
                AppMethodBeat.o(6971);
            }
            return false;
        }
    };
    private n mwl = new n.a() {
        private final byte[] ecf = new byte[0];

        {
            AppMethodBeat.i(6986);
            AppMethodBeat.o(6986);
        }

        public final void gl(int i) {
            AppMethodBeat.i(6987);
            synchronized (this.ecf) {
                try {
                    if (com.tencent.mm.sdk.platformtools.at.getNetType(ah.getContext()) == 0) {
                        ao.cXP().setNetWorkState(1);
                    } else {
                        ao.cXP().setNetWorkState(2);
                    }
                    g.IR(i);
                } finally {
                    AppMethodBeat.o(6987);
                }
            }
        }
    };
    private aj uoO;
    private ak uoP;
    private ai uoQ;
    private m uoR;
    private com.tencent.mm.plugin.webview.model.e uoS;
    private am uoT;
    private com.tencent.mm.plugin.webview.b.e uoU;
    private com.tencent.mm.plugin.webview.fts.g uoV;
    private com.tencent.mm.plugin.webview.fts.a uoW;
    private com.tencent.mm.plugin.webview.fts.b uoX;
    private com.tencent.mm.plugin.webview.c.a uoY;
    private final o uoZ = new o();
    private com.tencent.mm.plugin.webview.luggage.a upa;
    private c upb = new c<k>() {
        {
            AppMethodBeat.i(6959);
            this.xxI = k.class.getName().hashCode();
            AppMethodBeat.o(6959);
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x01a0  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x01e2  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x00ca  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6960);
            if (((k) bVar).csh.csi) {
                Object obj;
                com.tencent.mm.plugin.webview.fts.a.a.a cWq;
                com.tencent.mm.plugin.webview.fts.a.a.b cWr = com.tencent.mm.plugin.webview.fts.a.a.b.cWr();
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.eGM;
                com.tencent.mm.storage.c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100429");
                if (ll == null || !ll.isValid()) {
                    ab.i("WidgetPkgPreDownloadMgr", "abtest null or invalid");
                } else if (com.tencent.mm.plugin.webview.fts.a.a.b.a(ll)) {
                    if (System.currentTimeMillis() - ar.s(ah.getContext(), "WidgetPkgPreDownloadMgr", 4).getLong("last-timestamp", 0) > ((long) (bo.ank((String) ll.dru().get("reqTimeInterval")) * 1000))) {
                        obj = 1;
                    } else {
                        ab.i("WidgetPkgPreDownloadMgr", "abtest interval %d, do not check ,wait for next check", Long.valueOf((long) (bo.ank((String) ll.dru().get("reqTimeInterval")) * 1000)));
                        obj = null;
                    }
                    if (obj != null) {
                        String str = (String) ll.dru().get(TencentLocation.NETWORK_PROVIDER);
                        if (TextUtils.isEmpty(str)) {
                            obj = 1;
                        } else {
                            if (com.tencent.mm.sdk.platformtools.at.gB(ah.getContext()).equalsIgnoreCase(str)) {
                                obj = 1;
                            } else {
                                ab.i("WidgetPkgPreDownloadMgr", "abtest net type not match item.net %s, curNet %s ", str, com.tencent.mm.sdk.platformtools.at.gB(ah.getContext()));
                                obj = null;
                            }
                        }
                        if (obj != null) {
                            str = (String) ll.dru().get("preloadTimePeriod");
                            ab.i("WidgetPkgPreDownloadMgr", "preloadTimePeriod %s", str);
                            if (!TextUtils.isEmpty(str)) {
                                String[] split = str.split("-");
                                if (split.length == 2) {
                                    int ank = bo.ank(split[0]);
                                    int ank2 = bo.ank(split[1]);
                                    int i = Calendar.getInstance().get(11);
                                    if (i <= ank || i >= ank2) {
                                        ab.i("WidgetPkgPreDownloadMgr", "not in preload period");
                                        obj = null;
                                    }
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    obj = 1;
                                    if (obj == null) {
                                        ab.i("WidgetPkgPreDownloadMgr", "do check");
                                        h.pYm.k(918, 0, 1);
                                        ar.s(ah.getContext(), "WidgetPkgPreDownloadMgr", 4).edit().putLong("last-timestamp", System.currentTimeMillis()).commit();
                                        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
                                        aVar2.fsJ = new aqx();
                                        aVar2.fsK = new aqy();
                                        aVar2.uri = "/cgi-bin/mmux-bin/wxaapp_weappsearchlocal";
                                        aVar2.fsI = 2601;
                                        w.a(aVar2.acD(), new w.a() {
                                            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                                                AppMethodBeat.i(5765);
                                                ab.i("WidgetPkgPreDownloadMgr", "cgi back errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                                                if (i == 0 && i2 == 0) {
                                                    b.a(b.this, ((aqy) bVar.fsH.fsP).fjr);
                                                }
                                                AppMethodBeat.o(5765);
                                                return 0;
                                            }
                                        }, true);
                                    } else {
                                        ab.i("WidgetPkgPreDownloadMgr", "do not check");
                                    }
                                    ab.i("WidgetPkgPreDownloadMgr", "[checkUpdate] COST:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    cWq = com.tencent.mm.plugin.webview.fts.a.a.a.cWq();
                                    if (System.currentTimeMillis() - ar.s(ah.getContext(), "WidgetPkgCoverageReport", 4).getLong("last-timestamp", 0) > 86400000) {
                                        ar.s(ah.getContext(), "WidgetPkgCoverageReport", 4).edit().putLong("last-timestamp", System.currentTimeMillis()).commit();
                                        com.tencent.mm.sdk.g.d.post(new Runnable() {
                                            public final void run() {
                                                boolean z;
                                                long j;
                                                AppMethodBeat.i(5763);
                                                ab.i("WidgetPkgCoverageReport", "begin check");
                                                b.cWr();
                                                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.eGM;
                                                com.tencent.mm.storage.c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100429");
                                                if (ll == null || !ll.isValid()) {
                                                    z = false;
                                                } else {
                                                    z = b.a(ll);
                                                }
                                                List<x> abA = ((g) com.tencent.mm.kernel.g.K(g.class)).abA();
                                                StringBuilder stringBuilder = new StringBuilder();
                                                for (x xVar : abA) {
                                                    stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(xVar.csB).append("_").append(xVar.version).append("_").append(xVar.cvZ);
                                                }
                                                cz czVar = new cz();
                                                if (z) {
                                                    j = 1;
                                                } else {
                                                    j = 0;
                                                }
                                                czVar.diz = j;
                                                czVar.ia(stringBuilder.toString()).ajK();
                                                ab.i("WidgetPkgCoverageReport", "end check");
                                                AppMethodBeat.o(5763);
                                            }
                                        }, "WidgetPkgCoverageReport");
                                    }
                                }
                            }
                            obj = 1;
                            if (obj != null) {
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                }
                ab.i("WidgetPkgPreDownloadMgr", "[checkUpdate] COST:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                cWq = com.tencent.mm.plugin.webview.fts.a.a.a.cWq();
                if (System.currentTimeMillis() - ar.s(ah.getContext(), "WidgetPkgCoverageReport", 4).getLong("last-timestamp", 0) > 86400000) {
                }
            }
            AppMethodBeat.o(6960);
            return true;
        }
    };
    private c upc = new c<ms>() {
        {
            AppMethodBeat.i(6982);
            this.xxI = ms.class.getName().hashCode();
            AppMethodBeat.o(6982);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6983);
            ms msVar = (ms) bVar;
            g.cYD();
            com.tencent.mm.plugin.webview.fts.g.bB(msVar.cID.scene, msVar.cID.cvF);
            AppMethodBeat.o(6983);
            return true;
        }
    };
    c upd = new c<vt>() {
        {
            AppMethodBeat.i(6961);
            this.xxI = vt.class.getName().hashCode();
            AppMethodBeat.o(6961);
        }

        private static boolean a(vt vtVar) {
            AppMethodBeat.i(6962);
            if (vtVar instanceof vt) {
                String str;
                String Yz = r.Yz();
                ArrayList arrayList = new ArrayList();
                arrayList.add(vtVar.cSG.cSH);
                arrayList.add(vtVar.cSG.cSI);
                arrayList.add(vtVar.cSG.cSJ);
                arrayList.add(vtVar.cSG.cSK);
                arrayList.add(vtVar.cSG.url);
                arrayList.add(vtVar.cSG.cSL);
                arrayList.add(vtVar.cSG.cSM);
                arrayList.add(vtVar.cSG.cSN);
                arrayList.add(vtVar.cSG.cSO);
                arrayList.add(vtVar.cSG.cSP);
                arrayList.add(Yz);
                arrayList.add(vtVar.cSG.cSQ);
                arrayList.add(vtVar.cSG.cSR);
                PString pString = new PString();
                String a = ((i) com.tencent.mm.kernel.g.K(i.class)).a(vtVar.cSG.cSS, pString);
                arrayList.add(a);
                arrayList.add("");
                arrayList.add("");
                arrayList.add("");
                int ad = u.ad(vtVar.cSG.cSJ, vtVar.cSG.cSK);
                int ad2 = u.ad(Yz, vtVar.cSG.cSM);
                arrayList.add(String.valueOf(ad));
                arrayList.add(String.valueOf(ad2));
                Object obj = vtVar.cSG.cST;
                try {
                    obj = URLEncoder.encode(obj, "UTF-8");
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SubCoreTools", e, "", new Object[0]);
                }
                arrayList.add(obj);
                arrayList.add(pString.value);
                String str2 = "MicroMsg.SubCoreTools";
                String str3 = "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s";
                Object[] objArr = new Object[19];
                objArr[0] = vtVar.cSG.cSH;
                objArr[1] = vtVar.cSG.cSI;
                objArr[2] = vtVar.cSG.cSJ;
                objArr[3] = vtVar.cSG.cSK;
                if (vtVar.cSG.url == null) {
                    str = vtVar.cSG.url;
                } else {
                    str = vtVar.cSG.url.replace(",", "!");
                }
                objArr[4] = str;
                objArr[5] = Integer.valueOf(vtVar.cSG.cSL);
                objArr[6] = vtVar.cSG.cSM;
                objArr[7] = vtVar.cSG.cSN;
                objArr[8] = Integer.valueOf(vtVar.cSG.cSO);
                objArr[9] = Integer.valueOf(vtVar.cSG.cSP);
                objArr[10] = Yz;
                objArr[11] = Integer.valueOf(vtVar.cSG.cSQ);
                if (vtVar.cSG.cSR == null) {
                    str = vtVar.cSG.cSR;
                } else {
                    str = vtVar.cSG.cSR.replace(",", "!");
                }
                objArr[12] = str;
                objArr[13] = vtVar.cSG.cSS;
                objArr[14] = a;
                objArr[15] = Integer.valueOf(ad);
                objArr[16] = Integer.valueOf(ad2);
                objArr[17] = vtVar.cSG.cST;
                objArr[18] = pString.value;
                ab.d(str2, str3, objArr);
                if (vtVar.cSG.cSU != 2) {
                    h hVar = h.pYm;
                    h.g(11954, arrayList);
                }
                AppMethodBeat.o(6962);
                return true;
            }
            AppMethodBeat.o(6962);
            return false;
        }
    };
    c upe = new c<vu>() {
        {
            AppMethodBeat.i(6964);
            this.xxI = vu.class.getName().hashCode();
            AppMethodBeat.o(6964);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6965);
            vu vuVar = (vu) bVar;
            if (vuVar instanceof vu) {
                com.tencent.mm.plugin.webview.preload.a.IT(vuVar.cSV.cSW);
                AppMethodBeat.o(6965);
                return true;
            }
            AppMethodBeat.o(6965);
            return false;
        }
    };
    final c<vq> upf = new c<vq>() {
        {
            AppMethodBeat.i(6966);
            this.xxI = vq.class.getName().hashCode();
            AppMethodBeat.o(6966);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6967);
            as.unx = ((vq) bVar).cSC.cSD.substring(11);
            AppMethodBeat.o(6967);
            return true;
        }
    };
    c upg = new c<iy>() {
        {
            AppMethodBeat.i(6968);
            this.xxI = iy.class.getName().hashCode();
            AppMethodBeat.o(6968);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6969);
            iy iyVar = (iy) bVar;
            if (iyVar instanceof iy) {
                com.tencent.mm.plugin.webview.ui.tools.jsapi.h.dcN().c(iyVar.cEc.requestCode, iyVar.cEc.bFZ, iyVar.cEc.cEd);
                AppMethodBeat.o(6969);
                return true;
            }
            AppMethodBeat.o(6969);
            return false;
        }
    };
    final c<k> uph = new c<k>() {
        private Boolean upn;

        {
            AppMethodBeat.i(6972);
            this.upn = null;
            this.xxI = k.class.getName().hashCode();
            AppMethodBeat.o(6972);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            return false;
        }
    };
    c upi = new c<cq>() {
        {
            AppMethodBeat.i(6973);
            this.xxI = cq.class.getName().hashCode();
            AppMethodBeat.o(6973);
        }

        private static boolean a(cq cqVar) {
            AppMethodBeat.i(6974);
            if (cqVar instanceof cq) {
                Editor edit = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                XWalkEnvironment.setIpType(com.tencent.mm.m.g.Nu().getInt("WebKernelMode", -1));
                String value = com.tencent.mm.m.g.Nu().getValue("WebviewDownloadTbs");
                String value2 = com.tencent.mm.m.g.Nu().getValue("WebviewEnableTbs");
                String value3 = com.tencent.mm.m.g.Nu().getValue("WebviewSupportedTbsVersionSection");
                ab.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", value, value2, value3);
                if (value != null) {
                    edit.putString("tbs_download", value);
                }
                edit.apply();
                if ("1".equals(value) && "1".equals(value2)) {
                    com.tencent.mm.pluginsdk.ui.tools.m.kT(1);
                }
                if (value != null) {
                    try {
                        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(value)) {
                            ab.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(ah.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                            ah.getContext().sendBroadcast(intent);
                        }
                    } catch (Exception e) {
                        ab.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", e.getMessage());
                    }
                }
            }
            AppMethodBeat.o(6974);
            return false;
        }
    };
    c upj = new c<com.tencent.mm.g.a.b>() {
        {
            AppMethodBeat.i(6976);
            this.xxI = com.tencent.mm.g.a.b.class.getName().hashCode();
            AppMethodBeat.o(6976);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6977);
            com.tencent.mm.g.a.b bVar2 = (com.tencent.mm.g.a.b) bVar;
            if (bVar2 instanceof com.tencent.mm.g.a.b) {
                Intent intent = new Intent();
                if (bVar2.crM != null) {
                    intent.putExtra("card_list", bVar2.crM.crN);
                    intent.putExtra("result_code", bVar2.crM.bFZ);
                }
                if (bVar2.crM == null || bVar2.crM.bFZ != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.dcN().c(16, 0, intent);
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.dcN().c(16, -1, intent);
                }
            }
            AppMethodBeat.o(6977);
            return false;
        }
    };
    c upk = new c<cb>() {
        {
            AppMethodBeat.i(6978);
            this.xxI = cb.class.getName().hashCode();
            AppMethodBeat.o(6978);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6979);
            cb cbVar = (cb) bVar;
            if (cbVar instanceof cb) {
                Intent intent = new Intent();
                if (cbVar.cvk == null || cbVar.cvk.bFZ != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.dcN().c(29, 0, intent);
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.dcN().c(29, -1, intent);
                }
            }
            AppMethodBeat.o(6979);
            return false;
        }
    };
    private c upl = new c<ll>() {
        {
            AppMethodBeat.i(6984);
            this.xxI = ll.class.getName().hashCode();
            AppMethodBeat.o(6984);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(6985);
            ll llVar = (ll) bVar;
            if (llVar.cHk.scene == 0) {
                g.cYD().ugc = 0;
                g.cYD().tZK = null;
            } else {
                g.cYD().ugc = 1;
                g.cYD().tZK = new cvf();
                g.cYD().tZK.xrj = 1;
                g.cYD().tZK.xrk = new li();
                g.cYD().tZK.xrk.csB = llVar.cHk.appId;
                g.cYD().tZK.xrk.vOO = llVar.cHk.type;
                g.cYD().tZK.xrk.vOP = llVar.cHk.version;
                g.cYD().tZK.xrk.kLN = llVar.cHk.cHm;
            }
            AppMethodBeat.o(6985);
            return false;
        }
    };

    public g() {
        AppMethodBeat.i(6991);
        AppMethodBeat.o(6991);
    }

    public static g cYz() {
        AppMethodBeat.i(6992);
        g gVar = (g) q.Y(g.class);
        AppMethodBeat.o(6992);
        return gVar;
    }

    public static com.tencent.mm.plugin.webview.c.a cYA() {
        AppMethodBeat.i(6993);
        if (cYz().uoY == null) {
            cYz().uoY = new com.tencent.mm.plugin.webview.c.a();
        }
        com.tencent.mm.plugin.webview.c.a aVar = cYz().uoY;
        AppMethodBeat.o(6993);
        return aVar;
    }

    public static com.tencent.mm.plugin.webview.fts.a cYB() {
        AppMethodBeat.i(6994);
        if (cYz().uoW == null) {
            cYz().uoW = new com.tencent.mm.plugin.webview.fts.a();
        }
        com.tencent.mm.plugin.webview.fts.a aVar = cYz().uoW;
        AppMethodBeat.o(6994);
        return aVar;
    }

    public static com.tencent.mm.plugin.webview.fts.b cYC() {
        AppMethodBeat.i(6995);
        if (cYz().uoX == null) {
            cYz().uoX = new com.tencent.mm.plugin.webview.fts.b();
        }
        com.tencent.mm.plugin.webview.fts.b bVar = cYz().uoX;
        AppMethodBeat.o(6995);
        return bVar;
    }

    public static com.tencent.mm.plugin.webview.fts.g cYD() {
        AppMethodBeat.i(6996);
        if (cYz().uoV == null) {
            cYz().uoV = new com.tencent.mm.plugin.webview.fts.g();
        }
        com.tencent.mm.plugin.webview.fts.g gVar = cYz().uoV;
        AppMethodBeat.o(6996);
        return gVar;
    }

    public static aj cYE() {
        AppMethodBeat.i(6997);
        if (cYz().uoO == null) {
            cYz().uoO = new aj();
        }
        aj ajVar = cYz().uoO;
        AppMethodBeat.o(6997);
        return ajVar;
    }

    public static ak cYF() {
        AppMethodBeat.i(6998);
        if (cYz().uoP == null) {
            cYz().uoP = ak.cXM();
        }
        ak akVar = cYz().uoP;
        AppMethodBeat.o(6998);
        return akVar;
    }

    public static m cYG() {
        AppMethodBeat.i(6999);
        if (cYz().uoR == null) {
            g cYz = cYz();
            com.tencent.mm.kernel.g.RQ();
            cYz.uoR = new m(com.tencent.mm.kernel.g.RP().eJN);
        }
        m mVar = cYz().uoR;
        AppMethodBeat.o(6999);
        return mVar;
    }

    public static com.tencent.mm.plugin.webview.model.e cYH() {
        AppMethodBeat.i(7000);
        if (cYz().uoS == null) {
            g cYz = cYz();
            com.tencent.mm.kernel.g.RQ();
            cYz.uoS = new com.tencent.mm.plugin.webview.model.e(com.tencent.mm.kernel.g.RP().eJN);
        }
        com.tencent.mm.plugin.webview.model.e eVar = cYz().uoS;
        AppMethodBeat.o(7000);
        return eVar;
    }

    public static am cYI() {
        AppMethodBeat.i(7001);
        if (cYz().uoT == null) {
            g cYz = cYz();
            com.tencent.mm.kernel.g.RQ();
            cYz.uoT = new am(com.tencent.mm.kernel.g.RP().eJN);
        }
        am amVar = cYz().uoT;
        AppMethodBeat.o(7001);
        return amVar;
    }

    public static com.tencent.mm.plugin.webview.b.e cYJ() {
        AppMethodBeat.i(7002);
        if (cYz().uoU == null) {
            g cYz = cYz();
            com.tencent.mm.kernel.g.RQ();
            cYz.uoU = new com.tencent.mm.plugin.webview.b.e(com.tencent.mm.kernel.g.RP().eJN);
        }
        com.tencent.mm.plugin.webview.b.e eVar = cYz().uoU;
        AppMethodBeat.o(7002);
        return eVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(7003);
        ab.i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", Integer.valueOf(hashCode()));
        this.upb.dead();
        com.tencent.mm.sdk.b.a.xxA.d(this.upg);
        com.tencent.mm.sdk.b.a.xxA.d(this.upi);
        com.tencent.mm.sdk.b.a.xxA.d(this.upj);
        com.tencent.mm.sdk.b.a.xxA.d(this.upk);
        com.tencent.mm.sdk.b.a.xxA.d(this.upd);
        com.tencent.mm.sdk.b.a.xxA.d(this.upe);
        com.tencent.mm.sdk.b.a.xxA.d(this.upl);
        com.tencent.mm.sdk.b.a.xxA.d(this.fAP);
        com.tencent.mm.sdk.b.a.xxA.d(this.kBB);
        this.uph.dead();
        this.upc.dead();
        com.tencent.mm.kernel.g.RO().b(this.mwl);
        if (this.uoQ != null) {
            ai aiVar = this.uoQ;
            if (aiVar.qVE != null) {
                com.tencent.mm.plugin.downloader.model.d.bij();
                com.tencent.mm.plugin.downloader.model.b.b(aiVar.qVE);
            }
            if (aiVar.umt != null && aiVar.umt.size() > 0) {
                for (Long l : aiVar.umt) {
                    ab.i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", l);
                    com.tencent.mm.plugin.downloader.model.d.bij().hl(l.longValue());
                }
            }
        }
        if (this.uoX != null) {
            f fVar = this.uoX;
            com.tencent.mm.sdk.b.a.xxA.d(fVar.hAA);
            if (fVar.ufk != null) {
                com.tencent.mm.kernel.g.Rg().b(1048, fVar);
                com.tencent.mm.kernel.g.Rg().c(fVar.ufk);
                fVar.ufk = null;
            }
            this.uoX = null;
        }
        if (this.uoV != null) {
            com.tencent.mm.plugin.webview.fts.g gVar = this.uoV;
            gVar.ufU.dead();
            gVar.ugg.dead();
            com.tencent.mm.plugin.webview.fts.g.a aVar = gVar.ugi;
            if (aVar.ufZ != null) {
                com.tencent.mm.kernel.g.Rg().c(aVar.ufZ);
            }
            if (aVar.ugn != null) {
                aVar.ugn.jxQ = true;
            }
            com.tencent.mm.plugin.webview.fts.g.b bVar = gVar.ugj;
            if (bVar.ugp != null) {
                com.tencent.mm.kernel.g.Rg().b(bVar.ugp.getType(), com.tencent.mm.plugin.webview.fts.g.this);
            }
            if (gVar.mEx != null) {
                ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(gVar.mEx);
                gVar.mEx = null;
            }
            this.uoV = null;
        }
        if (this.uoW != null) {
            com.tencent.mm.plugin.webview.fts.a aVar2 = this.uoW;
            aVar2.qGl.dead();
            aVar2.ufe.dead();
            com.tencent.mm.ah.o.act().d(aVar2);
            this.uoW = null;
        }
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("hijackconfig", this.jCX, true);
        if (this.uoS != null) {
            this.uoS.cXu();
        }
        o oVar = this.uoZ;
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("webcache", oVar.unU, true);
        com.tencent.mm.sdk.b.a.xxA.d(oVar.unV);
        com.tencent.mm.sdk.b.a.xxA.d(oVar.unW);
        com.tencent.mm.plugin.webview.modelcache.r cYq = com.tencent.mm.plugin.webview.modelcache.r.a.uor;
        com.tencent.mm.sdk.b.a.xxA.d(cYq.uoc);
        com.tencent.mm.sdk.b.a.xxA.d(cYq.uod);
        cYq.release(true);
        this.upf.dead();
        com.tencent.mm.plugin.webview.fts.f cWo = com.tencent.mm.plugin.webview.fts.f.cWo();
        com.tencent.mm.plugin.webview.fts.f.a aVar3 = cWo.ufN;
        if (aVar3.ufZ != null) {
            com.tencent.mm.kernel.g.Rg().c(aVar3.ufZ);
        }
        if (aVar3.uga != null) {
            aVar3.uga.jxQ = true;
        }
        cWo.ufU.dead();
        com.tencent.mm.kernel.g.L(com.tencent.mm.plugin.webview.d.a.class);
        cYE().b(this.upa);
        l lVar = l.uzq;
        l.b bVar2 = s.ujG;
        if (bVar2 != null) {
            lVar.uzv.remove(bVar2);
        }
        com.tencent.mm.plugin.downloader.b.a.b(com.tencent.mm.plugin.webview.luggage.a.b.ukQ);
        com.tencent.mm.plugin.webview.luggage.a.b.ukQ = null;
        AppMethodBeat.o(7003);
    }

    static {
        AppMethodBeat.i(7006);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new d() {
            public final String[] Af() {
                return m.fnj;
            }
        });
        LinkedList<com.tencent.mm.plugin.webview.modelcache.e.a> linkedList = new LinkedList();
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.a.cYh());
        linkedList.addAll(com.tencent.mm.plugin.webview.modelcache.l.cYn());
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.i.cYh());
        for (com.tencent.mm.plugin.webview.modelcache.e.a aVar : linkedList) {
            eaA.put(Integer.valueOf(aVar.id), aVar);
        }
        eaA.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.webview.model.e.fnj;
            }
        });
        eaA.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new d() {
            public final String[] Af() {
                return am.fnj;
            }
        });
        eaA.put(Integer.valueOf("WEBVIEW_DATA".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.webview.b.c.fnj;
            }
        });
        eaA.put(Integer.valueOf("WEBVIEW_HISTORY_DATA".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.webview.b.e.fnj;
            }
        });
        AppMethodBeat.o(7006);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(7004);
        ab.i("MicroMsg.SubCoreTools", "onAccountPostReset hc:%d", Integer.valueOf(hashCode()));
        this.upb.dnU();
        com.tencent.mm.sdk.b.a.xxA.c(this.upg);
        com.tencent.mm.sdk.b.a.xxA.c(this.upi);
        com.tencent.mm.sdk.b.a.xxA.c(this.upj);
        com.tencent.mm.sdk.b.a.xxA.c(this.upk);
        com.tencent.mm.sdk.b.a.xxA.c(this.upd);
        com.tencent.mm.sdk.b.a.xxA.c(this.upe);
        com.tencent.mm.sdk.b.a.xxA.c(this.upl);
        com.tencent.mm.sdk.b.a.xxA.c(this.fAP);
        com.tencent.mm.sdk.b.a.xxA.c(this.kBB);
        this.uph.dnU();
        this.upc.dnU();
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("hijackconfig", this.jCX, true);
        com.tencent.mm.kernel.g.RO().a(this.mwl);
        o oVar = this.uoZ;
        com.tencent.mm.plugin.webview.modelcache.r cYq = com.tencent.mm.plugin.webview.modelcache.r.a.uor;
        com.tencent.mm.sdk.b.a.xxA.c(cYq.uoc);
        com.tencent.mm.sdk.b.a.xxA.c(cYq.uod);
        com.tencent.mm.plugin.webview.modelcache.c.cYm();
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("webcache", oVar.unU, true);
        com.tencent.mm.sdk.b.a.xxA.c(oVar.unV);
        com.tencent.mm.sdk.b.a.xxA.c(oVar.unW);
        com.tencent.mm.plugin.w.c.qwS.a(new as());
        this.upf.dnU();
        j.c.a(new com.tencent.mm.ci.c<com.tencent.mm.af.f>() {
            public final /* synthetic */ Object get() {
                AppMethodBeat.i(6988);
                com.tencent.mm.plugin.websearch.api.ab abVar = new com.tencent.mm.plugin.websearch.api.ab();
                AppMethodBeat.o(6988);
                return abVar;
            }
        });
        com.tencent.mm.cj.c.iw(ah.getContext());
        com.tencent.mm.kernel.g.RN();
        XWalkEnvironment.setGrayValueByUserId(com.tencent.mm.kernel.a.QF());
        if (com.tencent.mm.m.g.Nu() != null) {
            XWalkEnvironment.setIpType(com.tencent.mm.m.g.Nu().getInt("WebKernelMode", -1));
        }
        com.tencent.mm.plugin.webview.fts.f.cWo();
        com.tencent.mm.plugin.webview.fts.f.start();
        ab.d("MicroMsg.CityServiceHelper", "addCheckResUpdateListener");
        if (ab.getLogLevel() <= 0) {
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
            com.tencent.mm.pluginsdk.g.a.a.b.Ky(54);
        }
        com.tencent.mm.sdk.b.a.xxA.b(new c<bf>() {
            {
                AppMethodBeat.i(6913);
                this.xxI = bf.class.getName().hashCode();
                AppMethodBeat.o(6913);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(6914);
                bf bfVar = (bf) bVar;
                if (bfVar.cus.cut == 54 && bfVar.cus.cuu == 1) {
                    File file = new File(bfVar.cus.filePath);
                    if (file.exists()) {
                        String cYv = b.cYv();
                        ab.i("MicroMsg.CityServiceHelper", "checkResUpdateListener callback to update %s,savePath %s", file.getAbsoluteFile(), cYv);
                        com.tencent.mm.a.e.deleteFile(cYv);
                        com.tencent.mm.a.e.y(file.getAbsolutePath(), cYv);
                    } else {
                        ab.e("MicroMsg.CityServiceHelper", "checkResUpdateListener file not exist");
                    }
                }
                AppMethodBeat.o(6914);
                return false;
            }
        });
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.webview.d.a.class, new com.tencent.mm.plugin.webview.ui.tools.bag.m());
        this.upa = new com.tencent.mm.plugin.webview.luggage.a();
        cYE().a(this.upa);
        s.ujG = new l.b() {
            public final void cXm() {
                AppMethodBeat.i(6238);
                ToolsProcessIPCService.a(null, a.class, null);
                AppMethodBeat.o(6238);
            }
        };
        l lVar = l.uzq;
        l.b bVar = s.ujG;
        if (bVar != null) {
            lVar.uzv.add(bVar);
        }
        if (com.tencent.mm.plugin.webview.luggage.a.b.ukQ == null) {
            com.tencent.mm.plugin.webview.luggage.a.b.ukQ = new com.tencent.mm.plugin.downloader.b.a.b() {
                public final void E(int i, long j) {
                    AppMethodBeat.i(6421);
                    com.tencent.mm.plugin.downloader.f.a hv;
                    JSONObject jSONObject;
                    Bundle bundle;
                    switch (i) {
                        case 1:
                            hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                            if (hv != null) {
                                jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("appid", hv.field_appId);
                                    jSONObject.put("download_id", hv.field_downloadId);
                                    jSONObject.put("state", "download_start");
                                    bundle = new Bundle();
                                    bundle.putString("name", "wxdownload:state_change");
                                    bundle.putString("data", jSONObject.toString());
                                    ToolsProcessIPCService.a(bundle, a.class, null);
                                    AppMethodBeat.o(6421);
                                    return;
                                } catch (JSONException e) {
                                }
                            }
                            AppMethodBeat.o(6421);
                            return;
                        case 2:
                            hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                            if (hv != null) {
                                jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("appid", hv.field_appId);
                                    jSONObject.put("download_id", hv.field_downloadId);
                                    if (hv.field_fromDownloadApp && hv.field_downloadInWifi && !com.tencent.mm.sdk.platformtools.at.isWifi(ah.getContext())) {
                                        jSONObject.put("state", "download_wait_for_wifi");
                                    } else {
                                        jSONObject.put("state", "download_pause");
                                    }
                                    bundle = new Bundle();
                                    bundle.putString("name", "wxdownload:state_change");
                                    bundle.putString("data", jSONObject.toString());
                                    ToolsProcessIPCService.a(bundle, a.class, null);
                                    AppMethodBeat.o(6421);
                                    return;
                                } catch (JSONException e2) {
                                }
                            }
                            AppMethodBeat.o(6421);
                            return;
                        case 3:
                            hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                            if (hv != null) {
                                jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("appid", hv.field_appId);
                                    jSONObject.put("download_id", hv.field_downloadId);
                                    jSONObject.put("state", "download_succ");
                                    bundle = new Bundle();
                                    bundle.putString("name", "wxdownload:state_change");
                                    bundle.putString("data", jSONObject.toString());
                                    ToolsProcessIPCService.a(bundle, a.class, null);
                                    AppMethodBeat.o(6421);
                                    return;
                                } catch (JSONException e3) {
                                }
                            }
                            AppMethodBeat.o(6421);
                            return;
                        case 4:
                            hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                            if (hv != null) {
                                jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("appid", hv.field_appId);
                                    jSONObject.put("download_id", hv.field_downloadId);
                                    jSONObject.put("state", "download_removed");
                                    bundle = new Bundle();
                                    bundle.putString("name", "wxdownload:state_change");
                                    bundle.putString("data", jSONObject.toString());
                                    ToolsProcessIPCService.a(bundle, a.class, null);
                                    AppMethodBeat.o(6421);
                                    return;
                                } catch (JSONException e4) {
                                }
                            }
                            AppMethodBeat.o(6421);
                            return;
                        case 5:
                            hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                            if (hv != null) {
                                jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("appid", hv.field_appId);
                                    jSONObject.put("download_id", hv.field_downloadId);
                                    jSONObject.put("state", "download_fail");
                                    bundle = new Bundle();
                                    bundle.putString("name", "wxdownload:state_change");
                                    bundle.putString("data", jSONObject.toString());
                                    ToolsProcessIPCService.a(bundle, a.class, null);
                                    AppMethodBeat.o(6421);
                                    return;
                                } catch (JSONException e5) {
                                }
                            }
                            AppMethodBeat.o(6421);
                            return;
                        case 6:
                            hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                            if (hv != null && hv.field_totalSize != 0) {
                                int i2 = (int) ((((double) hv.field_downloadedSize) / ((double) hv.field_totalSize)) * 100.0d);
                                ab.d("MicroMsg.JsDownloadEventDispatch", "onDownloadTaskProgressChanged, progressFloat: %f", Float.valueOf((((float) hv.field_downloadedSize) / ((float) hv.field_totalSize)) * 100.0f));
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("appid", hv.field_appId);
                                    jSONObject2.put("download_id", hv.field_downloadId);
                                    jSONObject2.put("progress", i2);
                                    jSONObject2.put("progress_float", (double) r2);
                                    bundle = new Bundle();
                                    bundle.putString("name", "wxdownload:progress_change");
                                    bundle.putString("data", jSONObject2.toString());
                                    ToolsProcessIPCService.a(bundle, a.class, null);
                                    AppMethodBeat.o(6421);
                                    return;
                                } catch (JSONException e6) {
                                    break;
                                }
                            }
                            ab.w("MicroMsg.JsDownloadEventDispatch", "loadDownloadProgress failed");
                            AppMethodBeat.o(6421);
                            return;
                            break;
                        case 7:
                            hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
                            if (hv != null) {
                                jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("appid", hv.field_appId);
                                    jSONObject.put("download_id", hv.field_downloadId);
                                    jSONObject.put("state", "download_resumed");
                                    bundle = new Bundle();
                                    bundle.putString("name", "wxdownload:state_change");
                                    bundle.putString("data", jSONObject.toString());
                                    ToolsProcessIPCService.a(bundle, a.class, null);
                                    AppMethodBeat.o(6421);
                                    return;
                                } catch (JSONException e7) {
                                }
                            }
                            AppMethodBeat.o(6421);
                            return;
                    }
                    AppMethodBeat.o(6421);
                }
            };
        }
        com.tencent.mm.plugin.downloader.b.a.a(com.tencent.mm.plugin.webview.luggage.a.b.ukQ);
        AppMethodBeat.o(7004);
    }

    public final void bA(boolean z) {
    }

    static /* synthetic */ void IR(int i) {
        AppMethodBeat.i(7005);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadInfo.NETTYPE, i);
            Bundle bundle = new Bundle();
            bundle.putString("name", "onNetWorkChange");
            bundle.putString("data", jSONObject.toString());
            ToolsProcessIPCService.a(bundle, com.tencent.mm.plugin.webview.luggage.a.a.class);
            AppMethodBeat.o(7005);
        } catch (JSONException e) {
            AppMethodBeat.o(7005);
        }
    }
}
