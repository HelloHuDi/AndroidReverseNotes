package com.tencent.mm.plugin.story.g;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002KLB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010#\u001a\u00020\fJ\u001a\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\fH\u0002J\u0006\u0010(\u001a\u00020\bJ\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004H\u0002J\u000e\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u001fJ\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u0014\u0010-\u001a\u00020\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/J\u0006\u00100\u001a\u00020\u001fJ\u0010\u00101\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\fH\u0002J\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020\u001fJ\u000e\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\fJ\u0006\u00106\u001a\u00020\u001fJ*\u00107\u001a\u00020\u001f2\u0012\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001c0\u001c2\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fJ\u000e\u0010;\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J.\u0010>\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00042\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fJ\u0016\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020BJ\u000e\u0010?\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010C\u001a\u00020\u001fJ \u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0004H\u0002J\u0016\u0010H\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\bJ\u000e\u0010J\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
public final class b {
    private static boolean isWaiting;
    public static long lhy = 998;
    public static boolean mgU = true;
    public static long sbh;
    public static final Map<Long, a> sbi;
    public static a sbj;
    public static long sbk;
    private static long sbl;
    private static long sbm;
    public static g sbn;
    public static boolean sbo;
    public static long sbp;
    private static long sbq;
    private static long sbr;
    private static int sbs;
    private static int sbt;
    private static boolean sbu;
    private static ArrayList<String> sbv;
    public static final b sbw = new b();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        private final String cIS;
        public boolean eTf;
        public boolean isWaiting;
        public boolean koC;
        public boolean rmk;
        public boolean sbA;
        public long sbB;
        private b sbC;
        long sbx;
        public long sby;
        public long sbz;

