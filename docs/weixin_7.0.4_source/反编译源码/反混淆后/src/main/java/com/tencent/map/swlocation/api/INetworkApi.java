package com.tencent.map.swlocation.api;

import com.p081b.p082a.p083a.C31915q;

public interface INetworkApi extends C31915q {
    @Deprecated
    byte[] httpRequest(String str, byte[] bArr);

    byte[] httpRequest(byte[] bArr);
}
