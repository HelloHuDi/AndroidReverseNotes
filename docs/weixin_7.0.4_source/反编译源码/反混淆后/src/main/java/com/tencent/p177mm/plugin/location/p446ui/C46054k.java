package com.tencent.p177mm.plugin.location.p446ui;

import android.app.Activity;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p203bg.C1309c;
import com.tencent.p177mm.p203bg.C32336d;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.plugin.location.model.C39287l;
import com.tencent.p177mm.plugin.location.p446ui.VolumeMeter.C211771;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C35988ay.C30291a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.location.ui.k */
public final class C46054k implements C1202f, C32336d {
    private Activity activity;
    private List<String> cFX = new LinkedList();
    public C1309c nNA;
    public C34424a nNB;
    final C7564ap nNC = new C7564ap(new C344225(), true);
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
    C7564ap nNx = new C7564ap(new C69621(), false);
    C7564ap nNy = new C7564ap(new C344202(), false);
    private C7564ap nNz = new C7564ap(new C344213(), false);

    /* renamed from: com.tencent.mm.plugin.location.ui.k$1 */
    class C69621 implements C5015a {
        C69621() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(113530);
            C4990ab.m7416i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
            C46054k.this.bJZ();
            AppMethodBeat.m2505o(113530);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.k$7 */
    class C123997 implements OnTouchListener {

        /* renamed from: com.tencent.mm.plugin.location.ui.k$7$1 */
        class C33561 implements C30291a {
            C33561() {
            }

            /* renamed from: EA */
            public final void mo7762EA() {
                AppMethodBeat.m2504i(113536);
                C4990ab.m7416i("MicroMsg.TalkMgr", "play press sound end");
                AppMethodBeat.m2505o(113536);
            }
        }

