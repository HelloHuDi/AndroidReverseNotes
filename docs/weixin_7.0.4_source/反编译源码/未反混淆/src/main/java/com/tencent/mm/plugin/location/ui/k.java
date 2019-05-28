package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bg.c;
import com.tencent.mm.bg.d;
import com.tencent.mm.bg.g;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class k implements f, d {
    private Activity activity;
    private List<String> cFX = new LinkedList();
    public c nNA;
    public a nNB;
    final ap nNC = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            int akx;
            AppMethodBeat.i(113534);
            if (k.this.nNu == 3) {
                akx = k.this.nNA.akx();
            } else if (bo.isNullOrNil(k.this.nNr)) {
                AppMethodBeat.o(113534);
                return false;
            } else {
                akx = k.this.nNA.aky();
            }
            k kVar = k.this;
            float f = (float) akx;
            if (f < 10.0f) {
                f = 10.0f;
            }
            if (f > 100.0f) {
                f = 100.0f;
            }
            kVar.nNn.setVolume(f / 100.0f);
            kVar.nNn.invalidate();
            AppMethodBeat.o(113534);
            return true;
        }
    }, true);
    private boolean nND = true;
    Button nNm;
    public VolumeMeter nNn;
    RelativeLayout nNo;
    private boolean nNp = true;
    private String nNq;
    String nNr;
    private String nNs;
    boolean nNt = false;
    int nNu = 0;
    private long nNv = 500;
    long nNw = 0;
    ap nNx = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(113530);
            ab.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
            k.this.bJZ();
            AppMethodBeat.o(113530);
            return false;
        }
    }, false);
    ap nNy = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(113531);
            ab.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
            k.a(k.this);
            AppMethodBeat.o(113531);
            return false;
        }
    }, false);
    private ap nNz = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(113532);
            k.this.bKa();
            AppMethodBeat.o(113532);
            return false;
        }
    }, false);

    public interface a {
        void PY(String str);

        void PZ(String str);

        void bJV();

        void bJW();

        void bJX();
    }

    public k(Activity activity, Button button) {
        AppMethodBeat.i(113538);
        this.activity = activity;
        this.nNm = button;
        this.nNo = (RelativeLayout) this.activity.findViewById(R.id.c_q);
        this.nNo.setVisibility(8);
        this.nNn = (VolumeMeter) this.nNo.findViewById(R.id.c_r);
        this.nNn.setArchView(this.nNm);
        VolumeMeter volumeMeter = this.nNn;
        if (volumeMeter.nOk == null) {
            com.tencent.mm.sdk.g.d.a(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(113577);
                    Looper.prepare();
                    VolumeMeter.this.nOk = new ak();
                    Looper.loop();
                    AppMethodBeat.o(113577);
                }
            }, "VolumeMeter_handler", 1).start();
        }
        this.nNA = g.fUt;
        if (this.nNA == null) {
            ab.e("MicroMsg.TalkMgr", "cannot get talkroom server");
        }
        AppMethodBeat.o(113538);
    }

    public final void bJY() {
        AppMethodBeat.i(113539);
        this.nNs = this.activity.getIntent().getStringExtra("map_talker_name");
        this.nNA.a(this);
        ab.d("MicroMsg.TalkMgr", "talkRoomName %s ", this.nNs);
        final String str = this.nNs;
        this.nNq = str;
        if (!bo.isNullOrNil(this.nNq)) {
            if (t.kH(str)) {
                List my = n.my(str);
                if (my == null) {
                    com.tencent.mm.model.ao.a.flu.ai(str, "");
                } else {
                    this.cFX = my;
                }
            } else {
                this.cFX.clear();
                this.cFX.add(str);
                this.cFX.add(r.Yz());
            }
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(113535);
                    k.this.nNA.ac(str, 1);
                    AppMethodBeat.o(113535);
                }
            });
            this.nNm.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(113537);
                    switch (motionEvent.getAction()) {
                        case 0:
                            k.this.nNt = true;
                            k.this.nNo.setVisibility(0);
                            k.this.nNn.reset();
                            VolumeMeter volumeMeter = k.this.nNn;
                            if (!volumeMeter.nOg) {
                                volumeMeter.fAA = true;
                                volumeMeter.bKh();
                            }
                            k.this.nNm.setPressed(true);
                            if (k.this.nNt) {
                                ay.a(ah.getContext(), R.string.ev4, new com.tencent.mm.sdk.platformtools.ay.a() {
                                    public final void EA() {
                                        AppMethodBeat.i(113536);
                                        ab.i("MicroMsg.TalkMgr", "play press sound end");
                                        AppMethodBeat.o(113536);
                                    }
                                });
                                k.this.nNu = 1;
                                ab.i("MicroMsg.TalkMgr", "micBtn pressed down");
                                k.this.nNw = bo.yz();
                                k.this.nNA.akz();
                                k.this.bKa();
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            k.this.nNm.setPressed(false);
                            k.this.nNo.setVisibility(8);
                            k.this.nNn.reset();
                            k.this.nNn.fAA = false;
                            if (k.this.nNt) {
                                k.this.nNt = false;
                                if (k.this.nNu == 5) {
                                    ab.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                                    k.this.nNx.stopTimer();
                                    k.this.nNy.stopTimer();
                                }
                                k.this.nNu = 0;
                                k.this.nNC.stopTimer();
                                k.this.nNA.akA();
                                ay.au(ah.getContext(), R.string.ev7);
                                k.this.bKa();
                                if (k.this.nNB != null) {
                                    k.this.nNB.bJW();
                                    break;
                                }
                            }
                            break;
                        case 2:
                            if (k.this.nNt) {
                            }
                            break;
                    }
                    AppMethodBeat.o(113537);
                    return false;
                }
            });
        }
        AppMethodBeat.o(113539);
    }

    /* Access modifiers changed, original: final */
    public final void bJZ() {
        AppMethodBeat.i(113540);
        if (this.nNu != 5) {
            AppMethodBeat.o(113540);
            return;
        }
        this.nNx.stopTimer();
        bKa();
        ay.a(ah.getContext(), R.string.ev0, new com.tencent.mm.sdk.platformtools.ay.a() {
            public final void EA() {
                AppMethodBeat.i(113533);
                k.this.nNy.stopTimer();
                k.a(k.this);
                AppMethodBeat.o(113533);
            }
        });
        this.nNy.ae(1000, 1000);
        AppMethodBeat.o(113540);
    }

    /* Access modifiers changed, original: final */
    public final void bKa() {
        AppMethodBeat.i(113541);
        if (this.nNp) {
            AppMethodBeat.o(113541);
            return;
        }
        if (g.fUt.akB()) {
            ab.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
            if (this.nNB != null) {
                this.nNB.PY(null);
                this.nNB.bJW();
            }
        }
        switch (this.nNu) {
            case 0:
                ab.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", this.nNr);
                if (this.nNB != null) {
                    if (bo.isNullOrNil(this.nNr)) {
                        this.nNB.PY(null);
                        AppMethodBeat.o(113541);
                        return;
                    }
                    this.nNB.PY(this.nNr);
                    AppMethodBeat.o(113541);
                    return;
                }
                break;
            case 1:
                ab.d("MicroMsg.TalkMgr", "seize, state seizing");
                if (this.nNB != null) {
                    this.nNB.bJX();
                    AppMethodBeat.o(113541);
                    return;
                }
                break;
            case 2:
                ab.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", this.nNr);
                if (!(this.nNB == null || bo.isNullOrNil(this.nNr))) {
                    this.nNB.PZ(this.nNr);
                    AppMethodBeat.o(113541);
                    return;
                }
            case 3:
            case 5:
                ab.d("MicroMsg.TalkMgr", "seize, state success or prepare");
                if (this.nNB != null) {
                    this.nNB.bJV();
                    AppMethodBeat.o(113541);
                    return;
                }
                break;
            case 4:
                ab.d("MicroMsg.TalkMgr", "seize time out");
                break;
        }
        AppMethodBeat.o(113541);
    }

    public static void bKb() {
        AppMethodBeat.i(113542);
        sz szVar = new sz();
        szVar.cPf.cPi = true;
        com.tencent.mm.sdk.b.a.xxA.m(szVar);
        com.tencent.mm.compatible.b.g.KK().setMode(0);
        AppMethodBeat.o(113542);
    }

    public final void akC() {
        AppMethodBeat.i(113543);
        this.nNp = false;
        this.nNm.setEnabled(true);
        bKa();
        AppMethodBeat.o(113543);
    }

    public final void l(String str, int i, int i2) {
        AppMethodBeat.i(113544);
        ab.f("MicroMsg.TalkMgr", "onInitFailed %s", str);
        l.bJy().xC(3);
        this.activity.finish();
        AppMethodBeat.o(113544);
    }

    public final void akD() {
        AppMethodBeat.i(113545);
        if (this.nNu != 1) {
            AppMethodBeat.o(113545);
            return;
        }
        this.nNu = 5;
        if (bo.az(this.nNw) < this.nNv) {
            ab.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
            long az = this.nNv - bo.az(this.nNw);
            this.nNx.ae(az, az);
            AppMethodBeat.o(113545);
            return;
        }
        bJZ();
        AppMethodBeat.o(113545);
    }

    public final void mk(int i) {
        AppMethodBeat.i(113546);
        ab.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
        if (i == 340) {
            if (this.nNu != 3) {
                AppMethodBeat.o(113546);
                return;
            }
            this.nNu = 4;
        } else if (this.nNu != 1) {
            AppMethodBeat.o(113546);
            return;
        } else {
            this.nNu = 2;
        }
        bKa();
        ay.a(ah.getContext(), null);
        AppMethodBeat.o(113546);
    }

    public final void tO(String str) {
        AppMethodBeat.i(113547);
        ab.d("MicroMsg.TalkMgr", "onCurMember change %s", str);
        this.nNr = str;
        bKa();
        if (bo.isNullOrNil(str)) {
            this.nNC.stopTimer();
            AppMethodBeat.o(113547);
            return;
        }
        ay.au(ah.getContext(), R.string.ev3);
        this.nNC.ae(100, 100);
        AppMethodBeat.o(113547);
    }

    public final void aU(String str, String str2) {
        AppMethodBeat.i(113548);
        ab.i("MicroMsg.TalkMgr", "add %s,  del %s", str, str2);
        if (this.nNp) {
            AppMethodBeat.o(113548);
        } else {
            AppMethodBeat.o(113548);
        }
    }

    public final void g(int i, int i2, String str) {
    }

    public final void akE() {
    }

    public final void akF() {
        AppMethodBeat.i(113549);
        bKa();
        AppMethodBeat.o(113549);
    }

    public final void akG() {
        AppMethodBeat.i(113550);
        bKa();
        AppMethodBeat.o(113550);
    }

    public final void akH() {
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
    }

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(113551);
        if (kVar.nNu == 5) {
            kVar.nNu = 3;
            kVar.nNA.akw();
            kVar.nNC.ae(100, 100);
        }
        AppMethodBeat.o(113551);
    }
}
