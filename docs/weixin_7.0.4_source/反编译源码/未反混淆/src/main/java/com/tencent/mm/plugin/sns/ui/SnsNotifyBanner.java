package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class SnsNotifyBanner extends RelativeLayout {
    private View WL;
    private LayoutInflater mInflater;
    private TextView ruS;
    private ImageView ruT;
    int ruU = 0;
    private a ruV;

    public interface a {
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(39138);
        init();
        AppMethodBeat.o(39138);
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39139);
        init();
        AppMethodBeat.o(39139);
    }

    private void init() {
        AppMethodBeat.i(39140);
        this.mInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.WL = this.mInflater.inflate(R.layout.avw, this, true);
        this.ruS = (TextView) this.WL.findViewById(R.id.eki);
        this.ruT = (ImageView) this.WL.findViewById(R.id.ekj);
        this.ruT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39136);
                SnsNotifyBanner.this.setVisibility(8);
                AppMethodBeat.o(39136);
            }
        });
        AppMethodBeat.o(39140);
    }

    public void setOnClickNotify(a aVar) {
        AppMethodBeat.i(39141);
        this.ruV = aVar;
        this.ruS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39137);
                if (SnsNotifyBanner.this.ruV == null) {
                    AppMethodBeat.o(39137);
                    return;
                }
                if (SnsNotifyBanner.this.ruU > 0) {
                    SnsNotifyBanner.this.ruU = 0;
                    SnsNotifyBanner.this.ruV;
                } else {
                    SnsNotifyBanner.this.ruV;
                }
                SnsNotifyBanner.this.setVisibility(8);
                AppMethodBeat.o(39137);
            }
        });
        AppMethodBeat.o(39141);
    }
}
