package com.tencent.mm.plugin.wallet.balance.ui.lqt;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.balance.a.a.ac;
import com.tencent.mm.plugin.wallet.balance.a.a.n;
import com.tencent.mm.plugin.wallet.balance.a.a.w;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bkm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.g;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class WalletLqtPlanHomeUI extends WalletLqtBasePresenterUI {
    private ViewGroup kox;
    private LinearLayout tjA;
    private Button tjB;
    private RelativeLayout tjC;
    private LinearLayout tjD;
    private TextView tjE;
    private w tjF = ((w) V(w.class));
    private a tjG = new a(this, (byte) 0);
    private List<bkm> tjH = new ArrayList();
    private int tjI;
    private int tjJ;
    private ListView tjx;
    private TextView tjy;
    private TextView tjz;

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(WalletLqtPlanHomeUI walletLqtPlanHomeUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(45618);
            bkm Hc = Hc(i);
            AppMethodBeat.o(45618);
            return Hc;
        }

        public final int getCount() {
            AppMethodBeat.i(45615);
            int size = WalletLqtPlanHomeUI.this.tjH.size();
            AppMethodBeat.o(45615);
            return size;
        }

        private bkm Hc(int i) {
            AppMethodBeat.i(45616);
            bkm bkm = (bkm) WalletLqtPlanHomeUI.this.tjH.get(i);
            AppMethodBeat.o(45616);
            return bkm;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(45617);
            if (view == null) {
                view = LayoutInflater.from(WalletLqtPlanHomeUI.this.mController.ylL).inflate(R.layout.a_k, viewGroup, false);
                view.setTag(new b(view));
            }
            bkm Hc = Hc(i);
            b bVar = (b) view.getTag();
            bVar.tjR.setPrefix(ae.dOd());
            BigDecimal a = e.a(Hc.cSh, "100", 2, RoundingMode.HALF_UP);
            if (((double) a.intValue()) == a.doubleValue()) {
                bVar.tjR.setText(a.intValue());
            } else {
                bVar.tjR.setText(a.toString());
            }
            bVar.tjT.setText(WalletLqtPlanHomeUI.this.getString(R.string.fj4, new Object[]{Hc.ehf, Hc.nuL, Hc.pck}));
            if (Hc.wNE == null || bo.isNullOrNil(Hc.wNE.xhq)) {
                bVar.tjU.setVisibility(8);
            } else {
                bVar.tjU.setText(Hc.wNE.xhq);
                if (bo.isNullOrNil(Hc.wNE.color)) {
                    bVar.tjU.setTextColor(WalletLqtPlanHomeUI.this.getResources().getColor(R.color.w0));
                } else {
                    bVar.tjU.setTextColor(Color.parseColor(Hc.wNE.color));
                }
                bVar.tjU.setVisibility(0);
            }
            if (Hc.wNF != null) {
                bVar.tjV.setText(Hc.wNF.title);
                bVar.tjX.setOnClickListener(new AnonymousClass1(Hc));
            }
            if (Hc.state != 1) {
                bVar.tjW.setVisibility(0);
                bVar.tjT.setTextColor(Color.parseColor("#d1d1d1"));
                bVar.tjR.setTextColor(Color.parseColor("#d1d1d1"));
            } else {
                bVar.tjW.setVisibility(8);
                bVar.tjT.setTextColor(WalletLqtPlanHomeUI.this.getResources().getColor(R.color.h4));
                bVar.tjR.setTextColor(WalletLqtPlanHomeUI.this.getResources().getColor(R.color.h4));
            }
            bVar.tjS.setOnClickListener(new AnonymousClass2(Hc));
            AppMethodBeat.o(45617);
            return view;
        }
    }

    public class b {
        public View iym;
        public WalletTextView tjR;
        public ImageView tjS;
        public TextView tjT;
        public TextView tjU;
        public TextView tjV;
        public TextView tjW;
        public LinearLayout tjX;

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$b$1 */
        class AnonymousClass1 implements OnClickListener {
            final /* synthetic */ bkm tjN;

            AnonymousClass1(bkm bkm) {
                this.tjN = bkm;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(45619);
                e.n(b.this.iym.getContext(), this.tjN.wNF.url, true);
                AppMethodBeat.o(45619);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI$b$2 */
        class AnonymousClass2 implements OnClickListener {
            final /* synthetic */ bkm tjN;

            AnonymousClass2(bkm bkm) {
                this.tjN = bkm;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(45620);
                if (this.tjN.wNG != null) {
                    if (!this.tjN.wNG.wFY || bo.isNullOrNil(this.tjN.wNG.wFZ)) {
                        WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this, this.tjN.wNG.wGa, this.tjN);
                    } else {
                        h.a(WalletLqtPlanHomeUI.this.mController.ylL, this.tjN.wNG.wFZ, "", WalletLqtPlanHomeUI.this.getString(R.string.r4), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(45620);
                        return;
                    }
                }
                AppMethodBeat.o(45620);
            }
        }

        public b(View view) {
            AppMethodBeat.i(45621);
            this.iym = view;
            this.tjR = (WalletTextView) view.findViewById(R.id.crm);
            this.tjS = (ImageView) view.findViewById(R.id.crn);
            this.tjW = (TextView) view.findViewById(R.id.cro);
            this.tjT = (TextView) view.findViewById(R.id.crp);
            this.tjU = (TextView) view.findViewById(R.id.crq);
            this.tjV = (TextView) view.findViewById(R.id.crs);
            this.tjX = (LinearLayout) view.findViewById(R.id.crr);
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(WalletLqtPlanHomeUI.this.mController.ylL, 50);
            bo.n(this.tjS, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            AppMethodBeat.o(45621);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLqtPlanHomeUI() {
        AppMethodBeat.i(45622);
        AppMethodBeat.o(45622);
    }

    static /* synthetic */ void b(WalletLqtPlanHomeUI walletLqtPlanHomeUI) {
        AppMethodBeat.i(45632);
        walletLqtPlanHomeUI.mO(false);
        AppMethodBeat.o(45632);
    }

    public final void initView() {
        AppMethodBeat.i(45624);
        this.tjx = (ListView) findViewById(R.id.crv);
        this.tjy = (TextView) findViewById(R.id.cry);
        this.tjz = (TextView) findViewById(R.id.crz);
        this.tjA = (LinearLayout) findViewById(R.id.crx);
        this.tjB = (Button) findViewById(R.id.cs0);
        this.tjC = (RelativeLayout) findViewById(R.id.crw);
        this.tjD = (LinearLayout) findViewById(R.id.cs1);
        this.tjE = (TextView) findViewById(R.id.cs2);
        this.tjG = new a(this, (byte) 0);
        this.tjx.setAdapter(this.tjG);
        bGb();
        this.tjB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45604);
                WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this);
                AppMethodBeat.o(45604);
            }
        });
        this.tjx.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(45605);
                ab.i("MicroMsg.WalletLqtPlanHomeUI", "pos: %s", Integer.valueOf(i));
                adapterView.getAdapter().getItem(i);
                AppMethodBeat.o(45605);
            }
        });
        AppMethodBeat.o(45624);
    }

    public final int getLayoutId() {
        return R.layout.a_m;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45625);
        ab.i("MicroMsg.WalletLqtPlanHomeUI", "activity result: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
            case 2:
            case 3:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("encrypt_pwd");
                    int i3 = this.tjI;
                    int i4 = this.tjJ;
                    final Dialog b = g.b(this.mController.ylL, false, null);
                    f.h(Integer.valueOf(i3), Integer.valueOf(i4), stringExtra).c(this.tjF.tfS).f(new com.tencent.mm.vending.c.a<Object, bae>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(45614);
                            b.dismiss();
                            WalletLqtPlanHomeUI.b(WalletLqtPlanHomeUI.this);
                            AppMethodBeat.o(45614);
                            return null;
                        }
                    }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
                        public final void bi(Object obj) {
                            AppMethodBeat.i(45613);
                            b.dismiss();
                            if (obj instanceof m) {
                                ((m) obj).y(WalletLqtPlanHomeUI.this.mController.ylL, false);
                            }
                            AppMethodBeat.o(45613);
                        }
                    });
                    break;
                }
                break;
            case 65281:
                if (i2 == -1) {
                    mO(false);
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(45625);
    }

    private void bGb() {
        AppMethodBeat.i(45626);
        this.kox = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.a_l, this.tjx, false);
        this.kox.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45606);
                WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this);
                AppMethodBeat.o(45606);
            }
        });
        this.tjx.addFooterView(this.kox);
        AppMethodBeat.o(45626);
    }

    private void mO(final boolean z) {
        AppMethodBeat.i(45627);
        n nVar = new n();
        nVar.b(new com.tencent.mm.plugin.wallet.balance.a.a.g());
        nVar.a(new com.tencent.mm.wallet_core.c.a.a<bkl>() {
            public final /* synthetic */ void bX(Object obj) {
                AppMethodBeat.i(45611);
                bkl bkl = (bkl) obj;
                ab.i("MicroMsg.WalletLqtPlanHomeUI", "on index response callback");
                if (bkl == null) {
                    m.gi(-1, -1).y(WalletLqtPlanHomeUI.this.mController.ylL, true);
                    AppMethodBeat.o(45611);
                } else if (bkl.kdT == 0) {
                    WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this, bkl);
                    AppMethodBeat.o(45611);
                } else {
                    m.a(true, bkl.kdT, 0, bkl.kdU).y(WalletLqtPlanHomeUI.this.mController.ylL, true);
                    AppMethodBeat.o(45611);
                }
            }

            public final /* synthetic */ void bY(Object obj) {
                AppMethodBeat.i(45612);
                bkl bkl = (bkl) obj;
                ab.i("MicroMsg.WalletLqtPlanHomeUI", "on index cache callback");
                if (bkl != null && z) {
                    WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this, bkl);
                }
                AppMethodBeat.o(45612);
            }
        });
        AppMethodBeat.o(45627);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45623);
        this.yll = true;
        super.onCreate(bundle);
        setMMTitle("");
        xE(getResources().getColor(R.color.a69));
        dyb();
        initView();
        mO(true);
        AppMethodBeat.o(45623);
    }

    static /* synthetic */ void a(WalletLqtPlanHomeUI walletLqtPlanHomeUI) {
        AppMethodBeat.i(45628);
        ab.i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui");
        Intent intent = new Intent(walletLqtPlanHomeUI, WalletLqtPlanAddUI.class);
        intent.putExtra("key_mode", 1);
        walletLqtPlanHomeUI.startActivityForResult(intent, 65281);
        AppMethodBeat.o(45628);
    }

    static /* synthetic */ void c(WalletLqtPlanHomeUI walletLqtPlanHomeUI, int i) {
        AppMethodBeat.i(45629);
        ab.i("MicroMsg.WalletLqtPlanHomeUI", "go to check pwd");
        Intent intent = new Intent(walletLqtPlanHomeUI, WalletCheckPwdNewUI.class);
        intent.putExtra("scene", 3);
        intent.putExtra("title", ac.Hb(i));
        walletLqtPlanHomeUI.startActivityForResult(intent, i);
        AppMethodBeat.o(45629);
    }

    static /* synthetic */ void a(WalletLqtPlanHomeUI walletLqtPlanHomeUI, final List list, final bkm bkm) {
        AppMethodBeat.i(45633);
        ab.i("MicroMsg.WalletLqtPlanHomeUI", "show operation menu: %s", list);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(45633);
            return;
        }
        d dVar = new d(walletLqtPlanHomeUI.mController.ylL, 1, false);
        dVar.rBl = new c() {
            public final void a(l lVar) {
                AppMethodBeat.i(45608);
                for (Integer intValue : list) {
                    int intValue2 = intValue.intValue();
                    switch (intValue2) {
                        case 1:
                            lVar.hi(intValue2, R.string.fj_);
                            break;
                        case 2:
                            lVar.e(intValue2, WalletLqtPlanHomeUI.this.getString(R.string.fja));
                            break;
                        case 3:
                            lVar.hi(intValue2, R.string.fj8);
                            break;
                        case 4:
                            lVar.hi(intValue2, R.string.fj9);
                            break;
                        default:
                            break;
                    }
                }
                AppMethodBeat.o(45608);
            }
        };
        dVar.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(45610);
                final int itemId = menuItem.getItemId();
                WalletLqtPlanHomeUI.this.tjI = itemId;
                WalletLqtPlanHomeUI.this.tjJ = bkm.vES;
                switch (itemId) {
                    case 1:
                        WalletLqtPlanHomeUI.c(WalletLqtPlanHomeUI.this, itemId);
                        AppMethodBeat.o(45610);
                        return;
                    case 2:
                        h.a(WalletLqtPlanHomeUI.this.mController.ylL, WalletLqtPlanHomeUI.this.getString(R.string.fjj), "", WalletLqtPlanHomeUI.this.getString(R.string.fji), WalletLqtPlanHomeUI.this.getString(R.string.or), true, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(45609);
                                WalletLqtPlanHomeUI.c(WalletLqtPlanHomeUI.this, itemId);
                                AppMethodBeat.o(45609);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }, (int) R.color.y0);
                        AppMethodBeat.o(45610);
                        return;
                    case 3:
                        WalletLqtPlanHomeUI.c(WalletLqtPlanHomeUI.this, itemId);
                        AppMethodBeat.o(45610);
                        return;
                    case 4:
                        WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this, bkm);
                        break;
                }
                AppMethodBeat.o(45610);
            }
        };
        dVar.cpD();
        AppMethodBeat.o(45633);
    }
}
