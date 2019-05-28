package com.tencent.p177mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.modelvideo.l */
public final class C26489l extends C7563j<C9716j> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C9716j.ccO, "SightDraftInfo")};
    C4927e bSd;

    static {
        AppMethodBeat.m2504i(50732);
        AppMethodBeat.m2505o(50732);
    }

    public C26489l(C4927e c4927e) {
        super(c4927e, C9716j.ccO, "SightDraftInfo", null);
        this.bSd = c4927e;
    }

    public final List<C9716j> alf() {
        AppMethodBeat.m2504i(50730);
        LinkedList linkedList = new LinkedList();
        String str = "SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC " + new StringBuilder(" LIMIT 5").toString();
        Cursor a = this.bSd.mo10104a(str, new String[]{"7"}, 2);
        if (a == null) {
            AppMethodBeat.m2505o(50730);
        } else {
            while (a.moveToNext()) {
                C9716j c9716j = new C9716j();
                c9716j.mo8995d(a);
                linkedList.add(c9716j);
            }
            a.close();
            AppMethodBeat.m2505o(50730);
        }
        return linkedList;
    }

    public final Cursor alg() {
        AppMethodBeat.m2504i(50731);
        Cursor rawQuery = this.bSd.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[]{"1"});
        AppMethodBeat.m2505o(50731);
        return rawQuery;
    }
}
