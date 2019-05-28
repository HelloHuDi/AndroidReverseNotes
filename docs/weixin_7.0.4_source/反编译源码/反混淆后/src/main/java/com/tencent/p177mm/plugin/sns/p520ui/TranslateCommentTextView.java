package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.TranslateCommentTextView */
public class TranslateCommentTextView extends LinearLayout {
    public MaskTextView rDZ;
    public SnsTranslateResultView rrm;

    public TranslateCommentTextView(Context context) {
        super(context);
        AppMethodBeat.m2504i(39904);
        init();
        AppMethodBeat.m2505o(39904);
    }

    public TranslateCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(39905);
        init();
        AppMethodBeat.m2505o(39905);
    }

    private void init() {
        AppMethodBeat.m2504i(39906);
        LayoutInflater.from(getContext()).inflate(2130970925, this);
        this.rDZ = (MaskTextView) findViewById(2131828231);
        this.rrm = (SnsTranslateResultView) findViewById(2131827715);
        this.rrm.setVisibility(8);
        AppMethodBeat.m2505o(39906);
    }

    public TextView getOriginCommentTextView() {
        return this.rDZ;
    }

    public SnsTranslateResultView getTranslateResultView() {
        return this.rrm;
    }
}
