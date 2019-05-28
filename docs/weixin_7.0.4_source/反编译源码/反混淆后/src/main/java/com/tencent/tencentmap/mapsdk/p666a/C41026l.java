package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* renamed from: com.tencent.tencentmap.mapsdk.a.l */
public class C41026l {
    /* renamed from: a */
    private static volatile C41026l f16420a;
    /* renamed from: b */
    private String f16421b;
    /* renamed from: c */
    private String f16422c = (this.f16424e + File.separator + "vector.jar");
    /* renamed from: d */
    private String f16423d = (this.f16424e + File.separator + "libtxmapengine.so");
    /* renamed from: e */
    private String f16424e;
    /* renamed from: f */
    private String f16425f;

    private C41026l(Context context) {
        AppMethodBeat.m2504i(101234);
        this.f16421b = context.getDir("tencentMapTemp", 0).getAbsolutePath();
        this.f16424e = context.getDir("tencentMapLib", 0).getAbsolutePath();
        this.f16425f = context.getFilesDir().getAbsolutePath() + "/tencentMapSdk/dynamicAssets/";
        AppMethodBeat.m2505o(101234);
    }

    /* renamed from: a */
    public static C41026l m71300a(Context context) {
        AppMethodBeat.m2504i(101235);
        if (f16420a == null) {
            synchronized (C41026l.class) {
                try {
                    if (f16420a == null) {
                        f16420a = new C41026l(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(101235);
                    }
                }
            }
        }
        C41026l c41026l = f16420a;
        AppMethodBeat.m2505o(101235);
        return c41026l;
    }

    /* renamed from: a */
    public String mo65078a() {
        return this.f16421b;
    }

    /* renamed from: b */
    public String mo65079b() {
        return this.f16425f;
    }
}
