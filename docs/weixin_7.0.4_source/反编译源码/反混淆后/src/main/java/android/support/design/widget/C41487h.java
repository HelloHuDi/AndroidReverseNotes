package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.design.widget.C25313m.C8349a;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.view.C0477s;
import android.util.StateSet;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.design.widget.h */
class C41487h {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] ENABLED_STATE_SET = new int[]{16842910};
    static final int[] PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
    /* renamed from: qB */
    static final int[] f16741qB = new int[]{16842908, 16842910};
    /* renamed from: qr */
    static final Interpolator f16742qr = C31841a.f14581mh;
    /* renamed from: nR */
    float f16743nR;
    /* renamed from: oT */
    private final Rect f16744oT = new Rect();
    /* renamed from: qA */
    float f16745qA;
    /* renamed from: qC */
    final VisibilityAwareImageButton f16746qC;
    /* renamed from: qD */
    final C25312k f16747qD;
    /* renamed from: qE */
    OnPreDrawListener f16748qE;
    /* renamed from: qs */
    int f16749qs = 0;
    /* renamed from: qt */
    private final C25313m f16750qt;
    /* renamed from: qu */
    C37100j f16751qu;
    /* renamed from: qv */
    Drawable f16752qv;
    /* renamed from: qw */
    Drawable f16753qw;
    /* renamed from: qx */
    C31842d f16754qx;
    /* renamed from: qy */
    Drawable f16755qy;
    /* renamed from: qz */
    float f16756qz;

    /* renamed from: android.support.design.widget.h$1 */
    class C83461 extends AnimatorListenerAdapter {
        private boolean mCancelled;
        /* renamed from: qF */
        final /* synthetic */ boolean f2282qF = false;
        /* renamed from: qG */
        final /* synthetic */ C25310c f2283qG;

        C83461(C25310c c25310c) {
            this.f2283qG = c25310c;
        }

        public final void onAnimationStart(Animator animator) {
            C41487h.this.f16746qC.mo415j(0, this.f2282qF);
            this.mCancelled = false;
        }

        public final void onAnimationCancel(Animator animator) {
            this.mCancelled = true;
        }

        public final void onAnimationEnd(Animator animator) {
            C41487h.this.f16749qs = 0;
            if (!this.mCancelled) {
                C41487h.this.f16746qC.mo415j(this.f2282qF ? 8 : 4, this.f2282qF);
            }
        }
    }

    /* renamed from: android.support.design.widget.h$e */
    abstract class C17394e extends AnimatorListenerAdapter implements AnimatorUpdateListener {
        /* renamed from: qI */
        private boolean f3797qI;
        /* renamed from: qJ */
        private float f3798qJ;
        /* renamed from: qK */
        private float f3799qK;

        /* renamed from: cm */
        public abstract float mo31606cm();

        private C17394e() {
        }

        /* synthetic */ C17394e(C41487h c41487h, byte b) {
            this();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f3797qI) {
                this.f3798qJ = C41487h.this.f16751qu.f15688rk;
                this.f3799qK = mo31606cm();
                this.f3797qI = true;
            }
            C41487h.this.f16751qu.mo59137o(this.f3798qJ + ((this.f3799qK - this.f3798qJ) * valueAnimator.getAnimatedFraction()));
        }

        public void onAnimationEnd(Animator animator) {
            C41487h.this.f16751qu.mo59137o(this.f3799qK);
            this.f3797qI = false;
        }
    }

    /* renamed from: android.support.design.widget.h$b */
    class C24636b extends C17394e {
        C24636b() {
            super(C41487h.this, (byte) 0);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: cm */
        public final float mo31606cm() {
            return C41487h.this.f16756qz + C41487h.this.f16745qA;
        }
    }

    /* renamed from: android.support.design.widget.h$c */
    interface C25310c {
    }

    /* renamed from: android.support.design.widget.h$d */
    class C25311d extends C17394e {
        C25311d() {
            super(C41487h.this, (byte) 0);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: cm */
        public final float mo31606cm() {
            return C41487h.this.f16756qz;
        }
    }

    /* renamed from: android.support.design.widget.h$2 */
    class C414842 extends AnimatorListenerAdapter {
        /* renamed from: qF */
        final /* synthetic */ boolean f16736qF = false;
        /* renamed from: qG */
        final /* synthetic */ C25310c f16737qG;

        C414842(C25310c c25310c) {
            this.f16737qG = c25310c;
        }

        public final void onAnimationStart(Animator animator) {
            C41487h.this.f16746qC.mo415j(0, this.f16736qF);
        }

        public final void onAnimationEnd(Animator animator) {
            C41487h.this.f16749qs = 0;
        }
    }

    /* renamed from: android.support.design.widget.h$3 */
    class C414853 implements OnPreDrawListener {
        C414853() {
        }

        public final boolean onPreDraw() {
            C41487h c41487h = C41487h.this;
            float rotation = c41487h.f16746qC.getRotation();
            if (c41487h.f16743nR != rotation) {
                c41487h.f16743nR = rotation;
                if (VERSION.SDK_INT == 19) {
                    if (c41487h.f16743nR % 90.0f != 0.0f) {
                        if (c41487h.f16746qC.getLayerType() != 1) {
                            c41487h.f16746qC.setLayerType(1, null);
                        }
                    } else if (c41487h.f16746qC.getLayerType() != 0) {
                        c41487h.f16746qC.setLayerType(0, null);
                    }
                }
                if (c41487h.f16751qu != null) {
                    C37100j c37100j = c41487h.f16751qu;
                    float f = -c41487h.f16743nR;
                    if (c37100j.f15679nR != f) {
                        c37100j.f15679nR = f;
                        c37100j.invalidateSelf();
                    }
                }
                if (c41487h.f16754qx != null) {
                    C31842d c31842d = c41487h.f16754qx;
                    float f2 = -c41487h.f16743nR;
                    if (f2 != c31842d.f14593nR) {
                        c31842d.f14593nR = f2;
                        c31842d.invalidateSelf();
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: android.support.design.widget.h$a */
    class C41486a extends C17394e {
        C41486a() {
            super(C41487h.this, (byte) 0);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: cm */
        public final float mo31606cm() {
            return 0.0f;
        }
    }

    C41487h(VisibilityAwareImageButton visibilityAwareImageButton, C25312k c25312k) {
        this.f16746qC = visibilityAwareImageButton;
        this.f16747qD = c25312k;
        this.f16750qt = new C25313m();
        this.f16750qt.mo42264a(PRESSED_ENABLED_STATE_SET, C41487h.m72442a(new C24636b()));
        this.f16750qt.mo42264a(f16741qB, C41487h.m72442a(new C24636b()));
        this.f16750qt.mo42264a(ENABLED_STATE_SET, C41487h.m72442a(new C25311d()));
        this.f16750qt.mo42264a(EMPTY_STATE_SET, C41487h.m72442a(new C41486a()));
        this.f16743nR = this.f16746qC.getRotation();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo66212a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.f16752qv = C0280a.m467f(mo66219cj());
        C0280a.m457a(this.f16752qv, colorStateList);
        if (mode != null) {
            C0280a.m460a(this.f16752qv, mode);
        }
        this.f16753qw = C0280a.m467f(mo66219cj());
        C0280a.m457a(this.f16753qw, C41487h.m72441Z(i));
        if (i2 > 0) {
            this.f16754qx = mo66211a(i2, colorStateList);
            drawableArr = new Drawable[]{this.f16754qx, this.f16752qv, this.f16753qw};
        } else {
            this.f16754qx = null;
            drawableArr = new Drawable[]{this.f16752qv, this.f16753qw};
        }
        this.f16755qy = new LayerDrawable(drawableArr);
        this.f16751qu = new C37100j(this.f16746qC.getContext(), this.f16755qy, this.f16747qD.getRadius(), this.f16756qz, this.f16756qz + this.f16745qA);
        C37100j c37100j = this.f16751qu;
        c37100j.f15693rp = false;
        c37100j.invalidateSelf();
        this.f16747qD.setBackgroundDrawable(this.f16751qu);
    }

    /* Access modifiers changed, original: 0000 */
    public void setRippleColor(int i) {
        if (this.f16753qw != null) {
            C0280a.m457a(this.f16753qw, C41487h.m72441Z(i));
        }
    }

    /* Access modifiers changed, original: final */
    public final void setElevation(float f) {
        if (this.f16756qz != f) {
            this.f16756qz = f;
            mo66225o(f, this.f16745qA);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public float getElevation() {
        return this.f16756qz;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: o */
    public void mo66225o(float f, float f2) {
        if (this.f16751qu != null) {
            this.f16751qu.mo59138p(f, this.f16745qA + f);
            mo66216cg();
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo66213c(int[] iArr) {
        C8349a c8349a;
        C25313m c25313m = this.f16750qt;
        int size = c25313m.f5116rx.size();
        for (int i = 0; i < size; i++) {
            c8349a = (C8349a) c25313m.f5116rx.get(i);
            if (StateSet.stateSetMatches(c8349a.f2286rC, iArr)) {
                break;
            }
        }
        c8349a = null;
        if (c8349a != c25313m.f5117ry) {
            if (!(c25313m.f5117ry == null || c25313m.f5118rz == null)) {
                c25313m.f5118rz.cancel();
                c25313m.f5118rz = null;
            }
            c25313m.f5117ry = c8349a;
            if (c8349a != null) {
                c25313m.f5118rz = c8349a.f2287rD;
                c25313m.f5118rz.start();
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: ce */
    public void mo66214ce() {
        C25313m c25313m = this.f16750qt;
        if (c25313m.f5118rz != null) {
            c25313m.f5118rz.end();
            c25313m.f5118rz = null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: cf */
    public void mo66215cf() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cg */
    public final void mo66216cg() {
        Rect rect = this.f16744oT;
        mo66222d(rect);
        mo66223e(rect);
        this.f16747qD.mo18193e(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public void mo66222d(Rect rect) {
        this.f16751qu.getPadding(rect);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public void mo66223e(Rect rect) {
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: ch */
    public boolean mo66217ch() {
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C31842d mo66211a(int i, ColorStateList colorStateList) {
        Context context = this.f16746qC.getContext();
        C31842d ci = mo66218ci();
        ci.mo51809b(C0380b.m652i(context, C25738R.color.f11925lt), C0380b.m652i(context, C25738R.color.f11924ls), C0380b.m652i(context, C25738R.color.f11922lq), C0380b.m652i(context, C25738R.color.f11923lr));
        ci.setBorderWidth((float) i);
        ci.mo51808a(colorStateList);
        return ci;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: ci */
    public C31842d mo66218ci() {
        return new C31842d();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cj */
    public final GradientDrawable mo66219cj() {
        GradientDrawable ck = mo66220ck();
        ck.setShape(1);
        ck.setColor(-1);
        return ck;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: ck */
    public GradientDrawable mo66220ck() {
        return new GradientDrawable();
    }

    /* renamed from: a */
    private static ValueAnimator m72442a(C17394e c17394e) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f16742qr);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(c17394e);
        valueAnimator.addUpdateListener(c17394e);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    /* renamed from: Z */
    private static ColorStateList m72441Z(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{f16741qB, i, PRESSED_ENABLED_STATE_SET};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cl */
    public final boolean mo66221cl() {
        return C0477s.m927as(this.f16746qC) && !this.f16746qC.isInEditMode();
    }
}
