package com.tencent.mm.aa;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements a {
    private JSONArray eIy;

    public b() {
        AppMethodBeat.i(117484);
        this.eIy = new JSONArray();
        AppMethodBeat.o(117484);
    }

    public b(String str) {
        AppMethodBeat.i(117485);
        try {
            this.eIy = new JSONArray(str);
            AppMethodBeat.o(117485);
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117485);
            throw gVar;
        }
    }

    b(JSONArray jSONArray) {
        AppMethodBeat.i(117486);
        Assert.assertNotNull(jSONArray);
        this.eIy = jSONArray;
        AppMethodBeat.o(117486);
    }

    public final int length() {
        AppMethodBeat.i(117487);
        int length = this.eIy.length();
        AppMethodBeat.o(117487);
        return length;
    }

    public final a cj(boolean z) {
        AppMethodBeat.i(117488);
        this.eIy.put(z);
        AppMethodBeat.o(117488);
        return this;
    }

    public final a o(double d) {
        AppMethodBeat.i(117489);
        try {
            this.eIy.put(d);
            AppMethodBeat.o(117489);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117489);
            throw gVar;
        }
    }

    public final a jC(int i) {
        AppMethodBeat.i(117490);
        this.eIy.put(i);
        AppMethodBeat.o(117490);
        return this;
    }

    public final a fb(long j) {
        AppMethodBeat.i(117491);
        this.eIy.put(j);
        AppMethodBeat.o(117491);
        return this;
    }

    public final a av(Object obj) {
        AppMethodBeat.i(117492);
        this.eIy.put(obj);
        AppMethodBeat.o(117492);
        return this;
    }

    public final a z(int i, boolean z) {
        AppMethodBeat.i(117493);
        try {
            this.eIy.put(i, z);
            AppMethodBeat.o(117493);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117493);
            throw gVar;
        }
    }

    public final a d(int i, double d) {
        AppMethodBeat.i(117494);
        try {
            this.eIy.put(i, d);
            AppMethodBeat.o(117494);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117494);
            throw gVar;
        }
    }

    public final a cb(int i, int i2) {
        AppMethodBeat.i(117495);
        try {
            this.eIy.put(i, i2);
            AppMethodBeat.o(117495);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117495);
            throw gVar;
        }
    }

    public final a q(int i, long j) {
        AppMethodBeat.i(117496);
        try {
            this.eIy.put(i, j);
            AppMethodBeat.o(117496);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117496);
            throw gVar;
        }
    }

    public final a d(int i, Object obj) {
        AppMethodBeat.i(117497);
        try {
            this.eIy.put(i, obj);
            AppMethodBeat.o(117497);
            return this;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117497);
            throw gVar;
        }
    }

    public final boolean isNull(int i) {
        AppMethodBeat.i(117498);
        boolean isNull = this.eIy.isNull(i);
        AppMethodBeat.o(117498);
        return isNull;
    }

    public final Object get(int i) {
        AppMethodBeat.i(117499);
        try {
            Object obj = this.eIy.get(i);
            if (obj instanceof JSONObject) {
                d dVar = new d((JSONObject) obj);
                AppMethodBeat.o(117499);
                return dVar;
            } else if (obj instanceof JSONArray) {
                b bVar = new b((JSONArray) obj);
                AppMethodBeat.o(117499);
                return bVar;
            } else {
                AppMethodBeat.o(117499);
                return obj;
            }
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117499);
            throw gVar;
        }
    }

    public final Object opt(int i) {
        AppMethodBeat.i(117500);
        Object opt = this.eIy.opt(i);
        if (opt instanceof JSONObject) {
            d dVar = new d((JSONObject) opt);
            AppMethodBeat.o(117500);
            return dVar;
        } else if (opt instanceof JSONArray) {
            b bVar = new b((JSONArray) opt);
            AppMethodBeat.o(117500);
            return bVar;
        } else {
            AppMethodBeat.o(117500);
            return opt;
        }
    }

    @TargetApi(19)
    public final Object remove(int i) {
        AppMethodBeat.i(117501);
        Object remove = this.eIy.remove(i);
        if (remove instanceof JSONObject) {
            d dVar = new d((JSONObject) remove);
            AppMethodBeat.o(117501);
            return dVar;
        } else if (remove instanceof JSONArray) {
            b bVar = new b((JSONArray) remove);
            AppMethodBeat.o(117501);
            return bVar;
        } else {
            AppMethodBeat.o(117501);
            return remove;
        }
    }

    public final boolean getBoolean(int i) {
        AppMethodBeat.i(117502);
        try {
            boolean z = this.eIy.getBoolean(i);
            AppMethodBeat.o(117502);
            return z;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117502);
            throw gVar;
        }
    }

    public final boolean optBoolean(int i) {
        AppMethodBeat.i(117503);
        boolean optBoolean = this.eIy.optBoolean(i);
        AppMethodBeat.o(117503);
        return optBoolean;
    }

    public final boolean optBoolean(int i, boolean z) {
        AppMethodBeat.i(117504);
        boolean optBoolean = this.eIy.optBoolean(i, z);
        AppMethodBeat.o(117504);
        return optBoolean;
    }

    public final double getDouble(int i) {
        AppMethodBeat.i(117505);
        try {
            double d = this.eIy.getDouble(i);
            AppMethodBeat.o(117505);
            return d;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117505);
            throw gVar;
        }
    }

    public final double optDouble(int i) {
        AppMethodBeat.i(117506);
        double optDouble = this.eIy.optDouble(i);
        AppMethodBeat.o(117506);
        return optDouble;
    }

    public final double optDouble(int i, double d) {
        AppMethodBeat.i(117507);
        double optDouble = this.eIy.optDouble(i, d);
        AppMethodBeat.o(117507);
        return optDouble;
    }

    public final int getInt(int i) {
        AppMethodBeat.i(117508);
        try {
            int i2 = this.eIy.getInt(i);
            AppMethodBeat.o(117508);
            return i2;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117508);
            throw gVar;
        }
    }

    public final int optInt(int i) {
        AppMethodBeat.i(117509);
        int optInt = this.eIy.optInt(i);
        AppMethodBeat.o(117509);
        return optInt;
    }

    public final int optInt(int i, int i2) {
        AppMethodBeat.i(117510);
        int optInt = this.eIy.optInt(i, i2);
        AppMethodBeat.o(117510);
        return optInt;
    }

    public final long getLong(int i) {
        AppMethodBeat.i(117511);
        try {
            long j = this.eIy.getLong(i);
            AppMethodBeat.o(117511);
            return j;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117511);
            throw gVar;
        }
    }

    public final long optLong(int i) {
        AppMethodBeat.i(117512);
        long optLong = this.eIy.optLong(i);
        AppMethodBeat.o(117512);
        return optLong;
    }

    public final long optLong(int i, long j) {
        AppMethodBeat.i(117513);
        long optLong = this.eIy.optLong(i, j);
        AppMethodBeat.o(117513);
        return optLong;
    }

    public final String getString(int i) {
        AppMethodBeat.i(117514);
        try {
            String string = this.eIy.getString(i);
            AppMethodBeat.o(117514);
            return string;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117514);
            throw gVar;
        }
    }

    public final String optString(int i) {
        AppMethodBeat.i(117515);
        String optString = this.eIy.optString(i);
        AppMethodBeat.o(117515);
        return optString;
    }

    public final String optString(int i, String str) {
        AppMethodBeat.i(117516);
        String optString = this.eIy.optString(i, str);
        AppMethodBeat.o(117516);
        return optString;
    }

    public final a jD(int i) {
        AppMethodBeat.i(117517);
        try {
            JSONArray jSONArray = this.eIy.getJSONArray(i);
            if (jSONArray == null) {
                AppMethodBeat.o(117517);
                return null;
            }
            a bVar = new b(jSONArray);
            AppMethodBeat.o(117517);
            return bVar;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117517);
            throw gVar;
        }
    }

    public final a jE(int i) {
        AppMethodBeat.i(117518);
        JSONArray optJSONArray = this.eIy.optJSONArray(i);
        if (optJSONArray == null) {
            AppMethodBeat.o(117518);
            return null;
        }
        a bVar = new b(optJSONArray);
        AppMethodBeat.o(117518);
        return bVar;
    }

    public final c jF(int i) {
        AppMethodBeat.i(117519);
        try {
            JSONObject jSONObject = this.eIy.getJSONObject(i);
            if (jSONObject == null) {
                AppMethodBeat.o(117519);
                return null;
            }
            c dVar = new d(jSONObject);
            AppMethodBeat.o(117519);
            return dVar;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117519);
            throw gVar;
        }
    }

    public final c jG(int i) {
        AppMethodBeat.i(117520);
        JSONObject optJSONObject = this.eIy.optJSONObject(i);
        if (optJSONObject == null) {
            AppMethodBeat.o(117520);
            return null;
        }
        c dVar = new d(optJSONObject);
        AppMethodBeat.o(117520);
        return dVar;
    }

    public final String toString() {
        AppMethodBeat.i(117521);
        String jSONArray = this.eIy.toString();
        AppMethodBeat.o(117521);
        return jSONArray;
    }

    public final String toString(int i) {
        AppMethodBeat.i(117522);
        try {
            String jSONArray = this.eIy.toString(i);
            AppMethodBeat.o(117522);
            return jSONArray;
        } catch (JSONException e) {
            g gVar = new g(e);
            AppMethodBeat.o(117522);
            throw gVar;
        }
    }
}
