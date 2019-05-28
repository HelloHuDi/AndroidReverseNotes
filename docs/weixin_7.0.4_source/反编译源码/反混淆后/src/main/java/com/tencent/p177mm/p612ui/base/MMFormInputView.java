package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.MMFormInputView */
public class MMFormInputView extends LinearLayout {
    private TextView gnB;
    private int layout;
    private Context mContext;
    private OnFocusChangeListener mLV;
    private EditText pwu;
    private int vaH;
    private int yuj;
    private int[] yuk;

    /* renamed from: com.tencent.mm.ui.base.MMFormInputView$1 */
    class C52521 implements OnFocusChangeListener {
        C52521() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(106556);
            if (view == MMFormInputView.this.pwu) {
                MMFormInputView.m8024b(MMFormInputView.this);
                if (z) {
                    MMFormInputView.this.setBackgroundResource(C25738R.drawable.b77);
                } else {
                    MMFormInputView.this.setBackgroundResource(C25738R.drawable.b78);
                }
                MMFormInputView.m8025c(MMFormInputView.this);
            }
            if (MMFormInputView.this.mLV != null) {
                MMFormInputView.this.mLV.onFocusChange(view, z);
            }
            AppMethodBeat.m2505o(106556);
        }
    }

    @TargetApi(11)
    public MMFormInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106557);
        this.mContext = null;
        this.vaH = -1;
        this.yuj = -1;
        this.layout = -1;
        this.mLV = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.FormItemView, i, 0);
        this.yuj = obtainStyledAttributes.getResourceId(2, -1);
        this.vaH = obtainStyledAttributes.getResourceId(1, -1);
        this.layout = obtainStyledAttributes.getResourceId(0, this.layout);
        obtainStyledAttributes.recycle();
        MMFormInputView.inflate(context, this.layout, this);
        this.mContext = context;
        AppMethodBeat.m2505o(106557);
    }

    public MMFormInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setFocusListener(OnFocusChangeListener onFocusChangeListener) {
        this.mLV = onFocusChangeListener;
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(106559);
        if (this.gnB != null) {
            this.gnB.setText(str);
            AppMethodBeat.m2505o(106559);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormInputView", "titleTV is null!");
        AppMethodBeat.m2505o(106559);
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(106560);
        if (this.pwu != null) {
            this.pwu.setHint(str);
            AppMethodBeat.m2505o(106560);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.m2505o(106560);
    }

    public void setTitle(int i) {
        AppMethodBeat.m2504i(106561);
        if (this.gnB != null) {
            this.gnB.setText(i);
            AppMethodBeat.m2505o(106561);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormInputView", "titleTV is null!");
        AppMethodBeat.m2505o(106561);
    }

    public void setHint(int i) {
        AppMethodBeat.m2504i(106562);
        if (this.pwu != null) {
            this.pwu.setHint(i);
            AppMethodBeat.m2505o(106562);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.m2505o(106562);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(106563);
        if (this.pwu != null) {
            this.pwu.setText(str);
            AppMethodBeat.m2505o(106563);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.m2505o(106563);
    }

    public void setImeOption(int i) {
        AppMethodBeat.m2504i(106564);
        if (this.pwu != null) {
            this.pwu.setImeOptions(i);
            AppMethodBeat.m2505o(106564);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.m2505o(106564);
    }

    public void setInputType(int i) {
        AppMethodBeat.m2504i(106565);
        if (this.pwu != null) {
            this.pwu.setInputType(i);
            AppMethodBeat.m2505o(106565);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.m2505o(106565);
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.m2504i(106566);
        if (textWatcher == null || this.pwu == null) {
            C4990ab.m7421w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", textWatcher, this.pwu);
            AppMethodBeat.m2505o(106566);
            return;
        }
        this.pwu.addTextChangedListener(textWatcher);
        AppMethodBeat.m2505o(106566);
    }

    public Editable getText() {
        AppMethodBeat.m2504i(106567);
        if (this.pwu != null) {
            Editable text = this.pwu.getText();
            AppMethodBeat.m2505o(106567);
            return text;
        }
        C4990ab.m7412e("MicroMsg.MMFormInputView", "contentET is null!");
        AppMethodBeat.m2505o(106567);
        return null;
    }

    public EditText getContentEditText() {
        return this.pwu;
    }

    public TextView getTitleTextView() {
        return this.gnB;
    }

    public void onFinishInflate() {
        AppMethodBeat.m2504i(106558);
        this.gnB = (TextView) findViewById(2131820678);
        this.pwu = (EditText) findViewById(2131820980);
        if (this.gnB == null || this.pwu == null) {
            C4990ab.m7421w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", this.gnB, this.pwu);
        } else {
            if (this.vaH != -1) {
                this.gnB.setText(this.vaH);
            }
            if (this.yuj != -1) {
                this.pwu.setHint(this.yuj);
            }
        }
        if (this.pwu != null) {
            this.pwu.setOnFocusChangeListener(new C52521());
        }
        AppMethodBeat.m2505o(106558);
    }

    /* renamed from: b */
    static /* synthetic */ void m8024b(MMFormInputView mMFormInputView) {
        AppMethodBeat.m2504i(106568);
        mMFormInputView.yuk = new int[]{mMFormInputView.getPaddingLeft(), mMFormInputView.getPaddingTop(), mMFormInputView.getPaddingRight(), mMFormInputView.getPaddingBottom()};
        AppMethodBeat.m2505o(106568);
    }

    /* renamed from: c */
    static /* synthetic */ void m8025c(MMFormInputView mMFormInputView) {
        AppMethodBeat.m2504i(106569);
        if (mMFormInputView.yuk != null) {
            mMFormInputView.setPadding(mMFormInputView.yuk[0], mMFormInputView.yuk[1], mMFormInputView.yuk[2], mMFormInputView.yuk[3]);
        }
        AppMethodBeat.m2505o(106569);
    }
}
