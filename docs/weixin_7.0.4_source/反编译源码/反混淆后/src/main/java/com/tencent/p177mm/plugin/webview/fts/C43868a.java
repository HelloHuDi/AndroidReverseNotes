package com.tencent.p177mm.plugin.webview.fts;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p230g.p231a.C26142gb;
import com.tencent.p177mm.p230g.p231a.C42049rj;
import com.tencent.p177mm.plugin.sns.p1024b.C29034m;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29944h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.fts.a */
public final class C43868a implements C4931a {
    public C4884c qGl = new C72002();
    private volatile HashMap<String, HashSet<String>> ueY = new HashMap();
    volatile HashMap<String, HashSet<String>> ueZ = new HashMap();
    volatile HashMap<String, HashSet<String>> ufa = new HashMap();
    private volatile HashMap<String, Integer> ufb = new HashMap();
    volatile HashMap<String, Integer> ufc = new HashMap();
    volatile HashMap<String, Integer> ufd = new HashMap();
    public C4884c<C26142gb> ufe = new C71991();

    /* renamed from: com.tencent.mm.plugin.webview.fts.a$1 */
    class C71991 extends C4884c<C26142gb> {
        C71991() {
            AppMethodBeat.m2504i(5661);
            this.xxI = C26142gb.class.getName().hashCode();
            AppMethodBeat.m2505o(5661);
        }

