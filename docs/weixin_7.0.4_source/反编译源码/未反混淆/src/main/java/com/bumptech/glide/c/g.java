package com.bumptech.glide.c;

import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.d.a.m;
import com.bumptech.glide.c.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.List;

public final class g {
    public static a a(List<f> list, InputStream inputStream, b bVar) {
        AppMethodBeat.i(91677);
        a aVar;
        if (inputStream == null) {
            aVar = a.UNKNOWN;
            AppMethodBeat.o(91677);
            return aVar;
        }
        if (!inputStream.markSupported()) {
            inputStream = new m(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        int i = 0;
        while (i < size) {
            try {
                aVar = ((f) list.get(i)).c(inputStream);
                if (aVar != a.UNKNOWN) {
                    return aVar;
                }
                inputStream.reset();
                i++;
            } finally {
                inputStream.reset();
                AppMethodBeat.o(91677);
            }
        }
        aVar = a.UNKNOWN;
        AppMethodBeat.o(91677);
        return aVar;
    }

    public static int b(List<f> list, InputStream inputStream, b bVar) {
        AppMethodBeat.i(91678);
        if (inputStream == null) {
            AppMethodBeat.o(91678);
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new m(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        int i = 0;
        while (i < size) {
            try {
                int a = ((f) list.get(i)).a(inputStream, bVar);
                if (a != -1) {
                    return a;
                }
                inputStream.reset();
                i++;
            } finally {
                inputStream.reset();
                AppMethodBeat.o(91678);
            }
        }
        AppMethodBeat.o(91678);
        return -1;
    }
}
