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
import com.tencent.mm.sdk.platformtools.ab;

public class ToolsBar extends LinearLayout {
    private LayoutParams njH = new LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.nb), 1.0f);
    private ImageButton yJq = new ImageButton(getContext());
    private ImageButton yJt;
    private ImageButton yMI;

    public ToolsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(31072);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.drawable.ay1);
        this.yJq.setImageResource(R.drawable.hr);
        this.yJq.setScaleType(ScaleType.CENTER);
        this.yJq.setBackgroundResource(0);
        this.yJq.setContentDescription(context.getString(R.string.amz));
        this.yJt = new ImageButton(getContext());
        this.yJt.setImageResource(R.drawable.ho);
        this.yJt.setScaleType(ScaleType.CENTER);
        this.yJt.setBackgroundResource(0);
        this.yJt.setContentDescription(context.getString(R.string.amy));
        this.yMI = new ImageButton(getContext());
        this.yMI.setImageResource(R.drawable.hq);
        this.yMI.setScaleType(ScaleType.CENTER);
        this.yMI.setBackgroundResource(0);
        this.yMI.setContentDescription(context.getString(R.string.amy));
        removeAllViews();
        addView(this.yJq, this.njH);
        addView(this.yJt, this.njH);
        addView(this.yMI, this.njH);
        AppMethodBeat.o(31072);
    }

    public final void c(int i, OnClickListener onClickListener) {
        AppMethodBeat.i(31073);
        switch (i) {
            case 0:
                this.yJq.setOnClickListener(onClickListener);
                AppMethodBeat.o(31073);
                return;
            case 1:
                this.yJt.setOnClickListener(onClickListener);
                AppMethodBeat.o(31073);
                return;
            case 2:
                this.yMI.setOnClickListener(onClickListener);
                AppMethodBeat.o(31073);
                return;
            default:
                ab.w("MicroMsg.ToolsBar", "set button listener error button index %d", Integer.valueOf(i));
                AppMethodBeat.o(31073);
                return;
        }
    }
}
