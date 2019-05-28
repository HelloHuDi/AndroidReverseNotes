package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.protocal.protobuf.bwp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.wxmm.v2helper;

@a(3)
public class ShareToFacebookRedirectUI extends MMActivity implements f {
    private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
    private p eir;
    private String gId;
    private String gIe;
    private String gIf;
    private String gIg;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125576);
        super.onCreate(bundle);
        g.Rg().a((int) v2helper.EMethodSetSendToNetworkOff, (f) this);
        this.gId = getIntent().getStringExtra("title");
        this.gIe = getIntent().getStringExtra("digest");
        this.gIf = getIntent().getStringExtra("img");
        this.gIg = getIntent().getStringExtra("link");
        ab.i(TAG, "title %s, digest:%s, img:%s, link:%s", this.gId, this.gIe, this.gIf, this.gIg);
        if (r.Za()) {
            arK();
            arj();
            AppMethodBeat.o(125576);
            return;
        }
        Intent intent = new Intent(this, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        startActivityForResult(intent, 0);
        AppMethodBeat.o(125576);
    }

    public void onDestroy() {
        AppMethodBeat.i(125577);
        g.Rg().b((int) v2helper.EMethodSetSendToNetworkOff, (f) this);
        super.onDestroy();
        AppMethodBeat.o(125577);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125578);
        ab.i(TAG, "type:%d, code:%d, msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        aqX();
        this.eir.dismiss();
        if (i == 4 && i2 == -68) {
            if (bo.isNullOrNil(str)) {
                str = "error";
            }
            bj(getString(R.string.tz), str);
            AppMethodBeat.o(125578);
        } else if (i == 0 && i2 == 0) {
            String string = getString(R.string.egv);
            AnonymousClass1 anonymousClass1 = new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            h.bQ(this, string);
            finish();
            AppMethodBeat.o(125578);
        } else {
            h.a(this.mController.ylL, "err(" + i2 + "," + i + ")", getString(R.string.tz), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(125570);
                    ShareToFacebookRedirectUI.this.finish();
                    AppMethodBeat.o(125570);
                }
            }, null);
            AppMethodBeat.o(125578);
        }
    }

    private void arK() {
        AppMethodBeat.i(125579);
        ab.i(TAG, "refreshFacebookToken");
        long c = bo.c((Long) g.RP().Ry().get(65831, null));
        String nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(65830, null));
        if (bo.gb(c) <= 86400000 || nullAsNil.length() <= 0) {
            arj();
            AppMethodBeat.o(125579);
            return;
        }
        c cVar = new c(getString(R.string.g7d));
        cVar.arX(nullAsNil);
        new com.tencent.mm.plugin.account.model.h(cVar, new i() {
            public final void p(Bundle bundle) {
                AppMethodBeat.i(125571);
                super.p(bundle);
                AppMethodBeat.o(125571);
            }

            public final void onError(int i, String str) {
                AppMethodBeat.i(125572);
                ab.e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", Integer.valueOf(i), str);
                super.onError(i, str);
                if (i == 3) {
                    ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this);
                }
                AppMethodBeat.o(125572);
            }
        }).apm();
        AppMethodBeat.o(125579);
    }

    private void arj() {
        AppMethodBeat.i(125580);
        ab.i(TAG, "doSend");
        final e.a aVar = new e.a(this);
        aVar.al(this.gId).asM(this.gIf).am(this.gIe).asN(getString(R.string.ow)).Qg(R.string.tl).c(new e.c() {
            public final void d(boolean z, String str) {
                AppMethodBeat.i(125574);
                ShareToFacebookRedirectUI.this.aqX();
                aVar.gud.dismiss();
                if (z) {
                    bwp bwp = new bwp();
                    if (bo.isNullOrNil(str)) {
                        str = " ";
                    }
                    bwp.mZR = str;
                    bwp.Name = ShareToFacebookRedirectUI.this.gId;
                    bwp.vEA = ShareToFacebookRedirectUI.this.gIe;
                    bwp.oRb = ShareToFacebookRedirectUI.this.gIg;
                    bwp.wXa = ShareToFacebookRedirectUI.this.gIf;
                    g.Rg().a(new com.tencent.mm.plugin.account.model.f(bwp), 0);
                    ShareToFacebookRedirectUI.this.eir = h.b(ShareToFacebookRedirectUI.this, "", false, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(125573);
                            ShareToFacebookRedirectUI.this.eir.dismiss();
                            ShareToFacebookRedirectUI.this.finish();
                            AppMethodBeat.o(125573);
                        }
                    });
                    AppMethodBeat.o(125574);
                    return;
                }
                ShareToFacebookRedirectUI.this.finish();
                AppMethodBeat.o(125574);
            }
        }).show();
        AppMethodBeat.o(125580);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(125582);
        super.onActivityResult(i, i2, intent);
        String str = TAG;
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        ab.i(str, str2, objArr);
        if (i == 0 && i2 == -1 && intent != null) {
            ab.i(TAG, "bind facebooksucc %b", Boolean.valueOf(intent.getBooleanExtra("bind_facebook_succ", false)));
            if (intent.getBooleanExtra("bind_facebook_succ", false)) {
                arK();
                arj();
                AppMethodBeat.o(125582);
                return;
            }
        }
        finish();
        AppMethodBeat.o(125582);
    }

    private void bj(String str, String str2) {
        AppMethodBeat.i(125581);
        h.a(this.mController.ylL, str2, str, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(125575);
                Intent intent = new Intent(ShareToFacebookRedirectUI.this.mController.ylL, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                ShareToFacebookRedirectUI.this.mController.ylL.startActivityForResult(intent, 0);
                AppMethodBeat.o(125575);
            }
        }, null);
        AppMethodBeat.o(125581);
    }

    static /* synthetic */ void a(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        AppMethodBeat.i(125583);
        ab.e(TAG, "dealWithRefreshTokenFail");
        shareToFacebookRedirectUI.bj(shareToFacebookRedirectUI.mController.ylL.getString(R.string.tz), shareToFacebookRedirectUI.mController.ylL.getString(R.string.bmb));
        AppMethodBeat.o(125583);
    }
}
