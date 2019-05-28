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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d extends j<c> {
    public static final String[] fnj = new String[]{j.a(c.ccO, "ABTestItem")};
    private final e bSd;

    static {
        AppMethodBeat.i(118217);
        AppMethodBeat.o(118217);
    }

    public d(e eVar) {
        super(eVar, c.ccO, "ABTestItem", null);
        this.bSd = eVar;
    }

    public final c ll(String str) {
        AppMethodBeat.i(118212);
        c cVar = new c();
        cVar.field_layerId = str;
        if (super.b(cVar, new String[0]) && cVar.field_endTime == 0) {
            cVar.field_endTime = Long.MAX_VALUE;
        }
        ab.i("MicroMsg.ABTestStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(r1));
        AppMethodBeat.o(118212);
        return cVar;
    }

    public final void s(List<c> list, int i) {
        AppMethodBeat.i(118214);
        Object obj = null;
        long anT = bo.anT();
        this.bSd.delete("ABTestItem", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(anT)}), null);
        if (i == 0) {
            c cVar = new c();
            cVar.field_prioritylevel = 1;
            a((c) cVar, false, "prioritylevel");
        }
        for (c cVar2 : list) {
            boolean z;
            Object obj2;
            if (cVar2 == null || bo.isNullOrNil(cVar2.field_layerId)) {
                ab.e("MicroMsg.ABTestStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c cVar3 = new c();
                cVar3.field_layerId = cVar2.field_layerId;
                if (!super.b(cVar3, new String[0])) {
                    ab.i("MicroMsg.ABTestStorage", "Inserted: %s, Result: %b", cVar2.field_layerId, Boolean.valueOf(super.a(cVar2, false)));
                    z = r2;
                } else if ((cVar2.field_sequence <= cVar3.field_sequence || cVar2.field_prioritylevel != cVar3.field_prioritylevel) && cVar2.field_prioritylevel <= cVar3.field_prioritylevel) {
                    ab.i("MicroMsg.ABTestStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = false;
                } else {
                    ab.i("MicroMsg.ABTestStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Boolean.valueOf(super.b(cVar2, false, new String[0])), Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
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
        AppMethodBeat.o(118214);
    }

    public final String drt() {
        AppMethodBeat.i(118215);
        Cursor baR = baR();
        String str;
        if (baR == null) {
            str = "null cursor!!";
            AppMethodBeat.o(118215);
            return str;
        } else if (baR.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            c cVar = new c();
            do {
                stringBuilder.append("============\n");
                cVar.d(baR);
                stringBuilder.append("layerId = ").append(cVar.field_layerId).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("sequence = ").append(cVar.field_sequence).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("priorityLV = ").append(cVar.field_prioritylevel).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("expId = ").append(cVar.field_expId).append(IOUtils.LINE_SEPARATOR_UNIX);
            } while (baR.moveToNext());
            baR.close();
            str = stringBuilder.toString();
            AppMethodBeat.o(118215);
            return str;
        } else {
            baR.close();
            str = "cursor empty!!";
            AppMethodBeat.o(118215);
            return str;
        }
    }

    public final LinkedList<za> drs() {
        AppMethodBeat.i(118216);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR == null || !baR.moveToFirst()) {
            AppMethodBeat.o(118216);
        } else {
            c cVar = new c();
            do {
                cVar.d(baR);
                za zaVar = new za();
                try {
                    zaVar.wcM = bo.getInt(cVar.field_expId, 0);
                } catch (Exception e) {
                    ab.e("MicroMsg.ABTestStorage", "expId parse failed, %s", cVar.field_expId);
                }
                zaVar.priority = cVar.field_prioritylevel;
                linkedList.add(zaVar);
            } while (baR.moveToNext());
            baR.close();
            AppMethodBeat.o(118216);
        }
        return linkedList;
    }

    public final Map<String, c> aof(String str) {
        Cursor cursor;
        AppMethodBeat.i(118213);
        if (bo.isNullOrNil(str)) {
            cursor = null;
        } else {
            cursor = rawQuery(String.format("select * from %s where %s = %s", new Object[]{"ABTestItem", "business", str}), new String[0]);
        }
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            HashMap hashMap = new HashMap(0);
            AppMethodBeat.o(118213);
            return hashMap;
        }
        Map<String, c> hashMap2 = new HashMap();
        do {
            c cVar = new c();
            cVar.d(cursor);
            hashMap2.put(cVar.field_layerId, cVar);
        } while (cursor.moveToNext());
        cursor.close();
        AppMethodBeat.o(118213);
        return hashMap2;
    }
}
