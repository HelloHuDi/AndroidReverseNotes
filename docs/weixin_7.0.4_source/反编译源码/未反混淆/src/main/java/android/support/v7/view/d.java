package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import com.tencent.mm.R;

public final class d extends ContextWrapper {
    public int YN;
    private Configuration YO;
    private LayoutInflater mInflater;
    private Resources mResources;
    private Theme mTheme;

    public d() {
        super(null);
    }

    public d(Context context, int i) {
        super(context);
        this.YN = i;
    }

    public d(Context context, Theme theme) {
        super(context);
        this.mTheme = theme;
    }

    /* Access modifiers changed, original: protected|final */
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void setTheme(int i) {
        if (this.YN != i) {
            this.YN = i;
            gb();
        }
    }

    public final Theme getTheme() {
        if (this.mTheme != null) {
            return this.mTheme;
        }
        if (this.YN == 0) {
            this.YN = R.style.u5;
        }
        gb();
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

    private void gb() {
        if (this.mTheme == null) {
            this.mTheme = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        this.mTheme.applyStyle(this.YN, true);
    }

    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    public final Resources getResources() {
        if (this.mResources == null) {
            if (this.YO == null) {
                this.mResources = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.mResources = createConfigurationContext(this.YO).getResources();
            }
        }
        return this.mResources;
    }
}
