package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.smtt.sdk.WebView;

public class FTSSOSMoreWebViewUI extends BaseSOSWebViewUI {
    private View uBW;
    private int uBl;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void aMh() {
        AppMethodBeat.i(8525);
        super.aMh();
        this.uBW = findViewById(R.id.bhl);
        dby().dJf();
        dby().bBs();
        this.oOO.setVisibility(0);
        dby().bBq();
        this.uBl = a.fromDPToPix(this, 48);
        dby().setIconRes(com.tencent.mm.bd.a.b(getType(), (Context) this));
        if (bFf() == 24) {
            this.uBW.setVisibility(4);
        }
        findViewById(R.id.l_).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(8523);
                FTSSOSMoreWebViewUI.this.dby().mLL.clearFocus();
                FTSSOSMoreWebViewUI.this.aqX();
                AppMethodBeat.o(8523);
                return false;
            }
        });
        if (getIntent() != null && getIntent().getBooleanExtra("ftsneedkeyboard", false)) {
            this.mController.contentView.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8524);
                    FTSSOSMoreWebViewUI.this.dby().bBo();
                    FTSSOSMoreWebViewUI.this.dby().bBn();
                    AppMethodBeat.o(8524);
                }
            }, 128);
        }
        at(getResources().getColor(R.color.a69), true);
        ImageButton clearBtn = dby().getClearBtn();
        if (clearBtn != null) {
            clearBtn.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
        AppMethodBeat.o(8525);
    }

    public final int aMi() {
        AppMethodBeat.i(8526);
        int aMi;
        if (!d.iW(23) || b.Mt()) {
            aMi = super.aMi();
            AppMethodBeat.o(8526);
            return aMi;
        }
        aMi = getResources().getColor(R.color.a69);
        AppMethodBeat.o(8526);
        return aMi;
    }

    public final void hz(boolean z) {
        AppMethodBeat.i(8527);
        super.hz(z);
        if (!z) {
            this.uAr.setPadding(this.uBl, 0, this.uAr.getPaddingRight(), 0);
            this.oOO.setVisibility(0);
            dby().bBq();
        }
        dby().bBs();
        AppMethodBeat.o(8527);
    }

    public boolean aMo() {
        AppMethodBeat.i(8528);
        dby().bBs();
        this.uBW.setVisibility(0);
        boolean aMo = super.aMo();
        AppMethodBeat.o(8528);
        return aMo;
    }

    public final int getLayoutId() {
        return R.layout.axb;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbu() {
        AppMethodBeat.i(8529);
        finish();
        AppMethodBeat.o(8529);
    }

    /* Access modifiers changed, original: protected */
    public String getHint() {
        AppMethodBeat.i(8530);
        int i = -1;
        if (getType() != 8 || !this.uAK) {
            switch (getType()) {
                case 1:
                    i = R.string.e0c;
                    break;
                case 2:
                    i = R.string.e0b;
                    break;
                case 8:
                    i = R.string.c1y;
                    break;
                case 16:
                    i = R.string.c1w;
                    break;
                case 64:
                    i = R.string.i9;
                    break;
                case 128:
                    i = R.string.c1m;
                    break;
                case 256:
                case 384:
                    i = R.string.c1l;
                    break;
                case 512:
                    i = R.string.c1u;
                    break;
                case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                    i = R.string.c1v;
                    break;
            }
        }
        i = R.string.c1z;
        String str;
        if (i < 0) {
            str = ah.getContext().getResources().getString(R.string.te) + JA(getType());
            AppMethodBeat.o(8530);
            return str;
        }
        str = ah.getContext().getResources().getString(R.string.e0a, new Object[]{ah.getContext().getResources().getString(i)});
        AppMethodBeat.o(8530);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbv() {
        AppMethodBeat.i(8531);
        super.dbv();
        this.uBW.setVisibility(0);
        AppMethodBeat.o(8531);
    }
}
