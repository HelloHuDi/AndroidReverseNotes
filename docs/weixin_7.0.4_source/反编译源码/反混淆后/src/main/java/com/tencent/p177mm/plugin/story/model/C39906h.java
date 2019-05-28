package com.tencent.p177mm.plugin.story.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.p532h.C13765o;
import com.tencent.p177mm.plugin.story.p532h.C29296g;
import com.tencent.p177mm.plugin.story.p532h.C29298n;
import com.tencent.p177mm.plugin.story.p532h.C35191c;
import com.tencent.p177mm.plugin.story.p532h.C39879j;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.protocal.protobuf.cfb;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C36913i;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u001d\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001d\u0010\r\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J/\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u001d\u0010\u001e\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\b\u0010\u001f\u001a\u00020\u0004H\u0002¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "allUnRead", "", "allmockData", "args", "", "", "([Ljava/lang/String;)V", "cleanDb", "commentClear", "commentDump", "copyFile", "copydb", "createFiles", "delfile", "dumpDbInfo", "dumpFile", "processCommand", "", "context", "Landroid/content/Context;", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "resetFirst", "rsetStoryPostThreshold", "strangerClear", "strangerDump", "strangerRead", "testMakeData", "videoCacheClear", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.h */
public final class C39906h implements C44041a {
    public static final C39907a rSq = new C39907a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCommand$Companion;", "", "()V", "CommandStart", "", "TAG", "TestAllMockData", "TestAllUnRead", "TestCommentClear", "TestCommentDump", "TestCopyDb", "TestCopyFile", "TestCreateFile", "TestDBClean", "TestDelFile", "TestDumpInfo", "TestDumpeFile", "TestMakeData", "TestResetFirst", "TestStrangerClear", "TestStrangerDump", "TestStrangerMarkRead", "TestVideoCacheClear", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.h$a */
    public static final class C39907a {
        private C39907a() {
        }

        public /* synthetic */ C39907a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(109033);
        AppMethodBeat.m2505o(109033);
    }

