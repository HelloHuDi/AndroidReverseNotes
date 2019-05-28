package com.tencent.p177mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences.Editor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19936a;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C19938c;
import com.tencent.p177mm.plugin.backup.p342b.C19937b.C2600b;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p344c.C33685b;
import com.tencent.p177mm.plugin.backup.p344c.C33688c;
import com.tencent.p177mm.plugin.backup.p920g.C11151i;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19976b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19977d;
import com.tencent.p177mm.plugin.backup.p920g.C38655k;
import com.tencent.p177mm.plugin.backup.p921i.C11154f;
import com.tencent.p177mm.plugin.backup.p921i.C19992o;
import com.tencent.p177mm.plugin.backup.p921i.C33709c;
import com.tencent.p177mm.plugin.backup.p921i.C38661b;
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

/* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.e */
public final class C42760e {
    private static boolean jsA = false;
    private static boolean jtX = false;
    static boolean jwu = false;
    private C2600b jrE = new C110995();
    final C1202f jtI = new C386401();
    LinkedList<String> jtQ;
    private C33685b jtR;
    C33688c jtS;
    private long jtT = 0;
    private long jtU = 0;
    public Set<C19938c> jwm = new HashSet();
    public C19936a jwn;
    private boolean jwp = false;
    public boolean jwv = false;
    public boolean jww = false;
    final C1202f jwx = new C427612();
    private final C19977d jwy = new C336673();

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.e$5 */
    class C110995 implements C2600b {
        C110995() {
        }

