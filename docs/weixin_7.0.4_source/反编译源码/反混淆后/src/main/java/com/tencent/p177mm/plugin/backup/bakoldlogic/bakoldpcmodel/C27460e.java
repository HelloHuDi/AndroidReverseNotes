package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C42024md;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42478j;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldmodel.C42763a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27456d.C199611;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27463f.C199641;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27463f.C274642;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27463f.C274674;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcui.C27473a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C2645d;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C42767b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C45739a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C6790e;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b.C11125a;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C19978b.C19977d;
import com.tencent.p177mm.plugin.backup.p921i.C33707ac;
import com.tencent.p177mm.plugin.backup.p921i.C38659ab;
import com.tencent.p177mm.plugin.backup.p921i.C38664r;
import com.tencent.p177mm.plugin.backup.p921i.C42778q;
import com.tencent.p177mm.plugin.backup.p921i.C45753s;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e */
public final class C27460e implements C19977d {
    public C11115c jzA;
    public C27461a jzB;
    public C2643e jzC;
    public C27456d jzD = new C27456d();
    public C27463f jzE = new C27463f();
    C6790e jzF;
    private C42763a jzG;
    public int jzH = -1;
    public String jzI;
    public String jzJ;
    public int jzK = -1;
    public int jzL = 1;
    private boolean jzM = false;
    private C11116d jzs;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$e */
    public interface C2643e extends C27462b {
        void aUR();
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$c */
    public interface C11115c extends C27462b {
        void onEvent(int i);

        /* renamed from: rH */
        void mo22815rH(int i);
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$d */
    public interface C11116d extends C27462b {
        void aSt();

        void aUP();

        void aUQ();

        /* renamed from: rI */
        void mo22819rI(int i);

        /* renamed from: rJ */
        void mo22820rJ(int i);
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$1 */
    class C199621 extends C11125a {
        C199621() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17838);
            C45753s c45753s = new C45753s();
            if (this.jBa) {
                c45753s.jBP = this.dbSize;
                c45753s.jCn = this.jBc - this.dbSize;
                c45753s.jCm = this.jBb;
                C27460e c27460e = C27460e.this;
                C27460e.m43572a(6, 0, c45753s);
                C19978b.m30879a(3, new C274592());
                C4990ab.m7416i("MicroMsg.BakPcProcessMgr", "send restore info cmd");
                new C42767b(2).aUc();
                AppMethodBeat.m2505o(17838);
                return;
            }
            if (this.dbSize > this.jBc && this.jBc > 0) {
                c45753s.jBP = this.dbSize;
                c45753s.jCn = this.jBc - this.dbSize;
            }
            C27460e.m43572a(6, 14, c45753s);
            C4990ab.m7412e("MicroMsg.BakPcProcessMgr", "init TempDB error");
            AppMethodBeat.m2505o(17838);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$3 */
    class C199633 implements C1202f {
        final /* synthetic */ Runnable jzQ;
        final /* synthetic */ Runnable jzR;

        C199633(Runnable runnable, Runnable runnable2) {
            this.jzQ = runnable;
            this.jzR = runnable2;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17842);
            if (c1207m != C27460e.this.jzF) {
                C4990ab.m7420w("MicroMsg.BakPcProcessMgr", "last canceded scene");
                AppMethodBeat.m2505o(17842);
                return;
            }
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.BakPcProcessMgr", "getPcPwd OK");
                C6790e c6790e = (C6790e) c1207m;
                C41257a.aUB().jqU = c6790e.jAn;
                this.jzQ.run();
            } else {
                C27460e.this.mo45244ai(10010, new String("getPcPwd Fail"));
                C4990ab.m7416i("MicroMsg.BakPcProcessMgr", "getPcPwd Fail");
                this.jzR.run();
            }
            C9638aw.m17182Rg().mo14546b((int) C42478j.CTRL_INDEX, (C1202f) this);
            AppMethodBeat.m2505o(17842);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$2 */
    class C274592 implements C1202f {

        /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$2$2 */
        class C274582 implements Runnable {
            C274582() {
            }

