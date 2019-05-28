package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43945g.C43946a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.d */
public final class C43940d {
    private static final int uyv = ((C29876b.uym / 2) * (C29876b.uym / 2));
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean uyA;
    private boolean uyB;
    private float uyC = 2.0f;
    private float uyD = 0.15f;
    private long uyE;
    private boolean uye;
    C43945g uyr;
    private C43943f uys;
    private float uyt;
    private int uyw = (C29876b.uyg - (C29876b.uym / 2));
    private int uyx = ((-C29876b.uym) / 2);
    private C29877a uyy;
    private LayoutParams uyz;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.d$a */
    static final class C29877a extends FrameLayout {
        ImageView iUn = ((ImageView) findViewById(2131820915));
        Vibrator iVt;
        private ImageView lBT = ((ImageView) findViewById(2131829163));
        C29878a uyG;

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.d$a$a */
        interface C29878a {
            void onChange(boolean z);
        }

        public C29877a(Context context) {
            super(context);
            AppMethodBeat.m2504i(8158);
            this.iVt = (Vibrator) context.getSystemService("vibrator");
            LayoutInflater.from(context).inflate(2130971211, this);
            AppMethodBeat.m2505o(8158);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.m2504i(8159);
            super.onConfigurationChanged(configuration);
            if (!(this.uyG == null || configuration == null)) {
                this.uyG.onChange(configuration.orientation == 2);
            }
            AppMethodBeat.m2505o(8159);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: af */
        public final void mo48102af(float f, float f2) {
            AppMethodBeat.m2504i(8160);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(50);
            this.lBT.startAnimation(scaleAnimation);
            AppMethodBeat.m2505o(8160);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.d$1 */
    class C439381 implements C43946a {
        C439381() {
        }

        /* renamed from: bg */
        public final void mo26833bg(float f) {
            AppMethodBeat.m2504i(8153);
            if (C43940d.this.uyE < 0) {
                C43940d.this.uyE = C5046bo.anU();
            }
            if (C43940d.m78852a(C43940d.this, f)) {
                if (!C43940d.this.uyA) {
                    C43940d.m78855c(C43940d.this);
                }
                if (!C43940d.this.uyB) {
                    float e = C43940d.this.uyC * f;
                    if (e > 1.0f) {
                        e = 1.0f;
                    }
                    if (C43940d.this.uye) {
                        C43940d.this.uyz.bottomMargin = (int) (((e * 0.5f) - 1.0f) * ((float) C29876b.uym));
                        C43940d.this.uyz.rightMargin = C43940d.this.uyz.bottomMargin + C29876b.uyg;
                    } else {
                        C43940d.this.uyz.rightMargin = (int) (((e * 0.5f) - 1.0f) * ((float) C29876b.uym));
                        C43940d.this.uyz.bottomMargin = C43940d.this.uyz.rightMargin + C29876b.uyg;
                    }
                    C43940d.this.uyy.setLayoutParams(C43940d.this.uyz);
                }
                C43940d.m78861i(C43940d.this);
                AppMethodBeat.m2505o(8153);
                return;
            }
            C43940d.m78862j(C43940d.this);
            AppMethodBeat.m2505o(8153);
        }

        /* renamed from: l */
        public final void mo26834l(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(8154);
            boolean d = C43940d.this.uyB;
            C43940d.m78850a(C43940d.this, motionEvent);
            if (C43940d.this.uyA && C43940d.this.uyB != d) {
                if (C43940d.this.uyB) {
                    C43940d.this.uyz.rightMargin = C43940d.this.uyx;
                    C43940d.this.uyz.bottomMargin = C43940d.this.uyw;
                    C43940d.this.uyy.setLayoutParams(C43940d.this.uyz);
                    C43940d.this.uyt = motionEvent.getRawX();
                }
                C29877a h = C43940d.this.uyy;
                C4990ab.m7419v("MicroMsg.BagIndicatorController.BagIndicator", "onHitChange %b", Boolean.valueOf(C43940d.this.uyB));
                if (C43940d.this.uyB) {
                    h.iUn.setImageResource(C1318a.webview_bag_indicator_icon_press);
                    h.mo48102af(1.0f, C29876b.uyn);
                    if (h.iVt != null) {
                        h.iVt.vibrate(10);
                    }
                    AppMethodBeat.m2505o(8154);
                    return;
                }
                h.iUn.setImageResource(C1318a.webview_bag_indicator_icon_normal);
                h.mo48102af(C29876b.uyn, 1.0f);
            }
            AppMethodBeat.m2505o(8154);
        }

        /* renamed from: ba */
        public final boolean mo26832ba(boolean z) {
            AppMethodBeat.m2504i(8155);
            C4990ab.m7417i("MicroMsg.BagIndicatorController", "onViewReleased willSwipeBack:%b %b", Boolean.valueOf(z), Boolean.valueOf(C43940d.this.uyB));
            C43940d.this.uyE = -1;
            if (!z) {
                C43940d.m78862j(C43940d.this);
                C43940d.this.uyB = false;
                AppMethodBeat.m2505o(8155);
                return false;
            } else if (C43940d.this.uyB) {
                C4990ab.m7418v("MicroMsg.BagIndicatorController", "onViewReleased showBag");
                C43940d.m78862j(C43940d.this);
                C43940d.this.uyB = false;
                C43940d.this.uys.mo69626d(C43940d.this.uyt, 14);
                AppMethodBeat.m2505o(8155);
                return true;
            } else {
                AppMethodBeat.m2505o(8155);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.d$2 */
    class C439392 implements Runnable {
        C439392() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8156);
            try {
                if (C43940d.this.uyy.getParent() != null) {
                    ((ViewGroup) C43940d.this.uyy.getParent()).removeView(C43940d.this.uyy);
                }
                AppMethodBeat.m2505o(8156);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BagIndicatorController", "removeIndicator exp:%s", e.getLocalizedMessage());
                AppMethodBeat.m2505o(8156);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.d$3 */
    class C439413 implements C29878a {
        C439413() {
        }

        public final void onChange(boolean z) {
            AppMethodBeat.m2504i(8157);
            C43940d.m78851a(C43940d.this, z);
            C43940d.this.uyz.bottomMargin = C43940d.this.uyw;
            C43940d.this.uyz.rightMargin = C43940d.this.uyx;
            C43940d.this.uyy.setLayoutParams(C43940d.this.uyz);
            AppMethodBeat.m2505o(8157);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m78855c(C43940d c43940d) {
        AppMethodBeat.m2504i(8167);
        c43940d.dba();
        AppMethodBeat.m2505o(8167);
    }

    /* renamed from: j */
    static /* synthetic */ void m78862j(C43940d c43940d) {
        AppMethodBeat.m2504i(8169);
        c43940d.daZ();
        AppMethodBeat.m2505o(8169);
    }

    public C43940d(C43945g c43945g, C43943f c43943f) {
        AppMethodBeat.m2504i(8161);
        this.uyr = c43945g;
        this.uys = c43943f;
        this.uyy = new C29877a(this.uyr.getActivity());
        this.uyy.uyG = new C439413();
        m78867nS(C1338a.m2868gd(C4996ah.getContext()) > C1338a.m2869ge(C4996ah.getContext()));
        this.uyz = new LayoutParams(-2, -2);
        this.uyz.gravity = 85;
        this.uyz.bottomMargin = this.uyw;
        this.uyz.rightMargin = this.uyx;
        this.uyy.setLayoutParams(this.uyz);
        AppMethodBeat.m2505o(8161);
    }

    public final void start() {
        AppMethodBeat.m2504i(8162);
        daZ();
        this.uyE = -1;
        if (this.uyr.cXe()) {
            this.uyr.mo38458a(new C439381());
            this.uyy.setVisibility(8);
            ViewGroup bSl = this.uyr.bSl();
            try {
                if (this.uyy.getParent() == null) {
                    int childCount = bSl.getChildCount();
                    for (int i = 0; i < bSl.getChildCount(); i++) {
                        if (bSl.getChildAt(i) instanceof SwipeBackLayout) {
                            childCount = i + 1;
                            C4990ab.m7417i("MicroMsg.BagIndicatorController", "start pos %d, count %d", Integer.valueOf(childCount), Integer.valueOf(bSl.getChildCount()));
                            break;
                        }
                    }
                    bSl.addView(this.uyy, childCount);
                    AppMethodBeat.m2505o(8162);
                    return;
                }
                C4990ab.m7416i("MicroMsg.BagIndicatorController", "start already added");
                AppMethodBeat.m2505o(8162);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BagIndicatorController", "start addView exp:%s", e.getLocalizedMessage());
                AppMethodBeat.m2505o(8162);
                return;
            }
        }
        AppMethodBeat.m2505o(8162);
    }

    private void daZ() {
        AppMethodBeat.m2504i(8163);
        if (this.uyA) {
            this.uyy.setVisibility(8);
            this.uyA = false;
            AppMethodBeat.m2505o(8163);
            return;
        }
        AppMethodBeat.m2505o(8163);
    }

    private void dba() {
        AppMethodBeat.m2504i(8164);
        if (this.uyr != null) {
            C29876b.m47353fs(this.uyr.getActivity());
        }
        if (this.uye) {
            this.uyw = (-C29876b.uym) / 2;
            this.uyx = C29876b.uyg - (C29876b.uym / 2);
            AppMethodBeat.m2505o(8164);
            return;
        }
        this.uyw = C29876b.uyg - (C29876b.uym / 2);
        this.uyx = (-C29876b.uym) / 2;
        AppMethodBeat.m2505o(8164);
    }

    /* renamed from: nS */
    private void m78867nS(boolean z) {
        AppMethodBeat.m2504i(8165);
        C4990ab.m7417i("MicroMsg.BagIndicatorController", "updateOrientation isLandscape:%b", Boolean.valueOf(z));
        this.uye = z;
        this.mScreenWidth = C1338a.m2868gd(C4996ah.getContext());
        this.mScreenHeight = C1338a.m2869ge(C4996ah.getContext());
        dba();
        this.uyC = 1.0f / ((((float) (this.mScreenWidth - (C29876b.uyl / 2))) / ((float) this.mScreenWidth)) - 0.2f);
        C4990ab.m7411d("MicroMsg.BagIndicatorController", "initIndicator mIndicatorScaleGainConstant:%f", Float.valueOf(this.uyC));
        AppMethodBeat.m2505o(8165);
    }

    /* renamed from: i */
    static /* synthetic */ void m78861i(C43940d c43940d) {
        AppMethodBeat.m2504i(8168);
        if (!c43940d.uyA) {
            c43940d.uyy.setVisibility(0);
            c43940d.uyA = true;
        }
        AppMethodBeat.m2505o(8168);
    }
}