        C123997() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(113537);
            switch (motionEvent.getAction()) {
                case 0:
                    C46054k.this.nNt = true;
                    C46054k.this.nNo.setVisibility(0);
                    C46054k.this.nNn.reset();
                    VolumeMeter volumeMeter = C46054k.this.nNn;
                    if (!volumeMeter.nOg) {
                        volumeMeter.fAA = true;
                        volumeMeter.bKh();
                    }
                    C46054k.this.nNm.setPressed(true);
                    if (C46054k.this.nNt) {
                        C35988ay.m59199a(C4996ah.getContext(), C25738R.string.ev4, new C33561());
                        C46054k.this.nNu = 1;
                        C4990ab.m7416i("MicroMsg.TalkMgr", "micBtn pressed down");
                        C46054k.this.nNw = C5046bo.m7588yz();
                        C46054k.this.nNA.akz();
                        C46054k.this.bKa();
                        break;
                    }
                    break;
                case 1:
                case 3:
                    C46054k.this.nNm.setPressed(false);
                    C46054k.this.nNo.setVisibility(8);
                    C46054k.this.nNn.reset();
                    C46054k.this.nNn.fAA = false;
                    if (C46054k.this.nNt) {
                        C46054k.this.nNt = false;
                        if (C46054k.this.nNu == 5) {
                            C4990ab.m7416i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                            C46054k.this.nNx.stopTimer();
                            C46054k.this.nNy.stopTimer();
                        }
                        C46054k.this.nNu = 0;
                        C46054k.this.nNC.stopTimer();
                        C46054k.this.nNA.akA();
                        C35988ay.m59201au(C4996ah.getContext(), C25738R.string.ev7);
                        C46054k.this.bKa();
                        if (C46054k.this.nNB != null) {
                            C46054k.this.nNB.bJW();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (C46054k.this.nNt) {
                    }
                    break;
            }
            AppMethodBeat.m2505o(113537);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.k$2 */
    class C344202 implements C5015a {
        C344202() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(113531);
            C4990ab.m7416i("MicroMsg.TalkMgr", "seizeMicTimer reach");
            C46054k.m85779a(C46054k.this);
            AppMethodBeat.m2505o(113531);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.k$3 */
    class C344213 implements C5015a {
        C344213() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(113532);
            C46054k.this.bKa();
            AppMethodBeat.m2505o(113532);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.k$5 */
    class C344225 implements C5015a {
        C344225() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            int akx;
            AppMethodBeat.m2504i(113534);
            if (C46054k.this.nNu == 3) {
                akx = C46054k.this.nNA.akx();
            } else if (C5046bo.isNullOrNil(C46054k.this.nNr)) {
                AppMethodBeat.m2505o(113534);
                return false;
            } else {
                akx = C46054k.this.nNA.aky();
            }
            C46054k c46054k = C46054k.this;
            float f = (float) akx;
            if (f < 10.0f) {
                f = 10.0f;
            }
            if (f > 100.0f) {
                f = 100.0f;
            }
            c46054k.nNn.setVolume(f / 100.0f);
            c46054k.nNn.invalidate();
            AppMethodBeat.m2505o(113534);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.k$a */
    public interface C34424a {
        /* renamed from: PY */
        void mo54929PY(String str);

        /* renamed from: PZ */
        void mo54930PZ(String str);

        void bJV();

        void bJW();

        void bJX();
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.k$4 */
    class C460534 implements C30291a {
        C460534() {
        }

        /* renamed from: EA */
        public final void mo7762EA() {
            AppMethodBeat.m2504i(113533);
            C46054k.this.nNy.stopTimer();
            C46054k.m85779a(C46054k.this);
            AppMethodBeat.m2505o(113533);
        }
    }

    public C46054k(Activity activity, Button button) {
        AppMethodBeat.m2504i(113538);
        this.activity = activity;
        this.nNm = button;
        this.nNo = (RelativeLayout) this.activity.findViewById(2131824678);
        this.nNo.setVisibility(8);
        this.nNn = (VolumeMeter) this.nNo.findViewById(2131824679);
        this.nNn.setArchView(this.nNm);
        VolumeMeter volumeMeter = this.nNn;
        if (volumeMeter.nOk == null) {
            C7305d.m12285a(new C211771(), "VolumeMeter_handler", 1).start();
        }
        this.nNA = C32337g.fUt;
        if (this.nNA == null) {
            C4990ab.m7412e("MicroMsg.TalkMgr", "cannot get talkroom server");
        }
        AppMethodBeat.m2505o(113538);
    }

    public final void bJY() {
        AppMethodBeat.m2504i(113539);
        this.nNs = this.activity.getIntent().getStringExtra("map_talker_name");
        this.nNA.mo4626a(this);
        C4990ab.m7411d("MicroMsg.TalkMgr", "talkRoomName %s ", this.nNs);
        final String str = this.nNs;
        this.nNq = str;
        if (!C5046bo.isNullOrNil(this.nNq)) {
            if (C1855t.m3896kH(str)) {
                List my = C37921n.m64074my(str);
                if (my == null) {
                    C26417a.flu.mo20967ai(str, "");
                } else {
                    this.cFX = my;
                }
            } else {
                this.cFX.clear();
                this.cFX.add(str);
                this.cFX.add(C1853r.m3846Yz());
            }
            new C7306ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(113535);
                    C46054k.this.nNA.mo4627ac(str, 1);
                    AppMethodBeat.m2505o(113535);
                }
            });
            this.nNm.setOnTouchListener(new C123997());
        }
        AppMethodBeat.m2505o(113539);
    }

    /* Access modifiers changed, original: final */
    public final void bJZ() {
        AppMethodBeat.m2504i(113540);
        if (this.nNu != 5) {
            AppMethodBeat.m2505o(113540);
            return;
        }
        this.nNx.stopTimer();
        bKa();
        C35988ay.m59199a(C4996ah.getContext(), C25738R.string.ev0, new C460534());
        this.nNy.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(113540);
    }

    /* Access modifiers changed, original: final */
    public final void bKa() {
        AppMethodBeat.m2504i(113541);
        if (this.nNp) {
            AppMethodBeat.m2505o(113541);
            return;
        }
        if (C32337g.fUt.akB()) {
            C4990ab.m7410d("MicroMsg.TalkMgr", "talkRoomServer pausing");
            if (this.nNB != null) {
                this.nNB.mo54929PY(null);
                this.nNB.bJW();
            }
        }
        switch (this.nNu) {
            case 0:
                C4990ab.m7411d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", this.nNr);
                if (this.nNB != null) {
                    if (C5046bo.isNullOrNil(this.nNr)) {
                        this.nNB.mo54929PY(null);
                        AppMethodBeat.m2505o(113541);
                        return;
                    }
                    this.nNB.mo54929PY(this.nNr);
                    AppMethodBeat.m2505o(113541);
                    return;
                }
                break;
            case 1:
                C4990ab.m7410d("MicroMsg.TalkMgr", "seize, state seizing");
                if (this.nNB != null) {
                    this.nNB.bJX();
                    AppMethodBeat.m2505o(113541);
                    return;
                }
                break;
            case 2:
                C4990ab.m7411d("MicroMsg.TalkMgr", "seize error, curUsername = %s", this.nNr);
                if (!(this.nNB == null || C5046bo.isNullOrNil(this.nNr))) {
                    this.nNB.mo54930PZ(this.nNr);
                    AppMethodBeat.m2505o(113541);
                    return;
                }
            case 3:
            case 5:
                C4990ab.m7410d("MicroMsg.TalkMgr", "seize, state success or prepare");
                if (this.nNB != null) {
                    this.nNB.bJV();
                    AppMethodBeat.m2505o(113541);
                    return;
                }
                break;
            case 4:
                C4990ab.m7410d("MicroMsg.TalkMgr", "seize time out");
                break;
        }
        AppMethodBeat.m2505o(113541);
    }

    public static void bKb() {
        AppMethodBeat.m2504i(113542);
        C42062sz c42062sz = new C42062sz();
        c42062sz.cPf.cPi = true;
        C4879a.xxA.mo10055m(c42062sz);
        C1407g.m2946KK().setMode(0);
        AppMethodBeat.m2505o(113542);
    }

    public final void akC() {
        AppMethodBeat.m2504i(113543);
        this.nNp = false;
        this.nNm.setEnabled(true);
        bKa();
        AppMethodBeat.m2505o(113543);
    }

    /* renamed from: l */
    public final void mo53061l(String str, int i, int i2) {
        AppMethodBeat.m2504i(113544);
        C4990ab.m7415f("MicroMsg.TalkMgr", "onInitFailed %s", str);
        C39287l.bJy().mo46328xC(3);
        this.activity.finish();
        AppMethodBeat.m2505o(113544);
    }

    public final void akD() {
        AppMethodBeat.m2504i(113545);
        if (this.nNu != 1) {
            AppMethodBeat.m2505o(113545);
            return;
        }
        this.nNu = 5;
        if (C5046bo.m7525az(this.nNw) < this.nNv) {
            C4990ab.m7416i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
            long az = this.nNv - C5046bo.m7525az(this.nNw);
            this.nNx.mo16770ae(az, az);
            AppMethodBeat.m2505o(113545);
            return;
        }
        bJZ();
        AppMethodBeat.m2505o(113545);
    }

    /* renamed from: mk */
    public final void mo53062mk(int i) {
        AppMethodBeat.m2504i(113546);
        C4990ab.m7416i("MicroMsg.TalkMgr", "onSeizeMicFailed");
        if (i == 340) {
            if (this.nNu != 3) {
                AppMethodBeat.m2505o(113546);
                return;
            }
            this.nNu = 4;
        } else if (this.nNu != 1) {
            AppMethodBeat.m2505o(113546);
            return;
        } else {
            this.nNu = 2;
        }
        bKa();
        C35988ay.m59200a(C4996ah.getContext(), null);
        AppMethodBeat.m2505o(113546);
    }

    /* renamed from: tO */
    public final void mo53063tO(String str) {
        AppMethodBeat.m2504i(113547);
        C4990ab.m7411d("MicroMsg.TalkMgr", "onCurMember change %s", str);
        this.nNr = str;
        bKa();
        if (C5046bo.isNullOrNil(str)) {
            this.nNC.stopTimer();
            AppMethodBeat.m2505o(113547);
            return;
        }
        C35988ay.m59201au(C4996ah.getContext(), C25738R.string.ev3);
        this.nNC.mo16770ae(100, 100);
        AppMethodBeat.m2505o(113547);
    }

    /* renamed from: aU */
    public final void mo53053aU(String str, String str2) {
        AppMethodBeat.m2504i(113548);
        C4990ab.m7417i("MicroMsg.TalkMgr", "add %s,  del %s", str, str2);
        if (this.nNp) {
            AppMethodBeat.m2505o(113548);
        } else {
            AppMethodBeat.m2505o(113548);
        }
    }

    /* renamed from: g */
    public final void mo53060g(int i, int i2, String str) {
    }

    public final void akE() {
    }

    public final void akF() {
        AppMethodBeat.m2504i(113549);
        bKa();
        AppMethodBeat.m2505o(113549);
    }

    public final void akG() {
        AppMethodBeat.m2504i(113550);
        bKa();
        AppMethodBeat.m2505o(113550);
    }

    public final void akH() {
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
    }

    /* renamed from: a */
    static /* synthetic */ void m85779a(C46054k c46054k) {
        AppMethodBeat.m2504i(113551);
        if (c46054k.nNu == 5) {
            c46054k.nNu = 3;
            c46054k.nNA.akw();
            c46054k.nNC.mo16770ae(100, 100);
        }
        AppMethodBeat.m2505o(113551);
    }
}
