package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14104ac;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14106g;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35399n;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C40057w;
import com.tencent.p177mm.plugin.wallet_core.model.C29634m;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdNewUI;
import com.tencent.p177mm.protocal.protobuf.bae;
import com.tencent.p177mm.protocal.protobuf.bkl;
import com.tencent.p177mm.protocal.protobuf.bkm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.wallet_core.p649c.C44421a.C40926a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI */
public class WalletLqtPlanHomeUI extends WalletLqtBasePresenterUI {
    private ViewGroup kox;
    private LinearLayout tjA;
    private Button tjB;
    private RelativeLayout tjC;
    private LinearLayout tjD;
    private TextView tjE;
    private C40057w tjF = ((C40057w) mo74555V(C40057w.class));
    private C4331a tjG = new C4331a(this, (byte) 0);
    private List<bkm> tjH = new ArrayList();
    private int tjI;
    private int tjJ;
    private ListView tjx;
    private TextView tjy;
    private TextView tjz;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$a */
    class C4331a extends BaseAdapter {
        private C4331a() {
        }

        /* synthetic */ C4331a(WalletLqtPlanHomeUI walletLqtPlanHomeUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(45618);
            bkm Hc = m6686Hc(i);
            AppMethodBeat.m2505o(45618);
            return Hc;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(45615);
            int size = WalletLqtPlanHomeUI.this.tjH.size();
            AppMethodBeat.m2505o(45615);
            return size;
        }

