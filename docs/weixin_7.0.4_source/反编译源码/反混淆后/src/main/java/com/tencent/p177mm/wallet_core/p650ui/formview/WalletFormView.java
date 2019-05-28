package com.tencent.p177mm.wallet_core.p650ui.formview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.wxpay.C23226a.C23227a;
import com.tencent.p177mm.pluginsdk.p597ui.wallet.WalletIconImageView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C46725c.C30899a;
import com.tencent.p177mm.wallet_core.p650ui.formview.p1098a.C16106a;
import com.tencent.p177mm.wallet_core.p650ui.formview.p1098a.C30889b;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.lang.reflect.Field;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.wallet_core.ui.formview.WalletFormView */
public final class WalletFormView extends LinearLayout implements OnFocusChangeListener {
    public TenpaySecureEditText Aih;
    private C36397a Aii;
    private C16106a Aij;
    private C30889b Aik;
    private int Ail;
    private int Aim;
    private int Ain;
    private int Aio;
    @Deprecated
    private int Aip;
    private int Aiq;
    private int Air;
    private TextView iDT;
    private int pIA;
    private String pIB;
    private int pIC;
    private String pID;
    private int pIE;
    private int pIF;
    private String pIG;
    private int pIH;
    private int pII;
    private int pIJ;
    private boolean pIK;
    private boolean pIL;
    private boolean pIM;
    private int pIN;
    private int pIO;
    private int pIP;
    private TextView pIl;
    private WalletIconImageView pIn;
    private TextView pIo;
    private OnFocusChangeListener pIq;
    private OnClickListener pIr;
    private int pIu;
    private String pIv;
    private int pIw;
    private String pIx;
    private int pIy;
    private int pIz;

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.WalletFormView$2 */
    class C241792 implements OnClickListener {
        C241792() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(49411);
            WalletFormView.this.cey();
            AppMethodBeat.m2505o(49411);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.WalletFormView$1 */
    class C308851 implements TextWatcher {
        private boolean pIR = false;

        C308851() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(49410);
            boolean asa = WalletFormView.this.asa();
            if (WalletFormView.this.Aii != null) {
                if (asa != this.pIR) {
                    WalletFormView.this.Aii.mo9407hY(asa);
                    this.pIR = WalletFormView.this.asa();
                }
                if ((WalletFormView.this.Aii instanceof C36889b) && asa) {
                    WalletFormView.this.Aii;
                }
            }
            WalletFormView.m71006i(WalletFormView.this);
            AppMethodBeat.m2505o(49410);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.WalletFormView$3 */
    class C308863 extends NumberKeyListener {
        C308863() {
        }

