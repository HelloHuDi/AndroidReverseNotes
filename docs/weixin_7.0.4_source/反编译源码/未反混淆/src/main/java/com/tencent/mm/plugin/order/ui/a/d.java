package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    String kWC;
    String mName;
    OnClickListener mOnClickListener;
    private View mView = null;

    public d(Context context) {
        super(context);
        AppMethodBeat.i(43901);
        setLayoutResource(R.layout.abv);
        AppMethodBeat.o(43901);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(43902);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(43902);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(43903);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.d47);
        TextView textView = (TextView) view.findViewById(R.id.d48);
        imageView.setImageBitmap(null);
        if (!bo.isNullOrNil(this.kWC)) {
            a aVar = new a();
            b.bYR();
            aVar.ePK = b.bKP();
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.eQf = true;
            o.ahp().a(this.kWC, imageView, aVar.ahG());
        }
        textView.setText(this.mName);
        view.findViewById(R.id.d46).setOnClickListener(this.mOnClickListener);
        AppMethodBeat.o(43903);
    }
}
