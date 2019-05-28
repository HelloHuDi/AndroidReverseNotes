package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class az extends ContextWrapper {
    private static final Object atA = new Object();
    private static ArrayList<WeakReference<az>> atB;
    private final Resources mResources;
    private final Theme mTheme;

    public static Context ad(Context context) {
        Object obj = null;
        if (!((context instanceof az) || (context.getResources() instanceof bb) || (context.getResources() instanceof bh) || (VERSION.SDK_INT >= 21 && !bh.lw()))) {
            obj = 1;
        }
        if (obj == null) {
            return context;
        }
        synchronized (atA) {
            Context context2;
            if (atB == null) {
                atB = new ArrayList();
            } else {
                int size;
                WeakReference weakReference;
                for (size = atB.size() - 1; size >= 0; size--) {
                    weakReference = (WeakReference) atB.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        atB.remove(size);
                    }
                }
                size = atB.size() - 1;
                while (size >= 0) {
                    weakReference = (WeakReference) atB.get(size);
                    context2 = weakReference != null ? (az) weakReference.get() : null;
                    if (context2 == null || context2.getBaseContext() != context) {
                        size--;
                    } else {
                        return context2;
                    }
                }
            }
            context2 = new az(context);
            atB.add(new WeakReference(context2));
            return context2;
        }
    }

    private az(Context context) {
        super(context);
        if (bh.lw()) {
            this.mResources = new bh(this, context.getResources());
            this.mTheme = this.mResources.newTheme();
            this.mTheme.setTo(context.getTheme());
            return;
        }
        this.mResources = new bb(this, context.getResources());
        this.mTheme = null;
    }

    public final Theme getTheme() {
        return this.mTheme == null ? super.getTheme() : this.mTheme;
    }

    public final void setTheme(int i) {
        if (this.mTheme == null) {
            super.setTheme(i);
        } else {
            this.mTheme.applyStyle(i, true);
        }
    }

    public final Resources getResources() {
        return this.mResources;
    }

    public final AssetManager getAssets() {
        return this.mResources.getAssets();
    }
}
