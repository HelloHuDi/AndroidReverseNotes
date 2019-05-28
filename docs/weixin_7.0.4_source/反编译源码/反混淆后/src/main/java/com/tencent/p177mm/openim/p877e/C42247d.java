package com.tencent.p177mm.openim.p877e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.openim.e.d */
public final class C42247d extends C7563j<C42246c> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C42246c.ccO, "OpenIMAppIdInfo")};
    public C7480h fni;

    static {
        AppMethodBeat.m2504i(78989);
        AppMethodBeat.m2505o(78989);
    }

    public C42247d(C7480h c7480h) {
        super(c7480h, C42246c.ccO, "OpenIMAppIdInfo", null);
        this.fni = c7480h;
    }

    /* renamed from: a */
    public final boolean mo67777a(C42246c c42246c) {
        AppMethodBeat.m2504i(78986);
        c42246c.field_updateTime = C5046bo.anT();
        boolean a = super.mo10099a(c42246c);
        AppMethodBeat.m2505o(78986);
        return a;
    }

    /* renamed from: vm */
    public final List<String> mo67778vm(String str) {
        AppMethodBeat.m2504i(78987);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.fni.mo10104a("select distinct appid from OpenIMAppIdInfo where appid=? ", new String[]{str}, 2);
        if (a.moveToFirst()) {
            do {
                String string = a.getString(0);
                if (!C5046bo.isNullOrNil(string)) {
                    linkedList.add(string);
                }
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.m2505o(78987);
        return linkedList;
    }
}
