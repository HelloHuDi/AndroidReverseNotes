package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;

public class SwitchPhoneItemView extends RelativeLayout {
    private int tNA;
    private TextView tNx;
    private TextView tNy;
    ImageView tNz;

    public SwitchPhoneItemView(Context context) {
        this(context, 0);
    }

    public SwitchPhoneItemView(Context context, int i) {
        super(context);
        AppMethodBeat.i(47884);
        this.tNA = 0;
        this.tNA = i;
        cA(context);
        AppMethodBeat.o(47884);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(47885);
        this.tNA = 0;
        cA(context);
        AppMethodBeat.o(47885);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(47886);
        this.tNA = 0;
        cA(context);
        AppMethodBeat.o(47886);
    }

    private void cA(Context context) {
        View inflate;
        AppMethodBeat.i(47887);
        if (this.tNA > 0) {
            inflate = inflate(context, this.tNA, this);
        } else {
            inflate = inflate(context, R.layout.b6_, this);
        }
        this.tNx = (TextView) inflate.findViewById(R.id.fhc);
        this.tNy = (TextView) inflate.findViewById(R.id.fhd);
        this.tNz = (ImageView) inflate.findViewById(R.id.fhe);
        AppMethodBeat.o(47887);
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(47888);
        if (bo.ac(charSequence)) {
            this.tNx.setVisibility(8);
        } else {
            this.tNx.setText(charSequence);
        }
        if (bo.ac(charSequence2)) {
            this.tNy.setVisibility(8);
            AppMethodBeat.o(47888);
            return;
        }
        this.tNy.setMaxLines(2);
        this.tNy.setSelected(true);
        this.tNy.setEllipsize(TruncateAt.MIDDLE);
        this.tNy.setText(charSequence2);
        this.tNy.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(47888);
    }
}
