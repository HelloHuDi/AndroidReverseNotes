package com.tencent.tencentmap.mapsdk.a;

import android.util.Log;
import com.tencent.map.lib.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONException;

public class o {
    private int a;
    private int b;
    private JSONArray c;
    private String[] d;

    public o(int i, int i2, JSONArray jSONArray) {
        AppMethodBeat.i(98253);
        this.a = i;
        this.b = i2;
        this.c = jSONArray;
        if (this.c == null) {
            this.d = null;
            AppMethodBeat.o(98253);
            return;
        }
        int length = this.c.length();
        this.d = new String[length];
        int i3 = 0;
        while (i3 < length) {
            try {
                this.d[i3] = this.c.getString(i3);
                i3++;
            } catch (JSONException e) {
                this.d = null;
                d.b(Log.getStackTraceString(e));
                AppMethodBeat.o(98253);
                return;
            }
        }
        AppMethodBeat.o(98253);
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public JSONArray c() {
        return this.c;
    }

    public String[] d() {
        return this.d;
    }
}