            public final void run() {
                AppMethodBeat.m2504i(17840);
                C27460e.m43573rF(7);
                AppMethodBeat.m2505o(17840);
            }
        }

        C274592() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(17841);
            C19978b c19978b = (C19978b) c1207m;
            if (i == 0 && i2 == 0) {
                if (c1207m.getType() == 3) {
                    C33707ac c33707ac = (C33707ac) c19978b.aTS();
                    if (c33707ac.jBh == 2) {
                        final C38664r c38664r = c33707ac.jCN;
                        C274571 c274571 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(17839);
                                C27460e.this.mo45239a(c38664r);
                                AppMethodBeat.m2505o(17839);
                            }
                        };
                        C274582 c274582 = new C274582();
                        C27460e c27460e = C27460e.this;
                        C4990ab.m7417i("MicroMsg.BakPcProcessMgr", "doGetBakchatKey id: %s", c38664r.f16158ID);
                        C9638aw.m17182Rg().mo14539a((int) C42478j.CTRL_INDEX, new C199633(c274571, c274582));
                        if (c27460e.jzF != null) {
                            c27460e.jzF.cancel();
                        }
                        c27460e.jzF = new C6790e(r0);
                        C9638aw.m17182Rg().mo14541a(c27460e.jzF, 0);
                    }
                }
                C19978b.m30886b(3, this);
                AppMethodBeat.m2505o(17841);
                return;
            }
            C4990ab.m7413e("MicroMsg.BakPcProcessMgr", "onSceneEnd:%d  err  [%d,%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(17841);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$a */
    public interface C27461a extends C27462b {
        void aUO();
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$b */
    public interface C27462b {
        void onError(int i);
    }

    public C27460e() {
        AppMethodBeat.m2504i(17843);
        AppMethodBeat.m2505o(17843);
    }

    /* renamed from: cZ */
    public final void mo45245cZ(String str, String str2) {
        this.jzI = str;
        this.jzJ = str2;
    }

    /* renamed from: fr */
    public final synchronized void mo45246fr(boolean z) {
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

    /* renamed from: a */
    public final synchronized void mo45238a(C11116d c11116d) {
        AppMethodBeat.m2504i(17844);
        if (c11116d == null && (this.jzs instanceof C27473a)) {
            C4990ab.m7410d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck BakchatBannerView null ilegal, fking return");
            AppMethodBeat.m2505o(17844);
        } else {
            C4990ab.m7411d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck:%s", c11116d);
            this.jzs = c11116d;
            this.jzD.jzs = c11116d;
            this.jzE.jzs = c11116d;
            AppMethodBeat.m2505o(17844);
        }
    }

    public final void aSL() {
        AppMethodBeat.m2504i(17845);
        if (this.jzE.jzV) {
            C27463f c27463f = this.jzE;
            C4990ab.m7416i("MicroMsg.RecoverPCServer", "startMerge");
            if (c27463f.jsp) {
                C4990ab.m7416i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
                AppMethodBeat.m2505o(17845);
                return;
            }
            c27463f.jzy = 0;
            C41257a.aUB().aUC().jzL = 6;
            c27463f.jsp = true;
            C11124b.aUY().mo22827a(new C274674());
            AppMethodBeat.m2505o(17845);
            return;
        }
        C4990ab.m7412e("MicroMsg.BakPcProcessMgr", "startMerge err state");
        AppMethodBeat.m2505o(17845);
    }

    public final void pause() {
        AppMethodBeat.m2504i(17846);
        if (this.jzH == 1) {
            this.jzD.pause();
            AppMethodBeat.m2505o(17846);
            return;
        }
        if (this.jzH == 6) {
            this.jzE.pause();
        }
        AppMethodBeat.m2505o(17846);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: ai */
    public final synchronized void mo45244ai(int i, String str) {
        AppMethodBeat.m2504i(17847);
        C4990ab.m7413e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", Integer.valueOf(i), str);
        if (i == 10006 || i == 10008) {
            C4990ab.m7412e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
            this.jzK = -1;
            this.jzL = 1;
            C27460e.aUN();
            C41257a.aUB().aUD().jzk = 2;
            C41257a.aUB().aUD().aar();
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
            C4990ab.m7413e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", Integer.valueOf(i));
            C41257a.aUB().aUD().jzk = 2;
            C41257a.aUB().aUD().aar();
            C27460e.aUL();
            AppMethodBeat.m2505o(17847);
        } else {
            C4990ab.m7411d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", Integer.valueOf(i), this.jzB, this.jzs, this.jzA);
            if (i == 15) {
                if (this.jzB != null) {
                    this.jzB.onError(i);
                }
                if (this.jzs != null) {
                    this.jzs.onError(i);
                }
                if (this.jzA != null) {
                    this.jzA.mo22815rH(i);
                }
            }
            if (i == -1) {
                if (this.jzB != null) {
                    this.jzB.onError(i);
                    AppMethodBeat.m2505o(17847);
                } else if (this.jzs != null) {
                    this.jzs.onError(i);
                    AppMethodBeat.m2505o(17847);
                } else if (this.jzA != null) {
                    this.jzA.mo22815rH(i);
                }
            }
            AppMethodBeat.m2505o(17847);
        }
    }

    /* renamed from: a */
    public final void mo6669a(boolean z, int i, byte[] bArr, int i2) {
        AppMethodBeat.m2504i(17848);
        if (z && bArr != null) {
            mo45244ai(i, new String(bArr));
        }
        if (i == 10001 || i == 10002) {
            C41257a.aUB().aUD().jzk = 1;
            new C45739a(C41257a.aUB().jqP, C41257a.aUB().jqQ, C38634d.aSy(), C41257a.aUB().jqO).aUc();
        }
        if (i == 3) {
            this.jzH = -1;
            C38659ab c38659ab = new C38659ab();
            try {
                c38659ab.parseFrom(bArr);
                C4990ab.m7417i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", Integer.valueOf(c38659ab.jBh), C27460e.m43574rG(c38659ab.jBh));
                switch (c38659ab.jBh) {
                    case 0:
                        if (C9638aw.m17179RK()) {
                            this.jzH = c38659ab.jBh;
                            if (this.jzB != null) {
                                this.jzB.aUO();
                            } else {
                                C4990ab.m7416i("MicroMsg.BakPcProcessMgr", "authCallback is null");
                                Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                                className.addFlags(335544320);
                                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                                className.putExtra("newPCBackup", false);
                                C4996ah.getContext().startActivity(className);
                            }
                            this.jzK = 0;
                            this.jzL = 1;
                            AppMethodBeat.m2505o(17848);
                            return;
                        }
                        C4990ab.m7420w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
                        C27460e.m43572a(c38659ab.jBh, 1, null);
                        AppMethodBeat.m2505o(17848);
                        return;
                    case 1:
                        C41257a.aUB().aUE().aUF();
                        C41257a.aUB().aUD().aar();
                        mo45244ai(-1, null);
                        C4990ab.m7412e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
                        AppMethodBeat.m2505o(17848);
                        return;
                    case 3:
                        this.jzL = 2;
                        this.jzK = 3;
                        C27460e.aUN();
                        C27460e.m43572a(c38659ab.jBh, 0, null);
                        C7305d.m12301h(new C199611(), "BakPCServer_startBak").start();
                        AppMethodBeat.m2505o(17848);
                        return;
                    case 4:
                        this.jzK = -1;
                        this.jzL = 1;
                        C27460e.aUN();
                        C27460e.m43572a(c38659ab.jBh, 0, null);
                        if (this.jzF != null) {
                            this.jzF.cancel();
                            this.jzF = null;
                        }
                        if (this.jzD != null) {
                            this.jzD.cancel();
                        }
                        if (this.jzG != null) {
                            C42763a c42763a = this.jzG;
                            C4990ab.m7416i("MicroMsg.BakCalculator", "calculator cancel.");
                            C4990ab.m7411d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", C5046bo.dpG());
                            c42763a.eVT = true;
                            this.jzG = null;
                        }
                        if (this.jzs != null) {
                            this.jzs.aUQ();
                            AppMethodBeat.m2505o(17848);
                            return;
                        }
                        break;
                    case 6:
                        this.jzK = 5;
                        this.jzL = 4;
                        C27460e.aUN();
                        this.jzH = c38659ab.jBh;
                        if (this.jzA != null) {
                            this.jzA.onEvent(c38659ab.jBh);
                        } else {
                            C4990ab.m7416i("MicroMsg.BakPcProcessMgr", "callback is null");
                        }
                        C38643c aUD = C41257a.aUB().aUD();
                        aUD.jzn++;
                        C11124b.aUY().mo22827a(new C199621());
                        AppMethodBeat.m2505o(17848);
                        return;
                    case 7:
                        this.jzK = -1;
                        this.jzL = 1;
                        C27460e.aUN();
                        C27460e.m43572a(c38659ab.jBh, 0, null);
                        if (this.jzF != null) {
                            this.jzF.cancel();
                            this.jzF = null;
                        }
                        if (this.jzE != null) {
                            this.jzE.cancel();
                        }
                        if (this.jzs != null) {
                            this.jzs.aUQ();
                            AppMethodBeat.m2505o(17848);
                            return;
                        }
                        break;
                    case 9:
                        C27460e.m43572a(c38659ab.jBh, 0, null);
                        if (this.jzD != null) {
                            this.jzD.pause();
                            AppMethodBeat.m2505o(17848);
                            return;
                        }
                        break;
                    case 10:
                        C27460e.m43572a(c38659ab.jBh, 0, null);
                        if (this.jzE != null) {
                            this.jzE.pause();
                            AppMethodBeat.m2505o(17848);
                            return;
                        }
                        break;
                    case 11:
                        C27460e.m43572a(c38659ab.jBh, 0, null);
                        if (this.jzD != null) {
                            this.jzD.resume();
                            AppMethodBeat.m2505o(17848);
                            return;
                        }
                        break;
                    case 12:
                        C27460e.m43572a(c38659ab.jBh, 0, null);
                        if (this.jzE != null) {
                            this.jzE.resume();
                            AppMethodBeat.m2505o(17848);
                            return;
                        }
                        break;
                    case 15:
                        C41257a.aUB().aUE().aUF();
                        C41257a.aUB().aUD().aar();
                        mo45244ai(15, null);
                        AppMethodBeat.m2505o(17848);
                        return;
                    case 16:
                        C27460e.m43572a(c38659ab.jBh, 0, null);
                        if (this.jzC != null) {
                            this.jzC.aUR();
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(17848);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(17848);
    }

    public static void aUL() {
        AppMethodBeat.m2504i(17849);
        Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_error_notification");
        C4996ah.getContext().startActivity(className);
        AppMethodBeat.m2505o(17849);
    }

    public final int aUM() {
        AppMethodBeat.m2504i(17850);
        C4990ab.m7417i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", Integer.valueOf(this.jzL));
        int i;
        if (this.jzL == 2 || this.jzL == 3) {
            i = this.jzD.jzx;
            AppMethodBeat.m2505o(17850);
            return i;
        } else if (this.jzL == 4 || this.jzL == 5) {
            i = this.jzE.jzY;
            AppMethodBeat.m2505o(17850);
            return i;
        } else if (this.jzL == 6 || this.jzL == 7) {
            i = this.jzE.jzU;
            AppMethodBeat.m2505o(17850);
            return i;
        } else {
            C4990ab.m7420w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
            AppMethodBeat.m2505o(17850);
            return 0;
        }
    }

    /* renamed from: rE */
    public final void mo45248rE(int i) {
        AppMethodBeat.m2504i(17851);
        if (i == 0) {
            this.jzK = 1;
        } else {
            this.jzK = -1;
        }
        C33707ac c33707ac;
        if (i == 1) {
            c33707ac = new C33707ac();
            c33707ac.jBh = 0;
            c33707ac.jBT = i;
            try {
                C4990ab.m7417i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", Integer.valueOf(c33707ac.jBT));
                C19978b.m30877K(c33707ac.toByteArray(), 4);
                AppMethodBeat.m2505o(17851);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
                AppMethodBeat.m2505o(17851);
                return;
            }
        }
        C42778q c42778q = new C42778q();
        c42778q.jCe = 0;
        c42778q.jCg = Build.MANUFACTURER;
        c42778q.jBG = Build.MODEL;
        c42778q.jCf = 0;
        c42778q.jCh = VERSION.RELEASE;
        String str = C5128ac.eSj;
        if (new File(C6457e.eSl).exists() && C1445f.m3070Mn()) {
            File file = new File(C6457e.eSn);
            if (file.exists() || file.mkdirs()) {
                str = C6457e.eSn;
            }
        }
        c42778q.jCd = str;
        c42778q.jCc = C1853r.m3820YB();
        c42778q.jCb = C1853r.m3846Yz();
        c42778q.jCa = C7243d.vxo;
        try {
            PackageInfo packageInfo = C4996ah.getContext().getPackageManager().getPackageInfo(C4996ah.getContext().getPackageName(), 0);
            c42778q.jCa = packageInfo.versionName + ";" + packageInfo.versionCode + ";" + C7243d.vxo;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e2, "get packageInfo failed", new Object[0]);
        }
        C17884o.acd();
        Bitmap qf = C41732d.m73525qf(c42778q.jCb);
        byte[] bArr = null;
        if (qf != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            qf.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception e3) {
                C4990ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e3, "close", new Object[0]);
            }
        }
        C17884o.acd();
        String D = C41732d.m73515D(c42778q.jCb, true);
        String str2 = "MicroMsg.BakPcProcessMgr";
        String str3 = ", bmHDPath:%s, bm.buf.len:%d";
        Object[] objArr = new Object[2];
        objArr[0] = D;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        C4990ab.m7417i(str2, str3, objArr);
        if (!C5046bo.m7540cb(bArr)) {
            c42778q.jCi = new C1332b(bArr);
        }
        bArr = C1173e.m2571f(D, 0, -1);
        if (!C5046bo.m7540cb(bArr)) {
            c42778q.jCj = new C1332b(bArr);
        }
        c33707ac = new C33707ac();
        c33707ac.jBh = 0;
        c33707ac.jBT = i;
        c33707ac.jCL = c42778q;
        try {
            C4990ab.m7417i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", Integer.valueOf(c33707ac.jBT));
            C19978b.m30877K(c33707ac.toByteArray(), 4);
            AppMethodBeat.m2505o(17851);
        } catch (Exception e22) {
            C4990ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e22, "buf to PacketCommandResponse err", new Object[0]);
            AppMethodBeat.m2505o(17851);
        }
    }

    /* renamed from: a */
    public static void m43572a(int i, int i2, C45753s c45753s) {
        AppMethodBeat.m2504i(17852);
        C33707ac c33707ac = new C33707ac();
        c33707ac.jBh = i;
        c33707ac.jBT = i2;
        c33707ac.jCO = c45753s;
        try {
            C4990ab.m7417i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", Integer.valueOf(i2), Integer.valueOf(i), C27460e.m43574rG(i));
            C19978b.m30877K(c33707ac.toByteArray(), 4);
            AppMethodBeat.m2505o(17852);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
            AppMethodBeat.m2505o(17852);
        }
    }

    /* renamed from: rF */
    public static void m43573rF(int i) {
        AppMethodBeat.m2504i(17853);
        C38659ab c38659ab = new C38659ab();
        c38659ab.jBh = i;
        try {
            C4990ab.m7417i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", Integer.valueOf(i), C27460e.m43574rG(i));
            C19978b.m30877K(c38659ab.toByteArray(), 3);
            AppMethodBeat.m2505o(17853);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandRequest err", new Object[0]);
            AppMethodBeat.m2505o(17853);
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo45239a(C38664r c38664r) {
        AppMethodBeat.m2504i(17854);
        if (this.jzE != null) {
            this.jzE.cancel();
        }
        this.jzE = new C27463f();
        C27463f c27463f = this.jzE;
        LinkedList linkedList = c38664r.jCk;
        LinkedList linkedList2 = c38664r.jCl;
        long j = c38664r.jBS;
        c27463f.jzS = linkedList;
        c27463f.jzT = linkedList2;
        c27463f.cAY = false;
        c27463f.eVT = false;
        c27463f.jzr.clear();
        c27463f.jzu = false;
        c27463f.jzV = false;
        c27463f.jsp = false;
        c27463f.jzU = 0;
        c27463f.jzX = 0;
        c27463f.jzW = j;
        C2645d.setProgress(0);
        this.jzE.jzs = this.jzs;
        C4990ab.m7417i("MicroMsg.BakPcProcessMgr", "reve textList:%d,  mediaList:%d, convDataSize:%d", Integer.valueOf(c38664r.jCk.size()), Integer.valueOf(c38664r.jCl.size()), Long.valueOf(c38664r.jBS));
        c27463f = this.jzE;
        c27463f.jzy = 0;
        if (c27463f.jzT.size() < c38664r.jBX || c27463f.jzS.size() < c38664r.jBW) {
            C19978b.m30879a(3, new C274642());
            C4990ab.m7416i("MicroMsg.RecoverPCServer", "send restore info cmd");
            new C42767b(2).aUc();
            AppMethodBeat.m2505o(17854);
        } else {
            C4990ab.m7416i("MicroMsg.RecoverPCServer", "startRecover start directly");
            C7305d.post(new C199641(), "RecoverPCServer_recover");
            AppMethodBeat.m2505o(17854);
        }
    }

    public static void aUN() {
        AppMethodBeat.m2504i(17855);
        C4879a.xxA.mo10055m(new C42024md());
        AppMethodBeat.m2505o(17855);
    }

    /* renamed from: rG */
    private static String m43574rG(int i) {
        AppMethodBeat.m2504i(17856);
        String str;
        switch (i) {
            case -1:
                str = "COMMAND_NOT_SUPPORT";
                AppMethodBeat.m2505o(17856);
                return str;
            case 0:
                str = "AUTHORIZE";
                AppMethodBeat.m2505o(17856);
                return str;
            case 1:
                str = "BACKUP_INFO";
                AppMethodBeat.m2505o(17856);
                return str;
            case 2:
                str = "RESTORE_INFO";
                AppMethodBeat.m2505o(17856);
                return str;
            case 3:
                str = "BACKUP_START";
                AppMethodBeat.m2505o(17856);
                return str;
            case 4:
                str = "BACKUP_CANCEL";
                AppMethodBeat.m2505o(17856);
                return str;
            case 5:
                str = "BACKUP_FINISH";
                AppMethodBeat.m2505o(17856);
                return str;
            case 6:
                str = "RESTORE_START";
                AppMethodBeat.m2505o(17856);
                return str;
            case 7:
                str = "RESTORE_CANCE";
                AppMethodBeat.m2505o(17856);
                return str;
            case 8:
                str = "RESTORE_FINISH";
                AppMethodBeat.m2505o(17856);
                return str;
            case 9:
                str = "BACKUP_PAUSE";
                AppMethodBeat.m2505o(17856);
                return str;
            case 10:
                str = "RESTORE_PAUSE";
                AppMethodBeat.m2505o(17856);
                return str;
            case 11:
                str = "BACKUP_RESUME";
                AppMethodBeat.m2505o(17856);
                return str;
            case 12:
                str = "RESTORE_RESUME";
                AppMethodBeat.m2505o(17856);
                return str;
            case 13:
                str = "MERGE_PROGRESS";
                AppMethodBeat.m2505o(17856);
                return str;
            case 14:
                str = "LOGOFF";
                AppMethodBeat.m2505o(17856);
                return str;
            case 15:
                str = "EXIT";
                AppMethodBeat.m2505o(17856);
                return str;
            case 16:
                str = "SHOW_BACKUP_RESTORE";
                AppMethodBeat.m2505o(17856);
                return str;
            case 17:
                str = "COMMAND_WECHAT_LEAVE";
                AppMethodBeat.m2505o(17856);
                return str;
            default:
                str = String.valueOf(i);
                AppMethodBeat.m2505o(17856);
                return str;
        }
    }
}
