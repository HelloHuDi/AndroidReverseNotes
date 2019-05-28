package com.tencent.p177mm.p612ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ui.tools.e */
public final class C30759e {
    private float aKw = 0.0f;
    private float aKx = 0.0f;
    private final Context context;
    private C7306ak mHandler = new C7306ak();
    int mHeight = 0;
    int mWidth = 0;
    /* renamed from: xJ */
    private int f13755xJ = 0;
    /* renamed from: xL */
    private int f13756xL = 0;
    int zES = 0;
    int zET = 0;
    private int zEU = 0;
    private int zEV = 0;
    float zEW = 0.0f;
    float zEX = 0.0f;
    private float zEY = 1.0f;
    public float zEZ = 1.0f;
    private int zFa = 0;
    int zFb = 0;
    float zFc = 1.0f;
    public int zFd = 0;
    int zFe = 0;
    int zFf = 0;
    int zFg = 0;
    int zFh = 0;
    private int zFi = 300;
    private int zFj = 10;
    int zFk = 0;
    int zFl = 1;
    int zFm = 2;
    int zFn = 3;
    int zFo = 4;
    int zFp = this.zFk;

    @TargetApi(18)
    /* renamed from: com.tencent.mm.ui.tools.e$a */
    public interface C24050a {
        /* renamed from: F */
        void mo39856F(int i, int i2, int i3, int i4);
    }

    /* renamed from: com.tencent.mm.ui.tools.e$b */
    public interface C24051b {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public C30759e(Context context) {
        AppMethodBeat.m2504i(107646);
        this.context = context;
        AppMethodBeat.m2505o(107646);
    }

    /* renamed from: L */
    public final void mo49164L(int i, int i2, int i3, int i4) {
        this.f13755xJ = i;
        this.f13756xL = i2;
        this.mWidth = i3;
        this.mHeight = i4;
    }

    /* renamed from: hw */
    public final void mo49168hw(int i, int i2) {
        this.zES = i;
        this.zET = i2;
    }

    /* renamed from: hx */
    public final void mo49169hx(int i, int i2) {
        this.zFe = i;
        this.zFf = i2;
        this.zFg = 0;
        this.zFh = 0;
    }

    /* renamed from: PJ */
    public final void mo49165PJ(int i) {
        this.zFi = i;
    }

    /* renamed from: hy */
    public final void mo49170hy(int i, int i2) {
        this.zFa = i;
        this.zFb = i2;
    }

