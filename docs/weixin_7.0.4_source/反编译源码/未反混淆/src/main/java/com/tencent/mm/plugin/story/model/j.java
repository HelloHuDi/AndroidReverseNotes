package com.tencent.mm.plugin.story.model;

import a.l;
import a.y;
import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.story.h.e;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.h.m;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.c.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteException;
import java.util.HashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0005¢\u0006\u0002\u0010\u0002J\b\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0016H\u0016J\u0016\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0016J\u0006\u00106\u001a\u00020\bJ\u0010\u00107\u001a\u0002022\u0006\u00108\u001a\u00020\bH\u0016J\b\u00109\u001a\u000202H\u0016J\u0010\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020\bH\u0016J\b\u0010<\u001a\u000202H\u0002J\b\u0010=\u001a\u000202H\u0002J\b\u0010>\u001a\u000202H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006A"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "resetDb", "updateConfigs", "Companion", "ConfigChangedListener", "plugin-story_release"})
public final class j implements at {
    private static final String TAG = TAG;
    private static String qLl = "";
    private static final int qLv = 103;
    private static final Point qLw = new Point();
    private static final int rSO = 150;
    private static final com.tencent.mm.sdk.b.c<fa> rSP = new b();
    private static boolean rSQ;
    private static boolean rSR;
    private static long rSS = -1;
    public static final a rST = new a();
    private h eJN;
    private final byte[] eMl = new byte[0];
    private final ak handler = new ak(Looper.getMainLooper());
    private boolean qLf;
    private boolean qLi;
    private g rSA;
    private m rSB;
    private com.tencent.mm.plugin.story.h.b rSC;
    private o rSD;
    private e rSE;
    private i rSF;
    private com.tencent.mm.plugin.story.model.g.c rSG;
    private e rSH;
    private com.tencent.mm.plugin.story.model.c.e rSI;
    private com.tencent.mm.plugin.story.model.o.a rSJ;
    private com.tencent.mm.plugin.story.PluginStory.c rSK = new com.tencent.mm.plugin.story.PluginStory.c();
    private com.tencent.mm.plugin.story.PluginStory.b rSL = new com.tencent.mm.plugin.story.PluginStory.b();
    private c rSM = new c();
    private ak rSN;
    private HashMap<Integer, com.tencent.mm.cd.h.d> rSy = new HashMap();
    private k rSz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u000fJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u00020\u000fJ\u0006\u00108\u001a\u00020\u000fJ\b\u00109\u001a\u00020:H\u0002J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private static j cxS() {
            AppMethodBeat.i(109057);
            j jVar = (j) q.Y(j.class);
            if (jVar instanceof j) {
                jVar.qLi;
                if (jVar.qLf) {
                    synchronized (jVar.eMl) {
                        try {
                            String access$getTAG$cp = j.TAG;
                            StringBuilder stringBuilder = new StringBuilder("getCore need reset DB now ");
                            Thread currentThread = Thread.currentThread();
                            a.f.b.j.o(currentThread, "Thread.currentThread()");
                            stringBuilder = stringBuilder.append(currentThread.getName()).append(" ");
                            currentThread = Thread.currentThread();
                            a.f.b.j.o(currentThread, "Thread.currentThread()");
                            ab.i(access$getTAG$cp, stringBuilder.append(currentThread.getId()).append(" ").append(jVar.hashCode()).toString());
                            if (jVar.qLf) {
                                j.e(jVar);
                                jVar.qLf = false;
                                ab.i(j.TAG, "resetdb done");
                            }
                            y yVar = y.AUy;
                        } catch (Throwable th) {
                            AppMethodBeat.o(109057);
                        }
                    }
                }
            }
            a.f.b.j.o(jVar, "theCore");
            AppMethodBeat.o(109057);
            return jVar;
        }

        private static h Ru() {
            AppMethodBeat.i(109058);
            h f = cxS().eJN;
            if (f == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109058);
            return f;
        }

