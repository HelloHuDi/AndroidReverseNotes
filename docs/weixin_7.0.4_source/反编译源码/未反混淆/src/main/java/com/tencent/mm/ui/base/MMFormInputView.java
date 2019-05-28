package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMFormInputView extends LinearLayout {
    private TextView gnB;
    private int layout;
    private Context mContext;
    private OnFocusChangeListener mLV;
    private EditText pwu;
    private int vaH;
    private int yuj;
    private int[] yuk;

    @TargetApi(11)
    public MMFormInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(106557);
        this.mContext = null;
        this.vaH = -1;
        this.yuj = -1;
        this.layout = -1;
        this.mLV = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.FormItemView, i, 0);
        this.yuj = obtainStyledAttributes.getResourceId(2, -1);
        this.vaH = obtainStyledAttributes.getResourceId(1, -1);
        this.layout = obtainStyledAttributes.getResourceId(0, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
        AppMethodBeat.o(106557);
    }

    public MMFormInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setFocusListener(OnFocusChangeListener onFocusChangeListener) {
        this.mLV = onFocusChangeListener;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(106559);
        if (this.gnB != null) {
            this.gnB.setText(str);
            AppMethodBeat.o(106559);
            return;
        }
        ab.e("MicroMsg.MMFormInputView", "titleTV is null!");
        AppMethodBeat.o(106559);
    }

    public void setHint(String str) {
        AppMethodBeat.i(106560);
        if (this.pwu != null) {
            this.pwu.setHint(str);
            AppMethodBeat.o(106560);
            return;
        }
        ab.e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.o(106560);
    }

    public void setTitle(int i) {
        AppMethodBeat.i(106561);
        if (this.gnB != null) {
            this.gnB.setText(i);
            AppMethodBeat.o(106561);
            return;
        }
        ab.e("MicroMsg.MMFormInputView", "titleTV is null!");
        AppMethodBeat.o(106561);
    }

    public void setHint(int i) {
        AppMethodBeat.i(106562);
        if (this.pwu != null) {
            this.pwu.setHint(i);
            AppMethodBeat.o(106562);
            return;
        }
        ab.e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.o(106562);
    }

    public void setText(String str) {
        AppMethodBeat.i(106563);
        if (this.pwu != null) {
            this.pwu.setText(str);
            AppMethodBeat.o(106563);
            return;
        }
        ab.e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.o(106563);
    }

    public void setImeOption(int i) {
        AppMethodBeat.i(106564);
        if (this.pwu != null) {
            this.pwu.setImeOptions(i);
            AppMethodBeat.o(106564);
            return;
        }
        ab.e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.o(106564);
    }

    public void setInputType(int i) {
        AppMethodBeat.i(106565);
        if (this.pwu != null) {
            this.pwu.setInputType(i);
            AppMethodBeat.o(106565);
            return;
        }
        ab.e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.o(106565);
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.i(106566);
        if (textWatcher == null || this.pwu == null) {
            ab.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", textWatcher, this.pwu);
            AppMethodBeat.o(106566);
            return;
        }
        this.pwu.addTextChangedListener(textWatcher);
        AppMethodBeat.o(106566);
    }

    public Editable getText() {
        AppMethodBeat.i(106567);
        if (this.pwu != null) {
            Editable text = this.pwu.getText();
            AppMethodBeat.o(106567);
            return text;
        }
        ab.e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.o(106567);
        return null;
    }

    public EditText getContentEditText() {
        return this.pwu;
    }

    public TextView getTitleTextView() {
        return this.gnB;
    }

    public void onFinishInflate() {
        AppMethodBeat.i(106558);
        this.gnB = (TextView) findViewById(R.id.cx);
        this.pwu = (EditText) findViewById(R.id.l3);
        if (this.gnB == null || this.pwu == null) {
            ab.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", this.gnB, this.pwu);
        } else {
            if (this.vaH != -1) {
                this.gnB.setText(this.vaH);
            }
            if (this.yuj != -1) {
                this.pwu.setHint(this.yuj);
            }
        }
        if (this.pwu != null) {
            this.pwu.setOnFocusChangeListener(new OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(106556);
                    if (view == MMFormInputView.this.pwu) {
                        MMFormInputView.b(MMFormInputView.this);
                        if (z) {
                            MMFormInputView.this.setBackgroundResource(R.drawable.b77);
                        } else {
                            MMFormInputView.this.setBackgroundResource(R.drawable.b78);
                        }
                        MMFormInputView.c(MMFormInputView.this);
                    }
                    if (MMFormInputView.this.mLV != null) {
                        MMFormInputView.this.mLV.onFocusChange(view, z);
                    }
                    AppMethodBeat.o(106556);
                }
            });
        }
        AppMethodBeat.o(106558);
    }

    static /* synthetic */ void b(MMFormInputView mMFormInputView) {
        AppMethodBeat.i(106568);
        mMFormInputView.yuk = new int[]{mMFormInputView.getPaddingLeft(), mMFormInputView.getPaddingTop(), mMFormInputView.getPaddingRight(), mMFormInputView.getPaddingBottom()};
        AppMethodBeat.o(106568);
    }

    static /* synthetic */ void c(MMFormInputView mMFormInputView) {
        AppMethodBeat.i(106569);
        if (mMFormInputView.yuk != null) {
            mMFormInputView.setPadding(mMFormInputView.yuk[0], mMFormInputView.yuk[1], mMFormInputView.yuk[2], mMFormInputView.yuk[3]);
        }
        AppMethodBeat.o(106569);
    }
}
