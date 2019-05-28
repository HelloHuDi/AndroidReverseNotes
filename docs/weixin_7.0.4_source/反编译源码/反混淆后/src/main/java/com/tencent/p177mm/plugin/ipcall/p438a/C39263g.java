package com.tencent.p177mm.plugin.ipcall.p438a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.C27141z;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C21077d;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43218a.C28323a;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43219c;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C44747b.C28324a;
import com.tencent.p177mm.plugin.ipcall.p438a.p440c.C3304a;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C39257o;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C46033n;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C6949a;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C6950h;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C6951i;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C6952k;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C12253f;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C21081d;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C28330e;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C28331g;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C39261h;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C44748a;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C44844c;
import com.tencent.p177mm.plugin.ipcall.p438a.p982f.C46036i;
import com.tencent.p177mm.protocal.protobuf.bmb;
import com.tencent.p177mm.protocal.protobuf.bmc;
import com.tencent.p177mm.protocal.protobuf.bme;
import com.tencent.p177mm.protocal.protobuf.bmk;
import com.tencent.p177mm.protocal.protobuf.bml;
import com.tencent.p177mm.protocal.protobuf.cok;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g */
public final class C39263g implements C28323a, C28324a {
    public boolean cJn = false;
    public int nvA = 0;
    public int nvB = 0;
    public boolean nvC = false;
    public boolean nvD = false;
    public C34377a nvE;
    public C21081d nvF = new C21081d();
    C46036i nvG = new C46036i();
    C44748a nvH = new C44748a();
    C39261h nvI = new C39261h();
    C44844c nvJ = new C44844c();
    public C28330e nvK = new C28330e();
    C28331g nvL = new C28331g();
    C12253f nvM = new C12253f();
    public C43219c nvN;
    public boolean nvO = false;
    public boolean nvP = false;
    C1923n nvQ = new C392641();
    public int nvz = 0;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.g$a */
    public interface C34377a {
        /* renamed from: A */
        void mo46248A(String str, String str2, int i);

        /* renamed from: B */
        void mo46249B(String str, String str2, int i);

        /* renamed from: C */
        void mo46250C(String str, String str2, int i);

        /* renamed from: D */
        void mo46251D(String str, String str2, int i);

        void bGJ();

        void bGK();

        void bGL();

        void bGM();

        void bGN();

        void bGO();

        /* renamed from: cn */
        void mo46262cn(String str, int i);

        /* renamed from: co */
        void mo46263co(String str, int i);

        /* renamed from: cp */
        void mo46264cp(String str, int i);
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.a.g$1 */
    class C392641 extends C1924a {
        C392641() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(21743);
            C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", Integer.valueOf(i));
            if (C21088i.bHr().nxA) {
                C46037f bHu = C21088i.bHu();
                if (bHu.mCurrentState == 4 || bHu.mCurrentState == 5) {
                    i2 = 1;
                }
                if (!(i2 == 0 || i != 4 || C39263g.this.nvM == null)) {
                    C39263g.this.nvM.mo68722a(C39263g.this.nvN);
                }
            }
            AppMethodBeat.m2505o(21743);
        }
    }

    public C39263g() {
        AppMethodBeat.m2504i(21744);
        AppMethodBeat.m2505o(21744);
    }

