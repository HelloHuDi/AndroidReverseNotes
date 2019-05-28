package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.x;
import a.y;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.w;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.protocal.protobuf.hz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.bl;
import kotlinx.coroutines.bm;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000Ù\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a*\u0001'\bÆ\u0002\u0018\u00002\u00020\u0001:\u0010|}~\u0001\u0001\u0001\u0001\u0001\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010;\"\u00020\u0001H\u0007¢\u0006\u0002\u0010<J>\u0010=\u001a\u00020\u001a2\u0018\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?012\u0006\u00109\u001a\u00020\b2\b\b\u0002\u0010@\u001a\u00020\b2\b\b\u0002\u0010A\u001a\u00020\bH\u0002J\u0010\u0010B\u001a\u00020#2\u0006\u00109\u001a\u00020\bH\u0007J\b\u0010C\u001a\u00020\u001aH\u0002J\u0016\u0010D\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\b2\u0006\u0010E\u001a\u00020\rJ\b\u0010F\u001a\u00020\u001aH\u0002JF\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u00012\u0006\u00107\u001a\u00020\r2\u0006\u0010I\u001a\u00020J2&\b\u0002\u0010K\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010M\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020\u001a0LJ\u0018\u0010G\u001a\u0004\u0018\u00010O2\u0006\u00107\u001a\u00020\r2\u0006\u0010P\u001a\u00020\bJ:\u0010Q\u001a\u00020R2\u0018\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?0S2\u0006\u00109\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0002J\u0010\u0010T\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0002J\b\u0010U\u001a\u00020\u001aH\u0002J\u0010\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\bH\u0002J$\u0010X\u001a\u00020\u001a2\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r01012\u0006\u00109\u001a\u00020\bH\u0007J$\u0010Z\u001a\u00020\u001a2\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0;012\u0006\u00109\u001a\u00020\bH\u0007J\b\u0010[\u001a\u00020\u001aH\u0007J\u0018\u0010\\\u001a\u00020\u001a2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\bH\u0007J\b\u0010]\u001a\u00020\u0004H\u0002J\b\u0010^\u001a\u00020\u001aH\u0002J\u0010\u0010_\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\rH\u0007JX\u0010`\u001a\u00020\u001a2\u0018\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?012\u0006\u00109\u001a\u00020\b2\b\b\u0002\u0010@\u001a\u00020\b2\b\b\u0002\u0010A\u001a\u00020\b2\u0018\u0010K\u001a\u0014\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\u001a0aH\u0002J\u0010\u0010c\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\bH\u0007J3\u0010d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00162!\u0010K\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0015H\u0002J*\u0010e\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00162\u0018\u0010K\u001a\u0014\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\u001a0aH\u0002J \u0010f\u001a\u00020\u001a2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0002J\u0010\u0010f\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\bH\u0002J0\u0010g\u001a\u00020#2\u0006\u0010H\u001a\u00020h2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010i\u001a\u00020j2\u0006\u0010I\u001a\u00020J2\u0006\u0010k\u001a\u00020lH\u0002JN\u0010g\u001a\u00020#2\u0006\u0010H\u001a\u00020h2\u0006\u0010m\u001a\u00020\r2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010n\u001a\u00020\b2\b\b\u0002\u0010i\u001a\u00020j2\b\b\u0002\u0010o\u001a\u00020\b2\b\b\u0002\u0010k\u001a\u00020lH\u0007J(\u0010p\u001a\u00020\u001a2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\b2\u0006\u0010q\u001a\u00020\r2\u0006\u00107\u001a\u00020\rH\u0007J\u0018\u0010p\u001a\u00020\u001a2\u0006\u0010q\u001a\u00020\r2\u0006\u00107\u001a\u00020\rH\u0007J\u0018\u0010r\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?H\u0002J\u0018\u0010s\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?H\u0002J;\u0010t\u001a\u0002Hu\"\u000e\b\u0000\u0010v*\b\u0012\u0004\u0012\u0002Hu01\"\b\b\u0001\u0010u*\u00020\u0001*\u0002Hv2\u0006\u0010w\u001a\u00020\b2\u0006\u0010x\u001a\u0002HuH\u0002¢\u0006\u0002\u0010yJ\f\u0010z\u001a\u00020\b*\u00020\bH\u0002J\f\u0010{\u001a\u00020\b*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011RH\u0010\u0012\u001a/\u0012\u0004\u0012\u00020\r\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u00150\u00140\u00138FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#`$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R!\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\r0+j\b\u0012\u0004\u0012\u00020\r`,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010100X\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u00103R\u000e\u00104\u001a\u00020#XD¢\u0006\u0002\n\u0000¨\u0006\u0001"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic;", "", "()V", "DEFAULT_PROCESS", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$Process;", "DELAY_TIME", "", "PROCESS_DEFAULT", "", "PROCESS_MM", "PROCESS_TOOLS", "PROCESS_TOOLSMP", "TAG", "", "caches", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "getCaches", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "cgiCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "getCgiCallbackList", "()Ljava/util/concurrent/ConcurrentHashMap;", "cgiCallbackList$delegate", "Lkotlin/Lazy;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloadOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isRunning", "keys", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1;", "lastPreloadId", "preloadLimiter", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPreloadLimiter", "()Ljava/util/HashSet;", "preloadUrl", "Ljava/util/Queue;", "", "sProcess", "Ljava/lang/Integer;", "stopPreload", "addToPreload", "id", "url", "itemShowType", "openScene", "params", "", "(JLjava/lang/String;II[Ljava/lang/Object;)V", "batchSyncAppMsgContext", "reqList", "Landroid/support/v4/util/Pair;", "strip", "stripType", "canPreloadIn", "checkReportIfNeed", "checkTmplVer", "netType", "clear", "getAppMsgContext", "context", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "callback", "Lkotlin/Function3;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "getBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "", "getTmplVersion", "initDefaultProcess", "obtainTmplType", "bizTimeLineType", "preloadByIdAndUrls", "items", "preloadByInfoIdAndBuffer", "preloadNextWebView", "preloadWebview", "process", "report", "reportWithRetry", "requestAppMsg", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "run", "runCGI", "runCGICallback", "runInner", "startPreloadWebView", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "rawUrl", "subScene", "openType", "updateWebview", "contentId", "getTmplType", "getUrl", "safeGet", "C", "T", "index", "default", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "toPreloadScene", "toReportScene", "AppMsgContextCache", "IPCInvoke_CheckReport", "IPCInvoke_CheckTmplVer", "IPCInvoke_PreloadWebview", "IPCInvoke_RUN_CGI", "IPCInvoke_Report", "IPCInvoke_UpdateWebview", "MountableCGIResult", "PreloadSession", "Process", "plugin-brandservice_release"})
public final class PreloadLogic {
    private static final String TAG = TAG;
    private static final AtomicBoolean cnu = new AtomicBoolean(false);
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(PreloadLogic.class), "cgiCallbackList", "getCgiCallbackList()Ljava/util/concurrent/ConcurrentHashMap;"))};
    private static final HashSet<String> jKh = new HashSet();
    private static i jSE = i.ToolMP;
    private static final AtomicBoolean jSF = new AtomicBoolean(false);
    private static final int jSG = 0;
    private static final int jSH = 1;
    private static final int jSI = 2;
    private static final int jSJ = jSG;
    private static Integer jSK;
    private static final o jSL = new o();
    private static final HashMap<Integer, Boolean> jSM = new HashMap();
    private static final a jSN = new a();
    private static final a.f jSO = a.i.g(l.jTn);
    private static long jSP;
    private static Queue<List<Object>> jSQ = new LinkedList();
    private static final boolean jSR = false;
    public static final PreloadLogic jSS = new PreloadLogic();

    @a.c.b.a.d(c = "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$addToPreload$1", dWy = {898, 906}, f = "PreloadLogic.kt", m = "invokeSuspend")
    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class j extends a.c.b.a.g implements a.f.a.m<ac, a.c.c<? super y>, Object> {
        final /* synthetic */ long jKi;
        final /* synthetic */ String jKj;
        final /* synthetic */ int jKk;
        final /* synthetic */ int jKl;
        private ac jTk;
        final /* synthetic */ Object[] jTl;
        int label;

        j(long j, String str, int i, int i2, Object[] objArr, a.c.c cVar) {
            this.jKi = j;
            this.jKj = str;
            this.jKk = i;
            this.jKl = i2;
            this.jTl = objArr;
            super(cVar);
        }

        public final a.c.c<y> a(Object obj, a.c.c<?> cVar) {
            AppMethodBeat.i(14883);
            a.f.b.j.p(cVar, "completion");
            j jVar = new j(this.jKi, this.jKj, this.jKk, this.jKl, this.jTl, cVar);
            jVar.jTk = (ac) obj;
            AppMethodBeat.o(14883);
            return jVar;
        }

        public final Object m(Object obj, Object obj2) {
            AppMethodBeat.i(14884);
            Object bO = ((j) a(obj, (a.c.c) obj2)).bO(y.AUy);
            AppMethodBeat.o(14884);
            return bO;
        }

        /* JADX WARNING: Missing block: B:67:0x0198, code skipped:
            r0 = a.a.t.l(r1);
            r1 = new java.util.ArrayList();
            r3 = r0.iterator();
     */
        /* JADX WARNING: Missing block: B:69:0x01b0, code skipped:
            if (r3.hasNext() == false) goto L_0x01ce;
     */
        /* JADX WARNING: Missing block: B:70:0x01b2, code skipped:
            r2 = r3.next();
     */
        /* JADX WARNING: Missing block: B:71:0x01c0, code skipped:
            if ((((java.util.List) r2).get(0) instanceof java.lang.String) == false) goto L_0x01ac;
     */
        /* JADX WARNING: Missing block: B:72:0x01c2, code skipped:
            r1.add(r2);
     */
        /* JADX WARNING: Missing block: B:75:0x01ce, code skipped:
            r1 = (java.util.List) r1;
            r3 = new java.util.HashSet();
            r2 = new java.util.ArrayList();
            r4 = r1.iterator();
     */
        /* JADX WARNING: Missing block: B:77:0x01e4, code skipped:
            if (r4.hasNext() == false) goto L_0x0212;
     */
        /* JADX WARNING: Missing block: B:78:0x01e6, code skipped:
            r1 = r4.next();
            r0 = ((java.util.List) r1).get(0);
     */
        /* JADX WARNING: Missing block: B:79:0x01f2, code skipped:
            if (r0 != null) goto L_0x0202;
     */
        /* JADX WARNING: Missing block: B:80:0x01f4, code skipped:
            r0 = new a.v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.o(14882);
     */
        /* JADX WARNING: Missing block: B:81:0x0201, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:83:0x020c, code skipped:
            if (r3.add(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.FJ((java.lang.String) r0)) == false) goto L_0x01e0;
     */
        /* JADX WARNING: Missing block: B:84:0x020e, code skipped:
            r2.add(r1);
     */
        /* JADX WARNING: Missing block: B:85:0x0212, code skipped:
            r0 = r2;
     */
        /* JADX WARNING: Missing block: B:86:0x0219, code skipped:
            if (r0.isEmpty() != false) goto L_0x0434;
     */
        /* JADX WARNING: Missing block: B:87:0x021b, code skipped:
            r1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
            r3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.sq(r10.jKl);
     */
        /* JADX WARNING: Missing block: B:88:0x0223, code skipped:
            if (r3 == 0) goto L_0x030c;
     */
        /* JADX WARNING: Missing block: B:89:0x0225, code skipped:
            r4 = r0.iterator();
     */
        /* JADX WARNING: Missing block: B:91:0x0230, code skipped:
            if (r4.hasNext() == false) goto L_0x030c;
     */
        /* JADX WARNING: Missing block: B:92:0x0232, code skipped:
            r1 = (java.util.List) r4.next();
            r5 = com.tencent.mm.plugin.report.service.h.pYm;
            r7 = new java.lang.Object[11];
            r7[0] = java.lang.Integer.valueOf(r3);
            r8 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
            r7[1] = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.a(r1, 3, (java.lang.Object) "");
            r2 = r1.get(0);
     */
        /* JADX WARNING: Missing block: B:93:0x025a, code skipped:
            if (r2 != null) goto L_0x026a;
     */
        /* JADX WARNING: Missing block: B:94:0x025c, code skipped:
            r0 = new a.v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.o(14882);
     */
        /* JADX WARNING: Missing block: B:95:0x0269, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:96:0x026a, code skipped:
            r7[2] = com.tencent.mm.compatible.util.q.encode((java.lang.String) r2);
            r8 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
            r7[3] = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.a(r1, 4, (java.lang.Object) "");
            r8 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
            r7[4] = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.a(r1, 5, (java.lang.Object) "");
            r7[5] = java.lang.Integer.valueOf(2);
            r7[6] = r1.get(1);
            r7[7] = "";
            r7[8] = "";
            r7[9] = "";
            r2 = r1.get(1);
     */
        /* JADX WARNING: Missing block: B:97:0x02b7, code skipped:
            if (r2 != null) goto L_0x02c7;
     */
        /* JADX WARNING: Missing block: B:98:0x02b9, code skipped:
            r0 = new a.v("null cannot be cast to non-null type kotlin.Int");
            com.tencent.matrix.trace.core.AppMethodBeat.o(14882);
     */
        /* JADX WARNING: Missing block: B:99:0x02c6, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:101:0x02ce, code skipped:
            if (((java.lang.Integer) r2).intValue() != -1) goto L_0x0308;
     */
        /* JADX WARNING: Missing block: B:102:0x02d0, code skipped:
            r1 = r1.get(0);
     */
        /* JADX WARNING: Missing block: B:103:0x02d5, code skipped:
            if (r1 != null) goto L_0x02e5;
     */
        /* JADX WARNING: Missing block: B:104:0x02d7, code skipped:
            r0 = new a.v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.o(14882);
     */
        /* JADX WARNING: Missing block: B:105:0x02e4, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:106:0x02e5, code skipped:
            r1 = (java.lang.String) r1;
     */
        /* JADX WARNING: Missing block: B:107:0x02e7, code skipped:
            if (r1 == null) goto L_0x0306;
     */
        /* JADX WARNING: Missing block: B:108:0x02e9, code skipped:
            r1 = java.lang.Boolean.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.FW(r1));
     */
        /* JADX WARNING: Missing block: B:110:0x02f5, code skipped:
            if (r1.booleanValue() == false) goto L_0x0308;
     */
        /* JADX WARNING: Missing block: B:111:0x02f7, code skipped:
            r1 = 1;
     */
        /* JADX WARNING: Missing block: B:112:0x02f8, code skipped:
            if (r1 == null) goto L_0x030a;
     */
        /* JADX WARNING: Missing block: B:113:0x02fa, code skipped:
            r1 = 1;
     */
        /* JADX WARNING: Missing block: B:114:0x02fb, code skipped:
            r7[10] = java.lang.Integer.valueOf(r1);
            r5.e(16468, r7);
     */
        /* JADX WARNING: Missing block: B:115:0x0306, code skipped:
            r1 = null;
     */
        /* JADX WARNING: Missing block: B:116:0x0308, code skipped:
            r1 = null;
     */
        /* JADX WARNING: Missing block: B:117:0x030a, code skipped:
            r1 = 0;
     */
        /* JADX WARNING: Missing block: B:118:0x030c, code skipped:
            r1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
     */
        /* JADX WARNING: Missing block: B:119:0x0318, code skipped:
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.rW(com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.sr(r10.jKl)) == false) goto L_0x0434;
     */
        /* JADX WARNING: Missing block: B:120:0x031a, code skipped:
            r3 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.sk(r10.jKl);
            r1 = new java.util.ArrayList();
            r4 = r0.iterator();
     */
        /* JADX WARNING: Missing block: B:122:0x0331, code skipped:
            if (r4.hasNext() == false) goto L_0x0360;
     */
        /* JADX WARNING: Missing block: B:123:0x0333, code skipped:
            r2 = r4.next();
            r0 = ((java.util.List) r2).get(0);
     */
        /* JADX WARNING: Missing block: B:124:0x033f, code skipped:
            if (r0 != null) goto L_0x034f;
     */
        /* JADX WARNING: Missing block: B:125:0x0341, code skipped:
            r0 = new a.v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.o(14882);
     */
        /* JADX WARNING: Missing block: B:126:0x034e, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:128:0x0355, code skipped:
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.FW((java.lang.String) r0) != false) goto L_0x035e;
     */
        /* JADX WARNING: Missing block: B:129:0x0357, code skipped:
            r0 = 1;
     */
        /* JADX WARNING: Missing block: B:130:0x0358, code skipped:
            if (r0 != null) goto L_0x032d;
     */
        /* JADX WARNING: Missing block: B:131:0x035a, code skipped:
            r1.add(r2);
     */
        /* JADX WARNING: Missing block: B:132:0x035e, code skipped:
            r0 = null;
     */
        /* JADX WARNING: Missing block: B:133:0x0360, code skipped:
            r1 = (java.util.List) r1;
            r0 = new java.util.ArrayList(a.a.m.d(r1));
            r4 = r1.iterator();
     */
        /* JADX WARNING: Missing block: B:135:0x0377, code skipped:
            if (r4.hasNext() == false) goto L_0x03c5;
     */
        /* JADX WARNING: Missing block: B:136:0x0379, code skipped:
            r2 = (java.util.List) r4.next();
            r1 = r2.get(0);
     */
        /* JADX WARNING: Missing block: B:137:0x0387, code skipped:
            if (r1 != null) goto L_0x0397;
     */
        /* JADX WARNING: Missing block: B:138:0x0389, code skipped:
            r0 = new a.v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.o(14882);
     */
        /* JADX WARNING: Missing block: B:139:0x0396, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:140:0x0397, code skipped:
            r1 = (java.lang.String) r1;
            r6 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
            r2 = r2.get(1);
     */
        /* JADX WARNING: Missing block: B:141:0x03a0, code skipped:
            if (r2 != null) goto L_0x03b0;
     */
        /* JADX WARNING: Missing block: B:142:0x03a2, code skipped:
            r0 = new a.v("null cannot be cast to non-null type kotlin.Int");
            com.tencent.matrix.trace.core.AppMethodBeat.o(14882);
     */
        /* JADX WARNING: Missing block: B:143:0x03af, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:144:0x03b0, code skipped:
            r0.add(new android.support.v4.f.j(r1, java.lang.Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.sn(((java.lang.Integer) r2).intValue()))));
     */
        /* JADX WARNING: Missing block: B:145:0x03c5, code skipped:
            r1 = new java.util.ArrayList();
            r4 = ((java.util.List) r0).iterator();
     */
        /* JADX WARNING: Missing block: B:147:0x03d8, code skipped:
            if (r4.hasNext() == false) goto L_0x040e;
     */
        /* JADX WARNING: Missing block: B:148:0x03da, code skipped:
            r2 = r4.next();
            r0 = (android.support.v4.f.j) r2;
            r5 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
     */
        /* JADX WARNING: Missing block: B:149:0x03eb, code skipped:
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.FC(com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.c(r0)) == false) goto L_0x0405;
     */
        /* JADX WARNING: Missing block: B:150:0x03ed, code skipped:
            r5 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
            r5 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.aXp();
            r6 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
            r6 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.c(r0);
            r7 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
     */
        /* JADX WARNING: Missing block: B:151:0x0403, code skipped:
            if (r5.bK(r6, com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.d(r0)) == false) goto L_0x040c;
     */
        /* JADX WARNING: Missing block: B:152:0x0405, code skipped:
            r0 = 1;
     */
        /* JADX WARNING: Missing block: B:153:0x0406, code skipped:
            if (r0 != null) goto L_0x03d4;
     */
        /* JADX WARNING: Missing block: B:154:0x0408, code skipped:
            r1.add(r2);
     */
        /* JADX WARNING: Missing block: B:155:0x040c, code skipped:
            r0 = null;
     */
        /* JADX WARNING: Missing block: B:156:0x040e, code skipped:
            r1 = (java.util.List) r1;
            r2 = java.lang.Math.max(r1.size() - r3, 0);
            r1 = a.a.t.a((java.lang.Iterable) r1, r3);
     */
        /* JADX WARNING: Missing block: B:157:0x0427, code skipped:
            if (r1.isEmpty() != false) goto L_0x043d;
     */
        /* JADX WARNING: Missing block: B:158:0x0429, code skipped:
            r0 = 1;
     */
        /* JADX WARNING: Missing block: B:159:0x042a, code skipped:
            if (r0 == null) goto L_0x0434;
     */
        /* JADX WARNING: Missing block: B:160:0x042c, code skipped:
            r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.jSS;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.a(r1, r10.jKl, r2, 2);
     */
        /* JADX WARNING: Missing block: B:161:0x0434, code skipped:
            r0 = a.y.AUy;
            com.tencent.matrix.trace.core.AppMethodBeat.o(14882);
     */
        /* JADX WARNING: Missing block: B:162:0x043d, code skipped:
            r0 = null;
     */
        /* JADX WARNING: Missing block: B:192:?, code skipped:
            return r0;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final Object bO(Object obj) {
            PreloadLogic preloadLogic;
            Object obj2;
            AppMethodBeat.i(14882);
            y yVar = a.c.a.a.COROUTINE_SUSPENDED;
            Throwable th;
            switch (this.label) {
                case 0:
                    if (obj instanceof a.p.b) {
                        th = ((a.p.b) obj).AUq;
                        AppMethodBeat.o(14882);
                        throw th;
                    }
                    y yVar2;
                    preloadLogic = PreloadLogic.jSS;
                    synchronized (PreloadLogic.jSQ) {
                        try {
                            preloadLogic = PreloadLogic.jSS;
                            PreloadLogic.jSP = this.jKi;
                            preloadLogic = PreloadLogic.jSS;
                            Queue aXv = PreloadLogic.jSQ;
                            x xVar = new x(4);
                            xVar.add(this.jKj);
                            xVar.add(Integer.valueOf(this.jKk));
                            xVar.add(Integer.valueOf(this.jKl));
                            xVar.m15do(this.jTl);
                            Boolean.valueOf(aXv.add(a.a.l.U(xVar.toArray(new Object[xVar.ckx.size()]))));
                        } finally {
                            AppMethodBeat.o(14882);
                        }
                    }
                    this.label = 1;
                    if (1000 <= 0) {
                        yVar2 = y.AUy;
                    } else {
                        kotlinx.coroutines.j jVar = new kotlinx.coroutines.j(a.c.a.c.c(this));
                        bc bcVar = (bc) jVar.BPv.dWv().get(bc.BQx);
                        if ((jVar.BPu == null ? 1 : null) == null) {
                            th = new IllegalStateException("Check failed.".toString());
                            AppMethodBeat.o(14882);
                            throw th;
                        }
                        if (bcVar == null) {
                            jVar.BPu = bl.BQP;
                        } else {
                            bcVar.start();
                            ap a = kotlinx.coroutines.bc.a.a(bcVar, true, false, new kotlinx.coroutines.l(bcVar, jVar), 2);
                            jVar.BPu = a;
                            if (jVar.BPs instanceof bm) {
                                obj2 = null;
                            } else {
                                obj2 = 1;
                            }
                            if (obj2 != null) {
                                a.dispose();
                                jVar.BPu = bl.BQP;
                            }
                        }
                        kotlinx.coroutines.i iVar = jVar;
                        a.c.e dWv = iVar.dWv();
                        a.f.b.j.p(dWv, "receiver$0");
                        a.c.e.b bVar = dWv.get(a.c.d.AVd);
                        if (!(bVar instanceof aj)) {
                            bVar = null;
                        }
                        aj ajVar = (aj) bVar;
                        if (ajVar == null) {
                            ajVar = ah.elh();
                        }
                        ajVar.a(iVar);
                        if (jVar.ekP()) {
                            yVar2 = a.c.a.a.COROUTINE_SUSPENDED;
                        } else {
                            obj2 = jVar.BPs;
                            if (obj2 instanceof kotlinx.coroutines.q) {
                                th = ((kotlinx.coroutines.q) obj2).cause;
                                AppMethodBeat.o(14882);
                                throw th;
                            }
                            yVar2 = jVar.ec(obj2);
                        }
                        if (yVar2 == a.c.a.a.COROUTINE_SUSPENDED) {
                            a.f.b.j.p(this, "frame");
                        }
                    }
                    if (yVar2 == yVar) {
                        return yVar;
                    }
                    break;
                case 1:
                    if (obj instanceof a.p.b) {
                        th = ((a.p.b) obj).AUq;
                        AppMethodBeat.o(14882);
                        throw th;
                    }
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(14882);
                    throw illegalStateException;
            }
            preloadLogic = PreloadLogic.jSS;
            synchronized (PreloadLogic.jSQ) {
                try {
                    preloadLogic = PreloadLogic.jSS;
                    if (PreloadLogic.jSP == this.jKi) {
                        preloadLogic = PreloadLogic.jSS;
                        if (!PreloadLogic.jSQ.isEmpty()) {
                            preloadLogic = PreloadLogic.jSS;
                            ArrayList arrayList = new ArrayList(PreloadLogic.jSQ);
                            preloadLogic = PreloadLogic.jSS;
                            PreloadLogic.jSQ.clear();
                        }
                    }
                    obj2 = y.AUy;
                } finally {
                    AppMethodBeat.o(14882);
                }
            }
            return obj2;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
    static final class k extends a.f.b.k implements a.f.a.m<h, hz, y> {
        final /* synthetic */ List jTm;

        k(List list) {
            this.jTm = list;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            Integer num = null;
            AppMethodBeat.i(14885);
            h hVar = (h) obj;
            hz hzVar = (hz) obj2;
            a.f.b.j.p(hVar, "result");
            a.f.b.j.p(hzVar, "response");
            if (hVar.cxT) {
                PreloadLogic preloadLogic = PreloadLogic.jSS;
                String aXu = PreloadLogic.TAG;
                StringBuilder stringBuilder = new StringBuilder("response.AppMsgContextList size:");
                LinkedList linkedList = hzVar.vKx;
                ab.i(aXu, stringBuilder.append(linkedList != null ? Integer.valueOf(linkedList.size()) : null).toString());
                com.tencent.mm.plugin.webview.preload.c cVar = new com.tencent.mm.plugin.webview.preload.c();
                cVar.startTime = hVar.start;
                List list = this.jTm;
                if (list != null) {
                    num = Integer.valueOf(list.size());
                }
                cVar.exv = num.intValue();
                LinkedList<ef> linkedList2 = hzVar.vKx;
                if (linkedList2 != null) {
                    for (ef efVar : linkedList2) {
                        if (efVar != null) {
                            String str = efVar.Url;
                            if (str != null && m.FC(str)) {
                                PreloadLogic preloadLogic2 = PreloadLogic.jSS;
                                String aXu2 = PreloadLogic.TAG;
                                StringBuilder append = new StringBuilder("appMsgContext url:").append(efVar.Url).append(" content:");
                                str = efVar.ncM;
                                ab.v(aXu2, append.append(str != null ? str.length() : 0).append(" clientCacheTime:").append(efVar.vFU).append(" forceUrl:").append(efVar.vFV).append(" lastModifyTime:").append(efVar.vFW).append(" noNeedUpdate:").append(efVar.vFX).toString());
                                preloadLogic2 = PreloadLogic.jSS;
                                a aXp = PreloadLogic.aXp();
                                aXu2 = efVar.Url;
                                a.f.b.j.o(aXu2, "Url");
                                aXp.a(aXu2, efVar);
                                if (!hVar.jRW) {
                                    if (efVar.vFX) {
                                        cVar.cYR();
                                        com.tencent.mm.plugin.webview.preload.a.kT(31);
                                    } else {
                                        cVar.cYQ();
                                        com.tencent.mm.plugin.webview.preload.a.kT(32);
                                    }
                                    cVar.IV(efVar.computeSize());
                                }
                                preloadLogic2 = PreloadLogic.jSS;
                                ab.d(PreloadLogic.TAG, "terry trace: preloaded " + efVar.Url);
                            }
                        }
                        preloadLogic = PreloadLogic.jSS;
                        ab.e(PreloadLogic.TAG, "batchSyncAppMsgContext no Url response");
                    }
                }
                cVar.IF();
            }
            if (!hVar.jRW) {
                int i;
                com.tencent.mm.plugin.webview.preload.a.kT(23);
                com.tencent.mm.plugin.webview.preload.a.gv(26, this.jTm.size());
                if (hVar.cxT) {
                    i = 24;
                } else {
                    i = 25;
                }
                com.tencent.mm.plugin.webview.preload.a.kT(i);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(14885);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\u0006J\u0013\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "", "()V", "TAG", "", "checkValid", "", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "lowerVersion", "", "clear", "get", "url", "has", "tmplType", "save", "", "plugin-brandservice_release"})
    public static final class a {
        private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";

        public final boolean bK(String str, int i) {
            AppMethodBeat.i(14860);
            a.f.b.j.p(str, "url");
            ef FP = FP(str);
            if (FP == null) {
                AppMethodBeat.o(14860);
                return false;
            }
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            int sn = PreloadLogic.sn((FP != null ? Integer.valueOf(FP.vGc) : null).intValue());
            if (sn != -1) {
                i = sn;
            }
            preloadLogic = PreloadLogic.jSS;
            boolean a = a(FP, PreloadLogic.so(i));
            if (!a) {
                ab.d(this.TAG, "init valid:" + b.FI(str));
            }
            AppMethodBeat.o(14860);
            return a;
        }

        public final ef FP(String str) {
            AppMethodBeat.i(14861);
            a.f.b.j.p(str, "url");
            String FI = b.FI(str);
            as FL = b.FL(FI);
            if (FL != null) {
                ef efVar = new ef();
                try {
                    efVar.parseFrom(FL.decodeBytes(FI));
                    efVar.Url = str;
                    ab.i(this.TAG, "found:" + FI + " last modify:" + efVar.vFW);
                    AppMethodBeat.o(14861);
                    return efVar;
                } catch (IOException e) {
                    ab.printErrStackTrace(this.TAG, e, "get:".concat(String.valueOf(FI)), new Object[0]);
                }
            }
            ab.i(this.TAG, "not found:".concat(String.valueOf(FI)));
            AppMethodBeat.o(14861);
            return null;
        }

        private final boolean a(ef efVar, int i) {
            AppMethodBeat.i(14862);
            if (efVar == null) {
                ab.v(this.TAG, "checkValid: null");
                AppMethodBeat.o(14862);
                return false;
            } else if (efVar.vFY == 0 || efVar.vFY >= i) {
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
                if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXh()) {
                    ab.i(this.TAG, "checkValid: debug to expire");
                } else {
                    boolean a;
                    String str = efVar.Url;
                    a.f.b.j.o(str, "appMsgContext.Url");
                    str = b.FK(str);
                    as FL = b.FL(str);
                    if (FL != null) {
                        a = d.a(FL, str, ((long) efVar.vFU) * 1000);
                    } else {
                        a = true;
                    }
                    if (a) {
                        ab.i(this.TAG, "checkValid: expire for " + efVar.vFU);
                        AppMethodBeat.o(14862);
                        return false;
                    }
                }
                AppMethodBeat.o(14862);
                return true;
            } else {
                ab.v(this.TAG, "checkValid: lower version:data(" + efVar.vFY + ") < require(" + i + ')');
                AppMethodBeat.o(14862);
                return false;
            }
        }

        public final void a(String str, ef efVar) {
            byte[] bArr = null;
            AppMethodBeat.i(14863);
            a.f.b.j.p(str, "url");
            if (efVar == null) {
                ab.e(this.TAG, "save fail, appMsgContext is null");
                AppMethodBeat.o(14863);
                return;
            }
            String FI = b.FI(str);
            as aWO = b.aWO();
            String str2 = efVar.ncM;
            try {
                bArr = efVar.toByteArray();
                ef efVar2 = new ef();
                efVar2.parseFrom(bArr);
                efVar2.ncM = null;
                bArr = efVar2.toByteArray();
            } catch (IOException e) {
                ab.printErrStackTrace(this.TAG, e, "save ".concat(String.valueOf(FI)), new Object[0]);
            }
            if (bArr != null) {
                aWO.encode(FI, bArr);
                if (str2 != null) {
                    aWO.putString(b.FJ(str), str2);
                }
                d.a(aWO, b.FK(str));
            }
            ab.i(this.TAG, "save " + FI + " last modify:" + efVar.vFW);
            AppMethodBeat.o(14863);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_CheckReport;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "type", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    static final class b implements com.tencent.mm.ipcinvoker.a<IPCVoid, IPCVoid> {
        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(14864);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.aXs();
            AppMethodBeat.o(14864);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$run$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
    public static final class t implements IdleHandler {
        final /* synthetic */ int jKl;

        t(int i) {
            this.jKl = i;
        }

        public final boolean queueIdle() {
            AppMethodBeat.i(14910);
            Looper.myQueue().removeIdleHandler(this);
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            PreloadLogic.sp(this.jKl);
            preloadLogic = PreloadLogic.jSS;
            PreloadLogic.jSF.set(false);
            AppMethodBeat.o(14910);
            return false;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_PreloadWebview;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "type", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    static final class d implements com.tencent.mm.ipcinvoker.a<IPCInteger, IPCVoid> {
        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(14866);
            a.f.b.j.p((IPCInteger) obj, "type");
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c.aVR();
            AppMethodBeat.o(14866);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/ref/WeakReference;", "", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "<anonymous parameter 2>", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
    static final class m extends a.f.b.k implements a.f.a.q<WeakReference<Object>, h, ef, y> {
        public static final m jTo = new m();

        static {
            AppMethodBeat.i(14889);
            AppMethodBeat.o(14889);
        }

        m() {
            super(3);
        }

        public final /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(14888);
            h hVar = (h) obj2;
            ef efVar = (ef) obj3;
            a.f.b.j.p((WeakReference) obj, "<anonymous parameter 0>");
            a.f.b.j.p(hVar, "<anonymous parameter 1>");
            a.f.b.j.p(efVar, "<anonymous parameter 2>");
            y yVar = y.AUy;
            AppMethodBeat.o(14888);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "invoke"})
    static final class v extends a.f.b.k implements a.f.a.b<RunningAppProcessInfo, Boolean> {
        final /* synthetic */ i jTw;

        v(i iVar) {
            this.jTw = iVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(14912);
            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) obj;
            a.f.b.j.p(runningAppProcessInfo, "it");
            Boolean valueOf = Boolean.valueOf(a.f.b.j.j(runningAppProcessInfo.processName, this.jTw.processName));
            AppMethodBeat.o(14912);
            return valueOf;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_CheckTmplVer;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    static final class c implements com.tencent.mm.ipcinvoker.a<Bundle, IPCVoid> {
        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(14865);
            Bundle bundle = (Bundle) obj;
            a.f.b.j.p(bundle, "bundle");
            int i = bundle.getInt("openScene", Downloads.MIN_WAIT_FOR_NETWORK);
            String string = bundle.getString(DownloadInfo.NETTYPE, "unknown");
            a.f.b.j.o(string, DownloadInfo.NETTYPE);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.a(i, string, new int[0]);
            AppMethodBeat.o(14865);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class s<T> implements com.tencent.mm.ipcinvoker.c<ResultType> {
        final /* synthetic */ a.f.a.m jTs;

        s(a.f.a.m mVar) {
            this.jTs = mVar;
        }

        public final /* synthetic */ void ao(Object obj) {
            AppMethodBeat.i(14909);
            Bundle bundle = (Bundle) obj;
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            a.f.b.j.o(bundle, "bundle");
            PreloadLogic.a(bundle, this.jTs);
            AppMethodBeat.o(14909);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a/\u0012\u0004\u0012\u00020\u0002\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00040\u00030\u0001H\n¢\u0006\u0002\b\n"}, dWq = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "invoke"})
    static final class l extends a.f.b.k implements a.f.a.a<ConcurrentHashMap<String, ConcurrentLinkedDeque<a.f.a.b<? super Bundle, ? extends y>>>> {
        public static final l jTn = new l();

        static {
            AppMethodBeat.i(14887);
            AppMethodBeat.o(14887);
        }

        l() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14886);
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            AppMethodBeat.o(14886);
            return concurrentHashMap;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_RUN_CGI;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    static final class e implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.b<Bundle, y> {
            final /* synthetic */ com.tencent.mm.ipcinvoker.c jST;

            a(com.tencent.mm.ipcinvoker.c cVar) {
                this.jST = cVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(14867);
                Bundle bundle = (Bundle) obj;
                a.f.b.j.p(bundle, "it");
                this.jST.ao(bundle);
                y yVar = y.AUy;
                AppMethodBeat.o(14867);
                return yVar;
            }
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(14868);
            Bundle bundle = (Bundle) obj;
            a.f.b.j.p(bundle, "bundle");
            a.f.b.j.p(cVar, "callback");
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            PreloadLogic.b(bundle, new a(cVar));
            AppMethodBeat.o(14868);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_UpdateWebview;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    static final class g implements com.tencent.mm.ipcinvoker.a<Bundle, IPCVoid> {
        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(14870);
            Bundle bundle = (Bundle) obj;
            a.f.b.j.p(bundle, "bundle");
            int i = bundle.getInt("tmplType");
            String string = bundle.getString("contentId");
            String string2 = bundle.getString("url");
            long j = bundle.getLong("startLoadPage");
            a.f.b.j.o(string, "contentId");
            a.f.b.j.o(string2, "url");
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c.a(i, string, string2, j);
            AppMethodBeat.o(14870);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\r¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "", "isSuccess", "", "start", "", "end", "isMounted", "isCached", "(ZJJZZ)V", "getEnd", "()J", "setEnd", "(J)V", "()Z", "setCached", "(Z)V", "setMounted", "setSuccess", "getStart", "setStart", "plugin-brandservice_release"})
    public static final class h {
        public long aZV;
        public boolean cxT;
        public boolean jRW;
        public boolean jSU;
        public long start;

        private h(boolean z, long j, long j2, boolean z2) {
            this.cxT = z;
            this.start = j;
            this.aZV = j2;
            this.jRW = z2;
            this.jSU = false;
        }

        public /* synthetic */ h(boolean z, long j, long j2, boolean z2, byte b) {
            this(z, j, j2, z2);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    static final class u implements com.tencent.mm.ai.w.a {
        final /* synthetic */ a.f.a.b exI;
        final /* synthetic */ long jTt;
        final /* synthetic */ long jTu;
        final /* synthetic */ ArrayList jTv;

        u(long j, long j2, a.f.a.b bVar, ArrayList arrayList) {
            this.jTt = j;
            this.jTu = j2;
            this.exI = bVar;
            this.jTv = arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x00f7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, com.tencent.mm.ai.m mVar) {
            long currentTimeMillis;
            PreloadLogic preloadLogic;
            ArrayList<String> arrayList;
            AppMethodBeat.i(14911);
            PreloadLogic preloadLogic2 = PreloadLogic.jSS;
            ab.i(PreloadLogic.TAG, "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            Bundle bundle = new Bundle();
            if (i == 0 && i2 == 0) {
                a.f.b.j.o(bVar, "rr");
                if (bVar.acA() != null && (bVar.acA() instanceof hz)) {
                    com.tencent.mm.bt.a acA = bVar.acA();
                    if (acA == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchGetAppMsgResp");
                        AppMethodBeat.o(14911);
                        throw vVar;
                    }
                    hz hzVar = (hz) acA;
                    bundle.putBoolean("success", true);
                    bundle.putByteArray("response", hzVar.toByteArray());
                    LinkedList linkedList = hzVar.vKy;
                    a.f.b.j.o(linkedList, "response.SceneControlList");
                    if ((!((Collection) linkedList).isEmpty() ? 1 : null) != null) {
                        bui bui = new bui();
                        bui.vKy = hzVar.vKy;
                        l.aXy().encode("_msg_scene_strip", bui.toByteArray());
                    }
                    bundle.putLong("start", this.jTt);
                    currentTimeMillis = System.currentTimeMillis();
                    bundle.putLong("end", currentTimeMillis);
                    preloadLogic = PreloadLogic.jSS;
                    ab.v(PreloadLogic.TAG, "terry performance runCGI #" + this.jTu + ": " + this.jTt + ',' + currentTimeMillis);
                    this.exI.am(bundle);
                    bundle.putBoolean("mount", true);
                    arrayList = this.jTv;
                    a.f.b.j.o(arrayList, "urls");
                    for (String str2 : arrayList) {
                        a.f.b.j.o(str2, "url");
                        String FJ = b.FJ(str2);
                        preloadLogic2 = PreloadLogic.jSS;
                        ConcurrentLinkedDeque<a.f.a.b> concurrentLinkedDeque = (ConcurrentLinkedDeque) PreloadLogic.aXq().get(FJ);
                        PreloadLogic preloadLogic3 = PreloadLogic.jSS;
                        PreloadLogic.aXq().remove(FJ);
                        if (concurrentLinkedDeque != null) {
                            for (a.f.a.b bVar2 : concurrentLinkedDeque) {
                                bundle.putString("id", FJ);
                                bVar2.am(bundle);
                            }
                        }
                    }
                    AppMethodBeat.o(14911);
                    return 0;
                }
            }
            bundle.putBoolean("success", false);
            bundle.putLong("start", this.jTt);
            currentTimeMillis = System.currentTimeMillis();
            bundle.putLong("end", currentTimeMillis);
            preloadLogic = PreloadLogic.jSS;
            ab.v(PreloadLogic.TAG, "terry performance runCGI #" + this.jTu + ": " + this.jTt + ',' + currentTimeMillis);
            this.exI.am(bundle);
            bundle.putBoolean("mount", true);
            arrayList = this.jTv;
            a.f.b.j.o(arrayList, "urls");
            for (String str22 : arrayList) {
            }
            AppMethodBeat.o(14911);
            return 0;
        }
    }

    @a.c.b.a.d(c = "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$preloadByIdAndUrls$1", dWy = {995}, f = "PreloadLogic.kt", m = "invokeSuspend")
    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class p extends a.c.b.a.g implements a.f.a.m<ac, a.c.c<? super y>, Object> {
        final /* synthetic */ int jKl;
        final /* synthetic */ List jKn;
        private ac jTk;
        int label;

        p(List list, int i, a.c.c cVar) {
            this.jKn = list;
            this.jKl = i;
            super(cVar);
        }

        public final a.c.c<y> a(Object obj, a.c.c<?> cVar) {
            AppMethodBeat.i(14903);
            a.f.b.j.p(cVar, "completion");
            p pVar = new p(this.jKn, this.jKl, cVar);
            pVar.jTk = (ac) obj;
            AppMethodBeat.o(14903);
            return pVar;
        }

        public final Object m(Object obj, Object obj2) {
            AppMethodBeat.i(14904);
            Object bO = ((p) a(obj, (a.c.c) obj2)).bO(y.AUy);
            AppMethodBeat.o(14904);
            return bO;
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x015e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x014b  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01f5 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0229  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final Object bO(Object obj) {
            AppMethodBeat.i(14902);
            a.c.a.a aVar = a.c.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    if (obj instanceof a.p.b) {
                        Throwable th = ((a.p.b) obj).AUq;
                        AppMethodBeat.o(14902);
                        throw th;
                    }
                    List<List> list = this.jKn;
                    if ((!((Collection) list).isEmpty() ? 1 : null) != null) {
                        List list2;
                        PreloadLogic preloadLogic;
                        PreloadLogic preloadLogic2 = PreloadLogic.jSS;
                        if (PreloadLogic.sq(this.jKl) != 0) {
                            for (List list22 : list) {
                                StringBuilder append = new StringBuilder("addToPreload_").append((String) list22.get(0)).append('_').append((String) list22.get(1)).append('_');
                                PreloadLogic preloadLogic3 = PreloadLogic.jSS;
                                append = append.append((String) PreloadLogic.a(list22, 3, (Object) "")).append('_');
                                preloadLogic3 = PreloadLogic.jSS;
                                String stringBuilder = append.append((String) PreloadLogic.a(list22, 4, (Object) "")).toString();
                                preloadLogic = PreloadLogic.jSS;
                                if (!PreloadLogic.aXr().contains(stringBuilder)) {
                                    Object obj2;
                                    int i;
                                    preloadLogic = PreloadLogic.jSS;
                                    PreloadLogic.aXr().add(stringBuilder);
                                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                                    r7 = new Object[11];
                                    PreloadLogic preloadLogic4 = PreloadLogic.jSS;
                                    r7[3] = PreloadLogic.a(list22, 3, (Object) "");
                                    preloadLogic4 = PreloadLogic.jSS;
                                    r7[4] = PreloadLogic.a(list22, 4, (Object) "");
                                    r7[5] = Integer.valueOf(1);
                                    r7[6] = list22.get(2);
                                    r7[7] = "";
                                    r7[8] = "";
                                    r7[9] = "";
                                    if (a.f.b.j.j((String) list22.get(2), "-1")) {
                                        Boolean valueOf;
                                        String str = (String) list22.get(1);
                                        if (str != null) {
                                            valueOf = Boolean.valueOf(m.FW(str));
                                        } else {
                                            valueOf = null;
                                        }
                                        if (valueOf.booleanValue()) {
                                            obj2 = 1;
                                            if (obj2 == null) {
                                                i = 1;
                                            } else {
                                                i = 0;
                                            }
                                            r7[10] = Integer.valueOf(i);
                                            hVar.e(16468, r7);
                                        }
                                    }
                                    obj2 = null;
                                    if (obj2 == null) {
                                    }
                                    r7[10] = Integer.valueOf(i);
                                    hVar.e(16468, r7);
                                }
                            }
                        }
                        preloadLogic2 = PreloadLogic.jSS;
                        if (PreloadLogic.rW(PreloadLogic.sr(this.jKl))) {
                            int sk = b.sk(this.jKl);
                            Collection arrayList = new ArrayList();
                            for (Object next : list) {
                                if ((!m.FW((String) ((List) next).get(1)) ? 1 : null) == null) {
                                    arrayList.add(next);
                                }
                            }
                            Iterable<List> iterable = (List) arrayList;
                            Collection arrayList2 = new ArrayList(a.a.m.d(iterable));
                            for (List list222 : iterable) {
                                Object obj3 = list222.get(1);
                                preloadLogic = PreloadLogic.jSS;
                                arrayList2.add(new android.support.v4.f.j(obj3, Integer.valueOf(PreloadLogic.sn(Integer.parseInt((String) list222.get(2))))));
                            }
                            arrayList = new ArrayList();
                            for (Object next2 : (List) arrayList2) {
                                Object obj4;
                                android.support.v4.f.j jVar = (android.support.v4.f.j) next2;
                                preloadLogic = PreloadLogic.jSS;
                                if (m.FC(PreloadLogic.c(jVar))) {
                                    preloadLogic = PreloadLogic.jSS;
                                    a aXp = PreloadLogic.aXp();
                                    PreloadLogic preloadLogic5 = PreloadLogic.jSS;
                                    String c = PreloadLogic.c(jVar);
                                    PreloadLogic preloadLogic6 = PreloadLogic.jSS;
                                    if (!aXp.bK(c, PreloadLogic.d(jVar))) {
                                        obj4 = null;
                                        if (obj4 != null) {
                                            arrayList.add(next2);
                                        }
                                    }
                                }
                                obj4 = 1;
                                if (obj4 != null) {
                                }
                            }
                            list222 = (List) arrayList;
                            int max = Math.max(list222.size() - sk, 0);
                            List a = a.a.t.a((Iterable) list222, sk);
                            if ((!((Collection) a).isEmpty() ? 1 : null) != null) {
                                preloadLogic2 = PreloadLogic.jSS;
                                PreloadLogic.a(a, this.jKl, max, 1);
                            }
                        }
                    }
                    y yVar = y.AUy;
                    AppMethodBeat.o(14902);
                    return yVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(14902);
                    throw illegalStateException;
            }
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$Process;", "", "processName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getProcessName$plugin_brandservice_release", "()Ljava/lang/String;", "setProcessName$plugin_brandservice_release", "(Ljava/lang/String;)V", "MM", "Tool", "ToolMP", "UNKNOW", "plugin-brandservice_release"})
    public enum i {
        MM("com.tencent.mm"),
        Tool("com.tencent.mm:tools"),
        ToolMP("com.tencent.mm:toolsmp"),
        UNKNOW("com.tencent.mm:tools");
        
        String processName;

        private i(String str) {
            a.f.b.j.p(str, "processName");
            AppMethodBeat.i(14878);
            this.processName = str;
            AppMethodBeat.o(14878);
        }

        static {
            AppMethodBeat.o(14877);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "plugin-brandservice_release"})
    public static final class o extends HashMap<Integer, String> {
        o() {
            AppMethodBeat.i(14891);
            put(Integer.valueOf(1), "100463");
            put(Integer.valueOf(3), "100486");
            AppMethodBeat.o(14891);
        }

        public final /* bridge */ boolean containsKey(Object obj) {
            AppMethodBeat.i(14894);
            if (obj instanceof Integer) {
                boolean containsKey = super.containsKey((Integer) obj);
                AppMethodBeat.o(14894);
                return containsKey;
            }
            AppMethodBeat.o(14894);
            return false;
        }

        public final /* bridge */ boolean containsValue(Object obj) {
            AppMethodBeat.i(14892);
            if (obj instanceof String) {
                boolean containsValue = super.containsValue((String) obj);
                AppMethodBeat.o(14892);
                return containsValue;
            }
            AppMethodBeat.o(14892);
            return false;
        }

        public final /* bridge */ Object get(Object obj) {
            AppMethodBeat.i(14895);
            if (obj instanceof Integer) {
                String str = (String) super.get((Integer) obj);
                AppMethodBeat.o(14895);
                return str;
            }
            AppMethodBeat.o(14895);
            return null;
        }

        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            AppMethodBeat.i(14893);
            if (obj instanceof Integer) {
                String str = (String) super.getOrDefault((Integer) obj, (String) obj2);
                AppMethodBeat.o(14893);
                return str;
            }
            AppMethodBeat.o(14893);
            return obj2;
        }

        public final /* bridge */ Object remove(Object obj) {
            AppMethodBeat.i(14896);
            if (obj instanceof Integer) {
                String str = (String) super.remove((Integer) obj);
                AppMethodBeat.o(14896);
                return str;
            }
            AppMethodBeat.o(14896);
            return null;
        }

        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            AppMethodBeat.i(14897);
            if ((obj instanceof Integer) && (obj2 instanceof String)) {
                boolean remove = super.remove((Integer) obj, (String) obj2);
                AppMethodBeat.o(14897);
                return remove;
            }
            AppMethodBeat.o(14897);
            return false;
        }

        public final /* bridge */ Set<Entry<Integer, String>> entrySet() {
            AppMethodBeat.i(14898);
            Set entrySet = super.entrySet();
            AppMethodBeat.o(14898);
            return entrySet;
        }

        public final /* bridge */ Set<Integer> keySet() {
            AppMethodBeat.i(14899);
            Set keySet = super.keySet();
            AppMethodBeat.o(14899);
            return keySet;
        }

        public final /* bridge */ Collection<String> values() {
            AppMethodBeat.i(14900);
            Collection values = super.values();
            AppMethodBeat.o(14900);
            return values;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.i(14901);
            int size = super.size();
            AppMethodBeat.o(14901);
            return size;
        }
    }

    @a.c.b.a.d(c = "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$preloadByInfoIdAndBuffer$1", dWy = {967}, f = "PreloadLogic.kt", m = "invokeSuspend")
    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class q extends a.c.b.a.g implements a.f.a.m<ac, a.c.c<? super y>, Object> {
        final /* synthetic */ int jKl;
        final /* synthetic */ List jKn;
        private ac jTk;
        int label;

        q(int i, List list, a.c.c cVar) {
            this.jKl = i;
            this.jKn = list;
            super(cVar);
        }

        public final a.c.c<y> a(Object obj, a.c.c<?> cVar) {
            AppMethodBeat.i(14906);
            a.f.b.j.p(cVar, "completion");
            q qVar = new q(this.jKl, this.jKn, cVar);
            qVar.jTk = (ac) obj;
            AppMethodBeat.o(14906);
            return qVar;
        }

        public final Object m(Object obj, Object obj2) {
            AppMethodBeat.i(14907);
            Object bO = ((q) a(obj, (a.c.c) obj2)).bO(y.AUy);
            AppMethodBeat.o(14907);
            return bO;
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x00c0 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00f4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final Object bO(Object obj) {
            AppMethodBeat.i(14905);
            a.c.a.a aVar = a.c.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    if (obj instanceof a.p.b) {
                        Throwable th = ((a.p.b) obj).AUq;
                        AppMethodBeat.o(14905);
                        throw th;
                    }
                    PreloadLogic preloadLogic;
                    int i;
                    int sk = b.sk(this.jKl);
                    Collection arrayList = new ArrayList();
                    for (String[] strArr : this.jKn) {
                        List a;
                        int parseInt = Integer.parseInt(strArr[2]);
                        LinkedList linkedList = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).b(Long.parseLong(strArr[0]), strArr[1]).fjr;
                        if (parseInt > 0) {
                            a.f.b.j.o(linkedList, "it");
                            a = a.a.t.a((Iterable) linkedList, parseInt);
                        } else {
                            a = linkedList;
                        }
                        a.a.q.a(arrayList, (Iterable) a);
                    }
                    Iterable<com.tencent.mm.af.p> iterable = (List) arrayList;
                    Collection arrayList2 = new ArrayList(a.a.m.d(iterable));
                    for (com.tencent.mm.af.p pVar : iterable) {
                        String str = pVar.url;
                        preloadLogic = PreloadLogic.jSS;
                        arrayList2.add(new android.support.v4.f.j(str, Integer.valueOf(PreloadLogic.sn(pVar.type))));
                    }
                    arrayList = new ArrayList();
                    for (Object next : (List) arrayList2) {
                        android.support.v4.f.j jVar = (android.support.v4.f.j) next;
                        PreloadLogic preloadLogic2 = PreloadLogic.jSS;
                        if (m.FC(PreloadLogic.c(jVar))) {
                            preloadLogic2 = PreloadLogic.jSS;
                            a aXp = PreloadLogic.aXp();
                            preloadLogic = PreloadLogic.jSS;
                            String c = PreloadLogic.c(jVar);
                            PreloadLogic preloadLogic3 = PreloadLogic.jSS;
                            if (!aXp.bK(c, PreloadLogic.d(jVar))) {
                                i = 0;
                                if (i != 0) {
                                    arrayList.add(next);
                                }
                            }
                        }
                        i = 1;
                        if (i != 0) {
                        }
                    }
                    List list = (List) arrayList;
                    int max = Math.max(list.size() - sk, 0);
                    list = a.a.t.a((Iterable) list, sk);
                    if (list.isEmpty()) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        PreloadLogic preloadLogic4 = PreloadLogic.jSS;
                        PreloadLogic.a(list, this.jKl, max, 1);
                    }
                    y yVar = y.AUy;
                    AppMethodBeat.o(14905);
                    return yVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(14905);
                    throw illegalStateException;
            }
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
    static final class r extends a.f.b.k implements a.f.a.b<Bundle, y> {
        final /* synthetic */ a.f.a.m jTs;

        r(a.f.a.m mVar) {
            this.jTs = mVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(14908);
            Bundle bundle = (Bundle) obj;
            a.f.b.j.p(bundle, "it");
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            PreloadLogic.a(bundle, this.jTs);
            y yVar = y.AUy;
            AppMethodBeat.o(14908);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_Report;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    static final class f implements com.tencent.mm.ipcinvoker.a<Bundle, IPCVoid> {
        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(14869);
            Bundle bundle = (Bundle) obj;
            a.f.b.j.p(bundle, "bundle");
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c.FO(bundle.getString("url"));
            AppMethodBeat.o(14869);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f¢\u0006\u0002\u0010\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u0018\u00103\u001a\u0002042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0006H\u0016R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u001a\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u001a\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u001a\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001c¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "url", "", "tmplType", "openScene", "subScene", "aScene", "uid", "fastOpen", "", "cacheData", "zip", "prefixMP", "prefixHttp", "cacheItemShowType", "webCodeCache", "(ILjava/lang/String;IIIILjava/lang/String;ZZZZZZZ)V", "getAScene", "()I", "getCacheData", "()Z", "setCacheData", "(Z)V", "getCacheItemShowType", "setCacheItemShowType", "getFastOpen", "setFastOpen", "getId", "getOpenScene", "getPrefixHttp", "setPrefixHttp", "getPrefixMP", "setPrefixMP", "getSubScene", "getTmplType", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "getUrl", "getWebCodeCache", "setWebCodeCache", "getZip", "setZip", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-brandservice_release"})
    public static final class PreloadSession implements Parcelable {
        public static final a CREATOR = new a();
        final int id;
        final int jSV;
        final int jSW;
        final int jSX;
        String jSY;
        boolean jSZ;
        public boolean jSa;
        public final int jSu;
        boolean jTa;
        public boolean jTb;
        public boolean jTc;
        boolean jTd;
        public boolean jTe;
        final String url;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "plugin-brandservice_release"})
        public static final class a implements Creator<PreloadSession> {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(14871);
                a.f.b.j.p(parcel, "parcel");
                PreloadSession preloadSession = new PreloadSession(parcel);
                AppMethodBeat.o(14871);
                return preloadSession;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PreloadSession[i];
            }
        }

        static {
            AppMethodBeat.i(14876);
            AppMethodBeat.o(14876);
        }

        private PreloadSession(int i, String str, int i2, int i3, int i4, int i5, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            a.f.b.j.p(str, "url");
            a.f.b.j.p(str2, "uid");
            AppMethodBeat.i(138514);
            this.id = i;
            this.url = str;
            this.jSV = i2;
            this.jSu = i3;
            this.jSW = i4;
            this.jSX = i5;
            this.jSY = str2;
            this.jSZ = z;
            this.jTa = z2;
            this.jTb = z3;
            this.jTc = z4;
            this.jTd = z5;
            this.jSa = z6;
            this.jTe = z7;
            AppMethodBeat.o(138514);
        }

        public /* synthetic */ PreloadSession(int i, String str, int i2, int i3, int i4, int i5) {
            this(i, str, i2, i3, i4, i5, "", false, false, false, false, false, false, false);
            AppMethodBeat.i(14874);
            AppMethodBeat.o(14874);
        }

        public PreloadSession(Parcel parcel) {
            boolean z;
            a.f.b.j.p(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            a.f.b.j.o(readString, "parcel.readString()");
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            String readString2 = parcel.readString();
            a.f.b.j.o(readString2, "parcel.readString()");
            boolean z2 = parcel.readByte() != (byte) 0;
            boolean z3 = parcel.readByte() != (byte) 0;
            boolean z4 = parcel.readByte() != (byte) 0;
            boolean z5 = parcel.readByte() != (byte) 0;
            boolean z6 = parcel.readByte() != (byte) 0;
            boolean z7 = parcel.readByte() != (byte) 0;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this(readInt, readString, readInt2, readInt3, readInt4, readInt5, readString2, z2, z3, z4, z5, z6, z7, z);
            AppMethodBeat.i(14875);
            AppMethodBeat.o(14875);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.i(14872);
            a.f.b.j.p(parcel, "parcel");
            parcel.writeInt(this.id);
            parcel.writeString(this.url);
            parcel.writeInt(this.jSV);
            parcel.writeInt(this.jSu);
            parcel.writeInt(this.jSW);
            parcel.writeInt(this.jSX);
            parcel.writeString(this.jSY);
            parcel.writeByte(this.jSZ ? (byte) 1 : (byte) 0);
            if (this.jTa) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.jTb) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.jTc) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.jTd) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.jSa) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.jTe) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            AppMethodBeat.o(14872);
        }

        public final int describeContents() {
            return 0;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
    static final class n extends a.f.b.k implements a.f.a.m<h, hz, y> {
        final /* synthetic */ String jTp;
        final /* synthetic */ a.f.a.q jTq;
        final /* synthetic */ WeakReference jTr;

        n(String str, a.f.a.q qVar, WeakReference weakReference) {
            this.jTp = str;
            this.jTq = qVar;
            this.jTr = weakReference;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(14890);
            h hVar = (h) obj;
            hz hzVar = (hz) obj2;
            a.f.b.j.p(hVar, "result");
            a.f.b.j.p(hzVar, "response");
            if (hVar.cxT) {
                LinkedList linkedList = hzVar.vKx;
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    if (it.hasNext()) {
                        ef efVar = (ef) it.next();
                        PreloadLogic preloadLogic = PreloadLogic.jSS;
                        ab.i(PreloadLogic.TAG, "[findAppMsgContext] url:%s", this.jTp);
                        if (!hVar.jRW) {
                            preloadLogic = PreloadLogic.jSS;
                            a aXp = PreloadLogic.aXp();
                            String str = efVar.Url;
                            a.f.b.j.o(str, "appMsgContext.Url");
                            aXp.a(str, efVar);
                            com.tencent.mm.plugin.webview.preload.c cVar = new com.tencent.mm.plugin.webview.preload.c();
                            cVar.startTime = hVar.start;
                            cVar.endTime = hVar.aZV;
                            cVar.exv = 1;
                            if (efVar.vFX) {
                                cVar.cYR();
                                com.tencent.mm.plugin.webview.preload.a.kT(31);
                            } else {
                                cVar.cYQ();
                                com.tencent.mm.plugin.webview.preload.a.kT(32);
                            }
                            cVar.IV(efVar.computeSize());
                            cVar.IF();
                        }
                        a.f.a.q qVar = this.jTq;
                        WeakReference weakReference = this.jTr;
                        a.f.b.j.o(efVar, "appMsgContext");
                        qVar.g(weakReference, hVar, efVar);
                    } else {
                        Throwable noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
                        AppMethodBeat.o(14890);
                        throw noSuchElementException;
                    }
                }
            }
            this.jTq.g(this.jTr, hVar, new ef());
            if (!hVar.jRW) {
                int i;
                com.tencent.mm.plugin.webview.preload.a.kT(20);
                com.tencent.mm.plugin.webview.preload.a.kT(26);
                if (hVar.cxT) {
                    i = 24;
                } else {
                    i = 25;
                }
                com.tencent.mm.plugin.webview.preload.a.kT(i);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(14890);
            return yVar;
        }
    }

    public static ConcurrentHashMap<String, ConcurrentLinkedDeque<a.f.a.b<Bundle, y>>> aXq() {
        AppMethodBeat.i(14929);
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) jSO.getValue();
        AppMethodBeat.o(14929);
        return concurrentHashMap;
    }

    static {
        AppMethodBeat.i(14913);
        AppMethodBeat.o(14913);
    }

    private PreloadLogic() {
    }

    public static final /* synthetic */ void b(Bundle bundle, a.f.a.b bVar) {
        AppMethodBeat.i(14938);
        a(bundle, bVar);
        AppMethodBeat.o(14938);
    }

    public static final /* synthetic */ String c(android.support.v4.f.j jVar) {
        AppMethodBeat.i(14945);
        String a = a(jVar);
        AppMethodBeat.o(14945);
        return a;
    }

    public static final /* synthetic */ int d(android.support.v4.f.j jVar) {
        AppMethodBeat.i(14946);
        int b = b(jVar);
        AppMethodBeat.o(14946);
        return b;
    }

    public static final /* synthetic */ int sn(int i) {
        AppMethodBeat.i(14939);
        int sl = sl(i);
        AppMethodBeat.o(14939);
        return sl;
    }

    public static final /* synthetic */ int sr(int i) {
        AppMethodBeat.i(14944);
        int sm = sm(i);
        AppMethodBeat.o(14944);
        return sm;
    }

    public static final void mg(int i) {
        AppMethodBeat.i(14914);
        if (jSF.get()) {
            AppMethodBeat.o(14914);
        } else if (i == Downloads.MIN_WAIT_FOR_NETWORK) {
            a(jSE, i);
            jSF.set(false);
            AppMethodBeat.o(14914);
        } else {
            Looper.myQueue().addIdleHandler(new t(i));
            AppMethodBeat.o(14914);
        }
    }

    private static void a(i iVar, int i) {
        AppMethodBeat.i(14915);
        ab.i(TAG, "start in ".concat(String.valueOf(iVar)));
        aj(i, d.aWX());
        a(iVar);
        aXs();
        clear();
        AppMethodBeat.o(14915);
    }

    public static final void aXo() {
        AppMethodBeat.i(14917);
        a(jSE);
        AppMethodBeat.o(14917);
    }

    private static void a(i iVar) {
        AppMethodBeat.i(14918);
        a.f.b.j.p(iVar, "process");
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXe()) {
            com.tencent.mm.ipcinvoker.f.a(iVar.processName, new IPCInteger(0), d.class, null);
            AppMethodBeat.o(14918);
            return;
        }
        AppMethodBeat.o(14918);
    }

    private static void aj(int i, String str) {
        AppMethodBeat.i(14919);
        a.f.b.j.p(str, DownloadInfo.NETTYPE);
        Bundle bundle = new Bundle();
        bundle.putInt("openScene", i);
        bundle.putString(DownloadInfo.NETTYPE, str);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle, c.class, null);
        AppMethodBeat.o(14919);
    }

    public static /* synthetic */ boolean a(Context context, String str, int i, int i2, int i3, Intent intent, int i4, com.tencent.mm.plugin.brandservice.a.b.a aVar, int i5) {
        Intent intent2;
        int i6;
        com.tencent.mm.plugin.brandservice.a.b.a aVar2;
        AppMethodBeat.i(14921);
        if ((i5 & 32) != 0) {
            intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
        } else {
            intent2 = intent;
        }
        if ((i5 & 64) != 0) {
            i6 = -1;
        } else {
            i6 = i4;
        }
        if ((i5 & 128) != 0) {
            aVar2 = new com.tencent.mm.plugin.brandservice.a.b.a();
            aVar2.success = true;
        } else {
            aVar2 = aVar;
        }
        boolean a = a(context, str, i, i2, i3, intent2, i6, aVar2);
        AppMethodBeat.o(14921);
        return a;
    }

    private static boolean a(Context context, String str, int i, int i2, int i3, Intent intent, int i4, com.tencent.mm.plugin.brandservice.a.b.a aVar) {
        AppMethodBeat.i(14920);
        a.f.b.j.p(context, "context");
        a.f.b.j.p(str, "rawUrl");
        a.f.b.j.p(intent, "intent");
        a.f.b.j.p(aVar, "result");
        if (a.k.u.ar(str)) {
            aVar.success = false;
            aVar.message = "invalid url";
            AppMethodBeat.o(14920);
            return false;
        } else if (m.FC(str)) {
            int i5;
            if (i == -1) {
                ef FP = jSN.FP(str);
                i5 = FP != null ? FP.vGc : i;
            } else {
                i5 = i;
            }
            int sl = sl(i5);
            if (sl == -1) {
                aVar.success = false;
                aVar.message = "invalid itemShowType:".concat(String.valueOf(i5));
                AppMethodBeat.o(14920);
                return false;
            }
            int i6;
            int i7;
            String G;
            boolean z;
            int sessionId = com.tencent.mm.storage.s.getSessionId();
            if (i2 == 90) {
                i6 = i2;
                i7 = i3;
                G = m.G(m.G(str, "scene", String.valueOf(i2)), "subscene", String.valueOf(i3));
            } else {
                G = m.dg(str, "scene");
                if (G != null) {
                    if (new a.k.k("\\d+").aq(G)) {
                        i2 = Integer.parseInt(G);
                    }
                }
                G = m.dg(str, "subscene");
                if (G != null) {
                    if (new a.k.k("\\d+").aq(G)) {
                        i3 = Integer.parseInt(G);
                    }
                    i6 = i2;
                    i7 = i3;
                    G = str;
                } else {
                    i6 = i2;
                    i7 = i3;
                    G = str;
                }
            }
            intent.putExtra(com.tencent.mm.ui.e.m.ygo, i5);
            intent.putExtra(com.tencent.mm.ui.e.m.ygj, sessionId);
            intent.putExtra(com.tencent.mm.ui.e.m.ygk, i6);
            intent.putExtra(com.tencent.mm.ui.e.m.ygl, i7);
            intent.putExtra(com.tencent.mm.ui.e.m.ygp, i4);
            PreloadSession preloadSession = new PreloadSession(sessionId, G, sl, i6, i7, intent.getIntExtra("geta8key_scene", 0));
            if (i5 != i) {
                z = true;
            } else {
                z = false;
            }
            preloadSession.jSa = z;
            z = jSS.a(context, jSE, intent, preloadSession, aVar);
            if (z) {
                int i8;
                if (i4 != -1 && (context instanceof MMActivity) && i4 == 1) {
                    ((MMActivity) context).overridePendingTransition(R.anim.cg, R.anim.cf);
                }
                switch (i6) {
                    case 0:
                        i8 = 2;
                        break;
                    case 1:
                        i8 = 3;
                        break;
                    case 2:
                        i8 = 0;
                        break;
                    case 90:
                        i8 = 1;
                        break;
                    default:
                        i8 = -1;
                        break;
                }
                com.tencent.mm.plugin.webview.preload.a.IT(i8);
            }
            AppMethodBeat.o(14920);
            return z;
        } else {
            aVar.success = false;
            aVar.message = "invalid host";
            AppMethodBeat.o(14920);
            return false;
        }
    }

    private static int sl(int i) {
        switch (i) {
            case 0:
                return 0;
            case 5:
                return 1;
            case 7:
                return 3;
            case 8:
                return 2;
            default:
                return -1;
        }
    }

    public static final boolean rW(int i) {
        AppMethodBeat.i(14923);
        Object obj;
        boolean booleanValue;
        if (jSM.containsKey(Integer.valueOf(i))) {
            obj = jSM.get(Integer.valueOf(i));
            if (obj == null) {
                a.f.b.j.dWJ();
            }
            booleanValue = ((Boolean) obj).booleanValue();
            AppMethodBeat.o(14923);
            return booleanValue;
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
        Map map;
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXm() || !(com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.DEBUG)) {
            try {
                boolean z;
                map = jSM;
                Integer valueOf = Integer.valueOf(i);
                switch (i) {
                    case 1:
                        if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_biz_timeline, 0) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 2:
                        if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_chat, 0) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 3:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_forward, 0) & 1) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 4:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_sns, 0) & 1) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 5:
                        if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_jsapi, 0) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 6:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_mpprofile, 0) & 1) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 7:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_search, 0) & 1) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 13:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_forward, 0) & 2) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 14:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_sns, 0) & 2) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 16:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_mpprofile, 0) & 2) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 20:
                        if (((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_mpprocess, 0) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 23:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_forward, 0) & 4) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 24:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_sns, 0) & 4) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 26:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_mpprofile, 0) & 4) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 101:
                        if ((((com.tencent.mm.plugin.expt.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mpfastload_android_tmpl_zip, 0) & 1) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                map.put(valueOf, Boolean.valueOf(z));
            } catch (Exception e) {
                jSM.put(Integer.valueOf(i), Boolean.FALSE);
                ab.printErrStackTrace(TAG, e, "canPreloadIn", new Object[0]);
            }
            if (jSM.containsKey(Integer.valueOf(i))) {
                obj = jSM.get(Integer.valueOf(i));
                if (obj == null) {
                    a.f.b.j.dWJ();
                }
                a.f.b.j.o(obj, "isPreloadOpen[openScene]!!");
                booleanValue = ((Boolean) obj).booleanValue();
                AppMethodBeat.o(14923);
                return booleanValue;
            }
            AppMethodBeat.o(14923);
            return false;
        }
        map = jSM;
        Integer valueOf2 = Integer.valueOf(i);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar2 = g.jSD;
        map.put(valueOf2, Boolean.valueOf(h.aXn().getBoolean("preload_use", true)));
        obj = jSM.get(Integer.valueOf(i));
        if (obj == null) {
            a.f.b.j.dWJ();
        }
        booleanValue = ((Boolean) obj).booleanValue();
        AppMethodBeat.o(14923);
        return booleanValue;
    }

    public static a aXp() {
        return jSN;
    }

    private static ef bJ(String str, int i) {
        AppMethodBeat.i(14924);
        a.f.b.j.p(str, "url");
        if (a.k.u.ar(str)) {
            ab.e(TAG, "[findAppMsgContextInCache] url is null, return");
            AppMethodBeat.o(14924);
            return null;
        } else if (jSN.bK(str, i)) {
            ef FP = jSN.FP(str);
            AppMethodBeat.o(14924);
            return FP;
        } else {
            AppMethodBeat.o(14924);
            return null;
        }
    }

    public final void a(Object obj, String str, PreloadSession preloadSession, a.f.a.q<? super WeakReference<Object>, ? super h, ? super ef, y> qVar) {
        AppMethodBeat.i(14925);
        a.f.b.j.p(obj, "context");
        a.f.b.j.p(str, "url");
        a.f.b.j.p(preloadSession, "session");
        a.f.b.j.p(qVar, "callback");
        WeakReference weakReference = new WeakReference(obj);
        h hVar = new h(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte) 0);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXg()) {
            hVar.cxT = true;
            qVar.g(weakReference, hVar, new ef());
            AppMethodBeat.o(14925);
        } else if (a.k.u.ar(str) || !m.FC(str)) {
            qVar.g(weakReference, hVar, new ef());
            AppMethodBeat.o(14925);
        } else {
            ef bJ = bJ(str, preloadSession.jSV);
            if (bJ != null) {
                hVar.cxT = true;
                hVar.jSU = true;
                qVar.g(weakReference, hVar, bJ);
                AppMethodBeat.o(14925);
                return;
            }
            String a = m.a(str, preloadSession);
            LinkedList linkedList = new LinkedList();
            linkedList.add(new android.support.v4.f.j(a, Integer.valueOf(preloadSession.jSV)));
            a((List) linkedList, preloadSession.jSV, (a.f.a.m) new n(a, qVar, weakReference));
            AppMethodBeat.o(14925);
        }
    }

    private static void a(List<? extends android.support.v4.f.j<String, Integer>> list, int i, int i2, int i3, a.f.a.m<? super h, ? super hz, y> mVar) {
        AppMethodBeat.i(14926);
        Bundle bundle = new Bundle();
        String str = "urls";
        Iterable<android.support.v4.f.j> iterable = list;
        Collection arrayList = new ArrayList(a.a.m.d(iterable));
        for (android.support.v4.f.j a : iterable) {
            arrayList.add(a(a));
        }
        bundle.putStringArrayList(str, new ArrayList((List) arrayList));
        str = "tmplTypes";
        Iterable<android.support.v4.f.j> iterable2 = list;
        Collection arrayList2 = new ArrayList(a.a.m.d(iterable2));
        for (android.support.v4.f.j b : iterable2) {
            arrayList2.add(Integer.valueOf(b(b)));
        }
        bundle.putIntegerArrayList(str, new ArrayList((List) arrayList2));
        bundle.putInt("openScene", i);
        bundle.putInt("strip", i2);
        bundle.putInt("stripType", i3);
        com.tencent.mm.kernel.b.g Rn = com.tencent.mm.kernel.g.RM().Rn();
        a.f.b.j.o(Rn, "MMKernel.process().current()");
        if (((com.tencent.mm.kernel.b.h) Rn).SG()) {
            a(bundle, (a.f.a.b) new r(mVar));
            AppMethodBeat.o(14926);
            return;
        }
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle, e.class, new s(mVar));
        AppMethodBeat.o(14926);
    }

    private static com.tencent.mm.ai.b.a a(Iterable<? extends android.support.v4.f.j<String, Integer>> iterable, int i, int i2, int i3) {
        int i4;
        AppMethodBeat.i(14930);
        hy hyVar = new hy();
        hyVar.vKt = d.aWX();
        hyVar.vKu = l.aXx();
        hyVar.vKs = new LinkedList();
        hyVar.vKv = i2;
        hyVar.vKw = i3;
        Collection arrayList = new ArrayList(a.a.m.d(iterable));
        for (android.support.v4.f.j jVar : iterable) {
            bsq bsq = new bsq();
            bsq.Url = a(jVar);
            bsq.vFW = 0;
            bsq.Scene = i;
            ef FP = jSN.FP(a(jVar));
            if (FP != null) {
                bsq.vFW = FP.vFW;
                if (FP.vFY < com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.sv(b(jVar)).Version) {
                    bsq.vFW = 0;
                }
            }
            arrayList.add(bsq);
        }
        hyVar.vKs.addAll((List) arrayList);
        ab.i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", Integer.valueOf(hyVar.vKs.size()));
        ab.d(TAG, "[batchSyncAppMsgContext]urlList:%s", iterable);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.kU(2594);
        aVar.qq("/cgi-bin/mmbiz-bin/batchgetappmsg");
        aVar.kV(0);
        aVar.kW(0);
        aVar.a(hyVar);
        aVar.b(new hz());
        switch (i) {
            case 0:
                i4 = 35;
                break;
            case 90:
                i4 = 34;
                break;
            default:
                i4 = 35;
                break;
        }
        com.tencent.mm.plugin.webview.preload.a.gv(i4, hyVar.vKs.size());
        AppMethodBeat.o(14930);
        return aVar;
    }

    private static int sm(int i) {
        switch (i) {
            case 0:
            case 92:
                return 2;
            case 1:
                return 13;
            case 2:
                return 14;
            case 126:
                return 6;
            default:
                return 0;
        }
    }

    public static final void a(long j, String str, int i, int i2, Object... objArr) {
        AppMethodBeat.i(14931);
        a.f.b.j.p(str, "url");
        a.f.b.j.p(objArr, "params");
        if (jSR) {
            AppMethodBeat.o(14931);
            return;
        }
        kotlinx.coroutines.f.a(aw.BQs, ao.elk(), new j(j, str, i, i2, objArr, null));
        AppMethodBeat.o(14931);
    }

    public static final void j(List<String[]> list, int i) {
        AppMethodBeat.i(14932);
        a.f.b.j.p(list, "items");
        if (jSR) {
            AppMethodBeat.o(14932);
        } else if (rW(sm(i))) {
            jSP = 0;
            jSQ.clear();
            kotlinx.coroutines.f.a(aw.BQs, ao.elk(), new q(i, list, null));
            AppMethodBeat.o(14932);
        } else {
            AppMethodBeat.o(14932);
        }
    }

    public static HashSet<String> aXr() {
        return jKh;
    }

    public static final void i(List<? extends List<String>> list, int i) {
        AppMethodBeat.i(14933);
        a.f.b.j.p(list, "items");
        if (jSR) {
            AppMethodBeat.o(14933);
            return;
        }
        jSP = 0;
        jSQ.clear();
        kotlinx.coroutines.f.a(aw.BQs, ao.elk(), new p(list, i, null));
        AppMethodBeat.o(14933);
    }

    private static void aXs() {
        AppMethodBeat.i(14934);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", null, b.class, null);
        AppMethodBeat.o(14934);
    }

    public static final void FO(String str) {
        AppMethodBeat.i(14935);
        a.f.b.j.p(str, "url");
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle, f.class, null);
        AppMethodBeat.o(14935);
    }

    private static String a(android.support.v4.f.j<String, Integer> jVar) {
        AppMethodBeat.i(14936);
        Object obj = jVar.first;
        if (obj == null) {
            a.f.b.j.dWJ();
        }
        String str = (String) obj;
        AppMethodBeat.o(14936);
        return str;
    }

    private static int b(android.support.v4.f.j<String, Integer> jVar) {
        AppMethodBeat.i(14937);
        Object obj = jVar.second;
        if (obj == null) {
            a.f.b.j.dWJ();
        }
        int intValue = ((Number) obj).intValue();
        AppMethodBeat.o(14937);
        return intValue;
    }

    private static void clear() {
        AppMethodBeat.i(14916);
        b.aWP();
        ab.i(TAG, "clear() isOk:true");
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.aXz();
        AppMethodBeat.o(14916);
    }

    private final boolean a(Context context, i iVar, Intent intent, PreloadSession preloadSession, com.tencent.mm.plugin.brandservice.a.b.a aVar) {
        AppMethodBeat.i(14922);
        TmplParams sx = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.sx(preloadSession.jSV);
        if (sx == null) {
            ab.e(TAG, "tmplParams is null");
            aVar.success = false;
            aVar.message = "not support tmplType=" + preloadSession + ".tmplType";
            AppMethodBeat.o(14922);
            return false;
        }
        boolean z;
        int startPerformance = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, TAG);
        ab.i(TAG, "summer hardcoder biz startPerformance [%s][%s]", Integer.valueOf(902), Integer.valueOf(startPerformance));
        String str = sx.jSY;
        a.f.b.j.o(str, "tmplParams.uid");
        a.f.b.j.p(str, "<set-?>");
        preloadSession.jSY = str;
        com.tencent.mm.plugin.webview.preload.a.gu(sx.upQ, 104);
        ef bJ = bJ(preloadSession.url, preloadSession.jSV);
        if (bJ != null) {
            str = bJ.vFV;
            if (str != null) {
                if ((!a.k.u.ar((CharSequence) str) ? 1 : 0) == 1) {
                    Intent intent2 = new Intent();
                    String str2 = bJ.vFV;
                    a.f.b.j.o(str2, "appMsgContext.ForceUrl");
                    str2 = m.a(str2, preloadSession);
                    ab.i(TAG, "appMsgContext forceUrl:%s", str2);
                    intent2.putExtra("rawUrl", str2);
                    com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                    com.tencent.mm.plugin.webview.preload.a.gu(sx.upQ, 107);
                    aVar.success = false;
                    aVar.message = "has forceUrl=".concat(String.valueOf(str2));
                    AppMethodBeat.o(14922);
                    return true;
                }
            }
        }
        preloadSession.jSZ = true;
        chi sv = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.sv(sx.jSV);
        preloadSession.jTb = l.d(sv);
        boolean j = a.f.b.j.j(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix(), "mptmpl://");
        if (l.d(sv) && j) {
            z = true;
        } else {
            z = false;
        }
        preloadSession.jTc = z;
        if (!l.d(sv) || j) {
            z = false;
        } else {
            z = true;
        }
        preloadSession.jTd = z;
        if (bJ == null || !b.b(bJ)) {
            a((Object) context, preloadSession.url, preloadSession, (a.f.a.q) m.jTo);
        } else {
            preloadSession.jTa = true;
            if (preloadSession.jSV == 0) {
                String a = b.a(bJ);
                str = intent.getStringExtra("rawUrl");
                a.f.b.j.o(str, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
                String a2 = m.a(str, preloadSession);
                a.f.b.j.p(a, "contentId");
                a.f.b.j.p(a2, "url");
                i iVar2 = jSE;
                a.f.b.j.p(iVar2, "process");
                a.f.b.j.p(a, "contentId");
                a.f.b.j.p(a2, "url");
                Bundle bundle = new Bundle();
                bundle.putInt("tmplType", 0);
                bundle.putString("contentId", a);
                bundle.putString("url", a2);
                bundle.putLong("startLoadPage", System.currentTimeMillis());
                com.tencent.mm.ipcinvoker.f.a(iVar2.processName, bundle, g.class, null);
            }
            ab.i(TAG, "set contentId:%s", b.a(bJ));
        }
        str = com.tencent.mm.ui.e.m.ygf;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar2 = g.jSD;
        intent.putExtra(str, com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXe());
        intent.putExtra(com.tencent.mm.ui.e.m.ygg, System.currentTimeMillis());
        intent.putExtra(com.tencent.mm.ui.e.m.ygi, preloadSession.url);
        intent.putExtra(com.tencent.mm.ui.e.m.yge, sx);
        intent.putExtra(com.tencent.mm.ui.e.m.ygq, preloadSession);
        intent.putExtra(com.tencent.mm.ui.e.m.ygn, Process.myPid());
        try {
            intent.putExtra(com.tencent.mm.ui.e.m.ygm, d.a(context, (a.f.a.b) new v(iVar)));
            switch (i.eQZ[iVar.ordinal()]) {
                case 1:
                    str = "MM";
                    break;
                case 2:
                    str = "Tool";
                    break;
                case 3:
                    str = "TooLMp";
                    break;
                default:
                    str = "MM";
                    break;
            }
            com.tencent.mm.bp.d.b(context, "brandservice", ".ui.timeline.preload.ui.TmplWebView" + str + "UI", intent);
            com.tencent.mm.plugin.webview.preload.a.gu(sx.upQ, 106);
            com.tencent.mm.plugin.webview.preload.a.IU(100);
            if (preloadSession.jTb) {
                com.tencent.mm.plugin.webview.preload.a.gu(sx.upQ, 231);
                com.tencent.mm.plugin.webview.preload.a.IU(110);
            }
            AppMethodBeat.o(14922);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(14922);
            return false;
        }
    }

    private static void a(Bundle bundle, a.f.a.b<? super Bundle, y> bVar) {
        Object obj;
        AppMethodBeat.i(14928);
        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis2 = System.currentTimeMillis() % 100;
        ArrayList stringArrayList = bundle.getStringArrayList("urls");
        if (stringArrayList != null && stringArrayList.size() == 1) {
            obj = stringArrayList.get(0);
            a.f.b.j.o(obj, "urls[0]");
            String FJ = b.FJ((String) obj);
            if (aXq().containsKey(FJ)) {
                ConcurrentLinkedDeque concurrentLinkedDeque = (ConcurrentLinkedDeque) aXq().get(FJ);
                if (concurrentLinkedDeque != null) {
                    concurrentLinkedDeque.add(bVar);
                }
                ab.v(TAG, "terry trace cgi mounted:" + FJ + '#' + currentTimeMillis2);
                AppMethodBeat.o(14928);
                return;
            }
        }
        ArrayList integerArrayList = bundle.getIntegerArrayList("tmplTypes");
        int i = bundle.getInt("openScene");
        int i2 = bundle.getInt("strip", 0);
        int i3 = bundle.getInt("stripType", 0);
        LinkedList linkedList = new LinkedList();
        int size = stringArrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            linkedList.add(new android.support.v4.f.j(stringArrayList.get(i4), integerArrayList.get(i4)));
            obj = stringArrayList.get(i4);
            a.f.b.j.o(obj, "urls[i]");
            String FJ2 = b.FJ((String) obj);
            aXq().put(FJ2, new ConcurrentLinkedDeque());
            ab.v(TAG, "terry trace cgi send:" + FJ2 + '#' + currentTimeMillis2);
        }
        w.a(a((Iterable) linkedList, i, i2, i3).acD(), new u(currentTimeMillis, currentTimeMillis2, bVar, stringArrayList));
        AppMethodBeat.o(14928);
    }

    public static final /* synthetic */ int so(int i) {
        AppMethodBeat.i(14940);
        int i2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.sv(i).Version;
        AppMethodBeat.o(14940);
        return i2;
    }

    public static final /* synthetic */ void sp(int i) {
        i iVar;
        AppMethodBeat.i(14941);
        com.tencent.mm.cj.c.aNX();
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
        switch (h.aXn().getInt("preload_process", 4)) {
            case 1:
                iVar = i.Tool;
                break;
            case 2:
                iVar = i.ToolMP;
                break;
            case 3:
                iVar = i.MM;
                break;
            default:
                iVar = i.UNKNOW;
                break;
        }
        jSE = iVar;
        if (iVar == i.UNKNOW) {
            if (jSK == null) {
                com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100463");
                if (!ll.isValid()) {
                    ab.i(TAG, "webviewProcess item is null");
                    jSK = Integer.valueOf(jSJ);
                }
                a.f.b.j.o(ll, "item");
                jSK = Integer.valueOf(bo.getInt((String) ll.dru().get("webviewProcess"), jSJ));
                ab.i(TAG, "webviewProcess %d", jSK);
            }
            Integer num = jSK;
            int i2 = jSH;
            if (num != null && num.intValue() == i2) {
                iVar = i.Tool;
            } else {
                i2 = jSG;
                if (num == null || num.intValue() != i2) {
                    i2 = jSI;
                    if (num != null && num.intValue() == i2) {
                        iVar = i.MM;
                    }
                }
                iVar = i.ToolMP;
            }
            jSE = iVar;
        }
        ab.i(TAG, "[initDefaultProcess]DEFAULT_PROCESS:%s", jSE);
        a(jSE, i);
        AppMethodBeat.o(14941);
    }

    public static final /* synthetic */ int sq(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }
}
