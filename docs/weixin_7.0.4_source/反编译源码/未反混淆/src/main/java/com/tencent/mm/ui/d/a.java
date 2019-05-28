package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends b {
    String mUrl = null;
    private String nER = null;
    private boolean ysf = false;
    private com.tencent.mm.model.b.b.b ysg = null;
    private String ysh = "";

    public a(Context context, com.tencent.mm.model.b.b.b bVar) {
        super(context);
        AppMethodBeat.i(29991);
        this.ysg = bVar;
        refresh();
        AppMethodBeat.o(29991);
    }

    public final int getLayoutId() {
        return R.layout.nw;
    }

    private void refresh() {
        AppMethodBeat.i(29992);
        aw.ZK().Ym();
        if (com.tencent.mm.model.b.b.a(this.ysg)) {
            ab.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", this.ysg, this.nER, this.mUrl, Boolean.valueOf(this.ysf));
            if (this.ysg == com.tencent.mm.model.b.b.b.Chatting) {
                aw.ZK().Ym();
                this.nER = com.tencent.mm.model.b.b.aaQ();
                aw.ZK().Ym();
                this.mUrl = com.tencent.mm.model.b.b.aaR();
                aw.ZK().Ym();
                this.ysf = com.tencent.mm.model.b.b.aaS();
            } else {
                aw.ZK().Ym();
                this.nER = com.tencent.mm.model.b.b.aaN();
                aw.ZK().Ym();
                this.mUrl = com.tencent.mm.model.b.b.aaO();
                aw.ZK().Ym();
                this.ysf = com.tencent.mm.model.b.b.aaP();
            }
            TextView textView = (TextView) getView().findViewById(R.id.au2);
            ImageView imageView = (ImageView) getView().findViewById(R.id.au3);
            if (bo.isNullOrNil(this.nER)) {
                textView.setText(R.string.un);
            } else {
                textView.setText(this.nER);
            }
            textView.setSelected(true);
            if (bo.isNullOrNil(this.mUrl)) {
                getView().findViewById(R.id.au1).setBackgroundResource(R.color.a34);
                imageView.setImageResource(R.drawable.v7);
                textView.setTextColor(ah.getContext().getResources().getColor(R.color.a69));
            } else {
                getView().findViewById(R.id.au1).setBackgroundResource(R.drawable.a3h);
                imageView.setImageResource(R.drawable.v8);
                textView.setTextColor(ah.getContext().getResources().getColor(R.color.a3_));
            }
            getView().setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(29989);
                    a.this.Nx(1);
                    a aVar = a.this;
                    String str = a.this.mUrl;
                    if (bo.isNullOrNil(str)) {
                        ab.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
                        AppMethodBeat.o(29989);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    d.b((Context) aVar.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(29989);
                }
            });
            if (getView().getVisibility() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                g.RN();
                this.ysh = stringBuilder.append(com.tencent.mm.kernel.a.QF()).append("_").append(System.currentTimeMillis()).toString();
                Nx(0);
            }
            setVisibility(0);
            if (this.ysf) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(29990);
                        ab.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
                        a.this.Nx(2);
                        aw.ZK().Ym().c(com.tencent.mm.model.b.b.b.Main);
                        aw.ZK().Ym().c(com.tencent.mm.model.b.b.b.Chatting);
                        a.this.setVisibility(8);
                        AppMethodBeat.o(29990);
                    }
                });
                AppMethodBeat.o(29992);
                return;
            }
            imageView.setVisibility(8);
            AppMethodBeat.o(29992);
            return;
        }
        ab.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
        setVisibility(8);
        AppMethodBeat.o(29992);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(29993);
        super.setVisibility(i);
        getView().findViewById(R.id.au1).setVisibility(i);
        AppMethodBeat.o(29993);
    }

    public final boolean aMN() {
        AppMethodBeat.i(29994);
        refresh();
        boolean aMN = super.aMN();
        AppMethodBeat.o(29994);
        return aMN;
    }

    public final void destroy() {
    }

    /* Access modifiers changed, original: final */
    public final void Nx(int i) {
        int i2 = 1;
        AppMethodBeat.i(29995);
        h hVar = h.pYm;
        Object[] objArr = new Object[3];
        objArr[0] = this.ysh;
        objArr[1] = Integer.valueOf(i);
        if (this.ysg == com.tencent.mm.model.b.b.b.Main) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        hVar.e(14439, objArr);
        h.pYm.a(633, (long) i, 1, false);
        AppMethodBeat.o(29995);
    }
}
