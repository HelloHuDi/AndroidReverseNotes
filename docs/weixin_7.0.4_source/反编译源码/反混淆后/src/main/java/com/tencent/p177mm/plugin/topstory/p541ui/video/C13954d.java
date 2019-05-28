package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.d */
public class C13954d {
    /* renamed from: a */
    public void mo26186a(C4232b c4232b) {
    }

    /* renamed from: b */
    public void mo26188b(C4232b c4232b) {
    }

    /* renamed from: a */
    public void mo26187a(C4232b c4232b, int i) {
    }

    /* renamed from: c */
    public static final C46927h m22095c(C4232b c4232b) {
        C41531v c41531v;
        AppMethodBeat.m2504i(1709);
        int childCount = c4232b.getLayoutManager().getChildCount();
        if (childCount == 0) {
            c41531v = null;
        } else {
            int je;
            if (c4232b.getLayoutManager().getClipToPadding()) {
                je = c4232b.cFX().mo31905je() + (c4232b.cFX().mo31907jg() / 2);
            } else {
                je = c4232b.cFX().getEnd() / 2;
            }
            int i = BaseClientBuilder.API_PRIORITY_OTHER;
            int i2 = 0;
            View view = null;
            while (i2 < childCount) {
                View childAt = c4232b.getLayoutManager().getChildAt(i2);
                int abs = Math.abs((c4232b.cFX().mo31893bf(childAt) + (c4232b.cFX().mo31897bj(childAt) / 2)) - je);
                if (abs >= i) {
                    abs = i;
                    childAt = view;
                }
                i2++;
                i = abs;
                view = childAt;
            }
            c41531v = c4232b.getRecyclerView().mo66337aZ(view);
        }
        if (c41531v instanceof C46927h) {
            C46927h c46927h = (C46927h) c41531v;
            AppMethodBeat.m2505o(1709);
            return c46927h;
        }
        AppMethodBeat.m2505o(1709);
        return null;
    }
}
