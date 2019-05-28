package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p {
    public static final p sFq = new p();
    chw sFr;

    static {
        AppMethodBeat.i(1801);
        AppMethodBeat.o(1801);
    }

    static boolean g(chw chw) {
        if (chw.xhe == 100201 || chw.xhe == 100203) {
            return false;
        }
        return true;
    }

    public final void a(b bVar, int i, int i2, Intent intent) {
        AppMethodBeat.i(1799);
        if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            if (i2 == -1) {
                Toast.makeText(ah.getContext(), R.string.to, 1).show();
                h.a(bVar.cFT(), this.sFr, "1", r.Yz(), "");
                AppMethodBeat.o(1799);
                return;
            }
        } else if (i == 2048 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder("");
                StringBuilder stringBuilder2 = new StringBuilder("");
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (t.kH(str)) {
                        stringBuilder.append(3);
                        stringBuilder.append(";");
                    } else {
                        stringBuilder.append(2);
                        stringBuilder.append(";");
                    }
                    stringBuilder2.append(str);
                    stringBuilder2.append(";");
                }
                h.a(bVar.cFT(), this.sFr, stringBuilder.toString(), r.Yz(), stringBuilder2.toString());
            }
        }
        AppMethodBeat.o(1799);
    }

    static JSONArray dO(List<tn> list) {
        AppMethodBeat.i(1800);
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    tn tnVar = (tn) list.get(i2);
                    jSONObject.put("key", tnVar.key);
                    jSONObject.put("uintValue", tnVar.waD);
                    jSONObject.put("textValue", tnVar.waE);
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(1800);
                return jSONArray;
            }
        }
    }
}
