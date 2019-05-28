package android.support.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* renamed from: android.support.transition.z */
final class C37110z implements TypeEvaluator<Rect> {
    private Rect mRect;

    public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        Rect rect = (Rect) obj;
        Rect rect2 = (Rect) obj2;
        int i = ((int) (((float) (rect2.left - rect.left)) * f)) + rect.left;
        int i2 = ((int) (((float) (rect2.top - rect.top)) * f)) + rect.top;
        int i3 = ((int) (((float) (rect2.right - rect.right)) * f)) + rect.right;
        int i4 = ((int) (((float) (rect2.bottom - rect.bottom)) * f)) + rect.bottom;
        if (this.mRect == null) {
            return new Rect(i, i2, i3, i4);
        }
        this.mRect.set(i, i2, i3, i4);
        return this.mRect;
    }

    C37110z() {
    }

    C37110z(Rect rect) {
        this.mRect = rect;
    }
}
