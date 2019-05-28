package com.tencent.p177mm.wallet_core.p650ui.formview;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.wxpay.C23226a.C23227a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.wallet_core.p650ui.formview.C46725c.C30899a;
import com.tenpay.android.wechat.TenpaySecureEditText;

/* renamed from: com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView */
public final class EditHintPasswdView extends RelativeLayout implements OnFocusChangeListener {
    private static final int AhW = C25738R.drawable.f6670lw;
    private TenpaySecureEditText AhX;
    private int AhY;
    private int AhZ;
    private int Aia;
    private C30883a Aib;
    private OnFocusChangeListener gJD;
    private int sZx;

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView$a */
    public interface C30883a {
        /* renamed from: hY */
        void mo9438hY(boolean z);
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView$1 */
    class C308841 implements TextWatcher {
        C308841() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(49389);
            if (EditHintPasswdView.this.Aib != null) {
                EditHintPasswdView.this.Aib.mo9438hY(EditHintPasswdView.m49285c(EditHintPasswdView.this));
            }
            AppMethodBeat.m2505o(49389);
        }
    }

    /* renamed from: c */
    static /* synthetic */ boolean m49285c(EditHintPasswdView editHintPasswdView) {
        AppMethodBeat.m2504i(49400);
        boolean asa = editHintPasswdView.asa();
        AppMethodBeat.m2505o(49400);
        return asa;
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(49390);
        this.AhX = null;
        this.AhY = 6;
        this.sZx = 1;
        this.AhZ = AhW;
        this.Aia = 1;
        this.Aib = null;
        this.gJD = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C23227a.PwdAttr, i, 0);
        this.sZx = obtainStyledAttributes.getInteger(0, 1);
        this.AhZ = obtainStyledAttributes.getResourceId(1, AhW);
        this.Aia = obtainStyledAttributes.getInteger(2, 1);
        obtainStyledAttributes.recycle();
        this.AhX = (TenpaySecureEditText) C5616v.m8409hu(context).inflate(2130969819, this, true).findViewById(2131820687);
        C40950b.m71012a(this.AhX, this.sZx);
        this.AhY = getNumberSize();
        if (this.AhX != null) {
            this.AhX.setBackgroundResource(this.AhZ);
            this.AhX.setImeOptions(6);
            this.AhX.setInputType(128);
            this.AhX.addTextChangedListener(new C308841());
            this.AhX.setOnFocusChangeListener(this);
            this.AhX.setClickable(false);
            this.AhX.setLongClickable(false);
            super.setEnabled(true);
            super.setClickable(true);
            AppMethodBeat.m2505o(49390);
            return;
        }
        C4990ab.m7412e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
        AppMethodBeat.m2505o(49390);
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final String getMd5Value() {
        AppMethodBeat.m2504i(49391);
        String ck;
        if (this.AhX != null) {
            ck = C4995ag.m7428ck(this.AhX.getText().toString());
            AppMethodBeat.m2505o(49391);
            return ck;
        }
        C4990ab.m7420w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
        ck = "";
        AppMethodBeat.m2505o(49391);
        return ck;
    }

    private boolean asa() {
        AppMethodBeat.m2504i(49392);
        if (this.AhX == null || this.AhX.getInputLength() != this.AhY) {
            AppMethodBeat.m2505o(49392);
            return false;
        }
        AppMethodBeat.m2505o(49392);
        return true;
    }

    private int getNumberSize() {
        AppMethodBeat.m2504i(49393);
        switch (this.sZx) {
            case 1:
                AppMethodBeat.m2505o(49393);
                return 6;
            case 3:
                AppMethodBeat.m2505o(49393);
                return 3;
            case 4:
                AppMethodBeat.m2505o(49393);
                return 4;
            case 8:
                AppMethodBeat.m2505o(49393);
                return 4;
            default:
                C4990ab.m7416i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
                AppMethodBeat.m2505o(49393);
                return 6;
        }
    }

    public final void setOnInputValidListener(C30883a c30883a) {
        this.Aib = c30883a;
    }

    public final C30883a getOnEditInputValidListener() {
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
        AppMethodBeat.m2504i(49394);
        if (this.AhX != null) {
            this.AhX.setTextSize(f);
        }
        AppMethodBeat.m2505o(49394);
    }

    public final void setEditTextMaxLength(int i) {
        AppMethodBeat.m2504i(49395);
        if (this.AhX != null) {
            InputFilter[] filters = this.AhX.getFilters();
            InputFilter[] inputFilterArr = new InputFilter[(filters.length + 1)];
            for (int i2 = 0; i2 < filters.length; i2++) {
                inputFilterArr[i2] = filters[i2];
            }
            inputFilterArr[inputFilterArr.length - 1] = new LengthFilter(i);
            this.AhX.setFilters(inputFilterArr);
        }
        AppMethodBeat.m2505o(49395);
    }

    public final String getText() {
        AppMethodBeat.m2504i(49396);
        String a;
        if (this.AhX != null) {
            a = C30899a.m49314a(this.Aia, this.AhX);
            AppMethodBeat.m2505o(49396);
            return a;
        }
        C4990ab.m7420w("MicroMsg.EditHintPasswdView", "hy: no edit view");
        a = "";
        AppMethodBeat.m2505o(49396);
        return a;
    }

    public final void cey() {
        AppMethodBeat.m2504i(49397);
        if (this.AhX != null) {
            this.AhX.ClearInput();
        }
        AppMethodBeat.m2505o(49397);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(49398);
        setMeasuredDimension(EditHintPasswdView.getDefaultSize(C4977b.m7371b(getContext(), 960.0f), i), EditHintPasswdView.getDefaultSize(C4977b.m7371b(getContext(), 720.0f), i2));
        int measuredWidth = getMeasuredWidth();
        int i3 = this.AhY == 0 ? measuredWidth / 6 : measuredWidth / this.AhY;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, ErrorDialogData.SUPPRESSED);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED);
        setMeasuredDimension(EditHintPasswdView.getDefaultSize(measuredWidth, makeMeasureSpec), EditHintPasswdView.getDefaultSize(i3, makeMeasureSpec2));
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
        AppMethodBeat.m2505o(49398);
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.m2504i(49399);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        if (this.Aib != null) {
            this.Aib.mo9438hY(asa());
        }
        AppMethodBeat.m2505o(49399);
    }

    public final int getFormat() {
        return this.sZx;
    }
}
