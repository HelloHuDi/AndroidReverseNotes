package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements j {
    public b heS;
    private Map<String, d> heT;
    private Map<String, e> heU;
    public f heV;
    public c heW;
    public a heX;
    public boolean heY = true;
    public boolean heZ = true;
    public boolean hfa = false;
    public Set<String> hfb;
    public JSONArray hfc;
    public ArrayList<String> hfd;
    public boolean hfe = false;
    public JSONObject hff;
    public String hfg;

    public static class c {
        public int cRx;
        public int hfj;
        public int hfk;
        public int hfl;
    }

    public static final class e {
        public final String desc;
        public final String name;

        public e(String str, JSONObject jSONObject) {
            AppMethodBeat.i(86876);
            this.name = str;
            this.desc = jSONObject.getString("desc");
            AppMethodBeat.o(86876);
        }

        public final String toString() {
            AppMethodBeat.i(86877);
            String str = "Permission{name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + '}';
            AppMethodBeat.o(86877);
            return str;
        }
    }

    public static class b extends h {
    }

    public static class d extends h {
    }

    public static class a {
        public String hfh = "portrait";
        public boolean hfi = true;
    }

    public static class g {
        public String cIY;
        public String hfr;
        public String text;
        public String url;
    }

    public static abstract class h {
        static final JSONObject hfE = new JSONObject();
        public boolean hfA = false;
        public boolean hfB = false;
        public String hfC;
        public String hfD;
        public String hfo;
        public String hfs;
        public String hft;
        public double hfu = 1.0d;
        public String hfv = "default";
        public String hfw = "#000000";
        public String hfx;
        public boolean hfy = false;
        public boolean hfz = false;

        public static com.tencent.mm.plugin.appbrand.config.a.a.b yV(String str) {
            if ("landscape".equals(str)) {
                return com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LOCKED;
            }
            if ("portrait".equals(str)) {
                return com.tencent.mm.plugin.appbrand.config.a.a.b.PORTRAIT;
            }
            if ("auto".equals(str)) {
                return com.tencent.mm.plugin.appbrand.config.a.a.b.UNSPECIFIED;
            }
            return null;
        }

        public final boolean ayx() {
            return "custom".equalsIgnoreCase(this.hfv);
        }
    }

    public static class f {
        public ArrayList<g> cHb = new ArrayList();
        public String color;
        public String hfm;
        public String hfn;
        public String hfo;
        public String hfp;
        public boolean hfq;

        public f() {
            AppMethodBeat.i(86878);
            AppMethodBeat.o(86878);
        }

        public final boolean yU(String str) {
            AppMethodBeat.i(86879);
            Iterator it = this.cHb.iterator();
            while (it.hasNext()) {
                if (((g) it.next()).url.equals(com.tencent.luggage.g.h.bO(str))) {
                    AppMethodBeat.o(86879);
                    return true;
                }
            }
            AppMethodBeat.o(86879);
            return false;
        }
    }

    public final d yR(String str) {
        AppMethodBeat.i(86880);
        d b;
        if (TextUtils.isEmpty(str) || !this.heT.containsKey(str)) {
            b = b(null, this.heS);
            AppMethodBeat.o(86880);
            return b;
        }
        b = (d) this.heT.get(str);
        AppMethodBeat.o(86880);
        return b;
    }

    public final e yS(String str) {
        AppMethodBeat.i(86881);
        e eVar = (e) this.heU.get(str);
        AppMethodBeat.o(86881);
        return eVar;
    }

    public final String ayw() {
        AppMethodBeat.i(86882);
        String str;
        if (bo.isNullOrNil(this.hfg)) {
            str = "index.html";
            AppMethodBeat.o(86882);
            return str;
        }
        str = this.hfg;
        AppMethodBeat.o(86882);
        return str;
    }

    public static a yT(String str) {
        JSONObject jSONObject;
        AppMethodBeat.i(86883);
        a aVar = new a();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandAppConfig", e.getMessage());
            jSONObject = new JSONObject();
        }
        aVar.hfg = jSONObject.optString("entryPagePath");
        aVar.hff = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("global");
        b bVar = new b();
        a(optJSONObject, bVar, bVar);
        aVar.heS = bVar;
        aVar.heT = a(jSONObject.optJSONObject("page"), aVar.heS);
        aVar.heU = k(jSONObject.optJSONObject("permission"));
        aVar.heV = l(jSONObject.optJSONObject("tabBar"));
        optJSONObject = jSONObject.optJSONObject("networkTimeout");
        c cVar = new c();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        cVar.cRx = optJSONObject.optInt(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        cVar.hfj = optJSONObject.optInt("connectSocket");
        cVar.hfl = optJSONObject.optInt("downloadFile");
        cVar.hfk = optJSONObject.optInt("uploadFile");
        aVar.heW = cVar;
        a aVar2 = new a();
        aVar2.hfh = jSONObject.optString("deviceOrientation", "portrait");
        aVar2.hfi = jSONObject.optBoolean("showStatusBar", false);
        aVar.heX = aVar2;
        aVar.heY = jSONObject.optBoolean("preloadEnabled", true);
        aVar.hfa = jSONObject.has("useCommandBuffer");
        aVar.heZ = jSONObject.optBoolean("useCommandBuffer", false);
        aVar.hfb = i(jSONObject.optJSONArray("requiredBackgroundModes"));
        aVar.hfc = jSONObject.optJSONArray("preloadResources");
        aVar.hfd = j(jSONObject.optJSONArray("preloadSubpackages"));
        aVar.hfe = jSONObject.optBoolean("manualHideSplashScreen", false);
        AppMethodBeat.o(86883);
        return aVar;
    }

    private static <T extends h> T a(JSONObject jSONObject, T t, h hVar) {
        AppMethodBeat.i(86884);
        if (jSONObject == null) {
            jSONObject = h.hfE;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            optJSONObject = h.hfE;
        }
        t.hfs = optJSONObject.optString("navigationBarTitleText", hVar.hfs);
        t.hft = optJSONObject.optString("navigationBarTextStyle", hVar.hft);
        t.hfv = optJSONObject.optString("navigationStyle", hVar.hfv);
        t.hfw = optJSONObject.optString("navigationBarBackgroundColor", hVar.hfw);
        t.hfo = optJSONObject.optString("backgroundColor", hVar.hfo);
        t.hfA = optJSONObject.optBoolean("enablePullDownRefresh", hVar.hfA);
        t.hfC = optJSONObject.optString("backgroundTextStyle", hVar.hfC);
        t.hfz = optJSONObject.optBoolean("enableFullScreen", hVar.hfz);
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("navigationBarRightButton");
        if (optJSONObject2 == null) {
            optJSONObject2 = h.hfE;
        }
        t.hfB = optJSONObject.optBoolean("disableSwipeBack", hVar.hfB);
        t.hfy = optJSONObject2.optBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE, hVar.hfy);
        t.hfx = optJSONObject2.optString("customButtonIconData", hVar.hfx);
        t.hfD = optJSONObject.optString("pageOrientation", hVar.hfD);
        AppMethodBeat.o(86884);
        return t;
    }

    private static Map<String, d> a(JSONObject jSONObject, b bVar) {
        AppMethodBeat.i(86885);
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            AppMethodBeat.o(86885);
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, b(jSONObject.optJSONObject(str), bVar));
        }
        AppMethodBeat.o(86885);
        return hashMap;
    }

    private static Map<String, e> k(JSONObject jSONObject) {
        AppMethodBeat.i(86886);
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            AppMethodBeat.o(86886);
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                try {
                    hashMap.put(str, new e(str, optJSONObject));
                } catch (JSONException e) {
                    ab.e("MicroMsg.AppBrandAppConfig", e.getMessage());
                }
            }
        }
        AppMethodBeat.o(86886);
        return hashMap;
    }

    private static d b(JSONObject jSONObject, b bVar) {
        AppMethodBeat.i(86887);
        d dVar = (d) a(jSONObject, new d(), bVar);
        AppMethodBeat.o(86887);
        return dVar;
    }

    private static f l(JSONObject jSONObject) {
        int i = 0;
        AppMethodBeat.i(86888);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        f fVar = new f();
        fVar.hfm = jSONObject.optString("position");
        fVar.color = jSONObject.optString("color");
        fVar.hfn = jSONObject.optString("selectedColor");
        fVar.hfo = jSONObject.optString("backgroundColor");
        fVar.hfp = jSONObject.optString("borderStyle");
        fVar.hfq = jSONObject.optBoolean("custom", false);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            while (i < jSONArray.length()) {
                ArrayList arrayList = fVar.cHb;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                g gVar = new g();
                gVar.url = jSONObject2.optString("pagePath");
                gVar.text = jSONObject2.optString("text");
                gVar.cIY = jSONObject2.optString("iconData");
                gVar.hfr = jSONObject2.optString("selectedIconData");
                arrayList.add(gVar);
                i++;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandAppConfig", e.getMessage());
        }
        AppMethodBeat.o(86888);
        return fVar;
    }

    private static Set<String> i(JSONArray jSONArray) {
        AppMethodBeat.i(86889);
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            AppMethodBeat.o(86889);
            return hashSet;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!bo.isNullOrNil(optString)) {
                hashSet.add(optString);
            }
        }
        AppMethodBeat.o(86889);
        return hashSet;
    }

    private static ArrayList<String> j(JSONArray jSONArray) {
        AppMethodBeat.i(86890);
        ArrayList<String> arrayList = new ArrayList();
        if (jSONArray == null) {
            AppMethodBeat.o(86890);
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Object optString = optJSONObject.optString("root");
                if (!bo.isNullOrNil(optString)) {
                    if (!optString.startsWith("/")) {
                        optString = "/".concat(String.valueOf(optString));
                    }
                    if (!(optString.endsWith(".js") || optString.endsWith("/"))) {
                        optString = optString + "/";
                    }
                    arrayList.add(optString);
                }
            }
        }
        AppMethodBeat.o(86890);
        return arrayList;
    }
}
