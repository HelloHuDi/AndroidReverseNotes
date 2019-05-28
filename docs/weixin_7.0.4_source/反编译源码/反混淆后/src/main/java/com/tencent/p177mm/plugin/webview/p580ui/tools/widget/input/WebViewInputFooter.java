package com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.tools.C5584f.C5583a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewSmileyPanel.C4658a;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter */
public final class WebViewInputFooter extends LinearLayout {
    public MMActivity crP;
    private ImageButton jfS;
    private boolean oin = true;
    public int state = 0;
    private C35728c uKm;
    private C14683a uKn;
    private C29963b uKo;
    private WebViewSmileyPanel uKp;
    public View uKq;
    private View uKr;
    private View uKs;
    public MMEditText uKt;
    public LinearLayout uKu;
    public boolean uKv;
    private int uKw = BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter$5 */
    class C146825 implements TextWatcher {
        C146825() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(10082);
            if (WebViewInputFooter.this.uKt.getText() == null) {
                AppMethodBeat.m2505o(10082);
                return;
            }
            WebViewInputFooter.this.uKt.requestFocus();
            boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
            WebViewInputFooter.m58554a(WebViewInputFooter.this, z);
            AppMethodBeat.m2505o(10082);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter$a */
    public interface C14683a {
        /* renamed from: EH */
        boolean mo26953EH(String str);
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter$3 */
    class C231553 implements C4658a {
        C231553() {
        }

        public final void append(String str) {
            AppMethodBeat.m2504i(10077);
            try {
                if (WebViewInputFooter.this.uKv) {
                    WebViewInputFooter.this.uKn.mo26953EH(str);
                    AppMethodBeat.m2505o(10077);
                    return;
                }
                WebViewInputFooter.this.uKt.asB(str);
                AppMethodBeat.m2505o(10077);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", e);
                AppMethodBeat.m2505o(10077);
            }
        }

