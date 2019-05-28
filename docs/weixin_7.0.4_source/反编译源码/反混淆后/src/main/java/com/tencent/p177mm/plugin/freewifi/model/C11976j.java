package com.tencent.p177mm.plugin.freewifi.model;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26083af;
import com.tencent.p177mm.p230g.p231a.C32512ae;
import com.tencent.p177mm.p230g.p231a.C32552fe;
import com.tencent.p177mm.p230g.p231a.C32561go;
import com.tencent.p177mm.p230g.p231a.C32562gp;
import com.tencent.p177mm.p230g.p231a.C45358pm;
import com.tencent.p177mm.p230g.p231a.C6462bk;
import com.tencent.p177mm.p230g.p231a.C6462bk.C6463a;
import com.tencent.p177mm.p230g.p231a.C6480fh;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.freewifi.C11963i.C11964a;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C45955h.C39112b;
import com.tencent.p177mm.plugin.freewifi.model.C3141b.C3143a;
import com.tencent.p177mm.plugin.freewifi.model.C3141b.C3144b;
import com.tencent.p177mm.plugin.freewifi.model.C34191h.C20801b;
import com.tencent.p177mm.plugin.freewifi.model.C34191h.C28083a;
import com.tencent.p177mm.plugin.freewifi.model.C43113e.C207981;
import com.tencent.p177mm.plugin.freewifi.model.C45959f.C11971b;
import com.tencent.p177mm.plugin.freewifi.model.C45959f.C45958a;
import com.tencent.p177mm.plugin.freewifi.p1264c.C20780a;
import com.tencent.p177mm.plugin.freewifi.p416d.C20781g;
import com.tencent.p177mm.plugin.freewifi.p416d.C39101d;
import com.tencent.p177mm.plugin.freewifi.p416d.C44739k;
import com.tencent.p177mm.plugin.freewifi.p417g.C11961b;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.plugin.freewifi.p417g.C39110f;
import com.tencent.p177mm.plugin.freewifi.p417g.C7605d;
import com.tencent.p177mm.plugin.freewifi.p418ui.C28103a;
import com.tencent.p177mm.plugin.freewifi.p973b.C11949b.C11950a;
import com.tencent.p177mm.plugin.freewifi.p973b.C28070c;
import com.tencent.p177mm.plugin.freewifi.p974e.C39103b;
import com.tencent.p177mm.plugin.freewifi.p974e.C45952c.C391041;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.C7257dh;
import com.tencent.p177mm.protocal.protobuf.buc;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.freewifi.model.j */
public final class C11976j implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C4884c gRa = new C119733();
    private C1837a luy = new C119794();
    private volatile C45957d mwd;
    private volatile C7605d mwe;
    private volatile C11961b mwf;
    private volatile C39110f mwg;
    private volatile C3145c mwh;
    private volatile C3145c mwi;
    private volatile C3139a mwj;
    private volatile C43113e mwk;
    private C1923n mwl = new C119827();
    private C4884c mwm = new C119788();
    private C4884c mwn = new C119749();
    private C4884c mwo = new C1197710();
    private C4884c mwp = new C691311();
    private C4884c mwq = new C691412();
    private C4884c mwr = new C69162();

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$11 */
    class C691311 extends C4884c<C6480fh> {
        C691311() {
            AppMethodBeat.m2504i(20753);
            this.xxI = C6480fh.class.getName().hashCode();
            AppMethodBeat.m2505o(20753);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20754);
            C28070c.byA().mo45991a((C6480fh) c4883b);
            AppMethodBeat.m2505o(20754);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$12 */
    class C691412 extends C4884c<C32552fe> {
        C691412() {
            AppMethodBeat.m2504i(20755);
            this.xxI = C32552fe.class.getName().hashCode();
            AppMethodBeat.m2505o(20755);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20756);
            C11950a.mvi.mo23794a((C32552fe) c4883b);
            AppMethodBeat.m2505o(20756);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$1 */
    static class C69151 implements C1366d {
        C69151() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7605d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$2 */
    class C69162 extends C4884c<C32562gp> {
        C69162() {
            AppMethodBeat.m2504i(20738);
            this.xxI = C32562gp.class.getName().hashCode();
            AppMethodBeat.m2505o(20738);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20739);
            C32562gp c32562gp = (C32562gp) c4883b;
            C39103b.bzr();
            C39103b.m66544aa(c32562gp.cBm.intent);
            AppMethodBeat.m2505o(20739);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$3 */
    class C119733 extends C4884c<C32512ae> {
        C119733() {
            AppMethodBeat.m2504i(20740);
            this.xxI = C32512ae.class.getName().hashCode();
            AppMethodBeat.m2505o(20740);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20741);
            C26083af c26083af = new C26083af();
            c26083af.csZ.ctb = new C28103a(C4996ah.getContext());
            C4879a.xxA.mo10055m(c26083af);
            AppMethodBeat.m2505o(20741);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$9 */
    class C119749 extends C4884c<C45358pm> {
        C119749() {
            AppMethodBeat.m2504i(20748);
            this.xxI = C45358pm.class.getName().hashCode();
            AppMethodBeat.m2505o(20748);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20749);
            C45358pm c45358pm = (C45358pm) c4883b;
            int networkType = C45957d.getNetworkType();
            if (!(networkType == 0 || networkType == -1)) {
                C4990ab.m7416i("MicroMsg.FreeWifi.SubCoreFreeWifi", "networkType is " + networkType + ", start to scan and report near field wifi, to get a pushed message for connecting wifi.");
                final String str = c45358pm.cLH.userName;
                C20801b.mwc.mo54766a(new C28083a() {
                    /* renamed from: bU */
                    public final void mo23813bU(List<ScanResult> list) {
                        AppMethodBeat.m2504i(20747);
                        if (list == null || list.size() == 0) {
                            AppMethodBeat.m2505o(20747);
                            return;
                        }
                        buc buc = new buc();
                        buc.wVV = new LinkedList();
                        for (ScanResult scanResult : list) {
                            if (scanResult != null) {
                                C7257dh c7257dh = new C7257dh();
                                c7257dh.mac = scanResult.BSSID;
                                c7257dh.vFl = scanResult.level;
                                c7257dh.ssid = scanResult.SSID;
                                buc.wVV.add(c7257dh);
                            }
                        }
                        String bys = C34189m.bys();
                        C11967a byo = C11966k.byo();
                        byo.kBq = bys;
                        byo.muf = C11968b.ScanNearFieldWifiAndReport.muQ;
                        byo.mug = C11968b.ScanNearFieldWifiAndReport.name;
                        byo.cIb = 8;
                        byo.byq().byp();
                        new C44739k(str, buc, 8, bys).mo68619c(null);
                        AppMethodBeat.m2505o(20747);
                    }
                });
            }
            AppMethodBeat.m2505o(20749);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$10 */
    class C1197710 extends C4884c<C32561go> {
        C1197710() {
            AppMethodBeat.m2504i(20750);
            this.xxI = C32561go.class.getName().hashCode();
            AppMethodBeat.m2505o(20750);
        }

        /* renamed from: a */
        private static boolean m19886a(C32561go c32561go) {
            AppMethodBeat.m2504i(20751);
            if (c32561go.cBl.data == "MAIN_UI_EVENT_UPDATE_VIEW" && C34189m.byr()) {
                String str = "InterruptedProtocol31-" + System.currentTimeMillis();
                C11971b byQ = C45958a.mvN.byQ();
                if (!(byQ == null || byQ.mvR || System.currentTimeMillis() - byQ.mvE > 180000 || C34189m.isEmpty(byQ.mvP) || C34189m.isEmpty(byQ.mvO) || C34189m.isEmpty(byQ.mvQ))) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", str, Integer.valueOf(1), byQ.mvO, byQ.mvP, byQ.mvQ, Long.valueOf(byQ.mvE));
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. ", str, Integer.valueOf(2));
                    String Mx = C34189m.m56059Mx("MicroMsg.FreeWifi.Protocol31Handler");
                    if (C34189m.m56057Mv(byQ.mvO).equals(Mx)) {
                        String My = C34189m.m56060My("MicroMsg.FreeWifi.Protocol31Handler");
                        String Mz = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol31Handler");
                        synchronized (C45958a.mvN) {
                            try {
                                if (byQ != C45958a.mvN.byQ()) {
                                } else {
                                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", str, Integer.valueOf(3), Mx, My, Mz);
                                    new C20781g(Mx, My, Mz).mo68619c(new C391041(str, byQ));
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(20751);
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(20751);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$8 */
    class C119788 extends C4884c<C6462bk> {
        C119788() {
            AppMethodBeat.m2504i(20745);
            this.xxI = C6462bk.class.getName().hashCode();
            AppMethodBeat.m2505o(20745);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(20746);
            C6462bk c6462bk = (C6462bk) c4883b;
            C4990ab.m7410d("MicroMsg.FreeWifi.SubCoreFreeWifi", "receive CheckWechatFreeWifiEvent");
            if (C45957d.getNetworkType() != 0) {
                C4990ab.m7410d("MicroMsg.FreeWifi.SubCoreFreeWifi", "not wifi");
            } else {
                C11976j.byV();
                c6462bk.cuE.cuG = C39112b.mtY.byk();
                c6462bk.cuE.cuF = C39112b.mtY.byj();
                String byO = C45957d.byO();
                String byK = C45957d.byK();
                if (!(C5046bo.isNullOrNil(byO) || C5046bo.isNullOrNil(byK))) {
                    C3137c ML = C11976j.byW().mo17045ML(byO);
                    if (ML != null) {
                        c6462bk.cuE.cuH = ML.field_url;
                    }
                    c6462bk.cuE.ssid = byO;
                    c6462bk.cuE.bssid = C34189m.m56060My("MicroMsg.FreeWifi.FreeWifiManager");
                    c6462bk.cuE.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.FreeWifiManager");
                    if (ML != null && byO.equalsIgnoreCase(ML.field_ssid) && byK.equalsIgnoreCase(ML.field_mac)) {
                        C6463a c6463a = c6462bk.cuE;
                        if (ML == null) {
                            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "filterLang, freewifi info is null");
                            byO = null;
                        } else {
                            byO = C4988aa.dor();
                            if (byO.equals("zh_CN")) {
                                byO = ML.field_showWordCn;
                            } else if (byO.equals("zh_TW") || byO.equals("zh_HK")) {
                                byO = ML.field_showWordTw;
                            } else {
                                byO = ML.field_showWordEn;
                            }
                        }
                        c6463a.cuJ = byO;
                        if (!(C34189m.isEmpty(c6462bk.cuE.cuJ) || C11964a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1)) {
                            C11964a.mtZ.mo23806ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 1);
                        }
                        if (ML.field_expiredTime - C5046bo.anT() < 0) {
                            C11976j.bzb().byF();
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(20746);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$4 */
    class C119794 implements C1837a {
        C119794() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(20742);
            C43113e bzc = C11976j.bzc();
            C7254cm c7254cm = c1197a.eAB;
            if (1 != C11964a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
                C11964a.mtZ.mo23806ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
            }
            if (c7254cm == null || c7254cm.vED == null) {
                C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                AppMethodBeat.m2505o(20742);
                return;
            }
            String a = C1946aa.m4148a(c7254cm.vED);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", Long.valueOf(c7254cm.ptF), a);
            if (C34189m.isEmpty(a)) {
                C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                AppMethodBeat.m2505o(20742);
                return;
            }
            C20780a MB = C20780a.m32008MB(a);
            if (MB == null) {
                C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                AppMethodBeat.m2505o(20742);
                return;
            }
            new C39101d(C34189m.m56059Mx("MicroMsg.FreeWifi.FreeWifiMessageService"), C34189m.m56060My("MicroMsg.FreeWifi.FreeWifiMessageService"), C34189m.m56061Mz("MicroMsg.FreeWifi.FreeWifiMessageService"), MB.mvw, MB.mvt, MB.mvx, MB.ssid, MB.bssid).mo68619c(new C207981(c7254cm));
            AppMethodBeat.m2505o(20742);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$5 */
    static class C119805 implements C1366d {
        C119805() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C11961b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$6 */
    static class C119816 implements C1366d {
        C119816() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C39110f.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.j$7 */
    class C119827 extends C1924a {
        private byte[] ecf = new byte[0];

        C119827() {
            AppMethodBeat.m2504i(20743);
            AppMethodBeat.m2505o(20743);
        }

        /* JADX WARNING: Missing block: B:39:0x0131, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(20744);
     */
        /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(20744);
            synchronized (this.ecf) {
                try {
                    if (C9638aw.m17179RK()) {
                        C4990ab.m7416i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + i + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
                        ConnectivityManager connectivityManager = (ConnectivityManager) C4996ah.getContext().getSystemService("connectivity");
                        if (connectivityManager == null) {
                            AppMethodBeat.m2505o(20744);
                            return;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                        if (networkInfo != null) {
                            C4990ab.m7416i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:".concat(String.valueOf(networkInfo)));
                            C4990ab.m7417i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", Boolean.valueOf(networkInfo.isAvailable()), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()));
                        }
                        if (connectivityManager.getNetworkInfo(0) != null) {
                            C4990ab.m7417i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", connectivityManager.getNetworkInfo(0));
                            C4990ab.m7417i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", Boolean.valueOf(r0.isAvailable()), Boolean.valueOf(r0.isConnected()), Boolean.valueOf(r0.isConnectedOrConnecting()));
                        }
                        if (6 == i || 4 == i || i == 0 || -1 == i || -9 == i) {
                            if (networkInfo.isConnected()) {
                                C4990ab.m7417i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", Boolean.valueOf(C45958a.mvN.mo73816S(C34189m.m56059Mx("MicroMsg.FreeWifi.SubCoreFreeWifi"), C34189m.m56060My("MicroMsg.FreeWifi.SubCoreFreeWifi"), C34189m.m56061Mz("MicroMsg.FreeWifi.SubCoreFreeWifi"))));
                                if (C45958a.mvN.mo73816S(C34189m.m56059Mx("MicroMsg.FreeWifi.SubCoreFreeWifi"), C34189m.m56060My("MicroMsg.FreeWifi.SubCoreFreeWifi"), C34189m.m56061Mz("MicroMsg.FreeWifi.SubCoreFreeWifi"))) {
                                    C11976j.bzb().byF();
                                }
                            } else {
                                C45958a.mvN.byP();
                                AppMethodBeat.m2505o(20744);
                                return;
                            }
                        }
                    }
                    C4990ab.m7412e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(20744);
                }
            }
        }
    }

    public C11976j() {
        AppMethodBeat.m2504i(20757);
        AppMethodBeat.m2505o(20757);
    }

    static {
        AppMethodBeat.m2504i(20769);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new C69151());
        eaA.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new C119805());
        eaA.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new C119816());
        AppMethodBeat.m2505o(20769);
    }

    public static C11976j byU() {
        AppMethodBeat.m2504i(20758);
        C9638aw.m17184ZE();
        C11976j c11976j = (C11976j) C45439bw.m83697oJ("plugin.freewifi");
        if (c11976j == null) {
            C4990ab.m7420w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
            c11976j = new C11976j();
            C9638aw.m17184ZE().mo73244a("plugin.freewifi", c11976j);
        }
        AppMethodBeat.m2505o(20758);
        return c11976j;
    }

    public static C45957d byV() {
        AppMethodBeat.m2504i(20759);
        C1720g.m3534RN().mo5159QU();
        if (C11976j.byU().mwd == null) {
            C11976j.byU().mwd = new C45957d();
        }
        C45957d c45957d = C11976j.byU().mwd;
        AppMethodBeat.m2505o(20759);
        return c45957d;
    }

    public static C7605d byW() {
        AppMethodBeat.m2504i(20760);
        C1720g.m3534RN().mo5159QU();
        if (C11976j.byU().mwe == null) {
            C11976j byU = C11976j.byU();
            C9638aw.m17190ZK();
            byU.mwe = new C7605d(C18628c.m29069Ru());
        }
        C7605d c7605d = C11976j.byU().mwe;
        AppMethodBeat.m2505o(20760);
        return c7605d;
    }

    public static C11961b byX() {
        AppMethodBeat.m2504i(20761);
        C1720g.m3534RN().mo5159QU();
        if (C11976j.byU().mwf == null) {
            C11976j byU = C11976j.byU();
            C9638aw.m17190ZK();
            byU.mwf = new C11961b(C18628c.m29069Ru());
        }
        C11961b c11961b = C11976j.byU().mwf;
        AppMethodBeat.m2505o(20761);
        return c11961b;
    }

    public static C39110f byY() {
        AppMethodBeat.m2504i(20762);
        C1720g.m3534RN().mo5159QU();
        if (C11976j.byU().mwg == null) {
            C11976j byU = C11976j.byU();
            C9638aw.m17190ZK();
            byU.mwg = new C39110f(C18628c.m29069Ru());
        }
        C39110f c39110f = C11976j.byU().mwg;
        AppMethodBeat.m2505o(20762);
        return c39110f;
    }

    public static C3145c byZ() {
        AppMethodBeat.m2504i(20763);
        C1720g.m3534RN().mo5159QU();
        if (C11976j.byU().mwh == null) {
            C11976j.byU().mwh = new C3145c();
        }
        C3145c c3145c = C11976j.byU().mwh;
        AppMethodBeat.m2505o(20763);
        return c3145c;
    }

    public static C3145c bza() {
        AppMethodBeat.m2504i(20764);
        C1720g.m3534RN().mo5159QU();
        if (C11976j.byU().mwi == null) {
            C11976j.byU().mwi = new C3145c();
        }
        C3145c c3145c = C11976j.byU().mwi;
        AppMethodBeat.m2505o(20764);
        return c3145c;
    }

    public static synchronized C3139a bzb() {
        C3139a c3139a;
        synchronized (C11976j.class) {
            AppMethodBeat.m2504i(20765);
            C1720g.m3534RN().mo5159QU();
            if (C11976j.byU().mwj == null) {
                C11976j.byU().mwj = new C3139a();
            }
            c3139a = C11976j.byU().mwj;
            AppMethodBeat.m2505o(20765);
        }
        return c3139a;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(20766);
        C9638aw.getSysCmdMsgExtension().mo14900a("freewifi", this.luy, true);
        C9638aw.m17198a(this.mwl);
        C4879a.xxA.mo10052c(this.mwm);
        C4879a.xxA.mo10052c(this.mwn);
        C4879a.xxA.mo10052c(this.mwo);
        C4879a.xxA.mo10052c(this.mwp);
        C4879a.xxA.mo10052c(this.mwq);
        C4879a.xxA.mo10052c(this.mwr);
        C4879a.xxA.mo10052c(this.gRa);
        try {
            this.mwl.mo5192gl(-9);
        } catch (RemoteException e) {
            C4990ab.m7412e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + e.getMessage());
        }
        C3141b byH = C3144b.mvG;
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) C4996ah.getContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", networkInfo.toString());
            IntentFilter intentFilter;
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", networkInfo2.toString());
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    C3143a c3143a = new C3143a();
                    c3143a.mvE = System.currentTimeMillis();
                    c3143a.type = 0;
                    c3143a.ssid = "";
                    c3143a.bssid = "";
                    c3143a.mvF = C34189m.m56058Mw(networkInfo2.getExtraInfo());
                    C3141b.m5378a(byH.mvB.byG(), c3143a);
                    byH.mvB = c3143a;
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                byH.byc();
                C4996ah.getContext().registerReceiver(byH.mvC, intentFilter);
                AppMethodBeat.m2505o(20766);
            }
            String Mv = C34189m.m56057Mv(C34189m.m56059Mx("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
            String toLowerCase = C34189m.m56060My("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
            C3143a c3143a2 = new C3143a();
            c3143a2.mvE = System.currentTimeMillis();
            c3143a2.type = 1;
            c3143a2.ssid = Mv;
            c3143a2.bssid = toLowerCase;
            c3143a2.mvF = "";
            C3141b.m5379b(byH.mvB.byG(), c3143a2);
            byH.mvB = c3143a2;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            byH.byc();
            C4996ah.getContext().registerReceiver(byH.mvC, intentFilter);
            AppMethodBeat.m2505o(20766);
        } catch (Exception e2) {
            C11967a byo = C11966k.byo();
            byo.cuH = "UnExpectedException";
            byo.result = -1;
            byo.ehr = C34189m.m56077g(e2);
            byo.byq().byp();
            C4990ab.m7412e("MicroMsg.FreeWifi.UnExcepctedException", C34189m.m56078h(e2));
        }
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(20767);
        C9638aw.getSysCmdMsgExtension().mo14903b("freewifi", this.luy, true);
        C11976j.byV();
        C11976j.byZ().release();
        C9638aw.m17200b(this.mwl);
        C4879a.xxA.mo10053d(this.mwm);
        C4879a.xxA.mo10053d(this.mwn);
        C4879a.xxA.mo10053d(this.mwo);
        C4879a.xxA.mo10053d(this.mwp);
        C4879a.xxA.mo10053d(this.mwq);
        C4879a.xxA.mo10053d(this.mwr);
        C4879a.xxA.mo10053d(this.gRa);
        C3144b.mvG.byc();
        AppMethodBeat.m2505o(20767);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    public static C43113e bzc() {
        AppMethodBeat.m2504i(20768);
        C1720g.m3534RN().mo5159QU();
        if (C11976j.byU().mwk == null) {
            C11976j.byU().mwk = new C43113e();
        }
        C43113e c43113e = C11976j.byU().mwk;
        AppMethodBeat.m2505o(20768);
        return c43113e;
    }
}
