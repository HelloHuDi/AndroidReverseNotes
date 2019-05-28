package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class i extends Preference {
    private View mView = null;
    private int peP = BaseClientBuilder.API_PRIORITY_OTHER;
    String peQ;

    public i(Context context) {
        super(context);
        AppMethodBeat.i(43920);
        setLayoutResource(R.layout.ac1);
        AppMethodBeat.o(43920);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(43921);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(43921);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(43922);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.d4t);
        ((TextView) view.findViewById(R.id.d4s)).setText(getTitle());
        textView.setText(this.peQ);
        if (this.peP != BaseClientBuilder.API_PRIORITY_OTHER) {
            textView.setTextColor(this.peP);
        }
        AppMethodBeat.o(43922);
    }

    public final void UA(String str) {
        AppMethodBeat.i(43923);
        try {
            this.peP = Color.parseColor(str);
            AppMethodBeat.o(43923);
        } catch (Exception e) {
            this.peP = -1;
            AppMethodBeat.o(43923);
        }
    }
}
