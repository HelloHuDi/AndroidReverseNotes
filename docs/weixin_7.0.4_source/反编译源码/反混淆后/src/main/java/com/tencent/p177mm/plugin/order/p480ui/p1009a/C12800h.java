package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;

/* renamed from: com.tencent.mm.plugin.order.ui.a.h */
public final class C12800h extends Preference {
    boolean jlN = true;
    private View mView = null;
    boolean peN = false;
    boolean peO = false;

    public C12800h(Context context) {
        super(context);
        AppMethodBeat.m2504i(43917);
        setLayoutResource(2130970049);
        AppMethodBeat.m2505o(43917);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43918);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(43918);
        return view2;
    }

    public final void onBindView(View view) {
        int i;
        AppMethodBeat.m2504i(43919);
        super.onBindView(view);
        View findViewById = view.findViewById(2131825825);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        int b = C4977b.m7371b(this.mContext, 10.0f);
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
            AppMethodBeat.m2505o(43919);
            return;
        }
        findViewById.setVisibility(4);
        AppMethodBeat.m2505o(43919);
    }
}
