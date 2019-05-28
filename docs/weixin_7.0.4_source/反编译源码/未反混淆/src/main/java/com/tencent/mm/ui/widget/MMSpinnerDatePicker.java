package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public class MMSpinnerDatePicker extends DatePicker implements OnDateChangedListener {
    private NumberPicker zMD;
    private NumberPicker zME;
    private NumberPicker zMF;
    private a zMG;
    private int zMH = 0;

    public interface a {
    }

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107914);
        init();
        AppMethodBeat.o(107914);
    }

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107915);
        init();
        AppMethodBeat.o(107915);
    }

    private void init() {
        AppMethodBeat.i(107916);
        setCalendarViewShown(false);
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("year", "id", "android");
        int identifier2 = system.getIdentifier("month", "id", "android");
        int identifier3 = system.getIdentifier("day", "id", "android");
        this.zMD = (NumberPicker) findViewById(identifier);
        this.zME = (NumberPicker) findViewById(identifier2);
        this.zMF = (NumberPicker) findViewById(identifier3);
        View childAt = getChildAt(0);
        LayoutParams layoutParams = childAt.getLayoutParams();
        layoutParams.width = -1;
        childAt.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.zMD.getLayoutParams();
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        layoutParams2.leftMargin = 0;
        layoutParams2.rightMargin = 0;
        layoutParams2.weight = 1.0f;
        this.zMD.setLayoutParams(layoutParams2);
        this.zME.setLayoutParams(layoutParams2);
        this.zMF.setLayoutParams(layoutParams2);
        setDescendantFocusability(393216);
        setPickerMode(2);
        AppMethodBeat.o(107916);
    }

    public void setPickerMode(int i) {
        AppMethodBeat.i(107917);
        this.zMH = i;
        if (this.zMH == 0) {
            this.zMD.setVisibility(0);
            this.zME.setVisibility(0);
            this.zMF.setVisibility(0);
            AppMethodBeat.o(107917);
        } else if (this.zMH == 1) {
            this.zMD.setVisibility(0);
            this.zME.setVisibility(0);
            this.zMF.setVisibility(8);
            AppMethodBeat.o(107917);
        } else {
            this.zMD.setVisibility(0);
            this.zME.setVisibility(8);
            this.zMF.setVisibility(8);
            AppMethodBeat.o(107917);
        }
    }

    public int getPickerMode() {
        return this.zMH;
    }

    public void setOnDateChangeListener(a aVar) {
        this.zMG = aVar;
    }

    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
    }

    public final boolean dKC() {
        AppMethodBeat.i(107918);
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDivider");
            declaredField.setAccessible(true);
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(getResources().getColor(R.color.a3p));
            declaredField.set(this.zMD, colorDrawable);
            declaredField.set(this.zME, colorDrawable);
            declaredField.set(this.zMF, colorDrawable);
            invalidate();
            AppMethodBeat.o(107918);
            return true;
        } catch (IllegalAccessException e) {
            ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e, "", new Object[0]);
            AppMethodBeat.o(107918);
            return false;
        } catch (NoSuchFieldException e2) {
            ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
            AppMethodBeat.o(107918);
            return false;
        }
    }

    public void setTextSize(int i) {
        AppMethodBeat.i(107919);
        a(this.zMD, i);
        a(this.zME, i);
        a(this.zMF, i);
        AppMethodBeat.o(107919);
    }

    private void a(NumberPicker numberPicker, int i) {
        AppMethodBeat.i(107920);
        if (numberPicker == null) {
            AppMethodBeat.o(107920);
            return;
        }
        EditText editText = (EditText) numberPicker.findViewById(Resources.getSystem().getIdentifier("numberpicker_input", "id", "android"));
        editText.setTextSize(0, getResources().getDimension(i));
        int textSize = (int) editText.getTextSize();
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mTextSize");
            declaredField.setAccessible(true);
            declaredField.set(numberPicker, Integer.valueOf(textSize));
            Field declaredField2 = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
            declaredField2.setAccessible(true);
            Paint paint = (Paint) declaredField2.get(numberPicker);
            paint.setTextSize((float) textSize);
            declaredField2.set(numberPicker, paint);
            AppMethodBeat.o(107920);
        } catch (NoSuchFieldException e) {
            ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e, "", new Object[0]);
            AppMethodBeat.o(107920);
        } catch (IllegalAccessException e2) {
            ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
            AppMethodBeat.o(107920);
        }
    }
}
