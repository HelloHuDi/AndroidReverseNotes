package com.tenpay.android.wechat;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tenpay.ndk.Encrypt;
import java.util.regex.Pattern;

public final class TenpaySecureEditText extends EditText {
    public static final int AREA_ID_CARD_TYPE_HUIXIANG = 5;
    public static final int AREA_ID_CARD_TYPE_SHENFEN = 1;
    public static final int AREA_ID_CARD_TYPE_TAIBAO = 9;
    private static int BANK_CARD_LENGTH_LIMIT = 14;
    private static int CARD_TAIL_SPACE = 15;
    private static int CVV_4_PAYMENT_LENGTH = 4;
    private static int CVV_PAYMENT_LENGTH = 3;
    private static int PASSWD_BLACK_DOT_SIZE = 7;
    private static int PASSWD_LEFT_PADDING = -1500000;
    private static int PASSWD_LENGTH = 6;
    private static int VALID_THRU_LEN = 4;
    private static String mTimeStamp;
    private String mCardTailNum;
    private Drawable mClearBtnImg;
    private float mDensity;
    EditState mEditState;
    private char[] mFilterChar;
    private String mFixedHeaderText;
    private Paint mIDCardPaint;
    private ISecureEncrypt mIEncrypt;
    private boolean mIsCardTailNumCanDisplay;
    private boolean mIsSelfSet;
    private Paint mPaintBackground;
    private OnPasswdInputListener mPasswdListener;
    private Paint mTitlePaint;

    public enum EditState {
        DEFAULT,
        PASSWORD,
        BANKCARD,
        BANKCARD_WITH_TAILNUM,
        VALID_THRU,
        MONEY_AMOUNT,
        CVV_PAYMENT,
        CVV_4_PAYMENT,
        SECURITY_ANSWER,
        IDCARD_TAIL;

        static {
            AppMethodBeat.m2505o(49466);
        }
    }

    /* renamed from: com.tenpay.android.wechat.TenpaySecureEditText$1 */
    class C164351 implements TextWatcher {
        C164351() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tenpay.android.wechat.TenpaySecureEditText$2 */
    class C164372 implements OnFocusChangeListener {
        C164372() {
        }

        public void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(49461);
            if (z) {
                if (!(TenpaySecureEditText.this.getText().toString().equals("") || EditState.PASSWORD == TenpaySecureEditText.this.mEditState || EditState.CVV_PAYMENT == TenpaySecureEditText.this.mEditState || EditState.CVV_4_PAYMENT == TenpaySecureEditText.this.mEditState)) {
                    TenpaySecureEditText.this.setCompoundDrawables(TenpaySecureEditText.this.getCompoundDrawables()[0], TenpaySecureEditText.this.getCompoundDrawables()[1], TenpaySecureEditText.this.mClearBtnImg, TenpaySecureEditText.this.getCompoundDrawables()[3]);
                }
                AppMethodBeat.m2505o(49461);
                return;
            }
            TenpaySecureEditText.this.setCompoundDrawables(TenpaySecureEditText.this.getCompoundDrawables()[0], TenpaySecureEditText.this.getCompoundDrawables()[1], null, TenpaySecureEditText.this.getCompoundDrawables()[3]);
            AppMethodBeat.m2505o(49461);
        }
    }

