package com.tencent.mm.plugin.story.model;

import a.a.i;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u001d\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001d\u0010\r\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J/\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u001d\u0010\u001e\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\b\u0010\u001f\u001a\u00020\u0004H\u0002¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
public final class h implements com.tencent.mm.pluginsdk.cmd.a {
    public static final a rSq = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCommand$Companion;", "", "()V", "CommandStart", "", "TAG", "TestAllMockData", "TestAllUnRead", "TestCommentClear", "TestCommentDump", "TestCopyDb", "TestCopyFile", "TestCreateFile", "TestDBClean", "TestDelFile", "TestDumpInfo", "TestDumpeFile", "TestMakeData", "TestResetFirst", "TestStrangerClear", "TestStrangerDump", "TestStrangerMarkRead", "TestVideoCacheClear", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(109033);
        AppMethodBeat.o(109033);
    }

    /* JADX WARNING: Missing block: B:5:0x0038, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(109024);
     */
    /* JADX WARNING: Missing block: B:9:0x00a5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(109024);
     */
    /* JADX WARNING: Missing block: B:75:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:76:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(109024);
        j.p(strArr, "args");
        j.p(str, "username");
        ab.i("MicroMsg.StoryCommand", i.a((Object[]) strArr, null, null, null, 0, null, null, 63));
        if (strArr.length > 1) {
            String str2 = strArr[1];
            com.tencent.mm.plugin.story.model.j.a aVar;
            com.tencent.mm.plugin.story.model.j.a aVar2;
            l lVar;
            switch (str2.hashCode()) {
                case -2127268982:
                    if (str2.equals("strangerDump")) {
                        aVar = j.rST;
                        for (f fVar : com.tencent.mm.plugin.story.model.j.a.cxU().cBC()) {
                            ab.i("MicroMsg.StoryCommand", "strangerDump " + fVar.getUserName() + ' ' + fVar.field_syncId + ' ' + fVar.field_readId + ' ' + fVar.field_storyPostTime + ' ' + fVar.field_updateTime);
                        }
                        break;
                    }
                    break;
                case -2126867668:
                    if (str2.equals("strangerRead")) {
                        aVar = j.rST;
                        for (f fVar2 : com.tencent.mm.plugin.story.model.j.a.cxU().cBC()) {
                            fVar2.field_readId = fVar2.field_syncId;
                            aVar2 = j.rST;
                            com.tencent.mm.plugin.story.model.j.a.cxU().b(fVar2);
                        }
                        break;
                    }
                    break;
                case -2122675824:
                    if (str2.equals("dumpFile")) {
                        lVar = l.rTg;
                        l.cym();
                        break;
                    }
                    break;
                case -2113815067:
                    if (str2.equals("testcopyDb")) {
                        StringBuilder stringBuilder = new StringBuilder();
                        e RP = g.RP();
                        j.o(RP, "MMKernel.storage()");
                        str2 = stringBuilder.append(RP.Rt()).append("StoryMicroMsg.db").toString();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        aVar2 = j.rST;
                        String stringBuilder3 = stringBuilder2.append(com.tencent.mm.plugin.story.model.j.a.getAccStoryPath()).append("StoryMicroMsg.db").toString();
                        com.tencent.mm.vfs.e.y(str2, stringBuilder3);
                        ab.i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(stringBuilder3)));
                        t.makeText(ah.getContext(), "copydb done", 1).show();
                        break;
                    }
                    break;
                case -1699823967:
                    if (str2.equals("resetFirst")) {
                        e RP2 = g.RP();
                        j.o(RP2, "MMKernel.storage()");
                        RP2.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_BUBBLE_COUNT_INT, Integer.valueOf(0));
                        RP2 = g.RP();
                        j.o(RP2, "MMKernel.storage()");
                        RP2.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
                        RP2 = g.RP();
                        j.o(RP2, "MMKernel.storage()");
                        RP2.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
                        break;
                    }
                    break;
                case -1522028681:
                    if (str2.equals("strangerClear")) {
                        aVar = j.rST;
                        for (f fVar22 : com.tencent.mm.plugin.story.model.j.a.cxU().cBP()) {
                            aVar2 = j.rST;
                            com.tencent.mm.plugin.story.model.j.a.cxU().a((c) fVar22, new String[0]);
                        }
                        break;
                    }
                    break;
                case -1408241804:
                    if (str2.equals("testDumpInfo")) {
                        aVar = j.rST;
                        Cursor rawQuery = com.tencent.mm.plugin.story.model.j.a.cxX().bSd.rawQuery("select count(*) from StoryVideoCacheInfo", null);
                        j.o(rawQuery, "cu");
                        int count = rawQuery.getCount();
                        rawQuery.close();
                        str2 = "StoryVideoCacheInfo resultData ".concat(String.valueOf(count));
                        aVar2 = j.rST;
                        k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
                        Cursor rawQuery2 = cxT.bSd.rawQuery("select count(*) from " + k.sdP, null);
                        j.o(rawQuery2, "cu");
                        count = rawQuery2.getCount();
                        rawQuery2.close();
                        ab.i("MicroMsg.StoryCommand", "info1 " + str2 + " info2 " + (k.sdP + " resultData " + count));
                        break;
                    }
                    break;
                case -534114059:
                    if (str2.equals("allmockData")) {
                        H(strArr);
                        break;
                    }
                    break;
                case -505421199:
                    if (str2.equals("copyfile")) {
                        Object obj;
                        Object obj2 = strArr[2];
                        lVar = l.rTg;
                        l.cym();
                        lVar = l.rTg;
                        j.p(obj2, "path");
                        l.aax(l.cyk() + "cpfiles/");
                        File file = new File(obj2);
                        if (file.exists()) {
                            obj = l.cyk() + "cpfiles/" + file.getName();
                            ab.i("MicroMsg.StoryFileNameUtil", "copy file path " + obj2 + " newPath " + obj);
                            com.tencent.mm.vfs.e.y(obj2, obj);
                        } else {
                            obj = "";
                        }
                        t.makeText(ah.getContext(), "copyFile done ".concat(String.valueOf(obj)), 1).show();
                        break;
                    }
                    break;
                case 149228377:
                    if (str2.equals("allmakeData")) {
                        I(strArr);
                        break;
                    }
                    break;
                case 536375440:
                    if (str2.equals("allunread")) {
                        cxH();
                        break;
                    }
                    break;
                case 769522478:
                    if (str2.equals("commentClear")) {
                        cxE();
                        break;
                    }
                    break;
                case 856773767:
                    if (str2.equals("cleandb")) {
                        cxG();
                        break;
                    }
                    break;
                case 1233668806:
                    if (str2.equals("videoCacheClear")) {
                        cxF();
                        break;
                    }
                    break;
                case 1368796312:
                    if (str2.equals("createFile")) {
                        lVar = l.rTg;
                        l.cyn();
                        break;
                    }
                    break;
                case 1550482439:
                    if (str2.equals("delfile")) {
                        lVar = l.rTg;
                        com.tencent.mm.vfs.e.cu(l.cyl());
                        break;
                    }
                    break;
                case 2103071987:
                    if (str2.equals("commentDump")) {
                        cxD();
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(109024);
        return false;
    }

    private static void cxD() {
        AppMethodBeat.i(109025);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        for (com.tencent.mm.plugin.story.h.c cVar : com.tencent.mm.plugin.story.model.j.a.cxW().cBC()) {
            ab.i("MicroMsg.StoryCommand", "commentDump " + cVar.field_storyId + ' ' + cVar.field_readCommentId + ' ' + cVar.field_syncCommentId);
        }
        AppMethodBeat.o(109025);
    }

    private static void cxE() {
        AppMethodBeat.i(109026);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        for (com.tencent.mm.plugin.story.h.c cVar : com.tencent.mm.plugin.story.model.j.a.cxW().cBC()) {
            com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxW().a((c) cVar, new String[0]);
        }
        AppMethodBeat.o(109026);
    }

    private static void cxF() {
        AppMethodBeat.i(109027);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        o cxX = com.tencent.mm.plugin.story.model.j.a.cxX();
        ArrayList<n> arrayList = new ArrayList();
        Cursor rawQuery = cxX.bSd.rawQuery("select * from StoryVideoCacheInfo", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                n nVar = new n();
                nVar.d(rawQuery);
                arrayList.add(nVar);
            }
            rawQuery.close();
        }
        for (n nVar2 : arrayList) {
            com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxX().a((c) nVar2, new String[0]);
        }
        AppMethodBeat.o(109027);
    }

    public static void cxG() {
        AppMethodBeat.i(109028);
        ab.i("MicroMsg.StoryCommand", "cleanDb");
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxX().cqH();
        aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxU().cqH();
        aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxV().cqH();
        aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxT().cqH();
        aVar = j.rST;
        com.tencent.mm.vfs.e.cu(com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath());
        AppMethodBeat.o(109028);
    }

    public static void cxH() {
        AppMethodBeat.i(109029);
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxT().cqH();
        aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxX().cqH();
        aVar = j.rST;
        com.tencent.mm.vfs.e.cu(com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath());
        aVar = j.rST;
        for (f fVar : com.tencent.mm.plugin.story.model.j.a.cxU().cBP()) {
            fVar.field_readId = 0;
            fVar.field_md5 = "";
            fVar.field_preLoadResource = 0;
            fVar.aaT("");
            fVar.field_preloadStoryId = 0;
            com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxU().b(fVar.xDa, fVar);
        }
        ab.i("MicroMsg.StoryCommand", "allUnRead done");
        t.makeText(ah.getContext(), "allUnRead Done", 1).show();
        AppMethodBeat.o(109029);
    }

    private static void H(String[] strArr) {
        AppMethodBeat.i(109030);
        String str = strArr[2];
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        f aap = com.tencent.mm.plugin.story.model.j.a.cxU().aap("foreverzeus");
        aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
        List a = k.a(com.tencent.mm.plugin.story.model.j.a.cxT(), "foreverzeus", bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), "foreverzeus"), cb.aaF() - 86400);
        if (a.isEmpty()) {
            t.makeText(ah.getContext(), "allmockData error1", 1).show();
            AppMethodBeat.o(109030);
            return;
        }
        List<String> my = com.tencent.mm.model.n.my(str);
        if (my != null) {
            for (String str2 : my) {
                aVar = j.rST;
                com.tencent.mm.plugin.story.h.g cxU = com.tencent.mm.plugin.story.model.j.a.cxU();
                j.o(str2, "it");
                f aap2 = cxU.aap(str2);
                int i = (int) aap2.xDa;
                if (!aap2.isValid()) {
                    aap.setUserName(str2);
                    aap.field_storyPostTime = (int) bo.yz();
                    aap.xDa = -1;
                    if (i < 0) {
                        aVar = j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cxU().b((c) aap);
                    } else {
                        aVar = j.rST;
                        com.tencent.mm.plugin.story.model.j.a.cxU().b(((long) i) * 1, aap);
                    }
                }
                com.tencent.mm.plugin.story.h.j jVar = (com.tencent.mm.plugin.story.h.j) a.get(0);
                jVar.field_userName = str2;
                jVar.field_createTime = cb.aaF();
                cfb cBR = jVar.cBR();
                cBR.jBB = str2;
                jVar.b(cBR);
                jVar.cNE = -1;
                com.tencent.mm.plugin.story.model.j.a aVar3 = j.rST;
                com.tencent.mm.plugin.story.model.j.a.cxT().b((c) jVar);
            }
        }
        t.makeText(ah.getContext(), "allmockData done", 1).show();
        AppMethodBeat.o(109030);
    }

    private static void I(String[] strArr) {
        AppMethodBeat.i(109031);
        int ank = bo.ank(strArr[2]);
        ab.i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(ank)));
        com.tencent.mm.plugin.story.model.j.a aVar = j.rST;
        com.tencent.mm.plugin.story.model.j.a aVar2 = j.rST;
        List a = k.a(com.tencent.mm.plugin.story.model.j.a.cxT(), "ychengo", bo.isEqual(com.tencent.mm.plugin.story.model.j.a.cnk(), "ychengo"), cb.aaF() - 86400);
        for (int i = 0; i < ank; i++) {
            com.tencent.mm.plugin.story.h.j jVar = (com.tencent.mm.plugin.story.h.j) a.get(0);
            jVar.field_userName = "ychengo";
            jVar.field_createTime = cb.aaF();
            cfb cBR = jVar.cBR();
            cBR.jBB = "ychengo";
            jVar.b(cBR);
            jVar.cNE = -1;
            com.tencent.mm.plugin.story.model.j.a aVar3 = j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().b((c) jVar);
        }
        t.makeText(ah.getContext(), "testMakeData done ".concat(String.valueOf(ank)), 1).show();
        AppMethodBeat.o(109031);
    }

    public static void cxI() {
        AppMethodBeat.i(109032);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        AppMethodBeat.o(109032);
    }
}
