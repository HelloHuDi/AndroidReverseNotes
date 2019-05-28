package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class bx {
    public static bx fnB = new bx();
    private SharedPreferences fnC = ah.getContext().getSharedPreferences(ah.doA() + "_account_switch", 0);
    private SharedPreferences fnl = ah.getContext().getSharedPreferences(ah.doA() + "_account_history", 0);

    static {
        AppMethodBeat.i(58129);
        AppMethodBeat.o(58129);
    }

    private bx() {
        AppMethodBeat.i(58118);
        AppMethodBeat.o(58118);
    }

    public final void n(String str, String str2, String str3) {
        AppMethodBeat.i(58119);
        try {
            JSONObject jSONObject;
            if (this.fnl.contains(str)) {
                String string = this.fnl.getString(str, "");
                if (bo.isNullOrNil(string)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                }
            } else {
                jSONObject = new JSONObject();
            }
            if (!bo.Q(str2, str3)) {
                jSONObject.put(str2, str3);
                ab.i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", str2, jSONObject.toString());
                this.fnl.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
            }
            AppMethodBeat.o(58119);
        } catch (Exception e) {
            ab.e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", str2, str, e.getMessage());
            AppMethodBeat.o(58119);
        }
    }

    public final void g(String str, Map<String, String> map) {
        AppMethodBeat.i(58120);
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject;
                    if (this.fnl.contains(str)) {
                        String string = this.fnl.getString(str, "");
                        if (bo.isNullOrNil(string)) {
                            jSONObject = new JSONObject();
                        } else {
                            jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                        }
                    } else {
                        jSONObject = new JSONObject();
                    }
                    for (String str2 : map.keySet()) {
                        jSONObject.put(str2, map.get(str2));
                    }
                    ab.i("MicroMsg.SwitchAccountInfo", "put json str %s", jSONObject.toString());
                    this.fnl.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
                    AppMethodBeat.o(58120);
                    return;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", str, e.getMessage());
                AppMethodBeat.o(58120);
                return;
            }
        }
        ab.i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
        AppMethodBeat.o(58120);
    }

    public final String getString(String str, String str2) {
        String string;
        AppMethodBeat.i(58121);
        try {
            ab.i("MicroMsg.SwitchAccountInfo", "get %s, %s", str, str2);
            if (this.fnl.contains(str)) {
                String str3 = new String(Base64.decode(this.fnl.getString(str, ""), 0));
                if (!bo.isNullOrNil(str3)) {
                    ab.i("MicroMsg.SwitchAccountInfo", "get json str %s", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        string = jSONObject.getString(str2);
                        AppMethodBeat.o(58121);
                        return string;
                    }
                }
            }
            ab.w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", str);
        } catch (Exception e) {
            ab.e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
        string = "";
        AppMethodBeat.o(58121);
        return string;
    }

    public final void oK(String str) {
        AppMethodBeat.i(58122);
        if (oL(str)) {
            Set stringSet = this.fnC.getStringSet("first_switch_group", null);
            if (stringSet != null) {
                stringSet.remove(str);
                Editor edit = this.fnC.edit();
                edit.remove("first_switch_group").apply();
                edit.putStringSet("first_switch_group", stringSet).commit();
            }
        }
        if (oM(str)) {
            oN(str);
        }
        AppMethodBeat.o(58122);
    }

    public final void an(String str, String str2) {
        AppMethodBeat.i(58123);
        if (bo.Q(str, str2) || str.equals(str2)) {
            AppMethodBeat.o(58123);
            return;
        }
        Set stringSet = this.fnC.getStringSet("first_switch_group", null);
        Set hashSet;
        if (stringSet == null) {
            hashSet = new HashSet();
        } else {
            hashSet = stringSet;
        }
        if (!hashSet.contains(str) || hashSet.size() >= 2) {
            for (String oN : hashSet) {
                oN(oN);
            }
            hashSet.clear();
            hashSet.add(str);
            hashSet.add(str2);
        } else {
            hashSet.add(str2);
        }
        Editor edit = this.fnC.edit();
        edit.remove("first_switch_group").apply();
        edit.putStringSet("first_switch_group", hashSet).commit();
        AppMethodBeat.o(58123);
    }

    public final boolean oL(String str) {
        AppMethodBeat.i(58124);
        Set stringSet = this.fnC.getStringSet("first_switch_group", null);
        if (stringSet == null) {
            AppMethodBeat.o(58124);
            return false;
        }
        boolean contains = stringSet.contains(str);
        AppMethodBeat.o(58124);
        return contains;
    }

    public final boolean oM(String str) {
        AppMethodBeat.i(58125);
        boolean contains = this.fnl.contains(str);
        AppMethodBeat.o(58125);
        return contains;
    }

    private void oN(String str) {
        AppMethodBeat.i(58126);
        if (this.fnl.contains(str)) {
            try {
                e.deleteFile(getString(str, "last_avatar_path"));
            } catch (Exception e) {
                ab.w("MicroMsg.SwitchAccountInfo", "remove avatar file error %s", e.getMessage());
            }
            this.fnl.edit().remove(str).commit();
        }
        AppMethodBeat.o(58126);
    }

    public final Set<String> aat() {
        AppMethodBeat.i(58127);
        HashSet hashSet = new HashSet();
        Set stringSet = this.fnC.getStringSet("first_switch_group", null);
        if (!(stringSet == null || stringSet.isEmpty())) {
            hashSet.addAll(stringSet);
        }
        AppMethodBeat.o(58127);
        return hashSet;
    }

    public final String aau() {
        AppMethodBeat.i(58128);
        Set<String> aat = aat();
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : aat) {
            stringBuilder.append(append);
            stringBuilder.append(';');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        ab.i("MicroMsg.SwitchAccountInfo", "switch users %s", stringBuilder.toString());
        String append2 = stringBuilder.toString();
        AppMethodBeat.o(58128);
        return append2;
    }
}
