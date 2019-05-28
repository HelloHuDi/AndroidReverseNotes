package com.tencent.tencentmap.mapsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hm;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import java.io.File;

public class r {
    private static r a = null;
    private Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    private r(Context context) {
        AppMethodBeat.i(98262);
        if (context == null) {
            Error error = new Error("context can not be null");
            AppMethodBeat.o(98262);
            throw error;
        }
        this.b = context.getApplicationContext();
        String b = b(context);
        String a = hm.a(this.b);
        if (StringUtil.isEmpty(a)) {
            this.c = b + "/tencentmapsdk/";
        } else {
            this.c = b + "/tencentmapsdk/" + a;
        }
        this.d = this.c + "/data/v3/render/";
        this.e = this.c + "/sat/";
        this.j = context.getFilesDir().getAbsolutePath();
        this.g = this.j + "/tencentMapSdk/config/";
        this.k = this.g + "temp/";
        this.h = this.j + "/tencentMapSdk/assets/";
        this.i = this.j + "/tencentMapSdk/dynamicAssets/";
        this.f = this.d + "closeRoadDatas/";
        a(context, w.a(context).a("sdkVersion"));
        AppMethodBeat.o(98262);
    }

    public static r a(Context context) {
        AppMethodBeat.i(98263);
        if (a == null) {
            a = new r(context);
        }
        r rVar = a;
        AppMethodBeat.o(98263);
        return rVar;
    }

    public void a(Context context, String str) {
        AppMethodBeat.i(98264);
        if (StringUtil.isEmpty(w.a(context).a("sdkVersion"))) {
            AppMethodBeat.o(98264);
            return;
        }
        if (ic.b("4.1.0", str) > 0) {
            u.a(context);
            hm.a(new File(this.g));
            hm.a(new File(this.h));
            hm.a(new File(this.j + "/tencentMapSdk/subKey/"));
        }
        AppMethodBeat.o(98264);
    }

    public static String b(Context context) {
        int checkPermission;
        String path;
        Object obj = null;
        AppMethodBeat.i(98265);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        int checkPermission2;
        if (VERSION.SDK_INT >= 23) {
            checkPermission = context.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
            checkPermission2 = context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
        } else {
            checkPermission2 = 0;
            checkPermission = 0;
        }
        if (checkPermission == 0 && checkPermission2 == 0) {
            obj = 1;
        }
        if (!equals || obj == null) {
            path = context.getFilesDir().getPath();
        } else {
            path = Environment.getExternalStorageDirectory().getPath();
            if (a(path) < 5) {
                path = context.getFilesDir().getPath();
                if (a(path) < 5) {
                    path = Environment.getExternalStorageDirectory().getPath();
                }
            }
        }
        AppMethodBeat.o(98265);
        return path;
    }

    @SuppressLint({"NewApi"})
    public static long a(String str) {
        AppMethodBeat.i(98266);
        try {
            long blockSize;
            long availableBlocks;
            StatFs statFs = new StatFs(str);
            if (VERSION.SDK_INT < 18) {
                blockSize = (long) statFs.getBlockSize();
                availableBlocks = (long) statFs.getAvailableBlocks();
            } else {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            }
            availableBlocks = ((availableBlocks * blockSize) / 1024) / 1024;
            AppMethodBeat.o(98266);
            return availableBlocks;
        } catch (Exception e) {
            AppMethodBeat.o(98266);
            return 0;
        }
    }

    public File a() {
        AppMethodBeat.i(98267);
        File file = new File(this.c + "/data/");
        AppMethodBeat.o(98267);
        return file;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public String b(String str) {
        AppMethodBeat.i(98268);
        String str2;
        if (StringUtil.isEmpty(str)) {
            str2 = this.g;
            AppMethodBeat.o(98268);
            return str2;
        }
        str2 = this.j + "/tencentMapSdk/subKey/" + str + "/config/";
        AppMethodBeat.o(98268);
        return str2;
    }

    public String c(String str) {
        AppMethodBeat.i(98269);
        String str2;
        if (StringUtil.isEmpty(str)) {
            str2 = this.h;
            AppMethodBeat.o(98269);
            return str2;
        }
        str2 = this.j + "/tencentMapSdk/subKey/" + str + "/assets/";
        AppMethodBeat.o(98269);
        return str2;
    }

    public String e() {
        return this.i;
    }

    public String d(String str) {
        AppMethodBeat.i(98270);
        String str2;
        if (StringUtil.isEmpty(str)) {
            str2 = this.k;
            AppMethodBeat.o(98270);
            return str2;
        }
        str2 = b(str) + "temp/";
        AppMethodBeat.o(98270);
        return str2;
    }
}
