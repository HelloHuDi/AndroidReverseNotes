package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class h extends Preference {
    boolean jlN = true;
    private View mView = null;
    boolean peN = false;
    boolean peO = false;

    public h(Context context) {
        super(context);
        AppMethodBeat.i(43917);
        setLayoutResource(R.layout.ac0);
        AppMethodBeat.o(43917);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(43918);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(43918);
        return view2;
    }

    public final void onBindView(View view) {
        int i;
        AppMethodBeat.i(43919);
        super.onBindView(view);
        View findViewById = view.findViewById(R.id.d4r);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        int b = b.b(this.mContext, 10.0f);
        if (this.peN) {
            i = b;
        } else {
            i = 0;
        }
        if (!this.peO) {
            b = 0;
        }
        layoutParams.setMargins(0, i, 0, b);
        findViewById.setLayoutParams(layoutParams);
        if (this.jlN) {
            findViewById.setVisibility(0);
            AppMethodBeat.o(43919);
            return;
        }
        findViewById.setVisibility(4);
        AppMethodBeat.o(43919);
    }
}
