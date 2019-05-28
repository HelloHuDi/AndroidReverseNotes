package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.tools.q;

public class SwitchKeyValuePreference extends Preference {
    private boolean enable;
    private TextView pnu;

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107292);
        this.enable = true;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(107292);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(107293);
        super.onBindView(view);
        this.pnu = (TextView) view.findViewById(16908304);
        cu();
        AppMethodBeat.o(107293);
    }

    public final void qk(boolean z) {
        AppMethodBeat.i(107294);
        this.enable = z;
        cu();
        AppMethodBeat.o(107294);
    }

    private void cu() {
        AppMethodBeat.i(107295);
        if (this.pnu == null) {
            AppMethodBeat.o(107295);
        } else if (this.enable) {
            this.pnu.setTextColor(q.ii(this.mContext));
            AppMethodBeat.o(107295);
        } else {
            this.pnu.setTextColor(q.ij(this.mContext));
            AppMethodBeat.o(107295);
        }
    }
}
