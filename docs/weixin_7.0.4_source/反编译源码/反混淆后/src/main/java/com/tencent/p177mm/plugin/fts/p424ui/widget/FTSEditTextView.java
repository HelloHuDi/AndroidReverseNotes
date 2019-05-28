package com.tencent.p177mm.plugin.fts.p424ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.p627e.p628c.C5509b;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.plugin.fts.p424ui.widget.C43138a.C12071b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView */
public class FTSEditTextView extends LinearLayout {
    private String hint;
    private ImageView iqT;
    private List<C12071b> kPL;
    public EditText mLL;
    private TextView mLM;
    private TextView mLN;
    private TextView mLO;
    private View mLP;
    private boolean mLQ = true;
    private String mLR = "";
    private OnClickListener mLS = new C208886();
    private C20892a mLT;
    private C20890b mLU = C20890b.UserInput;
    protected OnFocusChangeListener mLV = new C208897();
    private ImageButton mpR;

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$2 */
    class C208842 implements TextWatcher {
        C208842() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(62106);
            String totalQuery = FTSEditTextView.this.getTotalQuery();
            if (!(totalQuery == FTSEditTextView.this.mLR || totalQuery.equals(FTSEditTextView.this.mLR))) {
                FTSEditTextView.this.mLR = totalQuery;
                if (totalQuery.length() > 0) {
                    FTSEditTextView.this.mpR.setVisibility(0);
                } else {
                    FTSEditTextView.this.mpR.setVisibility(8);
                }
                FTSEditTextView.m32124e(FTSEditTextView.this);
            }
            AppMethodBeat.m2505o(62106);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$1 */
    class C208851 implements OnKeyListener {
        C208851() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(62105);
            if (keyEvent.getAction() == 0 && 67 == i) {
                int selectionStart = FTSEditTextView.this.mLL.getSelectionStart();
                int selectionEnd = FTSEditTextView.this.mLL.getSelectionEnd();
                if (selectionStart == 0 && selectionEnd == 0 && FTSEditTextView.this.kPL.size() > 0 && FTSEditTextView.this.mLQ) {
                    FTSEditTextView.this.kPL.remove(FTSEditTextView.this.kPL.size() - 1);
                    FTSEditTextView.m32123d(FTSEditTextView.this);
                    FTSEditTextView.m32124e(FTSEditTextView.this);
                }
            }
            AppMethodBeat.m2505o(62105);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$3 */
    class C208863 implements OnEditorActionListener {
        C208863() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(62107);
            if (3 != i || FTSEditTextView.this.mLT == null) {
                AppMethodBeat.m2505o(62107);
                return false;
            }
            boolean aMo = FTSEditTextView.this.mLT.aMo();
            AppMethodBeat.m2505o(62107);
            return aMo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$4 */
    class C208874 implements OnClickListener {
        C208874() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(62108);
            FTSEditTextView.this.clearText();
            if (FTSEditTextView.this.mLT != null) {
                FTSEditTextView.this.mLT.onClickClearTextBtn(view);
            }
            AppMethodBeat.m2505o(62108);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$6 */
    class C208886 implements OnClickListener {
        C208886() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(62110);
            int i = -1;
            if (view.getId() == 2131824220) {
                i = 0;
            } else if (view.getId() == 2131824221) {
                i = 1;
            } else if (view.getId() == 2131824222) {
                i = 2;
            }
            if (FTSEditTextView.this.mLT != null && i >= 0) {
                C20892a h = FTSEditTextView.this.mLT;
                FTSEditTextView.this.kPL.get(i);
                h.bAR();
            }
            AppMethodBeat.m2505o(62110);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$7 */
    class C208897 implements OnFocusChangeListener {
        C208897() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(62111);
            if (FTSEditTextView.this.mLT != null) {
                FTSEditTextView.this.mLT.mo25276hz(z);
            }
            AppMethodBeat.m2505o(62111);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$b */
    public enum C20890b {
        UserInput,
        ClearText,
        SetText;

