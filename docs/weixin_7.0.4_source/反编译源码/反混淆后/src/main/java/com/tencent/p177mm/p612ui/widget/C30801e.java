package com.tencent.p177mm.p612ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.widget.e */
public final class C30801e extends DatePickerDialog {
    private boolean zMe;
    private long zMf;
    private int zMg;

    /* renamed from: com.tencent.mm.ui.widget.e$a */
    class C24094a {
        C24094a() {
        }

        @TargetApi(11)
        /* renamed from: x */
        public final NumberPicker mo39898x(ViewGroup viewGroup) {
            AppMethodBeat.m2504i(107863);
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    NumberPicker numberPicker;
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof NumberPicker) {
                        numberPicker = (NumberPicker) childAt;
                        if (numberPicker.getMaxValue() >= 28 && numberPicker.getMaxValue() <= 31) {
                            AppMethodBeat.m2505o(107863);
                            return numberPicker;
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        numberPicker = mo39898x((ViewGroup) childAt);
                        if (numberPicker != null) {
                            AppMethodBeat.m2505o(107863);
                            return numberPicker;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(107863);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.e$b */
    class C24095b {
        C24095b() {
        }

        /* renamed from: e */
        public final View mo39899e(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(107864);
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i2 = 0;
                while (i2 < childCount) {
                    View childAt = viewGroup.getChildAt(i2);
                    Class cls = childAt.getClass();
                    C4990ab.m7410d("MicroMsg.MMDatePickerDialog", "NAME = ".concat(String.valueOf(cls.getName())));
                    C4990ab.m7410d("MicroMsg.MMDatePickerDialog", "SimpleName = " + cls.getSimpleName());
                    if ("NumberPicker".equals(cls.getSimpleName()) && i2 == i) {
                        AppMethodBeat.m2505o(107864);
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        childAt = mo39899e((ViewGroup) childAt, i);
                        if (childAt != null) {
                            AppMethodBeat.m2505o(107864);
                            return childAt;
                        }
                    }
                    i2++;
                }
            }
            AppMethodBeat.m2505o(107864);
            return null;
        }
    }

    public C30801e(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.zMe = true;
        this.zMe = true;
        this.zMf = j;
        this.zMg = 1;
    }

    public C30801e(Context context, OnDateSetListener onDateSetListener, int i, int i2, int i3, long j, byte b) {
        super(context, 3, onDateSetListener, i, i2, i3);
        this.zMe = true;
        this.zMe = true;
        this.zMf = j;
        this.zMg = 1;
    }

    @SuppressLint({"DefaultLocale"})
    public final void show() {
        int i = 1;
        AppMethodBeat.m2504i(107865);
        super.show();
        if (this.zMe) {
            if (VERSION.SDK_INT >= 11) {
                NumberPicker x = new C24094a().mo39898x((ViewGroup) getWindow().getDecorView());
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
                    View e = new C24095b().mo39899e((ViewGroup) getWindow().getDecorView(), i);
                    if (e != null) {
                        e.setVisibility(8);
                    }
                }
            }
            int year = getDatePicker().getYear();
            i = getDatePicker().getMonth();
            getDatePicker().getDayOfMonth();
            m49148hA(year, i);
        }
        this.zMe = false;
        AppMethodBeat.m2505o(107865);
    }

    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        AppMethodBeat.m2504i(107866);
        super.onDateChanged(datePicker, i, i2, i3);
        m49148hA(i, i2);
        AppMethodBeat.m2505o(107866);
    }

    /* renamed from: hA */
    private void m49148hA(int i, int i2) {
        AppMethodBeat.m2504i(107867);
        if (this.zMg > 1) {
            setTitle(getContext().getString(C25738R.string.bz5, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1)}));
        }
        AppMethodBeat.m2505o(107867);
    }

    /* renamed from: nw */
    public final void mo49241nw(long j) {
        AppMethodBeat.m2504i(107868);
        getDatePicker().setMaxDate(j);
        AppMethodBeat.m2505o(107868);
    }

    /* renamed from: nx */
    public final void mo49242nx(long j) {
        AppMethodBeat.m2504i(107869);
        getDatePicker().setMinDate(j);
        AppMethodBeat.m2505o(107869);
    }
}
