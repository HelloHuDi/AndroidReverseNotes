package com.tencent.mm.plugin.fts.ui.widget;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.b.c;
import java.util.ArrayList;
import java.util.List;

public class FTSEditTextView extends LinearLayout {
    private String hint;
    private ImageView iqT;
    private List<com.tencent.mm.plugin.fts.ui.widget.a.b> kPL;
    public EditText mLL;
    private TextView mLM;
    private TextView mLN;
    private TextView mLO;
    private View mLP;
    private boolean mLQ = true;
    private String mLR = "";
    private OnClickListener mLS = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(62110);
            int i = -1;
            if (view.getId() == R.id.byc) {
                i = 0;
            } else if (view.getId() == R.id.byd) {
                i = 1;
            } else if (view.getId() == R.id.bye) {
                i = 2;
            }
            if (FTSEditTextView.this.mLT != null && i >= 0) {
                a h = FTSEditTextView.this.mLT;
                FTSEditTextView.this.kPL.get(i);
                h.bAR();
            }
            AppMethodBeat.o(62110);
        }
    };
    private a mLT;
    private b mLU = b.UserInput;
    protected OnFocusChangeListener mLV = new OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(62111);
            if (FTSEditTextView.this.mLT != null) {
                FTSEditTextView.this.mLT.hz(z);
            }
            AppMethodBeat.o(62111);
        }
    };
    private ImageButton mpR;

    public enum b {
        UserInput,
        ClearText,
        SetText;

        static {
            AppMethodBeat.o(62114);
        }
    }

    public interface a {
        void a(String str, String str2, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, b bVar);

        boolean aMo();

        void bAR();

        void hz(boolean z);

        void onClickClearTextBtn(View view);
    }

    static /* synthetic */ void d(FTSEditTextView fTSEditTextView) {
        AppMethodBeat.i(62134);
        fTSEditTextView.bBp();
        AppMethodBeat.o(62134);
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(62115);
        init();
        AppMethodBeat.o(62115);
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(62116);
        init();
        AppMethodBeat.o(62116);
    }

    /* Access modifiers changed, original: protected */
    public void bBm() {
        AppMethodBeat.i(62117);
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.a1d, this, true);
        AppMethodBeat.o(62117);
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        AppMethodBeat.i(62118);
        bBm();
        this.mLP = findViewById(R.id.byb);
        this.iqT = (ImageView) findViewById(R.id.jb);
        this.mLL = (EditText) findViewById(R.id.l3);
        this.mpR = (ImageButton) findViewById(R.id.kz);
        this.mLM = (TextView) findViewById(R.id.byc);
        this.mLN = (TextView) findViewById(R.id.byd);
        this.mLO = (TextView) findViewById(R.id.bye);
        this.kPL = new ArrayList();
        this.mLL.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(62105);
                if (keyEvent.getAction() == 0 && 67 == i) {
                    int selectionStart = FTSEditTextView.this.mLL.getSelectionStart();
                    int selectionEnd = FTSEditTextView.this.mLL.getSelectionEnd();
                    if (selectionStart == 0 && selectionEnd == 0 && FTSEditTextView.this.kPL.size() > 0 && FTSEditTextView.this.mLQ) {
                        FTSEditTextView.this.kPL.remove(FTSEditTextView.this.kPL.size() - 1);
                        FTSEditTextView.d(FTSEditTextView.this);
                        FTSEditTextView.e(FTSEditTextView.this);
                    }
                }
                AppMethodBeat.o(62105);
                return false;
            }
        });
        this.mLL.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(62106);
                String totalQuery = FTSEditTextView.this.getTotalQuery();
                if (!(totalQuery == FTSEditTextView.this.mLR || totalQuery.equals(FTSEditTextView.this.mLR))) {
                    FTSEditTextView.this.mLR = totalQuery;
                    if (totalQuery.length() > 0) {
                        FTSEditTextView.this.mpR.setVisibility(0);
                    } else {
                        FTSEditTextView.this.mpR.setVisibility(8);
                    }
                    FTSEditTextView.e(FTSEditTextView.this);
                }
                AppMethodBeat.o(62106);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.mLL.setOnFocusChangeListener(this.mLV);
        this.mLL.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(62107);
                if (3 != i || FTSEditTextView.this.mLT == null) {
                    AppMethodBeat.o(62107);
                    return false;
                }
                boolean aMo = FTSEditTextView.this.mLT.aMo();
                AppMethodBeat.o(62107);
                return aMo;
            }
        });
        this.mLM.setOnClickListener(this.mLS);
        this.mLN.setOnClickListener(this.mLS);
        this.mLO.setOnClickListener(this.mLS);
        this.mpR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(62108);
                FTSEditTextView.this.clearText();
                if (FTSEditTextView.this.mLT != null) {
                    FTSEditTextView.this.mLT.onClickClearTextBtn(view);
                }
                AppMethodBeat.o(62108);
            }
        });
        c.d(this.mLL).PM(100).a(null);
        AppMethodBeat.o(62118);
    }

    public final void clearText() {
        AppMethodBeat.i(62119);
        this.mLU = b.ClearText;
        if (this.mLQ) {
            this.kPL.clear();
        }
        this.mLL.setText("");
        this.mLL.setHint(this.hint);
        this.mpR.setVisibility(8);
        bBp();
        this.mLU = b.UserInput;
        AppMethodBeat.o(62119);
    }

    public void setEditTextDrawableLeft(int i) {
        AppMethodBeat.i(62120);
        if (i == -1) {
            this.mLL.setCompoundDrawablesRelative(null, null, null, null);
            AppMethodBeat.o(62120);
            return;
        }
        Drawable drawable = getContext().getResources().getDrawable(i);
        drawable.setBounds(0, 0, com.tencent.mm.bz.a.fromDPToPix(getContext(), 15), com.tencent.mm.bz.a.fromDPToPix(getContext(), 15));
        this.mLL.setCompoundDrawablesRelative(drawable, null, null, null);
        AppMethodBeat.o(62120);
    }

    public final void bBn() {
        AppMethodBeat.i(62121);
        postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(62109);
                ((InputMethodManager) FTSEditTextView.this.getContext().getSystemService("input_method")).showSoftInput(FTSEditTextView.this.mLL, 0);
                AppMethodBeat.o(62109);
            }
        }, 128);
        AppMethodBeat.o(62121);
    }

    public int getHighlightColor() {
        AppMethodBeat.i(62122);
        int highlightColor = this.mLL.getHighlightColor();
        AppMethodBeat.o(62122);
        return highlightColor;
    }

    public final void n(String str, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list) {
        AppMethodBeat.i(62123);
        a(str, list, b.UserInput);
        AppMethodBeat.o(62123);
    }

    private void a(String str, List<com.tencent.mm.plugin.fts.ui.widget.a.b> list, b bVar) {
        AppMethodBeat.i(62124);
        this.kPL.clear();
        if (list != null) {
            this.kPL.addAll(list);
        }
        ab.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", str, Integer.valueOf(this.kPL.size()));
        this.mLU = b.SetText;
        this.mLL.setText(str);
        Selection.setSelection(this.mLL.getText(), this.mLL.getText().length());
        bBp();
        this.mLU = bVar;
        AppMethodBeat.o(62124);
    }

    public final void bBo() {
        AppMethodBeat.i(62125);
        this.mLL.requestFocus();
        AppMethodBeat.o(62125);
    }

    public List<com.tencent.mm.plugin.fts.ui.widget.a.b> getTagList() {
        return this.kPL;
    }

    public void setHint(String str) {
        AppMethodBeat.i(62126);
        this.mLL.setHint(str);
        this.hint = str;
        AppMethodBeat.o(62126);
    }

    private void bBp() {
        AppMethodBeat.i(62127);
        ab.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", Integer.valueOf(this.kPL.size()));
        float al = (float) com.tencent.mm.bz.a.al(getContext(), R.dimen.m5);
        if (this.kPL.size() > 0) {
            this.mLM.setVisibility(0);
            this.mLM.setText(com.tencent.mm.ui.e.c.b.c(getContext(), ((com.tencent.mm.plugin.fts.ui.widget.a.b) this.kPL.get(0)).getTagName(), al));
        } else {
            this.mLM.setVisibility(8);
        }
        if (this.kPL.size() >= 2) {
            this.mLN.setVisibility(0);
            this.mLN.setText(com.tencent.mm.ui.e.c.b.c(getContext(), ((com.tencent.mm.plugin.fts.ui.widget.a.b) this.kPL.get(1)).getTagName(), al));
        } else {
            this.mLN.setVisibility(8);
        }
        if (this.kPL.size() >= 3) {
            this.mLO.setVisibility(0);
            this.mLO.setText(com.tencent.mm.ui.e.c.b.c(getContext(), ((com.tencent.mm.plugin.fts.ui.widget.a.b) this.kPL.get(2)).getTagName(), al));
            AppMethodBeat.o(62127);
            return;
        }
        this.mLO.setVisibility(8);
        AppMethodBeat.o(62127);
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

    public void setFtsEditTextListener(a aVar) {
        this.mLT = aVar;
    }

    public String getInEditTextQuery() {
        AppMethodBeat.i(62128);
        String trim = this.mLL.getText().toString().trim();
        AppMethodBeat.o(62128);
        return trim;
    }

    public String getTotalQuery() {
        AppMethodBeat.i(62129);
        StringBuffer stringBuffer = new StringBuffer();
        for (com.tencent.mm.plugin.fts.ui.widget.a.b tagName : this.kPL) {
            stringBuffer.append(tagName.getTagName());
            stringBuffer.append(" ");
        }
        stringBuffer.append(this.mLL.getText().toString());
        String trim = stringBuffer.toString().trim();
        AppMethodBeat.o(62129);
        return trim;
    }

    public final void bBq() {
        AppMethodBeat.i(62130);
        this.iqT.setVisibility(8);
        AppMethodBeat.o(62130);
    }

    public final void bBr() {
        AppMethodBeat.i(62131);
        this.iqT.setVisibility(0);
        AppMethodBeat.o(62131);
    }

    public final void bBs() {
        AppMethodBeat.i(62132);
        this.mpR.setVisibility(8);
        AppMethodBeat.o(62132);
    }

    public final void bBt() {
        AppMethodBeat.i(62133);
        this.mpR.setVisibility(0);
        AppMethodBeat.o(62133);
    }

    public View getTagPanel() {
        return this.mLP;
    }

    public b getTextChangeStatus() {
        return this.mLU;
    }

    public void setCanDeleteTag(boolean z) {
        this.mLQ = z;
    }

    static /* synthetic */ void e(FTSEditTextView fTSEditTextView) {
        AppMethodBeat.i(62135);
        String inEditTextQuery = fTSEditTextView.getInEditTextQuery();
        if (fTSEditTextView.mLT != null) {
            fTSEditTextView.mLT.a(fTSEditTextView.getTotalQuery(), inEditTextQuery, fTSEditTextView.kPL, fTSEditTextView.mLU);
        }
        if (inEditTextQuery.length() == 0) {
            fTSEditTextView.mLL.setHint(fTSEditTextView.hint);
        }
        AppMethodBeat.o(62135);
    }
}
