package com.tencent.mm.plugin.webview.ui.tools.widget.input;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;

public final class WebViewInputFooter extends LinearLayout {
    public MMActivity crP;
    private ImageButton jfS;
    private boolean oin = true;
    public int state = 0;
    private c uKm;
    private a uKn;
    private b uKo;
    private WebViewSmileyPanel uKp;
    public View uKq;
    private View uKr;
    private View uKs;
    public MMEditText uKt;
    public LinearLayout uKu;
    public boolean uKv;
    private int uKw = BaseClientBuilder.API_PRIORITY_OTHER;

    public interface a {
        boolean EH(String str);
    }

    public interface b {
        void cWT();

        void cWU();
    }

    public interface c {
        void aee(String str);
    }

    static /* synthetic */ int e(WebViewInputFooter webViewInputFooter) {
        AppMethodBeat.i(10093);
        int cWF = webViewInputFooter.cWF();
        AppMethodBeat.o(10093);
        return cWF;
    }

    static /* synthetic */ void h(WebViewInputFooter webViewInputFooter) {
        AppMethodBeat.i(10094);
        webViewInputFooter.aRe();
        AppMethodBeat.o(10094);
    }

    public final void setOnTextSendListener(c cVar) {
        this.uKm = cVar;
    }

    public final void setOnSmileyChosenListener(a aVar) {
        this.uKn = aVar;
    }

    public final void setOnSmileyPanelVisibilityChangedListener(b bVar) {
        this.uKo = bVar;
    }

