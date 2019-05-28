package com.tencent.p177mm.plugin.emojicapture.p389ui.p728c;

import android.content.Context;
import android.graphics.Rect;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\"\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J \u0010%\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0016J \u0010&\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0016J \u0010'\u001a\u00020\u00122\f\u0010(\u001a\b\u0018\u00010)R\u00020!2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0005H\u0016J$\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\n\u0010(\u001a\u00060)R\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\b\u00100\u001a\u00020\u0012H\u0002J\u0010\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000RL\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "TAG", "", "forceUpdateOnNextLayout", "", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutChildren", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onLayoutCompleted", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "updateChild", "updateSelectedChild", "force", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.c.a */
public final class C6849a extends LinearLayoutManager {
    private final String TAG = "MicroMsg.StickerLayoutManager";
    private int llU = -1;
    private int lqq;
    private boolean lqr;
    public C31591m<? super Integer, ? super View, C37091y> lqs;

    public C6849a(Context context) {
        C25052j.m39376p(context, "context");
        super(0);
        AppMethodBeat.m2504i(3192);
        AppMethodBeat.m2505o(3192);
    }

    /* renamed from: a */
    public final void mo1753a(C31880s c31880s) {
        AppMethodBeat.m2504i(3181);
        C4990ab.m7416i(this.TAG, "onLayoutCompleted");
        super.mo1753a(c31880s);
        m11315gK(this.lqr);
        this.lqr = false;
        AppMethodBeat.m2505o(3181);
    }

    /* renamed from: cm */
    public final void mo15124cm(int i) {
        AppMethodBeat.m2504i(3182);
        C4990ab.m7416i(this.TAG, "onScrollStateChanged ".concat(String.valueOf(i)));
        super.mo15124cm(i);
        this.lqq = i;
        if (this.lqq == 0) {
            m11315gK(false);
        }
        AppMethodBeat.m2505o(3182);
    }

    /* renamed from: c */
    public final void mo1765c(C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(3183);
        super.mo1765c(c25374o, c31880s);
        bol();
        AppMethodBeat.m2505o(3183);
    }

    /* renamed from: a */
    public final int mo1746a(int i, C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(3184);
        C25052j.m39376p(c25374o, "recycler");
        C25052j.m39376p(c31880s, "state");
        int a = super.mo1746a(i, c25374o, c31880s);
        if (i + 1 <= a && -1 >= a && this.lqq == 1) {
            ViewParent parent;
            View childAt = getChildAt(0);
            if (childAt != null) {
                parent = childAt.getParent();
            } else {
                parent = null;
            }
            if (!(parent instanceof RecyclerView)) {
                parent = null;
            }
            RecyclerView recyclerView = (RecyclerView) parent;
            C4990ab.m7416i(this.TAG, "horizontal Drag to end, " + i + ' ' + a + ", " + recyclerView);
            if (recyclerView != null) {
                recyclerView.mo66403jm();
            }
        }
        bol();
        AppMethodBeat.m2505o(3184);
        return a;
    }

    private final void bol() {
        AppMethodBeat.m2504i(3185);
        Rect rect = new Rect();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C17480i.m27157d(childAt, rect);
            if (Math.abs(((rect.left + rect.right) / 2) - (getWidth() / 2)) < (rect.right - rect.left) / 2) {
                C25052j.m39375o(childAt, "child");
                childAt.setAlpha(1.0f);
            } else {
                C25052j.m39375o(childAt, "child");
                childAt.setAlpha(0.3f);
            }
        }
        AppMethodBeat.m2505o(3185);
    }

    /* renamed from: gK */
    private void m11315gK(boolean z) {
        AppMethodBeat.m2504i(3186);
        int bom = bom();
        if (bom >= 0) {
            View childAt = getChildAt(bom);
            int bt = C17480i.m27148bt(childAt);
            if (bt != this.llU || z) {
                this.llU = bt;
                C31591m c31591m = this.lqs;
                if (c31591m != null) {
                    Integer valueOf = Integer.valueOf(this.llU);
                    C25052j.m39375o(childAt, "child");
                    c31591m.mo212m(valueOf, childAt);
                    AppMethodBeat.m2505o(3186);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(3186);
    }

    private final int bom() {
        int i = 0;
        AppMethodBeat.m2504i(3187);
        if (getChildCount() != 1) {
            int height;
            int childCount;
            View childAt;
            int top;
            View childAt2;
            if (!mo1776iG()) {
                height = getHeight() / 2;
                childCount = getChildCount();
                while (i < childCount) {
                    childAt = getChildAt(i);
                    C25052j.m39375o(childAt, "getChildAt(i)");
                    top = childAt.getTop();
                    childAt2 = getChildAt(i);
                    C25052j.m39375o(childAt2, "getChildAt(i)");
                    if ((top + childAt2.getBottom()) / 2 == height) {
                        break;
                    }
                    i++;
                }
            } else {
                height = getWidth() / 2;
                childCount = getChildCount();
                while (i < childCount) {
                    childAt = getChildAt(i);
                    C25052j.m39375o(childAt, "getChildAt(i)");
                    top = childAt.getLeft();
                    childAt2 = getChildAt(i);
                    C25052j.m39375o(childAt2, "getChildAt(i)");
                    top = (top + childAt2.getRight()) / 2;
                    int i2 = height + 1;
                    if (height - 1 <= top && i2 >= top) {
                        break;
                    }
                    i++;
                }
            }
            i = -1;
        }
        AppMethodBeat.m2505o(3187);
        return i;
    }

    /* renamed from: a */
    public final void mo15122a(RecyclerView recyclerView) {
        AppMethodBeat.m2504i(3188);
        C25052j.m39376p(recyclerView, "recyclerView");
        C4990ab.m7416i(this.TAG, "onItemsChanged");
        this.lqr = true;
        AppMethodBeat.m2505o(3188);
    }

    /* renamed from: c */
    public final void mo15123c(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(3189);
        super.mo15123c(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.m2505o(3189);
    }

    /* renamed from: d */
    public final void mo15125d(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(3190);
        C25052j.m39376p(recyclerView, "recyclerView");
        C4990ab.m7416i(this.TAG, "onItemsRemoved " + i + ", " + i2);
        super.mo15125d(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.m2505o(3190);
    }

    /* renamed from: g */
    public final void mo15126g(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(3191);
        C25052j.m39376p(recyclerView, "recyclerView");
        C4990ab.m7416i(this.TAG, "onItemsUpdated " + i + ", " + i2);
        super.mo15126g(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.m2505o(3191);
    }
}
