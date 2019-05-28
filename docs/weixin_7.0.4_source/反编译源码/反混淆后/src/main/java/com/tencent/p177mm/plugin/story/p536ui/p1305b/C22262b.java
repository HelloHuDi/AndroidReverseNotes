package com.tencent.p177mm.plugin.story.p536ui.p1305b;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0005H\u0002J\"\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-H\u0016J \u00101\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0016J \u00102\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0012\u00103\u001a\u00020\u00172\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0005H\u0016J$\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\n\u00109\u001a\u00060:R\u00020-2\u0006\u00104\u001a\u000205H\u0016J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J$\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\n\u00109\u001a\u00060:R\u00020-2\u0006\u00104\u001a\u000205H\u0016J\b\u0010>\u001a\u00020\u0017H\u0002J\u0010\u0010?\u001a\u00020\u00172\b\b\u0002\u0010@\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRL\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRL\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR\u000e\u0010!\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R$\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006B"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "forceUpdateOnNextLayout", "isScrollEnabled", "()Z", "setScrollEnabled", "(Z)V", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollCallback", "", "offset", "getScrollCallback", "setScrollCallback", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "onItemsAdded", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "positionStart", "itemCount", "onItemsChanged", "onItemsRemoved", "onItemsUpdated", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "scrollToPosition", "scrollVerticallyBy", "dy", "updateScroll", "updateSelectedChild", "force", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.b.b */
public final class C22262b extends LinearLayoutManager {
    private static final String TAG = TAG;
    public static final C22263a shd = new C22263a();
    public int llU;
    private int lqq;
    private boolean lqr;
    public C31591m<? super Integer, ? super View, C37091y> lqs;
    public C31591m<? super Integer, ? super Float, C37091y> shb;
    public boolean shc;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.b.b$a */
    public static final class C22263a {
        private C22263a() {
        }

        public /* synthetic */ C22263a(byte b) {
            this();
        }
    }

    private C22262b(Context context, int i) {
        C25052j.m39376p(context, "context");
        super(i);
        AppMethodBeat.m2504i(110226);
        this.llU = -1;
        this.shc = true;
        AppMethodBeat.m2505o(110226);
    }

    public C22262b(Context context, int i, byte b) {
        C25052j.m39376p(context, "context");
        this(context, i);
        AppMethodBeat.m2504i(110227);
        AppMethodBeat.m2505o(110227);
    }

    public C22262b(Context context) {
        C25052j.m39376p(context, "context");
        this(context, 1, (byte) 0);
        AppMethodBeat.m2504i(110228);
        AppMethodBeat.m2505o(110228);
    }

    static {
        AppMethodBeat.m2504i(110229);
        AppMethodBeat.m2505o(110229);
    }

    /* renamed from: iG */
    public final boolean mo1776iG() {
        AppMethodBeat.m2504i(110213);
        if (this.shc && super.mo1776iG()) {
            AppMethodBeat.m2505o(110213);
            return true;
        }
        AppMethodBeat.m2505o(110213);
        return false;
    }

    /* renamed from: iH */
    public final boolean mo1777iH() {
        AppMethodBeat.m2504i(110214);
        if (this.shc && getItemCount() > 1 && super.mo1777iH()) {
            AppMethodBeat.m2505o(110214);
            return true;
        }
        AppMethodBeat.m2505o(110214);
        return false;
    }

    /* renamed from: a */
    public final void mo1753a(C31880s c31880s) {
        AppMethodBeat.m2504i(110215);
        C4990ab.m7416i(TAG, "LogStory: onLayoutCompleted");
        super.mo1753a(c31880s);
        mo37786gK(this.lqr);
        this.lqr = false;
        AppMethodBeat.m2505o(110215);
    }

    /* renamed from: cm */
    public final void mo15124cm(int i) {
        AppMethodBeat.m2504i(110216);
        C4990ab.m7416i(TAG, "LogStory: onScrollStateChanged ".concat(String.valueOf(i)));
        super.mo15124cm(i);
        this.lqq = i;
        if (this.lqq == 0) {
            mo37786gK(false);
        }
        AppMethodBeat.m2505o(110216);
    }

