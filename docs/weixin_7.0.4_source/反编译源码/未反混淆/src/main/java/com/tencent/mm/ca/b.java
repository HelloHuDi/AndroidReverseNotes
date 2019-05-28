package com.tencent.mm.ca;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Picture;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.jsapi.contact.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.ui.ae;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class b extends Resources {
    private static Method xuA = null;
    private static Method xuB = null;
    private Resources mResources;
    private f xuw;
    private d xux;
    private boolean xuy;
    private a xuz;

    public static class a<E> extends ArrayList<E> {
        public final boolean add(E e) {
            AppMethodBeat.i(105885);
            ab.i("InterceptArrayList", "InterceptArrayList.add");
            AppMethodBeat.o(105885);
            return true;
        }

        public final void add(int i, E e) {
            AppMethodBeat.i(105886);
            ab.i("InterceptArrayList", "InterceptArrayList.add index object");
            AppMethodBeat.o(105886);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065 A:{Catch:{ NoSuchFieldException -> 0x00d1, IllegalAccessException -> 0x00de, IllegalArgumentException -> 0x00eb }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private b(Resources resources, f fVar, d dVar, a aVar) {
        c cVar;
        super(resources.getAssets(), aVar.getDisplayMetrics(), aVar.b(resources.getConfiguration()));
        AppMethodBeat.i(105887);
        this.xuz = aVar;
        this.xuw = fVar;
        if (resources instanceof b) {
            this.mResources = ((b) resources).mResources;
        } else {
            this.mResources = resources;
        }
        this.xux = dVar;
        try {
            Field declaredField;
            Class cls = Class.forName("android.content.res.MiuiResources");
            if (cls != null) {
                ab.i("MicroMsg.MMResources", "sMiuiThemeEnabled false");
                declaredField = cls.getDeclaredField("sMiuiThemeEnabled");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.set(null, Boolean.FALSE);
                    cVar = new c(getAssets(), "mThemeCookies", null);
                    if (cVar.Mg()) {
                        cVar.set(new a());
                    }
                    this.xuy = ah.doB().getBoolean("ShowStringName", false);
                    ab.i("MicroMsg.MMResources", "originalResources:%s mmresource:%s", resources, this);
                    AppMethodBeat.o(105887);
                }
            }
            declaredField = null;
            ab.e("MicroMsg.MMResources", "some thing wrong. %s %s", cls, declaredField);
        } catch (ClassNotFoundException e) {
            ab.i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
        } catch (NoSuchFieldException e2) {
            ab.i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
        } catch (IllegalAccessException e3) {
            ab.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
        } catch (IllegalArgumentException e4) {
            ab.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
        }
        cVar = new c(getAssets(), "mThemeCookies", null);
        try {
            if (cVar.Mg()) {
            }
        } catch (NoSuchFieldException e5) {
            ab.printErrStackTrace("MicroMsg.MMResources", e5, "", new Object[0]);
        } catch (IllegalAccessException e6) {
            ab.printErrStackTrace("MicroMsg.MMResources", e6, "", new Object[0]);
        } catch (IllegalArgumentException e7) {
            ab.printErrStackTrace("MicroMsg.MMResources", e7, "", new Object[0]);
        }
        try {
            this.xuy = ah.doB().getBoolean("ShowStringName", false);
        } catch (Exception e8) {
            ab.e("MicroMsg.MMResources", e8.getMessage());
        }
        ab.i("MicroMsg.MMResources", "originalResources:%s mmresource:%s", resources, this);
        AppMethodBeat.o(105887);
    }

    public final DisplayMetrics getDisplayMetrics() {
        AppMethodBeat.i(105888);
        DisplayMetrics displayMetrics = this.xuz.getDisplayMetrics();
        AppMethodBeat.o(105888);
        return displayMetrics;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(105889);
        ab.i("MicroMsg.MMResources", "locale %s, orientation %s", configuration.locale, Integer.valueOf(configuration.orientation));
        a aVar = this.xuz;
        DisplayMetrics displayMetrics = this.mResources.getDisplayMetrics();
        if (aVar.dmR()) {
            displayMetrics.density = aVar.aDu.density;
            displayMetrics.densityDpi = aVar.aDu.densityDpi;
            displayMetrics.scaledDensity = aVar.aDu.scaledDensity;
            aVar.aDu.setTo(displayMetrics);
        }
        super.updateConfiguration(this.xuz.b(configuration), getDisplayMetrics());
        AppMethodBeat.o(105889);
    }

    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        AppMethodBeat.i(105890);
        super.updateConfiguration(configuration, displayMetrics);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, displayMetrics);
        }
        if (this.xuz != null) {
            Object obj;
            DisplayMetrics displayMetrics2;
            int i;
            float f;
            int min;
            a aVar = this.xuz;
            int i2 = as.amF(ah.doA()).getInt(a.xus, 0);
            ae.dMw();
            int i3 = ae.dMw().densityDpi;
            if (i2 == 0) {
                as.amF(ah.doA()).putInt(a.xus, i3);
            }
            ab.i("MicroMsg.MMDensityManager", "dancy test checkDensity, mDensityDpi:%s,  mCurrentDensityDpi:%s", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 || i2 == i3) {
                obj = null;
            } else {
                as.amF(ah.doA()).putInt(a.xus, i3);
                obj = 1;
            }
            if (obj != null) {
                ab.i("MicroMsg.MMDensityManager", "checkDensity density change, mIcheckDensitylistener:%s", a.xuv);
                if (a.xuv != null) {
                    a.xuv.Bj();
                }
            }
            boolean z = as.amF(ah.doA()).getBoolean(a.xut, false);
            boolean z2 = as.amF(ah.doA()).getBoolean(a.yaj, false);
            if (!z) {
                try {
                    displayMetrics2 = new DisplayMetrics();
                    ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
                    i2 = displayMetrics2.widthPixels;
                    i = displayMetrics2.heightPixels;
                    float f2 = displayMetrics2.density;
                    f = aVar.getDisplayMetrics().density;
                    min = (int) (((float) Math.min(i2, i)) / f2);
                    h.pYm.e(17089, Integer.valueOf(i2), Integer.valueOf(i), Float.toString(f2), Float.toString(f), Integer.valueOf(min), Integer.valueOf(ae.dzh()), Integer.valueOf(ae.dMx()), Integer.valueOf(ae.getDeviceWidth()), Integer.valueOf(Math.min(aVar.xuq.widthPixels, aVar.xuq.heightPixels)), Float.valueOf(a.xuu));
                    as.amF(ah.doA()).putBoolean(a.xut, true);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "", new Object[0]);
                }
            }
            if (ae.dzh() != 0) {
                i = Math.round(((float) ae.getDeviceWidth()) / (((float) ae.dzh()) / 160.0f));
            } else {
                i = 0;
            }
            DisplayMetrics dMw = ae.dMw();
            Object obj2 = Math.round(((float) Math.min(dMw.heightPixels, dMw.widthPixels)) / dMw.density) >= e.CTRL_INDEX ? 1 : null;
            if (!(((i >= e.CTRL_INDEX ? 1 : null) == null && obj2 == null) || z2)) {
                i2 = dMw.widthPixels;
                i3 = dMw.heightPixels;
                float f3 = dMw.density;
                f = aVar.getDisplayMetrics().density;
                int min2 = (int) (((float) Math.min(i2, i3)) / f3);
                h.pYm.e(17305, Integer.valueOf(i), Integer.valueOf(min), Integer.valueOf(i2), Integer.valueOf(i3), Float.toString(f3), Float.toString(f), Integer.valueOf(min2), Integer.valueOf(ae.dzh()), Integer.valueOf(ae.dMx()), Integer.valueOf(ae.getDeviceWidth()), Integer.valueOf(Math.min(aVar.xuq.widthPixels, aVar.xuq.heightPixels)), Float.valueOf(a.xuu));
                as.amF(ah.doA()).putBoolean(a.yaj, true);
            }
            if (aVar.dmR()) {
                aVar.dmQ();
                ((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
                ab.i("MicroMsg.MMDensityManager", " \n************************************************************************* \nTarget -> %s \nCurrent -> %s \nWindowManager -> %s \nConfiguration -> %s fontScale -> %s", a.e(aVar.aDu), a.e(displayMetrics), a.e(displayMetrics2), Integer.valueOf(configuration.densityDpi), Float.valueOf(configuration.fontScale));
            }
        }
        AppMethodBeat.o(105890);
    }

    public static Resources a(Resources resources, Context context) {
        AppMethodBeat.i(105891);
        b bVar = new b(resources, f.gf(context), new d(), new a(resources.getDisplayMetrics()));
        AppMethodBeat.o(105891);
        return bVar;
    }

    public static Resources a(Resources resources, Context context, String str) {
        AppMethodBeat.i(105892);
        b bVar = new b(resources, f.bG(context, str), new d(), new a(resources.getDisplayMetrics()));
        AppMethodBeat.o(105892);
        return bVar;
    }

    private boolean dmT() {
        AppMethodBeat.i(105893);
        if (this.xuw == null || !f.dmT()) {
            AppMethodBeat.o(105893);
            return false;
        }
        AppMethodBeat.o(105893);
        return true;
    }

    public final CharSequence getText(int i) {
        CharSequence charSequence;
        AppMethodBeat.i(105894);
        if (this.xuy) {
            try {
                String resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.o(105894);
                return resourceEntryName;
            } catch (Exception e) {
                charSequence = "";
                AppMethodBeat.o(105894);
                return charSequence;
            }
        }
        if (dmT()) {
            charSequence = f.d(i, f.getString(i));
            if (charSequence != null) {
                AppMethodBeat.o(105894);
                return charSequence;
            }
        }
        charSequence = f.d(i, this.mResources.getString(i));
        if (charSequence != null) {
            charSequence = charSequence.toString();
            AppMethodBeat.o(105894);
            return charSequence;
        }
        charSequence = this.mResources.getString(i);
        AppMethodBeat.o(105894);
        return charSequence;
    }

    public final CharSequence getText(int i, CharSequence charSequence) {
        CharSequence charSequence2;
        AppMethodBeat.i(105895);
        if (this.xuy) {
            try {
                String resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.o(105895);
                return resourceEntryName;
            } catch (Exception e) {
                charSequence2 = "";
                AppMethodBeat.o(105895);
                return charSequence2;
            }
        }
        if (dmT()) {
            charSequence2 = f.d(i, f.getString(i));
            if (charSequence2 != null) {
                AppMethodBeat.o(105895);
                return charSequence2;
            }
        }
        charSequence2 = f.d(i, this.mResources.getString(i));
        if (charSequence2 != null) {
            charSequence2 = charSequence2.toString();
            AppMethodBeat.o(105895);
            return charSequence2;
        }
        charSequence2 = this.mResources.getString(i);
        AppMethodBeat.o(105895);
        return charSequence2;
    }

    public final String getString(int i) {
        AppMethodBeat.i(105896);
        String resourceEntryName;
        if (this.xuy) {
            try {
                resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.o(105896);
                return resourceEntryName;
            } catch (Exception e) {
                resourceEntryName = "";
                AppMethodBeat.o(105896);
                return resourceEntryName;
            }
        }
        if (dmT()) {
            resourceEntryName = f.getString(i);
            if (resourceEntryName != null) {
                resourceEntryName = f.d(i, resourceEntryName.toString()).toString();
                AppMethodBeat.o(105896);
                return resourceEntryName;
            }
        }
        try {
            CharSequence d = f.d(i, this.mResources.getString(i));
            if (d != null) {
                resourceEntryName = d.toString();
                AppMethodBeat.o(105896);
                return resourceEntryName;
            }
            resourceEntryName = this.mResources.getString(i);
            AppMethodBeat.o(105896);
            return resourceEntryName;
        } catch (Exception e2) {
            resourceEntryName = "";
            AppMethodBeat.o(105896);
            return resourceEntryName;
        }
    }

    public final String getQuantityString(int i, int i2) {
        AppMethodBeat.i(105897);
        String resourceEntryName;
        if (this.xuy) {
            try {
                resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.o(105897);
                return resourceEntryName;
            } catch (Exception e) {
                resourceEntryName = "";
                AppMethodBeat.o(105897);
                return resourceEntryName;
            }
        }
        if (dmT()) {
            resourceEntryName = f.getQuantityString(i, i2);
            if (resourceEntryName != null) {
                resourceEntryName = resourceEntryName.toString();
                AppMethodBeat.o(105897);
                return resourceEntryName;
            }
        }
        resourceEntryName = this.mResources.getQuantityString(i, i2);
        AppMethodBeat.o(105897);
        return resourceEntryName;
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        AppMethodBeat.i(105898);
        String resourceEntryName;
        if (this.xuy) {
            try {
                resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.o(105898);
                return resourceEntryName;
            } catch (Exception e) {
                resourceEntryName = "";
                AppMethodBeat.o(105898);
                return resourceEntryName;
            }
        }
        if (dmT()) {
            resourceEntryName = f.getQuantityString(i, i2, objArr);
            if (resourceEntryName != null) {
                resourceEntryName = resourceEntryName.toString();
                AppMethodBeat.o(105898);
                return resourceEntryName;
            }
        }
        resourceEntryName = this.mResources.getQuantityString(i, i2, objArr);
        AppMethodBeat.o(105898);
        return resourceEntryName;
    }

    public final CharSequence getQuantityText(int i, int i2) {
        CharSequence charSequence;
        AppMethodBeat.i(105899);
        String resourceEntryName;
        if (this.xuy) {
            try {
                resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.o(105899);
                return resourceEntryName;
            } catch (Exception e) {
                charSequence = "";
                AppMethodBeat.o(105899);
                return charSequence;
            }
        }
        if (dmT()) {
            resourceEntryName = f.getQuantityString(i, i2);
            if (resourceEntryName != null) {
                charSequence = resourceEntryName.toString();
                AppMethodBeat.o(105899);
                return charSequence;
            }
        }
        charSequence = this.mResources.getQuantityString(i, i2);
        AppMethodBeat.o(105899);
        return charSequence;
    }

    public final String[] getStringArray(int i) {
        String[] stringArray;
        AppMethodBeat.i(105900);
        if (dmT()) {
            stringArray = f.getStringArray(i);
            if (stringArray != null) {
                AppMethodBeat.o(105900);
                return stringArray;
            }
        }
        stringArray = super.getStringArray(i);
        AppMethodBeat.o(105900);
        return stringArray;
    }

    public final CharSequence[] getTextArray(int i) {
        AppMethodBeat.i(105901);
        String[] stringArray = getStringArray(i);
        if (stringArray != null) {
            AppMethodBeat.o(105901);
            return stringArray;
        }
        CharSequence[] textArray = super.getTextArray(i);
        AppMethodBeat.o(105901);
        return textArray;
    }

    public final TypedArray obtainTypedArray(int i) {
        AppMethodBeat.i(105902);
        TypedArray obtainTypedArray = this.mResources.obtainTypedArray(i);
        AppMethodBeat.o(105902);
        return obtainTypedArray;
    }

    public final Drawable getDrawable(int i) {
        Drawable f;
        AppMethodBeat.i(105903);
        if (i != 0) {
            f = this.xux.f(this.mResources, i);
            if (f != null) {
                AppMethodBeat.o(105903);
                return f;
            }
        }
        f = d(super.getDrawable(i), i);
        AppMethodBeat.o(105903);
        return f;
    }

    @TargetApi(21)
    public final Drawable getDrawable(int i, Theme theme) {
        Drawable f;
        AppMethodBeat.i(105904);
        if (i != 0) {
            f = this.xux.f(this.mResources, i);
            if (f != null) {
                AppMethodBeat.o(105904);
                return f;
            }
        }
        f = d(super.getDrawable(i, theme), i);
        AppMethodBeat.o(105904);
        return f;
    }

    public final Drawable getDrawableForDensity(int i, int i2) {
        Drawable f;
        AppMethodBeat.i(105905);
        if (i != 0) {
            f = this.xux.f(this.mResources, i);
            if (f != null) {
                AppMethodBeat.o(105905);
                return f;
            }
        }
        f = d(super.getDrawableForDensity(i, i2), i);
        AppMethodBeat.o(105905);
        return f;
    }

    @TargetApi(22)
    public final Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        Drawable f;
        AppMethodBeat.i(105906);
        if (i != 0) {
            f = this.xux.f(this.mResources, i);
            if (f != null) {
                AppMethodBeat.o(105906);
                return f;
            }
        }
        f = d(super.getDrawableForDensity(i, i2, theme), i);
        AppMethodBeat.o(105906);
        return f;
    }

    private Drawable d(Drawable drawable, int i) {
        AppMethodBeat.i(105907);
        if (drawable == null) {
            ab.c("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
            try {
                if (this.xux.xuG.g(this, i)) {
                    ab.e("MicroMsg.MMResources", "resources name = %s, this resource %s", getResourceName(i), this);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMResources", e, "WTF", new Object[0]);
            }
            drawable = new com.tencent.mm.svg.a.c(new Picture(), 0);
        }
        AppMethodBeat.o(105907);
        return drawable;
    }

    public static Drawable d(Resources resources, int i) {
        AppMethodBeat.i(105908);
        Drawable d = com.tencent.mm.svg.a.e.d(resources, i);
        AppMethodBeat.o(105908);
        return d;
    }

    public static Drawable e(Resources resources, int i) {
        Method declaredMethod;
        NotFoundException notFoundException;
        boolean z = true;
        AppMethodBeat.i(105909);
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        Drawable drawable = null;
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        }
        if (z) {
            drawable = new ColorDrawable(typedValue.data);
        }
        if (xuA == null) {
            try {
                declaredMethod = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[]{String.class, Integer.TYPE, Integer.TYPE, String.class});
                xuA = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                ab.printErrStackTrace("MicroMsg.MMResources", e, "", new Object[0]);
                ab.printErrStackTrace("MicroMsg.MMResources", e, "", new Object[0]);
                AppMethodBeat.o(105909);
                return null;
            }
        }
        if (xuB == null) {
            try {
                declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[]{Integer.TYPE, String.class, Integer.TYPE});
                xuB = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                ab.printErrStackTrace("MicroMsg.MMResources", e2, "", new Object[0]);
                ab.printErrStackTrace("MicroMsg.MMResources", e2, "", new Object[0]);
                AppMethodBeat.o(105909);
                return null;
            }
        }
        if (drawable == null) {
            if (typedValue.string == null) {
                NotFoundException notFoundException2 = new NotFoundException("Resource is not a Drawable (color or path): ".concat(String.valueOf(typedValue)));
                AppMethodBeat.o(105909);
                throw notFoundException2;
            }
            String charSequence = typedValue.string.toString();
            Drawable createFromXml;
            if (charSequence.endsWith(".xml")) {
                try {
                    XmlResourceParser xmlResourceParser = (XmlResourceParser) xuA.invoke(resources, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(typedValue.assetCookie), "drawable"});
                    createFromXml = Drawable.createFromXml(resources, xmlResourceParser);
                    xmlResourceParser.close();
                    drawable = createFromXml;
                } catch (Exception e3) {
                    notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e3);
                    AppMethodBeat.o(105909);
                    throw notFoundException;
                }
            }
            try {
                InputStream inputStream = (InputStream) xuB.invoke(resources.getAssets(), new Object[]{Integer.valueOf(typedValue.assetCookie), charSequence, Integer.valueOf(2)});
                createFromXml = Drawable.createFromResourceStream(resources, typedValue, inputStream, charSequence, null);
                inputStream.close();
                drawable = createFromXml;
            } catch (Exception e32) {
                notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e32);
                AppMethodBeat.o(105909);
                throw notFoundException;
            }
        }
        AppMethodBeat.o(105909);
        return drawable;
    }
}
