package com.tencent.p177mm.plugin.music.p463f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.music.p462e.C44752b;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C28564b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.f.b */
public final class C43327b extends C28564b {
    MediaPlayer gaq;
    C34583a oNw;
    boolean ovl = true;

    /* renamed from: com.tencent.mm.plugin.music.f.b$1 */
    class C126711 implements OnCompletionListener {
        C126711() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(137548);
            C4990ab.m7412e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
            C43327b.this.mo46689jz(true);
            AppMethodBeat.m2505o(137548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.f.b$2 */
    class C126722 implements OnSeekCompleteListener {
        C126722() {
        }

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(137549);
            if (C43327b.this.gaq != null && C43327b.this.gaq.isPlaying()) {
                C4990ab.m7416i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
                try {
                    C43327b.this.gaq.start();
                    AppMethodBeat.m2505o(137549);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(137549);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.f.b$3 */
    class C345813 implements OnPreparedListener {
        C345813() {
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(137550);
            if (C43327b.this.gaq != null) {
                C4990ab.m7416i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
                try {
                    C43327b.this.gaq.start();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                }
                C43327b.this.ovl = false;
                C43327b.this.onStart();
                if (C43327b.this.oNw != null) {
                    C43327b.this.oNw.isStop = true;
                }
                C43327b.this.oNw = new C34583a(C43327b.this, (byte) 0);
                C34583a c34583a = C43327b.this.oNw;
                c34583a.isStop = false;
                C7305d.post(c34583a, "music_play_progress_runnable");
            }
            AppMethodBeat.m2505o(137550);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.f.b$4 */
    class C345824 implements OnErrorListener {
        C345824() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(137551);
            C4990ab.m7413e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
            C43327b.this.mo46688jy(false);
            AppMethodBeat.m2505o(137551);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.f.b$a */
    class C34583a implements Runnable {
        boolean isStop;

        private C34583a() {
            this.isStop = true;
        }

        /* synthetic */ C34583a(C43327b c43327b, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(137552);
            C4990ab.m7416i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (C43327b.this.gaq != null && C43327b.this.gaq.isPlaying()) {
                        int currentPosition = C43327b.this.gaq.getCurrentPosition();
                        int duration = C43327b.this.gaq.getDuration();
                        if (currentPosition > 0 && duration > 0) {
                            C43327b.this.mo46695zR((currentPosition * 100) / duration);
                        }
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "onPlayUpdate", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "sleep", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(137552);
        }
    }

    public C43327b() {
        AppMethodBeat.m2504i(137553);
        C44752b c44752b = (C44752b) C43329b.m77295ar(C44752b.class);
        if (c44752b != null) {
            this.gaq = c44752b.bTR();
        } else {
            C4990ab.m7412e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
        }
        if (this.gaq == null) {
            this.gaq = new MediaPlayer();
        }
        this.gaq.setAudioStreamType(3);
        this.gaq.setOnCompletionListener(new C126711());
        this.gaq.setOnSeekCompleteListener(new C126722());
        this.gaq.setOnPreparedListener(new C345813());
        this.gaq.setOnErrorListener(new C345824());
        AppMethodBeat.m2505o(137553);
    }

    public final boolean isPlaying() {
        boolean z = false;
        AppMethodBeat.m2504i(137554);
        try {
            z = this.gaq.isPlaying();
            AppMethodBeat.m2505o(137554);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[z]);
            AppMethodBeat.m2505o(137554);
        }
        return z;
    }

    public final boolean bUz() {
        return !this.ovl;
    }

    /* renamed from: Tr */
    public final void mo46681Tr(String str) {
        AppMethodBeat.m2504i(137555);
        C4990ab.m7417i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", str);
        try {
            this.gaq.setDataSource(str);
            AppMethodBeat.m2505o(137555);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[0]);
            AppMethodBeat.m2505o(137555);
        }
    }

    public final int bUA() {
        int i = 0;
        AppMethodBeat.m2504i(137556);
        try {
            i = this.gaq.getCurrentPosition();
            AppMethodBeat.m2505o(137556);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "getCurrentPos", new Object[i]);
            AppMethodBeat.m2505o(137556);
        }
        return i;
    }

    public final int getDuration() {
        int i = 0;
        AppMethodBeat.m2504i(137557);
        try {
            i = this.gaq.getDuration();
            AppMethodBeat.m2505o(137557);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "getDuration", new Object[i]);
            AppMethodBeat.m2505o(137557);
        }
        return i;
    }

    public final void play() {
        AppMethodBeat.m2504i(137558);
        C4990ab.m7416i("MicroMsg.Music.MMMediaPlayer", "play");
        if (bUz()) {
            try {
                if (this.gaq.isPlaying()) {
                    AppMethodBeat.m2505o(137558);
                    return;
                }
                this.gaq.start();
                AppMethodBeat.m2505o(137558);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                AppMethodBeat.m2505o(137558);
                return;
            }
        }
        try {
            this.gaq.prepareAsync();
            AppMethodBeat.m2505o(137558);
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "prepareAsync", new Object[0]);
            AppMethodBeat.m2505o(137558);
        }
    }

    public final void stop() {
        AppMethodBeat.m2504i(137559);
        C4990ab.m7416i("MicroMsg.Music.MMMediaPlayer", "stop");
        this.ovl = true;
        try {
            if (this.gaq != null) {
                this.gaq.stop();
                this.gaq.release();
            }
            if (this.oNw != null) {
                this.oNw.isStop = true;
                this.oNw = null;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "stop", new Object[0]);
        }
        mo46689jz(false);
        AppMethodBeat.m2505o(137559);
    }

    public final void pause() {
        AppMethodBeat.m2504i(137560);
        C4990ab.m7416i("MicroMsg.Music.MMMediaPlayer", "pause");
        if (bUz()) {
            this.gaq.pause();
            AppMethodBeat.m2505o(137560);
            return;
        }
        AppMethodBeat.m2505o(137560);
    }

    public final void seek(long j) {
        AppMethodBeat.m2504i(137561);
        C4990ab.m7417i("MicroMsg.Music.MMMediaPlayer", "seek %d", Long.valueOf(j));
        this.gaq.seekTo((int) j);
        AppMethodBeat.m2505o(137561);
    }

    public final String bUB() {
        return null;
    }
}
