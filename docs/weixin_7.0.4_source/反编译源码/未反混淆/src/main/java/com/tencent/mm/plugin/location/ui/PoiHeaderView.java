package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class PoiHeaderView extends RelativeLayout {
    private Context context;
    public TextView eku;
    public String nMe = "";
    public String nMf = "";
    public SimpleImageView nMg;

    public PoiHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113469);
        this.context = context;
        View inflate = View.inflate(this.context, R.layout.akk, this);
        this.eku = (TextView) inflate.findViewById(R.id.dnh);
        this.nMg = (SimpleImageView) inflate.findViewById(R.id.dni);
        this.eku.setVisibility(8);
        this.nMg.setVisibility(8);
        setVisibility(8);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(113468);
                Intent intent = new Intent();
                ab.d("MicroMsg.PoiHeaderView", "click url %s", bo.isNullOrNil(PoiHeaderView.this.nMf) ? PoiHeaderView.this.nMe : PoiHeaderView.this.nMf);
                intent.putExtra("rawUrl", r0);
                intent.putExtra("showShare", false);
                d.f(PoiHeaderView.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                AppMethodBeat.o(113468);
            }
        });
        AppMethodBeat.o(113469);
    }

    public void setViewUrl(String str) {
        AppMethodBeat.i(113470);
        ab.d("MicroMsg.PoiHeaderView", "viewUrl ".concat(String.valueOf(str)));
        this.nMf = str;
        AppMethodBeat.o(113470);
    }
}
