package com.tenpay.android.wechat;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class MyKeyboardWindow extends LinearLayout {
    public static final int X_MODE_CHARACTER = 1;
    public static final int X_MODE_DOT = 2;
    public static final int X_MODE_NONE = 0;
    private Context mContext;
    private EditText mInputEditText;
    private Button mKey0;
    private Button mKey1;
    private Button mKey2;
    private Button mKey3;
    private Button mKey4;
    private Button mKey5;
    private Button mKey6;
    private Button mKey7;
    private Button mKey8;
    private Button mKey9;
    private ImageButton mKeyD;
    private Button mKeyX;
    private int mXMode = 0;

    /* renamed from: com.tenpay.android.wechat.MyKeyboardWindow$1 */
    class C411441 implements OnClickListener {
        C411441() {
        }

        public void onClick(View view) {
            AppMethodBeat.m2504i(5483);
            if (MyKeyboardWindow.this.mInputEditText == null) {
                AppMethodBeat.m2505o(5483);
            } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_x")) {
                switch (MyKeyboardWindow.this.mXMode) {
                    case 0:
                        AppMethodBeat.m2505o(5483);
                        return;
                    case 1:
                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 59));
                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 52));
                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 59));
                        AppMethodBeat.m2505o(5483);
                        return;
                    case 2:
                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 56));
                        break;
                }
                AppMethodBeat.m2505o(5483);
            } else {
                int i;
                if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_1")) {
                    i = 8;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_2")) {
                    i = 9;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_3")) {
                    i = 10;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_4")) {
                    i = 11;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_5")) {
                    i = 12;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_6")) {
                    i = 13;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_7")) {
                    i = 14;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_8")) {
                    i = 15;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_9")) {
                    i = 16;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_0")) {
                    i = 7;
                } else if (view.getId() == MyKeyboardWindow.this.getId("tenpay_keyboard_d")) {
                    i = 67;
                } else {
                    i = 0;
                }
                MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i));
                MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i));
                AppMethodBeat.m2505o(5483);
            }
        }
    }

    public MyKeyboardWindow(Context context) {
        super(context);
        AppMethodBeat.m2504i(5484);
        init(context);
        AppMethodBeat.m2505o(5484);
    }

    public MyKeyboardWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(5485);
        init(context);
        AppMethodBeat.m2505o(5485);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(5486);
        this.mContext = context.getApplicationContext();
        TenpayTTSUtil.init(context);
        View inflate = LayoutInflater.from(context).inflate(this.mContext.getResources().getIdentifier("tenpay_number_keyboard", "layout", this.mContext.getPackageName()), this, true);
        this.mKey1 = (Button) inflate.findViewById(getId("tenpay_keyboard_1"));
        this.mKey2 = (Button) inflate.findViewById(getId("tenpay_keyboard_2"));
        this.mKey3 = (Button) inflate.findViewById(getId("tenpay_keyboard_3"));
        this.mKey4 = (Button) inflate.findViewById(getId("tenpay_keyboard_4"));
        this.mKey5 = (Button) inflate.findViewById(getId("tenpay_keyboard_5"));
        this.mKey6 = (Button) inflate.findViewById(getId("tenpay_keyboard_6"));
        this.mKey7 = (Button) inflate.findViewById(getId("tenpay_keyboard_7"));
        this.mKey8 = (Button) inflate.findViewById(getId("tenpay_keyboard_8"));
        this.mKey9 = (Button) inflate.findViewById(getId("tenpay_keyboard_9"));
        this.mKeyX = (Button) inflate.findViewById(getId("tenpay_keyboard_x"));
        this.mKey0 = (Button) inflate.findViewById(getId("tenpay_keyboard_0"));
        this.mKeyD = (ImageButton) inflate.findViewById(getId("tenpay_keyboard_d"));
        C411441 c411441 = new C411441();
        if (VERSION.SDK_INT >= 14) {
            this.mKey1.setContentDescription("1");
            this.mKey2.setContentDescription("2");
            this.mKey3.setContentDescription(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            this.mKey4.setContentDescription("4");
            this.mKey5.setContentDescription("5");
            this.mKey6.setContentDescription("6");
            this.mKey7.setContentDescription("7");
            this.mKey8.setContentDescription("8");
            this.mKey9.setContentDescription("9");
            this.mKey0.setContentDescription(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.mKeyX.setContentDescription("字母X");
            this.mKeyD.setContentDescription("删除");
        }
        this.mKey1.setOnClickListener(c411441);
        this.mKey2.setOnClickListener(c411441);
        this.mKey3.setOnClickListener(c411441);
        this.mKey4.setOnClickListener(c411441);
        this.mKey5.setOnClickListener(c411441);
        this.mKey6.setOnClickListener(c411441);
        this.mKey7.setOnClickListener(c411441);
        this.mKey8.setOnClickListener(c411441);
        this.mKey9.setOnClickListener(c411441);
        this.mKeyX.setOnClickListener(c411441);
        this.mKey0.setOnClickListener(c411441);
        this.mKeyD.setOnClickListener(c411441);
        AppMethodBeat.m2505o(5486);
    }

    public void setSecureAccessibility(AccessibilityDelegate accessibilityDelegate) {
        AppMethodBeat.m2504i(5487);
        this.mKey0.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey1.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey2.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey3.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey4.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey5.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey6.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey7.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey8.setAccessibilityDelegate(accessibilityDelegate);
        this.mKey9.setAccessibilityDelegate(accessibilityDelegate);
        this.mKeyX.setAccessibilityDelegate(accessibilityDelegate);
        this.mKeyD.setAccessibilityDelegate(accessibilityDelegate);
        AppMethodBeat.m2505o(5487);
    }

    public void resetSecureAccessibility() {
        AppMethodBeat.m2504i(5488);
        this.mKey0.setAccessibilityDelegate(null);
        this.mKey1.setAccessibilityDelegate(null);
        this.mKey2.setAccessibilityDelegate(null);
        this.mKey3.setAccessibilityDelegate(null);
        this.mKey4.setAccessibilityDelegate(null);
        this.mKey5.setAccessibilityDelegate(null);
        this.mKey6.setAccessibilityDelegate(null);
        this.mKey7.setAccessibilityDelegate(null);
        this.mKey8.setAccessibilityDelegate(null);
        this.mKey9.setAccessibilityDelegate(null);
        this.mKeyX.setAccessibilityDelegate(null);
        this.mKeyD.setAccessibilityDelegate(null);
        AppMethodBeat.m2505o(5488);
    }

    public void setInputEditText(EditText editText) {
        AppMethodBeat.m2504i(5489);
        if (editText != null) {
            this.mInputEditText = editText;
            int imeOptions = this.mInputEditText.getImeOptions();
            CharSequence imeActionLabel = this.mInputEditText.getImeActionLabel();
            if (!TextUtils.isEmpty(imeActionLabel)) {
                this.mKeyX.setText(imeActionLabel);
            }
            switch (imeOptions) {
                case 1:
                    this.mXMode = 0;
                    if (TextUtils.isEmpty(imeActionLabel)) {
                        this.mKeyX.setText("");
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.m2505o(5489);
    }

    public void setXMode(int i) {
        AppMethodBeat.m2504i(5490);
        this.mXMode = i;
        switch (i) {
            case 0:
                this.mKeyX.setText("");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keyitem_bottom"));
                AppMethodBeat.m2505o(5490);
                return;
            case 1:
                this.mKeyX.setText("X");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom"));
                AppMethodBeat.m2505o(5490);
                return;
            case 2:
                this.mKeyX.setText(".");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom"));
                AppMethodBeat.m2505o(5490);
                return;
            default:
                this.mXMode = 0;
                AppMethodBeat.m2505o(5490);
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public int getId(String str) {
        AppMethodBeat.m2504i(5491);
        int identifier = this.mContext.getResources().getIdentifier(str, "id", this.mContext.getPackageName());
        AppMethodBeat.m2505o(5491);
        return identifier;
    }

    /* Access modifiers changed, original: protected */
    public int getDrawableId(String str) {
        AppMethodBeat.m2504i(5492);
        int identifier = this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName());
        AppMethodBeat.m2505o(5492);
        return identifier;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(5493);
        super.onDetachedFromWindow();
        TenpayTTSUtil.destroy();
        AppMethodBeat.m2505o(5493);
    }
}
