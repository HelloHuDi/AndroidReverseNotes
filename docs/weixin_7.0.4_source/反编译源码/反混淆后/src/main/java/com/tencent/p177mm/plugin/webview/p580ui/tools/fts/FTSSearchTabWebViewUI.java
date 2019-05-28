package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI */
public class FTSSearchTabWebViewUI extends FTSBaseWebViewUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(8532);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(2131820940), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        AppMethodBeat.m2505o(8532);
    }

    /* Access modifiers changed, original: protected */
    public String getHint() {
        AppMethodBeat.m2504i(8533);
        String stringExtra = getIntent().getStringExtra("key_search_input_hint");
        if (TextUtils.isEmpty(stringExtra)) {
            int i = -1;
            switch (this.type) {
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
            if (this.scene == 56) {
                i = C25738R.string.g8u;
            }
            if (i < 0) {
                stringExtra = C4996ah.getContext().getResources().getString(C25738R.string.f9220te);
                AppMethodBeat.m2505o(8533);
                return stringExtra;
            }
            stringExtra = C4996ah.getContext().getResources().getString(C25738R.string.e0a, new Object[]{C4996ah.getContext().getResources().getString(i)});
            AppMethodBeat.m2505o(8533);
            return stringExtra;
        }
        AppMethodBeat.m2505o(8533);
        return stringExtra;
    }

    public void onResume() {
        AppMethodBeat.m2504i(8535);
        super.onResume();
        C14423an.cVv();
        AppMethodBeat.m2505o(8535);
    }

    public void onPause() {
        AppMethodBeat.m2504i(8536);
        super.onPause();
        C14423an.cVw();
        AppMethodBeat.m2505o(8536);
    }

    public void onClickCancelBtn(View view) {
        AppMethodBeat.m2504i(8537);
        super.onClickCancelBtn(view);
        finish();
        AppMethodBeat.m2505o(8537);
    }

    /* renamed from: Jw */
    public final void mo30945Jw(int i) {
        AppMethodBeat.m2504i(8538);
        if (this.pzf == null || this.pzf.getSettings() == null) {
            AppMethodBeat.m2505o(8538);
            return;
        }
        float f = this.mController.ylL.getSharedPreferences(C4996ah.doA(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f >= 2.025f) {
            this.pzf.getSettings().setTextZoom(160);
            AppMethodBeat.m2505o(8538);
        } else if (f >= 1.875f) {
            this.pzf.getSettings().setTextZoom(150);
            AppMethodBeat.m2505o(8538);
        } else if (f >= 1.625f) {
            this.pzf.getSettings().setTextZoom(140);
            AppMethodBeat.m2505o(8538);
        } else if (f >= 1.375f) {
            this.pzf.getSettings().setTextZoom(130);
            AppMethodBeat.m2505o(8538);
        } else if (f >= 1.25f) {
            this.pzf.getSettings().setTextZoom(120);
            AppMethodBeat.m2505o(8538);
        } else if (f >= 1.125f) {
            this.pzf.getSettings().setTextZoom(110);
            AppMethodBeat.m2505o(8538);
        } else if (f >= 1.0f) {
            this.pzf.getSettings().setTextZoom(100);
            AppMethodBeat.m2505o(8538);
        } else if (f >= 0.875f) {
            this.pzf.getSettings().setTextZoom(90);
            AppMethodBeat.m2505o(8538);
        } else {
            this.pzf.getSettings().setTextZoom(80);
            AppMethodBeat.m2505o(8538);
        }
    }

    public boolean aMo() {
        AppMethodBeat.m2504i(8534);
        if (this.mIr != null) {
            this.mIr.getFtsEditText().mLL.clearFocus();
        }
        boolean aMo = super.aMo();
        AppMethodBeat.m2505o(8534);
        return aMo;
    }
}
