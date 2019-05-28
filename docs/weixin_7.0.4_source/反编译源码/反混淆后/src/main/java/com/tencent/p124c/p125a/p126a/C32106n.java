package com.tencent.p124c.p125a.p126a;

import android.content.Context;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.c.a.a.n */
public final class C32106n implements Runnable {
    public static long cbG = -1;
    private C25593a cbE = null;
    int cbF = 0;
    private Context mContext = null;
    private int mType = 0;

    public C32106n(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    /* renamed from: zU */
    private void m52245zU() {
        AppMethodBeat.m2504i(125732);
        C37314g F = C0914r.m2068aI(this.mContext).mo3744F(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1)})));
        C37314g F2 = C0914r.m2068aI(this.mContext).mo3744F(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
        C37314g F3 = C0914r.m2068aI(this.mContext).mo3744F(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4)})));
        if (C0916s.m2084b(F, F2) && C0916s.m2084b(F, F3)) {
            C0916s.m2088zX();
            AppMethodBeat.m2505o(125732);
            return;
        }
        F = C0916s.m2075a(C0916s.m2075a(F, F2), C0916s.m2075a(F, F3));
        new StringBuilder("local mid check failed, redress with mid:").append(F.toString());
        C0916s.m2088zX();
        C0914r.m2068aI(this.mContext).mo3746b(F);
        AppMethodBeat.m2505o(125732);
    }

    /* renamed from: d */
    private void m52244d(JSONObject jSONObject) {
        AppMethodBeat.m2504i(125733);
        if (C8756i.cbu != null) {
            if (C0913j.cbA == 1) {
                C0916s.m2088zX();
                AppMethodBeat.m2505o(125733);
                return;
            } else if (C0913j.cbB <= 0 || this.cbF <= C0913j.cbB) {
                String jSONObject2 = new C32105m(this.mContext, jSONObject).toJSONObject().toString();
                "request data:".concat(String.valueOf(jSONObject2));
                C0916s.m2088zX();
                C8756i.cbu.mo47010cm("[" + jSONObject2 + "]");
                cbG = System.currentTimeMillis();
                this.cbF++;
            } else {
                new StringBuilder("limit dispatch:").append(C0913j.cbB);
                C0916s.m2088zX();
                AppMethodBeat.m2505o(125733);
                return;
            }
        }
        AppMethodBeat.m2505o(125733);
    }

    public final void run() {
        AppMethodBeat.m2504i(125734);
        new StringBuilder("request type:").append(this.mType);
        C0916s.m2088zX();
        switch (this.mType) {
            case 1:
                m52244d(null);
                AppMethodBeat.m2505o(125734);
                return;
            case 2:
                if (this.cbE == null) {
                    this.cbE = C0914r.m2068aI(this.mContext).mo3748zW();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (C8756i.cbv <= 0) {
                    C8756i.cbv = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0);
                }
                long abs = Math.abs(currentTimeMillis - C8756i.cbv);
                new StringBuilder("check entity: ").append(this.cbE.toString()).append(",duration:").append(abs);
                C0916s.m2088zX();
                if (this.cbE.caY < 0 || this.cbE.caY > 100) {
                    this.cbE.caY = 3;
                }
                long j = ((long) this.cbE.caY) * C37313e.cbp;
                new StringBuilder("duration:").append(abs).append(",maxCheckDays:").append(j).append(",mLastCheckTime:").append(C8756i.cbv).append(",mCheckEntity:").append(this.cbE);
                C0916s.m2088zX();
                if (abs >= j) {
                    m52245zU();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("dur", abs);
                        jSONObject.put("md", j);
                        jSONObject.put("lct", C8756i.cbv);
                        jSONObject.put("cur", currentTimeMillis);
                    } catch (JSONException e) {
                    }
                    if (cbG <= 0) {
                        m52244d(jSONObject);
                    }
                } else if (abs > C37313e.cbp) {
                    m52245zU();
                    AppMethodBeat.m2505o(125734);
                    return;
                }
                AppMethodBeat.m2505o(125734);
                return;
            default:
                new StringBuilder("wrong type:").append(this.mType);
                C0916s.m2088zX();
                AppMethodBeat.m2505o(125734);
                return;
        }
    }
}
