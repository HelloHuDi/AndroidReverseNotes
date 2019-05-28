package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.account.friend.p272a.C38037x;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.protocal.protobuf.C35927jp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.i */
public final class C6725i implements C1202f {
    public String cFl;
    public boolean eVT = false;
    private final C6726a gyp;
    public C38037x gyq;
    private C38037x gyr;
    public boolean gys = true;
    public C6727b gyt;
    public Context mContext;
    public C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.i$a */
    public interface C6726a {
        /* renamed from: e */
        void mo14957e(int i, Bundle bundle);
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.i$b */
    public enum C6727b {
        BINDMOBILE,
        CHANGEMOBILE;

        static {
            AppMethodBeat.m2505o(108660);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.i$1 */
    class C67281 implements OnCancelListener {
        C67281() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            C6725i.this.eVT = true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.i$3 */
    class C67293 implements OnClickListener {
        C67293() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.i$2 */
    public class C67302 implements OnCancelListener {
        public final void onCancel(DialogInterface dialogInterface) {
            C6725i.this.eVT = true;
        }
    }

    public C6725i(C6727b c6727b, Context context, C6726a c6726a) {
        this.gyt = c6727b;
        this.mContext = context;
        this.gyp = c6726a;
    }

    /* renamed from: wn */
    public final void mo14956wn(String str) {
        AppMethodBeat.m2504i(108661);
        if (this.gyt == C6727b.BINDMOBILE || this.gyt == C6727b.CHANGEMOBILE) {
            C1720g.m3540Rg().mo14539a(132, (C1202f) this);
        }
        this.cFl = str;
        this.eVT = false;
        aqA();
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        this.tipDialog = C30379h.m48458b(this.mContext, this.mContext.getString(C25738R.string.f9222th), true, new C67281());
        AppMethodBeat.m2505o(108661);
    }

    public final void recycle() {
        AppMethodBeat.m2504i(108662);
        C1720g.m3540Rg().mo14546b(132, (C1202f) this);
        this.mContext = null;
        this.eVT = true;
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(108662);
    }

    /* renamed from: C */
    private boolean m11156C(int i, String str) {
        boolean z;
        AppMethodBeat.m2504i(108663);
        switch (i) {
            case -214:
                C42124a jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this.mContext, null, null);
                }
                z = true;
                break;
            case -74:
                C30379h.m48431a(this.mContext, (int) C25738R.string.a6g, (int) C25738R.string.f9238tz, null);
                z = true;
                break;
            case -59:
                C30379h.m48431a(this.mContext, (int) C25738R.string.a6l, (int) C25738R.string.f9238tz, null);
                z = true;
                break;
            case -57:
            case -1:
                Toast.makeText(this.mContext, C25738R.string.f9111ps, 0).show();
                z = true;
                break;
            case -43:
                C4990ab.m7412e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
                if (C6727b.BINDMOBILE == this.gyt || this.gyt == C6727b.CHANGEMOBILE) {
                    C1720g.m3536RP().mo5239Ry().set(4097, (Object) "");
                    String str2 = (String) C1720g.m3536RP().mo5239Ry().get(6, (Object) "");
                    C1720g.m3536RP().mo5239Ry().set(6, this.cFl);
                    if (!C5046bo.isNullOrNil(str2)) {
                        if (C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LAST_LOGIN_USERNAME_STRING, (Object) "").equals(str2)) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LAST_LOGIN_USERNAME_STRING, C1853r.m3846Yz());
                        }
                        for (String str3 : C37914bx.fnB.aat()) {
                            if (str2.equals(C37914bx.fnB.getString(str3, "login_user_name"))) {
                                C37914bx.fnB.mo60668n(str3, "login_user_name", str3);
                            }
                        }
                    }
                    ((C7599a) C1720g.m3530M(C7599a.class)).syncAddrBookAndUpload();
                }
                m11157e(2, new Bundle());
                Toast.makeText(this.mContext, C25738R.string.a6h, 0).show();
                z = true;
                break;
            case -41:
                Toast.makeText(this.mContext, C25738R.string.a6j, 0).show();
                z = true;
                break;
            case -36:
                Toast.makeText(this.mContext, C25738R.string.a6m, 0).show();
                z = true;
                break;
            case -35:
                C30379h.m48431a(this.mContext, (int) C25738R.string.a6i, (int) C25738R.string.a7y, new C67293());
                z = true;
                break;
            case -34:
                Toast.makeText(this.mContext, C25738R.string.a6k, 0).show();
                z = true;
                break;
            case -4:
                z = false;
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.m2505o(108663);
        return z;
    }

