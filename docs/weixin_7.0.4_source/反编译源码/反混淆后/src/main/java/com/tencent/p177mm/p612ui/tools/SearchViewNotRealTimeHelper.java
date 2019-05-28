package com.tencent.p177mm.p612ui.tools;

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
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView.C5553a;
import com.tencent.p177mm.p612ui.tools.ActionBarSearchView.C5554b;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper */
public class SearchViewNotRealTimeHelper extends LinearLayout implements C5582d {
    private EditText mLL;
    private ImageButton zAa;
    private C5553a zAf;
    public Button zHm;
    private C5576a zHn;
    private View zzY;

    /* renamed from: com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper$1 */
    class C55711 implements TextWatcher {
        C55711() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(107788);
            if (editable == null || editable.length() <= 0) {
                SearchViewNotRealTimeHelper.this.zAa.setVisibility(8);
                SearchViewNotRealTimeHelper.this.zHm.setEnabled(false);
                AppMethodBeat.m2505o(107788);
                return;
            }
            SearchViewNotRealTimeHelper.this.zAa.setVisibility(0);
            SearchViewNotRealTimeHelper.this.zHm.setEnabled(true);
            AppMethodBeat.m2505o(107788);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper$2 */
    class C55722 implements OnEditorActionListener {
        C55722() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(107789);
            if (3 != i || SearchViewNotRealTimeHelper.this.zHn == null) {
                AppMethodBeat.m2505o(107789);
                return false;
            }
            boolean vN = SearchViewNotRealTimeHelper.this.zHn.mo11299vN(SearchViewNotRealTimeHelper.this.getSearchContent());
            AppMethodBeat.m2505o(107789);
            return vN;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper$3 */
    class C55733 implements OnClickListener {
        C55733() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(107790);
            SearchViewNotRealTimeHelper.this.mLL.setText("");
            if (SearchViewNotRealTimeHelper.this.zHn != null) {
                SearchViewNotRealTimeHelper.this.zHn.aWl();
            }
            AppMethodBeat.m2505o(107790);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper$4 */
    class C55744 implements OnClickListener {
        C55744() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(107791);
            C4990ab.m7418v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
            if (SearchViewNotRealTimeHelper.this.zHn != null) {
                SearchViewNotRealTimeHelper.this.zHn;
            }
            if (SearchViewNotRealTimeHelper.this.zAf != null) {
                SearchViewNotRealTimeHelper.this.zAf.bKv();
            }
            AppMethodBeat.m2505o(107791);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper$5 */
    class C55755 implements OnClickListener {
        C55755() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(107792);
            if (SearchViewNotRealTimeHelper.this.zHn != null) {
                SearchViewNotRealTimeHelper.this.zHn.mo11297FD(SearchViewNotRealTimeHelper.this.getSearchContent());
            }
            AppMethodBeat.m2505o(107792);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper$a */
    public interface C5576a {
        /* renamed from: FD */
        void mo11297FD(String str);

        void aWl();

        /* renamed from: vN */
        boolean mo11299vN(String str);
    }

    public SearchViewNotRealTimeHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107793);
        init();
        AppMethodBeat.m2505o(107793);
    }

    public SearchViewNotRealTimeHelper(Context context) {
        super(context);
        AppMethodBeat.m2504i(107794);
        init();
        AppMethodBeat.m2505o(107794);
    }

    private void init() {
        AppMethodBeat.m2504i(107795);
        C5616v.m8409hu(getContext()).inflate(2130968617, this, true);
        this.mLL = (EditText) findViewById(2131820980);
        this.zAa = (ImageButton) findViewById(2131820981);
        this.zzY = findViewById(2131820977);
        this.zHm = (Button) findViewById(2131820869);
        this.zHm.setEnabled(false);
        this.mLL.addTextChangedListener(new C55711());
        this.mLL.setOnEditorActionListener(new C55722());
        C7357c.m12555d(this.mLL).mo15877PM(100).mo15879a(null);
        this.zAa.setOnClickListener(new C55733());
        this.zzY.setOnClickListener(new C55744());
        this.zHm.setOnClickListener(new C55755());
        AppMethodBeat.m2505o(107795);
    }

    public void setSearchBtnText(CharSequence charSequence) {
        AppMethodBeat.m2504i(107796);
        this.zHm.setText(charSequence);
        AppMethodBeat.m2505o(107796);
    }

    public void setSearchContent(CharSequence charSequence) {
        AppMethodBeat.m2504i(107797);
        this.mLL.setText("");
        this.mLL.append(charSequence);
        AppMethodBeat.m2505o(107797);
    }

    public void setSearchColor(int i) {
        AppMethodBeat.m2504i(107798);
        this.mLL.setTextColor(i);
        AppMethodBeat.m2505o(107798);
    }

    public void setSearchHint(CharSequence charSequence) {
        AppMethodBeat.m2504i(107799);
        this.mLL.setHint(charSequence);
        AppMethodBeat.m2505o(107799);
    }

    public void setSearchHintColor(int i) {
        AppMethodBeat.m2504i(107800);
        this.mLL.setHintTextColor(i);
        AppMethodBeat.m2505o(107800);
    }

    public void setSearchIcon(int i) {
        AppMethodBeat.m2504i(107801);
        this.mLL.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        AppMethodBeat.m2505o(107801);
    }

    public void setShowBackIcon(boolean z) {
        AppMethodBeat.m2504i(107802);
        if (this.zzY != null) {
            if (z) {
                this.zzY.setVisibility(0);
                AppMethodBeat.m2505o(107802);
                return;
            }
            this.zzY.setVisibility(8);
        }
        AppMethodBeat.m2505o(107802);
    }

    /* renamed from: qO */
    public final void mo11323qO(boolean z) {
        AppMethodBeat.m2504i(107803);
        this.mLL.setText("");
        AppMethodBeat.m2505o(107803);
    }

    public final void dJr() {
        AppMethodBeat.m2504i(107804);
        this.mLL.clearFocus();
        AppMethodBeat.m2505o(107804);
    }

    public void setCallBack(C5576a c5576a) {
        this.zHn = c5576a;
    }

    public String getSearchContent() {
        AppMethodBeat.m2504i(107805);
        Editable editableText = this.mLL.getEditableText();
        String str;
        if (editableText == null) {
            str = "";
            AppMethodBeat.m2505o(107805);
            return str;
        }
        str = editableText.toString();
        AppMethodBeat.m2505o(107805);
        return str;
    }

    public void setSearchContent(String str) {
        AppMethodBeat.m2504i(107806);
        setSearchContent((CharSequence) str);
        AppMethodBeat.m2505o(107806);
    }

    public void setHint(CharSequence charSequence) {
        AppMethodBeat.m2504i(107807);
        setSearchHint(charSequence);
        AppMethodBeat.m2505o(107807);
    }

    public void setCallBack(C5554b c5554b) {
    }

    /* renamed from: qN */
    public final void mo11322qN(boolean z) {
    }

    public void setEditTextEnabled(boolean z) {
    }

    public void setStatusBtnEnabled(boolean z) {
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
    }

    public void setNotRealCallBack(C5576a c5576a) {
        this.zHn = c5576a;
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

    public void setBackClickCallback(C5553a c5553a) {
        this.zAf = c5553a;
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
