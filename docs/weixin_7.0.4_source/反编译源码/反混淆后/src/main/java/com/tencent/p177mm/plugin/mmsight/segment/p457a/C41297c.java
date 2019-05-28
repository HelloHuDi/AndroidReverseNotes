package com.tencent.p177mm.plugin.mmsight.segment.p457a;

import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C21307a;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C28510b;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C39398c;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C39399d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.a.c */
public final class C41297c implements C39397a {
    private C7564ap fJs;
    int oAd;
    int oAe;
    private C39397a oAk;
    private HandlerThread oAl = C7305d.m12297ek("check auto job", 10);
    C39398c oAm = null;
    private C39398c oAn = new C34901();
    private C5015a oAo = new C125722();
    public C41298a ozL;
    boolean released;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a.c$1 */
    class C34901 implements C39398c {
        C34901() {
        }

        /* renamed from: cf */
        public final void mo7952cf(Object obj) {
            AppMethodBeat.m2504i(3724);
            if (C41297c.this.oAm != null) {
                C41297c.this.oAm.mo7952cf(obj);
            }
            AppMethodBeat.m2505o(3724);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a.c$2 */
    class C125722 implements C5015a {
        C125722() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(3725);
            if (C41297c.this.released) {
                AppMethodBeat.m2505o(3725);
                return false;
            }
            try {
                if (C41297c.this.isPlaying()) {
                    int currentPosition = C41297c.this.getCurrentPosition();
                    if (C41297c.this.ozL != null) {
                        C41297c.this.ozL.mo17642yY(currentPosition);
                    }
                    C4990ab.m7411d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", Integer.valueOf(currentPosition), Integer.valueOf(C41297c.this.oAd), Integer.valueOf(C41297c.this.oAe), Integer.valueOf(C41297c.this.getDuration()));
                    if (currentPosition < C41297c.this.oAe) {
                        AppMethodBeat.m2505o(3725);
                        return true;
                    }
                    C4990ab.m7417i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", Integer.valueOf(C41297c.this.oAe));
                    C41297c.this.seekTo(C41297c.this.oAd);
                    AppMethodBeat.m2505o(3725);
                    return false;
                }
                AppMethodBeat.m2505o(3725);
                return true;
            } catch (IllegalStateException e) {
                C4990ab.m7413e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", e.getMessage());
                if (C41297c.this.released) {
                    AppMethodBeat.m2505o(3725);
                    return false;
                }
                AppMethodBeat.m2505o(3725);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a.c$a */
    public interface C41298a {
        /* renamed from: yY */
        void mo17642yY(int i);
    }

    public C41297c() {
        AppMethodBeat.m2504i(3726);
        int i = CaptureMMProxy.getInstance().getInt(C5127a.USERINFO_LOCAL_SIGHT_CLIP_PREVIEW_MEDIA_PLAYER_INT_SYNC, -1);
        if (i == 1) {
            C4990ab.m7416i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
            this.oAk = new C28511d();
        } else if (i == 2) {
            C4990ab.m7416i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
            this.oAk = new C46081b();
        } else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer()) {
            C4990ab.m7416i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
            this.oAk = new C46081b();
        } else {
            C4990ab.m7416i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
            this.oAk = new C28511d();
        }
        this.oAl.start();
        this.fJs = new C7564ap(this.oAl.getLooper(), this.oAo, true);
        AppMethodBeat.m2505o(3726);
    }

    public final void setLoop(int i, int i2) {
        AppMethodBeat.m2504i(3727);
        this.oAd = i;
        this.oAe = i2;
        if (this.oAk != null) {
            this.oAk.setLoop(this.oAd, this.oAe);
        }
        AppMethodBeat.m2505o(3727);
    }

    public final void setDataSource(String str) {
        AppMethodBeat.m2504i(3728);
        this.oAk.setDataSource(str);
        AppMethodBeat.m2505o(3728);
    }

    public final void release() {
        AppMethodBeat.m2504i(3729);
        this.released = true;
        this.oAk.release();
        if (this.fJs != null) {
            this.fJs.stopTimer();
        }
        if (this.oAl != null) {
            this.oAl.quit();
        }
        AppMethodBeat.m2505o(3729);
    }

    public final void start() {
        AppMethodBeat.m2504i(3730);
        this.oAk.start();
        this.fJs.mo16770ae(30, 30);
        AppMethodBeat.m2505o(3730);
    }

    public final void pause() {
        AppMethodBeat.m2504i(3731);
        this.oAk.pause();
        this.fJs.stopTimer();
        AppMethodBeat.m2505o(3731);
    }

    public final void stop() {
        AppMethodBeat.m2504i(3732);
        this.oAk.stop();
        this.fJs.stopTimer();
        AppMethodBeat.m2505o(3732);
    }

    /* renamed from: a */
    public final void mo46478a(C39398c c39398c) {
        AppMethodBeat.m2504i(3733);
        this.oAk.mo46478a(c39398c);
        AppMethodBeat.m2505o(3733);
    }

    public final void setAudioStreamType(int i) {
        AppMethodBeat.m2504i(3734);
        this.oAk.setAudioStreamType(i);
        AppMethodBeat.m2505o(3734);
    }

    public final int getCurrentPosition() {
        AppMethodBeat.m2504i(3735);
        int currentPosition = this.oAk.getCurrentPosition();
        AppMethodBeat.m2505o(3735);
        return currentPosition;
    }

    public final int getDuration() {
        AppMethodBeat.m2504i(3736);
        if (this.oAk != null) {
            int duration = this.oAk.getDuration();
            AppMethodBeat.m2505o(3736);
            return duration;
        }
        AppMethodBeat.m2505o(3736);
        return 0;
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.m2504i(3737);
        this.oAk.setSurface(surface);
        AppMethodBeat.m2505o(3737);
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(3738);
        boolean isPlaying = this.oAk.isPlaying();
        AppMethodBeat.m2505o(3738);
        return isPlaying;
    }

    public final void seekTo(int i) {
        AppMethodBeat.m2504i(3739);
        this.oAk.seekTo(i);
        AppMethodBeat.m2505o(3739);
    }

    public final void prepareAsync() {
        AppMethodBeat.m2504i(3740);
        this.oAk.prepareAsync();
        AppMethodBeat.m2505o(3740);
    }

    public final void setLooping(boolean z) {
        AppMethodBeat.m2504i(3741);
        this.oAk.setLooping(z);
        AppMethodBeat.m2505o(3741);
    }

    /* renamed from: a */
    public final void mo46476a(C21307a c21307a) {
        AppMethodBeat.m2504i(3742);
        this.oAk.mo46476a(c21307a);
        AppMethodBeat.m2505o(3742);
    }

    /* renamed from: a */
    public final void mo46479a(C39399d c39399d) {
        AppMethodBeat.m2504i(3743);
        this.oAk.mo46479a(c39399d);
        AppMethodBeat.m2505o(3743);
    }

    /* renamed from: a */
    public final void mo46477a(C28510b c28510b) {
        AppMethodBeat.m2504i(3744);
        this.oAk.mo46477a(c28510b);
        AppMethodBeat.m2505o(3744);
    }
}
