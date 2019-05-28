package com.tencent.p177mm.plugin.sight.draft.p1021ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelvideo.C9716j;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sight.draft.p1021ui.C46921b.C29020d;

/* renamed from: com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView */
public class SightDraftContainerView extends ListView {
    private boolean qzQ;
    private C39714a qzR;
    C46921b qzS;

    /* renamed from: com.tencent.mm.plugin.sight.draft.ui.SightDraftContainerView$1 */
    class C218481 implements OnTouchListener {
        C218481() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(25015);
            SightDraftContainerView sightDraftContainerView = SightDraftContainerView.this;
            if (sightDraftContainerView.qzS != null) {
                C46921b c46921b = sightDraftContainerView.qzS;
                c46921b.mo76131a(null);
                c46921b.qzv.clw();
            }
            AppMethodBeat.m2505o(25015);
            return false;
        }
    }

    public SightDraftContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(25016);
        init();
        AppMethodBeat.m2505o(25016);
    }

    public SightDraftContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(25017);
        init();
        AppMethodBeat.m2505o(25017);
    }

    public SightDraftContainerView(Context context) {
        super(context);
        AppMethodBeat.m2504i(25018);
        init();
        AppMethodBeat.m2505o(25018);
    }

    private void init() {
        AppMethodBeat.m2504i(25019);
        setBackgroundColor(getResources().getColor(C25738R.color.f11782h4));
        setSelector(C25738R.color.a3p);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        TextView textView = new TextView(getContext());
        textView.setText(C25738R.string.ei8);
        textView.setTextSize(0, (float) C1338a.m2856al(getContext(), C25738R.dimen.f9936kr));
        textView.setGravity(17);
        textView.setTextColor(getResources().getColor(C25738R.color.f12093s1));
        textView.setTextSize(1, 11.0f);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        addFooterView(textView);
        setOnTouchListener(new C218481());
        AppMethodBeat.m2505o(25019);
    }

    public void setTipsResId(int i) {
        if (this.qzS != null) {
            this.qzS.qzB = i;
        }
    }

    public final void clx() {
        AppMethodBeat.m2504i(25020);
        if (this.qzQ) {
            this.qzS.qzC = 12;
            this.qzS.mo76132a(C29020d.NORMAL, false);
            this.qzS.mo5248a(null, null);
            setSelection(0);
            AppMethodBeat.m2505o(25020);
            return;
        }
        this.qzQ = true;
        this.qzS = new C46921b(getContext(), this.qzR);
        this.qzS.qzC = 12;
        setAdapter(this.qzS);
        AppMethodBeat.m2505o(25020);
    }

    public void setSightDraftCallback(C39714a c39714a) {
        this.qzR = c39714a;
        if (this.qzS != null) {
            this.qzS.qzA = c39714a;
        }
    }

    public C9716j getLastDrafInfo() {
        C46921b c46921b = this.qzS;
        if (c46921b.qzG == null) {
            return null;
        }
        return c46921b.qzG.qzO;
    }
}
