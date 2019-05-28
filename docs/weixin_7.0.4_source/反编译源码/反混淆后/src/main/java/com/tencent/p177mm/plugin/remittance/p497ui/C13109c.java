package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C46881bl;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.remittance.model.C39603v;
import com.tencent.p177mm.protocal.protobuf.C7282rn;

/* renamed from: com.tencent.mm.plugin.remittance.ui.c */
public final class C13109c {
    Context mContext;
    C7282rn pPM;
    C13112a pQJ;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.c$2 */
    class C131102 implements C5662c {
        final /* synthetic */ EditText pQK;
        final /* synthetic */ C39603v pQM;

        C131102(C39603v c39603v, EditText editText) {
            this.pQM = c39603v;
            this.pQK = editText;
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(44815);
            C46881bl c46881bl;
            if (z) {
                c46881bl = new C46881bl();
                c46881bl.dcq = (long) this.pQM.nUf;
                c46881bl = c46881bl.mo76060ge(this.pQM.username);
                c46881bl.dck = 3;
                c46881bl.ajK();
                C13109c.this.pQJ.mo8359VS(this.pQK.getText().toString());
                AppMethodBeat.m2505o(44815);
                return;
            }
            c46881bl = new C46881bl();
            c46881bl.dcq = (long) this.pQM.nUf;
            c46881bl = c46881bl.mo76060ge(this.pQM.username);
            c46881bl.dck = 2;
            c46881bl.ajK();
            C13109c.this.pQJ.onCancel();
            AppMethodBeat.m2505o(44815);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.c$1 */
    class C131111 implements Runnable {
        final /* synthetic */ EditText pQK;

        C131111(EditText editText) {
            this.pQK = editText;
        }

        public final void run() {
            AppMethodBeat.m2504i(44814);
            this.pQK.requestFocus();
            ((InputMethodManager) C13109c.this.mContext.getSystemService("input_method")).showSoftInput(this.pQK, 0);
            AppMethodBeat.m2505o(44814);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.c$a */
    public interface C13112a {
        /* renamed from: VS */
        void mo8359VS(String str);

        void onCancel();
    }

    public C13109c(Context context) {
        this.mContext = context;
    }
}
