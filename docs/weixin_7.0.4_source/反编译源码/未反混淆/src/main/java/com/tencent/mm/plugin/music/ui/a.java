package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.e;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a extends b {
    private c hAA;
    private View jyC;
    private View jyD;
    private TextView oOp;

    static /* synthetic */ boolean a(a aVar) {
        AppMethodBeat.i(105064);
        boolean bUK = aVar.bUK();
        AppMethodBeat.o(105064);
        return bUK;
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(105058);
        if (this.view != null) {
            this.oOp = (TextView) this.view.findViewById(R.id.dfa);
            this.jyC = this.view.findViewById(R.id.df_);
            this.jyD = this.view.findViewById(R.id.a2a);
            this.oOp.setTextSize(0, (float) com.tencent.mm.bz.a.al(ah.getContext(), R.dimen.kr));
            this.view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(105055);
                    e aih = com.tencent.mm.aw.a.aih();
                    Intent intent;
                    if (aih == null || !aih.fKt || TextUtils.isEmpty(aih.fKu)) {
                        intent = new Intent();
                        h.pYm.e(11992, Integer.valueOf(1));
                        intent.putExtra("key_scene", 1);
                        d.b((Context) a.this.vlu.get(), "music", ".ui.MusicMainUI", intent);
                        AppMethodBeat.o(105055);
                        return;
                    }
                    ab.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", aih.fKu);
                    intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    d.b((Context) a.this.vlu.get(), "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(105055);
                }
            });
        }
        this.hAA = new c<ke>() {
            {
                AppMethodBeat.i(105056);
                this.xxI = ke.class.getName().hashCode();
                AppMethodBeat.o(105056);
            }

            public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(105057);
                switch (((ke) bVar).cFH.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        a.a(a.this);
                        break;
                }
                AppMethodBeat.o(105057);
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xxA.c(this.hAA);
        AppMethodBeat.o(105058);
    }

    public final int getLayoutId() {
        return R.layout.ai0;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(105059);
        if (this.view != null) {
            this.view.findViewById(R.id.df_).setVisibility(i);
        }
        AppMethodBeat.o(105059);
    }

    public final boolean aMN() {
        AppMethodBeat.i(105060);
        boolean bUK = bUK();
        AppMethodBeat.o(105060);
        return bUK;
    }

    public final void destroy() {
        AppMethodBeat.i(105061);
        com.tencent.mm.sdk.b.a.xxA.d(this.hAA);
        AppMethodBeat.o(105061);
    }

    private void Tt(String str) {
        AppMethodBeat.i(105062);
        if (this.oOp != null) {
            this.oOp.setText(str);
        }
        AppMethodBeat.o(105062);
    }

    public final int getOrder() {
        return 1;
    }

    private boolean bUK() {
        AppMethodBeat.i(105063);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.a3h);
            this.jyC.setBackground(null);
            this.oOp.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.b7t);
            this.oOp.setBackgroundResource(R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.a_q);
            this.oOp.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackground(null);
            this.oOp.setBackgroundResource(R.drawable.a_q);
        }
        if (com.tencent.mm.aw.a.aie()) {
            int i;
            e aih = com.tencent.mm.aw.a.aih();
            Tt(ah.getContext().getString(R.string.d3t) + ah.getContext().getString(R.string.d3u) + aih.fJW);
            if (aih.fKq) {
                i = 8;
            } else {
                i = 0;
            }
            setVisibility(i);
            if (aih.fKq) {
                AppMethodBeat.o(105063);
                return false;
            }
            AppMethodBeat.o(105063);
            return true;
        } else if (com.tencent.mm.aw.a.aif()) {
            setVisibility(0);
            AppMethodBeat.o(105063);
            return true;
        } else {
            setVisibility(8);
            AppMethodBeat.o(105063);
            return false;
        }
    }
}
