package com.tencent.mm.plugin.story.ui.b;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0005H\u0002J\"\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-H\u0016J \u00101\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0016J \u00102\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0012\u00103\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0005H\u0016J$\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\n\u00109\u001a\u00060:R\u00020-2\u0006\u00104\u001a\u000205H\u0016J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J$\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\n\u00109\u001a\u00060:R\u00020-2\u0006\u00104\u001a\u000205H\u0016J\b\u0010>\u001a\u00020\u0017H\u0002J\u0010\u0010?\u001a\u00020\u00172\b\b\u0002\u0010@\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRL\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRL\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR\u000e\u0010!\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006B"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "forceUpdateOnNextLayout", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollCallback", "", "offset", "getScrollCallback", "setScrollCallback", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "scrollToPosition", "scrollVerticallyBy", "dy", "updateScroll", "updateSelectedChild", "force", "Companion", "plugin-story_release"})
public final class b extends LinearLayoutManager {
    private static final String TAG = TAG;
    public static final a shd = new a();
    public int llU;
    private int lqq;
    private boolean lqr;
    public m<? super Integer, ? super View, y> lqs;
    public m<? super Integer, ? super Float, y> shb;
    public boolean shc;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private b(Context context, int i) {
        j.p(context, "context");
        super(i);
        AppMethodBeat.i(110226);
        this.llU = -1;
        this.shc = true;
        AppMethodBeat.o(110226);
    }

    public b(Context context, int i, byte b) {
        j.p(context, "context");
        this(context, i);
        AppMethodBeat.i(110227);
        AppMethodBeat.o(110227);
    }

    public b(Context context) {
        j.p(context, "context");
        this(context, 1, (byte) 0);
        AppMethodBeat.i(110228);
        AppMethodBeat.o(110228);
    }

    static {
        AppMethodBeat.i(110229);
        AppMethodBeat.o(110229);
    }

    public final boolean iG() {
        AppMethodBeat.i(110213);
        if (this.shc && super.iG()) {
            AppMethodBeat.o(110213);
            return true;
        }
        AppMethodBeat.o(110213);
        return false;
    }

    public final boolean iH() {
        AppMethodBeat.i(110214);
        if (this.shc && getItemCount() > 1 && super.iH()) {
            AppMethodBeat.o(110214);
            return true;
        }
        AppMethodBeat.o(110214);
        return false;
    }

    public final void a(s sVar) {
        AppMethodBeat.i(110215);
        ab.i(TAG, "LogStory: onLayoutCompleted");
        super.a(sVar);
        gK(this.lqr);
        this.lqr = false;
        AppMethodBeat.o(110215);
    }

    public final void cm(int i) {
        AppMethodBeat.i(110216);
        ab.i(TAG, "LogStory: onScrollStateChanged ".concat(String.valueOf(i)));
        super.cm(i);
        this.lqq = i;
        if (this.lqq == 0) {
            gK(false);
        }
        AppMethodBeat.o(110216);
    }

    public final int a(int i, o oVar, s sVar) {
        AppMethodBeat.i(110217);
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
            ab.i(TAG, "horizontal Drag to end, " + i + ' ' + a + ", " + recyclerView);
            if (recyclerView != null) {
                recyclerView.jm();
            }
        }
        AppMethodBeat.o(110217);
        return a;
    }

    public final int b(int i, o oVar, s sVar) {
        View childAt;
        AppMethodBeat.i(110218);
        j.p(oVar, "recycler");
        j.p(sVar, "state");
        int b = super.b(i, oVar, sVar);
        ab.i(TAG, "LogStory: vertical " + i + ' ' + b);
        if (i + 1 <= b && -1 >= b && this.lqq == 1) {
            ViewParent parent;
            childAt = getChildAt(0);
            if (childAt != null) {
                parent = childAt.getParent();
            } else {
                parent = null;
            }
            if (!(parent instanceof RecyclerView)) {
                parent = null;
            }
            RecyclerView recyclerView = (RecyclerView) parent;
            ab.i(TAG, "vertical Drag to end, " + i + ' ' + b + ", " + recyclerView);
            if (recyclerView != null) {
                recyclerView.jm();
            }
        }
        if (getChildCount() != 0) {
            int bt;
            float f;
            if (getChildCount() == 1) {
                bt = i.bt(getChildAt(0));
                f = 0.0f;
            } else {
                childAt = getChildAt(0);
                bt = i.bt(childAt);
                if (iH()) {
                    f = (-((float) i.by(childAt))) / ((float) i.bw(childAt));
                } else {
                    f = (-((float) i.bx(childAt))) / ((float) i.bv(childAt));
                }
            }
            m mVar = this.shb;
            if (mVar != null) {
                mVar.m(Integer.valueOf(bt), Float.valueOf(f));
            }
        }
        AppMethodBeat.o(110218);
        return b;
    }

    public final void gK(boolean z) {
        AppMethodBeat.i(110219);
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
                    AppMethodBeat.o(110219);
                    return;
                }
            }
        }
        AppMethodBeat.o(110219);
    }

    private final int bom() {
        int i = 0;
        AppMethodBeat.i(110220);
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
                    if ((top + childAt2.getRight()) / 2 == height) {
                        break;
                    }
                    i++;
                }
            }
            i = -1;
        }
        AppMethodBeat.o(110220);
        return i;
    }

    public final void a(RecyclerView recyclerView) {
        AppMethodBeat.i(110221);
        j.p(recyclerView, "recyclerView");
        ab.i(TAG, "LogStory: onItemsChanged");
        this.lqr = true;
        AppMethodBeat.o(110221);
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(110222);
        super.c(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.o(110222);
    }

    public final void d(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(110223);
        j.p(recyclerView, "recyclerView");
        ab.i(TAG, "LogStory: onItemsRemoved " + i + ", " + i2);
        super.d(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.o(110223);
    }

    public final void g(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(110224);
        j.p(recyclerView, "recyclerView");
        ab.i(TAG, "LogStory: onItemsUpdated " + i + ", " + i2);
        super.g(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.o(110224);
    }

    public final void bY(int i) {
        AppMethodBeat.i(110225);
        ab.i(TAG, "LogStory: scrollToPosition " + i + ' ' + bo.dpG());
        super.bY(i);
        m mVar = this.shb;
        if (mVar != null) {
            mVar.m(Integer.valueOf(i), Float.valueOf(0.0f));
            AppMethodBeat.o(110225);
            return;
        }
        AppMethodBeat.o(110225);
    }
}
