package com.tencent.qqmusic.mediaplayer.codec;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;

public interface IAudioRecognition {
    AudioType getAudioType(String str, byte[] bArr);

    AudioType guessAudioType(String str);
}
