package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.p */
public final class C39991p {
    public static final C39991p sFq = new C39991p();
    chw sFr;

    static {
        AppMethodBeat.m2504i(1801);
        AppMethodBeat.m2505o(1801);
    }

    /* renamed from: g */
    static boolean m68488g(chw chw) {
        if (chw.xhe == 100201 || chw.xhe == 100203) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final void mo63212a(C4232b c4232b, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(1799);
        if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            if (i2 == -1) {
                Toast.makeText(C4996ah.getContext(), C25738R.string.f9229to, 1).show();
                C46297h.m86863a(c4232b.cFT(), this.sFr, "1", C1853r.m3846Yz(), "");
                AppMethodBeat.m2505o(1799);
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
                    if (C1855t.m3896kH(str)) {
                        stringBuilder.append(3);
                        stringBuilder.append(";");
                    } else {
                        stringBuilder.append(2);
                        stringBuilder.append(";");
                    }
                    stringBuilder2.append(str);
                    stringBuilder2.append(";");
                }
                C46297h.m86863a(c4232b.cFT(), this.sFr, stringBuilder.toString(), C1853r.m3846Yz(), stringBuilder2.toString());
            }
        }
        AppMethodBeat.m2505o(1799);
    }

    /* renamed from: dO */
    static JSONArray m68487dO(List<C23447tn> list) {
        AppMethodBeat.m2504i(1800);
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    C23447tn c23447tn = (C23447tn) list.get(i2);
                    jSONObject.put("key", c23447tn.key);
                    jSONObject.put("uintValue", c23447tn.waD);
                    jSONObject.put("textValue", c23447tn.waE);
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(1800);
                return jSONArray;
            }
        }
    }
}
