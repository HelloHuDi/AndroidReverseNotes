package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.plugin.ipcall.a.d.k;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.f.c;
import com.tencent.mm.plugin.ipcall.a.f.d;
import com.tencent.mm.plugin.ipcall.a.f.e;
import com.tencent.mm.plugin.ipcall.a.f.f;
import com.tencent.mm.plugin.ipcall.a.f.h;
import com.tencent.mm.plugin.ipcall.a.f.i;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;
import java.util.Iterator;

public final class g implements com.tencent.mm.plugin.ipcall.a.a.a.a, com.tencent.mm.plugin.ipcall.a.a.b.a {
    public boolean cJn = false;
    public int nvA = 0;
    public int nvB = 0;
    public boolean nvC = false;
    public boolean nvD = false;
    public a nvE;
    public d nvF = new d();
    i nvG = new i();
    com.tencent.mm.plugin.ipcall.a.f.a nvH = new com.tencent.mm.plugin.ipcall.a.f.a();
    h nvI = new h();
    c nvJ = new c();
    public e nvK = new e();
    com.tencent.mm.plugin.ipcall.a.f.g nvL = new com.tencent.mm.plugin.ipcall.a.f.g();
    f nvM = new f();
    public com.tencent.mm.plugin.ipcall.a.a.c nvN;
    public boolean nvO = false;
    public boolean nvP = false;
    n nvQ = new com.tencent.mm.network.n.a() {
        public final void gl(int i) {
            int i2 = 0;
            AppMethodBeat.i(21743);
            ab.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", Integer.valueOf(i));
            if (i.bHr().nxA) {
                f bHu = i.bHu();
                if (bHu.mCurrentState == 4 || bHu.mCurrentState == 5) {
                    i2 = 1;
                }
                if (!(i2 == 0 || i != 4 || g.this.nvM == null)) {
                    g.this.nvM.a(g.this.nvN);
                }
            }
            AppMethodBeat.o(21743);
        }
    };
    public int nvz = 0;

    public interface a {
        void A(String str, String str2, int i);

        void B(String str, String str2, int i);

        void C(String str, String str2, int i);

        void D(String str, String str2, int i);

        void bGJ();

        void bGK();

        void bGL();

        void bGM();

        void bGN();

        void bGO();

        void cn(String str, int i);

        void co(String str, int i);

        void cp(String str, int i);
    }

    public g() {
        AppMethodBeat.i(21744);
        AppMethodBeat.o(21744);
    }

