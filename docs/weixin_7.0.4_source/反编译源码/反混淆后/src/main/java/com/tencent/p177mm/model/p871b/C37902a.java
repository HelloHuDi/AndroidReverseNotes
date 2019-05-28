package com.tencent.p177mm.model.p871b;

import android.content.SharedPreferences;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p871b.C18613e.C18614a;

/* renamed from: com.tencent.mm.model.b.a */
public abstract class C37902a implements C18613e {
    protected C18614a fod;
    protected String foe = aaM();
    protected String[] fof = aaL();

    public abstract String aaM();

    /* renamed from: oV */
    public final boolean mo60659oV(String str) {
        C9638aw.m17190ZK();
        SharedPreferences lK = C18628c.m29106lK("banner");
        if (lK == null || !lK.getBoolean(this.foe + str, false)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final void mo60657a(String str, boolean z, String[] strArr) {
        C9638aw.m17190ZK();
        SharedPreferences lK = C18628c.m29106lK("banner");
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

    /* renamed from: ao */
    public final String mo60658ao(String str, String str2) {
        C9638aw.m17190ZK();
        SharedPreferences lK = C18628c.m29106lK("banner");
        if (lK == null) {
            return null;
        }
        return lK.getString(this.foe + str2 + str, null);
    }

    /* renamed from: oW */
    public final void mo60660oW(String str) {
        C9638aw.m17190ZK();
        SharedPreferences lK = C18628c.m29106lK("banner");
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

    /* renamed from: a */
    public final void mo60656a(C18614a c18614a) {
        this.fod = c18614a;
    }

    /* Access modifiers changed, original: protected */
    public String[] aaL() {
        return null;
    }
}