    /* JADX WARNING: Missing block: B:5:0x0038, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(109024);
     */
    /* JADX WARNING: Missing block: B:9:0x00a5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(109024);
     */
    /* JADX WARNING: Missing block: B:75:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:76:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(109024);
        C25052j.m39376p(strArr, "args");
        C25052j.m39376p(str, "username");
        C4990ab.m7416i("MicroMsg.StoryCommand", C36913i.m61690a((Object[]) strArr, null, null, null, 0, null, null, 63));
        if (strArr.length > 1) {
            String str2 = strArr[1];
            C4133a c4133a;
            C4133a c4133a2;
            C29309l c29309l;
            switch (str2.hashCode()) {
                case -2127268982:
                    if (str2.equals("strangerDump")) {
                        c4133a = C43644j.rST;
                        for (C4119f c4119f : C4133a.cxU().cBC()) {
                            C4990ab.m7416i("MicroMsg.StoryCommand", "strangerDump " + c4119f.getUserName() + ' ' + c4119f.field_syncId + ' ' + c4119f.field_readId + ' ' + c4119f.field_storyPostTime + ' ' + c4119f.field_updateTime);
                        }
                        break;
                    }
                    break;
                case -2126867668:
                    if (str2.equals("strangerRead")) {
                        c4133a = C43644j.rST;
                        for (C4119f c4119f2 : C4133a.cxU().cBC()) {
                            c4119f2.field_readId = c4119f2.field_syncId;
                            c4133a2 = C43644j.rST;
                            C4133a.cxU().mo47501b(c4119f2);
                        }
                        break;
                    }
                    break;
                case -2122675824:
                    if (str2.equals("dumpFile")) {
                        c29309l = C29309l.rTg;
                        C29309l.cym();
                        break;
                    }
                    break;
                case -2113815067:
                    if (str2.equals("testcopyDb")) {
                        StringBuilder stringBuilder = new StringBuilder();
                        C1706e RP = C1720g.m3536RP();
                        C25052j.m39375o(RP, "MMKernel.storage()");
                        str2 = stringBuilder.append(RP.mo5235Rt()).append("StoryMicroMsg.db").toString();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        c4133a2 = C43644j.rST;
                        String stringBuilder3 = stringBuilder2.append(C4133a.getAccStoryPath()).append("StoryMicroMsg.db").toString();
                        C5730e.m8644y(str2, stringBuilder3);
                        C4990ab.m7416i("MicroMsg.StoryCommand", "copydb ".concat(String.valueOf(stringBuilder3)));
                        C23639t.makeText(C4996ah.getContext(), "copydb done", 1).show();
                        break;
                    }
                    break;
                case -1699823967:
                    if (str2.equals("resetFirst")) {
                        C1706e RP2 = C1720g.m3536RP();
                        C25052j.m39375o(RP2, "MMKernel.storage()");
                        RP2.mo5239Ry().set(C5127a.USERINFO_STORY_BUBBLE_COUNT_INT, Integer.valueOf(0));
                        RP2 = C1720g.m3536RP();
                        C25052j.m39375o(RP2, "MMKernel.storage()");
                        RP2.mo5239Ry().set(C5127a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
                        RP2 = C1720g.m3536RP();
                        C25052j.m39375o(RP2, "MMKernel.storage()");
                        RP2.mo5239Ry().set(C5127a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
                        break;
                    }
                    break;
                case -1522028681:
                    if (str2.equals("strangerClear")) {
                        c4133a = C43644j.rST;
                        for (C4119f c4119f22 : C4133a.cxU().cBP()) {
                            c4133a2 = C43644j.rST;
                            C4133a.cxU().mo16760a((C4925c) c4119f22, new String[0]);
                        }
                        break;
                    }
                    break;
                case -1408241804:
                    if (str2.equals("testDumpInfo")) {
                        c4133a = C43644j.rST;
                        Cursor rawQuery = C4133a.cxX().bSd.rawQuery("select count(*) from StoryVideoCacheInfo", null);
                        C25052j.m39375o(rawQuery, "cu");
                        int count = rawQuery.getCount();
                        rawQuery.close();
                        str2 = "StoryVideoCacheInfo resultData ".concat(String.valueOf(count));
                        c4133a2 = C43644j.rST;
                        C46275k cxT = C4133a.cxT();
                        Cursor rawQuery2 = cxT.bSd.rawQuery("select count(*) from " + C46275k.sdP, null);
                        C25052j.m39375o(rawQuery2, "cu");
                        count = rawQuery2.getCount();
                        rawQuery2.close();
                        C4990ab.m7416i("MicroMsg.StoryCommand", "info1 " + str2 + " info2 " + (C46275k.sdP + " resultData " + count));
                        break;
                    }
                    break;
                case -534114059:
                    if (str2.equals("allmockData")) {
                        C39906h.m68334H(strArr);
                        break;
                    }
                    break;
                case -505421199:
                    if (str2.equals("copyfile")) {
                        Object obj;
                        Object obj2 = strArr[2];
                        c29309l = C29309l.rTg;
                        C29309l.cym();
                        c29309l = C29309l.rTg;
                        C25052j.m39376p(obj2, "path");
                        C29309l.aax(C29309l.cyk() + "cpfiles/");
                        File file = new File(obj2);
                        if (file.exists()) {
                            obj = C29309l.cyk() + "cpfiles/" + file.getName();
                            C4990ab.m7416i("MicroMsg.StoryFileNameUtil", "copy file path " + obj2 + " newPath " + obj);
                            C5730e.m8644y(obj2, obj);
                        } else {
                            obj = "";
                        }
                        C23639t.makeText(C4996ah.getContext(), "copyFile done ".concat(String.valueOf(obj)), 1).show();
                        break;
                    }
                    break;
                case 149228377:
                    if (str2.equals("allmakeData")) {
                        C39906h.m68335I(strArr);
                        break;
                    }
                    break;
                case 536375440:
                    if (str2.equals("allunread")) {
                        C39906h.cxH();
                        break;
                    }
                    break;
                case 769522478:
                    if (str2.equals("commentClear")) {
                        C39906h.cxE();
                        break;
                    }
                    break;
                case 856773767:
                    if (str2.equals("cleandb")) {
                        C39906h.cxG();
                        break;
                    }
                    break;
                case 1233668806:
                    if (str2.equals("videoCacheClear")) {
                        C39906h.cxF();
                        break;
                    }
                    break;
                case 1368796312:
                    if (str2.equals("createFile")) {
                        c29309l = C29309l.rTg;
                        C29309l.cyn();
                        break;
                    }
                    break;
                case 1550482439:
                    if (str2.equals("delfile")) {
                        c29309l = C29309l.rTg;
                        C5730e.m8629cu(C29309l.cyl());
                        break;
                    }
                    break;
                case 2103071987:
                    if (str2.equals("commentDump")) {
                        C39906h.cxD();
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.m2505o(109024);
        return false;
    }

    private static void cxD() {
        AppMethodBeat.m2504i(109025);
        C4133a c4133a = C43644j.rST;
        for (C35191c c35191c : C4133a.cxW().cBC()) {
            C4990ab.m7416i("MicroMsg.StoryCommand", "commentDump " + c35191c.field_storyId + ' ' + c35191c.field_readCommentId + ' ' + c35191c.field_syncCommentId);
        }
        AppMethodBeat.m2505o(109025);
    }

    private static void cxE() {
        AppMethodBeat.m2504i(109026);
        C4133a c4133a = C43644j.rST;
        for (C35191c c35191c : C4133a.cxW().cBC()) {
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxW().mo16760a((C4925c) c35191c, new String[0]);
        }
        AppMethodBeat.m2505o(109026);
    }

    private static void cxF() {
        AppMethodBeat.m2504i(109027);
        C4133a c4133a = C43644j.rST;
        C13765o cxX = C4133a.cxX();
        ArrayList<C29298n> arrayList = new ArrayList();
        Cursor rawQuery = cxX.bSd.rawQuery("select * from StoryVideoCacheInfo", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                C29298n c29298n = new C29298n();
                c29298n.mo8995d(rawQuery);
                arrayList.add(c29298n);
            }
            rawQuery.close();
        }
        for (C29298n c29298n2 : arrayList) {
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxX().mo16760a((C4925c) c29298n2, new String[0]);
        }
        AppMethodBeat.m2505o(109027);
    }

    public static void cxG() {
        AppMethodBeat.m2504i(109028);
        C4990ab.m7416i("MicroMsg.StoryCommand", "cleanDb");
        C4133a c4133a = C43644j.rST;
        C4133a.cxX().cqH();
        c4133a = C43644j.rST;
        C4133a.cxU().cqH();
        c4133a = C43644j.rST;
        C4133a.cxV().cqH();
        c4133a = C43644j.rST;
        C4133a.cxT().cqH();
        c4133a = C43644j.rST;
        C5730e.m8629cu(C4133a.getAccStoryCachePath());
        AppMethodBeat.m2505o(109028);
    }

    public static void cxH() {
        AppMethodBeat.m2504i(109029);
        C4133a c4133a = C43644j.rST;
        C4133a.cxT().cqH();
        c4133a = C43644j.rST;
        C4133a.cxX().cqH();
        c4133a = C43644j.rST;
        C5730e.m8629cu(C4133a.getAccStoryCachePath());
        c4133a = C43644j.rST;
        for (C4119f c4119f : C4133a.cxU().cBP()) {
            c4119f.field_readId = 0;
            c4119f.field_md5 = "";
            c4119f.field_preLoadResource = 0;
            c4119f.aaT("");
            c4119f.field_preloadStoryId = 0;
            C4133a c4133a2 = C43644j.rST;
            C4133a.cxU().mo47500b(c4119f.xDa, c4119f);
        }
        C4990ab.m7416i("MicroMsg.StoryCommand", "allUnRead done");
        C23639t.makeText(C4996ah.getContext(), "allUnRead Done", 1).show();
        AppMethodBeat.m2505o(109029);
    }

    /* renamed from: H */
    private static void m68334H(String[] strArr) {
        AppMethodBeat.m2504i(109030);
        String str = strArr[2];
        C4133a c4133a = C43644j.rST;
        C4119f aap = C4133a.cxU().aap("foreverzeus");
        c4133a = C43644j.rST;
        C4133a c4133a2 = C43644j.rST;
        List a = C46275k.m86718a(C4133a.cxT(), "foreverzeus", C5046bo.isEqual(C4133a.cnk(), "foreverzeus"), C1839cb.aaF() - 86400);
        if (a.isEmpty()) {
            C23639t.makeText(C4996ah.getContext(), "allmockData error1", 1).show();
            AppMethodBeat.m2505o(109030);
            return;
        }
        List<String> my = C37921n.m64074my(str);
        if (my != null) {
            for (String str2 : my) {
                c4133a = C43644j.rST;
                C29296g cxU = C4133a.cxU();
                C25052j.m39375o(str2, "it");
                C4119f aap2 = cxU.aap(str2);
                int i = (int) aap2.xDa;
                if (!aap2.isValid()) {
                    aap.setUserName(str2);
                    aap.field_storyPostTime = (int) C5046bo.m7588yz();
                    aap.xDa = -1;
                    if (i < 0) {
                        c4133a = C43644j.rST;
                        C4133a.cxU().mo10101b((C4925c) aap);
                    } else {
                        c4133a = C43644j.rST;
                        C4133a.cxU().mo47500b(((long) i) * 1, aap);
                    }
                }
                C39879j c39879j = (C39879j) a.get(0);
                c39879j.field_userName = str2;
                c39879j.field_createTime = C1839cb.aaF();
                cfb cBR = c39879j.cBR();
                cBR.jBB = str2;
                c39879j.mo63082b(cBR);
                c39879j.cNE = -1;
                C4133a c4133a3 = C43644j.rST;
                C4133a.cxT().mo10101b((C4925c) c39879j);
            }
        }
        C23639t.makeText(C4996ah.getContext(), "allmockData done", 1).show();
        AppMethodBeat.m2505o(109030);
    }

