package com.tencent.p177mm.plugin.music.p462e;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.music.e.j */
public class C46098j implements C44752b {
    public MediaPlayer bTR() {
        AppMethodBeat.m2504i(137532);
        MediaPlayer mediaPlayer = new MediaPlayer();
        AppMethodBeat.m2505o(137532);
        return mediaPlayer;
    }

    /* renamed from: ac */
    public AudioTrack mo68876ac(int i, int i2, int i3) {
        AppMethodBeat.m2504i(137533);
        AudioTrack audioTrack = new AudioTrack(3, i, i2, 2, i3, 1);
        AppMethodBeat.m2505o(137533);
        return audioTrack;
    }
}
