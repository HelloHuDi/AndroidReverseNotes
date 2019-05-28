package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C32809i;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.a */
final class C10513a implements C37866a<Bundle, Bundle> {
    C10513a() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
        AppMethodBeat.m2504i(131437);
        Bundle bundle = (Bundle) obj;
        try {
            ((C32809i) C1720g.m3528K(C32809i.class)).mo22294d(bundle.getInt(NativeProtocol.WEB_DIALOG_ACTION), bundle);
            AppMethodBeat.m2505o(131437);
        } catch (Exception e) {
            AppMethodBeat.m2505o(131437);
        }
    }
}
