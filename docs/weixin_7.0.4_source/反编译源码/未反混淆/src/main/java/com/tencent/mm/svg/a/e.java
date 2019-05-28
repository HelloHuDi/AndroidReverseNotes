package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class e {
    private static Class<?> cff = null;
    protected static Application cfh;
    protected static Resources cfi;
    protected static String sPackageName;
    private static Method xuA = null;
    private static Method xuB = null;
    private static boolean ydf = false;
    private static volatile a ydg;
    private static LongSparseArray<ConstantState>[] ydh;
    private static LongSparseArray<ConstantState> ydi;
    private static c<ConstantState> ydj;
    private static c<ConstantState> ydk;
    protected static Class<d> ydl;
    private static volatile boolean ydm = false;
    private static Map<WeakReference<Resources>, Map<Long, Integer>> ydn = new HashMap();
    private static boolean ydo = false;
    private static ThreadLocal<Boolean> ydp = new ThreadLocal();

    public static class a {
        Resources mResources;
        TypedValue ycK = new TypedValue();
        Map<Integer, com.tencent.mm.svg.c> ycP;
        Application ydq;

        public a(Map<Integer, com.tencent.mm.svg.c> map, Application application, Resources resources) {
            AppMethodBeat.i(70094);
            this.ycP = map;
            this.ydq = application;
            this.mResources = resources;
            AppMethodBeat.o(70094);
        }

        public final void a(Integer num, com.tencent.mm.svg.c cVar) {
            AppMethodBeat.i(70095);
            this.ycP.put(num, cVar);
            e.b(this.ydq, this.mResources, num.intValue(), this.ycK);
            AppMethodBeat.o(70095);
        }
    }

    protected static class b extends ConstantState {
        private Resources mResources;
        private int sLo = 0;
        private long ydr = 0;

        public b(int i, Resources resources, long j) {
            AppMethodBeat.i(70096);
            if (i == 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", Integer.valueOf(i));
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
            }
            this.sLo = i;
            this.mResources = resources;
            this.ydr = j;
            AppMethodBeat.o(70096);
        }

        public final Drawable newDrawable() {
            AppMethodBeat.i(70097);
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable mResources %s %s", this.mResources, Integer.valueOf(this.sLo));
            Drawable f = a.f(this.mResources, this.sLo);
            AppMethodBeat.o(70097);
            return f;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable e;
            AppMethodBeat.i(70098);
            try {
                Map g = e.g(resources);
                if (g != null) {
                    int intValue = ((Integer) g.get(Long.valueOf(this.ydr))).intValue();
                    e = e.e(resources, intValue);
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "loadDrawableSkipCache id:" + Integer.toHexString(intValue) + ",drawable:" + e, new Object[0]);
                    AppMethodBeat.o(70098);
                    return e;
                }
            } catch (Exception e2) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable loadDrawableSkipCache error:" + e2.getMessage(), new Object[0]);
            }
            e = newDrawable();
            AppMethodBeat.o(70098);
            return e;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            AppMethodBeat.i(70099);
            Drawable newDrawable = newDrawable(resources);
            AppMethodBeat.o(70099);
            return newDrawable;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    @TargetApi(16)
    public static class c<T> extends LongSparseArray<T> {
        public static boolean yds = false;
        LongSparseArray<T> ydi = null;

        public final T get(long j, T t) {
            T t2;
            AppMethodBeat.i(70100);
            if (e.ydp.get() == null || !((Boolean) e.ydp.get()).booleanValue()) {
                synchronized (this.ydi) {
                    try {
                        if (this.ydi.indexOfKey(j) >= 0) {
                            t2 = this.ydi.get(j, t);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(70100);
                    }
                }
            } else {
                com.tencent.mm.svg.b.c.d("MicroMsg.SVGLongSparseArray", "Skip svg this time for key %s", Long.valueOf(j));
            }
            t2 = super.get(j, t);
            AppMethodBeat.o(70100);
            return t2;
            return t2;
        }

        public final void delete(long j) {
            AppMethodBeat.i(70101);
            super.delete(j);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", Long.valueOf(j));
            AppMethodBeat.o(70101);
        }

        public final void remove(long j) {
            AppMethodBeat.i(70102);
            super.remove(j);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", Long.valueOf(j));
            AppMethodBeat.o(70102);
        }

        public final void clear() {
            AppMethodBeat.i(70103);
            super.clear();
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
            AppMethodBeat.o(70103);
        }
    }

    static /* synthetic */ void b(Application application, Resources resources, int i, TypedValue typedValue) {
        AppMethodBeat.i(70116);
        a(application, resources, i, typedValue);
        AppMethodBeat.o(70116);
    }

    static {
        AppMethodBeat.i(70118);
        AppMethodBeat.o(70118);
    }

    public static void a(Resources resources, Map<Long, Integer> map) {
        int i;
        AppMethodBeat.i(70104);
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "addFilterResources:".concat(String.valueOf(resources)), new Object[0]);
        for (WeakReference weakReference : ydn.keySet()) {
            if (weakReference.get() == resources) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            ydn.put(new WeakReference(resources), map);
        }
        AppMethodBeat.o(70104);
    }

    public static void G(Class<?> cls) {
        cff = cls;
    }

    public static void a(com.tencent.mm.svg.b.c.a aVar) {
        AppMethodBeat.i(70105);
        com.tencent.mm.svg.b.c.b(aVar);
        AppMethodBeat.o(70105);
    }

    public static void d(Application application, String str) {
        AppMethodBeat.i(70106);
        if (ydo) {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg initiated.", new Object[0]);
            AppMethodBeat.o(70106);
            return;
        }
        sPackageName = str;
        a.cY(str);
        com.tencent.mm.svg.b.b.cY(str);
        cfh = application;
        hm(application);
        AppMethodBeat.o(70106);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0110=Splitter:B:32:0x0110, B:43:0x0180=Splitter:B:43:0x0180} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0220  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(Application application, Resources resources, String str) {
        Object obj;
        long nanoTime;
        Throwable th;
        Object obj2;
        int i;
        AppMethodBeat.i(70107);
        d(application, str);
        if (ydm) {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg loaded, skip this time.", new Object[0]);
            AppMethodBeat.o(70107);
            return;
        }
        String str2 = sPackageName + ".svg.SVGPreload";
        try {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "try to load SVGPreload", new Object[0]);
            Class cls = Class.forName(str2);
            long nanoTime2 = System.nanoTime();
            cfh = application;
            ydl = cls;
            cfi = resources;
            try {
                if (ydl != null) {
                    ((d) cls.newInstance()).load(b(application, cfi));
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVGCode wrapper size %s", Integer.valueOf(b(application, cfi).ycP.size()));
                    ydf = true;
                }
            } catch (NotFoundException e) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "We found one NotFoundException.", new Object[0]);
                ydf = false;
            }
            obj = 1;
            try {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "load SVGPreload spent %s", Long.valueOf((System.nanoTime() - nanoTime2) / 1000));
                ydm = true;
                AppMethodBeat.o(70107);
            } catch (ClassNotFoundException e2) {
                try {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "ClassNotFoundException %s. Go fallback logic.", str2);
                    if (obj == null) {
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime = System.nanoTime();
                        hm(application);
                        try {
                            c(application, resources);
                        } catch (ClassNotFoundException e3) {
                        }
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                        AppMethodBeat.o(70107);
                        return;
                    }
                    ydm = true;
                    AppMethodBeat.o(70107);
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = obj;
                    if (obj2 == null) {
                    }
                    AppMethodBeat.o(70107);
                    throw th;
                }
            } catch (InstantiationException th22) {
                th = th22;
                i = 1;
                try {
                    com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
                    if (obj2 != null) {
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime = System.nanoTime();
                        hm(application);
                        try {
                            c(application, resources);
                        } catch (ClassNotFoundException e4) {
                        }
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                        AppMethodBeat.o(70107);
                        return;
                    }
                    ydm = true;
                    AppMethodBeat.o(70107);
                } catch (Throwable th3) {
                    th = th3;
                    if (obj2 == null) {
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime = System.nanoTime();
                        hm(application);
                        try {
                            c(application, resources);
                        } catch (ClassNotFoundException e5) {
                        }
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    } else {
                        ydm = true;
                    }
                    AppMethodBeat.o(70107);
                    throw th;
                }
            } catch (IllegalAccessException th222) {
                th = th222;
                i = 1;
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
                if (obj2 != null) {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    hm(application);
                    try {
                        c(application, resources);
                    } catch (ClassNotFoundException e6) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    AppMethodBeat.o(70107);
                    return;
                }
                ydm = true;
                AppMethodBeat.o(70107);
            }
        } catch (ClassNotFoundException e7) {
            obj = null;
        } catch (InstantiationException th32) {
            th = th32;
            obj2 = null;
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
            if (obj2 != null) {
            }
        } catch (IllegalAccessException th322) {
            th = th322;
            obj2 = null;
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
            if (obj2 != null) {
            }
        } catch (Throwable th3222) {
            th = th3222;
            obj2 = null;
            if (obj2 == null) {
            }
            AppMethodBeat.o(70107);
            throw th;
        }
    }

    private static a b(Application application, Resources resources) {
        AppMethodBeat.i(70108);
        if (ydg == null) {
            synchronized (e.class) {
                try {
                    if (ydg == null) {
                        ydg = new a(a.dvD(), application, resources);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(70108);
                    }
                }
            }
        }
        a aVar = ydg;
        AppMethodBeat.o(70108);
        return aVar;
    }

    @TargetApi(16)
    private static void hm(Context context) {
        AppMethodBeat.i(70109);
        if (ydj == null) {
            try {
                Object obj;
                ydi = new LongSparseArray();
                c cVar = new c();
                ydj = cVar;
                cVar.ydi = ydi;
                cVar = new c();
                ydk = cVar;
                cVar.ydi = ydi;
                if (VERSION.SDK_INT >= 23) {
                    com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "mResourcesImpl");
                    if (aVar.Mg()) {
                        obj = aVar.get();
                    } else {
                        obj = context.getResources();
                    }
                } else {
                    obj = context.getResources();
                }
                a(context, obj);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", context.getResources());
                AppMethodBeat.o(70109);
                return;
            } catch (NoSuchFieldException e) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
                AppMethodBeat.o(70109);
                return;
            } catch (IllegalAccessException e2) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
                AppMethodBeat.o(70109);
                return;
            } catch (IllegalArgumentException e3) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e3, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
            }
        }
        AppMethodBeat.o(70109);
    }

    @TargetApi(16)
    private static void a(Context context, Object obj) {
        AppMethodBeat.i(70110);
        Object obj2 = new com.tencent.mm.svg.b.a(obj, "sPreloadedDrawables").get();
        if (obj2 == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
            AppMethodBeat.o(70110);
        } else if (obj2 instanceof LongSparseArray[]) {
            int i;
            long keyAt;
            ydh = (LongSparseArray[]) obj2;
            com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", ydh[0]);
            for (i = 0; i < ydh[0].size(); i++) {
                keyAt = ydh[0].keyAt(i);
                ydj.put(keyAt, ydh[0].get(keyAt));
            }
            for (i = 0; i < ydh[1].size(); i++) {
                keyAt = ydh[1].keyAt(i);
                ydk.put(keyAt, ydh[1].get(keyAt));
            }
            ydh[0] = ydj;
            ydh[1] = ydk;
            AppMethodBeat.o(70110);
        } else if (obj2 instanceof LongSparseArray) {
            com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "sPreloadedDrawables");
            LongSparseArray longSparseArray = (LongSparseArray) aVar.get();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long keyAt2 = longSparseArray.keyAt(i2);
                ydj.put(keyAt2, longSparseArray.get(keyAt2));
            }
            c cVar = ydj;
            aVar.prepare();
            if (aVar.eum == null) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                AppMethodBeat.o(70110);
                throw noSuchFieldException;
            }
            aVar.eum.set(aVar.obj, cVar);
            if (aVar.get() == null) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
            }
            AppMethodBeat.o(70110);
        } else {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
            AppMethodBeat.o(70110);
        }
    }

    @TargetApi(16)
    private static void a(Application application, Resources resources, int i, TypedValue typedValue) {
        AppMethodBeat.i(70111);
        if (i == 0) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "preloadDrawable Why this id is %d. TypedValue %s", Integer.valueOf(i), typedValue);
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
        }
        resources.getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        b bVar = new b(i, application.getResources(), j);
        synchronized (ydi) {
            try {
                ydi.put(j, bVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(70111);
            }
        }
    }

    private static Class<?> dvI() {
        AppMethodBeat.i(70112);
        if (cff != null) {
            Class cls = cff;
            AppMethodBeat.o(70112);
            return cls;
        }
        Class<?> cls2;
        try {
            cls2 = Class.forName(sPackageName + ".R$raw");
            if (cls2 != null) {
                AppMethodBeat.o(70112);
                return cls2;
            }
        } catch (ClassNotFoundException e) {
        }
        cls2 = com.tencent.mm.svg.b.b.dvL();
        if (cls2 != null) {
            AppMethodBeat.o(70112);
            return cls2;
        }
        AppMethodBeat.o(70112);
        return null;
    }

    private static void c(Application application, Resources resources) {
        AppMethodBeat.i(70113);
        Class dvI = dvI();
        if (dvI == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
            AppMethodBeat.o(70113);
            return;
        }
        Field[] declaredFields = dvI.getDeclaredFields();
        a b = b(application, resources);
        try {
            a aVar = new a();
            for (Field field : declaredFields) {
                int i = field.getInt(null);
                if (aVar.g(application.getResources(), i)) {
                    b(b.ydq, b.mResources, i, b.ycK);
                }
            }
            ydf = true;
            AppMethodBeat.o(70113);
        } catch (IllegalAccessException e) {
            ydf = false;
            AppMethodBeat.o(70113);
        } catch (IllegalArgumentException e2) {
            ydf = false;
            AppMethodBeat.o(70113);
        }
    }

    public static Drawable d(Resources resources, int i) {
        AppMethodBeat.i(70114);
        ydp.set(Boolean.TRUE);
        Drawable drawable = resources.getDrawable(i);
        ydp.set(Boolean.FALSE);
        AppMethodBeat.o(70114);
        return drawable;
    }

    public static Drawable e(Resources resources, int i) {
        Method declaredMethod;
        NotFoundException notFoundException;
        boolean z = true;
        AppMethodBeat.i(70115);
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
                ab.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "", new Object[0]);
                ab.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "", new Object[0]);
                AppMethodBeat.o(70115);
                return null;
            }
        }
        if (xuB == null) {
            try {
                declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[]{Integer.TYPE, String.class, Integer.TYPE});
                xuB = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                ab.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                ab.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                AppMethodBeat.o(70115);
                return null;
            }
        }
        if (drawable == null) {
            if (typedValue.string == null) {
                NotFoundException notFoundException2 = new NotFoundException("Resource is not a Drawable (color or path): ".concat(String.valueOf(typedValue)));
                AppMethodBeat.o(70115);
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
                    AppMethodBeat.o(70115);
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
                AppMethodBeat.o(70115);
                throw notFoundException;
            }
        }
        AppMethodBeat.o(70115);
        return drawable;
    }

    static /* synthetic */ Map g(Resources resources) {
        AppMethodBeat.i(70117);
        for (WeakReference weakReference : ydn.keySet()) {
            Resources resources2 = (Resources) weakReference.get();
            if (resources2 != null && resources2 == resources) {
                Map map = (Map) ydn.get(weakReference);
                AppMethodBeat.o(70117);
                return map;
            }
        }
        AppMethodBeat.o(70117);
        return null;
    }
}
