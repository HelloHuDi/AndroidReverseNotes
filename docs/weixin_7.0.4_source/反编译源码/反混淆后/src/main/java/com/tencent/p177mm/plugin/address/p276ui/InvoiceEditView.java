package com.tencent.p177mm.plugin.address.p276ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.address.ui.InvoiceEditView */
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
    private C26691a gJV;
    private C26694c gJW;
    private C26692b gJX;
    private int gJY;
    public boolean gJZ;
    private int gravity;
    private int imeOptions;
    private int inputType;

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceEditView$3 */
    class C189773 implements TextWatcher {
        C189773() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(16832);
            if (InvoiceEditView.this.gJJ == 5 && InvoiceEditView.this.gJY != editable.toString().length()) {
                InvoiceEditView.this.gJY = editable.toString().length();
                InvoiceEditView.this.setBankNumberValStr(editable.toString());
            }
            boolean asa = InvoiceEditView.this.asa();
            if (!(asa == InvoiceEditView.this.gJN || InvoiceEditView.this.gJW == null)) {
                C4990ab.m7410d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.this.gJI + ", editType:" + InvoiceEditView.this.gJJ + " inputValid change to " + asa);
                InvoiceEditView.this.gJN = asa;
                InvoiceEditView.this.gJW.arX();
            }
            if ((!InvoiceEditView.this.gJU || InvoiceEditView.this.gJN) && InvoiceEditView.this.gJU && InvoiceEditView.this.gJN) {
                InvoiceEditView.this.gJF.setTextColor(InvoiceEditView.this.getResources().getColor(C25738R.color.f11782h4));
            }
            InvoiceEditView.m42521a(InvoiceEditView.this, InvoiceEditView.this.gJF.isFocused());
            AppMethodBeat.m2505o(16832);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceEditView$a */
    public interface C26691a {
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceEditView$b */
    public interface C26692b {
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceEditView$4 */
    class C266934 implements OnClickListener {
        C266934() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(16833);
            if (InvoiceEditView.this.gJG.getVisibility() == 0) {
                if (InvoiceEditView.this.gJL && InvoiceEditView.this.gJJ != 2 && !C5046bo.isNullOrNil(InvoiceEditView.this.getText())) {
                    InvoiceEditView.this.gJF.setText("");
                    InvoiceEditView.m42521a(InvoiceEditView.this, InvoiceEditView.this.gJF.isFocused());
                    AppMethodBeat.m2505o(16833);
                    return;
                } else if (InvoiceEditView.this.gJV != null) {
                    InvoiceEditView.this.gJV;
                }
            }
            AppMethodBeat.m2505o(16833);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceEditView$c */
    public interface C26694c {
        void arX();
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceEditView$1 */
    class C266951 extends NumberKeyListener {
        C266951() {
        }

        public final int getInputType() {
            return 2;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '-', '+', '_', 8212, ' ', ' ', '(', ')', 65288, 65289, '@', '~', '*', '&', '^', '%', '$', '#', '@', '!', ';', ':', 65306, 65307, '{', '}', '[', ']', 65371, 65373, 12304, 12305, '<', '>', '~', '`', 183, '=', '=', '+'};
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceEditView$2 */
    class C266962 extends NumberKeyListener {
        C266962() {
        }

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
    }

    public InvoiceEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(16834);
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
        this.gJR = new C266934();
        this.gJS = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25738R.C8899a.InvoiceEditView, i, 0);
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
        this.background = obtainStyledAttributes.getResourceId(1, C25738R.drawable.a8g);
        this.gJM = obtainStyledAttributes.getResourceId(12, -1);
        this.gJK = obtainStyledAttributes.getResourceId(9, C25738R.drawable.a8g);
        this.gJQ = obtainStyledAttributes.getBoolean(13, true);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(2130969875, this, true);
        this.gJF = (EditText) inflate.findViewById(2131821052);
        this.gJF.setTextSize(0, (float) C1338a.m2856al(context, C25738R.dimen.f9980m5));
        this.gJE = (TextView) inflate.findViewById(2131821051);
        this.gJG = (ImageView) inflate.findViewById(2131821053);
        this.gJG.setOnClickListener(this.gJR);
        this.gJF.setImeOptions(this.imeOptions);
        this.gJF.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.gJF.setKeyListener(new C266951());
        } else if (this.inputType == 3) {
            this.gJF.setKeyListener(new C266962());
        } else {
            this.gJF.setInputType(this.inputType);
        }
        m42525dr(this.gJF.isFocused());
        this.gJF.addTextChangedListener(new C189773());
        this.gJF.setOnFocusChangeListener(this);
        if (!C5046bo.isNullOrNil(this.gJH)) {
            this.gJF.setHint(this.gJH);
        }
        if (!C5046bo.isNullOrNil(this.gJI)) {
            this.gJE.setText(this.gJI);
        }
        Rect rect = new Rect();
        InvoiceEditView.m42529i(this.gJF, rect);
        if (this.gJL) {
            this.gJN = false;
            this.gJF.setBackgroundResource(this.gJK);
            setBackgroundResource(this.background);
        } else {
            this.gJF.setEnabled(false);
            this.gJF.setTextColor(getResources().getColor(C25738R.color.f11712ec));
            this.gJF.setFocusable(false);
            this.gJF.setClickable(false);
            this.gJF.setBackgroundResource(C25738R.drawable.a8g);
            if (this.gJZ) {
                setBackgroundResource(C25738R.drawable.f6623k5);
            }
            setPadding(C1338a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        InvoiceEditView.m42530j(this.gJF, rect);
        if (this.gJM != -1) {
            this.gJG.setImageResource(this.gJM);
        }
        if (!this.gJQ) {
            this.gJF.setSingleLine(false);
        }
        AppMethodBeat.m2505o(16834);
    }

    public InvoiceEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(C26694c c26694c) {
        this.gJW = c26694c;
    }

    public void setOnInputInvoiceTypeChangeListener(C26692b c26692b) {
        this.gJX = c26692b;
    }

    public String getText() {
        AppMethodBeat.m2504i(16835);
        String obj = this.gJF.getText().toString();
        AppMethodBeat.m2505o(16835);
        return obj;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.m2504i(16836);
        this.gJF.setEllipsize(truncateAt);
        AppMethodBeat.m2505o(16836);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.m2504i(16837);
        super.setEnabled(z);
        this.gJL = z;
        this.gJG.setEnabled(true);
        AppMethodBeat.m2505o(16837);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(16838);
        if (!this.gJL) {
            boolean z;
            if (this.gJG.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            z = z ? getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY()) : false;
            if (!z) {
                AppMethodBeat.m2505o(16838);
                return true;
            }
        }
        AppMethodBeat.m2505o(16838);
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(16839);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(16839);
    }

    public final boolean asa() {
        AppMethodBeat.m2504i(16840);
        String obj = this.gJF.getText().toString();
        switch (this.gJJ) {
            case 0:
                if (obj.length() < this.gJO || obj.length() > this.gJP) {
                    AppMethodBeat.m2505o(16840);
                    return false;
                }
                AppMethodBeat.m2505o(16840);
                return true;
            case 1:
                if (obj.length() == 0 || (obj.length() >= this.gJO && obj.length() <= this.gJP)) {
                    AppMethodBeat.m2505o(16840);
                    return true;
                }
                AppMethodBeat.m2505o(16840);
                return false;
            case 4:
                if (obj.length() <= 100) {
                    AppMethodBeat.m2505o(16840);
                    return true;
                }
                AppMethodBeat.m2505o(16840);
                return false;
            case 5:
                if (obj.length() <= 48) {
                    AppMethodBeat.m2505o(16840);
                    return true;
                }
                AppMethodBeat.m2505o(16840);
                return false;
            default:
                if (obj.length() < this.gJO || obj.length() > this.gJP) {
                    AppMethodBeat.m2505o(16840);
                    return false;
                }
                AppMethodBeat.m2505o(16840);
                return true;
        }
    }

    /* renamed from: dr */
    private void m42525dr(boolean z) {
        AppMethodBeat.m2504i(16841);
        if (!this.gJL || C5046bo.isNullOrNil(getText())) {
            switch (this.gJJ) {
                case 0:
                case 1:
                case 4:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.m2505o(16841);
                    return;
                case 2:
                    this.gJG.setVisibility(0);
                    this.gJG.setContentDescription(getContext().getString(C25738R.string.f8739dm));
                    AppMethodBeat.m2505o(16841);
                    return;
                case 3:
                    this.gJG.setVisibility(0);
                    this.gJG.setContentDescription(getContext().getString(C25738R.string.f8760e8));
                    AppMethodBeat.m2505o(16841);
                    return;
                default:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.m2505o(16841);
                    return;
            }
        }
        this.gJG.setImageResource(C25738R.drawable.f6801r8);
        this.gJG.setContentDescription(getContext().getString(C25738R.string.aqw));
        switch (this.gJJ) {
            case 0:
            case 1:
            case 4:
            case 5:
                if (z) {
                    this.gJG.setVisibility(0);
                    AppMethodBeat.m2505o(16841);
                    return;
                }
                this.gJG.setVisibility(8);
                AppMethodBeat.m2505o(16841);
                return;
            case 2:
                this.gJG.setVisibility(0);
                this.gJG.setContentDescription(getContext().getString(C25738R.string.f8739dm));
                AppMethodBeat.m2505o(16841);
                return;
            case 3:
                this.gJG.setVisibility(0);
                this.gJG.setContentDescription(getContext().getString(C25738R.string.f8760e8));
                AppMethodBeat.m2505o(16841);
                return;
            default:
                this.gJG.setVisibility(8);
                AppMethodBeat.m2505o(16841);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.m2504i(16842);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.gJD = onFocusChangeListener;
        AppMethodBeat.m2505o(16842);
    }

    public void setInfoIvOnClickListener(C26691a c26691a) {
        this.gJV = c26691a;
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.m2504i(16843);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        C4990ab.m7410d("MicroMsg.InvoiceEditView", "View:" + this.gJI + ", editType:" + this.gJJ + " onFocusChange to " + z);
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
            InvoiceEditView.m42529i(this, rect);
            if (z) {
                setBackgroundResource(C25738R.drawable.b77);
            } else {
                setBackgroundResource(C25738R.drawable.b78);
            }
            InvoiceEditView.m42530j(this, rect);
        }
        m42525dr(z);
        AppMethodBeat.m2505o(16843);
    }

    public void setHintStr(String str) {
        AppMethodBeat.m2504i(16844);
        this.gJF.setHint(str);
        AppMethodBeat.m2505o(16844);
    }

    public void setTipStr(String str) {
        AppMethodBeat.m2504i(16845);
        this.gJE.setText(str);
        AppMethodBeat.m2505o(16845);
    }

    public void setValStr(String str) {
        AppMethodBeat.m2504i(16846);
        this.gJF.setText(str);
        this.gJF.setSelection(this.gJF.getText().length());
        this.gJS = str;
        AppMethodBeat.m2505o(16846);
    }

    public void setBankNumberValStr(String str) {
        CharSequence str2;
        int i = 0;
        AppMethodBeat.m2504i(16847);
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
        AppMethodBeat.m2505o(16847);
    }

    public final boolean asb() {
        AppMethodBeat.m2504i(16848);
        if (getText().equals(C5046bo.nullAsNil(this.gJS))) {
            AppMethodBeat.m2505o(16848);
            return false;
        }
        AppMethodBeat.m2505o(16848);
        return true;
    }

    public void setEditBG(int i) {
        AppMethodBeat.m2504i(16849);
        if (this.gJF != null) {
            Rect rect = new Rect();
            InvoiceEditView.m42529i(this.gJF, rect);
            this.gJF.setBackgroundResource(i);
            InvoiceEditView.m42530j(this.gJF, rect);
        }
        AppMethodBeat.m2505o(16849);
    }

    public void setTipTextColor(int i) {
        AppMethodBeat.m2504i(16850);
        if (this.gJE != null) {
            this.gJE.setTextColor(i);
        }
        AppMethodBeat.m2505o(16850);
    }

    public void setImeOptions(int i) {
        AppMethodBeat.m2504i(16851);
        this.gJF.setImeOptions(i);
        AppMethodBeat.m2505o(16851);
    }

    public void setInfoIvVisible(int i) {
        AppMethodBeat.m2504i(16852);
        this.gJG.setVisibility(i);
        AppMethodBeat.m2505o(16852);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.m2504i(16853);
        Rect rect = new Rect();
        this.gJG.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.m2505o(16853);
        return rect;
    }

    /* renamed from: i */
    private static void m42529i(View view, Rect rect) {
        AppMethodBeat.m2504i(16854);
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.m2505o(16854);
    }

    /* renamed from: j */
    private static void m42530j(View view, Rect rect) {
        AppMethodBeat.m2504i(16855);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.m2505o(16855);
    }
}