    /* renamed from: I */
    private static void m68335I(String[] strArr) {
        AppMethodBeat.m2504i(109031);
        int ank = C5046bo.ank(strArr[2]);
        C4990ab.m7416i("MicroMsg.StoryCommand", "testMakeData datacount ".concat(String.valueOf(ank)));
        C4133a c4133a = C43644j.rST;
        C4133a c4133a2 = C43644j.rST;
        List a = C46275k.m86718a(C4133a.cxT(), "ychengo", C5046bo.isEqual(C4133a.cnk(), "ychengo"), C1839cb.aaF() - 86400);
        for (int i = 0; i < ank; i++) {
            C39879j c39879j = (C39879j) a.get(0);
            c39879j.field_userName = "ychengo";
            c39879j.field_createTime = C1839cb.aaF();
            cfb cBR = c39879j.cBR();
            cBR.jBB = "ychengo";
            c39879j.mo63082b(cBR);
            c39879j.cNE = -1;
            C4133a c4133a3 = C43644j.rST;
            C4133a.cxT().mo10101b((C4925c) c39879j);
        }
        C23639t.makeText(C4996ah.getContext(), "testMakeData done ".concat(String.valueOf(ank)), 1).show();
        AppMethodBeat.m2505o(109031);
    }

    public static void cxI() {
        AppMethodBeat.m2504i(109032);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0));
        AppMethodBeat.m2505o(109032);
    }
}
