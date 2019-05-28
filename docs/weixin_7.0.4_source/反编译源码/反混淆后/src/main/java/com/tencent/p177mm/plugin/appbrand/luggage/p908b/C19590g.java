package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.bridge.impl.p1588a.C44678c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37924e;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C379293;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37931h;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.plugin.appbrand.luggage.p1227a.C27184a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19163a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19164c;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.g */
public final class C19590g extends C44678c {
    public final boolean match(String str) {
        AppMethodBeat.m2504i(86985);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(86985);
            return false;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://")) {
            AppMethodBeat.m2505o(86985);
            return true;
        }
        AppMethodBeat.m2505o(86985);
        return false;
    }

    /* renamed from: b */
    public final Bitmap mo22119b(String str, Rect rect, final C19164c c19164c) {
        AppMethodBeat.m2504i(86986);
        if (match(str)) {
            C37924e c27184a;
            if (rect != null) {
                c27184a = new C27184a(rect.left, rect.top, rect.width(), rect.height());
            } else {
                c27184a = null;
            }
            Bitmap a = C37926b.abR().mo60681a(str, c27184a);
            if (a == null) {
                C37926b.abR().mo60686a(new C9676i() {
                    public final void abU() {
                    }

                    /* renamed from: x */
                    public final void mo6524x(Bitmap bitmap) {
                        AppMethodBeat.m2504i(86982);
                        if (c19164c == null) {
                            AppMethodBeat.m2505o(86982);
                        } else if (bitmap == null || bitmap.isRecycled()) {
                            c19164c.mo34405E(null);
                            AppMethodBeat.m2505o(86982);
                        } else {
                            c19164c.mo34405E(bitmap);
                            AppMethodBeat.m2505o(86982);
                        }
                    }

                    /* renamed from: mr */
                    public final void mo6522mr() {
                        AppMethodBeat.m2504i(86983);
                        if (c19164c == null) {
                            AppMethodBeat.m2505o(86983);
                            return;
                        }
                        c19164c.mo34405E(null);
                        AppMethodBeat.m2505o(86983);
                    }

                    /* renamed from: wP */
                    public final String mo6523wP() {
                        return "WxaIcon";
                    }
                }, str, null, c27184a);
            }
            AppMethodBeat.m2505o(86986);
            return a;
        }
        AppMethodBeat.m2505o(86986);
        return null;
    }

    /* renamed from: a */
    public final void mo22117a(String str, final C19163a c19163a) {
        AppMethodBeat.m2504i(86987);
        if (match(str)) {
            C37926b abR = C37926b.abR();
            C195912 c195912 = new C37931h() {
                /* renamed from: Q */
                public final void mo34800Q(byte[] bArr) {
                    AppMethodBeat.m2504i(86984);
                    if (c19163a != null) {
                        c19163a.mo34404Q(bArr);
                    }
                    AppMethodBeat.m2505o(86984);
                }
            };
            byte[] pD = abR.mo60689pD(str);
            if (pD == null || pD.length == 0) {
                abR.mo60685a(new C379293(str, c195912), str, null);
                AppMethodBeat.m2505o(86987);
                return;
            }
            c195912.mo34800Q(pD);
            AppMethodBeat.m2505o(86987);
            return;
        }
        AppMethodBeat.m2505o(86987);
    }
}
