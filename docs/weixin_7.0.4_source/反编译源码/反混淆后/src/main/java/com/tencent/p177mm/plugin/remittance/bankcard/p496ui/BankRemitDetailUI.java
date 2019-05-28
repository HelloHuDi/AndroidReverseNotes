package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C3714l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI */
public class BankRemitDetailUI extends BankRemitBaseUI {
    private int gqq;
    private int mState;
    private Button nsJ;
    private LinearLayout nsy;
    private ImageView pNb;
    private ImageView pNc;
    private ImageView pNd;
    private TextView pNe;
    private TextView pNf;
    private TextView pNg;
    private TextView pNh;
    private TextView pNi;
    private TextView pNj;
    private View pNk;
    private View pNl;
    private ViewGroup pNm;
    private String pNn;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI$2 */
    class C130322 implements OnClickListener {
        C130322() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44595);
            C4990ab.m7416i("MicroMsg.BankRemitDetailUI", "click finish btn");
            BankRemitDetailUI.this.finish();
            AppMethodBeat.m2505o(44595);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI$3 */
    class C130333 implements C40929a {
        C130333() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44596);
            C4990ab.m7413e("MicroMsg.BankRemitDetailUI", "net error: %s", c1207m);
            Toast.makeText(BankRemitDetailUI.this, C25738R.string.a43, 1).show();
            AppMethodBeat.m2505o(44596);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI$1 */
    class C288651 implements OnMenuItemClickListener {
        C288651() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44594);
            C4990ab.m7416i("MicroMsg.BankRemitDetailUI", "back press");
            BankRemitDetailUI.this.finish();
            AppMethodBeat.m2505o(44594);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44599);
        super.onCreate(bundle);
        mo39992nf(1579);
        this.pNn = getIntent().getStringExtra("key_transfer_bill_id");
        this.gqq = getIntent().getIntExtra("key_enter_scene", 0);
        C4990ab.m7417i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", this.pNn, Integer.valueOf(this.gqq));
        initView();
        C4990ab.m7416i("MicroMsg.BankRemitDetailUI", "do query detail");
        mo39970a(new C3714l(this.pNn), true, true);
        if (this.gqq == 0) {
            showHomeBtn(false);
            enableBackMenu(false);
            setMMTitle((int) C25738R.string.a4g);
        } else {
            showHomeBtn(true);
            enableBackMenu(true);
            setMMTitle((int) C25738R.string.a4f);
        }
        setBackBtn(new C288651());
        AppMethodBeat.m2505o(44599);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44600);
        this.pNb = (ImageView) findViewById(2131821647);
        this.pNc = (ImageView) findViewById(2131821651);
        this.pNd = (ImageView) findViewById(2131821655);
        this.pNe = (TextView) findViewById(2131821648);
        this.pNf = (TextView) findViewById(2131821652);
        this.pNg = (TextView) findViewById(2131821656);
        this.pNh = (TextView) findViewById(2131821649);
        this.pNi = (TextView) findViewById(2131821653);
        this.pNj = (TextView) findViewById(2131821657);
        this.pNk = findViewById(2131821644);
        this.pNl = findViewById(2131821645);
        this.nsy = (LinearLayout) findViewById(2131821660);
        this.pNm = (ViewGroup) findViewById(2131821642);
        if (this.gqq == 1) {
            findViewById(2131821662).setVisibility(8);
            AppMethodBeat.m2505o(44600);
            return;
        }
        this.nsJ = (Button) findViewById(2131821663);
        this.nsJ.setOnClickListener(new C130322());
        AppMethodBeat.m2505o(44600);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFY() {
        AppMethodBeat.m2504i(44601);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.a69)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131821128);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(C25738R.color.f12085rt));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(C25738R.color.f11782h4));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.a69));
        }
        BankRemitBaseUI.m6024Y(this);
        this.mController.contentView.setFitsSystemWindows(true);
        AppMethodBeat.m2505o(44601);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44602);
        if (c1207m instanceof C3714l) {
            final C3714l c3714l = (C3714l) c1207m;
            c3714l.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44598);
                    C4990ab.m7417i("MicroMsg.BankRemitDetailUI", "state: %s, amount: %s, fee: %s, account: %s", Integer.valueOf(c3714l.pLD.state), Integer.valueOf(c3714l.pLD.nUf), Integer.valueOf(c3714l.pLD.wQZ), c3714l.pLD.wRa);
                    BankRemitDetailUI.this.mState = c3714l.pLD.state;
                    BankRemitDetailUI.m45880a(BankRemitDetailUI.this, c3714l.pLD.state, c3714l.pLD.wQY);
                    BankRemitDetailUI.m45881a(BankRemitDetailUI.this, c3714l.pLD);
                    BankRemitDetailUI.this.pNm.setVisibility(0);
                    AppMethodBeat.m2505o(44598);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44597);
                    C4990ab.m7413e("MicroMsg.BankRemitDetailUI", "detail reponse error: %s, %s", Integer.valueOf(c3714l.pLD.kCl), c3714l.pLD.kCm);
                    if (C5046bo.isNullOrNil(c3714l.pLD.kCm)) {
                        Toast.makeText(BankRemitDetailUI.this, C25738R.string.a43, 1).show();
                        AppMethodBeat.m2505o(44597);
                        return;
                    }
                    Toast.makeText(BankRemitDetailUI.this, c3714l.pLD.kCm, 1).show();
                    AppMethodBeat.m2505o(44597);
                }
            }).mo70320c(new C130333());
        }
        AppMethodBeat.m2505o(44602);
        return true;
    }

    public final int getLayoutId() {
        return 2130968816;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44603);
        super.onDestroy();
        mo39993ng(1579);
        AppMethodBeat.m2505o(44603);
    }

    /* renamed from: a */
    static /* synthetic */ void m45880a(BankRemitDetailUI bankRemitDetailUI, int i, String str) {
        int i2 = 1;
        AppMethodBeat.m2504i(44604);
        switch (i) {
            case 1:
                bankRemitDetailUI.pNc.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNc.setImageResource(C1318a.bank_remit_waiting);
                bankRemitDetailUI.pNi.setTextColor(bankRemitDetailUI.getResources().getColor(C25738R.color.f12212w4));
                bankRemitDetailUI.pNf.setText(C25738R.string.a49);
                if (!C5046bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNi.setText(str);
                    bankRemitDetailUI.pNi.setVisibility(0);
                    break;
                }
                break;
            case 2:
                bankRemitDetailUI.pNl.setBackground(bankRemitDetailUI.getResources().getDrawable(C25738R.drawable.f6406d5));
                bankRemitDetailUI.pNd.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNd.setImageResource(C1318a.bank_remit_success);
                bankRemitDetailUI.pNg.setTextColor(bankRemitDetailUI.getResources().getColor(C25738R.color.f12212w4));
                if (!C5046bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNj.setText(str);
                    bankRemitDetailUI.pNj.setVisibility(0);
                    break;
                }
                break;
            case 3:
                bankRemitDetailUI.pNc.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNc.setImageResource(C1318a.bank_remit_delay);
                bankRemitDetailUI.pNf.setTextColor(bankRemitDetailUI.getResources().getColor(C25738R.color.f12212w4));
                bankRemitDetailUI.pNf.setText(C25738R.string.a4a);
                if (!C5046bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNi.setText(str);
                    bankRemitDetailUI.pNi.setVisibility(0);
                    break;
                }
                break;
            case 4:
                bankRemitDetailUI.pNc.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNc.setImageResource(C1318a.bank_remit_fail);
                bankRemitDetailUI.pNf.setTextColor(bankRemitDetailUI.getResources().getColor(C25738R.color.f12212w4));
                bankRemitDetailUI.pNf.setText(C25738R.string.a4d);
                if (!C5046bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNi.setText(str);
                    bankRemitDetailUI.pNi.setVisibility(0);
                    break;
                }
                break;
            case 5:
                bankRemitDetailUI.pNd.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pNd.setImageResource(C1318a.bank_remit_fail);
                bankRemitDetailUI.pNg.setTextColor(bankRemitDetailUI.getResources().getColor(C25738R.color.f12212w4));
                bankRemitDetailUI.pNg.setText(C25738R.string.a4b);
                if (!C5046bo.isNullOrNil(str)) {
                    bankRemitDetailUI.pNj.setText(str);
                    bankRemitDetailUI.pNj.setVisibility(0);
                    break;
                }
                break;
            default:
                C4990ab.m7421w("MicroMsg.BankRemitDetailUI", "unknown state: %s", Integer.valueOf(bankRemitDetailUI.mState));
                i2 = 0;
                break;
        }
        if (i2 != 0) {
            bankRemitDetailUI.findViewById(2131821658).setVisibility(8);
        }
        AppMethodBeat.m2505o(44604);
    }
}
