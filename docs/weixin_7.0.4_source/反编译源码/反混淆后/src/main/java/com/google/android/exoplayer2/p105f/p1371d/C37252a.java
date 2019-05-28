package com.google.android.exoplayer2.p105f.p1371d;

import android.text.Html;
import android.text.TextUtils;
import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p105f.C8672b;
import com.google.android.exoplayer2.p111i.C0873g;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.f.d.a */
public final class C37252a extends C8672b {
    private static final Pattern bnB = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private final StringBuilder bnC = new StringBuilder();

    /* renamed from: c */
    public final /* synthetic */ C17659d mo2574c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(95649);
        C25534b h = m62502h(bArr, i);
        AppMethodBeat.m2505o(95649);
        return h;
    }

    static {
        AppMethodBeat.m2504i(95650);
        AppMethodBeat.m2505o(95650);
    }

    public C37252a() {
        super("SubripDecoder");
        AppMethodBeat.m2504i(95646);
        AppMethodBeat.m2505o(95646);
    }

    /* renamed from: h */
    private C25534b m62502h(byte[] bArr, int i) {
        AppMethodBeat.m2504i(95647);
        ArrayList arrayList = new ArrayList();
        C0873g c0873g = new C0873g();
        C32065l c32065l = new C32065l(bArr, i);
        while (true) {
            String readLine = c32065l.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.length() != 0) {
                try {
                    Integer.parseInt(readLine);
                    readLine = c32065l.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Matcher matcher = bnB.matcher(readLine);
                    if (matcher.matches()) {
                        int i2;
                        c0873g.add(C37252a.m62501a(matcher, 1));
                        if (TextUtils.isEmpty(matcher.group(6))) {
                            i2 = 0;
                        } else {
                            c0873g.add(C37252a.m62501a(matcher, 6));
                            i2 = 1;
                        }
                        this.bnC.setLength(0);
                        while (true) {
                            String readLine2 = c32065l.readLine();
                            if (TextUtils.isEmpty(readLine2)) {
                                break;
                            }
                            if (this.bnC.length() > 0) {
                                this.bnC.append("<br>");
                            }
                            this.bnC.append(readLine2.trim());
                        }
                        arrayList.add(new C32044a(Html.fromHtml(this.bnC.toString())));
                        if (i2 != 0) {
                            arrayList.add(null);
                        }
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        C32044a[] c32044aArr = new C32044a[arrayList.size()];
        arrayList.toArray(c32044aArr);
        C25534b c25534b = new C25534b(c32044aArr, c0873g.toArray());
        AppMethodBeat.m2505o(95647);
        return c25534b;
    }

    /* renamed from: a */
    private static long m62501a(Matcher matcher, int i) {
        AppMethodBeat.m2504i(95648);
        long parseLong = ((((((Long.parseLong(matcher.group(i + 1)) * 60) * 60) * 1000) + ((Long.parseLong(matcher.group(i + 2)) * 60) * 1000)) + (Long.parseLong(matcher.group(i + 3)) * 1000)) + Long.parseLong(matcher.group(i + 4))) * 1000;
        AppMethodBeat.m2505o(95648);
        return parseLong;
    }
}
