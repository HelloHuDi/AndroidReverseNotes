package com.tencent.p177mm.svg.p610a;

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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.p611b.C5156a;
import com.tencent.p177mm.svg.p611b.C5157b;
import com.tencent.p177mm.svg.p611b.C5159c;
import com.tencent.p177mm.svg.p611b.C5159c.C5158a;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.svg.a.e */
public class C5154e {
    private static Class<?> cff = null;
    protected static Application cfh;
    protected static Resources cfi;
    protected static String sPackageName;
    private static Method xuA = null;
    private static Method xuB = null;
    private static boolean ydf = false;
    private static volatile C5151a ydg;
    private static LongSparseArray<ConstantState>[] ydh;
    private static LongSparseArray<ConstantState> ydi;
    private static C5153c<ConstantState> ydj;
    private static C5153c<ConstantState> ydk;
    protected static Class<C5150d> ydl;
    private static volatile boolean ydm = false;
    private static Map<WeakReference<Resources>, Map<Long, Integer>> ydn = new HashMap();
    private static boolean ydo = false;
    private static ThreadLocal<Boolean> ydp = new ThreadLocal();

    /* renamed from: com.tencent.mm.svg.a.e$a */
    public static class C5151a {
        Resources mResources;
        TypedValue ycK = new TypedValue();
        Map<Integer, C5163c> ycP;
        Application ydq;

        public C5151a(Map<Integer, C5163c> map, Application application, Resources resources) {
            AppMethodBeat.m2504i(70094);
            this.ycP = map;
            this.ydq = application;
            this.mResources = resources;
            AppMethodBeat.m2505o(70094);
        }

        /* renamed from: a */
        public final void mo10605a(Integer num, C5163c c5163c) {
            AppMethodBeat.m2504i(70095);
            this.ycP.put(num, c5163c);
            C5154e.m7850b(this.ydq, this.mResources, num.intValue(), this.ycK);
            AppMethodBeat.m2505o(70095);
        }
    }

    /* renamed from: com.tencent.mm.svg.a.e$b */
    protected static class C5152b extends ConstantState {
        private Resources mResources;
        private int sLo = 0;
        private long ydr = 0;

        public C5152b(int i, Resources resources, long j) {
            AppMethodBeat.m2504i(70096);
            if (i == 0) {
                C5159c.m7868e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", Integer.valueOf(i));
                C5159c.m7869i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
            }
            this.sLo = i;
            this.mResources = resources;
            this.ydr = j;
            AppMethodBeat.m2505o(70096);
        }

