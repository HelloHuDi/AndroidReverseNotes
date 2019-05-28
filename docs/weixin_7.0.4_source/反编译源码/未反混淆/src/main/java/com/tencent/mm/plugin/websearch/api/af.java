package com.tencent.mm.plugin.websearch.api;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class af {
    public static bvf uax;

    public static bvf cVk() {
        AppMethodBeat.i(124166);
        if (uax == null) {
            String cVl = cVl();
            uax = new bvf();
            cVl = ah.getContext().getSharedPreferences("fts_history_search_sp", 0).getString(cVl, "");
            if (!bo.isNullOrNil(cVl)) {
                try {
                    uax.parseFrom(Base64.decode(cVl.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        bvf bvf = uax;
        AppMethodBeat.o(124166);
        return bvf;
    }

    public static String cVl() {
        AppMethodBeat.i(124167);
        String str = "key_pb_history_list" + r.Yz();
        AppMethodBeat.o(124167);
        return str;
    }

    public static String cVm() {
        AppMethodBeat.i(124168);
        bvf cVk = cVk();
        int size = cVk.jBw.size();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (i < cVk.jBw.size() && i < size) {
                bve bve = (bve) cVk.jBw.get(i);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("word", bve.wWv);
                jSONArray2.put(jSONObject3);
                i++;
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put("count", jSONArray2.length());
            jSONObject2.put("type", 4);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
            jSONObject.put("ret", 0);
        } catch (JSONException e) {
        }
        String jSONObject4 = jSONObject.toString();
        AppMethodBeat.o(124168);
        return jSONObject4;
    }
}
