package com.tencent.p177mm.plugin.appbrand.dynamic.p285c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9548e;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C9687e;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.ttpic.util.VideoMaterialUtil;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c.a */
public final class C38191a implements C44041a {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c.a$a */
    static class C33148a implements C37866a<Bundle, Bundle> {

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c.a$a$1 */
        class C21281 implements Runnable {
            C21281() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10795);
                Assert.assertTrue(String.format("execute assert process(%s) command", new Object[]{C9548e.m17007PN()}), false);
                AppMethodBeat.m2505o(10795);
            }
        }

        private C33148a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10796);
            C26006a.postDelayed(new C21281(), 1000);
            AppMethodBeat.m2505o(10796);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c.a$b */
    static class C38192b implements C37866a<Bundle, Bundle> {

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.c.a$b$1 */
        class C381901 implements Runnable {
            C381901() {
            }

            public final void run() {
                AppMethodBeat.m2504i(10797);
                MMProtocalJni.setClientPackVersion(-1);
                AppMethodBeat.m2505o(10797);
            }
        }

        private C38192b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10798);
            C26006a.postDelayed(new C381901(), 1000);
            AppMethodBeat.m2505o(10798);
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo7165a(Context context, final String[] strArr, String str) {
        AppMethodBeat.m2504i(10799);
        if (!((C9687e) C1720g.m3528K(C9687e.class)).abz().abF()) {
            AppMethodBeat.m2505o(10799);
        } else if (!"//widget".equals(strArr[0])) {
            AppMethodBeat.m2505o(10799);
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(10799);
        } else {
            int i;
            boolean i2;
            String toLowerCase = strArr[1].toLowerCase();
            switch (toLowerCase.hashCode()) {
                case -1408208058:
                    if (toLowerCase.equals("assert")) {
                        i2 = 0;
                        break;
                    }
                case 547812385:
                    if (toLowerCase.equals("debugger")) {
                        i2 = 2;
                        break;
                    }
                case 1704329003:
                    if (toLowerCase.equals("jniassert")) {
                        i2 = true;
                        break;
                    }
                default:
                    i2 = -1;
                    break;
            }
            switch (i2) {
                case 0:
                    C26006a.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(10793);
                            String str = "com.tencent.mm";
                            if (strArr.length > 2 && !TextUtils.isEmpty(strArr[2])) {
                                str = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + strArr[2];
                            }
                            C9549f.m17012a(str, null, C33148a.class, null);
                            AppMethodBeat.m2505o(10793);
                        }
                    });
                case 1:
                    C26006a.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(10794);
                            String str = "com.tencent.mm";
                            if (strArr.length > 2 && !TextUtils.isEmpty(strArr[2])) {
                                str = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + strArr[2];
                            }
                            C9549f.m17012a(str, null, C38192b.class, null);
                            AppMethodBeat.m2505o(10794);
                        }
                    });
                case 2:
                    if (strArr.length <= 2 || TextUtils.isEmpty(strArr[2])) {
                        AppMethodBeat.m2505o(10799);
                        break;
                    }
                    toLowerCase = strArr[2];
                    switch (toLowerCase.hashCode()) {
                        case 46428:
                            if (toLowerCase.equals("-cr")) {
                                i2 = true;
                                break;
                            }
                        case 46800:
                            if (toLowerCase.equals("-or")) {
                                i2 = 0;
                                break;
                            }
                        case 1450433:
                            if (toLowerCase.equals("-ocb")) {
                                i2 = 2;
                                break;
                            }
                        default:
                            i2 = -1;
                            break;
                    }
                    switch (i2) {
                        case 0:
                            ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33914cA(true);
                        case 1:
                            ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33914cA(false);
                        case 2:
                            ((C9687e) C1720g.m3528K(C9687e.class)).abz().mo33913bT(context);
                    }
                    break;
            }
            AppMethodBeat.m2505o(10799);
        }
        return true;
    }
}
