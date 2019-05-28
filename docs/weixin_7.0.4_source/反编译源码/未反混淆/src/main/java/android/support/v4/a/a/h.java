package android.support.v4.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class h extends g {

    static class a extends a {
        a(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new h(this, resources);
        }
    }

    h(Drawable drawable) {
        super(drawable);
    }

    h(a aVar, Resources resources) {
        super(aVar, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.mDrawable.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    /* Access modifiers changed, original: 0000 */
    public a dD() {
        return new a(this.HG);
    }
}
