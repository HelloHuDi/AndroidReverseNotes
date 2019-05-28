package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.ui.j.a;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    private View kRR;
    public OnClickListener lDG;
    private View mView = null;
    public String mXp;
    public boolean mXt;
    public int peA = BaseClientBuilder.API_PRIORITY_OTHER;
    private int peB = -1;
    private int peC = -1;

    public e(Context context) {
        super(context, null);
        AppMethodBeat.i(47126);
        setLayoutResource(R.layout.a9_);
        AppMethodBeat.o(47126);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(47127);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(47127);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(47128);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.cns);
        ((TextView) view.findViewById(R.id.cnr)).setText(getTitle());
        this.kRR = view;
        if (this.peA != BaseClientBuilder.API_PRIORITY_OTHER) {
            textView.setTextColor(this.peA);
        }
        if (!this.mXt) {
            textView.setOnClickListener(null);
            textView.setText(j.b(this.mContext, this.mXp, textView.getTextSize()));
            AppMethodBeat.o(47128);
        } else if (this.peB < 0 || this.peC <= 0) {
            if (this.peA != BaseClientBuilder.API_PRIORITY_OTHER) {
                textView.setTextColor(this.peA);
            } else {
                textView.setTextColor(this.mContext.getResources().getColor(R.color.um));
            }
            textView.setOnClickListener(this.lDG);
            textView.setText(j.b(this.mContext, this.mXp, textView.getTextSize()));
            AppMethodBeat.o(47128);
        } else {
            j jVar = new j(this.mContext);
            SpannableString spannableString = new SpannableString(this.mXp);
            jVar.tHw = new a() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47125);
                    if (e.this.lDG != null) {
                        e.this.lDG.onClick(view);
                    }
                    AppMethodBeat.o(47125);
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(jVar, this.peB, this.peC, 33);
            textView.setText(spannableString);
            AppMethodBeat.o(47128);
        }
    }
}
