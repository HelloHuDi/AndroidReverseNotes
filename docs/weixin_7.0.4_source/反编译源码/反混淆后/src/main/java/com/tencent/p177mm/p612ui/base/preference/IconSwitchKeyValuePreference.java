package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.tools.C24054q;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;

/* renamed from: com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference */
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
        AppMethodBeat.m2504i(107189);
        super.onBindView(view);
        this.pnu = (TextView) view.findViewById(16908304);
        m50966cu();
        AppMethodBeat.m2505o(107189);
    }

    /* renamed from: NS */
    public final void mo51421NS(int i) {
        AppMethodBeat.m2504i(107190);
        this.status = i;
        m50966cu();
        AppMethodBeat.m2505o(107190);
    }

    /* renamed from: cu */
    private void m50966cu() {
        AppMethodBeat.m2504i(107191);
        if (this.pnu == null) {
            AppMethodBeat.m2505o(107191);
            return;
        }
        int b = C4977b.m7371b(this.mContext, 2.0f);
        this.pnu.setTextColor(C24054q.m37014ij(this.mContext));
        if (this.status == 0) {
            this.pnu.setCompoundDrawablesWithIntrinsicBounds(C1318a.status_accountunkey, 0, 0, 0);
            this.pnu.setCompoundDrawablePadding(b);
            AppMethodBeat.m2505o(107191);
        } else if (this.status == 1) {
            this.pnu.setCompoundDrawablesWithIntrinsicBounds(C1318a.status_accountkey, 0, 0, 0);
            this.pnu.setCompoundDrawablePadding(b);
            AppMethodBeat.m2505o(107191);
        } else if (this.status == 2) {
            this.pnu.setCompoundDrawablesWithIntrinsicBounds(C1318a.status_accountkey_off, 0, 0, 0);
            this.pnu.setCompoundDrawablePadding(b);
            AppMethodBeat.m2505o(107191);
        } else {
            this.pnu.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.m2505o(107191);
        }
    }
}
