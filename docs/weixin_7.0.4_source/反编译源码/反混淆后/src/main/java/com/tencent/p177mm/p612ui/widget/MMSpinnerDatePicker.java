package com.tencent.p177mm.p612ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.ui.widget.MMSpinnerDatePicker */
public class MMSpinnerDatePicker extends DatePicker implements OnDateChangedListener {
    private NumberPicker zMD;
    private NumberPicker zME;
    private NumberPicker zMF;
    private C40901a zMG;
    private int zMH = 0;

    /* renamed from: com.tencent.mm.ui.widget.MMSpinnerDatePicker$a */
    public interface C40901a {
    }

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107914);
        init();
        AppMethodBeat.m2505o(107914);
    }

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107915);
        init();
        AppMethodBeat.m2505o(107915);
    }

    private void init() {
        AppMethodBeat.m2504i(107916);
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
        AppMethodBeat.m2505o(107916);
    }

    public void setPickerMode(int i) {
        AppMethodBeat.m2504i(107917);
        this.zMH = i;
        if (this.zMH == 0) {
            this.zMD.setVisibility(0);
            this.zME.setVisibility(0);
            this.zMF.setVisibility(0);
            AppMethodBeat.m2505o(107917);
        } else if (this.zMH == 1) {
            this.zMD.setVisibility(0);
            this.zME.setVisibility(0);
            this.zMF.setVisibility(8);
            AppMethodBeat.m2505o(107917);
        } else {
            this.zMD.setVisibility(0);
            this.zME.setVisibility(8);
            this.zMF.setVisibility(8);
            AppMethodBeat.m2505o(107917);
        }
    }

    public int getPickerMode() {
        return this.zMH;
    }

    public void setOnDateChangeListener(C40901a c40901a) {
        this.zMG = c40901a;
    }

    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
    }

    public final boolean dKC() {
        AppMethodBeat.m2504i(107918);
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDivider");
            declaredField.setAccessible(true);
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(getResources().getColor(C25738R.color.a3p));
            declaredField.set(this.zMD, colorDrawable);
            declaredField.set(this.zME, colorDrawable);
            declaredField.set(this.zMF, colorDrawable);
            invalidate();
            AppMethodBeat.m2505o(107918);
            return true;
        } catch (IllegalAccessException e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e, "", new Object[0]);
            AppMethodBeat.m2505o(107918);
            return false;
        } catch (NoSuchFieldException e2) {
            C4990ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
            AppMethodBeat.m2505o(107918);
            return false;
        }
    }

    public void setTextSize(int i) {
        AppMethodBeat.m2504i(107919);
        m70895a(this.zMD, i);
        m70895a(this.zME, i);
        m70895a(this.zMF, i);
        AppMethodBeat.m2505o(107919);
    }

    /* renamed from: a */
    private void m70895a(NumberPicker numberPicker, int i) {
        AppMethodBeat.m2504i(107920);
        if (numberPicker == null) {
            AppMethodBeat.m2505o(107920);
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
            AppMethodBeat.m2505o(107920);
        } catch (NoSuchFieldException e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e, "", new Object[0]);
            AppMethodBeat.m2505o(107920);
        } catch (IllegalAccessException e2) {
            C4990ab.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
            AppMethodBeat.m2505o(107920);
        }
    }
}
