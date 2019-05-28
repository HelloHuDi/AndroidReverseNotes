package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p835bd.C17977a;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI */
public class FTSSOSMoreWebViewUI extends BaseSOSWebViewUI {
    private View uBW;
    private int uBl;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI$2 */
    class C368582 implements Runnable {
        C368582() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8524);
            FTSSOSMoreWebViewUI.this.dby().bBo();
            FTSSOSMoreWebViewUI.this.dby().bBn();
            AppMethodBeat.m2505o(8524);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI$1 */
    class C368591 implements OnTouchListener {
        C368591() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(8523);
            FTSSOSMoreWebViewUI.this.dby().mLL.clearFocus();
            FTSSOSMoreWebViewUI.this.aqX();
            AppMethodBeat.m2505o(8523);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void aMh() {
        AppMethodBeat.m2504i(8525);
        super.aMh();
        this.uBW = findViewById(2131823600);
        dby().dJf();
        dby().bBs();
        this.oOO.setVisibility(0);
        dby().bBq();
        this.uBl = C1338a.fromDPToPix(this, 48);
        dby().setIconRes(C17977a.m28290b(getType(), (Context) this));
        if (bFf() == 24) {
            this.uBW.setVisibility(4);
        }
        findViewById(2131820987).setOnTouchListener(new C368591());
        if (getIntent() != null && getIntent().getBooleanExtra("ftsneedkeyboard", false)) {
            this.mController.contentView.postDelayed(new C368582(), 128);
        }
        mo30967at(getResources().getColor(C25738R.color.a69), true);
        ImageButton clearBtn = dby().getClearBtn();
        if (clearBtn != null) {
            clearBtn.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
        AppMethodBeat.m2505o(8525);
    }

    public final int aMi() {
        AppMethodBeat.m2504i(8526);
        int aMi;
        if (!C1443d.m3068iW(23) || C4971b.m7364Mt()) {
            aMi = super.aMi();
            AppMethodBeat.m2505o(8526);
            return aMi;
        }
        aMi = getResources().getColor(C25738R.color.a69);
        AppMethodBeat.m2505o(8526);
        return aMi;
    }

    /* renamed from: hz */
    public final void mo25276hz(boolean z) {
        AppMethodBeat.m2504i(8527);
        super.mo25276hz(z);
        if (!z) {
            this.uAr.setPadding(this.uBl, 0, this.uAr.getPaddingRight(), 0);
            this.oOO.setVisibility(0);
            dby().bBq();
        }
        dby().bBs();
        AppMethodBeat.m2505o(8527);
    }

    public boolean aMo() {
        AppMethodBeat.m2504i(8528);
        dby().bBs();
        this.uBW.setVisibility(0);
        boolean aMo = super.aMo();
        AppMethodBeat.m2505o(8528);
        return aMo;
    }

    public final int getLayoutId() {
        return 2130970838;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbu() {
        AppMethodBeat.m2504i(8529);
        finish();
        AppMethodBeat.m2505o(8529);
    }

    /* Access modifiers changed, original: protected */
    public String getHint() {
        AppMethodBeat.m2504i(8530);
        int i = -1;
        if (getType() != 8 || !this.uAK) {
            switch (getType()) {
                case 1:
                    i = C25738R.string.e0c;
                    break;
                case 2:
                    i = C25738R.string.e0b;
                    break;
                case 8:
                    i = C25738R.string.c1y;
                    break;
                case 16:
                    i = C25738R.string.c1w;
                    break;
                case 64:
                    i = C25738R.string.f8887i9;
                    break;
                case 128:
                    i = C25738R.string.c1m;
                    break;
                case 256:
                case 384:
                    i = C25738R.string.c1l;
                    break;
                case 512:
                    i = C25738R.string.c1u;
                    break;
                case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                    i = C25738R.string.c1v;
                    break;
            }
        }
        i = C25738R.string.c1z;
        String str;
        if (i < 0) {
            str = C4996ah.getContext().getResources().getString(C25738R.string.f9220te) + mo56361JA(getType());
            AppMethodBeat.m2505o(8530);
            return str;
        }
        str = C4996ah.getContext().getResources().getString(C25738R.string.e0a, new Object[]{C4996ah.getContext().getResources().getString(i)});
        AppMethodBeat.m2505o(8530);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbv() {
        AppMethodBeat.m2504i(8531);
        super.dbv();
        this.uBW.setVisibility(0);
        AppMethodBeat.m2505o(8531);
    }
}