    /* renamed from: com.tenpay.android.wechat.TenpaySecureEditText$3 */
    class C164383 implements OnTouchListener {
        C164383() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(49462);
            if (!(EditState.PASSWORD == TenpaySecureEditText.this.mEditState || EditState.CVV_PAYMENT == TenpaySecureEditText.this.mEditState || EditState.CVV_4_PAYMENT == TenpaySecureEditText.this.mEditState)) {
                TenpaySecureEditText tenpaySecureEditText = TenpaySecureEditText.this;
                if (tenpaySecureEditText.getCompoundDrawables()[2] == null) {
                    AppMethodBeat.m2505o(49462);
                } else if (motionEvent.getAction() != 1) {
                    AppMethodBeat.m2505o(49462);
                } else if (motionEvent.getX() > ((float) ((tenpaySecureEditText.getWidth() - tenpaySecureEditText.getPaddingRight()) - TenpaySecureEditText.this.mClearBtnImg.getIntrinsicWidth()))) {
                    tenpaySecureEditText.setText("");
                }
                return false;
            }
            AppMethodBeat.m2505o(49462);
            return false;
        }
    }

    /* renamed from: com.tenpay.android.wechat.TenpaySecureEditText$4 */
    class C164394 implements OnFocusChangeListener {
        C164394() {
        }

        public void onFocusChange(View view, boolean z) {
        }
    }

    /* renamed from: com.tenpay.android.wechat.TenpaySecureEditText$5 */
    class C164405 implements OnTouchListener {
        C164405() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    public TenpaySecureEditText(Context context) {
        this(context, null);
    }

    public TenpaySecureEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(49467);
        this.mEditState = EditState.DEFAULT;
        this.mIEncrypt = new TenpaySecureEncrypt();
        init(context, attributeSet);
        AppMethodBeat.m2505o(49467);
    }

    public TenpaySecureEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(49468);
        this.mEditState = EditState.DEFAULT;
        this.mIEncrypt = new TenpaySecureEncrypt();
        init(context, attributeSet);
        AppMethodBeat.m2505o(49468);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(49469);
        this.mDensity = getResources().getDisplayMetrics().density;
        if (attributeSet != null) {
            int[] resourceDeclareStyleableIntArray = TenpayUtil.getResourceDeclareStyleableIntArray(context, "TenpaySecureEditText");
            if (resourceDeclareStyleableIntArray != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, resourceDeclareStyleableIntArray);
                if (obtainStyledAttributes != null) {
                    setIsPasswordFormat(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isPassword"), false));
                    setIsBankcardFormat(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isBankcard"), false));
                    setIsValidThru(obtainStyledAttributes.getBoolean(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_isValidThru"), false));
                    setBankcardTailNum(obtainStyledAttributes.getString(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_bankcardTailNum")));
                    int resourceId = obtainStyledAttributes.getResourceId(TenpayUtil.getResourceDeclareStyleableIndex(context, "TenpaySecureEditText_rightClearDrawable"), 0);
                    if (resourceId != 0) {
                        setClearBtnDrawableId(resourceId);
                    }
                    obtainStyledAttributes.recycle();
                }
            }
        }
        addTextChangedListener(new C164351());
        AppMethodBeat.m2505o(49469);
    }

    public final void setClearBtnDrawableId(int i) {
        AppMethodBeat.m2504i(49470);
        try {
            this.mClearBtnImg = getResources().getDrawable(i);
        } catch (Exception e) {
            this.mClearBtnImg = null;
        }
        if (this.mClearBtnImg != null) {
            this.mClearBtnImg.setBounds(0, 0, this.mClearBtnImg.getIntrinsicWidth(), this.mClearBtnImg.getIntrinsicHeight());
            setOnFocusChangeListener(new C164372());
            setOnTouchListener(new C164383());
            AppMethodBeat.m2505o(49470);
            return;
        }
        setOnFocusChangeListener(new C164394());
        setOnTouchListener(new C164405());
        AppMethodBeat.m2505o(49470);
    }

    public final EditState getEditState() {
        return this.mEditState;
    }

    public final void setIsPasswordFormat(boolean z) {
        AppMethodBeat.m2504i(49471);
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Style.FILL);
            this.mPaintBackground.setColor(WebView.NIGHT_MODE_COLOR);
            this.mEditState = EditState.PASSWORD;
            AppMethodBeat.m2505o(49471);
            return;
        }
        this.mPaintBackground = null;
        if (EditState.PASSWORD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
        AppMethodBeat.m2505o(49471);
    }

    public final void setIsSecurityAnswerFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.SECURITY_ANSWER;
        } else {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setIsIdCardTailFormat(boolean z) {
        AppMethodBeat.m2504i(49472);
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mEditState = EditState.IDCARD_TAIL;
            this.mIDCardPaint = new Paint();
            this.mIDCardPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            this.mIDCardPaint.setTextAlign(Align.CENTER);
            this.mIDCardPaint.setAntiAlias(true);
            this.mIDCardPaint.setTextSize(getTextSize());
            this.mIDCardPaint.setColor(WebView.NIGHT_MODE_COLOR);
            AppMethodBeat.m2505o(49472);
            return;
        }
        this.mEditState = EditState.DEFAULT;
        AppMethodBeat.m2505o(49472);
    }

    public final void setIsCvvPaymentFormat(boolean z) {
        AppMethodBeat.m2504i(49473);
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Style.FILL);
            this.mPaintBackground.setColor(WebView.NIGHT_MODE_COLOR);
            this.mEditState = EditState.CVV_PAYMENT;
            AppMethodBeat.m2505o(49473);
            return;
        }
        this.mPaintBackground = null;
        if (EditState.CVV_PAYMENT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
        AppMethodBeat.m2505o(49473);
    }

    public final void setIsCvv4PaymentFormat(boolean z) {
        AppMethodBeat.m2504i(49474);
        if (z) {
            setPadding(PASSWD_LEFT_PADDING, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.mPaintBackground = new Paint(1);
            this.mPaintBackground.setStyle(Style.FILL);
            this.mPaintBackground.setColor(WebView.NIGHT_MODE_COLOR);
            this.mEditState = EditState.CVV_4_PAYMENT;
            AppMethodBeat.m2505o(49474);
            return;
        }
        this.mPaintBackground = null;
        if (EditState.CVV_4_PAYMENT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
        AppMethodBeat.m2505o(49474);
    }

    public final void setIsValidThru(boolean z) {
        if (z) {
            this.mEditState = EditState.VALID_THRU;
        } else if (EditState.VALID_THRU == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setValidThru(String str) {
        AppMethodBeat.m2504i(49475);
        if (str != null && str.length() == VALID_THRU_LEN) {
            setText(str);
            this.mEditState = EditState.VALID_THRU;
        }
        AppMethodBeat.m2505o(49475);
    }

    public final void setIsBankcardFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.BANKCARD;
        } else if (EditState.BANKCARD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setBankcardTailNum(String str) {
        AppMethodBeat.m2504i(49476);
        this.mCardTailNum = str;
        if (str != null && str.length() > 0) {
            this.mEditState = EditState.BANKCARD_WITH_TAILNUM;
            this.mTitlePaint = new Paint();
            this.mTitlePaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            this.mTitlePaint.setAntiAlias(true);
            this.mTitlePaint.setTextSize(getTextSize());
            this.mTitlePaint.setColor(WebView.NIGHT_MODE_COLOR);
        }
        AppMethodBeat.m2505o(49476);
    }

    public final void setIsMoneyAmountFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.MONEY_AMOUNT;
        } else if (EditState.MONEY_AMOUNT == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setFilterChar(char[] cArr) {
        this.mFilterChar = cArr;
    }

    public final void setFixedHeaderText(String str) {
        AppMethodBeat.m2504i(49477);
        this.mFixedHeaderText = str;
        setPadding(((int) getPaint().measureText(this.mFixedHeaderText)) + getPaddingLeft(), getPaddingTop(), getPaddingBottom(), getPaddingRight());
        invalidate();
        AppMethodBeat.m2505o(49477);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(49478);
        if (this.mEditState == EditState.IDCARD_TAIL) {
            drawIdCardTail(canvas);
        } else if (this.mEditState == EditState.PASSWORD || this.mEditState == EditState.CVV_PAYMENT || this.mEditState == EditState.CVV_4_PAYMENT) {
            drawPasswdDot(canvas);
            drawCvvPaymentDot(canvas);
            drawCvv4PaymentDot(canvas);
        } else {
            super.onDraw(canvas);
            drawCardTailNum(canvas);
        }
        if (!TextUtils.isEmpty(this.mFixedHeaderText)) {
            canvas.drawText(this.mFixedHeaderText, 0.0f, ((((float) getMeasuredHeight()) - getTextSize()) / 2.0f) + getTextSize(), getPaint());
        }
        AppMethodBeat.m2505o(49478);
    }

    private void drawIdCardTail(Canvas canvas) {
        AppMethodBeat.m2504i(49479);
        if (EditState.IDCARD_TAIL == this.mEditState && this.mIDCardPaint != null) {
            int width = getWidth() / 4;
            String obj = getText().toString();
            int length = obj.length();
            this.mIDCardPaint.setTextSize(getTextSize());
            for (int i = 0; i < length; i++) {
                canvas.drawText(obj.substring(i, i + 1), (float) ((width / 2) + (i * width)), (float) getBaseline(), this.mIDCardPaint);
            }
        }
        AppMethodBeat.m2505o(49479);
    }

    private void drawPasswdDot(Canvas canvas) {
        AppMethodBeat.m2504i(49480);
        if (EditState.PASSWORD == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i = width / PASSWD_LENGTH;
            int length = getText().length();
            for (width = 0; width < length; width++) {
                canvas.drawCircle((float) ((i / 2) + (width * i)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
        AppMethodBeat.m2505o(49480);
    }

    private void drawCvvPaymentDot(Canvas canvas) {
        AppMethodBeat.m2504i(49481);
        if (EditState.CVV_PAYMENT == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i = width / CVV_PAYMENT_LENGTH;
            int length = getText().length();
            for (width = 0; width < length; width++) {
                canvas.drawCircle((float) ((i / 2) + (width * i)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
        AppMethodBeat.m2505o(49481);
    }

    private void drawCvv4PaymentDot(Canvas canvas) {
        AppMethodBeat.m2504i(49482);
        if (EditState.CVV_4_PAYMENT == this.mEditState && this.mPaintBackground != null) {
            int width = getWidth();
            int height = getHeight();
            int i = width / CVV_4_PAYMENT_LENGTH;
            int length = getText().length();
            for (width = 0; width < length; width++) {
                canvas.drawCircle((float) ((i / 2) + (width * i)), (float) (height / 2), ((float) PASSWD_BLACK_DOT_SIZE) * this.mDensity, this.mPaintBackground);
            }
        }
        AppMethodBeat.m2505o(49482);
    }

    private void drawCardTailNum(Canvas canvas) {
        AppMethodBeat.m2504i(49483);
        if (EditState.BANKCARD_WITH_TAILNUM == this.mEditState && this.mIsCardTailNumCanDisplay) {
            int baseline = getBaseline();
            if (baseline == -1) {
                baseline = 44;
            }
            canvas.drawText(this.mCardTailNum, (((float) CARD_TAIL_SPACE) * this.mDensity) + getPaint().measureText(getText().toString()), (float) baseline, this.mTitlePaint);
        }
        AppMethodBeat.m2505o(49483);
    }

    public final boolean onTextContextMenuItem(int i) {
        AppMethodBeat.m2504i(49484);
        if ((getInputType() & 128) > 0 || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState || this.mEditState == EditState.IDCARD_TAIL) {
            AppMethodBeat.m2505o(49484);
            return true;
        }
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        AppMethodBeat.m2505o(49484);
        return onTextContextMenuItem;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreateContextMenu(ContextMenu contextMenu) {
        AppMethodBeat.m2504i(49485);
        if (!((getInputType() & 128) > 0 || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState)) {
            super.onCreateContextMenu(contextMenu);
        }
        AppMethodBeat.m2505o(49485);
    }

    public static void setSalt(String str) {
        mTimeStamp = str;
    }

    private String getInputText() {
        String obj;
        AppMethodBeat.m2504i(49486);
        if (this.mEditState == EditState.SECURITY_ANSWER) {
            obj = getText().toString();
        } else {
            obj = getText().toString().trim();
        }
        if (obj == null || obj.length() == 0) {
            AppMethodBeat.m2505o(49486);
            return null;
        }
        switch (this.mEditState) {
            case BANKCARD:
                obj = obj.replaceAll(" ", "");
                break;
            case BANKCARD_WITH_TAILNUM:
                obj = obj.replaceAll(" ", "");
                if (this.mCardTailNum != null && this.mCardTailNum.length() > 0) {
                    obj = obj + this.mCardTailNum;
                    break;
                }
            case VALID_THRU:
                obj = obj.replaceAll("/", "");
                if (obj != null && obj.length() == VALID_THRU_LEN) {
                    obj = obj.substring(2) + obj.substring(0, 2);
                    break;
                }
            case SECURITY_ANSWER:
                break;
            default:
                obj = obj.replaceAll(" ", "").replaceAll(VideoMaterialUtil.CRAZYFACE_X, "X");
                break;
        }
        AppMethodBeat.m2505o(49486);
        return obj;
    }

    public final void setSecureEncrypt(ISecureEncrypt iSecureEncrypt) {
        this.mIEncrypt = iSecureEncrypt;
    }

    public final String getEncryptDataWithHash(boolean z) {
        AppMethodBeat.m2504i(49487);
        String encryptDataWithHash = getEncryptDataWithHash(z, false);
        AppMethodBeat.m2505o(49487);
        return encryptDataWithHash;
    }

    public final String getEncryptDataWithHash(boolean z, boolean z2) {
        AppMethodBeat.m2504i(49488);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.m2505o(49488);
            return null;
        } else if (this.mIEncrypt == null) {
            if (z) {
                inputText = TenpayUtil.md5HexDigest(inputText);
            }
            Encrypt encrypt = new Encrypt();
            if (mTimeStamp != null) {
                encrypt.setTimeStamp(mTimeStamp);
            }
            if (z2) {
                inputText = encrypt.encryptPasswdWithRSA2048(inputText);
                AppMethodBeat.m2505o(49488);
                return inputText;
            }
            inputText = encrypt.encryptPasswd(inputText);
            AppMethodBeat.m2505o(49488);
            return inputText;
        } else if (z2) {
            inputText = this.mIEncrypt.encryptPasswdWithRSA2048(z, inputText, mTimeStamp);
            AppMethodBeat.m2505o(49488);
            return inputText;
        } else {
            inputText = this.mIEncrypt.encryptPasswd(z, inputText, mTimeStamp);
            AppMethodBeat.m2505o(49488);
            return inputText;
        }
    }

    public final String get3DesEncrptData() {
        AppMethodBeat.m2504i(49489);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.m2505o(49489);
            return null;
        } else if (this.mIEncrypt != null) {
            inputText = this.mIEncrypt.desedeEncode(inputText, mTimeStamp);
            AppMethodBeat.m2505o(49489);
            return inputText;
        } else {
            inputText = new Encrypt().desedeEncode(inputText);
            AppMethodBeat.m2505o(49489);
            return inputText;
        }
    }

    public final void set3DesEncrptData(String str) {
        AppMethodBeat.m2504i(49490);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(49490);
            return;
        }
        Encrypt encrypt = new Encrypt();
        setText(encrypt.desedeDecode(str, encrypt.getRandomKey()));
        AppMethodBeat.m2505o(49490);
    }

    public final String get3DesVerifyCode() {
        AppMethodBeat.m2504i(49491);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.m2505o(49491);
            return null;
        } else if (this.mIEncrypt != null) {
            inputText = this.mIEncrypt.desedeVerifyCode(inputText, mTimeStamp);
            AppMethodBeat.m2505o(49491);
            return inputText;
        } else {
            inputText = new Encrypt().desedeVerifyCode(inputText);
            AppMethodBeat.m2505o(49491);
            return inputText;
        }
    }

    public final boolean isPhoneNum() {
        AppMethodBeat.m2504i(49492);
        if (getText().toString().trim().length() == 11) {
            AppMethodBeat.m2505o(49492);
            return true;
        } else if (getText().toString().contains("**")) {
            AppMethodBeat.m2505o(49492);
            return true;
        } else {
            AppMethodBeat.m2505o(49492);
            return false;
        }
    }

    public final boolean isBankcardNum() {
        AppMethodBeat.m2504i(49493);
        if (getInputLength() >= BANK_CARD_LENGTH_LIMIT || getText().toString().contains("**")) {
            AppMethodBeat.m2505o(49493);
            return true;
        }
        AppMethodBeat.m2505o(49493);
        return false;
    }

    public final boolean isMoneyAmount() {
        AppMethodBeat.m2504i(49494);
        boolean isMatchPattern = isMatchPattern("^\\d+(\\.\\d{0,2})?$");
        AppMethodBeat.m2505o(49494);
        return isMatchPattern;
    }

    public final boolean isUserIdNum() {
        AppMethodBeat.m2504i(49495);
        String trim = getText().toString().trim();
        boolean isMatchPattern;
        if (getInputLength() == 15) {
            isMatchPattern = isMatchPattern("^\\d{15}$");
            AppMethodBeat.m2505o(49495);
            return isMatchPattern;
        }
        isMatchPattern = TenpayUtil.invalidateID(trim);
        AppMethodBeat.m2505o(49495);
        return isMatchPattern;
    }

    public final boolean isValidThru() {
        AppMethodBeat.m2504i(49496);
        boolean isMatchPattern = isMatchPattern("[1-9][0-9]0[1-9]$|[1-9][0-9]1[0-2]$");
        AppMethodBeat.m2505o(49496);
        return isMatchPattern;
    }

    public final boolean isAreaIDCardNum(int i) {
        AppMethodBeat.m2504i(49497);
        String trim = getText().toString().trim();
        if (trim == null || trim.length() == 0) {
            AppMethodBeat.m2505o(49497);
            return false;
        }
        trim.replaceAll(" ", "");
        switch (i) {
            case 1:
                boolean isUserIdNum = isUserIdNum();
                AppMethodBeat.m2505o(49497);
                return isUserIdNum;
            default:
                AppMethodBeat.m2505o(49497);
                return true;
        }
    }

    public final boolean isMatchPattern(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(49498);
        if (str != null) {
            try {
                z = Pattern.compile(str).matcher(getInputText()).matches();
                AppMethodBeat.m2505o(49498);
            } catch (Exception e) {
                AppMethodBeat.m2505o(49498);
            }
        } else {
            AppMethodBeat.m2505o(49498);
        }
        return z;
    }

    private boolean isMatchPattern(String str, String str2) {
        boolean z = false;
        AppMethodBeat.m2504i(49499);
        if (str2 != null) {
            try {
                z = Pattern.compile(str2).matcher(str).matches();
                AppMethodBeat.m2505o(49499);
            } catch (Exception e) {
                AppMethodBeat.m2505o(49499);
            }
        } else {
            AppMethodBeat.m2505o(49499);
        }
        return z;
    }

    public final void ClearInput() {
        AppMethodBeat.m2504i(49500);
        setText("");
        AppMethodBeat.m2505o(49500);
    }

    public final int getInputLength() {
        AppMethodBeat.m2504i(49501);
        String inputText = getInputText();
        if (inputText == null) {
            AppMethodBeat.m2505o(49501);
            return 0;
        }
        int length = inputText.length();
        AppMethodBeat.m2505o(49501);
        return length;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int length;
        String charSequence2;
        int i5 = 0;
        AppMethodBeat.m2504i(49502);
        super.onTextChanged(charSequence, i, i2, i3);
        if (!(this.mFilterChar == null || TextUtils.isEmpty(charSequence))) {
            for (i4 = i; i4 < i + i3; i4++) {
                for (char c : this.mFilterChar) {
                    if (c == charSequence.charAt(i4)) {
                        charSequence2 = charSequence.toString();
                        setText(charSequence2.substring(0, i4) + charSequence2.substring(i4 + 1));
                        setSelection(i4);
                        AppMethodBeat.m2505o(49502);
                        return;
                    }
                }
            }
        }
        String obj = getText().toString();
        boolean z = obj != null && obj.length() > 0;
        this.mIsCardTailNumCanDisplay = z;
        if (!(!isFocused() || this.mClearBtnImg == null || EditState.PASSWORD == this.mEditState || EditState.CVV_PAYMENT == this.mEditState || EditState.CVV_4_PAYMENT == this.mEditState)) {
            if (getText().toString().equals("")) {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            } else {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearBtnImg, getCompoundDrawables()[3]);
            }
        }
        if (this.mEditState != null) {
            try {
                int length2;
                switch (this.mEditState) {
                    case BANKCARD:
                    case BANKCARD_WITH_TAILNUM:
                        if (this.mIsSelfSet) {
                            this.mIsSelfSet = false;
                            AppMethodBeat.m2505o(49502);
                            return;
                        }
                        int i6 = i + i3;
                        if (obj.length() > 0) {
                            if (i6 <= obj.length()) {
                                charSequence2 = obj.substring(0, i6);
                                length2 = charSequence2.length() - charSequence2.replaceAll(" ", "").length();
                            } else {
                                length2 = 0;
                            }
                            charSequence2 = obj.replaceAll(" ", "");
                            StringBuffer stringBuffer = new StringBuffer();
                            i4 = charSequence2.length();
                            while (i5 + 4 < i4) {
                                stringBuffer.append(charSequence2.substring(i5, i5 + 4));
                                stringBuffer.append(" ");
                                i5 += 4;
                            }
                            stringBuffer.append(charSequence2.substring(i5));
                            String stringBuffer2 = stringBuffer.toString();
                            if (i6 <= stringBuffer2.length()) {
                                charSequence2 = stringBuffer2.substring(0, i6);
                                length = charSequence2.length() - charSequence2.replaceAll(" ", "").length();
                            } else {
                                length = stringBuffer2.length() - stringBuffer2.replaceAll(" ", "").length();
                            }
                            length = (length + i6) - length2;
                            this.mIsSelfSet = true;
                            setText(stringBuffer2);
                            setSelection(length);
                        }
                        AppMethodBeat.m2505o(49502);
                        return;
                    case VALID_THRU:
                        if (this.mIsSelfSet) {
                            this.mIsSelfSet = false;
                            break;
                        }
                        i5 = obj.length();
                        if (i5 == 0 || i5 == 1) {
                            AppMethodBeat.m2505o(49502);
                            return;
                        }
                        CharSequence replace = obj.replace("/", "");
                        if (!(i5 == 2 && obj.contains("/"))) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(replace.substring(0, 2));
                            stringBuilder.append("/");
                            if (replace.length() > 2) {
                                stringBuilder.append(replace.substring(2));
                            }
                            replace = stringBuilder.toString();
                        }
                        length2 = getSelectionStart();
                        this.mIsSelfSet = true;
                        setText(replace);
                        if (i5 != 2) {
                            setSelection(length2);
                        } else if (obj.contains("/")) {
                            setSelection(1);
                            AppMethodBeat.m2505o(49502);
                            return;
                        } else if (length2 == 2) {
                            setSelection(i3 > i2 ? 3 : 2);
                            AppMethodBeat.m2505o(49502);
                            return;
                        }
                        AppMethodBeat.m2505o(49502);
                        return;
                        break;
                    case PASSWORD:
                        if (obj.length() == PASSWD_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            AppMethodBeat.m2505o(49502);
                            return;
                        }
                    case CVV_PAYMENT:
                        if (obj.length() == CVV_PAYMENT_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            AppMethodBeat.m2505o(49502);
                            return;
                        }
                    case CVV_4_PAYMENT:
                        if (obj.length() == CVV_4_PAYMENT_LENGTH && this.mPasswdListener != null) {
                            this.mPasswdListener.onDone();
                            AppMethodBeat.m2505o(49502);
                            return;
                        }
                }
                AppMethodBeat.m2505o(49502);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(49502);
    }

    public final void setOnPasswdInputListener(OnPasswdInputListener onPasswdInputListener) {
        this.mPasswdListener = onPasswdInputListener;
    }
}
