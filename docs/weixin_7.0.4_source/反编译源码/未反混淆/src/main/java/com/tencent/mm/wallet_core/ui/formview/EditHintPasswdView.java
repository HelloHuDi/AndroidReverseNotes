package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.v;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView extends RelativeLayout implements OnFocusChangeListener {
    private static final int AhW = R.drawable.lw;
    private TenpaySecureEditText AhX;
    private int AhY;
    private int AhZ;
    private int Aia;
    private a Aib;
    private OnFocusChangeListener gJD;
    private int sZx;

    public interface a {
        void hY(boolean z);
    }

    static /* synthetic */ boolean c(EditHintPasswdView editHintPasswdView) {
        AppMethodBeat.i(49400);
        boolean asa = editHintPasswdView.asa();
        AppMethodBeat.o(49400);
        return asa;
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(49390);
        this.AhX = null;
        this.AhY = 6;
        this.sZx = 1;
        this.AhZ = AhW;
        this.Aia = 1;
        this.Aib = null;
        this.gJD = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.plugin.wxpay.a.a.PwdAttr, i, 0);
        this.sZx = obtainStyledAttributes.getInteger(0, 1);
        this.AhZ = obtainStyledAttributes.getResourceId(1, AhW);
        this.Aia = obtainStyledAttributes.getInteger(2, 1);
        obtainStyledAttributes.recycle();
        this.AhX = (TenpaySecureEditText) v.hu(context).inflate(R.layout.a6s, this, true).findViewById(R.id.d6);
        b.a(this.AhX, this.sZx);
        this.AhY = getNumberSize();
        if (this.AhX != null) {
            this.AhX.setBackgroundResource(this.AhZ);
            this.AhX.setImeOptions(6);
            this.AhX.setInputType(128);
            this.AhX.addTextChangedListener(new TextWatcher() {
                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(49389);
                    if (EditHintPasswdView.this.Aib != null) {
                        EditHintPasswdView.this.Aib.hY(EditHintPasswdView.c(EditHintPasswdView.this));
                    }
                    AppMethodBeat.o(49389);
                }
            });
            this.AhX.setOnFocusChangeListener(this);
            this.AhX.setClickable(false);
            this.AhX.setLongClickable(false);
            super.setEnabled(true);
            super.setClickable(true);
            AppMethodBeat.o(49390);
            return;
        }
        ab.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
        AppMethodBeat.o(49390);
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final String getMd5Value() {
        AppMethodBeat.i(49391);
        String ck;
        if (this.AhX != null) {
            ck = ag.ck(this.AhX.getText().toString());
            AppMethodBeat.o(49391);
            return ck;
        }
        ab.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
        ck = "";
        AppMethodBeat.o(49391);
        return ck;
    }

    private boolean asa() {
        AppMethodBeat.i(49392);
        if (this.AhX == null || this.AhX.getInputLength() != this.AhY) {
            AppMethodBeat.o(49392);
            return false;
        }
        AppMethodBeat.o(49392);
        return true;
    }

    private int getNumberSize() {
        AppMethodBeat.i(49393);
        switch (this.sZx) {
            case 1:
                AppMethodBeat.o(49393);
                return 6;
            case 3:
                AppMethodBeat.o(49393);
                return 3;
            case 4:
                AppMethodBeat.o(49393);
                return 4;
            case 8:
                AppMethodBeat.o(49393);
                return 4;
            default:
                ab.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
                AppMethodBeat.o(49393);
                return 6;
        }
    }

    public final void setOnInputValidListener(a aVar) {
        this.Aib = aVar;
    }

    public final a getOnEditInputValidListener() {
        return this.Aib;
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.gJD = onFocusChangeListener;
    }

    public final OnFocusChangeListener getOnFocusChangeListener() {
        return this.gJD;
    }

    public final void setEncrType(int i) {
        this.Aia = i;
    }

    public final int getEncrType() {
        return this.Aia;
    }

    public final void setEditTextSize(float f) {
        AppMethodBeat.i(49394);
        if (this.AhX != null) {
            this.AhX.setTextSize(f);
        }
        AppMethodBeat.o(49394);
    }

    public final void setEditTextMaxLength(int i) {
        AppMethodBeat.i(49395);
        if (this.AhX != null) {
            InputFilter[] filters = this.AhX.getFilters();
            InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
            for (int i2 = 0; i2 < filters.length; i2++) {
                inputFilterArr[i2] = filters[i2];
            }
            inputFilterArr[inputFilterArr.length - 1] = new LengthFilter(i);
            this.AhX.setFilters(inputFilterArr);
        }
        AppMethodBeat.o(49395);
    }

    public final String getText() {
        AppMethodBeat.i(49396);
        String a;
        if (this.AhX != null) {
            a = com.tencent.mm.wallet_core.ui.formview.c.a.a(this.Aia, this.AhX);
            AppMethodBeat.o(49396);
            return a;
        }
        ab.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
        a = "";
        AppMethodBeat.o(49396);
        return a;
    }

    public final void cey() {
        AppMethodBeat.i(49397);
        if (this.AhX != null) {
            this.AhX.ClearInput();
        }
        AppMethodBeat.o(49397);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(49398);
        setMeasuredDimension(getDefaultSize(b.b(getContext(), 960.0f), i), getDefaultSize(b.b(getContext(), 720.0f), i2));
        int measuredWidth = getMeasuredWidth();
        int i3 = this.AhY == 0 ? measuredWidth / 6 : measuredWidth / this.AhY;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, ErrorDialogData.SUPPRESSED);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED);
        setMeasuredDimension(getDefaultSize(measuredWidth, makeMeasureSpec), getDefaultSize(i3, makeMeasureSpec2));
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
        AppMethodBeat.o(49398);
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(49399);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        if (this.Aib != null) {
            this.Aib.hY(asa());
        }
        AppMethodBeat.o(49399);
    }

    public final int getFormat() {
        return this.sZx;
    }
}
