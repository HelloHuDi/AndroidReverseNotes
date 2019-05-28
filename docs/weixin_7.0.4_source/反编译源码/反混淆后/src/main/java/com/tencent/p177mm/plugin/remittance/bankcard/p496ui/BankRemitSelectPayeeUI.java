package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C13021f;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C39585j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C22657a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI */
public class BankRemitSelectPayeeUI extends BankRemitBaseUI implements C5279d {
    private C46696j icA;
    private ListView pOg;
    private C34807b pOh;
    private List<TransferRecordParcel> pOi;
    private ArrayList<TransferRecordParcel> pOj;
    private ArrayList<String> pOk;
    private int pOl = -1;
    private int pOm = -1;
    private Intent pOn;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI$5 */
    class C216385 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI$5$1 */
        class C216371 implements Runnable {
            C216371() {
            }

            public final void run() {
                AppMethodBeat.m2504i(44675);
                BankRemitSelectPayeeUI.this.aqX();
                AppMethodBeat.m2505o(44675);
            }
        }

        C216385() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(44676);
            C5004al.m7442n(new C216371(), 500);
            AppMethodBeat.m2505o(44676);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI$a */
    class C21640a {
        TextView pMb;
        CdnImageView pOt;
        TextView pOu;

        private C21640a() {
        }

        /* synthetic */ C21640a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI$6 */
    class C288676 implements C40929a {
        C288676() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44677);
            C4990ab.m7413e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(44677);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI$b */
    class C34807b extends BaseAdapter {
        private C34807b() {
        }

