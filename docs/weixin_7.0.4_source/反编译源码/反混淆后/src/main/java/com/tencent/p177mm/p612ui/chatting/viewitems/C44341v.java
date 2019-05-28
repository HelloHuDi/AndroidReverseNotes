package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.v */
public final class C44341v extends RelativeLayout {
    private LayoutInflater ezi;
    private int zeL;

    public C44341v(LayoutInflater layoutInflater, int i) {
        super(layoutInflater.getContext());
        AppMethodBeat.m2504i(33121);
        this.ezi = layoutInflater;
        this.zeL = i;
        setClipChildren(false);
        View inflate = this.ezi.inflate(2130969026, null);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        inflate.setId(2131820583);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(C25738R.dimen.f9979m4), 0, getResources().getDimensionPixelSize(C25738R.dimen.f9979m4));
        inflate.setVisibility(8);
        addView(inflate, layoutParams);
        TextView textView = new TextView(getContext(), null, C25738R.style.f10851gg);
        textView.setId(2131820587);
        int dimensionPixelSize = textView.getResources().getDimensionPixelSize(C25738R.dimen.f10018nk);
        if (C1338a.m2856al(getContext(), C25738R.dimen.f10018nk) != dimensionPixelSize) {
            C4990ab.m7413e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", Integer.valueOf(C1338a.m2856al(getContext(), C25738R.dimen.f10018nk)), Integer.valueOf(dimensionPixelSize));
        }
        textView.setTextSize(0, (float) dimensionPixelSize);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(3, 2131820583);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(C25738R.dimen.f9979m4), 0, getResources().getDimensionPixelSize(C25738R.dimen.f9979m4));
        addView(textView, layoutParams);
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getContext()).inflate(2130970096, this, false);
        checkBox.setId(2131820580);
        dimensionPixelSize = C1338a.fromDPToPix(getContext(), 32);
        LayoutParams layoutParams2 = new LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.setMargins(0, getResources().getDimensionPixelSize(C25738R.dimen.f9723do), getResources().getDimensionPixelSize(C25738R.dimen.f10011nc), 0);
        layoutParams2.addRule(3, 2131820587);
        layoutParams2.addRule(11);
        layoutParams2.width = dimensionPixelSize;
        layoutParams2.height = dimensionPixelSize;
        addView(checkBox, layoutParams2);
        View inflate2 = this.ezi.inflate(this.zeL, null);
        int id = inflate2.getId();
        if (-1 == id) {
            C4990ab.m7418v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
            id = 2131820581;
            inflate2.setId(2131820581);
        }
        layoutParams2 = new LayoutParams(-1, -2);
        layoutParams2.addRule(3, 2131820587);
        layoutParams2.addRule(0, 2131820580);
        addView(inflate2, layoutParams2);
        inflate2 = new View(getContext());
        inflate2.setId(2131820586);
        inflate2.setVisibility(8);
        layoutParams2 = new LayoutParams(-1, -1);
        layoutParams2.addRule(6, id);
        layoutParams2.addRule(8, id);
        addView(inflate2, layoutParams2);
        AppMethodBeat.m2505o(33121);
    }
}