        public final Drawable newDrawable() {
            AppMethodBeat.m2504i(70097);
            C5159c.m7869i("MicroMsg.SVGResourceLoader", "newDrawable mResources %s %s", this.mResources, Integer.valueOf(this.sLo));
            Drawable f = C5147a.m7837f(this.mResources, this.sLo);
            AppMethodBeat.m2505o(70097);
            return f;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable e;
            AppMethodBeat.m2504i(70098);
            try {
                Map g = C5154e.m7855g(resources);
                if (g != null) {
                    int intValue = ((Integer) g.get(Long.valueOf(this.ydr))).intValue();
                    e = C5154e.m7854e(resources, intValue);
                    C5159c.m7869i("MicroMsg.SVGResourceLoader", "loadDrawableSkipCache id:" + Integer.toHexString(intValue) + ",drawable:" + e, new Object[0]);
                    AppMethodBeat.m2505o(70098);
                    return e;
                }
            } catch (Exception e2) {
                C5159c.m7869i("MicroMsg.SVGResourceLoader", "newDrawable loadDrawableSkipCache error:" + e2.getMessage(), new Object[0]);
            }
            e = newDrawable();
            AppMethodBeat.m2505o(70098);
            return e;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            AppMethodBeat.m2504i(70099);
            Drawable newDrawable = newDrawable(resources);
            AppMethodBeat.m2505o(70099);
            return newDrawable;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    @TargetApi(16)
    /* renamed from: com.tencent.mm.svg.a.e$c */
    public static class C5153c<T> extends LongSparseArray<T> {
        public static boolean yds = false;
        LongSparseArray<T> ydi = null;

        public final T get(long j, T t) {
            T t2;
            AppMethodBeat.m2504i(70100);
            if (C5154e.ydp.get() == null || !((Boolean) C5154e.ydp.get()).booleanValue()) {
                synchronized (this.ydi) {
                    try {
                        if (this.ydi.indexOfKey(j) >= 0) {
                            t2 = this.ydi.get(j, t);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(70100);
                    }
                }
            } else {
                C5159c.m7867d("MicroMsg.SVGLongSparseArray", "Skip svg this time for key %s", Long.valueOf(j));
            }
            t2 = super.get(j, t);
            AppMethodBeat.m2505o(70100);
            return t2;
            return t2;
        }

        public final void delete(long j) {
            AppMethodBeat.m2504i(70101);
            super.delete(j);
            C5159c.m7868e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", Long.valueOf(j));
            AppMethodBeat.m2505o(70101);
        }

        public final void remove(long j) {
            AppMethodBeat.m2504i(70102);
            super.remove(j);
            C5159c.m7868e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", Long.valueOf(j));
            AppMethodBeat.m2505o(70102);
        }

        public final void clear() {
            AppMethodBeat.m2504i(70103);
            super.clear();
            C5159c.m7868e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
            AppMethodBeat.m2505o(70103);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m7850b(Application application, Resources resources, int i, TypedValue typedValue) {
        AppMethodBeat.m2504i(70116);
        C5154e.m7844a(application, resources, i, typedValue);
        AppMethodBeat.m2505o(70116);
    }

    static {
        AppMethodBeat.m2504i(70118);
        AppMethodBeat.m2505o(70118);
    }

    /* renamed from: a */
    public static void m7847a(Resources resources, Map<Long, Integer> map) {
        int i;
        AppMethodBeat.m2504i(70104);
        C5159c.m7869i("MicroMsg.SVGResourceLoader", "addFilterResources:".concat(String.valueOf(resources)), new Object[0]);
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
        AppMethodBeat.m2505o(70104);
    }

    /* renamed from: G */
    public static void m7843G(Class<?> cls) {
        cff = cls;
    }

    /* renamed from: a */
    public static void m7848a(C5158a c5158a) {
        AppMethodBeat.m2504i(70105);
        C5159c.m7866b(c5158a);
        AppMethodBeat.m2505o(70105);
    }

    /* renamed from: d */
    public static void m7853d(Application application, String str) {
        AppMethodBeat.m2504i(70106);
        if (ydo) {
            C5159c.m7869i("MicroMsg.SVGResourceLoader", "svg initiated.", new Object[0]);
            AppMethodBeat.m2505o(70106);
            return;
        }
        sPackageName = str;
        C5147a.m7836cY(str);
        C5157b.m7860cY(str);
        cfh = application;
        C5154e.m7856hm(application);
        AppMethodBeat.m2505o(70106);
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
    /* renamed from: a */
    public static void m7845a(Application application, Resources resources, String str) {
        Object obj;
        long nanoTime;
        Throwable th;
        Object obj2;
        int i;
        AppMethodBeat.m2504i(70107);
        C5154e.m7853d(application, str);
        if (ydm) {
            C5159c.m7869i("MicroMsg.SVGResourceLoader", "svg loaded, skip this time.", new Object[0]);
            AppMethodBeat.m2505o(70107);
            return;
        }
        String str2 = sPackageName + ".svg.SVGPreload";
        try {
            C5159c.m7869i("MicroMsg.SVGResourceLoader", "try to load SVGPreload", new Object[0]);
            Class cls = Class.forName(str2);
            long nanoTime2 = System.nanoTime();
            cfh = application;
            ydl = cls;
            cfi = resources;
            try {
                if (ydl != null) {
                    ((C5150d) cls.newInstance()).load(C5154e.m7849b(application, cfi));
                    C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVGCode wrapper size %s", Integer.valueOf(C5154e.m7849b(application, cfi).ycP.size()));
                    ydf = true;
                }
            } catch (NotFoundException e) {
                C5159c.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "We found one NotFoundException.", new Object[0]);
                ydf = false;
            }
            obj = 1;
            try {
                C5159c.m7869i("MicroMsg.SVGResourceLoader", "load SVGPreload spent %s", Long.valueOf((System.nanoTime() - nanoTime2) / 1000));
                ydm = true;
                AppMethodBeat.m2505o(70107);
            } catch (ClassNotFoundException e2) {
                try {
                    C5159c.m7868e("MicroMsg.SVGResourceLoader", "ClassNotFoundException %s. Go fallback logic.", str2);
                    if (obj == null) {
                        C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime = System.nanoTime();
                        C5154e.m7856hm(application);
                        try {
                            C5154e.m7851c(application, resources);
                        } catch (ClassNotFoundException e3) {
                        }
                        C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                        AppMethodBeat.m2505o(70107);
                        return;
                    }
                    ydm = true;
                    AppMethodBeat.m2505o(70107);
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = obj;
                    if (obj2 == null) {
                    }
                    AppMethodBeat.m2505o(70107);
                    throw th;
                }
            } catch (InstantiationException th22) {
                th = th22;
                i = 1;
                try {
                    C5159c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
                    C5159c.m7868e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
                    if (obj2 != null) {
                        C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime = System.nanoTime();
                        C5154e.m7856hm(application);
                        try {
                            C5154e.m7851c(application, resources);
                        } catch (ClassNotFoundException e4) {
                        }
                        C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                        AppMethodBeat.m2505o(70107);
                        return;
                    }
                    ydm = true;
                    AppMethodBeat.m2505o(70107);
                } catch (Throwable th3) {
                    th = th3;
                    if (obj2 == null) {
                        C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime = System.nanoTime();
                        C5154e.m7856hm(application);
                        try {
                            C5154e.m7851c(application, resources);
                        } catch (ClassNotFoundException e5) {
                        }
                        C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    } else {
                        ydm = true;
                    }
                    AppMethodBeat.m2505o(70107);
                    throw th;
                }
            } catch (IllegalAccessException th222) {
                th = th222;
                i = 1;
                C5159c.m7868e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
                C5159c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
                if (obj2 != null) {
                    C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    C5154e.m7856hm(application);
                    try {
                        C5154e.m7851c(application, resources);
                    } catch (ClassNotFoundException e6) {
                    }
                    C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    AppMethodBeat.m2505o(70107);
                    return;
                }
                ydm = true;
                AppMethodBeat.m2505o(70107);
            }
        } catch (ClassNotFoundException e7) {
            obj = null;
        } catch (InstantiationException th32) {
            th = th32;
            obj2 = null;
            C5159c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
            C5159c.m7868e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
            if (obj2 != null) {
            }
        } catch (IllegalAccessException th322) {
            th = th322;
            obj2 = null;
            C5159c.m7868e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
            C5159c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
            if (obj2 != null) {
            }
        } catch (Throwable th3222) {
            th = th3222;
            obj2 = null;
            if (obj2 == null) {
            }
            AppMethodBeat.m2505o(70107);
            throw th;
        }
    }

    /* renamed from: b */
    private static C5151a m7849b(Application application, Resources resources) {
        AppMethodBeat.m2504i(70108);
        if (ydg == null) {
            synchronized (C5154e.class) {
                try {
                    if (ydg == null) {
                        ydg = new C5151a(C5147a.dvD(), application, resources);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(70108);
                    }
                }
            }
        }
        C5151a c5151a = ydg;
        AppMethodBeat.m2505o(70108);
        return c5151a;
    }

    @TargetApi(16)
    /* renamed from: hm */
    private static void m7856hm(Context context) {
        AppMethodBeat.m2504i(70109);
        if (ydj == null) {
            try {
                Object obj;
                ydi = new LongSparseArray();
                C5153c c5153c = new C5153c();
                ydj = c5153c;
                c5153c.ydi = ydi;
                c5153c = new C5153c();
                ydk = c5153c;
                c5153c.ydi = ydi;
                if (VERSION.SDK_INT >= 23) {
                    C5156a c5156a = new C5156a(context.getResources(), "mResourcesImpl");
                    if (c5156a.mo10617Mg()) {
                        obj = c5156a.get();
                    } else {
                        obj = context.getResources();
                    }
                } else {
                    obj = context.getResources();
                }
                C5154e.m7846a(context, obj);
                C5159c.m7869i("MicroMsg.SVGResourceLoader", "SVG this resources %s", context.getResources());
                AppMethodBeat.m2505o(70109);
                return;
            } catch (NoSuchFieldException e) {
                C5159c.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
                AppMethodBeat.m2505o(70109);
                return;
            } catch (IllegalAccessException e2) {
                C5159c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
                AppMethodBeat.m2505o(70109);
                return;
            } catch (IllegalArgumentException e3) {
                C5159c.printErrStackTrace("MicroMsg.SVGResourceLoader", e3, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(70109);
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m7846a(Context context, Object obj) {
        AppMethodBeat.m2504i(70110);
        Object obj2 = new C5156a(obj, "sPreloadedDrawables").get();
        if (obj2 == null) {
            C5159c.m7868e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
            AppMethodBeat.m2505o(70110);
        } else if (obj2 instanceof LongSparseArray[]) {
            int i;
            long keyAt;
            ydh = (LongSparseArray[]) obj2;
            C5159c.m7867d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", ydh[0]);
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
            AppMethodBeat.m2505o(70110);
        } else if (obj2 instanceof LongSparseArray) {
            C5156a c5156a = new C5156a(context.getResources(), "sPreloadedDrawables");
            LongSparseArray longSparseArray = (LongSparseArray) c5156a.get();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long keyAt2 = longSparseArray.keyAt(i2);
                ydj.put(keyAt2, longSparseArray.get(keyAt2));
            }
            C5153c c5153c = ydj;
            c5156a.prepare();
            if (c5156a.eum == null) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                AppMethodBeat.m2505o(70110);
                throw noSuchFieldException;
            }
            c5156a.eum.set(c5156a.obj, c5153c);
            if (c5156a.get() == null) {
                C5159c.m7868e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
            }
            AppMethodBeat.m2505o(70110);
        } else {
            C5159c.m7868e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
            AppMethodBeat.m2505o(70110);
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private static void m7844a(Application application, Resources resources, int i, TypedValue typedValue) {
        AppMethodBeat.m2504i(70111);
        if (i == 0) {
            C5159c.m7868e("MicroMsg.SVGResourceLoader", "preloadDrawable Why this id is %d. TypedValue %s", Integer.valueOf(i), typedValue);
            C5159c.m7869i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
        }
        resources.getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        C5152b c5152b = new C5152b(i, application.getResources(), j);
        synchronized (ydi) {
            try {
                ydi.put(j, c5152b);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(70111);
            }
        }
    }

    private static Class<?> dvI() {
        AppMethodBeat.m2504i(70112);
        if (cff != null) {
            Class cls = cff;
            AppMethodBeat.m2505o(70112);
            return cls;
        }
        Class<?> cls2;
        try {
            cls2 = Class.forName(sPackageName + ".R$raw");
            if (cls2 != null) {
                AppMethodBeat.m2505o(70112);
                return cls2;
            }
        } catch (ClassNotFoundException e) {
        }
        cls2 = C5157b.dvL();
        if (cls2 != null) {
            AppMethodBeat.m2505o(70112);
            return cls2;
        }
        AppMethodBeat.m2505o(70112);
        return null;
    }

    /* renamed from: c */
    private static void m7851c(Application application, Resources resources) {
        AppMethodBeat.m2504i(70113);
        Class dvI = C5154e.dvI();
        if (dvI == null) {
            C5159c.m7868e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
            AppMethodBeat.m2505o(70113);
            return;
        }
        Field[] declaredFields = dvI.getDeclaredFields();
        C5151a b = C5154e.m7849b(application, resources);
        try {
            C5147a c5147a = new C5147a();
            for (Field field : declaredFields) {
                int i = field.getInt(null);
                if (c5147a.mo10586g(application.getResources(), i)) {
                    C5154e.m7850b(b.ydq, b.mResources, i, b.ycK);
                }
            }
            ydf = true;
            AppMethodBeat.m2505o(70113);
        } catch (IllegalAccessException e) {
            ydf = false;
            AppMethodBeat.m2505o(70113);
        } catch (IllegalArgumentException e2) {
            ydf = false;
            AppMethodBeat.m2505o(70113);
        }
    }

    /* renamed from: d */
    public static Drawable m7852d(Resources resources, int i) {
        AppMethodBeat.m2504i(70114);
        ydp.set(Boolean.TRUE);
        Drawable drawable = resources.getDrawable(i);
        ydp.set(Boolean.FALSE);
        AppMethodBeat.m2505o(70114);
        return drawable;
    }

    /* renamed from: e */
    public static Drawable m7854e(Resources resources, int i) {
        Method declaredMethod;
        NotFoundException notFoundException;
        boolean z = true;
        AppMethodBeat.m2504i(70115);
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
                C4990ab.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "", new Object[0]);
                C4990ab.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "", new Object[0]);
                AppMethodBeat.m2505o(70115);
                return null;
            }
        }
        if (xuB == null) {
            try {
                declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[]{Integer.TYPE, String.class, Integer.TYPE});
                xuB = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                C4990ab.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                C4990ab.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                AppMethodBeat.m2505o(70115);
                return null;
            }
        }
        if (drawable == null) {
            if (typedValue.string == null) {
                NotFoundException notFoundException2 = new NotFoundException("Resource is not a Drawable (color or path): ".concat(String.valueOf(typedValue)));
                AppMethodBeat.m2505o(70115);
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
                    AppMethodBeat.m2505o(70115);
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
                AppMethodBeat.m2505o(70115);
                throw notFoundException;
            }
        }
        AppMethodBeat.m2505o(70115);
        return drawable;
    }

    /* renamed from: g */
    static /* synthetic */ Map m7855g(Resources resources) {
        AppMethodBeat.m2504i(70117);
        for (WeakReference weakReference : ydn.keySet()) {
            Resources resources2 = (Resources) weakReference.get();
            if (resources2 != null && resources2 == resources) {
                Map map = (Map) ydn.get(weakReference);
                AppMethodBeat.m2505o(70117);
                return map;
            }
        }
        AppMethodBeat.m2505o(70117);
        return null;
    }
}
