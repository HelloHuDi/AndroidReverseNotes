package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C37436r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C27562d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C38715e;
import com.tencent.p177mm.protocal.protobuf.C15332ec;
import com.tencent.p177mm.protocal.protobuf.C15333ed;
import com.tencent.p177mm.protocal.protobuf.C15334ek;
import com.tencent.p177mm.protocal.protobuf.C15335el;
import com.tencent.p177mm.protocal.protobuf.C23382dx;
import com.tencent.p177mm.protocal.protobuf.C23383dy;
import com.tencent.p177mm.protocal.protobuf.C23384dz;
import com.tencent.p177mm.protocal.protobuf.C30179eb;
import com.tencent.p177mm.protocal.protobuf.C30180ee;
import com.tencent.p177mm.protocal.protobuf.C30227to;
import com.tencent.p177mm.protocal.protobuf.C35914en;
import com.tencent.p177mm.protocal.protobuf.C35915eo;
import com.tencent.p177mm.protocal.protobuf.C40517eq;
import com.tencent.p177mm.protocal.protobuf.C46537ep;
import com.tencent.p177mm.protocal.protobuf.C7535ej;
import com.tencent.p177mm.protocal.protobuf.C7536em;
import com.tencent.p177mm.protocal.protobuf.bac;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map.Entry;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010d\u001a\u00020eJ\b\u0010f\u001a\u0004\u0018\u00010YJ\u0006\u0010g\u001a\u00020eJ\u000e\u0010h\u001a\u00020e2\u0006\u0010i\u001a\u00020jJ\u0018\u0010k\u001a\u00020e2\u0006\u0010l\u001a\u00020\u00062\b\u0010m\u001a\u0004\u0018\u00010\u0004J\u000e\u0010n\u001a\u00020e2\u0006\u0010i\u001a\u00020oJ\u000e\u0010p\u001a\u00020e2\u0006\u0010i\u001a\u00020qJ\u000e\u0010r\u001a\u00020e2\u0006\u0010i\u001a\u00020sJ\u0006\u0010t\u001a\u00020eJ\u000e\u0010u\u001a\u00020e2\u0006\u0010l\u001a\u00020\u0006J\u0006\u0010v\u001a\u00020 J\b\u0010w\u001a\u0004\u0018\u00010\u0004J.\u0010x\u001a\u00020e2\u0006\u0010W\u001a\u00020Y2\u0006\u0010K\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@2\u0006\u00103\u001a\u000204J\u0006\u0010y\u001a\u00020\u001aJ\u0006\u0010z\u001a\u00020\u001aJ\u0006\u0010{\u001a\u00020eJ\u000e\u0010|\u001a\u00020e2\u0006\u0010}\u001a\u00020\u0006J\u0012\u0010~\u001a\u00020e2\b\u0010^\u001a\u0004\u0018\u00010\u0004H\u0016J\u0011\u0010\u001a\u00020e2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001a\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\nR\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\b\"\u0004\b;\u0010\nR\u001a\u0010<\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010\nR\u001a\u0010?\u001a\u00020@X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010\nR\u001c\u0010N\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR\u001c\u0010Q\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR\u001a\u0010T\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\b\"\u0004\bV\u0010\nR \u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XX.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010^\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\r\"\u0004\b`\u0010\u000fR\u001c\u0010a\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\r\"\u0004\bc\u0010\u000f¨\u0006\u0001"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "", "()V", "TAG", "", "commentOffset", "", "getCommentOffset", "()I", "setCommentOffset", "(I)V", "copyUrl", "getCopyUrl", "()Ljava/lang/String;", "setCopyUrl", "(Ljava/lang/String;)V", "enterId", "getEnterId", "setEnterId", "funcFlag", "getFuncFlag", "setFuncFlag", "idx", "getIdx", "setIdx", "isDoingGetFansComment", "", "isDoingGetMyComment", "itemShowType", "getItemShowType", "setItemShowType", "kV17149", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKV17149", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "setKV17149", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;)V", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "maliciousTitleInfo", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "getMaliciousTitleInfo", "()Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setMaliciousTitleInfo", "(Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;)V", "mid", "", "getMid", "()J", "setMid", "(J)V", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "prompted", "getPrompted", "setPrompted", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setReaderItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "setReport", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;)V", "scene", "getScene", "setScene", "srcDisPlayName", "getSrcDisPlayName", "setSrcDisPlayName", "srcUserName", "getSrcUserName", "setSrcUserName", "subScene", "getSubScene", "setSubScene", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "url", "getUrl", "setUrl", "vid", "getVid", "setVid", "appMsgGet", "", "context", "disMissProgressDlg", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "doAppMsgLike", "actionType", "comment", "doAppMsgLikeComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doCommentExposure", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentExposureReq;", "geAppMsgtExtData", "getAppMsgCommentList", "getKv17149", "getTalker", "init", "isFinished", "isMaliciousTitle", "onDestroy", "setMsgFuncFlag", "flag", "setShareUrl", "showProgressDlg", "wording", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b */
public final class C45767b {
    final String TAG = "MicroMsg.BizVideoController";
    String cwG = "";
    private C44275p ejZ;
    public int ffZ;
    public int fgc;
    public String fgd = "";
    public WeakReference<BizVideoDetailUI> hiC;
    public int jSW;
    int jVA;
    public String jVB = "";
    public C38715e jVC = new C38715e();
    public long jVD;
    public int jVE;
    public int jVF = ((int) (System.currentTimeMillis() / 1000));
    public C37436r jVG;
    public C32224p jVH;
    public bac jVI;
    public C27562d jVJ = new C27562d();
    boolean jVK;
    boolean jVL;
    int jVx;
    int jVy;
    String jVz = "";
    public int scene;
    public String url = "";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$d */
    static final class C11266d implements C1224a {
        public static final C11266d jVP = new C11266d();

