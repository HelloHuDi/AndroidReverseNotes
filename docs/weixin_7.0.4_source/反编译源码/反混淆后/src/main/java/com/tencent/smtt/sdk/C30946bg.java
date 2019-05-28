package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

/* renamed from: com.tencent.smtt.sdk.bg */
class C30946bg {
    /* renamed from: a */
    private DexLoader f13905a = null;

    public C30946bg(DexLoader dexLoader) {
        this.f13905a = dexLoader;
    }

    /* renamed from: a */
    public String mo50061a(Context context) {
        String valueOf;
        AppMethodBeat.m2504i(64632);
        if (this.f13905a != null) {
            Object newInstance = this.f13905a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
            if (newInstance != null) {
                Object invokeMethod = this.f13905a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[]{Context.class}, context);
                if (invokeMethod != null) {
                    valueOf = String.valueOf(invokeMethod);
                    AppMethodBeat.m2505o(64632);
                    return valueOf;
                }
            }
        }
        valueOf = "";
        AppMethodBeat.m2505o(64632);
        return valueOf;
    }

    /* renamed from: a */
    public void mo50062a(Context context, String str) {
        AppMethodBeat.m2504i(64631);
        if (this.f13905a != null) {
            Object newInstance = this.f13905a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
            if (newInstance != null) {
                this.f13905a.invokeMethod(newInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[]{Context.class, String.class}, context, str);
            }
        }
        AppMethodBeat.m2505o(64631);
    }
}
