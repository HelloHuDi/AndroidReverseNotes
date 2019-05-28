package com.tencent.c.a.a;

import android.content.Context;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class n implements Runnable {
    public static long cbG = -1;
    private a cbE = null;
    int cbF = 0;
    private Context mContext = null;
    private int mType = 0;

    public n(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    private void zU() {
        AppMethodBeat.i(125732);
        g F = r.aI(this.mContext).F(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1)})));
        g F2 = r.aI(this.mContext).F(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
        g F3 = r.aI(this.mContext).F(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4)})));
        if (s.b(F, F2) && s.b(F, F3)) {
            s.zX();
            AppMethodBeat.o(125732);
            return;
        }
        F = s.a(s.a(F, F2), s.a(F, F3));
        new StringBuilder("local mid check failed, redress with mid:").append(F.toString());
        s.zX();
        r.aI(this.mContext).b(F);
        AppMethodBeat.o(125732);
    }

    private void d(JSONObject jSONObject) {
        AppMethodBeat.i(125733);
        if (i.cbu != null) {
            if (j.cbA == 1) {
                s.zX();
                AppMethodBeat.o(125733);
                return;
            } else if (j.cbB <= 0 || this.cbF <= j.cbB) {
                String jSONObject2 = new m(this.mContext, jSONObject).toJSONObject().toString();
                "request data:".concat(String.valueOf(jSONObject2));
                s.zX();
                i.cbu.cm("[" + jSONObject2 + "]");
                cbG = System.currentTimeMillis();
                this.cbF++;
            } else {
                new StringBuilder("limit dispatch:").append(j.cbB);
                s.zX();
                AppMethodBeat.o(125733);
                return;
            }
        }
        AppMethodBeat.o(125733);
    }

    public final void run() {
        AppMethodBeat.i(125734);
        new StringBuilder("request type:").append(this.mType);
        s.zX();
        switch (this.mType) {
            case 1:
                d(null);
                AppMethodBeat.o(125734);
                return;
            case 2:
                if (this.cbE == null) {
                    this.cbE = r.aI(this.mContext).zW();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i.cbv <= 0) {
                    i.cbv = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0);
                }
                long abs = Math.abs(currentTimeMillis - i.cbv);
                new StringBuilder("check entity: ").append(this.cbE.toString()).append(",duration:").append(abs);
                s.zX();
                if (this.cbE.caY < 0 || this.cbE.caY > 100) {
                    this.cbE.caY = 3;
                }
                long j = ((long) this.cbE.caY) * e.cbp;
                new StringBuilder("duration:").append(abs).append(",maxCheckDays:").append(j).append(",mLastCheckTime:").append(i.cbv).append(",mCheckEntity:").append(this.cbE);
                s.zX();
                if (abs >= j) {
                    zU();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("dur", abs);
                        jSONObject.put("md", j);
                        jSONObject.put("lct", i.cbv);
                        jSONObject.put("cur", currentTimeMillis);
                    } catch (JSONException e) {
                    }
                    if (cbG <= 0) {
                        d(jSONObject);
                    }
                } else if (abs > e.cbp) {
                    zU();
                    AppMethodBeat.o(125734);
                    return;
                }
                AppMethodBeat.o(125734);
                return;
            default:
                new StringBuilder("wrong type:").append(this.mType);
                s.zX();
                AppMethodBeat.o(125734);
                return;
        }
    }
}
