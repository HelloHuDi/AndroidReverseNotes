package com.tencent.p177mm.wallet_core.p649c;

import android.os.Bundle;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.wallet_core.c.u */
public abstract class C36378u extends C1207m implements C1918k {
    public String eHT = "";
    public int gOW = 0;
    public long hbj = 0;
    private int lqy = 0;
    public Bundle mBundle;
    private long tRk;

    /* renamed from: e */
    public abstract void mo9541e(int i, int i2, String str, C1929q c1929q);

    public int bLE() {
        return -1;
    }

    /* renamed from: a */
    public final int mo4457a(C1902e c1902e, C1929q c1929q, C1918k c1918k) {
        this.tRk = System.currentTimeMillis();
        return super.mo4457a(c1902e, c1929q, c1918k);
    }

    /* renamed from: a */
    public void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
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
        C7060h.pYm.mo8381e(11170, Integer.valueOf(getType()), Integer.valueOf(this.lqy), Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(C5023at.getNetType(C4996ah.getContext())), this.eHT, str2, str3, Long.valueOf(this.hbj), Long.valueOf(currentTimeMillis2));
        C36381z.m59952a(getType(), bLE(), i2, i3, currentTimeMillis, this.gOW, this.eHT);
        mo9541e(i2, i3, str, c1929q);
    }
}
