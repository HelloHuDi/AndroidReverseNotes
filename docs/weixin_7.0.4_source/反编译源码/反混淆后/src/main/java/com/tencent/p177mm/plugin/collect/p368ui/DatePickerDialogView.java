package com.tencent.p177mm.plugin.collect.p368ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.widget.MMSpinnerDatePicker;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.collect.ui.DatePickerDialogView */
public class DatePickerDialogView extends LinearLayout implements OnClickListener {
    private CollectRadioBtnView kHD;
    private CollectRadioBtnView kHE;
    private CollectRadioBtnView kHF;
    private MMSpinnerDatePicker kHG;
    private TextView kHH;
    private TextView kHI;
    private int kHJ = 0;

    public DatePickerDialogView(Context context) {
        super(context);
        AppMethodBeat.m2504i(41334);
        init(context);
        AppMethodBeat.m2505o(41334);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(41335);
        init(context);
        AppMethodBeat.m2505o(41335);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(41336);
        init(context);
        AppMethodBeat.m2505o(41336);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(41337);
        View inflate = C5616v.m8409hu(context).inflate(2130969151, this);
        this.kHD = (CollectRadioBtnView) inflate.findViewById(2131822820);
        this.kHE = (CollectRadioBtnView) inflate.findViewById(2131822821);
        this.kHF = (CollectRadioBtnView) inflate.findViewById(2131822822);
        this.kHH = (TextView) inflate.findViewById(2131820999);
        this.kHI = (TextView) inflate.findViewById(2131822819);
        this.kHD.setOnClickListener(this);
        this.kHE.setOnClickListener(this);
        this.kHF.setOnClickListener(this);
        this.kHD.setTitleText("年");
        this.kHE.setTitleText("月");
        this.kHF.setTitleText("日");
        this.kHG = (MMSpinnerDatePicker) inflate.findViewById(2131822823);
        this.kHG.dKC();
        this.kHG.setTextSize(C25738R.dimen.f9980m5);
        AppMethodBeat.m2505o(41337);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(41338);
        int id = view.getId();
        if (id == 2131822820) {
            this.kHJ = 2;
        } else if (id == 2131822821) {
            this.kHJ = 1;
        } else if (id == 2131822822) {
            this.kHJ = 0;
        } else {
            C4990ab.m7417i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", view.getClass().toString());
        }
        bhH();
        AppMethodBeat.m2505o(41338);
    }

    private void bhH() {
        AppMethodBeat.m2504i(41339);
        if (this.kHJ == 2) {
            this.kHD.setRadioSrc(C1318a.radio_on);
            this.kHE.setRadioSrc(C1318a.radio_off);
            this.kHF.setRadioSrc(C1318a.radio_off);
        } else if (this.kHJ == 1) {
            this.kHD.setRadioSrc(C1318a.radio_off);
            this.kHE.setRadioSrc(C1318a.radio_on);
            this.kHF.setRadioSrc(C1318a.radio_off);
        } else {
            this.kHD.setRadioSrc(C1318a.radio_off);
            this.kHE.setRadioSrc(C1318a.radio_off);
            this.kHF.setRadioSrc(C1318a.radio_on);
        }
        this.kHG.setPickerMode(this.kHJ);
        AppMethodBeat.m2505o(41339);
    }

    public void setDatePickerMode(int i) {
        AppMethodBeat.m2504i(41340);
        this.kHJ = i;
        bhH();
        AppMethodBeat.m2505o(41340);
    }

    public void setOnOkBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(41341);
        this.kHH.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(41341);
    }

    public void setOnCancelBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(41342);
        this.kHI.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(41342);
    }

    public int getYear() {
        AppMethodBeat.m2504i(41343);
        int year = this.kHG.getYear();
        AppMethodBeat.m2505o(41343);
        return year;
    }

    public int getMonth() {
        AppMethodBeat.m2504i(41344);
        int month = this.kHG.getMonth();
        AppMethodBeat.m2505o(41344);
        return month;
    }

    public int getDayOfMonth() {
        AppMethodBeat.m2504i(41345);
        int dayOfMonth = this.kHG.getDayOfMonth();
        AppMethodBeat.m2505o(41345);
        return dayOfMonth;
    }

    public int getDatePickerMode() {
        AppMethodBeat.m2504i(41346);
        int pickerMode = this.kHG.getPickerMode();
        AppMethodBeat.m2505o(41346);
        return pickerMode;
    }
}
