package com.tencent.mm.plugin.freewifi.model;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.af;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.a;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class j implements at {
    private static HashMap<Integer, d> eaA;
    private c gRa = new c<ae>() {
        {
            AppMethodBeat.i(20740);
            this.xxI = ae.class.getName().hashCode();
            AppMethodBeat.o(20740);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(20741);
            af afVar = new af();
            afVar.csZ.ctb = new a(ah.getContext());
            com.tencent.mm.sdk.b.a.xxA.m(afVar);
            AppMethodBeat.o(20741);
            return false;
        }
    };
    private bz.a luy = new bz.a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(20742);
            e bzc = j.bzc();
            cm cmVar = aVar.eAB;
            if (1 != i.a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
                i.a.mtZ.ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
            }
            if (cmVar == null || cmVar.vED == null) {
                ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                AppMethodBeat.o(20742);
                return;
            }
            String a = aa.a(cmVar.vED);
            ab.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", Long.valueOf(cmVar.ptF), a);
            if (m.isEmpty(a)) {
                ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                AppMethodBeat.o(20742);
                return;
            }
            com.tencent.mm.plugin.freewifi.c.a MB = com.tencent.mm.plugin.freewifi.c.a.MB(a);
            if (MB == null) {
                ab.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                AppMethodBeat.o(20742);
                return;
            }
            new com.tencent.mm.plugin.freewifi.d.d(m.Mx("MicroMsg.FreeWifi.FreeWifiMessageService"), m.My("MicroMsg.FreeWifi.FreeWifiMessageService"), m.Mz("MicroMsg.FreeWifi.FreeWifiMessageService"), MB.mvw, MB.mvt, MB.mvx, MB.ssid, MB.bssid).c(new com.tencent.mm.plugin.freewifi.model.e.AnonymousClass1(cmVar));
            AppMethodBeat.o(20742);
        }
    };
    private volatile d mwd;
    private volatile com.tencent.mm.plugin.freewifi.g.d mwe;
    private volatile com.tencent.mm.plugin.freewifi.g.b mwf;
    private volatile f mwg;
    private volatile c mwh;
    private volatile c mwi;
    private volatile a mwj;
    private volatile e mwk;
    private n mwl = new n.a() {
        private byte[] ecf = new byte[0];

        {
            AppMethodBeat.i(20743);
            AppMethodBeat.o(20743);
        }

        /* JADX WARNING: Missing block: B:39:0x0131, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(20744);
     */
        /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void gl(int i) {
            AppMethodBeat.i(20744);
            synchronized (this.ecf) {
                try {
                    if (aw.RK()) {
                        ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + i + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
                        ConnectivityManager connectivityManager = (ConnectivityManager) ah.getContext().getSystemService("connectivity");
                        if (connectivityManager == null) {
                            AppMethodBeat.o(20744);
                            return;
                        }
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                        if (networkInfo != null) {
                            ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:".concat(String.valueOf(networkInfo)));
                            ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", Boolean.valueOf(networkInfo.isAvailable()), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()));
                        }
                        if (connectivityManager.getNetworkInfo(0) != null) {
                            ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", connectivityManager.getNetworkInfo(0));
                            ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", Boolean.valueOf(r0.isAvailable()), Boolean.valueOf(r0.isConnected()), Boolean.valueOf(r0.isConnectedOrConnecting()));
                        }
                        if (6 == i || 4 == i || i == 0 || -1 == i || -9 == i) {
                            if (networkInfo.isConnected()) {
                                ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", Boolean.valueOf(f.a.mvN.S(m.Mx("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.My("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.Mz("MicroMsg.FreeWifi.SubCoreFreeWifi"))));
                                if (f.a.mvN.S(m.Mx("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.My("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.Mz("MicroMsg.FreeWifi.SubCoreFreeWifi"))) {
                                    j.bzb().byF();
                                }
                            } else {
                                f.a.mvN.byP();
                                AppMethodBeat.o(20744);
                                return;
                            }
                        }
                    }
                    ab.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(20744);
                }
            }
        }
    };
    private c mwm = new c<bk>() {
        {
            AppMethodBeat.i(20745);
            this.xxI = bk.class.getName().hashCode();
            AppMethodBeat.o(20745);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(20746);
            bk bkVar = (bk) bVar;
            ab.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "receive CheckWechatFreeWifiEvent");
            if (d.getNetworkType() != 0) {
                ab.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "not wifi");
            } else {
                j.byV();
                bkVar.cuE.cuG = h.b.mtY.byk();
                bkVar.cuE.cuF = h.b.mtY.byj();
                String byO = d.byO();
                String byK = d.byK();
                if (!(bo.isNullOrNil(byO) || bo.isNullOrNil(byK))) {
                    com.tencent.mm.plugin.freewifi.g.c ML = j.byW().ML(byO);
                    if (ML != null) {
                        bkVar.cuE.cuH = ML.field_url;
                    }
                    bkVar.cuE.ssid = byO;
                    bkVar.cuE.bssid = m.My("MicroMsg.FreeWifi.FreeWifiManager");
                    bkVar.cuE.cuI = m.Mz("MicroMsg.FreeWifi.FreeWifiManager");
                    if (ML != null && byO.equalsIgnoreCase(ML.field_ssid) && byK.equalsIgnoreCase(ML.field_mac)) {
                        bk.a aVar = bkVar.cuE;
                        if (ML == null) {
                            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "filterLang, freewifi info is null");
                            byO = null;
                        } else {
                            byO = com.tencent.mm.sdk.platformtools.aa.dor();
                            if (byO.equals("zh_CN")) {
                                byO = ML.field_showWordCn;
                            } else if (byO.equals("zh_TW") || byO.equals("zh_HK")) {
                                byO = ML.field_showWordTw;
                            } else {
                                byO = ML.field_showWordEn;
                            }
                        }
                        aVar.cuJ = byO;
                        if (!(m.isEmpty(bkVar.cuE.cuJ) || i.a.mtZ.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1)) {
                            i.a.mtZ.ch("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 1);
                        }
                        if (ML.field_expiredTime - bo.anT() < 0) {
                            j.bzb().byF();
                        }
                    }
                }
            }
            AppMethodBeat.o(20746);
            return false;
        }
    };
    private c mwn = new c<pm>() {
        {
            AppMethodBeat.i(20748);
            this.xxI = pm.class.getName().hashCode();
            AppMethodBeat.o(20748);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(20749);
            pm pmVar = (pm) bVar;
            int networkType = d.getNetworkType();
            if (!(networkType == 0 || networkType == -1)) {
                ab.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "networkType is " + networkType + ", start to scan and report near field wifi, to get a pushed message for connecting wifi.");
                final String str = pmVar.cLH.userName;
                h.b.mwc.a(new h.a() {
                    public final void bU(List<ScanResult> list) {
                        AppMethodBeat.i(20747);
                        if (list == null || list.size() == 0) {
                            AppMethodBeat.o(20747);
                            return;
                        }
                        buc buc = new buc();
                        buc.wVV = new LinkedList();
                        for (ScanResult scanResult : list) {
                            if (scanResult != null) {
                                dh dhVar = new dh();
                                dhVar.mac = scanResult.BSSID;
                                dhVar.vFl = scanResult.level;
                                dhVar.ssid = scanResult.SSID;
                                buc.wVV.add(dhVar);
                            }
                        }
                        String bys = m.bys();
                        k.a byo = k.byo();
                        byo.kBq = bys;
                        byo.muf = k.b.ScanNearFieldWifiAndReport.muQ;
                        byo.mug = k.b.ScanNearFieldWifiAndReport.name;
                        byo.cIb = 8;
                        byo.byq().byp();
                        new com.tencent.mm.plugin.freewifi.d.k(str, buc, 8, bys).c(null);
                        AppMethodBeat.o(20747);
                    }
                });
            }
            AppMethodBeat.o(20749);
            return false;
        }
    };
    private c mwo = new c<go>() {
        {
            AppMethodBeat.i(20750);
            this.xxI = go.class.getName().hashCode();
            AppMethodBeat.o(20750);
        }

        private static boolean a(go goVar) {
            AppMethodBeat.i(20751);
            if (goVar.cBl.data == "MAIN_UI_EVENT_UPDATE_VIEW" && m.byr()) {
                String str = "InterruptedProtocol31-" + System.currentTimeMillis();
                f.b byQ = f.a.mvN.byQ();
                if (!(byQ == null || byQ.mvR || System.currentTimeMillis() - byQ.mvE > 180000 || m.isEmpty(byQ.mvP) || m.isEmpty(byQ.mvO) || m.isEmpty(byQ.mvQ))) {
                    ab.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", str, Integer.valueOf(1), byQ.mvO, byQ.mvP, byQ.mvQ, Long.valueOf(byQ.mvE));
                    ab.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. ", str, Integer.valueOf(2));
                    String Mx = m.Mx("MicroMsg.FreeWifi.Protocol31Handler");
                    if (m.Mv(byQ.mvO).equals(Mx)) {
                        String My = m.My("MicroMsg.FreeWifi.Protocol31Handler");
                        String Mz = m.Mz("MicroMsg.FreeWifi.Protocol31Handler");
                        synchronized (f.a.mvN) {
                            try {
                                if (byQ != f.a.mvN.byQ()) {
                                } else {
                                    ab.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", str, Integer.valueOf(3), Mx, My, Mz);
                                    new g(Mx, My, Mz).c(new com.tencent.mm.plugin.freewifi.e.c.AnonymousClass1(str, byQ));
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(20751);
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(20751);
            return false;
        }
    };
    private c mwp = new c<fh>() {
        {
            AppMethodBeat.i(20753);
            this.xxI = fh.class.getName().hashCode();
            AppMethodBeat.o(20753);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(20754);
            com.tencent.mm.plugin.freewifi.b.c.byA().a((fh) bVar);
            AppMethodBeat.o(20754);
            return false;
        }
    };
    private c mwq = new c<fe>() {
        {
            AppMethodBeat.i(20755);
            this.xxI = fe.class.getName().hashCode();
            AppMethodBeat.o(20755);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(20756);
            com.tencent.mm.plugin.freewifi.b.b.a.mvi.a((fe) bVar);
            AppMethodBeat.o(20756);
            return false;
        }
    };
    private c mwr = new c<gp>() {
        {
            AppMethodBeat.i(20738);
            this.xxI = gp.class.getName().hashCode();
            AppMethodBeat.o(20738);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(20739);
            gp gpVar = (gp) bVar;
            com.tencent.mm.plugin.freewifi.e.b.bzr();
            com.tencent.mm.plugin.freewifi.e.b.aa(gpVar.cBm.intent);
            AppMethodBeat.o(20739);
            return false;
        }
    };

    public j() {
        AppMethodBeat.i(20757);
        AppMethodBeat.o(20757);
    }

    static {
        AppMethodBeat.i(20769);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.freewifi.g.d.fnj;
            }
        });
        eaA.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.freewifi.g.b.fnj;
            }
        });
        eaA.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return f.fnj;
            }
        });
        AppMethodBeat.o(20769);
    }

    public static j byU() {
        AppMethodBeat.i(20758);
        aw.ZE();
        j jVar = (j) bw.oJ("plugin.freewifi");
        if (jVar == null) {
            ab.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
            jVar = new j();
            aw.ZE().a("plugin.freewifi", jVar);
        }
        AppMethodBeat.o(20758);
        return jVar;
    }

    public static d byV() {
        AppMethodBeat.i(20759);
        com.tencent.mm.kernel.g.RN().QU();
        if (byU().mwd == null) {
            byU().mwd = new d();
        }
        d dVar = byU().mwd;
        AppMethodBeat.o(20759);
        return dVar;
    }

    public static com.tencent.mm.plugin.freewifi.g.d byW() {
        AppMethodBeat.i(20760);
        com.tencent.mm.kernel.g.RN().QU();
        if (byU().mwe == null) {
            j byU = byU();
            aw.ZK();
            byU.mwe = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.Ru());
        }
        com.tencent.mm.plugin.freewifi.g.d dVar = byU().mwe;
        AppMethodBeat.o(20760);
        return dVar;
    }

    public static com.tencent.mm.plugin.freewifi.g.b byX() {
        AppMethodBeat.i(20761);
        com.tencent.mm.kernel.g.RN().QU();
        if (byU().mwf == null) {
            j byU = byU();
            aw.ZK();
            byU.mwf = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.Ru());
        }
        com.tencent.mm.plugin.freewifi.g.b bVar = byU().mwf;
        AppMethodBeat.o(20761);
        return bVar;
    }

    public static f byY() {
        AppMethodBeat.i(20762);
        com.tencent.mm.kernel.g.RN().QU();
        if (byU().mwg == null) {
            j byU = byU();
            aw.ZK();
            byU.mwg = new f(com.tencent.mm.model.c.Ru());
        }
        f fVar = byU().mwg;
        AppMethodBeat.o(20762);
        return fVar;
    }

    public static c byZ() {
        AppMethodBeat.i(20763);
        com.tencent.mm.kernel.g.RN().QU();
        if (byU().mwh == null) {
            byU().mwh = new c();
        }
        c cVar = byU().mwh;
        AppMethodBeat.o(20763);
        return cVar;
    }

    public static c bza() {
        AppMethodBeat.i(20764);
        com.tencent.mm.kernel.g.RN().QU();
        if (byU().mwi == null) {
            byU().mwi = new c();
        }
        c cVar = byU().mwi;
        AppMethodBeat.o(20764);
        return cVar;
    }

    public static synchronized a bzb() {
        a aVar;
        synchronized (j.class) {
            AppMethodBeat.i(20765);
            com.tencent.mm.kernel.g.RN().QU();
            if (byU().mwj == null) {
                byU().mwj = new a();
            }
            aVar = byU().mwj;
            AppMethodBeat.o(20765);
        }
        return aVar;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(20766);
        aw.getSysCmdMsgExtension().a("freewifi", this.luy, true);
        aw.a(this.mwl);
        com.tencent.mm.sdk.b.a.xxA.c(this.mwm);
        com.tencent.mm.sdk.b.a.xxA.c(this.mwn);
        com.tencent.mm.sdk.b.a.xxA.c(this.mwo);
        com.tencent.mm.sdk.b.a.xxA.c(this.mwp);
        com.tencent.mm.sdk.b.a.xxA.c(this.mwq);
        com.tencent.mm.sdk.b.a.xxA.c(this.mwr);
        com.tencent.mm.sdk.b.a.xxA.c(this.gRa);
        try {
            this.mwl.gl(-9);
        } catch (RemoteException e) {
            ab.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + e.getMessage());
        }
        b byH = b.mvG;
        ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ah.getContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", networkInfo.toString());
            IntentFilter intentFilter;
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", networkInfo2.toString());
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    a aVar = new a();
                    aVar.mvE = System.currentTimeMillis();
                    aVar.type = 0;
                    aVar.ssid = "";
                    aVar.bssid = "";
                    aVar.mvF = m.Mw(networkInfo2.getExtraInfo());
                    b.a(byH.mvB.byG(), aVar);
                    byH.mvB = aVar;
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                byH.byc();
                ah.getContext().registerReceiver(byH.mvC, intentFilter);
                AppMethodBeat.o(20766);
            }
            String Mv = m.Mv(m.Mx("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
            String toLowerCase = m.My("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
            a aVar2 = new a();
            aVar2.mvE = System.currentTimeMillis();
            aVar2.type = 1;
            aVar2.ssid = Mv;
            aVar2.bssid = toLowerCase;
            aVar2.mvF = "";
            b.b(byH.mvB.byG(), aVar2);
            byH.mvB = aVar2;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            byH.byc();
            ah.getContext().registerReceiver(byH.mvC, intentFilter);
            AppMethodBeat.o(20766);
        } catch (Exception e2) {
            k.a byo = k.byo();
            byo.cuH = "UnExpectedException";
            byo.result = -1;
            byo.ehr = m.g(e2);
            byo.byq().byp();
            ab.e("MicroMsg.FreeWifi.UnExcepctedException", m.h(e2));
        }
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(20767);
        aw.getSysCmdMsgExtension().b("freewifi", this.luy, true);
        byV();
        byZ().release();
        aw.b(this.mwl);
        com.tencent.mm.sdk.b.a.xxA.d(this.mwm);
        com.tencent.mm.sdk.b.a.xxA.d(this.mwn);
        com.tencent.mm.sdk.b.a.xxA.d(this.mwo);
        com.tencent.mm.sdk.b.a.xxA.d(this.mwp);
        com.tencent.mm.sdk.b.a.xxA.d(this.mwq);
        com.tencent.mm.sdk.b.a.xxA.d(this.mwr);
        com.tencent.mm.sdk.b.a.xxA.d(this.gRa);
        b.mvG.byc();
        AppMethodBeat.o(20767);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public static e bzc() {
        AppMethodBeat.i(20768);
        com.tencent.mm.kernel.g.RN().QU();
        if (byU().mwk == null) {
            byU().mwk = new e();
        }
        e eVar = byU().mwk;
        AppMethodBeat.o(20768);
        return eVar;
    }
}
