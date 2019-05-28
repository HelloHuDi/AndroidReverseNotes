package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.ui.v;

public class VideoSeekBarEditorView extends LinearLayout {
    private Button lXI;
    public RecyclerThumbSeekBar oDA;
    private Button oDB;
    private LinearLayout oDC;

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55302);
        init(context);
        AppMethodBeat.o(55302);
    }

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(55303);
        init(context);
        AppMethodBeat.o(55303);
    }

    private void init(Context context) {
        AppMethodBeat.i(55304);
        this.oDC = (LinearLayout) v.hu(context).inflate(R.layout.b1k, this, true);
        this.oDA = (RecyclerThumbSeekBar) findViewById(R.id.f16);
        this.lXI = (Button) findViewById(R.id.dn5);
        this.oDB = (Button) findViewById(R.id.dn6);
        AppMethodBeat.o(55304);
    }

    public void setTextColor(String str) {
        AppMethodBeat.i(55305);
        if (str != null) {
            this.oDB.setTextColor(Color.parseColor(str));
        }
        AppMethodBeat.o(55305);
    }

    public void setFinishButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(55306);
        this.oDB.setOnClickListener(onClickListener);
        AppMethodBeat.o(55306);
    }

    public void setCancelButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(55307);
        this.lXI.setOnClickListener(onClickListener);
        AppMethodBeat.o(55307);
    }

    public final void bQM() {
        AppMethodBeat.i(55308);
        this.oDA.release();
        ViewParent parent = this.oDA.getParent();
        if (parent instanceof LinearLayout) {
            LayoutParams layoutParams = (LayoutParams) this.oDA.getLayoutParams();
            ((LinearLayout) parent).removeView(this.oDA);
            this.oDA = new RecyclerThumbSeekBar(getContext());
            ((LinearLayout) parent).addView(this.oDA, 0, layoutParams);
        }
        AppMethodBeat.o(55308);
    }
}
