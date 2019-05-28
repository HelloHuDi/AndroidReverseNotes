package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.d;

public final class i {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.i$2 */
    static class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ e uyH;
        final /* synthetic */ j uyM;

        AnonymousClass2(j jVar, e eVar) {
            this.uyM = jVar;
            this.uyH = eVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(8176);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8175);
                    if (AnonymousClass2.this.uyM.getParent() != null) {
                        ((ViewGroup) AnonymousClass2.this.uyM.getParent()).removeView(AnonymousClass2.this.uyM);
                    }
                    AppMethodBeat.o(8175);
                }
            });
            this.uyH.onAnimationEnd();
            AppMethodBeat.o(8176);
        }
    }

    public static void a(g gVar, Point point, e eVar) {
        AppMethodBeat.i(8177);
        a(gVar, point, -1.0f, eVar);
        AppMethodBeat.o(8177);
    }

    static void a(final g gVar, final Point point, final float f, final e eVar) {
        AppMethodBeat.i(8178);
        ay.au(ah.getContext(), R.string.gb1);
        gVar.a(new b() {
            public final void iH(boolean z) {
                AppMethodBeat.i(8174);
                if (z) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8173);
                            g gVar = gVar;
                            Point point = point;
                            float f = f;
                            e eVar = eVar;
                            ab.i("MicroMsg.TransformToBagAniHelper", "doMaskAnimation bogPos x:%d, y:%d lastSwipePosX:%f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f));
                            if (gVar.getContentView() == null) {
                                ab.w("MicroMsg.TransformToBagAniHelper", "doMaskAnimation getSwipeBackLayout null");
                                eVar.dbb();
                                AppMethodBeat.o(8173);
                                return;
                            }
                            ViewGroup bSl = gVar.bSl();
                            j jVar = new j(gVar.getActivity(), d.eA(gVar.getContentView()));
                            jVar.setLayoutParams(new LayoutParams(-1, -1));
                            int i = point.x;
                            int i2 = point.y + b.uyh;
                            int i3 = b.uyj / 2;
                            jVar.uyV = i;
                            jVar.uyW = i2;
                            jVar.uyU = i3;
                            jVar.setContentStartPosX((int) f);
                            jVar.setListener(new AnonymousClass2(jVar, eVar));
                            bSl.addView(jVar, bSl.getChildCount());
                            gVar.getContentView().setVisibility(8);
                            LinearInterpolator linearInterpolator = new LinearInterpolator();
                            jVar.uyY = jVar.uyX > 0;
                            int i4 = jVar.uyX < jVar.uyV ? jVar.uyX : jVar.uyV;
                            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("canvasTranslationX", new int[]{jVar.uyX, i4});
                            i4 = jVar.uyV;
                            if (jVar.uyY) {
                                if (jVar.uyX < jVar.uyV) {
                                    i4 = jVar.uyV - jVar.uyX;
                                } else {
                                    i4 = 0;
                                }
                            }
                            PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("translationX", new int[]{0, i4});
                            PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("translationY", new int[]{0, jVar.uyW});
                            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, (2.0f * ((float) jVar.uyU)) / ((float) jVar.mWidth)});
                            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, (2.0f * ((float) jVar.uyU)) / ((float) jVar.mHeight)});
                            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt2, ofInt3, ofFloat, ofFloat2, ofInt});
                            ofPropertyValuesHolder.setDuration(300);
                            ofPropertyValuesHolder.setInterpolator(linearInterpolator);
                            ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener() {
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    AppMethodBeat.i(8179);
                                    j.this.uyT = ((Integer) valueAnimator.getAnimatedValue("canvasTranslationX")).intValue();
                                    j.this.uyS.left = (float) ((Integer) valueAnimator.getAnimatedValue("translationX")).intValue();
                                    j.this.uyS.top = (float) ((Integer) valueAnimator.getAnimatedValue("translationY")).intValue();
                                    j.this.uyS.right = (((Float) valueAnimator.getAnimatedValue("scaleX")).floatValue() * ((float) j.this.mWidth)) + j.this.uyS.left;
                                    j.this.uyS.bottom = (((Float) valueAnimator.getAnimatedValue("scaleY")).floatValue() * ((float) j.this.mHeight)) + j.this.uyS.top;
                                    j.this.postInvalidate();
                                    AppMethodBeat.o(8179);
                                }
                            });
                            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                                public final void onAnimationEnd(Animator animator) {
                                    AppMethodBeat.i(8180);
                                    if (j.this.uyZ != null) {
                                        j.this.uyZ.onAnimationEnd(animator);
                                    }
                                    j.this.setVisibility(8);
                                    if (!(j.this.mMaskBitmap == null || j.this.mMaskBitmap.isRecycled())) {
                                        ab.i("MicroMsg.TransformToBagAniMask", "bitmap recycle %s", j.this.mMaskBitmap.toString());
                                        j.this.mMaskBitmap.recycle();
                                    }
                                    AppMethodBeat.o(8180);
                                }
                            });
                            ofPropertyValuesHolder.start();
                            AppMethodBeat.o(8173);
                        }
                    });
                    AppMethodBeat.o(8174);
                    return;
                }
                ab.i("MicroMsg.TransformToBagAniHelper", "convertToTranslucent not drawComplete");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(8172);
                        eVar.dbb();
                        AppMethodBeat.o(8172);
                    }
                });
                AppMethodBeat.o(8174);
            }
        });
        AppMethodBeat.o(8178);
    }
}
