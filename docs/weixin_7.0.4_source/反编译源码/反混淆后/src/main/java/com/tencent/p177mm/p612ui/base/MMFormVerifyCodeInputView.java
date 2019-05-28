package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.ui.base.MMFormVerifyCodeInputView */
public class MMFormVerifyCodeInputView extends LinearLayout {
    private C7564ap fNJ;
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

    /* renamed from: com.tencent.mm.ui.base.MMFormVerifyCodeInputView$1 */
    class C235841 implements OnFocusChangeListener {
        C235841() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(106592);
            if (view == MMFormVerifyCodeInputView.this.pwu) {
                MMFormVerifyCodeInputView.m48395b(MMFormVerifyCodeInputView.this);
                if (z) {
                    MMFormVerifyCodeInputView.this.setBackgroundResource(C25738R.drawable.b77);
                } else {
                    MMFormVerifyCodeInputView.this.setBackgroundResource(C25738R.drawable.b78);
                }
                MMFormVerifyCodeInputView.m48396c(MMFormVerifyCodeInputView.this);
            }
            if (MMFormVerifyCodeInputView.this.mLV != null) {
                MMFormVerifyCodeInputView.this.mLV.onFocusChange(view, z);
            }
            AppMethodBeat.m2505o(106592);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMFormVerifyCodeInputView$2 */
    class C235852 implements OnClickListener {
        C235852() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(106593);
            if (MMFormVerifyCodeInputView.this.yux != null) {
                MMFormVerifyCodeInputView.this.yux.onClick(view);
            }
            AppMethodBeat.m2505o(106593);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMFormVerifyCodeInputView$3 */
    class C303683 implements C5015a {
        C303683() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(106594);
            MMFormVerifyCodeInputView.this.yuw = MMFormVerifyCodeInputView.this.yuw - 1;
            MMFormVerifyCodeInputView.this.yut.setText(MMFormVerifyCodeInputView.this.getContext().getString(C25738R.string.d0o, new Object[]{Integer.valueOf(MMFormVerifyCodeInputView.this.yuw)}));
            if (MMFormVerifyCodeInputView.this.yuw == 0) {
                MMFormVerifyCodeInputView.this.fNJ.stopTimer();
                MMFormVerifyCodeInputView.this.yuw = MMFormVerifyCodeInputView.this.yuv;
                MMFormVerifyCodeInputView.this.gGm.setVisibility(0);
                MMFormVerifyCodeInputView.this.yut.setVisibility(8);
            }
            AppMethodBeat.m2505o(106594);
            return true;
        }
    }

