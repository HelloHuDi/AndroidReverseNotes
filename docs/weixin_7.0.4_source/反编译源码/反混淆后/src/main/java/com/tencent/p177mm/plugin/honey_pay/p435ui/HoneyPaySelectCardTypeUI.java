package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.p177mm.plugin.honey_pay.p434a.C21050b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.protocal.protobuf.asj;
import com.tencent.p177mm.protocal.protobuf.ask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI */
public class HoneyPaySelectCardTypeUI extends HoneyPayBaseUI {
    private LinearLayout ntf;
    private List<asj> ntg;
    private int nth;
    private ask nti;

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI$a */
    class C21066a {
        public CdnImageView nrl;
        public TextView nrv;
        public CdnImageView ntk;
        public TextView ntl;
        public TextView ntm;
        public ImageView ntn;

        /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI$a$1 */
        class C210671 implements C35502a {
            final /* synthetic */ asj nto;
            final /* synthetic */ Context val$context;

            C210671(asj asj, Context context) {
                this.nto = asj;
                this.val$context = context;
            }

            /* renamed from: df */
            public final void mo9537df(View view) {
                AppMethodBeat.m2504i(41953);
                C4990ab.m7416i("MicroMsg.HoneyPaySelectCardTypeUI", "click oper text");
                if (!C5046bo.isNullOrNil(this.nto.wpr.url)) {
                    C36391e.m60016n(this.val$context, this.nto.wpr.url, false);
                }
                AppMethodBeat.m2505o(41953);
            }
        }

        private C21066a() {
        }

