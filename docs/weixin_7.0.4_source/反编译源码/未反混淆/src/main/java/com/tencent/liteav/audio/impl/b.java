package com.tencent.liteav.audio.impl;

import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.Play.d;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

public class b {
    private static int[] a = new int[]{96000, 88200, 64000, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};

    public static String a(byte[] bArr) {
        AppMethodBeat.i(66554);
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.o(66554);
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append("0x");
            stringBuilder.append(toHexString);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(66554);
        return stringBuilder2;
    }

    public static int a(int i) {
        if (i >= a.length || i < 0) {
            return 0;
        }
        return a[i];
    }

    public static int b(int i) {
        int i2;
        AppMethodBeat.i(66555);
        if (i == TXEAudioDef.TXE_AEC_TRAE) {
            if (d.a().d()) {
                i2 = TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_PLAYER_INVALID;
                AppMethodBeat.o(66555);
                return i2;
            }
        } else if (TXCTraeJNI.nativeTraeIsPlaying()) {
            i2 = TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_PLAYER_INVALID;
            AppMethodBeat.o(66555);
            return i2;
        }
        i2 = TXEAudioDef.TXE_AUDIO_COMMON_ERR_OK;
        AppMethodBeat.o(66555);
        return i2;
    }

    public static int c(int i) {
        int i2;
        AppMethodBeat.i(66556);
        if (i == TXEAudioDef.TXE_AEC_TRAE) {
            if (f.a().c()) {
                i2 = TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_RECORDER_INVALID;
                AppMethodBeat.o(66556);
                return i2;
            }
        } else if (TXCTraeJNI.nativeTraeIsRecording()) {
            i2 = TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_RECORDER_INVALID;
            AppMethodBeat.o(66556);
            return i2;
        }
        i2 = TXEAudioDef.TXE_AUDIO_COMMON_ERR_OK;
        AppMethodBeat.o(66556);
        return i2;
    }
}
