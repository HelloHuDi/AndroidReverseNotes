package com.tencent.p177mm.p647w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C45968a;
import com.tencent.ttpic.util.ActUtil;

/* renamed from: com.tencent.mm.w.a */
public final class C40925a extends C45968a {
    public final String getName() {
        return "FTS5FriendStorage";
    }

    public final int getType() {
        return ActUtil.HEIGHT;
    }

    public final int getPriority() {
        return ActUtil.HEIGHT;
    }

    /* renamed from: Po */
    public final void mo23702Po() {
        AppMethodBeat.m2504i(124472);
        if (mo23703Pp()) {
            this.mBT.mo54778K(-107, 1);
        }
        AppMethodBeat.m2505o(124472);
    }

    public final String getTableName() {
        return "Friend";
    }

    /* renamed from: Pp */
    public final boolean mo23703Pp() {
        AppMethodBeat.m2504i(124473);
        if (mo73849ei(-107, 1)) {
            AppMethodBeat.m2505o(124473);
            return false;
        }
        AppMethodBeat.m2505o(124473);
        return true;
    }
}
