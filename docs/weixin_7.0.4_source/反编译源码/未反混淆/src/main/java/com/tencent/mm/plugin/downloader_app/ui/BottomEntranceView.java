package com.tencent.mm.plugin.downloader_app.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ak;

public class BottomEntranceView extends RelativeLayout {
    private f kPP;
    private TextView kPQ;
    private int kPR;
    private int kPS;

    public BottomEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(136211);
        super.onFinishInflate();
        this.kPQ = (TextView) findViewById(R.id.b_w);
        int displayHeight = getDisplayHeight();
        int de = ak.de(getContext());
        this.kPS = ((displayHeight - de) - ak.getStatusBarHeight(getContext())) - ak.fr(getContext());
        this.kPR = getResources().getDimensionPixelSize(R.dimen.up);
        ab.d("MicroMsg.BottomEntranceView", "mContentH = %d", Integer.valueOf(this.kPS));
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(136209);
                BottomEntranceView.a(BottomEntranceView.this);
                AppMethodBeat.o(136209);
            }
        });
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(136210);
                if (!(BottomEntranceView.this.kPP == null || bo.isNullOrNil(BottomEntranceView.this.kPP.kdF))) {
                    Bundle bundle = new Bundle();
                    bundle.putString("rawUrl", BottomEntranceView.this.kPP.kdF);
                    ((d) g.K(d.class)).f(BottomEntranceView.this.getContext(), bundle);
                    a.a(10, 1005, 1, 40, "", "", "");
                }
                AppMethodBeat.o(136210);
            }
        });
        AppMethodBeat.o(136211);
    }

    public void setData(f fVar) {
        AppMethodBeat.i(136212);
        if (fVar == null || bo.isNullOrNil(fVar.desc) || bo.isNullOrNil(fVar.kdF)) {
            setVisibility(8);
            AppMethodBeat.o(136212);
            return;
        }
        this.kPP = fVar;
        setVisibility(0);
        this.kPQ.setText(this.kPP.desc);
        AppMethodBeat.o(136212);
    }

    private int getDisplayHeight() {
        AppMethodBeat.i(136213);
        int i = ak.hy(getContext()).y;
        AppMethodBeat.o(136213);
        return i;
    }

    static /* synthetic */ void a(BottomEntranceView bottomEntranceView) {
        AppMethodBeat.i(136214);
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
                    ab.d("MicroMsg.BottomEntranceView", "listH = %d, mContentH = %d, topMargin = %d, bottomMargin = %d", Integer.valueOf(computeVerticalScrollRange), Integer.valueOf(bottomEntranceView.kPS), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.bottomMargin));
                    AppMethodBeat.o(136214);
                    return;
                }
            }
        }
        AppMethodBeat.o(136214);
    }
}
