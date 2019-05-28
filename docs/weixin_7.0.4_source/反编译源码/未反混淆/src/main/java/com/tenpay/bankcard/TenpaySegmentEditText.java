package com.tenpay.bankcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.b;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpayUtil;
import com.tenpay.ndk.Encrypt;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class TenpaySegmentEditText extends LinearLayout {
    private static String mTimeStamp;
    private final int BG_LINE_COLOR;
    private final int BG_LINE_HEIGHT;
    private final int BG_LINE_SIZE;
    private final String TAG;
    private Context mContext;
    private List<EditText> mEditArray;
    EditState mEditState;
    private MyKeyboardWindow mKeyboard;
    private boolean mNoFocus;
    private OnClickListener mOnClickListener;
    private Paint mPaintBg;
    private Paint mPaintSplit;

    public enum EditState {
        DEFAULT,
        BANKCARD,
        BANKCARD_WITH_TAILNUM;

        static {
            AppMethodBeat.o(49523);
        }
    }

    public TenpaySegmentEditText(Context context) {
        this(context, null);
        AppMethodBeat.i(49524);
        this.mContext = context;
        init();
        AppMethodBeat.o(49524);
    }

    public TenpaySegmentEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49525);
        this.TAG = "MyTag";
        this.BG_LINE_COLOR = -11615450;
        this.BG_LINE_SIZE = 4;
        this.BG_LINE_HEIGHT = 9;
        this.mOnClickListener = null;
        this.mNoFocus = true;
        this.mEditState = EditState.DEFAULT;
        this.mContext = null;
        this.mEditArray = new ArrayList();
        this.mKeyboard = null;
        this.mContext = context;
        init();
        AppMethodBeat.o(49525);
    }

    private void init() {
        AppMethodBeat.i(49526);
        setBackgroundColor(-1);
        setOrientation(0);
        setIsBankcardFormat(true);
        this.mPaintSplit = new Paint();
        this.mPaintSplit.setStrokeWidth(0.0f);
        this.mPaintSplit.setColor(-7829368);
        this.mPaintBg = new Paint();
        this.mPaintBg.setColor(-11615450);
        this.mPaintBg.setStyle(Style.FILL);
        AppMethodBeat.o(49526);
    }

    public final void setIsBankcardFormat(boolean z) {
        if (z) {
            this.mEditState = EditState.BANKCARD;
        } else if (EditState.BANKCARD == this.mEditState) {
            this.mEditState = EditState.DEFAULT;
        }
    }

    public final void setText(String str) {
        AppMethodBeat.i(49527);
        setText(str, null);
        AppMethodBeat.o(49527);
    }

    public final void setText(String str, String str2) {
        AppMethodBeat.i(49528);
        Encrypt encrypt = new Encrypt();
        if (bo.isNullOrNil(str2)) {
            str2 = encrypt.getRandomKey();
        }
        String[] split = encrypt.desedeDecode(str, str2).split("-");
        removeAllViews();
        this.mNoFocus = true;
        this.mEditArray.clear();
        for (int i = 0; i < split.length; i++) {
            final EditText editText = new EditText(this.mContext);
            editText.setText(split[i]);
            editText.setMaxLines(1);
            editText.setFilters(new InputFilter[]{new LengthFilter(split[i].length())});
            editText.setGravity(17);
            editText.setInputType(2);
            editText.setBackgroundColor(0);
            editText.setSelectAllOnFocus(true);
            editText.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppMethodBeat.i(49519);
                    if (TenpaySegmentEditText.this.mOnClickListener != null) {
                        TenpaySegmentEditText.this.mOnClickListener.onClick(view);
                    }
                    if (TenpaySegmentEditText.this.mNoFocus) {
                        TenpaySegmentEditText.this.setFocusable(true);
                        editText.requestFocus();
                        TenpaySegmentEditText.this.mNoFocus = false;
                    }
                    AppMethodBeat.o(49519);
                }
            });
            setNoSystemInputOnEditText(editText);
            ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 2);
            editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(49520);
                    LogUtil.d("MyTag", "edit onFocusChange hasFocus=".concat(String.valueOf(z)));
                    if (z) {
                        if (TenpaySegmentEditText.this.mOnClickListener != null) {
                            TenpaySegmentEditText.this.mOnClickListener.onClick(view);
                        }
                        if (TenpaySegmentEditText.this.mKeyboard != null) {
                            LogUtil.d("MyTag", "keyboard is not null");
                            TenpaySegmentEditText.this.mKeyboard.setXMode(0);
                            TenpaySegmentEditText.this.mKeyboard.setInputEditText(editText);
                        }
                    }
                    AppMethodBeat.o(49520);
                }
            });
            addView(editText, new LayoutParams(-2, -1, (float) split[i].length()));
            this.mEditArray.add(editText);
        }
        setFocusable(false);
        AppMethodBeat.o(49528);
    }

    public final void setKeyboard(MyKeyboardWindow myKeyboardWindow) {
        this.mKeyboard = myKeyboardWindow;
    }

    public final void setFocusable(boolean z) {
        int i = 0;
        AppMethodBeat.i(49529);
        LogUtil.d("MyTag", "setFocusable ".concat(String.valueOf(z)));
        while (true) {
            int i2 = i;
            if (i2 < this.mEditArray.size()) {
                EditText editText = (EditText) this.mEditArray.get(i2);
                editText.setFocusable(z);
                editText.setFocusableInTouchMode(z);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(49529);
                return;
            }
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(49530);
        super.onDraw(canvas);
        drawBackgroundLine(canvas);
        AppMethodBeat.o(49530);
    }

    private void drawBackgroundLine(Canvas canvas) {
        AppMethodBeat.i(49531);
        int width = getWidth();
        int height = getHeight();
        float f = (float) (height - 4);
        canvas.drawRect(0.0f, f, (float) width, (float) height, this.mPaintBg);
        float f2 = f - 9.0f;
        int size = this.mEditArray.size();
        canvas.drawRect(0.0f, f2, 4.0f, f, this.mPaintBg);
        int i = 0;
        float f3 = 0.0f;
        while (i < size) {
            width = -2;
            if (i == size - 1) {
                width = -4;
            }
            height = width;
            float width2 = f3 + ((float) (((EditText) this.mEditArray.get(i)).getWidth() + height));
            canvas.drawRect(width2, f2, width2 + 4.0f, f, this.mPaintBg);
            i++;
            f3 = width2 - ((float) height);
        }
        AppMethodBeat.o(49531);
    }

    public static void setSalt(String str) {
        mTimeStamp = str;
    }

    private String getInputText() {
        AppMethodBeat.i(49532);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mEditArray.size()) {
                break;
            }
            stringBuffer.append(((EditText) this.mEditArray.get(i2)).getText().toString());
            i = i2 + 1;
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.length() == 0) {
            AppMethodBeat.o(49532);
            return null;
        }
        stringBuffer2.trim().replaceAll(" ", "");
        AppMethodBeat.o(49532);
        return stringBuffer2;
    }

    public final String getEncryptDataWithHash(boolean z) {
        AppMethodBeat.i(49533);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.o(49533);
            return null;
        }
        if (z) {
            inputText = TenpayUtil.md5HexDigest(inputText);
        }
        Encrypt encrypt = new Encrypt();
        if (mTimeStamp != null) {
            encrypt.setTimeStamp(mTimeStamp);
        }
        b.dNA();
        if (b.dNB()) {
            inputText = encrypt.encryptPasswdWithRSA2048(inputText);
            AppMethodBeat.o(49533);
            return inputText;
        }
        inputText = encrypt.encryptPasswd(inputText);
        AppMethodBeat.o(49533);
        return inputText;
    }

    public final String get3DesEncrptData() {
        AppMethodBeat.i(49534);
        String inputText = getInputText();
        if (inputText == null || inputText.length() == 0) {
            AppMethodBeat.o(49534);
            return null;
        }
        Encrypt encrypt = new Encrypt();
        inputText = encrypt.desedeEncode(inputText, encrypt.getRandomKey());
        AppMethodBeat.o(49534);
        return inputText;
    }

    public final boolean isMatchPattern(String str) {
        boolean z = false;
        AppMethodBeat.i(49535);
        if (str != null) {
            try {
                z = Pattern.compile(str).matcher(getInputText()).matches();
                AppMethodBeat.o(49535);
            } catch (Exception e) {
                AppMethodBeat.o(49535);
            }
        } else {
            AppMethodBeat.o(49535);
        }
        return z;
    }

    private boolean isMatchPattern(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(49536);
        if (str2 != null) {
            try {
                z = Pattern.compile(str2).matcher(str).matches();
                AppMethodBeat.o(49536);
            } catch (Exception e) {
                AppMethodBeat.o(49536);
            }
        } else {
            AppMethodBeat.o(49536);
        }
        return z;
    }

    public final void ClearInput() {
    }

    public final int getInputLength() {
        AppMethodBeat.i(49537);
        String inputText = getInputText();
        if (inputText == null) {
            AppMethodBeat.o(49537);
            return 0;
        }
        int length = inputText.length();
        AppMethodBeat.o(49537);
        return length;
    }

    public static void setNoSystemInputOnEditText(EditText editText) {
        AppMethodBeat.i(49538);
        if (VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            AppMethodBeat.o(49538);
            return;
        }
        Class cls = EditText.class;
        try {
            Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(true);
            method.invoke(editText, new Object[]{Boolean.FALSE});
            AppMethodBeat.o(49538);
        } catch (NoSuchMethodException e) {
            try {
                Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(true);
                method2.invoke(editText, new Object[]{Boolean.FALSE});
                AppMethodBeat.o(49538);
            } catch (Exception e2) {
                editText.setInputType(0);
                AppMethodBeat.o(49538);
            }
        } catch (Exception e3) {
            AppMethodBeat.o(49538);
        }
    }
}
