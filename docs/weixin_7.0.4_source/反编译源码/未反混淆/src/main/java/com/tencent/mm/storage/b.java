package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "ABTestInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(118208);
        AppMethodBeat.o(118208);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "ABTestInfo", null);
        this.bSd = eVar;
    }

    public final void s(List<a> list, int i) {
        AppMethodBeat.i(118202);
        Object obj = null;
        long anT = bo.anT();
        this.bSd.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(anT)}), null);
        if (1 == i) {
            a aVar = new a();
            aVar.field_prioritylevel = 1;
            a((c) aVar, false, "prioritylevel");
        }
        for (c cVar : list) {
            boolean z;
            Object obj2;
            if (cVar == null || bo.isNullOrNil(cVar.field_abtestkey)) {
                ab.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c aVar2 = new a();
                aVar2.field_abtestkey = cVar.field_abtestkey;
                if (!super.b(aVar2, new String[0])) {
                    ab.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", cVar.field_abtestkey, Boolean.valueOf(super.a(cVar, false)));
                    z = r2;
                } else if ((cVar.field_sequence <= aVar2.field_sequence || cVar.field_prioritylevel != aVar2.field_prioritylevel) && cVar.field_prioritylevel <= aVar2.field_prioritylevel) {
                    ab.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", cVar.field_abtestkey, Long.valueOf(aVar2.field_sequence), Long.valueOf(cVar.field_sequence), Integer.valueOf(aVar2.field_prioritylevel), Integer.valueOf(cVar.field_prioritylevel));
                    z = false;
                } else {
                    ab.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", cVar.field_abtestkey, Boolean.valueOf(super.b(cVar, false, new String[0])), Long.valueOf(aVar2.field_sequence), Long.valueOf(cVar.field_sequence), Integer.valueOf(aVar2.field_prioritylevel), Integer.valueOf(cVar.field_prioritylevel));
                    z = r2;
                }
            }
            if (z) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj != null) {
            anF("event_updated");
        }
        AppMethodBeat.o(118202);
    }

    public final LinkedList<za> drs() {
        AppMethodBeat.i(118203);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR == null) {
            AppMethodBeat.o(118203);
        } else if (baR.moveToFirst()) {
            a aVar = new a();
            do {
                aVar.d(baR);
                za zaVar = new za();
                try {
                    zaVar.wcM = bo.getInt(aVar.field_expId, 0);
                } catch (Exception e) {
                    ab.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", aVar.field_expId);
                }
                zaVar.priority = aVar.field_prioritylevel;
                linkedList.add(zaVar);
            } while (baR.moveToNext());
            baR.close();
            AppMethodBeat.o(118203);
        } else {
            baR.close();
            AppMethodBeat.o(118203);
        }
        return linkedList;
    }

    public final a aoe(String str) {
        AppMethodBeat.i(118204);
        c aVar = new a();
        aVar.field_abtestkey = str;
        if (super.b(aVar, new String[0]) && aVar.field_endTime == 0) {
            aVar.field_endTime = Long.MAX_VALUE;
        }
        ab.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(r1));
        AppMethodBeat.o(118204);
        return aVar;
    }

    public final int en(String str, int i) {
        AppMethodBeat.i(118205);
        a aoe = aoe(str);
        if (aoe.isValid()) {
            i = bo.getInt(aoe.field_value, i);
            AppMethodBeat.o(118205);
            return i;
        }
        AppMethodBeat.o(118205);
        return i;
    }

    public final String getExpIdByKey(String str) {
        AppMethodBeat.i(118206);
        a aoe = aoe(str);
        String str2;
        if (!aoe.isValid()) {
            str2 = "";
            AppMethodBeat.o(118206);
            return str2;
        } else if (aoe.field_expId == null) {
            str2 = "";
            AppMethodBeat.o(118206);
            return str2;
        } else {
            str2 = aoe.field_expId;
            AppMethodBeat.o(118206);
            return str2;
        }
    }

    public final String drt() {
        AppMethodBeat.i(118207);
        Cursor baR = baR();
        String str;
        if (baR == null) {
            str = "null cursor!!";
            AppMethodBeat.o(118207);
            return str;
        } else if (baR.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            a aVar = new a();
            do {
                stringBuilder.append("============\n");
                aVar.d(baR);
                stringBuilder.append("abtestkey = ").append(aVar.field_abtestkey).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("sequence = ").append(aVar.field_sequence).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("priorityLV = ").append(aVar.field_prioritylevel).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("expId = ").append(aVar.field_expId).append(IOUtils.LINE_SEPARATOR_UNIX);
            } while (baR.moveToNext());
            baR.close();
            str = stringBuilder.toString();
            AppMethodBeat.o(118207);
            return str;
        } else {
            baR.close();
            str = "cursor empty!!";
            AppMethodBeat.o(118207);
            return str;
        }
    }
}
