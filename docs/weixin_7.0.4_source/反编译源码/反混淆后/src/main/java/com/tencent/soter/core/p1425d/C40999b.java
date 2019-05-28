package com.tencent.soter.core.p1425d;

import android.content.Context;
import android.util.Base64;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p1351c.C44478f;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Signature;

/* renamed from: com.tencent.soter.core.d.b */
public abstract class C40999b {
    public abstract C44478f atZ(String str);

    public abstract boolean aua(String str);

    public abstract boolean aub(String str);

    public abstract C30972i auc(String str);

    public abstract Signature aud(String str);

    /* renamed from: cn */
    public abstract C44478f mo64954cn(String str, boolean z);

    public abstract boolean dQN();

    public abstract C44478f dQO();

    public abstract C44478f dQP();

    public abstract boolean dQQ();

    public abstract boolean dQR();

    public abstract C30972i dQS();

    /* renamed from: iC */
    public abstract SoterSessionResult mo64959iC(String str, String str2);

    /* renamed from: iV */
    public abstract boolean mo64960iV(Context context);

    /* renamed from: nB */
    public abstract byte[] mo64961nB(long j);

    /* renamed from: cp */
    protected static C30972i m71103cp(byte[] bArr) {
        C30972i c30972i = null;
        if (bArr == null) {
            C44476d.m80483e("Soter.SoterCoreBase", "soter: raw data is null", new Object[0]);
        } else {
            int i;
            if (bArr.length < 4) {
                C44476d.m80483e("Soter.SoterCoreBase", "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
            }
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            int i2 = 0;
            for (i = 0; i < 4; i++) {
                i2 += (bArr2[i] & 255) << (i * 8);
            }
            C44476d.m80482d("Soter.SoterCoreBase", "soter: parsed raw length: ".concat(String.valueOf(i2)), new Object[0]);
            if (i2 > 1048576) {
                C44476d.m80483e("Soter.SoterCoreBase", "soter: too large json result!", new Object[0]);
            } else {
                byte[] bArr3 = new byte[i2];
                if (bArr.length < i2 + 4) {
                    C44476d.m80483e("Soter.SoterCoreBase", "length not correct 2", new Object[0]);
                } else {
                    System.arraycopy(bArr, 4, bArr3, 0, i2);
                    String str = new String(bArr3);
                    C44476d.m80482d("Soter.SoterCoreBase", "soter: to convert json: ".concat(String.valueOf(str)), new Object[0]);
                    c30972i = new C30972i(str, "");
                    i = bArr.length - (i2 + 4);
                    C44476d.m80482d("Soter.SoterCoreBase", "soter: signature length: ".concat(String.valueOf(i)), new Object[0]);
                    if (i != 0) {
                        bArr2 = new byte[i];
                        System.arraycopy(bArr, i2 + 4, bArr2, 0, i);
                        c30972i.signature = Base64.encodeToString(bArr2, 2);
                    }
                }
            }
        }
        return c30972i;
    }
}
