package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Date;

public class WalletBankcardManageUI extends WalletBaseUI {
    private OnItemClickListener amz = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(45773);
            final Bankcard bankcard = (Bankcard) adapterView.getAdapter().getItem(i);
            e.QS(18);
            if (bankcard != null) {
                String str;
                a b = WalletBankcardManageUI.this.tlQ;
                if (b.tlo != null && !b.tlo.isEmpty()) {
                    for (String str2 : b.tlo) {
                        if (str2.equals(bankcard.field_bindSerial)) {
                            ab.d("MicroMsg.BankcardListAdapter", "remove new: %s", str2);
                            b.tlo.remove(str2);
                            g.RQ();
                            g.RP().Ry().set(a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, bo.c(b.tlo, ","));
                            break;
                        }
                    }
                }
                if (bankcard.cPb()) {
                    Bundle bundle;
                    if (bankcard.field_wxcreditState == 0) {
                        if (b.b(bankcard) && bankcard != null) {
                            g.RQ();
                            str2 = (String) g.RP().Ry().get(196659, null);
                            StringBuilder stringBuilder = new StringBuilder();
                            if (TextUtils.isEmpty(str2)) {
                                stringBuilder.append(bankcard.field_bankcardType);
                            } else {
                                stringBuilder.append(str2);
                                stringBuilder.append("&");
                                stringBuilder.append(bankcard.field_bankcardType);
                            }
                            g.RQ();
                            g.RP().Ry().set(196659, stringBuilder.toString());
                        }
                        bundle = new Bundle();
                        bundle.putParcelable("key_bankcard", bankcard);
                        bundle.putString("key_bank_username", bankcard.field_bizUsername);
                        bundle.putString("key_bank_type", bankcard.field_bankcardType);
                        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditOpenProcess", bundle, null);
                    } else {
                        bundle = new Bundle();
                        bundle.putParcelable("key_bankcard", bankcard);
                        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditManagerProcess", bundle, null);
                    }
                } else if (bankcard.cPg()) {
                    ab.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
                    Intent intent = new Intent();
                    intent.putExtra("key_card_no", bankcard.field_bindSerial);
                    d.b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", intent);
                } else {
                    ab.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", Boolean.valueOf((r.cPI().cQo().tCP & 4096) > 0), Integer.valueOf(r.cPI().cQo().tCP));
                    if ((r.cPI().cQo().tCP & 4096) > 0) {
                        ab.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                        g.RQ();
                        str2 = (String) g.RP().Ry().get(a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, (Object) "");
                        g.RQ();
                        long longValue = ((Long) g.RP().Ry().get(a.USERINFO_WALLET_BANKCARD_DETAIL_URL_TIMESTAMP_LONG_SYNC, Long.valueOf(0))).longValue();
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        if (bo.isNullOrNil(str2) || currentTimeMillis - longValue >= 7200) {
                            ab.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
                            com.tencent.mm.sdk.b.a.xxA.c(new c<ad>() {
                                public final /* synthetic */ boolean a(b bVar) {
                                    AppMethodBeat.i(45772);
                                    com.tencent.mm.sdk.b.a.xxA.d(this);
                                    ab.i("MicroMsg.WalletBankcardManageUI", "BankcardLogoReady,jump bank url");
                                    WalletBankcardManageUI.this.c(bankcard);
                                    AppMethodBeat.o(45772);
                                    return true;
                                }
                            });
                        } else {
                            ab.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                            WalletBankcardManageUI.this.c(bankcard);
                        }
                    } else {
                        WalletBankcardManageUI.this.d(bankcard);
                    }
                }
                h.pYm.e(14422, Integer.valueOf(1), bankcard.field_bankcardType);
                AppMethodBeat.o(45773);
                return;
            }
            WalletBankcardManageUI.this.cNv();
            h.pYm.e(14422, Integer.valueOf(2));
            AppMethodBeat.o(45773);
        }
    };
    private OnClickListener gKK = new OnClickListener() {
        final int tmc = 1000;

        public final void onClick(View view) {
            AppMethodBeat.i(45770);
            Intent intent;
            if (view.getId() == R.id.f82) {
                com.tencent.mm.plugin.wallet_core.model.g cPl = com.tencent.mm.plugin.wallet_core.model.g.cPl();
                if (cPl.aFF()) {
                    com.tencent.mm.ui.base.h.b(WalletBankcardManageUI.this, cPl.pbp, WalletBankcardManageUI.this.getString(R.string.tz), true);
                    AppMethodBeat.o(45770);
                    return;
                }
                e.QS(19);
                WalletBankcardManageUI.this.cNv();
                h.pYm.e(14422, Integer.valueOf(2));
                AppMethodBeat.o(45770);
            } else if (view.getId() == R.id.f88) {
                Object tag = view.getTag();
                long time = new Date().getTime();
                view.setTag(Long.valueOf(time));
                if (tag == null || time - ((Long) tag).longValue() >= 1000) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", WalletBankcardManageUI.this.tlY.field_loan_jump_url);
                    d.b(WalletBankcardManageUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    g.RQ();
                    g.RP().Ry().set(a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(WalletBankcardManageUI.this.tlY.field_red_dot_index));
                    e.QS(6);
                    AppMethodBeat.o(45770);
                    return;
                }
                AppMethodBeat.o(45770);
            } else {
                if (view.getId() == R.id.f8c) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
                    d.b(WalletBankcardManageUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    h.pYm.e(14422, Integer.valueOf(3));
                }
                AppMethodBeat.o(45770);
            }
        }
    };
    private ListView mListView = null;
    private s onl = new s();
    protected ArrayList<Bankcard> tlM = new ArrayList();
    private ArrayList<Bankcard> tlN = new ArrayList();
    protected ak tlO = null;
    private ListView tlP = null;
    private a tlQ = null;
    private a tlR = null;
    private TextView tlS;
    private View tlT;
    private View tlU;
    private View tlV;
    private CdnImageView tlW;
    private TextView tlX;
    private n tlY;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBankcardManageUI() {
        AppMethodBeat.i(45775);
        AppMethodBeat.o(45775);
    }

    public final int getLayoutId() {
        return R.layout.b3d;
    }

    public void onResume() {
        AppMethodBeat.i(45777);
        if (this.tlO.cQl()) {
            mV(true);
        } else {
            this.tlO.f(this.tlM, this.tlN);
            if (this.tlO.thy != null) {
                AM(0);
            }
            mV(false);
        }
        this.onl.onResume();
        cu();
        super.onResume();
        AppMethodBeat.o(45777);
    }

    public void onPause() {
        AppMethodBeat.i(45778);
        super.onPause();
        this.onl.onPause();
        AppMethodBeat.o(45778);
    }

    /* Access modifiers changed, original: protected */
    public void mV(boolean z) {
        AppMethodBeat.i(45779);
        if (z) {
            a(new y(null, 12), true, false);
            AppMethodBeat.o(45779);
            return;
        }
        a(new y(null, 12), false, false);
        AppMethodBeat.o(45779);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45780);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.onl.bNo();
                AppMethodBeat.o(45780);
                return;
            }
            this.onl.cancel();
        }
        AppMethodBeat.o(45780);
    }

    public void onDestroy() {
        AppMethodBeat.i(45781);
        super.onDestroy();
        this.tlQ.tln.destory();
        this.tlR.tln.destory();
        AppMethodBeat.o(45781);
    }

    public final void initView() {
        AppMethodBeat.i(45782);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45765);
                WalletBankcardManageUI.this.finish();
                h.pYm.e(14422, Integer.valueOf(4));
                AppMethodBeat.o(45765);
                return true;
            }
        });
        this.tlS = (TextView) findViewById(R.id.f87);
        this.tlS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45766);
                WalletBankcardManageUI.this.cNv();
                e.QS(19);
                h.pYm.e(14422, Integer.valueOf(2));
                AppMethodBeat.o(45766);
            }
        });
        this.mListView = (ListView) findViewById(R.id.f80);
        this.tlQ = cNu();
        this.mListView.setAdapter(this.tlQ);
        this.mListView.setOnItemClickListener(this.amz);
        this.tlP = (ListView) findViewById(R.id.f81);
        this.tlR = new a(this, this.tlN);
        this.tlP.setAdapter(this.tlR);
        this.tlP.setOnItemClickListener(this.amz);
        this.tlT = findViewById(R.id.f82);
        this.tlT.setOnClickListener(this.gKK);
        this.tlU = findViewById(R.id.f88);
        this.tlU.setOnClickListener(this.gKK);
        this.tlV = findViewById(R.id.f83);
        this.tlW = (CdnImageView) findViewById(R.id.f84);
        this.tlX = (TextView) findViewById(R.id.f85);
        cNt();
        findViewById(R.id.f8c).setOnClickListener(this.gKK);
        final uo uoVar = new uo();
        uoVar.cQJ.cQL = "4";
        uoVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(45767);
                if (bo.isNullOrNil(uoVar.cQK.cQM)) {
                    ab.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
                    AppMethodBeat.o(45767);
                    return;
                }
                e.a((TextView) WalletBankcardManageUI.this.findViewById(R.id.a2f), uoVar.cQK.cQM, uoVar.cQK.content, uoVar.cQK.url);
                AppMethodBeat.o(45767);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(uoVar);
        AppMethodBeat.o(45782);
    }

    private void cNt() {
        AppMethodBeat.i(45783);
        g.RQ();
        final f acw = f.acw((String) g.RP().Ry().get(a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, (Object) ""));
        if (!(acw == null || bo.isNullOrNil(acw.txz))) {
            if (!bo.isNullOrNil(acw.txA)) {
                this.tlW.setUrl(acw.txA);
            }
            this.tlX.setText(acw.txz);
            if (acw.txv == 1) {
                this.tlV.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45768);
                        if (!bo.isNullOrNil(acw.txw)) {
                            e.n(WalletBankcardManageUI.this.mController.ylL, acw.txw, false);
                        }
                        AppMethodBeat.o(45768);
                    }
                });
                this.tlV.setVisibility(0);
                AppMethodBeat.o(45783);
                return;
            } else if (acw.txv == 2) {
                this.tlV.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45769);
                        se seVar = new se();
                        seVar.cOf.userName = acw.txx;
                        seVar.cOf.cOh = bo.bc(acw.txy, "");
                        seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_LIULI;
                        seVar.cOf.cOi = 0;
                        com.tencent.mm.sdk.b.a.xxA.m(seVar);
                        AppMethodBeat.o(45769);
                    }
                });
                this.tlV.setVisibility(0);
                AppMethodBeat.o(45783);
                return;
            } else {
                ab.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", Integer.valueOf(acw.txv));
            }
        }
        this.tlV.setVisibility(8);
        AppMethodBeat.o(45783);
    }

    /* Access modifiers changed, original: protected */
    public a cNu() {
        AppMethodBeat.i(45784);
        a aVar = new a(this, this.tlM);
        AppMethodBeat.o(45784);
        return aVar;
    }

    public final void c(Bankcard bankcard) {
        AppMethodBeat.i(45785);
        g.RQ();
        String str = (String) g.RP().Ry().get(a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, (Object) "");
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
            AppMethodBeat.o(45785);
            return;
        }
        ab.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
        Intent intent = new Intent();
        String format = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[]{bankcard.field_bankcardType, bankcard.field_bankcardTail, bankcard.field_bindSerial});
        if (str.contains("?")) {
            str = str + "&" + format;
        } else {
            str = str + "?" + format;
        }
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("disable_bounce_scroll", true);
        d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(45785);
    }

    /* Access modifiers changed, original: protected */
    public void d(Bankcard bankcard) {
        AppMethodBeat.i(45786);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.bind.a.class, bundle, null);
        AppMethodBeat.o(45786);
    }

    private void cu() {
        AppMethodBeat.i(45787);
        if (this.tlO.cQl()) {
            this.tlS.setEnabled(false);
        } else {
            this.tlS.setEnabled(true);
        }
        if (this.tlM == null || this.tlM.size() <= 0) {
            this.mListView.setVisibility(8);
        } else {
            this.mListView.setVisibility(0);
        }
        if (this.tlN == null || this.tlN.size() <= 0) {
            this.tlP.setVisibility(8);
        } else {
            this.tlP.setVisibility(0);
        }
        if (this.tlY == null || this.tlY.field_is_show_entry != 1) {
            this.tlU.setVisibility(8);
        } else {
            ((TextView) this.tlU.findViewById(R.id.f8_)).setText(this.tlY.field_title);
            a(this.tlY);
            this.tlU.setVisibility(0);
        }
        this.tlQ.W(this.tlM);
        this.tlQ.notifyDataSetChanged();
        this.tlR.W(this.tlN);
        this.tlR.notifyDataSetChanged();
        this.tlS.setEnabled(true);
        AppMethodBeat.o(45787);
    }

    private void a(n nVar) {
        AppMethodBeat.i(45788);
        TextView textView = (TextView) findViewById(R.id.f8b);
        if (com.tencent.mm.plugin.wallet.b.a.Hn(nVar.field_red_dot_index)) {
            ab.i("MicroMsg.WalletBankcardManageUI", "red point update");
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        textView = (TextView) findViewById(R.id.f8a);
        if (nVar.field_is_overdue == 1) {
            ab.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
            textView.setText(R.string.f_o);
            textView.setTextColor(getResources().getColor(R.color.xy));
        } else if (!bo.isNullOrNil(nVar.field_tips)) {
            ab.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
            textView.setText(nVar.field_tips);
        } else if (bo.isNullOrNil(nVar.field_available_otb)) {
            textView.setVisibility(8);
            AppMethodBeat.o(45788);
            return;
        } else {
            ab.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
            int indexOf = nVar.field_available_otb.indexOf(".");
            String str = nVar.field_available_otb;
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
            }
            textView.setText(getString(R.string.f_n, new Object[]{str}));
        }
        textView.setVisibility(0);
        AppMethodBeat.o(45788);
    }

    /* Access modifiers changed, original: protected */
    public void cNv() {
        AppMethodBeat.i(45789);
        final Bundle bundle = new Bundle();
        final AnonymousClass10 anonymousClass10 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(45774);
                bundle.putInt("key_bind_scene", 15);
                bundle.putBoolean("key_bind_show_change_card", true);
                com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, null);
                AppMethodBeat.o(45774);
            }
        };
        this.onl.a(new s.a() {
            public final void bNo() {
                AppMethodBeat.i(45762);
                anonymousClass10.run();
                AppMethodBeat.o(45762);
            }

            public final void cancel() {
                AppMethodBeat.i(45763);
                WalletBankcardManageUI.this.onl.cui = false;
                AppMethodBeat.o(45763);
            }

            public final void bNp() {
                AppMethodBeat.i(45764);
                anonymousClass10.run();
                AppMethodBeat.o(45764);
            }
        }, new ai().cQe());
        AppMethodBeat.o(45789);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cNw() {
        AppMethodBeat.i(45790);
        AM(0);
        this.tlO.f(this.tlM, this.tlN);
        cu();
        cNt();
        AppMethodBeat.o(45790);
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45791);
        ab.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
        if (i == 0 && i2 == 0 && (mVar instanceof y)) {
            this.tlY = r.cPI().tCW;
            cNw();
            AppMethodBeat.o(45791);
            return true;
        }
        AppMethodBeat.o(45791);
        return false;
    }

    public final boolean bNf() {
        return false;
    }

    public void finish() {
        AppMethodBeat.i(45792);
        if (!getIntent().getBooleanExtra("intent_finish_self", false)) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            d.b((Context) this, "mall", ".ui.MallIndexUI", intent);
        }
        super.finish();
        AppMethodBeat.o(45792);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45776);
        this.yll = true;
        super.onCreate(bundle);
        AM(4);
        ab.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
        com.tencent.mm.plugin.wallet.a.s.cNC();
        this.tlO = com.tencent.mm.plugin.wallet.a.s.cND();
        setMMTitle((int) R.string.fgd);
        xE(this.mController.ylL.getResources().getColor(R.color.l8));
        dyb();
        initView();
        z.hL(5, 0);
        e.QS(27);
        this.tlY = r.cPI().tCW;
        this.onl.tLw = new s.b() {
            public final int bNq() {
                return 1;
            }

            public final Context getContext() {
                return WalletBankcardManageUI.this;
            }
        };
        AppMethodBeat.o(45776);
    }
}
