package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private String album;
    private String hAf;
    private int lWS = 0;
    public ArrayList<a> oMj = new ArrayList();
    private LinkedList<Long> oMk = new LinkedList();
    private String oMl;
    private String oMm;
    private String oMn;
    private boolean oMo = false;
    private String title;
    private long xb;

    public static final class a {
        public String content;
        public boolean oMp;
        public long timestamp;

        public final String toString() {
            AppMethodBeat.i(104870);
            String format = String.format("[%d %s]", new Object[]{Long.valueOf(this.timestamp), this.content});
            AppMethodBeat.o(104870);
            return format;
        }
    }

    public static a a(String str, String str2, String str3, boolean z, String str4, boolean z2) {
        a aVar;
        AppMethodBeat.i(104871);
        a aVar2 = new a();
        long yz = bo.yz();
        if (bo.isNullOrNil(str)) {
            aVar = new a();
            aVar.timestamp = 0;
            if (z2) {
                aVar.content = str4;
            } else if (z) {
                aVar.content = ah.getContext().getString(R.string.d7l);
            } else {
                aVar.content = ah.getContext().getString(R.string.d7k);
            }
            if (aVar.content != null) {
                aVar2.oMj.add(aVar);
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
                        ab.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
                    } else if (group.startsWith("[ti:")) {
                        aVar2.title = fp(group, "[ti:");
                    } else if (group.startsWith("[ar:")) {
                        aVar2.hAf = fp(group, "[ar:");
                    } else if (group.startsWith("[al:")) {
                        aVar2.album = fp(group, "[al:");
                    } else if (group.startsWith("[by:")) {
                        aVar2.oMl = fp(group, "[by:");
                    } else if (group.startsWith("[offset:")) {
                        aVar2.xb = bo.getLong(fp(group, "[offset:"), 0);
                    } else if (group.startsWith("[re:")) {
                        aVar2.oMm = fp(group, "[re:");
                    } else if (group.startsWith("[ve:")) {
                        aVar2.oMn = fp(group, "[ve:");
                    } else {
                        Pattern compile = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
                        Matcher matcher2 = compile.matcher(group);
                        a aVar3 = new a();
                        while (matcher2.find()) {
                            if (matcher2.groupCount() > 0) {
                                aVar3.timestamp = Tj(matcher2.group(1));
                            }
                            String[] split = compile.split(group);
                            if (split == null || split.length <= 0) {
                                aVar2.oMk.add(Long.valueOf(aVar3.timestamp));
                                break;
                            }
                            String str5 = split[split.length - 1];
                            if (str5 != null) {
                                str5 = str5.trim();
                            }
                            if (bo.isNullOrNil(str5)) {
                                str5 = " ";
                            }
                            aVar3.content = str5;
                            i = 0;
                            while (true) {
                                i2 = i;
                                if (i2 >= aVar2.oMk.size()) {
                                    break;
                                }
                                a aVar4 = new a();
                                aVar4.timestamp = ((Long) aVar2.oMk.get(i2)).longValue();
                                aVar4.content = aVar3.content;
                                aVar4.oMp = true;
                                i = i2 + 1;
                            }
                            aVar2.oMk.clear();
                            i2 = aVar2.oMj.size() - 1;
                            while (i2 >= 0 && ((a) aVar2.oMj.get(i2)).timestamp != aVar3.timestamp) {
                                if (((a) aVar2.oMj.get(i2)).timestamp < aVar3.timestamp) {
                                    aVar2.oMj.add(i2 + 1, aVar3);
                                    break;
                                }
                                i2--;
                            }
                            if (i2 < 0) {
                                aVar2.oMj.add(0, aVar3);
                            }
                        }
                    }
                }
                ab.d("MicroMsg.Music.LyricObj", "handle offset %d", Long.valueOf(aVar2.xb));
                if (aVar2.xb != 0) {
                    i = 0;
                    while (true) {
                        i2 = i;
                        if (i2 >= aVar2.oMj.size()) {
                            break;
                        }
                        aVar = (a) aVar2.oMj.get(i2);
                        aVar.timestamp += aVar2.xb;
                        i = i2 + 1;
                    }
                    aVar2.xb = 0;
                }
                i = 0;
                while (true) {
                    int i3 = i;
                    if (i3 >= aVar2.oMj.size() - 1) {
                        break;
                    }
                    aVar = (a) aVar2.oMj.get(i3);
                    if (aVar.oMp && aVar.content.equals(((a) aVar2.oMj.get(i3 + 1)).content)) {
                        aVar.content = " ";
                    }
                    i = i3 + 1;
                }
            } else {
                ab.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
            }
            ab.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", str);
            ab.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", Integer.valueOf(aVar2.oMj.size()));
        }
        if (bo.isNullOrNil(str3)) {
            ab.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        } else {
            aVar = new a();
            aVar.timestamp = 0;
            aVar.content = ah.getContext().getString(R.string.ezs, new Object[]{s.mJ(str3)});
            if (aVar2.oMj.isEmpty()) {
                aVar2.oMj.add(aVar);
            } else if (aVar2.oMj.size() == 1) {
                aVar2.oMj.add(0, aVar);
                ((a) aVar2.oMj.get(1)).timestamp = 5000;
            } else {
                aVar2.oMj.add(0, aVar);
                ((a) aVar2.oMj.get(1)).timestamp = 3 * (((a) aVar2.oMj.get(2)).timestamp >> 2);
            }
        }
        if (!bo.isNullOrNil(str)) {
            if (bo.isNullOrNil(str2)) {
                ab.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
            } else {
                aVar = new a();
                aVar.timestamp = 0;
                aVar.content = str2;
                if (aVar2.oMj.isEmpty()) {
                    aVar2.oMj.add(aVar);
                } else if (aVar2.oMj.size() == 1) {
                    aVar2.oMj.add(0, aVar);
                    ((a) aVar2.oMj.get(1)).timestamp = 5000;
                } else {
                    aVar2.oMj.add(0, aVar);
                    ((a) aVar2.oMj.get(1)).timestamp = 3 * (((a) aVar2.oMj.get(2)).timestamp >> 2);
                }
            }
        }
        ab.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(104871);
        return aVar2;
    }

    private static String fp(String str, String str2) {
        AppMethodBeat.i(104872);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(104872);
            return str;
        } else if (str2.length() >= str.length() - 1) {
            str = "";
            AppMethodBeat.o(104872);
            return str;
        } else {
            ab.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", str, str2, str.substring(str2.length(), str.length() - 1));
            AppMethodBeat.o(104872);
            return str.substring(str2.length(), str.length() - 1);
        }
    }

    private static long Tj(String str) {
        AppMethodBeat.i(104873);
        try {
            int la;
            int la2;
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            int la3 = d.la(split[0]);
            if (split.length > 1) {
                split = split[1].split("\\.");
                la = d.la(split[0]);
                la2 = split.length > 1 ? d.la(split[1]) : 0;
            } else {
                la2 = 0;
                la = 0;
            }
            long j = ((long) (la2 * 10)) + (((long) (la * 1000)) + ((((long) la3) * 60) * 1000));
            AppMethodBeat.o(104873);
            return j;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.LyricObj", e, "", new Object[0]);
            ab.w("MicroMsg.Music.LyricObj", "strToLong error: %s", e.getLocalizedMessage());
            AppMethodBeat.o(104873);
            return 0;
        }
    }

    public final a zJ(int i) {
        AppMethodBeat.i(104874);
        if (i < 0 || i >= this.oMj.size()) {
            AppMethodBeat.o(104874);
            return null;
        }
        a aVar = (a) this.oMj.get(i);
        AppMethodBeat.o(104874);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(104875);
        AppMethodBeat.o(104875);
    }
}
