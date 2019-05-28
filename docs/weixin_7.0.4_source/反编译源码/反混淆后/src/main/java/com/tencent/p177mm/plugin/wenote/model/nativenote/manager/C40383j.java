package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29992n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.j */
public final class C40383j implements Serializable {
    private static final Pattern uQs = Pattern.compile("\\r\\n|\\r|\\n");
    int uQt = 0;
    public final ArrayList<C29992n> uQu = new ArrayList();

    static {
        AppMethodBeat.m2504i(26830);
        AppMethodBeat.m2505o(26830);
    }

    public C40383j(Spanned spanned) {
        boolean z = false;
        AppMethodBeat.m2504i(26827);
        if (spanned != null) {
            String obj = spanned.toString();
            this.uQt = 1;
            Matcher matcher = uQs.matcher(obj);
            int i = 0;
            while (matcher.find()) {
                boolean z2;
                int end = matcher.end();
                if (this.uQt == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.uQu.add(new C29992n(i, end, z2, false));
                i = matcher.end();
                this.uQt++;
            }
            if (this.uQu.size() < this.uQt) {
                int length = obj.length();
                if (this.uQt == 1) {
                    z = true;
                }
                this.uQu.add(new C29992n(i, length, z, true));
            }
        }
        AppMethodBeat.m2505o(26827);
    }

    public final int getLineForOffset(int i) {
        AppMethodBeat.m2504i(26828);
        int i2 = 0;
        while (i2 < this.uQt && i >= ((C29992n) this.uQu.get(i2)).f4406Ls) {
            i2++;
        }
        int min = Math.min(Math.max(0, i2), this.uQu.size() - 1);
        AppMethodBeat.m2505o(26828);
        return min;
    }

    public final String toString() {
        AppMethodBeat.m2504i(26829);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.uQu.iterator();
        int i = 1;
        while (it.hasNext()) {
            C29992n c29992n = (C29992n) it.next();
            int i2 = i + 1;
            stringBuilder.append(i).append(": ").append(c29992n.aqm).append("-").append(c29992n.f4406Ls).append(c29992n.uRZ ? "" : ", ");
            i = i2;
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(26829);
        return stringBuilder2;
    }
}
