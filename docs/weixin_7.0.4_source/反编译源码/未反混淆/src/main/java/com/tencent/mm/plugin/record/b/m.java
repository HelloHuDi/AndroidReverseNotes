package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class m extends j<com.tencent.mm.plugin.record.a.j> implements g {
    private e bSd;

    public m(e eVar) {
        super(eVar, com.tencent.mm.plugin.record.a.j.ccO, "RecordMessageInfo", null);
        this.bSd = eVar;
    }

    public final List<com.tencent.mm.plugin.record.a.j> ceB() {
        AppMethodBeat.i(135694);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR != null) {
            baR.moveToFirst();
            while (!baR.isAfterLast()) {
                com.tencent.mm.plugin.record.a.j jVar = new com.tencent.mm.plugin.record.a.j();
                try {
                    jVar.d(baR);
                } catch (Exception e) {
                    ab.e("MicroMsg.RecordMsgStorage", "convert recordInfo Exception: " + e.getMessage());
                }
                linkedList.add(jVar);
                baR.moveToNext();
            }
            baR.close();
        }
        ab.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(135694);
        return linkedList;
    }

    public final void BF(int i) {
        AppMethodBeat.i(135695);
        int delete = this.bSd.delete("RecordMessageInfo", "localId=?", new String[]{String.valueOf(i)});
        ab.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", Integer.valueOf(i), Integer.valueOf(delete));
        AppMethodBeat.o(135695);
    }

    public final com.tencent.mm.plugin.record.a.j BG(int i) {
        com.tencent.mm.plugin.record.a.j jVar = null;
        AppMethodBeat.i(135696);
        ab.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", "SELECT * FROM RecordMessageInfo WHERE localId=".concat(String.valueOf(i)), Integer.valueOf(i));
        Cursor a = this.bSd.a(r1, null, 2);
        if (a != null && a.moveToFirst()) {
            jVar = new com.tencent.mm.plugin.record.a.j();
            jVar.d(a);
        }
        if (a != null) {
            a.close();
        }
        AppMethodBeat.o(135696);
        return jVar;
    }
}
