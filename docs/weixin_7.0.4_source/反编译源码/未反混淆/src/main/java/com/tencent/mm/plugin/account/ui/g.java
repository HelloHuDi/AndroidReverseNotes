package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class g {
    private String account = "";
    private String cOG;
    boolean gDc = false;
    private String gDl = "";
    private a gDm;
    private String username = "";

    public interface a {
        void a(ProgressDialog progressDialog);
    }

    public g(a aVar, String str, String str2, String str3) {
        this.username = str;
        this.account = str3;
        this.gDl = str2;
        this.gDm = aVar;
    }

    public final void a(MMActivity mMActivity) {
        AppMethodBeat.i(125084);
        String str = this.account;
        if (bo.isNullOrNil(this.account)) {
            str = this.username;
        }
        final m qVar = new q(str, this.gDl, 0, "", "", "", 0, "", false, true);
        com.tencent.mm.kernel.g.Rg().a(qVar, 0);
        a aVar = this.gDm;
        mMActivity.getString(R.string.tz);
        aVar.a(h.b((Context) mMActivity, mMActivity.getString(R.string.cou), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(125081);
                com.tencent.mm.kernel.g.Rg().c(qVar);
                AppMethodBeat.o(125081);
            }
        }));
        AppMethodBeat.o(125084);
    }

    public final void a(final MMActivity mMActivity, int i, int i2, String str, m mVar) {
        int i3;
        AppMethodBeat.i(125085);
        if (i == 4 && (i2 == -16 || i2 == -17)) {
            com.tencent.mm.kernel.g.Rg().a(new bk(new com.tencent.mm.model.bk.a() {
                public final void a(e eVar) {
                    AppMethodBeat.i(125082);
                    if (eVar == null) {
                        AppMethodBeat.o(125082);
                        return;
                    }
                    c adg = eVar.adg();
                    byte[] bArr = new byte[0];
                    byte[] bArr2 = new byte[0];
                    byte[] bArr3 = new byte[0];
                    com.tencent.mm.kernel.g.RN();
                    adg.a(bArr, bArr2, bArr3, com.tencent.mm.kernel.a.QF());
                    AppMethodBeat.o(125082);
                }
            }), 0);
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (mVar instanceof q) {
            this.cOG = ((q) mVar).ajm();
        }
        String string;
        if (i3 != 0 || (i == 0 && i2 == 0)) {
            com.tencent.mm.kernel.a.unhold();
            w.cm(mMActivity);
            z.vx(this.account);
            z.showAddrBookUploadConfirm(mMActivity, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(125083);
                    Intent bh = com.tencent.mm.plugin.account.a.a.gkE.bh(mMActivity);
                    bh.addFlags(67108864);
                    mMActivity.startActivity(bh);
                    mMActivity.finish();
                    AppMethodBeat.o(125083);
                }
            }, false, 2);
            if (this.gDc) {
                string = ah.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.h.Mu()).getString("randomID", "");
                com.tencent.mm.plugin.report.service.h.pYm.e(11930, string, Integer.valueOf(4));
            }
            AppMethodBeat.o(125085);
        } else if (i2 == ZipJNI.UNZ_ERR_OPEN_WRITE) {
            z.f(mMActivity, str, 0);
            AppMethodBeat.o(125085);
        } else if (i2 == -217) {
            z.a(mMActivity, com.tencent.mm.platformtools.e.a((q) mVar), i2);
            AppMethodBeat.o(125085);
        } else {
            int i4;
            if (com.tencent.mm.plugin.account.a.a.gkF.a((Context) mMActivity, i, i2, str)) {
                i4 = 1;
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -140:
                            if (!bo.isNullOrNil(this.cOG)) {
                                z.o(mMActivity, str, this.cOG);
                            }
                            i4 = 1;
                            break;
                        case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                            com.tencent.mm.kernel.a.hold();
                            com.tencent.mm.kernel.g.RN();
                            if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QH())) {
                                string = com.tencent.mm.bz.a.an(mMActivity, R.string.cvw);
                            } else {
                                com.tencent.mm.kernel.g.RN();
                                string = com.tencent.mm.kernel.a.QH();
                            }
                            h.a((Context) mMActivity, string, mMActivity.getString(R.string.tz), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            i4 = 1;
                            break;
                        case -75:
                            h.g(mMActivity, R.string.fm, R.string.tz);
                            i4 = 1;
                            break;
                        case -72:
                            h.g(mMActivity, R.string.dmb, R.string.tz);
                            i4 = 1;
                            break;
                        case -9:
                            h.g(mMActivity, R.string.cof, R.string.cog);
                            i4 = 1;
                            break;
                        case -1:
                            if (com.tencent.mm.kernel.g.Rg().acS() == 5) {
                                h.g(mMActivity, R.string.d5n, R.string.d5m);
                                i4 = 1;
                                break;
                            }
                        case -4:
                        case -3:
                            h.g(mMActivity, R.string.be9, R.string.cog);
                            i4 = 1;
                            break;
                    }
                }
                i4 = 0;
            }
            if (i4 != 0) {
                AppMethodBeat.o(125085);
                return;
            }
            Toast.makeText(mMActivity, mMActivity.getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(125085);
        }
    }
}
