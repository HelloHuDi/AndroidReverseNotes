package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;

public class GetQRCodeInfoUI extends MMBaseActivity implements f {
    private ProgressDialog ehJ = null;
    private com.tencent.mm.plugin.messenger.a.f qku;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126906);
        super.onCreate(bundle);
        setContentView(R.layout.v8);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
            AppMethodBeat.o(126906);
            return;
        }
        String nullAsNil = bo.nullAsNil(data.getHost());
        String nullAsNil2 = bo.nullAsNil(data.getScheme());
        if (("http".equals(nullAsNil2) && "weixin.qq.com".equals(nullAsNil)) || ("weixin".equals(nullAsNil2) && "qr".equals(nullAsNil))) {
            g.Rg().a(new bk(new a() {
                public final void a(e eVar) {
                    AppMethodBeat.i(126902);
                    if (eVar == null) {
                        GetQRCodeInfoUI.this.finish();
                        AppMethodBeat.o(126902);
                    } else if (!g.RK() || com.tencent.mm.kernel.a.QT()) {
                        b.gkE.p(new Intent(), GetQRCodeInfoUI.this);
                        GetQRCodeInfoUI.this.finish();
                        AppMethodBeat.o(126902);
                    } else {
                        GetQRCodeInfoUI.a(GetQRCodeInfoUI.this, GetQRCodeInfoUI.this.getIntent().getDataString());
                        AppMethodBeat.o(126902);
                    }
                }
            }), 0);
            AppMethodBeat.o(126906);
            return;
        }
        finish();
        AppMethodBeat.o(126906);
    }

    public void onResume() {
        AppMethodBeat.i(126907);
        super.onResume();
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.ek), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(126903);
                GetQRCodeInfoUI.this.finish();
                AppMethodBeat.o(126903);
            }
        });
        AppMethodBeat.o(126907);
    }

    public void onDestroy() {
        AppMethodBeat.i(126908);
        super.onDestroy();
        if (this.qku != null) {
            g.Rg().c(this.qku);
        }
        g.Rg().b(106, (f) this);
        AppMethodBeat.o(126908);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(126909);
        ab.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 4 && i2 == -2004) {
            h.a((Context) this, (int) R.string.dgb, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(126904);
                    GetQRCodeInfoUI.this.finish();
                    AppMethodBeat.o(126904);
                }
            });
            AppMethodBeat.o(126909);
        } else if (i == 0 && i2 == 0) {
            buv bOj = ((com.tencent.mm.plugin.messenger.a.f) mVar).bOj();
            String a = aa.a(bOj.wcB);
            o.acd().n(a, aa.a(bOj.vEF));
            ((j) g.K(j.class)).a(new Intent(), bOj, 30);
            if (bo.nullAsNil(a).length() > 0) {
                if ((bOj.wBT & 8) > 0) {
                    com.tencent.mm.plugin.report.service.h.pYm.X(10298, a + ",30");
                }
                d.c((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", 1);
            }
            AppMethodBeat.o(126909);
        } else {
            h.a((Context) this, getString(R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.string.tz), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(126905);
                    GetQRCodeInfoUI.this.finish();
                    AppMethodBeat.o(126905);
                }
            });
            AppMethodBeat.o(126909);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(126910);
        b.gkE.p(new Intent(), this);
        finish();
        AppMethodBeat.o(126910);
    }

    static /* synthetic */ void a(GetQRCodeInfoUI getQRCodeInfoUI, String str) {
        AppMethodBeat.i(126911);
        if (!bo.isNullOrNil(str)) {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            g.Rg().a(106, (f) getQRCodeInfoUI);
            getQRCodeInfoUI.qku = new com.tencent.mm.plugin.messenger.a.f(str2, 5);
            g.Rg().a(getQRCodeInfoUI.qku, 0);
        }
        AppMethodBeat.o(126911);
    }
}