        public final int getInputType() {
            return 3;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.WalletFormView$5 */
    class C363955 extends NumberKeyListener {
        C363955() {
        }

        public final int getInputType() {
            return 18;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.WalletFormView$6 */
    class C363966 extends NumberKeyListener {
        C363966() {
        }

        public final int getInputType() {
            return 3;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.WalletFormView$a */
    public interface C36397a {
        /* renamed from: hY */
        void mo9407hY(boolean z);
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.WalletFormView$b */
    public interface C36889b extends C36397a {
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.WalletFormView$4 */
    class C409494 extends NumberKeyListener {
        C409494() {
        }

        public final int getInputType() {
            return 1;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
        }
    }

    /* renamed from: i */
    static /* synthetic */ void m71006i(WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49458);
        walletFormView.cew();
        AppMethodBeat.m2505o(49458);
    }

    public WalletFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        AppMethodBeat.m2504i(49412);
        this.iDT = null;
        this.pIl = null;
        this.Aih = null;
        this.pIn = null;
        this.pIo = null;
        this.Aii = null;
        this.pIq = null;
        this.pIr = null;
        this.Aij = null;
        this.Aik = null;
        this.pIu = -1;
        this.Ail = this.pIu;
        this.Aim = 100;
        this.pIv = "";
        this.pIw = 0;
        this.pIx = "";
        this.pIy = 8;
        this.pIz = -1;
        this.pIA = 4;
        this.pIB = "";
        this.pIC = 8;
        this.pID = "";
        this.Ain = -1;
        this.pIE = 19;
        this.pIF = C25738R.color.f12212w4;
        this.pIG = "";
        this.Aio = 0;
        this.pIH = BaseClientBuilder.API_PRIORITY_OTHER;
        this.pII = 1;
        this.pIJ = C25738R.drawable.f6900uv;
        this.pIK = true;
        this.pIL = false;
        this.pIM = true;
        this.pIN = 1;
        this.pIO = 5;
        this.pIP = C25738R.color.f12125t_;
        this.Aip = 0;
        this.Aiq = 0;
        this.Air = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C23227a.WalletFormAttrs, i, 0);
        this.pIu = obtainStyledAttributes.getResourceId(4, this.pIu);
        int resourceId = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.pIv = context.getString(resourceId);
        }
        this.pIz = obtainStyledAttributes.getResourceId(7, this.pIz);
        resourceId = obtainStyledAttributes.getResourceId(8, 0);
        if (resourceId != 0) {
            this.pIB = context.getString(resourceId);
        }
        this.pIA = obtainStyledAttributes.getInteger(10, this.pIA);
        this.pIw = obtainStyledAttributes.getInteger(11, this.pIw);
        this.pIC = obtainStyledAttributes.getInteger(12, this.pIC);
        this.pIy = obtainStyledAttributes.getInteger(13, this.pIy);
        resourceId = obtainStyledAttributes.getResourceId(14, 0);
        if (resourceId != 0) {
            this.pIx = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(15, 0);
        if (resourceId != 0) {
            this.pID = context.getString(resourceId);
        }
        this.Ain = obtainStyledAttributes.getDimensionPixelSize(16, -1);
        this.pIE = obtainStyledAttributes.getInteger(17, this.pIE);
        this.pIF = obtainStyledAttributes.getColor(18, this.pIF);
        resourceId = obtainStyledAttributes.getResourceId(19, 0);
        if (resourceId != 0) {
            this.pIG = context.getString(resourceId);
        }
        this.Aio = obtainStyledAttributes.getInt(20, this.Aio);
        this.pIH = obtainStyledAttributes.getInteger(21, this.pIH);
        this.pII = obtainStyledAttributes.getInteger(22, this.pII);
        this.pIJ = obtainStyledAttributes.getResourceId(23, this.pIJ);
        this.pIK = obtainStyledAttributes.getBoolean(24, this.pIK);
        this.pIL = obtainStyledAttributes.getBoolean(26, this.pIL);
        this.pIM = obtainStyledAttributes.getBoolean(24, this.pIM);
        this.pIN = obtainStyledAttributes.getInteger(0, this.pIN);
        this.pIO = obtainStyledAttributes.getInteger(1, this.pIO);
        this.Aim = obtainStyledAttributes.getInteger(28, this.Aim);
        this.pIP = obtainStyledAttributes.getInteger(27, this.pIP);
        this.Ail = obtainStyledAttributes.getResourceId(5, this.Ail);
        this.Aip = obtainStyledAttributes.getInteger(30, 0);
        this.Aiq = obtainStyledAttributes.getInteger(3, -1);
        if (this.Aip == 1 && this.Aiq == -1) {
            this.Aiq = 4;
        }
        this.Air = obtainStyledAttributes.getResourceId(2, 0);
        obtainStyledAttributes.recycle();
        if (this.pIu > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        if (C5046bo.isNullOrNil(this.pIv) || this.pIv.length() <= 6) {
            WalletFormView.inflate(context, this.pIu, this);
        } else {
            WalletFormView.inflate(context, this.Ail, this);
        }
        this.iDT = (TextView) findViewById(2131820694);
        this.pIl = (TextView) findViewById(2131820692);
        this.Aih = (TenpaySecureEditText) findViewById(2131820687);
        this.pIn = (WalletIconImageView) findViewById(2131820691);
        this.pIo = (TextView) findViewById(2131820693);
        AppMethodBeat.m2505o(49412);
    }

    public WalletFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void setTitleText(String str) {
        AppMethodBeat.m2504i(49413);
        this.pIv = str;
        dOR();
        AppMethodBeat.m2505o(49413);
    }

    public final void dOP() {
        AppMethodBeat.m2504i(49414);
        if (this.Aih != null) {
            this.Aih.setPadding(0, 0, 0, 0);
        }
        AppMethodBeat.m2505o(49414);
    }

    public final void set3DesValStr(String str) {
        AppMethodBeat.m2504i(49415);
        if (this.Aih != null && (this.Aik == null || !this.Aik.mo26607d(this, str))) {
            this.Aih.set3DesEncrptData(str);
            setSelection(getInputLength());
        }
        AppMethodBeat.m2505o(49415);
    }

    public final String getMD5Value() {
        AppMethodBeat.m2504i(49416);
        String nullAsNil = C5046bo.nullAsNil(this.Aih.getText().toString());
        if (this.Aik != null && this.Aik.cev()) {
            nullAsNil = this.Aik.mo26608e(this, nullAsNil);
        }
        nullAsNil = C4995ag.m7428ck(nullAsNil);
        AppMethodBeat.m2505o(49416);
        return nullAsNil;
    }

    public final void setImeOptions(int i) {
        AppMethodBeat.m2504i(49417);
        if (this.Aih != null) {
            this.Aih.setImeOptions(i);
        }
        AppMethodBeat.m2505o(49417);
    }

    public final void setInputType(int i) {
        AppMethodBeat.m2504i(49418);
        if (this.Aih != null) {
            this.Aih.setInputType(i);
        }
        AppMethodBeat.m2505o(49418);
    }

    public final void setText(String str) {
        AppMethodBeat.m2504i(49419);
        if (this.Aih != null && (this.Aik == null || !this.Aik.mo26605c(this, str))) {
            this.Aih.setText(str);
            this.Aih.setSelection(getInputLength());
        }
        AppMethodBeat.m2505o(49419);
    }

    public final void setInputEnable(boolean z) {
        AppMethodBeat.m2504i(49420);
        if (this.Aih != null) {
            this.Aih.setEnabled(z);
        }
        AppMethodBeat.m2505o(49420);
    }

    @SuppressLint({"ResourceType"})
    public final void setContentTextColorRes(int i) {
        AppMethodBeat.m2504i(49421);
        this.pIF = i;
        if (this.Aih != null) {
            this.Aih.setTextColor(getResources().getColor(this.pIF));
        }
        AppMethodBeat.m2505o(49421);
    }

    public final void setContentTextColor(int i) {
        AppMethodBeat.m2504i(49422);
        if (this.Aih != null) {
            this.Aih.setTextColor(i);
        }
        AppMethodBeat.m2505o(49422);
    }

    private void cew() {
        AppMethodBeat.m2504i(49423);
        if (this.pIn != null && !C5046bo.isNullOrNil(getText()) && this.Aih != null && this.Aih.isEnabled() && this.Aih.isClickable() && this.Aih.isFocusable() && this.Aih.isFocused()) {
            this.pIn.setToClearState(new C241792());
            AppMethodBeat.m2505o(49423);
        } else if (this.pIn != null) {
            this.pIn.dlG();
            AppMethodBeat.m2505o(49423);
        } else {
            C4990ab.m7418v("MicroMsg.WalletFormView", "hy: no info iv");
            AppMethodBeat.m2505o(49423);
        }
    }

    public final C36397a getInputValidChangeListener() {
        return this.Aii;
    }

    public final boolean dOQ() {
        AppMethodBeat.m2504i(49424);
        if (this.Aih != null) {
            boolean isFocusable = this.Aih.isFocusable();
            AppMethodBeat.m2505o(49424);
            return isFocusable;
        }
        AppMethodBeat.m2505o(49424);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(49425);
        super.onAttachedToWindow();
        AppMethodBeat.m2505o(49425);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(49426);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(49426);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onFinishInflate() {
        AppMethodBeat.m2504i(49427);
        super.onFinishInflate();
        dOR();
        if (getPrefilledTv() != null) {
            getPrefilledTv().setText(this.pIx);
            getPrefilledTv().setVisibility(this.pIy);
        }
        if (getInfoIv() != null) {
            getInfoIv().setImageResource(this.pIz);
            getInfoIv().setVisibility(this.pIA);
        }
        if (getTipsTv() != null) {
            getTipsTv().setText(this.pIB);
            getTipsTv().setVisibility(this.pIC);
        }
        Context context = getContext();
        if (this.Aih != null) {
            if (this.Aiq >= 0) {
                this.Aih.setTypeface(Typeface.createFromAsset(context.getAssets(), C36391e.m59976QQ(this.Aiq)));
            }
            if (this.Ain == -1) {
                this.Aih.setHint(this.pID);
            } else {
                SpannableString spannableString = new SpannableString(this.pID + "  ");
                spannableString.setSpan(new C40952d(this.Ain), 0, spannableString.length() - 2, 33);
                spannableString.setSpan(new AbsoluteSizeSpan((int) this.Aih.getTextSize(), false), spannableString.length() - 2, spannableString.length(), 33);
                this.Aih.setHint(new SpannedString(spannableString));
            }
            this.Aih.setGravity(this.pIE);
            this.Aih.setTextColor(this.pIF);
            setText(this.pIG);
            C40950b.m71012a(this.Aih, this.Aio);
            this.Aih.setBackgroundResource(this.pIJ);
            this.Aih.setEnabled(this.pIK);
            this.Aih.setFocusable(this.pIM);
            this.Aih.setClickable(this.pIL);
            this.Aih.setHintTextColor(this.pIP);
            setImeOptions(this.pIO);
            setInputType(this.pIN);
            this.Aih.addTextChangedListener(new C308851());
            this.Aih.setOnFocusChangeListener(this);
            try {
                if (!C5046bo.m7563gW(this.Air, 0)) {
                    Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                    declaredField.setAccessible(true);
                    declaredField.set(this.Aih, Integer.valueOf(this.Air));
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WalletFormView", "set textCursorDrawable fail!!");
            }
        }
        cew();
        if (this.Aih != null) {
            if (this.pIN == 2) {
                this.Aih.setKeyListener(new C308863());
            } else if (this.pIN == 4) {
                this.Aih.setKeyListener(new C409494());
            } else if (this.pIN == 128) {
                this.Aih.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.Aih.setKeyListener(new C363955());
                this.Aih.setRawInputType(18);
            } else if (this.pIN == 3) {
                this.Aih.setKeyListener(new C363966());
            } else {
                this.Aih.setInputType(this.pIN);
            }
            if (this.pIH != -1) {
                this.Aih.setFilters(new InputFilter[]{new LengthFilter(this.pIH)});
            }
        }
        AppMethodBeat.m2505o(49427);
    }

    public final void setHint(CharSequence charSequence) {
        AppMethodBeat.m2504i(49428);
        if (this.Aih != null) {
            if (this.Ain == -1) {
                this.Aih.setHint(charSequence);
                AppMethodBeat.m2505o(49428);
                return;
            }
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new AbsoluteSizeSpan(this.Ain, false), 0, spannableString.length(), 33);
            this.Aih.setHint(new SpannedString(spannableString));
        }
        AppMethodBeat.m2505o(49428);
    }

    public final void setContentClickable(boolean z) {
        AppMethodBeat.m2504i(49429);
        if (this.Aih != null) {
            this.Aih.setClickable(z);
        }
        AppMethodBeat.m2505o(49429);
    }

    public final void setContentFocusable(boolean z) {
        AppMethodBeat.m2504i(49430);
        if (this.Aih != null) {
            this.Aih.setFocusable(z);
        }
        AppMethodBeat.m2505o(49430);
    }

    public final void setContentEnabled(boolean z) {
        AppMethodBeat.m2504i(49431);
        if (this.Aih != null) {
            this.Aih.setEnabled(z);
        }
        AppMethodBeat.m2505o(49431);
    }

    public final void setFilterChar(char[] cArr) {
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.m2504i(49432);
        this.Aih.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.m2505o(49432);
    }

    /* Access modifiers changed, original: protected|final */
    @SuppressLint({"WrongCall"})
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(49433);
        if (this.Aij == null || !this.Aij.dOT()) {
            super.onMeasure(i, i2);
        }
        AppMethodBeat.m2505o(49433);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(49434);
        if (this.Aij != null && this.Aij.dOU()) {
            AppMethodBeat.m2505o(49434);
            return true;
        } else if (this.Aih != null && m71003b(this.Aih, motionEvent) && !this.Aih.isClickable()) {
            C4990ab.m7410d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            AppMethodBeat.m2505o(49434);
            return true;
        } else if (m71003b(this.pIn, motionEvent) && motionEvent.getAction() == 1) {
            C4990ab.m7410d("MicroMsg.WalletFormView", "hy: click on info iv");
            cew();
            this.pIn.performClick();
            AppMethodBeat.m2505o(49434);
            return true;
        } else {
            AppMethodBeat.m2505o(49434);
            return false;
        }
    }

    /* renamed from: b */
    private boolean m71003b(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(49435);
        if (view == null || view.getVisibility() != 0) {
            AppMethodBeat.m2505o(49435);
            return false;
        } else if (m71004dt(view).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            AppMethodBeat.m2505o(49435);
            return true;
        } else {
            AppMethodBeat.m2505o(49435);
            return false;
        }
    }

    /* renamed from: l */
    private Rect m71007l(View view, Rect rect) {
        if (view == this.pIn) {
            rect.left -= 50;
            rect.right += 50;
            rect.top -= 25;
            rect.bottom += 25;
        }
        return rect;
    }

    /* renamed from: dt */
    private Rect m71004dt(View view) {
        AppMethodBeat.m2504i(49436);
        if (view != null) {
            Rect rect = new Rect();
            view.getHitRect(rect);
            rect = m71007l(view, rect);
            AppMethodBeat.m2505o(49436);
            return rect;
        }
        AppMethodBeat.m2505o(49436);
        return null;
    }

    private void dOR() {
        AppMethodBeat.m2504i(49437);
        if (getTitleTv() != null) {
            getTitleTv().setText(this.pIv);
            getTitleTv().setVisibility(this.pIw);
        }
        AppMethodBeat.m2505o(49437);
    }

    public final TextView getTitleTv() {
        return this.iDT;
    }

    public final WalletIconImageView getInfoIv() {
        return this.pIn;
    }

    public final TextView getTipsTv() {
        return this.pIo;
    }

    public final TextView getPrefilledTv() {
        return this.pIl;
    }

    public final void setSelection(int i) {
        AppMethodBeat.m2504i(49438);
        if (this.Aih != null) {
            this.Aih.setSelection(i);
        }
        AppMethodBeat.m2505o(49438);
    }

    public final C16106a getEventDelegate() {
        return this.Aij;
    }

    public final C30889b getLogicDelegate() {
        return this.Aik;
    }

    public final String getText() {
        AppMethodBeat.m2504i(49439);
        String a;
        if (this.Aih != null) {
            a = C30899a.m49314a(this.Aim, this.Aih);
            if (this.Aik == null || !this.Aik.cev()) {
                AppMethodBeat.m2505o(49439);
                return a;
            }
            a = this.Aik.mo26608e(this, a);
            AppMethodBeat.m2505o(49439);
            return a;
        }
        C4990ab.m7412e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        a = "";
        AppMethodBeat.m2505o(49439);
        return a;
    }

    public final KeyListener getKeyListener() {
        AppMethodBeat.m2504i(49440);
        if (this.Aih != null) {
            KeyListener keyListener = this.Aih.getKeyListener();
            AppMethodBeat.m2505o(49440);
            return keyListener;
        }
        C4990ab.m7420w("MicroMsg.WalletFormView", "hy: no content et");
        AppMethodBeat.m2505o(49440);
        return null;
    }

    public final EditText getContentEt() {
        return this.Aih;
    }

    public final void setMaxInputLength(int i) {
        this.pIH = i;
    }

    public final void setMinInputLength(int i) {
        this.pII = i;
    }

    public final int getMaxInputLength() {
        return this.pIH;
    }

    public final int getMinInputLength() {
        return this.pII;
    }

    public final void setBankcardTail(String str) {
        AppMethodBeat.m2504i(49441);
        if (this.Aih != null) {
            this.Aih.setBankcardTailNum(str);
        }
        AppMethodBeat.m2505o(49441);
    }

    public final int getEncrptType() {
        return this.Aim;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(49442);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(49442);
    }

    public final void setOnInfoIvClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(49443);
        this.pIr = onClickListener;
        if (getInfoIv() != null) {
            getInfoIv().setOnClickListener(this.pIr);
        }
        AppMethodBeat.m2505o(49443);
    }

    public final void setOnInputValidChangeListener(C36397a c36397a) {
        this.Aii = c36397a;
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pIq = onFocusChangeListener;
    }

    public final void setEventDelegate(C16106a c16106a) {
        this.Aij = c16106a;
    }

    public final void setLogicDelegate(C30889b c30889b) {
        this.Aik = c30889b;
    }

    public final void setEncryptType(int i) {
        this.Aim = i;
    }

    public final boolean isPhoneNum() {
        AppMethodBeat.m2504i(49444);
        if (this.Aih == null) {
            AppMethodBeat.m2505o(49444);
            return false;
        }
        boolean isPhoneNum = this.Aih.isPhoneNum();
        AppMethodBeat.m2505o(49444);
        return isPhoneNum;
    }

    /* renamed from: a */
    public final void mo64594a(TextWatcher textWatcher) {
        AppMethodBeat.m2504i(49445);
        if (this.Aih != null) {
            this.Aih.addTextChangedListener(textWatcher);
        }
        AppMethodBeat.m2505o(49445);
    }

    public final void setKeyListener(KeyListener keyListener) {
        AppMethodBeat.m2504i(49446);
        if (this.Aih != null) {
            this.Aih.setKeyListener(keyListener);
        }
        AppMethodBeat.m2505o(49446);
    }

    public final boolean asa() {
        AppMethodBeat.m2504i(49447);
        if (this.Aih != null) {
            int inputLength = this.Aih.getInputLength();
            if (inputLength > this.pIH || inputLength < this.pII) {
                AppMethodBeat.m2505o(49447);
                return false;
            } else if (this.Aik != null) {
                boolean a = this.Aik.mo26604a(this);
                AppMethodBeat.m2505o(49447);
                return a;
            } else {
                AppMethodBeat.m2505o(49447);
                return true;
            }
        }
        C4990ab.m7412e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
        AppMethodBeat.m2505o(49447);
        return true;
    }

    public final void cey() {
        AppMethodBeat.m2504i(49448);
        if (this.Aih != null) {
            this.Aih.ClearInput();
        }
        AppMethodBeat.m2505o(49448);
    }

    public final void cex() {
        AppMethodBeat.m2504i(49449);
        if (this.Aih != null) {
            this.Aih.clearFocus();
        }
        AppMethodBeat.m2505o(49449);
    }

    /* renamed from: fx */
    public final boolean mo64602fx(View view) {
        AppMethodBeat.m2504i(49450);
        if (getVisibility() != 0) {
            if (view != null) {
                view.setVisibility(8);
            }
            AppMethodBeat.m2505o(49450);
            return true;
        } else if (C5046bo.isNullOrNil(getText())) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.iDT != null) {
                this.iDT.setEnabled(true);
            }
            AppMethodBeat.m2505o(49450);
            return false;
        } else if (asa()) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.iDT != null) {
                this.iDT.setEnabled(true);
            }
            AppMethodBeat.m2505o(49450);
            return true;
        } else {
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.iDT != null) {
                this.iDT.setEnabled(false);
            }
            AppMethodBeat.m2505o(49450);
            return false;
        }
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        AppMethodBeat.m2504i(49451);
        if (this.Aih != null) {
            this.Aih.setFilters(inputFilterArr);
        }
        AppMethodBeat.m2505o(49451);
    }

