package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView */
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
        AppMethodBeat.m2504i(47884);
        this.tNA = 0;
        this.tNA = i;
        m68835cA(context);
        AppMethodBeat.m2505o(47884);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(47885);
        this.tNA = 0;
        m68835cA(context);
        AppMethodBeat.m2505o(47885);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(47886);
        this.tNA = 0;
        m68835cA(context);
        AppMethodBeat.m2505o(47886);
    }

    /* renamed from: cA */
    private void m68835cA(Context context) {
        View inflate;
        AppMethodBeat.m2504i(47887);
        if (this.tNA > 0) {
            inflate = SwitchPhoneItemView.inflate(context, this.tNA, this);
        } else {
            inflate = SwitchPhoneItemView.inflate(context, 2130971173, this);
        }
        this.tNx = (TextView) inflate.findViewById(2131829066);
        this.tNy = (TextView) inflate.findViewById(2131829067);
        this.tNz = (ImageView) inflate.findViewById(2131829068);
        AppMethodBeat.m2505o(47887);
    }

    /* renamed from: a */
    public final void mo63487a(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.m2504i(47888);
        if (C5046bo.m7519ac(charSequence)) {
            this.tNx.setVisibility(8);
        } else {
            this.tNx.setText(charSequence);
        }
        if (C5046bo.m7519ac(charSequence2)) {
            this.tNy.setVisibility(8);
            AppMethodBeat.m2505o(47888);
            return;
        }
        this.tNy.setMaxLines(2);
        this.tNy.setSelected(true);
        this.tNy.setEllipsize(TruncateAt.MIDDLE);
        this.tNy.setText(charSequence2);
        this.tNy.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.m2505o(47888);
    }
}
