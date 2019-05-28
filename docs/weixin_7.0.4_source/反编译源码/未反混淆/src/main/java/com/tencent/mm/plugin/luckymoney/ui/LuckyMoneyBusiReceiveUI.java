package com.tencent.mm.plugin.luckymoney.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

@a(3)
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
    private ad odh;
    private RealnameGuideHelper odi;
    private p tipDialog = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42627);
        super.onCreate(bundle);
        this.ocK = getIntent().getStringExtra("key_native_url");
        this.ode = getIntent().getIntExtra("key_way", 5);
        this.ocM = getIntent().getIntExtra("key_static_from_scene", 0);
        ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "nativeurl=" + bo.nullAsNil(this.ocK) + ", mWay=" + this.ode);
        init();
        h.pYm.e(11701, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        initView();
        nf(980);
        AppMethodBeat.o(42627);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(42629);
        if (intent != null && intent.hasExtra("key_is_realname_verify_process")) {
            if (intent.getIntExtra("realname_verify_process_ret", 0) == -1) {
                ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process succ");
                init();
                AppMethodBeat.o(42629);
                return;
            }
            ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "new intent from realname verify process cancel");
            aO(-1, "");
            finish();
        }
        AppMethodBeat.o(42629);
    }

    public void onDestroy() {
        AppMethodBeat.i(42630);
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        ng(980);
        AppMethodBeat.o(42630);
    }

    public final void initView() {
        AppMethodBeat.i(42631);
        this.nTI = findViewById(R.id.cts);
        this.nSM = (ImageView) findViewById(R.id.ctv);
        this.nTD = (TextView) findViewById(R.id.ctw);
        this.ocV = (TextView) findViewById(R.id.cu4);
        this.ocU = (TextView) findViewById(R.id.ctx);
        this.nTE = (Button) findViewById(R.id.cu5);
        this.nVJ = (ImageView) findViewById(R.id.cu9);
        this.ocW = findViewById(R.id.cu1);
        this.nSD = (TextView) findViewById(R.id.cu2);
        this.ocX = (ImageView) findViewById(R.id.ctu);
        this.ocY = (TextView) findViewById(R.id.cu8);
        this.ocZ = findViewById(R.id.cty);
        this.oda = (TextView) findViewById(R.id.ctz);
        this.odb = (Button) findViewById(R.id.cu6);
        this.odc = (TextView) findViewById(R.id.cu3);
        this.odd = (CheckBox) findViewById(R.id.cu7);
        this.nVJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42618);
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                if (LuckyMoneyBusiReceiveUI.this.odi == null || !LuckyMoneyBusiReceiveUI.this.odi.a(LuckyMoneyBusiReceiveUI.this, bundle, null, null, true)) {
                    LuckyMoneyBusiReceiveUI.this.finish();
                    AppMethodBeat.o(42618);
                    return;
                }
                LuckyMoneyBusiReceiveUI.this.odi = null;
                AppMethodBeat.o(42618);
            }
        });
        AM(8);
        AppMethodBeat.o(42631);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42632);
        Intent intent;
        if (mVar instanceof ad) {
            if (i == 0 && i2 == 0) {
                this.odh = (ad) mVar;
                this.ocI = this.odh.nSX;
                this.odg = this.odh.cRT;
                h.pYm.e(13050, Integer.valueOf(this.ocM), Integer.valueOf(1), this.odh.nYl);
                if (this.odh.cRV == 2) {
                    aO(-1, "");
                    b(new af(this.ocI, 11, 0, this.ocK, "v1.0"), false);
                } else {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    x.k(this.nSM, this.odh.nYp);
                    x.a(this.mController.ylL, this.nTD, this.odh.nYf);
                    x.h(this.ocX, this.odh.nXg);
                    if (this.odh.cRV == 1 || this.odh.cRU == 4 || this.odh.cRU == 5 || this.odh.cRU == 1) {
                        h.pYm.e(11701, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                        this.ocU.setVisibility(4);
                        this.ocV.setText(this.odh.nWO);
                        this.nTE.setVisibility(8);
                        if (this.odg == 1) {
                            this.ocY.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.i(42620);
                                    h.pYm.e(11701, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                                    Intent intent = new Intent();
                                    intent.setClass(LuckyMoneyBusiReceiveUI.this.mController.ylL, LuckyMoneyBusiDetailUI.class);
                                    intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.this.ocK);
                                    intent.putExtra("key_sendid", LuckyMoneyBusiReceiveUI.this.odh.nSX);
                                    intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.this.ocM);
                                    LuckyMoneyBusiReceiveUI.this.startActivity(intent);
                                    LuckyMoneyBusiReceiveUI.this.finish();
                                    AppMethodBeat.o(42620);
                                }
                            });
                            this.ocY.setVisibility(0);
                        } else {
                            this.ocY.setVisibility(8);
                        }
                    } else {
                        if (!bo.isNullOrNil(this.odh.nYl)) {
                            this.odf = this.odh.nYl;
                            if (this.odh.nYm == 1) {
                                this.odd.setVisibility(8);
                            } else {
                                ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "show checkbox for " + this.odh.nYl);
                                if (this.odh.nYj == 1) {
                                    this.odd.setChecked(true);
                                } else {
                                    this.odd.setChecked(false);
                                }
                                this.odd.setText(this.odh.nYk);
                            }
                        }
                        this.nTE.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(42619);
                                h.pYm.e(11701, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                                if (LuckyMoneyBusiReceiveUI.this.odd.isChecked()) {
                                    h.pYm.e(13050, Integer.valueOf(LuckyMoneyBusiReceiveUI.this.ocM), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.this.odh.nYl);
                                } else {
                                    h.pYm.e(13050, Integer.valueOf(LuckyMoneyBusiReceiveUI.this.ocM), Integer.valueOf(2), "");
                                }
                                LuckyMoneyBusiReceiveUI.i(LuckyMoneyBusiReceiveUI.this);
                                AppMethodBeat.o(42619);
                            }
                        });
                        if (bo.isNullOrNil(this.odh.nWO)) {
                            this.ocU.setVisibility(8);
                        } else {
                            this.ocU.setText(this.odh.nWO);
                        }
                        if (bo.isNullOrNil(this.odh.nYq)) {
                            this.ocV.setVisibility(8);
                        } else {
                            this.ocV.setText(this.odh.nYq);
                        }
                    }
                    x.a(this.nTI, null);
                    this.mController.contentView.setVisibility(0);
                }
                AppMethodBeat.o(42632);
                return true;
            }
        } else if (mVar instanceof ac) {
            x.d(this.nTE);
            if (i == 0 && i2 == 0) {
                aO(-1, "");
                final ac acVar = (ac) mVar;
                if (acVar.cRV != 2) {
                    this.ocU.setVisibility(4);
                    this.ocV.setText(acVar.nWO);
                    this.nTE.setVisibility(8);
                    if (this.odg == 1) {
                        this.ocY.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(42626);
                                Intent intent = new Intent();
                                intent.setClass(LuckyMoneyBusiReceiveUI.this.mController.ylL, LuckyMoneyBusiDetailUI.class);
                                if (acVar.nTN != null) {
                                    intent.putExtra("key_realname_guide_helper", acVar.nTN);
                                }
                                intent.putExtra("key_native_url", LuckyMoneyBusiReceiveUI.this.ocK);
                                intent.putExtra("key_sendid", acVar.nSX);
                                intent.putExtra("key_static_from_scene", LuckyMoneyBusiReceiveUI.this.ocM);
                                LuckyMoneyBusiReceiveUI.this.startActivity(intent);
                                LuckyMoneyBusiReceiveUI.this.finish();
                                AppMethodBeat.o(42626);
                            }
                        });
                        this.ocY.setVisibility(0);
                    } else {
                        this.ocY.setVisibility(8);
                    }
                } else if (acVar.kCd <= 1 || !(acVar.nXd == null || acVar.nXd.erD == 1)) {
                    ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can not atomic go detail");
                    intent = new Intent();
                    intent.putExtra("key_sendid", acVar.nSX);
                    intent.putExtra("key_static_from_scene", this.ocM);
                    if (acVar.nTN != null) {
                        intent.putExtra("key_realname_guide_helper", acVar.nTN);
                    }
                    try {
                        intent.putExtra("key_detail_info", acVar.nYn.toByteArray());
                        intent.putExtra("key_jump_from", 2);
                    } catch (IOException e) {
                        ab.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                    }
                    if (g.Nu().getInt("PlayCoinSound", 0) > 0) {
                        intent.putExtra("play_sound", true);
                    }
                    d.b(this.mController.ylL, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
                    finish();
                    AppMethodBeat.o(42632);
                    return true;
                } else {
                    CharSequence string;
                    final View findViewById = findViewById(R.id.ctt);
                    TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-findViewById.getHeight()));
                    translateAnimation.setDuration(400);
                    translateAnimation.setFillAfter(true);
                    translateAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(42621);
                            findViewById.setVisibility(8);
                            AppMethodBeat.o(42621);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    findViewById.startAnimation(translateAnimation);
                    this.nSD.setText(e.F(((double) acVar.cSh) / 100.0d));
                    this.nTD.setText(acVar.nYf);
                    this.ocU.setVisibility(8);
                    this.ocV.setVisibility(8);
                    this.ocW.setVisibility(0);
                    this.nTE.setVisibility(8);
                    if (bo.isNullOrNil(acVar.nYi)) {
                        string = getString(R.string.ctb);
                    } else {
                        string = acVar.nYi;
                    }
                    this.odb.setText(string);
                    this.odc.setVisibility(0);
                    h.pYm.e(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                    ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "totalNum:" + acVar.kCd);
                    if (acVar.kCd > 1 || (acVar.nXd != null && acVar.nXd.erD == 1)) {
                        ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "can atomic");
                        this.odi = acVar.nTN;
                        this.odb.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                CharSequence string;
                                AppMethodBeat.i(42624);
                                LuckyMoneyBusiReceiveUI.this.nTI.setVisibility(4);
                                LuckyMoneyBusiReceiveUI.this.odc.setVisibility(8);
                                LuckyMoneyBusiReceiveUI.this.ocW.setVisibility(8);
                                if (acVar.nXd == null || bo.isNullOrNil(acVar.nXd.nWz)) {
                                    string = LuckyMoneyBusiReceiveUI.this.getString(R.string.ctc);
                                } else {
                                    string = acVar.nXd.nWz;
                                }
                                LuckyMoneyBusiReceiveUI.this.odb.setText(string);
                                LuckyMoneyBusiReceiveUI.this.oda.setText(acVar.nYg);
                                LuckyMoneyBusiReceiveUI.this.ocZ.setVisibility(0);
                                LuckyMoneyBusiReceiveUI.this.odb.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(42622);
                                        h.pYm.e(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                                        x.a(LuckyMoneyBusiReceiveUI.this, 1, false);
                                        AppMethodBeat.o(42622);
                                    }
                                });
                                x.a(LuckyMoneyBusiReceiveUI.this.nTI, new AnimationListener() {
                                    public final void onAnimationStart(Animation animation) {
                                        AppMethodBeat.i(42623);
                                        LuckyMoneyBusiReceiveUI.this.nTI.setVisibility(0);
                                        AppMethodBeat.o(42623);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                    }
                                });
                                AppMethodBeat.o(42624);
                            }
                        });
                    } else {
                        this.odb.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(42625);
                                LuckyMoneyBusiReceiveUI.this.finish();
                                AppMethodBeat.o(42625);
                            }
                        });
                    }
                    this.odb.setVisibility(0);
                }
                AppMethodBeat.o(42632);
                return true;
            } else if (i2 == 416) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                this.nTE.setBackgroundResource(R.drawable.b5t);
                AnonymousClass10 anonymousClass10 = new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                };
                boolean a = x.a(this, i2, mVar, bundle, false, new c.a() {
                    public final Intent n(int i, Bundle bundle) {
                        AppMethodBeat.i(42617);
                        ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "re");
                        AppMethodBeat.o(42617);
                        return null;
                    }
                }, 1005);
                AppMethodBeat.o(42632);
                return a;
            }
        } else if (mVar instanceof ar) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.base.h.bQ(this, getString(R.string.cbn));
                h.pYm.e(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                finish();
                AppMethodBeat.o(42632);
                return true;
            }
            com.tencent.mm.ui.base.h.bQ(this, str);
            AppMethodBeat.o(42632);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.luckymoney.model.ab) {
            if (i == 0 && i2 == 0) {
                n(new ad(this.ocI, this.ocK, this.ode, getIntent().getStringExtra("packageExt")));
                AppMethodBeat.o(42632);
                return true;
            }
        } else if (mVar instanceof y) {
            AppMethodBeat.o(42632);
            return true;
        } else if (mVar instanceof af) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            if (i == 0 && i2 == 0) {
                af afVar = (af) mVar;
                intent = new Intent();
                intent.setClass(this.mController.ylL, LuckyMoneyBusiDetailUI.class);
                try {
                    intent.putExtra("key_detail_info", afVar.nYn.toByteArray());
                    intent.putExtra("key_jump_from", 2);
                } catch (IOException e2) {
                    ab.w("MicroMsg.LuckyMoneyBusiReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                }
                intent.putExtra("key_native_url", this.ocK);
                intent.putExtra("key_sendid", this.ocI);
                intent.putExtra("key_static_from_scene", this.ocM);
                startActivity(intent);
                finish();
                AppMethodBeat.o(42632);
                return true;
            }
        }
        if (!(i == 0 && i2 == 0)) {
            aO(2, str);
        }
        AppMethodBeat.o(42632);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(42633);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    h.pYm.e(11701, Integer.valueOf(12), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), stringExtra);
                    if (!bo.isNullOrNil(stringExtra)) {
                        n(new ar(stringExtra, this.ocI, "v1.0"));
                        break;
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(42633);
    }

    public final int getLayoutId() {
        return R.layout.a_w;
    }

    private void aO(int i, String str) {
        AppMethodBeat.i(42634);
        ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "markResult resultCode:%d errMsg:%s", Integer.valueOf(i), str);
        Intent intent = new Intent();
        intent.putExtra("key_result_errmsg", str);
        setResult(i, intent);
        AppMethodBeat.o(42634);
    }

    private void init() {
        AppMethodBeat.i(42628);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this.mController.ylL, getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(42616);
                if (LuckyMoneyBusiReceiveUI.this.tipDialog != null && LuckyMoneyBusiReceiveUI.this.tipDialog.isShowing()) {
                    LuckyMoneyBusiReceiveUI.this.tipDialog.dismiss();
                }
                LuckyMoneyBusiReceiveUI.this.ocz.bLz();
                if (LuckyMoneyBusiReceiveUI.this.mController.contentView.getVisibility() == 8 || LuckyMoneyBusiReceiveUI.this.mController.contentView.getVisibility() == 4) {
                    ab.i("MicroMsg.LuckyMoneyBusiReceiveUI", "user cancel & finish");
                    LuckyMoneyBusiReceiveUI.this.finish();
                }
                AppMethodBeat.o(42616);
            }
        });
        if (this.ode == 3) {
            b(new com.tencent.mm.plugin.luckymoney.model.ab(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url")), false);
        } else if (this.ode == 4) {
            b(new com.tencent.mm.plugin.luckymoney.model.ab(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("key_wxapi_sign"), getIntent().getStringExtra("key_wxapi_package_name")), false);
        } else {
            try {
                this.ocI = Uri.parse(bo.nullAsNil(this.ocK)).getQueryParameter("sendid");
            } catch (Exception e) {
            }
            if (bo.isNullOrNil(this.ocI)) {
                finish();
                ab.w("MicroMsg.LuckyMoneyBusiReceiveUI", "sendid null & finish");
            } else {
                b(new ad(this.ocI, this.ocK, this.ode, getIntent().getStringExtra("packageExt")), false);
            }
        }
        aO(0, "");
        AppMethodBeat.o(42628);
    }

    static /* synthetic */ void i(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        AppMethodBeat.i(42635);
        luckyMoneyBusiReceiveUI.b(new ac(luckyMoneyBusiReceiveUI.odh.nSX, luckyMoneyBusiReceiveUI.odh.cRS, luckyMoneyBusiReceiveUI.odh.nYo, luckyMoneyBusiReceiveUI.getIntent().getStringExtra("packageExt"), luckyMoneyBusiReceiveUI.getIntent().getStringExtra("key_username")), false);
        x.b(luckyMoneyBusiReceiveUI.nTE);
        AppMethodBeat.o(42635);
    }
}
