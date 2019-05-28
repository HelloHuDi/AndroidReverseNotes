package com.tencent.p177mm.plugin.recharge.p491ui.form;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
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
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.recharge.ui.form.MallFormView */
public final class MallFormView extends LinearLayout implements OnFocusChangeListener {
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
    public boolean pIQ;
    private TextView pIl;
    public EditText pIm;
    private WalletIconImageView pIn;
    private TextView pIo;
    private C28815a pIp;
    private OnFocusChangeListener pIq;
    private OnClickListener pIr;
    private C39574a pIs;
    private C46162b pIt;
    private int pIu;
    private String pIv;
    private int pIw;
    private String pIx;
    private int pIy;
    private int pIz;

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.MallFormView$6 */
    class C129786 extends NumberKeyListener {
        C129786() {
        }

        public final int getInputType() {
            return 3;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.MallFormView$5 */
    class C288145 extends NumberKeyListener {
        C288145() {
        }

        public final int getInputType() {
            return 18;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.MallFormView$a */
    public interface C28815a {
        /* renamed from: hY */
        void mo37062hY(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.MallFormView$2 */
    class C347892 implements OnClickListener {
        C347892() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44376);
            MallFormView.this.cey();
            AppMethodBeat.m2505o(44376);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.MallFormView$1 */
    class C395721 implements TextWatcher {
        private boolean pIR = false;

        C395721() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(44375);
            if (MallFormView.this.asa() != this.pIR) {
                if (MallFormView.this.pIp != null) {
                    MallFormView.this.pIp.mo37062hY(MallFormView.this.asa());
                }
                this.pIR = MallFormView.this.asa();
            }
            MallFormView.this.cew();
            AppMethodBeat.m2505o(44375);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.MallFormView$4 */
    class C395734 extends NumberKeyListener {
        C395734() {
        }

        public final int getInputType() {
            return 1;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.MallFormView$3 */
    class C461613 extends NumberKeyListener {
        C461613() {
        }

        public final int getInputType() {
            return 3;
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        }
    }

    public MallFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        AppMethodBeat.m2504i(44377);
        this.iDT = null;
        this.pIl = null;
        this.pIm = null;
        this.pIn = null;
        this.pIo = null;
        this.pIp = null;
        this.pIq = null;
        this.pIr = null;
        this.pIs = null;
        this.pIt = null;
        this.pIu = -1;
        this.pIv = "";
        this.pIw = 0;
        this.pIx = "";
        this.pIy = 8;
        this.pIz = -1;
        this.pIA = 4;
        this.pIB = "";
        this.pIC = 8;
        this.pID = "";
        this.pIE = 19;
        this.pIF = C25738R.color.f12212w4;
        this.pIG = "";
        this.pIH = BaseClientBuilder.API_PRIORITY_OTHER;
        this.pII = 1;
        this.pIJ = C25738R.drawable.f6900uv;
        this.pIK = true;
        this.pIL = false;
        this.pIM = true;
        this.pIN = 1;
        this.pIO = 5;
        this.pIP = C25738R.color.f12125t_;
        this.pIQ = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C23227a.MallFormAttrs, i, 0);
        this.pIu = obtainStyledAttributes.getResourceId(2, this.pIu);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.pIv = context.getString(resourceId);
        }
        this.pIz = obtainStyledAttributes.getResourceId(4, this.pIz);
        resourceId = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId != 0) {
            this.pIB = context.getString(resourceId);
        }
        this.pIA = obtainStyledAttributes.getInteger(8, this.pIA);
        this.pIw = obtainStyledAttributes.getInteger(9, this.pIw);
        this.pIC = obtainStyledAttributes.getInteger(10, this.pIC);
        this.pIy = obtainStyledAttributes.getInteger(11, this.pIy);
        resourceId = obtainStyledAttributes.getResourceId(12, 0);
        if (resourceId != 0) {
            this.pIx = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(13, 0);
        if (resourceId != 0) {
            this.pID = context.getString(resourceId);
        }
        this.pIE = obtainStyledAttributes.getInteger(14, this.pIE);
        this.pIF = obtainStyledAttributes.getColor(15, this.pIF);
        resourceId = obtainStyledAttributes.getResourceId(16, 0);
        if (resourceId != 0) {
            this.pIG = context.getString(resourceId);
        }
        this.pIH = obtainStyledAttributes.getInteger(18, this.pIH);
        this.pII = obtainStyledAttributes.getInteger(19, this.pII);
        this.pIJ = obtainStyledAttributes.getResourceId(20, this.pIJ);
        this.pIK = obtainStyledAttributes.getBoolean(21, this.pIK);
        this.pIL = obtainStyledAttributes.getBoolean(23, this.pIL);
        this.pIM = obtainStyledAttributes.getBoolean(21, this.pIM);
        this.pIN = obtainStyledAttributes.getInteger(0, this.pIN);
        this.pIO = obtainStyledAttributes.getInteger(1, this.pIO);
        this.pIP = obtainStyledAttributes.getInteger(24, this.pIP);
        obtainStyledAttributes.recycle();
        if (this.pIu > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        MallFormView.inflate(context, this.pIu, this);
        this.iDT = (TextView) findViewById(2131820644);
        this.pIl = (TextView) findViewById(2131820642);
        this.pIm = (EditText) findViewById(2131820640);
        this.pIn = (WalletIconImageView) findViewById(2131820641);
        this.pIo = (TextView) findViewById(2131820643);
        AppMethodBeat.m2505o(44377);
    }

    public MallFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final EditText getContentEditText() {
        return this.pIm;
    }

    public final void setImeOptions(int i) {
        AppMethodBeat.m2504i(44378);
        if (this.pIm != null) {
            this.pIm.setImeOptions(i);
        }
        AppMethodBeat.m2505o(44378);
    }

    public final void setInputType(int i) {
        AppMethodBeat.m2504i(44379);
        if (this.pIm != null) {
            this.pIm.setInputType(i);
        }
        AppMethodBeat.m2505o(44379);
    }

    public final void setText(String str) {
        AppMethodBeat.m2504i(44380);
        if (this.pIm != null) {
            this.pIm.setText(str);
            this.pIm.setSelection(getInputLength());
        }
        AppMethodBeat.m2505o(44380);
    }

    public final void cew() {
        AppMethodBeat.m2504i(44381);
        if (this.pIn != null && !C5046bo.isNullOrNil(getText()) && this.pIm != null && this.pIm.isEnabled() && this.pIm.isClickable() && this.pIm.isFocusable() && this.pIm.isFocused()) {
            this.pIn.setToClearState(new C347892());
            AppMethodBeat.m2505o(44381);
        } else if (this.pIn != null) {
            this.pIn.dlG();
            AppMethodBeat.m2505o(44381);
        } else {
            C4990ab.m7418v("MicroMsg.WalletFormView", "hy: no info iv");
            AppMethodBeat.m2505o(44381);
        }
    }

    public final C28815a getInputValidChangeListener() {
        return this.pIp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(44382);
        super.onAttachedToWindow();
        AppMethodBeat.m2505o(44382);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(44383);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(44383);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onFinishInflate() {
        AppMethodBeat.m2504i(44384);
        super.onFinishInflate();
        if (getTitleTv() != null) {
            getTitleTv().setText(this.pIv);
            getTitleTv().setVisibility(this.pIw);
        }
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
        getContext();
        if (this.pIm != null) {
            this.pIm.setHint(this.pID);
            this.pIm.setGravity(this.pIE);
            this.pIm.setTextColor(this.pIF);
            setText(this.pIG);
            this.pIm.setBackgroundResource(this.pIJ);
            this.pIm.setEnabled(this.pIK);
            this.pIm.setFocusable(this.pIM);
            this.pIm.setClickable(this.pIL);
            this.pIm.setHintTextColor(this.pIP);
            setImeOptions(this.pIO);
            setInputType(this.pIN);
            this.pIm.addTextChangedListener(new C395721());
            this.pIm.setOnFocusChangeListener(this);
        }
        cew();
        if (this.pIm != null) {
            if (this.pIN == 2) {
                this.pIm.setKeyListener(new C461613());
            } else if (this.pIN == 4) {
                this.pIm.setKeyListener(new C395734());
            } else if (this.pIN == 128) {
                this.pIm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.pIm.setKeyListener(new C288145());
                this.pIm.setRawInputType(18);
            } else if (this.pIN == 3) {
                this.pIm.setKeyListener(new C129786());
            } else {
                this.pIm.setInputType(this.pIN);
            }
            if (this.pIH != -1) {
                this.pIm.setFilters(new InputFilter[]{new LengthFilter(this.pIH)});
            }
        }
        AppMethodBeat.m2505o(44384);
    }

    public final void setHint(String str) {
        AppMethodBeat.m2504i(44385);
        if (this.pIm != null) {
            this.pIm.setHint(str);
        }
        AppMethodBeat.m2505o(44385);
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        AppMethodBeat.m2504i(44386);
        this.pIm.setOnEditorActionListener(onEditorActionListener);
        AppMethodBeat.m2505o(44386);
    }

    /* Access modifiers changed, original: protected|final */
    @SuppressLint({"WrongCall"})
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(44387);
        if (this.pIs == null || !this.pIs.cet()) {
            super.onMeasure(i, i2);
        }
        AppMethodBeat.m2505o(44387);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(44388);
        if (this.pIs != null && this.pIs.ceu()) {
            AppMethodBeat.m2505o(44388);
            return true;
        } else if (this.pIm != null && m86167b(this.pIm, motionEvent) && !this.pIm.isClickable()) {
            C4990ab.m7410d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            AppMethodBeat.m2505o(44388);
            return true;
        } else if (m86167b(this.pIn, motionEvent) && motionEvent.getAction() == 1) {
            C4990ab.m7410d("MicroMsg.WalletFormView", "hy: click on info iv");
            this.pIn.performClick();
            AppMethodBeat.m2505o(44388);
            return true;
        } else {
            AppMethodBeat.m2505o(44388);
            return false;
        }
    }

    /* renamed from: b */
    private boolean m86167b(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(44389);
        if (view == null || view.getVisibility() != 0) {
            AppMethodBeat.m2505o(44389);
            return false;
        } else if (m86169dt(view).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            AppMethodBeat.m2505o(44389);
            return true;
        } else {
            AppMethodBeat.m2505o(44389);
            return false;
        }
    }

    /* renamed from: l */
    private Rect m86170l(View view, Rect rect) {
        if (view == this.pIn) {
            rect.left -= 50;
            rect.right += 50;
            rect.top -= 25;
            rect.bottom += 25;
        }
        return rect;
    }

    /* renamed from: dt */
    private Rect m86169dt(View view) {
        AppMethodBeat.m2504i(44390);
        if (view != null) {
            Rect rect = new Rect();
            view.getHitRect(rect);
            rect = m86170l(view, rect);
            AppMethodBeat.m2505o(44390);
            return rect;
        }
        AppMethodBeat.m2505o(44390);
        return null;
    }

    public final void cex() {
        AppMethodBeat.m2504i(44391);
        C4990ab.m7411d("MicroMsg.WalletFormView", "shouldClearFocus: %s", Boolean.valueOf(this.pIQ));
        if (this.pIQ) {
            getContentEditText().clearFocus();
            AppMethodBeat.m2505o(44391);
            return;
        }
        this.pIQ = true;
        AppMethodBeat.m2505o(44391);
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
        AppMethodBeat.m2504i(44392);
        if (this.pIm != null) {
            this.pIm.setSelection(i);
        }
        AppMethodBeat.m2505o(44392);
    }

    public final C39574a getEventDelegate() {
        return this.pIs;
    }

    public final C46162b getLogicDelegate() {
        return this.pIt;
    }

    public final String getText() {
        AppMethodBeat.m2504i(44393);
        String obj;
        if (this.pIm != null) {
            obj = this.pIm.getText().toString();
            if (this.pIt == null || !this.pIt.cev()) {
                AppMethodBeat.m2505o(44393);
                return obj;
            }
            obj = this.pIt.mo46964VG(obj);
            AppMethodBeat.m2505o(44393);
            return obj;
        }
        C4990ab.m7412e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        obj = "";
        AppMethodBeat.m2505o(44393);
        return obj;
    }

    public final KeyListener getKeyListener() {
        AppMethodBeat.m2504i(44394);
        if (this.pIm != null) {
            KeyListener keyListener = this.pIm.getKeyListener();
            AppMethodBeat.m2505o(44394);
            return keyListener;
        }
        C4990ab.m7420w("MicroMsg.WalletFormView", "hy: no content et");
        AppMethodBeat.m2505o(44394);
        return null;
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

    public final void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(44395);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(44395);
    }

    public final void setOnInfoIvClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(44396);
        this.pIr = onClickListener;
        if (getInfoIv() != null) {
            getInfoIv().setOnClickListener(this.pIr);
        }
        AppMethodBeat.m2505o(44396);
    }

    public final void setOnInputValidChangeListener(C28815a c28815a) {
        this.pIp = c28815a;
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pIq = onFocusChangeListener;
    }

    public final void setEventDelegate(C39574a c39574a) {
        this.pIs = c39574a;
    }

    public final void setLogicDelegate(C46162b c46162b) {
        this.pIt = c46162b;
    }

    public final void setKeyListener(KeyListener keyListener) {
        AppMethodBeat.m2504i(44397);
        if (this.pIm != null) {
            this.pIm.setKeyListener(keyListener);
        }
        AppMethodBeat.m2505o(44397);
    }

    public final boolean asa() {
        AppMethodBeat.m2504i(44398);
        if (this.pIm != null) {
            int length = this.pIm.getText() == null ? 0 : this.pIm.getText().length();
            if (length > this.pIH || length < this.pII) {
                AppMethodBeat.m2505o(44398);
                return false;
            } else if (this.pIt != null) {
                boolean a = this.pIt.mo46965a(this);
                AppMethodBeat.m2505o(44398);
                return a;
            } else {
                AppMethodBeat.m2505o(44398);
                return true;
            }
        }
        C4990ab.m7412e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
        AppMethodBeat.m2505o(44398);
        return true;
    }

    public final void cey() {
        AppMethodBeat.m2504i(44399);
        if (this.pIm != null) {
            this.pIm.setText("");
        }
        AppMethodBeat.m2505o(44399);
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        AppMethodBeat.m2504i(44400);
        if (this.pIm != null) {
            this.pIm.setFilters(inputFilterArr);
        }
        AppMethodBeat.m2505o(44400);
    }

    public final int getInputLength() {
        AppMethodBeat.m2504i(44401);
        if (this.pIm != null) {
            int length = this.pIm.getText().length();
            AppMethodBeat.m2505o(44401);
            return length;
        }
        AppMethodBeat.m2505o(44401);
        return 0;
    }

    public final void onFocusChange(View view, boolean z) {
        AppMethodBeat.m2504i(44402);
        if (this.pIq != null) {
            this.pIq.onFocusChange(this, z);
        }
        if (asa()) {
            if (this.iDT != null) {
                this.iDT.setEnabled(true);
            }
        } else if (this.iDT != null) {
            this.iDT.setEnabled(false);
        }
        cew();
        AppMethodBeat.m2505o(44402);
    }
}
