package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.t;
import a.f.b.v;
import a.f.b.x;
import a.k.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bT\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bu\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\u0018\u0000 ä\u00012\u00020\u0001:\u0002ä\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010Û\u0001\u001a\u00030Ü\u0001J\t\u0010Ý\u0001\u001a\u00020\bH\u0016J\r\u0010Þ\u0001\u001a\u00020\u0004*\u00020\u0004H\u0002J\r\u0010ß\u0001\u001a\u00020\f*\u00020\u0004H\u0002J-\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040a*\b\u0012\u0004\u0012\u00020\u00040a2\f\u0010á\u0001\u001a\u00030â\u0001\"\u00020\u0004H\u0002¢\u0006\u0003\u0010ã\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001b\u0010%\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b&\u0010\u001fR\u001b\u0010(\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b)\u0010\u0013R\u001a\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u000e\u00101\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010R\u001a\u00107\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u000e\u0010:\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b=\u0010\u001b\u001a\u0004\b<\u0010\u0019R\u001a\u0010>\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000e\"\u0004\b?\u0010\u0010R\u001a\u0010@\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000e\"\u0004\bA\u0010\u0010R\u001a\u0010B\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010\u0010R\u001a\u0010D\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010\u0010R\u001a\u0010F\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000e\"\u0004\bG\u0010\u0010R\u001a\u0010H\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000e\"\u0004\bI\u0010\u0010R\u001a\u0010J\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000e\"\u0004\bK\u0010\u0010R\u001a\u0010L\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000e\"\u0004\bM\u0010\u0010R\u001a\u0010N\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010\u0010R\u001a\u0010P\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0019\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0013\"\u0004\bV\u0010\u0015R\u001b\u0010W\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\bY\u0010\u001b\u001a\u0004\bX\u0010\u0013R\u000e\u0010Z\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010]\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0013\"\u0004\b_\u0010\u0015R!\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00040a8BX\u0002¢\u0006\f\n\u0004\bd\u0010\u001b\u001a\u0004\bb\u0010cR\u001a\u0010e\u001a\u00020fX.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u001f\"\u0004\bm\u0010!R\u001a\u0010n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u001f\"\u0004\bp\u0010!R\u001a\u0010q\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u001f\"\u0004\bs\u0010!R\u001a\u0010t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u001f\"\u0004\bv\u0010!R\u001a\u0010w\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u001f\"\u0004\by\u0010!R\u001a\u0010z\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u001f\"\u0004\b|\u0010!R\u001a\u0010}\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u001f\"\u0004\b\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b \u0001\u0010!R\u001d\u0010¡\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u001f\"\u0005\b£\u0001\u0010!R\u001d\u0010¤\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u001f\"\u0005\b¦\u0001\u0010!R\u001d\u0010§\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\u001f\"\u0005\b©\u0001\u0010!R\u001d\u0010ª\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010\u001f\"\u0005\b¬\u0001\u0010!R\u001d\u0010­\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u001f\"\u0005\b¯\u0001\u0010!R\u001d\u0010°\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010\u001f\"\u0005\b²\u0001\u0010!R\u001d\u0010³\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010\u001f\"\u0005\bµ\u0001\u0010!R\u001d\u0010¶\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010\u001f\"\u0005\b¸\u0001\u0010!R\u001d\u0010¹\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010\u001f\"\u0005\b»\u0001\u0010!R\u001d\u0010¼\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010\u001f\"\u0005\b¾\u0001\u0010!R\u001d\u0010¿\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010\u001f\"\u0005\bÁ\u0001\u0010!R\u001d\u0010Â\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010\u001f\"\u0005\bÄ\u0001\u0010!R\u001d\u0010Å\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010\u001f\"\u0005\bÇ\u0001\u0010!R\u001d\u0010È\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u0010\u001f\"\u0005\bÊ\u0001\u0010!R\u001d\u0010Ë\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010\u001f\"\u0005\bÍ\u0001\u0010!R\u001d\u0010Î\u0001\u001a\u00020\bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010\u0019\"\u0005\bÐ\u0001\u0010SR\u001d\u0010Ñ\u0001\u001a\u00020\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010\u000e\"\u0005\bÓ\u0001\u0010\u0010R\u000f\u0010Ô\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010Õ\u0001\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0001\u0010\u0019\"\u0005\b×\u0001\u0010SR\u001e\u0010Ø\u0001\u001a\u00020\b8BX\u0002¢\u0006\u000e\n\u0005\bÚ\u0001\u0010\u001b\u001a\u0005\bÙ\u0001\u0010\u0019¨\u0006å\u0001"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "invalidId", "getInvalidId", "invalidId$delegate", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/plugin/webview/preload/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "report", "", "toString", "limit", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
public final class f {
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(f.class), "contentId", "getContentId()Ljava/lang/String;")), v.a(new t(v.aN(f.class), "pageDataSize", "getPageDataSize()I")), v.a(new t(v.aN(f.class), "invalidId", "getInvalidId()Ljava/lang/String;")), v.a(new t(v.aN(f.class), "dataCachedTime", "getDataCachedTime()J")), v.a(new t(v.aN(f.class), "dataVersion", "getDataVersion()I")), v.a(new t(v.aN(f.class), "webviewProcess", "getWebviewProcess()Ljava/lang/String;")), v.a(new t(v.aN(f.class), "speedMatrix", "getSpeedMatrix()[Ljava/lang/Long;"))};
    public static final a jSx = new a();
    private final String TAG = "MicroMsg.Preload.Kv15862";
    public long jRA = -1;
    public long jRB = -1;
    public long jRC = -1;
    public long jRD;
    public long jRE;
    public long jRF;
    public long jRG;
    public long jRH;
    public long jRI;
    public long jRJ;
    public long jRK;
    public long jRL;
    public long jRM;
    public long jRN;
    public long jRO;
    public long jRP;
    public long jRQ;
    public long jRR;
    public boolean jRS;
    public boolean jRT;
    public boolean jRU;
    public boolean jRV;
    public boolean jRW;
    public boolean jRX;
    public boolean jRY;
    public boolean jRZ;
    private final int jRa = 15862;
    public TmplParams jRb;
    public int jRc;
    private final a.f jRd = a.i.g(new b(this));
    private final a.f jRe = a.i.g(new f(this));
    private final a.f jRf = a.i.g(new e(this));
    private final a.f jRg = a.i.g(new c(this));
    private final a.f jRh = a.i.g(new d(this));
    private long jRi = -1;
    public long jRj;
    public long jRk;
    long jRl;
    public long jRm;
    public long jRn;
    public long jRo;
    public long jRp;
    public long jRq;
    public long jRr;
    public long jRs;
    public long jRt;
    public long jRu;
    public long jRv = -1;
    public long jRw = -1;
    public long jRx = -1;
    public long jRy = -1;
    public long jRz = -1;
    public boolean jSa;
    public boolean jSb;
    public int jSc;
    public boolean jSd;
    public boolean jSe;
    private long jSf;
    private int jSg;
    private long jSh;
    private long jSi;
    private long jSj;
    private long jSk;
    private long jSl;
    private long jSm;
    private long jSn;
    private long jSo;
    private long jSp;
    private long jSq;
    public String jSr;
    private final a.f jSs = a.i.g(p.jSC);
    public boolean jSt;
    public int jSu = Downloads.MIN_WAIT_FOR_NETWORK;
    private final a.f jSv = a.i.g(new g(this));
    private long jSw = 3600000;
    public String key = "";
    public String url = "";

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"verify", "", "", "invoke"})
    static final class i extends a.f.b.k implements a.f.a.b<Long, String> {
        final /* synthetic */ f jSy;

        i(f fVar) {
            this.jSy = fVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(14816);
            String gN = gN(((Number) obj).longValue());
            AppMethodBeat.o(14816);
            return gN;
        }

        public final String gN(long j) {
            AppMethodBeat.i(14817);
            String valueOf;
            if (f.a(this.jSy, j)) {
                valueOf = String.valueOf(j);
                AppMethodBeat.o(14817);
                return valueOf;
            }
            valueOf = "NaN";
            AppMethodBeat.o(14817);
            return valueOf;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/Long;"})
    static final class g extends a.f.b.k implements a.f.a.a<Long[]> {
        final /* synthetic */ f jSy;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, dWq = {"getDuractionMatrix", "", "", "start", "end", "invoke", "(JJ)[Ljava/lang/Long;"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$g$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.m<Long, Long, Long[]> {
            final /* synthetic */ g jSz;

            AnonymousClass1(g gVar) {
                this.jSz = gVar;
                super(2);
            }

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                AppMethodBeat.i(14810);
                Long[] D = D(((Number) obj).longValue(), ((Number) obj2).longValue());
                AppMethodBeat.o(14810);
                return D;
            }

            public final Long[] D(long j, long j2) {
                AppMethodBeat.i(14811);
                Long[] a = f.a(new Long[]{Long.valueOf(j2 - j), Long.valueOf(j2 - this.jSz.jSy.jRj)}, j, j2);
                AppMethodBeat.o(14811);
                return a;
            }
        }

        g(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14812);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this);
            ab.v(this.jSy.TAG, "terry trace speedMatrix");
            if (this.jSy.jRj == -1) {
                this.jSy.jRj = this.jSy.jRv;
            }
            x xVar = new x(19);
            xVar.add(Long.valueOf(this.jSy.jRm));
            xVar.add(Long.valueOf(this.jSy.jRl));
            xVar.m15do(f.a(new Long[]{Long.valueOf(this.jSy.jRv - this.jSy.jRj), Long.valueOf(this.jSy.jRv - this.jSy.jRj)}, this.jSy.jRv));
            xVar.m15do(f.a(new Long[]{Long.valueOf(this.jSy.jRw - this.jSy.jRv), Long.valueOf(this.jSy.jRw - this.jSy.jRj)}, this.jSy.jRv, this.jSy.jRw));
            xVar.m15do(f.a(new Long[]{Long.valueOf(this.jSy.jRF - this.jSy.jRD), Long.valueOf(this.jSy.jRF - this.jSy.jRj)}, this.jSy.jRD, this.jSy.jRF));
            xVar.m15do(f.a(new Long[]{Long.valueOf(this.jSy.jRB - this.jSy.jRA), Long.valueOf(this.jSy.jRB - this.jSy.jRj)}, this.jSy.jRA, this.jSy.jRB));
            xVar.m15do(f.a(new Long[]{Long.valueOf(this.jSy.jRH - this.jSy.jRG), Long.valueOf(this.jSy.jRH - this.jSy.jRj)}, this.jSy.jRH, this.jSy.jRG));
            xVar.m15do(f.a(new Long[]{Long.valueOf(this.jSy.jRI - this.jSy.jRH), Long.valueOf(this.jSy.jRI - this.jSy.jRj)}, this.jSy.jRH, this.jSy.jRI));
            xVar.m15do(f.a(new Long[]{Long.valueOf(this.jSy.jRu - this.jSy.jRt), Long.valueOf(this.jSy.jRu - this.jSy.jRj)}, this.jSy.jRt, this.jSy.jRu));
            xVar.m15do(f.a(new Long[]{Long.valueOf(this.jSy.jRs - this.jSy.jRr), Long.valueOf(this.jSy.jRs - this.jSy.jRj)}, this.jSy.jRr, this.jSy.jRs));
            xVar.m15do(f.a(new Long[]{Long.valueOf(this.jSy.jRy - this.jSy.jRx), Long.valueOf(this.jSy.jRy - this.jSy.jRj)}, this.jSy.jRx, this.jSy.jRy));
            xVar.m15do(anonymousClass1.D(this.jSy.jRJ, this.jSy.jRK));
            xVar.m15do(anonymousClass1.D(this.jSy.jRK, this.jSy.jRL));
            xVar.m15do(anonymousClass1.D(this.jSy.jRL, this.jSy.jRM));
            xVar.m15do(anonymousClass1.D(this.jSy.jRM, this.jSy.jRN));
            xVar.m15do(anonymousClass1.D(this.jSy.jRN, this.jSy.jRO));
            xVar.m15do(anonymousClass1.D(this.jSy.jRO, this.jSy.jRP));
            xVar.m15do(anonymousClass1.D(this.jSy.jRP, this.jSy.jRQ));
            xVar.m15do(anonymousClass1.D(this.jSy.jRQ, this.jSy.jRR));
            Long[] lArr = (Long[]) xVar.toArray(new Long[xVar.ckx.size()]);
            AppMethodBeat.o(14812);
            return lArr;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class p extends a.f.b.k implements a.f.a.a<String> {
        public static final p jSC = new p();

        static {
            AppMethodBeat.i(14832);
            AppMethodBeat.o(14832);
        }

        p() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14831);
            Object obj;
            if (ah.bqo()) {
                String str = "mm";
                AppMethodBeat.o(14831);
                return str;
            } else if (ah.doF()) {
                obj = "tools";
                AppMethodBeat.o(14831);
                return obj;
            } else if (ah.doG()) {
                obj = "toolsmp";
                AppMethodBeat.o(14831);
                return obj;
            } else {
                obj = "unknow";
                AppMethodBeat.o(14831);
                return obj;
            }
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"format", "", "kotlin.jvm.PlatformType", "", "digits", "", "invoke"})
    static final class h extends a.f.b.k implements a.f.a.m<Float, Integer, String> {
        public static final h jSA = new h();

        static {
            AppMethodBeat.i(14815);
            AppMethodBeat.o(14815);
        }

        h() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(14813);
            String c = c(((Number) obj).floatValue(), ((Number) obj2).intValue());
            AppMethodBeat.o(14813);
            return c;
        }

        public static String c(float f, int i) {
            AppMethodBeat.i(14814);
            String format = String.format("%." + i + 'f', new Object[]{Float.valueOf(f)});
            AppMethodBeat.o(14814);
            return format;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"toDate", "", "", "invoke"})
    static final class j extends a.f.b.k implements a.f.a.b<Long, String> {
        public static final j jSB = new j();

        static {
            AppMethodBeat.i(14820);
            AppMethodBeat.o(14820);
        }

        j() {
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(14818);
            String gN = gN(((Number) obj).longValue());
            AppMethodBeat.o(14818);
            return gN;
        }

        public static String gN(long j) {
            AppMethodBeat.i(14819);
            String format = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(j));
            a.f.b.j.o(format, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
            AppMethodBeat.o(14819);
            return format;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ f jSy;

        b(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14805);
            String FJ = b.FJ(this.jSy.url);
            AppMethodBeat.o(14805);
            return FJ;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ f jSy;

        e(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14808);
            String FK = b.FK(this.jSy.url);
            AppMethodBeat.o(14808);
            return FK;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printDebugger", "", "invoke"})
    static final class k extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ f jSy;

        k(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14821);
            String aXd = aXd();
            AppMethodBeat.o(14821);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.i(14822);
            StringBuilder stringBuilder = new StringBuilder();
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a aVar = g.jSD;
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXk()) {
                stringBuilder.append("\nno re-direct;");
            }
            aVar = g.jSD;
            if (!com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXf()) {
                stringBuilder.append("\nno preload data;");
            }
            aVar = g.jSD;
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXl()) {
                stringBuilder.append("\nno preload webview;");
            }
            aVar = g.jSD;
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXh()) {
                stringBuilder.append("\ndata no expire;");
            }
            aVar = g.jSD;
            if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a.aXm()) {
                stringBuilder.append("\nno red;");
            }
            String str = this.jSy.aWY().upP;
            a.f.b.j.o(str, "tmplParams.headers");
            if ((!u.ar((CharSequence) str) ? 1 : null) != null) {
                stringBuilder.append(this.jSy.aWY().upP);
            }
            if (u.ar(stringBuilder)) {
                stringBuilder.append("none;");
            }
            str = stringBuilder.toString();
            a.f.b.j.o(str, "sb.toString()");
            AppMethodBeat.o(14822);
            return str;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printDataState", "", "invoke"})
    static final class l extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ f jSy;

        l(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14823);
            String aXd = aXd();
            AppMethodBeat.o(14823);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.i(14824);
            StringBuilder stringBuilder = new StringBuilder();
            if (!this.jSy.jRS) {
                stringBuilder.append("async;");
            }
            if (this.jSy.jRW) {
                stringBuilder.append("mounted;");
            }
            if (this.jSy.jSa) {
                stringBuilder.append("cache_tmpl;");
            }
            if (u.ar(stringBuilder)) {
                stringBuilder.append("ok;");
            }
            String stringBuilder2 = stringBuilder.toString();
            a.f.b.j.o(stringBuilder2, "sb.toString()");
            AppMethodBeat.o(14824);
            return stringBuilder2;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printProcessState", "", "invoke"})
    static final class n extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ f jSy;

        n(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14827);
            String aXd = aXd();
            AppMethodBeat.o(14827);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.i(14828);
            StringBuilder stringBuilder = new StringBuilder();
            if (this.jSy.jSc == 1) {
                stringBuilder.append("relanuch;");
            }
            if (!this.jSy.jSb) {
                stringBuilder.append("cold;");
            }
            if (u.ar(stringBuilder)) {
                stringBuilder.append("ok;");
            }
            String stringBuilder2 = stringBuilder.toString();
            a.f.b.j.o(stringBuilder2, "sb.toString()");
            AppMethodBeat.o(14828);
            return stringBuilder2;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<Long> {
        final /* synthetic */ f jSy;

        c(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            long j = 0;
            AppMethodBeat.i(14806);
            as FL = b.FL(f.b(this.jSy));
            if (FL != null) {
                j = FL.getLong(f.b(this.jSy), 0);
            }
            Long valueOf = Long.valueOf(j);
            AppMethodBeat.o(14806);
            return valueOf;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<Integer> {
        final /* synthetic */ f jSy;

        d(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            AppMethodBeat.i(14807);
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            ef FP = PreloadLogic.aXp().FP(this.jSy.url);
            if (FP != null) {
                i = FP.vFY;
            } else {
                i = 0;
            }
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.o(14807);
            return valueOf;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class f extends a.f.b.k implements a.f.a.a<Integer> {
        final /* synthetic */ f jSy;

        f(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14809);
            Integer valueOf = Integer.valueOf(b.FN(f.a(this.jSy)));
            AppMethodBeat.o(14809);
            return valueOf;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printWebViewState", "", "invoke"})
    static final class m extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ f jSy;

        m(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14825);
            String aXd = aXd();
            AppMethodBeat.o(14825);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.i(14826);
            StringBuilder stringBuilder = new StringBuilder();
            if (this.jSy.jSc == 2) {
                stringBuilder.append("relanuch;");
            }
            if (!this.jSy.jRT) {
                stringBuilder.append("cold;");
            }
            if (!this.jSy.jRV) {
                stringBuilder.append("inject fail;");
            }
            if (this.jSy.jSt) {
                stringBuilder.append("h5;");
            }
            if (this.jSy.jRZ) {
                stringBuilder.append("xweb_cc;");
            }
            if (u.ar(stringBuilder)) {
                stringBuilder.append("ok;");
            }
            String stringBuilder2 = stringBuilder.toString();
            a.f.b.j.o(stringBuilder2, "sb.toString()");
            AppMethodBeat.o(14826);
            return stringBuilder2;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printTmplState", "", "invoke"})
    static final class o extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ f jSy;

        o(f fVar) {
            this.jSy = fVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(14829);
            String aXd = aXd();
            AppMethodBeat.o(14829);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.i(14830);
            StringBuilder stringBuilder = new StringBuilder();
            if (this.jSy.jRX) {
                stringBuilder.append("zip;");
            }
            if (this.jSy.jRY) {
                stringBuilder.append("prefixMP;");
            }
            if (u.ar(stringBuilder)) {
                stringBuilder.append("none;");
            }
            String stringBuilder2 = stringBuilder.toString();
            a.f.b.j.o(stringBuilder2, "sb.toString()");
            AppMethodBeat.o(14830);
            return stringBuilder2;
        }
    }

    static {
        AppMethodBeat.i(14833);
        AppMethodBeat.o(14833);
    }

    private final String aWZ() {
        AppMethodBeat.i(14835);
        String str = (String) this.jRd.getValue();
        AppMethodBeat.o(14835);
        return str;
    }

    private final int aXa() {
        AppMethodBeat.i(14836);
        int intValue = ((Number) this.jRe.getValue()).intValue();
        AppMethodBeat.o(14836);
        return intValue;
    }

    private final String aXb() {
        AppMethodBeat.i(14837);
        String str = (String) this.jSs.getValue();
        AppMethodBeat.o(14837);
        return str;
    }

    private final Long[] aXc() {
        AppMethodBeat.i(14838);
        Long[] lArr = (Long[]) this.jSv.getValue();
        AppMethodBeat.o(14838);
        return lArr;
    }

    public f() {
        AppMethodBeat.i(14842);
        AppMethodBeat.o(14842);
    }

    public static final /* synthetic */ String a(f fVar) {
        AppMethodBeat.i(14844);
        String aWZ = fVar.aWZ();
        AppMethodBeat.o(14844);
        return aWZ;
    }

    public final TmplParams aWY() {
        AppMethodBeat.i(14834);
        TmplParams tmplParams = this.jRb;
        if (tmplParams == null) {
            a.f.b.j.avw("tmplParams");
        }
        AppMethodBeat.o(14834);
        return tmplParams;
    }

    public final void IF() {
        AppMethodBeat.i(14839);
        if (this.jSd && this.jSe) {
            Object encode;
            int i;
            int i2;
            TmplParams tmplParams = this.jRb;
            if (tmplParams == null) {
                a.f.b.j.avw("tmplParams");
            }
            com.tencent.mm.plugin.webview.preload.a.gu(tmplParams.upQ, 132);
            String aWX = d.aWX();
            this.jSf = Math.max(this.jRk, this.jRu);
            this.jSg = this.jRk < this.jRu ? 1 : 2;
            this.jSh = this.jSf - this.jRj;
            this.jSn = this.jRo - this.jRj;
            this.jSm = this.jRy - this.jRz;
            this.jSo = this.jRu - this.jRj;
            this.jSp = this.jRu - this.jRt;
            this.jRl = this.jRk - this.jRj;
            this.jSi = this.jRv - this.jRj;
            this.jSj = this.jRw - this.jRv;
            this.jSl = this.jRq - this.jRp;
            this.jSk = this.jRy - this.jRx;
            this.jRi = this.jRy - this.jRz;
            this.jSq = ((((this.jSi + this.jSj) + this.jSl) + this.jSk) + this.jRn) + this.jRm;
            String str = this.TAG;
            String str2 = "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b";
            Object[] objArr = new Object[23];
            TmplParams tmplParams2 = this.jRb;
            if (tmplParams2 == null) {
                a.f.b.j.avw("tmplParams");
            }
            objArr[0] = Integer.valueOf(tmplParams2.version);
            objArr[1] = this.url;
            objArr[2] = Integer.valueOf(aXa());
            objArr[3] = aWX;
            objArr[4] = Long.valueOf(this.jSh);
            objArr[5] = Integer.valueOf(this.jSg);
            objArr[6] = Long.valueOf(this.jRm);
            objArr[7] = Long.valueOf(this.jSo);
            objArr[8] = Boolean.valueOf(this.jRT);
            objArr[9] = Long.valueOf(this.jRB - this.jRA);
            objArr[10] = Boolean.valueOf(this.jRS);
            objArr[11] = Long.valueOf(this.jSl);
            objArr[12] = Long.valueOf(this.jSp);
            objArr[13] = Long.valueOf(this.jSn);
            objArr[14] = Long.valueOf(this.jRn);
            objArr[15] = Long.valueOf(this.jRm);
            TmplParams tmplParams3 = this.jRb;
            if (tmplParams3 == null) {
                a.f.b.j.avw("tmplParams");
            }
            objArr[16] = Integer.valueOf(tmplParams3.jSV);
            tmplParams3 = this.jRb;
            if (tmplParams3 == null) {
                a.f.b.j.avw("tmplParams");
            }
            objArr[17] = tmplParams3.jSY;
            objArr[18] = this.jSr;
            objArr[19] = aXb();
            objArr[20] = Integer.valueOf(this.jSu);
            objArr[21] = Long.valueOf(this.jSm);
            objArr[22] = Boolean.valueOf(this.jSb);
            ab.d(str, str2, objArr);
            if (!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
                boolean z = com.tencent.mm.sdk.platformtools.f.DEBUG;
            }
            try {
                str = this.url;
                if (str == null) {
                    a.f.b.j.dWJ();
                }
                encode = q.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ab.printErrStackTrace(this.TAG, e, "url:%d", this.url);
                encode = null;
            }
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            int i3 = this.jRa;
            Object[] objArr2 = new Object[26];
            TmplParams tmplParams4 = this.jRb;
            if (tmplParams4 == null) {
                a.f.b.j.avw("tmplParams");
            }
            objArr2[0] = Integer.valueOf(tmplParams4.version);
            objArr2[1] = encode;
            objArr2[2] = Integer.valueOf(aXa());
            objArr2[3] = aWX;
            objArr2[4] = Long.valueOf(gM(this.jSh));
            objArr2[5] = Integer.valueOf(this.jSg);
            objArr2[6] = Long.valueOf(gM(this.jRl));
            objArr2[7] = Long.valueOf(gM(this.jSo));
            if (this.jRT) {
                i = 1;
            } else {
                i = 0;
            }
            objArr2[8] = Integer.valueOf(i);
            objArr2[9] = Long.valueOf(gM(this.jRB - this.jRA));
            if (this.jRS) {
                i = 1;
            } else {
                i = 0;
            }
            objArr2[10] = Integer.valueOf(i);
            objArr2[11] = Long.valueOf(gM(this.jSl));
            objArr2[12] = Long.valueOf(gM(this.jSp));
            objArr2[13] = Long.valueOf(gM(this.jSn));
            objArr2[14] = Long.valueOf(gM(this.jRn));
            objArr2[15] = Long.valueOf(gM(this.jRm));
            TmplParams tmplParams5 = this.jRb;
            if (tmplParams5 == null) {
                a.f.b.j.avw("tmplParams");
            }
            objArr2[16] = Integer.valueOf(tmplParams5.jSV);
            tmplParams5 = this.jRb;
            if (tmplParams5 == null) {
                a.f.b.j.avw("tmplParams");
            }
            objArr2[17] = tmplParams5.jSY;
            objArr2[18] = this.jSr;
            objArr2[19] = aXb();
            objArr2[20] = Integer.valueOf(this.jSu);
            objArr2[21] = Long.valueOf(gM(this.jSm));
            if (this.jSb) {
                i = 1;
            } else {
                i = 0;
            }
            objArr2[22] = Integer.valueOf(i);
            objArr2[23] = Long.valueOf(gM(this.jSi));
            objArr2[24] = Long.valueOf(gM(this.jSj));
            objArr2[25] = Long.valueOf(gM(this.jSk));
            hVar.e(i3, objArr2);
            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.pYm;
            x xVar = new x(19);
            xVar.add(encode);
            xVar.add(Integer.valueOf(this.jSu));
            xVar.add(aWX);
            xVar.add(Integer.valueOf(aXa()));
            tmplParams = this.jRb;
            if (tmplParams == null) {
                a.f.b.j.avw("tmplParams");
            }
            xVar.add(tmplParams.jSY);
            xVar.add(aXb());
            xVar.add(this.jSr);
            if (this.jRS) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            xVar.add(Integer.valueOf(i2));
            if (this.jSb) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            xVar.add(Integer.valueOf(i2));
            if (this.jRT) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i2 != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            xVar.add(Integer.valueOf(i2));
            xVar.add(Integer.valueOf(this.jSc));
            if (this.jRW) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            xVar.add(Integer.valueOf(i2));
            if (this.jRV) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            xVar.add(Integer.valueOf(i2));
            xVar.add(Long.valueOf(this.jSh));
            xVar.m15do(aXc());
            xVar.add(this.key);
            if (this.jRX) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            xVar.add(Integer.valueOf(i2));
            if (this.jRZ) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            xVar.add(Integer.valueOf(i2));
            xVar.add(Long.valueOf(this.jRC));
            hVar2.e(16874, xVar.toArray(new Object[xVar.ckx.size()]));
            com.tencent.mm.plugin.webview.preload.a.IU(0);
            if (this.jRX) {
                com.tencent.mm.plugin.webview.preload.a.IU(111);
                tmplParams = this.jRb;
                if (tmplParams == null) {
                    a.f.b.j.avw("tmplParams");
                }
                com.tencent.mm.plugin.webview.preload.a.gu(tmplParams.upQ, 232);
            }
            if (this.jRZ) {
                com.tencent.mm.plugin.webview.preload.a.IU(113);
            }
            com.tencent.mm.plugin.webview.preload.a.ae(1, this.jSh);
            com.tencent.mm.plugin.webview.preload.a.ae(2, this.jRl);
            long j = this.jRv - this.jRj;
            if (this.jSb) {
                com.tencent.mm.plugin.webview.preload.a.ae(10, this.jSh);
                com.tencent.mm.plugin.webview.preload.a.ae(11, this.jRl);
                com.tencent.mm.plugin.webview.preload.a.ae(12, j);
                com.tencent.mm.plugin.webview.preload.a.ae(13, this.jRF - this.jRD);
                com.tencent.mm.plugin.webview.preload.a.ae(14, this.jRB - this.jRA);
                com.tencent.mm.plugin.webview.preload.a.ae(15, this.jRy - this.jRx);
            } else {
                com.tencent.mm.plugin.webview.preload.a.ae(20, this.jSh);
                com.tencent.mm.plugin.webview.preload.a.ae(21, this.jRl);
                com.tencent.mm.plugin.webview.preload.a.ae(22, j);
                com.tencent.mm.plugin.webview.preload.a.ae(23, this.jRF - this.jRD);
                if (!this.jRS) {
                    com.tencent.mm.plugin.webview.preload.a.ae(24, this.jRs - this.jRr);
                    com.tencent.mm.plugin.webview.preload.a.IU(107);
                }
            }
            ab.i(this.TAG, "terry performance report:" + this.jRj + 10 + a.a.i.a((Object[]) aXc(), null, null, null, 0, null, null, 63));
            AppMethodBeat.o(14839);
            return;
        }
        AppMethodBeat.o(14839);
    }

    private final long gM(long j) {
        AppMethodBeat.i(14840);
        long min = Math.min(Math.max(-this.jSw, j), this.jSw);
        AppMethodBeat.o(14840);
        return min;
    }

    public final String toString() {
        AppMethodBeat.i(14841);
        h hVar = h.jSA;
        i iVar = new i(this);
        j jVar = j.jSB;
        ab.v(this.TAG, "terry performance log:\n" + this.jSi + ',' + this.jSj + ',' + (this.jRF - this.jRw) + ',' + (Math.max(this.jRF, this.jRB) - this.jRF) + ',' + (this.jRx - Math.max(this.jRF, this.jRB)) + ',' + this.jSk);
        ab.v(this.TAG, "terry performance timestamp:\n " + a.a.i.a((Object[]) aXc(), null, null, null, 0, null, null, 63));
        k kVar = new k(this);
        l lVar = new l(this);
        m mVar = new m(this);
        n nVar = new n(this);
        o oVar = new o(this);
        StringBuilder append = new StringBuilder("\n            [debug]\n            info: ").append(aWZ()).append("\n            settings: ").append(kVar.aXd()).append("\n\n            [process]\n            process: ").append(aXb()).append("\n            state: ").append(nVar.aXd()).append("\n\n            [webview]\n            kind: ").append(this.jSr).append("\n            state: ").append(mVar.aXd()).append("\n\n            [tmpl]\n            uid: ");
        TmplParams tmplParams = this.jRb;
        if (tmplParams == null) {
            a.f.b.j.avw("tmplParams");
        }
        append = append.append(tmplParams.jSY).append("\n            tmplType: ");
        tmplParams = this.jRb;
        if (tmplParams == null) {
            a.f.b.j.avw("tmplParams");
        }
        append = append.append(tmplParams.jSV).append("\n            version: ");
        tmplParams = this.jRb;
        if (tmplParams == null) {
            a.f.b.j.avw("tmplParams");
        }
        append = append.append(tmplParams.version).append("\n            md5: ");
        tmplParams = this.jRb;
        if (tmplParams == null) {
            a.f.b.j.avw("tmplParams");
        }
        append = append.append(tmplParams.cvZ).append("\n            time: ");
        tmplParams = this.jRb;
        if (tmplParams == null) {
            a.f.b.j.avw("tmplParams");
        }
        String stringBuilder = append.append(j.gN(tmplParams.qOg)).append("\n            state: ").append(oVar.aXd()).append("\n\n            [data]\n            dataSize: ").append(h.c(((float) aXa()) / 1024.0f, 2)).append("Kb\n            dataTime: ").append(this.jSl).append("\n            cached: ").append(j.gN(((Number) this.jRg.getValue()).longValue())).append("\n            version: ").append(((Number) this.jRh.getValue()).intValue()).append("\n            expire in: ").append(this.jRc).append("s\n            scene: ").append(this.jSu).append("\n            state: ").append(lVar.aXd()).append("\n\n            [performance](ms)\n            finishType: ").append(this.jSg).append("\n            finishTime: ").append(this.jSh).append(this.jSh != Math.max(this.jSo, this.jSq) ? "/" + iVar.gN(this.jSq) : "").append("\n            firstScreenFinish: ").append(iVar.gN(this.jRl)).append(IOUtils.DIR_SEPARATOR_UNIX).append(iVar.gN(this.jSq)).append("\n            a8keyFinish: ").append(this.jSo).append("\n\n            client:\n            TmplCostTime: ").append(this.jRB - this.jRA).append("\n            WebViewUICostTime: ").append(this.jRF - this.jRD).append("\n            NotifyPageCostTime: ").append(this.jRC - this.jRy).append("\n\n            1.bindWebViewCostTime: ").append(this.jSi).append("\n            2.createWebViewCostTime: ").append(this.jSj).append("\n            3.getPageDataCostTime: ").append(this.jSl).append("\n            4.injectCostTime: ").append(iVar.gN(this.jSk)).append("\n            eval cost: ").append(this.jRi).append("\n\n            js:\n            4.1.onReceivePageData: ").append(this.jRz - this.jRo).append("\n            5.ctWebCompile: ").append(this.jRn).append("\n            6.renderTime: ").append(this.jRm).append("\n\n            [js]webReceivePageDataTime: ").append(this.jSn).append("\n            a8KeyFinishTime: ").append(this.jSo).append("\n            getA8KeyCostTime: ").append(this.jSp).append("\n        ").toString();
        a.f.b.j.p(stringBuilder, "receiver$0");
        stringBuilder = a.k.n.ja(stringBuilder, "");
        AppMethodBeat.o(14841);
        return stringBuilder;
    }

    public static final /* synthetic */ String b(f fVar) {
        AppMethodBeat.i(14845);
        String str = (String) fVar.jRf.getValue();
        AppMethodBeat.o(14845);
        return str;
    }
}
