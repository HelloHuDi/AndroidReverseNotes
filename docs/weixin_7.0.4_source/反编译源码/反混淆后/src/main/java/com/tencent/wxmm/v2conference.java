package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

public class v2conference {
    private static final String TAG = "WXMM.Conference";
    public int[] audioChannels = new int[]{1};
    public int[] audioFrameLen = new int[]{20};
    public int[] audioSampleRate = new int[]{TXRecordCommon.AUDIO_SAMPLERATE_8000};
    public int defaultHeight = 480;
    public int defaultWidth = 640;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgMember = -1;
    public int field_remoteImgWidth = 0;
    private IConfCallBack mUiConfCallback = null;
    public int maxMemberSize = 100;
    public int[] memberVadlist = null;
    public byte[] remoteImgBuffer = null;

    private native int GetVideoData(byte[] bArr);

    public native int ExitRoom(int i);

    public native int GetAudioData(byte[] bArr, int i);

    public native int GetAudioFormat(int[] iArr, int[] iArr2, int[] iArr3);

    public native int GetVADStatus(int[] iArr);

    public native int GetVoiceActivity(int i);

    public native int Init(byte[] bArr, int i);

    public native int JoinRoom(long j, int i);

    public native int OnNetworkChange(int i);

    public native int PutExternalplayAudioData(byte[] bArr, int i, int i2, int i3, int i4);

    public native int SendAudioData(byte[] bArr, int i, int i2);

    public native int SendVideoData(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int SetAppCmd(int i, byte[] bArr, int i2);

    public native int UnInit();

    public native int UpdateAuthKey(byte[] bArr, int i);

    public native int videoTrans(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr);

    static {
        AppMethodBeat.m2504i(35396);
        System.loadLibrary("c++_shared");
        System.loadLibrary("marsbridgexlog");
        System.loadLibrary("marsbridgenetwork");
        System.loadLibrary("confService");
        AppMethodBeat.m2505o(35396);
    }

    public v2conference() {
        AppMethodBeat.m2504i(35388);
        AppMethodBeat.m2505o(35388);
    }

    public byte[] CallbackFromConferenceSDK(int i, int i2, byte[] bArr) {
        AppMethodBeat.m2504i(35389);
        if (this.mUiConfCallback != null) {
            byte[] callBackFromConf = this.mUiConfCallback.callBackFromConf(i, i2, bArr);
            AppMethodBeat.m2505o(35389);
            return callBackFromConf;
        }
        AppMethodBeat.m2505o(35389);
        return null;
    }

    public void CallbackWriteLogFromSDK(int i, String str, String str2, int i2, String str3, String str4, int i3) {
        AppMethodBeat.m2504i(35390);
        if (this.mUiConfCallback != null) {
            this.mUiConfCallback.callbackWriteLog(i, str, str2, i2, str3, str4, i3);
        }
        AppMethodBeat.m2505o(35390);
    }

    public void SetUICallback(IConfCallBack iConfCallBack) {
        this.mUiConfCallback = iConfCallBack;
    }

    public int GetDecodeVideoData(byte[] bArr) {
        AppMethodBeat.m2504i(35391);
        bArr[3] = (byte) 0;
        bArr[1] = (byte) 0;
        bArr[2] = (byte) 0;
        bArr[0] = (byte) 2;
        if (1 == GetVideoData(bArr)) {
            AppMethodBeat.m2505o(35391);
            return 1;
        }
        AppMethodBeat.m2505o(35391);
        return 0;
    }

    public int GetAudioDeviceFmt(AudDataFmt audDataFmt) {
        AppMethodBeat.m2504i(35392);
        int GetAudioFormat = GetAudioFormat(this.audioSampleRate, this.audioFrameLen, this.audioChannels);
        audDataFmt.nChannesl = this.audioChannels[0];
        audDataFmt.nFramelen = this.audioFrameLen[0];
        audDataFmt.nSamplerate = this.audioSampleRate[0];
        AppMethodBeat.m2505o(35392);
        return GetAudioFormat;
    }

    public int InitSDK(byte[] bArr, int i, IConfCallBack iConfCallBack) {
        AppMethodBeat.m2504i(35393);
        this.mUiConfCallback = iConfCallBack;
        this.remoteImgBuffer = new byte[(((this.defaultWidth * this.defaultHeight) * 3) / 2)];
        this.memberVadlist = new int[this.maxMemberSize];
        int Init = Init(bArr, i);
        AppMethodBeat.m2505o(35393);
        return Init;
    }

    public int UninitSDK() {
        AppMethodBeat.m2504i(35394);
        this.mUiConfCallback = null;
        this.memberVadlist = null;
        UnInit();
        AppMethodBeat.m2505o(35394);
        return 0;
    }

    public int GetMembersVadStatus(int[] iArr) {
        AppMethodBeat.m2504i(35395);
        if (iArr == null || this.memberVadlist == null) {
            AppMethodBeat.m2505o(35395);
            return -1;
        }
        int GetVADStatus = GetVADStatus(this.memberVadlist);
        if (GetVADStatus > 0) {
            int length = iArr.length;
            if (GetVADStatus <= length) {
                length = GetVADStatus;
            }
            System.arraycopy(this.memberVadlist, 0, iArr, 0, length);
            AppMethodBeat.m2505o(35395);
            return length;
        }
        AppMethodBeat.m2505o(35395);
        return GetVADStatus;
    }
}
