package com.tencent.p177mm.plugin.welab.p1563e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p711c.C32685cq;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C14715d;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C29973b;
import com.tencent.p177mm.sdk.p600b.C4879a;

/* renamed from: com.tencent.mm.plugin.welab.e.a */
public final class C40362a implements C29973b {
    /* renamed from: f */
    public final void mo9766f(Activity activity, String str) {
        AppMethodBeat.m2504i(26582);
        C32685cq agJ = ((C14715d) C1720g.m3528K(C14715d.class)).agJ(str);
        C32628se c32628se = new C32628se();
        c32628se.cOf.userName = agJ.field_WeAppUser;
        c32628se.cOf.cOh = agJ.field_WeAppPath;
        c32628se.cOf.scene = 1051;
        c32628se.cOf.cOi = agJ.field_WeAppDebugMode;
        c32628se.cOf.cst = String.format("%s:%s:%s:%s", new Object[]{(String) C1720g.m3536RP().mo5239Ry().get(2, null), agJ.field_expId, agJ.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000)});
        C4879a.xxA.mo10055m(c32628se);
        AppMethodBeat.m2505o(26582);
    }

    public final String ddq() {
        return null;
    }

    public final String ddr() {
        return null;
    }
}
