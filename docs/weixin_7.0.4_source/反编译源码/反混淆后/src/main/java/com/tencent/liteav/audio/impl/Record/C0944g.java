package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.C8792d;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.audio.impl.Record.g */
public class C0944g extends C37349c {
    public int startRecord(Context context) {
        AppMethodBeat.m2504i(66637);
        TXCLog.m15677i("AudioCenter:TXCAudioTraeRecordController", "trae startRecord");
        super.startRecord(context);
        TXCTraeJNI.InitTraeEngineLibrary(this.mContext);
        TXCTraeJNI.setTraeRecordListener(this.mWeakRecordListener);
        TXCTraeJNI.nativeTraeStartRecord(context, this.mSampleRate, this.mChannels, this.mBits);
        TXCTraeJNI.nativeTraeSetChangerType(this.mVoiceKind, this.mVoiceEnvironment);
        if (!(this.mWeakRecordListener == null || this.mWeakRecordListener.get() == null)) {
            ((C8792d) this.mWeakRecordListener.get()).mo19855a(TXEAudioDef.TXE_AUDIO_NOTIFY_AUDIO_INFO, "TRAE-AEC,采样率(" + this.mSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels);
        }
        AppMethodBeat.m2505o(66637);
        return 0;
    }

    public int stopRecord() {
        AppMethodBeat.m2504i(66638);
        TXCLog.m15677i("AudioCenter:TXCAudioTraeRecordController", "trae stopRecord");
        TXCTraeJNI.nativeTraeStopRecord(true);
        TXCTraeJNI.setTraeRecordListener(null);
        AppMethodBeat.m2505o(66638);
        return 0;
    }

    public void sendCustomPCMData(byte[] bArr) {
    }

    public boolean isRecording() {
        AppMethodBeat.m2504i(66639);
        boolean nativeTraeIsRecording = TXCTraeJNI.nativeTraeIsRecording();
        AppMethodBeat.m2505o(66639);
        return nativeTraeIsRecording;
    }

    public void setReverbType(int i) {
        AppMethodBeat.m2504i(66640);
        super.setReverbType(i);
        TXCTraeJNI.nativeTraeSetRecordReverb(i);
        AppMethodBeat.m2505o(66640);
    }

    public void setChangerType(int i, int i2) {
        AppMethodBeat.m2504i(66641);
        super.setChangerType(i, i2);
        TXCTraeJNI.nativeTraeSetChangerType(i, i2);
        AppMethodBeat.m2505o(66641);
    }

    public void setVolume(float f) {
        AppMethodBeat.m2504i(66642);
        super.setVolume(f);
        TXCTraeJNI.nativeTraeSetVolume(f);
        AppMethodBeat.m2505o(66642);
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(66643);
        super.setMute(z);
        TXCTraeJNI.nativeTraeSetRecordMute(z);
        this.mIsMute = z;
        AppMethodBeat.m2505o(66643);
    }
}
