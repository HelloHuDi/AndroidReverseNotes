package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.order.ui.a.g */
public final class C28662g extends Preference {
    private static int peE;
    private static float peF = 16.0f;
    C15541f iFE;
    private View mView = null;
    String peG;
    private String[] peH;
    private TruncateAt peI;
    private boolean peJ = false;

    public C28662g(Context context) {
        super(context);
        AppMethodBeat.m2504i(43913);
        setLayoutResource(2130970047);
        peE = context.getResources().getColor(C25738R.color.f12173ut);
        AppMethodBeat.m2505o(43913);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43914);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(43914);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(43915);
        super.onBindView(view);
        final TextView textView = (TextView) view.findViewById(2131825811);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(2131825810);
        ((TextView) view.findViewById(2131825809)).setText(getTitle());
        if (this.peH == null || this.peH.length <= 1) {
            textView.setTextColor(peE);
        } else {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(43912);
                    textView.setVisibility(8);
                    for (String a : C28662g.this.peH) {
                        linearLayout.addView(C28662g.m45548a(C28662g.this, a), new LayoutParams(-2, -2));
                    }
                    textView.setOnClickListener(null);
                    if (C28662g.this.iFE != null) {
                        C28662g.this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.m2505o(43912);
                }
            });
        }
        textView.setText(this.peG);
        AppMethodBeat.m2505o(43915);
    }

    /* renamed from: a */
    public final void mo46790a(String[] strArr, TruncateAt truncateAt) {
        this.peH = strArr;
        this.peI = truncateAt;
        this.peJ = true;
    }
}
