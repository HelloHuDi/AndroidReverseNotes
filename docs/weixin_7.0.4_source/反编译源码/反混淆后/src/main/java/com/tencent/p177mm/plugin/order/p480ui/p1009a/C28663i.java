package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.order.ui.a.i */
public final class C28663i extends Preference {
    private View mView = null;
    private int peP = BaseClientBuilder.API_PRIORITY_OTHER;
    String peQ;

    public C28663i(Context context) {
        super(context);
        AppMethodBeat.m2504i(43920);
        setLayoutResource(2130970050);
        AppMethodBeat.m2505o(43920);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43921);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(43921);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(43922);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131825827);
        ((TextView) view.findViewById(2131825826)).setText(getTitle());
        textView.setText(this.peQ);
        if (this.peP != BaseClientBuilder.API_PRIORITY_OTHER) {
            textView.setTextColor(this.peP);
        }
        AppMethodBeat.m2505o(43922);
    }

    /* renamed from: UA */
    public final void mo46791UA(String str) {
        AppMethodBeat.m2504i(43923);
        try {
            this.peP = Color.parseColor(str);
            AppMethodBeat.m2505o(43923);
        } catch (Exception e) {
            this.peP = -1;
            AppMethodBeat.m2505o(43923);
        }
    }
}
