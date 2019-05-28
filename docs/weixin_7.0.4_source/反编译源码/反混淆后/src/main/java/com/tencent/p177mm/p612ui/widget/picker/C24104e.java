package com.tencent.p177mm.p612ui.widget.picker;

import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C23574ad;
import com.tencent.p177mm.p612ui.C5227ai;

/* renamed from: com.tencent.mm.ui.widget.picker.e */
public final class C24104e {
    /* renamed from: a */
    public static void m37070a(NumberPicker numberPicker, Drawable drawable) {
        AppMethodBeat.m2504i(112852);
        if (numberPicker != null) {
            try {
                new C23574ad(numberPicker, "mSelectionDivider").set(drawable);
            } catch (Exception e) {
                AppMethodBeat.m2505o(112852);
                return;
            }
        }
        AppMethodBeat.m2505o(112852);
    }

    /* renamed from: b */
    public static EditText m37071b(NumberPicker numberPicker) {
        AppMethodBeat.m2504i(112853);
        if (numberPicker == null) {
            AppMethodBeat.m2505o(112853);
            return null;
        }
        try {
            EditText editText = (EditText) new C23574ad(numberPicker, "mInputText").get();
            AppMethodBeat.m2505o(112853);
            return editText;
        } catch (IllegalAccessException e) {
            C5227ai.printErrStackTrace("NumberPickerUtil", e, "getInputText IllegalAccessException", new Object[0]);
            AppMethodBeat.m2505o(112853);
            return null;
        } catch (NoSuchFieldException e2) {
            C5227ai.printErrStackTrace("NumberPickerUtil", e2, "getInputText NoSuchFieldException", new Object[0]);
            AppMethodBeat.m2505o(112853);
            return null;
        }
    }

    /* renamed from: c */
    public static void m37072c(NumberPicker numberPicker) {
        AppMethodBeat.m2504i(112854);
        if (numberPicker == null) {
            AppMethodBeat.m2505o(112854);
            return;
        }
        numberPicker.setDescendantFocusability(393216);
        AppMethodBeat.m2505o(112854);
    }

    /* renamed from: d */
    public static void m37073d(NumberPicker numberPicker) {
        AppMethodBeat.m2504i(112855);
        if (numberPicker == null) {
            AppMethodBeat.m2505o(112855);
            return;
        }
        try {
            EditText editText = (EditText) new C23574ad(numberPicker, "mInputText").get();
            if (editText != null) {
                editText.setFilters(new InputFilter[0]);
            }
            AppMethodBeat.m2505o(112855);
        } catch (IllegalAccessException e) {
            C5227ai.printErrStackTrace("NumberPickerUtil", e, "fixDefaultValueDisplaying IllegalAccessException", new Object[0]);
            AppMethodBeat.m2505o(112855);
        } catch (NoSuchFieldException e2) {
            C5227ai.printErrStackTrace("NumberPickerUtil", e2, "fixDefaultValueDisplaying NoSuchFieldException", new Object[0]);
            AppMethodBeat.m2505o(112855);
        }
    }

    /* renamed from: e */
    public static void m37074e(NumberPicker numberPicker) {
        AppMethodBeat.m2504i(112856);
        if (numberPicker == null) {
            AppMethodBeat.m2505o(112856);
            return;
        }
        try {
            Runnable runnable = (Runnable) new C23574ad(numberPicker, "mSetSelectionCommand").get();
            if (runnable != null) {
                numberPicker.removeCallbacks(runnable);
            }
            AppMethodBeat.m2505o(112856);
        } catch (IllegalAccessException e) {
            C5227ai.printErrStackTrace("NumberPickerUtil", e, "removePendingSetSelectionCommand IllegalAccessException", new Object[0]);
            AppMethodBeat.m2505o(112856);
        } catch (NoSuchFieldException e2) {
            C5227ai.printErrStackTrace("NumberPickerUtil", e2, "removePendingSetSelectionCommand NoSuchFieldException", new Object[0]);
            AppMethodBeat.m2505o(112856);
        }
    }
}
