package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

class bj {
    protected DexLoader a = null;

    public bj(DexLoader dexLoader) {
        this.a = dexLoader;
    }

    public Object a(Context context) {
        AppMethodBeat.i(64679);
        Object newInstance = this.a.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, this.a.getClassLoader());
        AppMethodBeat.o(64679);
        return newInstance;
    }

    public void a(Object obj) {
        AppMethodBeat.i(64682);
        this.a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
        AppMethodBeat.o(64682);
    }

    public void a(Object obj, Activity activity, int i) {
        AppMethodBeat.i(64681);
        Object obj2 = obj;
        this.a.invokeMethod(obj2, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
        AppMethodBeat.o(64681);
    }

    public boolean a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        Object invokeMethod;
        AppMethodBeat.i(64680);
        Object obj3;
        if (obj2 != null) {
            obj3 = obj;
            invokeMethod = this.a.invokeMethod(obj3, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class, Object.class}, bundle, frameLayout, obj2);
        } else {
            obj3 = obj;
            invokeMethod = this.a.invokeMethod(obj3, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        }
        if (invokeMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeMethod).booleanValue();
            AppMethodBeat.o(64680);
            return booleanValue;
        }
        AppMethodBeat.o(64680);
        return false;
    }
}
