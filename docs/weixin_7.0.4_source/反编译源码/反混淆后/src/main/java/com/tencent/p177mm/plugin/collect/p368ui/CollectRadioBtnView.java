package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;

/* renamed from: com.tencent.mm.plugin.collect.ui.CollectRadioBtnView */
public class CollectRadioBtnView extends LinearLayout {
    private TextView iDT;
    private ImageView kHC;

    public CollectRadioBtnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(41329);
        init(context);
        AppMethodBeat.m2505o(41329);
    }

    public CollectRadioBtnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(41330);
        init(context);
        AppMethodBeat.m2505o(41330);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(41331);
        View inflate = C5616v.m8409hu(context).inflate(2130969158, this);
        this.kHC = (ImageView) inflate.findViewById(2131822840);
        this.iDT = (TextView) inflate.findViewById(2131821185);
        AppMethodBeat.m2505o(41331);
    }

    public void setTitleText(String str) {
        AppMethodBeat.m2504i(41332);
        this.iDT.setText(str);
        AppMethodBeat.m2505o(41332);
    }

    public void setRadioSrc(int i) {
        AppMethodBeat.m2504i(41333);
        this.kHC.setImageResource(i);
        AppMethodBeat.m2505o(41333);
    }
}
