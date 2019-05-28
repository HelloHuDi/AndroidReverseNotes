package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class SettingsModifyNameUI extends MMActivity implements a {
    private p eir = null;
    private MMEditText ejH;
    private c ekk = new c<mc>() {
        {
            AppMethodBeat.i(127304);
            this.xxI = mc.class.getName().hashCode();
            AppMethodBeat.o(127304);
        }

        private boolean a(mc mcVar) {
            AppMethodBeat.i(127305);
            String str = mcVar.cHU.cHV;
            String str2 = mcVar.cHU.cHW;
            int i = mcVar.cHU.ret;
            if (i != 0 && str2 != null) {
                h.b(SettingsModifyNameUI.this, str2, str, true);
                if (SettingsModifyNameUI.this.qkI != null) {
                    ((j) g.K(j.class)).XL().d(SettingsModifyNameUI.this.qkI);
                }
            } else if (i == 0 && SettingsModifyNameUI.this.qkK) {
                g.RP().Ry().set(4, SettingsModifyNameUI.this.ejH.getText().toString());
                SettingsModifyNameUI.this.finish();
            }
            if (SettingsModifyNameUI.this.eir != null) {
                SettingsModifyNameUI.this.eir.dismiss();
            }
            AppMethodBeat.o(127305);
            return true;
        }
    };
    private b qkI;
    private boolean qkK = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsModifyNameUI() {
        AppMethodBeat.i(127310);
        AppMethodBeat.o(127310);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127311);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xxA.c(this.ekk);
        initView();
        AppMethodBeat.o(127311);
    }

    public void onDestroy() {
        AppMethodBeat.i(127312);
        com.tencent.mm.sdk.b.a.xxA.d(this.ekk);
        super.onDestroy();
        AppMethodBeat.o(127312);
    }

    public final int getLayoutId() {
        return R.layout.arv;
    }

    public final void initView() {
        AppMethodBeat.i(127313);
        setMMTitle((int) R.string.e8l);
        this.ejH = (MMEditText) findViewById(R.id.e_a);
        this.ejH.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, (String) g.RP().Ry().get(4, null), this.ejH.getTextSize()));
        this.ejH.setSelection(this.ejH.getText().length());
        this.ejH.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(127307);
                SettingsModifyNameUI.this.enableOptionMenu(true);
                AppMethodBeat.o(127307);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        com.tencent.mm.ui.tools.b.c hz = com.tencent.mm.ui.tools.b.c.d(this.ejH).hz(1, 32);
        hz.zIx = false;
        hz.a(null);
        a(0, getString(R.string.tc), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127308);
                String obj = SettingsModifyNameUI.this.ejH.getText().toString();
                String Ne = com.tencent.mm.m.b.Ne();
                if (bo.isNullOrNil(Ne) || !obj.matches(".*[" + Ne + "].*")) {
                    com.tencent.mm.ui.tools.b.c.d(SettingsModifyNameUI.this.ejH).hz(1, 32).a(SettingsModifyNameUI.this);
                    AppMethodBeat.o(127308);
                    return true;
                }
                h.b(SettingsModifyNameUI.this.mController.ylL, SettingsModifyNameUI.this.getString(R.string.ce4, new Object[]{Ne}), SettingsModifyNameUI.this.getString(R.string.tz), true);
                AppMethodBeat.o(127308);
                return false;
            }
        }, q.b.GREEN);
        enableOptionMenu(false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127309);
                SettingsModifyNameUI.this.aqX();
                SettingsModifyNameUI.this.finish();
                AppMethodBeat.o(127309);
                return true;
            }
        });
        AppMethodBeat.o(127313);
    }

    public final void ki(String str) {
        AppMethodBeat.i(127314);
        ab.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : ".concat(String.valueOf(str)));
        this.qkK = true;
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.eir = h.b(context, getString(R.string.av5), false, null);
        this.qkI = r.r(2, str);
        AppMethodBeat.o(127314);
    }

    public final void JW() {
        AppMethodBeat.i(127315);
        h.g(this, R.string.e8m, R.string.e8p);
        AppMethodBeat.o(127315);
    }

    public final void JX() {
        AppMethodBeat.i(127316);
        h.g(this, R.string.e8n, R.string.e8p);
        AppMethodBeat.o(127316);
    }
}
