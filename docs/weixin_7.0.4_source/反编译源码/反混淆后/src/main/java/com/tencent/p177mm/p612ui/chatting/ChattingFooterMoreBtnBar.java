package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar */
public class ChattingFooterMoreBtnBar extends LinearLayout {
    private ImageButton mpG;
    private LayoutParams njH;
    private ImageButton yJq;
    private ImageButton yJr;
    private ImageButton yJs;
    private ImageButton yJt;

    public ChattingFooterMoreBtnBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(30684);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(C25738R.drawable.ay1);
        this.njH = new LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.f10010nb), 1.0f);
        this.njH.topMargin = C1338a.fromDPToPix(getContext(), 0);
        this.yJq = new ImageButton(getContext());
        this.yJq.setImageResource(C25738R.drawable.f6547hr);
        this.yJq.setScaleType(ScaleType.CENTER);
        this.yJq.setBackgroundResource(0);
        this.yJq.setContentDescription(context.getString(C25738R.string.amz));
        this.yJt = new ImageButton(getContext());
        this.yJt.setImageResource(C25738R.drawable.f6544ho);
        this.yJt.setScaleType(ScaleType.CENTER);
        this.yJt.setBackgroundResource(0);
        this.yJt.setContentDescription(context.getString(C25738R.string.amy));
        this.mpG = new ImageButton(getContext());
        this.mpG.setImageResource(C25738R.drawable.f6542hm);
        this.mpG.setScaleType(ScaleType.CENTER);
        this.mpG.setBackgroundResource(0);
        this.mpG.setContentDescription(context.getString(C25738R.string.amw));
        this.yJs = new ImageButton(getContext());
        this.yJs.setImageResource(C25738R.drawable.f6545hp);
        this.yJs.setScaleType(ScaleType.CENTER);
        this.yJs.setBackgroundResource(0);
        this.yJs.setContentDescription(context.getString(C25738R.string.amv));
        this.yJr = new ImageButton(getContext());
        this.yJr.setImageResource(C25738R.drawable.f6543hn);
        this.yJr.setScaleType(ScaleType.CENTER);
        this.yJr.setBackgroundResource(0);
        this.yJr.setContentDescription(context.getString(C25738R.string.amx));
        dCp();
        AppMethodBeat.m2505o(30684);
    }

    public final void dCp() {
        AppMethodBeat.m2504i(30685);
        removeAllViews();
        addView(this.yJq, this.njH);
        addView(this.yJt, this.njH);
        addView(this.mpG, this.njH);
        addView(this.yJr, this.njH);
        AppMethodBeat.m2505o(30685);
    }

    /* renamed from: On */
    public final void mo10921On(int i) {
        AppMethodBeat.m2504i(30686);
        boolean z = i > 0;
        this.yJq.setClickable(z);
        this.yJq.setEnabled(z);
        if (C40788j.dBY().size() > 0) {
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
        AppMethodBeat.m2505o(30686);
    }

    /* renamed from: c */
    public final void mo10922c(int i, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(30687);
        switch (i) {
            case 0:
                this.yJq.setOnClickListener(onClickListener);
                AppMethodBeat.m2505o(30687);
                return;
            case 1:
                this.yJr.setOnClickListener(onClickListener);
                AppMethodBeat.m2505o(30687);
                return;
            case 2:
                this.yJs.setOnClickListener(onClickListener);
                AppMethodBeat.m2505o(30687);
                return;
            case 3:
                this.mpG.setOnClickListener(onClickListener);
                AppMethodBeat.m2505o(30687);
                return;
            case 4:
                this.yJt.setOnClickListener(onClickListener);
                AppMethodBeat.m2505o(30687);
                return;
            default:
                C4990ab.m7421w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(30687);
                return;
        }
    }
}
