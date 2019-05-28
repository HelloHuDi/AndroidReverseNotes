package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b */
public abstract class C10332b {
    private String hvI;

    public C10332b() {
        Assert.assertTrue("Must declare NAME in subclasses", true);
    }

    public final String getName() {
        if (C5046bo.isNullOrNil(this.hvI)) {
            try {
                this.hvI = (String) new C1438c(this, "NAME", null).get();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", C5046bo.m7574l(e));
            }
        }
        return this.hvI;
    }
}
