package com.tencent.p177mm.p1174aa;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.aa.b */
public final class C17867b implements C41723a {
    private JSONArray eIy;

    public C17867b() {
        AppMethodBeat.m2504i(117484);
        this.eIy = new JSONArray();
        AppMethodBeat.m2505o(117484);
    }

    public C17867b(String str) {
        AppMethodBeat.m2504i(117485);
        try {
            this.eIy = new JSONArray(str);
            AppMethodBeat.m2505o(117485);
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117485);
            throw c41724g;
        }
    }

    C17867b(JSONArray jSONArray) {
        AppMethodBeat.m2504i(117486);
        Assert.assertNotNull(jSONArray);
        this.eIy = jSONArray;
        AppMethodBeat.m2505o(117486);
    }

    public final int length() {
        AppMethodBeat.m2504i(117487);
        int length = this.eIy.length();
        AppMethodBeat.m2505o(117487);
        return length;
    }

    /* renamed from: cj */
    public final C41723a mo33299cj(boolean z) {
        AppMethodBeat.m2504i(117488);
        this.eIy.put(z);
        AppMethodBeat.m2505o(117488);
        return this;
    }

    /* renamed from: o */
    public final C41723a mo33316o(double d) {
        AppMethodBeat.m2504i(117489);
        try {
            this.eIy.put(d);
            AppMethodBeat.m2505o(117489);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117489);
            throw c41724g;
        }
    }

    /* renamed from: jC */
    public final C41723a mo33310jC(int i) {
        AppMethodBeat.m2504i(117490);
        this.eIy.put(i);
        AppMethodBeat.m2505o(117490);
        return this;
    }

    /* renamed from: fb */
    public final C41723a mo33302fb(long j) {
        AppMethodBeat.m2504i(117491);
        this.eIy.put(j);
        AppMethodBeat.m2505o(117491);
        return this;
    }

    /* renamed from: av */
    public final C41723a mo33297av(Object obj) {
        AppMethodBeat.m2504i(117492);
        this.eIy.put(obj);
        AppMethodBeat.m2505o(117492);
        return this;
    }

    /* renamed from: z */
    public final C41723a mo33332z(int i, boolean z) {
        AppMethodBeat.m2504i(117493);
        try {
            this.eIy.put(i, z);
            AppMethodBeat.m2505o(117493);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117493);
            throw c41724g;
        }
    }

    /* renamed from: d */
    public final C41723a mo33300d(int i, double d) {
        AppMethodBeat.m2504i(117494);
        try {
            this.eIy.put(i, d);
            AppMethodBeat.m2505o(117494);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117494);
            throw c41724g;
        }
    }

    /* renamed from: cb */
    public final C41723a mo33298cb(int i, int i2) {
        AppMethodBeat.m2504i(117495);
        try {
            this.eIy.put(i, i2);
            AppMethodBeat.m2505o(117495);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117495);
            throw c41724g;
        }
    }

    /* renamed from: q */
    public final C41723a mo33328q(int i, long j) {
        AppMethodBeat.m2504i(117496);
        try {
            this.eIy.put(i, j);
            AppMethodBeat.m2505o(117496);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117496);
            throw c41724g;
        }
    }

    /* renamed from: d */
    public final C41723a mo33301d(int i, Object obj) {
        AppMethodBeat.m2504i(117497);
        try {
            this.eIy.put(i, obj);
            AppMethodBeat.m2505o(117497);
            return this;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117497);
            throw c41724g;
        }
    }

    public final boolean isNull(int i) {
        AppMethodBeat.m2504i(117498);
        boolean isNull = this.eIy.isNull(i);
        AppMethodBeat.m2505o(117498);
        return isNull;
    }

    public final Object get(int i) {
        AppMethodBeat.m2504i(117499);
        try {
            Object obj = this.eIy.get(i);
            if (obj instanceof JSONObject) {
                C24653d c24653d = new C24653d((JSONObject) obj);
                AppMethodBeat.m2505o(117499);
                return c24653d;
            } else if (obj instanceof JSONArray) {
                C17867b c17867b = new C17867b((JSONArray) obj);
                AppMethodBeat.m2505o(117499);
                return c17867b;
            } else {
                AppMethodBeat.m2505o(117499);
                return obj;
            }
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117499);
            throw c41724g;
        }
    }

    public final Object opt(int i) {
        AppMethodBeat.m2504i(117500);
        Object opt = this.eIy.opt(i);
        if (opt instanceof JSONObject) {
            C24653d c24653d = new C24653d((JSONObject) opt);
            AppMethodBeat.m2505o(117500);
            return c24653d;
        } else if (opt instanceof JSONArray) {
            C17867b c17867b = new C17867b((JSONArray) opt);
            AppMethodBeat.m2505o(117500);
            return c17867b;
        } else {
            AppMethodBeat.m2505o(117500);
            return opt;
        }
    }

    @TargetApi(19)
    public final Object remove(int i) {
        AppMethodBeat.m2504i(117501);
        Object remove = this.eIy.remove(i);
        if (remove instanceof JSONObject) {
            C24653d c24653d = new C24653d((JSONObject) remove);
            AppMethodBeat.m2505o(117501);
            return c24653d;
        } else if (remove instanceof JSONArray) {
            C17867b c17867b = new C17867b((JSONArray) remove);
            AppMethodBeat.m2505o(117501);
            return c17867b;
        } else {
            AppMethodBeat.m2505o(117501);
            return remove;
        }
    }

    public final boolean getBoolean(int i) {
        AppMethodBeat.m2504i(117502);
        try {
            boolean z = this.eIy.getBoolean(i);
            AppMethodBeat.m2505o(117502);
            return z;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117502);
            throw c41724g;
        }
    }

    public final boolean optBoolean(int i) {
        AppMethodBeat.m2504i(117503);
        boolean optBoolean = this.eIy.optBoolean(i);
        AppMethodBeat.m2505o(117503);
        return optBoolean;
    }

    public final boolean optBoolean(int i, boolean z) {
        AppMethodBeat.m2504i(117504);
        boolean optBoolean = this.eIy.optBoolean(i, z);
        AppMethodBeat.m2505o(117504);
        return optBoolean;
    }

    public final double getDouble(int i) {
        AppMethodBeat.m2504i(117505);
        try {
            double d = this.eIy.getDouble(i);
            AppMethodBeat.m2505o(117505);
            return d;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117505);
            throw c41724g;
        }
    }

    public final double optDouble(int i) {
        AppMethodBeat.m2504i(117506);
        double optDouble = this.eIy.optDouble(i);
        AppMethodBeat.m2505o(117506);
        return optDouble;
    }

    public final double optDouble(int i, double d) {
        AppMethodBeat.m2504i(117507);
        double optDouble = this.eIy.optDouble(i, d);
        AppMethodBeat.m2505o(117507);
        return optDouble;
    }

    public final int getInt(int i) {
        AppMethodBeat.m2504i(117508);
        try {
            int i2 = this.eIy.getInt(i);
            AppMethodBeat.m2505o(117508);
            return i2;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117508);
            throw c41724g;
        }
    }

    public final int optInt(int i) {
        AppMethodBeat.m2504i(117509);
        int optInt = this.eIy.optInt(i);
        AppMethodBeat.m2505o(117509);
        return optInt;
    }

    public final int optInt(int i, int i2) {
        AppMethodBeat.m2504i(117510);
        int optInt = this.eIy.optInt(i, i2);
        AppMethodBeat.m2505o(117510);
        return optInt;
    }

    public final long getLong(int i) {
        AppMethodBeat.m2504i(117511);
        try {
            long j = this.eIy.getLong(i);
            AppMethodBeat.m2505o(117511);
            return j;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117511);
            throw c41724g;
        }
    }

    public final long optLong(int i) {
        AppMethodBeat.m2504i(117512);
        long optLong = this.eIy.optLong(i);
        AppMethodBeat.m2505o(117512);
        return optLong;
    }

    public final long optLong(int i, long j) {
        AppMethodBeat.m2504i(117513);
        long optLong = this.eIy.optLong(i, j);
        AppMethodBeat.m2505o(117513);
        return optLong;
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(117514);
        try {
            String string = this.eIy.getString(i);
            AppMethodBeat.m2505o(117514);
            return string;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117514);
            throw c41724g;
        }
    }

    public final String optString(int i) {
        AppMethodBeat.m2504i(117515);
        String optString = this.eIy.optString(i);
        AppMethodBeat.m2505o(117515);
        return optString;
    }

    public final String optString(int i, String str) {
        AppMethodBeat.m2504i(117516);
        String optString = this.eIy.optString(i, str);
        AppMethodBeat.m2505o(117516);
        return optString;
    }

    /* renamed from: jD */
    public final C41723a mo33311jD(int i) {
        AppMethodBeat.m2504i(117517);
        try {
            JSONArray jSONArray = this.eIy.getJSONArray(i);
            if (jSONArray == null) {
                AppMethodBeat.m2505o(117517);
                return null;
            }
            C41723a c17867b = new C17867b(jSONArray);
            AppMethodBeat.m2505o(117517);
            return c17867b;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117517);
            throw c41724g;
        }
    }

    /* renamed from: jE */
    public final C41723a mo33312jE(int i) {
        AppMethodBeat.m2504i(117518);
        JSONArray optJSONArray = this.eIy.optJSONArray(i);
        if (optJSONArray == null) {
            AppMethodBeat.m2505o(117518);
            return null;
        }
        C41723a c17867b = new C17867b(optJSONArray);
        AppMethodBeat.m2505o(117518);
        return c17867b;
    }

    /* renamed from: jF */
    public final C17868c mo33313jF(int i) {
        AppMethodBeat.m2504i(117519);
        try {
            JSONObject jSONObject = this.eIy.getJSONObject(i);
            if (jSONObject == null) {
                AppMethodBeat.m2505o(117519);
                return null;
            }
            C17868c c24653d = new C24653d(jSONObject);
            AppMethodBeat.m2505o(117519);
            return c24653d;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117519);
            throw c41724g;
        }
    }

    /* renamed from: jG */
    public final C17868c mo33314jG(int i) {
        AppMethodBeat.m2504i(117520);
        JSONObject optJSONObject = this.eIy.optJSONObject(i);
        if (optJSONObject == null) {
            AppMethodBeat.m2505o(117520);
            return null;
        }
        C17868c c24653d = new C24653d(optJSONObject);
        AppMethodBeat.m2505o(117520);
        return c24653d;
    }

    public final String toString() {
        AppMethodBeat.m2504i(117521);
        String jSONArray = this.eIy.toString();
        AppMethodBeat.m2505o(117521);
        return jSONArray;
    }

    public final String toString(int i) {
        AppMethodBeat.m2504i(117522);
        try {
            String jSONArray = this.eIy.toString(i);
            AppMethodBeat.m2505o(117522);
            return jSONArray;
        } catch (JSONException e) {
            C41724g c41724g = new C41724g(e);
            AppMethodBeat.m2505o(117522);
            throw c41724g;
        }
    }
}
