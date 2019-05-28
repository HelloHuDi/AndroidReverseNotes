package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class aa {
    private static volatile aa a;
    private SharedPreferences b;

    private aa(Context context) {
        AppMethodBeat.i(101245);
        this.b = context.getSharedPreferences("com.tencent.tencentmap.vector.dynamic", 0);
        AppMethodBeat.o(101245);
    }

    public static aa a(Context context) {
        AppMethodBeat.i(101246);
        if (a == null) {
            synchronized (aa.class) {
                try {
                    if (a == null) {
                        a = new aa(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(101246);
                    }
                }
            }
        }
        aa aaVar = a;
        AppMethodBeat.o(101246);
        return aaVar;
    }

    public boolean a(String[] strArr) {
        int i = 0;
        AppMethodBeat.i(101247);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(101247);
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (i < strArr.length - 1) {
            stringBuffer.append(strArr[i] + ";");
            i++;
        }
        stringBuffer.append(strArr[strArr.length - 1]);
        boolean commit = this.b.edit().putString("supportVectorOtaVersions", stringBuffer.toString()).commit();
        AppMethodBeat.o(101247);
        return commit;
    }

    public String[] a() {
        AppMethodBeat.i(101248);
        String string = this.b.getString("supportVectorOtaVersions", null);
        if (string == null) {
            AppMethodBeat.o(101248);
            return null;
        }
        String[] split = string.split(";");
        AppMethodBeat.o(101248);
        return split;
    }

    public boolean a(String str) {
        AppMethodBeat.i(101249);
        boolean commit;
        if (str == null) {
            AppMethodBeat.o(101249);
            return false;
        } else if (this.b.getString("supportVectorOtaVersions", null) == null) {
            commit = this.b.edit().putString("supportVectorOtaVersions", str).commit();
            AppMethodBeat.o(101249);
            return commit;
        } else {
            String[] a = a();
            if (a == null) {
                AppMethodBeat.o(101249);
                return false;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(a));
            linkedHashSet.add(str);
            commit = a((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
            AppMethodBeat.o(101249);
            return commit;
        }
    }

    public boolean b(String str) {
        AppMethodBeat.i(101250);
        boolean commit = this.b.edit().putString("vectorMapConfigMd5", str).commit();
        AppMethodBeat.o(101250);
        return commit;
    }

    public String b() {
        AppMethodBeat.i(101251);
        String string = this.b.getString("vectorMapConfigMd5", null);
        AppMethodBeat.o(101251);
        return string;
    }

    public boolean c(String str) {
        AppMethodBeat.i(101252);
        boolean commit = this.b.edit().putString("vectorMapPoiIconMd5", str).commit();
        AppMethodBeat.o(101252);
        return commit;
    }

    public String c() {
        AppMethodBeat.i(101253);
        String string = this.b.getString("vectorMapPoiIconMd5", null);
        AppMethodBeat.o(101253);
        return string;
    }

    public String d() {
        AppMethodBeat.i(101254);
        String string = this.b.getString("dynamicMapSdkVectorVersion", "");
        AppMethodBeat.o(101254);
        return string;
    }

    public boolean d(String str) {
        AppMethodBeat.i(101255);
        boolean commit = this.b.edit().putString("dynamicMapSdkVectorVersion", str).commit();
        AppMethodBeat.o(101255);
        return commit;
    }
}
