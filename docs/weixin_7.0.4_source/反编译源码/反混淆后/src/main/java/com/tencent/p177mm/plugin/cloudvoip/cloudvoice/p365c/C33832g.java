package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1422n;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p1480b.C38802b;
import com.tencent.p177mm.protocal.protobuf.C23448tt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.voip.mars.comm.PlatformComm;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.g */
class C33832g {
    private static final String[] kyY = new String[]{"marsbridgenetwork", "marsbridgexlog", "confService"};
    private static v2conference kzI = new v2conference();

    C33832g() {
    }

    static {
        int i = 0;
        AppMethodBeat.m2504i(135497);
        Context context = C4996ah.getContext();
        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
        String[] strArr = kyY;
        int length = strArr.length;
        while (i < length) {
            C1449k.m3079a(strArr[i], C33832g.class.getClassLoader());
            i++;
        }
        PlatformComm.init(context, new Handler(Looper.getMainLooper()));
        AppMethodBeat.m2505o(135497);
    }

    /* renamed from: a */
    public static int m55333a(String str, String str2, String str3, IConfCallBack iConfCallBack) {
        AppMethodBeat.m2504i(135487);
        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
        int i = -1;
        try {
            C23448tt c23448tt = new C23448tt();
            c23448tt.app_id = str;
            c23448tt.waU = str2;
            c23448tt.waV = str3;
            c23448tt.waW = C6457e.eSi + "/openvoice";
            c23448tt.waX = 0;
            c23448tt.waY = 1;
            c23448tt.waZ = C38802b.bgo();
            c23448tt.wba = C1422n.getNumCores();
            c23448tt.wbb = C5046bo.getInt(C45290m.m83512Lz(), 0);
            c23448tt.wbc = C45290m.m83509Lw();
            c23448tt.wbd = Build.MANUFACTURER;
            c23448tt.wbe = Build.MODEL;
            c23448tt.wbf = VERSION.RELEASE;
            String deviceID = C1427q.getDeviceID(C4996ah.getContext());
            if (deviceID == null || deviceID.isEmpty()) {
                C4990ab.m7412e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "getDeviceId failed");
            } else {
                c23448tt.wbg = C1332b.m2847bI(C4995ag.m7428ck(deviceID).getBytes());
            }
            c23448tt.wbh = C1427q.m3038LW();
            C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(c23448tt.toByteArray()) + ",length:" + c23448tt.toByteArray().length);
            i = kzI.InitSDK(c23448tt.toByteArray(), c23448tt.toByteArray().length, iConfCallBack);
            C4990ab.m7418v("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "init ret:".concat(String.valueOf(i)));
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", e, "envInfo exception", new Object[0]);
        }
        AppMethodBeat.m2505o(135487);
        return i;
    }

    /* renamed from: HX */
    public static int m55331HX(String str) {
        AppMethodBeat.m2504i(135488);
        int UpdateAuthKey = kzI.UpdateAuthKey(str.getBytes(), str.getBytes().length);
        AppMethodBeat.m2505o(135488);
        return UpdateAuthKey;
    }

    /* renamed from: hj */
    public static int m55335hj(long j) {
        AppMethodBeat.m2504i(135489);
        int JoinRoom = kzI.JoinRoom(j, 4);
        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:".concat(String.valueOf(JoinRoom)));
        AppMethodBeat.m2505o(135489);
        return JoinRoom;
    }

    /* renamed from: s */
    public static int m55336s(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(135490);
        int SendAudioData = kzI.SendAudioData(bArr, i, i2);
        AppMethodBeat.m2505o(135490);
        return SendAudioData;
    }

    /* renamed from: O */
    public static int m55332O(byte[] bArr, int i) {
        AppMethodBeat.m2504i(135491);
        int GetAudioData = kzI.GetAudioData(bArr, i);
        AppMethodBeat.m2505o(135491);
        return GetAudioData;
    }

    /* renamed from: tA */
    public static int m55337tA(int i) {
        AppMethodBeat.m2504i(135492);
        int GetVoiceActivity = kzI.GetVoiceActivity(i);
        AppMethodBeat.m2505o(135492);
        return GetVoiceActivity;
    }

    /* renamed from: tB */
    static int m55338tB(int i) {
        AppMethodBeat.m2504i(135493);
        int ExitRoom = kzI.ExitRoom(i);
        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(ExitRoom)));
        AppMethodBeat.m2505o(135493);
        return ExitRoom;
    }

    public static int bgq() {
        AppMethodBeat.m2504i(135494);
        int UnInit = kzI.UnInit();
        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(UnInit)));
        AppMethodBeat.m2505o(135494);
        return UnInit;
    }

    /* renamed from: e */
    public static int m55334e(int i, byte[] bArr, int i2) {
        AppMethodBeat.m2504i(135495);
        int SetAppCmd = kzI.SetAppCmd(i, bArr, i2);
        AppMethodBeat.m2505o(135495);
        return SetAppCmd;
    }

    /* renamed from: tC */
    public static void m55339tC(int i) {
        AppMethodBeat.m2504i(135496);
        kzI.OnNetworkChange(i);
        AppMethodBeat.m2505o(135496);
    }
}
