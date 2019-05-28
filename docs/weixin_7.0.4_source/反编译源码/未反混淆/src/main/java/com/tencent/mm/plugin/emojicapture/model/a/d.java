package com.tencent.mm.plugin.emojicapture.model.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.model.c.a.a;
import com.tencent.mm.plugin.emojicapture.model.c.i;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, dWq = {"checkStickerValid", "", "item", "Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensItem;", "plugin-emojicapture_release"})
public final class d {
    public static final boolean a(com.tencent.mm.plugin.emojicapture.model.c.d dVar) {
        AppMethodBeat.i(2646);
        j.p(dVar, "item");
        e eVar = e.lii;
        String uw = e.uw(dVar.ljp);
        i iVar = new i();
        a aVar = com.tencent.mm.plugin.emojicapture.model.c.a.ljn;
        a.a(uw, iVar);
        if (iVar.ljI >= dVar.ljr) {
            AppMethodBeat.o(2646);
            return true;
        }
        AppMethodBeat.o(2646);
        return false;
    }
}
