package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class WalletIconImageView extends ImageView {
    private int uf;
    private int vvZ;
    private OnClickListener vwa;

    public WalletIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.vvZ = -1;
        this.uf = 4;
        this.vwa = null;
    }

    public WalletIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(48765);
        this.vvZ = i;
        super.setImageResource(i);
        AppMethodBeat.o(48765);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(48766);
        this.uf = i;
        super.setVisibility(i);
        AppMethodBeat.o(48766);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.vwa = onClickListener;
    }

    public void setToClearState(OnClickListener onClickListener) {
        AppMethodBeat.i(48767);
        super.setVisibility(0);
        super.setImageResource(R.drawable.r8);
        super.setContentDescription(getContext().getString(R.string.aqw));
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(48767);
    }

    public final void dlG() {
        AppMethodBeat.i(48768);
        super.setVisibility(this.uf);
        super.setImageResource(this.vvZ);
        super.setOnClickListener(this.vwa);
        AppMethodBeat.o(48768);
    }
}
