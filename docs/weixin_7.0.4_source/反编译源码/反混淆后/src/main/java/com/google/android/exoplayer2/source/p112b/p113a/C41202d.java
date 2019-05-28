package com.google.android.exoplayer2.source.p112b.p113a;

import android.net.Uri;
import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p110h.C41614t.C37263a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p1585d.C41599b;
import com.google.android.exoplayer2.source.C41632q;
import com.google.android.exoplayer2.source.p112b.p113a.C25553a.C25552a;
import com.google.android.exoplayer2.source.p112b.p113a.C37272b.C37273a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
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

/* renamed from: com.google.android.exoplayer2.source.b.a.d */
public final class C41202d implements C37263a<C45047c> {
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
    private static final Pattern bku = C41202d.m71714az("AUTOSELECT");
    private static final Pattern bkv = C41202d.m71714az("DEFAULT");
    private static final Pattern bkw = C41202d.m71714az("FORCED");

    /* renamed from: com.google.android.exoplayer2.source.b.a.d$a */
    static class C25554a {
        private final BufferedReader bkx;
        private final Queue<String> bky;
        private String bkz;

        public C25554a(Queue<String> queue, BufferedReader bufferedReader) {
            this.bky = queue;
            this.bkx = bufferedReader;
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(125965);
            if (this.bkz != null) {
                AppMethodBeat.m2505o(125965);
                return true;
            } else if (this.bky.isEmpty()) {
                do {
                    String readLine = this.bkx.readLine();
                    this.bkz = readLine;
                    if (readLine != null) {
                        this.bkz = this.bkz.trim();
                    } else {
                        AppMethodBeat.m2505o(125965);
                        return false;
                    }
                } while (this.bkz.isEmpty());
                AppMethodBeat.m2505o(125965);
                return true;
            } else {
                this.bkz = (String) this.bky.poll();
                AppMethodBeat.m2505o(125965);
                return true;
            }
        }

        public final String next() {
            String str;
            AppMethodBeat.m2504i(125966);
            if (hasNext()) {
                str = this.bkz;
                this.bkz = null;
            } else {
                str = null;
            }
            AppMethodBeat.m2505o(125966);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(125979);
        AppMethodBeat.m2505o(125979);
    }

