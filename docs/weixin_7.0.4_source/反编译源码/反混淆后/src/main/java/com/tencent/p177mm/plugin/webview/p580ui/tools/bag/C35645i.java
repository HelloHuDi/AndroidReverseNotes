package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22937j.C145902;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C22937j.C229381;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43945g.C43944b;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.i */
public final class C35645i {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.i$2 */
    static class C356432 extends AnimatorListenerAdapter {
        final /* synthetic */ C43942e uyH;
        final /* synthetic */ C22937j uyM;

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.i$2$1 */
        class C356441 implements Runnable {
            C356441() {
            }

            public final void run() {
                AppMethodBeat.m2504i(8175);
                if (C356432.this.uyM.getParent() != null) {
                    ((ViewGroup) C356432.this.uyM.getParent()).removeView(C356432.this.uyM);
                }
                AppMethodBeat.m2505o(8175);
            }
        }

        C356432(C22937j c22937j, C43942e c43942e) {
            this.uyM = c22937j;
            this.uyH = c43942e;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(8176);
            C5004al.m7441d(new C356441());
            this.uyH.onAnimationEnd();
            AppMethodBeat.m2505o(8176);
        }
    }

    /* renamed from: a */
    public static void m58497a(C43945g c43945g, Point point, C43942e c43942e) {
        AppMethodBeat.m2504i(8177);
        C35645i.m58496a(c43945g, point, -1.0f, c43942e);
        AppMethodBeat.m2505o(8177);
    }

    /* renamed from: a */
    static void m58496a(final C43945g c43945g, final Point point, final float f, final C43942e c43942e) {
        AppMethodBeat.m2504i(8178);
        C35988ay.m59201au(C4996ah.getContext(), C25738R.string.gb1);
        c43945g.mo38459a(new C43944b() {

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.i$1$1 */
            class C45901 implements Runnable {
                C45901() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(8172);
                    c43942e.dbb();
                    AppMethodBeat.m2505o(8172);
                }
            }

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.i$1$2 */
            class C356422 implements Runnable {
                C356422() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(8173);
                    C43945g c43945g = c43945g;
                    Point point = point;
                    float f = f;
                    C43942e c43942e = c43942e;
                    C4990ab.m7417i("MicroMsg.TransformToBagAniHelper", "doMaskAnimation bogPos x:%d, y:%d lastSwipePosX:%f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f));
                    if (c43945g.getContentView() == null) {
                        C4990ab.m7420w("MicroMsg.TransformToBagAniHelper", "doMaskAnimation getSwipeBackLayout null");
                        c43942e.dbb();
                        AppMethodBeat.m2505o(8173);
                        return;
                    }
                    ViewGroup bSl = c43945g.bSl();
                    C22937j c22937j = new C22937j(c43945g.getActivity(), C5056d.m7661eA(c43945g.getContentView()));
                    c22937j.setLayoutParams(new LayoutParams(-1, -1));
                    int i = point.x;
                    int i2 = point.y + C29876b.uyh;
                    int i3 = C29876b.uyj / 2;
                    c22937j.uyV = i;
                    c22937j.uyW = i2;
                    c22937j.uyU = i3;
                    c22937j.setContentStartPosX((int) f);
                    c22937j.setListener(new C356432(c22937j, c43942e));
                    bSl.addView(c22937j, bSl.getChildCount());
                    c43945g.getContentView().setVisibility(8);
                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                    c22937j.uyY = c22937j.uyX > 0;
                    int i4 = c22937j.uyX < c22937j.uyV ? c22937j.uyX : c22937j.uyV;
                    PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("canvasTranslationX", new int[]{c22937j.uyX, i4});
                    i4 = c22937j.uyV;
                    if (c22937j.uyY) {
                        if (c22937j.uyX < c22937j.uyV) {
                            i4 = c22937j.uyV - c22937j.uyX;
                        } else {
                            i4 = 0;
                        }
                    }
                    PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("translationX", new int[]{0, i4});
                    PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("translationY", new int[]{0, c22937j.uyW});
                    PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, (2.0f * ((float) c22937j.uyU)) / ((float) c22937j.mWidth)});
                    PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, (2.0f * ((float) c22937j.uyU)) / ((float) c22937j.mHeight)});
                    ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt2, ofInt3, ofFloat, ofFloat2, ofInt});
                    ofPropertyValuesHolder.setDuration(300);
                    ofPropertyValuesHolder.setInterpolator(linearInterpolator);
                    ofPropertyValuesHolder.addUpdateListener(new C229381());
                    ofPropertyValuesHolder.addListener(new C145902());
                    ofPropertyValuesHolder.start();
                    AppMethodBeat.m2505o(8173);
                }
            }

            /* renamed from: iH */
            public final void mo56357iH(boolean z) {
                AppMethodBeat.m2504i(8174);
                if (z) {
                    C5004al.m7441d(new C356422());
                    AppMethodBeat.m2505o(8174);
                    return;
                }
                C4990ab.m7416i("MicroMsg.TransformToBagAniHelper", "convertToTranslucent not drawComplete");
                C5004al.m7441d(new C45901());
                AppMethodBeat.m2505o(8174);
            }
        });
        AppMethodBeat.m2505o(8178);
    }
}
