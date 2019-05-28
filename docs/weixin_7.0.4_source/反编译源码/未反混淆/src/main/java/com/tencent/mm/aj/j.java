package com.tencent.mm.aj;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class j {
    public static String fwo = "menu_click";
    public static String fwp = "menu_action_start";
    public static String fwq = "menu_action_success";
    public String cRS;
    public String content;
    public List<j> fwr = null;
    public int fws;
    public int id;
    public String key;
    public String name;
    public String state;
    public int type;
    public String value;

    public final void az(String str, String str2) {
        AppMethodBeat.i(105481);
        ab.v("MicroMsg.BizMenuItem", "type is %s , result is %s", str, str2);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scan_type", str);
            jSONObject.put("scan_result", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("scan_code", jSONObject);
            this.content = jSONObject2.toString();
            ab.v("MicroMsg.BizMenuItem", "content: %s", this.content);
            AppMethodBeat.o(105481);
        } catch (JSONException e) {
            ab.e("MicroMsg.BizMenuItem", e.toString());
            AppMethodBeat.o(105481);
        }
    }

    public final void g(ArrayList<String> arrayList) {
        AppMethodBeat.i(105482);
        if (arrayList.size() == 0) {
            ab.e("MicroMsg.BizMenuItem", "value null!");
            AppMethodBeat.o(105482);
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
            ab.v("MicroMsg.BizMenuItem", this.content);
            AppMethodBeat.o(105482);
        } catch (JSONException e) {
            ab.e("MicroMsg.BizMenuItem", e.toString());
            AppMethodBeat.o(105482);
        }
    }

    public final void a(double d, double d2, int i, String str, String str2) {
        AppMethodBeat.i(105483);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(VideoMaterialUtil.CRAZYFACE_X, String.valueOf(d));
            jSONObject.put(VideoMaterialUtil.CRAZYFACE_Y, String.valueOf(d2));
            jSONObject.put(WMElement.ANIMATE_TYPE_SCALE, i);
            jSONObject.put("label", str);
            jSONObject.put("poiname", str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(b.LOCATION, jSONObject);
            this.content = jSONObject2.toString();
            ab.v("MicroMsg.BizMenuItem", this.content);
            AppMethodBeat.o(105483);
        } catch (JSONException e) {
            ab.e("MicroMsg.BizMenuItem", e.toString());
            AppMethodBeat.o(105483);
        }
    }

    public final String getInfo() {
        AppMethodBeat.i(105484);
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
        String format = String.format("%s<info><id><![CDATA[%d]]></id><key><![CDATA[%s]]></key><status><![CDATA[%s]]></status><content><![CDATA[%s]]></content></info>", new Object[]{"#bizmenu#", Integer.valueOf(this.id), this.key, this.state, this.content});
        AppMethodBeat.o(105484);
        return format;
    }

    public final String toString() {
        AppMethodBeat.i(105485);
        String str = "id:%d, type:%d, acttype:%s, name:%s, key:%s, value:%s, content:%s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.id);
        objArr[1] = Integer.valueOf(this.fws);
        objArr[2] = Integer.valueOf(this.type);
        objArr[3] = this.name == null ? "" : this.name;
        objArr[4] = this.key == null ? "" : this.key;
        objArr[5] = this.value == null ? "" : this.value;
        objArr[6] = this.content == null ? "" : this.content;
        String format = String.format(str, objArr);
        AppMethodBeat.o(105485);
        return format;
    }

    public static List<j> e(JSONArray jSONArray) {
        ArrayList arrayList;
        AppMethodBeat.i(105486);
        if (jSONArray != null) {
            try {
                arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    j jVar = new j();
                    jVar.id = jSONObject.getInt("id");
                    jVar.type = jSONObject.getInt("type");
                    jVar.name = jSONObject.getString("name");
                    jVar.key = jSONObject.getString("key");
                    jVar.value = jSONObject.optString("value");
                    jVar.cRS = jSONObject.optString("native_url");
                    ab.d("MicroMsg.BizMenuItem", "menuItem.nativeurl : " + jVar.cRS);
                    jVar.fwr = e(jSONObject.optJSONArray("sub_button_list"));
                    jVar.fws = jSONObject.optInt("acttype");
                    arrayList.add(jVar);
                }
            } catch (JSONException e) {
                ab.e("MicroMsg.BizMenuItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(105486);
                return null;
            }
        }
        arrayList = null;
        AppMethodBeat.o(105486);
        return arrayList;
    }

    public static LinkedList<j> o(Map<String, String> map) {
        AppMethodBeat.i(105487);
        if (map == null) {
            AppMethodBeat.o(105487);
            return null;
        }
        int i = bo.getInt((String) map.get(".msg.appmsg.buttonlist.$count"), 0);
        if (i > 0) {
            try {
                LinkedList<j> linkedList = new LinkedList();
                ab.v("MicroMsg.BizMenuItem", "menuItem.jsonArray.length : ".concat(String.valueOf(i)));
                int i2 = 0;
                while (i2 < i) {
                    j jVar = new j();
                    String str = ".msg.appmsg.buttonlist.button" + (i2 == 0 ? "" : String.valueOf(i2));
                    jVar.id = bo.getInt((String) map.get(str + ".id"), 0);
                    jVar.type = bo.getInt((String) map.get(str + ".type"), 0);
                    jVar.name = (String) map.get(str + ".name");
                    jVar.key = (String) map.get(str + ".key");
                    jVar.value = (String) map.get(str + ".value");
                    jVar.fws = bo.getInt((String) map.get(str + ".acttype"), 0);
                    linkedList.add(jVar);
                    i2++;
                }
                AppMethodBeat.o(105487);
                return linkedList;
            } catch (Exception e) {
                ab.e("MicroMsg.BizMenuItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(105487);
                return null;
            }
        }
        AppMethodBeat.o(105487);
        return null;
    }
}
