package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.tools.q;

public class IconSwitchKeyValuePreference extends IconPreference {
    private TextView pnu;
    private int status;

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(107189);
        super.onBindView(view);
        this.pnu = (TextView) view.findViewById(16908304);
        cu();
        AppMethodBeat.o(107189);
    }

    public final void NS(int i) {
        AppMethodBeat.i(107190);
        this.status = i;
        cu();
        AppMethodBeat.o(107190);
    }

    private void cu() {
        AppMethodBeat.i(107191);
        if (this.pnu == null) {
            AppMethodBeat.o(107191);
            return;
        }
        int b = b.b(this.mContext, 2.0f);
        this.pnu.setTextColor(q.ij(this.mContext));
        if (this.status == 0) {
            this.pnu.setCompoundDrawablesWithIntrinsicBounds(R.raw.status_accountunkey, 0, 0, 0);
            this.pnu.setCompoundDrawablePadding(b);
            AppMethodBeat.o(107191);
        } else if (this.status == 1) {
            this.pnu.setCompoundDrawablesWithIntrinsicBounds(R.raw.status_accountkey, 0, 0, 0);
            this.pnu.setCompoundDrawablePadding(b);
            AppMethodBeat.o(107191);
        } else if (this.status == 2) {
            this.pnu.setCompoundDrawablesWithIntrinsicBounds(R.raw.status_accountkey_off, 0, 0, 0);
            this.pnu.setCompoundDrawablePadding(b);
            AppMethodBeat.o(107191);
        } else {
            this.pnu.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.o(107191);
        }
    }
}
