package com.tencent.mm.plugin.music.d;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.h.m;
import com.google.android.exoplayer2.h.o;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.net.URL;

public final class a extends com.tencent.mm.plugin.music.f.a implements com.google.android.exoplayer2.h.d.a, com.google.android.exoplayer2.metadata.e.a {
    Handler awA = new Handler(Looper.myLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(137475);
            if (100 == message.what) {
                long duration = a.this.oLD.getDuration();
                long currentPosition = a.this.oLD.getCurrentPosition();
                long bufferedPosition = a.this.oLD.getBufferedPosition();
                long bufferedPercentage = (long) a.this.oLD.getBufferedPercentage();
                ab.i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", Long.valueOf(duration), Long.valueOf(currentPosition), Long.valueOf(bufferedPosition), Long.valueOf(bufferedPercentage));
                a.this.awA.removeMessages(100);
                if (a.this.oKe) {
                    a.this.awA.sendEmptyMessageDelayed(100, 5000);
                }
            }
            AppMethodBeat.o(137475);
        }
    };
    boolean bjP = false;
    private long bqO;
    int bqQ = 0;
    private String cle = "";
    boolean oKe;
    private long oKj = 0;
    com.tencent.mm.aw.e oLA;
    private com.tencent.mm.aw.c oLB;
    int oLC = 0;
    v oLD;
    private com.google.android.exoplayer2.g.c oLE;
    private k oLF;
    private com.google.android.exoplayer2.h.f.a oLG;
    private i oLH;
    f oLI = new f();
    a oLJ = new a(this, (byte) 0);
    e oLK = new e(this, (byte) 0);
    d oLL = new d(this, (byte) 0);
    b oLM = new c();
    public boolean oLN = false;
    int startTime = 0;
    protected String userAgent;

    public interface b {
        void bTK();

        void bTL();

        void bTM();

        void bTN();

        void bTO();

        void bTP();

        void eH(int i, int i2);

        void zE(int i);
    }

    public class c implements b {
        public final void bTK() {
            AppMethodBeat.i(137482);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
            if (a.this.oLA != null) {
                a.this.z(a.this.oLA);
            }
            if (a.this.startTime > 0) {
                ab.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", Integer.valueOf(a.this.startTime));
                a.this.lP(a.this.startTime);
            }
            if (a.this.startTime == 0 && !a.this.oLD.pP()) {
                ab.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
                a.this.oLD.aE(true);
            }
            AppMethodBeat.o(137482);
        }

        public final void bTL() {
            AppMethodBeat.i(137483);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
            if (a.this.oLA != null) {
                a.this.A(a.this.oLA);
            }
            AppMethodBeat.o(137483);
        }

        public final void bTM() {
            AppMethodBeat.i(137484);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (!(a.this.oLA == null || a.this.oLD.pP())) {
                a.this.C(a.this.oLA);
            }
            AppMethodBeat.o(137484);
        }

        public final void bTN() {
            AppMethodBeat.i(137485);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (a.this.oLA != null) {
                a.this.D(a.this.oLA);
            }
            AppMethodBeat.o(137485);
        }

        public final void bTO() {
            AppMethodBeat.i(137486);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
            if (a.this.oLA != null) {
                a.this.E(a.this.oLA);
            }
            if (!(a.this.startTime <= 0 || a.this.oLD == null || a.this.oLD.pP())) {
                ab.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete, stay play hls");
                a.this.startTime = 0;
                a.this.oLD.aE(true);
            }
            AppMethodBeat.o(137486);
        }

        public final void bTP() {
            AppMethodBeat.i(137487);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
            if (a.this.oLA != null) {
                a.this.G(a.this.oLA);
            }
            a.this.oKe = false;
            a.this.awA.removeMessages(100);
            AppMethodBeat.o(137487);
        }

        public final void zE(int i) {
            AppMethodBeat.i(137488);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", Integer.valueOf(i));
            AppMethodBeat.o(137488);
        }

        public final void eH(int i, int i2) {
            AppMethodBeat.i(137489);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (a.this.oLA != null) {
                a.this.a(a.this.oLA, i, i2);
            }
            if (a.this.oLD != null) {
                a.this.oLD.aE(false);
                a.this.oLD.stop();
            }
            a.this.oKe = false;
            a.this.awA.removeMessages(100);
            a aVar = a.this;
            aVar.bqQ++;
            if (a.this.bqQ == 1) {
                a.a(a.this, a.this.oLA, i, i2);
            }
            AppMethodBeat.o(137489);
        }
    }

    class e implements com.google.android.exoplayer2.a.e {
        private e() {
        }

        /* synthetic */ e(a aVar, byte b) {
            this();
        }

        public final void c(com.google.android.exoplayer2.b.d dVar) {
            AppMethodBeat.i(137494);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + a.this.bTJ() + "]");
            AppMethodBeat.o(137494);
        }

        public final void dx(int i) {
            AppMethodBeat.i(137495);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + i + "]");
            AppMethodBeat.o(137495);
        }

        public final void b(String str, long j, long j2) {
            AppMethodBeat.i(137496);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + a.this.bTJ() + ", " + str + "]");
            AppMethodBeat.o(137496);
        }

        public final void d(Format format) {
            AppMethodBeat.i(137497);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + a.this.bTJ() + ", " + Format.a(format) + "]");
            AppMethodBeat.o(137497);
        }

        public final void d(com.google.android.exoplayer2.b.d dVar) {
            AppMethodBeat.i(137498);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + a.this.bTJ() + "]");
            AppMethodBeat.o(137498);
        }

        public final void d(int i, long j, long j2) {
            AppMethodBeat.i(137499);
            a.a(a.this, "audioTrackUnderrun [" + i + ", " + j + ", " + j2 + "]", null);
            AppMethodBeat.o(137499);
        }
    }

    class d implements com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.g.a {
        private d() {
        }

        /* synthetic */ d(a aVar, byte b) {
            this();
        }

        public final void a(com.google.android.exoplayer2.h.i iVar, Format format, IOException iOException) {
            AppMethodBeat.i(137490);
            a.a(a.this, "loadError", (Exception) iOException);
            if (!(iVar == null || format == null)) {
                ab.e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", iVar.uri, format.toString());
            }
            a.b(a.this);
            AppMethodBeat.o(137490);
        }

        public final void rO() {
            AppMethodBeat.i(137491);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
            AppMethodBeat.o(137491);
        }

        public final void onLoadError(IOException iOException) {
            AppMethodBeat.i(137492);
            a.a(a.this, "loadError", (Exception) iOException);
            ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", iOException, "onLoadError", new Object[0]);
            a.b(a.this);
            AppMethodBeat.o(137492);
        }

        public final void rP() {
            AppMethodBeat.i(137493);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
            a.this.bjP = true;
            AppMethodBeat.o(137493);
        }
    }

    class a implements com.google.android.exoplayer2.f.a {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void aH(boolean z) {
            AppMethodBeat.i(137477);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "loading [" + z + "]");
            AppMethodBeat.o(137477);
        }

        public final void c(boolean z, int i) {
            AppMethodBeat.i(137478);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "state [" + a.this.bTJ() + ", " + z + ", " + com.tencent.mm.plugin.music.f.b.a.zT(i) + "]");
            a aVar = a.this;
            if (aVar.oLD != null) {
                boolean pP = aVar.oLD.pP();
                int pO = aVar.oLD.pO();
                if (pP && pO == 3) {
                    ab.i("MicroMsg.Music.ExoMusicPlayer", "onStart");
                    if (aVar.oLM != null) {
                        aVar.oLM.bTL();
                    }
                } else if (!pP && pO == 3 && aVar.oLC == 2) {
                    ab.i("MicroMsg.Music.ExoMusicPlayer", "onPause");
                    if (aVar.oLM != null) {
                        aVar.oLM.bTM();
                    }
                } else if (!pP && pO == 3 && aVar.oLC == 3) {
                    ab.i("MicroMsg.Music.ExoMusicPlayer", "onStop");
                    if (aVar.oLM != null) {
                        aVar.oLM.bTN();
                    }
                }
                int z2 = f.z(pP, pO);
                if (z2 != aVar.oLI.oLP[3]) {
                    ab.i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + pP + "," + pO + "]");
                    aVar.oLI.y(pP, pO);
                    if (z2 == f.z(true, 4)) {
                        ab.i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
                        if (aVar.oLM != null) {
                            aVar.oLM.bTP();
                        }
                        AppMethodBeat.o(137478);
                        return;
                    }
                    if (aVar.oLI.b(new int[]{f.z(false, 1), f.z(false, 2), f.z(false, 3)}, false)) {
                        ab.i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
                        if (aVar.oLM != null) {
                            aVar.oLM.bTK();
                        }
                        AppMethodBeat.o(137478);
                        return;
                    } else if (((aVar.oLI.b(new int[]{100, 2, 3}, true) | aVar.oLI.b(new int[]{2, 100, 3}, true)) | aVar.oLI.b(new int[]{100, 3, 2, 3}, true)) != 0) {
                        ab.i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
                        if (aVar.oLM != null) {
                            aVar.oLM.bTO();
                        }
                        AppMethodBeat.o(137478);
                        return;
                    } else {
                        if (aVar.oLI.b(new int[]{f.z(true, 3), f.z(true, 2)}, false)) {
                            ab.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
                            aVar.eG(701, aVar.getDownloadPercent());
                            AppMethodBeat.o(137478);
                            return;
                        }
                        if (aVar.oLI.b(new int[]{f.z(true, 2), f.z(true, 3)}, false)) {
                            ab.i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
                            aVar.eG(702, aVar.getDownloadPercent());
                        }
                    }
                }
            }
            AppMethodBeat.o(137478);
        }

        public final void a(com.google.android.exoplayer2.e eVar) {
            AppMethodBeat.i(137479);
            ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "playerFailed [" + a.this.bTJ() + "]", new Object[0]);
            a aVar = a.this;
            if (eVar != null) {
                Throwable cause = eVar.getCause();
                if (cause == null) {
                    aVar.eF(-4999, -1);
                } else if (cause instanceof com.google.android.exoplayer2.h.r.c) {
                    if (cause.toString().contains("Unable to connect")) {
                        boolean isNetworkConnected = at.isNetworkConnected(ah.getContext());
                        ab.e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + isNetworkConnected + " caused by:\n" + cause.toString());
                        if (isNetworkConnected) {
                            aVar.eF(-4000, -3);
                            AppMethodBeat.o(137479);
                            return;
                        }
                        aVar.eF(-4000, -2);
                        AppMethodBeat.o(137479);
                        return;
                    } else if (cause instanceof com.google.android.exoplayer2.h.r.e) {
                        String th = cause.toString();
                        if (th.contains("403")) {
                            aVar.eF(-4000, -10);
                        } else if (th.contains("404")) {
                            aVar.eF(-4000, -11);
                        } else if (th.contains("500")) {
                            aVar.eF(-4000, -12);
                        } else if (th.contains("502")) {
                            aVar.eF(-4000, -13);
                        } else {
                            aVar.eF(-4000, -30);
                        }
                    }
                } else if (cause instanceof q) {
                    aVar.eF(-4001, -1);
                } else if (cause instanceof IllegalStateException) {
                    aVar.eF(-4002, -1);
                } else if (cause instanceof com.google.android.exoplayer2.e.b.a) {
                    aVar.eF(-4003, -1);
                } else {
                    aVar.eF(-4999, -1);
                }
            }
            ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", eVar, "ExoPlaybackException", new Object[0]);
            AppMethodBeat.o(137479);
        }

        public final void qe() {
            AppMethodBeat.i(137480);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
            AppMethodBeat.o(137480);
        }

        public final void a(p pVar) {
            AppMethodBeat.i(137481);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[]{Float.valueOf(pVar.speed), Float.valueOf(pVar.pitch)}));
            AppMethodBeat.o(137481);
        }
    }

    static class f {
        int[] oLP;

        private f() {
            AppMethodBeat.i(137500);
            this.oLP = new int[]{1, 1, 1, 1};
            AppMethodBeat.o(137500);
        }

        /* synthetic */ f(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void y(boolean z, int i) {
            AppMethodBeat.i(137501);
            int z2 = z(z, i);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + z + "," + i + "], lastState=" + this.oLP[3] + ",newState=" + z2);
            if (this.oLP[3] == z2) {
                AppMethodBeat.o(137501);
                return;
            }
            this.oLP[0] = this.oLP[1];
            this.oLP[1] = this.oLP[2];
            this.oLP[2] = this.oLP[3];
            this.oLP[3] = z2;
            ab.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.oLP[0] + "," + this.oLP[1] + "," + this.oLP[2] + "," + this.oLP[3] + "]");
            AppMethodBeat.o(137501);
        }

        static int z(boolean z, int i) {
            return (z ? -268435456 : 0) | i;
        }

        /* Access modifiers changed, original: final */
        public final boolean b(int[] iArr, boolean z) {
            int i = z ? 268435455 : -1;
            int length = this.oLP.length - iArr.length;
            int i2 = 1;
            for (int i3 = length; i3 < this.oLP.length; i3++) {
                i2 &= (this.oLP[i3] & i) == (iArr[i3 - length] & i) ? 1 : 0;
            }
            return i2;
        }
    }

    static /* synthetic */ void a(a aVar, com.tencent.mm.aw.e eVar, int i, int i2) {
        AppMethodBeat.i(137526);
        aVar.b(eVar, i, i2);
        AppMethodBeat.o(137526);
    }

    public a() {
        AppMethodBeat.i(137502);
        com.tencent.mm.plugin.music.f.b.a.bUI();
        AppMethodBeat.o(137502);
    }

    public final void f(com.tencent.mm.aw.e eVar) {
        AppMethodBeat.i(137503);
        super.f(eVar);
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oKj;
        if (this.oLA != null && this.oLA.e(eVar) && j <= 1000) {
            this.oLA = eVar;
            ab.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.cle, Long.valueOf(j));
            AppMethodBeat.o(137503);
        } else if (eVar == null) {
            ab.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
            AppMethodBeat.o(137503);
        } else {
            if (this.oNt != null) {
                this.oNt.s(eVar);
            }
            this.oKj = currentTimeMillis;
            ab.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(eVar.startTime));
            if (this.oLD != null && aie()) {
                this.oLD.stop();
            }
            this.bqQ = 0;
            this.startTime = eVar.startTime;
            this.bqO = SystemClock.elapsedRealtime();
            this.oLA = eVar;
            y(this.oLA);
            ab.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", Integer.valueOf(this.startTime));
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(137476);
                    a.a(a.this);
                    AppMethodBeat.o(137476);
                }
            });
            AppMethodBeat.o(137503);
        }
    }

    public final void bTI() {
        AppMethodBeat.i(137504);
        this.oNt = (com.tencent.mm.plugin.music.e.d) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.e.d.class);
        this.oNu = com.tencent.mm.plugin.music.e.k.bUf().oLX;
        AppMethodBeat.o(137504);
    }

    public final void pause() {
        AppMethodBeat.i(137505);
        this.oLN = false;
        ab.i("MicroMsg.Music.ExoMusicPlayer", "pause");
        if (this.oLD != null) {
            this.oLC = 2;
            this.oLD.aE(false);
        }
        AppMethodBeat.o(137505);
    }

    public final boolean aif() {
        return this.oKe && this.oLN;
    }

    public final void bSN() {
        AppMethodBeat.i(137506);
        this.oLN = true;
        ab.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
        if (this.oLD != null) {
            this.oLC = 2;
            this.oLD.aE(false);
        }
        AppMethodBeat.o(137506);
    }

    public final void bTb() {
        AppMethodBeat.i(137507);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
        pause();
        com.tencent.mm.plugin.music.e.k.bUh().bSK();
        AppMethodBeat.o(137507);
    }

    public final void resume() {
        AppMethodBeat.i(137508);
        this.bqQ = 0;
        boolean bTc = bTc();
        boolean aie = aie();
        ab.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", Boolean.valueOf(bTc), Boolean.valueOf(aie));
        if (this.oLD != null) {
            if (com.tencent.mm.plugin.music.e.k.bUh().requestFocus()) {
                this.oLC = 1;
                this.oLD.aE(true);
                B(this.oLA);
            } else {
                ab.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
            }
            this.oKe = true;
        }
        AppMethodBeat.o(137508);
    }

    public final boolean aie() {
        AppMethodBeat.i(137509);
        if (this.oLD == null) {
            AppMethodBeat.o(137509);
            return false;
        }
        switch (this.oLD.pO()) {
            case 1:
            case 3:
                boolean pP = this.oLD.pP();
                AppMethodBeat.o(137509);
                return pP;
            default:
                AppMethodBeat.o(137509);
                return false;
        }
    }

    private boolean bTc() {
        AppMethodBeat.i(137510);
        if (this.oLD != null) {
            boolean isLoading = this.oLD.isLoading();
            AppMethodBeat.o(137510);
            return isLoading;
        }
        AppMethodBeat.o(137510);
        return false;
    }

    public final boolean aig() {
        AppMethodBeat.i(137511);
        if (!this.oKe || bTc()) {
            AppMethodBeat.o(137511);
            return false;
        }
        AppMethodBeat.o(137511);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.i(137512);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
        try {
            if (this.oLD != null) {
                this.oLC = 3;
                this.oLD.aE(false);
                this.oLD.stop();
                D(this.oLA);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e, "stopPlay", new Object[0]);
            d(this.oLA, 504);
            b(this.oLA, -4005, -42);
        }
        com.tencent.mm.plugin.music.e.k.bUh().bSK();
        this.oKe = false;
        this.oLN = false;
        this.awA.removeMessages(100);
        AppMethodBeat.o(137512);
    }

    public final int bTi() {
        AppMethodBeat.i(137513);
        if (this.oLD != null) {
            int currentPosition = (int) this.oLD.getCurrentPosition();
            AppMethodBeat.o(137513);
            return currentPosition;
        }
        AppMethodBeat.o(137513);
        return 0;
    }

    public final int getDuration() {
        AppMethodBeat.i(137514);
        if (this.oLD != null) {
            int duration = (int) this.oLD.getDuration();
            AppMethodBeat.o(137514);
            return duration;
        }
        AppMethodBeat.o(137514);
        return 0;
    }

    public final int getDownloadPercent() {
        AppMethodBeat.i(137515);
        if (this.oLD != null) {
            int bufferedPercentage = this.oLD.getBufferedPercentage();
            AppMethodBeat.o(137515);
            return bufferedPercentage;
        }
        AppMethodBeat.o(137515);
        return 0;
    }

    public final boolean lP(int i) {
        boolean z = false;
        AppMethodBeat.i(137516);
        int duration = getDuration();
        ab.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0 || i > duration) {
            ab.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            AppMethodBeat.o(137516);
            return false;
        }
        if (this.oLD != null) {
            F(this.oLA);
            f fVar = this.oLI;
            if ((this.oLI.oLP[3] & -268435456) != 0) {
                z = true;
            }
            fVar.y(z, 100);
            this.oLC = 4;
            this.oLD.seekTo((long) i);
        }
        AppMethodBeat.o(137516);
        return true;
    }

    public final com.tencent.mm.aw.c bSP() {
        int i = 0;
        AppMethodBeat.i(137517);
        int duration = getDuration();
        int bTi = bTi();
        boolean aie = aie();
        int downloadPercent = getDownloadPercent();
        if (downloadPercent < 0) {
            downloadPercent = 0;
        }
        if ((this.oLH instanceof h) && !this.bjP) {
            duration = 0;
        }
        if (this.oLB != null) {
            com.tencent.mm.aw.c cVar = this.oLB;
            if (aie) {
                i = 1;
            }
            cVar.t(duration, bTi, i, downloadPercent);
        } else {
            if (aie) {
                i = 1;
            }
            this.oLB = new com.tencent.mm.aw.c(duration, bTi, i, downloadPercent);
        }
        this.oLB.cFJ = true;
        this.oLB.fJR = bUy();
        com.tencent.mm.aw.c cVar2 = this.oLB;
        AppMethodBeat.o(137517);
        return cVar2;
    }

    public final boolean bSO() {
        return true;
    }

    public final void release() {
        AppMethodBeat.i(137518);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "release");
        this.awA.removeMessages(100);
        bSM();
        if (this.oLD != null) {
            this.oLD.b(this.oLJ);
            this.oLD.aOJ.remove(this);
            this.oLD.release();
            this.oLD = null;
        }
        if (this.oLH != null) {
            this.oLH.rY();
            this.oLH = null;
        }
        this.oLE = null;
        this.oLG = null;
        AppMethodBeat.o(137518);
    }

    public final void a(com.tencent.mm.aw.e eVar, int i, int i2) {
        int i3 = 0;
        AppMethodBeat.i(137519);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        this.oNs = "error";
        com.tencent.mm.sdk.b.b keVar = new ke();
        keVar.cFH.action = 4;
        keVar.cFH.cFB = eVar;
        keVar.cFH.state = "error";
        keVar.cFH.duration = (long) getDuration();
        keVar.cFH.cFJ = true;
        com.tencent.mm.g.a.ke.a aVar = keVar.cFH;
        ab.i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", Integer.valueOf(i));
        switch (i) {
            case -4999:
                i3 = -1;
                break;
            case -4005:
            case -4004:
            case -4003:
            case -4002:
                i3 = 10001;
                break;
            case -4001:
                i3 = 10004;
                break;
            case -4000:
                i3 = 10002;
                break;
        }
        aVar.errCode = i3;
        com.tencent.mm.g.a.ke.a aVar2 = keVar.cFH;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errCode:" + i2 + ", err:");
        switch (i2) {
            case -4004:
                stringBuilder.append("load error");
                break;
            case -4003:
                stringBuilder.append("MediaCodec decoder init exception");
                break;
            case -4002:
                stringBuilder.append("illegal state exception");
                break;
            case -4001:
                stringBuilder.append("UnrecognizedInputFormatException");
                break;
            case -43:
                stringBuilder.append("error url format");
                break;
            case -42:
                stringBuilder.append("stop error");
                break;
            case -41:
                stringBuilder.append("prepare error");
                break;
            case -30:
                stringBuilder.append(" network error");
                break;
            case -13:
                stringBuilder.append(" network respCode 502");
                break;
            case -12:
                stringBuilder.append(" network respCode 500");
                break;
            case -11:
                stringBuilder.append(" network respCode 404");
                break;
            case -10:
                stringBuilder.append(" network respCode 403");
                break;
            case -3:
                stringBuilder.append("connect fail");
                break;
            case -2:
                stringBuilder.append(" no network");
                break;
            case -1:
                stringBuilder.append("unknow exception");
                break;
        }
        aVar2.aIm = stringBuilder.toString();
        com.tencent.mm.sdk.b.a.xxA.a(keVar, Looper.getMainLooper());
        AppMethodBeat.o(137519);
    }

    /* Access modifiers changed, original: final */
    public final void eF(int i, int i2) {
        AppMethodBeat.i(137520);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.oLM != null) {
            this.oLM.eH(i, i2);
        }
        AppMethodBeat.o(137520);
    }

    /* Access modifiers changed, original: final */
    public final void eG(int i, int i2) {
        AppMethodBeat.i(137521);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + i + "," + i2 + "]");
        if (this.oLM != null && (i == 701 || i == 702)) {
            this.oLM.zE(i2);
        }
        AppMethodBeat.o(137521);
    }

    public final void b(Metadata metadata) {
        AppMethodBeat.i(137522);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
        com.tencent.mm.plugin.music.f.b.a.a(metadata, "  ");
        ab.i("MicroMsg.Music.ExoMusicPlayer", "]");
        AppMethodBeat.o(137522);
    }

    /* Access modifiers changed, original: final */
    public final String bTJ() {
        AppMethodBeat.i(137523);
        String jo = com.tencent.mm.plugin.music.f.b.a.jo(SystemClock.elapsedRealtime() - this.bqO);
        AppMethodBeat.o(137523);
        return jo;
    }

    private void b(com.tencent.mm.aw.e eVar, int i, int i2) {
        AppMethodBeat.i(137524);
        if (this.oNt != null) {
            this.oNt.d(eVar, i, i2);
        }
        AppMethodBeat.o(137524);
    }

    static /* synthetic */ void a(a aVar) {
        String str;
        URL url;
        AppMethodBeat.i(137525);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "initPlayer");
        boolean isWifi = at.isWifi(ah.getContext());
        PBool pBool = new PBool();
        if (bo.isNullOrNil(aVar.oLA.fKa)) {
            str = aVar.oLA.fKc;
        } else {
            str = aVar.oLA.fKa;
        }
        aVar.cle = com.tencent.mm.plugin.music.h.e.a(str, aVar.oLA.fKb, isWifi, pBool);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "mSrc:%s", aVar.cle);
        ab.i("MicroMsg.Music.ExoMusicPlayer", "field_songWifiUrl:%s", aVar.oLA.fKa);
        try {
            url = new URL(aVar.cle);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e, "initPlayer", new Object[0]);
            ab.e("MicroMsg.Music.ExoMusicPlayer", "new URL exception:" + e.getMessage());
            url = null;
        }
        if (url == null) {
            ab.e("MicroMsg.Music.ExoMusicPlayer", "initPlayer url is null");
            aVar.d(aVar.oLA, 500);
            aVar.b(aVar.oLA, -4005, -43);
            AppMethodBeat.o(137525);
            return;
        }
        if (aVar.oLD != null && (aVar.oLC != 3 || aVar.oLD.pP())) {
            ab.i("MicroMsg.Music.ExoMusicPlayer", "stop it first!");
            aVar.oLC = 3;
            aVar.oLD.aE(false);
            aVar.oLD.stop();
        }
        aVar.oLI.oLP = new int[]{1, 1, 1, 1};
        aVar.userAgent = com.google.android.exoplayer2.i.v.i(ah.getContext(), Token.WX_TOKEN_PLATFORMID_VALUE);
        Uri parse = Uri.parse(aVar.cle);
        if (aVar.oLD == null) {
            aVar.oLF = new k(aVar.awA, aVar);
            aVar.oLE = new com.google.android.exoplayer2.g.c();
            aVar.oLD = g.a(ah.getContext(), aVar.oLE, new com.google.android.exoplayer2.c());
        }
        if (aVar.oLG == null) {
            aVar.oLG = new m(ah.getContext(), aVar.oLF, new o(aVar.userAgent, aVar.oLF));
        }
        try {
            aVar.bjP = false;
            aVar.oLH = new h(parse, aVar.oLG, aVar.awA, aVar.oLL);
            aVar.oLD.a(aVar.oLJ);
            aVar.oLD.aOJ.add(aVar);
            aVar.oLD.aOT = aVar.oLK;
            aVar.oLC = 0;
            if (aVar.startTime == 0) {
                ab.i("MicroMsg.Music.ExoMusicPlayer", "startTime is 0, play it when ready!");
                aVar.oLD.aE(true);
            } else {
                aVar.oLD.aE(false);
            }
            aVar.oLD.a(aVar.oLH);
            aVar.oKe = true;
            aVar.awA.sendEmptyMessageDelayed(100, 5000);
            AppMethodBeat.o(137525);
        } catch (Exception e2) {
            ab.e("MicroMsg.Music.ExoMusicPlayer", "initPlayer exception:" + e2.getMessage());
            ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e2, "initPlayer", new Object[0]);
            aVar.d(aVar.oLA, 501);
            aVar.b(aVar.oLA, -4005, -41);
            AppMethodBeat.o(137525);
        }
    }
}
