package com.tencent.p177mm.plugin.webview.stub;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C41964am;
import com.tencent.p177mm.p230g.p231a.C42019kv;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity */
public class WebviewScanImageActivity extends Activity {
    private int cvn;
    private int cvo;
    private String ffl;
    private String riC = null;
    private C4884c riJ = new C356231();
    private boolean uqS = false;
    private String uqT;
    private String url;

    /* renamed from: com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity$1 */
    class C356231 extends C4884c<C42019kv> {
        C356231() {
            super(0);
            AppMethodBeat.m2504i(7334);
            this.xxI = C42019kv.class.getName().hashCode();
            AppMethodBeat.m2505o(7334);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(7335);
            C42019kv c42019kv = (C42019kv) c4883b;
            if (c42019kv != null && (c42019kv instanceof C42019kv)) {
                C4990ab.m7417i("MicroMsg.WebviewScanImageActivity", "notify Event: %d", Integer.valueOf(c42019kv.cGM.cGK));
                C4990ab.m7411d("MicroMsg.WebviewScanImageActivity", "%s, %s", c42019kv.cGM.activity, WebviewScanImageActivity.this);
                if (c42019kv.cGM.activity == WebviewScanImageActivity.this && c42019kv.cGM.ctB.equals(WebviewScanImageActivity.this.riC)) {
                    switch (c42019kv.cGM.cGK) {
                        case 0:
                        case 1:
                        case 2:
                            C4879a.xxA.mo10053d(WebviewScanImageActivity.this.riJ);
                            WebviewScanImageActivity.this.finish();
                            break;
                        case 3:
                            C4879a.xxA.mo10053d(WebviewScanImageActivity.this.riJ);
                            WebviewScanImageActivity.this.finish();
                            break;
                    }
                }
                C4990ab.m7413e("MicroMsg.WebviewScanImageActivity", "not the same, eventStr: %s, origin: %s", c42019kv.cGM.ctB, WebviewScanImageActivity.this.riC);
            } else {
                C4990ab.m7412e("MicroMsg.WebviewScanImageActivity", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            AppMethodBeat.m2505o(7335);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WebviewScanImageActivity() {
        AppMethodBeat.m2504i(7336);
        AppMethodBeat.m2505o(7336);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7337);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.WebviewScanImageActivity", "hy: on create");
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(C8415j.INVALID_ID);
            getWindow().setStatusBarColor(0);
        }
        setContentView(2130969926);
        AppMethodBeat.m2505o(7337);
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
        AppMethodBeat.m2504i(7338);
        super.onStart();
        C4990ab.m7416i("MicroMsg.WebviewScanImageActivity", "hy: on start");
        if (!(this.uqS || getIntent() == null)) {
            this.riC = getIntent().getStringExtra("key_string_for_scan");
            this.cvn = getIntent().getIntExtra("key_codetype_for_scan", 0);
            this.cvo = getIntent().getIntExtra("key_codeversion_for_scan", 0);
            this.url = getIntent().getStringExtra("key_string_for_url");
            this.ffl = getIntent().getStringExtra("key_string_for_image_url");
            this.uqT = getIntent().getStringExtra("key_string_for_wxapp_id");
            if (this.riC != null) {
                C4879a.xxA.mo10052c(this.riJ);
                C26102cf c26102cf = new C26102cf();
                c26102cf.cvm.activity = this;
                c26102cf.cvm.ctB = this.riC;
                c26102cf.cvm.cvo = this.cvo;
                c26102cf.cvm.cvn = this.cvn;
                c26102cf.cvm.cvp = 6;
                c26102cf.cvm.imagePath = this.ffl;
                c26102cf.cvm.scene = 40;
                Bundle bundle = new Bundle();
                bundle.putString("stat_app_id", this.uqT);
                bundle.putString("stat_url", this.url);
                bundle.putInt("stat_scene", 4);
                c26102cf.cvm.cvs = bundle;
                C4879a.xxA.mo10055m(c26102cf);
            }
        }
        this.uqS = true;
        AppMethodBeat.m2505o(7338);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.m2504i(7339);
        super.onPause();
        C4990ab.m7416i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
        C41964am c41964am = new C41964am();
        c41964am.ctA.activity = this;
        c41964am.ctA.ctB = this.riC;
        C4879a.xxA.mo10055m(c41964am);
        C4879a.xxA.mo10053d(this.riJ);
        finish();
        AppMethodBeat.m2505o(7339);
    }
}
