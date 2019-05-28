package com.tencent.p177mm.plugin.record.p492b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.record.p1016a.C16844j;
import com.tencent.p177mm.plugin.record.p1016a.C46163g;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.record.b.m */
public final class C43435m extends C7563j<C16844j> implements C46163g {
    private C4927e bSd;

    public C43435m(C4927e c4927e) {
        super(c4927e, C16844j.ccO, "RecordMessageInfo", null);
        this.bSd = c4927e;
    }

    public final List<C16844j> ceB() {
        AppMethodBeat.m2504i(135694);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR != null) {
            baR.moveToFirst();
            while (!baR.isAfterLast()) {
                C16844j c16844j = new C16844j();
                try {
                    c16844j.mo8995d(baR);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.RecordMsgStorage", "convert recordInfo Exception: " + e.getMessage());
                }
                linkedList.add(c16844j);
                baR.moveToNext();
            }
            baR.close();
        }
        C4990ab.m7411d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(135694);
        return linkedList;
    }

    /* renamed from: BF */
    public final void mo68995BF(int i) {
        AppMethodBeat.m2504i(135695);
        int delete = this.bSd.delete("RecordMessageInfo", "localId=?", new String[]{String.valueOf(i)});
        C4990ab.m7411d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", Integer.valueOf(i), Integer.valueOf(delete));
        AppMethodBeat.m2505o(135695);
    }

    /* renamed from: BG */
    public final C16844j mo68996BG(int i) {
        C16844j c16844j = null;
        AppMethodBeat.m2504i(135696);
        C4990ab.m7411d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", "SELECT * FROM RecordMessageInfo WHERE localId=".concat(String.valueOf(i)), Integer.valueOf(i));
        Cursor a = this.bSd.mo10104a(r1, null, 2);
        if (a != null && a.moveToFirst()) {
            c16844j = new C16844j();
            c16844j.mo8995d(a);
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.m2505o(135696);
        return c16844j;
    }
}
