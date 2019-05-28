package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e extends a<a> {
    public List<a> mFf = Collections.emptyList();

    public static class a {
        public String bCu;
        public String dFl;
        public String desc;
        public String hHV;
        public String ucj;
        public String userName;
    }

    public e(String str) {
        super(str);
        AppMethodBeat.i(91376);
        AppMethodBeat.o(91376);
    }

    public final void dZ(List<l> list) {
        AppMethodBeat.i(91377);
        this.mFf = new ArrayList(list.size());
        for (l lVar : list) {
            ad aoO = ((j) g.K(j.class)).XM().aoO(lVar.mDx);
            a aVar = new a();
            aVar.userName = aoO.field_username;
            aVar.ucj = lVar.content;
            aVar.bCu = aoO.field_nickname;
            aVar.hHV = aoO.field_conRemark;
            aVar.dFl = aoO.Hq();
            aVar.desc = aoO.dul;
            this.mFf.add(aVar);
        }
        AppMethodBeat.o(91377);
    }
}