    /* renamed from: E */
    private void m49088E(View view, boolean z) {
        int i;
        AppMethodBeat.m2504i(107647);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (this.f13755xJ == 0 && this.f13756xL == 0) {
            this.f13755xJ = view.getWidth() / 2;
            this.f13756xL = view.getHeight() / 2;
        }
        this.zEU = this.f13755xJ - iArr[0];
        this.zEV = this.f13756xL - iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            width = this.zES;
            height = this.zET;
            i = width;
        } else {
            i = width;
        }
        if (!(i == 0 || height == 0)) {
            this.aKw = ((float) this.mWidth) / ((float) i);
            this.aKx = ((float) this.mHeight) / ((float) height);
        }
        float f = this.zEY;
        if (!(this.zFe == 0 && this.zFf == 0 && this.zFg == 0 && this.zFh == 0)) {
            f = 1.1f;
        }
        if (z) {
            f = 1.0f;
            if (!(this.zES == 0 || this.zET == 0)) {
                this.aKw = ((float) this.mWidth) / ((float) this.zES);
                this.aKx = ((float) this.mHeight) / ((float) this.zET);
            }
        }
        if (((double) this.zEZ) != 1.0d) {
            this.zEU += iArr[0];
            this.zEV += iArr[1];
            this.zEW = this.aKw * this.zEZ;
            this.zEX = this.zEW;
            this.zEV = (int) (((float) this.zEV) - (((float) this.zFb) * this.zEW));
            this.zEU = (int) (((float) this.zEU) - (((float) this.zFa) * this.zEW));
            AppMethodBeat.m2505o(107647);
            return;
        }
        if (this.aKw > this.aKx) {
            this.zEW = this.aKw * f;
            this.zEV = (int) (((float) this.zEV) - (((((float) height) * this.zEW) - (((float) this.mHeight) * f)) / 2.0f));
        } else {
            this.zEW = this.aKx * f;
            this.zEU = (int) (((float) this.zEU) - (((((float) i) * this.zEW) - (((float) this.mWidth) * f)) / 2.0f));
            if (this.zET != 0 && this.zET < height) {
                this.zEV = (int) (((float) this.zEV) - (((((float) height) * this.zEW) - (((float) this.mHeight) * f)) / 2.0f));
            }
        }
        this.zEV = (int) ((((float) this.zEV) - ((((float) this.mHeight) * (f - 1.0f)) / 2.0f)) - ((((float) this.zFd) * this.zEW) / 2.0f));
        this.zEU = (int) (((float) this.zEU) - ((((float) this.mWidth) * (f - 1.0f)) / 2.0f));
        if (this.zET != 0 && this.f13756xL < (height - this.zET) / 2) {
            this.zEV = (int) ((((f - 1.0f) * ((float) this.mHeight)) / 2.0f) + ((float) this.zEV));
        } else if (this.zET != 0 && this.f13756xL + this.mHeight > (this.zET + height) / 2) {
            this.zEV = (int) (((float) this.zEV) - (((f - 1.0f) * ((float) this.mHeight)) / 2.0f));
        }
        if (this.mWidth == 0 && this.mHeight == 0) {
            this.zEW = 0.5f;
            this.zFc = 0.0f;
            this.zEU = (int) (((float) this.zEU) - ((((float) i) * this.zEW) / 2.0f));
            this.zEV = (int) ((((float) this.zEV) - ((((float) height) * this.zEW) / 2.0f)) - ((((float) this.zFd) * this.zEW) / 2.0f));
        }
        AppMethodBeat.m2505o(107647);
    }

    @TargetApi(16)
    /* renamed from: a */
    public final void mo49166a(final View view, View view2, final C24051b c24051b) {
        AppMethodBeat.m2504i(107648);
        if (VERSION.SDK_INT < 12 || view == null || this.zFp == this.zFm || this.zFp == this.zFo || this.zFp == this.zFn) {
            AppMethodBeat.m2505o(107648);
            return;
        }
        m49088E(view, false);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setScaleX(this.zEW);
        view.setScaleY(this.zEW);
        view.setTranslationX((float) this.zEU);
        view.setTranslationY((float) this.zEV);
        if (view2 != null) {
            view2.setAlpha(0.0f);
            view2.animate().setDuration((long) this.zFi).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(1.0f);
        }
        view.animate().setDuration((long) this.zFi).setInterpolator(new DecelerateInterpolator(1.2f)).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(107640);
                if (c24051b != null) {
                    c24051b.onAnimationStart();
                }
                C30759e.this.zFp = C30759e.this.zFm;
                AppMethodBeat.m2505o(107640);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(107641);
                if (c24051b != null) {
                    c24051b.onAnimationEnd();
                }
                C30759e.this.zFp = C30759e.this.zFn;
                AppMethodBeat.m2505o(107641);
            }

