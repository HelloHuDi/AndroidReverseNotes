package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;

public class ChattingFooterMoreBtnBar extends LinearLayout {
    private ImageButton mpG;
    private LayoutParams njH;
    private ImageButton yJq;
    private ImageButton yJr;
    private ImageButton yJs;
    private ImageButton yJt;

    public ChattingFooterMoreBtnBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(30684);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.drawable.ay1);
        this.njH = new LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.nb), 1.0f);
        this.njH.topMargin = a.fromDPToPix(getContext(), 0);
        this.yJq = new ImageButton(getContext());
        this.yJq.setImageResource(R.drawable.hr);
        this.yJq.setScaleType(ScaleType.CENTER);
        this.yJq.setBackgroundResource(0);
        this.yJq.setContentDescription(context.getString(R.string.amz));
        this.yJt = new ImageButton(getContext());
        this.yJt.setImageResource(R.drawable.ho);
        this.yJt.setScaleType(ScaleType.CENTER);
        this.yJt.setBackgroundResource(0);
        this.yJt.setContentDescription(context.getString(R.string.amy));
        this.mpG = new ImageButton(getContext());
        this.mpG.setImageResource(R.drawable.hm);
        this.mpG.setScaleType(ScaleType.CENTER);
        this.mpG.setBackgroundResource(0);
        this.mpG.setContentDescription(context.getString(R.string.amw));
        this.yJs = new ImageButton(getContext());
        this.yJs.setImageResource(R.drawable.hp);
        this.yJs.setScaleType(ScaleType.CENTER);
        this.yJs.setBackgroundResource(0);
        this.yJs.setContentDescription(context.getString(R.string.amv));
        this.yJr = new ImageButton(getContext());
        this.yJr.setImageResource(R.drawable.hn);
        this.yJr.setScaleType(ScaleType.CENTER);
        this.yJr.setBackgroundResource(0);
        this.yJr.setContentDescription(context.getString(R.string.amx));
        dCp();
        AppMethodBeat.o(30684);
    }

    public final void dCp() {
        AppMethodBeat.i(30685);
        removeAllViews();
        addView(this.yJq, this.njH);
        addView(this.yJt, this.njH);
        addView(this.mpG, this.njH);
        addView(this.yJr, this.njH);
        AppMethodBeat.o(30685);
    }

    public final void On(int i) {
        AppMethodBeat.i(30686);
        boolean z = i > 0;
        this.yJq.setClickable(z);
        this.yJq.setEnabled(z);
        if (j.dBY().size() > 0) {
            this.yJs.setClickable(z);
            this.yJs.setEnabled(z);
        } else {
            this.yJr.setClickable(z);
            this.yJr.setEnabled(z);
        }
        this.mpG.setClickable(z);
        this.mpG.setEnabled(z);
        this.yJt.setClickable(z);
        this.yJt.setEnabled(z);
        AppMethodBeat.o(30686);
    }

    public final void c(int i, OnClickListener onClickListener) {
        AppMethodBeat.i(30687);
        switch (i) {
            case 0:
                this.yJq.setOnClickListener(onClickListener);
                AppMethodBeat.o(30687);
                return;
            case 1:
                this.yJr.setOnClickListener(onClickListener);
                AppMethodBeat.o(30687);
                return;
            case 2:
                this.yJs.setOnClickListener(onClickListener);
                AppMethodBeat.o(30687);
                return;
            case 3:
                this.mpG.setOnClickListener(onClickListener);
                AppMethodBeat.o(30687);
                return;
            case 4:
                this.yJt.setOnClickListener(onClickListener);
                AppMethodBeat.o(30687);
                return;
            default:
                ab.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", Integer.valueOf(i));
                AppMethodBeat.o(30687);
                return;
        }
    }
}
