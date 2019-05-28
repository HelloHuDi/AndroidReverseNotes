package com.tencent.mm.plugin.game.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.game.report.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str) {
        AppMethodBeat.i(111691);
        a(context, i, i2, i3, i4, 0, null, i5, 0, null, null, str);
        AppMethodBeat.o(111691);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2) {
        AppMethodBeat.i(111692);
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, null, str2);
        AppMethodBeat.o(111692);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2, String str3) {
        AppMethodBeat.i(111693);
        a(context, i, i2, i3, i4, 0, str, i5, 0, null, str2, str3);
        AppMethodBeat.o(111693);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, String str2, String str3, String str4) {
        AppMethodBeat.i(111694);
        c.eBG.a(d.b(12909, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6), Integer.valueOf(i7), str2, Integer.valueOf(bo.getInt(str3, 0)), Integer.valueOf(a.getNetworkType(context)), str4));
        AppMethodBeat.o(111694);
    }

    public static String eA(String str, String str2) {
        AppMethodBeat.i(111695);
        if (str2 == null) {
            AppMethodBeat.o(111695);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("function_type", str);
            jSONObject.put("function_value", str2);
        } catch (JSONException e) {
        }
        String kY = a.kY(jSONObject.toString());
        AppMethodBeat.o(111695);
        return kY;
    }
}
