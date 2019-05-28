package com.tencent.p177mm.plugin.misc.p764b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.model.C6667bj;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.misc.p994a.C12534a;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
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

/* renamed from: com.tencent.mm.plugin.misc.b.b */
public final class C39374b implements C1202f, C9562c, C12534a {
    private static C7564ap che = null;
    private static String oro = "";
    private static String orp = "";
    private int fmQ = 0;
    private int fmR = 0;
    private C1923n fyJ = new C75092();
    private boolean orl = false;
    private long orm = 0;
    private long orn = 60;
    private final Map<Integer, Set<Object>> orq = new HashMap();
    private int type = 0;

    /* renamed from: com.tencent.mm.plugin.misc.b.b$2 */
    class C75092 extends C1924a {
        C75092() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            int i2 = 1;
            AppMethodBeat.m2504i(50513);
            try {
                if (C39374b.bOP()) {
                    String LX = C1427q.m3039LX();
                    C4990ab.m7417i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", LX);
                    if (LX.equals(C39374b.oro)) {
                        LX = C39374b.bOQ();
                        if (LX.equals(C39374b.orp)) {
                            i2 = 0;
                        } else {
                            C4990ab.m7417i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", C39374b.orp, LX);
                            C39374b.orp = LX;
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", C39374b.oro, LX);
                        C39374b.oro = LX;
                    }
                    if (i2 != 0) {
                        C39374b.this.orl = false;
                        C39374b.this.orm = 0;
                        C39374b.this.mo62265yy(2);
                        AppMethodBeat.m2505o(50513);
                        return;
                    }
                    C39374b.m67151a(C39374b.this, C39374b.this.fmQ);
                    AppMethodBeat.m2505o(50513);
                    return;
                }
                C39374b.m67151a(C39374b.this, 0);
                AppMethodBeat.m2505o(50513);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SimcardService", e, "", new Object[0]);
                AppMethodBeat.m2505o(50513);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.misc.b.b$1 */
    class C393731 implements C5015a {
        C393731() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(50512);
            if (C1720g.m3534RN().mo5161QY()) {
                C4990ab.m7416i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
                if (C39374b.this.orm == 0) {
                    C39374b.this.mo62265yy(0);
                } else {
                    C39374b.this.mo62265yy(3);
                }
                AppMethodBeat.m2505o(50512);
            } else {
                C4990ab.m7420w("MicroMsg.SimcardService", "account not init.");
                AppMethodBeat.m2505o(50512);
            }
            return true;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m67151a(C39374b c39374b, int i) {
        AppMethodBeat.m2504i(50525);
        c39374b.m67155yz(i);
        AppMethodBeat.m2505o(50525);
    }

    static /* synthetic */ boolean bOP() {
        AppMethodBeat.m2504i(50524);
        boolean bON = C39374b.bON();
        AppMethodBeat.m2505o(50524);
        return bON;
    }

    static /* synthetic */ String bOQ() {
        AppMethodBeat.m2504i(50526);
        String bOO = C39374b.bOO();
        AppMethodBeat.m2505o(50526);
        return bOO;
    }

    public C39374b() {
        AppMethodBeat.m2504i(50514);
        AppMethodBeat.m2505o(50514);
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(50515);
        if (che == null) {
            C7564ap c7564ap = new C7564ap(new C393731(), true);
            che = c7564ap;
            c7564ap.mo16770ae(30000, 30000);
        }
        C1720g.m3540Rg().mo14539a(813, (C1202f) this);
        C1720g.m3535RO().mo5187a(this.fyJ);
        AppMethodBeat.m2505o(50515);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(50516);
        C1720g.m3540Rg().mo14546b(813, (C1202f) this);
        AppMethodBeat.m2505o(50516);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(50517);
        che.stopTimer();
        che.mo16770ae(86400000, 86400000);
        if (i == 0 && i2 == 0) {
            C6667bj c6667bj = (C6667bj) c1207m;
            this.orl = true;
            this.fmR = c6667bj.fmR;
            this.type = c6667bj.type;
            this.fmQ = c6667bj.fmQ;
            if (((long) c6667bj.fmS) < 60 || ((long) c6667bj.fmS) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                this.orn = 28800;
            } else {
                this.orn = (long) c6667bj.fmS;
            }
            C4990ab.m7417i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", Integer.valueOf(this.type), Integer.valueOf(this.fmR), Integer.valueOf(this.fmQ), Integer.valueOf(c6667bj.fmS));
            m67155yz(this.fmQ);
            AppMethodBeat.m2505o(50517);
            return;
        }
        this.orn = 60;
        C4990ab.m7412e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + i + "," + i2 + ")");
        m67155yz(this.fmQ);
        AppMethodBeat.m2505o(50517);
    }

    public final int bOK() {
        AppMethodBeat.m2504i(50518);
        if (C39374b.bON()) {
            mo62265yy(1);
            if (2 == this.type) {
                AppMethodBeat.m2505o(50518);
                return 0;
            } else if (!this.orl) {
                AppMethodBeat.m2505o(50518);
                return 0;
            } else if ((this.fmQ & 2) == 0) {
                AppMethodBeat.m2505o(50518);
                return 2;
            } else {
                AppMethodBeat.m2505o(50518);
                return 1;
            }
        }
        AppMethodBeat.m2505o(50518);
        return 2;
    }

    public final int bOL() {
        AppMethodBeat.m2504i(50519);
        if (C39374b.bON()) {
            int i = this.fmR;
            AppMethodBeat.m2505o(50519);
            return i;
        }
        AppMethodBeat.m2505o(50519);
        return 0;
    }

    /* renamed from: yy */
    public final void mo62265yy(int i) {
        AppMethodBeat.m2504i(50520);
        if (C39374b.bON()) {
            if (this.orm != 0) {
                long anT = C5046bo.anT();
                C4990ab.m7417i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", Integer.valueOf(i), Long.valueOf(this.orn), Long.valueOf(this.orm), Long.valueOf(anT));
                if (i != 2) {
                    long j = (long) ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
                    if (j > this.orn) {
                        j = this.orn;
                    }
                    if (anT - this.orm < j) {
                        AppMethodBeat.m2505o(50520);
                        return;
                    }
                } else if (anT - this.orm < 60) {
                    AppMethodBeat.m2505o(50520);
                    return;
                }
            }
            this.orm = C5046bo.anT();
            oro = C1427q.m3039LX();
            orp = C39374b.bOO();
            C4990ab.m7416i("MicroMsg.SimcardService", "CheckMobileSIMType start");
            C1720g.m3540Rg().mo14541a(new C6667bj(i, orp, C1427q.m3026LK(), oro), 0);
            AppMethodBeat.m2505o(50520);
            return;
        }
        AppMethodBeat.m2505o(50520);
    }

    /* renamed from: yz */
    private void m67155yz(int i) {
        AppMethodBeat.m2504i(50521);
        C4990ab.m7417i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", Integer.valueOf(i));
        if (this.orq == null) {
            AppMethodBeat.m2505o(50521);
            return;
        }
        for (Entry entry : this.orq.entrySet()) {
            ((Integer) entry.getKey()).intValue();
            Iterator it = ((Set) entry.getValue()).iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.m2505o(50521);
    }

    private static boolean bON() {
        AppMethodBeat.m2504i(50522);
        if (C5023at.isMobile(C4996ah.getContext())) {
            int iSPCode = C5023at.getISPCode(C4996ah.getContext());
            C4990ab.m7417i("MicroMsg.SimcardService", "isUnicomNetwork ispcode[%d]", Integer.valueOf(iSPCode));
            if (iSPCode == 46001 || iSPCode == 46006 || iSPCode == 46009) {
                AppMethodBeat.m2505o(50522);
                return true;
            }
            AppMethodBeat.m2505o(50522);
            return false;
        }
        AppMethodBeat.m2505o(50522);
        return false;
    }

    private static String bOO() {
        String str;
        AppMethodBeat.m2504i(50523);
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (networkInterface != null) {
                    Enumeration inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (inetAddress != null && !inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            if (C5046bo.isNullOrNil(inetAddress.getHostAddress())) {
                                str = "127.0.0.1";
                                AppMethodBeat.m2505o(50523);
                                return str;
                            }
                            str = inetAddress.getHostAddress();
                            AppMethodBeat.m2505o(50523);
                            return str;
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e) {
        }
        str = "127.0.0.1";
        AppMethodBeat.m2505o(50523);
        return str;
    }
}
