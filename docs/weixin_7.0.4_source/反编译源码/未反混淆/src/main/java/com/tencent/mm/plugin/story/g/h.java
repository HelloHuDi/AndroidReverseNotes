package com.tencent.mm.plugin.story.g;

import a.f.b.j;
import a.l;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.b.a.aj;
import com.tencent.mm.g.b.a.ak;
import com.tencent.mm.g.b.a.al;
import com.tencent.mm.g.b.a.am;
import com.tencent.mm.g.b.a.an;
import com.tencent.mm.g.b.a.ap;
import com.tencent.mm.g.b.a.aq;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.g.b.a.as;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.g.b.a.au;
import com.tencent.mm.g.b.a.ax;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b,\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\nJ\u000e\u0010H\u001a\u00020F2\u0006\u0010G\u001a\u00020\nJ\u0010\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010L\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010M\u001a\u00020FJ\u0006\u0010N\u001a\u00020FJ\u0006\u0010O\u001a\u00020FJ\u0006\u0010P\u001a\u00020FJ\u0006\u0010Q\u001a\u00020FJ\u0006\u0010R\u001a\u00020FJ\u0006\u0010S\u001a\u00020FJ\u0006\u0010T\u001a\u00020FJ\u0006\u0010U\u001a\u00020FJ\u0006\u0010V\u001a\u00020FJ\u0006\u0010W\u001a\u00020FJ\u000e\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\nJ\u0006\u0010Z\u001a\u00020FJ\u0006\u0010[\u001a\u00020#J\u0006\u0010\\\u001a\u000204J\u000e\u0010]\u001a\u00020@2\u0006\u0010Y\u001a\u00020\nJ\u0006\u0010^\u001a\u00020\u001eJ\u0006\u0010_\u001a\u00020%J\u0006\u0010`\u001a\u00020'J\u0006\u0010a\u001a\u00020)J\u0006\u0010b\u001a\u00020-J\u0006\u0010c\u001a\u00020/J\u0006\u0010d\u001a\u000202J\u0006\u0010e\u001a\u000206J\u0006\u0010f\u001a\u00020BJ4\u0010g\u001a\u00020F2\u0006\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u001a2\b\b\u0002\u0010j\u001a\u00020\u00042\b\b\u0002\u0010k\u001a\u00020\u00042\b\b\u0002\u0010l\u001a\u00020\u0004J\u0006\u0010m\u001a\u00020FJ\u0006\u0010n\u001a\u00020FJ\u0006\u0010o\u001a\u00020FJ\u0006\u0010p\u001a\u00020FJ\u0006\u0010q\u001a\u00020FJ\u0016\u0010r\u001a\u00020F2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010s\u001a\u00020\u001aJ\u001e\u0010t\u001a\u00020F2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010s\u001a\u00020\u001a2\u0006\u0010u\u001a\u00020JR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR2\u0010\u0018\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001c0\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020@0?X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000R2\u0010D\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001c0\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyTraceStruct", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "addTrace", "checkRepeatUser", "", "name", "checkRepeatVideo", "doBehaviorReport", "doFailBehaviorReport", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "getBehaviorReporter", "getFailBehaviorReporter", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "storyId", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetBehaviorReporter", "resetFailBehaviorReporter", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
public final class h {
    private static al sbV = new al();
    private static a sbW = new a();
    private static aq sbX = new aq();
    private static at sbY = new at();
    private static a sbZ = new a();
    private static int sca = -1;
    private static ar scb = new ar();
    private static a scc = new a();
    private static Set<String> scd = Collections.synchronizedSet(new HashSet());
    private static Set<String> sce = Collections.synchronizedSet(new HashSet());
    private static aj scf = new aj();
    private static am scg = new am();
    private static ak sch = new ak();
    private static an sci = new an();
    private static final HashMap<Integer, ay> scj = new HashMap();
    private static au sck = new au();
    private static as scl = new as();
    private static long scm;
    private static long scn;
    private static long sco;
    private static long scp;
    private static int scq;
    private static ap scr = new ap();
    private static ax scs = new ax();
    public static final h scu = new h();

    static {
        AppMethodBeat.i(109847);
        AppMethodBeat.o(109847);
    }

    private h() {
    }

    public static void cAl() {
        sca = 1;
    }

    public static al cAm() {
        return sbV;
    }

    public static void EU(int i) {
        AppMethodBeat.i(109824);
        if (i == 15 && (sca == 4 || sca == 10)) {
            sca = i;
            AppMethodBeat.o(109824);
            return;
        }
        sca = i;
        sbW.EU(i);
        sbZ.EU(i);
        AppMethodBeat.o(109824);
    }

    public static void cAn() {
        AppMethodBeat.i(109825);
        sbV.fr(sbW.czP());
        sbV.ajK();
        cAo();
        sca = -1;
        AppMethodBeat.o(109825);
    }

    public static void cAo() {
        AppMethodBeat.i(109826);
        sbV = new al();
        sbW = new a();
        AppMethodBeat.o(109826);
    }

    public static void cAp() {
        AppMethodBeat.i(109827);
        sbY = new at();
        sbZ = new a();
        AppMethodBeat.o(109827);
    }

    public static at cAq() {
        return sbY;
    }

    public static boolean aaP(String str) {
        AppMethodBeat.i(109829);
        if (str == null) {
            AppMethodBeat.o(109829);
            return true;
        } else if (scd.contains(str)) {
            AppMethodBeat.o(109829);
            return true;
        } else {
            scd.add(str);
            AppMethodBeat.o(109829);
            return false;
        }
    }

    public static boolean aaQ(String str) {
        AppMethodBeat.i(109830);
        if (str == null) {
            AppMethodBeat.o(109830);
            return true;
        } else if (sce.contains(str)) {
            AppMethodBeat.o(109830);
            return true;
        } else {
            sce.add(str);
            AppMethodBeat.o(109830);
            return false;
        }
    }

    public static ar cAs() {
        return scb;
    }

    public static void EX(int i) {
        AppMethodBeat.i(109831);
        if (sca == -1 && i == 4) {
            sca = i;
            AppMethodBeat.o(109831);
        } else if (sca == 10 && i == 11) {
            sca = i;
            AppMethodBeat.o(109831);
        } else {
            sca = i;
            scc.EU(i);
            AppMethodBeat.o(109831);
        }
    }

    public static void cAu() {
        AppMethodBeat.i(109833);
        scb = new ar();
        cAv();
        AppMethodBeat.o(109833);
    }

    public static void cAv() {
        AppMethodBeat.i(109834);
        scc = new a();
        sca = -1;
        scd.clear();
        sce.clear();
        AppMethodBeat.o(109834);
    }

    public static aq cAw() {
        return sbX;
    }

    public static void cAx() {
        AppMethodBeat.i(109835);
        sbX.ajK();
        sbX = new aq();
        AppMethodBeat.o(109835);
    }

    public static aj cAy() {
        return scf;
    }

    public static void cAz() {
        AppMethodBeat.i(109836);
        if (TextUtils.isEmpty(scf.getUserName())) {
            AppMethodBeat.o(109836);
            return;
        }
        scf.ajK();
        AppMethodBeat.o(109836);
    }

    public static am cAA() {
        return scg;
    }

    public static void cAB() {
        AppMethodBeat.i(109837);
        scg.ajK();
        AppMethodBeat.o(109837);
    }

    public static ak cAC() {
        return sch;
    }

    public static void cAD() {
        AppMethodBeat.i(109838);
        sch.ajK();
        sch = new ak();
        AppMethodBeat.o(109838);
    }

    public static an cAE() {
        return sci;
    }

    public static void cAF() {
        AppMethodBeat.i(109839);
        sci.ajK();
        sci = new an();
        AppMethodBeat.o(109839);
    }

    public static ay EY(int i) {
        AppMethodBeat.i(109840);
        ay ayVar = (ay) scj.get(Integer.valueOf(i));
        if (ayVar == null) {
            ay ayVar2 = new ay();
            scj.put(Integer.valueOf(i), ayVar2);
            ayVar = ayVar2;
        }
        AppMethodBeat.o(109840);
        return ayVar;
    }

    public static void g(int i, String str, boolean z) {
        long cBl;
        AppMethodBeat.i(109841);
        j.p(str, "path");
        a WR = d.WR(str);
        EY(i).cq(e.asZ(str));
        ay EY = EY(i);
        com.tencent.mm.plugin.story.h.a.a aVar;
        if (z) {
            aVar = com.tencent.mm.plugin.story.h.a.sdm;
            cBl = com.tencent.mm.plugin.story.h.a.sdb;
        } else {
            aVar = com.tencent.mm.plugin.story.h.a.sdm;
            cBl = com.tencent.mm.plugin.story.h.a.sda;
        }
        EY.cE(cBl);
        if (WR != null) {
            EY(i).cv((long) WR.width);
            EY(i).cw((long) WR.height);
            EY(i).cs((long) WR.videoBitrate);
            EY(i).ct((long) WR.fzS);
            EY(i).cr((long) WR.eWK);
            EY(i).cu((long) WR.eTk);
            EY(i).cF((long) WR.qwV);
            AppMethodBeat.o(109841);
            return;
        }
        AppMethodBeat.o(109841);
    }

    public static void bl(int i, String str) {
        AppMethodBeat.i(109842);
        j.p(str, "path");
        a WR = d.WR(str);
        EY(i).cx(e.asZ(str));
        EY(i).fP(g.cz(str));
        if (WR != null) {
            EY(i);
            EY(i).cD((long) WR.height);
            EY(i).cC((long) WR.width);
            EY(i).cz((long) WR.videoBitrate);
            EY(i).cA((long) WR.fzS);
            EY(i).cy((long) WR.eWK);
            EY(i).cB((long) WR.eTk);
            AppMethodBeat.o(109842);
            return;
        }
        AppMethodBeat.o(109842);
    }

    public static void EZ(int i) {
        AppMethodBeat.i(109843);
        ay ayVar = (ay) scj.get(Integer.valueOf(i));
        if (ayVar != null) {
            ab.d("MicroMsg.StoryReporter", "basic:\n" + ayVar.Gv() + ' ' + ayVar.Gf() + ' ' + ayVar.Gg() + ' ' + ayVar.Gt() + ' ' + ayVar.Ge() + ' ' + ayVar.Gc() + ' ' + ayVar.Gd());
            ab.d("MicroMsg.StoryReporter", "origin:\n" + ayVar.Gj() + ' ' + ayVar.Gh() + ' ' + ayVar.Gu() + ' ' + ayVar.Gm() + ' ' + ayVar.Gl() + ' ' + ayVar.Gk() + ' ' + ayVar.Gi());
            ab.d("MicroMsg.StoryReporter", "cp:\n" + ayVar.Gp() + ' ' + ayVar.Gn() + ' ' + ayVar.Gs() + ' ' + ayVar.Gr() + ' ' + ayVar.Gq() + ' ' + ayVar.Go());
            ayVar.ajK();
            scj.remove(Integer.valueOf(i));
        }
        AppMethodBeat.o(109843);
    }

    public static au cAG() {
        return sck;
    }

    public static void cAH() {
        AppMethodBeat.i(109844);
        if (sck.FH() == 0) {
            sck = new au();
            AppMethodBeat.o(109844);
            return;
        }
        sck.ajK();
        sck = new au();
        AppMethodBeat.o(109844);
    }

    public static void ln(long j) {
        scm = j;
    }

    public static void lo(long j) {
        scn = j;
    }

    public static void lp(long j) {
        sco = j;
    }

    public static long cAI() {
        return scp;
    }

    public static void lq(long j) {
        scp = j;
    }

    public static as cAJ() {
        return scl;
    }

    public static void cAK() {
        AppMethodBeat.i(109845);
        if (scl.FU() != 0) {
            scl.ajK();
            scl.FT();
            scl.FR();
            scl.FQ();
            scl.FS();
            scl.bS(scm);
            scl.bT(scn);
            scl.bU(sco);
        }
        AppMethodBeat.o(109845);
    }

    public static void Fa(int i) {
        scq = i;
    }

    public static int cAL() {
        return scq;
    }

    public static ap cAM() {
        return scr;
    }

    public static void cAN() {
        AppMethodBeat.i(109846);
        scr.ajK();
        scr = new ap();
        AppMethodBeat.o(109846);
    }

    public static void a(long j, String str, long j2, long j3, long j4) {
        AppMethodBeat.i(138837);
        j.p(str, "storyId");
        scs.fN(str);
        scs.ck(j);
        scs.cn(j4);
        scs.cl(j2);
        scs.cm(j3);
        scs.ajK();
        scs = new ax();
        AppMethodBeat.o(138837);
    }

    public static void cAr() {
        AppMethodBeat.i(109828);
        sbY.bY(System.currentTimeMillis());
        sbY.fE(sbZ.czP());
        sbY.ajK();
        sbY = new at();
        sbZ = new a();
        AppMethodBeat.o(109828);
    }

    public static void cAt() {
        AppMethodBeat.i(109832);
        if (0 == scb.FK()) {
            cAv();
            AppMethodBeat.o(109832);
            return;
        }
        scb.fB(scc.czP());
        ar arVar = scb;
        arVar.bQ(arVar.FO() + scb.FM());
        scb.ajK();
        scb.bK(0);
        scb.bO(0);
        scb.bN(0);
        scb.bL(0);
        scb.bP(0);
        scb.bH(0);
        scb.bQ(0);
        scb.oh(0);
        scb.fC("");
        cAv();
        AppMethodBeat.o(109832);
    }
}
