package com.tencent.p177mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C19427b;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42740n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.b */
public abstract class C33640b {
    public C36743a jks;

    public abstract View aEK();

    /* renamed from: an */
    public final <T extends C19427b> T mo54197an(Class<T> cls) {
        C36743a ff = mo54198ff(true);
        this.jks = ff;
        if (ff == null) {
            return null;
        }
        try {
            ff.setPickerImpl((C19427b) cls.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{ff.getContext()}));
            return ff.getPicker();
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandBottomPickerInvokeHandler", "newInstance class[%s], exp[%s]", cls.getSimpleName(), e);
            return null;
        }
    }

    /* renamed from: ff */
    public final C36743a mo54198ff(boolean z) {
        if (this.jks != null) {
            return this.jks;
        }
        if (aEK() == null) {
            return null;
        }
        C42740n cG = C42740n.m75740cG(aEK());
        if (cG == null) {
            return null;
        }
        C36743a cV = C36743a.m60964cV(cG);
        if (cV != null || !z) {
            return cV;
        }
        cV = new C36743a(aEK().getContext());
        cG.mo68198n(cV, true);
        return cV;
    }
}
