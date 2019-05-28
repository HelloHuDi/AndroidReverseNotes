package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public class MMFormVerifyCodeInputView extends LinearLayout {
    private ap fNJ;
    private Button gGm;
    private TextView gnB;
    private int layout;
    private Context mContext;
    private OnFocusChangeListener mLV;
    private EditText pwu;
    private int vaH;
    private int yuj;
    private int[] yuk;
    private TextView yut;
    private int yuu;
    private int yuv;
    private int yuw;
    private OnClickListener yux;

    @TargetApi(11)
    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(106595);
        this.mContext = null;
        this.vaH = -1;
        this.yuj = -1;
        this.yuu = -1;
        this.layout = -1;
        this.yuv = 60;
        this.yuw = this.yuv;
        this.mLV = null;
        this.yux = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.FormItemView, i, 0);
        this.yuj = obtainStyledAttributes.getResourceId(2, -1);
        this.vaH = obtainStyledAttributes.getResourceId(1, -1);
        this.yuu = obtainStyledAttributes.getResourceId(3, -1);
        this.layout = obtainStyledAttributes.getResourceId(0, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
        AppMethodBeat.o(106595);
    }

    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        AppMethodBeat.i(106596);
        super.onFinishInflate();
        this.gnB = (TextView) findViewById(R.id.cx);
        this.pwu = (EditText) findViewById(R.id.l3);
        this.yut = (TextView) findViewById(R.id.d9h);
        this.gGm = (Button) findViewById(R.id.d9g);
        if (this.gnB == null || this.pwu == null || this.yut == null || this.gGm == null) {
            ab.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", this.gnB, this.pwu, this.yut, this.gGm);
        } else {
            if (this.vaH != -1) {
                this.gnB.setText(this.vaH);
            }
            if (this.yuj != -1) {
                this.pwu.setHint(this.yuj);
            }
            if (this.yuu != -1) {
                this.gGm.setText(this.yuu);
            }
        }
        if (this.pwu != null) {
            this.pwu.setOnFocusChangeListener(new OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(106592);
                    if (view == MMFormVerifyCodeInputView.this.pwu) {
                        MMFormVerifyCodeInputView.b(MMFormVerifyCodeInputView.this);
                        if (z) {
                            MMFormVerifyCodeInputView.this.setBackgroundResource(R.drawable.b77);
                        } else {
                            MMFormVerifyCodeInputView.this.setBackgroundResource(R.drawable.b78);
                        }
                        MMFormVerifyCodeInputView.c(MMFormVerifyCodeInputView.this);
                    }
                    if (MMFormVerifyCodeInputView.this.mLV != null) {
                        MMFormVerifyCodeInputView.this.mLV.onFocusChange(view, z);
                    }
                    AppMethodBeat.o(106592);
                }
            });
        }
        if (this.gGm != null) {
            this.gGm.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(106593);
                    if (MMFormVerifyCodeInputView.this.yux != null) {
                        MMFormVerifyCodeInputView.this.yux.onClick(view);
                    }
                    AppMethodBeat.o(106593);
                }
            });
        }
        AppMethodBeat.o(106596);
    }

    public void setFocusListener(OnFocusChangeListener onFocusChangeListener) {
        this.mLV = onFocusChangeListener;
    }

    public void setSendSmsBtnClickListener(OnClickListener onClickListener) {
        this.yux = onClickListener;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(106597);
        if (this.gnB != null) {
            this.gnB.setText(str);
            AppMethodBeat.o(106597);
            return;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
        AppMethodBeat.o(106597);
    }

    public void setHint(String str) {
        AppMethodBeat.i(106598);
        if (this.pwu != null) {
            this.pwu.setHint(str);
            AppMethodBeat.o(106598);
            return;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(106598);
    }

    public void setTitle(int i) {
        AppMethodBeat.i(106599);
        if (this.gnB != null) {
            this.gnB.setText(i);
            AppMethodBeat.o(106599);
            return;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
        AppMethodBeat.o(106599);
    }

    public void setHint(int i) {
        AppMethodBeat.i(106600);
        if (this.pwu != null) {
            this.pwu.setHint(i);
            AppMethodBeat.o(106600);
            return;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(106600);
    }

    public void setText(String str) {
        AppMethodBeat.i(106601);
        if (this.pwu != null) {
            this.pwu.setText(str);
            AppMethodBeat.o(106601);
            return;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(106601);
    }

    public void setImeOption(int i) {
        AppMethodBeat.i(106602);
        if (this.pwu != null) {
            this.pwu.setImeOptions(i);
            AppMethodBeat.o(106602);
            return;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(106602);
    }

    public void setSmsBtnText(int i) {
        AppMethodBeat.i(106603);
        if (this.gGm != null) {
            this.gGm.setText(i);
            AppMethodBeat.o(106603);
            return;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        AppMethodBeat.o(106603);
    }

    public void setSmsBtnText(String str) {
        AppMethodBeat.i(106604);
        if (this.gGm != null) {
            this.gGm.setText(str);
            AppMethodBeat.o(106604);
            return;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        AppMethodBeat.o(106604);
    }

    public final void dzH() {
        AppMethodBeat.i(106605);
        this.gGm.setVisibility(8);
        this.yut.setVisibility(0);
        this.yut.setText(getContext().getString(R.string.d0o, new Object[]{Integer.valueOf(this.yuv)}));
        if (this.fNJ != null) {
            this.fNJ.stopTimer();
            this.fNJ.ae(1000, 1000);
            AppMethodBeat.o(106605);
        } else if (getContext() != null) {
            this.fNJ = new ap(getContext().getMainLooper(), new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(106594);
                    MMFormVerifyCodeInputView.this.yuw = MMFormVerifyCodeInputView.this.yuw - 1;
                    MMFormVerifyCodeInputView.this.yut.setText(MMFormVerifyCodeInputView.this.getContext().getString(R.string.d0o, new Object[]{Integer.valueOf(MMFormVerifyCodeInputView.this.yuw)}));
                    if (MMFormVerifyCodeInputView.this.yuw == 0) {
                        MMFormVerifyCodeInputView.this.fNJ.stopTimer();
                        MMFormVerifyCodeInputView.this.yuw = MMFormVerifyCodeInputView.this.yuv;
                        MMFormVerifyCodeInputView.this.gGm.setVisibility(0);
                        MMFormVerifyCodeInputView.this.yut.setVisibility(8);
                    }
                    AppMethodBeat.o(106594);
                    return true;
                }
            }, true);
            this.fNJ.ae(1000, 1000);
            AppMethodBeat.o(106605);
        } else {
            if (this.fNJ != null) {
                this.fNJ.stopTimer();
            }
            AppMethodBeat.o(106605);
        }
    }

    public final void reset() {
        AppMethodBeat.i(106606);
        if (this.fNJ != null) {
            this.fNJ.stopTimer();
        }
        this.pwu.setText("");
        this.yut.setVisibility(8);
        this.yuw = this.yuv;
        this.gGm.setVisibility(0);
        AppMethodBeat.o(106606);
    }

    public void setInputType(int i) {
        AppMethodBeat.i(106607);
        if (this.pwu != null) {
            this.pwu.setInputType(i);
            AppMethodBeat.o(106607);
            return;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(106607);
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(106608);
        if (this.pwu != null) {
            this.pwu.addTextChangedListener(textWatcher);
            AppMethodBeat.o(106608);
            return;
        }
        ab.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", textWatcher, this.pwu);
        AppMethodBeat.o(106608);
    }

    public Editable getText() {
        AppMethodBeat.i(106609);
        if (this.pwu != null) {
            Editable text = this.pwu.getText();
            AppMethodBeat.o(106609);
            return text;
        }
        ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.o(106609);
        return null;
    }

    public EditText getContentEditText() {
        return this.pwu;
    }

    public TextView getTitleTextView() {
        return this.gnB;
    }

    static /* synthetic */ void b(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        AppMethodBeat.i(106610);
        mMFormVerifyCodeInputView.yuk = new int[]{mMFormVerifyCodeInputView.getPaddingLeft(), mMFormVerifyCodeInputView.getPaddingTop(), mMFormVerifyCodeInputView.getPaddingRight(), mMFormVerifyCodeInputView.getPaddingBottom()};
        AppMethodBeat.o(106610);
    }

    static /* synthetic */ void c(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        AppMethodBeat.i(106611);
        if (mMFormVerifyCodeInputView.yuk != null) {
            mMFormVerifyCodeInputView.setPadding(mMFormVerifyCodeInputView.yuk[0], mMFormVerifyCodeInputView.yuk[1], mMFormVerifyCodeInputView.yuk[2], mMFormVerifyCodeInputView.yuk[3]);
        }
        AppMethodBeat.o(106611);
    }
}
