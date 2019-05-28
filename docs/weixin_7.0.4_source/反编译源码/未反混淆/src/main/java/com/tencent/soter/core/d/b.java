package com.tencent.soter.core.d;

import android.content.Context;
import android.util.Base64;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Signature;

public abstract class b {
    public abstract f atZ(String str);

    public abstract boolean aua(String str);

    public abstract boolean aub(String str);

    public abstract i auc(String str);

    public abstract Signature aud(String str);

    public abstract f cn(String str, boolean z);

    public abstract boolean dQN();

    public abstract f dQO();

    public abstract f dQP();

    public abstract boolean dQQ();

    public abstract boolean dQR();

    public abstract i dQS();

    public abstract SoterSessionResult iC(String str, String str2);

    public abstract boolean iV(Context context);

    public abstract byte[] nB(long j);

    protected static i cp(byte[] bArr) {
        i iVar = null;
        if (bArr == null) {
            d.e("Soter.SoterCoreBase", "soter: raw data is null", new Object[0]);
        } else {
            int i;
            if (bArr.length < 4) {
                d.e("Soter.SoterCoreBase", "soter: raw data length smaller than RAW_LENGTH_PREFIX", new Object[0]);
            }
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            int i2 = 0;
            for (i = 0; i < 4; i++) {
                i2 += (bArr2[i] & 255) << (i * 8);
            }
            d.d("Soter.SoterCoreBase", "soter: parsed raw length: ".concat(String.valueOf(i2)), new Object[0]);
            if (i2 > 1048576) {
                d.e("Soter.SoterCoreBase", "soter: too large json result!", new Object[0]);
            } else {
                byte[] bArr3 = new byte[i2];
                if (bArr.length < i2 + 4) {
                    d.e("Soter.SoterCoreBase", "length not correct 2", new Object[0]);
                } else {
                    System.arraycopy(bArr, 4, bArr3, 0, i2);
                    String str = new String(bArr3);
                    d.d("Soter.SoterCoreBase", "soter: to convert json: ".concat(String.valueOf(str)), new Object[0]);
                    iVar = new i(str, "");
                    i = bArr.length - (i2 + 4);
                    d.d("Soter.SoterCoreBase", "soter: signature length: ".concat(String.valueOf(i)), new Object[0]);
                    if (i != 0) {
                        bArr2 = new byte[i];
                        System.arraycopy(bArr, i2 + 4, bArr2, 0, i);
                        iVar.signature = Base64.encodeToString(bArr2, 2);
                    }
                }
            }
        }
        return iVar;
    }
}
