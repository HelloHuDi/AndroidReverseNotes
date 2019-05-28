package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter */
public class WebViewSearchContentInputFooter extends LinearLayout {
    private View uKe;
    private EditText uKf;
    private View uKg;
    private View uKh;
    private View uKi;
    private TextView uKj;
    private C23150a uKk;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter$1 */
    class C46541 implements OnClickListener {
        C46541() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(10058);
            WebViewSearchContentInputFooter.this.hide();
            AppMethodBeat.m2505o(10058);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter$2 */
    class C146712 implements OnClickListener {
        C146712() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(10059);
            if (WebViewSearchContentInputFooter.this.uKk != null) {
                WebViewSearchContentInputFooter.this.uKk.cWW();
            }
            AppMethodBeat.m2505o(10059);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter$3 */
    class C231463 implements OnClickListener {
        C231463() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(10060);
            if (WebViewSearchContentInputFooter.this.uKk != null) {
                WebViewSearchContentInputFooter.this.uKk.cWX();
            }
            AppMethodBeat.m2505o(10060);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter$4 */
    class C231474 implements OnKeyListener {
        C231474() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(10061);
            if (WebViewSearchContentInputFooter.this.uKk != null) {
                WebViewSearchContentInputFooter.this.uKk.mo31019c(i, keyEvent);
            }
            if (i != 66 || WebViewSearchContentInputFooter.this.uKk == null) {
                AppMethodBeat.m2505o(10061);
                return false;
            }
            Context context = view.getContext();
            if (context instanceof MMActivity) {
                ((MMActivity) context).hideVKB(WebViewSearchContentInputFooter.this.uKf);
            }
            WebViewSearchContentInputFooter.this.uKk.mo31018b(WebViewSearchContentInputFooter.this);
            AppMethodBeat.m2505o(10061);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter$7 */
    class C231487 implements Runnable {
        C231487() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10064);
            MMActivity.showVKB((Activity) WebViewSearchContentInputFooter.this.getContext());
            AppMethodBeat.m2505o(10064);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter$6 */
    class C231496 implements TextWatcher {
        C231496() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(10063);
            if (WebViewSearchContentInputFooter.this.uKk != null) {
                C23150a c = WebViewSearchContentInputFooter.this.uKk;
                WebViewSearchContentInputFooter webViewSearchContentInputFooter = WebViewSearchContentInputFooter.this;
                if (charSequence != null) {
                    charSequence.toString();
                }
                c.mo31017a(webViewSearchContentInputFooter);
            }
            AppMethodBeat.m2505o(10063);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter$a */
    public interface C23150a {
        /* renamed from: a */
        void mo31017a(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        /* renamed from: b */
        void mo31018b(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        /* renamed from: c */
        boolean mo31019c(int i, KeyEvent keyEvent);

        void cWV();

        void cWW();

        void cWX();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter$5 */
    class C231515 implements OnFocusChangeListener {
        C231515() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(10062);
            if (!(z || WebViewSearchContentInputFooter.this.uKk == null)) {
                Context context = view.getContext();
                if (context instanceof MMActivity) {
                    ((MMActivity) context).hideVKB(WebViewSearchContentInputFooter.this.uKf);
                }
            }
            WebViewSearchContentInputFooter.this.uKe.setSelected(z);
            AppMethodBeat.m2505o(10062);
        }
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(10065);
        init();
        AppMethodBeat.m2505o(10065);
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(10066);
        init();
        AppMethodBeat.m2505o(10066);
    }

    private void init() {
        AppMethodBeat.m2504i(10067);
        View inflate = WebViewSearchContentInputFooter.inflate(getContext(), 2130971217, this);
        this.uKf = (EditText) inflate.findViewById(2131820980);
        this.uKg = inflate.findViewById(2131827693);
        this.uKh = inflate.findViewById(2131829187);
        this.uKi = inflate.findViewById(2131829188);
        this.uKj = (TextView) inflate.findViewById(2131829186);
        this.uKe = inflate.findViewById(2131829185);
        this.uKg.setOnClickListener(new C46541());
        this.uKh.setOnClickListener(new C146712());
        this.uKi.setOnClickListener(new C231463());
        this.uKf.setOnKeyListener(new C231474());
        this.uKf.setOnFocusChangeListener(new C231515());
        this.uKf.addTextChangedListener(new C231496());
        this.uKf.setSelectAllOnFocus(true);
        reset();
        AppMethodBeat.m2505o(10067);
    }

    public final void reset() {
        AppMethodBeat.m2504i(10068);
        this.uKj.setText("");
        this.uKh.setEnabled(false);
        this.uKi.setEnabled(false);
        AppMethodBeat.m2505o(10068);
    }

    public final void dcX() {
        AppMethodBeat.m2504i(10069);
        this.uKf.setText("");
        AppMethodBeat.m2505o(10069);
    }

    public boolean isShown() {
        AppMethodBeat.m2504i(10070);
        if (getVisibility() == 0) {
            AppMethodBeat.m2505o(10070);
            return true;
        }
        AppMethodBeat.m2505o(10070);
        return false;
    }

    public final void show() {
        AppMethodBeat.m2504i(10071);
        setVisibility(0);
        this.uKf.requestFocus();
        postDelayed(new C231487(), 100);
        AppMethodBeat.m2505o(10071);
    }

    public final void hide() {
        AppMethodBeat.m2504i(10072);
        Context context = this.uKf.getContext();
        if (context instanceof MMActivity) {
            ((MMActivity) context).hideVKB(this.uKf);
        }
        this.uKf.clearFocus();
        setVisibility(8);
        if (this.uKk != null) {
            this.uKk.cWV();
        }
        AppMethodBeat.m2505o(10072);
    }

    /* renamed from: t */
    public final void mo38766t(int i, int i2, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(10073);
        if (z) {
            boolean z3;
            TextView textView = this.uKj;
            String str = "%d/%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i2 == 0 ? 0 : i + 1);
            objArr[1] = Integer.valueOf(i2);
            textView.setText(String.format(str, objArr));
            View view = this.uKi;
            if (i2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            view.setEnabled(z3);
            View view2 = this.uKh;
            if (i2 <= 0) {
                z2 = false;
            }
            view2.setEnabled(z2);
            AppMethodBeat.m2505o(10073);
            return;
        }
        AppMethodBeat.m2505o(10073);
    }

    public void setActionDelegate(C23150a c23150a) {
        this.uKk = c23150a;
    }

    public String getSearchContent() {
        AppMethodBeat.m2504i(10074);
        String obj = this.uKf.getText().toString();
        AppMethodBeat.m2505o(10074);
        return obj;
    }
}
