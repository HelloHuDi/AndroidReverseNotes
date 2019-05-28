package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.bqd;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.b */
public class C26758b extends C7563j<C26757a> {
    public static final String[] fjY = new String[]{C7563j.m13217a(C26757a.ccO, "AppBrandRecommendCard")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(129737);
        AppMethodBeat.m2505o(129737);
    }

    public C26758b(C4927e c4927e) {
        super(c4927e, C26757a.ccO, "AppBrandRecommendCard", null);
        this.bSd = c4927e;
    }

    public final void axQ() {
        AppMethodBeat.m2504i(129734);
        this.bSd.mo10108hY("AppBrandRecommendCard", "delete from AppBrandRecommendCard");
        AppMethodBeat.m2505o(129734);
    }

    /* renamed from: t */
    public final void mo44534t(LinkedList<bqd> linkedList) {
        AppMethodBeat.m2504i(129735);
        C4990ab.m7416i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "addRecommendWxaList()");
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(linkedList);
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            bqd bqd = (bqd) it.next();
            C26757a c26757a = new C26757a();
            c26757a.field_appId = bqd.wSq;
            c26757a.field_recommendCard = bqd;
            mo10101b((C4925c) c26757a);
        }
        AppMethodBeat.m2505o(129735);
    }

    public final LinkedList<bqd> axR() {
        LinkedList<bqd> linkedList = null;
        AppMethodBeat.m2504i(129736);
        Cursor rawQuery = this.bSd.rawQuery("select * from AppBrandRecommendCard LIMIT 100", null);
        if (rawQuery == null) {
            AppMethodBeat.m2505o(129736);
        } else {
            C4990ab.m7416i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "getRecommendWxaList()");
            linkedList = new LinkedList();
            while (rawQuery.moveToNext()) {
                C26757a c26757a = new C26757a();
                c26757a.mo8995d(rawQuery);
                linkedList.add(c26757a.field_recommendCard);
            }
            rawQuery.close();
            AppMethodBeat.m2505o(129736);
        }
        return linkedList;
    }
}