        /* renamed from: rj */
        public final void mo6651rj(final int i) {
            AppMethodBeat.m2504i(17550);
            final HashSet hashSet = new HashSet();
            hashSet.addAll(C42760e.this.jwm);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(17548);
                    for (C19938c rj : hashSet) {
                        rj.mo6681rj(i);
                    }
                    AppMethodBeat.m2505o(17548);
                }
            });
            if (C42760e.this.jwn != null) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(17549);
                        if (C42760e.this.jwn != null) {
                            C42760e.this.jwn.mo35185ri(i);
                        }
                        AppMethodBeat.m2505o(17549);
                    }
                });
            }
            AppMethodBeat.m2505o(17550);
        }

        public final void aSq() {
            AppMethodBeat.m2504i(17551);
            C7060h.pYm.mo8378a(400, 11, 1, false);
            C7060h.pYm.mo8378a(400, 12, C42760e.this.jtS == null ? 0 : C5046bo.m7566gb(C42760e.this.jtS.jrH) / 1000, false);
            C7060h.pYm.mo8378a(400, 13, C42760e.this.jtS == null ? 0 : C42760e.this.jtS.aSH(), false);
            C42760e.this.mo68235rt(0);
            C19978b.m30891rx(11);
            if (!C42760e.this.jwp) {
                C42760e.this.mo68235rt(21);
            }
            AppMethodBeat.m2505o(17551);
        }

        public final void aSr() {
            AppMethodBeat.m2504i(17552);
            C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPackAndSendCallback onCancel, isSelf[%b]", Boolean.FALSE);
            C42760e.this.cancel(false);
            C7060h.pYm.mo8378a(400, 120, 1, false);
            AppMethodBeat.m2505o(17552);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.e$3 */
    class C336673 implements C19977d {

        /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.e$3$1 */
        class C336681 implements C19976b {
            C336681() {
            }

            /* renamed from: fo */
            public final void mo35224fo(boolean z) {
                AppMethodBeat.m2504i(17545);
                if (z) {
                    C4990ab.m7416i("MicroMsg.BackupPcServer", "onBackupPcServerNotify resendSceneMap finish");
                    C19978b.m30892ry(0);
                    AppMethodBeat.m2505o(17545);
                    return;
                }
                C42760e.this.mo68236ru(C42759b.aTD().aSu().jqW);
                AppMethodBeat.m2505o(17545);
            }
        }

        C336673() {
        }

        /* renamed from: a */
        public final void mo6669a(boolean z, int i, byte[] bArr, int i2) {
            AppMethodBeat.m2504i(17546);
            String str = "MicroMsg.BackupPcServer";
            String str2 = "onBackupPcServerNotify isLocal[%b], type[%d], seq[%d], buf[%d], isBackupFinish[%b]";
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr[4] = Boolean.valueOf(C42760e.jwu);
            C4990ab.m7417i(str, str2, objArr);
            if (!z || bArr == null) {
                if (1 == C42759b.aTD().aTE().jwa || 3 == C42759b.aTD().aTE().jwa) {
                    if (i == 10) {
                        try {
                            new C11154f().parseFrom(bArr);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.BackupPcServer", e, "onBackupPcServerNotify buf to BackupHeartBeatResponse error.", new Object[0]);
                        }
                        C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive heartbeatResp, ack[%d]", Long.valueOf(r0.jxD));
                        AppMethodBeat.m2505o(17546);
                        return;
                    } else if (i == 5) {
                        C4990ab.m7416i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive cancelReq");
                        C42760e.this.cancel(true);
                        C42759b.aTD().aSu().jqW = -100;
                        C42760e.this.mo68236ru(-100);
                        C7060h.pYm.mo8378a(400, 51, 1, false);
                        C42760e.this.mo68235rt(5);
                        AppMethodBeat.m2505o(17546);
                        return;
                    } else if (i == 18) {
                        C33709c c33709c = new C33709c();
                        try {
                            c33709c.parseFrom(bArr);
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.BackupPcServer", e2, "onBackupPcServerNotify buf to BackupCommandResponse error.", new Object[0]);
                        }
                        C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandResp, cmd[%d]", Integer.valueOf(c33709c.jBh));
                        if (c33709c.jBh == 9) {
                            if (C19978b.aUb() == 1) {
                                C19978b.m30892ry(2);
                                C4990ab.m7416i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect success, start resendSceneMap");
                                C42760e.this.mo68235rt(20);
                                C19978b.aUa();
                                C42759b.aTD().aSu().jqW = 14;
                                C42760e.this.mo68236ru(14);
                                C19978b.m30881a(new C336681());
                                AppMethodBeat.m2505o(17546);
                                return;
                            }
                            C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPcServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(C19978b.aUb()));
                        }
                        AppMethodBeat.m2505o(17546);
                        return;
                    } else if (i == 17) {
                        C38661b c38661b = new C38661b();
                        try {
                            c38661b.parseFrom(bArr);
                        } catch (Exception e22) {
                            C4990ab.printErrStackTrace("MicroMsg.BackupPcServer", e22, "onBackupPcServerNotify buf to BackupCommandRequest error.", new Object[0]);
                        }
                        C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPcServerNotify receive commandReq, cmd[%d]", Integer.valueOf(c38661b.jBh));
                        if (c38661b.jBh == 10) {
                            int i3 = C42759b.aTD().aSu().jqW;
                            C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPcServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i3));
                            if (i3 == 12 || i3 == 14) {
                                C42760e.this.cancel(true);
                                C42759b.aTD().aTa().stop();
                                C42759b.aTD().aSu().jqW = -4;
                                C42760e.this.mo68236ru(-4);
                                C7060h.pYm.mo8378a(400, 51, 1, false);
                                C42760e.this.mo68235rt(5);
                                long j = 0;
                                if (C42760e.this.jtS.jrH != 0) {
                                    j = C5046bo.m7566gb(C42760e.this.jtS.jrH);
                                }
                                C7060h.pYm.mo8381e(13737, Integer.valueOf(3), Long.valueOf(C42760e.this.jtS.aSH()), Long.valueOf(j / 1000), Integer.valueOf(1));
                                C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPcServerNotify transfer disconnect, backupDataSize[%d kb], backupCostTime[%d s]", Long.valueOf(C42760e.this.jtS.aSH()), Long.valueOf(j / 1000));
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(17546);
                return;
            }
            if (CdnLogic.kMediaTypeBeatificFile == i) {
                C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPcServerNotify local disconnect, backupPcState[%d]", Integer.valueOf(C42759b.aTD().aSu().jqW));
                switch (C42759b.aTD().aSu().jqW) {
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                    case -5:
                        C42759b.aTD().aTa().stop();
                        AppMethodBeat.m2505o(17546);
                        return;
                    case -4:
                        C42760e.this.cancel(true);
                        break;
                    case 1:
                    case 11:
                        C42759b.aTD().aTa().stop();
                        C42759b.aTD().aSu().jqW = -100;
                        C42760e.this.mo68236ru(-100);
                        AppMethodBeat.m2505o(17546);
                        return;
                    case 4:
                    case 12:
                    case 14:
                        if (!C42759b.aTD().aTE().jwe || C42760e.jwu) {
                            C4990ab.m7416i("MicroMsg.BackupPcServer", "onBackupPcServerNotify not support reconnect, disconnect");
                            C42760e.this.cancel(true);
                            C42759b.aTD().aTa().stop();
                            C42759b.aTD().aSu().jqW = -4;
                            C42760e.this.mo68236ru(-4);
                            C7060h.pYm.mo8378a(400, 9, 1, false);
                            C42760e.this.mo68235rt(3);
                            AppMethodBeat.m2505o(17546);
                            return;
                        }
                        switch (C19978b.aUb()) {
                            case 0:
                            case 2:
                                C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPcServerNotify startBackupReconnectHandler, reconnectState[%d]", Integer.valueOf(C19978b.aUb()));
                                C42760e.this.mo68235rt(19);
                                C42760e.this.jwp = true;
                                C19978b.m30884a(C42759b.aTD().aTE().jwj);
                                AppMethodBeat.m2505o(17546);
                                return;
                            case 1:
                                C4990ab.m7417i("MicroMsg.BackupPcServer", "onBackupPcServerNotify already start reconnect, state[%d]", Integer.valueOf(C19978b.aUb()));
                                break;
                        }
                        AppMethodBeat.m2505o(17546);
                        return;
                    case 15:
                        C42759b.aTD().aTa().stop();
                        C42759b.aTD().aSu().jqW = -100;
                        C42760e.this.mo68236ru(-100);
                        AppMethodBeat.m2505o(17546);
                        return;
                }
            }
            AppMethodBeat.m2505o(17546);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.e$1 */
    class C386401 implements C1202f {
        C386401() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17543);
            C19978b.m30886b(3, C42760e.this.jtI);
            if (i == 0 && i2 == 0) {
                C4990ab.m7417i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", str);
                C19992o c19992o = ((C38655k) c1207m).jyg;
                if (C42759b.aTD().jqO.equals(c19992o.f4367ID)) {
                    C42759b.aTD().aSu().jrc = c19992o.jBL;
                    C4990ab.m7417i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", Long.valueOf(c19992o.jBL));
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE);
                    C19978b.aTU();
                    C42760e.m75807a(C42760e.this);
                    AppMethodBeat.m2505o(17543);
                    return;
                }
                C4990ab.m7412e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
                C7060h.pYm.mo8378a(400, 118, 1, false);
                C42759b.aTD().aSu().jqW = -5;
                C42760e.this.mo68236ru(-5);
                AppMethodBeat.m2505o(17543);
                return;
            }
            C4990ab.m7413e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            C7060h.pYm.mo8378a(400, 117, 1, false);
            C42759b.aTD().aSu().jqW = -5;
            C42760e.this.mo68236ru(-5);
            AppMethodBeat.m2505o(17543);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.e$2 */
    class C427612 implements C1202f {
        C427612() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17544);
            C19978b.m30886b(11, C42760e.this.jwx);
            if (i == 0 && i2 == 0) {
                C11151i c11151i = (C11151i) c1207m;
                C4990ab.m7417i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", Integer.valueOf(C38635g.m65517b(c11151i.jxU.jBx, c11151i.jxU.jBy).size()));
                C33688c b = C42760e.this.jtS;
                C42759b.aTD().aTE();
                b.mo54240a(r0, C42759b.aTD().aSu().jrc, C42760e.jsA);
                AppMethodBeat.m2505o(17544);
                return;
            }
            C4990ab.m7413e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            C7060h.pYm.mo8378a(400, 119, 1, false);
            C42760e.this.cancel(false);
            C42759b.aTD().aSu().jqW = -5;
            C42760e.this.mo68236ru(-5);
            AppMethodBeat.m2505o(17544);
        }
    }

    public C42760e() {
        AppMethodBeat.m2504i(17553);
        AppMethodBeat.m2505o(17553);
    }

    public static void aTN() {
        jwu = true;
    }

    public final void init() {
        AppMethodBeat.m2504i(17554);
        C4990ab.m7416i("MicroMsg.BackupPcServer", "BackupPcServer init.");
        jwu = false;
        this.jwp = false;
        C19978b.m30883a(this.jwy);
        this.jtS = new C33688c(C42759b.aTD(), 1, this.jrE);
        AppMethodBeat.m2505o(17554);
    }

    public final void cancel(boolean z) {
        AppMethodBeat.m2504i(17555);
        C4990ab.m7417i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", Boolean.valueOf(z), C5007an.doQ());
        jwu = true;
        if (!z) {
            C42759b.aTD().aTE();
            C45736c.aTj();
        }
        this.jtS.cancel();
        if (this.jtR != null) {
            this.jtR.cancel();
            this.jtR = null;
        }
        C19978b.aTV();
        C19978b.aTX();
        C19978b.aUa();
        AppMethodBeat.m2505o(17555);
    }

    /* renamed from: G */
    public final void mo68230G(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(17556);
        this.jtQ = linkedList;
        C42759b.aTD();
        if (C38634d.aSz().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            jtX = true;
        } else {
            jtX = false;
        }
        C42759b.aTD();
        this.jtT = C38634d.aSz().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
        C42759b.aTD();
        this.jtU = C38634d.aSz().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        C42759b.aTD();
        if (C38634d.aSz().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
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
        C4990ab.m7417i(str, str2, objArr);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(C5127a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.TRUE);
        if (1 == C42759b.aTD().aTE().jwa) {
            C42759b.aTD();
            Editor edit = C38634d.aSz().edit();
            edit.putString("BACKUP_PC_CHOOSE_SESSION", C38635g.m65513a("", ",", linkedList == null ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()])));
            edit.commit();
        }
        AppMethodBeat.m2505o(17556);
    }

    /* renamed from: e */
    public static void m75812e(int i, long j, long j2, int i2) {
        AppMethodBeat.m2504i(17557);
        C4990ab.m7417i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2));
        if (i == 0) {
            j2 = 0;
            j = 0;
        }
        C42759b.aTD();
        Editor edit = C38634d.aSz().edit();
        if (1 == C42759b.aTD().aTE().jwa) {
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", i);
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", i2);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", j);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", j2);
        }
        edit.commit();
        AppMethodBeat.m2505o(17557);
    }

    /* renamed from: gx */
    public final void mo68233gx(long j) {
        int i = 3;
        AppMethodBeat.m2504i(17558);
        C4990ab.m7416i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
        C19978b.m30879a(3, this.jtI);
        C38655k c38655k = new C38655k(C42759b.aTD().jqO);
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        C9638aw.m17190ZK();
        C38635g.m65515a(pLong, pLong2, C18628c.getAccPath());
        if (!jsA) {
            C9638aw.m17190ZK();
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                i = 0;
            } else {
                i = 1;
            }
        }
        c38655k.mo61494a(j, C38635g.m65528gw(pLong2.value), i);
        C4990ab.m7417i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", Long.valueOf(j), Integer.valueOf(i));
        c38655k.aUc();
        AppMethodBeat.m2505o(17558);
    }

    /* renamed from: rt */
    public final void mo68235rt(int i) {
        long aSH;
        long j;
        long j2 = 0;
        AppMethodBeat.m2504i(17559);
        if (this.jtS != null) {
            if (this.jtS.jrH != 0) {
                j2 = C5046bo.m7566gb(this.jtS.jrH);
            }
            aSH = this.jtS.aSH();
            j = j2;
        } else {
            aSH = 0;
            j = 0;
        }
        C7060h.pYm.mo8381e(13737, Integer.valueOf(i), Long.valueOf(aSH), Long.valueOf(j / 1000), Integer.valueOf(1), Integer.valueOf(C42759b.aTD().aTE().jwg));
        C4990ab.m7417i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(aSH), Long.valueOf(j / 1000));
        AppMethodBeat.m2505o(17559);
    }

    public final void aSs() {
        AppMethodBeat.m2504i(17560);
        final HashSet hashSet = new HashSet();
        hashSet.addAll(this.jwm);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17547);
                for (C19938c aSs : hashSet) {
                    aSs.aSs();
                }
                AppMethodBeat.m2505o(17547);
            }
        });
        AppMethodBeat.m2505o(17560);
    }

    /* renamed from: ru */
    public final void mo68236ru(int i) {
        AppMethodBeat.m2504i(17561);
        this.jrE.mo6651rj(i);
        AppMethodBeat.m2505o(17561);
    }

    /* renamed from: a */
    static /* synthetic */ void m75807a(C42760e c42760e) {
        AppMethodBeat.m2504i(17562);
        C19978b.m30879a(11, c42760e.jwx);
        C11151i c11151i = new C11151i(c42760e.jtQ, c42760e.jtT, c42760e.jtU);
        C4990ab.m7417i("MicroMsg.BackupPcServer", "backupPcSendRequestSession, chooseConvNames size[%d]", Integer.valueOf(c42760e.jtQ.size()));
        c11151i.aUc();
        AppMethodBeat.m2505o(17562);
    }
}
