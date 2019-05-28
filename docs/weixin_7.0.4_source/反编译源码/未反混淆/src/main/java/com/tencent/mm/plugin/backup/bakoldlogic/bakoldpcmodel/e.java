package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.md;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.jsapi.b.j;
import com.tencent.mm.plugin.backup.bakoldlogic.c.c;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.q;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.s;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.LinkedList;

public final class e implements com.tencent.mm.plugin.backup.g.b.d {
    public c jzA;
    public a jzB;
    public e jzC;
    public d jzD = new d();
    public f jzE = new f();
    com.tencent.mm.plugin.backup.bakoldlogic.c.e jzF;
    private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a jzG;
    public int jzH = -1;
    public String jzI;
    public String jzJ;
    public int jzK = -1;
    public int jzL = 1;
    private boolean jzM = false;
    private d jzs;

    public interface e extends b {
        void aUR();
    }

    public interface c extends b {
        void onEvent(int i);

        void rH(int i);
    }

    public interface d extends b {
        void aSt();

        void aUP();

        void aUQ();

        void rI(int i);

        void rJ(int i);
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$3 */
    class AnonymousClass3 implements f {
        final /* synthetic */ Runnable jzQ;
        final /* synthetic */ Runnable jzR;

        AnonymousClass3(Runnable runnable, Runnable runnable2) {
            this.jzQ = runnable;
            this.jzR = runnable2;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(17842);
            if (mVar != e.this.jzF) {
                ab.w("MicroMsg.BakPcProcessMgr", "last canceded scene");
                AppMethodBeat.o(17842);
                return;
            }
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.BakPcProcessMgr", "getPcPwd OK");
                com.tencent.mm.plugin.backup.bakoldlogic.c.e eVar = (com.tencent.mm.plugin.backup.bakoldlogic.c.e) mVar;
                a.aUB().jqU = eVar.jAn;
                this.jzQ.run();
            } else {
                e.this.ai(10010, new String("getPcPwd Fail"));
                ab.i("MicroMsg.BakPcProcessMgr", "getPcPwd Fail");
                this.jzR.run();
            }
            aw.Rg().b((int) j.CTRL_INDEX, (f) this);
            AppMethodBeat.o(17842);
        }
    }

    public interface a extends b {
        void aUO();
    }

    public interface b {
        void onError(int i);
    }

    public e() {
        AppMethodBeat.i(17843);
        AppMethodBeat.o(17843);
    }

    public final void cZ(String str, String str2) {
        this.jzI = str;
        this.jzJ = str2;
    }

    public final synchronized void fr(boolean z) {
        this.jzM = z;
    }

    public final synchronized boolean aUJ() {
        return this.jzM;
    }

    public final synchronized void aUK() {
        this.jzs = null;
        this.jzD.jzs = null;
        this.jzE.jzs = null;
    }

    public final synchronized void a(d dVar) {
        AppMethodBeat.i(17844);
        if (dVar == null && (this.jzs instanceof com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a)) {
            ab.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck BakchatBannerView null ilegal, fking return");
            AppMethodBeat.o(17844);
        } else {
            ab.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck:%s", dVar);
            this.jzs = dVar;
            this.jzD.jzs = dVar;
            this.jzE.jzs = dVar;
            AppMethodBeat.o(17844);
        }
    }

    public final void aSL() {
        AppMethodBeat.i(17845);
        if (this.jzE.jzV) {
            f fVar = this.jzE;
            ab.i("MicroMsg.RecoverPCServer", "startMerge");
            if (fVar.jsp) {
                ab.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
                AppMethodBeat.o(17845);
                return;
            }
            fVar.jzy = 0;
            a.aUB().aUC().jzL = 6;
            fVar.jsp = true;
            com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().a(new com.tencent.mm.plugin.backup.bakoldlogic.d.b.a() {
                public final void run() {
                    AppMethodBeat.i(17865);
                    f fVar = f.this;
                    int aT = f.aT(fVar.jzS);
                    ab.i("MicroMsg.RecoverPCServer", "all msg item Count : ".concat(String.valueOf(aT)));
                    ab.d("MicroMsg.RecoverPCServer", "readFromSdcard start");
                    d.a(new AnonymousClass5(aT), "RecoverPCServer_recoverFromSdcard", 1).start();
                    AppMethodBeat.o(17865);
                }
            });
            AppMethodBeat.o(17845);
            return;
        }
        ab.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
        AppMethodBeat.o(17845);
    }

