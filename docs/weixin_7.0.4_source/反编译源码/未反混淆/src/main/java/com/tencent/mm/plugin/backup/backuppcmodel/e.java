package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.b.c;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.i;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    private static boolean jsA = false;
    private static boolean jtX = false;
    static boolean jwu = false;
    private b jrE = new b() {
        public final void rj(final int i) {
            AppMethodBeat.i(17550);
            final HashSet hashSet = new HashSet();
            hashSet.addAll(e.this.jwm);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17548);
                    for (c rj : hashSet) {
                        rj.rj(i);
                    }
                    AppMethodBeat.o(17548);
                }
            });
            if (e.this.jwn != null) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(17549);
                        if (e.this.jwn != null) {
                            e.this.jwn.ri(i);
                        }
                        AppMethodBeat.o(17549);
                    }
                });
            }
            AppMethodBeat.o(17550);
        }

        public final void aSq() {
            AppMethodBeat.i(17551);
            h.pYm.a(400, 11, 1, false);
            h.pYm.a(400, 12, e.this.jtS == null ? 0 : bo.gb(e.this.jtS.jrH) / 1000, false);
            h.pYm.a(400, 13, e.this.jtS == null ? 0 : e.this.jtS.aSH(), false);
            e.this.rt(0);
            com.tencent.mm.plugin.backup.g.b.rx(11);
            if (!e.this.jwp) {
                e.this.rt(21);
            }
            AppMethodBeat.o(17551);
        }

        public final void aSr() {
            AppMethodBeat.i(17552);
            ab.i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", Boolean.FALSE);
            e.this.cancel(false);
            h.pYm.a(400, 120, 1, false);
            AppMethodBeat.o(17552);
        }
    };
    final f jtI = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17543);
            com.tencent.mm.plugin.backup.g.b.b(3, e.this.jtI);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", str);
                o oVar = ((k) mVar).jyg;
                if (b.aTD().jqO.equals(oVar.ID)) {
                    b.aTD().aSu().jrc = oVar.jBL;
                    ab.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", Long.valueOf(oVar.jBL));
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE);
                    com.tencent.mm.plugin.backup.g.b.aTU();
                    e.a(e.this);
                    AppMethodBeat.o(17543);
                    return;
                }
                ab.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
                h.pYm.a(400, 118, 1, false);
                b.aTD().aSu().jqW = -5;
                e.this.ru(-5);
                AppMethodBeat.o(17543);
                return;
            }
            ab.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            h.pYm.a(400, 117, 1, false);
            b.aTD().aSu().jqW = -5;
            e.this.ru(-5);
            AppMethodBeat.o(17543);
        }
    };
    LinkedList<String> jtQ;
    private com.tencent.mm.plugin.backup.c.b jtR;
    com.tencent.mm.plugin.backup.c.c jtS;
    private long jtT = 0;
    private long jtU = 0;
    public Set<c> jwm = new HashSet();
    public com.tencent.mm.plugin.backup.b.b.a jwn;
    private boolean jwp = false;
    public boolean jwv = false;
    public boolean jww = false;
    final f jwx = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17544);
            com.tencent.mm.plugin.backup.g.b.b(11, e.this.jwx);
            if (i == 0 && i2 == 0) {
                i iVar = (i) mVar;
                ab.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", Integer.valueOf(g.b(iVar.jxU.jBx, iVar.jxU.jBy).size()));
                com.tencent.mm.plugin.backup.c.c b = e.this.jtS;
                b.aTD().aTE();
                b.a(r0, b.aTD().aSu().jrc, e.jsA);
                AppMethodBeat.o(17544);
                return;
            }
            ab.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            h.pYm.a(400, 119, 1, false);
            e.this.cancel(false);
            b.aTD().aSu().jqW = -5;
            e.this.ru(-5);
            AppMethodBeat.o(17544);
        }
    };
    private final d jwy = new d() {
        public final void a(boolean z, int i, byte[] bArr, int i2) {
            AppMethodBeat.i(17546);
            String str = "MicroMsg.BackupPcServer";
            String str2 = "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr[4] = Boolean.valueOf(e.jwu);
            ab.i(str, str2, objArr);
            if (!z || bArr == null) {
                if (1 == b.aTD().aTE().jwa || 3 == b.aTD().aTE().jwa) {
                    if (i == 10) {
                        try {
                            new com.tencent.mm.plugin.backup.i.f().parseFrom(bArr);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.BackupPcServer", e, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
                        }
                        ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", Long.valueOf(r0.jxD));
                        AppMethodBeat.o(17546);
                        return;
                    } else if (i == 5) {
                        ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
                        e.this.cancel(true);
                        b.aTD().aSu().jqW = -100;
                        e.this.ru(-100);
                        h.pYm.a(400, 51, 1, false);
                        e.this.rt(5);
                        AppMethodBeat.o(17546);
                        return;
                    } else if (i == 18) {
                        com.tencent.mm.plugin.backup.i.c cVar = new com.tencent.mm.plugin.backup.i.c();
                        try {
                            cVar.parseFrom(bArr);
                        } catch (Exception e2) {
                            ab.printErrStackTrace("MicroMsg.BackupPcServer", e2, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
                        }
                        ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", Integer.valueOf(cVar.jBh));
                        if (cVar.jBh == 9) {
                            if (com.tencent.mm.plugin.backup.g.b.aUb() == 1) {
                                com.tencent.mm.plugin.backup.g.b.ry(2);
                                ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                                e.this.rt(20);
                                com.tencent.mm.plugin.backup.g.b.aUa();
                                b.aTD().aSu().jqW = 14;
                                e.this.ru(14);
                                com.tencent.mm.plugin.backup.g.b.a(new com.tencent.mm.plugin.backup.g.b.b() {
                                    public final void fo(boolean z) {
                                        AppMethodBeat.i(17545);
                                        if (z) {
                                            ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                                            com.tencent.mm.plugin.backup.g.b.ry(0);
                                            AppMethodBeat.o(17545);
                                            return;
                                        }
                                        e.this.ru(b.aTD().aSu().jqW);
                                        AppMethodBeat.o(17545);
                                    }
                                });
                                AppMethodBeat.o(17546);
                                return;
                            }
                            ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.g.b.aUb()));
                        }
                        AppMethodBeat.o(17546);
                        return;
                    } else if (i == 17) {
                        com.tencent.mm.plugin.backup.i.b bVar = new com.tencent.mm.plugin.backup.i.b();
                        try {
                            bVar.parseFrom(bArr);
                        } catch (Exception e22) {
                            ab.printErrStackTrace("MicroMsg.BackupPcServer", e22, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
                        }
                        ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", Integer.valueOf(bVar.jBh));
                        if (bVar.jBh == 10) {
                            int i3 = b.aTD().aSu().jqW;
                            ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i3));
                            if (i3 == 12 || i3 == 14) {
                                e.this.cancel(true);
                                b.aTD().aTa().stop();
                                b.aTD().aSu().jqW = -4;
                                e.this.ru(-4);
                                h.pYm.a(400, 51, 1, false);
                                e.this.rt(5);
                                long j = 0;
                                if (e.this.jtS.jrH != 0) {
                                    j = bo.gb(e.this.jtS.jrH);
                                }
                                h.pYm.e(13737, Integer.valueOf(3), Long.valueOf(e.this.jtS.aSH()), Long.valueOf(j / 1000), Integer.valueOf(1));
                                ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", Long.valueOf(e.this.jtS.aSH()), Long.valueOf(j / 1000));
                            }
                        }
                    }
                }
                AppMethodBeat.o(17546);
                return;
            }
            if (CdnLogic.kMediaTypeBeatificFile == i) {
                ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", Integer.valueOf(b.aTD().aSu().jqW));
                switch (b.aTD().aSu().jqW) {
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                    case -5:
                        b.aTD().aTa().stop();
                        AppMethodBeat.o(17546);
                        return;
                    case -4:
                        e.this.cancel(true);
                        break;
                    case 1:
                    case 11:
                        b.aTD().aTa().stop();
                        b.aTD().aSu().jqW = -100;
                        e.this.ru(-100);
                        AppMethodBeat.o(17546);
                        return;
                    case 4:
                    case 12:
                    case 14:
                        if (!b.aTD().aTE().jwe || e.jwu) {
                            ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
                            e.this.cancel(true);
                            b.aTD().aTa().stop();
                            b.aTD().aSu().jqW = -4;
                            e.this.ru(-4);
                            h.pYm.a(400, 9, 1, false);
                            e.this.rt(3);
                            AppMethodBeat.o(17546);
                            return;
                        }
                        switch (com.tencent.mm.plugin.backup.g.b.aUb()) {
                            case 0:
                            case 2:
                                ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.g.b.aUb()));
                                e.this.rt(19);
                                e.this.jwp = true;
                                com.tencent.mm.plugin.backup.g.b.a(b.aTD().aTE().jwj);
                                AppMethodBeat.o(17546);
                                return;
                            case 1:
                                ab.i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", Integer.valueOf(com.tencent.mm.plugin.backup.g.b.aUb()));
                                break;
                        }
                        AppMethodBeat.o(17546);
                        return;
                    case 15:
                        b.aTD().aTa().stop();
                        b.aTD().aSu().jqW = -100;
                        e.this.ru(-100);
                        AppMethodBeat.o(17546);
                        return;
                }
            }
            AppMethodBeat.o(17546);
        }
    };

    public e() {
        AppMethodBeat.i(17553);
        AppMethodBeat.o(17553);
    }

    public static void aTN() {
        jwu = true;
    }

    public final void init() {
        AppMethodBeat.i(17554);
        ab.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
        jwu = false;
        this.jwp = false;
        com.tencent.mm.plugin.backup.g.b.a(this.jwy);
        this.jtS = new com.tencent.mm.plugin.backup.c.c(b.aTD(), 1, this.jrE);
        AppMethodBeat.o(17554);
    }

    public final void cancel(boolean z) {
        AppMethodBeat.i(17555);
        ab.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", Boolean.valueOf(z), an.doQ());
        jwu = true;
        if (!z) {
            b.aTD().aTE();
            c.aTj();
        }
        this.jtS.cancel();
        if (this.jtR != null) {
            this.jtR.cancel();
            this.jtR = null;
        }
        com.tencent.mm.plugin.backup.g.b.aTV();
        com.tencent.mm.plugin.backup.g.b.aTX();
        com.tencent.mm.plugin.backup.g.b.aUa();
        AppMethodBeat.o(17555);
    }

    public final void G(LinkedList<String> linkedList) {
        AppMethodBeat.i(17556);
        this.jtQ = linkedList;
        b.aTD();
        if (com.tencent.mm.plugin.backup.b.d.aSz().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            jtX = true;
        } else {
            jtX = false;
        }
        b.aTD();
        this.jtT = com.tencent.mm.plugin.backup.b.d.aSz().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
        b.aTD();
        this.jtU = com.tencent.mm.plugin.backup.b.d.aSz().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        b.aTD();
        if (com.tencent.mm.plugin.backup.b.d.aSz().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
            jsA = true;
        } else {
            jsA = false;
        }
        String str = "MicroMsg.BackupPcServer";
        String str2 = "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Boolean.valueOf(jtX);
        objArr[2] = Boolean.valueOf(jsA);
        objArr[3] = Long.valueOf(this.jtT);
        objArr[4] = Long.valueOf(this.jtU);
        ab.i(str, str2, objArr);
        aw.ZK();
        com.tencent.mm.model.c.Ry().set(a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.TRUE);
        if (1 == b.aTD().aTE().jwa) {
            b.aTD();
            Editor edit = com.tencent.mm.plugin.backup.b.d.aSz().edit();
            edit.putString("BACKUP_PC_CHOOSE_SESSION", g.a("", ",", linkedList == null ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()])));
            edit.commit();
        }
        AppMethodBeat.o(17556);
    }

    public static void e(int i, long j, long j2, int i2) {
        AppMethodBeat.i(17557);
        ab.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2));
        if (i == 0) {
            j2 = 0;
            j = 0;
        }
        b.aTD();
        Editor edit = com.tencent.mm.plugin.backup.b.d.aSz().edit();
        if (1 == b.aTD().aTE().jwa) {
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", i);
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", i2);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", j);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", j2);
        }
        edit.commit();
        AppMethodBeat.o(17557);
    }

    public final void gx(long j) {
        int i = 3;
        AppMethodBeat.i(17558);
        ab.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
        com.tencent.mm.plugin.backup.g.b.a(3, this.jtI);
        k kVar = new k(b.aTD().jqO);
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        aw.ZK();
        g.a(pLong, pLong2, com.tencent.mm.model.c.getAccPath());
        if (!jsA) {
            aw.ZK();
            if (((Boolean) com.tencent.mm.model.c.Ry().get(a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                i = 0;
            } else {
                i = 1;
            }
        }
        kVar.a(j, g.gw(pLong2.value), i);
        ab.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", Long.valueOf(j), Integer.valueOf(i));
        kVar.aUc();
        AppMethodBeat.o(17558);
    }

    public final void rt(int i) {
        long aSH;
        long j;
        long j2 = 0;
        AppMethodBeat.i(17559);
        if (this.jtS != null) {
            if (this.jtS.jrH != 0) {
                j2 = bo.gb(this.jtS.jrH);
            }
            aSH = this.jtS.aSH();
            j = j2;
        } else {
            aSH = 0;
            j = 0;
        }
        h.pYm.e(13737, Integer.valueOf(i), Long.valueOf(aSH), Long.valueOf(j / 1000), Integer.valueOf(1), Integer.valueOf(b.aTD().aTE().jwg));
        ab.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(aSH), Long.valueOf(j / 1000));
        AppMethodBeat.o(17559);
    }

    public final void aSs() {
        AppMethodBeat.i(17560);
        final HashSet hashSet = new HashSet();
        hashSet.addAll(this.jwm);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17547);
                for (c aSs : hashSet) {
                    aSs.aSs();
                }
                AppMethodBeat.o(17547);
            }
        });
        AppMethodBeat.o(17560);
    }

    public final void ru(int i) {
        AppMethodBeat.i(17561);
        this.jrE.rj(i);
        AppMethodBeat.o(17561);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(17562);
        com.tencent.mm.plugin.backup.g.b.a(11, eVar.jwx);
        i iVar = new i(eVar.jtQ, eVar.jtT, eVar.jtU);
        ab.i("MicroMsg.BackupPcServer", "backupPcSendRequestSession, chooseConvNames size[%d]", Integer.valueOf(eVar.jtQ.size()));
        iVar.aUc();
        AppMethodBeat.o(17562);
    }
}
