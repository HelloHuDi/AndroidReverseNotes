package com.tencent.p177mm.plugin.order.p480ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.order.model.C43363h;
import com.tencent.p177mm.plugin.order.model.C46125a.C3567a;
import com.tencent.p177mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.p177mm.plugin.order.model.MallTransactionObject;
import com.tencent.p177mm.plugin.order.p1007a.C34656a;
import com.tencent.p177mm.plugin.order.p480ui.p1009a.C12790a;
import com.tencent.p177mm.plugin.order.p480ui.p1009a.C46127b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C46724c;
import com.tencent.p177mm.wallet_core.p650ui.WalletPreferenceUI;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI */
public class MallOrderTransactionInfoUI extends WalletPreferenceUI {
    protected C15541f iFE;
    private int peo;
    private MallTransactionObject pep = null;
    private C46724c peq;

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI$1 */
    class C127861 implements OnClickListener {
        C127861() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43877);
            MallOrderTransactionInfoUI.this.finish();
            AppMethodBeat.m2505o(43877);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI$2 */
    class C127872 implements OnMenuItemClickListener {
        C127872() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(43878);
            MallOrderTransactionInfoUI.this.finish();
            AppMethodBeat.m2505o(43878);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        String string;
        String str;
        AppMethodBeat.m2504i(43879);
        super.onCreate(bundle);
        C40931c aE = C24143a.m37112aE(this);
        String string2;
        if (aE != null && (aE instanceof C34656a)) {
            string2 = bZi().getString("key_trans_id");
            string = bZi().getString("bill_id");
            str = string2;
        } else if (getIntent().getIntExtra("scene", 0) == 1 || getIntent().getIntExtra("scene", 0) == 2) {
            string2 = getIntent().getStringExtra("trans_id");
            string = getIntent().getStringExtra("bill_id");
            str = string2;
        } else {
            string = null;
            str = null;
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
            C30379h.m48431a(this.mController.ylL, (int) C25738R.string.fkw, 0, new C127861());
        }
        this.peo = bZi().getInt("key_pay_type");
        initView();
        dOM().mo49367a(new C43363h(str, string), true, 1);
        AppMethodBeat.m2505o(43879);
    }

    public final void initView() {
        AppMethodBeat.m2504i(43880);
        setMMTitle((int) C25738R.string.cx0);
        setBackBtn(new C127872());
        this.iFE = this.yCw;
        this.peq = new C46724c(this);
        this.peq.ase();
        AppMethodBeat.m2505o(43880);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43881);
        super.onDestroy();
        if (this.peq != null) {
            this.peq.release();
        }
        AppMethodBeat.m2505o(43881);
    }

    public final int getLayoutId() {
        return 2130970063;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8516b1;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        return false;
    }

    /* renamed from: f */
    public final boolean mo24791f(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43882);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C43363h) {
                MallOrderDetailObject mallOrderDetailObject = ((C43363h) c1207m).pcS;
                if (mallOrderDetailObject != null) {
                    List list;
                    this.pep = mallOrderDetailObject.pbI;
                    this.iFE.removeAll();
                    AppCompatActivity appCompatActivity = this.mController.ylL;
                    C15541f c15541f = this.iFE;
                    MallTransactionObject mallTransactionObject = this.pep;
                    Object[] objArr = new Object[]{this.peq};
                    if (mallTransactionObject == null) {
                        list = null;
                    } else {
                        C3567a c46127b;
                        switch (mallTransactionObject.cQO) {
                            case 21:
                                c46127b = new C46127b();
                                break;
                            default:
                                c46127b = new C12790a();
                                if (objArr[0] instanceof C46724c) {
                                    ((C12790a) c46127b).peq = (C46724c) objArr[0];
                                    break;
                                }
                                break;
                        }
                        list = c46127b.mo8135a(appCompatActivity, c15541f, mallTransactionObject);
                    }
                    if (list != null) {
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            this.iFE.mo27713b((Preference) list.get(i3));
                        }
                    }
                    this.iFE.notifyDataSetChanged();
                }
            }
            AppMethodBeat.m2505o(43882);
            return true;
        }
        AppMethodBeat.m2505o(43882);
        return false;
    }

    private Bundle bZi() {
        AppMethodBeat.m2504i(43883);
        Bundle aD = C24143a.m37110aD((Activity) this);
        if (aD == null) {
            aD = new Bundle();
        }
        AppMethodBeat.m2505o(43883);
        return aD;
    }
}
