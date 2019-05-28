package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.PaddingImageView */
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
        AppMethodBeat.m2504i(53836);
        init(context);
        AppMethodBeat.m2505o(53836);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(53837);
        init(context);
        AppMethodBeat.m2505o(53837);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(53838);
        init(context);
        AppMethodBeat.m2505o(53838);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(53839);
        this.lgj = C1338a.m2856al(getContext(), C25738R.dimen.f9979m4);
        this.ikh = new ImageView(context);
        this.ikh.setPadding(this.lgj, this.lgj, this.lgj, this.lgj);
        this.lgi = new ImageView(context);
        AppMethodBeat.m2505o(53839);
    }
}
