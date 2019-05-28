package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a;

import android.text.TextUtils;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.sdk.C40611c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.a.a */
public abstract class C2098a<T> {
    private Map<String, C40611c> map = new HashMap();

    /* renamed from: yA */
    public abstract <T> T mo5898yA(String str);

    /* renamed from: yy */
    public final <T extends BaseDrawActionArg> T mo5899yy(String str) {
        BaseDrawActionArg baseDrawActionArg = (BaseDrawActionArg) m4293yz(str).mo56734aA();
        if (baseDrawActionArg == null) {
            return (BaseDrawActionArg) mo5898yA(str);
        }
        return baseDrawActionArg;
    }

    /* renamed from: a */
    public final void mo5897a(BaseDrawActionArg baseDrawActionArg) {
        if (baseDrawActionArg != null) {
            if (TextUtils.isEmpty(baseDrawActionArg.method)) {
                throw new IllegalStateException("method is empty " + baseDrawActionArg.toString());
            }
            m4293yz(baseDrawActionArg.method).release(baseDrawActionArg);
        }
    }

    /* renamed from: yz */
    private C40611c m4293yz(String str) {
        C40611c c40611c = (C40611c) this.map.get(str);
        if (c40611c != null) {
            return c40611c;
        }
        c40611c = new C40611c(500);
        this.map.put(str, c40611c);
        return c40611c;
    }
}
