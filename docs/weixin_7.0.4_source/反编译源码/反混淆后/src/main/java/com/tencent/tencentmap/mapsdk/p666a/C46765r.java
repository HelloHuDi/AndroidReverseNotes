package com.tencent.tencentmap.mapsdk.p666a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16272hm;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import java.io.File;

/* renamed from: com.tencent.tencentmap.mapsdk.a.r */
public class C46765r {
    /* renamed from: a */
    private static C46765r f18050a = null;
    /* renamed from: b */
    private Context f18051b;
    /* renamed from: c */
    private String f18052c;
    /* renamed from: d */
    private String f18053d;
    /* renamed from: e */
    private String f18054e;
    /* renamed from: f */
    private String f18055f;
    /* renamed from: g */
    private String f18056g;
    /* renamed from: h */
    private String f18057h;
    /* renamed from: i */
    private String f18058i;
    /* renamed from: j */
    private String f18059j;
    /* renamed from: k */
    private String f18060k;

    private C46765r(Context context) {
        AppMethodBeat.m2504i(98262);
        if (context == null) {
            Error error = new Error("context can not be null");
            AppMethodBeat.m2505o(98262);
            throw error;
        }
        this.f18051b = context.getApplicationContext();
        String b = C46765r.m88664b(context);
        String a = C16272hm.m24957a(this.f18051b);
        if (StringUtil.isEmpty(a)) {
            this.f18052c = b + "/tencentmapsdk/";
        } else {
            this.f18052c = b + "/tencentmapsdk/" + a;
        }
        this.f18053d = this.f18052c + "/data/v3/render/";
        this.f18054e = this.f18052c + "/sat/";
        this.f18059j = context.getFilesDir().getAbsolutePath();
        this.f18056g = this.f18059j + "/tencentMapSdk/config/";
        this.f18060k = this.f18056g + "temp/";
        this.f18057h = this.f18059j + "/tencentMapSdk/assets/";
        this.f18058i = this.f18059j + "/tencentMapSdk/dynamicAssets/";
        this.f18055f = this.f18053d + "closeRoadDatas/";
        mo75314a(context, C31016w.m49806a(context).mo65080a("sdkVersion"));
        AppMethodBeat.m2505o(98262);
    }

    /* renamed from: a */
    public static C46765r m88663a(Context context) {
        AppMethodBeat.m2504i(98263);
        if (f18050a == null) {
            f18050a = new C46765r(context);
        }
        C46765r c46765r = f18050a;
        AppMethodBeat.m2505o(98263);
        return c46765r;
    }

    /* renamed from: a */
    public void mo75314a(Context context, String str) {
        AppMethodBeat.m2504i(98264);
        if (StringUtil.isEmpty(C31016w.m49806a(context).mo65080a("sdkVersion"))) {
            AppMethodBeat.m2505o(98264);
            return;
        }
        if (C36520ic.m60481b("4.1.0", str) > 0) {
            C41355u.m72124a(context);
            C16272hm.m24956a(new File(this.f18056g));
            C16272hm.m24956a(new File(this.f18057h));
            C16272hm.m24956a(new File(this.f18059j + "/tencentMapSdk/subKey/"));
        }
        AppMethodBeat.m2505o(98264);
    }

    /* renamed from: b */
    public static String m88664b(Context context) {
        int checkPermission;
        String path;
        Object obj = null;
        AppMethodBeat.m2504i(98265);
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
            if (C46765r.m88662a(path) < 5) {
                path = context.getFilesDir().getPath();
                if (C46765r.m88662a(path) < 5) {
                    path = Environment.getExternalStorageDirectory().getPath();
                }
            }
        }
        AppMethodBeat.m2505o(98265);
        return path;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static long m88662a(String str) {
        AppMethodBeat.m2504i(98266);
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
            AppMethodBeat.m2505o(98266);
            return availableBlocks;
        } catch (Exception e) {
            AppMethodBeat.m2505o(98266);
            return 0;
        }
    }

    /* renamed from: a */
    public File mo75313a() {
        AppMethodBeat.m2504i(98267);
        File file = new File(this.f18052c + "/data/");
        AppMethodBeat.m2505o(98267);
        return file;
    }

    /* renamed from: b */
    public String mo75315b() {
        return this.f18053d;
    }

    /* renamed from: c */
    public String mo75317c() {
        return this.f18054e;
    }

    /* renamed from: d */
    public String mo75319d() {
        return this.f18055f;
    }

    /* renamed from: b */
    public String mo75316b(String str) {
        AppMethodBeat.m2504i(98268);
        String str2;
        if (StringUtil.isEmpty(str)) {
            str2 = this.f18056g;
            AppMethodBeat.m2505o(98268);
            return str2;
        }
        str2 = this.f18059j + "/tencentMapSdk/subKey/" + str + "/config/";
        AppMethodBeat.m2505o(98268);
        return str2;
    }

    /* renamed from: c */
    public String mo75318c(String str) {
        AppMethodBeat.m2504i(98269);
        String str2;
        if (StringUtil.isEmpty(str)) {
            str2 = this.f18057h;
            AppMethodBeat.m2505o(98269);
            return str2;
        }
        str2 = this.f18059j + "/tencentMapSdk/subKey/" + str + "/assets/";
        AppMethodBeat.m2505o(98269);
        return str2;
    }

    /* renamed from: e */
    public String mo75321e() {
        return this.f18058i;
    }

    /* renamed from: d */
    public String mo75320d(String str) {
        AppMethodBeat.m2504i(98270);
        String str2;
        if (StringUtil.isEmpty(str)) {
            str2 = this.f18060k;
            AppMethodBeat.m2505o(98270);
            return str2;
        }
        str2 = mo75316b(str) + "temp/";
        AppMethodBeat.m2505o(98270);
        return str2;
    }
}
