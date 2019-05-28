package com.tencent.p177mm.emoji.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0016J0\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/emoji/view/InsectFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "insectCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bottom", "", "getInsectCallback", "()Lkotlin/jvm/functions/Function1;", "setInsectCallback", "(Lkotlin/jvm/functions/Function1;)V", "positionInWindow", "", "visibleRect", "Landroid/graphics/Rect;", "insectBottom", "onLayout", "", "changed", "left", "top", "right", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.view.InsectFrameLayout */
public class InsectFrameLayout extends FrameLayout {
    private final String TAG;
    private Rect eAp;
    private int[] eAq;
    private C17126b<? super Integer, Boolean> eAr;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.emoji.view.InsectFrameLayout$a */
    static final class C1519a implements Runnable {
        final /* synthetic */ InsectFrameLayout eAs;
        final /* synthetic */ int eAt;

        C1519a(InsectFrameLayout insectFrameLayout, int i) {
            this.eAs = insectFrameLayout;
            this.eAt = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(63317);
            this.eAs.setPadding(this.eAs.getPaddingLeft(), this.eAs.getPaddingTop(), this.eAs.getPaddingRight(), this.eAt);
            this.eAs.requestLayout();
            AppMethodBeat.m2505o(63317);
        }
    }

    public InsectFrameLayout(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(63319);
        this.TAG = "MicroMsg.InsectLayout";
        this.eAp = new Rect();
        this.eAq = new int[2];
        AppMethodBeat.m2505o(63319);
    }

    public InsectFrameLayout(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(63320);
        AppMethodBeat.m2505o(63320);
    }

    public final C17126b<Integer, Boolean> getInsectCallback() {
        return this.eAr;
    }

    public final void setInsectCallback(C17126b<? super Integer, Boolean> c17126b) {
        this.eAr = c17126b;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(63318);
        C4990ab.m7416i(this.TAG, "InsectFrameLayout onLayout");
        getWindowVisibleDisplayFrame(this.eAp);
        getLocationOnScreen(this.eAq);
        int i5 = ((i4 - i2) + this.eAq[1]) - this.eAp.bottom;
        boolean z2 = false;
        if (this.eAr != null) {
            C17126b c17126b = this.eAr;
            if (c17126b == null) {
                C25052j.dWJ();
            }
            z2 = ((Boolean) c17126b.mo50am(Integer.valueOf(i5))).booleanValue();
        }
        if (!(z2 || getPaddingBottom() == i5)) {
            post(new C1519a(this, i5));
        }
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(63318);
    }
}