        public static k cxT() {
            AppMethodBeat.i(109059);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSz == null) {
                cxS().rSz = new k(Ru());
            }
            k g = cxS().rSz;
            if (g == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109059);
            return g;
        }

        public static g cxU() {
            AppMethodBeat.i(109060);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSA == null) {
                cxS().rSA = new g(Ru());
            }
            g h = cxS().rSA;
            if (h == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109060);
            return h;
        }

        public static m cxV() {
            AppMethodBeat.i(109061);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSB == null) {
                cxS().rSB = new m(Ru());
            }
            m i = cxS().rSB;
            if (i == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109061);
            return i;
        }

        public static com.tencent.mm.plugin.story.h.b cxW() {
            AppMethodBeat.i(109062);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSC == null) {
                cxS().rSC = new com.tencent.mm.plugin.story.h.b(Ru());
            }
            com.tencent.mm.plugin.story.h.b j = cxS().rSC;
            if (j == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109062);
            return j;
        }

        public static o cxX() {
            AppMethodBeat.i(109063);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSD == null) {
                cxS().rSD = new o(Ru());
            }
            o k = cxS().rSD;
            if (k == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109063);
            return k;
        }

        public static e cxY() {
            AppMethodBeat.i(109064);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSE == null) {
                cxS().rSE = new e(Ru());
            }
            e l = cxS().rSE;
            if (l == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109064);
            return l;
        }

        public static i cxZ() {
            AppMethodBeat.i(109065);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSF == null) {
                cxS().rSF = new i(Ru());
            }
            i m = cxS().rSF;
            if (m == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109065);
            return m;
        }

        public static ak cno() {
            AppMethodBeat.i(109066);
            al RS = com.tencent.mm.kernel.g.RS();
            a.f.b.j.o(RS, "MMKernel.getPizzaWorkerThread()");
            ak doN = RS.doN();
            a.f.b.j.o(doN, "MMKernel.getPizzaWorkerThread().workerHandler");
            AppMethodBeat.o(109066);
            return doN;
        }

        public static com.tencent.mm.plugin.story.model.g.c cya() {
            AppMethodBeat.i(109067);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSG == null) {
                cxS().rSG = new com.tencent.mm.plugin.story.model.g.c();
            }
            com.tencent.mm.plugin.story.model.g.c n = cxS().rSG;
            if (n == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109067);
            return n;
        }

        public static e cyb() {
            AppMethodBeat.i(109068);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSH == null) {
                j cxS = cxS();
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
                a.f.b.j.o(RP, "MMKernel.storage()");
                stringBuilder = stringBuilder.append(RP.Rt());
                com.tencent.mm.plugin.story.model.e.a aVar = e.rSo;
                cxS.rSH = new e(stringBuilder.append(e.FILE_NAME).toString());
            }
            e o = cxS().rSH;
            if (o == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109068);
            return o;
        }

        public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.model.c.d> cyc() {
            AppMethodBeat.i(109069);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSI == null) {
                cxS().rSI = new com.tencent.mm.plugin.story.model.c.e();
            }
            com.tencent.mm.plugin.story.model.c.e p = cxS().rSI;
            if (p == null) {
                a.f.b.j.dWJ();
            }
            com.tencent.mm.loader.d dVar = p.rVR;
            AppMethodBeat.o(109069);
            return dVar;
        }

        public static com.tencent.mm.loader.c.e a(com.tencent.mm.plugin.story.model.c.a aVar) {
            AppMethodBeat.i(109070);
            a.f.b.j.p(aVar, "scene");
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSI == null) {
                cxS().rSI = new com.tencent.mm.plugin.story.model.c.e();
            }
            com.tencent.mm.plugin.story.model.c.e p = cxS().rSI;
            if (p == null) {
                a.f.b.j.dWJ();
            }
            a.f.b.j.p(aVar, "scene");
            com.tencent.mm.loader.c.e eVar;
            switch (f.eQZ[aVar.ordinal()]) {
                case 1:
                case 2:
                    eVar = p.rVU;
                    AppMethodBeat.o(109070);
                    return eVar;
                case 3:
                    eVar = p.rVT;
                    AppMethodBeat.o(109070);
                    return eVar;
                default:
                    a.m mVar = new a.m();
                    AppMethodBeat.o(109070);
                    throw mVar;
            }
        }

        public static com.tencent.mm.plugin.story.model.o.a cyd() {
            AppMethodBeat.i(109071);
            com.tencent.mm.kernel.g.RN().QU();
            if (cxS().rSJ == null) {
                cxS().rSJ = new com.tencent.mm.plugin.story.model.o.a();
            }
            com.tencent.mm.plugin.story.model.o.a q = cxS().rSJ;
            if (q == null) {
                a.f.b.j.dWJ();
            }
            AppMethodBeat.o(109071);
            return q;
        }

        public static boolean cnn() {
            AppMethodBeat.i(109072);
            cxS();
            if (j.isValid()) {
                AppMethodBeat.o(109072);
                return false;
            }
            AppMethodBeat.o(109072);
            return true;
        }

        public static String cnk() {
            AppMethodBeat.i(109073);
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            String str = (String) RP.Ry().get(2);
            if (str == null) {
                ab.i(j.TAG, "error getSelfName " + bo.dpG());
            }
            if (str == null) {
                str = "";
            }
            AppMethodBeat.o(109073);
            return str;
        }

        public static String getAccStoryPath() {
            AppMethodBeat.i(109074);
            com.tencent.mm.kernel.b.a M = com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class);
            a.f.b.j.o(M, "plugin<IPluginStory>(IPluginStory::class.java)");
            String accStoryPath = ((com.tencent.mm.plugin.story.api.e) M).getAccStoryPath();
            a.f.b.j.o(accStoryPath, "plugin<IPluginStory>(IPl…:class.java).accStoryPath");
            AppMethodBeat.o(109074);
            return accStoryPath;
        }

        public static String getAccStoryCachePath() {
            AppMethodBeat.i(109075);
            com.tencent.mm.kernel.b.a M = com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class);
            a.f.b.j.o(M, "plugin<IPluginStory>(IPluginStory::class.java)");
            String accStoryCachePath = ((com.tencent.mm.plugin.story.api.e) M).getAccStoryCachePath();
            a.f.b.j.o(accStoryCachePath, "plugin<IPluginStory>(IPl…s.java).accStoryCachePath");
            AppMethodBeat.o(109075);
            return accStoryCachePath;
        }

        public static com.tencent.mm.plugin.story.c.a.f.a cye() {
            AppMethodBeat.i(109076);
            com.tencent.mm.plugin.story.c.a.f.a aVar = (com.tencent.mm.plugin.story.c.a.f.a) com.tencent.mm.plugin.story.c.a.f.rRC.Uw();
            AppMethodBeat.o(109076);
            return aVar;
        }

        static void cyf() {
            int i;
            boolean z;
            AppMethodBeat.i(109077);
            j.rSQ = true;
            ab.d(j.TAG, "loadStoryCheck %s local_debug %s", Integer.valueOf(((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_open, 1)), Boolean.FALSE);
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100481");
            a.f.b.j.o(ll, "abTestItem");
            if (ll.isValid() && a.f.b.j.j("1", (String) ll.dru().get("open"))) {
                i = 1;
            } else {
                i = r3;
            }
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            j.rSR = z;
            AppMethodBeat.o(109077);
        }

        public static boolean cyg() {
            AppMethodBeat.i(109078);
            if (!j.rSQ) {
                cyf();
            }
            boolean cxQ = j.rSR;
            AppMethodBeat.o(109078);
            return cxQ;
        }

        public static long cyh() {
            AppMethodBeat.i(109079);
            if (j.rSS == -1) {
                com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
                a.f.b.j.o(RP, "MMKernel.storage()");
                j.rSS = RP.Ry().a(com.tencent.mm.storage.ac.a.USERINFO_STORY_SNS_ALL_READ_TIME_LONG, 0);
            }
            long cxR = j.rSS;
            AppMethodBeat.o(109079);
            return cxR;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/StoryCore$Companion$exptChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class b extends com.tencent.mm.sdk.b.c<fa> {
        b() {
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(109056);
            a aVar = j.rST;
            a.cyf();
            AppMethodBeat.o(109056);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ j rTb;

        d(j jVar) {
            this.rTb = jVar;
        }

        public final void run() {
            AppMethodBeat.i(109081);
            Looper.prepare();
            this.rTb.rSN = new ak();
            Looper.loop();
            AppMethodBeat.o(109081);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/DynamicConfigUpdatedEvent;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "callback", "", "event", "plugin-story_release"})
    public final class c extends com.tencent.mm.sdk.b.c<cq> {
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(109080);
            ab.i(j.TAG, "dynamicCfg changed, will loadConfig.");
            j.cxN();
            AppMethodBeat.o(109080);
            return false;
        }
    }

    public j() {
        AppMethodBeat.i(109085);
        com.tencent.mm.sdk.g.d.a((Runnable) new d(this), "SnsCore_task_handler", 10).start();
        this.rSy.put(Integer.valueOf(k.sdP.hashCode()), AnonymousClass1.rSU);
        this.rSy.put(Integer.valueOf("StoryExtItem".hashCode()), AnonymousClass2.rSV);
        this.rSy.put(Integer.valueOf("StoryCommentSync".hashCode()), AnonymousClass3.rSW);
        this.rSy.put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), AnonymousClass4.rSX);
        this.rSy.put(Integer.valueOf("StoryEditorInfo".hashCode()), AnonymousClass5.rSY);
        this.rSy.put(Integer.valueOf("StoryRoomInfo".hashCode()), AnonymousClass6.rSZ);
        this.rSy.put(Integer.valueOf(i.sdP.hashCode()), AnonymousClass7.rTa);
        AppMethodBeat.o(109085);
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(109082);
        if (this.qLi) {
            AppMethodBeat.o(109082);
            return;
        }
        this.qLi = true;
        this.qLf = true;
        com.tencent.mm.kernel.b.a M = com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class);
        a.f.b.j.o(M, "plugin(IPluginStory::class.java)");
        com.tencent.mm.vfs.e.tf(((com.tencent.mm.plugin.story.api.e) M).getAccStoryPath());
        M = com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class);
        a.f.b.j.o(M, "plugin(IPluginStory::class.java)");
        com.tencent.mm.vfs.e.tf(((com.tencent.mm.plugin.story.api.e) M).getAccStoryTmpPath());
        com.tencent.mm.sdk.b.a.xxA.c(this.rSK);
        com.tencent.mm.sdk.b.a.xxA.c(this.rSL);
        com.tencent.mm.pluginsdk.cmd.b.a(new h(), "//story");
        com.tencent.mm.plugin.story.model.g.c cya = a.cya();
        cya.rXK.a((com.tencent.mm.loader.g.f) cya.rXM);
        cya.rXA.a((com.tencent.mm.loader.g.f) cya.rXN);
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().a(351, (com.tencent.mm.ai.f) cya);
        g cxU = a.cxU();
        cxU.c(cxU);
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        byte[] e = com.tencent.mm.vfs.e.e(com.tencent.mm.plugin.story.model.b.b.rVo, 0, -1);
        if (e != null) {
            if (!(e.length == 0)) {
                com.tencent.mm.plugin.story.model.b.b.rVq.parseFrom(e);
            }
        }
        RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "network()");
        RO.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX, (com.tencent.mm.ai.f) bVar);
        RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "network()");
        RO.Rg().a(764, (com.tencent.mm.ai.f) bVar);
        com.tencent.mm.plugin.story.model.b.b.col();
        a.cyf();
        com.tencent.mm.plugin.story.model.f.a.rWL.init();
        rSP.dnU();
        l lVar = l.rTg;
        l.reset();
        lVar = l.rTg;
        com.tencent.mm.vfs.e.tf(l.cyk() + "coming/");
        com.tencent.mm.vfs.e.tf(l.cyk() + "/pic/");
        com.tencent.mm.vfs.e.tf(l.cyk() + "/video/");
        com.tencent.mm.plugin.story.api.o.rQN = com.tencent.mm.plugin.story.model.d.d.rVX;
        com.tencent.mm.sdk.b.a.xxA.c(this.rSM);
        AppMethodBeat.o(109082);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(109083);
        com.tencent.mm.sdk.b.a.xxA.d(this.rSK);
        com.tencent.mm.sdk.b.a.xxA.d(this.rSL);
        com.tencent.mm.sdk.b.a.xxA.d(this.rSM);
        com.tencent.mm.pluginsdk.cmd.b.N("//story");
        com.tencent.mm.plugin.story.model.g.c cya = a.cya();
        cya.rXK.b((com.tencent.mm.loader.g.f) cya.rXM);
        cya.rXA.b((com.tencent.mm.loader.g.f) cya.rXN);
        com.tencent.mm.kernel.b RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "MMKernel.network()");
        RO.Rg().b(351, (com.tencent.mm.ai.f) cya);
        g cxU = a.cxU();
        cxU.d(cxU);
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.cyZ();
        RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "network()");
        RO.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.nfc.c.CTRL_INDEX, (com.tencent.mm.ai.f) bVar);
        RO = com.tencent.mm.kernel.g.RO();
        a.f.b.j.o(RO, "network()");
        RO.Rg().b(764, (com.tencent.mm.ai.f) bVar);
        com.tencent.mm.plugin.story.model.f.a aVar = com.tencent.mm.plugin.story.model.f.a.rWL;
        ab.i(com.tencent.mm.plugin.story.model.f.a.TAG, "destroy: ");
        a.cxU().d(aVar);
        a.cxT().d(aVar);
        com.tencent.mm.plugin.story.model.f.a.ilQ.clear();
        com.tencent.mm.plugin.story.model.f.a.rWJ.dead();
        com.tencent.mm.plugin.story.model.b.b bVar2 = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.b(com.tencent.mm.plugin.story.model.f.a.rWK);
        rSP.dead();
        AppMethodBeat.o(109083);
    }

    public static boolean isValid() {
        AppMethodBeat.i(109084);
        boolean QY = com.tencent.mm.kernel.g.RN().QY();
        AppMethodBeat.o(109084);
        return QY;
    }

    static {
        AppMethodBeat.i(109086);
        AppMethodBeat.o(109086);
    }

    public static final /* synthetic */ void cxN() {
        com.tencent.mm.plugin.story.c.a.a aVar = com.tencent.mm.plugin.story.c.a.a.rQZ;
        com.tencent.mm.plugin.story.c.a.b bVar = com.tencent.mm.plugin.story.c.a.b.rRj;
        com.tencent.mm.plugin.story.c.a.c cVar = com.tencent.mm.plugin.story.c.a.c.rRk;
        com.tencent.mm.plugin.story.c.a.d dVar = com.tencent.mm.plugin.story.c.a.d.rRo;
        com.tencent.mm.plugin.story.c.a.e eVar = com.tencent.mm.plugin.story.c.a.e.rRA;
        com.tencent.mm.plugin.story.c.a.f fVar = com.tencent.mm.plugin.story.c.a.f.rRC;
    }

    public static final /* synthetic */ void e(j jVar) {
        AppMethodBeat.i(109087);
        if (jVar.eJN == null) {
            jVar.eJN = new h();
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            String str = RP.Rt() + "StoryMicroMsg.db";
            h hVar = jVar.eJN;
            if (hVar == null) {
                a.f.b.j.dWJ();
            }
            if (!hVar.b(str, jVar.rSy, true)) {
                Throwable sQLiteException = new SQLiteException("story db initViews failed");
                AppMethodBeat.o(109087);
                throw sQLiteException;
            }
        }
        AppMethodBeat.o(109087);
    }
}