    /* renamed from: a */
    public final int mo1746a(int i, C25374o c25374o, C31880s c31880s) {
        AppMethodBeat.m2504i(110217);
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
            C4990ab.m7416i(TAG, "horizontal Drag to end, " + i + ' ' + a + ", " + recyclerView);
            if (recyclerView != null) {
                recyclerView.mo66403jm();
            }
        }
        AppMethodBeat.m2505o(110217);
        return a;
    }

    /* renamed from: b */
    public final int mo1759b(int i, C25374o c25374o, C31880s c31880s) {
        View childAt;
        AppMethodBeat.m2504i(110218);
        C25052j.m39376p(c25374o, "recycler");
        C25052j.m39376p(c31880s, "state");
        int b = super.mo1759b(i, c25374o, c31880s);
        C4990ab.m7416i(TAG, "LogStory: vertical " + i + ' ' + b);
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
            C4990ab.m7416i(TAG, "vertical Drag to end, " + i + ' ' + b + ", " + recyclerView);
            if (recyclerView != null) {
                recyclerView.mo66403jm();
            }
        }
        if (getChildCount() != 0) {
            int bt;
            float f;
            if (getChildCount() == 1) {
                bt = C17480i.m27148bt(getChildAt(0));
                f = 0.0f;
            } else {
                childAt = getChildAt(0);
                bt = C17480i.m27148bt(childAt);
                if (mo1777iH()) {
                    f = (-((float) C17480i.m27152by(childAt))) / ((float) C17480i.m27150bw(childAt));
                } else {
                    f = (-((float) C17480i.m27151bx(childAt))) / ((float) C17480i.m27149bv(childAt));
                }
            }
            C31591m c31591m = this.shb;
            if (c31591m != null) {
                c31591m.mo212m(Integer.valueOf(bt), Float.valueOf(f));
            }
        }
        AppMethodBeat.m2505o(110218);
        return b;
    }

    /* renamed from: gK */
    public final void mo37786gK(boolean z) {
        AppMethodBeat.m2504i(110219);
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
                    AppMethodBeat.m2505o(110219);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(110219);
    }

    private final int bom() {
        int i = 0;
        AppMethodBeat.m2504i(110220);
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
                    if ((top + childAt2.getRight()) / 2 == height) {
                        break;
                    }
                    i++;
                }
            }
            i = -1;
        }
        AppMethodBeat.m2505o(110220);
        return i;
    }

    /* renamed from: a */
    public final void mo15122a(RecyclerView recyclerView) {
        AppMethodBeat.m2504i(110221);
        C25052j.m39376p(recyclerView, "recyclerView");
        C4990ab.m7416i(TAG, "LogStory: onItemsChanged");
        this.lqr = true;
        AppMethodBeat.m2505o(110221);
    }

    /* renamed from: c */
    public final void mo15123c(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(110222);
        super.mo15123c(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.m2505o(110222);
    }

    /* renamed from: d */
    public final void mo15125d(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(110223);
        C25052j.m39376p(recyclerView, "recyclerView");
        C4990ab.m7416i(TAG, "LogStory: onItemsRemoved " + i + ", " + i2);
        super.mo15125d(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.m2505o(110223);
    }

    /* renamed from: g */
    public final void mo15126g(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(110224);
        C25052j.m39376p(recyclerView, "recyclerView");
        C4990ab.m7416i(TAG, "LogStory: onItemsUpdated " + i + ", " + i2);
        super.mo15126g(recyclerView, i, i2);
        if (this.llU >= i && this.llU < i + i2) {
            this.lqr = true;
        }
        AppMethodBeat.m2505o(110224);
    }

    /* renamed from: bY */
    public final void mo1762bY(int i) {
        AppMethodBeat.m2504i(110225);
        C4990ab.m7416i(TAG, "LogStory: scrollToPosition " + i + ' ' + C5046bo.dpG());
        super.mo1762bY(i);
        C31591m c31591m = this.shb;
        if (c31591m != null) {
            c31591m.mo212m(Integer.valueOf(i), Float.valueOf(0.0f));
            AppMethodBeat.m2505o(110225);
            return;
        }
        AppMethodBeat.m2505o(110225);
    }
}
