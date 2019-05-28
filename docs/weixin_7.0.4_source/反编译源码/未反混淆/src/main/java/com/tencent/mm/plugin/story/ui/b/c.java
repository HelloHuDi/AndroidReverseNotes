package com.tencent.mm.plugin.story.ui.b;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\fR\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/layout/IndicatorLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "Companion", "plugin-story_release"})
public final class c extends LinearLayoutManager {
    private static final String TAG = TAG;
    public static final a she = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/layout/IndicatorLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public c(Context context) {
        j.p(context, "context");
        super(0);
        AppMethodBeat.i(110233);
        AppMethodBeat.o(110233);
    }

    static {
        AppMethodBeat.i(110234);
        AppMethodBeat.o(110234);
    }

    public final void c(o oVar, s sVar) {
        AppMethodBeat.i(110230);
        j.p(oVar, "recycler");
        j.p(sVar, "state");
        super.c(oVar, sVar);
        ab.i(TAG, "onLayoutChildren: " + getItemCount() + ' ' + getChildCount());
        AppMethodBeat.o(110230);
    }

    public final int a(int i, o oVar, s sVar) {
        AppMethodBeat.i(110231);
        int a = super.a(i, oVar, sVar);
        ab.i(TAG, "scrollHorizontallyBy: " + getItemCount() + ' ' + getChildCount());
        AppMethodBeat.o(110231);
        return a;
    }

    public final void bY(int i) {
        AppMethodBeat.i(110232);
        int iR = iR();
        int iT = iT();
        if (i - iR < 2) {
            super.bY(i - 2);
            AppMethodBeat.o(110232);
            return;
        }
        if (iT - i < 2) {
            super.bY(i + 2);
        }
        AppMethodBeat.o(110232);
    }
}
