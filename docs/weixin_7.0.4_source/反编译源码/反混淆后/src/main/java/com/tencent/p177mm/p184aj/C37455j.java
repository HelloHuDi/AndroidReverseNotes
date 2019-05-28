package com.tencent.p177mm.p184aj;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.aj.j */
public final class C37455j {
    public static String fwo = "menu_click";
    public static String fwp = "menu_action_start";
    public static String fwq = "menu_action_success";
    public String cRS;
    public String content;
    public List<C37455j> fwr = null;
    public int fws;
    /* renamed from: id */
    public int f16115id;
    public String key;
    public String name;
    public String state;
    public int type;
    public String value;

    /* renamed from: az */
    public final void mo60367az(String str, String str2) {
        AppMethodBeat.m2504i(105481);
        C4990ab.m7419v("MicroMsg.BizMenuItem", "type is %s , result is %s", str, str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scan_type", str);
            jSONObject.put("scan_result", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("scan_code", jSONObject);
            this.content = jSONObject2.toString();
            C4990ab.m7419v("MicroMsg.BizMenuItem", "content: %s", this.content);
            AppMethodBeat.m2505o(105481);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.BizMenuItem", e.toString());
            AppMethodBeat.m2505o(105481);
        }
    }

    /* renamed from: g */
    public final void mo60368g(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(105482);
        if (arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.BizMenuItem", "value null!");
            AppMethodBeat.m2505o(105482);
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pic_md5", str);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pics", jSONArray);
            this.content = jSONObject2.toString();
            C4990ab.m7418v("MicroMsg.BizMenuItem", this.content);
            AppMethodBeat.m2505o(105482);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.BizMenuItem", e.toString());
            AppMethodBeat.m2505o(105482);
        }
    }

    /* renamed from: a */
    public final void mo60366a(double d, double d2, int i, String str, String str2) {
        AppMethodBeat.m2504i(105483);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(VideoMaterialUtil.CRAZYFACE_X, String.valueOf(d));
            jSONObject.put(VideoMaterialUtil.CRAZYFACE_Y, String.valueOf(d2));
            jSONObject.put(WMElement.ANIMATE_TYPE_SCALE, i);
            jSONObject.put("label", str);
            jSONObject.put("poiname", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C8741b.LOCATION, jSONObject);
            this.content = jSONObject2.toString();
            C4990ab.m7418v("MicroMsg.BizMenuItem", this.content);
            AppMethodBeat.m2505o(105483);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.BizMenuItem", e.toString());
            AppMethodBeat.m2505o(105483);
        }
    }

    public final String getInfo() {
        AppMethodBeat.m2504i(105484);
        if (this.content == null) {
            this.content = "";
        }
        if (this.state == null) {
            if (this.type == 4) {
                this.state = fwp;
            } else {
                this.state = fwo;
            }
        }
        String format = String.format("%s<info><id><![CDATA[%d]]></id><key><![CDATA[%s]]></key><status><![CDATA[%s]]></status><content><![CDATA[%s]]></content></info>", new Object[]{"#bizmenu#", Integer.valueOf(this.f16115id), this.key, this.state, this.content});
        AppMethodBeat.m2505o(105484);
        return format;
    }

    public final String toString() {
        AppMethodBeat.m2504i(105485);
        String str = "id:%d, type:%d, acttype:%s, name:%s, key:%s, value:%s, content:%s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.f16115id);
        objArr[1] = Integer.valueOf(this.fws);
        objArr[2] = Integer.valueOf(this.type);
        objArr[3] = this.name == null ? "" : this.name;
        objArr[4] = this.key == null ? "" : this.key;
        objArr[5] = this.value == null ? "" : this.value;
        objArr[6] = this.content == null ? "" : this.content;
        String format = String.format(str, objArr);
        AppMethodBeat.m2505o(105485);
        return format;
    }

    /* renamed from: e */
    public static List<C37455j> m63154e(JSONArray jSONArray) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(105486);
        if (jSONArray != null) {
            try {
                arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    C37455j c37455j = new C37455j();
                    c37455j.f16115id = jSONObject.getInt("id");
                    c37455j.type = jSONObject.getInt("type");
                    c37455j.name = jSONObject.getString("name");
                    c37455j.key = jSONObject.getString("key");
                    c37455j.value = jSONObject.optString("value");
                    c37455j.cRS = jSONObject.optString("native_url");
                    C4990ab.m7410d("MicroMsg.BizMenuItem", "menuItem.nativeurl : " + c37455j.cRS);
                    c37455j.fwr = C37455j.m63154e(jSONObject.optJSONArray("sub_button_list"));
                    c37455j.fws = jSONObject.optInt("acttype");
                    arrayList.add(c37455j);
                }
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.BizMenuItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(105486);
                return null;
            }
        }
        arrayList = null;
        AppMethodBeat.m2505o(105486);
        return arrayList;
    }

    /* renamed from: o */
    public static LinkedList<C37455j> m63155o(Map<String, String> map) {
        AppMethodBeat.m2504i(105487);
        if (map == null) {
            AppMethodBeat.m2505o(105487);
            return null;
        }
        int i = C5046bo.getInt((String) map.get(".msg.appmsg.buttonlist.$count"), 0);
        if (i > 0) {
            try {
                LinkedList<C37455j> linkedList = new LinkedList();
                C4990ab.m7418v("MicroMsg.BizMenuItem", "menuItem.jsonArray.length : ".concat(String.valueOf(i)));
                int i2 = 0;
                while (i2 < i) {
                    C37455j c37455j = new C37455j();
                    String str = ".msg.appmsg.buttonlist.button" + (i2 == 0 ? "" : String.valueOf(i2));
                    c37455j.f16115id = C5046bo.getInt((String) map.get(str + ".id"), 0);
                    c37455j.type = C5046bo.getInt((String) map.get(str + ".type"), 0);
                    c37455j.name = (String) map.get(str + ".name");
                    c37455j.key = (String) map.get(str + ".key");
                    c37455j.value = (String) map.get(str + ".value");
                    c37455j.fws = C5046bo.getInt((String) map.get(str + ".acttype"), 0);
                    linkedList.add(c37455j);
                    i2++;
                }
                AppMethodBeat.m2505o(105487);
                return linkedList;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BizMenuItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(105487);
                return null;
            }
        }
        AppMethodBeat.m2505o(105487);
        return null;
    }
}
