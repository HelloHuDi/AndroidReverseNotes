package com.tencent.p177mm.plugin.account.p275ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.account.model.C26603h;
import com.tencent.p177mm.plugin.account.model.C42287f;
import com.tencent.p177mm.plugin.account.model.C9908i;
import com.tencent.p177mm.protocal.protobuf.bwp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI */
public class ShareToFacebookRedirectUI extends MMActivity implements C1202f {
    private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
    private C44275p eir;
    private String gId;
    private String gIe;
    private String gIf;
    private String gIg;

    /* renamed from: com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI$5 */
    class C99995 implements OnClickListener {
        C99995() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125575);
            Intent intent = new Intent(ShareToFacebookRedirectUI.this.mController.ylL, FacebookAuthUI.class);
            intent.putExtra("is_force_unbind", true);
            ShareToFacebookRedirectUI.this.mController.ylL.startActivityForResult(intent, 0);
            AppMethodBeat.m2505o(125575);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI$3 */
    class C165833 extends C9908i {
        C165833() {
        }

        /* renamed from: p */
        public final void mo21265p(Bundle bundle) {
            AppMethodBeat.m2504i(125571);
            super.mo21265p(bundle);
            AppMethodBeat.m2505o(125571);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(125572);
            C4990ab.m7413e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", Integer.valueOf(i), str);
            super.onError(i, str);
            if (i == 3) {
                ShareToFacebookRedirectUI.m29517a(ShareToFacebookRedirectUI.this);
            }
            AppMethodBeat.m2505o(125572);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI$2 */
    class C189342 implements OnClickListener {
        C189342() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125570);
            ShareToFacebookRedirectUI.this.finish();
            AppMethodBeat.m2505o(125570);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI$1 */
    class C189351 implements OnDismissListener {
        C189351() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125576);
        super.onCreate(bundle);
        C1720g.m3540Rg().mo14539a((int) v2helper.EMethodSetSendToNetworkOff, (C1202f) this);
        this.gId = getIntent().getStringExtra("title");
        this.gIe = getIntent().getStringExtra("digest");
        this.gIf = getIntent().getStringExtra("img");
        this.gIg = getIntent().getStringExtra("link");
        C4990ab.m7417i(TAG, "title %s, digest:%s, img:%s, link:%s", this.gId, this.gIe, this.gIf, this.gIg);
        if (C1853r.m3847Za()) {
            arK();
            arj();
            AppMethodBeat.m2505o(125576);
            return;
        }
        Intent intent = new Intent(this, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        startActivityForResult(intent, 0);
        AppMethodBeat.m2505o(125576);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125577);
        C1720g.m3540Rg().mo14546b((int) v2helper.EMethodSetSendToNetworkOff, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(125577);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125578);
        C4990ab.m7417i(TAG, "type:%d, code:%d, msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        aqX();
        this.eir.dismiss();
        if (i == 4 && i2 == -68) {
            if (C5046bo.isNullOrNil(str)) {
                str = "error";
            }
            m29519bj(getString(C25738R.string.f9238tz), str);
            AppMethodBeat.m2505o(125578);
        } else if (i == 0 && i2 == 0) {
            String string = getString(C25738R.string.egv);
            C189351 c189351 = new C189351();
            C30379h.m48465bQ(this, string);
            finish();
            AppMethodBeat.m2505o(125578);
        } else {
            C30379h.m48440a(this.mController.ylL, "err(" + i2 + "," + i + ")", getString(C25738R.string.f9238tz), new C189342(), null);
            AppMethodBeat.m2505o(125578);
        }
    }

    private void arK() {
        AppMethodBeat.m2504i(125579);
        C4990ab.m7416i(TAG, "refreshFacebookToken");
        long c = C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(65831, null));
        String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(65830, null));
        if (C5046bo.m7566gb(c) <= 86400000 || nullAsNil.length() <= 0) {
            arj();
            AppMethodBeat.m2505o(125579);
            return;
        }
        C30704c c30704c = new C30704c(getString(C25738R.string.g7d));
        c30704c.arX(nullAsNil);
        new C26603h(c30704c, new C165833()).apm();
        AppMethodBeat.m2505o(125579);
    }

    private void arj() {
        AppMethodBeat.m2504i(125580);
        C4990ab.m7416i(TAG, "doSend");
        final C5659a c5659a = new C5659a(this);
        c5659a.mo11514al(this.gId).asM(this.gIf).mo11515am(this.gIe).asN(getString(C25738R.string.f9080ow)).mo11509Qg(C25738R.string.f9226tl).mo11523c(new C5662c() {

            /* renamed from: com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI$4$1 */
            class C189331 implements OnCancelListener {
                C189331() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125573);
                    ShareToFacebookRedirectUI.this.eir.dismiss();
                    ShareToFacebookRedirectUI.this.finish();
                    AppMethodBeat.m2505o(125573);
                }
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(125574);
                ShareToFacebookRedirectUI.this.aqX();
                c5659a.gud.dismiss();
                if (z) {
                    bwp bwp = new bwp();
                    if (C5046bo.isNullOrNil(str)) {
                        str = " ";
                    }
                    bwp.mZR = str;
                    bwp.Name = ShareToFacebookRedirectUI.this.gId;
                    bwp.vEA = ShareToFacebookRedirectUI.this.gIe;
                    bwp.oRb = ShareToFacebookRedirectUI.this.gIg;
                    bwp.wXa = ShareToFacebookRedirectUI.this.gIf;
                    C1720g.m3540Rg().mo14541a(new C42287f(bwp), 0);
                    ShareToFacebookRedirectUI.this.eir = C30379h.m48458b(ShareToFacebookRedirectUI.this, "", false, new C189331());
                    AppMethodBeat.m2505o(125574);
                    return;
                }
                ShareToFacebookRedirectUI.this.finish();
                AppMethodBeat.m2505o(125574);
            }
        }).show();
        AppMethodBeat.m2505o(125580);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(125582);
        super.onActivityResult(i, i2, intent);
        String str = TAG;
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        C4990ab.m7417i(str, str2, objArr);
        if (i == 0 && i2 == -1 && intent != null) {
            C4990ab.m7417i(TAG, "bind facebooksucc %b", Boolean.valueOf(intent.getBooleanExtra("bind_facebook_succ", false)));
            if (intent.getBooleanExtra("bind_facebook_succ", false)) {
                arK();
                arj();
                AppMethodBeat.m2505o(125582);
                return;
            }
        }
        finish();
        AppMethodBeat.m2505o(125582);
    }

    /* renamed from: bj */
    private void m29519bj(String str, String str2) {
        AppMethodBeat.m2504i(125581);
        C30379h.m48440a(this.mController.ylL, str2, str, new C99995(), null);
        AppMethodBeat.m2505o(125581);
    }

    /* renamed from: a */
    static /* synthetic */ void m29517a(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        AppMethodBeat.m2504i(125583);
        C4990ab.m7412e(TAG, "dealWithRefreshTokenFail");
        shareToFacebookRedirectUI.m29519bj(shareToFacebookRedirectUI.mController.ylL.getString(C25738R.string.f9238tz), shareToFacebookRedirectUI.mController.ylL.getString(C25738R.string.bmb));
        AppMethodBeat.m2505o(125583);
    }
}
