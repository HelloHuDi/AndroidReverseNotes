package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j implements Serializable {
    private static final Pattern uQs = Pattern.compile("\\r\\n|\\r|\\n");
    int uQt = 0;
    public final ArrayList<n> uQu = new ArrayList();

    static {
        AppMethodBeat.i(26830);
        AppMethodBeat.o(26830);
    }

    public j(Spanned spanned) {
        boolean z = false;
        AppMethodBeat.i(26827);
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
                this.uQu.add(new n(i, end, z2, false));
                i = matcher.end();
                this.uQt++;
            }
            if (this.uQu.size() < this.uQt) {
                int length = obj.length();
                if (this.uQt == 1) {
                    z = true;
                }
                this.uQu.add(new n(i, length, z, true));
            }
        }
        AppMethodBeat.o(26827);
    }

    public final int getLineForOffset(int i) {
        AppMethodBeat.i(26828);
        int i2 = 0;
        while (i2 < this.uQt && i >= ((n) this.uQu.get(i2)).Ls) {
            i2++;
        }
        int min = Math.min(Math.max(0, i2), this.uQu.size() - 1);
        AppMethodBeat.o(26828);
        return min;
    }

    public final String toString() {
        AppMethodBeat.i(26829);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.uQu.iterator();
        int i = 1;
        while (it.hasNext()) {
            n nVar = (n) it.next();
            int i2 = i + 1;
            stringBuilder.append(i).append(": ").append(nVar.aqm).append("-").append(nVar.Ls).append(nVar.uRZ ? "" : ", ");
            i = i2;
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(26829);
        return stringBuilder2;
    }
}