    public final void bHo() {
        AppMethodBeat.i(21745);
        if (this.nvN.nwZ) {
            ab.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
        }
        this.nvC = true;
        ab.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(this.nvN.nwx));
        this.nvJ.stop();
        this.nvG.stop();
        this.nvH.a(this.nvN);
        this.nvL.a(this.nvN);
        AppMethodBeat.o(21745);
    }

    public final void xi(int i) {
        AppMethodBeat.i(21746);
        if (!this.nvN.nwZ) {
            ab.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
        }
        ab.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(this.nvN.nwx));
        this.nvD = true;
        this.nvJ.stop();
        this.nvG.stop();
        this.nvI.nzs = false;
        this.nvI.nzr = i;
        this.nvI.a(this.nvN);
        this.nvL.a(this.nvN);
        AppMethodBeat.o(21746);
    }

    private void ij(boolean z) {
        AppMethodBeat.i(21747);
        ab.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", Boolean.valueOf(z), Boolean.valueOf(this.nvC), Boolean.valueOf(this.nvD));
        if (this.nvC || this.nvD) {
            ab.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
            AppMethodBeat.o(21747);
        } else if (z) {
            if (this.nvE != null) {
                if (this.nvN.nwJ) {
                    this.nvE.bGJ();
                } else {
                    this.nvE.bGO();
                }
            }
            ab.i("MicroMsg.IPCallSvrLogic", "start sync");
            this.nvG.a(this.nvN);
            AppMethodBeat.o(21747);
        } else {
            if (this.nvE != null) {
                if (this.nvN.nwG) {
                    this.nvE.B(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                    AppMethodBeat.o(21747);
                    return;
                } else if (this.nvN.nwH) {
                    this.nvE.C(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                    AppMethodBeat.o(21747);
                    return;
                } else if (this.nvN.nwI) {
                    this.nvE.D(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                    AppMethodBeat.o(21747);
                    return;
                } else if (this.nvN.nwJ) {
                    this.nvE.A(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                } else {
                    this.nvE.bGO();
                    AppMethodBeat.o(21747);
                    return;
                }
            }
            AppMethodBeat.o(21747);
        }
    }

    private void ik(boolean z) {
        AppMethodBeat.i(21748);
        ab.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", Boolean.valueOf(z));
        if (z) {
            this.nvz = 0;
        } else {
            this.nvz++;
            if (this.nvz >= 2) {
                ab.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
                this.nvJ.stop();
                if (i.bHu().bHn() && this.nvE != null) {
                    this.nvE.bGN();
                    AppMethodBeat.o(21748);
                    return;
                }
            }
        }
        AppMethodBeat.o(21748);
    }

    private void u(boolean z, int i) {
        AppMethodBeat.i(21749);
        ab.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", Boolean.valueOf(z));
        if (z || i >= 0 || this.nvB > 0) {
            AppMethodBeat.o(21749);
            return;
        }
        this.nvB++;
        ab.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", Integer.valueOf(this.nvB));
        this.nvH.a(this.nvN);
        AppMethodBeat.o(21749);
    }

    private void v(boolean z, int i) {
        AppMethodBeat.i(21750);
        ab.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", Boolean.valueOf(z), Boolean.valueOf(this.nvI.nzs));
        if (z || i >= 0 || this.nvA > 0) {
            AppMethodBeat.o(21750);
            return;
        }
        this.nvA++;
        ab.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", Integer.valueOf(this.nvA), Boolean.valueOf(this.nvI.nzs));
        this.nvI.a(this.nvN);
        AppMethodBeat.o(21750);
    }

    private void il(boolean z) {
        int i = 1;
        AppMethodBeat.i(21751);
        ab.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", Boolean.valueOf(z));
        if (z && i.bHr().nxA) {
            i.bHr().xk(this.nvN.nwP);
        }
        if (z) {
            if (this.nvN != null && z) {
                xj(this.nvN.bHH());
            }
            AppMethodBeat.o(21751);
            return;
        }
        ab.e("MicroMsg.IPCallSvrLogic", "sync failed!");
        this.nvG.stop();
        if (i.bHu().mCurrentState != 3) {
            i = 0;
        }
        if (!(i == 0 || this.nvE == null)) {
            this.nvE.cp(this.nvN.luU, this.nvN.nwA);
        }
        AppMethodBeat.o(21751);
    }

    private void im(boolean z) {
        AppMethodBeat.i(21752);
        ab.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", Boolean.valueOf(z));
        if (z && i.bHr().nxA) {
            i.bHr().xk(this.nvN.nwP);
        }
        if (this.nvN != null && z) {
            int bHH = this.nvN.bHH();
            if (bHH == 2 || bHH == 1) {
                if (this.nvP) {
                    ab.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
                    AppMethodBeat.o(21752);
                    return;
                }
                aw.Rg().a(new o(this.nvN.nwu, this.nvN.nwv, this.nvN.bHG(), this.nvN.nww, false), 0);
            }
            xj(this.nvN.bHH());
        }
        AppMethodBeat.o(21752);
    }

    public final boolean xj(int i) {
        AppMethodBeat.i(21753);
        switch (i) {
            case 1:
                ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
                if (!this.nvO) {
                    this.nvO = true;
                    if (this.nvE != null) {
                        this.nvE.bGK();
                    }
                }
                AppMethodBeat.o(21753);
                return true;
            case 2:
                ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", Boolean.valueOf(this.nvC), Boolean.valueOf(this.nvD));
                if (this.nvC || this.nvD) {
                    AppMethodBeat.o(21753);
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
                    this.nvJ.a(this.nvN);
                }
                AppMethodBeat.o(21753);
                return true;
            case 3:
                ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
                this.nvG.stop();
                this.nvJ.stop();
                if (this.nvE != null) {
                    this.nvE.co(this.nvN.luU, this.nvN.nwA);
                }
                AppMethodBeat.o(21753);
                return true;
            case 4:
            case 7:
            case 8:
                ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
                if (this.nvN.nwI) {
                    if (this.nvE != null) {
                        this.nvE.D(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                    }
                } else if (this.nvE != null) {
                    this.nvE.cn(this.nvN.luU, this.nvN.nwA);
                }
                AppMethodBeat.o(21753);
                return true;
            case 5:
                ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
                if (this.nvE != null) {
                    this.nvE.bGM();
                }
                AppMethodBeat.o(21753);
                return true;
            case 6:
                ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
                this.nvN.nwG = true;
                if (this.nvE != null) {
                    this.nvE.B(this.nvN.nwB, this.nvN.luU, this.nvN.nwA);
                }
                AppMethodBeat.o(21753);
                return true;
            default:
                ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", Integer.valueOf(i));
                AppMethodBeat.o(21753);
                return false;
        }
    }

    private void in(boolean z) {
        cok cok = null;
        AppMethodBeat.i(21754);
        ab.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", Boolean.valueOf(z));
        if (z) {
            cok cok2;
            com.tencent.mm.plugin.ipcall.a.c.a bHr = i.bHr();
            com.tencent.mm.plugin.ipcall.a.a.c cVar = this.nvN;
            ab.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
            if (cVar == null || cVar.jud == null || cVar.jud.size() <= 0) {
                cok2 = null;
            } else {
                cok2 = com.tencent.mm.plugin.ipcall.b.c.af(cVar.jud);
            }
            if (!(cVar == null || cVar.nwS == null || cVar.nwS.size() <= 0)) {
                cok = com.tencent.mm.plugin.ipcall.b.c.af(cVar.nwS);
            }
            bHr.nxx.a(cok2, cok2, cok, 0, 0);
        }
        AppMethodBeat.o(21754);
    }

    public final void a(int i, Object obj, int i2, int i3) {
        AppMethodBeat.i(21755);
        if (c(i, obj, i2, i3)) {
            ab.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
            AppMethodBeat.o(21755);
            return;
        }
        switch (i) {
            case 1:
                ij(true);
                AppMethodBeat.o(21755);
                return;
            case 3:
                u(true, i3);
                AppMethodBeat.o(21755);
                return;
            case 4:
                v(true, i3);
                AppMethodBeat.o(21755);
                return;
            case 6:
                in(true);
                break;
            case 8:
                im(true);
                AppMethodBeat.o(21755);
                return;
        }
        AppMethodBeat.o(21755);
    }

    public final void b(int i, Object obj, int i2, int i3) {
        AppMethodBeat.i(21756);
        if (c(i, obj, i2, i3)) {
            ab.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
            AppMethodBeat.o(21756);
            return;
        }
        switch (i) {
            case 1:
                ij(false);
                AppMethodBeat.o(21756);
                return;
            case 3:
                u(false, i3);
                AppMethodBeat.o(21756);
                return;
            case 4:
                v(false, i3);
                AppMethodBeat.o(21756);
                return;
            case 6:
                in(false);
                break;
            case 8:
                im(false);
                AppMethodBeat.o(21756);
                return;
        }
        AppMethodBeat.o(21756);
    }

    public final void a(int i, m mVar, int i2, int i3) {
        AppMethodBeat.i(21757);
        if (c(i, mVar, i2, i3)) {
            ab.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
            AppMethodBeat.o(21757);
            return;
        }
        switch (i) {
            case 2:
                il(true);
                AppMethodBeat.o(21757);
                return;
            case 5:
                ik(true);
                break;
        }
        AppMethodBeat.o(21757);
    }

    public final void b(int i, m mVar, int i2, int i3) {
        AppMethodBeat.i(21758);
        if (c(i, mVar, i2, i3)) {
            ab.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
            AppMethodBeat.o(21758);
            return;
        }
        switch (i) {
            case 2:
                il(false);
                AppMethodBeat.o(21758);
                return;
            case 5:
                ik(false);
                break;
        }
        AppMethodBeat.o(21758);
    }

    private boolean c(int i, Object obj, int i2, int i3) {
        AppMethodBeat.i(21759);
        if (this.nvN == null || obj == null) {
            ab.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
            AppMethodBeat.o(21759);
            return true;
        }
        Object obj2;
        Iterator it;
        com.tencent.mm.plugin.ipcall.a.a.d dVar;
        switch (i) {
            case 1:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.i) {
                    com.tencent.mm.plugin.ipcall.a.d.i iVar = (com.tencent.mm.plugin.ipcall.a.d.i) obj;
                    bmb bmb = iVar.nyx;
                    if (this.nvN.nwx == iVar.nyw.wOQ) {
                        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", Integer.valueOf(this.nvN.nwx));
                        i.bHs().ep(this.nvN.nwx, i3);
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
                                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.nvN.nwQ + "] from Invite resp");
                                } else {
                                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                                    this.nvN.nwQ = 2;
                                }
                                this.nvN.nwR = bmb.wPf;
                                ab.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", Integer.valueOf(bmb.nwF));
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
                                this.nvN.luU = bo.nullAsNil(aa.a(bmb.BaseResponse.ErrMsg));
                                break;
                            }
                        }
                        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
                        if (bmb.BaseResponse == null) {
                            this.nvN.nwB = "";
                            this.nvN.nwA = 2;
                            this.nvN.luU = ah.getContext().getString(R.string.abv);
                            this.nvN.luT = i3;
                            break;
                        }
                        if (i3 == v2helper.EMethodSetSendToNetworkOff) {
                            ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                            this.nvN.nwG = true;
                        } else if (i3 == 434) {
                            ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                            this.nvN.nwH = true;
                        } else if (i3 == z.CTRL_INDEX) {
                            ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
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
                            this.nvN.luU = bo.nullAsNil(aa.a(bmb.BaseResponse.ErrMsg));
                            ab.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", Integer.valueOf(bmb.nwA), Integer.valueOf(i3), this.nvN.luU);
                            break;
                        }
                    }
                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", Integer.valueOf(this.nvN.nwx), Integer.valueOf(iVar.nyw.wOQ));
                    AppMethodBeat.o(21759);
                    return true;
                }
                ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
                AppMethodBeat.o(21759);
                return true;
                break;
            case 2:
                if (obj instanceof o) {
                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    o oVar = (o) obj;
                    bmk bmk = oVar.nyJ;
                    if (this.nvN.nwu == oVar.nyI.wem) {
                        if (i2 == 0 && i3 == 0) {
                            ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", Integer.valueOf(bmk.wem), Integer.valueOf(bmk.wPp), Integer.valueOf(bmk.wPq), Integer.valueOf(bmk.wPn));
                            if (bmk.wem == this.nvN.nwu && bmk.wen == this.nvN.nwv) {
                                if (bmk.wPq == this.nvN.nwC) {
                                    ab.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
                                    if (bmk.wPn > this.nvN.nwD) {
                                        this.nvN.nwD = bmk.wPn;
                                        if (bmk.wPp != 0) {
                                            this.nvN.hGH = bmk.wPp;
                                        }
                                    }
                                } else {
                                    ab.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
                                    obj2 = null;
                                    it = this.nvN.nwU.iterator();
                                    while (true) {
                                        Object obj3 = obj2;
                                        if (it.hasNext()) {
                                            dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it.next();
                                            if (dVar.kyZ == bmk.wPq) {
                                                if (bmk.wPn > dVar.nwD) {
                                                    dVar.nwD = bmk.wPn;
                                                    if (bmk.wPp != 0) {
                                                        dVar.eIV = bmk.wPp;
                                                    }
                                                }
                                                obj2 = 1;
                                            } else {
                                                obj2 = obj3;
                                            }
                                        } else if (obj3 == null) {
                                            dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                            dVar.kyZ = bmk.wPq;
                                            dVar.eIV = bmk.wPp;
                                            dVar.nwD = bmk.wPn;
                                            this.nvN.nwU.add(dVar);
                                        }
                                    }
                                }
                                if (bmk.luT == 404 || bmk.luT == 484) {
                                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
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
                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(oVar.nyI.wem));
                    AppMethodBeat.o(21759);
                    return true;
                }
                ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
                AppMethodBeat.o(21759);
                return true;
            case 3:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.a) {
                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (this.nvN.nwx != ((com.tencent.mm.plugin.ipcall.a.d.a) obj).nyf.wOQ) {
                        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", Integer.valueOf(this.nvN.nwx), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.a) obj).nyf.wOQ));
                        AppMethodBeat.o(21759);
                        return true;
                    }
                }
                ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
                AppMethodBeat.o(21759);
                return true;
                break;
            case 4:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.n) {
                    if (this.nvN.nwu == ((com.tencent.mm.plugin.ipcall.a.d.n) obj).nyG.wem) {
                        if (i2 != 0 || i3 != 0) {
                            ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
                            break;
                        }
                        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                        this.nvN.hGH = 5;
                        break;
                    }
                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.n) obj).nyG.wem));
                    AppMethodBeat.o(21759);
                    return true;
                }
                ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.o(21759);
                return true;
                break;
            case 5:
                if (obj instanceof com.tencent.mm.plugin.ipcall.a.d.h) {
                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (this.nvN.nwu != ((com.tencent.mm.plugin.ipcall.a.d.h) obj).nyu.wem) {
                        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.h) obj).nyu.wem));
                        AppMethodBeat.o(21759);
                        return true;
                    }
                }
                ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
                AppMethodBeat.o(21759);
                return true;
                break;
            case 6:
                if (obj instanceof k) {
                    k kVar = (k) obj;
                    bme bme = kVar.nyB;
                    if (this.nvN.nwu == kVar.nyA.wem) {
                        if (i2 != 0 || i3 != 0) {
                            ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
                            break;
                        }
                        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
                        this.nvN.jud = bme.vIO;
                        this.nvN.nwS = bme.wPd;
                        break;
                    }
                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(kVar.nyA.wem));
                    AppMethodBeat.o(21759);
                    return true;
                }
                ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
                AppMethodBeat.o(21759);
                return true;
                break;
            case 8:
                if (obj instanceof bmc) {
                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
                    bmc bmc = (bmc) obj;
                    if (this.nvN.nwu == bmc.wem) {
                        if (i2 == 0 && i3 == 0) {
                            this.nvN.nwP = bmc.nwP;
                            ab.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", Integer.valueOf(bmc.wPh.size()));
                            it = bmc.wPh.iterator();
                            while (it.hasNext()) {
                                bml bml = (bml) it.next();
                                if (this.nvN.nwC == bml.wPq) {
                                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", Integer.valueOf(this.nvN.nwC), Integer.valueOf(bml.wPr), Integer.valueOf(bml.wPs));
                                    if (bml.wPs > this.nvN.nwD) {
                                        this.nvN.nwD = bml.wPs;
                                        if (bml.wPr != 0) {
                                            this.nvN.hGH = bml.wPr;
                                        }
                                    }
                                } else {
                                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", Integer.valueOf(bml.wPq), Integer.valueOf(bml.wPr), Integer.valueOf(bml.wPs));
                                    Object obj4 = null;
                                    Iterator it2 = this.nvN.nwU.iterator();
                                    while (it2.hasNext()) {
                                        dVar = (com.tencent.mm.plugin.ipcall.a.a.d) it2.next();
                                        if (dVar.kyZ == bml.wPq) {
                                            if (bml.wPs > dVar.nwD) {
                                                dVar.nwD = bml.wPs;
                                                if (bml.wPr != 0) {
                                                    dVar.eIV = bml.wPr;
                                                }
                                            }
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj4;
                                        }
                                        obj4 = obj2;
                                    }
                                    if (obj4 == null) {
                                        dVar = new com.tencent.mm.plugin.ipcall.a.a.d();
                                        dVar.kyZ = bml.wPq;
                                        dVar.eIV = bml.wPr;
                                        dVar.nwD = bml.wPs;
                                        this.nvN.nwU.add(dVar);
                                    }
                                }
                                if (bml.luT == 404 || bml.luT == 484) {
                                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
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
                    ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", Integer.valueOf(this.nvN.nwu), Integer.valueOf(bmc.wem));
                    AppMethodBeat.o(21759);
                    return true;
                }
                ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
                AppMethodBeat.o(21759);
                return true;
                break;
        }
        AppMethodBeat.o(21759);
        return false;
    }
}
