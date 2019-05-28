package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class x extends i {
    /* Access modifiers changed, original: final */
    public final boolean a(y yVar, e eVar) {
        if (yVar == null) {
            ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
            return false;
        }
        int i = eVar.jdk;
        if (this.jdV != null) {
            u uVar = (u) this.jdV.get();
            if (uVar != null) {
                ac aBf = uVar.aBf();
                if (aBf == null) {
                    ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(i));
                    return false;
                }
                boolean z;
                int i2 = (eVar.jjE == null || !eVar.jjE.booleanValue()) ? 0 : 4;
                int i3 = eVar.jji;
                float[] fArr = new float[]{(float) eVar.jjs.intValue(), (float) eVar.jjr.intValue(), (float) eVar.jjp.intValue(), (float) eVar.jjq.intValue(), 0.0f};
                if (eVar.jjI == null || !eVar.jjI.booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                ab.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", Integer.valueOf(i), Boolean.valueOf(aBf.a(yVar, i, i3, fArr, i2, z, false)));
                return aBf.a(yVar, i, i3, fArr, i2, z, false);
            }
        }
        ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", Integer.valueOf(i));
        return false;
    }

    /* Access modifiers changed, original: final */
    public final boolean b(y yVar, e eVar) {
        if (yVar == null) {
            ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
            return false;
        }
        int inputId = yVar.getInputId();
        if (this.jdV != null) {
            u uVar = (u) this.jdV.get();
            if (uVar != null) {
                ac aBf = uVar.aBf();
                if (aBf == null) {
                    ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(inputId));
                    return false;
                }
                int i = (eVar.jjE == null || !eVar.jjE.booleanValue()) ? 0 : 4;
                ab.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", Integer.valueOf(inputId), Boolean.valueOf(aBf.a(inputId, new float[]{(float) eVar.jjs.intValue(), (float) eVar.jjr.intValue(), (float) eVar.jjp.intValue(), (float) eVar.jjq.intValue(), 0.0f}, i, eVar.jjI, Boolean.FALSE)));
                return aBf.a(inputId, new float[]{(float) eVar.jjs.intValue(), (float) eVar.jjr.intValue(), (float) eVar.jjp.intValue(), (float) eVar.jjq.intValue(), 0.0f}, i, eVar.jjI, Boolean.FALSE);
            }
        }
        ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", Integer.valueOf(inputId));
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void a(y yVar) {
        if (yVar == null) {
            ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
            return;
        }
        int inputId = yVar.getInputId();
        yVar.b(this.jdP);
        u uVar = this.jdV == null ? null : (u) this.jdV.get();
        if (uVar == null) {
            ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", Integer.valueOf(inputId));
            return;
        }
        ac aBf = uVar.aBf();
        if (aBf == null) {
            ab.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", Integer.valueOf(inputId));
            return;
        }
        boolean pv = aBf.pv(inputId);
        ab.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", Integer.valueOf(inputId), Boolean.valueOf(pv));
    }
}