        /* synthetic */ C34807b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(44682);
            int size = BankRemitSelectPayeeUI.this.pOi.size();
            if (cfn()) {
                size++;
            }
            if (cfo()) {
                size++;
            }
            AppMethodBeat.m2505o(44682);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(44683);
            Object obj;
            if (i == BankRemitSelectPayeeUI.this.pOl || i == BankRemitSelectPayeeUI.this.pOm) {
                AppMethodBeat.m2505o(44683);
                return null;
            } else if (i < BankRemitSelectPayeeUI.this.pOm) {
                obj = BankRemitSelectPayeeUI.this.pOi.get(i - 1);
                AppMethodBeat.m2505o(44683);
                return obj;
            } else if (!cfo() || i <= BankRemitSelectPayeeUI.this.pOm) {
                if (cfn()) {
                    obj = BankRemitSelectPayeeUI.this.pOi.get(i - 1);
                    AppMethodBeat.m2505o(44683);
                    return obj;
                }
                C4990ab.m7417i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", Integer.valueOf(i), Integer.valueOf(BankRemitSelectPayeeUI.this.pOl), Integer.valueOf(BankRemitSelectPayeeUI.this.pOm));
                AppMethodBeat.m2505o(44683);
                return null;
            } else if (cfn()) {
                obj = BankRemitSelectPayeeUI.this.pOi.get(i - 2);
                AppMethodBeat.m2505o(44683);
                return obj;
            } else {
                obj = BankRemitSelectPayeeUI.this.pOi.get(i - 1);
                AppMethodBeat.m2505o(44683);
                return obj;
            }
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(44684);
            if (i == BankRemitSelectPayeeUI.this.pOl || i == BankRemitSelectPayeeUI.this.pOm) {
                AppMethodBeat.m2505o(44684);
                return false;
            }
            AppMethodBeat.m2505o(44684);
            return true;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(44685);
            if (i == BankRemitSelectPayeeUI.this.pOl || i == BankRemitSelectPayeeUI.this.pOm) {
                AppMethodBeat.m2505o(44685);
                return 0;
            }
            AppMethodBeat.m2505o(44685);
            return 1;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(44686);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                if (itemViewType == 0) {
                    view = LayoutInflater.from(BankRemitSelectPayeeUI.this.mController.ylL).inflate(2130968826, viewGroup, false);
                } else {
                    view = LayoutInflater.from(BankRemitSelectPayeeUI.this.mController.ylL).inflate(2130968827, viewGroup, false);
                    C21640a c21640a = new C21640a(BankRemitSelectPayeeUI.this, (byte) 0);
                    c21640a.pOt = (CdnImageView) view.findViewById(2131821690);
                    c21640a.pMb = (TextView) view.findViewById(2131821691);
                    c21640a.pOu = (TextView) view.findViewById(2131821692);
                    view.setTag(c21640a);
                }
            }
            switch (itemViewType) {
                case 0:
                    boolean z;
                    TextView textView = (TextView) view.findViewById(2131821688);
                    if (BankRemitSelectPayeeUI.this.pOl == i) {
                        itemViewType = 1;
                    } else {
                        z = false;
                    }
                    if (itemViewType == 0) {
                        if (BankRemitSelectPayeeUI.this.pOm == i) {
                            itemViewType = 1;
                        } else {
                            z = false;
                        }
                        if (itemViewType == 0) {
                            textView.setText("");
                            C4990ab.m7421w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", Integer.valueOf(i));
                            break;
                        }
                        textView.setText(C25738R.string.a52);
                        break;
                    }
                    textView.setText(C25738R.string.a54);
                    break;
                case 1:
                    C21640a c21640a2 = (C21640a) view.getTag();
                    TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i);
                    if (transferRecordParcel == null) {
                        c21640a2.pOt.setImageResource(C25738R.color.a3p);
                        c21640a2.pMb.setText("");
                        c21640a2.pOu.setText("");
                        C4990ab.m7420w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
                        break;
                    }
                    c21640a2.pOt.mo38952eb(transferRecordParcel.pLH, C25738R.color.a3p);
                    if (C5046bo.isNullOrNil(transferRecordParcel.pMg)) {
                        c21640a2.pMb.setText(transferRecordParcel.pMf);
                    } else {
                        c21640a2.pMb.setText(C44089j.m79292b(BankRemitSelectPayeeUI.this.mController.ylL, BankRemitSelectPayeeUI.this.mController.ylL.getString(C25738R.string.a51, new Object[]{transferRecordParcel.pMf, transferRecordParcel.pMg})));
                    }
                    c21640a2.pOu.setText(BankRemitSelectPayeeUI.this.getString(C25738R.string.a51, new Object[]{transferRecordParcel.nuL, transferRecordParcel.pMe}));
                    break;
                default:
                    C4990ab.m7421w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", Integer.valueOf(itemViewType));
                    break;
            }
            AppMethodBeat.m2505o(44686);
            return view;
        }

        private boolean cfn() {
            AppMethodBeat.m2504i(44687);
            if (BankRemitSelectPayeeUI.this.pOl >= 0) {
                AppMethodBeat.m2505o(44687);
                return true;
            }
            AppMethodBeat.m2505o(44687);
            return false;
        }

        private boolean cfo() {
            AppMethodBeat.m2504i(44688);
            if (BankRemitSelectPayeeUI.this.pOm >= 0) {
                AppMethodBeat.m2505o(44688);
                return true;
            }
            AppMethodBeat.m2505o(44688);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI$1 */
    class C395991 implements OnItemClickListener {
        C395991() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44671);
            C4990ab.m7411d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", Integer.valueOf(i));
            TransferRecordParcel transferRecordParcel = (TransferRecordParcel) adapterView.getAdapter().getItem(i);
            if (transferRecordParcel != null) {
                BankRemitSelectPayeeUI.this.pOn.putExtra("key_bank_card_seqno", transferRecordParcel.pMd);
                BankRemitSelectPayeeUI.this.setResult(-1, BankRemitSelectPayeeUI.this.pOn);
                BankRemitSelectPayeeUI.this.finish();
            }
            AppMethodBeat.m2505o(44671);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI$3 */
    class C396003 implements OnItemLongClickListener {
        C396003() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44673);
            BankRemitSelectPayeeUI.this.icA.mo75004a(view, i, j, BankRemitSelectPayeeUI.this, BankRemitSelectPayeeUI.this);
            AppMethodBeat.m2505o(44673);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI$9 */
    class C434519 implements C40929a {
        C434519() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44680);
            C4990ab.m7413e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(44680);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44689);
        super.onCreate(bundle);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_self_transfer_record_list");
        ArrayList parcelableArrayListExtra2 = getIntent().getParcelableArrayListExtra("key_freq_transfer_record_list");
        this.pOi = new ArrayList();
        if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty())) {
            this.pOl = 0;
            this.pOi.addAll(parcelableArrayListExtra);
        }
        if (!(parcelableArrayListExtra2 == null || parcelableArrayListExtra2.isEmpty())) {
            this.pOm = (this.pOi.size() + this.pOl) + 1;
            this.pOi.addAll(parcelableArrayListExtra2);
        }
        C4990ab.m7417i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", Integer.valueOf(this.pOl), Integer.valueOf(this.pOm));
        for (TransferRecordParcel transferRecordParcel : this.pOi) {
            C4990ab.m7411d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", transferRecordParcel.pMd, transferRecordParcel.pMe, transferRecordParcel.pLH, transferRecordParcel.nuL, transferRecordParcel.pbn, transferRecordParcel.pMf, transferRecordParcel.pMg);
        }
        this.pOn = new Intent();
        initView();
        setMMTitle((int) C25738R.string.a55);
        mo39992nf(1590);
        mo39992nf(1395);
        AppMethodBeat.m2505o(44689);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44690);
        this.pOg = (ListView) findViewById(2131821693);
        this.icA = new C46696j(this);
        this.pOh = new C34807b(this, (byte) 0);
        this.pOg.setAdapter(this.pOh);
        this.pOg.setOnItemClickListener(new C395991());
        this.pOg.setOnItemLongClickListener(new C396003());
        AppMethodBeat.m2505o(44690);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(44691);
        contextMenu.add(0, 1, 0, C25738R.string.a53);
        contextMenu.add(0, 0, 0, C25738R.string.a50);
        AppMethodBeat.m2505o(44691);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.m2504i(44692);
        int itemId = menuItem.getItemId();
        final TransferRecordParcel transferRecordParcel = (TransferRecordParcel) this.pOg.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (transferRecordParcel == null) {
            C4990ab.m7416i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
            AppMethodBeat.m2505o(44692);
        } else if (itemId == 1) {
            C22657a.m34348a(this, getString(C25738R.string.arr), transferRecordParcel.pMg, "", 32, new C30387b() {
                /* renamed from: s */
                public final boolean mo4760s(CharSequence charSequence) {
                    AppMethodBeat.m2504i(44674);
                    if (!(transferRecordParcel.pMg == null && charSequence == null) && (transferRecordParcel.pMg == null || !transferRecordParcel.pMg.equals(charSequence))) {
                        BankRemitSelectPayeeUI.m86287a(BankRemitSelectPayeeUI.this, transferRecordParcel.pMd, String.valueOf(charSequence));
                        AppMethodBeat.m2505o(44674);
                    } else {
                        C4990ab.m7417i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", transferRecordParcel.pMg, charSequence);
                        AppMethodBeat.m2505o(44674);
                    }
                    return true;
                }
            }, new C216385());
            AppMethodBeat.m2505o(44692);
        } else if (itemId == 0) {
            String str = transferRecordParcel.pMd;
            C4990ab.m7416i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
            mo39970a(new C13021f(str), true, false);
            C7060h.pYm.mo8381e(14673, Integer.valueOf(7));
            AppMethodBeat.m2505o(44692);
        } else {
            C4990ab.m7417i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", Integer.valueOf(itemId));
            AppMethodBeat.m2505o(44692);
        }
    }

    public final int getLayoutId() {
        return 2130968828;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44693);
        super.onDestroy();
        mo39993ng(1590);
        mo39993ng(1395);
        AppMethodBeat.m2505o(44693);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44694);
        if (c1207m instanceof C39585j) {
            final C39585j c39585j = (C39585j) c1207m;
            c39585j.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44679);
                    C4990ab.m7416i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
                    BankRemitSelectPayeeUI.m86289b(BankRemitSelectPayeeUI.this, c39585j.pLt, c39585j.hHV);
                    AppMethodBeat.m2505o(44679);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44678);
                    C4990ab.m7413e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", Integer.valueOf(c39585j.pLB.kCl), c39585j.pLB.kCm);
                    if (!C5046bo.isNullOrNil(c39585j.pLB.kCm)) {
                        Toast.makeText(BankRemitSelectPayeeUI.this, c39585j.pLB.kCm, 1).show();
                    }
                    AppMethodBeat.m2505o(44678);
                }
            }).mo70320c(new C288676());
        } else if (c1207m instanceof C13021f) {
            final C13021f c13021f = (C13021f) c1207m;
            c13021f.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44672);
                    BankRemitSelectPayeeUI.m86286a(BankRemitSelectPayeeUI.this, c13021f.pLt);
                    AppMethodBeat.m2505o(44672);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44681);
                    C4990ab.m7413e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", Integer.valueOf(c13021f.pLx.kCl), c13021f.pLx.kCm);
                    if (!C5046bo.isNullOrNil(c13021f.pLx.kCm)) {
                        Toast.makeText(BankRemitSelectPayeeUI.this, c13021f.pLx.kCm, 1).show();
                    }
                    AppMethodBeat.m2505o(44681);
                }
            }).mo70320c(new C434519());
        }
        AppMethodBeat.m2505o(44694);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m86287a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        AppMethodBeat.m2504i(44695);
        C4990ab.m7417i("MicroMsg.BankRemitSelectPayeeUI", "do modify remark: %s", str2);
        bankRemitSelectPayeeUI.mo39970a(new C39585j(str, str2), true, false);
        AppMethodBeat.m2505o(44695);
    }

    /* renamed from: b */
    static /* synthetic */ void m86289b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        AppMethodBeat.m2504i(44696);
        C4990ab.m7416i("MicroMsg.BankRemitSelectPayeeUI", "do modify record");
        if (bankRemitSelectPayeeUI.pOj == null) {
            bankRemitSelectPayeeUI.pOj = new ArrayList();
        }
        for (int size = bankRemitSelectPayeeUI.pOi.size() - 1; size >= 0; size--) {
            TransferRecordParcel transferRecordParcel = (TransferRecordParcel) bankRemitSelectPayeeUI.pOi.get(size);
            if (transferRecordParcel.pMd.equals(str)) {
                transferRecordParcel.pMg = str2;
                bankRemitSelectPayeeUI.pOj.add(transferRecordParcel);
                break;
            }
        }
        bankRemitSelectPayeeUI.pOh.notifyDataSetChanged();
        bankRemitSelectPayeeUI.pOn.putParcelableArrayListExtra("key_modified_record_list", bankRemitSelectPayeeUI.pOj);
        bankRemitSelectPayeeUI.setResult(0, bankRemitSelectPayeeUI.pOn);
        C7060h.pYm.mo8381e(14673, Integer.valueOf(5));
        AppMethodBeat.m2505o(44696);
    }

    /* renamed from: a */
    static /* synthetic */ void m86286a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str) {
        AppMethodBeat.m2504i(44697);
        C4990ab.m7416i("MicroMsg.BankRemitSelectPayeeUI", "do remove record");
        for (int size = bankRemitSelectPayeeUI.pOi.size() - 1; size >= 0; size--) {
            if (((TransferRecordParcel) bankRemitSelectPayeeUI.pOi.get(size)).pMd.equals(str)) {
                bankRemitSelectPayeeUI.pOi.remove(size);
                break;
            }
        }
        bankRemitSelectPayeeUI.pOh.notifyDataSetChanged();
        if (bankRemitSelectPayeeUI.pOk == null) {
            bankRemitSelectPayeeUI.pOk = new ArrayList();
        }
        bankRemitSelectPayeeUI.pOk.add(str);
        bankRemitSelectPayeeUI.pOn.putStringArrayListExtra("key_delete_seq_no_list", bankRemitSelectPayeeUI.pOk);
        bankRemitSelectPayeeUI.setResult(0, bankRemitSelectPayeeUI.pOn);
        AppMethodBeat.m2505o(44697);
    }
}
