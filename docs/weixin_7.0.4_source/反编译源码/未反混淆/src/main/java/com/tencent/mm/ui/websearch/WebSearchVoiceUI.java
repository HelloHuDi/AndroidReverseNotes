package com.tencent.mm.ui.websearch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebSearchVoiceUI extends WebSearchBaseActivity {
    private String cIy;
    private String cvF;
    private int scene;
    private com.tencent.mm.pluginsdk.ui.websearch.a zLK;
    private View zLL;
    private int zLM;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.b75;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35384);
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.cvF = getIntent().getStringExtra("sessionId");
            this.cIy = getIntent().getStringExtra("subSessionId");
            this.scene = getIntent().getIntExtra("key_scene", -1);
            this.zLM = getIntent().getIntExtra("key_is_nav_voice", 0);
        }
        this.zLL = findViewById(R.id.f1g);
        this.mController.hideTitleView();
        if (this.zLK == null) {
            this.zLK = new com.tencent.mm.pluginsdk.ui.websearch.a(this.mController.ylL);
            this.zLK.setCallback(new com.tencent.mm.pluginsdk.ui.websearch.a.a() {
                public final void djr() {
                    AppMethodBeat.i(35381);
                    WebSearchVoiceUI.this.setResult(0);
                    h.pYm.e(15178, Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.this.cvF, WebSearchVoiceUI.this.cIy, Integer.valueOf(WebSearchVoiceUI.this.scene), Integer.valueOf(WebSearchVoiceUI.this.zLM));
                    WebSearchVoiceUI.this.finish();
                    AppMethodBeat.o(35381);
                }

                public final void ajt(String str) {
                    AppMethodBeat.i(35382);
                    if (!TextUtils.isEmpty(str) && str.length() > 2) {
                        str = str.substring(0, str.length() - 1);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("text", str);
                    WebSearchVoiceUI.this.setResult(0, intent);
                    h.pYm.e(15178, Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.this.cvF, WebSearchVoiceUI.this.cIy, Integer.valueOf(WebSearchVoiceUI.this.scene), Integer.valueOf(WebSearchVoiceUI.this.zLM));
                    WebSearchVoiceUI.this.finish();
                    AppMethodBeat.o(35382);
                }

                public final void oz(boolean z) {
                    AppMethodBeat.i(35383);
                    if (z) {
                        h.pYm.e(15178, Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.this.cvF, WebSearchVoiceUI.this.cIy, Integer.valueOf(WebSearchVoiceUI.this.scene), Integer.valueOf(WebSearchVoiceUI.this.zLM));
                    }
                    AppMethodBeat.o(35383);
                }
            });
        }
        this.zLK.dkM();
        com.tencent.mm.pluginsdk.ui.websearch.a aVar = this.zLK;
        ab.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", Integer.valueOf(aVar.vmi), Boolean.valueOf(aVar.vpB));
        if (aVar.vpB) {
            aVar.vpB = false;
            View findViewById = aVar.findViewById(R.id.f1h);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = aVar.vmi;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            aVar.dkO();
            aVar.requestLayout();
        }
        this.zLK.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        ((ViewGroup) findViewById(R.id.l_)).addView(this.zLK, layoutParams2);
        h.pYm.e(15178, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), "", this.cvF, this.cIy, Integer.valueOf(this.scene), Integer.valueOf(this.zLM));
        AppMethodBeat.o(35384);
    }

    public void onBackPressed() {
        AppMethodBeat.i(35385);
        super.onBackPressed();
        setResult(0);
        finish();
        AppMethodBeat.o(35385);
    }

    public void onDestroy() {
        AppMethodBeat.i(35386);
        super.onDestroy();
        if (this.zLK != null) {
            this.zLK.destroy();
        }
        AppMethodBeat.o(35386);
    }
}
