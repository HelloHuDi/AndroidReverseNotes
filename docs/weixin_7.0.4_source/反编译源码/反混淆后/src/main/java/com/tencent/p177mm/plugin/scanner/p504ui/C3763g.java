package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.scanner.ui.g */
public final class C3763g extends Preference {
    private View mView = null;

    public C3763g(Context context) {
        super(context);
        AppMethodBeat.m2504i(81040);
        setLayoutResource(2130970381);
        AppMethodBeat.m2505o(81040);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(81041);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        super.onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(81041);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(139050);
        super.onBindView(view);
        AppMethodBeat.m2505o(139050);
    }
}
