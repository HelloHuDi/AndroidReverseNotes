package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.C24054q;

/* renamed from: com.tencent.mm.ui.base.preference.SwitchKeyValuePreference */
public class SwitchKeyValuePreference extends Preference {
    private boolean enable;
    private TextView pnu;

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107292);
        this.enable = true;
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(107292);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107293);
        super.onBindView(view);
        this.pnu = (TextView) view.findViewById(16908304);
        m79977cu();
        AppMethodBeat.m2505o(107293);
    }

    /* renamed from: qk */
    public final void mo70137qk(boolean z) {
        AppMethodBeat.m2504i(107294);
        this.enable = z;
        m79977cu();
        AppMethodBeat.m2505o(107294);
    }

    /* renamed from: cu */
    private void m79977cu() {
        AppMethodBeat.m2504i(107295);
        if (this.pnu == null) {
            AppMethodBeat.m2505o(107295);
        } else if (this.enable) {
            this.pnu.setTextColor(C24054q.m37013ii(this.mContext));
            AppMethodBeat.m2505o(107295);
        } else {
            this.pnu.setTextColor(C24054q.m37014ij(this.mContext));
            AppMethodBeat.m2505o(107295);
        }
    }
}
