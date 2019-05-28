package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p069v7.app.C0576d;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.widget.bh */
public final class C0706bh extends Resources {
    private final WeakReference<Context> atF;

    /* renamed from: lw */
    public static boolean m1569lw() {
        return C0576d.m1256fm() && VERSION.SDK_INT <= 20;
    }

    public C0706bh(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.atF = new WeakReference(context);
    }

    public final Drawable getDrawable(int i) {
        Context context = (Context) this.atF.get();
        if (context == null) {
            return super.getDrawable(i);
        }
        C0716i hE = C0716i.m1606hE();
        Drawable n = hE.mo2084n(context, i);
        if (n == null) {
            n = super.getDrawable(i);
        }
        if (n != null) {
            return hE.mo2083a(context, i, false, n);
        }
        return null;
    }
}
