package com.tencent.p177mm.plugin.wallet.balance.p552ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.weishi.C2509f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.balance.C41322b;
import com.tencent.p177mm.plugin.wallet.balance.C43761a;
import com.tencent.p177mm.plugin.wallet.balance.p550a.C14115a;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14103ab;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35397l;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4314r;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.WalletLqtDetailUI;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.p177mm.plugin.wallet.bind.p1311a.C29586b;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.id_verify.C40105a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.C29629ai;
import com.tencent.p177mm.plugin.wallet_core.model.C29633l;
import com.tencent.p177mm.plugin.wallet_core.model.C43803ae;
import com.tencent.p177mm.plugin.wallet_core.model.C46366h;
import com.tencent.p177mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22627m;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e.C355189;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e.C355218;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C23370ba;
import com.tencent.p177mm.protocal.protobuf.C44191xg;
import com.tencent.p177mm.protocal.protobuf.C46524az;
import com.tencent.p177mm.protocal.protobuf.aew;
import com.tencent.p177mm.protocal.protobuf.bnr;
import com.tencent.p177mm.protocal.protobuf.bpt;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.app.C40919c;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI */
public class WalletBalanceManagerUI extends WalletBaseUI implements C29633l {
    protected int gOW;
    protected TextView tgH;
    private C46366h thA;
    private C14115a thB;
    protected TextView thr;
    protected Button ths;
    protected View tht;
    protected TextView thu;
    private ViewGroup thv;
    private TextView thw;
    private ImageView thx;
    protected Bankcard thy;
    private C23370ba thz;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$6 */
    class C43226 implements OnClickListener {
        C43226() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45433);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(45433);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$9 */
    class C43239 implements View.OnClickListener {
        C43239() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45436);
            C46332s.cNC();
            ArrayList cQD = C46332s.cND().cQD();
            if (cQD == null || cQD.size() == 0) {
                C4990ab.m7416i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
                WalletBalanceManagerUI.m38817c(WalletBalanceManagerUI.this);
                AppMethodBeat.m2505o(45436);
                return;
            }
            C4990ab.m7416i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
            C24143a.m37106a(WalletBalanceManagerUI.this, C41322b.class, null, null);
            C36391e.m59978QS(15);
            AppMethodBeat.m2505o(45436);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$7 */
    class C71807 implements C5681a<Object, C37441a<aew>> {
        C71807() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45434);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.WalletBalanceManagerUI", "errCode: %s, errType: %s", Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                WalletBalanceManagerUI.this.thz = ((aew) c37441a.fsy).wmy;
                WalletBalanceManagerUI.this.ceo();
            }
            WalletBalanceManagerUI.this.thB = null;
            AppMethodBeat.m2505o(45434);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$8 */
    class C141288 implements View.OnClickListener {
        C141288() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45435);
            WalletBalanceManagerUI.this.cNa();
            C36391e.m59978QS(14);
            AppMethodBeat.m2505o(45435);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$10 */
    class C2250510 implements View.OnClickListener {
        C2250510() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45437);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            C25985d.m41467b(WalletBalanceManagerUI.this, "webview", ".ui.tools.WebViewUI", intent);
            C36391e.m59978QS(17);
            AppMethodBeat.m2505o(45437);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$2 */
    class C248492 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$2$1 */
        class C225061 implements C5279d {
            C225061() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(45427);
                if (i < WalletBalanceManagerUI.this.thz.vCQ.size()) {
                    C46524az c46524az = (C46524az) WalletBalanceManagerUI.this.thz.vCQ.get(i);
                    if (c46524az.vCP != null) {
                        if (c46524az.vCP.type == 1) {
                            C7060h.pYm.mo8381e(16503, Integer.valueOf(2), c46524az.vCP.url);
                            AppMethodBeat.m2505o(45427);
                            return;
                        } else if (c46524az.vCP.type == 2) {
                            C7060h.pYm.mo8381e(16503, Integer.valueOf(3), c46524az.vCP.wVC.username);
                            AppMethodBeat.m2505o(45427);
                            return;
                        } else if (c46524az.vCP.type == 5) {
                            C7060h.pYm.mo8381e(16503, Integer.valueOf(4), c46524az.vCP.url);
                        }
                    }
                }
                AppMethodBeat.m2505o(45427);
            }
        }

        C248492() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45428);
            C36356d c36356d = new C36356d(WalletBalanceManagerUI.this.mController.ylL, 1, false);
            AppCompatActivity appCompatActivity = WalletBalanceManagerUI.this.mController.ylL;
            C23370ba d = WalletBalanceManagerUI.this.thz;
            C225061 c225061 = new C225061();
            if (!(d == null || d.vCQ == null || d.vCQ.isEmpty())) {
                c36356d.rBl = new C355218(d, appCompatActivity);
                c36356d.rBm = new C355189(d, appCompatActivity, c225061);
            }
            c36356d.cpD();
            C7060h.pYm.mo8381e(16503, Integer.valueOf(1));
            AppMethodBeat.m2505o(45428);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$3 */
    class C248503 implements OnMenuItemClickListener {
        C248503() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45429);
            Intent intent = new Intent();
            if (C5046bo.isNullOrNil(WalletBalanceManagerUI.this.thy.twW)) {
                intent.putExtra("rawUrl", WalletBalanceManagerUI.this.thy.twV);
            } else {
                C4990ab.m7417i("MicroMsg.WalletBalanceManagerUI", "carson: entry_url: %s", WalletBalanceManagerUI.this.thy.twW);
                intent.putExtra("rawUrl", WalletBalanceManagerUI.this.thy.twW);
            }
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", C1853r.m3846Yz());
            intent.putExtra("KPublisherId", "pay_blance_list");
            intent.putExtra("geta8key_scene", 33);
            C25985d.m41467b(WalletBalanceManagerUI.this, "webview", ".ui.tools.WebViewUI", intent);
            C36391e.m59978QS(16);
            C7060h.pYm.mo8381e(16503, Integer.valueOf(1), "balanceBill");
            AppMethodBeat.m2505o(45429);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$4 */
    class C248514 implements View.OnClickListener {
        C248514() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45431);
            C4990ab.m7416i("MicroMsg.WalletBalanceManagerUI", "click action entry");
            if (WalletBalanceManagerUI.this.thA.type == 1) {
                if (C5046bo.isNullOrNil(WalletBalanceManagerUI.this.thA.txZ)) {
                    AppMethodBeat.m2505o(45431);
                    return;
                } else if (WalletBalanceManagerUI.this.thA.txZ.startsWith("weixin://wcpay/lqt/detail")) {
                    C14103ab.parseUrl(WalletBalanceManagerUI.this.thA.txZ);
                    Intent intent = new Intent();
                    intent.putExtra("key_account_type", 1);
                    C25985d.m41467b(WalletBalanceManagerUI.this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                    AppMethodBeat.m2505o(45431);
                    return;
                } else if (WalletBalanceManagerUI.this.thA.txZ.startsWith("weixin://wcpay/lqt/save")) {
                    C14103ab.parseUrl(WalletBalanceManagerUI.this.thA.txZ);
                    final String aci = C14103ab.aci(WalletBalanceManagerUI.this.thA.txZ);
                    final Dialog b = C30901g.m49318b(WalletBalanceManagerUI.this.mController.ylL, false, null);
                    new C35397l().acy().mo60487b(new C5681a<Void, C37441a<bnr>>() {
                        public final /* synthetic */ Object call(Object obj) {
                            boolean z = true;
                            AppMethodBeat.m2504i(45430);
                            C37441a c37441a = (C37441a) obj;
                            C4990ab.m7417i("MicroMsg.WalletBalanceManagerUI", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
                            b.dismiss();
                            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                                bnr bnr = (bnr) c37441a.fsy;
                                C4990ab.m7417i("MicroMsg.WalletBalanceManagerUI", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(bnr.kdT), bnr.kdU);
                                if (bnr.kdT == 0) {
                                    boolean z2;
                                    C14103ab.ach(bnr.tgu);
                                    ArrayList arrayList = new ArrayList();
                                    if (bnr.wQx != null && bnr.wQx.size() > 0) {
                                        Iterator it = bnr.wQx.iterator();
                                        while (it.hasNext()) {
                                            C44191xg c44191xg = (C44191xg) it.next();
                                            if (!(C5046bo.isNullOrNil(c44191xg.title) || C5046bo.isNullOrNil(c44191xg.wdd))) {
                                                arrayList.add(String.format("%s||%s", new Object[]{c44191xg.title, c44191xg.wdd}));
                                            }
                                        }
                                    }
                                    ((C4314r) new C40919c().mo64541a(WalletBalanceManagerUI.this.mController.ylL, C4314r.class)).tfF.mo9336ge(bnr.wao, 3);
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
                            AppMethodBeat.m2505o(45430);
                            return voidR;
                        }
                    });
                    AppMethodBeat.m2505o(45431);
                    return;
                }
            } else if (WalletBalanceManagerUI.this.thA.type == 2) {
                C36391e.m60016n(WalletBalanceManagerUI.this.mController.ylL, WalletBalanceManagerUI.this.thA.kLE, true);
                AppMethodBeat.m2505o(45431);
                return;
            } else if (WalletBalanceManagerUI.this.thA.type == 3) {
                C36391e.m60018p(WalletBalanceManagerUI.this.thA.tya, WalletBalanceManagerUI.this.thA.tyb, 0, FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
                AppMethodBeat.m2505o(45431);
                return;
            } else {
                C4990ab.m7421w("MicroMsg.WalletBalanceManagerUI", "unknown type: %s", Integer.valueOf(WalletBalanceManagerUI.this.thA.type));
            }
            AppMethodBeat.m2505o(45431);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$5 */
    class C248535 implements OnClickListener {
        C248535() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45432);
            dialogInterface.dismiss();
            WalletBalanceManagerUI.m38820f(WalletBalanceManagerUI.this);
            AppMethodBeat.m2505o(45432);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$12 */
    class C2485412 implements View.OnClickListener {
        C2485412() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45439);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
            Bundle bundle = new Bundle();
            bundle.putInt("real_name_verify_mode", 0);
            bundle.putString("realname_verify_process_jump_plugin", "wallet");
            bundle.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
            bundle.putInt("entry_scene", 1009);
            C24143a.m37105a(WalletBalanceManagerUI.this, C40105a.class, bundle);
            AppMethodBeat.m2505o(45439);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$13 */
    class C2485513 implements View.OnClickListener {
        C2485513() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45440);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
            Intent intent = new Intent(WalletBalanceManagerUI.this, WalletLqtDetailUI.class);
            intent.putExtra("key_account_type", 1);
            WalletBalanceManagerUI.this.startActivity(intent);
            AppMethodBeat.m2505o(45440);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI$1 */
    class C248561 implements OnMenuItemClickListener {
        C248561() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45426);
            if (WalletBalanceManagerUI.m38815a(WalletBalanceManagerUI.this)) {
                WalletBalanceManagerUI.this.aqX();
                WalletBalanceManagerUI.this.showDialog(1000);
            } else {
                WalletBalanceManagerUI.this.finish();
            }
            AppMethodBeat.m2505o(45426);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m38815a(WalletBalanceManagerUI walletBalanceManagerUI) {
        AppMethodBeat.m2504i(45454);
        boolean cNR = walletBalanceManagerUI.cNR();
        AppMethodBeat.m2505o(45454);
        return cNR;
    }

    public final int getLayoutId() {
        return 2130971049;
    }

    /* Access modifiers changed, original: protected */
    public void cMZ() {
        boolean z;
        AppMethodBeat.m2504i(45443);
        C46332s.cNC();
        if (C46332s.cND().thy == null) {
            z = true;
        } else {
            z = false;
        }
        mo39970a(new C35475y(null, 10), z, false);
        AppMethodBeat.m2505o(45443);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45444);
        mo39993ng(C2509f.CTRL_INDEX);
        C14241r.cPP();
        C43803ae.m78512b(this);
        this.thB = null;
        super.onDestroy();
        AppMethodBeat.m2505o(45444);
    }

    /* Access modifiers changed, original: protected */
    public void cNa() {
        AppMethodBeat.m2504i(45445);
        mo17383aA(WalletBalanceSaveUI.class);
        AppMethodBeat.m2505o(45445);
    }

    public final void initView() {
        boolean gT;
        AppMethodBeat.m2504i(45446);
        setMMTitle("");
        this.thr = (TextView) findViewById(2131828620);
        this.tgH = (TextView) findViewById(2131828605);
        ((Button) findViewById(2131822846)).setOnClickListener(new C141288());
        this.ths = (Button) findViewById(2131828624);
        this.ths.setOnClickListener(new C43239());
        TextView textView = (TextView) findViewById(2131828627);
        if (C4988aa.dor().equals("zh_CN")) {
            gT = C5046bo.m7558gT(C4996ah.getContext());
        } else {
            gT = true;
        }
        if (gT) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new C2250510());
            textView.setVisibility(0);
        }
        ((TextView) findViewById(2131828628)).setText(C44423ae.dOc());
        this.thv = (ViewGroup) findViewById(2131828621);
        this.thw = (TextView) findViewById(2131828622);
        this.thx = (ImageView) findViewById(2131828623);
        this.tht = findViewById(2131828625);
        this.thu = (TextView) findViewById(2131828626);
        final C37807uo c37807uo = new C37807uo();
        c37807uo.cQJ.cQL = "2";
        c37807uo.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(45438);
                if (!C5046bo.isNullOrNil(c37807uo.cQK.cQM)) {
                    C36391e.m59985a(WalletBalanceManagerUI.this.tgH, c37807uo.cQK.cQM, c37807uo.cQK.content, c37807uo.cQK.url);
                }
                AppMethodBeat.m2505o(45438);
            }
        };
        C4879a.xxA.mo10055m(c37807uo);
        AppMethodBeat.m2505o(45446);
    }

    public void onResume() {
        AppMethodBeat.m2504i(45447);
        mo41703cu();
        cMZ();
        C4990ab.m7416i("MicroMsg.WalletBalanceManagerUI", "do query balance menu");
        if (this.thB != null) {
            this.thB.cancel();
        }
        this.thB = new C14115a();
        this.thB.acy().mo60487b(new C71807());
        super.onResume();
        C40167b c40167b = (C40167b) C1720g.m3528K(C40167b.class);
        c40167b.mo38287a(this, c40167b.cTi(), null);
        AppMethodBeat.m2505o(45447);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: cu */
    public final void mo41703cu() {
        AppMethodBeat.m2504i(45448);
        C46332s.cNC();
        this.thy = C46332s.cND().thy;
        if (this.thy != null) {
            if (this.thy.twS >= 0.0d) {
                this.thr.setText(C36391e.m59972G(this.thy.twS));
            } else {
                this.thr.setText(getString(C25738R.string.fg1));
            }
            if (cNb()) {
                this.ths.setVisibility(0);
            } else {
                this.ths.setVisibility(8);
            }
        }
        View findViewById = findViewById(2131825786);
        C1720g.m3537RQ();
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1))).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        if (new C29629ai().cQd()) {
            C1720g.m3537RQ();
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_RELEAY_NAME_TIP_CONTENT_STRING_SYNC, getString(C25738R.string.dim));
            this.tht.setVisibility(0);
            this.thu.setTextColor(getResources().getColor(C25738R.color.a4_));
            this.thu.setText(str);
            this.tht.setOnClickListener(new C2485412());
            AppMethodBeat.m2505o(45448);
            return;
        }
        C46332s.cNC();
        boolean z = C46332s.cND().cQN() == 1;
        C46332s.cNC();
        String cQO = C46332s.cND().cQO();
        C46332s.cNC();
        C4990ab.m7417i("MicroMsg.WalletBalanceManagerUI", "isShowLqtCell:%s lqtCellTitle:%s lqtCellWording:%s", Boolean.valueOf(z), cQO, C46332s.cND().cQP());
        if (!z || (C5046bo.isNullOrNil(cQO) && C5046bo.isNullOrNil(r4))) {
            C46332s.cNC();
            if (C46332s.cND().cQw()) {
                this.tht.setVisibility(0);
                this.tht.setOnClickListener(new C2485513());
                TextView textView = this.thu;
                C46332s.cNC();
                textView.setText(C46332s.cND().cQs());
                AppMethodBeat.m2505o(45448);
                return;
            }
            C46332s.cNC();
            final C22587ak cND = C46332s.cND();
            if (cND == null || !cND.cQo().cPZ() || TextUtils.isEmpty(cND.cQs()) || TextUtils.isEmpty(cND.cQt())) {
                this.tht.setVisibility(8);
            } else {
                this.tht.setVisibility(0);
                this.thu.setText(cND.cQs());
                this.tht.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(45441);
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
                        C36391e.m60016n(WalletBalanceManagerUI.this, cND.cQt(), true);
                        AppMethodBeat.m2505o(45441);
                    }
                });
                AppMethodBeat.m2505o(45448);
                return;
            }
        }
        AppMethodBeat.m2505o(45448);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ceo() {
        AppMethodBeat.m2504i(45449);
        if (this.thz == null) {
            C4990ab.m7420w("MicroMsg.WalletBalanceManagerUI", "actionsheet is null");
            AppMethodBeat.m2505o(45449);
            return;
        }
        boolean optBoolean;
        this.mController.removeAllOptionMenu();
        try {
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, (Object) "");
            if (!C5046bo.isNullOrNil(str)) {
                optBoolean = new JSONObject(str).optBoolean("is_show_menu", false);
                if (optBoolean) {
                    C4990ab.m7416i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
                    if (this.thy != null) {
                        C46332s.cNC();
                        C46332s.cND();
                        if (!C5046bo.isNullOrNil(this.thy.twV)) {
                            str = getString(C25738R.string.f99);
                            if (!C5046bo.isNullOrNil(this.thy.twX)) {
                                C4990ab.m7417i("MicroMsg.WalletBalanceManagerUI", "carson: entry_word：%s", this.thy.twX);
                                str = this.thy.twX;
                            }
                            mo39972a(str, (OnMenuItemClickListener) new C248503(), C5535b.TRANSPARENT_BG_BLACK_TEXT);
                        }
                    }
                    AppMethodBeat.m2505o(45449);
                    return;
                }
                C4990ab.m7416i("MicroMsg.WalletBalanceManagerUI", "go new menu logic");
                addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new C248492());
                AppMethodBeat.m2505o(45449);
                return;
            }
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", e, "", new Object[0]);
        }
        optBoolean = false;
        if (optBoolean) {
        }
    }

    private boolean cNb() {
        AppMethodBeat.m2504i(45450);
        C46332s.cNC();
        if (!C46332s.cND().cQo().cNb() || this.thy.twS <= 0.0d) {
            AppMethodBeat.m2505o(45450);
            return false;
        }
        AppMethodBeat.m2505o(45450);
        return true;
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45451);
        if (i == 0 && i2 == 0 && !(c1207m instanceof C29586b) && (c1207m instanceof C35475y)) {
            this.thA = ((C35475y) c1207m).tuw;
            if (this.thA == null) {
                this.thv.setVisibility(8);
            } else if (C5046bo.isNullOrNil(this.thA.cEh)) {
                this.thv.setVisibility(8);
            } else {
                this.thw.setText(this.thA.cEh);
                if (!C5046bo.isNullOrNil(this.thA.color)) {
                    this.thw.setTextColor(Color.parseColor(this.thA.color));
                    this.thx.getDrawable().setColorFilter(Color.parseColor(this.thA.color), Mode.SRC_ATOP);
                }
                this.thv.setOnClickListener(new C248514());
                this.thv.setVisibility(0);
            }
            mo41703cu();
            ceo();
        }
        AppMethodBeat.m2505o(45451);
        return false;
    }

    /* renamed from: yq */
    public final void mo41704yq(int i) {
        AppMethodBeat.m2504i(45452);
        C46332s.cNC();
        this.thy = C46332s.cND().thy;
        if (this.thy != null) {
            if (this.thy.twS >= 0.0d) {
                this.thr.setText(C36391e.m59972G(this.thy.twS));
                AppMethodBeat.m2505o(45452);
                return;
            }
            this.thr.setText(getString(C25738R.string.fg1));
        }
        AppMethodBeat.m2505o(45452);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(45453);
        C4990ab.m7416i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + intent.getIntExtra("from_bind_ui", 0));
        if (intent.getIntExtra("from_bind_ui", 0) == C43761a.teT) {
            C24143a.m37106a((Activity) this, C41322b.class, null, null);
            C36391e.m59978QS(15);
        }
        AppMethodBeat.m2505o(45453);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45442);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.a69));
        dyb();
        ((C40167b) C1720g.m3528K(C40167b.class)).mo38286a(this, null);
        setBackBtn(new C248561(), C1318a.actionbar_icon_dark_back);
        this.gOW = getIntent().getIntExtra("key_scene_balance_manager", 0);
        bpt cPp = ECardInfo.cPp();
        if (cPp != null) {
            if (cPp.vAF == 1) {
                Bundle bundle2 = new Bundle();
                bwP();
                C43795a.m78493a(this, bundle2, null, 0);
            } else if (cPp.vAF == 3) {
                ECardInfo cPq = ECardInfo.cPq();
                if (cPq != null) {
                    C22627m.m34314a(this, cPq, 1);
                }
            }
        }
        mo39992nf(C2509f.CTRL_INDEX);
        C14241r.cPP();
        C43803ae.m78511a(this);
        initView();
        C36381z.m59954hL(2, 0);
        C7060h.pYm.mo8381e(11850, Integer.valueOf(6), Integer.valueOf(0));
        C36391e.m59978QS(10);
        AppMethodBeat.m2505o(45442);
    }

    /* renamed from: c */
    static /* synthetic */ void m38817c(WalletBalanceManagerUI walletBalanceManagerUI) {
        AppMethodBeat.m2504i(45455);
        C30379h.m48453a((Context) walletBalanceManagerUI, false, walletBalanceManagerUI.getString(C25738R.string.f96), "", walletBalanceManagerUI.getString(C25738R.string.f95), walletBalanceManagerUI.getString(C25738R.string.f9076or), new C248535(), new C43226());
        AppMethodBeat.m2505o(45455);
    }

    /* renamed from: f */
    static /* synthetic */ void m38820f(WalletBalanceManagerUI walletBalanceManagerUI) {
        AppMethodBeat.m2504i(45456);
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
        bundle.putInt("from_bind_ui", C43761a.teT);
        C24143a.m37106a((Activity) walletBalanceManagerUI, C43761a.class, bundle, null);
        AppMethodBeat.m2505o(45456);
    }
}
