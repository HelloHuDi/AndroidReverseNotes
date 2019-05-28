package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Serializable;

public abstract class a implements Serializable {
    private static final String TAG = a.class.getName();
    public long jGw;
    public String jHc;
    public int jHd;

    public abstract byte[] aVE();

    public static a at(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            ab.e(TAG, "data input error");
            return null;
        }
        Object aQ = b.aQ(bArr);
        if (aQ != null && (aQ instanceof a)) {
            return (a) aQ;
        }
        ab.e(TAG, "bytes2object is not instanceof BaseProfileParser");
        return null;
    }
}