        /* synthetic */ C21066a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo36390a(View view, final asj asj) {
            AppMethodBeat.m2504i(41955);
            this.ntk = (CdnImageView) view.findViewById(2131824942);
            this.nrv = (TextView) view.findViewById(2131824943);
            this.ntl = (TextView) view.findViewById(2131824944);
            this.ntn = (ImageView) view.findViewById(2131824945);
            if (C5046bo.isNullOrNil(asj.cIY)) {
                this.ntk.setImageResource(C28289c.m44881Y(asj.iAd, asj.wvW));
            } else {
                this.ntk.mo38952eb(asj.cIY, C28289c.m44881Y(asj.iAd, asj.wvW));
            }
            this.nrv.setText(asj.kdf);
            this.ntl.setText(asj.kfM);
            if (asj.wvW) {
                C4990ab.m7416i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
                view.setEnabled(false);
                this.nrv.setEnabled(false);
                this.ntl.setEnabled(false);
                this.ntn.setVisibility(8);
                AppMethodBeat.m2505o(41955);
                return;
            }
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(41954);
                    C4990ab.m7416i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
                    if (HoneyPaySelectCardTypeUI.this.nti != null) {
                        HoneyPaySelectCardTypeUI.m44917a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.this.nti);
                        AppMethodBeat.m2505o(41954);
                        return;
                    }
                    HoneyPaySelectCardTypeUI.this.nth = asj.iAd;
                    HoneyPaySelectCardTypeUI.m44918b(HoneyPaySelectCardTypeUI.this);
                    AppMethodBeat.m2505o(41954);
                }
            });
            AppMethodBeat.m2505o(41955);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI$1 */
    class C283131 implements C40929a {
        C283131() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI$2 */
    class C283152 implements C40929a {
        C283152() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41956);
        this.nqT = C25738R.color.f12094s2;
        super.onCreate(bundle);
        mo39992nf(2618);
        mo39992nf(2926);
        setMMTitle((int) C25738R.string.cd5);
        ArrayList<HoneyPayCardType> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_card_type_list");
        if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty())) {
            this.ntg = new ArrayList();
            try {
                for (HoneyPayCardType honeyPayCardType : parcelableArrayListExtra) {
                    asj asj = new asj();
                    asj.parseFrom(honeyPayCardType.f2910wR);
                    this.ntg.add(asj);
                }
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", e, "", new Object[0]);
            }
        }
        initView();
        refreshView();
        AppMethodBeat.m2505o(41956);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41958);
        mo39993ng(2618);
        mo39993ng(2926);
        super.onDestroy();
        AppMethodBeat.m2505o(41958);
    }

    public final boolean aoE() {
        return false;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41959);
        if (c1207m instanceof C21050b) {
            final C21050b c21050b = (C21050b) c1207m;
            c21050b.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41952);
                    HoneyPaySelectCardTypeUI.m44916a(HoneyPaySelectCardTypeUI.this, c21050b.nqy.vYj, c21050b.nqy.vYi, c21050b.nqy.vYk, c21050b.nqy.vYl, c21050b.username, c21050b.nqy.nSd, c21050b.nqy.kKZ);
                    AppMethodBeat.m2505o(41952);
                }
            }).mo70319b(new C283152()).mo70320c(new C283131());
        }
        AppMethodBeat.m2505o(41959);
        return true;
    }

    public final int getLayoutId() {
        return 2130969838;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41960);
        if (i == 1) {
            if (i2 == -1) {
                C4990ab.m7417i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", intent.getStringExtra("Select_Conv_User"));
                C4990ab.m7417i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", r0);
                C1207m c21050b = new C21050b(r0, this.nth);
                c21050b.mo70321o(this);
                mo39970a(c21050b, true, false);
            } else {
                C4990ab.m7416i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(41960);
    }

    private void refreshView() {
        AppMethodBeat.m2504i(41961);
        this.ntf.removeAllViews();
        if (this.ntg == null || this.ntg.isEmpty()) {
            AppMethodBeat.m2505o(41961);
            return;
        }
        for (asj asj : this.ntg) {
            View view;
            C21066a c21066a = new C21066a(this, (byte) 0);
            if (asj.wpr == null) {
                AppCompatActivity appCompatActivity = this.mController.ylL;
                View inflate = LayoutInflater.from(appCompatActivity).inflate(2130969836, this.ntf, false);
                c21066a.mo36390a(inflate, asj);
                view = inflate;
            } else {
                AppCompatActivity appCompatActivity2 = this.mController.ylL;
                View inflate2 = LayoutInflater.from(appCompatActivity2).inflate(2130969837, this.ntf, false);
                c21066a.mo36390a(inflate2, asj);
                c21066a.nrl = (CdnImageView) inflate2.findViewById(2131824946);
                c21066a.ntm = (TextView) inflate2.findViewById(2131824947);
                c21066a.nrl.setUrl(asj.wpr.cIY);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(asj.wpr.wvU);
                spannableStringBuilder.append(asj.wpr.wvV);
                spannableStringBuilder.setSpan(new C35503o(new C210671(asj, appCompatActivity2)), asj.wpr.wvU.length(), spannableStringBuilder.length(), 34);
                c21066a.ntm.setOnTouchListener(new C30132m(appCompatActivity2));
                c21066a.ntm.setClickable(true);
                c21066a.ntm.setText(spannableStringBuilder);
                view = inflate2;
            }
            this.ntf.addView(view);
        }
        AppMethodBeat.m2505o(41961);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41957);
        this.ntf = (LinearLayout) findViewById(2131824948);
        AppMethodBeat.m2505o(41957);
    }

    /* renamed from: a */
    static /* synthetic */ void m44916a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI, long j, long j2, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(41962);
        C4990ab.m7416i("MicroMsg.HoneyPaySelectCardTypeUI", "go to give card");
        Intent intent = new Intent(honeyPaySelectCardTypeUI, HoneyPayGiveCardUI.class);
        intent.putExtra("key_max_credit_line", j);
        intent.putExtra("key_min_credit_line", j2);
        intent.putExtra("key_true_name", str);
        intent.putExtra("key_take_message", str2);
        intent.putExtra("key_username", str3);
        intent.putExtra("key_wishing", str4);
        intent.putExtra("key_icon_url", str5);
        intent.putExtra("key_cardtype", honeyPaySelectCardTypeUI.nth);
        honeyPaySelectCardTypeUI.startActivity(intent);
        AppMethodBeat.m2505o(41962);
    }

    /* renamed from: b */
    static /* synthetic */ void m44918b(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI) {
        AppMethodBeat.m2504i(41964);
        C4990ab.m7416i("MicroMsg.HoneyPaySelectCardTypeUI", "go to select contact");
        Intent intent = new Intent();
        intent.putExtra("list_attr", C15830s.m24190C(16, 1, 2, 4, 16384));
        intent.putExtra("block_contact", C1853r.m3846Yz());
        intent.putExtra("titile", honeyPaySelectCardTypeUI.getString(C25738R.string.cd6));
        C25985d.m41466b((Context) honeyPaySelectCardTypeUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.m2505o(41964);
    }
}
