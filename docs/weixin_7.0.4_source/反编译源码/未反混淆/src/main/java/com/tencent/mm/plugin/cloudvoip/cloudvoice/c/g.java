package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.voip.mars.comm.PlatformComm;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;

class g {
    private static final String[] kyY = new String[]{"marsbridgenetwork", "marsbridgexlog", "confService"};
    private static v2conference kzI = new v2conference();

    g() {
    }

    static {
        int i = 0;
        AppMethodBeat.i(135497);
        Context context = ah.getContext();
        ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
        String[] strArr = kyY;
        int length = strArr.length;
        while (i < length) {
            k.a(strArr[i], g.class.getClassLoader());
            i++;
        }
        PlatformComm.init(context, new Handler(Looper.getMainLooper()));
        AppMethodBeat.o(135497);
    }

    public static int a(String str, String str2, String str3, IConfCallBack iConfCallBack) {
        AppMethodBeat.i(135487);
        ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
        int i = -1;
        try {
            tt ttVar = new tt();
            ttVar.app_id = str;
            ttVar.waU = str2;
            ttVar.waV = str3;
            ttVar.waW = e.eSi + "/openvoice";
            ttVar.waX = 0;
            ttVar.waY = 1;
            ttVar.waZ = b.bgo();
            ttVar.wba = n.getNumCores();
            ttVar.wbb = bo.getInt(m.Lz(), 0);
            ttVar.wbc = m.Lw();
            ttVar.wbd = Build.MANUFACTURER;
            ttVar.wbe = Build.MODEL;
            ttVar.wbf = VERSION.RELEASE;
            String deviceID = q.getDeviceID(ah.getContext());
            if (deviceID == null || deviceID.isEmpty()) {
                ab.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "getDeviceId failed");
            } else {
                ttVar.wbg = com.tencent.mm.bt.b.bI(ag.ck(deviceID).getBytes());
            }
            ttVar.wbh = q.LW();
            ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(ttVar.toByteArray()) + ",length:" + ttVar.toByteArray().length);
            i = kzI.InitSDK(ttVar.toByteArray(), ttVar.toByteArray().length, iConfCallBack);
            ab.v("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "init ret:".concat(String.valueOf(i)));
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", e, "envInfo exception", new Object[0]);
        }
        AppMethodBeat.o(135487);
        return i;
    }

    public static int HX(String str) {
        AppMethodBeat.i(135488);
        int UpdateAuthKey = kzI.UpdateAuthKey(str.getBytes(), str.getBytes().length);
        AppMethodBeat.o(135488);
        return UpdateAuthKey;
    }

    public static int hj(long j) {
        AppMethodBeat.i(135489);
        int JoinRoom = kzI.JoinRoom(j, 4);
        ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:".concat(String.valueOf(JoinRoom)));
        AppMethodBeat.o(135489);
        return JoinRoom;
    }

    public static int s(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(135490);
        int SendAudioData = kzI.SendAudioData(bArr, i, i2);
        AppMethodBeat.o(135490);
        return SendAudioData;
    }

    public static int O(byte[] bArr, int i) {
        AppMethodBeat.i(135491);
        int GetAudioData = kzI.GetAudioData(bArr, i);
        AppMethodBeat.o(135491);
        return GetAudioData;
    }

    public static int tA(int i) {
        AppMethodBeat.i(135492);
        int GetVoiceActivity = kzI.GetVoiceActivity(i);
        AppMethodBeat.o(135492);
        return GetVoiceActivity;
    }

    static int tB(int i) {
        AppMethodBeat.i(135493);
        int ExitRoom = kzI.ExitRoom(i);
        ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(ExitRoom)));
        AppMethodBeat.o(135493);
        return ExitRoom;
    }

    public static int bgq() {
        AppMethodBeat.i(135494);
        int UnInit = kzI.UnInit();
        ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(UnInit)));
        AppMethodBeat.o(135494);
        return UnInit;
    }

    public static int e(int i, byte[] bArr, int i2) {
        AppMethodBeat.i(135495);
        int SetAppCmd = kzI.SetAppCmd(i, bArr, i2);
        AppMethodBeat.o(135495);
        return SetAppCmd;
    }

    public static void tC(int i) {
        AppMethodBeat.i(135496);
        kzI.OnNetworkChange(i);
        AppMethodBeat.o(135496);
    }
}
