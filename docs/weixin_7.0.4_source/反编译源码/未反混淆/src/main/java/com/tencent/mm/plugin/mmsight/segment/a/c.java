package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class c implements a {
    private ap fJs;
    int oAd;
    int oAe;
    private a oAk;
    private HandlerThread oAl = d.ek("check auto job", 10);
    com.tencent.mm.plugin.mmsight.segment.a.a.c oAm = null;
    private com.tencent.mm.plugin.mmsight.segment.a.a.c oAn = new com.tencent.mm.plugin.mmsight.segment.a.a.c() {
        public final void cf(Object obj) {
            AppMethodBeat.i(3724);
            if (c.this.oAm != null) {
                c.this.oAm.cf(obj);
            }
            AppMethodBeat.o(3724);
        }
    };
    private com.tencent.mm.sdk.platformtools.ap.a oAo = new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(3725);
            if (c.this.released) {
                AppMethodBeat.o(3725);
                return false;
            }
            try {
                if (c.this.isPlaying()) {
                    int currentPosition = c.this.getCurrentPosition();
                    if (c.this.ozL != null) {
                        c.this.ozL.yY(currentPosition);
                    }
                    ab.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", Integer.valueOf(currentPosition), Integer.valueOf(c.this.oAd), Integer.valueOf(c.this.oAe), Integer.valueOf(c.this.getDuration()));
                    if (currentPosition < c.this.oAe) {
                        AppMethodBeat.o(3725);
                        return true;
                    }
                    ab.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", Integer.valueOf(c.this.oAe));
                    c.this.seekTo(c.this.oAd);
                    AppMethodBeat.o(3725);
                    return false;
                }
                AppMethodBeat.o(3725);
                return true;
            } catch (IllegalStateException e) {
                ab.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", e.getMessage());
                if (c.this.released) {
                    AppMethodBeat.o(3725);
                    return false;
                }
                AppMethodBeat.o(3725);
                return true;
            }
        }
    };
    public a ozL;
    boolean released;

    public interface a {
        void yY(int i);
    }

    public c() {
        AppMethodBeat.i(3726);
        int i = CaptureMMProxy.getInstance().getInt(com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_CLIP_PREVIEW_MEDIA_PLAYER_INT_SYNC, -1);
        if (i == 1) {
            ab.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
            this.oAk = new d();
        } else if (i == 2) {
            ab.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
            this.oAk = new b();
        } else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer()) {
            ab.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
            this.oAk = new b();
        } else {
            ab.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
            this.oAk = new d();
        }
        this.oAl.start();
        this.fJs = new ap(this.oAl.getLooper(), this.oAo, true);
        AppMethodBeat.o(3726);
    }

    public final void setLoop(int i, int i2) {
        AppMethodBeat.i(3727);
        this.oAd = i;
        this.oAe = i2;
        if (this.oAk != null) {
            this.oAk.setLoop(this.oAd, this.oAe);
        }
        AppMethodBeat.o(3727);
    }

    public final void setDataSource(String str) {
        AppMethodBeat.i(3728);
        this.oAk.setDataSource(str);
        AppMethodBeat.o(3728);
    }

    public final void release() {
        AppMethodBeat.i(3729);
        this.released = true;
        this.oAk.release();
        if (this.fJs != null) {
            this.fJs.stopTimer();
        }
        if (this.oAl != null) {
            this.oAl.quit();
        }
        AppMethodBeat.o(3729);
    }

    public final void start() {
        AppMethodBeat.i(3730);
        this.oAk.start();
        this.fJs.ae(30, 30);
        AppMethodBeat.o(3730);
    }

    public final void pause() {
        AppMethodBeat.i(3731);
        this.oAk.pause();
        this.fJs.stopTimer();
        AppMethodBeat.o(3731);
    }

    public final void stop() {
        AppMethodBeat.i(3732);
        this.oAk.stop();
        this.fJs.stopTimer();
        AppMethodBeat.o(3732);
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.c cVar) {
        AppMethodBeat.i(3733);
        this.oAk.a(cVar);
        AppMethodBeat.o(3733);
    }

    public final void setAudioStreamType(int i) {
        AppMethodBeat.i(3734);
        this.oAk.setAudioStreamType(i);
        AppMethodBeat.o(3734);
    }

    public final int getCurrentPosition() {
        AppMethodBeat.i(3735);
        int currentPosition = this.oAk.getCurrentPosition();
        AppMethodBeat.o(3735);
        return currentPosition;
    }

    public final int getDuration() {
        AppMethodBeat.i(3736);
        if (this.oAk != null) {
            int duration = this.oAk.getDuration();
            AppMethodBeat.o(3736);
            return duration;
        }
        AppMethodBeat.o(3736);
        return 0;
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.i(3737);
        this.oAk.setSurface(surface);
        AppMethodBeat.o(3737);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(3738);
        boolean isPlaying = this.oAk.isPlaying();
        AppMethodBeat.o(3738);
        return isPlaying;
    }

    public final void seekTo(int i) {
        AppMethodBeat.i(3739);
        this.oAk.seekTo(i);
        AppMethodBeat.o(3739);
    }

    public final void prepareAsync() {
        AppMethodBeat.i(3740);
        this.oAk.prepareAsync();
        AppMethodBeat.o(3740);
    }

    public final void setLooping(boolean z) {
        AppMethodBeat.i(3741);
        this.oAk.setLooping(z);
        AppMethodBeat.o(3741);
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.a aVar) {
        AppMethodBeat.i(3742);
        this.oAk.a(aVar);
        AppMethodBeat.o(3742);
    }

    public final void a(a.d dVar) {
        AppMethodBeat.i(3743);
        this.oAk.a(dVar);
        AppMethodBeat.o(3743);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(3744);
        this.oAk.a(bVar);
        AppMethodBeat.o(3744);
    }
}
