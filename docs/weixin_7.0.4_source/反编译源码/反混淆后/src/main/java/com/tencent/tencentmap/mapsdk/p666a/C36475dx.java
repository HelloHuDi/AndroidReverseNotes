package com.tencent.tencentmap.mapsdk.p666a;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dx */
public class C36475dx {
    /* renamed from: a */
    public static boolean f15238a = false;
    /* renamed from: b */
    public static final String f15239b = (C36475dx.m60310a() + "/js/nicolas/xkun/dynamic_map");

    static {
        AppMethodBeat.m2504i(101330);
        AppMethodBeat.m2505o(101330);
    }

    /* renamed from: a */
    public static String m60310a() {
        AppMethodBeat.m2504i(101329);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String str = "/sdcard";
        if (externalStorageDirectory != null) {
            str = externalStorageDirectory.getPath();
        }
        AppMethodBeat.m2505o(101329);
        return str;
    }
}
