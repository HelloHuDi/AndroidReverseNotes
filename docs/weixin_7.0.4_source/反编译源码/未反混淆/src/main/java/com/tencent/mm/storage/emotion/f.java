package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

public final class f extends j<e> implements a {
    public static final String[] fnj = new String[]{j.a(e.ccO, "EmojiSuggestDescInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(62848);
        AppMethodBeat.o(62848);
    }

    public f(e eVar) {
        this(eVar, e.ccO, "EmojiSuggestDescInfo");
    }

    private f(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.bSd = eVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final boolean am(ArrayList<ArrayList<String>> arrayList) {
        AppMethodBeat.i(62847);
        if (arrayList.isEmpty()) {
            ab.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
            AppMethodBeat.o(62847);
        } else {
            long iV;
            h hVar;
            if (this.bSd instanceof h) {
                h hVar2 = (h) this.bSd;
                iV = hVar2.iV(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                iV = -1;
                hVar = null;
            }
            this.bSd.delete("EmojiSuggestDescInfo", "", null);
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ArrayList arrayList2 = (ArrayList) it.next();
                if (!(arrayList2 == null || arrayList2.isEmpty())) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        if (!bo.isNullOrNil(str)) {
                            ab.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", String.valueOf(i), str);
                            b((c) new e(String.valueOf(i), str));
                        }
                    }
                    i++;
                }
                i = i;
            }
            if (hVar != null) {
                hVar.mB(iV);
            }
            AppMethodBeat.o(62847);
        }
        return false;
    }
}