    /* renamed from: e */
    private void m11157e(int i, Bundle bundle) {
        AppMethodBeat.m2504i(108664);
        if (this.gyt == C6727b.BINDMOBILE || this.gyt == C6727b.CHANGEMOBILE) {
            C1720g.m3540Rg().mo14546b(132, (C1202f) this);
        }
        if (this.gyp != null) {
            this.gyp.mo14957e(i, bundle);
        }
        AppMethodBeat.m2505o(108664);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(108665);
        C4990ab.m7416i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (c1207m != this.gyq && c1207m != this.gyr) {
            C4990ab.m7416i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
            AppMethodBeat.m2505o(108665);
        } else if (this.eVT) {
            AppMethodBeat.m2505o(108665);
        } else if ((C6727b.BINDMOBILE == this.gyt || C6727b.CHANGEMOBILE == this.gyt) && c1207m.getType() == 132) {
            switch (((C38037x) c1207m).mo60786Ah()) {
                case 1:
                case 2:
                case 18:
                case 19:
                    if (i != 0 || i2 != 0) {
                        if (!m11156C(i2, str)) {
                            C42124a jY = C42124a.m74268jY(str);
                            if (jY != null) {
                                jY.mo67668a(this.mContext, null, null);
                                AppMethodBeat.m2505o(108665);
                                return;
                            }
                            Toast.makeText(this.mContext, this.mContext.getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        }
                        AppMethodBeat.m2505o(108665);
                        return;
                    } else if (((C38037x) c1207m).mo60786Ah() == 2 || ((C38037x) c1207m).mo60786Ah() == 19) {
                        int i3;
                        if (this.gys) {
                            ((C7599a) C1720g.m3530M(C7599a.class)).syncAddrBookAndUpload();
                        }
                        Bundle bundle = new Bundle();
                        if (((C38037x) c1207m).mo60786Ah() == 2) {
                            C4990ab.m7417i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", ((C38037x) c1207m).agg());
                            bundle.putString("setpwd_ticket", ((C38037x) c1207m).agg());
                        }
                        if (((C35927jp) ((C38037x) c1207m).ehh.fsH.fsP).vLU != 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            bundle.putBoolean("restart_wechat", true);
                        }
                        m11157e(2, bundle);
                        AppMethodBeat.m2505o(108665);
                        return;
                    } else {
                        m11157e(1, new Bundle());
                        AppMethodBeat.m2505o(108665);
                        return;
                    }
                default:
                    AppMethodBeat.m2505o(108665);
                    return;
            }
        } else {
            Assert.assertTrue("code path should not be here!", false);
            AppMethodBeat.m2505o(108665);
        }
    }

    private void aqA() {
        AppMethodBeat.m2504i(108666);
        if (this.gyt == C6727b.BINDMOBILE || this.gyt == C6727b.CHANGEMOBILE) {
            int i = 1;
            if (this.gyt == C6727b.CHANGEMOBILE) {
                i = 18;
            }
            this.gyr = new C38037x(this.cFl, i, "", 0, "");
            C1720g.m3540Rg().mo14541a(this.gyr, 0);
        }
        AppMethodBeat.m2505o(108666);
    }
}
