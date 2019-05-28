package com.tencent.mm.plugin.websearch.c.a;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a<l> {
    public boolean ctn;
    private List<l> mEy;
    private List<String> uci;

    public d(String str, List<String> list) {
        super(str);
        this.uci = list;
    }

    public final void dZ(List<l> list) {
        AppMethodBeat.i(91374);
        this.mEy = list;
        if (this.mEy != null) {
            ArrayList arrayList = new ArrayList(this.uci.size());
            Iterator it = this.mEy.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                int indexOf = this.uci.indexOf(((j) g.K(j.class)).XM().aoO(lVar.mDx).field_username);
                if (indexOf >= 0) {
                    if (indexOf < arrayList.size()) {
                        arrayList.add(indexOf, lVar);
                    } else {
                        arrayList.add(lVar);
                    }
                    it.remove();
                }
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mEy.add(0, arrayList.get(size));
            }
        }
        this.ctn = true;
        AppMethodBeat.o(91374);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final JSONObject gq(int i, int i2) {
        AppMethodBeat.i(91375);
        JSONObject jSONObject = new JSONObject();
        if (!this.ctn) {
            AppMethodBeat.o(91375);
            return jSONObject;
        } else if (i < 0 || i2 <= 0) {
            AppMethodBeat.o(91375);
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
                AppMethodBeat.o(91375);
                return jSONObject;
            }
            jSONObject.put("continueFlag", size == this.mEy.size() + -1 ? 0 : 1);
            jSONObject.put("offset", size + 1);
            jSONObject.put(SearchIntents.EXTRA_QUERY, this.query);
            jSONObject.put("ret", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("count", (size - i) + 1);
            jSONObject2.put("totalCount", t.Zo());
            JSONArray jSONArray = new JSONArray();
            while (i <= size) {
                l lVar = (l) this.mEy.get(i);
                JSONObject jSONObject3 = new JSONObject();
                ad aoO = ((j) g.K(j.class)).XM().aoO(lVar.mDx);
                jSONObject3.put("userName", aoO.field_username);
                jSONObject3.put("nickName", aoO.field_nickname);
                String str = lVar.content;
                Context context = ah.getContext();
                String str2 = "";
                Object replaceFirst = str.replaceFirst(this.query, "<em class=\\\"highlight\\\">" + this.query + "</em>");
                switch (lVar.mDw) {
                    case 1:
                    case 4:
                    case 5:
                        break;
                    case 15:
                        replaceFirst = context.getString(R.string.e09) + replaceFirst;
                        break;
                    default:
                        replaceFirst = str2;
                        break;
                }
                try {
                    jSONObject3.put("displayText", replaceFirst);
                } catch (JSONException e) {
                    ab.printErrStackTrace("JsapiFtsMatchContact", e, "", new Object[0]);
                }
                try {
                    replaceFirst = "";
                    h qo = o.act().qo(aoO.field_username);
                    if (qo != null) {
                        replaceFirst = qo.acl();
                        if (bo.isNullOrNil(replaceFirst)) {
                            replaceFirst = qo.ack();
                        }
                    }
                    jSONObject3.put("thumbUrl", replaceFirst);
                    jSONArray.put(jSONObject3);
                    i++;
                } catch (JSONException e2) {
                    ab.printErrStackTrace("JsapiFtsMatchContact", e2, "", new Object[0]);
                }
            }
            jSONObject2.put("items", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            jSONObject.put("data", jSONArray2);
            AppMethodBeat.o(91375);
            return jSONObject;
        }
    }
}
