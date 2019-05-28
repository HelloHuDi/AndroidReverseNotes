package com.tencent.p177mm.p612ui.fts.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fts.p424ui.widget.FTSEditTextView;

/* renamed from: com.tencent.mm.ui.fts.widget.SOSEditTextView */
public class SOSEditTextView extends FTSEditTextView {
    private View zyg;
    private View zyh;
    private View zyi;

    public SOSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SOSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bBm() {
        AppMethodBeat.m2504i(91594);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130970836, this, true);
        AppMethodBeat.m2505o(91594);
    }

    @SuppressLint({"WrongViewCast"})
    public final void init() {
        AppMethodBeat.m2504i(91595);
        super.init();
        this.zyg = findViewById(2131827948);
        this.zyh = findViewById(2131827950);
        this.zyi = findViewById(2131827949);
        getEditText().setOnFocusChangeListener(null);
        getEditText().setHintTextColor(getResources().getColor(C25738R.color.f12116sy));
        getEditText().setTextColor(getResources().getColor(C25738R.color.f12212w4));
        AppMethodBeat.m2505o(91595);
    }

    public final void dJf() {
        AppMethodBeat.m2504i(91596);
        getEditText().setOnFocusChangeListener(this.mLV);
        AppMethodBeat.m2505o(91596);
    }

    public void setIconRes(Drawable drawable) {
        AppMethodBeat.m2504i(91597);
        getIconView().setImageDrawable(drawable);
        AppMethodBeat.m2505o(91597);
    }

    public void setSearchBarCancelTextContainerVisibile(int i) {
        AppMethodBeat.m2504i(91598);
        if (this.zyi != null) {
            this.zyi.setVisibility(i);
        }
        AppMethodBeat.m2505o(91598);
    }

    public void setVoiceImageButtonVisibile(int i) {
        AppMethodBeat.m2504i(91599);
        if (this.zyg != null) {
            this.zyg.setVisibility(i);
        }
        AppMethodBeat.m2505o(91599);
    }

    public void setVoiceBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(91600);
        if (this.zyg != null) {
            this.zyg.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(91600);
    }

    public void setCancelTextViewVisibile(int i) {
        AppMethodBeat.m2504i(91601);
        if (this.zyh != null) {
            this.zyh.setVisibility(i);
        }
        AppMethodBeat.m2505o(91601);
    }

    public void setCancelTextViewClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(91602);
        if (this.zyh != null) {
            this.zyh.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(91602);
    }
}
