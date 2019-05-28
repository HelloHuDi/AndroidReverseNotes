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
import android.support.v4.view.s;
import android.util.StateSet;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;
import com.tencent.mm.R;

class h {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] ENABLED_STATE_SET = new int[]{16842910};
    static final int[] PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
    static final int[] qB = new int[]{16842908, 16842910};
    static final Interpolator qr = a.mh;
    float nR;
    private final Rect oT = new Rect();
    float qA;
    final VisibilityAwareImageButton qC;
    final k qD;
    OnPreDrawListener qE;
    int qs = 0;
    private final m qt;
    j qu;
    Drawable qv;
    Drawable qw;
    d qx;
    Drawable qy;
    float qz;

    /* renamed from: android.support.design.widget.h$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        private boolean mCancelled;
        final /* synthetic */ boolean qF = false;
        final /* synthetic */ c qG;

        AnonymousClass1(c cVar) {
            this.qG = cVar;
        }

        public final void onAnimationStart(Animator animator) {
            h.this.qC.j(0, this.qF);
            this.mCancelled = false;
        }

        public final void onAnimationCancel(Animator animator) {
            this.mCancelled = true;
        }

        public final void onAnimationEnd(Animator animator) {
            h.this.qs = 0;
            if (!this.mCancelled) {
                h.this.qC.j(this.qF ? 8 : 4, this.qF);
            }
        }
    }

    abstract class e extends AnimatorListenerAdapter implements AnimatorUpdateListener {
        private boolean qI;
        private float qJ;
        private float qK;

        public abstract float cm();

        private e() {
        }

        /* synthetic */ e(h hVar, byte b) {
            this();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.qI) {
                this.qJ = h.this.qu.rk;
                this.qK = cm();
                this.qI = true;
            }
            h.this.qu.o(this.qJ + ((this.qK - this.qJ) * valueAnimator.getAnimatedFraction()));
        }

        public void onAnimationEnd(Animator animator) {
            h.this.qu.o(this.qK);
            this.qI = false;
        }
    }

    class b extends e {
        b() {
            super(h.this, (byte) 0);
        }

        /* Access modifiers changed, original: protected|final */
        public final float cm() {
            return h.this.qz + h.this.qA;
        }
    }

    interface c {
    }

    class d extends e {
        d() {
            super(h.this, (byte) 0);
        }

        /* Access modifiers changed, original: protected|final */
        public final float cm() {
            return h.this.qz;
        }
    }

    /* renamed from: android.support.design.widget.h$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean qF = false;
        final /* synthetic */ c qG;

        AnonymousClass2(c cVar) {
            this.qG = cVar;
        }

        public final void onAnimationStart(Animator animator) {
            h.this.qC.j(0, this.qF);
        }

        public final void onAnimationEnd(Animator animator) {
            h.this.qs = 0;
        }
    }

    class a extends e {
        a() {
            super(h.this, (byte) 0);
        }

        /* Access modifiers changed, original: protected|final */
        public final float cm() {
            return 0.0f;
        }
    }

    h(VisibilityAwareImageButton visibilityAwareImageButton, k kVar) {
        this.qC = visibilityAwareImageButton;
        this.qD = kVar;
        this.qt = new m();
        this.qt.a(PRESSED_ENABLED_STATE_SET, a(new b()));
        this.qt.a(qB, a(new b()));
        this.qt.a(ENABLED_STATE_SET, a(new d()));
        this.qt.a(EMPTY_STATE_SET, a(new a()));
        this.nR = this.qC.getRotation();
    }

    /* Access modifiers changed, original: 0000 */
    public void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.qv = android.support.v4.a.a.a.f(cj());
        android.support.v4.a.a.a.a(this.qv, colorStateList);
        if (mode != null) {
            android.support.v4.a.a.a.a(this.qv, mode);
        }
        this.qw = android.support.v4.a.a.a.f(cj());
        android.support.v4.a.a.a.a(this.qw, Z(i));
        if (i2 > 0) {
            this.qx = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.qx, this.qv, this.qw};
        } else {
            this.qx = null;
            drawableArr = new Drawable[]{this.qv, this.qw};
        }
        this.qy = new LayerDrawable(drawableArr);
        this.qu = new j(this.qC.getContext(), this.qy, this.qD.getRadius(), this.qz, this.qz + this.qA);
        j jVar = this.qu;
        jVar.rp = false;
        jVar.invalidateSelf();
        this.qD.setBackgroundDrawable(this.qu);
    }

    /* Access modifiers changed, original: 0000 */
    public void setRippleColor(int i) {
        if (this.qw != null) {
            android.support.v4.a.a.a.a(this.qw, Z(i));
        }
    }

    /* Access modifiers changed, original: final */
    public final void setElevation(float f) {
        if (this.qz != f) {
            this.qz = f;
            o(f, this.qA);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public float getElevation() {
        return this.qz;
    }

    /* Access modifiers changed, original: 0000 */
    public void o(float f, float f2) {
        if (this.qu != null) {
            this.qu.p(f, this.qA + f);
            cg();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void c(int[] iArr) {
        a aVar;
        m mVar = this.qt;
        int size = mVar.rx.size();
        for (int i = 0; i < size; i++) {
            aVar = (a) mVar.rx.get(i);
            if (StateSet.stateSetMatches(aVar.rC, iArr)) {
                break;
            }
        }
        aVar = null;
        if (aVar != mVar.ry) {
            if (!(mVar.ry == null || mVar.rz == null)) {
                mVar.rz.cancel();
                mVar.rz = null;
            }
            mVar.ry = aVar;
            if (aVar != null) {
                mVar.rz = aVar.rD;
                mVar.rz.start();
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void ce() {
        m mVar = this.qt;
        if (mVar.rz != null) {
            mVar.rz.end();
            mVar.rz = null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void cf() {
    }

    /* Access modifiers changed, original: final */
    public final void cg() {
        Rect rect = this.oT;
        d(rect);
        e(rect);
        this.qD.e(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* Access modifiers changed, original: 0000 */
    public void d(Rect rect) {
        this.qu.getPadding(rect);
    }

    /* Access modifiers changed, original: 0000 */
    public void e(Rect rect) {
    }

    /* Access modifiers changed, original: 0000 */
    public boolean ch() {
        return true;
    }

    /* Access modifiers changed, original: final */
    public final d a(int i, ColorStateList colorStateList) {
        Context context = this.qC.getContext();
        d ci = ci();
        ci.b(android.support.v4.content.b.i(context, R.color.lt), android.support.v4.content.b.i(context, R.color.ls), android.support.v4.content.b.i(context, R.color.lq), android.support.v4.content.b.i(context, R.color.lr));
        ci.setBorderWidth((float) i);
        ci.a(colorStateList);
        return ci;
    }

    /* Access modifiers changed, original: 0000 */
    public d ci() {
        return new d();
    }

    /* Access modifiers changed, original: final */
    public final GradientDrawable cj() {
        GradientDrawable ck = ck();
        ck.setShape(1);
        ck.setColor(-1);
        return ck;
    }

    /* Access modifiers changed, original: 0000 */
    public GradientDrawable ck() {
        return new GradientDrawable();
    }

    private static ValueAnimator a(e eVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(qr);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(eVar);
        valueAnimator.addUpdateListener(eVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    private static ColorStateList Z(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{qB, i, PRESSED_ENABLED_STATE_SET};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    /* Access modifiers changed, original: final */
    public final boolean cl() {
        return s.as(this.qC) && !this.qC.isInEditMode();
    }
}
