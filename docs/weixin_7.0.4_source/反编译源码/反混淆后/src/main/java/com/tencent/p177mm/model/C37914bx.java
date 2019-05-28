package com.tencent.p177mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.model.bx */
public final class C37914bx {
    public static C37914bx fnB = new C37914bx();
    private SharedPreferences fnC = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_account_switch", 0);
    private SharedPreferences fnl = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_account_history", 0);

    static {
        AppMethodBeat.m2504i(58129);
        AppMethodBeat.m2505o(58129);
    }

    private C37914bx() {
        AppMethodBeat.m2504i(58118);
        AppMethodBeat.m2505o(58118);
    }

    /* renamed from: n */
    public final void mo60668n(String str, String str2, String str3) {
        AppMethodBeat.m2504i(58119);
        try {
            JSONObject jSONObject;
            if (this.fnl.contains(str)) {
                String string = this.fnl.getString(str, "");
                if (C5046bo.isNullOrNil(string)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                }
            } else {
                jSONObject = new JSONObject();
            }
            if (!C5046bo.m7510Q(str2, str3)) {
                jSONObject.put(str2, str3);
                C4990ab.m7417i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", str2, jSONObject.toString());
                this.fnl.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
            }
            AppMethodBeat.m2505o(58119);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", str2, str, e.getMessage());
            AppMethodBeat.m2505o(58119);
        }
    }

    /* renamed from: g */
    public final void mo60666g(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(58120);
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject;
                    if (this.fnl.contains(str)) {
                        String string = this.fnl.getString(str, "");
                        if (C5046bo.isNullOrNil(string)) {
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
                    C4990ab.m7417i("MicroMsg.SwitchAccountInfo", "put json str %s", jSONObject.toString());
                    this.fnl.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
                    AppMethodBeat.m2505o(58120);
                    return;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", str, e.getMessage());
                AppMethodBeat.m2505o(58120);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
        AppMethodBeat.m2505o(58120);
    }

    public final String getString(String str, String str2) {
        String string;
        AppMethodBeat.m2504i(58121);
        try {
            C4990ab.m7417i("MicroMsg.SwitchAccountInfo", "get %s, %s", str, str2);
            if (this.fnl.contains(str)) {
                String str3 = new String(Base64.decode(this.fnl.getString(str, ""), 0));
                if (!C5046bo.isNullOrNil(str3)) {
                    C4990ab.m7417i("MicroMsg.SwitchAccountInfo", "get json str %s", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        string = jSONObject.getString(str2);
                        AppMethodBeat.m2505o(58121);
                        return string;
                    }
                }
            }
            C4990ab.m7421w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", str);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", str2, str, e.getMessage());
        }
        string = "";
        AppMethodBeat.m2505o(58121);
        return string;
    }

    /* renamed from: oK */
    public final void mo60669oK(String str) {
        AppMethodBeat.m2504i(58122);
        if (mo60670oL(str)) {
            Set stringSet = this.fnC.getStringSet("first_switch_group", null);
            if (stringSet != null) {
                stringSet.remove(str);
                Editor edit = this.fnC.edit();
                edit.remove("first_switch_group").apply();
                edit.putStringSet("first_switch_group", stringSet).commit();
            }
        }
        if (mo60671oM(str)) {
            m64030oN(str);
        }
        AppMethodBeat.m2505o(58122);
    }

    /* renamed from: an */
    public final void mo60665an(String str, String str2) {
        AppMethodBeat.m2504i(58123);
        if (C5046bo.m7510Q(str, str2) || str.equals(str2)) {
            AppMethodBeat.m2505o(58123);
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
                m64030oN(oN);
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
        AppMethodBeat.m2505o(58123);
    }

    /* renamed from: oL */
    public final boolean mo60670oL(String str) {
        AppMethodBeat.m2504i(58124);
        Set stringSet = this.fnC.getStringSet("first_switch_group", null);
        if (stringSet == null) {
            AppMethodBeat.m2505o(58124);
            return false;
        }
        boolean contains = stringSet.contains(str);
        AppMethodBeat.m2505o(58124);
        return contains;
    }

    /* renamed from: oM */
    public final boolean mo60671oM(String str) {
        AppMethodBeat.m2504i(58125);
        boolean contains = this.fnl.contains(str);
        AppMethodBeat.m2505o(58125);
        return contains;
    }

    /* renamed from: oN */
    private void m64030oN(String str) {
        AppMethodBeat.m2504i(58126);
        if (this.fnl.contains(str)) {
            try {
                C5730e.deleteFile(getString(str, "last_avatar_path"));
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.SwitchAccountInfo", "remove avatar file error %s", e.getMessage());
            }
            this.fnl.edit().remove(str).commit();
        }
        AppMethodBeat.m2505o(58126);
    }

    public final Set<String> aat() {
        AppMethodBeat.m2504i(58127);
        HashSet hashSet = new HashSet();
        Set stringSet = this.fnC.getStringSet("first_switch_group", null);
        if (!(stringSet == null || stringSet.isEmpty())) {
            hashSet.addAll(stringSet);
        }
        AppMethodBeat.m2505o(58127);
        return hashSet;
    }

    public final String aau() {
        AppMethodBeat.m2504i(58128);
        Set<String> aat = aat();
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : aat) {
            stringBuilder.append(append);
            stringBuilder.append(';');
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        C4990ab.m7417i("MicroMsg.SwitchAccountInfo", "switch users %s", stringBuilder.toString());
        String append2 = stringBuilder.toString();
        AppMethodBeat.m2505o(58128);
        return append2;
    }
}
