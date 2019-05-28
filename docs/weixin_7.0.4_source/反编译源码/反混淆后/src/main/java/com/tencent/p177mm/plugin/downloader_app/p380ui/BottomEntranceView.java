package com.tencent.p177mm.plugin.downloader_app.p380ui;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a.C27701f;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.downloader_app.p1646c.C45838a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView */
public class BottomEntranceView extends RelativeLayout {
    private C27701f kPP;
    private TextView kPQ;
    private int kPR;
    private int kPS;

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView$1 */
    class C203451 implements OnGlobalLayoutListener {
        C203451() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(136209);
            BottomEntranceView.m44032a(BottomEntranceView.this);
            AppMethodBeat.m2505o(136209);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView$2 */
    class C203462 implements OnClickListener {
        C203462() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(136210);
            if (!(BottomEntranceView.this.kPP == null || C5046bo.isNullOrNil(BottomEntranceView.this.kPP.kdF))) {
                Bundle bundle = new Bundle();
                bundle.putString("rawUrl", BottomEntranceView.this.kPP.kdF);
                ((C38855d) C1720g.m3528K(C38855d.class)).mo61733f(BottomEntranceView.this.getContext(), bundle);
                C45838a.m84850a(10, 1005, 1, 40, "", "", "");
            }
            AppMethodBeat.m2505o(136210);
        }
    }

    public BottomEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(136211);
        super.onFinishInflate();
        this.kPQ = (TextView) findViewById(2131823315);
        int displayHeight = getDisplayHeight();
        int de = C5230ak.m7987de(getContext());
        this.kPS = ((displayHeight - de) - C5230ak.getStatusBarHeight(getContext())) - C5230ak.m7988fr(getContext());
        this.kPR = getResources().getDimensionPixelSize(C25738R.dimen.f10214up);
        C4990ab.m7411d("MicroMsg.BottomEntranceView", "mContentH = %d", Integer.valueOf(this.kPS));
        getViewTreeObserver().addOnGlobalLayoutListener(new C203451());
        setOnClickListener(new C203462());
        AppMethodBeat.m2505o(136211);
    }

    public void setData(C27701f c27701f) {
        AppMethodBeat.m2504i(136212);
        if (c27701f == null || C5046bo.isNullOrNil(c27701f.desc) || C5046bo.isNullOrNil(c27701f.kdF)) {
            setVisibility(8);
            AppMethodBeat.m2505o(136212);
            return;
        }
        this.kPP = c27701f;
        setVisibility(0);
        this.kPQ.setText(this.kPP.desc);
        AppMethodBeat.m2505o(136212);
    }

    private int getDisplayHeight() {
        AppMethodBeat.m2504i(136213);
        int i = C5230ak.m7993hy(getContext()).y;
        AppMethodBeat.m2505o(136213);
        return i;
    }

    /* renamed from: a */
    static /* synthetic */ void m44032a(BottomEntranceView bottomEntranceView) {
        AppMethodBeat.m2504i(136214);
        if (bottomEntranceView.getVisibility() != 8) {
            for (ViewParent parent = bottomEntranceView.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof TaskListView) {
                    int computeVerticalScrollRange = ((TaskListView) parent).computeVerticalScrollRange();
                    LayoutParams layoutParams = (LayoutParams) bottomEntranceView.getLayoutParams();
                    if (computeVerticalScrollRange < bottomEntranceView.kPS) {
                        layoutParams.topMargin += bottomEntranceView.kPS - computeVerticalScrollRange;
                        bottomEntranceView.setLayoutParams(layoutParams);
                    } else if (computeVerticalScrollRange > bottomEntranceView.kPS) {
                        if (layoutParams.topMargin > bottomEntranceView.kPR) {
                            layoutParams.topMargin -= computeVerticalScrollRange - bottomEntranceView.kPS;
                            bottomEntranceView.setLayoutParams(layoutParams);
                        } else if (layoutParams.topMargin < bottomEntranceView.kPR) {
                            layoutParams.topMargin = bottomEntranceView.kPR;
                            bottomEntranceView.setLayoutParams(layoutParams);
                        }
                    }
                    C4990ab.m7411d("MicroMsg.BottomEntranceView", "listH = %d, mContentH = %d, topMargin = %d, bottomMargin = %d", Integer.valueOf(computeVerticalScrollRange), Integer.valueOf(bottomEntranceView.kPS), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.bottomMargin));
                    AppMethodBeat.m2505o(136214);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(136214);
    }
}
