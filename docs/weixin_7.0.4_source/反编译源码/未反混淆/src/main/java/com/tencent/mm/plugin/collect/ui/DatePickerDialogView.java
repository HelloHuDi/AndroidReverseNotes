package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

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
        AppMethodBeat.i(41334);
        init(context);
        AppMethodBeat.o(41334);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41335);
        init(context);
        AppMethodBeat.o(41335);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(41336);
        init(context);
        AppMethodBeat.o(41336);
    }

    private void init(Context context) {
        AppMethodBeat.i(41337);
        View inflate = v.hu(context).inflate(R.layout.os, this);
        this.kHD = (CollectRadioBtnView) inflate.findViewById(R.id.axi);
        this.kHE = (CollectRadioBtnView) inflate.findViewById(R.id.axj);
        this.kHF = (CollectRadioBtnView) inflate.findViewById(R.id.axk);
        this.kHH = (TextView) inflate.findViewById(R.id.ll);
        this.kHI = (TextView) inflate.findViewById(R.id.axh);
        this.kHD.setOnClickListener(this);
        this.kHE.setOnClickListener(this);
        this.kHF.setOnClickListener(this);
        this.kHD.setTitleText("年");
        this.kHE.setTitleText("月");
        this.kHF.setTitleText("日");
        this.kHG = (MMSpinnerDatePicker) inflate.findViewById(R.id.axl);
        this.kHG.dKC();
        this.kHG.setTextSize(R.dimen.m5);
        AppMethodBeat.o(41337);
    }

    public void onClick(View view) {
        AppMethodBeat.i(41338);
        int id = view.getId();
        if (id == R.id.axi) {
            this.kHJ = 2;
        } else if (id == R.id.axj) {
            this.kHJ = 1;
        } else if (id == R.id.axk) {
            this.kHJ = 0;
        } else {
            ab.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", view.getClass().toString());
        }
        bhH();
        AppMethodBeat.o(41338);
    }

    private void bhH() {
        AppMethodBeat.i(41339);
        if (this.kHJ == 2) {
            this.kHD.setRadioSrc(R.raw.radio_on);
            this.kHE.setRadioSrc(R.raw.radio_off);
            this.kHF.setRadioSrc(R.raw.radio_off);
        } else if (this.kHJ == 1) {
            this.kHD.setRadioSrc(R.raw.radio_off);
            this.kHE.setRadioSrc(R.raw.radio_on);
            this.kHF.setRadioSrc(R.raw.radio_off);
        } else {
            this.kHD.setRadioSrc(R.raw.radio_off);
            this.kHE.setRadioSrc(R.raw.radio_off);
            this.kHF.setRadioSrc(R.raw.radio_on);
        }
        this.kHG.setPickerMode(this.kHJ);
        AppMethodBeat.o(41339);
    }

    public void setDatePickerMode(int i) {
        AppMethodBeat.i(41340);
        this.kHJ = i;
        bhH();
        AppMethodBeat.o(41340);
    }

    public void setOnOkBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(41341);
        this.kHH.setOnClickListener(onClickListener);
        AppMethodBeat.o(41341);
    }

    public void setOnCancelBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(41342);
        this.kHI.setOnClickListener(onClickListener);
        AppMethodBeat.o(41342);
    }

    public int getYear() {
        AppMethodBeat.i(41343);
        int year = this.kHG.getYear();
        AppMethodBeat.o(41343);
        return year;
    }

    public int getMonth() {
        AppMethodBeat.i(41344);
        int month = this.kHG.getMonth();
        AppMethodBeat.o(41344);
        return month;
    }

    public int getDayOfMonth() {
        AppMethodBeat.i(41345);
        int dayOfMonth = this.kHG.getDayOfMonth();
        AppMethodBeat.o(41345);
        return dayOfMonth;
    }

    public int getDatePickerMode() {
        AppMethodBeat.i(41346);
        int pickerMode = this.kHG.getPickerMode();
        AppMethodBeat.o(41346);
        return pickerMode;
    }
}
