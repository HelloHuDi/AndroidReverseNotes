package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.p230g.p231a.C42023mc;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI */
public class EditSignatureUI extends MMActivity {
    private C44275p eir = null;
    private C4884c ekk = new C131961();
    private MMEditText qkH;
    private C3463b qkI;
    final C32782bp qkJ = C32782bp.aao();
    private boolean qkK = false;
    private TextView qkx;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI$a */
    class C13195a implements TextWatcher {
        private int qkM;

        private C13195a() {
            this.qkM = 60;
        }

        /* synthetic */ C13195a(EditSignatureUI editSignatureUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(126947);
            EditSignatureUI.this.enableOptionMenu(true);
            AppMethodBeat.m2505o(126947);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(126948);
            this.qkM = C5584f.m8385bP(60, editable.toString());
            if (this.qkM < 0) {
                this.qkM = 0;
            }
            if (EditSignatureUI.this.qkx != null) {
                EditSignatureUI.this.qkx.setText(this.qkM);
            }
            AppMethodBeat.m2505o(126948);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI$1 */
    class C131961 extends C4884c<C42023mc> {
        C131961() {
            AppMethodBeat.m2504i(126942);
            this.xxI = C42023mc.class.getName().hashCode();
            AppMethodBeat.m2505o(126942);
        }

        /* renamed from: a */
        private boolean m21211a(C42023mc c42023mc) {
            AppMethodBeat.m2504i(126943);
            String str = c42023mc.cHU.cHV;
            String str2 = c42023mc.cHU.cHW;
            int i = c42023mc.cHU.ret;
            if (i != 0 && EditSignatureUI.this.qkH != null) {
                C30379h.m48461b(EditSignatureUI.this, str2, str, true);
                if (EditSignatureUI.this.qkI != null) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7921d(EditSignatureUI.this.qkI);
                }
            } else if (i == 0 && EditSignatureUI.this.qkK) {
                C1720g.m3536RP().mo5239Ry().set(12291, EditSignatureUI.this.qkH.getText().toString().trim());
                EditSignatureUI.this.finish();
            }
            if (EditSignatureUI.this.eir != null) {
                EditSignatureUI.this.eir.dismiss();
            }
            AppMethodBeat.m2505o(126943);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI$2 */
    class C131972 implements OnMenuItemClickListener {
        C131972() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126945);
            EditSignatureUI.this.aqX();
            EditSignatureUI.this.finish();
            AppMethodBeat.m2505o(126945);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI$3 */
    class C131983 implements OnMenuItemClickListener {
        C131983() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(126946);
            String trim = EditSignatureUI.this.qkH.getText().toString().trim();
            String Ne = C42164b.m74343Ne();
            if (C5046bo.isNullOrNil(Ne) || !trim.matches(".*[" + Ne + "].*")) {
                EditSignatureUI editSignatureUI = EditSignatureUI.this;
                Context context = EditSignatureUI.this.mController.ylL;
                EditSignatureUI.this.getString(C25738R.string.f9238tz);
                editSignatureUI.eir = C30379h.m48458b(context, EditSignatureUI.this.getString(C25738R.string.av5), false, null);
                EditSignatureUI.this.qkI = C1853r.m3859r(18, trim);
                EditSignatureUI.this.qkK = true;
                EditSignatureUI.this.aqX();
                AppMethodBeat.m2505o(126946);
                return true;
            }
            C30379h.m48461b(EditSignatureUI.this.mController.ylL, EditSignatureUI.this.getString(C25738R.string.ce4, new Object[]{Ne}), EditSignatureUI.this.getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(126946);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EditSignatureUI() {
        AppMethodBeat.m2504i(126949);
        AppMethodBeat.m2505o(126949);
    }

    public final int getLayoutId() {
        return 2130969318;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(126950);
        super.onCreate(bundle);
        C4879a.xxA.mo10052c(this.ekk);
        initView();
        AppMethodBeat.m2505o(126950);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(126951);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.ekk);
        AppMethodBeat.m2505o(126951);
    }

    public final void initView() {
        AppMethodBeat.m2504i(126952);
        setMMTitle((int) C25738R.string.eak);
        this.qkH = (MMEditText) findViewById(2131821019);
        this.qkx = (TextView) findViewById(2131823129);
        this.qkH.setText(C44089j.m79293b((Context) this, C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(12291, null)), this.qkH.getTextSize()));
        this.qkH.setSelection(this.qkH.getText().length());
        this.qkx.setText(C5584f.m8385bP(60, this.qkH.getEditableText().toString()));
        C7357c.m12555d(this.qkH).mo15880hz(0, 60).mo15879a(null);
        this.qkH.addTextChangedListener(new C13195a(this, (byte) 0));
        setBackBtn(new C131972());
        mo17379a(0, getString(C25738R.string.f9218tc), (OnMenuItemClickListener) new C131983(), C5535b.GREEN);
        enableOptionMenu(false);
        AppMethodBeat.m2505o(126952);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(126953);
        if (i == 4) {
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(126953);
        return onKeyDown;
    }
}
