package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.y;
import java.util.List;

public interface e {
    int a(r rVar, l lVar);

    int a(String str, boolean z, List<String> list);

    void a(int i, String str, int i2, boolean z);

    void a(b bVar);

    void a(h hVar);

    void a(o oVar);

    void a(y yVar);

    void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4);

    boolean acT();

    c adg();

    i adh();

    void adi();

    void adj();

    void cF(boolean z);

    void cG(boolean z);

    void cH(boolean z);

    void cI(boolean z);

    void cancel(int i);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void keepSignalling();

    void qs(String str);

    void qt(String str);

    void reportFailIp(String str);

    void reset();

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setSignallingStrategy(long j, long j2);

    void stopSignalling();
}
