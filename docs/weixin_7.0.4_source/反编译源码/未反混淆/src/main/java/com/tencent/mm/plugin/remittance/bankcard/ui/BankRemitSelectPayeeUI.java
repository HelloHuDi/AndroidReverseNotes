package com.tencent.mm.plugin.remittance.bankcard.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.f;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import java.util.ArrayList;
import java.util.List;

public class BankRemitSelectPayeeUI extends BankRemitBaseUI implements d {
    private j icA;
    private ListView pOg;
    private b pOh;
    private List<TransferRecordParcel> pOi;
    private ArrayList<TransferRecordParcel> pOj;
    private ArrayList<String> pOk;
    private int pOl = -1;
    private int pOm = -1;
    private Intent pOn;

    class a {
        TextView pMb;
        CdnImageView pOt;
        TextView pOu;

        private a() {
        }

        /* synthetic */ a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, byte b) {
            this();
        }
    }

    class b extends BaseAdapter {
        private b() {
        }

        /* synthetic */ b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(44682);
            int size = BankRemitSelectPayeeUI.this.pOi.size();
            if (cfn()) {
                size++;
            }
            if (cfo()) {
                size++;
            }
            AppMethodBeat.o(44682);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(44683);
            Object obj;
            if (i == BankRemitSelectPayeeUI.this.pOl || i == BankRemitSelectPayeeUI.this.pOm) {
                AppMethodBeat.o(44683);
                return null;
            } else if (i < BankRemitSelectPayeeUI.this.pOm) {
                obj = BankRemitSelectPayeeUI.this.pOi.get(i - 1);
                AppMethodBeat.o(44683);
                return obj;
            } else if (!cfo() || i <= BankRemitSelectPayeeUI.this.pOm) {
                if (cfn()) {
                    obj = BankRemitSelectPayeeUI.this.pOi.get(i - 1);
                    AppMethodBeat.o(44683);
                    return obj;
                }
                ab.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", Integer.valueOf(i), Integer.valueOf(BankRemitSelectPayeeUI.this.pOl), Integer.valueOf(BankRemitSelectPayeeUI.this.pOm));
                AppMethodBeat.o(44683);
                return null;
            } else if (cfn()) {
                obj = BankRemitSelectPayeeUI.this.pOi.get(i - 2);
                AppMethodBeat.o(44683);
                return obj;
            } else {
                obj = BankRemitSelectPayeeUI.this.pOi.get(i - 1);
                AppMethodBeat.o(44683);
                return obj;
            }
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.i(44684);
            if (i == BankRemitSelectPayeeUI.this.pOl || i == BankRemitSelectPayeeUI.this.pOm) {
                AppMethodBeat.o(44684);
                return false;
            }
            AppMethodBeat.o(44684);
            return true;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(44685);
            if (i == BankRemitSelectPayeeUI.this.pOl || i == BankRemitSelectPayeeUI.this.pOm) {
                AppMethodBeat.o(44685);
                return 0;
            }
            AppMethodBeat.o(44685);
            return 1;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(44686);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                if (itemViewType == 0) {
                    view = LayoutInflater.from(BankRemitSelectPayeeUI.this.mController.ylL).inflate(R.layout.g2, viewGroup, false);
                } else {
                    view = LayoutInflater.from(BankRemitSelectPayeeUI.this.mController.ylL).inflate(R.layout.g3, viewGroup, false);
                    a aVar = new a(BankRemitSelectPayeeUI.this, (byte) 0);
                    aVar.pOt = (CdnImageView) view.findViewById(R.id.a3y);
                    aVar.pMb = (TextView) view.findViewById(R.id.a3z);
                    aVar.pOu = (TextView) view.findViewById(R.id.a40);
                    view.setTag(aVar);
                }
            }
            switch (itemViewType) {
                case 0:
                    boolean z;
                    TextView textView = (TextView) view.findViewById(R.id.a3w);
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
                            ab.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", Integer.valueOf(i));
                            break;
                        }
                        textView.setText(R.string.a52);
                        break;
                    }
                    textView.setText(R.string.a54);
                    break;
                case 1:
                    a aVar2 = (a) view.getTag();
                    TransferRecordParcel transferRecordParcel = (TransferRecordParcel) getItem(i);
                    if (transferRecordParcel == null) {
                        aVar2.pOt.setImageResource(R.color.a3p);
                        aVar2.pMb.setText("");
                        aVar2.pOu.setText("");
                        ab.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
                        break;
                    }
                    aVar2.pOt.eb(transferRecordParcel.pLH, R.color.a3p);
                    if (bo.isNullOrNil(transferRecordParcel.pMg)) {
                        aVar2.pMb.setText(transferRecordParcel.pMf);
                    } else {
                        aVar2.pMb.setText(com.tencent.mm.pluginsdk.ui.e.j.b(BankRemitSelectPayeeUI.this.mController.ylL, BankRemitSelectPayeeUI.this.mController.ylL.getString(R.string.a51, new Object[]{transferRecordParcel.pMf, transferRecordParcel.pMg})));
                    }
                    aVar2.pOu.setText(BankRemitSelectPayeeUI.this.getString(R.string.a51, new Object[]{transferRecordParcel.nuL, transferRecordParcel.pMe}));
                    break;
                default:
                    ab.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", Integer.valueOf(itemViewType));
                    break;
            }
            AppMethodBeat.o(44686);
            return view;
        }

        private boolean cfn() {
            AppMethodBeat.i(44687);
            if (BankRemitSelectPayeeUI.this.pOl >= 0) {
                AppMethodBeat.o(44687);
                return true;
            }
            AppMethodBeat.o(44687);
            return false;
        }

        private boolean cfo() {
            AppMethodBeat.i(44688);
            if (BankRemitSelectPayeeUI.this.pOm >= 0) {
                AppMethodBeat.o(44688);
                return true;
            }
            AppMethodBeat.o(44688);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44689);
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
        ab.i("MicroMsg.BankRemitSelectPayeeUI", "selfHeaderPos: %s, otherHeaderPos: %s", Integer.valueOf(this.pOl), Integer.valueOf(this.pOm));
        for (TransferRecordParcel transferRecordParcel : this.pOi) {
            ab.d("MicroMsg.BankRemitSelectPayeeUI", "seqno: %s, tail: %s, bank_logo: %s, bank_name: %s, bank_type: %s, payee: %s, explain: %s", transferRecordParcel.pMd, transferRecordParcel.pMe, transferRecordParcel.pLH, transferRecordParcel.nuL, transferRecordParcel.pbn, transferRecordParcel.pMf, transferRecordParcel.pMg);
        }
        this.pOn = new Intent();
        initView();
        setMMTitle((int) R.string.a55);
        nf(1590);
        nf(1395);
        AppMethodBeat.o(44689);
    }

    public final void initView() {
        AppMethodBeat.i(44690);
        this.pOg = (ListView) findViewById(R.id.a41);
        this.icA = new j(this);
        this.pOh = new b(this, (byte) 0);
        this.pOg.setAdapter(this.pOh);
        this.pOg.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(44671);
                ab.d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", Integer.valueOf(i));
                TransferRecordParcel transferRecordParcel = (TransferRecordParcel) adapterView.getAdapter().getItem(i);
                if (transferRecordParcel != null) {
                    BankRemitSelectPayeeUI.this.pOn.putExtra("key_bank_card_seqno", transferRecordParcel.pMd);
                    BankRemitSelectPayeeUI.this.setResult(-1, BankRemitSelectPayeeUI.this.pOn);
                    BankRemitSelectPayeeUI.this.finish();
                }
                AppMethodBeat.o(44671);
            }
        });
        this.pOg.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(44673);
                BankRemitSelectPayeeUI.this.icA.a(view, i, j, BankRemitSelectPayeeUI.this, BankRemitSelectPayeeUI.this);
                AppMethodBeat.o(44673);
                return true;
            }
        });
        AppMethodBeat.o(44690);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(44691);
        contextMenu.add(0, 1, 0, R.string.a53);
        contextMenu.add(0, 0, 0, R.string.a50);
        AppMethodBeat.o(44691);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.i(44692);
        int itemId = menuItem.getItemId();
        final TransferRecordParcel transferRecordParcel = (TransferRecordParcel) this.pOg.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (transferRecordParcel == null) {
            ab.i("MicroMsg.BankRemitSelectPayeeUI", "select record is null");
            AppMethodBeat.o(44692);
        } else if (itemId == 1) {
            com.tencent.mm.plugin.wallet_core.ui.view.a.a(this, getString(R.string.arr), transferRecordParcel.pMg, "", 32, new com.tencent.mm.ui.base.h.b() {
                public final boolean s(CharSequence charSequence) {
                    AppMethodBeat.i(44674);
                    if (!(transferRecordParcel.pMg == null && charSequence == null) && (transferRecordParcel.pMg == null || !transferRecordParcel.pMg.equals(charSequence))) {
                        BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, transferRecordParcel.pMd, String.valueOf(charSequence));
                        AppMethodBeat.o(44674);
                    } else {
                        ab.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", transferRecordParcel.pMg, charSequence);
                        AppMethodBeat.o(44674);
                    }
                    return true;
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(44676);
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(44675);
                            BankRemitSelectPayeeUI.this.aqX();
                            AppMethodBeat.o(44675);
                        }
                    }, 500);
                    AppMethodBeat.o(44676);
                }
            });
            AppMethodBeat.o(44692);
        } else if (itemId == 0) {
            String str = transferRecordParcel.pMd;
            ab.i("MicroMsg.BankRemitSelectPayeeUI", "do delete record");
            a(new f(str), true, false);
            h.pYm.e(14673, Integer.valueOf(7));
            AppMethodBeat.o(44692);
        } else {
            ab.i("MicroMsg.BankRemitSelectPayeeUI", "unknown itemId: %s", Integer.valueOf(itemId));
            AppMethodBeat.o(44692);
        }
    }

    public final int getLayoutId() {
        return R.layout.g4;
    }

    public void onDestroy() {
        AppMethodBeat.i(44693);
        super.onDestroy();
        ng(1590);
        ng(1395);
        AppMethodBeat.o(44693);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44694);
        if (mVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.j) {
            final com.tencent.mm.plugin.remittance.bankcard.a.j jVar = (com.tencent.mm.plugin.remittance.bankcard.a.j) mVar;
            jVar.a(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44679);
                    ab.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
                    BankRemitSelectPayeeUI.b(BankRemitSelectPayeeUI.this, jVar.pLt, jVar.hHV);
                    AppMethodBeat.o(44679);
                }
            }).b(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44678);
                    ab.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", Integer.valueOf(jVar.pLB.kCl), jVar.pLB.kCm);
                    if (!bo.isNullOrNil(jVar.pLB.kCm)) {
                        Toast.makeText(BankRemitSelectPayeeUI.this, jVar.pLB.kCm, 1).show();
                    }
                    AppMethodBeat.o(44678);
                }
            }).c(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44677);
                    ab.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", mVar);
                    AppMethodBeat.o(44677);
                }
            });
        } else if (mVar instanceof f) {
            final f fVar = (f) mVar;
            fVar.a(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44672);
                    BankRemitSelectPayeeUI.a(BankRemitSelectPayeeUI.this, fVar.pLt);
                    AppMethodBeat.o(44672);
                }
            }).b(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44681);
                    ab.e("MicroMsg.BankRemitSelectPayeeUI", "reponse error: %s, msg: %s", Integer.valueOf(fVar.pLx.kCl), fVar.pLx.kCm);
                    if (!bo.isNullOrNil(fVar.pLx.kCm)) {
                        Toast.makeText(BankRemitSelectPayeeUI.this, fVar.pLx.kCm, 1).show();
                    }
                    AppMethodBeat.o(44681);
                }
            }).c(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44680);
                    ab.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", mVar);
                    AppMethodBeat.o(44680);
                }
            });
        }
        AppMethodBeat.o(44694);
        return false;
    }

    static /* synthetic */ void a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        AppMethodBeat.i(44695);
        ab.i("MicroMsg.BankRemitSelectPayeeUI", "do modify remark: %s", str2);
        bankRemitSelectPayeeUI.a(new com.tencent.mm.plugin.remittance.bankcard.a.j(str, str2), true, false);
        AppMethodBeat.o(44695);
    }

    static /* synthetic */ void b(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str, String str2) {
        AppMethodBeat.i(44696);
        ab.i("MicroMsg.BankRemitSelectPayeeUI", "do modify record");
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
        h.pYm.e(14673, Integer.valueOf(5));
        AppMethodBeat.o(44696);
    }

    static /* synthetic */ void a(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, String str) {
        AppMethodBeat.i(44697);
        ab.i("MicroMsg.BankRemitSelectPayeeUI", "do remove record");
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
        AppMethodBeat.o(44697);
    }
}
