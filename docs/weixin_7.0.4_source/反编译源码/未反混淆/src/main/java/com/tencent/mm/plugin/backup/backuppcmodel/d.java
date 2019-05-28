package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.i;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class d implements com.tencent.mm.plugin.backup.b.b.d {
    private static boolean jtr = false;
    private static boolean jwl = false;
    private boolean eVT = false;
    private long jrb = 0;
    private boolean jsA = false;
    private com.tencent.mm.plugin.backup.c.d jti;
    LinkedList<String> jtj;
    LinkedList<Long> jtk;
    private HashSet<String> jto = new HashSet();
    private long jtp = 0;
    private long jtq = 0;
    public Set<c> jwm = new HashSet();
    public a jwn;
    private long jwo = 0;
    private boolean jwp = false;
    private final com.tencent.mm.plugin.backup.g.b.d jwq = new com.tencent.mm.plugin.backup.g.b.d() {
        public final void a(boolean z, final int i, final byte[] bArr, final int i2) {
            AppMethodBeat.i(17521);
            String str = "MicroMsg.BackupPcRecoverServer";
            String str2 = "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            ab.i(str, str2, objArr);
            if (z && CdnLogic.kMediaTypeBeatificFile == i) {
                d.a(d.this);
                AppMethodBeat.o(17521);
            } else if (i == 5) {
                ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
                d.this.c(true, false, -100);
                h.pYm.a(400, 52, 1, false);
                d.this.rt(5);
                AppMethodBeat.o(17521);
            } else {
                int i3 = b.aTD().aTE().jwa;
                if (2 != i3 && 4 != i3) {
                    ab.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", Integer.valueOf(b.aTD().aTE().jwa));
                    AppMethodBeat.o(17521);
                } else if (i == 10) {
                    f fVar = (f) g.a(new f(), bArr);
                    str2 = "MicroMsg.BackupPcRecoverServer";
                    String str3 = "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]";
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Long.valueOf(fVar != null ? fVar.jxD : -1);
                    ab.i(str2, str3, objArr2);
                    AppMethodBeat.o(17521);
                } else if (i == 18) {
                    com.tencent.mm.plugin.backup.i.c cVar = new com.tencent.mm.plugin.backup.i.c();
                    try {
                        cVar.parseFrom(bArr);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
                    }
                    ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", Integer.valueOf(cVar.jBh));
                    if (cVar.jBh == 9) {
                        if (b.aUb() == 1) {
                            b.ry(2);
                            ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                            d.this.rt(20);
                            b.aUa();
                            b.aTD().aSu().jqW = 23;
                            d.this.rj(23);
                            b.ry(0);
                            AppMethodBeat.o(17521);
                            return;
                        }
                        ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(b.aUb()));
                    }
                    AppMethodBeat.o(17521);
                } else if (i == 17) {
                    com.tencent.mm.plugin.backup.i.b bVar = new com.tencent.mm.plugin.backup.i.b();
                    try {
                        bVar.parseFrom(bArr);
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
                    }
                    ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", Integer.valueOf(bVar.jBh));
                    if (bVar.jBh == 10) {
                        i3 = b.aTD().aSu().jqW;
                        ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i3));
                        if (i3 == 22 || i3 == 23) {
                            d.this.c(true, false, -4);
                            b.aTD().aTa().stop();
                            h.pYm.a(400, 52, 1, false);
                            d.this.rt(5);
                            long j = 0;
                            if (d.this.jtp != 0) {
                                j = bo.gb(d.this.jtp);
                            }
                            h.pYm.e(13737, Integer.valueOf(3), Long.valueOf(d.this.jrb), Long.valueOf(j), Integer.valueOf(2));
                            ab.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(d.this.jrb), Long.valueOf(j));
                        }
                    }
                    AppMethodBeat.o(17521);
                } else {
                    aw.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(17520);
                            if (i == 3) {
                                d.a(d.this, bArr, i2);
                                AppMethodBeat.o(17520);
                            } else if (i == 11) {
                                d.b(d.this, bArr, i2);
                                AppMethodBeat.o(17520);
                            } else if (i == 6) {
                                d.c(d.this, bArr, i2);
                                AppMethodBeat.o(17520);
                            } else if (i == 13) {
                                d.J(bArr, i2);
                                AppMethodBeat.o(17520);
                            } else if (i == 15) {
                                d.d(d.this, bArr, i2);
                                AppMethodBeat.o(17520);
                            } else if (i == 8) {
                                d.a(d.this, bArr);
                                AppMethodBeat.o(17520);
                            } else {
                                AppMethodBeat.o(17520);
                            }
                        }
                    });
                    AppMethodBeat.o(17521);
                }
            }
        }
    };
    private Object lock = new Object();
    private long recvSize = 0;

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.d$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Set jwt;

        AnonymousClass2(Set set) {
            this.jwt = set;
        }

        public final void run() {
            AppMethodBeat.i(17522);
            for (c aSs : this.jwt) {
                aSs.aSs();
            }
            AppMethodBeat.o(17522);
        }
    }

    public d() {
        AppMethodBeat.i(17525);
        AppMethodBeat.o(17525);
    }

    public static void aTM() {
        jwl = true;
    }

    public final void init() {
        AppMethodBeat.i(17526);
        ab.i("MicroMsg.BackupPcRecoverServer", "init");
        this.jwp = false;
        jwl = false;
        jtr = false;
        b.a(this.jwq);
        this.jrb = 0;
        this.recvSize = 0;
        this.eVT = false;
        this.jsA = false;
        this.jto.clear();
        AppMethodBeat.o(17526);
    }

    public static boolean aTe() {
        AppMethodBeat.i(17527);
        boolean drz = aw.ZK().Yr().drz();
        AppMethodBeat.o(17527);
        return drz;
    }

    public final void aTf() {
        AppMethodBeat.i(17528);
        ab.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
        this.jto.clear();
        AppMethodBeat.o(17528);
    }

    public final void c(boolean z, boolean z2, int i) {
        int i2 = 0;
        AppMethodBeat.i(17529);
        ab.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", Boolean.valueOf(z), Boolean.valueOf(z2), an.doQ());
        jwl = true;
        if (!z) {
            b.aTD().aTE();
            c.aTj();
        }
        synchronized (this.lock) {
            try {
                this.eVT = true;
                if (this.jti == null || !this.jti.jsp) {
                    i2 = 1;
                } else {
                    this.jti.l(z2, i);
                }
                this.jti = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(17529);
                }
            }
        }
        if (!(i2 == 0 || i == 0)) {
            b.aTD().aSu().jqW = i;
            rj(i);
        }
        if (z2) {
            aTf();
        }
        b.aTV();
        b.aTX();
        b.aUa();
        AppMethodBeat.o(17529);
    }

    public final void rt(int i) {
        AppMethodBeat.i(17530);
        long j = 0;
        if (this.jtp != 0) {
            j = bo.gb(this.jtp);
        }
        h.pYm.e(13737, Integer.valueOf(i), Long.valueOf(this.jrb / 1024), Long.valueOf(j / 1000), Integer.valueOf(2), Integer.valueOf(b.aTD().aTE().jwg));
        ab.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(this.jrb / 1024), Long.valueOf(j / 1000));
        AppMethodBeat.o(17530);
    }

    private static void a(String str, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(17531);
        y yVar = new y();
        yVar.jCx = str;
        yVar.jCy = i;
        yVar.jCA = i2;
        yVar.jCB = i3;
        yVar.jBT = i4;
        try {
            b.r(yVar.toByteArray(), 7, i5);
            AppMethodBeat.o(17531);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "sendResp", new Object[0]);
            AppMethodBeat.o(17531);
        }
    }

    private static void d(int i, int i2, long j) {
        AppMethodBeat.i(17532);
        o oVar = new o();
        oVar.ID = b.aTD().jqO;
        oVar.jBT = i;
        oVar.jBO = g.gw(j);
        try {
            ab.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", Integer.valueOf(i));
            b.r(oVar.toByteArray(), 4, i2);
            AppMethodBeat.o(17532);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "buf to BackupStartRequest err.", new Object[0]);
            AppMethodBeat.o(17532);
        }
    }

    public final void aSL() {
        AppMethodBeat.i(17533);
        synchronized (this.lock) {
            try {
                if (this.jti == null || !this.jti.jsp) {
                    int drA;
                    if (this.jti != null) {
                        this.jti.l(false, 0);
                    }
                    if (this.jto == null || this.jto.size() <= 0) {
                        drA = aw.ZK().Yr().drA();
                    } else {
                        drA = this.jto.size();
                    }
                    b.aTD().aSu().O(26, 1, drA);
                    rj(26);
                    if (this.jtj == null) {
                        this.jtj = new LinkedList();
                    }
                    if (this.jtk == null) {
                        this.jtk = new LinkedList();
                    }
                    this.jtq = bo.anU();
                    this.jti = new com.tencent.mm.plugin.backup.c.d(b.aTD(), 1, this, drA, this.jsA, this.jtj, this.jtk);
                    this.jti.aSL();
                    h.pYm.a(400, 24, 1, false);
                    AppMethodBeat.o(17533);
                    return;
                }
                ab.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
            } finally {
                AppMethodBeat.o(17533);
            }
        }
    }

    public final void rj(final int i) {
        AppMethodBeat.i(17534);
        final HashSet hashSet = new HashSet();
        hashSet.addAll(this.jwm);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17523);
                for (c rj : hashSet) {
                    rj.rj(i);
                }
                AppMethodBeat.o(17523);
            }
        });
        if (this.jwn != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17524);
                    if (d.this.jwn != null) {
                        d.this.jwn.ri(i);
                    }
                    AppMethodBeat.o(17524);
                }
            });
        }
        AppMethodBeat.o(17534);
    }

    public final void aSt() {
        AppMethodBeat.i(17535);
        aTf();
        h.pYm.a(400, 27, 1, false);
        h.pYm.a(400, 28, bo.gb(this.jtq) / 1000, false);
        b.rx(12);
        b.aTV();
        b.aTX();
        AppMethodBeat.o(17535);
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(17536);
        ab.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify local disconnect, backupPcState[%d], isRecoverFinish[%b]", Integer.valueOf(b.aTD().aSu().jqW), Boolean.valueOf(jwl));
        switch (b.aTD().aSu().jqW) {
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
                b.aTD().aTa().stop();
                AppMethodBeat.o(17536);
                return;
            case -4:
                dVar.c(true, false, 0);
                break;
            case 1:
            case 21:
                b.aTD().aTa().stop();
                b.aTD().aSu().jqW = -100;
                dVar.rj(-100);
                AppMethodBeat.o(17536);
                return;
            case 4:
            case 22:
            case 23:
                if (!b.aTD().aTE().jwe || jwl) {
                    ab.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify not support reconnect, disconnect");
                    dVar.c(true, false, -4);
                    b.aTD().aTa().stop();
                    h.pYm.a(400, 17, 1, false);
                    dVar.rt(3);
                    AppMethodBeat.o(17536);
                    return;
                }
                switch (b.aUb()) {
                    case 0:
                    case 2:
                        ab.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify startBackupReconnectHandler, reconnectState[%d]", Integer.valueOf(b.aUb()));
                        dVar.rt(19);
                        dVar.jwp = true;
                        b.a(b.aTD().aTE().jwj);
                        AppMethodBeat.o(17536);
                        return;
                    case 1:
                        ab.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify already start reconnect, state[%d]", Integer.valueOf(b.aUb()));
                        break;
                }
                AppMethodBeat.o(17536);
                return;
            case 27:
                b.aTD().aTa().stop();
                b.aTD().aSu().jqW = -100;
                dVar.rj(-100);
                AppMethodBeat.o(17536);
                return;
        }
        AppMethodBeat.o(17536);
    }

    static /* synthetic */ void a(d dVar, byte[] bArr, int i) {
        AppMethodBeat.i(17537);
        n nVar = (n) g.a(new n(), bArr);
        if (nVar == null || !b.aTD().jqO.equals(nVar.ID)) {
            String str;
            String str2 = "MicroMsg.BackupPcRecoverServer";
            String str3 = "startRequestNotify BackupStartRequest parseBuf:%d failed or wrong id[%s,%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bo.cc(bArr));
            if (nVar != null) {
                str = nVar.ID;
            } else {
                str = "buf is null";
            }
            objArr[1] = str;
            objArr[2] = b.aTD().jqO;
            ab.e(str2, str3, objArr);
            d(1, i, 0);
            dVar.c(false, false, -5);
            h.pYm.a(400, 121, 1, false);
            AppMethodBeat.o(17537);
            return;
        }
        double d;
        b.aTD().aSu().jrc = nVar.jBL;
        if (nVar.jBQ == 3) {
            dVar.jsA = true;
            h.pYm.a(400, 36, 1, false);
            ab.i("MicroMsg.BackupPcRecoverServer", "isQuickBackup!!!");
        }
        long j = nVar.jBP;
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        aw.ZK();
        g.a(pLong, pLong2, com.tencent.mm.model.c.getAccPath());
        long j2 = pLong2.value;
        if (((double) j) * 0.1d > 5.24288E8d) {
            d = 5.24288E8d;
        } else {
            d = ((double) j) * 0.1d;
        }
        long j3 = (j2 - ((long) d)) / 1048576;
        dVar.jtp = bo.anU();
        ab.i("MicroMsg.BackupPcRecoverServer", "startRequestNotify time:%d SessionCount:%d, MsgCount:%d, DataSize:%d validSize:%d", Long.valueOf(dVar.jtp), Long.valueOf(nVar.jBM), Long.valueOf(nVar.jBN), Long.valueOf(j), Long.valueOf(j3));
        if (j3 >= j) {
            d(0, i, j3);
            b.aTU();
            AppMethodBeat.o(17537);
            return;
        }
        ab.e("MicroMsg.BackupPcRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d", Long.valueOf(j3), Long.valueOf(j));
        d(2, i, j3);
        com.tencent.mm.plugin.backup.c.a aTa = b.aTD().aTa();
        if (aTa.jrp == null) {
            aTa.stop();
        } else {
            aTa.jrp.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17155);
                    a.this.stop();
                    AppMethodBeat.o(17155);
                }
            }, 10);
        }
        b.aTD().aSu().jqW = -13;
        dVar.rj(-13);
        h.pYm.a(400, 6, 1, false);
        h.pYm.e(13736, Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(b.aTD().aTE().jwg));
        AppMethodBeat.o(17537);
    }

    static /* synthetic */ void b(d dVar, byte[] bArr, int i) {
        AppMethodBeat.i(17538);
        i iVar = (i) g.a(new i(), bArr);
        if (iVar == null) {
            ab.e("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify parseBuf failed:%d", Integer.valueOf(bo.cc(bArr)));
            b.aTD().aSu().jqW = -21;
            dVar.rj(-21);
            AppMethodBeat.o(17538);
            return;
        }
        dVar.jtj = iVar.jBx;
        dVar.jtk = iVar.jBy;
        if (dVar.jtk.size() != dVar.jtj.size() * 2) {
            dVar.c(false, false, -21);
            h.pYm.a(400, 119, 1, false);
            AppMethodBeat.o(17538);
            return;
        }
        b.aTD().aSu().O(23, 1, dVar.jtj.size());
        dVar.rj(23);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        aw.ZK().Yq().a(dVar.jtj, dVar.jtk, linkedList, linkedList2);
        j jVar = new j();
        jVar.jBx = linkedList;
        jVar.jBy = linkedList2;
        b.aTW();
        try {
            ab.i("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(dVar.jtj.size()), Integer.valueOf(linkedList2.size()));
            b.r(jVar.toByteArray(), 12, i);
            AppMethodBeat.o(17538);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "BackupRequestSessionResponse to buf err.", new Object[0]);
            AppMethodBeat.o(17538);
        }
    }

    static /* synthetic */ void J(byte[] bArr, int i) {
        AppMethodBeat.i(17540);
        af afVar = (af) g.a(new af(), bArr);
        if (afVar == null) {
            ab.e("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", Integer.valueOf(bo.cc(bArr)));
            AppMethodBeat.o(17540);
            return;
        }
        ag agVar = new ag();
        agVar.jCP = afVar.jCP;
        agVar.jCR = afVar.jCR;
        agVar.jCQ = afVar.jCQ;
        agVar.jBt = afVar.jBt;
        try {
            ab.i("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify send SvrID resp");
            b.r(agVar.toByteArray(), 14, i);
            AppMethodBeat.o(17540);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "PacketSvrIDResponse to buf err.", new Object[0]);
            AppMethodBeat.o(17540);
        }
    }

    static /* synthetic */ void a(d dVar, byte[] bArr) {
        AppMethodBeat.i(17542);
        ab.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify receive finishReq. hasReceiveFinishReq[%b]", Boolean.valueOf(jtr));
        if (jtr) {
            ab.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify has receive finishReq, return.");
            AppMethodBeat.o(17542);
            return;
        }
        jtr = true;
        if (g.a(new com.tencent.mm.plugin.backup.i.d(), bArr) == null) {
            ab.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", Integer.valueOf(bo.cc(bArr)));
        }
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(ac.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE);
        b.aTV();
        b.aTX();
        jwl = true;
        b.aTD().aSu().O(24, dVar.jto.size(), dVar.jtj.size());
        dVar.rj(24);
        h.pYm.a(400, 19, 1, false);
        dVar.jwo = bo.anU();
        h.pYm.a(400, 20, (dVar.jwo - dVar.jtp) / 1000, false);
        h.pYm.a(400, 21, dVar.jrb / 1024, false);
        dVar.rt(0);
        if (!dVar.jwp) {
            dVar.rt(21);
        }
        ab.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify recover success. hasEnterReconnect[%b], recoverCostTime[%d s], recoverStartTime[%d], recoverEndTime[%d], recoverTotalSize[%d kb]", Boolean.valueOf(dVar.jwp), Long.valueOf(r10 / 1000), Long.valueOf(dVar.jtp), Long.valueOf(dVar.jwo), Long.valueOf(dVar.jrb / 1024));
        AppMethodBeat.o(17542);
    }
}
