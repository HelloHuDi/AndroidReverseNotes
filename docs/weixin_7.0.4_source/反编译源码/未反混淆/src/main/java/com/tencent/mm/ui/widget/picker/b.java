package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aj;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.List;

public final class b implements OnGlobalLayoutListener {
    private Button grC;
    private View iym;
    private Button jAH;
    private Context mContext;
    private BottomSheetBehavior nA;
    private String[] zSl;
    private ArrayList<List<String>> zSm = null;
    private int zSn;
    private OptionPicker zSo;
    private OptionPicker zSp;
    public a zSq;
    private c zaW;
    private int zaX;

    public interface a<T> {
        void d(boolean z, T t);
    }

    static /* synthetic */ String[] a(b bVar, int i) {
        AppMethodBeat.i(112833);
        String[] Qr = bVar.Qr(i);
        AppMethodBeat.o(112833);
        return Qr;
    }

    public b(Context context, String[] strArr) {
        AppMethodBeat.i(112824);
        this.mContext = context;
        this.zSl = strArr;
        initView();
        AppMethodBeat.o(112824);
    }

    public b(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.i(112825);
        this.mContext = context;
        if (arrayList != null) {
            this.zSl = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        initView();
        AppMethodBeat.o(112825);
    }

    public final void onGlobalLayout() {
    }

    private void initView() {
        AppMethodBeat.i(112826);
        this.zaW = new c(this.mContext);
        this.iym = View.inflate(this.mContext, R.layout.ajt, null);
        this.zSo = (OptionPicker) this.iym.findViewById(R.id.dkn);
        this.zSo.setOptionsArray(this.zSl);
        this.zSp = (OptionPicker) this.iym.findViewById(R.id.dko);
        if (this.zSm != null) {
            this.zSp.setVisibility(0);
            this.zSp.setOptionsArray(Qr(this.zSo.getValue()));
            this.zSo.setOnValueChangedListener(new OnValueChangeListener() {
                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    AppMethodBeat.i(112820);
                    b.this.zSp.setOptionsArray(b.a(b.this, i2));
                    AppMethodBeat.o(112820);
                }
            });
        } else {
            this.zSp.setVisibility(8);
        }
        this.zSn = aj.fromDPToPix(this.mContext, d.MIC_PTU_YOUJIALI);
        this.grC = (Button) this.iym.findViewById(R.id.b7o);
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112821);
                b bVar = b.this;
                Object aRK = b.this.zSo == null ? null : b.this.zSo.aRK();
                if (b.this.zSp != null) {
                    b.this.zSp.aRK();
                }
                b.a(bVar, true, aRK);
                AppMethodBeat.o(112821);
            }
        });
        this.jAH = (Button) this.iym.findViewById(R.id.axh);
        this.jAH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112822);
                b.a(b.this, false, null);
                AppMethodBeat.o(112822);
            }
        });
        this.zaW.setContentView(this.iym);
        this.zaX = aj.fromDPToPix(this.mContext, 350);
        this.nA = BottomSheetBehavior.j((View) this.iym.getParent());
        if (this.nA != null) {
            this.nA.K(this.zaX);
            this.nA.nj = false;
        }
        this.zaW.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(112823);
                b.this.zaW = null;
                AppMethodBeat.o(112823);
            }
        });
        AppMethodBeat.o(112826);
    }

    public final void Qp(int i) {
        AppMethodBeat.i(112827);
        if (i != 0) {
            this.zSn = i;
        }
        LayoutParams layoutParams = (LayoutParams) this.iym.getLayoutParams();
        layoutParams.height = this.zSn;
        this.iym.setLayoutParams(layoutParams);
        this.iym.invalidate();
        AppMethodBeat.o(112827);
    }

    public final void show() {
        AppMethodBeat.i(112828);
        if (this.zaW != null) {
            this.zaW.show();
        }
        AppMethodBeat.o(112828);
    }

    public final void hide() {
        AppMethodBeat.i(112829);
        if (this.zaW != null) {
            this.zaW.dismiss();
        }
        AppMethodBeat.o(112829);
    }

    public final int dLl() {
        AppMethodBeat.i(112830);
        int i = 0;
        if (this.zSo != null) {
            i = this.zSo.getValue();
        }
        AppMethodBeat.o(112830);
        return i;
    }

    public final void Qq(int i) {
        AppMethodBeat.i(112831);
        if (this.zSo != null) {
            this.zSo.setValue(i);
        }
        AppMethodBeat.o(112831);
    }

    private String[] Qr(int i) {
        AppMethodBeat.i(112832);
        if (this.zSm != null) {
            ArrayList arrayList = (ArrayList) this.zSm.get(i);
            if (arrayList != null) {
                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                AppMethodBeat.o(112832);
                return strArr;
            }
        }
        AppMethodBeat.o(112832);
        return null;
    }

    static /* synthetic */ void a(b bVar, boolean z, Object obj) {
        AppMethodBeat.i(112834);
        if (bVar.zSq != null) {
            bVar.zSq.d(z, obj);
        }
        AppMethodBeat.o(112834);
    }
}
