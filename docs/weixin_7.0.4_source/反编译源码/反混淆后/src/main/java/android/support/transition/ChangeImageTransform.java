package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.transition.C25320ag.C25321a;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    /* renamed from: xS */
    private static final TypeEvaluator<Matrix> f184xS = new C02731();
    /* renamed from: xT */
    private static final Property<ImageView, Matrix> f185xT = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            C41498l.m72489a((ImageView) obj, (Matrix) obj2);
        }
    };
    /* renamed from: xk */
    private static final String[] f186xk = new String[]{"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: android.support.transition.ChangeImageTransform$1 */
    static class C02731 implements TypeEvaluator<Matrix> {
        C02731() {
        }

        public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            return null;
        }
    }

    /* renamed from: android.support.transition.ChangeImageTransform$3 */
    static /* synthetic */ class C02743 {
        /* renamed from: xU */
        static final /* synthetic */ int[] f187xU = new int[ScaleType.values().length];

        static {
            try {
                f187xU[ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f187xU[ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: c */
    private static void m444c(C8368ah c8368ah) {
        View view = c8368ah.view;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Object matrix;
                Map map = c8368ah.values;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                String str = "android:changeImageTransform:matrix";
                switch (C02743.f187xU[imageView.getScaleType().ordinal()]) {
                    case 1:
                        Drawable drawable = imageView.getDrawable();
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(((float) imageView.getWidth()) / ((float) drawable.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable.getIntrinsicHeight()));
                        Matrix matrix3 = matrix2;
                        break;
                    case 2:
                        Drawable drawable2 = imageView.getDrawable();
                        int intrinsicWidth = drawable2.getIntrinsicWidth();
                        int width = imageView.getWidth();
                        float f = ((float) width) / ((float) intrinsicWidth);
                        int intrinsicHeight = drawable2.getIntrinsicHeight();
                        int height = imageView.getHeight();
                        f = Math.max(f, ((float) height) / ((float) intrinsicHeight));
                        float f2 = ((float) intrinsicHeight) * f;
                        intrinsicWidth = Math.round((((float) width) - (((float) intrinsicWidth) * f)) / 2.0f);
                        intrinsicHeight = Math.round((((float) height) - f2) / 2.0f);
                        matrix3 = new Matrix();
                        matrix3.postScale(f, f);
                        matrix3.postTranslate((float) intrinsicWidth, (float) intrinsicHeight);
                        break;
                    default:
                        matrix3 = new Matrix(imageView.getImageMatrix());
                        break;
                }
                map.put(str, matrix3);
            }
        }
    }

    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        m444c(c8368ah);
    }

    /* renamed from: b */
    public final void mo411b(C8368ah c8368ah) {
        m444c(c8368ah);
    }

    public final String[] getTransitionProperties() {
        return f186xk;
    }

    /* renamed from: a */
    public final Animator mo409a(ViewGroup viewGroup, C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah == null || c8368ah2 == null) {
            return null;
        }
        Rect rect = (Rect) c8368ah.values.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) c8368ah2.values.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        int i;
        Object obj = (Matrix) c8368ah.values.get("android:changeImageTransform:matrix");
        Matrix matrix = (Matrix) c8368ah2.values.get("android:changeImageTransform:matrix");
        if (!(obj == null && matrix == null) && (obj == null || !obj.equals(matrix))) {
            i = 0;
        } else {
            i = 1;
        }
        if (rect.equals(rect2) && i != 0) {
            return null;
        }
        Animator ofObject;
        ImageView imageView = (ImageView) c8368ah2.view;
        Drawable drawable = imageView.getDrawable();
        i = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        C41498l.m72487a(imageView);
        if (i == 0 || intrinsicHeight == 0) {
            ofObject = ObjectAnimator.ofObject(imageView, f185xT, f184xS, new Matrix[]{null, null});
        } else {
            if (obj == null) {
                obj = C17422p.f3874vt;
            }
            if (matrix == null) {
                matrix = C17422p.f3874vt;
            }
            f185xT.set(imageView, obj);
            ofObject = ObjectAnimator.ofObject(imageView, f185xT, new C25321a(), new Matrix[]{obj, matrix});
        }
        C41498l.m72488a(imageView, ofObject);
        return ofObject;
    }
}
