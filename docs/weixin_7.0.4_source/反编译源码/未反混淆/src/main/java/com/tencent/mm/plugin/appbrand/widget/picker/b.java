package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class b {
    public a jks;

    public abstract View aEK();

    public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m.b> T an(Class<T> cls) {
        a ff = ff(true);
        this.jks = ff;
        if (ff == null) {
            return null;
        }
        try {
            ff.setPickerImpl((com.tencent.mm.plugin.appbrand.jsapi.m.b) cls.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{ff.getContext()}));
            return ff.getPicker();
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandBottomPickerInvokeHandler", "newInstance class[%s], exp[%s]", cls.getSimpleName(), e);
            return null;
        }
    }

    public final a ff(boolean z) {
        if (this.jks != null) {
            return this.jks;
        }
        if (aEK() == null) {
            return null;
        }
        n cG = n.cG(aEK());
        if (cG == null) {
            return null;
        }
        a cV = a.cV(cG);
        if (cV != null || !z) {
            return cV;
        }
        cV = new a(aEK().getContext());
        cG.n(cV, true);
        return cV;
    }
}
