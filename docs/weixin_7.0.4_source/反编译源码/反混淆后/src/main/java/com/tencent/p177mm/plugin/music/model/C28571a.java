package com.tencent.p177mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.music.model.a */
public final class C28571a {
    private String album;
    private String hAf;
    private int lWS = 0;
    public ArrayList<C28572a> oMj = new ArrayList();
    private LinkedList<Long> oMk = new LinkedList();
    private String oMl;
    private String oMm;
    private String oMn;
    private boolean oMo = false;
    private String title;
    /* renamed from: xb */
    private long f13698xb;

    /* renamed from: com.tencent.mm.plugin.music.model.a$a */
    public static final class C28572a {
        public String content;
        public boolean oMp;
        public long timestamp;

        public final String toString() {
            AppMethodBeat.m2504i(104870);
            String format = String.format("[%d %s]", new Object[]{Long.valueOf(this.timestamp), this.content});
            AppMethodBeat.m2505o(104870);
            return format;
        }
    }

    /* renamed from: a */
    public static C28571a m45375a(String str, String str2, String str3, boolean z, String str4, boolean z2) {
        C28572a c28572a;
        AppMethodBeat.m2504i(104871);
        C28571a c28571a = new C28571a();
        long yz = C5046bo.m7588yz();
        if (C5046bo.isNullOrNil(str)) {
            c28572a = new C28572a();
            c28572a.timestamp = 0;
            if (z2) {
                c28572a.content = str4;
            } else if (z) {
                c28572a.content = C4996ah.getContext().getString(C25738R.string.d7l);
            } else {
                c28572a.content = C4996ah.getContext().getString(C25738R.string.d7k);
            }
            if (c28572a.content != null) {
                c28571a.oMj.add(c28572a);
            }
        } else {
            if (str != null) {
                int i;
                int i2;
                Matcher matcher = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(str.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, " ").replaceAll("\r", " "));
                while (matcher.find()) {
                    String group = matcher.group();
                    matcher.start();
                    matcher.end();
                    if (group == null) {
                        C4990ab.m7420w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
                    } else if (group.startsWith("[ti:")) {
                        c28571a.title = C28571a.m45376fp(group, "[ti:");
                    } else if (group.startsWith("[ar:")) {
                        c28571a.hAf = C28571a.m45376fp(group, "[ar:");
                    } else if (group.startsWith("[al:")) {
                        c28571a.album = C28571a.m45376fp(group, "[al:");
                    } else if (group.startsWith("[by:")) {
                        c28571a.oMl = C28571a.m45376fp(group, "[by:");
                    } else if (group.startsWith("[offset:")) {
                        c28571a.f13698xb = C5046bo.getLong(C28571a.m45376fp(group, "[offset:"), 0);
                    } else if (group.startsWith("[re:")) {
                        c28571a.oMm = C28571a.m45376fp(group, "[re:");
                    } else if (group.startsWith("[ve:")) {
                        c28571a.oMn = C28571a.m45376fp(group, "[ve:");
                    } else {
                        Pattern compile = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
                        Matcher matcher2 = compile.matcher(group);
                        C28572a c28572a2 = new C28572a();
                        while (matcher2.find()) {
                            if (matcher2.groupCount() > 0) {
                                c28572a2.timestamp = C28571a.m45374Tj(matcher2.group(1));
                            }
                            String[] split = compile.split(group);
                            if (split == null || split.length <= 0) {
                                c28571a.oMk.add(Long.valueOf(c28572a2.timestamp));
                                break;
                            }
                            String str5 = split[split.length - 1];
                            if (str5 != null) {
                                str5 = str5.trim();
                            }
                            if (C5046bo.isNullOrNil(str5)) {
                                str5 = " ";
                            }
                            c28572a2.content = str5;
                            i = 0;
                            while (true) {
                                i2 = i;
                                if (i2 >= c28571a.oMk.size()) {
                                    break;
                                }
                                C28572a c28572a3 = new C28572a();
                                c28572a3.timestamp = ((Long) c28571a.oMk.get(i2)).longValue();
                                c28572a3.content = c28572a2.content;
                                c28572a3.oMp = true;
                                i = i2 + 1;
                            }
                            c28571a.oMk.clear();
                            i2 = c28571a.oMj.size() - 1;
                            while (i2 >= 0 && ((C28572a) c28571a.oMj.get(i2)).timestamp != c28572a2.timestamp) {
                                if (((C28572a) c28571a.oMj.get(i2)).timestamp < c28572a2.timestamp) {
                                    c28571a.oMj.add(i2 + 1, c28572a2);
                                    break;
                                }
                                i2--;
                            }
                            if (i2 < 0) {
                                c28571a.oMj.add(0, c28572a2);
                            }
                        }
                    }
                }
                C4990ab.m7411d("MicroMsg.Music.LyricObj", "handle offset %d", Long.valueOf(c28571a.f13698xb));
                if (c28571a.f13698xb != 0) {
                    i = 0;
                    while (true) {
                        i2 = i;
                        if (i2 >= c28571a.oMj.size()) {
                            break;
                        }
                        c28572a = (C28572a) c28571a.oMj.get(i2);
                        c28572a.timestamp += c28571a.f13698xb;
                        i = i2 + 1;
                    }
                    c28571a.f13698xb = 0;
                }
                i = 0;
                while (true) {
                    int i3 = i;
                    if (i3 >= c28571a.oMj.size() - 1) {
                        break;
                    }
                    c28572a = (C28572a) c28571a.oMj.get(i3);
                    if (c28572a.oMp && c28572a.content.equals(((C28572a) c28571a.oMj.get(i3 + 1)).content)) {
                        c28572a.content = " ";
                    }
                    i = i3 + 1;
                }
            } else {
                C4990ab.m7420w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
            }
            C4990ab.m7411d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", str);
            C4990ab.m7411d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", Integer.valueOf(c28571a.oMj.size()));
        }
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7420w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        } else {
            c28572a = new C28572a();
            c28572a.timestamp = 0;
            c28572a.content = C4996ah.getContext().getString(C25738R.string.ezs, new Object[]{C1854s.m3866mJ(str3)});
            if (c28571a.oMj.isEmpty()) {
                c28571a.oMj.add(c28572a);
            } else if (c28571a.oMj.size() == 1) {
                c28571a.oMj.add(0, c28572a);
                ((C28572a) c28571a.oMj.get(1)).timestamp = 5000;
            } else {
                c28571a.oMj.add(0, c28572a);
                ((C28572a) c28571a.oMj.get(1)).timestamp = 3 * (((C28572a) c28571a.oMj.get(2)).timestamp >> 2);
            }
        }
        if (!C5046bo.isNullOrNil(str)) {
            if (C5046bo.isNullOrNil(str2)) {
                C4990ab.m7420w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
            } else {
                c28572a = new C28572a();
                c28572a.timestamp = 0;
                c28572a.content = str2;
                if (c28571a.oMj.isEmpty()) {
                    c28571a.oMj.add(c28572a);
                } else if (c28571a.oMj.size() == 1) {
                    c28571a.oMj.add(0, c28572a);
                    ((C28572a) c28571a.oMj.get(1)).timestamp = 5000;
                } else {
                    c28571a.oMj.add(0, c28572a);
                    ((C28572a) c28571a.oMj.get(1)).timestamp = 3 * (((C28572a) c28571a.oMj.get(2)).timestamp >> 2);
                }
            }
        }
        C4990ab.m7411d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(104871);
        return c28571a;
    }

    /* renamed from: fp */
    private static String m45376fp(String str, String str2) {
        AppMethodBeat.m2504i(104872);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(104872);
            return str;
        } else if (str2.length() >= str.length() - 1) {
            str = "";
            AppMethodBeat.m2505o(104872);
            return str;
        } else {
            C4990ab.m7411d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", str, str2, str.substring(str2.length(), str.length() - 1));
            AppMethodBeat.m2505o(104872);
            return str.substring(str2.length(), str.length() - 1);
        }
    }

    /* renamed from: Tj */
    private static long m45374Tj(String str) {
        AppMethodBeat.m2504i(104873);
        try {
            int la;
            int la2;
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            int la3 = C39444d.m67388la(split[0]);
            if (split.length > 1) {
                split = split[1].split("\\.");
                la = C39444d.m67388la(split[0]);
                la2 = split.length > 1 ? C39444d.m67388la(split[1]) : 0;
            } else {
                la2 = 0;
                la = 0;
            }
            long j = ((long) (la2 * 10)) + (((long) (la * 1000)) + ((((long) la3) * 60) * 1000));
            AppMethodBeat.m2505o(104873);
            return j;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.LyricObj", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.Music.LyricObj", "strToLong error: %s", e.getLocalizedMessage());
            AppMethodBeat.m2505o(104873);
            return 0;
        }
    }

    /* renamed from: zJ */
    public final C28572a mo46702zJ(int i) {
        AppMethodBeat.m2504i(104874);
        if (i < 0 || i >= this.oMj.size()) {
            AppMethodBeat.m2505o(104874);
            return null;
        }
        C28572a c28572a = (C28572a) this.oMj.get(i);
        AppMethodBeat.m2505o(104874);
        return c28572a;
    }

    private C28571a() {
        AppMethodBeat.m2504i(104875);
        AppMethodBeat.m2505o(104875);
    }
}
