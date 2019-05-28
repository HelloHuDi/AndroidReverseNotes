package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.HashMap;
import java.util.Map;

public final class cv {
    public int a;
    public String b;
    public int c = 0;
    public byte[] d;
    private Map<String, String> e;

    public cv(int i, String str, int i2) {
        this.a = i;
        this.b = str;
    }

    public final String a(String str) {
        String str2;
        AppMethodBeat.i(98672);
        if (!(this.e == null || TextUtils.isEmpty(str))) {
            str2 = (String) this.e.get(str.toLowerCase());
            if (!TextUtils.isEmpty(str2)) {
                AppMethodBeat.o(98672);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.o(98672);
        return str2;
    }

    public final void a(Map<String, String> map) {
        AppMethodBeat.i(98671);
        this.e = new HashMap();
        if (map.size() > 0) {
            for (String str : map.keySet()) {
                this.e.put(str.toLowerCase(), map.get(str));
            }
        }
        AppMethodBeat.o(98671);
    }

    public final String toString() {
        AppMethodBeat.i(98673);
        String str = "errorCode:" + this.a + ",errorInfo:" + this.b + ",httpStatus:" + this.c + ",headers:" + this.e + ",body:" + (this.d != null ? Integer.valueOf(this.d.length) : BuildConfig.COMMAND);
        AppMethodBeat.o(98673);
        return str;
    }
}
