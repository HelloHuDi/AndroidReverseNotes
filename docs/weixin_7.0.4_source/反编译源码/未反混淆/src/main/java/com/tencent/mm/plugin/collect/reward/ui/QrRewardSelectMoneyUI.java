package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(2)
public class QrRewardSelectMoneyUI extends QrRewardBaseUI {
    private int cIb;
    private String hAh;
    private String kDS;
    private String kDU;
    private String kDW;
    private String kDX;
    private String kDY;
    private String kDZ;
    private List<Integer> kEJ = new ArrayList();
    private ImageView kEK;
    private TextView kEL;
    private TextView kEM;
    private TextView kEN;
    private TextView kEO;
    private MMGridView kEP;
    private TextView kEQ;
    private a kER;
    private String kES;
    private String kET;
    private String kEa;
    private int kEb;

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(41138);
            int size = QrRewardSelectMoneyUI.this.kEJ.size();
            AppMethodBeat.o(41138);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(41139);
            Object obj = QrRewardSelectMoneyUI.this.kEJ.get(i);
            AppMethodBeat.o(41139);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(41140);
            if (view == null) {
                view = LayoutInflater.from(QrRewardSelectMoneyUI.this.mController.ylL).inflate(R.layout.amc, viewGroup, false);
            }
            int intValue = ((Integer) getItem(i)).intValue();
            TextView textView = (TextView) view.findViewById(R.id.dt6);
            if (((double) intValue) / 100.0d > ((double) (intValue / 100))) {
                textView.setText(String.format("%.2f", new Object[]{Double.valueOf(r4)}) + QrRewardSelectMoneyUI.this.getString(R.string.dg9));
            } else {
                textView.setText(String.format("%d", new Object[]{Integer.valueOf(r2)}) + QrRewardSelectMoneyUI.this.getString(R.string.dg9));
            }
            AppMethodBeat.o(41140);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public QrRewardSelectMoneyUI() {
        AppMethodBeat.i(41141);
        AppMethodBeat.o(41141);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41142);
        super.onCreate(bundle);
        nf(1516);
        setMMTitle((int) R.string.dfr);
        AM(4);
        this.kES = getIntent().getStringExtra("key_qrcode_url");
        this.cIb = getIntent().getIntExtra("key_channel", 0);
        this.hAh = getIntent().getStringExtra("key_web_url");
        ab.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
        a(new f(this.kES, this.cIb, this.hAh), true, true);
        initView();
        int intExtra = getIntent().getIntExtra("key_scene", 0);
        ab.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", Integer.valueOf(intExtra));
        h.pYm.e(14721, Integer.valueOf(2), Integer.valueOf(intExtra));
        AppMethodBeat.o(41142);
    }

    public boolean convertActivityFromTranslucent() {
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(41143);
        this.kEK = (ImageView) findViewById(R.id.dt7);
        this.kEL = (TextView) findViewById(R.id.dtc);
        this.kEM = (TextView) findViewById(R.id.dt8);
        this.kEN = (TextView) findViewById(R.id.dt9);
        this.kEO = (TextView) findViewById(R.id.dt_);
        this.kEP = (MMGridView) findViewById(R.id.dta);
        this.kEQ = (TextView) findViewById(R.id.dtb);
        this.kER = new a(this, (byte) 0);
        this.kEP.setAdapter(this.kER);
        this.kEP.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(41131);
                QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, ((Integer) adapterView.getAdapter().getItem(i)).intValue(), 1);
                AppMethodBeat.o(41131);
            }
        });
        this.kEQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41132);
                QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, 0, 2);
                AppMethodBeat.o(41132);
            }
        });
        AppMethodBeat.o(41143);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41144);
        if (mVar instanceof f) {
            final f fVar = (f) mVar;
            fVar.a(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41136);
                    ab.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
                    QrRewardSelectMoneyUI.this.kDW = fVar.kDz.vWJ;
                    QrRewardSelectMoneyUI.this.kDX = fVar.kDz.pPw;
                    QrRewardSelectMoneyUI.this.kEb = fVar.kDz.vWv;
                    QrRewardSelectMoneyUI.this.kDU = fVar.kDz.vWG;
                    QrRewardSelectMoneyUI.this.kDS = fVar.kDz.desc;
                    QrRewardSelectMoneyUI.this.kDZ = fVar.kDz.vWO;
                    QrRewardSelectMoneyUI.this.kEa = fVar.kDz.vWP;
                    QrRewardSelectMoneyUI.this.kDY = fVar.kDz.vWM;
                    QrRewardSelectMoneyUI.this.kET = fVar.kDz.vWS;
                    QrRewardSelectMoneyUI.this.kEJ = fVar.kDz.vWt;
                    if (QrRewardSelectMoneyUI.this.kEJ == null) {
                        ab.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
                        QrRewardSelectMoneyUI.this.kEJ = new LinkedList();
                    }
                    QrRewardSelectMoneyUI.b(QrRewardSelectMoneyUI.this);
                    AppMethodBeat.o(41136);
                }
            }).b(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41135);
                    ab.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
                    if (!bo.isNullOrNil(fVar.kDz.kCm)) {
                        Toast.makeText(QrRewardSelectMoneyUI.this, fVar.kDz.kCm, 1).show();
                    }
                    QrRewardSelectMoneyUI.this.finish();
                    AppMethodBeat.o(41135);
                }
            }).c(new com.tencent.mm.plugin.collect.reward.a.a.a() {
                public final void j(m mVar) {
                    AppMethodBeat.i(41134);
                    ab.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", fVar);
                    com.tencent.mm.ui.base.h.a(QrRewardSelectMoneyUI.this.mController.ylL, QrRewardSelectMoneyUI.this.getString(R.string.fu2), null, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(41133);
                            QrRewardSelectMoneyUI.this.finish();
                            AppMethodBeat.o(41133);
                        }
                    });
                    AppMethodBeat.o(41134);
                }
            });
            AM(0);
        }
        AppMethodBeat.o(41144);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.amd;
    }

    public void onDestroy() {
        AppMethodBeat.i(41145);
        super.onDestroy();
        ng(1516);
        AppMethodBeat.o(41145);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41146);
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            ab.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
            finish();
            AppMethodBeat.o(41146);
            return;
        }
        AppMethodBeat.o(41146);
    }

    static /* synthetic */ void a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, int i, int i2) {
        AppMethodBeat.i(41147);
        ab.i("MicroMsg.QrRewardSelectMoneyUI", "go to grant ui");
        Intent intent = new Intent(qrRewardSelectMoneyUI.mController.ylL, QrRewardGrantUI.class);
        intent.putExtra("key_amt_type", i2);
        if (i2 == 1) {
            intent.putExtra("key_money_amt", i);
        }
        intent.putExtra("key_rcvr_name", qrRewardSelectMoneyUI.kDW);
        intent.putExtra("key_rcvr_true_name", qrRewardSelectMoneyUI.kDX);
        intent.putExtra("key_rcvr_open_id", qrRewardSelectMoneyUI.kDU);
        intent.putExtra("key_qrcode_desc", qrRewardSelectMoneyUI.kDS);
        intent.putExtra("key_channel", qrRewardSelectMoneyUI.cIb);
        intent.putExtra("key_web_url", qrRewardSelectMoneyUI.hAh);
        intent.putExtra("key_scan_id", qrRewardSelectMoneyUI.kDY);
        intent.putExtra("key_sxtend_1", qrRewardSelectMoneyUI.kDZ);
        intent.putExtra("key_sxtend_2", qrRewardSelectMoneyUI.kEa);
        intent.putExtra("key_max_amt", qrRewardSelectMoneyUI.kEb);
        qrRewardSelectMoneyUI.startActivityForResult(intent, 1);
        AppMethodBeat.o(41147);
    }

    static /* synthetic */ void b(QrRewardSelectMoneyUI qrRewardSelectMoneyUI) {
        AppMethodBeat.i(41148);
        String str = qrRewardSelectMoneyUI.kDW;
        g.RQ();
        ad aoN = ((j) g.K(j.class)).XM().aoN(str);
        if (aoN == null || ((int) aoN.ewQ) <= 0) {
            ab.d("MicroMsg.QrRewardSelectMoneyUI", "Receiver in contactStg and try to get contact");
            final long anU = bo.anU();
            com.tencent.mm.model.ao.a.flu.a(str, "", new com.tencent.mm.model.ao.b.a() {
                public final void o(String str, boolean z) {
                    AppMethodBeat.i(41137);
                    if (z) {
                        ab.v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (bo.anU() - anU) + " ms");
                        b.U(str, 3);
                        o.acv().pZ(str);
                    } else {
                        ab.w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
                    }
                    com.tencent.mm.pluginsdk.ui.a.b.a(QrRewardSelectMoneyUI.this.kEK, str, 0.03f, false);
                    QrRewardSelectMoneyUI.this.kEM.setText(com.tencent.mm.pluginsdk.ui.e.j.b(QrRewardSelectMoneyUI.this.mController.ylL, e.mJ(str)));
                    AppMethodBeat.o(41137);
                }
            });
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(qrRewardSelectMoneyUI.kEK, str, 0.03f, false);
            qrRewardSelectMoneyUI.kEM.setText(com.tencent.mm.pluginsdk.ui.e.j.b(qrRewardSelectMoneyUI.mController.ylL, e.mJ(str)));
        }
        if (!bo.isNullOrNil(qrRewardSelectMoneyUI.kDS)) {
            qrRewardSelectMoneyUI.kEN.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) qrRewardSelectMoneyUI, qrRewardSelectMoneyUI.getString(R.string.dg8, new Object[]{qrRewardSelectMoneyUI.kDS}), qrRewardSelectMoneyUI.kEN.getTextSize()));
        }
        if (bo.isNullOrNil(qrRewardSelectMoneyUI.kET)) {
            qrRewardSelectMoneyUI.kEL.setVisibility(8);
        } else {
            qrRewardSelectMoneyUI.kEL.setText(qrRewardSelectMoneyUI.kET);
        }
        qrRewardSelectMoneyUI.kER.notifyDataSetChanged();
        AppMethodBeat.o(41148);
    }
}
