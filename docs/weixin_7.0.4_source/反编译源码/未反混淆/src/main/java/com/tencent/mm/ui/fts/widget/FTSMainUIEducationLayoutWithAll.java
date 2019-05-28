package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayoutWithAll extends FTSMainUIEducationLayout {
    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bBw() {
        AppMethodBeat.i(91587);
        eF(getContext().getResources().getString(R.string.e0u), a.a(null, getContext().getString(R.string.e0u), getContext()));
        AppMethodBeat.o(91587);
    }

    private void eF(String str, int i) {
        AppMethodBeat.i(91588);
        LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.layout.a1p, null);
        linearLayout.findViewById(R.id.bz6).setOnClickListener(this.mJH);
        ((TextView) linearLayout.findViewById(R.id.bz6)).setText(str);
        this.mMf.add(linearLayout);
        this.mMg.put(Integer.valueOf(i), (TextView) linearLayout.findViewById(R.id.bz6));
        addView(linearLayout);
        AppMethodBeat.o(91588);
    }

    public final boolean T(JSONObject jSONObject) {
        AppMethodBeat.i(91589);
        if (jSONObject == null) {
            AppMethodBeat.o(91589);
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            AppMethodBeat.o(91589);
            return false;
        }
        int al;
        if (aa.gw(ah.getContext()).equalsIgnoreCase("en")) {
            al = com.tencent.mm.bz.a.al(getContext(), R.dimen.dw);
        } else {
            al = com.tencent.mm.bz.a.al(getContext(), R.dimen.m5);
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
                a(str2, obj2, str, obj3, optJSONObject.optString("hotword"), optJSONObject, al);
                obj3 = null;
                obj2 = null;
                str = null;
                str2 = null;
            }
        }
        if (!(str2 == null || obj2 == null)) {
            a(str2, obj2, str, obj3, null, null, al);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("all");
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            bBw();
        } else {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(0);
            eF(optJSONObject2.optString("hotword"), optJSONObject2.optInt("businessType"));
        }
        AppMethodBeat.o(91589);
        return true;
    }
}
