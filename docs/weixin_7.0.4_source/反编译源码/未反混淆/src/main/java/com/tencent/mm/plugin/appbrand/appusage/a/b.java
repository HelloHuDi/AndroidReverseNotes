package com.tencent.mm.plugin.appbrand.appusage.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public class b extends j<a> {
    public static final String[] fjY = new String[]{j.a(a.ccO, "AppBrandRecommendCard")};
    private e bSd;

    static {
        AppMethodBeat.i(129737);
        AppMethodBeat.o(129737);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "AppBrandRecommendCard", null);
        this.bSd = eVar;
    }

    public final void axQ() {
        AppMethodBeat.i(129734);
        this.bSd.hY("AppBrandRecommendCard", "delete from AppBrandRecommendCard");
        AppMethodBeat.o(129734);
    }

    public final void t(LinkedList<bqd> linkedList) {
        AppMethodBeat.i(129735);
        ab.i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "addRecommendWxaList()");
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(linkedList);
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            bqd bqd = (bqd) it.next();
            a aVar = new a();
            aVar.field_appId = bqd.wSq;
            aVar.field_recommendCard = bqd;
            b((c) aVar);
        }
        AppMethodBeat.o(129735);
    }

    public final LinkedList<bqd> axR() {
        LinkedList<bqd> linkedList = null;
        AppMethodBeat.i(129736);
        Cursor rawQuery = this.bSd.rawQuery("select * from AppBrandRecommendCard LIMIT 100", null);
        if (rawQuery == null) {
            AppMethodBeat.o(129736);
        } else {
            ab.i("MicroMsg.Recommend.AppBrandRecommendCardStorage", "getRecommendWxaList()");
            linkedList = new LinkedList();
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.d(rawQuery);
                linkedList.add(aVar.field_recommendCard);
            }
            rawQuery.close();
            AppMethodBeat.o(129736);
        }
        return linkedList;
    }
}
