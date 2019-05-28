package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    /* Access modifiers changed, original: protected|final */
    public final List<a> Q(bi biVar) {
        AppMethodBeat.i(18623);
        if (biVar == null) {
            AppMethodBeat.o(18623);
            return null;
        }
        o.all();
        String uh = t.uh(biVar.field_imgPath);
        long asZ = com.tencent.mm.vfs.e.asZ(uh);
        a R = a.R(biVar);
        R.field_msgSubType = 1;
        R.field_path = Gh(uh);
        R.field_size = asZ;
        o.all();
        uh = t.ui(biVar.field_imgPath);
        asZ = com.tencent.mm.vfs.e.asZ(uh);
        a R2 = a.R(biVar);
        R2.field_msgSubType = 2;
        R2.field_path = Gh(uh);
        R2.field_size = asZ;
        ab.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", aZm(), R, R2);
        List<a> arrayList = new ArrayList();
        arrayList.add(R);
        arrayList.add(R2);
        AppMethodBeat.o(18623);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.i(18624);
        String str = "video_" + hashCode();
        AppMethodBeat.o(18624);
        return str;
    }
}
