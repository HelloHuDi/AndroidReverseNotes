package com.tencent.p177mm.plugin.story.p536ui.view.gallery;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.WebView;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "orientation", "", "(I)V", "bounds", "Landroid/graphics/Rect;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "getOrientation", "()I", "drawHorizontal", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.b */
public final class C35247b extends C25373h {
    public static final C35246a snC = new C35246a();
    private final Drawable gAf = new ColorDrawable(WebView.NIGHT_MODE_COLOR);
    private final int orientation;
    private final Rect snA = new Rect();
    private int snB = C1338a.fromDPToPix(C4996ah.getContext(), 16);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration$Companion;", "", "()V", "Horizontal", "", "Vertical", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.b$a */
    public static final class C35246a {
        private C35246a() {
        }

        public /* synthetic */ C35246a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(110707);
        AppMethodBeat.m2505o(110707);
    }

    public C35247b(int i) {
        AppMethodBeat.m2504i(110706);
        this.orientation = i;
        AppMethodBeat.m2505o(110706);
    }

    /* renamed from: a */
    public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
        int i = 0;
        AppMethodBeat.m2504i(110704);
        C25052j.m39376p(canvas, "c");
        C25052j.m39376p(recyclerView, "parent");
        int paddingLeft;
        int width;
        int childCount;
        View childAt;
        int i2;
        int round;
        if (recyclerView.getLayoutManager() == null) {
            AppMethodBeat.m2505o(110704);
        } else if (this.orientation == 1) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                paddingLeft = recyclerView.getPaddingLeft();
                width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                width = recyclerView.getWidth();
                paddingLeft = 0;
            }
            childCount = recyclerView.getChildCount();
            while (i < childCount) {
                childAt = recyclerView.getChildAt(i);
                RecyclerView.m72551d(childAt, this.snA);
                i2 = this.snA.bottom;
                C25052j.m39375o(childAt, "child");
                round = Math.round(childAt.getTranslationY()) + i2;
                this.gAf.setBounds(paddingLeft, round - this.snB, width, round);
                this.gAf.draw(canvas);
                i++;
            }
            canvas.restore();
            AppMethodBeat.m2505o(110704);
        } else {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                paddingLeft = recyclerView.getPaddingTop();
                width = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), paddingLeft, recyclerView.getWidth() - recyclerView.getPaddingRight(), width);
            } else {
                width = recyclerView.getHeight();
                paddingLeft = 0;
            }
            childCount = recyclerView.getChildCount();
            while (i < childCount) {
                childAt = recyclerView.getChildAt(i);
                recyclerView.getLayoutManager();
                C17480i.m27157d(childAt, this.snA);
                i2 = this.snA.right;
                C25052j.m39375o(childAt, "child");
                round = Math.round(childAt.getTranslationX()) + i2;
                this.gAf.setBounds(round - this.snB, paddingLeft, round, width);
                this.gAf.draw(canvas);
                i++;
            }
            canvas.restore();
            AppMethodBeat.m2505o(110704);
        }
    }

    /* renamed from: a */
    public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
        int itemCount;
        AppMethodBeat.m2504i(110705);
        C25052j.m39376p(rect, "outRect");
        C25052j.m39376p(view, "view");
        C25052j.m39376p(recyclerView, "parent");
        C25052j.m39376p(c31880s, "state");
        int bt = recyclerView.getLayoutManager() != null ? C17480i.m27148bt(view) : -1;
        C17480i layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            itemCount = layoutManager.getItemCount();
        } else {
            itemCount = 0;
        }
        itemCount--;
        if (bt < 0) {
            AppMethodBeat.m2505o(110705);
            return;
        }
        if (itemCount > bt) {
            if (this.orientation == 0) {
                rect.set(0, 0, this.snB, 0);
                AppMethodBeat.m2505o(110705);
                return;
            }
            rect.set(0, 0, 0, this.snB);
        }
        AppMethodBeat.m2505o(110705);
    }
}
