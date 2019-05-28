package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.design.widget.BottomSheetBehavior;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.g.a.se;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.a.a.q;
import com.tencent.mm.plugin.wallet.balance.a.a.r;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLqtDetailUI extends WalletLqtBasePresenterUI {
    private static final int koS = a.fromDPToPix(ah.getContext(), 16);
    private Dialog gnn;
    private ak handler = new ak(Looper.getMainLooper());
    private TextView tiA;
    private LinearLayout tiB;
    private TextView tiC;
    private TextView tiD;
    private TextView tiE;
    private TextView tiF;
    private boolean tiG = true;
    private q tic = ((q) Z(q.class));
    private r tie = ((r) V(r.class));
    private bnr tif;
    private ViewGroup tig;
    private TextView tih;
    private WalletTextView tii;
    private ViewGroup tij;
    private TextView tik;
    private TextView til;
    private ViewGroup tim;
    private TextView tin;
    private WalletTextView tio;
    private Button tip;
    private Button tiq;
    private LinearLayout tir;
    private TextView tis;
    private TextView tit;
    private View tiu;
    private TextView tiv;
    private View tiw;
    private View tix;
    private CdnImageView tiy;
    private TextView tiz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLqtDetailUI() {
        AppMethodBeat.i(45545);
        AppMethodBeat.o(45545);
    }

    static /* synthetic */ ArrayList e(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.i(45555);
        ArrayList cNh = walletLqtDetailUI.cNh();
        AppMethodBeat.o(45555);
        return cNh;
    }

    static {
        AppMethodBeat.i(45557);
        AppMethodBeat.o(45557);
    }

    private ArrayList<String> cNh() {
        AppMethodBeat.i(45547);
        ArrayList arrayList = new ArrayList();
        if (this.tif.wQx != null && this.tif.wQx.size() > 0) {
            Iterator it = this.tif.wQx.iterator();
            while (it.hasNext()) {
                xg xgVar = (xg) it.next();
                if (!(bo.isNullOrNil(xgVar.title) || bo.isNullOrNil(xgVar.wdd))) {
                    arrayList.add(String.format("%s||%s", new Object[]{xgVar.title, xgVar.wdd}));
                }
            }
        }
        AppMethodBeat.o(45547);
        return arrayList;
    }

    public void onResume() {
        AppMethodBeat.i(45548);
        super.onResume();
        if (this.tiG) {
            this.tig.setVisibility(8);
            this.gnn = g.b(this, false, null);
            this.tie.tfC.aor().f(new com.tencent.mm.vending.c.a<Void, bnr>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(45537);
                    bnr bnr = (bnr) obj;
                    if (bnr != null) {
                        ab.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", Integer.valueOf(bnr.wao), Boolean.valueOf(bnr.wQG));
                        WalletLqtDetailUI.this.tif = bnr;
                        WalletLqtDetailUI.b(WalletLqtDetailUI.this);
                    } else {
                        ab.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
                    }
                    if (WalletLqtDetailUI.this.gnn != null) {
                        WalletLqtDetailUI.this.gnn.dismiss();
                    }
                    Void voidR = zXH;
                    AppMethodBeat.o(45537);
                    return voidR;
                }
            }).a((d.a) new d.a() {
                public final void bi(Object obj) {
                    AppMethodBeat.i(45522);
                    if (WalletLqtDetailUI.this.gnn != null) {
                        WalletLqtDetailUI.this.gnn.dismiss();
                    }
                    ab.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", obj);
                    if (obj != null) {
                        CharSequence obj2;
                        if (obj instanceof String) {
                            obj2 = obj.toString();
                        } else {
                            obj2 = WalletLqtDetailUI.this.getString(R.string.fiu);
                        }
                        Toast.makeText(WalletLqtDetailUI.this, obj2, 1).show();
                    }
                    AppMethodBeat.o(45522);
                }
            });
        }
        this.tiG = true;
        AppMethodBeat.o(45548);
    }

    private void ack(String str) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(45549);
        ab.i("MicroMsg.WalletLqtDetailUI", "go to save ui");
        Intent intent = new Intent(this, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fund_code", this.tif != null ? this.tif.wPv : null);
        intent.putExtra("lqt_save_fetch_mode", 1);
        String str2 = "lqt_is_show_protocol";
        if (this.tif.cRh == 1) {
            z = true;
        } else {
            z = false;
        }
        intent.putExtra(str2, z);
        String str3 = "lqt_is_agree_protocol";
        if (this.tif.wQw != 1) {
            z2 = false;
        }
        intent.putExtra(str3, z2);
        intent.putStringArrayListExtra("lqt_protocol_list", cNh());
        intent.putExtra("lqt_profile_wording", this.tif.wQp);
        intent.putExtra("lqt_account_type", this.tif.wao);
        intent.putExtra("lqt_fund_spid", this.tif.wPx);
        intent.putExtra("operate_id", str);
        startActivity(intent);
        AppMethodBeat.o(45549);
    }

    private void acl(String str) {
        AppMethodBeat.i(45550);
        ab.i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
        Intent intent = new Intent(this, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fetch_mode", 2);
        intent.putExtra("lqt_balance", this.tif.wJb);
        intent.putExtra("lqt_max_redeem_amount", this.tif.wQD);
        intent.putExtra("lqt_redeem_invalid_amount_hint", this.tif.wQE);
        intent.putExtra("lqt_account_type", this.tif.wao);
        intent.putExtra("operate_id", str);
        startActivity(intent);
        AppMethodBeat.o(45550);
    }

    public final int getLayoutId() {
        return R.layout.b4r;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45551);
        super.onActivityResult(i, i2, intent);
        if (i == 123 && i2 == -1) {
            this.tiG = false;
            String stringExtra = intent.getStringExtra("lqt_enc_pwd");
            if (this.gnn == null) {
                this.gnn = g.b(this, false, null);
            } else {
                this.gnn.show();
            }
            f.D(stringExtra, Integer.valueOf(this.tif.wao)).c(this.tie.tfD).f(new com.tencent.mm.vending.c.a<Void, sw>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(45536);
                    WalletLqtDetailUI.this.handler.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(45535);
                            if (WalletLqtDetailUI.this.gnn != null) {
                                WalletLqtDetailUI.this.gnn.dismiss();
                            }
                            Toast.makeText(WalletLqtDetailUI.this, WalletLqtDetailUI.this.getString(R.string.fi1), 1).show();
                            WalletLqtDetailUI.this.finish();
                            AppMethodBeat.o(45535);
                        }
                    }, 1000);
                    Void voidR = zXH;
                    AppMethodBeat.o(45536);
                    return voidR;
                }
            }).a((d.a) new d.a() {
                public final void bi(Object obj) {
                    AppMethodBeat.i(45534);
                    if (WalletLqtDetailUI.this.gnn != null) {
                        WalletLqtDetailUI.this.gnn.dismiss();
                    }
                    ab.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", obj);
                    if (obj != null) {
                        CharSequence obj2;
                        if (obj instanceof String) {
                            obj2 = obj.toString();
                        } else {
                            obj2 = WalletLqtDetailUI.this.getString(R.string.fiu);
                        }
                        Toast.makeText(WalletLqtDetailUI.this, obj2, 1).show();
                    }
                    AppMethodBeat.o(45534);
                }
            });
        }
        AppMethodBeat.o(45551);
    }

    public void onDestroy() {
        AppMethodBeat.i(45552);
        super.onDestroy();
        this.tic = null;
        this.tie = null;
        AppMethodBeat.o(45552);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45546);
        this.yll = true;
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.a4p));
        Nc(getResources().getColor(R.color.a69));
        dyb();
        setMMTitle("");
        int intExtra = getIntent().getIntExtra("key_account_type", 1);
        ab.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", Integer.valueOf(intExtra));
        this.tig = (ViewGroup) findViewById(R.id.fas);
        this.tih = (TextView) findViewById(R.id.fat);
        this.tii = (WalletTextView) findViewById(R.id.fb0);
        this.tij = (ViewGroup) findViewById(R.id.fb1);
        this.tik = (TextView) findViewById(R.id.fb2);
        this.til = (TextView) findViewById(R.id.fb4);
        this.tim = (ViewGroup) findViewById(R.id.fb6);
        this.tin = (TextView) findViewById(R.id.fb7);
        this.tio = (WalletTextView) findViewById(R.id.fb9);
        this.tip = (Button) findViewById(R.id.fba);
        this.tiq = (Button) findViewById(R.id.fbb);
        this.tir = (LinearLayout) findViewById(R.id.fbd);
        this.tis = (TextView) findViewById(R.id.fbl);
        this.tiu = findViewById(R.id.cs1);
        this.tiv = (TextView) findViewById(R.id.cs2);
        this.tix = findViewById(R.id.fbf);
        this.tiy = (CdnImageView) findViewById(R.id.fbg);
        this.tiz = (TextView) findViewById(R.id.fbh);
        this.tiA = (TextView) findViewById(R.id.fbi);
        this.tiw = findViewById(R.id.fbe);
        this.tit = (TextView) findViewById(R.id.fbm);
        this.tiB = (LinearLayout) findViewById(R.id.faw);
        this.tiC = (TextView) findViewById(R.id.fax);
        this.tiD = (TextView) findViewById(R.id.fb5);
        this.tiE = (TextView) findViewById(R.id.fb_);
        this.tiF = (TextView) findViewById(R.id.fbj);
        this.tis.setVisibility(4);
        AppMethodBeat.o(45546);
    }

    static /* synthetic */ void b(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.i(45553);
        if (walletLqtDetailUI.tif != null) {
            walletLqtDetailUI.tii.setText(e.F(e.b(walletLqtDetailUI.tif.wJb, "100", RoundingMode.HALF_UP)));
            ImageView imageView = (ImageView) walletLqtDetailUI.findViewById(R.id.fb3);
            if (imageView != null) {
                if (bo.isNullOrNil(walletLqtDetailUI.tif.wQH)) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
            }
            imageView = (ImageView) walletLqtDetailUI.findViewById(R.id.fb8);
            if (imageView != null) {
                if (bo.isNullOrNil(walletLqtDetailUI.tif.wQH)) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
            }
            walletLqtDetailUI.tij.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45538);
                    if (!bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQH)) {
                        e.n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQH, false);
                        h.pYm.e(17084, Integer.valueOf(1));
                    }
                    AppMethodBeat.o(45538);
                }
            });
            walletLqtDetailUI.tik.setText(walletLqtDetailUI.tif.wQr);
            walletLqtDetailUI.til.setText(walletLqtDetailUI.tif.wQs);
            walletLqtDetailUI.tin.setText(walletLqtDetailUI.tif.wQt);
            walletLqtDetailUI.tio.setText(e.G(e.b(walletLqtDetailUI.tif.wQu, "100", RoundingMode.HALF_UP)));
            walletLqtDetailUI.tim.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45539);
                    if (!bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQI)) {
                        e.n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQI, false);
                        h.pYm.e(17084, Integer.valueOf(2));
                    }
                    AppMethodBeat.o(45539);
                }
            });
            if (bo.isNullOrNil(walletLqtDetailUI.tif.wQK)) {
                walletLqtDetailUI.tiD.setVisibility(4);
            } else {
                walletLqtDetailUI.tiD.setText(walletLqtDetailUI.tif.wQK);
                walletLqtDetailUI.tiD.setVisibility(0);
            }
            if (bo.isNullOrNil(walletLqtDetailUI.tif.wQR)) {
                walletLqtDetailUI.tiE.setVisibility(4);
            } else {
                walletLqtDetailUI.tiE.setText(walletLqtDetailUI.tif.wQR);
                walletLqtDetailUI.tiE.setVisibility(0);
            }
            walletLqtDetailUI.tir.removeAllViews();
            final ViewGroup viewGroup;
            TextView textView;
            if (walletLqtDetailUI.tif.wQJ != null && !walletLqtDetailUI.tif.wQJ.isEmpty()) {
                Iterator it = walletLqtDetailUI.tif.wQJ.iterator();
                int i = 0;
                while (it.hasNext()) {
                    final bdy bdy = (bdy) it.next();
                    viewGroup = (ViewGroup) walletLqtDetailUI.getLayoutInflater().inflate(R.layout.a_h, walletLqtDetailUI.tir, false);
                    TextView textView2 = (TextView) viewGroup.findViewById(R.id.crd);
                    textView = (TextView) viewGroup.findViewById(R.id.cre);
                    View findViewById = viewGroup.findViewById(R.id.crf);
                    if (i == walletLqtDetailUI.tif.wQJ.size() - 1) {
                        findViewById.setVisibility(8);
                    }
                    textView2.setText(bdy.title);
                    textView.setText(bdy.desc);
                    if (bdy.wHE == 1) {
                        if (bdy.wHD == 1) {
                            viewGroup.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(45540);
                                    ab.i("MicroMsg.WalletLqtDetailUI", "go to lqt plan home");
                                    WalletLqtDetailUI.this.startActivity(new Intent(WalletLqtDetailUI.this.mController.ylL, WalletLqtPlanHomeUI.class));
                                    h.pYm.e(16807, Integer.valueOf(2), Integer.valueOf(1), "", "", Integer.valueOf(bdy.wHD));
                                    AppMethodBeat.o(45540);
                                }
                            });
                        }
                    } else if (bdy.wHE == 2) {
                        if (!bo.isNullOrNil(bdy.wdd)) {
                            viewGroup.setTag(bdy.wdd);
                            viewGroup.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(45541);
                                    e.n(WalletLqtDetailUI.this, (String) viewGroup.getTag(), false);
                                    h.pYm.e(16807, Integer.valueOf(2), Integer.valueOf(2), bdy.wdd);
                                    AppMethodBeat.o(45541);
                                }
                            });
                        }
                    } else if (!(bdy.wHE != 3 || bo.isNullOrNil(bdy.vTT) || bo.isNullOrNil(bdy.wdd))) {
                        viewGroup.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(45542);
                                e.p(bdy.vTT, bdy.wdd, 0, FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
                                h.pYm.e(16807, Integer.valueOf(2), Integer.valueOf(2), bdy.wdd, bdy.vTT);
                                AppMethodBeat.o(45542);
                            }
                        });
                    }
                    walletLqtDetailUI.tir.addView(viewGroup, new LayoutParams(-1, -2, -1.0f));
                    i++;
                }
            } else if (walletLqtDetailUI.tif.wQv != null && walletLqtDetailUI.tif.wQv.size() > 0) {
                Iterator it2 = walletLqtDetailUI.tif.wQv.iterator();
                while (it2.hasNext()) {
                    xg xgVar = (xg) it2.next();
                    viewGroup = (ViewGroup) walletLqtDetailUI.getLayoutInflater().inflate(R.layout.a_h, walletLqtDetailUI.tir, false);
                    textView = (TextView) viewGroup.findViewById(R.id.cre);
                    ((TextView) viewGroup.findViewById(R.id.crd)).setText(xgVar.title);
                    textView.setText(xgVar.desc);
                    if (!bo.isNullOrNil(xgVar.wdd)) {
                        viewGroup.setTag(xgVar.wdd);
                        viewGroup.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(45543);
                                e.n(WalletLqtDetailUI.this, (String) viewGroup.getTag(), false);
                                AppMethodBeat.o(45543);
                            }
                        });
                    }
                    walletLqtDetailUI.tir.addView(viewGroup, new LayoutParams(-1, -2, -1.0f));
                }
            }
            if (walletLqtDetailUI.tir.getChildCount() == 0) {
                View findViewById2 = walletLqtDetailUI.findViewById(R.id.fbc);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(4);
                }
            }
            walletLqtDetailUI.tig.setVisibility(0);
            if (walletLqtDetailUI.tif.wJb <= 0) {
                walletLqtDetailUI.tiq.setEnabled(false);
            } else {
                walletLqtDetailUI.tiq.setEnabled(true);
            }
            if (b.dnO()) {
                walletLqtDetailUI.tiq.setEnabled(true);
            }
            if (bo.isNullOrNil(walletLqtDetailUI.tif.wQS)) {
                walletLqtDetailUI.tiF.setVisibility(8);
                walletLqtDetailUI.findViewById(R.id.fbk).setVisibility(8);
                walletLqtDetailUI.tis.setGravity(17);
                walletLqtDetailUI.tis.setPadding(0, 0, 0, 0);
            } else {
                walletLqtDetailUI.tiF.setText(walletLqtDetailUI.tif.wQS);
                e.aA(walletLqtDetailUI.tiF, 50);
                walletLqtDetailUI.tiF.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45544);
                        WalletLqtDetailUI.d(WalletLqtDetailUI.this);
                        h.pYm.e(17084, Integer.valueOf(3));
                        AppMethodBeat.o(45544);
                    }
                });
                walletLqtDetailUI.tiF.setVisibility(0);
                walletLqtDetailUI.findViewById(R.id.fbk).setVisibility(0);
                walletLqtDetailUI.tis.setGravity(3);
                walletLqtDetailUI.tis.setPadding(a.fromDPToPix(walletLqtDetailUI.mController.ylL, 5), 0, 0, 0);
            }
            if (walletLqtDetailUI.tif.wQy != null) {
                walletLqtDetailUI.tis.setText(walletLqtDetailUI.tif.wQy.title);
                walletLqtDetailUI.tis.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45523);
                        e.n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQy.wdd, false);
                        h.pYm.e(17084, Integer.valueOf(4));
                        AppMethodBeat.o(45523);
                    }
                });
            }
            walletLqtDetailUI.tiu.setVisibility(8);
            if (!(walletLqtDetailUI.tif.wQA == null || bo.isNullOrNil(walletLqtDetailUI.tif.wQA.title))) {
                walletLqtDetailUI.tiu.setVisibility(0);
                walletLqtDetailUI.tiv.setText(walletLqtDetailUI.tif.wQA.title);
                if (!bo.isNullOrNil(walletLqtDetailUI.tif.wQA.wdd)) {
                    walletLqtDetailUI.tiu.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(45524);
                            e.n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQA.wdd, false);
                            AppMethodBeat.o(45524);
                        }
                    });
                }
            }
            walletLqtDetailUI.tix.setVisibility(8);
            walletLqtDetailUI.tiw.setVisibility(8);
            if (!(walletLqtDetailUI.tif.wQB == null || bo.isNullOrNil(walletLqtDetailUI.tif.wQB.username))) {
                walletLqtDetailUI.tiy.setUrl(walletLqtDetailUI.tif.wQB.kbV);
                walletLqtDetailUI.tiz.setText(walletLqtDetailUI.tif.wQB.title);
                walletLqtDetailUI.tiA.setText(walletLqtDetailUI.tif.wQB.desc);
                walletLqtDetailUI.tix.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45525);
                        se seVar = new se();
                        seVar.cOf.userName = WalletLqtDetailUI.this.tif.wQB.username;
                        seVar.cOf.cOh = bo.bc(WalletLqtDetailUI.this.tif.wQB.path, "");
                        seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_QINSHUI;
                        seVar.cOf.cOi = 0;
                        com.tencent.mm.sdk.b.a.xxA.m(seVar);
                        AppMethodBeat.o(45525);
                    }
                });
                walletLqtDetailUI.tiw.setVisibility(0);
                walletLqtDetailUI.tix.setVisibility(0);
            }
            walletLqtDetailUI.tis.setVisibility(0);
            if (!bo.isNullOrNil(walletLqtDetailUI.tif.wQN)) {
                walletLqtDetailUI.tit.setText(walletLqtDetailUI.tif.wQN);
            } else if (walletLqtDetailUI.tif.wao == 1) {
                walletLqtDetailUI.tit.setText(R.string.fi4);
            } else if (walletLqtDetailUI.tif.wao == 2) {
                walletLqtDetailUI.tit.setText(R.string.fi5);
            }
            if (walletLqtDetailUI.tif.wQO == null || bo.isNullOrNil(walletLqtDetailUI.tif.wQO.title)) {
                walletLqtDetailUI.tiB.setVisibility(8);
            } else {
                walletLqtDetailUI.tiB.setVisibility(0);
                walletLqtDetailUI.tiC.setText(walletLqtDetailUI.tif.wQO.title);
                walletLqtDetailUI.tiB.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45526);
                        ab.i("MicroMsg.WalletLqtDetailUI", "click top biz");
                        if (WalletLqtDetailUI.this.tif.wQO.wHE == 2) {
                            if (!bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQO.wdd)) {
                                e.n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQO.wdd, false);
                                h.pYm.e(16807, Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.this.tif.wQO.wdd);
                                AppMethodBeat.o(45526);
                                return;
                            }
                        } else if (!(WalletLqtDetailUI.this.tif.wQO.wHE != 3 || bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQO.vTT) || bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQO.wdd))) {
                            e.p(WalletLqtDetailUI.this.tif.wQO.vTT, WalletLqtDetailUI.this.tif.wQO.wdd, 0, FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
                            h.pYm.e(16807, Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.this.tif.wQO.wdd, WalletLqtDetailUI.this.tif.wQO.vTT);
                        }
                        AppMethodBeat.o(45526);
                    }
                });
            }
            walletLqtDetailUI.tip.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    boolean z = true;
                    AppMethodBeat.i(45527);
                    if (ae.gjv) {
                        boolean z2;
                        Intent intent = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
                        intent.putExtra("lqt_save_fund_code", WalletLqtDetailUI.this.tif != null ? WalletLqtDetailUI.this.tif.wPv : null);
                        intent.putExtra("lqt_save_fetch_mode", 1);
                        String str = "lqt_is_show_protocol";
                        if (WalletLqtDetailUI.this.tif.cRh == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        intent.putExtra(str, z2);
                        String str2 = "lqt_is_agree_protocol";
                        if (WalletLqtDetailUI.this.tif.wQw != 1) {
                            z = false;
                        }
                        intent.putExtra(str2, z);
                        intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(WalletLqtDetailUI.this));
                        intent.putExtra("lqt_profile_wording", WalletLqtDetailUI.this.tif.wQp);
                        WalletLqtDetailUI.this.startActivity(intent);
                        AppMethodBeat.o(45527);
                        return;
                    }
                    WalletLqtDetailUI.this.tie.tfF.ge(WalletLqtDetailUI.this.tif.wao, 1);
                    if (bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQC)) {
                        WalletLqtDetailUI.a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.this.tif.wQP);
                        AppMethodBeat.o(45527);
                        return;
                    }
                    ab.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", WalletLqtDetailUI.this.tif.wQC);
                    e.n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQC, false);
                    AppMethodBeat.o(45527);
                }
            });
            walletLqtDetailUI.tiq.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45528);
                    f.D(Integer.valueOf(WalletLqtDetailUI.this.tif.wao), Integer.valueOf(1)).c(WalletLqtDetailUI.this.tie.tfE);
                    WalletLqtDetailUI.a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.this.tif.wQQ);
                    AppMethodBeat.o(45528);
                }
            });
        }
        walletLqtDetailUI.mController.removeAllOptionMenu();
        if (walletLqtDetailUI.tif != null) {
            walletLqtDetailUI.addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(45533);
                    com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(WalletLqtDetailUI.this, 1, false);
                    dVar.rBl = new c() {
                        public final void a(l lVar) {
                            AppMethodBeat.i(45530);
                            if (WalletLqtDetailUI.this.tif.wQz != null && WalletLqtDetailUI.this.tif.wQz.size() > 0) {
                                Iterator it = WalletLqtDetailUI.this.tif.wQz.iterator();
                                int i = 0;
                                while (it.hasNext()) {
                                    xg xgVar = (xg) it.next();
                                    if (!(bo.isNullOrNil(xgVar.title) || bo.isNullOrNil(xgVar.wdd))) {
                                        lVar.add(0, i, 0, xgVar.title);
                                    }
                                    i++;
                                }
                            }
                            if (!WalletLqtDetailUI.this.tif.wQG) {
                                lVar.add(0, -1, 0, (int) R.string.fi0);
                            }
                            AppMethodBeat.o(45530);
                        }
                    };
                    dVar.rBm = new n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(45532);
                            if (menuItem.getItemId() != -1 || WalletLqtDetailUI.this.tif.wQG) {
                                if (WalletLqtDetailUI.this.tif.wQz != null && WalletLqtDetailUI.this.tif.wQz.size() > 0 && menuItem.getItemId() < WalletLqtDetailUI.this.tif.wQz.size()) {
                                    e.n(WalletLqtDetailUI.this, ((xg) WalletLqtDetailUI.this.tif.wQz.get(menuItem.getItemId())).wdd, false);
                                }
                                AppMethodBeat.o(45532);
                                return;
                            }
                            String str;
                            if (!bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQL)) {
                                str = WalletLqtDetailUI.this.tif.wQL;
                            } else if (WalletLqtDetailUI.this.tif.wao == 0) {
                                str = WalletLqtDetailUI.this.getString(R.string.fi2);
                            } else {
                                str = WalletLqtDetailUI.this.getString(R.string.fht);
                            }
                            com.tencent.mm.ui.base.h.a(WalletLqtDetailUI.this, str, "", WalletLqtDetailUI.this.getString(R.string.ar5), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(45531);
                                    WalletLqtDetailUI.this.tiG = false;
                                    WalletLqtDetailUI.this.startActivityForResult(new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class), 123);
                                    AppMethodBeat.o(45531);
                                }
                            });
                            AppMethodBeat.o(45532);
                        }
                    };
                    dVar.cpD();
                    AppMethodBeat.o(45533);
                    return false;
                }
            });
        }
        AppMethodBeat.o(45553);
    }

    static /* synthetic */ void d(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.i(45554);
        if (walletLqtDetailUI.tif.wQT != null) {
            final android.support.design.widget.c cVar = new android.support.design.widget.c(walletLqtDetailUI.mController.ylL);
            View inflate = View.inflate(walletLqtDetailUI.mController.ylL, R.layout.a_i, null);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.crh);
            TextView textView = (TextView) inflate.findViewById(R.id.cri);
            ((TextView) inflate.findViewById(R.id.crg)).setText(walletLqtDetailUI.tif.wQT.title);
            textView.setText(walletLqtDetailUI.tif.wQT.wjT);
            if (walletLqtDetailUI.tif.wQT.wjU != null) {
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                layoutParams.topMargin = koS;
                Iterator it = walletLqtDetailUI.tif.wQT.wjU.iterator();
                while (it.hasNext()) {
                    ace ace = (ace) it.next();
                    ViewGroup viewGroup2 = (ViewGroup) View.inflate(walletLqtDetailUI.mController.ylL, R.layout.a_j, null);
                    TextView textView2 = (TextView) viewGroup2.findViewById(R.id.crk);
                    TextView textView3 = (TextView) viewGroup2.findViewById(R.id.crl);
                    ((CdnImageView) viewGroup2.findViewById(R.id.crj)).setUrl(ace.kbV);
                    textView2.setText(ace.title);
                    textView3.setText(ace.desc);
                    viewGroup.addView(viewGroup2, layoutParams);
                }
            }
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45529);
                    cVar.dismiss();
                    AppMethodBeat.o(45529);
                }
            });
            cVar.setContentView(inflate);
            BottomSheetBehavior j = BottomSheetBehavior.j((View) inflate.getParent());
            if (j != null) {
                j.K(a.fromDPToPix(walletLqtDetailUI.mController.ylL, JsApiOpenAdCanvas.CTRL_INDEX));
                j.nj = false;
            }
            cVar.show();
        }
        AppMethodBeat.o(45554);
    }

    static /* synthetic */ void a(WalletLqtDetailUI walletLqtDetailUI, boolean z, axi axi) {
        AppMethodBeat.i(45556);
        if (axi == null) {
            if (z) {
                walletLqtDetailUI.ack("");
                AppMethodBeat.o(45556);
                return;
            }
            walletLqtDetailUI.acl("");
            AppMethodBeat.o(45556);
        } else if (axi.type == 1 && !bo.isNullOrNil(axi.url)) {
            String aci = com.tencent.mm.plugin.wallet.balance.a.a.ab.aci(axi.url);
            if (z) {
                walletLqtDetailUI.ack(aci);
                AppMethodBeat.o(45556);
                return;
            }
            walletLqtDetailUI.acl(aci);
            AppMethodBeat.o(45556);
        } else if (axi.type == 2) {
            e.n(walletLqtDetailUI.mController.ylL, axi.url, true);
            AppMethodBeat.o(45556);
        } else if (axi.type == 3) {
            e.p(axi.vTT, axi.url, 0, FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
            AppMethodBeat.o(45556);
        } else if (z) {
            walletLqtDetailUI.ack("");
            AppMethodBeat.o(45556);
        } else {
            walletLqtDetailUI.acl("");
            AppMethodBeat.o(45556);
        }
    }
}