    public final void pause() {
        AppMethodBeat.i(17846);
        if (this.jzH == 1) {
            this.jzD.pause();
            AppMethodBeat.o(17846);
            return;
        }
        if (this.jzH == 6) {
            this.jzE.pause();
        }
        AppMethodBeat.o(17846);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void ai(int i, String str) {
        AppMethodBeat.i(17847);
        ab.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", Integer.valueOf(i), str);
        if (i == 10006 || i == 10008) {
            ab.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
            this.jzK = -1;
            this.jzL = 1;
            aUN();
            a.aUB().aUD().jzk = 2;
            a.aUB().aUD().aar();
            if (this.jzA != null) {
                this.jzA.onError(i);
            }
            if (this.jzB != null) {
                this.jzB.onError(i);
            }
            if (this.jzs != null) {
                this.jzs.onError(i);
            }
            if (this.jzC != null) {
                this.jzC.onError(i);
            }
        }
        if (i == 10009 || i == 10004) {
            ab.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", Integer.valueOf(i));
            a.aUB().aUD().jzk = 2;
            a.aUB().aUD().aar();
            aUL();
            AppMethodBeat.o(17847);
        } else {
            ab.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", Integer.valueOf(i), this.jzB, this.jzs, this.jzA);
            if (i == 15) {
                if (this.jzB != null) {
                    this.jzB.onError(i);
                }
                if (this.jzs != null) {
                    this.jzs.onError(i);
                }
                if (this.jzA != null) {
                    this.jzA.rH(i);
                }
            }
            if (i == -1) {
                if (this.jzB != null) {
                    this.jzB.onError(i);
                    AppMethodBeat.o(17847);
                } else if (this.jzs != null) {
                    this.jzs.onError(i);
                    AppMethodBeat.o(17847);
                } else if (this.jzA != null) {
                    this.jzA.rH(i);
                }
            }
            AppMethodBeat.o(17847);
        }
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        AppMethodBeat.i(17848);
        if (z && bArr != null) {
            ai(i, new String(bArr));
        }
        if (i == 10001 || i == 10002) {
            a.aUB().aUD().jzk = 1;
            new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.aUB().jqP, a.aUB().jqQ, com.tencent.mm.plugin.backup.b.d.aSy(), a.aUB().jqO).aUc();
        }
        if (i == 3) {
            this.jzH = -1;
            com.tencent.mm.plugin.backup.i.ab abVar = new com.tencent.mm.plugin.backup.i.ab();
            try {
                abVar.parseFrom(bArr);
                ab.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", Integer.valueOf(abVar.jBh), rG(abVar.jBh));
                switch (abVar.jBh) {
                    case 0:
                        if (aw.RK()) {
                            this.jzH = abVar.jBh;
                            if (this.jzB != null) {
                                this.jzB.aUO();
                            } else {
                                ab.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
                                Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                                className.addFlags(335544320);
                                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                                className.putExtra("newPCBackup", false);
                                ah.getContext().startActivity(className);
                            }
                            this.jzK = 0;
                            this.jzL = 1;
                            AppMethodBeat.o(17848);
                            return;
                        }
                        ab.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
                        a(abVar.jBh, 1, null);
                        AppMethodBeat.o(17848);
                        return;
                    case 1:
                        a.aUB().aUE().aUF();
                        a.aUB().aUD().aar();
                        ai(-1, null);
                        ab.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
                        AppMethodBeat.o(17848);
                        return;
                    case 3:
                        this.jzL = 2;
                        this.jzK = 3;
                        aUN();
                        a(abVar.jBh, 0, null);
                        com.tencent.mm.sdk.g.d.h(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(17828);
                                d dVar = d.this;
                                dVar.jzy = 0;
                                dVar.jzt = new f() {
                                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                        AppMethodBeat.i(17829);
                                        ab.i("MicroMsg.BakPCServer", "onSceneEnd %s, %d, %d", ((c) mVar).jxp.jCx, Integer.valueOf(i), Integer.valueOf(i2));
                                        synchronized (d.this.lock) {
                                            try {
                                                d.this.jzr.remove(r14.jxp.jCx);
                                                ab.i("MicroMsg.BakPCServer", "onSceneEnd left: size:%d", Integer.valueOf(d.this.jzr.size()));
                                                if (d.this.jzr.size() <= 10) {
                                                    d.this.lock.notifyAll();
                                                }
                                            } catch (Throwable th) {
                                                while (true) {
                                                    AppMethodBeat.o(17829);
                                                }
                                            }
                                        }
                                        d dVar = d.this;
                                        dVar.jzy++;
                                        if (d.this.jzy % 100 == 0) {
                                            dVar = d.this;
                                            System.gc();
                                            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                                            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                                            ab.i("MicroMsg.BakPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(dVar.jzy));
                                        }
                                        d.this.aUI();
                                        AppMethodBeat.o(17829);
                                    }
                                };
                                b.a(5, dVar.jzt);
                                String str = (String) com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().Ry().get(2, null);
                                for (String str2 : dVar.jzq) {
                                    int i;
                                    ak aoZ = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().aUZ().XR().aoZ(str2);
                                    if (aoZ != null) {
                                        i = aoZ.field_unReadCount;
                                    } else {
                                        i = 0;
                                    }
                                    ab.i("MicroMsg.BakPCServer", "backupImp convName:%s, unReadCount:%d", str2, Integer.valueOf(i));
                                    if (!dVar.r(str2, str, i)) {
                                        ab.i("MicroMsg.BakPCServer", "backupImp.backupChatMsg canceled");
                                        AppMethodBeat.o(17828);
                                        return;
                                    }
                                }
                                dVar.jzu = true;
                                ab.i("MicroMsg.BakPCServer", "send conplete waiting to send finishCmd");
                                dVar.aUI();
                                AppMethodBeat.o(17828);
                            }
                        }, "BakPCServer_startBak").start();
                        AppMethodBeat.o(17848);
                        return;
                    case 4:
                        this.jzK = -1;
                        this.jzL = 1;
                        aUN();
                        a(abVar.jBh, 0, null);
                        if (this.jzF != null) {
                            this.jzF.cancel();
                            this.jzF = null;
                        }
                        if (this.jzD != null) {
                            this.jzD.cancel();
                        }
                        if (this.jzG != null) {
                            com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a aVar = this.jzG;
                            ab.i("MicroMsg.BakCalculator", "calculator cancel.");
                            ab.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", bo.dpG());
                            aVar.eVT = true;
                            this.jzG = null;
                        }
                        if (this.jzs != null) {
                            this.jzs.aUQ();
                            AppMethodBeat.o(17848);
                            return;
                        }
                        break;
                    case 6:
                        this.jzK = 5;
                        this.jzL = 4;
                        aUN();
                        this.jzH = abVar.jBh;
                        if (this.jzA != null) {
                            this.jzA.onEvent(abVar.jBh);
                        } else {
                            ab.i("MicroMsg.BakPcProcessMgr", "callback is null");
                        }
                        c aUD = a.aUB().aUD();
                        aUD.jzn++;
                        com.tencent.mm.plugin.backup.bakoldlogic.d.b.aUY().a(new com.tencent.mm.plugin.backup.bakoldlogic.d.b.a() {
                            public final void run() {
                                AppMethodBeat.i(17838);
                                s sVar = new s();
                                if (this.jBa) {
                                    sVar.jBP = this.dbSize;
                                    sVar.jCn = this.jBc - this.dbSize;
                                    sVar.jCm = this.jBb;
                                    e eVar = e.this;
                                    e.a(6, 0, sVar);
                                    com.tencent.mm.plugin.backup.g.b.a(3, new f() {
                                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                            AppMethodBeat.i(17841);
                                            com.tencent.mm.plugin.backup.g.b bVar = (com.tencent.mm.plugin.backup.g.b) mVar;
                                            if (i == 0 && i2 == 0) {
                                                if (mVar.getType() == 3) {
                                                    ac acVar = (ac) bVar.aTS();
                                                    if (acVar.jBh == 2) {
                                                        final r rVar = acVar.jCN;
                                                        AnonymousClass1 anonymousClass1 = new Runnable() {
                                                            public final void run() {
                                                                AppMethodBeat.i(17839);
                                                                e.this.a(rVar);
                                                                AppMethodBeat.o(17839);
                                                            }
                                                        };
                                                        AnonymousClass2 anonymousClass2 = new Runnable() {
                                                            public final void run() {
                                                                AppMethodBeat.i(17840);
                                                                e.rF(7);
                                                                AppMethodBeat.o(17840);
                                                            }
                                                        };
                                                        e eVar = e.this;
                                                        ab.i("MicroMsg.BakPcProcessMgr", "doGetBakchatKey id: %s", rVar.ID);
                                                        aw.Rg().a((int) j.CTRL_INDEX, new AnonymousClass3(anonymousClass1, anonymousClass2));
                                                        if (eVar.jzF != null) {
                                                            eVar.jzF.cancel();
                                                        }
                                                        eVar.jzF = new com.tencent.mm.plugin.backup.bakoldlogic.c.e(r0);
                                                        aw.Rg().a(eVar.jzF, 0);
                                                    }
                                                }
                                                com.tencent.mm.plugin.backup.g.b.b(3, this);
                                                AppMethodBeat.o(17841);
                                                return;
                                            }
                                            ab.e("MicroMsg.BakPcProcessMgr", "onSceneEnd:%d  err  [%d,%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                                            AppMethodBeat.o(17841);
                                        }
                                    });
                                    ab.i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                                    new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).aUc();
                                    AppMethodBeat.o(17838);
                                    return;
                                }
                                if (this.dbSize > this.jBc && this.jBc > 0) {
                                    sVar.jBP = this.dbSize;
                                    sVar.jCn = this.jBc - this.dbSize;
                                }
                                e.a(6, 14, sVar);
                                ab.e("MicroMsg.BakPcProcessMgr", "init TempDB error");
                                AppMethodBeat.o(17838);
                            }
                        });
                        AppMethodBeat.o(17848);
                        return;
                    case 7:
                        this.jzK = -1;
                        this.jzL = 1;
                        aUN();
                        a(abVar.jBh, 0, null);
                        if (this.jzF != null) {
                            this.jzF.cancel();
                            this.jzF = null;
                        }
                        if (this.jzE != null) {
                            this.jzE.cancel();
                        }
                        if (this.jzs != null) {
                            this.jzs.aUQ();
                            AppMethodBeat.o(17848);
                            return;
                        }
                        break;
                    case 9:
                        a(abVar.jBh, 0, null);
                        if (this.jzD != null) {
                            this.jzD.pause();
                            AppMethodBeat.o(17848);
                            return;
                        }
                        break;
                    case 10:
                        a(abVar.jBh, 0, null);
                        if (this.jzE != null) {
                            this.jzE.pause();
                            AppMethodBeat.o(17848);
                            return;
                        }
                        break;
                    case 11:
                        a(abVar.jBh, 0, null);
                        if (this.jzD != null) {
                            this.jzD.resume();
                            AppMethodBeat.o(17848);
                            return;
                        }
                        break;
                    case 12:
                        a(abVar.jBh, 0, null);
                        if (this.jzE != null) {
                            this.jzE.resume();
                            AppMethodBeat.o(17848);
                            return;
                        }
                        break;
                    case 15:
                        a.aUB().aUE().aUF();
                        a.aUB().aUD().aar();
                        ai(15, null);
                        AppMethodBeat.o(17848);
                        return;
                    case 16:
                        a(abVar.jBh, 0, null);
                        if (this.jzC != null) {
                            this.jzC.aUR();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(17848);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
            }
        }
        AppMethodBeat.o(17848);
    }

    public static void aUL() {
        AppMethodBeat.i(17849);
        Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_error_notification");
        ah.getContext().startActivity(className);
        AppMethodBeat.o(17849);
    }

    public final int aUM() {
        AppMethodBeat.i(17850);
        ab.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", Integer.valueOf(this.jzL));
        int i;
        if (this.jzL == 2 || this.jzL == 3) {
            i = this.jzD.jzx;
            AppMethodBeat.o(17850);
            return i;
        } else if (this.jzL == 4 || this.jzL == 5) {
            i = this.jzE.jzY;
            AppMethodBeat.o(17850);
            return i;
        } else if (this.jzL == 6 || this.jzL == 7) {
            i = this.jzE.jzU;
            AppMethodBeat.o(17850);
            return i;
        } else {
            ab.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
            AppMethodBeat.o(17850);
            return 0;
        }
    }

    public final void rE(int i) {
        AppMethodBeat.i(17851);
        if (i == 0) {
            this.jzK = 1;
        } else {
            this.jzK = -1;
        }
        ac acVar;
        if (i == 1) {
            acVar = new ac();
            acVar.jBh = 0;
            acVar.jBT = i;
            try {
                ab.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", Integer.valueOf(acVar.jBT));
                com.tencent.mm.plugin.backup.g.b.K(acVar.toByteArray(), 4);
                AppMethodBeat.o(17851);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
                AppMethodBeat.o(17851);
                return;
            }
        }
        q qVar = new q();
        qVar.jCe = 0;
        qVar.jCg = Build.MANUFACTURER;
        qVar.jBG = Build.MODEL;
        qVar.jCf = 0;
        qVar.jCh = VERSION.RELEASE;
        String str = com.tencent.mm.storage.ac.eSj;
        if (new File(com.tencent.mm.compatible.util.e.eSl).exists() && com.tencent.mm.compatible.util.f.Mn()) {
            File file = new File(com.tencent.mm.compatible.util.e.eSn);
            if (file.exists() || file.mkdirs()) {
                str = com.tencent.mm.compatible.util.e.eSn;
            }
        }
        qVar.jCd = str;
        qVar.jCc = com.tencent.mm.model.r.YB();
        qVar.jCb = com.tencent.mm.model.r.Yz();
        qVar.jCa = com.tencent.mm.protocal.d.vxo;
        try {
            PackageInfo packageInfo = ah.getContext().getPackageManager().getPackageInfo(ah.getContext().getPackageName(), 0);
            qVar.jCa = packageInfo.versionName + ";" + packageInfo.versionCode + ";" + com.tencent.mm.protocal.d.vxo;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e2, "get packageInfo failed", new Object[0]);
        }
        o.acd();
        Bitmap qf = com.tencent.mm.ah.d.qf(qVar.jCb);
        byte[] bArr = null;
        if (qf != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            qf.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception e3) {
                ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e3, "close", new Object[0]);
            }
        }
        o.acd();
        String D = com.tencent.mm.ah.d.D(qVar.jCb, true);
        String str2 = "MicroMsg.BakPcProcessMgr";
        String str3 = ", bmHDPath:%s, bm.buf.len:%d";
        Object[] objArr = new Object[2];
        objArr[0] = D;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        ab.i(str2, str3, objArr);
        if (!bo.cb(bArr)) {
            qVar.jCi = new com.tencent.mm.bt.b(bArr);
        }
        bArr = com.tencent.mm.a.e.f(D, 0, -1);
        if (!bo.cb(bArr)) {
            qVar.jCj = new com.tencent.mm.bt.b(bArr);
        }
        acVar = new ac();
        acVar.jBh = 0;
        acVar.jBT = i;
        acVar.jCL = qVar;
        try {
            ab.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", Integer.valueOf(acVar.jBT));
            com.tencent.mm.plugin.backup.g.b.K(acVar.toByteArray(), 4);
            AppMethodBeat.o(17851);
        } catch (Exception e22) {
            ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e22, "buf to PacketCommandResponse err", new Object[0]);
            AppMethodBeat.o(17851);
        }
    }

    public static void a(int i, int i2, s sVar) {
        AppMethodBeat.i(17852);
        ac acVar = new ac();
        acVar.jBh = i;
        acVar.jBT = i2;
        acVar.jCO = sVar;
        try {
            ab.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", Integer.valueOf(i2), Integer.valueOf(i), rG(i));
            com.tencent.mm.plugin.backup.g.b.K(acVar.toByteArray(), 4);
            AppMethodBeat.o(17852);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
            AppMethodBeat.o(17852);
        }
    }

    public static void rF(int i) {
        AppMethodBeat.i(17853);
        com.tencent.mm.plugin.backup.i.ab abVar = new com.tencent.mm.plugin.backup.i.ab();
        abVar.jBh = i;
        try {
            ab.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", Integer.valueOf(i), rG(i));
            com.tencent.mm.plugin.backup.g.b.K(abVar.toByteArray(), 3);
            AppMethodBeat.o(17853);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandRequest err", new Object[0]);
            AppMethodBeat.o(17853);
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void a(r rVar) {
        AppMethodBeat.i(17854);
        if (this.jzE != null) {
            this.jzE.cancel();
        }
        this.jzE = new f();
        f fVar = this.jzE;
        LinkedList linkedList = rVar.jCk;
        LinkedList linkedList2 = rVar.jCl;
        long j = rVar.jBS;
        fVar.jzS = linkedList;
        fVar.jzT = linkedList2;
        fVar.cAY = false;
        fVar.eVT = false;
        fVar.jzr.clear();
        fVar.jzu = false;
        fVar.jzV = false;
        fVar.jsp = false;
        fVar.jzU = 0;
        fVar.jzX = 0;
        fVar.jzW = j;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(0);
        this.jzE.jzs = this.jzs;
        ab.i("MicroMsg.BakPcProcessMgr", "reve textList:%d,  mediaList:%d, convDataSize:%d", Integer.valueOf(rVar.jCk.size()), Integer.valueOf(rVar.jCl.size()), Long.valueOf(rVar.jBS));
        fVar = this.jzE;
        fVar.jzy = 0;
        if (fVar.jzT.size() < rVar.jBX || fVar.jzS.size() < rVar.jBW) {
            com.tencent.mm.plugin.backup.g.b.a(3, new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(17863);
                    ac acVar = (ac) ((b) mVar).aTS();
                    if (acVar.jBh != 2) {
                        AppMethodBeat.o(17863);
                        return;
                    }
                    r rVar = acVar.jCN;
                    f.this.jzT.addAll(rVar.jCl);
                    f.this.jzS.addAll(rVar.jCk);
                    ab.i("MicroMsg.RecoverPCServer", "MediaSize:[%d / %d], digestSize: [%d / %d]", Integer.valueOf(f.this.jzT.size()), Integer.valueOf(f.this.jzS.size()), Integer.valueOf(rVar.jBX), Integer.valueOf(rVar.jBW));
                    if (f.this.jzT.size() < rVar.jBX || f.this.jzS.size() < rVar.jBW) {
                        ab.i("MicroMsg.RecoverPCServer", "send restore info cmd again~");
                        new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).aUc();
                        AppMethodBeat.o(17863);
                        return;
                    }
                    f.this.jzW = rVar.jBS;
                    ab.i("MicroMsg.RecoverPCServer", "down RestoreInfo complete, convDataSize:%d", Long.valueOf(f.this.jzW));
                    b.b(3, this);
                    d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(17862);
                            f.a(f.this);
                            AppMethodBeat.o(17862);
                        }
                    }, "RecoverPCServer_recover_getIDList");
                    AppMethodBeat.o(17863);
                }
            });
            ab.i("MicroMsg.RecoverPCServer", "send restore info cmd");
            new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).aUc();
            AppMethodBeat.o(17854);
        } else {
            ab.i("MicroMsg.RecoverPCServer", "startRecover start directly");
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(17861);
                    f.a(f.this);
                    AppMethodBeat.o(17861);
                }
            }, "RecoverPCServer_recover");
            AppMethodBeat.o(17854);
        }
    }

    public static void aUN() {
        AppMethodBeat.i(17855);
        com.tencent.mm.sdk.b.a.xxA.m(new md());
        AppMethodBeat.o(17855);
    }

    private static String rG(int i) {
        AppMethodBeat.i(17856);
        String str;
        switch (i) {
            case -1:
                str = "COMMAND_NOT_SUPPORT";
                AppMethodBeat.o(17856);
                return str;
            case 0:
                str = "AUTHORIZE";
                AppMethodBeat.o(17856);
                return str;
            case 1:
                str = "BACKUP_INFO";
                AppMethodBeat.o(17856);
                return str;
            case 2:
                str = "RESTORE_INFO";
                AppMethodBeat.o(17856);
                return str;
            case 3:
                str = "BACKUP_START";
                AppMethodBeat.o(17856);
                return str;
            case 4:
                str = "BACKUP_CANCEL";
                AppMethodBeat.o(17856);
                return str;
            case 5:
                str = "BACKUP_FINISH";
                AppMethodBeat.o(17856);
                return str;
            case 6:
                str = "RESTORE_START";
                AppMethodBeat.o(17856);
                return str;
            case 7:
                str = "RESTORE_CANCE";
                AppMethodBeat.o(17856);
                return str;
            case 8:
                str = "RESTORE_FINISH";
                AppMethodBeat.o(17856);
                return str;
            case 9:
                str = "BACKUP_PAUSE";
                AppMethodBeat.o(17856);
                return str;
            case 10:
                str = "RESTORE_PAUSE";
                AppMethodBeat.o(17856);
                return str;
            case 11:
                str = "BACKUP_RESUME";
                AppMethodBeat.o(17856);
                return str;
            case 12:
                str = "RESTORE_RESUME";
                AppMethodBeat.o(17856);
                return str;
            case 13:
                str = "MERGE_PROGRESS";
                AppMethodBeat.o(17856);
                return str;
            case 14:
                str = "LOGOFF";
                AppMethodBeat.o(17856);
                return str;
            case 15:
                str = "EXIT";
                AppMethodBeat.o(17856);
                return str;
            case 16:
                str = "SHOW_BACKUP_RESTORE";
                AppMethodBeat.o(17856);
                return str;
            case 17:
                str = "COMMAND_WECHAT_LEAVE";
                AppMethodBeat.o(17856);
                return str;
            default:
                str = String.valueOf(i);
                AppMethodBeat.o(17856);
                return str;
        }
    }
}
