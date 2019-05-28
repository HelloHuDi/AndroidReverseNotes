package com.tencent.p177mm.wallet_core.p650ui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.C30801e;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.wxpay.C23226a.C23227a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C46719b;
import com.tencent.p177mm.wallet_core.p1348a.C24142a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
/* renamed from: com.tencent.mm.wallet_core.ui.EditHintView */
public class EditHintView extends RelativeLayout implements OnFocusChangeListener {
    private C5753b AgV;
    private TextView AgW;
    TenpaySecureEditText AgX;
    private int AgY;
    private int AgZ;
    private int Aha;
    private boolean Ahb;
    private String Ahc;
    private DatePickerDialog Ahd;
    private int Ahe;
    private int Ahf;
    private C5653c Ahg;
    private C5752a Ahh;
    private int background;
    private OnFocusChangeListener gJD;
    private TextView gJE;
    private ImageView gJG;
    private String gJH;
    private String gJI;
    private int gJJ;
    private int gJK;
    public boolean gJL;
    private boolean gJN;
    private int gJO;
    private int gJP;
    private OnClickListener gJR;
    private int gravity;
    private boolean hNO;
    private int imeOptions;
    private int inputType;
    private int mode;
    public boolean yCj;

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$8 */
    class C57508 implements OnClickListener {
        C57508() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49185);
            if (EditHintView.this.gJG.getVisibility() == 0) {
                if (EditHintView.this.gJL && !C5046bo.isNullOrNil(EditHintView.this.getText())) {
                    EditHintView.this.AgX.ClearInput();
                    AppMethodBeat.m2505o(49185);
                    return;
                } else if (EditHintView.this.gJJ != 1) {
                    EditHintView.m80363o(EditHintView.this);
                } else if (EditHintView.this.Ahh != null && EditHintView.this.Ahb) {
                    EditHintView.this.Ahh;
                    AppMethodBeat.m2505o(49185);
                    return;
                }
            }
            AppMethodBeat.m2505o(49185);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$9 */
    class C57519 implements DialogInterface.OnClickListener {
        C57519() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(49186);
            EditHintView.this.Ahg.dismiss();
            AppMethodBeat.m2505o(49186);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$a */
    public interface C5752a {
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$b */
    public interface C5753b {
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$6 */
    class C160906 extends NumberKeyListener {
        C160906() {
        }

        public final int getInputType() {
            return 1;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$7 */
    class C160917 implements OnClickListener {

        /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$7$1 */
        class C160921 implements OnDateSetListener {
            C160921() {
            }

            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AppMethodBeat.m2504i(49183);
                if (i >= EditHintView.this.Ahe || i2 >= EditHintView.this.Ahf) {
                    DecimalFormat decimalFormat = new DecimalFormat("00");
                    if (C1853r.m3831YM()) {
                        EditHintView.this.Ahc = decimalFormat.format((long) (i2 + 1)) + i;
                    } else {
                        EditHintView.this.Ahc = decimalFormat.format((long) i).substring(2) + decimalFormat.format((long) (i2 + 1));
                    }
                    EditHintView.this.AgX.setText(decimalFormat.format((long) (i2 + 1)) + decimalFormat.format((long) i).substring(2));
                } else {
                    C30379h.m48461b(EditHintView.this.getContext(), EditHintView.this.getContext().getString(C25738R.string.fel), null, true);
                }
                EditHintView.this.gJN = EditHintView.this.asa();
                if (EditHintView.this.AgV != null) {
                    C4990ab.m7410d("MicroMsg.EditHintView", "View:" + EditHintView.this.gJI + ", editType:" + EditHintView.this.gJJ + " inputValid change to " + EditHintView.this.gJN);
                    EditHintView.this.AgV;
                    EditHintView.this.gJN;
                }
                AppMethodBeat.m2505o(49183);
            }
        }

        C160917() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49184);
            if (EditHintView.this.Ahd == null) {
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(System.currentTimeMillis());
                instance.add(2, 1);
                EditHintView.this.Ahe = instance.get(1);
                EditHintView.this.Ahf = instance.get(2);
                EditHintView.this.Ahd = new C30801e(EditHintView.this.getContext(), new C160921(), EditHintView.this.Ahe, EditHintView.this.Ahf, instance.get(5), instance.getTimeInMillis());
            }
            EditHintView.this.Ahd.show();
            AppMethodBeat.m2505o(49184);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$1 */
    class C308761 implements TextWatcher {
        C308761() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(49181);
            if (EditHintView.this.mode == 4 && EditHintView.this.asa()) {
                EditHintView.this.mode = 0;
                EditHintView.this.AgX.ClearInput();
            }
            AppMethodBeat.m2505o(49181);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(49182);
            boolean asa = EditHintView.this.asa();
            if (!(asa == EditHintView.this.gJN || EditHintView.this.AgV == null)) {
                C4990ab.m7410d("MicroMsg.EditHintView", "View:" + EditHintView.this.gJI + ", editType:" + EditHintView.this.gJJ + " inputValid change to " + asa);
                EditHintView.this.gJN = asa;
                EditHintView.this.AgV;
                EditHintView.this.gJN;
            }
            EditHintView.m80355g(EditHintView.this);
            AppMethodBeat.m2505o(49182);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$5 */
    class C363865 extends NumberKeyListener {
        C363865() {
        }

