package com.tencent.p177mm.plugin.backup.backuppcmodel;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19936a;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19938c;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19939d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p344c.C33682a;
import com.tencent.p177mm.plugin.backup.p344c.C33682a.C26463;
import com.tencent.p177mm.plugin.backup.p344c.C33689d;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19977d;
import com.tencent.p177mm.plugin.backup.p921i.C11152ag;
import com.tencent.p177mm.plugin.backup.p921i.C11153d;
import com.tencent.p177mm.plugin.backup.p921i.C11154f;
import com.tencent.p177mm.plugin.backup.p921i.C19991n;
import com.tencent.p177mm.plugin.backup.p921i.C19992o;
import com.tencent.p177mm.plugin.backup.p921i.C27492af;
import com.tencent.p177mm.plugin.backup.p921i.C33709c;
import com.tencent.p177mm.plugin.backup.p921i.C38661b;
import com.tencent.p177mm.plugin.backup.p921i.C38662i;
import com.tencent.p177mm.plugin.backup.p921i.C38665y;
import com.tencent.p177mm.plugin.backup.p921i.C45752j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.d */
public final class C41256d implements C19939d {
    private static boolean jtr = false;
    private static boolean jwl = false;
    private boolean eVT = false;
    private long jrb = 0;
    private boolean jsA = false;
    private C33689d jti;
    LinkedList<String> jtj;
    LinkedList<Long> jtk;
    private HashSet<String> jto = new HashSet();
    private long jtp = 0;
    private long jtq = 0;
    public Set<C19938c> jwm = new HashSet();
    public C19936a jwn;
    private long jwo = 0;
    private boolean jwp = false;
    private final C19977d jwq = new C26111();
    private Object lock = new Object();
    private long recvSize = 0;

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.d$1 */
    class C26111 implements C19977d {
        C26111() {
        }

