package com.tencent.p177mm.p612ui.websearch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.websearch.C23358a;
import com.tencent.p177mm.pluginsdk.p597ui.websearch.C23358a.C23362a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(7)
/* renamed from: com.tencent.mm.ui.websearch.WebSearchVoiceUI */
public class WebSearchVoiceUI extends WebSearchBaseActivity {
    private String cIy;
    private String cvF;
    private int scene;
    private C23358a zLK;
    private View zLL;
    private int zLM;

    /* renamed from: com.tencent.mm.ui.websearch.WebSearchVoiceUI$1 */
    class C159861 implements C23362a {
        C159861() {
        }

        public final void djr() {
            AppMethodBeat.m2504i(35381);
            WebSearchVoiceUI.this.setResult(0);
            C7060h.pYm.mo8381e(15178, Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.this.cvF, WebSearchVoiceUI.this.cIy, Integer.valueOf(WebSearchVoiceUI.this.scene), Integer.valueOf(WebSearchVoiceUI.this.zLM));
            WebSearchVoiceUI.this.finish();
            AppMethodBeat.m2505o(35381);
        }

        public final void ajt(String str) {
            AppMethodBeat.m2504i(35382);
            if (!TextUtils.isEmpty(str) && str.length() > 2) {
                str = str.substring(0, str.length() - 1);
            }
            Intent intent = new Intent();
            intent.putExtra("text", str);
            WebSearchVoiceUI.this.setResult(0, intent);
            C7060h.pYm.mo8381e(15178, Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.this.cvF, WebSearchVoiceUI.this.cIy, Integer.valueOf(WebSearchVoiceUI.this.scene), Integer.valueOf(WebSearchVoiceUI.this.zLM));
            WebSearchVoiceUI.this.finish();
            AppMethodBeat.m2505o(35382);
        }

        /* renamed from: oz */
        public final void mo28249oz(boolean z) {
            AppMethodBeat.m2504i(35383);
            if (z) {
                C7060h.pYm.mo8381e(15178, Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.this.cvF, WebSearchVoiceUI.this.cIy, Integer.valueOf(WebSearchVoiceUI.this.scene), Integer.valueOf(WebSearchVoiceUI.this.zLM));
            }
            AppMethodBeat.m2505o(35383);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130971205;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(35384);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.cvF = getIntent().getStringExtra("sessionId");
            this.cIy = getIntent().getStringExtra("subSessionId");
            this.scene = getIntent().getIntExtra("key_scene", -1);
            this.zLM = getIntent().getIntExtra("key_is_nav_voice", 0);
        }
        this.zLL = findViewById(2131828441);
        this.mController.hideTitleView();
        if (this.zLK == null) {
            this.zLK = new C23358a(this.mController.ylL);
            this.zLK.setCallback(new C159861());
        }
        this.zLK.dkM();
        C23358a c23358a = this.zLK;
        C4990ab.m7411d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", Integer.valueOf(c23358a.vmi), Boolean.valueOf(c23358a.vpB));
        if (c23358a.vpB) {
            c23358a.vpB = false;
            View findViewById = c23358a.findViewById(2131828442);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = c23358a.vmi;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            c23358a.dkO();
            c23358a.requestLayout();
        }
        this.zLK.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        ((ViewGroup) findViewById(2131820987)).addView(this.zLK, layoutParams2);
        C7060h.pYm.mo8381e(15178, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), "", this.cvF, this.cIy, Integer.valueOf(this.scene), Integer.valueOf(this.zLM));
        AppMethodBeat.m2505o(35384);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(35385);
        super.onBackPressed();
        setResult(0);
        finish();
        AppMethodBeat.m2505o(35385);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(35386);
        super.onDestroy();
        if (this.zLK != null) {
            this.zLK.destroy();
        }
        AppMethodBeat.m2505o(35386);
    }
}
