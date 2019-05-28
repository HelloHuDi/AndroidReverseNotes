package com.tencent.p177mm.plugin.appbrand.jsapi.p316t;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10378a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45577a;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.page.C33481y;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C27354a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.f */
public final class C27100f extends C45577a<C27242w> {
    public static final int CTRL_INDEX = 298;
    public static final String NAME = "insertHTMLWebView";

    /* renamed from: a */
    public final /* synthetic */ View mo6126a(C33303e c33303e, JSONObject jSONObject) {
        AppMethodBeat.m2504i(131675);
        final C27242w c27242w = (C27242w) c33303e;
        if (c27242w.aJS() != null) {
            AppMethodBeat.m2505o(131675);
            return null;
        }
        c27242w.mo68076f(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.f$1$1 */
            class C271041 implements C27354a {
                C271041() {
                }

                public final void aGw() {
                    AppMethodBeat.m2504i(131668);
                    C45622a aJS = c27242w.aJS();
                    if (aJS != null) {
                        aJS.fow.getView().scrollTo(aJS.fow.getWebScrollX(), 0);
                    }
                    AppMethodBeat.m2505o(131668);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(131669);
                C33481y c33481y = c27242w.isK;
                c33481y.setPullDownEnabled(true);
                c33481y.mo53966dO(false);
                c33481y.mo53965bq("light", C1338a.m2872i(c27242w.mContext, C25738R.color.a5v));
                c27242w.aJE();
                c27242w.getActionBar().mo22478a(new C271041());
                AppMethodBeat.m2505o(131669);
            }
        });
        final View c45622a = new C45622a(c27242w.mContext, c27242w.getRuntime(), c27242w);
        c45622a.setId(2131820572);
        c27242w.iqN.hvY.add(new C10378a() {
            /* renamed from: wY */
            public final boolean mo21856wY() {
                AppMethodBeat.m2504i(131670);
                C45622a c45622a = c45622a;
                if (c45622a.getWebView().canGoBack()) {
                    c45622a.getReporter().mo61210a(c45622a.hyU, true);
                    c45622a.getWebView().goBack();
                    c45622a.icn = true;
                    AppMethodBeat.m2505o(131670);
                    return true;
                }
                c45622a.getReporter().mo61210a(c45622a.hyU, false);
                AppMethodBeat.m2505o(131670);
                return false;
            }
        });
        c27242w.mo53829a((C10381d) new C10381d() {
            /* renamed from: wU */
            public final void mo6095wU() {
                AppMethodBeat.m2504i(131671);
                c45622a.getWebView().onResume();
                AppMethodBeat.m2505o(131671);
            }
        });
        c27242w.mo53827a((C10379b) new C10379b() {
            /* renamed from: wW */
            public final void mo21857wW() {
                AppMethodBeat.m2504i(131672);
                c45622a.getWebView().onPause();
                AppMethodBeat.m2505o(131672);
            }
        });
        AppMethodBeat.m2505o(131675);
        return c45622a;
    }

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(131673);
        int i = jSONObject.getInt("htmlId");
        AppMethodBeat.m2505o(131673);
        return i;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo6140a(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(131674);
        ((C45622a) view).setViewId(i);
        AppMethodBeat.m2505o(131674);
    }
}
