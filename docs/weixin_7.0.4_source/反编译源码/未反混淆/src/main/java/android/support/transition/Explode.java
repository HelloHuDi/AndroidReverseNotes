package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.R;

public class Explode extends Visibility {
    private static final TimeInterpolator yp = new DecelerateInterpolator();
    private static final TimeInterpolator yq = new AccelerateInterpolator();
    private int[] yr;

    public Explode() {
        this.yr = new int[2];
        a((af) new e());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yr = new int[2];
        a((af) new e());
    }

    private void c(ah ahVar) {
        View view = ahVar.view;
        view.getLocationOnScreen(this.yr);
        int i = this.yr[0];
        int i2 = this.yr[1];
        ahVar.values.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    public final void a(ah ahVar) {
        super.a(ahVar);
        c(ahVar);
    }

    public final void b(ah ahVar) {
        super.b(ahVar);
        c(ahVar);
    }

    public final Animator a(ViewGroup viewGroup, View view, ah ahVar, ah ahVar2) {
        if (ahVar2 == null) {
            return null;
        }
        Rect rect = (Rect) ahVar2.values.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a((View) viewGroup, rect, this.yr);
        return aj.a(view, ahVar2, rect.left, rect.top, translationX + ((float) this.yr[0]), translationY + ((float) this.yr[1]), translationX, translationY, yp);
    }

    public final Animator a(ViewGroup viewGroup, View view, ah ahVar) {
        if (ahVar == null) {
            return null;
        }
        float f;
        float f2;
        Rect rect = (Rect) ahVar.values.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) ahVar.view.getTag(R.id.d1);
        if (iArr != null) {
            f = translationX + ((float) (iArr[0] - rect.left));
            float f3 = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
            f2 = f3;
        } else {
            f2 = translationY;
            f = translationX;
        }
        a((View) viewGroup, rect, this.yr);
        return aj.a(view, ahVar, i, i2, translationX, translationY, f + ((float) this.yr[0]), f2 + ((float) this.yr[1]), yq);
    }

    private void a(View view, Rect rect, int[] iArr) {
        int width;
        int height;
        view.getLocationOnScreen(this.yr);
        int i = this.yr[0];
        int i2 = this.yr[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            width = ((view.getWidth() / 2) + i) + Math.round(view.getTranslationX());
            height = ((view.getHeight() / 2) + i2) + Math.round(view.getTranslationY());
        } else {
            width = epicenter.centerX();
            height = epicenter.centerY();
        }
        float centerX = (float) (rect.centerX() - width);
        float centerY = (float) (rect.centerY() - height);
        if (centerX == 0.0f && centerY == 0.0f) {
            centerX = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float q = q(centerX, centerY);
        centerX /= q;
        centerY /= q;
        float f = f(view, width - i, height - i2);
        iArr[0] = Math.round(centerX * f);
        iArr[1] = Math.round(f * centerY);
    }

    private static float f(View view, int i, int i2) {
        return q((float) Math.max(i, view.getWidth() - i), (float) Math.max(i2, view.getHeight() - i2));
    }

    private static float q(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
