package com.tencent.mm.ui.fts.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;

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
        AppMethodBeat.i(91594);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.ax_, this, true);
        AppMethodBeat.o(91594);
    }

    @SuppressLint({"WrongViewCast"})
    public final void init() {
        AppMethodBeat.i(91595);
        super.init();
        this.zyg = findViewById(R.id.eo5);
        this.zyh = findViewById(R.id.eo7);
        this.zyi = findViewById(R.id.eo6);
        getEditText().setOnFocusChangeListener(null);
        getEditText().setHintTextColor(getResources().getColor(R.color.sy));
        getEditText().setTextColor(getResources().getColor(R.color.w4));
        AppMethodBeat.o(91595);
    }

    public final void dJf() {
        AppMethodBeat.i(91596);
        getEditText().setOnFocusChangeListener(this.mLV);
        AppMethodBeat.o(91596);
    }

    public void setIconRes(Drawable drawable) {
        AppMethodBeat.i(91597);
        getIconView().setImageDrawable(drawable);
        AppMethodBeat.o(91597);
    }

    public void setSearchBarCancelTextContainerVisibile(int i) {
        AppMethodBeat.i(91598);
        if (this.zyi != null) {
            this.zyi.setVisibility(i);
        }
        AppMethodBeat.o(91598);
    }

    public void setVoiceImageButtonVisibile(int i) {
        AppMethodBeat.i(91599);
        if (this.zyg != null) {
            this.zyg.setVisibility(i);
        }
        AppMethodBeat.o(91599);
    }

    public void setVoiceBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(91600);
        if (this.zyg != null) {
            this.zyg.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(91600);
    }

    public void setCancelTextViewVisibile(int i) {
        AppMethodBeat.i(91601);
        if (this.zyh != null) {
            this.zyh.setVisibility(i);
        }
        AppMethodBeat.o(91601);
    }

    public void setCancelTextViewClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(91602);
        if (this.zyh != null) {
            this.zyh.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(91602);
    }
}
