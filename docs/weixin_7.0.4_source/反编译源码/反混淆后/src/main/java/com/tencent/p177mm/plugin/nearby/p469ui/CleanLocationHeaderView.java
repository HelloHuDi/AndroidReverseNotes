package com.tencent.p177mm.plugin.nearby.p469ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;

/* renamed from: com.tencent.mm.plugin.nearby.ui.CleanLocationHeaderView */
public class CleanLocationHeaderView extends LinearLayout {
    private ImageView iyo;
    private TextView oPI;

    public CleanLocationHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(55408);
        m56746cA(context);
        AppMethodBeat.m2505o(55408);
    }

    public CleanLocationHeaderView(Context context) {
        super(context);
        AppMethodBeat.m2504i(55409);
        m56746cA(context);
        AppMethodBeat.m2505o(55409);
    }

    /* renamed from: cA */
    private void m56746cA(Context context) {
        AppMethodBeat.m2504i(55410);
        View inflate = View.inflate(context, 2130970286, this);
        this.oPI = (TextView) inflate.findViewById(2131826295);
        this.oPI.setSingleLine(false);
        this.iyo = (ImageView) inflate.findViewById(2131826294);
        this.oPI.setText(C25738R.string.aq6);
        this.iyo.setImageResource(C1318a.peoplenearby_icon);
        AppMethodBeat.m2505o(55410);
    }
}
