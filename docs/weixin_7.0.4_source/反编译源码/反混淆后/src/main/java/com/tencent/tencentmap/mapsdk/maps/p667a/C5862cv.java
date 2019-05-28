package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cv */
public final class C5862cv {
    /* renamed from: a */
    public int f1540a;
    /* renamed from: b */
    public String f1541b;
    /* renamed from: c */
    public int f1542c = 0;
    /* renamed from: d */
    public byte[] f1543d;
    /* renamed from: e */
    private Map<String, String> f1544e;

    public C5862cv(int i, String str, int i2) {
        this.f1540a = i;
        this.f1541b = str;
    }

    /* renamed from: a */
    public final String mo12406a(String str) {
        String str2;
        AppMethodBeat.m2504i(98672);
        if (!(this.f1544e == null || TextUtils.isEmpty(str))) {
            str2 = (String) this.f1544e.get(str.toLowerCase());
            if (!TextUtils.isEmpty(str2)) {
                AppMethodBeat.m2505o(98672);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.m2505o(98672);
        return str2;
    }

    /* renamed from: a */
    public final void mo12407a(Map<String, String> map) {
        AppMethodBeat.m2504i(98671);
        this.f1544e = new HashMap();
        if (map.size() > 0) {
            for (String str : map.keySet()) {
                this.f1544e.put(str.toLowerCase(), map.get(str));
            }
        }
        AppMethodBeat.m2505o(98671);
    }

    public final String toString() {
        AppMethodBeat.m2504i(98673);
        String str = "errorCode:" + this.f1540a + ",errorInfo:" + this.f1541b + ",httpStatus:" + this.f1542c + ",headers:" + this.f1544e + ",body:" + (this.f1543d != null ? Integer.valueOf(this.f1543d.length) : BuildConfig.COMMAND);
        AppMethodBeat.m2505o(98673);
        return str;
    }
}
