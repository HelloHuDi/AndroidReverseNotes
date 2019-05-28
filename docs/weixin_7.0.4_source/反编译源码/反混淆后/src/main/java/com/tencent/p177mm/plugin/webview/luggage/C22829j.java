package com.tencent.p177mm.plugin.webview.luggage;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.j */
public final class C22829j extends C43888i {
    public View uiV;
    public View uiW;
    private TextView uiX;

    public C22829j(Context context, View view) {
        super(context);
        AppMethodBeat.m2504i(6168);
        this.uiV = view;
        this.uiW = LayoutInflater.from(context).inflate(2130971215, this, false);
        this.uiW.setVisibility(0);
        this.uiW.setBackgroundResource(C25738R.color.a5v);
        View view2 = this.uiW;
        removeAllViews();
        this.itI = view2;
        this.itJ.setLayoutParams(new LayoutParams(-1, -1));
        this.itJ.addView(view2);
        this.f17233WL = view;
        this.itK = new FrameLayout(getContext());
        this.itK.setLayoutParams(new LayoutParams(-1, -1));
        this.itK.addView(view);
        addView(this.itJ);
        addView(this.itK);
        this.uiX = (TextView) this.uiW.findViewById(2131829179);
        AppMethodBeat.m2505o(6168);
    }

    public final void setCurrentUrl(String str) {
        AppMethodBeat.m2504i(6169);
        if (!C5046bo.isNullOrNil(str)) {
            if (!C5046bo.isNullOrNil(Uri.parse(str).getHost())) {
                String string = getContext().getString(C25738R.string.fyz, new Object[]{string});
                this.uiX.setVisibility(0);
                this.uiX.setText(string);
                AppMethodBeat.m2505o(6169);
                return;
            }
        }
        this.uiX.setVisibility(8);
        AppMethodBeat.m2505o(6169);
    }

    public final void setX5LogoViewVisibility(int i) {
        AppMethodBeat.m2504i(6170);
        this.uiW.setVisibility(i);
        AppMethodBeat.m2505o(6170);
    }

    public final void setBgColor(int i) {
        AppMethodBeat.m2504i(6171);
        ((ViewGroup) this.uiW.getParent()).setBackgroundColor(i);
        AppMethodBeat.m2505o(6171);
    }
}
