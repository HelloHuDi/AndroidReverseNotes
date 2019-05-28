package com.tencent.p177mm.plugin.address.p276ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.telephony.PhoneNumberUtils;
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
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.address.ui.AddrEditView */
public class AddrEditView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private C26689a gJB;
    private C26690b gJC;
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
    private boolean gJN;
    private int gJO;
    private int gJP;
    private boolean gJQ;
    private OnClickListener gJR;
    private String gJS;
    private int gravity;
    private int imeOptions;
    private int inputType;

    /* renamed from: com.tencent.mm.plugin.address.ui.AddrEditView$4 */
    class C266884 implements OnClickListener {
        C266884() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(16808);
            if (AddrEditView.this.gJG.getVisibility() == 0) {
                if (AddrEditView.this.gJL && AddrEditView.this.gJJ != 2 && !C5046bo.isNullOrNil(AddrEditView.this.getText())) {
                    AddrEditView.this.gJF.setText("");
                    AddrEditView.m83893b(AddrEditView.this, AddrEditView.this.gJF.isFocused());
                    AppMethodBeat.m2505o(16808);
                    return;
                } else if (AddrEditView.this.gJB != null) {
                    AddrEditView.this.gJB.onClick();
                }
            }
            AppMethodBeat.m2505o(16808);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.AddrEditView$a */
    public interface C26689a {
        void onClick();
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.AddrEditView$b */
    public interface C26690b {
        void arX();
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.AddrEditView$1 */
    class C330491 extends NumberKeyListener {
        C330491() {
        }

        public final int getInputType() {
            return 3;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.AddrEditView$2 */
    class C330502 extends NumberKeyListener {
        C330502() {
        }

        public final int getInputType() {
            return 3;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.AddrEditView$3 */
    class C330513 implements TextWatcher {
        C330513() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(16807);
            boolean asa = AddrEditView.this.asa();
            if (!(asa == AddrEditView.this.gJN || AddrEditView.this.gJC == null)) {
                C4990ab.m7410d("MicroMsg.AddrEditView", "View:" + AddrEditView.this.gJI + ", editType:" + AddrEditView.this.gJJ + " inputValid change to " + asa);
                AddrEditView.this.gJN = asa;
                C26690b b = AddrEditView.this.gJC;
                AddrEditView.this.gJN;
                b.arX();
            }
            AddrEditView.m83893b(AddrEditView.this, AddrEditView.this.gJF.isFocused());
            AppMethodBeat.m2505o(16807);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m83893b(AddrEditView addrEditView, boolean z) {
        AppMethodBeat.m2504i(16831);
        addrEditView.m83896dr(z);
        AppMethodBeat.m2505o(16831);
    }

    public AddrEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(16809);
        this.gJH = "";
        this.gJI = "";
        this.inputType = 1;
        this.gravity = 19;
        this.gJJ = -1;
        this.background = -1;
        this.gJK = -1;
        this.gJL = true;
        this.gJN = false;
        this.gJO = 1;
        this.gJP = 30;
        this.gJQ = true;
        this.gJR = new C266884();
        this.gJS = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C25738R.C8899a.AddrEditView, i, 0);
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
        View inflate = LayoutInflater.from(context).inflate(2130968637, this, true);
        this.gJF = (EditText) inflate.findViewById(2131821052);
        this.gJF.setTextSize(0, (float) C1338a.m2856al(context, C25738R.dimen.f9980m5));
        this.gJE = (TextView) inflate.findViewById(2131821051);
        this.gJG = (ImageView) inflate.findViewById(2131821053);
        this.gJG.setOnClickListener(this.gJR);
        this.gJF.setImeOptions(this.imeOptions);
        this.gJF.setInputType(this.inputType);
        if (this.inputType == 2) {
            this.gJF.setKeyListener(new C330491());
        } else if (this.inputType == 3) {
            this.gJF.setKeyListener(new C330502());
        } else {
            this.gJF.setInputType(this.inputType);
        }
        m83896dr(this.gJF.isFocused());
        this.gJF.addTextChangedListener(new C330513());
        this.gJF.setOnFocusChangeListener(this);
        if (!C5046bo.isNullOrNil(this.gJH)) {
            this.gJF.setHint(this.gJH);
        }
        if (!C5046bo.isNullOrNil(this.gJI)) {
            this.gJE.setText(this.gJI);
        }
        Rect rect = new Rect();
        AddrEditView.m83900i(this.gJF, rect);
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
            setBackgroundResource(C25738R.drawable.f6623k5);
            setPadding(C1338a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        AddrEditView.m83901j(this.gJF, rect);
        this.gJF.setGravity(this.gravity);
        if (this.gJM != -1) {
            this.gJG.setImageResource(this.gJM);
        }
        if (!this.gJQ) {
            this.gJF.setSingleLine(false);
        }
        AppMethodBeat.m2505o(16809);
    }

    public AddrEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(C26690b c26690b) {
        this.gJC = c26690b;
    }

    public String getText() {
        AppMethodBeat.m2504i(16810);
        String obj = this.gJF.getText().toString();
        AppMethodBeat.m2505o(16810);
        return obj;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.m2504i(16811);
        this.gJF.setEllipsize(truncateAt);
        AppMethodBeat.m2505o(16811);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.m2504i(16812);
        super.setEnabled(z);
        this.gJL = z;
        this.gJG.setEnabled(true);
        AppMethodBeat.m2505o(16812);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(16813);
        if (!this.gJL) {
            boolean z;
            if (this.gJG.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            z = z ? getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY()) : false;
            if (!z) {
                AppMethodBeat.m2505o(16813);
                return true;
            }
        }
        AppMethodBeat.m2505o(16813);
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(16814);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(16814);
    }

    public final boolean asa() {
        AppMethodBeat.m2504i(16815);
        String obj = this.gJF.getText().toString();
        switch (this.gJJ) {
            case 1:
                if (obj.length() >= this.gJO && obj.length() <= this.gJP) {
                    if (obj == null) {
                        obj = null;
                    } else {
                        obj = obj.replaceAll("\\D", "");
                        if (obj.startsWith("86")) {
                            obj = obj.substring(2);
                        }
                    }
                    if (PhoneNumberUtils.isGlobalPhoneNumber(obj)) {
                        AppMethodBeat.m2505o(16815);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(16815);
                return false;
            case 2:
                if (obj.length() < this.gJO || AddrEditView.m83902wF(obj) > 32) {
                    AppMethodBeat.m2505o(16815);
                    return false;
                }
                AppMethodBeat.m2505o(16815);
                return true;
            case 3:
            case 5:
                if (obj.length() < this.gJO || AddrEditView.m83902wF(obj) > 128) {
                    AppMethodBeat.m2505o(16815);
                    return false;
                }
                AppMethodBeat.m2505o(16815);
                return true;
            case 4:
                if (obj.length() <= this.gJP) {
                    AppMethodBeat.m2505o(16815);
                    return true;
                }
                AppMethodBeat.m2505o(16815);
                return false;
            default:
                if (obj.length() >= this.gJO) {
                    AppMethodBeat.m2505o(16815);
                    return true;
                }
                AppMethodBeat.m2505o(16815);
                return false;
        }
    }

    /* renamed from: dr */
    private void m83896dr(boolean z) {
        AppMethodBeat.m2504i(16816);
        if (!this.gJL || C5046bo.isNullOrNil(getText())) {
            switch (this.gJJ) {
                case 0:
                case 1:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.m2505o(16816);
                    return;
                case 2:
                    this.gJG.setVisibility(0);
                    this.gJG.setImageResource(C1318a.wallet_address_contact_icon);
                    this.gJG.setContentDescription(getContext().getString(C25738R.string.f8739dm));
                    AppMethodBeat.m2505o(16816);
                    return;
                case 3:
                    this.gJG.setVisibility(0);
                    this.gJG.setImageResource(C1318a.wallet_address_location_icon);
                    this.gJG.setContentDescription(getContext().getString(C25738R.string.f8760e8));
                    AppMethodBeat.m2505o(16816);
                    return;
                default:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.m2505o(16816);
                    return;
            }
        }
        this.gJG.setImageResource(C25738R.drawable.f6801r8);
        this.gJG.setContentDescription(getContext().getString(C25738R.string.aqw));
        switch (this.gJJ) {
            case 0:
            case 1:
                if (z) {
                    this.gJG.setVisibility(0);
                    AppMethodBeat.m2505o(16816);
                    return;
                }
                this.gJG.setVisibility(8);
                AppMethodBeat.m2505o(16816);
                return;
            case 2:
                this.gJG.setVisibility(0);
                this.gJG.setImageResource(C1318a.wallet_address_contact_icon);
                this.gJG.setContentDescription(getContext().getString(C25738R.string.f8739dm));
                AppMethodBeat.m2505o(16816);
                return;
            case 3:
                this.gJG.setVisibility(0);
                this.gJG.setImageResource(C1318a.wallet_address_location_icon);
                this.gJG.setContentDescription(getContext().getString(C25738R.string.f8760e8));
                AppMethodBeat.m2505o(16816);
                return;
            default:
                this.gJG.setVisibility(8);
                AppMethodBeat.m2505o(16816);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.m2504i(16817);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.gJD = onFocusChangeListener;
        AppMethodBeat.m2505o(16817);
    }

    public void setInfoIvOnClickListener(C26689a c26689a) {
        this.gJB = c26689a;
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.m2504i(16818);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        C4990ab.m7410d("MicroMsg.AddrEditView", "View:" + this.gJI + ", editType:" + this.gJJ + " onFocusChange to " + z);
        if (this.gJC != null) {
            this.gJC.arX();
        }
        if (this.gJN) {
            this.gJE.setEnabled(true);
        } else {
            this.gJE.setEnabled(false);
        }
        if (view == this.gJF) {
            Rect rect = new Rect();
            AddrEditView.m83900i(this, rect);
            if (z) {
                setBackgroundResource(C25738R.drawable.b77);
            } else {
                setBackgroundResource(C25738R.drawable.b78);
            }
            AddrEditView.m83901j(this, rect);
        }
        m83896dr(z);
        AppMethodBeat.m2505o(16818);
    }

    public void setHintStr(String str) {
        AppMethodBeat.m2504i(16819);
        this.gJF.setHint(str);
        AppMethodBeat.m2505o(16819);
    }

    public void setTipStr(String str) {
        AppMethodBeat.m2504i(16820);
        this.gJE.setText(str);
        AppMethodBeat.m2505o(16820);
    }

    public void setValStr(String str) {
        AppMethodBeat.m2504i(16821);
        this.gJF.setText(str);
        this.gJF.setSelection(this.gJF.getText().length());
        this.gJS = str;
        AppMethodBeat.m2505o(16821);
    }

    public final boolean asb() {
        AppMethodBeat.m2504i(16822);
        if (getText().equals(C5046bo.nullAsNil(this.gJS))) {
            AppMethodBeat.m2505o(16822);
            return false;
        }
        AppMethodBeat.m2505o(16822);
        return true;
    }

    public void setEditBG(int i) {
        AppMethodBeat.m2504i(16823);
        if (this.gJF != null) {
            Rect rect = new Rect();
            AddrEditView.m83900i(this.gJF, rect);
            this.gJF.setBackgroundResource(i);
            AddrEditView.m83901j(this.gJF, rect);
        }
        AppMethodBeat.m2505o(16823);
    }

    public void setTipTextColor(int i) {
        AppMethodBeat.m2504i(16824);
        if (this.gJE != null) {
            this.gJE.setTextColor(i);
        }
        AppMethodBeat.m2505o(16824);
    }

    public void setImeOptions(int i) {
        AppMethodBeat.m2504i(16825);
        this.gJF.setImeOptions(i);
        AppMethodBeat.m2505o(16825);
    }

    public void setInfoIvVisible(int i) {
        AppMethodBeat.m2504i(16826);
        this.gJG.setVisibility(i);
        AppMethodBeat.m2505o(16826);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.m2504i(16827);
        Rect rect = new Rect();
        this.gJG.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.m2505o(16827);
        return rect;
    }

    /* renamed from: i */
    private static void m83900i(View view, Rect rect) {
        AppMethodBeat.m2504i(16828);
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.m2505o(16828);
    }

    /* renamed from: j */
    private static void m83901j(View view, Rect rect) {
        AppMethodBeat.m2504i(16829);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.m2505o(16829);
    }

    /* renamed from: wF */
    private static int m83902wF(String str) {
        int i = 0;
        AppMethodBeat.m2504i(16830);
        String str2 = "[Α-￥]";
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < str.length()) {
                if (str.substring(i2, i2 + 1).matches(str2)) {
                    i = i3 + 2;
                } else {
                    i = i3 + 1;
                }
                i2++;
            } else {
                AppMethodBeat.m2505o(16830);
                return i3;
            }
        }
    }
}
