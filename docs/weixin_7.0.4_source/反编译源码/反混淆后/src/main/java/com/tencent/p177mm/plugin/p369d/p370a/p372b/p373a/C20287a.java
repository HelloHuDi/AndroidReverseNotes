package com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a;

import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.Serializable;

/* renamed from: com.tencent.mm.plugin.d.a.b.a.a */
public abstract class C20287a implements Serializable {
    private static final String TAG = C20287a.class.getName();
    public long jGw;
    public String jHc;
    public int jHd;

    public abstract byte[] aVE();

    /* renamed from: at */
    public static C20287a m31370at(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            C4990ab.m7412e(TAG, "data input error");
            return null;
        }
        Object aQ = C42992b.m76352aQ(bArr);
        if (aQ != null && (aQ instanceof C20287a)) {
            return (C20287a) aQ;
        }
        C4990ab.m7412e(TAG, "bytes2object is not instanceof BaseProfileParser");
        return null;
    }
}
