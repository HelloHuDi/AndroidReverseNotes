package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class l {
    private static volatile l a;
    private String b;
    private String c = (this.e + File.separator + "vector.jar");
    private String d = (this.e + File.separator + "libtxmapengine.so");
    private String e;
    private String f;

    private l(Context context) {
        AppMethodBeat.i(101234);
        this.b = context.getDir("tencentMapTemp", 0).getAbsolutePath();
        this.e = context.getDir("tencentMapLib", 0).getAbsolutePath();
        this.f = context.getFilesDir().getAbsolutePath() + "/tencentMapSdk/dynamicAssets/";
        AppMethodBeat.o(101234);
    }

    public static l a(Context context) {
        AppMethodBeat.i(101235);
        if (a == null) {
            synchronized (l.class) {
                try {
                    if (a == null) {
                        a = new l(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(101235);
                    }
                }
            }
        }
        l lVar = a;
        AppMethodBeat.o(101235);
        return lVar;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f;
    }
}
