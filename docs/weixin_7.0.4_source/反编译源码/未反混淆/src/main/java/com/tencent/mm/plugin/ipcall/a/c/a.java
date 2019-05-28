package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class a {
    public boolean nxA = false;
    public boolean nxB = false;
    public a nxC = null;
    public v2protocal nxx = new v2protocal(this.nxy);
    private ak nxy = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(21822);
            if (message == null || message.what != 59998) {
                super.handleMessage(message);
                AppMethodBeat.o(21822);
                return;
            }
            ab.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
            a aVar;
            switch (message.arg1) {
                case 3:
                    ab.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
                    AppMethodBeat.o(21822);
                    return;
                case 4:
                    ab.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
                    aVar = a.this;
                    ab.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
                    if (aVar.nxC != null) {
                        aVar.nxC.bGP();
                    }
                    AppMethodBeat.o(21822);
                    return;
                case 5:
                    ab.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        ab.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
                        a.a(a.this, 34);
                        AppMethodBeat.o(21822);
                        return;
                    } else if (message.arg2 == 1) {
                        ab.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
                        a.a(a.this, 20);
                        AppMethodBeat.o(21822);
                        return;
                    } else if (message.arg2 == 5) {
                        ab.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
                        a.a(a.this, 30);
                        AppMethodBeat.o(21822);
                        return;
                    }
                    break;
                case 6:
                    aVar = a.this;
                    ab.d("MicroMsg.IPCallEngineManager", "channel connect!");
                    if (aVar.nxA) {
                        ab.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
                        AppMethodBeat.o(21822);
                        return;
                    }
                    ab.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", Integer.valueOf(aVar.nxx.startEngine()));
                    if (aVar.nxx.startEngine() == 0) {
                        aVar.nxx.sUA = 0;
                    } else {
                        aVar.nxx.sUA = 1;
                    }
                    aVar.nxx.setInactive();
                    aVar.nxA = true;
                    if (aVar.nxC != null) {
                        aVar.nxC.bGQ();
                    }
                    AppMethodBeat.o(21822);
                    return;
                case 9:
                    ab.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
                    AppMethodBeat.o(21822);
                    return;
                case 10:
                    ab.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
                    ab.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
                    g bHq = i.bHq();
                    ab.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
                    if (!bHq.cJn) {
                        bHq.nvP = true;
                        if (bHq.nvN != null) {
                            bHq.nvN.hGH = 2;
                            aw.Rg().a(new o(bHq.nvN.nwu, bHq.nvN.nwv, bHq.nvN.bHG(), bHq.nvN.nww, true), 0);
                        }
                        bHq.xj(2);
                        break;
                    }
                    ab.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
                    AppMethodBeat.o(21822);
                    return;
            }
            AppMethodBeat.o(21822);
        }
    };
    private boolean nxz = false;

    public interface a {
        void bGP();

        void bGQ();

        void xe(int i);
    }

    public a() {
        AppMethodBeat.i(21823);
        AppMethodBeat.o(21823);
    }

    public final void bHK() {
        AppMethodBeat.i(21824);
        ab.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
        if (!this.nxA) {
            ab.d("MicroMsg.IPCallEngineManager", "channel not connect now");
        }
        this.nxx.setActive();
        AppMethodBeat.o(21824);
    }

    public final void bHL() {
        AppMethodBeat.i(21825);
        if (this.nxz) {
            ab.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
            AppMethodBeat.o(21825);
            return;
        }
        ab.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
        c cVar = i.bHq().nvN;
        if (cVar != null) {
            if (cVar.jud != null) {
                cok af = com.tencent.mm.plugin.ipcall.b.c.af(cVar.jud);
                cok af2 = com.tencent.mm.plugin.ipcall.b.c.af(cVar.nwS);
                cpu cpu = new cpu();
                cpu.xnK = 0;
                cpu.xnL = 0;
                cpu.xnM = 0;
                cpu.userName = "";
                cpu.gDC = "";
                this.nxx.a(af, af, af2, cpu, null);
            }
            ab.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
            this.nxx.sUd = cVar.nwN;
            this.nxx.sUY = cVar.nwQ;
            if (cVar.nwR != null) {
                this.nxx.sUZ = cVar.nwR.toByteArray();
            }
            if (cVar.nwO != null) {
                this.nxx.sUe = cVar.nwO.toByteArray();
            }
            this.nxx.nwu = cVar.nwu;
            this.nxx.nwv = cVar.nwv;
            this.nxx.nwC = cVar.nwC;
            this.nxx.sUg = cVar.nwL;
            this.nxx.sUf = cVar.nwM;
            this.nxx.sUh = cVar.nwT;
            int configInfo = this.nxx.setConfigInfo(this.nxx.sTY, (long) this.nxx.nwu, this.nxx.nwC, this.nxx.nwv, this.nxx.field_peerId, 1, this.nxx.sUf, this.nxx.sUg, this.nxx.sUd, this.nxx.sUe == null ? 0 : this.nxx.sUe.length, this.nxx.sUe, this.nxx.sUh, 0, 0, this.nxx.sUY, this.nxx.sUZ, 255, 0, 0, null, 0);
            ab.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", Integer.valueOf(configInfo));
            if (configInfo == 0) {
                configInfo = this.nxx.connectToPeer();
            }
            if (configInfo < 0) {
                ab.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", Integer.valueOf(configInfo));
                if (this.nxC != null) {
                    this.nxC.xe(21);
                }
            }
            this.nxz = true;
        }
        AppMethodBeat.o(21825);
    }

    public final void xk(int i) {
        AppMethodBeat.i(21826);
        if (this.nxA) {
            ab.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", Integer.valueOf(i));
            if (this.nxx.SetDTMFPayload(i) < 0) {
                ab.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", Integer.valueOf(this.nxx.SetDTMFPayload(i)));
            }
            AppMethodBeat.o(21826);
            return;
        }
        AppMethodBeat.o(21826);
    }

    public final void bHM() {
        this.nxA = false;
        this.nxz = false;
        this.nxB = false;
    }

    public final void io(boolean z) {
        int appCmd;
        AppMethodBeat.i(21827);
        if (z) {
            appCmd = this.nxx.setAppCmd(401);
        } else {
            appCmd = this.nxx.setAppCmd(402);
        }
        if (appCmd < 0) {
            ab.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", Integer.valueOf(appCmd));
        }
        AppMethodBeat.o(21827);
    }

    static /* synthetic */ void a(a aVar, int i) {
        AppMethodBeat.i(21828);
        ab.d("MicroMsg.IPCallEngineManager", "channel connect failed!");
        if (aVar.nxC != null) {
            aVar.nxC.xe(i);
        }
        AppMethodBeat.o(21828);
    }
}
