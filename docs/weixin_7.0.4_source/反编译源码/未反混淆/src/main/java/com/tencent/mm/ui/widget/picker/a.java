package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aj;
import com.tencent.view.d;
import java.util.Calendar;
import java.util.Locale;

public final class a implements OnGlobalLayoutListener {
    private Button grC = ((Button) this.iym.findViewById(R.id.b7o));
    private View iym = View.inflate(this.mContext, R.layout.rs, null);
    private Button jAH;
    private Context mContext;
    private BottomSheetBehavior nA;
    public CustomDatePicker zSi = ((CustomDatePicker) this.iym.findViewById(R.id.b7p));
    public a zSj;
    private c zaW = new c(this.mContext);
    private int zaX;

    public interface a<T> {
        void b(boolean z, int i, int i2, int i3);
    }

    public a(Context context) {
        AppMethodBeat.i(112812);
        this.mContext = context;
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112808);
                a.a(a.this, true, a.this.zSi.getYear(), a.this.zSi.getMonth(), a.this.zSi.getDayOfMonth());
                a.this.hide();
                AppMethodBeat.o(112808);
            }
        });
        this.jAH = (Button) this.iym.findViewById(R.id.axh);
        this.jAH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(112809);
                a.a(a.this, false, 0, 0, 0);
                a.this.hide();
                AppMethodBeat.o(112809);
            }
        });
        this.zaW.setContentView(this.iym);
        this.zaW.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(112810);
                a.a(a.this, false, 0, 0, 0);
                a.this.hide();
                AppMethodBeat.o(112810);
            }
        });
        this.zaX = aj.fromDPToPix(this.mContext, d.MIC_PTU_YOUJIALI);
        this.nA = BottomSheetBehavior.j((View) this.iym.getParent());
        if (this.nA != null) {
            this.nA.K(this.zaX);
            this.nA.nj = false;
        }
        this.zaW.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(112811);
                a.this.zaW = null;
                AppMethodBeat.o(112811);
            }
        });
        AppMethodBeat.o(112812);
    }

    public final void onGlobalLayout() {
    }

    public final void aB(int i, int i2, int i3) {
        AppMethodBeat.i(112813);
        if (i < 0 || i2 < 0 || i3 < 0) {
            AppMethodBeat.o(112813);
            return;
        }
        if (this.zSi != null) {
            this.zSi.aA(i, i2, i3);
        }
        AppMethodBeat.o(112813);
    }

    public final void al(boolean z, boolean z2) {
        AppMethodBeat.i(112814);
        if (this.zSi != null) {
            this.zSi.al(z, z2);
        }
        AppMethodBeat.o(112814);
    }

    public final void aC(int i, int i2, int i3) {
        AppMethodBeat.i(112815);
        if (i < 0 || i2 < 0 || i3 < 0) {
            AppMethodBeat.o(112815);
            return;
        }
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.set(i, i2 - 1, i3);
        if (this.zSi != null) {
            this.zSi.setMinDate(instance.getTimeInMillis());
        }
        AppMethodBeat.o(112815);
    }

    public final void aD(int i, int i2, int i3) {
        AppMethodBeat.i(112816);
        if (i < 0 || i2 < 0 || i3 < 0) {
            AppMethodBeat.o(112816);
            return;
        }
        Calendar instance = Calendar.getInstance(Locale.US);
        instance.set(i, i2 - 1, i3);
        if (this.zSi != null) {
            this.zSi.setMaxDate(instance.getTimeInMillis());
        }
        AppMethodBeat.o(112816);
    }

    public final void show() {
        AppMethodBeat.i(112817);
        if (this.zaW != null) {
            if (this.zSi != null) {
                this.zSi.aRJ();
            }
            this.zaW.show();
        }
        AppMethodBeat.o(112817);
    }

    public final void hide() {
        AppMethodBeat.i(112818);
        if (this.zaW != null) {
            this.zaW.dismiss();
        }
        AppMethodBeat.o(112818);
    }

    static /* synthetic */ void a(a aVar, boolean z, int i, int i2, int i3) {
        AppMethodBeat.i(112819);
        if (aVar.zSj != null) {
            aVar.zSj.b(z, i, i2, i3);
        }
        AppMethodBeat.o(112819);
    }
}
