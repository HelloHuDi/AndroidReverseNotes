package com.tencent.mm.plugin.story.g;

import a.f.b.j;
import a.l;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001>B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\u001fJ\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006J\u001a\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u0011H\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\u0006\u0010-\u001a\u00020\u001fJ\u0014\u0010.\u001a\u00020\u001f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dJ\u0006\u00100\u001a\u00020\u001fJ\u0006\u00101\u001a\u00020\u001fJ\u0006\u00102\u001a\u00020\u001fJ\u0006\u00103\u001a\u00020\u001fJ*\u00104\u001a\u00020\u001f2\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020706062\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010:\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u001e\u0010;\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat;", "", "()V", "ID", "", "TAG", "", "canReport", "", "currentUser", "Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "enterFromDoubleClick", "enterWithCache", "hasStartHttp", "hascanPlayCall", "isWaiting", "last_selectedColumn", "", "last_selectedRow", "markStoryId", "noCachecurrentUser", "onCreateTime", "onPlayCostTime", "onPlayUser", "onResumeTime", "onSelectItemReport", "onStayTime", "onVideoPlay", "unReadList", "", "canPlay", "", "user", "storyId", "chattingDoubleCheck", "chattingDoubleCheckHasCache", "chattingDoubleCheckNoCache", "chattingRight", "chattingRightHasCache", "chattingRightNoCache", "checkCanPlay", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "cacheSecondsDowngrade", "checkStayTime", "clean", "enter", "unreadList", "finish", "markInit", "markResumeTime", "onDestroy", "onSelectItem", "group", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedRow", "selectedColumn", "onVideoWaiting", "playUser", "preLoadVideo", "startHttp", "CurrentPlayer", "plugin-story_release"})
public final class c {
    private static boolean eDk;
    private static boolean isWaiting;
    public static a sbH;
    private static a sbI;
    private static boolean sbJ;
    private static long sbK;
    private static boolean sbL;
    public static boolean sbM;
    private static long sbN;
    private static boolean sbO;
    private static List<String> sbP;
    public static final c sbQ = new c();
    private static long sbk;
    private static long sbl;
    private static long sbm;
    private static long sbr;
    private static int sbs;
    private static int sbt;
    private static boolean sbu;
    private static long sbx;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBrowseIDKeyStat$CurrentPlayer;", "", "user", "", "scene", "", "(Ljava/lang/String;I)V", "getScene", "()I", "getUser", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class a {
        final String cIS;
        final int scene;

