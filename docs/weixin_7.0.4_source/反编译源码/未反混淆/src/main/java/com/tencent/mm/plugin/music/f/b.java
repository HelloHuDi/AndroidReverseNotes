package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends com.tencent.mm.plugin.music.f.a.b {
    MediaPlayer gaq;
    a oNw;
    boolean ovl = true;

    class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(137552);
            ab.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (b.this.gaq != null && b.this.gaq.isPlaying()) {
                        int currentPosition = b.this.gaq.getCurrentPosition();
                        int duration = b.this.gaq.getDuration();
                        if (currentPosition > 0 && duration > 0) {
                            b.this.zR((currentPosition * 100) / duration);
                        }
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "onPlayUpdate", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                    ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "sleep", new Object[0]);
                }
            }
            AppMethodBeat.o(137552);
        }
    }

    public b() {
        AppMethodBeat.i(137553);
        com.tencent.mm.plugin.music.e.b bVar = (com.tencent.mm.plugin.music.e.b) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.e.b.class);
        if (bVar != null) {
            this.gaq = bVar.bTR();
        } else {
            ab.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
        }
        if (this.gaq == null) {
            this.gaq = new MediaPlayer();
        }
        this.gaq.setAudioStreamType(3);
        this.gaq.setOnCompletionListener(new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(137548);
                ab.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
                b.this.jz(true);
                AppMethodBeat.o(137548);
            }
        });
        this.gaq.setOnSeekCompleteListener(new OnSeekCompleteListener() {
            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(137549);
                if (b.this.gaq != null && b.this.gaq.isPlaying()) {
                    ab.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
                    try {
                        b.this.gaq.start();
                        AppMethodBeat.o(137549);
                        return;
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                    }
                }
                AppMethodBeat.o(137549);
            }
        });
        this.gaq.setOnPreparedListener(new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(137550);
                if (b.this.gaq != null) {
                    ab.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
                    try {
                        b.this.gaq.start();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                    }
                    b.this.ovl = false;
                    b.this.onStart();
                    if (b.this.oNw != null) {
                        b.this.oNw.isStop = true;
                    }
                    b.this.oNw = new a(b.this, (byte) 0);
                    a aVar = b.this.oNw;
                    aVar.isStop = false;
                    d.post(aVar, "music_play_progress_runnable");
                }
                AppMethodBeat.o(137550);
            }
        });
        this.gaq.setOnErrorListener(new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(137551);
                ab.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
                b.this.jy(false);
                AppMethodBeat.o(137551);
                return false;
            }
        });
        AppMethodBeat.o(137553);
    }

    public final boolean isPlaying() {
        boolean z = false;
        AppMethodBeat.i(137554);
        try {
            z = this.gaq.isPlaying();
            AppMethodBeat.o(137554);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[z]);
            AppMethodBeat.o(137554);
        }
        return z;
    }

    public final boolean bUz() {
        return !this.ovl;
    }

    public final void Tr(String str) {
        AppMethodBeat.i(137555);
        ab.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", str);
        try {
            this.gaq.setDataSource(str);
            AppMethodBeat.o(137555);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[0]);
            AppMethodBeat.o(137555);
        }
    }

    public final int bUA() {
        int i = 0;
        AppMethodBeat.i(137556);
        try {
            i = this.gaq.getCurrentPosition();
            AppMethodBeat.o(137556);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "getCurrentPos", new Object[i]);
            AppMethodBeat.o(137556);
        }
        return i;
    }

    public final int getDuration() {
        int i = 0;
        AppMethodBeat.i(137557);
        try {
            i = this.gaq.getDuration();
            AppMethodBeat.o(137557);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "getDuration", new Object[i]);
            AppMethodBeat.o(137557);
        }
        return i;
    }

    public final void play() {
        AppMethodBeat.i(137558);
        ab.i("MicroMsg.Music.MMMediaPlayer", "play");
        if (bUz()) {
            try {
                if (this.gaq.isPlaying()) {
                    AppMethodBeat.o(137558);
                    return;
                }
                this.gaq.start();
                AppMethodBeat.o(137558);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                AppMethodBeat.o(137558);
                return;
            }
        }
        try {
            this.gaq.prepareAsync();
            AppMethodBeat.o(137558);
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "prepareAsync", new Object[0]);
            AppMethodBeat.o(137558);
        }
    }

    public final void stop() {
        AppMethodBeat.i(137559);
        ab.i("MicroMsg.Music.MMMediaPlayer", "stop");
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
            ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "stop", new Object[0]);
        }
        jz(false);
        AppMethodBeat.o(137559);
    }

    public final void pause() {
        AppMethodBeat.i(137560);
        ab.i("MicroMsg.Music.MMMediaPlayer", "pause");
        if (bUz()) {
            this.gaq.pause();
            AppMethodBeat.o(137560);
            return;
        }
        AppMethodBeat.o(137560);
    }

    public final void seek(long j) {
        AppMethodBeat.i(137561);
        ab.i("MicroMsg.Music.MMMediaPlayer", "seek %d", Long.valueOf(j));
        this.gaq.seekTo((int) j);
        AppMethodBeat.o(137561);
    }

    public final String bUB() {
        return null;
    }
}
