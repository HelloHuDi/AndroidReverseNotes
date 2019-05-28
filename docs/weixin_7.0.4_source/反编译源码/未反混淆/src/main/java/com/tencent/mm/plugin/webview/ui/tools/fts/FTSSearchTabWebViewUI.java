package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.a;

@a(3)
public class FTSSearchTabWebViewUI extends FTSBaseWebViewUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(8532);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(R.id.k0), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        AppMethodBeat.o(8532);
    }

    /* Access modifiers changed, original: protected */
    public String getHint() {
        AppMethodBeat.i(8533);
        String stringExtra = getIntent().getStringExtra("key_search_input_hint");
        if (TextUtils.isEmpty(stringExtra)) {
            int i = -1;
            switch (this.type) {
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
            if (this.scene == 56) {
                i = R.string.g8u;
            }
            if (i < 0) {
                stringExtra = ah.getContext().getResources().getString(R.string.te);
                AppMethodBeat.o(8533);
                return stringExtra;
            }
            stringExtra = ah.getContext().getResources().getString(R.string.e0a, new Object[]{ah.getContext().getResources().getString(i)});
            AppMethodBeat.o(8533);
            return stringExtra;
        }
        AppMethodBeat.o(8533);
        return stringExtra;
    }

    public void onResume() {
        AppMethodBeat.i(8535);
        super.onResume();
        an.cVv();
        AppMethodBeat.o(8535);
    }

    public void onPause() {
        AppMethodBeat.i(8536);
        super.onPause();
        an.cVw();
        AppMethodBeat.o(8536);
    }

    public void onClickCancelBtn(View view) {
        AppMethodBeat.i(8537);
        super.onClickCancelBtn(view);
        finish();
        AppMethodBeat.o(8537);
    }

    public final void Jw(int i) {
        AppMethodBeat.i(8538);
        if (this.pzf == null || this.pzf.getSettings() == null) {
            AppMethodBeat.o(8538);
            return;
        }
        float f = this.mController.ylL.getSharedPreferences(ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f >= 2.025f) {
            this.pzf.getSettings().setTextZoom(160);
            AppMethodBeat.o(8538);
        } else if (f >= 1.875f) {
            this.pzf.getSettings().setTextZoom(150);
            AppMethodBeat.o(8538);
        } else if (f >= 1.625f) {
            this.pzf.getSettings().setTextZoom(140);
            AppMethodBeat.o(8538);
        } else if (f >= 1.375f) {
            this.pzf.getSettings().setTextZoom(130);
            AppMethodBeat.o(8538);
        } else if (f >= 1.25f) {
            this.pzf.getSettings().setTextZoom(120);
            AppMethodBeat.o(8538);
        } else if (f >= 1.125f) {
            this.pzf.getSettings().setTextZoom(110);
            AppMethodBeat.o(8538);
        } else if (f >= 1.0f) {
            this.pzf.getSettings().setTextZoom(100);
            AppMethodBeat.o(8538);
        } else if (f >= 0.875f) {
            this.pzf.getSettings().setTextZoom(90);
            AppMethodBeat.o(8538);
        } else {
            this.pzf.getSettings().setTextZoom(80);
            AppMethodBeat.o(8538);
        }
    }

    public boolean aMo() {
        AppMethodBeat.i(8534);
        if (this.mIr != null) {
            this.mIr.getFtsEditText().mLL.clearFocus();
        }
        boolean aMo = super.aMo();
        AppMethodBeat.o(8534);
        return aMo;
    }
}
