package com.tencent.p177mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p182ah.C41733e;
import com.tencent.p177mm.p182ah.C41733e.C25750c;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33586h;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33586h.C2535b;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33586h.C2536c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper;", "", "()V", "Companion", "GetHeadIconPathCallback", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.e */
public final class C38263e {
    private static final String TAG = TAG;
    public static final C26927a hBN = new C26927a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ4\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$Companion;", "", "()V", "SCOPE_USER_INFO", "", "TAG", "getHeadIconPath", "", "username", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "setUserInfoListData", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "userNickName", "scope", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.e$a */
    public static final class C26927a {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "errType", "errCode", "resultCallback"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.e$a$a */
        static final class C10329a implements C25750c {
            final /* synthetic */ C38262b hBO;
            final /* synthetic */ String hBP;

            C10329a(C38262b c38262b, String str) {
                this.hBO = c38262b;
                this.hBP = str;
            }

            /* renamed from: cr */
            public final int mo4442cr(int i, int i2) {
                AppMethodBeat.m2504i(134657);
                C4990ab.m7417i(C38263e.TAG, "GetHDHeadImg errType=%d  errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                C38262b c38262b = this.hBO;
                if (c38262b != null) {
                    C17884o.acd();
                    String C = C41732d.m73514C(this.hBP, false);
                    if (C == null) {
                        C = "";
                    }
                    c38262b.mo21759AQ(C);
                }
                AppMethodBeat.m2505o(134657);
                return 0;
            }
        }

        private C26927a() {
        }

        public /* synthetic */ C26927a(byte b) {
            this();
        }

        /* renamed from: a */
        public static void m42881a(String str, C38262b c38262b) {
            AppMethodBeat.m2504i(134658);
            C25052j.m39376p(str, "username");
            C17884o.acd();
            if (C41732d.m73524qe(str)) {
                C17884o.acd();
                String C = C41732d.m73514C(str, false);
                if (C == null) {
                    C = "";
                }
                c38262b.mo21759AQ(C);
                AppMethodBeat.m2505o(134658);
                return;
            }
            new C41733e().mo67507a(str, new C10329a(c38262b, str));
            AppMethodBeat.m2505o(134658);
        }

        /* renamed from: a */
        public static void m42880a(Context context, Bitmap bitmap, String str, String str2, C33586h c33586h) {
            AppMethodBeat.m2504i(134659);
            C25052j.m39376p(context, "context");
            C25052j.m39376p(c33586h, "dialog");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C2535b(str, context.getResources().getString(C25738R.string.f9266ut), str2, bitmap, (byte) 0));
            List list = arrayList;
            if (!list.isEmpty()) {
                c33586h.jcy = new C2536c(list);
                c33586h.iJP.setAdapter(c33586h.jcy);
                c33586h.jct.setVisibility(0);
                c33586h.jcq.setVisibility(8);
                c33586h.jcv.setVisibility(8);
                c33586h.jcu.setVisibility(8);
            }
            AppMethodBeat.m2505o(134659);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "", "onCallback", "", "path", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.e$b */
    public interface C38262b {
        /* renamed from: AQ */
        void mo21759AQ(String str);
    }

    static {
        AppMethodBeat.m2504i(134660);
        AppMethodBeat.m2505o(134660);
    }
}
