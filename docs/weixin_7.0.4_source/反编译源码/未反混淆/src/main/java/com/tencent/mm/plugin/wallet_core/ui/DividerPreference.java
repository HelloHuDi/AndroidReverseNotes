package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public class DividerPreference extends Preference {
    private boolean jlN;
    private View mView;
    private boolean peN;
    private boolean peO;

    public DividerPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(47095);
        this.mView = null;
        this.peN = false;
        this.peO = false;
        this.jlN = true;
        setLayoutResource(R.layout.so);
        AppMethodBeat.o(47095);
    }

    public DividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(47096);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(47096);
        return view2;
    }

    public final void onBindView(View view) {
        int i;
        AppMethodBeat.i(47097);
        super.onBindView(view);
        View findViewById = view.findViewById(R.id.b_v);
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
            AppMethodBeat.o(47097);
            return;
        }
        findViewById.setVisibility(4);
        AppMethodBeat.o(47097);
    }
}
