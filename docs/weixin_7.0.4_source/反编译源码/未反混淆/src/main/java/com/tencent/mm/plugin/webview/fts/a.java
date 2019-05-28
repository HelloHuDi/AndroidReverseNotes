package com.tencent.mm.plugin.webview.fts;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements com.tencent.mm.sdk.e.k.a {
    public c qGl = new c<rj>() {
        {
            AppMethodBeat.i(5664);
            this.xxI = rj.class.getName().hashCode();
            AppMethodBeat.o(5664);
        }

        private boolean a(rj rjVar) {
            AppMethodBeat.i(5665);
            if ((rjVar instanceof rj) && rjVar.cNq.cuy == 2) {
                ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "Download callback %s", rjVar.cNq.cHr);
                if (a.this.ueZ.containsKey(rjVar.cNq.cHr)) {
                    synchronized (a.this.ueZ) {
                        try {
                            int intValue = ((Integer) a.this.ufc.get(rjVar.cNq.cHr)).intValue();
                            HashSet hashSet = (HashSet) a.this.ueZ.get(rjVar.cNq.cHr);
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                String str = (String) it.next();
                                String str2 = "weixin://fts/sns?path=" + rjVar.cNq.path;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", str);
                                    jSONObject.put("src", str2);
                                } catch (JSONException e) {
                                }
                                jSONArray.put(jSONObject);
                            }
                            h.JR(intValue).bH(0, jSONArray.toString());
                            a.this.ueZ.remove(rjVar.cNq.cHr);
                            a.this.ufc.remove(rjVar.cNq.cHr);
                        } catch (Throwable th) {
                            AppMethodBeat.o(5665);
                        }
                    }
                }
            }
            AppMethodBeat.o(5665);
            return false;
        }
    };
    private volatile HashMap<String, HashSet<String>> ueY = new HashMap();
    volatile HashMap<String, HashSet<String>> ueZ = new HashMap();
    volatile HashMap<String, HashSet<String>> ufa = new HashMap();
    private volatile HashMap<String, Integer> ufb = new HashMap();
    volatile HashMap<String, Integer> ufc = new HashMap();
    volatile HashMap<String, Integer> ufd = new HashMap();
    public c<gb> ufe = new c<gb>() {
        {
            AppMethodBeat.i(5661);
            this.xxI = gb.class.getName().hashCode();
            AppMethodBeat.o(5661);
        }

        private boolean a(gb gbVar) {
            AppMethodBeat.i(5662);
            if (gbVar.cAm.cuy == 2) {
                ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "Emoji Download callback %s", gbVar.cAm.cvZ);
                if (a.this.ufa.containsKey(gbVar.cAm.cvZ)) {
                    synchronized (a.this.ufa) {
                        try {
                            int intValue = ((Integer) a.this.ufd.get(gbVar.cAm.cvZ)).intValue();
                            HashSet hashSet = (HashSet) a.this.ufa.get(gbVar.cAm.cvZ);
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                String str = (String) it.next();
                                String str2 = "weixin://fts/emoji?path=" + gbVar.cAn.path;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("id", str);
                                    jSONObject.put("src", str2);
                                } catch (JSONException e) {
                                }
                                jSONArray.put(jSONObject);
                            }
                            h.JR(intValue).bH(0, jSONArray.toString());
                            a.this.ufa.remove(gbVar.cAm.cvZ);
                            a.this.ufd.remove(gbVar.cAm.cvZ);
                        } catch (Throwable th) {
                            AppMethodBeat.o(5662);
                        }
                    }
                }
            }
            AppMethodBeat.o(5662);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(5667);
        this.qGl.dnU();
        this.ufe.dnU();
        o.act().c(this);
        AppMethodBeat.o(5667);
    }

    public final boolean as(Map<String, Object> map) {
        AppMethodBeat.i(5668);
        ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchAvatarList");
        String t = aa.t(map, "data");
        int g = bo.g(map.get("webview_instance_id"), -1);
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
                        com.tencent.mm.ah.h hVar = new com.tencent.mm.ah.h();
                        hVar.username = optString2;
                        hVar.frW = optString4;
                        hVar.frV = optString3;
                        hVar.bJt = -1;
                        hVar.dtR = 3;
                        hVar.cB(true);
                        o.act().b(hVar);
                        break;
                }
                o.acd();
                t = d.D(optString2, false);
                if (e.ct(t)) {
                    ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file exist %s", t);
                    optString3 = "weixin://fts/avatar?path=".concat(String.valueOf(t));
                } else {
                    ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file not exist %s", t);
                    this.ufb.put(optString2, Integer.valueOf(g));
                    HashSet hashSet = (HashSet) this.ueY.get(optString2);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(optString);
                    this.ueY.put(optString2, hashSet);
                    b.diS().cQ(optString2);
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
                h.JR(g).bH(0, jSONArray2.toString());
            }
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.FTS.FTSWebViewImageLogic", e, "", new Object[0]);
            h.JR(g).bH(-1, "");
        }
        AppMethodBeat.o(5668);
        return false;
    }

    public final boolean at(Map<String, Object> map) {
        AppMethodBeat.i(5669);
        ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchSnsImageList");
        String t = aa.t(map, "data");
        int g = bo.g(map.get("webview_instance_id"), -1);
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
                int i2 = jSONObject.getInt(FirebaseAnalytics.b.INDEX);
                TimeLineObject tC = ((m) g.K(m.class)).tC(string2);
                if (tC.xfI.wbK.size() > i2) {
                    bau bau = (bau) tC.xfI.wbK.get(i2);
                    rj rjVar = new rj();
                    rjVar.cNq.cuy = 3;
                    rjVar.cNq.cHr = bau.Id;
                    com.tencent.mm.sdk.b.a.xxA.m(rjVar);
                    ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "generatePath: %s", rjVar.cNq.path);
                    if (e.ct(rjVar.cNq.path)) {
                        obj2 = "weixin://fts/sns?path=" + rjVar.cNq.path;
                    } else {
                        synchronized (this.ueZ) {
                            HashSet hashSet;
                            if (this.ueZ.containsKey(bau.Id)) {
                                hashSet = (HashSet) this.ueZ.get(bau.Id);
                            } else {
                                hashSet = new HashSet();
                            }
                            hashSet.add(string);
                            this.ueZ.put(bau.Id, hashSet);
                            this.ufc.put(bau.Id, Integer.valueOf(g));
                        }
                        rjVar = new rj();
                        rjVar.cNq.cuy = 1;
                        rjVar.cNq.cNr = bau;
                        com.tencent.mm.sdk.b.a.xxA.m(rjVar);
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
                h.JR(g).bH(0, jSONArray2.toString());
            }
        } catch (JSONException e) {
        } catch (Throwable th) {
            AppMethodBeat.o(5669);
        }
        AppMethodBeat.o(5669);
        return false;
    }

    public final boolean au(Map<String, Object> map) {
        AppMethodBeat.i(5670);
        ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchImageList");
        int d = aa.d((Map) map, "requestType", 0);
        String t = aa.t(map, "data");
        int g = bo.g(map.get("webview_instance_id"), -1);
        boolean isWifi = at.isWifi(ah.getContext());
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
                            gb gbVar = new gb();
                            gbVar.cAm.cuy = 3;
                            gbVar.cAm.cvZ = jSONObject.optString("md5");
                            gbVar.cAm.cAo = jSONObject.optString("designerId");
                            gbVar.cAm.aeskey = jSONObject.optString("aesKey");
                            gbVar.cAm.cAp = jSONObject.optString("encryptUrl");
                            gbVar.cAm.cwg = jSONObject.optString("productID");
                            gbVar.cAm.name = jSONObject.optString("express");
                            gbVar.cAm.thumbUrl = jSONObject.optString("imageUrl");
                            com.tencent.mm.sdk.b.a.xxA.m(gbVar);
                            if (e.ct(gbVar.cAn.path)) {
                                obj2 = "weixin://fts/emoji?path=" + gbVar.cAn.path;
                                ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "path=%s", gbVar.cAn.path);
                            } else if (isWifi) {
                                synchronized (this.ufa) {
                                    HashSet hashSet;
                                    if (this.ufa.containsKey(gbVar.cAm.cvZ)) {
                                        hashSet = (HashSet) this.ufa.get(gbVar.cAm.cvZ);
                                    } else {
                                        hashSet = new HashSet();
                                    }
                                    hashSet.add(optString);
                                    this.ufa.put(gbVar.cAm.cvZ, hashSet);
                                    this.ufd.put(gbVar.cAm.cvZ, Integer.valueOf(g));
                                }
                                gbVar.cAm.cuy = 1;
                                com.tencent.mm.sdk.b.a.xxA.m(gbVar);
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
                        h.JR(g).bH(0, jSONArray2.toString());
                        break;
                    }
                } catch (Exception e) {
                    break;
                } catch (Throwable th) {
                    AppMethodBeat.o(5670);
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
                    h.JR(g).bH(0, jSONArray4.toString());
                    break;
                } catch (JSONException e2) {
                    break;
                }
        }
        AppMethodBeat.o(5670);
        return false;
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(5671);
        if (mVar == null || mVar.obj == null) {
            AppMethodBeat.o(5671);
            return;
        }
        synchronized (this.ueY) {
            try {
                ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "event %s，eventData %s", str, mVar.toString());
                String obj = mVar.obj.toString();
                if (this.ueY.containsKey(obj) && this.ufb.containsKey(obj)) {
                    ab.i("MicroMsg.FTS.FTSWebViewImageLogic", "notify avatar changed %s", obj);
                    int intValue = ((Integer) this.ufb.get(obj)).intValue();
                    HashSet hashSet = new HashSet((HashSet) this.ueY.get(obj));
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        o.acd();
                        String concat = "weixin://fts/avatar?path=".concat(String.valueOf(d.D(obj, false)));
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str2);
                            jSONObject.put("src", concat);
                        } catch (JSONException e) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    h.JR(intValue).bH(0, jSONArray.toString());
                    this.ueY.remove(obj);
                    this.ufb.remove(obj);
                }
            } finally {
                AppMethodBeat.o(5671);
            }
        }
    }
}
