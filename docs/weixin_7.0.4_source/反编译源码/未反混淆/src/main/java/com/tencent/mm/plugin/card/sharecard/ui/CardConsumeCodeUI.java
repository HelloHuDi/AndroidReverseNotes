package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.c.a;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI extends MMActivity implements OnClickListener, a, d.a {
    private final String TAG = "MicroMsg.CardConsumeCodeUI";
    private int emC = 3;
    private b kaS;
    private Vibrator kgA;
    private boolean kgB = false;
    private String kgm;
    private int kgn = 3;
    private int kgo = 0;
    private a kgp;
    private TextView kgq;
    private TextView kgr;
    private LinearLayout kgs;
    private ImageView kgt;
    private View kgu;
    private LinearLayout kgv;
    private View kgw;
    private TextView kgx;
    private TextView kgy;
    private TextView kgz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.i9;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88100);
        super.onCreate(bundle);
        ab.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
        setResult(0);
        this.kaS = (b) getIntent().getParcelableExtra("key_card_info_data");
        this.emC = getIntent().getIntExtra("key_from_scene", 3);
        this.kgn = getIntent().getIntExtra("key_previous_scene", 3);
        this.kgm = getIntent().getStringExtra("key_mark_user");
        this.kgo = getIntent().getIntExtra("key_from_appbrand_type", 0);
        if (this.kaS == null || this.kaS.aZV() == null || this.kaS.aZW() == null) {
            ab.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            AppMethodBeat.o(88100);
            return;
        }
        initView();
        am.bbc().s("", "", 3);
        AppMethodBeat.o(88100);
    }

    public final void initView() {
        AppMethodBeat.i(88101);
        bbC();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88098);
                CardConsumeCodeUI.this.setResult(-1);
                CardConsumeCodeUI.this.finish();
                AppMethodBeat.o(88098);
                return true;
            }
        });
        if (this.kgp == null) {
            this.kgp = new a(this, this.mController.contentView);
            this.kgp.onCreate();
            this.kgp.initView();
            this.kgp.kgi = new a.a() {
                public final void sV(int i) {
                    AppMethodBeat.i(88099);
                    am.bbi().M(CardConsumeCodeUI.this.kaS.aZZ(), i, 1);
                    AppMethodBeat.o(88099);
                }
            };
        }
        this.kgp.kaS = this.kaS;
        this.kgp.kgh = true;
        if (this.kaS.aZC()) {
            this.kgp.GL(this.kgm);
        }
        this.kgA = (Vibrator) getSystemService("vibrator");
        this.kgq = (TextView) findViewById(R.id.aao);
        this.kgr = (TextView) findViewById(R.id.cx);
        this.kgs = (LinearLayout) findViewById(R.id.aap);
        this.kgt = (ImageView) findViewById(R.id.aaq);
        this.kgu = findViewById(R.id.aar);
        this.kgv = (LinearLayout) findViewById(R.id.aas);
        cu();
        bbD();
        AppMethodBeat.o(88101);
    }

    private void bbC() {
        AppMethodBeat.i(88102);
        if (this.kaS.aZD()) {
            if (TextUtils.isEmpty(this.kaS.aZV().kdf)) {
                setMMTitle(getString(R.string.ad_, new Object[]{getString(R.string.afv)}));
            } else {
                setMMTitle(getString(R.string.ad_, new Object[]{this.kaS.aZV().kdf}));
                AppMethodBeat.o(88102);
                return;
            }
        }
        AppMethodBeat.o(88102);
    }

    private void bbD() {
        AppMethodBeat.i(88103);
        am.bbh().a((d.a) this);
        if (this.kaS.aZQ()) {
            am.bbj().a(this);
            if (am.bbj().isEmpty()) {
                ab.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
                am.bbj().Gk(this.kaS.aZZ());
            } else {
                am.bbj().ban();
                AppMethodBeat.o(88103);
                return;
            }
        }
        AppMethodBeat.o(88103);
    }

    public void onResume() {
        AppMethodBeat.i(88104);
        this.kgp.bbB();
        am.bbh().a(this, true);
        super.onResume();
        AppMethodBeat.o(88104);
    }

    public void onPause() {
        AppMethodBeat.i(88105);
        am.bbh().a(this, false);
        super.onPause();
        AppMethodBeat.o(88105);
    }

    public void onDestroy() {
        AppMethodBeat.i(88106);
        a aVar = this.kgp;
        aVar.ay(aVar.kgj);
        l.K(aVar.gKF);
        l.K(aVar.kgb);
        aVar.kgi = null;
        aVar.jiE = null;
        am.bbh().c((d.a) this);
        am.bbh().b((d.a) this);
        if (this.kaS.aZQ()) {
            am.bbj().b(this);
            am.bbj().bao();
        }
        this.kgA.cancel();
        super.onDestroy();
        AppMethodBeat.o(88106);
    }

    private void cu() {
        AppMethodBeat.i(88107);
        if (this.kaS.aZD()) {
            findViewById(R.id.aam).setBackgroundColor(getResources().getColor(R.color.ir));
            m.d(this);
        } else {
            findViewById(R.id.aam).setBackgroundColor(l.Hn(this.kaS.aZV().color));
            m.a((MMActivity) this, this.kaS);
        }
        if (!this.kaS.aZD() || TextUtils.isEmpty(this.kaS.aZV().kbV)) {
            this.kgq.setText(this.kaS.aZV().kdg);
            this.kgr.setText(this.kaS.aZV().title);
        } else {
            this.kgs.setVisibility(0);
            this.kgq.setVisibility(8);
            this.kgr.setVisibility(8);
            this.kgu.setVisibility(8);
            m.a(this.kgt, this.kaS.aZV().kbV, getResources().getDimensionPixelSize(R.dimen.vg), (int) R.drawable.bcm, true);
        }
        if (this.kaS.aZV().vUA != null) {
            tm tmVar = this.kaS.aZV().vUA;
            if (TextUtils.isEmpty(tmVar.title)) {
                AppMethodBeat.o(88107);
                return;
            }
            if (this.kgw == null) {
                this.kgw = ((ViewStub) findViewById(R.id.ab1)).inflate();
            }
            this.kgw.setOnClickListener(this);
            this.kgx = (TextView) this.kgw.findViewById(R.id.ai7);
            this.kgy = (TextView) this.kgw.findViewById(R.id.ai6);
            this.kgz = (TextView) this.kgw.findViewById(R.id.ai8);
            this.kgx.setVisibility(0);
            this.kgx.setText(tmVar.title);
            Drawable drawable = getResources().getDrawable(R.drawable.ayr);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            drawable.setColorFilter(l.Hn(this.kaS.aZV().color), Mode.SRC_IN);
            this.kgx.setCompoundDrawables(null, null, drawable, null);
            this.kgx.setTextColor(l.Hn(this.kaS.aZV().color));
            this.kgx.setOnClickListener(this);
            if (TextUtils.isEmpty(tmVar.kbW)) {
                this.kgy.setVisibility(0);
                this.kgy.setText(getString(R.string.afw));
            } else {
                this.kgy.setVisibility(0);
                this.kgy.setText(tmVar.kbW);
            }
            if (!TextUtils.isEmpty(tmVar.kbX)) {
                this.kgz.setVisibility(0);
                this.kgz.setText(tmVar.kbX);
            }
            LayoutParams layoutParams = this.kgt.getLayoutParams();
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.vh);
            layoutParams.width = getResources().getDimensionPixelSize(R.dimen.vh);
            this.kgt.setLayoutParams(layoutParams);
            layoutParams = this.kgs.getLayoutParams();
            layoutParams.height = com.tencent.mm.bz.a.fromDPToPix(this, 54);
            layoutParams.width = com.tencent.mm.bz.a.fromDPToPix(this, 54);
            this.kgs.setLayoutParams(layoutParams);
            m.a(this.kgt, this.kaS.aZV().kbV, getResources().getDimensionPixelSize(R.dimen.vh), (int) R.drawable.bcm, true);
            this.kgv.setPadding(0, com.tencent.mm.bz.a.fromDPToPix(this, 10), 0, com.tencent.mm.bz.a.fromDPToPix(this, 30));
        }
        AppMethodBeat.o(88107);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(88108);
        if (i == 4) {
            ab.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
            setResult(-1);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(88108);
        return onKeyDown;
    }

    public final void d(b bVar) {
        AppMethodBeat.i(88109);
        ab.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
        if (!(bVar == null || bVar.aZZ() == null || !bVar.aZZ().equals(this.kaS.aZZ()))) {
            this.kaS = bVar;
            this.kgp.kaS = this.kaS;
            this.kgp.bbB();
        }
        AppMethodBeat.o(88109);
    }

    public final void bau() {
        AppMethodBeat.i(88110);
        this.kgA.vibrate(300);
        AppMethodBeat.o(88110);
    }

    public final void bav() {
        AppMethodBeat.i(88111);
        ab.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
        finish();
        AppMethodBeat.o(88111);
    }

    public final void Gm(String str) {
        AppMethodBeat.i(88112);
        ab.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
        if (this.kgB) {
            ab.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
            AppMethodBeat.o(88112);
            return;
        }
        ab.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
        this.kgB = true;
        Intent intent = new Intent(this, CardConsumeSuccessUI.class);
        intent.putExtra("KEY_CARD_ID", this.kaS.aZZ());
        intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
        intent.putExtra("KEY_CARD_COLOR", this.kaS.aZV().color);
        intent.putExtra("key_stastic_scene", this.emC);
        intent.putExtra("key_from_scene", 0);
        startActivity(intent);
        AppMethodBeat.o(88112);
    }

    public final void bap() {
        AppMethodBeat.i(88113);
        this.kgp.bbB();
        AppMethodBeat.o(88113);
    }

    public final void Gj(String str) {
        AppMethodBeat.i(88114);
        com.tencent.mm.plugin.card.d.d.a(this, str, true);
        AppMethodBeat.o(88114);
    }

    public final void onSuccess() {
        AppMethodBeat.i(88115);
        this.kgp.bbB();
        AppMethodBeat.o(88115);
    }

    public void onClick(View view) {
        AppMethodBeat.i(88116);
        if (view.getId() == R.id.ai7 || view.getId() == R.id.ab2) {
            if (this.kaS.aZP()) {
                j.b bVar = new j.b();
                com.tencent.mm.plugin.card.d.b.a(this, bVar.kbK, bVar.kbL, false, this.kaS);
            } else {
                tm tmVar = this.kaS.aZV().vUA;
                if (!(com.tencent.mm.plugin.card.d.b.a(this.kaS.aZZ(), tmVar, this.kgn, this.kgo) || tmVar == null || TextUtils.isEmpty(tmVar.url))) {
                    com.tencent.mm.plugin.card.d.b.a((MMActivity) this, l.A(tmVar.url, tmVar.vUW), 1);
                    h.pYm.e(11941, Integer.valueOf(9), this.kaS.aZZ(), this.kaS.baa(), "", tmVar.title);
                    if (l.a(tmVar, this.kaS.aZZ())) {
                        l.Hs(this.kaS.aZZ());
                        com.tencent.mm.plugin.card.d.b.b(this, this.kaS.aZV().kdg);
                    }
                }
            }
            finish();
        }
        AppMethodBeat.o(88116);
    }
}
