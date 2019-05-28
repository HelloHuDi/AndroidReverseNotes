package com.tencent.p177mm.plugin.collect.reward.p367ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MMGridView;
import com.tencent.p177mm.plugin.collect.reward.p366a.C33863a.C33864a;
import com.tencent.p177mm.plugin.collect.reward.p366a.C36754f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@C5271a(2)
/* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI */
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
    private C20274a kER;
    private String kES;
    private String kET;
    private String kEa;
    private int kEb;

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI$1 */
    class C202711 implements OnItemClickListener {
        C202711() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(41131);
            QrRewardSelectMoneyUI.m31348a(QrRewardSelectMoneyUI.this, ((Integer) adapterView.getAdapter().getItem(i)).intValue(), 1);
            AppMethodBeat.m2505o(41131);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI$2 */
    class C202722 implements OnClickListener {
        C202722() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41132);
            QrRewardSelectMoneyUI.m31348a(QrRewardSelectMoneyUI.this, 0, 2);
            AppMethodBeat.m2505o(41132);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI$a */
    class C20274a extends BaseAdapter {
        private C20274a() {
        }

        /* synthetic */ C20274a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(41138);
            int size = QrRewardSelectMoneyUI.this.kEJ.size();
            AppMethodBeat.m2505o(41138);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(41139);
            Object obj = QrRewardSelectMoneyUI.this.kEJ.get(i);
            AppMethodBeat.m2505o(41139);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(41140);
            if (view == null) {
                view = LayoutInflater.from(QrRewardSelectMoneyUI.this.mController.ylL).inflate(2130970433, viewGroup, false);
            }
            int intValue = ((Integer) getItem(i)).intValue();
            TextView textView = (TextView) view.findViewById(2131826765);
            if (((double) intValue) / 100.0d > ((double) (intValue / 100))) {
                textView.setText(String.format("%.2f", new Object[]{Double.valueOf(r4)}) + QrRewardSelectMoneyUI.this.getString(C25738R.string.dg9));
            } else {
                textView.setText(String.format("%d", new Object[]{Integer.valueOf(r2)}) + QrRewardSelectMoneyUI.this.getString(C25738R.string.dg9));
            }
            AppMethodBeat.m2505o(41140);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public QrRewardSelectMoneyUI() {
        AppMethodBeat.m2504i(41141);
        AppMethodBeat.m2505o(41141);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41142);
        super.onCreate(bundle);
        mo39992nf(1516);
        setMMTitle((int) C25738R.string.dfr);
        mo9439AM(4);
        this.kES = getIntent().getStringExtra("key_qrcode_url");
        this.cIb = getIntent().getIntExtra("key_channel", 0);
        this.hAh = getIntent().getStringExtra("key_web_url");
        C4990ab.m7416i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
        mo39970a(new C36754f(this.kES, this.cIb, this.hAh), true, true);
        initView();
        int intExtra = getIntent().getIntExtra("key_scene", 0);
        C4990ab.m7411d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", Integer.valueOf(intExtra));
        C7060h.pYm.mo8381e(14721, Integer.valueOf(2), Integer.valueOf(intExtra));
        AppMethodBeat.m2505o(41142);
    }

    public boolean convertActivityFromTranslucent() {
        return false;
    }

    public final void initView() {
        AppMethodBeat.m2504i(41143);
        this.kEK = (ImageView) findViewById(2131826766);
        this.kEL = (TextView) findViewById(2131826772);
        this.kEM = (TextView) findViewById(2131826767);
        this.kEN = (TextView) findViewById(2131826768);
        this.kEO = (TextView) findViewById(2131826769);
        this.kEP = (MMGridView) findViewById(2131826770);
        this.kEQ = (TextView) findViewById(2131826771);
        this.kER = new C20274a(this, (byte) 0);
        this.kEP.setAdapter(this.kER);
        this.kEP.setOnItemClickListener(new C202711());
        this.kEQ.setOnClickListener(new C202722());
        AppMethodBeat.m2505o(41143);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41144);
        if (c1207m instanceof C36754f) {
            final C36754f c36754f = (C36754f) c1207m;
            c36754f.mo54407a(new C33864a() {
                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    AppMethodBeat.m2504i(41136);
                    C4990ab.m7410d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
                    QrRewardSelectMoneyUI.this.kDW = c36754f.kDz.vWJ;
                    QrRewardSelectMoneyUI.this.kDX = c36754f.kDz.pPw;
                    QrRewardSelectMoneyUI.this.kEb = c36754f.kDz.vWv;
                    QrRewardSelectMoneyUI.this.kDU = c36754f.kDz.vWG;
                    QrRewardSelectMoneyUI.this.kDS = c36754f.kDz.desc;
                    QrRewardSelectMoneyUI.this.kDZ = c36754f.kDz.vWO;
                    QrRewardSelectMoneyUI.this.kEa = c36754f.kDz.vWP;
                    QrRewardSelectMoneyUI.this.kDY = c36754f.kDz.vWM;
                    QrRewardSelectMoneyUI.this.kET = c36754f.kDz.vWS;
                    QrRewardSelectMoneyUI.this.kEJ = c36754f.kDz.vWt;
                    if (QrRewardSelectMoneyUI.this.kEJ == null) {
                        C4990ab.m7416i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
                        QrRewardSelectMoneyUI.this.kEJ = new LinkedList();
                    }
                    QrRewardSelectMoneyUI.m31350b(QrRewardSelectMoneyUI.this);
                    AppMethodBeat.m2505o(41136);
                }
            }).mo54408b(new C33864a() {
                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    AppMethodBeat.m2504i(41135);
                    C4990ab.m7412e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
                    if (!C5046bo.isNullOrNil(c36754f.kDz.kCm)) {
                        Toast.makeText(QrRewardSelectMoneyUI.this, c36754f.kDz.kCm, 1).show();
                    }
                    QrRewardSelectMoneyUI.this.finish();
                    AppMethodBeat.m2505o(41135);
                }
            }).mo54410c(new C33864a() {

                /* renamed from: com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI$3$1 */
                class C202761 implements DialogInterface.OnClickListener {
                    C202761() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(41133);
                        QrRewardSelectMoneyUI.this.finish();
                        AppMethodBeat.m2505o(41133);
                    }
                }

                /* renamed from: j */
                public final void mo6956j(C1207m c1207m) {
                    AppMethodBeat.m2504i(41134);
                    C4990ab.m7413e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", c36754f);
                    C30379h.m48448a(QrRewardSelectMoneyUI.this.mController.ylL, QrRewardSelectMoneyUI.this.getString(C25738R.string.fu2), null, false, new C202761());
                    AppMethodBeat.m2505o(41134);
                }
            });
            mo9439AM(0);
        }
        AppMethodBeat.m2505o(41144);
        return true;
    }

    public final int getLayoutId() {
        return 2130970434;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41145);
        super.onDestroy();
        mo39993ng(1516);
        AppMethodBeat.m2505o(41145);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41146);
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            C4990ab.m7416i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
            finish();
            AppMethodBeat.m2505o(41146);
            return;
        }
        AppMethodBeat.m2505o(41146);
    }

    /* renamed from: a */
    static /* synthetic */ void m31348a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, int i, int i2) {
        AppMethodBeat.m2504i(41147);
        C4990ab.m7416i("MicroMsg.QrRewardSelectMoneyUI", "go to grant ui");
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
        AppMethodBeat.m2505o(41147);
    }

    /* renamed from: b */
    static /* synthetic */ void m31350b(QrRewardSelectMoneyUI qrRewardSelectMoneyUI) {
        AppMethodBeat.m2504i(41148);
        String str = qrRewardSelectMoneyUI.kDW;
        C1720g.m3537RQ();
        C7616ad aoN = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(str);
        if (aoN == null || ((int) aoN.ewQ) <= 0) {
            C4990ab.m7410d("MicroMsg.QrRewardSelectMoneyUI", "Receiver in contactStg and try to get contact");
            final long anU = C5046bo.anU();
            C26417a.flu.mo20966a(str, "", new C9636a() {
                /* renamed from: o */
                public final void mo6218o(String str, boolean z) {
                    AppMethodBeat.m2504i(41137);
                    if (z) {
                        C4990ab.m7418v("MicroMsg.QrRewardSelectMoneyUI", "getContact suc; cost=" + (C5046bo.anU() - anU) + " ms");
                        C41730b.m73489U(str, 3);
                        C17884o.acv().mo67495pZ(str);
                    } else {
                        C4990ab.m7420w("MicroMsg.QrRewardSelectMoneyUI", "getContact failed");
                    }
                    C40460b.m69433a(QrRewardSelectMoneyUI.this.kEK, str, 0.03f, false);
                    QrRewardSelectMoneyUI.this.kEM.setText(C44089j.m79292b(QrRewardSelectMoneyUI.this.mController.ylL, C36391e.m60015mJ(str)));
                    AppMethodBeat.m2505o(41137);
                }
            });
        } else {
            C40460b.m69433a(qrRewardSelectMoneyUI.kEK, str, 0.03f, false);
            qrRewardSelectMoneyUI.kEM.setText(C44089j.m79292b(qrRewardSelectMoneyUI.mController.ylL, C36391e.m60015mJ(str)));
        }
        if (!C5046bo.isNullOrNil(qrRewardSelectMoneyUI.kDS)) {
            qrRewardSelectMoneyUI.kEN.setText(C44089j.m79293b((Context) qrRewardSelectMoneyUI, qrRewardSelectMoneyUI.getString(C25738R.string.dg8, new Object[]{qrRewardSelectMoneyUI.kDS}), qrRewardSelectMoneyUI.kEN.getTextSize()));
        }
        if (C5046bo.isNullOrNil(qrRewardSelectMoneyUI.kET)) {
            qrRewardSelectMoneyUI.kEL.setVisibility(8);
        } else {
            qrRewardSelectMoneyUI.kEL.setText(qrRewardSelectMoneyUI.kET);
        }
        qrRewardSelectMoneyUI.kER.notifyDataSetChanged();
        AppMethodBeat.m2505o(41148);
    }
}
