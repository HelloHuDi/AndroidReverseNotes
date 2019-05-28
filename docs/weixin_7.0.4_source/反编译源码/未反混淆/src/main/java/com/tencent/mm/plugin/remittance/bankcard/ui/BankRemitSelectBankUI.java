package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.b;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.wallet_core.c.p.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BankRemitSelectBankUI extends BankRemitBaseUI {
    private BankRemitSortView pOd;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44667);
        super.onCreate(bundle);
        setMMTitle((int) R.string.a4z);
        nf(1399);
        initView();
        ab.i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
        m hVar = new h();
        hVar.o(this);
        a(hVar, true, true);
        AppMethodBeat.o(44667);
    }

    public final void initView() {
        AppMethodBeat.i(44668);
        this.pOd = (BankRemitSortView) findViewById(R.id.a3v);
        this.pOd.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(44663);
                hd hdVar = (hd) ((d) adapterView.getAdapter().getItem(i)).data;
                if (hdVar != null) {
                    BankcardElemParcel bankcardElemParcel = new BankcardElemParcel(hdVar);
                    Intent intent = new Intent();
                    intent.putExtra("key_bank_card_elem_parcel", bankcardElemParcel);
                    BankRemitSelectBankUI.this.setResult(-1, intent);
                    BankRemitSelectBankUI.this.finish();
                    AppMethodBeat.o(44663);
                    return;
                }
                ab.w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", Integer.valueOf(i));
                AppMethodBeat.o(44663);
            }
        });
        AppMethodBeat.o(44668);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44669);
        if (mVar instanceof h) {
            final h hVar = (h) mVar;
            hVar.a(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44666);
                    ArrayList arrayList = new ArrayList();
                    LinkedList<hd> linkedList = hVar.pLz.wmC;
                    LinkedList<hd> linkedList2 = hVar.pLz.wmB;
                    b bVar = new b();
                    if (!(linkedList == null || linkedList.isEmpty())) {
                        ab.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", Integer.valueOf(linkedList2.size()));
                        for (hd hdVar : linkedList) {
                            d dVar = new d();
                            dVar.yDG = "☆";
                            dVar.data = hdVar;
                            arrayList.add(dVar);
                        }
                    }
                    if (!(linkedList2 == null || linkedList2.isEmpty())) {
                        ab.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", Integer.valueOf(linkedList2.size()));
                        Collections.sort(linkedList2, bVar);
                        for (hd hdVar2 : linkedList2) {
                            if (!bo.isNullOrNil(hdVar2.nuL)) {
                                String str2;
                                if (bo.isNullOrNil(hdVar2.vJN)) {
                                    str2 = com.tencent.mm.plugin.remittance.bankcard.model.a.VL(hdVar2.nuL);
                                } else {
                                    ab.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", hdVar2.vJN);
                                    str2 = hdVar2.vJN.toUpperCase().charAt(0);
                                }
                                d dVar2 = new d();
                                dVar2.yDG = str2;
                                dVar2.data = hdVar2;
                                arrayList.add(dVar2);
                            }
                        }
                    }
                    BankRemitSelectBankUI.this.pOd.dJ(arrayList);
                    AppMethodBeat.o(44666);
                }
            }).b(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44665);
                    ab.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", Integer.valueOf(hVar.pLz.kCl), hVar.pLz.kCm);
                    if (!bo.isNullOrNil(hVar.pLz.kCm)) {
                        Toast.makeText(BankRemitSelectBankUI.this, hVar.pLz.kCm, 1).show();
                    }
                    AppMethodBeat.o(44665);
                }
            }).c(new a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44664);
                    ab.e("MicroMsg.BankRemitSelectBankUI", "net error: %s", hVar);
                    AppMethodBeat.o(44664);
                }
            });
        }
        AppMethodBeat.o(44669);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.g1;
    }

    public void onDestroy() {
        AppMethodBeat.i(44670);
        super.onDestroy();
        ng(1399);
        AppMethodBeat.o(44670);
    }
}
