package com.tencent.p177mm.pluginsdk.p597ui.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView */
public class WalletIconImageView extends ImageView {
    /* renamed from: uf */
    private int f4410uf;
    private int vvZ;
    private OnClickListener vwa;

    public WalletIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.vvZ = -1;
        this.f4410uf = 4;
        this.vwa = null;
    }

    public WalletIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setImageResource(int i) {
        AppMethodBeat.m2504i(48765);
        this.vvZ = i;
        super.setImageResource(i);
        AppMethodBeat.m2505o(48765);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(48766);
        this.f4410uf = i;
        super.setVisibility(i);
        AppMethodBeat.m2505o(48766);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.vwa = onClickListener;
    }

    public void setToClearState(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(48767);
        super.setVisibility(0);
        super.setImageResource(C25738R.drawable.f6801r8);
        super.setContentDescription(getContext().getString(C25738R.string.aqw));
        super.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(48767);
    }

    public final void dlG() {
        AppMethodBeat.m2504i(48768);
        super.setVisibility(this.f4410uf);
        super.setImageResource(this.vvZ);
        super.setOnClickListener(this.vwa);
        AppMethodBeat.m2505o(48768);
    }
}
