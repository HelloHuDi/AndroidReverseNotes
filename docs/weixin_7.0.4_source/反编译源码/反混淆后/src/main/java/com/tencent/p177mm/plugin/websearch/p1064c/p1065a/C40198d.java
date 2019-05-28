package com.tencent.p177mm.plugin.websearch.p1064c.p1065a;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.c.a.d */
public final class C40198d extends C29745a<C45966l> {
    public boolean ctn;
    private List<C45966l> mEy;
    private List<String> uci;

    public C40198d(String str, List<String> list) {
        super(str);
        this.uci = list;
    }

    /* renamed from: dZ */
    public final void mo47990dZ(List<C45966l> list) {
        AppMethodBeat.m2504i(91374);
        this.mEy = list;
        if (this.mEy != null) {
            ArrayList arrayList = new ArrayList(this.uci.size());
            Iterator it = this.mEy.iterator();
            while (it.hasNext()) {
                C45966l c45966l = (C45966l) it.next();
                int indexOf = this.uci.indexOf(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c45966l.mDx).field_username);
                if (indexOf >= 0) {
                    if (indexOf < arrayList.size()) {
                        arrayList.add(indexOf, c45966l);
                    } else {
                        arrayList.add(c45966l);
                    }
                    it.remove();
                }
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mEy.add(0, arrayList.get(size));
            }
        }
        this.ctn = true;
        AppMethodBeat.m2505o(91374);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: gq */
    public final JSONObject mo63538gq(int i, int i2) {
        AppMethodBeat.m2504i(91375);
        JSONObject jSONObject = new JSONObject();
        if (!this.ctn) {
            AppMethodBeat.m2505o(91375);
            return jSONObject;
        } else if (i < 0 || i2 <= 0) {
            AppMethodBeat.m2505o(91375);
            return jSONObject;
        } else {
            int size;
            int i3 = (i + i2) - 1;
            if (i3 > this.mEy.size() - 1) {
                size = this.mEy.size() - 1;
            } else {
                size = i3;
            }
            if (size < i) {
                AppMethodBeat.m2505o(91375);
                return jSONObject;
            }
            jSONObject.put("continueFlag", size == this.mEy.size() + -1 ? 0 : 1);
            jSONObject.put("offset", size + 1);
            jSONObject.put(SearchIntents.EXTRA_QUERY, this.query);
            jSONObject.put("ret", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("count", (size - i) + 1);
            jSONObject2.put("totalCount", C1855t.m3878Zo());
            JSONArray jSONArray = new JSONArray();
            while (i <= size) {
                C45966l c45966l = (C45966l) this.mEy.get(i);
                JSONObject jSONObject3 = new JSONObject();
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c45966l.mDx);
                jSONObject3.put("userName", aoO.field_username);
                jSONObject3.put("nickName", aoO.field_nickname);
                String str = c45966l.content;
                Context context = C4996ah.getContext();
                String str2 = "";
                Object replaceFirst = str.replaceFirst(this.query, "<em class=\\\"highlight\\\">" + this.query + "</em>");
                switch (c45966l.mDw) {
                    case 1:
                    case 4:
                    case 5:
                        break;
                    case 15:
                        replaceFirst = context.getString(C25738R.string.e09) + replaceFirst;
                        break;
                    default:
                        replaceFirst = str2;
                        break;
                }
                try {
                    jSONObject3.put("displayText", replaceFirst);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("JsapiFtsMatchContact", e, "", new Object[0]);
                }
                try {
                    replaceFirst = "";
                    C17880h qo = C17884o.act().mo33392qo(aoO.field_username);
                    if (qo != null) {
                        replaceFirst = qo.acl();
                        if (C5046bo.isNullOrNil(replaceFirst)) {
                            replaceFirst = qo.ack();
                        }
                    }
                    jSONObject3.put("thumbUrl", replaceFirst);
                    jSONArray.put(jSONObject3);
                    i++;
                } catch (JSONException e2) {
                    C4990ab.printErrStackTrace("JsapiFtsMatchContact", e2, "", new Object[0]);
                }
            }
            jSONObject2.put("items", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            jSONObject.put("data", jSONArray2);
            AppMethodBeat.m2505o(91375);
            return jSONObject;
        }
    }
}
