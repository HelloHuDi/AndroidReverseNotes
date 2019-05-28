package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.e */
public final class C29667e extends Preference {
    private View kRR;
    public OnClickListener lDG;
    private View mView = null;
    public String mXp;
    public boolean mXt;
    public int peA = BaseClientBuilder.API_PRIORITY_OTHER;
    private int peB = -1;
    private int peC = -1;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.e$1 */
    class C296681 implements C29672a {
        C296681() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47125);
            if (C29667e.this.lDG != null) {
                C29667e.this.lDG.onClick(view);
            }
            AppMethodBeat.m2505o(47125);
        }
    }

    public C29667e(Context context) {
        super(context, null);
        AppMethodBeat.m2504i(47126);
        setLayoutResource(2130969911);
        AppMethodBeat.m2505o(47126);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(47127);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(47127);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(47128);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131825198);
        ((TextView) view.findViewById(2131825197)).setText(getTitle());
        this.kRR = view;
        if (this.peA != BaseClientBuilder.API_PRIORITY_OTHER) {
            textView.setTextColor(this.peA);
        }
        if (!this.mXt) {
            textView.setOnClickListener(null);
            textView.setText(C44089j.m79293b(this.mContext, this.mXp, textView.getTextSize()));
            AppMethodBeat.m2505o(47128);
        } else if (this.peB < 0 || this.peC <= 0) {
            if (this.peA != BaseClientBuilder.API_PRIORITY_OTHER) {
                textView.setTextColor(this.peA);
            } else {
                textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12166um));
            }
            textView.setOnClickListener(this.lDG);
            textView.setText(C44089j.m79293b(this.mContext, this.mXp, textView.getTextSize()));
            AppMethodBeat.m2505o(47128);
        } else {
            C46373j c46373j = new C46373j(this.mContext);
            SpannableString spannableString = new SpannableString(this.mXp);
            c46373j.tHw = new C296681();
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(c46373j, this.peB, this.peC, 33);
            textView.setText(spannableString);
            AppMethodBeat.m2505o(47128);
        }
    }
}
