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
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.storage.b */
public final class C23510b extends C7563j<C46618a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C46618a.ccO, "ABTestInfo")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(118208);
        AppMethodBeat.m2505o(118208);
    }

    public C23510b(C4927e c4927e) {
        super(c4927e, C46618a.ccO, "ABTestInfo", null);
        this.bSd = c4927e;
    }

    /* renamed from: s */
    public final void mo39178s(List<C46618a> list, int i) {
        AppMethodBeat.m2504i(118202);
        Object obj = null;
        long anT = C5046bo.anT();
        this.bSd.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(anT)}), null);
        if (1 == i) {
            C46618a c46618a = new C46618a();
            c46618a.field_prioritylevel = 1;
            mo10100a((C4925c) c46618a, false, "prioritylevel");
        }
        for (C4925c c4925c : list) {
            boolean z;
            Object obj2;
            if (c4925c == null || C5046bo.isNullOrNil(c4925c.field_abtestkey)) {
                C4990ab.m7412e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                C4925c c46618a2 = new C46618a();
                c46618a2.field_abtestkey = c4925c.field_abtestkey;
                if (!super.mo10102b(c46618a2, new String[0])) {
                    C4990ab.m7417i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", c4925c.field_abtestkey, Boolean.valueOf(super.mo16759a(c4925c, false)));
                    z = r2;
                } else if ((c4925c.field_sequence <= c46618a2.field_sequence || c4925c.field_prioritylevel != c46618a2.field_prioritylevel) && c4925c.field_prioritylevel <= c46618a2.field_prioritylevel) {
                    C4990ab.m7417i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", c4925c.field_abtestkey, Long.valueOf(c46618a2.field_sequence), Long.valueOf(c4925c.field_sequence), Integer.valueOf(c46618a2.field_prioritylevel), Integer.valueOf(c4925c.field_prioritylevel));
                    z = false;
                } else {
                    C4990ab.m7417i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", c4925c.field_abtestkey, Boolean.valueOf(super.mo16762b(c4925c, false, new String[0])), Long.valueOf(c46618a2.field_sequence), Long.valueOf(c4925c.field_sequence), Integer.valueOf(c46618a2.field_prioritylevel), Integer.valueOf(c4925c.field_prioritylevel));
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
        AppMethodBeat.m2505o(118202);
    }

    public final LinkedList<C15402za> drs() {
        AppMethodBeat.m2504i(118203);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR == null) {
            AppMethodBeat.m2505o(118203);
        } else if (baR.moveToFirst()) {
            C46618a c46618a = new C46618a();
            do {
                c46618a.mo8995d(baR);
                C15402za c15402za = new C15402za();
                try {
                    c15402za.wcM = C5046bo.getInt(c46618a.field_expId, 0);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", c46618a.field_expId);
                }
                c15402za.priority = c46618a.field_prioritylevel;
                linkedList.add(c15402za);
            } while (baR.moveToNext());
            baR.close();
            AppMethodBeat.m2505o(118203);
        } else {
            baR.close();
            AppMethodBeat.m2505o(118203);
        }
        return linkedList;
    }

    public final C46618a aoe(String str) {
        AppMethodBeat.m2504i(118204);
        C4925c c46618a = new C46618a();
        c46618a.field_abtestkey = str;
        if (super.mo10102b(c46618a, new String[0]) && c46618a.field_endTime == 0) {
            c46618a.field_endTime = Long.MAX_VALUE;
        }
        C4990ab.m7417i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(r1));
        AppMethodBeat.m2505o(118204);
        return c46618a;
    }

    /* renamed from: en */
    public final int mo39176en(String str, int i) {
        AppMethodBeat.m2504i(118205);
        C46618a aoe = aoe(str);
        if (aoe.isValid()) {
            i = C5046bo.getInt(aoe.field_value, i);
            AppMethodBeat.m2505o(118205);
            return i;
        }
        AppMethodBeat.m2505o(118205);
        return i;
    }

    public final String getExpIdByKey(String str) {
        AppMethodBeat.m2504i(118206);
        C46618a aoe = aoe(str);
        String str2;
        if (!aoe.isValid()) {
            str2 = "";
            AppMethodBeat.m2505o(118206);
            return str2;
        } else if (aoe.field_expId == null) {
            str2 = "";
            AppMethodBeat.m2505o(118206);
            return str2;
        } else {
            str2 = aoe.field_expId;
            AppMethodBeat.m2505o(118206);
            return str2;
        }
    }

    public final String drt() {
        AppMethodBeat.m2504i(118207);
        Cursor baR = baR();
        String str;
        if (baR == null) {
            str = "null cursor!!";
            AppMethodBeat.m2505o(118207);
            return str;
        } else if (baR.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            C46618a c46618a = new C46618a();
            do {
                stringBuilder.append("============\n");
                c46618a.mo8995d(baR);
                stringBuilder.append("abtestkey = ").append(c46618a.field_abtestkey).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("sequence = ").append(c46618a.field_sequence).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("priorityLV = ").append(c46618a.field_prioritylevel).append(IOUtils.LINE_SEPARATOR_UNIX);
                stringBuilder.append("expId = ").append(c46618a.field_expId).append(IOUtils.LINE_SEPARATOR_UNIX);
            } while (baR.moveToNext());
            baR.close();
            str = stringBuilder.toString();
            AppMethodBeat.m2505o(118207);
            return str;
        } else {
            baR.close();
            str = "cursor empty!!";
            AppMethodBeat.m2505o(118207);
            return str;
        }
    }
}
