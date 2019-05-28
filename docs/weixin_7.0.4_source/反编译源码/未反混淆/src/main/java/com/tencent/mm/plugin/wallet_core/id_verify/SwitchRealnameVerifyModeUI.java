package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.plugin.wallet_core.ui.s.b;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI extends WalletBaseUI implements OnClickListener {
    private int gwj = 0;
    private s onl = new s();
    private boolean ttQ = false;
    private int tuT = 500;
    private long tuU = 0;
    private View tuV;
    private View tuW;
    private View tuX;
    private TextView tuY;
    private TextView tuZ;
    private TextView tva;
    private TextView tvb;
    private TextView tvc;
    private TextView tvd;
    private TextView tve;
    private TextView tvf;
    private String tvg;
    private String tvh;
    private String tvi;
    private boolean tvj;
    private boolean tvk = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SwitchRealnameVerifyModeUI() {
        AppMethodBeat.i(46598);
        AppMethodBeat.o(46598);
    }

    public void onResume() {
        AppMethodBeat.i(46599);
        super.onResume();
        this.onl.onResume();
        AppMethodBeat.o(46599);
    }

    public void onPause() {
        AppMethodBeat.i(46600);
        super.onPause();
        this.onl.onPause();
        AppMethodBeat.o(46600);
    }

    public void onDestroy() {
        AppMethodBeat.i(46601);
        super.onDestroy();
        AppMethodBeat.o(46601);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46602);
        super.onCreate(bundle);
        this.tvk = this.mBundle.getBoolean("key_from_set_pwd", false);
        initView();
        dOD();
        this.gwj = this.mBundle.getInt("entry_scene", this.gwj);
        e.a(13, bo.anT(), this.gwj);
        if (this.tvk) {
            setMMTitle((int) R.string.fqi);
        }
        this.onl.tLw = new b() {
            public final int bNq() {
                return 1;
            }

            public final Context getContext() {
                return SwitchRealnameVerifyModeUI.this;
            }
        };
        AppMethodBeat.o(46602);
    }

    public final void initView() {
        AppMethodBeat.i(46603);
        setMMTitle("");
        this.tuV = findViewById(R.id.fgj);
        this.tuW = findViewById(R.id.fgn);
        this.tuX = findViewById(R.id.fgf);
        this.tuW.setOnClickListener(this);
        this.tuV.setOnClickListener(this);
        this.tuX.setOnClickListener(this);
        this.tuY = (TextView) findViewById(R.id.fgk);
        this.tuZ = (TextView) findViewById(R.id.fgl);
        this.tva = (TextView) findViewById(R.id.fgo);
        this.tvb = (TextView) findViewById(R.id.fgp);
        this.tvc = (TextView) findViewById(R.id.fgq);
        this.tvd = (TextView) findViewById(R.id.fdc);
        this.tve = (TextView) findViewById(R.id.fgg);
        this.tvf = (TextView) findViewById(R.id.fgh);
        if (this.tvk) {
            ((TextView) findViewById(R.id.fge)).setText(R.string.fqj);
        }
        nd(false);
        cOY();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46590);
                c dOD = SwitchRealnameVerifyModeUI.this.dOD();
                if (dOD != null) {
                    e.a(14, bo.anT(), SwitchRealnameVerifyModeUI.this.gwj);
                    dOD.c(SwitchRealnameVerifyModeUI.this, 0);
                    AppMethodBeat.o(46590);
                    return true;
                }
                SwitchRealnameVerifyModeUI.this.finish();
                AppMethodBeat.o(46590);
                return false;
            }
        });
        AppMethodBeat.o(46603);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46604);
        if (mVar instanceof a) {
            if (i == 0 && i2 == 0) {
                f.akr(((a) mVar).cOS());
                ng(580);
                c dOD = dOD();
                if (dOD != null) {
                    Bundle bundle = dOD.mqu;
                    bundle.putInt("real_name_verify_mode", 1);
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                }
                AppMethodBeat.o(46604);
                return true;
            }
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.b) {
            boolean z;
            ng(1666);
            nd(true);
            com.tencent.mm.plugin.wallet_core.id_verify.model.b bVar = (com.tencent.mm.plugin.wallet_core.id_verify.model.b) mVar;
            this.ttQ = bVar.ttQ;
            if (bVar.nYe == null) {
                z = false;
            } else {
                z = true;
            }
            if (z && bVar.nYe.a((Activity) this, new com.tencent.mm.wallet_core.c.f() {
                public final void bMI() {
                }
            })) {
                AppMethodBeat.o(46604);
                return true;
            }
        }
        AppMethodBeat.o(46604);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(46605);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.onl.bNo();
                AppMethodBeat.o(46605);
                return;
            }
            this.onl.cancel();
        }
        AppMethodBeat.o(46605);
    }

    public final int getLayoutId() {
        return R.layout.b5x;
    }

    public void onClick(final View view) {
        AppMethodBeat.i(46606);
        if (System.currentTimeMillis() - this.tuU <= ((long) this.tuT)) {
            ab.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
            AppMethodBeat.o(46606);
            return;
        }
        this.tuU = System.currentTimeMillis();
        this.onl.a(new s.a() {
            public final void bNo() {
                AppMethodBeat.i(46591);
                SwitchRealnameVerifyModeUI.this.onClickImp(view);
                SwitchRealnameVerifyModeUI.this.ttQ = false;
                AppMethodBeat.o(46591);
            }

            public final void cancel() {
                AppMethodBeat.i(46592);
                SwitchRealnameVerifyModeUI.this.onl.cui = false;
                AppMethodBeat.o(46592);
            }

            public final void bNp() {
                AppMethodBeat.i(46593);
                SwitchRealnameVerifyModeUI.this.onClickImp(view);
                AppMethodBeat.o(46593);
            }
        }, this.ttQ);
        AppMethodBeat.o(46606);
    }

    public void onClickImp(View view) {
        AppMethodBeat.i(46607);
        int id = view.getId();
        final c dOD = dOD();
        if (dOD != null) {
            Bundle bundle = dOD.mqu;
            if (id == R.id.fgj) {
                e.a(15, bo.anT(), this.gwj);
                if (bundle.getInt("realname_scene") != 1) {
                    bundle.putInt("real_name_verify_mode", 1);
                } else if (getIntent() == null) {
                    String str = "";
                    if (bo.isNullOrNil(str)) {
                        str = getString(R.string.fu2);
                    }
                    h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(46595);
                            SwitchRealnameVerifyModeUI.this.finish();
                            AppMethodBeat.o(46595);
                        }
                    });
                    AppMethodBeat.o(46607);
                    return;
                } else {
                    nf(580);
                    a(new a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 8, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)), true, false);
                    AppMethodBeat.o(46607);
                    return;
                }
            } else if (id == R.id.fgn) {
                e.a(17, bo.anT(), this.gwj);
                bundle.putInt("real_name_verify_mode", 2);
            } else if (id == R.id.fgf) {
                e.a(16, bo.anT(), this.gwj);
                if (!this.tvj || bo.isNullOrNil(this.tvi)) {
                    bundle.putInt("real_name_verify_mode", 3);
                    bundle.putString("verify_card_flag", "1");
                } else {
                    h.a(this, this.tvi, "", this.tvh, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(46594);
                            Bundle bundle = dOD.mqu;
                            bundle.putInt("real_name_verify_mode", 3);
                            bundle.putString("verify_card_flag", "1");
                            com.tencent.mm.wallet_core.a.j(SwitchRealnameVerifyModeUI.this, bundle);
                            AppMethodBeat.o(46594);
                        }
                    });
                    AppMethodBeat.o(46607);
                    return;
                }
            }
            com.tencent.mm.wallet_core.a.j(this, bundle);
        }
        AppMethodBeat.o(46607);
    }

    private void cOY() {
        AppMethodBeat.i(46608);
        m bVar = new com.tencent.mm.plugin.wallet_core.id_verify.model.b();
        nf(1666);
        a(bVar, true, true);
        AppMethodBeat.o(46608);
    }

    private static JSONObject cOZ() {
        AppMethodBeat.i(46609);
        g.RQ();
        Object obj = g.RP().Ry().get(ac.a.USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC, (Object) "");
        if (obj != null) {
            String str = (String) obj;
            if (!bo.isNullOrNil(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j = jSONObject.getLong(Param.TIMESTAMP);
                    long j2 = jSONObject.getLong("cache_time");
                    ab.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + currentTimeMillis + ";timestamp=" + j + ";cachetime=" + j2);
                    if (currentTimeMillis - j > j2) {
                        ab.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
                        AppMethodBeat.o(46609);
                        return null;
                    }
                    AppMethodBeat.o(46609);
                    return jSONObject;
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", e, "", new Object[0]);
                    ab.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
                    AppMethodBeat.o(46609);
                    return null;
                }
            }
        }
        ab.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
        AppMethodBeat.o(46609);
        return null;
    }

    private boolean nd(boolean z) {
        JSONObject jSONObject;
        AppMethodBeat.i(46610);
        JSONObject cOZ = cOZ();
        if (z && cOZ == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = cOZ;
        }
        if (jSONObject != null) {
            String bc = bo.bc(jSONObject.optString("cache_header_titles", getString(R.string.etx)), getString(R.string.etx));
            if (this.tvk) {
                ((TextView) findViewById(R.id.fge)).setText(R.string.fqj);
            } else {
                ((TextView) findViewById(R.id.fge)).setText(bc);
            }
            if (jSONObject.optBoolean("isShowBindCardVerify", false)) {
                this.tve.setText(jSONObject.optString("bindCardVerifyTitle"));
                this.tvf.setText(jSONObject.optString("bindCardVerifySubtitle"));
                this.tuX.setVisibility(0);
            } else {
                this.tuX.setVisibility(8);
            }
            if (jSONObject.optBoolean("isShowBindCard", false)) {
                this.tuY.setText(jSONObject.optString("bindcardTitle", getString(R.string.ety)));
                this.tuZ.setText(jSONObject.optString("bindcardSubTitle", getString(R.string.etz)));
                this.tuV.setVisibility(0);
            } else {
                this.tuV.setVisibility(8);
            }
            if (jSONObject.optBoolean("isShowBindId", false)) {
                this.tva.setText(jSONObject.optString("bindIdTitle", getString(R.string.eu0)));
                this.tvb.setText(jSONObject.optString("bindIdSubTitle", getString(R.string.eu1)));
                this.tuW.setVisibility(0);
            } else {
                this.tuW.setVisibility(8);
            }
            this.tvh = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
            this.tvi = jSONObject.optString("bindCardVerifyAlertViewContent", "");
            this.tvj = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
            String optString = jSONObject.optString("extral_wording", "");
            if (bo.isNullOrNil(optString)) {
                this.tvc.setVisibility(8);
            } else {
                this.tvc.setText(optString);
                this.tvc.setVisibility(0);
            }
            this.tvh = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
            this.tvi = jSONObject.optString("bindCardVerifyAlertViewContent");
            this.tvj = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
            boolean optBoolean = jSONObject.optBoolean("question_answer_switch", false);
            this.tvg = jSONObject.optString("question_answer_url", "");
            if (optBoolean && !bo.isNullOrNil(this.tvg)) {
                addIconOptionMenu(0, R.drawable.bli, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(46596);
                        e.a(18, bo.anT(), SwitchRealnameVerifyModeUI.this.gwj);
                        e.n(SwitchRealnameVerifyModeUI.this.mController.ylL, SwitchRealnameVerifyModeUI.this.tvg, false);
                        AppMethodBeat.o(46596);
                        return true;
                    }
                });
            }
            if (jSONObject.optBoolean("isShowCapitalSecurity", false)) {
                SpannableString spannableString = new SpannableString("#  " + this.mController.ylL.getResources().getString(R.string.fke));
                Drawable drawable = this.mController.ylL.getResources().getDrawable(R.drawable.icon_shield_pay);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableString.setSpan(new ImageSpan(drawable), 0, 1, 18);
                this.tvd.setText(spannableString, BufferType.SPANNABLE);
                this.tvd.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(46597);
                        Intent intent = new Intent();
                        intent.putExtra("wallet_lock_jsapi_scene", 2);
                        d.b(SwitchRealnameVerifyModeUI.this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                        AppMethodBeat.o(46597);
                    }
                });
                this.tvd.setVisibility(0);
            } else {
                this.tvd.setVisibility(8);
            }
            AppMethodBeat.o(46610);
            return true;
        }
        AppMethodBeat.o(46610);
        return z;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(46611);
        if (i == 4) {
            c dOD = dOD();
            if (dOD != null) {
                e.a(14, bo.anT(), this.gwj);
                dOD.c((Activity) this, 0);
                AppMethodBeat.o(46611);
                return true;
            }
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(46611);
        return onKeyUp;
    }
}
