package com.tencent.mm.ui.widget.picker;

import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ai;

public final class e {
    public static void a(NumberPicker numberPicker, Drawable drawable) {
        AppMethodBeat.i(112852);
        if (numberPicker != null) {
            try {
                new ad(numberPicker, "mSelectionDivider").set(drawable);
            } catch (Exception e) {
                AppMethodBeat.o(112852);
                return;
            }
        }
        AppMethodBeat.o(112852);
    }

    public static EditText b(NumberPicker numberPicker) {
        AppMethodBeat.i(112853);
        if (numberPicker == null) {
            AppMethodBeat.o(112853);
            return null;
        }
        try {
            EditText editText = (EditText) new ad(numberPicker, "mInputText").get();
            AppMethodBeat.o(112853);
            return editText;
        } catch (IllegalAccessException e) {
            ai.printErrStackTrace("NumberPickerUtil", e, "getInputText IllegalAccessException", new Object[0]);
            AppMethodBeat.o(112853);
            return null;
        } catch (NoSuchFieldException e2) {
            ai.printErrStackTrace("NumberPickerUtil", e2, "getInputText NoSuchFieldException", new Object[0]);
            AppMethodBeat.o(112853);
            return null;
        }
    }

    public static void c(NumberPicker numberPicker) {
        AppMethodBeat.i(112854);
        if (numberPicker == null) {
            AppMethodBeat.o(112854);
            return;
        }
        numberPicker.setDescendantFocusability(393216);
        AppMethodBeat.o(112854);
    }

    public static void d(NumberPicker numberPicker) {
        AppMethodBeat.i(112855);
        if (numberPicker == null) {
            AppMethodBeat.o(112855);
            return;
        }
        try {
            EditText editText = (EditText) new ad(numberPicker, "mInputText").get();
            if (editText != null) {
                editText.setFilters(new InputFilter[0]);
            }
            AppMethodBeat.o(112855);
        } catch (IllegalAccessException e) {
            ai.printErrStackTrace("NumberPickerUtil", e, "fixDefaultValueDisplaying IllegalAccessException", new Object[0]);
            AppMethodBeat.o(112855);
        } catch (NoSuchFieldException e2) {
            ai.printErrStackTrace("NumberPickerUtil", e2, "fixDefaultValueDisplaying NoSuchFieldException", new Object[0]);
            AppMethodBeat.o(112855);
        }
    }

    public static void e(NumberPicker numberPicker) {
        AppMethodBeat.i(112856);
        if (numberPicker == null) {
            AppMethodBeat.o(112856);
            return;
        }
        try {
            Runnable runnable = (Runnable) new ad(numberPicker, "mSetSelectionCommand").get();
            if (runnable != null) {
                numberPicker.removeCallbacks(runnable);
            }
            AppMethodBeat.o(112856);
        } catch (IllegalAccessException e) {
            ai.printErrStackTrace("NumberPickerUtil", e, "removePendingSetSelectionCommand IllegalAccessException", new Object[0]);
            AppMethodBeat.o(112856);
        } catch (NoSuchFieldException e2) {
            ai.printErrStackTrace("NumberPickerUtil", e2, "removePendingSetSelectionCommand NoSuchFieldException", new Object[0]);
            AppMethodBeat.o(112856);
        }
    }
}
