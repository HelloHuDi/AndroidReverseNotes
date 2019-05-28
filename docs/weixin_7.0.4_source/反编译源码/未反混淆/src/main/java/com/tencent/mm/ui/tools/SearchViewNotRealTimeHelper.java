package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.v;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper extends LinearLayout implements d {
    private EditText mLL;
    private ImageButton zAa;
    private com.tencent.mm.ui.tools.ActionBarSearchView.a zAf;
    public Button zHm;
    private a zHn;
    private View zzY;

    public interface a {
        void FD(String str);

        void aWl();

        boolean vN(String str);
    }

    public SearchViewNotRealTimeHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107793);
        init();
        AppMethodBeat.o(107793);
    }

    public SearchViewNotRealTimeHelper(Context context) {
        super(context);
        AppMethodBeat.i(107794);
        init();
        AppMethodBeat.o(107794);
    }

    private void init() {
        AppMethodBeat.i(107795);
        v.hu(getContext()).inflate(R.layout.ae, this, true);
        this.mLL = (EditText) findViewById(R.id.l3);
        this.zAa = (ImageButton) findViewById(R.id.l4);
        this.zzY = findViewById(R.id.l0);
        this.zHm = (Button) findViewById(R.id.i3);
        this.zHm.setEnabled(false);
        this.mLL.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(107788);
                if (editable == null || editable.length() <= 0) {
                    SearchViewNotRealTimeHelper.this.zAa.setVisibility(8);
                    SearchViewNotRealTimeHelper.this.zHm.setEnabled(false);
                    AppMethodBeat.o(107788);
                    return;
                }
                SearchViewNotRealTimeHelper.this.zAa.setVisibility(0);
                SearchViewNotRealTimeHelper.this.zHm.setEnabled(true);
                AppMethodBeat.o(107788);
            }
        });
        this.mLL.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(107789);
                if (3 != i || SearchViewNotRealTimeHelper.this.zHn == null) {
                    AppMethodBeat.o(107789);
                    return false;
                }
                boolean vN = SearchViewNotRealTimeHelper.this.zHn.vN(SearchViewNotRealTimeHelper.this.getSearchContent());
                AppMethodBeat.o(107789);
                return vN;
            }
        });
        c.d(this.mLL).PM(100).a(null);
        this.zAa.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(107790);
                SearchViewNotRealTimeHelper.this.mLL.setText("");
                if (SearchViewNotRealTimeHelper.this.zHn != null) {
                    SearchViewNotRealTimeHelper.this.zHn.aWl();
                }
                AppMethodBeat.o(107790);
            }
        });
        this.zzY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(107791);
                ab.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
                if (SearchViewNotRealTimeHelper.this.zHn != null) {
                    SearchViewNotRealTimeHelper.this.zHn;
                }
                if (SearchViewNotRealTimeHelper.this.zAf != null) {
                    SearchViewNotRealTimeHelper.this.zAf.bKv();
                }
                AppMethodBeat.o(107791);
            }
        });
        this.zHm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(107792);
                if (SearchViewNotRealTimeHelper.this.zHn != null) {
                    SearchViewNotRealTimeHelper.this.zHn.FD(SearchViewNotRealTimeHelper.this.getSearchContent());
                }
                AppMethodBeat.o(107792);
            }
        });
        AppMethodBeat.o(107795);
    }

    public void setSearchBtnText(CharSequence charSequence) {
        AppMethodBeat.i(107796);
        this.zHm.setText(charSequence);
        AppMethodBeat.o(107796);
    }

    public void setSearchContent(CharSequence charSequence) {
        AppMethodBeat.i(107797);
        this.mLL.setText("");
        this.mLL.append(charSequence);
        AppMethodBeat.o(107797);
    }

    public void setSearchColor(int i) {
        AppMethodBeat.i(107798);
        this.mLL.setTextColor(i);
        AppMethodBeat.o(107798);
    }

    public void setSearchHint(CharSequence charSequence) {
        AppMethodBeat.i(107799);
        this.mLL.setHint(charSequence);
        AppMethodBeat.o(107799);
    }

    public void setSearchHintColor(int i) {
        AppMethodBeat.i(107800);
        this.mLL.setHintTextColor(i);
        AppMethodBeat.o(107800);
    }

    public void setSearchIcon(int i) {
        AppMethodBeat.i(107801);
        this.mLL.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        AppMethodBeat.o(107801);
    }

    public void setShowBackIcon(boolean z) {
        AppMethodBeat.i(107802);
        if (this.zzY != null) {
            if (z) {
                this.zzY.setVisibility(0);
                AppMethodBeat.o(107802);
                return;
            }
            this.zzY.setVisibility(8);
        }
        AppMethodBeat.o(107802);
    }

    public final void qO(boolean z) {
        AppMethodBeat.i(107803);
        this.mLL.setText("");
        AppMethodBeat.o(107803);
    }

    public final void dJr() {
        AppMethodBeat.i(107804);
        this.mLL.clearFocus();
        AppMethodBeat.o(107804);
    }

    public void setCallBack(a aVar) {
        this.zHn = aVar;
    }

    public String getSearchContent() {
        AppMethodBeat.i(107805);
        Editable editableText = this.mLL.getEditableText();
        String str;
        if (editableText == null) {
            str = "";
            AppMethodBeat.o(107805);
            return str;
        }
        str = editableText.toString();
        AppMethodBeat.o(107805);
        return str;
    }

    public void setSearchContent(String str) {
        AppMethodBeat.i(107806);
        setSearchContent((CharSequence) str);
        AppMethodBeat.o(107806);
    }

    public void setHint(CharSequence charSequence) {
        AppMethodBeat.i(107807);
        setSearchHint(charSequence);
        AppMethodBeat.o(107807);
    }

    public void setCallBack(b bVar) {
    }

    public final void qN(boolean z) {
    }

    public void setEditTextEnabled(boolean z) {
    }

    public void setStatusBtnEnabled(boolean z) {
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
    }

    public void setNotRealCallBack(a aVar) {
        this.zHn = aVar;
    }

    public boolean hasFocus() {
        return false;
    }

    public final boolean dJt() {
        return false;
    }

    public final boolean dJs() {
        return false;
    }

    public void setBackClickCallback(com.tencent.mm.ui.tools.ActionBarSearchView.a aVar) {
        this.zAf = aVar;
    }

    public void setKeywords(ArrayList<String> arrayList) {
    }

    public void setAutoMatchKeywords(boolean z) {
    }

    public void setSearchTipIcon(int i) {
    }

    public void setFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
    }

    public void setSelectedTag(String str) {
    }

    public int getSelectionStart() {
        return -1;
    }

    public int getSelectionEnd() {
        return -1;
    }
}
