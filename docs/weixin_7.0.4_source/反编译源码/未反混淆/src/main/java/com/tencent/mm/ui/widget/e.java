package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends DatePickerDialog {
    private boolean zMe;
    private long zMf;
    private int zMg;

    class a {
        a() {
        }

        @TargetApi(11)
        public final NumberPicker x(ViewGroup viewGroup) {
            AppMethodBeat.i(107863);
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    NumberPicker numberPicker;
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof NumberPicker) {
                        numberPicker = (NumberPicker) childAt;
                        if (numberPicker.getMaxValue() >= 28 && numberPicker.getMaxValue() <= 31) {
                            AppMethodBeat.o(107863);
                            return numberPicker;
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        numberPicker = x((ViewGroup) childAt);
                        if (numberPicker != null) {
                            AppMethodBeat.o(107863);
                            return numberPicker;
                        }
                    }
                }
            }
            AppMethodBeat.o(107863);
            return null;
        }
    }

    class b {
        b() {
        }

        public final View e(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(107864);
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i2 = 0;
                while (i2 < childCount) {
                    View childAt = viewGroup.getChildAt(i2);
                    Class cls = childAt.getClass();
                    ab.d("MicroMsg.MMDatePickerDialog", "NAME = ".concat(String.valueOf(cls.getName())));
                    ab.d("MicroMsg.MMDatePickerDialog", "SimpleName = " + cls.getSimpleName());
                    if ("NumberPicker".equals(cls.getSimpleName()) && i2 == i) {
                        AppMethodBeat.o(107864);
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        childAt = e((ViewGroup) childAt, i);
                        if (childAt != null) {
                            AppMethodBeat.o(107864);
                            return childAt;
                        }
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(107864);
            return null;
        }
    }

    public e(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.zMe = true;
        this.zMe = true;
        this.zMf = j;
        this.zMg = 1;
    }

    public e(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j, byte b) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.zMe = true;
        this.zMe = true;
        this.zMf = j;
        this.zMg = 1;
    }

    @SuppressLint({"DefaultLocale"})
    public final void show() {
        int i = 1;
        AppMethodBeat.i(107865);
        super.show();
        if (this.zMe) {
            if (VERSION.SDK_INT >= 11) {
                NumberPicker x = new a().x((ViewGroup) getWindow().getDecorView());
                if (x != null && this.zMg > 1) {
                    x.setVisibility(8);
                }
            } else {
                Object string = System.getString(getContext().getContentResolver(), "date_format");
                if (string != null) {
                    string = string.toLowerCase();
                }
                if ("dd/mm/yyyy".equals(string) || "dd-mm-yyyy".equals(string)) {
                    i = 0;
                } else if (!("mm/dd/yyyy".equals(string) || "mm-dd-yyyy".equals(string))) {
                    i = ("yyyy/mm/dd".equals(string) || "yyyy-mm-dd".equals(string)) ? 2 : -1;
                }
                if (i != -1) {
                    View e = new b().e((ViewGroup) getWindow().getDecorView(), i);
                    if (e != null) {
                        e.setVisibility(8);
                    }
                }
            }
            int year = getDatePicker().getYear();
            i = getDatePicker().getMonth();
            getDatePicker().getDayOfMonth();
            hA(year, i);
        }
        this.zMe = false;
        AppMethodBeat.o(107865);
    }

    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        AppMethodBeat.i(107866);
        super.onDateChanged(datePicker, i, i2, i3);
        hA(i, i2);
        AppMethodBeat.o(107866);
    }

    private void hA(int i, int i2) {
        AppMethodBeat.i(107867);
        if (this.zMg > 1) {
            setTitle(getContext().getString(R.string.bz5, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1)}));
        }
        AppMethodBeat.o(107867);
    }

    public final void nw(long j) {
        AppMethodBeat.i(107868);
        getDatePicker().setMaxDate(j);
        AppMethodBeat.o(107868);
    }

    public final void nx(long j) {
        AppMethodBeat.i(107869);
        getDatePicker().setMinDate(j);
        AppMethodBeat.o(107869);
    }
}
