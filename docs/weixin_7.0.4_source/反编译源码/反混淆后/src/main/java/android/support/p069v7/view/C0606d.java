package android.support.p069v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.view.d */
public final class C0606d extends ContextWrapper {
    /* renamed from: YN */
    public int f942YN;
    /* renamed from: YO */
    private Configuration f943YO;
    private LayoutInflater mInflater;
    private Resources mResources;
    private Theme mTheme;

    public C0606d() {
        super(null);
    }

    public C0606d(Context context, int i) {
        super(context);
        this.f942YN = i;
    }

    public C0606d(Context context, Theme theme) {
        super(context);
        this.mTheme = theme;
    }

    /* Access modifiers changed, original: protected|final */
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void setTheme(int i) {
        if (this.f942YN != i) {
            this.f942YN = i;
            m1311gb();
        }
    }

    public final Theme getTheme() {
        if (this.mTheme != null) {
            return this.mTheme;
        }
        if (this.f942YN == 0) {
            this.f942YN = C25738R.style.f11244u5;
        }
        m1311gb();
        return this.mTheme;
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.mInflater;
    }

    /* renamed from: gb */
    private void m1311gb() {
        if (this.mTheme == null) {
            this.mTheme = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        this.mTheme.applyStyle(this.f942YN, true);
    }

    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    public final Resources getResources() {
        if (this.mResources == null) {
            if (this.f943YO == null) {
                this.mResources = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.mResources = createConfigurationContext(this.f943YO).getResources();
            }
        }
        return this.mResources;
    }
}
