package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    /* Access modifiers changed, original: protected|final */
    public final List<a> Q(bi biVar) {
        AppMethodBeat.i(18621);
        if (biVar == null) {
            AppMethodBeat.o(18621);
            return null;
        }
        e w = o.ahl().w(biVar);
        if (w == null || w.fDy == 0) {
            ab.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", aZm());
            AppMethodBeat.o(18621);
            return null;
        }
        String q = o.ahl().q(w.fDz, "", "");
        long asZ = com.tencent.mm.vfs.e.asZ(q);
        String q2 = o.ahl().q(w.fDB, "", "");
        long asZ2 = com.tencent.mm.vfs.e.asZ(q2);
        String str = o.ahl().q(w.fDB, "", "") + "hd";
        long asZ3 = com.tencent.mm.vfs.e.asZ(str);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        if (w.agQ()) {
            w = o.ahl().ly(w.fDJ);
            if (w != null) {
                str2 = o.ahl().q(w.fDz, "", "");
                if (!bo.isEqual(str2, q)) {
                    j = com.tencent.mm.vfs.e.asZ(str2);
                }
                str3 = o.ahl().q(w.fDB, "", "");
                if (!bo.isEqual(str3, q2)) {
                    j2 = com.tencent.mm.vfs.e.asZ(str3);
                }
                str4 = o.ahl().q(w.fDB, "", "") + "hd";
                if (!bo.isEqual(str4, str)) {
                    j3 = com.tencent.mm.vfs.e.asZ(str4);
                }
            }
        }
        a R = a.R(biVar);
        R.field_msgSubType = 20;
        R.field_path = Gh(q);
        R.field_size = asZ;
        a R2 = a.R(biVar);
        R2.field_msgSubType = 21;
        R2.field_path = Gh(q2);
        R2.field_size = asZ2;
        a R3 = a.R(biVar);
        R3.field_msgSubType = 22;
        R3.field_path = Gh(str);
        R3.field_size = asZ3;
        a R4 = a.R(biVar);
        R4.field_msgSubType = 23;
        R4.field_path = Gh(str2);
        R4.field_size = j;
        a R5 = a.R(biVar);
        R5.field_msgSubType = 24;
        R5.field_path = Gh(str3);
        R5.field_size = j2;
        a R6 = a.R(biVar);
        R6.field_msgSubType = 25;
        R6.field_path = Gh(str4);
        R6.field_size = j3;
        ab.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", aZm(), R, R2, R3, R4, R5, R6);
        List<a> arrayList = new ArrayList();
        arrayList.add(R);
        arrayList.add(R2);
        arrayList.add(R3);
        arrayList.add(R4);
        arrayList.add(R5);
        arrayList.add(R6);
        AppMethodBeat.o(18621);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aZm() {
        AppMethodBeat.i(18622);
        String str = "image_" + hashCode();
        AppMethodBeat.o(18622);
        return str;
    }
}
