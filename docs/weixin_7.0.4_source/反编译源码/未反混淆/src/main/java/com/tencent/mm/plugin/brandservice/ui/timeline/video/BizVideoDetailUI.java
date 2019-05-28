package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.bizui.widget.BizKeyboardLinearLayout;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(6)
@a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t*\u0001N\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\u0011\u0010 \u0001\u001a\u00030\u00012\u0007\u0010¡\u0001\u001a\u000201J\n\u0010¢\u0001\u001a\u00030\u0001H\u0016J\t\u0010£\u0001\u001a\u00020;H\u0014J\t\u0010¤\u0001\u001a\u000207H\u0002J\t\u0010¥\u0001\u001a\u00020;H\u0014J\n\u0010¦\u0001\u001a\u00030\u0001H\u0002J\b\u0010§\u0001\u001a\u00030\u0001J\b\u0010¨\u0001\u001a\u00030\u0001J\n\u0010©\u0001\u001a\u00030\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030\u0001H\u0002J\n\u0010«\u0001\u001a\u00030\u0001H\u0002J\n\u0010¬\u0001\u001a\u00030\u0001H\u0002J\n\u0010­\u0001\u001a\u00030\u0001H\u0002J\n\u0010®\u0001\u001a\u00030\u0001H\u0002J\n\u0010¯\u0001\u001a\u00030\u0001H\u0002J(\u0010°\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020;2\u0007\u0010²\u0001\u001a\u00020;2\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0014J\u0016\u0010µ\u0001\u001a\u00030\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0016J\n\u0010¸\u0001\u001a\u00030\u0001H\u0016J\u0015\u0010¹\u0001\u001a\u00030\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010vH\u0016J\n\u0010»\u0001\u001a\u00030\u0001H\u0014J\u0014\u0010¼\u0001\u001a\u00030\u00012\b\u0010½\u0001\u001a\u00030¾\u0001H\u0002J\u0014\u0010¿\u0001\u001a\u00030\u00012\b\u0010¶\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Á\u0001\u001a\u00030\u0001H\u0014J\n\u0010Â\u0001\u001a\u00030\u0001H\u0014J2\u0010Ã\u0001\u001a\u00030\u00012\u0007\u0010Ä\u0001\u001a\u00020;2\u0007\u0010Å\u0001\u001a\u00020;2\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010w\u001a\u0005\u0018\u00010Ç\u0001H\u0016J\n\u0010È\u0001\u001a\u00030\u0001H\u0016J\n\u0010É\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ë\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010Ì\u0001\u001a\u00020\u001a2\u0007\u0010Í\u0001\u001a\u00020;H\u0002J\n\u0010Î\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010Ï\u0001\u001a\u00030\u00012\u0007\u0010Í\u0001\u001a\u00020;H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \b*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001e\u001a\n \b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001f\u0010\u001cR#\u0010!\u001a\n \b*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R#\u0010&\u001a\n \b*\u0004\u0018\u00010'0'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b(\u0010)R#\u0010+\u001a\n \b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b,\u0010\u001cR\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201XD¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b<\u0010=R#\u0010?\u001a\n \b*\u0004\u0018\u00010@0@8BX\u0002¢\u0006\f\n\u0004\bC\u0010\f\u001a\u0004\bA\u0010BR\u000e\u0010D\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R#\u0010E\u001a\n \b*\u0004\u0018\u00010F0F8BX\u0002¢\u0006\f\n\u0004\bI\u0010\f\u001a\u0004\bG\u0010HR#\u0010J\u001a\n \b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\bL\u0010\f\u001a\u0004\bK\u0010\u001cR\u0010\u0010M\u001a\u00020NX\u0004¢\u0006\u0004\n\u0002\u0010OR\u001a\u0010P\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010=\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020UX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010=\"\u0004\bX\u0010SR\u001b\u0010Y\u001a\u00020Z8BX\u0002¢\u0006\f\n\u0004\b]\u0010\f\u001a\u0004\b[\u0010\\R\u001a\u0010^\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0010\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R#\u0010f\u001a\n \b*\u0004\u0018\u00010g0g8BX\u0002¢\u0006\f\n\u0004\bj\u0010\f\u001a\u0004\bh\u0010iR#\u0010k\u001a\n \b*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\bn\u0010\f\u001a\u0004\bl\u0010mR\u000e\u0010o\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R#\u0010p\u001a\n \b*\u0004\u0018\u00010q0q8BX\u0002¢\u0006\f\n\u0004\bt\u0010\f\u001a\u0004\br\u0010sR\u0010\u0010u\u001a\u0004\u0018\u00010vX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010w\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\by\u0010\f\u001a\u0004\bx\u0010=R\u001a\u0010z\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010=\"\u0004\b|\u0010SR\u001a\u0010}\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010=\"\u0004\b\u0010SR\u001e\u0010\u0001\u001a\u00020;8BX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\f\u001a\u0005\b\u0001\u0010=R)\u0010\u0001\u001a\f \b*\u0005\u0018\u00010\u00010\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\f\u001a\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020;X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010=\"\u0005\b\u0001\u0010SR)\u0010\u0001\u001a\f \b*\u0005\u0018\u00010\u00010\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\f\u001a\u0006\b\u0001\u0010\u0001R&\u0010\u0001\u001a\n \b*\u0004\u0018\u00010\u00070\u00078FX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\f\u001a\u0005\b\u0001\u0010\nR)\u0010\u0001\u001a\f \b*\u0005\u0018\u00010\u00010\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\f\u001a\u0006\b\u0001\u0010\u0001¨\u0006Ð\u0001"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "adView", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getAdView", "()Landroid/widget/FrameLayout;", "adView$delegate", "Lkotlin/Lazy;", "adWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "getAdWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "adWebView$delegate", "animationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper;", "animationIv", "Landroid/widget/ImageView;", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "animationMaskView", "getAnimationMaskView", "animationMaskView$delegate", "commentListView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "getCommentListView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "commentListView$delegate", "commentView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;", "commentView$delegate", "commentViewHeader", "getCommentViewHeader", "commentViewHeader$delegate", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "debugAD", "", "density", "", "enterPageTime", "", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "getA8KeyScene", "", "getGetA8KeyScene", "()I", "getA8KeyScene$delegate", "headerView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "getHeaderView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "headerView$delegate", "isInFullScreen", "kbLayout", "Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;", "getKbLayout", "()Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;", "kbLayout$delegate", "kbTouchLayout", "getKbTouchLayout", "kbTouchLayout$delegate", "mOnForegroundListener", "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$mOnForegroundListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$mOnForegroundListener$1;", "maxVideoHeight", "getMaxVideoHeight", "setMaxVideoHeight", "(I)V", "menuHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "minVideoHeight", "getMinVideoHeight", "setMinVideoHeight", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "msgInfo$delegate", "needToDoHeightAnimation", "getNeedToDoHeightAnimation", "()Z", "setNeedToDoHeightAnimation", "(Z)V", "orientationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "pageStayTime", "previewBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;", "getPreviewBar", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;", "previewBar$delegate", "publishId", "getPublishId", "()Ljava/lang/String;", "publishId$delegate", "resumePageTime", "rootView", "Landroid/widget/RelativeLayout;", "getRootView", "()Landroid/widget/RelativeLayout;", "rootView$delegate", "saveBundle", "Landroid/os/Bundle;", "scene", "getScene", "scene$delegate", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "subScene", "getSubScene", "subScene$delegate", "videoErrView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "getVideoErrView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "videoErrView$delegate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoView$delegate", "videoViewContainer", "getVideoViewContainer", "videoViewContainer$delegate", "writeCommentContainer", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "getWriteCommentContainer", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "writeCommentContainer$delegate", "addNetSceneListener", "", "destroyReport", "destroyWebView", "doPlayVideo", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "doVideoHeightAnimation", "enableOrientationListener", "enable", "finish", "getForceOrientation", "getFullscreenImpl", "getLayoutId", "goneVideoErrorView", "init", "initActionBar", "initAd", "initCommentContainer", "initHeader", "initOrientationHelper", "initVideoBaseParam", "initVideoParam", "initVideoView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "onBackPressed", "onCreate", "savedInstanceState", "onDestroy", "onGetAdData", "appMsgAdvert", "Lcom/tencent/mm/protocal/protobuf/AppMsgAdvert;", "onGetExtData", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetExtResp;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "removeNetSceneListener", "sendScrollEvent", "setTouchListener", "view", "height", "showVideoErrorView", "updateAdHeight", "plugin-brandservice_release"})
public class BizVideoDetailUI extends MMActivity implements com.tencent.mm.ai.f {
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "rootView", "getRootView()Landroid/widget/RelativeLayout;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "animationMaskView", "getAnimationMaskView()Landroid/view/View;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "kbLayout", "getKbLayout()Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "kbTouchLayout", "getKbTouchLayout()Landroid/view/View;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "videoView", "getVideoView()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "videoErrView", "getVideoErrView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "videoViewContainer", "getVideoViewContainer()Landroid/widget/FrameLayout;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "commentViewHeader", "getCommentViewHeader()Landroid/view/View;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "headerView", "getHeaderView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "adView", "getAdView()Landroid/widget/FrameLayout;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "commentView", "getCommentView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "commentListView", "getCommentListView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "writeCommentContainer", "getWriteCommentContainer()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "previewBar", "getPreviewBar()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "adWebView", "getAdWebView()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "scene", "getScene()I")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "subScene", "getSubScene()I")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "publishId", "getPublishId()Ljava/lang/String;")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "getA8KeyScene", "getGetA8KeyScene()I")), a.f.b.v.a(new a.f.b.t(a.f.b.v.aN(BizVideoDetailUI.class), "msgInfo", "getMsgInfo()Lcom/tencent/mm/message/MPMsgInfo;"))};
    private final String TAG = "MicroMsg.BizVideoDetailUI";
    private int bpm;
    private float density;
    private int ieu;
    private int iev;
    private long ism;
    private final boolean jVT;
    private final a.f jVU = a.i.g(new aa(this));
    private final a.f jVV = a.i.g(new e(this));
    private final a.f jVW = a.i.g(new r(this));
    private final a.f jVX = a.i.g(new s(this));
    private final a.f jVY = a.i.g(new af(this));
    private final a.f jVZ = a.i.g(new ae(this));
    boolean jWA;
    private com.tencent.mm.plugin.brandservice.ui.widget.b jWB = new j(this);
    private final t jWC = new t(this);
    private final a.f jWa = a.i.g(new ag(this));
    private final a.f jWb = a.i.g(new h(this));
    private final a.f jWc = a.i.g(new l(this));
    private final a.f jWd = a.i.g(new a(this));
    private final a.f jWe = a.i.g(new g(this));
    private final a.f jWf = a.i.g(new f(this));
    private final a.f jWg = a.i.g(new ah(this));
    private final a.f jWh = a.i.g(new y(this));
    private final a.f jWi = a.i.g(new c(this));
    private final a.f jWj = a.i.g(new d(this));
    private com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g jWk = new com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g();
    private com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b jWl;
    private boolean jWm;
    private com.tencent.mm.plugin.brandservice.ui.widget.a jWn;
    private long jWo;
    private long jWp;
    private final a.f jWq = a.i.g(new b(this));
    private final a.f jWr = a.i.g(new ab(this));
    private final a.f jWs = a.i.g(new ad(this));
    private final a.f jWt = a.i.g(new z(this));
    private final a.f jWu = a.i.g(new k(this));
    private final a.f jWv = a.i.g(new u(this));
    int jWw;
    private b jWx = new b();
    private Bundle jWy;
    private com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f jWz = new com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f();
    private int videoHeight;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class k extends a.f.b.k implements a.f.a.a<Integer> {
        final /* synthetic */ BizVideoDetailUI jWD;

        k(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15153);
            Integer valueOf = Integer.valueOf(this.jWD.getIntent().getIntExtra("geta8key_scene", 0));
            AppMethodBeat.o(15153);
            return valueOf;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "enterFullScreen", "", "direction", "", "isFullScreen", "", "quitFullScreen", "plugin-brandservice_release"})
    public static final class p implements com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.a {
        final /* synthetic */ BizVideoDetailUI jWD;

        p(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void on(int i) {
            AppMethodBeat.i(15158);
            this.jWD.aYt().removeView(BizVideoDetailUI.c(this.jWD));
            this.jWD.jWm = true;
            BizVideoDetailUI.e(this.jWD).G(BizVideoDetailUI.c(this.jWD), i);
            if (i == 0 || i == 180) {
                BizVideoDetailUI.c(this.jWD).setPageGestureInFullscreen(false);
            } else {
                BizVideoDetailUI.c(this.jWD).setPageGestureInFullscreen(true);
            }
            this.jWD.jWx.jVJ.sE(5);
            AppMethodBeat.o(15158);
        }

        public final void aDF() {
            AppMethodBeat.i(15159);
            BizVideoDetailUI.e(this.jWD).aIZ();
            this.jWD.setRequestedOrientation(1);
            this.jWD.jWx.jVJ.sE(6);
            AppMethodBeat.o(15159);
        }

        public final boolean isFullScreen() {
            AppMethodBeat.i(15160);
            boolean d = this.jWD.jWm;
            AppMethodBeat.o(15160);
            return d;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$2", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "onPlayError", "", "errorMsg", "", "errorCode", "", "plugin-brandservice_release"})
    public static final class q implements com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.b {
        final /* synthetic */ BizVideoDetailUI jWD;

        q(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void Gf(String str) {
            AppMethodBeat.i(15161);
            BizVideoDetailUI.g(this.jWD).setPlayError$505cff1c(str);
            BizVideoDetailUI.h(this.jWD);
            AppMethodBeat.o(15161);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class r extends a.f.b.k implements a.f.a.a<BizKeyboardLinearLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        r(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15162);
            BizKeyboardLinearLayout bizKeyboardLinearLayout = (BizKeyboardLinearLayout) this.jWD.findViewById(R.id.a98);
            AppMethodBeat.o(15162);
            return bizKeyboardLinearLayout;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class s extends a.f.b.k implements a.f.a.a<View> {
        final /* synthetic */ BizVideoDetailUI jWD;

        s(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15163);
            View findViewById = this.jWD.findViewById(R.id.a99);
            AppMethodBeat.o(15163);
            return findViewById;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends a.f.b.k implements a.f.a.a<FrameLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        a(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15141);
            FrameLayout frameLayout = (FrameLayout) BizVideoDetailUI.k(this.jWD).findViewById(R.id.dd1);
            AppMethodBeat.o(15141);
            return frameLayout;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class ac implements OnTouchListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        ac(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(15173);
            a.f.b.j.o(motionEvent, "event");
            if (motionEvent.getAction() == 0) {
                MPVideoWriteCommentLayout i = BizVideoDetailUI.i(this.jWD);
                if (i.jYe == -3) {
                    Context context = i.getContext();
                    if (context == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(15173);
                        throw vVar;
                    }
                    ((MMActivity) context).aqX();
                } else if (i.jXV.aYU() && i.aFF()) {
                    i.jXV.aYW();
                } else {
                    i.hide();
                }
            }
            AppMethodBeat.o(15173);
            return true;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class ad extends a.f.b.k implements a.f.a.a<Integer> {
        final /* synthetic */ BizVideoDetailUI jWD;

        ad(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15174);
            Integer valueOf = Integer.valueOf(this.jWD.getIntent().getIntExtra("biz_video_subscene", 0));
            AppMethodBeat.o(15174);
            return valueOf;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ae extends a.f.b.k implements a.f.a.a<MPVideoErrorView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        ae(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15175);
            MPVideoErrorView mPVideoErrorView = (MPVideoErrorView) BizVideoDetailUI.c(this.jWD).findViewById(R.id.ddo);
            AppMethodBeat.o(15175);
            return mPVideoErrorView;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class af extends a.f.b.k implements a.f.a.a<MPVideoView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        af(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15176);
            MPVideoView mPVideoView = (MPVideoView) this.jWD.findViewById(R.id.a93);
            AppMethodBeat.o(15176);
            return mPVideoView;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$mOnForegroundListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppActiveEvent;", "callback", "", "event", "plugin-brandservice_release"})
    public static final class t extends com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k> {
        final /* synthetic */ BizVideoDetailUI jWD;

        t(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15164);
            com.tencent.mm.g.a.k kVar = (com.tencent.mm.g.a.k) bVar;
            if (!((kVar != null ? kVar.csh : null) == null || kVar.csh.csi)) {
                this.jWD.jWo = 0;
            }
            AppMethodBeat.o(15164);
            return false;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class z extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ BizVideoDetailUI jWD;

        z(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15170);
            String stringExtra = this.jWD.getIntent().getStringExtra("KPublisherId");
            AppMethodBeat.o(15170);
            return stringExtra;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends a.f.b.k implements a.f.a.a<View> {
        final /* synthetic */ BizVideoDetailUI jWD;

        h(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15150);
            View inflate = LayoutInflater.from(this.jWD.dxU()).inflate(R.layout.ahh, null, false);
            AppMethodBeat.o(15150);
            return inflate;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
    public static final class j extends com.tencent.mm.plugin.brandservice.ui.widget.b {
        final /* synthetic */ BizVideoDetailUI jWD;

        j(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void aDI() {
            AppMethodBeat.i(15152);
            this.jWD.jWm = false;
            this.jWD.aYt().addView(BizVideoDetailUI.c(this.jWD), 0);
            AppMethodBeat.o(15152);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class ab extends a.f.b.k implements a.f.a.a<Integer> {
        final /* synthetic */ BizVideoDetailUI jWD;

        ab(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15172);
            Integer valueOf = Integer.valueOf(this.jWD.getIntent().getIntExtra("biz_video_scene", 0));
            AppMethodBeat.o(15172);
            return valueOf;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<MMWebViewWithJsApi> {
        final /* synthetic */ BizVideoDetailUI jWD;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "viewHeight", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$b$2 */
        static final class AnonymousClass2 extends a.f.b.k implements a.f.a.b<Integer, a.y> {
            final /* synthetic */ b jWE;

            AnonymousClass2(b bVar) {
                this.jWE = bVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(15143);
                int intValue = ((Number) obj).intValue();
                com.tencent.mm.sdk.platformtools.ab.i(this.jWE.jWD.TAG, "config ad webview height:".concat(String.valueOf(intValue)));
                BizVideoDetailUI.a(this.jWE.jWD, intValue);
                BizVideoDetailUI.j(this.jWE.jWD);
                a.y yVar = a.y.AUy;
                AppMethodBeat.o(15143);
                return yVar;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "webViewDenisty", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$b$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.b<Float, a.y> {
            final /* synthetic */ b jWE;

            AnonymousClass1(b bVar) {
                this.jWE = bVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(15142);
                float floatValue = ((Number) obj).floatValue();
                this.jWE.jWD.density = floatValue;
                com.tencent.mm.sdk.platformtools.ab.i(this.jWE.jWD.TAG, "config ad webview density:".concat(String.valueOf(floatValue)));
                a.y yVar = a.y.AUy;
                AppMethodBeat.o(15142);
                return yVar;
            }
        }

        b(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15144);
            a aVar = a.jVq;
            MMWebViewWithJsApi fv = com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a.fv(this.jWD.dxU());
            a.f.b.j.o(fv, "MMWebViewWithJsApi.Factory.create(this.context)");
            String l = BizVideoDetailUI.l(this.jWD);
            a.f.b.j.o(l, "publishId");
            MMWebViewWithJsApi a = a.a(fv, l, new AnonymousClass1(this), new AnonymousClass2(this), BizVideoDetailUI.n(this.jWD));
            AppMethodBeat.o(15144);
            return a;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class i implements AnimatorUpdateListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        i(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(15151);
            a.f.b.j.o(valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(15151);
                throw vVar;
            }
            int intValue = ((Integer) animatedValue).intValue();
            FrameLayout aYt = this.jWD.aYt();
            a.f.b.j.o(aYt, "videoViewContainer");
            BizVideoDetailUI.Q(aYt, intValue);
            View b = BizVideoDetailUI.b(this.jWD);
            a.f.b.j.o(b, "animationLayout");
            BizVideoDetailUI.Q(b, intValue);
            AppMethodBeat.o(15151);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends a.f.b.k implements a.f.a.a<MPVideoHeaderView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        l(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15154);
            MPVideoHeaderView mPVideoHeaderView = (MPVideoHeaderView) BizVideoDetailUI.k(this.jWD).findViewById(R.id.dd0);
            AppMethodBeat.o(15154);
            return mPVideoHeaderView;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class m implements OnMenuItemClickListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        m(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(15155);
            this.jWD.aqX();
            this.jWD.finish();
            AppMethodBeat.o(15155);
            return true;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class n implements OnMenuItemClickListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        n(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(15156);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g a = this.jWD.jWk;
            if (a.isFinished() || a.jXv == null) {
                boolean z;
                String str = a.TAG;
                String str2 = "showMenu return:isFinished=%b,appMsgStat null=%b";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(a.isFinished());
                if (a.jXv == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                com.tencent.mm.sdk.platformtools.ab.i(str, str2, objArr);
            } else {
                a.iHZ = new com.tencent.mm.ui.widget.a.d(a.aYo(), 0, true);
                com.tencent.mm.ui.widget.a.d dVar = a.iHZ;
                if (dVar != null) {
                    dVar.a((com.tencent.mm.ui.base.n.c) new com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g.a(a));
                }
                dVar = a.iHZ;
                if (dVar != null) {
                    dVar.a((com.tencent.mm.ui.base.n.d) new com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g.b(a));
                }
                dVar = a.iHZ;
                if (dVar != null) {
                    dVar.q(" ", 1);
                }
                com.tencent.mm.ui.widget.a.d dVar2 = a.iHZ;
                if (dVar2 != null) {
                    dVar2.cpD();
                }
            }
            AppMethodBeat.o(15156);
            return true;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class o implements OnLongClickListener {
        public static final o jWF = new o();

        static {
            AppMethodBeat.i(15157);
            AppMethodBeat.o(15157);
        }

        o() {
        }

        public final boolean onLongClick(View view) {
            return true;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/message/MPMsgInfo;", "invoke"})
    static final class u extends a.f.b.k implements a.f.a.a<com.tencent.mm.af.r> {
        final /* synthetic */ BizVideoDetailUI jWD;

        u(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15165);
            Intent intent = this.jWD.getIntent();
            a.f.b.j.o(intent, "intent");
            com.tencent.mm.af.r R = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.R(intent);
            AppMethodBeat.o(15165);
            return R;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onScrollChanged"})
    static final class v implements OnScrollChangedListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        v(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void onScrollChanged() {
            AppMethodBeat.i(15166);
            BizVideoDetailUI.j(this.jWD);
            AppMethodBeat.o(15166);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;", "kotlin.jvm.PlatformType", "invoke"})
    static final class y extends a.f.b.k implements a.f.a.a<MPPreviewBar> {
        final /* synthetic */ BizVideoDetailUI jWD;

        y(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15169);
            MPPreviewBar mPPreviewBar = (MPPreviewBar) this.jWD.findViewById(R.id.a94);
            AppMethodBeat.o(15169);
            return mPPreviewBar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ah extends a.f.b.k implements a.f.a.a<MPVideoWriteCommentLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        ah(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15178);
            MPVideoWriteCommentLayout mPVideoWriteCommentLayout = (MPVideoWriteCommentLayout) this.jWD.findViewById(R.id.a9_);
            AppMethodBeat.o(15178);
            return mPVideoWriteCommentLayout;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<ImageView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        c(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15145);
            ImageView imageView = (ImageView) this.jWD.findViewById(R.id.a9c);
            AppMethodBeat.o(15145);
            return imageView;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends a.f.b.k implements a.f.a.a<MPVideoMRecyclerView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        f(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15148);
            MPVideoMRecyclerView mPVideoMRecyclerView = (MPVideoMRecyclerView) this.jWD.findViewById(R.id.a95);
            AppMethodBeat.o(15148);
            return mPVideoMRecyclerView;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onStart$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-brandservice_release"})
    public static final class x implements com.tencent.mm.ui.tools.e.b {
        final /* synthetic */ BizVideoDetailUI jWD;

        x(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void onAnimationStart() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.i(15168);
            if (this.jWD.jWA) {
                this.jWD.jWA = false;
                this.jWD.aYG();
            }
            AppMethodBeat.o(15168);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class aa extends a.f.b.k implements a.f.a.a<RelativeLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        aa(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15171);
            RelativeLayout relativeLayout = (RelativeLayout) this.jWD.findViewById(R.id.a91);
            AppMethodBeat.o(15171);
            return relativeLayout;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<View> {
        final /* synthetic */ BizVideoDetailUI jWD;

        d(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15146);
            View findViewById = this.jWD.findViewById(R.id.a9b);
            AppMethodBeat.o(15146);
            return findViewById;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class ag extends a.f.b.k implements a.f.a.a<FrameLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        ag(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15177);
            FrameLayout frameLayout = (FrameLayout) this.jWD.findViewById(R.id.a92);
            AppMethodBeat.o(15177);
            return frameLayout;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<View> {
        final /* synthetic */ BizVideoDetailUI jWD;

        e(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15147);
            View findViewById = this.jWD.findViewById(R.id.a9a);
            AppMethodBeat.o(15147);
            return findViewById;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends a.f.b.k implements a.f.a.a<MPVideoCommentView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        g(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(15149);
            MPVideoCommentView mPVideoCommentView = (MPVideoCommentView) BizVideoDetailUI.k(this.jWD).findViewById(R.id.dd2);
            AppMethodBeat.o(15149);
            return mPVideoCommentView;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class w implements Runnable {
        final /* synthetic */ BizVideoDetailUI jWD;

        w(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void run() {
            AppMethodBeat.i(15167);
            this.jWD.finish();
            AppMethodBeat.o(15167);
        }
    }

    static {
        AppMethodBeat.i(15179);
        AppMethodBeat.o(15179);
    }

    private final ImageView aYA() {
        AppMethodBeat.i(15190);
        ImageView imageView = (ImageView) this.jWi.getValue();
        AppMethodBeat.o(15190);
        return imageView;
    }

    private final View aYB() {
        AppMethodBeat.i(15191);
        View view = (View) this.jWj.getValue();
        AppMethodBeat.o(15191);
        return view;
    }

    private final MMWebViewWithJsApi aYC() {
        AppMethodBeat.i(15192);
        MMWebViewWithJsApi mMWebViewWithJsApi = (MMWebViewWithJsApi) this.jWq.getValue();
        AppMethodBeat.o(15192);
        return mMWebViewWithJsApi;
    }

    private final com.tencent.mm.af.r aYD() {
        AppMethodBeat.i(15193);
        com.tencent.mm.af.r rVar = (com.tencent.mm.af.r) this.jWv.getValue();
        AppMethodBeat.o(15193);
        return rVar;
    }

    private final View aYq() {
        AppMethodBeat.i(15180);
        View view = (View) this.jVV.getValue();
        AppMethodBeat.o(15180);
        return view;
    }

    private final MPVideoView aYr() {
        AppMethodBeat.i(15181);
        MPVideoView mPVideoView = (MPVideoView) this.jVY.getValue();
        AppMethodBeat.o(15181);
        return mPVideoView;
    }

    private final MPVideoErrorView aYs() {
        AppMethodBeat.i(15182);
        MPVideoErrorView mPVideoErrorView = (MPVideoErrorView) this.jVZ.getValue();
        AppMethodBeat.o(15182);
        return mPVideoErrorView;
    }

    private final View aYu() {
        AppMethodBeat.i(15184);
        View view = (View) this.jWb.getValue();
        AppMethodBeat.o(15184);
        return view;
    }

    private final MPVideoHeaderView aYv() {
        AppMethodBeat.i(15185);
        MPVideoHeaderView mPVideoHeaderView = (MPVideoHeaderView) this.jWc.getValue();
        AppMethodBeat.o(15185);
        return mPVideoHeaderView;
    }

    private final FrameLayout aYw() {
        AppMethodBeat.i(15186);
        FrameLayout frameLayout = (FrameLayout) this.jWd.getValue();
        AppMethodBeat.o(15186);
        return frameLayout;
    }

    private final MPVideoCommentView aYx() {
        AppMethodBeat.i(15187);
        MPVideoCommentView mPVideoCommentView = (MPVideoCommentView) this.jWe.getValue();
        AppMethodBeat.o(15187);
        return mPVideoCommentView;
    }

    private final MPVideoMRecyclerView aYy() {
        AppMethodBeat.i(15188);
        MPVideoMRecyclerView mPVideoMRecyclerView = (MPVideoMRecyclerView) this.jWf.getValue();
        AppMethodBeat.o(15188);
        return mPVideoMRecyclerView;
    }

    private final MPVideoWriteCommentLayout aYz() {
        AppMethodBeat.i(15189);
        MPVideoWriteCommentLayout mPVideoWriteCommentLayout = (MPVideoWriteCommentLayout) this.jWg.getValue();
        AppMethodBeat.o(15189);
        return mPVideoWriteCommentLayout;
    }

    public final FrameLayout aYt() {
        AppMethodBeat.i(15183);
        FrameLayout frameLayout = (FrameLayout) this.jWa.getValue();
        AppMethodBeat.o(15183);
        return frameLayout;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BizVideoDetailUI() {
        AppMethodBeat.i(15211);
        AppMethodBeat.o(15211);
    }

    public static final /* synthetic */ void Q(View view, int i) {
        AppMethodBeat.i(15212);
        P(view, i);
        AppMethodBeat.o(15212);
    }

    public static final /* synthetic */ View b(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(15213);
        View aYB = bizVideoDetailUI.aYB();
        AppMethodBeat.o(15213);
        return aYB;
    }

    public static final /* synthetic */ MPVideoView c(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(15214);
        MPVideoView aYr = bizVideoDetailUI.aYr();
        AppMethodBeat.o(15214);
        return aYr;
    }

    public static final /* synthetic */ MPVideoErrorView g(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(15216);
        MPVideoErrorView aYs = bizVideoDetailUI.aYs();
        AppMethodBeat.o(15216);
        return aYs;
    }

    public static final /* synthetic */ void h(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(15217);
        bizVideoDetailUI.aYJ();
        AppMethodBeat.o(15217);
    }

    public static final /* synthetic */ MPVideoWriteCommentLayout i(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(15218);
        MPVideoWriteCommentLayout aYz = bizVideoDetailUI.aYz();
        AppMethodBeat.o(15218);
        return aYz;
    }

    public static final /* synthetic */ View k(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(15220);
        View aYu = bizVideoDetailUI.aYu();
        AppMethodBeat.o(15220);
        return aYu;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(15194);
        com.tencent.mm.pluginsdk.f.m(this);
        this.jWy = bundle;
        super.onCreate(bundle);
        if (aYD().fjT == null) {
            finish();
            com.tencent.mm.sdk.platformtools.ab.w(this.TAG, "onCreate msgInfo.item is null");
            AppMethodBeat.o(15194);
            return;
        }
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("onCreate rawUrl is ");
        com.tencent.mm.af.p pVar = aYD().fjT;
        if (pVar == null) {
            a.f.b.j.dWJ();
        }
        com.tencent.mm.sdk.platformtools.ab.i(str, stringBuilder.append(pVar.url).toString());
        com.tencent.mm.kernel.g.Rg().a(1179, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().a(2866, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().a(2776, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().a(2759, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().a(2691, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().a(2617, (com.tencent.mm.ai.f) this);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g gVar = this.jWk;
        com.tencent.mm.af.r aYD = aYD();
        b bVar = this.jWx;
        a.f.b.j.p(this, "ui");
        a.f.b.j.p(aYD, "msgInfo");
        a.f.b.j.p(bVar, "controller");
        gVar.hiC = new WeakReference(this);
        gVar.jVG = aYD;
        gVar.jWx = bVar;
        xE(com.tencent.mm.bz.a.i(dxU(), R.color.a3p));
        setBackBtn(new m(this), R.raw.actionbar_icon_light_close);
        getController().l(this, WebView.NIGHT_MODE_COLOR);
        a((int) R.raw.actionbar_icon_light_more, (OnMenuItemClickListener) new n(this), (OnLongClickListener) o.jWF);
        setMMTitle("");
        MPVideoCommentView aYx = aYx();
        MPVideoMRecyclerView aYy = aYy();
        a.f.b.j.o(aYy, "commentListView");
        MRecyclerView mRecyclerView = aYy;
        View aYu = aYu();
        a.f.b.j.o(aYu, "commentViewHeader");
        b bVar2 = this.jWx;
        a.f.b.j.p(mRecyclerView, "recyclerView");
        a.f.b.j.p(aYu, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        a.f.b.j.p(bVar2, "controller");
        aYx.jWJ = mRecyclerView;
        LinkedList linkedList = new LinkedList();
        Context context = aYx.getContext();
        a.f.b.j.o(context, "context");
        aYx.jWM = new com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView.a(context, linkedList, bVar2);
        mRecyclerView.setAdapter(aYx.jWM);
        mRecyclerView.addHeaderView(aYu);
        aYx.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager());
        mRecyclerView.setNestedScrollingEnabled(false);
        MPVideoCommentView aYx2 = aYx();
        MPVideoWriteCommentLayout aYz = aYz();
        a.f.b.j.o(aYz, "writeCommentContainer");
        aYx2.setWriteCommentLayout(aYz);
        MPVideoWriteCommentLayout aYz2 = aYz();
        BizKeyboardLinearLayout bizKeyboardLinearLayout = (BizKeyboardLinearLayout) this.jVW.getValue();
        a.f.b.j.o(bizKeyboardLinearLayout, "kbLayout");
        a.f.b.j.p(bizKeyboardLinearLayout, "kbLayout");
        aYz2.jXU = bizKeyboardLinearLayout;
        bizKeyboardLinearLayout.setOnkbdStateListener(new c(aYz2, bizKeyboardLinearLayout));
        aYz().setController(this.jWx);
        bVar2 = this.jWx;
        int intValue = ((Number) this.jWr.getValue()).intValue();
        int intValue2 = ((Number) this.jWs.getValue()).intValue();
        com.tencent.mm.af.p pVar2 = aYD().fjT;
        if (pVar2 == null) {
            a.f.b.j.dWJ();
        }
        com.tencent.mm.af.r aYD2 = aYD();
        a.f.b.j.p(this, "ui");
        a.f.b.j.p(pVar2, "readerItem");
        a.f.b.j.p(aYD2, "msgInfo");
        bVar2.hiC = new WeakReference(this);
        bVar2.scene = intValue;
        bVar2.jSW = intValue2;
        bVar2.Gd(pVar2.url);
        bVar2.jVH = pVar2;
        bVar2.jVG = aYD2;
        bVar2.ffZ = pVar2.type;
        bVar2.cwG = aYD2.cwG;
        bVar2.jVz = aYD2.fjR;
        bVar2.fgd = aYD2.fjT.fgd;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.e eVar = bVar2.jVC;
        a.f.b.j.p(bVar2, "controller");
        eVar.jWx = bVar2;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.d dVar = bVar2.jVJ;
        a.f.b.j.p(bVar2, "controller");
        dVar.jWx = bVar2;
        dVar.sE(1);
        try {
            Uri parse = Uri.parse(aYD2.fjT.url);
            bVar2.jVD = bo.getLong(parse.getQueryParameter("mid"), 0);
            bVar2.jVE = bo.getInt(parse.getQueryParameter("idx"), 0);
        } catch (UnsupportedOperationException e) {
            com.tencent.mm.sdk.platformtools.ab.w(bVar2.TAG, "init parse url exp %s", e.getMessage());
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.ab.w(bVar2.TAG, "init parse url exp %s", e2.getMessage());
        }
        com.tencent.mm.sdk.platformtools.ab.i(bVar2.TAG, "init vid=" + bVar2.fgd);
        this.jWx.aYm();
        this.jWx.sB(1);
        bVar2 = this.jWx;
        eh ehVar = new eh();
        ehVar.url = bVar2.url;
        ehVar.scene = bVar2.scene;
        ehVar.vFQ = bVar2.jSW;
        ehVar.vFO = bVar2.ffZ;
        ehVar.session_id = com.tencent.mm.storage.s.getSessionId();
        ehVar.vFP = bVar2.jVF;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.a(ehVar);
        aVar.b(new ei());
        aVar.qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_getext");
        aVar.kU(2776);
        aVar.kV(0);
        aVar.kW(0);
        com.tencent.mm.ai.w.a(aVar.acD(), g.jVR);
        MPVideoHeaderView aYv = aYv();
        aYD = aYD();
        bVar = this.jWx;
        a.f.b.j.p(aYD, "msgInfo");
        a.f.b.j.p(bVar, "controller");
        aYv.jVG = aYD;
        aYv.talker = bVar.HE();
        com.tencent.mm.af.p pVar3 = aYD.fjT;
        a.f.b.j.o(pVar3, "msgInfo.item");
        aYv.jVH = pVar3;
        aYv.jWx = bVar;
        aYv.initView();
        aYv = aYv();
        aYz = aYz();
        a.f.b.j.o(aYz, "writeCommentContainer");
        aYv.setWriteCommentLayout(aYz);
        View findViewById = findViewById(R.id.a97);
        a.f.b.j.o(findViewById, "findViewById(R.id.biz_video_wow_edu_view)");
        aYv().setWowEduView((MPVideoWowEduView) findViewById);
        aYw().addView(aYC(), 0);
        aYr().setBizVideoControlBar(this.jWx);
        aYE();
        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "initVideoParam width " + aYD().fjT.videoWidth + " height " + aYD().fjT.videoHeight);
        if (aYD().fjT.videoWidth <= 0 || aYD().fjT.videoHeight <= 0) {
            aYr();
            str = MPVideoView.a(aYD());
            if (com.tencent.mm.vfs.e.ct(str)) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, options);
                if (options.outWidth > 0 && options.outHeight > 0) {
                    aYD().fjT.videoWidth = options.outWidth;
                    aYD().fjT.videoHeight = options.outHeight;
                    com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "initVideoParam with cover: width " + aYD().fjT.videoWidth + " height " + aYD().fjT.videoHeight);
                }
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
            }
        }
        aYF();
        FrameLayout aYt = aYt();
        a.f.b.j.o(aYt, "videoViewContainer");
        P(aYt, this.videoHeight);
        findViewById = aYB();
        a.f.b.j.o(findViewById, "animationLayout");
        P(findViewById, this.videoHeight);
        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "initVideoParam minVideoHeight " + this.jWw + " maxVideoHeight " + this.bpm);
        aYr().setFullScreenDelegate(new p(this));
        aYr().setMPVideoViewCallBack(new q(this));
        aYr().setTitle(aYD().fjT.title);
        MPVideoErrorView aYs = aYs();
        bVar = this.jWx;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f fVar = this.jWz;
        a.f.b.j.p(bVar, "controller");
        aYs.jWH.setOnClickListener(new a(aYs, bVar, fVar));
        ((View) this.jVX.getValue()).setOnTouchListener(new ac(this));
        this.jWo = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.xxA.c(this.jWC);
        AppMethodBeat.o(15194);
    }

    private final void aYE() {
        AppMethodBeat.i(15195);
        this.ieu = com.tencent.mm.bz.a.gd(dxU());
        this.iev = com.tencent.mm.bz.a.ge(dxU());
        this.bpm = (int) (0.65d * ((double) this.iev));
        this.jWw = (this.ieu * 9) / 16;
        this.bpm = Math.max(this.bpm, this.jWw);
        this.videoHeight = this.jWw;
        AppMethodBeat.o(15195);
    }

    private final void aYF() {
        int i;
        AppMethodBeat.i(15196);
        if (aYD().fjT.videoWidth > 0 && aYD().fjT.videoHeight > 0) {
            i = (this.ieu * aYD().fjT.videoHeight) / aYD().fjT.videoWidth;
            if (i > this.bpm) {
                this.videoHeight = this.bpm;
            } else if (i < this.jWw) {
                this.videoHeight = this.jWw;
            } else {
                this.videoHeight = i;
            }
            if (aYD().fjT.videoWidth > aYD().fjT.videoHeight) {
                aYH();
            }
        }
        i = (aYD().fjT.videoWidth <= 0 || aYD().fjT.videoHeight <= 0) ? this.jWw : this.videoHeight;
        this.bpm = i;
        if (this.bpm - this.jWw < 10) {
            this.jWw = this.bpm;
        }
        MPVideoMRecyclerView aYy = aYy();
        MPVideoView aYr = aYr();
        a.f.b.j.o(aYr, "videoView");
        FrameLayout aYt = aYt();
        a.f.b.j.o(aYt, "videoViewContainer");
        View aYB = aYB();
        a.f.b.j.o(aYB, "animationLayout");
        aYy.a(aYr, aYt, aYB, this.bpm, this.jWw);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f fVar = this.jWz;
        Intent intent = getIntent();
        a.f.b.j.o(intent, "intent");
        AppCompatActivity dxU = dxU();
        a.f.b.j.o(dxU, "context");
        Context context = dxU;
        aYB = aYB();
        a.f.b.j.o(aYB, "animationLayout");
        fVar.a(intent, context, aYB, aYq());
        aYr().a(aYA(), aYD().fjT.fjx, this.ieu, this.videoHeight, aYD());
        AppMethodBeat.o(15196);
    }

    public final void aYG() {
        AppMethodBeat.i(15197);
        int i = this.videoHeight;
        aYE();
        aYF();
        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "initVideoParam with cgi: width " + aYD().fjT.videoWidth + " height " + aYD().fjT.videoHeight);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, this.videoHeight});
        ofInt.addUpdateListener(new i(this));
        a.f.b.j.o(ofInt, "va");
        ofInt.setDuration(100);
        ofInt.start();
        AppMethodBeat.o(15197);
    }

    private static void P(View view, int i) {
        AppMethodBeat.i(15198);
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.o(15198);
            throw vVar;
        }
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(15198);
    }

    public final void fz(boolean z) {
        AppMethodBeat.i(15199);
        if (this.jWl != null) {
            com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b bVar = this.jWl;
            if (bVar != null) {
                bVar.fB(z);
                AppMethodBeat.o(15199);
                return;
            }
        }
        AppMethodBeat.o(15199);
    }

    private final void aYH() {
        AppMethodBeat.i(15200);
        if (this.jWl != null) {
            AppMethodBeat.o(15200);
            return;
        }
        AppCompatActivity dxU = dxU();
        a.f.b.j.o(dxU, "context");
        Context context = dxU;
        MPVideoView aYr = aYr();
        a.f.b.j.o(aYr, "videoView");
        this.jWl = new com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b(context, aYr);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b bVar = this.jWl;
        if (bVar != null) {
            bVar.fB(true);
            AppMethodBeat.o(15200);
            return;
        }
        AppMethodBeat.o(15200);
    }

    public final int getLayoutId() {
        return R.layout.hi;
    }

    public void onResume() {
        AppMethodBeat.i(15201);
        super.onResume();
        aYr().akW();
        this.jWp = System.currentTimeMillis();
        AppMethodBeat.o(15201);
    }

    public void onStart() {
        boolean z;
        AppMethodBeat.i(15202);
        super.onStart();
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f fVar = this.jWz;
        if (com.tencent.mm.af.r.ks(aYD().fgc)) {
            z = false;
        } else {
            z = true;
        }
        fVar.enable = z;
        fVar = this.jWz;
        Bundle bundle = this.jWy;
        com.tencent.mm.ui.tools.e.b xVar = new x(this);
        a.f.b.j.p(xVar, "callBack");
        com.tencent.mm.ui.tools.e eVar = fVar.jYE;
        if (eVar == null) {
            a.f.b.j.avw("imagePreviewAnimation");
        }
        eVar.L(fVar.xJ, fVar.xL, fVar.mWidth, fVar.mHeight);
        if (fVar.jYD || fVar.mWidth == 0 || fVar.mHeight == 0 || !fVar.enable || bundle != null) {
            com.tencent.mm.sdk.platformtools.ab.i(fVar.TAG, "handleAnimation return " + fVar.jYD + ',' + fVar.mWidth + ',' + fVar.mHeight);
            View view = fVar.jYG;
            if (view != null) {
                view.setVisibility(8);
            }
            fVar.jYI = true;
            fVar.aYP();
            AppMethodBeat.o(15202);
            return;
        }
        fVar.jYD = true;
        View view2 = fVar.jYF;
        if (view2 == null) {
            a.f.b.j.avw("animationView");
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f.a(fVar, xVar));
            AppMethodBeat.o(15202);
            return;
        }
        AppMethodBeat.o(15202);
    }

    public void onPause() {
        AppMethodBeat.i(15203);
        super.onPause();
        aYr().akV();
        long currentTimeMillis = System.currentTimeMillis();
        this.ism += currentTimeMillis - this.jWp;
        this.jWp = currentTimeMillis;
        AppMethodBeat.o(15203);
    }

    public void finish() {
        AppMethodBeat.i(138061);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.ce);
        AppMethodBeat.o(138061);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(15204);
        super.onDestroy();
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.d dVar = this.jWx.jVJ;
        MPVideoView aYr = aYr();
        a.f.b.j.o(aYr, "videoView");
        dVar.jYy = aYr.getEndPlayTime();
        if (this.jWo != 0) {
            this.ism = (System.currentTimeMillis() - this.jWp) + this.ism;
            this.jWx.jVJ.jYz = (int) (this.ism / 1000);
        }
        dVar = this.jWx.jVJ;
        aYr = aYr();
        a.f.b.j.o(aYr, "videoView");
        dVar.jYx = (int) aYr.getRealPlayTime();
        this.jWx.jVJ.sE(2);
        com.tencent.mm.kernel.g.Rg().b(1179, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().b(2866, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().b(2776, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().b(2759, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().b(2691, (com.tencent.mm.ai.f) this);
        com.tencent.mm.kernel.g.Rg().b(2617, (com.tencent.mm.ai.f) this);
        MPVideoView aYr2 = aYr();
        Integer valueOf = aYr2 != null ? Integer.valueOf(aYr2.getCurrPosSec()) : null;
        if (valueOf == null) {
            a.f.b.j.dWJ();
        }
        int intValue = valueOf.intValue();
        aYr = aYr();
        if (aYr != null && intValue == aYr.getDuration()) {
            intValue = 0;
        }
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.e(aYD().HE() + "_" + this.jWx.fgd, (double) intValue);
        aYr().aEX();
        if (this.jWn != null) {
            com.tencent.mm.plugin.brandservice.ui.widget.a aVar = this.jWn;
            if (aVar == null) {
                a.f.b.j.dWJ();
            }
            aVar.b(this.jWB);
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.jWC);
        this.jWx.onDestroy();
        aYC().destroy();
        aYC().setWebChromeClient(null);
        aYC().setWebViewClient(null);
        aYC().setOnTouchListener(null);
        aYC().setOnLongClickListener(null);
        aYC().setVisibility(8);
        aYC().removeAllViews();
        aYC().clearView();
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.b bVar = this.jWl;
        if (bVar != null) {
            bVar.jYr.disable();
            AppMethodBeat.o(15204);
            return;
        }
        AppMethodBeat.o(15204);
    }

    public void onBackPressed() {
        boolean z = true;
        AppMethodBeat.i(15205);
        if (this.jWm) {
            aYr().j(false, 0);
            AppMethodBeat.o(15205);
            return;
        }
        MPVideoWriteCommentLayout aYz = aYz();
        if (aYz.jXV.aYU() && aYz.aFF()) {
            aYz.jXV.aYW();
        } else if (aYz.jYe == -3 || !aYz.aFF()) {
            z = false;
        } else {
            aYz.hide();
        }
        if (!z) {
            super.onBackPressed();
        }
        AppMethodBeat.o(15205);
    }

    private void a(ek ekVar) {
        int i = 0;
        AppMethodBeat.i(15206);
        if (ekVar == null) {
            AppMethodBeat.o(15206);
            return;
        }
        MPVideoHeaderView aYv;
        if (ekVar.vGj != 0) {
            MPPreviewBar mPPreviewBar = (MPPreviewBar) this.jWh.getValue();
            a.f.b.j.o(mPPreviewBar, "previewBar");
            mPPreviewBar.setVisibility(0);
        }
        if (ekVar.vGq != null && com.tencent.mm.af.r.ks(aYD().fgc)) {
            aYv = aYv();
            eg egVar = ekVar.vGq;
            a.f.b.j.o(egVar, "resp.base_appmsg_info");
            aYv.setOriginInfo(egVar);
        }
        b bVar = this.jWx;
        bVar.fgc = ekVar.vGl;
        if (bVar.aYp()) {
            com.tencent.mm.af.r rVar = bVar.jVG;
            if (rVar == null) {
                a.f.b.j.avw("msgInfo");
            }
            com.tencent.mm.af.r rVar2 = bVar.jVG;
            if (rVar2 == null) {
                a.f.b.j.avw("msgInfo");
            }
            rVar.fgc = rVar2.fgc | 1;
        }
        if (ekVar.vGp != null && this.jWx.aYp()) {
            this.jWx.jVI = ekVar.vGp;
            aYv = aYv();
            bac bac = ekVar.vGp;
            a.f.b.j.o(bac, "resp.malicious_title_info");
            aYv.setMaliciousInfo(bac);
        }
        this.jWx.fgd = ekVar.fgd;
        bVar = this.jWx;
        String str = ekVar.vGo;
        a.f.b.j.o(str, "resp.copy_url");
        a.f.b.j.p(str, "<set-?>");
        bVar.jVB = str;
        this.jWx.Gd(ekVar.url);
        aYx().setTmpUrl(ekVar.vGj);
        if (ekVar.vGn == null || ekVar.vGn.cCJ == 0) {
            aYI();
            if (bo.ek(ekVar.vGg)) {
                AppMethodBeat.o(15206);
                return;
            }
            ew ewVar = (ew) ekVar.vGg.get(0);
            aYr().setAutoPlay((ekVar.vGk & 1) != 0);
            aYr().setInitialTime(com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.Gg(aYD().HE() + "_" + ekVar.fgd));
            a.f.b.j.o(ewVar, "urlInfo");
            aYr().bL(ewVar.url, ewVar.vGL / 1000);
            MPVideoView aYr = aYr();
            if (ewVar.width > ewVar.height) {
                i = 90;
            }
            aYr.setFullScreenDirection(i);
            if (ewVar.width > ewVar.height) {
                aYH();
            }
            if (ewVar.width > 0 && ewVar.height > 0 && aYD().fjT.videoWidth <= 0 && aYD().fjT.videoHeight <= 0) {
                aYD().fjT.videoWidth = ewVar.width;
                aYD().fjT.videoHeight = ewVar.height;
                if (this.jWz.jYI) {
                    aYG();
                    AppMethodBeat.o(15206);
                    return;
                }
                this.jWA = true;
            }
            AppMethodBeat.o(15206);
            return;
        }
        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "play_error_info msg:" + ekVar.vGn.cCK + " errCode:" + ekVar.vGn.cCJ);
        aYs().setPlayError$505cff1c(ekVar.vGn.cCK);
        aYJ();
        AppMethodBeat.o(15206);
    }

    private final void aYI() {
        AppMethodBeat.i(15207);
        MPVideoErrorView aYs = aYs();
        a.f.b.j.o(aYs, "videoErrView");
        aYs.setVisibility(8);
        fz(true);
        AppMethodBeat.o(15207);
    }

    private final void aYJ() {
        AppMethodBeat.i(15208);
        MPVideoErrorView aYs = aYs();
        a.f.b.j.o(aYs, "videoErrView");
        aYs.setVisibility(0);
        fz(false);
        AppMethodBeat.o(15208);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        String str = null;
        AppMethodBeat.i(15209);
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g gVar = this.jWk;
        Context aYo;
        BizVideoDetailUI aYo2;
        b bVar;
        if (i == 1) {
            if (i2 == -1) {
                aYo = gVar.aYo();
                aYo2 = gVar.aYo();
                if (aYo2 != null) {
                    str = aYo2.getString(R.string.g5z);
                }
                com.tencent.mm.ui.base.h.bN(aYo, str);
                bVar = gVar.jWx;
                if (bVar == null) {
                    a.f.b.j.avw("controller");
                }
                bVar.jVC.sF(2);
            }
            i3 = 1;
        } else {
            if (i == 2 && i2 == -1) {
                String stringExtra;
                String stringExtra2 = intent != null ? intent.getStringExtra("Select_Conv_User") : null;
                if (intent != null) {
                    stringExtra = intent.getStringExtra("custom_send_text");
                } else {
                    stringExtra = null;
                }
                if (stringExtra2 != null) {
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.jYp;
                    com.tencent.mm.af.r rVar = gVar.jVG;
                    if (rVar == null) {
                        a.f.b.j.avw("msgInfo");
                    }
                    b bVar2 = gVar.jWx;
                    if (bVar2 == null) {
                        a.f.b.j.avw("controller");
                    }
                    if (com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a.a(stringExtra2, rVar, stringExtra, bVar2)) {
                        aYo = gVar.aYo();
                        aYo2 = gVar.aYo();
                        if (aYo2 != null) {
                            str = aYo2.getString(R.string.g5z);
                        }
                        com.tencent.mm.ui.base.h.bN(aYo, str);
                        bVar = gVar.jWx;
                        if (bVar == null) {
                            a.f.b.j.avw("controller");
                        }
                        bVar.jVC.sF(1);
                    }
                }
            }
            i3 = 0;
        }
        if (i3 != 0) {
            AppMethodBeat.o(15209);
        } else {
            AppMethodBeat.o(15209);
        }
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(15210);
        this.jWx.aYn();
        if (mVar == null || mVar.acN() == null) {
            AppMethodBeat.o(15210);
            return;
        }
        com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "onSceneEnd errType " + i + ", errCode " + i2 + ", errMsg " + str + ", type: " + mVar.getType());
        com.tencent.mm.network.q acN = mVar.acN();
        a.v vVar;
        if (acN == null) {
            vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.o(15210);
            throw vVar;
        }
        com.tencent.mm.bt.a acz = ((com.tencent.mm.ai.b) acN).acz();
        if (((acz instanceof ej) && ((ej) acz).vFP != this.jWx.jVF) || (((acz instanceof ed) && ((ed) acz).vFP != this.jWx.jVF) || (((acz instanceof eh) && ((eh) acz).vFP != this.jWx.jVF) || (((acz instanceof en) && ((en) acz).vFP != this.jWx.jVF) || ((acz instanceof ep) && ((ep) acz).vFP != this.jWx.jVF))))) {
            AppMethodBeat.o(15210);
        } else if ((mVar.getType() != 2691 && mVar.getType() != 2617) || i2 == 0 || bo.isNullOrNil(str)) {
            acN = mVar.acN();
            a.f.b.j.o(acN, "scene.reqResp");
            com.tencent.mm.bt.a acA;
            String str2;
            LinkedList linkedList;
            int size;
            String str3;
            int length;
            if (acN.getType() == 1179) {
                com.tencent.mm.plugin.brandservice.ui.timeline.video.a.f fVar = this.jWz;
                fVar.jYH = true;
                fVar.aYP();
                if (i == 0 && i2 == 0) {
                    aYI();
                    acN = mVar.acN();
                    if (acN == null) {
                        vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                        AppMethodBeat.o(15210);
                        throw vVar;
                    }
                    acA = ((com.tencent.mm.ai.b) acN).acA();
                    if (acA == null) {
                        vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
                        AppMethodBeat.o(15210);
                        throw vVar;
                    }
                    ek ekVar = (ek) acA;
                    str2 = this.TAG;
                    StringBuilder stringBuilder = new StringBuilder("url_info size is ");
                    if (ekVar.vGg != null) {
                        linkedList = ekVar.vGg;
                        if (linkedList == null) {
                            a.f.b.j.dWJ();
                        }
                        size = linkedList.size();
                    } else {
                        size = 0;
                    }
                    com.tencent.mm.sdk.platformtools.ab.i(str2, stringBuilder.append(size).toString());
                    String str4;
                    if (ekVar.vGh == 0 || bo.isNullOrNil(ekVar.vGi)) {
                        a(ekVar);
                        dw dwVar = ekVar.vGm;
                        if ((dwVar != null && dwVar.enabled == 1) || (this.jVT && (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.DEBUG))) {
                            a.f.b.j.o(dwVar, "appMsgAdvert");
                            str3 = "https://mp.weixin.qq.com/s?__biz=MjM5NDE1ODg2MQ==&mid=2663410252&idx=1&sn=2d23c198e56a8de51135dd6fff2a3424&chksm=bdb8ca2e8acf4338c6185291f34f8ad945e7b21ddc58b917f1421e2275830366fe83b405ba33&scene=90&xtrack=1&render_type=ad&ascene=1&devicetype=android-26&version=27000400&nettype=WIFI&abtest_cookie=BAABAAoACwASABMABQAjlx4AVpkeAMWZHgDVmR4A3JkeAAAA&lang=zh_CN&pass_ticket=HuAnleAdesPJYvj8VdGnM5iy840UzEsUCPB4f9wpHi2EEZwaCr%2BDkfL1p50iY8au&wx_header=1&mock=-1#test";
                            if (!this.jVT) {
                                str3 = dwVar.url;
                                a.f.b.j.o(str3, "appMsgAdvert.url");
                            }
                            str2 = "";
                            if (a.k.v.a((CharSequence) str3, '#', 0, 6) != -1) {
                                str4 = "#" + a.k.v.jf(str3, "#");
                                length = str3.length() - str4.length();
                                if (str3 == null) {
                                    vVar = new a.v("null cannot be cast to non-null type java.lang.String");
                                    AppMethodBeat.o(15210);
                                    throw vVar;
                                }
                                str3 = str3.substring(0, length);
                                a.f.b.j.o(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            } else {
                                str4 = str2;
                            }
                            str4 = str3 + "&adWidth=" + ((int) (((float) aYC().getMeasuredWidth()) / this.density)) + str4;
                            com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "load ad url:".concat(String.valueOf(str4)));
                            aYC().loadUrl(str4);
                            MPVideoMRecyclerView aYy = aYy();
                            a.f.b.j.o(aYy, "commentListView");
                            aYy.getViewTreeObserver().addOnScrollChangedListener(new v(this));
                            AppMethodBeat.o(15210);
                            return;
                        }
                    }
                    com.tencent.mm.sdk.platformtools.ab.i(this.TAG, "onSceneEnd redirect %s", ekVar.vGi);
                    AppCompatActivity dxU = dxU();
                    a.f.b.j.o(dxU, "context");
                    Context context = dxU;
                    com.tencent.mm.af.r aYD = aYD();
                    str4 = ekVar.vGi;
                    a.f.b.j.o(str4, "resp.redirect_url");
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.a(context, aYD, str4);
                    al.n(new w(this), 500);
                    AppMethodBeat.o(15210);
                    return;
                }
                a(null);
                aYJ();
                MPVideoErrorView aYs = aYs();
                aYs.jXq.setBackgroundResource(R.drawable.axu);
                if (bo.isNullOrNil(str)) {
                    aYs.jXp.setText(aYs.getContext().getString(R.string.g83));
                } else {
                    aYs.jXp.setText(aYs.getContext().getString(R.string.g83) + ' ' + str);
                }
                aYs.jWH.setClickable(true);
                AppMethodBeat.o(15210);
                return;
            }
            acN = mVar.acN();
            a.f.b.j.o(acN, "scene.reqResp");
            com.tencent.mm.network.q acN2;
            String str5;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView.a aVar;
            Context context2;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout.a aVar2;
            if (acN.getType() == 2866) {
                acN = mVar.acN();
                if (acN == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                acA = ((com.tencent.mm.ai.b) acN).acz();
                if (acA == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgCommentListReq");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                ed edVar = (ed) acA;
                acN2 = mVar.acN();
                if (acN2 == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                acz = ((com.tencent.mm.ai.b) acN2).acA();
                if (acz == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgCommentListResp");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                ee eeVar = (ee) acz;
                str5 = this.TAG;
                StringBuilder stringBuilder2 = new StringBuilder("url_info size is ");
                if (eeVar.vFR != null) {
                    LinkedList linkedList2 = eeVar.vFR;
                    if (linkedList2 == null) {
                        a.f.b.j.dWJ();
                    }
                    length = linkedList2.size();
                } else {
                    length = 0;
                }
                com.tencent.mm.sdk.platformtools.ab.i(str5, stringBuilder2.append(length).toString());
                LinkedList linkedList3;
                List list;
                if (edVar.kdC == 1) {
                    this.jWx.jVx = eeVar.kKI;
                    MPVideoCommentView aYx = aYx();
                    a.f.b.j.p(eeVar, "resp");
                    if (!bo.ek(eeVar.vFR)) {
                        aVar = aYx.jWM;
                        if (aVar != null) {
                            linkedList3 = eeVar.vFR;
                            a.f.b.j.o(linkedList3, "resp.comment");
                            list = linkedList3;
                            a.f.b.j.p(list, "items");
                            com.tencent.mm.sdk.platformtools.ab.i(com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView.a.TAG, "update: " + list.size());
                            aVar.eow.addAll(list);
                            aVar.notifyDataSetChanged();
                        }
                    }
                    aYx.erD = eeVar.enabled;
                    aYx.jWO = eeVar.vFT;
                    aYx.jWP = eeVar.vFS;
                    Object obj = null;
                    if (aYx.jWM != null) {
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView.a aVar3 = aYx.jWM;
                        Integer valueOf = aVar3 != null ? Integer.valueOf(aVar3.getItemCount()) : null;
                        if (valueOf == null) {
                            a.f.b.j.dWJ();
                        }
                        if (valueOf.intValue() > 0) {
                            aYx.jWL.setVisibility(0);
                            obj = 1;
                        } else {
                            aYx.jWL.setVisibility(8);
                        }
                    }
                    if (aYx.erD == 1) {
                        aYx.jWK.setVisibility(0);
                        if (obj != null) {
                            aYx.jWK.setGravity(5);
                        } else {
                            aYx.jWK.setGravity(1);
                        }
                    } else {
                        aYx.jWK.setVisibility(8);
                    }
                    if (aYx.jWO == 1 || !aYx.jWP) {
                        str2 = aYx.getContext().getString(R.string.g62);
                        Context context3 = aYx.getContext();
                        a.f.b.j.o(context3, "context");
                        Drawable drawable = context3.getResources().getDrawable(R.drawable.axn);
                        size = (int) (((double) aYx.jWK.getTextSize()) * 1.2d);
                        drawable.setBounds(0, 0, size, size);
                        new SpannableString("@").setSpan(new com.tencent.mm.ui.widget.a(drawable), 0, 1, 33);
                        aYx.jWK.setText(TextUtils.concat(new CharSequence[]{r1, " ", str2}));
                        AppMethodBeat.o(15210);
                        return;
                    }
                    aYx.jWK.setText(aYx.getContext().getString(R.string.g84));
                    AppMethodBeat.o(15210);
                    return;
                }
                Object obj2;
                int i3 = this.jWx.jVy;
                this.jWx.jVy = eeVar.kKI;
                MPVideoWriteCommentLayout aYz = aYz();
                if (i3 == 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                a.f.b.j.p(eeVar, "resp");
                if (!aYz.jYf) {
                    if (bo.ek(eeVar.vFR)) {
                        aYz.aYM();
                        AppMethodBeat.o(15210);
                        return;
                    }
                    View view = aYz.jYa;
                    context2 = aYz.getContext();
                    a.f.b.j.o(context2, "context");
                    view.setBackgroundColor(context2.getResources().getColor(R.color.gy));
                    aYz.jYb.setVisibility(0);
                    if (aYz.jYd == null) {
                        Context context4 = aYz.getContext();
                        a.f.b.j.o(context4, "context");
                        linkedList = eeVar.vFR;
                        a.f.b.j.o(linkedList, "resp.comment");
                        b bVar = aYz.jWx;
                        if (bVar == null) {
                            a.f.b.j.avw("controller");
                        }
                        aYz.jYd = new com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout.a(context4, linkedList, bVar);
                        aYz.jXZ.setAdapter(aYz.jYd);
                        AppMethodBeat.o(15210);
                        return;
                    }
                    aVar2 = aYz.jYd;
                    if (aVar2 != null) {
                        linkedList3 = eeVar.vFR;
                        a.f.b.j.o(linkedList3, "resp.comment");
                        list = linkedList3;
                        a.f.b.j.p(list, "items");
                        com.tencent.mm.sdk.platformtools.ab.i(com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout.a.TAG, "update: " + list.size());
                        if (obj2 != null) {
                            aVar2.eow.clear();
                            aVar2.eow.addAll(list);
                        } else {
                            aVar2.eow.addAll(list);
                        }
                        aVar2.notifyDataSetChanged();
                        AppMethodBeat.o(15210);
                        return;
                    }
                }
                AppMethodBeat.o(15210);
                return;
            }
            acN = mVar.acN();
            a.f.b.j.o(acN, "scene.reqResp");
            jz jzVar;
            if (acN.getType() == 2776) {
                if (i == 0 && i2 == 0) {
                    acN = mVar.acN();
                    if (acN == null) {
                        vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                        AppMethodBeat.o(15210);
                        throw vVar;
                    }
                    acA = ((com.tencent.mm.ai.b) acN).acA();
                    if (acA == null) {
                        vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetExtResp");
                        AppMethodBeat.o(15210);
                        throw vVar;
                    }
                    ei eiVar = (ei) acA;
                    if (eiVar.vGd != null) {
                        MPVideoHeaderView aYv = aYv();
                        jzVar = eiVar.vGd;
                        a.f.b.j.o(jzVar, "resp.appmsgstat");
                        aYv.a(jzVar);
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g gVar = this.jWk;
                        jzVar = eiVar.vGd;
                        a.f.b.j.o(jzVar, "resp.appmsgstat");
                        a.f.b.j.p(jzVar, "appMsgStat");
                        gVar.jXv = jzVar;
                        this.jWx.jVA = eiVar.vGd.jVA;
                    }
                }
                AppMethodBeat.o(15210);
                return;
            }
            acN = mVar.acN();
            a.f.b.j.o(acN, "scene.reqResp");
            if (acN.getType() == 2691) {
                acN = mVar.acN();
                if (acN == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                acA = ((com.tencent.mm.ai.b) acN).acz();
                if (acA == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgLikeReq");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                en enVar = (en) acA;
                acN2 = mVar.acN();
                if (acN2 == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                acz = ((com.tencent.mm.ai.b) acN2).acA();
                if (acz == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgLikeResp");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                eo eoVar = (eo) acz;
                if (i == 0 && i2 == 0) {
                    if (enVar.kdC != 4) {
                        MPVideoHeaderView aYv2 = aYv();
                        jzVar = aYv2.jXv;
                        if (jzVar == null) {
                            a.f.b.j.avw("appMsgStat");
                        }
                        if (jzVar != null) {
                            jzVar = aYv2.jXv;
                            if (jzVar == null) {
                                a.f.b.j.avw("appMsgStat");
                            }
                            if (jzVar.vMP == 1) {
                                jzVar = aYv2.jXv;
                                if (jzVar == null) {
                                    a.f.b.j.avw("appMsgStat");
                                }
                                jzVar.vMP = 0;
                                jzVar = aYv2.jXv;
                                if (jzVar == null) {
                                    a.f.b.j.avw("appMsgStat");
                                }
                                jzVar.vMO--;
                                aYv2.jXG.setVisibility(8);
                            } else {
                                jzVar = aYv2.jXv;
                                if (jzVar == null) {
                                    a.f.b.j.avw("appMsgStat");
                                }
                                jzVar.vMP = 1;
                                jzVar = aYv2.jXv;
                                if (jzVar == null) {
                                    a.f.b.j.avw("appMsgStat");
                                }
                                jzVar.vMO++;
                                if (aYv2.jXu) {
                                    aYv2.jXG.setVisibility(0);
                                    aYv2.jXu = false;
                                    length = (int) aYv2.jXH.getTextSize();
                                    LayoutParams layoutParams = aYv2.jXI.getLayoutParams();
                                    if (layoutParams == null) {
                                        vVar = new a.v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                                        AppMethodBeat.o(15210);
                                        throw vVar;
                                    }
                                    layoutParams.height = (int) (((double) length) * 1.2d);
                                    layoutParams.width = (int) (((double) length) * 1.2d);
                                    aYv2.jXI.setLayoutParams(layoutParams);
                                    str5 = aYv2.getContext().getString(R.string.g61);
                                    context2 = aYv2.getContext();
                                    a.f.b.j.o(context2, "context");
                                    Drawable drawable2 = context2.getResources().getDrawable(R.drawable.axm);
                                    drawable2.setBounds(0, 0, length / 2, length);
                                    new SpannableString("@").setSpan(new com.tencent.mm.ui.widget.a(drawable2), 0, 1, 33);
                                    aYv2.jXH.setText(TextUtils.concat(new CharSequence[]{str5, "  ", r4}));
                                    aYv2.jXH.setOnClickListener(new e(aYv2));
                                    as eg = as.eg("key_webview_menu_haokan", 2);
                                    if (eg == null) {
                                        a.f.b.j.dWJ();
                                    }
                                    if (eg.decodeBool("show_first_tips", true)) {
                                        MPVideoWowEduView mPVideoWowEduView = aYv2.jXK;
                                        if (mPVideoWowEduView == null) {
                                            a.f.b.j.avw("wowEduLayout");
                                        }
                                        if (mPVideoWowEduView != null) {
                                            b bVar2 = aYv2.jWx;
                                            if (bVar2 == null) {
                                                a.f.b.j.avw("controller");
                                            }
                                            if (bVar2.jVA != 1) {
                                                eg.encode("show_first_tips", false);
                                                eg.apply();
                                                MPVideoWowEduView mPVideoWowEduView2 = aYv2.jXK;
                                                if (mPVideoWowEduView2 == null) {
                                                    a.f.b.j.avw("wowEduLayout");
                                                }
                                                mPVideoWowEduView2.setPosition(aYv2.jXJ.getY() + ((float) aYv2.jXJ.getHeight()));
                                            }
                                        }
                                    }
                                }
                            }
                            jzVar = aYv2.jXv;
                            if (jzVar == null) {
                                a.f.b.j.avw("appMsgStat");
                            }
                            jz jzVar2 = aYv2.jXv;
                            if (jzVar2 == null) {
                                a.f.b.j.avw("appMsgStat");
                            }
                            jzVar.vMO = Math.max(0, jzVar2.vMO);
                            jzVar = aYv2.jXv;
                            if (jzVar == null) {
                                a.f.b.j.avw("appMsgStat");
                            }
                            aYv2.a(jzVar);
                        }
                    } else {
                        aYz().aYN();
                    }
                    if (enVar.kdC == 1 || enVar.kdC == 5) {
                        this.jWx.jVC.sF(9);
                    }
                    if (enVar.kdC != 2) {
                        com.tencent.mm.ui.base.h.bN(dxU(), getString(R.string.ti));
                        AppMethodBeat.o(15210);
                        return;
                    } else if (eoVar.vGw == 1) {
                        com.tencent.mm.ui.base.h.a((Context) dxU(), dxU().getString(R.string.g81), "", dxU().getString(R.string.s6), null);
                        AppMethodBeat.o(15210);
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.bN(dxU(), getString(R.string.g80));
                        AppMethodBeat.o(15210);
                        return;
                    }
                }
                com.tencent.mm.ui.base.h.bN(dxU(), getString(R.string.g5x, new Object[]{Integer.valueOf(i2)}));
                AppMethodBeat.o(15210);
                return;
            }
            acN = mVar.acN();
            a.f.b.j.o(acN, "scene.reqResp");
            if (acN.getType() == 2617) {
                acN = mVar.acN();
                if (acN == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                acA = ((com.tencent.mm.ai.b) acN).acz();
                if (acA == null) {
                    vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgOperateCommentReq");
                    AppMethodBeat.o(15210);
                    throw vVar;
                }
                ep epVar = (ep) acA;
                if (i == 0 && i2 == 0) {
                    if (epVar.kdC == 1) {
                        com.tencent.mm.ui.base.h.bN(dxU(), getString(R.string.g65));
                        aYz().aYN();
                        AppMethodBeat.o(15210);
                        return;
                    }
                    com.tencent.mm.ui.base.h.bN(dxU(), getString(R.string.g5r));
                    MPVideoWriteCommentLayout aYz2 = aYz();
                    a.f.b.j.p(epVar, "req");
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout.a aVar4 = aYz2.jYd;
                    str3 = aVar4 != null ? aVar4.b(epVar) : null;
                    aVar2 = aYz2.jYd;
                    if (aVar2 != null && aVar2.getCount() == 0) {
                        aYz2.aYM();
                    }
                    MPVideoCommentView aYx2 = aYx();
                    a.f.b.j.p(epVar, "req");
                    aVar = aYx2.jWM;
                    if (aVar != null) {
                        aVar.a(epVar, str3);
                        AppMethodBeat.o(15210);
                        return;
                    }
                    AppMethodBeat.o(15210);
                    return;
                } else if (epVar.kdC == 1) {
                    com.tencent.mm.ui.base.h.bN(dxU(), getString(R.string.g63, new Object[]{Integer.valueOf(i2)}));
                    AppMethodBeat.o(15210);
                    return;
                } else {
                    com.tencent.mm.ui.base.h.bN(dxU(), getString(R.string.g5q, new Object[]{Integer.valueOf(i2)}));
                    AppMethodBeat.o(15210);
                    return;
                }
            }
            AppMethodBeat.o(15210);
        } else {
            com.tencent.mm.ui.base.h.a((Context) dxU(), str, "", dxU().getString(R.string.s6), null);
            AppMethodBeat.o(15210);
        }
    }

    public static final /* synthetic */ com.tencent.mm.plugin.brandservice.ui.widget.a e(BizVideoDetailUI bizVideoDetailUI) {
        com.tencent.mm.plugin.brandservice.ui.widget.a aVar;
        AppMethodBeat.i(15215);
        a.v vVar;
        if (bizVideoDetailUI.jWn != null) {
            aVar = bizVideoDetailUI.jWn;
            if (aVar == null) {
                vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPFullscreenImpl");
                AppMethodBeat.o(15215);
                throw vVar;
            }
            AppMethodBeat.o(15215);
        } else {
            bizVideoDetailUI.jWn = new com.tencent.mm.plugin.brandservice.ui.widget.a(bizVideoDetailUI.dxU());
            aVar = bizVideoDetailUI.jWn;
            if (aVar == null) {
                a.f.b.j.dWJ();
            }
            aVar.a(bizVideoDetailUI.jWB);
            aVar = bizVideoDetailUI.jWn;
            if (aVar == null) {
                vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPFullscreenImpl");
                AppMethodBeat.o(15215);
                throw vVar;
            }
            AppMethodBeat.o(15215);
        }
        return aVar;
    }

    public static final /* synthetic */ void j(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(15219);
        MPVideoMRecyclerView aYy = bizVideoDetailUI.aYy();
        a.f.b.j.o(aYy, "commentListView");
        float height = ((float) aYy.getHeight()) / bizVideoDetailUI.density;
        FrameLayout aYw = bizVideoDetailUI.aYw();
        a.f.b.j.o(aYw, "adView");
        float top = ((float) (aYw.getTop() - bizVideoDetailUI.aYy().computeVerticalScrollOffset())) / bizVideoDetailUI.density;
        a aVar = a.jVq;
        a.a(bizVideoDetailUI.aYC(), (int) height, (int) top);
        com.tencent.mm.sdk.platformtools.ab.v(bizVideoDetailUI.TAG, "scroll:" + height + ", " + top + ", " + bizVideoDetailUI.density);
        AppMethodBeat.o(15219);
    }

    public static final /* synthetic */ String l(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(15221);
        String str = (String) bizVideoDetailUI.jWt.getValue();
        AppMethodBeat.o(15221);
        return str;
    }

    public static final /* synthetic */ int n(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.i(15223);
        int intValue = ((Number) bizVideoDetailUI.jWu.getValue()).intValue();
        AppMethodBeat.o(15223);
        return intValue;
    }
}
