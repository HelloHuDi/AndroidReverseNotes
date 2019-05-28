package com.tencent.p177mm.p210ca;

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
import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C16657e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.svg.p610a.C5154e;
import com.tencent.p177mm.svg.p610a.C7314c;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ca.b */
public final class C18121b extends Resources {
    private static Method xuA = null;
    private static Method xuB = null;
    private Resources mResources;
    private C1344f xuw;
    private C41917d xux;
    private boolean xuy;
    private C32432a xuz;

    /* renamed from: com.tencent.mm.ca.b$a */
    public static class C18122a<E> extends ArrayList<E> {
        public final boolean add(E e) {
            AppMethodBeat.m2504i(105885);
            C4990ab.m7416i("InterceptArrayList", "InterceptArrayList.add");
            AppMethodBeat.m2505o(105885);
            return true;
        }

        public final void add(int i, E e) {
            AppMethodBeat.m2504i(105886);
            C4990ab.m7416i("InterceptArrayList", "InterceptArrayList.add index object");
            AppMethodBeat.m2505o(105886);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065 A:{Catch:{ NoSuchFieldException -> 0x00d1, IllegalAccessException -> 0x00de, IllegalArgumentException -> 0x00eb }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C18121b(Resources resources, C1344f c1344f, C41917d c41917d, C32432a c32432a) {
        C1438c c1438c;
        super(resources.getAssets(), c32432a.getDisplayMetrics(), c32432a.mo53072b(resources.getConfiguration()));
        AppMethodBeat.m2504i(105887);
        this.xuz = c32432a;
        this.xuw = c1344f;
        if (resources instanceof C18121b) {
            this.mResources = ((C18121b) resources).mResources;
        } else {
            this.mResources = resources;
        }
        this.xux = c41917d;
        try {
            Field declaredField;
            Class cls = Class.forName("android.content.res.MiuiResources");
            if (cls != null) {
                C4990ab.m7416i("MicroMsg.MMResources", "sMiuiThemeEnabled false");
                declaredField = cls.getDeclaredField("sMiuiThemeEnabled");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.set(null, Boolean.FALSE);
                    c1438c = new C1438c(getAssets(), "mThemeCookies", null);
                    if (c1438c.mo4891Mg()) {
                        c1438c.set(new C18122a());
                    }
                    this.xuy = C4996ah.doB().getBoolean("ShowStringName", false);
                    C4990ab.m7417i("MicroMsg.MMResources", "originalResources:%s mmresource:%s", resources, this);
                    AppMethodBeat.m2505o(105887);
                }
            }
            declaredField = null;
            C4990ab.m7413e("MicroMsg.MMResources", "some thing wrong. %s %s", cls, declaredField);
        } catch (ClassNotFoundException e) {
            C4990ab.m7416i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
        } catch (NoSuchFieldException e2) {
            C4990ab.m7416i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
        } catch (IllegalAccessException e3) {
            C4990ab.m7416i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
        } catch (IllegalArgumentException e4) {
            C4990ab.m7416i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
        }
        c1438c = new C1438c(getAssets(), "mThemeCookies", null);
        try {
            if (c1438c.mo4891Mg()) {
            }
        } catch (NoSuchFieldException e5) {
            C4990ab.printErrStackTrace("MicroMsg.MMResources", e5, "", new Object[0]);
        } catch (IllegalAccessException e6) {
            C4990ab.printErrStackTrace("MicroMsg.MMResources", e6, "", new Object[0]);
        } catch (IllegalArgumentException e7) {
            C4990ab.printErrStackTrace("MicroMsg.MMResources", e7, "", new Object[0]);
        }
        try {
            this.xuy = C4996ah.doB().getBoolean("ShowStringName", false);
        } catch (Exception e8) {
            C4990ab.m7412e("MicroMsg.MMResources", e8.getMessage());
        }
        C4990ab.m7417i("MicroMsg.MMResources", "originalResources:%s mmresource:%s", resources, this);
        AppMethodBeat.m2505o(105887);
    }

    public final DisplayMetrics getDisplayMetrics() {
        AppMethodBeat.m2504i(105888);
        DisplayMetrics displayMetrics = this.xuz.getDisplayMetrics();
        AppMethodBeat.m2505o(105888);
        return displayMetrics;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(105889);
        C4990ab.m7417i("MicroMsg.MMResources", "locale %s, orientation %s", configuration.locale, Integer.valueOf(configuration.orientation));
        C32432a c32432a = this.xuz;
        DisplayMetrics displayMetrics = this.mResources.getDisplayMetrics();
        if (c32432a.dmR()) {
            displayMetrics.density = c32432a.aDu.density;
            displayMetrics.densityDpi = c32432a.aDu.densityDpi;
            displayMetrics.scaledDensity = c32432a.aDu.scaledDensity;
            c32432a.aDu.setTo(displayMetrics);
        }
        super.updateConfiguration(this.xuz.mo53072b(configuration), getDisplayMetrics());
        AppMethodBeat.m2505o(105889);
    }

    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        AppMethodBeat.m2504i(105890);
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
            C32432a c32432a = this.xuz;
            int i2 = C5018as.amF(C4996ah.doA()).getInt(C32432a.xus, 0);
            C5222ae.dMw();
            int i3 = C5222ae.dMw().densityDpi;
            if (i2 == 0) {
                C5018as.amF(C4996ah.doA()).putInt(C32432a.xus, i3);
            }
            C4990ab.m7417i("MicroMsg.MMDensityManager", "dancy test checkDensity, mDensityDpi:%s,  mCurrentDensityDpi:%s", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 || i2 == i3) {
                obj = null;
            } else {
                C5018as.amF(C4996ah.doA()).putInt(C32432a.xus, i3);
                obj = 1;
            }
            if (obj != null) {
                C4990ab.m7417i("MicroMsg.MMDensityManager", "checkDensity density change, mIcheckDensitylistener:%s", C32432a.xuv);
                if (C32432a.xuv != null) {
                    C32432a.xuv.mo20433Bj();
                }
            }
            boolean z = C5018as.amF(C4996ah.doA()).getBoolean(C32432a.xut, false);
            boolean z2 = C5018as.amF(C4996ah.doA()).getBoolean(C32432a.yaj, false);
            if (!z) {
                try {
                    displayMetrics2 = new DisplayMetrics();
                    ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
                    i2 = displayMetrics2.widthPixels;
                    i = displayMetrics2.heightPixels;
                    float f2 = displayMetrics2.density;
                    f = c32432a.getDisplayMetrics().density;
                    min = (int) (((float) Math.min(i2, i)) / f2);
                    C7060h.pYm.mo8381e(17089, Integer.valueOf(i2), Integer.valueOf(i), Float.toString(f2), Float.toString(f), Integer.valueOf(min), Integer.valueOf(C5222ae.dzh()), Integer.valueOf(C5222ae.dMx()), Integer.valueOf(C5222ae.getDeviceWidth()), Integer.valueOf(Math.min(c32432a.xuq.widthPixels, c32432a.xuq.heightPixels)), Float.valueOf(C32432a.xuu));
                    C5018as.amF(C4996ah.doA()).putBoolean(C32432a.xut, true);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MMDensityManager", e, "", new Object[0]);
                }
            }
            if (C5222ae.dzh() != 0) {
                i = Math.round(((float) C5222ae.getDeviceWidth()) / (((float) C5222ae.dzh()) / 160.0f));
            } else {
                i = 0;
            }
            DisplayMetrics dMw = C5222ae.dMw();
            Object obj2 = Math.round(((float) Math.min(dMw.heightPixels, dMw.widthPixels)) / dMw.density) >= C16657e.CTRL_INDEX ? 1 : null;
            if (!(((i >= C16657e.CTRL_INDEX ? 1 : null) == null && obj2 == null) || z2)) {
                i2 = dMw.widthPixels;
                i3 = dMw.heightPixels;
                float f3 = dMw.density;
                f = c32432a.getDisplayMetrics().density;
                int min2 = (int) (((float) Math.min(i2, i3)) / f3);
                C7060h.pYm.mo8381e(17305, Integer.valueOf(i), Integer.valueOf(min), Integer.valueOf(i2), Integer.valueOf(i3), Float.toString(f3), Float.toString(f), Integer.valueOf(min2), Integer.valueOf(C5222ae.dzh()), Integer.valueOf(C5222ae.dMx()), Integer.valueOf(C5222ae.getDeviceWidth()), Integer.valueOf(Math.min(c32432a.xuq.widthPixels, c32432a.xuq.heightPixels)), Float.valueOf(C32432a.xuu));
                C5018as.amF(C4996ah.doA()).putBoolean(C32432a.yaj, true);
            }
            if (c32432a.dmR()) {
                c32432a.dmQ();
                ((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
                C4990ab.m7417i("MicroMsg.MMDensityManager", " \n************************************************************************* \nTarget -> %s \nCurrent -> %s \nWindowManager -> %s \nConfiguration -> %s fontScale -> %s", C32432a.m53095e(c32432a.aDu), C32432a.m53095e(displayMetrics), C32432a.m53095e(displayMetrics2), Integer.valueOf(configuration.densityDpi), Float.valueOf(configuration.fontScale));
            }
        }
        AppMethodBeat.m2505o(105890);
    }

    /* renamed from: a */
    public static Resources m28547a(Resources resources, Context context) {
        AppMethodBeat.m2504i(105891);
        C18121b c18121b = new C18121b(resources, C1344f.m2882gf(context), new C41917d(), new C32432a(resources.getDisplayMetrics()));
        AppMethodBeat.m2505o(105891);
        return c18121b;
    }

    /* renamed from: a */
    public static Resources m28548a(Resources resources, Context context, String str) {
        AppMethodBeat.m2504i(105892);
        C18121b c18121b = new C18121b(resources, C1344f.m2879bG(context, str), new C41917d(), new C32432a(resources.getDisplayMetrics()));
        AppMethodBeat.m2505o(105892);
        return c18121b;
    }

    private boolean dmT() {
        AppMethodBeat.m2504i(105893);
        if (this.xuw == null || !C1344f.dmT()) {
            AppMethodBeat.m2505o(105893);
            return false;
        }
        AppMethodBeat.m2505o(105893);
        return true;
    }

    public final CharSequence getText(int i) {
        CharSequence charSequence;
        AppMethodBeat.m2504i(105894);
        if (this.xuy) {
            try {
                String resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.m2505o(105894);
                return resourceEntryName;
            } catch (Exception e) {
                charSequence = "";
                AppMethodBeat.m2505o(105894);
                return charSequence;
            }
        }
        if (dmT()) {
            charSequence = C1344f.m2881d(i, C1344f.getString(i));
            if (charSequence != null) {
                AppMethodBeat.m2505o(105894);
                return charSequence;
            }
        }
        charSequence = C1344f.m2881d(i, this.mResources.getString(i));
        if (charSequence != null) {
            charSequence = charSequence.toString();
            AppMethodBeat.m2505o(105894);
            return charSequence;
        }
        charSequence = this.mResources.getString(i);
        AppMethodBeat.m2505o(105894);
        return charSequence;
    }

    public final CharSequence getText(int i, CharSequence charSequence) {
        CharSequence charSequence2;
        AppMethodBeat.m2504i(105895);
        if (this.xuy) {
            try {
                String resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.m2505o(105895);
                return resourceEntryName;
            } catch (Exception e) {
                charSequence2 = "";
                AppMethodBeat.m2505o(105895);
                return charSequence2;
            }
        }
        if (dmT()) {
            charSequence2 = C1344f.m2881d(i, C1344f.getString(i));
            if (charSequence2 != null) {
                AppMethodBeat.m2505o(105895);
                return charSequence2;
            }
        }
        charSequence2 = C1344f.m2881d(i, this.mResources.getString(i));
        if (charSequence2 != null) {
            charSequence2 = charSequence2.toString();
            AppMethodBeat.m2505o(105895);
            return charSequence2;
        }
        charSequence2 = this.mResources.getString(i);
        AppMethodBeat.m2505o(105895);
        return charSequence2;
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(105896);
        String resourceEntryName;
        if (this.xuy) {
            try {
                resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.m2505o(105896);
                return resourceEntryName;
            } catch (Exception e) {
                resourceEntryName = "";
                AppMethodBeat.m2505o(105896);
                return resourceEntryName;
            }
        }
        if (dmT()) {
            resourceEntryName = C1344f.getString(i);
            if (resourceEntryName != null) {
                resourceEntryName = C1344f.m2881d(i, resourceEntryName.toString()).toString();
                AppMethodBeat.m2505o(105896);
                return resourceEntryName;
            }
        }
        try {
            CharSequence d = C1344f.m2881d(i, this.mResources.getString(i));
            if (d != null) {
                resourceEntryName = d.toString();
                AppMethodBeat.m2505o(105896);
                return resourceEntryName;
            }
            resourceEntryName = this.mResources.getString(i);
            AppMethodBeat.m2505o(105896);
            return resourceEntryName;
        } catch (Exception e2) {
            resourceEntryName = "";
            AppMethodBeat.m2505o(105896);
            return resourceEntryName;
        }
    }

    public final String getQuantityString(int i, int i2) {
        AppMethodBeat.m2504i(105897);
        String resourceEntryName;
        if (this.xuy) {
            try {
                resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.m2505o(105897);
                return resourceEntryName;
            } catch (Exception e) {
                resourceEntryName = "";
                AppMethodBeat.m2505o(105897);
                return resourceEntryName;
            }
        }
        if (dmT()) {
            resourceEntryName = C1344f.getQuantityString(i, i2);
            if (resourceEntryName != null) {
                resourceEntryName = resourceEntryName.toString();
                AppMethodBeat.m2505o(105897);
                return resourceEntryName;
            }
        }
        resourceEntryName = this.mResources.getQuantityString(i, i2);
        AppMethodBeat.m2505o(105897);
        return resourceEntryName;
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        AppMethodBeat.m2504i(105898);
        String resourceEntryName;
        if (this.xuy) {
            try {
                resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.m2505o(105898);
                return resourceEntryName;
            } catch (Exception e) {
                resourceEntryName = "";
                AppMethodBeat.m2505o(105898);
                return resourceEntryName;
            }
        }
        if (dmT()) {
            resourceEntryName = C1344f.getQuantityString(i, i2, objArr);
            if (resourceEntryName != null) {
                resourceEntryName = resourceEntryName.toString();
                AppMethodBeat.m2505o(105898);
                return resourceEntryName;
            }
        }
        resourceEntryName = this.mResources.getQuantityString(i, i2, objArr);
        AppMethodBeat.m2505o(105898);
        return resourceEntryName;
    }

    public final CharSequence getQuantityText(int i, int i2) {
        CharSequence charSequence;
        AppMethodBeat.m2504i(105899);
        String resourceEntryName;
        if (this.xuy) {
            try {
                resourceEntryName = this.mResources.getResourceEntryName(i);
                AppMethodBeat.m2505o(105899);
                return resourceEntryName;
            } catch (Exception e) {
                charSequence = "";
                AppMethodBeat.m2505o(105899);
                return charSequence;
            }
        }
        if (dmT()) {
            resourceEntryName = C1344f.getQuantityString(i, i2);
            if (resourceEntryName != null) {
                charSequence = resourceEntryName.toString();
                AppMethodBeat.m2505o(105899);
                return charSequence;
            }
        }
        charSequence = this.mResources.getQuantityString(i, i2);
        AppMethodBeat.m2505o(105899);
        return charSequence;
    }

    public final String[] getStringArray(int i) {
        String[] stringArray;
        AppMethodBeat.m2504i(105900);
        if (dmT()) {
            stringArray = C1344f.getStringArray(i);
            if (stringArray != null) {
                AppMethodBeat.m2505o(105900);
                return stringArray;
            }
        }
        stringArray = super.getStringArray(i);
        AppMethodBeat.m2505o(105900);
        return stringArray;
    }

    public final CharSequence[] getTextArray(int i) {
        AppMethodBeat.m2504i(105901);
        String[] stringArray = getStringArray(i);
        if (stringArray != null) {
            AppMethodBeat.m2505o(105901);
            return stringArray;
        }
        CharSequence[] textArray = super.getTextArray(i);
        AppMethodBeat.m2505o(105901);
        return textArray;
    }

    public final TypedArray obtainTypedArray(int i) {
        AppMethodBeat.m2504i(105902);
        TypedArray obtainTypedArray = this.mResources.obtainTypedArray(i);
        AppMethodBeat.m2505o(105902);
        return obtainTypedArray;
    }

    public final Drawable getDrawable(int i) {
        Drawable f;
        AppMethodBeat.m2504i(105903);
        if (i != 0) {
            f = this.xux.mo67562f(this.mResources, i);
            if (f != null) {
                AppMethodBeat.m2505o(105903);
                return f;
            }
        }
        f = m28550d(super.getDrawable(i), i);
        AppMethodBeat.m2505o(105903);
        return f;
    }

    @TargetApi(21)
    public final Drawable getDrawable(int i, Theme theme) {
        Drawable f;
        AppMethodBeat.m2504i(105904);
        if (i != 0) {
            f = this.xux.mo67562f(this.mResources, i);
            if (f != null) {
                AppMethodBeat.m2505o(105904);
                return f;
            }
        }
        f = m28550d(super.getDrawable(i, theme), i);
        AppMethodBeat.m2505o(105904);
        return f;
    }

    public final Drawable getDrawableForDensity(int i, int i2) {
        Drawable f;
        AppMethodBeat.m2504i(105905);
        if (i != 0) {
            f = this.xux.mo67562f(this.mResources, i);
            if (f != null) {
                AppMethodBeat.m2505o(105905);
                return f;
            }
        }
        f = m28550d(super.getDrawableForDensity(i, i2), i);
        AppMethodBeat.m2505o(105905);
        return f;
    }

    @TargetApi(22)
    public final Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        Drawable f;
        AppMethodBeat.m2504i(105906);
        if (i != 0) {
            f = this.xux.mo67562f(this.mResources, i);
            if (f != null) {
                AppMethodBeat.m2505o(105906);
                return f;
            }
        }
        f = m28550d(super.getDrawableForDensity(i, i2, theme), i);
        AppMethodBeat.m2505o(105906);
        return f;
    }

