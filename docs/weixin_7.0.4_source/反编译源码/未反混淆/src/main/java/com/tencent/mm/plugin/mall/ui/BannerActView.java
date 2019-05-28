package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public class BannerActView extends LinearLayout {
    private List<a> olh;
    private u oli;
    private TextView olj = ((TextView) LayoutInflater.from(getContext()).inflate(R.layout.g7, this, true).findViewById(R.id.a4_));

    public BannerActView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(43128);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(43127);
                BannerActView.this.setVisibility(8);
                b.dT(BannerActView.this.olh);
                if (BannerActView.this.olh != null && BannerActView.this.olh.size() > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ((a) BannerActView.this.olh.get(0)).tDk);
                    d.b(BannerActView.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(43127);
            }
        });
        AppMethodBeat.o(43128);
    }

    public void setData(u uVar) {
        AppMethodBeat.i(43129);
        this.oli = uVar;
        if (this.oli != null) {
            this.olj.setText(this.oli.field_bulletin_content);
            setVisibility(0);
            AppMethodBeat.o(43129);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(43129);
    }

    public void setActivityList(List<a> list) {
        AppMethodBeat.i(43130);
        this.olh = list;
        if (this.olh == null || this.olh.size() <= 0) {
            ab.i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
        } else if (b.dS(this.olh)) {
            this.olj.setText(((a) this.olh.get(0)).tDj);
            setVisibility(0);
            AppMethodBeat.o(43130);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(43130);
    }
}
