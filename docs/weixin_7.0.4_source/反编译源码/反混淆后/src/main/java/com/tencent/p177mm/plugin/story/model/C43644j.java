package com.tencent.p177mm.plugin.story.model;

import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.loader.C18532d;
import com.tencent.p177mm.loader.p861c.C37878e;
import com.tencent.p177mm.loader.p864g.C42155f;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.p230g.p231a.C9333fa;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.C33379c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.story.PluginStory.C39859b;
import com.tencent.p177mm.plugin.story.PluginStory.C39860c;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C39864o;
import com.tencent.p177mm.plugin.story.model.C22244o.C22245a;
import com.tencent.p177mm.plugin.story.model.C35205e.C35206a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.model.p1304c.C22226a;
import com.tencent.p177mm.plugin.story.model.p1304c.C22231e;
import com.tencent.p177mm.plugin.story.model.p1304c.C24833d;
import com.tencent.p177mm.plugin.story.model.p1304c.C43636f;
import com.tencent.p177mm.plugin.story.model.p533d.C43637d;
import com.tencent.p177mm.plugin.story.model.p534f.C39895a;
import com.tencent.p177mm.plugin.story.model.p535g.C7149c;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C13740b;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29274a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C39867d;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C39869f;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C39869f.C29278a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C43625e;
import com.tencent.p177mm.plugin.story.p532h.C13765o;
import com.tencent.p177mm.plugin.story.p532h.C13765o.C13766a;
import com.tencent.p177mm.plugin.story.p532h.C29296g;
import com.tencent.p177mm.plugin.story.p532h.C29296g.C29297a;
import com.tencent.p177mm.plugin.story.p532h.C35189b;
import com.tencent.p177mm.plugin.story.p532h.C35189b.C35190a;
import com.tencent.p177mm.plugin.story.p532h.C39883m;
import com.tencent.p177mm.plugin.story.p532h.C39883m.C4122a;
import com.tencent.p177mm.plugin.story.p532h.C46274i;
import com.tencent.p177mm.plugin.story.p532h.C46274i.C22214a;
import com.tencent.p177mm.plugin.story.p532h.C46275k;
import com.tencent.p177mm.plugin.story.p532h.C46275k.C39880a;
import com.tencent.p177mm.plugin.story.p532h.C7610e;
import com.tencent.p177mm.plugin.story.p532h.C7610e.C7611a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wcdb.database.SQLiteException;
import java.util.HashMap;
import p000a.C0220l;
import p000a.C31824m;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0005¢\u0006\u0002\u0010\u0002J\b\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0016H\u0016J\u0016\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0016J\u0006\u00106\u001a\u00020\bJ\u0010\u00107\u001a\u0002022\u0006\u00108\u001a\u00020\bH\u0016J\b\u00109\u001a\u000202H\u0016J\u0010\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020\bH\u0016J\b\u0010<\u001a\u000202H\u0002J\b\u0010=\u001a\u000202H\u0002J\b\u0010>\u001a\u000202H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006A"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "resetDb", "updateConfigs", "Companion", "ConfigChangedListener", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.j */
public final class C43644j implements C1816at {
    private static final String TAG = TAG;
    private static String qLl = "";
    private static final int qLv = 103;
    private static final Point qLw = new Point();
    private static final int rSO = 150;
    private static final C4884c<C9333fa> rSP = new C7158b();
    private static boolean rSQ;
    private static boolean rSR;
    private static long rSS = -1;
    public static final C4133a rST = new C4133a();
    private C7480h eJN;
    private final byte[] eMl = new byte[0];
    private final C7306ak handler = new C7306ak(Looper.getMainLooper());
    private boolean qLf;
    private boolean qLi;
    private C29296g rSA;
    private C39883m rSB;
    private C35189b rSC;
    private C13765o rSD;
    private C7610e rSE;
    private C46274i rSF;
    private C7149c rSG;
    private C35205e rSH;
    private C22231e rSI;
    private C22245a rSJ;
    private C39860c rSK = new C39860c();
    private C39859b rSL = new C39859b();
    private C29307c rSM = new C29307c();
    private C7306ak rSN;
    private HashMap<Integer, C1366d> rSy = new HashMap();
    private C46275k rSz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u000fJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u00020\u000fJ\u0006\u00108\u001a\u00020\u000fJ\b\u00109\u001a\u00020:H\u0002J\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$a */
    public static final class C4133a {
        private C4133a() {
        }

