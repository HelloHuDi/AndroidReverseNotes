package com.google.android.exoplayer2.f.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends b {
    private static final Pattern bnt = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean bnu;
    private int bnv;
    private int bnw;
    private int bnx;
    private int bny;

    static {
        AppMethodBeat.i(95642);
        AppMethodBeat.o(95642);
    }

    public a() {
        this(null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        AppMethodBeat.i(95636);
        if (list != null) {
            this.bnu = true;
            String str = new String((byte[]) list.get(0));
            com.google.android.exoplayer2.i.a.checkArgument(str.startsWith("Format: "));
            aA(str);
            B(new l((byte[]) list.get(1)));
            AppMethodBeat.o(95636);
            return;
        }
        this.bnu = false;
        AppMethodBeat.o(95636);
    }

    private static void B(l lVar) {
        AppMethodBeat.i(95637);
        String readLine;
        do {
            readLine = lVar.readLine();
            if (readLine == null) {
                AppMethodBeat.o(95637);
                return;
            }
        } while (!readLine.startsWith("[Events]"));
        AppMethodBeat.o(95637);
    }

    private void a(l lVar, List<com.google.android.exoplayer2.f.a> list, g gVar) {
        AppMethodBeat.i(95638);
        while (true) {
            String readLine = lVar.readLine();
            if (readLine == null) {
                AppMethodBeat.o(95638);
                return;
            } else if (!this.bnu && readLine.startsWith("Format: ")) {
                aA(readLine);
            } else if (readLine.startsWith("Dialogue: ") && this.bnv != 0) {
                String[] split = readLine.substring(10).split(",", this.bnv);
                long aB = aB(split[this.bnw]);
                if (aB != -9223372036854775807L) {
                    long j;
                    readLine = split[this.bnx];
                    if (readLine.trim().isEmpty()) {
                        j = -9223372036854775807L;
                    } else {
                        j = aB(readLine);
                        if (j == -9223372036854775807L) {
                        }
                    }
                    list.add(new com.google.android.exoplayer2.f.a(split[this.bny].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", IOUtils.LINE_SEPARATOR_UNIX).replaceAll("\\\\n", IOUtils.LINE_SEPARATOR_UNIX)));
                    gVar.add(aB);
                    if (j != -9223372036854775807L) {
                        list.add(null);
                        gVar.add(j);
                    }
                }
            }
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aA(String str) {
        AppMethodBeat.i(95639);
        String[] split = TextUtils.split(str.substring(8), ",");
        this.bnv = split.length;
        this.bnw = -1;
        this.bnx = -1;
        this.bny = -1;
        for (int i = 0; i < this.bnv; i++) {
            int i2;
            String aR = v.aR(split[i].trim());
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
        AppMethodBeat.o(95639);
    }

    private static long aB(String str) {
        AppMethodBeat.i(95640);
        Matcher matcher = bnt.matcher(str);
        if (matcher.matches()) {
            long parseLong = (Long.parseLong(matcher.group(4)) * 10000) + (((((Long.parseLong(matcher.group(1)) * 60) * 60) * 1000000) + ((Long.parseLong(matcher.group(2)) * 60) * 1000000)) + (Long.parseLong(matcher.group(3)) * 1000000));
            AppMethodBeat.o(95640);
            return parseLong;
        }
        AppMethodBeat.o(95640);
        return -9223372036854775807L;
    }

    public final /* synthetic */ d c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(95641);
        ArrayList arrayList = new ArrayList();
        g gVar = new g();
        l lVar = new l(bArr, i);
        if (!this.bnu) {
            B(lVar);
        }
        a(lVar, arrayList, gVar);
        com.google.android.exoplayer2.f.a[] aVarArr = new com.google.android.exoplayer2.f.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        b bVar = new b(aVarArr, gVar.toArray());
        AppMethodBeat.o(95641);
        return bVar;
    }
}
