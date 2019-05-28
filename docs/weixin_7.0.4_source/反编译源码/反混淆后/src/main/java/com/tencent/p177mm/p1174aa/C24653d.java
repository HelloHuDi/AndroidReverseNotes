package com.tencent.p177mm.p1174aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.aa.d */
public final class C24653d implements C17868c {
    private JSONObject eIz;

    public C24653d() {
        AppMethodBeat.m2504i(117523);
        this.eIz = new JSONObject();
        AppMethodBeat.m2505o(117523);
    }

    public C24653d(Map map) {
        AppMethodBeat.m2504i(117524);
        this.eIz = new JSONObject(map);
        AppMethodBeat.m2505o(117524);
    }

    public C24653d(String str) {
        AppMethodBeat.m2504i(117525);
        try {
            this.eIz = new JSONObject(str);
            AppMethodBeat.m2505o(117525);
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117525);
            throw c41724g;
        }
    }

    C24653d(JSONObject jSONObject) {
        AppMethodBeat.m2504i(117526);
        Assert.assertNotNull(jSONObject);
        this.eIz = jSONObject;
        AppMethodBeat.m2505o(117526);
    }

    public final int length() {
        AppMethodBeat.m2504i(117527);
        int length = this.eIz.length();
        AppMethodBeat.m2505o(117527);
        return length;
    }

    /* renamed from: s */
    public final C17868c mo33361s(String str, boolean z) {
        AppMethodBeat.m2504i(117528);
        try {
            this.eIz.put(str, z);
            AppMethodBeat.m2505o(117528);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117528);
            throw c41724g;
        }
    }

    /* renamed from: c */
    public final C17868c mo33334c(String str, double d) {
        AppMethodBeat.m2504i(117529);
        try {
            this.eIz.put(str, d);
            AppMethodBeat.m2505o(117529);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117529);
            throw c41724g;
        }
    }

    /* renamed from: J */
    public final C17868c mo33333J(String str, int i) {
        AppMethodBeat.m2504i(117530);
        try {
            this.eIz.put(str, i);
            AppMethodBeat.m2505o(117530);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117530);
            throw c41724g;
        }
    }

    /* renamed from: k */
    public final C17868c mo33345k(String str, long j) {
        AppMethodBeat.m2504i(117531);
        try {
            this.eIz.put(str, j);
            AppMethodBeat.m2505o(117531);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117531);
            throw c41724g;
        }
    }

    /* renamed from: e */
    public final C17868c mo33335e(String str, Object obj) {
        AppMethodBeat.m2504i(117532);
        try {
            if (obj instanceof C24653d) {
                this.eIz.put(str, ((C24653d) obj).eIz);
            } else {
                this.eIz.put(str, obj);
            }
            AppMethodBeat.m2505o(117532);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117532);
            throw c41724g;
        }
    }

    /* renamed from: f */
    public final C17868c mo33336f(String str, Object obj) {
        AppMethodBeat.m2504i(117533);
        try {
            if (obj instanceof C24653d) {
                this.eIz.putOpt(str, ((C24653d) obj).eIz);
            } else {
                this.eIz.putOpt(str, obj);
            }
            AppMethodBeat.m2505o(117533);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117533);
            throw c41724g;
        }
    }

    /* renamed from: lr */
    public final String mo33348lr(String str) {
        AppMethodBeat.m2504i(117534);
        if (str == null) {
            C41724g c41724g = new C41724g("Names must be non-null");
            AppMethodBeat.m2505o(117534);
            throw c41724g;
        }
        AppMethodBeat.m2505o(117534);
        return str;
    }

    public final Object remove(String str) {
        AppMethodBeat.m2504i(117535);
        Object remove = this.eIz.remove(str);
        AppMethodBeat.m2505o(117535);
        return remove;
    }

    public final boolean isNull(String str) {
        AppMethodBeat.m2504i(117536);
        boolean isNull = this.eIz.isNull(str);
        AppMethodBeat.m2505o(117536);
        return isNull;
    }

    public final boolean has(String str) {
        AppMethodBeat.m2504i(117537);
        boolean has = this.eIz.has(str);
        AppMethodBeat.m2505o(117537);
        return has;
    }

    public final Object get(String str) {
        AppMethodBeat.m2504i(117538);
        try {
            Object obj = this.eIz.get(str);
            if (obj instanceof JSONObject) {
                C24653d c24653d = new C24653d((JSONObject) obj);
                AppMethodBeat.m2505o(117538);
                return c24653d;
            } else if (obj instanceof JSONArray) {
                C17867b c17867b = new C17867b((JSONArray) obj);
                AppMethodBeat.m2505o(117538);
                return c17867b;
            } else {
                AppMethodBeat.m2505o(117538);
                return obj;
            }
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117538);
            throw c41724g;
        }
    }

    public final Object opt(String str) {
        AppMethodBeat.m2504i(117539);
        try {
            Object obj = this.eIz.get(str);
            if (obj instanceof JSONObject) {
                C24653d c24653d = new C24653d((JSONObject) obj);
                AppMethodBeat.m2505o(117539);
                return c24653d;
            } else if (obj instanceof JSONArray) {
                C17867b c17867b = new C17867b((JSONArray) obj);
                AppMethodBeat.m2505o(117539);
                return c17867b;
            } else {
                AppMethodBeat.m2505o(117539);
                return obj;
            }
        } catch (JSONException e) {
            AppMethodBeat.m2505o(117539);
            return null;
        }
    }

    public final boolean getBoolean(String str) {
        AppMethodBeat.m2504i(117540);
        try {
            boolean z = this.eIz.getBoolean(str);
            AppMethodBeat.m2505o(117540);
            return z;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117540);
            throw c41724g;
        }
    }

    public final boolean optBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(117541);
        boolean optBoolean = this.eIz.optBoolean(str, z);
        AppMethodBeat.m2505o(117541);
        return optBoolean;
    }

    public final double getDouble(String str) {
        AppMethodBeat.m2504i(117542);
        try {
            double d = this.eIz.getDouble(str);
            AppMethodBeat.m2505o(117542);
            return d;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117542);
            throw c41724g;
        }
    }

    public final double optDouble(String str, double d) {
        AppMethodBeat.m2504i(117543);
        double optDouble = this.eIz.optDouble(str, d);
        AppMethodBeat.m2505o(117543);
        return optDouble;
    }

    public final int getInt(String str) {
        AppMethodBeat.m2504i(117544);
        try {
            int i = this.eIz.getInt(str);
            AppMethodBeat.m2505o(117544);
            return i;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117544);
            throw c41724g;
        }
    }

    public final int optInt(String str, int i) {
        AppMethodBeat.m2504i(117545);
        int optInt = this.eIz.optInt(str, i);
        AppMethodBeat.m2505o(117545);
        return optInt;
    }

    public final long getLong(String str) {
        AppMethodBeat.m2504i(117546);
        try {
            long j = this.eIz.getLong(str);
            AppMethodBeat.m2505o(117546);
            return j;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117546);
            throw c41724g;
        }
    }

    public final long optLong(String str, long j) {
        AppMethodBeat.m2504i(117547);
        long optLong = this.eIz.optLong(str, j);
        AppMethodBeat.m2505o(117547);
        return optLong;
    }

    public final String getString(String str) {
        AppMethodBeat.m2504i(117548);
        try {
            String string = this.eIz.getString(str);
            AppMethodBeat.m2505o(117548);
            return string;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117548);
            throw c41724g;
        }
    }

    public final String optString(String str) {
        AppMethodBeat.m2504i(117549);
        String optString = this.eIz.optString(str);
        AppMethodBeat.m2505o(117549);
        return optString;
    }

    public final String optString(String str, String str2) {
        AppMethodBeat.m2504i(117550);
        String optString = this.eIz.optString(str, str2);
        AppMethodBeat.m2505o(117550);
        return optString;
    }

    /* renamed from: ls */
    public final C41723a mo33349ls(String str) {
        AppMethodBeat.m2504i(117551);
        try {
            JSONArray jSONArray = this.eIz.getJSONArray(str);
            if (jSONArray == null) {
                AppMethodBeat.m2505o(117551);
                return null;
            }
            C41723a c17867b = new C17867b(jSONArray);
            AppMethodBeat.m2505o(117551);
            return c17867b;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117551);
            throw c41724g;
        }
    }

    /* renamed from: lt */
    public final C41723a mo33350lt(String str) {
        AppMethodBeat.m2504i(117552);
        JSONArray optJSONArray = this.eIz.optJSONArray(str);
        if (optJSONArray == null) {
            AppMethodBeat.m2505o(117552);
            return null;
        }
        C41723a c17867b = new C17867b(optJSONArray);
        AppMethodBeat.m2505o(117552);
        return c17867b;
    }

    /* renamed from: lu */
    public final C17868c mo33351lu(String str) {
        AppMethodBeat.m2504i(117553);
        try {
            JSONObject jSONObject = this.eIz.getJSONObject(str);
            if (jSONObject == null) {
                AppMethodBeat.m2505o(117553);
                return null;
            }
            C17868c c24653d = new C24653d(jSONObject);
            AppMethodBeat.m2505o(117553);
            return c24653d;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117553);
            throw c41724g;
        }
    }

    /* renamed from: lv */
    public final C17868c mo33352lv(String str) {
        AppMethodBeat.m2504i(117554);
        JSONObject optJSONObject = this.eIz.optJSONObject(str);
        if (optJSONObject == null) {
            AppMethodBeat.m2505o(117554);
            return null;
        }
        C17868c c24653d = new C24653d(optJSONObject);
        AppMethodBeat.m2505o(117554);
        return c24653d;
    }

    public final Iterator<String> keys() {
        AppMethodBeat.m2504i(117555);
        Iterator keys = this.eIz.keys();
        AppMethodBeat.m2505o(117555);
        return keys;
    }

    public final String toString() {
        AppMethodBeat.m2504i(117556);
        String jSONObject = this.eIz.toString();
        AppMethodBeat.m2505o(117556);
        return jSONObject;
    }
}
