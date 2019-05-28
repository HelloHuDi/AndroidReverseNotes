package com.tencent.p177mm.plugin.music.p461d;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.C0884v;
import com.google.android.exoplayer2.C25532c;
import com.google.android.exoplayer2.C25533e;
import com.google.android.exoplayer2.C37253f.C37254a;
import com.google.android.exoplayer2.C45036g;
import com.google.android.exoplayer2.C45045p;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.C37267e.C8694a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p099a.C0826e;
import com.google.android.exoplayer2.p100b.C32021d;
import com.google.android.exoplayer2.p109g.C45034c;
import com.google.android.exoplayer2.p110h.C0867f.C0868a;
import com.google.android.exoplayer2.p110h.C17665i;
import com.google.android.exoplayer2.p110h.C17668r.C17670e;
import com.google.android.exoplayer2.p110h.C17668r.C8682c;
import com.google.android.exoplayer2.p110h.C25541o;
import com.google.android.exoplayer2.p110h.C32056d.C8679a;
import com.google.android.exoplayer2.p110h.C37261k;
import com.google.android.exoplayer2.p110h.C41612m;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p797e.C44649b.C32042a;
import com.google.android.exoplayer2.source.C37271a;
import com.google.android.exoplayer2.source.C41632q;
import com.google.android.exoplayer2.source.C45052i;
import com.google.android.exoplayer2.source.C46871g.C0881a;
import com.google.android.exoplayer2.source.p112b.C41624h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.p177mm.p198aw.C37496c;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p230g.p231a.C37752ke.C9394a;
import com.tencent.p177mm.plugin.music.p462e.C39434d;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.plugin.music.p463f.C36792a;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p465b.C28566a;
import com.tencent.p177mm.plugin.music.p997h.C46101e;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.music.d.a */
public final class C28555a extends C36792a implements C8679a, C8694a {
    Handler awA = new Handler(Looper.myLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(137475);
            if (100 == message.what) {
                long duration = C28555a.this.oLD.getDuration();
                long currentPosition = C28555a.this.oLD.getCurrentPosition();
                long bufferedPosition = C28555a.this.oLD.getBufferedPosition();
                long bufferedPercentage = (long) C28555a.this.oLD.getBufferedPercentage();
                C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "duration:%d, position:%d, bufferSize:%d, percent:%d", Long.valueOf(duration), Long.valueOf(currentPosition), Long.valueOf(bufferedPosition), Long.valueOf(bufferedPercentage));
                C28555a.this.awA.removeMessages(100);
                if (C28555a.this.oKe) {
                    C28555a.this.awA.sendEmptyMessageDelayed(100, 5000);
                }
            }
            AppMethodBeat.m2505o(137475);
        }
    };
    boolean bjP = false;
    private long bqO;
    int bqQ = 0;
    private String cle = "";
    boolean oKe;
    private long oKj = 0;
    C9058e oLA;
    private C37496c oLB;
    int oLC = 0;
    C0884v oLD;
    private C45034c oLE;
    private C37261k oLF;
    private C0868a oLG;
    private C45052i oLH;
    C28558f oLI = new C28558f();
    C28557a oLJ = new C28557a(this, (byte) 0);
    C12662e oLK = new C12662e(this, (byte) 0);
    C28554d oLL = new C28554d(this, (byte) 0);
    C3525b oLM = new C6986c();
    public boolean oLN = false;
    int startTime = 0;
    protected String userAgent;

    /* renamed from: com.tencent.mm.plugin.music.d.a$b */
    public interface C3525b {
        void bTK();

        void bTL();

        void bTM();

        void bTN();

        void bTO();

        void bTP();

        /* renamed from: eH */
        void mo8018eH(int i, int i2);

        /* renamed from: zE */
        void mo8019zE(int i);
    }

    /* renamed from: com.tencent.mm.plugin.music.d.a$c */
    public class C6986c implements C3525b {
        public final void bTK() {
            AppMethodBeat.m2504i(137482);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
            if (C28555a.this.oLA != null) {
                C28555a.this.mo58653z(C28555a.this.oLA);
            }
            if (C28555a.this.startTime > 0) {
                C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, seekTo startTime:%d,", Integer.valueOf(C28555a.this.startTime));
                C28555a.this.mo8037lP(C28555a.this.startTime);
            }
            if (C28555a.this.startTime == 0 && !C28555a.this.oLD.mo2627pP()) {
                C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onPrepared, set play when ready");
                C28555a.this.oLD.mo2618aE(true);
            }
            AppMethodBeat.m2505o(137482);
        }

        public final void bTL() {
            AppMethodBeat.m2504i(137483);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onStart");
            if (C28555a.this.oLA != null) {
                C28555a.this.mo58640A(C28555a.this.oLA);
            }
            AppMethodBeat.m2505o(137483);
        }

        public final void bTM() {
            AppMethodBeat.m2504i(137484);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onPause");
            if (!(C28555a.this.oLA == null || C28555a.this.oLD.mo2627pP())) {
                C28555a.this.mo58642C(C28555a.this.oLA);
            }
            AppMethodBeat.m2505o(137484);
        }

        public final void bTN() {
            AppMethodBeat.m2504i(137485);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onStop");
            if (C28555a.this.oLA != null) {
                C28555a.this.mo58643D(C28555a.this.oLA);
            }
            AppMethodBeat.m2505o(137485);
        }

        public final void bTO() {
            AppMethodBeat.m2504i(137486);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
            if (C28555a.this.oLA != null) {
                C28555a.this.mo58644E(C28555a.this.oLA);
            }
            if (!(C28555a.this.startTime <= 0 || C28555a.this.oLD == null || C28555a.this.oLD.mo2627pP())) {
                C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete, stay play hls");
                C28555a.this.startTime = 0;
                C28555a.this.oLD.mo2618aE(true);
            }
            AppMethodBeat.m2505o(137486);
        }

        public final void bTP() {
            AppMethodBeat.m2504i(137487);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
            if (C28555a.this.oLA != null) {
                C28555a.this.mo58646G(C28555a.this.oLA);
            }
            C28555a.this.oKe = false;
            C28555a.this.awA.removeMessages(100);
            AppMethodBeat.m2505o(137487);
        }

        /* renamed from: zE */
        public final void mo8019zE(int i) {
            AppMethodBeat.m2504i(137488);
            C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "onBufferingUpdate, percent:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(137488);
        }

        /* renamed from: eH */
        public final void mo8018eH(int i, int i2) {
            AppMethodBeat.m2504i(137489);
            C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "onError what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (C28555a.this.oLA != null) {
                C28555a.this.mo46630a(C28555a.this.oLA, i, i2);
            }
            if (C28555a.this.oLD != null) {
                C28555a.this.oLD.mo2618aE(false);
                C28555a.this.oLD.stop();
            }
            C28555a.this.oKe = false;
            C28555a.this.awA.removeMessages(100);
            C28555a c28555a = C28555a.this;
            c28555a.bqQ++;
            if (C28555a.this.bqQ == 1) {
                C28555a.m45323a(C28555a.this, C28555a.this.oLA, i, i2);
            }
            AppMethodBeat.m2505o(137489);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.d.a$e */
    class C12662e implements C0826e {
        private C12662e() {
        }

        /* synthetic */ C12662e(C28555a c28555a, byte b) {
            this();
        }

        /* renamed from: c */
        public final void mo2523c(C32021d c32021d) {
            AppMethodBeat.m2504i(137494);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + C28555a.this.bTJ() + "]");
            AppMethodBeat.m2505o(137494);
        }

        /* renamed from: dx */
        public final void mo2527dx(int i) {
            AppMethodBeat.m2504i(137495);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + i + "]");
            AppMethodBeat.m2505o(137495);
        }

        /* renamed from: b */
        public final void mo2522b(String str, long j, long j2) {
            AppMethodBeat.m2504i(137496);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + C28555a.this.bTJ() + ", " + str + "]");
            AppMethodBeat.m2505o(137496);
        }

        /* renamed from: d */
        public final void mo2525d(Format format) {
            AppMethodBeat.m2504i(137497);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + C28555a.this.bTJ() + ", " + Format.m15283a(format) + "]");
            AppMethodBeat.m2505o(137497);
        }

        /* renamed from: d */
        public final void mo2526d(C32021d c32021d) {
            AppMethodBeat.m2504i(137498);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + C28555a.this.bTJ() + "]");
            AppMethodBeat.m2505o(137498);
        }

        /* renamed from: d */
        public final void mo2524d(int i, long j, long j2) {
            AppMethodBeat.m2504i(137499);
            C28555a.m45324a(C28555a.this, "audioTrackUnderrun [" + i + ", " + j + ", " + j2 + "]", null);
            AppMethodBeat.m2505o(137499);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.d.a$d */
    class C28554d implements C37271a, C0881a {
        private C28554d() {
        }

        /* synthetic */ C28554d(C28555a c28555a, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo46627a(C17665i c17665i, Format format, IOException iOException) {
            AppMethodBeat.m2504i(137490);
            C28555a.m45324a(C28555a.this, "loadError", (Exception) iOException);
            if (!(c17665i == null || format == null)) {
                C4990ab.m7413e("MicroMsg.Music.ExoMusicPlayer", "uri:%s, Format:%s", c17665i.uri, format.toString());
            }
            C28555a.m45326b(C28555a.this);
            AppMethodBeat.m2505o(137490);
        }

        /* renamed from: rO */
        public final void mo46628rO() {
            AppMethodBeat.m2504i(137491);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onLoadCompleted");
            AppMethodBeat.m2505o(137491);
        }

        public final void onLoadError(IOException iOException) {
            AppMethodBeat.m2504i(137492);
            C28555a.m45324a(C28555a.this, "loadError", (Exception) iOException);
            C4990ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", iOException, "onLoadError", new Object[0]);
            C28555a.m45326b(C28555a.this);
            AppMethodBeat.m2505o(137492);
        }

        /* renamed from: rP */
        public final void mo46629rP() {
            AppMethodBeat.m2504i(137493);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onHasEndTag");
            C28555a.this.bjP = true;
            AppMethodBeat.m2505o(137493);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.d.a$2 */
    class C285562 implements Runnable {
        C285562() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137476);
            C28555a.m45322a(C28555a.this);
            AppMethodBeat.m2505o(137476);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.d.a$a */
    class C28557a implements C37254a {
        private C28557a() {
        }

        /* synthetic */ C28557a(C28555a c28555a, byte b) {
            this();
        }

        /* renamed from: aH */
        public final void mo26016aH(boolean z) {
            AppMethodBeat.m2504i(137477);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "loading [" + z + "]");
            AppMethodBeat.m2505o(137477);
        }

        /* renamed from: c */
        public final void mo26017c(boolean z, int i) {
            AppMethodBeat.m2504i(137478);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "state [" + C28555a.this.bTJ() + ", " + z + ", " + C28566a.m45373zT(i) + "]");
            C28555a c28555a = C28555a.this;
            if (c28555a.oLD != null) {
                boolean pP = c28555a.oLD.mo2627pP();
                int pO = c28555a.oLD.mo2626pO();
                if (pP && pO == 3) {
                    C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onStart");
                    if (c28555a.oLM != null) {
                        c28555a.oLM.bTL();
                    }
                } else if (!pP && pO == 3 && c28555a.oLC == 2) {
                    C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onPause");
                    if (c28555a.oLM != null) {
                        c28555a.oLM.bTM();
                    }
                } else if (!pP && pO == 3 && c28555a.oLC == 3) {
                    C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onStop");
                    if (c28555a.oLM != null) {
                        c28555a.oLM.bTN();
                    }
                }
                int z2 = C28558f.m45338z(pP, pO);
                if (z2 != c28555a.oLI.oLP[3]) {
                    C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "setMostRecentState [" + pP + "," + pO + "]");
                    c28555a.oLI.mo46638y(pP, pO);
                    if (z2 == C28558f.m45338z(true, 4)) {
                        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onComplete");
                        if (c28555a.oLM != null) {
                            c28555a.oLM.bTP();
                        }
                        AppMethodBeat.m2505o(137478);
                        return;
                    }
                    if (c28555a.oLI.mo46637b(new int[]{C28558f.m45338z(false, 1), C28558f.m45338z(false, 2), C28558f.m45338z(false, 3)}, false)) {
                        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onPrepared");
                        if (c28555a.oLM != null) {
                            c28555a.oLM.bTK();
                        }
                        AppMethodBeat.m2505o(137478);
                        return;
                    } else if (((c28555a.oLI.mo46637b(new int[]{100, 2, 3}, true) | c28555a.oLI.mo46637b(new int[]{2, 100, 3}, true)) | c28555a.oLI.mo46637b(new int[]{100, 3, 2, 3}, true)) != 0) {
                        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onSeekComplete");
                        if (c28555a.oLM != null) {
                            c28555a.oLM.bTO();
                        }
                        AppMethodBeat.m2505o(137478);
                        return;
                    } else {
                        if (c28555a.oLI.mo46637b(new int[]{C28558f.m45338z(true, 3), C28558f.m45338z(true, 2)}, false)) {
                            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_START");
                            c28555a.mo46633eG(701, c28555a.getDownloadPercent());
                            AppMethodBeat.m2505o(137478);
                            return;
                        }
                        if (c28555a.oLI.mo46637b(new int[]{C28558f.m45338z(true, 2), C28558f.m45338z(true, 3)}, false)) {
                            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "MEDIA_INFO_BUFFERING_END");
                            c28555a.mo46633eG(702, c28555a.getDownloadPercent());
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(137478);
        }

        /* renamed from: a */
        public final void mo26014a(C25533e c25533e) {
            AppMethodBeat.m2504i(137479);
            C4990ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", c25533e, "playerFailed [" + C28555a.this.bTJ() + "]", new Object[0]);
            C28555a c28555a = C28555a.this;
            if (c25533e != null) {
                Throwable cause = c25533e.getCause();
                if (cause == null) {
                    c28555a.mo46632eF(-4999, -1);
                } else if (cause instanceof C8682c) {
                    if (cause.toString().contains("Unable to connect")) {
                        boolean isNetworkConnected = C5023at.isNetworkConnected(C4996ah.getContext());
                        C4990ab.m7412e("MicroMsg.Music.ExoMusicPlayer", "ExoPlaybackException hasNetwork=" + isNetworkConnected + " caused by:\n" + cause.toString());
                        if (isNetworkConnected) {
                            c28555a.mo46632eF(-4000, -3);
                            AppMethodBeat.m2505o(137479);
                            return;
                        }
                        c28555a.mo46632eF(-4000, -2);
                        AppMethodBeat.m2505o(137479);
                        return;
                    } else if (cause instanceof C17670e) {
                        String th = cause.toString();
                        if (th.contains("403")) {
                            c28555a.mo46632eF(-4000, -10);
                        } else if (th.contains("404")) {
                            c28555a.mo46632eF(-4000, -11);
                        } else if (th.contains("500")) {
                            c28555a.mo46632eF(-4000, -12);
                        } else if (th.contains("502")) {
                            c28555a.mo46632eF(-4000, -13);
                        } else {
                            c28555a.mo46632eF(-4000, -30);
                        }
                    }
                } else if (cause instanceof C41632q) {
                    c28555a.mo46632eF(-4001, -1);
                } else if (cause instanceof IllegalStateException) {
                    c28555a.mo46632eF(-4002, -1);
                } else if (cause instanceof C32042a) {
                    c28555a.mo46632eF(-4003, -1);
                } else {
                    c28555a.mo46632eF(-4999, -1);
                }
            }
            C4990ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", c25533e, "ExoPlaybackException", new Object[0]);
            AppMethodBeat.m2505o(137479);
        }

        /* renamed from: qe */
        public final void mo26018qe() {
            AppMethodBeat.m2504i(137480);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "positionDiscontinuity");
            AppMethodBeat.m2505o(137480);
        }

        /* renamed from: a */
        public final void mo26015a(C45045p c45045p) {
            AppMethodBeat.m2504i(137481);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", new Object[]{Float.valueOf(c45045p.speed), Float.valueOf(c45045p.pitch)}));
            AppMethodBeat.m2505o(137481);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.d.a$f */
    static class C28558f {
        int[] oLP;

        private C28558f() {
            AppMethodBeat.m2504i(137500);
            this.oLP = new int[]{1, 1, 1, 1};
            AppMethodBeat.m2505o(137500);
        }

        /* synthetic */ C28558f(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: y */
        public final void mo46638y(boolean z, int i) {
            AppMethodBeat.m2504i(137501);
            int z2 = C28558f.m45338z(z, i);
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + z + "," + i + "], lastState=" + this.oLP[3] + ",newState=" + z2);
            if (this.oLP[3] == z2) {
                AppMethodBeat.m2505o(137501);
                return;
            }
            this.oLP[0] = this.oLP[1];
            this.oLP[1] = this.oLP[2];
            this.oLP[2] = this.oLP[3];
            this.oLP[3] = z2;
            C4990ab.m7418v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.oLP[0] + "," + this.oLP[1] + "," + this.oLP[2] + "," + this.oLP[3] + "]");
            AppMethodBeat.m2505o(137501);
        }

        /* renamed from: z */
        static int m45338z(boolean z, int i) {
            return (z ? -268435456 : 0) | i;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final boolean mo46637b(int[] iArr, boolean z) {
            int i = z ? 268435455 : -1;
            int length = this.oLP.length - iArr.length;
            int i2 = 1;
            for (int i3 = length; i3 < this.oLP.length; i3++) {
                i2 &= (this.oLP[i3] & i) == (iArr[i3 - length] & i) ? 1 : 0;
            }
            return i2;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m45323a(C28555a c28555a, C9058e c9058e, int i, int i2) {
        AppMethodBeat.m2504i(137526);
        c28555a.m45325b(c9058e, i, i2);
        AppMethodBeat.m2505o(137526);
    }

    public C28555a() {
        AppMethodBeat.m2504i(137502);
        C28566a.bUI();
        AppMethodBeat.m2505o(137502);
    }

    /* renamed from: f */
    public final void mo8035f(C9058e c9058e) {
        AppMethodBeat.m2504i(137503);
        super.mo8035f(c9058e);
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oKj;
        if (this.oLA != null && this.oLA.mo20537e(c9058e) && j <= 1000) {
            this.oLA = c9058e;
            C4990ab.m7413e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.cle, Long.valueOf(j));
            AppMethodBeat.m2505o(137503);
        } else if (c9058e == null) {
            C4990ab.m7412e("MicroMsg.Music.ExoMusicPlayer", "music is null");
            AppMethodBeat.m2505o(137503);
        } else {
            if (this.oNt != null) {
                this.oNt.mo24651s(c9058e);
            }
            this.oKj = currentTimeMillis;
            C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(c9058e.startTime));
            if (this.oLD != null && aie()) {
                this.oLD.stop();
            }
            this.bqQ = 0;
            this.startTime = c9058e.startTime;
            this.bqO = SystemClock.elapsedRealtime();
            this.oLA = c9058e;
            mo58652y(this.oLA);
            C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", Integer.valueOf(this.startTime));
            C5004al.m7441d(new C285562());
            AppMethodBeat.m2505o(137503);
        }
    }

    public final void bTI() {
        AppMethodBeat.m2504i(137504);
        this.oNt = (C39434d) C43329b.m77295ar(C39434d.class);
        this.oNu = C39435k.bUf().oLX;
        AppMethodBeat.m2505o(137504);
    }

    public final void pause() {
        AppMethodBeat.m2504i(137505);
        this.oLN = false;
        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "pause");
        if (this.oLD != null) {
            this.oLC = 2;
            this.oLD.mo2618aE(false);
        }
        AppMethodBeat.m2505o(137505);
    }

    public final boolean aif() {
        return this.oKe && this.oLN;
    }

    public final void bSN() {
        AppMethodBeat.m2504i(137506);
        this.oLN = true;
        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
        if (this.oLD != null) {
            this.oLC = 2;
            this.oLD.mo2618aE(false);
        }
        AppMethodBeat.m2505o(137506);
    }

    public final void bTb() {
        AppMethodBeat.m2504i(137507);
        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
        pause();
        C39435k.bUh().bSK();
        AppMethodBeat.m2505o(137507);
    }

    public final void resume() {
        AppMethodBeat.m2504i(137508);
        this.bqQ = 0;
        boolean bTc = bTc();
        boolean aie = aie();
        C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", Boolean.valueOf(bTc), Boolean.valueOf(aie));
        if (this.oLD != null) {
            if (C39435k.bUh().requestFocus()) {
                this.oLC = 1;
                this.oLD.mo2618aE(true);
                mo58641B(this.oLA);
            } else {
                C4990ab.m7412e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
            }
            this.oKe = true;
        }
        AppMethodBeat.m2505o(137508);
    }

    public final boolean aie() {
        AppMethodBeat.m2504i(137509);
        if (this.oLD == null) {
            AppMethodBeat.m2505o(137509);
            return false;
        }
        switch (this.oLD.mo2626pO()) {
            case 1:
            case 3:
                boolean pP = this.oLD.mo2627pP();
                AppMethodBeat.m2505o(137509);
                return pP;
            default:
                AppMethodBeat.m2505o(137509);
                return false;
        }
    }

    private boolean bTc() {
        AppMethodBeat.m2504i(137510);
        if (this.oLD != null) {
            boolean isLoading = this.oLD.isLoading();
            AppMethodBeat.m2505o(137510);
            return isLoading;
        }
        AppMethodBeat.m2505o(137510);
        return false;
    }

    public final boolean aig() {
        AppMethodBeat.m2504i(137511);
        if (!this.oKe || bTc()) {
            AppMethodBeat.m2505o(137511);
            return false;
        }
        AppMethodBeat.m2505o(137511);
        return true;
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(137512);
        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
        try {
            if (this.oLD != null) {
                this.oLC = 3;
                this.oLD.mo2618aE(false);
                this.oLD.stop();
                mo58643D(this.oLA);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e, "stopPlay", new Object[0]);
            mo58651d(this.oLA, 504);
            m45325b(this.oLA, -4005, -42);
        }
        C39435k.bUh().bSK();
        this.oKe = false;
        this.oLN = false;
        this.awA.removeMessages(100);
        AppMethodBeat.m2505o(137512);
    }

    public final int bTi() {
        AppMethodBeat.m2504i(137513);
        if (this.oLD != null) {
            int currentPosition = (int) this.oLD.getCurrentPosition();
            AppMethodBeat.m2505o(137513);
            return currentPosition;
        }
        AppMethodBeat.m2505o(137513);
        return 0;
    }

    public final int getDuration() {
        AppMethodBeat.m2504i(137514);
        if (this.oLD != null) {
            int duration = (int) this.oLD.getDuration();
            AppMethodBeat.m2505o(137514);
            return duration;
        }
        AppMethodBeat.m2505o(137514);
        return 0;
    }

    public final int getDownloadPercent() {
        AppMethodBeat.m2504i(137515);
        if (this.oLD != null) {
            int bufferedPercentage = this.oLD.getBufferedPercentage();
            AppMethodBeat.m2505o(137515);
            return bufferedPercentage;
        }
        AppMethodBeat.m2505o(137515);
        return 0;
    }

    /* renamed from: lP */
    public final boolean mo8037lP(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(137516);
        int duration = getDuration();
        C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0 || i > duration) {
            C4990ab.m7413e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            AppMethodBeat.m2505o(137516);
            return false;
        }
        if (this.oLD != null) {
            mo58645F(this.oLA);
            C28558f c28558f = this.oLI;
            if ((this.oLI.oLP[3] & -268435456) != 0) {
                z = true;
            }
            c28558f.mo46638y(z, 100);
            this.oLC = 4;
            this.oLD.seekTo((long) i);
        }
        AppMethodBeat.m2505o(137516);
        return true;
    }

    public final C37496c bSP() {
        int i = 0;
        AppMethodBeat.m2504i(137517);
        int duration = getDuration();
        int bTi = bTi();
        boolean aie = aie();
        int downloadPercent = getDownloadPercent();
        if (downloadPercent < 0) {
            downloadPercent = 0;
        }
        if ((this.oLH instanceof C41624h) && !this.bjP) {
            duration = 0;
        }
        if (this.oLB != null) {
            C37496c c37496c = this.oLB;
            if (aie) {
                i = 1;
            }
            c37496c.mo60427t(duration, bTi, i, downloadPercent);
        } else {
            if (aie) {
                i = 1;
            }
            this.oLB = new C37496c(duration, bTi, i, downloadPercent);
        }
        this.oLB.cFJ = true;
        this.oLB.fJR = bUy();
        C37496c c37496c2 = this.oLB;
        AppMethodBeat.m2505o(137517);
        return c37496c2;
    }

    public final boolean bSO() {
        return true;
    }

    public final void release() {
        AppMethodBeat.m2504i(137518);
        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "release");
        this.awA.removeMessages(100);
        bSM();
        if (this.oLD != null) {
            this.oLD.mo2619b(this.oLJ);
            this.oLD.aOJ.remove(this);
            this.oLD.release();
            this.oLD = null;
        }
        if (this.oLH != null) {
            this.oLH.mo42825rY();
            this.oLH = null;
        }
        this.oLE = null;
        this.oLG = null;
        AppMethodBeat.m2505o(137518);
    }

    /* renamed from: a */
    public final void mo46630a(C9058e c9058e, int i, int i2) {
        int i3 = 0;
        AppMethodBeat.m2504i(137519);
        C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "onErrorEvent with extra:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        this.oNs = "error";
        C4883b c37752ke = new C37752ke();
        c37752ke.cFH.action = 4;
        c37752ke.cFH.cFB = c9058e;
        c37752ke.cFH.state = "error";
        c37752ke.cFH.duration = (long) getDuration();
        c37752ke.cFH.cFJ = true;
        C9394a c9394a = c37752ke.cFH;
        C4990ab.m7417i("MicroMsg.Music.ExoPlayerErrorHandler", "getErrCodeType, errType: %d", Integer.valueOf(i));
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
        c9394a.errCode = i3;
        C9394a c9394a2 = c37752ke.cFH;
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
        c9394a2.aIm = stringBuilder.toString();
        C4879a.xxA.mo10048a(c37752ke, Looper.getMainLooper());
        AppMethodBeat.m2505o(137519);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: eF */
    public final void mo46632eF(int i, int i2) {
        AppMethodBeat.m2504i(137520);
        C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.oLM != null) {
            this.oLM.mo8018eH(i, i2);
        }
        AppMethodBeat.m2505o(137520);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: eG */
    public final void mo46633eG(int i, int i2) {
        AppMethodBeat.m2504i(137521);
        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + i + "," + i2 + "]");
        if (this.oLM != null && (i == 701 || i == 702)) {
            this.oLM.mo8019zE(i2);
        }
        AppMethodBeat.m2505o(137521);
    }

    /* renamed from: b */
    public final void mo2635b(Metadata metadata) {
        AppMethodBeat.m2504i(137522);
        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
        C28566a.m45371a(metadata, "  ");
        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "]");
        AppMethodBeat.m2505o(137522);
    }

    /* Access modifiers changed, original: final */
    public final String bTJ() {
        AppMethodBeat.m2504i(137523);
        String jo = C28566a.m45372jo(SystemClock.elapsedRealtime() - this.bqO);
        AppMethodBeat.m2505o(137523);
        return jo;
    }

    /* renamed from: b */
    private void m45325b(C9058e c9058e, int i, int i2) {
        AppMethodBeat.m2504i(137524);
        if (this.oNt != null) {
            this.oNt.mo24650d(c9058e, i, i2);
        }
        AppMethodBeat.m2505o(137524);
    }

    /* renamed from: a */
    static /* synthetic */ void m45322a(C28555a c28555a) {
        String str;
        URL url;
        AppMethodBeat.m2504i(137525);
        C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "initPlayer");
        boolean isWifi = C5023at.isWifi(C4996ah.getContext());
        PBool pBool = new PBool();
        if (C5046bo.isNullOrNil(c28555a.oLA.fKa)) {
            str = c28555a.oLA.fKc;
        } else {
            str = c28555a.oLA.fKa;
        }
        c28555a.cle = C46101e.m86005a(str, c28555a.oLA.fKb, isWifi, pBool);
        C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "mSrc:%s", c28555a.cle);
        C4990ab.m7417i("MicroMsg.Music.ExoMusicPlayer", "field_songWifiUrl:%s", c28555a.oLA.fKa);
        try {
            url = new URL(c28555a.cle);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e, "initPlayer", new Object[0]);
            C4990ab.m7412e("MicroMsg.Music.ExoMusicPlayer", "new URL exception:" + e.getMessage());
            url = null;
        }
        if (url == null) {
            C4990ab.m7412e("MicroMsg.Music.ExoMusicPlayer", "initPlayer url is null");
            c28555a.mo58651d(c28555a.oLA, 500);
            c28555a.m45325b(c28555a.oLA, -4005, -43);
            AppMethodBeat.m2505o(137525);
            return;
        }
        if (c28555a.oLD != null && (c28555a.oLC != 3 || c28555a.oLD.mo2627pP())) {
            C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "stop it first!");
            c28555a.oLC = 3;
            c28555a.oLD.mo2618aE(false);
            c28555a.oLD.stop();
        }
        c28555a.oLI.oLP = new int[]{1, 1, 1, 1};
        c28555a.userAgent = C17675v.m27573i(C4996ah.getContext(), Token.WX_TOKEN_PLATFORMID_VALUE);
        Uri parse = Uri.parse(c28555a.cle);
        if (c28555a.oLD == null) {
            c28555a.oLF = new C37261k(c28555a.awA, c28555a);
            c28555a.oLE = new C45034c();
            c28555a.oLD = C45036g.m82562a(C4996ah.getContext(), c28555a.oLE, new C25532c());
        }
        if (c28555a.oLG == null) {
            c28555a.oLG = new C41612m(C4996ah.getContext(), c28555a.oLF, new C25541o(c28555a.userAgent, c28555a.oLF));
        }
        try {
            c28555a.bjP = false;
            c28555a.oLH = new C41624h(parse, c28555a.oLG, c28555a.awA, c28555a.oLL);
            c28555a.oLD.mo2615a(c28555a.oLJ);
            c28555a.oLD.aOJ.add(c28555a);
            c28555a.oLD.aOT = c28555a.oLK;
            c28555a.oLC = 0;
            if (c28555a.startTime == 0) {
                C4990ab.m7416i("MicroMsg.Music.ExoMusicPlayer", "startTime is 0, play it when ready!");
                c28555a.oLD.mo2618aE(true);
            } else {
                c28555a.oLD.mo2618aE(false);
            }
            c28555a.oLD.mo2616a(c28555a.oLH);
            c28555a.oKe = true;
            c28555a.awA.sendEmptyMessageDelayed(100, 5000);
            AppMethodBeat.m2505o(137525);
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.Music.ExoMusicPlayer", "initPlayer exception:" + e2.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e2, "initPlayer", new Object[0]);
            c28555a.mo58651d(c28555a.oLA, 501);
            c28555a.m45325b(c28555a.oLA, -4005, -41);
            AppMethodBeat.m2505o(137525);
        }
    }
}
