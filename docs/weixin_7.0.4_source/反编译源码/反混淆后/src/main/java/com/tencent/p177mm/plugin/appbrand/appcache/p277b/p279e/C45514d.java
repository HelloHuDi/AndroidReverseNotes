package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p911q.C19678c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.e.d */
public final class C45514d extends C19678c<C38113c> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C38113c.fjX, "PredownloadCmdGetCodePersistentInfo")};
    private final C4927e gTC;

    public C45514d(C4927e c4927e) {
        super(c4927e, C38113c.fjX, "PredownloadCmdGetCodePersistentInfo", C38113c.diI);
        this.gTC = c4927e;
    }

    static {
        AppMethodBeat.m2504i(129512);
        AppMethodBeat.m2505o(129512);
    }

    /* renamed from: c */
    public final List<C38113c> mo73327c(String str, String... strArr) {
        AppMethodBeat.m2504i(129511);
        Cursor query = this.gTC.query("PredownloadCmdGetCodePersistentInfo", null, str, strArr, null, null, null);
        if (query == null || query.isClosed()) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(129511);
            return emptyList;
        }
        List<C38113c> linkedList = new LinkedList();
        if (query.moveToFirst()) {
            do {
                C38113c c38113c = new C38113c();
                c38113c.mo8995d(query);
                linkedList.add(c38113c);
            } while (query.moveToNext());
        }
        query.close();
        AppMethodBeat.m2505o(129511);
        return linkedList;
    }
}
