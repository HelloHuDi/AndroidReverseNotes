package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class ClassifyHeader extends LinearLayout {
    private TextView hrg;
    private Context mContext;
    private ImageView olT;

    @TargetApi(11)
    public ClassifyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(38194);
        init(context);
        AppMethodBeat.o(38194);
    }

    public ClassifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38195);
        init(context);
        AppMethodBeat.o(38195);
    }

    private void init(Context context) {
        AppMethodBeat.i(38196);
        this.mContext = context;
        View inflate = View.inflate(this.mContext, R.layout.of, this);
        this.olT = (ImageView) inflate.findViewById(R.id.avt);
        this.hrg = (TextView) inflate.findViewById(R.id.avu);
        AppMethodBeat.o(38196);
    }

    public void setDesc(String str) {
        AppMethodBeat.i(38197);
        this.hrg.setText(String.valueOf(str));
        AppMethodBeat.o(38197);
    }
}
