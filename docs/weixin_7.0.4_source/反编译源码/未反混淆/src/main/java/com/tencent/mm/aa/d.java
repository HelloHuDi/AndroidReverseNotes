package com.tencent.mm.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements c {
    private JSONObject eIz;

    public d() {
        AppMethodBeat.i(117523);
        this.eIz = new JSONObject();
        AppMethodBeat.o(117523);
    }

    public d(Map map) {
        AppMethodBeat.i(117524);
        this.eIz = new JSONObject(map);
        AppMethodBeat.o(117524);
    }

    public d(String str) {
        AppMethodBeat.i(117525);
        try {
            this.eIz = new JSONObject(str);
            AppMethodBeat.o(117525);
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117525);
            throw gVar;
        }
    }

    d(JSONObject jSONObject) {
        AppMethodBeat.i(117526);
        Assert.assertNotNull(jSONObject);
        this.eIz = jSONObject;
        AppMethodBeat.o(117526);
    }

    public final int length() {
        AppMethodBeat.i(117527);
        int length = this.eIz.length();
        AppMethodBeat.o(117527);
        return length;
    }

    public final c s(String str, boolean z) {
        AppMethodBeat.i(117528);
        try {
            this.eIz.put(str, z);
            AppMethodBeat.o(117528);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117528);
            throw gVar;
        }
    }

    public final c c(String str, double d) {
        AppMethodBeat.i(117529);
        try {
            this.eIz.put(str, d);
            AppMethodBeat.o(117529);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117529);
            throw gVar;
        }
    }

    public final c J(String str, int i) {
        AppMethodBeat.i(117530);
        try {
            this.eIz.put(str, i);
            AppMethodBeat.o(117530);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117530);
            throw gVar;
        }
    }

    public final c k(String str, long j) {
        AppMethodBeat.i(117531);
        try {
            this.eIz.put(str, j);
            AppMethodBeat.o(117531);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117531);
            throw gVar;
        }
    }

    public final c e(String str, Object obj) {
        AppMethodBeat.i(117532);
        try {
            if (obj instanceof d) {
                this.eIz.put(str, ((d) obj).eIz);
            } else {
                this.eIz.put(str, obj);
            }
            AppMethodBeat.o(117532);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117532);
            throw gVar;
        }
    }

    public final c f(String str, Object obj) {
        AppMethodBeat.i(117533);
        try {
            if (obj instanceof d) {
                this.eIz.putOpt(str, ((d) obj).eIz);
            } else {
                this.eIz.putOpt(str, obj);
            }
            AppMethodBeat.o(117533);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117533);
            throw gVar;
        }
    }

    public final String lr(String str) {
        AppMethodBeat.i(117534);
        if (str == null) {
            g gVar = new g("Names must be non-null");
            AppMethodBeat.o(117534);
            throw gVar;
        }
        AppMethodBeat.o(117534);
        return str;
    }

    public final Object remove(String str) {
        AppMethodBeat.i(117535);
        Object remove = this.eIz.remove(str);
        AppMethodBeat.o(117535);
        return remove;
    }

    public final boolean isNull(String str) {
        AppMethodBeat.i(117536);
        boolean isNull = this.eIz.isNull(str);
        AppMethodBeat.o(117536);
        return isNull;
    }

    public final boolean has(String str) {
        AppMethodBeat.i(117537);
        boolean has = this.eIz.has(str);
        AppMethodBeat.o(117537);
        return has;
    }

    public final Object get(String str) {
        AppMethodBeat.i(117538);
        try {
            Object obj = this.eIz.get(str);
            if (obj instanceof JSONObject) {
                d dVar = new d((JSONObject) obj);
                AppMethodBeat.o(117538);
                return dVar;
            } else if (obj instanceof JSONArray) {
                b bVar = new b((JSONArray) obj);
                AppMethodBeat.o(117538);
                return bVar;
            } else {
                AppMethodBeat.o(117538);
                return obj;
            }
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117538);
            throw gVar;
        }
    }

    public final Object opt(String str) {
        AppMethodBeat.i(117539);
        try {
            Object obj = this.eIz.get(str);
            if (obj instanceof JSONObject) {
                d dVar = new d((JSONObject) obj);
                AppMethodBeat.o(117539);
                return dVar;
            } else if (obj instanceof JSONArray) {
                b bVar = new b((JSONArray) obj);
                AppMethodBeat.o(117539);
                return bVar;
            } else {
                AppMethodBeat.o(117539);
                return obj;
            }
        } catch (JSONException e) {
            AppMethodBeat.o(117539);
            return null;
        }
    }

    public final boolean getBoolean(String str) {
        AppMethodBeat.i(117540);
        try {
            boolean z = this.eIz.getBoolean(str);
            AppMethodBeat.o(117540);
            return z;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117540);
            throw gVar;
        }
    }

    public final boolean optBoolean(String str, boolean z) {
        AppMethodBeat.i(117541);
        boolean optBoolean = this.eIz.optBoolean(str, z);
        AppMethodBeat.o(117541);
        return optBoolean;
    }

    public final double getDouble(String str) {
        AppMethodBeat.i(117542);
        try {
            double d = this.eIz.getDouble(str);
            AppMethodBeat.o(117542);
            return d;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117542);
            throw gVar;
        }
    }

    public final double optDouble(String str, double d) {
        AppMethodBeat.i(117543);
        double optDouble = this.eIz.optDouble(str, d);
        AppMethodBeat.o(117543);
        return optDouble;
    }

    public final int getInt(String str) {
        AppMethodBeat.i(117544);
        try {
            int i = this.eIz.getInt(str);
            AppMethodBeat.o(117544);
            return i;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117544);
            throw gVar;
        }
    }

    public final int optInt(String str, int i) {
        AppMethodBeat.i(117545);
        int optInt = this.eIz.optInt(str, i);
        AppMethodBeat.o(117545);
        return optInt;
    }

    public final long getLong(String str) {
        AppMethodBeat.i(117546);
        try {
            long j = this.eIz.getLong(str);
            AppMethodBeat.o(117546);
            return j;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117546);
            throw gVar;
        }
    }

    public final long optLong(String str, long j) {
        AppMethodBeat.i(117547);
        long optLong = this.eIz.optLong(str, j);
        AppMethodBeat.o(117547);
        return optLong;
    }

    public final String getString(String str) {
        AppMethodBeat.i(117548);
        try {
            String string = this.eIz.getString(str);
            AppMethodBeat.o(117548);
            return string;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117548);
            throw gVar;
        }
    }

    public final String optString(String str) {
        AppMethodBeat.i(117549);
        String optString = this.eIz.optString(str);
        AppMethodBeat.o(117549);
        return optString;
    }

    public final String optString(String str, String str2) {
        AppMethodBeat.i(117550);
        String optString = this.eIz.optString(str, str2);
        AppMethodBeat.o(117550);
        return optString;
    }

    public final a ls(String str) {
        AppMethodBeat.i(117551);
        try {
            JSONArray jSONArray = this.eIz.getJSONArray(str);
            if (jSONArray == null) {
                AppMethodBeat.o(117551);
                return null;
            }
            a bVar = new b(jSONArray);
            AppMethodBeat.o(117551);
            return bVar;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117551);
            throw gVar;
        }
    }

    public final a lt(String str) {
        AppMethodBeat.i(117552);
        JSONArray optJSONArray = this.eIz.optJSONArray(str);
        if (optJSONArray == null) {
            AppMethodBeat.o(117552);
            return null;
        }
        a bVar = new b(optJSONArray);
        AppMethodBeat.o(117552);
        return bVar;
    }

    public final c lu(String str) {
        AppMethodBeat.i(117553);
        try {
            JSONObject jSONObject = this.eIz.getJSONObject(str);
            if (jSONObject == null) {
                AppMethodBeat.o(117553);
                return null;
            }
            c dVar = new d(jSONObject);
            AppMethodBeat.o(117553);
            return dVar;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117553);
            throw gVar;
        }
    }

    public final c lv(String str) {
        AppMethodBeat.i(117554);
        JSONObject optJSONObject = this.eIz.optJSONObject(str);
        if (optJSONObject == null) {
            AppMethodBeat.o(117554);
            return null;
        }
        c dVar = new d(optJSONObject);
        AppMethodBeat.o(117554);
        return dVar;
    }

    public final Iterator<String> keys() {
        AppMethodBeat.i(117555);
        Iterator keys = this.eIz.keys();
        AppMethodBeat.o(117555);
        return keys;
    }

    public final String toString() {
        AppMethodBeat.i(117556);
        String jSONObject = this.eIz.toString();
        AppMethodBeat.o(117556);
        return jSONObject;
    }
}