        public final int getInputType() {
            return 3;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$2 */
    class C409452 extends NumberKeyListener {
        C409452() {
        }

        public final int getInputType() {
            return 3;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$4 */
    class C409464 extends NumberKeyListener {
        C409464() {
        }

        public final int getInputType() {
            return 18;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.EditHintView$3 */
    class C444333 extends NumberKeyListener {
        C444333() {
        }

        public final int getInputType() {
            return 1;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m80355g(EditHintView editHintView) {
        AppMethodBeat.m2504i(49219);
        editHintView.dOu();
        AppMethodBeat.m2505o(49219);
    }

    public EditHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(49187);
        this.gJH = "";
        this.gJI = "";
        this.inputType = 1;
        this.hNO = true;
        this.gJP = -1;
        this.gJO = 1;
        this.gravity = 19;
        this.AgY = -1;
        this.gJJ = -1;
        this.gJN = false;
        this.AgZ = 1;
        this.Aha = -1;
        this.background = -1;
        this.gJK = -1;
        this.gJL = true;
        this.yCj = true;
        this.Ahb = true;
        this.Ahc = null;
        this.mode = 0;
        this.Ahd = null;
        this.Ahe = 0;
        this.Ahf = 0;
        this.gJR = new C57508();
        this.Ahg = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C23227a.EditHintView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.gJH = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId != 0) {
            this.gJI = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(4, 1);
        this.gJL = obtainStyledAttributes.getBoolean(11, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.hNO = obtainStyledAttributes.getBoolean(2, true);
        this.gJP = obtainStyledAttributes.getInteger(12, -1);
        this.gJJ = obtainStyledAttributes.getInteger(8, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(5, 5);
        this.Aha = obtainStyledAttributes.getColor(9, C25738R.color.f11782h4);
        this.background = obtainStyledAttributes.getResourceId(1, -1);
        this.gJK = obtainStyledAttributes.getResourceId(10, C25738R.drawable.f6671lx);
        this.gJO = obtainStyledAttributes.getInteger(13, 1);
        this.yCj = obtainStyledAttributes.getBoolean(3, true);
        obtainStyledAttributes.recycle();
        View inflate = C5616v.m8409hu(context).inflate(2130969315, this, true);
        this.AgX = (TenpaySecureEditText) inflate.findViewById(2131821052);
        this.gJE = (TextView) inflate.findViewById(2131821051);
        this.AgW = (TextView) inflate.findViewById(2131823383);
        this.gJG = (ImageView) inflate.findViewById(2131821053);
        this.AgX.setImeOptions(this.imeOptions);
        switch (this.gJJ) {
            case 0:
                break;
            case 1:
                this.gJP = 25;
                this.AgX.setIsBankcardFormat(true);
                this.inputType = 2;
                break;
            case 2:
            case 9:
                this.gJP = 30;
                this.inputType = 3;
                break;
            case 3:
                this.gJL = false;
                this.AgX.setIsValidThru(true);
                setOnClickListener(new C160917());
                break;
            case 4:
                this.gJP = 4;
                this.inputType = 2;
                break;
            case 5:
                this.gJP = 18;
                this.inputType = 4;
                break;
            case 6:
                this.gJP = 6;
                this.gJE.setVisibility(8);
                this.inputType = 2;
                break;
            case 7:
            case 17:
                this.gJP = 6;
                this.gJE.setVisibility(8);
                this.AgX.setIsPasswordFormat(true);
                this.AgX.setImeOptions(6);
                this.inputType = 128;
                break;
            case 8:
                this.inputType = 32;
                break;
            case 10:
                if (this.gJL || this.hNO) {
                }
            case 12:
                this.gJP = 12;
                this.AgX.setIsMoneyAmountFormat(true);
                break;
            case 13:
            case 16:
                this.AgX.setIsSecurityAnswerFormat(true);
                break;
            case 14:
                this.gJP = 3;
                this.gJE.setVisibility(8);
                this.AgX.setIsCvvPaymentFormat(true);
                this.AgX.setImeOptions(6);
                this.inputType = 128;
                break;
            case 15:
                this.gJP = 4;
                this.gJE.setVisibility(8);
                this.AgX.setIsCvv4PaymentFormat(true);
                this.AgX.setImeOptions(6);
                this.inputType = 128;
                break;
            default:
                this.inputType = 1;
                break;
        }
        dOu();
        this.AgX.setSingleLine(this.yCj);
        if (!this.yCj) {
            this.AgX.setMaxLines(1073741823);
        }
        this.gJG.setOnClickListener(this.gJR);
        this.AgX.addTextChangedListener(new C308761());
        this.AgX.setOnFocusChangeListener(this);
        if (!C5046bo.isNullOrNil(this.gJH)) {
            this.AgX.setHint(this.gJH);
        }
        if (!C5046bo.isNullOrNil(this.gJI)) {
            this.gJE.setText(this.gJI);
        }
        this.AgX.setGravity(this.gravity);
        if (this.inputType == 2) {
            this.AgX.setKeyListener(new C409452());
        } else if (this.inputType == 4) {
            this.AgX.setKeyListener(new C444333());
        } else if (this.inputType == 128) {
            this.AgX.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.AgX.setKeyListener(new C409464());
            this.AgX.setRawInputType(18);
        } else if (this.inputType == 3) {
            this.AgX.setKeyListener(new C363865());
        } else {
            this.AgX.setInputType(this.inputType);
        }
        if (this.gJP != -1) {
            this.AgX.setFilters(new InputFilter[]{new LengthFilter(this.gJP)});
        }
        super.setEnabled(true);
        super.setClickable(true);
        if (!this.hNO) {
            this.AgX.setEnabled(false);
            this.AgX.setTextColor(getResources().getColor(this.Aha));
            this.AgX.setFocusable(false);
            this.AgX.setClickable(false);
            this.AgX.setBackgroundResource(C25738R.drawable.a8g);
            setBackgroundResource(C25738R.drawable.a_q);
        }
        if (this.gJL) {
            this.gJN = false;
            this.AgX.setBackgroundResource(this.gJK);
            setBackgroundResource(C25738R.drawable.a8g);
        } else {
            this.gJN = true;
            this.AgX.setEnabled(false);
            this.AgX.setTextColor(getResources().getColor(C25738R.color.f12124t8));
            this.AgX.setFocusable(false);
            this.AgX.setClickable(false);
            this.AgX.setBackgroundResource(C25738R.drawable.a8g);
            setBackgroundResource(C25738R.drawable.f6623k5);
        }
        if (this.background > 0) {
            setBackgroundResource(this.background);
        }
        if (!(this.gJE == null || this.AgY == -1)) {
            LayoutParams layoutParams = this.gJE.getLayoutParams();
            layoutParams.width = this.AgY;
            this.gJE.setLayoutParams(layoutParams);
        }
        if (C1853r.m3831YM()) {
            this.AgX.setSecureEncrypt(new C24142a(getEncryptType()));
        }
        AppMethodBeat.m2505o(49187);
    }

    public EditHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(C5753b c5753b) {
        this.AgV = c5753b;
    }

    public void setTipWidth(int i) {
        AppMethodBeat.m2504i(49188);
        this.AgY = C4977b.m7371b(getContext(), ((float) i) * 1.0f);
        if (this.gJE != null) {
            LayoutParams layoutParams = this.gJE.getLayoutParams();
            layoutParams.width = this.AgY;
            this.gJE.setLayoutParams(layoutParams);
        }
        AppMethodBeat.m2505o(49188);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(49189);
        if (this.gJJ == 7 || this.gJJ == 17 || this.gJJ == 14 || this.gJJ == 15) {
            int i3;
            setMeasuredDimension(EditHintView.getDefaultSize(C4977b.m7371b(getContext(), 960.0f), i), EditHintView.getDefaultSize(C4977b.m7371b(getContext(), 720.0f), i2));
            int measuredWidth = getMeasuredWidth();
            if (this.gJJ == 7 || this.gJJ == 17) {
                i3 = measuredWidth / 6;
            } else if (this.gJJ == 14) {
                i3 = measuredWidth / 3;
            } else {
                i3 = measuredWidth / 4;
            }
            i = MeasureSpec.makeMeasureSpec(measuredWidth, ErrorDialogData.SUPPRESSED);
            i2 = MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED);
            setMeasuredDimension(EditHintView.getDefaultSize(measuredWidth, i), EditHintView.getDefaultSize(i3, i2));
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(49189);
    }

    public void setHintStr(String str) {
        AppMethodBeat.m2504i(49190);
        this.AgX.setHint(str);
        AppMethodBeat.m2505o(49190);
    }

    public void setTipStr(String str) {
        AppMethodBeat.m2504i(49191);
        this.gJE.setText(str);
        AppMethodBeat.m2505o(49191);
    }

    public void setPreFilledStr(String str) {
        AppMethodBeat.m2504i(49192);
        if (C5046bo.isNullOrNil(str)) {
            this.AgW.setText("");
            this.AgW.setVisibility(8);
            AppMethodBeat.m2505o(49192);
            return;
        }
        this.AgW.setText(str);
        this.AgW.setVisibility(0);
        AppMethodBeat.m2505o(49192);
    }

    public void setValStr(String str) {
        AppMethodBeat.m2504i(49193);
        switch (this.gJJ) {
            case 1:
                if (C5046bo.isNullOrNil(str) || str.length() > 5) {
                    this.AgX.setText(str);
                    this.AgX.setSelection(this.AgX.getText().length());
                    AppMethodBeat.m2505o(49193);
                    return;
                }
                this.AgX.setSelection(0);
                this.AgX.setBankcardTailNum(str);
                this.gJP = 24 - str.length();
                this.AgX.setFilters(new InputFilter[]{new LengthFilter(this.gJP)});
                AppMethodBeat.m2505o(49193);
                return;
            default:
                this.AgX.setText(str);
                this.AgX.setSelection(this.AgX.getText().length());
                AppMethodBeat.m2505o(49193);
                return;
        }
    }

    public void set3DesValStr(String str) {
        AppMethodBeat.m2504i(49194);
        switch (this.gJJ) {
            case 1:
                if (C5046bo.isNullOrNil(str) || str.length() > 5) {
                    this.AgX.set3DesEncrptData(str);
                    this.AgX.setSelection(this.AgX.getText().length());
                    AppMethodBeat.m2505o(49194);
                    return;
                }
                this.AgX.setSelection(0);
                this.AgX.set3DesEncrptData(str);
                this.gJP = 24 - str.length();
                this.AgX.setFilters(new InputFilter[]{new LengthFilter(this.gJP)});
                AppMethodBeat.m2505o(49194);
                return;
            default:
                this.AgX.setText(str);
                this.AgX.setSelection(this.AgX.getText().length());
                AppMethodBeat.m2505o(49194);
                return;
        }
    }

    private void setValStrForce(String str) {
        AppMethodBeat.m2504i(49195);
        KeyListener keyListener = this.AgX.getKeyListener();
        this.AgX.setKeyListener(null);
        setEnabled(false);
        setClickable(false);
        setValStr(str);
        this.AgX.setKeyListener(keyListener);
        AppMethodBeat.m2505o(49195);
    }

    public void setPreText(String str) {
        AppMethodBeat.m2504i(49196);
        KeyListener keyListener = this.AgX.getKeyListener();
        this.AgX.setInputType(1);
        this.AgX.setKeyListener(null);
        setValStr(str);
        this.AgX.setKeyListener(keyListener);
        this.mode = 4;
        AppMethodBeat.m2505o(49196);
    }

    public void setEditBG(int i) {
        AppMethodBeat.m2504i(49197);
        if (this.AgX != null) {
            this.AgX.setBackgroundResource(i);
        }
        AppMethodBeat.m2505o(49197);
    }

    public void setEncryptType(int i) {
        AppMethodBeat.m2504i(49198);
        if (C1853r.m3831YM()) {
            this.AgX.setSecureEncrypt(new C24142a(i));
        }
        AppMethodBeat.m2505o(49198);
    }

    public void setTipTextColor(int i) {
        AppMethodBeat.m2504i(49199);
        if (this.gJE != null) {
            this.gJE.setTextColor(i);
        }
        AppMethodBeat.m2505o(49199);
    }

    public void setMaxLen(int i) {
        AppMethodBeat.m2504i(49200);
        if (i != -1) {
            this.gJP = i;
            this.AgX.setFilters(new InputFilter[]{new LengthFilter(i)});
        }
        AppMethodBeat.m2505o(49200);
    }

    public void setIdentifyCardType(int i) {
        AppMethodBeat.m2504i(49201);
        this.AgZ = i;
        if (i == 1) {
            this.AgX.setKeyListener(new C160906());
            AppMethodBeat.m2505o(49201);
            return;
        }
        this.AgX.setInputType(1);
        AppMethodBeat.m2505o(49201);
    }

    public String getText() {
        AppMethodBeat.m2504i(49202);
        String bc;
        TenpaySecureEditText tenpaySecureEditText;
        switch (this.gJJ) {
            case 0:
            case 8:
            case 10:
                bc = C5046bo.m7532bc(this.AgX.getText().toString(), "");
                AppMethodBeat.m2505o(49202);
                return bc;
            case 1:
            case 13:
            case 16:
                tenpaySecureEditText = this.AgX;
                C46719b.dNA();
                bc = tenpaySecureEditText.getEncryptDataWithHash(false, C46719b.dNB());
                AppMethodBeat.m2505o(49202);
                return bc;
            case 2:
            case 9:
                bc = C5046bo.m7532bc(this.AgX.getText().toString(), "");
                AppMethodBeat.m2505o(49202);
                return bc;
            case 3:
                bc = C5046bo.m7532bc(this.Ahc, "").replace("/", "");
                AppMethodBeat.m2505o(49202);
                return bc;
            case 4:
            case 14:
            case 15:
                bc = this.AgX.get3DesEncrptData();
                AppMethodBeat.m2505o(49202);
                return bc;
            case 5:
                bc = this.AgX.get3DesEncrptData();
                AppMethodBeat.m2505o(49202);
                return bc;
            case 6:
                bc = this.AgX.get3DesVerifyCode();
                AppMethodBeat.m2505o(49202);
                return bc;
            case 7:
                tenpaySecureEditText = this.AgX;
                C46719b.dNA();
                bc = tenpaySecureEditText.getEncryptDataWithHash(true, C46719b.dNB());
                AppMethodBeat.m2505o(49202);
                return bc;
            default:
                bc = C5046bo.m7532bc(this.AgX.getText().toString(), "");
                AppMethodBeat.m2505o(49202);
                return bc;
        }
    }

    public String getMD5Value() {
        String replace;
        AppMethodBeat.m2504i(49203);
        if (this.gJJ == 3) {
            replace = C5046bo.m7532bc(this.Ahc, "").replace("/", "");
        } else {
            replace = this.AgX.getText().toString();
        }
        replace = C4995ag.m7428ck(replace);
        AppMethodBeat.m2505o(49203);
        return replace;
    }

    public final boolean asa() {
        AppMethodBeat.m2504i(49204);
        if (this.gJL || this.hNO) {
            boolean isBankcardNum;
            switch (this.gJJ) {
                case 1:
                    isBankcardNum = this.AgX.isBankcardNum();
                    AppMethodBeat.m2505o(49204);
                    return isBankcardNum;
                case 4:
                    if (this.AgX.getInputLength() > 0) {
                        AppMethodBeat.m2505o(49204);
                        return true;
                    }
                    AppMethodBeat.m2505o(49204);
                    return false;
                case 5:
                    isBankcardNum = this.AgX.isAreaIDCardNum(this.AgZ);
                    AppMethodBeat.m2505o(49204);
                    return isBankcardNum;
                case 7:
                case 17:
                    if (this.AgX.getInputLength() == 6) {
                        AppMethodBeat.m2505o(49204);
                        return true;
                    }
                    AppMethodBeat.m2505o(49204);
                    return false;
                case 8:
                    isBankcardNum = C5046bo.amW(this.AgX.getText().toString());
                    AppMethodBeat.m2505o(49204);
                    return isBankcardNum;
                case 9:
                    isBankcardNum = this.AgX.isPhoneNum();
                    AppMethodBeat.m2505o(49204);
                    return isBankcardNum;
                case 12:
                    isBankcardNum = this.AgX.isMoneyAmount();
                    AppMethodBeat.m2505o(49204);
                    return isBankcardNum;
                case 14:
                    if (this.AgX.getInputLength() == 3) {
                        AppMethodBeat.m2505o(49204);
                        return true;
                    }
                    AppMethodBeat.m2505o(49204);
                    return false;
                case 15:
                    if (this.AgX.getInputLength() == 4) {
                        AppMethodBeat.m2505o(49204);
                        return true;
                    }
                    AppMethodBeat.m2505o(49204);
                    return false;
                default:
                    if (this.AgX.getInputLength() >= this.gJO) {
                        AppMethodBeat.m2505o(49204);
                        return true;
                    }
                    AppMethodBeat.m2505o(49204);
                    return false;
            }
        }
        AppMethodBeat.m2505o(49204);
        return true;
    }

    public String get3DesEncrptData() {
        AppMethodBeat.m2504i(49205);
        String str = this.AgX.get3DesEncrptData();
        AppMethodBeat.m2505o(49205);
        return str;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.m2504i(49206);
        this.AgX.setEllipsize(truncateAt);
        AppMethodBeat.m2505o(49206);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.m2504i(49207);
        super.setEnabled(z);
        this.gJL = z;
        this.gJG.setEnabled(true);
        AppMethodBeat.m2505o(49207);
    }

    public void setClickable(boolean z) {
        AppMethodBeat.m2504i(49208);
        super.setClickable(z);
        this.hNO = z;
        if (z) {
            this.AgX.setEnabled(true);
            if (this.gJL) {
                this.AgX.setTextColor(getResources().getColor(this.Aha));
            } else {
                this.AgX.setTextColor(getResources().getColor(C25738R.color.f12124t8));
            }
            this.AgX.setFocusable(true);
            this.AgX.setClickable(true);
            AppMethodBeat.m2505o(49208);
            return;
        }
        this.AgX.setEnabled(false);
        if (this.gJL) {
            this.AgX.setTextColor(getResources().getColor(this.Aha));
        } else {
            this.AgX.setTextColor(getResources().getColor(C25738R.color.f12121t4));
        }
        this.AgX.setFocusable(false);
        this.AgX.setClickable(false);
        AppMethodBeat.m2505o(49208);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(49209);
        if (!this.gJL) {
            boolean z;
            if (this.gJG.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            z = z ? getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY()) : false;
            if (!z) {
                AppMethodBeat.m2505o(49209);
                return true;
            }
        }
        AppMethodBeat.m2505o(49209);
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(49210);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(49210);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.m2504i(49211);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.gJD = onFocusChangeListener;
        AppMethodBeat.m2505o(49211);
    }

    private void dOu() {
        AppMethodBeat.m2504i(49212);
        if (this.gJJ == 7 || this.gJJ == 14 || this.gJJ == 15) {
            AppMethodBeat.m2505o(49212);
        } else if (!this.gJL || C5046bo.isNullOrNil(getText())) {
            switch (this.gJJ) {
                case 1:
                    if (this.Ahb) {
                        this.gJG.setVisibility(0);
                        this.gJG.setImageResource(C1318a.wallet_scan_camera);
                        AppMethodBeat.m2505o(49212);
                        return;
                    }
                    this.gJG.setVisibility(8);
                    AppMethodBeat.m2505o(49212);
                    return;
                case 3:
                case 4:
                case 9:
                case 10:
                    this.gJG.setVisibility(0);
                    this.gJG.setImageResource(C25738R.drawable.akp);
                    AppMethodBeat.m2505o(49212);
                    return;
                default:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.m2505o(49212);
                    return;
            }
        } else {
            this.gJG.setVisibility(0);
            this.gJG.setImageResource(C25738R.drawable.f6801r8);
            AppMethodBeat.m2505o(49212);
        }
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.m2504i(49213);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        C4990ab.m7410d("MicroMsg.EditHintView", "View:" + this.gJI + ", editType:" + this.gJJ + " onFocusChange to " + z);
        if (this.gJN) {
            this.gJE.setEnabled(true);
            AppMethodBeat.m2505o(49213);
            return;
        }
        this.gJE.setEnabled(false);
        AppMethodBeat.m2505o(49213);
    }

    public void setImeOptions(int i) {
        AppMethodBeat.m2504i(49214);
        this.AgX.setImeOptions(i);
        AppMethodBeat.m2505o(49214);
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.m2504i(49215);
        this.AgX.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.m2505o(49215);
    }

    public void setInfoIvVisible(int i) {
        AppMethodBeat.m2504i(49216);
        this.gJG.setVisibility(i);
        AppMethodBeat.m2505o(49216);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.m2504i(49217);
        Rect rect = new Rect();
        this.gJG.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.m2505o(49217);
        return rect;
    }

    public void setOnInfoListener(C5752a c5752a) {
        this.Ahh = c5752a;
    }

    public void setShowScanCamera(boolean z) {
        AppMethodBeat.m2504i(49218);
        this.Ahb = z;
        dOu();
        AppMethodBeat.m2505o(49218);
    }

    private int getEncryptType() {
        switch (this.gJJ) {
            case 1:
                return 50;
            case 4:
            case 14:
            case 15:
                return 30;
            case 6:
                return 60;
            case 7:
                return 20;
            case 13:
                return 40;
            case 16:
                return -20;
            case 17:
                return -10;
            default:
                return 0;
        }
    }

    /* renamed from: o */
    static /* synthetic */ void m80363o(EditHintView editHintView) {
        int dOe;
        AppMethodBeat.m2504i(49220);
        int i = 0;
        switch (editHintView.gJJ) {
            case 3:
                editHintView.getContext();
                dOe = C44423ae.dOe();
                editHintView.getContext();
                i = C44423ae.dOf();
                break;
            case 4:
                editHintView.getContext();
                dOe = C44423ae.dOg();
                i = C25738R.string.b45;
                break;
            case 9:
                dOe = 2130971152;
                i = C25738R.string.fc3;
                break;
            case 10:
                dOe = 2130971125;
                i = C25738R.string.fbu;
                break;
            default:
                dOe = -1;
                break;
        }
        if (dOe != -1) {
            if (editHintView.Ahg == null) {
                editHintView.Ahg = C36387b.m59970a(editHintView.getContext(), dOe, editHintView.getResources().getString(i), editHintView.getResources().getString(C25738R.string.ffp), new C57519());
            }
            editHintView.Ahg.show();
        }
        AppMethodBeat.m2505o(49220);
    }
}
