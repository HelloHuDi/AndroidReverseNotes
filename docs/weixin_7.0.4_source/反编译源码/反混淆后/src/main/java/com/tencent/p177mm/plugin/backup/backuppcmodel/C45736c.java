package com.tencent.p177mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19320l;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C41256d.C26132;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C45732c;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19977d;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19979c;
import com.tencent.p177mm.plugin.backup.p920g.C19986h.C19987a;
import com.tencent.p177mm.plugin.backup.p920g.C24713a;
import com.tencent.p177mm.plugin.backup.p920g.C33704j.C33705a;
import com.tencent.p177mm.plugin.backup.p920g.C42773e;
import com.tencent.p177mm.plugin.backup.p921i.C33709c;
import com.tencent.p177mm.plugin.backup.p921i.C38661b;
import com.tencent.p177mm.plugin.backup.p921i.C45749a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C7284ua;
import com.tencent.p177mm.protocal.protobuf.ahq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.c */
public final class C45736c {
    private static boolean aGz = false;
    private static int eRu = 2;
    private C7564ap jtF;
    final C1202f jtG = new C199571();
    private final C1202f jtH = new C110973();
    C19979c jtL = new C386398();
    private final C33705a jtM = new C386386();
    public int jwa = 0;
    public String jwb;
    String jwc;
    int jwd;
    boolean jwe;
    private C1332b jwf;
    public int jwg;
    public boolean jwh = true;
    private final C19977d jwi = new C110984();
    public final C19987a jwj = new C457357();

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.c$3 */
    class C110973 implements C1202f {
        C110973() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17501);
            C45736c.aGz = true;
            C7060h.pYm.mo8381e(13736, Integer.valueOf(0), C45736c.this.jwb, C38635g.m65526ds(C4996ah.getContext()), Integer.valueOf(0), Integer.valueOf(C42759b.aTD().aTE().jwg));
            C19978b.m30886b(1, C45736c.this.jtH);
            if (i == 0 && i2 == 0) {
                boolean z;
                boolean z2;
                boolean z3;
                C24713a c24713a = (C24713a) c1207m;
                if ((c24713a.jwY.jCu & C45732c.jqL) == 0) {
                    z = false;
                } else {
                    z = true;
                }
                if ((c24713a.jwY.jCu & C45732c.jqM) == 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if ((c24713a.jwY.jCu & C45732c.jqN) == 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
                if (z3) {
                    C1332b c1332b;
                    if (c24713a.jwY.jCw == null) {
                        c1332b = null;
                    } else {
                        c1332b = c24713a.jwY.jCw;
                    }
                    if (c1332b != null) {
                        C45736c.this.mo73534a(true, c1332b);
                        C42759b.aTD().aTF().jwv = z;
                        C42759b.aTD().aTF().jww = z2;
                        AppMethodBeat.m2505o(17501);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
                }
                C45736c.this.mo73534a(false, null);
                C42759b.aTD().aTF().jwv = z;
                C42759b.aTD().aTF().jww = z2;
                AppMethodBeat.m2505o(17501);
                return;
            }
            C4990ab.m7413e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            switch (i2) {
                case -3:
                    C7060h.pYm.mo8378a(400, 115, 1, false);
                    break;
                case -1:
                    C7060h.pYm.mo8378a(400, 114, 1, false);
                    break;
                default:
                    C7060h.pYm.mo8378a(400, 116, 1, false);
                    break;
            }
            C7060h.pYm.mo8381e(13737, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(C45736c.this.jwg));
            C42759b.aTD().aSu().jqW = -5;
            C42759b.aTD().aTF().mo68236ru(-5);
            AppMethodBeat.m2505o(17501);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.c$4 */
    class C110984 implements C19977d {
        C110984() {
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo6669a(boolean z, int i, byte[] bArr, int i2) {
            AppMethodBeat.m2504i(17502);
            String str = "MicroMsg.BackupPcProcessMgr";
            String str2 = "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            C4990ab.m7417i(str, str2, objArr);
            if (!z || bArr == null) {
                if (i == 17) {
                    C38661b c38661b = new C38661b();
                    try {
                        c38661b.parseFrom(bArr);
                        C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", Integer.valueOf(c38661b.jBh));
                        switch (c38661b.jBh) {
                            case 1:
                                C45736c.m84500a(C45736c.this, 1, i2);
                                break;
                            case 3:
                                C45736c.m84502b(C45736c.this, 3, i2);
                                break;
                            case 5:
                                C9638aw.m17190ZK();
                                if (!((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                                    C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
                                    C45736c.m84500a(C45736c.this, 5, i2);
                                    break;
                                }
                                C42759b.aTD();
                                String string = C38634d.aSz().getString("BACKUP_PC_CHOOSE_SESSION", null);
                                if (string != null) {
                                    C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
                                    C7060h.pYm.mo8378a(400, 29, 1, false);
                                    C45736c.this.jwa = 3;
                                    LinkedList linkedList = new LinkedList(Arrays.asList(C38635g.m65524cX(string, ",")));
                                    C42759b.aTD().aTF().init();
                                    C42759b.aTD().aTF().mo68230G(linkedList);
                                    C45736c.m84505dA(5, i2);
                                    C42759b.aTD().aTF().aSs();
                                    C45736c.this.mo73535rs(6);
                                    C42760e aTF = C42759b.aTD().aTF();
                                    C38658d.aUr().aUu();
                                    aTF.mo68233gx((long) aTF.jtQ.size());
                                    break;
                                }
                                C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
                                C45736c.m84500a(C45736c.this, 5, i2);
                                break;
                            case 7:
                                C9638aw.m17190ZK();
                                if (!((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                                    C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
                                    C45736c.m84502b(C45736c.this, 7, i2);
                                    break;
                                }
                                C42759b.aTD().aTG();
                                if (!C41256d.aTe()) {
                                    C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
                                    C45736c.m84502b(C45736c.this, 7, i2);
                                    break;
                                }
                                C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
                                C7060h.pYm.mo8378a(400, 30, 1, false);
                                C45736c.this.jwa = 4;
                                C42759b.aTD().aTG().init();
                                C45736c.m84505dA(7, i2);
                                C42759b.aTD().aTF().aSs();
                                C45736c.this.mo73535rs(8);
                                break;
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
                    }
                }
                if (i == 5) {
                    C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
                    C7060h.pYm.mo8381e(13737, Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(C42759b.aTD().aTE().jwg));
                    C42759b.aTD().aSu().jqW = -100;
                    C42759b.aTD().aTF().mo68236ru(-100);
                    AppMethodBeat.m2505o(17502);
                    return;
                }
                AppMethodBeat.m2505o(17502);
                return;
            }
            if (CdnLogic.kMediaTypeBeatificFile == i) {
                C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", Integer.valueOf(C42759b.aTD().aSu().jqW));
                switch (C42759b.aTD().aSu().jqW) {
                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                    case -5:
                        C42759b.aTD().aTa().stop();
                        break;
                    case 1:
                        if (C45736c.aGz) {
                            C42759b.aTD().aTa().stop();
                            C42759b.aTD().aSu().jqW = -4;
                            C42759b.aTD().aTF().mo68236ru(-4);
                            AppMethodBeat.m2505o(17502);
                            return;
                        }
                        if (C45736c.this.jtF != null) {
                            C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
                            C45736c.this.jtF.stopTimer();
                        }
                        C45736c.m84504d(C45736c.this);
                        AppMethodBeat.m2505o(17502);
                        return;
                }
            }
            AppMethodBeat.m2505o(17502);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.c$1 */
    class C199571 implements C1202f {
        C199571() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17499);
            C9638aw.m17182Rg().mo14546b((int) C19320l.CTRL_INDEX, C45736c.this.jtG);
            if (i == 0 && i2 == 0) {
                ahq aUk = ((C42773e) c1207m).aUk();
                C9638aw.m17190ZK();
                String str2;
                if (!C5046bo.nullAsNil((String) C18628c.m29072Ry().get(2, null)).equals(aUk.vIQ)) {
                    C4990ab.m7412e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
                    C42759b.aTD().aSu().jqW = -5;
                    C42759b.aTD().aTF().mo68236ru(-5);
                    C7060h.pYm.mo8378a(400, 112, 1, false);
                    AppMethodBeat.m2505o(17499);
                    return;
                } else if (aUk.vIO == null || aUk.vIO.size() <= 0 || aUk.vIO.getFirst() == null) {
                    str2 = "MicroMsg.BackupPcProcessMgr";
                    String str3 = "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(aUk.vIN);
                    objArr[1] = aUk.vIO == null ? BuildConfig.COMMAND : aUk.vIO.size();
                    C4990ab.m7413e(str2, str3, objArr);
                    C42759b.aTD().aSu().jqW = -5;
                    C42759b.aTD().aTF().mo68236ru(-5);
                    C7060h.pYm.mo8378a(400, 113, 1, false);
                    AppMethodBeat.m2505o(17499);
                    return;
                } else {
                    C7284ua c7284ua = (C7284ua) aUk.vIO.getFirst();
                    str2 = c7284ua.vYA;
                    int intValue = ((Integer) c7284ua.wbp.getFirst()).intValue();
                    C45736c c45736c = C45736c.this;
                    c45736c.jwb = aUk.vIR;
                    c45736c.jwc = str2;
                    c45736c.jwd = intValue;
                    C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", Integer.valueOf(aUk.jCt), Integer.valueOf(aUk.Scene), aUk.vIR, str2, Integer.valueOf(intValue));
                    C42759b.aTD().jqO = aUk.f2976ID;
                    C42759b.aTD().jqP = aUk.vIW;
                    C42759b.aTD().jqQ = aUk.vIX;
                    C42759b.aTD().jqU = aUk.vIn.getBufferToBytes();
                    C45736c.m84501b(C45736c.this);
                    AppMethodBeat.m2505o(17499);
                    return;
                }
            }
            C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            C7060h.pYm.mo8378a(400, 111, 1, false);
            if (i == 4 && i2 == -2011) {
                C4990ab.m7412e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
            }
            C42759b.aTD().aSu().jqW = -5;
            C42759b.aTD().aTF().mo68236ru(-5);
            AppMethodBeat.m2505o(17499);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.c$2 */
    class C274502 implements C5015a {
        C274502() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(17500);
            if (!C45736c.aGz) {
                C4990ab.m7412e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
                if (C45736c.this.jtF != null) {
                    C45736c.this.jtF.stopTimer();
                }
                C45736c.m84504d(C45736c.this);
            }
            AppMethodBeat.m2505o(17500);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.c$6 */
    class C386386 implements C33705a {
        C386386() {
        }

        public final void aTn() {
            AppMethodBeat.m2504i(17504);
            int i = C42759b.aTD().aTE().jwa;
            if (1 == i || 3 == i) {
                C42759b.aTD().aTF().mo68236ru(C42759b.aTD().aSu().jqW);
                AppMethodBeat.m2505o(17504);
                return;
            }
            if (2 == i || 4 == i) {
                C42759b.aTD().aTG().mo6681rj(C42759b.aTD().aSu().jqW);
            }
            AppMethodBeat.m2505o(17504);
        }

        /* renamed from: ro */
        public final void mo15077ro(int i) {
            AppMethodBeat.m2504i(17505);
            int i2 = C42759b.aTD().aSu().jqW;
            if (i == 1) {
                if ((1 == C45736c.this.jwa || 3 == C45736c.this.jwa) && i2 == 14) {
                    C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
                    C42759b.aTD().aSu().jqW = 4;
                    C42759b.aTD().aTF().mo68236ru(4);
                    AppMethodBeat.m2505o(17505);
                    return;
                } else if ((2 == C45736c.this.jwa || 4 == C45736c.this.jwa) && i2 == 23) {
                    C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
                    C42759b.aTD().aSu().jqW = 4;
                    C42759b.aTD().aTG().mo6681rj(4);
                    AppMethodBeat.m2505o(17505);
                    return;
                }
            } else if (i == 0 && i2 == 4) {
                C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
                if (1 == C45736c.this.jwa || 3 == C45736c.this.jwa) {
                    C42759b.aTD().aSu().jqW = 14;
                    C42759b.aTD().aTF().mo68236ru(14);
                    AppMethodBeat.m2505o(17505);
                    return;
                } else if (2 == C45736c.this.jwa || 4 == C45736c.this.jwa) {
                    C42759b.aTD().aSu().jqW = 23;
                    C42759b.aTD().aTG().mo6681rj(23);
                }
            }
            AppMethodBeat.m2505o(17505);
        }

        public final void aTo() {
            AppMethodBeat.m2504i(17506);
            int i = C42759b.aTD().aSu().jqW;
            C4990ab.m7413e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", Integer.valueOf(i));
            int i2 = C42759b.aTD().aTE().jwa;
            if ((1 == i2 || 3 == i2) && (i == 14 || i == 4)) {
                C42759b.aTD().aTa().stop();
                C42759b.aTD().aTF().cancel(true);
                C7060h.pYm.mo8378a(400, 9, 1, false);
                C42759b.aTD().aTF().mo68235rt(18);
                C42759b.aTD().aSu().jqW = -4;
                C42759b.aTD().aTF().mo68236ru(-4);
                AppMethodBeat.m2505o(17506);
                return;
            }
            if ((2 == i2 || 4 == i2) && (i == 23 || i == 4)) {
                C42759b.aTD().aTa().stop();
                C42759b.aTD().aTG().mo65912c(true, false, -4);
                C7060h.pYm.mo8378a(400, 17, 1, false);
                C42759b.aTD().aTG().mo65914rt(18);
            }
            AppMethodBeat.m2505o(17506);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.c$8 */
    class C386398 implements C19979c {
        C386398() {
        }

        public final void aTm() {
            AppMethodBeat.m2504i(17509);
            C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
            C19978b.aTV();
            C42759b.aTD().aSw();
            AppMethodBeat.m2505o(17509);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.c$5 */
    class C457345 implements Runnable {
        C457345() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17503);
            C42759b.aTD().aTa().stop();
            C42759b.aTD().aSw();
            C19978b.aTV();
            C19978b.aTX();
            AppMethodBeat.m2505o(17503);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.c$7 */
    class C457357 implements C19987a {
        C457357() {
        }

        public final void aTK() {
            AppMethodBeat.m2504i(17507);
            C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
            if (C42759b.aTD().aSu().jqW != 5) {
                C42759b.aTD().aSu().jqW = 5;
                int i = C42759b.aTD().aTE().jwa;
                if (1 == i || 3 == i) {
                    C42759b.aTD().aTF().mo68236ru(5);
                } else if (2 == i || 4 == i) {
                    C42759b.aTD().aTG().mo6681rj(5);
                }
            }
            C45736c.this.mo73535rs(9);
            AppMethodBeat.m2505o(17507);
        }

        public final void aTL() {
            AppMethodBeat.m2504i(17508);
            int i = C45736c.this.jwa;
            C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", Integer.valueOf(i));
            if (1 == i || 3 == i) {
                C42759b.aTD().aTF();
                C42760e.aTN();
                C42759b.aTD().aTF().cancel(true);
                C42759b.aTD().aTa().stop();
                C42759b.aTD().aSu().jqW = -4;
                C42759b.aTD().aTF().mo68236ru(-4);
                C7060h.pYm.mo8378a(400, 9, 1, false);
                C42759b.aTD().aTF().mo68235rt(3);
                AppMethodBeat.m2505o(17508);
                return;
            }
            if (2 == i || 4 == i) {
                C42759b.aTD().aTG();
                C41256d.aTM();
                C42759b.aTD().aTG().mo65912c(true, false, -4);
                C42759b.aTD().aTa().stop();
                C7060h.pYm.mo8378a(400, 17, 1, false);
                C42759b.aTD().aTG().mo65914rt(3);
            }
            AppMethodBeat.m2505o(17508);
        }
    }

    public C45736c() {
        AppMethodBeat.m2504i(17510);
        AppMethodBeat.m2505o(17510);
    }

    /* renamed from: a */
    public final void mo73534a(boolean z, C1332b c1332b) {
        this.jwe = z;
        this.jwf = c1332b;
    }

    private void aTI() {
        AppMethodBeat.m2504i(17511);
        C42759b.aTD().aTa().connect(this.jwc, this.jwd);
        C19978b.clear();
        C19978b.m30879a(1, this.jtH);
        C24713a c24713a = new C24713a(C42759b.aTD().jqP, C42759b.aTD().jqQ, C38634d.aSy(), C42759b.aTD().jqO, 0, 1);
        c24713a.mo41608u(true, true);
        c24713a.jwX.jCv = 1;
        c24713a.aUc();
        C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
        if (this.jtF == null) {
            this.jtF = new C7564ap(new C274502(), false);
        }
        this.jtF.mo16770ae(3000, 3000);
        AppMethodBeat.m2505o(17511);
    }

    public static String aTJ() {
        AppMethodBeat.m2504i(17512);
        String aTY = C19978b.aTY();
        AppMethodBeat.m2505o(17512);
        return aTY;
    }

    /* renamed from: rs */
    public final void mo73535rs(int i) {
        AppMethodBeat.m2504i(17513);
        C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", Integer.valueOf(i));
        C38661b c38661b = new C38661b();
        c38661b.jBh = i;
        if (i == 9) {
            c38661b.jBi = this.jwf;
        }
        try {
            C19978b.m30877K(c38661b.toByteArray(), 17);
            AppMethodBeat.m2505o(17513);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandRequest to buf err.", new Object[0]);
            AppMethodBeat.m2505o(17513);
        }
    }

    /* renamed from: dA */
    public static void m84505dA(int i, int i2) {
        AppMethodBeat.m2504i(17514);
        C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", Integer.valueOf(i));
        C33709c c33709c = new C33709c();
        c33709c.jBh = i;
        try {
            C19978b.m30889r(c33709c.toByteArray(), 18, i2);
            AppMethodBeat.m2505o(17514);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandResponse to buf err.", new Object[0]);
            AppMethodBeat.m2505o(17514);
        }
    }

    public static void aTj() {
        AppMethodBeat.m2504i(17515);
        C4990ab.m7416i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
        C45749a c45749a = new C45749a();
        c45749a.f17890ID = C42759b.aTD().jqO;
        try {
            C19978b.m30877K(c45749a.toByteArray(), 5);
            AppMethodBeat.m2505o(17515);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCancelRequest to buf err.", new Object[0]);
            AppMethodBeat.m2505o(17515);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m84501b(C45736c c45736c) {
        AppMethodBeat.m2504i(17516);
        C19978b.m30890rk(1);
        C42759b.aTD().aSv();
        C19978b.m30882a(c45736c.jtL);
        C19978b.m30883a(c45736c.jwi);
        C19978b.m30880a(C42759b.aTD().aTa());
        C19978b.m30885a(c45736c.jtM);
        C42759b.aTD().aSu().jqW = 1;
        Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_notification");
        C4996ah.getContext().startActivity(className);
        aGz = false;
        C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "startConnectPc, PC ip:%s, PC wifi:%s, Phone wifi:%s", c45736c.jwc, c45736c.jwb, C38635g.m65526ds(C4996ah.getContext()));
        eRu = 2;
        c45736c.aTI();
        AppMethodBeat.m2505o(17516);
    }

    /* renamed from: d */
    static /* synthetic */ void m84504d(C45736c c45736c) {
        AppMethodBeat.m2504i(17517);
        String str = c45736c.jwb;
        String str2 = c45736c.jwc;
        String ds = C38635g.m65526ds(C4996ah.getContext());
        C42759b.aTD().aTa().stop();
        C4990ab.m7413e("MicroMsg.BackupPcProcessMgr", "tryConnectFailed thisWifiName:%s, pcWifiName:%s, pcIpAddress:%s, tryCount:%d", ds, str, str2, Integer.valueOf(eRu));
        if (ds == null || ds.equals("")) {
            C7060h.pYm.mo8378a(400, 1, 1, false);
            C7060h.pYm.mo8381e(13736, Integer.valueOf(1), str, ds, Integer.valueOf(0), Integer.valueOf(C42759b.aTD().aTE().jwg));
            C42759b.aTD().aSu().jqW = -1;
            C42759b.aTD().aTF().mo68236ru(-1);
            AppMethodBeat.m2505o(17517);
        } else if (str == null || !str.equals(ds)) {
            C7060h.pYm.mo8378a(400, 2, 1, false);
            C7060h.pYm.mo8381e(13736, Integer.valueOf(2), str, ds, Integer.valueOf(0), Integer.valueOf(C42759b.aTD().aTE().jwg));
            C42759b.aTD().aSu().jqW = -2;
            C42759b.aTD().aTF().mo68236ru(-2);
            AppMethodBeat.m2505o(17517);
        } else if (!C38635g.m65505Fc(str2)) {
            C7060h.pYm.mo8378a(400, 3, 1, false);
            C7060h.pYm.mo8381e(13736, Integer.valueOf(3), str, ds, Integer.valueOf(0), Integer.valueOf(C42759b.aTD().aTE().jwg));
            C42759b.aTD().aSu().jqW = -3;
            C42759b.aTD().aTF().mo68236ru(-3);
            AppMethodBeat.m2505o(17517);
        } else if (eRu <= 0) {
            C7060h.pYm.mo8378a(400, 63, 1, false);
            C7060h.pYm.mo8381e(13736, Integer.valueOf(6), str, ds, Integer.valueOf(0), Integer.valueOf(C42759b.aTD().aTE().jwg));
            C42759b.aTD().aSu().jqW = -5;
            C42759b.aTD().aTF().mo68236ru(-5);
            AppMethodBeat.m2505o(17517);
        } else {
            eRu--;
            c45736c.aTI();
            AppMethodBeat.m2505o(17517);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m84500a(C45736c c45736c, int i, int i2) {
        AppMethodBeat.m2504i(17518);
        C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "newBackup, command[%d]", Integer.valueOf(i));
        c45736c.jwa = 1;
        C42759b.aTD().jqR = null;
        C42759b.aTD().aTF().init();
        C42760e aTF = C42759b.aTD().aTF();
        C4990ab.m7416i("MicroMsg.BackupPcServer", "clearContinueBackupData.");
        aTF.jtS.mo54245fj(false);
        C45736c.m84505dA(i, i2);
        C42759b.aTD().aTF().aSs();
        AppMethodBeat.m2505o(17518);
    }

    /* renamed from: b */
    static /* synthetic */ void m84502b(C45736c c45736c, int i, int i2) {
        AppMethodBeat.m2504i(17519);
        C4990ab.m7417i("MicroMsg.BackupPcProcessMgr", "newRecover, command[%d]", Integer.valueOf(i));
        c45736c.jwa = 2;
        C42759b.aTD().jqR = null;
        C42759b.aTD().aTG().init();
        C42759b.aTD().aTG().aTf();
        C45736c.m84505dA(i, i2);
        C41256d aTG = C42759b.aTD().aTG();
        HashSet hashSet = new HashSet();
        hashSet.addAll(aTG.jwm);
        C5004al.m7441d(new C26132(hashSet));
        AppMethodBeat.m2505o(17519);
    }
}
