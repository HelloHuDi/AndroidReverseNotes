package com.tencent.p177mm.audio.p194a;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.audio.p195b.C32304g.C32306b;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.compatible.util.C45293b.C32474a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvoice.C26498d;
import com.tencent.p177mm.modelvoice.C26498d.C18718a;
import com.tencent.p177mm.modelvoice.C26498d.C26499b;
import com.tencent.p177mm.modelvoice.C32848o;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C9732i;
import com.tencent.p177mm.modelvoice.C9738j;
import com.tencent.p177mm.modelvoice.C9746s;
import com.tencent.p177mm.p183ai.C17891h;
import com.tencent.p177mm.p183ai.C17891h.C17889a;
import com.tencent.p177mm.p183ai.C17891h.C17890c;
import com.tencent.p177mm.p183ai.C17891h.C17892b;
import com.tencent.p177mm.p183ai.C17891h.C17893d;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C35988ay.C23497b;
import com.tencent.p177mm.sdk.platformtools.C35988ay.C30291a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.audio.a.a */
public final class C32297a implements C17891h, C1406a {
    private static String cox = null;
    private boolean coA;
    private C32474a coB;
    public C17892b coC;
    public C17889a coD;
    private C26498d col;
    private boolean com;
    private boolean con;
    private Context context;
    private boolean coo;
    private C45293b cop;
    private int coq;
    private boolean cor;
    private boolean cos;
    private boolean cot;
    private C17890c cou;
    private C17893d cov;
    private String cow;
    private boolean coy;
    private boolean coz;

    /* renamed from: com.tencent.mm.audio.a.a$1 */
    class C12891 implements C32474a {
        C12891() {
        }

        /* renamed from: gF */
        public final void mo4587gF(int i) {
            AppMethodBeat.m2504i(116448);
            C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", Integer.valueOf(i));
            if (i == -2 || i == -3) {
                if (C32297a.this.isPlaying()) {
                    C4990ab.m7419v("MicroMsg.SceneVoicePlayer", "alvinluo current fileName: %s, lastFileName: %s", C32297a.this.cow, C32297a.cox);
                    if (C32297a.this.cow == null || C32297a.this.cow.equals(C32297a.cox)) {
                        if (!C5046bo.m7563gW(((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_target26_voice_focus_shield_sw, 0), 0)) {
                            C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "no shield");
                        } else if (i == -3 && C1443d.m3068iW(26)) {
                            C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK %s", Integer.valueOf(VERSION.SDK_INT));
                            AppMethodBeat.m2505o(116448);
                            return;
                        }
                        C32297a.this.mo53006bn(false);
                        AppMethodBeat.m2505o(116448);
                        return;
                    }
                }
            } else if (i == 1 || i == 2 || i == 3) {
                C32297a.this.mo33396Ew();
                AppMethodBeat.m2505o(116448);
                return;
            } else if (i == -1) {
                C32297a.this.stop(false);
            }
            AppMethodBeat.m2505o(116448);
        }
    }

    /* renamed from: com.tencent.mm.audio.a.a$3 */
    class C322963 implements C26499b {

        /* renamed from: com.tencent.mm.audio.a.a$3$1 */
        class C258301 implements Runnable {
            C258301() {
            }

            public final void run() {
                AppMethodBeat.m2504i(116450);
                C32297a.this.coC.onError();
                AppMethodBeat.m2505o(116450);
            }
        }

