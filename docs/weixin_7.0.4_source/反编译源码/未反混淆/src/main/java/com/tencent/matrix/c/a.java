package com.tencent.matrix.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.d.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class a extends c {
    private final long bWr = 86400000;
    private final Editor bWs;
    private final HashMap<String, Long> bWt;
    private final SharedPreferences sharedPreferences;

    public a(Context context, String str, com.tencent.matrix.c.c.a aVar) {
        super(aVar);
        this.sharedPreferences = context.getSharedPreferences(str + d.aD(context), 0);
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

    public final void cf(String str) {
        if (str != null && !this.bWt.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            this.bWt.put(str, Long.valueOf(currentTimeMillis));
            this.bWs.putLong(str, currentTimeMillis).apply();
        }
    }

    public final boolean cg(String str) {
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
