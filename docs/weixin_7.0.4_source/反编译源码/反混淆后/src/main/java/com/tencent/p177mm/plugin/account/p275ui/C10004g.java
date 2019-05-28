package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.platformtools.C1948e;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.g */
public final class C10004g {
    private String account = "";
    private String cOG;
    boolean gDc = false;
    private String gDl = "";
    private C10008a gDm;
    private String username = "";

    /* renamed from: com.tencent.mm.plugin.account.ui.g$2 */
    class C100032 implements C1835a {
        C100032() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(125082);
            if (c1902e == null) {
                AppMethodBeat.m2505o(125082);
                return;
            }
            C1898c adg = c1902e.adg();
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[0];
            byte[] bArr3 = new byte[0];
            C1720g.m3534RN();
            adg.mo5482a(bArr, bArr2, bArr3, C1668a.m3383QF());
            AppMethodBeat.m2505o(125082);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.g$4 */
    class C100064 implements OnClickListener {
        C100064() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.g$5 */
    class C100075 implements OnCancelListener {
        C100075() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.g$a */
    public interface C10008a {
        /* renamed from: a */
        void mo17503a(ProgressDialog progressDialog);
    }

    public C10004g(C10008a c10008a, String str, String str2, String str3) {
        this.username = str;
        this.account = str3;
        this.gDl = str2;
        this.gDm = c10008a;
    }

    /* renamed from: a */
    public final void mo21362a(MMActivity mMActivity) {
        AppMethodBeat.m2504i(125084);
        String str = this.account;
        if (C5046bo.isNullOrNil(this.account)) {
            str = this.username;
        }
        final C1207m c6686q = new C6686q(str, this.gDl, 0, "", "", "", 0, "", false, true);
        C1720g.m3540Rg().mo14541a(c6686q, 0);
        C10008a c10008a = this.gDm;
        mMActivity.getString(C25738R.string.f9238tz);
        c10008a.mo17503a(C30379h.m48458b((Context) mMActivity, mMActivity.getString(C25738R.string.cou), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(125081);
                C1720g.m3540Rg().mo14547c(c6686q);
                AppMethodBeat.m2505o(125081);
            }
        }));
        AppMethodBeat.m2505o(125084);
    }

    /* renamed from: a */
    public final void mo21363a(final MMActivity mMActivity, int i, int i2, String str, C1207m c1207m) {
        int i3;
        AppMethodBeat.m2504i(125085);
        if (i == 4 && (i2 == -16 || i2 == -17)) {
            C1720g.m3540Rg().mo14541a(new C6668bk(new C100032()), 0);
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (c1207m instanceof C6686q) {
            this.cOG = ((C6686q) c1207m).ajm();
        }
        String string;
        if (i3 != 0 || (i == 0 && i2 == 0)) {
            C1668a.unhold();
            C26529w.m42356cm(mMActivity);
            C42257z.m74637vx(this.account);
            C42257z.showAddrBookUploadConfirm(mMActivity, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(125083);
                    Intent bh = C24679a.gkE.mo38909bh(mMActivity);
                    bh.addFlags(67108864);
                    mMActivity.startActivity(bh);
                    mMActivity.finish();
                    AppMethodBeat.m2505o(125083);
                }
            }, false, 2);
            if (this.gDc) {
                string = C4996ah.getContext().getSharedPreferences("randomid_prefs", C1448h.m3078Mu()).getString("randomID", "");
                C7060h.pYm.mo8381e(11930, string, Integer.valueOf(4));
            }
            AppMethodBeat.m2505o(125085);
        } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
            C42257z.m74635f(mMActivity, str, 0);
            AppMethodBeat.m2505o(125085);
        } else if (i2 == -217) {
            C42257z.m74633a(mMActivity, C1948e.m4157a((C6686q) c1207m), i2);
            AppMethodBeat.m2505o(125085);
        } else {
            int i4;
            if (C24679a.gkF.mo38859a((Context) mMActivity, i, i2, str)) {
                i4 = 1;
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -140:
                            if (!C5046bo.isNullOrNil(this.cOG)) {
                                C42257z.m74636o(mMActivity, str, this.cOG);
                            }
                            i4 = 1;
                            break;
                        case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                            C1668a.hold();
                            C1720g.m3534RN();
                            if (TextUtils.isEmpty(C1668a.m3385QH())) {
                                string = C1338a.m2858an(mMActivity, C25738R.string.cvw);
                            } else {
                                C1720g.m3534RN();
                                string = C1668a.m3385QH();
                            }
                            C30379h.m48439a((Context) mMActivity, string, mMActivity.getString(C25738R.string.f9238tz), new C100064(), new C100075());
                            i4 = 1;
                            break;
                        case -75:
                            C30379h.m48467g(mMActivity, C25738R.string.f8809fm, C25738R.string.f9238tz);
                            i4 = 1;
                            break;
                        case -72:
                            C30379h.m48467g(mMActivity, C25738R.string.dmb, C25738R.string.f9238tz);
                            i4 = 1;
                            break;
                        case -9:
                            C30379h.m48467g(mMActivity, C25738R.string.cof, C25738R.string.cog);
                            i4 = 1;
                            break;
                        case -1:
                            if (C1720g.m3540Rg().acS() == 5) {
                                C30379h.m48467g(mMActivity, C25738R.string.d5n, C25738R.string.d5m);
                                i4 = 1;
                                break;
                            }
                        case -4:
                        case -3:
                            C30379h.m48467g(mMActivity, C25738R.string.be9, C25738R.string.cog);
                            i4 = 1;
                            break;
                    }
                }
                i4 = 0;
            }
            if (i4 != 0) {
                AppMethodBeat.m2505o(125085);
                return;
            }
            Toast.makeText(mMActivity, mMActivity.getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(125085);
        }
    }
}
