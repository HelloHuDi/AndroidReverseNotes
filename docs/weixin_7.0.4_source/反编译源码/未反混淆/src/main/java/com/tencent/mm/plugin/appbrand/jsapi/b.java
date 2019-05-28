package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public abstract class b {
    private String hvI;

    public b() {
        Assert.assertTrue("Must declare NAME in subclasses", true);
    }

    public final String getName() {
        if (bo.isNullOrNil(this.hvI)) {
            try {
                this.hvI = (String) new c(this, "NAME", null).get();
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", bo.l(e));
            }
        }
        return this.hvI;
    }
}