        public /* synthetic */ C4133a(byte b) {
            this();
        }

        private static C43644j cxS() {
            AppMethodBeat.m2504i(109057);
            C43644j c43644j = (C43644j) C7485q.m12925Y(C43644j.class);
            if (c43644j instanceof C43644j) {
                c43644j.qLi;
                if (c43644j.qLf) {
                    synchronized (c43644j.eMl) {
                        try {
                            String access$getTAG$cp = C43644j.TAG;
                            StringBuilder stringBuilder = new StringBuilder("getCore need reset DB now ");
                            Thread currentThread = Thread.currentThread();
                            C25052j.m39375o(currentThread, "Thread.currentThread()");
                            stringBuilder = stringBuilder.append(currentThread.getName()).append(" ");
                            currentThread = Thread.currentThread();
                            C25052j.m39375o(currentThread, "Thread.currentThread()");
                            C4990ab.m7416i(access$getTAG$cp, stringBuilder.append(currentThread.getId()).append(" ").append(c43644j.hashCode()).toString());
                            if (c43644j.qLf) {
                                C43644j.m78125e(c43644j);
                                c43644j.qLf = false;
                                C4990ab.m7416i(C43644j.TAG, "resetdb done");
                            }
                            C37091y c37091y = C37091y.AUy;
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(109057);
                        }
                    }
                }
            }
            C25052j.m39375o(c43644j, "theCore");
            AppMethodBeat.m2505o(109057);
            return c43644j;
        }

        /* renamed from: Ru */
        private static C7480h m6463Ru() {
            AppMethodBeat.m2504i(109058);
            C7480h f = C4133a.cxS().eJN;
            if (f == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109058);
            return f;
        }

        public static C46275k cxT() {
            AppMethodBeat.m2504i(109059);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSz == null) {
                C4133a.cxS().rSz = new C46275k(C4133a.m6463Ru());
            }
            C46275k g = C4133a.cxS().rSz;
            if (g == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109059);
            return g;
        }

