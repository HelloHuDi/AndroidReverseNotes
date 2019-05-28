package com.tencent.p177mm.plugin.story.p536ui.p1305b;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0018\u00010\rR\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "alphaStartOffset", "canScrollVertically", "", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollToPositionWithOffset", "position", "offset", "updateChild", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.b.a */
public final class C22261a extends LinearLayoutManager {
    private final int sha;

    public C22261a(Context context) {
        C25052j.m39376p(context, "context");
        super(1);
        AppMethodBeat.m2504i(110212);
        this.sha = C1338a.fromDPToPix(context, 0);
        AppMethodBeat.m2505o(110212);
    }

    /* renamed from: iH */
    public final boolean mo1777iH() {
        return false;
    }

    /* renamed from: c */
    public final void mo1765c(C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(110209);
        super.mo1765c(c25374o, c31880s);
        bol();
        AppMethodBeat.m2505o(110209);
    }

    /* renamed from: ah */
    public final void mo1757ah(int i, int i2) {
        AppMethodBeat.m2504i(110210);
        super.mo1757ah(i, i2);
        bol();
        AppMethodBeat.m2505o(110210);
    }

    private final void bol() {
        AppMethodBeat.m2504i(110211);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            boolean z;
            View childAt = getChildAt(i);
            C25052j.m39375o(childAt, "child");
            int top = (childAt.getTop() + childAt.getBottom()) / 2;
            int height = getHeight() / 2;
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight - Math.abs(top - height) > this.sha) {
                childAt.setAlpha(Math.min(1.0f - (((float) Math.abs(top - height)) / ((float) (measuredHeight - this.sha))), 1.0f));
            } else {
                childAt.setAlpha(0.0f);
            }
            if (1.0f - childAt.getAlpha() < 0.1f) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
        AppMethodBeat.m2505o(110211);
    }
}
