package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class NetStatGroup extends LinearLayout {
    LinearLayout qkU;
    final TextView qkV;

    public NetStatGroup(Context context) {
        this(context, null);
    }

    public NetStatGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(126965);
        View.inflate(context, R.layout.aim, this);
        this.qkU = (LinearLayout) findViewById(R.id.d_c);
        this.qkV = (TextView) findViewById(R.id.fv);
        this.qkV.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.dimen.kr));
        AppMethodBeat.o(126965);
    }
}
