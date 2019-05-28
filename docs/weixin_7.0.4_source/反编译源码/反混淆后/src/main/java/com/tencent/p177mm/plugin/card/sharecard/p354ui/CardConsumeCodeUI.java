package com.tencent.p177mm.plugin.card.sharecard.p354ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p352b.C11268c.C11269a;
import com.tencent.p177mm.plugin.card.p352b.C20123j.C20125b;
import com.tencent.p177mm.plugin.card.p352b.C27568d.C27569a;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.C42861a.C2760a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI */
public class CardConsumeCodeUI extends MMActivity implements OnClickListener, C11269a, C27569a {
    private final String TAG = "MicroMsg.CardConsumeCodeUI";
    private int emC = 3;
    private C42837b kaS;
    private Vibrator kgA;
    private boolean kgB = false;
    private String kgm;
    private int kgn = 3;
    private int kgo = 0;
    private C42861a kgp;
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

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI$1 */
    class C247291 implements OnMenuItemClickListener {
        C247291() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88098);
            CardConsumeCodeUI.this.setResult(-1);
            CardConsumeCodeUI.this.finish();
            AppMethodBeat.m2505o(88098);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI$2 */
    class C247302 implements C2760a {
        C247302() {
        }

        /* renamed from: sV */
        public final void mo6843sV(int i) {
            AppMethodBeat.m2504i(88099);
            C42852am.bbi().mo35370M(CardConsumeCodeUI.this.kaS.aZZ(), i, 1);
            AppMethodBeat.m2505o(88099);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130968907;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88100);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.CardConsumeCodeUI", "onCreate()");
        setResult(0);
        this.kaS = (C42837b) getIntent().getParcelableExtra("key_card_info_data");
        this.emC = getIntent().getIntExtra("key_from_scene", 3);
        this.kgn = getIntent().getIntExtra("key_previous_scene", 3);
        this.kgm = getIntent().getStringExtra("key_mark_user");
        this.kgo = getIntent().getIntExtra("key_from_appbrand_type", 0);
        if (this.kaS == null || this.kaS.aZV() == null || this.kaS.aZW() == null) {
            C4990ab.m7412e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            AppMethodBeat.m2505o(88100);
            return;
        }
        initView();
        C42852am.bbc().mo15082s("", "", 3);
        AppMethodBeat.m2505o(88100);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88101);
        bbC();
        setBackBtn(new C247291());
        if (this.kgp == null) {
            this.kgp = new C42861a(this, this.mController.contentView);
            this.kgp.onCreate();
            this.kgp.initView();
            this.kgp.kgi = new C247302();
        }
        this.kgp.kaS = this.kaS;
        this.kgp.kgh = true;
        if (this.kaS.aZC()) {
            this.kgp.mo68366GL(this.kgm);
        }
        this.kgA = (Vibrator) getSystemService("vibrator");
        this.kgq = (TextView) findViewById(2131821976);
        this.kgr = (TextView) findViewById(2131820678);
        this.kgs = (LinearLayout) findViewById(2131821977);
        this.kgt = (ImageView) findViewById(2131821978);
        this.kgu = findViewById(2131821979);
        this.kgv = (LinearLayout) findViewById(2131821980);
        m38592cu();
        bbD();
        AppMethodBeat.m2505o(88101);
    }

    private void bbC() {
        AppMethodBeat.m2504i(88102);
        if (this.kaS.aZD()) {
            if (TextUtils.isEmpty(this.kaS.aZV().kdf)) {
                setMMTitle(getString(C25738R.string.ad_, new Object[]{getString(C25738R.string.afv)}));
            } else {
                setMMTitle(getString(C25738R.string.ad_, new Object[]{this.kaS.aZV().kdf}));
                AppMethodBeat.m2505o(88102);
                return;
            }
        }
        AppMethodBeat.m2505o(88102);
    }

    private void bbD() {
        AppMethodBeat.m2504i(88103);
        C42852am.bbh().mo45372a((C27569a) this);
        if (this.kaS.aZQ()) {
            C42852am.bbj().mo22960a(this);
            if (C42852am.bbj().isEmpty()) {
                C4990ab.m7416i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
                C42852am.bbj().mo22959Gk(this.kaS.aZZ());
            } else {
                C42852am.bbj().ban();
                AppMethodBeat.m2505o(88103);
                return;
            }
        }
        AppMethodBeat.m2505o(88103);
    }

    public void onResume() {
        AppMethodBeat.m2504i(88104);
        this.kgp.bbB();
        C42852am.bbh().mo45373a(this, true);
        super.onResume();
        AppMethodBeat.m2505o(88104);
    }

    public void onPause() {
        AppMethodBeat.m2504i(88105);
        C42852am.bbh().mo45373a(this, false);
        super.onPause();
        AppMethodBeat.m2505o(88105);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88106);
        C42861a c42861a = this.kgp;
        c42861a.mo68367ay(c42861a.kgj);
        C38736l.m65709K(c42861a.gKF);
        C38736l.m65709K(c42861a.kgb);
        c42861a.kgi = null;
        c42861a.jiE = null;
        C42852am.bbh().mo45377c((C27569a) this);
        C42852am.bbh().mo45374b((C27569a) this);
        if (this.kaS.aZQ()) {
            C42852am.bbj().mo22961b(this);
            C42852am.bbj().bao();
        }
        this.kgA.cancel();
        super.onDestroy();
        AppMethodBeat.m2505o(88106);
    }

    /* renamed from: cu */
    private void m38592cu() {
        AppMethodBeat.m2504i(88107);
        if (this.kaS.aZD()) {
            findViewById(2131821974).setBackgroundColor(getResources().getColor(C25738R.color.f11834ir));
            C45778m.m84647d(this);
        } else {
            findViewById(2131821974).setBackgroundColor(C38736l.m65701Hn(this.kaS.aZV().color));
            C45778m.m84645a((MMActivity) this, this.kaS);
        }
        if (!this.kaS.aZD() || TextUtils.isEmpty(this.kaS.aZV().kbV)) {
            this.kgq.setText(this.kaS.aZV().kdg);
            this.kgr.setText(this.kaS.aZV().title);
        } else {
            this.kgs.setVisibility(0);
            this.kgq.setVisibility(8);
            this.kgr.setVisibility(8);
            this.kgu.setVisibility(8);
            C45778m.m84644a(this.kgt, this.kaS.aZV().kbV, getResources().getDimensionPixelSize(C25738R.dimen.f10239vg), (int) C25738R.drawable.bcm, true);
        }
        if (this.kaS.aZV().vUA != null) {
            C23446tm c23446tm = this.kaS.aZV().vUA;
            if (TextUtils.isEmpty(c23446tm.title)) {
                AppMethodBeat.m2505o(88107);
                return;
            }
            if (this.kgw == null) {
                this.kgw = ((ViewStub) findViewById(2131821989)).inflate();
            }
            this.kgw.setOnClickListener(this);
            this.kgx = (TextView) this.kgw.findViewById(2131822254);
            this.kgy = (TextView) this.kgw.findViewById(2131822253);
            this.kgz = (TextView) this.kgw.findViewById(2131822255);
            this.kgx.setVisibility(0);
            this.kgx.setText(c23446tm.title);
            Drawable drawable = getResources().getDrawable(C25738R.drawable.ayr);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            drawable.setColorFilter(C38736l.m65701Hn(this.kaS.aZV().color), Mode.SRC_IN);
            this.kgx.setCompoundDrawables(null, null, drawable, null);
            this.kgx.setTextColor(C38736l.m65701Hn(this.kaS.aZV().color));
            this.kgx.setOnClickListener(this);
            if (TextUtils.isEmpty(c23446tm.kbW)) {
                this.kgy.setVisibility(0);
                this.kgy.setText(getString(C25738R.string.afw));
            } else {
                this.kgy.setVisibility(0);
                this.kgy.setText(c23446tm.kbW);
            }
            if (!TextUtils.isEmpty(c23446tm.kbX)) {
                this.kgz.setVisibility(0);
                this.kgz.setText(c23446tm.kbX);
            }
            LayoutParams layoutParams = this.kgt.getLayoutParams();
            layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.f10240vh);
            layoutParams.width = getResources().getDimensionPixelSize(C25738R.dimen.f10240vh);
            this.kgt.setLayoutParams(layoutParams);
            layoutParams = this.kgs.getLayoutParams();
            layoutParams.height = C1338a.fromDPToPix(this, 54);
            layoutParams.width = C1338a.fromDPToPix(this, 54);
            this.kgs.setLayoutParams(layoutParams);
            C45778m.m84644a(this.kgt, this.kaS.aZV().kbV, getResources().getDimensionPixelSize(C25738R.dimen.f10240vh), (int) C25738R.drawable.bcm, true);
            this.kgv.setPadding(0, C1338a.fromDPToPix(this, 10), 0, C1338a.fromDPToPix(this, 30));
        }
        AppMethodBeat.m2505o(88107);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88108);
        if (i == 4) {
            C4990ab.m7412e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
            setResult(-1);
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(88108);
        return onKeyDown;
    }

    /* renamed from: d */
    public final void mo41613d(C42837b c42837b) {
        AppMethodBeat.m2504i(88109);
        C4990ab.m7416i("MicroMsg.CardConsumeCodeUI", "onDataChange");
        if (!(c42837b == null || c42837b.aZZ() == null || !c42837b.aZZ().equals(this.kaS.aZZ()))) {
            this.kaS = c42837b;
            this.kgp.kaS = this.kaS;
            this.kgp.bbB();
        }
        AppMethodBeat.m2505o(88109);
    }

    public final void bau() {
        AppMethodBeat.m2504i(88110);
        this.kgA.vibrate(300);
        AppMethodBeat.m2505o(88110);
    }

    public final void bav() {
        AppMethodBeat.m2504i(88111);
        C4990ab.m7416i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
        finish();
        AppMethodBeat.m2505o(88111);
    }

    /* renamed from: Gm */
    public final void mo41610Gm(String str) {
        AppMethodBeat.m2504i(88112);
        C4990ab.m7416i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
        if (this.kgB) {
            C4990ab.m7412e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
            AppMethodBeat.m2505o(88112);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
        this.kgB = true;
        Intent intent = new Intent(this, CardConsumeSuccessUI.class);
        intent.putExtra("KEY_CARD_ID", this.kaS.aZZ());
        intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
        intent.putExtra("KEY_CARD_COLOR", this.kaS.aZV().color);
        intent.putExtra("key_stastic_scene", this.emC);
        intent.putExtra("key_from_scene", 0);
        startActivity(intent);
        AppMethodBeat.m2505o(88112);
    }

    public final void bap() {
        AppMethodBeat.m2504i(88113);
        this.kgp.bbB();
        AppMethodBeat.m2505o(88113);
    }

    /* renamed from: Gj */
    public final void mo22968Gj(String str) {
        AppMethodBeat.m2504i(88114);
        C42840d.m76036a(this, str, true);
        AppMethodBeat.m2505o(88114);
    }

    public final void onSuccess() {
        AppMethodBeat.m2504i(88115);
        this.kgp.bbB();
        AppMethodBeat.m2505o(88115);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(88116);
        if (view.getId() == 2131822254 || view.getId() == 2131821990) {
            if (this.kaS.aZP()) {
                C20125b c20125b = new C20125b();
                C45774b.m84624a(this, c20125b.kbK, c20125b.kbL, false, this.kaS);
            } else {
                C23446tm c23446tm = this.kaS.aZV().vUA;
                if (!(C45774b.m84629a(this.kaS.aZZ(), c23446tm, this.kgn, this.kgo) || c23446tm == null || TextUtils.isEmpty(c23446tm.url))) {
                    C45774b.m84626a((MMActivity) this, C38736l.m65699A(c23446tm.url, c23446tm.vUW), 1);
                    C7060h.pYm.mo8381e(11941, Integer.valueOf(9), this.kaS.aZZ(), this.kaS.baa(), "", c23446tm.title);
                    if (C38736l.m65714a(c23446tm, this.kaS.aZZ())) {
                        C38736l.m65706Hs(this.kaS.aZZ());
                        C45774b.m84633b(this, this.kaS.aZV().kdg);
                    }
                }
            }
            finish();
        }
        AppMethodBeat.m2505o(88116);
    }
}
