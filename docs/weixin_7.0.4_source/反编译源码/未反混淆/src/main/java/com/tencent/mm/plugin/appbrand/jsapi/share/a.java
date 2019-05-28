package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;

final class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
    a() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        AppMethodBeat.i(131437);
        Bundle bundle = (Bundle) obj;
        try {
            ((i) g.K(i.class)).d(bundle.getInt(NativeProtocol.WEB_DIALOG_ACTION), bundle);
            AppMethodBeat.o(131437);
        } catch (Exception e) {
            AppMethodBeat.o(131437);
        }
    }
}
