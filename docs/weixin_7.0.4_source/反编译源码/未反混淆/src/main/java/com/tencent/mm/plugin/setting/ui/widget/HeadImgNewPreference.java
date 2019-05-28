package com.tencent.mm.plugin.setting.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgNewPreference extends Preference {
    private int height;
    private ImageView iNr;
    private TextView qqS;
    private View qqT;
    private String qqU;
    public OnClickListener qqV;
    private boolean qqW;
    private boolean qqX;

    public HeadImgNewPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgNewPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(127698);
        this.height = -1;
        this.qqW = false;
        this.qqX = false;
        setLayoutResource(R.layout.ae4);
        AppMethodBeat.o(127698);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(127699);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        if (this.qqX) {
            View.inflate(this.mContext, R.layout.ahc, viewGroup2);
        } else {
            View.inflate(this.mContext, R.layout.aeq, viewGroup2);
        }
        this.iNr = (ImageView) onCreateView.findViewById(R.id.d_g);
        this.qqS = (TextView) onCreateView.findViewById(R.id.d_i);
        this.qqT = onCreateView.findViewById(R.id.mt);
        AppMethodBeat.o(127699);
        return onCreateView;
    }

    public final void WB(String str) {
        AppMethodBeat.i(127700);
        this.qqU = null;
        if (this.iNr != null) {
            b.b(this.iNr, str);
        } else {
            this.qqU = str;
        }
        if (str == null) {
            this.qqW = false;
            AppMethodBeat.o(127700);
            return;
        }
        this.qqW = true;
        AppMethodBeat.o(127700);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(127701);
        super.onBindView(view);
        if (this.iNr == null) {
            this.iNr = (ImageView) view.findViewById(R.id.d_g);
        }
        if (this.qqS == null) {
            this.qqS = (TextView) view.findViewById(R.id.d_i);
        }
        if (this.qqT == null) {
            this.qqT = view.findViewById(R.id.mt);
        }
        if (this.qqV != null) {
            this.qqT.setOnClickListener(this.qqV);
        }
        if (this.qqU != null) {
            b.b(this.iNr, this.qqU);
            this.qqU = null;
        }
        if (this.qqW) {
            this.qqS.setVisibility(8);
            this.qqT.setVisibility(0);
        } else {
            this.qqT.setVisibility(8);
            this.qqS.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.akp);
        if (this.height != -1) {
            relativeLayout.setMinimumHeight(this.height);
        }
        AppMethodBeat.o(127701);
    }
}
