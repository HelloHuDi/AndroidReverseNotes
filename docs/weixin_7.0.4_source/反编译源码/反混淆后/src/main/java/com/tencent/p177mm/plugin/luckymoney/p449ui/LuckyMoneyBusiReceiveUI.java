package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.luckymoney.model.C12425af;
import com.tencent.p177mm.plugin.luckymoney.model.C12432y;
import com.tencent.p177mm.plugin.luckymoney.model.C21198ar;
import com.tencent.p177mm.plugin.luckymoney.model.C36784ad;
import com.tencent.p177mm.plugin.luckymoney.model.C39317ab;
import com.tencent.p177mm.plugin.luckymoney.model.C46057ac;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.io.IOException;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI */
public class LuckyMoneyBusiReceiveUI extends LuckyMoneyBaseUI {
    private TextView nSD;
    private ImageView nSM;
    private TextView nTD;
    private Button nTE;
    private View nTI;
    private ImageView nVJ;
    private String ocI = null;
    private String ocK = null;
    private int ocM = 0;
    private TextView ocU;
    private TextView ocV;
    private View ocW;
    private ImageView ocX;
    private TextView ocY;
    private View ocZ;
    private TextView oda;
    private Button odb;
    private TextView odc;
    private CheckBox odd;
    private int ode;
    private String odf = null;
    private int odg = 0;
    private C36784ad odh;
    private RealnameGuideHelper odi;
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI$1 */
    class C33891 implements OnCancelListener {
        C33891() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(42616);
            if (LuckyMoneyBusiReceiveUI.this.tipDialog != null && LuckyMoneyBusiReceiveUI.this.tipDialog.isShowing()) {
                LuckyMoneyBusiReceiveUI.this.tipDialog.dismiss();
            }
            LuckyMoneyBusiReceiveUI.this.ocz.bLz();
            if (LuckyMoneyBusiReceiveUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyBusiReceiveUI.this.mController.contentView.getVisibility() == 4) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
                LuckyMoneyBusiReceiveUI.this.finish();
            }
            AppMethodBeat.m2505o(42616);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI$2 */
    class C33902 implements C30857a {
        C33902() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(42617);
            C4990ab.m7416i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
            AppMethodBeat.m2505o(42617);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI$5 */
    class C33915 implements OnClickListener {
        C33915() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42620);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
            Intent intent = new Intent();
            intent.setClass(LuckyMoneyBusiReceiveUI.this.mController.ylL, LuckyMoneyBusiDetailUI.class);
            intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.this.ocK);
            intent.putExtra("key_sendid", LuckyMoneyBusiReceiveUI.this.odh.nSX);
            intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.this.ocM);
            LuckyMoneyBusiReceiveUI.this.startActivity(intent);
            LuckyMoneyBusiReceiveUI.this.finish();
            AppMethodBeat.m2505o(42620);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI$4 */
    class C33924 implements OnClickListener {
        C33924() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42619);
            C7060h.pYm.mo8381e(11701, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
            if (LuckyMoneyBusiReceiveUI.this.odd.isChecked()) {
                C7060h.pYm.mo8381e(13050, Integer.valueOf(LuckyMoneyBusiReceiveUI.this.ocM), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.this.odh.nYl);
            } else {
                C7060h.pYm.mo8381e(13050, Integer.valueOf(LuckyMoneyBusiReceiveUI.this.ocM), Integer.valueOf(2), "");
            }
            LuckyMoneyBusiReceiveUI.m5684i(LuckyMoneyBusiReceiveUI.this);
            AppMethodBeat.m2505o(42619);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI$10 */
    class C339310 implements DialogInterface.OnClickListener {
        C339310() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI$3 */
    class C33943 implements OnClickListener {
        C33943() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42618);
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            if (LuckyMoneyBusiReceiveUI.this.odi == null || !LuckyMoneyBusiReceiveUI.this.odi.mo74573a(LuckyMoneyBusiReceiveUI.this, bundle, null, null, true)) {
                LuckyMoneyBusiReceiveUI.this.finish();
                AppMethodBeat.m2505o(42618);
                return;
            }
            LuckyMoneyBusiReceiveUI.this.odi = null;
            AppMethodBeat.m2505o(42618);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI$8 */
    class C33998 implements OnClickListener {
        C33998() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42625);
            LuckyMoneyBusiReceiveUI.this.finish();
            AppMethodBeat.m2505o(42625);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42627);
        super.onCreate(bundle);
        this.ocK = getIntent().getStringExtra("key_native_url");
        this.ode = getIntent().getIntExtra("key_way", 5);
        this.ocM = getIntent().getIntExtra("key_static_from_scene", 0);
        C4990ab.m7416i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + C5046bo.nullAsNil(this.ocK) + ", mWay=" + this.ode);
        init();
        C7060h.pYm.mo8381e(11701, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        initView();
        mo24305nf(980);
        AppMethodBeat.m2505o(42627);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(42629);
        if (intent != null && intent.hasExtra("key_is_realname_verify_process")) {
            if (intent.getIntExtra("realname_verify_process_ret", 0) == -1) {
                C4990ab.m7416i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
                init();
                AppMethodBeat.m2505o(42629);
                return;
            }
            C4990ab.m7416i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
            m5676aO(-1, "");
            finish();
        }
        AppMethodBeat.m2505o(42629);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42630);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        mo24306ng(980);
        AppMethodBeat.m2505o(42630);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42631);
        this.nTI = findViewById(2131825419);
        this.nSM = (ImageView) findViewById(2131825422);
        this.nTD = (TextView) findViewById(2131825423);
        this.ocV = (TextView) findViewById(2131825431);
        this.ocU = (TextView) findViewById(2131825424);
        this.nTE = (Button) findViewById(2131825432);
        this.nVJ = (ImageView) findViewById(2131825436);
        this.ocW = findViewById(2131825428);
        this.nSD = (TextView) findViewById(2131825429);
        this.ocX = (ImageView) findViewById(2131825421);
        this.ocY = (TextView) findViewById(2131825435);
        this.ocZ = findViewById(2131825425);
        this.oda = (TextView) findViewById(2131825426);
        this.odb = (Button) findViewById(2131825433);
        this.odc = (TextView) findViewById(2131825430);
        this.odd = (CheckBox) findViewById(2131825434);
        this.nVJ.setOnClickListener(new C33943());
        mo9439AM(8);
        AppMethodBeat.m2505o(42631);
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42632);
        Intent intent;
        if (c1207m instanceof C36784ad) {
            if (i == 0 && i2 == 0) {
                this.odh = (C36784ad) c1207m;
                this.ocI = this.odh.nSX;
                this.odg = this.odh.cRT;
                C7060h.pYm.mo8381e(13050, Integer.valueOf(this.ocM), Integer.valueOf(1), this.odh.nYl);
                if (this.odh.cRV == 2) {
                    m5676aO(-1, "");
                    mo24301b(new C12425af(this.ocI, 11, 0, this.ocK, "v1.0"), false);
                } else {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    C46063x.m85821k(this.nSM, this.odh.nYp);
                    C46063x.m85800a(this.mController.ylL, this.nTD, this.odh.nYf);
                    C46063x.m85819h(this.ocX, this.odh.nXg);
                    if (this.odh.cRV == 1 || this.odh.cRU == 4 || this.odh.cRU == 5 || this.odh.cRU == 1) {
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                        this.ocU.setVisibility(4);
                        this.ocV.setText(this.odh.nWO);
                        this.nTE.setVisibility(8);
                        if (this.odg == 1) {
                            this.ocY.setOnClickListener(new C33915());
                            this.ocY.setVisibility(0);
                        } else {
                            this.ocY.setVisibility(8);
                        }
                    } else {
                        if (!C5046bo.isNullOrNil(this.odh.nYl)) {
                            this.odf = this.odh.nYl;
                            if (this.odh.nYm == 1) {
                                this.odd.setVisibility(8);
                            } else {
                                C4990ab.m7416i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.odh.nYl);
                                if (this.odh.nYj == 1) {
                                    this.odd.setChecked(true);
                                } else {
                                    this.odd.setChecked(false);
                                }
                                this.odd.setText(this.odh.nYk);
                            }
                        }
                        this.nTE.setOnClickListener(new C33924());
                        if (C5046bo.isNullOrNil(this.odh.nWO)) {
                            this.ocU.setVisibility(8);
                        } else {
                            this.ocU.setText(this.odh.nWO);
                        }
                        if (C5046bo.isNullOrNil(this.odh.nYq)) {
                            this.ocV.setVisibility(8);
                        } else {
                            this.ocV.setText(this.odh.nYq);
                        }
                    }
                    C46063x.m85801a(this.nTI, null);
                    this.mController.contentView.setVisibility(0);
                }
                AppMethodBeat.m2505o(42632);
                return true;
            }
        } else if (c1207m instanceof C46057ac) {
            C46063x.m85814d(this.nTE);
            if (i == 0 && i2 == 0) {
                m5676aO(-1, "");
                final C46057ac c46057ac = (C46057ac) c1207m;
                if (c46057ac.cRV != 2) {
                    this.ocU.setVisibility(4);
                    this.ocV.setText(c46057ac.nWO);
                    this.nTE.setVisibility(8);
                    if (this.odg == 1) {
                        this.ocY.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(42626);
                                Intent intent = new Intent();
                                intent.setClass(LuckyMoneyBusiReceiveUI.this.mController.ylL, LuckyMoneyBusiDetailUI.class);
                                if (c46057ac.nTN != null) {
                                    intent.putExtra("key_realname_guide_helper", c46057ac.nTN);
                                }
                                intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.this.ocK);
                                intent.putExtra("key_sendid", c46057ac.nSX);
                                intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.this.ocM);
                                LuckyMoneyBusiReceiveUI.this.startActivity(intent);
                                LuckyMoneyBusiReceiveUI.this.finish();
                                AppMethodBeat.m2505o(42626);
                            }
                        });
                        this.ocY.setVisibility(0);
                    } else {
                        this.ocY.setVisibility(8);
                    }
                } else if (c46057ac.kCd <= 1 || !(c46057ac.nXd == null || c46057ac.nXd.erD == 1)) {
                    C4990ab.m7416i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
                    intent = new Intent();
                    intent.putExtra("key_sendid", c46057ac.nSX);
                    intent.putExtra("key_static_from_scene", this.ocM);
                    if (c46057ac.nTN != null) {
                        intent.putExtra("key_realname_guide_helper", c46057ac.nTN);
                    }
                    try {
                        intent.putExtra("key_detail_info", c46057ac.nYn.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e) {
                        C4990ab.m7420w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                    }
                    if (C26373g.m41964Nu().getInt("PlayCoinSound", 0) > 0) {
                        intent.putExtra("play_sound", true);
                    }
                    C25985d.m41467b(this.mController.ylL, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
                    finish();
                    AppMethodBeat.m2505o(42632);
                    return true;
                } else {
                    CharSequence string;
                    final View findViewById = findViewById(2131825420);
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-findViewById.getHeight()));
                    translateAnimation.setDuration(400);
                    translateAnimation.setFillAfter(true);
                    translateAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.m2504i(42621);
                            findViewById.setVisibility(8);
                            AppMethodBeat.m2505o(42621);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    findViewById.startAnimation(translateAnimation);
                    this.nSD.setText(C36391e.m59971F(((double) c46057ac.cSh) / 100.0d));
                    this.nTD.setText(c46057ac.nYf);
                    this.ocU.setVisibility(8);
                    this.ocV.setVisibility(8);
                    this.ocW.setVisibility(0);
                    this.nTE.setVisibility(8);
                    if (C5046bo.isNullOrNil(c46057ac.nYi)) {
                        string = getString(C25738R.string.ctb);
                    } else {
                        string = c46057ac.nYi;
                    }
                    this.odb.setText(string);
                    this.odc.setVisibility(0);
                    C7060h.pYm.mo8381e(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                    C4990ab.m7416i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + c46057ac.kCd);
                    if (c46057ac.kCd > 1 || (c46057ac.nXd != null && c46057ac.nXd.erD == 1)) {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
                        this.odi = c46057ac.nTN;
                        this.odb.setOnClickListener(new OnClickListener() {

                            /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI$7$2 */
                            class C33972 implements AnimationListener {
                                C33972() {
                                }

                                public final void onAnimationStart(Animation animation) {
                                    AppMethodBeat.m2504i(42623);
                                    LuckyMoneyBusiReceiveUI.this.nTI.setVisibility(0);
                                    AppMethodBeat.m2505o(42623);
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                }
                            }

                            /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI$7$1 */
                            class C33981 implements OnClickListener {
                                C33981() {
                                }

                                public final void onClick(View view) {
                                    AppMethodBeat.m2504i(42622);
                                    C7060h.pYm.mo8381e(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                                    C46063x.m85805a(LuckyMoneyBusiReceiveUI.this, 1, false);
                                    AppMethodBeat.m2505o(42622);
                                }
                            }

                            public final void onClick(View view) {
                                CharSequence string;
                                AppMethodBeat.m2504i(42624);
                                LuckyMoneyBusiReceiveUI.this.nTI.setVisibility(4);
                                LuckyMoneyBusiReceiveUI.this.odc.setVisibility(8);
                                LuckyMoneyBusiReceiveUI.this.ocW.setVisibility(8);
                                if (c46057ac.nXd == null || C5046bo.isNullOrNil(c46057ac.nXd.nWz)) {
                                    string = LuckyMoneyBusiReceiveUI.this.getString(C25738R.string.ctc);
                                } else {
                                    string = c46057ac.nXd.nWz;
                                }
                                LuckyMoneyBusiReceiveUI.this.odb.setText(string);
                                LuckyMoneyBusiReceiveUI.this.oda.setText(c46057ac.nYg);
                                LuckyMoneyBusiReceiveUI.this.ocZ.setVisibility(0);
                                LuckyMoneyBusiReceiveUI.this.odb.setOnClickListener(new C33981());
                                C46063x.m85801a(LuckyMoneyBusiReceiveUI.this.nTI, new C33972());
                                AppMethodBeat.m2505o(42624);
                            }
                        });
                    } else {
                        this.odb.setOnClickListener(new C33998());
                    }
                    this.odb.setVisibility(0);
                }
                AppMethodBeat.m2505o(42632);
                return true;
            } else if (i2 == 416) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                this.nTE.setBackgroundResource(C25738R.drawable.b5t);
                C339310 c339310 = new C339310();
                boolean a = C46063x.m85808a(this, i2, c1207m, bundle, false, new C33902(), 1005);
                AppMethodBeat.m2505o(42632);
                return a;
            }
        } else if (c1207m instanceof C21198ar) {
            if (i == 0 && i2 == 0) {
                C30379h.m48465bQ(this, getString(C25738R.string.cbn));
                C7060h.pYm.mo8381e(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                finish();
                AppMethodBeat.m2505o(42632);
                return true;
            }
            C30379h.m48465bQ(this, str);
            AppMethodBeat.m2505o(42632);
            return true;
        } else if (c1207m instanceof C39317ab) {
            if (i == 0 && i2 == 0) {
                mo24304n(new C36784ad(this.ocI, this.ocK, this.ode, getIntent().getStringExtra("packageExt")));
                AppMethodBeat.m2505o(42632);
                return true;
            }
        } else if (c1207m instanceof C12432y) {
            AppMethodBeat.m2505o(42632);
            return true;
        } else if (c1207m instanceof C12425af) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            if (i == 0 && i2 == 0) {
                C12425af c12425af = (C12425af) c1207m;
                intent = new Intent();
                intent.setClass(this.mController.ylL, LuckyMoneyBusiDetailUI.class);
                try {
                    intent.putExtra("key_detail_info", c12425af.nYn.toByteArray());
                    intent.putExtra("key_jump_from", 2);
                } catch (IOException e2) {
                    C4990ab.m7420w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                }
                intent.putExtra("key_native_url", this.ocK);
                intent.putExtra("key_sendid", this.ocI);
                intent.putExtra("key_static_from_scene", this.ocM);
                startActivity(intent);
                finish();
                AppMethodBeat.m2505o(42632);
                return true;
            }
        }
        if (!(i == 0 && i2 == 0)) {
            m5676aO(2, str);
        }
        AppMethodBeat.m2505o(42632);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(42633);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    C7060h.pYm.mo8381e(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), stringExtra);
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        mo24304n(new C21198ar(stringExtra, this.ocI, "v1.0"));
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(42633);
    }

    public final int getLayoutId() {
        return 2130969971;
    }

    /* renamed from: aO */
    private void m5676aO(int i, String str) {
        AppMethodBeat.m2504i(42634);
        C4990ab.m7417i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", Integer.valueOf(i), str);
        Intent intent = new Intent();
        intent.putExtra("key_result_errmsg", str);
        setResult(i, intent);
        AppMethodBeat.m2505o(42634);
    }

    private void init() {
        AppMethodBeat.m2504i(42628);
        this.tipDialog = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.cn5), true, new C33891());
        if (this.ode == 3) {
            mo24301b(new C39317ab(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
        } else if (this.ode == 4) {
            mo24301b(new C39317ab(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        } else {
            try {
                this.ocI = Uri.parse(C5046bo.nullAsNil(this.ocK)).getQueryParameter("sendid");
            } catch (Exception e) {
            }
            if (C5046bo.isNullOrNil(this.ocI)) {
                finish();
                C4990ab.m7420w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
            } else {
                mo24301b(new C36784ad(this.ocI, this.ocK, this.ode, getIntent().getStringExtra("packageExt")), false);
            }
        }
        m5676aO(0, "");
        AppMethodBeat.m2505o(42628);
    }

    /* renamed from: i */
    static /* synthetic */ void m5684i(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        AppMethodBeat.m2504i(42635);
        luckyMoneyBusiReceiveUI.mo24301b(new C46057ac(luckyMoneyBusiReceiveUI.odh.nSX, luckyMoneyBusiReceiveUI.odh.cRS, luckyMoneyBusiReceiveUI.odh.nYo, luckyMoneyBusiReceiveUI.getIntent().getStringExtra("packageExt"), luckyMoneyBusiReceiveUI.getIntent().getStringExtra("key_username")), false);
        C46063x.m85810b(luckyMoneyBusiReceiveUI.nTE);
        AppMethodBeat.m2505o(42635);
    }
}
