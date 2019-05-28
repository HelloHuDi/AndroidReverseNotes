package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class EditSignatureUI extends MMActivity {
    private p eir = null;
    private c ekk = new c<mc>() {
        {
            AppMethodBeat.i(126942);
            this.xxI = mc.class.getName().hashCode();
            AppMethodBeat.o(126942);
        }

        private boolean a(mc mcVar) {
            AppMethodBeat.i(126943);
            String str = mcVar.cHU.cHV;
            String str2 = mcVar.cHU.cHW;
            int i = mcVar.cHU.ret;
            if (i != 0 && EditSignatureUI.this.qkH != null) {
                h.b(EditSignatureUI.this, str2, str, true);
                if (EditSignatureUI.this.qkI != null) {
                    ((j) g.K(j.class)).XL().d(EditSignatureUI.this.qkI);
                }
            } else if (i == 0 && EditSignatureUI.this.qkK) {
                g.RP().Ry().set(12291, EditSignatureUI.this.qkH.getText().toString().trim());
                EditSignatureUI.this.finish();
            }
            if (EditSignatureUI.this.eir != null) {
                EditSignatureUI.this.eir.dismiss();
            }
            AppMethodBeat.o(126943);
            return true;
        }
    };
    private MMEditText qkH;
    private b qkI;
    final bp qkJ = bp.aao();
    private boolean qkK = false;
    private TextView qkx;

    class a implements TextWatcher {
        private int qkM;

        private a() {
            this.qkM = 60;
        }

        /* synthetic */ a(EditSignatureUI editSignatureUI, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(126947);
            EditSignatureUI.this.enableOptionMenu(true);
            AppMethodBeat.o(126947);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(126948);
            this.qkM = f.bP(60, editable.toString());
            if (this.qkM < 0) {
                this.qkM = 0;
            }
            if (EditSignatureUI.this.qkx != null) {
                EditSignatureUI.this.qkx.setText(this.qkM);
            }
            AppMethodBeat.o(126948);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EditSignatureUI() {
        AppMethodBeat.i(126949);
        AppMethodBeat.o(126949);
    }

    public final int getLayoutId() {
        return R.layout.ta;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(126950);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xxA.c(this.ekk);
        initView();
        AppMethodBeat.o(126950);
    }

    public void onDestroy() {
        AppMethodBeat.i(126951);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.ekk);
        AppMethodBeat.o(126951);
    }

    public final void initView() {
        AppMethodBeat.i(126952);
        setMMTitle((int) R.string.eak);
        this.qkH = (MMEditText) findViewById(R.id.m5);
        this.qkx = (TextView) findViewById(R.id.b5v);
        this.qkH.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, bo.nullAsNil((String) g.RP().Ry().get(12291, null)), this.qkH.getTextSize()));
        this.qkH.setSelection(this.qkH.getText().length());
        this.qkx.setText(f.bP(60, this.qkH.getEditableText().toString()));
        com.tencent.mm.ui.tools.b.c.d(this.qkH).hz(0, 60).a(null);
        this.qkH.addTextChangedListener(new a(this, (byte) 0));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126945);
                EditSignatureUI.this.aqX();
                EditSignatureUI.this.finish();
                AppMethodBeat.o(126945);
                return true;
            }
        });
        a(0, getString(R.string.tc), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(126946);
                String trim = EditSignatureUI.this.qkH.getText().toString().trim();
                String Ne = com.tencent.mm.m.b.Ne();
                if (bo.isNullOrNil(Ne) || !trim.matches(".*[" + Ne + "].*")) {
                    EditSignatureUI editSignatureUI = EditSignatureUI.this;
                    Context context = EditSignatureUI.this.mController.ylL;
                    EditSignatureUI.this.getString(R.string.tz);
                    editSignatureUI.eir = h.b(context, EditSignatureUI.this.getString(R.string.av5), false, null);
                    EditSignatureUI.this.qkI = r.r(18, trim);
                    EditSignatureUI.this.qkK = true;
                    EditSignatureUI.this.aqX();
                    AppMethodBeat.o(126946);
                    return true;
                }
                h.b(EditSignatureUI.this.mController.ylL, EditSignatureUI.this.getString(R.string.ce4, new Object[]{Ne}), EditSignatureUI.this.getString(R.string.tz), true);
                AppMethodBeat.o(126946);
                return false;
            }
        }, q.b.GREEN);
        enableOptionMenu(false);
        AppMethodBeat.o(126952);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(126953);
        if (i == 4) {
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(126953);
        return onKeyDown;
    }
}
