package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.p268aa.p269a.C1954a;
import com.tencent.p177mm.plugin.p268aa.p269a.C9797h;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C37996f;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C37998g;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C37998g.C18776c;
import com.tencent.p177mm.plugin.p268aa.p270ui.C9821a.C9822a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C15369o;
import com.tencent.p177mm.protocal.protobuf.C15389v;
import com.tencent.p177mm.protocal.protobuf.C35955t;
import com.tencent.p177mm.protocal.protobuf.C40499a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import com.tencent.view.C31128d;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI */
public class PaylistAAUI extends BaseAAPresenterActivity {
    private String cJH;
    private String cva;
    private View gnR;
    private Dialog gnn = null;
    private String gpA;
    private long gpB;
    private C37998g gpl = ((C37998g) mo21155V(C37998g.class));
    private C37996f gpm = ((C37996f) mo21156Z(C37996f.class));
    private LinearLayout gpn;
    private LinearLayout gpo;
    private LinearLayout gpp;
    private WalletTextView gpq;
    private Button gpr;
    private TextView gps;
    private TextView gpt;
    private TextView gpu;
    private TextView gpv;
    private String gpw;
    private String gpx;
    private String gpy;
    private int gpz;
    private String title;

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$8 */
    class C19638 implements C9822a {

        /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$8$1 */
        class C19641 implements C5662c {
            C19641() {
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$8$2 */
        class C19652 implements C5662c {
            C19652() {
            }

            /* renamed from: d */
            public final void mo5699d(boolean z, String str) {
                AppMethodBeat.m2504i(40872);
                PaylistAAUI.m29357b(PaylistAAUI.this);
                AppMethodBeat.m2505o(40872);
            }
        }

        C19638() {
        }

        public final void aos() {
            AppMethodBeat.m2504i(40873);
            int i = !C1855t.m3896kH(PaylistAAUI.this.gpx) ? C25738R.string.ezf : C25738R.string.eze;
            C5659a c5659a = new C5659a(PaylistAAUI.this);
            c5659a.mo11514al(PaylistAAUI.this.getString(C25738R.string.ezg));
            View inflate = C5616v.m8409hu(PaylistAAUI.this).inflate(2130970982, null);
            TextView textView = (TextView) inflate.findViewById(2131820674);
            ((ImageView) inflate.findViewById(2131820629)).setImageResource(C25738R.drawable.bee);
            textView.setText(i);
            c5659a.mo11524fo(inflate);
            c5659a.mo11509Qg(C25738R.string.f9221tf);
            c5659a.zQK = PaylistAAUI.this.getString(C25738R.string.f9076or);
            c5659a.zQM = false;
            c5659a.mo11513a(new C19641(), new C19652());
            c5659a.show();
            C7060h.pYm.mo8381e(13721, Integer.valueOf(4), Integer.valueOf(7));
            AppMethodBeat.m2505o(40873);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$9 */
    class C67079 implements C5690a {
        C67079() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(40874);
            C4990ab.m7417i("MicroMsg.PaylistAAUI", "onInterrupt: %s", obj);
            PaylistAAUI.m29354a(PaylistAAUI.this, obj == null ? "" : obj.toString());
            AppMethodBeat.m2505o(40874);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$12 */
    class C981612 implements Runnable {
        C981612() {
        }

        public final void run() {
            AppMethodBeat.m2504i(40877);
            int height = PaylistAAUI.this.getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            View findViewById = PaylistAAUI.this.findViewById(2131826459);
            findViewById.getLocationInWindow(iArr);
            int height2 = iArr[1] + findViewById.getHeight();
            int fromDPToPix = C1338a.fromDPToPix(PaylistAAUI.this.mController.ylL, 20);
            int fromDPToPix2 = ((height - height2) - C1338a.fromDPToPix(PaylistAAUI.this.mController.ylL, 24)) - C1338a.fromDPToPix(PaylistAAUI.this.mController.ylL, 12);
            if (fromDPToPix2 < fromDPToPix) {
                fromDPToPix2 = fromDPToPix;
            }
            C4990ab.m7411d("MicroMsg.PaylistAAUI", "height: %s, h1: %s, topMargin: %s", Integer.valueOf(height), Integer.valueOf(height2), Integer.valueOf(fromDPToPix2));
            LayoutParams layoutParams = (LayoutParams) PaylistAAUI.this.gpv.getLayoutParams();
            layoutParams.topMargin = fromDPToPix2;
            PaylistAAUI.this.gpv.setLayoutParams(layoutParams);
            AppMethodBeat.m2505o(40877);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$14 */
    class C981714 implements OnClickListener {
        C981714() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40882);
            PaylistAAUI.m29351a(PaylistAAUI.this, PaylistAAUI.this.gpB);
            AppMethodBeat.m2505o(40882);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$1 */
    class C98181 implements OnMenuItemClickListener {
        C98181() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40864);
            PaylistAAUI.this.finish();
            AppMethodBeat.m2505o(40864);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$2 */
    class C98192 implements C5681a<Void, C15369o> {
        C98192() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40866);
            final C15369o c15369o = (C15369o) obj;
            if (PaylistAAUI.this.gnn != null) {
                PaylistAAUI.this.gnn.dismiss();
            }
            String str = "MicroMsg.PaylistAAUI";
            String str2 = "aapay return, alertItem: %s, alertItem.flag: %s";
            Object[] objArr = new Object[2];
            objArr[0] = c15369o.vAf;
            objArr[1] = Integer.valueOf(c15369o.vAf != null ? c15369o.vAf.bJt : 0);
            C4990ab.m7417i(str, str2, objArr);
            if (c15369o.vAf == null || c15369o.vAf.bJt != 1) {
                C4990ab.m7411d("MicroMsg.PaylistAAUI", "aapay return, reqKey: %s", c15369o.nYX);
                PaylistAAUI.m29352a(PaylistAAUI.this, c15369o);
            } else {
                String str3 = c15369o.vAf.cEh;
                String str4 = c15369o.vAf.nZb;
                str = c15369o.vAf.nZc;
                C5652a c5652a = new C5652a(PaylistAAUI.this);
                c5652a.asE(str3);
                c5652a.asJ(str).mo11457a(new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(40865);
                        PaylistAAUI.m29352a(PaylistAAUI.this, c15369o);
                        AppMethodBeat.m2505o(40865);
                    }
                });
                c5652a.asK(str4);
                c5652a.aMb().show();
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(40866);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$11 */
    class C1878311 implements C9822a {
        C1878311() {
        }

        public final void aos() {
            AppMethodBeat.m2504i(40876);
            Intent intent = new Intent();
            intent.putExtra("key_scene_balance_manager", 0);
            C25985d.m41467b(PaylistAAUI.this, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
            C7060h.pYm.mo8381e(13721, Integer.valueOf(4), Integer.valueOf(4));
            AppMethodBeat.m2505o(40876);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$3 */
    class C187863 implements C5690a {
        C187863() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(40867);
            C4990ab.m7417i("MicroMsg.PaylistAAUI", "close pay list failed: %s", obj);
            if (PaylistAAUI.this.gnn != null) {
                PaylistAAUI.this.gnn.dismiss();
            }
            if (obj instanceof String) {
                Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
                AppMethodBeat.m2505o(40867);
                return;
            }
            Toast.makeText(PaylistAAUI.this, C25738R.string.ar6, 1).show();
            AppMethodBeat.m2505o(40867);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$4 */
    class C187874 implements C5681a<Void, Boolean> {
        C187874() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40868);
            C4990ab.m7417i("MicroMsg.PaylistAAUI", "close pay list success: %s", (Boolean) obj);
            if (PaylistAAUI.this.gnn != null) {
                PaylistAAUI.this.gnn.dismiss();
            }
            PaylistAAUI.this.gpy = null;
            PaylistAAUI.m29371j(PaylistAAUI.this);
            PaylistAAUI.this.mController.removeAllOptionMenu();
            PaylistAAUI.m29372k(PaylistAAUI.this);
            Void voidR = zXH;
            AppMethodBeat.m2505o(40868);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$5 */
    class C187885 implements C5690a {
        C187885() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(40869);
            if (PaylistAAUI.this.gnn != null) {
                PaylistAAUI.this.gnn.dismiss();
            }
            if (!(obj instanceof String) || obj.toString().equalsIgnoreCase("ok")) {
                Toast.makeText(PaylistAAUI.this, C25738R.string.ezh, 1).show();
            } else {
                Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
            }
            C4990ab.m7412e("MicroMsg.PaylistAAUI", "urgeAAPay fail");
            AppMethodBeat.m2505o(40869);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$6 */
    class C187896 implements C5681a<Void, Boolean> {
        C187896() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40870);
            Boolean bool = (Boolean) obj;
            if (PaylistAAUI.this.gnn != null) {
                PaylistAAUI.this.gnn.dismiss();
            }
            if (bool.booleanValue()) {
                C4990ab.m7416i("MicroMsg.PaylistAAUI", "urgeAAPay success");
                Toast.makeText(PaylistAAUI.this, C25738R.string.ezi, 1).show();
            } else {
                C4990ab.m7416i("MicroMsg.PaylistAAUI", "urgeAAPay fail");
                Toast.makeText(PaylistAAUI.this, C25738R.string.ezh, 1).show();
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(40870);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$10 */
    class C1879010 implements C5681a<Void, C15389v> {
        C1879010() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40875);
            C15389v c15389v = (C15389v) obj;
            if (c15389v == null) {
                C4990ab.m7412e("MicroMsg.PaylistAAUI", "queryDetailRes is null!!!");
                PaylistAAUI.m29354a(PaylistAAUI.this, null);
            } else {
                C4990ab.m7417i("MicroMsg.PaylistAAUI", "get queryDetailRes: %s, billNo: %s, type: %s, state: %s, is_launcher: %s, role: %s, role_state: %s, payer_list.size: %s", c15389v, c15389v.vzL, Integer.valueOf(c15389v.type), Integer.valueOf(c15389v.state), Integer.valueOf(c15389v.vAq), Integer.valueOf(c15389v.vzW), Integer.valueOf(c15389v.vAr), Integer.valueOf(c15389v.vzQ.size()));
                C4990ab.m7417i("MicroMsg.PaylistAAUI", "paid_num: %s, plan_num: %s, activity_amount: %s", Integer.valueOf(c15389v.vAo), Integer.valueOf(c15389v.vAm), Long.valueOf(c15389v.vAy));
                PaylistAAUI.this.gnR.setVisibility(0);
                PaylistAAUI.this.gpy = c15389v.vAk;
                PaylistAAUI.this.gpz = c15389v.vzQ.size() + 1;
                PaylistAAUI.this.title = c15389v.title;
                PaylistAAUI.m29353a(PaylistAAUI.this, c15389v);
                PaylistAAUI.m29358b(PaylistAAUI.this, c15389v);
                PaylistAAUI.m29361c(PaylistAAUI.this, c15389v);
                PaylistAAUI.m29363d(PaylistAAUI.this, c15389v);
                PaylistAAUI.m29366e(PaylistAAUI.this, c15389v);
                if (PaylistAAUI.this.gnn != null) {
                    PaylistAAUI.this.gnn.dismiss();
                    PaylistAAUI.this.gnn = null;
                }
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(40875);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$15 */
    class C1879115 implements C5690a {
        C1879115() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(40884);
            C4990ab.m7417i("MicroMsg.PaylistAAUI", "aapay failed: %s", obj);
            if (PaylistAAUI.this.gnn != null) {
                PaylistAAUI.this.gnn.dismiss();
            }
            if (obj == null) {
                Toast.makeText(PaylistAAUI.this, PaylistAAUI.this.getString(C25738R.string.f8672bm), 1).show();
            } else if (obj instanceof C40499a) {
                final C40499a c40499a = (C40499a) obj;
                String str = c40499a.cEh;
                String str2 = c40499a.nZb;
                String str3 = c40499a.nZc;
                C5652a c5652a = new C5652a(PaylistAAUI.this);
                c5652a.asE(str);
                c5652a.asJ(str3).mo11457a(new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(40883);
                        C36391e.m60016n(PaylistAAUI.this.mController.ylL, c40499a.kCs, false);
                        AppMethodBeat.m2505o(40883);
                    }
                });
                c5652a.asK(str2);
                c5652a.aMb().show();
                AppMethodBeat.m2505o(40884);
                return;
            } else if ((obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
                AppMethodBeat.m2505o(40884);
                return;
            }
            AppMethodBeat.m2505o(40884);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.PaylistAAUI$7 */
    class C187937 implements C5681a<Void, Void> {
        C187937() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40871);
            C4990ab.m7416i("MicroMsg.PaylistAAUI", "insert msg finish");
            Void voidR = zXH;
            AppMethodBeat.m2505o(40871);
            return voidR;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public PaylistAAUI() {
        AppMethodBeat.m2504i(40885);
        AppMethodBeat.m2505o(40885);
    }

    /* renamed from: j */
    static /* synthetic */ void m29371j(PaylistAAUI paylistAAUI) {
        AppMethodBeat.m2504i(40903);
        paylistAAUI.aoL();
        AppMethodBeat.m2505o(40903);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(40886);
        super.onCreate(bundle);
        setBackBtn(new C98181());
        setMMTitle((int) C25738R.string.cm5);
        this.gpx = getIntent().getStringExtra("chatroom");
        this.gpn = (LinearLayout) findViewById(2131826462);
        this.gpo = (LinearLayout) findViewById(2131826465);
        this.gpp = (LinearLayout) findViewById(2131826473);
        this.gps = (TextView) findViewById(2131826463);
        this.gpt = (TextView) findViewById(2131826464);
        this.gnR = findViewById(2131823601);
        this.gpu = (TextView) findViewById(2131826471);
        this.gpu.setClickable(true);
        this.gpu.setOnTouchListener(new C30132m(this));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(C25738R.string.dbq));
        spannableStringBuilder.setSpan(new C9821a(new C19638()), 0, spannableStringBuilder.length(), 18);
        this.gpu.setText(spannableStringBuilder);
        this.gpv = (TextView) findViewById(2131826477);
        aoL();
        AppMethodBeat.m2505o(40886);
    }

    private void aoL() {
        AppMethodBeat.m2504i(40887);
        this.gnn = C30901g.m49318b(this, false, null);
        this.gnR.setVisibility(4);
        this.gpl.gmS.aor().mo15896f(new C1879010()).mo11586a((C5690a) new C67079());
        AppMethodBeat.m2505o(40887);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(40888);
        super.onDestroy();
        AppMethodBeat.m2505o(40888);
    }

    /* renamed from: K */
    private static boolean m29347K(int i, int i2, int i3) {
        return i == C1954a.gld && i2 != C1954a.glh && i3 == C1954a.gkZ;
    }

    /* renamed from: a */
    private void m29355a(List<C35955t> list, String str, boolean z) {
        AppMethodBeat.m2504i(40889);
        ((TextView) findViewById(2131826470)).setText(str);
        this.gpu.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131826472);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z2;
            C35955t c35955t = (C35955t) list.get(i);
            if (i >= list.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            m29350a(linearLayout, c35955t, z2);
        }
        AppMethodBeat.m2505o(40889);
    }

    /* renamed from: d */
    private void m29364d(List<C35955t> list, String str) {
        AppMethodBeat.m2504i(40890);
        ((TextView) findViewById(2131826474)).setText(str);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131826475);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z;
            C35955t c35955t = (C35955t) list.get(i);
            if (i >= list.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            m29350a(linearLayout, c35955t, z);
        }
        AppMethodBeat.m2505o(40890);
    }

    /* renamed from: a */
    private void m29350a(LinearLayout linearLayout, C35955t c35955t, boolean z) {
        AppMethodBeat.m2504i(40891);
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(2130970344, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(2131826456);
        TextView textView = (TextView) linearLayout2.findViewById(2131826457);
        TextView textView2 = (TextView) linearLayout2.findViewById(2131826458);
        View findViewById = linearLayout2.findViewById(2131821128);
        if (z) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        C40460b.m69434b(imageView, c35955t.vAh);
        textView.setText(C44089j.m79293b(this.mController.ylL, this.gpm.mo60765mJ(c35955t.vAh), textView.getTextSize()));
        if (c35955t.vAj == C1954a.glk) {
            textView2.setText(getString(C25738R.string.dbn, new Object[]{Double.valueOf(((double) c35955t.vzU) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(C25738R.color.f12218wj));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
            AppMethodBeat.m2505o(40891);
        } else if (c35955t.vAj == C1954a.glj) {
            textView2.setText(getString(C25738R.string.dbd, new Object[]{Double.valueOf(((double) c35955t.vzU) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(C25738R.color.f12220wl));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
            AppMethodBeat.m2505o(40891);
        } else {
            textView2.setVisibility(8);
            linearLayout.addView(linearLayout2);
            AppMethodBeat.m2505o(40891);
        }
    }

    public final int getLayoutId() {
        return 2130970345;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(40892);
        super.onActivityResult(i, i2, intent);
        Intent intent2;
        String stringExtra;
        if (i == C31128d.MIC_PTU_MEISHI) {
            if (i2 == -1) {
                C4990ab.m7417i("MicroMsg.PaylistAAUI", "pay success, payMsgId: %s", this.cJH);
                RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                if (realnameGuideHelper != null) {
                    C4990ab.m7416i("MicroMsg.PaylistAAUI", "do realname guide");
                    intent2 = new Intent();
                    intent2.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    C25985d.m41467b((Context) this, "wallet_core", ".id_verify.RealnameDialogActivity", intent2);
                }
                C9797h.m17463vF(this.gpx);
                finish();
                C5698f.m8561h(this.cJH, this.gpy, this.gpA).mo15892c(this.gpl.gmU).mo15896f(new C187937());
                C7060h.pYm.mo8378a(407, 12, 1, false);
                stringExtra = intent.getStringExtra("key_trans_id");
                C18776c c18776c = this.gpl.gmV;
                long j = this.gpB;
                C5698f.m8561h(Long.valueOf(j), this.cva, stringExtra).mo15892c(c18776c);
                AppMethodBeat.m2505o(40892);
                return;
            }
        } else if (i == 222 && i2 == -1) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            C4990ab.m7417i("MicroMsg.PaylistAAUI", "select chatroom：%s", stringExtra);
            if (!C5046bo.isNullOrNil(stringExtra)) {
                intent2 = new Intent(this.mController.ylL, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 3);
                intent2.putExtra("chatroom_name", stringExtra);
                startActivity(intent2);
            }
        }
        AppMethodBeat.m2505o(40892);
    }

    /* renamed from: b */
    static /* synthetic */ void m29357b(PaylistAAUI paylistAAUI) {
        AppMethodBeat.m2504i(40893);
        if (paylistAAUI.gnn != null) {
            paylistAAUI.gnn.dismiss();
        }
        paylistAAUI.gnn = C30901g.m49317a((Context) paylistAAUI, false, null);
        C5698f.dMn().mo15892c(paylistAAUI.gpl.gmX).mo15896f(new C187896()).mo11586a((C5690a) new C187885());
        C7060h.pYm.mo8381e(13721, Integer.valueOf(4), Integer.valueOf(8));
        AppMethodBeat.m2505o(40893);
    }

    /* renamed from: e */
    static /* synthetic */ void m29366e(PaylistAAUI paylistAAUI, C15389v c15389v) {
        AppMethodBeat.m2504i(40899);
        if (c15389v.vzW == C1954a.gld && c15389v.vAk.equals(C1853r.m3846Yz())) {
            paylistAAUI.gpv.setVisibility(0);
        } else {
            paylistAAUI.gpv.setVisibility(8);
        }
        if (paylistAAUI.gpv.getVisibility() != 0) {
            C4990ab.m7416i("MicroMsg.PaylistAAUI", "no need to show bottom tv");
            AppMethodBeat.m2505o(40899);
        } else if (C5046bo.isNullOrNil(c15389v.vAw)) {
            C4990ab.m7416i("MicroMsg.PaylistAAUI", "wording is null");
            AppMethodBeat.m2505o(40899);
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c15389v.vAw);
            if (c15389v.vAx == 1) {
                paylistAAUI.gpv.setClickable(true);
                paylistAAUI.gpv.setOnTouchListener(new C30132m(paylistAAUI));
                spannableStringBuilder.setSpan(new C9821a(new C1878311()), 0, spannableStringBuilder.length(), 18);
            }
            paylistAAUI.gpv.setText(spannableStringBuilder);
            paylistAAUI.getWindow().getDecorView().post(new C981612());
            AppMethodBeat.m2505o(40899);
        }
    }

    /* renamed from: h */
    static /* synthetic */ void m29369h(PaylistAAUI paylistAAUI) {
        AppMethodBeat.m2504i(40900);
        if (paylistAAUI.gnn != null) {
            paylistAAUI.gnn.dismiss();
        }
        paylistAAUI.gnn = C30901g.m49317a((Context) paylistAAUI, false, null);
        C5698f.dMn().mo15892c(paylistAAUI.gpl.gmW).mo15896f(new C187874()).mo11586a((C5690a) new C187863());
        C7060h.pYm.mo8381e(13721, Integer.valueOf(4), Integer.valueOf(6));
        AppMethodBeat.m2505o(40900);
    }

    /* renamed from: k */
    static /* synthetic */ void m29372k(PaylistAAUI paylistAAUI) {
        AppMethodBeat.m2504i(40904);
        Intent intent = new Intent();
        intent.putExtra("close_aa", true);
        intent.putExtra("item_position", paylistAAUI.getIntent().getIntExtra("item_position", 0));
        intent.putExtra("item_offset", paylistAAUI.getIntent().getIntExtra("item_offset", 0));
        paylistAAUI.setResult(-1, intent);
        AppMethodBeat.m2505o(40904);
    }
}
