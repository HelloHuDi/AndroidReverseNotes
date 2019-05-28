package com.tencent.p177mm.plugin.order.p480ui.p1009a;

import android.content.Context;
import android.graphics.Color;
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
import com.tencent.p177mm.plugin.order.p1008c.C12784a;
import com.tencent.p177mm.plugin.order.p1008c.C12784a.C12783a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;

/* renamed from: com.tencent.mm.plugin.order.ui.a.f */
public final class C28661f extends Preference {
    private OnClickListener lDG;
    private View mView = null;
    private String mXp;
    private boolean mXt;
    private int peA = BaseClientBuilder.API_PRIORITY_OTHER;
    private int peB = -1;
    private int peC = -1;

    /* renamed from: com.tencent.mm.plugin.order.ui.a.f$1 */
    class C214241 implements C12783a {
        C214241() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43907);
            if (C28661f.this.lDG != null) {
                C28661f.this.lDG.onClick(view);
            }
            AppMethodBeat.m2505o(43907);
        }
    }

    public C28661f(Context context) {
        super(context);
        AppMethodBeat.m2504i(43908);
        setLayoutResource(2130970046);
        AppMethodBeat.m2505o(43908);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(43909);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(43909);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(43910);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(2131825808);
        ((TextView) view.findViewById(2131825807)).setText(getTitle());
        if (this.peA != BaseClientBuilder.API_PRIORITY_OTHER) {
            textView.setTextColor(this.peA);
        }
        if (!this.mXt) {
            textView.setOnClickListener(null);
            textView.setText(C44089j.m79293b(this.mContext, this.mXp, textView.getTextSize()));
            AppMethodBeat.m2505o(43910);
        } else if (this.peB < 0 || this.peC <= 0) {
            textView.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12166um));
            textView.setOnClickListener(this.lDG);
            textView.setText(C44089j.m79293b(this.mContext, this.mXp, textView.getTextSize()));
            AppMethodBeat.m2505o(43910);
        } else {
            C12784a c12784a = new C12784a(this.mContext);
            SpannableString spannableString = new SpannableString(this.mXp);
            c12784a.peT = new C214241();
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(c12784a, this.peB, this.peC, 33);
            textView.setText(spannableString);
            AppMethodBeat.m2505o(43910);
        }
    }

    /* renamed from: Uz */
    public final void mo46787Uz(String str) {
        AppMethodBeat.m2504i(43911);
        try {
            this.peA = Color.parseColor(str);
            AppMethodBeat.m2505o(43911);
        } catch (Exception e) {
            this.peA = BaseClientBuilder.API_PRIORITY_OTHER;
            AppMethodBeat.m2505o(43911);
        }
    }

    public final void setContent(String str) {
        this.mXp = str;
        this.mXt = false;
    }

    /* renamed from: a */
    public final void mo46788a(String str, int i, int i2, OnClickListener onClickListener) {
        this.mXp = str;
        this.mXt = true;
        this.peB = i;
        this.peC = i2;
        this.lDG = onClickListener;
    }
}
