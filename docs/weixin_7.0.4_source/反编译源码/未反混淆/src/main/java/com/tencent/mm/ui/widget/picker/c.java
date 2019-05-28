package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aj;
import com.tencent.view.d;
import java.util.Locale;

public final class c implements OnGlobalLayoutListener {
    private Button grC = ((Button) this.iym.findViewById(R.id.b7o));
    private View iym = View.inflate(this.mContext, R.layout.azl, null);
    private Button jAH;
    private Context mContext;
    private BottomSheetBehavior nA;
    public CustomTimePicker zSs = ((CustomTimePicker) this.iym.findViewById(R.id.evr));
    public a zSt;
    public android.support.design.widget.c zaW = new android.support.design.widget.c(this.mContext);
    private int zaX;

    public interface a<T> {
        void b(boolean z, T t);
    }

    public c(Context context) {
        AppMethodBeat.i(112838);
        this.mContext = context;
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Object obj;
                AppMethodBeat.i(112835);
                c cVar = c.this;
                if (c.this.zSs == null) {
                    obj = null;
                } else {
                    CustomTimePicker a = c.this.zSs;
                    obj = String.format(Locale.US, "%02d:%02d", new Object[]{a.getCurrentHour(), a.getCurrentMinute()});
                }
                c.a(cVar, true, obj);
                AppMethodBeat.o(112835);
            }
        });
        this.jAH = (Button) this.iym.findViewById(R.id.axh);
        this.jAH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112836);
                c.a(c.this, false, null);
                AppMethodBeat.o(112836);
            }
        });
        this.zaW.setContentView(this.iym);
        this.zaX = aj.fromDPToPix(this.mContext, d.MIC_PTU_YOUJIALI);
        this.nA = BottomSheetBehavior.j((View) this.iym.getParent());
        if (this.nA != null) {
            this.nA.K(this.zaX);
            this.nA.nj = false;
        }
        this.zaW.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(112837);
                c.this.zaW = null;
                AppMethodBeat.o(112837);
            }
        });
        AppMethodBeat.o(112838);
    }

    public final void onGlobalLayout() {
    }

    static /* synthetic */ void a(c cVar, boolean z, Object obj) {
        AppMethodBeat.i(112839);
        if (cVar.zSt != null) {
            cVar.zSt.b(z, obj);
        }
        AppMethodBeat.o(112839);
    }
}
