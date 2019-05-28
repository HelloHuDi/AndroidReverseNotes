package com.tencent.p177mm.plugin.appbrand.game.p292b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C45968a;

/* renamed from: com.tencent.mm.plugin.appbrand.game.b.a */
public final class C38215a extends C45968a {
    /* renamed from: Po */
    public final void mo23702Po() {
        AppMethodBeat.m2504i(130063);
        if (mo23703Pp()) {
            mo73835K(-108, 1);
        }
        AppMethodBeat.m2505o(130063);
    }

    public final String getTableName() {
        return "MiniGame";
    }

    public final String getName() {
        return "FTS5MiniGameStorage";
    }

    public final int getType() {
        return 8;
    }

    public final int getPriority() {
        return 8;
    }

    /* renamed from: Pp */
    public final boolean mo23703Pp() {
        AppMethodBeat.m2504i(130064);
        if (mo73849ei(-108, 1)) {
            AppMethodBeat.m2505o(130064);
            return false;
        }
        AppMethodBeat.m2505o(130064);
        return true;
    }
}