        public a(String str, int i) {
            j.p(str, "user");
            AppMethodBeat.i(109781);
            this.cIS = str;
            this.scene = i;
            AppMethodBeat.o(109781);
        }
    }

    static {
        AppMethodBeat.i(109796);
        AppMethodBeat.o(109796);
    }

    private c() {
    }

    public static void clean() {
        AppMethodBeat.i(109782);
        sbM = false;
        eDk = true;
        sbl = 0;
        sbL = false;
        sbK = 0;
        sbm = 0;
        sbr = 0;
        sbu = false;
        sbs = -1;
        sbt = -1;
        sbx = 0;
        sbO = false;
        isWaiting = false;
        sbP = new ArrayList();
        sbH = new a("", 1);
        AppMethodBeat.o(109782);
    }

    public static void dF(List<String> list) {
        AppMethodBeat.i(109783);
        j.p(list, "unreadList");
        sbP = list;
        AppMethodBeat.o(109783);
    }

    public static void czT() {
        AppMethodBeat.i(109784);
        ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightHasCache");
        sbJ = true;
        h.pYm.k(988, 11, 1);
        AppMethodBeat.o(109784);
    }

    public static void czU() {
        AppMethodBeat.i(109785);
        ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckHasCache");
        sbJ = true;
        h.pYm.k(988, 12, 1);
        AppMethodBeat.o(109785);
    }

    public static void aaN(String str) {
        AppMethodBeat.i(109786);
        j.p(str, "user");
        ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRightNoCache ".concat(String.valueOf(str)));
        sbJ = false;
        sbI = new a(str, 1);
        h.pYm.k(988, 15, 1);
        AppMethodBeat.o(109786);
    }

    public static void aaO(String str) {
        AppMethodBeat.i(109787);
        j.p(str, "user");
        ab.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheckNoCache ".concat(String.valueOf(str)));
        sbJ = false;
        sbI = new a(str, 2);
        h.pYm.k(988, 16, 1);
        AppMethodBeat.o(109787);
    }

    public static void lj(long j) {
        sbk = j;
    }

    public static void ll(long j) {
        if (sbr > 0 && j != 0 && j == sbk && sbK <= 0 && sbl > 0) {
            isWaiting = true;
        }
    }

    public static void lm(long j) {
        AppMethodBeat.i(109788);
        if (sbr <= 0) {
            AppMethodBeat.o(109788);
            return;
        }
        sbL = true;
        if (sbK <= 0) {
            ab.v("MicroMsg.StoryBrowseIDKeyStat", "storyId  " + j + " markStoryId " + sbk + " onPlayCostTime " + sbK + " onResumeTime " + sbl + "  onPlayUser " + sbm);
        }
        if (j != 0 && j == sbk && sbK <= 0 && sbl > 0) {
            sbK = bo.gb(sbl);
            sbN = bo.anU();
            ab.i("MicroMsg.StoryBrowseIDKeyStat", "canPlay " + sbK);
            isWaiting = false;
            if (sbM) {
                if (sbJ) {
                    h.pYm.k(988, 32, sbK);
                    h.pYm.k(988, 33, 1);
                } else {
                    h.pYm.k(988, 36, sbK);
                    h.pYm.k(988, 37, 1);
                }
            } else if (sbJ) {
                h.pYm.k(988, 30, sbK);
                h.pYm.k(988, 31, 1);
            } else {
                h.pYm.k(988, 34, sbK);
                h.pYm.k(988, 35, 1);
            }
            h.pYm.k(988, 71, sbK);
            h.pYm.k(988, 70, 1);
            if (NetStatusUtil.isWifi(ah.getContext()) || NetStatusUtil.is4G(ah.getContext())) {
                h.pYm.k(988, 73, sbK);
                h.pYm.k(988, 72, 1);
            }
            if (sbK <= 400) {
                h.pYm.k(988, 100, sbK);
                AppMethodBeat.o(109788);
                return;
            } else if (sbK <= 800) {
                h.pYm.k(988, 101, sbK);
                AppMethodBeat.o(109788);
                return;
            } else if (sbK <= 1600) {
                h.pYm.k(988, 102, sbK);
                AppMethodBeat.o(109788);
                return;
            } else if (sbK <= 3200) {
                h.pYm.k(988, 103, sbK);
                AppMethodBeat.o(109788);
                return;
            } else if (sbK <= 5000) {
                h.pYm.k(988, 104, sbK);
                AppMethodBeat.o(109788);
                return;
            } else {
                h.pYm.k(988, 105, sbK);
            }
        }
        AppMethodBeat.o(109788);
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0154  */
    /* JADX WARNING: Missing block: B:58:0x0144, code skipped:
            if (r0 >= ((float) com.tencent.mm.plugin.story.ui.view.gallery.n.cCM().soQ)) goto L_0x0146;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(ArrayList<ArrayList<g>> arrayList, int i, int i2) {
        AppMethodBeat.i(109789);
        j.p(arrayList, "group");
        if (sbr <= 0) {
            AppMethodBeat.o(109789);
            return;
        }
        boolean z;
        boolean z2;
        ab.v("MicroMsg.StoryBrowseIDKeyStat", " last_selectedColumn:" + sbt + ",last_selectedRow:" + sbs + " selectedRow:" + i + ",selectedColumn:" + i2);
        if (arrayList.size() > 0) {
            boolean z3;
            if (((ArrayList) arrayList.get(i)).size() <= 0 || i2 + 1 >= ((ArrayList) arrayList.get(i)).size()) {
                z = false;
            } else {
                if (!sbu) {
                    h.pYm.k(988, 42, 1);
                }
                z = true;
            }
            if (i + 1 < arrayList.size()) {
                if (!sbu) {
                    h.pYm.k(988, 43, 1);
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
                h.pYm.k(988, 40, 1);
                isWaiting = false;
            }
            int i3;
            if (i != sbs) {
                if (z) {
                    h.pYm.k(988, 46, 1);
                }
                h.pYm.k(988, 47, 1);
                i3 = i - sbs;
                if (i3 == 1) {
                    h.pYm.k(988, 90, 1);
                } else if (i3 == 2) {
                    h.pYm.k(988, 91, 1);
                } else if (i3 == 3) {
                    h.pYm.k(988, 92, 1);
                } else if (i3 >= 4) {
                    h.pYm.k(988, 93, 1);
                }
                if (arrayList.size() > 0) {
                    int i4 = 0;
                    while (i4 < 3) {
                        if (i + i4 < arrayList.size() && ((ArrayList) arrayList.get(i + i4)).size() > 0) {
                            i iVar = ((g) ((ArrayList) arrayList.get(i + i4)).get(0)).rVZ;
                            if (!(iVar == null || iVar.username == null || sbP == null)) {
                                List list = sbP;
                                if (list != null && list.contains(iVar.username)) {
                                    s sVar = s.rTV;
                                    n a = s.a(iVar);
                                    if (!a.cCd()) {
                                        if (a.field_totalSize > 0) {
                                            float f = (((float) a.field_cacheSize) / ((float) a.field_totalSize)) * 100.0f;
                                            com.tencent.mm.plugin.story.ui.view.gallery.n nVar = com.tencent.mm.plugin.story.ui.view.gallery.n.sqi;
                                        }
                                        z = false;
                                        if (z) {
                                            if (i4 == 0) {
                                                h.pYm.k(988, 80, 1);
                                            } else if (i4 == 1) {
                                                h.pYm.k(988, 81, 1);
                                            } else if (i4 == 2) {
                                                h.pYm.k(988, 82, 1);
                                            }
                                        }
                                        if (i4 != 0) {
                                            h.pYm.k(988, 84, 1);
                                        } else if (i4 == 1) {
                                            h.pYm.k(988, 85, 1);
                                        } else if (i4 == 2) {
                                            h.pYm.k(988, 86, 1);
                                        }
                                    }
                                    z = true;
                                    if (z) {
                                    }
                                    if (i4 != 0) {
                                    }
                                }
                            }
                        }
                        i4++;
                    }
                }
            } else if (i2 != sbt) {
                if (z2) {
                    h.pYm.k(988, 44, 1);
                }
                h.pYm.k(988, 45, 1);
                i3 = i2 - sbt;
                if (i3 == 1) {
                    h.pYm.k(988, 94, 1);
                } else if (i3 == 2) {
                    h.pYm.k(988, 95, 1);
                } else if (i3 == 3) {
                    h.pYm.k(988, 96, 1);
                } else if (i3 >= 4) {
                    h.pYm.k(988, 97, 1);
                }
            }
            czV();
        }
        sbt = i2;
        sbs = i;
        AppMethodBeat.o(109789);
    }

    private static void czV() {
        AppMethodBeat.i(109790);
        ab.v("MicroMsg.StoryBrowseIDKeyStat", "checkStayTime1 onStayTime " + sbx + " hasStartHttp " + sbO + " onPlayCostTime: " + sbK);
        if (sbx == 0 && sbO) {
            if (sbK == 0) {
                sbx = bo.gb(sbl);
                h.pYm.k(988, 63, 1);
                h.pYm.k(988, 62, sbx);
                AppMethodBeat.o(109790);
                return;
            }
            sbx = bo.gb(sbN);
            h.pYm.k(988, 61, 1);
            h.pYm.k(988, 60, sbx);
        }
        AppMethodBeat.o(109790);
    }

    public static void onDestroy() {
        AppMethodBeat.i(109791);
        if (sbr <= 0) {
            AppMethodBeat.o(109791);
            return;
        }
        czV();
        AppMethodBeat.o(109791);
    }

    public static void czW() {
        AppMethodBeat.i(109792);
        if (sbr <= 0) {
            AppMethodBeat.o(109792);
            return;
        }
        ab.i("MicroMsg.StoryBrowseIDKeyStat", "startHttp");
        sbO = true;
        AppMethodBeat.o(109792);
    }

    public static void czR() {
        AppMethodBeat.i(109793);
        ab.v("MicroMsg.StoryBrowseIDKeyStat", "makeResumeTime onResumeTime " + sbl + " onPlayUser " + sbm);
        sbl = bo.anU();
        AppMethodBeat.o(109793);
    }

    public static void ar(String str, long j) {
        AppMethodBeat.i(109794);
        j.p(str, "user");
        if (sbr <= 0) {
            AppMethodBeat.o(109794);
        } else if (sbk != j) {
            sbk = 0;
            ab.i("MicroMsg.StoryBrowseIDKeyStat", "reset storyId markStoryId: " + sbk + " storyId " + j);
            AppMethodBeat.o(109794);
        } else {
            sbm = bo.anU();
            ab.v("MicroMsg.StoryBrowseIDKeyStat", "playUser onResumeTime " + sbm);
            a aVar = sbI;
            if (aVar != null && j.j(aVar.cIS, str)) {
                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                f aap = com.tencent.mm.plugin.story.model.j.a.cxU().aap(str);
                ab.i("MicroMsg.StoryBrowseIDKeyStat", "preLoadCache > 0 then " + str + " preload " + bo.ga(aap.cBL()) + " canPlay: " + sbL);
                if (aap.cBL() > 0) {
                    if (aVar.scene == 1) {
                        h.pYm.k(988, 21, 1);
                        if (sbL) {
                            h.pYm.k(988, 27, 1);
                        }
                    } else if (aVar.scene == 2) {
                        h.pYm.k(988, 22, 1);
                        if (sbL) {
                            h.pYm.k(988, 28, 1);
                        }
                    }
                }
            }
            sbH = null;
            sbI = null;
            AppMethodBeat.o(109794);
        }
    }

    public static void czS() {
        AppMethodBeat.i(109795);
        sbr = bo.anU();
        AppMethodBeat.o(109795);
    }
}
