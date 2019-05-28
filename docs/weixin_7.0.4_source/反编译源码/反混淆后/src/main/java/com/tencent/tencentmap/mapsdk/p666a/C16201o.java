package com.tencent.tencentmap.mapsdk.p666a;

import android.util.Log;
import com.tencent.map.lib.C1015d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.tencentmap.mapsdk.a.o */
public class C16201o {
    /* renamed from: a */
    private int f3113a;
    /* renamed from: b */
    private int f3114b;
    /* renamed from: c */
    private JSONArray f3115c;
    /* renamed from: d */
    private String[] f3116d;

    public C16201o(int i, int i2, JSONArray jSONArray) {
        AppMethodBeat.m2504i(98253);
        this.f3113a = i;
        this.f3114b = i2;
        this.f3115c = jSONArray;
        if (this.f3115c == null) {
            this.f3116d = null;
            AppMethodBeat.m2505o(98253);
            return;
        }
        int length = this.f3115c.length();
        this.f3116d = new String[length];
        int i3 = 0;
        while (i3 < length) {
            try {
                this.f3116d[i3] = this.f3115c.getString(i3);
                i3++;
            } catch (JSONException e) {
                this.f3116d = null;
                C1015d.m2290b(Log.getStackTraceString(e));
                AppMethodBeat.m2505o(98253);
                return;
            }
        }
        AppMethodBeat.m2505o(98253);
    }

    /* renamed from: a */
    public int mo29193a() {
        return this.f3113a;
    }

    /* renamed from: b */
    public int mo29194b() {
        return this.f3114b;
    }

    /* renamed from: c */
    public JSONArray mo29195c() {
        return this.f3115c;
    }

    /* renamed from: d */
    public String[] mo29196d() {
        return this.f3116d;
    }
}
