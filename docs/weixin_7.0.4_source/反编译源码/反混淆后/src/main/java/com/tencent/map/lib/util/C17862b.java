package com.tencent.map.lib.util;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;

/* renamed from: com.tencent.map.lib.util.b */
public class C17862b {
    /* renamed from: a */
    private static LinkedHashMap<String, C17863a> f4313a = new LinkedHashMap();

    /* renamed from: com.tencent.map.lib.util.b$a */
    public static class C17863a {
        /* renamed from: a */
        public int f4314a;
        /* renamed from: b */
        public Bitmap f4315b;
    }

    static {
        AppMethodBeat.m2504i(98245);
        AppMethodBeat.m2505o(98245);
    }

    /* renamed from: a */
    public static synchronized void m27956a(String str, Bitmap bitmap) {
        synchronized (C17862b.class) {
            AppMethodBeat.m2504i(98241);
            if (f4313a == null) {
                f4313a = new LinkedHashMap();
            }
            C17863a c17863a;
            if (f4313a.containsKey(str)) {
                c17863a = (C17863a) f4313a.get(str);
                c17863a.f4314a++;
                AppMethodBeat.m2505o(98241);
            } else {
                c17863a = new C17863a();
                c17863a.f4315b = bitmap;
                c17863a.f4314a = 1;
                f4313a.put(str, c17863a);
                AppMethodBeat.m2505o(98241);
            }
        }
    }

    /* renamed from: a */
    public static synchronized Bitmap m27954a(String str) {
        Bitmap bitmap;
        synchronized (C17862b.class) {
            AppMethodBeat.m2504i(98242);
            if (f4313a == null) {
                AppMethodBeat.m2505o(98242);
                bitmap = null;
            } else {
                C17863a c17863a = (C17863a) f4313a.get(str);
                if (c17863a != null) {
                    bitmap = c17863a.f4315b;
                    AppMethodBeat.m2505o(98242);
                } else {
                    AppMethodBeat.m2505o(98242);
                    bitmap = null;
                }
            }
        }
        return bitmap;
    }

    /* renamed from: b */
    public static synchronized void m27957b(String str) {
        synchronized (C17862b.class) {
            AppMethodBeat.m2504i(98243);
            if (f4313a == null) {
                AppMethodBeat.m2505o(98243);
            } else {
                C17863a c17863a = (C17863a) f4313a.get(str);
                if (c17863a != null) {
                    c17863a.f4314a--;
                    if (c17863a.f4314a <= 0) {
                        f4313a.remove(str);
                        if (VERSION.SDK_INT <= 10) {
                            Bitmap bitmap = c17863a.f4315b;
                            if (!(bitmap == null || bitmap.isRecycled())) {
                                bitmap.recycle();
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(98243);
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m27955a() {
        synchronized (C17862b.class) {
            AppMethodBeat.m2504i(98244);
            if (f4313a != null) {
                f4313a.clear();
            }
            AppMethodBeat.m2505o(98244);
        }
    }
}
