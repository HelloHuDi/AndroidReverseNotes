package com.tencent.p177mm.plugin.voip_cs.p547b.p1310b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43746a;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43749c;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43750d;
import com.tencent.p177mm.protocal.protobuf.cmm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.b.a */
public final class C43747a {
    boolean nxA = false;
    private C7306ak nxy = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(135367);
            if (message == null) {
                super.handleMessage(message);
                AppMethodBeat.m2505o(135367);
                return;
            }
            C4990ab.m7411d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
            C43747a c43747a;
            switch (message.arg1) {
                case 1:
                    AppMethodBeat.m2505o(135367);
                    return;
                case 3:
                    C4990ab.m7410d("MicroMsg.VoipCSEngine", "start dev!");
                    AppMethodBeat.m2505o(135367);
                    return;
                case 4:
                    AppMethodBeat.m2505o(135367);
                    return;
                case 5:
                    C4990ab.m7416i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        C4990ab.m7416i("MicroMsg.VoipCSEngine", "channel broken...");
                        C43749c.cMg().tdg = 1;
                    } else if (message.arg2 == 5) {
                        C4990ab.m7416i("MicroMsg.VoipCSEngine", "channel event network failer...");
                        C43749c.cMg().tdg = 6;
                    } else {
                        C4990ab.m7416i("MicroMsg.VoipCSEngine", "channel connect fail...");
                        C43749c.cMg().tdg = 5;
                    }
                    c43747a = C43747a.this;
                    C4990ab.m7416i("MicroMsg.VoipCSEngine", "channel connect failed!");
                    C43749c.cMg().dataType = 1;
                    if (c43747a.tey != null) {
                        c43747a.tey.cMy();
                    }
                    AppMethodBeat.m2505o(135367);
                    return;
                case 6:
                    C4990ab.m7416i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
                    C43750d cMg = C43749c.cMg();
                    C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "channelConnect");
                    cMg.tdj = 1;
                    c43747a = C43747a.this;
                    C4990ab.m7416i("MicroMsg.VoipCSEngine", "channel connect!");
                    if (c43747a.nxA) {
                        C4990ab.m7416i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
                        AppMethodBeat.m2505o(135367);
                        return;
                    }
                    c43747a.nxA = true;
                    C4990ab.m7416i("MicroMsg.VoipCSEngine", "start engine");
                    c43747a.tew.setInactive();
                    C4990ab.m7410d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
                    if (!c43747a.nxA) {
                        C4990ab.m7410d("MicroMsg.VoipCSEngine", "channel not connect now");
                    }
                    c43747a.tew.setActive();
                    int startEngine = c43747a.tew.startEngine();
                    if (startEngine == 0) {
                        C4990ab.m7416i("MicroMsg.VoipCSEngine", "start engine suc!");
                        int[] iArr = new int[]{C43749c.cMe().tew.sVi, C43749c.cMe().tew.sVj};
                        C4990ab.m7416i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + iArr[0] + ", MaxFps:" + iArr[1]);
                        if (iArr[0] > 0 && iArr[1] > 0) {
                            ByteBuffer allocate = ByteBuffer.allocate(8);
                            allocate.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(iArr);
                            byte[] array = allocate.array();
                            if (C43749c.cMe().tew.setAppCmd(34, array, array.length) < 0) {
                                C4990ab.m7416i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + iArr[0] + "," + iArr[1] + ",ret:" + startEngine);
                            }
                        }
                        C43749c.cMg().tdh = 1;
                    } else {
                        C4990ab.m7416i("MicroMsg.VoipCSEngine", "start engine fail!");
                        C43749c.cMg().tdh = 0;
                    }
                    if (!(c43747a.tey == null || C43749c.cMf().tdM == 2)) {
                        c43747a.tey.bGQ();
                        C43749c.cMf().tdM = 2;
                    }
                    AppMethodBeat.m2505o(135367);
                    return;
                case 8:
                    byte[] bArr = (byte[]) message.obj;
                    C43747a c43747a2 = C43747a.this;
                    try {
                        cmm cmm = (cmm) new cmm().parseFrom(bArr);
                        C46317a.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + cmm.xko);
                        switch (cmm.xko) {
                            case 3:
                                if (cmm.xkp == null) {
                                    C46317a.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                    break;
                                }
                                bArr = cmm.xkp.f1226wR;
                                C46317a.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(bArr)));
                                int appCmd = c43747a2.tew.setAppCmd(302, bArr, 4);
                                if (appCmd < 0) {
                                    C46317a.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + bArr + "fail:" + appCmd + ", [roomid=" + c43747a2.tew.sTZ + ", roomkey=" + c43747a2.tew.nwv + "]");
                                }
                                AppMethodBeat.m2505o(135367);
                                return;
                        }
                        AppMethodBeat.m2505o(135367);
                        return;
                    } catch (Exception e) {
                        C46317a.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                        break;
                    }
                case 100:
                    C46317a.outputJniLog((byte[]) message.obj, "MicroMsg.VoipCSEngine", message.arg2);
                    AppMethodBeat.m2505o(135367);
                    return;
                case 101:
                    C46317a.outputJniLog((byte[]) message.obj, "MicroMsg.VoipCSEngine-JNI_CORE", message.arg2);
                    AppMethodBeat.m2505o(135367);
                    return;
            }
            AppMethodBeat.m2505o(135367);
        }
    };
    private boolean nxz = false;
    public C43746a tew = new C43746a(this.nxy);
    public C22486a tey = null;

    /* renamed from: com.tencent.mm.plugin.voip_cs.b.b.a$a */
    public interface C22486a {
        void bGQ();

        void cMy();
    }

    public C43747a() {
        AppMethodBeat.m2504i(135368);
        AppMethodBeat.m2505o(135368);
    }

    public static int acg(String str) {
        AppMethodBeat.m2504i(135370);
        String[] split = str.split("\\.");
        int i = C5046bo.getInt(split[3], 0) + (((C5046bo.getInt(split[0], 0) << 24) + (C5046bo.getInt(split[1], 0) << 16)) + (C5046bo.getInt(split[2], 0) << 8));
        AppMethodBeat.m2505o(135370);
        return i;
    }

    public final void init() {
        AppMethodBeat.m2504i(135369);
        this.nxA = false;
        this.nxz = false;
        if (this.tew.cKK()) {
            C4990ab.m7410d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
            this.tew.mo63320mx(false);
            this.tew.reset();
        }
        this.tew.sTY = 1;
        long currentTimeMillis = System.currentTimeMillis();
        int cMc = this.tew.cMc();
        long currentTimeMillis2 = System.currentTimeMillis();
        C4990ab.m7411d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", Integer.valueOf(cMc), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
        if (cMc < 0) {
            C4990ab.m7412e("MicroMsg.VoipCSEngine", "engine init failed!");
        }
        AppMethodBeat.m2505o(135369);
    }
}
