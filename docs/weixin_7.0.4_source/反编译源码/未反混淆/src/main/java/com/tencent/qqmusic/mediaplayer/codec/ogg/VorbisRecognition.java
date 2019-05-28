package com.tencent.qqmusic.mediaplayer.codec.ogg;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class VorbisRecognition implements IAudioRecognition {
    public AudioType getAudioType(String str, byte[] bArr) {
        AppMethodBeat.i(128587);
        AudioType audioType;
        if (bArr == null || bArr.length <= 0 || !new String(bArr).startsWith("OggS")) {
            audioType = AudioType.UNSUPPORT;
            AppMethodBeat.o(128587);
            return audioType;
        }
        audioType = AudioType.OGG;
        AppMethodBeat.o(128587);
        return audioType;
    }

    public AudioType guessAudioType(String str) {
        AppMethodBeat.i(128588);
        AudioType audioType;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(".ogg")) {
            audioType = AudioType.UNSUPPORT;
            AppMethodBeat.o(128588);
            return audioType;
        }
        audioType = AudioType.OGG;
        AppMethodBeat.o(128588);
        return audioType;
    }
}
