package com.tencent.p177mm.plugin.story.p536ui.p1305b;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fR\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/layout/IndicatorLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.b.c */
public final class C22264c extends LinearLayoutManager {
    private static final String TAG = TAG;
    public static final C22265a she = new C22265a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/layout/IndicatorLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.b.c$a */
    public static final class C22265a {
        private C22265a() {
        }

        public /* synthetic */ C22265a(byte b) {
            this();
        }
    }

    public C22264c(Context context) {
        C25052j.m39376p(context, "context");
        super(0);
        AppMethodBeat.m2504i(110233);
        AppMethodBeat.m2505o(110233);
    }

    static {
        AppMethodBeat.m2504i(110234);
        AppMethodBeat.m2505o(110234);
    }

    /* renamed from: c */
    public final void mo1765c(C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(110230);
        C25052j.m39376p(c25374o, "recycler");
        C25052j.m39376p(c31880s, "state");
        super.mo1765c(c25374o, c31880s);
        C4990ab.m7416i(TAG, "onLayoutChildren: " + getItemCount() + ' ' + getChildCount());
        AppMethodBeat.m2505o(110230);
    }

    /* renamed from: a */
    public final int mo1746a(int i, C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(110231);
        int a = super.mo1746a(i, c25374o, c31880s);
        C4990ab.m7416i(TAG, "scrollHorizontallyBy: " + getItemCount() + ' ' + getChildCount());
        AppMethodBeat.m2505o(110231);
        return a;
    }

    /* renamed from: bY */
    public final void mo1762bY(int i) {
        AppMethodBeat.m2504i(110232);
        int iR = mo1781iR();
        int iT = mo1783iT();
        if (i - iR < 2) {
            super.mo1762bY(i - 2);
            AppMethodBeat.m2505o(110232);
            return;
        }
        if (iT - i < 2) {
            super.mo1762bY(i + 2);
        }
        AppMethodBeat.m2505o(110232);
    }
}
