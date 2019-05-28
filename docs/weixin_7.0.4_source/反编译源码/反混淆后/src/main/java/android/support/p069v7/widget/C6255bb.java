package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.bb */
final class C6255bb extends C0690ap {
    private final WeakReference<Context> atF;

    public C6255bb(Context context, Resources resources) {
        super(resources);
        this.atF = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.atF.get();
        if (!(drawable == null || context == null)) {
            C0716i.m1606hE();
            C0716i.m1600a(context, i, drawable);
        }
        return drawable;
    }
}
