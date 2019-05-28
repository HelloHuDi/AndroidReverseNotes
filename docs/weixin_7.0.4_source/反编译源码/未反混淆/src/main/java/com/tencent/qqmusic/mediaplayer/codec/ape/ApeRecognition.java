package com.tencent.qqmusic.mediaplayer.codec.ape;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;

public class ApeRecognition implements IAudioRecognition {
    public static final String TAG = "ApeRecognition";

    public AudioType getAudioType(String str, byte[] bArr) {
        AppMethodBeat.i(128547);
        AudioType audioType;
        if (bArr == null || bArr.length <= 0 || !new String(bArr).startsWith("MAC")) {
            audioType = AudioType.UNSUPPORT;
            NativeDecoder nativeDecoder = new NativeDecoder();
            if (nativeDecoder.init(new FileDataSource(str)) == 0) {
                AudioInformation audioInformation = nativeDecoder.getAudioInformation();
                if (audioInformation != null && audioInformation.getAudioType() == AudioType.APE) {
                    audioType = AudioType.APE;
                }
            }
            AppMethodBeat.o(128547);
            return audioType;
        }
        audioType = AudioType.APE;
        AppMethodBeat.o(128547);
        return audioType;
    }

    public AudioType guessAudioType(String str) {
        AppMethodBeat.i(128548);
        AudioType audioType;
        if (TextUtils.isEmpty(str) || !(str.toLowerCase().contains(".ape") || str.toLowerCase().contains(".mac"))) {
            audioType = AudioType.UNSUPPORT;
            AppMethodBeat.o(128548);
            return audioType;
        }
        audioType = AudioType.APE;
        AppMethodBeat.o(128548);
        return audioType;
    }
}
