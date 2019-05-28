package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class TranslateCommentTextView extends LinearLayout {
    public MaskTextView rDZ;
    public SnsTranslateResultView rrm;

    public TranslateCommentTextView(Context context) {
        super(context);
        AppMethodBeat.i(39904);
        init();
        AppMethodBeat.o(39904);
    }

    public TranslateCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39905);
        init();
        AppMethodBeat.o(39905);
    }

    private void init() {
        AppMethodBeat.i(39906);
        LayoutInflater.from(getContext()).inflate(R.layout.azm, this);
        this.rDZ = (MaskTextView) findViewById(R.id.evs);
        this.rrm = (SnsTranslateResultView) findViewById(R.id.ehu);
        this.rrm.setVisibility(8);
        AppMethodBeat.o(39906);
    }

    public TextView getOriginCommentTextView() {
        return this.rDZ;
    }

    public SnsTranslateResultView getTranslateResultView() {
        return this.rrm;
    }
}
