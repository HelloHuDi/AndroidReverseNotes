package com.tencent.mm.plugin.appbrand.canvas.action.arg.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.sdk.c;
import java.util.HashMap;
import java.util.Map;

public abstract class a<T> {
    private Map<String, c> map = new HashMap();

    public abstract <T> T yA(String str);

    public final <T extends BaseDrawActionArg> T yy(String str) {
        BaseDrawActionArg baseDrawActionArg = (BaseDrawActionArg) yz(str).aA();
        if (baseDrawActionArg == null) {
            return (BaseDrawActionArg) yA(str);
        }
        return baseDrawActionArg;
    }

    public final void a(BaseDrawActionArg baseDrawActionArg) {
        if (baseDrawActionArg != null) {
            if (TextUtils.isEmpty(baseDrawActionArg.method)) {
                throw new IllegalStateException("method is empty " + baseDrawActionArg.toString());
            }
            yz(baseDrawActionArg.method).release(baseDrawActionArg);
        }
    }

    private c yz(String str) {
        c cVar = (c) this.map.get(str);
        if (cVar != null) {
            return cVar;
        }
        cVar = new c(500);
        this.map.put(str, cVar);
        return cVar;
    }
}
