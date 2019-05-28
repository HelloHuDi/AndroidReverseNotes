package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class v extends RelativeLayout {
    private LayoutInflater ezi;
    private int zeL;

    public v(LayoutInflater layoutInflater, int i) {
        super(layoutInflater.getContext());
        AppMethodBeat.i(33121);
        this.ezi = layoutInflater;
        this.zeL = i;
        setClipChildren(false);
        View inflate = this.ezi.inflate(R.layout.lg, null);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        inflate.setId(R.id.ac);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.m4), 0, getResources().getDimensionPixelSize(R.dimen.m4));
        inflate.setVisibility(8);
        addView(inflate, layoutParams);
        TextView textView = new TextView(getContext(), null, R.style.gg);
        textView.setId(R.id.ag);
        int dimensionPixelSize = textView.getResources().getDimensionPixelSize(R.dimen.nk);
        if (a.al(getContext(), R.dimen.nk) != dimensionPixelSize) {
            ab.e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", Integer.valueOf(a.al(getContext(), R.dimen.nk)), Integer.valueOf(dimensionPixelSize));
        }
        textView.setTextSize(0, (float) dimensionPixelSize);
        layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(3, R.id.ac);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.m4), 0, getResources().getDimensionPixelSize(R.dimen.m4));
        addView(textView, layoutParams);
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getContext()).inflate(R.layout.ad_, this, false);
        checkBox.setId(R.id.a_);
        dimensionPixelSize = a.fromDPToPix(getContext(), 32);
        LayoutParams layoutParams2 = new LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.setMargins(0, getResources().getDimensionPixelSize(R.dimen.f15do), getResources().getDimensionPixelSize(R.dimen.nc), 0);
        layoutParams2.addRule(3, R.id.ag);
        layoutParams2.addRule(11);
        layoutParams2.width = dimensionPixelSize;
        layoutParams2.height = dimensionPixelSize;
        addView(checkBox, layoutParams2);
        View inflate2 = this.ezi.inflate(this.zeL, null);
        int id = inflate2.getId();
        if (-1 == id) {
            ab.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
            id = R.id.aa;
            inflate2.setId(R.id.aa);
        }
        layoutParams2 = new LayoutParams(-1, -2);
        layoutParams2.addRule(3, R.id.ag);
        layoutParams2.addRule(0, R.id.a_);
        addView(inflate2, layoutParams2);
        inflate2 = new View(getContext());
        inflate2.setId(R.id.af);
        inflate2.setVisibility(8);
        layoutParams2 = new LayoutParams(-1, -1);
        layoutParams2.addRule(6, id);
        layoutParams2.addRule(8, id);
        addView(inflate2, layoutParams2);
        AppMethodBeat.o(33121);
    }
}
