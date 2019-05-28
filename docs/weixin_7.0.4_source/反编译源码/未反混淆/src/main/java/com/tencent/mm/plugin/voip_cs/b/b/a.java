package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a {
    boolean nxA = false;
    private ak nxy = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(135367);
            if (message == null) {
                super.handleMessage(message);
                AppMethodBeat.o(135367);
                return;
            }
            ab.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
            a aVar;
            switch (message.arg1) {
                case 1:
                    AppMethodBeat.o(135367);
                    return;
                case 3:
                    ab.d("MicroMsg.VoipCSEngine", "start dev!");
                    AppMethodBeat.o(135367);
                    return;
                case 4:
                    AppMethodBeat.o(135367);
                    return;
                case 5:
                    ab.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        ab.i("MicroMsg.VoipCSEngine", "channel broken...");
                        c.cMg().tdg = 1;
                    } else if (message.arg2 == 5) {
                        ab.i("MicroMsg.VoipCSEngine", "channel event network failer...");
                        c.cMg().tdg = 6;
                    } else {
                        ab.i("MicroMsg.VoipCSEngine", "channel connect fail...");
                        c.cMg().tdg = 5;
                    }
                    aVar = a.this;
                    ab.i("MicroMsg.VoipCSEngine", "channel connect failed!");
                    c.cMg().dataType = 1;
                    if (aVar.tey != null) {
                        aVar.tey.cMy();
                    }
                    AppMethodBeat.o(135367);
                    return;
                case 6:
                    ab.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
                    d cMg = c.cMg();
                    ab.d("MicroMsg.VoipCSReportHelper", "channelConnect");
                    cMg.tdj = 1;
                    aVar = a.this;
                    ab.i("MicroMsg.VoipCSEngine", "channel connect!");
                    if (aVar.nxA) {
                        ab.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
                        AppMethodBeat.o(135367);
                        return;
                    }
                    aVar.nxA = true;
                    ab.i("MicroMsg.VoipCSEngine", "start engine");
                    aVar.tew.setInactive();
                    ab.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
                    if (!aVar.nxA) {
                        ab.d("MicroMsg.VoipCSEngine", "channel not connect now");
                    }
                    aVar.tew.setActive();
                    int startEngine = aVar.tew.startEngine();
                    if (startEngine == 0) {
                        ab.i("MicroMsg.VoipCSEngine", "start engine suc!");
                        int[] iArr = new int[]{c.cMe().tew.sVi, c.cMe().tew.sVj};
                        ab.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + iArr[0] + ", MaxFps:" + iArr[1]);
                        if (iArr[0] > 0 && iArr[1] > 0) {
                            ByteBuffer allocate = ByteBuffer.allocate(8);
                            allocate.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(iArr);
                            byte[] array = allocate.array();
                            if (c.cMe().tew.setAppCmd(34, array, array.length) < 0) {
                                ab.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + iArr[0] + "," + iArr[1] + ",ret:" + startEngine);
                            }
                        }
                        c.cMg().tdh = 1;
                    } else {
                        ab.i("MicroMsg.VoipCSEngine", "start engine fail!");
                        c.cMg().tdh = 0;
                    }
                    if (!(aVar.tey == null || c.cMf().tdM == 2)) {
                        aVar.tey.bGQ();
                        c.cMf().tdM = 2;
                    }
                    AppMethodBeat.o(135367);
                    return;
                case 8:
                    byte[] bArr = (byte[]) message.obj;
                    a aVar2 = a.this;
                    try {
                        cmm cmm = (cmm) new cmm().parseFrom(bArr);
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + cmm.xko);
                        switch (cmm.xko) {
                            case 3:
                                if (cmm.xkp == null) {
                                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                    break;
                                }
                                bArr = cmm.xkp.wR;
                                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(bArr)));
                                int appCmd = aVar2.tew.setAppCmd(302, bArr, 4);
                                if (appCmd < 0) {
                                    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + bArr + "fail:" + appCmd + ", [roomid=" + aVar2.tew.sTZ + ", roomkey=" + aVar2.tew.nwv + "]");
                                }
                                AppMethodBeat.o(135367);
                                return;
                        }
                        AppMethodBeat.o(135367);
                        return;
                    } catch (Exception e) {
                        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                        break;
                    }
                case 100:
                    com.tencent.mm.plugin.voip.a.a.outputJniLog((byte[]) message.obj, "MicroMsg.VoipCSEngine", message.arg2);
                    AppMethodBeat.o(135367);
                    return;
                case 101:
                    com.tencent.mm.plugin.voip.a.a.outputJniLog((byte[]) message.obj, "MicroMsg.VoipCSEngine-JNI_CORE", message.arg2);
                    AppMethodBeat.o(135367);
                    return;
            }
            AppMethodBeat.o(135367);
        }
    };
    private boolean nxz = false;
    public com.tencent.mm.plugin.voip_cs.b.a tew = new com.tencent.mm.plugin.voip_cs.b.a(this.nxy);
    public a tey = null;

    public interface a {
        void bGQ();

        void cMy();
    }

    public a() {
        AppMethodBeat.i(135368);
        AppMethodBeat.o(135368);
    }

    public static int acg(String str) {
        AppMethodBeat.i(135370);
        String[] split = str.split("\\.");
        int i = bo.getInt(split[3], 0) + (((bo.getInt(split[0], 0) << 24) + (bo.getInt(split[1], 0) << 16)) + (bo.getInt(split[2], 0) << 8));
        AppMethodBeat.o(135370);
        return i;
    }

    public final void init() {
        AppMethodBeat.i(135369);
        this.nxA = false;
        this.nxz = false;
        if (this.tew.cKK()) {
            ab.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
            this.tew.mx(false);
            this.tew.reset();
        }
        this.tew.sTY = 1;
        long currentTimeMillis = System.currentTimeMillis();
        int cMc = this.tew.cMc();
        long currentTimeMillis2 = System.currentTimeMillis();
        ab.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", Integer.valueOf(cMc), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
        if (cMc < 0) {
            ab.e("MicroMsg.VoipCSEngine", "engine init failed!");
        }
        AppMethodBeat.o(135369);
    }
}
