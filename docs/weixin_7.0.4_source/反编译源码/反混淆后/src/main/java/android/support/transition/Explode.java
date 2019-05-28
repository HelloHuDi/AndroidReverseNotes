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

public class Explode extends Visibility {
    /* renamed from: yp */
    private static final TimeInterpolator f16763yp = new DecelerateInterpolator();
    /* renamed from: yq */
    private static final TimeInterpolator f16764yq = new AccelerateInterpolator();
    /* renamed from: yr */
    private int[] f16765yr;

    public Explode() {
        this.f16765yr = new int[2];
        mo42273a((C37104af) new C16504e());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16765yr = new int[2];
        mo42273a((C37104af) new C16504e());
    }

    /* renamed from: c */
    private void m72466c(C8368ah c8368ah) {
        View view = c8368ah.view;
        view.getLocationOnScreen(this.f16765yr);
        int i = this.f16765yr[0];
        int i2 = this.f16765yr[1];
        c8368ah.values.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        super.mo410a(c8368ah);
        m72466c(c8368ah);
    }

    /* renamed from: b */
    public final void mo411b(C8368ah c8368ah) {
        super.mo411b(c8368ah);
        m72466c(c8368ah);
    }

    /* renamed from: a */
    public final Animator mo18283a(ViewGroup viewGroup, View view, C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah2 == null) {
            return null;
        }
        Rect rect = (Rect) c8368ah2.values.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        m72465a((View) viewGroup, rect, this.f16765yr);
        return C8369aj.m14773a(view, c8368ah2, rect.left, rect.top, translationX + ((float) this.f16765yr[0]), translationY + ((float) this.f16765yr[1]), translationX, translationY, f16763yp);
    }

    /* renamed from: a */
    public final Animator mo18282a(ViewGroup viewGroup, View view, C8368ah c8368ah) {
        if (c8368ah == null) {
            return null;
        }
        float f;
        float f2;
        Rect rect = (Rect) c8368ah.values.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c8368ah.view.getTag(2131820682);
        if (iArr != null) {
            f = translationX + ((float) (iArr[0] - rect.left));
            float f3 = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
            f2 = f3;
        } else {
            f2 = translationY;
            f = translationX;
        }
        m72465a((View) viewGroup, rect, this.f16765yr);
        return C8369aj.m14773a(view, c8368ah, i, i2, translationX, translationY, f + ((float) this.f16765yr[0]), f2 + ((float) this.f16765yr[1]), f16764yq);
    }

    /* renamed from: a */
    private void m72465a(View view, Rect rect, int[] iArr) {
        int width;
        int height;
        view.getLocationOnScreen(this.f16765yr);
        int i = this.f16765yr[0];
        int i2 = this.f16765yr[1];
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
        float q = m72468q(centerX, centerY);
        centerX /= q;
        centerY /= q;
        float f = m72467f(view, width - i, height - i2);
        iArr[0] = Math.round(centerX * f);
        iArr[1] = Math.round(f * centerY);
    }

    /* renamed from: f */
    private static float m72467f(View view, int i, int i2) {
        return m72468q((float) Math.max(i, view.getWidth() - i), (float) Math.max(i2, view.getHeight() - i2));
    }

    /* renamed from: q */
    private static float m72468q(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
