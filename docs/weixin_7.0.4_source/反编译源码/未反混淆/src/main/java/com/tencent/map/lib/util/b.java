package com.tencent.map.lib.util;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;

public class b {
    private static LinkedHashMap<String, a> a = new LinkedHashMap();

    public static class a {
        public int a;
        public Bitmap b;
    }

    static {
        AppMethodBeat.i(98245);
        AppMethodBeat.o(98245);
    }

    public static synchronized void a(String str, Bitmap bitmap) {
        synchronized (b.class) {
            AppMethodBeat.i(98241);
            if (a == null) {
                a = new LinkedHashMap();
            }
            a aVar;
            if (a.containsKey(str)) {
                aVar = (a) a.get(str);
                aVar.a++;
                AppMethodBeat.o(98241);
            } else {
                aVar = new a();
                aVar.b = bitmap;
                aVar.a = 1;
                a.put(str, aVar);
                AppMethodBeat.o(98241);
            }
        }
    }

    public static synchronized Bitmap a(String str) {
        Bitmap bitmap;
        synchronized (b.class) {
            AppMethodBeat.i(98242);
            if (a == null) {
                AppMethodBeat.o(98242);
                bitmap = null;
            } else {
                a aVar = (a) a.get(str);
                if (aVar != null) {
                    bitmap = aVar.b;
                    AppMethodBeat.o(98242);
                } else {
                    AppMethodBeat.o(98242);
                    bitmap = null;
                }
            }
        }
        return bitmap;
    }

    public static synchronized void b(String str) {
        synchronized (b.class) {
            AppMethodBeat.i(98243);
            if (a == null) {
                AppMethodBeat.o(98243);
            } else {
                a aVar = (a) a.get(str);
                if (aVar != null) {
                    aVar.a--;
                    if (aVar.a <= 0) {
                        a.remove(str);
                        if (VERSION.SDK_INT <= 10) {
                            Bitmap bitmap = aVar.b;
                            if (!(bitmap == null || bitmap.isRecycled())) {
                                bitmap.recycle();
                            }
                        }
                    }
                }
                AppMethodBeat.o(98243);
            }
        }
    }

    public static synchronized void a() {
        synchronized (b.class) {
            AppMethodBeat.i(98244);
            if (a != null) {
                a.clear();
            }
            AppMethodBeat.o(98244);
        }
    }
}
