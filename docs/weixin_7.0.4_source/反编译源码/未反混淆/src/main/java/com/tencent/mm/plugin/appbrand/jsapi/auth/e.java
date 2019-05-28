package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.plugin.appbrand.widget.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper;", "", "()V", "Companion", "GetHeadIconPathCallback", "plugin-appbrand-integration_release"})
public final class e {
    private static final String TAG = TAG;
    public static final a hBN = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ4\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$Companion;", "", "()V", "SCOPE_USER_INFO", "", "TAG", "getHeadIconPath", "", "username", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "setUserInfoListData", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "userNickName", "scope", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "plugin-appbrand-integration_release"})
    public static final class a {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "errType", "errCode", "resultCallback"})
        static final class a implements c {
            final /* synthetic */ b hBO;
            final /* synthetic */ String hBP;

            a(b bVar, String str) {
                this.hBO = bVar;
                this.hBP = str;
            }

            public final int cr(int i, int i2) {
                AppMethodBeat.i(134657);
                ab.i(e.TAG, "GetHDHeadImg errType=%d  errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                b bVar = this.hBO;
                if (bVar != null) {
                    o.acd();
                    String C = d.C(this.hBP, false);
                    if (C == null) {
                        C = "";
                    }
                    bVar.AQ(C);
                }
                AppMethodBeat.o(134657);
                return 0;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static void a(String str, b bVar) {
            AppMethodBeat.i(134658);
            j.p(str, "username");
            o.acd();
            if (d.qe(str)) {
                o.acd();
                String C = d.C(str, false);
                if (C == null) {
                    C = "";
                }
                bVar.AQ(C);
                AppMethodBeat.o(134658);
                return;
            }
            new com.tencent.mm.ah.e().a(str, new a(bVar, str));
            AppMethodBeat.o(134658);
        }

        public static void a(Context context, Bitmap bitmap, String str, String str2, h hVar) {
            AppMethodBeat.i(134659);
            j.p(context, "context");
            j.p(hVar, "dialog");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.tencent.mm.plugin.appbrand.widget.b.h.b(str, context.getResources().getString(R.string.ut), str2, bitmap, (byte) 0));
            List list = arrayList;
            if (!list.isEmpty()) {
                hVar.jcy = new h.c(list);
                hVar.iJP.setAdapter(hVar.jcy);
                hVar.jct.setVisibility(0);
                hVar.jcq.setVisibility(8);
                hVar.jcv.setVisibility(8);
                hVar.jcu.setVisibility(8);
            }
            AppMethodBeat.o(134659);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "", "onCallback", "", "path", "", "plugin-appbrand-integration_release"})
    public interface b {
        void AQ(String str);
    }

    static {
        AppMethodBeat.i(134660);
        AppMethodBeat.o(134660);
    }
}
