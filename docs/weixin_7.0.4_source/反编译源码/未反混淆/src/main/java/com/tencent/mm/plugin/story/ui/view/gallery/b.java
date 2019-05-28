package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.smtt.sdk.WebView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\"\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "orientation", "", "(I)V", "bounds", "Landroid/graphics/Rect;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "getOrientation", "()I", "drawHorizontal", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Companion", "plugin-story_release"})
public final class b extends h {
    public static final a snC = new a();
    private final Drawable gAf = new ColorDrawable(WebView.NIGHT_MODE_COLOR);
    private final int orientation;
    private final Rect snA = new Rect();
    private int snB = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 16);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration$Companion;", "", "()V", "Horizontal", "", "Vertical", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(110707);
        AppMethodBeat.o(110707);
    }

    public b(int i) {
        AppMethodBeat.i(110706);
        this.orientation = i;
        AppMethodBeat.o(110706);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, s sVar) {
        int i = 0;
        AppMethodBeat.i(110704);
        j.p(canvas, "c");
        j.p(recyclerView, "parent");
        int paddingLeft;
        int width;
        int childCount;
        View childAt;
        int i2;
        int round;
        if (recyclerView.getLayoutManager() == null) {
            AppMethodBeat.o(110704);
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
                RecyclerView.d(childAt, this.snA);
                i2 = this.snA.bottom;
                j.o(childAt, "child");
                round = Math.round(childAt.getTranslationY()) + i2;
                this.gAf.setBounds(paddingLeft, round - this.snB, width, round);
                this.gAf.draw(canvas);
                i++;
            }
            canvas.restore();
            AppMethodBeat.o(110704);
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
                i.d(childAt, this.snA);
                i2 = this.snA.right;
                j.o(childAt, "child");
                round = Math.round(childAt.getTranslationX()) + i2;
                this.gAf.setBounds(round - this.snB, paddingLeft, round, width);
                this.gAf.draw(canvas);
                i++;
            }
            canvas.restore();
            AppMethodBeat.o(110704);
        }
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
        int itemCount;
        AppMethodBeat.i(110705);
        j.p(rect, "outRect");
        j.p(view, "view");
        j.p(recyclerView, "parent");
        j.p(sVar, "state");
        int bt = recyclerView.getLayoutManager() != null ? i.bt(view) : -1;
        i layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            itemCount = layoutManager.getItemCount();
        } else {
            itemCount = 0;
        }
        itemCount--;
        if (bt < 0) {
            AppMethodBeat.o(110705);
            return;
        }
        if (itemCount > bt) {
            if (this.orientation == 0) {
                rect.set(0, 0, this.snB, 0);
                AppMethodBeat.o(110705);
                return;
            }
            rect.set(0, 0, 0, this.snB);
        }
        AppMethodBeat.o(110705);
    }
}
