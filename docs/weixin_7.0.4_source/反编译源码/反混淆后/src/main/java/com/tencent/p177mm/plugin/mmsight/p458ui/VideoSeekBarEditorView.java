package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.mmsight.segment.RecyclerThumbSeekBar;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView */
public class VideoSeekBarEditorView extends LinearLayout {
    private Button lXI;
    public RecyclerThumbSeekBar oDA;
    private Button oDB;
    private LinearLayout oDC;

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(55302);
        init(context);
        AppMethodBeat.m2505o(55302);
    }

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(55303);
        init(context);
        AppMethodBeat.m2505o(55303);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(55304);
        this.oDC = (LinearLayout) C5616v.m8409hu(context).inflate(2130970997, this, true);
        this.oDA = (RecyclerThumbSeekBar) findViewById(2131828430);
        this.lXI = (Button) findViewById(2131826542);
        this.oDB = (Button) findViewById(2131826543);
        AppMethodBeat.m2505o(55304);
    }

    public void setTextColor(String str) {
        AppMethodBeat.m2504i(55305);
        if (str != null) {
            this.oDB.setTextColor(Color.parseColor(str));
        }
        AppMethodBeat.m2505o(55305);
    }

    public void setFinishButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(55306);
        this.oDB.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(55306);
    }

    public void setCancelButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(55307);
        this.lXI.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(55307);
    }

    public final void bQM() {
        AppMethodBeat.m2504i(55308);
        this.oDA.release();
        ViewParent parent = this.oDA.getParent();
        if (parent instanceof LinearLayout) {
            LayoutParams layoutParams = (LayoutParams) this.oDA.getLayoutParams();
            ((LinearLayout) parent).removeView(this.oDA);
            this.oDA = new RecyclerThumbSeekBar(getContext());
            ((LinearLayout) parent).addView(this.oDA, 0, layoutParams);
        }
        AppMethodBeat.m2505o(55308);
    }
}
