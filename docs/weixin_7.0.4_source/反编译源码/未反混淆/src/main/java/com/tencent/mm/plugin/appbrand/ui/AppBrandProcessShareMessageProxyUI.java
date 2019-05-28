package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.plugin.appbrand.r.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(7)
public class AppBrandProcessShareMessageProxyUI extends MMActivity {
    private com.tencent.mm.ui.widget.a.c iHe;
    private a iHf;

    class a implements OnDismissListener, com.tencent.mm.pluginsdk.ui.applet.q.a {
        private boolean hvk = false;

        a() {
        }

        public final void a(boolean z, String str, int i) {
            AppMethodBeat.i(133014);
            if (z) {
                ad(-1, str);
                AppMethodBeat.o(133014);
                return;
            }
            ad(-2, null);
            AppMethodBeat.o(133014);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(133015);
            AppBrandProcessShareMessageProxyUI.this.finish();
            AppMethodBeat.o(133015);
        }

        private void ad(int i, String str) {
            AppMethodBeat.i(133016);
            if (this.hvk) {
                AppMethodBeat.o(133016);
                return;
            }
            this.hvk = true;
            ResultReceiver resultReceiver = (ResultReceiver) AppBrandProcessShareMessageProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
            if (resultReceiver != null) {
                Bundle bundle = null;
                if (!bo.isNullOrNil(str)) {
                    bundle = new Bundle();
                    bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
                }
                resultReceiver.send(i, bundle);
            }
            AppMethodBeat.o(133016);
        }
    }

    interface b {
        void e(boolean z, String str, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI$1 */
    static class AnonymousClass1 extends ResultReceiver {
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.applet.q.a iHg;

        /* Access modifiers changed, original: protected|final */
        public final void onReceiveResult(int i, Bundle bundle) {
            AppMethodBeat.i(133009);
            if (-1 == i && this.iHg != null) {
                this.iHg.a(true, bundle == null ? null : bundle.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE), 0);
            }
            if (-2 == i && this.iHg != null) {
                this.iHg.a(false, null, 0);
            }
            AppMethodBeat.o(133009);
        }
    }

    class c {
        private Context context;
        Runnable hEw = new Runnable() {
            public final void run() {
                AppMethodBeat.i(133017);
                if (c.this.tipDialog != null) {
                    c.this.tipDialog.dismiss();
                }
                c.this.aMl();
                AppMethodBeat.o(133017);
            }
        };
        private boolean iHj;
        boolean iHk;
        private boolean iHl;
        private int iHm;
        b iHn;
        private String text;
        p tipDialog;

        public c(Context context) {
            AppMethodBeat.i(133018);
            this.context = context;
            AppMethodBeat.o(133018);
        }

        public final void f(boolean z, String str, int i) {
            AppMethodBeat.i(133019);
            this.iHj = true;
            this.iHl = z;
            this.text = str;
            this.iHm = i;
            if (oC()) {
                aMl();
                AppMethodBeat.o(133019);
                return;
            }
            if (z) {
                this.tipDialog = h.b(this.context, this.context.getString(R.string.th), true, null);
                al.n(this.hEw, 5000);
            }
            AppMethodBeat.o(133019);
        }

        public final boolean oC() {
            return this.iHj && this.iHk;
        }

        public final void aMl() {
            AppMethodBeat.i(133020);
            if (this.iHn != null) {
                this.iHn.e(this.iHl, this.text, this.iHm);
            }
            AppMethodBeat.o(133020);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(133021);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
        AppMethodBeat.o(133021);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(133022);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        n.a(getWindow());
        n.a(getWindow(), false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(133022);
            return;
        }
        Object obj;
        String stringExtra = getIntent().getStringExtra("key_dialog_touser");
        if (bo.isNullOrNil(stringExtra)) {
            obj = null;
        } else {
            HashMap hashMap = (HashMap) getIntent().getSerializableExtra("key_dialog_params");
            int i = ce.getInt(hashMap.get("type"), 1);
            String e = ce.e(hashMap.get("title"), "");
            String e2 = ce.e(hashMap.get("img_url"), null);
            if (i == 2 || i == 3) {
                i = ce.getInt(hashMap.get("pkg_type"), 0);
                int i2 = ce.getInt(hashMap.get("pkg_version"), 0);
                String e3 = ce.e(hashMap.get("app_id"), null);
                String e4 = ce.e(hashMap.get("cache_key"), null);
                String e5 = ce.e(hashMap.get("path"), null);
                String e6 = ce.e(hashMap.get("delay_load_img_path"), null);
                boolean bc = ce.bc(hashMap.get("is_dynamic"));
                final View d = ((i) g.K(i.class)).d((Context) this, null);
                final String bE = n.bE(this);
                Bundle bundle2 = new Bundle();
                bundle2.putString("app_id", e3);
                bundle2.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                bundle2.putInt("msg_pkg_type", i);
                bundle2.putInt("pkg_version", i2);
                bundle2.putString(MessengerShareContentUtility.IMAGE_URL, e2);
                bundle2.putBoolean("is_dynamic_page", bc);
                bundle2.putString("title", e);
                bundle2.putString("cache_key", e4);
                bundle2.putString("msg_path", e5);
                bundle2.putString("delay_load_img_path", e6);
                final c cVar = new c(this);
                cVar.iHn = new b() {
                    public final void e(boolean z, String str, int i) {
                        AppMethodBeat.i(133010);
                        ab.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onProcessDone, result:%b", Boolean.valueOf(z));
                        if (AppBrandProcessShareMessageProxyUI.this.iHf != null) {
                            AppBrandProcessShareMessageProxyUI.this.iHf.a(z, str, i);
                        }
                        ((i) g.K(i.class)).a(bE, d);
                        AppMethodBeat.o(133010);
                    }
                };
                ((i) g.K(i.class)).a(bE, d, bundle2, new com.tencent.mm.modelappbrand.i.b() {
                    public final void kQ(int i) {
                        AppMethodBeat.i(133011);
                        ab.i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onLoadImageResult, result:%d", Integer.valueOf(i));
                        c cVar = cVar;
                        cVar.iHk = true;
                        if (cVar.oC()) {
                            al.af(cVar.hEw);
                            cVar.aMl();
                        }
                        AppMethodBeat.o(133011);
                    }
                });
                this.iHf = new a();
                this.iHe = ((com.tencent.mm.pluginsdk.i) g.K(com.tencent.mm.pluginsdk.i.class)).a((Context) this, stringExtra, d, getResources().getString(R.string.tf), new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                    public final void a(boolean z, String str, int i) {
                        AppMethodBeat.i(133012);
                        AppBrandProcessShareMessageProxyUI.this.aqX();
                        cVar.f(z, str, i);
                        AppMethodBeat.o(133012);
                    }
                });
                this.iHe.setOnDismissListener(this.iHf);
                this.iHe.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        AppMethodBeat.i(133013);
                        if (i == 4 && keyEvent.getAction() == 1) {
                            cVar.f(false, null, 0);
                            dialogInterface.dismiss();
                        }
                        AppMethodBeat.o(133013);
                        return false;
                    }
                });
                this.iHe.show();
            }
            obj = 1;
        }
        if (obj == null) {
            finish();
        }
        AppMethodBeat.o(133022);
    }

    public void finish() {
        AppMethodBeat.i(133023);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(133023);
    }

    public void onDestroy() {
        AppMethodBeat.i(133024);
        super.onDestroy();
        if (this.iHe != null && this.iHe.isShowing()) {
            this.iHe.dismiss();
            this.iHe = null;
            this.iHf = null;
        }
        AppMethodBeat.o(133024);
    }
}
