package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedHashSet;

/* renamed from: com.tencent.tencentmap.mapsdk.a.aa */
public class C16176aa {
    /* renamed from: a */
    private static volatile C16176aa f3066a;
    /* renamed from: b */
    private SharedPreferences f3067b;

    private C16176aa(Context context) {
        AppMethodBeat.m2504i(101245);
        this.f3067b = context.getSharedPreferences("com.tencent.tencentmap.vector.dynamic", 0);
        AppMethodBeat.m2505o(101245);
    }

    /* renamed from: a */
    public static C16176aa m24541a(Context context) {
        AppMethodBeat.m2504i(101246);
        if (f3066a == null) {
            synchronized (C16176aa.class) {
                try {
                    if (f3066a == null) {
                        f3066a = new C16176aa(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(101246);
                    }
                }
            }
        }
        C16176aa c16176aa = f3066a;
        AppMethodBeat.m2505o(101246);
        return c16176aa;
    }

    /* renamed from: a */
    public boolean mo29046a(String[] strArr) {
        int i = 0;
        AppMethodBeat.m2504i(101247);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(101247);
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (i < strArr.length - 1) {
            stringBuffer.append(strArr[i] + ";");
            i++;
        }
        stringBuffer.append(strArr[strArr.length - 1]);
        boolean commit = this.f3067b.edit().putString("supportVectorOtaVersions", stringBuffer.toString()).commit();
        AppMethodBeat.m2505o(101247);
        return commit;
    }

    /* renamed from: a */
    public String[] mo29047a() {
        AppMethodBeat.m2504i(101248);
        String string = this.f3067b.getString("supportVectorOtaVersions", null);
        if (string == null) {
            AppMethodBeat.m2505o(101248);
            return null;
        }
        String[] split = string.split(";");
        AppMethodBeat.m2505o(101248);
        return split;
    }

    /* renamed from: a */
    public boolean mo29045a(String str) {
        AppMethodBeat.m2504i(101249);
        boolean commit;
        if (str == null) {
            AppMethodBeat.m2505o(101249);
            return false;
        } else if (this.f3067b.getString("supportVectorOtaVersions", null) == null) {
            commit = this.f3067b.edit().putString("supportVectorOtaVersions", str).commit();
            AppMethodBeat.m2505o(101249);
            return commit;
        } else {
            String[] a = mo29047a();
            if (a == null) {
                AppMethodBeat.m2505o(101249);
                return false;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(a));
            linkedHashSet.add(str);
            commit = mo29046a((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
            AppMethodBeat.m2505o(101249);
            return commit;
        }
    }

    /* renamed from: b */
    public boolean mo29049b(String str) {
        AppMethodBeat.m2504i(101250);
        boolean commit = this.f3067b.edit().putString("vectorMapConfigMd5", str).commit();
        AppMethodBeat.m2505o(101250);
        return commit;
    }

    /* renamed from: b */
    public String mo29048b() {
        AppMethodBeat.m2504i(101251);
        String string = this.f3067b.getString("vectorMapConfigMd5", null);
        AppMethodBeat.m2505o(101251);
        return string;
    }

    /* renamed from: c */
    public boolean mo29051c(String str) {
        AppMethodBeat.m2504i(101252);
        boolean commit = this.f3067b.edit().putString("vectorMapPoiIconMd5", str).commit();
        AppMethodBeat.m2505o(101252);
        return commit;
    }

    /* renamed from: c */
    public String mo29050c() {
        AppMethodBeat.m2504i(101253);
        String string = this.f3067b.getString("vectorMapPoiIconMd5", null);
        AppMethodBeat.m2505o(101253);
        return string;
    }

    /* renamed from: d */
    public String mo29052d() {
        AppMethodBeat.m2504i(101254);
        String string = this.f3067b.getString("dynamicMapSdkVectorVersion", "");
        AppMethodBeat.m2505o(101254);
        return string;
    }

    /* renamed from: d */
    public boolean mo29053d(String str) {
        AppMethodBeat.m2504i(101255);
        boolean commit = this.f3067b.edit().putString("dynamicMapSdkVectorVersion", str).commit();
        AppMethodBeat.m2505o(101255);
        return commit;
    }
}
