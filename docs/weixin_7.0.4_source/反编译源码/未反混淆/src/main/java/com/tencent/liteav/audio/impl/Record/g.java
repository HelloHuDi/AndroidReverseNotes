package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class g extends c {
    public int startRecord(Context context) {
        AppMethodBeat.i(66637);
        TXCLog.i("AudioCenter:TXCAudioTraeRecordController", "trae startRecord");
        super.startRecord(context);
        TXCTraeJNI.InitTraeEngineLibrary(this.mContext);
        TXCTraeJNI.setTraeRecordListener(this.mWeakRecordListener);
        TXCTraeJNI.nativeTraeStartRecord(context, this.mSampleRate, this.mChannels, this.mBits);
        TXCTraeJNI.nativeTraeSetChangerType(this.mVoiceKind, this.mVoiceEnvironment);
        if (!(this.mWeakRecordListener == null || this.mWeakRecordListener.get() == null)) {
            ((d) this.mWeakRecordListener.get()).a(TXEAudioDef.TXE_AUDIO_NOTIFY_AUDIO_INFO, "TRAE-AEC,采样率(" + this.mSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels);
        }
        AppMethodBeat.o(66637);
        return 0;
    }

    public int stopRecord() {
        AppMethodBeat.i(66638);
        TXCLog.i("AudioCenter:TXCAudioTraeRecordController", "trae stopRecord");
        TXCTraeJNI.nativeTraeStopRecord(true);
        TXCTraeJNI.setTraeRecordListener(null);
        AppMethodBeat.o(66638);
        return 0;
    }

    public void sendCustomPCMData(byte[] bArr) {
    }

    public boolean isRecording() {
        AppMethodBeat.i(66639);
        boolean nativeTraeIsRecording = TXCTraeJNI.nativeTraeIsRecording();
        AppMethodBeat.o(66639);
        return nativeTraeIsRecording;
    }

    public void setReverbType(int i) {
        AppMethodBeat.i(66640);
        super.setReverbType(i);
        TXCTraeJNI.nativeTraeSetRecordReverb(i);
        AppMethodBeat.o(66640);
    }

    public void setChangerType(int i, int i2) {
        AppMethodBeat.i(66641);
        super.setChangerType(i, i2);
        TXCTraeJNI.nativeTraeSetChangerType(i, i2);
        AppMethodBeat.o(66641);
    }

    public void setVolume(float f) {
        AppMethodBeat.i(66642);
        super.setVolume(f);
        TXCTraeJNI.nativeTraeSetVolume(f);
        AppMethodBeat.o(66642);
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(66643);
        super.setMute(z);
        TXCTraeJNI.nativeTraeSetRecordMute(z);
        this.mIsMute = z;
        AppMethodBeat.o(66643);
    }
}
