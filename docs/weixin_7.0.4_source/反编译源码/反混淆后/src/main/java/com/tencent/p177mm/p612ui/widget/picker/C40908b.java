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
import android.widget.FrameLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.widget.picker.b */
public final class C40908b implements OnGlobalLayoutListener {
    private Button grC;
    private View iym;
    private Button jAH;
    private Context mContext;
    /* renamed from: nA */
    private BottomSheetBehavior f16222nA;
    private String[] zSl;
    private ArrayList<List<String>> zSm = null;
    private int zSn;
    private OptionPicker zSo;
    private OptionPicker zSp;
    public C40907a zSq;
    private C17391c zaW;
    private int zaX;

    /* renamed from: com.tencent.mm.ui.widget.picker.b$4 */
    class C160154 implements OnDismissListener {
        C160154() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(112823);
            C40908b.this.zaW = null;
            AppMethodBeat.m2505o(112823);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.b$2 */
    class C308082 implements OnClickListener {
        C308082() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112821);
            C40908b c40908b = C40908b.this;
            Object aRK = C40908b.this.zSo == null ? null : C40908b.this.zSo.aRK();
            if (C40908b.this.zSp != null) {
                C40908b.this.zSp.aRK();
            }
            C40908b.m70908a(c40908b, true, aRK);
            AppMethodBeat.m2505o(112821);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.b$3 */
    class C308093 implements OnClickListener {
        C308093() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(112822);
            C40908b.m70908a(C40908b.this, false, null);
            AppMethodBeat.m2505o(112822);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.b$a */
    public interface C40907a<T> {
        /* renamed from: d */
        void mo7219d(boolean z, T t);
    }

    /* renamed from: com.tencent.mm.ui.widget.picker.b$1 */
    class C409091 implements OnValueChangeListener {
        C409091() {
        }

        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
            AppMethodBeat.m2504i(112820);
            C40908b.this.zSp.setOptionsArray(C40908b.m70909a(C40908b.this, i2));
            AppMethodBeat.m2505o(112820);
        }
    }

    /* renamed from: a */
    static /* synthetic */ String[] m70909a(C40908b c40908b, int i) {
        AppMethodBeat.m2504i(112833);
        String[] Qr = c40908b.m70906Qr(i);
        AppMethodBeat.m2505o(112833);
        return Qr;
    }

    public C40908b(Context context, String[] strArr) {
        AppMethodBeat.m2504i(112824);
        this.mContext = context;
        this.zSl = strArr;
        initView();
        AppMethodBeat.m2505o(112824);
    }

    public C40908b(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(112825);
        this.mContext = context;
        if (arrayList != null) {
            this.zSl = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        initView();
        AppMethodBeat.m2505o(112825);
    }

    public final void onGlobalLayout() {
    }

    private void initView() {
        AppMethodBeat.m2504i(112826);
        this.zaW = new C17391c(this.mContext);
        this.iym = View.inflate(this.mContext, 2130970339, null);
        this.zSo = (OptionPicker) this.iym.findViewById(2131826450);
        this.zSo.setOptionsArray(this.zSl);
        this.zSp = (OptionPicker) this.iym.findViewById(2131826451);
        if (this.zSm != null) {
            this.zSp.setVisibility(0);
            this.zSp.setOptionsArray(m70906Qr(this.zSo.getValue()));
            this.zSo.setOnValueChangedListener(new C409091());
        } else {
            this.zSp.setVisibility(8);
        }
        this.zSn = C5229aj.fromDPToPix(this.mContext, C31128d.MIC_PTU_YOUJIALI);
        this.grC = (Button) this.iym.findViewById(2131823196);
        this.grC.setOnClickListener(new C308082());
        this.jAH = (Button) this.iym.findViewById(2131822819);
        this.jAH.setOnClickListener(new C308093());
        this.zaW.setContentView(this.iym);
        this.zaX = C5229aj.fromDPToPix(this.mContext, 350);
        this.f16222nA = BottomSheetBehavior.m38322j((View) this.iym.getParent());
        if (this.f16222nA != null) {
            this.f16222nA.mo41462K(this.zaX);
            this.f16222nA.f4913nj = false;
        }
        this.zaW.setOnDismissListener(new C160154());
        AppMethodBeat.m2505o(112826);
    }

    /* renamed from: Qp */
    public final void mo64521Qp(int i) {
        AppMethodBeat.m2504i(112827);
        if (i != 0) {
            this.zSn = i;
        }
        LayoutParams layoutParams = (LayoutParams) this.iym.getLayoutParams();
        layoutParams.height = this.zSn;
        this.iym.setLayoutParams(layoutParams);
        this.iym.invalidate();
        AppMethodBeat.m2505o(112827);
    }

    public final void show() {
        AppMethodBeat.m2504i(112828);
        if (this.zaW != null) {
            this.zaW.show();
        }
        AppMethodBeat.m2505o(112828);
    }

    public final void hide() {
        AppMethodBeat.m2504i(112829);
        if (this.zaW != null) {
            this.zaW.dismiss();
        }
        AppMethodBeat.m2505o(112829);
    }

    public final int dLl() {
        AppMethodBeat.m2504i(112830);
        int i = 0;
        if (this.zSo != null) {
            i = this.zSo.getValue();
        }
        AppMethodBeat.m2505o(112830);
        return i;
    }

    /* renamed from: Qq */
    public final void mo64522Qq(int i) {
        AppMethodBeat.m2504i(112831);
        if (this.zSo != null) {
            this.zSo.setValue(i);
        }
        AppMethodBeat.m2505o(112831);
    }

    /* renamed from: Qr */
    private String[] m70906Qr(int i) {
        AppMethodBeat.m2504i(112832);
        if (this.zSm != null) {
            ArrayList arrayList = (ArrayList) this.zSm.get(i);
            if (arrayList != null) {
                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                AppMethodBeat.m2505o(112832);
                return strArr;
            }
        }
        AppMethodBeat.m2505o(112832);
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m70908a(C40908b c40908b, boolean z, Object obj) {
        AppMethodBeat.m2504i(112834);
        if (c40908b.zSq != null) {
            c40908b.zSq.mo7219d(z, obj);
        }
        AppMethodBeat.m2505o(112834);
    }
}
