package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

final class bb extends ap {
    private final WeakReference<Context> atF;

    public bb(Context context, Resources resources) {
        super(resources);
        this.atF = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.atF.get();
        if (!(drawable == null || context == null)) {
            i.hE();
            i.a(context, i, drawable);
        }
        return drawable;
    }
}
