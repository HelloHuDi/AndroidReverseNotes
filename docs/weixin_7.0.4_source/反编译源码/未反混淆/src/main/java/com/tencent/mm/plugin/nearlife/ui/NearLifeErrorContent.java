package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class NearLifeErrorContent extends FrameLayout {
    private View contentView;
    private ListView gKd;
    private Context mContext;
    private TextView oSL;
    private View oSM;

    public NearLifeErrorContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(22990);
        this.mContext = context;
        init();
        AppMethodBeat.o(22990);
    }

    public NearLifeErrorContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(22991);
        this.mContext = context;
        init();
        AppMethodBeat.o(22991);
    }

    private void init() {
        AppMethodBeat.i(22992);
        this.contentView = View.inflate(this.mContext, R.layout.aib, this);
        this.oSL = (TextView) this.contentView.findViewById(R.id.dg9);
        this.oSM = this.contentView.findViewById(R.id.dg_);
        AppMethodBeat.o(22992);
    }

    public void setListView(ListView listView) {
        this.gKd = listView;
    }

    public final void Af(int i) {
        AppMethodBeat.i(22993);
        switch (i) {
            case 0:
                this.oSL.setVisibility(8);
                this.oSM.setVisibility(8);
                this.gKd.setVisibility(0);
                AppMethodBeat.o(22993);
                return;
            case 1:
                this.oSL.setVisibility(0);
                this.oSM.setVisibility(8);
                this.gKd.setVisibility(8);
                AppMethodBeat.o(22993);
                return;
            case 2:
                this.oSL.setVisibility(8);
                this.oSM.setVisibility(0);
                this.gKd.setVisibility(8);
                break;
        }
        AppMethodBeat.o(22993);
    }
}
