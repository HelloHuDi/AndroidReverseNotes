package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a {
    public TextView gnB;
    private ImageView lnh;
    private ImageView sDV;
    private View uCq;
    public TextView yeg;
    public ImageView yeh;
    public ImageView yei;
    private ImageView yej;
    public ImageView yek;
    private View yel;

    public a(View view) {
        AppMethodBeat.i(105936);
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
        this.gnB = (TextView) view.findViewById(R.id.ko);
        this.yeg = (TextView) view.findViewById(R.id.kp);
        this.sDV = (ImageView) view.findViewById(R.id.kr);
        this.yeh = (ImageView) view.findViewById(R.id.kq);
        this.yei = (ImageView) view.findViewById(R.id.ks);
        this.yej = (ImageView) view.findViewById(R.id.kt);
        this.uCq = view.findViewById(R.id.km);
        this.lnh = (ImageView) view.findViewById(R.id.kn);
        this.yek = (ImageView) view.findViewById(R.id.ku);
        this.yel = view;
        AppMethodBeat.o(105936);
    }

    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.i(105937);
        this.gnB.setText(charSequence);
        if (com.tencent.mm.bz.a.ga(this.gnB.getContext())) {
            this.gnB.setTextSize(0, ((float) com.tencent.mm.bz.a.am(this.gnB.getContext(), R.dimen.dk)) * com.tencent.mm.bz.a.fY(this.gnB.getContext()));
        }
        AppMethodBeat.o(105937);
    }

    public final void pv(boolean z) {
        AppMethodBeat.i(105938);
        this.sDV.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(105938);
    }

    public final void pw(boolean z) {
        AppMethodBeat.i(105939);
        this.yej.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(105939);
    }

    public final void b(OnClickListener onClickListener) {
        AppMethodBeat.i(105940);
        this.uCq.setOnClickListener(onClickListener);
        AppMethodBeat.o(105940);
    }
}