            public final void onAnimationCancel(Animator animator) {
                C30759e.this.zFp = C30759e.this.zFn;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(107642);
                if (C30759e.this.zFp == C30759e.this.zFk) {
                    C4990ab.m7416i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
                    view.requestLayout();
                }
                AppMethodBeat.m2505o(107642);
            }
        }, (long) this.zFj);
        AppMethodBeat.m2505o(107648);
    }

    @TargetApi(16)
    /* renamed from: a */
    public final void mo49167a(View view, View view2, final C24051b c24051b, C24050a c24050a) {
        AppMethodBeat.m2504i(107649);
        if (VERSION.SDK_INT < 12 || view == null || this.zFp == this.zFm || this.zFp == this.zFo || this.zFp == this.zFl) {
            C4990ab.m7417i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", Integer.valueOf(this.zFp), view);
            AppMethodBeat.m2505o(107649);
            return;
        }
        m49088E(view, true);
        if (view2 != null) {
            view2.animate().setDuration(200).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
        }
        AnimationSet animationSet = new AnimationSet(true);
        final View view3 = view;
        final C24050a c24050a2 = c24050a;
        C240483 c240483 = new ScaleAnimation(this.zEW, this.zEW) {
            /* Access modifiers changed, original: protected|final */
            public final void applyTransformation(float f, Transformation transformation) {
                AppMethodBeat.m2504i(107643);
                if (!(C30759e.this.zES == 0 || C30759e.this.zET == 0 || C30759e.this.zEZ != 1.0f)) {
                    Rect rect = new Rect();
                    view3.getGlobalVisibleRect(rect);
                    int i = (rect.right - rect.left) / 2;
                    int i2 = ((rect.bottom - rect.top) + C30759e.this.zFd) / 2;
                    int i3 = (int) (((((float) (C30759e.this.zES - C30759e.this.mWidth)) * (1.0f - f)) + ((float) C30759e.this.mWidth)) / (1.0f - ((1.0f - C30759e.this.zEW) * f)));
                    int i4 = (int) (((((float) (C30759e.this.zET - C30759e.this.mHeight)) * (1.0f - f)) + ((float) C30759e.this.mHeight)) / (1.0f - ((1.0f - C30759e.this.zEW) * f)));
                    if (C30759e.this.zEZ != 1.0f) {
                        C30759e.this.zEW = C30759e.this.zEX / C30759e.this.zEZ;
                        i4 = rect.right;
                        i4 = rect.left;
                        i = (rect.right + rect.left) / 2;
                        i2 = (C30759e.this.zFb - rect.top) + ((int) (((float) C30759e.this.zET) / 2.0f));
                        i3 = (int) (((((float) (C30759e.this.zES - C30759e.this.mWidth)) * (1.0f - f)) + ((float) C30759e.this.mWidth)) / (1.0f - ((1.0f - C30759e.this.zEW) * f)));
                        i4 = (int) (((((float) (C30759e.this.zET - C30759e.this.mHeight)) * (1.0f - f)) + ((float) C30759e.this.mHeight)) / (1.0f - ((1.0f - C30759e.this.zEW) * f)));
                    }
                    int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) C30759e.this.zFe) * f) / (1.0f - ((1.0f - C30759e.this.zEW) * f))));
                    int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) C30759e.this.zFd) * (1.0f - f)) / 2.0f)) + ((((float) C30759e.this.zFg) * f) / (1.0f - ((1.0f - C30759e.this.zEW) * f))));
                    i3 = (int) (((float) ((i3 / 2) + i)) - ((((float) C30759e.this.zFf) * f) / (1.0f - ((1.0f - C30759e.this.zEW) * f))));
                    i4 = (int) (((float) ((i4 / 2) + i2)) - ((((float) C30759e.this.zFh) * f) / (1.0f - ((1.0f - C30759e.this.zEW) * f))));
                    if (VERSION.SDK_INT >= 21) {
                        view3.setClipBounds(new Rect(i5, i6, i3, i4));
                    } else if (VERSION.SDK_INT >= 18) {
                        if (c24050a2 != null) {
                            c24050a2.mo39856F(i5, i6, i3, i4);
                        } else {
                            view3.setClipBounds(new Rect(i5 + view3.getScrollX(), i6, i3 + view3.getScrollX(), i4));
                        }
                    }
                }
                super.applyTransformation(f, transformation);
                AppMethodBeat.m2505o(107643);
            }
        };
        c240483.setDuration(200);
        c240483.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(c240483);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) this.zEU, 0.0f, (float) this.zEV);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, this.zFc);
        alphaAnimation.setDuration(200);
        alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(107644);
                C4990ab.m7416i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
                if (c24051b != null) {
                    c24051b.onAnimationStart();
                }
                C30759e.this.zFp = C30759e.this.zFo;
                AppMethodBeat.m2505o(107644);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(107645);
                C4990ab.m7416i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
                if (c24051b != null) {
                    c24051b.onAnimationEnd();
                }
                C30759e.this.zFp = C30759e.this.zFl;
                AppMethodBeat.m2505o(107645);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(animationSet);
        AppMethodBeat.m2505o(107649);
    }
}
