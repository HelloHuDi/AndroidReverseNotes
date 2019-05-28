package com.tencent.p177mm.plugin.product.p482ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.product.ui.HtmlTextView2 */
public class HtmlTextView2 extends MMWebView {
    private C36592s pih = new C367992();

    /* renamed from: com.tencent.mm.plugin.product.ui.HtmlTextView2$2 */
    class C367992 extends C36592s {
        C367992() {
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(44021);
            C4990ab.m7410d("test", str);
            AppMethodBeat.m2505o(44021);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.HtmlTextView2$1 */
    class C394901 implements OnTouchListener {
        C394901() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(44020);
            if (motionEvent.getAction() == 2) {
                AppMethodBeat.m2505o(44020);
                return true;
            }
            AppMethodBeat.m2505o(44020);
            return false;
        }
    }

    public HtmlTextView2(Context context, AttributeSet attributeSet, int i) {
        super(C4996ah.getContext(), attributeSet, i);
        AppMethodBeat.m2504i(44022);
        initView();
        AppMethodBeat.m2505o(44022);
    }

    public HtmlTextView2(Context context, AttributeSet attributeSet) {
        super(C4996ah.getContext(), attributeSet);
        AppMethodBeat.m2504i(44023);
        initView();
        AppMethodBeat.m2505o(44023);
    }

    private void initView() {
        AppMethodBeat.m2504i(44024);
        setOnTouchListener(new C394901());
        setVerticalScrollBarEnabled(false);
        getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
        AppMethodBeat.m2505o(44024);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(44025);
        setWebViewClient(null);
        loadData(str, "text/html", ProtocolPackage.ServerEncoding);
        setWebViewClient(this.pih);
        AppMethodBeat.m2505o(44025);
    }
}
