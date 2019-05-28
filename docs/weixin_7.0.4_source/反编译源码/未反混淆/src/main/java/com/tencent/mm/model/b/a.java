package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;

public abstract class a implements e {
    protected com.tencent.mm.model.b.e.a fod;
    protected String foe = aaM();
    protected String[] fof = aaL();

    public abstract String aaM();

    public final boolean oV(String str) {
        aw.ZK();
        SharedPreferences lK = c.lK("banner");
        if (lK == null || !lK.getBoolean(this.foe + str, false)) {
            return false;
        }
        return true;
    }

    public final void a(String str, boolean z, String[] strArr) {
        aw.ZK();
        SharedPreferences lK = c.lK("banner");
        if (lK != null) {
            lK.edit().putBoolean(this.foe + str, z).commit();
            if (!(this.fof == null || strArr == null || this.fof.length != strArr.length)) {
                int i = 0;
                for (String str2 : this.fof) {
                    if (str2 != null) {
                        lK.edit().putString(this.foe + str2 + str, strArr[i] != null ? strArr[i] : "").commit();
                    }
                    i++;
                }
            }
            if (this.fod != null) {
                this.fod.aaX();
            }
        }
    }

    public final String ao(String str, String str2) {
        aw.ZK();
        SharedPreferences lK = c.lK("banner");
        if (lK == null) {
            return null;
        }
        return lK.getString(this.foe + str2 + str, null);
    }

    public final void oW(String str) {
        aw.ZK();
        SharedPreferences lK = c.lK("banner");
        if (lK != null) {
            lK.edit().remove(this.foe + str).commit();
            if (this.fof != null) {
                for (String str2 : this.fof) {
                    if (str2 != null) {
                        lK.edit().remove(this.foe + str2 + str).commit();
                    }
                }
            }
            if (this.fod != null) {
                this.fod.aaY();
            }
        }
    }

    public final void a(com.tencent.mm.model.b.e.a aVar) {
        this.fod = aVar;
    }

    /* Access modifiers changed, original: protected */
    public String[] aaL() {
        return null;
    }
}
