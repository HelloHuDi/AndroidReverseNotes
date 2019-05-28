package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    private static final TypeEvaluator<Matrix> xS = new TypeEvaluator<Matrix>() {
        public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            return null;
        }
    };
    private static final Property<ImageView, Matrix> xT = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            l.a((ImageView) obj, (Matrix) obj2);
        }
    };
    private static final String[] xk = new String[]{"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: android.support.transition.ChangeImageTransform$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] xU = new int[ScaleType.values().length];

        static {
            try {
                xU[ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                xU[ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void c(ah ahVar) {
        View view = ahVar.view;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Object matrix;
                Map map = ahVar.values;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                String str = "android:changeImageTransform:matrix";
                switch (AnonymousClass3.xU[imageView.getScaleType().ordinal()]) {
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

    public final void a(ah ahVar) {
        c(ahVar);
    }

    public final void b(ah ahVar) {
        c(ahVar);
    }

    public final String[] getTransitionProperties() {
        return xk;
    }

    public final Animator a(ViewGroup viewGroup, ah ahVar, ah ahVar2) {
        if (ahVar == null || ahVar2 == null) {
            return null;
        }
        Rect rect = (Rect) ahVar.values.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) ahVar2.values.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        int i;
        Object obj = (Matrix) ahVar.values.get("android:changeImageTransform:matrix");
        Matrix matrix = (Matrix) ahVar2.values.get("android:changeImageTransform:matrix");
        if (!(obj == null && matrix == null) && (obj == null || !obj.equals(matrix))) {
            i = 0;
        } else {
            i = 1;
        }
        if (rect.equals(rect2) && i != 0) {
            return null;
        }
        Animator ofObject;
        ImageView imageView = (ImageView) ahVar2.view;
        Drawable drawable = imageView.getDrawable();
        i = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        l.a(imageView);
        if (i == 0 || intrinsicHeight == 0) {
            ofObject = ObjectAnimator.ofObject(imageView, xT, xS, new Matrix[]{null, null});
        } else {
            if (obj == null) {
                obj = p.vt;
            }
            if (matrix == null) {
                matrix = p.vt;
            }
            xT.set(imageView, obj);
            ofObject = ObjectAnimator.ofObject(imageView, xT, new a(), new Matrix[]{obj, matrix});
        }
        l.a(imageView, ofObject);
        return ofObject;
    }
}
