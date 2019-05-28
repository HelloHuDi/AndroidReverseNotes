package com.tencent.mm.plugin.subapp.ui.pluginapp;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

public class ContactSearchUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    private EditText svm;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(ContactSearchUI contactSearchUI) {
        AppMethodBeat.i(25537);
        contactSearchUI.cDP();
        AppMethodBeat.o(25537);
    }

    public final int getLayoutId() {
        return R.layout.r4;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25530);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(25530);
    }

    public void onResume() {
        AppMethodBeat.i(25531);
        aw.Rg().a(106, (f) this);
        super.onResume();
        AppMethodBeat.o(25531);
    }

    public void onPause() {
        AppMethodBeat.i(25532);
        aw.Rg().b(106, (f) this);
        super.onPause();
        AppMethodBeat.o(25532);
    }

    public final void initView() {
        AppMethodBeat.i(25533);
        setMMTitle((int) R.string.b2l);
        this.svm = (EditText) findViewById(R.id.b62);
        this.svm.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(25525);
                ContactSearchUI.this.enableOptionMenu(editable.length() > 0);
                AppMethodBeat.o(25525);
            }
        });
        this.svm.setImeOptions(3);
        this.svm.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(25526);
                if (!(keyEvent == null || keyEvent.getKeyCode() != 66 || bo.isNullOrNil(ContactSearchUI.this.svm.getText().toString().trim()))) {
                    ContactSearchUI.b(ContactSearchUI.this);
                }
                AppMethodBeat.o(25526);
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.string.qs), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25527);
                ContactSearchUI.b(ContactSearchUI.this);
                AppMethodBeat.o(25527);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25528);
                ContactSearchUI.this.aqX();
                ContactSearchUI.this.finish();
                AppMethodBeat.o(25528);
                return true;
            }
        });
        if (getIntent().getBooleanExtra("from_webview", false)) {
            this.svm.setText(getIntent().getStringExtra("userName"));
            cDP();
        }
        AppMethodBeat.o(25533);
    }

    private void cDP() {
        AppMethodBeat.i(25534);
        String trim = this.svm.getText().toString().trim();
        if (trim == null || trim.length() <= 0) {
            h.g(this.mController.ylL, R.string.f0q, R.string.tz);
            AppMethodBeat.o(25534);
            return;
        }
        ab.d("MicroMsg.ContactSearchUI", "always search contact from internet!!!");
        final m fVar = new com.tencent.mm.plugin.messenger.a.f(trim, 1);
        aw.Rg().a(fVar, 0);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.ehJ = h.b(context, getString(R.string.ek), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(25529);
                aw.Rg().c(fVar);
                AppMethodBeat.o(25529);
            }
        });
        AppMethodBeat.o(25534);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(25535);
        ab.i("MicroMsg.ContactSearchUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (b.gkF.b(this.mController.ylL, i, i2, str)) {
            AppMethodBeat.o(25535);
        } else if (i == 4 && i2 == -4) {
            h.g(this.mController.ylL, R.string.ee, R.string.tz);
            AppMethodBeat.o(25535);
        } else if (i == 0 && i2 == 0) {
            buv bOj = ((com.tencent.mm.plugin.messenger.a.f) mVar).bOj();
            if (bOj.wod > 0) {
                Intent intent = new Intent();
                intent.setClass(this, ContactSearchResultUI.class);
                try {
                    intent.putExtra("result", bOj.toByteArray());
                    startActivity(intent);
                    AppMethodBeat.o(25535);
                    return;
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.ContactSearchUI", e, "", new Object[0]);
                    AppMethodBeat.o(25535);
                    return;
                }
            }
            String a = aa.a(bOj.wcB);
            Intent intent2 = new Intent();
            ((j) g.K(j.class)).a(intent2, bOj, abq(this.svm.getText().toString().trim()));
            if (bo.nullAsNil(a).length() > 0) {
                if ((bOj.wBT & 8) > 0) {
                    com.tencent.mm.plugin.report.service.h.pYm.X(10298, a + "," + abq(this.svm.getText().toString().trim()));
                }
                d.b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
            }
            AppMethodBeat.o(25535);
        } else {
            Toast.makeText(this, getString(R.string.byl), 0).show();
            ab.w("MicroMsg.ContactSearchUI", getString(R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            AppMethodBeat.o(25535);
        }
    }

    private static int abq(String str) {
        AppMethodBeat.i(25536);
        if (bo.amV(str)) {
            AppMethodBeat.o(25536);
            return 1;
        } else if (bo.amW(str)) {
            AppMethodBeat.o(25536);
            return 2;
        } else if (bo.amX(str)) {
            AppMethodBeat.o(25536);
            return 3;
        } else {
            AppMethodBeat.o(25536);
            return 3;
        }
    }
}
