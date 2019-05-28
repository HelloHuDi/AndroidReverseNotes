package com.tencent.p177mm.plugin.setting.p505ui.qrcode;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.pluginsdk.C44055j;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI */
public class GetQRCodeInfoUI extends MMBaseActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private C12518f qku;

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI$1 */
    class C217411 implements C1835a {
        C217411() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(126902);
            if (c1902e == null) {
                GetQRCodeInfoUI.this.finish();
                AppMethodBeat.m2505o(126902);
            } else if (!C1720g.m3531RK() || C1668a.m3393QT()) {
                C24824b.gkE.mo38931p(new Intent(), GetQRCodeInfoUI.this);
                GetQRCodeInfoUI.this.finish();
                AppMethodBeat.m2505o(126902);
            } else {
                GetQRCodeInfoUI.m57241a(GetQRCodeInfoUI.this, GetQRCodeInfoUI.this.getIntent().getDataString());
                AppMethodBeat.m2505o(126902);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI$3 */
    class C348523 implements OnClickListener {
        C348523() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(126904);
            GetQRCodeInfoUI.this.finish();
            AppMethodBeat.m2505o(126904);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI$4 */
    class C348534 implements OnClickListener {
        C348534() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(126905);
            GetQRCodeInfoUI.this.finish();
            AppMethodBeat.m2505o(126905);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI$2 */
    class C348542 implements OnCancelListener {
        C348542() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(126903);
            GetQRCodeInfoUI.this.finish();
            AppMethodBeat.m2505o(126903);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126906);
        super.onCreate(bundle);
        setContentView(2130969389);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
            AppMethodBeat.m2505o(126906);
            return;
        }
        String nullAsNil = C5046bo.nullAsNil(data.getHost());
        String nullAsNil2 = C5046bo.nullAsNil(data.getScheme());
        if (("http".equals(nullAsNil2) && "weixin.qq.com".equals(nullAsNil)) || ("weixin".equals(nullAsNil2) && "qr".equals(nullAsNil))) {
            C1720g.m3540Rg().mo14541a(new C6668bk(new C217411()), 0);
            AppMethodBeat.m2505o(126906);
            return;
        }
        finish();
        AppMethodBeat.m2505o(126906);
    }

    public void onResume() {
        AppMethodBeat.m2504i(126907);
        super.onResume();
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f8773ek), true, new C348542());
        AppMethodBeat.m2505o(126907);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(126908);
        super.onDestroy();
        if (this.qku != null) {
            C1720g.m3540Rg().mo14547c(this.qku);
        }
        C1720g.m3540Rg().mo14546b(106, (C1202f) this);
        AppMethodBeat.m2505o(126908);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(126909);
        C4990ab.m7416i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 4 && i2 == -2004) {
            C30379h.m48431a((Context) this, (int) C25738R.string.dgb, (int) C25738R.string.f9238tz, new C348523());
            AppMethodBeat.m2505o(126909);
        } else if (i == 0 && i2 == 0) {
            buv bOj = ((C12518f) c1207m).bOj();
            String a = C1946aa.m4148a(bOj.wcB);
            C17884o.acd().mo67506n(a, C1946aa.m4150a(bOj.vEF));
            ((C44055j) C1720g.m3528K(C44055j.class)).mo41537a(new Intent(), bOj, 30);
            if (C5046bo.nullAsNil(a).length() > 0) {
                if ((bOj.wBT & 8) > 0) {
                    C7060h.pYm.mo8374X(10298, a + ",30");
                }
                C25985d.m41471c((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", 1);
            }
            AppMethodBeat.m2505o(126909);
        } else {
            C30379h.m48438a((Context) this, getString(C25738R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(C25738R.string.f9238tz), new C348534());
            AppMethodBeat.m2505o(126909);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(126910);
        C24824b.gkE.mo38931p(new Intent(), this);
        finish();
        AppMethodBeat.m2505o(126910);
    }

    /* renamed from: a */
    static /* synthetic */ void m57241a(GetQRCodeInfoUI getQRCodeInfoUI, String str) {
        AppMethodBeat.m2504i(126911);
        if (!C5046bo.isNullOrNil(str)) {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            C1720g.m3540Rg().mo14539a(106, (C1202f) getQRCodeInfoUI);
            getQRCodeInfoUI.qku = new C12518f(str2, 5);
            C1720g.m3540Rg().mo14541a(getQRCodeInfoUI.qku, 0);
        }
        AppMethodBeat.m2505o(126911);
    }
}
