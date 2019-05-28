package com.tencent.mm.ipcinvoker.a;

import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.h.a.a;

public interface d {
    void a(a aVar);

    <T extends BaseIPCService> void a(String str, Class<T> cls);
}
