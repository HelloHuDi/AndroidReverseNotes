package com.tencent.p177mm.plugin.appbrand.config;

import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26839b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10441j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.config.a */
public class C38163a implements C10441j {
    public C26834b heS;
    private Map<String, C33131d> heT;
    private Map<String, C19155e> heU;
    public C38166f heV;
    public C10174c heW;
    public C38161a heX;
    public boolean heY = true;
    public boolean heZ = true;
    public boolean hfa = false;
    public Set<String> hfb;
    public JSONArray hfc;
    public ArrayList<String> hfd;
    public boolean hfe = false;
    public JSONObject hff;
    public String hfg;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a$c */
    public static class C10174c {
        public int cRx;
        public int hfj;
        public int hfk;
        public int hfl;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a$e */
    public static final class C19155e {
        public final String desc;
        public final String name;

        public C19155e(String str, JSONObject jSONObject) {
            AppMethodBeat.m2504i(86876);
            this.name = str;
            this.desc = jSONObject.getString("desc");
            AppMethodBeat.m2505o(86876);
        }

        public final String toString() {
            AppMethodBeat.m2504i(86877);
            String str = "Permission{name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + '}';
            AppMethodBeat.m2505o(86877);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a$b */
    public static class C26834b extends C38165h {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a$d */
    public static class C33131d extends C38165h {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a$a */
    public static class C38161a {
        public String hfh = "portrait";
        public boolean hfi = true;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a$g */
    public static class C38164g {
        public String cIY;
        public String hfr;
        public String text;
        public String url;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a$h */
    public static abstract class C38165h {
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

        /* renamed from: yV */
        public static C26839b m64599yV(String str) {
            if ("landscape".equals(str)) {
                return C26839b.LANDSCAPE_LOCKED;
            }
            if ("portrait".equals(str)) {
                return C26839b.PORTRAIT;
            }
            if ("auto".equals(str)) {
                return C26839b.UNSPECIFIED;
            }
            return null;
        }

        public final boolean ayx() {
            return "custom".equalsIgnoreCase(this.hfv);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a$f */
    public static class C38166f {
        public ArrayList<C38164g> cHb = new ArrayList();
        public String color;
        public String hfm;
        public String hfn;
        public String hfo;
        public String hfp;
        public boolean hfq;

        public C38166f() {
            AppMethodBeat.m2504i(86878);
            AppMethodBeat.m2505o(86878);
        }

        /* renamed from: yU */
        public final boolean mo60906yU(String str) {
            AppMethodBeat.m2504i(86879);
            Iterator it = this.cHb.iterator();
            while (it.hasNext()) {
                if (((C38164g) it.next()).url.equals(C8874h.m15847bO(str))) {
                    AppMethodBeat.m2505o(86879);
                    return true;
                }
            }
            AppMethodBeat.m2505o(86879);
            return false;
        }
    }

    /* renamed from: yR */
    public final C33131d mo60903yR(String str) {
        AppMethodBeat.m2504i(86880);
        C33131d b;
        if (TextUtils.isEmpty(str) || !this.heT.containsKey(str)) {
            b = C38163a.m64591b(null, this.heS);
            AppMethodBeat.m2505o(86880);
            return b;
        }
        b = (C33131d) this.heT.get(str);
        AppMethodBeat.m2505o(86880);
        return b;
    }

    /* renamed from: yS */
    public final C19155e mo60904yS(String str) {
        AppMethodBeat.m2504i(86881);
        C19155e c19155e = (C19155e) this.heU.get(str);
        AppMethodBeat.m2505o(86881);
        return c19155e;
    }

    public final String ayw() {
        AppMethodBeat.m2504i(86882);
        String str;
        if (C5046bo.isNullOrNil(this.hfg)) {
            str = "index.html";
            AppMethodBeat.m2505o(86882);
            return str;
        }
        str = this.hfg;
        AppMethodBeat.m2505o(86882);
        return str;
    }

    /* renamed from: yT */
    public static C38163a m64596yT(String str) {
        JSONObject jSONObject;
        AppMethodBeat.m2504i(86883);
        C38163a c38163a = new C38163a();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AppBrandAppConfig", e.getMessage());
            jSONObject = new JSONObject();
        }
        c38163a.hfg = jSONObject.optString("entryPagePath");
        c38163a.hff = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("global");
        C26834b c26834b = new C26834b();
        C38163a.m64589a(optJSONObject, c26834b, c26834b);
        c38163a.heS = c26834b;
        c38163a.heT = C38163a.m64590a(jSONObject.optJSONObject("page"), c38163a.heS);
        c38163a.heU = C38163a.m64594k(jSONObject.optJSONObject("permission"));
        c38163a.heV = C38163a.m64595l(jSONObject.optJSONObject("tabBar"));
        optJSONObject = jSONObject.optJSONObject("networkTimeout");
        C10174c c10174c = new C10174c();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        c10174c.cRx = optJSONObject.optInt(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        c10174c.hfj = optJSONObject.optInt("connectSocket");
        c10174c.hfl = optJSONObject.optInt("downloadFile");
        c10174c.hfk = optJSONObject.optInt("uploadFile");
        c38163a.heW = c10174c;
        C38161a c38161a = new C38161a();
        c38161a.hfh = jSONObject.optString("deviceOrientation", "portrait");
        c38161a.hfi = jSONObject.optBoolean("showStatusBar", false);
        c38163a.heX = c38161a;
        c38163a.heY = jSONObject.optBoolean("preloadEnabled", true);
        c38163a.hfa = jSONObject.has("useCommandBuffer");
        c38163a.heZ = jSONObject.optBoolean("useCommandBuffer", false);
        c38163a.hfb = C38163a.m64592i(jSONObject.optJSONArray("requiredBackgroundModes"));
        c38163a.hfc = jSONObject.optJSONArray("preloadResources");
        c38163a.hfd = C38163a.m64593j(jSONObject.optJSONArray("preloadSubpackages"));
        c38163a.hfe = jSONObject.optBoolean("manualHideSplashScreen", false);
        AppMethodBeat.m2505o(86883);
        return c38163a;
    }

    /* renamed from: a */
    private static <T extends C38165h> T m64589a(JSONObject jSONObject, T t, C38165h c38165h) {
        AppMethodBeat.m2504i(86884);
        if (jSONObject == null) {
            jSONObject = C38165h.hfE;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            optJSONObject = C38165h.hfE;
        }
        t.hfs = optJSONObject.optString("navigationBarTitleText", c38165h.hfs);
        t.hft = optJSONObject.optString("navigationBarTextStyle", c38165h.hft);
        t.hfv = optJSONObject.optString("navigationStyle", c38165h.hfv);
        t.hfw = optJSONObject.optString("navigationBarBackgroundColor", c38165h.hfw);
        t.hfo = optJSONObject.optString("backgroundColor", c38165h.hfo);
        t.hfA = optJSONObject.optBoolean("enablePullDownRefresh", c38165h.hfA);
        t.hfC = optJSONObject.optString("backgroundTextStyle", c38165h.hfC);
        t.hfz = optJSONObject.optBoolean("enableFullScreen", c38165h.hfz);
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("navigationBarRightButton");
        if (optJSONObject2 == null) {
            optJSONObject2 = C38165h.hfE;
        }
        t.hfB = optJSONObject.optBoolean("disableSwipeBack", c38165h.hfB);
        t.hfy = optJSONObject2.optBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE, c38165h.hfy);
        t.hfx = optJSONObject2.optString("customButtonIconData", c38165h.hfx);
        t.hfD = optJSONObject.optString("pageOrientation", c38165h.hfD);
        AppMethodBeat.m2505o(86884);
        return t;
    }

    /* renamed from: a */
    private static Map<String, C33131d> m64590a(JSONObject jSONObject, C26834b c26834b) {
        AppMethodBeat.m2504i(86885);
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            AppMethodBeat.m2505o(86885);
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, C38163a.m64591b(jSONObject.optJSONObject(str), c26834b));
        }
        AppMethodBeat.m2505o(86885);
        return hashMap;
    }

    /* renamed from: k */
    private static Map<String, C19155e> m64594k(JSONObject jSONObject) {
        AppMethodBeat.m2504i(86886);
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            AppMethodBeat.m2505o(86886);
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                try {
                    hashMap.put(str, new C19155e(str, optJSONObject));
                } catch (JSONException e) {
                    C4990ab.m7412e("MicroMsg.AppBrandAppConfig", e.getMessage());
                }
            }
        }
        AppMethodBeat.m2505o(86886);
        return hashMap;
    }

    /* renamed from: b */
    private static C33131d m64591b(JSONObject jSONObject, C26834b c26834b) {
        AppMethodBeat.m2504i(86887);
        C33131d c33131d = (C33131d) C38163a.m64589a(jSONObject, new C33131d(), c26834b);
        AppMethodBeat.m2505o(86887);
        return c33131d;
    }

    /* renamed from: l */
    private static C38166f m64595l(JSONObject jSONObject) {
        int i = 0;
        AppMethodBeat.m2504i(86888);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C38166f c38166f = new C38166f();
        c38166f.hfm = jSONObject.optString("position");
        c38166f.color = jSONObject.optString("color");
        c38166f.hfn = jSONObject.optString("selectedColor");
        c38166f.hfo = jSONObject.optString("backgroundColor");
        c38166f.hfp = jSONObject.optString("borderStyle");
        c38166f.hfq = jSONObject.optBoolean("custom", false);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            while (i < jSONArray.length()) {
                ArrayList arrayList = c38166f.cHb;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                C38164g c38164g = new C38164g();
                c38164g.url = jSONObject2.optString("pagePath");
                c38164g.text = jSONObject2.optString("text");
                c38164g.cIY = jSONObject2.optString("iconData");
                c38164g.hfr = jSONObject2.optString("selectedIconData");
                arrayList.add(c38164g);
                i++;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.AppBrandAppConfig", e.getMessage());
        }
        AppMethodBeat.m2505o(86888);
        return c38166f;
    }

    /* renamed from: i */
    private static Set<String> m64592i(JSONArray jSONArray) {
        AppMethodBeat.m2504i(86889);
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            AppMethodBeat.m2505o(86889);
            return hashSet;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!C5046bo.isNullOrNil(optString)) {
                hashSet.add(optString);
            }
        }
        AppMethodBeat.m2505o(86889);
        return hashSet;
    }

    /* renamed from: j */
    private static ArrayList<String> m64593j(JSONArray jSONArray) {
        AppMethodBeat.m2504i(86890);
        ArrayList<String> arrayList = new ArrayList();
        if (jSONArray == null) {
            AppMethodBeat.m2505o(86890);
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Object optString = optJSONObject.optString("root");
                if (!C5046bo.isNullOrNil(optString)) {
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
        AppMethodBeat.m2505o(86890);
        return arrayList;
    }
}