        static {
            AppMethodBeat.m2505o(62114);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$5 */
    class C208915 implements Runnable {
        C208915() {
        }

        public final void run() {
            AppMethodBeat.m2504i(62109);
            ((InputMethodManager) FTSEditTextView.this.getContext().getSystemService("input_method")).showSoftInput(FTSEditTextView.this.mLL, 0);
            AppMethodBeat.m2505o(62109);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView$a */
    public interface C20892a {
        /* renamed from: a */
        void mo6403a(String str, String str2, List<C12071b> list, C20890b c20890b);

        boolean aMo();

        void bAR();

        /* renamed from: hz */
        void mo25276hz(boolean z);

        void onClickClearTextBtn(View view);
    }

    /* renamed from: d */
    static /* synthetic */ void m32123d(FTSEditTextView fTSEditTextView) {
        AppMethodBeat.m2504i(62134);
        fTSEditTextView.bBp();
        AppMethodBeat.m2505o(62134);
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(62115);
        init();
        AppMethodBeat.m2505o(62115);
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(62116);
        init();
        AppMethodBeat.m2505o(62116);
    }

    /* Access modifiers changed, original: protected */
    public void bBm() {
        AppMethodBeat.m2504i(62117);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130969619, this, true);
        AppMethodBeat.m2505o(62117);
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        AppMethodBeat.m2504i(62118);
        bBm();
        this.mLP = findViewById(2131824219);
        this.iqT = (ImageView) findViewById(2131820915);
        this.mLL = (EditText) findViewById(2131820980);
        this.mpR = (ImageButton) findViewById(2131820976);
        this.mLM = (TextView) findViewById(2131824220);
        this.mLN = (TextView) findViewById(2131824221);
        this.mLO = (TextView) findViewById(2131824222);
        this.kPL = new ArrayList();
        this.mLL.setOnKeyListener(new C208851());
        this.mLL.addTextChangedListener(new C208842());
        this.mLL.setOnFocusChangeListener(this.mLV);
        this.mLL.setOnEditorActionListener(new C208863());
        this.mLM.setOnClickListener(this.mLS);
        this.mLN.setOnClickListener(this.mLS);
        this.mLO.setOnClickListener(this.mLS);
        this.mpR.setOnClickListener(new C208874());
        C7357c.m12555d(this.mLL).mo15877PM(100).mo15879a(null);
        AppMethodBeat.m2505o(62118);
    }

    public final void clearText() {
        AppMethodBeat.m2504i(62119);
        this.mLU = C20890b.ClearText;
        if (this.mLQ) {
            this.kPL.clear();
        }
        this.mLL.setText("");
        this.mLL.setHint(this.hint);
        this.mpR.setVisibility(8);
        bBp();
        this.mLU = C20890b.UserInput;
        AppMethodBeat.m2505o(62119);
    }

    public void setEditTextDrawableLeft(int i) {
        AppMethodBeat.m2504i(62120);
        if (i == -1) {
            this.mLL.setCompoundDrawablesRelative(null, null, null, null);
            AppMethodBeat.m2505o(62120);
            return;
        }
        Drawable drawable = getContext().getResources().getDrawable(i);
        drawable.setBounds(0, 0, C1338a.fromDPToPix(getContext(), 15), C1338a.fromDPToPix(getContext(), 15));
        this.mLL.setCompoundDrawablesRelative(drawable, null, null, null);
        AppMethodBeat.m2505o(62120);
    }

    public final void bBn() {
        AppMethodBeat.m2504i(62121);
        postDelayed(new C208915(), 128);
        AppMethodBeat.m2505o(62121);
    }

    public int getHighlightColor() {
        AppMethodBeat.m2504i(62122);
        int highlightColor = this.mLL.getHighlightColor();
        AppMethodBeat.m2505o(62122);
        return highlightColor;
    }

    /* renamed from: n */
    public final void mo36173n(String str, List<C12071b> list) {
        AppMethodBeat.m2504i(62123);
        m32120a(str, list, C20890b.UserInput);
        AppMethodBeat.m2505o(62123);
    }

    /* renamed from: a */
    private void m32120a(String str, List<C12071b> list, C20890b c20890b) {
        AppMethodBeat.m2504i(62124);
        this.kPL.clear();
        if (list != null) {
            this.kPL.addAll(list);
        }
        C4990ab.m7417i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", str, Integer.valueOf(this.kPL.size()));
        this.mLU = C20890b.SetText;
        this.mLL.setText(str);
        Selection.setSelection(this.mLL.getText(), this.mLL.getText().length());
        bBp();
        this.mLU = c20890b;
        AppMethodBeat.m2505o(62124);
    }

    public final void bBo() {
        AppMethodBeat.m2504i(62125);
        this.mLL.requestFocus();
        AppMethodBeat.m2505o(62125);
    }

    public List<C12071b> getTagList() {
        return this.kPL;
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(62126);
        this.mLL.setHint(str);
        this.hint = str;
        AppMethodBeat.m2505o(62126);
    }

    private void bBp() {
        AppMethodBeat.m2504i(62127);
        C4990ab.m7417i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", Integer.valueOf(this.kPL.size()));
        float al = (float) C1338a.m2856al(getContext(), C25738R.dimen.f9980m5);
        if (this.kPL.size() > 0) {
            this.mLM.setVisibility(0);
            this.mLM.setText(C5509b.m8295c(getContext(), ((C12071b) this.kPL.get(0)).getTagName(), al));
        } else {
            this.mLM.setVisibility(8);
        }
        if (this.kPL.size() >= 2) {
            this.mLN.setVisibility(0);
            this.mLN.setText(C5509b.m8295c(getContext(), ((C12071b) this.kPL.get(1)).getTagName(), al));
        } else {
            this.mLN.setVisibility(8);
        }
        if (this.kPL.size() >= 3) {
            this.mLO.setVisibility(0);
            this.mLO.setText(C5509b.m8295c(getContext(), ((C12071b) this.kPL.get(2)).getTagName(), al));
            AppMethodBeat.m2505o(62127);
            return;
        }
        this.mLO.setVisibility(8);
        AppMethodBeat.m2505o(62127);
    }

    public ImageView getIconView() {
        return this.iqT;
    }

    public EditText getEditText() {
        return this.mLL;
    }

    public ImageButton getClearBtn() {
        return this.mpR;
    }

    public void setFtsEditTextListener(C20892a c20892a) {
        this.mLT = c20892a;
    }

    public String getInEditTextQuery() {
        AppMethodBeat.m2504i(62128);
        String trim = this.mLL.getText().toString().trim();
        AppMethodBeat.m2505o(62128);
        return trim;
    }

    public String getTotalQuery() {
        AppMethodBeat.m2504i(62129);
        StringBuffer stringBuffer = new StringBuffer();
        for (C12071b tagName : this.kPL) {
            stringBuffer.append(tagName.getTagName());
            stringBuffer.append(" ");
        }
        stringBuffer.append(this.mLL.getText().toString());
        String trim = stringBuffer.toString().trim();
        AppMethodBeat.m2505o(62129);
        return trim;
    }

    public final void bBq() {
        AppMethodBeat.m2504i(62130);
        this.iqT.setVisibility(8);
        AppMethodBeat.m2505o(62130);
    }

    public final void bBr() {
        AppMethodBeat.m2504i(62131);
        this.iqT.setVisibility(0);
        AppMethodBeat.m2505o(62131);
    }

    public final void bBs() {
        AppMethodBeat.m2504i(62132);
        this.mpR.setVisibility(8);
        AppMethodBeat.m2505o(62132);
    }

    public final void bBt() {
        AppMethodBeat.m2504i(62133);
        this.mpR.setVisibility(0);
        AppMethodBeat.m2505o(62133);
    }

    public View getTagPanel() {
        return this.mLP;
    }

    public C20890b getTextChangeStatus() {
        return this.mLU;
    }

    public void setCanDeleteTag(boolean z) {
        this.mLQ = z;
    }

    /* renamed from: e */
    static /* synthetic */ void m32124e(FTSEditTextView fTSEditTextView) {
        AppMethodBeat.m2504i(62135);
        String inEditTextQuery = fTSEditTextView.getInEditTextQuery();
        if (fTSEditTextView.mLT != null) {
            fTSEditTextView.mLT.mo6403a(fTSEditTextView.getTotalQuery(), inEditTextQuery, fTSEditTextView.kPL, fTSEditTextView.mLU);
        }
        if (inEditTextQuery.length() == 0) {
            fTSEditTextView.mLL.setHint(fTSEditTextView.hint);
        }
        AppMethodBeat.m2505o(62135);
    }
}
