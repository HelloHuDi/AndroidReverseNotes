package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader extends LinearLayout {
    private TextView gne;
    private Context mContext;
    private ViewGroup nMu;
    private MMImageButton nMv;
    private MMImageButton nMw;

    @TargetApi(11)
    public ShareHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(113485);
        this.mContext = context;
        init();
        AppMethodBeat.o(113485);
    }

    public ShareHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113486);
        this.mContext = context;
        init();
        AppMethodBeat.o(113486);
    }

    private void init() {
        AppMethodBeat.i(113487);
        View inflate = View.inflate(this.mContext, R.layout.ask, this);
        this.nMu = (ViewGroup) inflate.findViewById(R.id.d80);
        this.nMv = (MMImageButton) inflate.findViewById(R.id.ecz);
        this.nMw = (MMImageButton) inflate.findViewById(R.id.ed1);
        this.gne = (TextView) inflate.findViewById(R.id.cx);
        AppMethodBeat.o(113487);
    }

    public ViewGroup getHeaderBar() {
        return this.nMu;
    }

    public void setOnLeftClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(113488);
        this.nMv.setOnClickListener(onClickListener);
        AppMethodBeat.o(113488);
    }

    public void setOnRightClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(113489);
        this.nMw.setOnClickListener(onClickListener);
        AppMethodBeat.o(113489);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(113490);
        this.gne.setText(str);
        AppMethodBeat.o(113490);
    }

    public void setTitleColor(int i) {
        AppMethodBeat.i(113491);
        this.gne.setTextColor(i);
        AppMethodBeat.o(113491);
    }
}