        public a(String str, b bVar) {
            j.p(str, "user");
            j.p(bVar, "state");
            AppMethodBeat.i(109764);
            this.cIS = str;
            this.sbC = bVar;
            AppMethodBeat.o(109764);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "", "s", "", "(Ljava/lang/String;II)V", "getS", "()I", "SHOW", "PLAY", "WAIT", "plugin-story_release"})
    public enum b {
        SHOW(1),
        PLAY(2),
        WAIT(3);
        
        private final int s;

        private b(int i) {
            this.s = i;
        }

        static {
            AppMethodBeat.o(109765);
        }
    }

    static {
        AppMethodBeat.i(109780);
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        j.o(synchronizedMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
        sbi = synchronizedMap;
        AppMethodBeat.o(109780);
    }

    private b() {
    }

    public static void EV(int i) {
        if (i == 1 || i == 2) {
            lhy = 998;
        } else if (i == 3) {
            lhy = 1006;
        } else {
            lhy = -1;
        }
    }

    public static void l(long j, long j2, long j3) {
        AppMethodBeat.i(109768);
        if (j < 0) {
            AppMethodBeat.o(109768);
            return;
        }
        h.pYm.k(j, j2, j3);
        AppMethodBeat.o(109768);
    }

    public static void clean() {
        AppMethodBeat.i(109769);
        sbl = 0;
        sbm = 0;
        sbr = 0;
        sbu = false;
        sbs = -1;
        sbt = -1;
        sbp = 0;
        sbq = 0;
        sbi.clear();
        sbo = false;
        sbn = null;
        isWaiting = false;
        sbv = new ArrayList();
        sbj = null;
        AppMethodBeat.o(109769);
    }

    public static void dF(List<String> list) {
        AppMethodBeat.i(109770);
        j.p(list, "list");
        ArrayList arrayList = new ArrayList();
        sbv = arrayList;
        arrayList.addAll(list);
        AppMethodBeat.o(109770);
    }

    public static void lj(long j) {
        sbk = j;
    }

    public static void czQ() {
        sbo = true;
    }

    public static void EW(int i) {
        AppMethodBeat.i(109771);
        long gb = bo.gb(sbr);
        ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + i + " cur: " + gb);
        if (gb > 5000) {
            if (i < 10) {
                l(lhy, 82, 1);
                AppMethodBeat.o(109771);
                return;
            } else if (i < 100) {
                l(lhy, 83, 1);
                AppMethodBeat.o(109771);
                return;
            } else if (i < 200) {
                l(lhy, 89, 1);
                AppMethodBeat.o(109771);
                return;
            } else if (i < 250) {
                l(lhy, 84, 1);
                AppMethodBeat.o(109771);
                return;
            } else if (i < 450) {
                l(lhy, 85, 1);
                AppMethodBeat.o(109771);
                return;
            } else if (i < TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR) {
                l(lhy, 86, 1);
                AppMethodBeat.o(109771);
                return;
            } else if (i < 1350) {
                l(lhy, 87, 1);
                AppMethodBeat.o(109771);
                return;
            } else if (i < 1800) {
                l(lhy, 88, 1);
            }
        }
        AppMethodBeat.o(109771);
    }

    public static void b(ArrayList<ArrayList<g>> arrayList, int i, int i2) {
        AppMethodBeat.i(109772);
        j.p(arrayList, "group");
        if (aiG()) {
            boolean z;
            boolean z2;
            ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + sbt + ",last_selectedRow:" + sbs + " selectedRow:" + i + ",selectedColumn:" + i2);
            if (arrayList.size() > 0) {
                boolean z3;
                if (((ArrayList) arrayList.get(i)).size() <= 0 || i2 + 1 >= ((ArrayList) arrayList.get(i)).size()) {
                    z = false;
                } else {
                    if (!sbu) {
                        l(lhy, 101, 1);
                    }
                    z = true;
                }
                if (i + 1 < arrayList.size()) {
                    if (!sbu) {
                        l(lhy, 102, 1);
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                sbu = true;
                z2 = z3;
            } else {
                z2 = false;
                z = false;
            }
            if (!(sbt == -1 || sbs == -1)) {
                if (isWaiting) {
                    l(lhy, 100, 1);
                    isWaiting = false;
                }
                int i3;
                if (i != sbs) {
                    if (z) {
                        l(lhy, 105, 1);
                    }
                    l(lhy, 106, 1);
                    i3 = i - sbs;
                    if (i3 == 1) {
                        l(lhy, 110, 1);
                    } else if (i3 == 2) {
                        l(lhy, 111, 1);
                    } else if (i3 == 3) {
                        l(lhy, 112, 1);
                    } else if (i3 >= 4) {
                        l(lhy, 113, 1);
                    }
                    if (arrayList.size() > 0) {
                        int i4 = 0;
                        while (i4 < 3) {
                            if (i + i4 < arrayList.size() && ((ArrayList) arrayList.get(i + i4)).size() > 0) {
                                i iVar = ((g) ((ArrayList) arrayList.get(i + i4)).get(0)).rVZ;
                                if (!(iVar == null || iVar.username == null || sbv == null)) {
                                    ArrayList arrayList2 = sbv;
                                    if (arrayList2 != null && arrayList2.contains(iVar.username)) {
                                        if (b(iVar) == 1) {
                                            if (i4 == 0) {
                                                l(lhy, 120, 1);
                                            } else if (i4 == 1) {
                                                l(lhy, 121, 1);
                                            } else if (i4 == 2) {
                                                l(lhy, 122, 1);
                                            }
                                        }
                                        if (i4 == 0) {
                                            l(lhy, 125, 1);
                                        } else if (i4 == 1) {
                                            l(lhy, 126, 1);
                                        } else if (i4 == 2) {
                                            l(lhy, 127, 1);
                                        }
                                    }
                                }
                            }
                            i4++;
                        }
                    }
                } else if (i2 != sbt) {
                    if (z2) {
                        l(lhy, 103, 1);
                    }
                    l(lhy, 104, 1);
                    i3 = i2 - sbt;
                    if (i3 == 1) {
                        l(lhy, 115, 1);
                    } else if (i3 == 2) {
                        l(lhy, 116, 1);
                    } else if (i3 == 3) {
                        l(lhy, 117, 1);
                    } else if (i3 >= 4) {
                        l(lhy, 118, 1);
                    }
                }
                if (sbs >= 0 && sbs < arrayList.size() && sbt >= 0 && sbt < ((ArrayList) arrayList.get(sbs)).size() && !(sbt == i2 && sbs == i)) {
                    long j = ((g) ((ArrayList) arrayList.get(sbs)).get(sbt)).rVZ.rUJ;
                    ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + j + " lastStoryId " + sbh);
                    if (aiG() && sbi.containsKey(Long.valueOf(j))) {
                        a aVar = (a) sbi.get(Long.valueOf(j));
                        if (aVar != null && aVar.sbx <= 0 && !aVar.rmk && aVar.sby >= 0) {
                            aVar.sbx = bo.gb(aVar.sby);
                            ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + j + ' ' + aVar.sbx + " hasHttp:" + aVar.sbA + "  isWaiting:" + aVar.isWaiting);
                            if (aVar.sbA) {
                                l(lhy, 21, 1);
                                l(lhy, 20, aVar.sbx);
                            }
                            if (aVar.isWaiting) {
                                l(lhy, 23, 1);
                                l(lhy, 22, aVar.sbx);
                            }
                            l(lhy, 25, 1);
                            l(lhy, 24, aVar.sbx);
                            if (aVar.eTf) {
                                l(lhy, 26, 1);
                            }
                        }
                    }
                }
            }
            sbt = i2;
            sbs = i;
            AppMethodBeat.o(109772);
            return;
        }
        AppMethodBeat.o(109772);
    }

    public static /* synthetic */ int c(i iVar) {
        AppMethodBeat.i(109774);
        int b = b(iVar);
        AppMethodBeat.o(109774);
        return b;
    }

    private static int b(i iVar) {
        AppMethodBeat.i(109773);
        s sVar = s.rTV;
        n a = s.a(iVar);
        if (a.cCd()) {
            ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + iVar.rUJ);
            AppMethodBeat.o(109773);
            return 1;
        } else if (a.field_totalSize <= 0) {
            AppMethodBeat.o(109773);
            return 0;
        } else {
            float f = (((float) a.field_cacheSize) / ((float) a.field_totalSize)) * 100.0f;
            com.tencent.mm.plugin.story.ui.view.gallery.n nVar = com.tencent.mm.plugin.story.ui.view.gallery.n.sqi;
            if (f >= ((float) com.tencent.mm.plugin.story.ui.view.gallery.n.cCM().soQ)) {
                ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay cachesize " + a.field_cacheSize + " totalSize: " + a.field_totalSize);
                AppMethodBeat.o(109773);
                return 1;
            }
            AppMethodBeat.o(109773);
            return 0;
        }
    }

    public static void z(long j, boolean z) {
        AppMethodBeat.i(109775);
        if (sbi.containsKey(Long.valueOf(j))) {
            a aVar = (a) sbi.get(Long.valueOf(j));
            if (aVar != null) {
                aVar.sbB = bo.anU();
                aVar.koC = z;
                AppMethodBeat.o(109775);
                return;
            }
            AppMethodBeat.o(109775);
            return;
        }
        AppMethodBeat.o(109775);
    }

    public static void lk(long j) {
        AppMethodBeat.i(109776);
        if (sbi.containsKey(Long.valueOf(j))) {
            a aVar = (a) sbi.get(Long.valueOf(j));
            long gb;
            if (aVar != null && aVar.rmk) {
                AppMethodBeat.o(109776);
                return;
            } else if (j == sbk) {
                aVar = sbj;
                if (aVar == null) {
                    AppMethodBeat.o(109776);
                    return;
                } else if (aVar.sbB <= 0) {
                    AppMethodBeat.o(109776);
                    return;
                } else {
                    gb = bo.gb(aVar.sbB);
                    ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(gb)));
                    if (aVar.koC) {
                        l(lhy, 62, 1);
                        l(lhy, 63, gb);
                    }
                    l(lhy, 60, 1);
                    l(lhy, 61, gb);
                    AppMethodBeat.o(109776);
                    return;
                }
            } else {
                aVar = (a) sbi.get(Long.valueOf(j));
                if (aVar == null) {
                    AppMethodBeat.o(109776);
                    return;
                } else if (aVar.sbB <= 0) {
                    AppMethodBeat.o(109776);
                    return;
                } else {
                    gb = bo.gb(aVar.sbB);
                    ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(gb)));
                    if (aVar.koC) {
                        l(lhy, 62, 1);
                        l(lhy, 63, gb);
                    }
                    l(lhy, 60, 1);
                    l(lhy, 61, gb);
                    AppMethodBeat.o(109776);
                    return;
                }
            }
        }
        AppMethodBeat.o(109776);
    }

    public static void czR() {
        AppMethodBeat.i(109777);
        ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + sbl + " onPlayUser " + sbm);
        sbl = bo.anU();
        AppMethodBeat.o(109777);
    }

    public static void j(String str, long j, int i) {
        AppMethodBeat.i(109778);
        j.p(str, "user");
        if (aiG()) {
            Object obj;
            if (sbp > 0 && sbq <= 0) {
                sbq = bo.gb(sbp);
                l(lhy, 130, 1);
                l(lhy, 131, sbq);
            }
            ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + str + " storyId " + j + " selectedColumn " + i + " lastStoryId:" + sbh + " onStoryLauncherTime " + sbq);
            Object obj2 = null;
            if (!(sbh == j || sbh == 0)) {
                obj2 = 1;
            }
            long j2 = sbh;
            sbh = j;
            j.p(str, "user");
            ArrayList arrayList = sbv;
            if (arrayList == null || !arrayList.contains(str)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                AppMethodBeat.o(109778);
                return;
            }
            if (sbi.containsKey(Long.valueOf(j2)) && obj2 != null) {
                a aVar = (a) sbi.get(Long.valueOf(j2));
                if (aVar != null) {
                    aVar.rmk = true;
                }
            }
            if (i > 0) {
                AppMethodBeat.o(109778);
                return;
            }
            Map map = sbi;
            Long valueOf = Long.valueOf(j);
            a aVar2 = new a(str, b.PLAY);
            aVar2.sby = bo.anU();
            map.put(valueOf, aVar2);
            sbm = bo.anU();
            ab.v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + sbm);
            com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
            f aap = com.tencent.mm.plugin.story.model.j.a.cxU().aap(str);
            ab.i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + str + " preload " + bo.ga(aap.cBL()));
            l(lhy, 2, 1);
            if (aap.cBL() > 0) {
                l(lhy, 3, 1);
            }
            if (j == sbk) {
                if (sbo) {
                    l(lhy, 6, 1);
                } else {
                    l(lhy, 9, 1);
                }
                if (aap.cBL() > 0) {
                    if (sbo) {
                        l(lhy, 7, 1);
                    } else {
                        l(lhy, 10, 1);
                    }
                }
                g gVar = sbn;
                if (gVar != null) {
                    if (b(gVar.rVZ) == 1) {
                        if (sbo) {
                            l(lhy, 8, 1);
                            AppMethodBeat.o(109778);
                            return;
                        }
                        l(lhy, 11, 1);
                    }
                    AppMethodBeat.o(109778);
                    return;
                }
            }
            AppMethodBeat.o(109778);
            return;
        }
        AppMethodBeat.o(109778);
    }

    public static void czS() {
        AppMethodBeat.i(109779);
        sbr = bo.anU();
        AppMethodBeat.o(109779);
    }

    public static boolean aiG() {
        if (sbr > 0 && mgU) {
            return true;
        }
        return false;
    }
}
