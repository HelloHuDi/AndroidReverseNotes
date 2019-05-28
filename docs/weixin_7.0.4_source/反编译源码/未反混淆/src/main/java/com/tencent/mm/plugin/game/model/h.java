package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends g {

    /* renamed from: com.tencent.mm.plugin.game.model.h$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ LinkedList mVS;

        AnonymousClass1(LinkedList linkedList) {
            this.mVS = linkedList;
        }

        public final void run() {
            AppMethodBeat.i(111245);
            LinkedList linkedList = new LinkedList();
            Iterator it = this.mVS.iterator();
            while (it.hasNext()) {
                Iterator it2 = g.s(((h) it.next()).optJSONArray("items")).iterator();
                while (it2.hasNext()) {
                    c cVar = (c) it2.next();
                    if (!bo.isNullOrNil(cVar.field_appId)) {
                        linkedList.add(cVar.field_appId);
                    }
                }
            }
            it = c.bFF().iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (!linkedList.contains(fVar.field_appId)) {
                    a.bYJ().b(fVar, new String[0]);
                    ab.i("MicroMsg.GameDataSearchGameList", "delete appid : " + fVar.field_appId);
                }
            }
            AppMethodBeat.o(111245);
        }
    }

    protected h(String str) {
        super(str);
    }

    public final void bEf() {
        AppMethodBeat.i(111246);
        LinkedList s = g.s(optJSONArray("items"));
        Iterator it = s.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            cVar.ii(cVar.mVk);
        }
        d.ac(s);
        AppMethodBeat.o(111246);
    }
}
