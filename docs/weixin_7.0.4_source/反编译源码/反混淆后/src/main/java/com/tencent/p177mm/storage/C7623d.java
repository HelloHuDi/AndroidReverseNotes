package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C15402za;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.tencent.mm.storage.d */
public final class C7623d extends C7563j<C5141c> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C5141c.ccO, "ABTestItem")};
    private final C4927e bSd;

    static {
        AppMethodBeat.m2504i(118217);
        AppMethodBeat.m2505o(118217);
    }

    public C7623d(C4927e c4927e) {
        super(c4927e, C5141c.ccO, "ABTestItem", null);
        this.bSd = c4927e;
    }

    /* renamed from: ll */
    public final C5141c mo17131ll(String str) {
        AppMethodBeat.m2504i(118212);
        C4925c c5141c = new C5141c();
        c5141c.field_layerId = str;
        if (super.mo10102b(c5141c, new String[0]) && c5141c.field_endTime == 0) {
            c5141c.field_endTime = Long.MAX_VALUE;
        }
        C4990ab.m7417i("MicroMsg.ABTestStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(r1));
        AppMethodBeat.m2505o(118212);
        return c5141c;
    }

    /* renamed from: s */
    public final void mo17132s(List<C5141c> list, int i) {
        AppMethodBeat.m2504i(118214);
        Object obj = null;
        long anT = C5046bo.anT();
        this.bSd.delete("ABTestItem", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(anT)}), null);
        if (i == 0) {
            C5141c c5141c = new C5141c();
            c5141c.field_prioritylevel = 1;
            mo10100a((C4925c) c5141c, false, "prioritylevel");
        }
        for (C4925c c4925c : list) {
            boolean z;
            Object obj2;
            if (c4925c == null || C5046bo.isNullOrNil(c4925c.field_layerId)) {
                C4990ab.m7412e("MicroMsg.ABTestStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                C4925c c5141c2 = new C5141c();
                c5141c2.field_layerId = c4925c.field_layerId;
                if (!super.mo10102b(c5141c2, new String[0])) {
                    C4990ab.m7417i("MicroMsg.ABTestStorage", "Inserted: %s, Result: %b", c4925c.field_layerId, Boolean.valueOf(super.mo16759a(c4925c, false)));
                    z = r2;
                } else if ((c4925c.field_sequence <= c5141c2.field_sequence || c4925c.field_prioritylevel != c5141c2.field_prioritylevel) && c4925c.field_prioritylevel <= c5141c2.field_prioritylevel) {
                    C4990ab.m7417i("MicroMsg.ABTestStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", c4925c.field_layerId, Long.valueOf(c5141c2.field_sequence), Long.valueOf(c4925c.field_sequence), Integer.valueOf(c5141c2.field_prioritylevel), Integer.valueOf(c4925c.field_prioritylevel));
                    z = false;
                } else {
                    C4990ab.m7417i("MicroMsg.ABTestStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", c4925c.field_layerId, Boolean.valueOf(super.mo16762b(c4925c, false, new String[0])), Long.valueOf(c5141c2.field_sequence), Long.valueOf(c4925c.field_sequence), Integer.valueOf(c5141c2.field_prioritylevel), Integer.valueOf(c4925c.field_prioritylevel));
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
        AppMethodBeat.m2505o(118214);
    }

    public final String drt() {
        AppMethodBeat.m2504i(118215);
        Cursor baR = baR();
        String str;
        if (baR == null) {
            str = "null cursor!!";
            AppMethodBeat.m2505o(118215);
            return str;
        } else if (baR.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            C5141c c5141c = new C5141c();
            do {
                stringBuilder.append("============\n");
                c5141c.mo8995d(baR);
                stringBuilder.append("layerId = ").append(c5141c.field_layerId).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("sequence = ").append(c5141c.field_sequence).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("priorityLV = ").append(c5141c.field_prioritylevel).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("expId = ").append(c5141c.field_expId).append(IOUtils.LINE_SEPARATOR_UNIX);
            } while (baR.moveToNext());
            baR.close();
            str = stringBuilder.toString();
            AppMethodBeat.m2505o(118215);
            return str;
        } else {
            baR.close();
            str = "cursor empty!!";
            AppMethodBeat.m2505o(118215);
            return str;
        }
    }

    public final LinkedList<C15402za> drs() {
        AppMethodBeat.m2504i(118216);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR == null || !baR.moveToFirst()) {
            AppMethodBeat.m2505o(118216);
        } else {
            C5141c c5141c = new C5141c();
            do {
                c5141c.mo8995d(baR);
                C15402za c15402za = new C15402za();
                try {
                    c15402za.wcM = C5046bo.getInt(c5141c.field_expId, 0);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.ABTestStorage", "expId parse failed, %s", c5141c.field_expId);
                }
                c15402za.priority = c5141c.field_prioritylevel;
                linkedList.add(c15402za);
            } while (baR.moveToNext());
            baR.close();
            AppMethodBeat.m2505o(118216);
        }
        return linkedList;
    }

    public final Map<String, C5141c> aof(String str) {
        Cursor cursor;
        AppMethodBeat.m2504i(118213);
        if (C5046bo.isNullOrNil(str)) {
            cursor = null;
        } else {
            cursor = rawQuery(String.format("select * from %s where %s = %s", new Object[]{"ABTestItem", "business", str}), new String[0]);
        }
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            HashMap hashMap = new HashMap(0);
            AppMethodBeat.m2505o(118213);
            return hashMap;
        }
        Map<String, C5141c> hashMap2 = new HashMap();
        do {
            C5141c c5141c = new C5141c();
            c5141c.mo8995d(cursor);
            hashMap2.put(c5141c.field_layerId, c5141c);
        } while (cursor.moveToNext());
        cursor.close();
        AppMethodBeat.m2505o(118213);
        return hashMap2;
    }
}