        /* renamed from: a */
        private boolean m12005a(C26142gb c26142gb) {
            AppMethodBeat.m2504i(5662);
            if (c26142gb.cAm.cuy == 2) {
                C4990ab.m7417i("MicroMsg.FTS.FTSWebViewImageLogic", "Emoji Download callback %s", c26142gb.cAm.cvZ);
                if (C43868a.this.ufa.containsKey(c26142gb.cAm.cvZ)) {
                    synchronized (C43868a.this.ufa) {
                        try {
                            int intValue = ((Integer) C43868a.this.ufd.get(c26142gb.cAm.cvZ)).intValue();
                            HashSet hashSet = (HashSet) C43868a.this.ufa.get(c26142gb.cAm.cvZ);
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                String str = (String) it.next();
                                String str2 = "weixin://fts/emoji?path=" + c26142gb.cAn.path;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", str);
                                    jSONObject.put("src", str2);
                                } catch (JSONException e) {
                                }
                                jSONArray.put(jSONObject);
                            }
                            C29944h.m47401JR(intValue).mo38633bH(0, jSONArray.toString());
                            C43868a.this.ufa.remove(c26142gb.cAm.cvZ);
                            C43868a.this.ufd.remove(c26142gb.cAm.cvZ);
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(5662);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(5662);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.a$2 */
    class C72002 extends C4884c<C42049rj> {
        C72002() {
            AppMethodBeat.m2504i(5664);
            this.xxI = C42049rj.class.getName().hashCode();
            AppMethodBeat.m2505o(5664);
        }

        /* renamed from: a */
        private boolean m12007a(C42049rj c42049rj) {
            AppMethodBeat.m2504i(5665);
            if ((c42049rj instanceof C42049rj) && c42049rj.cNq.cuy == 2) {
                C4990ab.m7417i("MicroMsg.FTS.FTSWebViewImageLogic", "Download callback %s", c42049rj.cNq.cHr);
                if (C43868a.this.ueZ.containsKey(c42049rj.cNq.cHr)) {
                    synchronized (C43868a.this.ueZ) {
                        try {
                            int intValue = ((Integer) C43868a.this.ufc.get(c42049rj.cNq.cHr)).intValue();
                            HashSet hashSet = (HashSet) C43868a.this.ueZ.get(c42049rj.cNq.cHr);
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                String str = (String) it.next();
                                String str2 = "weixin://fts/sns?path=" + c42049rj.cNq.path;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", str);
                                    jSONObject.put("src", str2);
                                } catch (JSONException e) {
                                }
                                jSONArray.put(jSONObject);
                            }
                            C29944h.m47401JR(intValue).mo38633bH(0, jSONArray.toString());
                            C43868a.this.ueZ.remove(c42049rj.cNq.cHr);
                            C43868a.this.ufc.remove(c42049rj.cNq.cHr);
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(5665);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(5665);
            return false;
        }
    }

    public C43868a() {
        AppMethodBeat.m2504i(5667);
        this.qGl.dnU();
        this.ufe.dnU();
        C17884o.act().mo10116c(this);
        AppMethodBeat.m2505o(5667);
    }

    /* renamed from: as */
    public final boolean mo69553as(Map<String, Object> map) {
        AppMethodBeat.m2504i(5668);
        C4990ab.m7416i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchAvatarList");
        String t = C46400aa.m87342t(map, "data");
        int g = C5046bo.m7550g(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(t);
            JSONArray jSONArray2 = new JSONArray();
            Object obj = null;
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("id");
                String optString2 = jSONObject.optString("userName");
                int optInt = jSONObject.optInt("type");
                Object optString3 = jSONObject.optString("imageUrl");
                String optString4 = jSONObject.optString("bigImageUrl");
                switch (optInt) {
                    case 1:
                    case 4:
                    case 64:
                        break;
                    case 32:
                        C17880h c17880h = new C17880h();
                        c17880h.username = optString2;
                        c17880h.frW = optString4;
                        c17880h.frV = optString3;
                        c17880h.bJt = -1;
                        c17880h.dtR = 3;
                        c17880h.mo33385cB(true);
                        C17884o.act().mo33391b(c17880h);
                        break;
                }
                C17884o.acd();
                t = C41732d.m73515D(optString2, false);
                if (C5730e.m8628ct(t)) {
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file exist %s", t);
                    optString3 = "weixin://fts/avatar?path=".concat(String.valueOf(t));
                } else {
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file not exist %s", t);
                    this.ufb.put(optString2, Integer.valueOf(g));
                    HashSet hashSet = (HashSet) this.ueY.get(optString2);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(optString);
                    this.ueY.put(optString2, hashSet);
                    C40460b.diS().mo8232cQ(optString2);
                    optString3 = obj;
                }
                if (optString3 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", optString);
                    jSONObject2.put("src", optString3);
                    jSONArray2.put(jSONObject2);
                    optString3 = null;
                }
                i++;
                obj = optString3;
            }
            if (jSONArray2.length() > 0) {
                C29944h.m47401JR(g).mo38633bH(0, jSONArray2.toString());
            }
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewImageLogic", e, "", new Object[0]);
            C29944h.m47401JR(g).mo38633bH(-1, "");
        }
        AppMethodBeat.m2505o(5668);
        return false;
    }

    /* renamed from: at */
    public final boolean mo69554at(Map<String, Object> map) {
        AppMethodBeat.m2504i(5669);
        C4990ab.m7416i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchSnsImageList");
        String t = C46400aa.m87342t(map, "data");
        int g = C5046bo.m7550g(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(t);
            JSONArray jSONArray2 = new JSONArray();
            Object obj = null;
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("objectXmlDesc");
                int i2 = jSONObject.getInt(C8741b.INDEX);
                TimeLineObject tC = ((C29034m) C1720g.m3528K(C29034m.class)).mo47122tC(string2);
                if (tC.xfI.wbK.size() > i2) {
                    bau bau = (bau) tC.xfI.wbK.get(i2);
                    C42049rj c42049rj = new C42049rj();
                    c42049rj.cNq.cuy = 3;
                    c42049rj.cNq.cHr = bau.f17915Id;
                    C4879a.xxA.mo10055m(c42049rj);
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewImageLogic", "generatePath: %s", c42049rj.cNq.path);
                    if (C5730e.m8628ct(c42049rj.cNq.path)) {
                        obj2 = "weixin://fts/sns?path=" + c42049rj.cNq.path;
                    } else {
                        synchronized (this.ueZ) {
                            HashSet hashSet;
                            if (this.ueZ.containsKey(bau.f17915Id)) {
                                hashSet = (HashSet) this.ueZ.get(bau.f17915Id);
                            } else {
                                hashSet = new HashSet();
                            }
                            hashSet.add(string);
                            this.ueZ.put(bau.f17915Id, hashSet);
                            this.ufc.put(bau.f17915Id, Integer.valueOf(g));
                        }
                        c42049rj = new C42049rj();
                        c42049rj.cNq.cuy = 1;
                        c42049rj.cNq.cNr = bau;
                        C4879a.xxA.mo10055m(c42049rj);
                        obj2 = obj;
                    }
                    if (obj2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("id", string);
                        jSONObject2.put("src", obj2);
                        jSONArray2.put(jSONObject2);
                        obj2 = null;
                    }
                } else {
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
            if (jSONArray2.length() > 0) {
                C29944h.m47401JR(g).mo38633bH(0, jSONArray2.toString());
            }
        } catch (JSONException e) {
        } catch (Throwable th) {
            AppMethodBeat.m2505o(5669);
        }
        AppMethodBeat.m2505o(5669);
        return false;
    }

    /* renamed from: au */
    public final boolean mo69555au(Map<String, Object> map) {
        AppMethodBeat.m2504i(5670);
        C4990ab.m7416i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchImageList");
        int d = C46400aa.m87332d((Map) map, "requestType", 0);
        String t = C46400aa.m87342t(map, "data");
        int g = C5046bo.m7550g(map.get("webview_instance_id"), -1);
        boolean isWifi = C5023at.isWifi(C4996ah.getContext());
        switch (d) {
            case 1:
                try {
                    JSONArray jSONArray = new JSONArray(t);
                    JSONArray jSONArray2 = new JSONArray();
                    Object obj = null;
                    int i = 0;
                    while (i < jSONArray.length()) {
                        Object obj2;
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        int optInt = jSONObject.optInt("emojiType");
                        String optString = jSONObject.optString("id");
                        JSONObject jSONObject2;
                        if (optInt == 2) {
                            C26142gb c26142gb = new C26142gb();
                            c26142gb.cAm.cuy = 3;
                            c26142gb.cAm.cvZ = jSONObject.optString("md5");
                            c26142gb.cAm.cAo = jSONObject.optString("designerId");
                            c26142gb.cAm.aeskey = jSONObject.optString("aesKey");
                            c26142gb.cAm.cAp = jSONObject.optString("encryptUrl");
                            c26142gb.cAm.cwg = jSONObject.optString("productID");
                            c26142gb.cAm.name = jSONObject.optString("express");
                            c26142gb.cAm.thumbUrl = jSONObject.optString("imageUrl");
                            C4879a.xxA.mo10055m(c26142gb);
                            if (C5730e.m8628ct(c26142gb.cAn.path)) {
                                obj2 = "weixin://fts/emoji?path=" + c26142gb.cAn.path;
                                C4990ab.m7417i("MicroMsg.FTS.FTSWebViewImageLogic", "path=%s", c26142gb.cAn.path);
                            } else if (isWifi) {
                                synchronized (this.ufa) {
                                    HashSet hashSet;
                                    if (this.ufa.containsKey(c26142gb.cAm.cvZ)) {
                                        hashSet = (HashSet) this.ufa.get(c26142gb.cAm.cvZ);
                                    } else {
                                        hashSet = new HashSet();
                                    }
                                    hashSet.add(optString);
                                    this.ufa.put(c26142gb.cAm.cvZ, hashSet);
                                    this.ufd.put(c26142gb.cAm.cvZ, Integer.valueOf(g));
                                }
                                c26142gb.cAm.cuy = 1;
                                C4879a.xxA.mo10055m(c26142gb);
                                obj2 = obj;
                            } else {
                                obj2 = jSONObject.optString("imageUrl");
                            }
                            if (obj2 != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("id", optString);
                                jSONObject3.put("src", obj2);
                                jSONArray2.put(jSONObject3);
                                obj2 = null;
                            }
                        } else if (optInt == 4) {
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("id", optString);
                            if (isWifi) {
                                jSONObject2.put("src", jSONObject.optString("raw"));
                            } else {
                                jSONObject2.put("src", jSONObject.optString("imageUrl"));
                            }
                            jSONArray2.put(jSONObject2);
                            obj2 = obj;
                        } else {
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("id", optString);
                            jSONObject2.put("src", jSONObject.optString("imageUrl"));
                            jSONArray2.put(jSONObject2);
                            obj2 = obj;
                        }
                        i++;
                        obj = obj2;
                    }
                    if (jSONArray2.length() > 0) {
                        C29944h.m47401JR(g).mo38633bH(0, jSONArray2.toString());
                        break;
                    }
                } catch (Exception e) {
                    break;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(5670);
                }
                break;
            default:
                try {
                    JSONArray jSONArray3 = new JSONArray(t);
                    JSONArray jSONArray4 = new JSONArray();
                    for (d = 0; d < jSONArray3.length(); d++) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(d);
                        JSONObject jSONObject5 = new JSONObject();
                        String string = jSONObject4.getString("id");
                        String string2 = jSONObject4.getString("imageUrl");
                        jSONObject5.put("id", string);
                        jSONObject5.put("src", string2);
                        jSONArray4.put(jSONObject5);
                    }
                    C29944h.m47401JR(g).mo38633bH(0, jSONArray4.toString());
                    break;
                } catch (JSONException e2) {
                    break;
                }
        }
        AppMethodBeat.m2505o(5670);
        return false;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(5671);
        if (c4935m == null || c4935m.obj == null) {
            AppMethodBeat.m2505o(5671);
            return;
        }
        synchronized (this.ueY) {
            try {
                C4990ab.m7417i("MicroMsg.FTS.FTSWebViewImageLogic", "event %s，eventData %s", str, c4935m.toString());
                String obj = c4935m.obj.toString();
                if (this.ueY.containsKey(obj) && this.ufb.containsKey(obj)) {
                    C4990ab.m7417i("MicroMsg.FTS.FTSWebViewImageLogic", "notify avatar changed %s", obj);
                    int intValue = ((Integer) this.ufb.get(obj)).intValue();
                    HashSet hashSet = new HashSet((HashSet) this.ueY.get(obj));
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        C17884o.acd();
                        String concat = "weixin://fts/avatar?path=".concat(String.valueOf(C41732d.m73515D(obj, false)));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str2);
                            jSONObject.put("src", concat);
                        } catch (JSONException e) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    C29944h.m47401JR(intValue).mo38633bH(0, jSONArray.toString());
                    this.ueY.remove(obj);
                    this.ufb.remove(obj);
                }
            } finally {
                AppMethodBeat.m2505o(5671);
            }
        }
    }
}
