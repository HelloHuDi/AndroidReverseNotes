package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.ListViewInScrollView;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C44025e;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C44027l;
import com.tencent.p177mm.plugin.wxcredit.p1334a.C46477c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI */
public class WalletWXCreditChangeAmountUI extends WalletBaseUI implements OnClickListener {
    private List<C44027l> uYY;
    private List<C44027l> uYZ = new ArrayList();
    private C44027l uZa;
    private C44027l uZb;
    private int uZc = -1;
    private boolean uZd;
    private boolean uZe;
    private TextView uZf;
    private TextView uZg;
    private TextView uZh;
    private TextView uZi;
    private TextView uZj;
    private TextView uZk;
    private EditText uZl;
    private EditText uZm;
    private EditText uZn;
    private EditText uZo;
    private BaseAdapter uZp = new C2493911();
    private BaseAdapter uZq = new C249382();

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$6 */
    class C47086 implements OnClickListener {
        C47086() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48694);
            if (WalletWXCreditChangeAmountUI.m39023b(WalletWXCreditChangeAmountUI.this)) {
                if (WalletWXCreditChangeAmountUI.this.uZa.uYS == null) {
                    WalletWXCreditChangeAmountUI.this.uZa.nYb = WalletWXCreditChangeAmountUI.this.uZl.getText().toString();
                } else if (WalletWXCreditChangeAmountUI.this.uZm.getVisibility() == 0) {
                    WalletWXCreditChangeAmountUI.this.uZa.uYS.nYb = WalletWXCreditChangeAmountUI.this.uZm.getText().toString();
                }
                if (WalletWXCreditChangeAmountUI.this.uZb.uYS == null) {
                    WalletWXCreditChangeAmountUI.this.uZb.nYb = WalletWXCreditChangeAmountUI.this.uZn.getText().toString();
                } else if (WalletWXCreditChangeAmountUI.this.uZo.getVisibility() == 0) {
                    WalletWXCreditChangeAmountUI.this.uZb.uYS.nYb = WalletWXCreditChangeAmountUI.this.uZo.getText().toString();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(WalletWXCreditChangeAmountUI.this.uZa);
                arrayList.add(WalletWXCreditChangeAmountUI.this.uZb);
                String string = WalletWXCreditChangeAmountUI.this.mBundle.getString("kreq_token");
                WalletWXCreditChangeAmountUI.this.mBundle.getString("key_bank_type");
                WalletWXCreditChangeAmountUI.this.mo39970a(new C46477c(arrayList, string), true, false);
                AppMethodBeat.m2505o(48694);
                return;
            }
            C23639t.makeText(WalletWXCreditChangeAmountUI.this.mController.ylL, C25738R.string.fxb, 0).show();
            AppMethodBeat.m2505o(48694);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$7 */
    class C232217 implements OnItemClickListener {
        C232217() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(48695);
            WalletWXCreditChangeAmountUI.this.dismissDialog(1);
            if (WalletWXCreditChangeAmountUI.this.uZd) {
                WalletWXCreditChangeAmountUI.this.uZa.uYP = 0;
                WalletWXCreditChangeAmountUI.this.uZa = (C44027l) WalletWXCreditChangeAmountUI.this.uYZ.get(i);
                WalletWXCreditChangeAmountUI.this.uZa.uYP = 1;
            } else {
                WalletWXCreditChangeAmountUI.this.uZb.uYP = 0;
                WalletWXCreditChangeAmountUI.this.uZb = (C44027l) WalletWXCreditChangeAmountUI.this.uYZ.get(i);
                WalletWXCreditChangeAmountUI.this.uZb.uYP = 2;
            }
            WalletWXCreditChangeAmountUI.m39033k(WalletWXCreditChangeAmountUI.this);
            AppMethodBeat.m2505o(48695);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$9 */
    class C232229 implements DialogInterface.OnClickListener {
        C232229() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48697);
            C40931c aE = C24143a.m37112aE(WalletWXCreditChangeAmountUI.this);
            if (aE != null) {
                aE.mo8125b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.mBundle);
                AppMethodBeat.m2505o(48697);
                return;
            }
            WalletWXCreditChangeAmountUI.this.finish();
            AppMethodBeat.m2505o(48697);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$1 */
    class C249341 implements OnClickListener {
        C249341() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48688);
            WalletWXCreditChangeAmountUI.this.uZd = true;
            WalletWXCreditChangeAmountUI.m39020a(WalletWXCreditChangeAmountUI.this);
            WalletWXCreditChangeAmountUI.this.showDialog(1);
            AppMethodBeat.m2505o(48688);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$4 */
    class C249354 implements OnClickListener {
        C249354() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48692);
            WalletWXCreditChangeAmountUI.this.uZd = false;
            WalletWXCreditChangeAmountUI.m39020a(WalletWXCreditChangeAmountUI.this);
            WalletWXCreditChangeAmountUI.this.showDialog(1);
            AppMethodBeat.m2505o(48692);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$5 */
    class C249365 implements OnMenuItemClickListener {
        C249365() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(48693);
            WalletWXCreditChangeAmountUI.this.aqX();
            WalletWXCreditChangeAmountUI.this.showDialog(3);
            AppMethodBeat.m2505o(48693);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$8 */
    class C249378 implements OnItemClickListener {
        C249378() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(48696);
            WalletWXCreditChangeAmountUI.this.dismissDialog(2);
            if (WalletWXCreditChangeAmountUI.this.uZe) {
                if (i == 0) {
                    WalletWXCreditChangeAmountUI.this.uZa.nYb = "Y";
                } else {
                    WalletWXCreditChangeAmountUI.this.uZa.nYb = "N";
                }
            } else if (i == 0) {
                WalletWXCreditChangeAmountUI.this.uZb.nYb = "Y";
            } else {
                WalletWXCreditChangeAmountUI.this.uZb.nYb = "N";
            }
            WalletWXCreditChangeAmountUI.m39033k(WalletWXCreditChangeAmountUI.this);
            AppMethodBeat.m2505o(48696);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$2 */
    class C249382 extends BaseAdapter {
        C249382() {
        }

        public final int getCount() {
            return 2;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            AppMethodBeat.m2504i(48689);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletWXCreditChangeAmountUI.this, 2130971115, null);
            if (i == 0) {
                checkedTextView.setText(C25738R.string.f9262up);
            } else {
                checkedTextView.setText(C25738R.string.f9183s2);
            }
            if (WalletWXCreditChangeAmountUI.this.uZe) {
                if (WalletWXCreditChangeAmountUI.this.uZa.uYS == null || !"Y".equals(WalletWXCreditChangeAmountUI.this.uZa.nYb)) {
                    if (i == 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                } else {
                    if (i != 0) {
                        z = false;
                    }
                    checkedTextView.setChecked(z);
                }
            } else if (WalletWXCreditChangeAmountUI.this.uZb.uYS == null || !"Y".equals(WalletWXCreditChangeAmountUI.this.uZb.nYb)) {
                if (i == 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            } else {
                if (i != 0) {
                    z = false;
                }
                checkedTextView.setChecked(z);
            }
            AppMethodBeat.m2505o(48689);
            return checkedTextView;
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(48690);
            C44027l c44027l = (C44027l) WalletWXCreditChangeAmountUI.this.uYZ.get(i);
            AppMethodBeat.m2505o(48690);
            return c44027l;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$11 */
    class C2493911 extends BaseAdapter {
        C2493911() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(48702);
            C44027l Km = m39036Km(i);
            AppMethodBeat.m2505o(48702);
            return Km;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(48699);
            if (WalletWXCreditChangeAmountUI.this.uYZ != null) {
                int size = WalletWXCreditChangeAmountUI.this.uYZ.size();
                AppMethodBeat.m2505o(48699);
                return size;
            }
            AppMethodBeat.m2505o(48699);
            return 0;
        }

        /* renamed from: Km */
        private C44027l m39036Km(int i) {
            AppMethodBeat.m2504i(48700);
            C44027l c44027l = (C44027l) WalletWXCreditChangeAmountUI.this.uYZ.get(i);
            AppMethodBeat.m2505o(48700);
            return c44027l;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(48701);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletWXCreditChangeAmountUI.this, 2130971115, null);
            C44027l Km = m39036Km(i);
            checkedTextView.setText(Km.desc);
            checkedTextView.setChecked(Km.uYP != 0);
            AppMethodBeat.m2505o(48701);
            return checkedTextView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$10 */
    class C2494010 implements DialogInterface.OnClickListener {
        C2494010() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48698);
            WalletWXCreditChangeAmountUI.this.showVKB();
            AppMethodBeat.m2505o(48698);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI$3 */
    class C249413 implements DialogInterface.OnClickListener {
        C249413() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48691);
            C40931c aE = C24143a.m37112aE(WalletWXCreditChangeAmountUI.this);
            if (aE != null) {
                aE.mo8125b(WalletWXCreditChangeAmountUI.this, WalletWXCreditChangeAmountUI.this.mBundle);
                AppMethodBeat.m2505o(48691);
                return;
            }
            WalletWXCreditChangeAmountUI.this.finish();
            AppMethodBeat.m2505o(48691);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletWXCreditChangeAmountUI() {
        AppMethodBeat.m2504i(48703);
        AppMethodBeat.m2505o(48703);
    }

    /* renamed from: k */
    static /* synthetic */ void m39033k(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        AppMethodBeat.m2504i(48712);
        walletWXCreditChangeAmountUI.m39025cu();
        AppMethodBeat.m2505o(48712);
    }

    public final int getLayoutId() {
        return 2130971184;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48704);
        super.onCreate(bundle);
        initView();
        m39025cu();
        AppMethodBeat.m2505o(48704);
    }

    public final void initView() {
        AppMethodBeat.m2504i(48705);
        setMMTitle((int) C25738R.string.fxf);
        this.uZf = (TextView) findViewById(2131829080);
        this.uZh = (TextView) findViewById(2131829083);
        this.uZg = (TextView) findViewById(2131829085);
        this.uZi = (TextView) findViewById(2131829088);
        this.uZl = (EditText) findViewById(2131829081);
        this.uZm = (EditText) findViewById(2131829084);
        this.uZn = (EditText) findViewById(2131829086);
        this.uZo = (EditText) findViewById(2131829089);
        this.uZj = (TextView) findViewById(2131829082);
        this.uZk = (TextView) findViewById(2131829087);
        this.uZj.setOnClickListener(this);
        this.uZk.setOnClickListener(this);
        this.uZf.setOnClickListener(new C249341());
        this.uZg.setOnClickListener(new C249354());
        setBackBtn(new C249365());
        findViewById(2131822846).setOnClickListener(new C47086());
        AppMethodBeat.m2505o(48705);
    }

    /* renamed from: cu */
    private void m39025cu() {
        AppMethodBeat.m2504i(48706);
        if (this.uZa != null) {
            this.uZf.setText(this.uZa.desc);
            if (this.uZa.uYS != null) {
                this.uZj.setVisibility(0);
                this.uZl.setVisibility(8);
                this.uZh.setText(this.uZa.uYS.desc);
                this.uZm.setHint(this.uZa.uYS.kfM);
                if ("Y".equals(this.uZa.nYb)) {
                    this.uZh.setVisibility(0);
                    this.uZm.setVisibility(0);
                    this.uZj.setText(C25738R.string.f9262up);
                } else {
                    this.uZh.setVisibility(8);
                    this.uZm.setVisibility(8);
                    if ("N".equals(this.uZa.nYb)) {
                        this.uZj.setText(C25738R.string.f9183s2);
                    }
                }
            } else {
                this.uZj.setVisibility(8);
                this.uZl.setVisibility(0);
                this.uZl.setHint(this.uZa.kfM);
                this.uZh.setVisibility(8);
                this.uZm.setVisibility(8);
            }
        }
        if (this.uZb != null) {
            this.uZg.setText(this.uZb.desc);
            if (this.uZb.uYS != null) {
                this.uZk.setVisibility(0);
                this.uZn.setVisibility(8);
                this.uZi.setText(this.uZb.uYS.desc);
                this.uZo.setHint(this.uZb.uYS.kfM);
                if ("Y".equals(this.uZb.nYb)) {
                    this.uZi.setVisibility(0);
                    this.uZo.setVisibility(0);
                    this.uZk.setText(C25738R.string.f9262up);
                    AppMethodBeat.m2505o(48706);
                    return;
                }
                this.uZi.setVisibility(8);
                this.uZo.setVisibility(8);
                if ("N".equals(this.uZb.nYb)) {
                    this.uZk.setText(C25738R.string.f9183s2);
                    AppMethodBeat.m2505o(48706);
                    return;
                }
            }
            this.uZk.setVisibility(8);
            this.uZn.setVisibility(0);
            this.uZn.setHint(this.uZb.kfM);
            this.uZi.setVisibility(8);
            this.uZo.setVisibility(8);
        }
        AppMethodBeat.m2505o(48706);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48707);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C44025e) {
                this.uYY = ((C44025e) c1207m).uYx;
                this.uZc = ((C44025e) c1207m).uYy;
                if (this.uYY != null && this.uYY.size() >= 2) {
                    this.uZa = (C44027l) this.uYY.get(0);
                    this.uZb = (C44027l) this.uYY.get(1);
                    this.uZa.uYP = 1;
                    this.uZb.uYP = 2;
                }
                m39025cu();
                AppMethodBeat.m2505o(48707);
                return true;
            }
        } else if (c1207m instanceof C46477c) {
            C30379h.m48448a((Context) this, str, null, false, new C249413());
            AppMethodBeat.m2505o(48707);
            return true;
        }
        AppMethodBeat.m2505o(48707);
        return false;
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(48708);
        if (view.getId() == 2131829082) {
            this.uZe = true;
            showDialog(2);
            AppMethodBeat.m2505o(48708);
            return;
        }
        if (view.getId() == 2131829087) {
            this.uZe = false;
            showDialog(2);
        }
        AppMethodBeat.m2505o(48708);
    }

    public /* synthetic */ Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(48709);
        View inflate;
        ListViewInScrollView listViewInScrollView;
        C5652a c5652a;
        Dialog aMb;
        switch (i) {
            case 1:
                inflate = getLayoutInflater().inflate(2130971114, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(2131821054);
                listViewInScrollView.setAdapter(this.uZp);
                listViewInScrollView.setOnItemClickListener(new C232217());
                c5652a = new C5652a(this);
                c5652a.mo11446PV(C25738R.string.fxd);
                c5652a.mo11479fn(inflate);
                c5652a.mo11478f(null);
                aMb = c5652a.aMb();
                AppMethodBeat.m2505o(48709);
                return aMb;
            case 2:
                inflate = getLayoutInflater().inflate(2130971114, null);
                listViewInScrollView = (ListViewInScrollView) inflate.findViewById(2131821054);
                listViewInScrollView.setAdapter(this.uZq);
                listViewInScrollView.setOnItemClickListener(new C249378());
                c5652a = new C5652a(this);
                c5652a.mo11446PV(C25738R.string.fx_);
                c5652a.mo11479fn(inflate);
                c5652a.mo11478f(null);
                aMb = c5652a.aMb();
                AppMethodBeat.m2505o(48709);
                return aMb;
            case 3:
                String string = getString(C25738R.string.fxc);
                if (this.uZc > 0) {
                    string = getString(C25738R.string.fxa, new Object[]{Integer.valueOf(this.uZc)});
                }
                aMb = C30379h.m48440a((Context) this, string, null, new C232229(), new C2494010());
                AppMethodBeat.m2505o(48709);
                return aMb;
            default:
                C5653c b = C30379h.m48461b((Context) this, "", "", true);
                AppMethodBeat.m2505o(48709);
                return b;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m39020a(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        AppMethodBeat.m2504i(48710);
        walletWXCreditChangeAmountUI.uYZ.clear();
        if (walletWXCreditChangeAmountUI.uZd) {
            for (C44027l c44027l : walletWXCreditChangeAmountUI.uYY) {
                if (c44027l.uYP != 2) {
                    walletWXCreditChangeAmountUI.uYZ.add(c44027l);
                }
            }
            AppMethodBeat.m2505o(48710);
            return;
        }
        for (C44027l c44027l2 : walletWXCreditChangeAmountUI.uYY) {
            if (c44027l2.uYP != 1) {
                walletWXCreditChangeAmountUI.uYZ.add(c44027l2);
            }
        }
        AppMethodBeat.m2505o(48710);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m39023b(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        AppMethodBeat.m2504i(48711);
        if (walletWXCreditChangeAmountUI.uZa == null || walletWXCreditChangeAmountUI.uZb == null) {
            AppMethodBeat.m2505o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZl.getVisibility() == 0 && C5046bo.isNullOrNil(walletWXCreditChangeAmountUI.uZl.getText().toString())) {
            AppMethodBeat.m2505o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZm.getVisibility() == 0 && C5046bo.isNullOrNil(walletWXCreditChangeAmountUI.uZm.getText().toString())) {
            AppMethodBeat.m2505o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZj.getVisibility() == 0 && C5046bo.isNullOrNil(walletWXCreditChangeAmountUI.uZj.getText().toString())) {
            AppMethodBeat.m2505o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZn.getVisibility() == 0 && C5046bo.isNullOrNil(walletWXCreditChangeAmountUI.uZn.getText().toString())) {
            AppMethodBeat.m2505o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZo.getVisibility() == 0 && C5046bo.isNullOrNil(walletWXCreditChangeAmountUI.uZo.getText().toString())) {
            AppMethodBeat.m2505o(48711);
            return false;
        } else if (walletWXCreditChangeAmountUI.uZk.getVisibility() == 0 && C5046bo.isNullOrNil(walletWXCreditChangeAmountUI.uZk.getText().toString())) {
            AppMethodBeat.m2505o(48711);
            return false;
        } else {
            AppMethodBeat.m2505o(48711);
            return true;
        }
    }
}
