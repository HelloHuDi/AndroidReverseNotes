package com.tencent.p177mm.plugin.story.p531g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.C43649s;
import com.tencent.p177mm.plugin.story.model.p533d.C35201i;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.p532h.C29298n;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C39933n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002KLB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010#\u001a\u00020\fJ\u001a\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\fH\u0002J\u0006\u0010(\u001a\u00020\bJ\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004H\u0002J\u000e\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u001fJ\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u0014\u0010-\u001a\u00020\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060/J\u0006\u00100\u001a\u00020\u001fJ\u0010\u00101\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\fH\u0002J\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020\u001fJ\u000e\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\fJ\u0006\u00106\u001a\u00020\u001fJ*\u00107\u001a\u00020\u001f2\u0012\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001c0\u001c2\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fJ\u000e\u0010;\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J.\u0010>\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00042\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fJ\u0016\u0010?\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020BJ\u000e\u0010?\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010C\u001a\u00020\u001fJ \u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0004H\u0002J\u0016\u0010H\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\bJ\u000e\u0010J\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "isWaiting", "", "isWifi", "lastStoryId", "last_selectedColumn", "", "last_selectedRow", "markGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "markStoryId", "onClickTime", "onCreateTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStoryLauncherTime", "preLoadInfo", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "storyIdsState", "", "unReadList", "Ljava/util/ArrayList;", "withCache", "canPlay", "", "user", "storyId", "chatting", "clickScene", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkReport", "checkStayTime", "checkUnRead", "clean", "downloadEnd", "enter", "list", "", "finish", "initID", "markInit", "markResumeTime", "netSpeed", "speed", "onDestroy", "onSelectItem", "group", "selectedRow", "selectedColumn", "onVideoEnd", "onVideoPlay", "onVideoWaiting", "playUser", "preLoadVideo", "galleryItem", "extinfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "preloadWithCache", "report", "IID", "key", "mval", "startDownload", "isAll", "startHttp", "Info", "State", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.g.b */
public final class C4116b {
    private static boolean isWaiting;
    public static long lhy = 998;
    public static boolean mgU = true;
    public static long sbh;
    public static final Map<Long, C4117a> sbi;
    public static C4117a sbj;
    public static long sbk;
    private static long sbl;
    private static long sbm;
    public static C43640g sbn;
    public static boolean sbo;
    public static long sbp;
    private static long sbq;
    private static long sbr;
    private static int sbs;
    private static int sbt;
    private static boolean sbu;
    private static ArrayList<String> sbv;
    public static final C4116b sbw = new C4116b();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001a\u0010\u0014\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006+"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$Info;", "", "user", "", "state", "Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "clean", "", "getClean", "()Z", "setClean", "(Z)V", "hasHttp", "getHasHttp", "setHasHttp", "isAll", "setAll", "isEnd", "setEnd", "isWaiting", "setWaiting", "onMarkPlayCall", "", "getOnMarkPlayCall", "()J", "setOnMarkPlayCall", "(J)V", "onMarkPlayingCall", "getOnMarkPlayingCall", "setOnMarkPlayingCall", "onStayTime", "getOnStayTime", "setOnStayTime", "startHttp", "getStartHttp", "setStartHttp", "getState", "()Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "setState", "(Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;)V", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.g.b$a */
    public static final class C4117a {
        private final String cIS;
        public boolean eTf;
        public boolean isWaiting;
        public boolean koC;
        public boolean rmk;
        public boolean sbA;
        public long sbB;
        private C4118b sbC;
        long sbx;
        public long sby;
        public long sbz;

