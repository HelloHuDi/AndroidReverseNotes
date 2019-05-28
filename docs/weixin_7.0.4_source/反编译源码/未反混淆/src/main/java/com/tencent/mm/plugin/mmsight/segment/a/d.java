package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;

public final class d implements a {
    private MediaPlayer gaq = new k();

    public d() {
        AppMethodBeat.i(3749);
        AppMethodBeat.o(3749);
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.i(3750);
        this.gaq.setSurface(surface);
        AppMethodBeat.o(3750);
    }

    public final void setDataSource(String str) {
        AppMethodBeat.i(3751);
        this.gaq.setDataSource(str);
        AppMethodBeat.o(3751);
    }

    public final void prepareAsync() {
        AppMethodBeat.i(3752);
        this.gaq.prepareAsync();
        AppMethodBeat.o(3752);
    }

    public final void start() {
        AppMethodBeat.i(3753);
        this.gaq.start();
        AppMethodBeat.o(3753);
    }

    public final void stop() {
        AppMethodBeat.i(3754);
        this.gaq.stop();
        AppMethodBeat.o(3754);
    }

    public final void pause() {
        AppMethodBeat.i(3755);
        this.gaq.pause();
        AppMethodBeat.o(3755);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(3756);
        boolean isPlaying = this.gaq.isPlaying();
        AppMethodBeat.o(3756);
        return isPlaying;
    }

    public final void seekTo(int i) {
        AppMethodBeat.i(3757);
        this.gaq.seekTo(i);
        AppMethodBeat.o(3757);
    }

    public final int getCurrentPosition() {
        AppMethodBeat.i(3758);
        int currentPosition = this.gaq.getCurrentPosition();
        AppMethodBeat.o(3758);
        return currentPosition;
    }

    public final int getDuration() {
        AppMethodBeat.i(3759);
        int duration = this.gaq.getDuration();
        AppMethodBeat.o(3759);
        return duration;
    }

    public final void release() {
        AppMethodBeat.i(3760);
        this.gaq.release();
        AppMethodBeat.o(3760);
    }

    public final void setAudioStreamType(int i) {
        AppMethodBeat.i(3761);
        this.gaq.setAudioStreamType(i);
        AppMethodBeat.o(3761);
    }

    public final void setLooping(boolean z) {
        AppMethodBeat.i(3762);
        this.gaq.setLooping(z);
        AppMethodBeat.o(3762);
    }

    public final void setLoop(int i, int i2) {
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(3763);
        if (bVar == null) {
            this.gaq.setOnPreparedListener(null);
            AppMethodBeat.o(3763);
            return;
        }
        this.gaq.setOnPreparedListener(new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(3745);
                bVar.ce(mediaPlayer);
                AppMethodBeat.o(3745);
            }
        });
        AppMethodBeat.o(3763);
    }

    public final void a(final c cVar) {
        AppMethodBeat.i(3764);
        if (cVar == null) {
            this.gaq.setOnSeekCompleteListener(null);
            AppMethodBeat.o(3764);
            return;
        }
        this.gaq.setOnSeekCompleteListener(new OnSeekCompleteListener() {
            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(3746);
                cVar.cf(mediaPlayer);
                AppMethodBeat.o(3746);
            }
        });
        AppMethodBeat.o(3764);
    }

    public final void a(final com.tencent.mm.plugin.mmsight.segment.a.a.d dVar) {
        AppMethodBeat.i(3765);
        if (dVar == null) {
            this.gaq.setOnVideoSizeChangedListener(null);
            AppMethodBeat.o(3765);
            return;
        }
        this.gaq.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(3747);
                dVar.aa(i, i2, 0);
                AppMethodBeat.o(3747);
            }
        });
        AppMethodBeat.o(3765);
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(3766);
        if (aVar == null) {
            this.gaq.setOnErrorListener(null);
            AppMethodBeat.o(3766);
            return;
        }
        this.gaq.setOnErrorListener(new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(3748);
                boolean ey = aVar.ey(i, i2);
                AppMethodBeat.o(3748);
                return ey;
            }
        });
        AppMethodBeat.o(3766);
    }
}
