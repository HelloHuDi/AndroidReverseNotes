package com.tencent.p177mm.loader.p248j;

import android.content.SharedPreferences;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.loader.j.c */
public class C1762c {
    public static C1762c eSp = new C1762c(null);
    protected final SharedPreferences ehZ;

    protected C1762c(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            this.ehZ = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
        } else {
            this.ehZ = sharedPreferences;
        }
    }

    /* renamed from: Un */
    public final SharedPreferences mo5293Un() {
        return this.ehZ;
    }

    /* renamed from: T */
    public final String mo5292T(String str, String str2) {
        return this.ehZ.getString(str, str2);
    }
}
