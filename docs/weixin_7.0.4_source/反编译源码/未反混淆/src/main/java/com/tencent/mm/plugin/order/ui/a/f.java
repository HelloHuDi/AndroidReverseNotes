package com.tencent.mm.plugin.order.ui.a;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference {
    private OnClickListener lDG;
    private View mView = null;
    private String mXp;
    private boolean mXt;
    private int peA = BaseClientBuilder.API_PRIORITY_OTHER;
    private int peB = -1;
    private int peC = -1;

    public f(Context context) {
        super(context);
        AppMethodBeat.i(43908);
        setLayoutResource(R.layout.abx);
        AppMethodBeat.o(43908);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(43909);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(43909);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(43910);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.d4a);
        ((TextView) view.findViewById(R.id.d4_)).setText(getTitle());
        if (this.peA != BaseClientBuilder.API_PRIORITY_OTHER) {
            textView.setTextColor(this.peA);
        }
        if (!this.mXt) {
            textView.setOnClickListener(null);
            textView.setText(j.b(this.mContext, this.mXp, textView.getTextSize()));
            AppMethodBeat.o(43910);
        } else if (this.peB < 0 || this.peC <= 0) {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.um));
            textView.setOnClickListener(this.lDG);
            textView.setText(j.b(this.mContext, this.mXp, textView.getTextSize()));
            AppMethodBeat.o(43910);
        } else {
            a aVar = new a(this.mContext);
            SpannableString spannableString = new SpannableString(this.mXp);
            aVar.peT = new a.a() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43907);
                    if (f.this.lDG != null) {
                        f.this.lDG.onClick(view);
                    }
                    AppMethodBeat.o(43907);
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(aVar, this.peB, this.peC, 33);
            textView.setText(spannableString);
            AppMethodBeat.o(43910);
        }
    }

    public final void Uz(String str) {
        AppMethodBeat.i(43911);
        try {
            this.peA = Color.parseColor(str);
            AppMethodBeat.o(43911);
        } catch (Exception e) {
            this.peA = BaseClientBuilder.API_PRIORITY_OTHER;
            AppMethodBeat.o(43911);
        }
    }

    public final void setContent(String str) {
        this.mXp = str;
        this.mXt = false;
    }

    public final void a(String str, int i, int i2, OnClickListener onClickListener) {
        this.mXp = str;
        this.mXt = true;
        this.peB = i;
        this.peC = i2;
        this.lDG = onClickListener;
    }
}
