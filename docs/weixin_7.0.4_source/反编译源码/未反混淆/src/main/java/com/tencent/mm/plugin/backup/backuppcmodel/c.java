package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.b.d;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.plugin.backup.g.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public final class c {
    private static boolean aGz = false;
    private static int eRu = 2;
    private ap jtF;
    final f jtG = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17499);
            aw.Rg().b((int) l.CTRL_INDEX, c.this.jtG);
            if (i == 0 && i2 == 0) {
                ahq aUk = ((e) mVar).aUk();
                aw.ZK();
                String str2;
                if (!bo.nullAsNil((String) com.tencent.mm.model.c.Ry().get(2, null)).equals(aUk.vIQ)) {
                    ab.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: not the same account");
                    b.aTD().aSu().jqW = -5;
                    b.aTD().aTF().ru(-5);
                    h.pYm.a(400, 112, 1, false);
                    AppMethodBeat.o(17499);
                    return;
                } else if (aUk.vIO == null || aUk.vIO.size() <= 0 || aUk.vIO.getFirst() == null) {
                    str2 = "MicroMsg.BackupPcProcessMgr";
                    String str3 = "onGetConnectInfoEnd AddrList is empty! AddrCount[%d], AddrList size[%s]";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(aUk.vIN);
                    objArr[1] = aUk.vIO == null ? BuildConfig.COMMAND : aUk.vIO.size();
                    ab.e(str2, str3, objArr);
                    b.aTD().aSu().jqW = -5;
                    b.aTD().aTF().ru(-5);
                    h.pYm.a(400, 113, 1, false);
                    AppMethodBeat.o(17499);
                    return;
                } else {
                    ua uaVar = (ua) aUk.vIO.getFirst();
                    str2 = uaVar.vYA;
                    int intValue = ((Integer) uaVar.wbp.getFirst()).intValue();
                    c cVar = c.this;
                    cVar.jwb = aUk.vIR;
                    cVar.jwc = str2;
                    cVar.jwd = intValue;
                    ab.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd type:%d, scene:%d, wifiName:%s, ip:%s, port:%d", Integer.valueOf(aUk.jCt), Integer.valueOf(aUk.Scene), aUk.vIR, str2, Integer.valueOf(intValue));
                    b.aTD().jqO = aUk.ID;
                    b.aTD().jqP = aUk.vIW;
                    b.aTD().jqQ = aUk.vIX;
                    b.aTD().jqU = aUk.vIn.getBufferToBytes();
                    c.b(c.this);
                    AppMethodBeat.o(17499);
                    return;
                }
            }
            ab.i("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: other error[%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            h.pYm.a(400, 111, 1, false);
            if (i == 4 && i2 == -2011) {
                ab.e("MicroMsg.BackupPcProcessMgr", "onGetConnectInfoEnd Error: INVALID URL");
            }
            b.aTD().aSu().jqW = -5;
            b.aTD().aTF().ru(-5);
            AppMethodBeat.o(17499);
        }
    };
    private final f jtH = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17501);
            c.aGz = true;
            h.pYm.e(13736, Integer.valueOf(0), c.this.jwb, g.ds(ah.getContext()), Integer.valueOf(0), Integer.valueOf(b.aTD().aTE().jwg));
            b.b(1, c.this.jtH);
            if (i == 0 && i2 == 0) {
                boolean z;
                boolean z2;
                boolean z3;
                a aVar = (a) mVar;
                if ((aVar.jwY.jCu & com.tencent.mm.plugin.backup.b.c.jqL) == 0) {
                    z = false;
                } else {
                    z = true;
                }
                if ((aVar.jwY.jCu & com.tencent.mm.plugin.backup.b.c.jqM) == 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if ((aVar.jwY.jCu & com.tencent.mm.plugin.backup.b.c.jqN) == 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                ab.i("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth success, pcSupportTimeSelect[%b], pcSupportQuickBackup[%b], pcSupportReconnect[%b]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
                if (z3) {
                    com.tencent.mm.bt.b bVar;
                    if (aVar.jwY.jCw == null) {
                        bVar = null;
                    } else {
                        bVar = aVar.jwY.jCw;
                    }
                    if (bVar != null) {
                        c.this.a(true, bVar);
                        b.aTD().aTF().jwv = z;
                        b.aTD().aTF().jww = z2;
                        AppMethodBeat.o(17501);
                        return;
                    }
                    ab.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd pcSupportReconnect but token is null!");
                }
                c.this.a(false, null);
                b.aTD().aTF().jwv = z;
                b.aTD().aTF().jww = z2;
                AppMethodBeat.o(17501);
                return;
            }
            ab.e("MicroMsg.BackupPcProcessMgr", "onBackupAuthEnd auth failed, errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
            switch (i2) {
                case -3:
                    h.pYm.a(400, 115, 1, false);
                    break;
                case -1:
                    h.pYm.a(400, 114, 1, false);
                    break;
                default:
                    h.pYm.a(400, 116, 1, false);
                    break;
            }
            h.pYm.e(13737, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(c.this.jwg));
            b.aTD().aSu().jqW = -5;
            b.aTD().aTF().ru(-5);
            AppMethodBeat.o(17501);
        }
    };
    com.tencent.mm.plugin.backup.g.b.c jtL = new com.tencent.mm.plugin.backup.g.b.c() {
        public final void aTm() {
            AppMethodBeat.i(17509);
            ab.i("MicroMsg.BackupPcProcessMgr", "engineStopCallback ");
            b.aTV();
            b.aTD().aSw();
            AppMethodBeat.o(17509);
        }
    };
    private final j.a jtM = new j.a() {
        public final void aTn() {
            AppMethodBeat.i(17504);
            int i = b.aTD().aTE().jwa;
            if (1 == i || 3 == i) {
                b.aTD().aTF().ru(b.aTD().aSu().jqW);
                AppMethodBeat.o(17504);
                return;
            }
            if (2 == i || 4 == i) {
                b.aTD().aTG().rj(b.aTD().aSu().jqW);
            }
            AppMethodBeat.o(17504);
        }

        public final void ro(int i) {
            AppMethodBeat.i(17505);
            int i2 = b.aTD().aSu().jqW;
            if (i == 1) {
                if ((1 == c.this.jwa || 3 == c.this.jwa) && i2 == 14) {
                    ab.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
                    b.aTD().aSu().jqW = 4;
                    b.aTD().aTF().ru(4);
                    AppMethodBeat.o(17505);
                    return;
                } else if ((2 == c.this.jwa || 4 == c.this.jwa) && i2 == 23) {
                    ab.i("MicroMsg.BackupPcProcessMgr", "speedCallback is weak connect now.");
                    b.aTD().aSu().jqW = 4;
                    b.aTD().aTG().rj(4);
                    AppMethodBeat.o(17505);
                    return;
                }
            } else if (i == 0 && i2 == 4) {
                ab.i("MicroMsg.BackupPcProcessMgr", "speedCallback is normal speed now.");
                if (1 == c.this.jwa || 3 == c.this.jwa) {
                    b.aTD().aSu().jqW = 14;
                    b.aTD().aTF().ru(14);
                    AppMethodBeat.o(17505);
                    return;
                } else if (2 == c.this.jwa || 4 == c.this.jwa) {
                    b.aTD().aSu().jqW = 23;
                    b.aTD().aTG().rj(23);
                }
            }
            AppMethodBeat.o(17505);
        }

        public final void aTo() {
            AppMethodBeat.i(17506);
            int i = b.aTD().aSu().jqW;
            ab.e("MicroMsg.BackupPcProcessMgr", "speedOverTime callback, backupState[%d]", Integer.valueOf(i));
            int i2 = b.aTD().aTE().jwa;
            if ((1 == i2 || 3 == i2) && (i == 14 || i == 4)) {
                b.aTD().aTa().stop();
                b.aTD().aTF().cancel(true);
                h.pYm.a(400, 9, 1, false);
                b.aTD().aTF().rt(18);
                b.aTD().aSu().jqW = -4;
                b.aTD().aTF().ru(-4);
                AppMethodBeat.o(17506);
                return;
            }
            if ((2 == i2 || 4 == i2) && (i == 23 || i == 4)) {
                b.aTD().aTa().stop();
                b.aTD().aTG().c(true, false, -4);
                h.pYm.a(400, 17, 1, false);
                b.aTD().aTG().rt(18);
            }
            AppMethodBeat.o(17506);
        }
    };
    public int jwa = 0;
    public String jwb;
    String jwc;
    int jwd;
    boolean jwe;
    private com.tencent.mm.bt.b jwf;
    public int jwg;
    public boolean jwh = true;
    private final d jwi = new d() {
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(boolean z, int i, byte[] bArr, int i2) {
            AppMethodBeat.i(17502);
            String str = "MicroMsg.BackupPcProcessMgr";
            String str2 = "onBackupPcProcessMgrNotify isLocal[%b], type[%d], seq[%d], buf[%d]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            ab.i(str, str2, objArr);
            if (!z || bArr == null) {
                if (i == 17) {
                    com.tencent.mm.plugin.backup.i.b bVar = new com.tencent.mm.plugin.backup.i.b();
                    try {
                        bVar.parseFrom(bArr);
                        ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive commandReq, command[%d]", Integer.valueOf(bVar.jBh));
                        switch (bVar.jBh) {
                            case 1:
                                c.a(c.this, 1, i2);
                                break;
                            case 3:
                                c.b(c.this, 3, i2);
                                break;
                            case 5:
                                aw.ZK();
                                if (!((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                                    ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not backuping, start new backup.");
                                    c.a(c.this, 5, i2);
                                    break;
                                }
                                b.aTD();
                                String string = com.tencent.mm.plugin.backup.b.d.aSz().getString("BACKUP_PC_CHOOSE_SESSION", null);
                                if (string != null) {
                                    ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify start continue Backup.");
                                    h.pYm.a(400, 29, 1, false);
                                    c.this.jwa = 3;
                                    LinkedList linkedList = new LinkedList(Arrays.asList(g.cX(string, ",")));
                                    b.aTD().aTF().init();
                                    b.aTD().aTF().G(linkedList);
                                    c.dA(5, i2);
                                    b.aTD().aTF().aSs();
                                    c.this.rs(6);
                                    e aTF = b.aTD().aTF();
                                    com.tencent.mm.plugin.backup.h.d.aUr().aUu();
                                    aTF.gx((long) aTF.jtQ.size());
                                    break;
                                }
                                ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify sessionString is null, start new backup.");
                                c.a(c.this, 5, i2);
                                break;
                            case 7:
                                aw.ZK();
                                if (!((Boolean) com.tencent.mm.model.c.Ry().get(ac.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                                    ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify not recovering, start new recover.");
                                    c.b(c.this, 7, i2);
                                    break;
                                }
                                b.aTD().aTG();
                                if (!d.aTe()) {
                                    ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify MsgDataIdList not exist, start new recover.");
                                    c.b(c.this, 7, i2);
                                    break;
                                }
                                ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify continue Recover.");
                                h.pYm.a(400, 30, 1, false);
                                c.this.jwa = 4;
                                b.aTD().aTG().init();
                                c.dA(7, i2);
                                b.aTD().aTF().aSs();
                                c.this.rs(8);
                                break;
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "onBackupPcProcessMgrNotify buf to BackupCommandRequest error.", new Object[0]);
                    }
                }
                if (i == 5) {
                    ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify receive cancelReq");
                    h.pYm.e(13737, Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(b.aTD().aTE().jwg));
                    b.aTD().aSu().jqW = -100;
                    b.aTD().aTF().ru(-100);
                    AppMethodBeat.o(17502);
                    return;
                }
                AppMethodBeat.o(17502);
                return;
            }
            if (CdnLogic.kMediaTypeBeatificFile == i) {
                ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify local disconnect, backupPcState[%d]", Integer.valueOf(b.aTD().aSu().jqW));
                switch (b.aTD().aSu().jqW) {
                    case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                    case -5:
                        b.aTD().aTa().stop();
                        break;
                    case 1:
                        if (c.aGz) {
                            b.aTD().aTa().stop();
                            b.aTD().aSu().jqW = -4;
                            b.aTD().aTF().ru(-4);
                            AppMethodBeat.o(17502);
                            return;
                        }
                        if (c.this.jtF != null) {
                            ab.i("MicroMsg.BackupPcProcessMgr", "onBackupPcProcessMgrNotify stop backupConnectTimerHandler.");
                            c.this.jtF.stopTimer();
                        }
                        c.d(c.this);
                        AppMethodBeat.o(17502);
                        return;
                }
            }
            AppMethodBeat.o(17502);
        }
    };
    public final com.tencent.mm.plugin.backup.g.h.a jwj = new com.tencent.mm.plugin.backup.g.h.a() {
        public final void aTK() {
            AppMethodBeat.i(17507);
            ab.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback callback to reconnect");
            if (b.aTD().aSu().jqW != 5) {
                b.aTD().aSu().jqW = 5;
                int i = b.aTD().aTE().jwa;
                if (1 == i || 3 == i) {
                    b.aTD().aTF().ru(5);
                } else if (2 == i || 4 == i) {
                    b.aTD().aTG().rj(5);
                }
            }
            c.this.rs(9);
            AppMethodBeat.o(17507);
        }

        public final void aTL() {
            AppMethodBeat.i(17508);
            int i = c.this.jwa;
            ab.i("MicroMsg.BackupPcProcessMgr", "reconnectCallback reconnectFail, commandMode[%d]", Integer.valueOf(i));
            if (1 == i || 3 == i) {
                b.aTD().aTF();
                e.aTN();
                b.aTD().aTF().cancel(true);
                b.aTD().aTa().stop();
                b.aTD().aSu().jqW = -4;
                b.aTD().aTF().ru(-4);
                h.pYm.a(400, 9, 1, false);
                b.aTD().aTF().rt(3);
                AppMethodBeat.o(17508);
                return;
            }
            if (2 == i || 4 == i) {
                b.aTD().aTG();
                d.aTM();
                b.aTD().aTG().c(true, false, -4);
                b.aTD().aTa().stop();
                h.pYm.a(400, 17, 1, false);
                b.aTD().aTG().rt(3);
            }
            AppMethodBeat.o(17508);
        }
    };

    public c() {
        AppMethodBeat.i(17510);
        AppMethodBeat.o(17510);
    }

    public final void a(boolean z, com.tencent.mm.bt.b bVar) {
        this.jwe = z;
        this.jwf = bVar;
    }

    private void aTI() {
        AppMethodBeat.i(17511);
        b.aTD().aTa().connect(this.jwc, this.jwd);
        b.clear();
        b.a(1, this.jtH);
        a aVar = new a(b.aTD().jqP, b.aTD().jqQ, com.tencent.mm.plugin.backup.b.d.aSy(), b.aTD().jqO, 0, 1);
        aVar.u(true, true);
        aVar.jwX.jCv = 1;
        aVar.aUc();
        ab.i("MicroMsg.BackupPcProcessMgr", "tryConnect start backupConnectTimerHandler.");
        if (this.jtF == null) {
            this.jtF = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(17500);
                    if (!c.aGz) {
                        ab.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
                        if (c.this.jtF != null) {
                            c.this.jtF.stopTimer();
                        }
                        c.d(c.this);
                    }
                    AppMethodBeat.o(17500);
                    return true;
                }
            }, false);
        }
        this.jtF.ae(3000, 3000);
        AppMethodBeat.o(17511);
    }

    public static String aTJ() {
        AppMethodBeat.i(17512);
        String aTY = b.aTY();
        AppMethodBeat.o(17512);
        return aTY;
    }

    public final void rs(int i) {
        AppMethodBeat.i(17513);
        ab.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandRequest cmd:%d", Integer.valueOf(i));
        com.tencent.mm.plugin.backup.i.b bVar = new com.tencent.mm.plugin.backup.i.b();
        bVar.jBh = i;
        if (i == 9) {
            bVar.jBi = this.jwf;
        }
        try {
            b.K(bVar.toByteArray(), 17);
            AppMethodBeat.o(17513);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandRequest to buf err.", new Object[0]);
            AppMethodBeat.o(17513);
        }
    }

    public static void dA(int i, int i2) {
        AppMethodBeat.i(17514);
        ab.i("MicroMsg.BackupPcProcessMgr", "backupSendCommandResponse cmd:%d", Integer.valueOf(i));
        com.tencent.mm.plugin.backup.i.c cVar = new com.tencent.mm.plugin.backup.i.c();
        cVar.jBh = i;
        try {
            b.r(cVar.toByteArray(), 18, i2);
            AppMethodBeat.o(17514);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCommandResponse to buf err.", new Object[0]);
            AppMethodBeat.o(17514);
        }
    }

    public static void aTj() {
        AppMethodBeat.i(17515);
        ab.i("MicroMsg.BackupPcProcessMgr", "backupSendCancelRequest.");
        com.tencent.mm.plugin.backup.i.a aVar = new com.tencent.mm.plugin.backup.i.a();
        aVar.ID = b.aTD().jqO;
        try {
            b.K(aVar.toByteArray(), 5);
            AppMethodBeat.o(17515);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupPcProcessMgr", e, "BackupCancelRequest to buf err.", new Object[0]);
            AppMethodBeat.o(17515);
        }
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(17516);
        b.rk(1);
        b.aTD().aSv();
        b.a(cVar.jtL);
        b.a(cVar.jwi);
        b.a(b.aTD().aTa());
        b.a(cVar.jtM);
        b.aTD().aSu().jqW = 1;
        Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_notification");
        ah.getContext().startActivity(className);
        aGz = false;
        ab.i("MicroMsg.BackupPcProcessMgr", "startConnectPc, PC ip:%s, PC wifi:%s, Phone wifi:%s", cVar.jwc, cVar.jwb, g.ds(ah.getContext()));
        eRu = 2;
        cVar.aTI();
        AppMethodBeat.o(17516);
    }

    static /* synthetic */ void d(c cVar) {
        AppMethodBeat.i(17517);
        String str = cVar.jwb;
        String str2 = cVar.jwc;
        String ds = g.ds(ah.getContext());
        b.aTD().aTa().stop();
        ab.e("MicroMsg.BackupPcProcessMgr", "tryConnectFailed thisWifiName:%s, pcWifiName:%s, pcIpAddress:%s, tryCount:%d", ds, str, str2, Integer.valueOf(eRu));
        if (ds == null || ds.equals("")) {
            h.pYm.a(400, 1, 1, false);
            h.pYm.e(13736, Integer.valueOf(1), str, ds, Integer.valueOf(0), Integer.valueOf(b.aTD().aTE().jwg));
            b.aTD().aSu().jqW = -1;
            b.aTD().aTF().ru(-1);
            AppMethodBeat.o(17517);
        } else if (str == null || !str.equals(ds)) {
            h.pYm.a(400, 2, 1, false);
            h.pYm.e(13736, Integer.valueOf(2), str, ds, Integer.valueOf(0), Integer.valueOf(b.aTD().aTE().jwg));
            b.aTD().aSu().jqW = -2;
            b.aTD().aTF().ru(-2);
            AppMethodBeat.o(17517);
        } else if (!g.Fc(str2)) {
            h.pYm.a(400, 3, 1, false);
            h.pYm.e(13736, Integer.valueOf(3), str, ds, Integer.valueOf(0), Integer.valueOf(b.aTD().aTE().jwg));
            b.aTD().aSu().jqW = -3;
            b.aTD().aTF().ru(-3);
            AppMethodBeat.o(17517);
        } else if (eRu <= 0) {
            h.pYm.a(400, 63, 1, false);
            h.pYm.e(13736, Integer.valueOf(6), str, ds, Integer.valueOf(0), Integer.valueOf(b.aTD().aTE().jwg));
            b.aTD().aSu().jqW = -5;
            b.aTD().aTF().ru(-5);
            AppMethodBeat.o(17517);
        } else {
            eRu--;
            cVar.aTI();
            AppMethodBeat.o(17517);
        }
    }

    static /* synthetic */ void a(c cVar, int i, int i2) {
        AppMethodBeat.i(17518);
        ab.i("MicroMsg.BackupPcProcessMgr", "newBackup, command[%d]", Integer.valueOf(i));
        cVar.jwa = 1;
        b.aTD().jqR = null;
        b.aTD().aTF().init();
        e aTF = b.aTD().aTF();
        ab.i("MicroMsg.BackupPcServer", "clearContinueBackupData.");
        aTF.jtS.fj(false);
        dA(i, i2);
        b.aTD().aTF().aSs();
        AppMethodBeat.o(17518);
    }

    static /* synthetic */ void b(c cVar, int i, int i2) {
        AppMethodBeat.i(17519);
        ab.i("MicroMsg.BackupPcProcessMgr", "newRecover, command[%d]", Integer.valueOf(i));
        cVar.jwa = 2;
        b.aTD().jqR = null;
        b.aTD().aTG().init();
        b.aTD().aTG().aTf();
        dA(i, i2);
        d aTG = b.aTD().aTG();
        HashSet hashSet = new HashSet();
        hashSet.addAll(aTG.jwm);
        al.d(new com.tencent.mm.plugin.backup.backuppcmodel.d.AnonymousClass2(hashSet));
        AppMethodBeat.o(17519);
    }
}
