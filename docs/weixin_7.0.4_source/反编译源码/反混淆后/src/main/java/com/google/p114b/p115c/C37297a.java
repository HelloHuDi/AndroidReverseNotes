package com.google.p114b.p115c;

import com.google.p114b.C25577g;
import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.C45062b;
import com.google.p114b.p115c.p116a.C0894k;
import com.google.p114b.p115c.p116a.C0895l;
import com.google.p114b.p115c.p116a.C32081j;
import com.google.p114b.p115c.p116a.C37296i;
import com.google.p114b.p115c.p116a.C8730e;
import com.google.p114b.p120f.p122b.C8738b;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.c.a */
public final class C37297a implements C25577g {
    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57274);
        IllegalArgumentException illegalArgumentException;
        if (str.isEmpty()) {
            illegalArgumentException = new IllegalArgumentException("Found empty contents");
            AppMethodBeat.m2505o(57274);
            throw illegalArgumentException;
        } else if (c37292a != C37292a.DATA_MATRIX) {
            illegalArgumentException = new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57274);
            throw illegalArgumentException;
        } else if (i < 0 || i2 < 0) {
            illegalArgumentException = new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
            AppMethodBeat.m2505o(57274);
            throw illegalArgumentException;
        } else {
            C45062b c45062b;
            C45062b c45062b2;
            C0895l c0895l = C0895l.FORCE_NONE;
            if (map != null) {
                C0895l c0895l2 = (C0895l) map.get(C41638c.DATA_MATRIX_SHAPE);
                if (c0895l2 != null) {
                    c0895l = c0895l2;
                }
                c45062b = (C45062b) map.get(C41638c.MIN_SIZE);
                if (c45062b != null) {
                    c45062b2 = c45062b;
                } else {
                    c45062b2 = null;
                }
                c45062b = (C45062b) map.get(C41638c.MAX_SIZE);
                if (c45062b == null) {
                    c45062b = null;
                }
            } else {
                c45062b = null;
                c45062b2 = null;
            }
            String a = C32081j.m52191a(str, c0895l, c45062b2, c45062b);
            C0894k a2 = C0894k.m2021a(a.length(), c0895l, c45062b2, c45062b);
            C8730e c8730e = new C8730e(C37296i.m62698a(a, a2), a2.mo3678vE(), a2.mo3679vF());
            c8730e.mo19749vw();
            C45061b a3 = C37297a.m62700a(c8730e, a2);
            AppMethodBeat.m2505o(57274);
            return a3;
        }
    }

    /* renamed from: a */
    private static C45061b m62700a(C8730e c8730e, C0894k c0894k) {
        int i;
        int i2;
        int i3;
        AppMethodBeat.m2504i(57275);
        int vE = c0894k.mo3678vE();
        int vF = c0894k.mo3679vF();
        C8738b c8738b = new C8738b(c0894k.mo3680vG(), c0894k.mo3681vH());
        int i4 = 0;
        int i5 = 0;
        while (i4 < vF) {
            boolean z;
            if (i4 % c0894k.bzZ == 0) {
                i = 0;
                for (i2 = 0; i2 < c0894k.mo3680vG(); i2++) {
                    if (i2 % 2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    c8738b.set(i, i5, z);
                    i++;
                }
                i2 = i5 + 1;
            } else {
                i2 = i5;
            }
            i = 0;
            for (i5 = 0; i5 < vE; i5++) {
                if (i5 % c0894k.bzY == 0) {
                    c8738b.set(i, i2, true);
                    i++;
                }
                if (c8730e.bzG[(c8730e.bzF * i4) + i5] == (byte) 1) {
                    z = true;
                } else {
                    z = false;
                }
                c8738b.set(i, i2, z);
                i3 = i + 1;
                if (i5 % c0894k.bzY == c0894k.bzY - 1) {
                    c8738b.set(i3, i2, i4 % 2 == 0);
                    i = i3 + 1;
                } else {
                    i = i3;
                }
            }
            i3 = i2 + 1;
            if (i4 % c0894k.bzZ == c0894k.bzZ - 1) {
                i = 0;
                for (i2 = 0; i2 < c0894k.mo3680vG(); i2++) {
                    c8738b.set(i, i3, true);
                    i++;
                }
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            i4++;
            i5 = i2;
        }
        i3 = c8738b.width;
        i5 = c8738b.height;
        C45061b c45061b = new C45061b(i3, i5);
        c45061b.clear();
        for (i = 0; i < i3; i++) {
            for (i2 = 0; i2 < i5; i2++) {
                if (c8738b.mo19752bH(i, i2) == (byte) 1) {
                    c45061b.set(i, i2);
                }
            }
        }
        AppMethodBeat.m2505o(57275);
        return c45061b;
    }
}
