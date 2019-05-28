package com.tencent.mm.plugin.backup.d;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.af;
import com.tencent.mm.plugin.backup.i.ag;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.plugin.backup.i.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.n;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c implements d, b.d {
    private static boolean aGz = false;
    private static int eRu = 0;
    private static boolean jtr = false;
    private static boolean jts = false;
    String ceI;
    private boolean eVT = false;
    private long jrb = 0;
    private boolean jsA = false;
    public d jsv;
    private boolean jtA = false;
    private int jtB;
    public String jtC;
    String jtD;
    int jtE;
    private ap jtF;
    final f jtG = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17246);
            aw.Rg().b((int) l.CTRL_INDEX, c.this.jtG);
            if (i == 0 && i2 == 0) {
                ahq aUk = ((e) mVar).aUk();
                aw.ZK();
                if (bo.nullAsNil((String) com.tencent.mm.model.c.Ry().get(2, null)).equals(aUk.vIQ)) {
                    String str2;
                    b.aSZ().jqO = aUk.ID;
                    b.aSZ().jqP = aUk.vIW;
                    b.aSZ().jqQ = aUk.vIX;
                    b.a(c.this.jtL);
                    b.aSZ().aSv();
                    b.a(b.aSZ().aTc());
                    b.a(b.aSZ().aTa());
                    b.rk(2);
                    b.a(c.this.jtM);
                    int i3 = 0;
                    if (aUk.vIN > 0) {
                        ua uaVar = (ua) aUk.vIO.getFirst();
                        String str3 = uaVar.vYA;
                        i3 = ((Integer) uaVar.wbp.getFirst()).intValue();
                        str2 = str3;
                    } else {
                        ab.e("MicroMsg.BackupMoveRecoverServer", "summerbak address convMsgCount is empty");
                        str2 = null;
                    }
                    c cVar = c.this;
                    cVar.jtC = aUk.vIR;
                    cVar.jtD = str2;
                    cVar.jtE = i3;
                    ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak getconnetinfo, type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", Integer.valueOf(aUk.jCt), Integer.valueOf(aUk.Scene), aUk.vIR, str2, Integer.valueOf(i3));
                    com.tencent.mm.plugin.backup.b.d.rk(22);
                    b.aSZ().aSu().jqW = 1;
                    Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "backup_move_notification");
                    ah.getContext().startActivity(className);
                    h.pYm.a(485, 41, 1, false);
                    c.aGz = false;
                    ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak try connct old phone, oldphone ip:%s, oldphone wifi:%s, newphone wifi:%s", str2, aUk.vIR, g.ds(ah.getContext()));
                    c.eRu = 2;
                    c.a(c.this, str2, i3);
                    AppMethodBeat.o(17246);
                    return;
                }
                ab.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnectinfo not the same account");
                b.aSZ().aSu().jqW = -5;
                c.this.rj(-5);
                AppMethodBeat.o(17246);
                return;
            }
            ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info other error [%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 4 && i2 == -2011) {
                ab.e("MicroMsg.BackupMoveRecoverServer", "summerbak getConnect info: INVALID URL");
            }
            b.aSZ().aSu().jqW = -5;
            c.this.rj(-5);
            AppMethodBeat.o(17246);
        }
    };
    private final f jtH = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17250);
            c.aGz = true;
            h.pYm.a(485, 42, 1, false);
            h.pYm.e(11787, Integer.valueOf(0));
            b.b(1, c.this.jtH);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth success");
                com.tencent.mm.plugin.backup.g.a aVar = (com.tencent.mm.plugin.backup.g.a) mVar;
                if (aVar.jwY.Version < com.tencent.mm.plugin.backup.b.c.jqG) {
                    ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start old move, version:%d", Integer.valueOf(aVar.jwY.Version));
                    h.pYm.a(485, 104, 1, false);
                    b.aSZ().aSu().jqW = -12;
                    c.this.rj(-12);
                    AppMethodBeat.o(17250);
                    return;
                }
                boolean z;
                int i3 = aVar.jwY.jCt;
                c cVar = c.this;
                if ((aVar.jwY.jCu & com.tencent.mm.plugin.backup.b.c.jqK) == 0) {
                    z = false;
                } else {
                    z = true;
                }
                cVar.jtx = z;
                ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd start new move, version:%d, type:%d, isServerSupportKv:%b", Integer.valueOf(aVar.jwY.Version), Integer.valueOf(i3), Boolean.valueOf(c.this.jtx));
                if (i3 == com.tencent.mm.plugin.backup.b.c.jqI && c.aTe()) {
                    c.this.jtz = true;
                    ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Resume Move!!!.");
                } else {
                    c.this.aTf();
                    c.this.jtz = false;
                    ab.i("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd is Normal move.");
                }
                c.g(c.this);
                b.a(3, c.this.jtI);
                new k(b.aSZ().jqO).aUc();
                b.aSZ().aSu().jqW = 22;
                c.this.rj(22);
                AppMethodBeat.o(17250);
                return;
            }
            ab.e("MicroMsg.BackupMoveRecoverServer", "onBackupAuthEnd auth failed");
            b.aSZ().aSu().jqW = -5;
            c.this.rj(-5);
            c.this.rn(3);
            AppMethodBeat.o(17250);
        }
    };
    private final f jtI = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17251);
            b.b(3, c.this.jtI);
            ab.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                k kVar = (k) mVar;
                o oVar = kVar.jyg;
                if (b.aSZ().jqO.equals(oVar.ID)) {
                    Object obj;
                    double d;
                    b.aSZ().aSu().jrc = oVar.jBL;
                    c.this.ceI = kVar.jyg.jBO.jBE;
                    if (kVar.jyg.jBO.jBH.toLowerCase().contains("ios")) {
                        c.this.jtB = 1;
                    } else {
                        c.this.jtB = 2;
                    }
                    c.this.jrb = kVar.jyg.jBS;
                    c.this.jtv = kVar.jyg.jBU;
                    ab.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d], and wait old mobile's pushData", Long.valueOf(kVar.jyg.jBR), Long.valueOf(kVar.jyg.jBS));
                    if (c.this.jty && c.this.jtx) {
                        int i3;
                        h hVar = h.pYm;
                        if (c.this.jtw || c.this.jtv == 1) {
                            i3 = 66;
                        } else {
                            i3 = 65;
                        }
                        hVar.a(485, (long) i3, 1, false);
                    }
                    if (kVar.jyg.jBQ == 3) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        c.this.jsA = true;
                        ab.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
                    } else {
                        c.this.jsA = false;
                    }
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    aw.ZK();
                    g.a(pLong, pLong2, com.tencent.mm.model.c.getAccPath());
                    long l = c.this.jrb;
                    if (((double) c.this.jrb) * 0.1d > 5.24288E8d) {
                        d = 5.24288E8d;
                    } else {
                        d = ((double) c.this.jrb) * 0.1d;
                    }
                    long j = ((long) d) + l;
                    c.this.jtJ = j;
                    if (pLong2.value < j) {
                        ab.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", Long.valueOf(pLong2.value), Long.valueOf(j), Long.valueOf(c.this.jrb));
                        h.pYm.e(11787, Integer.valueOf(5));
                        b.aSZ().aTa().stop();
                        b.aSZ().aSu().jqW = -13;
                        c.this.rj(-13);
                        h.pYm.a(485, 5, 1, false);
                        AppMethodBeat.o(17251);
                        return;
                    }
                    c.this.jtp = bo.anU();
                    b.aTU();
                    AppMethodBeat.o(17251);
                    return;
                }
                ab.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
                b.aSZ().aSu().jqW = -5;
                c.this.rj(-5);
                AppMethodBeat.o(17251);
                return;
            }
            ab.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(str)));
            b.aSZ().aSu().jqW = -5;
            c.this.rj(-5);
            AppMethodBeat.o(17251);
        }
    };
    public long jtJ;
    private int jtK;
    com.tencent.mm.plugin.backup.g.b.c jtL = new com.tencent.mm.plugin.backup.g.b.c() {
        public final void aTm() {
            AppMethodBeat.i(17255);
            ab.i("MicroMsg.BackupMoveRecoverServer", "stopCallback ");
            b.aTV();
            b.aSZ().aSw();
            AppMethodBeat.o(17255);
        }
    };
    private final com.tencent.mm.plugin.backup.g.j.a jtM = new com.tencent.mm.plugin.backup.g.j.a() {
        public final void aTn() {
            AppMethodBeat.i(17256);
            c.this.rj(b.aSZ().aSu().jqW);
            AppMethodBeat.o(17256);
        }

        public final void ro(int i) {
            AppMethodBeat.i(17257);
            int i2 = b.aSZ().aSu().jqW;
            if (i == 1) {
                if (i2 == 23) {
                    ab.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is weak connect now.");
                    b.aSZ().aSu().jqW = 4;
                    c.this.rj(4);
                    h.pYm.e(11789, Integer.valueOf(8));
                    AppMethodBeat.o(17257);
                    return;
                }
            } else if (i == 0 && i2 == 4) {
                ab.i("MicroMsg.BackupMoveRecoverServer", "speedCallback is normal speed now.");
                b.aSZ().aSu().jqW = 23;
                c.this.rj(23);
                h.pYm.e(11789, Integer.valueOf(9));
            }
            AppMethodBeat.o(17257);
        }

        public final void aTo() {
            AppMethodBeat.i(17258);
            int i = b.aSZ().aSu().jqW;
            ab.e("MicroMsg.BackupMoveRecoverServer", "speedOverTime callback, backupState[%d]", Integer.valueOf(i));
            if (i == 23 || i == 4) {
                c.this.c(true, false, -4);
                h.pYm.a(485, 43, 1, false);
                c.this.rn(4);
                b.aSZ().aTa().stop();
            }
            AppMethodBeat.o(17258);
        }
    };
    private com.tencent.mm.plugin.backup.c.d jti;
    private LinkedList<String> jtj;
    private LinkedList<Long> jtk;
    private LinkedList<String> jtl;
    private LinkedList<Long> jtm;
    public com.tencent.mm.plugin.backup.b.b.a jtn;
    private HashSet<String> jto = new HashSet();
    private long jtp = 0;
    private long jtq = 0;
    private boolean jtt = true;
    private HashSet<String> jtu = new HashSet();
    private int jtv = 0;
    public boolean jtw = false;
    private boolean jtx = true;
    private boolean jty = true;
    private boolean jtz = false;
    private Object lock = new Object();
    private long recvSize = 0;

    class a {
        byte[] buf;
        int fQi;
        boolean iae = false;
        int type;

        a(int i, int i2, byte[] bArr) {
            AppMethodBeat.i(17259);
            this.fQi = i;
            this.type = i2;
            this.buf = (byte[]) bArr.clone();
            AppMethodBeat.o(17259);
        }
    }

    public c() {
        AppMethodBeat.i(17260);
        AppMethodBeat.o(17260);
    }

    static /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(17277);
        cVar.aTg();
        AppMethodBeat.o(17277);
    }

    public static boolean aTe() {
        AppMethodBeat.i(17261);
        boolean drz = aw.ZK().Yr().drz();
        AppMethodBeat.o(17261);
        return drz;
    }

    public final void aTf() {
        AppMethodBeat.i(17262);
        ab.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
        this.jto.clear();
        AppMethodBeat.o(17262);
    }

    public final void c(boolean z, boolean z2, int i) {
        int i2 = 0;
        AppMethodBeat.i(17263);
        ab.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), an.doQ());
        if (!z) {
            aTj();
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
                    AppMethodBeat.o(17263);
                }
            }
        }
        if (!(i2 == 0 || i == 0)) {
            b.aSZ().aSu().jqW = i;
            rj(i);
        }
        if (z2) {
            aTf();
        }
        b.aTV();
        b.aTX();
        b.aSZ().aTa().jrq = null;
        AppMethodBeat.o(17263);
    }

    private void bD(String str, int i) {
        boolean z = true;
        AppMethodBeat.i(17264);
        b.aSZ().aTa().connect(str, i);
        b.a(1, this.jtH);
        try {
            if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
                z = false;
            }
            this.jty = z;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "getInt", new Object[0]);
        }
        com.tencent.mm.plugin.backup.g.a aVar = new com.tencent.mm.plugin.backup.g.a(b.aSZ().jqP, b.aSZ().jqQ, com.tencent.mm.plugin.backup.b.d.aSy(), b.aSZ().jqO, com.tencent.mm.plugin.backup.b.c.jqG, 22);
        aVar.u(this.jty, false);
        aVar.aUc();
        ab.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
        if (this.jtF == null) {
            this.jtF = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(17249);
                    if (!c.aGz) {
                        ab.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
                        if (c.this.jtF != null) {
                            c.this.jtF.stopTimer();
                        }
                        c.d(c.this);
                    }
                    AppMethodBeat.o(17249);
                    return true;
                }
            }, false);
        }
        this.jtF.ae(3000, 3000);
        AppMethodBeat.o(17264);
    }

    public final void a(boolean z, final int i, final byte[] bArr, final int i2) {
        AppMethodBeat.i(17266);
        String str = "MicroMsg.BackupMoveRecoverServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str, str2, objArr);
        if (z && CdnLogic.kMediaTypeBeatificFile == i) {
            ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak local disconnect, backupMoveState:%d", Integer.valueOf(b.aSZ().aSu().jqW));
            switch (b.aSZ().aSu().jqW) {
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -13:
                case -5:
                    b.aSZ().aTa().stop();
                    AppMethodBeat.o(17266);
                    return;
                case -4:
                    c(true, false, 0);
                    break;
                case 1:
                    b.aSZ().aTa().stop();
                    if (aGz) {
                        b.aSZ().aSu().jqW = -4;
                        rj(-4);
                        AppMethodBeat.o(17266);
                        return;
                    }
                    if (this.jtF != null) {
                        ab.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
                        this.jtF.stopTimer();
                    }
                    aTg();
                    AppMethodBeat.o(17266);
                    return;
                case 22:
                case 23:
                    c(true, false, -4);
                    b.aSZ().aTa().stop();
                    jts = true;
                    h.pYm.a(485, 43, 1, false);
                    rn(4);
                    long j = 0;
                    if (this.jtp != 0) {
                        j = bo.gb(this.jtp);
                    }
                    ab.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(this.jrb), Long.valueOf(j));
                    AppMethodBeat.o(17266);
                    return;
            }
            AppMethodBeat.o(17266);
        } else if (i == 9) {
            com.tencent.mm.plugin.backup.i.e eVar = (com.tencent.mm.plugin.backup.i.e) g.a(new com.tencent.mm.plugin.backup.i.e(), bArr);
            if (eVar == null) {
                ab.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", Integer.valueOf(bo.cc(bArr)));
                AppMethodBeat.o(17266);
                return;
            }
            ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat req, req:%s ack:%d", eVar, Long.valueOf(eVar.jxD));
            com.tencent.mm.plugin.backup.i.f fVar = new com.tencent.mm.plugin.backup.i.f();
            fVar.jxD = eVar.jxD;
            try {
                ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak send heartbeat resp");
                b.r(fVar.toByteArray(), 10, i2);
                AppMethodBeat.o(17266);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
                AppMethodBeat.o(17266);
            }
        } else if (i == 10) {
            com.tencent.mm.plugin.backup.i.f fVar2 = (com.tencent.mm.plugin.backup.i.f) g.a(new com.tencent.mm.plugin.backup.i.f(), bArr);
            str2 = "MicroMsg.BackupMoveRecoverServer";
            String str3 = "summerbak receive heartbeat response, resp:%s ack:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = fVar2;
            objArr2[1] = Long.valueOf(fVar2 != null ? fVar2.jxD : -1);
            ab.i(str2, str3, objArr2);
            AppMethodBeat.o(17266);
        } else {
            if (i == 5) {
                h.pYm.a(485, 51, 1, false);
                c(true, false, -100);
            }
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17252);
                    if (i == 11) {
                        c.a(c.this, bArr, i2);
                        AppMethodBeat.o(17252);
                    } else if (i == 6) {
                        c.b(c.this, bArr, i2);
                        AppMethodBeat.o(17252);
                    } else if (i == 13) {
                        c.I(bArr, i2);
                        AppMethodBeat.o(17252);
                    } else if (i == 15) {
                        c.c(c.this, bArr, i2);
                        AppMethodBeat.o(17252);
                    } else if (i == 8) {
                        c.a(c.this, bArr);
                        AppMethodBeat.o(17252);
                    } else {
                        AppMethodBeat.o(17252);
                    }
                }
            });
            AppMethodBeat.o(17266);
        }
    }

    public final void fk(boolean z) {
        AppMethodBeat.i(17267);
        this.jtA = z;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        b.aSZ().aTa().jrq = new com.tencent.mm.plugin.backup.c.a.a() {
            public final void c(int i, int i2, byte[] bArr) {
                AppMethodBeat.i(17253);
                while (!c.this.eVT) {
                    try {
                        if (linkedBlockingQueue.offer(new a(i, i2, bArr), 500, TimeUnit.MILLISECONDS)) {
                            break;
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse onBackupMoveRecoverDatapushCallback e:%s", e.getMessage());
                    }
                }
                ab.i("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse offer datapushQueue, datapushQueue size:%d", Integer.valueOf(linkedBlockingQueue.size()));
                AppMethodBeat.o(17253);
            }
        };
        com.tencent.mm.sdk.g.d.h(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17254);
                while (!c.this.eVT && !c.jtr) {
                    a aVar;
                    try {
                        aVar = (a) linkedBlockingQueue.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        aVar = null;
                    }
                    ab.d("MicroMsg.BackupMoveRecoverServer", "startSendRequestSessionResponse datapushQueue size:%d, startNext receiveData:%s", Integer.valueOf(linkedBlockingQueue.size()), aVar);
                    if (aVar != null) {
                        c.this.a(aVar.iae, aVar.type, aVar.buf, aVar.fQi);
                    }
                }
                AppMethodBeat.o(17254);
            }
        }, "startSendRequestSessionResponse.onNotifyWorker").start();
        this.jtl = new LinkedList();
        this.jtm = new LinkedList();
        aw.ZK().Yq().a(this.jtj, this.jtk, this.jtl, this.jtm);
        if (!(this.jsA || z)) {
            LinkedList linkedList = this.jtl;
            LinkedList linkedList2 = this.jtm;
            this.jtl = new LinkedList();
            this.jtm = new LinkedList();
            aw.ZK().Yp().a(this.ceI, linkedList, linkedList2, this.jtl, this.jtm);
        }
        j jVar = new j();
        jVar.jBx = this.jtl;
        jVar.jBy = this.jtm;
        try {
            ab.i("MicroMsg.BackupMoveRecoverServer", "summerbak send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(this.jtj.size()), Integer.valueOf(jVar.jBy.size()));
            b.r(jVar.toByteArray(), 12, this.jtK);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupRequestSessionResponse err.", new Object[0]);
        }
        b.aTW();
        if (this.jtz) {
            b.aSZ().aSu().O(23, 1, this.jtj.size());
            this.recvSize = b.aSZ().aSu().jra;
        } else {
            b.aSZ().aSu().a(23, 1, this.jtj.size(), 0, this.jrb);
        }
        rj(23);
        AppMethodBeat.o(17267);
    }

    private static void a(String str, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(17268);
        y yVar = new y();
        yVar.jCx = str;
        yVar.jCy = i;
        yVar.jCA = i2;
        yVar.jCB = i3;
        yVar.jBT = i4;
        try {
            b.r(yVar.toByteArray(), 7, i5);
            AppMethodBeat.o(17268);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "sendResp", new Object[0]);
            AppMethodBeat.o(17268);
        }
    }

    public final void rn(int i) {
        AppMethodBeat.i(17269);
        long j = 0;
        if (this.jtp != 0) {
            j = bo.gb(this.jtp);
        }
        h.pYm.e(11789, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(this.jtB), Long.valueOf(this.jrb / 1024), Long.valueOf(j / 1000));
        ab.i("MicroMsg.BackupMoveRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recoverCostTime[%d s]", Integer.valueOf(11789), Integer.valueOf(i), Long.valueOf(this.jrb / 1024), Long.valueOf(j / 1000));
        AppMethodBeat.o(17269);
    }

    public final void aTh() {
        AppMethodBeat.i(17270);
        c(true, false, 28);
        b.aSZ().aTa().stop();
        AppMethodBeat.o(17270);
    }

    public final void aSL() {
        AppMethodBeat.i(17271);
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
                    b.aSZ().aSu().jqW = 26;
                    b.aSZ().aSu().jqZ = 0;
                    rj(26);
                    this.jtq = bo.anU();
                    this.jti = new com.tencent.mm.plugin.backup.c.d(b.aSZ(), 22, this, drA, false, new LinkedList(), new LinkedList());
                    this.jti.aSL();
                    h.pYm.a(485, 46, 1, false);
                    AppMethodBeat.o(17271);
                    return;
                }
                ab.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
            } finally {
                AppMethodBeat.o(17271);
            }
        }
    }

    public static String aTi() {
        AppMethodBeat.i(17272);
        String aTY = b.aTY();
        AppMethodBeat.o(17272);
        return aTY;
    }

    private static void aTj() {
        AppMethodBeat.i(17273);
        com.tencent.mm.plugin.backup.i.a aVar = new com.tencent.mm.plugin.backup.i.a();
        aVar.ID = b.aSZ().jqO;
        try {
            ab.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
            b.K(aVar.toByteArray(), 5);
            AppMethodBeat.o(17273);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupCancelRequest err.", new Object[0]);
            AppMethodBeat.o(17273);
        }
    }

    public final void rj(final int i) {
        AppMethodBeat.i(17274);
        if (this.jsv != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17247);
                    if (c.this.jsv != null) {
                        c.this.jsv.rj(i);
                    }
                    AppMethodBeat.o(17247);
                }
            });
        }
        if (this.jtn != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17248);
                    if (c.this.jtn != null) {
                        c.this.jtn.ri(i);
                    }
                    AppMethodBeat.o(17248);
                }
            });
        }
        AppMethodBeat.o(17274);
    }

    public final void aSt() {
        AppMethodBeat.i(17275);
        h.pYm.a(485, 49, 1, false);
        h.pYm.a(485, 50, bo.gb(this.jtq) / 1000, false);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.TRUE);
        ab.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS.");
        if (!this.jsA) {
            n Yq = aw.ZK().Yq();
            LinkedList linkedList = new LinkedList();
            Cursor baR = Yq.baR();
            if (baR == null) {
                ab.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
            } else {
                while (baR.moveToNext()) {
                    com.tencent.mm.storage.m mVar = new com.tencent.mm.storage.m();
                    mVar.d(baR);
                    linkedList.add(mVar);
                }
                baR.close();
            }
            if (linkedList.size() <= 0) {
                ab.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
            } else {
                ab.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
                aw.ZK().Yp().f(this.ceI, linkedList);
            }
        }
        aTf();
        b.rx(22);
        b.aTV();
        b.aTX();
        AppMethodBeat.o(17275);
    }

    private void aTg() {
        AppMethodBeat.i(17265);
        String str = this.jtC;
        String str2 = this.jtD;
        String ds = g.ds(ah.getContext());
        ab.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", ds, str, str2, Integer.valueOf(eRu));
        if (ds == null || ds.equals("")) {
            h.pYm.a(485, 1, 1, false);
            h.pYm.e(11787, Integer.valueOf(1));
            b.aSZ().aSu().jqW = -1;
            rj(-1);
            AppMethodBeat.o(17265);
        } else if (str == null || !str.equals(ds)) {
            h.pYm.a(485, 2, 1, false);
            h.pYm.e(11787, Integer.valueOf(2));
            b.aSZ().aSu().jqW = -2;
            rj(-2);
            AppMethodBeat.o(17265);
        } else if (!g.Fc(str2)) {
            h.pYm.a(485, 3, 1, false);
            h.pYm.e(11787, Integer.valueOf(3));
            b.aSZ().aSu().jqW = -3;
            rj(-3);
            AppMethodBeat.o(17265);
        } else if (eRu <= 0) {
            b.aSZ().aSu().jqW = -5;
            rj(-5);
            h.pYm.a(485, 4, 1, false);
            h.pYm.e(11787, Integer.valueOf(6));
            AppMethodBeat.o(17265);
        } else {
            eRu--;
            bD(this.jtD, this.jtE);
            AppMethodBeat.o(17265);
        }
    }

    static /* synthetic */ void g(c cVar) {
        AppMethodBeat.i(17278);
        ab.i("MicroMsg.BackupMoveRecoverServer", "move recover init");
        jtr = false;
        jts = false;
        cVar.jrb = 0;
        cVar.recvSize = 0;
        cVar.eVT = false;
        cVar.jto.clear();
        cVar.jtt = true;
        cVar.jtu.clear();
        AppMethodBeat.o(17278);
    }

    static /* synthetic */ void b(c cVar, byte[] bArr, int i) {
        int i2 = 1;
        AppMethodBeat.i(17280);
        if (cVar.jtt) {
            cVar.jtt = false;
        }
        x xVar = (x) g.a(new x(), bArr);
        if (xVar == null) {
            ab.e("MicroMsg.BackupMoveRecoverServer", "dataPushNotify parseBuf failed:%d", Integer.valueOf(bo.cc(bArr)));
            a("", 0, 0, 0, 1, i);
            AppMethodBeat.o(17280);
            return;
        }
        ab.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recoverData id:%s, type:%d, start:%d, end:%d", xVar.jCx, Integer.valueOf(xVar.jCy), Integer.valueOf(xVar.jCA), Integer.valueOf(xVar.jCB));
        if (xVar.jCy == 1 && xVar.jBi != null) {
            ab.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify text dataid:%s, dir:%s", xVar.jCx, g.EZ(xVar.jCx));
            g.b(r2, xVar);
            cVar.recvSize += (long) xVar.jBi.wR.length;
        }
        if (xVar.jCy == 2) {
            ab.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify datapush media dataid:%s, dir:%s", xVar.jCx, g.Fa(xVar.jCx));
            g.a(r2, xVar);
            cVar.recvSize += (long) xVar.jBi.wR.length;
            cVar.jtu.add(xVar.jCx);
        }
        ab.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", Long.valueOf(cVar.recvSize), Long.valueOf(cVar.jrb));
        if (cVar.jrb < cVar.recvSize) {
            cVar.jrb = cVar.recvSize;
        }
        a(xVar.jCx, xVar.jCy, xVar.jCA, xVar.jCB, 0, i);
        com.tencent.mm.plugin.backup.b.e aSu = b.aSZ().aSu();
        long j = cVar.recvSize;
        double d = 0.0d;
        if (aSu.jrb != 0) {
            d = (double) (((j - aSu.jra) * 100) / aSu.jrb);
        }
        aSu.jra = j;
        if (d < 0.5d) {
            i2 = 0;
        }
        if (i2 != 0) {
            cVar.rj(aSu.jqW);
        }
        AppMethodBeat.o(17280);
    }

    static /* synthetic */ void I(byte[] bArr, int i) {
        AppMethodBeat.i(17281);
        af afVar = (af) g.a(new af(), bArr);
        if (afVar == null) {
            ab.e("MicroMsg.BackupMoveRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", Integer.valueOf(bo.cc(bArr)));
            AppMethodBeat.o(17281);
            return;
        }
        ag agVar = new ag();
        agVar.jCP = afVar.jCP;
        agVar.jCR = afVar.jCR;
        agVar.jCQ = afVar.jCQ;
        agVar.jBt = afVar.jBt;
        try {
            ab.i("MicroMsg.BackupMoveRecoverServer", "send SvrID resp");
            b.r(agVar.toByteArray(), 14, i);
            AppMethodBeat.o(17281);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to PacketSvrIDResponse err.", new Object[0]);
            AppMethodBeat.o(17281);
        }
    }
}