        /* renamed from: a */
        public final void mo6669a(boolean z, final int i, final byte[] bArr, final int i2) {
            AppMethodBeat.m2504i(17521);
            String str = "MicroMsg.BackupPcRecoverServer";
            String str2 = "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            C4990ab.m7417i(str, str2, objArr);
            if (z && CdnLogic.kMediaTypeBeatificFile == i) {
                C41256d.m71822a(C41256d.this);
                AppMethodBeat.m2505o(17521);
            } else if (i == 5) {
                C4990ab.m7416i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
                C41256d.this.mo65912c(true, false, -100);
                C7060h.pYm.mo8378a(400, 52, 1, false);
                C41256d.this.mo65914rt(5);
                AppMethodBeat.m2505o(17521);
            } else {
                int i3 = C42759b.aTD().aTE().jwa;
                if (2 != i3 && 4 != i3) {
                    C4990ab.m7413e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", Integer.valueOf(C42759b.aTD().aTE().jwa));
                    AppMethodBeat.m2505o(17521);
                } else if (i == 10) {
                    C11154f c11154f = (C11154f) C38635g.m65510a(new C11154f(), bArr);
                    str2 = "MicroMsg.BackupPcRecoverServer";
                    String str3 = "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]";
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Long.valueOf(c11154f != null ? c11154f.jxD : -1);
                    C4990ab.m7417i(str2, str3, objArr2);
                    AppMethodBeat.m2505o(17521);
                } else if (i == 18) {
                    C33709c c33709c = new C33709c();
                    try {
                        c33709c.parseFrom(bArr);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
                    }
                    C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", Integer.valueOf(c33709c.jBh));
                    if (c33709c.jBh == 9) {
                        if (C19978b.aUb() == 1) {
                            C19978b.m30892ry(2);
                            C4990ab.m7416i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                            C41256d.this.mo65914rt(20);
                            C19978b.aUa();
                            C42759b.aTD().aSu().jqW = 23;
                            C41256d.this.mo6681rj(23);
                            C19978b.m30892ry(0);
                            AppMethodBeat.m2505o(17521);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(C19978b.aUb()));
                    }
                    AppMethodBeat.m2505o(17521);
                } else if (i == 17) {
                    C38661b c38661b = new C38661b();
                    try {
                        c38661b.parseFrom(bArr);
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
                    }
                    C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", Integer.valueOf(c38661b.jBh));
                    if (c38661b.jBh == 10) {
                        i3 = C42759b.aTD().aSu().jqW;
                        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i3));
                        if (i3 == 22 || i3 == 23) {
                            C41256d.this.mo65912c(true, false, -4);
                            C42759b.aTD().aTa().stop();
                            C7060h.pYm.mo8378a(400, 52, 1, false);
                            C41256d.this.mo65914rt(5);
                            long j = 0;
                            if (C41256d.this.jtp != 0) {
                                j = C5046bo.m7566gb(C41256d.this.jtp);
                            }
                            C7060h.pYm.mo8381e(13737, Integer.valueOf(3), Long.valueOf(C41256d.this.jrb), Long.valueOf(j), Integer.valueOf(2));
                            C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(C41256d.this.jrb), Long.valueOf(j));
                        }
                    }
                    AppMethodBeat.m2505o(17521);
                } else {
                    C9638aw.m17180RS().mo10302aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(17520);
                            if (i == 3) {
                                C41256d.m71824a(C41256d.this, bArr, i2);
                                AppMethodBeat.m2505o(17520);
                            } else if (i == 11) {
                                C41256d.m71827b(C41256d.this, bArr, i2);
                                AppMethodBeat.m2505o(17520);
                            } else if (i == 6) {
                                C41256d.m71829c(C41256d.this, bArr, i2);
                                AppMethodBeat.m2505o(17520);
                            } else if (i == 13) {
                                C41256d.m71821J(bArr, i2);
                                AppMethodBeat.m2505o(17520);
                            } else if (i == 15) {
                                C41256d.m71832d(C41256d.this, bArr, i2);
                                AppMethodBeat.m2505o(17520);
                            } else if (i == 8) {
                                C41256d.m71823a(C41256d.this, bArr);
                                AppMethodBeat.m2505o(17520);
                            } else {
                                AppMethodBeat.m2505o(17520);
                            }
                        }
                    });
                    AppMethodBeat.m2505o(17521);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.d$2 */
    class C26132 implements Runnable {
        final /* synthetic */ Set jwt;

        C26132(Set set) {
            this.jwt = set;
        }

        public final void run() {
            AppMethodBeat.m2504i(17522);
            for (C19938c aSs : this.jwt) {
                aSs.aSs();
            }
            AppMethodBeat.m2505o(17522);
        }
    }

    public C41256d() {
        AppMethodBeat.m2504i(17525);
        AppMethodBeat.m2505o(17525);
    }

    public static void aTM() {
        jwl = true;
    }

    public final void init() {
        AppMethodBeat.m2504i(17526);
        C4990ab.m7416i("MicroMsg.BackupPcRecoverServer", "init");
        this.jwp = false;
        jwl = false;
        jtr = false;
        C19978b.m30883a(this.jwq);
        this.jrb = 0;
        this.recvSize = 0;
        this.eVT = false;
        this.jsA = false;
        this.jto.clear();
        AppMethodBeat.m2505o(17526);
    }

    public static boolean aTe() {
        AppMethodBeat.m2504i(17527);
        boolean drz = C9638aw.m17190ZK().mo33890Yr().drz();
        AppMethodBeat.m2505o(17527);
        return drz;
    }

    public final void aTf() {
        AppMethodBeat.m2504i(17528);
        C4990ab.m7416i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
        this.jto.clear();
        AppMethodBeat.m2505o(17528);
    }

    /* renamed from: c */
    public final void mo65912c(boolean z, boolean z2, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(17529);
        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", Boolean.valueOf(z), Boolean.valueOf(z2), C5007an.doQ());
        jwl = true;
        if (!z) {
            C42759b.aTD().aTE();
            C45736c.aTj();
        }
        synchronized (this.lock) {
            try {
                this.eVT = true;
                if (this.jti == null || !this.jti.jsp) {
                    i2 = 1;
                } else {
                    this.jti.mo54247l(z2, i);
                }
                this.jti = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(17529);
                }
            }
        }
        if (!(i2 == 0 || i == 0)) {
            C42759b.aTD().aSu().jqW = i;
            mo6681rj(i);
        }
        if (z2) {
            aTf();
        }
        C19978b.aTV();
        C19978b.aTX();
        C19978b.aUa();
        AppMethodBeat.m2505o(17529);
    }

    /* renamed from: rt */
    public final void mo65914rt(int i) {
        AppMethodBeat.m2504i(17530);
        long j = 0;
        if (this.jtp != 0) {
            j = C5046bo.m7566gb(this.jtp);
        }
        C7060h.pYm.mo8381e(13737, Integer.valueOf(i), Long.valueOf(this.jrb / 1024), Long.valueOf(j / 1000), Integer.valueOf(2), Integer.valueOf(C42759b.aTD().aTE().jwg));
        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(this.jrb / 1024), Long.valueOf(j / 1000));
        AppMethodBeat.m2505o(17530);
    }

    /* renamed from: a */
    private static void m71825a(String str, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(17531);
        C38665y c38665y = new C38665y();
        c38665y.jCx = str;
        c38665y.jCy = i;
        c38665y.jCA = i2;
        c38665y.jCB = i3;
        c38665y.jBT = i4;
        try {
            C19978b.m30889r(c38665y.toByteArray(), 7, i5);
            AppMethodBeat.m2505o(17531);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "sendResp", new Object[0]);
            AppMethodBeat.m2505o(17531);
        }
    }

    /* renamed from: d */
    private static void m71831d(int i, int i2, long j) {
        AppMethodBeat.m2504i(17532);
        C19992o c19992o = new C19992o();
        c19992o.f4367ID = C42759b.aTD().jqO;
        c19992o.jBT = i;
        c19992o.jBO = C38635g.m65528gw(j);
        try {
            C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", Integer.valueOf(i));
            C19978b.m30889r(c19992o.toByteArray(), 4, i2);
            AppMethodBeat.m2505o(17532);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "buf to BackupStartRequest err.", new Object[0]);
            AppMethodBeat.m2505o(17532);
        }
    }

    public final void aSL() {
        AppMethodBeat.m2504i(17533);
        synchronized (this.lock) {
            try {
                if (this.jti == null || !this.jti.jsp) {
                    int drA;
                    if (this.jti != null) {
                        this.jti.mo54247l(false, 0);
                    }
                    if (this.jto == null || this.jto.size() <= 0) {
                        drA = C9638aw.m17190ZK().mo33890Yr().drA();
                    } else {
                        drA = this.jto.size();
                    }
                    C42759b.aTD().aSu().mo68222O(26, 1, drA);
                    mo6681rj(26);
                    if (this.jtj == null) {
                        this.jtj = new LinkedList();
                    }
                    if (this.jtk == null) {
                        this.jtk = new LinkedList();
                    }
                    this.jtq = C5046bo.anU();
                    this.jti = new C33689d(C42759b.aTD(), 1, this, drA, this.jsA, this.jtj, this.jtk);
                    this.jti.aSL();
                    C7060h.pYm.mo8378a(400, 24, 1, false);
                    AppMethodBeat.m2505o(17533);
                    return;
                }
                C4990ab.m7412e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
            } finally {
                AppMethodBeat.m2505o(17533);
            }
        }
    }

    /* renamed from: rj */
    public final void mo6681rj(final int i) {
        AppMethodBeat.m2504i(17534);
        final HashSet hashSet = new HashSet();
        hashSet.addAll(this.jwm);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17523);
                for (C19938c rj : hashSet) {
                    rj.mo6681rj(i);
                }
                AppMethodBeat.m2505o(17523);
            }
        });
        if (this.jwn != null) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(17524);
                    if (C41256d.this.jwn != null) {
                        C41256d.this.jwn.mo35185ri(i);
                    }
                    AppMethodBeat.m2505o(17524);
                }
            });
        }
        AppMethodBeat.m2505o(17534);
    }

    public final void aSt() {
        AppMethodBeat.m2504i(17535);
        aTf();
        C7060h.pYm.mo8378a(400, 27, 1, false);
        C7060h.pYm.mo8378a(400, 28, C5046bo.m7566gb(this.jtq) / 1000, false);
        C19978b.m30891rx(12);
        C19978b.aTV();
        C19978b.aTX();
        AppMethodBeat.m2505o(17535);
    }

    /* renamed from: a */
    static /* synthetic */ void m71822a(C41256d c41256d) {
        AppMethodBeat.m2504i(17536);
        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify local disconnect, backupPcState[%d], isRecoverFinish[%b]", Integer.valueOf(C42759b.aTD().aSu().jqW), Boolean.valueOf(jwl));
        switch (C42759b.aTD().aSu().jqW) {
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
                C42759b.aTD().aTa().stop();
                AppMethodBeat.m2505o(17536);
                return;
            case -4:
                c41256d.mo65912c(true, false, 0);
                break;
            case 1:
            case 21:
                C42759b.aTD().aTa().stop();
                C42759b.aTD().aSu().jqW = -100;
                c41256d.mo6681rj(-100);
                AppMethodBeat.m2505o(17536);
                return;
            case 4:
            case 22:
            case 23:
                if (!C42759b.aTD().aTE().jwe || jwl) {
                    C4990ab.m7416i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify not support reconnect, disconnect");
                    c41256d.mo65912c(true, false, -4);
                    C42759b.aTD().aTa().stop();
                    C7060h.pYm.mo8378a(400, 17, 1, false);
                    c41256d.mo65914rt(3);
                    AppMethodBeat.m2505o(17536);
                    return;
                }
                switch (C19978b.aUb()) {
                    case 0:
                    case 2:
                        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify startBackupReconnectHandler, reconnectState[%d]", Integer.valueOf(C19978b.aUb()));
                        c41256d.mo65914rt(19);
                        c41256d.jwp = true;
                        C19978b.m30884a(C42759b.aTD().aTE().jwj);
                        AppMethodBeat.m2505o(17536);
                        return;
                    case 1:
                        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify already start reconnect, state[%d]", Integer.valueOf(C19978b.aUb()));
                        break;
                }
                AppMethodBeat.m2505o(17536);
                return;
            case 27:
                C42759b.aTD().aTa().stop();
                C42759b.aTD().aSu().jqW = -100;
                c41256d.mo6681rj(-100);
                AppMethodBeat.m2505o(17536);
                return;
        }
        AppMethodBeat.m2505o(17536);
    }

    /* renamed from: a */
    static /* synthetic */ void m71824a(C41256d c41256d, byte[] bArr, int i) {
        AppMethodBeat.m2504i(17537);
        C19991n c19991n = (C19991n) C38635g.m65510a(new C19991n(), bArr);
        if (c19991n == null || !C42759b.aTD().jqO.equals(c19991n.f4366ID)) {
            String str;
            String str2 = "MicroMsg.BackupPcRecoverServer";
            String str3 = "startRequestNotify BackupStartRequest parseBuf:%d failed or wrong id[%s,%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(C5046bo.m7541cc(bArr));
            if (c19991n != null) {
                str = c19991n.f4366ID;
            } else {
                str = "buf is null";
            }
            objArr[1] = str;
            objArr[2] = C42759b.aTD().jqO;
            C4990ab.m7413e(str2, str3, objArr);
            C41256d.m71831d(1, i, 0);
            c41256d.mo65912c(false, false, -5);
            C7060h.pYm.mo8378a(400, 121, 1, false);
            AppMethodBeat.m2505o(17537);
            return;
        }
        double d;
        C42759b.aTD().aSu().jrc = c19991n.jBL;
        if (c19991n.jBQ == 3) {
            c41256d.jsA = true;
            C7060h.pYm.mo8378a(400, 36, 1, false);
            C4990ab.m7416i("MicroMsg.BackupPcRecoverServer", "isQuickBackup!!!");
        }
        long j = c19991n.jBP;
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        C9638aw.m17190ZK();
        C38635g.m65515a(pLong, pLong2, C18628c.getAccPath());
        long j2 = pLong2.value;
        if (((double) j) * 0.1d > 5.24288E8d) {
            d = 5.24288E8d;
        } else {
            d = ((double) j) * 0.1d;
        }
        long j3 = (j2 - ((long) d)) / 1048576;
        c41256d.jtp = C5046bo.anU();
        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "startRequestNotify time:%d SessionCount:%d, MsgCount:%d, DataSize:%d validSize:%d", Long.valueOf(c41256d.jtp), Long.valueOf(c19991n.jBM), Long.valueOf(c19991n.jBN), Long.valueOf(j), Long.valueOf(j3));
        if (j3 >= j) {
            C41256d.m71831d(0, i, j3);
            C19978b.aTU();
            AppMethodBeat.m2505o(17537);
            return;
        }
        C4990ab.m7413e("MicroMsg.BackupPcRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d", Long.valueOf(j3), Long.valueOf(j));
        C41256d.m71831d(2, i, j3);
        C33682a aTa = C42759b.aTD().aTa();
        if (aTa.jrp == null) {
            aTa.stop();
        } else {
            aTa.jrp.postDelayed(new C26463(), 10);
        }
        C42759b.aTD().aSu().jqW = -13;
        c41256d.mo6681rj(-13);
        C7060h.pYm.mo8378a(400, 6, 1, false);
        C7060h.pYm.mo8381e(13736, Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(C42759b.aTD().aTE().jwg));
        AppMethodBeat.m2505o(17537);
    }

    /* renamed from: b */
    static /* synthetic */ void m71827b(C41256d c41256d, byte[] bArr, int i) {
        AppMethodBeat.m2504i(17538);
        C38662i c38662i = (C38662i) C38635g.m65510a(new C38662i(), bArr);
        if (c38662i == null) {
            C4990ab.m7413e("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify parseBuf failed:%d", Integer.valueOf(C5046bo.m7541cc(bArr)));
            C42759b.aTD().aSu().jqW = -21;
            c41256d.mo6681rj(-21);
            AppMethodBeat.m2505o(17538);
            return;
        }
        c41256d.jtj = c38662i.jBx;
        c41256d.jtk = c38662i.jBy;
        if (c41256d.jtk.size() != c41256d.jtj.size() * 2) {
            c41256d.mo65912c(false, false, -21);
            C7060h.pYm.mo8378a(400, 119, 1, false);
            AppMethodBeat.m2505o(17538);
            return;
        }
        C42759b.aTD().aSu().mo68222O(23, 1, c41256d.jtj.size());
        c41256d.mo6681rj(23);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        C9638aw.m17190ZK().mo33889Yq().mo27487a(c41256d.jtj, c41256d.jtk, linkedList, linkedList2);
        C45752j c45752j = new C45752j();
        c45752j.jBx = linkedList;
        c45752j.jBy = linkedList2;
        C19978b.aTW();
        try {
            C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(c41256d.jtj.size()), Integer.valueOf(linkedList2.size()));
            C19978b.m30889r(c45752j.toByteArray(), 12, i);
            AppMethodBeat.m2505o(17538);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "BackupRequestSessionResponse to buf err.", new Object[0]);
            AppMethodBeat.m2505o(17538);
        }
    }

    /* renamed from: J */
    static /* synthetic */ void m71821J(byte[] bArr, int i) {
        AppMethodBeat.m2504i(17540);
        C27492af c27492af = (C27492af) C38635g.m65510a(new C27492af(), bArr);
        if (c27492af == null) {
            C4990ab.m7413e("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", Integer.valueOf(C5046bo.m7541cc(bArr)));
            AppMethodBeat.m2505o(17540);
            return;
        }
        C11152ag c11152ag = new C11152ag();
        c11152ag.jCP = c27492af.jCP;
        c11152ag.jCR = c27492af.jCR;
        c11152ag.jCQ = c27492af.jCQ;
        c11152ag.jBt = c27492af.jBt;
        try {
            C4990ab.m7416i("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify send SvrID resp");
            C19978b.m30889r(c11152ag.toByteArray(), 14, i);
            AppMethodBeat.m2505o(17540);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "PacketSvrIDResponse to buf err.", new Object[0]);
            AppMethodBeat.m2505o(17540);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m71823a(C41256d c41256d, byte[] bArr) {
        AppMethodBeat.m2504i(17542);
        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "finishReqNotify receive finishReq. hasReceiveFinishReq[%b]", Boolean.valueOf(jtr));
        if (jtr) {
            C4990ab.m7412e("MicroMsg.BackupPcRecoverServer", "finishReqNotify has receive finishReq, return.");
            AppMethodBeat.m2505o(17542);
            return;
        }
        jtr = true;
        if (C38635g.m65510a(new C11153d(), bArr) == null) {
            C4990ab.m7413e("MicroMsg.BackupPcRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", Integer.valueOf(C5046bo.m7541cc(bArr)));
        }
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE);
        C19978b.aTV();
        C19978b.aTX();
        jwl = true;
        C42759b.aTD().aSu().mo68222O(24, c41256d.jto.size(), c41256d.jtj.size());
        c41256d.mo6681rj(24);
        C7060h.pYm.mo8378a(400, 19, 1, false);
        c41256d.jwo = C5046bo.anU();
        C7060h.pYm.mo8378a(400, 20, (c41256d.jwo - c41256d.jtp) / 1000, false);
        C7060h.pYm.mo8378a(400, 21, c41256d.jrb / 1024, false);
        c41256d.mo65914rt(0);
        if (!c41256d.jwp) {
            c41256d.mo65914rt(21);
        }
        C4990ab.m7417i("MicroMsg.BackupPcRecoverServer", "finishReqNotify recover success. hasEnterReconnect[%b], recoverCostTime[%d s], recoverStartTime[%d], recoverEndTime[%d], recoverTotalSize[%d kb]", Boolean.valueOf(c41256d.jwp), Long.valueOf(r10 / 1000), Long.valueOf(c41256d.jtp), Long.valueOf(c41256d.jwo), Long.valueOf(c41256d.jrb / 1024));
        AppMethodBeat.m2505o(17542);
    }
}
