package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class SummaryBelowPreference extends Preference {
    private View mView;

    public SummaryBelowPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SummaryBelowPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107290);
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(107290);
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107291);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, R.layout.ag7, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.o(107291);
        return view;
    }
}
