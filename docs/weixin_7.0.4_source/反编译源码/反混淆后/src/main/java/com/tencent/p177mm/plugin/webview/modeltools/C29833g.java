package com.tencent.p177mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C8909j.C8912c;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18433vt;
import com.tencent.p177mm.p230g.p231a.C26190ll;
import com.tencent.p177mm.p230g.p231a.C26265vu;
import com.tencent.p177mm.p230g.p231a.C32517b;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C41973cb;
import com.tencent.p177mm.p230g.p231a.C42028ms;
import com.tencent.p177mm.p230g.p231a.C42080vq;
import com.tencent.p177mm.p230g.p231a.C45334iy;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p940b.C33903a;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.p1622w.C43755c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.plugin.websearch.api.C14420ab;
import com.tencent.p177mm.plugin.webview.fts.C22793f;
import com.tencent.p177mm.plugin.webview.fts.C22793f.C22795a;
import com.tencent.p177mm.plugin.webview.fts.C22797g;
import com.tencent.p177mm.plugin.webview.fts.C22797g.C22798b;
import com.tencent.p177mm.plugin.webview.fts.C22797g.C22803a;
import com.tencent.p177mm.plugin.webview.fts.C43868a;
import com.tencent.p177mm.plugin.webview.fts.C43869b;
import com.tencent.p177mm.plugin.webview.fts.p1327a.p1328a.C40213b;
import com.tencent.p177mm.plugin.webview.fts.p1327a.p1328a.C40213b.C402141;
import com.tencent.p177mm.plugin.webview.fts.p1327a.p1328a.C46410a;
import com.tencent.p177mm.plugin.webview.fts.p1327a.p1328a.C46410a.C402121;
import com.tencent.p177mm.plugin.webview.luggage.C29776a;
import com.tencent.p177mm.plugin.webview.luggage.C29809s;
import com.tencent.p177mm.plugin.webview.luggage.C29809s.C228711;
import com.tencent.p177mm.plugin.webview.luggage.p1141a.C22811b;
import com.tencent.p177mm.plugin.webview.luggage.p1141a.C22811b.C169251;
import com.tencent.p177mm.plugin.webview.luggage.p1141a.C29775a;
import com.tencent.p177mm.plugin.webview.model.C14513as;
import com.tencent.p177mm.plugin.webview.model.C22881aj;
import com.tencent.p177mm.plugin.webview.model.C29817ak;
import com.tencent.p177mm.plugin.webview.model.C29818am;
import com.tencent.p177mm.plugin.webview.model.C31479e;
import com.tencent.p177mm.plugin.webview.model.C43912ai;
import com.tencent.p177mm.plugin.webview.model.C43913ao;
import com.tencent.p177mm.plugin.webview.modelcache.C14526r;
import com.tencent.p177mm.plugin.webview.modelcache.C14526r.C4557a;
import com.tencent.p177mm.plugin.webview.modelcache.C22895a;
import com.tencent.p177mm.plugin.webview.modelcache.C29824c;
import com.tencent.p177mm.plugin.webview.modelcache.C29825i;
import com.tencent.p177mm.plugin.webview.modelcache.C29826l;
import com.tencent.p177mm.plugin.webview.modelcache.C40274o;
import com.tencent.p177mm.plugin.webview.modelcache.C46427e.C40269a;
import com.tencent.p177mm.plugin.webview.modeltools.C35619b.C72021;
import com.tencent.p177mm.plugin.webview.p1325c.C43863a;
import com.tencent.p177mm.plugin.webview.p1326d.C22783a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C29879l;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C29879l.C14591b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43947m;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29944h;
import com.tencent.p177mm.plugin.webview.p768b.C35583e;
import com.tencent.p177mm.plugin.webview.p768b.C7615c;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.pluginsdk.model.C46499v.C30086a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C4782m;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.C35933li;
import com.tencent.p177mm.protocal.protobuf.aqx;
import com.tencent.p177mm.protocal.protobuf.aqy;
import com.tencent.p177mm.protocal.protobuf.cvf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C30284ar;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.g */
public class C29833g implements C1816at {
    private static final HashMap<Integer, C1366d> eaA;
    private C4884c<C32519bf> fAP = new C2289811();
    public boolean isAppActive = true;
    private C1837a jCX = new C2983921();
    C4884c kBB = new C298446();
    private C1923n mwl = new C2983414();
    private C22881aj uoO;
    private C29817ak uoP;
    private C43912ai uoQ;
    private C40277m uoR;
    private C31479e uoS;
    private C29818am uoT;
    private C35583e uoU;
    private C22797g uoV;
    private C43868a uoW;
    private C43869b uoX;
    private C43863a uoY;
    private final C40274o uoZ = new C40274o();
    private C29776a upa;
    private C4884c upb = new C298321();
    private C4884c upc = new C2289912();
    C4884c upd = new C145422();
    C4884c upe = new C298413();
    final C4884c<C42080vq> upf = new C298424();
    C4884c upg = new C298435();
    final C4884c<C6504k> uph = new C229017();
    C4884c upi = new C229028();
    C4884c upj = new C229039();
    C4884c upk = new C2983110();
    private C4884c upl = new C2290013();

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$19 */
    static class C1454119 implements C1366d {
        C1454119() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C35583e.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$2 */
    class C145422 extends C4884c<C18433vt> {
        C145422() {
            AppMethodBeat.m2504i(6961);
            this.xxI = C18433vt.class.getName().hashCode();
            AppMethodBeat.m2505o(6961);
        }

