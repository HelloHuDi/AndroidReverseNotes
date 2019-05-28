package com.tencent.mm.plugin.webview.stub;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebviewScanImageActivity extends Activity {
    private int cvn;
    private int cvo;
    private String ffl;
    private String riC = null;
    private c riJ = new c<kv>() {
        {
            AppMethodBeat.i(7334);
            this.xxI = kv.class.getName().hashCode();
            AppMethodBeat.o(7334);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(7335);
            kv kvVar = (kv) bVar;
            if (kvVar != null && (kvVar instanceof kv)) {
                ab.i("MicroMsg.WebviewScanImageActivity", "notify Event: %d", Integer.valueOf(kvVar.cGM.cGK));
                ab.d("MicroMsg.WebviewScanImageActivity", "%s, %s", kvVar.cGM.activity, WebviewScanImageActivity.this);
                if (kvVar.cGM.activity == WebviewScanImageActivity.this && kvVar.cGM.ctB.equals(WebviewScanImageActivity.this.riC)) {
                    switch (kvVar.cGM.cGK) {
                        case 0:
                        case 1:
                        case 2:
                            com.tencent.mm.sdk.b.a.xxA.d(WebviewScanImageActivity.this.riJ);
                            WebviewScanImageActivity.this.finish();
                            break;
                        case 3:
                            com.tencent.mm.sdk.b.a.xxA.d(WebviewScanImageActivity.this.riJ);
                            WebviewScanImageActivity.this.finish();
                            break;
                    }
                }
                ab.e("MicroMsg.WebviewScanImageActivity", "not the same, eventStr: %s, origin: %s", kvVar.cGM.ctB, WebviewScanImageActivity.this.riC);
            } else {
                ab.e("MicroMsg.WebviewScanImageActivity", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            AppMethodBeat.o(7335);
            return false;
        }
    };
    private boolean uqS = false;
    private String uqT;
    private String url;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebviewScanImageActivity() {
        AppMethodBeat.i(7336);
        AppMethodBeat.o(7336);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7337);
        super.onCreate(bundle);
        ab.i("MicroMsg.WebviewScanImageActivity", "hy: on create");
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(j.INVALID_ID);
            getWindow().setStatusBarColor(0);
        }
        setContentView(R.layout.a9o);
        AppMethodBeat.o(7337);
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
        AppMethodBeat.i(7338);
        super.onStart();
        ab.i("MicroMsg.WebviewScanImageActivity", "hy: on start");
        if (!(this.uqS || getIntent() == null)) {
            this.riC = getIntent().getStringExtra("key_string_for_scan");
            this.cvn = getIntent().getIntExtra("key_codetype_for_scan", 0);
            this.cvo = getIntent().getIntExtra("key_codeversion_for_scan", 0);
            this.url = getIntent().getStringExtra("key_string_for_url");
            this.ffl = getIntent().getStringExtra("key_string_for_image_url");
            this.uqT = getIntent().getStringExtra("key_string_for_wxapp_id");
            if (this.riC != null) {
                com.tencent.mm.sdk.b.a.xxA.c(this.riJ);
                cf cfVar = new cf();
                cfVar.cvm.activity = this;
                cfVar.cvm.ctB = this.riC;
                cfVar.cvm.cvo = this.cvo;
                cfVar.cvm.cvn = this.cvn;
                cfVar.cvm.cvp = 6;
                cfVar.cvm.imagePath = this.ffl;
                cfVar.cvm.scene = 40;
                Bundle bundle = new Bundle();
                bundle.putString("stat_app_id", this.uqT);
                bundle.putString("stat_url", this.url);
                bundle.putInt("stat_scene", 4);
                cfVar.cvm.cvs = bundle;
                com.tencent.mm.sdk.b.a.xxA.m(cfVar);
            }
        }
        this.uqS = true;
        AppMethodBeat.o(7338);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.i(7339);
        super.onPause();
        ab.i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
        am amVar = new am();
        amVar.ctA.activity = this;
        amVar.ctA.ctB = this.riC;
        com.tencent.mm.sdk.b.a.xxA.m(amVar);
        com.tencent.mm.sdk.b.a.xxA.d(this.riJ);
        finish();
        AppMethodBeat.o(7339);
    }
}
