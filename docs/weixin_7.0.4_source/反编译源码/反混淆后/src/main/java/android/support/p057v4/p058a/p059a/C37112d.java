package android.support.p057v4.p058a.p059a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0456d;

/* renamed from: android.support.v4.a.a.d */
public final class C37112d {

    /* renamed from: android.support.v4.a.a.d$a */
    static class C37113a extends C37111b {
        C37113a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo59156a(int i, int i2, int i3, Rect rect, Rect rect2) {
            C0456d.apply(i, i2, i3, rect, rect2, 0);
        }
    }

    /* renamed from: a */
    public static C37111b m62123a(Resources resources, Bitmap bitmap) {
        if (VERSION.SDK_INT >= 21) {
            return new C44955c(resources, bitmap);
        }
        return new C37113a(resources, bitmap);
    }
}
