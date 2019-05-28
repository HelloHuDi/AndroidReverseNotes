package com.google.android.exoplayer2.f.d;

import android.text.Html;
import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends b {
    private static final Pattern bnB = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private final StringBuilder bnC = new StringBuilder();

    public final /* synthetic */ d c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(95649);
        b h = h(bArr, i);
        AppMethodBeat.o(95649);
        return h;
    }

    static {
        AppMethodBeat.i(95650);
        AppMethodBeat.o(95650);
    }

    public a() {
        super("SubripDecoder");
        AppMethodBeat.i(95646);
        AppMethodBeat.o(95646);
    }

    private b h(byte[] bArr, int i) {
        AppMethodBeat.i(95647);
        ArrayList arrayList = new ArrayList();
        g gVar = new g();
        l lVar = new l(bArr, i);
        while (true) {
            String readLine = lVar.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.length() != 0) {
                try {
                    Integer.parseInt(readLine);
                    readLine = lVar.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Matcher matcher = bnB.matcher(readLine);
                    if (matcher.matches()) {
                        int i2;
                        gVar.add(a(matcher, 1));
                        if (TextUtils.isEmpty(matcher.group(6))) {
                            i2 = 0;
                        } else {
                            gVar.add(a(matcher, 6));
                            i2 = 1;
                        }
                        this.bnC.setLength(0);
                        while (true) {
                            String readLine2 = lVar.readLine();
                            if (TextUtils.isEmpty(readLine2)) {
                                break;
                            }
                            if (this.bnC.length() > 0) {
                                this.bnC.append("<br>");
                            }
                            this.bnC.append(readLine2.trim());
                        }
                        arrayList.add(new com.google.android.exoplayer2.f.a(Html.fromHtml(this.bnC.toString())));
                        if (i2 != 0) {
                            arrayList.add(null);
                        }
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        com.google.android.exoplayer2.f.a[] aVarArr = new com.google.android.exoplayer2.f.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        b bVar = new b(aVarArr, gVar.toArray());
        AppMethodBeat.o(95647);
        return bVar;
    }

    private static long a(Matcher matcher, int i) {
        AppMethodBeat.i(95648);
        long parseLong = ((((((Long.parseLong(matcher.group(i + 1)) * 60) * 60) * 1000) + ((Long.parseLong(matcher.group(i + 2)) * 60) * 1000)) + (Long.parseLong(matcher.group(i + 3)) * 1000)) + Long.parseLong(matcher.group(i + 4))) * 1000;
        AppMethodBeat.o(95648);
        return parseLong;
    }
}
