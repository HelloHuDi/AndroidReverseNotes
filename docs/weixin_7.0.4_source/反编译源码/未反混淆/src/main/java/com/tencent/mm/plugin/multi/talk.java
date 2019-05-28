package com.tencent.mm.plugin.multi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wecall.talkroom.model.i;
import java.util.concurrent.atomic.AtomicInteger;

public class talk {
    public static int VOICE_FRAME_DURATION = 20;
    public static int VOICE_SAMPLERATE = TXRecordCommon.AUDIO_SAMPLERATE_8000;
    public byte[] field_capInfo = null;
    public int field_localImgHeight = 0;
    public int field_localImgWidth = 0;
    public int field_remoteImgChannel = 0;
    public int field_remoteImgHeight = 0;
    public int field_remoteImgLength = 0;
    public int field_remoteImgWidth = 0;

    public interface a {
        void keep_OnError(int i);

        void keep_OnNotify(int i);

        void keep_OnOpenSuccess();

        void keep_OnReportChannel(String str);

        void keep_OnReportEngineRecv(String str, int i);

        void keep_OnReportEngineSend(String str);
    }

    public native int GetAudioData(byte[] bArr, int i, AtomicInteger atomicInteger, AtomicInteger atomicInteger2);

    public native int GetVoiceActivity(int i);

    public native int IsSilenceFrame();

    public native void OnMembersChanged(int[] iArr);

    public native int Open(a aVar, i iVar, int i, int i2, int i3, long j, int[] iArr, short[] sArr, int i4, int[] iArr2, byte[] bArr, boolean z, int i5, int[] iArr3, short[] sArr2, int i6, int i7, int i8, byte[] bArr2, int[] iArr4, int i9);

    public native int SendAudio(byte[] bArr, short s, int i);

    public native int SendVideo(byte[] bArr, short s, int i, int i2, int i3, int i4);

    public native void SetAVEncryptType(int i, int i2);

    public native int SetCurrentMicId(int i);

    public native int close();

    public native int getChannelBytes(AtomicInteger atomicInteger, AtomicInteger atomicInteger2);

    public native int getSampleRate(AtomicInteger atomicInteger, AtomicInteger atomicInteger2);

    public native int init(int i, int i2, String str);

    public native int onNetworkChange(int i);

    public native int setAppCmd(int i, byte[] bArr, int i2);

    public native int setMVSvrCfg(int[] iArr, int i);

    public native int uninit();

    public native int videoDecode(int[] iArr);

    public native int videoTrans(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr);

    static {
        AppMethodBeat.i(127740);
        try {
            if (com.tencent.pb.common.a.a.Alr && com.tencent.pb.common.a.a.AlI) {
                com.tencent.pb.common.c.a.p("stlport_shared", d.sZj);
                com.tencent.pb.common.c.a.p("wechatxlog", d.sZj);
                com.tencent.pb.common.c.a.p("voipMain", d.sZj);
            }
            AppMethodBeat.o(127740);
        } catch (Throwable th) {
            c.w("loadLibrary: ", th);
            AppMethodBeat.o(127740);
        }
    }

    public final int setAppCmd(int i) {
        AppMethodBeat.i(127739);
        int appCmd = setAppCmd(i, new byte[]{(byte) 5}, 1);
        AppMethodBeat.o(127739);
        return appCmd;
    }
}
