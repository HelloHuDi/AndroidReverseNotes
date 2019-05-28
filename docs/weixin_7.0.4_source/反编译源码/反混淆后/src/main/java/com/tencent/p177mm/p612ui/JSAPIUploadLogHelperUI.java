package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1814al;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.JSAPIUploadLogHelperUI */
public class JSAPIUploadLogHelperUI extends MMBaseActivity {
    private static volatile boolean mIsRunning = false;
    private static byte[] yjz = new byte[0];

    /* renamed from: com.tencent.mm.ui.JSAPIUploadLogHelperUI$2 */
    class C170142 implements OnDismissListener {
        C170142() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(29439);
            if (!JSAPIUploadLogHelperUI.this.isFinishing()) {
                JSAPIUploadLogHelperUI.this.finish();
            }
            AppMethodBeat.m2505o(29439);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.m2504i(29441);
        C4990ab.m7417i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", Boolean.valueOf(mIsRunning));
        super.onCreate(bundle);
        setContentView(2130968794);
        synchronized (yjz) {
            try {
                if (mIsRunning) {
                    C4990ab.m7420w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
                    finish();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(29441);
            }
        }
        final String stringExtra = getIntent().getStringExtra("key_user");
        final int intExtra = getIntent().getIntExtra("key_time", 0);
        String str = "MicroMsg.JSAPIUploadLogHelperUI";
        String str2 = "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d";
        Object[] objArr = new Object[2];
        if (stringExtra == null || !stringExtra.equals(C1853r.m3846Yz())) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(intExtra);
        C4990ab.m7417i(str, str2, objArr);
        if (stringExtra == null) {
            C4990ab.m7412e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
            finish();
        } else if (intExtra < 0) {
            C4990ab.m7413e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", Integer.valueOf(intExtra));
            finish();
            AppMethodBeat.m2505o(29441);
        } else {
            getString(C25738R.string.f9238tz);
            final C44275p b = C30379h.m48458b((Context) this, getString(C25738R.string.g33), false, null);
            C9638aw.m17182Rg().mo14541a(new C6668bk(new C1835a() {
                /* renamed from: a */
                public final void mo4918a(C1902e c1902e) {
                    AppMethodBeat.m2504i(29438);
                    synchronized (JSAPIUploadLogHelperUI.yjz) {
                        try {
                            JSAPIUploadLogHelperUI.mIsRunning = true;
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(29438);
                        }
                    }
                    C9638aw.m17182Rg().mo14540a(1, "", 0, false);
                    C4990ab.dot();
                    C9638aw.m17182Rg().mo14540a(2, stringExtra, intExtra, C9638aw.m17179RK());
                }
            }), 0);
            final C170142 c170142 = new C170142();
            C9638aw.m17196a(new C1814al() {
                /* renamed from: kx */
                public final void mo5389kx(int i) {
                    AppMethodBeat.m2504i(29440);
                    C5653c g;
                    if (i < 0) {
                        C4990ab.m7413e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", Integer.valueOf(i));
                        C9638aw.m17196a(null);
                        if (b != null) {
                            b.dismiss();
                        }
                        g = C30379h.m48467g(JSAPIUploadLogHelperUI.this, C25738R.string.ez9, C25738R.string.f9238tz);
                        if (g != null) {
                            g.setOnDismissListener(c170142);
                        }
                        synchronized (JSAPIUploadLogHelperUI.yjz) {
                            try {
                                JSAPIUploadLogHelperUI.mIsRunning = false;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.m2505o(29440);
                            }
                        }
                    } else if (i >= 100) {
                        C4990ab.m7416i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
                        C9638aw.m17196a(null);
                        if (b != null) {
                            b.dismiss();
                        }
                        g = C30379h.m48467g(JSAPIUploadLogHelperUI.this, C25738R.string.ezc, C25738R.string.f9238tz);
                        if (g != null) {
                            g.setOnDismissListener(c170142);
                        }
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        C7060h.pYm.mo8381e(12975, Long.valueOf(currentTimeMillis));
                        synchronized (JSAPIUploadLogHelperUI.yjz) {
                            try {
                                JSAPIUploadLogHelperUI.mIsRunning = false;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.m2505o(29440);
                            }
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", Integer.valueOf(i));
                        if (b != null) {
                            b.setMessage(JSAPIUploadLogHelperUI.this.getString(C25738R.string.ez_) + i + "%");
                        }
                        AppMethodBeat.m2505o(29440);
                    }
                }
            });
            AppMethodBeat.m2505o(29441);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(29442);
        C4990ab.m7417i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", Boolean.valueOf(mIsRunning));
        super.onDestroy();
        AppMethodBeat.m2505o(29442);
    }
}
