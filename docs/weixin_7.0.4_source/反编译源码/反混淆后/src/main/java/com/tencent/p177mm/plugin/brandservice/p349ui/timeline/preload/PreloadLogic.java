package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

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
import android.support.p057v4.p065f.C0415j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCInteger;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b.C20024a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C33739g.C33740a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p1476a.C45764c;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b.C20082b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.C45765c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.plugin.webview.preload.C43926c;
import com.tencent.p177mm.plugin.webview.preload.TmplParams;
import com.tencent.p177mm.protocal.protobuf.C40515ef;
import com.tencent.p177mm.protocal.protobuf.C44128hy;
import com.tencent.p177mm.protocal.protobuf.C44129hz;
import com.tencent.p177mm.protocal.protobuf.bsq;
import com.tencent.p177mm.protocal.protobuf.bui;
import com.tencent.p177mm.protocal.protobuf.chi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C5141c;
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
import kotlinx.coroutines.C24594i;
import kotlinx.coroutines.C31186aj;
import kotlinx.coroutines.C31195q;
import kotlinx.coroutines.C36622ac;
import kotlinx.coroutines.C36624ah;
import kotlinx.coroutines.C36629bm;
import kotlinx.coroutines.C36637f;
import kotlinx.coroutines.C41154ao;
import kotlinx.coroutines.C41155ap;
import kotlinx.coroutines.C41157bc;
import kotlinx.coroutines.C41157bc.C16454a;
import kotlinx.coroutines.C41361bl;
import kotlinx.coroutines.C44611aw;
import kotlinx.coroutines.C44619j;
import kotlinx.coroutines.C44621l;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C37088p.C37089b;
import p000a.C37091y;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C44628q;
import p000a.p001a.C7987l;
import p000a.p002c.C36927c;
import p000a.p002c.C41366e;
import p000a.p002c.C41366e.C41367b;
import p000a.p002c.C46863d;
import p000a.p002c.p003b.p004a.C25045g;
import p000a.p002c.p003b.p004a.C31589d;
import p000a.p002c.p773a.C25040a;
import p000a.p002c.p773a.C25042c;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C31598x;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p051k.C25274k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Ù\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a*\u0001'\bÆ\u0002\u0018\u00002\u00020\u0001:\u0010|}~\u0001\u0001\u0001\u0001\u0001\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0012\u0010:\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010;\"\u00020\u0001H\u0007¢\u0006\u0002\u0010<J>\u0010=\u001a\u00020\u001a2\u0018\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?012\u0006\u00109\u001a\u00020\b2\b\b\u0002\u0010@\u001a\u00020\b2\b\b\u0002\u0010A\u001a\u00020\bH\u0002J\u0010\u0010B\u001a\u00020#2\u0006\u00109\u001a\u00020\bH\u0007J\b\u0010C\u001a\u00020\u001aH\u0002J\u0016\u0010D\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\b2\u0006\u0010E\u001a\u00020\rJ\b\u0010F\u001a\u00020\u001aH\u0002JF\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u00012\u0006\u00107\u001a\u00020\r2\u0006\u0010I\u001a\u00020J2&\b\u0002\u0010K\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010M\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020\u001a0LJ\u0018\u0010G\u001a\u0004\u0018\u00010O2\u0006\u00107\u001a\u00020\r2\u0006\u0010P\u001a\u00020\bJ:\u0010Q\u001a\u00020R2\u0018\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?0S2\u0006\u00109\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0002J\u0010\u0010T\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0002J\b\u0010U\u001a\u00020\u001aH\u0002J\u0010\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020\bH\u0002J$\u0010X\u001a\u00020\u001a2\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r01012\u0006\u00109\u001a\u00020\bH\u0007J$\u0010Z\u001a\u00020\u001a2\u0012\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0;012\u0006\u00109\u001a\u00020\bH\u0007J\b\u0010[\u001a\u00020\u001aH\u0007J\u0018\u0010\\\u001a\u00020\u001a2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\bH\u0007J\b\u0010]\u001a\u00020\u0004H\u0002J\b\u0010^\u001a\u00020\u001aH\u0002J\u0010\u0010_\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\rH\u0007JX\u0010`\u001a\u00020\u001a2\u0018\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?012\u0006\u00109\u001a\u00020\b2\b\b\u0002\u0010@\u001a\u00020\b2\b\b\u0002\u0010A\u001a\u00020\b2\u0018\u0010K\u001a\u0014\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\u001a0aH\u0002J\u0010\u0010c\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\bH\u0007J3\u0010d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00162!\u0010K\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0015H\u0002J*\u0010e\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00162\u0018\u0010K\u001a\u0014\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\u001a0aH\u0002J \u0010f\u001a\u00020\u001a2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0002J\u0010\u0010f\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\bH\u0002J0\u0010g\u001a\u00020#2\u0006\u0010H\u001a\u00020h2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010i\u001a\u00020j2\u0006\u0010I\u001a\u00020J2\u0006\u0010k\u001a\u00020lH\u0002JN\u0010g\u001a\u00020#2\u0006\u0010H\u001a\u00020h2\u0006\u0010m\u001a\u00020\r2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\u0006\u0010n\u001a\u00020\b2\b\b\u0002\u0010i\u001a\u00020j2\b\b\u0002\u0010o\u001a\u00020\b2\b\b\u0002\u0010k\u001a\u00020lH\u0007J(\u0010p\u001a\u00020\u001a2\u0006\u0010]\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\b2\u0006\u0010q\u001a\u00020\r2\u0006\u00107\u001a\u00020\rH\u0007J\u0018\u0010p\u001a\u00020\u001a2\u0006\u0010q\u001a\u00020\r2\u0006\u00107\u001a\u00020\rH\u0007J\u0018\u0010r\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?H\u0002J\u0018\u0010s\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0?H\u0002J;\u0010t\u001a\u0002Hu\"\u000e\b\u0000\u0010v*\b\u0012\u0004\u0012\u0002Hu01\"\b\b\u0001\u0010u*\u00020\u0001*\u0002Hv2\u0006\u0010w\u001a\u00020\b2\u0006\u0010x\u001a\u0002HuH\u0002¢\u0006\u0002\u0010yJ\f\u0010z\u001a\u00020\b*\u00020\bH\u0002J\f\u0010{\u001a\u00020\b*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011RH\u0010\u0012\u001a/\u0012\u0004\u0012\u00020\r\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u00150\u00140\u00138FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#`$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R!\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\r0+j\b\u0012\u0004\u0012\u00020\r`,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010100X\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u00103R\u000e\u00104\u001a\u00020#XD¢\u0006\u0002\n\u0000¨\u0006\u0001"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic;", "", "()V", "DEFAULT_PROCESS", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$Process;", "DELAY_TIME", "", "PROCESS_DEFAULT", "", "PROCESS_MM", "PROCESS_TOOLS", "PROCESS_TOOLSMP", "TAG", "", "caches", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "getCaches", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "cgiCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "getCgiCallbackList", "()Ljava/util/concurrent/ConcurrentHashMap;", "cgiCallbackList$delegate", "Lkotlin/Lazy;", "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPreloadOpen", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isRunning", "keys", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1;", "lastPreloadId", "preloadLimiter", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPreloadLimiter", "()Ljava/util/HashSet;", "preloadUrl", "Ljava/util/Queue;", "", "sProcess", "Ljava/lang/Integer;", "stopPreload", "addToPreload", "id", "url", "itemShowType", "openScene", "params", "", "(JLjava/lang/String;II[Ljava/lang/Object;)V", "batchSyncAppMsgContext", "reqList", "Landroid/support/v4/util/Pair;", "strip", "stripType", "canPreloadIn", "checkReportIfNeed", "checkTmplVer", "netType", "clear", "getAppMsgContext", "context", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "callback", "Lkotlin/Function3;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "tmplType", "getBuilder", "Lcom/tencent/mm/modelbase/CommReqResp$Builder;", "", "getTmplVersion", "initDefaultProcess", "obtainTmplType", "bizTimeLineType", "preloadByIdAndUrls", "items", "preloadByInfoIdAndBuffer", "preloadNextWebView", "preloadWebview", "process", "report", "reportWithRetry", "requestAppMsg", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "run", "runCGI", "runCGICallback", "runInner", "startPreloadWebView", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "rawUrl", "subScene", "openType", "updateWebview", "contentId", "getTmplType", "getUrl", "safeGet", "C", "T", "index", "default", "(Ljava/util/List;ILjava/lang/Object;)Ljava/lang/Object;", "toPreloadScene", "toReportScene", "AppMsgContextCache", "IPCInvoke_CheckReport", "IPCInvoke_CheckTmplVer", "IPCInvoke_PreloadWebview", "IPCInvoke_RUN_CGI", "IPCInvoke_Report", "IPCInvoke_UpdateWebview", "MountableCGIResult", "PreloadSession", "Process", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic */
public final class PreloadLogic {
    private static final String TAG = TAG;
    private static final AtomicBoolean cnu = new AtomicBoolean(false);
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(PreloadLogic.class), "cgiCallbackList", "getCgiCallbackList()Ljava/util/concurrent/ConcurrentHashMap;"))};
    private static final HashSet<String> jKh = new HashSet();
    private static C20075i jSE = C20075i.ToolMP;
    private static final AtomicBoolean jSF = new AtomicBoolean(false);
    private static final int jSG = 0;
    private static final int jSH = 1;
    private static final int jSI = 2;
    private static final int jSJ = jSG;
    private static Integer jSK;
    private static final C20076o jSL = new C20076o();
    private static final HashMap<Integer, Boolean> jSM = new HashMap();
    private static final C11247a jSN = new C11247a();
    private static final C44856f jSO = C17344i.m26854g(C20069l.jTn);
    private static long jSP;
    private static Queue<List<Object>> jSQ = new LinkedList();
    private static final boolean jSR = false;
    public static final PreloadLogic jSS = new PreloadLogic();

    @C31589d(c = "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$addToPreload$1", dWy = {898, 906}, f = "PreloadLogic.kt", m = "invokeSuspend")
    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$j */
    static final class C2699j extends C25045g implements C31591m<C36622ac, C36927c<? super C37091y>, Object> {
        final /* synthetic */ long jKi;
        final /* synthetic */ String jKj;
        final /* synthetic */ int jKk;
        final /* synthetic */ int jKl;
        private C36622ac jTk;
        final /* synthetic */ Object[] jTl;
        int label;

        C2699j(long j, String str, int i, int i2, Object[] objArr, C36927c c36927c) {
            this.jKi = j;
            this.jKj = str;
            this.jKk = i;
            this.jKl = i2;
            this.jTl = objArr;
            super(c36927c);
        }

        /* renamed from: a */
        public final C36927c<C37091y> mo42a(Object obj, C36927c<?> c36927c) {
            AppMethodBeat.m2504i(14883);
            C25052j.m39376p(c36927c, "completion");
            C2699j c2699j = new C2699j(this.jKi, this.jKj, this.jKk, this.jKl, this.jTl, c36927c);
            c2699j.jTk = (C36622ac) obj;
            AppMethodBeat.m2505o(14883);
            return c2699j;
        }

        /* renamed from: m */
        public final Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(14884);
            Object bO = ((C2699j) mo42a(obj, (C36927c) obj2)).mo43bO(C37091y.AUy);
            AppMethodBeat.m2505o(14884);
            return bO;
        }

        /* JADX WARNING: Missing block: B:67:0x0198, code skipped:
            r0 = p000a.p001a.C25035t.m39351l(r1);
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
            r0 = new p000a.C44941v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(14882);
     */
        /* JADX WARNING: Missing block: B:81:0x0201, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:83:0x020c, code skipped:
            if (r3.add(com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2702b.m4922FJ((java.lang.String) r0)) == false) goto L_0x01e0;
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
            r1 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
            r3 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31039sq(r10.jKl);
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
            r5 = com.tencent.p177mm.plugin.report.service.C7060h.pYm;
            r7 = new java.lang.Object[11];
            r7[0] = java.lang.Integer.valueOf(r3);
            r8 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
            r7[1] = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31010a(r1, 3, (java.lang.Object) "");
            r2 = r1.get(0);
     */
        /* JADX WARNING: Missing block: B:93:0x025a, code skipped:
            if (r2 != null) goto L_0x026a;
     */
        /* JADX WARNING: Missing block: B:94:0x025c, code skipped:
            r0 = new p000a.C44941v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(14882);
     */
        /* JADX WARNING: Missing block: B:95:0x0269, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:96:0x026a, code skipped:
            r7[2] = com.tencent.p177mm.compatible.util.C18178q.encode((java.lang.String) r2);
            r8 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
            r7[3] = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31010a(r1, 4, (java.lang.Object) "");
            r8 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
            r7[4] = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31010a(r1, 5, (java.lang.Object) "");
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
            r0 = new p000a.C44941v("null cannot be cast to non-null type kotlin.Int");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(14882);
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
            r0 = new p000a.C44941v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(14882);
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
            r1 = java.lang.Boolean.valueOf(com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C27540m.m43707FW(r1));
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
            r5.mo8381e(16468, r7);
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
            r1 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
     */
        /* JADX WARNING: Missing block: B:119:0x0318, code skipped:
            if (com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31033rW(com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31040sr(r10.jKl)) == false) goto L_0x0434;
     */
        /* JADX WARNING: Missing block: B:120:0x031a, code skipped:
            r3 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C2702b.m4935sk(r10.jKl);
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
            r0 = new p000a.C44941v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(14882);
     */
        /* JADX WARNING: Missing block: B:126:0x034e, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:128:0x0355, code skipped:
            if (com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C27540m.m43707FW((java.lang.String) r0) != false) goto L_0x035e;
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
            r0 = new java.util.ArrayList(p000a.p001a.C25034m.m39318d(r1));
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
            r0 = new p000a.C44941v("null cannot be cast to non-null type kotlin.String");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(14882);
     */
        /* JADX WARNING: Missing block: B:139:0x0396, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:140:0x0397, code skipped:
            r1 = (java.lang.String) r1;
            r6 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
            r2 = r2.get(1);
     */
        /* JADX WARNING: Missing block: B:141:0x03a0, code skipped:
            if (r2 != null) goto L_0x03b0;
     */
        /* JADX WARNING: Missing block: B:142:0x03a2, code skipped:
            r0 = new p000a.C44941v("null cannot be cast to non-null type kotlin.Int");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(14882);
     */
        /* JADX WARNING: Missing block: B:143:0x03af, code skipped:
            throw r0;
     */
        /* JADX WARNING: Missing block: B:144:0x03b0, code skipped:
            r0.add(new android.support.p057v4.p065f.C0415j(r1, java.lang.Integer.valueOf(com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31036sn(((java.lang.Integer) r2).intValue()))));
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
            r0 = (android.support.p057v4.p065f.C0415j) r2;
            r5 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
     */
        /* JADX WARNING: Missing block: B:149:0x03eb, code skipped:
            if (com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C27540m.m43703FC(com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31027c(r0)) == false) goto L_0x0405;
     */
        /* JADX WARNING: Missing block: B:150:0x03ed, code skipped:
            r5 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
            r5 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.aXp();
            r6 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
            r6 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31027c(r0);
            r7 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
     */
        /* JADX WARNING: Missing block: B:151:0x0403, code skipped:
            if (r5.mo22946bK(r6, com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31028d(r0)) == false) goto L_0x040c;
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
            r1 = p000a.p001a.C25035t.m39324a((java.lang.Iterable) r1, r3);
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
            r0 = com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.jSS;
            com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic.m31017a(r1, r10.jKl, r2, 2);
     */
        /* JADX WARNING: Missing block: B:161:0x0434, code skipped:
            r0 = p000a.C37091y.AUy;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(14882);
     */
        /* JADX WARNING: Missing block: B:162:0x043d, code skipped:
            r0 = null;
     */
        /* JADX WARNING: Missing block: B:192:?, code skipped:
            return r0;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: bO */
        public final Object mo43bO(Object obj) {
            PreloadLogic preloadLogic;
            Object obj2;
            AppMethodBeat.m2504i(14882);
            C37091y c37091y = C25040a.COROUTINE_SUSPENDED;
            Throwable th;
            switch (this.label) {
                case 0:
                    if (obj instanceof C37089b) {
                        th = ((C37089b) obj).AUq;
                        AppMethodBeat.m2505o(14882);
                        throw th;
                    }
                    C37091y c37091y2;
                    preloadLogic = PreloadLogic.jSS;
                    synchronized (PreloadLogic.jSQ) {
                        try {
                            preloadLogic = PreloadLogic.jSS;
                            PreloadLogic.jSP = this.jKi;
                            preloadLogic = PreloadLogic.jSS;
                            Queue aXv = PreloadLogic.jSQ;
                            C31598x c31598x = new C31598x(4);
                            c31598x.add(this.jKj);
                            c31598x.add(Integer.valueOf(this.jKk));
                            c31598x.add(Integer.valueOf(this.jKl));
                            c31598x.mo51593do(this.jTl);
                            Boolean.valueOf(aXv.add(C7987l.m14170U(c31598x.toArray(new Object[c31598x.ckx.size()]))));
                        } finally {
                            AppMethodBeat.m2505o(14882);
                        }
                    }
                    this.label = 1;
                    if (1000 <= 0) {
                        c37091y2 = C37091y.AUy;
                    } else {
                        C44619j c44619j = new C44619j(C25042c.m39365c(this));
                        C41157bc c41157bc = (C41157bc) c44619j.BPv.dWv().get(C41157bc.BQx);
                        if ((c44619j.BPu == null ? 1 : null) == null) {
                            th = new IllegalStateException("Check failed.".toString());
                            AppMethodBeat.m2505o(14882);
                            throw th;
                        }
                        if (c41157bc == null) {
                            c44619j.BPu = C41361bl.BQP;
                        } else {
                            c41157bc.start();
                            C41155ap a = C16454a.m25237a(c41157bc, true, false, new C44621l(c41157bc, c44619j), 2);
                            c44619j.BPu = a;
                            if (c44619j.BPs instanceof C36629bm) {
                                obj2 = null;
                            } else {
                                obj2 = 1;
                            }
                            if (obj2 != null) {
                                a.dispose();
                                c44619j.BPu = C41361bl.BQP;
                            }
                        }
                        C24594i c24594i = c44619j;
                        C41366e dWv = c24594i.dWv();
                        C25052j.m39376p(dWv, "receiver$0");
                        C41367b c41367b = dWv.get(C46863d.AVd);
                        if (!(c41367b instanceof C31186aj)) {
                            c41367b = null;
                        }
                        C31186aj c31186aj = (C31186aj) c41367b;
                        if (c31186aj == null) {
                            c31186aj = C36624ah.elh();
                        }
                        c31186aj.mo30314a(c24594i);
                        if (c44619j.ekP()) {
                            c37091y2 = C25040a.COROUTINE_SUSPENDED;
                        } else {
                            obj2 = c44619j.BPs;
                            if (obj2 instanceof C31195q) {
                                th = ((C31195q) obj2).cause;
                                AppMethodBeat.m2505o(14882);
                                throw th;
                            }
                            c37091y2 = c44619j.mo71482ec(obj2);
                        }
                        if (c37091y2 == C25040a.COROUTINE_SUSPENDED) {
                            C25052j.m39376p(this, "frame");
                        }
                    }
                    if (c37091y2 == c37091y) {
                        return c37091y;
                    }
                    break;
                case 1:
                    if (obj instanceof C37089b) {
                        th = ((C37089b) obj).AUq;
                        AppMethodBeat.m2505o(14882);
                        throw th;
                    }
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.m2505o(14882);
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
                    obj2 = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(14882);
                }
            }
            return obj2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$k */
    static final class C2700k extends C25053k implements C31591m<C20072h, C44129hz, C37091y> {
        final /* synthetic */ List jTm;

        C2700k(List list) {
            this.jTm = list;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            Integer num = null;
            AppMethodBeat.m2504i(14885);
            C20072h c20072h = (C20072h) obj;
            C44129hz c44129hz = (C44129hz) obj2;
            C25052j.m39376p(c20072h, "result");
            C25052j.m39376p(c44129hz, "response");
            if (c20072h.cxT) {
                PreloadLogic preloadLogic = PreloadLogic.jSS;
                String aXu = PreloadLogic.TAG;
                StringBuilder stringBuilder = new StringBuilder("response.AppMsgContextList size:");
                LinkedList linkedList = c44129hz.vKx;
                C4990ab.m7416i(aXu, stringBuilder.append(linkedList != null ? Integer.valueOf(linkedList.size()) : null).toString());
                C43926c c43926c = new C43926c();
                c43926c.startTime = c20072h.start;
                List list = this.jTm;
                if (list != null) {
                    num = Integer.valueOf(list.size());
                }
                c43926c.exv = num.intValue();
                LinkedList<C40515ef> linkedList2 = c44129hz.vKx;
                if (linkedList2 != null) {
                    for (C40515ef c40515ef : linkedList2) {
                        if (c40515ef != null) {
                            String str = c40515ef.Url;
                            if (str != null && C27540m.m43703FC(str)) {
                                PreloadLogic preloadLogic2 = PreloadLogic.jSS;
                                String aXu2 = PreloadLogic.TAG;
                                StringBuilder append = new StringBuilder("appMsgContext url:").append(c40515ef.Url).append(" content:");
                                str = c40515ef.ncM;
                                C4990ab.m7418v(aXu2, append.append(str != null ? str.length() : 0).append(" clientCacheTime:").append(c40515ef.vFU).append(" forceUrl:").append(c40515ef.vFV).append(" lastModifyTime:").append(c40515ef.vFW).append(" noNeedUpdate:").append(c40515ef.vFX).toString());
                                preloadLogic2 = PreloadLogic.jSS;
                                C11247a aXp = PreloadLogic.aXp();
                                aXu2 = c40515ef.Url;
                                C25052j.m39375o(aXu2, "Url");
                                aXp.mo22945a(aXu2, c40515ef);
                                if (!c20072h.jRW) {
                                    if (c40515ef.vFX) {
                                        c43926c.cYR();
                                        C43924a.m78793kT(31);
                                    } else {
                                        c43926c.cYQ();
                                        C43924a.m78793kT(32);
                                    }
                                    c43926c.mo69612IV(c40515ef.computeSize());
                                }
                                preloadLogic2 = PreloadLogic.jSS;
                                C4990ab.m7410d(PreloadLogic.TAG, "terry trace: preloaded " + c40515ef.Url);
                            }
                        }
                        preloadLogic = PreloadLogic.jSS;
                        C4990ab.m7412e(PreloadLogic.TAG, "batchSyncAppMsgContext no Url response");
                    }
                }
                c43926c.mo69611IF();
            }
            if (!c20072h.jRW) {
                int i;
                C43924a.m78793kT(23);
                C43924a.m78792gv(26, this.jTm.size());
                if (c20072h.cxT) {
                    i = 24;
                } else {
                    i = 25;
                }
                C43924a.m78793kT(i);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(14885);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\u0006J\u0013\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$AppMsgContextCache;", "", "()V", "TAG", "", "checkValid", "", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "lowerVersion", "", "clear", "get", "url", "has", "tmplType", "save", "", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$a */
    public static final class C11247a {
        private final String TAG = "MicroMsg.Preload.BizAppMsgContextCache";

        /* renamed from: bK */
        public final boolean mo22946bK(String str, int i) {
            AppMethodBeat.m2504i(14860);
            C25052j.m39376p(str, "url");
            C40515ef FP = mo22944FP(str);
            if (FP == null) {
                AppMethodBeat.m2505o(14860);
                return false;
            }
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            int sn = PreloadLogic.m31036sn((FP != null ? Integer.valueOf(FP.vGc) : null).intValue());
            if (sn != -1) {
                i = sn;
            }
            preloadLogic = PreloadLogic.jSS;
            boolean a = m18961a(FP, PreloadLogic.m31037so(i));
            if (!a) {
                C4990ab.m7410d(this.TAG, "init valid:" + C2702b.m4921FI(str));
            }
            AppMethodBeat.m2505o(14860);
            return a;
        }

        /* renamed from: FP */
        public final C40515ef mo22944FP(String str) {
            AppMethodBeat.m2504i(14861);
            C25052j.m39376p(str, "url");
            String FI = C2702b.m4921FI(str);
            C5018as FL = C2702b.m4924FL(FI);
            if (FL != null) {
                C40515ef c40515ef = new C40515ef();
                try {
                    c40515ef.parseFrom(FL.decodeBytes(FI));
                    c40515ef.Url = str;
                    C4990ab.m7416i(this.TAG, "found:" + FI + " last modify:" + c40515ef.vFW);
                    AppMethodBeat.m2505o(14861);
                    return c40515ef;
                } catch (IOException e) {
                    C4990ab.printErrStackTrace(this.TAG, e, "get:".concat(String.valueOf(FI)), new Object[0]);
                }
            }
            C4990ab.m7416i(this.TAG, "not found:".concat(String.valueOf(FI)));
            AppMethodBeat.m2505o(14861);
            return null;
        }

        /* renamed from: a */
        private final boolean m18961a(C40515ef c40515ef, int i) {
            AppMethodBeat.m2504i(14862);
            if (c40515ef == null) {
                C4990ab.m7418v(this.TAG, "checkValid: null");
                AppMethodBeat.m2505o(14862);
                return false;
            } else if (c40515ef.vFY == 0 || c40515ef.vFY >= i) {
                C33740a c33740a = C33739g.jSD;
                if (C33740a.aXh()) {
                    C4990ab.m7416i(this.TAG, "checkValid: debug to expire");
                } else {
                    boolean a;
                    String str = c40515ef.Url;
                    C25052j.m39375o(str, "appMsgContext.Url");
                    str = C2702b.m4923FK(str);
                    C5018as FL = C2702b.m4924FL(str);
                    if (FL != null) {
                        a = C2710d.m4957a(FL, str, ((long) c40515ef.vFU) * 1000);
                    } else {
                        a = true;
                    }
                    if (a) {
                        C4990ab.m7416i(this.TAG, "checkValid: expire for " + c40515ef.vFU);
                        AppMethodBeat.m2505o(14862);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(14862);
                return true;
            } else {
                C4990ab.m7418v(this.TAG, "checkValid: lower version:data(" + c40515ef.vFY + ") < require(" + i + ')');
                AppMethodBeat.m2505o(14862);
                return false;
            }
        }

        /* renamed from: a */
        public final void mo22945a(String str, C40515ef c40515ef) {
            byte[] bArr = null;
            AppMethodBeat.m2504i(14863);
            C25052j.m39376p(str, "url");
            if (c40515ef == null) {
                C4990ab.m7412e(this.TAG, "save fail, appMsgContext is null");
                AppMethodBeat.m2505o(14863);
                return;
            }
            String FI = C2702b.m4921FI(str);
            C5018as aWO = C2702b.aWO();
            String str2 = c40515ef.ncM;
            try {
                bArr = c40515ef.toByteArray();
                C40515ef c40515ef2 = new C40515ef();
                c40515ef2.parseFrom(bArr);
                c40515ef2.ncM = null;
                bArr = c40515ef2.toByteArray();
            } catch (IOException e) {
                C4990ab.printErrStackTrace(this.TAG, e, "save ".concat(String.valueOf(FI)), new Object[0]);
            }
            if (bArr != null) {
                aWO.encode(FI, bArr);
                if (str2 != null) {
                    aWO.putString(C2702b.m4922FJ(str), str2);
                }
                C2710d.m4955a(aWO, C2702b.m4923FK(str));
            }
            C4990ab.m7416i(this.TAG, "save " + FI + " last modify:" + c40515ef.vFW);
            AppMethodBeat.m2505o(14863);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_CheckReport;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "type", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$b */
    static final class C11248b implements C37866a<IPCVoid, IPCVoid> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(14864);
            C45764c.aXs();
            AppMethodBeat.m2505o(14864);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$run$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$t */
    public static final class C11250t implements IdleHandler {
        final /* synthetic */ int jKl;

        C11250t(int i) {
            this.jKl = i;
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(14910);
            Looper.myQueue().removeIdleHandler(this);
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            PreloadLogic.m31038sp(this.jKl);
            preloadLogic = PreloadLogic.jSS;
            PreloadLogic.jSF.set(false);
            AppMethodBeat.m2505o(14910);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_PreloadWebview;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "type", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$d */
    static final class C20064d implements C37866a<IPCInteger, IPCVoid> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(14866);
            C25052j.m39376p((IPCInteger) obj, "type");
            C45765c.aVR();
            AppMethodBeat.m2505o(14866);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/ref/WeakReference;", "", "<anonymous parameter 1>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "<anonymous parameter 2>", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$m */
    static final class C20065m extends C25053k implements C36933q<WeakReference<Object>, C20072h, C40515ef, C37091y> {
        public static final C20065m jTo = new C20065m();

        static {
            AppMethodBeat.m2504i(14889);
            AppMethodBeat.m2505o(14889);
        }

        C20065m() {
            super(3);
        }

        /* renamed from: g */
        public final /* synthetic */ Object mo9028g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(14888);
            C20072h c20072h = (C20072h) obj2;
            C40515ef c40515ef = (C40515ef) obj3;
            C25052j.m39376p((WeakReference) obj, "<anonymous parameter 0>");
            C25052j.m39376p(c20072h, "<anonymous parameter 1>");
            C25052j.m39376p(c40515ef, "<anonymous parameter 2>");
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(14888);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$v */
    static final class C20066v extends C25053k implements C17126b<RunningAppProcessInfo, Boolean> {
        final /* synthetic */ C20075i jTw;

        C20066v(C20075i c20075i) {
            this.jTw = c20075i;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(14912);
            RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) obj;
            C25052j.m39376p(runningAppProcessInfo, "it");
            Boolean valueOf = Boolean.valueOf(C25052j.m39373j(runningAppProcessInfo.processName, this.jTw.processName));
            AppMethodBeat.m2505o(14912);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_CheckTmplVer;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$c */
    static final class C20067c implements C37866a<Bundle, IPCVoid> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(14865);
            Bundle bundle = (Bundle) obj;
            C25052j.m39376p(bundle, "bundle");
            int i = bundle.getInt("openScene", Downloads.MIN_WAIT_FOR_NETWORK);
            String string = bundle.getString(DownloadInfo.NETTYPE, "unknown");
            C25052j.m39375o(string, DownloadInfo.NETTYPE);
            C20082b.m31058a(i, string, new int[0]);
            AppMethodBeat.m2505o(14865);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$s */
    static final class C20068s<T> implements C18507c<ResultType> {
        final /* synthetic */ C31591m jTs;

        C20068s(C31591m c31591m) {
            this.jTs = c31591m;
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(14909);
            Bundle bundle = (Bundle) obj;
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            C25052j.m39375o(bundle, "bundle");
            PreloadLogic.m31014a(bundle, this.jTs);
            AppMethodBeat.m2505o(14909);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a/\u0012\u0004\u0012\u00020\u0002\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00040\u00030\u0001H\n¢\u0006\u0002\b\n"}, dWq = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ParameterName;", "name", "bundle", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$l */
    static final class C20069l extends C25053k implements C31214a<ConcurrentHashMap<String, ConcurrentLinkedDeque<C17126b<? super Bundle, ? extends C37091y>>>> {
        public static final C20069l jTn = new C20069l();

        static {
            AppMethodBeat.m2504i(14887);
            AppMethodBeat.m2505o(14887);
        }

        C20069l() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14886);
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            AppMethodBeat.m2505o(14886);
            return concurrentHashMap;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_RUN_CGI;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$e */
    static final class C20070e implements C37866a<Bundle, Bundle> {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$e$a */
        static final class C11249a extends C25053k implements C17126b<Bundle, C37091y> {
            final /* synthetic */ C18507c jST;

            C11249a(C18507c c18507c) {
                this.jST = c18507c;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(14867);
                Bundle bundle = (Bundle) obj;
                C25052j.m39376p(bundle, "it");
                this.jST.mo5960ao(bundle);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(14867);
                return c37091y;
            }
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(14868);
            Bundle bundle = (Bundle) obj;
            C25052j.m39376p(bundle, "bundle");
            C25052j.m39376p(c18507c, "callback");
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            PreloadLogic.m31025b(bundle, new C11249a(c18507c));
            AppMethodBeat.m2505o(14868);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_UpdateWebview;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$g */
    static final class C20071g implements C37866a<Bundle, IPCVoid> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(14870);
            Bundle bundle = (Bundle) obj;
            C25052j.m39376p(bundle, "bundle");
            int i = bundle.getInt("tmplType");
            String string = bundle.getString("contentId");
            String string2 = bundle.getString("url");
            long j = bundle.getLong("startLoadPage");
            C25052j.m39375o(string, "contentId");
            C25052j.m39375o(string2, "url");
            C45765c.m84592a(i, string, string2, j);
            AppMethodBeat.m2505o(14870);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\r¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "", "isSuccess", "", "start", "", "end", "isMounted", "isCached", "(ZJJZZ)V", "getEnd", "()J", "setEnd", "(J)V", "()Z", "setCached", "(Z)V", "setMounted", "setSuccess", "getStart", "setStart", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$h */
    public static final class C20072h {
        public long aZV;
        public boolean cxT;
        public boolean jRW;
        public boolean jSU;
        public long start;

        private C20072h(boolean z, long j, long j2, boolean z2) {
            this.cxT = z;
            this.start = j;
            this.aZV = j2;
            this.jRW = z2;
            this.jSU = false;
        }

        public /* synthetic */ C20072h(boolean z, long j, long j2, boolean z2, byte b) {
            this(z, j, j2, z2);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, dWq = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$u */
    static final class C20073u implements C1224a {
        final /* synthetic */ C17126b exI;
        final /* synthetic */ long jTt;
        final /* synthetic */ long jTu;
        final /* synthetic */ ArrayList jTv;

        C20073u(long j, long j2, C17126b c17126b, ArrayList arrayList) {
            this.jTt = j;
            this.jTu = j2;
            this.exI = c17126b;
            this.jTv = arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x00f7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            long currentTimeMillis;
            PreloadLogic preloadLogic;
            ArrayList<String> arrayList;
            AppMethodBeat.m2504i(14911);
            PreloadLogic preloadLogic2 = PreloadLogic.jSS;
            C4990ab.m7417i(PreloadLogic.TAG, "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            Bundle bundle = new Bundle();
            if (i == 0 && i2 == 0) {
                C25052j.m39375o(c7472b, "rr");
                if (c7472b.acA() != null && (c7472b.acA() instanceof C44129hz)) {
                    C1331a acA = c7472b.acA();
                    if (acA == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BatchGetAppMsgResp");
                        AppMethodBeat.m2505o(14911);
                        throw c44941v;
                    }
                    C44129hz c44129hz = (C44129hz) acA;
                    bundle.putBoolean("success", true);
                    bundle.putByteArray("response", c44129hz.toByteArray());
                    LinkedList linkedList = c44129hz.vKy;
                    C25052j.m39375o(linkedList, "response.SceneControlList");
                    if ((!((Collection) linkedList).isEmpty() ? 1 : null) != null) {
                        bui bui = new bui();
                        bui.vKy = c44129hz.vKy;
                        C20086l.aXy().encode("_msg_scene_strip", bui.toByteArray());
                    }
                    bundle.putLong("start", this.jTt);
                    currentTimeMillis = System.currentTimeMillis();
                    bundle.putLong("end", currentTimeMillis);
                    preloadLogic = PreloadLogic.jSS;
                    C4990ab.m7418v(PreloadLogic.TAG, "terry performance runCGI #" + this.jTu + ": " + this.jTt + ',' + currentTimeMillis);
                    this.exI.mo50am(bundle);
                    bundle.putBoolean("mount", true);
                    arrayList = this.jTv;
                    C25052j.m39375o(arrayList, "urls");
                    for (String str2 : arrayList) {
                        C25052j.m39375o(str2, "url");
                        String FJ = C2702b.m4922FJ(str2);
                        preloadLogic2 = PreloadLogic.jSS;
                        ConcurrentLinkedDeque<C17126b> concurrentLinkedDeque = (ConcurrentLinkedDeque) PreloadLogic.aXq().get(FJ);
                        PreloadLogic preloadLogic3 = PreloadLogic.jSS;
                        PreloadLogic.aXq().remove(FJ);
                        if (concurrentLinkedDeque != null) {
                            for (C17126b c17126b : concurrentLinkedDeque) {
                                bundle.putString("id", FJ);
                                c17126b.mo50am(bundle);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(14911);
                    return 0;
                }
            }
            bundle.putBoolean("success", false);
            bundle.putLong("start", this.jTt);
            currentTimeMillis = System.currentTimeMillis();
            bundle.putLong("end", currentTimeMillis);
            preloadLogic = PreloadLogic.jSS;
            C4990ab.m7418v(PreloadLogic.TAG, "terry performance runCGI #" + this.jTu + ": " + this.jTt + ',' + currentTimeMillis);
            this.exI.mo50am(bundle);
            bundle.putBoolean("mount", true);
            arrayList = this.jTv;
            C25052j.m39375o(arrayList, "urls");
            for (String str22 : arrayList) {
            }
            AppMethodBeat.m2505o(14911);
            return 0;
        }
    }

    @C31589d(c = "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$preloadByIdAndUrls$1", dWy = {995}, f = "PreloadLogic.kt", m = "invokeSuspend")
    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$p */
    static final class C20074p extends C25045g implements C31591m<C36622ac, C36927c<? super C37091y>, Object> {
        final /* synthetic */ int jKl;
        final /* synthetic */ List jKn;
        private C36622ac jTk;
        int label;

        C20074p(List list, int i, C36927c c36927c) {
            this.jKn = list;
            this.jKl = i;
            super(c36927c);
        }

        /* renamed from: a */
        public final C36927c<C37091y> mo42a(Object obj, C36927c<?> c36927c) {
            AppMethodBeat.m2504i(14903);
            C25052j.m39376p(c36927c, "completion");
            C20074p c20074p = new C20074p(this.jKn, this.jKl, c36927c);
            c20074p.jTk = (C36622ac) obj;
            AppMethodBeat.m2505o(14903);
            return c20074p;
        }

        /* renamed from: m */
        public final Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(14904);
            Object bO = ((C20074p) mo42a(obj, (C36927c) obj2)).mo43bO(C37091y.AUy);
            AppMethodBeat.m2505o(14904);
            return bO;
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x015e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x014b  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01f5 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0229  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: bO */
        public final Object mo43bO(Object obj) {
            AppMethodBeat.m2504i(14902);
            C25040a c25040a = C25040a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    if (obj instanceof C37089b) {
                        Throwable th = ((C37089b) obj).AUq;
                        AppMethodBeat.m2505o(14902);
                        throw th;
                    }
                    List<List> list = this.jKn;
                    if ((!((Collection) list).isEmpty() ? 1 : null) != null) {
                        List list2;
                        PreloadLogic preloadLogic;
                        PreloadLogic preloadLogic2 = PreloadLogic.jSS;
                        if (PreloadLogic.m31039sq(this.jKl) != 0) {
                            for (List list22 : list) {
                                StringBuilder append = new StringBuilder("addToPreload_").append((String) list22.get(0)).append('_').append((String) list22.get(1)).append('_');
                                PreloadLogic preloadLogic3 = PreloadLogic.jSS;
                                append = append.append((String) PreloadLogic.m31010a(list22, 3, (Object) "")).append('_');
                                preloadLogic3 = PreloadLogic.jSS;
                                String stringBuilder = append.append((String) PreloadLogic.m31010a(list22, 4, (Object) "")).toString();
                                preloadLogic = PreloadLogic.jSS;
                                if (!PreloadLogic.aXr().contains(stringBuilder)) {
                                    Object obj2;
                                    int i;
                                    preloadLogic = PreloadLogic.jSS;
                                    PreloadLogic.aXr().add(stringBuilder);
                                    C7060h c7060h = C7060h.pYm;
                                    r7 = new Object[11];
                                    PreloadLogic preloadLogic4 = PreloadLogic.jSS;
                                    r7[3] = PreloadLogic.m31010a(list22, 3, (Object) "");
                                    preloadLogic4 = PreloadLogic.jSS;
                                    r7[4] = PreloadLogic.m31010a(list22, 4, (Object) "");
                                    r7[5] = Integer.valueOf(1);
                                    r7[6] = list22.get(2);
                                    r7[7] = "";
                                    r7[8] = "";
                                    r7[9] = "";
                                    if (C25052j.m39373j((String) list22.get(2), "-1")) {
                                        Boolean valueOf;
                                        String str = (String) list22.get(1);
                                        if (str != null) {
                                            valueOf = Boolean.valueOf(C27540m.m43707FW(str));
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
                                            c7060h.mo8381e(16468, r7);
                                        }
                                    }
                                    obj2 = null;
                                    if (obj2 == null) {
                                    }
                                    r7[10] = Integer.valueOf(i);
                                    c7060h.mo8381e(16468, r7);
                                }
                            }
                        }
                        preloadLogic2 = PreloadLogic.jSS;
                        if (PreloadLogic.m31033rW(PreloadLogic.m31040sr(this.jKl))) {
                            int sk = C2702b.m4935sk(this.jKl);
                            Collection arrayList = new ArrayList();
                            for (Object next : list) {
                                if ((!C27540m.m43707FW((String) ((List) next).get(1)) ? 1 : null) == null) {
                                    arrayList.add(next);
                                }
                            }
                            Iterable<List> iterable = (List) arrayList;
                            Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable));
                            for (List list222 : iterable) {
                                Object obj3 = list222.get(1);
                                preloadLogic = PreloadLogic.jSS;
                                arrayList2.add(new C0415j(obj3, Integer.valueOf(PreloadLogic.m31036sn(Integer.parseInt((String) list222.get(2))))));
                            }
                            arrayList = new ArrayList();
                            for (Object next2 : (List) arrayList2) {
                                Object obj4;
                                C0415j c0415j = (C0415j) next2;
                                preloadLogic = PreloadLogic.jSS;
                                if (C27540m.m43703FC(PreloadLogic.m31027c(c0415j))) {
                                    preloadLogic = PreloadLogic.jSS;
                                    C11247a aXp = PreloadLogic.aXp();
                                    PreloadLogic preloadLogic5 = PreloadLogic.jSS;
                                    String c = PreloadLogic.m31027c(c0415j);
                                    PreloadLogic preloadLogic6 = PreloadLogic.jSS;
                                    if (!aXp.mo22946bK(c, PreloadLogic.m31028d(c0415j))) {
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
                            List a = C25035t.m39324a((Iterable) list222, sk);
                            if ((!((Collection) a).isEmpty() ? 1 : null) != null) {
                                preloadLogic2 = PreloadLogic.jSS;
                                PreloadLogic.m31017a(a, this.jKl, max, 1);
                            }
                        }
                    }
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(14902);
                    return c37091y;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.m2505o(14902);
                    throw illegalStateException;
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$Process;", "", "processName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getProcessName$plugin_brandservice_release", "()Ljava/lang/String;", "setProcessName$plugin_brandservice_release", "(Ljava/lang/String;)V", "MM", "Tool", "ToolMP", "UNKNOW", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$i */
    public enum C20075i {
        MM("com.tencent.mm"),
        Tool("com.tencent.mm:tools"),
        ToolMP("com.tencent.mm:toolsmp"),
        UNKNOW("com.tencent.mm:tools");
        
        String processName;

        private C20075i(String str) {
            C25052j.m39376p(str, "processName");
            AppMethodBeat.m2504i(14878);
            this.processName = str;
            AppMethodBeat.m2505o(14878);
        }

        static {
            AppMethodBeat.m2505o(14877);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$keys$1", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$o */
    public static final class C20076o extends HashMap<Integer, String> {
        C20076o() {
            AppMethodBeat.m2504i(14891);
            put(Integer.valueOf(1), "100463");
            put(Integer.valueOf(3), "100486");
            AppMethodBeat.m2505o(14891);
        }

        public final /* bridge */ boolean containsKey(Object obj) {
            AppMethodBeat.m2504i(14894);
            if (obj instanceof Integer) {
                boolean containsKey = super.containsKey((Integer) obj);
                AppMethodBeat.m2505o(14894);
                return containsKey;
            }
            AppMethodBeat.m2505o(14894);
            return false;
        }

        public final /* bridge */ boolean containsValue(Object obj) {
            AppMethodBeat.m2504i(14892);
            if (obj instanceof String) {
                boolean containsValue = super.containsValue((String) obj);
                AppMethodBeat.m2505o(14892);
                return containsValue;
            }
            AppMethodBeat.m2505o(14892);
            return false;
        }

        public final /* bridge */ Object get(Object obj) {
            AppMethodBeat.m2504i(14895);
            if (obj instanceof Integer) {
                String str = (String) super.get((Integer) obj);
                AppMethodBeat.m2505o(14895);
                return str;
            }
            AppMethodBeat.m2505o(14895);
            return null;
        }

        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            AppMethodBeat.m2504i(14893);
            if (obj instanceof Integer) {
                String str = (String) super.getOrDefault((Integer) obj, (String) obj2);
                AppMethodBeat.m2505o(14893);
                return str;
            }
            AppMethodBeat.m2505o(14893);
            return obj2;
        }

        public final /* bridge */ Object remove(Object obj) {
            AppMethodBeat.m2504i(14896);
            if (obj instanceof Integer) {
                String str = (String) super.remove((Integer) obj);
                AppMethodBeat.m2505o(14896);
                return str;
            }
            AppMethodBeat.m2505o(14896);
            return null;
        }

        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            AppMethodBeat.m2504i(14897);
            if ((obj instanceof Integer) && (obj2 instanceof String)) {
                boolean remove = super.remove((Integer) obj, (String) obj2);
                AppMethodBeat.m2505o(14897);
                return remove;
            }
            AppMethodBeat.m2505o(14897);
            return false;
        }

        public final /* bridge */ Set<Entry<Integer, String>> entrySet() {
            AppMethodBeat.m2504i(14898);
            Set entrySet = super.entrySet();
            AppMethodBeat.m2505o(14898);
            return entrySet;
        }

        public final /* bridge */ Set<Integer> keySet() {
            AppMethodBeat.m2504i(14899);
            Set keySet = super.keySet();
            AppMethodBeat.m2505o(14899);
            return keySet;
        }

        public final /* bridge */ Collection<String> values() {
            AppMethodBeat.m2504i(14900);
            Collection values = super.values();
            AppMethodBeat.m2505o(14900);
            return values;
        }

        public final /* bridge */ int size() {
            AppMethodBeat.m2504i(14901);
            int size = super.size();
            AppMethodBeat.m2505o(14901);
            return size;
        }
    }

    @C31589d(c = "com/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$preloadByInfoIdAndBuffer$1", dWy = {967}, f = "PreloadLogic.kt", m = "invokeSuspend")
    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$q */
    static final class C20077q extends C25045g implements C31591m<C36622ac, C36927c<? super C37091y>, Object> {
        final /* synthetic */ int jKl;
        final /* synthetic */ List jKn;
        private C36622ac jTk;
        int label;

        C20077q(int i, List list, C36927c c36927c) {
            this.jKl = i;
            this.jKn = list;
            super(c36927c);
        }

        /* renamed from: a */
        public final C36927c<C37091y> mo42a(Object obj, C36927c<?> c36927c) {
            AppMethodBeat.m2504i(14906);
            C25052j.m39376p(c36927c, "completion");
            C20077q c20077q = new C20077q(this.jKl, this.jKn, c36927c);
            c20077q.jTk = (C36622ac) obj;
            AppMethodBeat.m2505o(14906);
            return c20077q;
        }

        /* renamed from: m */
        public final Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(14907);
            Object bO = ((C20077q) mo42a(obj, (C36927c) obj2)).mo43bO(C37091y.AUy);
            AppMethodBeat.m2505o(14907);
            return bO;
        }

        /* JADX WARNING: Removed duplicated region for block: B:45:0x00c0 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00f4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: bO */
        public final Object mo43bO(Object obj) {
            AppMethodBeat.m2504i(14905);
            C25040a c25040a = C25040a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    if (obj instanceof C37089b) {
                        Throwable th = ((C37089b) obj).AUq;
                        AppMethodBeat.m2505o(14905);
                        throw th;
                    }
                    PreloadLogic preloadLogic;
                    int i;
                    int sk = C2702b.m4935sk(this.jKl);
                    Collection arrayList = new ArrayList();
                    for (String[] strArr : this.jKn) {
                        List a;
                        int parseInt = Integer.parseInt(strArr[2]);
                        LinkedList linkedList = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(Long.parseLong(strArr[0]), strArr[1]).fjr;
                        if (parseInt > 0) {
                            C25052j.m39375o(linkedList, "it");
                            a = C25035t.m39324a((Iterable) linkedList, parseInt);
                        } else {
                            a = linkedList;
                        }
                        C44628q.m81054a(arrayList, (Iterable) a);
                    }
                    Iterable<C32224p> iterable = (List) arrayList;
                    Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable));
                    for (C32224p c32224p : iterable) {
                        String str = c32224p.url;
                        preloadLogic = PreloadLogic.jSS;
                        arrayList2.add(new C0415j(str, Integer.valueOf(PreloadLogic.m31036sn(c32224p.type))));
                    }
                    arrayList = new ArrayList();
                    for (Object next : (List) arrayList2) {
                        C0415j c0415j = (C0415j) next;
                        PreloadLogic preloadLogic2 = PreloadLogic.jSS;
                        if (C27540m.m43703FC(PreloadLogic.m31027c(c0415j))) {
                            preloadLogic2 = PreloadLogic.jSS;
                            C11247a aXp = PreloadLogic.aXp();
                            preloadLogic = PreloadLogic.jSS;
                            String c = PreloadLogic.m31027c(c0415j);
                            PreloadLogic preloadLogic3 = PreloadLogic.jSS;
                            if (!aXp.mo22946bK(c, PreloadLogic.m31028d(c0415j))) {
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
                    list = C25035t.m39324a((Iterable) list, sk);
                    if (list.isEmpty()) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        PreloadLogic preloadLogic4 = PreloadLogic.jSS;
                        PreloadLogic.m31017a(list, this.jKl, max, 1);
                    }
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(14905);
                    return c37091y;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.m2505o(14905);
                    throw illegalStateException;
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Landroid/os/Bundle;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$r */
    static final class C20078r extends C25053k implements C17126b<Bundle, C37091y> {
        final /* synthetic */ C31591m jTs;

        C20078r(C31591m c31591m) {
            this.jTs = c31591m;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(14908);
            Bundle bundle = (Bundle) obj;
            C25052j.m39376p(bundle, "it");
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            PreloadLogic.m31014a(bundle, this.jTs);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(14908);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$IPCInvoke_Report;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "bundle", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$f */
    static final class C20079f implements C37866a<Bundle, IPCVoid> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(14869);
            Bundle bundle = (Bundle) obj;
            C25052j.m39376p(bundle, "bundle");
            C45764c.m84585FO(bundle.getString("url"));
            AppMethodBeat.m2505o(14869);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f¢\u0006\u0002\u0010\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u0018\u00103\u001a\u0002042\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0006H\u0016R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u001a\u0010\u0013\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u001a\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u001a\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001c¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "url", "", "tmplType", "openScene", "subScene", "aScene", "uid", "fastOpen", "", "cacheData", "zip", "prefixMP", "prefixHttp", "cacheItemShowType", "webCodeCache", "(ILjava/lang/String;IIIILjava/lang/String;ZZZZZZZ)V", "getAScene", "()I", "getCacheData", "()Z", "setCacheData", "(Z)V", "getCacheItemShowType", "setCacheItemShowType", "getFastOpen", "setFastOpen", "getId", "getOpenScene", "getPrefixHttp", "setPrefixHttp", "getPrefixMP", "setPrefixMP", "getSubScene", "getTmplType", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "getUrl", "getWebCodeCache", "setWebCodeCache", "getZip", "setZip", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$PreloadSession */
    public static final class PreloadSession implements Parcelable {
        public static final C20080a CREATOR = new C20080a();
        /* renamed from: id */
        final int f4371id;
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

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$PreloadSession$a */
        public static final class C20080a implements Creator<PreloadSession> {
            private C20080a() {
            }

            public /* synthetic */ C20080a(byte b) {
                this();
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(14871);
                C25052j.m39376p(parcel, "parcel");
                PreloadSession preloadSession = new PreloadSession(parcel);
                AppMethodBeat.m2505o(14871);
                return preloadSession;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PreloadSession[i];
            }
        }

        static {
            AppMethodBeat.m2504i(14876);
            AppMethodBeat.m2505o(14876);
        }

        private PreloadSession(int i, String str, int i2, int i3, int i4, int i5, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            C25052j.m39376p(str, "url");
            C25052j.m39376p(str2, "uid");
            AppMethodBeat.m2504i(138514);
            this.f4371id = i;
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
            AppMethodBeat.m2505o(138514);
        }

        public /* synthetic */ PreloadSession(int i, String str, int i2, int i3, int i4, int i5) {
            this(i, str, i2, i3, i4, i5, "", false, false, false, false, false, false, false);
            AppMethodBeat.m2504i(14874);
            AppMethodBeat.m2505o(14874);
        }

        public PreloadSession(Parcel parcel) {
            boolean z;
            C25052j.m39376p(parcel, "parcel");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            C25052j.m39375o(readString, "parcel.readString()");
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            String readString2 = parcel.readString();
            C25052j.m39375o(readString2, "parcel.readString()");
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
            AppMethodBeat.m2504i(14875);
            AppMethodBeat.m2505o(14875);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.m2504i(14872);
            C25052j.m39376p(parcel, "parcel");
            parcel.writeInt(this.f4371id);
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
            AppMethodBeat.m2505o(14872);
        }

        public final int describeContents() {
            return 0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BatchGetAppMsgResp;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic$n */
    static final class C20081n extends C25053k implements C31591m<C20072h, C44129hz, C37091y> {
        final /* synthetic */ String jTp;
        final /* synthetic */ C36933q jTq;
        final /* synthetic */ WeakReference jTr;

        C20081n(String str, C36933q c36933q, WeakReference weakReference) {
            this.jTp = str;
            this.jTq = c36933q;
            this.jTr = weakReference;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(14890);
            C20072h c20072h = (C20072h) obj;
            C44129hz c44129hz = (C44129hz) obj2;
            C25052j.m39376p(c20072h, "result");
            C25052j.m39376p(c44129hz, "response");
            if (c20072h.cxT) {
                LinkedList linkedList = c44129hz.vKx;
                if (linkedList != null) {
                    Iterator it = linkedList.iterator();
                    if (it.hasNext()) {
                        C40515ef c40515ef = (C40515ef) it.next();
                        PreloadLogic preloadLogic = PreloadLogic.jSS;
                        C4990ab.m7417i(PreloadLogic.TAG, "[findAppMsgContext] url:%s", this.jTp);
                        if (!c20072h.jRW) {
                            preloadLogic = PreloadLogic.jSS;
                            C11247a aXp = PreloadLogic.aXp();
                            String str = c40515ef.Url;
                            C25052j.m39375o(str, "appMsgContext.Url");
                            aXp.mo22945a(str, c40515ef);
                            C43926c c43926c = new C43926c();
                            c43926c.startTime = c20072h.start;
                            c43926c.endTime = c20072h.aZV;
                            c43926c.exv = 1;
                            if (c40515ef.vFX) {
                                c43926c.cYR();
                                C43924a.m78793kT(31);
                            } else {
                                c43926c.cYQ();
                                C43924a.m78793kT(32);
                            }
                            c43926c.mo69612IV(c40515ef.computeSize());
                            c43926c.mo69611IF();
                        }
                        C36933q c36933q = this.jTq;
                        WeakReference weakReference = this.jTr;
                        C25052j.m39375o(c40515ef, "appMsgContext");
                        c36933q.mo9028g(weakReference, c20072h, c40515ef);
                    } else {
                        Throwable noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
                        AppMethodBeat.m2505o(14890);
                        throw noSuchElementException;
                    }
                }
            }
            this.jTq.mo9028g(this.jTr, c20072h, new C40515ef());
            if (!c20072h.jRW) {
                int i;
                C43924a.m78793kT(20);
                C43924a.m78793kT(26);
                if (c20072h.cxT) {
                    i = 24;
                } else {
                    i = 25;
                }
                C43924a.m78793kT(i);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(14890);
            return c37091y;
        }
    }

    public static ConcurrentHashMap<String, ConcurrentLinkedDeque<C17126b<Bundle, C37091y>>> aXq() {
        AppMethodBeat.m2504i(14929);
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) jSO.getValue();
        AppMethodBeat.m2505o(14929);
        return concurrentHashMap;
    }

    static {
        AppMethodBeat.m2504i(14913);
        AppMethodBeat.m2505o(14913);
    }

    private PreloadLogic() {
    }

    /* renamed from: b */
    public static final /* synthetic */ void m31025b(Bundle bundle, C17126b c17126b) {
        AppMethodBeat.m2504i(14938);
        PreloadLogic.m31013a(bundle, c17126b);
        AppMethodBeat.m2505o(14938);
    }

    /* renamed from: c */
    public static final /* synthetic */ String m31027c(C0415j c0415j) {
        AppMethodBeat.m2504i(14945);
        String a = PreloadLogic.m31011a(c0415j);
        AppMethodBeat.m2505o(14945);
        return a;
    }

    /* renamed from: d */
    public static final /* synthetic */ int m31028d(C0415j c0415j) {
        AppMethodBeat.m2504i(14946);
        int b = PreloadLogic.m31024b(c0415j);
        AppMethodBeat.m2505o(14946);
        return b;
    }

    /* renamed from: sn */
    public static final /* synthetic */ int m31036sn(int i) {
        AppMethodBeat.m2504i(14939);
        int sl = PreloadLogic.m31034sl(i);
        AppMethodBeat.m2505o(14939);
        return sl;
    }

    /* renamed from: sr */
    public static final /* synthetic */ int m31040sr(int i) {
        AppMethodBeat.m2504i(14944);
        int sm = PreloadLogic.m31035sm(i);
        AppMethodBeat.m2505o(14944);
        return sm;
    }

    /* renamed from: mg */
    public static final void m31032mg(int i) {
        AppMethodBeat.m2504i(14914);
        if (jSF.get()) {
            AppMethodBeat.m2505o(14914);
        } else if (i == Downloads.MIN_WAIT_FOR_NETWORK) {
            PreloadLogic.m31016a(jSE, i);
            jSF.set(false);
            AppMethodBeat.m2505o(14914);
        } else {
            Looper.myQueue().addIdleHandler(new C11250t(i));
            AppMethodBeat.m2505o(14914);
        }
    }

    /* renamed from: a */
    private static void m31016a(C20075i c20075i, int i) {
        AppMethodBeat.m2504i(14915);
        C4990ab.m7416i(TAG, "start in ".concat(String.valueOf(c20075i)));
        PreloadLogic.m31023aj(i, C2710d.aWX());
        PreloadLogic.m31015a(c20075i);
        PreloadLogic.aXs();
        PreloadLogic.clear();
        AppMethodBeat.m2505o(14915);
    }

    public static final void aXo() {
        AppMethodBeat.m2504i(14917);
        PreloadLogic.m31015a(jSE);
        AppMethodBeat.m2505o(14917);
    }

    /* renamed from: a */
    private static void m31015a(C20075i c20075i) {
        AppMethodBeat.m2504i(14918);
        C25052j.m39376p(c20075i, "process");
        C33740a c33740a = C33739g.jSD;
        if (C33740a.aXe()) {
            C9549f.m17012a(c20075i.processName, new IPCInteger(0), C20064d.class, null);
            AppMethodBeat.m2505o(14918);
            return;
        }
        AppMethodBeat.m2505o(14918);
    }

    /* renamed from: aj */
    private static void m31023aj(int i, String str) {
        AppMethodBeat.m2504i(14919);
        C25052j.m39376p(str, DownloadInfo.NETTYPE);
        Bundle bundle = new Bundle();
        bundle.putInt("openScene", i);
        bundle.putString(DownloadInfo.NETTYPE, str);
        C9549f.m17012a("com.tencent.mm", bundle, C20067c.class, null);
        AppMethodBeat.m2505o(14919);
    }

    /* renamed from: a */
    public static /* synthetic */ boolean m31022a(Context context, String str, int i, int i2, int i3, Intent intent, int i4, C20024a c20024a, int i5) {
        Intent intent2;
        int i6;
        C20024a c20024a2;
        AppMethodBeat.m2504i(14921);
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
            c20024a2 = new C20024a();
            c20024a2.success = true;
        } else {
            c20024a2 = c20024a;
        }
        boolean a = PreloadLogic.m31021a(context, str, i, i2, i3, intent2, i6, c20024a2);
        AppMethodBeat.m2505o(14921);
        return a;
    }

    /* renamed from: a */
    private static boolean m31021a(Context context, String str, int i, int i2, int i3, Intent intent, int i4, C20024a c20024a) {
        AppMethodBeat.m2504i(14920);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(str, "rawUrl");
        C25052j.m39376p(intent, "intent");
        C25052j.m39376p(c20024a, "result");
        if (C6163u.m9837ar(str)) {
            c20024a.success = false;
            c20024a.message = "invalid url";
            AppMethodBeat.m2505o(14920);
            return false;
        } else if (C27540m.m43703FC(str)) {
            int i5;
            if (i == -1) {
                C40515ef FP = jSN.mo22944FP(str);
                i5 = FP != null ? FP.vGc : i;
            } else {
                i5 = i;
            }
            int sl = PreloadLogic.m31034sl(i5);
            if (sl == -1) {
                c20024a.success = false;
                c20024a.message = "invalid itemShowType:".concat(String.valueOf(i5));
                AppMethodBeat.m2505o(14920);
                return false;
            }
            int i6;
            int i7;
            String G;
            boolean z;
            int sessionId = C30309s.getSessionId();
            if (i2 == 90) {
                i6 = i2;
                i7 = i3;
                G = C27540m.m43708G(C27540m.m43708G(str, "scene", String.valueOf(i2)), "subscene", String.valueOf(i3));
            } else {
                G = C27540m.m43710dg(str, "scene");
                if (G != null) {
                    if (new C25274k("\\d+").mo42119aq(G)) {
                        i2 = Integer.parseInt(G);
                    }
                }
                G = C27540m.m43710dg(str, "subscene");
                if (G != null) {
                    if (new C25274k("\\d+").mo42119aq(G)) {
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
            intent.putExtra(C5506m.ygo, i5);
            intent.putExtra(C5506m.ygj, sessionId);
            intent.putExtra(C5506m.ygk, i6);
            intent.putExtra(C5506m.ygl, i7);
            intent.putExtra(C5506m.ygp, i4);
            PreloadSession preloadSession = new PreloadSession(sessionId, G, sl, i6, i7, intent.getIntExtra("geta8key_scene", 0));
            if (i5 != i) {
                z = true;
            } else {
                z = false;
            }
            preloadSession.jSa = z;
            z = jSS.m31020a(context, jSE, intent, preloadSession, c20024a);
            if (z) {
                int i8;
                if (i4 != -1 && (context instanceof MMActivity) && i4 == 1) {
                    ((MMActivity) context).overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8374cf);
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
                C43924a.m78787IT(i8);
            }
            AppMethodBeat.m2505o(14920);
            return z;
        } else {
            c20024a.success = false;
            c20024a.message = "invalid host";
            AppMethodBeat.m2505o(14920);
            return false;
        }
    }

    /* renamed from: sl */
    private static int m31034sl(int i) {
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

    /* renamed from: rW */
    public static final boolean m31033rW(int i) {
        AppMethodBeat.m2504i(14923);
        Object obj;
        boolean booleanValue;
        if (jSM.containsKey(Integer.valueOf(i))) {
            obj = jSM.get(Integer.valueOf(i));
            if (obj == null) {
                C25052j.dWJ();
            }
            booleanValue = ((Boolean) obj).booleanValue();
            AppMethodBeat.m2505o(14923);
            return booleanValue;
        }
        C33740a c33740a = C33739g.jSD;
        Map map;
        if (C33740a.aXm() || !(C5058f.IS_FLAVOR_RED || C5058f.DEBUG)) {
            try {
                boolean z;
                map = jSM;
                Integer valueOf = Integer.valueOf(i);
                switch (i) {
                    case 1:
                        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_biz_timeline, 0) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 2:
                        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_chat, 0) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 3:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_forward, 0) & 1) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 4:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_sns, 0) & 1) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 5:
                        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_jsapi, 0) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 6:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_mpprofile, 0) & 1) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 7:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_search, 0) & 1) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 13:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_forward, 0) & 2) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 14:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_sns, 0) & 2) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 16:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_mpprofile, 0) & 2) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 20:
                        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_mpprocess, 0) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 23:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_forward, 0) & 4) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 24:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_sns, 0) & 4) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 26:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_mpprofile, 0) & 4) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 101:
                        if ((((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mpfastload_android_tmpl_zip, 0) & 1) == 0) {
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
                C4990ab.printErrStackTrace(TAG, e, "canPreloadIn", new Object[0]);
            }
            if (jSM.containsKey(Integer.valueOf(i))) {
                obj = jSM.get(Integer.valueOf(i));
                if (obj == null) {
                    C25052j.dWJ();
                }
                C25052j.m39375o(obj, "isPreloadOpen[openScene]!!");
                booleanValue = ((Boolean) obj).booleanValue();
                AppMethodBeat.m2505o(14923);
                return booleanValue;
            }
            AppMethodBeat.m2505o(14923);
            return false;
        }
        map = jSM;
        Integer valueOf2 = Integer.valueOf(i);
        C33740a c33740a2 = C33739g.jSD;
        map.put(valueOf2, Boolean.valueOf(C38709h.aXn().getBoolean("preload_use", true)));
        obj = jSM.get(Integer.valueOf(i));
        if (obj == null) {
            C25052j.dWJ();
        }
        booleanValue = ((Boolean) obj).booleanValue();
        AppMethodBeat.m2505o(14923);
        return booleanValue;
    }

    public static C11247a aXp() {
        return jSN;
    }

    /* renamed from: bJ */
    private static C40515ef m31026bJ(String str, int i) {
        AppMethodBeat.m2504i(14924);
        C25052j.m39376p(str, "url");
        if (C6163u.m9837ar(str)) {
            C4990ab.m7412e(TAG, "[findAppMsgContextInCache] url is null, return");
            AppMethodBeat.m2505o(14924);
            return null;
        } else if (jSN.mo22946bK(str, i)) {
            C40515ef FP = jSN.mo22944FP(str);
            AppMethodBeat.m2505o(14924);
            return FP;
        } else {
            AppMethodBeat.m2505o(14924);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo35311a(Object obj, String str, PreloadSession preloadSession, C36933q<? super WeakReference<Object>, ? super C20072h, ? super C40515ef, C37091y> c36933q) {
        AppMethodBeat.m2504i(14925);
        C25052j.m39376p(obj, "context");
        C25052j.m39376p(str, "url");
        C25052j.m39376p(preloadSession, "session");
        C25052j.m39376p(c36933q, "callback");
        WeakReference weakReference = new WeakReference(obj);
        C20072h c20072h = new C20072h(false, System.currentTimeMillis(), System.currentTimeMillis(), false, (byte) 0);
        C33740a c33740a = C33739g.jSD;
        if (C33740a.aXg()) {
            c20072h.cxT = true;
            c36933q.mo9028g(weakReference, c20072h, new C40515ef());
            AppMethodBeat.m2505o(14925);
        } else if (C6163u.m9837ar(str) || !C27540m.m43703FC(str)) {
            c36933q.mo9028g(weakReference, c20072h, new C40515ef());
            AppMethodBeat.m2505o(14925);
        } else {
            C40515ef bJ = PreloadLogic.m31026bJ(str, preloadSession.jSV);
            if (bJ != null) {
                c20072h.cxT = true;
                c20072h.jSU = true;
                c36933q.mo9028g(weakReference, c20072h, bJ);
                AppMethodBeat.m2505o(14925);
                return;
            }
            String a = C27540m.m43709a(str, preloadSession);
            LinkedList linkedList = new LinkedList();
            linkedList.add(new C0415j(a, Integer.valueOf(preloadSession.jSV)));
            PreloadLogic.m31019a((List) linkedList, preloadSession.jSV, (C31591m) new C20081n(a, c36933q, weakReference));
            AppMethodBeat.m2505o(14925);
        }
    }

    /* renamed from: a */
    private static void m31018a(List<? extends C0415j<String, Integer>> list, int i, int i2, int i3, C31591m<? super C20072h, ? super C44129hz, C37091y> c31591m) {
        AppMethodBeat.m2504i(14926);
        Bundle bundle = new Bundle();
        String str = "urls";
        Iterable<C0415j> iterable = list;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C0415j a : iterable) {
            arrayList.add(PreloadLogic.m31011a(a));
        }
        bundle.putStringArrayList(str, new ArrayList((List) arrayList));
        str = "tmplTypes";
        Iterable<C0415j> iterable2 = list;
        Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable2));
        for (C0415j b : iterable2) {
            arrayList2.add(Integer.valueOf(PreloadLogic.m31024b(b)));
        }
        bundle.putIntegerArrayList(str, new ArrayList((List) arrayList2));
        bundle.putInt("openScene", i);
        bundle.putInt("strip", i2);
        bundle.putInt("stripType", i3);
        C1681g Rn = C1720g.m3533RM().mo5224Rn();
        C25052j.m39375o(Rn, "MMKernel.process().current()");
        if (((C6624h) Rn).mo5181SG()) {
            PreloadLogic.m31013a(bundle, (C17126b) new C20078r(c31591m));
            AppMethodBeat.m2505o(14926);
            return;
        }
        C9549f.m17012a("com.tencent.mm", bundle, C20070e.class, new C20068s(c31591m));
        AppMethodBeat.m2505o(14926);
    }

    /* renamed from: a */
    private static C1196a m31009a(Iterable<? extends C0415j<String, Integer>> iterable, int i, int i2, int i3) {
        int i4;
        AppMethodBeat.m2504i(14930);
        C44128hy c44128hy = new C44128hy();
        c44128hy.vKt = C2710d.aWX();
        c44128hy.vKu = C20086l.aXx();
        c44128hy.vKs = new LinkedList();
        c44128hy.vKv = i2;
        c44128hy.vKw = i3;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C0415j c0415j : iterable) {
            bsq bsq = new bsq();
            bsq.Url = PreloadLogic.m31011a(c0415j);
            bsq.vFW = 0;
            bsq.Scene = i;
            C40515ef FP = jSN.mo22944FP(PreloadLogic.m31011a(c0415j));
            if (FP != null) {
                bsq.vFW = FP.vFW;
                if (FP.vFY < C20082b.m31068sv(PreloadLogic.m31024b(c0415j)).Version) {
                    bsq.vFW = 0;
                }
            }
            arrayList.add(bsq);
        }
        c44128hy.vKs.addAll((List) arrayList);
        C4990ab.m7417i(TAG, "[batchSyncAppMsgContext]urlList ReqInfoList:%d", Integer.valueOf(c44128hy.vKs.size()));
        C4990ab.m7411d(TAG, "[batchSyncAppMsgContext]urlList:%s", iterable);
        C1196a c1196a = new C1196a();
        c1196a.mo4447kU(2594);
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/batchgetappmsg");
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        c1196a.mo4444a(c44128hy);
        c1196a.mo4446b(new C44129hz());
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
        C43924a.m78792gv(i4, c44128hy.vKs.size());
        AppMethodBeat.m2505o(14930);
        return c1196a;
    }

    /* renamed from: sm */
    private static int m31035sm(int i) {
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

    /* renamed from: a */
    public static final void m31012a(long j, String str, int i, int i2, Object... objArr) {
        AppMethodBeat.m2504i(14931);
        C25052j.m39376p(str, "url");
        C25052j.m39376p(objArr, "params");
        if (jSR) {
            AppMethodBeat.m2505o(14931);
            return;
        }
        C36637f.m60738a(C44611aw.BQs, C41154ao.elk(), new C2699j(j, str, i, i2, objArr, null));
        AppMethodBeat.m2505o(14931);
    }

    /* renamed from: j */
    public static final void m31031j(List<String[]> list, int i) {
        AppMethodBeat.m2504i(14932);
        C25052j.m39376p(list, "items");
        if (jSR) {
            AppMethodBeat.m2505o(14932);
        } else if (PreloadLogic.m31033rW(PreloadLogic.m31035sm(i))) {
            jSP = 0;
            jSQ.clear();
            C36637f.m60738a(C44611aw.BQs, C41154ao.elk(), new C20077q(i, list, null));
            AppMethodBeat.m2505o(14932);
        } else {
            AppMethodBeat.m2505o(14932);
        }
    }

    public static HashSet<String> aXr() {
        return jKh;
    }

    /* renamed from: i */
    public static final void m31030i(List<? extends List<String>> list, int i) {
        AppMethodBeat.m2504i(14933);
        C25052j.m39376p(list, "items");
        if (jSR) {
            AppMethodBeat.m2505o(14933);
            return;
        }
        jSP = 0;
        jSQ.clear();
        C36637f.m60738a(C44611aw.BQs, C41154ao.elk(), new C20074p(list, i, null));
        AppMethodBeat.m2505o(14933);
    }

    private static void aXs() {
        AppMethodBeat.m2504i(14934);
        C9549f.m17012a("com.tencent.mm", null, C11248b.class, null);
        AppMethodBeat.m2505o(14934);
    }

    /* renamed from: FO */
    public static final void m31008FO(String str) {
        AppMethodBeat.m2504i(14935);
        C25052j.m39376p(str, "url");
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        C9549f.m17012a("com.tencent.mm", bundle, C20079f.class, null);
        AppMethodBeat.m2505o(14935);
    }

    /* renamed from: a */
    private static String m31011a(C0415j<String, Integer> c0415j) {
        AppMethodBeat.m2504i(14936);
        Object obj = c0415j.first;
        if (obj == null) {
            C25052j.dWJ();
        }
        String str = (String) obj;
        AppMethodBeat.m2505o(14936);
        return str;
    }

    /* renamed from: b */
    private static int m31024b(C0415j<String, Integer> c0415j) {
        AppMethodBeat.m2504i(14937);
        Object obj = c0415j.second;
        if (obj == null) {
            C25052j.dWJ();
        }
        int intValue = ((Number) obj).intValue();
        AppMethodBeat.m2505o(14937);
        return intValue;
    }

    private static void clear() {
        AppMethodBeat.m2504i(14916);
        C2702b.aWP();
        C4990ab.m7416i(TAG, "clear() isOk:true");
        C20082b.aXz();
        AppMethodBeat.m2505o(14916);
    }

    /* renamed from: a */
    private final boolean m31020a(Context context, C20075i c20075i, Intent intent, PreloadSession preloadSession, C20024a c20024a) {
        AppMethodBeat.m2504i(14922);
        TmplParams sx = C20082b.m31070sx(preloadSession.jSV);
        if (sx == null) {
            C4990ab.m7412e(TAG, "tmplParams is null");
            c20024a.success = false;
            c20024a.message = "not support tmplType=" + preloadSession + ".tmplType";
            AppMethodBeat.m2505o(14922);
            return false;
        }
        boolean z;
        int startPerformance = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, TAG);
        C4990ab.m7417i(TAG, "summer hardcoder biz startPerformance [%s][%s]", Integer.valueOf(902), Integer.valueOf(startPerformance));
        String str = sx.jSY;
        C25052j.m39375o(str, "tmplParams.uid");
        C25052j.m39376p(str, "<set-?>");
        preloadSession.jSY = str;
        C43924a.m78791gu(sx.upQ, 104);
        C40515ef bJ = PreloadLogic.m31026bJ(preloadSession.url, preloadSession.jSV);
        if (bJ != null) {
            str = bJ.vFV;
            if (str != null) {
                if ((!C6163u.m9837ar((CharSequence) str) ? 1 : 0) == 1) {
                    Intent intent2 = new Intent();
                    String str2 = bJ.vFV;
                    C25052j.m39375o(str2, "appMsgContext.ForceUrl");
                    str2 = C27540m.m43709a(str2, preloadSession);
                    C4990ab.m7417i(TAG, "appMsgContext forceUrl:%s", str2);
                    intent2.putExtra("rawUrl", str2);
                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent2);
                    C43924a.m78791gu(sx.upQ, 107);
                    c20024a.success = false;
                    c20024a.message = "has forceUrl=".concat(String.valueOf(str2));
                    AppMethodBeat.m2505o(14922);
                    return true;
                }
            }
        }
        preloadSession.jSZ = true;
        chi sv = C20082b.m31068sv(sx.jSV);
        preloadSession.jTb = C20086l.m31080d(sv);
        boolean j = C25052j.m39373j(C20082b.getPrefix(), "mptmpl://");
        if (C20086l.m31080d(sv) && j) {
            z = true;
        } else {
            z = false;
        }
        preloadSession.jTc = z;
        if (!C20086l.m31080d(sv) || j) {
            z = false;
        } else {
            z = true;
        }
        preloadSession.jTd = z;
        if (bJ == null || !C2702b.m4929b(bJ)) {
            mo35311a((Object) context, preloadSession.url, preloadSession, (C36933q) C20065m.jTo);
        } else {
            preloadSession.jTa = true;
            if (preloadSession.jSV == 0) {
                String a = C2702b.m4928a(bJ);
                str = intent.getStringExtra("rawUrl");
                C25052j.m39375o(str, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
                String a2 = C27540m.m43709a(str, preloadSession);
                C25052j.m39376p(a, "contentId");
                C25052j.m39376p(a2, "url");
                C20075i c20075i2 = jSE;
                C25052j.m39376p(c20075i2, "process");
                C25052j.m39376p(a, "contentId");
                C25052j.m39376p(a2, "url");
                Bundle bundle = new Bundle();
                bundle.putInt("tmplType", 0);
                bundle.putString("contentId", a);
                bundle.putString("url", a2);
                bundle.putLong("startLoadPage", System.currentTimeMillis());
                C9549f.m17012a(c20075i2.processName, bundle, C20071g.class, null);
            }
            C4990ab.m7417i(TAG, "set contentId:%s", C2702b.m4928a(bJ));
        }
        str = C5506m.ygf;
        C33740a c33740a = C33739g.jSD;
        intent.putExtra(str, C33740a.aXe());
        intent.putExtra(C5506m.ygg, System.currentTimeMillis());
        intent.putExtra(C5506m.ygi, preloadSession.url);
        intent.putExtra(C5506m.yge, sx);
        intent.putExtra(C5506m.ygq, preloadSession);
        intent.putExtra(C5506m.ygn, Process.myPid());
        try {
            intent.putExtra(C5506m.ygm, C2710d.m4956a(context, (C17126b) new C20066v(c20075i)));
            switch (C33741i.eQZ[c20075i.ordinal()]) {
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
            C25985d.m41467b(context, "brandservice", ".ui.timeline.preload.ui.TmplWebView" + str + "UI", intent);
            C43924a.m78791gu(sx.upQ, 106);
            C43924a.m78788IU(100);
            if (preloadSession.jTb) {
                C43924a.m78791gu(sx.upQ, 231);
                C43924a.m78788IU(110);
            }
            AppMethodBeat.m2505o(14922);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(14922);
            return false;
        }
    }

    /* renamed from: a */
    private static void m31013a(Bundle bundle, C17126b<? super Bundle, C37091y> c17126b) {
        Object obj;
        AppMethodBeat.m2504i(14928);
        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis2 = System.currentTimeMillis() % 100;
        ArrayList stringArrayList = bundle.getStringArrayList("urls");
        if (stringArrayList != null && stringArrayList.size() == 1) {
            obj = stringArrayList.get(0);
            C25052j.m39375o(obj, "urls[0]");
            String FJ = C2702b.m4922FJ((String) obj);
            if (PreloadLogic.aXq().containsKey(FJ)) {
                ConcurrentLinkedDeque concurrentLinkedDeque = (ConcurrentLinkedDeque) PreloadLogic.aXq().get(FJ);
                if (concurrentLinkedDeque != null) {
                    concurrentLinkedDeque.add(c17126b);
                }
                C4990ab.m7418v(TAG, "terry trace cgi mounted:" + FJ + '#' + currentTimeMillis2);
                AppMethodBeat.m2505o(14928);
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
            linkedList.add(new C0415j(stringArrayList.get(i4), integerArrayList.get(i4)));
            obj = stringArrayList.get(i4);
            C25052j.m39375o(obj, "urls[i]");
            String FJ2 = C2702b.m4922FJ((String) obj);
            PreloadLogic.aXq().put(FJ2, new ConcurrentLinkedDeque());
            C4990ab.m7418v(TAG, "terry trace cgi send:" + FJ2 + '#' + currentTimeMillis2);
        }
        C1226w.m2654a(PreloadLogic.m31009a((Iterable) linkedList, i, i2, i3).acD(), new C20073u(currentTimeMillis, currentTimeMillis2, c17126b, stringArrayList));
        AppMethodBeat.m2505o(14928);
    }

    /* renamed from: so */
    public static final /* synthetic */ int m31037so(int i) {
        AppMethodBeat.m2504i(14940);
        int i2 = C20082b.m31068sv(i).Version;
        AppMethodBeat.m2505o(14940);
        return i2;
    }

    /* renamed from: sp */
    public static final /* synthetic */ void m31038sp(int i) {
        C20075i c20075i;
        AppMethodBeat.m2504i(14941);
        C45287c.aNX();
        C33740a c33740a = C33739g.jSD;
        switch (C38709h.aXn().getInt("preload_process", 4)) {
            case 1:
                c20075i = C20075i.Tool;
                break;
            case 2:
                c20075i = C20075i.ToolMP;
                break;
            case 3:
                c20075i = C20075i.MM;
                break;
            default:
                c20075i = C20075i.UNKNOW;
                break;
        }
        jSE = c20075i;
        if (c20075i == C20075i.UNKNOW) {
            if (jSK == null) {
                C5141c ll = C18624c.abi().mo17131ll("100463");
                if (!ll.isValid()) {
                    C4990ab.m7416i(TAG, "webviewProcess item is null");
                    jSK = Integer.valueOf(jSJ);
                }
                C25052j.m39375o(ll, "item");
                jSK = Integer.valueOf(C5046bo.getInt((String) ll.dru().get("webviewProcess"), jSJ));
                C4990ab.m7417i(TAG, "webviewProcess %d", jSK);
            }
            Integer num = jSK;
            int i2 = jSH;
            if (num != null && num.intValue() == i2) {
                c20075i = C20075i.Tool;
            } else {
                i2 = jSG;
                if (num == null || num.intValue() != i2) {
                    i2 = jSI;
                    if (num != null && num.intValue() == i2) {
                        c20075i = C20075i.MM;
                    }
                }
                c20075i = C20075i.ToolMP;
            }
            jSE = c20075i;
        }
        C4990ab.m7417i(TAG, "[initDefaultProcess]DEFAULT_PROCESS:%s", jSE);
        PreloadLogic.m31016a(jSE, i);
        AppMethodBeat.m2505o(14941);
    }

    /* renamed from: sq */
    public static final /* synthetic */ int m31039sq(int i) {
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
