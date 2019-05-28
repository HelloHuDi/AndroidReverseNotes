package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bl;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.protocal.protobuf.rn;

public final class c {
    Context mContext;
    rn pPM;
    a pQJ;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.c$2 */
    class AnonymousClass2 implements com.tencent.mm.ui.widget.a.e.c {
        final /* synthetic */ EditText pQK;
        final /* synthetic */ v pQM;

        AnonymousClass2(v vVar, EditText editText) {
            this.pQM = vVar;
            this.pQK = editText;
        }

        public final void d(boolean z, String str) {
            AppMethodBeat.i(44815);
            bl blVar;
            if (z) {
                blVar = new bl();
                blVar.dcq = (long) this.pQM.nUf;
                blVar = blVar.ge(this.pQM.username);
                blVar.dck = 3;
                blVar.ajK();
                c.this.pQJ.VS(this.pQK.getText().toString());
                AppMethodBeat.o(44815);
                return;
            }
            blVar = new bl();
            blVar.dcq = (long) this.pQM.nUf;
            blVar = blVar.ge(this.pQM.username);
            blVar.dck = 2;
            blVar.ajK();
            c.this.pQJ.onCancel();
            AppMethodBeat.o(44815);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.c$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ EditText pQK;

        AnonymousClass1(EditText editText) {
            this.pQK = editText;
        }

        public final void run() {
            AppMethodBeat.i(44814);
            this.pQK.requestFocus();
            ((InputMethodManager) c.this.mContext.getSystemService("input_method")).showSoftInput(this.pQK, 0);
            AppMethodBeat.o(44814);
        }
    }

    public interface a {
        void VS(String str);

        void onCancel();
    }

    public c(Context context) {
        this.mContext = context;
    }
}
