package com.tencent.p177mm.plugin.subapp.p537ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.subapp.C24837b;
import com.tencent.p177mm.pluginsdk.C44055j;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI */
public class ContactSearchUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    private EditText svm;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI$1 */
    class C78931 implements TextWatcher {
        C78931() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(25525);
            ContactSearchUI.this.enableOptionMenu(editable.length() > 0);
            AppMethodBeat.m2505o(25525);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI$2 */
    class C78942 implements OnEditorActionListener {
        C78942() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(25526);
            if (!(keyEvent == null || keyEvent.getKeyCode() != 66 || C5046bo.isNullOrNil(ContactSearchUI.this.svm.getText().toString().trim()))) {
                ContactSearchUI.m14042b(ContactSearchUI.this);
            }
            AppMethodBeat.m2505o(25526);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI$3 */
    class C78953 implements OnMenuItemClickListener {
        C78953() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25527);
            ContactSearchUI.m14042b(ContactSearchUI.this);
            AppMethodBeat.m2505o(25527);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchUI$4 */
    class C78964 implements OnMenuItemClickListener {
        C78964() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25528);
            ContactSearchUI.this.aqX();
            ContactSearchUI.this.finish();
            AppMethodBeat.m2505o(25528);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m14042b(ContactSearchUI contactSearchUI) {
        AppMethodBeat.m2504i(25537);
        contactSearchUI.cDP();
        AppMethodBeat.m2505o(25537);
    }

    public final int getLayoutId() {
        return 2130969237;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25530);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(25530);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25531);
        C9638aw.m17182Rg().mo14539a(106, (C1202f) this);
        super.onResume();
        AppMethodBeat.m2505o(25531);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25532);
        C9638aw.m17182Rg().mo14546b(106, (C1202f) this);
        super.onPause();
        AppMethodBeat.m2505o(25532);
    }

    public final void initView() {
        AppMethodBeat.m2504i(25533);
        setMMTitle((int) C25738R.string.b2l);
        this.svm = (EditText) findViewById(2131823136);
        this.svm.addTextChangedListener(new C78931());
        this.svm.setImeOptions(3);
        this.svm.setOnEditorActionListener(new C78942());
        addTextOptionMenu(0, getString(C25738R.string.f9141qs), new C78953());
        setBackBtn(new C78964());
        if (getIntent().getBooleanExtra("from_webview", false)) {
            this.svm.setText(getIntent().getStringExtra("userName"));
            cDP();
        }
        AppMethodBeat.m2505o(25533);
    }

    private void cDP() {
        AppMethodBeat.m2504i(25534);
        String trim = this.svm.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            C30379h.m48467g(this.mController.ylL, C25738R.string.f0q, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(25534);
            return;
        }
        C4990ab.m7410d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
        final C1207m c12518f = new C12518f(trim, 1);
        C9638aw.m17182Rg().mo14541a(c12518f, 0);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b(context, getString(C25738R.string.f8773ek), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(25529);
                C9638aw.m17182Rg().mo14547c(c12518f);
                AppMethodBeat.m2505o(25529);
            }
        });
        AppMethodBeat.m2505o(25534);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(25535);
        C4990ab.m7416i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (C24837b.gkF.mo38861b(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.m2505o(25535);
        } else if (i == 4 && i2 == -4) {
            C30379h.m48467g(this.mController.ylL, C25738R.string.f8767ee, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(25535);
        } else if (i == 0 && i2 == 0) {
            buv bOj = ((C12518f) c1207m).bOj();
            if (bOj.wod > 0) {
                Intent intent = new Intent();
                intent.setClass(this, ContactSearchResultUI.class);
                try {
                    intent.putExtra("result", bOj.toByteArray());
                    startActivity(intent);
                    AppMethodBeat.m2505o(25535);
                    return;
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ContactSearchUI", e, "", new Object[0]);
                    AppMethodBeat.m2505o(25535);
                    return;
                }
            }
            String a = C1946aa.m4148a(bOj.wcB);
            Intent intent2 = new Intent();
            ((C44055j) C1720g.m3528K(C44055j.class)).mo41537a(intent2, bOj, ContactSearchUI.abq(this.svm.getText().toString().trim()));
            if (C5046bo.nullAsNil(a).length() > 0) {
                if ((bOj.wBT & 8) > 0) {
                    C7060h.pYm.mo8374X(10298, a + "," + ContactSearchUI.abq(this.svm.getText().toString().trim()));
                }
                C25985d.m41467b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
            }
            AppMethodBeat.m2505o(25535);
        } else {
            Toast.makeText(this, getString(C25738R.string.byl), 0).show();
            C4990ab.m7420w("MicroMsg.ContactSearchUI", getString(C25738R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            AppMethodBeat.m2505o(25535);
        }
    }

    private static int abq(String str) {
        AppMethodBeat.m2504i(25536);
        if (C5046bo.amV(str)) {
            AppMethodBeat.m2505o(25536);
            return 1;
        } else if (C5046bo.amW(str)) {
            AppMethodBeat.m2505o(25536);
            return 2;
        } else if (C5046bo.amX(str)) {
            AppMethodBeat.m2505o(25536);
            return 3;
        } else {
            AppMethodBeat.m2505o(25536);
            return 3;
        }
    }
}
