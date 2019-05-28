package com.tencent.p177mm.plugin.wallet.bind.p553ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32511ad;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.bind.C41325a;
import com.tencent.p177mm.plugin.wallet.p1658b.C46333a;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.C29629ai;
import com.tencent.p177mm.plugin.wallet_core.model.C40114n;
import com.tencent.p177mm.plugin.wallet_core.model.C43808f;
import com.tencent.p177mm.plugin.wallet_core.model.C43809g;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s.C7187a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s.C7188b;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Date;

/* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI */
public class WalletBankcardManageUI extends WalletBaseUI {
    private OnItemClickListener amz = new C354419();
    private OnClickListener gKK = new C354408();
    private ListView mListView = null;
    private C7186s onl = new C7186s();
    protected ArrayList<Bankcard> tlM = new ArrayList();
    private ArrayList<Bankcard> tlN = new ArrayList();
    protected C22587ak tlO = null;
    private ListView tlP = null;
    private C29591a tlQ = null;
    private C29591a tlR = null;
    private TextView tlS;
    private View tlT;
    private View tlU;
    private View tlV;
    private CdnImageView tlW;
    private TextView tlX;
    private C40114n tlY;

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI$1 */
    class C225221 implements C7188b {
        C225221() {
        }

        public final int bNq() {
            return 1;
        }

