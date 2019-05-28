package com.tencent.mm.plugin.address.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class AddrEditView extends RelativeLayout implements OnFocusChangeListener {
    private int background;
    private a gJB;
    private b gJC;
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

    public interface a {
        void onClick();
    }

    public interface b {
        void arX();
    }

    static /* synthetic */ void b(AddrEditView addrEditView, boolean z) {
        AppMethodBeat.i(16831);
        addrEditView.dr(z);
        AppMethodBeat.o(16831);
    }

    public AddrEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(16809);
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
        this.gJR = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(16808);
                if (AddrEditView.this.gJG.getVisibility() == 0) {
                    if (AddrEditView.this.gJL && AddrEditView.this.gJJ != 2 && !bo.isNullOrNil(AddrEditView.this.getText())) {
                        AddrEditView.this.gJF.setText("");
                        AddrEditView.b(AddrEditView.this, AddrEditView.this.gJF.isFocused());
                        AppMethodBeat.o(16808);
                        return;
                    } else if (AddrEditView.this.gJB != null) {
                        AddrEditView.this.gJB.onClick();
                    }
                }
                AppMethodBeat.o(16808);
            }
        };
        this.gJS = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.AddrEditView, i, 0);
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.ay, this, true);
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
                    return 3;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                }
            });
        } else if (this.inputType == 3) {
            this.gJF.setKeyListener(new NumberKeyListener() {
                public final int getInputType() {
                    return 3;
                }

                /* Access modifiers changed, original: protected|final */
                public final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
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
                AppMethodBeat.i(16807);
                boolean asa = AddrEditView.this.asa();
                if (!(asa == AddrEditView.this.gJN || AddrEditView.this.gJC == null)) {
                    ab.d("MicroMsg.AddrEditView", "View:" + AddrEditView.this.gJI + ", editType:" + AddrEditView.this.gJJ + " inputValid change to " + asa);
                    AddrEditView.this.gJN = asa;
                    b b = AddrEditView.this.gJC;
                    AddrEditView.this.gJN;
                    b.arX();
                }
                AddrEditView.b(AddrEditView.this, AddrEditView.this.gJF.isFocused());
                AppMethodBeat.o(16807);
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
            setBackgroundResource(R.drawable.k5);
            setPadding(com.tencent.mm.bz.a.fromDPToPix(getContext(), 8), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        j(this.gJF, rect);
        this.gJF.setGravity(this.gravity);
        if (this.gJM != -1) {
            this.gJG.setImageResource(this.gJM);
        }
        if (!this.gJQ) {
            this.gJF.setSingleLine(false);
        }
        AppMethodBeat.o(16809);
    }

    public AddrEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnInputValidChangeListener(b bVar) {
        this.gJC = bVar;
    }

    public String getText() {
        AppMethodBeat.i(16810);
        String obj = this.gJF.getText().toString();
        AppMethodBeat.o(16810);
        return obj;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.i(16811);
        this.gJF.setEllipsize(truncateAt);
        AppMethodBeat.o(16811);
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(16812);
        super.setEnabled(z);
        this.gJL = z;
        this.gJG.setEnabled(true);
        AppMethodBeat.o(16812);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(16813);
        if (!this.gJL) {
            boolean z;
            if (this.gJG.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            z = z ? getValidRectOfInfoIv().contains((int) motionEvent.getX(), (int) motionEvent.getY()) : false;
            if (!z) {
                AppMethodBeat.o(16813);
                return true;
            }
        }
        AppMethodBeat.o(16813);
        return false;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(16814);
        super.setOnClickListener(onClickListener);
        AppMethodBeat.o(16814);
    }

    public final boolean asa() {
        AppMethodBeat.i(16815);
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
                        AppMethodBeat.o(16815);
                        return true;
                    }
                }
                AppMethodBeat.o(16815);
                return false;
            case 2:
                if (obj.length() < this.gJO || wF(obj) > 32) {
                    AppMethodBeat.o(16815);
                    return false;
                }
                AppMethodBeat.o(16815);
                return true;
            case 3:
            case 5:
                if (obj.length() < this.gJO || wF(obj) > 128) {
                    AppMethodBeat.o(16815);
                    return false;
                }
                AppMethodBeat.o(16815);
                return true;
            case 4:
                if (obj.length() <= this.gJP) {
                    AppMethodBeat.o(16815);
                    return true;
                }
                AppMethodBeat.o(16815);
                return false;
            default:
                if (obj.length() >= this.gJO) {
                    AppMethodBeat.o(16815);
                    return true;
                }
                AppMethodBeat.o(16815);
                return false;
        }
    }

    private void dr(boolean z) {
        AppMethodBeat.i(16816);
        if (!this.gJL || bo.isNullOrNil(getText())) {
            switch (this.gJJ) {
                case 0:
                case 1:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.o(16816);
                    return;
                case 2:
                    this.gJG.setVisibility(0);
                    this.gJG.setImageResource(R.raw.wallet_address_contact_icon);
                    this.gJG.setContentDescription(getContext().getString(R.string.dm));
                    AppMethodBeat.o(16816);
                    return;
                case 3:
                    this.gJG.setVisibility(0);
                    this.gJG.setImageResource(R.raw.wallet_address_location_icon);
                    this.gJG.setContentDescription(getContext().getString(R.string.e8));
                    AppMethodBeat.o(16816);
                    return;
                default:
                    this.gJG.setVisibility(8);
                    AppMethodBeat.o(16816);
                    return;
            }
        }
        this.gJG.setImageResource(R.drawable.r8);
        this.gJG.setContentDescription(getContext().getString(R.string.aqw));
        switch (this.gJJ) {
            case 0:
            case 1:
                if (z) {
                    this.gJG.setVisibility(0);
                    AppMethodBeat.o(16816);
                    return;
                }
                this.gJG.setVisibility(8);
                AppMethodBeat.o(16816);
                return;
            case 2:
                this.gJG.setVisibility(0);
                this.gJG.setImageResource(R.raw.wallet_address_contact_icon);
                this.gJG.setContentDescription(getContext().getString(R.string.dm));
                AppMethodBeat.o(16816);
                return;
            case 3:
                this.gJG.setVisibility(0);
                this.gJG.setImageResource(R.raw.wallet_address_location_icon);
                this.gJG.setContentDescription(getContext().getString(R.string.e8));
                AppMethodBeat.o(16816);
                return;
            default:
                this.gJG.setVisibility(8);
                AppMethodBeat.o(16816);
                return;
        }
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        AppMethodBeat.i(16817);
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.gJD = onFocusChangeListener;
        AppMethodBeat.o(16817);
    }

    public void setInfoIvOnClickListener(a aVar) {
        this.gJB = aVar;
    }

    public void onFocusChange(View view, boolean z) {
        AppMethodBeat.i(16818);
        if (this.gJD != null) {
            this.gJD.onFocusChange(this, z);
        }
        ab.d("MicroMsg.AddrEditView", "View:" + this.gJI + ", editType:" + this.gJJ + " onFocusChange to " + z);
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
            i(this, rect);
            if (z) {
                setBackgroundResource(R.drawable.b77);
            } else {
                setBackgroundResource(R.drawable.b78);
            }
            j(this, rect);
        }
        dr(z);
        AppMethodBeat.o(16818);
    }

    public void setHintStr(String str) {
        AppMethodBeat.i(16819);
        this.gJF.setHint(str);
        AppMethodBeat.o(16819);
    }

    public void setTipStr(String str) {
        AppMethodBeat.i(16820);
        this.gJE.setText(str);
        AppMethodBeat.o(16820);
    }

    public void setValStr(String str) {
        AppMethodBeat.i(16821);
        this.gJF.setText(str);
        this.gJF.setSelection(this.gJF.getText().length());
        this.gJS = str;
        AppMethodBeat.o(16821);
    }

    public final boolean asb() {
        AppMethodBeat.i(16822);
        if (getText().equals(bo.nullAsNil(this.gJS))) {
            AppMethodBeat.o(16822);
            return false;
        }
        AppMethodBeat.o(16822);
        return true;
    }

    public void setEditBG(int i) {
        AppMethodBeat.i(16823);
        if (this.gJF != null) {
            Rect rect = new Rect();
            i(this.gJF, rect);
            this.gJF.setBackgroundResource(i);
            j(this.gJF, rect);
        }
        AppMethodBeat.o(16823);
    }

    public void setTipTextColor(int i) {
        AppMethodBeat.i(16824);
        if (this.gJE != null) {
            this.gJE.setTextColor(i);
        }
        AppMethodBeat.o(16824);
    }

    public void setImeOptions(int i) {
        AppMethodBeat.i(16825);
        this.gJF.setImeOptions(i);
        AppMethodBeat.o(16825);
    }

    public void setInfoIvVisible(int i) {
        AppMethodBeat.i(16826);
        this.gJG.setVisibility(i);
        AppMethodBeat.o(16826);
    }

    private Rect getValidRectOfInfoIv() {
        AppMethodBeat.i(16827);
        Rect rect = new Rect();
        this.gJG.getHitRect(rect);
        rect.left -= 50;
        rect.right += 50;
        rect.top -= 25;
        rect.bottom += 25;
        AppMethodBeat.o(16827);
        return rect;
    }

    private static void i(View view, Rect rect) {
        AppMethodBeat.i(16828);
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(16828);
    }

    private static void j(View view, Rect rect) {
        AppMethodBeat.i(16829);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(16829);
    }

    private static int wF(String str) {
        int i = 0;
        AppMethodBeat.i(16830);
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
                AppMethodBeat.o(16830);
                return i3;
            }
        }
    }
}
