package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.vending.g.e;
import java.util.List;

public interface d extends com.tencent.mm.kernel.c.a {

    public interface a {
        void d(WxaAttributes wxaAttributes);
    }

    void a(String str, a aVar);

    void aE(List<String> list);

    void b(String str, a aVar);

    WxaAttributes zb(String str);

    WxaAttributes zc(String str);

    e<WxaAttributes> zd(String str);
}