    /* renamed from: a */
    private static C45047c m71712a(Uri uri, InputStream inputStream) {
        AppMethodBeat.m2504i(125967);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        LinkedList linkedList = new LinkedList();
        try {
            if (C41202d.m71713a(bufferedReader)) {
                String readLine;
                C45047c a;
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        readLine = readLine.trim();
                        if (!readLine.isEmpty()) {
                            if (readLine.startsWith("#EXT-X-STREAM-INF")) {
                                linkedList.add(readLine);
                                a = C41202d.m71711a(new C25554a(linkedList, bufferedReader), uri.toString());
                                C17675v.closeQuietly(bufferedReader);
                                AppMethodBeat.m2505o(125967);
                                break;
                            } else if (readLine.startsWith("#EXT-X-TARGETDURATION") || readLine.startsWith("#EXT-X-MEDIA-SEQUENCE") || readLine.startsWith("#EXTINF") || readLine.startsWith("#EXT-X-KEY") || readLine.startsWith("#EXT-X-BYTERANGE") || readLine.equals("#EXT-X-DISCONTINUITY") || readLine.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || readLine.equals("#EXT-X-ENDLIST")) {
                                linkedList.add(readLine);
                                a = C41202d.m71716b(new C25554a(linkedList, bufferedReader), uri.toString());
                            } else {
                                linkedList.add(readLine);
                            }
                        }
                    } else {
                        C17675v.closeQuietly(bufferedReader);
                        C37269o c37269o = new C37269o("Failed to parse the playlist, could not identify any tags.");
                        AppMethodBeat.m2505o(125967);
                        throw c37269o;
                    }
                }
                linkedList.add(readLine);
                a = C41202d.m71716b(new C25554a(linkedList, bufferedReader), uri.toString());
                return a;
            }
            C41599b.m72863e("ExoPlayer", "parse, not the #EXTM3U header, uri:%s, reader:%s", uri.toString(), bufferedReader.readLine());
            C41632q c41632q = new C41632q("Input does not start with the #EXTM3U header.", uri);
            AppMethodBeat.m2505o(125967);
            throw c41632q;
        } finally {
            C17675v.closeQuietly(bufferedReader);
            AppMethodBeat.m2505o(125967);
        }
    }

    /* renamed from: a */
    private static boolean m71713a(BufferedReader bufferedReader) {
        AppMethodBeat.m2504i(125968);
        int read = bufferedReader.read();
        if (read == C31128d.MIC_PTU_SHISHANG2) {
            if (bufferedReader.read() == 187 && bufferedReader.read() == 191) {
                read = bufferedReader.read();
            } else {
                AppMethodBeat.m2505o(125968);
                return false;
            }
        }
        char a = C41202d.m71709a(bufferedReader, true, read);
        for (read = 0; read < 7; read++) {
            if (a != "#EXTM3U".charAt(read)) {
                AppMethodBeat.m2505o(125968);
                return false;
            }
            a = bufferedReader.read();
        }
        boolean eQ = C17675v.m27568eQ(C41202d.m71709a(bufferedReader, false, a));
        AppMethodBeat.m2505o(125968);
        return eQ;
    }

    /* renamed from: a */
    private static int m71709a(BufferedReader bufferedReader, boolean z, int i) {
        AppMethodBeat.m2504i(125969);
        while (i != -1 && Character.isWhitespace(i) && (z || !C17675v.m27568eQ(i))) {
            i = bufferedReader.read();
        }
        AppMethodBeat.m2505o(125969);
        return i;
    }

    /* renamed from: a */
    private static C25553a m71711a(C25554a c25554a, String str) {
        AppMethodBeat.m2504i(125970);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Format format = null;
        List list = null;
        int i = 0;
        while (c25554a.hasNext()) {
            String next = c25554a.next();
            C41599b.m72864i("master ExoPlayer", next, new Object[0]);
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
                i2 = (C41202d.m71719e(next, bkw) ? 2 : 0) | (C41202d.m71719e(next, bkv) ? 1 : 0);
                if (C41202d.m71719e(next, bku)) {
                    i3 = 4;
                } else {
                    i3 = 0;
                }
                i4 = i2 | i3;
                c = C41202d.m71717c(next, bko);
                d = C41202d.m71718d(next, bks);
                String c2 = C41202d.m71717c(next, bkr);
                d2 = C41202d.m71718d(next, bkq);
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
                        Format a = Format.m15274a(d, "application/x-mpegURL", i4, c2);
                        if (c != null) {
                            arrayList2.add(new C25552a(c, a));
                            break;
                        }
                        format = a;
                        break;
                    case 1:
                        arrayList3.add(new C25552a(c, Format.m15280a(d, "application/x-mpegURL", "text/vtt", i4, c2)));
                        break;
                    case 2:
                        String d3 = C41202d.m71718d(next, bkt);
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
                        list.add(Format.m15281a(d, null, c, i4, c2, parseInt));
                        break;
                    default:
                        break;
                }
            } else if (next.startsWith("#EXT-X-STREAM-INF")) {
                int i5;
                i4 = C41202d.m71710a(next, bkc);
                d = C41202d.m71717c(next, bkb);
                if (d != null) {
                    i4 = Integer.parseInt(d);
                }
                c = C41202d.m71717c(next, bkd);
                d = C41202d.m71717c(next, bke);
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
                d2 = c25554a.next();
                if (hashSet.add(d2)) {
                    arrayList.add(new C25552a(d2, Format.m15279a(Integer.toString(arrayList.size()), "application/x-mpegURL", c, i4, i5, parseInt)));
                }
            }
        }
        if (i != 0) {
            list = Collections.emptyList();
        }
        C25553a c25553a = new C25553a(str, arrayList4, arrayList, arrayList2, arrayList3, format, list);
        AppMethodBeat.m2505o(125970);
        return c25553a;
    }

    /* renamed from: b */
    private static C37272b m71716b(C25554a c25554a, String str) {
        AppMethodBeat.m2504i(125971);
        int i = 0;
        long j = -9223372036854775807L;
        int i2 = 0;
        int i3 = 1;
        long j2 = -9223372036854775807L;
        boolean z = false;
        boolean z2 = false;
        C37273a c37273a = null;
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
        while (c25554a.hasNext()) {
            String next = c25554a.next();
            C41599b.m72864i("ExoPlayer", next, new Object[0]);
            if (next.startsWith("#EXT")) {
                arrayList2.add(next);
            }
            String d;
            int i7;
            String[] split;
            long parseLong;
            long parseLong2;
            if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                d = C41202d.m71718d(next, bkh);
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
                j = (long) (C41202d.m71715b(next, bkk) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-MAP")) {
                String d2 = C41202d.m71718d(next, bko);
                d = C41202d.m71717c(next, bkm);
                if (d != null) {
                    split = d.split("@");
                    parseLong = Long.parseLong(split[0]);
                    if (split.length > 1) {
                        j4 = Long.parseLong(split[1]);
                    }
                } else {
                    parseLong = j5;
                }
                C37273a c37273a2 = new C37273a(d2, j4, parseLong);
                j4 = 0;
                j5 = -1;
                c37273a = c37273a2;
            } else if (next.startsWith("#EXT-X-TARGETDURATION")) {
                j2 = ((long) C41202d.m71710a(next, bkf)) * 1000000;
            } else if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                i7 = C41202d.m71710a(next, bki);
                i4 = i7;
                i2 = i7;
            } else if (next.startsWith("#EXT-X-VERSION")) {
                i3 = C41202d.m71710a(next, bkg);
            } else if (next.startsWith("#EXTINF")) {
                j3 = (long) (C41202d.m71715b(next, bkj) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-KEY")) {
                z4 = "AES-128".equals(C41202d.m71718d(next, bkn));
                if (z4) {
                    str2 = C41202d.m71718d(next, bko);
                    str3 = C41202d.m71717c(next, bkp);
                } else {
                    str2 = null;
                    str3 = null;
                }
            } else if (next.startsWith("#EXT-X-BYTERANGE")) {
                split = C41202d.m71718d(next, bkl).split("@");
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
                    j7 = C17628b.m27434x(C17675v.m27561aS(next.substring(next.indexOf(58) + 1))) - j6;
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
                arrayList.add(new C37273a(next, j3, i5, j6, z4, str2, str4, j8, j5));
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
        C37272b c37272b = new C37272b(i, str, arrayList2, j, j7, z3, i6, i2, i3, j2, z, z2, j7 != 0, c37273a, arrayList);
        AppMethodBeat.m2505o(125971);
        return c37272b;
    }

    /* renamed from: a */
    private static int m71710a(String str, Pattern pattern) {
        AppMethodBeat.m2504i(125972);
        int parseInt = Integer.parseInt(C41202d.m71718d(str, pattern));
        AppMethodBeat.m2505o(125972);
        return parseInt;
    }

    /* renamed from: b */
    private static double m71715b(String str, Pattern pattern) {
        AppMethodBeat.m2504i(125973);
        double parseDouble = Double.parseDouble(C41202d.m71718d(str, pattern));
        AppMethodBeat.m2505o(125973);
        return parseDouble;
    }

    /* renamed from: c */
    private static String m71717c(String str, Pattern pattern) {
        AppMethodBeat.m2504i(125974);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            AppMethodBeat.m2505o(125974);
            return group;
        }
        AppMethodBeat.m2505o(125974);
        return null;
    }

    /* renamed from: d */
    private static String m71718d(String str, Pattern pattern) {
        AppMethodBeat.m2504i(125975);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            String group = matcher.group(1);
            AppMethodBeat.m2505o(125975);
            return group;
        }
        C37269o c37269o = new C37269o("Couldn't match " + pattern.pattern() + " in " + str);
        AppMethodBeat.m2505o(125975);
        throw c37269o;
    }

    /* renamed from: e */
    private static boolean m71719e(String str, Pattern pattern) {
        AppMethodBeat.m2504i(125976);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            boolean equals = matcher.group(1).equals("YES");
            AppMethodBeat.m2505o(125976);
            return equals;
        }
        AppMethodBeat.m2505o(125976);
        return false;
    }

    /* renamed from: az */
    private static Pattern m71714az(String str) {
        AppMethodBeat.m2504i(125977);
        Pattern compile = Pattern.compile(str + "=(NO|YES)");
        AppMethodBeat.m2505o(125977);
        return compile;
    }
}
