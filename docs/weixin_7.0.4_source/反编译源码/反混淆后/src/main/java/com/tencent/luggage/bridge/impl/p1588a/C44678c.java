package com.tencent.luggage.bridge.impl.p1588a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a.C19164c;

/* renamed from: com.tencent.luggage.bridge.impl.a.c */
public class C44678c extends C41702a {
    public boolean match(String str) {
        AppMethodBeat.m2504i(90767);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(90767);
            return false;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://")) {
            AppMethodBeat.m2505o(90767);
            return true;
        }
        AppMethodBeat.m2505o(90767);
        return false;
    }

    /* renamed from: b */
    public Bitmap mo22119b(String str, Rect rect, C19164c c19164c) {
        return null;
    }

    /* renamed from: wP */
    public final String mo22122wP() {
        return "NetworkImageReader";
    }
}
