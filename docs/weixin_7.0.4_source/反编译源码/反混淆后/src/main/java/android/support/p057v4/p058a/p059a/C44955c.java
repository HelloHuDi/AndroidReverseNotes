package android.support.p057v4.p058a.p059a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: android.support.v4.a.a.c */
final class C44955c extends C37111b {
    protected C44955c(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public final void getOutline(Outline outline) {
        mo59159dz();
        outline.setRoundRect(this.f15755Hx, this.f15758rf);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo59156a(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }
}
