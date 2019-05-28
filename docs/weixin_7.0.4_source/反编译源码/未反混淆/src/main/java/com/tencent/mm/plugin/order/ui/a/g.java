package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g extends Preference {
    private static int peE;
    private static float peF = 16.0f;
    f iFE;
    private View mView = null;
    String peG;
    private String[] peH;
    private TruncateAt peI;
    private boolean peJ = false;

    public g(Context context) {
        super(context);
        AppMethodBeat.i(43913);
        setLayoutResource(R.layout.aby);
        peE = context.getResources().getColor(R.color.ut);
        AppMethodBeat.o(43913);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(43914);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(43914);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(43915);
        super.onBindView(view);
        final TextView textView = (TextView) view.findViewById(R.id.d4d);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.d4c);
        ((TextView) view.findViewById(R.id.d4b)).setText(getTitle());
        if (this.peH == null || this.peH.length <= 1) {
            textView.setTextColor(peE);
        } else {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43912);
                    textView.setVisibility(8);
                    for (String a : g.this.peH) {
                        linearLayout.addView(g.a(g.this, a), new LayoutParams(-2, -2));
                    }
                    textView.setOnClickListener(null);
                    if (g.this.iFE != null) {
                        g.this.iFE.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(43912);
                }
            });
        }
        textView.setText(this.peG);
        AppMethodBeat.o(43915);
    }

    public final void a(String[] strArr, TruncateAt truncateAt) {
        this.peH = strArr;
        this.peI = truncateAt;
        this.peJ = true;
    }
}
