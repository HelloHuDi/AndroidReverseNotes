package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.p1115c.C24524e;
import com.tencent.xweb.xwalk.C36614f.C24567d;
import com.tencent.xweb.xwalk.C36614f.C36615a;
import com.tencent.xweb.xwalk.C36614f.C36616c;
import org.xwalk.core.XWalkView;

/* renamed from: com.tencent.xweb.xwalk.g */
public final class C36617g implements C24524e {
    C31537l ARX;
    C24570m ARY;
    XWalkView ARZ;

    public C36617g(XWalkView xWalkView) {
        AppMethodBeat.m2504i(85230);
        this.ARZ = xWalkView;
        this.ARX = new C31537l(xWalkView);
        this.ARY = new C24570m(xWalkView);
        AppMethodBeat.m2505o(85230);
    }

    /* renamed from: w */
    public final void mo13225w(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(85231);
        this.ARX.mo51488a(this.ARZ, str);
        AppMethodBeat.m2505o(85231);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.m2504i(85232);
        if (customViewCallback instanceof C36615a) {
            this.ARX.mo51487a(view, ((C36615a) customViewCallback).ART);
        }
        AppMethodBeat.m2505o(85232);
    }

    public final void onHideCustomView() {
        AppMethodBeat.m2504i(85233);
        this.ARX.dVA();
        AppMethodBeat.m2505o(85233);
    }

    /* renamed from: a */
    public final boolean mo13220a(String str, String str2, C46945h c46945h) {
        AppMethodBeat.m2504i(85234);
        if (c46945h instanceof C36616c) {
            boolean b = this.ARX.mo51491b(this.ARZ, str, str2, ((C36616c) c46945h).ARV);
            AppMethodBeat.m2505o(85234);
            return b;
        }
        AppMethodBeat.m2505o(85234);
        return false;
    }

    /* renamed from: b */
    public final boolean mo13222b(String str, String str2, C46945h c46945h) {
        AppMethodBeat.m2504i(85235);
        if (c46945h instanceof C36616c) {
            boolean a = this.ARX.mo51490a(this.ARZ, str, str2, ((C36616c) c46945h).ARV);
            AppMethodBeat.m2505o(85235);
            return a;
        }
        AppMethodBeat.m2505o(85235);
        return false;
    }

    /* renamed from: a */
    public final boolean mo13221a(String str, String str2, String str3, C41127g c41127g) {
        AppMethodBeat.m2504i(85236);
        if (c41127g instanceof C24567d) {
            boolean a = this.ARX.mo51489a(this.ARZ, str, str2, str3, ((C24567d) c41127g).ARV);
            AppMethodBeat.m2505o(85236);
            return a;
        }
        AppMethodBeat.m2505o(85236);
        return false;
    }
}
