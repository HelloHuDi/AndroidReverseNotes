package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.order.ui.a.e */
public final class C39483e extends Preference {
    public OnClickListener mOnClickListener = null;
    private View mView = null;
    public String pez;

    public C39483e(Context context) {
        super(context);
        AppMethodBeat.m2504i(43904);
        setLayoutResource(2130970045);
        AppMethodBeat.m2505o(43904);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43905);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(43905);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(43906);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131825806);
        textView.setText(this.pez);
        textView.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.m2505o(43906);
    }
}