    @TargetApi(11)
    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106595);
        this.mContext = null;
        this.vaH = -1;
        this.yuj = -1;
        this.yuu = -1;
        this.layout = -1;
        this.yuv = 60;
        this.yuw = this.yuv;
        this.mLV = null;
        this.yux = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.FormItemView, i, 0);
        this.yuj = obtainStyledAttributes.getResourceId(2, -1);
        this.vaH = obtainStyledAttributes.getResourceId(1, -1);
        this.yuu = obtainStyledAttributes.getResourceId(3, -1);
        this.layout = obtainStyledAttributes.getResourceId(0, this.layout);
        obtainStyledAttributes.recycle();
        MMFormVerifyCodeInputView.inflate(context, this.layout, this);
        this.mContext = context;
        AppMethodBeat.m2505o(106595);
    }

    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        AppMethodBeat.m2504i(106596);
        super.onFinishInflate();
        this.gnB = (TextView) findViewById(2131820678);
        this.pwu = (EditText) findViewById(2131820980);
        this.yut = (TextView) findViewById(2131826000);
        this.gGm = (Button) findViewById(2131825999);
        if (this.gnB == null || this.pwu == null || this.yut == null || this.gGm == null) {
            C4990ab.m7421w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", this.gnB, this.pwu, this.yut, this.gGm);
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
            this.pwu.setOnFocusChangeListener(new C235841());
        }
        if (this.gGm != null) {
            this.gGm.setOnClickListener(new C235852());
        }
        AppMethodBeat.m2505o(106596);
    }

    public void setFocusListener(OnFocusChangeListener onFocusChangeListener) {
        this.mLV = onFocusChangeListener;
    }

    public void setSendSmsBtnClickListener(OnClickListener onClickListener) {
        this.yux = onClickListener;
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(106597);
        if (this.gnB != null) {
            this.gnB.setText(str);
            AppMethodBeat.m2505o(106597);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
        AppMethodBeat.m2505o(106597);
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(106598);
        if (this.pwu != null) {
            this.pwu.setHint(str);
            AppMethodBeat.m2505o(106598);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.m2505o(106598);
    }

    public void setTitle(int i) {
        AppMethodBeat.m2504i(106599);
        if (this.gnB != null) {
            this.gnB.setText(i);
            AppMethodBeat.m2505o(106599);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
        AppMethodBeat.m2505o(106599);
    }

    public void setHint(int i) {
        AppMethodBeat.m2504i(106600);
        if (this.pwu != null) {
            this.pwu.setHint(i);
            AppMethodBeat.m2505o(106600);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.m2505o(106600);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(106601);
        if (this.pwu != null) {
            this.pwu.setText(str);
            AppMethodBeat.m2505o(106601);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.m2505o(106601);
    }

    public void setImeOption(int i) {
        AppMethodBeat.m2504i(106602);
        if (this.pwu != null) {
            this.pwu.setImeOptions(i);
            AppMethodBeat.m2505o(106602);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.m2505o(106602);
    }

    public void setSmsBtnText(int i) {
        AppMethodBeat.m2504i(106603);
        if (this.gGm != null) {
            this.gGm.setText(i);
            AppMethodBeat.m2505o(106603);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        AppMethodBeat.m2505o(106603);
    }

    public void setSmsBtnText(String str) {
        AppMethodBeat.m2504i(106604);
        if (this.gGm != null) {
            this.gGm.setText(str);
            AppMethodBeat.m2505o(106604);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
        AppMethodBeat.m2505o(106604);
    }

    public final void dzH() {
        AppMethodBeat.m2504i(106605);
        this.gGm.setVisibility(8);
        this.yut.setVisibility(0);
        this.yut.setText(getContext().getString(C25738R.string.d0o, new Object[]{Integer.valueOf(this.yuv)}));
        if (this.fNJ != null) {
            this.fNJ.stopTimer();
            this.fNJ.mo16770ae(1000, 1000);
            AppMethodBeat.m2505o(106605);
        } else if (getContext() != null) {
            this.fNJ = new C7564ap(getContext().getMainLooper(), new C303683(), true);
            this.fNJ.mo16770ae(1000, 1000);
            AppMethodBeat.m2505o(106605);
        } else {
            if (this.fNJ != null) {
                this.fNJ.stopTimer();
            }
            AppMethodBeat.m2505o(106605);
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(106606);
        if (this.fNJ != null) {
            this.fNJ.stopTimer();
        }
        this.pwu.setText("");
        this.yut.setVisibility(8);
        this.yuw = this.yuv;
        this.gGm.setVisibility(0);
        AppMethodBeat.m2505o(106606);
    }

    public void setInputType(int i) {
        AppMethodBeat.m2504i(106607);
        if (this.pwu != null) {
            this.pwu.setInputType(i);
            AppMethodBeat.m2505o(106607);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.m2505o(106607);
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        AppMethodBeat.m2504i(106608);
        if (this.pwu != null) {
            this.pwu.addTextChangedListener(textWatcher);
            AppMethodBeat.m2505o(106608);
            return;
        }
        C4990ab.m7421w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", textWatcher, this.pwu);
        AppMethodBeat.m2505o(106608);
    }

    public Editable getText() {
        AppMethodBeat.m2504i(106609);
        if (this.pwu != null) {
            Editable text = this.pwu.getText();
            AppMethodBeat.m2505o(106609);
            return text;
        }
        C4990ab.m7412e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        AppMethodBeat.m2505o(106609);
        return null;
    }

    public EditText getContentEditText() {
        return this.pwu;
    }

    public TextView getTitleTextView() {
        return this.gnB;
    }

    /* renamed from: b */
    static /* synthetic */ void m48395b(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        AppMethodBeat.m2504i(106610);
        mMFormVerifyCodeInputView.yuk = new int[]{mMFormVerifyCodeInputView.getPaddingLeft(), mMFormVerifyCodeInputView.getPaddingTop(), mMFormVerifyCodeInputView.getPaddingRight(), mMFormVerifyCodeInputView.getPaddingBottom()};
        AppMethodBeat.m2505o(106610);
    }

    /* renamed from: c */
    static /* synthetic */ void m48396c(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        AppMethodBeat.m2504i(106611);
        if (mMFormVerifyCodeInputView.yuk != null) {
            mMFormVerifyCodeInputView.setPadding(mMFormVerifyCodeInputView.yuk[0], mMFormVerifyCodeInputView.yuk[1], mMFormVerifyCodeInputView.yuk[2], mMFormVerifyCodeInputView.yuk[3]);
        }
        AppMethodBeat.m2505o(106611);
    }
}