    public final void bHo() {
        AppMethodBeat.m2504i(21745);
        if (this.nvN.nwZ) {
            C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
        }
        this.nvC = true;
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(this.nvN.nwx));
        this.nvJ.stop();
        this.nvG.stop();
        this.nvH.mo68722a(this.nvN);
        this.nvL.mo68722a(this.nvN);
        AppMethodBeat.m2505o(21745);
    }

    /* renamed from: xi */
    public final void mo62160xi(int i) {
        AppMethodBeat.m2504i(21746);
        if (!this.nvN.nwZ) {
            C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
        }
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(this.nvN.nwx));
        this.nvD = true;
        this.nvJ.stop();
        this.nvG.stop();
        this.nvI.nzs = false;
        this.nvI.nzr = i;
        this.nvI.mo68722a(this.nvN);
        this.nvL.mo68722a(this.nvN);
        AppMethodBeat.m2505o(21746);
    }

    /* renamed from: ij */
    private void m66914ij(boolean z) {
        AppMethodBeat.m2504i(21747);
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", Boolean.valueOf(z), Boolean.valueOf(this.nvC), Boolean.valueOf(this.nvD));
        if (this.nvC || this.nvD) {
            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
            AppMethodBeat.m2505o(21747);
        } else if (z) {
            if (this.nvE != null) {
                if (this.nvN.nwJ) {
                    this.nvE.bGJ();
                } else {
                    this.nvE.bGO();
                }
            }
            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "start sync");
            this.nvG.mo68722a(this.nvN);
            AppMethodBeat.m2505o(21747);
        } else {
            if (this.nvE != null) {
                if (this.nvN.nwG) {
                    this.nvE.mo46249B(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                    AppMethodBeat.m2505o(21747);
                    return;
                } else if (this.nvN.nwH) {
                    this.nvE.mo46250C(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                    AppMethodBeat.m2505o(21747);
                    return;
                } else if (this.nvN.nwI) {
                    this.nvE.mo46251D(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                    AppMethodBeat.m2505o(21747);
                    return;
                } else if (this.nvN.nwJ) {
                    this.nvE.mo46248A(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                } else {
                    this.nvE.bGO();
                    AppMethodBeat.m2505o(21747);
                    return;
                }
            }
            AppMethodBeat.m2505o(21747);
        }
    }

    /* renamed from: ik */
    private void m66915ik(boolean z) {
        AppMethodBeat.m2504i(21748);
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", Boolean.valueOf(z));
        if (z) {
            this.nvz = 0;
        } else {
            this.nvz++;
            if (this.nvz >= 2) {
                C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
                this.nvJ.stop();
                if (C21088i.bHu().bHn() && this.nvE != null) {
                    this.nvE.bGN();
                    AppMethodBeat.m2505o(21748);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(21748);
    }

    /* renamed from: u */
    private void m66919u(boolean z, int i) {
        AppMethodBeat.m2504i(21749);
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", Boolean.valueOf(z));
        if (z || i >= 0 || this.nvB > 0) {
            AppMethodBeat.m2505o(21749);
            return;
        }
        this.nvB++;
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", Integer.valueOf(this.nvB));
        this.nvH.mo68722a(this.nvN);
        AppMethodBeat.m2505o(21749);
    }

    /* renamed from: v */
    private void m66920v(boolean z, int i) {
        AppMethodBeat.m2504i(21750);
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", Boolean.valueOf(z), Boolean.valueOf(this.nvI.nzs));
        if (z || i >= 0 || this.nvA > 0) {
            AppMethodBeat.m2505o(21750);
            return;
        }
        this.nvA++;
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", Integer.valueOf(this.nvA), Boolean.valueOf(this.nvI.nzs));
        this.nvI.mo68722a(this.nvN);
        AppMethodBeat.m2505o(21750);
    }

    /* renamed from: il */
    private void m66916il(boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(21751);
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", Boolean.valueOf(z));
        if (z && C21088i.bHr().nxA) {
            C21088i.bHr().mo7683xk(this.nvN.nwP);
        }
        if (z) {
            if (this.nvN != null && z) {
                mo62161xj(this.nvN.bHH());
            }
            AppMethodBeat.m2505o(21751);
            return;
        }
        C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "sync failed!");
        this.nvG.stop();
        if (C21088i.bHu().mCurrentState != 3) {
            i = 0;
        }
        if (!(i == 0 || this.nvE == null)) {
            this.nvE.mo46264cp(this.nvN.luU, this.nvN.nwA);
        }
        AppMethodBeat.m2505o(21751);
    }

    /* renamed from: im */
    private void m66917im(boolean z) {
        AppMethodBeat.m2504i(21752);
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", Boolean.valueOf(z));
        if (z && C21088i.bHr().nxA) {
            C21088i.bHr().mo7683xk(this.nvN.nwP);
        }
        if (this.nvN != null && z) {
            int bHH = this.nvN.bHH();
            if (bHH == 2 || bHH == 1) {
                if (this.nvP) {
                    C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
                    AppMethodBeat.m2505o(21752);
                    return;
                }
                C9638aw.m17182Rg().mo14541a(new C39257o(this.nvN.nwu, this.nvN.nwv, this.nvN.bHG(), this.nvN.nww, false), 0);
            }
            mo62161xj(this.nvN.bHH());
        }
        AppMethodBeat.m2505o(21752);
    }

    /* renamed from: xj */
    public final boolean mo62161xj(int i) {
        AppMethodBeat.m2504i(21753);
        switch (i) {
            case 1:
                C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
                if (!this.nvO) {
                    this.nvO = true;
                    if (this.nvE != null) {
                        this.nvE.bGK();
                    }
                }
                AppMethodBeat.m2505o(21753);
                return true;
            case 2:
                C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", Boolean.valueOf(this.nvC), Boolean.valueOf(this.nvD));
                if (this.nvC || this.nvD) {
                    AppMethodBeat.m2505o(21753);
                    return true;
                }
                this.nvG.stop();
                if (!this.cJn) {
                    this.cJn = true;
                    if (this.nvN != null) {
                        this.nvN.nwZ = true;
                    }
                    if (this.nvE != null) {
                        this.nvE.bGL();
                    }
                    this.nvJ.mo68722a(this.nvN);
                }
                AppMethodBeat.m2505o(21753);
                return true;
            case 3:
                C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
                this.nvG.stop();
                this.nvJ.stop();
                if (this.nvE != null) {
                    this.nvE.mo46263co(this.nvN.luU, this.nvN.nwA);
                }
                AppMethodBeat.m2505o(21753);
                return true;
            case 4:
            case 7:
            case 8:
                C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
                if (this.nvN.nwI) {
                    if (this.nvE != null) {
                        this.nvE.mo46251D(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                    }
                } else if (this.nvE != null) {
                    this.nvE.mo46262cn(this.nvN.luU, this.nvN.nwA);
                }
                AppMethodBeat.m2505o(21753);
                return true;
            case 5:
                C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
                if (this.nvE != null) {
                    this.nvE.bGM();
                }
                AppMethodBeat.m2505o(21753);
                return true;
            case 6:
                C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
                this.nvN.nwG = true;
                if (this.nvE != null) {
                    this.nvE.mo46249B(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                }
                AppMethodBeat.m2505o(21753);
                return true;
            default:
                C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", Integer.valueOf(i));
                AppMethodBeat.m2505o(21753);
                return false;
        }
    }

    /* renamed from: in */
    private void m66918in(boolean z) {
        cok cok = null;
        AppMethodBeat.m2504i(21754);
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", Boolean.valueOf(z));
        if (z) {
            cok cok2;
            C3304a bHr = C21088i.bHr();
            C43219c c43219c = this.nvN;
            C4990ab.m7416i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
            if (c43219c == null || c43219c.jud == null || c43219c.jud.size() <= 0) {
                cok2 = null;
            } else {
                cok2 = C34382c.m56381af(c43219c.jud);
            }
            if (!(c43219c == null || c43219c.nwS == null || c43219c.nwS.size() <= 0)) {
                cok = C34382c.m56381af(c43219c.nwS);
            }
            bHr.nxx.mo63274a(cok2, cok2, cok, 0, 0);
        }
        AppMethodBeat.m2505o(21754);
    }

    /* renamed from: a */
    public final void mo46234a(int i, Object obj, int i2, int i3) {
        AppMethodBeat.m2504i(21755);
        if (m66913c(i, obj, i2, i3)) {
            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
            AppMethodBeat.m2505o(21755);
            return;
        }
        switch (i) {
            case 1:
                m66914ij(true);
                AppMethodBeat.m2505o(21755);
                return;
            case 3:
                m66919u(true, i3);
                AppMethodBeat.m2505o(21755);
                return;
            case 4:
                m66920v(true, i3);
                AppMethodBeat.m2505o(21755);
                return;
            case 6:
                m66918in(true);
                break;
            case 8:
                m66917im(true);
                AppMethodBeat.m2505o(21755);
                return;
        }
        AppMethodBeat.m2505o(21755);
    }

    /* renamed from: b */
    public final void mo46235b(int i, Object obj, int i2, int i3) {
        AppMethodBeat.m2504i(21756);
        if (m66913c(i, obj, i2, i3)) {
            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
            AppMethodBeat.m2505o(21756);
            return;
        }
        switch (i) {
            case 1:
                m66914ij(false);
                AppMethodBeat.m2505o(21756);
                return;
            case 3:
                m66919u(false, i3);
                AppMethodBeat.m2505o(21756);
                return;
            case 4:
                m66920v(false, i3);
                AppMethodBeat.m2505o(21756);
                return;
            case 6:
                m66918in(false);
                break;
            case 8:
                m66917im(false);
                AppMethodBeat.m2505o(21756);
                return;
        }
        AppMethodBeat.m2505o(21756);
    }

    /* renamed from: a */
    public final void mo46236a(int i, C1207m c1207m, int i2, int i3) {
        AppMethodBeat.m2504i(21757);
        if (m66913c(i, c1207m, i2, i3)) {
            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
            AppMethodBeat.m2505o(21757);
            return;
        }
        switch (i) {
            case 2:
                m66916il(true);
                AppMethodBeat.m2505o(21757);
                return;
            case 5:
                m66915ik(true);
                break;
        }
        AppMethodBeat.m2505o(21757);
    }

    /* renamed from: b */
    public final void mo46237b(int i, C1207m c1207m, int i2, int i3) {
        AppMethodBeat.m2504i(21758);
        if (m66913c(i, c1207m, i2, i3)) {
            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
            AppMethodBeat.m2505o(21758);
            return;
        }
        switch (i) {
            case 2:
                m66916il(false);
                AppMethodBeat.m2505o(21758);
                return;
            case 5:
                m66915ik(false);
                break;
        }
        AppMethodBeat.m2505o(21758);
    }

    /* renamed from: c */
    private boolean m66913c(int i, Object obj, int i2, int i3) {
        AppMethodBeat.m2504i(21759);
        if (this.nvN == null || obj == null) {
            C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
            AppMethodBeat.m2505o(21759);
            return true;
        }
        Object obj2;
        Iterator it;
        C21077d c21077d;
        switch (i) {
            case 1:
                if (obj instanceof C6951i) {
                    C6951i c6951i = (C6951i) obj;
                    bmb bmb = c6951i.nyx;
                    if (this.nvN.nwx == c6951i.nyw.wOQ) {
                        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", Integer.valueOf(this.nvN.nwx));
                        C21088i.bHs().mo24086ep(this.nvN.nwx, i3);
                        if (i2 == 0 && i3 == 0) {
                            if (this.nvN != null) {
                                this.nvN.nwu = bmb.wem;
                                this.nvN.nwv = bmb.wen;
                                this.nvN.nww = bmb.wOS;
                                this.nvN.nwC = bmb.wPb;
                                this.nvN.nwE = bmb.wPc * 1000;
                                this.nvN.nwL = bmb.nwL;
                                this.nvN.nwM = bmb.nwM;
                                this.nvN.jud = bmb.vIO;
                                this.nvN.nwS = bmb.wPd;
                                this.nvN.nwX = bmb.wPe;
                                if (bmb.nwT > 0) {
                                    this.nvN.nwT = bmb.nwT;
                                }
                                this.nvN.nwN = bmb.nwN;
                                this.nvN.nwO = bmb.nwO;
                                this.nvN.nwK = bmb.wPg;
                                if (bmb.nwQ > 0) {
                                    this.nvN.nwQ = bmb.nwQ - 1;
                                    C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.nvN.nwQ + "] from Invite resp");
                                } else {
                                    C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                                    this.nvN.nwQ = 2;
                                }
                                this.nvN.nwR = bmb.wPf;
                                C4990ab.m7411d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", Integer.valueOf(bmb.nwF));
                                if (bmb.nwF > 0) {
                                    this.nvN.nwJ = false;
                                    this.nvN.nwF = bmb.nwF;
                                } else {
                                    this.nvN.nwJ = true;
                                    this.nvN.nwF = 0;
                                }
                                this.nvN.nwB = bmb.nwB;
                                this.nvN.nwA = bmb.nwA;
                                this.nvN.luT = i3;
                                this.nvN.luU = C5046bo.nullAsNil(C1946aa.m4148a(bmb.BaseResponse.ErrMsg));
                                break;
                            }
                        }
                        C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
                        if (bmb.BaseResponse == null) {
                            this.nvN.nwB = "";
                            this.nvN.nwA = 2;
                            this.nvN.luU = C4996ah.getContext().getString(C25738R.string.abv);
                            this.nvN.luT = i3;
                            break;
                        }
                        if (i3 == v2helper.EMethodSetSendToNetworkOff) {
                            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                            this.nvN.nwG = true;
                        } else if (i3 == 434) {
                            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                            this.nvN.nwH = true;
                        } else if (i3 == C27141z.CTRL_INDEX) {
                            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                            this.nvN.nwI = true;
                        }
                        if (bmb.nwF > 0) {
                            this.nvN.nwJ = false;
                            this.nvN.nwF = bmb.nwF;
                        } else {
                            this.nvN.nwJ = true;
                            this.nvN.nwF = 0;
                        }
                        this.nvN.nwB = bmb.nwB;
                        this.nvN.nwA = bmb.nwA;
                        this.nvN.luT = i3;
                        if (bmb.getBaseResponse() != null) {
                            this.nvN.luU = C5046bo.nullAsNil(C1946aa.m4148a(bmb.BaseResponse.ErrMsg));
                            C4990ab.m7411d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", Integer.valueOf(bmb.nwA), Integer.valueOf(i3), this.nvN.luU);
                            break;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", Integer.valueOf(this.nvN.nwx), Integer.valueOf(c6951i.nyw.wOQ));
                    AppMethodBeat.m2505o(21759);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
                AppMethodBeat.m2505o(21759);
                return true;
                break;
            case 2:
                if (obj instanceof C39257o) {
                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    C39257o c39257o = (C39257o) obj;
                    bmk bmk = c39257o.nyJ;
                    if (this.nvN.nwu == c39257o.nyI.wem) {
                        if (i2 == 0 && i3 == 0) {
                            C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", Integer.valueOf(bmk.wem), Integer.valueOf(bmk.wPp), Integer.valueOf(bmk.wPq), Integer.valueOf(bmk.wPn));
                            if (bmk.wem == this.nvN.nwu && bmk.wen == this.nvN.nwv) {
                                if (bmk.wPq == this.nvN.nwC) {
                                    C4990ab.m7410d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
                                    if (bmk.wPn > this.nvN.nwD) {
                                        this.nvN.nwD = bmk.wPn;
                                        if (bmk.wPp != 0) {
                                            this.nvN.hGH = bmk.wPp;
                                        }
                                    }
                                } else {
                                    C4990ab.m7410d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
                                    obj2 = null;
                                    it = this.nvN.nwU.iterator();
                                    while (true) {
                                        Object obj3 = obj2;
                                        if (it.hasNext()) {
                                            c21077d = (C21077d) it.next();
                                            if (c21077d.kyZ == bmk.wPq) {
                                                if (bmk.wPn > c21077d.nwD) {
                                                    c21077d.nwD = bmk.wPn;
                                                    if (bmk.wPp != 0) {
                                                        c21077d.eIV = bmk.wPp;
                                                    }
                                                }
                                                obj2 = 1;
                                            } else {
                                                obj2 = obj3;
                                            }
                                        } else if (obj3 == null) {
                                            c21077d = new C21077d();
                                            c21077d.kyZ = bmk.wPq;
                                            c21077d.eIV = bmk.wPp;
                                            c21077d.nwD = bmk.wPn;
                                            this.nvN.nwU.add(c21077d);
                                        }
                                    }
                                }
                                if (bmk.luT == 404 || bmk.luT == 484) {
                                    C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
                                    this.nvN.nwI = true;
                                }
                                this.nvN.luU = bmk.luU;
                                this.nvN.luT = bmk.luT;
                                this.nvN.nwA = bmk.nwA;
                                this.nvN.nwB = bmk.nwB;
                                this.nvN.nwP = bmk.nwP;
                                break;
                            }
                        }
                    }
                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(c39257o.nyI.wem));
                    AppMethodBeat.m2505o(21759);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
                AppMethodBeat.m2505o(21759);
                return true;
            case 3:
                if (obj instanceof C6949a) {
                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (this.nvN.nwx != ((C6949a) obj).nyf.wOQ) {
                        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", Integer.valueOf(this.nvN.nwx), Integer.valueOf(((C6949a) obj).nyf.wOQ));
                        AppMethodBeat.m2505o(21759);
                        return true;
                    }
                }
                C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
                AppMethodBeat.m2505o(21759);
                return true;
                break;
            case 4:
                if (obj instanceof C46033n) {
                    if (this.nvN.nwu == ((C46033n) obj).nyG.wem) {
                        if (i2 != 0 || i3 != 0) {
                            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
                            break;
                        }
                        C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                        this.nvN.hGH = 5;
                        break;
                    }
                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(((C46033n) obj).nyG.wem));
                    AppMethodBeat.m2505o(21759);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.m2505o(21759);
                return true;
                break;
            case 5:
                if (obj instanceof C6950h) {
                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (this.nvN.nwu != ((C6950h) obj).nyu.wem) {
                        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(((C6950h) obj).nyu.wem));
                        AppMethodBeat.m2505o(21759);
                        return true;
                    }
                }
                C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
                AppMethodBeat.m2505o(21759);
                return true;
                break;
            case 6:
                if (obj instanceof C6952k) {
                    C6952k c6952k = (C6952k) obj;
                    bme bme = c6952k.nyB;
                    if (this.nvN.nwu == c6952k.nyA.wem) {
                        if (i2 != 0 || i3 != 0) {
                            C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
                            break;
                        }
                        C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
                        this.nvN.jud = bme.vIO;
                        this.nvN.nwS = bme.wPd;
                        break;
                    }
                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(c6952k.nyA.wem));
                    AppMethodBeat.m2505o(21759);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
                AppMethodBeat.m2505o(21759);
                return true;
                break;
            case 8:
                if (obj instanceof bmc) {
                    C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
                    bmc bmc = (bmc) obj;
                    if (this.nvN.nwu == bmc.wem) {
                        if (i2 == 0 && i3 == 0) {
                            this.nvN.nwP = bmc.nwP;
                            C4990ab.m7411d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", Integer.valueOf(bmc.wPh.size()));
                            it = bmc.wPh.iterator();
                            while (it.hasNext()) {
                                bml bml = (bml) it.next();
                                if (this.nvN.nwC == bml.wPq) {
                                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", Integer.valueOf(this.nvN.nwC), Integer.valueOf(bml.wPr), Integer.valueOf(bml.wPs));
                                    if (bml.wPs > this.nvN.nwD) {
                                        this.nvN.nwD = bml.wPs;
                                        if (bml.wPr != 0) {
                                            this.nvN.hGH = bml.wPr;
                                        }
                                    }
                                } else {
                                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", Integer.valueOf(bml.wPq), Integer.valueOf(bml.wPr), Integer.valueOf(bml.wPs));
                                    Object obj4 = null;
                                    Iterator it2 = this.nvN.nwU.iterator();
                                    while (it2.hasNext()) {
                                        c21077d = (C21077d) it2.next();
                                        if (c21077d.kyZ == bml.wPq) {
                                            if (bml.wPs > c21077d.nwD) {
                                                c21077d.nwD = bml.wPs;
                                                if (bml.wPr != 0) {
                                                    c21077d.eIV = bml.wPr;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj4;
                                        }
                                        obj4 = obj2;
                                    }
                                    if (obj4 == null) {
                                        c21077d = new C21077d();
                                        c21077d.kyZ = bml.wPq;
                                        c21077d.eIV = bml.wPr;
                                        c21077d.nwD = bml.wPs;
                                        this.nvN.nwU.add(c21077d);
                                    }
                                }
                                if (bml.luT == 404 || bml.luT == 484) {
                                    C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
                                    this.nvN.nwI = true;
                                }
                                this.nvN.luU = bml.luU;
                                this.nvN.luT = bml.luT;
                                this.nvN.nwA = bml.nwA;
                                this.nvN.nwB = bml.nwB;
                            }
                            break;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(bmc.wem));
                    AppMethodBeat.m2505o(21759);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
                AppMethodBeat.m2505o(21759);
                return true;
                break;
        }
        AppMethodBeat.m2505o(21759);
        return false;
    }
}
