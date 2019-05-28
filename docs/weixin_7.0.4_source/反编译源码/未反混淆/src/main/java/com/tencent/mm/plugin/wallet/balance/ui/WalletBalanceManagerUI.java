package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.weishi.f;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.a.a;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.q;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI extends WalletBaseUI implements l {
    protected int gOW;
    protected TextView tgH;
    private h thA;
    private a thB;
    protected TextView thr;
    protected Button ths;
    protected View tht;
    protected TextView thu;
    private ViewGroup thv;
    private TextView thw;
    private ImageView thx;
    protected Bankcard thy;
    private ba thz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ boolean a(WalletBalanceManagerUI walletBalanceManagerUI) {
        AppMethodBeat.i(45454);
        boolean cNR = walletBalanceManagerUI.cNR();
        AppMethodBeat.o(45454);
        return cNR;
    }

    public final int getLayoutId() {
        return R.layout.b2x;
    }

    /* Access modifiers changed, original: protected */
    public void cMZ() {
        boolean z;
        AppMethodBeat.i(45443);
        s.cNC();
        if (s.cND().thy == null) {
            z = true;
        } else {
            z = false;
        }
        a(new y(null, 10), z, false);
        AppMethodBeat.o(45443);
    }

    public void onDestroy() {
        AppMethodBeat.i(45444);
        ng(f.CTRL_INDEX);
        r.cPP();
        ae.b(this);
        this.thB = null;
        super.onDestroy();
        AppMethodBeat.o(45444);
    }

    /* Access modifiers changed, original: protected */
    public void cNa() {
        AppMethodBeat.i(45445);
        aA(WalletBalanceSaveUI.class);
        AppMethodBeat.o(45445);
    }

    public final void initView() {
        boolean gT;
        AppMethodBeat.i(45446);
        setMMTitle("");
        this.thr = (TextView) findViewById(R.id.f6a);
        this.tgH = (TextView) findViewById(R.id.f5w);
        ((Button) findViewById(R.id.ay8)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45435);
                WalletBalanceManagerUI.this.cNa();
                e.QS(14);
                AppMethodBeat.o(45435);
            }
        });
        this.ths = (Button) findViewById(R.id.f6e);
        this.ths.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45436);
                s.cNC();
                ArrayList cQD = s.cND().cQD();
                if (cQD == null || cQD.size() == 0) {
                    ab.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
                    WalletBalanceManagerUI.c(WalletBalanceManagerUI.this);
                    AppMethodBeat.o(45436);
                    return;
                }
                ab.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
                com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, b.class, null, null);
                e.QS(15);
                AppMethodBeat.o(45436);
            }
        });
        TextView textView = (TextView) findViewById(R.id.f6h);
        if (aa.dor().equals("zh_CN")) {
            gT = bo.gT(ah.getContext());
        } else {
            gT = true;
        }
        if (gT) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45437);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
                    d.b(WalletBalanceManagerUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    e.QS(17);
                    AppMethodBeat.o(45437);
                }
            });
            textView.setVisibility(0);
        }
        ((TextView) findViewById(R.id.f6i)).setText(com.tencent.mm.wallet_core.c.ae.dOc());
        this.thv = (ViewGroup) findViewById(R.id.f6b);
        this.thw = (TextView) findViewById(R.id.f6c);
        this.thx = (ImageView) findViewById(R.id.f6d);
        this.tht = findViewById(R.id.f6f);
        this.thu = (TextView) findViewById(R.id.f6g);
        final uo uoVar = new uo();
        uoVar.cQJ.cQL = "2";
        uoVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(45438);
                if (!bo.isNullOrNil(uoVar.cQK.cQM)) {
                    e.a(WalletBalanceManagerUI.this.tgH, uoVar.cQK.cQM, uoVar.cQK.content, uoVar.cQK.url);
                }
                AppMethodBeat.o(45438);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(uoVar);
        AppMethodBeat.o(45446);
    }

    public void onResume() {
        AppMethodBeat.i(45447);
        cu();
        cMZ();
        ab.i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
        if (this.thB != null) {
            this.thB.cancel();
        }
        this.thB = new a();
        this.thB.acy().b(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<aew>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(45434);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                ab.i("MicroMsg.WalletBalanceManagerUI", "errCode: %s, errType: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType));
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    WalletBalanceManagerUI.this.thz = ((aew) aVar.fsy).wmy;
                    WalletBalanceManagerUI.this.ceo();
                }
                WalletBalanceManagerUI.this.thB = null;
                AppMethodBeat.o(45434);
                return null;
            }
        });
        super.onResume();
        com.tencent.mm.plugin.walletlock.a.b bVar = (com.tencent.mm.plugin.walletlock.a.b) g.K(com.tencent.mm.plugin.walletlock.a.b.class);
        bVar.a(this, bVar.cTi(), null);
        AppMethodBeat.o(45447);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cu() {
        AppMethodBeat.i(45448);
        s.cNC();
        this.thy = s.cND().thy;
        if (this.thy != null) {
            if (this.thy.twS >= 0.0d) {
                this.thr.setText(e.G(this.thy.twS));
            } else {
                this.thr.setText(getString(R.string.fg1));
            }
            if (cNb()) {
                this.ths.setVisibility(0);
            } else {
                this.ths.setVisibility(8);
            }
        }
        View findViewById = findViewById(R.id.d3p);
        g.RQ();
        if (((Integer) g.RP().Ry().get(ac.a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1))).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        if (new ai().cQd()) {
            g.RQ();
            String str = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_RELEAY_NAME_TIP_CONTENT_STRING_SYNC, getString(R.string.dim));
            this.tht.setVisibility(0);
            this.thu.setTextColor(getResources().getColor(R.color.a4_));
            this.thu.setText(str);
            this.tht.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45439);
                    g.RQ();
                    g.RP().Ry().set(ac.a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
                    Bundle bundle = new Bundle();
                    bundle.putInt("real_name_verify_mode", 0);
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    bundle.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
                    bundle.putInt("entry_scene", 1009);
                    com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                    AppMethodBeat.o(45439);
                }
            });
            AppMethodBeat.o(45448);
            return;
        }
        s.cNC();
        boolean z = s.cND().cQN() == 1;
        s.cNC();
        String cQO = s.cND().cQO();
        s.cNC();
        ab.i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", Boolean.valueOf(z), cQO, s.cND().cQP());
        if (!z || (bo.isNullOrNil(cQO) && bo.isNullOrNil(r4))) {
            s.cNC();
            if (s.cND().cQw()) {
                this.tht.setVisibility(0);
                this.tht.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45440);
                        g.RQ();
                        g.RP().Ry().set(ac.a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
                        Intent intent = new Intent(WalletBalanceManagerUI.this, WalletLqtDetailUI.class);
                        intent.putExtra("key_account_type", 1);
                        WalletBalanceManagerUI.this.startActivity(intent);
                        AppMethodBeat.o(45440);
                    }
                });
                TextView textView = this.thu;
                s.cNC();
                textView.setText(s.cND().cQs());
                AppMethodBeat.o(45448);
                return;
            }
            s.cNC();
            final ak cND = s.cND();
            if (cND == null || !cND.cQo().cPZ() || TextUtils.isEmpty(cND.cQs()) || TextUtils.isEmpty(cND.cQt())) {
                this.tht.setVisibility(8);
            } else {
                this.tht.setVisibility(0);
                this.thu.setText(cND.cQs());
                this.tht.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45441);
                        g.RQ();
                        g.RP().Ry().set(ac.a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
                        e.n(WalletBalanceManagerUI.this, cND.cQt(), true);
                        AppMethodBeat.o(45441);
                    }
                });
                AppMethodBeat.o(45448);
                return;
            }
        }
        AppMethodBeat.o(45448);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ceo() {
        AppMethodBeat.i(45449);
        if (this.thz == null) {
            ab.w("MicroMsg.WalletBalanceManagerUI", "actionsheet is null");
            AppMethodBeat.o(45449);
            return;
        }
        boolean optBoolean;
        this.mController.removeAllOptionMenu();
        try {
            String str = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, (Object) "");
            if (!bo.isNullOrNil(str)) {
                optBoolean = new JSONObject(str).optBoolean("is_show_menu", false);
                if (optBoolean) {
                    ab.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
                    if (this.thy != null) {
                        s.cNC();
                        s.cND();
                        if (!bo.isNullOrNil(this.thy.twV)) {
                            str = getString(R.string.f99);
                            if (!bo.isNullOrNil(this.thy.twX)) {
                                ab.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_word：%s", this.thy.twX);
                                str = this.thy.twX;
                            }
                            a(str, (OnMenuItemClickListener) new OnMenuItemClickListener() {
                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    AppMethodBeat.i(45429);
                                    Intent intent = new Intent();
                                    if (bo.isNullOrNil(WalletBalanceManagerUI.this.thy.twW)) {
                                        intent.putExtra("rawUrl", WalletBalanceManagerUI.this.thy.twV);
                                    } else {
                                        ab.i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", WalletBalanceManagerUI.this.thy.twW);
                                        intent.putExtra("rawUrl", WalletBalanceManagerUI.this.thy.twW);
                                    }
                                    intent.putExtra("showShare", false);
                                    intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
                                    intent.putExtra("KPublisherId", "pay_blance_list");
                                    intent.putExtra("geta8key_scene", 33);
                                    d.b(WalletBalanceManagerUI.this, "webview", ".ui.tools.WebViewUI", intent);
                                    e.QS(16);
                                    com.tencent.mm.plugin.report.service.h.pYm.e(16503, Integer.valueOf(1), "balanceBill");
                                    AppMethodBeat.o(45429);
                                    return true;
                                }
                            }, q.b.TRANSPARENT_BG_BLACK_TEXT);
                        }
                    }
                    AppMethodBeat.o(45449);
                    return;
                }
                ab.i("MicroMsg.WalletBalanceManagerUI", "go new menu logic");
                addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(45428);
                        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(WalletBalanceManagerUI.this.mController.ylL, 1, false);
                        AppCompatActivity appCompatActivity = WalletBalanceManagerUI.this.mController.ylL;
                        ba d = WalletBalanceManagerUI.this.thz;
                        AnonymousClass1 anonymousClass1 = new n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(45427);
                                if (i < WalletBalanceManagerUI.this.thz.vCQ.size()) {
                                    az azVar = (az) WalletBalanceManagerUI.this.thz.vCQ.get(i);
                                    if (azVar.vCP != null) {
                                        if (azVar.vCP.type == 1) {
                                            com.tencent.mm.plugin.report.service.h.pYm.e(16503, Integer.valueOf(2), azVar.vCP.url);
                                            AppMethodBeat.o(45427);
                                            return;
                                        } else if (azVar.vCP.type == 2) {
                                            com.tencent.mm.plugin.report.service.h.pYm.e(16503, Integer.valueOf(3), azVar.vCP.wVC.username);
                                            AppMethodBeat.o(45427);
                                            return;
                                        } else if (azVar.vCP.type == 5) {
                                            com.tencent.mm.plugin.report.service.h.pYm.e(16503, Integer.valueOf(4), azVar.vCP.url);
                                        }
                                    }
                                }
                                AppMethodBeat.o(45427);
                            }
                        };
                        if (!(d == null || d.vCQ == null || d.vCQ.isEmpty())) {
                            dVar.rBl = new com.tencent.mm.plugin.wallet_core.utils.e.AnonymousClass8(d, appCompatActivity);
                            dVar.rBm = new com.tencent.mm.plugin.wallet_core.utils.e.AnonymousClass9(d, appCompatActivity, anonymousClass1);
                        }
                        dVar.cpD();
                        com.tencent.mm.plugin.report.service.h.pYm.e(16503, Integer.valueOf(1));
                        AppMethodBeat.o(45428);
                        return false;
                    }
                });
                AppMethodBeat.o(45449);
                return;
            }
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", e, "", new Object[0]);
        }
        optBoolean = false;
        if (optBoolean) {
        }
    }

    private boolean cNb() {
        AppMethodBeat.i(45450);
        s.cNC();
        if (!s.cND().cQo().cNb() || this.thy.twS <= 0.0d) {
            AppMethodBeat.o(45450);
            return false;
        }
        AppMethodBeat.o(45450);
        return true;
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45451);
        if (i == 0 && i2 == 0 && !(mVar instanceof com.tencent.mm.plugin.wallet.bind.a.b) && (mVar instanceof y)) {
            this.thA = ((y) mVar).tuw;
            if (this.thA == null) {
                this.thv.setVisibility(8);
            } else if (bo.isNullOrNil(this.thA.cEh)) {
                this.thv.setVisibility(8);
            } else {
                this.thw.setText(this.thA.cEh);
                if (!bo.isNullOrNil(this.thA.color)) {
                    this.thw.setTextColor(Color.parseColor(this.thA.color));
                    this.thx.getDrawable().setColorFilter(Color.parseColor(this.thA.color), Mode.SRC_ATOP);
                }
                this.thv.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45431);
                        ab.i("MicroMsg.WalletBalanceManagerUI", "click action entry");
                        if (WalletBalanceManagerUI.this.thA.type == 1) {
                            if (bo.isNullOrNil(WalletBalanceManagerUI.this.thA.txZ)) {
                                AppMethodBeat.o(45431);
                                return;
                            } else if (WalletBalanceManagerUI.this.thA.txZ.startsWith("weixin://wcpay/lqt/detail")) {
                                com.tencent.mm.plugin.wallet.balance.a.a.ab.parseUrl(WalletBalanceManagerUI.this.thA.txZ);
                                Intent intent = new Intent();
                                intent.putExtra("key_account_type", 1);
                                d.b(WalletBalanceManagerUI.this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                                AppMethodBeat.o(45431);
                                return;
                            } else if (WalletBalanceManagerUI.this.thA.txZ.startsWith("weixin://wcpay/lqt/save")) {
                                com.tencent.mm.plugin.wallet.balance.a.a.ab.parseUrl(WalletBalanceManagerUI.this.thA.txZ);
                                final String aci = com.tencent.mm.plugin.wallet.balance.a.a.ab.aci(WalletBalanceManagerUI.this.thA.txZ);
                                final Dialog b = com.tencent.mm.wallet_core.ui.g.b(WalletBalanceManagerUI.this.mController.ylL, false, null);
                                new com.tencent.mm.plugin.wallet.balance.a.a.l().acy().b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bnr>>() {
                                    public final /* synthetic */ Object call(Object obj) {
                                        boolean z = true;
                                        AppMethodBeat.i(45430);
                                        com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                                        ab.i("MicroMsg.WalletBalanceManagerUI", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                                        b.dismiss();
                                        if (aVar.errType == 0 && aVar.errCode == 0) {
                                            bnr bnr = (bnr) aVar.fsy;
                                            ab.i("MicroMsg.WalletBalanceManagerUI", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(bnr.kdT), bnr.kdU);
                                            if (bnr.kdT == 0) {
                                                boolean z2;
                                                com.tencent.mm.plugin.wallet.balance.a.a.ab.ach(bnr.tgu);
                                                ArrayList arrayList = new ArrayList();
                                                if (bnr.wQx != null && bnr.wQx.size() > 0) {
                                                    Iterator it = bnr.wQx.iterator();
                                                    while (it.hasNext()) {
                                                        xg xgVar = (xg) it.next();
                                                        if (!(bo.isNullOrNil(xgVar.title) || bo.isNullOrNil(xgVar.wdd))) {
                                                            arrayList.add(String.format("%s||%s", new Object[]{xgVar.title, xgVar.wdd}));
                                                        }
                                                    }
                                                }
                                                ((com.tencent.mm.plugin.wallet.balance.a.a.r) new c().a(WalletBalanceManagerUI.this.mController.ylL, com.tencent.mm.plugin.wallet.balance.a.a.r.class)).tfF.ge(bnr.wao, 3);
                                                Intent intent = new Intent(WalletBalanceManagerUI.this.mController.ylL, WalletLqtSaveFetchUI.class);
                                                intent.putExtra("lqt_save_fund_code", bnr != null ? bnr.wPv : null);
                                                intent.putExtra("lqt_save_fetch_mode", 1);
                                                String str = "lqt_is_show_protocol";
                                                if (bnr.cRh == 1) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                intent.putExtra(str, z2);
                                                String str2 = "lqt_is_agree_protocol";
                                                if (bnr.wQw != 1) {
                                                    z = false;
                                                }
                                                intent.putExtra(str2, z);
                                                intent.putStringArrayListExtra("lqt_protocol_list", arrayList);
                                                intent.putExtra("lqt_profile_wording", bnr.wQp);
                                                intent.putExtra("lqt_account_type", bnr.wao);
                                                intent.putExtra("lqt_fund_spid", bnr.wPx);
                                                intent.putExtra("operate_id", aci);
                                                WalletBalanceManagerUI.this.startActivity(intent);
                                            }
                                        }
                                        Void voidR = zXH;
                                        AppMethodBeat.o(45430);
                                        return voidR;
                                    }
                                });
                                AppMethodBeat.o(45431);
                                return;
                            }
                        } else if (WalletBalanceManagerUI.this.thA.type == 2) {
                            e.n(WalletBalanceManagerUI.this.mController.ylL, WalletBalanceManagerUI.this.thA.kLE, true);
                            AppMethodBeat.o(45431);
                            return;
                        } else if (WalletBalanceManagerUI.this.thA.type == 3) {
                            e.p(WalletBalanceManagerUI.this.thA.tya, WalletBalanceManagerUI.this.thA.tyb, 0, FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
                            AppMethodBeat.o(45431);
                            return;
                        } else {
                            ab.w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", Integer.valueOf(WalletBalanceManagerUI.this.thA.type));
                        }
                        AppMethodBeat.o(45431);
                    }
                });
                this.thv.setVisibility(0);
            }
            cu();
            ceo();
        }
        AppMethodBeat.o(45451);
        return false;
    }

    public final void yq(int i) {
        AppMethodBeat.i(45452);
        s.cNC();
        this.thy = s.cND().thy;
        if (this.thy != null) {
            if (this.thy.twS >= 0.0d) {
                this.thr.setText(e.G(this.thy.twS));
                AppMethodBeat.o(45452);
                return;
            }
            this.thr.setText(getString(R.string.fg1));
        }
        AppMethodBeat.o(45452);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(45453);
        ab.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + intent.getIntExtra("from_bind_ui", 0));
        if (intent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.teT) {
            com.tencent.mm.wallet_core.a.a((Activity) this, b.class, null, null);
            e.QS(15);
        }
        AppMethodBeat.o(45453);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45442);
        this.yll = true;
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.a69));
        dyb();
        ((com.tencent.mm.plugin.walletlock.a.b) g.K(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45426);
                if (WalletBalanceManagerUI.a(WalletBalanceManagerUI.this)) {
                    WalletBalanceManagerUI.this.aqX();
                    WalletBalanceManagerUI.this.showDialog(1000);
                } else {
                    WalletBalanceManagerUI.this.finish();
                }
                AppMethodBeat.o(45426);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        this.gOW = getIntent().getIntExtra("key_scene_balance_manager", 0);
        bpt cPp = ECardInfo.cPp();
        if (cPp != null) {
            if (cPp.vAF == 1) {
                Bundle bundle2 = new Bundle();
                bwP();
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle2, null, 0);
            } else if (cPp.vAF == 3) {
                ECardInfo cPq = ECardInfo.cPq();
                if (cPq != null) {
                    com.tencent.mm.plugin.wallet_core.ui.m.a(this, cPq, 1);
                }
            }
        }
        nf(f.CTRL_INDEX);
        r.cPP();
        ae.a(this);
        initView();
        z.hL(2, 0);
        com.tencent.mm.plugin.report.service.h.pYm.e(11850, Integer.valueOf(6), Integer.valueOf(0));
        e.QS(10);
        AppMethodBeat.o(45442);
    }

    static /* synthetic */ void c(WalletBalanceManagerUI walletBalanceManagerUI) {
        AppMethodBeat.i(45455);
        com.tencent.mm.ui.base.h.a((Context) walletBalanceManagerUI, false, walletBalanceManagerUI.getString(R.string.f96), "", walletBalanceManagerUI.getString(R.string.f95), walletBalanceManagerUI.getString(R.string.or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45432);
                dialogInterface.dismiss();
                WalletBalanceManagerUI.f(WalletBalanceManagerUI.this);
                AppMethodBeat.o(45432);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45433);
                dialogInterface.dismiss();
                AppMethodBeat.o(45433);
            }
        });
        AppMethodBeat.o(45455);
    }

    static /* synthetic */ void f(WalletBalanceManagerUI walletBalanceManagerUI) {
        AppMethodBeat.i(45456);
        Bundle bundle = new Bundle();
        walletBalanceManagerUI.mBundle.get("key_pay_info");
        PayInfo payInfo = new PayInfo();
        payInfo.cIf = 21;
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.teT);
        com.tencent.mm.wallet_core.a.a((Activity) walletBalanceManagerUI, com.tencent.mm.plugin.wallet.balance.a.class, bundle, null);
        AppMethodBeat.o(45456);
    }
}
