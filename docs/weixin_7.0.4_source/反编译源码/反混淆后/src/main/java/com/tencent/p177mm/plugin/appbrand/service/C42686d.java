package com.tencent.p177mm.plugin.appbrand.service;

import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.vending.p641g.C7582e;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.service.d */
public interface C42686d extends C1694a {

    /* renamed from: com.tencent.mm.plugin.appbrand.service.d$a */
    public interface C38509a {
        /* renamed from: d */
        void mo21701d(WxaAttributes wxaAttributes);
    }

    /* renamed from: a */
    void mo44615a(String str, C38509a c38509a);

    /* renamed from: aE */
    void mo44616aE(List<String> list);

    /* renamed from: b */
    void mo44617b(String str, C38509a c38509a);

    /* renamed from: zb */
    WxaAttributes mo44618zb(String str);

    /* renamed from: zc */
    WxaAttributes mo44619zc(String str);

    /* renamed from: zd */
    C7582e<WxaAttributes> mo44620zd(String str);
}
