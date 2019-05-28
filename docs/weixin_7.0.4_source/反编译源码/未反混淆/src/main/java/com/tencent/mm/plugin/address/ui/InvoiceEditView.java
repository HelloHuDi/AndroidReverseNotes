package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class InvoiceEditView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private OnFocusChangeListener gJD;
    private TextView gJE;
    EditText gJF;
    private ImageView gJG;
    private String gJH;
    private String gJI;
    private int gJJ;
    private int gJK;
    public boolean gJL;
    private int gJM;
    public boolean gJN;
    private int gJO;
    private int gJP;
    private boolean gJQ;
    private OnClickListener gJR;
    private String gJS;
    public boolean gJU;
    private a gJV;
    private c gJW;
    private b gJX;
    private int gJY;
    public boolean gJZ;
    private int gravity;
    private int imeOptions;
    private int inputType;

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void arX();
    }

    public InvoiceEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(16834);
        this.gJU = false;
        this.gJH = "";
        this.gJI = "";
        this.inputType = 1;
        this.gJY = 0;
        this.gravity = 19;
        this.gJJ = -1;
        this.background = -1;
        this.gJK = -1;
        this.gJL = true;
        this.gJZ = true;
        this.gJN = false;
        this.gJO = 0;
        this.gJP = 100;
        this.gJQ = true;
        this.gJR = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(16833);
                if (InvoiceEditView.this.gJG.getVisibility() == 0) {
                    if (InvoiceEditView.this.gJL && InvoiceEditView.this.gJJ != 2 && !bo.isNullOrNil(InvoiceEditView.this.getText())) {
                        InvoiceEditView.this.gJF.setText("");
                        InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.this.gJF.isFocused());
                        AppMethodBeat.o(16833);
                        return;
                    } else if (InvoiceEditView.this.gJV != null) {
                        InvoiceEditView.this.gJV;
                    }
                }
                AppMethodBeat.o(16833);
            }
        };
        this.gJS = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.InvoiceEditView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            this.gJH = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.gJI = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(3, 1);
        this.gJJ = obtainStyledAttributes.getInteger(7, 0);
        this.gJL = obtainStyledAttributes.getBoolean(10, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.imeOptions = obtainStyledAttributes.getInteger(4, 5);
        this.background = obtainStyledAttributes.getResourceId(1, R.drawable.a8g);
        this.gJM = obtainStyledAttributes.getResourceId(12, -1);
        this.gJK = obtainStyledAttributes.getResourceId(9, R.drawable.a8g);
        this.gJQ = obtainStyledAttributes.getBoolean(13, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.layout.a8a, this, true);
        this.gJF = (EditText) inflate.findViewById(R.id.n1);
        this.gJF.setTextSize(0, (float) com.tencent.mm.bz.a.al(context, R.dimen.m5));
        this.gJE = (TextView) inflate.findViewById(R.id.n0);
        this.gJG = (ImageView) inflate.findViewById(R.id.n2);
        this.gJG.setOnClickListener(this.gJR);
        this.gJF.setImeOptions(this.imeOptions);
        this.gJF.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.gJF.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 2;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '+', '_', 8212, ' ', ' ', '(', ')', 65288, 65289, '@', '~', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', 65306, 65307, '{', '}', '[', ']', 65371, 65373, 12304, 12305, '<', '>', '~', '`', 183, '=', '=', '+'};
                }
            });
        } else if (this.inputType == 3) {
            this.gJF.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 3;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    if (InvoiceEditView.this.gJU) {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ' '};
                    }
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '+', '_', 8212, ' ', ' ', '(', ')', 65288, 65289, '@', '~', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', 65306, 65307, '{', '}', '[', ']', 65371, 65373, 12304, 12305, '<', '>', 36716, '~', '`', 183, '=', '=', '+'};
                }
            });
        } else {
            this.gJF.setInputType(this.inputType);
        }
        dr(this.gJF.isFocused());
        this.gJF.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(16832);
                if (InvoiceEditView.this.gJJ == 5 && InvoiceEditView.this.gJY != editable.toString().length()) {
                    InvoiceEditView.this.gJY = editable.toString().length();
                    InvoiceEditView.this.setBankNumberValStr(editable.toString());
                }
                boolean asa = InvoiceEditView.this.asa();
                if (!(asa == InvoiceEditView.this.gJN || InvoiceEditView.this.gJW == null)) {
                    ab.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.this.gJI + ", editType:" + InvoiceEditView.this.gJJ + " inputValid change to " + asa);
                    InvoiceEditView.this.gJN = asa;
                    InvoiceEditView.this.gJW.arX();
                }
                if ((!InvoiceEditView.this.gJU || InvoiceEditView.this.gJN) && InvoiceEditView.this.gJU && InvoiceEditView.this.gJN) {
                    InvoiceEditView.this.gJF.setTextColor(InvoiceEditView.this.getResources().getColor(R.color.h4));
                }
                InvoiceEditView.a(InvoiceEditView.this, InvoiceEditView.this.gJF.isFocused());
                AppMethodBeat.o(16832);
            }
        });
        this.gJF.setOnFocusChangeListener(this);
        if (!bo.isNullOrNil(this.gJH)) {
            this.gJF.setHint(this.gJH);
        }
        if (!bo.isNullOrNil(this.gJI)) {
            this.gJE.setText(this.gJI);
        }
        Rect rect = new Rect();
        i(this.gJF, rect);
        if (this.gJL) {
            this.gJN = false;
            this.gJF.setBackgroundResource(this.gJK);
            setBackgroundResource(this.background);
        } else {
            this.gJF.setEnabled(false);
            this.gJF.setTextColor(getResources().getColor(R.color.ec));
            this.gJF.setFocusable(false);
            this.gJF.setClickable(false);
            this.gJF.setBackgroundResource(R.drawable.a8g);
            if (this.gJZ) {
                setBackgroundResource(R.drawable.k5);
            }
            setPadding(com.tencent.mm.bz.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        j(this.gJF, rect);
        if (this.gJM != -1) {
            this.gJG.setImageResource(this.gJM);
        }
        if (!this.gJQ) {
            this.gJF.setSingleLine(false);
        }
        AppMethodBeat.o(16834);
    }

    public InvoiceEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(c cVar) {
        this.gJW = cVar;
    }

    public void setOnInputInvoiceTypeChangeListener(b bVar) {
        this.gJX = bVar;
    }

    public String getText() {
        AppMethodBeat.i(16835);
        String obj = this.gJF.getText().toString();
        AppMethodBeat.o(16835);
        return obj;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.i(16836);
        this.gJF.setEllipsize(truncateAt);
        AppMethodBeat.o(16836);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(16837);
        super.setEnabled(z);
        this.gJL = z;
        this.gJG.setEnabled(true);
        AppMethodBeat.o(16837);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(16838);
        if (!this.gJL) {
            boolean z;
            if (this.gJG.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            z = z ? getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY()) : false;
            if (!z) {
                AppMethodBeat.o(16838);
                return true;
            }
        }
        AppMethodBeat.o(16838);
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(16839);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(16839);
    }

    public final boolean asa() {
        AppMethodBeat.i(16840);
        String obj = this.gJF.getText().toString();
        switch (this.gJJ) {
            case 0:
                if (obj.length() < this.gJO || obj.length() > this.gJP) {
                    AppMethodBeat.o(16840);
                    return false;
                }
                AppMethodBeat.o(16840);
                return true;
            case 1:
                if (obj.length() == 0 || (obj.length() >= this.gJO && obj.length() <= this.gJP)) {
                    AppMethodBeat.o(16840);
                    return true;
                }
                AppMethodBeat.o(16840);
                return false;
            case 4:
                if (obj.length() <= 100) {
                    AppMethodBeat.o(16840);
                    return true;
                }
                AppMethodBeat.o(16840);
                return false;
            case 5:
                if (obj.length() <= 48) {
                    AppMethodBeat.o(16840);
                    return true;
                }
                AppMethodBeat.o(16840);
                return false;
            default:
                if (obj.length() < this.gJO || obj.length() > this.gJP) {
                    AppMethodBeat.o(16840);
                    return false;
                }
                AppMethodBeat.o(16840);
                return true;
        }
    }

    private void dr(boolean z) {
        AppMethodBeat.i(16841);
        if (!this.gJL || bo.isNullOrNil(getText())) {
            switch (this.gJJ) {
                case 0:
                case 1:
                case 4:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.o(16841);
                    return;
                case 2:
                    this.gJG.setVisibility(0);
                    this.gJG.setContentDescription(getContext().getString(R.string.dm));
                    AppMethodBeat.o(16841);
                    return;
                case 3:
                    this.gJG.setVisibility(0);
                    this.gJG.setContentDescription(getContext().getString(R.string.e8));
                    AppMethodBeat.o(16841);
                    return;
                default:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.o(16841);
                    return;
            }
        }
        this.gJG.setImageResource(R.drawable.r8);
        this.gJG.setContentDescription(getContext().getString(R.string.aqw));
        switch (this.gJJ) {
            case 0:
            case 1:
            case 4:
            case 5:
                if (z) {
                    this.gJG.setVisibility(0);
                    AppMethodBeat.o(16841);
                    return;
                }
                this.gJG.setVisibility(8);
                AppMethodBeat.o(16841);
                return;
            case 2:
                this.gJG.setVisibility(0);
                this.gJG.setContentDescription(getContext().getString(R.string.dm));
                AppMethodBeat.o(16841);
                return;
            case 3:
                this.gJG.setVisibility(0);
                this.gJG.setContentDescription(getContext().getString(R.string.e8));
                AppMethodBeat.o(16841);
                return;
            default:
                this.gJG.setVisibility(8);
                AppMethodBeat.o(16841);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(16842);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.gJD = onFocusChangeListener;
        AppMethodBeat.o(16842);
    }

    public void setInfoIvOnClickListener(a aVar) {
        this.gJV = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(16843);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        ab.d("MicroMsg.InvoiceEditView", "View:" + this.gJI + ", editType:" + this.gJJ + " onFocusChange to " + z);
        if (this.gJW != null) {
            this.gJW.arX();
        }
        if (this.gJN) {
            this.gJE.setEnabled(true);
        } else {
            this.gJE.setEnabled(false);
        }
        if (view == this.gJF) {
            Rect rect = new Rect();
            i(this, rect);
            if (z) {
                setBackgroundResource(R.drawable.b77);
            } else {
                setBackgroundResource(R.drawable.b78);
            }
            j(this, rect);
        }
        dr(z);
        AppMethodBeat.o(16843);
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(16844);
        this.gJF.setHint(str);
        AppMethodBeat.o(16844);
    }

    public void setTipStr(String str) {
        AppMethodBeat.i(16845);
        this.gJE.setText(str);
        AppMethodBeat.o(16845);
    }

    public void setValStr(String str) {
        AppMethodBeat.i(16846);
        this.gJF.setText(str);
        this.gJF.setSelection(this.gJF.getText().length());
        this.gJS = str;
        AppMethodBeat.o(16846);
    }

    public void setBankNumberValStr(String str) {
        CharSequence str2;
        int i = 0;
        AppMethodBeat.i(16847);
        if (this.gJJ == 5) {
            String replace = str2.replace(" ", "");
            if (replace.length() >= 4) {
                StringBuilder stringBuilder = new StringBuilder();
                if (replace.length() % 4 == 0) {
                    while (i < (replace.length() / 4) - 1) {
                        stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                        i++;
                    }
                } else {
                    while (i < replace.length() / 4) {
                        stringBuilder.append(replace.substring(i * 4, (i + 1) * 4)).append(" ");
                        i++;
                    }
                    str2 = stringBuilder.append(replace.substring((replace.length() / 4) * 4, replace.length())).toString();
                }
            }
        }
        this.gJF.setText(str2);
        this.gJF.setSelection(this.gJF.getText().length());
        AppMethodBeat.o(16847);
    }

    public final boolean asb() {
        AppMethodBeat.i(16848);
        if (getText().equals(bo.nullAsNil(this.gJS))) {
            AppMethodBeat.o(16848);
            return false;
        }
        AppMethodBeat.o(16848);
        return true;
    }

    public void setEditBG(int i) {
        AppMethodBeat.i(16849);
        if (this.gJF != null) {
            Rect rect = new Rect();
            i(this.gJF, rect);
            this.gJF.setBackgroundResource(i);
            j(this.gJF, rect);
        }
        AppMethodBeat.o(16849);
    }

    public void setTipTextColor(int i) {
        AppMethodBeat.i(16850);
        if (this.gJE != null) {
            this.gJE.setTextColor(i);
        }
        AppMethodBeat.o(16850);
    }

    public void setImeOptions(int i) {
        AppMethodBeat.i(16851);
        this.gJF.setImeOptions(i);
        AppMethodBeat.o(16851);
    }

    public void setInfoIvVisible(int i) {
        AppMethodBeat.i(16852);
        this.gJG.setVisibility(i);
        AppMethodBeat.o(16852);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.i(16853);
        Rect rect = new Rect();
        this.gJG.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.o(16853);
        return rect;
    }

    private static void i(View view, Rect rect) {
        AppMethodBeat.i(16854);
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(16854);
    }

    private static void j(View view, Rect rect) {
        AppMethodBeat.i(16855);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(16855);
    }
}
