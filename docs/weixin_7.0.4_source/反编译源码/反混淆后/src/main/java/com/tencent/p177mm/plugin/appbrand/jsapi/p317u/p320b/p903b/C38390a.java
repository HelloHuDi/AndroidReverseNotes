package com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b.p903b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b.a */
public final class C38390a extends C45626b {
    int ieB;
    MediaPlayer ieC = new C45289k();
    private OnPreparedListener ieD = new C383891();
    private OnVideoSizeChangedListener ieE = new C271122();
    private OnCompletionListener ieF = new C105323();
    private OnInfoListener ieG = new C271134();
    private OnSeekCompleteListener ieH = new C194925();
    private OnErrorListener ieI = new C383926();
    private OnBufferingUpdateListener ieJ = new C383917();
    boolean ief;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b.a$3 */
    class C105323 implements OnCompletionListener {
        C105323() {
        }

        public final void onCompletion(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(117428);
            C38390a.this.mCurrentState = 6;
            if (C38390a.this.ieO != null) {
                C38390a.this.ieO.onCompletion(mediaPlayer);
            }
            AppMethodBeat.m2505o(117428);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b.a$5 */
    class C194925 implements OnSeekCompleteListener {
        C194925() {
        }

        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(117430);
            if (C38390a.this.ieP != null) {
                C38390a.this.ieP.onSeekComplete(mediaPlayer);
            }
            AppMethodBeat.m2505o(117430);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b.a$2 */
    class C271122 implements OnVideoSizeChangedListener {
        C271122() {
        }

        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(117427);
            if (C38390a.this.ieR != null) {
                C38390a.this.ieR.onVideoSizeChanged(mediaPlayer, i, i2);
            }
            AppMethodBeat.m2505o(117427);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b.a$4 */
    class C271134 implements OnInfoListener {
        C271134() {
        }

        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(117429);
            if (C38390a.this.ieL != null) {
                C38390a.this.ieL.onInfo(mediaPlayer, i, i2);
            }
            AppMethodBeat.m2505o(117429);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b.a$1 */
    class C383891 implements OnPreparedListener {
        C383891() {
        }

        public final void onPrepared(MediaPlayer mediaPlayer) {
            AppMethodBeat.m2504i(117426);
            C38390a.this.mCurrentState = 2;
            if (C38390a.this.ieN != null) {
                C38390a.this.ieN.onPrepared(C38390a.this.ieC);
            }
            int i = C38390a.this.ieB;
            if (i != 0) {
                C38390a.this.seekTo(i);
                C38390a.this.ieB = 0;
            }
            if (C38390a.this.ief) {
                C38390a.this.start();
            }
            AppMethodBeat.m2505o(117426);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b.a$7 */
    class C383917 implements OnBufferingUpdateListener {
        C383917() {
        }

        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            AppMethodBeat.m2504i(117432);
            if (C38390a.this.ieQ != null) {
                C38390a.this.ieQ.onBufferingUpdate(mediaPlayer, i);
            }
            AppMethodBeat.m2505o(117432);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b.a$6 */
    class C383926 implements OnErrorListener {
        C383926() {
        }

        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AppMethodBeat.m2504i(117431);
            if (C38390a.this.ieM != null) {
                C38390a.this.ieM.onError(mediaPlayer, i, i2);
            }
            AppMethodBeat.m2505o(117431);
            return true;
        }
    }

    public C38390a() {
        AppMethodBeat.m2504i(117433);
        AppMethodBeat.m2505o(117433);
    }

    private boolean aGO() {
        return this.ieC != null;
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.m2504i(117435);
        try {
            if (aGO()) {
                this.ieC.setSurface(surface);
            }
            AppMethodBeat.m2505o(117435);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setSurface fail", Integer.valueOf(hashCode()), e);
            m64962oN(-12);
            AppMethodBeat.m2505o(117435);
        }
    }

    private void setVolume(float f, float f2) {
        AppMethodBeat.m2504i(117436);
        try {
            if (aGO()) {
                this.ieC.setVolume(f, f2);
            }
            AppMethodBeat.m2505o(117436);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setVolume fail", Integer.valueOf(hashCode()), e);
            m64962oN(-13);
            AppMethodBeat.m2505o(117436);
        }
    }

    /* renamed from: at */
    public final boolean mo61044at(float f) {
        AppMethodBeat.m2504i(117437);
        if (f <= 0.0f) {
            AppMethodBeat.m2505o(117437);
            return false;
        }
        try {
            if (!aGO() || VERSION.SDK_INT < 23) {
                C4990ab.m7421w("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setSpeed, current system(%d) not support play speed setting", Integer.valueOf(hashCode()), Integer.valueOf(VERSION.SDK_INT));
                AppMethodBeat.m2505o(117437);
                return false;
            }
            PlaybackParams playbackParams = this.ieC.getPlaybackParams();
            playbackParams.setSpeed(f);
            if (this.ieC.isPlaying()) {
                this.ieC.setPlaybackParams(playbackParams);
            } else {
                this.ieC.setPlaybackParams(playbackParams);
                this.ieC.pause();
            }
            AppMethodBeat.m2505o(117437);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setSpeed fail", Integer.valueOf(hashCode()), e);
            m64962oN(-14);
        }
    }

    public final void setMute(boolean z) {
        AppMethodBeat.m2504i(117438);
        if (aGO()) {
            if (z) {
                setVolume(0.0f, 0.0f);
                AppMethodBeat.m2505o(117438);
                return;
            }
            setVolume(1.0f, 1.0f);
        }
        AppMethodBeat.m2505o(117438);
    }

    public final void setLooping(boolean z) {
        AppMethodBeat.m2504i(117439);
        try {
            if (aGO()) {
                this.ieC.setLooping(z);
            }
            AppMethodBeat.m2505o(117439);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setLooping fail", Integer.valueOf(hashCode()), e);
            m64962oN(-10);
            AppMethodBeat.m2505o(117439);
        }
    }

    /* renamed from: oM */
    public final void mo61051oM(int i) {
        if (i > 0) {
            this.ieB = i;
        }
    }

    /* renamed from: eu */
    public final void mo61045eu(boolean z) {
        this.ief = z;
    }

    public final boolean isPlaying() {
        boolean z = false;
        AppMethodBeat.m2504i(117440);
        try {
            if (aGO() && this.mCurrentState != -1) {
                z = this.ieC.isPlaying();
                AppMethodBeat.m2505o(117440);
                return z;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s isPlaying fail", Integer.valueOf(hashCode()), e);
            m64962oN(-9);
        }
        AppMethodBeat.m2505o(117440);
        return z;
    }

    public final int getCurrentPosition() {
        int i = 0;
        AppMethodBeat.m2504i(117441);
        try {
            if (aGO() && (this.mCurrentState == 2 || this.mCurrentState == 3 || this.mCurrentState == 4 || this.mCurrentState == 6)) {
                i = this.ieC.getCurrentPosition();
                AppMethodBeat.m2505o(117441);
                return i;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getCurrentPosition fail", Integer.valueOf(hashCode()), e);
            m64962oN(-15);
        }
        AppMethodBeat.m2505o(117441);
        return i;
    }

    public final int getDuration() {
        int i = 0;
        AppMethodBeat.m2504i(117442);
        try {
            if (!(!aGO() || this.mCurrentState == -1 || this.mCurrentState == 1 || this.mCurrentState == 0)) {
                i = this.ieC.getDuration();
                AppMethodBeat.m2505o(117442);
                return i;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getDuration fail", Integer.valueOf(hashCode()), e);
            m64962oN(-16);
        }
        AppMethodBeat.m2505o(117442);
        return i;
    }

    public final int getVideoWidth() {
        int i = 0;
        AppMethodBeat.m2504i(117443);
        try {
            if (aGO()) {
                i = this.ieC.getVideoWidth();
                AppMethodBeat.m2505o(117443);
                return i;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getVideoWidth fail", Integer.valueOf(hashCode()), e);
            m64962oN(-17);
        }
        AppMethodBeat.m2505o(117443);
        return i;
    }

    public final int getVideoHeight() {
        int i = 0;
        AppMethodBeat.m2504i(117444);
        try {
            if (aGO()) {
                i = this.ieC.getVideoHeight();
                AppMethodBeat.m2505o(117444);
                return i;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s getVideoHeight fail", Integer.valueOf(hashCode()), e);
            m64962oN(-18);
        }
        AppMethodBeat.m2505o(117444);
        return i;
    }

    public final void prepareAsync() {
        AppMethodBeat.m2504i(117445);
        try {
            if (aGO()) {
                this.ieC.prepareAsync();
            }
            AppMethodBeat.m2505o(117445);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s prepareAsync fail", Integer.valueOf(hashCode()), e);
            m64962oN(-6);
            AppMethodBeat.m2505o(117445);
        }
    }

    public final void start() {
        AppMethodBeat.m2504i(117446);
        try {
            if (aGO() && (this.mCurrentState == 2 || this.mCurrentState == 4 || this.mCurrentState == 6)) {
                this.ieC.start();
                this.mCurrentState = 3;
            }
            AppMethodBeat.m2505o(117446);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s start fail", Integer.valueOf(hashCode()), e);
            m64962oN(-1);
            AppMethodBeat.m2505o(117446);
        }
    }

    public final void pause() {
        AppMethodBeat.m2504i(117447);
        try {
            if (aGO()) {
                this.ieC.pause();
                this.mCurrentState = 4;
            }
            AppMethodBeat.m2505o(117447);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s pause fail", Integer.valueOf(hashCode()), e);
            m64962oN(-2);
            AppMethodBeat.m2505o(117447);
        }
    }

    public final void seekTo(int i) {
        AppMethodBeat.m2504i(117448);
        try {
            if (aGO() && (this.mCurrentState == 2 || this.mCurrentState == 3 || this.mCurrentState == 4 || this.mCurrentState == 6)) {
                this.ieC.seekTo(i);
            }
            AppMethodBeat.m2505o(117448);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s seekTo fail", Integer.valueOf(hashCode()), e);
            m64962oN(-3);
            AppMethodBeat.m2505o(117448);
        }
    }

    public final void stop() {
        AppMethodBeat.m2504i(117449);
        try {
            if (aGO() && (this.mCurrentState == 2 || this.mCurrentState == 3 || this.mCurrentState == 4 || this.mCurrentState == 6)) {
                this.ieC.stop();
                this.mCurrentState = 5;
            }
            AppMethodBeat.m2505o(117449);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s stop fail", Integer.valueOf(hashCode()), e);
            m64962oN(-4);
            AppMethodBeat.m2505o(117449);
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(117450);
        try {
            if (aGO()) {
                this.ieC.reset();
                this.mCurrentState = 0;
            }
            AppMethodBeat.m2505o(117450);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s reset fail", Integer.valueOf(hashCode()), e);
            m64962oN(-7);
            AppMethodBeat.m2505o(117450);
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(117451);
        try {
            if (aGO()) {
                aGP();
                this.ieC.release();
                this.mCurrentState = -2;
            }
            AppMethodBeat.m2505o(117451);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s release fail", Integer.valueOf(hashCode()), e);
            m64962oN(-8);
            AppMethodBeat.m2505o(117451);
        }
    }

    private void aGP() {
        AppMethodBeat.m2504i(117452);
        if (this.ieC == null) {
            AppMethodBeat.m2505o(117452);
            return;
        }
        this.ieC.setOnInfoListener(null);
        this.ieC.setOnErrorListener(null);
        this.ieC.setOnPreparedListener(null);
        this.ieC.setOnCompletionListener(null);
        this.ieC.setOnSeekCompleteListener(null);
        this.ieC.setOnBufferingUpdateListener(null);
        this.ieC.setOnVideoSizeChangedListener(null);
        AppMethodBeat.m2505o(117452);
    }

    /* renamed from: oN */
    private void m64962oN(int i) {
        AppMethodBeat.m2504i(117453);
        if (this.ieI != null) {
            this.ieI.onError(this.ieC, -1024, i);
        }
        AppMethodBeat.m2505o(117453);
    }

    public final void setDataSource(String str) {
        AppMethodBeat.m2504i(117434);
        try {
            if (this.ieC == null) {
                this.ieC = new C45289k();
            } else {
                stop();
                reset();
                aGP();
            }
            this.ieC.setScreenOnWhilePlaying(true);
            this.ieC.setAudioStreamType(3);
            this.ieC.setOnInfoListener(this.ieG);
            this.ieC.setOnErrorListener(this.ieI);
            this.ieC.setOnPreparedListener(this.ieD);
            this.ieC.setOnCompletionListener(this.ieF);
            this.ieC.setOnSeekCompleteListener(this.ieH);
            this.ieC.setOnVideoSizeChangedListener(this.ieE);
            this.ieC.setOnBufferingUpdateListener(this.ieJ);
            if (aGO()) {
                this.ieC.setDataSource(str);
                this.mCurrentState = 1;
            }
            AppMethodBeat.m2505o(117434);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandMediaPlayer", "%s setDataSource fail", Integer.valueOf(hashCode()), e);
            m64962oN(-11);
            AppMethodBeat.m2505o(117434);
        }
    }
}
