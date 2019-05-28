package com.tencent.p177mm.plugin.appbrand.p336ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26424ce;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.C32809i.C32808b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI */
public class AppBrandProcessShareMessageProxyUI extends MMActivity {
    private C5653c iHe;
    private C10769a iHf;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI$a */
    class C10769a implements OnDismissListener, C30111a {
        private boolean hvk = false;

        C10769a() {
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(133014);
            if (z) {
                m18455ad(-1, str);
                AppMethodBeat.m2505o(133014);
                return;
            }
            m18455ad(-2, null);
            AppMethodBeat.m2505o(133014);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(133015);
            AppBrandProcessShareMessageProxyUI.this.finish();
            AppMethodBeat.m2505o(133015);
        }

        /* renamed from: ad */
        private void m18455ad(int i, String str) {
            AppMethodBeat.m2504i(133016);
            if (this.hvk) {
                AppMethodBeat.m2505o(133016);
                return;
            }
            this.hvk = true;
            ResultReceiver resultReceiver = (ResultReceiver) AppBrandProcessShareMessageProxyUI.this.getIntent().getParcelableExtra("key_result_receiver");
            if (resultReceiver != null) {
                Bundle bundle = null;
                if (!C5046bo.isNullOrNil(str)) {
                    bundle = new Bundle();
                    bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
                }
                resultReceiver.send(i, bundle);
            }
            AppMethodBeat.m2505o(133016);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI$b */
    interface C10770b {
        /* renamed from: e */
        void mo22324e(boolean z, String str, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI$1 */
    static class C335381 extends ResultReceiver {
        final /* synthetic */ C30111a iHg;

        /* Access modifiers changed, original: protected|final */
        public final void onReceiveResult(int i, Bundle bundle) {
            AppMethodBeat.m2504i(133009);
            if (-1 == i && this.iHg != null) {
                this.iHg.mo6399a(true, bundle == null ? null : bundle.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE), 0);
            }
            if (-2 == i && this.iHg != null) {
                this.iHg.mo6399a(false, null, 0);
            }
            AppMethodBeat.m2505o(133009);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI$c */
    class C33540c {
        private Context context;
        Runnable hEw = new C24741();
        private boolean iHj;
        boolean iHk;
        private boolean iHl;
        private int iHm;
        C10770b iHn;
        private String text;
        C44275p tipDialog;

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI$c$1 */
        class C24741 implements Runnable {
            C24741() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133017);
                if (C33540c.this.tipDialog != null) {
                    C33540c.this.tipDialog.dismiss();
                }
                C33540c.this.aMl();
                AppMethodBeat.m2505o(133017);
            }
        }

        public C33540c(Context context) {
            AppMethodBeat.m2504i(133018);
            this.context = context;
            AppMethodBeat.m2505o(133018);
        }

        /* renamed from: f */
        public final void mo54020f(boolean z, String str, int i) {
            AppMethodBeat.m2504i(133019);
            this.iHj = true;
            this.iHl = z;
            this.text = str;
            this.iHm = i;
            if (mo54021oC()) {
                aMl();
                AppMethodBeat.m2505o(133019);
                return;
            }
            if (z) {
                this.tipDialog = C30379h.m48458b(this.context, this.context.getString(C25738R.string.f9222th), true, null);
                C5004al.m7442n(this.hEw, 5000);
            }
            AppMethodBeat.m2505o(133019);
        }

        /* renamed from: oC */
        public final boolean mo54021oC() {
            return this.iHj && this.iHk;
        }

        public final void aMl() {
            AppMethodBeat.m2504i(133020);
            if (this.iHn != null) {
                this.iHn.mo22324e(this.iHl, this.text, this.iHm);
            }
            AppMethodBeat.m2505o(133020);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(133021);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
        AppMethodBeat.m2505o(133021);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133022);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        C42696n.m75615a(getWindow());
        C42696n.m75616a(getWindow(), false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getIntent() == null) {
            finish();
            AppMethodBeat.m2505o(133022);
            return;
        }
        Object obj;
        String stringExtra = getIntent().getStringExtra("key_dialog_touser");
        if (C5046bo.isNullOrNil(stringExtra)) {
            obj = null;
        } else {
            HashMap hashMap = (HashMap) getIntent().getSerializableExtra("key_dialog_params");
            int i = C26424ce.getInt(hashMap.get("type"), 1);
            String e = C26424ce.m42081e(hashMap.get("title"), "");
            String e2 = C26424ce.m42081e(hashMap.get("img_url"), null);
            if (i == 2 || i == 3) {
                i = C26424ce.getInt(hashMap.get("pkg_type"), 0);
                int i2 = C26424ce.getInt(hashMap.get("pkg_version"), 0);
                String e3 = C26424ce.m42081e(hashMap.get("app_id"), null);
                String e4 = C26424ce.m42081e(hashMap.get("cache_key"), null);
                String e5 = C26424ce.m42081e(hashMap.get("path"), null);
                String e6 = C26424ce.m42081e(hashMap.get("delay_load_img_path"), null);
                boolean bc = C26424ce.m42080bc(hashMap.get("is_dynamic"));
                final View d = ((C32809i) C1720g.m3528K(C32809i.class)).mo22293d((Context) this, null);
                final String bE = C38496n.m65148bE(this);
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
                final C33540c c33540c = new C33540c(this);
                c33540c.iHn = new C10770b() {
                    /* renamed from: e */
                    public final void mo22324e(boolean z, String str, int i) {
                        AppMethodBeat.m2504i(133010);
                        C4990ab.m7417i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onProcessDone, result:%b", Boolean.valueOf(z));
                        if (AppBrandProcessShareMessageProxyUI.this.iHf != null) {
                            AppBrandProcessShareMessageProxyUI.this.iHf.mo6399a(z, str, i);
                        }
                        ((C32809i) C1720g.m3528K(C32809i.class)).mo22288a(bE, d);
                        AppMethodBeat.m2505o(133010);
                    }
                };
                ((C32809i) C1720g.m3528K(C32809i.class)).mo22290a(bE, d, bundle2, new C32808b() {
                    /* renamed from: kQ */
                    public final void mo6398kQ(int i) {
                        AppMethodBeat.m2504i(133011);
                        C4990ab.m7417i("MicroMsg.AppBrandProcessShareMessageProxyUI", "onLoadImageResult, result:%d", Integer.valueOf(i));
                        C33540c c33540c = c33540c;
                        c33540c.iHk = true;
                        if (c33540c.mo54021oC()) {
                            C5004al.m7439af(c33540c.hEw);
                            c33540c.aMl();
                        }
                        AppMethodBeat.m2505o(133011);
                    }
                });
                this.iHf = new C10769a();
                this.iHe = ((C40437i) C1720g.m3528K(C40437i.class)).mo56644a((Context) this, stringExtra, d, getResources().getString(C25738R.string.f9221tf), new C30111a() {
                    /* renamed from: a */
                    public final void mo6399a(boolean z, String str, int i) {
                        AppMethodBeat.m2504i(133012);
                        AppBrandProcessShareMessageProxyUI.this.aqX();
                        c33540c.mo54020f(z, str, i);
                        AppMethodBeat.m2505o(133012);
                    }
                });
                this.iHe.setOnDismissListener(this.iHf);
                this.iHe.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        AppMethodBeat.m2504i(133013);
                        if (i == 4 && keyEvent.getAction() == 1) {
                            c33540c.mo54020f(false, null, 0);
                            dialogInterface.dismiss();
                        }
                        AppMethodBeat.m2505o(133013);
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
        AppMethodBeat.m2505o(133022);
    }

    public void finish() {
        AppMethodBeat.m2504i(133023);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(133023);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(133024);
        super.onDestroy();
        if (this.iHe != null && this.iHe.isShowing()) {
            this.iHe.dismiss();
            this.iHe = null;
            this.iHf = null;
        }
        AppMethodBeat.m2505o(133024);
    }
}
