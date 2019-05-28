package com.tencent.p177mm.plugin.story.p531g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p232b.p233a.C1583aj;
import com.tencent.p177mm.p230g.p232b.p233a.C1584ak;
import com.tencent.p177mm.p230g.p232b.p233a.C1585al;
import com.tencent.p177mm.p230g.p232b.p233a.C26274at;
import com.tencent.p177mm.p230g.p232b.p233a.C32662an;
import com.tencent.p177mm.p230g.p232b.p233a.C32664ap;
import com.tencent.p177mm.p230g.p232b.p233a.C37821aq;
import com.tencent.p177mm.p230g.p232b.p233a.C42082ax;
import com.tencent.p177mm.p230g.p232b.p233a.C42083ay;
import com.tencent.p177mm.p230g.p232b.p233a.C46878am;
import com.tencent.p177mm.p230g.p232b.p233a.C9502ar;
import com.tencent.p177mm.p230g.p232b.p233a.C9503as;
import com.tencent.p177mm.p230g.p232b.p233a.C9504au;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.story.p532h.C35183a;
import com.tencent.p177mm.plugin.story.p532h.C35183a.C35184a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b,\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\nJ\u000e\u0010H\u001a\u00020F2\u0006\u0010G\u001a\u00020\nJ\u0010\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010L\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010M\u001a\u00020FJ\u0006\u0010N\u001a\u00020FJ\u0006\u0010O\u001a\u00020FJ\u0006\u0010P\u001a\u00020FJ\u0006\u0010Q\u001a\u00020FJ\u0006\u0010R\u001a\u00020FJ\u0006\u0010S\u001a\u00020FJ\u0006\u0010T\u001a\u00020FJ\u0006\u0010U\u001a\u00020FJ\u0006\u0010V\u001a\u00020FJ\u0006\u0010W\u001a\u00020FJ\u000e\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\nJ\u0006\u0010Z\u001a\u00020FJ\u0006\u0010[\u001a\u00020#J\u0006\u0010\\\u001a\u000204J\u000e\u0010]\u001a\u00020@2\u0006\u0010Y\u001a\u00020\nJ\u0006\u0010^\u001a\u00020\u001eJ\u0006\u0010_\u001a\u00020%J\u0006\u0010`\u001a\u00020'J\u0006\u0010a\u001a\u00020)J\u0006\u0010b\u001a\u00020-J\u0006\u0010c\u001a\u00020/J\u0006\u0010d\u001a\u000202J\u0006\u0010e\u001a\u000206J\u0006\u0010f\u001a\u00020BJ4\u0010g\u001a\u00020F2\u0006\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u001a2\b\b\u0002\u0010j\u001a\u00020\u00042\b\b\u0002\u0010k\u001a\u00020\u00042\b\b\u0002\u0010l\u001a\u00020\u0004J\u0006\u0010m\u001a\u00020FJ\u0006\u0010n\u001a\u00020FJ\u0006\u0010o\u001a\u00020FJ\u0006\u0010p\u001a\u00020FJ\u0006\u0010q\u001a\u00020FJ\u0016\u0010r\u001a\u00020F2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010s\u001a\u00020\u001aJ\u001e\u0010t\u001a\u00020F2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010s\u001a\u00020\u001a2\u0006\u0010u\u001a\u00020JR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR2\u0010\u0018\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001c0\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020@0?X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000R2\u0010D\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001c0\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006v"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyTraceStruct", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "addTrace", "checkRepeatUser", "", "name", "checkRepeatVideo", "doBehaviorReport", "doFailBehaviorReport", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "getBehaviorReporter", "getFailBehaviorReporter", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "storyId", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetBehaviorReporter", "resetFailBehaviorReporter", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.g.h */
public final class C22212h {
    private static C1585al sbV = new C1585al();
    private static C22211a sbW = new C22211a();
    private static C37821aq sbX = new C37821aq();
    private static C26274at sbY = new C26274at();
    private static C22211a sbZ = new C22211a();
    private static int sca = -1;
    private static C9502ar scb = new C9502ar();
    private static C22211a scc = new C22211a();
    private static Set<String> scd = Collections.synchronizedSet(new HashSet());
    private static Set<String> sce = Collections.synchronizedSet(new HashSet());
    private static C1583aj scf = new C1583aj();
    private static C46878am scg = new C46878am();
    private static C1584ak sch = new C1584ak();
    private static C32662an sci = new C32662an();
    private static final HashMap<Integer, C42083ay> scj = new HashMap();
    private static C9504au sck = new C9504au();
    private static C9503as scl = new C9503as();
    private static long scm;
    private static long scn;
    private static long sco;
    private static long scp;
    private static int scq;
    private static C32664ap scr = new C32664ap();
    private static C42082ax scs = new C42082ax();
    public static final C22212h scu = new C22212h();

    static {
        AppMethodBeat.m2504i(109847);
        AppMethodBeat.m2505o(109847);
    }

    private C22212h() {
    }

    public static void cAl() {
        sca = 1;
    }

    public static C1585al cAm() {
        return sbV;
    }

    /* renamed from: EU */
    public static void m33887EU(int i) {
        AppMethodBeat.m2504i(109824);
        if (i == 15 && (sca == 4 || sca == 10)) {
            sca = i;
            AppMethodBeat.m2505o(109824);
            return;
        }
        sca = i;
        sbW.mo37760EU(i);
        sbZ.mo37760EU(i);
        AppMethodBeat.m2505o(109824);
    }

    public static void cAn() {
        AppMethodBeat.m2504i(109825);
        sbV.mo5014fr(sbW.czP());
        sbV.ajK();
        C22212h.cAo();
        sca = -1;
        AppMethodBeat.m2505o(109825);
    }

    public static void cAo() {
        AppMethodBeat.m2504i(109826);
        sbV = new C1585al();
        sbW = new C22211a();
        AppMethodBeat.m2505o(109826);
    }

    public static void cAp() {
        AppMethodBeat.m2504i(109827);
        sbY = new C26274at();
        sbZ = new C22211a();
        AppMethodBeat.m2505o(109827);
    }

    public static C26274at cAq() {
        return sbY;
    }

    public static boolean aaP(String str) {
        AppMethodBeat.m2504i(109829);
        if (str == null) {
            AppMethodBeat.m2505o(109829);
            return true;
        } else if (scd.contains(str)) {
            AppMethodBeat.m2505o(109829);
            return true;
        } else {
            scd.add(str);
            AppMethodBeat.m2505o(109829);
            return false;
        }
    }

    public static boolean aaQ(String str) {
        AppMethodBeat.m2504i(109830);
        if (str == null) {
            AppMethodBeat.m2505o(109830);
            return true;
        } else if (sce.contains(str)) {
            AppMethodBeat.m2505o(109830);
            return true;
        } else {
            sce.add(str);
            AppMethodBeat.m2505o(109830);
            return false;
        }
    }

    public static C9502ar cAs() {
        return scb;
    }

    /* renamed from: EX */
    public static void m33888EX(int i) {
        AppMethodBeat.m2504i(109831);
        if (sca == -1 && i == 4) {
            sca = i;
            AppMethodBeat.m2505o(109831);
        } else if (sca == 10 && i == 11) {
            sca = i;
            AppMethodBeat.m2505o(109831);
        } else {
            sca = i;
            scc.mo37760EU(i);
            AppMethodBeat.m2505o(109831);
        }
    }

    public static void cAu() {
        AppMethodBeat.m2504i(109833);
        scb = new C9502ar();
        C22212h.cAv();
        AppMethodBeat.m2505o(109833);
    }

    public static void cAv() {
        AppMethodBeat.m2504i(109834);
        scc = new C22211a();
        sca = -1;
        scd.clear();
        sce.clear();
        AppMethodBeat.m2505o(109834);
    }

    public static C37821aq cAw() {
        return sbX;
    }

    public static void cAx() {
        AppMethodBeat.m2504i(109835);
        sbX.ajK();
        sbX = new C37821aq();
        AppMethodBeat.m2505o(109835);
    }

    public static C1583aj cAy() {
        return scf;
    }

    public static void cAz() {
        AppMethodBeat.m2504i(109836);
        if (TextUtils.isEmpty(scf.getUserName())) {
            AppMethodBeat.m2505o(109836);
            return;
        }
        scf.ajK();
        AppMethodBeat.m2505o(109836);
    }

    public static C46878am cAA() {
        return scg;
    }

    public static void cAB() {
        AppMethodBeat.m2504i(109837);
        scg.ajK();
        AppMethodBeat.m2505o(109837);
    }

    public static C1584ak cAC() {
        return sch;
    }

    public static void cAD() {
        AppMethodBeat.m2504i(109838);
        sch.ajK();
        sch = new C1584ak();
        AppMethodBeat.m2505o(109838);
    }

    public static C32662an cAE() {
        return sci;
    }

    public static void cAF() {
        AppMethodBeat.m2504i(109839);
        sci.ajK();
        sci = new C32662an();
        AppMethodBeat.m2505o(109839);
    }

    /* renamed from: EY */
    public static C42083ay m33889EY(int i) {
        AppMethodBeat.m2504i(109840);
        C42083ay c42083ay = (C42083ay) scj.get(Integer.valueOf(i));
        if (c42083ay == null) {
            C42083ay c42083ay2 = new C42083ay();
            scj.put(Integer.valueOf(i), c42083ay2);
            c42083ay = c42083ay2;
        }
        AppMethodBeat.m2505o(109840);
        return c42083ay;
    }

    /* renamed from: g */
    public static void m33895g(int i, String str, boolean z) {
        long cBl;
        AppMethodBeat.m2504i(109841);
        C25052j.m39376p(str, "path");
        C43528a WR = C21846d.m33388WR(str);
        C22212h.m33889EY(i).mo67628cq(C5730e.asZ(str));
        C42083ay EY = C22212h.m33889EY(i);
        C35184a c35184a;
        if (z) {
            c35184a = C35183a.sdm;
            cBl = C35183a.sdb;
        } else {
            c35184a = C35183a.sdm;
            cBl = C35183a.sda;
        }
        EY.mo67623cE(cBl);
        if (WR != null) {
            C22212h.m33889EY(i).mo67633cv((long) WR.width);
            C22212h.m33889EY(i).mo67634cw((long) WR.height);
            C22212h.m33889EY(i).mo67630cs((long) WR.videoBitrate);
            C22212h.m33889EY(i).mo67631ct((long) WR.fzS);
            C22212h.m33889EY(i).mo67629cr((long) WR.eWK);
            C22212h.m33889EY(i).mo67632cu((long) WR.eTk);
            C22212h.m33889EY(i).mo67624cF((long) WR.qwV);
            AppMethodBeat.m2505o(109841);
            return;
        }
        AppMethodBeat.m2505o(109841);
    }

    /* renamed from: bl */
    public static void m33894bl(int i, String str) {
        AppMethodBeat.m2504i(109842);
        C25052j.m39376p(str, "path");
        C43528a WR = C21846d.m33388WR(str);
        C22212h.m33889EY(i).mo67635cx(C5730e.asZ(str));
        C22212h.m33889EY(i).mo67639fP(C1178g.m2587cz(str));
        if (WR != null) {
            C22212h.m33889EY(i);
            C22212h.m33889EY(i).mo67622cD((long) WR.height);
            C22212h.m33889EY(i).mo67621cC((long) WR.width);
            C22212h.m33889EY(i).mo67637cz((long) WR.videoBitrate);
            C22212h.m33889EY(i).mo67619cA((long) WR.fzS);
            C22212h.m33889EY(i).mo67636cy((long) WR.eWK);
            C22212h.m33889EY(i).mo67620cB((long) WR.eTk);
            AppMethodBeat.m2505o(109842);
            return;
        }
        AppMethodBeat.m2505o(109842);
    }

    /* renamed from: EZ */
    public static void m33890EZ(int i) {
        AppMethodBeat.m2504i(109843);
        C42083ay c42083ay = (C42083ay) scj.get(Integer.valueOf(i));
        if (c42083ay != null) {
            C4990ab.m7410d("MicroMsg.StoryReporter", "basic:\n" + c42083ay.mo67618Gv() + ' ' + c42083ay.mo67602Gf() + ' ' + c42083ay.mo67603Gg() + ' ' + c42083ay.mo67616Gt() + ' ' + c42083ay.mo67601Ge() + ' ' + c42083ay.mo67599Gc() + ' ' + c42083ay.mo67600Gd());
            C4990ab.m7410d("MicroMsg.StoryReporter", "origin:\n" + c42083ay.mo67606Gj() + ' ' + c42083ay.mo67604Gh() + ' ' + c42083ay.mo67617Gu() + ' ' + c42083ay.mo67609Gm() + ' ' + c42083ay.mo67608Gl() + ' ' + c42083ay.mo67607Gk() + ' ' + c42083ay.mo67605Gi());
            C4990ab.m7410d("MicroMsg.StoryReporter", "cp:\n" + c42083ay.mo67612Gp() + ' ' + c42083ay.mo67610Gn() + ' ' + c42083ay.mo67615Gs() + ' ' + c42083ay.mo67614Gr() + ' ' + c42083ay.mo67613Gq() + ' ' + c42083ay.mo67611Go());
            c42083ay.ajK();
            scj.remove(Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(109843);
    }

    public static C9504au cAG() {
        return sck;
    }

    public static void cAH() {
        AppMethodBeat.m2504i(109844);
        if (sck.mo20768FH() == 0) {
            sck = new C9504au();
            AppMethodBeat.m2505o(109844);
            return;
        }
        sck.ajK();
        sck = new C9504au();
        AppMethodBeat.m2505o(109844);
    }

    /* renamed from: ln */
    public static void m33896ln(long j) {
        scm = j;
    }

    /* renamed from: lo */
    public static void m33897lo(long j) {
        scn = j;
    }

    /* renamed from: lp */
    public static void m33898lp(long j) {
        sco = j;
    }

    public static long cAI() {
        return scp;
    }

    /* renamed from: lq */
    public static void m33899lq(long j) {
        scp = j;
    }

    public static C9503as cAJ() {
        return scl;
    }

    public static void cAK() {
        AppMethodBeat.m2504i(109845);
        if (scl.mo20764FU() != 0) {
            scl.ajK();
            scl.mo20763FT();
            scl.mo20761FR();
            scl.mo20760FQ();
            scl.mo20762FS();
            scl.mo20765bS(scm);
            scl.mo20766bT(scn);
            scl.mo20767bU(sco);
        }
        AppMethodBeat.m2505o(109845);
    }

    /* renamed from: Fa */
    public static void m33891Fa(int i) {
        scq = i;
    }

    public static int cAL() {
        return scq;
    }

    public static C32664ap cAM() {
        return scr;
    }

    public static void cAN() {
        AppMethodBeat.m2504i(109846);
        scr.ajK();
        scr = new C32664ap();
        AppMethodBeat.m2505o(109846);
    }

    /* renamed from: a */
    public static void m33893a(long j, String str, long j2, long j3, long j4) {
        AppMethodBeat.m2504i(138837);
        C25052j.m39376p(str, "storyId");
        scs.mo67598fN(str);
        scs.mo67594ck(j);
        scs.mo67597cn(j4);
        scs.mo67595cl(j2);
        scs.mo67596cm(j3);
        scs.ajK();
        scs = new C42082ax();
        AppMethodBeat.m2505o(138837);
    }

    public static void cAr() {
        AppMethodBeat.m2504i(109828);
        sbY.mo43961bY(System.currentTimeMillis());
        sbY.mo43968fE(sbZ.czP());
        sbY.ajK();
        sbY = new C26274at();
        sbZ = new C22211a();
        AppMethodBeat.m2505o(109828);
    }

    public static void cAt() {
        AppMethodBeat.m2504i(109832);
        if (0 == scb.mo20737FK()) {
            C22212h.cAv();
            AppMethodBeat.m2505o(109832);
            return;
        }
        scb.mo20756fB(scc.czP());
        C9502ar c9502ar = scb;
        c9502ar.mo20753bQ(c9502ar.mo20741FO() + scb.mo20739FM());
        scb.ajK();
        scb.mo20747bK(0);
        scb.mo20751bO(0);
        scb.mo20750bN(0);
        scb.mo20748bL(0);
        scb.mo20752bP(0);
        scb.mo20744bH(0);
        scb.mo20753bQ(0);
        scb.mo20759oh(0);
        scb.mo20757fC("");
        C22212h.cAv();
        AppMethodBeat.m2505o(109832);
    }
}