        public final void aRg() {
            AppMethodBeat.m2504i(10078);
            if (!WebViewInputFooter.this.uKv || WebViewInputFooter.this.uKn == null) {
                if (WebViewInputFooter.this.uKt != null) {
                    MMEditText d = WebViewInputFooter.this.uKt;
                    if (d.getInputConnection() != null) {
                        d.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                        d.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                        AppMethodBeat.m2505o(10078);
                        return;
                    }
                    d.dispatchKeyEvent(new KeyEvent(0, 67));
                    d.dispatchKeyEvent(new KeyEvent(1, 67));
                }
                AppMethodBeat.m2505o(10078);
                return;
            }
            WebViewInputFooter.this.uKn.mo26953EH("[DELETE_EMOTION]");
            AppMethodBeat.m2505o(10078);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter$4 */
    class C299614 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter$4$1 */
        class C299621 implements C5581a {
            C299621() {
            }

            /* renamed from: ki */
            public final void mo11317ki(String str) {
                AppMethodBeat.m2504i(10079);
                if (WebViewInputFooter.this.uKm != null) {
                    WebViewInputFooter.this.uKm.aee(WebViewInputFooter.this.uKt.getText().toString());
                }
                WebViewInputFooter webViewInputFooter = WebViewInputFooter.this;
                webViewInputFooter.uKt.clearComposingText();
                webViewInputFooter.uKt.setText("");
                AppMethodBeat.m2505o(10079);
            }

            /* renamed from: JW */
            public final void mo11315JW() {
            }

            /* renamed from: JX */
            public final void mo11316JX() {
                AppMethodBeat.m2504i(10080);
                if (WebViewInputFooter.this.crP != null) {
                    Toast.makeText(WebViewInputFooter.this.crP, "exceed max-length", 0).show();
                }
                AppMethodBeat.m2505o(10080);
            }
        }

        C299614() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(10081);
            C7357c PM = C7357c.m12555d(WebViewInputFooter.this.uKt).mo15877PM(WebViewInputFooter.this.uKw);
            PM.jeZ = C5583a.MODE_CHINESE_AS_1;
            PM.zIx = true;
            PM.mo15879a(new C299621());
            AppMethodBeat.m2505o(10081);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter$b */
    public interface C29963b {
        void cWT();

        void cWU();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter$1 */
    class C357271 implements OnClickListener {
        C357271() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(10075);
            if (WebViewInputFooter.this.state == 0) {
                WebViewInputFooter.this.crP.aqX();
                if (!WebViewInputFooter.this.uKv) {
                    WebViewInputFooter.this.uKt.requestFocus();
                }
                WebViewInputFooter.m58558e(WebViewInputFooter.this);
                WebViewInputFooter.this.jfS.setImageResource(C1318a.icons_outlined_emoji);
                WebViewInputFooter.this.state = 1;
                WebViewInputFooter.this.oin = false;
                AppMethodBeat.m2505o(10075);
                return;
            }
            WebViewInputFooter.this.oin = false;
            WebViewInputFooter.this.uKt.requestFocus();
            WebViewInputFooter.this.crP.showVKB();
            WebViewInputFooter.m58561h(WebViewInputFooter.this);
            WebViewInputFooter.this.state = 0;
            AppMethodBeat.m2505o(10075);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter$c */
    public interface C35728c {
        void aee(String str);
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter$2 */
    class C357292 implements OnTouchListener {
        C357292() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(10076);
            WebViewInputFooter.this.oin = false;
            WebViewInputFooter.this.uKp.setVisibility(8);
            WebViewInputFooter.this.uKp;
            WebViewInputFooter.this.jfS.setImageResource(C25738R.drawable.f6583iv);
            WebViewInputFooter.this.state = 0;
            AppMethodBeat.m2505o(10076);
            return false;
        }
    }

    /* renamed from: e */
    static /* synthetic */ int m58558e(WebViewInputFooter webViewInputFooter) {
        AppMethodBeat.m2504i(10093);
        int cWF = webViewInputFooter.cWF();
        AppMethodBeat.m2505o(10093);
        return cWF;
    }

    /* renamed from: h */
    static /* synthetic */ void m58561h(WebViewInputFooter webViewInputFooter) {
        AppMethodBeat.m2504i(10094);
        webViewInputFooter.aRe();
        AppMethodBeat.m2505o(10094);
    }

    public final void setOnTextSendListener(C35728c c35728c) {
        this.uKm = c35728c;
    }

    public final void setOnSmileyChosenListener(C14683a c14683a) {
        this.uKn = c14683a;
    }

    public final void setOnSmileyPanelVisibilityChangedListener(C29963b c29963b) {
        this.uKo = c29963b;
    }

    public WebViewInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(10083);
        this.crP = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.crP, 2130971213, this);
        this.uKu = (LinearLayout) viewGroup.findViewById(2131829170);
        this.uKr = viewGroup.findViewById(2131829174);
        this.uKs = viewGroup.findViewById(2131829175);
        this.uKq = viewGroup.findViewById(2131829173);
        this.uKt = (MMEditText) viewGroup.findViewById(2131829171);
        this.jfS = (ImageButton) viewGroup.findViewById(2131829172);
        this.jfS.setOnClickListener(new C357271());
        this.uKt.setOnTouchListener(new C357292());
        this.uKp = new WebViewSmileyPanel(getContext());
        this.uKp.setVisibility(8);
        this.uKp.setBackgroundResource(C25738R.drawable.ay1);
        this.uKp.setOnTextOperationListener(new C231553());
        ((LinearLayout) findViewById(2131820987)).addView(this.uKp, -1, 0);
        this.uKs.setOnClickListener(new C299614());
        this.uKt.addTextChangedListener(new C146825());
        AppMethodBeat.m2505o(10083);
    }

    private int cWF() {
        AppMethodBeat.m2504i(10084);
        if (this.uKo != null) {
            this.uKo.cWT();
        }
        if (this.uKt != null) {
            this.crP.hideVKB(this.uKt);
        }
        this.uKp.setVisibility(0);
        WebViewSmileyPanel webViewSmileyPanel = this.uKp;
        if (webViewSmileyPanel.f1289WL != null) {
            webViewSmileyPanel.f1289WL.setVisibility(0);
        }
        LayoutParams layoutParams = this.uKp.getLayoutParams();
        if (layoutParams != null && this.oin) {
            layoutParams.height = C40619x.m70073gs(getContext());
            this.uKp.setLayoutParams(layoutParams);
        }
        if (layoutParams != null) {
            int i = layoutParams.height;
            AppMethodBeat.m2505o(10084);
            return i;
        }
        AppMethodBeat.m2505o(10084);
        return 0;
    }

    private void aRe() {
        AppMethodBeat.m2504i(10085);
        if (this.uKo != null) {
            this.uKo.cWU();
        }
        this.uKp.setVisibility(8);
        this.jfS.setImageResource(C1318a.icons_outlined_emoji);
        this.state = 0;
        AppMethodBeat.m2505o(10085);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(10086);
        super.onDetachedFromWindow();
        dcY();
        if (!(this.uKt == null || this.crP == null)) {
            this.crP.hideVKB(this.uKt);
        }
        this.uKt = null;
        WebViewSmileyPanel webViewSmileyPanel = this.uKp;
        C14685c c14685c = webViewSmileyPanel.uKz;
        c14685c.uKF = null;
        c14685c.jiq = null;
        if (webViewSmileyPanel.f1289WL != null) {
            ((ViewGroup) webViewSmileyPanel.f1289WL.getParent()).removeView(webViewSmileyPanel.f1289WL);
            ((ViewGroup) webViewSmileyPanel.f1289WL).removeAllViews();
            webViewSmileyPanel.f1289WL = null;
        }
        webViewSmileyPanel.jiE = null;
        removeAllViews();
        this.crP = null;
        this.uKm = null;
        AppMethodBeat.m2505o(10086);
    }

    public final void setText(String str) {
        AppMethodBeat.m2504i(10087);
        this.uKt.setText("");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(10087);
            return;
        }
        try {
            this.uKt.append(str);
        } catch (Exception e) {
            C4990ab.m7411d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", e);
        }
        C4990ab.m7411d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", this.uKt.getText());
        AppMethodBeat.m2505o(10087);
    }

