package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.p057v4.content.p062a.C0379c;
import android.support.p057v4.view.C0477s;
import android.support.transition.Transition.C31852c;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    /* renamed from: xW */
    private static final Property<C31845b, float[]> f14600xW = new Property<C31845b, float[]>(float[].class, "nonTranslations") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            C31845b c31845b = (C31845b) obj;
            float[] fArr = (float[]) obj2;
            System.arraycopy(fArr, 0, c31845b.f14597yh, 0, fArr.length);
            c31845b.mo51820cR();
        }
    };
    /* renamed from: xX */
    private static final Property<C31845b, PointF> f14601xX = new Property<C31845b, PointF>(PointF.class, "translations") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            C31845b c31845b = (C31845b) obj;
            PointF pointF = (PointF) obj2;
            c31845b.f14598yi = pointF.x;
            c31845b.f14599yj = pointF.y;
            c31845b.mo51820cR();
        }
    };
    /* renamed from: xY */
    private static final boolean f14602xY;
    /* renamed from: xk */
    private static final String[] f14603xk = new String[]{"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    /* renamed from: xZ */
    private boolean f14604xZ = true;
    /* renamed from: xt */
    private boolean f14605xt = true;
    /* renamed from: ya */
    private Matrix f14606ya = new Matrix();

    /* renamed from: android.support.transition.ChangeTransform$a */
    static class C8356a extends C36668ad {
        private View mView;
        /* renamed from: yg */
        private C37109j f2300yg;

        C8356a(View view, C37109j c37109j) {
            this.mView = view;
            this.f2300yg = c37109j;
        }

        /* renamed from: a */
        public final void mo452a(Transition transition) {
            transition.mo42277b((C31852c) this);
            C41497k.m72485A(this.mView);
            this.mView.setTag(2131820684, null);
            this.mView.setTag(2131820647, null);
        }

        /* renamed from: cO */
        public final void mo18279cO() {
            this.f2300yg.setVisibility(4);
        }

        /* renamed from: cP */
        public final void mo18280cP() {
            this.f2300yg.setVisibility(0);
        }
    }

    /* renamed from: android.support.transition.ChangeTransform$b */
    static class C31845b {
        final Matrix mMatrix = new Matrix();
        private final View mView;
        /* renamed from: yh */
        final float[] f14597yh;
        /* renamed from: yi */
        float f14598yi;
        /* renamed from: yj */
        float f14599yj;

        C31845b(View view, float[] fArr) {
            this.mView = view;
            this.f14597yh = (float[]) fArr.clone();
            this.f14598yi = this.f14597yh[2];
            this.f14599yj = this.f14597yh[5];
            mo51820cR();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cR */
        public final void mo51820cR() {
            this.f14597yh[2] = this.f14598yi;
            this.f14597yh[5] = this.f14599yj;
            this.mMatrix.setValues(this.f14597yh);
            C41495au.m72483c(this.mView, this.mMatrix);
        }
    }

    /* renamed from: android.support.transition.ChangeTransform$c */
    static class C31847c {
        final float mScaleX;
        final float mScaleY;
        /* renamed from: yi */
        final float f14607yi;
        /* renamed from: yj */
        final float f14608yj;
        /* renamed from: yk */
        final float f14609yk;
        /* renamed from: yl */
        final float f14610yl;
        /* renamed from: ym */
        final float f14611ym;
        /* renamed from: yn */
        final float f14612yn;

        C31847c(View view) {
            this.f14607yi = view.getTranslationX();
            this.f14608yj = view.getTranslationY();
            this.f14609yk = C0477s.m916ah(view);
            this.mScaleX = view.getScaleX();
            this.mScaleY = view.getScaleY();
            this.f14610yl = view.getRotationX();
            this.f14611ym = view.getRotationY();
            this.f14612yn = view.getRotation();
        }

        /* renamed from: y */
        public final void mo51825y(View view) {
            ChangeTransform.m51603a(view, this.f14607yi, this.f14608yj, this.f14609yk, this.mScaleX, this.mScaleY, this.f14610yl, this.f14611ym, this.f14612yn);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C31847c)) {
                return false;
            }
            C31847c c31847c = (C31847c) obj;
            if (c31847c.f14607yi == this.f14607yi && c31847c.f14608yj == this.f14608yj && c31847c.f14609yk == this.f14609yk && c31847c.mScaleX == this.mScaleX && c31847c.mScaleY == this.mScaleY && c31847c.f14610yl == this.f14610yl && c31847c.f14611ym == this.f14611ym && c31847c.f14612yn == this.f14612yn) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int floatToIntBits;
            int i = 0;
            int floatToIntBits2 = (this.f14607yi != 0.0f ? Float.floatToIntBits(this.f14607yi) : 0) * 31;
            if (this.f14608yj != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.f14608yj);
            } else {
                floatToIntBits = 0;
            }
            floatToIntBits2 = (floatToIntBits + floatToIntBits2) * 31;
            if (this.f14609yk != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.f14609yk);
            } else {
                floatToIntBits = 0;
            }
            floatToIntBits2 = (floatToIntBits + floatToIntBits2) * 31;
            if (this.mScaleX != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.mScaleX);
            } else {
                floatToIntBits = 0;
            }
            floatToIntBits2 = (floatToIntBits + floatToIntBits2) * 31;
            if (this.mScaleY != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.mScaleY);
            } else {
                floatToIntBits = 0;
            }
            floatToIntBits2 = (floatToIntBits + floatToIntBits2) * 31;
            if (this.f14610yl != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.f14610yl);
            } else {
                floatToIntBits = 0;
            }
            floatToIntBits2 = (floatToIntBits + floatToIntBits2) * 31;
            if (this.f14611ym != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.f14611ym);
            } else {
                floatToIntBits = 0;
            }
            floatToIntBits = (floatToIntBits + floatToIntBits2) * 31;
            if (this.f14612yn != 0.0f) {
                i = Float.floatToIntBits(this.f14612yn);
            }
            return floatToIntBits + i;
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        f14602xY = z;
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37103ac.f15733zC);
        this.f14604xZ = C0379c.m640a(obtainStyledAttributes, (XmlPullParser) attributeSet, "reparentWithOverlay", 1, true);
        this.f14605xt = C0379c.m640a(obtainStyledAttributes, (XmlPullParser) attributeSet, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    public final String[] getTransitionProperties() {
        return f14603xk;
    }

    /* renamed from: c */
    private void m51607c(C8368ah c8368ah) {
        View view = c8368ah.view;
        if (view.getVisibility() != 8) {
            Object obj;
            c8368ah.values.put("android:changeTransform:parent", view.getParent());
            c8368ah.values.put("android:changeTransform:transforms", new C31847c(view));
            Matrix matrix = view.getMatrix();
            if (matrix == null || matrix.isIdentity()) {
                obj = null;
            } else {
                obj = new Matrix(matrix);
            }
            c8368ah.values.put("android:changeTransform:matrix", obj);
            if (this.f14605xt) {
                matrix = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                C41495au.m72479a(viewGroup, matrix);
                matrix.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                c8368ah.values.put("android:changeTransform:parentMatrix", matrix);
                c8368ah.values.put("android:changeTransform:intermediateMatrix", view.getTag(2131820684));
                c8368ah.values.put("android:changeTransform:intermediateParentMatrix", view.getTag(2131820647));
            }
        }
    }

    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        m51607c(c8368ah);
        if (!f14602xY) {
            ((ViewGroup) c8368ah.view.getParent()).startViewTransition(c8368ah.view);
        }
    }

    /* renamed from: b */
    public final void mo411b(C8368ah c8368ah) {
        m51607c(c8368ah);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final Animator mo409a(ViewGroup viewGroup, C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah == null || c8368ah2 == null || !c8368ah.values.containsKey("android:changeTransform:parent") || !c8368ah2.values.containsKey("android:changeTransform:parent")) {
            return null;
        }
        boolean z;
        Matrix matrix;
        Matrix matrix2;
        Object obj;
        ViewGroup viewGroup2 = (ViewGroup) c8368ah.values.get("android:changeTransform:parent");
        View view = (ViewGroup) c8368ah2.values.get("android:changeTransform:parent");
        if (this.f14605xt) {
            Object obj2;
            if (mo59139C(viewGroup2) && mo59139C(view)) {
                C8368ah c = mo59143c(viewGroup2, true);
                obj2 = c != null ? view == c.view ? 1 : null : null;
            } else {
                obj2 = viewGroup2 == view ? 1 : null;
            }
            if (obj2 == null) {
                Matrix matrix3;
                Animator animator;
                z = true;
                matrix = (Matrix) c8368ah.values.get("android:changeTransform:intermediateMatrix");
                if (matrix != null) {
                    c8368ah.values.put("android:changeTransform:matrix", matrix);
                }
                matrix = (Matrix) c8368ah.values.get("android:changeTransform:intermediateParentMatrix");
                if (matrix != null) {
                    c8368ah.values.put("android:changeTransform:parentMatrix", matrix);
                }
                if (z) {
                    matrix = (Matrix) c8368ah2.values.get("android:changeTransform:parentMatrix");
                    c8368ah2.view.setTag(2131820647, matrix);
                    matrix3 = this.f14606ya;
                    matrix3.reset();
                    matrix.invert(matrix3);
                    matrix = (Matrix) c8368ah.values.get("android:changeTransform:matrix");
                    if (matrix == null) {
                        matrix = new Matrix();
                        c8368ah.values.put("android:changeTransform:matrix", matrix);
                        matrix2 = matrix;
                    } else {
                        matrix2 = matrix;
                    }
                    matrix2.postConcat((Matrix) c8368ah.values.get("android:changeTransform:parentMatrix"));
                    matrix2.postConcat(matrix3);
                }
                matrix = (Matrix) c8368ah.values.get("android:changeTransform:matrix");
                matrix2 = (Matrix) c8368ah2.values.get("android:changeTransform:matrix");
                if (matrix == null) {
                    matrix = C17422p.f3874vt;
                }
                if (matrix2 != null) {
                    obj = C17422p.f3874vt;
                } else {
                    matrix3 = matrix2;
                }
                if (matrix.equals(obj)) {
                    final C31847c c31847c = (C31847c) c8368ah2.values.get("android:changeTransform:transforms");
                    final View view2 = c8368ah2.view;
                    m51608w(view2);
                    r2 = new float[9];
                    matrix.getValues(r2);
                    float[] fArr = new float[9];
                    obj.getValues(fArr);
                    final C31845b c31845b = new C31845b(view2, r2);
                    PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject(f14600xW, new C8374f(new float[9]), new float[][]{r2, fArr});
                    PropertyValuesHolder a = C17425v.m27067a(f14601xX, this.f15707Ak.getPath(r2[2], r2[5], fArr[2], fArr[5]));
                    Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(c31845b, new PropertyValuesHolder[]{ofObject, a});
                    C318483 c318483 = new AnimatorListenerAdapter() {
                        private boolean mIsCanceled;
                        /* renamed from: ya */
                        private Matrix f14613ya = new Matrix();

                        public final void onAnimationCancel(Animator animator) {
                            this.mIsCanceled = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            if (!this.mIsCanceled) {
                                if (z && ChangeTransform.this.f14604xZ) {
                                    m51614a(obj);
                                } else {
                                    view2.setTag(2131820684, null);
                                    view2.setTag(2131820647, null);
                                }
                            }
                            C41495au.m72483c(view2, null);
                            c31847c.mo51825y(view2);
                        }

                        public final void onAnimationPause(Animator animator) {
                            m51614a(c31845b.mMatrix);
                        }

                        public final void onAnimationResume(Animator animator) {
                            ChangeTransform.m51608w(view2);
                        }

                        /* renamed from: a */
                        private void m51614a(Matrix matrix) {
                            this.f14613ya.set(matrix);
                            view2.setTag(2131820684, this.f14613ya);
                            c31847c.mo51825y(view2);
                        }
                    };
                    ofPropertyValuesHolder.addListener(c318483);
                    C37102a.m62100a(ofPropertyValuesHolder, c318483);
                    animator = ofPropertyValuesHolder;
                } else {
                    animator = null;
                }
                if (!z && animator != null && this.f14604xZ) {
                    m51606b(viewGroup, c8368ah, c8368ah2);
                    return animator;
                } else if (!f14602xY) {
                    return animator;
                } else {
                    viewGroup2.endViewTransition(c8368ah.view);
                    return animator;
                }
            }
        }
        z = false;
        matrix = (Matrix) c8368ah.values.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
        }
        matrix = (Matrix) c8368ah.values.get("android:changeTransform:intermediateParentMatrix");
        if (matrix != null) {
        }
        if (z) {
        }
        matrix = (Matrix) c8368ah.values.get("android:changeTransform:matrix");
        matrix2 = (Matrix) c8368ah2.values.get("android:changeTransform:matrix");
        if (matrix == null) {
        }
        if (matrix2 != null) {
        }
        if (matrix.equals(obj)) {
        }
        if (!z) {
        }
        if (!f14602xY) {
        }
    }

    /* renamed from: b */
    private void m51606b(ViewGroup viewGroup, C8368ah c8368ah, C8368ah c8368ah2) {
        View view = c8368ah2.view;
        Matrix matrix = new Matrix((Matrix) c8368ah2.values.get("android:changeTransform:parentMatrix"));
        C41495au.m72481b(viewGroup, matrix);
        C37109j a = C41497k.m72486a(view, viewGroup, matrix);
        if (a != null) {
            Transition thisR;
            a.mo31647a((ViewGroup) c8368ah.values.get("android:changeTransform:parent"), c8368ah.view);
            while (thisR.f15724zY != null) {
                thisR = thisR.f15724zY;
            }
            thisR.mo42271a(new C8356a(view, a));
            if (f14602xY) {
                if (c8368ah.view != c8368ah2.view) {
                    C41495au.m72482c(c8368ah.view, 0.0f);
                }
                C41495au.m72482c(view, 1.0f);
            }
        }
    }

    /* renamed from: w */
    private static void m51608w(View view) {
        m51603a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    /* renamed from: a */
    private static void m51603a(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        C0477s.m946i(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }
}
