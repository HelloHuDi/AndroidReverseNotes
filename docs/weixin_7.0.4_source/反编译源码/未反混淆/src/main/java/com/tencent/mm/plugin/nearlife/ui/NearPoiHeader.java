package com.tencent.mm.plugin.nearlife.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class NearPoiHeader extends LinearLayout {
    private TextView hrg;
    private ImageView olT;

    @TargetApi(11)
    public NearPoiHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(22994);
        init(context);
        AppMethodBeat.o(22994);
    }

    public NearPoiHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(22995);
        init(context);
        AppMethodBeat.o(22995);
    }

    private void init(Context context) {
        AppMethodBeat.i(22996);
        View inflate = View.inflate(context, R.layout.ai_, this);
        this.olT = (ImageView) inflate.findViewById(R.id.dfy);
        this.hrg = (TextView) inflate.findViewById(R.id.dfz);
        AppMethodBeat.o(22996);
    }

    public void setText(CharSequence charSequence) {
        AppMethodBeat.i(22997);
        this.hrg.setText(charSequence);
        AppMethodBeat.o(22997);
    }
}
