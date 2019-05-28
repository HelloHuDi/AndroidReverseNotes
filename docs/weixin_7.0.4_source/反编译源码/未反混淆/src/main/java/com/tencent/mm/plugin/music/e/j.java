package com.tencent.mm.plugin.music.e;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j implements b {
    public MediaPlayer bTR() {
        AppMethodBeat.i(137532);
        MediaPlayer mediaPlayer = new MediaPlayer();
        AppMethodBeat.o(137532);
        return mediaPlayer;
    }

    public AudioTrack ac(int i, int i2, int i3) {
        AppMethodBeat.i(137533);
        AudioTrack audioTrack = new AudioTrack(3, i, i2, 2, i3, 1);
        AppMethodBeat.o(137533);
        return audioTrack;
    }
}
