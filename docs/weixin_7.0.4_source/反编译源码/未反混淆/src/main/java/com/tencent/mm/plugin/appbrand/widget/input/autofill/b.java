package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.support.v4.widget.j;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Filter.FilterListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.ab.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class b {
    final ab jhB;
    public final e jhC;
    private final FilterListener jhD;
    public final c jhE;
    private final a jhF;
    private f jhG = f.VIEW;
    public a jhH;
    private int jhI;
    private int jhJ;

    static class a implements h {
        h jhN;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public void a(String str, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a aVar) {
            AppMethodBeat.i(123889);
            if (this.jhN != null) {
                this.jhN.a(str, aVar);
            }
            AppMethodBeat.o(123889);
        }
    }

    public b(ab abVar) {
        AppMethodBeat.i(123890);
        this.jhB = abVar;
        this.jhC = new e(abVar.getContext());
        this.jhE = new c(abVar, this.jhC);
        this.jhB.a(new com.tencent.mm.plugin.appbrand.widget.input.ab.a() {
            public final void gY() {
                AppMethodBeat.i(123881);
                b.this.aRv();
                AppMethodBeat.o(123881);
            }
        });
        this.jhB.a(new c() {
            public final void aQS() {
                AppMethodBeat.i(123882);
                b.this.aRv();
                AppMethodBeat.o(123882);
            }
        });
        this.jhB.a(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(123883);
                if (z) {
                    b.this.aRw();
                    AppMethodBeat.o(123883);
                    return;
                }
                b bVar = b.this;
                if (bVar.jhC.amH.isShowing()) {
                    g gVar = (g) bVar.jhC.jhV.getAdapter();
                    bVar.jhC.dismiss();
                    gVar.aRu();
                }
                AppMethodBeat.o(123883);
            }
        });
        this.jhB.addTextChangedListener(new TextWatcher() {
            private boolean jhL = false;

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(123884);
                this.jhL = b.this.jhC.amH.isShowing();
                AppMethodBeat.o(123884);
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(123885);
                if (!this.jhL || b.this.jhC.amH.isShowing()) {
                    if (!b.this.jhC.amH.isShowing()) {
                        b.this.aRw();
                    }
                    b.this.E(editable);
                    AppMethodBeat.o(123885);
                    return;
                }
                AppMethodBeat.o(123885);
            }
        });
        this.jhD = new FilterListener() {
            public final void onFilterComplete(int i) {
                AppMethodBeat.i(123886);
                if (i <= 0) {
                    b.this.jhC.dismiss();
                    AppMethodBeat.o(123886);
                    return;
                }
                if (b.this.jhC.amH.isShowing()) {
                    b.this.jhC.show();
                }
                AppMethodBeat.o(123886);
            }
        };
        this.jhF = new a() {
            public final void a(String str, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a aVar) {
                AppMethodBeat.i(123887);
                if (aVar == com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a.DELETE) {
                    b.this.E(b.this.jhB.getText());
                }
                super.a(str, aVar);
                AppMethodBeat.o(123887);
            }
        };
        AppMethodBeat.o(123890);
    }

    /* Access modifiers changed, original: final */
    public final void E(CharSequence charSequence) {
        AppMethodBeat.i(123891);
        if (this.jhH == null) {
            AppMethodBeat.o(123891);
            return;
        }
        this.jhH.getFilter().filter(charSequence, this.jhD);
        AppMethodBeat.o(123891);
    }

    /* Access modifiers changed, original: final */
    public final void s(ArrayList<com.tencent.mm.plugin.appbrand.widget.input.d.a.b> arrayList) {
        AppMethodBeat.i(123892);
        this.jhH = new a(this.jhB.getContext(), arrayList);
        this.jhH.jhu = this.jhF;
        e eVar = this.jhC;
        a aVar = this.jhH;
        if (eVar.mObserver == null) {
            eVar.mObserver = new c(eVar, (byte) 0);
        } else if (eVar.Ei != null) {
            eVar.Ei.unregisterDataSetObserver(eVar.mObserver);
        }
        eVar.Ei = aVar;
        if (eVar.Ei != null) {
            aVar.registerDataSetObserver(eVar.mObserver);
        }
        if (eVar.jhV != null) {
            eVar.jhV.setAdapter(eVar.Ei);
        }
        AppMethodBeat.o(123892);
    }

    /* Access modifiers changed, original: final */
    public final void a(h hVar) {
        this.jhF.jhN = hVar;
    }

    /* Access modifiers changed, original: final */
    public final void aRv() {
        AppMethodBeat.i(123893);
        switch (this.jhG) {
            case SCREEN:
                this.jhC.age = n.aMw()[0];
                break;
            case VIEW:
                this.jhC.age = this.jhB.getView().getMeasuredWidth();
                break;
        }
        if (this.jhI != 0) {
            this.jhC.amm = this.jhI;
            this.jhC.age -= this.jhI;
        }
        if (this.jhJ != 0) {
            this.jhC.age -= this.jhJ;
        }
        AppMethodBeat.o(123893);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        AppMethodBeat.i(123894);
        this.jhC.setOnDismissListener(onDismissListener);
        AppMethodBeat.o(123894);
    }

    /* Access modifiers changed, original: final */
    public final void a(f fVar) {
        AppMethodBeat.i(123895);
        if (fVar != null) {
            this.jhG = fVar;
        }
        aRv();
        AppMethodBeat.o(123895);
    }

    /* Access modifiers changed, original: final */
    public final void aRw() {
        AppMethodBeat.i(123896);
        if (this.jhH == null) {
            AppMethodBeat.o(123896);
            return;
        }
        CharSequence text = this.jhB.getText();
        if (!bo.ac(text)) {
            E(text);
        }
        this.jhC.amx = this.jhB.getView();
        this.jhC.show();
        ((g) this.jhC.jhV.getAdapter()).a(this);
        c cVar = this.jhE;
        cVar.qM(2);
        cVar.jhQ = j.INVALID_ID;
        if (!bo.ac(text)) {
            cVar.jhR = true;
        }
        a aVar = cVar.jhC.jhV;
        if (aVar != null) {
            aVar.getAdapter().registerDataSetObserver(new DataSetObserver() {
                public final void onChanged() {
                    AppMethodBeat.i(123899);
                    if (c.this.jhC.amH.isShowing()) {
                        c.this.qM(1);
                        AppMethodBeat.o(123899);
                        return;
                    }
                    AppMethodBeat.o(123899);
                }
            });
        }
        AppMethodBeat.o(123896);
    }
}
