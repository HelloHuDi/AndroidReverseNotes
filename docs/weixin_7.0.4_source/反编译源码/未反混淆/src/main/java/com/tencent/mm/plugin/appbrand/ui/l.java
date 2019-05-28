package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.b;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.v;

public final class l extends ContextThemeWrapper {
    private Resources iJr;
    private LayoutInflater iJs;

    static final class a extends b {
        private Configuration YO;
        private final Resources iJt;
        private DisplayMetrics iJu;

        a(Resources resources, DisplayMetrics displayMetrics) {
            super(resources);
            AppMethodBeat.i(133164);
            this.iJt = resources;
            this.iJu = displayMetrics;
            Configuration configuration = new Configuration(this.iJt.getConfiguration());
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(this.iJt.getDisplayMetrics());
            updateConfiguration(configuration, displayMetrics2);
            AppMethodBeat.o(133164);
        }

        public final DisplayMetrics getDisplayMetrics() {
            AppMethodBeat.i(133165);
            DisplayMetrics displayMetrics;
            if (this.iJu != null) {
                displayMetrics = this.iJu;
                AppMethodBeat.o(133165);
                return displayMetrics;
            }
            displayMetrics = super.getDisplayMetrics();
            AppMethodBeat.o(133165);
            return displayMetrics;
        }

        public final Configuration getConfiguration() {
            AppMethodBeat.i(133166);
            Configuration configuration;
            if (this.YO != null) {
                configuration = this.YO;
                AppMethodBeat.o(133166);
                return configuration;
            }
            configuration = super.getConfiguration();
            AppMethodBeat.o(133166);
            return configuration;
        }

        private Drawable r(Drawable drawable) {
            AppMethodBeat.i(138144);
            if ((drawable instanceof BitmapDrawable) && this.iJu != null) {
                ((BitmapDrawable) drawable).setTargetDensity(this.iJu.densityDpi);
            }
            AppMethodBeat.o(138144);
            return drawable;
        }

        public final Drawable getDrawable(int i) {
            AppMethodBeat.i(138145);
            Drawable drawableForDensity;
            if (this.iJu != null) {
                drawableForDensity = getDrawableForDensity(i, this.iJu.densityDpi);
                AppMethodBeat.o(138145);
                return drawableForDensity;
            }
            drawableForDensity = r(this.iJt.getDrawable(i));
            AppMethodBeat.o(138145);
            return drawableForDensity;
        }

        public final Drawable getDrawable(int i, Theme theme) {
            Drawable drawableForDensity;
            AppMethodBeat.i(138146);
            try {
                if (this.iJu != null) {
                    drawableForDensity = getDrawableForDensity(i, this.iJu.densityDpi, theme);
                    AppMethodBeat.o(138146);
                    return drawableForDensity;
                }
            } catch (NoSuchMethodError e) {
                ab.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", e, "getDrawable(id, theme)", new Object[0]);
                if (theme == null) {
                    drawableForDensity = getDrawableForDensity(i, this.iJu.densityDpi);
                    AppMethodBeat.o(138146);
                    return drawableForDensity;
                }
            }
            drawableForDensity = r(this.iJt.getDrawable(i, theme));
            AppMethodBeat.o(138146);
            return drawableForDensity;
        }

        public final Drawable getDrawableForDensity(int i, int i2) {
            AppMethodBeat.i(138147);
            if (i2 == 0 && this.iJu != null) {
                i2 = this.iJu.densityDpi;
            }
            Drawable drawableForDensity = this.iJt.getDrawableForDensity(i, i2);
            AppMethodBeat.o(138147);
            return drawableForDensity;
        }

        public final Drawable getDrawableForDensity(int i, int i2, Theme theme) {
            AppMethodBeat.i(138148);
            if (i2 == 0 && this.iJu != null) {
                i2 = this.iJu.densityDpi;
            }
            Drawable drawableForDensity = this.iJt.getDrawableForDensity(i, i2, theme);
            AppMethodBeat.o(138148);
            return drawableForDensity;
        }

        public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
            AppMethodBeat.i(133167);
            if (this.iJu != null) {
                this.iJu = com.tencent.mm.ca.a.d(displayMetrics);
                this.YO = new Configuration(configuration);
                this.YO.densityDpi = this.iJu.densityDpi;
                super.updateConfiguration(this.YO, this.iJu);
                this.iJt.updateConfiguration(configuration, displayMetrics);
                AppMethodBeat.o(133167);
                return;
            }
            super.updateConfiguration(configuration, displayMetrics);
            AppMethodBeat.o(133167);
        }
    }

    public l(Context context) {
        AppMethodBeat.i(133168);
        super.attachBaseContext(context);
        if (com.tencent.mm.ca.a.dmL() && !com.tencent.mm.ca.a.dmM()) {
            this.iJr = new a(context.getResources(), com.tencent.mm.ca.a.d(context.getResources().getDisplayMetrics()));
            if (VERSION.SDK_INT >= 21) {
                getTheme().getResources().getDisplayMetrics().setTo(this.iJr.getDisplayMetrics());
            }
        }
        AppMethodBeat.o(133168);
    }

    public final Object getSystemService(String str) {
        AppMethodBeat.i(138149);
        Object systemService;
        if (!"layout_inflater".equals(str)) {
            systemService = super.getSystemService(str);
            AppMethodBeat.o(138149);
            return systemService;
        } else if (this.iJs != null) {
            LayoutInflater layoutInflater = this.iJs;
            AppMethodBeat.o(138149);
            return layoutInflater;
        } else {
            systemService = v.a((LayoutInflater) super.getSystemService("layout_inflater"));
            this.iJs = systemService;
            AppMethodBeat.o(138149);
            return systemService;
        }
    }

    public final Resources getResources() {
        AppMethodBeat.i(133169);
        Resources resources;
        if (getAssets() == null || this.iJr == null) {
            resources = super.getResources();
            AppMethodBeat.o(133169);
            return resources;
        }
        resources = this.iJr;
        AppMethodBeat.o(133169);
        return resources;
    }
}
