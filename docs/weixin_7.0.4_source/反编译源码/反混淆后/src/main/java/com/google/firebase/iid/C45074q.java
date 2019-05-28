package com.google.firebase.iid;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.firebase.iid.q */
final class C45074q {
    private static final long bwd = TimeUnit.DAYS.toMillis(7);
    final String bwe;
    private final String bwf;
    private final long timestamp;

    static {
        AppMethodBeat.m2504i(108764);
        AppMethodBeat.m2505o(108764);
    }

    private C45074q(String str, String str2, long j) {
        this.bwe = str;
        this.bwf = str2;
        this.timestamp = j;
    }

    /* renamed from: b */
    static String m82700b(String str, String str2, long j) {
        AppMethodBeat.m2504i(108762);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("token", str);
            jSONObject2.put("appVersion", str2);
            jSONObject2.put(Param.TIMESTAMP, j);
            jSONObject = jSONObject2.toString();
            AppMethodBeat.m2505o(108762);
            return jSONObject;
        } catch (JSONException e) {
            jSONObject = String.valueOf(e);
            new StringBuilder(String.valueOf(jSONObject).length() + 24).append("Failed to encode token: ").append(jSONObject);
            AppMethodBeat.m2505o(108762);
            return null;
        }
    }

    /* renamed from: ba */
    static C45074q m82701ba(String str) {
        AppMethodBeat.m2504i(108761);
        C45074q c45074q;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(108761);
            return null;
        } else if (str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                c45074q = new C45074q(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(Param.TIMESTAMP));
                AppMethodBeat.m2505o(108761);
                return c45074q;
            } catch (JSONException e) {
                String valueOf = String.valueOf(e);
                new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to parse token: ").append(valueOf);
                AppMethodBeat.m2505o(108761);
                return null;
            }
        } else {
            c45074q = new C45074q(str, null, 0);
            AppMethodBeat.m2505o(108761);
            return c45074q;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bb */
    public final boolean mo72840bb(String str) {
        AppMethodBeat.m2504i(108763);
        if (System.currentTimeMillis() > this.timestamp + bwd || !str.equals(this.bwf)) {
            AppMethodBeat.m2505o(108763);
            return true;
        }
        AppMethodBeat.m2505o(108763);
        return false;
    }
}
