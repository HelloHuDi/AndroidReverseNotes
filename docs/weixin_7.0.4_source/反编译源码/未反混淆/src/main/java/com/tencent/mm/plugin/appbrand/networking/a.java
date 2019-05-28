package com.tencent.mm.plugin.appbrand.networking;

import com.tencent.luggage.a.b;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.vending.g.c;

public interface a extends b {
    <Resp extends btd> c<Resp> a(String str, com.tencent.mm.bt.a aVar, Class<Resp> cls);
}
