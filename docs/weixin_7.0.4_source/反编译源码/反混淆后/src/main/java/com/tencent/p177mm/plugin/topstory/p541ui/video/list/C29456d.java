package com.tencent.p177mm.plugin.topstory.p541ui.video.list;

import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C13954d;
import com.tencent.p177mm.plugin.topstory.p541ui.video.C4232b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.list.d */
public final class C29456d extends C13954d {
    /* renamed from: a */
    public final void mo26186a(C4232b c4232b) {
        AppMethodBeat.m2504i(2023);
        RecyclerView recyclerView = c4232b.getRecyclerView();
        C41531v f = C29456d.m46780f(c4232b);
        if (f instanceof C46950h) {
            int cFP;
            C46950h c46950h = (C46950h) f;
            if (c46950h != null) {
                cFP = c46950h.cFP();
            } else {
                cFP = -1;
            }
            if (cFP != c4232b.cFY() && c4232b.cFV().sFw) {
                c4232b.cFV().stopPlay();
            }
            c4232b.cFO();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < recyclerView.getChildCount()) {
                    View childAt = recyclerView.getChildAt(i2);
                    if (childAt.getTag() != null) {
                        c46950h = (C46950h) c4232b.getRecyclerView().mo66337aZ(childAt);
                        if (c46950h.cFP() == cFP) {
                            c46950h.cHk();
                            c46950h.cFN();
                            if (!c4232b.cFV().sFw) {
                                c46950h.sGZ.cGn();
                            }
                        } else {
                            c46950h.cHj();
                            c46950h.sGZ.cGo();
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(2023);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(2023);
    }

    /* renamed from: b */
    public final void mo26188b(C4232b c4232b) {
        AppMethodBeat.m2504i(2024);
        C41531v f = C29456d.m46780f(c4232b);
        if (f instanceof C46950h) {
            C46950h c46950h = (C46950h) f;
            if (!c4232b.cFV().sFw) {
                if (c4232b.cFQ().isConnected()) {
                    c46950h.mo47707mc(true);
                } else {
                    c46950h.sGZ.cGr();
                    c4232b.cFV().stopPlay();
                }
            }
            c46950h.cFN();
            c4232b.mo9158FD(c46950h.cFP());
            c4232b.cFR().cGS();
            AppMethodBeat.m2505o(2024);
            return;
        }
        AppMethodBeat.m2505o(2024);
    }

    /* renamed from: a */
    public final void mo26187a(C4232b c4232b, int i) {
        AppMethodBeat.m2504i(2025);
        View view = null;
        for (int i2 = 0; i2 < c4232b.getRecyclerView().getChildCount(); i2++) {
            view = c4232b.getRecyclerView().getChildAt(i2);
            if (RecyclerView.m72547bo(view) == i) {
                break;
            }
        }
        if (view != null) {
            c4232b.getRecyclerView().mo66329a(0, c4232b.cFX().mo31893bf(view) - c4232b.cGd(), null);
        }
        AppMethodBeat.m2505o(2025);
    }

    /* renamed from: e */
    private static View m46779e(C4232b c4232b) {
        AppMethodBeat.m2504i(2026);
        int i = 0;
        while (i < c4232b.getRecyclerView().getChildCount()) {
            View childAt = c4232b.getRecyclerView().getChildAt(i);
            C41531v aZ = c4232b.getRecyclerView().mo66337aZ(childAt);
            if (childAt.getTag() == null || !childAt.getTag().equals("video") || childAt.getTop() <= 0 || aZ.mo66454kj() < 0) {
                C4990ab.m7417i("MicroMsg.TopStory.TopStoryHItemViewController", "findTargetPlayView index:%s, top:%s, pos:%s", Integer.valueOf(i), Integer.valueOf(childAt.getTop()), Integer.valueOf(aZ.mo66454kj()));
                i++;
            } else {
                AppMethodBeat.m2505o(2026);
                return childAt;
            }
        }
        AppMethodBeat.m2505o(2026);
        return null;
    }

    /* renamed from: f */
    public static C41531v m46780f(C4232b c4232b) {
        AppMethodBeat.m2504i(2027);
        View e = C29456d.m46779e(c4232b);
        if (e != null) {
            C41531v aZ = c4232b.getRecyclerView().mo66337aZ(e);
            AppMethodBeat.m2505o(2027);
            return aZ;
        }
        AppMethodBeat.m2505o(2027);
        return null;
    }
}
