package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;

public final class j extends i {
    public View uiV;
    public View uiW;
    private TextView uiX;

    public j(Context context, View view) {
        super(context);
        AppMethodBeat.i(6168);
        this.uiV = view;
        this.uiW = LayoutInflater.from(context).inflate(R.layout.b7e, this, false);
        this.uiW.setVisibility(0);
        this.uiW.setBackgroundResource(R.color.a5v);
        View view2 = this.uiW;
        removeAllViews();
        this.itI = view2;
        this.itJ.setLayoutParams(new LayoutParams(-1, -1));
        this.itJ.addView(view2);
        this.WL = view;
        this.itK = new FrameLayout(getContext());
        this.itK.setLayoutParams(new LayoutParams(-1, -1));
        this.itK.addView(view);
        addView(this.itJ);
        addView(this.itK);
        this.uiX = (TextView) this.uiW.findViewById(R.id.fke);
        AppMethodBeat.o(6168);
    }

    public final void setCurrentUrl(String str) {
        AppMethodBeat.i(6169);
        if (!bo.isNullOrNil(str)) {
            if (!bo.isNullOrNil(Uri.parse(str).getHost())) {
                String string = getContext().getString(R.string.fyz, new Object[]{string});
                this.uiX.setVisibility(0);
                this.uiX.setText(string);
                AppMethodBeat.o(6169);
                return;
            }
        }
        this.uiX.setVisibility(8);
        AppMethodBeat.o(6169);
    }

    public final void setX5LogoViewVisibility(int i) {
        AppMethodBeat.i(6170);
        this.uiW.setVisibility(i);
        AppMethodBeat.o(6170);
    }

    public final void setBgColor(int i) {
        AppMethodBeat.i(6171);
        ((ViewGroup) this.uiW.getParent()).setBackgroundColor(i);
        AppMethodBeat.o(6171);
    }
}