        public C4117a(String str, C4118b c4118b) {
            C25052j.m39376p(str, "user");
            C25052j.m39376p(c4118b, "state");
            AppMethodBeat.m2504i(109764);
            this.cIS = str;
            this.sbC = c4118b;
            AppMethodBeat.m2505o(109764);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "", "s", "", "(Ljava/lang/String;II)V", "getS", "()I", "SHOW", "PLAY", "WAIT", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.g.b$b */
    public enum C4118b {
        SHOW(1),
        PLAY(2),
        WAIT(3);
        
        /* renamed from: s */
        private final int f1284s;

        private C4118b(int i) {
            this.f1284s = i;
        }

        static {
            AppMethodBeat.m2505o(109765);
        }
    }

    static {
        AppMethodBeat.m2504i(109780);
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        C25052j.m39375o(synchronizedMap, "Collections.synchronizedMap(HashMap<Long, Info>())");
        sbi = synchronizedMap;
        AppMethodBeat.m2505o(109780);
    }

    private C4116b() {
    }

    /* renamed from: EV */
    public static void m6434EV(int i) {
        if (i == 1 || i == 2) {
            lhy = 998;
        } else if (i == 3) {
            lhy = 1006;
        } else {
            lhy = -1;
        }
    }

    /* renamed from: l */
    public static void m6441l(long j, long j2, long j3) {
        AppMethodBeat.m2504i(109768);
        if (j < 0) {
            AppMethodBeat.m2505o(109768);
            return;
        }
        C7060h.pYm.mo15419k(j, j2, j3);
        AppMethodBeat.m2505o(109768);
    }

    public static void clean() {
        AppMethodBeat.m2504i(109769);
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
        AppMethodBeat.m2505o(109769);
    }

    /* renamed from: dF */
    public static void m6439dF(List<String> list) {
        AppMethodBeat.m2504i(109770);
        C25052j.m39376p(list, "list");
        ArrayList arrayList = new ArrayList();
        sbv = arrayList;
        arrayList.addAll(list);
        AppMethodBeat.m2505o(109770);
    }

    /* renamed from: lj */
    public static void m6442lj(long j) {
        sbk = j;
    }

    public static void czQ() {
        sbo = true;
    }

    /* renamed from: EW */
    public static void m6435EW(int i) {
        AppMethodBeat.m2504i(109771);
        long gb = C5046bo.m7566gb(sbr);
        C4990ab.m7416i("MicroMsg.StoryBrowseDetailIDKeyStat", "cur speed " + i + " cur: " + gb);
        if (gb > 5000) {
            if (i < 10) {
                C4116b.m6441l(lhy, 82, 1);
                AppMethodBeat.m2505o(109771);
                return;
            } else if (i < 100) {
                C4116b.m6441l(lhy, 83, 1);
                AppMethodBeat.m2505o(109771);
                return;
            } else if (i < 200) {
                C4116b.m6441l(lhy, 89, 1);
                AppMethodBeat.m2505o(109771);
                return;
            } else if (i < 250) {
                C4116b.m6441l(lhy, 84, 1);
                AppMethodBeat.m2505o(109771);
                return;
            } else if (i < 450) {
                C4116b.m6441l(lhy, 85, 1);
                AppMethodBeat.m2505o(109771);
                return;
            } else if (i < TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR) {
                C4116b.m6441l(lhy, 86, 1);
                AppMethodBeat.m2505o(109771);
                return;
            } else if (i < 1350) {
                C4116b.m6441l(lhy, 87, 1);
                AppMethodBeat.m2505o(109771);
                return;
            } else if (i < 1800) {
                C4116b.m6441l(lhy, 88, 1);
            }
        }
        AppMethodBeat.m2505o(109771);
    }

    /* renamed from: b */
    public static void m6437b(ArrayList<ArrayList<C43640g>> arrayList, int i, int i2) {
        AppMethodBeat.m2504i(109772);
        C25052j.m39376p(arrayList, "group");
        if (C4116b.aiG()) {
            boolean z;
            boolean z2;
            C4990ab.m7418v("MicroMsg.StoryBrowseDetailIDKeyStat", " last_selectedColumn:" + sbt + ",last_selectedRow:" + sbs + " selectedRow:" + i + ",selectedColumn:" + i2);
            if (arrayList.size() > 0) {
                boolean z3;
                if (((ArrayList) arrayList.get(i)).size() <= 0 || i2 + 1 >= ((ArrayList) arrayList.get(i)).size()) {
                    z = false;
                } else {
                    if (!sbu) {
                        C4116b.m6441l(lhy, 101, 1);
                    }
                    z = true;
                }
                if (i + 1 < arrayList.size()) {
                    if (!sbu) {
                        C4116b.m6441l(lhy, 102, 1);
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
                    C4116b.m6441l(lhy, 100, 1);
                    isWaiting = false;
                }
                int i3;
                if (i != sbs) {
                    if (z) {
                        C4116b.m6441l(lhy, 105, 1);
                    }
                    C4116b.m6441l(lhy, 106, 1);
                    i3 = i - sbs;
                    if (i3 == 1) {
                        C4116b.m6441l(lhy, 110, 1);
                    } else if (i3 == 2) {
                        C4116b.m6441l(lhy, 111, 1);
                    } else if (i3 == 3) {
                        C4116b.m6441l(lhy, 112, 1);
                    } else if (i3 >= 4) {
                        C4116b.m6441l(lhy, 113, 1);
                    }
                    if (arrayList.size() > 0) {
                        int i4 = 0;
                        while (i4 < 3) {
                            if (i + i4 < arrayList.size() && ((ArrayList) arrayList.get(i + i4)).size() > 0) {
                                C35201i c35201i = ((C43640g) ((ArrayList) arrayList.get(i + i4)).get(0)).rVZ;
                                if (!(c35201i == null || c35201i.username == null || sbv == null)) {
                                    ArrayList arrayList2 = sbv;
                                    if (arrayList2 != null && arrayList2.contains(c35201i.username)) {
                                        if (C4116b.m6436b(c35201i) == 1) {
                                            if (i4 == 0) {
                                                C4116b.m6441l(lhy, 120, 1);
                                            } else if (i4 == 1) {
                                                C4116b.m6441l(lhy, 121, 1);
                                            } else if (i4 == 2) {
                                                C4116b.m6441l(lhy, 122, 1);
                                            }
                                        }
                                        if (i4 == 0) {
                                            C4116b.m6441l(lhy, 125, 1);
                                        } else if (i4 == 1) {
                                            C4116b.m6441l(lhy, 126, 1);
                                        } else if (i4 == 2) {
                                            C4116b.m6441l(lhy, 127, 1);
                                        }
                                    }
                                }
                            }
                            i4++;
                        }
                    }
                } else if (i2 != sbt) {
                    if (z2) {
                        C4116b.m6441l(lhy, 103, 1);
                    }
                    C4116b.m6441l(lhy, 104, 1);
                    i3 = i2 - sbt;
                    if (i3 == 1) {
                        C4116b.m6441l(lhy, 115, 1);
                    } else if (i3 == 2) {
                        C4116b.m6441l(lhy, 116, 1);
                    } else if (i3 == 3) {
                        C4116b.m6441l(lhy, 117, 1);
                    } else if (i3 >= 4) {
                        C4116b.m6441l(lhy, 118, 1);
                    }
                }
                if (sbs >= 0 && sbs < arrayList.size() && sbt >= 0 && sbt < ((ArrayList) arrayList.get(sbs)).size() && !(sbt == i2 && sbs == i)) {
                    long j = ((C43640g) ((ArrayList) arrayList.get(sbs)).get(sbt)).rVZ.rUJ;
                    C4990ab.m7418v("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime storyId " + j + " lastStoryId " + sbh);
                    if (C4116b.aiG() && sbi.containsKey(Long.valueOf(j))) {
                        C4117a c4117a = (C4117a) sbi.get(Long.valueOf(j));
                        if (c4117a != null && c4117a.sbx <= 0 && !c4117a.rmk && c4117a.sby >= 0) {
                            c4117a.sbx = C5046bo.m7566gb(c4117a.sby);
                            C4990ab.m7416i("MicroMsg.StoryBrowseDetailIDKeyStat", "checkStayTime onStayTime " + j + ' ' + c4117a.sbx + " hasHttp:" + c4117a.sbA + "  isWaiting:" + c4117a.isWaiting);
                            if (c4117a.sbA) {
                                C4116b.m6441l(lhy, 21, 1);
                                C4116b.m6441l(lhy, 20, c4117a.sbx);
                            }
                            if (c4117a.isWaiting) {
                                C4116b.m6441l(lhy, 23, 1);
                                C4116b.m6441l(lhy, 22, c4117a.sbx);
                            }
                            C4116b.m6441l(lhy, 25, 1);
                            C4116b.m6441l(lhy, 24, c4117a.sbx);
                            if (c4117a.eTf) {
                                C4116b.m6441l(lhy, 26, 1);
                            }
                        }
                    }
                }
            }
            sbt = i2;
            sbs = i;
            AppMethodBeat.m2505o(109772);
            return;
        }
        AppMethodBeat.m2505o(109772);
    }

    /* renamed from: c */
    public static /* synthetic */ int m6438c(C35201i c35201i) {
        AppMethodBeat.m2504i(109774);
        int b = C4116b.m6436b(c35201i);
        AppMethodBeat.m2505o(109774);
        return b;
    }

    /* renamed from: b */
    private static int m6436b(C35201i c35201i) {
        AppMethodBeat.m2504i(109773);
        C43649s c43649s = C43649s.rTV;
        C29298n a = C43649s.m78153a(c35201i);
        if (a.cCd()) {
            C4990ab.m7418v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay downloadFinish " + c35201i.rUJ);
            AppMethodBeat.m2505o(109773);
            return 1;
        } else if (a.field_totalSize <= 0) {
            AppMethodBeat.m2505o(109773);
            return 0;
        } else {
            float f = (((float) a.field_cacheSize) / ((float) a.field_totalSize)) * 100.0f;
            C39933n c39933n = C39933n.sqi;
            if (f >= ((float) C39933n.cCM().soQ)) {
                C4990ab.m7418v("MicroMsg.StoryBrowseDetailIDKeyStat", "z checkCanPlay cachesize " + a.field_cacheSize + " totalSize: " + a.field_totalSize);
                AppMethodBeat.m2505o(109773);
                return 1;
            }
            AppMethodBeat.m2505o(109773);
            return 0;
        }
    }

    /* renamed from: z */
    public static void m6444z(long j, boolean z) {
        AppMethodBeat.m2504i(109775);
        if (sbi.containsKey(Long.valueOf(j))) {
            C4117a c4117a = (C4117a) sbi.get(Long.valueOf(j));
            if (c4117a != null) {
                c4117a.sbB = C5046bo.anU();
                c4117a.koC = z;
                AppMethodBeat.m2505o(109775);
                return;
            }
            AppMethodBeat.m2505o(109775);
            return;
        }
        AppMethodBeat.m2505o(109775);
    }

    /* renamed from: lk */
    public static void m6443lk(long j) {
        AppMethodBeat.m2504i(109776);
        if (sbi.containsKey(Long.valueOf(j))) {
            C4117a c4117a = (C4117a) sbi.get(Long.valueOf(j));
            long gb;
            if (c4117a != null && c4117a.rmk) {
                AppMethodBeat.m2505o(109776);
                return;
            } else if (j == sbk) {
                c4117a = sbj;
                if (c4117a == null) {
                    AppMethodBeat.m2505o(109776);
                    return;
                } else if (c4117a.sbB <= 0) {
                    AppMethodBeat.m2505o(109776);
                    return;
                } else {
                    gb = C5046bo.m7566gb(c4117a.sbB);
                    C4990ab.m7416i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd1 ".concat(String.valueOf(gb)));
                    if (c4117a.koC) {
                        C4116b.m6441l(lhy, 62, 1);
                        C4116b.m6441l(lhy, 63, gb);
                    }
                    C4116b.m6441l(lhy, 60, 1);
                    C4116b.m6441l(lhy, 61, gb);
                    AppMethodBeat.m2505o(109776);
                    return;
                }
            } else {
                c4117a = (C4117a) sbi.get(Long.valueOf(j));
                if (c4117a == null) {
                    AppMethodBeat.m2505o(109776);
                    return;
                } else if (c4117a.sbB <= 0) {
                    AppMethodBeat.m2505o(109776);
                    return;
                } else {
                    gb = C5046bo.m7566gb(c4117a.sbB);
                    C4990ab.m7416i("MicroMsg.StoryBrowseDetailIDKeyStat", "downloadEnd2 ".concat(String.valueOf(gb)));
                    if (c4117a.koC) {
                        C4116b.m6441l(lhy, 62, 1);
                        C4116b.m6441l(lhy, 63, gb);
                    }
                    C4116b.m6441l(lhy, 60, 1);
                    C4116b.m6441l(lhy, 61, gb);
                    AppMethodBeat.m2505o(109776);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(109776);
    }

    public static void czR() {
        AppMethodBeat.m2504i(109777);
        C4990ab.m7418v("MicroMsg.StoryBrowseDetailIDKeyStat", "makeResumeTime onResumeTime " + sbl + " onPlayUser " + sbm);
        sbl = C5046bo.anU();
        AppMethodBeat.m2505o(109777);
    }

    /* renamed from: j */
    public static void m6440j(String str, long j, int i) {
        AppMethodBeat.m2504i(109778);
        C25052j.m39376p(str, "user");
        if (C4116b.aiG()) {
            Object obj;
            if (sbp > 0 && sbq <= 0) {
                sbq = C5046bo.m7566gb(sbp);
                C4116b.m6441l(lhy, 130, 1);
                C4116b.m6441l(lhy, 131, sbq);
            }
            C4990ab.m7418v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser user " + str + " storyId " + j + " selectedColumn " + i + " lastStoryId:" + sbh + " onStoryLauncherTime " + sbq);
            Object obj2 = null;
            if (!(sbh == j || sbh == 0)) {
                obj2 = 1;
            }
            long j2 = sbh;
            sbh = j;
            C25052j.m39376p(str, "user");
            ArrayList arrayList = sbv;
            if (arrayList == null || !arrayList.contains(str)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                AppMethodBeat.m2505o(109778);
                return;
            }
            if (sbi.containsKey(Long.valueOf(j2)) && obj2 != null) {
                C4117a c4117a = (C4117a) sbi.get(Long.valueOf(j2));
                if (c4117a != null) {
                    c4117a.rmk = true;
                }
            }
            if (i > 0) {
                AppMethodBeat.m2505o(109778);
                return;
            }
            Map map = sbi;
            Long valueOf = Long.valueOf(j);
            C4117a c4117a2 = new C4117a(str, C4118b.PLAY);
            c4117a2.sby = C5046bo.anU();
            map.put(valueOf, c4117a2);
            sbm = C5046bo.anU();
            C4990ab.m7418v("MicroMsg.StoryBrowseDetailIDKeyStat", "playUser onResumeTime " + sbm);
            C4133a c4133a = C43644j.rST;
            C4119f aap = C4133a.cxU().aap(str);
            C4990ab.m7416i("MicroMsg.StoryBrowseDetailIDKeyStat", "preLoadCache > 0 then " + str + " preload " + C5046bo.m7565ga(aap.cBL()));
            C4116b.m6441l(lhy, 2, 1);
            if (aap.cBL() > 0) {
                C4116b.m6441l(lhy, 3, 1);
            }
            if (j == sbk) {
                if (sbo) {
                    C4116b.m6441l(lhy, 6, 1);
                } else {
                    C4116b.m6441l(lhy, 9, 1);
                }
                if (aap.cBL() > 0) {
                    if (sbo) {
                        C4116b.m6441l(lhy, 7, 1);
                    } else {
                        C4116b.m6441l(lhy, 10, 1);
                    }
                }
                C43640g c43640g = sbn;
                if (c43640g != null) {
                    if (C4116b.m6436b(c43640g.rVZ) == 1) {
                        if (sbo) {
                            C4116b.m6441l(lhy, 8, 1);
                            AppMethodBeat.m2505o(109778);
                            return;
                        }
                        C4116b.m6441l(lhy, 11, 1);
                    }
                    AppMethodBeat.m2505o(109778);
                    return;
                }
            }
            AppMethodBeat.m2505o(109778);
            return;
        }
        AppMethodBeat.m2505o(109778);
    }

    public static void czS() {
        AppMethodBeat.m2504i(109779);
        sbr = C5046bo.anU();
        AppMethodBeat.m2505o(109779);
    }

    public static boolean aiG() {
        if (sbr > 0 && mgU) {
            return true;
        }
        return false;
    }
}
