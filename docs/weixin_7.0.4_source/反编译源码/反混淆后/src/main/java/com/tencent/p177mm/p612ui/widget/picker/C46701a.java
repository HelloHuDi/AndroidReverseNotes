package com.tencent.p177mm.p612ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.C17391c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.view.C31128d;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.tencent.mm.ui.widget.picker.a */
public final class C46701a implements OnGlobalLayoutListener {
    private Button grC = ((Button) this.iym.findViewById(2131823196));
    private View iym = View.inflate(this.mContext, 2130969262, null);
    private Button jAH;
    private Context mContext;
    /* renamed from: nA */
    private BottomSheetBehavior f17923nA;
    public CustomDatePicker zSi = ((CustomDatePicker) this.iym.findViewById(2131823197));
    public C5669a zSj;
    private C17391c zaW = new C17391c(this.mContext);
    private int zaX;

    /* renamed from: com.tencent.mm.ui.widget.picker.a$4 */
    class C56684 implements OnDismissListener {
        C56684() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(112811);
            C46701a.this.zaW = null;
            AppMethodBeat.m2505o(112811);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.a$a */
    public interface C5669a<T> {
        /* renamed from: b */
        void mo11538b(boolean z, int i, int i2, int i3);
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.a$3 */
    class C160143 implements OnCancelListener {
        C160143() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(112810);
            C46701a.m88480a(C46701a.this, false, 0, 0, 0);
            C46701a.this.hide();
            AppMethodBeat.m2505o(112810);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.a$1 */
    class C409051 implements OnClickListener {
        C409051() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112808);
            C46701a.m88480a(C46701a.this, true, C46701a.this.zSi.getYear(), C46701a.this.zSi.getMonth(), C46701a.this.zSi.getDayOfMonth());
            C46701a.this.hide();
            AppMethodBeat.m2505o(112808);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.a$2 */
    class C409062 implements OnClickListener {
        C409062() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112809);
            C46701a.m88480a(C46701a.this, false, 0, 0, 0);
            C46701a.this.hide();
            AppMethodBeat.m2505o(112809);
        }
    }

    public C46701a(Context context) {
        AppMethodBeat.m2504i(112812);
        this.mContext = context;
        this.grC.setOnClickListener(new C409051());
        this.jAH = (Button) this.iym.findViewById(2131822819);
        this.jAH.setOnClickListener(new C409062());
        this.zaW.setContentView(this.iym);
        this.zaW.setOnCancelListener(new C160143());
        this.zaX = C5229aj.fromDPToPix(this.mContext, C31128d.MIC_PTU_YOUJIALI);
        this.f17923nA = BottomSheetBehavior.m38322j((View) this.iym.getParent());
        if (this.f17923nA != null) {
            this.f17923nA.mo41462K(this.zaX);
            this.f17923nA.f4913nj = false;
        }
        this.zaW.setOnDismissListener(new C56684());
        AppMethodBeat.m2505o(112812);
    }

    public final void onGlobalLayout() {
    }

    /* renamed from: aB */
    public final void mo75044aB(int i, int i2, int i3) {
        AppMethodBeat.m2504i(112813);
        if (i < 0 || i2 < 0 || i3 < 0) {
            AppMethodBeat.m2505o(112813);
            return;
        }
        if (this.zSi != null) {
            this.zSi.mo28326aA(i, i2, i3);
        }
        AppMethodBeat.m2505o(112813);
    }

    /* renamed from: al */
    public final void mo75047al(boolean z, boolean z2) {
        AppMethodBeat.m2504i(112814);
        if (this.zSi != null) {
            this.zSi.mo28328al(z, z2);
        }
        AppMethodBeat.m2505o(112814);
    }

    /* renamed from: aC */
    public final void mo75045aC(int i, int i2, int i3) {
        AppMethodBeat.m2504i(112815);
        if (i < 0 || i2 < 0 || i3 < 0) {
            AppMethodBeat.m2505o(112815);
            return;
        }
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.set(i, i2 - 1, i3);
        if (this.zSi != null) {
            this.zSi.setMinDate(instance.getTimeInMillis());
        }
        AppMethodBeat.m2505o(112815);
    }

    /* renamed from: aD */
    public final void mo75046aD(int i, int i2, int i3) {
        AppMethodBeat.m2504i(112816);
        if (i < 0 || i2 < 0 || i3 < 0) {
            AppMethodBeat.m2505o(112816);
            return;
        }
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.set(i, i2 - 1, i3);
        if (this.zSi != null) {
            this.zSi.setMaxDate(instance.getTimeInMillis());
        }
        AppMethodBeat.m2505o(112816);
    }

    public final void show() {
        AppMethodBeat.m2504i(112817);
        if (this.zaW != null) {
            if (this.zSi != null) {
                this.zSi.aRJ();
            }
            this.zaW.show();
        }
        AppMethodBeat.m2505o(112817);
    }

    public final void hide() {
        AppMethodBeat.m2504i(112818);
        if (this.zaW != null) {
            this.zaW.dismiss();
        }
        AppMethodBeat.m2505o(112818);
    }

    /* renamed from: a */
    static /* synthetic */ void m88480a(C46701a c46701a, boolean z, int i, int i2, int i3) {
        AppMethodBeat.m2504i(112819);
        if (c46701a.zSj != null) {
            c46701a.zSj.mo11538b(z, i, i2, i3);
        }
        AppMethodBeat.m2505o(112819);
    }
}
