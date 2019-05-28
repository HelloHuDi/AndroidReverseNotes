package com.tencent.p177mm.p612ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.ui.a */
public final class C15481a {
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

    public C15481a(View view) {
        AppMethodBeat.m2504i(105936);
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
        this.gnB = (TextView) view.findViewById(2131820965);
        this.yeg = (TextView) view.findViewById(2131820966);
        this.sDV = (ImageView) view.findViewById(2131820968);
        this.yeh = (ImageView) view.findViewById(2131820967);
        this.yei = (ImageView) view.findViewById(2131820969);
        this.yej = (ImageView) view.findViewById(2131820970);
        this.uCq = view.findViewById(2131820963);
        this.lnh = (ImageView) view.findViewById(2131820964);
        this.yek = (ImageView) view.findViewById(2131820971);
        this.yel = view;
        AppMethodBeat.m2505o(105936);
    }

    public final void setTitle(CharSequence charSequence) {
        AppMethodBeat.m2504i(105937);
        this.gnB.setText(charSequence);
        if (C1338a.m2865ga(this.gnB.getContext())) {
            this.gnB.setTextSize(0, ((float) C1338a.m2857am(this.gnB.getContext(), C25738R.dimen.f9720dk)) * C1338a.m2862fY(this.gnB.getContext()));
        }
        AppMethodBeat.m2505o(105937);
    }

    /* renamed from: pv */
    public final void mo27556pv(boolean z) {
        AppMethodBeat.m2504i(105938);
        this.sDV.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(105938);
    }

    /* renamed from: pw */
    public final void mo27557pw(boolean z) {
        AppMethodBeat.m2504i(105939);
        this.yej.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(105939);
    }

    /* renamed from: b */
    public final void mo27555b(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(105940);
        this.uCq.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(105940);
    }
}
