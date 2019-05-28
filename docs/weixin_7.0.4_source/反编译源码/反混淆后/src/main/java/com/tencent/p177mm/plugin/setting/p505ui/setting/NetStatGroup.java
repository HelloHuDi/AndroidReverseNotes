package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.NetStatGroup */
public class NetStatGroup extends LinearLayout {
    LinearLayout qkU;
    final TextView qkV;

    public NetStatGroup(Context context) {
        this(context, null);
    }

    public NetStatGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(126965);
        View.inflate(context, 2130970294, this);
        this.qkU = (LinearLayout) findViewById(2131826032);
        this.qkV = (TextView) findViewById(2131820787);
        this.qkV.setTextSize(0, (float) context.getResources().getDimensionPixelSize(C25738R.dimen.f9936kr));
        AppMethodBeat.m2505o(126965);
    }
}
