package com.tencent.qqmusic.mediaplayer.codec.mp3;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class MP3Recognition implements IAudioRecognition {
    public AudioType getAudioType(String str, byte[] bArr) {
        AppMethodBeat.m2504i(128576);
        AudioType audioType;
        if (MP3FileCheck.isMp3File(str)) {
            audioType = AudioType.MP3;
            AppMethodBeat.m2505o(128576);
            return audioType;
        }
        audioType = AudioType.UNSUPPORT;
        AppMethodBeat.m2505o(128576);
        return audioType;
    }

    public AudioType guessAudioType(String str) {
        AppMethodBeat.m2504i(128577);
        AudioType audioType;
        if (TextUtils.isEmpty(str) || !(str.toLowerCase().endsWith(".mp3") || str.endsWith(".mp3.tmp") || str.endsWith(".mp3.mqcc") || str.endsWith(".ofl") || str.endsWith(".efe"))) {
            audioType = AudioType.UNSUPPORT;
            AppMethodBeat.m2505o(128577);
            return audioType;
        }
        audioType = AudioType.MP3;
        AppMethodBeat.m2505o(128577);
        return audioType;
    }
}
