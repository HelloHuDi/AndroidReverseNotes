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
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.chatting.ToolsBar */
public class ToolsBar extends LinearLayout {
    private LayoutParams njH = new LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.f10010nb), 1.0f);
    private ImageButton yJq = new ImageButton(getContext());
    private ImageButton yJt;
    private ImageButton yMI;

    public ToolsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(31072);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(C25738R.drawable.ay1);
        this.yJq.setImageResource(C25738R.drawable.f6547hr);
        this.yJq.setScaleType(ScaleType.CENTER);
        this.yJq.setBackgroundResource(0);
        this.yJq.setContentDescription(context.getString(C25738R.string.amz));
        this.yJt = new ImageButton(getContext());
        this.yJt.setImageResource(C25738R.drawable.f6544ho);
        this.yJt.setScaleType(ScaleType.CENTER);
        this.yJt.setBackgroundResource(0);
        this.yJt.setContentDescription(context.getString(C25738R.string.amy));
        this.yMI = new ImageButton(getContext());
        this.yMI.setImageResource(C25738R.drawable.f6546hq);
        this.yMI.setScaleType(ScaleType.CENTER);
        this.yMI.setBackgroundResource(0);
        this.yMI.setContentDescription(context.getString(C25738R.string.amy));
        removeAllViews();
        addView(this.yJq, this.njH);
        addView(this.yJt, this.njH);
        addView(this.yMI, this.njH);
        AppMethodBeat.m2505o(31072);
    }

    /* renamed from: c */
    public final void mo56995c(int i, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(31073);
        switch (i) {
            case 0:
                this.yJq.setOnClickListener(onClickListener);
                AppMethodBeat.m2505o(31073);
                return;
            case 1:
                this.yJt.setOnClickListener(onClickListener);
                AppMethodBeat.m2505o(31073);
                return;
            case 2:
                this.yMI.setOnClickListener(onClickListener);
                AppMethodBeat.m2505o(31073);
                return;
            default:
                C4990ab.m7421w("MicroMsg.ToolsBar", "set button listener error button index %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(31073);
                return;
        }
    }
}
