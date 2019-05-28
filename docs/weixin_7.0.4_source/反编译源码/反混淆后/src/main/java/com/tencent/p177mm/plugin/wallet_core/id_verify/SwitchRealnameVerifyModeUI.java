package com.tencent.p177mm.plugin.wallet_core.id_verify;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C40107b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s.C7187a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s.C7188b;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C16077f;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI */
public class SwitchRealnameVerifyModeUI extends WalletBaseUI implements OnClickListener {
    private int gwj = 0;
    private C7186s onl = new C7186s();
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

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI$7 */
    class C225717 implements OnMenuItemClickListener {
        C225717() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46596);
            C36391e.m59982a(18, C5046bo.anT(), SwitchRealnameVerifyModeUI.this.gwj);
            C36391e.m60016n(SwitchRealnameVerifyModeUI.this.mController.ylL, SwitchRealnameVerifyModeUI.this.tvg, false);
            AppMethodBeat.m2505o(46596);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI$1 */
    class C296221 implements C7188b {
        C296221() {
        }

        public final int bNq() {
            return 1;
        }

        public final Context getContext() {
            return SwitchRealnameVerifyModeUI.this;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI$8 */
    class C296238 implements OnClickListener {
        C296238() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46597);
            Intent intent = new Intent();
            intent.putExtra("wallet_lock_jsapi_scene", 2);
            C25985d.m41467b(SwitchRealnameVerifyModeUI.this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
            AppMethodBeat.m2505o(46597);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI$2 */
    class C400982 implements OnMenuItemClickListener {
        C400982() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46590);
            C40931c dOD = SwitchRealnameVerifyModeUI.this.dOD();
            if (dOD != null) {
                C36391e.m59982a(14, C5046bo.anT(), SwitchRealnameVerifyModeUI.this.gwj);
                dOD.mo8127c(SwitchRealnameVerifyModeUI.this, 0);
                AppMethodBeat.m2505o(46590);
                return true;
            }
            SwitchRealnameVerifyModeUI.this.finish();
            AppMethodBeat.m2505o(46590);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI$3 */
    class C400993 implements C16077f {
        C400993() {
        }

        public final void bMI() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI$6 */
    class C401016 implements DialogInterface.OnClickListener {
        C401016() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(46595);
            SwitchRealnameVerifyModeUI.this.finish();
            AppMethodBeat.m2505o(46595);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SwitchRealnameVerifyModeUI() {
        AppMethodBeat.m2504i(46598);
        AppMethodBeat.m2505o(46598);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46599);
        super.onResume();
        this.onl.onResume();
        AppMethodBeat.m2505o(46599);
    }

    public void onPause() {
        AppMethodBeat.m2504i(46600);
        super.onPause();
        this.onl.onPause();
        AppMethodBeat.m2505o(46600);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46601);
        super.onDestroy();
        AppMethodBeat.m2505o(46601);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46602);
        super.onCreate(bundle);
        this.tvk = this.mBundle.getBoolean("key_from_set_pwd", false);
        initView();
        dOD();
        this.gwj = this.mBundle.getInt("entry_scene", this.gwj);
        C36391e.m59982a(13, C5046bo.anT(), this.gwj);
        if (this.tvk) {
            setMMTitle((int) C25738R.string.fqi);
        }
        this.onl.tLw = new C296221();
        AppMethodBeat.m2505o(46602);
    }

    public final void initView() {
        AppMethodBeat.m2504i(46603);
        setMMTitle("");
        this.tuV = findViewById(2131829036);
        this.tuW = findViewById(2131829040);
        this.tuX = findViewById(2131829032);
        this.tuW.setOnClickListener(this);
        this.tuV.setOnClickListener(this);
        this.tuX.setOnClickListener(this);
        this.tuY = (TextView) findViewById(2131829037);
        this.tuZ = (TextView) findViewById(2131829038);
        this.tva = (TextView) findViewById(2131829041);
        this.tvb = (TextView) findViewById(2131829042);
        this.tvc = (TextView) findViewById(2131829043);
        this.tvd = (TextView) findViewById(2131828918);
        this.tve = (TextView) findViewById(2131829033);
        this.tvf = (TextView) findViewById(2131829034);
        if (this.tvk) {
            ((TextView) findViewById(2131829031)).setText(C25738R.string.fqj);
        }
        m68731nd(false);
        cOY();
        setBackBtn(new C400982());
        AppMethodBeat.m2505o(46603);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46604);
        if (c1207m instanceof C22558a) {
            if (i == 0 && i2 == 0) {
                C46512f.akr(((C22558a) c1207m).cOS());
                mo39993ng(580);
                C40931c dOD = dOD();
                if (dOD != null) {
                    Bundle bundle = dOD.mqu;
                    bundle.putInt("real_name_verify_mode", 1);
                    C24143a.m37116j(this, bundle);
                }
                AppMethodBeat.m2505o(46604);
                return true;
            }
        } else if (c1207m instanceof C40107b) {
            boolean z;
            mo39993ng(1666);
            m68731nd(true);
            C40107b c40107b = (C40107b) c1207m;
            this.ttQ = c40107b.ttQ;
            if (c40107b.nYe == null) {
                z = false;
            } else {
                z = true;
            }
            if (z && c40107b.nYe.mo39946a((Activity) this, new C400993())) {
                AppMethodBeat.m2505o(46604);
                return true;
            }
        }
        AppMethodBeat.m2505o(46604);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(46605);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.onl.bNo();
                AppMethodBeat.m2505o(46605);
                return;
            }
            this.onl.cancel();
        }
        AppMethodBeat.m2505o(46605);
    }

    public final int getLayoutId() {
        return 2130971160;
    }

    public void onClick(final View view) {
        AppMethodBeat.m2504i(46606);
        if (System.currentTimeMillis() - this.tuU <= ((long) this.tuT)) {
            C4990ab.m7412e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
            AppMethodBeat.m2505o(46606);
            return;
        }
        this.tuU = System.currentTimeMillis();
        this.onl.mo15494a(new C7187a() {
            public final void bNo() {
                AppMethodBeat.m2504i(46591);
                SwitchRealnameVerifyModeUI.this.onClickImp(view);
                SwitchRealnameVerifyModeUI.this.ttQ = false;
                AppMethodBeat.m2505o(46591);
            }

            public final void cancel() {
                AppMethodBeat.m2504i(46592);
                SwitchRealnameVerifyModeUI.this.onl.cui = false;
                AppMethodBeat.m2505o(46592);
            }

            public final void bNp() {
                AppMethodBeat.m2504i(46593);
                SwitchRealnameVerifyModeUI.this.onClickImp(view);
                AppMethodBeat.m2505o(46593);
            }
        }, this.ttQ);
        AppMethodBeat.m2505o(46606);
    }

    public void onClickImp(View view) {
        AppMethodBeat.m2504i(46607);
        int id = view.getId();
        final C40931c dOD = dOD();
        if (dOD != null) {
            Bundle bundle = dOD.mqu;
            if (id == 2131829036) {
                C36391e.m59982a(15, C5046bo.anT(), this.gwj);
                if (bundle.getInt("realname_scene") != 1) {
                    bundle.putInt("real_name_verify_mode", 1);
                } else if (getIntent() == null) {
                    String str = "";
                    if (C5046bo.isNullOrNil(str)) {
                        str = getString(C25738R.string.fu2);
                    }
                    C30379h.m48448a((Context) this, str, null, false, new C401016());
                    AppMethodBeat.m2505o(46607);
                    return;
                } else {
                    mo39992nf(580);
                    mo39970a(new C22558a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 8, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)), true, false);
                    AppMethodBeat.m2505o(46607);
                    return;
                }
            } else if (id == 2131829040) {
                C36391e.m59982a(17, C5046bo.anT(), this.gwj);
                bundle.putInt("real_name_verify_mode", 2);
            } else if (id == 2131829032) {
                C36391e.m59982a(16, C5046bo.anT(), this.gwj);
                if (!this.tvj || C5046bo.isNullOrNil(this.tvi)) {
                    bundle.putInt("real_name_verify_mode", 3);
                    bundle.putString("verify_card_flag", "1");
                } else {
                    C30379h.m48447a(this, this.tvi, "", this.tvh, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(46594);
                            Bundle bundle = dOD.mqu;
                            bundle.putInt("real_name_verify_mode", 3);
                            bundle.putString("verify_card_flag", "1");
                            C24143a.m37116j(SwitchRealnameVerifyModeUI.this, bundle);
                            AppMethodBeat.m2505o(46594);
                        }
                    });
                    AppMethodBeat.m2505o(46607);
                    return;
                }
            }
            C24143a.m37116j(this, bundle);
        }
        AppMethodBeat.m2505o(46607);
    }

    private void cOY() {
        AppMethodBeat.m2504i(46608);
        C1207m c40107b = new C40107b();
        mo39992nf(1666);
        mo39970a(c40107b, true, true);
        AppMethodBeat.m2505o(46608);
    }

    private static JSONObject cOZ() {
        AppMethodBeat.m2504i(46609);
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC, (Object) "");
        if (obj != null) {
            String str = (String) obj;
            if (!C5046bo.isNullOrNil(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j = jSONObject.getLong(Param.TIMESTAMP);
                    long j2 = jSONObject.getLong("cache_time");
                    C4990ab.m7416i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + currentTimeMillis + ";timestamp=" + j + ";cachetime=" + j2);
                    if (currentTimeMillis - j > j2) {
                        C4990ab.m7412e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
                        AppMethodBeat.m2505o(46609);
                        return null;
                    }
                    AppMethodBeat.m2505o(46609);
                    return jSONObject;
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
                    AppMethodBeat.m2505o(46609);
                    return null;
                }
            }
        }
        C4990ab.m7416i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
        AppMethodBeat.m2505o(46609);
        return null;
    }

    /* renamed from: nd */
    private boolean m68731nd(boolean z) {
        JSONObject jSONObject;
        AppMethodBeat.m2504i(46610);
        JSONObject cOZ = SwitchRealnameVerifyModeUI.cOZ();
        if (z && cOZ == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = cOZ;
        }
        if (jSONObject != null) {
            String bc = C5046bo.m7532bc(jSONObject.optString("cache_header_titles", getString(C25738R.string.etx)), getString(C25738R.string.etx));
            if (this.tvk) {
                ((TextView) findViewById(2131829031)).setText(C25738R.string.fqj);
            } else {
                ((TextView) findViewById(2131829031)).setText(bc);
            }
            if (jSONObject.optBoolean("isShowBindCardVerify", false)) {
                this.tve.setText(jSONObject.optString("bindCardVerifyTitle"));
                this.tvf.setText(jSONObject.optString("bindCardVerifySubtitle"));
                this.tuX.setVisibility(0);
            } else {
                this.tuX.setVisibility(8);
            }
            if (jSONObject.optBoolean("isShowBindCard", false)) {
                this.tuY.setText(jSONObject.optString("bindcardTitle", getString(C25738R.string.ety)));
                this.tuZ.setText(jSONObject.optString("bindcardSubTitle", getString(C25738R.string.etz)));
                this.tuV.setVisibility(0);
            } else {
                this.tuV.setVisibility(8);
            }
            if (jSONObject.optBoolean("isShowBindId", false)) {
                this.tva.setText(jSONObject.optString("bindIdTitle", getString(C25738R.string.eu0)));
                this.tvb.setText(jSONObject.optString("bindIdSubTitle", getString(C25738R.string.eu1)));
                this.tuW.setVisibility(0);
            } else {
                this.tuW.setVisibility(8);
            }
            this.tvh = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
            this.tvi = jSONObject.optString("bindCardVerifyAlertViewContent", "");
            this.tvj = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
            String optString = jSONObject.optString("extral_wording", "");
            if (C5046bo.isNullOrNil(optString)) {
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
            if (optBoolean && !C5046bo.isNullOrNil(this.tvg)) {
                addIconOptionMenu(0, C25738R.drawable.bli, new C225717());
            }
            if (jSONObject.optBoolean("isShowCapitalSecurity", false)) {
                SpannableString spannableString = new SpannableString("#  " + this.mController.ylL.getResources().getString(C25738R.string.fke));
                Drawable drawable = this.mController.ylL.getResources().getDrawable(C25738R.drawable.icon_shield_pay);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableString.setSpan(new ImageSpan(drawable), 0, 1, 18);
                this.tvd.setText(spannableString, BufferType.SPANNABLE);
                this.tvd.setOnClickListener(new C296238());
                this.tvd.setVisibility(0);
            } else {
                this.tvd.setVisibility(8);
            }
            AppMethodBeat.m2505o(46610);
            return true;
        }
        AppMethodBeat.m2505o(46610);
        return z;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(46611);
        if (i == 4) {
            C40931c dOD = dOD();
            if (dOD != null) {
                C36391e.m59982a(14, C5046bo.anT(), this.gwj);
                dOD.mo8127c((Activity) this, 0);
                AppMethodBeat.m2505o(46611);
                return true;
            }
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(46611);
        return onKeyUp;
    }
}
