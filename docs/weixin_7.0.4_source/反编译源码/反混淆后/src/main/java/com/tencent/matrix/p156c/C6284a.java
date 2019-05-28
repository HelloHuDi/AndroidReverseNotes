package com.tencent.matrix.p156c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.p156c.C1064c.C1063a;
import com.tencent.matrix.p157d.C1073d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.matrix.c.a */
public class C6284a extends C1064c {
    private final long bWr = 86400000;
    private final Editor bWs;
    private final HashMap<String, Long> bWt;
    private final SharedPreferences sharedPreferences;

    public C6284a(Context context, String str, C1063a c1063a) {
        super(c1063a);
        this.sharedPreferences = context.getSharedPreferences(str + C1073d.m2377aD(context), 0);
        this.bWt = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        this.bWs = this.sharedPreferences.edit();
        Iterator it = new HashSet(this.sharedPreferences.getAll().keySet()).iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            long j = this.sharedPreferences.getLong(str2, 0);
            long j2 = currentTimeMillis - j;
            if (j <= 0 || j2 > this.bWr) {
                this.bWs.remove(str2);
            } else {
                this.bWt.put(str2, Long.valueOf(j));
            }
        }
        this.bWs.apply();
    }

    /* renamed from: cf */
    public final void mo4201cf(String str) {
        if (str != null && !this.bWt.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bWt.put(str, Long.valueOf(currentTimeMillis));
            this.bWs.putLong(str, currentTimeMillis).apply();
        }
    }

    /* renamed from: cg */
    public final boolean mo4202cg(String str) {
        if (!this.bWt.containsKey(str)) {
            return false;
        }
        long longValue = ((Long) this.bWt.get(str)).longValue();
        if (longValue > 0 && System.currentTimeMillis() - longValue <= this.bWr) {
            return true;
        }
        this.bWs.remove(str).apply();
        this.bWt.remove(str);
        return false;
    }
}
