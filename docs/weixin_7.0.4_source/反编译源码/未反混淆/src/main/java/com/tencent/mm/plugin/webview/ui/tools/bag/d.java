package com.tencent.mm.plugin.webview.ui.tools.bag;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class d {
    private static final int uyv = ((b.uym / 2) * (b.uym / 2));
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean uyA;
    private boolean uyB;
    private float uyC = 2.0f;
    private float uyD = 0.15f;
    private long uyE;
    private boolean uye;
    g uyr;
    private f uys;
    private float uyt;
    private int uyw = (b.uyg - (b.uym / 2));
    private int uyx = ((-b.uym) / 2);
    private a uyy;
    private LayoutParams uyz;

    static final class a extends FrameLayout {
        ImageView iUn = ((ImageView) findViewById(R.id.jb));
        Vibrator iVt;
        private ImageView lBT = ((ImageView) findViewById(R.id.fjz));
        a uyG;

        interface a {
            void onChange(boolean z);
        }

        public a(Context context) {
            super(context);
            AppMethodBeat.i(8158);
            this.iVt = (Vibrator) context.getSystemService("vibrator");
            LayoutInflater.from(context).inflate(R.layout.b7a, this);
            AppMethodBeat.o(8158);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onConfigurationChanged(Configuration configuration) {
            AppMethodBeat.i(8159);
            super.onConfigurationChanged(configuration);
            if (!(this.uyG == null || configuration == null)) {
                this.uyG.onChange(configuration.orientation == 2);
            }
            AppMethodBeat.o(8159);
        }

        /* Access modifiers changed, original: final */
        public final void af(float f, float f2) {
            AppMethodBeat.i(8160);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(50);
            this.lBT.startAnimation(scaleAnimation);
            AppMethodBeat.o(8160);
        }
    }

    static /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(8167);
        dVar.dba();
        AppMethodBeat.o(8167);
    }

    static /* synthetic */ void j(d dVar) {
        AppMethodBeat.i(8169);
        dVar.daZ();
        AppMethodBeat.o(8169);
    }

    public d(g gVar, f fVar) {
        AppMethodBeat.i(8161);
        this.uyr = gVar;
        this.uys = fVar;
        this.uyy = new a(this.uyr.getActivity());
        this.uyy.uyG = new a() {
            public final void onChange(boolean z) {
                AppMethodBeat.i(8157);
                d.a(d.this, z);
                d.this.uyz.bottomMargin = d.this.uyw;
                d.this.uyz.rightMargin = d.this.uyx;
                d.this.uyy.setLayoutParams(d.this.uyz);
                AppMethodBeat.o(8157);
            }
        };
        nS(com.tencent.mm.bz.a.gd(ah.getContext()) > com.tencent.mm.bz.a.ge(ah.getContext()));
        this.uyz = new LayoutParams(-2, -2);
        this.uyz.gravity = 85;
        this.uyz.bottomMargin = this.uyw;
        this.uyz.rightMargin = this.uyx;
        this.uyy.setLayoutParams(this.uyz);
        AppMethodBeat.o(8161);
    }

    public final void start() {
        AppMethodBeat.i(8162);
        daZ();
        this.uyE = -1;
        if (this.uyr.cXe()) {
            this.uyr.a(new com.tencent.mm.plugin.webview.ui.tools.bag.g.a() {
                public final void bg(float f) {
                    AppMethodBeat.i(8153);
                    if (d.this.uyE < 0) {
                        d.this.uyE = bo.anU();
                    }
                    if (d.a(d.this, f)) {
                        if (!d.this.uyA) {
                            d.c(d.this);
                        }
                        if (!d.this.uyB) {
                            float e = d.this.uyC * f;
                            if (e > 1.0f) {
                                e = 1.0f;
                            }
                            if (d.this.uye) {
                                d.this.uyz.bottomMargin = (int) (((e * 0.5f) - 1.0f) * ((float) b.uym));
                                d.this.uyz.rightMargin = d.this.uyz.bottomMargin + b.uyg;
                            } else {
                                d.this.uyz.rightMargin = (int) (((e * 0.5f) - 1.0f) * ((float) b.uym));
                                d.this.uyz.bottomMargin = d.this.uyz.rightMargin + b.uyg;
                            }
                            d.this.uyy.setLayoutParams(d.this.uyz);
                        }
                        d.i(d.this);
                        AppMethodBeat.o(8153);
                        return;
                    }
                    d.j(d.this);
                    AppMethodBeat.o(8153);
                }

                public final void l(MotionEvent motionEvent) {
                    AppMethodBeat.i(8154);
                    boolean d = d.this.uyB;
                    d.a(d.this, motionEvent);
                    if (d.this.uyA && d.this.uyB != d) {
                        if (d.this.uyB) {
                            d.this.uyz.rightMargin = d.this.uyx;
                            d.this.uyz.bottomMargin = d.this.uyw;
                            d.this.uyy.setLayoutParams(d.this.uyz);
                            d.this.uyt = motionEvent.getRawX();
                        }
                        a h = d.this.uyy;
                        ab.v("MicroMsg.BagIndicatorController.BagIndicator", "onHitChange %b", Boolean.valueOf(d.this.uyB));
                        if (d.this.uyB) {
                            h.iUn.setImageResource(R.raw.webview_bag_indicator_icon_press);
                            h.af(1.0f, b.uyn);
                            if (h.iVt != null) {
                                h.iVt.vibrate(10);
                            }
                            AppMethodBeat.o(8154);
                            return;
                        }
                        h.iUn.setImageResource(R.raw.webview_bag_indicator_icon_normal);
                        h.af(b.uyn, 1.0f);
                    }
                    AppMethodBeat.o(8154);
                }

                public final boolean ba(boolean z) {
                    AppMethodBeat.i(8155);
                    ab.i("MicroMsg.BagIndicatorController", "onViewReleased willSwipeBack:%b %b", Boolean.valueOf(z), Boolean.valueOf(d.this.uyB));
                    d.this.uyE = -1;
                    if (!z) {
                        d.j(d.this);
                        d.this.uyB = false;
                        AppMethodBeat.o(8155);
                        return false;
                    } else if (d.this.uyB) {
                        ab.v("MicroMsg.BagIndicatorController", "onViewReleased showBag");
                        d.j(d.this);
                        d.this.uyB = false;
                        d.this.uys.d(d.this.uyt, 14);
                        AppMethodBeat.o(8155);
                        return true;
                    } else {
                        AppMethodBeat.o(8155);
                        return false;
                    }
                }
            });
            this.uyy.setVisibility(8);
            ViewGroup bSl = this.uyr.bSl();
            try {
                if (this.uyy.getParent() == null) {
                    int childCount = bSl.getChildCount();
                    for (int i = 0; i < bSl.getChildCount(); i++) {
                        if (bSl.getChildAt(i) instanceof SwipeBackLayout) {
                            childCount = i + 1;
                            ab.i("MicroMsg.BagIndicatorController", "start pos %d, count %d", Integer.valueOf(childCount), Integer.valueOf(bSl.getChildCount()));
                            break;
                        }
                    }
                    bSl.addView(this.uyy, childCount);
                    AppMethodBeat.o(8162);
                    return;
                }
                ab.i("MicroMsg.BagIndicatorController", "start already added");
                AppMethodBeat.o(8162);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.BagIndicatorController", "start addView exp:%s", e.getLocalizedMessage());
                AppMethodBeat.o(8162);
                return;
            }
        }
        AppMethodBeat.o(8162);
    }

    private void daZ() {
        AppMethodBeat.i(8163);
        if (this.uyA) {
            this.uyy.setVisibility(8);
            this.uyA = false;
            AppMethodBeat.o(8163);
            return;
        }
        AppMethodBeat.o(8163);
    }

    private void dba() {
        AppMethodBeat.i(8164);
        if (this.uyr != null) {
            b.fs(this.uyr.getActivity());
        }
        if (this.uye) {
            this.uyw = (-b.uym) / 2;
            this.uyx = b.uyg - (b.uym / 2);
            AppMethodBeat.o(8164);
            return;
        }
        this.uyw = b.uyg - (b.uym / 2);
        this.uyx = (-b.uym) / 2;
        AppMethodBeat.o(8164);
    }

    private void nS(boolean z) {
        AppMethodBeat.i(8165);
        ab.i("MicroMsg.BagIndicatorController", "updateOrientation isLandscape:%b", Boolean.valueOf(z));
        this.uye = z;
        this.mScreenWidth = com.tencent.mm.bz.a.gd(ah.getContext());
        this.mScreenHeight = com.tencent.mm.bz.a.ge(ah.getContext());
        dba();
        this.uyC = 1.0f / ((((float) (this.mScreenWidth - (b.uyl / 2))) / ((float) this.mScreenWidth)) - 0.2f);
        ab.d("MicroMsg.BagIndicatorController", "initIndicator mIndicatorScaleGainConstant:%f", Float.valueOf(this.uyC));
        AppMethodBeat.o(8165);
    }

    static /* synthetic */ void i(d dVar) {
        AppMethodBeat.i(8168);
        if (!dVar.uyA) {
            dVar.uyy.setVisibility(0);
            dVar.uyA = true;
        }
        AppMethodBeat.o(8168);
    }
}
