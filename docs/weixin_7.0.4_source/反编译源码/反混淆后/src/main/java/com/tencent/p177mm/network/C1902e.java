package com.tencent.p177mm.network;

import com.tencent.p177mm.network.p265a.C1889b;
import com.tencent.p177mm.protocal.C4848y;
import java.util.List;

/* renamed from: com.tencent.mm.network.e */
public interface C1902e {
    /* renamed from: a */
    int mo5518a(C1930r c1930r, C1919l c1919l);

    /* renamed from: a */
    int mo5519a(String str, boolean z, List<String> list);

    /* renamed from: a */
    void mo5520a(int i, String str, int i2, boolean z);

    /* renamed from: a */
    void mo5521a(C1889b c1889b);

    /* renamed from: a */
    void mo5522a(C1909h c1909h);

    /* renamed from: a */
    void mo5523a(C1926o c1926o);

    /* renamed from: a */
    void mo5524a(C4848y c4848y);

    /* renamed from: a */
    void mo5525a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4);

    boolean acT();

    C1898c adg();

    C1912i adh();

    void adi();

    void adj();

    /* renamed from: cF */
    void mo5531cF(boolean z);

    /* renamed from: cG */
    void mo5532cG(boolean z);

    /* renamed from: cH */
    void mo5533cH(boolean z);

    /* renamed from: cI */
    void mo5534cI(boolean z);

    void cancel(int i);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void keepSignalling();

    /* renamed from: qs */
    void mo5541qs(String str);

    /* renamed from: qt */
    void mo5542qt(String str);

    void reportFailIp(String str);

    void reset();

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setSignallingStrategy(long j, long j2);

    void stopSignalling();
}
