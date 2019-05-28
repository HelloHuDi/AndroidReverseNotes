package com.tencent.tencentmap.mapsdk.a;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class dx {
    public static boolean a = false;
    public static final String b = (a() + "/js/nicolas/xkun/dynamic_map");

    static {
        AppMethodBeat.i(101330);
        AppMethodBeat.o(101330);
    }

    public static String a() {
        AppMethodBeat.i(101329);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String str = "/sdcard";
        if (externalStorageDirectory != null) {
            str = externalStorageDirectory.getPath();
        }
        AppMethodBeat.o(101329);
        return str;
    }
}
