package com.tencent.mm.wallet_core.c;

import android.os.Bundle;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public abstract class u extends m implements k {
    public String eHT = "";
    public int gOW = 0;
    public long hbj = 0;
    private int lqy = 0;
    public Bundle mBundle;
    private long tRk;

    public abstract void e(int i, int i2, String str, q qVar);

    public int bLE() {
        return -1;
    }

    public final int a(e eVar, q qVar, k kVar) {
        this.tRk = System.currentTimeMillis();
        return super.a(eVar, qVar, kVar);
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis() - this.tRk;
        String str2 = "";
        String str3 = "";
        this.lqy = bLE();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.mBundle != null) {
            str2 = this.mBundle.getString("key_TransId");
            str3 = this.mBundle.getString("key_reqKey");
            if (this.hbj == 0) {
                this.hbj = this.mBundle.getLong("key_SessionId", 0);
            }
            if (this.gOW == 0) {
                this.gOW = this.mBundle.getInt("key_scene");
            }
        }
        h.pYm.e(11170, Integer.valueOf(getType()), Integer.valueOf(this.lqy), Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(at.getNetType(ah.getContext())), this.eHT, str2, str3, Long.valueOf(this.hbj), Long.valueOf(currentTimeMillis2));
        z.a(getType(), bLE(), i2, i3, currentTimeMillis, this.gOW, this.eHT);
        e(i2, i3, str, qVar);
    }
}
