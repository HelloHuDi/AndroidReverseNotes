package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.d;
import java.lang.ref.WeakReference;

public final class bh extends Resources {
    private final WeakReference<Context> atF;

    public static boolean lw() {
        return d.fm() && VERSION.SDK_INT <= 20;
    }

    public bh(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.atF = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Context context = (Context) this.atF.get();
        if (context == null) {
            return super.getDrawable(i);
        }
        i hE = i.hE();
        Drawable n = hE.n(context, i);
        if (n == null) {
            n = super.getDrawable(i);
        }
        if (n != null) {
            return hE.a(context, i, false, n);
        }
        return null;
    }
}
