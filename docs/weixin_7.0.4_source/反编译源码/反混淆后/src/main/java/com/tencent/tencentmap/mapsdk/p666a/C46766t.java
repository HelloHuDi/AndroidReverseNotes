package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.tencentmap.mapsdk.a.t */
public class C46766t {
    /* renamed from: a */
    private static String f18061a;
    /* renamed from: b */
    private static String f18062b;

    /* renamed from: a */
    public static void m88677a(Context context, String str, String str2, String str3) {
        AppMethodBeat.m2504i(98271);
        if (!new File(str, str2).exists()) {
            C46766t.m88681b(context, str, str2, str3);
        }
        AppMethodBeat.m2505o(98271);
    }

    /* renamed from: a */
    public static final InputStream m88674a(Context context, String str) {
        AppMethodBeat.m2504i(98272);
        InputStream a = C46766t.m88675a(context, "tencentmap/mapsdk_vector/", str);
        AppMethodBeat.m2505o(98272);
        return a;
    }

    /* renamed from: a */
    public static final InputStream m88675a(Context context, String str, String str2) {
        AppMethodBeat.m2504i(98273);
        InputStream b = C46766t.m88679b(context, str + str2);
        AppMethodBeat.m2505o(98273);
        return b;
    }

    /* renamed from: b */
    public static final InputStream m88679b(Context context, String str) {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(98274);
        if (context == null) {
            AppMethodBeat.m2505o(98274);
        } else {
            AssetManager assets = context.getAssets();
            if (assets == null) {
                AppMethodBeat.m2505o(98274);
            } else {
                try {
                    inputStream = assets.open(str);
                    AppMethodBeat.m2505o(98274);
                } catch (IOException e) {
                    AppMethodBeat.m2505o(98274);
                }
            }
        }
        return inputStream;
    }

    /* renamed from: b */
    private static void m88681b(Context context, String str, String str2, String str3) {
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        AppMethodBeat.m2504i(98275);
        Closeable b;
        try {
            b = C31015v.m49804b(C46765r.m88663a(context).mo75318c(null) + str3);
            if (b == null) {
                try {
                    if (f18061a != null) {
                        b = C46766t.m88679b(context, f18061a + str3);
                    } else if (f18062b != null) {
                        b = C31015v.m49804b(f18062b + str3);
                    }
                } catch (IOException e) {
                    closeable = null;
                    C31015v.m49801a(closeable);
                    C31015v.m49801a(b);
                    AppMethodBeat.m2505o(98275);
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = null;
                    C31015v.m49801a(closeable2);
                    C31015v.m49801a(b);
                    AppMethodBeat.m2505o(98275);
                    throw th;
                }
            }
            if (b == null) {
                b = C31015v.m49804b(C46765r.m88663a(context).mo75321e() + str3);
            }
            if (b == null) {
                b = C46766t.m88674a(context, str3);
            }
            closeable = new FileOutputStream(new File(str, str2));
            try {
                C31015v.m49799a(b, closeable);
                C31015v.m49801a(closeable);
                C31015v.m49801a(b);
                AppMethodBeat.m2505o(98275);
            } catch (IOException e2) {
                C31015v.m49801a(closeable);
                C31015v.m49801a(b);
                AppMethodBeat.m2505o(98275);
            } catch (Throwable th3) {
                th = th3;
                closeable2 = closeable;
                C31015v.m49801a(closeable2);
                C31015v.m49801a(b);
                AppMethodBeat.m2505o(98275);
                throw th;
            }
        } catch (IOException e3) {
            closeable = null;
            b = null;
        } catch (Throwable th22) {
            th = th22;
            closeable2 = null;
            b = null;
            C31015v.m49801a(closeable2);
            C31015v.m49801a(b);
            AppMethodBeat.m2505o(98275);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m88678a(String str) {
        AppMethodBeat.m2504i(98276);
        if (!(str == null || str.trim().length() == 0)) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            f18061a = str;
        }
        AppMethodBeat.m2505o(98276);
    }

    /* renamed from: b */
    public static void m88682b(String str) {
        AppMethodBeat.m2504i(98277);
        if (!(str == null || str.trim().length() == 0)) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            f18062b = str;
        }
        AppMethodBeat.m2505o(98277);
    }

    /* renamed from: a */
    public static String m88676a() {
        return f18061a;
    }

    /* renamed from: b */
    public static String m88680b() {
        return f18062b;
    }
}
