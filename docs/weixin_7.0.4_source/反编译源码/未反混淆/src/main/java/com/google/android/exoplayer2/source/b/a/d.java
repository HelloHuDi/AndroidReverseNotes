package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d implements com.google.android.exoplayer2.h.t.a<c> {
    private static final Pattern bkb = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern bkc = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern bkd = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern bke = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern bkf = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern bkg = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern bkh = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern bki = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern bkj = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern bkk = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern bkl = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern bkm = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern bkn = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final Pattern bko = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern bkp = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern bkq = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern bkr = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern bks = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern bkt = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern bku = az("AUTOSELECT");
    private static final Pattern bkv = az("DEFAULT");
    private static final Pattern bkw = az("FORCED");

    static class a {
        private final BufferedReader bkx;
        private final Queue<String> bky;
        private String bkz;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.bky = queue;
            this.bkx = bufferedReader;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(125965);
            if (this.bkz != null) {
                AppMethodBeat.o(125965);
                return true;
            } else if (this.bky.isEmpty()) {
                do {
                    String readLine = this.bkx.readLine();
                    this.bkz = readLine;
                    if (readLine != null) {
                        this.bkz = this.bkz.trim();
                    } else {
                        AppMethodBeat.o(125965);
                        return false;
                    }
                } while (this.bkz.isEmpty());
                AppMethodBeat.o(125965);
                return true;
            } else {
                this.bkz = (String) this.bky.poll();
                AppMethodBeat.o(125965);
                return true;
            }
        }

        public final String next() {
            String str;
            AppMethodBeat.i(125966);
            if (hasNext()) {
                str = this.bkz;
                this.bkz = null;
            } else {
                str = null;
            }
            AppMethodBeat.o(125966);
            return str;
        }
    }

    static {
        AppMethodBeat.i(125979);
        AppMethodBeat.o(125979);
    }

    private static c a(Uri uri, InputStream inputStream) {
        AppMethodBeat.i(125967);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        LinkedList linkedList = new LinkedList();
        try {
            if (a(bufferedReader)) {
                String readLine;
                c a;
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        readLine = readLine.trim();
                        if (!readLine.isEmpty()) {
                            if (readLine.startsWith("#EXT-X-STREAM-INF")) {
                                linkedList.add(readLine);
                                a = a(new a(linkedList, bufferedReader), uri.toString());
                                v.closeQuietly(bufferedReader);
                                AppMethodBeat.o(125967);
                                break;
                            } else if (readLine.startsWith("#EXT-X-TARGETDURATION") || readLine.startsWith("#EXT-X-MEDIA-SEQUENCE") || readLine.startsWith("#EXTINF") || readLine.startsWith("#EXT-X-KEY") || readLine.startsWith("#EXT-X-BYTERANGE") || readLine.equals("#EXT-X-DISCONTINUITY") || readLine.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || readLine.equals("#EXT-X-ENDLIST")) {
                                linkedList.add(readLine);
                                a = b(new a(linkedList, bufferedReader), uri.toString());
                            } else {
                                linkedList.add(readLine);
                            }
                        }
                    } else {
                        v.closeQuietly(bufferedReader);
                        o oVar = new o("Failed to parse the playlist, could not identify any tags.");
                        AppMethodBeat.o(125967);
                        throw oVar;
                    }
                }
                linkedList.add(readLine);
                a = b(new a(linkedList, bufferedReader), uri.toString());
                return a;
            }
            b.e("ExoPlayer", "parse, not the #EXTM3U header, uri:%s, reader:%s", uri.toString(), bufferedReader.readLine());
            q qVar = new q("Input does not start with the #EXTM3U header.", uri);
            AppMethodBeat.o(125967);
            throw qVar;
        } finally {
            v.closeQuietly(bufferedReader);
            AppMethodBeat.o(125967);
        }
    }

    private static boolean a(BufferedReader bufferedReader) {
        AppMethodBeat.i(125968);
        int read = bufferedReader.read();
        if (read == com.tencent.view.d.MIC_PTU_SHISHANG2) {
            if (bufferedReader.read() == 187 && bufferedReader.read() == 191) {
                read = bufferedReader.read();
            } else {
                AppMethodBeat.o(125968);
                return false;
            }
        }
        char a = a(bufferedReader, true, read);
        for (read = 0; read < 7; read++) {
            if (a != "#EXTM3U".charAt(read)) {
                AppMethodBeat.o(125968);
                return false;
            }
            a = bufferedReader.read();
        }
        boolean eQ = v.eQ(a(bufferedReader, false, a));
        AppMethodBeat.o(125968);
        return eQ;
    }

    private static int a(BufferedReader bufferedReader, boolean z, int i) {
        AppMethodBeat.i(125969);
        while (i != -1 && Character.isWhitespace(i) && (z || !v.eQ(i))) {
            i = bufferedReader.read();
        }
        AppMethodBeat.o(125969);
        return i;
    }

    private static a a(a aVar, String str) {
        AppMethodBeat.i(125970);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Format format = null;
        List list = null;
        int i = 0;
        while (aVar.hasNext()) {
            String next = aVar.next();
            b.i("master ExoPlayer", next, new Object[0]);
            if (next.startsWith("#EXT")) {
                arrayList4.add(next);
            }
            int i2;
            int i3;
            int i4;
            String c;
            String d;
            String d2;
            int parseInt;
            if (next.startsWith("#EXT-X-MEDIA")) {
                i2 = (e(next, bkw) ? 2 : 0) | (e(next, bkv) ? 1 : 0);
                if (e(next, bku)) {
                    i3 = 4;
                } else {
                    i3 = 0;
                }
                i4 = i2 | i3;
                c = c(next, bko);
                d = d(next, bks);
                String c2 = c(next, bkr);
                d2 = d(next, bkq);
                Object obj = -1;
                switch (d2.hashCode()) {
                    case -959297733:
                        if (d2.equals("SUBTITLES")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case -333210994:
                        if (d2.equals("CLOSED-CAPTIONS")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 62628790:
                        if (d2.equals("AUDIO")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        Format a = Format.a(d, "application/x-mpegURL", i4, c2);
                        if (c != null) {
                            arrayList2.add(new com.google.android.exoplayer2.source.b.a.a.a(c, a));
                            break;
                        }
                        format = a;
                        break;
                    case 1:
                        arrayList3.add(new com.google.android.exoplayer2.source.b.a.a.a(c, Format.a(d, "application/x-mpegURL", "text/vtt", i4, c2)));
                        break;
                    case 2:
                        String d3 = d(next, bkt);
                        if (d3.startsWith("CC")) {
                            c = "application/cea-608";
                            parseInt = Integer.parseInt(d3.substring(2));
                        } else {
                            c = "application/cea-708";
                            parseInt = Integer.parseInt(d3.substring(7));
                        }
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(Format.a(d, null, c, i4, c2, parseInt));
                        break;
                    default:
                        break;
                }
            } else if (next.startsWith("#EXT-X-STREAM-INF")) {
                int i5;
                i4 = a(next, bkc);
                d = c(next, bkb);
                if (d != null) {
                    i4 = Integer.parseInt(d);
                }
                c = c(next, bkd);
                d = c(next, bke);
                i |= next.contains("CLOSED-CAPTIONS=NONE");
                if (d != null) {
                    String[] split = d.split(VideoMaterialUtil.CRAZYFACE_X);
                    i2 = Integer.parseInt(split[0]);
                    i3 = Integer.parseInt(split[1]);
                    if (i2 <= 0 || i3 <= 0) {
                        i2 = -1;
                        i3 = -1;
                    }
                    parseInt = i3;
                    i5 = i2;
                } else {
                    i5 = -1;
                    parseInt = -1;
                }
                d2 = aVar.next();
                if (hashSet.add(d2)) {
                    arrayList.add(new com.google.android.exoplayer2.source.b.a.a.a(d2, Format.a(Integer.toString(arrayList.size()), "application/x-mpegURL", c, i4, i5, parseInt)));
                }
            }
        }
        if (i != 0) {
            list = Collections.emptyList();
        }
        a aVar2 = new a(str, arrayList4, arrayList, arrayList2, arrayList3, format, list);
        AppMethodBeat.o(125970);
        return aVar2;
    }

    private static b b(a aVar, String str) {
        AppMethodBeat.i(125971);
        int i = 0;
        long j = -9223372036854775807L;
        int i2 = 0;
        int i3 = 1;
        long j2 = -9223372036854775807L;
        boolean z = false;
        boolean z2 = false;
        com.google.android.exoplayer2.source.b.a.b.a aVar2 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j3 = 0;
        boolean z3 = false;
        long j4 = 0;
        long j5 = -1;
        boolean z4 = false;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        long j6 = 0;
        long j7 = 0;
        int i5 = 0;
        int i6 = 0;
        while (aVar.hasNext()) {
            String next = aVar.next();
            b.i("ExoPlayer", next, new Object[0]);
            if (next.startsWith("#EXT")) {
                arrayList2.add(next);
            }
            String d;
            int i7;
            String[] split;
            long parseLong;
            long parseLong2;
            if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                d = d(next, bkh);
                if ("VOD".equals(d)) {
                    i = 1;
                } else {
                    if ("EVENT".equals(d)) {
                        i7 = 2;
                    } else {
                        i7 = i;
                    }
                    i = i7;
                }
            } else if (next.startsWith("#EXT-X-START")) {
                j = (long) (b(next, bkk) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-MAP")) {
                String d2 = d(next, bko);
                d = c(next, bkm);
                if (d != null) {
                    split = d.split("@");
                    parseLong = Long.parseLong(split[0]);
                    if (split.length > 1) {
                        j4 = Long.parseLong(split[1]);
                    }
                } else {
                    parseLong = j5;
                }
                com.google.android.exoplayer2.source.b.a.b.a aVar3 = new com.google.android.exoplayer2.source.b.a.b.a(d2, j4, parseLong);
                j4 = 0;
                j5 = -1;
                aVar2 = aVar3;
            } else if (next.startsWith("#EXT-X-TARGETDURATION")) {
                j2 = ((long) a(next, bkf)) * 1000000;
            } else if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                i7 = a(next, bki);
                i4 = i7;
                i2 = i7;
            } else if (next.startsWith("#EXT-X-VERSION")) {
                i3 = a(next, bkg);
            } else if (next.startsWith("#EXTINF")) {
                j3 = (long) (b(next, bkj) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-KEY")) {
                z4 = "AES-128".equals(d(next, bkn));
                if (z4) {
                    str2 = d(next, bko);
                    str3 = c(next, bkp);
                } else {
                    str2 = null;
                    str3 = null;
                }
            } else if (next.startsWith("#EXT-X-BYTERANGE")) {
                split = d(next, bkl).split("@");
                j5 = Long.parseLong(split[0]);
                if (split.length > 1) {
                    parseLong2 = Long.parseLong(split[1]);
                } else {
                    parseLong2 = j4;
                }
                j4 = parseLong2;
            } else if (next.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                i6 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                z3 = true;
            } else if (next.equals("#EXT-X-DISCONTINUITY")) {
                i5++;
            } else if (next.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                if (j7 == 0) {
                    j7 = com.google.android.exoplayer2.b.x(v.aS(next.substring(next.indexOf(58) + 1))) - j6;
                }
            } else if (!next.startsWith("#")) {
                String str4;
                long j8;
                if (!z4) {
                    str4 = null;
                } else if (str3 != null) {
                    str4 = str3;
                } else {
                    str4 = Integer.toHexString(i4);
                }
                int i8 = i4 + 1;
                if (j5 == -1) {
                    j8 = 0;
                } else {
                    j8 = j4;
                }
                arrayList.add(new com.google.android.exoplayer2.source.b.a.b.a(next, j3, i5, j6, z4, str2, str4, j8, j5));
                parseLong = j6 + j3;
                j3 = 0;
                if (j5 != -1) {
                    parseLong2 = j8 + j5;
                } else {
                    parseLong2 = j8;
                }
                j5 = -1;
                i4 = i8;
                j4 = parseLong2;
                j6 = parseLong;
            } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z = true;
            } else if (next.equals("#EXT-X-ENDLIST")) {
                z2 = true;
            }
        }
        b bVar = new b(i, str, arrayList2, j, j7, z3, i6, i2, i3, j2, z, z2, j7 != 0, aVar2, arrayList);
        AppMethodBeat.o(125971);
        return bVar;
    }

    private static int a(String str, Pattern pattern) {
        AppMethodBeat.i(125972);
        int parseInt = Integer.parseInt(d(str, pattern));
        AppMethodBeat.o(125972);
        return parseInt;
    }

    private static double b(String str, Pattern pattern) {
        AppMethodBeat.i(125973);
        double parseDouble = Double.parseDouble(d(str, pattern));
        AppMethodBeat.o(125973);
        return parseDouble;
    }

    private static String c(String str, Pattern pattern) {
        AppMethodBeat.i(125974);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            AppMethodBeat.o(125974);
            return group;
        }
        AppMethodBeat.o(125974);
        return null;
    }

    private static String d(String str, Pattern pattern) {
        AppMethodBeat.i(125975);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            String group = matcher.group(1);
            AppMethodBeat.o(125975);
            return group;
        }
        o oVar = new o("Couldn't match " + pattern.pattern() + " in " + str);
        AppMethodBeat.o(125975);
        throw oVar;
    }

    private static boolean e(String str, Pattern pattern) {
        AppMethodBeat.i(125976);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            boolean equals = matcher.group(1).equals("YES");
            AppMethodBeat.o(125976);
            return equals;
        }
        AppMethodBeat.o(125976);
        return false;
    }

    private static Pattern az(String str) {
        AppMethodBeat.i(125977);
        Pattern compile = Pattern.compile(str + "=(NO|YES)");
        AppMethodBeat.o(125977);
        return compile;
    }
}