        public final Context getContext() {
            return WalletBankcardManageUI.this;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI$3 */
    class C225243 implements OnMenuItemClickListener {
        C225243() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45765);
            WalletBankcardManageUI.this.finish();
            C7060h.pYm.mo8381e(14422, Integer.valueOf(4));
            AppMethodBeat.m2505o(45765);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI$4 */
    class C225254 implements OnClickListener {
        C225254() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45766);
            WalletBankcardManageUI.this.cNv();
            C36391e.m59978QS(19);
            C7060h.pYm.mo8381e(14422, Integer.valueOf(2));
            AppMethodBeat.m2505o(45766);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI$8 */
    class C354408 implements OnClickListener {
        final int tmc = 1000;

        C354408() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45770);
            Intent intent;
            if (view.getId() == 2131828685) {
                C43809g cPl = C43809g.cPl();
                if (cPl.aFF()) {
                    C30379h.m48461b(WalletBankcardManageUI.this, cPl.pbp, WalletBankcardManageUI.this.getString(C25738R.string.f9238tz), true);
                    AppMethodBeat.m2505o(45770);
                    return;
                }
                C36391e.m59978QS(19);
                WalletBankcardManageUI.this.cNv();
                C7060h.pYm.mo8381e(14422, Integer.valueOf(2));
                AppMethodBeat.m2505o(45770);
            } else if (view.getId() == 2131828691) {
                Object tag = view.getTag();
                long time = new Date().getTime();
                view.setTag(Long.valueOf(time));
                if (tag == null || time - ((Long) tag).longValue() >= 1000) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", WalletBankcardManageUI.this.tlY.field_loan_jump_url);
                    C25985d.m41467b(WalletBankcardManageUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(WalletBankcardManageUI.this.tlY.field_red_dot_index));
                    C36391e.m59978QS(6);
                    AppMethodBeat.m2505o(45770);
                    return;
                }
                AppMethodBeat.m2505o(45770);
            } else {
                if (view.getId() == 2131828696) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
                    C25985d.m41467b(WalletBankcardManageUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    C7060h.pYm.mo8381e(14422, Integer.valueOf(3));
                }
                AppMethodBeat.m2505o(45770);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI$9 */
    class C354419 implements OnItemClickListener {
        C354419() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(45773);
            final Bankcard bankcard = (Bankcard) adapterView.getAdapter().getItem(i);
            C36391e.m59978QS(18);
            if (bankcard != null) {
                String str;
                C29591a b = WalletBankcardManageUI.this.tlQ;
                if (b.tlo != null && !b.tlo.isEmpty()) {
                    for (String str2 : b.tlo) {
                        if (str2.equals(bankcard.field_bindSerial)) {
                            C4990ab.m7411d("MicroMsg.BankcardListAdapter", "remove new: %s", str2);
                            b.tlo.remove(str2);
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, C5046bo.m7536c(b.tlo, ","));
                            break;
                        }
                    }
                }
                if (bankcard.cPb()) {
                    Bundle bundle;
                    if (bankcard.field_wxcreditState == 0) {
                        if (C22528b.m34221b(bankcard) && bankcard != null) {
                            C1720g.m3537RQ();
                            str2 = (String) C1720g.m3536RP().mo5239Ry().get(196659, null);
                            StringBuilder stringBuilder = new StringBuilder();
                            if (TextUtils.isEmpty(str2)) {
                                stringBuilder.append(bankcard.field_bankcardType);
                            } else {
                                stringBuilder.append(str2);
                                stringBuilder.append("&");
                                stringBuilder.append(bankcard.field_bankcardType);
                            }
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(196659, stringBuilder.toString());
                        }
                        bundle = new Bundle();
                        bundle.putParcelable("key_bankcard", bankcard);
                        bundle.putString("key_bank_username", bankcard.field_bizUsername);
                        bundle.putString("key_bank_type", bankcard.field_bankcardType);
                        C24143a.m37107a(WalletBankcardManageUI.this, "WXCreditOpenProcess", bundle, null);
                    } else {
                        bundle = new Bundle();
                        bundle.putParcelable("key_bankcard", bankcard);
                        C24143a.m37107a(WalletBankcardManageUI.this, "WXCreditManagerProcess", bundle, null);
                    }
                } else if (bankcard.cPg()) {
                    C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
                    Intent intent = new Intent();
                    intent.putExtra("key_card_no", bankcard.field_bindSerial);
                    C25985d.m41467b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", intent);
                } else {
                    C4990ab.m7417i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", Boolean.valueOf((C14241r.cPI().cQo().tCP & 4096) > 0), Integer.valueOf(C14241r.cPI().cQo().tCP));
                    if ((C14241r.cPI().cQo().tCP & 4096) > 0) {
                        C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                        C1720g.m3537RQ();
                        str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, (Object) "");
                        C1720g.m3537RQ();
                        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BANKCARD_DETAIL_URL_TIMESTAMP_LONG_SYNC, Long.valueOf(0))).longValue();
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        if (C5046bo.isNullOrNil(str2) || currentTimeMillis - longValue >= 7200) {
                            C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
                            C4879a.xxA.mo10052c(new C4884c<C32511ad>() {
                                /* renamed from: a */
                                public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                                    AppMethodBeat.m2504i(45772);
                                    C4879a.xxA.mo10053d(this);
                                    C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "BankcardLogoReady,jump bank url");
                                    WalletBankcardManageUI.this.mo56177c(bankcard);
                                    AppMethodBeat.m2505o(45772);
                                    return true;
                                }
                            });
                        } else {
                            C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                            WalletBankcardManageUI.this.mo56177c(bankcard);
                        }
                    } else {
                        WalletBankcardManageUI.this.mo38272d(bankcard);
                    }
                }
                C7060h.pYm.mo8381e(14422, Integer.valueOf(1), bankcard.field_bankcardType);
                AppMethodBeat.m2505o(45773);
                return;
            }
            WalletBankcardManageUI.this.cNv();
            C7060h.pYm.mo8381e(14422, Integer.valueOf(2));
            AppMethodBeat.m2505o(45773);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletBankcardManageUI() {
        AppMethodBeat.m2504i(45775);
        AppMethodBeat.m2505o(45775);
    }

    public final int getLayoutId() {
        return 2130971066;
    }

    public void onResume() {
        AppMethodBeat.m2504i(45777);
        if (this.tlO.cQl()) {
            mo38273mV(true);
        } else {
            this.tlO.mo38169f(this.tlM, this.tlN);
            if (this.tlO.thy != null) {
                mo9439AM(0);
            }
            mo38273mV(false);
        }
        this.onl.onResume();
        m58167cu();
        super.onResume();
        AppMethodBeat.m2505o(45777);
    }

    public void onPause() {
        AppMethodBeat.m2504i(45778);
        super.onPause();
        this.onl.onPause();
        AppMethodBeat.m2505o(45778);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: mV */
    public void mo38273mV(boolean z) {
        AppMethodBeat.m2504i(45779);
        if (z) {
            mo39970a(new C35475y(null, 12), true, false);
            AppMethodBeat.m2505o(45779);
            return;
        }
        mo39970a(new C35475y(null, 12), false, false);
        AppMethodBeat.m2505o(45779);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45780);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.onl.bNo();
                AppMethodBeat.m2505o(45780);
                return;
            }
            this.onl.cancel();
        }
        AppMethodBeat.m2505o(45780);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45781);
        super.onDestroy();
        this.tlQ.tln.destory();
        this.tlR.tln.destory();
        AppMethodBeat.m2505o(45781);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45782);
        setBackBtn(new C225243());
        this.tlS = (TextView) findViewById(2131828690);
        this.tlS.setOnClickListener(new C225254());
        this.mListView = (ListView) findViewById(2131828683);
        this.tlQ = cNu();
        this.mListView.setAdapter(this.tlQ);
        this.mListView.setOnItemClickListener(this.amz);
        this.tlP = (ListView) findViewById(2131828684);
        this.tlR = new C29591a(this, this.tlN);
        this.tlP.setAdapter(this.tlR);
        this.tlP.setOnItemClickListener(this.amz);
        this.tlT = findViewById(2131828685);
        this.tlT.setOnClickListener(this.gKK);
        this.tlU = findViewById(2131828691);
        this.tlU.setOnClickListener(this.gKK);
        this.tlV = findViewById(2131828686);
        this.tlW = (CdnImageView) findViewById(2131828687);
        this.tlX = (TextView) findViewById(2131828688);
        cNt();
        findViewById(2131828696).setOnClickListener(this.gKK);
        final C37807uo c37807uo = new C37807uo();
        c37807uo.cQJ.cQL = "4";
        c37807uo.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(45767);
                if (C5046bo.isNullOrNil(c37807uo.cQK.cQM)) {
                    C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
                    AppMethodBeat.m2505o(45767);
                    return;
                }
                C36391e.m59985a((TextView) WalletBankcardManageUI.this.findViewById(2131821634), c37807uo.cQK.cQM, c37807uo.cQK.content, c37807uo.cQK.url);
                AppMethodBeat.m2505o(45767);
            }
        };
        C4879a.xxA.mo10055m(c37807uo);
        AppMethodBeat.m2505o(45782);
    }

    private void cNt() {
        AppMethodBeat.m2504i(45783);
        C1720g.m3537RQ();
        final C43808f acw = C43808f.acw((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, (Object) ""));
        if (!(acw == null || C5046bo.isNullOrNil(acw.txz))) {
            if (!C5046bo.isNullOrNil(acw.txA)) {
                this.tlW.setUrl(acw.txA);
            }
            this.tlX.setText(acw.txz);
            if (acw.txv == 1) {
                this.tlV.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(45768);
                        if (!C5046bo.isNullOrNil(acw.txw)) {
                            C36391e.m60016n(WalletBankcardManageUI.this.mController.ylL, acw.txw, false);
                        }
                        AppMethodBeat.m2505o(45768);
                    }
                });
                this.tlV.setVisibility(0);
                AppMethodBeat.m2505o(45783);
                return;
            } else if (acw.txv == 2) {
                this.tlV.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(45769);
                        C32628se c32628se = new C32628se();
                        c32628se.cOf.userName = acw.txx;
                        c32628se.cOf.cOh = C5046bo.m7532bc(acw.txy, "");
                        c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_LIULI;
                        c32628se.cOf.cOi = 0;
                        C4879a.xxA.mo10055m(c32628se);
                        AppMethodBeat.m2505o(45769);
                    }
                });
                this.tlV.setVisibility(0);
                AppMethodBeat.m2505o(45783);
                return;
            } else {
                C4990ab.m7421w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", Integer.valueOf(acw.txv));
            }
        }
        this.tlV.setVisibility(8);
        AppMethodBeat.m2505o(45783);
    }

    /* Access modifiers changed, original: protected */
    public C29591a cNu() {
        AppMethodBeat.m2504i(45784);
        C29591a c29591a = new C29591a(this, this.tlM);
        AppMethodBeat.m2505o(45784);
        return c29591a;
    }

    /* renamed from: c */
    public final void mo56177c(Bankcard bankcard) {
        AppMethodBeat.m2504i(45785);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, (Object) "");
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
            AppMethodBeat.m2505o(45785);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
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
        C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(45785);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: d */
    public void mo38272d(Bankcard bankcard) {
        AppMethodBeat.m2504i(45786);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        C24143a.m37106a((Activity) this, C41325a.class, bundle, null);
        AppMethodBeat.m2505o(45786);
    }

    /* renamed from: cu */
    private void m58167cu() {
        AppMethodBeat.m2504i(45787);
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
            ((TextView) this.tlU.findViewById(2131828693)).setText(this.tlY.field_title);
            m58164a(this.tlY);
            this.tlU.setVisibility(0);
        }
        this.tlQ.mo47835W(this.tlM);
        this.tlQ.notifyDataSetChanged();
        this.tlR.mo47835W(this.tlN);
        this.tlR.notifyDataSetChanged();
        this.tlS.setEnabled(true);
        AppMethodBeat.m2505o(45787);
    }

    /* renamed from: a */
    private void m58164a(C40114n c40114n) {
        AppMethodBeat.m2504i(45788);
        TextView textView = (TextView) findViewById(2131828695);
        if (C46333a.m87050Hn(c40114n.field_red_dot_index)) {
            C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "red point update");
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        textView = (TextView) findViewById(2131828694);
        if (c40114n.field_is_overdue == 1) {
            C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
            textView.setText(C25738R.string.f_o);
            textView.setTextColor(getResources().getColor(C25738R.color.f12266xy));
        } else if (!C5046bo.isNullOrNil(c40114n.field_tips)) {
            C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
            textView.setText(c40114n.field_tips);
        } else if (C5046bo.isNullOrNil(c40114n.field_available_otb)) {
            textView.setVisibility(8);
            AppMethodBeat.m2505o(45788);
            return;
        } else {
            C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
            int indexOf = c40114n.field_available_otb.indexOf(".");
            String str = c40114n.field_available_otb;
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
            }
            textView.setText(getString(C25738R.string.f_n, new Object[]{str}));
        }
        textView.setVisibility(0);
        AppMethodBeat.m2505o(45788);
    }

    /* Access modifiers changed, original: protected */
    public void cNv() {
        AppMethodBeat.m2504i(45789);
        final Bundle bundle = new Bundle();
        final C435210 c435210 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(45774);
                bundle.putInt("key_bind_scene", 15);
                bundle.putBoolean("key_bind_show_change_card", true);
                C24143a.m37106a(WalletBankcardManageUI.this, C29615b.class, bundle, null);
                AppMethodBeat.m2505o(45774);
            }
        };
        this.onl.mo15494a(new C7187a() {
            public final void bNo() {
                AppMethodBeat.m2504i(45762);
                c435210.run();
                AppMethodBeat.m2505o(45762);
            }

            public final void cancel() {
                AppMethodBeat.m2504i(45763);
                WalletBankcardManageUI.this.onl.cui = false;
                AppMethodBeat.m2505o(45763);
            }

            public final void bNp() {
                AppMethodBeat.m2504i(45764);
                c435210.run();
                AppMethodBeat.m2505o(45764);
            }
        }, new C29629ai().cQe());
        AppMethodBeat.m2505o(45789);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cNw() {
        AppMethodBeat.m2504i(45790);
        mo9439AM(0);
        this.tlO.mo38169f(this.tlM, this.tlN);
        m58167cu();
        cNt();
        AppMethodBeat.m2505o(45790);
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45791);
        C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
        if (i == 0 && i2 == 0 && (c1207m instanceof C35475y)) {
            this.tlY = C14241r.cPI().tCW;
            cNw();
            AppMethodBeat.m2505o(45791);
            return true;
        }
        AppMethodBeat.m2505o(45791);
        return false;
    }

    public final boolean bNf() {
        return false;
    }

    public void finish() {
        AppMethodBeat.m2504i(45792);
        if (!getIntent().getBooleanExtra("intent_finish_self", false)) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            C25985d.m41467b((Context) this, "mall", ".ui.MallIndexUI", intent);
        }
        super.finish();
        AppMethodBeat.m2505o(45792);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45776);
        this.yll = true;
        super.onCreate(bundle);
        mo9439AM(4);
        C4990ab.m7416i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
        C46332s.cNC();
        this.tlO = C46332s.cND();
        setMMTitle((int) C25738R.string.fgd);
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.f11906l8));
        dyb();
        initView();
        C36381z.m59954hL(5, 0);
        C36391e.m59978QS(27);
        this.tlY = C14241r.cPI().tCW;
        this.onl.tLw = new C225221();
        AppMethodBeat.m2505o(45776);
    }
}
