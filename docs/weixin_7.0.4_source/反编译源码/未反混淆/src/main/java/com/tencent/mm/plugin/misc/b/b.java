package com.tencent.mm.plugin.misc.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b implements f, c, a {
    private static ap che = null;
    private static String oro = "";
    private static String orp = "";
    private int fmQ = 0;
    private int fmR = 0;
    private n fyJ = new n.a() {
        public final void gl(int i) {
            int i2 = 1;
            AppMethodBeat.i(50513);
            try {
                if (b.bOP()) {
                    String LX = q.LX();
                    ab.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", LX);
                    if (LX.equals(b.oro)) {
                        LX = b.bOQ();
                        if (LX.equals(b.orp)) {
                            i2 = 0;
                        } else {
                            ab.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", b.orp, LX);
                            b.orp = LX;
                        }
                    } else {
                        ab.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", b.oro, LX);
                        b.oro = LX;
                    }
                    if (i2 != 0) {
                        b.this.orl = false;
                        b.this.orm = 0;
                        b.this.yy(2);
                        AppMethodBeat.o(50513);
                        return;
                    }
                    b.a(b.this, b.this.fmQ);
                    AppMethodBeat.o(50513);
                    return;
                }
                b.a(b.this, 0);
                AppMethodBeat.o(50513);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SimcardService", e, "", new Object[0]);
                AppMethodBeat.o(50513);
            }
        }
    };
    private boolean orl = false;
    private long orm = 0;
    private long orn = 60;
    private final Map<Integer, Set<Object>> orq = new HashMap();
    private int type = 0;

    static /* synthetic */ void a(b bVar, int i) {
        AppMethodBeat.i(50525);
        bVar.yz(i);
        AppMethodBeat.o(50525);
    }

    static /* synthetic */ boolean bOP() {
        AppMethodBeat.i(50524);
        boolean bON = bON();
        AppMethodBeat.o(50524);
        return bON;
    }

    static /* synthetic */ String bOQ() {
        AppMethodBeat.i(50526);
        String bOO = bOO();
        AppMethodBeat.o(50526);
        return bOO;
    }

    public b() {
        AppMethodBeat.i(50514);
        AppMethodBeat.o(50514);
    }

    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(50515);
        if (che == null) {
            ap apVar = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(50512);
                    if (g.RN().QY()) {
                        ab.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
                        if (b.this.orm == 0) {
                            b.this.yy(0);
                        } else {
                            b.this.yy(3);
                        }
                        AppMethodBeat.o(50512);
                    } else {
                        ab.w("MicroMsg.SimcardService", "account not init.");
                        AppMethodBeat.o(50512);
                    }
                    return true;
                }
            }, true);
            che = apVar;
            apVar.ae(30000, 30000);
        }
        g.Rg().a(813, (f) this);
        g.RO().a(this.fyJ);
        AppMethodBeat.o(50515);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(50516);
        g.Rg().b(813, (f) this);
        AppMethodBeat.o(50516);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(50517);
        che.stopTimer();
        che.ae(86400000, 86400000);
        if (i == 0 && i2 == 0) {
            bj bjVar = (bj) mVar;
            this.orl = true;
            this.fmR = bjVar.fmR;
            this.type = bjVar.type;
            this.fmQ = bjVar.fmQ;
            if (((long) bjVar.fmS) < 60 || ((long) bjVar.fmS) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                this.orn = 28800;
            } else {
                this.orn = (long) bjVar.fmS;
            }
            ab.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", Integer.valueOf(this.type), Integer.valueOf(this.fmR), Integer.valueOf(this.fmQ), Integer.valueOf(bjVar.fmS));
            yz(this.fmQ);
            AppMethodBeat.o(50517);
            return;
        }
        this.orn = 60;
        ab.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + i + "," + i2 + ")");
        yz(this.fmQ);
        AppMethodBeat.o(50517);
    }

    public final int bOK() {
        AppMethodBeat.i(50518);
        if (bON()) {
            yy(1);
            if (2 == this.type) {
                AppMethodBeat.o(50518);
                return 0;
            } else if (!this.orl) {
                AppMethodBeat.o(50518);
                return 0;
            } else if ((this.fmQ & 2) == 0) {
                AppMethodBeat.o(50518);
                return 2;
            } else {
                AppMethodBeat.o(50518);
                return 1;
            }
        }
        AppMethodBeat.o(50518);
        return 2;
    }

    public final int bOL() {
        AppMethodBeat.i(50519);
        if (bON()) {
            int i = this.fmR;
            AppMethodBeat.o(50519);
            return i;
        }
        AppMethodBeat.o(50519);
        return 0;
    }

    public final void yy(int i) {
        AppMethodBeat.i(50520);
        if (bON()) {
            if (this.orm != 0) {
                long anT = bo.anT();
                ab.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", Integer.valueOf(i), Long.valueOf(this.orn), Long.valueOf(this.orm), Long.valueOf(anT));
                if (i != 2) {
                    long j = (long) ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
                    if (j > this.orn) {
                        j = this.orn;
                    }
                    if (anT - this.orm < j) {
                        AppMethodBeat.o(50520);
                        return;
                    }
                } else if (anT - this.orm < 60) {
                    AppMethodBeat.o(50520);
                    return;
                }
            }
            this.orm = bo.anT();
            oro = q.LX();
            orp = bOO();
            ab.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
            g.Rg().a(new bj(i, orp, q.LK(), oro), 0);
            AppMethodBeat.o(50520);
            return;
        }
        AppMethodBeat.o(50520);
    }

    private void yz(int i) {
        AppMethodBeat.i(50521);
        ab.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", Integer.valueOf(i));
        if (this.orq == null) {
            AppMethodBeat.o(50521);
            return;
        }
        for (Entry entry : this.orq.entrySet()) {
            ((Integer) entry.getKey()).intValue();
            Iterator it = ((Set) entry.getValue()).iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.o(50521);
    }

    private static boolean bON() {
        AppMethodBeat.i(50522);
        if (at.isMobile(ah.getContext())) {
            int iSPCode = at.getISPCode(ah.getContext());
            ab.i("MicroMsg.SimcardService", "isUnicomNetwork ispcode[%d]", Integer.valueOf(iSPCode));
            if (iSPCode == 46001 || iSPCode == 46006 || iSPCode == 46009) {
                AppMethodBeat.o(50522);
                return true;
            }
            AppMethodBeat.o(50522);
            return false;
        }
        AppMethodBeat.o(50522);
        return false;
    }

    private static String bOO() {
        String str;
        AppMethodBeat.i(50523);
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface != null) {
                    Enumeration inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (inetAddress != null && !inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            if (bo.isNullOrNil(inetAddress.getHostAddress())) {
                                str = "127.0.0.1";
                                AppMethodBeat.o(50523);
                                return str;
                            }
                            str = inetAddress.getHostAddress();
                            AppMethodBeat.o(50523);
                            return str;
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e) {
        }
        str = "127.0.0.1";
        AppMethodBeat.o(50523);
        return str;
    }
}
