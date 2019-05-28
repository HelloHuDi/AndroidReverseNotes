package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.plugin.sight.draft.ui.b.d;

public class SightDraftContainerView extends ListView {
    private boolean qzQ;
    private a qzR;
    b qzS;

    public SightDraftContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(25016);
        init();
        AppMethodBeat.o(25016);
    }

    public SightDraftContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(25017);
        init();
        AppMethodBeat.o(25017);
    }

    public SightDraftContainerView(Context context) {
        super(context);
        AppMethodBeat.i(25018);
        init();
        AppMethodBeat.o(25018);
    }

    private void init() {
        AppMethodBeat.i(25019);
        setBackgroundColor(getResources().getColor(R.color.h4));
        setSelector(R.color.a3p);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nc);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.l5);
        TextView textView = new TextView(getContext());
        textView.setText(R.string.ei8);
        textView.setTextSize(0, (float) a.al(getContext(), R.dimen.kr));
        textView.setGravity(17);
        textView.setTextColor(getResources().getColor(R.color.s1));
        textView.setTextSize(1, 11.0f);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        addFooterView(textView);
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(25015);
                SightDraftContainerView sightDraftContainerView = SightDraftContainerView.this;
                if (sightDraftContainerView.qzS != null) {
                    b bVar = sightDraftContainerView.qzS;
                    bVar.a(null);
                    bVar.qzv.clw();
                }
                AppMethodBeat.o(25015);
                return false;
            }
        });
        AppMethodBeat.o(25019);
    }

    public void setTipsResId(int i) {
        if (this.qzS != null) {
            this.qzS.qzB = i;
        }
    }

    public final void clx() {
        AppMethodBeat.i(25020);
        if (this.qzQ) {
            this.qzS.qzC = 12;
            this.qzS.a(d.NORMAL, false);
            this.qzS.a(null, null);
            setSelection(0);
            AppMethodBeat.o(25020);
            return;
        }
        this.qzQ = true;
        this.qzS = new b(getContext(), this.qzR);
        this.qzS.qzC = 12;
        setAdapter(this.qzS);
        AppMethodBeat.o(25020);
    }

    public void setSightDraftCallback(a aVar) {
        this.qzR = aVar;
        if (this.qzS != null) {
            this.qzS.qzA = aVar;
        }
    }

    public j getLastDrafInfo() {
        b bVar = this.qzS;
        if (bVar.qzG == null) {
            return null;
        }
        return bVar.qzG.qzO;
    }
}
