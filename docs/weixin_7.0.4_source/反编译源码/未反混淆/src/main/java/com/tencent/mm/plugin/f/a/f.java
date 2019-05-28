package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    /* Access modifiers changed, original: protected|final */
    public final List<a> Q(bi biVar) {
        AppMethodBeat.i(18625);
        if (biVar == null) {
            AppMethodBeat.o(18625);
            return null;
        }
        a R = a.R(biVar);
        String fullPath = q.getFullPath(biVar.field_imgPath);
        long cs = (long) e.cs(fullPath);
        R.field_msgSubType = 10;
        R.field_path = Gh(fullPath);
        R.field_size = cs;
        ab.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", aZm(), R);
        List<a> arrayList = new ArrayList();
        arrayList.add(R);
        AppMethodBeat.o(18625);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.i(18626);
        String str = "voice_" + hashCode();
        AppMethodBeat.o(18626);
        return str;
    }
}
