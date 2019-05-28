package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.r;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.dz;
import com.tencent.mm.protocal.protobuf.eb;
import com.tencent.mm.protocal.protobuf.ec;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.p;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map.Entry;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010d\u001a\u00020eJ\b\u0010f\u001a\u0004\u0018\u00010YJ\u0006\u0010g\u001a\u00020eJ\u000e\u0010h\u001a\u00020e2\u0006\u0010i\u001a\u00020jJ\u0018\u0010k\u001a\u00020e2\u0006\u0010l\u001a\u00020\u00062\b\u0010m\u001a\u0004\u0018\u00010\u0004J\u000e\u0010n\u001a\u00020e2\u0006\u0010i\u001a\u00020oJ\u000e\u0010p\u001a\u00020e2\u0006\u0010i\u001a\u00020qJ\u000e\u0010r\u001a\u00020e2\u0006\u0010i\u001a\u00020sJ\u0006\u0010t\u001a\u00020eJ\u000e\u0010u\u001a\u00020e2\u0006\u0010l\u001a\u00020\u0006J\u0006\u0010v\u001a\u00020 J\b\u0010w\u001a\u0004\u0018\u00010\u0004J.\u0010x\u001a\u00020e2\u0006\u0010W\u001a\u00020Y2\u0006\u0010K\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@2\u0006\u00103\u001a\u000204J\u0006\u0010y\u001a\u00020\u001aJ\u0006\u0010z\u001a\u00020\u001aJ\u0006\u0010{\u001a\u00020eJ\u000e\u0010|\u001a\u00020e2\u0006\u0010}\u001a\u00020\u0006J\u0012\u0010~\u001a\u00020e2\b\u0010^\u001a\u0004\u0018\u00010\u0004H\u0016J\u0011\u0010\u001a\u00020e2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\u001a\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001a\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\nR\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\b\"\u0004\b;\u0010\nR\u001a\u0010<\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010\nR\u001a\u0010?\u001a\u00020@X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010\nR\u001c\u0010N\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR\u001c\u0010Q\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\r\"\u0004\bS\u0010\u000fR\u001a\u0010T\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\b\"\u0004\bV\u0010\nR \u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XX.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010^\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\r\"\u0004\b`\u0010\u000fR\u001c\u0010a\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\r\"\u0004\bc\u0010\u000f¨\u0006\u0001"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "", "()V", "TAG", "", "commentOffset", "", "getCommentOffset", "()I", "setCommentOffset", "(I)V", "copyUrl", "getCopyUrl", "()Ljava/lang/String;", "setCopyUrl", "(Ljava/lang/String;)V", "enterId", "getEnterId", "setEnterId", "funcFlag", "getFuncFlag", "setFuncFlag", "idx", "getIdx", "setIdx", "isDoingGetFansComment", "", "isDoingGetMyComment", "itemShowType", "getItemShowType", "setItemShowType", "kV17149", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKV17149", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "setKV17149", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;)V", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "maliciousTitleInfo", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "getMaliciousTitleInfo", "()Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setMaliciousTitleInfo", "(Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;)V", "mid", "", "getMid", "()J", "setMid", "(J)V", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "prompted", "getPrompted", "setPrompted", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setReaderItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "setReport", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;)V", "scene", "getScene", "setScene", "srcDisPlayName", "getSrcDisPlayName", "setSrcDisPlayName", "srcUserName", "getSrcUserName", "setSrcUserName", "subScene", "getSubScene", "setSubScene", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "url", "getUrl", "setUrl", "vid", "getVid", "setVid", "appMsgGet", "", "context", "disMissProgressDlg", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "doAppMsgLike", "actionType", "comment", "doAppMsgLikeComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doCommentExposure", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentExposureReq;", "geAppMsgtExtData", "getAppMsgCommentList", "getKv17149", "getTalker", "init", "isFinished", "isMaliciousTitle", "onDestroy", "setMsgFuncFlag", "flag", "setShareUrl", "showProgressDlg", "wording", "plugin-brandservice_release"})
public final class b {
    final String TAG = "MicroMsg.BizVideoController";
    String cwG = "";
    private p ejZ;
    public int ffZ;
    public int fgc;
    public String fgd = "";
    public WeakReference<BizVideoDetailUI> hiC;
    public int jSW;
    int jVA;
    public String jVB = "";
    public com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e jVC = new com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e();
    public long jVD;
    public int jVE;
    public int jVF = ((int) (System.currentTimeMillis() / 1000));
    public r jVG;
    public com.tencent.mm.af.p jVH;
    public bac jVI;
    public com.tencent.mm.plugin.brandservice.ui.timeline.video.a.d jVJ = new com.tencent.mm.plugin.brandservice.ui.timeline.video.a.d();
    boolean jVK;
    boolean jVL;
    int jVx;
    int jVy;
    String jVz = "";
    public int scene;
    public String url = "";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class d implements com.tencent.mm.ai.w.a {
        public static final d jVP = new d();

        static {
            AppMethodBeat.i(15122);
            AppMethodBeat.o(15122);
        }

        d() {
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            return 0;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class f implements com.tencent.mm.ai.w.a {
        final /* synthetic */ b jVN;

        f(b bVar) {
            this.jVN = bVar;
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            AppMethodBeat.i(15124);
            ab.i(this.jVN.TAG, "appmsg_comment_exposure errType " + i + ", errCode " + i2 + ", errMsg " + str);
            AppMethodBeat.o(15124);
            return 0;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class c implements com.tencent.mm.ai.w.a {
        public static final c jVO = new c();

        static {
            AppMethodBeat.i(15121);
            AppMethodBeat.o(15121);
        }

        c() {
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            return 0;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class e implements com.tencent.mm.ai.w.a {
        public static final e jVQ = new e();

        static {
            AppMethodBeat.i(15123);
            AppMethodBeat.o(15123);
        }

        e() {
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            return 0;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class a implements com.tencent.mm.ai.w.a {
        public static final a jVM = new a();

        static {
            AppMethodBeat.i(15119);
            AppMethodBeat.o(15119);
        }

        a() {
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            return 0;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class b implements com.tencent.mm.ai.w.a {
        final /* synthetic */ b jVN;

        b(b bVar) {
            this.jVN = bVar;
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            AppMethodBeat.i(15120);
            ab.i(this.jVN.TAG, "appmsg_report errType " + i + ", errCode " + i2 + ", errMsg " + str);
            AppMethodBeat.o(15120);
            return 0;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class h implements com.tencent.mm.ai.w.a {
        final /* synthetic */ b jVN;
        final /* synthetic */ int jVS;

        h(b bVar, int i) {
            this.jVN = bVar;
            this.jVS = i;
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            if (this.jVS == 1) {
                this.jVN.jVL = false;
            } else {
                this.jVN.jVK = false;
            }
            return 0;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class i implements OnCancelListener {
        final /* synthetic */ b jVN;

        i(b bVar) {
            this.jVN = bVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(15126);
            try {
                dialogInterface.dismiss();
                AppMethodBeat.o(15126);
            } catch (Exception e) {
                ab.e(this.jVN.TAG, "showProgressDlg onCancel exp: %s ", e.getLocalizedMessage());
                AppMethodBeat.o(15126);
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class g implements com.tencent.mm.ai.w.a {
        public static final g jVR = new g();

        static {
            AppMethodBeat.i(15125);
            AppMethodBeat.o(15125);
        }

        g() {
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
            return 0;
        }
    }

    public b() {
        AppMethodBeat.i(15140);
        AppMethodBeat.o(15140);
    }

    public final com.tencent.mm.af.p aYl() {
        AppMethodBeat.i(15127);
        com.tencent.mm.af.p pVar = this.jVH;
        if (pVar == null) {
            j.avw("readerItem");
        }
        AppMethodBeat.o(15127);
        return pVar;
    }

    public final void Gd(String str) {
        if (str != null) {
            this.url = str;
        }
    }

    public final void aYm() {
        AppMethodBeat.i(15128);
        ej ejVar = new ej();
        ejVar.url = this.url;
        ejVar.fgd = this.fgd;
        ejVar.scene = this.scene;
        ejVar.vFQ = this.jSW;
        ejVar.nettype = com.tencent.mm.af.l.Me();
        if (ejVar.nettype == 100) {
            ejVar.nettype = 0;
        }
        ejVar.session_id = s.getSessionId();
        ejVar.vFP = this.jVF;
        r rVar = this.jVG;
        if (rVar == null) {
            j.avw("msgInfo");
        }
        if (r.ks(rVar.fgc)) {
            ejVar.vGf = 1;
        } else {
            ejVar.vGf = 0;
        }
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(ejVar);
        aVar.b(new ek());
        aVar.qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_get");
        aVar.kU(1179);
        aVar.kV(0);
        aVar.kW(0);
        w.a(aVar.acD(), a.jVM);
        AppMethodBeat.o(15128);
    }

    public final void sB(int i) {
        AppMethodBeat.i(15129);
        ed edVar = new ed();
        edVar.url = this.url;
        if (i == 1) {
            if (this.jVL) {
                AppMethodBeat.o(15129);
                return;
            } else if (this.jVx == -1) {
                ab.i(this.TAG, "no more comment");
                AppMethodBeat.o(15129);
                return;
            } else {
                edVar.offset = this.jVx;
                this.jVL = true;
            }
        } else if (this.jVK) {
            AppMethodBeat.o(15129);
            return;
        } else {
            edVar.offset = this.jVy;
            if (this.jVy == -1) {
                ab.i(this.TAG, "no more my comment");
                AppMethodBeat.o(15129);
                return;
            }
            this.jVK = true;
        }
        edVar.kdC = i;
        edVar.scene = this.scene;
        edVar.vFQ = this.jSW;
        edVar.vFO = this.ffZ;
        edVar.session_id = s.getSessionId();
        edVar.vFP = this.jVF;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(edVar);
        aVar.b(new ee());
        aVar.qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_list");
        aVar.kU(2866);
        aVar.kV(0);
        aVar.kW(0);
        w.a(aVar.acD(), new h(this, i));
        AppMethodBeat.o(15129);
    }

    public final void a(el elVar) {
        AppMethodBeat.i(15130);
        j.p(elVar, "req");
        elVar.scene = this.scene;
        elVar.vFQ = this.jSW;
        elVar.url = this.url;
        elVar.vFO = this.ffZ;
        elVar.session_id = s.getSessionId();
        elVar.vFP = this.jVF;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(elVar);
        aVar.b(new em());
        aVar.qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_like_comment");
        aVar.kU(2759);
        aVar.kV(0);
        aVar.kW(0);
        w.a(aVar.acD(), d.jVP);
        AppMethodBeat.o(15130);
    }

    public final void ao(int i, String str) {
        AppMethodBeat.i(15131);
        en enVar = new en();
        enVar.url = this.url;
        enVar.fBq = System.currentTimeMillis();
        enVar.vGv = str;
        enVar.scene = this.scene;
        enVar.vFQ = this.jSW;
        enVar.kdC = i;
        enVar.vFO = this.ffZ;
        enVar.session_id = s.getSessionId();
        enVar.vFP = this.jVF;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(enVar);
        aVar.b(new eo());
        aVar.qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_like");
        aVar.kU(2691);
        aVar.kV(0);
        aVar.kW(0);
        w.a(aVar.acD(), c.jVO);
        BizVideoDetailUI aYo = aYo();
        Ge(aYo != null ? aYo.getString(R.string.g87) : null);
        AppMethodBeat.o(15131);
    }

    public final void a(ep epVar) {
        AppMethodBeat.i(15132);
        j.p(epVar, "req");
        epVar.scene = this.scene;
        epVar.vFQ = this.jSW;
        epVar.url = this.url;
        com.tencent.mm.af.p pVar = this.jVH;
        if (pVar == null) {
            j.avw("readerItem");
        }
        epVar.title = pVar.title;
        epVar.vGx = System.currentTimeMillis();
        epVar.vFO = this.ffZ;
        epVar.session_id = s.getSessionId();
        epVar.vFP = this.jVF;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(epVar);
        aVar.b(new eq());
        aVar.qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_operate_comment");
        aVar.kU(2617);
        aVar.kV(0);
        aVar.kW(0);
        w.a(aVar.acD(), e.jVQ);
        BizVideoDetailUI aYo = aYo();
        Ge(aYo != null ? aYo.getString(R.string.un) : null);
        AppMethodBeat.o(15132);
    }

    public final void a(dy dyVar) {
        AppMethodBeat.i(15133);
        j.p(dyVar, "req");
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(dyVar);
        aVar.b(new dz());
        aVar.qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
        aVar.kU(1870);
        aVar.kV(0);
        aVar.kW(0);
        w.a(aVar.acD(), new b(this));
        AppMethodBeat.o(15133);
    }

    public final void onDestroy() {
        LinkedList linkedList;
        AppMethodBeat.i(15134);
        aYn();
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e eVar = this.jVC;
        if (eVar.jYB.size() > 0) {
            linkedList = new LinkedList();
            for (Object next : eVar.jYB.entrySet()) {
                j.o(next, "it.next()");
                Object next2 = ((Entry) next2).getValue();
                j.o(next2, "entry.value");
                linkedList.add((to) next2);
            }
            eb ebVar = new eb();
            ebVar.vFN = linkedList;
            b bVar = eVar.jWx;
            if (bVar == null) {
                j.avw("controller");
            }
            j.p(ebVar, "req");
            ebVar.vFP = bVar.jVF;
            ebVar.session_id = s.getSessionId();
            ebVar.vFO = bVar.ffZ;
            ebVar.url = bVar.url;
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.a(ebVar);
            aVar.b(new ec());
            aVar.qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_exposure");
            aVar.kU(2827);
            aVar.kV(0);
            aVar.kW(0);
            w.a(aVar.acD(), new f(bVar));
        }
        dy dyVar = new dy();
        dx dxVar = new dx();
        dxVar.type = 1;
        String str = "scene";
        b bVar2 = eVar.jWx;
        if (bVar2 == null) {
            j.avw("controller");
        }
        String valueOf = String.valueOf(bVar2.scene);
        LinkedList linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e.a(str, valueOf, linkedList2);
        str = DownloadInfo.NETTYPE;
        valueOf = at.gB(ah.getContext());
        linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e.a(str, valueOf, linkedList2);
        valueOf = String.valueOf(eVar.jYC);
        linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e.a("StartTimeMs", valueOf, linkedList2);
        valueOf = String.valueOf(System.currentTimeMillis());
        linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e.a("EndTimeMs", valueOf, linkedList2);
        str = "ItemShowType";
        bVar2 = eVar.jWx;
        if (bVar2 == null) {
            j.avw("controller");
        }
        valueOf = String.valueOf(bVar2.ffZ);
        linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e.a(str, valueOf, linkedList2);
        valueOf = s.getSessionId();
        linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e.a("SessionId", valueOf, linkedList2);
        str = "EnterId";
        bVar2 = eVar.jWx;
        if (bVar2 == null) {
            j.avw("controller");
        }
        valueOf = String.valueOf(bVar2.jVF);
        linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e.a(str, valueOf, linkedList2);
        linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e.a("NativePage", "1", linkedList2);
        str = "#AppMsgUrl#";
        bVar2 = eVar.jWx;
        if (bVar2 == null) {
            j.avw("controller");
        }
        valueOf = bVar2.url;
        linkedList2 = dxVar.vCQ;
        j.o(linkedList2, "reportData.item");
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e.a(str, valueOf, linkedList2);
        dyVar.vFM.add(dxVar);
        b bVar3 = eVar.jWx;
        if (bVar3 == null) {
            j.avw("controller");
        }
        bVar3.a(dyVar);
        linkedList = dxVar.vCQ;
        j.o(linkedList, "reportData.item");
        eVar.b(10945, linkedList);
        AppMethodBeat.o(15134);
    }

    private void Ge(String str) {
        AppMethodBeat.i(15135);
        if (isFinished()) {
            AppMethodBeat.o(15135);
            return;
        }
        aYn();
        if (this.ejZ != null) {
            p pVar = this.ejZ;
            if (pVar == null) {
                j.dWJ();
            }
            if (!pVar.isShowing()) {
                pVar = this.ejZ;
                if (pVar != null) {
                    pVar.show();
                    AppMethodBeat.o(15135);
                    return;
                }
                AppMethodBeat.o(15135);
                return;
            }
        }
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            j.avw("ui");
        }
        this.ejZ = com.tencent.mm.ui.base.h.b((Context) weakReference.get(), str, true, (OnCancelListener) new i(this));
        AppMethodBeat.o(15135);
    }

    public final void aYn() {
        AppMethodBeat.i(15136);
        if (this.ejZ != null) {
            p pVar = this.ejZ;
            Boolean valueOf = pVar != null ? Boolean.valueOf(pVar.isShowing()) : null;
            if (valueOf == null) {
                j.dWJ();
            }
            if (valueOf.booleanValue()) {
                pVar = this.ejZ;
                if (pVar != null) {
                    pVar.dismiss();
                    AppMethodBeat.o(15136);
                    return;
                }
            }
        }
        AppMethodBeat.o(15136);
    }

    public final String HE() {
        AppMethodBeat.i(15137);
        r rVar = this.jVG;
        if (rVar == null) {
            j.avw("msgInfo");
        }
        String HE = rVar.HE();
        AppMethodBeat.o(15137);
        return HE;
    }

    private BizVideoDetailUI aYo() {
        AppMethodBeat.i(15138);
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            j.avw("ui");
        }
        if (weakReference.get() == null) {
            AppMethodBeat.o(15138);
            return null;
        }
        weakReference = this.hiC;
        if (weakReference == null) {
            j.avw("ui");
        }
        Object obj = weakReference.get();
        if (obj == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
            AppMethodBeat.o(15138);
            throw vVar;
        }
        BizVideoDetailUI bizVideoDetailUI = (BizVideoDetailUI) obj;
        AppMethodBeat.o(15138);
        return bizVideoDetailUI;
    }

    private boolean isFinished() {
        AppMethodBeat.i(15139);
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            j.avw("ui");
        }
        if (weakReference.get() != null) {
            weakReference = this.hiC;
            if (weakReference == null) {
                j.avw("ui");
            }
            Object obj = weakReference.get();
            if (obj == null) {
                v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
                AppMethodBeat.o(15139);
                throw vVar;
            } else if (!((BizVideoDetailUI) obj).isFinishing()) {
                AppMethodBeat.o(15139);
                return false;
            }
        }
        AppMethodBeat.o(15139);
        return true;
    }

    public final boolean aYp() {
        return (this.fgc & 4) != 0;
    }
}
