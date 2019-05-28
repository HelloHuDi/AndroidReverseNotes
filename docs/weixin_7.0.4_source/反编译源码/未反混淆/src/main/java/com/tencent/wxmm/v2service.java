package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class v2service {
    private static final String TAG = "WXMM.Voip";
    public byte[] callbackOutData = null;
    public int defaultHeight = 544;
    public int defaultWidth = 704;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgWidth = 0;
    private IVoipCallBack mUiCallBack = null;
    public byte[] remoteImgBuffer = null;

    private native int Init(byte[] bArr, int i);

    private native int UnInit();

    public native int Accept(int i);

    public native int Ack();

    public native int Hangup(int i);

    public native int Invite(int i, byte[] bArr, int i2, int i3);

    public native int OnNetworkChange(int i);

    public native int RecvNotify(byte[] bArr, int i, int i2);

    public native int SwitchAVCmd(int i);

    public native int UpdateAuthKey(byte[] bArr, int i);

    public native int playCallback(byte[] bArr, int i);

    public native int recordCallback(byte[] bArr, int i, int i2);

    public native int setAppCmd(int i, byte[] bArr, int i2);

    public native int videoDecode(byte[] bArr);

    public native int videoEncodeToSend(byte[] bArr, int i, int i2, int i3, int i4);

    static {
        AppMethodBeat.i(35428);
        System.loadLibrary("c++_shared");
        System.loadLibrary("marswechatxlog");
        System.loadLibrary("wechatnetwork");
        System.loadLibrary("voipService");
        AppMethodBeat.o(35428);
    }

    public int setAppCmd(int i) {
        AppMethodBeat.i(35423);
        int appCmd = setAppCmd(i, new byte[]{(byte) 0}, 1);
        if (appCmd < 0) {
            v2helper.Logd(TAG, "setAppCmd: type:" + appCmd + ":ret:" + appCmd);
        }
        AppMethodBeat.o(35423);
        return appCmd;
    }

    public int InitSDK(byte[] bArr, int i, IVoipCallBack iVoipCallBack) {
        AppMethodBeat.i(35424);
        this.mUiCallBack = iVoipCallBack;
        this.remoteImgBuffer = new byte[(((this.defaultWidth * this.defaultHeight) * 3) / 2)];
        int Init = Init(bArr, i);
        v2helper.Logd(TAG, "protocal init ret :" + Init + " " + i);
        AppMethodBeat.o(35424);
        return Init;
    }

    public int UninitSDK() {
        AppMethodBeat.i(35425);
        this.mUiCallBack = null;
        UnInit();
        AppMethodBeat.o(35425);
        return 0;
    }

    public int IntCallbackFromVoipSDK(int i, int i2, byte[] bArr) {
        AppMethodBeat.i(35426);
        if (this.mUiCallBack != null) {
            this.mUiCallBack.callBackFromVoip1(i, i2, bArr);
        }
        AppMethodBeat.o(35426);
        return 0;
    }

    public byte[] ByteArrayCallbackFromVoipSDK(int i, int i2, byte[] bArr) {
        AppMethodBeat.i(35427);
        if (this.mUiCallBack != null) {
            byte[] callBackFromVoip2 = this.mUiCallBack.callBackFromVoip2(i, i2, bArr);
            AppMethodBeat.o(35427);
            return callBackFromVoip2;
        }
        AppMethodBeat.o(35427);
        return null;
    }
}
