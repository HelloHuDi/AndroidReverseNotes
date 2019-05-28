package com.tencent.tencentmap.mapsdk.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.map.lib.util.StringUtil;

public abstract class s {
    protected SharedPreferences a = null;

    public boolean a(String str, String str2) {
        if (this.a == null) {
            return false;
        }
        return this.a.edit().putString(str, str2).commit();
    }

    public String a(String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.getString(str, null);
    }

    public boolean a(String str, int i) {
        if (this.a == null) {
            return false;
        }
        return this.a.edit().putInt(str, i).commit();
    }

    public int b(String str) {
        if (this.a == null) {
            return -1;
        }
        return this.a.getInt(str, -1);
    }

    public boolean a(String str, long j) {
        if (this.a == null) {
            return false;
        }
        return this.a.edit().putLong(str, j).commit();
    }

    public boolean a(String str, boolean z) {
        if (this.a == null) {
            return false;
        }
        return this.a.edit().putBoolean(str, z).commit();
    }

    public boolean c(String str) {
        if (this.a == null) {
            return false;
        }
        return this.a.getBoolean(str, false);
    }

    public boolean a(String[] strArr) {
        int i = 0;
        if (this.a == null) {
            return false;
        }
        Editor edit = this.a.edit();
        int length = strArr.length;
        while (i < length) {
            edit.remove(strArr[i]);
            i++;
        }
        return edit.commit();
    }

    public boolean a() {
        return a(new String[]{"mapConfigVersion", "poiIconVersion", "mapIconVersion", "rttConfigVersion", "mapConfigIndoorVersion", "mapPoiIconIndoorVersion", "closeRoadSytleNomalModeVersion", "closeRoadStyleTrafficModeVersion", "offlineCityListVersion", "mapConfigZipMd5", "mapPoiIconZipMd5", "mapIconZipMd5", "rttConfigMd5", "mapConfigIndoorMd5", "poiIconIndoorMd5", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeMd5", "offlineCityListMd5"});
    }

    public String b() {
        String str;
        String valueOf = String.valueOf(b("mapConfigVersion"));
        String a = a("mapConfigZipMd5");
        String valueOf2 = String.valueOf(b("mapConfigIndoorPremiumVersion"));
        String a2 = a("mapConfigIndoorPremiumMd5");
        String valueOf3 = String.valueOf(b("mapConfigIndoorVersion"));
        String a3 = a("mapConfigIndoorMd5");
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