        /* renamed from: Hc */
        private bkm m6686Hc(int i) {
            AppMethodBeat.m2504i(45616);
            bkm bkm = (bkm) WalletLqtPlanHomeUI.this.tjH.get(i);
            AppMethodBeat.m2505o(45616);
            return bkm;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(45617);
            if (view == null) {
                view = LayoutInflater.from(WalletLqtPlanHomeUI.this.mController.ylL).inflate(2130969959, viewGroup, false);
                view.setTag(new C4332b(view));
            }
            bkm Hc = m6686Hc(i);
            C4332b c4332b = (C4332b) view.getTag();
            c4332b.tjR.setPrefix(C44423ae.dOd());
            BigDecimal a = C36391e.m59981a(Hc.cSh, "100", 2, RoundingMode.HALF_UP);
            if (((double) a.intValue()) == a.doubleValue()) {
                c4332b.tjR.setText(a.intValue());
            } else {
                c4332b.tjR.setText(a.toString());
            }
            c4332b.tjT.setText(WalletLqtPlanHomeUI.this.getString(C25738R.string.fj4, new Object[]{Hc.ehf, Hc.nuL, Hc.pck}));
            if (Hc.wNE == null || C5046bo.isNullOrNil(Hc.wNE.xhq)) {
                c4332b.tjU.setVisibility(8);
            } else {
                c4332b.tjU.setText(Hc.wNE.xhq);
                if (C5046bo.isNullOrNil(Hc.wNE.color)) {
                    c4332b.tjU.setTextColor(WalletLqtPlanHomeUI.this.getResources().getColor(C25738R.color.f12208w0));
                } else {
                    c4332b.tjU.setTextColor(Color.parseColor(Hc.wNE.color));
                }
                c4332b.tjU.setVisibility(0);
            }
            if (Hc.wNF != null) {
                c4332b.tjV.setText(Hc.wNF.title);
                c4332b.tjX.setOnClickListener(new C43331(Hc));
            }
            if (Hc.state != 1) {
                c4332b.tjW.setVisibility(0);
                c4332b.tjT.setTextColor(Color.parseColor("#d1d1d1"));
                c4332b.tjR.setTextColor(Color.parseColor("#d1d1d1"));
            } else {
                c4332b.tjW.setVisibility(8);
                c4332b.tjT.setTextColor(WalletLqtPlanHomeUI.this.getResources().getColor(C25738R.color.f11782h4));
                c4332b.tjR.setTextColor(WalletLqtPlanHomeUI.this.getResources().getColor(C25738R.color.f11782h4));
            }
            c4332b.tjS.setOnClickListener(new C43342(Hc));
            AppMethodBeat.m2505o(45617);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$b */
    public class C4332b {
        public View iym;
        public WalletTextView tjR;
        public ImageView tjS;
        public TextView tjT;
        public TextView tjU;
        public TextView tjV;
        public TextView tjW;
        public LinearLayout tjX;

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$b$1 */
        class C43331 implements OnClickListener {
            final /* synthetic */ bkm tjN;

            C43331(bkm bkm) {
                this.tjN = bkm;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(45619);
                C36391e.m60016n(C4332b.this.iym.getContext(), this.tjN.wNF.url, true);
                AppMethodBeat.m2505o(45619);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$b$2 */
        class C43342 implements OnClickListener {
            final /* synthetic */ bkm tjN;

            /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$b$2$1 */
            class C43351 implements DialogInterface.OnClickListener {
                C43351() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }

            C43342(bkm bkm) {
                this.tjN = bkm;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(45620);
                if (this.tjN.wNG != null) {
                    if (!this.tjN.wNG.wFY || C5046bo.isNullOrNil(this.tjN.wNG.wFZ)) {
                        WalletLqtPlanHomeUI.m6679a(WalletLqtPlanHomeUI.this, this.tjN.wNG.wGa, this.tjN);
                    } else {
                        C30379h.m48443a(WalletLqtPlanHomeUI.this.mController.ylL, this.tjN.wNG.wFZ, "", WalletLqtPlanHomeUI.this.getString(C25738R.string.f9151r4), new C43351());
                        AppMethodBeat.m2505o(45620);
                        return;
                    }
                }
                AppMethodBeat.m2505o(45620);
            }
        }

        public C4332b(View view) {
            AppMethodBeat.m2504i(45621);
            this.iym = view;
            this.tjR = (WalletTextView) view.findViewById(2131825339);
            this.tjS = (ImageView) view.findViewById(2131825340);
            this.tjW = (TextView) view.findViewById(2131825341);
            this.tjT = (TextView) view.findViewById(2131825342);
            this.tjU = (TextView) view.findViewById(2131825343);
            this.tjV = (TextView) view.findViewById(2131825345);
            this.tjX = (LinearLayout) view.findViewById(2131825344);
            int fromDPToPix = C1338a.fromDPToPix(WalletLqtPlanHomeUI.this.mController.ylL, 50);
            C5046bo.m7582n(this.tjS, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            AppMethodBeat.m2505o(45621);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$1 */
    class C43391 implements OnClickListener {
        C43391() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45604);
            WalletLqtPlanHomeUI.m6676a(WalletLqtPlanHomeUI.this);
            AppMethodBeat.m2505o(45604);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$2 */
    class C43432 implements OnItemClickListener {
        C43432() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(45605);
            C4990ab.m7417i("MicroMsg.WalletLqtPlanHomeUI", "pos: %s", Integer.valueOf(i));
            adapterView.getAdapter().getItem(i);
            AppMethodBeat.m2505o(45605);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$3 */
    class C43443 implements OnClickListener {
        C43443() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45606);
            WalletLqtPlanHomeUI.m6676a(WalletLqtPlanHomeUI.this);
            AppMethodBeat.m2505o(45606);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletLqtPlanHomeUI() {
        AppMethodBeat.m2504i(45622);
        AppMethodBeat.m2505o(45622);
    }

    /* renamed from: b */
    static /* synthetic */ void m6681b(WalletLqtPlanHomeUI walletLqtPlanHomeUI) {
        AppMethodBeat.m2504i(45632);
        walletLqtPlanHomeUI.m6684mO(false);
        AppMethodBeat.m2505o(45632);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45624);
        this.tjx = (ListView) findViewById(2131825348);
        this.tjy = (TextView) findViewById(2131825351);
        this.tjz = (TextView) findViewById(2131825352);
        this.tjA = (LinearLayout) findViewById(2131825350);
        this.tjB = (Button) findViewById(2131825353);
        this.tjC = (RelativeLayout) findViewById(2131825349);
        this.tjD = (LinearLayout) findViewById(2131825354);
        this.tjE = (TextView) findViewById(2131825355);
        this.tjG = new C4331a(this, (byte) 0);
        this.tjx.setAdapter(this.tjG);
        bGb();
        this.tjB.setOnClickListener(new C43391());
        this.tjx.setOnItemClickListener(new C43432());
        AppMethodBeat.m2505o(45624);
    }

    public final int getLayoutId() {
        return 2130969961;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45625);
        C4990ab.m7417i("MicroMsg.WalletLqtPlanHomeUI", "activity result: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
            case 2:
            case 3:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("encrypt_pwd");
                    int i3 = this.tjI;
                    int i4 = this.tjJ;
                    final Dialog b = C30901g.m49318b(this.mController.ylL, false, null);
                    C5698f.m8561h(Integer.valueOf(i3), Integer.valueOf(i4), stringExtra).mo15892c(this.tjF.tfS).mo15896f(new C5681a<Object, bae>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.m2504i(45614);
                            b.dismiss();
                            WalletLqtPlanHomeUI.m6681b(WalletLqtPlanHomeUI.this);
                            AppMethodBeat.m2505o(45614);
                            return null;
                        }
                    }).mo11586a((C5690a) new C5690a() {
                        /* renamed from: bi */
                        public final void mo9345bi(Object obj) {
                            AppMethodBeat.m2504i(45613);
                            b.dismiss();
                            if (obj instanceof C29634m) {
                                ((C29634m) obj).mo47880y(WalletLqtPlanHomeUI.this.mController.ylL, false);
                            }
                            AppMethodBeat.m2505o(45613);
                        }
                    });
                    break;
                }
                break;
            case 65281:
                if (i2 == -1) {
                    m6684mO(false);
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(45625);
    }

    private void bGb() {
        AppMethodBeat.m2504i(45626);
        this.kox = (ViewGroup) LayoutInflater.from(this).inflate(2130969960, this.tjx, false);
        this.kox.setOnClickListener(new C43443());
        this.tjx.addFooterView(this.kox);
        AppMethodBeat.m2505o(45626);
    }

    /* renamed from: mO */
    private void m6684mO(final boolean z) {
        AppMethodBeat.m2504i(45627);
        C35399n c35399n = new C35399n();
        c35399n.mo70317b(new C14106g());
        c35399n.mo70316a(new C40926a<bkl>() {
            /* renamed from: bX */
            public final /* synthetic */ void mo9356bX(Object obj) {
                AppMethodBeat.m2504i(45611);
                bkl bkl = (bkl) obj;
                C4990ab.m7416i("MicroMsg.WalletLqtPlanHomeUI", "on index response callback");
                if (bkl == null) {
                    C29634m.m47003gi(-1, -1).mo47880y(WalletLqtPlanHomeUI.this.mController.ylL, true);
                    AppMethodBeat.m2505o(45611);
                } else if (bkl.kdT == 0) {
                    WalletLqtPlanHomeUI.m6677a(WalletLqtPlanHomeUI.this, bkl);
                    AppMethodBeat.m2505o(45611);
                } else {
                    C29634m.m47002a(true, bkl.kdT, 0, bkl.kdU).mo47880y(WalletLqtPlanHomeUI.this.mController.ylL, true);
                    AppMethodBeat.m2505o(45611);
                }
            }

            /* renamed from: bY */
            public final /* synthetic */ void mo9357bY(Object obj) {
                AppMethodBeat.m2504i(45612);
                bkl bkl = (bkl) obj;
                C4990ab.m7416i("MicroMsg.WalletLqtPlanHomeUI", "on index cache callback");
                if (bkl != null && z) {
                    WalletLqtPlanHomeUI.m6677a(WalletLqtPlanHomeUI.this, bkl);
                }
                AppMethodBeat.m2505o(45612);
            }
        });
        AppMethodBeat.m2505o(45627);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45623);
        this.yll = true;
        super.onCreate(bundle);
        setMMTitle("");
        mo17446xE(getResources().getColor(C25738R.color.a69));
        dyb();
        initView();
        m6684mO(true);
        AppMethodBeat.m2505o(45623);
    }

    /* renamed from: a */
    static /* synthetic */ void m6676a(WalletLqtPlanHomeUI walletLqtPlanHomeUI) {
        AppMethodBeat.m2504i(45628);
        C4990ab.m7416i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui");
        Intent intent = new Intent(walletLqtPlanHomeUI, WalletLqtPlanAddUI.class);
        intent.putExtra("key_mode", 1);
        walletLqtPlanHomeUI.startActivityForResult(intent, 65281);
        AppMethodBeat.m2505o(45628);
    }

    /* renamed from: c */
    static /* synthetic */ void m6683c(WalletLqtPlanHomeUI walletLqtPlanHomeUI, int i) {
        AppMethodBeat.m2504i(45629);
        C4990ab.m7416i("MicroMsg.WalletLqtPlanHomeUI", "go to check pwd");
        Intent intent = new Intent(walletLqtPlanHomeUI, WalletCheckPwdNewUI.class);
        intent.putExtra("scene", 3);
        intent.putExtra("title", C14104ac.m22282Hb(i));
        walletLqtPlanHomeUI.startActivityForResult(intent, i);
        AppMethodBeat.m2505o(45629);
    }

    /* renamed from: a */
    static /* synthetic */ void m6679a(WalletLqtPlanHomeUI walletLqtPlanHomeUI, final List list, final bkm bkm) {
        AppMethodBeat.m2504i(45633);
        C4990ab.m7417i("MicroMsg.WalletLqtPlanHomeUI", "show operation menu: %s", list);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(45633);
            return;
        }
        C36356d c36356d = new C36356d(walletLqtPlanHomeUI.mController.ylL, 1, false);
        c36356d.rBl = new C36073c() {
            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(45608);
                for (Integer intValue : list) {
                    int intValue2 = intValue.intValue();
                    switch (intValue2) {
                        case 1:
                            c44273l.mo70072hi(intValue2, C25738R.string.fj_);
                            break;
                        case 2:
                            c44273l.mo70068e(intValue2, WalletLqtPlanHomeUI.this.getString(C25738R.string.fja));
                            break;
                        case 3:
                            c44273l.mo70072hi(intValue2, C25738R.string.fj8);
                            break;
                        case 4:
                            c44273l.mo70072hi(intValue2, C25738R.string.fj9);
                            break;
                        default:
                            break;
                    }
                }
                AppMethodBeat.m2505o(45608);
            }
        };
        c36356d.rBm = new C5279d() {

            /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$6$2 */
            class C43372 implements DialogInterface.OnClickListener {
                C43372() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(45610);
                final int itemId = menuItem.getItemId();
                WalletLqtPlanHomeUI.this.tjI = itemId;
                WalletLqtPlanHomeUI.this.tjJ = bkm.vES;
                switch (itemId) {
                    case 1:
                        WalletLqtPlanHomeUI.m6683c(WalletLqtPlanHomeUI.this, itemId);
                        AppMethodBeat.m2505o(45610);
                        return;
                    case 2:
                        C30379h.m48446a(WalletLqtPlanHomeUI.this.mController.ylL, WalletLqtPlanHomeUI.this.getString(C25738R.string.fjj), "", WalletLqtPlanHomeUI.this.getString(C25738R.string.fji), WalletLqtPlanHomeUI.this.getString(C25738R.string.f9076or), true, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(45609);
                                WalletLqtPlanHomeUI.m6683c(WalletLqtPlanHomeUI.this, itemId);
                                AppMethodBeat.m2505o(45609);
                            }
                        }, new C43372(), (int) C25738R.color.f12267y0);
                        AppMethodBeat.m2505o(45610);
                        return;
                    case 3:
                        WalletLqtPlanHomeUI.m6683c(WalletLqtPlanHomeUI.this, itemId);
                        AppMethodBeat.m2505o(45610);
                        return;
                    case 4:
                        WalletLqtPlanHomeUI.m6678a(WalletLqtPlanHomeUI.this, bkm);
                        break;
                }
                AppMethodBeat.m2505o(45610);
            }
        };
        c36356d.cpD();
        AppMethodBeat.m2505o(45633);
    }
}
