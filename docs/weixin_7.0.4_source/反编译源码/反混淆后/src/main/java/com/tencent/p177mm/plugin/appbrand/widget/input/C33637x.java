package com.tencent.p177mm.plugin.appbrand.widget.input;

import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.C45663ac;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C16712e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.x */
public abstract class C33637x extends C19881i {
    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo35120a(C2577y c2577y, C16712e c16712e) {
        if (c2577y == null) {
            C4990ab.m7420w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
            return false;
        }
        int i = c16712e.jdk;
        if (this.jdV != null) {
            C44709u c44709u = (C44709u) this.jdV.get();
            if (c44709u != null) {
                C45663ac aBf = c44709u.aBf();
                if (aBf == null) {
                    C4990ab.m7421w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(i));
                    return false;
                }
                boolean z;
                int i2 = (c16712e.jjE == null || !c16712e.jjE.booleanValue()) ? 0 : 4;
                int i3 = c16712e.jji;
                float[] fArr = new float[]{(float) c16712e.jjs.intValue(), (float) c16712e.jjr.intValue(), (float) c16712e.jjp.intValue(), (float) c16712e.jjq.intValue(), 0.0f};
                if (c16712e.jjI == null || !c16712e.jjI.booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                C4990ab.m7417i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", Integer.valueOf(i), Boolean.valueOf(aBf.mo73443a(c2577y, i, i3, fArr, i2, z, false)));
                return aBf.mo73443a(c2577y, i, i3, fArr, i2, z, false);
            }
        }
        C4990ab.m7421w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", Integer.valueOf(i));
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo35127b(C2577y c2577y, C16712e c16712e) {
        if (c2577y == null) {
            C4990ab.m7420w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
            return false;
        }
        int inputId = c2577y.getInputId();
        if (this.jdV != null) {
            C44709u c44709u = (C44709u) this.jdV.get();
            if (c44709u != null) {
                C45663ac aBf = c44709u.aBf();
                if (aBf == null) {
                    C4990ab.m7421w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(inputId));
                    return false;
                }
                int i = (c16712e.jjE == null || !c16712e.jjE.booleanValue()) ? 0 : 4;
                C4990ab.m7417i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", Integer.valueOf(inputId), Boolean.valueOf(aBf.mo73442a(inputId, new float[]{(float) c16712e.jjs.intValue(), (float) c16712e.jjr.intValue(), (float) c16712e.jjp.intValue(), (float) c16712e.jjq.intValue(), 0.0f}, i, c16712e.jjI, Boolean.FALSE)));
                return aBf.mo73442a(inputId, new float[]{(float) c16712e.jjs.intValue(), (float) c16712e.jjr.intValue(), (float) c16712e.jjp.intValue(), (float) c16712e.jjq.intValue(), 0.0f}, i, c16712e.jjI, Boolean.FALSE);
            }
        }
        C4990ab.m7421w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", Integer.valueOf(inputId));
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo35119a(C2577y c2577y) {
        if (c2577y == null) {
            C4990ab.m7420w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
            return;
        }
        int inputId = c2577y.getInputId();
        c2577y.mo6581b(this.jdP);
        C44709u c44709u = this.jdV == null ? null : (C44709u) this.jdV.get();
        if (c44709u == null) {
            C4990ab.m7421w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", Integer.valueOf(inputId));
            return;
        }
        C45663ac aBf = c44709u.aBf();
        if (aBf == null) {
            C4990ab.m7421w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(inputId));
            return;
        }
        boolean pv = aBf.mo73450pv(inputId);
        C4990ab.m7417i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", Integer.valueOf(inputId), Boolean.valueOf(pv));
    }
}
