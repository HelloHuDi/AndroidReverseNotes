package com.bumptech.glide.p086c;

import com.bumptech.glide.p086c.C0776f.C0777a;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.bumptech.glide.p086c.p092d.p093a.C25444m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.bumptech.glide.c.g */
public final class C0778g {
    /* renamed from: a */
    public static C0777a m1772a(List<C0776f> list, InputStream inputStream, C8515b c8515b) {
        AppMethodBeat.m2504i(91677);
        C0777a c0777a;
        if (inputStream == null) {
            c0777a = C0777a.UNKNOWN;
            AppMethodBeat.m2505o(91677);
            return c0777a;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C25444m(inputStream, c8515b);
        }
        inputStream.mark(5242880);
        int size = list.size();
        int i = 0;
        while (i < size) {
            try {
                c0777a = ((C0776f) list.get(i)).mo2241c(inputStream);
                if (c0777a != C0777a.UNKNOWN) {
                    return c0777a;
                }
                inputStream.reset();
                i++;
            } finally {
                inputStream.reset();
                AppMethodBeat.m2505o(91677);
            }
        }
        c0777a = C0777a.UNKNOWN;
        AppMethodBeat.m2505o(91677);
        return c0777a;
    }

    /* renamed from: b */
    public static int m1773b(List<C0776f> list, InputStream inputStream, C8515b c8515b) {
        AppMethodBeat.m2504i(91678);
        if (inputStream == null) {
            AppMethodBeat.m2505o(91678);
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C25444m(inputStream, c8515b);
        }
        inputStream.mark(5242880);
        int size = list.size();
        int i = 0;
        while (i < size) {
            try {
                int a = ((C0776f) list.get(i)).mo2239a(inputStream, c8515b);
                if (a != -1) {
                    return a;
                }
                inputStream.reset();
                i++;
            } finally {
                inputStream.reset();
                AppMethodBeat.m2505o(91678);
            }
        }
        AppMethodBeat.m2505o(91678);
        return -1;
    }
}
