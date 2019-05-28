package com.tencent.mm.loader.j;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ah;

public class c {
    public static c eSp = new c(null);
    protected final SharedPreferences ehZ;

    protected c(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            this.ehZ = ah.getContext().getSharedPreferences(ah.doA(), 0);
        } else {
            this.ehZ = sharedPreferences;
        }
    }

    public final SharedPreferences Un() {
        return this.ehZ;
    }

    public final String T(String str, String str2) {
        return this.ehZ.getString(str, str2);
    }
}
