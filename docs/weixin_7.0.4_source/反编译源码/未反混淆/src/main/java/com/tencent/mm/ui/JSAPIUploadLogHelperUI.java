package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.al;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;

public class JSAPIUploadLogHelperUI extends MMBaseActivity {
    private static volatile boolean mIsRunning = false;
    private static byte[] yjz = new byte[0];

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(29441);
        ab.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", Boolean.valueOf(mIsRunning));
        super.onCreate(bundle);
        setContentView(R.layout.f7);
        synchronized (yjz) {
            try {
                if (mIsRunning) {
                    ab.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
                    finish();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(29441);
            }
        }
        final String stringExtra = getIntent().getStringExtra("key_user");
        final int intExtra = getIntent().getIntExtra("key_time", 0);
        String str = "MicroMsg.JSAPIUploadLogHelperUI";
        String str2 = "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d";
        Object[] objArr = new Object[2];
        if (stringExtra == null || !stringExtra.equals(r.Yz())) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(intExtra);
        ab.i(str, str2, objArr);
        if (stringExtra == null) {
            ab.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
            finish();
        } else if (intExtra < 0) {
            ab.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", Integer.valueOf(intExtra));
            finish();
            AppMethodBeat.o(29441);
        } else {
            getString(R.string.tz);
            final p b = h.b((Context) this, getString(R.string.g33), false, null);
            aw.Rg().a(new bk(new a() {
                public final void a(e eVar) {
                    AppMethodBeat.i(29438);
                    synchronized (JSAPIUploadLogHelperUI.yjz) {
                        try {
                            JSAPIUploadLogHelperUI.mIsRunning = true;
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(29438);
                        }
                    }
                    aw.Rg().a(1, "", 0, false);
                    ab.dot();
                    aw.Rg().a(2, stringExtra, intExtra, aw.RK());
                }
            }), 0);
            final AnonymousClass2 anonymousClass2 = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(29439);
                    if (!JSAPIUploadLogHelperUI.this.isFinishing()) {
                        JSAPIUploadLogHelperUI.this.finish();
                    }
                    AppMethodBeat.o(29439);
                }
            };
            aw.a(new al() {
                public final void kx(int i) {
                    AppMethodBeat.i(29440);
                    c g;
                    if (i < 0) {
                        ab.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", Integer.valueOf(i));
                        aw.a(null);
                        if (b != null) {
                            b.dismiss();
                        }
                        g = h.g(JSAPIUploadLogHelperUI.this, R.string.ez9, R.string.tz);
                        if (g != null) {
                            g.setOnDismissListener(anonymousClass2);
                        }
                        synchronized (JSAPIUploadLogHelperUI.yjz) {
                            try {
                                JSAPIUploadLogHelperUI.mIsRunning = false;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(29440);
                            }
                        }
                    } else if (i >= 100) {
                        ab.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
                        aw.a(null);
                        if (b != null) {
                            b.dismiss();
                        }
                        g = h.g(JSAPIUploadLogHelperUI.this, R.string.ezc, R.string.tz);
                        if (g != null) {
                            g.setOnDismissListener(anonymousClass2);
                        }
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        com.tencent.mm.plugin.report.service.h.pYm.e(12975, Long.valueOf(currentTimeMillis));
                        synchronized (JSAPIUploadLogHelperUI.yjz) {
                            try {
                                JSAPIUploadLogHelperUI.mIsRunning = false;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(29440);
                            }
                        }
                    } else {
                        ab.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", Integer.valueOf(i));
                        if (b != null) {
                            b.setMessage(JSAPIUploadLogHelperUI.this.getString(R.string.ez_) + i + "%");
                        }
                        AppMethodBeat.o(29440);
                    }
                }
            });
            AppMethodBeat.o(29441);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(29442);
        ab.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", Boolean.valueOf(mIsRunning));
        super.onDestroy();
        AppMethodBeat.o(29442);
    }
}