    public final int getInputLength() {
        AppMethodBeat.m2504i(49452);
        if (this.Aih != null) {
            int inputLength = this.Aih.getInputLength();
            AppMethodBeat.m2505o(49452);
            return inputLength;
        }
        AppMethodBeat.m2505o(49452);
        return 0;
    }

    public final void dOS() {
        AppMethodBeat.m2504i(49453);
        if (this.Aih != null) {
            this.Aih.setFocusable(true);
            this.Aih.requestFocus();
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.Aih, 0);
        }
        AppMethodBeat.m2505o(49453);
    }

    /* renamed from: f */
    public final void mo64601f(WalletBaseUI walletBaseUI) {
        AppMethodBeat.m2504i(49454);
        if (this.Aih != null) {
            this.Aih.setFocusable(true);
            this.Aih.requestFocus();
            walletBaseUI.dOC();
        }
        AppMethodBeat.m2505o(49454);
    }

    public final void setIsSecretAnswer(boolean z) {
        AppMethodBeat.m2504i(49455);
        if (this.Aih != null) {
            this.Aih.setIsSecurityAnswerFormat(z);
        }
        AppMethodBeat.m2505o(49455);
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.m2504i(49456);
        if (this.pIq != null) {
            this.pIq.onFocusChange(this, z);
        }
        if (this.Aii != null) {
            this.Aii.mo9407hY(asa());
        }
        if (asa()) {
            if (this.iDT != null) {
                this.iDT.setEnabled(true);
            }
        } else if (this.iDT != null) {
            this.iDT.setEnabled(false);
        }
        cew();
        AppMethodBeat.m2505o(49456);
    }

    public final void set3DesToView(String str) {
        AppMethodBeat.m2504i(49457);
        if (this.Aih != null) {
            this.Aih.set3DesEncrptData(str);
        }
        AppMethodBeat.m2505o(49457);
    }
}
