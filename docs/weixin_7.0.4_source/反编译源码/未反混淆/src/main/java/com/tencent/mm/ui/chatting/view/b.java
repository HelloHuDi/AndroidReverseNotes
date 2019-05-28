package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.Calendar;

public final class b {
    private Button grC;
    private View iym;
    private Button jAH;
    Context mContext;
    private BottomSheetBehavior nA;
    OptionPicker zaU;
    OptionPicker zaV;
    c zaW;
    private int zaX;
    public a zaY;
    ArrayList<Long> zaZ = new ArrayList(42);

    public interface a {
        void ne(long j);

        void onCancel();
    }

    public b(Context context) {
        AppMethodBeat.i(32780);
        this.mContext = context;
        this.iym = View.inflate(this.mContext, R.layout.ao_, null);
        this.zaW = new c(this.mContext);
        this.zaW.setContentView(this.iym);
        this.zaW.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                b.this.zaW = null;
            }
        });
        this.zaU = (OptionPicker) this.iym.findViewById(R.id.dyi);
        this.zaV = (OptionPicker) this.iym.findViewById(R.id.dko);
        this.zaU.setValue(0);
        this.zaU.setMinWidth(com.tencent.mm.bz.a.fromDPToPix(this.mContext, 60));
        this.zaV.setMinWidth(com.tencent.mm.bz.a.fromDPToPix(this.mContext, 60));
        this.zaU.setOptionsArray(dHi());
        this.zaV.setOptionsArray(Pk(0));
        this.zaU.setOnValueChangedListener(new OnValueChangeListener() {
            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                AppMethodBeat.i(32777);
                ab.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", Integer.valueOf(i), Integer.valueOf(i2));
                b.this.zaV.setOptionsArray(b.this.Pk(i2));
                int i3 = Calendar.getInstance().get(11);
                if (i2 == 0) {
                    b.this.zaV.setValue(0);
                    AppMethodBeat.o(32777);
                    return;
                }
                b.this.zaV.setValue(i3);
                AppMethodBeat.o(32777);
            }
        });
        LayoutParams layoutParams = (LayoutParams) this.iym.getLayoutParams();
        layoutParams.height = com.tencent.mm.bz.a.fromDPToPix(this.mContext, d.MIC_PTU_YOUJIALI);
        this.iym.setLayoutParams(layoutParams);
        this.zaX = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 350);
        this.nA = BottomSheetBehavior.j((View) this.iym.getParent());
        if (this.nA != null) {
            this.nA.K(this.zaX);
            this.nA.nj = false;
        }
        this.grC = (Button) this.iym.findViewById(R.id.b7o);
        this.grC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(32778);
                if (b.this.zaY != null) {
                    a aVar = b.this.zaY;
                    b bVar = b.this;
                    long currentTimeMillis = System.currentTimeMillis();
                    int value = bVar.zaU.getValue();
                    int value2 = bVar.zaV.getValue();
                    if (value != 0) {
                        currentTimeMillis = ((Long) bVar.zaZ.get(value)).longValue() + (((long) (value2 + 1)) * 3600000);
                    } else if (com.tencent.mm.sdk.a.b.dnO()) {
                        currentTimeMillis += 360000;
                    } else {
                        currentTimeMillis += ((long) (value2 + 1)) * 3600000;
                    }
                    String formatTime = h.formatTime(bVar.mContext.getString(R.string.bxf) + "HH:mm", currentTimeMillis / 1000);
                    ab.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", formatTime);
                    aVar.ne(currentTimeMillis);
                }
                AppMethodBeat.o(32778);
            }
        });
        this.jAH = (Button) this.iym.findViewById(R.id.axh);
        this.jAH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(32779);
                if (b.this.zaY != null) {
                    b.this.zaY.onCancel();
                }
                AppMethodBeat.o(32779);
            }
        });
        AppMethodBeat.o(32780);
    }

    public final void show() {
        AppMethodBeat.i(32781);
        if (this.zaW != null) {
            this.zaW.show();
        }
        AppMethodBeat.o(32781);
    }

    public final void hide() {
        AppMethodBeat.i(32782);
        if (this.zaW != null) {
            this.zaW.dismiss();
        }
        AppMethodBeat.o(32782);
    }

    /* Access modifiers changed, original: final */
    public final String[] Pk(int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(32783);
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mm.sdk.a.b.dnO()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        switch (i - i2) {
            case -1:
                arrayList.add("after 6 min");
                break;
            case 0:
                int i4 = Calendar.getInstance().get(11);
                for (i2 = 1; i2 <= 24 - i4; i2++) {
                    arrayList.add(this.mContext.getResources().getString(R.string.f5, new Object[]{Integer.valueOf(i2)}));
                }
                break;
            default:
                while (true) {
                    i2 = i3;
                    if (i2 > 24) {
                        break;
                    }
                    arrayList.add((i2 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2)) : Integer.valueOf(i2)) + ":00");
                    i3 = i2 + 1;
                }
        }
        String[] ej = bo.ej(arrayList);
        AppMethodBeat.o(32783);
        return ej;
    }

    private String[] dHi() {
        int i = 0;
        AppMethodBeat.i(32784);
        this.zaZ.clear();
        ArrayList arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        int i2 = 0;
        while (i2 < instance.getActualMaximum(5)) {
            if (com.tencent.mm.sdk.a.b.dnO() && i2 == 0) {
                arrayList.add("test");
                this.zaZ.add(Long.valueOf(instance.getTimeInMillis()));
            }
            if (i2 == 0) {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                this.zaZ.add(Long.valueOf(instance.getTimeInMillis()));
            } else {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                this.zaZ.add(Long.valueOf(instance.getTimeInMillis()));
            }
            String formatTime = h.formatTime(this.mContext.getString(R.string.bww), instance.getTimeInMillis() / 1000);
            if (i2 == 0) {
                arrayList.add(this.mContext.getResources().getString(R.string.by3));
            } else if (i2 == 1) {
                arrayList.add(formatTime + " " + this.mContext.getResources().getString(R.string.by4));
            } else if (i2 == 2) {
                arrayList.add(formatTime + " " + this.mContext.getResources().getString(R.string.bxu));
            } else {
                arrayList.add(formatTime + " " + h.af(this.mContext, instance.get(7)));
            }
            i2++;
        }
        i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        while (i < 12) {
            if (i3 + i > 12) {
                instance.set(1, i2 + 1);
                instance.set(2, (i3 + i) - 12);
            } else {
                instance.set(2, i3 + i);
            }
            instance.set(5, 1);
            this.zaZ.add(Long.valueOf(instance.getTimeInMillis()));
            arrayList.add(String.valueOf(h.formatTime(this.mContext.getString(R.string.bxf), instance.getTimeInMillis() / 1000)));
            i++;
        }
        String[] ej = bo.ej(arrayList);
        AppMethodBeat.o(32784);
        return ej;
    }
}
