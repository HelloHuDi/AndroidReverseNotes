package com.bumptech.glide.p789d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* renamed from: com.bumptech.glide.d.d */
public final class C8556d {
    private final Context context;

    public C8556d(Context context) {
        this.context = context;
    }

    /* renamed from: nJ */
    public final List<C41566b> mo18660nJ() {
        AppMethodBeat.m2504i(92426);
        Log.isLoggable("ManifestParser", 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable("ManifestParser", 3);
                AppMethodBeat.m2505o(92426);
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                new StringBuilder("Got app info metadata: ").append(applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(C8556d.m15209ac(str));
                    Log.isLoggable("ManifestParser", 3);
                }
            }
            Log.isLoggable("ManifestParser", 3);
            AppMethodBeat.m2505o(92426);
            return arrayList;
        } catch (NameNotFoundException e) {
            RuntimeException runtimeException = new RuntimeException("Unable to find metadata to parse GlideModules", e);
            AppMethodBeat.m2505o(92426);
            throw runtimeException;
        }
    }

    /* renamed from: ac */
    private static C41566b m15209ac(String str) {
        AppMethodBeat.m2504i(92427);
        try {
            Class cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InstantiationException e) {
                C8556d.m15208a(cls, e);
            } catch (IllegalAccessException e2) {
                C8556d.m15208a(cls, e2);
            } catch (NoSuchMethodException e3) {
                C8556d.m15208a(cls, e3);
            } catch (InvocationTargetException e4) {
                C8556d.m15208a(cls, e4);
            }
            if (obj instanceof C41566b) {
                C41566b c41566b = (C41566b) obj;
                AppMethodBeat.m2505o(92427);
                return c41566b;
            }
            RuntimeException runtimeException = new RuntimeException("Expected instanceof GlideModule, but found: ".concat(String.valueOf(obj)));
            AppMethodBeat.m2505o(92427);
            throw runtimeException;
        } catch (ClassNotFoundException e5) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to find GlideModule implementation", e5);
            AppMethodBeat.m2505o(92427);
            throw illegalArgumentException;
        }
    }

    /* renamed from: a */
    private static void m15208a(Class<?> cls, Exception exception) {
        AppMethodBeat.m2504i(92428);
        RuntimeException runtimeException = new RuntimeException("Unable to instantiate GlideModule implementation for ".concat(String.valueOf(cls)), exception);
        AppMethodBeat.m2505o(92428);
        throw runtimeException;
    }
}
