package com.tencent.mm.plugin.emojicapture.ui.c;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\"\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J \u0010%\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0016J \u0010&\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0016J \u0010'\u001a\u00020\u00122\f\u0010(\u001a\b\u0018\u00010)R\u00020!2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0005H\u0016J$\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\n\u0010(\u001a\u00060)R\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J\b\u00100\u001a\u00020\u0012H\u0002J\u0010\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000RL\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00063"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "TAG", "", "forceUpdateOnNextLayout", "", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutChildren", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onLayoutCompleted", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "updateChild", "updateSelectedChild", "force", "plugin-emojicapture_release"})
public final class a extends LinearLayoutManager {
    private final String TAG = "MicroMsg.StickerLayoutManager";
    private int llU = -1;
    private int lqq;
    private boolean lqr;
    public m<? super Integer, ? super View, y> lqs;

    public a(Context context) {
        j.p(context, "context");
        super(0);
        AppMethodBeat.i(3192);
        AppMethodBeat.o(3192);
    }

    public final void a(s sVar) {
        AppMethodBeat.i(3181);
        ab.i(this.TAG, "onLayoutCompleted");
        super.a(sVar);
        gK(this.lqr);
        this.lqr = false;
        AppMethodBeat.o(3181);
    }

    public final void cm(int i) {
        AppMethodBeat.i(3182);
        ab.i(this.TAG, "onScrollStateChanged ".concat(String.valueOf(i)));
        super.cm(i);
        this.lqq = i;
        if (this.lqq == 0) {
            gK(false);
        }
        AppMethodBeat.o(3182);
    }

    public final void c(o oVar, s sVar) {
        AppMethodBeat.i(3183);
        super.c(oVar, sVar);
        bol();
        AppMethodBeat.o(3183);
    }

    public final int a(int i, o oVar, s sVar) {
        AppMethodBeat.i(3184);
        j.p(oVar, "recycler");
        j.p(sVar, "state");
        int a = super.a(i, oVar, sVar);
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
            ab.i(this.TAG, "horizontal Drag to end, " + i + ' ' + a + ", " + recyclerView);
            if (recyclerView != null) {
                recyclerView.jm();
            }
        }
        bol();
        AppMethodBeat.o(3184);
        return a;
    }

    private final void bol() {
        AppMethodBeat.i(3185);
        Rect rect = new Rect();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            i.d(childAt, rect);
            if (Math.abs(((rect.left + rect.right) / 2) - (getWidth() / 2)) < (rect.right - rect.left) / 2) {
                j.o(childAt, "child");
                childAt.setAlpha(1.0f);
            } else {
                j.o(childAt, "child");
                childAt.setAlpha(0.3f);
            }
        }
        AppMethodBeat.o(3185);
    }

    private void gK(boolean z) {
        AppMethodBeat.i(3186);
        int bom = bom();
        if (bom >= 0) {
            View childAt = getChildAt(bom);
            int bt = i.bt(childAt);
            if (bt != this.llU || z) {
                this.llU = bt;
                m mVar = this.lqs;
                if (mVar != null) {
                    Integer valueOf = Integer.valueOf(this.llU);
                    j.o(childAt, "child");
                    mVar.m(valueOf, childAt);
                    AppMethodBeat.o(3186);
                    return;
                }
            }
        }
        AppMethodBeat.o(3186);
    }

    private final int bom() {
        int i = 0;
        AppMethodBeat.i(3187);
        if (getChildCount() != 1) {
            int height;
            int childCount;
            View childAt;
            int top;
            View childAt2;
            if (!iG()) {
                height = getHeight() / 2;
                childCount = getChildCount();
                while (i < childCount) {
                    childAt = getChildAt(i);
                    j.o(childAt, "getChildAt(i)");
                    top = childAt.getTop();
                    childAt2 = getChildAt(i);
                    j.o(childAt2, "getChildAt(i)");
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
                    j.o(childAt, "getChildAt(i)");
                    top = childAt.getLeft();
                    childAt2 = getChildAt(i);
                    j.o(childAt2, "getChildAt(i)");
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
        AppMethodBeat.o(3187);
        return i;
    }

    public final void a(RecyclerView recyclerView) {
        AppMethodBeat.i(3188);
        j.p(recyclerView, "recyclerView");
        ab.i(this.TAG, "onItemsChanged");
        this.lqr = true;
        AppMethodBeat.o(3188);
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(3189);
        super.c(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.o(3189);
    }

    public final void d(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(3190);
        j.p(recyclerView, "recyclerView");
        ab.i(this.TAG, "onItemsRemoved " + i + ", " + i2);
        super.d(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.o(3190);
    }

    public final void g(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(3191);
        j.p(recyclerView, "recyclerView");
        ab.i(this.TAG, "onItemsUpdated " + i + ", " + i2);
        super.g(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.o(3191);
    }
}
