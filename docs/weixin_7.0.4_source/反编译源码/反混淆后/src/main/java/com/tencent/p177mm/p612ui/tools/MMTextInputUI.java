package com.tencent.p177mm.p612ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.tools.MMTextInputUI */
public class MMTextInputUI extends MMActivity {
    private int ehD;
    private EditText mLL;
    private TextView zGb;
    private int zGc;
    private int zGd;
    private boolean zGe;

    /* renamed from: com.tencent.mm.ui.tools.MMTextInputUI$3 */
    class C240343 implements OnMenuItemClickListener {
        C240343() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(107726);
            MMTextInputUI.this.mo23730I(MMTextInputUI.this.mLL.getText());
            Intent intent = new Intent();
            intent.putExtra("key_result", MMTextInputUI.this.mLL.getText());
            MMTextInputUI.this.setResult(-1, intent);
            MMTextInputUI.this.finish();
            AppMethodBeat.m2505o(107726);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MMTextInputUI$4 */
    class C240354 implements TextWatcher {
        C240354() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = false;
            AppMethodBeat.m2504i(107727);
            String obj = editable.toString();
            if (!MMTextInputUI.this.zGe) {
                if (obj.trim().length() > 0) {
                    MMTextInputUI.this.enableOptionMenu(true);
                } else {
                    MMTextInputUI.this.enableOptionMenu(false);
                }
            }
            if (MMTextInputUI.this.ehD > 0) {
                MMTextInputUI.this.zGd = 0;
                for (int i = 0; i < obj.length(); i++) {
                    if (C5046bo.m7587y(obj.charAt(i))) {
                        MMTextInputUI.this.zGd = MMTextInputUI.this.zGd + 2;
                    } else {
                        MMTextInputUI.this.zGd = MMTextInputUI.this.zGd + 1;
                    }
                }
                if (MMTextInputUI.this.zGd >= MMTextInputUI.this.zGc && MMTextInputUI.this.zGd <= MMTextInputUI.this.ehD) {
                    MMTextInputUI.this.enableOptionMenu(true);
                    MMTextInputUI.this.zGb.setVisibility(0);
                    MMTextInputUI.this.zGb.setTextColor(MMTextInputUI.this.getResources().getColor(C25738R.color.a2x));
                    MMTextInputUI.this.zGb.setText(MMTextInputUI.this.getString(C25738R.string.evr, new Object[]{Integer.valueOf((MMTextInputUI.this.ehD - MMTextInputUI.this.zGd) >> 1)}));
                    AppMethodBeat.m2505o(107727);
                    return;
                } else if (MMTextInputUI.this.zGd > MMTextInputUI.this.ehD) {
                    MMTextInputUI.this.enableOptionMenu(false);
                    MMTextInputUI.this.zGb.setVisibility(0);
                    MMTextInputUI.this.zGb.setTextColor(MMTextInputUI.this.getResources().getColor(C25738R.color.a2y));
                    MMTextInputUI.this.zGb.setText(MMTextInputUI.this.getString(C25738R.string.evs, new Object[]{Integer.valueOf(((MMTextInputUI.this.zGd - MMTextInputUI.this.ehD) >> 1) + 1)}));
                    AppMethodBeat.m2505o(107727);
                    return;
                } else {
                    MMTextInputUI mMTextInputUI = MMTextInputUI.this;
                    if (MMTextInputUI.this.zGe) {
                        z = true;
                    } else if (MMTextInputUI.this.zGd > 0) {
                        z = true;
                    }
                    mMTextInputUI.enableOptionMenu(z);
                    MMTextInputUI.this.zGb.setVisibility(8);
                }
            }
            AppMethodBeat.m2505o(107727);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MMTextInputUI$1 */
    class C363311 implements OnClickListener {
        C363311() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(107724);
            MMTextInputUI.this.aqX();
            MMTextInputUI.this.setResult(0);
            MMTextInputUI.this.finish();
            AppMethodBeat.m2505o(107724);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.MMTextInputUI$2 */
    class C363322 implements OnMenuItemClickListener {
        C363322() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(107725);
            MMTextInputUI.m59791a(MMTextInputUI.this);
            AppMethodBeat.m2505o(107725);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m59791a(MMTextInputUI mMTextInputUI) {
        AppMethodBeat.m2504i(107734);
        mMTextInputUI.goBack();
        AppMethodBeat.m2505o(107734);
    }

    public int getLayoutId() {
        return 2130969865;
    }

    private void goBack() {
        AppMethodBeat.m2504i(107728);
        if (getIntent().getBooleanExtra("key_show_confirm", false)) {
            C30379h.m48440a(this.mController.ylL, getString(C25738R.string.dgt), "", new C363311(), null);
            AppMethodBeat.m2505o(107728);
            return;
        }
        aqX();
        setResult(0);
        finish();
        AppMethodBeat.m2505o(107728);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(107729);
        if (4 == i) {
            C4990ab.m7416i("MicroMsg.MMTextInputUI", "on back key down");
            goBack();
            AppMethodBeat.m2505o(107729);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(107729);
        return onKeyDown;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(107730);
        super.onCreate(bundle);
        this.mLL = (EditText) findViewById(2131823386);
        this.zGb = (TextView) findViewById(2131823892);
        this.mLL.setHint(C5046bo.m7532bc(getIntent().getStringExtra("key_hint"), ""));
        this.mLL.append(C5046bo.m7532bc(getIntent().getStringExtra("key_value"), ""));
        this.ehD = getIntent().getIntExtra("key_max_count", -1) << 1;
        this.zGd = 0;
        this.zGc = Math.max(this.ehD - 120, (this.ehD * 9) / 10);
        this.zGe = getIntent().getBooleanExtra("key_nullable", false);
        setBackBtn(new C363322());
        mo17379a(0, getString(C25738R.string.f9142qt), (OnMenuItemClickListener) new C240343(), C5535b.GREEN);
        enableOptionMenu(this.zGe);
        if (!this.zGe || this.ehD > 0) {
            this.mLL.addTextChangedListener(new C240354());
        }
        AppMethodBeat.m2505o(107730);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: I */
    public void mo23730I(CharSequence charSequence) {
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(107731);
        super.onDestroy();
        AppMethodBeat.m2505o(107731);
    }

    public void onResume() {
        AppMethodBeat.m2504i(107732);
        super.onResume();
        AppMethodBeat.m2505o(107732);
    }

    public void onPause() {
        AppMethodBeat.m2504i(107733);
        super.onPause();
        AppMethodBeat.m2505o(107733);
    }
}
