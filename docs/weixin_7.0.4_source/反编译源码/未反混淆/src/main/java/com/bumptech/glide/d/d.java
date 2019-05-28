package com.bumptech.glide.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class d {
    private final Context context;

    public d(Context context) {
        this.context = context;
    }

    public final List<b> nJ() {
        AppMethodBeat.i(92426);
        Log.isLoggable("ManifestParser", 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable("ManifestParser", 3);
                AppMethodBeat.o(92426);
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                new StringBuilder("Got app info metadata: ").append(applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(ac(str));
                    Log.isLoggable("ManifestParser", 3);
                }
            }
            Log.isLoggable("ManifestParser", 3);
            AppMethodBeat.o(92426);
            return arrayList;
        } catch (NameNotFoundException e) {
            RuntimeException runtimeException = new RuntimeException("Unable to find metadata to parse GlideModules", e);
            AppMethodBeat.o(92426);
            throw runtimeException;
        }
    }

    private static b ac(String str) {
        AppMethodBeat.i(92427);
        try {
            Class cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (InstantiationException e) {
                a(cls, e);
            } catch (IllegalAccessException e2) {
                a(cls, e2);
            } catch (NoSuchMethodException e3) {
                a(cls, e3);
            } catch (InvocationTargetException e4) {
                a(cls, e4);
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                AppMethodBeat.o(92427);
                return bVar;
            }
            RuntimeException runtimeException = new RuntimeException("Expected instanceof GlideModule, but found: ".concat(String.valueOf(obj)));
            AppMethodBeat.o(92427);
            throw runtimeException;
        } catch (ClassNotFoundException e5) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to find GlideModule implementation", e5);
            AppMethodBeat.o(92427);
            throw illegalArgumentException;
        }
    }

    private static void a(Class<?> cls, Exception exception) {
        AppMethodBeat.i(92428);
        RuntimeException runtimeException = new RuntimeException("Unable to instantiate GlideModule implementation for ".concat(String.valueOf(cls)), exception);
        AppMethodBeat.o(92428);
        throw runtimeException;
    }
}
