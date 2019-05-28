package com.google.firebase.iid;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class q {
    private static final long bwd = TimeUnit.DAYS.toMillis(7);
    final String bwe;
    private final String bwf;
    private final long timestamp;

    static {
        AppMethodBeat.i(108764);
        AppMethodBeat.o(108764);
    }

    private q(String str, String str2, long j) {
        this.bwe = str;
        this.bwf = str2;
        this.timestamp = j;
    }

    static String b(String str, String str2, long j) {
        AppMethodBeat.i(108762);
        String jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("token", str);
            jSONObject2.put("appVersion", str2);
            jSONObject2.put(Param.TIMESTAMP, j);
            jSONObject = jSONObject2.toString();
            AppMethodBeat.o(108762);
            return jSONObject;
        } catch (JSONException e) {
            jSONObject = String.valueOf(e);
            new StringBuilder(String.valueOf(jSONObject).length() + 24).append("Failed to encode token: ").append(jSONObject);
            AppMethodBeat.o(108762);
            return null;
        }
    }

    static q ba(String str) {
        AppMethodBeat.i(108761);
        q qVar;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(108761);
            return null;
        } else if (str.startsWith("{")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                qVar = new q(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(Param.TIMESTAMP));
                AppMethodBeat.o(108761);
                return qVar;
            } catch (JSONException e) {
                String valueOf = String.valueOf(e);
                new StringBuilder(String.valueOf(valueOf).length() + 23).append("Failed to parse token: ").append(valueOf);
                AppMethodBeat.o(108761);
                return null;
            }
        } else {
            qVar = new q(str, null, 0);
            AppMethodBeat.o(108761);
            return qVar;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean bb(String str) {
        AppMethodBeat.i(108763);
        if (System.currentTimeMillis() > this.timestamp + bwd || !str.equals(this.bwf)) {
            AppMethodBeat.o(108763);
            return true;
        }
        AppMethodBeat.o(108763);
        return false;
    }
}
