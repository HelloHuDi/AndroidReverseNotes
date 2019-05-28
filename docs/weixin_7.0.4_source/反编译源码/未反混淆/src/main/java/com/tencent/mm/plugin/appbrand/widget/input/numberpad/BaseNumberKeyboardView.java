package com.tencent.mm.plugin.appbrand.widget.input.numberpad;

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
import com.tencent.mm.R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class BaseNumberKeyboardView extends LinearLayout {
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

    public BaseNumberKeyboardView(Context context) {
        super(context);
        AppMethodBeat.i(123938);
        init(context);
        AppMethodBeat.o(123938);
    }

    public BaseNumberKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(123939);
        init(context);
        AppMethodBeat.o(123939);
    }

    private void init(Context context) {
        AppMethodBeat.i(123940);
        this.mContext = context.getApplicationContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.eh, this, true);
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
        AnonymousClass1 anonymousClass1 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(123937);
                if (BaseNumberKeyboardView.this.mInputEditText == null) {
                    AppMethodBeat.o(123937);
                } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_x")) {
                    switch (BaseNumberKeyboardView.this.mXMode) {
                        case 0:
                            AppMethodBeat.o(123937);
                            return;
                        case 1:
                            BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 59));
                            BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 52));
                            BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 59));
                            AppMethodBeat.o(123937);
                            return;
                        case 2:
                            BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 56));
                            break;
                    }
                    AppMethodBeat.o(123937);
                } else {
                    int i;
                    if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_1")) {
                        i = 8;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_2")) {
                        i = 9;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_3")) {
                        i = 10;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_4")) {
                        i = 11;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_5")) {
                        i = 12;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_6")) {
                        i = 13;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_7")) {
                        i = 14;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_8")) {
                        i = 15;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_9")) {
                        i = 16;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_0")) {
                        i = 7;
                    } else if (view.getId() == BaseNumberKeyboardView.this.getId("tenpay_keyboard_d")) {
                        i = 67;
                    } else {
                        i = 0;
                    }
                    BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i));
                    BaseNumberKeyboardView.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i));
                    AppMethodBeat.o(123937);
                }
            }
        };
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
        this.mKey1.setOnClickListener(anonymousClass1);
        this.mKey2.setOnClickListener(anonymousClass1);
        this.mKey3.setOnClickListener(anonymousClass1);
        this.mKey4.setOnClickListener(anonymousClass1);
        this.mKey5.setOnClickListener(anonymousClass1);
        this.mKey6.setOnClickListener(anonymousClass1);
        this.mKey7.setOnClickListener(anonymousClass1);
        this.mKey8.setOnClickListener(anonymousClass1);
        this.mKey9.setOnClickListener(anonymousClass1);
        this.mKeyX.setOnClickListener(anonymousClass1);
        this.mKey0.setOnClickListener(anonymousClass1);
        this.mKeyD.setOnClickListener(anonymousClass1);
        AppMethodBeat.o(123940);
    }

    public void setSecureAccessibility(AccessibilityDelegate accessibilityDelegate) {
        AppMethodBeat.i(123941);
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
        AppMethodBeat.o(123941);
    }

    public void setInputEditText(EditText editText) {
        AppMethodBeat.i(123942);
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
        AppMethodBeat.o(123942);
    }

    public void setXMode(int i) {
        AppMethodBeat.i(123943);
        this.mXMode = i;
        switch (i) {
            case 0:
                this.mKeyX.setText("");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keyitem_bottom"));
                AppMethodBeat.o(123943);
                return;
            case 1:
                this.mKeyX.setText("X");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom"));
                AppMethodBeat.o(123943);
                return;
            case 2:
                this.mKeyX.setText(".");
                this.mKeyX.setBackgroundResource(getDrawableId("tenpay_keybtn_bottom"));
                AppMethodBeat.o(123943);
                return;
            default:
                this.mXMode = 0;
                AppMethodBeat.o(123943);
                return;
        }
    }

    public final int getId(String str) {
        AppMethodBeat.i(123944);
        int identifier = this.mContext.getResources().getIdentifier(str, "id", this.mContext.getPackageName());
        AppMethodBeat.o(123944);
        return identifier;
    }

    private int getDrawableId(String str) {
        AppMethodBeat.i(123945);
        int identifier = this.mContext.getResources().getIdentifier(str, "drawable", this.mContext.getPackageName());
        AppMethodBeat.o(123945);
        return identifier;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(123946);
        super.onDetachedFromWindow();
        AppMethodBeat.o(123946);
    }
}