    /* renamed from: d */
    private Drawable m28550d(Drawable drawable, int i) {
        AppMethodBeat.m2504i(105907);
        if (drawable == null) {
            C4990ab.m7409c("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
            try {
                if (this.xux.xuG.mo10586g(this, i)) {
                    C4990ab.m7413e("MicroMsg.MMResources", "resources name = %s, this resource %s", getResourceName(i), this);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMResources", e, "WTF", new Object[0]);
            }
            drawable = new C7314c(new Picture(), 0);
        }
        AppMethodBeat.m2505o(105907);
        return drawable;
    }

    /* renamed from: d */
    public static Drawable m28549d(Resources resources, int i) {
        AppMethodBeat.m2504i(105908);
        Drawable d = C5154e.m7852d(resources, i);
        AppMethodBeat.m2505o(105908);
        return d;
    }

    /* renamed from: e */
    public static Drawable m28551e(Resources resources, int i) {
        Method declaredMethod;
        NotFoundException notFoundException;
        boolean z = true;
        AppMethodBeat.m2504i(105909);
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
                C4990ab.printErrStackTrace("MicroMsg.MMResources", e, "", new Object[0]);
                C4990ab.printErrStackTrace("MicroMsg.MMResources", e, "", new Object[0]);
                AppMethodBeat.m2505o(105909);
                return null;
            }
        }
        if (xuB == null) {
            try {
                declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[]{Integer.TYPE, String.class, Integer.TYPE});
                xuB = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                C4990ab.printErrStackTrace("MicroMsg.MMResources", e2, "", new Object[0]);
                C4990ab.printErrStackTrace("MicroMsg.MMResources", e2, "", new Object[0]);
                AppMethodBeat.m2505o(105909);
                return null;
            }
        }
        if (drawable == null) {
            if (typedValue.string == null) {
                NotFoundException notFoundException2 = new NotFoundException("Resource is not a Drawable (color or path): ".concat(String.valueOf(typedValue)));
                AppMethodBeat.m2505o(105909);
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
                    AppMethodBeat.m2505o(105909);
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
                AppMethodBeat.m2505o(105909);
                throw notFoundException;
            }
        }
        AppMethodBeat.m2505o(105909);
        return drawable;
    }
}
