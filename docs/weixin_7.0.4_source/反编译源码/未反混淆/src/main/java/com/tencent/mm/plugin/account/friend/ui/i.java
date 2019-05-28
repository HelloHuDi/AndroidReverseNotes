package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import junit.framework.Assert;

public final class i implements f {
    public String cFl;
    public boolean eVT = false;
    private final a gyp;
    public x gyq;
    private x gyr;
    public boolean gys = true;
    public b gyt;
    public Context mContext;
    public p tipDialog = null;

    public interface a {
        void e(int i, Bundle bundle);
    }

    public enum b {
        BINDMOBILE,
        CHANGEMOBILE;

        static {
            AppMethodBeat.o(108660);
        }
    }

    public i(b bVar, Context context, a aVar) {
        this.gyt = bVar;
        this.mContext = context;
        this.gyp = aVar;
    }

    public final void wn(String str) {
        AppMethodBeat.i(108661);
        if (this.gyt == b.BINDMOBILE || this.gyt == b.CHANGEMOBILE) {
            g.Rg().a(132, (f) this);
        }
        this.cFl = str;
        this.eVT = false;
        aqA();
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        this.tipDialog = h.b(this.mContext, this.mContext.getString(R.string.th), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                i.this.eVT = true;
            }
        });
        AppMethodBeat.o(108661);
    }

    public final void recycle() {
        AppMethodBeat.i(108662);
        g.Rg().b(132, (f) this);
        this.mContext = null;
        this.eVT = true;
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(108662);
    }

    private boolean C(int i, String str) {
        boolean z;
        AppMethodBeat.i(108663);
        switch (i) {
            case -214:
                com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this.mContext, null, null);
                }
                z = true;
                break;
            case -74:
                h.a(this.mContext, (int) R.string.a6g, (int) R.string.tz, null);
                z = true;
                break;
            case -59:
                h.a(this.mContext, (int) R.string.a6l, (int) R.string.tz, null);
                z = true;
                break;
            case -57:
            case -1:
                Toast.makeText(this.mContext, R.string.ps, 0).show();
                z = true;
                break;
            case -43:
                ab.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
                if (b.BINDMOBILE == this.gyt || this.gyt == b.CHANGEMOBILE) {
                    g.RP().Ry().set(4097, (Object) "");
                    String str2 = (String) g.RP().Ry().get(6, (Object) "");
                    g.RP().Ry().set(6, this.cFl);
                    if (!bo.isNullOrNil(str2)) {
                        if (g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_LAST_LOGIN_USERNAME_STRING, (Object) "").equals(str2)) {
                            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_LAST_LOGIN_USERNAME_STRING, r.Yz());
                        }
                        for (String str3 : bx.fnB.aat()) {
                            if (str2.equals(bx.fnB.getString(str3, "login_user_name"))) {
                                bx.fnB.n(str3, "login_user_name", str3);
                            }
                        }
                    }
                    ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                }
                e(2, new Bundle());
                Toast.makeText(this.mContext, R.string.a6h, 0).show();
                z = true;
                break;
            case -41:
                Toast.makeText(this.mContext, R.string.a6j, 0).show();
                z = true;
                break;
            case -36:
                Toast.makeText(this.mContext, R.string.a6m, 0).show();
                z = true;
                break;
            case -35:
                h.a(this.mContext, (int) R.string.a6i, (int) R.string.a7y, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z = true;
                break;
            case -34:
                Toast.makeText(this.mContext, R.string.a6k, 0).show();
                z = true;
                break;
            case -4:
                z = false;
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.o(108663);
        return z;
    }

    private void e(int i, Bundle bundle) {
        AppMethodBeat.i(108664);
        if (this.gyt == b.BINDMOBILE || this.gyt == b.CHANGEMOBILE) {
            g.Rg().b(132, (f) this);
        }
        if (this.gyp != null) {
            this.gyp.e(i, bundle);
        }
        AppMethodBeat.o(108664);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(108665);
        ab.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (mVar != this.gyq && mVar != this.gyr) {
            ab.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
            AppMethodBeat.o(108665);
        } else if (this.eVT) {
            AppMethodBeat.o(108665);
        } else if ((b.BINDMOBILE == this.gyt || b.CHANGEMOBILE == this.gyt) && mVar.getType() == 132) {
            switch (((x) mVar).Ah()) {
                case 1:
                case 2:
                case 18:
                case 19:
                    if (i != 0 || i2 != 0) {
                        if (!C(i2, str)) {
                            com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                            if (jY != null) {
                                jY.a(this.mContext, null, null);
                                AppMethodBeat.o(108665);
                                return;
                            }
                            Toast.makeText(this.mContext, this.mContext.getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        }
                        AppMethodBeat.o(108665);
                        return;
                    } else if (((x) mVar).Ah() == 2 || ((x) mVar).Ah() == 19) {
                        int i3;
                        if (this.gys) {
                            ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                        }
                        Bundle bundle = new Bundle();
                        if (((x) mVar).Ah() == 2) {
                            ab.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", ((x) mVar).agg());
                            bundle.putString("setpwd_ticket", ((x) mVar).agg());
                        }
                        if (((jp) ((x) mVar).ehh.fsH.fsP).vLU != 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            bundle.putBoolean("restart_wechat", true);
                        }
                        e(2, bundle);
                        AppMethodBeat.o(108665);
                        return;
                    } else {
                        e(1, new Bundle());
                        AppMethodBeat.o(108665);
                        return;
                    }
                default:
                    AppMethodBeat.o(108665);
                    return;
            }
        } else {
            Assert.assertTrue("code path should not be here!", false);
            AppMethodBeat.o(108665);
        }
    }

    private void aqA() {
        AppMethodBeat.i(108666);
        if (this.gyt == b.BINDMOBILE || this.gyt == b.CHANGEMOBILE) {
            int i = 1;
            if (this.gyt == b.CHANGEMOBILE) {
                i = 18;
            }
            this.gyr = new x(this.cFl, i, "", 0, "");
            g.Rg().a(this.gyr, 0);
        }
        AppMethodBeat.o(108666);
    }
}
