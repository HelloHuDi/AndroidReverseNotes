package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.s;

public class HtmlTextView2 extends MMWebView {
    private s pih = new s() {
        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(44021);
            ab.d("test", str);
            AppMethodBeat.o(44021);
            return true;
        }
    };

    public HtmlTextView2(Context context, AttributeSet attributeSet, int i) {
        super(ah.getContext(), attributeSet, i);
        AppMethodBeat.i(44022);
        initView();
        AppMethodBeat.o(44022);
    }

    public HtmlTextView2(Context context, AttributeSet attributeSet) {
        super(ah.getContext(), attributeSet);
        AppMethodBeat.i(44023);
        initView();
        AppMethodBeat.o(44023);
    }

    private void initView() {
        AppMethodBeat.i(44024);
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(44020);
                if (motionEvent.getAction() == 2) {
                    AppMethodBeat.o(44020);
                    return true;
                }
                AppMethodBeat.o(44020);
                return false;
            }
        });
        setVerticalScrollBarEnabled(false);
        getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
        AppMethodBeat.o(44024);
    }

    public void setText(String str) {
        AppMethodBeat.i(44025);
        setWebViewClient(null);
        loadData(str, "text/html", ProtocolPackage.ServerEncoding);
        setWebViewClient(this.pih);
        AppMethodBeat.o(44025);
    }
}
