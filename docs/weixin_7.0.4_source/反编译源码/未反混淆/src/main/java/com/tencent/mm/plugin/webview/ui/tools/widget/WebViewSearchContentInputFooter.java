package com.tencent.mm.plugin.webview.ui.tools.widget;

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
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class WebViewSearchContentInputFooter extends LinearLayout {
    private View uKe;
    private EditText uKf;
    private View uKg;
    private View uKh;
    private View uKi;
    private TextView uKj;
    private a uKk;

    public interface a {
        void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        boolean c(int i, KeyEvent keyEvent);

        void cWV();

        void cWW();

        void cWX();
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(10065);
        init();
        AppMethodBeat.o(10065);
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(10066);
        init();
        AppMethodBeat.o(10066);
    }

    private void init() {
        AppMethodBeat.i(10067);
        View inflate = inflate(getContext(), R.layout.b7g, this);
        this.uKf = (EditText) inflate.findViewById(R.id.l3);
        this.uKg = inflate.findViewById(R.id.eh9);
        this.uKh = inflate.findViewById(R.id.fkm);
        this.uKi = inflate.findViewById(R.id.fkn);
        this.uKj = (TextView) inflate.findViewById(R.id.fkl);
        this.uKe = inflate.findViewById(R.id.fkk);
        this.uKg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(10058);
                WebViewSearchContentInputFooter.this.hide();
                AppMethodBeat.o(10058);
            }
        });
        this.uKh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(10059);
                if (WebViewSearchContentInputFooter.this.uKk != null) {
                    WebViewSearchContentInputFooter.this.uKk.cWW();
                }
                AppMethodBeat.o(10059);
            }
        });
        this.uKi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(10060);
                if (WebViewSearchContentInputFooter.this.uKk != null) {
                    WebViewSearchContentInputFooter.this.uKk.cWX();
                }
                AppMethodBeat.o(10060);
            }
        });
        this.uKf.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(10061);
                if (WebViewSearchContentInputFooter.this.uKk != null) {
                    WebViewSearchContentInputFooter.this.uKk.c(i, keyEvent);
                }
                if (i != 66 || WebViewSearchContentInputFooter.this.uKk == null) {
                    AppMethodBeat.o(10061);
                    return false;
                }
                Context context = view.getContext();
                if (context instanceof MMActivity) {
                    ((MMActivity) context).hideVKB(WebViewSearchContentInputFooter.this.uKf);
                }
                WebViewSearchContentInputFooter.this.uKk.b(WebViewSearchContentInputFooter.this);
                AppMethodBeat.o(10061);
                return true;
            }
        });
        this.uKf.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(10062);
                if (!(z || WebViewSearchContentInputFooter.this.uKk == null)) {
                    Context context = view.getContext();
                    if (context instanceof MMActivity) {
                        ((MMActivity) context).hideVKB(WebViewSearchContentInputFooter.this.uKf);
                    }
                }
                WebViewSearchContentInputFooter.this.uKe.setSelected(z);
                AppMethodBeat.o(10062);
            }
        });
        this.uKf.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(10063);
                if (WebViewSearchContentInputFooter.this.uKk != null) {
                    a c = WebViewSearchContentInputFooter.this.uKk;
                    WebViewSearchContentInputFooter webViewSearchContentInputFooter = WebViewSearchContentInputFooter.this;
                    if (charSequence != null) {
                        charSequence.toString();
                    }
                    c.a(webViewSearchContentInputFooter);
                }
                AppMethodBeat.o(10063);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.uKf.setSelectAllOnFocus(true);
        reset();
        AppMethodBeat.o(10067);
    }

    public final void reset() {
        AppMethodBeat.i(10068);
        this.uKj.setText("");
        this.uKh.setEnabled(false);
        this.uKi.setEnabled(false);
        AppMethodBeat.o(10068);
    }

    public final void dcX() {
        AppMethodBeat.i(10069);
        this.uKf.setText("");
        AppMethodBeat.o(10069);
    }

    public boolean isShown() {
        AppMethodBeat.i(10070);
        if (getVisibility() == 0) {
            AppMethodBeat.o(10070);
            return true;
        }
        AppMethodBeat.o(10070);
        return false;
    }

    public final void show() {
        AppMethodBeat.i(10071);
        setVisibility(0);
        this.uKf.requestFocus();
        postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(10064);
                MMActivity.showVKB((Activity) WebViewSearchContentInputFooter.this.getContext());
                AppMethodBeat.o(10064);
            }
        }, 100);
        AppMethodBeat.o(10071);
    }

    public final void hide() {
        AppMethodBeat.i(10072);
        Context context = this.uKf.getContext();
        if (context instanceof MMActivity) {
            ((MMActivity) context).hideVKB(this.uKf);
        }
        this.uKf.clearFocus();
        setVisibility(8);
        if (this.uKk != null) {
            this.uKk.cWV();
        }
        AppMethodBeat.o(10072);
    }

    public final void t(int i, int i2, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(10073);
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
            AppMethodBeat.o(10073);
            return;
        }
        AppMethodBeat.o(10073);
    }

    public void setActionDelegate(a aVar) {
        this.uKk = aVar;
    }

    public String getSearchContent() {
        AppMethodBeat.i(10074);
        String obj = this.uKf.getText().toString();
        AppMethodBeat.o(10074);
        return obj;
    }
}
