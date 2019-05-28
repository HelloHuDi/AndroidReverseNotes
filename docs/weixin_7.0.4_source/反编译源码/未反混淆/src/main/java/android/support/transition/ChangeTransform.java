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
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final Property<b, float[]> xW = new Property<b, float[]>(float[].class, "nonTranslations") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            b bVar = (b) obj;
            float[] fArr = (float[]) obj2;
            System.arraycopy(fArr, 0, bVar.yh, 0, fArr.length);
            bVar.cR();
        }
    };
    private static final Property<b, PointF> xX = new Property<b, PointF>(PointF.class, "translations") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            b bVar = (b) obj;
            PointF pointF = (PointF) obj2;
            bVar.yi = pointF.x;
            bVar.yj = pointF.y;
            bVar.cR();
        }
    };
    private static final boolean xY;
    private static final String[] xk = new String[]{"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private boolean xZ = true;
    private boolean xt = true;
    private Matrix ya = new Matrix();

    static class a extends ad {
        private View mView;
        private j yg;

        a(View view, j jVar) {
            this.mView = view;
            this.yg = jVar;
        }

        public final void a(Transition transition) {
            transition.b((android.support.transition.Transition.c) this);
            k.A(this.mView);
            this.mView.setTag(R.id.d3, null);
            this.mView.setTag(R.id.c3, null);
        }

        public final void cO() {
            this.yg.setVisibility(4);
        }

        public final void cP() {
            this.yg.setVisibility(0);
        }
    }

    static class b {
        final Matrix mMatrix = new Matrix();
        private final View mView;
        final float[] yh;
        float yi;
        float yj;

        b(View view, float[] fArr) {
            this.mView = view;
            this.yh = (float[]) fArr.clone();
            this.yi = this.yh[2];
            this.yj = this.yh[5];
            cR();
        }

        /* Access modifiers changed, original: final */
        public final void cR() {
            this.yh[2] = this.yi;
            this.yh[5] = this.yj;
            this.mMatrix.setValues(this.yh);
            au.c(this.mView, this.mMatrix);
        }
    }

    static class c {
        final float mScaleX;
        final float mScaleY;
        final float yi;
        final float yj;
        final float yk;
        final float yl;
        final float ym;
        final float yn;

        c(View view) {
            this.yi = view.getTranslationX();
            this.yj = view.getTranslationY();
            this.yk = s.ah(view);
            this.mScaleX = view.getScaleX();
            this.mScaleY = view.getScaleY();
            this.yl = view.getRotationX();
            this.ym = view.getRotationY();
            this.yn = view.getRotation();
        }

        public final void y(View view) {
            ChangeTransform.a(view, this.yi, this.yj, this.yk, this.mScaleX, this.mScaleY, this.yl, this.ym, this.yn);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.yi == this.yi && cVar.yj == this.yj && cVar.yk == this.yk && cVar.mScaleX == this.mScaleX && cVar.mScaleY == this.mScaleY && cVar.yl == this.yl && cVar.ym == this.ym && cVar.yn == this.yn) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int floatToIntBits;
            int i = 0;
            int floatToIntBits2 = (this.yi != 0.0f ? Float.floatToIntBits(this.yi) : 0) * 31;
            if (this.yj != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.yj);
            } else {
                floatToIntBits = 0;
            }
            floatToIntBits2 = (floatToIntBits + floatToIntBits2) * 31;
            if (this.yk != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.yk);
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
            if (this.yl != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.yl);
            } else {
                floatToIntBits = 0;
            }
            floatToIntBits2 = (floatToIntBits + floatToIntBits2) * 31;
            if (this.ym != 0.0f) {
                floatToIntBits = Float.floatToIntBits(this.ym);
            } else {
                floatToIntBits = 0;
            }
            floatToIntBits = (floatToIntBits + floatToIntBits2) * 31;
            if (this.yn != 0.0f) {
                i = Float.floatToIntBits(this.yn);
            }
            return floatToIntBits + i;
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        xY = z;
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ac.zC);
        this.xZ = android.support.v4.content.a.c.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "reparentWithOverlay", 1, true);
        this.xt = android.support.v4.content.a.c.a(obtainStyledAttributes, (XmlPullParser) attributeSet, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    public final String[] getTransitionProperties() {
        return xk;
    }

    private void c(ah ahVar) {
        View view = ahVar.view;
        if (view.getVisibility() != 8) {
            Object obj;
            ahVar.values.put("android:changeTransform:parent", view.getParent());
            ahVar.values.put("android:changeTransform:transforms", new c(view));
            Matrix matrix = view.getMatrix();
            if (matrix == null || matrix.isIdentity()) {
                obj = null;
            } else {
                obj = new Matrix(matrix);
            }
            ahVar.values.put("android:changeTransform:matrix", obj);
            if (this.xt) {
                matrix = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                au.a(viewGroup, matrix);
                matrix.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                ahVar.values.put("android:changeTransform:parentMatrix", matrix);
                ahVar.values.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.d3));
                ahVar.values.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.c3));
            }
        }
    }

    public final void a(ah ahVar) {
        c(ahVar);
        if (!xY) {
            ((ViewGroup) ahVar.view.getParent()).startViewTransition(ahVar.view);
        }
    }

    public final void b(ah ahVar) {
        c(ahVar);
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
    public final Animator a(ViewGroup viewGroup, ah ahVar, ah ahVar2) {
        if (ahVar == null || ahVar2 == null || !ahVar.values.containsKey("android:changeTransform:parent") || !ahVar2.values.containsKey("android:changeTransform:parent")) {
            return null;
        }
        boolean z;
        Matrix matrix;
        Matrix matrix2;
        Object obj;
        ViewGroup viewGroup2 = (ViewGroup) ahVar.values.get("android:changeTransform:parent");
        View view = (ViewGroup) ahVar2.values.get("android:changeTransform:parent");
        if (this.xt) {
            Object obj2;
            if (C(viewGroup2) && C(view)) {
                ah c = c(viewGroup2, true);
                obj2 = c != null ? view == c.view ? 1 : null : null;
            } else {
                obj2 = viewGroup2 == view ? 1 : null;
            }
            if (obj2 == null) {
                Matrix matrix3;
                Animator animator;
                z = true;
                matrix = (Matrix) ahVar.values.get("android:changeTransform:intermediateMatrix");
                if (matrix != null) {
                    ahVar.values.put("android:changeTransform:matrix", matrix);
                }
                matrix = (Matrix) ahVar.values.get("android:changeTransform:intermediateParentMatrix");
                if (matrix != null) {
                    ahVar.values.put("android:changeTransform:parentMatrix", matrix);
                }
                if (z) {
                    matrix = (Matrix) ahVar2.values.get("android:changeTransform:parentMatrix");
                    ahVar2.view.setTag(R.id.c3, matrix);
                    matrix3 = this.ya;
                    matrix3.reset();
                    matrix.invert(matrix3);
                    matrix = (Matrix) ahVar.values.get("android:changeTransform:matrix");
                    if (matrix == null) {
                        matrix = new Matrix();
                        ahVar.values.put("android:changeTransform:matrix", matrix);
                        matrix2 = matrix;
                    } else {
                        matrix2 = matrix;
                    }
                    matrix2.postConcat((Matrix) ahVar.values.get("android:changeTransform:parentMatrix"));
                    matrix2.postConcat(matrix3);
                }
                matrix = (Matrix) ahVar.values.get("android:changeTransform:matrix");
                matrix2 = (Matrix) ahVar2.values.get("android:changeTransform:matrix");
                if (matrix == null) {
                    matrix = p.vt;
                }
                if (matrix2 != null) {
                    obj = p.vt;
                } else {
                    matrix3 = matrix2;
                }
                if (matrix.equals(obj)) {
                    final c cVar = (c) ahVar2.values.get("android:changeTransform:transforms");
                    final View view2 = ahVar2.view;
                    w(view2);
                    r2 = new float[9];
                    matrix.getValues(r2);
                    float[] fArr = new float[9];
                    obj.getValues(fArr);
                    final b bVar = new b(view2, r2);
                    PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject(xW, new f(new float[9]), new float[][]{r2, fArr});
                    PropertyValuesHolder a = v.a(xX, this.Ak.getPath(r2[2], r2[5], fArr[2], fArr[5]));
                    Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bVar, new PropertyValuesHolder[]{ofObject, a});
                    AnonymousClass3 anonymousClass3 = new AnimatorListenerAdapter() {
                        private boolean mIsCanceled;
                        private Matrix ya = new Matrix();

                        public final void onAnimationCancel(Animator animator) {
                            this.mIsCanceled = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            if (!this.mIsCanceled) {
                                if (z && ChangeTransform.this.xZ) {
                                    a(obj);
                                } else {
                                    view2.setTag(R.id.d3, null);
                                    view2.setTag(R.id.c3, null);
                                }
                            }
                            au.c(view2, null);
                            cVar.y(view2);
                        }

                        public final void onAnimationPause(Animator animator) {
                            a(bVar.mMatrix);
                        }

                        public final void onAnimationResume(Animator animator) {
                            ChangeTransform.w(view2);
                        }

                        private void a(Matrix matrix) {
                            this.ya.set(matrix);
                            view2.setTag(R.id.d3, this.ya);
                            cVar.y(view2);
                        }
                    };
                    ofPropertyValuesHolder.addListener(anonymousClass3);
                    a.a(ofPropertyValuesHolder, anonymousClass3);
                    animator = ofPropertyValuesHolder;
                } else {
                    animator = null;
                }
                if (!z && animator != null && this.xZ) {
                    b(viewGroup, ahVar, ahVar2);
                    return animator;
                } else if (!xY) {
                    return animator;
                } else {
                    viewGroup2.endViewTransition(ahVar.view);
                    return animator;
                }
            }
        }
        z = false;
        matrix = (Matrix) ahVar.values.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
        }
        matrix = (Matrix) ahVar.values.get("android:changeTransform:intermediateParentMatrix");
        if (matrix != null) {
        }
        if (z) {
        }
        matrix = (Matrix) ahVar.values.get("android:changeTransform:matrix");
        matrix2 = (Matrix) ahVar2.values.get("android:changeTransform:matrix");
        if (matrix == null) {
        }
        if (matrix2 != null) {
        }
        if (matrix.equals(obj)) {
        }
        if (!z) {
        }
        if (!xY) {
        }
    }

    private void b(ViewGroup viewGroup, ah ahVar, ah ahVar2) {
        View view = ahVar2.view;
        Matrix matrix = new Matrix((Matrix) ahVar2.values.get("android:changeTransform:parentMatrix"));
        au.b(viewGroup, matrix);
        j a = k.a(view, viewGroup, matrix);
        if (a != null) {
            Transition thisR;
            a.a((ViewGroup) ahVar.values.get("android:changeTransform:parent"), ahVar.view);
            while (thisR.zY != null) {
                thisR = thisR.zY;
            }
            thisR.a(new a(view, a));
            if (xY) {
                if (ahVar.view != ahVar2.view) {
                    au.c(ahVar.view, 0.0f);
                }
                au.c(view, 1.0f);
            }
        }
    }

    private static void w(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private static void a(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        s.i(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }
}
