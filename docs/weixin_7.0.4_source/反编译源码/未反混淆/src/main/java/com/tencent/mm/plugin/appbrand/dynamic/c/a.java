package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.ttpic.util.VideoMaterialUtil;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(10796);
            com.tencent.mm.ce.a.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10795);
                    Assert.assertTrue(String.format("execute assert process(%s) command", new Object[]{e.PN()}), false);
                    AppMethodBeat.o(10795);
                }
            }, 1000);
            AppMethodBeat.o(10796);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(10798);
            com.tencent.mm.ce.a.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10797);
                    MMProtocalJni.setClientPackVersion(-1);
                    AppMethodBeat.o(10797);
                }
            }, 1000);
            AppMethodBeat.o(10798);
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, final String[] strArr, String str) {
        AppMethodBeat.i(10799);
        if (!((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).abz().abF()) {
            AppMethodBeat.o(10799);
        } else if (!"//widget".equals(strArr[0])) {
            AppMethodBeat.o(10799);
        } else if (strArr.length < 2) {
            AppMethodBeat.o(10799);
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
                    com.tencent.mm.ce.a.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(10793);
                            String str = "com.tencent.mm";
                            if (strArr.length > 2 && !TextUtils.isEmpty(strArr[2])) {
                                str = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + strArr[2];
                            }
                            f.a(str, null, a.class, null);
                            AppMethodBeat.o(10793);
                        }
                    });
                case 1:
                    com.tencent.mm.ce.a.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(10794);
                            String str = "com.tencent.mm";
                            if (strArr.length > 2 && !TextUtils.isEmpty(strArr[2])) {
                                str = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + strArr[2];
                            }
                            f.a(str, null, b.class, null);
                            AppMethodBeat.o(10794);
                        }
                    });
                case 2:
                    if (strArr.length <= 2 || TextUtils.isEmpty(strArr[2])) {
                        AppMethodBeat.o(10799);
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
                            ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).abz().cA(true);
                        case 1:
                            ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).abz().cA(false);
                        case 2:
                            ((com.tencent.mm.modelappbrand.e) g.K(com.tencent.mm.modelappbrand.e.class)).abz().bT(context);
                    }
                    break;
            }
            AppMethodBeat.o(10799);
        }
        return true;
    }
}
