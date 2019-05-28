package com.tencent.p177mm.plugin.ipcall.p438a.p440c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.ipcall.p1275b.C34382c;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.C39263g;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43219c;
import com.tencent.p177mm.plugin.ipcall.p438a.p732d.C39257o;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.protocal.protobuf.cok;
import com.tencent.p177mm.protocal.protobuf.cpu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.ipcall.a.c.a */
public final class C3304a {
    public boolean nxA = false;
    public boolean nxB = false;
    public C3306a nxC = null;
    public v2protocal nxx = new v2protocal(this.nxy);
    private C7306ak nxy = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(21822);
            if (message == null || message.what != 59998) {
                super.handleMessage(message);
                AppMethodBeat.m2505o(21822);
                return;
            }
            C4990ab.m7411d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
            C3304a c3304a;
            switch (message.arg1) {
                case 3:
                    C4990ab.m7410d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
                    AppMethodBeat.m2505o(21822);
                    return;
                case 4:
                    C4990ab.m7416i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
                    c3304a = C3304a.this;
                    C4990ab.m7410d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
                    if (c3304a.nxC != null) {
                        c3304a.nxC.bGP();
                    }
                    AppMethodBeat.m2505o(21822);
                    return;
                case 5:
                    C4990ab.m7416i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        C4990ab.m7416i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
                        C3304a.m5622a(C3304a.this, 34);
                        AppMethodBeat.m2505o(21822);
                        return;
                    } else if (message.arg2 == 1) {
                        C4990ab.m7416i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
                        C3304a.m5622a(C3304a.this, 20);
                        AppMethodBeat.m2505o(21822);
                        return;
                    } else if (message.arg2 == 5) {
                        C4990ab.m7416i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
                        C3304a.m5622a(C3304a.this, 30);
                        AppMethodBeat.m2505o(21822);
                        return;
                    }
                    break;
                case 6:
                    c3304a = C3304a.this;
                    C4990ab.m7410d("MicroMsg.IPCallEngineManager", "channel connect!");
                    if (c3304a.nxA) {
                        C4990ab.m7410d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
                        AppMethodBeat.m2505o(21822);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", Integer.valueOf(c3304a.nxx.startEngine()));
                    if (c3304a.nxx.startEngine() == 0) {
                        c3304a.nxx.sUA = 0;
                    } else {
                        c3304a.nxx.sUA = 1;
                    }
                    c3304a.nxx.setInactive();
                    c3304a.nxA = true;
                    if (c3304a.nxC != null) {
                        c3304a.nxC.bGQ();
                    }
                    AppMethodBeat.m2505o(21822);
                    return;
                case 9:
                    C4990ab.m7416i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
                    AppMethodBeat.m2505o(21822);
                    return;
                case 10:
                    C4990ab.m7416i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
                    C4990ab.m7416i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
                    C39263g bHq = C21088i.bHq();
                    C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
                    if (!bHq.cJn) {
                        bHq.nvP = true;
                        if (bHq.nvN != null) {
                            bHq.nvN.hGH = 2;
                            C9638aw.m17182Rg().mo14541a(new C39257o(bHq.nvN.nwu, bHq.nvN.nwv, bHq.nvN.bHG(), bHq.nvN.nww, true), 0);
                        }
                        bHq.mo62161xj(2);
                        break;
                    }
                    C4990ab.m7416i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
                    AppMethodBeat.m2505o(21822);
                    return;
            }
            AppMethodBeat.m2505o(21822);
        }
    };
    private boolean nxz = false;

    /* renamed from: com.tencent.mm.plugin.ipcall.a.c.a$a */
    public interface C3306a {
        void bGP();

        void bGQ();

        /* renamed from: xe */
        void mo7686xe(int i);
    }

    public C3304a() {
        AppMethodBeat.m2504i(21823);
        AppMethodBeat.m2505o(21823);
    }

    public final void bHK() {
        AppMethodBeat.m2504i(21824);
        C4990ab.m7410d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
        if (!this.nxA) {
            C4990ab.m7410d("MicroMsg.IPCallEngineManager", "channel not connect now");
        }
        this.nxx.setActive();
        AppMethodBeat.m2505o(21824);
    }

    public final void bHL() {
        AppMethodBeat.m2504i(21825);
        if (this.nxz) {
            C4990ab.m7410d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
            AppMethodBeat.m2505o(21825);
            return;
        }
        C4990ab.m7416i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
        C43219c c43219c = C21088i.bHq().nvN;
        if (c43219c != null) {
            if (c43219c.jud != null) {
                cok af = C34382c.m56381af(c43219c.jud);
                cok af2 = C34382c.m56381af(c43219c.nwS);
                cpu cpu = new cpu();
                cpu.xnK = 0;
                cpu.xnL = 0;
                cpu.xnM = 0;
                cpu.userName = "";
                cpu.gDC = "";
                this.nxx.mo63275a(af, af, af2, cpu, null);
            }
            C4990ab.m7410d("MicroMsg.IPCallEngineManager", "finish set svr addr");
            this.nxx.sUd = c43219c.nwN;
            this.nxx.sUY = c43219c.nwQ;
            if (c43219c.nwR != null) {
                this.nxx.sUZ = c43219c.nwR.toByteArray();
            }
            if (c43219c.nwO != null) {
                this.nxx.sUe = c43219c.nwO.toByteArray();
            }
            this.nxx.nwu = c43219c.nwu;
            this.nxx.nwv = c43219c.nwv;
            this.nxx.nwC = c43219c.nwC;
            this.nxx.sUg = c43219c.nwL;
            this.nxx.sUf = c43219c.nwM;
            this.nxx.sUh = c43219c.nwT;
            int configInfo = this.nxx.setConfigInfo(this.nxx.sTY, (long) this.nxx.nwu, this.nxx.nwC, this.nxx.nwv, this.nxx.field_peerId, 1, this.nxx.sUf, this.nxx.sUg, this.nxx.sUd, this.nxx.sUe == null ? 0 : this.nxx.sUe.length, this.nxx.sUe, this.nxx.sUh, 0, 0, this.nxx.sUY, this.nxx.sUZ, 255, 0, 0, null, 0);
            C4990ab.m7411d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", Integer.valueOf(configInfo));
            if (configInfo == 0) {
                configInfo = this.nxx.connectToPeer();
            }
            if (configInfo < 0) {
                C4990ab.m7413e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", Integer.valueOf(configInfo));
                if (this.nxC != null) {
                    this.nxC.mo7686xe(21);
                }
            }
            this.nxz = true;
        }
        AppMethodBeat.m2505o(21825);
    }

    /* renamed from: xk */
    public final void mo7683xk(int i) {
        AppMethodBeat.m2504i(21826);
        if (this.nxA) {
            C4990ab.m7411d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", Integer.valueOf(i));
            if (this.nxx.SetDTMFPayload(i) < 0) {
                C4990ab.m7417i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", Integer.valueOf(this.nxx.SetDTMFPayload(i)));
            }
            AppMethodBeat.m2505o(21826);
            return;
        }
        AppMethodBeat.m2505o(21826);
    }

    public final void bHM() {
        this.nxA = false;
        this.nxz = false;
        this.nxB = false;
    }

    /* renamed from: io */
    public final void mo7682io(boolean z) {
        int appCmd;
        AppMethodBeat.m2504i(21827);
        if (z) {
            appCmd = this.nxx.setAppCmd(401);
        } else {
            appCmd = this.nxx.setAppCmd(402);
        }
        if (appCmd < 0) {
            C4990ab.m7413e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", Integer.valueOf(appCmd));
        }
        AppMethodBeat.m2505o(21827);
    }

    /* renamed from: a */
    static /* synthetic */ void m5622a(C3304a c3304a, int i) {
        AppMethodBeat.m2504i(21828);
        C4990ab.m7410d("MicroMsg.IPCallEngineManager", "channel connect failed!");
        if (c3304a.nxC != null) {
            c3304a.nxC.mo7686xe(i);
        }
        AppMethodBeat.m2505o(21828);
    }
}