    public final void setMaxCount(int i) {
        if (i > 0) {
            this.uKw = i;
        }
    }

    private void dcY() {
        AppMethodBeat.m2504i(10088);
        if (this.uKt != null) {
            this.uKt.clearFocus();
            this.uKt.setFocusable(false);
            this.uKt.setFocusableInTouchMode(false);
        }
        AppMethodBeat.m2505o(10088);
    }

    public final int dcZ() {
        AppMethodBeat.m2504i(10089);
        setVisibility(0);
        if (this.uKu != null) {
            this.uKu.setVisibility(8);
        }
        this.uKv = true;
        this.state = 1;
        int cWF = cWF();
        AppMethodBeat.m2505o(10089);
        return cWF;
    }

    public final void hide() {
        AppMethodBeat.m2504i(10090);
        setVisibility(8);
        if (this.crP != null) {
            if (this.uKt != null) {
                this.crP.hideVKB(this.uKt);
            }
            this.crP.aqX();
        }
        this.state = 0;
        aRe();
        dcY();
        AppMethodBeat.m2505o(10090);
    }

    public final void dda() {
        AppMethodBeat.m2504i(10091);
        if (this.uKv) {
            setVisibility(8);
        }
        this.state = 0;
        aRe();
        AppMethodBeat.m2505o(10091);
    }

    public final boolean isShown() {
        AppMethodBeat.m2504i(10092);
        if (getVisibility() == 0) {
            AppMethodBeat.m2505o(10092);
            return true;
        }
        AppMethodBeat.m2505o(10092);
        return false;
    }
}
