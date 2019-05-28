package com.tencent.p177mm.plugin.game.p1485e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.C45406d;
import com.tencent.p177mm.game.report.p1382b.C26319a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.e.b */
public final class C34277b {
    /* renamed from: a */
    public static void m56209a(Context context, int i, int i2, int i3, int i4, int i5, String str) {
        AppMethodBeat.m2504i(111691);
        C34277b.m56210a(context, i, i2, i3, i4, 0, null, i5, 0, null, null, str);
        AppMethodBeat.m2505o(111691);
    }

    /* renamed from: a */
    public static void m56211a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2) {
        AppMethodBeat.m2504i(111692);
        C34277b.m56210a(context, i, i2, i3, i4, 0, str, i5, 0, null, null, str2);
        AppMethodBeat.m2505o(111692);
    }

    /* renamed from: a */
    public static void m56212a(Context context, int i, int i2, int i3, int i4, String str, int i5, String str2, String str3) {
        AppMethodBeat.m2504i(111693);
        C34277b.m56210a(context, i, i2, i3, i4, 0, str, i5, 0, null, str2, str3);
        AppMethodBeat.m2505o(111693);
    }

    /* renamed from: a */
    public static void m56210a(Context context, int i, int i2, int i3, int i4, int i5, String str, int i6, int i7, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(111694);
        C37860c.eBG.mo60578a(C45406d.m83611b(12909, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6), Integer.valueOf(i7), str2, Integer.valueOf(C5046bo.getInt(str3, 0)), Integer.valueOf(C26319a.getNetworkType(context)), str4));
        AppMethodBeat.m2505o(111694);
    }

    /* renamed from: eA */
    public static String m56213eA(String str, String str2) {
        AppMethodBeat.m2504i(111695);
        if (str2 == null) {
            AppMethodBeat.m2505o(111695);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("function_type", str);
            jSONObject.put("function_value", str2);
        } catch (JSONException e) {
        }
        String kY = C26319a.m41875kY(jSONObject.toString());
        AppMethodBeat.m2505o(111695);
        return kY;
    }
}