        static {
            AppMethodBeat.m2504i(15122);
            AppMethodBeat.m2505o(15122);
        }

        C11266d() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            return 0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$f */
    static final class C20111f implements C1224a {
        final /* synthetic */ C45767b jVN;

        C20111f(C45767b c45767b) {
            this.jVN = c45767b;
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(15124);
            C4990ab.m7416i(this.jVN.TAG, "appmsg_comment_exposure errType " + i + ", errCode " + i2 + ", errMsg " + str);
            AppMethodBeat.m2505o(15124);
            return 0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$c */
    static final class C27563c implements C1224a {
        public static final C27563c jVO = new C27563c();

        static {
            AppMethodBeat.m2504i(15121);
            AppMethodBeat.m2505o(15121);
        }

        C27563c() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            return 0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$e */
    static final class C27564e implements C1224a {
        public static final C27564e jVQ = new C27564e();

        static {
            AppMethodBeat.m2504i(15123);
            AppMethodBeat.m2505o(15123);
        }

        C27564e() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            return 0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$a */
    static final class C38716a implements C1224a {
        public static final C38716a jVM = new C38716a();

        static {
            AppMethodBeat.m2504i(15119);
            AppMethodBeat.m2505o(15119);
        }

        C38716a() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            return 0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$b */
    static final class C38717b implements C1224a {
        final /* synthetic */ C45767b jVN;

        C38717b(C45767b c45767b) {
            this.jVN = c45767b;
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(15120);
            C4990ab.m7416i(this.jVN.TAG, "appmsg_report errType " + i + ", errCode " + i2 + ", errMsg " + str);
            AppMethodBeat.m2505o(15120);
            return 0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$h */
    static final class C38718h implements C1224a {
        final /* synthetic */ C45767b jVN;
        final /* synthetic */ int jVS;

        C38718h(C45767b c45767b, int i) {
            this.jVN = c45767b;
            this.jVS = i;
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            if (this.jVS == 1) {
                this.jVN.jVL = false;
            } else {
                this.jVN.jVK = false;
            }
            return 0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$i */
    static final class C42833i implements OnCancelListener {
        final /* synthetic */ C45767b jVN;

        C42833i(C45767b c45767b) {
            this.jVN = c45767b;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(15126);
            try {
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(15126);
            } catch (Exception e) {
                C4990ab.m7413e(this.jVN.TAG, "showProgressDlg onCancel exp: %s ", e.getLocalizedMessage());
                AppMethodBeat.m2505o(15126);
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$g */
    static final class C45766g implements C1224a {
        public static final C45766g jVR = new C45766g();

        static {
            AppMethodBeat.m2504i(15125);
            AppMethodBeat.m2505o(15125);
        }

        C45766g() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            return 0;
        }
    }

    public C45767b() {
        AppMethodBeat.m2504i(15140);
        AppMethodBeat.m2505o(15140);
    }

    public final C32224p aYl() {
        AppMethodBeat.m2504i(15127);
        C32224p c32224p = this.jVH;
        if (c32224p == null) {
            C25052j.avw("readerItem");
        }
        AppMethodBeat.m2505o(15127);
        return c32224p;
    }

    /* renamed from: Gd */
    public final void mo73551Gd(String str) {
        if (str != null) {
            this.url = str;
        }
    }

    public final void aYm() {
        AppMethodBeat.m2504i(15128);
        C7535ej c7535ej = new C7535ej();
        c7535ej.url = this.url;
        c7535ej.fgd = this.fgd;
        c7535ej.scene = this.scene;
        c7535ej.vFQ = this.jSW;
        c7535ej.nettype = C1192l.m2616Me();
        if (c7535ej.nettype == 100) {
            c7535ej.nettype = 0;
        }
        c7535ej.session_id = C30309s.getSessionId();
        c7535ej.vFP = this.jVF;
        C37436r c37436r = this.jVG;
        if (c37436r == null) {
            C25052j.avw("msgInfo");
        }
        if (C37436r.m63099ks(c37436r.fgc)) {
            c7535ej.vGf = 1;
        } else {
            c7535ej.vGf = 0;
        }
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(c7535ej);
        c1196a.mo4446b(new C15334ek());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_get");
        c1196a.mo4447kU(1179);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C1226w.m2654a(c1196a.acD(), C38716a.jVM);
        AppMethodBeat.m2505o(15128);
    }

    /* renamed from: sB */
    public final void mo73562sB(int i) {
        AppMethodBeat.m2504i(15129);
        C15333ed c15333ed = new C15333ed();
        c15333ed.url = this.url;
        if (i == 1) {
            if (this.jVL) {
                AppMethodBeat.m2505o(15129);
                return;
            } else if (this.jVx == -1) {
                C4990ab.m7416i(this.TAG, "no more comment");
                AppMethodBeat.m2505o(15129);
                return;
            } else {
                c15333ed.offset = this.jVx;
                this.jVL = true;
            }
        } else if (this.jVK) {
            AppMethodBeat.m2505o(15129);
            return;
        } else {
            c15333ed.offset = this.jVy;
            if (this.jVy == -1) {
                C4990ab.m7416i(this.TAG, "no more my comment");
                AppMethodBeat.m2505o(15129);
                return;
            }
            this.jVK = true;
        }
        c15333ed.kdC = i;
        c15333ed.scene = this.scene;
        c15333ed.vFQ = this.jSW;
        c15333ed.vFO = this.ffZ;
        c15333ed.session_id = C30309s.getSessionId();
        c15333ed.vFP = this.jVF;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(c15333ed);
        c1196a.mo4446b(new C30180ee());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
        c1196a.mo4447kU(2866);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C1226w.m2654a(c1196a.acD(), new C38718h(this, i));
        AppMethodBeat.m2505o(15129);
    }

    /* renamed from: a */
    public final void mo73554a(C15335el c15335el) {
        AppMethodBeat.m2504i(15130);
        C25052j.m39376p(c15335el, "req");
        c15335el.scene = this.scene;
        c15335el.vFQ = this.jSW;
        c15335el.url = this.url;
        c15335el.vFO = this.ffZ;
        c15335el.session_id = C30309s.getSessionId();
        c15335el.vFP = this.jVF;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(c15335el);
        c1196a.mo4446b(new C7536em());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment");
        c1196a.mo4447kU(2759);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C1226w.m2654a(c1196a.acD(), C11266d.jVP);
        AppMethodBeat.m2505o(15130);
    }

    /* renamed from: ao */
    public final void mo73560ao(int i, String str) {
        AppMethodBeat.m2504i(15131);
        C35914en c35914en = new C35914en();
        c35914en.url = this.url;
        c35914en.fBq = System.currentTimeMillis();
        c35914en.vGv = str;
        c35914en.scene = this.scene;
        c35914en.vFQ = this.jSW;
        c35914en.kdC = i;
        c35914en.vFO = this.ffZ;
        c35914en.session_id = C30309s.getSessionId();
        c35914en.vFP = this.jVF;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(c35914en);
        c1196a.mo4446b(new C35915eo());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_like");
        c1196a.mo4447kU(2691);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C1226w.m2654a(c1196a.acD(), C27563c.jVO);
        BizVideoDetailUI aYo = aYo();
        m84599Ge(aYo != null ? aYo.getString(C25738R.string.g87) : null);
        AppMethodBeat.m2505o(15131);
    }

    /* renamed from: a */
    public final void mo73555a(C46537ep c46537ep) {
        AppMethodBeat.m2504i(15132);
        C25052j.m39376p(c46537ep, "req");
        c46537ep.scene = this.scene;
        c46537ep.vFQ = this.jSW;
        c46537ep.url = this.url;
        C32224p c32224p = this.jVH;
        if (c32224p == null) {
            C25052j.avw("readerItem");
        }
        c46537ep.title = c32224p.title;
        c46537ep.vGx = System.currentTimeMillis();
        c46537ep.vFO = this.ffZ;
        c46537ep.session_id = C30309s.getSessionId();
        c46537ep.vFP = this.jVF;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(c46537ep);
        c1196a.mo4446b(new C40517eq());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
        c1196a.mo4447kU(2617);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C1226w.m2654a(c1196a.acD(), C27564e.jVQ);
        BizVideoDetailUI aYo = aYo();
        m84599Ge(aYo != null ? aYo.getString(C25738R.string.f9260un) : null);
        AppMethodBeat.m2505o(15132);
    }

    /* renamed from: a */
    public final void mo73553a(C23383dy c23383dy) {
        AppMethodBeat.m2504i(15133);
        C25052j.m39376p(c23383dy, "req");
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(c23383dy);
        c1196a.mo4446b(new C23384dz());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
        c1196a.mo4447kU(1870);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C1226w.m2654a(c1196a.acD(), new C38717b(this));
        AppMethodBeat.m2505o(15133);
    }

    public final void onDestroy() {
        LinkedList linkedList;
        AppMethodBeat.m2504i(15134);
        aYn();
        C38715e c38715e = this.jVC;
        if (c38715e.jYB.size() > 0) {
            linkedList = new LinkedList();
            for (Object next : c38715e.jYB.entrySet()) {
                C25052j.m39375o(next, "it.next()");
                Object next2 = ((Entry) next2).getValue();
                C25052j.m39375o(next2, "entry.value");
                linkedList.add((C30227to) next2);
            }
            C30179eb c30179eb = new C30179eb();
            c30179eb.vFN = linkedList;
            C45767b c45767b = c38715e.jWx;
            if (c45767b == null) {
                C25052j.avw("controller");
            }
            C25052j.m39376p(c30179eb, "req");
            c30179eb.vFP = c45767b.jVF;
            c30179eb.session_id = C30309s.getSessionId();
            c30179eb.vFO = c45767b.ffZ;
            c30179eb.url = c45767b.url;
            C1196a c1196a = new C1196a();
            c1196a.mo4444a(c30179eb);
            c1196a.mo4446b(new C15332ec());
            c1196a.mo4450qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_exposure");
            c1196a.mo4447kU(2827);
            c1196a.mo4448kV(0);
            c1196a.mo4449kW(0);
            C1226w.m2654a(c1196a.acD(), new C20111f(c45767b));
        }
        C23383dy c23383dy = new C23383dy();
        C23382dx c23382dx = new C23382dx();
        c23382dx.type = 1;
        String str = "scene";
        C45767b c45767b2 = c38715e.jWx;
        if (c45767b2 == null) {
            C25052j.avw("controller");
        }
        String valueOf = String.valueOf(c45767b2.scene);
        LinkedList linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        C38715e.m65664a(str, valueOf, linkedList2);
        str = DownloadInfo.NETTYPE;
        valueOf = C5023at.m7471gB(C4996ah.getContext());
        linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        C38715e.m65664a(str, valueOf, linkedList2);
        valueOf = String.valueOf(c38715e.jYC);
        linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        C38715e.m65664a("StartTimeMs", valueOf, linkedList2);
        valueOf = String.valueOf(System.currentTimeMillis());
        linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        C38715e.m65664a("EndTimeMs", valueOf, linkedList2);
        str = "ItemShowType";
        c45767b2 = c38715e.jWx;
        if (c45767b2 == null) {
            C25052j.avw("controller");
        }
        valueOf = String.valueOf(c45767b2.ffZ);
        linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        C38715e.m65664a(str, valueOf, linkedList2);
        valueOf = C30309s.getSessionId();
        linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        C38715e.m65664a("SessionId", valueOf, linkedList2);
        str = "EnterId";
        c45767b2 = c38715e.jWx;
        if (c45767b2 == null) {
            C25052j.avw("controller");
        }
        valueOf = String.valueOf(c45767b2.jVF);
        linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        C38715e.m65664a(str, valueOf, linkedList2);
        linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        C38715e.m65664a("NativePage", "1", linkedList2);
        str = "#AppMsgUrl#";
        c45767b2 = c38715e.jWx;
        if (c45767b2 == null) {
            C25052j.avw("controller");
        }
        valueOf = c45767b2.url;
        linkedList2 = c23382dx.vCQ;
        C25052j.m39375o(linkedList2, "reportData.item");
        C38715e.m65664a(str, valueOf, linkedList2);
        c23383dy.vFM.add(c23382dx);
        C45767b c45767b3 = c38715e.jWx;
        if (c45767b3 == null) {
            C25052j.avw("controller");
        }
        c45767b3.mo73553a(c23383dy);
        linkedList = c23382dx.vCQ;
        C25052j.m39375o(linkedList, "reportData.item");
        c38715e.mo61572b(10945, linkedList);
        AppMethodBeat.m2505o(15134);
    }

    /* renamed from: Ge */
    private void m84599Ge(String str) {
        AppMethodBeat.m2504i(15135);
        if (isFinished()) {
            AppMethodBeat.m2505o(15135);
            return;
        }
        aYn();
        if (this.ejZ != null) {
            C44275p c44275p = this.ejZ;
            if (c44275p == null) {
                C25052j.dWJ();
            }
            if (!c44275p.isShowing()) {
                c44275p = this.ejZ;
                if (c44275p != null) {
                    c44275p.show();
                    AppMethodBeat.m2505o(15135);
                    return;
                }
                AppMethodBeat.m2505o(15135);
                return;
            }
        }
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            C25052j.avw("ui");
        }
        this.ejZ = C30379h.m48458b((Context) weakReference.get(), str, true, (OnCancelListener) new C42833i(this));
        AppMethodBeat.m2505o(15135);
    }

    public final void aYn() {
        AppMethodBeat.m2504i(15136);
        if (this.ejZ != null) {
            C44275p c44275p = this.ejZ;
            Boolean valueOf = c44275p != null ? Boolean.valueOf(c44275p.isShowing()) : null;
            if (valueOf == null) {
                C25052j.dWJ();
            }
            if (valueOf.booleanValue()) {
                c44275p = this.ejZ;
                if (c44275p != null) {
                    c44275p.dismiss();
                    AppMethodBeat.m2505o(15136);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(15136);
    }

    /* renamed from: HE */
    public final String mo73552HE() {
        AppMethodBeat.m2504i(15137);
        C37436r c37436r = this.jVG;
        if (c37436r == null) {
            C25052j.avw("msgInfo");
        }
        String HE = c37436r.mo60325HE();
        AppMethodBeat.m2505o(15137);
        return HE;
    }

    private BizVideoDetailUI aYo() {
        AppMethodBeat.m2504i(15138);
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            C25052j.avw("ui");
        }
        if (weakReference.get() == null) {
            AppMethodBeat.m2505o(15138);
            return null;
        }
        weakReference = this.hiC;
        if (weakReference == null) {
            C25052j.avw("ui");
        }
        Object obj = weakReference.get();
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
            AppMethodBeat.m2505o(15138);
            throw c44941v;
        }
        BizVideoDetailUI bizVideoDetailUI = (BizVideoDetailUI) obj;
        AppMethodBeat.m2505o(15138);
        return bizVideoDetailUI;
    }

    private boolean isFinished() {
        AppMethodBeat.m2504i(15139);
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            C25052j.avw("ui");
        }
        if (weakReference.get() != null) {
            weakReference = this.hiC;
            if (weakReference == null) {
                C25052j.avw("ui");
            }
            Object obj = weakReference.get();
            if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
                AppMethodBeat.m2505o(15139);
                throw c44941v;
            } else if (!((BizVideoDetailUI) obj).isFinishing()) {
                AppMethodBeat.m2505o(15139);
                return false;
            }
        }
        AppMethodBeat.m2505o(15139);
        return true;
    }

    public final boolean aYp() {
        return (this.fgc & 4) != 0;
    }
}