        C322963() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(116451);
            C1407g.m2946KK().mo4829b(C32297a.this);
            if (C32297a.this.cos) {
                C1407g.m2946KK().mo4818KN();
                C32297a.this.cos = false;
            }
            C1407g.m2946KK().setMode(0);
            C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(C32297a.this.coy), Boolean.valueOf(C32297a.this.coA));
            if (C32297a.this.coA) {
                C32297a.this.cop.mo73178Mm();
                C32297a.this.coA = false;
            }
            if (C32297a.this.coC != null) {
                C5004al.m7441d(new C258301());
            }
            AppMethodBeat.m2505o(116451);
        }
    }

    /* renamed from: com.tencent.mm.audio.a.a$4 */
    class C322994 implements C18718a {

        /* renamed from: com.tencent.mm.audio.a.a$4$1 */
        class C323001 implements Runnable {

            /* renamed from: com.tencent.mm.audio.a.a$4$1$1 */
            class C323011 implements Runnable {

                /* renamed from: com.tencent.mm.audio.a.a$4$1$1$1 */
                class C323021 implements C30291a {
                    C323021() {
                    }

                    /* renamed from: EA */
                    public final void mo7762EA() {
                        AppMethodBeat.m2504i(116452);
                        C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!C32297a.this.isPlaying()) {
                            C1407g.m2946KK().mo4829b(C32297a.this);
                            C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(C32297a.this.coo));
                            if (!C32297a.this.coo) {
                                C1407g.m2946KK().mo4818KN();
                            }
                            C32297a.this.coo = false;
                            C32297a.this.cos = false;
                            C1407g.m2946KK().setMode(0);
                            C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(C32297a.this.coy), Boolean.valueOf(C32297a.this.coA));
                            if (C32297a.this.coA) {
                                C32297a.this.cop.mo73178Mm();
                                C32297a.this.coA = false;
                            }
                            C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                        AppMethodBeat.m2505o(116452);
                    }
                }

                C323011() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(116453);
                    C1407g.m2946KK().mo4834f(C32297a.this.com, false, false);
                    if (C32297a.this.cot) {
                        C23497b c23497b;
                        Context l = C32297a.this.context;
                        boolean k = C32297a.this.com;
                        C323021 c323021 = new C323021();
                        if (k) {
                            c23497b = C23497b.ON;
                        } else {
                            c23497b = C23497b.OFF;
                        }
                        C35988ay.m59198a(l, C25738R.string.dcn, c23497b, c323021);
                    } else {
                        C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!C32297a.this.isPlaying()) {
                            C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(C32297a.this.coy), Boolean.valueOf(C32297a.this.coA));
                            if (C32297a.this.coA) {
                                C32297a.this.cop.mo73178Mm();
                                C32297a.this.coA = false;
                            }
                            C1407g.m2946KK().mo4829b(C32297a.this);
                            C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(C32297a.this.coo));
                            if (!C32297a.this.coo) {
                                C1407g.m2946KK().mo4818KN();
                            }
                            C32297a.this.coo = false;
                            C32297a.this.cos = false;
                            C1407g.m2946KK().setMode(0);
                            C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                    }
                    if (C32297a.this.coD != null) {
                        C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                        C32297a.this.coD.mo17611EA();
                        AppMethodBeat.m2505o(116453);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                    AppMethodBeat.m2505o(116453);
                }
            }

            C323001() {
            }

            public final void run() {
                AppMethodBeat.m2504i(116454);
                try {
                    if (C1427q.etd.epP == 1) {
                        Thread.sleep(300);
                    }
                    C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", C32297a.this.coD, Boolean.valueOf(C32297a.this.cot));
                    C5004al.m7441d(new C323011());
                    AppMethodBeat.m2505o(116454);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SceneVoicePlayer", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(116454);
                }
            }
        }

        C322994() {
        }

        /* renamed from: EA */
        public final void mo33981EA() {
            AppMethodBeat.m2504i(116455);
            C7305d.post(new C323001(), "SceneVoice_onCompletion");
            AppMethodBeat.m2505o(116455);
        }
    }

    public C32297a(Context context) {
        this(context, 0);
    }

    public C32297a(Context context, int i) {
        AppMethodBeat.m2504i(116456);
        this.col = null;
        this.context = null;
        this.com = false;
        this.con = false;
        this.coo = false;
        this.coq = 0;
        this.cor = false;
        this.cos = false;
        this.cot = true;
        this.cow = null;
        this.coy = true;
        this.coz = true;
        this.coA = false;
        this.coB = new C12891();
        this.coC = null;
        this.context = context;
        this.cop = new C45293b(context);
        this.coq = i;
        C32306b c32306b = new C32306b();
        AppMethodBeat.m2505o(116456);
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(116457);
        if (this.col == null) {
            AppMethodBeat.m2505o(116457);
            return false;
        }
        boolean isPlaying = this.col.isPlaying();
        AppMethodBeat.m2505o(116457);
        return isPlaying;
    }

    /* renamed from: a */
    public final boolean mo33404a(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(116458);
        C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(this.coq));
        Assert.assertTrue(str.length() > 0);
        cox = this.cow;
        this.cow = str;
        String str2;
        if (C5730e.m8628ct(z2 ? str : C32850q.getFullPath(str))) {
            if (i == -1) {
                i = C32848o.m53696g(str, this.coq, z2);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.col = new C9746s(this.context);
                } else {
                    this.col = new C9746s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.col = new C9738j(this.context);
                } else {
                    this.col = new C9738j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.col = new C9732i(this.context);
                } else {
                    this.col = new C9732i();
                }
            }
            if (this.col != null) {
                this.col.mo21080b(this.coB);
                this.cop.mo73179a(this.coB);
                this.col.alP();
            }
            this.com = z;
            this.cor = z;
            if (C1407g.m2946KK().mo4822KV() || C1407g.m2946KK().mo4819KP()) {
                C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(C1407g.m2946KK().mo4822KV()), Boolean.valueOf(C1407g.m2946KK().mo4819KP()));
                this.com = false;
            }
            C1407g.m2946KK().mo4834f(this.com, false, false);
            m52741Ey();
            setError();
            str2 = null;
            if (z2) {
                str2 = str;
            } else if (this.coq == 0) {
                str2 = C32850q.getFullPath(str);
            }
            C1407g.m2946KK().mo4828a((C1406a) this);
            if (!C1407g.m2946KK().mo4822KV()) {
                C1407g.m2946KK().mo4817KM();
                this.cos = true;
            }
            if (this.col.mo21075S(str2, this.com)) {
                C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", Boolean.valueOf(this.coy));
                if (this.coy) {
                    this.cop.requestFocus();
                    this.coA = true;
                }
                this.coz = true;
                AppMethodBeat.m2505o(116458);
                return true;
            }
            C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + str + "], [" + z + "]");
            C1407g.m2946KK().mo4818KN();
            this.cos = false;
            AppMethodBeat.m2505o(116458);
            return false;
        }
        str2 = "MicroMsg.SceneVoicePlayer";
        String str3 = "start, file %s not exist!, fullPath: %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (!z2) {
            str = C32850q.getFullPath(str);
        }
        objArr[1] = str;
        C4990ab.m7413e(str2, str3, objArr);
        AppMethodBeat.m2505o(116458);
        return false;
    }

    /* renamed from: a */
    public final boolean mo33403a(String str, boolean z, int i, int i2) {
        AppMethodBeat.m2504i(116459);
        C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.TRUE, Integer.valueOf(i), Integer.valueOf(this.coq));
        Assert.assertTrue(str.length() > 0);
        if (C5730e.m8628ct(str)) {
            if (i == -1) {
                i = C32848o.m53696g(str, this.coq, true);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.col = new C9746s(this.context);
                } else {
                    this.col = new C9746s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.col = new C9738j(this.context);
                } else {
                    this.col = new C9738j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.col = new C9732i(this.context);
                } else {
                    this.col = new C9732i();
                }
            }
            if (this.col != null) {
                this.col.mo21080b(this.coB);
                this.cop.mo73179a(this.coB);
                this.col.alP();
            }
            this.com = z;
            this.cor = z;
            if (C1407g.m2946KK().mo4822KV() || C1407g.m2946KK().mo4819KP()) {
                C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(C1407g.m2946KK().mo4822KV()), Boolean.valueOf(C1407g.m2946KK().mo4819KP()));
                this.com = false;
            }
            C1407g.m2946KK().mo4834f(this.com, false, false);
            m52741Ey();
            setError();
            C1407g.m2946KK().mo4828a((C1406a) this);
            if (!C1407g.m2946KK().mo4822KV()) {
                C1407g.m2946KK().mo4817KM();
                this.cos = true;
            }
            if (this.col.mo21083c(str, this.com, i2)) {
                C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", Boolean.valueOf(this.coy));
                if (this.coy) {
                    this.cop.requestFocus();
                    this.coA = true;
                }
                this.coz = true;
                AppMethodBeat.m2505o(116459);
                return true;
            }
            C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "start play fileName[" + str + "], [" + z + "]");
            C1407g.m2946KK().mo4818KN();
            this.cos = false;
            AppMethodBeat.m2505o(116459);
            return false;
        }
        C4990ab.m7413e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", str, str);
        AppMethodBeat.m2505o(116459);
        return false;
    }

    /* renamed from: bl */
    public final void mo33405bl(boolean z) {
        this.coy = z;
    }

    /* renamed from: bm */
    public final void mo33406bm(boolean z) {
        this.coz = z;
    }

    public final boolean pause() {
        AppMethodBeat.m2504i(139159);
        boolean bn = mo53006bn(true);
        AppMethodBeat.m2505o(139159);
        return bn;
    }

    /* renamed from: bn */
    public final boolean mo53006bn(boolean z) {
        AppMethodBeat.m2504i(116461);
        if (this.col == null) {
            AppMethodBeat.m2505o(116461);
            return false;
        }
        boolean bn;
        C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "pause");
        if (this.col.isPlaying()) {
            bn = this.col.mo21081bn(z);
        } else {
            bn = false;
        }
        if (bn) {
            if (this.cos) {
                C1407g.m2946KK().mo4818KN();
                this.cos = false;
            }
            if (this.cou != null) {
                this.cou.mo33394cC(z);
            }
        }
        C1407g.m2946KK().setMode(0);
        C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(this.coy), Boolean.valueOf(this.coA));
        if (this.coA) {
            this.cop.mo73178Mm();
            this.coA = false;
        }
        AppMethodBeat.m2505o(116461);
        return bn;
    }

    /* renamed from: Ew */
    public final boolean mo33396Ew() {
        AppMethodBeat.m2504i(116462);
        if (this.col == null) {
            AppMethodBeat.m2505o(116462);
            return false;
        }
        C4990ab.m7416i("MicroMsg.SceneVoicePlayer", "resume");
        boolean Ew = this.col.mo21073Ew();
        if (Ew) {
            C1407g.m2946KK().mo4817KM();
            this.cos = true;
            if (C1407g.m2946KK().mo4819KP()) {
                this.com = false;
            }
            C1407g.m2946KK().mo4834f(this.com, false, false);
        }
        C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(this.coy), Boolean.valueOf(this.coA));
        if (this.coA) {
            this.cop.requestFocus();
            this.coA = false;
        }
        AppMethodBeat.m2505o(116462);
        return Ew;
    }

    /* renamed from: m */
    public final boolean mo53007m(String str, boolean z) {
        AppMethodBeat.m2504i(116463);
        boolean a = mo33404a(str, z, false, -1);
        AppMethodBeat.m2505o(116463);
        return a;
    }

    /* renamed from: Ex */
    public final boolean mo33397Ex() {
        return this.con;
    }

    public final void stop() {
        AppMethodBeat.m2504i(139160);
        stop(false);
        AppMethodBeat.m2505o(139160);
    }

    public final void stop(boolean z) {
        AppMethodBeat.m2504i(116465);
        if (this.col == null) {
            AppMethodBeat.m2505o(116465);
            return;
        }
        C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b, fromStart: %b", Boolean.valueOf(this.cos), Boolean.valueOf(this.col.isPlaying()), Boolean.valueOf(z));
        this.col.mo21072EH();
        C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", Boolean.valueOf(this.coy), Boolean.valueOf(this.coA), Boolean.valueOf(this.coz));
        if (this.coA && this.coz) {
            this.cop.mo73178Mm();
            this.coA = false;
        }
        C1407g.m2946KK().mo4829b((C1406a) this);
        if (this.cos && !z) {
            C1407g.m2946KK().mo4818KN();
            this.cos = false;
        }
        if (!(z || this.cov == null)) {
            this.cov.onStop();
        }
        try {
            C1407g.m2946KK().setMode(0);
            AppMethodBeat.m2505o(116465);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SceneVoicePlayer", e, "stop reset speaker error: %s", e.getMessage());
            AppMethodBeat.m2505o(116465);
        }
    }

    /* renamed from: bo */
    public final void mo33407bo(final boolean z) {
        AppMethodBeat.m2504i(116466);
        if (this.com == z) {
            AppMethodBeat.m2505o(116466);
            return;
        }
        this.com = z;
        if (this.col != null && this.col.isPlaying()) {
            this.col.mo21082bo(z);
        }
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(116449);
                C1407g.m2946KK().mo4834f(z, false, false);
                AppMethodBeat.m2505o(116449);
            }
        }, "SceneVoicePlayer_shiftSpeaker");
        AppMethodBeat.m2505o(116466);
    }

    /* renamed from: a */
    public final void mo33400a(C17892b c17892b) {
        this.coC = c17892b;
    }

    /* renamed from: a */
    public final void mo33401a(C17890c c17890c) {
        this.cou = c17890c;
    }

    /* renamed from: a */
    public final void mo33402a(C17893d c17893d) {
        this.cov = c17893d;
    }

    private void setError() {
        AppMethodBeat.m2504i(116467);
        C26499b c322963 = new C322963();
        if (this.col != null) {
            this.col.mo21077a(c322963);
        }
        AppMethodBeat.m2505o(116467);
    }

    /* renamed from: a */
    public final void mo33399a(C17889a c17889a) {
        this.coD = c17889a;
    }

    /* renamed from: Ey */
    private void m52741Ey() {
        AppMethodBeat.m2504i(116468);
        C18718a c322994 = new C322994();
        if (this.col != null) {
            this.col.mo21076a(c322994);
        }
        AppMethodBeat.m2505o(116468);
    }

    /* renamed from: Ez */
    public final double mo33398Ez() {
        AppMethodBeat.m2504i(116469);
        if (this.col == null) {
            AppMethodBeat.m2505o(116469);
            return 0.0d;
        }
        double Ez = this.col.mo21074Ez();
        AppMethodBeat.m2505o(116469);
        return Ez;
    }

    /* renamed from: bp */
    public final void mo33408bp(boolean z) {
        AppMethodBeat.m2504i(116470);
        C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", Boolean.valueOf(z));
        this.coo = z;
        AppMethodBeat.m2505o(116470);
    }

    /* renamed from: DA */
    public final boolean mo33395DA() {
        AppMethodBeat.m2504i(116471);
        if (this.col == null) {
            AppMethodBeat.m2505o(116471);
            return false;
        } else if (this.col.getStatus() == 2) {
            AppMethodBeat.m2505o(116471);
            return true;
        } else {
            AppMethodBeat.m2505o(116471);
            return false;
        }
    }

    /* renamed from: gE */
    public final void mo4815gE(int i) {
        AppMethodBeat.m2504i(116472);
        C4990ab.m7417i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.com), Boolean.valueOf(this.cor), Boolean.valueOf(this.cos));
        switch (i) {
            case 1:
                mo33407bo(false);
                AppMethodBeat.m2505o(116472);
                return;
            case 2:
            case 4:
                mo33407bo(this.cor);
                if (this.cos) {
                    C1407g.m2946KK().mo4818KN();
                    this.cos = false;
                    AppMethodBeat.m2505o(116472);
                    return;
                }
                break;
            case 5:
                C1407g.m2946KK().mo4817KM();
                AppMethodBeat.m2505o(116472);
                return;
            case 6:
                mo33407bo(this.cor);
                if (this.col != null && this.col.isPlaying()) {
                    C1407g.m2946KK().mo4817KM();
                    this.cos = true;
                    AppMethodBeat.m2505o(116472);
                    return;
                }
            case 7:
                if (this.col != null && this.col.isPlaying()) {
                    C1407g.m2946KK().mo4817KM();
                    this.cos = true;
                    break;
                }
        }
        AppMethodBeat.m2505o(116472);
    }
}
