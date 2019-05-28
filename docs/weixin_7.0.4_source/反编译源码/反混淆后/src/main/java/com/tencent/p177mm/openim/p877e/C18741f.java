package com.tencent.p177mm.openim.p877e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.openim.e.f */
public final class C18741f extends C7563j<C42248e> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C42248e.ccO, "OpenIMWordingInfo")};
    public C7480h fni;

    static {
        AppMethodBeat.m2504i(78994);
        AppMethodBeat.m2505o(78994);
    }

    public C18741f(C7480h c7480h) {
        super(c7480h, C42248e.ccO, "OpenIMWordingInfo", null);
        this.fni = c7480h;
    }

    /* renamed from: a */
    public final boolean mo34001a(C42248e c42248e) {
        AppMethodBeat.m2504i(78991);
        c42248e.field_updateTime = C5046bo.anT();
        boolean a = super.mo10099a(c42248e);
        AppMethodBeat.m2505o(78991);
        return a;
    }

    /* renamed from: B */
    public final List<String> mo34000B(int i, String str) {
        AppMethodBeat.m2504i(78992);
        LinkedList linkedList = new LinkedList();
        C4990ab.m7411d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording sql:%s", " select wordingId from OpenIMWordingInfo where language='" + str + "' order by updateTime limit " + i);
        Cursor a = this.fni.mo10104a(r1, null, 2);
        if (a.moveToFirst()) {
            do {
                String string = a.getString(0);
                if (!C5046bo.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            } while (a.moveToNext());
        }
        C4990ab.m7411d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording result cnt: %d, language:%s", Integer.valueOf(linkedList.size()), str);
        a.close();
        AppMethodBeat.m2505o(78992);
        return linkedList;
    }
}
