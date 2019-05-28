package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.v;

public class CollectRadioBtnView extends LinearLayout {
    private TextView iDT;
    private ImageView kHC;

    public CollectRadioBtnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41329);
        init(context);
        AppMethodBeat.o(41329);
    }

    public CollectRadioBtnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(41330);
        init(context);
        AppMethodBeat.o(41330);
    }

    private void init(Context context) {
        AppMethodBeat.i(41331);
        View inflate = v.hu(context).inflate(R.layout.oz, this);
        this.kHC = (ImageView) inflate.findViewById(R.id.ay2);
        this.iDT = (TextView) inflate.findViewById(R.id.qm);
        AppMethodBeat.o(41331);
    }

    public void setTitleText(String str) {
        AppMethodBeat.i(41332);
        this.iDT.setText(str);
        AppMethodBeat.o(41332);
    }

    public void setRadioSrc(int i) {
        AppMethodBeat.i(41333);
        this.kHC.setImageResource(i);
        AppMethodBeat.o(41333);
    }
}
