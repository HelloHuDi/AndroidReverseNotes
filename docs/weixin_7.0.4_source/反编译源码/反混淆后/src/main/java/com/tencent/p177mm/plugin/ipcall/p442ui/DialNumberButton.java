package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.DialNumberButton */
public class DialNumberButton extends RelativeLayout {
    private TextView nzH;
    private TextView nzI;
    private boolean nzJ = false;

    public DialNumberButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(21953);
        LayoutInflater.from(getContext()).inflate(2130969286, this);
        this.nzH = (TextView) findViewById(2131823282);
        this.nzI = (TextView) findViewById(2131823283);
        if (C1443d.m3068iW(16)) {
            this.nzH.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nzI.setTypeface(Typeface.create("sans-serif-normal", 0));
        }
        setClipChildren(false);
        setClipToPadding(false);
        AppMethodBeat.m2505o(21953);
    }

    public final void setNumberTextSize$255e752(float f) {
        AppMethodBeat.m2504i(21954);
        this.nzH.setTextSize(0, f);
        AppMethodBeat.m2505o(21954);
    }

    public String getNumberText() {
        AppMethodBeat.m2504i(21955);
        String charSequence = this.nzH.getText().toString();
        AppMethodBeat.m2505o(21955);
        return charSequence;
    }

    public String getOtherText() {
        AppMethodBeat.m2504i(21956);
        String charSequence = this.nzI.getText().toString();
        AppMethodBeat.m2505o(21956);
        return charSequence;
    }

    /* renamed from: eK */
    public final void mo46269eK(String str, String str2) {
        AppMethodBeat.m2504i(21957);
        if (!C5046bo.isNullOrNil(str) && str.length() == 1) {
            this.nzH.setText(str);
        }
        if (!C5046bo.isNullOrNil(str2) || "1".equals(str)) {
            this.nzI.setText(str2);
            this.nzI.setVisibility(0);
            AppMethodBeat.m2505o(21957);
            return;
        }
        this.nzI.setVisibility(8);
        AppMethodBeat.m2505o(21957);
    }

    public void setInTalkUIMode(boolean z) {
        AppMethodBeat.m2504i(21958);
        this.nzJ = z;
        if (this.nzJ) {
            if ("#".equals(this.nzH.getText()) || "*".equals(this.nzH.getText())) {
                this.nzH.setTextColor(getContext().getResources().getColor(C25738R.color.f11929m1));
            } else {
                this.nzH.setTextColor(getContext().getResources().getColor(C25738R.color.f11931m3));
            }
            this.nzI.setTextColor(getContext().getResources().getColor(C25738R.color.f11929m1));
            setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.f6656la));
            AppMethodBeat.m2505o(21958);
            return;
        }
        if ("#".equals(this.nzH.getText()) || "*".equals(this.nzH.getText())) {
            this.nzH.setTextColor(getContext().getResources().getColor(C25738R.color.f11929m1));
        } else {
            this.nzH.setTextColor(getContext().getResources().getColor(C25738R.color.f11930m2));
        }
        this.nzI.setTextColor(getContext().getResources().getColor(C25738R.color.f11929m1));
        setBackgroundDrawable(getResources().getDrawable(C25738R.drawable.f6657lb));
        AppMethodBeat.m2505o(21958);
    }
}
