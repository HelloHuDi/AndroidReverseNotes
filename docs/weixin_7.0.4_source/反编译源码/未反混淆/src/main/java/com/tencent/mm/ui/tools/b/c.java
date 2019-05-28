package com.tencent.mm.ui.tools.b;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c extends a {
    public com.tencent.mm.ui.tools.f.a jeZ;
    private String mText;
    private int zIA;
    private ArrayList<InputFilter> zIB;
    public a zIC;
    public boolean zIx = true;
    public WeakReference<EditText> zIy;
    private int zIz;

    public interface a {
        void JW();

        void JX();

        void ki(String str);
    }

    public c(WeakReference<EditText> weakReference) {
        this.zIy = weakReference;
        this.jeZ = com.tencent.mm.ui.tools.f.a.MODE_CHINESE_AS_2;
        this.zIx = false;
    }

    public c(String str) {
        this.mText = str;
        this.jeZ = com.tencent.mm.ui.tools.f.a.MODE_CHINESE_AS_2;
        this.zIx = false;
    }

    public static c d(EditText editText) {
        AppMethodBeat.i(67866);
        c cVar = new c(new WeakReference(editText));
        AppMethodBeat.o(67866);
        return cVar;
    }

    public final c hz(int i, int i2) {
        this.zIA = i;
        this.zIz = i2;
        return this;
    }

    public final c PM(int i) {
        this.zIA = 0;
        this.zIz = i;
        return this;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(67867);
        this.zIC = aVar;
        dkS();
        AppMethodBeat.o(67867);
    }

    /* Access modifiers changed, original: protected|final */
    public final int aAa() {
        Object obj;
        AppMethodBeat.i(67868);
        if (bo.isNullOrNil(this.mText)) {
            if (this.zIy == null) {
                AppMethodBeat.o(67868);
                return 1;
            }
            this.mText = ((EditText) this.zIy.get()).getText().toString().trim();
        }
        int a = f.a(this.mText, this.jeZ);
        if (a < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            ab.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            AppMethodBeat.o(67868);
            return 2;
        } else if (a < this.zIA) {
            AppMethodBeat.o(67868);
            return 1;
        } else if (a > this.zIz) {
            AppMethodBeat.o(67868);
            return 2;
        } else {
            AppMethodBeat.o(67868);
            return 0;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void dkS() {
        AppMethodBeat.i(67869);
        if (!this.zIx) {
            if (this.zIy == null) {
                ab.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
                AppMethodBeat.o(67869);
                return;
            } else if (bo.ek(this.zIB)) {
                ((EditText) this.zIy.get()).setFilters(new InputFilter[]{a(this.zIz, this.jeZ)});
            } else {
                this.zIB.add(a(this.zIz, this.jeZ));
                ((EditText) this.zIy.get()).setFilters((InputFilter[]) this.zIB.toArray(new InputFilter[this.zIB.size()]));
            }
        }
        if (this.zIC != null) {
            switch (aAa()) {
                case 0:
                    this.zIC.ki(this.mText);
                    AppMethodBeat.o(67869);
                    return;
                case 1:
                    this.zIC.JW();
                    AppMethodBeat.o(67869);
                    return;
                case 2:
                    this.zIC.JX();
                    break;
            }
        }
        AppMethodBeat.o(67869);
    }

    /* Access modifiers changed, original: protected */
    public f a(int i, com.tencent.mm.ui.tools.f.a aVar) {
        AppMethodBeat.i(67870);
        f fVar = new f(i, aVar);
        AppMethodBeat.o(67870);
        return fVar;
    }
}
