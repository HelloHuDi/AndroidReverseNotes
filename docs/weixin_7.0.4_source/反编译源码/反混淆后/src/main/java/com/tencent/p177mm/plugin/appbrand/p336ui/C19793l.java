package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p069v7.widget.C17496b;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p210ca.C32432a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.l */
public final class C19793l extends ContextThemeWrapper {
    private Resources iJr;
    private LayoutInflater iJs;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.l$a */
    static final class C19794a extends C17496b {
        /* renamed from: YO */
        private Configuration f4358YO;
        private final Resources iJt;
        private DisplayMetrics iJu;

        C19794a(Resources resources, DisplayMetrics displayMetrics) {
            super(resources);
            AppMethodBeat.m2504i(133164);
            this.iJt = resources;
            this.iJu = displayMetrics;
            Configuration configuration = new Configuration(this.iJt.getConfiguration());
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(this.iJt.getDisplayMetrics());
            updateConfiguration(configuration, displayMetrics2);
            AppMethodBeat.m2505o(133164);
        }

        public final DisplayMetrics getDisplayMetrics() {
            AppMethodBeat.m2504i(133165);
            DisplayMetrics displayMetrics;
            if (this.iJu != null) {
                displayMetrics = this.iJu;
                AppMethodBeat.m2505o(133165);
                return displayMetrics;
            }
            displayMetrics = super.getDisplayMetrics();
            AppMethodBeat.m2505o(133165);
            return displayMetrics;
        }

        public final Configuration getConfiguration() {
            AppMethodBeat.m2504i(133166);
            Configuration configuration;
            if (this.f4358YO != null) {
                configuration = this.f4358YO;
                AppMethodBeat.m2505o(133166);
                return configuration;
            }
            configuration = super.getConfiguration();
            AppMethodBeat.m2505o(133166);
            return configuration;
        }

        /* renamed from: r */
        private Drawable m30630r(Drawable drawable) {
            AppMethodBeat.m2504i(138144);
            if ((drawable instanceof BitmapDrawable) && this.iJu != null) {
                ((BitmapDrawable) drawable).setTargetDensity(this.iJu.densityDpi);
            }
            AppMethodBeat.m2505o(138144);
            return drawable;
        }

        public final Drawable getDrawable(int i) {
            AppMethodBeat.m2504i(138145);
            Drawable drawableForDensity;
            if (this.iJu != null) {
                drawableForDensity = getDrawableForDensity(i, this.iJu.densityDpi);
                AppMethodBeat.m2505o(138145);
                return drawableForDensity;
            }
            drawableForDensity = m30630r(this.iJt.getDrawable(i));
            AppMethodBeat.m2505o(138145);
            return drawableForDensity;
        }

        public final Drawable getDrawable(int i, Theme theme) {
            Drawable drawableForDensity;
            AppMethodBeat.m2504i(138146);
            try {
                if (this.iJu != null) {
                    drawableForDensity = getDrawableForDensity(i, this.iJu.densityDpi, theme);
                    AppMethodBeat.m2505o(138146);
                    return drawableForDensity;
                }
            } catch (NoSuchMethodError e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", e, "getDrawable(id, theme)", new Object[0]);
                if (theme == null) {
                    drawableForDensity = getDrawableForDensity(i, this.iJu.densityDpi);
                    AppMethodBeat.m2505o(138146);
                    return drawableForDensity;
                }
            }
            drawableForDensity = m30630r(this.iJt.getDrawable(i, theme));
            AppMethodBeat.m2505o(138146);
            return drawableForDensity;
        }

        public final Drawable getDrawableForDensity(int i, int i2) {
            AppMethodBeat.m2504i(138147);
            if (i2 == 0 && this.iJu != null) {
                i2 = this.iJu.densityDpi;
            }
            Drawable drawableForDensity = this.iJt.getDrawableForDensity(i, i2);
            AppMethodBeat.m2505o(138147);
            return drawableForDensity;
        }

        public final Drawable getDrawableForDensity(int i, int i2, Theme theme) {
            AppMethodBeat.m2504i(138148);
            if (i2 == 0 && this.iJu != null) {
                i2 = this.iJu.densityDpi;
            }
            Drawable drawableForDensity = this.iJt.getDrawableForDensity(i, i2, theme);
            AppMethodBeat.m2505o(138148);
            return drawableForDensity;
        }

        public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
            AppMethodBeat.m2504i(133167);
            if (this.iJu != null) {
                this.iJu = C32432a.m53094d(displayMetrics);
                this.f4358YO = new Configuration(configuration);
                this.f4358YO.densityDpi = this.iJu.densityDpi;
                super.updateConfiguration(this.f4358YO, this.iJu);
                this.iJt.updateConfiguration(configuration, displayMetrics);
                AppMethodBeat.m2505o(133167);
                return;
            }
            super.updateConfiguration(configuration, displayMetrics);
            AppMethodBeat.m2505o(133167);
        }
    }

    public C19793l(Context context) {
        AppMethodBeat.m2504i(133168);
        super.attachBaseContext(context);
        if (C32432a.dmL() && !C32432a.dmM()) {
            this.iJr = new C19794a(context.getResources(), C32432a.m53094d(context.getResources().getDisplayMetrics()));
            if (VERSION.SDK_INT >= 21) {
                getTheme().getResources().getDisplayMetrics().setTo(this.iJr.getDisplayMetrics());
            }
        }
        AppMethodBeat.m2505o(133168);
    }

    public final Object getSystemService(String str) {
        AppMethodBeat.m2504i(138149);
        Object systemService;
        if (!"layout_inflater".equals(str)) {
            systemService = super.getSystemService(str);
            AppMethodBeat.m2505o(138149);
            return systemService;
        } else if (this.iJs != null) {
            LayoutInflater layoutInflater = this.iJs;
            AppMethodBeat.m2505o(138149);
            return layoutInflater;
        } else {
            systemService = C5616v.m8408a((LayoutInflater) super.getSystemService("layout_inflater"));
            this.iJs = systemService;
            AppMethodBeat.m2505o(138149);
            return systemService;
        }
    }

    public final Resources getResources() {
        AppMethodBeat.m2504i(133169);
        Resources resources;
        if (getAssets() == null || this.iJr == null) {
            resources = super.getResources();
            AppMethodBeat.m2505o(133169);
            return resources;
        }
        resources = this.iJr;
        AppMethodBeat.m2505o(133169);
        return resources;
    }
}