    public WebViewInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(10083);
        this.crP = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.crP, R.layout.b7c, this);
        this.uKu = (LinearLayout) viewGroup.findViewById(R.id.fk6);
        this.uKr = viewGroup.findViewById(R.id.fk_);
        this.uKs = viewGroup.findViewById(R.id.fka);
        this.uKq = viewGroup.findViewById(R.id.fk9);
        this.uKt = (MMEditText) viewGroup.findViewById(R.id.fk7);
        this.jfS = (ImageButton) viewGroup.findViewById(R.id.fk8);
        this.jfS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(10075);
                if (WebViewInputFooter.this.state == 0) {
                    WebViewInputFooter.this.crP.aqX();
                    if (!WebViewInputFooter.this.uKv) {
                        WebViewInputFooter.this.uKt.requestFocus();
                    }
                    WebViewInputFooter.e(WebViewInputFooter.this);
                    WebViewInputFooter.this.jfS.setImageResource(R.raw.icons_outlined_emoji);
                    WebViewInputFooter.this.state = 1;
                    WebViewInputFooter.this.oin = false;
                    AppMethodBeat.o(10075);
                    return;
                }
                WebViewInputFooter.this.oin = false;
                WebViewInputFooter.this.uKt.requestFocus();
                WebViewInputFooter.this.crP.showVKB();
                WebViewInputFooter.h(WebViewInputFooter.this);
                WebViewInputFooter.this.state = 0;
                AppMethodBeat.o(10075);
            }
        });
        this.uKt.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(10076);
                WebViewInputFooter.this.oin = false;
                WebViewInputFooter.this.uKp.setVisibility(8);
                WebViewInputFooter.this.uKp;
                WebViewInputFooter.this.jfS.setImageResource(R.drawable.iv);
                WebViewInputFooter.this.state = 0;
                AppMethodBeat.o(10076);
                return false;
            }
        });
        this.uKp = new WebViewSmileyPanel(getContext());
        this.uKp.setVisibility(8);
        this.uKp.setBackgroundResource(R.drawable.ay1);
        this.uKp.setOnTextOperationListener(new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a() {
            public final void append(String str) {
                AppMethodBeat.i(10077);
                try {
                    if (WebViewInputFooter.this.uKv) {
                        WebViewInputFooter.this.uKn.EH(str);
                        AppMethodBeat.o(10077);
                        return;
                    }
                    WebViewInputFooter.this.uKt.asB(str);
                    AppMethodBeat.o(10077);
                } catch (Exception e) {
                    ab.e("MicroMsg.WebViewInputFooter", "appendText, exp = %s", e);
                    AppMethodBeat.o(10077);
                }
            }

            public final void aRg() {
                AppMethodBeat.i(10078);
                if (!WebViewInputFooter.this.uKv || WebViewInputFooter.this.uKn == null) {
                    if (WebViewInputFooter.this.uKt != null) {
                        MMEditText d = WebViewInputFooter.this.uKt;
                        if (d.getInputConnection() != null) {
                            d.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                            d.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                            AppMethodBeat.o(10078);
                            return;
                        }
                        d.dispatchKeyEvent(new KeyEvent(0, 67));
                        d.dispatchKeyEvent(new KeyEvent(1, 67));
                    }
                    AppMethodBeat.o(10078);
                    return;
                }
                WebViewInputFooter.this.uKn.EH("[DELETE_EMOTION]");
                AppMethodBeat.o(10078);
            }
        });
        ((LinearLayout) findViewById(R.id.l_)).addView(this.uKp, -1, 0);
        this.uKs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(10081);
                com.tencent.mm.ui.tools.b.c PM = com.tencent.mm.ui.tools.b.c.d(WebViewInputFooter.this.uKt).PM(WebViewInputFooter.this.uKw);
                PM.jeZ = com.tencent.mm.ui.tools.f.a.MODE_CHINESE_AS_1;
                PM.zIx = true;
                PM.a(new com.tencent.mm.ui.tools.b.c.a() {
                    public final void ki(String str) {
                        AppMethodBeat.i(10079);
                        if (WebViewInputFooter.this.uKm != null) {
                            WebViewInputFooter.this.uKm.aee(WebViewInputFooter.this.uKt.getText().toString());
                        }
                        WebViewInputFooter webViewInputFooter = WebViewInputFooter.this;
                        webViewInputFooter.uKt.clearComposingText();
                        webViewInputFooter.uKt.setText("");
                        AppMethodBeat.o(10079);
                    }

                    public final void JW() {
                    }

                    public final void JX() {
                        AppMethodBeat.i(10080);
                        if (WebViewInputFooter.this.crP != null) {
                            Toast.makeText(WebViewInputFooter.this.crP, "exceed max-length", 0).show();
                        }
                        AppMethodBeat.o(10080);
                    }
                });
                AppMethodBeat.o(10081);
            }
        });
        this.uKt.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(10082);
                if (WebViewInputFooter.this.uKt.getText() == null) {
                    AppMethodBeat.o(10082);
                    return;
                }
                WebViewInputFooter.this.uKt.requestFocus();
                boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
                WebViewInputFooter.a(WebViewInputFooter.this, z);
                AppMethodBeat.o(10082);
            }
        });
        AppMethodBeat.o(10083);
    }

    private int cWF() {
        AppMethodBeat.i(10084);
        if (this.uKo != null) {
            this.uKo.cWT();
        }
        if (this.uKt != null) {
            this.crP.hideVKB(this.uKt);
        }
        this.uKp.setVisibility(0);
        WebViewSmileyPanel webViewSmileyPanel = this.uKp;
        if (webViewSmileyPanel.WL != null) {
            webViewSmileyPanel.WL.setVisibility(0);
        }
        LayoutParams layoutParams = this.uKp.getLayoutParams();
        if (layoutParams != null && this.oin) {
            layoutParams.height = x.gs(getContext());
            this.uKp.setLayoutParams(layoutParams);
        }
        if (layoutParams != null) {
            int i = layoutParams.height;
            AppMethodBeat.o(10084);
            return i;
        }
        AppMethodBeat.o(10084);
        return 0;
    }

    private void aRe() {
        AppMethodBeat.i(10085);
        if (this.uKo != null) {
            this.uKo.cWU();
        }
        this.uKp.setVisibility(8);
        this.jfS.setImageResource(R.raw.icons_outlined_emoji);
        this.state = 0;
        AppMethodBeat.o(10085);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(10086);
        super.onDetachedFromWindow();
        dcY();
        if (!(this.uKt == null || this.crP == null)) {
            this.crP.hideVKB(this.uKt);
        }
        this.uKt = null;
        WebViewSmileyPanel webViewSmileyPanel = this.uKp;
        c cVar = webViewSmileyPanel.uKz;
        cVar.uKF = null;
        cVar.jiq = null;
        if (webViewSmileyPanel.WL != null) {
            ((ViewGroup) webViewSmileyPanel.WL.getParent()).removeView(webViewSmileyPanel.WL);
            ((ViewGroup) webViewSmileyPanel.WL).removeAllViews();
            webViewSmileyPanel.WL = null;
        }
        webViewSmileyPanel.jiE = null;
        removeAllViews();
        this.crP = null;
        this.uKm = null;
        AppMethodBeat.o(10086);
    }

    public final void setText(String str) {
        AppMethodBeat.i(10087);
        this.uKt.setText("");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(10087);
            return;
        }
        try {
            this.uKt.append(str);
        } catch (Exception e) {
            ab.d("MicroMsg.WebViewInputFooter", "appendText, exp = %s", e);
        }
        ab.d("MicroMsg.WebViewInputFooter", "after setText, editText.getText() = %s", this.uKt.getText());
        AppMethodBeat.o(10087);
    }

    public final void setMaxCount(int i) {
        if (i > 0) {
            this.uKw = i;
        }
    }

    private void dcY() {
        AppMethodBeat.i(10088);
        if (this.uKt != null) {
            this.uKt.clearFocus();
            this.uKt.setFocusable(false);
            this.uKt.setFocusableInTouchMode(false);
        }
        AppMethodBeat.o(10088);
    }

    public final int dcZ() {
        AppMethodBeat.i(10089);
        setVisibility(0);
        if (this.uKu != null) {
            this.uKu.setVisibility(8);
        }
        this.uKv = true;
        this.state = 1;
        int cWF = cWF();
        AppMethodBeat.o(10089);
        return cWF;
    }

    public final void hide() {
        AppMethodBeat.i(10090);
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
        AppMethodBeat.o(10090);
    }

    public final void dda() {
        AppMethodBeat.i(10091);
        if (this.uKv) {
            setVisibility(8);
        }
        this.state = 0;
        aRe();
        AppMethodBeat.o(10091);
    }

    public final boolean isShown() {
        AppMethodBeat.i(10092);
        if (getVisibility() == 0) {
            AppMethodBeat.o(10092);
            return true;
        }
        AppMethodBeat.o(10092);
        return false;
    }
}
