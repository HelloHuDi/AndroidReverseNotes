package com.tencent.mm.plugin.websearch.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.vending.c.a;
import java.lang.ref.WeakReference;
import org.xwalk.core.Log;

public final class b implements e {
    public final void a(final String str, d dVar, com.tencent.mm.vending.e.b bVar) {
        AppMethodBeat.i(91365);
        if (TextUtils.isEmpty(str)) {
            Log.w("RelevantSearchService", "empty query");
            if (dVar != null) {
                dVar.a(false, null, null, null);
            }
        }
        final WeakReference weakReference = new WeakReference(dVar);
        new a(str).acy().b(bVar).b(new a<Void, com.tencent.mm.ai.a.a<bvj>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(91364);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                d dVar = (d) weakReference.get();
                if (dVar != null) {
                    if (aVar.errType == 0 && aVar.errCode == 0) {
                        dVar.a(true, ((bvj) aVar.fsy).wWx, ((bvj) aVar.fsy).vQg, str);
                    } else {
                        Log.w("RelevantSearchService", "search local page error " + aVar.aIm);
                        dVar.a(false, null, null, null);
                    }
                }
                AppMethodBeat.o(91364);
                return null;
            }
        });
        AppMethodBeat.o(91365);
    }

    public final void ar(String str, String str2, String str3) {
        AppMethodBeat.i(91366);
        an.a(str, str2, System.currentTimeMillis(), str3);
        AppMethodBeat.o(91366);
    }

    public final void d(String str, String str2, int i, String str3) {
        AppMethodBeat.i(91367);
        an.e(str, str2, i, str3);
        AppMethodBeat.o(91367);
    }
}
