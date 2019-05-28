package com.tencent.mm.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.wallet_core.c.ae;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

@Deprecated
public class EditHintView extends RelativeLayout implements OnFocusChangeListener {
    private b AgV;
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
    private c Ahg;
    private a Ahh;
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

    public interface a {
    }

    public interface b {
    }

    static /* synthetic */ void g(EditHintView editHintView) {
        AppMethodBeat.i(49219);
        editHintView.dOu();
        AppMethodBeat.o(49219);
    }

    public EditHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(49187);
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
        this.gJR = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(49185);
                if (EditHintView.this.gJG.getVisibility() == 0) {
                    if (EditHintView.this.gJL && !bo.isNullOrNil(EditHintView.this.getText())) {
                        EditHintView.this.AgX.ClearInput();
                        AppMethodBeat.o(49185);
                        return;
                    } else if (EditHintView.this.gJJ != 1) {
                        EditHintView.o(EditHintView.this);
                    } else if (EditHintView.this.Ahh != null && EditHintView.this.Ahb) {
                        EditHintView.this.Ahh;
                        AppMethodBeat.o(49185);
                        return;
                    }
                }
                AppMethodBeat.o(49185);
            }
        };
        this.Ahg = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.plugin.wxpay.a.a.EditHintView, i, 0);
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
        this.Aha = obtainStyledAttributes.getColor(9, R.color.h4);
        this.background = obtainStyledAttributes.getResourceId(1, -1);
        this.gJK = obtainStyledAttributes.getResourceId(10, R.drawable.lx);
        this.gJO = obtainStyledAttributes.getInteger(13, 1);
        this.yCj = obtainStyledAttributes.getBoolean(3, true);
        obtainStyledAttributes.recycle();
        View inflate = v.hu(context).inflate(R.layout.t8, this, true);
        this.AgX = (TenpaySecureEditText) inflate.findViewById(R.id.n1);
        this.gJE = (TextView) inflate.findViewById(R.id.n0);
        this.AgW = (TextView) inflate.findViewById(R.id.bbq);
        this.gJG = (ImageView) inflate.findViewById(R.id.n2);
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
                setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(49184);
                        if (EditHintView.this.Ahd == null) {
                            Calendar instance = Calendar.getInstance();
                            instance.setTimeInMillis(System.currentTimeMillis());
                            instance.add(2, 1);
                            EditHintView.this.Ahe = instance.get(1);
                            EditHintView.this.Ahf = instance.get(2);
                            EditHintView.this.Ahd = new e(EditHintView.this.getContext(), new OnDateSetListener() {
                                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                                    AppMethodBeat.i(49183);
                                    if (i >= EditHintView.this.Ahe || i2 >= EditHintView.this.Ahf) {
                                        DecimalFormat decimalFormat = new DecimalFormat("00");
                                        if (r.YM()) {
                                            EditHintView.this.Ahc = decimalFormat.format((long) (i2 + 1)) + i;
                                        } else {
                                            EditHintView.this.Ahc = decimalFormat.format((long) i).substring(2) + decimalFormat.format((long) (i2 + 1));
                                        }
                                        EditHintView.this.AgX.setText(decimalFormat.format((long) (i2 + 1)) + decimalFormat.format((long) i).substring(2));
                                    } else {
                                        h.b(EditHintView.this.getContext(), EditHintView.this.getContext().getString(R.string.fel), null, true);
                                    }
                                    EditHintView.this.gJN = EditHintView.this.asa();
                                    if (EditHintView.this.AgV != null) {
                                        ab.d("MicroMsg.EditHintView", "View:" + EditHintView.this.gJI + ", editType:" + EditHintView.this.gJJ + " inputValid change to " + EditHintView.this.gJN);
                                        EditHintView.this.AgV;
                                        EditHintView.this.gJN;
                                    }
                                    AppMethodBeat.o(49183);
                                }
                            }, EditHintView.this.Ahe, EditHintView.this.Ahf, instance.get(5), instance.getTimeInMillis());
                        }
                        EditHintView.this.Ahd.show();
                        AppMethodBeat.o(49184);
                    }
                });
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
        this.AgX.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(49181);
                if (EditHintView.this.mode == 4 && EditHintView.this.asa()) {
                    EditHintView.this.mode = 0;
                    EditHintView.this.AgX.ClearInput();
                }
                AppMethodBeat.o(49181);
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(49182);
                boolean asa = EditHintView.this.asa();
                if (!(asa == EditHintView.this.gJN || EditHintView.this.AgV == null)) {
                    ab.d("MicroMsg.EditHintView", "View:" + EditHintView.this.gJI + ", editType:" + EditHintView.this.gJJ + " inputValid change to " + asa);
                    EditHintView.this.gJN = asa;
                    EditHintView.this.AgV;
                    EditHintView.this.gJN;
                }
                EditHintView.g(EditHintView.this);
                AppMethodBeat.o(49182);
            }
        });
        this.AgX.setOnFocusChangeListener(this);
        if (!bo.isNullOrNil(this.gJH)) {
            this.AgX.setHint(this.gJH);
        }
        if (!bo.isNullOrNil(this.gJI)) {
            this.gJE.setText(this.gJI);
        }
        this.AgX.setGravity(this.gravity);
        if (this.inputType == 2) {
            this.AgX.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 3;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else if (this.inputType == 4) {
            this.AgX.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 1;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                }
            });
        } else if (this.inputType == 128) {
            this.AgX.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.AgX.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 18;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
            this.AgX.setRawInputType(18);
        } else if (this.inputType == 3) {
            this.AgX.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 3;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                }
            });
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
            this.AgX.setBackgroundResource(R.drawable.a8g);
            setBackgroundResource(R.drawable.a_q);
        }
        if (this.gJL) {
            this.gJN = false;
            this.AgX.setBackgroundResource(this.gJK);
            setBackgroundResource(R.drawable.a8g);
        } else {
            this.gJN = true;
            this.AgX.setEnabled(false);
            this.AgX.setTextColor(getResources().getColor(R.color.t8));
            this.AgX.setFocusable(false);
            this.AgX.setClickable(false);
            this.AgX.setBackgroundResource(R.drawable.a8g);
            setBackgroundResource(R.drawable.k5);
        }
        if (this.background > 0) {
            setBackgroundResource(this.background);
        }
        if (!(this.gJE == null || this.AgY == -1)) {
            LayoutParams layoutParams = this.gJE.getLayoutParams();
            layoutParams.width = this.AgY;
            this.gJE.setLayoutParams(layoutParams);
        }
        if (r.YM()) {
            this.AgX.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(getEncryptType()));
        }
        AppMethodBeat.o(49187);
    }

    public EditHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(b bVar) {
        this.AgV = bVar;
    }

    public void setTipWidth(int i) {
        AppMethodBeat.i(49188);
        this.AgY = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(getContext(), ((float) i) * 1.0f);
        if (this.gJE != null) {
            LayoutParams layoutParams = this.gJE.getLayoutParams();
            layoutParams.width = this.AgY;
            this.gJE.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(49188);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(49189);
        if (this.gJJ == 7 || this.gJJ == 17 || this.gJJ == 14 || this.gJJ == 15) {
            int i3;
            setMeasuredDimension(getDefaultSize(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(getContext(), 960.0f), i), getDefaultSize(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(getContext(), 720.0f), i2));
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
            setMeasuredDimension(getDefaultSize(measuredWidth, i), getDefaultSize(i3, i2));
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(49189);
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(49190);
        this.AgX.setHint(str);
        AppMethodBeat.o(49190);
    }

    public void setTipStr(String str) {
        AppMethodBeat.i(49191);
        this.gJE.setText(str);
        AppMethodBeat.o(49191);
    }

    public void setPreFilledStr(String str) {
        AppMethodBeat.i(49192);
        if (bo.isNullOrNil(str)) {
            this.AgW.setText("");
            this.AgW.setVisibility(8);
            AppMethodBeat.o(49192);
            return;
        }
        this.AgW.setText(str);
        this.AgW.setVisibility(0);
        AppMethodBeat.o(49192);
    }

    public void setValStr(String str) {
        AppMethodBeat.i(49193);
        switch (this.gJJ) {
            case 1:
                if (bo.isNullOrNil(str) || str.length() > 5) {
                    this.AgX.setText(str);
                    this.AgX.setSelection(this.AgX.getText().length());
                    AppMethodBeat.o(49193);
                    return;
                }
                this.AgX.setSelection(0);
                this.AgX.setBankcardTailNum(str);
                this.gJP = 24 - str.length();
                this.AgX.setFilters(new InputFilter[]{new LengthFilter(this.gJP)});
                AppMethodBeat.o(49193);
                return;
            default:
                this.AgX.setText(str);
                this.AgX.setSelection(this.AgX.getText().length());
                AppMethodBeat.o(49193);
                return;
        }
    }

    public void set3DesValStr(String str) {
        AppMethodBeat.i(49194);
        switch (this.gJJ) {
            case 1:
                if (bo.isNullOrNil(str) || str.length() > 5) {
                    this.AgX.set3DesEncrptData(str);
                    this.AgX.setSelection(this.AgX.getText().length());
                    AppMethodBeat.o(49194);
                    return;
                }
                this.AgX.setSelection(0);
                this.AgX.set3DesEncrptData(str);
                this.gJP = 24 - str.length();
                this.AgX.setFilters(new InputFilter[]{new LengthFilter(this.gJP)});
                AppMethodBeat.o(49194);
                return;
            default:
                this.AgX.setText(str);
                this.AgX.setSelection(this.AgX.getText().length());
                AppMethodBeat.o(49194);
                return;
        }
    }

    private void setValStrForce(String str) {
        AppMethodBeat.i(49195);
        KeyListener keyListener = this.AgX.getKeyListener();
        this.AgX.setKeyListener(null);
        setEnabled(false);
        setClickable(false);
        setValStr(str);
        this.AgX.setKeyListener(keyListener);
        AppMethodBeat.o(49195);
    }

    public void setPreText(String str) {
        AppMethodBeat.i(49196);
        KeyListener keyListener = this.AgX.getKeyListener();
        this.AgX.setInputType(1);
        this.AgX.setKeyListener(null);
        setValStr(str);
        this.AgX.setKeyListener(keyListener);
        this.mode = 4;
        AppMethodBeat.o(49196);
    }

    public void setEditBG(int i) {
        AppMethodBeat.i(49197);
        if (this.AgX != null) {
            this.AgX.setBackgroundResource(i);
        }
        AppMethodBeat.o(49197);
    }

    public void setEncryptType(int i) {
        AppMethodBeat.i(49198);
        if (r.YM()) {
            this.AgX.setSecureEncrypt(new com.tencent.mm.wallet_core.a.a(i));
        }
        AppMethodBeat.o(49198);
    }

    public void setTipTextColor(int i) {
        AppMethodBeat.i(49199);
        if (this.gJE != null) {
            this.gJE.setTextColor(i);
        }
        AppMethodBeat.o(49199);
    }

    public void setMaxLen(int i) {
        AppMethodBeat.i(49200);
        if (i != -1) {
            this.gJP = i;
            this.AgX.setFilters(new InputFilter[]{new LengthFilter(i)});
        }
        AppMethodBeat.o(49200);
    }

    public void setIdentifyCardType(int i) {
        AppMethodBeat.i(49201);
        this.AgZ = i;
        if (i == 1) {
            this.AgX.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 1;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                }
            });
            AppMethodBeat.o(49201);
            return;
        }
        this.AgX.setInputType(1);
        AppMethodBeat.o(49201);
    }

    public String getText() {
        AppMethodBeat.i(49202);
        String bc;
        TenpaySecureEditText tenpaySecureEditText;
        switch (this.gJJ) {
            case 0:
            case 8:
            case 10:
                bc = bo.bc(this.AgX.getText().toString(), "");
                AppMethodBeat.o(49202);
                return bc;
            case 1:
            case 13:
            case 16:
                tenpaySecureEditText = this.AgX;
                com.tencent.mm.wallet_core.b.dNA();
                bc = tenpaySecureEditText.getEncryptDataWithHash(false, com.tencent.mm.wallet_core.b.dNB());
                AppMethodBeat.o(49202);
                return bc;
            case 2:
            case 9:
                bc = bo.bc(this.AgX.getText().toString(), "");
                AppMethodBeat.o(49202);
                return bc;
            case 3:
                bc = bo.bc(this.Ahc, "").replace("/", "");
                AppMethodBeat.o(49202);
                return bc;
            case 4:
            case 14:
            case 15:
                bc = this.AgX.get3DesEncrptData();
                AppMethodBeat.o(49202);
                return bc;
            case 5:
                bc = this.AgX.get3DesEncrptData();
                AppMethodBeat.o(49202);
                return bc;
            case 6:
                bc = this.AgX.get3DesVerifyCode();
                AppMethodBeat.o(49202);
                return bc;
            case 7:
                tenpaySecureEditText = this.AgX;
                com.tencent.mm.wallet_core.b.dNA();
                bc = tenpaySecureEditText.getEncryptDataWithHash(true, com.tencent.mm.wallet_core.b.dNB());
                AppMethodBeat.o(49202);
                return bc;
            default:
                bc = bo.bc(this.AgX.getText().toString(), "");
                AppMethodBeat.o(49202);
                return bc;
        }
    }

    public String getMD5Value() {
        String replace;
        AppMethodBeat.i(49203);
        if (this.gJJ == 3) {
            replace = bo.bc(this.Ahc, "").replace("/", "");
        } else {
            replace = this.AgX.getText().toString();
        }
        replace = ag.ck(replace);
        AppMethodBeat.o(49203);
        return replace;
    }

    public final boolean asa() {
        AppMethodBeat.i(49204);
        if (this.gJL || this.hNO) {
            boolean isBankcardNum;
            switch (this.gJJ) {
                case 1:
                    isBankcardNum = this.AgX.isBankcardNum();
                    AppMethodBeat.o(49204);
                    return isBankcardNum;
                case 4:
                    if (this.AgX.getInputLength() > 0) {
                        AppMethodBeat.o(49204);
                        return true;
                    }
                    AppMethodBeat.o(49204);
                    return false;
                case 5:
                    isBankcardNum = this.AgX.isAreaIDCardNum(this.AgZ);
                    AppMethodBeat.o(49204);
                    return isBankcardNum;
                case 7:
                case 17:
                    if (this.AgX.getInputLength() == 6) {
                        AppMethodBeat.o(49204);
                        return true;
                    }
                    AppMethodBeat.o(49204);
                    return false;
                case 8:
                    isBankcardNum = bo.amW(this.AgX.getText().toString());
                    AppMethodBeat.o(49204);
                    return isBankcardNum;
                case 9:
                    isBankcardNum = this.AgX.isPhoneNum();
                    AppMethodBeat.o(49204);
                    return isBankcardNum;
                case 12:
                    isBankcardNum = this.AgX.isMoneyAmount();
                    AppMethodBeat.o(49204);
                    return isBankcardNum;
                case 14:
                    if (this.AgX.getInputLength() == 3) {
                        AppMethodBeat.o(49204);
                        return true;
                    }
                    AppMethodBeat.o(49204);
                    return false;
                case 15:
                    if (this.AgX.getInputLength() == 4) {
                        AppMethodBeat.o(49204);
                        return true;
                    }
                    AppMethodBeat.o(49204);
                    return false;
                default:
                    if (this.AgX.getInputLength() >= this.gJO) {
                        AppMethodBeat.o(49204);
                        return true;
                    }
                    AppMethodBeat.o(49204);
                    return false;
            }
        }
        AppMethodBeat.o(49204);
        return true;
    }

    public String get3DesEncrptData() {
        AppMethodBeat.i(49205);
        String str = this.AgX.get3DesEncrptData();
        AppMethodBeat.o(49205);
        return str;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.i(49206);
        this.AgX.setEllipsize(truncateAt);
        AppMethodBeat.o(49206);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(49207);
        super.setEnabled(z);
        this.gJL = z;
        this.gJG.setEnabled(true);
        AppMethodBeat.o(49207);
    }

    public void setClickable(boolean z) {
        AppMethodBeat.i(49208);
        super.setClickable(z);
        this.hNO = z;
        if (z) {
            this.AgX.setEnabled(true);
            if (this.gJL) {
                this.AgX.setTextColor(getResources().getColor(this.Aha));
            } else {
                this.AgX.setTextColor(getResources().getColor(R.color.t8));
            }
            this.AgX.setFocusable(true);
            this.AgX.setClickable(true);
            AppMethodBeat.o(49208);
            return;
        }
        this.AgX.setEnabled(false);
        if (this.gJL) {
            this.AgX.setTextColor(getResources().getColor(this.Aha));
        } else {
            this.AgX.setTextColor(getResources().getColor(R.color.t4));
        }
        this.AgX.setFocusable(false);
        this.AgX.setClickable(false);
        AppMethodBeat.o(49208);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(49209);
        if (!this.gJL) {
            boolean z;
            if (this.gJG.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            z = z ? getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY()) : false;
            if (!z) {
                AppMethodBeat.o(49209);
                return true;
            }
        }
        AppMethodBeat.o(49209);
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(49210);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(49210);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(49211);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.gJD = onFocusChangeListener;
        AppMethodBeat.o(49211);
    }

    private void dOu() {
        AppMethodBeat.i(49212);
        if (this.gJJ == 7 || this.gJJ == 14 || this.gJJ == 15) {
            AppMethodBeat.o(49212);
        } else if (!this.gJL || bo.isNullOrNil(getText())) {
            switch (this.gJJ) {
                case 1:
                    if (this.Ahb) {
                        this.gJG.setVisibility(0);
                        this.gJG.setImageResource(R.raw.wallet_scan_camera);
                        AppMethodBeat.o(49212);
                        return;
                    }
                    this.gJG.setVisibility(8);
                    AppMethodBeat.o(49212);
                    return;
                case 3:
                case 4:
                case 9:
                case 10:
                    this.gJG.setVisibility(0);
                    this.gJG.setImageResource(R.drawable.akp);
                    AppMethodBeat.o(49212);
                    return;
                default:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.o(49212);
                    return;
            }
        } else {
            this.gJG.setVisibility(0);
            this.gJG.setImageResource(R.drawable.r8);
            AppMethodBeat.o(49212);
        }
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(49213);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        ab.d("MicroMsg.EditHintView", "View:" + this.gJI + ", editType:" + this.gJJ + " onFocusChange to " + z);
        if (this.gJN) {
            this.gJE.setEnabled(true);
            AppMethodBeat.o(49213);
            return;
        }
        this.gJE.setEnabled(false);
        AppMethodBeat.o(49213);
    }

    public void setImeOptions(int i) {
        AppMethodBeat.i(49214);
        this.AgX.setImeOptions(i);
        AppMethodBeat.o(49214);
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.i(49215);
        this.AgX.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.o(49215);
    }

    public void setInfoIvVisible(int i) {
        AppMethodBeat.i(49216);
        this.gJG.setVisibility(i);
        AppMethodBeat.o(49216);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.i(49217);
        Rect rect = new Rect();
        this.gJG.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.o(49217);
        return rect;
    }

    public void setOnInfoListener(a aVar) {
        this.Ahh = aVar;
    }

    public void setShowScanCamera(boolean z) {
        AppMethodBeat.i(49218);
        this.Ahb = z;
        dOu();
        AppMethodBeat.o(49218);
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

    static /* synthetic */ void o(EditHintView editHintView) {
        int dOe;
        AppMethodBeat.i(49220);
        int i = 0;
        switch (editHintView.gJJ) {
            case 3:
                editHintView.getContext();
                dOe = ae.dOe();
                editHintView.getContext();
                i = ae.dOf();
                break;
            case 4:
                editHintView.getContext();
                dOe = ae.dOg();
                i = R.string.b45;
                break;
            case 9:
                dOe = R.layout.b5p;
                i = R.string.fc3;
                break;
            case 10:
                dOe = R.layout.b4z;
                i = R.string.fbu;
                break;
            default:
                dOe = -1;
                break;
        }
        if (dOe != -1) {
            if (editHintView.Ahg == null) {
                editHintView.Ahg = b.a(editHintView.getContext(), dOe, editHintView.getResources().getString(i), editHintView.getResources().getString(R.string.ffp), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(49186);
                        EditHintView.this.Ahg.dismiss();
                        AppMethodBeat.o(49186);
                    }
                });
            }
            editHintView.Ahg.show();
        }
        AppMethodBeat.o(49220);
    }
}
