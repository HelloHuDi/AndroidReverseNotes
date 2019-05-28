package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

/* renamed from: com.tencent.smtt.sdk.bj */
class C30948bj {
    /* renamed from: a */
    protected DexLoader f13913a = null;

    public C30948bj(DexLoader dexLoader) {
        this.f13913a = dexLoader;
    }

    /* renamed from: a */
    public Object mo50068a(Context context) {
        AppMethodBeat.m2504i(64679);
        Object newInstance = this.f13913a.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, this.f13913a.getClassLoader());
        AppMethodBeat.m2505o(64679);
        return newInstance;
    }

    /* renamed from: a */
    public void mo50069a(Object obj) {
        AppMethodBeat.m2504i(64682);
        this.f13913a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(64682);
    }

    /* renamed from: a */
    public void mo50070a(Object obj, Activity activity, int i) {
        AppMethodBeat.m2504i(64681);
        Object obj2 = obj;
        this.f13913a.invokeMethod(obj2, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
        AppMethodBeat.m2505o(64681);
    }

    /* renamed from: a */
    public boolean mo50071a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        Object invokeMethod;
        AppMethodBeat.m2504i(64680);
        Object obj3;
        if (obj2 != null) {
            obj3 = obj;
            invokeMethod = this.f13913a.invokeMethod(obj3, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class, Object.class}, bundle, frameLayout, obj2);
        } else {
            obj3 = obj;
            invokeMethod = this.f13913a.invokeMethod(obj3, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        }
        if (invokeMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeMethod).booleanValue();
            AppMethodBeat.m2505o(64680);
            return booleanValue;
        }
        AppMethodBeat.m2505o(64680);
        return false;
    }
}
