package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;

public class PaddingImageView extends FrameLayout {
    ImageView ikh;
    ImageView lgi;
    private int lgj;

    public ImageView getImageView() {
        return this.ikh;
    }

    public ImageView getImageViewFG() {
        return this.lgi;
    }

    public PaddingImageView(Context context) {
        super(context);
        AppMethodBeat.i(53836);
        init(context);
        AppMethodBeat.o(53836);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(53837);
        init(context);
        AppMethodBeat.o(53837);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(53838);
        init(context);
        AppMethodBeat.o(53838);
    }

    private void init(Context context) {
        AppMethodBeat.i(53839);
        this.lgj = a.al(getContext(), R.dimen.m4);
        this.ikh = new ImageView(context);
        this.ikh.setPadding(this.lgj, this.lgj, this.lgj, this.lgj);
        this.lgi = new ImageView(context);
        AppMethodBeat.o(53839);
    }
}
