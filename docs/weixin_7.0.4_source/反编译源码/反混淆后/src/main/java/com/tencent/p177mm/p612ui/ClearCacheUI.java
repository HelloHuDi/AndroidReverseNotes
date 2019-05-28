package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p190at.p191a.p829g.C9016b;
import com.tencent.p177mm.p230g.p231a.C41970bq;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.avatar.C19935c;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.ui.ClearCacheUI */
public class ClearCacheUI extends MMBaseActivity {

    /* renamed from: com.tencent.mm.ui.ClearCacheUI$2 */
    class C51762 implements OnClickListener {
        C51762() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29166);
            ClearCacheUI.this.finish();
            AppMethodBeat.m2505o(29166);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29169);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_message");
        final long longExtra = getIntent().getLongExtra("key_mask", 0);
        C30379h.m48445a((Context) this, stringExtra, getString(C25738R.string.ar0), getString(C25738R.string.aqz), getString(C25738R.string.aqx), false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(29165);
                ClearCacheUI.m7887a(ClearCacheUI.this, longExtra);
                ClearCacheUI.this.finish();
                AppMethodBeat.m2505o(29165);
            }
        }, new C51762());
        AppMethodBeat.m2505o(29169);
    }

    /* renamed from: a */
    static /* synthetic */ void m7887a(ClearCacheUI clearCacheUI, final long j) {
        AppMethodBeat.m2504i(29170);
        C7305d.post(new Runnable() {

            /* renamed from: com.tencent.mm.ui.ClearCacheUI$3$1 */
            class C51751 implements Runnable {
                C51751() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(29167);
                    Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.aqy), 0).show();
                    AppMethodBeat.m2505o(29167);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(29168);
                C4990ab.m7421w("MicroMsg.ClearCacheUI", "doClearCache flag %d", Long.valueOf(j));
                if ((j & 1) != 0) {
                    C5730e.m8618N(C43217c.bGF(), true);
                }
                if ((j & 2) != 0) {
                    C5730e.m8618N(C9016b.eSG, true);
                }
                if ((j & 4) != 0) {
                    C5730e.m8618N(C6457e.euX, true);
                }
                if ((j & 8) != 0) {
                    C9638aw.m17190ZK();
                    C5730e.m8618N(C18628c.m29097Yf(), true);
                }
                if ((j & 16) != 0) {
                    C5730e.m8618N(C19935c.aSn(), true);
                }
                if ((j & 32) != 0) {
                    C9638aw.m17190ZK();
                    C5730e.m8618N(C18628c.m29092Ya(), true);
                }
                if ((j & 64) != 0) {
                    C9638aw.m17190ZK();
                    C5730e.m8618N(C18628c.getAccSnsPath(), true);
                }
                C41970bq c41970bq = new C41970bq();
                c41970bq.cuL.cuM = j;
                C4879a.xxA.mo10055m(c41970bq);
                C5004al.m7441d(new C51751());
                AppMethodBeat.m2505o(29168);
            }
        }, "CleanCacheUIThread");
        AppMethodBeat.m2505o(29170);
    }
}
