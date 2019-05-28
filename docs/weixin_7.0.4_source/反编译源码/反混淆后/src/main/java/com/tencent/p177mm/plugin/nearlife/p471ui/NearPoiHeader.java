package com.tencent.p177mm.plugin.nearlife.p471ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.nearlife.ui.NearPoiHeader */
public class NearPoiHeader extends LinearLayout {
    private TextView hrg;
    private ImageView olT;

    @TargetApi(11)
    public NearPoiHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(22994);
        init(context);
        AppMethodBeat.m2505o(22994);
    }

    public NearPoiHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(22995);
        init(context);
        AppMethodBeat.m2505o(22995);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(22996);
        View inflate = View.inflate(context, 2130970281, this);
        this.olT = (ImageView) inflate.findViewById(2131826276);
        this.hrg = (TextView) inflate.findViewById(2131826277);
        AppMethodBeat.m2505o(22996);
    }

    public void setText(CharSequence charSequence) {
        AppMethodBeat.m2504i(22997);
        this.hrg.setText(charSequence);
        AppMethodBeat.m2505o(22997);
    }
}
