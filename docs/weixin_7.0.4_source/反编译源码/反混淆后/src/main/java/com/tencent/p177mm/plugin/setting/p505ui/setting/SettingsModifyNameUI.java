package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C42023mc;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI */
public class SettingsModifyNameUI extends MMActivity implements C5581a {
    private C44275p eir = null;
    private MMEditText ejH;
    private C4884c ekk = new C348781();
    private C3463b qkI;
    private boolean qkK = false;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI$3 */
    class C38033 implements OnMenuItemClickListener {
        C38033() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127308);
            String obj = SettingsModifyNameUI.this.ejH.getText().toString();
            String Ne = C42164b.m74343Ne();
            if (C5046bo.isNullOrNil(Ne) || !obj.matches(".*[" + Ne + "].*")) {
                C7357c.m12555d(SettingsModifyNameUI.this.ejH).mo15880hz(1, 32).mo15879a(SettingsModifyNameUI.this);
                AppMethodBeat.m2505o(127308);
                return true;
            }
            C30379h.m48461b(SettingsModifyNameUI.this.mController.ylL, SettingsModifyNameUI.this.getString(C25738R.string.ce4, new Object[]{Ne}), SettingsModifyNameUI.this.getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(127308);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI$2 */
    class C217692 implements TextWatcher {
        C217692() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(127307);
            SettingsModifyNameUI.this.enableOptionMenu(true);
            AppMethodBeat.m2505o(127307);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI$1 */
    class C348781 extends C4884c<C42023mc> {
        C348781() {
            super(0);
            AppMethodBeat.m2504i(127304);
            this.xxI = C42023mc.class.getName().hashCode();
            AppMethodBeat.m2505o(127304);
        }

        /* renamed from: a */
        private boolean m57277a(C42023mc c42023mc) {
            AppMethodBeat.m2504i(127305);
            String str = c42023mc.cHU.cHV;
            String str2 = c42023mc.cHU.cHW;
            int i = c42023mc.cHU.ret;
            if (i != 0 && str2 != null) {
                C30379h.m48461b(SettingsModifyNameUI.this, str2, str, true);
                if (SettingsModifyNameUI.this.qkI != null) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7921d(SettingsModifyNameUI.this.qkI);
                }
            } else if (i == 0 && SettingsModifyNameUI.this.qkK) {
                C1720g.m3536RP().mo5239Ry().set(4, SettingsModifyNameUI.this.ejH.getText().toString());
                SettingsModifyNameUI.this.finish();
            }
            if (SettingsModifyNameUI.this.eir != null) {
                SettingsModifyNameUI.this.eir.dismiss();
            }
            AppMethodBeat.m2505o(127305);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI$4 */
    class C348794 implements OnMenuItemClickListener {
        C348794() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127309);
            SettingsModifyNameUI.this.aqX();
            SettingsModifyNameUI.this.finish();
            AppMethodBeat.m2505o(127309);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsModifyNameUI() {
        AppMethodBeat.m2504i(127310);
        AppMethodBeat.m2505o(127310);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127311);
        super.onCreate(bundle);
        C4879a.xxA.mo10052c(this.ekk);
        initView();
        AppMethodBeat.m2505o(127311);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127312);
        C4879a.xxA.mo10053d(this.ekk);
        super.onDestroy();
        AppMethodBeat.m2505o(127312);
    }

    public final int getLayoutId() {
        return 2130970637;
    }

    public final void initView() {
        AppMethodBeat.m2504i(127313);
        setMMTitle((int) C25738R.string.e8l);
        this.ejH = (MMEditText) findViewById(2131827399);
        this.ejH.setText(C44089j.m79293b((Context) this, (String) C1720g.m3536RP().mo5239Ry().get(4, null), this.ejH.getTextSize()));
        this.ejH.setSelection(this.ejH.getText().length());
        this.ejH.addTextChangedListener(new C217692());
        C7357c hz = C7357c.m12555d(this.ejH).mo15880hz(1, 32);
        hz.zIx = false;
        hz.mo15879a(null);
        mo17379a(0, getString(C25738R.string.f9218tc), (OnMenuItemClickListener) new C38033(), C5535b.GREEN);
        enableOptionMenu(false);
        setBackBtn(new C348794());
        AppMethodBeat.m2505o(127313);
    }

    /* renamed from: ki */
    public final void mo11317ki(String str) {
        AppMethodBeat.m2504i(127314);
        C4990ab.m7416i("MiroMsg.SettingsModifyNameUI", "Set New NickName : ".concat(String.valueOf(str)));
        this.qkK = true;
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.eir = C30379h.m48458b(context, getString(C25738R.string.av5), false, null);
        this.qkI = C1853r.m3859r(2, str);
        AppMethodBeat.m2505o(127314);
    }

    /* renamed from: JW */
    public final void mo11315JW() {
        AppMethodBeat.m2504i(127315);
        C30379h.m48467g(this, C25738R.string.e8m, C25738R.string.e8p);
        AppMethodBeat.m2505o(127315);
    }

    /* renamed from: JX */
    public final void mo11316JX() {
        AppMethodBeat.m2504i(127316);
        C30379h.m48467g(this, C25738R.string.e8n, C25738R.string.e8p);
        AppMethodBeat.m2505o(127316);
    }
}
