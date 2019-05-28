package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAddressCountView */
public class IPCallAddressCountView extends FrameLayout {
    private View gbS;
    private TextView nBf;

    public IPCallAddressCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(22044);
        init();
        AppMethodBeat.m2505o(22044);
    }

    private IPCallAddressCountView(Context context) {
        super(context);
        AppMethodBeat.m2504i(22045);
        init();
        AppMethodBeat.m2505o(22045);
    }

    public IPCallAddressCountView(Context context, int i) {
        this(context);
        AppMethodBeat.m2504i(22046);
        setAddressCount(i);
        AppMethodBeat.m2505o(22046);
    }

    private void init() {
        AppMethodBeat.m2504i(22047);
        IPCallAddressCountView.inflate(getContext(), 2130969880, this);
        this.gbS = findViewById(2131822964);
        this.nBf = (TextView) findViewById(2131822965);
        AppMethodBeat.m2505o(22047);
    }

    public void setAddressCount(int i) {
        AppMethodBeat.m2504i(22048);
        this.nBf.setText(getContext().getResources().getQuantityString(C25738R.plurals.f9590b, i, new Object[]{Integer.valueOf(i)}));
        AppMethodBeat.m2505o(22048);
    }
}
