package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class bg {
    private DexLoader a = null;

    public bg(DexLoader dexLoader) {
        this.a = dexLoader;
    }

    public String a(Context context) {
        String valueOf;
        AppMethodBeat.i(64632);
        if (this.a != null) {
            Object newInstance = this.a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
            if (newInstance != null) {
                Object invokeMethod = this.a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[]{Context.class}, context);
                if (invokeMethod != null) {
                    valueOf = String.valueOf(invokeMethod);
                    AppMethodBeat.o(64632);
                    return valueOf;
                }
            }
        }
        valueOf = "";
        AppMethodBeat.o(64632);
        return valueOf;
    }

    public void a(Context context, String str) {
        AppMethodBeat.i(64631);
        if (this.a != null) {
            Object newInstance = this.a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
            if (newInstance != null) {
                this.a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[]{Context.class, String.class}, context, str);
            }
        }
        AppMethodBeat.o(64631);
    }
}
