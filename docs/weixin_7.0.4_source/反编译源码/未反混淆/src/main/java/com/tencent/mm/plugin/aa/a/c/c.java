package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class c extends com.tencent.mm.vending.app.a {

    public class a {
        public List<String> ewK;
    }

    public final void onCreate() {
        AppMethodBeat.i(40682);
        super.onCreate();
        a(a.class, (com.tencent.mm.vending.app.a.a) new com.tencent.mm.vending.app.a.a<a>() {
            public final /* synthetic */ Object aoq() {
                AppMethodBeat.i(40681);
                a a = c.a(c.this);
                AppMethodBeat.o(40681);
                return a;
            }
        });
        AppMethodBeat.o(40682);
    }

    static /* synthetic */ a a(c cVar) {
        AppMethodBeat.i(40683);
        String stringExtra = cVar.zXe.getStringExtra("chatroom");
        if (bo.isNullOrNil(stringExtra)) {
            AppMethodBeat.o(40683);
            return null;
        }
        a aVar = new a();
        aVar.ewK = h.vE(stringExtra);
        if (aVar.ewK != null && aVar.ewK.size() > 0) {
            aVar.ewK.remove(r.Yz());
        }
        AppMethodBeat.o(40683);
        return aVar;
    }
}