        public static C29296g cxU() {
            AppMethodBeat.m2504i(109060);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSA == null) {
                C4133a.cxS().rSA = new C29296g(C4133a.m6463Ru());
            }
            C29296g h = C4133a.cxS().rSA;
            if (h == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109060);
            return h;
        }

        public static C39883m cxV() {
            AppMethodBeat.m2504i(109061);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSB == null) {
                C4133a.cxS().rSB = new C39883m(C4133a.m6463Ru());
            }
            C39883m i = C4133a.cxS().rSB;
            if (i == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109061);
            return i;
        }

        public static C35189b cxW() {
            AppMethodBeat.m2504i(109062);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSC == null) {
                C4133a.cxS().rSC = new C35189b(C4133a.m6463Ru());
            }
            C35189b j = C4133a.cxS().rSC;
            if (j == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109062);
            return j;
        }

        public static C13765o cxX() {
            AppMethodBeat.m2504i(109063);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSD == null) {
                C4133a.cxS().rSD = new C13765o(C4133a.m6463Ru());
            }
            C13765o k = C4133a.cxS().rSD;
            if (k == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109063);
            return k;
        }

        public static C7610e cxY() {
            AppMethodBeat.m2504i(109064);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSE == null) {
                C4133a.cxS().rSE = new C7610e(C4133a.m6463Ru());
            }
            C7610e l = C4133a.cxS().rSE;
            if (l == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109064);
            return l;
        }

        public static C46274i cxZ() {
            AppMethodBeat.m2504i(109065);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSF == null) {
                C4133a.cxS().rSF = new C46274i(C4133a.m6463Ru());
            }
            C46274i m = C4133a.cxS().rSF;
            if (m == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109065);
            return m;
        }

        public static C7306ak cno() {
            AppMethodBeat.m2504i(109066);
            C5004al RS = C1720g.m3539RS();
            C25052j.m39375o(RS, "MMKernel.getPizzaWorkerThread()");
            C7306ak doN = RS.doN();
            C25052j.m39375o(doN, "MMKernel.getPizzaWorkerThread().workerHandler");
            AppMethodBeat.m2505o(109066);
            return doN;
        }

        public static C7149c cya() {
            AppMethodBeat.m2504i(109067);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSG == null) {
                C4133a.cxS().rSG = new C7149c();
            }
            C7149c n = C4133a.cxS().rSG;
            if (n == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109067);
            return n;
        }

        public static C35205e cyb() {
            AppMethodBeat.m2504i(109068);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSH == null) {
                C43644j cxS = C4133a.cxS();
                StringBuilder stringBuilder = new StringBuilder();
                C1706e RP = C1720g.m3536RP();
                C25052j.m39375o(RP, "MMKernel.storage()");
                stringBuilder = stringBuilder.append(RP.mo5235Rt());
                C35206a c35206a = C35205e.rSo;
                cxS.rSH = new C35205e(stringBuilder.append(C35205e.FILE_NAME).toString());
            }
            C35205e o = C4133a.cxS().rSH;
            if (o == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109068);
            return o;
        }

        public static C18532d<C24833d> cyc() {
            AppMethodBeat.m2504i(109069);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSI == null) {
                C4133a.cxS().rSI = new C22231e();
            }
            C22231e p = C4133a.cxS().rSI;
            if (p == null) {
                C25052j.dWJ();
            }
            C18532d c18532d = p.rVR;
            AppMethodBeat.m2505o(109069);
            return c18532d;
        }

        /* renamed from: a */
        public static C37878e m6464a(C22226a c22226a) {
            AppMethodBeat.m2504i(109070);
            C25052j.m39376p(c22226a, "scene");
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSI == null) {
                C4133a.cxS().rSI = new C22231e();
            }
            C22231e p = C4133a.cxS().rSI;
            if (p == null) {
                C25052j.dWJ();
            }
            C25052j.m39376p(c22226a, "scene");
            C37878e c37878e;
            switch (C43636f.eQZ[c22226a.ordinal()]) {
                case 1:
                case 2:
                    c37878e = p.rVU;
                    AppMethodBeat.m2505o(109070);
                    return c37878e;
                case 3:
                    c37878e = p.rVT;
                    AppMethodBeat.m2505o(109070);
                    return c37878e;
                default:
                    C31824m c31824m = new C31824m();
                    AppMethodBeat.m2505o(109070);
                    throw c31824m;
            }
        }

        public static C22245a cyd() {
            AppMethodBeat.m2504i(109071);
            C1720g.m3534RN().mo5159QU();
            if (C4133a.cxS().rSJ == null) {
                C4133a.cxS().rSJ = new C22245a();
            }
            C22245a q = C4133a.cxS().rSJ;
            if (q == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(109071);
            return q;
        }

        public static boolean cnn() {
            AppMethodBeat.m2504i(109072);
            C4133a.cxS();
            if (C43644j.isValid()) {
                AppMethodBeat.m2505o(109072);
                return false;
            }
            AppMethodBeat.m2505o(109072);
            return true;
        }

        public static String cnk() {
            AppMethodBeat.m2504i(109073);
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            String str = (String) RP.mo5239Ry().get(2);
            if (str == null) {
                C4990ab.m7416i(C43644j.TAG, "error getSelfName " + C5046bo.dpG());
            }
            if (str == null) {
                str = "";
            }
            AppMethodBeat.m2505o(109073);
            return str;
        }

        public static String getAccStoryPath() {
            AppMethodBeat.m2504i(109074);
            C1677a M = C1720g.m3530M(C35168e.class);
            C25052j.m39375o(M, "plugin<IPluginStory>(IPluginStory::class.java)");
            String accStoryPath = ((C35168e) M).getAccStoryPath();
            C25052j.m39375o(accStoryPath, "plugin<IPluginStory>(IPl…:class.java).accStoryPath");
            AppMethodBeat.m2505o(109074);
            return accStoryPath;
        }

        public static String getAccStoryCachePath() {
            AppMethodBeat.m2504i(109075);
            C1677a M = C1720g.m3530M(C35168e.class);
            C25052j.m39375o(M, "plugin<IPluginStory>(IPluginStory::class.java)");
            String accStoryCachePath = ((C35168e) M).getAccStoryCachePath();
            C25052j.m39375o(accStoryCachePath, "plugin<IPluginStory>(IPl…s.java).accStoryCachePath");
            AppMethodBeat.m2505o(109075);
            return accStoryCachePath;
        }

        public static C29278a cye() {
            AppMethodBeat.m2504i(109076);
            C29278a c29278a = (C29278a) C39869f.rRC.mo53288Uw();
            AppMethodBeat.m2505o(109076);
            return c29278a;
        }

        static void cyf() {
            int i;
            boolean z;
            AppMethodBeat.m2504i(109077);
            C43644j.rSQ = true;
            C4990ab.m7411d(C43644j.TAG, "loadStoryCheck %s local_debug %s", Integer.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_open, 1)), Boolean.FALSE);
            C5141c ll = C18624c.abi().mo17131ll("100481");
            C25052j.m39375o(ll, "abTestItem");
            if (ll.isValid() && C25052j.m39373j("1", (String) ll.dru().get("open"))) {
                i = 1;
            } else {
                i = r3;
            }
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            C43644j.rSR = z;
            AppMethodBeat.m2505o(109077);
        }

        public static boolean cyg() {
            AppMethodBeat.m2504i(109078);
            if (!C43644j.rSQ) {
                C4133a.cyf();
            }
            boolean cxQ = C43644j.rSR;
            AppMethodBeat.m2505o(109078);
            return cxQ;
        }

        public static long cyh() {
            AppMethodBeat.m2504i(109079);
            if (C43644j.rSS == -1) {
                C1706e RP = C1720g.m3536RP();
                C25052j.m39375o(RP, "MMKernel.storage()");
                C43644j.rSS = RP.mo5239Ry().mo16814a(C5127a.USERINFO_STORY_SNS_ALL_READ_TIME_LONG, 0);
            }
            long cxR = C43644j.rSS;
            AppMethodBeat.m2505o(109079);
            return cxR;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$6 */
    static final class C71566 implements C1366d {
        public static final C71566 rSZ = new C71566();

        static {
            AppMethodBeat.m2504i(109053);
            AppMethodBeat.m2505o(109053);
        }

        C71566() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(109052);
            C4122a c4122a = C39883m.sen;
            String[] cBD = C39883m.fnj;
            AppMethodBeat.m2505o(109052);
            return cBD;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$7 */
    static final class C71577 implements C1366d {
        public static final C71577 rTa = new C71577();

        static {
            AppMethodBeat.m2504i(109055);
            AppMethodBeat.m2505o(109055);
        }

        C71577() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(109054);
            C22214a c22214a = C46274i.sdU;
            String[] cBD = C46274i.fnj;
            AppMethodBeat.m2505o(109054);
            return cBD;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/model/StoryCore$Companion$exptChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$b */
    public static final class C7158b extends C4884c<C9333fa> {
        C7158b() {
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(109056);
            C4133a c4133a = C43644j.rST;
            C4133a.cyf();
            AppMethodBeat.m2505o(109056);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$d */
    static final class C13796d implements Runnable {
        final /* synthetic */ C43644j rTb;

        C13796d(C43644j c43644j) {
            this.rTb = c43644j;
        }

        public final void run() {
            AppMethodBeat.m2504i(109081);
            Looper.prepare();
            this.rTb.rSN = new C7306ak();
            Looper.loop();
            AppMethodBeat.m2505o(109081);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/DynamicConfigUpdatedEvent;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$c */
    public final class C29307c extends C4884c<C6471cq> {
        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(109080);
            C4990ab.m7416i(C43644j.TAG, "dynamicCfg changed, will loadConfig.");
            C43644j.cxN();
            AppMethodBeat.m2505o(109080);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$1 */
    static final class C352151 implements C1366d {
        public static final C352151 rSU = new C352151();

        static {
            AppMethodBeat.m2504i(109043);
            AppMethodBeat.m2505o(109043);
        }

        C352151() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(109042);
            C39880a c39880a = C46275k.sek;
            String[] cBD = C46275k.fnj;
            AppMethodBeat.m2505o(109042);
            return cBD;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$5 */
    static final class C352165 implements C1366d {
        public static final C352165 rSY = new C352165();

        static {
            AppMethodBeat.m2504i(109051);
            AppMethodBeat.m2505o(109051);
        }

        C352165() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(109050);
            C7611a c7611a = C7610e.sdH;
            String[] cBI = C7610e.sdG;
            AppMethodBeat.m2505o(109050);
            return cBI;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$2 */
    static final class C399092 implements C1366d {
        public static final C399092 rSV = new C399092();

        static {
            AppMethodBeat.m2504i(109045);
            AppMethodBeat.m2505o(109045);
        }

        C399092() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(109044);
            C29297a c29297a = C29296g.sdS;
            String[] cBD = C29296g.fnj;
            AppMethodBeat.m2505o(109044);
            return cBD;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$4 */
    static final class C399104 implements C1366d {
        public static final C399104 rSX = new C399104();

        static {
            AppMethodBeat.m2504i(109049);
            AppMethodBeat.m2505o(109049);
        }

        C399104() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(109048);
            C13766a c13766a = C13765o.sep;
            String[] cBI = C13765o.sdG;
            AppMethodBeat.m2505o(109048);
            return cBI;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
    /* renamed from: com.tencent.mm.plugin.story.model.j$3 */
    static final class C436453 implements C1366d {
        public static final C436453 rSW = new C436453();

        static {
            AppMethodBeat.m2504i(109047);
            AppMethodBeat.m2505o(109047);
        }

        C436453() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            AppMethodBeat.m2504i(109046);
            C35190a c35190a = C35189b.sdD;
            String[] cBD = C35189b.fnj;
            AppMethodBeat.m2505o(109046);
            return cBD;
        }
    }

    public C43644j() {
        AppMethodBeat.m2504i(109085);
        C7305d.m12285a((Runnable) new C13796d(this), "SnsCore_task_handler", 10).start();
        this.rSy.put(Integer.valueOf(C46275k.sdP.hashCode()), C352151.rSU);
        this.rSy.put(Integer.valueOf("StoryExtItem".hashCode()), C399092.rSV);
        this.rSy.put(Integer.valueOf("StoryCommentSync".hashCode()), C436453.rSW);
        this.rSy.put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), C399104.rSX);
        this.rSy.put(Integer.valueOf("StoryEditorInfo".hashCode()), C352165.rSY);
        this.rSy.put(Integer.valueOf("StoryRoomInfo".hashCode()), C71566.rSZ);
        this.rSy.put(Integer.valueOf(C46274i.sdP.hashCode()), C71577.rTa);
        AppMethodBeat.m2505o(109085);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(109082);
        if (this.qLi) {
            AppMethodBeat.m2505o(109082);
            return;
        }
        this.qLi = true;
        this.qLf = true;
        C1677a M = C1720g.m3530M(C35168e.class);
        C25052j.m39375o(M, "plugin(IPluginStory::class.java)");
        C5730e.m8643tf(((C35168e) M).getAccStoryPath());
        M = C1720g.m3530M(C35168e.class);
        C25052j.m39375o(M, "plugin(IPluginStory::class.java)");
        C5730e.m8643tf(((C35168e) M).getAccStoryTmpPath());
        C4879a.xxA.mo10052c(this.rSK);
        C4879a.xxA.mo10052c(this.rSL);
        C44042b.m79163a(new C39906h(), "//story");
        C7149c cya = C4133a.cya();
        cya.rXK.mo44160a((C42155f) cya.rXM);
        cya.rXA.mo44160a((C42155f) cya.rXN);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14539a(351, (C1202f) cya);
        C29296g cxU = C4133a.cxU();
        cxU.mo10116c(cxU);
        C46279b c46279b = C46279b.rVw;
        byte[] e = C5730e.m8632e(C46279b.rVo, 0, -1);
        if (e != null) {
            if (!(e.length == 0)) {
                C46279b.rVq.parseFrom(e);
            }
        }
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14539a((int) C33379c.CTRL_INDEX, (C1202f) c46279b);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14539a(764, (C1202f) c46279b);
        C46279b.col();
        C4133a.cyf();
        C39895a.rWL.init();
        rSP.dnU();
        C29309l c29309l = C29309l.rTg;
        C29309l.reset();
        c29309l = C29309l.rTg;
        C5730e.m8643tf(C29309l.cyk() + "coming/");
        C5730e.m8643tf(C29309l.cyk() + "/pic/");
        C5730e.m8643tf(C29309l.cyk() + "/video/");
        C39864o.rQN = C43637d.rVX;
        C4879a.xxA.mo10052c(this.rSM);
        AppMethodBeat.m2505o(109082);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(109083);
        C4879a.xxA.mo10053d(this.rSK);
        C4879a.xxA.mo10053d(this.rSL);
        C4879a.xxA.mo10053d(this.rSM);
        C44042b.m79162N("//story");
        C7149c cya = C4133a.cya();
        cya.rXK.mo44161b((C42155f) cya.rXM);
        cya.rXA.mo44161b((C42155f) cya.rXN);
        C1682b RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "MMKernel.network()");
        RO.mo5186Rg().mo14546b(351, (C1202f) cya);
        C29296g cxU = C4133a.cxU();
        cxU.mo10117d(cxU);
        C46279b c46279b = C46279b.rVw;
        C46279b.cyZ();
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14546b((int) C33379c.CTRL_INDEX, (C1202f) c46279b);
        RO = C1720g.m3535RO();
        C25052j.m39375o(RO, "network()");
        RO.mo5186Rg().mo14546b(764, (C1202f) c46279b);
        C39895a c39895a = C39895a.rWL;
        C4990ab.m7416i(C39895a.TAG, "destroy: ");
        C4133a.cxU().mo10117d(c39895a);
        C4133a.cxT().mo10117d(c39895a);
        C39895a.ilQ.clear();
        C39895a.rWJ.dead();
        C46279b c46279b2 = C46279b.rVw;
        C46279b.m86763b(C39895a.rWK);
        rSP.dead();
        AppMethodBeat.m2505o(109083);
    }

    public static boolean isValid() {
        AppMethodBeat.m2504i(109084);
        boolean QY = C1720g.m3534RN().mo5161QY();
        AppMethodBeat.m2505o(109084);
        return QY;
    }

    static {
        AppMethodBeat.m2504i(109086);
        AppMethodBeat.m2505o(109086);
    }

    public static final /* synthetic */ void cxN() {
        C29274a c29274a = C29274a.rQZ;
        C13740b c13740b = C13740b.rRj;
        C29275c c29275c = C29275c.rRk;
        C39867d c39867d = C39867d.rRo;
        C43625e c43625e = C43625e.rRA;
        C39869f c39869f = C39869f.rRC;
    }

    /* renamed from: e */
    public static final /* synthetic */ void m78125e(C43644j c43644j) {
        AppMethodBeat.m2504i(109087);
        if (c43644j.eJN == null) {
            c43644j.eJN = new C7480h();
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            String str = RP.mo5235Rt() + "StoryMicroMsg.db";
            C7480h c7480h = c43644j.eJN;
            if (c7480h == null) {
                C25052j.dWJ();
            }
            if (!c7480h.mo16661b(str, c43644j.rSy, true)) {
                Throwable sQLiteException = new SQLiteException("story db initViews failed");
                AppMethodBeat.m2505o(109087);
                throw sQLiteException;
            }
        }
        AppMethodBeat.m2505o(109087);
    }
}
