package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    /* Access modifiers changed, original: protected|final */
    public final List<a> Q(bi biVar) {
        long j = 0;
        String str = null;
        AppMethodBeat.i(18619);
        if (biVar == null) {
            AppMethodBeat.o(18619);
            return null;
        }
        b me;
        String anj = bo.anj(biVar.field_content);
        if (anj != null) {
            me = b.me(anj);
        } else {
            me = null;
        }
        if (me == null) {
            ab.e("MicroMsg.AppMsgMsgHandler", "content is null");
            AppMethodBeat.o(18619);
            return null;
        }
        int i;
        a R = a.R(biVar);
        com.tencent.mm.pluginsdk.model.app.b aiE;
        switch (me.type) {
            case 2:
                aiE = am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                    j = e.asZ(str);
                }
                R.field_msgSubType = 30;
                R.field_path = Gh(str);
                R.field_size = j;
                i = 31;
                break;
            case 6:
                aiE = am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                    j = e.asZ(str);
                }
                R.field_msgSubType = 34;
                R.field_path = Gh(str);
                R.field_size = j;
                i = 35;
                break;
            case 7:
                aiE = am.aUq().aiE(me.csD);
                if (aiE != null) {
                    str = aiE.field_fileFullPath;
                    j = e.asZ(str);
                }
                R.field_msgSubType = 32;
                R.field_path = Gh(str);
                R.field_size = j;
                i = 33;
                break;
            default:
                AppMethodBeat.o(18619);
                return null;
        }
        String I = o.ahl().I(biVar.field_imgPath, true);
        long asZ = e.asZ(I);
        a R2 = a.R(biVar);
        R2.field_msgSubType = i;
        R2.field_path = Gh(I);
        R2.field_size = asZ;
        ab.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", aZm(), R, R2);
        List<a> arrayList = new ArrayList();
        arrayList.add(R);
        arrayList.add(R2);
        AppMethodBeat.o(18619);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.i(18620);
        String str = "AppMsg_" + hashCode();
        AppMethodBeat.o(18620);
        return str;
    }
}
