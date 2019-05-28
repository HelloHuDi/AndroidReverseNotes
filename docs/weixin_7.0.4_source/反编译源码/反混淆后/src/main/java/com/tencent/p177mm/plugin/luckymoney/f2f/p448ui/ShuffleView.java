package com.tencent.p177mm.plugin.luckymoney.f2f.p448ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView */
public class ShuffleView extends FrameLayout {
    public static DisplayMetrics ghw;
    /* renamed from: eX */
    private float f17205eX;
    /* renamed from: eY */
    private float f17206eY;
    View gCO;
    GestureDetector lCs = new GestureDetector(new C4325414());
    ValueAnimator lgH;
    List<View> nVP = new ArrayList();
    private C3380c nVQ = new C3380c();
    ValueAnimator nVR;
    private ValueAnimator nVS;
    ValueAnimator nVT;
    private C34438a nVU;
    private C34438a nVV;
    private C34439b nVW;
    View nVX;
    private View nVY;
    int nVZ;
    private View nWa;
    private int nWb;
    int nWc;
    private final float nWd = 0.23f;
    private final float nWe = 0.28f;
    private final float nWf = 0.33f;
    private ArrayList<Float> nWg = new ArrayList();
    private ArrayList<Float> nWh = new ArrayList();
    private boolean nWi;
    private int nWj = getResources().getDimensionPixelSize(C25738R.dimen.a4e);
    private int nWk = 2500;

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$10 */
    class C337510 implements AnimatorUpdateListener {
        C337510() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = 0;
            AppMethodBeat.m2504i(42235);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue == 0.0f) {
                ShuffleView.this.nWg.clear();
                ShuffleView.this.nWh.clear();
                while (i < ShuffleView.this.nWc) {
                    ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                    ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                    i++;
                }
                AppMethodBeat.m2505o(42235);
                return;
            }
            ShuffleView.this.gCO.setTranslationY((((Float) ShuffleView.this.nWh.get(0)).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.this.gCO.getHeight()) * floatValue) / 7.0f));
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 < ShuffleView.this.nWc) {
                    ((View) ShuffleView.this.nVP.get(i3)).setTranslationX((((Float) ShuffleView.this.nWg.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68786xM(i3) * floatValue));
                    ((View) ShuffleView.this.nVP.get(i3)).setTranslationY((((Float) ShuffleView.this.nWh.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(i3) * floatValue));
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.m2505o(42235);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$7 */
    class C33777 implements AnimatorUpdateListener {
        C33777() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(42232);
            if (ShuffleView.this.nVV != null) {
                ShuffleView.this.nVV.mo24271a(valueAnimator, ShuffleView.this.nVY);
            }
            AppMethodBeat.m2505o(42232);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$8 */
    class C33788 implements AnimatorUpdateListener {
        C33788() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = 0;
            AppMethodBeat.m2504i(42233);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue == 0.0f) {
                ShuffleView.this.nWg.clear();
                ShuffleView.this.nWh.clear();
                while (i < ShuffleView.this.nWc) {
                    ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                    ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                    i++;
                }
                AppMethodBeat.m2505o(42233);
                return;
            }
            while (true) {
                int i2 = i;
                if (i2 < ShuffleView.this.nWc) {
                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68786xM(i2) * floatValue));
                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(i2) * floatValue));
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(42233);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$c */
    static class C3380c {
        public int nWp = 1;
        public int nWq = 1;
        public int nWr = 2;
        public int nWs = 200;
        public int nWt = 80;
        public float scaleX = 0.01f;
        public float scaleY = 0.01f;

        C3380c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$11 */
    class C1242211 implements AnimatorUpdateListener {
        C1242211() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = 0;
            AppMethodBeat.m2504i(42236);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue == 0.0f) {
                ShuffleView.this.nWg.clear();
                ShuffleView.this.nWh.clear();
                while (i < ShuffleView.this.nWc) {
                    ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                    ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                    i++;
                }
                AppMethodBeat.m2505o(42236);
                return;
            }
            while (true) {
                int i2 = i;
                if (i2 < ShuffleView.this.nWc) {
                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68786xM(i2) * floatValue));
                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(i2) * floatValue));
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(42236);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$13 */
    class C1242313 implements AnimatorUpdateListener {
        C1242313() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(42238);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue == 0.0f) {
                ShuffleView.this.nWg.clear();
                ShuffleView.this.nWh.clear();
                for (int i = 0; i < ShuffleView.this.nWc; i++) {
                    ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                    ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                }
                AppMethodBeat.m2505o(42238);
                return;
            }
            ((View) ShuffleView.this.nVP.get(0)).setTranslationX((((Float) ShuffleView.this.nWg.get(0)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68786xM(0) * floatValue));
            ((View) ShuffleView.this.nVP.get(0)).setTranslationY((((Float) ShuffleView.this.nWh.get(0)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(0) * floatValue));
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 < ShuffleView.this.nWc) {
                    ((View) ShuffleView.this.nVP.get(i3)).setTranslationX((((Float) ShuffleView.this.nWg.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68786xM(i3) * floatValue));
                    ((View) ShuffleView.this.nVP.get(i3)).setTranslationY((((Float) ShuffleView.this.nWh.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(i3) * floatValue));
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.m2505o(42238);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$1 */
    class C211971 implements OnLayoutChangeListener {
        C211971() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppMethodBeat.m2504i(42224);
            ShuffleView.m76950a(ShuffleView.this);
            ShuffleView shuffleView = ShuffleView.this;
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 < shuffleView.nWc) {
                    shuffleView.mo68774W((View) shuffleView.nVP.get(i10), i10);
                    i9 = i10 + 1;
                } else {
                    ShuffleView.this.removeOnLayoutChangeListener(this);
                    AppMethodBeat.m2505o(42224);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$2 */
    class C284222 implements AnimatorListener {
        C284222() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(42225);
            ShuffleView.this.nWi = true;
            AppMethodBeat.m2505o(42225);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(42226);
            ShuffleView.this.nWi = false;
            ShuffleView.this.nWa = null;
            ShuffleView.this.nWb = -1;
            AppMethodBeat.m2505o(42226);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$4 */
    class C344364 implements AnimatorListener {
        C344364() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(42228);
            ShuffleView.this.nWi = true;
            AppMethodBeat.m2505o(42228);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(42229);
            ShuffleView.this.nWi = false;
            ShuffleView.this.nVY.setVisibility(0);
            if (ShuffleView.this.nVS != null) {
                ShuffleView.this.nVS.start();
            }
            AppMethodBeat.m2505o(42229);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$5 */
    class C344375 implements AnimatorListener {
        C344375() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(42230);
            ShuffleView.this.nVP.remove(ShuffleView.this.nVX);
            if (ShuffleView.this.nVR != null) {
                ShuffleView.this.nVR.start();
            }
            ShuffleView.m76962f(ShuffleView.this, ShuffleView.this.nVZ);
            if (ShuffleView.this.nWc > 0) {
                ShuffleView.this.nVZ = ShuffleView.m76982y(ShuffleView.this);
                ShuffleView.this.gCO = (View) ShuffleView.this.nVP.get(ShuffleView.this.nVZ);
                AppMethodBeat.m2505o(42230);
                return;
            }
            ShuffleView.this.gCO = null;
            ShuffleView.this.nVZ = 0;
            AppMethodBeat.m2505o(42230);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$a */
    interface C34438a {
        /* renamed from: a */
        void mo24271a(ValueAnimator valueAnimator, View view);
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$b */
    interface C34439b {
        /* renamed from: er */
        void mo24272er(int i, int i2);

        /* renamed from: es */
        void mo24273es(int i, int i2);

        /* renamed from: xL */
        void mo24274xL(int i);
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$15 */
    class C3931415 implements AnimatorUpdateListener {
        C3931415() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = 0;
            AppMethodBeat.m2504i(42243);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue == 0.0f) {
                ShuffleView.this.nWg.clear();
                ShuffleView.this.nWh.clear();
                while (i < ShuffleView.this.nWc) {
                    ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                    ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                    i++;
                }
                AppMethodBeat.m2505o(42243);
                return;
            }
            while (true) {
                int i2 = i;
                if (i2 < ShuffleView.this.nWc) {
                    View view = (View) ShuffleView.this.nVP.get(i2);
                    if (ShuffleView.this.nVQ.nWp == 1) {
                        view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.nVQ.scaleX) + (1.0f - (ShuffleView.this.nVQ.scaleX * ((float) (i2 + 1)))));
                        view.setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * ShuffleView.this.mo68787xN(i2)));
                    } else if (ShuffleView.this.nVQ.nWp == 2) {
                        view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.nVQ.scaleY) + (1.0f - (ShuffleView.this.nVQ.scaleY * ((float) (i2 + 1)))));
                        view.setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * ShuffleView.this.mo68786xM(i2)));
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(42243);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$6 */
    class C393166 implements AnimatorUpdateListener {
        C393166() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(42231);
            if (ShuffleView.this.nVU != null) {
                ShuffleView.this.nVU.mo24271a(valueAnimator, ShuffleView.this.nVX);
            }
            AppMethodBeat.m2505o(42231);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView$14 */
    class C4325414 implements OnGestureListener {
        C4325414() {
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(42239);
            C4990ab.m7410d("ShuffleView", "gesture down");
            switch (ShuffleView.this.nVQ.nWq) {
                case 4:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int i = 0;
                    while (i < ShuffleView.this.nWc) {
                        Rect a = ShuffleView.m76948a(ShuffleView.this, i);
                        if (a == null || !a.contains(x, y)) {
                            i++;
                        } else {
                            View view = (View) ShuffleView.this.nVP.get(i);
                            if (ShuffleView.this.gCO != view && ShuffleView.this.gCO != null) {
                                ShuffleView.m76969m(ShuffleView.this);
                            } else if (ShuffleView.this.gCO == view) {
                                C4990ab.m7416i("ShuffleView", "down on the select card");
                                AppMethodBeat.m2505o(42239);
                                return true;
                            }
                            ShuffleView.m76954b(ShuffleView.this, i);
                            AppMethodBeat.m2505o(42239);
                            return true;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(42239);
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(42240);
            switch (ShuffleView.this.nVQ.nWq) {
                case 4:
                    if (ShuffleView.this.gCO != null) {
                        C4990ab.m7410d("ShuffleView", "click the select card");
                        if (ShuffleView.this.nVW != null) {
                            ShuffleView.this.nVW.mo24273es(ShuffleView.this.nVZ, ShuffleView.this.nWc);
                        }
                        ShuffleView.m76969m(ShuffleView.this);
                    }
                    if (ShuffleView.this.nWa != null) {
                        if (ShuffleView.this.nVW != null) {
                            C34439b n = ShuffleView.this.nVW;
                            ShuffleView.this.nWb;
                            n.mo24274xL(ShuffleView.this.nWc);
                        }
                        ShuffleView.m76956c(ShuffleView.this, ShuffleView.this.nWb);
                    }
                    AppMethodBeat.m2505o(42240);
                    return true;
                default:
                    AppMethodBeat.m2505o(42240);
                    return false;
            }
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(42241);
            if (motionEvent2.getActionMasked() == 2) {
                int x = (int) motionEvent2.getX();
                int y = (int) motionEvent2.getY();
                switch (ShuffleView.this.nVQ.nWq) {
                    case 4:
                        View view;
                        if (Math.abs(f2) < ((float) ShuffleView.this.nWj)) {
                            for (int i = 0; i < ShuffleView.this.nWc; i++) {
                                Rect a = ShuffleView.m76948a(ShuffleView.this, i);
                                if (a != null && a.contains(x, y)) {
                                    view = (View) ShuffleView.this.nVP.get(i);
                                    if (ShuffleView.this.gCO != view && ShuffleView.this.gCO != null) {
                                        ShuffleView.m76969m(ShuffleView.this);
                                    } else if (ShuffleView.this.gCO == view) {
                                        C4990ab.m7416i("ShuffleView", "scroll on the select card");
                                    }
                                    if (ShuffleView.this.nWa != view) {
                                        ShuffleView.m76972p(ShuffleView.this);
                                        ShuffleView.m76954b(ShuffleView.this, i);
                                    }
                                }
                            }
                        }
                        if (Math.abs(f) < ((float) ShuffleView.this.nWj)) {
                            C4990ab.m7410d("ShuffleView", "scroll distanceY:".concat(String.valueOf(f2)));
                            if (ShuffleView.this.nWa != null) {
                                view = ShuffleView.this.nWa;
                            } else if (ShuffleView.this.gCO != null) {
                                view = ShuffleView.this.gCO;
                            } else {
                                view = null;
                            }
                            if (view != null) {
                                C4990ab.m7416i("ShuffleView", "scroll translationY:" + view.getTranslationY() + "," + (view.getHeight() / 7));
                                if (((int) view.getTranslationY()) <= (-view.getHeight()) / 7) {
                                    if (f2 < 0.0f && Math.abs(f2) > ((float) ShuffleView.this.nWj)) {
                                        if (((int) f2) <= (-view.getHeight()) / 7) {
                                            view.setTranslationY(0.0f);
                                        } else {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                        }
                                        if (view == ShuffleView.this.gCO) {
                                            ShuffleView.this.nWa = ShuffleView.this.gCO;
                                            ShuffleView.this.nWb = ShuffleView.this.nVZ;
                                            if (ShuffleView.this.nVT.isStarted()) {
                                                C4990ab.m7416i("ShuffleView", "scroll when select view is animation");
                                                ShuffleView.this.nVT.cancel();
                                            }
                                            ShuffleView.this.gCO = null;
                                            ShuffleView.this.nVZ = 0;
                                        }
                                    }
                                } else if (view.getTranslationY() == 0.0f) {
                                    if (f2 > 0.0f && Math.abs(f2) > ((float) ShuffleView.this.nWj)) {
                                        if (((int) f2) >= view.getHeight() / 7) {
                                            view.setTranslationY((float) ((-view.getHeight()) / 7));
                                        } else {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                        }
                                    }
                                } else if (f2 < 0.0f) {
                                    if (view.getTranslationY() - f2 >= 0.0f) {
                                        view.setTranslationY(0.0f);
                                    } else {
                                        view.setTranslationY(view.getTranslationY() - f2);
                                    }
                                } else if (((int) (view.getTranslationY() - f2)) <= (-view.getHeight()) / 7) {
                                    view.setTranslationY((float) ((-view.getHeight()) / 7));
                                } else {
                                    view.setTranslationY(view.getTranslationY() - f2);
                                }
                            }
                            AppMethodBeat.m2505o(42241);
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(42241);
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(42242);
            C4990ab.m7416i("ShuffleView", "fling up ".concat(String.valueOf(f2)));
            if (f2 < ((float) (-ShuffleView.this.nWk))) {
                switch (ShuffleView.this.nVQ.nWq) {
                    case 4:
                        if (ShuffleView.this.gCO != null) {
                            ShuffleView.m76969m(ShuffleView.this);
                        }
                        if (ShuffleView.this.nWa != null) {
                            if (ShuffleView.this.nVW != null) {
                                C34439b n = ShuffleView.this.nVW;
                                ShuffleView.this.nWb;
                                n.mo24274xL(ShuffleView.this.nWc);
                            }
                            ShuffleView.m76956c(ShuffleView.this, ShuffleView.this.nWb);
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(42242);
                return true;
            }
            AppMethodBeat.m2505o(42242);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m76950a(ShuffleView shuffleView) {
        AppMethodBeat.m2504i(42260);
        shuffleView.bLl();
        AppMethodBeat.m2505o(42260);
    }

    /* renamed from: c */
    static /* synthetic */ void m76956c(ShuffleView shuffleView, int i) {
        AppMethodBeat.m2504i(42266);
        shuffleView.mo68788xO(i);
        AppMethodBeat.m2505o(42266);
    }

    /* renamed from: f */
    static /* synthetic */ void m76962f(ShuffleView shuffleView, int i) {
        AppMethodBeat.m2504i(42268);
        shuffleView.mo68789xQ(i);
        AppMethodBeat.m2505o(42268);
    }

    /* renamed from: g */
    static /* synthetic */ float m76963g(ShuffleView shuffleView) {
        AppMethodBeat.m2504i(42261);
        float selectScaleTranslationX = shuffleView.getSelectScaleTranslationX();
        AppMethodBeat.m2505o(42261);
        return selectScaleTranslationX;
    }

    /* renamed from: j */
    static /* synthetic */ float m76966j(ShuffleView shuffleView) {
        AppMethodBeat.m2504i(42262);
        float touchScaleTranslationX = shuffleView.getTouchScaleTranslationX();
        AppMethodBeat.m2505o(42262);
        return touchScaleTranslationX;
    }

    /* renamed from: m */
    static /* synthetic */ void m76969m(ShuffleView shuffleView) {
        AppMethodBeat.m2504i(42264);
        shuffleView.bLn();
        AppMethodBeat.m2505o(42264);
    }

    /* renamed from: p */
    static /* synthetic */ void m76972p(ShuffleView shuffleView) {
        AppMethodBeat.m2504i(42267);
        shuffleView.bLo();
        AppMethodBeat.m2505o(42267);
    }

    /* renamed from: y */
    static /* synthetic */ int m76982y(ShuffleView shuffleView) {
        AppMethodBeat.m2504i(42269);
        int bLm = shuffleView.bLm();
        AppMethodBeat.m2505o(42269);
        return bLm;
    }

    public ShuffleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(42244);
        AppMethodBeat.m2505o(42244);
    }

    public void setShuffleSetting(C3380c c3380c) {
        AppMethodBeat.m2504i(42245);
        this.nVQ = c3380c;
        this.lgH = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) c3380c.nWs);
        this.nVT = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) c3380c.nWt);
        AppMethodBeat.m2505o(42245);
    }

    public void setAllShuffleCards(List<View> list) {
        AppMethodBeat.m2504i(42246);
        this.nVP.clear();
        this.nVP.addAll(list);
        this.nVZ = 0;
        this.gCO = null;
        this.nWb = -1;
        this.nWa = null;
        removeAllViews();
        List list2 = this.nVP;
        if (list2.size() > 100) {
            this.nWc = 100;
        } else {
            this.nWc = list2.size();
            if (this.nWc == 1) {
                ((View) list2.get(0)).findViewById(2131825501).setVisibility(0);
            }
        }
        for (int i = this.nWc - 1; i >= 0; i--) {
            addView((View) list2.get(i));
        }
        addOnLayoutChangeListener(new C211971());
        AppMethodBeat.m2505o(42246);
    }

    private void bLl() {
        AppMethodBeat.m2504i(42247);
        if (this.nWc > 1) {
            C4990ab.m7411d("ShuffleView", "card width: %d,height: %d", Integer.valueOf(((View) this.nVP.get(0)).getWidth()), Integer.valueOf(((View) this.nVP.get(0)).getHeight()));
            if (this.nVQ.nWp == 2) {
                this.f17205eX = (((float) ((View) this.nVP.get(0)).getWidth()) * 1.5f) / ((float) this.nWc);
                if (this.f17205eX > ((float) ((View) this.nVP.get(0)).getWidth()) * 0.23f) {
                    this.f17205eX = ((float) ((View) this.nVP.get(0)).getWidth()) * 0.23f;
                    AppMethodBeat.m2505o(42247);
                    return;
                }
            } else if (this.nVQ.nWp == 1) {
                this.f17206eY = (((float) ((View) this.nVP.get(0)).getHeight()) * 1.0f) / ((float) this.nWc);
                AppMethodBeat.m2505o(42247);
                return;
            }
        }
        this.f17205eX = 0.0f;
        this.f17206eY = 0.0f;
        AppMethodBeat.m2505o(42247);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: W */
    public final void mo68774W(View view, int i) {
        AppMethodBeat.m2504i(42248);
        if (this.nVQ.nWp == 1) {
            view.setScaleX(1.0f - (this.nVQ.scaleX * ((float) i)));
            view.setTranslationY(mo68787xN(i));
            AppMethodBeat.m2505o(42248);
            return;
        }
        if (this.nVQ.nWp == 2) {
            view.setScaleY(1.0f - (this.nVQ.scaleY * ((float) i)));
            view.setTranslationX(mo68786xM(i));
        }
        AppMethodBeat.m2505o(42248);
    }

    /* renamed from: xM */
    public final float mo68786xM(int i) {
        if (this.nVQ.nWp == 2 && this.nWc > 0) {
            if (this.nVQ.nWq == 3) {
                return ((((float) (this.nWc - 1)) * 0.5f) * this.f17205eX) - (this.f17205eX * ((float) i));
            }
            if (this.nVQ.nWq == 4) {
                return (this.f17205eX * ((float) i)) - ((((float) (this.nWc - 1)) * 0.5f) * this.f17205eX);
            }
        }
        return 0.0f;
    }

    /* renamed from: xN */
    public final float mo68787xN(int i) {
        if (this.nVQ.nWp == 1) {
            if (this.nVQ.nWq == 1) {
                return ((((float) (this.nWc - 1)) * 0.5f) * this.f17206eY) - (this.f17206eY * ((float) i));
            }
            if (this.nVQ.nWq == 2) {
                return (this.f17206eY * ((float) i)) - ((((float) (this.nWc - 1)) * 0.5f) * this.f17206eY);
            }
        }
        return 0.0f;
    }

    /* Access modifiers changed, original: final */
    public final int bLm() {
        AppMethodBeat.m2504i(42249);
        int random = (int) (Math.random() * ((double) this.nWc));
        AppMethodBeat.m2505o(42249);
        return random;
    }

    private void bLn() {
        AppMethodBeat.m2504i(42250);
        if (this.gCO != null) {
            C4990ab.m7416i("ShuffleView", "selectView != null, cancel select");
            if (this.nVT.isStarted()) {
                this.nVT.cancel();
            }
            this.nVT.removeAllUpdateListeners();
            this.nVT.removeAllListeners();
            switch (this.nVQ.nWq) {
                case 4:
                    if (this.nVZ >= 0) {
                        this.nVT.addUpdateListener(new C33788());
                        break;
                    }
                    break;
            }
            this.gCO = null;
            this.nVZ = 0;
            this.nVT.start();
        }
        AppMethodBeat.m2505o(42250);
    }

    private float getSelectScaleTranslationX() {
        AppMethodBeat.m2504i(42251);
        if (this.gCO != null) {
            float width = (0.33f * ((float) this.gCO.getWidth())) - this.f17205eX;
            int i = this.nVZ - 1;
            int i2 = (this.nWc - 1) - this.nVZ;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                float f = (width * 2.0f) / ((float) i3);
                AppMethodBeat.m2505o(42251);
                return f;
            }
        }
        AppMethodBeat.m2505o(42251);
        return 0.0f;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: xO */
    public final void mo68788xO(int i) {
        AppMethodBeat.m2504i(42252);
        if (i >= 0 && i < this.nWc) {
            C4990ab.m7416i("ShuffleView", "select card ".concat(String.valueOf(i)));
            if (this.nVT.isStarted()) {
                this.nVT.cancel();
            }
            this.nVT.removeAllUpdateListeners();
            this.nVT.removeAllListeners();
            this.gCO = (View) this.nVP.get(i);
            this.nVZ = i;
            this.nWa = null;
            this.nWb = -1;
            switch (this.nVQ.nWq) {
                case 4:
                    if (i <= 0) {
                        this.nVT.addUpdateListener(new C337510());
                        break;
                    }
                    final int i2 = i - 1;
                    final int i3 = (this.nWc - 1) - i;
                    this.nVT.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int i = 0;
                            AppMethodBeat.m2504i(42234);
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (floatValue == 0.0f) {
                                ShuffleView.this.nWg.clear();
                                ShuffleView.this.nWh.clear();
                                while (i < ShuffleView.this.nWc) {
                                    ShuffleView.this.nWg.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationX()));
                                    ShuffleView.this.nWh.add(Float.valueOf(((View) ShuffleView.this.nVP.get(i)).getTranslationY()));
                                    i++;
                                }
                                AppMethodBeat.m2505o(42234);
                                return;
                            }
                            int i2;
                            if (i2 <= 0) {
                                while (true) {
                                    i2 = i;
                                    if (i2 >= ShuffleView.this.nVZ) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68786xM(i2) * floatValue));
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(i2) * floatValue));
                                    i = i2 + 1;
                                }
                            } else {
                                while (true) {
                                    i2 = i;
                                    if (i2 >= ShuffleView.this.nVZ - 1) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.mo68786xM(i2) - (((float) (i2 + 1)) * ShuffleView.m76963g(ShuffleView.this))) * floatValue));
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(i2) * floatValue));
                                    i = i2 + 1;
                                }
                                ((View) ShuffleView.this.nVP.get(ShuffleView.this.nVZ - 1)).setTranslationX((((Float) ShuffleView.this.nWg.get(ShuffleView.this.nVZ - 1)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.mo68786xM(ShuffleView.this.nVZ - 1) - ((ShuffleView.m76963g(ShuffleView.this) * ((float) i2)) / 2.0f)) * floatValue));
                                ((View) ShuffleView.this.nVP.get(ShuffleView.this.nVZ - 1)).setTranslationY((((Float) ShuffleView.this.nWh.get(ShuffleView.this.nVZ - 1)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(ShuffleView.this.nVZ - 1) * floatValue));
                            }
                            int f;
                            if (i3 <= 0) {
                                f = ShuffleView.this.nVZ;
                                while (true) {
                                    i2 = f;
                                    if (i2 >= ShuffleView.this.nWc) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68786xM(i2) * floatValue));
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(i2) * floatValue));
                                    f = i2 + 1;
                                }
                            } else {
                                ShuffleView.this.gCO.setTranslationX((((Float) ShuffleView.this.nWg.get(ShuffleView.this.nVZ)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.mo68786xM(ShuffleView.this.nVZ) + ((ShuffleView.m76963g(ShuffleView.this) * ((float) i3)) / 2.0f)) * floatValue));
                                f = ShuffleView.this.nVZ + 1;
                                while (true) {
                                    i2 = f;
                                    if (i2 >= ShuffleView.this.nWc) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationX((((Float) ShuffleView.this.nWg.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.mo68786xM(i2) + (((float) (ShuffleView.this.nWc - i2)) * ShuffleView.m76963g(ShuffleView.this))) * floatValue));
                                    ((View) ShuffleView.this.nVP.get(i2)).setTranslationY((((Float) ShuffleView.this.nWh.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.mo68787xN(i2) * floatValue));
                                    f = i2 + 1;
                                }
                            }
                            ShuffleView.this.gCO.setTranslationY((((Float) ShuffleView.this.nWh.get(ShuffleView.this.nVZ)).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.this.gCO.getHeight()) * floatValue) / 7.0f));
                            AppMethodBeat.m2505o(42234);
                        }
                    });
                    break;
            }
            this.nVT.start();
        }
        AppMethodBeat.m2505o(42252);
    }

    private void bLo() {
        AppMethodBeat.m2504i(42253);
        if (this.nWa != null) {
            C4990ab.m7416i("ShuffleView", "touchView != null,cancel touch");
            if (this.nVT.isStarted()) {
                this.nVT.cancel();
            }
            this.nVT.removeAllUpdateListeners();
            this.nVT.removeAllListeners();
            switch (this.nVQ.nWq) {
                case 4:
                    if (this.nWb >= 0) {
                        this.nVT.addUpdateListener(new C1242211());
                        break;
                    }
                    break;
            }
            this.nWa = null;
            this.nWb = -1;
            this.nVT.start();
        }
        AppMethodBeat.m2505o(42253);
    }

    private float getTouchScaleTranslationX() {
        AppMethodBeat.m2504i(42254);
        if (this.nWa != null) {
            float width = (0.28f * ((float) this.nWa.getWidth())) - this.f17205eX;
            int i = this.nWb - 1;
            int i2 = (this.nWc - 1) - this.nWb;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                float f = (width * 2.0f) / ((float) i3);
                AppMethodBeat.m2505o(42254);
                return f;
            }
        }
        AppMethodBeat.m2505o(42254);
        return 0.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(42255);
        if (this.nWi) {
            AppMethodBeat.m2505o(42255);
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.nWc <= 0) {
            AppMethodBeat.m2505o(42255);
            return false;
        }
        C4990ab.m7411d("ShuffleView", "y:%d,packet largest:%d", Integer.valueOf(y), Integer.valueOf((getHeight() - ((View) this.nVP.get(0)).getHeight()) - (((View) this.nVP.get(0)).getHeight() / 7)));
        if (y < (getHeight() - ((View) this.nVP.get(0)).getHeight()) - (((View) this.nVP.get(0)).getHeight() / 7)) {
            if (this.gCO != null && motionEvent.getActionMasked() == 0) {
                if (this.nVW != null) {
                    this.nVW.mo24273es(this.nVZ, this.nWc);
                }
                bLn();
            } else if (this.nWa != null && this.nWa.getTranslationY() == ((float) ((-this.nWa.getHeight()) / 7))) {
                if (this.nVW != null) {
                    this.nVW.mo24274xL(this.nWc);
                }
                mo68788xO(this.nWb);
            } else if (this.nWa != null) {
                bLo();
            }
            AppMethodBeat.m2505o(42255);
            return false;
        }
        int i;
        for (i = 0; i < this.nWc; i++) {
            Rect xP = m76981xP(i);
            if (xP != null && xP.contains(x, y)) {
                i = 1;
                break;
            }
        }
        boolean z = false;
        if (i == 0) {
            C4990ab.m7411d("ShuffleView", "event %d out of cards,%d,%d", Integer.valueOf(motionEvent.getActionMasked()), Integer.valueOf(x), Integer.valueOf(y));
            if (this.gCO != null && motionEvent.getActionMasked() == 0) {
                if (this.nVW != null) {
                    this.nVW.mo24273es(this.nVZ, this.nWc);
                }
                bLn();
            } else if (this.nWa != null && this.nWa.getTranslationY() == ((float) ((-this.nWa.getHeight()) / 7))) {
                if (this.nVW != null) {
                    this.nVW.mo24274xL(this.nWc);
                }
                mo68788xO(this.nWb);
            } else if (this.nWa != null) {
                bLo();
            }
        }
        if (this.nWc <= 1) {
            AppMethodBeat.m2505o(42255);
            return false;
        }
        C4990ab.m7417i("ShuffleView", "ret:%s,action:%s", Boolean.valueOf(this.lCs.onTouchEvent(motionEvent)), Integer.valueOf(motionEvent.getActionMasked()));
        if (!this.lCs.onTouchEvent(motionEvent) && motionEvent.getActionMasked() == 1) {
            if (this.nWa != null && this.nWa.getTranslationY() == ((float) ((-this.nWa.getHeight()) / 7))) {
                if (this.nVW != null) {
                    this.nVW.mo24274xL(this.nWc);
                }
                mo68788xO(this.nWb);
            } else if (this.nWa != null) {
                bLo();
            }
        }
        AppMethodBeat.m2505o(42255);
        return true;
    }

    /* renamed from: xP */
    private Rect m76981xP(int i) {
        AppMethodBeat.m2504i(42256);
        if (i >= 0 && i < this.nWc) {
            View view = (View) this.nVP.get(i);
            switch (this.nVQ.nWq) {
                case 4:
                    if (i == 0) {
                        Rect rect = new Rect(view.getLeft() + ((int) view.getTranslationX()), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                        AppMethodBeat.m2505o(42256);
                        return rect;
                    }
                    View view2 = (View) this.nVP.get(i - 1);
                    Rect rect2 = new Rect(((int) view2.getTranslationX()) + view2.getRight(), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                    AppMethodBeat.m2505o(42256);
                    return rect2;
            }
        }
        AppMethodBeat.m2505o(42256);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: xQ */
    public final void mo68789xQ(final int i) {
        AppMethodBeat.m2504i(42257);
        this.lgH.removeAllUpdateListeners();
        this.lgH.removeAllListeners();
        if (this.nVP.size() < this.nWc) {
            this.nWc--;
            if (this.nWc == 1) {
                ((View) this.nVP.get(0)).findViewById(2131825501).setVisibility(0);
            }
            bLl();
            this.lgH.addUpdateListener(new C3931415());
            this.lgH.addListener(new C284222());
        } else {
            this.nVY = (View) this.nVP.get(this.nWc - 1);
            mo68774W(this.nVY, this.nWc - 1);
            addView(this.nVY, 0);
            if (this.nVS != null) {
                switch (this.nVQ.nWr) {
                    case 1:
                        this.nVY.setTranslationY((float) (-ghw.heightPixels));
                        break;
                    case 2:
                        this.nVY.setTranslationY((float) ghw.heightPixels);
                        break;
                    case 3:
                        this.nVY.setTranslationX((float) (-ghw.widthPixels));
                        break;
                    case 4:
                        this.nVY.setTranslationX((float) ghw.widthPixels);
                        break;
                }
            }
            this.nVY.setVisibility(4);
            this.lgH.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.m2504i(42227);
                    int i = i;
                    while (true) {
                        int i2 = i;
                        if (i2 < ShuffleView.this.nWc - 1) {
                            View view = (View) ShuffleView.this.nVP.get(i2);
                            if (ShuffleView.this.nVQ.nWp == 1) {
                                view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.nVQ.scaleX) + (1.0f - (ShuffleView.this.nVQ.scaleX * ((float) (i2 + 1)))));
                                if (ShuffleView.this.nVQ.nWq == 2) {
                                    view.setTranslationY(ShuffleView.this.mo68787xN(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.f17206eY));
                                } else if (ShuffleView.this.nVQ.nWq == 1) {
                                    view.setTranslationY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.f17206eY) + ShuffleView.this.mo68787xN(i2 + 1));
                                }
                            } else if (ShuffleView.this.nVQ.nWp == 2) {
                                view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.nVQ.scaleY) + (1.0f - (ShuffleView.this.nVQ.scaleY * ((float) (i2 + 1)))));
                                if (ShuffleView.this.nVQ.nWq == 3) {
                                    view.setTranslationX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.f17205eX) + ShuffleView.this.mo68786xM(i2 + 1));
                                } else if (ShuffleView.this.nVQ.nWq == 4) {
                                    view.setTranslationX(ShuffleView.this.mo68786xM(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.f17205eX));
                                }
                            }
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.m2505o(42227);
                            return;
                        }
                    }
                }
            });
            this.lgH.addListener(new C344364());
        }
        this.lgH.start();
        AppMethodBeat.m2505o(42257);
    }

    public void setExitAnimator(ValueAnimator valueAnimator) {
        AppMethodBeat.m2504i(42258);
        if (this.nVR != null) {
            this.nVR.removeAllListeners();
            this.nVR.cancel();
        }
        this.nVR = valueAnimator;
        if (this.nVR != null) {
            this.nVR.addUpdateListener(new C393166());
        }
        AppMethodBeat.m2505o(42258);
    }

    public void setEnterAnimator(ValueAnimator valueAnimator) {
        AppMethodBeat.m2504i(42259);
        if (this.nVS != null) {
            this.nVS.removeAllListeners();
            this.nVS.cancel();
        }
        this.nVS = valueAnimator;
        if (this.nVS != null) {
            this.nVS.addUpdateListener(new C33777());
        }
        AppMethodBeat.m2505o(42259);
    }

    public void setExitAnimatorListener(C34438a c34438a) {
        this.nVU = c34438a;
    }

    public void setEnterAnimatorListener(C34438a c34438a) {
        this.nVV = c34438a;
    }

    public void setCardListener(C34439b c34439b) {
        this.nVW = c34439b;
    }

    public View getExitView() {
        return this.nVX;
    }

    public View getEnterView() {
        return this.nVY;
    }
}
