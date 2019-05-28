package com.tencent.tencentmap.mapsdk.p666a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.map.lib.util.StringUtil;

/* renamed from: com.tencent.tencentmap.mapsdk.a.s */
public abstract class C41027s {
    /* renamed from: a */
    protected SharedPreferences f16426a = null;

    /* renamed from: a */
    public boolean mo65084a(String str, String str2) {
        if (this.f16426a == null) {
            return false;
        }
        return this.f16426a.edit().putString(str, str2).commit();
    }

    /* renamed from: a */
    public String mo65080a(String str) {
        if (this.f16426a == null) {
            return null;
        }
        return this.f16426a.getString(str, null);
    }

    /* renamed from: a */
    public boolean mo65082a(String str, int i) {
        if (this.f16426a == null) {
            return false;
        }
        return this.f16426a.edit().putInt(str, i).commit();
    }

    /* renamed from: b */
    public int mo65087b(String str) {
        if (this.f16426a == null) {
            return -1;
        }
        return this.f16426a.getInt(str, -1);
    }

    /* renamed from: a */
    public boolean mo65083a(String str, long j) {
        if (this.f16426a == null) {
            return false;
        }
        return this.f16426a.edit().putLong(str, j).commit();
    }

    /* renamed from: a */
    public boolean mo65085a(String str, boolean z) {
        if (this.f16426a == null) {
            return false;
        }
        return this.f16426a.edit().putBoolean(str, z).commit();
    }

    /* renamed from: c */
    public boolean mo65089c(String str) {
        if (this.f16426a == null) {
            return false;
        }
        return this.f16426a.getBoolean(str, false);
    }

    /* renamed from: a */
    public boolean mo65086a(String[] strArr) {
        int i = 0;
        if (this.f16426a == null) {
            return false;
        }
        Editor edit = this.f16426a.edit();
        int length = strArr.length;
        while (i < length) {
            edit.remove(strArr[i]);
            i++;
        }
        return edit.commit();
    }

    /* renamed from: a */
    public boolean mo65081a() {
        return mo65086a(new String[]{"mapConfigVersion", "poiIconVersion", "mapIconVersion", "rttConfigVersion", "mapConfigIndoorVersion", "mapPoiIconIndoorVersion", "closeRoadSytleNomalModeVersion", "closeRoadStyleTrafficModeVersion", "offlineCityListVersion", "mapConfigZipMd5", "mapPoiIconZipMd5", "mapIconZipMd5", "rttConfigMd5", "mapConfigIndoorMd5", "poiIconIndoorMd5", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeMd5", "offlineCityListMd5"});
    }

    /* renamed from: b */
    public String mo65088b() {
        String str;
        String valueOf = String.valueOf(mo65087b("mapConfigVersion"));
        String a = mo65080a("mapConfigZipMd5");
        String valueOf2 = String.valueOf(mo65087b("mapConfigIndoorPremiumVersion"));
        String a2 = mo65080a("mapConfigIndoorPremiumMd5");
        String valueOf3 = String.valueOf(mo65087b("mapConfigIndoorVersion"));
        String a3 = mo65080a("mapConfigIndoorMd5");
        if (StringUtil.isEmpty(a2)) {
            str = "indoormap_config";
            a2 = a3;
            valueOf2 = valueOf3;
        } else {
            str = "indoormap_config_premium";
        }
        return String.format("mapconfig-%s-%s,%s-%s-%s", new Object[]{valueOf, a, str, valueOf2, a2});
    }
}
