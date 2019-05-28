package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    public OnClickListener mOnClickListener = null;
    private View mView = null;
    public String pez;

    public e(Context context) {
        super(context);
        AppMethodBeat.i(43904);
        setLayoutResource(R.layout.abw);
        AppMethodBeat.o(43904);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(43905);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(43905);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(43906);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.d49);
        textView.setText(this.pez);
        textView.setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(43906);
    }
}
