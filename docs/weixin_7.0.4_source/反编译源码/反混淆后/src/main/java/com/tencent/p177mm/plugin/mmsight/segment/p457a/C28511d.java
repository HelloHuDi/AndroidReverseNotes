package com.tencent.p177mm.plugin.mmsight.segment.p457a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C21307a;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C28510b;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C39398c;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C39399d;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.a.d */
public final class C28511d implements C39397a {
    private MediaPlayer gaq = new C45289k();

    public C28511d() {
        AppMethodBeat.m2504i(3749);
        AppMethodBeat.m2505o(3749);
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.m2504i(3750);
        this.gaq.setSurface(surface);
        AppMethodBeat.m2505o(3750);
    }

    public final void setDataSource(String str) {
        AppMethodBeat.m2504i(3751);
        this.gaq.setDataSource(str);
        AppMethodBeat.m2505o(3751);
    }

    public final void prepareAsync() {
        AppMethodBeat.m2504i(3752);
        this.gaq.prepareAsync();
        AppMethodBeat.m2505o(3752);
    }

    public final void start() {
        AppMethodBeat.m2504i(3753);
        this.gaq.start();
        AppMethodBeat.m2505o(3753);
    }

    public final void stop() {
        AppMethodBeat.m2504i(3754);
        this.gaq.stop();
        AppMethodBeat.m2505o(3754);
    }

    public final void pause() {
        AppMethodBeat.m2504i(3755);
        this.gaq.pause();
        AppMethodBeat.m2505o(3755);
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(3756);
        boolean isPlaying = this.gaq.isPlaying();
        AppMethodBeat.m2505o(3756);
        return isPlaying;
    }

    public final void seekTo(int i) {
        AppMethodBeat.m2504i(3757);
        this.gaq.seekTo(i);
        AppMethodBeat.m2505o(3757);
    }

    public final int getCurrentPosition() {
        AppMethodBeat.m2504i(3758);
        int currentPosition = this.gaq.getCurrentPosition();
        AppMethodBeat.m2505o(3758);
        return currentPosition;
    }

    public final int getDuration() {
        AppMethodBeat.m2504i(3759);
        int duration = this.gaq.getDuration();
        AppMethodBeat.m2505o(3759);
        return duration;
    }

    public final void release() {
        AppMethodBeat.m2504i(3760);
        this.gaq.release();
        AppMethodBeat.m2505o(3760);
    }

    public final void setAudioStreamType(int i) {
        AppMethodBeat.m2504i(3761);
        this.gaq.setAudioStreamType(i);
        AppMethodBeat.m2505o(3761);
    }

    public final void setLooping(boolean z) {
        AppMethodBeat.m2504i(3762);
        this.gaq.setLooping(z);
        AppMethodBeat.m2505o(3762);
    }

    public final void setLoop(int i, int i2) {
    }

    /* renamed from: a */
    public final void mo46477a(final C28510b c28510b) {
        AppMethodBeat.m2504i(3763);
        if (c28510b == null) {
            this.gaq.setOnPreparedListener(null);
            AppMethodBeat.m2505o(3763);
            return;
        }
        this.gaq.setOnPreparedListener(new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.m2504i(3745);
                c28510b.mo17631ce(mediaPlayer);
                AppMethodBeat.m2505o(3745);
            }
        });
        AppMethodBeat.m2505o(3763);
    }

    /* renamed from: a */
    public final void mo46478a(final C39398c c39398c) {
        AppMethodBeat.m2504i(3764);
        if (c39398c == null) {
            this.gaq.setOnSeekCompleteListener(null);
            AppMethodBeat.m2505o(3764);
            return;
        }
        this.gaq.setOnSeekCompleteListener(new OnSeekCompleteListener() {
            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                AppMethodBeat.m2504i(3746);
                c39398c.mo7952cf(mediaPlayer);
                AppMethodBeat.m2505o(3746);
            }
        });
        AppMethodBeat.m2505o(3764);
    }

    /* renamed from: a */
    public final void mo46479a(final C39399d c39399d) {
        AppMethodBeat.m2504i(3765);
        if (c39399d == null) {
            this.gaq.setOnVideoSizeChangedListener(null);
            AppMethodBeat.m2505o(3765);
            return;
        }
        this.gaq.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.m2504i(3747);
                c39399d.mo17622aa(i, i2, 0);
                AppMethodBeat.m2505o(3747);
            }
        });
        AppMethodBeat.m2505o(3765);
    }

    /* renamed from: a */
    public final void mo46476a(final C21307a c21307a) {
        AppMethodBeat.m2504i(3766);
        if (c21307a == null) {
            this.gaq.setOnErrorListener(null);
            AppMethodBeat.m2505o(3766);
            return;
        }
        this.gaq.setOnErrorListener(new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.m2504i(3748);
                boolean ey = c21307a.mo17632ey(i, i2);
                AppMethodBeat.m2505o(3748);
                return ey;
            }
        });
        AppMethodBeat.m2505o(3766);
    }
}
