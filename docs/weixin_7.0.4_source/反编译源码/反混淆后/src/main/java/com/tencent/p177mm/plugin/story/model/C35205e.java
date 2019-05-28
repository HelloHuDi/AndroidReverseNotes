package com.tencent.p177mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.cdq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ;2\u00020\u0001:\u0001;B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0013J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u0016\u0010 \u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0003J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003J&\u0010)\u001a\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\"2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0007H\u0002J\u000e\u0010.\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0007J\b\u0010/\u001a\u00020\u0017H\u0002J\u0016\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007J\u000e\u00103\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u00104\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u00105\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u0007J\u000e\u00109\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "", "path", "", "(Ljava/lang/String;)V", "downLoadingScenes", "Ljava/util/HashMap;", "", "downLoadingSize", "getDownLoadingSize", "()I", "postLocks", "Ljava/util/Vector;", "queue", "Lcom/tencent/mm/protocal/protobuf/StoryAsyncQueue;", "releactionUploadScene", "selfName", "uploadLocks", "addDelItem", "", "snsId", "", "addDownLoadingId", "", "mediaId", "sceneKey", "addPostId", "mLocalId", "addUploadId", "checkNotDel", "checkQueue", "checkQueueImp", "checkSendComment", "commentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StoryCommentToSend;", "fileToList", "getSceneHashCodeByUploadId", "uploadId", "getSelfName", "isDownloading", "isInSnsObj", "list", "Lcom/tencent/mm/protocal/protobuf/StoryCommentInfo;", "content", "createTime", "isPosting", "listToFile", "releationUploadScene", "uplocalid", "hashCode", "removeDelItem", "removeDelItemImp", "removeDownLoadingS", "removePostId", "removeReleationUploadScene", "uploadid", "removeUploadId", "setSelfName", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.model.e */
public final class C35205e {
    private static final String FILE_NAME = FILE_NAME;
    private static final String TAG = TAG;
    private static final int rSm = rSm;
    private static final String rSn = rSn;
    public static final C35206a rSo = new C35206a();
    private String ecX = "";
    private final String path;
    private cdq rSh;
    private final Vector<Integer> rSi = new Vector();
    private final HashMap<String, Integer> rSj = new HashMap();
    private final Vector<Integer> rSk = new Vector();
    private final HashMap<Integer, Integer> rSl = new HashMap();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr$Companion;", "", "()V", "AD_CMD_TAG", "", "getAD_CMD_TAG", "()Ljava/lang/String;", "EXPIRES", "", "FILE_NAME", "getFILE_NAME", "TAG", "getTAG", "fromAcitonToCommentInfo", "Lcom/tencent/mm/protocal/protobuf/StoryCommentInfo;", "isAdCmd", "", "clientId", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.model.e$a */
    public static final class C35206a {
        private C35206a() {
        }

        public /* synthetic */ C35206a(byte b) {
            this();
        }
    }

    public C35205e(String str) {
        C25052j.m39376p(str, "path");
        AppMethodBeat.m2504i(109020);
        this.path = str;
        if (!cnh()) {
            this.rSh = new cdq();
        }
        this.rSi.clear();
        this.rSj.clear();
        AppMethodBeat.m2505o(109020);
    }

    private final synchronized boolean cnh() {
        boolean z;
        AppMethodBeat.m2504i(109018);
        byte[] e = C5730e.m8632e(this.path, 0, -1);
        if (e == null) {
            AppMethodBeat.m2505o(109018);
            z = false;
        } else {
            try {
                C1331a parseFrom = new cdq().parseFrom(e);
                if (parseFrom == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryAsyncQueue");
                    AppMethodBeat.m2505o(109018);
                    throw c44941v;
                }
                this.rSh = (cdq) parseFrom;
                z = true;
                AppMethodBeat.m2505o(109018);
            } catch (IOException e2) {
                C4990ab.printErrStackTrace(TAG, e2, "", new Object[0]);
                C5730e.deleteFile(this.path);
                AppMethodBeat.m2505o(109018);
                z = false;
            }
        }
        return z;
    }

    /* renamed from: CT */
    public final synchronized boolean mo55851CT(int i) {
        AppMethodBeat.m2504i(109019);
        this.rSi.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(109019);
        return true;
    }

    static {
        AppMethodBeat.m2504i(109021);
        AppMethodBeat.m2505o(109021);
    }
}