        /* renamed from: a */
        private static boolean m22747a(C18433vt c18433vt) {
            AppMethodBeat.m2504i(6962);
            if (c18433vt instanceof C18433vt) {
                String str;
                String Yz = C1853r.m3846Yz();
                ArrayList arrayList = new ArrayList();
                arrayList.add(c18433vt.cSG.cSH);
                arrayList.add(c18433vt.cSG.cSI);
                arrayList.add(c18433vt.cSG.cSJ);
                arrayList.add(c18433vt.cSG.cSK);
                arrayList.add(c18433vt.cSG.url);
                arrayList.add(c18433vt.cSG.cSL);
                arrayList.add(c18433vt.cSG.cSM);
                arrayList.add(c18433vt.cSG.cSN);
                arrayList.add(c18433vt.cSG.cSO);
                arrayList.add(c18433vt.cSG.cSP);
                arrayList.add(Yz);
                arrayList.add(c18433vt.cSG.cSQ);
                arrayList.add(c18433vt.cSG.cSR);
                PString pString = new PString();
                String a = ((C46210i) C1720g.m3528K(C46210i.class)).mo55529a(c18433vt.cSG.cSS, pString);
                arrayList.add(a);
                arrayList.add("");
                arrayList.add("");
                arrayList.add("");
                int ad = C32798u.m53583ad(c18433vt.cSG.cSJ, c18433vt.cSG.cSK);
                int ad2 = C32798u.m53583ad(Yz, c18433vt.cSG.cSM);
                arrayList.add(String.valueOf(ad));
                arrayList.add(String.valueOf(ad2));
                Object obj = c18433vt.cSG.cST;
                try {
                    obj = URLEncoder.encode(obj, "UTF-8");
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SubCoreTools", e, "", new Object[0]);
                }
                arrayList.add(obj);
                arrayList.add(pString.value);
                String str2 = "MicroMsg.SubCoreTools";
                String str3 = "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s";
                Object[] objArr = new Object[19];
                objArr[0] = c18433vt.cSG.cSH;
                objArr[1] = c18433vt.cSG.cSI;
                objArr[2] = c18433vt.cSG.cSJ;
                objArr[3] = c18433vt.cSG.cSK;
                if (c18433vt.cSG.url == null) {
                    str = c18433vt.cSG.url;
                } else {
                    str = c18433vt.cSG.url.replace(",", "!");
                }
                objArr[4] = str;
                objArr[5] = Integer.valueOf(c18433vt.cSG.cSL);
                objArr[6] = c18433vt.cSG.cSM;
                objArr[7] = c18433vt.cSG.cSN;
                objArr[8] = Integer.valueOf(c18433vt.cSG.cSO);
                objArr[9] = Integer.valueOf(c18433vt.cSG.cSP);
                objArr[10] = Yz;
                objArr[11] = Integer.valueOf(c18433vt.cSG.cSQ);
                if (c18433vt.cSG.cSR == null) {
                    str = c18433vt.cSG.cSR;
                } else {
                    str = c18433vt.cSG.cSR.replace(",", "!");
                }
                objArr[12] = str;
                objArr[13] = c18433vt.cSG.cSS;
                objArr[14] = a;
                objArr[15] = Integer.valueOf(ad);
                objArr[16] = Integer.valueOf(ad2);
                objArr[17] = c18433vt.cSG.cST;
                objArr[18] = pString.value;
                C4990ab.m7411d(str2, str3, objArr);
                if (c18433vt.cSG.cSU != 2) {
                    C7060h c7060h = C7060h.pYm;
                    C7060h.m11802g(11954, arrayList);
                }
                AppMethodBeat.m2505o(6962);
                return true;
            }
            AppMethodBeat.m2505o(6962);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$11 */
    class C2289811 extends C4884c<C32519bf> {
        C2289811() {
            AppMethodBeat.m2504i(6980);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(6980);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6981);
            C32519bf c32519bf = (C32519bf) c4883b;
            if (49 != c32519bf.cus.cut) {
                AppMethodBeat.m2505o(6981);
                return false;
            } else if (1 != c32519bf.cus.cuu) {
                AppMethodBeat.m2505o(6981);
                return false;
            } else if (c32519bf.cus.cuw) {
                C4990ab.m7416i("MicroMsg.SubCoreTools", "receive xweb get config  notify!!");
                C4996ah.getContext();
                C30086a.m47649Kv(5);
                AppMethodBeat.m2505o(6981);
                return true;
            } else {
                C4990ab.m7416i("MicroMsg.SubCoreTools", "receive xweb get config  notify!! fileUpdated == false ignore");
                AppMethodBeat.m2505o(6981);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$12 */
    class C2289912 extends C4884c<C42028ms> {
        C2289912() {
            AppMethodBeat.m2504i(6982);
            this.xxI = C42028ms.class.getName().hashCode();
            AppMethodBeat.m2505o(6982);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6983);
            C42028ms c42028ms = (C42028ms) c4883b;
            C29833g.cYD();
            C22797g.m34604bB(c42028ms.cID.scene, c42028ms.cID.cvF);
            AppMethodBeat.m2505o(6983);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$13 */
    class C2290013 extends C4884c<C26190ll> {
        C2290013() {
            AppMethodBeat.m2504i(6984);
            this.xxI = C26190ll.class.getName().hashCode();
            AppMethodBeat.m2505o(6984);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6985);
            C26190ll c26190ll = (C26190ll) c4883b;
            if (c26190ll.cHk.scene == 0) {
                C29833g.cYD().ugc = 0;
                C29833g.cYD().tZK = null;
            } else {
                C29833g.cYD().ugc = 1;
                C29833g.cYD().tZK = new cvf();
                C29833g.cYD().tZK.xrj = 1;
                C29833g.cYD().tZK.xrk = new C35933li();
                C29833g.cYD().tZK.xrk.csB = c26190ll.cHk.appId;
                C29833g.cYD().tZK.xrk.vOO = c26190ll.cHk.type;
                C29833g.cYD().tZK.xrk.vOP = c26190ll.cHk.version;
                C29833g.cYD().tZK.xrk.kLN = c26190ll.cHk.cHm;
            }
            AppMethodBeat.m2505o(6985);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$7 */
    class C229017 extends C4884c<C6504k> {
        private Boolean upn;

        C229017() {
            AppMethodBeat.m2504i(6972);
            this.upn = null;
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(6972);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$8 */
    class C229028 extends C4884c<C6471cq> {
        C229028() {
            AppMethodBeat.m2504i(6973);
            this.xxI = C6471cq.class.getName().hashCode();
            AppMethodBeat.m2505o(6973);
        }

        /* renamed from: a */
        private static boolean m34752a(C6471cq c6471cq) {
            AppMethodBeat.m2504i(6974);
            if (c6471cq instanceof C6471cq) {
                Editor edit = C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                XWalkEnvironment.setIpType(C26373g.m41964Nu().getInt("WebKernelMode", -1));
                String value = C26373g.m41964Nu().getValue("WebviewDownloadTbs");
                String value2 = C26373g.m41964Nu().getValue("WebviewEnableTbs");
                String value3 = C26373g.m41964Nu().getValue("WebviewSupportedTbsVersionSection");
                C4990ab.m7417i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", value, value2, value3);
                if (value != null) {
                    edit.putString("tbs_download", value);
                }
                edit.apply();
                if ("1".equals(value) && "1".equals(value2)) {
                    C4782m.m7141kT(1);
                }
                if (value != null) {
                    try {
                        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(value)) {
                            C4990ab.m7416i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(C4996ah.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                            C4996ah.getContext().sendBroadcast(intent);
                        }
                    } catch (Exception e) {
                        C4990ab.m7421w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", e.getMessage());
                    }
                }
            }
            AppMethodBeat.m2505o(6974);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$9 */
    class C229039 extends C4884c<C32517b> {
        C229039() {
            AppMethodBeat.m2504i(6976);
            this.xxI = C32517b.class.getName().hashCode();
            AppMethodBeat.m2505o(6976);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6977);
            C32517b c32517b = (C32517b) c4883b;
            if (c32517b instanceof C32517b) {
                Intent intent = new Intent();
                if (c32517b.crM != null) {
                    intent.putExtra("card_list", c32517b.crM.crN);
                    intent.putExtra("result_code", c32517b.crM.bFZ);
                }
                if (c32517b.crM == null || c32517b.crM.bFZ != -1) {
                    C29944h.dcN().mo6069c(16, 0, intent);
                } else {
                    C29944h.dcN().mo6069c(16, -1, intent);
                }
            }
            AppMethodBeat.m2505o(6977);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$10 */
    class C2983110 extends C4884c<C41973cb> {
        C2983110() {
            AppMethodBeat.m2504i(6978);
            this.xxI = C41973cb.class.getName().hashCode();
            AppMethodBeat.m2505o(6978);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6979);
            C41973cb c41973cb = (C41973cb) c4883b;
            if (c41973cb instanceof C41973cb) {
                Intent intent = new Intent();
                if (c41973cb.cvk == null || c41973cb.cvk.bFZ != -1) {
                    C29944h.dcN().mo6069c(29, 0, intent);
                } else {
                    C29944h.dcN().mo6069c(29, -1, intent);
                }
            }
            AppMethodBeat.m2505o(6979);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$1 */
    class C298321 extends C4884c<C6504k> {
        C298321() {
            super(0);
            AppMethodBeat.m2504i(6959);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(6959);
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x01a0  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x01e2  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x00ca  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6960);
            if (((C6504k) c4883b).csh.csi) {
                Object obj;
                C46410a cWq;
                C40213b cWr = C40213b.cWr();
                long currentTimeMillis = System.currentTimeMillis();
                C42142a c42142a = C32718b.eGM;
                C5141c ll = C42142a.m74295ll("100429");
                if (ll == null || !ll.isValid()) {
                    C4990ab.m7416i("WidgetPkgPreDownloadMgr", "abtest null or invalid");
                } else if (C40213b.m68970a(ll)) {
                    if (System.currentTimeMillis() - C30284ar.m48183s(C4996ah.getContext(), "WidgetPkgPreDownloadMgr", 4).getLong("last-timestamp", 0) > ((long) (C5046bo.ank((String) ll.dru().get("reqTimeInterval")) * 1000))) {
                        obj = 1;
                    } else {
                        C4990ab.m7417i("WidgetPkgPreDownloadMgr", "abtest interval %d, do not check ,wait for next check", Long.valueOf((long) (C5046bo.ank((String) ll.dru().get("reqTimeInterval")) * 1000)));
                        obj = null;
                    }
                    if (obj != null) {
                        String str = (String) ll.dru().get(TencentLocation.NETWORK_PROVIDER);
                        if (TextUtils.isEmpty(str)) {
                            obj = 1;
                        } else {
                            if (C5023at.m7471gB(C4996ah.getContext()).equalsIgnoreCase(str)) {
                                obj = 1;
                            } else {
                                C4990ab.m7417i("WidgetPkgPreDownloadMgr", "abtest net type not match item.net %s, curNet %s ", str, C5023at.m7471gB(C4996ah.getContext()));
                                obj = null;
                            }
                        }
                        if (obj != null) {
                            str = (String) ll.dru().get("preloadTimePeriod");
                            C4990ab.m7417i("WidgetPkgPreDownloadMgr", "preloadTimePeriod %s", str);
                            if (!TextUtils.isEmpty(str)) {
                                String[] split = str.split("-");
                                if (split.length == 2) {
                                    int ank = C5046bo.ank(split[0]);
                                    int ank2 = C5046bo.ank(split[1]);
                                    int i = Calendar.getInstance().get(11);
                                    if (i <= ank || i >= ank2) {
                                        C4990ab.m7416i("WidgetPkgPreDownloadMgr", "not in preload period");
                                        obj = null;
                                    }
                                } else {
                                    obj = null;
                                }
                                if (obj != null) {
                                    obj = 1;
                                    if (obj == null) {
                                        C4990ab.m7416i("WidgetPkgPreDownloadMgr", "do check");
                                        C7060h.pYm.mo15419k(918, 0, 1);
                                        C30284ar.m48183s(C4996ah.getContext(), "WidgetPkgPreDownloadMgr", 4).edit().putLong("last-timestamp", System.currentTimeMillis()).commit();
                                        C1196a c1196a = new C1196a();
                                        c1196a.fsJ = new aqx();
                                        c1196a.fsK = new aqy();
                                        c1196a.uri = "/cgi-bin/mmux-bin/wxaapp_weappsearchlocal";
                                        c1196a.fsI = 2601;
                                        C1226w.m2655a(c1196a.acD(), new C402141(), true);
                                    } else {
                                        C4990ab.m7416i("WidgetPkgPreDownloadMgr", "do not check");
                                    }
                                    C4990ab.m7417i("WidgetPkgPreDownloadMgr", "[checkUpdate] COST:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    cWq = C46410a.cWq();
                                    if (System.currentTimeMillis() - C30284ar.m48183s(C4996ah.getContext(), "WidgetPkgCoverageReport", 4).getLong("last-timestamp", 0) > 86400000) {
                                        C30284ar.m48183s(C4996ah.getContext(), "WidgetPkgCoverageReport", 4).edit().putLong("last-timestamp", System.currentTimeMillis()).commit();
                                        C7305d.post(new C402121(), "WidgetPkgCoverageReport");
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
                C4990ab.m7417i("WidgetPkgPreDownloadMgr", "[checkUpdate] COST:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                cWq = C46410a.cWq();
                if (System.currentTimeMillis() - C30284ar.m48183s(C4996ah.getContext(), "WidgetPkgCoverageReport", 4).getLong("last-timestamp", 0) > 86400000) {
                }
            }
            AppMethodBeat.m2505o(6960);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$14 */
    class C2983414 extends C1924a {
        private final byte[] ecf = new byte[0];

        C2983414() {
            AppMethodBeat.m2504i(6986);
            AppMethodBeat.m2505o(6986);
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(6987);
            synchronized (this.ecf) {
                try {
                    if (C5023at.getNetType(C4996ah.getContext()) == 0) {
                        C43913ao.cXP().setNetWorkState(1);
                    } else {
                        C43913ao.cXP().setNetWorkState(2);
                    }
                    C29833g.m47300IR(i);
                } finally {
                    AppMethodBeat.m2505o(6987);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$20 */
    class C2983520 implements C32467c<C37435f> {
        C2983520() {
        }

        public final /* synthetic */ Object get() {
            AppMethodBeat.m2504i(6988);
            C14420ab c14420ab = new C14420ab();
            AppMethodBeat.m2505o(6988);
            return c14420ab;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$16 */
    static class C2983616 implements C1366d {
        C2983616() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C31479e.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$17 */
    static class C2983717 implements C1366d {
        C2983717() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C29818am.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$18 */
    static class C2983818 implements C1366d {
        C2983818() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7615c.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$21 */
    class C2983921 implements C1837a {
        C2983921() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(6990);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            final C40277m cYG = C29833g.cYG();
            new Thread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6989);
                    C4990ab.m7410d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
                    Map z = C5049br.m7595z(a, "sysmsg");
                    long j = C5046bo.getLong((String) z.get(".sysmsg.hijackconfig.expiretime"), Long.MAX_VALUE);
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
                        if (C5046bo.isNullOrNil(str2)) {
                            AppMethodBeat.m2505o(6989);
                            return;
                        }
                        C16930i c16930i = new C16930i();
                        c16930i.field_expireTime = j;
                        c16930i.field_host = str2;
                        cYG.mo10101b((C4925c) c16930i);
                        str2 = str3;
                    }
                }
            }).start();
            AppMethodBeat.m2505o(6990);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$3 */
    class C298413 extends C4884c<C26265vu> {
        C298413() {
            AppMethodBeat.m2504i(6964);
            this.xxI = C26265vu.class.getName().hashCode();
            AppMethodBeat.m2505o(6964);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6965);
            C26265vu c26265vu = (C26265vu) c4883b;
            if (c26265vu instanceof C26265vu) {
                C43924a.m78787IT(c26265vu.cSV.cSW);
                AppMethodBeat.m2505o(6965);
                return true;
            }
            AppMethodBeat.m2505o(6965);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$4 */
    class C298424 extends C4884c<C42080vq> {
        C298424() {
            AppMethodBeat.m2504i(6966);
            this.xxI = C42080vq.class.getName().hashCode();
            AppMethodBeat.m2505o(6966);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6967);
            C14513as.unx = ((C42080vq) c4883b).cSC.cSD.substring(11);
            AppMethodBeat.m2505o(6967);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$5 */
    class C298435 extends C4884c<C45334iy> {
        C298435() {
            AppMethodBeat.m2504i(6968);
            this.xxI = C45334iy.class.getName().hashCode();
            AppMethodBeat.m2505o(6968);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6969);
            C45334iy c45334iy = (C45334iy) c4883b;
            if (c45334iy instanceof C45334iy) {
                C29944h.dcN().mo6069c(c45334iy.cEc.requestCode, c45334iy.cEc.bFZ, c45334iy.cEc.cEd);
                AppMethodBeat.m2505o(6969);
                return true;
            }
            AppMethodBeat.m2505o(6969);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$6 */
    class C298446 extends C4884c<C6504k> {
        C298446() {
            AppMethodBeat.m2504i(6970);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(6970);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6971);
            C6504k c6504k = (C6504k) c4883b;
            if (c6504k.csh == null) {
                AppMethodBeat.m2505o(6971);
            } else {
                C4990ab.m7417i("MicroMsg.SubCoreTools", "appActiveListener isActive:%b", Boolean.valueOf(c6504k.csh.csi));
                if (c6504k.csh.csi) {
                    C29879l.uzq.mo48112nU(true);
                } else {
                    C29879l.uzq.dbi();
                }
                C29833g.this.isAppActive = c6504k.csh.csi;
                AppMethodBeat.m2505o(6971);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.g$15 */
    static class C2984515 implements C1366d {
        C2984515() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C40277m.fnj;
        }
    }

    public C29833g() {
        AppMethodBeat.m2504i(6991);
        AppMethodBeat.m2505o(6991);
    }

    public static C29833g cYz() {
        AppMethodBeat.m2504i(6992);
        C29833g c29833g = (C29833g) C7485q.m12925Y(C29833g.class);
        AppMethodBeat.m2505o(6992);
        return c29833g;
    }

    public static C43863a cYA() {
        AppMethodBeat.m2504i(6993);
        if (C29833g.cYz().uoY == null) {
            C29833g.cYz().uoY = new C43863a();
        }
        C43863a c43863a = C29833g.cYz().uoY;
        AppMethodBeat.m2505o(6993);
        return c43863a;
    }

    public static C43868a cYB() {
        AppMethodBeat.m2504i(6994);
        if (C29833g.cYz().uoW == null) {
            C29833g.cYz().uoW = new C43868a();
        }
        C43868a c43868a = C29833g.cYz().uoW;
        AppMethodBeat.m2505o(6994);
        return c43868a;
    }

    public static C43869b cYC() {
        AppMethodBeat.m2504i(6995);
        if (C29833g.cYz().uoX == null) {
            C29833g.cYz().uoX = new C43869b();
        }
        C43869b c43869b = C29833g.cYz().uoX;
        AppMethodBeat.m2505o(6995);
        return c43869b;
    }

    public static C22797g cYD() {
        AppMethodBeat.m2504i(6996);
        if (C29833g.cYz().uoV == null) {
            C29833g.cYz().uoV = new C22797g();
        }
        C22797g c22797g = C29833g.cYz().uoV;
        AppMethodBeat.m2505o(6996);
        return c22797g;
    }

    public static C22881aj cYE() {
        AppMethodBeat.m2504i(6997);
        if (C29833g.cYz().uoO == null) {
            C29833g.cYz().uoO = new C22881aj();
        }
        C22881aj c22881aj = C29833g.cYz().uoO;
        AppMethodBeat.m2505o(6997);
        return c22881aj;
    }

    public static C29817ak cYF() {
        AppMethodBeat.m2504i(6998);
        if (C29833g.cYz().uoP == null) {
            C29833g.cYz().uoP = C29817ak.cXM();
        }
        C29817ak c29817ak = C29833g.cYz().uoP;
        AppMethodBeat.m2505o(6998);
        return c29817ak;
    }

    public static C40277m cYG() {
        AppMethodBeat.m2504i(6999);
        if (C29833g.cYz().uoR == null) {
            C29833g cYz = C29833g.cYz();
            C1720g.m3537RQ();
            cYz.uoR = new C40277m(C1720g.m3536RP().eJN);
        }
        C40277m c40277m = C29833g.cYz().uoR;
        AppMethodBeat.m2505o(6999);
        return c40277m;
    }

    public static C31479e cYH() {
        AppMethodBeat.m2504i(7000);
        if (C29833g.cYz().uoS == null) {
            C29833g cYz = C29833g.cYz();
            C1720g.m3537RQ();
            cYz.uoS = new C31479e(C1720g.m3536RP().eJN);
        }
        C31479e c31479e = C29833g.cYz().uoS;
        AppMethodBeat.m2505o(7000);
        return c31479e;
    }

    public static C29818am cYI() {
        AppMethodBeat.m2504i(7001);
        if (C29833g.cYz().uoT == null) {
            C29833g cYz = C29833g.cYz();
            C1720g.m3537RQ();
            cYz.uoT = new C29818am(C1720g.m3536RP().eJN);
        }
        C29818am c29818am = C29833g.cYz().uoT;
        AppMethodBeat.m2505o(7001);
        return c29818am;
    }

    public static C35583e cYJ() {
        AppMethodBeat.m2504i(7002);
        if (C29833g.cYz().uoU == null) {
            C29833g cYz = C29833g.cYz();
            C1720g.m3537RQ();
            cYz.uoU = new C35583e(C1720g.m3536RP().eJN);
        }
        C35583e c35583e = C29833g.cYz().uoU;
        AppMethodBeat.m2505o(7002);
        return c35583e;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(7003);
        C4990ab.m7417i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", Integer.valueOf(hashCode()));
        this.upb.dead();
        C4879a.xxA.mo10053d(this.upg);
        C4879a.xxA.mo10053d(this.upi);
        C4879a.xxA.mo10053d(this.upj);
        C4879a.xxA.mo10053d(this.upk);
        C4879a.xxA.mo10053d(this.upd);
        C4879a.xxA.mo10053d(this.upe);
        C4879a.xxA.mo10053d(this.upl);
        C4879a.xxA.mo10053d(this.fAP);
        C4879a.xxA.mo10053d(this.kBB);
        this.uph.dead();
        this.upc.dead();
        C1720g.m3535RO().mo5188b(this.mwl);
        if (this.uoQ != null) {
            C43912ai c43912ai = this.uoQ;
            if (c43912ai.qVE != null) {
                C2896d.bij();
                C2886b.m5130b(c43912ai.qVE);
            }
            if (c43912ai.umt != null && c43912ai.umt.size() > 0) {
                for (Long l : c43912ai.umt) {
                    C4990ab.m7417i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", l);
                    C2896d.bij().mo7047hl(l.longValue());
                }
            }
        }
        if (this.uoX != null) {
            C1202f c1202f = this.uoX;
            C4879a.xxA.mo10053d(c1202f.hAA);
            if (c1202f.ufk != null) {
                C1720g.m3540Rg().mo14546b(1048, c1202f);
                C1720g.m3540Rg().mo14547c(c1202f.ufk);
                c1202f.ufk = null;
            }
            this.uoX = null;
        }
        if (this.uoV != null) {
            C22797g c22797g = this.uoV;
            c22797g.ufU.dead();
            c22797g.ugg.dead();
            C22803a c22803a = c22797g.ugi;
            if (c22803a.ufZ != null) {
                C1720g.m3540Rg().mo14547c(c22803a.ufZ);
            }
            if (c22803a.ugn != null) {
                c22803a.ugn.jxQ = true;
            }
            C22798b c22798b = c22797g.ugj;
            if (c22798b.ugp != null) {
                C1720g.m3540Rg().mo14546b(c22798b.ugp.getType(), C22797g.this);
            }
            if (c22797g.mEx != null) {
                ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(c22797g.mEx);
                c22797g.mEx = null;
            }
            this.uoV = null;
        }
        if (this.uoW != null) {
            C43868a c43868a = this.uoW;
            c43868a.qGl.dead();
            c43868a.ufe.dead();
            C17884o.act().mo10117d(c43868a);
            this.uoW = null;
        }
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("hijackconfig", this.jCX, true);
        if (this.uoS != null) {
            this.uoS.cXu();
        }
        C40274o c40274o = this.uoZ;
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("webcache", c40274o.unU, true);
        C4879a.xxA.mo10053d(c40274o.unV);
        C4879a.xxA.mo10053d(c40274o.unW);
        C14526r cYq = C4557a.uor;
        C4879a.xxA.mo10053d(cYq.uoc);
        C4879a.xxA.mo10053d(cYq.uod);
        cYq.release(true);
        this.upf.dead();
        C22793f cWo = C22793f.cWo();
        C22795a c22795a = cWo.ufN;
        if (c22795a.ufZ != null) {
            C1720g.m3540Rg().mo14547c(c22795a.ufZ);
        }
        if (c22795a.uga != null) {
            c22795a.uga.jxQ = true;
        }
        cWo.ufU.dead();
        C1720g.m3529L(C22783a.class);
        C29833g.cYE().mo38477b(this.upa);
        C29879l c29879l = C29879l.uzq;
        C14591b c14591b = C29809s.ujG;
        if (c14591b != null) {
            c29879l.uzv.remove(c14591b);
        }
        C33903a.m55477b(C22811b.ukQ);
        C22811b.ukQ = null;
        AppMethodBeat.m2505o(7003);
    }

    static {
        AppMethodBeat.m2504i(7006);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new C2984515());
        LinkedList<C40269a> linkedList = new LinkedList();
        linkedList.add(C22895a.cYh());
        linkedList.addAll(C29826l.cYn());
        linkedList.add(C29825i.cYh());
        for (C40269a c40269a : linkedList) {
            eaA.put(Integer.valueOf(c40269a.f16197id), c40269a);
        }
        eaA.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new C2983616());
        eaA.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new C2983717());
        eaA.put(Integer.valueOf("WEBVIEW_DATA".hashCode()), new C2983818());
        eaA.put(Integer.valueOf("WEBVIEW_HISTORY_DATA".hashCode()), new C1454119());
        AppMethodBeat.m2505o(7006);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(7004);
        C4990ab.m7417i("MicroMsg.SubCoreTools", "onAccountPostReset hc:%d", Integer.valueOf(hashCode()));
        this.upb.dnU();
        C4879a.xxA.mo10052c(this.upg);
        C4879a.xxA.mo10052c(this.upi);
        C4879a.xxA.mo10052c(this.upj);
        C4879a.xxA.mo10052c(this.upk);
        C4879a.xxA.mo10052c(this.upd);
        C4879a.xxA.mo10052c(this.upe);
        C4879a.xxA.mo10052c(this.upl);
        C4879a.xxA.mo10052c(this.fAP);
        C4879a.xxA.mo10052c(this.kBB);
        this.uph.dnU();
        this.upc.dnU();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("hijackconfig", this.jCX, true);
        C1720g.m3535RO().mo5187a(this.mwl);
        C40274o c40274o = this.uoZ;
        C14526r cYq = C4557a.uor;
        C4879a.xxA.mo10052c(cYq.uoc);
        C4879a.xxA.mo10052c(cYq.uod);
        C29824c.cYm();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("webcache", c40274o.unU, true);
        C4879a.xxA.mo10052c(c40274o.unV);
        C4879a.xxA.mo10052c(c40274o.unW);
        C43755c.qwS.mo69466a(new C14513as());
        this.upf.dnU();
        C8912c.m16075a(new C2983520());
        C45287c.m83506iw(C4996ah.getContext());
        C1720g.m3534RN();
        XWalkEnvironment.setGrayValueByUserId(C1668a.m3383QF());
        if (C26373g.m41964Nu() != null) {
            XWalkEnvironment.setIpType(C26373g.m41964Nu().getInt("WebKernelMode", -1));
        }
        C22793f.cWo();
        C22793f.start();
        C4990ab.m7410d("MicroMsg.CityServiceHelper", "addCheckResUpdateListener");
        if (C4990ab.getLogLevel() <= 0) {
            C14845c.veg;
            C14839b.m23095Ky(54);
        }
        C4879a.xxA.mo10051b(new C72021());
        C1720g.m3542a(C22783a.class, new C43947m());
        this.upa = new C29776a();
        C29833g.cYE().mo38473a(this.upa);
        C29809s.ujG = new C228711();
        C29879l c29879l = C29879l.uzq;
        C14591b c14591b = C29809s.ujG;
        if (c14591b != null) {
            c29879l.uzv.add(c14591b);
        }
        if (C22811b.ukQ == null) {
            C22811b.ukQ = new C169251();
        }
        C33903a.m55476a(C22811b.ukQ);
        AppMethodBeat.m2505o(7004);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: IR */
    static /* synthetic */ void m47300IR(int i) {
        AppMethodBeat.m2504i(7005);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadInfo.NETTYPE, i);
            Bundle bundle = new Bundle();
            bundle.putString("name", "onNetWorkChange");
            bundle.putString("data", jSONObject.toString());
            ToolsProcessIPCService.m63912a(bundle, C29775a.class);
            AppMethodBeat.m2505o(7005);
        } catch (JSONException e) {
            AppMethodBeat.m2505o(7005);
        }
    }
}
