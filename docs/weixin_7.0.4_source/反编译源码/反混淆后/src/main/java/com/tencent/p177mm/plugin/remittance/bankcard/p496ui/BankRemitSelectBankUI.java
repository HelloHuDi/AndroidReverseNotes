package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.sortview.C36087d;
import com.tencent.p177mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.p177mm.plugin.remittance.bankcard.model.C21625a;
import com.tencent.p177mm.plugin.remittance.bankcard.model.C28859b;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C34804h;
import com.tencent.p177mm.protocal.protobuf.C23396hd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI */
public class BankRemitSelectBankUI extends BankRemitBaseUI {
    private BankRemitSortView pOd;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI$1 */
    class C395951 implements OnItemClickListener {
        C395951() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44663);
            C23396hd c23396hd = (C23396hd) ((C36087d) adapterView.getAdapter().getItem(i)).data;
            if (c23396hd != null) {
                BankcardElemParcel bankcardElemParcel = new BankcardElemParcel(c23396hd);
                Intent intent = new Intent();
                intent.putExtra("key_bank_card_elem_parcel", bankcardElemParcel);
                BankRemitSelectBankUI.this.setResult(-1, intent);
                BankRemitSelectBankUI.this.finish();
                AppMethodBeat.m2505o(44663);
                return;
            }
            C4990ab.m7421w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", Integer.valueOf(i));
            AppMethodBeat.m2505o(44663);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44667);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.a4z);
        mo39992nf(1399);
        initView();
        C4990ab.m7416i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
        C1207m c34804h = new C34804h();
        c34804h.mo70321o(this);
        mo39970a(c34804h, true, true);
        AppMethodBeat.m2505o(44667);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44668);
        this.pOd = (BankRemitSortView) findViewById(2131821687);
        this.pOd.setOnItemClickListener(new C395951());
        AppMethodBeat.m2505o(44668);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44669);
        if (c1207m instanceof C34804h) {
            final C34804h c34804h = (C34804h) c1207m;
            c34804h.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44666);
                    ArrayList arrayList = new ArrayList();
                    LinkedList<C23396hd> linkedList = c34804h.pLz.wmC;
                    LinkedList<C23396hd> linkedList2 = c34804h.pLz.wmB;
                    C28859b c28859b = new C28859b();
                    if (!(linkedList == null || linkedList.isEmpty())) {
                        C4990ab.m7417i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", Integer.valueOf(linkedList2.size()));
                        for (C23396hd c23396hd : linkedList) {
                            C36087d c36087d = new C36087d();
                            c36087d.yDG = "☆";
                            c36087d.data = c23396hd;
                            arrayList.add(c36087d);
                        }
                    }
                    if (!(linkedList2 == null || linkedList2.isEmpty())) {
                        C4990ab.m7417i("MicroMsg.BankRemitSelectBankUI", "card count: %s", Integer.valueOf(linkedList2.size()));
                        Collections.sort(linkedList2, c28859b);
                        for (C23396hd c23396hd2 : linkedList2) {
                            if (!C5046bo.isNullOrNil(c23396hd2.nuL)) {
                                String str2;
                                if (C5046bo.isNullOrNil(c23396hd2.vJN)) {
                                    str2 = C21625a.m33129VL(c23396hd2.nuL);
                                } else {
                                    C4990ab.m7417i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", c23396hd2.vJN);
                                    str2 = c23396hd2.vJN.toUpperCase().charAt(0);
                                }
                                C36087d c36087d2 = new C36087d();
                                c36087d2.yDG = str2;
                                c36087d2.data = c23396hd2;
                                arrayList.add(c36087d2);
                            }
                        }
                    }
                    BankRemitSelectBankUI.this.pOd.mo70141dJ(arrayList);
                    AppMethodBeat.m2505o(44666);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44665);
                    C4990ab.m7413e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", Integer.valueOf(c34804h.pLz.kCl), c34804h.pLz.kCm);
                    if (!C5046bo.isNullOrNil(c34804h.pLz.kCm)) {
                        Toast.makeText(BankRemitSelectBankUI.this, c34804h.pLz.kCm, 1).show();
                    }
                    AppMethodBeat.m2505o(44665);
                }
            }).mo70320c(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44664);
                    C4990ab.m7413e("MicroMsg.BankRemitSelectBankUI", "net error: %s", c34804h);
                    AppMethodBeat.m2505o(44664);
                }
            });
        }
        AppMethodBeat.m2505o(44669);
        return false;
    }

    public final int getLayoutId() {
        return 2130968825;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44670);
        super.onDestroy();
        mo39993ng(1399);
        AppMethodBeat.m2505o(44670);
    }
}
