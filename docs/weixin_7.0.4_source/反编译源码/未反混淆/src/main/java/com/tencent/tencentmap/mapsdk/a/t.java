package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class t {
    private static String a;
    private static String b;

    public static void a(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(98271);
        if (!new File(str, str2).exists()) {
            b(context, str, str2, str3);
        }
        AppMethodBeat.o(98271);
    }

    public static final InputStream a(Context context, String str) {
        AppMethodBeat.i(98272);
        InputStream a = a(context, "tencentmap/mapsdk_vector/", str);
        AppMethodBeat.o(98272);
        return a;
    }

    public static final InputStream a(Context context, String str, String str2) {
        AppMethodBeat.i(98273);
        InputStream b = b(context, str + str2);
        AppMethodBeat.o(98273);
        return b;
    }

    public static final InputStream b(Context context, String str) {
        InputStream inputStream = null;
        AppMethodBeat.i(98274);
        if (context == null) {
            AppMethodBeat.o(98274);
        } else {
            AssetManager assets = context.getAssets();
            if (assets == null) {
                AppMethodBeat.o(98274);
            } else {
                try {
                    inputStream = assets.open(str);
                    AppMethodBeat.o(98274);
                } catch (IOException e) {
                    AppMethodBeat.o(98274);
                }
            }
        }
        return inputStream;
    }

    private static void b(Context context, String str, String str2, String str3) {
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        AppMethodBeat.i(98275);
        Closeable b;
        try {
            b = v.b(r.a(context).c(null) + str3);
            if (b == null) {
                try {
                    if (a != null) {
                        b = b(context, a + str3);
                    } else if (b != null) {
                        b = v.b(b + str3);
                    }
                } catch (IOException e) {
                    closeable = null;
                    v.a(closeable);
                    v.a(b);
                    AppMethodBeat.o(98275);
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = null;
                    v.a(closeable2);
                    v.a(b);
                    AppMethodBeat.o(98275);
                    throw th;
                }
            }
            if (b == null) {
                b = v.b(r.a(context).e() + str3);
            }
            if (b == null) {
                b = a(context, str3);
            }
            closeable = new FileOutputStream(new File(str, str2));
            try {
                v.a(b, closeable);
                v.a(closeable);
                v.a(b);
                AppMethodBeat.o(98275);
            } catch (IOException e2) {
                v.a(closeable);
                v.a(b);
                AppMethodBeat.o(98275);
            } catch (Throwable th3) {
                th = th3;
                closeable2 = closeable;
                v.a(closeable2);
                v.a(b);
                AppMethodBeat.o(98275);
                throw th;
            }
        } catch (IOException e3) {
            closeable = null;
            b = null;
        } catch (Throwable th22) {
            th = th22;
            closeable2 = null;
            b = null;
            v.a(closeable2);
            v.a(b);
            AppMethodBeat.o(98275);
            throw th;
        }
    }

    public static void a(String str) {
        AppMethodBeat.i(98276);
        if (!(str == null || str.trim().length() == 0)) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            a = str;
        }
        AppMethodBeat.o(98276);
    }

    public static void b(String str) {
        AppMethodBeat.i(98277);
        if (!(str == null || str.trim().length() == 0)) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            b = str;
        }
        AppMethodBeat.o(98277);
    }

    public static String a() {
        return a;
    }

    public static String b() {
        return b;
    }
}
