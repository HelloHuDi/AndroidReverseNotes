package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.honey_pay.a.b;
import com.tencent.mm.plugin.honey_pay.model.HoneyPayCardType;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HoneyPaySelectCardTypeUI extends HoneyPayBaseUI {
    private LinearLayout ntf;
    private List<asj> ntg;
    private int nth;
    private ask nti;

    class a {
        public CdnImageView nrl;
        public TextView nrv;
        public CdnImageView ntk;
        public TextView ntl;
        public TextView ntm;
        public ImageView ntn;

        /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI$a$1 */
        class AnonymousClass1 implements com.tencent.mm.plugin.wallet_core.ui.o.a {
            final /* synthetic */ asj nto;
            final /* synthetic */ Context val$context;

            AnonymousClass1(asj asj, Context context) {
                this.nto = asj;
                this.val$context = context;
            }

            public final void df(View view) {
                AppMethodBeat.i(41953);
                ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "click oper text");
                if (!bo.isNullOrNil(this.nto.wpr.url)) {
                    e.n(this.val$context, this.nto.wpr.url, false);
                }
                AppMethodBeat.o(41953);
            }
        }

        private a() {
        }

        /* synthetic */ a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final void a(View view, final asj asj) {
            AppMethodBeat.i(41955);
            this.ntk = (CdnImageView) view.findViewById(R.id.cgv);
            this.nrv = (TextView) view.findViewById(R.id.cgw);
            this.ntl = (TextView) view.findViewById(R.id.cgx);
            this.ntn = (ImageView) view.findViewById(R.id.cgy);
            if (bo.isNullOrNil(asj.cIY)) {
                this.ntk.setImageResource(c.Y(asj.iAd, asj.wvW));
            } else {
                this.ntk.eb(asj.cIY, c.Y(asj.iAd, asj.wvW));
            }
            this.nrv.setText(asj.kdf);
            this.ntl.setText(asj.kfM);
            if (asj.wvW) {
                ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "disable this card");
                view.setEnabled(false);
                this.nrv.setEnabled(false);
                this.ntl.setEnabled(false);
                this.ntn.setVisibility(8);
                AppMethodBeat.o(41955);
                return;
            }
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(41954);
                    ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
                    if (HoneyPaySelectCardTypeUI.this.nti != null) {
                        HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, HoneyPaySelectCardTypeUI.this.nti);
                        AppMethodBeat.o(41954);
                        return;
                    }
                    HoneyPaySelectCardTypeUI.this.nth = asj.iAd;
                    HoneyPaySelectCardTypeUI.b(HoneyPaySelectCardTypeUI.this);
                    AppMethodBeat.o(41954);
                }
            });
            AppMethodBeat.o(41955);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41956);
        this.nqT = R.color.s2;
        super.onCreate(bundle);
        nf(2618);
        nf(2926);
        setMMTitle((int) R.string.cd5);
        ArrayList<HoneyPayCardType> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_card_type_list");
        if (!(parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty())) {
            this.ntg = new ArrayList();
            try {
                for (HoneyPayCardType honeyPayCardType : parcelableArrayListExtra) {
                    asj asj = new asj();
                    asj.parseFrom(honeyPayCardType.wR);
                    this.ntg.add(asj);
                }
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.HoneyPaySelectCardTypeUI", e, "", new Object[0]);
            }
        }
        initView();
        refreshView();
        AppMethodBeat.o(41956);
    }

    public void onDestroy() {
        AppMethodBeat.i(41958);
        ng(2618);
        ng(2926);
        super.onDestroy();
        AppMethodBeat.o(41958);
    }

    public final boolean aoE() {
        return false;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41959);
        if (mVar instanceof b) {
            final b bVar = (b) mVar;
            bVar.a(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41952);
                    HoneyPaySelectCardTypeUI.a(HoneyPaySelectCardTypeUI.this, bVar.nqy.vYj, bVar.nqy.vYi, bVar.nqy.vYk, bVar.nqy.vYl, bVar.username, bVar.nqy.nSd, bVar.nqy.kKZ);
                    AppMethodBeat.o(41952);
                }
            }).b(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            }).c(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            });
        }
        AppMethodBeat.o(41959);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.a7a;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41960);
        if (i == 1) {
            if (i2 == -1) {
                ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "select friend: %s", intent.getStringExtra("Select_Conv_User"));
                ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "do check user: %s", r0);
                m bVar = new b(r0, this.nth);
                bVar.o(this);
                a(bVar, true, false);
            } else {
                ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "cancel add friend");
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(41960);
    }

    private void refreshView() {
        AppMethodBeat.i(41961);
        this.ntf.removeAllViews();
        if (this.ntg == null || this.ntg.isEmpty()) {
            AppMethodBeat.o(41961);
            return;
        }
        for (asj asj : this.ntg) {
            View view;
            a aVar = new a(this, (byte) 0);
            if (asj.wpr == null) {
                AppCompatActivity appCompatActivity = this.mController.ylL;
                View inflate = LayoutInflater.from(appCompatActivity).inflate(R.layout.a79, this.ntf, false);
                aVar.a(inflate, asj);
                view = inflate;
            } else {
                AppCompatActivity appCompatActivity2 = this.mController.ylL;
                View inflate2 = LayoutInflater.from(appCompatActivity2).inflate(R.layout.a7_, this.ntf, false);
                aVar.a(inflate2, asj);
                aVar.nrl = (CdnImageView) inflate2.findViewById(R.id.cgz);
                aVar.ntm = (TextView) inflate2.findViewById(R.id.ch0);
                aVar.nrl.setUrl(asj.wpr.cIY);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(asj.wpr.wvU);
                spannableStringBuilder.append(asj.wpr.wvV);
                spannableStringBuilder.setSpan(new o(new AnonymousClass1(asj, appCompatActivity2)), asj.wpr.wvU.length(), spannableStringBuilder.length(), 34);
                aVar.ntm.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(appCompatActivity2));
                aVar.ntm.setClickable(true);
                aVar.ntm.setText(spannableStringBuilder);
                view = inflate2;
            }
            this.ntf.addView(view);
        }
        AppMethodBeat.o(41961);
    }

    public final void initView() {
        AppMethodBeat.i(41957);
        this.ntf = (LinearLayout) findViewById(R.id.ch1);
        AppMethodBeat.o(41957);
    }

    static /* synthetic */ void a(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI, long j, long j2, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(41962);
        ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "go to give card");
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
        AppMethodBeat.o(41962);
    }

    static /* synthetic */ void b(HoneyPaySelectCardTypeUI honeyPaySelectCardTypeUI) {
        AppMethodBeat.i(41964);
        ab.i("MicroMsg.HoneyPaySelectCardTypeUI", "go to select contact");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.C(16, 1, 2, 4, 16384));
        intent.putExtra("block_contact", r.Yz());
        intent.putExtra("titile", honeyPaySelectCardTypeUI.getString(R.string.cd6));
        d.b((Context) honeyPaySelectCardTypeUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.o(41964);
    }
}
