package com.tencent.mm.audio.a;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.ai.h.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import junit.framework.Assert;

public final class a implements h, com.tencent.mm.compatible.b.g.a {
    private static String cox = null;
    private boolean coA;
    private com.tencent.mm.compatible.util.b.a coB;
    public b coC;
    public com.tencent.mm.ai.h.a coD;
    private d col;
    private boolean com;
    private boolean con;
    private Context context;
    private boolean coo;
    private com.tencent.mm.compatible.util.b cop;
    private int coq;
    private boolean cor;
    private boolean cos;
    private boolean cot;
    private c cou;
    private h.d cov;
    private String cow;
    private boolean coy;
    private boolean coz;

    public a(Context context) {
        this(context, 0);
    }

    public a(Context context, int i) {
        AppMethodBeat.i(116456);
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
        this.coB = new com.tencent.mm.compatible.util.b.a() {
            public final void gF(int i) {
                AppMethodBeat.i(116448);
                ab.i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", Integer.valueOf(i));
                if (i == -2 || i == -3) {
                    if (a.this.isPlaying()) {
                        ab.v("MicroMsg.SceneVoicePlayer", "alvinluo current fileName: %s, lastFileName: %s", a.this.cow, a.cox);
                        if (a.this.cow == null || a.this.cow.equals(a.cox)) {
                            if (!bo.gW(((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_target26_voice_focus_shield_sw, 0), 0)) {
                                ab.i("MicroMsg.SceneVoicePlayer", "no shield");
                            } else if (i == -3 && com.tencent.mm.compatible.util.d.iW(26)) {
                                ab.i("MicroMsg.SceneVoicePlayer", "focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK %s", Integer.valueOf(VERSION.SDK_INT));
                                AppMethodBeat.o(116448);
                                return;
                            }
                            a.this.bn(false);
                            AppMethodBeat.o(116448);
                            return;
                        }
                    }
                } else if (i == 1 || i == 2 || i == 3) {
                    a.this.Ew();
                    AppMethodBeat.o(116448);
                    return;
                } else if (i == -1) {
                    a.this.stop(false);
                }
                AppMethodBeat.o(116448);
            }
        };
        this.coC = null;
        this.context = context;
        this.cop = new com.tencent.mm.compatible.util.b(context);
        this.coq = i;
        com.tencent.mm.audio.b.g.b bVar = new com.tencent.mm.audio.b.g.b();
        AppMethodBeat.o(116456);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(116457);
        if (this.col == null) {
            AppMethodBeat.o(116457);
            return false;
        }
        boolean isPlaying = this.col.isPlaying();
        AppMethodBeat.o(116457);
        return isPlaying;
    }

    public final boolean a(String str, boolean z, boolean z2, int i) {
        AppMethodBeat.i(116458);
        ab.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(this.coq));
        Assert.assertTrue(str.length() > 0);
        cox = this.cow;
        this.cow = str;
        String str2;
        if (e.ct(z2 ? str : q.getFullPath(str))) {
            if (i == -1) {
                i = o.g(str, this.coq, z2);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.col = new s(this.context);
                } else {
                    this.col = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.col = new j(this.context);
                } else {
                    this.col = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.col = new i(this.context);
                } else {
                    this.col = new i();
                }
            }
            if (this.col != null) {
                this.col.b(this.coB);
                this.cop.a(this.coB);
                this.col.alP();
            }
            this.com = z;
            this.cor = z;
            if (com.tencent.mm.compatible.b.g.KK().KV() || com.tencent.mm.compatible.b.g.KK().KP()) {
                ab.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(com.tencent.mm.compatible.b.g.KK().KV()), Boolean.valueOf(com.tencent.mm.compatible.b.g.KK().KP()));
                this.com = false;
            }
            com.tencent.mm.compatible.b.g.KK().f(this.com, false, false);
            Ey();
            setError();
            str2 = null;
            if (z2) {
                str2 = str;
            } else if (this.coq == 0) {
                str2 = q.getFullPath(str);
            }
            com.tencent.mm.compatible.b.g.KK().a((com.tencent.mm.compatible.b.g.a) this);
            if (!com.tencent.mm.compatible.b.g.KK().KV()) {
                com.tencent.mm.compatible.b.g.KK().KM();
                this.cos = true;
            }
            if (this.col.S(str2, this.com)) {
                ab.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", Boolean.valueOf(this.coy));
                if (this.coy) {
                    this.cop.requestFocus();
                    this.coA = true;
                }
                this.coz = true;
                AppMethodBeat.o(116458);
                return true;
            }
            ab.i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + str + "], [" + z + "]");
            com.tencent.mm.compatible.b.g.KK().KN();
            this.cos = false;
            AppMethodBeat.o(116458);
            return false;
        }
        str2 = "MicroMsg.SceneVoicePlayer";
        String str3 = "start, file %s not exist!, fullPath: %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (!z2) {
            str = q.getFullPath(str);
        }
        objArr[1] = str;
        ab.e(str2, str3, objArr);
        AppMethodBeat.o(116458);
        return false;
    }

    public final boolean a(String str, boolean z, int i, int i2) {
        AppMethodBeat.i(116459);
        ab.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.TRUE, Integer.valueOf(i), Integer.valueOf(this.coq));
        Assert.assertTrue(str.length() > 0);
        if (e.ct(str)) {
            if (i == -1) {
                i = o.g(str, this.coq, true);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.col = new s(this.context);
                } else {
                    this.col = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.col = new j(this.context);
                } else {
                    this.col = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.col = new i(this.context);
                } else {
                    this.col = new i();
                }
            }
            if (this.col != null) {
                this.col.b(this.coB);
                this.cop.a(this.coB);
                this.col.alP();
            }
            this.com = z;
            this.cor = z;
            if (com.tencent.mm.compatible.b.g.KK().KV() || com.tencent.mm.compatible.b.g.KK().KP()) {
                ab.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(com.tencent.mm.compatible.b.g.KK().KV()), Boolean.valueOf(com.tencent.mm.compatible.b.g.KK().KP()));
                this.com = false;
            }
            com.tencent.mm.compatible.b.g.KK().f(this.com, false, false);
            Ey();
            setError();
            com.tencent.mm.compatible.b.g.KK().a((com.tencent.mm.compatible.b.g.a) this);
            if (!com.tencent.mm.compatible.b.g.KK().KV()) {
                com.tencent.mm.compatible.b.g.KK().KM();
                this.cos = true;
            }
            if (this.col.c(str, this.com, i2)) {
                ab.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s", Boolean.valueOf(this.coy));
                if (this.coy) {
                    this.cop.requestFocus();
                    this.coA = true;
                }
                this.coz = true;
                AppMethodBeat.o(116459);
                return true;
            }
            ab.i("MicroMsg.SceneVoicePlayer", "start play fileName[" + str + "], [" + z + "]");
            com.tencent.mm.compatible.b.g.KK().KN();
            this.cos = false;
            AppMethodBeat.o(116459);
            return false;
        }
        ab.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", str, str);
        AppMethodBeat.o(116459);
        return false;
    }

    public final void bl(boolean z) {
        this.coy = z;
    }

    public final void bm(boolean z) {
        this.coz = z;
    }

    public final boolean pause() {
        AppMethodBeat.i(139159);
        boolean bn = bn(true);
        AppMethodBeat.o(139159);
        return bn;
    }

    public final boolean bn(boolean z) {
        AppMethodBeat.i(116461);
        if (this.col == null) {
            AppMethodBeat.o(116461);
            return false;
        }
        boolean bn;
        ab.i("MicroMsg.SceneVoicePlayer", "pause");
        if (this.col.isPlaying()) {
            bn = this.col.bn(z);
        } else {
            bn = false;
        }
        if (bn) {
            if (this.cos) {
                com.tencent.mm.compatible.b.g.KK().KN();
                this.cos = false;
            }
            if (this.cou != null) {
                this.cou.cC(z);
            }
        }
        com.tencent.mm.compatible.b.g.KK().setMode(0);
        ab.i("MicroMsg.SceneVoicePlayer", "jacks Player abandonFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(this.coy), Boolean.valueOf(this.coA));
        if (this.coA) {
            this.cop.Mm();
            this.coA = false;
        }
        AppMethodBeat.o(116461);
        return bn;
    }

    public final boolean Ew() {
        AppMethodBeat.i(116462);
        if (this.col == null) {
            AppMethodBeat.o(116462);
            return false;
        }
        ab.i("MicroMsg.SceneVoicePlayer", "resume");
        boolean Ew = this.col.Ew();
        if (Ew) {
            com.tencent.mm.compatible.b.g.KK().KM();
            this.cos = true;
            if (com.tencent.mm.compatible.b.g.KK().KP()) {
                this.com = false;
            }
            com.tencent.mm.compatible.b.g.KK().f(this.com, false, false);
        }
        ab.i("MicroMsg.SceneVoicePlayer", "jacks Player requestFocus focus helper, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(this.coy), Boolean.valueOf(this.coA));
        if (this.coA) {
            this.cop.requestFocus();
            this.coA = false;
        }
        AppMethodBeat.o(116462);
        return Ew;
    }

    public final boolean m(String str, boolean z) {
        AppMethodBeat.i(116463);
        boolean a = a(str, z, false, -1);
        AppMethodBeat.o(116463);
        return a;
    }

    public final boolean Ex() {
        return this.con;
    }

    public final void stop() {
        AppMethodBeat.i(139160);
        stop(false);
        AppMethodBeat.o(139160);
    }

    public final void stop(boolean z) {
        AppMethodBeat.i(116465);
        if (this.col == null) {
            AppMethodBeat.o(116465);
            return;
        }
        ab.i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b, fromStart: %b", Boolean.valueOf(this.cos), Boolean.valueOf(this.col.isPlaying()), Boolean.valueOf(z));
        this.col.EH();
        ab.i("MicroMsg.SceneVoicePlayer", "stop player abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s, abandonFocusOnStop: %s", Boolean.valueOf(this.coy), Boolean.valueOf(this.coA), Boolean.valueOf(this.coz));
        if (this.coA && this.coz) {
            this.cop.Mm();
            this.coA = false;
        }
        com.tencent.mm.compatible.b.g.KK().b((com.tencent.mm.compatible.b.g.a) this);
        if (this.cos && !z) {
            com.tencent.mm.compatible.b.g.KK().KN();
            this.cos = false;
        }
        if (!(z || this.cov == null)) {
            this.cov.onStop();
        }
        try {
            com.tencent.mm.compatible.b.g.KK().setMode(0);
            AppMethodBeat.o(116465);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SceneVoicePlayer", e, "stop reset speaker error: %s", e.getMessage());
            AppMethodBeat.o(116465);
        }
    }

    public final void bo(final boolean z) {
        AppMethodBeat.i(116466);
        if (this.com == z) {
            AppMethodBeat.o(116466);
            return;
        }
        this.com = z;
        if (this.col != null && this.col.isPlaying()) {
            this.col.bo(z);
        }
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(116449);
                com.tencent.mm.compatible.b.g.KK().f(z, false, false);
                AppMethodBeat.o(116449);
            }
        }, "SceneVoicePlayer_shiftSpeaker");
        AppMethodBeat.o(116466);
    }

    public final void a(b bVar) {
        this.coC = bVar;
    }

    public final void a(c cVar) {
        this.cou = cVar;
    }

    public final void a(h.d dVar) {
        this.cov = dVar;
    }

    private void setError() {
        AppMethodBeat.i(116467);
        d.b anonymousClass3 = new d.b() {
            public final void onError() {
                AppMethodBeat.i(116451);
                com.tencent.mm.compatible.b.g.KK().b(a.this);
                if (a.this.cos) {
                    com.tencent.mm.compatible.b.g.KK().KN();
                    a.this.cos = false;
                }
                com.tencent.mm.compatible.b.g.KK().setMode(0);
                ab.i("MicroMsg.SceneVoicePlayer", "setError abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(a.this.coy), Boolean.valueOf(a.this.coA));
                if (a.this.coA) {
                    a.this.cop.Mm();
                    a.this.coA = false;
                }
                if (a.this.coC != null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(116450);
                            a.this.coC.onError();
                            AppMethodBeat.o(116450);
                        }
                    });
                }
                AppMethodBeat.o(116451);
            }
        };
        if (this.col != null) {
            this.col.a(anonymousClass3);
        }
        AppMethodBeat.o(116467);
    }

    public final void a(com.tencent.mm.ai.h.a aVar) {
        this.coD = aVar;
    }

    private void Ey() {
        AppMethodBeat.i(116468);
        com.tencent.mm.modelvoice.d.a anonymousClass4 = new com.tencent.mm.modelvoice.d.a() {
            public final void EA() {
                AppMethodBeat.i(116455);
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(116454);
                        try {
                            if (com.tencent.mm.compatible.e.q.etd.epP == 1) {
                                Thread.sleep(300);
                            }
                            ab.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", a.this.coD, Boolean.valueOf(a.this.cot));
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(116453);
                                    com.tencent.mm.compatible.b.g.KK().f(a.this.com, false, false);
                                    if (a.this.cot) {
                                        ay.b bVar;
                                        Context l = a.this.context;
                                        boolean k = a.this.com;
                                        AnonymousClass1 anonymousClass1 = new com.tencent.mm.sdk.platformtools.ay.a() {
                                            public final void EA() {
                                                AppMethodBeat.i(116452);
                                                ab.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                                                if (!a.this.isPlaying()) {
                                                    com.tencent.mm.compatible.b.g.KK().b(a.this);
                                                    ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(a.this.coo));
                                                    if (!a.this.coo) {
                                                        com.tencent.mm.compatible.b.g.KK().KN();
                                                    }
                                                    a.this.coo = false;
                                                    a.this.cos = false;
                                                    com.tencent.mm.compatible.b.g.KK().setMode(0);
                                                    ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(a.this.coy), Boolean.valueOf(a.this.coA));
                                                    if (a.this.coA) {
                                                        a.this.cop.Mm();
                                                        a.this.coA = false;
                                                    }
                                                    ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                                                }
                                                AppMethodBeat.o(116452);
                                            }
                                        };
                                        if (k) {
                                            bVar = ay.b.ON;
                                        } else {
                                            bVar = ay.b.OFF;
                                        }
                                        ay.a(l, R.string.dcn, bVar, anonymousClass1);
                                    } else {
                                        ab.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                                        if (!a.this.isPlaying()) {
                                            ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() abandon focus, needFocusOnPlay: %s, hasAudioFocus: %s", Boolean.valueOf(a.this.coy), Boolean.valueOf(a.this.coA));
                                            if (a.this.coA) {
                                                a.this.cop.Mm();
                                                a.this.coA = false;
                                            }
                                            com.tencent.mm.compatible.b.g.KK().b(a.this);
                                            ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(a.this.coo));
                                            if (!a.this.coo) {
                                                com.tencent.mm.compatible.b.g.KK().KN();
                                            }
                                            a.this.coo = false;
                                            a.this.cos = false;
                                            com.tencent.mm.compatible.b.g.KK().setMode(0);
                                            ab.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                                        }
                                    }
                                    if (a.this.coD != null) {
                                        ab.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                                        a.this.coD.EA();
                                        AppMethodBeat.o(116453);
                                        return;
                                    }
                                    ab.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                                    AppMethodBeat.o(116453);
                                }
                            });
                            AppMethodBeat.o(116454);
                        } catch (Exception e) {
                            ab.e("MicroMsg.SceneVoicePlayer", "exception:%s", bo.l(e));
                            AppMethodBeat.o(116454);
                        }
                    }
                }, "SceneVoice_onCompletion");
                AppMethodBeat.o(116455);
            }
        };
        if (this.col != null) {
            this.col.a(anonymousClass4);
        }
        AppMethodBeat.o(116468);
    }

    public final double Ez() {
        AppMethodBeat.i(116469);
        if (this.col == null) {
            AppMethodBeat.o(116469);
            return 0.0d;
        }
        double Ez = this.col.Ez();
        AppMethodBeat.o(116469);
        return Ez;
    }

    public final void bp(boolean z) {
        AppMethodBeat.i(116470);
        ab.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", Boolean.valueOf(z));
        this.coo = z;
        AppMethodBeat.o(116470);
    }

    public final boolean DA() {
        AppMethodBeat.i(116471);
        if (this.col == null) {
            AppMethodBeat.o(116471);
            return false;
        } else if (this.col.getStatus() == 2) {
            AppMethodBeat.o(116471);
            return true;
        } else {
            AppMethodBeat.o(116471);
            return false;
        }
    }

    public final void gE(int i) {
        AppMethodBeat.i(116472);
        ab.i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.com), Boolean.valueOf(this.cor), Boolean.valueOf(this.cos));
        switch (i) {
            case 1:
                bo(false);
                AppMethodBeat.o(116472);
                return;
            case 2:
            case 4:
                bo(this.cor);
                if (this.cos) {
                    com.tencent.mm.compatible.b.g.KK().KN();
                    this.cos = false;
                    AppMethodBeat.o(116472);
                    return;
                }
                break;
            case 5:
                com.tencent.mm.compatible.b.g.KK().KM();
                AppMethodBeat.o(116472);
                return;
            case 6:
                bo(this.cor);
                if (this.col != null && this.col.isPlaying()) {
                    com.tencent.mm.compatible.b.g.KK().KM();
                    this.cos = true;
                    AppMethodBeat.o(116472);
                    return;
                }
            case 7:
                if (this.col != null && this.col.isPlaying()) {
                    com.tencent.mm.compatible.b.g.KK().KM();
                    this.cos = true;
                    break;
                }
        }
        AppMethodBeat.o(116472);
    }
}
