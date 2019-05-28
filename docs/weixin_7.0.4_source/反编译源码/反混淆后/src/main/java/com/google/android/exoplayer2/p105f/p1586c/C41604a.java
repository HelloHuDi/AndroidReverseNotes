package com.google.android.exoplayer2.p105f.p1586c;

import android.text.TextUtils;
import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p105f.C8672b;
import com.google.android.exoplayer2.p111i.C0873g;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.exoplayer2.f.c.a */
public final class C41604a extends C8672b {
    private static final Pattern bnt = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean bnu;
    private int bnv;
    private int bnw;
    private int bnx;
    private int bny;

    static {
        AppMethodBeat.m2504i(95642);
        AppMethodBeat.m2505o(95642);
    }

    public C41604a() {
        this(null);
    }

    public C41604a(List<byte[]> list) {
        super("SsaDecoder");
        AppMethodBeat.m2504i(95636);
        if (list != null) {
            this.bnu = true;
            String str = new String((byte[]) list.get(0));
            C45039a.checkArgument(str.startsWith("Format: "));
            m72884aA(str);
            C41604a.m72882B(new C32065l((byte[]) list.get(1)));
            AppMethodBeat.m2505o(95636);
            return;
        }
        this.bnu = false;
        AppMethodBeat.m2505o(95636);
    }

    /* renamed from: B */
    private static void m72882B(C32065l c32065l) {
        AppMethodBeat.m2504i(95637);
        String readLine;
        do {
            readLine = c32065l.readLine();
            if (readLine == null) {
                AppMethodBeat.m2505o(95637);
                return;
            }
        } while (!readLine.startsWith("[Events]"));
        AppMethodBeat.m2505o(95637);
    }

    /* renamed from: a */
    private void m72883a(C32065l c32065l, List<C32044a> list, C0873g c0873g) {
        AppMethodBeat.m2504i(95638);
        while (true) {
            String readLine = c32065l.readLine();
            if (readLine == null) {
                AppMethodBeat.m2505o(95638);
                return;
            } else if (!this.bnu && readLine.startsWith("Format: ")) {
                m72884aA(readLine);
            } else if (readLine.startsWith("Dialogue: ") && this.bnv != 0) {
                String[] split = readLine.substring(10).split(",", this.bnv);
                long aB = C41604a.m72885aB(split[this.bnw]);
                if (aB != -9223372036854775807L) {
                    long j;
                    readLine = split[this.bnx];
                    if (readLine.trim().isEmpty()) {
                        j = -9223372036854775807L;
                    } else {
                        j = C41604a.m72885aB(readLine);
                        if (j == -9223372036854775807L) {
                        }
                    }
                    list.add(new C32044a(split[this.bny].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", IOUtils.LINE_SEPARATOR_UNIX).replaceAll("\\\\n", IOUtils.LINE_SEPARATOR_UNIX)));
                    c0873g.add(aB);
                    if (j != -9223372036854775807L) {
                        list.add(null);
                        c0873g.add(j);
                    }
                }
            }
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aA */
    private void m72884aA(String str) {
        AppMethodBeat.m2504i(95639);
        String[] split = TextUtils.split(str.substring(8), ",");
        this.bnv = split.length;
        this.bnw = -1;
        this.bnx = -1;
        this.bny = -1;
        for (int i = 0; i < this.bnv; i++) {
            int i2;
            String aR = C17675v.m27560aR(split[i].trim());
            switch (aR.hashCode()) {
                case 100571:
                    if (aR.equals("end")) {
                        i2 = 1;
                        break;
                    }
                case 3556653:
                    if (aR.equals("text")) {
                        i2 = 2;
                        break;
                    }
                case 109757538:
                    if (aR.equals("start")) {
                        i2 = 0;
                        break;
                    }
                default:
                    i2 = -1;
                    break;
            }
            switch (i2) {
                case 0:
                    this.bnw = i;
                    break;
                case 1:
                    this.bnx = i;
                    break;
                case 2:
                    this.bny = i;
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.m2505o(95639);
    }

    /* renamed from: aB */
    private static long m72885aB(String str) {
        AppMethodBeat.m2504i(95640);
        Matcher matcher = bnt.matcher(str);
        if (matcher.matches()) {
            long parseLong = (Long.parseLong(matcher.group(4)) * 10000) + (((((Long.parseLong(matcher.group(1)) * 60) * 60) * 1000000) + ((Long.parseLong(matcher.group(2)) * 60) * 1000000)) + (Long.parseLong(matcher.group(3)) * 1000000));
            AppMethodBeat.m2505o(95640);
            return parseLong;
        }
        AppMethodBeat.m2505o(95640);
        return -9223372036854775807L;
    }

    /* renamed from: c */
    public final /* synthetic */ C17659d mo2574c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(95641);
        ArrayList arrayList = new ArrayList();
        C0873g c0873g = new C0873g();
        C32065l c32065l = new C32065l(bArr, i);
        if (!this.bnu) {
            C41604a.m72882B(c32065l);
        }
        m72883a(c32065l, arrayList, c0873g);
        C32044a[] c32044aArr = new C32044a[arrayList.size()];
        arrayList.toArray(c32044aArr);
        C41605b c41605b = new C41605b(c32044aArr, c0873g.toArray());
        AppMethodBeat.m2505o(95641);
        return c41605b;
    }
}
