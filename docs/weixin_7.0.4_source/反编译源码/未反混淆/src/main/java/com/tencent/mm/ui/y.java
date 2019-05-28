package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.i.a;

public final class y extends LinearLayout implements a {
    private ImageView ejo = ((ImageView) findViewById(R.id.qk));
    private TextView jPp = ((TextView) findViewById(R.id.a76));
    private TextView qha = ((TextView) findViewById(R.id.dcf));
    private HeaderContainer yoe;
    private ImageView yof = ((ImageView) findViewById(R.id.dce));

    public y(Context context) {
        super(context);
        AppMethodBeat.i(29684);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.ahb, this, true);
        AppMethodBeat.o(29684);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(29685);
        super.onDraw(canvas);
        AppMethodBeat.o(29685);
    }

    public final void setHeaderContainer(HeaderContainer headerContainer) {
        this.yoe = headerContainer;
    }

    public final void setAccountName(String str) {
        AppMethodBeat.i(29686);
        if (this.qha != null) {
            this.qha.setText(getResources().getString(R.string.fr, new Object[]{str}));
        }
        AppMethodBeat.o(29686);
    }

    public final void setNickNameTV(SpannableString spannableString) {
        AppMethodBeat.i(29687);
        if (this.jPp != null) {
            this.jPp.setText(spannableString);
        }
        AppMethodBeat.o(29687);
    }

    public final ImageView getQrCodeIv() {
        return this.yof;
    }

    public final TextView getNickNameTV() {
        return this.jPp;
    }
}
