package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.e;
import com.tencent.xweb.h;
import com.tencent.xweb.xwalk.f.a;
import com.tencent.xweb.xwalk.f.c;
import com.tencent.xweb.xwalk.f.d;
import org.xwalk.core.XWalkView;

public final class g implements e {
    l ARX;
    m ARY;
    XWalkView ARZ;

    public g(XWalkView xWalkView) {
        AppMethodBeat.i(85230);
        this.ARZ = xWalkView;
        this.ARX = new l(xWalkView);
        this.ARY = new m(xWalkView);
        AppMethodBeat.o(85230);
    }

    public final void w(String str, Bitmap bitmap) {
        AppMethodBeat.i(85231);
        this.ARX.a(this.ARZ, str);
        AppMethodBeat.o(85231);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(85232);
        if (customViewCallback instanceof a) {
            this.ARX.a(view, ((a) customViewCallback).ART);
        }
        AppMethodBeat.o(85232);
    }

    public final void onHideCustomView() {
        AppMethodBeat.i(85233);
        this.ARX.dVA();
        AppMethodBeat.o(85233);
    }

    public final boolean a(String str, String str2, h hVar) {
        AppMethodBeat.i(85234);
        if (hVar instanceof c) {
            boolean b = this.ARX.b(this.ARZ, str, str2, ((c) hVar).ARV);
            AppMethodBeat.o(85234);
            return b;
        }
        AppMethodBeat.o(85234);
        return false;
    }

    public final boolean b(String str, String str2, h hVar) {
        AppMethodBeat.i(85235);
        if (hVar instanceof c) {
            boolean a = this.ARX.a(this.ARZ, str, str2, ((c) hVar).ARV);
            AppMethodBeat.o(85235);
            return a;
        }
        AppMethodBeat.o(85235);
        return false;
    }

    public final boolean a(String str, String str2, String str3, com.tencent.xweb.g gVar) {
        AppMethodBeat.i(85236);
        if (gVar instanceof d) {
            boolean a = this.ARX.a(this.ARZ, str, str2, str3, ((d) gVar).ARV);
            AppMethodBeat.o(85236);
            return a;
        }
        AppMethodBeat.o(85236);
        return false;
    }
}
