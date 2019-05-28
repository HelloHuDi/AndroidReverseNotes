package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    /* Access modifiers changed, original: protected|final */
    public final List<a> Q(bi biVar) {
        String str = null;
        AppMethodBeat.i(18617);
        if (biVar == null) {
            AppMethodBeat.o(18617);
            return null;
        }
        com.tencent.mm.af.j.b me;
        String anj = bo.anj(biVar.field_content);
        if (anj != null) {
            me = com.tencent.mm.af.j.b.me(anj);
        } else {
            me = null;
        }
        if (me == null) {
            ab.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
            AppMethodBeat.o(18617);
            return null;
        }
        a R = a.R(biVar);
        com.tencent.mm.pluginsdk.model.app.b aiE = am.aUq().aiE(me.csD);
        long j = 0;
        if (aiE != null) {
            str = aiE.field_fileFullPath;
            j = e.asZ(str);
        }
        R.field_msgSubType = 30;
        R.field_path = Gh(str);
        R.field_size = j;
        anj = o.ahl().I(biVar.field_imgPath, true);
        long asZ = e.asZ(anj);
        a R2 = a.R(biVar);
        R2.field_msgSubType = 31;
        R2.field_path = Gh(anj);
        R2.field_size = asZ;
        ab.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", aZm(), R, R2);
        List<a> arrayList = new ArrayList();
        arrayList.add(R);
        arrayList.add(R2);
        AppMethodBeat.o(18617);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.i(18618);
        String str = "AppMsgImg_" + hashCode();
        AppMethodBeat.o(18618);
        return str;
    }
}
