package android.support.p057v4.p058a.p059a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p058a.p059a.C6171g.C0283a;

/* renamed from: android.support.v4.a.a.h */
class C7446h extends C6171g {

    /* renamed from: android.support.v4.a.a.h$a */
    static class C6172a extends C0283a {
        C6172a(C0283a c0283a) {
            super(c0283a);
        }

        public final Drawable newDrawable(Resources resources) {
            return new C7446h(this, resources);
        }
    }

    C7446h(Drawable drawable) {
        super(drawable);
    }

    C7446h(C0283a c0283a, Resources resources) {
        super(c0283a, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.mDrawable.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: dD */
    public C0283a mo13723dD() {
        return new C6172a(this.f1735HG);
    }
}
