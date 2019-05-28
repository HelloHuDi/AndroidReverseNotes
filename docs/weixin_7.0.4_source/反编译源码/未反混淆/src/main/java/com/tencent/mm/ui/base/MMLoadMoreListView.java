package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class MMLoadMoreListView extends ListView {
    private View kZq = null;
    private a yvO = null;
    private boolean yvP = false;
    private TextView yvQ;
    private boolean yvR = false;

    public interface a {
        void KB();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106688);
        init();
        AppMethodBeat.o(106688);
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106689);
        init();
        AppMethodBeat.o(106689);
    }

    private void ctT() {
        AppMethodBeat.i(106690);
        this.kZq = View.inflate(getContext(), R.layout.adp, null);
        this.yvQ = (TextView) this.kZq.findViewById(R.id.d9f);
        this.kZq.setVisibility(8);
        AppMethodBeat.o(106690);
    }

    private void init() {
        AppMethodBeat.i(106691);
        if (this.kZq == null) {
            ctT();
            addFooterView(this.kZq);
            this.kZq.setVisibility(8);
        }
        AppMethodBeat.o(106691);
    }

    public final void dzM() {
        AppMethodBeat.i(106692);
        if (this.kZq == null) {
            ctT();
        }
        try {
            removeFooterView(this.kZq);
            addFooterView(this.kZq);
            AppMethodBeat.o(106692);
        } catch (Exception e) {
            AppMethodBeat.o(106692);
        }
    }

    public void setOnLoadMoreListener(a aVar) {
        this.yvO = aVar;
    }

    public final void dzN() {
        AppMethodBeat.i(106693);
        this.yvP = true;
        setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(106686);
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && MMLoadMoreListView.this.yvO != null) {
                    MMLoadMoreListView.this.yvO.KB();
                }
                AppMethodBeat.o(106686);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(106687);
                if (i == 0 && MMLoadMoreListView.this.getChildAt(0) != null && MMLoadMoreListView.this.getChildAt(0).getTop() == MMLoadMoreListView.this.getPaddingTop()) {
                    MMLoadMoreListView.this.yvR = true;
                } else {
                    MMLoadMoreListView.this.yvR = false;
                }
                ab.d("MMLoadMoreListView", "newpoi scroll2Top %s", MMLoadMoreListView.this.yvR);
                AppMethodBeat.o(106687);
            }
        });
        AppMethodBeat.o(106693);
    }

    public boolean getScroll2Top() {
        return this.yvR;
    }

    public void setOnFootrClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(106694);
        this.yvQ.setOnClickListener(onClickListener);
        AppMethodBeat.o(106694);
    }

    public void setFooterTips(String str) {
        AppMethodBeat.i(106695);
        this.yvQ.setText(str);
        AppMethodBeat.o(106695);
    }

    public final void dzO() {
        AppMethodBeat.i(106696);
        if (this.kZq != null) {
            this.yvQ.setVisibility(8);
            this.kZq.setVisibility(8);
        }
        AppMethodBeat.o(106696);
    }

    public final void dzP() {
        AppMethodBeat.i(106697);
        this.yvQ.setVisibility(0);
        this.kZq.setVisibility(0);
        AppMethodBeat.o(106697);
    }

    public final void dzQ() {
        AppMethodBeat.i(106698);
        removeFooterView(this.kZq);
        AppMethodBeat.o(106698);
    }
}
