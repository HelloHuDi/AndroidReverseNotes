package com.tencent.p177mm.p612ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
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
import java.util.Locale;

/* renamed from: com.tencent.mm.ui.widget.picker.c */
public final class C46702c implements OnGlobalLayoutListener {
    private Button grC = ((Button) this.iym.findViewById(2131823196));
    private View iym = View.inflate(this.mContext, 2130970924, null);
    private Button jAH;
    private Context mContext;
    /* renamed from: nA */
    private BottomSheetBehavior f17924nA;
    public CustomTimePicker zSs = ((CustomTimePicker) this.iym.findViewById(2131828230));
    public C40910a zSt;
    public C17391c zaW = new C17391c(this.mContext);
    private int zaX;

    /* renamed from: com.tencent.mm.ui.widget.picker.c$1 */
    class C241001 implements OnClickListener {
        C241001() {
        }

        public final void onClick(View view) {
            Object obj;
            AppMethodBeat.m2504i(112835);
            C46702c c46702c = C46702c.this;
            if (C46702c.this.zSs == null) {
                obj = null;
            } else {
                CustomTimePicker a = C46702c.this.zSs;
                obj = String.format(Locale.US, "%02d:%02d", new Object[]{a.getCurrentHour(), a.getCurrentMinute()});
            }
            C46702c.m88487a(c46702c, true, obj);
            AppMethodBeat.m2505o(112835);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.c$2 */
    class C241012 implements OnClickListener {
        C241012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112836);
            C46702c.m88487a(C46702c.this, false, null);
            AppMethodBeat.m2505o(112836);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.c$3 */
    class C308103 implements OnDismissListener {
        C308103() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(112837);
            C46702c.this.zaW = null;
            AppMethodBeat.m2505o(112837);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.c$a */
    public interface C40910a<T> {
        /* renamed from: b */
        void mo38363b(boolean z, T t);
    }

    public C46702c(Context context) {
        AppMethodBeat.m2504i(112838);
        this.mContext = context;
        this.grC.setOnClickListener(new C241001());
        this.jAH = (Button) this.iym.findViewById(2131822819);
        this.jAH.setOnClickListener(new C241012());
        this.zaW.setContentView(this.iym);
        this.zaX = C5229aj.fromDPToPix(this.mContext, C31128d.MIC_PTU_YOUJIALI);
        this.f17924nA = BottomSheetBehavior.m38322j((View) this.iym.getParent());
        if (this.f17924nA != null) {
            this.f17924nA.mo41462K(this.zaX);
            this.f17924nA.f4913nj = false;
        }
        this.zaW.setOnDismissListener(new C308103());
        AppMethodBeat.m2505o(112838);
    }

    public final void onGlobalLayout() {
    }

    /* renamed from: a */
    static /* synthetic */ void m88487a(C46702c c46702c, boolean z, Object obj) {
        AppMethodBeat.m2504i(112839);
        if (c46702c.zSt != null) {
            c46702c.zSt.mo38363b(z, obj);
        }
        AppMethodBeat.m2505o(112839);
    }
}
