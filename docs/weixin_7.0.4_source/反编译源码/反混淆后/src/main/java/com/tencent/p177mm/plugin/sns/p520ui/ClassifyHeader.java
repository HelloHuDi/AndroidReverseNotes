package com.tencent.p177mm.plugin.sns.p520ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.ClassifyHeader */
public class ClassifyHeader extends LinearLayout {
    private TextView hrg;
    private Context mContext;
    private ImageView olT;

    @TargetApi(11)
    public ClassifyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(38194);
        init(context);
        AppMethodBeat.m2505o(38194);
    }

    public ClassifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38195);
        init(context);
        AppMethodBeat.m2505o(38195);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(38196);
        this.mContext = context;
        View inflate = View.inflate(this.mContext, 2130969138, this);
        this.olT = (ImageView) inflate.findViewById(2131822757);
        this.hrg = (TextView) inflate.findViewById(2131822758);
        AppMethodBeat.m2505o(38196);
    }

    public void setDesc(String str) {
        AppMethodBeat.m2504i(38197);
        this.hrg.setText(String.valueOf(str));
        AppMethodBeat.m2505o(38197);
    }
}
