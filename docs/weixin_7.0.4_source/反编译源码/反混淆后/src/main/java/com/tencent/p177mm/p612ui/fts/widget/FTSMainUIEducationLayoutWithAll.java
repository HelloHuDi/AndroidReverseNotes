package com.tencent.p177mm.p612ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p835bd.C17977a;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSMainUIEducationLayout;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll */
public class FTSMainUIEducationLayoutWithAll extends FTSMainUIEducationLayout {
    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bBw() {
        AppMethodBeat.m2504i(91587);
        m70819eF(getContext().getResources().getString(C25738R.string.e0u), C17977a.m28288a(null, getContext().getString(C25738R.string.e0u), getContext()));
        AppMethodBeat.m2505o(91587);
    }

    /* renamed from: eF */
    private void m70819eF(String str, int i) {
        AppMethodBeat.m2504i(91588);
        LinearLayout linearLayout = (LinearLayout) FTSMainUIEducationLayoutWithAll.inflate(getContext(), 2130969631, null);
        linearLayout.findViewById(2131824250).setOnClickListener(this.mJH);
        ((TextView) linearLayout.findViewById(2131824250)).setText(str);
        this.mMf.add(linearLayout);
        this.mMg.put(Integer.valueOf(i), (TextView) linearLayout.findViewById(2131824250));
        addView(linearLayout);
        AppMethodBeat.m2505o(91588);
    }

    /* renamed from: T */
    public final boolean mo36194T(JSONObject jSONObject) {
        AppMethodBeat.m2504i(91589);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(91589);
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            AppMethodBeat.m2505o(91589);
            return false;
        }
        int al;
        if (C4988aa.m7403gw(C4996ah.getContext()).equalsIgnoreCase("en")) {
            al = C1338a.m2856al(getContext(), C25738R.dimen.f9730dw);
        } else {
            al = C1338a.m2856al(getContext(), C25738R.dimen.f9980m5);
        }
        Object obj = null;
        Object obj2 = null;
        String str = null;
        String str2 = null;
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (i % 3 == 0) {
                str2 = optJSONObject.optString("hotword");
                obj2 = optJSONObject;
            } else if (i % 3 == 1) {
                str = optJSONObject.optString("hotword");
                JSONObject obj3 = optJSONObject;
            } else {
                mo36195a(str2, obj2, str, obj3, optJSONObject.optString("hotword"), optJSONObject, al);
                obj3 = null;
                obj2 = null;
                str = null;
                str2 = null;
            }
        }
        if (!(str2 == null || obj2 == null)) {
            mo36195a(str2, obj2, str, obj3, null, null, al);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("all");
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            bBw();
        } else {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(0);
            m70819eF(optJSONObject2.optString("hotword"), optJSONObject2.optInt("businessType"));
        }
        AppMethodBeat.m2505o(91589);
        return true;
    }
}
