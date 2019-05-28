package com.tencent.p177mm.p612ui.tools.p632b;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.tools.C5584f.C5583a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.tools.b.c */
public class C7357c extends C5580a {
    public C5583a jeZ;
    private String mText;
    private int zIA;
    private ArrayList<InputFilter> zIB;
    public C5581a zIC;
    public boolean zIx = true;
    public WeakReference<EditText> zIy;
    private int zIz;

    /* renamed from: com.tencent.mm.ui.tools.b.c$a */
    public interface C5581a {
        /* renamed from: JW */
        void mo11315JW();

        /* renamed from: JX */
        void mo11316JX();

        /* renamed from: ki */
        void mo11317ki(String str);
    }

    public C7357c(WeakReference<EditText> weakReference) {
        this.zIy = weakReference;
        this.jeZ = C5583a.MODE_CHINESE_AS_2;
        this.zIx = false;
    }

    public C7357c(String str) {
        this.mText = str;
        this.jeZ = C5583a.MODE_CHINESE_AS_2;
        this.zIx = false;
    }

    /* renamed from: d */
    public static C7357c m12555d(EditText editText) {
        AppMethodBeat.m2504i(67866);
        C7357c c7357c = new C7357c(new WeakReference(editText));
        AppMethodBeat.m2505o(67866);
        return c7357c;
    }

    /* renamed from: hz */
    public final C7357c mo15880hz(int i, int i2) {
        this.zIA = i;
        this.zIz = i2;
        return this;
    }

    /* renamed from: PM */
    public final C7357c mo15877PM(int i) {
        this.zIA = 0;
        this.zIz = i;
        return this;
    }

    /* renamed from: a */
    public final void mo15879a(C5581a c5581a) {
        AppMethodBeat.m2504i(67867);
        this.zIC = c5581a;
        dkS();
        AppMethodBeat.m2505o(67867);
    }

    /* Access modifiers changed, original: protected|final */
    public final int aAa() {
        Object obj;
        AppMethodBeat.m2504i(67868);
        if (C5046bo.isNullOrNil(this.mText)) {
            if (this.zIy == null) {
                AppMethodBeat.m2505o(67868);
                return 1;
            }
            this.mText = ((EditText) this.zIy.get()).getText().toString().trim();
        }
        int a = C5584f.m8384a(this.mText, this.jeZ);
        if (a < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            C4990ab.m7420w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            AppMethodBeat.m2505o(67868);
            return 2;
        } else if (a < this.zIA) {
            AppMethodBeat.m2505o(67868);
            return 1;
        } else if (a > this.zIz) {
            AppMethodBeat.m2505o(67868);
            return 2;
        } else {
            AppMethodBeat.m2505o(67868);
            return 0;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void dkS() {
        AppMethodBeat.m2504i(67869);
        if (!this.zIx) {
            if (this.zIy == null) {
                C4990ab.m7420w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
                AppMethodBeat.m2505o(67869);
                return;
            } else if (C5046bo.m7548ek(this.zIB)) {
                ((EditText) this.zIy.get()).setFilters(new InputFilter[]{mo15878a(this.zIz, this.jeZ)});
            } else {
                this.zIB.add(mo15878a(this.zIz, this.jeZ));
                ((EditText) this.zIy.get()).setFilters((InputFilter[]) this.zIB.toArray(new InputFilter[this.zIB.size()]));
            }
        }
        if (this.zIC != null) {
            switch (aAa()) {
                case 0:
                    this.zIC.mo11317ki(this.mText);
                    AppMethodBeat.m2505o(67869);
                    return;
                case 1:
                    this.zIC.mo11315JW();
                    AppMethodBeat.m2505o(67869);
                    return;
                case 2:
                    this.zIC.mo11316JX();
                    break;
            }
        }
        AppMethodBeat.m2505o(67869);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public C5584f mo15878a(int i, C5583a c5583a) {
        AppMethodBeat.m2504i(67870);
        C5584f c5584f = new C5584f(i, c5583a);
        AppMethodBeat.m2505o(67870);
        return c5584f;
    }
}
