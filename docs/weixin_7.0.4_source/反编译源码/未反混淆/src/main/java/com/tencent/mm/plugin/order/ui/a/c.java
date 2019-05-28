package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    Bitmap fru = null;
    OnClickListener mOnClickListener;
    private View mView = null;
    private TextView oZK;
    private ImageView pex;
    String pey = "";

    public c(Context context) {
        super(context);
        AppMethodBeat.i(43898);
        setLayoutResource(R.layout.abu);
        AppMethodBeat.o(43898);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(43899);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(43899);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(43900);
        super.onBindView(view);
        this.oZK = (TextView) view.findViewById(R.id.d45);
        this.pex = (ImageView) view.findViewById(R.id.d44);
        this.oZK.setText(this.pey);
        this.pex.setImageBitmap(this.fru);
        this.pex.setOnClickListener(this.mOnClickListener);
        if (this.pey != null && this.pey.length() > 48) {
            this.oZK.setTextSize(0, (float) a.al(this.mContext, R.dimen.kr));
        }
        AppMethodBeat.o(43900);
    }
}
