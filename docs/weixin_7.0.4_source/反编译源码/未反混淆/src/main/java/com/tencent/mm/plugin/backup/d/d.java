package com.tencent.mm.plugin.backup.d;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b.c;
import com.tencent.mm.plugin.backup.g.j.a;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.plugin.backup.i.f;
import com.tencent.mm.plugin.backup.i.i;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.backup.i.v;
import com.tencent.mm.plugin.backup.i.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class d implements b, com.tencent.mm.plugin.backup.g.b.d {
    public static boolean jsA = false;
    public static boolean jtX = false;
    public byte[] bitmapData;
    public com.tencent.mm.plugin.backup.b.b.d jsv;
    public c jtL = new c() {
        public final void aTm() {
            AppMethodBeat.i(17285);
            ab.i("MicroMsg.BackupMoveServer", "stopCallback ");
            com.tencent.mm.plugin.backup.g.b.aTV();
            b.aSZ().aSw();
            AppMethodBeat.o(17285);
        }
    };
    public final a jtM = new a() {
        public final void aTn() {
            AppMethodBeat.i(17286);
            d.this.rj(b.aSZ().aSu().jqW);
            AppMethodBeat.o(17286);
        }

        public final void ro(int i) {
            AppMethodBeat.i(17287);
            int i2 = b.aSZ().aSu().jqW;
            if (i == 1) {
                if (i2 == 14) {
                    ab.i("MicroMsg.BackupMoveServer", "speedCallback is weak connect now.");
                    b.aSZ().aSu().jqW = 4;
                    d.this.rj(4);
                    AppMethodBeat.o(17287);
                    return;
                }
            } else if (i == 0 && i2 == 4) {
                ab.i("MicroMsg.BackupMoveServer", "speedCallback is normal speed now.");
                b.aSZ().aSu().jqW = 14;
                d.this.rj(14);
            }
            AppMethodBeat.o(17287);
        }

        public final void aTo() {
            AppMethodBeat.i(17288);
            int i = b.aSZ().aSu().jqW;
            ab.e("MicroMsg.BackupMoveServer", "speedOverTime callback, backupState[%d]", Integer.valueOf(i));
            if (i == 14 || i == 4) {
                d.this.cancel(true);
                b.aSZ().aTa().stop();
                b.aSZ().aSu().jqW = -4;
                d.this.rj(-4);
            }
            AppMethodBeat.o(17288);
        }
    };
    public LinkedList<String> jtQ;
    private com.tencent.mm.plugin.backup.c.b jtR;
    private com.tencent.mm.plugin.backup.c.c jtS;
    public long jtT = 0;
    public long jtU = 0;
    public boolean jtV = false;
    public int jtW = 0;
    private int jtY;
    private int jtZ;
    public boolean jtw = false;
    private int jua = 0;
    public e jub = new e(new e.a() {
        public final void k(int i, byte[] bArr) {
            AppMethodBeat.i(17289);
            if (bArr != null) {
                d.this.bitmapData = bArr;
            }
            d.this.rj(i);
            AppMethodBeat.o(17289);
        }
    }, b.aSZ().aSu());

    public d() {
        AppMethodBeat.i(17290);
        AppMethodBeat.o(17290);
    }

    public final void cancel(boolean z) {
        AppMethodBeat.i(17291);
        ab.e("MicroMsg.BackupMoveServer", "summerbak BackupMoveServer CANCEL, Caller:%s", an.doQ());
        if (!z) {
            aTj();
        }
        if (this.jtS != null) {
            this.jtS.cancel();
        }
        if (this.jtR != null) {
            this.jtR.cancel();
            this.jtR = null;
        }
        ab.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
        com.tencent.mm.plugin.backup.g.b.aTV();
        com.tencent.mm.plugin.backup.g.b.aTX();
        AppMethodBeat.o(17291);
    }

    public static void d(int i, long j, long j2, int i2) {
        AppMethodBeat.i(17292);
        ab.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2));
        if (i == 0) {
            j2 = 0;
            j = 0;
        }
        b.aSZ();
        Editor edit = com.tencent.mm.plugin.backup.b.d.aSz().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", i);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", j);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", j2);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", i2);
        edit.commit();
        AppMethodBeat.o(17292);
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        AppMethodBeat.i(17293);
        String str = "MicroMsg.BackupMoveServer";
        String str2 = "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        ab.i(str, str2, objArr);
        if (z && bArr != null && CdnLogic.kMediaTypeBeatificFile == i) {
            ab.i("MicroMsg.BackupMoveServer", "summerbak local disconnect, backupMoveState:%d", Integer.valueOf(b.aSZ().aSu().jqW));
            switch (b.aSZ().aSu().jqW) {
                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -5:
                    b.aSZ().aTa().stop();
                    break;
                case -4:
                    cancel(true);
                    break;
                case 1:
                    b.aSZ().aTa().stop();
                    b.aSZ().aSu().jqW = -100;
                    rj(-100);
                    break;
                case 12:
                case 14:
                    cancel(true);
                    b.aSZ().aTa().stop();
                    b.aSZ().aSu().jqW = -4;
                    rj(-4);
                    h.pYm.a(485, 24, 1, false);
                    if (!(this.jtS == null || this.jtS.jrH == 0)) {
                        long gb = bo.gb(this.jtS.jrH);
                        ab.i("MicroMsg.BackupMoveServer", "onNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", Long.valueOf(this.jtS.aSH()), Long.valueOf(gb / 1000));
                        break;
                    }
            }
        }
        if (i == 1) {
            v vVar = (v) g.a(new v(), bArr);
            if (vVar == null) {
                ab.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", Integer.valueOf(bo.cc(bArr)));
                b.aSZ().aSu().jqW = -5;
                rj(-5);
                AppMethodBeat.o(17293);
                return;
            }
            if (bo.isNullOrNil(b.aSZ().jqO)) {
                b.aSZ().jqO = vVar.ID;
            }
            if (vVar.ID.equals(b.aSZ().jqO)) {
                ab.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", vVar.ID, Integer.valueOf(vVar.jCs));
                if (vVar.jCs == 0) {
                    if (!b.aSZ().jqP.equals(new String(l.c(vVar.jBi.wR, com.tencent.mm.plugin.backup.b.d.aSy())))) {
                        w wVar = new w();
                        wVar.jCs = 0;
                        wVar.ID = b.aSZ().jqO;
                        wVar.jBT = 1;
                        ab.e("MicroMsg.BackupMoveServer", "get authReq step 0, but hello failed");
                        try {
                            ab.i("MicroMsg.BackupMoveServer", "summerbak send authFailResp.");
                            com.tencent.mm.plugin.backup.g.b.r(wVar.toByteArray(), 2, i2);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
                        }
                        b.aSZ().aSu().jqW = -5;
                        rj(-5);
                    }
                    if (vVar.Version < com.tencent.mm.plugin.backup.b.c.jqG) {
                        ab.i("MicroMsg.BackupMoveServer", "summerbak old move, version:%d", Integer.valueOf(vVar.Version));
                        h.pYm.a(485, 103, 1, false);
                        b.aSZ().aSu().jqW = -12;
                        rj(-12);
                        AppMethodBeat.o(17293);
                        return;
                    }
                    ab.i("MicroMsg.BackupMoveServer", "summerbak start move");
                    this.jtZ = i2;
                    if (jtX || jsA) {
                        if (jtX && jsA && (vVar.jCu & com.tencent.mm.plugin.backup.b.c.jqL) == 0 && (vVar.jCu & com.tencent.mm.plugin.backup.b.c.jqM) == 0) {
                            b.aSZ().aSu().jqW = -31;
                            rj(-31);
                            this.jua = 1;
                            AppMethodBeat.o(17293);
                            return;
                        } else if (jtX && (vVar.jCu & com.tencent.mm.plugin.backup.b.c.jqL) == 0) {
                            b.aSZ().aSu().jqW = -32;
                            rj(-32);
                            this.jua = 2;
                            AppMethodBeat.o(17293);
                            return;
                        } else if (jsA && (vVar.jCu & com.tencent.mm.plugin.backup.b.c.jqM) == 0) {
                            b.aSZ().aSu().jqW = -33;
                            rj(-33);
                            this.jua = 3;
                            AppMethodBeat.o(17293);
                            return;
                        }
                    }
                    fl(false);
                    AppMethodBeat.o(17293);
                    return;
                }
                if (vVar.jCs == 1) {
                    if (!b.aSZ().jqQ.equals(new String(l.c(vVar.jBi.wR, com.tencent.mm.plugin.backup.b.d.aSy())))) {
                        ab.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                        b.aSZ().aSu().jqW = -5;
                        rj(-5);
                    }
                    ab.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
                    b.aSZ().aSu().jqW = 2;
                    rj(2);
                }
                AppMethodBeat.o(17293);
                return;
            }
            ab.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", b.aSZ().jqO, vVar.ID);
            cancel(false);
            b.aSZ().aSu().jqW = -5;
            rj(-5);
            AppMethodBeat.o(17293);
        } else if (i == 3) {
            this.jtY = i2;
            if (b.aSZ().aTd().jsZ) {
                aTp();
                AppMethodBeat.o(17293);
                return;
            }
            this.jtV = true;
            AppMethodBeat.o(17293);
        } else if (i == 9) {
            e eVar = (e) g.a(new e(), bArr);
            if (eVar == null) {
                ab.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", Integer.valueOf(bo.cc(bArr)));
                AppMethodBeat.o(17293);
                return;
            }
            ab.i("MicroMsg.BackupMoveServer", "summerbak receive heartbeatReq,req:%s ack:%d", eVar, Long.valueOf(eVar.jxD));
            f fVar = (f) g.a(new f(), bArr);
            fVar.jxD = eVar.jxD;
            try {
                ab.i("MicroMsg.BackupMoveServer", "summerbak send heartbeatResp");
                com.tencent.mm.plugin.backup.g.b.r(fVar.toByteArray(), 10, i2);
                AppMethodBeat.o(17293);
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
                AppMethodBeat.o(17293);
            }
        } else if (i == 10) {
            try {
                new f().parseFrom(bArr);
                AppMethodBeat.o(17293);
            } catch (Exception e22) {
                ab.printErrStackTrace("MicroMsg.BackupMoveServer", e22, "summerbak heartbeatResp parse from buf error.", new Object[0]);
                AppMethodBeat.o(17293);
            }
        } else if (i == 5) {
            ab.i("MicroMsg.BackupMoveServer", "summerbak receive command cancel");
            cancel(true);
            b.aSZ().aSu().jqW = -100;
            rj(-100);
            AppMethodBeat.o(17293);
        } else {
            if (i == 12) {
                j jVar = (j) g.a(new j(), bArr);
                if (jVar == null) {
                    ab.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", Integer.valueOf(bo.cc(bArr)));
                    b.aSZ().aSu().jqW = -5;
                    rj(-5);
                    AppMethodBeat.o(17293);
                    return;
                }
                int i3;
                LinkedList b = g.b(jVar.jBx, jVar.jBy);
                str2 = "MicroMsg.BackupMoveServer";
                String str3 = "summerbak backup receive requestsession response. backupSessionList:%d ";
                Object[] objArr2 = new Object[1];
                if (b == null) {
                    i3 = -1;
                } else {
                    i3 = b.size();
                }
                objArr2[0] = Integer.valueOf(i3);
                ab.i(str2, str3, objArr2);
                if (b == null) {
                    ab.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
                    aTj();
                    b.aSZ().aSu().jqW = -21;
                    rj(-21);
                    AppMethodBeat.o(17293);
                    return;
                }
                com.tencent.mm.plugin.backup.g.b.aTU();
                this.jtS = new com.tencent.mm.plugin.backup.c.c(b.aSZ(), 2, this);
                this.jtS.fj(false);
                this.jtS.a(b, b.aSZ().aSu().jrc, jsA);
            }
            AppMethodBeat.o(17293);
        }
    }

    public final void fl(boolean z) {
        AppMethodBeat.i(17294);
        if (z) {
            switch (this.jua) {
                case 1:
                    jtX = false;
                    jsA = false;
                    this.jtT = 0;
                    this.jtU = 0;
                    break;
                case 2:
                    jtX = false;
                    this.jtT = 0;
                    this.jtU = 0;
                    break;
                case 3:
                    jsA = false;
                    break;
            }
        }
        w wVar = new w();
        wVar.jCs = 0;
        wVar.ID = b.aSZ().jqO;
        wVar.Version = com.tencent.mm.plugin.backup.b.c.jqG;
        wVar.jBT = 0;
        wVar.jCt = this.jtW;
        wVar.jBi = new com.tencent.mm.bt.b(l.d(b.aSZ().jqQ.getBytes(), com.tencent.mm.plugin.backup.b.d.aSy()));
        if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
            wVar.jCu |= com.tencent.mm.plugin.backup.b.c.jqK;
        }
        wVar.jCu |= com.tencent.mm.plugin.backup.b.c.jqL;
        wVar.jCu |= com.tencent.mm.plugin.backup.b.c.jqM;
        try {
            ab.i("MicroMsg.BackupMoveServer", "summerbak send authSuccessResp.");
            com.tencent.mm.plugin.backup.g.b.r(wVar.toByteArray(), 2, this.jtZ);
            AppMethodBeat.o(17294);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
            AppMethodBeat.o(17294);
        }
    }

    public final void aTp() {
        AppMethodBeat.i(17295);
        ab.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
        this.jtV = false;
        b.aSZ().aSu().jqW = 12;
        rj(12);
        com.tencent.mm.plugin.backup.h.d.aUr().aUu();
        if (this.jtQ == null) {
            AppMethodBeat.o(17295);
            return;
        }
        ab.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", Integer.valueOf(this.jtQ.size()));
        o oVar = new o();
        oVar.ID = b.aSZ().jqO;
        oVar.jBR = (long) this.jtQ.size();
        oVar.jBS = b.aSZ().aTd().aSY();
        oVar.jBT = 0;
        oVar.jBU = this.jtw ? com.tencent.mm.plugin.backup.b.c.jqF : com.tencent.mm.plugin.backup.b.c.jqE;
        if (jsA) {
            oVar.jBQ = 3;
        }
        m mVar = new m();
        mVar.jBE = q.LM();
        mVar.jBF = Build.MANUFACTURER;
        mVar.jBG = Build.MODEL;
        mVar.jBH = "Android";
        mVar.jBI = VERSION.RELEASE;
        mVar.jBJ = com.tencent.mm.protocal.d.vxo;
        mVar.jBK = 0;
        ab.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", Integer.valueOf(com.tencent.mm.protocal.d.vxo));
        oVar.jBO = mVar;
        try {
            com.tencent.mm.plugin.backup.g.b.r(oVar.toByteArray(), 4, this.jtY);
            A(this.jtT, this.jtU);
            AppMethodBeat.o(17295);
        } catch (IOException e) {
            ab.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
            ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "", new Object[0]);
            AppMethodBeat.o(17295);
        }
    }

    private void A(long j, long j2) {
        AppMethodBeat.i(17296);
        ab.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", Integer.valueOf(this.jtQ.size()), Long.valueOf(j), Long.valueOf(j2));
        i iVar = new i();
        iVar.jBx = this.jtQ;
        iVar.jBy = new LinkedList();
        Iterator it = this.jtQ.iterator();
        while (it.hasNext()) {
            it.next();
            iVar.jBy.add(Long.valueOf(j));
            iVar.jBy.add(Long.valueOf(j2));
        }
        try {
            ab.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", Integer.valueOf(this.jtQ.size()));
            com.tencent.mm.plugin.backup.g.b.K(iVar.toByteArray(), 11);
            AppMethodBeat.o(17296);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
            AppMethodBeat.o(17296);
        }
    }

    private static void aTj() {
        AppMethodBeat.i(17297);
        com.tencent.mm.plugin.backup.i.a aVar = new com.tencent.mm.plugin.backup.i.a();
        aVar.ID = b.aSZ().jqO;
        try {
            ab.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
            com.tencent.mm.plugin.backup.g.b.K(aVar.toByteArray(), 5);
            AppMethodBeat.o(17297);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to BackupCancelRequest err.", new Object[0]);
            AppMethodBeat.o(17297);
        }
    }

    public static String aTq() {
        AppMethodBeat.i(17298);
        String aTY = com.tencent.mm.plugin.backup.g.b.aTY();
        AppMethodBeat.o(17298);
        return aTY;
    }

    public final void rj(final int i) {
        AppMethodBeat.i(17299);
        if (this.jsv != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17284);
                    if (d.this.jsv != null) {
                        d.this.jsv.rj(i);
                    }
                    AppMethodBeat.o(17284);
                }
            });
        }
        AppMethodBeat.o(17299);
    }

    public final void aSq() {
        AppMethodBeat.i(17300);
        com.tencent.mm.plugin.backup.g.b.rx(21);
        AppMethodBeat.o(17300);
    }

    public final void aSr() {
        AppMethodBeat.i(17301);
        cancel(false);
        AppMethodBeat.o(17301);
    }
}
