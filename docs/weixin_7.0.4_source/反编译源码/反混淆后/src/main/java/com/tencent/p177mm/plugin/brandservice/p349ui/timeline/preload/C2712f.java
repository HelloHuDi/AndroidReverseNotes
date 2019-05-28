package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C33739g.C33740a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.preload.C43924a;
import com.tencent.p177mm.plugin.webview.preload.TmplParams;
import com.tencent.p177mm.protocal.protobuf.C40515ef;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C31598x;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p051k.C37084n;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bT\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bu\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\u0018\u0000 ä\u00012\u00020\u0001:\u0002ä\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010Û\u0001\u001a\u00030Ü\u0001J\t\u0010Ý\u0001\u001a\u00020\bH\u0016J\r\u0010Þ\u0001\u001a\u00020\u0004*\u00020\u0004H\u0002J\r\u0010ß\u0001\u001a\u00020\f*\u00020\u0004H\u0002J-\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040a*\b\u0012\u0004\u0012\u00020\u00040a2\f\u0010á\u0001\u001a\u00030â\u0001\"\u00020\u0004H\u0002¢\u0006\u0003\u0010ã\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001b\u0010%\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b&\u0010\u001fR\u001b\u0010(\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b)\u0010\u0013R\u001a\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u000e\u00101\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010R\u001a\u00107\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u000e\u0010:\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b=\u0010\u001b\u001a\u0004\b<\u0010\u0019R\u001a\u0010>\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000e\"\u0004\b?\u0010\u0010R\u001a\u0010@\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000e\"\u0004\bA\u0010\u0010R\u001a\u0010B\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010\u0010R\u001a\u0010D\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010\u0010R\u001a\u0010F\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000e\"\u0004\bG\u0010\u0010R\u001a\u0010H\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000e\"\u0004\bI\u0010\u0010R\u001a\u0010J\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000e\"\u0004\bK\u0010\u0010R\u001a\u0010L\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000e\"\u0004\bM\u0010\u0010R\u001a\u0010N\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010\u0010R\u001a\u0010P\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0019\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0013\"\u0004\bV\u0010\u0015R\u001b\u0010W\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\bY\u0010\u001b\u001a\u0004\bX\u0010\u0013R\u000e\u0010Z\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010]\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0013\"\u0004\b_\u0010\u0015R!\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00040a8BX\u0002¢\u0006\f\n\u0004\bd\u0010\u001b\u001a\u0004\bb\u0010cR\u001a\u0010e\u001a\u00020fX.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u001f\"\u0004\bm\u0010!R\u001a\u0010n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u001f\"\u0004\bp\u0010!R\u001a\u0010q\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u001f\"\u0004\bs\u0010!R\u001a\u0010t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u001f\"\u0004\bv\u0010!R\u001a\u0010w\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u001f\"\u0004\by\u0010!R\u001a\u0010z\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u001f\"\u0004\b|\u0010!R\u001a\u0010}\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u001f\"\u0004\b\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b\u0001\u0010!R\u001d\u0010\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001f\"\u0005\b \u0001\u0010!R\u001d\u0010¡\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u001f\"\u0005\b£\u0001\u0010!R\u001d\u0010¤\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u001f\"\u0005\b¦\u0001\u0010!R\u001d\u0010§\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\u001f\"\u0005\b©\u0001\u0010!R\u001d\u0010ª\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010\u001f\"\u0005\b¬\u0001\u0010!R\u001d\u0010­\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u001f\"\u0005\b¯\u0001\u0010!R\u001d\u0010°\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010\u001f\"\u0005\b²\u0001\u0010!R\u001d\u0010³\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010\u001f\"\u0005\bµ\u0001\u0010!R\u001d\u0010¶\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010\u001f\"\u0005\b¸\u0001\u0010!R\u001d\u0010¹\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010\u001f\"\u0005\b»\u0001\u0010!R\u001d\u0010¼\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010\u001f\"\u0005\b¾\u0001\u0010!R\u001d\u0010¿\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010\u001f\"\u0005\bÁ\u0001\u0010!R\u001d\u0010Â\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010\u001f\"\u0005\bÄ\u0001\u0010!R\u001d\u0010Å\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010\u001f\"\u0005\bÇ\u0001\u0010!R\u001d\u0010È\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u0010\u001f\"\u0005\bÊ\u0001\u0010!R\u001d\u0010Ë\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010\u001f\"\u0005\bÍ\u0001\u0010!R\u001d\u0010Î\u0001\u001a\u00020\bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010\u0019\"\u0005\bÐ\u0001\u0010SR\u001d\u0010Ñ\u0001\u001a\u00020\fX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010\u000e\"\u0005\bÓ\u0001\u0010\u0010R\u000f\u0010Ô\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010Õ\u0001\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÖ\u0001\u0010\u0019\"\u0005\b×\u0001\u0010SR\u001e\u0010Ø\u0001\u001a\u00020\b8BX\u0002¢\u0006\u000e\n\u0005\bÚ\u0001\u0010\u001b\u001a\u0005\bÙ\u0001\u0010\u0019¨\u0006å\u0001"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "invalidId", "getInvalidId", "invalidId$delegate", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/plugin/webview/preload/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "report", "", "toString", "limit", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f */
public final class C2712f {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C2712f.class), "contentId", "getContentId()Ljava/lang/String;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C2712f.class), "pageDataSize", "getPageDataSize()I")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C2712f.class), "invalidId", "getInvalidId()Ljava/lang/String;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C2712f.class), "dataCachedTime", "getDataCachedTime()J")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C2712f.class), "dataVersion", "getDataVersion()I")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C2712f.class), "webviewProcess", "getWebviewProcess()Ljava/lang/String;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C2712f.class), "speedMatrix", "getSpeedMatrix()[Ljava/lang/Long;"))};
    public static final C2714a jSx = new C2714a();
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
    private final C44856f jRd = C17344i.m26854g(new C2720b(this));
    private final C44856f jRe = C17344i.m26854g(new C2727f(this));
    private final C44856f jRf = C17344i.m26854g(new C2721e(this));
    private final C44856f jRg = C17344i.m26854g(new C2725c(this));
    private final C44856f jRh = C17344i.m26854g(new C2726d(this));
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
    private final C44856f jSs = C17344i.m26854g(C2717p.jSC);
    public boolean jSt;
    public int jSu = Downloads.MIN_WAIT_FOR_NETWORK;
    private final C44856f jSv = C17344i.m26854g(new C2715g(this));
    private long jSw = 3600000;
    public String key = "";
    public String url = "";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"verify", "", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$i */
    static final class C2713i extends C25053k implements C17126b<Long, String> {
        final /* synthetic */ C2712f jSy;

        C2713i(C2712f c2712f) {
            this.jSy = c2712f;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(14816);
            String gN = mo6794gN(((Number) obj).longValue());
            AppMethodBeat.m2505o(14816);
            return gN;
        }

        /* renamed from: gN */
        public final String mo6794gN(long j) {
            AppMethodBeat.m2504i(14817);
            String valueOf;
            if (C2712f.m4959a(this.jSy, j)) {
                valueOf = String.valueOf(j);
                AppMethodBeat.m2505o(14817);
                return valueOf;
            }
            valueOf = "NaN";
            AppMethodBeat.m2505o(14817);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$a */
    public static final class C2714a {
        private C2714a() {
        }

        public /* synthetic */ C2714a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/Long;"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$g */
    static final class C2715g extends C25053k implements C31214a<Long[]> {
        final /* synthetic */ C2712f jSy;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, dWq = {"getDuractionMatrix", "", "", "start", "end", "invoke", "(JJ)[Ljava/lang/Long;"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$g$1 */
        static final class C27161 extends C25053k implements C31591m<Long, Long, Long[]> {
            final /* synthetic */ C2715g jSz;

            C27161(C2715g c2715g) {
                this.jSz = c2715g;
                super(2);
            }

            /* renamed from: m */
            public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
                AppMethodBeat.m2504i(14810);
                Long[] D = mo6795D(((Number) obj).longValue(), ((Number) obj2).longValue());
                AppMethodBeat.m2505o(14810);
                return D;
            }

            /* renamed from: D */
            public final Long[] mo6795D(long j, long j2) {
                AppMethodBeat.m2504i(14811);
                Long[] a = C2712f.m4960a(new Long[]{Long.valueOf(j2 - j), Long.valueOf(j2 - this.jSz.jSy.jRj)}, j, j2);
                AppMethodBeat.m2505o(14811);
                return a;
            }
        }

        C2715g(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14812);
            C27161 c27161 = new C27161(this);
            C4990ab.m7418v(this.jSy.TAG, "terry trace speedMatrix");
            if (this.jSy.jRj == -1) {
                this.jSy.jRj = this.jSy.jRv;
            }
            C31598x c31598x = new C31598x(19);
            c31598x.add(Long.valueOf(this.jSy.jRm));
            c31598x.add(Long.valueOf(this.jSy.jRl));
            c31598x.mo51593do(C2712f.m4960a(new Long[]{Long.valueOf(this.jSy.jRv - this.jSy.jRj), Long.valueOf(this.jSy.jRv - this.jSy.jRj)}, this.jSy.jRv));
            c31598x.mo51593do(C2712f.m4960a(new Long[]{Long.valueOf(this.jSy.jRw - this.jSy.jRv), Long.valueOf(this.jSy.jRw - this.jSy.jRj)}, this.jSy.jRv, this.jSy.jRw));
            c31598x.mo51593do(C2712f.m4960a(new Long[]{Long.valueOf(this.jSy.jRF - this.jSy.jRD), Long.valueOf(this.jSy.jRF - this.jSy.jRj)}, this.jSy.jRD, this.jSy.jRF));
            c31598x.mo51593do(C2712f.m4960a(new Long[]{Long.valueOf(this.jSy.jRB - this.jSy.jRA), Long.valueOf(this.jSy.jRB - this.jSy.jRj)}, this.jSy.jRA, this.jSy.jRB));
            c31598x.mo51593do(C2712f.m4960a(new Long[]{Long.valueOf(this.jSy.jRH - this.jSy.jRG), Long.valueOf(this.jSy.jRH - this.jSy.jRj)}, this.jSy.jRH, this.jSy.jRG));
            c31598x.mo51593do(C2712f.m4960a(new Long[]{Long.valueOf(this.jSy.jRI - this.jSy.jRH), Long.valueOf(this.jSy.jRI - this.jSy.jRj)}, this.jSy.jRH, this.jSy.jRI));
            c31598x.mo51593do(C2712f.m4960a(new Long[]{Long.valueOf(this.jSy.jRu - this.jSy.jRt), Long.valueOf(this.jSy.jRu - this.jSy.jRj)}, this.jSy.jRt, this.jSy.jRu));
            c31598x.mo51593do(C2712f.m4960a(new Long[]{Long.valueOf(this.jSy.jRs - this.jSy.jRr), Long.valueOf(this.jSy.jRs - this.jSy.jRj)}, this.jSy.jRr, this.jSy.jRs));
            c31598x.mo51593do(C2712f.m4960a(new Long[]{Long.valueOf(this.jSy.jRy - this.jSy.jRx), Long.valueOf(this.jSy.jRy - this.jSy.jRj)}, this.jSy.jRx, this.jSy.jRy));
            c31598x.mo51593do(c27161.mo6795D(this.jSy.jRJ, this.jSy.jRK));
            c31598x.mo51593do(c27161.mo6795D(this.jSy.jRK, this.jSy.jRL));
            c31598x.mo51593do(c27161.mo6795D(this.jSy.jRL, this.jSy.jRM));
            c31598x.mo51593do(c27161.mo6795D(this.jSy.jRM, this.jSy.jRN));
            c31598x.mo51593do(c27161.mo6795D(this.jSy.jRN, this.jSy.jRO));
            c31598x.mo51593do(c27161.mo6795D(this.jSy.jRO, this.jSy.jRP));
            c31598x.mo51593do(c27161.mo6795D(this.jSy.jRP, this.jSy.jRQ));
            c31598x.mo51593do(c27161.mo6795D(this.jSy.jRQ, this.jSy.jRR));
            Long[] lArr = (Long[]) c31598x.toArray(new Long[c31598x.ckx.size()]);
            AppMethodBeat.m2505o(14812);
            return lArr;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$p */
    static final class C2717p extends C25053k implements C31214a<String> {
        public static final C2717p jSC = new C2717p();

        static {
            AppMethodBeat.m2504i(14832);
            AppMethodBeat.m2505o(14832);
        }

        C2717p() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14831);
            Object obj;
            if (C4996ah.bqo()) {
                String str = "mm";
                AppMethodBeat.m2505o(14831);
                return str;
            } else if (C4996ah.doF()) {
                obj = "tools";
                AppMethodBeat.m2505o(14831);
                return obj;
            } else if (C4996ah.doG()) {
                obj = "toolsmp";
                AppMethodBeat.m2505o(14831);
                return obj;
            } else {
                obj = "unknow";
                AppMethodBeat.m2505o(14831);
                return obj;
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"format", "", "kotlin.jvm.PlatformType", "", "digits", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$h */
    static final class C2718h extends C25053k implements C31591m<Float, Integer, String> {
        public static final C2718h jSA = new C2718h();

        static {
            AppMethodBeat.m2504i(14815);
            AppMethodBeat.m2505o(14815);
        }

        C2718h() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(14813);
            String c = C2718h.m4969c(((Number) obj).floatValue(), ((Number) obj2).intValue());
            AppMethodBeat.m2505o(14813);
            return c;
        }

        /* renamed from: c */
        public static String m4969c(float f, int i) {
            AppMethodBeat.m2504i(14814);
            String format = String.format("%." + i + 'f', new Object[]{Float.valueOf(f)});
            AppMethodBeat.m2505o(14814);
            return format;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, dWq = {"toDate", "", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$j */
    static final class C2719j extends C25053k implements C17126b<Long, String> {
        public static final C2719j jSB = new C2719j();

        static {
            AppMethodBeat.m2504i(14820);
            AppMethodBeat.m2505o(14820);
        }

        C2719j() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(14818);
            String gN = C2719j.m4971gN(((Number) obj).longValue());
            AppMethodBeat.m2505o(14818);
            return gN;
        }

        /* renamed from: gN */
        public static String m4971gN(long j) {
            AppMethodBeat.m2504i(14819);
            String format = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(j));
            C25052j.m39375o(format, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
            AppMethodBeat.m2505o(14819);
            return format;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$b */
    static final class C2720b extends C25053k implements C31214a<String> {
        final /* synthetic */ C2712f jSy;

        C2720b(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14805);
            String FJ = C2702b.m4922FJ(this.jSy.url);
            AppMethodBeat.m2505o(14805);
            return FJ;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$e */
    static final class C2721e extends C25053k implements C31214a<String> {
        final /* synthetic */ C2712f jSy;

        C2721e(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14808);
            String FK = C2702b.m4923FK(this.jSy.url);
            AppMethodBeat.m2505o(14808);
            return FK;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printDebugger", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$k */
    static final class C2722k extends C25053k implements C31214a<String> {
        final /* synthetic */ C2712f jSy;

        C2722k(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14821);
            String aXd = aXd();
            AppMethodBeat.m2505o(14821);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.m2504i(14822);
            StringBuilder stringBuilder = new StringBuilder();
            C33740a c33740a = C33739g.jSD;
            if (C33740a.aXk()) {
                stringBuilder.append("\nno re-direct;");
            }
            c33740a = C33739g.jSD;
            if (!C33740a.aXf()) {
                stringBuilder.append("\nno preload data;");
            }
            c33740a = C33739g.jSD;
            if (C33740a.aXl()) {
                stringBuilder.append("\nno preload webview;");
            }
            c33740a = C33739g.jSD;
            if (C33740a.aXh()) {
                stringBuilder.append("\ndata no expire;");
            }
            c33740a = C33739g.jSD;
            if (C33740a.aXm()) {
                stringBuilder.append("\nno red;");
            }
            String str = this.jSy.aWY().upP;
            C25052j.m39375o(str, "tmplParams.headers");
            if ((!C6163u.m9837ar((CharSequence) str) ? 1 : null) != null) {
                stringBuilder.append(this.jSy.aWY().upP);
            }
            if (C6163u.m9837ar(stringBuilder)) {
                stringBuilder.append("none;");
            }
            str = stringBuilder.toString();
            C25052j.m39375o(str, "sb.toString()");
            AppMethodBeat.m2505o(14822);
            return str;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printDataState", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$l */
    static final class C2723l extends C25053k implements C31214a<String> {
        final /* synthetic */ C2712f jSy;

        C2723l(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14823);
            String aXd = aXd();
            AppMethodBeat.m2505o(14823);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.m2504i(14824);
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
            if (C6163u.m9837ar(stringBuilder)) {
                stringBuilder.append("ok;");
            }
            String stringBuilder2 = stringBuilder.toString();
            C25052j.m39375o(stringBuilder2, "sb.toString()");
            AppMethodBeat.m2505o(14824);
            return stringBuilder2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printProcessState", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$n */
    static final class C2724n extends C25053k implements C31214a<String> {
        final /* synthetic */ C2712f jSy;

        C2724n(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14827);
            String aXd = aXd();
            AppMethodBeat.m2505o(14827);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.m2504i(14828);
            StringBuilder stringBuilder = new StringBuilder();
            if (this.jSy.jSc == 1) {
                stringBuilder.append("relanuch;");
            }
            if (!this.jSy.jSb) {
                stringBuilder.append("cold;");
            }
            if (C6163u.m9837ar(stringBuilder)) {
                stringBuilder.append("ok;");
            }
            String stringBuilder2 = stringBuilder.toString();
            C25052j.m39375o(stringBuilder2, "sb.toString()");
            AppMethodBeat.m2505o(14828);
            return stringBuilder2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$c */
    static final class C2725c extends C25053k implements C31214a<Long> {
        final /* synthetic */ C2712f jSy;

        C2725c(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            long j = 0;
            AppMethodBeat.m2504i(14806);
            C5018as FL = C2702b.m4924FL(C2712f.m4961b(this.jSy));
            if (FL != null) {
                j = FL.getLong(C2712f.m4961b(this.jSy), 0);
            }
            Long valueOf = Long.valueOf(j);
            AppMethodBeat.m2505o(14806);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$d */
    static final class C2726d extends C25053k implements C31214a<Integer> {
        final /* synthetic */ C2712f jSy;

        C2726d(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            int i;
            AppMethodBeat.m2504i(14807);
            PreloadLogic preloadLogic = PreloadLogic.jSS;
            C40515ef FP = PreloadLogic.aXp().mo22944FP(this.jSy.url);
            if (FP != null) {
                i = FP.vFY;
            } else {
                i = 0;
            }
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.m2505o(14807);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$f */
    static final class C2727f extends C25053k implements C31214a<Integer> {
        final /* synthetic */ C2712f jSy;

        C2727f(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14809);
            Integer valueOf = Integer.valueOf(C2702b.m4926FN(C2712f.m4958a(this.jSy)));
            AppMethodBeat.m2505o(14809);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printWebViewState", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$m */
    static final class C2728m extends C25053k implements C31214a<String> {
        final /* synthetic */ C2712f jSy;

        C2728m(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14825);
            String aXd = aXd();
            AppMethodBeat.m2505o(14825);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.m2504i(14826);
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
            if (C6163u.m9837ar(stringBuilder)) {
                stringBuilder.append("ok;");
            }
            String stringBuilder2 = stringBuilder.toString();
            C25052j.m39375o(stringBuilder2, "sb.toString()");
            AppMethodBeat.m2505o(14826);
            return stringBuilder2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"printTmplState", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.f$o */
    static final class C2729o extends C25053k implements C31214a<String> {
        final /* synthetic */ C2712f jSy;

        C2729o(C2712f c2712f) {
            this.jSy = c2712f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(14829);
            String aXd = aXd();
            AppMethodBeat.m2505o(14829);
            return aXd;
        }

        public final String aXd() {
            AppMethodBeat.m2504i(14830);
            StringBuilder stringBuilder = new StringBuilder();
            if (this.jSy.jRX) {
                stringBuilder.append("zip;");
            }
            if (this.jSy.jRY) {
                stringBuilder.append("prefixMP;");
            }
            if (C6163u.m9837ar(stringBuilder)) {
                stringBuilder.append("none;");
            }
            String stringBuilder2 = stringBuilder.toString();
            C25052j.m39375o(stringBuilder2, "sb.toString()");
            AppMethodBeat.m2505o(14830);
            return stringBuilder2;
        }
    }

    static {
        AppMethodBeat.m2504i(14833);
        AppMethodBeat.m2505o(14833);
    }

    private final String aWZ() {
        AppMethodBeat.m2504i(14835);
        String str = (String) this.jRd.getValue();
        AppMethodBeat.m2505o(14835);
        return str;
    }

    private final int aXa() {
        AppMethodBeat.m2504i(14836);
        int intValue = ((Number) this.jRe.getValue()).intValue();
        AppMethodBeat.m2505o(14836);
        return intValue;
    }

    private final String aXb() {
        AppMethodBeat.m2504i(14837);
        String str = (String) this.jSs.getValue();
        AppMethodBeat.m2505o(14837);
        return str;
    }

    private final Long[] aXc() {
        AppMethodBeat.m2504i(14838);
        Long[] lArr = (Long[]) this.jSv.getValue();
        AppMethodBeat.m2505o(14838);
        return lArr;
    }

    public C2712f() {
        AppMethodBeat.m2504i(14842);
        AppMethodBeat.m2505o(14842);
    }

    /* renamed from: a */
    public static final /* synthetic */ String m4958a(C2712f c2712f) {
        AppMethodBeat.m2504i(14844);
        String aWZ = c2712f.aWZ();
        AppMethodBeat.m2505o(14844);
        return aWZ;
    }

    public final TmplParams aWY() {
        AppMethodBeat.m2504i(14834);
        TmplParams tmplParams = this.jRb;
        if (tmplParams == null) {
            C25052j.avw("tmplParams");
        }
        AppMethodBeat.m2505o(14834);
        return tmplParams;
    }

    /* renamed from: IF */
    public final void mo6791IF() {
        AppMethodBeat.m2504i(14839);
        if (this.jSd && this.jSe) {
            Object encode;
            int i;
            int i2;
            TmplParams tmplParams = this.jRb;
            if (tmplParams == null) {
                C25052j.avw("tmplParams");
            }
            C43924a.m78791gu(tmplParams.upQ, 132);
            String aWX = C2710d.aWX();
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
                C25052j.avw("tmplParams");
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
                C25052j.avw("tmplParams");
            }
            objArr[16] = Integer.valueOf(tmplParams3.jSV);
            tmplParams3 = this.jRb;
            if (tmplParams3 == null) {
                C25052j.avw("tmplParams");
            }
            objArr[17] = tmplParams3.jSY;
            objArr[18] = this.jSr;
            objArr[19] = aXb();
            objArr[20] = Integer.valueOf(this.jSu);
            objArr[21] = Long.valueOf(this.jSm);
            objArr[22] = Boolean.valueOf(this.jSb);
            C4990ab.m7411d(str, str2, objArr);
            if (!C5058f.IS_FLAVOR_RED) {
                boolean z = C5058f.DEBUG;
            }
            try {
                str = this.url;
                if (str == null) {
                    C25052j.dWJ();
                }
                encode = C18178q.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                C4990ab.printErrStackTrace(this.TAG, e, "url:%d", this.url);
                encode = null;
            }
            C7060h c7060h = C7060h.pYm;
            int i3 = this.jRa;
            Object[] objArr2 = new Object[26];
            TmplParams tmplParams4 = this.jRb;
            if (tmplParams4 == null) {
                C25052j.avw("tmplParams");
            }
            objArr2[0] = Integer.valueOf(tmplParams4.version);
            objArr2[1] = encode;
            objArr2[2] = Integer.valueOf(aXa());
            objArr2[3] = aWX;
            objArr2[4] = Long.valueOf(m4963gM(this.jSh));
            objArr2[5] = Integer.valueOf(this.jSg);
            objArr2[6] = Long.valueOf(m4963gM(this.jRl));
            objArr2[7] = Long.valueOf(m4963gM(this.jSo));
            if (this.jRT) {
                i = 1;
            } else {
                i = 0;
            }
            objArr2[8] = Integer.valueOf(i);
            objArr2[9] = Long.valueOf(m4963gM(this.jRB - this.jRA));
            if (this.jRS) {
                i = 1;
            } else {
                i = 0;
            }
            objArr2[10] = Integer.valueOf(i);
            objArr2[11] = Long.valueOf(m4963gM(this.jSl));
            objArr2[12] = Long.valueOf(m4963gM(this.jSp));
            objArr2[13] = Long.valueOf(m4963gM(this.jSn));
            objArr2[14] = Long.valueOf(m4963gM(this.jRn));
            objArr2[15] = Long.valueOf(m4963gM(this.jRm));
            TmplParams tmplParams5 = this.jRb;
            if (tmplParams5 == null) {
                C25052j.avw("tmplParams");
            }
            objArr2[16] = Integer.valueOf(tmplParams5.jSV);
            tmplParams5 = this.jRb;
            if (tmplParams5 == null) {
                C25052j.avw("tmplParams");
            }
            objArr2[17] = tmplParams5.jSY;
            objArr2[18] = this.jSr;
            objArr2[19] = aXb();
            objArr2[20] = Integer.valueOf(this.jSu);
            objArr2[21] = Long.valueOf(m4963gM(this.jSm));
            if (this.jSb) {
                i = 1;
            } else {
                i = 0;
            }
            objArr2[22] = Integer.valueOf(i);
            objArr2[23] = Long.valueOf(m4963gM(this.jSi));
            objArr2[24] = Long.valueOf(m4963gM(this.jSj));
            objArr2[25] = Long.valueOf(m4963gM(this.jSk));
            c7060h.mo8381e(i3, objArr2);
            C7060h c7060h2 = C7060h.pYm;
            C31598x c31598x = new C31598x(19);
            c31598x.add(encode);
            c31598x.add(Integer.valueOf(this.jSu));
            c31598x.add(aWX);
            c31598x.add(Integer.valueOf(aXa()));
            tmplParams = this.jRb;
            if (tmplParams == null) {
                C25052j.avw("tmplParams");
            }
            c31598x.add(tmplParams.jSY);
            c31598x.add(aXb());
            c31598x.add(this.jSr);
            if (this.jRS) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            c31598x.add(Integer.valueOf(i2));
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
            c31598x.add(Integer.valueOf(i2));
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
            c31598x.add(Integer.valueOf(i2));
            c31598x.add(Integer.valueOf(this.jSc));
            if (this.jRW) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            c31598x.add(Integer.valueOf(i2));
            if (this.jRV) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            c31598x.add(Integer.valueOf(i2));
            c31598x.add(Long.valueOf(this.jSh));
            c31598x.mo51593do(aXc());
            c31598x.add(this.key);
            if (this.jRX) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            c31598x.add(Integer.valueOf(i2));
            if (this.jRZ) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            c31598x.add(Integer.valueOf(i2));
            c31598x.add(Long.valueOf(this.jRC));
            c7060h2.mo8381e(16874, c31598x.toArray(new Object[c31598x.ckx.size()]));
            C43924a.m78788IU(0);
            if (this.jRX) {
                C43924a.m78788IU(111);
                tmplParams = this.jRb;
                if (tmplParams == null) {
                    C25052j.avw("tmplParams");
                }
                C43924a.m78791gu(tmplParams.upQ, 232);
            }
            if (this.jRZ) {
                C43924a.m78788IU(113);
            }
            C43924a.m78789ae(1, this.jSh);
            C43924a.m78789ae(2, this.jRl);
            long j = this.jRv - this.jRj;
            if (this.jSb) {
                C43924a.m78789ae(10, this.jSh);
                C43924a.m78789ae(11, this.jRl);
                C43924a.m78789ae(12, j);
                C43924a.m78789ae(13, this.jRF - this.jRD);
                C43924a.m78789ae(14, this.jRB - this.jRA);
                C43924a.m78789ae(15, this.jRy - this.jRx);
            } else {
                C43924a.m78789ae(20, this.jSh);
                C43924a.m78789ae(21, this.jRl);
                C43924a.m78789ae(22, j);
                C43924a.m78789ae(23, this.jRF - this.jRD);
                if (!this.jRS) {
                    C43924a.m78789ae(24, this.jRs - this.jRr);
                    C43924a.m78788IU(107);
                }
            }
            C4990ab.m7416i(this.TAG, "terry performance report:" + this.jRj + 10 + C36913i.m61690a((Object[]) aXc(), null, null, null, 0, null, null, 63));
            AppMethodBeat.m2505o(14839);
            return;
        }
        AppMethodBeat.m2505o(14839);
    }

    /* renamed from: gM */
    private final long m4963gM(long j) {
        AppMethodBeat.m2504i(14840);
        long min = Math.min(Math.max(-this.jSw, j), this.jSw);
        AppMethodBeat.m2505o(14840);
        return min;
    }

    public final String toString() {
        AppMethodBeat.m2504i(14841);
        C2718h c2718h = C2718h.jSA;
        C2713i c2713i = new C2713i(this);
        C2719j c2719j = C2719j.jSB;
        C4990ab.m7418v(this.TAG, "terry performance log:\n" + this.jSi + ',' + this.jSj + ',' + (this.jRF - this.jRw) + ',' + (Math.max(this.jRF, this.jRB) - this.jRF) + ',' + (this.jRx - Math.max(this.jRF, this.jRB)) + ',' + this.jSk);
        C4990ab.m7418v(this.TAG, "terry performance timestamp:\n " + C36913i.m61690a((Object[]) aXc(), null, null, null, 0, null, null, 63));
        C2722k c2722k = new C2722k(this);
        C2723l c2723l = new C2723l(this);
        C2728m c2728m = new C2728m(this);
        C2724n c2724n = new C2724n(this);
        C2729o c2729o = new C2729o(this);
        StringBuilder append = new StringBuilder("\n            [debug]\n            info: ").append(aWZ()).append("\n            settings: ").append(c2722k.aXd()).append("\n\n            [process]\n            process: ").append(aXb()).append("\n            state: ").append(c2724n.aXd()).append("\n\n            [webview]\n            kind: ").append(this.jSr).append("\n            state: ").append(c2728m.aXd()).append("\n\n            [tmpl]\n            uid: ");
        TmplParams tmplParams = this.jRb;
        if (tmplParams == null) {
            C25052j.avw("tmplParams");
        }
        append = append.append(tmplParams.jSY).append("\n            tmplType: ");
        tmplParams = this.jRb;
        if (tmplParams == null) {
            C25052j.avw("tmplParams");
        }
        append = append.append(tmplParams.jSV).append("\n            version: ");
        tmplParams = this.jRb;
        if (tmplParams == null) {
            C25052j.avw("tmplParams");
        }
        append = append.append(tmplParams.version).append("\n            md5: ");
        tmplParams = this.jRb;
        if (tmplParams == null) {
            C25052j.avw("tmplParams");
        }
        append = append.append(tmplParams.cvZ).append("\n            time: ");
        tmplParams = this.jRb;
        if (tmplParams == null) {
            C25052j.avw("tmplParams");
        }
        String stringBuilder = append.append(C2719j.m4971gN(tmplParams.qOg)).append("\n            state: ").append(c2729o.aXd()).append("\n\n            [data]\n            dataSize: ").append(C2718h.m4969c(((float) aXa()) / 1024.0f, 2)).append("Kb\n            dataTime: ").append(this.jSl).append("\n            cached: ").append(C2719j.m4971gN(((Number) this.jRg.getValue()).longValue())).append("\n            version: ").append(((Number) this.jRh.getValue()).intValue()).append("\n            expire in: ").append(this.jRc).append("s\n            scene: ").append(this.jSu).append("\n            state: ").append(c2723l.aXd()).append("\n\n            [performance](ms)\n            finishType: ").append(this.jSg).append("\n            finishTime: ").append(this.jSh).append(this.jSh != Math.max(this.jSo, this.jSq) ? "/" + c2713i.mo6794gN(this.jSq) : "").append("\n            firstScreenFinish: ").append(c2713i.mo6794gN(this.jRl)).append(IOUtils.DIR_SEPARATOR_UNIX).append(c2713i.mo6794gN(this.jSq)).append("\n            a8keyFinish: ").append(this.jSo).append("\n\n            client:\n            TmplCostTime: ").append(this.jRB - this.jRA).append("\n            WebViewUICostTime: ").append(this.jRF - this.jRD).append("\n            NotifyPageCostTime: ").append(this.jRC - this.jRy).append("\n\n            1.bindWebViewCostTime: ").append(this.jSi).append("\n            2.createWebViewCostTime: ").append(this.jSj).append("\n            3.getPageDataCostTime: ").append(this.jSl).append("\n            4.injectCostTime: ").append(c2713i.mo6794gN(this.jSk)).append("\n            eval cost: ").append(this.jRi).append("\n\n            js:\n            4.1.onReceivePageData: ").append(this.jRz - this.jRo).append("\n            5.ctWebCompile: ").append(this.jRn).append("\n            6.renderTime: ").append(this.jRm).append("\n\n            [js]webReceivePageDataTime: ").append(this.jSn).append("\n            a8KeyFinishTime: ").append(this.jSo).append("\n            getA8KeyCostTime: ").append(this.jSp).append("\n        ").toString();
        C25052j.m39376p(stringBuilder, "receiver$0");
        stringBuilder = C37084n.m62041ja(stringBuilder, "");
        AppMethodBeat.m2505o(14841);
        return stringBuilder;
    }

    /* renamed from: b */
    public static final /* synthetic */ String m4961b(C2712f c2712f) {
        AppMethodBeat.m2504i(14845);
        String str = (String) c2712f.jRf.getValue();
        AppMethodBeat.m2505o(14845);
        return str;
    }
}
