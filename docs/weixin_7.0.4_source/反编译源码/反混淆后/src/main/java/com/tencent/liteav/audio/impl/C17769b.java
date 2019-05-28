package com.tencent.liteav.audio.impl;

import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.Play.C45098d;
import com.tencent.liteav.audio.impl.Record.C45100f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

/* renamed from: com.tencent.liteav.audio.impl.b */
public class C17769b {
    /* renamed from: a */
    private static int[] f4076a = new int[]{96000, 88200, 64000, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, TXRecordCommon.AUDIO_SAMPLERATE_32000, 24000, 22050, TXRecordCommon.AUDIO_SAMPLERATE_16000, 12000, 11025, TXRecordCommon.AUDIO_SAMPLERATE_8000, 7350};

    /* renamed from: a */
    public static String m27678a(byte[] bArr) {
        AppMethodBeat.m2504i(66554);
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.m2505o(66554);
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
        AppMethodBeat.m2505o(66554);
        return stringBuilder2;
    }

    /* renamed from: a */
    public static int m27677a(int i) {
        if (i >= f4076a.length || i < 0) {
            return 0;
        }
        return f4076a[i];
    }

    /* renamed from: b */
    public static int m27679b(int i) {
        int i2;
        AppMethodBeat.m2504i(66555);
        if (i == TXEAudioDef.TXE_AEC_TRAE) {
            if (C45098d.m82718a().mo72864d()) {
                i2 = TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_PLAYER_INVALID;
                AppMethodBeat.m2505o(66555);
                return i2;
            }
        } else if (TXCTraeJNI.nativeTraeIsPlaying()) {
            i2 = TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_PLAYER_INVALID;
            AppMethodBeat.m2505o(66555);
            return i2;
        }
        i2 = TXEAudioDef.TXE_AUDIO_COMMON_ERR_OK;
        AppMethodBeat.m2505o(66555);
        return i2;
    }

    /* renamed from: c */
    public static int m27680c(int i) {
        int i2;
        AppMethodBeat.m2504i(66556);
        if (i == TXEAudioDef.TXE_AEC_TRAE) {
            if (C45100f.m82736a().mo72872c()) {
                i2 = TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_RECORDER_INVALID;
                AppMethodBeat.m2505o(66556);
                return i2;
            }
        } else if (TXCTraeJNI.nativeTraeIsRecording()) {
            i2 = TXEAudioDef.TXE_AUDIO_RECORD_ERR_CUR_RECORDER_INVALID;
            AppMethodBeat.m2505o(66556);
            return i2;
        }
        i2 = TXEAudioDef.TXE_AUDIO_COMMON_ERR_OK;
        AppMethodBeat.m2505o(66556);
        return i2;
    }
}
