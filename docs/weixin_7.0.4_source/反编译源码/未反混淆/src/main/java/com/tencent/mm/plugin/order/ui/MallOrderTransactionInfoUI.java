package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI extends WalletPreferenceUI {
    protected f iFE;
    private int peo;
    private MallTransactionObject pep = null;
    private c peq;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        String string;
        String str;
        AppMethodBeat.i(43879);
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.c aE = a.aE(this);
        String string2;
        if (aE != null && (aE instanceof com.tencent.mm.plugin.order.a.a)) {
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
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.mmui.MMPreference", "mOrders info is Illegal!");
            h.a(this.mController.ylL, (int) R.string.fkw, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(43877);
                    MallOrderTransactionInfoUI.this.finish();
                    AppMethodBeat.o(43877);
                }
            });
        }
        this.peo = bZi().getInt("key_pay_type");
        initView();
        dOM().a(new com.tencent.mm.plugin.order.model.h(str, string), true, 1);
        AppMethodBeat.o(43879);
    }

    public final void initView() {
        AppMethodBeat.i(43880);
        setMMTitle((int) R.string.cx0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(43878);
                MallOrderTransactionInfoUI.this.finish();
                AppMethodBeat.o(43878);
                return false;
            }
        });
        this.iFE = this.yCw;
        this.peq = new c(this);
        this.peq.ase();
        AppMethodBeat.o(43880);
    }

    public void onDestroy() {
        AppMethodBeat.i(43881);
        super.onDestroy();
        if (this.peq != null) {
            this.peq.release();
        }
        AppMethodBeat.o(43881);
    }

    public final int getLayoutId() {
        return R.layout.acd;
    }

    public final int JC() {
        return R.xml.b1;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final boolean f(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(43882);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof com.tencent.mm.plugin.order.model.h) {
                MallOrderDetailObject mallOrderDetailObject = ((com.tencent.mm.plugin.order.model.h) mVar).pcS;
                if (mallOrderDetailObject != null) {
                    List list;
                    this.pep = mallOrderDetailObject.pbI;
                    this.iFE.removeAll();
                    AppCompatActivity appCompatActivity = this.mController.ylL;
                    f fVar = this.iFE;
                    MallTransactionObject mallTransactionObject = this.pep;
                    Object[] objArr = new Object[]{this.peq};
                    if (mallTransactionObject == null) {
                        list = null;
                    } else {
                        com.tencent.mm.plugin.order.model.a.a bVar;
                        switch (mallTransactionObject.cQO) {
                            case 21:
                                bVar = new b();
                                break;
                            default:
                                bVar = new com.tencent.mm.plugin.order.ui.a.a();
                                if (objArr[0] instanceof c) {
                                    ((com.tencent.mm.plugin.order.ui.a.a) bVar).peq = (c) objArr[0];
                                    break;
                                }
                                break;
                        }
                        list = bVar.a(appCompatActivity, fVar, mallTransactionObject);
                    }
                    if (list != null) {
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            this.iFE.b((Preference) list.get(i3));
                        }
                    }
                    this.iFE.notifyDataSetChanged();
                }
            }
            AppMethodBeat.o(43882);
            return true;
        }
        AppMethodBeat.o(43882);
        return false;
    }

    private Bundle bZi() {
        AppMethodBeat.i(43883);
        Bundle aD = a.aD((Activity) this);
        if (aD == null) {
            aD = new Bundle();
        }
        AppMethodBeat.o(43883);
        return aD;
    }
}
