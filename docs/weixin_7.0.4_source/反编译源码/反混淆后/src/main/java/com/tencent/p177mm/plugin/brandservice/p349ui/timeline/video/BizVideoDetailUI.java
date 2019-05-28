package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.widget.LinearLayoutManager;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C37436r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.tools.C30759e;
import com.tencent.p177mm.p612ui.tools.C30759e.C24051b;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.p177mm.plugin.bizui.widget.BizKeyboardLinearLayout;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.C45767b.C45766g;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.MPVideoCommentView.C2736a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.MPVideoErrorView.C20092a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.MPVideoHeaderView.C2744e;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.MPVideoWriteCommentLayout.C20095a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.MPVideoWriteCommentLayout.C20100c;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C11262a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C11263c;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C27559b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C27562d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C33743f;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C33743f.C20109a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C33744g;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C33744g.C33745b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C33744g.C33746a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C38715e;
import com.tencent.p177mm.plugin.brandservice.p349ui.widget.C2751a;
import com.tencent.p177mm.plugin.brandservice.p349ui.widget.C33752b;
import com.tencent.p177mm.plugin.brandservice.p349ui.widget.MPVideoView;
import com.tencent.p177mm.plugin.brandservice.p349ui.widget.MPVideoView.C33751a;
import com.tencent.p177mm.plugin.brandservice.p349ui.widget.MPVideoView.C38723b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi.C14670a;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.protocal.protobuf.C15333ed;
import com.tencent.p177mm.protocal.protobuf.C15334ek;
import com.tencent.p177mm.protocal.protobuf.C30180ee;
import com.tencent.p177mm.protocal.protobuf.C35914en;
import com.tencent.p177mm.protocal.protobuf.C35915eo;
import com.tencent.p177mm.protocal.protobuf.C35931jz;
import com.tencent.p177mm.protocal.protobuf.C40514dw;
import com.tencent.p177mm.protocal.protobuf.C40516eh;
import com.tencent.p177mm.protocal.protobuf.C46535eg;
import com.tencent.p177mm.protocal.protobuf.C46536ei;
import com.tencent.p177mm.protocal.protobuf.C46537ep;
import com.tencent.p177mm.protocal.protobuf.C46538ew;
import com.tencent.p177mm.protocal.protobuf.C7535ej;
import com.tencent.p177mm.protocal.protobuf.bac;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C37091y;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p051k.C31820v;

@C5271a(6)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t*\u0001N\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\u0011\u0010 \u0001\u001a\u00030\u00012\u0007\u0010¡\u0001\u001a\u000201J\n\u0010¢\u0001\u001a\u00030\u0001H\u0016J\t\u0010£\u0001\u001a\u00020;H\u0014J\t\u0010¤\u0001\u001a\u000207H\u0002J\t\u0010¥\u0001\u001a\u00020;H\u0014J\n\u0010¦\u0001\u001a\u00030\u0001H\u0002J\b\u0010§\u0001\u001a\u00030\u0001J\b\u0010¨\u0001\u001a\u00030\u0001J\n\u0010©\u0001\u001a\u00030\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030\u0001H\u0002J\n\u0010«\u0001\u001a\u00030\u0001H\u0002J\n\u0010¬\u0001\u001a\u00030\u0001H\u0002J\n\u0010­\u0001\u001a\u00030\u0001H\u0002J\n\u0010®\u0001\u001a\u00030\u0001H\u0002J\n\u0010¯\u0001\u001a\u00030\u0001H\u0002J(\u0010°\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020;2\u0007\u0010²\u0001\u001a\u00020;2\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0014J\u0016\u0010µ\u0001\u001a\u00030\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0016J\n\u0010¸\u0001\u001a\u00030\u0001H\u0016J\u0015\u0010¹\u0001\u001a\u00030\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010vH\u0016J\n\u0010»\u0001\u001a\u00030\u0001H\u0014J\u0014\u0010¼\u0001\u001a\u00030\u00012\b\u0010½\u0001\u001a\u00030¾\u0001H\u0002J\u0014\u0010¿\u0001\u001a\u00030\u00012\b\u0010¶\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Á\u0001\u001a\u00030\u0001H\u0014J\n\u0010Â\u0001\u001a\u00030\u0001H\u0014J2\u0010Ã\u0001\u001a\u00030\u00012\u0007\u0010Ä\u0001\u001a\u00020;2\u0007\u0010Å\u0001\u001a\u00020;2\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010w\u001a\u0005\u0018\u00010Ç\u0001H\u0016J\n\u0010È\u0001\u001a\u00030\u0001H\u0016J\n\u0010É\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ë\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010Ì\u0001\u001a\u00020\u001a2\u0007\u0010Í\u0001\u001a\u00020;H\u0002J\n\u0010Î\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010Ï\u0001\u001a\u00030\u00012\u0007\u0010Í\u0001\u001a\u00020;H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \b*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001e\u001a\n \b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001f\u0010\u001cR#\u0010!\u001a\n \b*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R#\u0010&\u001a\n \b*\u0004\u0018\u00010'0'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b(\u0010)R#\u0010+\u001a\n \b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b,\u0010\u001cR\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201XD¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b<\u0010=R#\u0010?\u001a\n \b*\u0004\u0018\u00010@0@8BX\u0002¢\u0006\f\n\u0004\bC\u0010\f\u001a\u0004\bA\u0010BR\u000e\u0010D\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R#\u0010E\u001a\n \b*\u0004\u0018\u00010F0F8BX\u0002¢\u0006\f\n\u0004\bI\u0010\f\u001a\u0004\bG\u0010HR#\u0010J\u001a\n \b*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\bL\u0010\f\u001a\u0004\bK\u0010\u001cR\u0010\u0010M\u001a\u00020NX\u0004¢\u0006\u0004\n\u0002\u0010OR\u001a\u0010P\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010=\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020UX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010=\"\u0004\bX\u0010SR\u001b\u0010Y\u001a\u00020Z8BX\u0002¢\u0006\f\n\u0004\b]\u0010\f\u001a\u0004\b[\u0010\\R\u001a\u0010^\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0010\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R#\u0010f\u001a\n \b*\u0004\u0018\u00010g0g8BX\u0002¢\u0006\f\n\u0004\bj\u0010\f\u001a\u0004\bh\u0010iR#\u0010k\u001a\n \b*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\bn\u0010\f\u001a\u0004\bl\u0010mR\u000e\u0010o\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R#\u0010p\u001a\n \b*\u0004\u0018\u00010q0q8BX\u0002¢\u0006\f\n\u0004\bt\u0010\f\u001a\u0004\br\u0010sR\u0010\u0010u\u001a\u0004\u0018\u00010vX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010w\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\by\u0010\f\u001a\u0004\bx\u0010=R\u001a\u0010z\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010=\"\u0004\b|\u0010SR\u001a\u0010}\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010=\"\u0004\b\u0010SR\u001e\u0010\u0001\u001a\u00020;8BX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\f\u001a\u0005\b\u0001\u0010=R)\u0010\u0001\u001a\f \b*\u0005\u0018\u00010\u00010\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\f\u001a\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020;X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010=\"\u0005\b\u0001\u0010SR)\u0010\u0001\u001a\f \b*\u0005\u0018\u00010\u00010\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\f\u001a\u0006\b\u0001\u0010\u0001R&\u0010\u0001\u001a\n \b*\u0004\u0018\u00010\u00070\u00078FX\u0002¢\u0006\u000e\n\u0005\b\u0001\u0010\f\u001a\u0005\b\u0001\u0010\nR)\u0010\u0001\u001a\f \b*\u0005\u0018\u00010\u00010\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\f\u001a\u0006\b\u0001\u0010\u0001¨\u0006Ð\u0001"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "adView", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "getAdView", "()Landroid/widget/FrameLayout;", "adView$delegate", "Lkotlin/Lazy;", "adWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "getAdWebView", "()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "adWebView$delegate", "animationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPVideoImageAnimationHelper;", "animationIv", "Landroid/widget/ImageView;", "getAnimationIv", "()Landroid/widget/ImageView;", "animationIv$delegate", "animationLayout", "Landroid/view/View;", "getAnimationLayout", "()Landroid/view/View;", "animationLayout$delegate", "animationMaskView", "getAnimationMaskView", "animationMaskView$delegate", "commentListView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "getCommentListView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "commentListView$delegate", "commentView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;", "commentView$delegate", "commentViewHeader", "getCommentViewHeader", "commentViewHeader$delegate", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "debugAD", "", "density", "", "enterPageTime", "", "fullscreenImpl", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenImpl;", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "getA8KeyScene", "", "getGetA8KeyScene", "()I", "getA8KeyScene$delegate", "headerView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "getHeaderView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "headerView$delegate", "isInFullScreen", "kbLayout", "Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;", "getKbLayout", "()Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;", "kbLayout$delegate", "kbTouchLayout", "getKbTouchLayout", "kbTouchLayout$delegate", "mOnForegroundListener", "com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$mOnForegroundListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$mOnForegroundListener$1;", "maxVideoHeight", "getMaxVideoHeight", "setMaxVideoHeight", "(I)V", "menuHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "minVideoHeight", "getMinVideoHeight", "setMinVideoHeight", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "msgInfo$delegate", "needToDoHeightAnimation", "getNeedToDoHeightAnimation", "()Z", "setNeedToDoHeightAnimation", "(Z)V", "orientationHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "pageStayTime", "previewBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;", "getPreviewBar", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;", "previewBar$delegate", "publishId", "getPublishId", "()Ljava/lang/String;", "publishId$delegate", "resumePageTime", "rootView", "Landroid/widget/RelativeLayout;", "getRootView", "()Landroid/widget/RelativeLayout;", "rootView$delegate", "saveBundle", "Landroid/os/Bundle;", "scene", "getScene", "scene$delegate", "screenHeight", "getScreenHeight", "setScreenHeight", "screenWidth", "getScreenWidth", "setScreenWidth", "subScene", "getSubScene", "subScene$delegate", "videoErrView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "getVideoErrView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "videoErrView$delegate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoView", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "videoView$delegate", "videoViewContainer", "getVideoViewContainer", "videoViewContainer$delegate", "writeCommentContainer", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "getWriteCommentContainer", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "writeCommentContainer$delegate", "addNetSceneListener", "", "destroyReport", "destroyWebView", "doPlayVideo", "urlInfo", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "doVideoHeightAnimation", "enableOrientationListener", "enable", "finish", "getForceOrientation", "getFullscreenImpl", "getLayoutId", "goneVideoErrorView", "init", "initActionBar", "initAd", "initCommentContainer", "initHeader", "initOrientationHelper", "initVideoBaseParam", "initVideoParam", "initVideoView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppMsgGet", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetResp;", "onBackPressed", "onCreate", "savedInstanceState", "onDestroy", "onGetAdData", "appMsgAdvert", "Lcom/tencent/mm/protocal/protobuf/AppMsgAdvert;", "onGetExtData", "Lcom/tencent/mm/protocal/protobuf/AppMsgGetExtResp;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStart", "removeNetSceneListener", "sendScrollEvent", "setTouchListener", "view", "height", "showVideoErrorView", "updateAdHeight", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI */
public class BizVideoDetailUI extends MMActivity implements C1202f {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "rootView", "getRootView()Landroid/widget/RelativeLayout;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "animationMaskView", "getAnimationMaskView()Landroid/view/View;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "kbLayout", "getKbLayout()Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "kbTouchLayout", "getKbTouchLayout()Landroid/view/View;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "videoView", "getVideoView()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "videoErrView", "getVideoErrView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "videoViewContainer", "getVideoViewContainer()Landroid/widget/FrameLayout;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "commentViewHeader", "getCommentViewHeader()Landroid/view/View;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "headerView", "getHeaderView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "adView", "getAdView()Landroid/widget/FrameLayout;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "commentView", "getCommentView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "commentListView", "getCommentListView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "writeCommentContainer", "getWriteCommentContainer()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "previewBar", "getPreviewBar()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "animationIv", "getAnimationIv()Landroid/widget/ImageView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "animationLayout", "getAnimationLayout()Landroid/view/View;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "adWebView", "getAdWebView()Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "scene", "getScene()I")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "subScene", "getSubScene()I")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "publishId", "getPublishId()Ljava/lang/String;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "getA8KeyScene", "getGetA8KeyScene()I")), C44855v.m82052a(new C25054t(C44855v.m82055aN(BizVideoDetailUI.class), "msgInfo", "getMsgInfo()Lcom/tencent/mm/message/MPMsgInfo;"))};
    private final String TAG = "MicroMsg.BizVideoDetailUI";
    private int bpm;
    private float density;
    private int ieu;
    private int iev;
    private long ism;
    private final boolean jVT;
    private final C44856f jVU = C17344i.m26854g(new C7746aa(this));
    private final C44856f jVV = C17344i.m26854g(new C7749e(this));
    private final C44856f jVW = C17344i.m26854g(new C2734r(this));
    private final C44856f jVX = C17344i.m26854g(new C2735s(this));
    private final C44856f jVY = C17344i.m26854g(new C7726af(this));
    private final C44856f jVZ = C17344i.m26854g(new C7725ae(this));
    boolean jWA;
    private C33752b jWB = new C7730j(this);
    private final C7727t jWC = new C7727t(this);
    private final C44856f jWa = C17344i.m26854g(new C7748ag(this));
    private final C44856f jWb = C17344i.m26854g(new C7729h(this));
    private final C44856f jWc = C17344i.m26854g(new C7735l(this));
    private final C44856f jWd = C17344i.m26854g(new C7722a(this));
    private final C44856f jWe = C17344i.m26854g(new C7750g(this));
    private final C44856f jWf = C17344i.m26854g(new C7744f(this));
    private final C44856f jWg = C17344i.m26854g(new C7742ah(this));
    private final C44856f jWh = C17344i.m26854g(new C7741y(this));
    private final C44856f jWi = C17344i.m26854g(new C7743c(this));
    private final C44856f jWj = C17344i.m26854g(new C7747d(this));
    private C33744g jWk = new C33744g();
    private C27559b jWl;
    private boolean jWm;
    private C2751a jWn;
    private long jWo;
    private long jWp;
    private final C44856f jWq = C17344i.m26854g(new C7732b(this));
    private final C44856f jWr = C17344i.m26854g(new C7731ab(this));
    private final C44856f jWs = C17344i.m26854g(new C7724ad(this));
    private final C44856f jWt = C17344i.m26854g(new C7728z(this));
    private final C44856f jWu = C17344i.m26854g(new C2731k(this));
    private final C44856f jWv = C17344i.m26854g(new C7739u(this));
    int jWw;
    private C45767b jWx = new C45767b();
    private Bundle jWy;
    private C33743f jWz = new C33743f();
    private int videoHeight;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$k */
    static final class C2731k extends C25053k implements C31214a<Integer> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C2731k(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15153);
            Integer valueOf = Integer.valueOf(this.jWD.getIntent().getIntExtra("geta8key_scene", 0));
            AppMethodBeat.m2505o(15153);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$FullScreenDelegate;", "enterFullScreen", "", "direction", "", "isFullScreen", "", "quitFullScreen", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$p */
    public static final class C2732p implements C33751a {
        final /* synthetic */ BizVideoDetailUI jWD;

        C2732p(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        /* renamed from: on */
        public final void mo6803on(int i) {
            AppMethodBeat.m2504i(15158);
            this.jWD.aYt().removeView(BizVideoDetailUI.m13762c(this.jWD));
            this.jWD.jWm = true;
            BizVideoDetailUI.m13764e(this.jWD).mo6823G(BizVideoDetailUI.m13762c(this.jWD), i);
            if (i == 0 || i == 180) {
                BizVideoDetailUI.m13762c(this.jWD).setPageGestureInFullscreen(false);
            } else {
                BizVideoDetailUI.m13762c(this.jWD).setPageGestureInFullscreen(true);
            }
            this.jWD.jWx.jVJ.mo45367sE(5);
            AppMethodBeat.m2505o(15158);
        }

        public final void aDF() {
            AppMethodBeat.m2504i(15159);
            BizVideoDetailUI.m13764e(this.jWD).aIZ();
            this.jWD.setRequestedOrientation(1);
            this.jWD.jWx.jVJ.mo45367sE(6);
            AppMethodBeat.m2505o(15159);
        }

        public final boolean isFullScreen() {
            AppMethodBeat.m2504i(15160);
            boolean d = this.jWD.jWm;
            AppMethodBeat.m2505o(15160);
            return d;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$initVideoView$2", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$MPVideoViewCallBack;", "onPlayError", "", "errorMsg", "", "errorCode", "", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$q */
    public static final class C2733q implements C38723b {
        final /* synthetic */ BizVideoDetailUI jWD;

        C2733q(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        /* renamed from: Gf */
        public final void mo6804Gf(String str) {
            AppMethodBeat.m2504i(15161);
            BizVideoDetailUI.m13766g(this.jWD).setPlayError$505cff1c(str);
            BizVideoDetailUI.m13767h(this.jWD);
            AppMethodBeat.m2505o(15161);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$r */
    static final class C2734r extends C25053k implements C31214a<BizKeyboardLinearLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C2734r(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15162);
            BizKeyboardLinearLayout bizKeyboardLinearLayout = (BizKeyboardLinearLayout) this.jWD.findViewById(2131821885);
            AppMethodBeat.m2505o(15162);
            return bizKeyboardLinearLayout;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$s */
    static final class C2735s extends C25053k implements C31214a<View> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C2735s(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15163);
            View findViewById = this.jWD.findViewById(2131821886);
            AppMethodBeat.m2505o(15163);
            return findViewById;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$a */
    static final class C7722a extends C25053k implements C31214a<FrameLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7722a(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15141);
            FrameLayout frameLayout = (FrameLayout) BizVideoDetailUI.m13770k(this.jWD).findViewById(2131826168);
            AppMethodBeat.m2505o(15141);
            return frameLayout;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$ac */
    static final class C7723ac implements OnTouchListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7723ac(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(15173);
            C25052j.m39375o(motionEvent, "event");
            if (motionEvent.getAction() == 0) {
                MPVideoWriteCommentLayout i = BizVideoDetailUI.m13768i(this.jWD);
                if (i.jYe == -3) {
                    Context context = i.getContext();
                    if (context == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.m2505o(15173);
                        throw c44941v;
                    }
                    ((MMActivity) context).aqX();
                } else if (i.jXV.aYU() && i.aFF()) {
                    i.jXV.aYW();
                } else {
                    i.hide();
                }
            }
            AppMethodBeat.m2505o(15173);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$ad */
    static final class C7724ad extends C25053k implements C31214a<Integer> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7724ad(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15174);
            Integer valueOf = Integer.valueOf(this.jWD.getIntent().getIntExtra("biz_video_subscene", 0));
            AppMethodBeat.m2505o(15174);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoErrorView;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$ae */
    static final class C7725ae extends C25053k implements C31214a<MPVideoErrorView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7725ae(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15175);
            MPVideoErrorView mPVideoErrorView = (MPVideoErrorView) BizVideoDetailUI.m13762c(this.jWD).findViewById(2131826192);
            AppMethodBeat.m2505o(15175);
            return mPVideoErrorView;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$af */
    static final class C7726af extends C25053k implements C31214a<MPVideoView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7726af(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15176);
            MPVideoView mPVideoView = (MPVideoView) this.jWD.findViewById(2131821880);
            AppMethodBeat.m2505o(15176);
            return mPVideoView;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$mOnForegroundListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppActiveEvent;", "callback", "", "event", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$t */
    public static final class C7727t extends C4884c<C6504k> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7727t(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15164);
            C6504k c6504k = (C6504k) c4883b;
            if (!((c6504k != null ? c6504k.csh : null) == null || c6504k.csh.csi)) {
                this.jWD.jWo = 0;
            }
            AppMethodBeat.m2505o(15164);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$z */
    static final class C7728z extends C25053k implements C31214a<String> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7728z(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15170);
            String stringExtra = this.jWD.getIntent().getStringExtra("KPublisherId");
            AppMethodBeat.m2505o(15170);
            return stringExtra;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$h */
    static final class C7729h extends C25053k implements C31214a<View> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7729h(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15150);
            View inflate = LayoutInflater.from(this.jWD.dxU()).inflate(2130970252, null, false);
            AppMethodBeat.m2505o(15150);
            return inflate;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPFullscreenStatusListener;", "onExitFullscreen", "", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$j */
    public static final class C7730j extends C33752b {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7730j(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void aDI() {
            AppMethodBeat.m2504i(15152);
            this.jWD.jWm = false;
            this.jWD.aYt().addView(BizVideoDetailUI.m13762c(this.jWD), 0);
            AppMethodBeat.m2505o(15152);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$ab */
    static final class C7731ab extends C25053k implements C31214a<Integer> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7731ab(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15172);
            Integer valueOf = Integer.valueOf(this.jWD.getIntent().getIntExtra("biz_video_scene", 0));
            AppMethodBeat.m2505o(15172);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$b */
    static final class C7732b extends C25053k implements C31214a<MMWebViewWithJsApi> {
        final /* synthetic */ BizVideoDetailUI jWD;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "viewHeight", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$b$2 */
        static final class C27302 extends C25053k implements C17126b<Integer, C37091y> {
            final /* synthetic */ C7732b jWE;

            C27302(C7732b c7732b) {
                this.jWE = c7732b;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(15143);
                int intValue = ((Number) obj).intValue();
                C4990ab.m7416i(this.jWE.jWD.TAG, "config ad webview height:".concat(String.valueOf(intValue)));
                BizVideoDetailUI.m13758a(this.jWE.jWD, intValue);
                BizVideoDetailUI.m13769j(this.jWE.jWD);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(15143);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "webViewDenisty", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$b$1 */
        static final class C77331 extends C25053k implements C17126b<Float, C37091y> {
            final /* synthetic */ C7732b jWE;

            C77331(C7732b c7732b) {
                this.jWE = c7732b;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(15142);
                float floatValue = ((Number) obj).floatValue();
                this.jWE.jWD.density = floatValue;
                C4990ab.m7416i(this.jWE.jWD.TAG, "config ad webview density:".concat(String.valueOf(floatValue)));
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(15142);
                return c37091y;
            }
        }

        C7732b(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15144);
            C42831a c42831a = C42831a.jVq;
            MMWebViewWithJsApi fv = C14670a.m22875fv(this.jWD.dxU());
            C25052j.m39375o(fv, "MMWebViewWithJsApi.Factory.create(this.context)");
            String l = BizVideoDetailUI.m13771l(this.jWD);
            C25052j.m39375o(l, "publishId");
            MMWebViewWithJsApi a = C42831a.m75978a(fv, l, new C77331(this), new C27302(this), BizVideoDetailUI.m13773n(this.jWD));
            AppMethodBeat.m2505o(15144);
            return a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$i */
    static final class C7734i implements AnimatorUpdateListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7734i(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(15151);
            C25052j.m39375o(valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.m2505o(15151);
                throw c44941v;
            }
            int intValue = ((Integer) animatedValue).intValue();
            FrameLayout aYt = this.jWD.aYt();
            C25052j.m39375o(aYt, "videoViewContainer");
            BizVideoDetailUI.m13755Q(aYt, intValue);
            View b = BizVideoDetailUI.m13761b(this.jWD);
            C25052j.m39375o(b, "animationLayout");
            BizVideoDetailUI.m13755Q(b, intValue);
            AppMethodBeat.m2505o(15151);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoHeaderView;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$l */
    static final class C7735l extends C25053k implements C31214a<MPVideoHeaderView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7735l(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15154);
            MPVideoHeaderView mPVideoHeaderView = (MPVideoHeaderView) BizVideoDetailUI.m13770k(this.jWD).findViewById(2131826167);
            AppMethodBeat.m2505o(15154);
            return mPVideoHeaderView;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$m */
    static final class C7736m implements OnMenuItemClickListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7736m(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(15155);
            this.jWD.aqX();
            this.jWD.finish();
            AppMethodBeat.m2505o(15155);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$n */
    static final class C7737n implements OnMenuItemClickListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7737n(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(15156);
            C33744g a = this.jWD.jWk;
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
                C4990ab.m7417i(str, str2, objArr);
            } else {
                a.iHZ = new C36356d(a.aYo(), 0, true);
                C36356d c36356d = a.iHZ;
                if (c36356d != null) {
                    c36356d.mo57235a((C36073c) new C33746a(a));
                }
                c36356d = a.iHZ;
                if (c36356d != null) {
                    c36356d.mo57236a((C5279d) new C33745b(a));
                }
                c36356d = a.iHZ;
                if (c36356d != null) {
                    c36356d.mo57242q(" ", 1);
                }
                C36356d c36356d2 = a.iHZ;
                if (c36356d2 != null) {
                    c36356d2.cpD();
                }
            }
            AppMethodBeat.m2505o(15156);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$o */
    static final class C7738o implements OnLongClickListener {
        public static final C7738o jWF = new C7738o();

        static {
            AppMethodBeat.m2504i(15157);
            AppMethodBeat.m2505o(15157);
        }

        C7738o() {
        }

        public final boolean onLongClick(View view) {
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/message/MPMsgInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$u */
    static final class C7739u extends C25053k implements C31214a<C37436r> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7739u(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15165);
            Intent intent = this.jWD.getIntent();
            C25052j.m39375o(intent, "intent");
            C37436r R = C11263c.m18981R(intent);
            AppMethodBeat.m2505o(15165);
            return R;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onScrollChanged"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$v */
    static final class C7740v implements OnScrollChangedListener {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7740v(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void onScrollChanged() {
            AppMethodBeat.m2504i(15166);
            BizVideoDetailUI.m13769j(this.jWD);
            AppMethodBeat.m2505o(15166);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPPreviewBar;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$y */
    static final class C7741y extends C25053k implements C31214a<MPPreviewBar> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7741y(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15169);
            MPPreviewBar mPPreviewBar = (MPPreviewBar) this.jWD.findViewById(2131821881);
            AppMethodBeat.m2505o(15169);
            return mPPreviewBar;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$ah */
    static final class C7742ah extends C25053k implements C31214a<MPVideoWriteCommentLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7742ah(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15178);
            MPVideoWriteCommentLayout mPVideoWriteCommentLayout = (MPVideoWriteCommentLayout) this.jWD.findViewById(2131821887);
            AppMethodBeat.m2505o(15178);
            return mPVideoWriteCommentLayout;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$c */
    static final class C7743c extends C25053k implements C31214a<ImageView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7743c(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15145);
            ImageView imageView = (ImageView) this.jWD.findViewById(2131821890);
            AppMethodBeat.m2505o(15145);
            return imageView;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoMRecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$f */
    static final class C7744f extends C25053k implements C31214a<MPVideoMRecyclerView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7744f(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15148);
            MPVideoMRecyclerView mPVideoMRecyclerView = (MPVideoMRecyclerView) this.jWD.findViewById(2131821882);
            AppMethodBeat.m2505o(15148);
            return mPVideoMRecyclerView;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI$onStart$1", "Lcom/tencent/mm/ui/tools/ImagePreviewAnimation$ICallback;", "onAnimationEnd", "", "onAnimationStart", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$x */
    public static final class C7745x implements C24051b {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7745x(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void onAnimationStart() {
        }

        public final void onAnimationEnd() {
            AppMethodBeat.m2504i(15168);
            if (this.jWD.jWA) {
                this.jWD.jWA = false;
                this.jWD.aYG();
            }
            AppMethodBeat.m2505o(15168);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$aa */
    static final class C7746aa extends C25053k implements C31214a<RelativeLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7746aa(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15171);
            RelativeLayout relativeLayout = (RelativeLayout) this.jWD.findViewById(2131821878);
            AppMethodBeat.m2505o(15171);
            return relativeLayout;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$d */
    static final class C7747d extends C25053k implements C31214a<View> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7747d(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15146);
            View findViewById = this.jWD.findViewById(2131821889);
            AppMethodBeat.m2505o(15146);
            return findViewById;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$ag */
    static final class C7748ag extends C25053k implements C31214a<FrameLayout> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7748ag(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15177);
            FrameLayout frameLayout = (FrameLayout) this.jWD.findViewById(2131821879);
            AppMethodBeat.m2505o(15177);
            return frameLayout;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$e */
    static final class C7749e extends C25053k implements C31214a<View> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7749e(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15147);
            View findViewById = this.jWD.findViewById(2131821888);
            AppMethodBeat.m2505o(15147);
            return findViewById;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$g */
    static final class C7750g extends C25053k implements C31214a<MPVideoCommentView> {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7750g(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(15149);
            MPVideoCommentView mPVideoCommentView = (MPVideoCommentView) BizVideoDetailUI.m13770k(this.jWD).findViewById(2131826169);
            AppMethodBeat.m2505o(15149);
            return mPVideoCommentView;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI$w */
    static final class C7751w implements Runnable {
        final /* synthetic */ BizVideoDetailUI jWD;

        C7751w(BizVideoDetailUI bizVideoDetailUI) {
            this.jWD = bizVideoDetailUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(15167);
            this.jWD.finish();
            AppMethodBeat.m2505o(15167);
        }
    }

    static {
        AppMethodBeat.m2504i(15179);
        AppMethodBeat.m2505o(15179);
    }

    private final ImageView aYA() {
        AppMethodBeat.m2504i(15190);
        ImageView imageView = (ImageView) this.jWi.getValue();
        AppMethodBeat.m2505o(15190);
        return imageView;
    }

    private final View aYB() {
        AppMethodBeat.m2504i(15191);
        View view = (View) this.jWj.getValue();
        AppMethodBeat.m2505o(15191);
        return view;
    }

    private final MMWebViewWithJsApi aYC() {
        AppMethodBeat.m2504i(15192);
        MMWebViewWithJsApi mMWebViewWithJsApi = (MMWebViewWithJsApi) this.jWq.getValue();
        AppMethodBeat.m2505o(15192);
        return mMWebViewWithJsApi;
    }

    private final C37436r aYD() {
        AppMethodBeat.m2504i(15193);
        C37436r c37436r = (C37436r) this.jWv.getValue();
        AppMethodBeat.m2505o(15193);
        return c37436r;
    }

    private final View aYq() {
        AppMethodBeat.m2504i(15180);
        View view = (View) this.jVV.getValue();
        AppMethodBeat.m2505o(15180);
        return view;
    }

    private final MPVideoView aYr() {
        AppMethodBeat.m2504i(15181);
        MPVideoView mPVideoView = (MPVideoView) this.jVY.getValue();
        AppMethodBeat.m2505o(15181);
        return mPVideoView;
    }

    private final MPVideoErrorView aYs() {
        AppMethodBeat.m2504i(15182);
        MPVideoErrorView mPVideoErrorView = (MPVideoErrorView) this.jVZ.getValue();
        AppMethodBeat.m2505o(15182);
        return mPVideoErrorView;
    }

    private final View aYu() {
        AppMethodBeat.m2504i(15184);
        View view = (View) this.jWb.getValue();
        AppMethodBeat.m2505o(15184);
        return view;
    }

    private final MPVideoHeaderView aYv() {
        AppMethodBeat.m2504i(15185);
        MPVideoHeaderView mPVideoHeaderView = (MPVideoHeaderView) this.jWc.getValue();
        AppMethodBeat.m2505o(15185);
        return mPVideoHeaderView;
    }

    private final FrameLayout aYw() {
        AppMethodBeat.m2504i(15186);
        FrameLayout frameLayout = (FrameLayout) this.jWd.getValue();
        AppMethodBeat.m2505o(15186);
        return frameLayout;
    }

    private final MPVideoCommentView aYx() {
        AppMethodBeat.m2504i(15187);
        MPVideoCommentView mPVideoCommentView = (MPVideoCommentView) this.jWe.getValue();
        AppMethodBeat.m2505o(15187);
        return mPVideoCommentView;
    }

    private final MPVideoMRecyclerView aYy() {
        AppMethodBeat.m2504i(15188);
        MPVideoMRecyclerView mPVideoMRecyclerView = (MPVideoMRecyclerView) this.jWf.getValue();
        AppMethodBeat.m2505o(15188);
        return mPVideoMRecyclerView;
    }

    private final MPVideoWriteCommentLayout aYz() {
        AppMethodBeat.m2504i(15189);
        MPVideoWriteCommentLayout mPVideoWriteCommentLayout = (MPVideoWriteCommentLayout) this.jWg.getValue();
        AppMethodBeat.m2505o(15189);
        return mPVideoWriteCommentLayout;
    }

    public final FrameLayout aYt() {
        AppMethodBeat.m2504i(15183);
        FrameLayout frameLayout = (FrameLayout) this.jWa.getValue();
        AppMethodBeat.m2505o(15183);
        return frameLayout;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BizVideoDetailUI() {
        AppMethodBeat.m2504i(15211);
        AppMethodBeat.m2505o(15211);
    }

    /* renamed from: Q */
    public static final /* synthetic */ void m13755Q(View view, int i) {
        AppMethodBeat.m2504i(15212);
        BizVideoDetailUI.m13754P(view, i);
        AppMethodBeat.m2505o(15212);
    }

    /* renamed from: b */
    public static final /* synthetic */ View m13761b(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.m2504i(15213);
        View aYB = bizVideoDetailUI.aYB();
        AppMethodBeat.m2505o(15213);
        return aYB;
    }

    /* renamed from: c */
    public static final /* synthetic */ MPVideoView m13762c(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.m2504i(15214);
        MPVideoView aYr = bizVideoDetailUI.aYr();
        AppMethodBeat.m2505o(15214);
        return aYr;
    }

    /* renamed from: g */
    public static final /* synthetic */ MPVideoErrorView m13766g(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.m2504i(15216);
        MPVideoErrorView aYs = bizVideoDetailUI.aYs();
        AppMethodBeat.m2505o(15216);
        return aYs;
    }

    /* renamed from: h */
    public static final /* synthetic */ void m13767h(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.m2504i(15217);
        bizVideoDetailUI.aYJ();
        AppMethodBeat.m2505o(15217);
    }

    /* renamed from: i */
    public static final /* synthetic */ MPVideoWriteCommentLayout m13768i(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.m2504i(15218);
        MPVideoWriteCommentLayout aYz = bizVideoDetailUI.aYz();
        AppMethodBeat.m2505o(15218);
        return aYz;
    }

    /* renamed from: k */
    public static final /* synthetic */ View m13770k(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.m2504i(15220);
        View aYu = bizVideoDetailUI.aYu();
        AppMethodBeat.m2505o(15220);
        return aYu;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(15194);
        C30036f.m47544m(this);
        this.jWy = bundle;
        super.onCreate(bundle);
        if (aYD().fjT == null) {
            finish();
            C4990ab.m7420w(this.TAG, "onCreate msgInfo.item is null");
            AppMethodBeat.m2505o(15194);
            return;
        }
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("onCreate rawUrl is ");
        C32224p c32224p = aYD().fjT;
        if (c32224p == null) {
            C25052j.dWJ();
        }
        C4990ab.m7416i(str, stringBuilder.append(c32224p.url).toString());
        C1720g.m3540Rg().mo14539a(1179, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2866, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2776, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2759, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2691, (C1202f) this);
        C1720g.m3540Rg().mo14539a(2617, (C1202f) this);
        C33744g c33744g = this.jWk;
        C37436r aYD = aYD();
        C45767b c45767b = this.jWx;
        C25052j.m39376p(this, "ui");
        C25052j.m39376p(aYD, "msgInfo");
        C25052j.m39376p(c45767b, "controller");
        c33744g.hiC = new WeakReference(this);
        c33744g.jVG = aYD;
        c33744g.jWx = c45767b;
        mo17446xE(C1338a.m2872i(dxU(), C25738R.color.a3p));
        setBackBtn(new C7736m(this), C1318a.actionbar_icon_light_close);
        getController().mo11216l(this, WebView.NIGHT_MODE_COLOR);
        mo17377a((int) C1318a.actionbar_icon_light_more, (OnMenuItemClickListener) new C7737n(this), (OnLongClickListener) C7738o.jWF);
        setMMTitle("");
        MPVideoCommentView aYx = aYx();
        MPVideoMRecyclerView aYy = aYy();
        C25052j.m39375o(aYy, "commentListView");
        MRecyclerView mRecyclerView = aYy;
        View aYu = aYu();
        C25052j.m39375o(aYu, "commentViewHeader");
        C45767b c45767b2 = this.jWx;
        C25052j.m39376p(mRecyclerView, "recyclerView");
        C25052j.m39376p(aYu, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        C25052j.m39376p(c45767b2, "controller");
        aYx.jWJ = mRecyclerView;
        LinkedList linkedList = new LinkedList();
        Context context = aYx.getContext();
        C25052j.m39375o(context, "context");
        aYx.jWM = new C2736a(context, linkedList, c45767b2);
        mRecyclerView.setAdapter(aYx.jWM);
        mRecyclerView.addHeaderView(aYu);
        aYx.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager());
        mRecyclerView.setNestedScrollingEnabled(false);
        MPVideoCommentView aYx2 = aYx();
        MPVideoWriteCommentLayout aYz = aYz();
        C25052j.m39375o(aYz, "writeCommentContainer");
        aYx2.setWriteCommentLayout(aYz);
        MPVideoWriteCommentLayout aYz2 = aYz();
        BizKeyboardLinearLayout bizKeyboardLinearLayout = (BizKeyboardLinearLayout) this.jVW.getValue();
        C25052j.m39375o(bizKeyboardLinearLayout, "kbLayout");
        C25052j.m39376p(bizKeyboardLinearLayout, "kbLayout");
        aYz2.jXU = bizKeyboardLinearLayout;
        bizKeyboardLinearLayout.setOnkbdStateListener(new C20100c(aYz2, bizKeyboardLinearLayout));
        aYz().setController(this.jWx);
        c45767b2 = this.jWx;
        int intValue = ((Number) this.jWr.getValue()).intValue();
        int intValue2 = ((Number) this.jWs.getValue()).intValue();
        C32224p c32224p2 = aYD().fjT;
        if (c32224p2 == null) {
            C25052j.dWJ();
        }
        C37436r aYD2 = aYD();
        C25052j.m39376p(this, "ui");
        C25052j.m39376p(c32224p2, "readerItem");
        C25052j.m39376p(aYD2, "msgInfo");
        c45767b2.hiC = new WeakReference(this);
        c45767b2.scene = intValue;
        c45767b2.jSW = intValue2;
        c45767b2.mo73551Gd(c32224p2.url);
        c45767b2.jVH = c32224p2;
        c45767b2.jVG = aYD2;
        c45767b2.ffZ = c32224p2.type;
        c45767b2.cwG = aYD2.cwG;
        c45767b2.jVz = aYD2.fjR;
        c45767b2.fgd = aYD2.fjT.fgd;
        C38715e c38715e = c45767b2.jVC;
        C25052j.m39376p(c45767b2, "controller");
        c38715e.jWx = c45767b2;
        C27562d c27562d = c45767b2.jVJ;
        C25052j.m39376p(c45767b2, "controller");
        c27562d.jWx = c45767b2;
        c27562d.mo45367sE(1);
        try {
            Uri parse = Uri.parse(aYD2.fjT.url);
            c45767b2.jVD = C5046bo.getLong(parse.getQueryParameter("mid"), 0);
            c45767b2.jVE = C5046bo.getInt(parse.getQueryParameter("idx"), 0);
        } catch (UnsupportedOperationException e) {
            C4990ab.m7421w(c45767b2.TAG, "init parse url exp %s", e.getMessage());
        } catch (Exception e2) {
            C4990ab.m7421w(c45767b2.TAG, "init parse url exp %s", e2.getMessage());
        }
        C4990ab.m7416i(c45767b2.TAG, "init vid=" + c45767b2.fgd);
        this.jWx.aYm();
        this.jWx.mo73562sB(1);
        c45767b2 = this.jWx;
        C40516eh c40516eh = new C40516eh();
        c40516eh.url = c45767b2.url;
        c40516eh.scene = c45767b2.scene;
        c40516eh.vFQ = c45767b2.jSW;
        c40516eh.vFO = c45767b2.ffZ;
        c40516eh.session_id = C30309s.getSessionId();
        c40516eh.vFP = c45767b2.jVF;
        C1196a c1196a = new C1196a();
        c1196a.mo4444a(c40516eh);
        c1196a.mo4446b(new C46536ei());
        c1196a.mo4450qq("/cgi-bin/mmbiz-bin/appmsg/appmsg_getext");
        c1196a.mo4447kU(2776);
        c1196a.mo4448kV(0);
        c1196a.mo4449kW(0);
        C1226w.m2654a(c1196a.acD(), C45766g.jVR);
        MPVideoHeaderView aYv = aYv();
        aYD = aYD();
        c45767b = this.jWx;
        C25052j.m39376p(aYD, "msgInfo");
        C25052j.m39376p(c45767b, "controller");
        aYv.jVG = aYD;
        aYv.talker = c45767b.mo73552HE();
        C32224p c32224p3 = aYD.fjT;
        C25052j.m39375o(c32224p3, "msgInfo.item");
        aYv.jVH = c32224p3;
        aYv.jWx = c45767b;
        aYv.initView();
        aYv = aYv();
        aYz = aYz();
        C25052j.m39375o(aYz, "writeCommentContainer");
        aYv.setWriteCommentLayout(aYz);
        View findViewById = findViewById(2131821884);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_wow_edu_view)");
        aYv().setWowEduView((MPVideoWowEduView) findViewById);
        aYw().addView(aYC(), 0);
        aYr().setBizVideoControlBar(this.jWx);
        aYE();
        C4990ab.m7416i(this.TAG, "initVideoParam width " + aYD().fjT.videoWidth + " height " + aYD().fjT.videoHeight);
        if (aYD().fjT.videoWidth <= 0 || aYD().fjT.videoHeight <= 0) {
            aYr();
            str = MPVideoView.m75992a(aYD());
            if (C5730e.m8628ct(str)) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = C5056d.decodeFile(str, options);
                if (options.outWidth > 0 && options.outHeight > 0) {
                    aYD().fjT.videoWidth = options.outWidth;
                    aYD().fjT.videoHeight = options.outHeight;
                    C4990ab.m7416i(this.TAG, "initVideoParam with cover: width " + aYD().fjT.videoWidth + " height " + aYD().fjT.videoHeight);
                }
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
            }
        }
        aYF();
        FrameLayout aYt = aYt();
        C25052j.m39375o(aYt, "videoViewContainer");
        BizVideoDetailUI.m13754P(aYt, this.videoHeight);
        findViewById = aYB();
        C25052j.m39375o(findViewById, "animationLayout");
        BizVideoDetailUI.m13754P(findViewById, this.videoHeight);
        C4990ab.m7416i(this.TAG, "initVideoParam minVideoHeight " + this.jWw + " maxVideoHeight " + this.bpm);
        aYr().setFullScreenDelegate(new C2732p(this));
        aYr().setMPVideoViewCallBack(new C2733q(this));
        aYr().setTitle(aYD().fjT.title);
        MPVideoErrorView aYs = aYs();
        c45767b = this.jWx;
        C33743f c33743f = this.jWz;
        C25052j.m39376p(c45767b, "controller");
        aYs.jWH.setOnClickListener(new C20092a(aYs, c45767b, c33743f));
        ((View) this.jVX.getValue()).setOnTouchListener(new C7723ac(this));
        this.jWo = System.currentTimeMillis();
        C4879a.xxA.mo10052c(this.jWC);
        AppMethodBeat.m2505o(15194);
    }

    private final void aYE() {
        AppMethodBeat.m2504i(15195);
        this.ieu = C1338a.m2868gd(dxU());
        this.iev = C1338a.m2869ge(dxU());
        this.bpm = (int) (0.65d * ((double) this.iev));
        this.jWw = (this.ieu * 9) / 16;
        this.bpm = Math.max(this.bpm, this.jWw);
        this.videoHeight = this.jWw;
        AppMethodBeat.m2505o(15195);
    }

    private final void aYF() {
        int i;
        AppMethodBeat.m2504i(15196);
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
        C25052j.m39375o(aYr, "videoView");
        FrameLayout aYt = aYt();
        C25052j.m39375o(aYt, "videoViewContainer");
        View aYB = aYB();
        C25052j.m39375o(aYB, "animationLayout");
        aYy.mo68305a(aYr, aYt, aYB, this.bpm, this.jWw);
        C33743f c33743f = this.jWz;
        Intent intent = getIntent();
        C25052j.m39375o(intent, "intent");
        AppCompatActivity dxU = dxU();
        C25052j.m39375o(dxU, "context");
        Context context = dxU;
        aYB = aYB();
        C25052j.m39375o(aYB, "animationLayout");
        c33743f.mo54273a(intent, context, aYB, aYq());
        aYr().mo68310a(aYA(), aYD().fjT.fjx, this.ieu, this.videoHeight, aYD());
        AppMethodBeat.m2505o(15196);
    }

    public final void aYG() {
        AppMethodBeat.m2504i(15197);
        int i = this.videoHeight;
        aYE();
        aYF();
        C4990ab.m7416i(this.TAG, "initVideoParam with cgi: width " + aYD().fjT.videoWidth + " height " + aYD().fjT.videoHeight);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, this.videoHeight});
        ofInt.addUpdateListener(new C7734i(this));
        C25052j.m39375o(ofInt, "va");
        ofInt.setDuration(100);
        ofInt.start();
        AppMethodBeat.m2505o(15197);
    }

    /* renamed from: P */
    private static void m13754P(View view, int i) {
        AppMethodBeat.m2504i(15198);
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.m2505o(15198);
            throw c44941v;
        }
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(15198);
    }

    /* renamed from: fz */
    public final void mo17555fz(boolean z) {
        AppMethodBeat.m2504i(15199);
        if (this.jWl != null) {
            C27559b c27559b = this.jWl;
            if (c27559b != null) {
                c27559b.mo45365fB(z);
                AppMethodBeat.m2505o(15199);
                return;
            }
        }
        AppMethodBeat.m2505o(15199);
    }

    private final void aYH() {
        AppMethodBeat.m2504i(15200);
        if (this.jWl != null) {
            AppMethodBeat.m2505o(15200);
            return;
        }
        AppCompatActivity dxU = dxU();
        C25052j.m39375o(dxU, "context");
        Context context = dxU;
        MPVideoView aYr = aYr();
        C25052j.m39375o(aYr, "videoView");
        this.jWl = new C27559b(context, aYr);
        C27559b c27559b = this.jWl;
        if (c27559b != null) {
            c27559b.mo45365fB(true);
            AppMethodBeat.m2505o(15200);
            return;
        }
        AppMethodBeat.m2505o(15200);
    }

    public final int getLayoutId() {
        return 2130968880;
    }

    public void onResume() {
        AppMethodBeat.m2504i(15201);
        super.onResume();
        aYr().akW();
        this.jWp = System.currentTimeMillis();
        AppMethodBeat.m2505o(15201);
    }

    public void onStart() {
        boolean z;
        AppMethodBeat.m2504i(15202);
        super.onStart();
        C33743f c33743f = this.jWz;
        if (C37436r.m63099ks(aYD().fgc)) {
            z = false;
        } else {
            z = true;
        }
        c33743f.enable = z;
        c33743f = this.jWz;
        Bundle bundle = this.jWy;
        C24051b c7745x = new C7745x(this);
        C25052j.m39376p(c7745x, "callBack");
        C30759e c30759e = c33743f.jYE;
        if (c30759e == null) {
            C25052j.avw("imagePreviewAnimation");
        }
        c30759e.mo49164L(c33743f.f15043xJ, c33743f.f15044xL, c33743f.mWidth, c33743f.mHeight);
        if (c33743f.jYD || c33743f.mWidth == 0 || c33743f.mHeight == 0 || !c33743f.enable || bundle != null) {
            C4990ab.m7416i(c33743f.TAG, "handleAnimation return " + c33743f.jYD + ',' + c33743f.mWidth + ',' + c33743f.mHeight);
            View view = c33743f.jYG;
            if (view != null) {
                view.setVisibility(8);
            }
            c33743f.jYI = true;
            c33743f.aYP();
            AppMethodBeat.m2505o(15202);
            return;
        }
        c33743f.jYD = true;
        View view2 = c33743f.jYF;
        if (view2 == null) {
            C25052j.avw("animationView");
        }
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new C20109a(c33743f, c7745x));
            AppMethodBeat.m2505o(15202);
            return;
        }
        AppMethodBeat.m2505o(15202);
    }

    public void onPause() {
        AppMethodBeat.m2504i(15203);
        super.onPause();
        aYr().akV();
        long currentTimeMillis = System.currentTimeMillis();
        this.ism += currentTimeMillis - this.jWp;
        this.jWp = currentTimeMillis;
        AppMethodBeat.m2505o(15203);
    }

    public void finish() {
        AppMethodBeat.m2504i(138061);
        super.finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8373ce);
        AppMethodBeat.m2505o(138061);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(15204);
        super.onDestroy();
        C27562d c27562d = this.jWx.jVJ;
        MPVideoView aYr = aYr();
        C25052j.m39375o(aYr, "videoView");
        c27562d.jYy = aYr.getEndPlayTime();
        if (this.jWo != 0) {
            this.ism = (System.currentTimeMillis() - this.jWp) + this.ism;
            this.jWx.jVJ.jYz = (int) (this.ism / 1000);
        }
        c27562d = this.jWx.jVJ;
        aYr = aYr();
        C25052j.m39375o(aYr, "videoView");
        c27562d.jYx = (int) aYr.getRealPlayTime();
        this.jWx.jVJ.mo45367sE(2);
        C1720g.m3540Rg().mo14546b(1179, (C1202f) this);
        C1720g.m3540Rg().mo14546b(2866, (C1202f) this);
        C1720g.m3540Rg().mo14546b(2776, (C1202f) this);
        C1720g.m3540Rg().mo14546b(2759, (C1202f) this);
        C1720g.m3540Rg().mo14546b(2691, (C1202f) this);
        C1720g.m3540Rg().mo14546b(2617, (C1202f) this);
        MPVideoView aYr2 = aYr();
        Integer valueOf = aYr2 != null ? Integer.valueOf(aYr2.getCurrPosSec()) : null;
        if (valueOf == null) {
            C25052j.dWJ();
        }
        int intValue = valueOf.intValue();
        aYr = aYr();
        if (aYr != null && intValue == aYr.getDuration()) {
            intValue = 0;
        }
        C11263c.m18984e(aYD().mo60325HE() + "_" + this.jWx.fgd, (double) intValue);
        aYr().aEX();
        if (this.jWn != null) {
            C2751a c2751a = this.jWn;
            if (c2751a == null) {
                C25052j.dWJ();
            }
            c2751a.mo6826b(this.jWB);
        }
        C4879a.xxA.mo10053d(this.jWC);
        this.jWx.onDestroy();
        aYC().destroy();
        aYC().setWebChromeClient(null);
        aYC().setWebViewClient(null);
        aYC().setOnTouchListener(null);
        aYC().setOnLongClickListener(null);
        aYC().setVisibility(8);
        aYC().removeAllViews();
        aYC().clearView();
        C27559b c27559b = this.jWl;
        if (c27559b != null) {
            c27559b.jYr.disable();
            AppMethodBeat.m2505o(15204);
            return;
        }
        AppMethodBeat.m2505o(15204);
    }

    public void onBackPressed() {
        boolean z = true;
        AppMethodBeat.m2504i(15205);
        if (this.jWm) {
            aYr().mo68325j(false, 0);
            AppMethodBeat.m2505o(15205);
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
        AppMethodBeat.m2505o(15205);
    }

    /* renamed from: a */
    private void m13760a(C15334ek c15334ek) {
        int i = 0;
        AppMethodBeat.m2504i(15206);
        if (c15334ek == null) {
            AppMethodBeat.m2505o(15206);
            return;
        }
        MPVideoHeaderView aYv;
        if (c15334ek.vGj != 0) {
            MPPreviewBar mPPreviewBar = (MPPreviewBar) this.jWh.getValue();
            C25052j.m39375o(mPPreviewBar, "previewBar");
            mPPreviewBar.setVisibility(0);
        }
        if (c15334ek.vGq != null && C37436r.m63099ks(aYD().fgc)) {
            aYv = aYv();
            C46535eg c46535eg = c15334ek.vGq;
            C25052j.m39375o(c46535eg, "resp.base_appmsg_info");
            aYv.setOriginInfo(c46535eg);
        }
        C45767b c45767b = this.jWx;
        c45767b.fgc = c15334ek.vGl;
        if (c45767b.aYp()) {
            C37436r c37436r = c45767b.jVG;
            if (c37436r == null) {
                C25052j.avw("msgInfo");
            }
            C37436r c37436r2 = c45767b.jVG;
            if (c37436r2 == null) {
                C25052j.avw("msgInfo");
            }
            c37436r.fgc = c37436r2.fgc | 1;
        }
        if (c15334ek.vGp != null && this.jWx.aYp()) {
            this.jWx.jVI = c15334ek.vGp;
            aYv = aYv();
            bac bac = c15334ek.vGp;
            C25052j.m39375o(bac, "resp.malicious_title_info");
            aYv.setMaliciousInfo(bac);
        }
        this.jWx.fgd = c15334ek.fgd;
        c45767b = this.jWx;
        String str = c15334ek.vGo;
        C25052j.m39375o(str, "resp.copy_url");
        C25052j.m39376p(str, "<set-?>");
        c45767b.jVB = str;
        this.jWx.mo73551Gd(c15334ek.url);
        aYx().setTmpUrl(c15334ek.vGj);
        if (c15334ek.vGn == null || c15334ek.vGn.cCJ == 0) {
            aYI();
            if (C5046bo.m7548ek(c15334ek.vGg)) {
                AppMethodBeat.m2505o(15206);
                return;
            }
            C46538ew c46538ew = (C46538ew) c15334ek.vGg.get(0);
            aYr().setAutoPlay((c15334ek.vGk & 1) != 0);
            aYr().setInitialTime(C11263c.m18980Gg(aYD().mo60325HE() + "_" + c15334ek.fgd));
            C25052j.m39375o(c46538ew, "urlInfo");
            aYr().mo68315bL(c46538ew.url, c46538ew.vGL / 1000);
            MPVideoView aYr = aYr();
            if (c46538ew.width > c46538ew.height) {
                i = 90;
            }
            aYr.setFullScreenDirection(i);
            if (c46538ew.width > c46538ew.height) {
                aYH();
            }
            if (c46538ew.width > 0 && c46538ew.height > 0 && aYD().fjT.videoWidth <= 0 && aYD().fjT.videoHeight <= 0) {
                aYD().fjT.videoWidth = c46538ew.width;
                aYD().fjT.videoHeight = c46538ew.height;
                if (this.jWz.jYI) {
                    aYG();
                    AppMethodBeat.m2505o(15206);
                    return;
                }
                this.jWA = true;
            }
            AppMethodBeat.m2505o(15206);
            return;
        }
        C4990ab.m7416i(this.TAG, "play_error_info msg:" + c15334ek.vGn.cCK + " errCode:" + c15334ek.vGn.cCJ);
        aYs().setPlayError$505cff1c(c15334ek.vGn.cCK);
        aYJ();
        AppMethodBeat.m2505o(15206);
    }

    private final void aYI() {
        AppMethodBeat.m2504i(15207);
        MPVideoErrorView aYs = aYs();
        C25052j.m39375o(aYs, "videoErrView");
        aYs.setVisibility(8);
        mo17555fz(true);
        AppMethodBeat.m2505o(15207);
    }

    private final void aYJ() {
        AppMethodBeat.m2504i(15208);
        MPVideoErrorView aYs = aYs();
        C25052j.m39375o(aYs, "videoErrView");
        aYs.setVisibility(0);
        mo17555fz(false);
        AppMethodBeat.m2505o(15208);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        String str = null;
        AppMethodBeat.m2504i(15209);
        super.onActivityResult(i, i2, intent);
        C33744g c33744g = this.jWk;
        Context aYo;
        BizVideoDetailUI aYo2;
        C45767b c45767b;
        if (i == 1) {
            if (i2 == -1) {
                aYo = c33744g.aYo();
                aYo2 = c33744g.aYo();
                if (aYo2 != null) {
                    str = aYo2.getString(C25738R.string.g5z);
                }
                C30379h.m48462bN(aYo, str);
                c45767b = c33744g.jWx;
                if (c45767b == null) {
                    C25052j.avw("controller");
                }
                c45767b.jVC.mo61573sF(2);
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
                    C11262a c11262a = C11262a.jYp;
                    C37436r c37436r = c33744g.jVG;
                    if (c37436r == null) {
                        C25052j.avw("msgInfo");
                    }
                    C45767b c45767b2 = c33744g.jWx;
                    if (c45767b2 == null) {
                        C25052j.avw("controller");
                    }
                    if (C11262a.m18978a(stringExtra2, c37436r, stringExtra, c45767b2)) {
                        aYo = c33744g.aYo();
                        aYo2 = c33744g.aYo();
                        if (aYo2 != null) {
                            str = aYo2.getString(C25738R.string.g5z);
                        }
                        C30379h.m48462bN(aYo, str);
                        c45767b = c33744g.jWx;
                        if (c45767b == null) {
                            C25052j.avw("controller");
                        }
                        c45767b.jVC.mo61573sF(1);
                    }
                }
            }
            i3 = 0;
        }
        if (i3 != 0) {
            AppMethodBeat.m2505o(15209);
        } else {
            AppMethodBeat.m2505o(15209);
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(15210);
        this.jWx.aYn();
        if (c1207m == null || c1207m.acN() == null) {
            AppMethodBeat.m2505o(15210);
            return;
        }
        C4990ab.m7416i(this.TAG, "onSceneEnd errType " + i + ", errCode " + i2 + ", errMsg " + str + ", type: " + c1207m.getType());
        C1929q acN = c1207m.acN();
        C44941v c44941v;
        if (acN == null) {
            c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.m2505o(15210);
            throw c44941v;
        }
        C1331a acz = ((C7472b) acN).acz();
        if (((acz instanceof C7535ej) && ((C7535ej) acz).vFP != this.jWx.jVF) || (((acz instanceof C15333ed) && ((C15333ed) acz).vFP != this.jWx.jVF) || (((acz instanceof C40516eh) && ((C40516eh) acz).vFP != this.jWx.jVF) || (((acz instanceof C35914en) && ((C35914en) acz).vFP != this.jWx.jVF) || ((acz instanceof C46537ep) && ((C46537ep) acz).vFP != this.jWx.jVF))))) {
            AppMethodBeat.m2505o(15210);
        } else if ((c1207m.getType() != 2691 && c1207m.getType() != 2617) || i2 == 0 || C5046bo.isNullOrNil(str)) {
            acN = c1207m.acN();
            C25052j.m39375o(acN, "scene.reqResp");
            C1331a acA;
            String str2;
            LinkedList linkedList;
            int size;
            String str3;
            int length;
            if (acN.getType() == 1179) {
                C33743f c33743f = this.jWz;
                c33743f.jYH = true;
                c33743f.aYP();
                if (i == 0 && i2 == 0) {
                    aYI();
                    acN = c1207m.acN();
                    if (acN == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                        AppMethodBeat.m2505o(15210);
                        throw c44941v;
                    }
                    acA = ((C7472b) acN).acA();
                    if (acA == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetResp");
                        AppMethodBeat.m2505o(15210);
                        throw c44941v;
                    }
                    C15334ek c15334ek = (C15334ek) acA;
                    str2 = this.TAG;
                    StringBuilder stringBuilder = new StringBuilder("url_info size is ");
                    if (c15334ek.vGg != null) {
                        linkedList = c15334ek.vGg;
                        if (linkedList == null) {
                            C25052j.dWJ();
                        }
                        size = linkedList.size();
                    } else {
                        size = 0;
                    }
                    C4990ab.m7416i(str2, stringBuilder.append(size).toString());
                    String str4;
                    if (c15334ek.vGh == 0 || C5046bo.isNullOrNil(c15334ek.vGi)) {
                        m13760a(c15334ek);
                        C40514dw c40514dw = c15334ek.vGm;
                        if ((c40514dw != null && c40514dw.enabled == 1) || (this.jVT && (C5058f.IS_FLAVOR_RED || C5058f.DEBUG))) {
                            C25052j.m39375o(c40514dw, "appMsgAdvert");
                            str3 = "https://mp.weixin.qq.com/s?__biz=MjM5NDE1ODg2MQ==&mid=2663410252&idx=1&sn=2d23c198e56a8de51135dd6fff2a3424&chksm=bdb8ca2e8acf4338c6185291f34f8ad945e7b21ddc58b917f1421e2275830366fe83b405ba33&scene=90&xtrack=1&render_type=ad&ascene=1&devicetype=android-26&version=27000400&nettype=WIFI&abtest_cookie=BAABAAoACwASABMABQAjlx4AVpkeAMWZHgDVmR4A3JkeAAAA&lang=zh_CN&pass_ticket=HuAnleAdesPJYvj8VdGnM5iy840UzEsUCPB4f9wpHi2EEZwaCr%2BDkfL1p50iY8au&wx_header=1&mock=-1#test";
                            if (!this.jVT) {
                                str3 = c40514dw.url;
                                C25052j.m39375o(str3, "appMsgAdvert.url");
                            }
                            str2 = "";
                            if (C31820v.m51514a((CharSequence) str3, '#', 0, 6) != -1) {
                                str4 = "#" + C31820v.m51543jf(str3, "#");
                                length = str3.length() - str4.length();
                                if (str3 == null) {
                                    c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                                    AppMethodBeat.m2505o(15210);
                                    throw c44941v;
                                }
                                str3 = str3.substring(0, length);
                                C25052j.m39375o(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            } else {
                                str4 = str2;
                            }
                            str4 = str3 + "&adWidth=" + ((int) (((float) aYC().getMeasuredWidth()) / this.density)) + str4;
                            C4990ab.m7416i(this.TAG, "load ad url:".concat(String.valueOf(str4)));
                            aYC().loadUrl(str4);
                            MPVideoMRecyclerView aYy = aYy();
                            C25052j.m39375o(aYy, "commentListView");
                            aYy.getViewTreeObserver().addOnScrollChangedListener(new C7740v(this));
                            AppMethodBeat.m2505o(15210);
                            return;
                        }
                    }
                    C4990ab.m7417i(this.TAG, "onSceneEnd redirect %s", c15334ek.vGi);
                    AppCompatActivity dxU = dxU();
                    C25052j.m39375o(dxU, "context");
                    Context context = dxU;
                    C37436r aYD = aYD();
                    str4 = c15334ek.vGi;
                    C25052j.m39375o(str4, "resp.redirect_url");
                    C11263c.m18983a(context, aYD, str4);
                    C5004al.m7442n(new C7751w(this), 500);
                    AppMethodBeat.m2505o(15210);
                    return;
                }
                m13760a(null);
                aYJ();
                MPVideoErrorView aYs = aYs();
                aYs.jXq.setBackgroundResource(C25738R.drawable.axu);
                if (C5046bo.isNullOrNil(str)) {
                    aYs.jXp.setText(aYs.getContext().getString(C25738R.string.g83));
                } else {
                    aYs.jXp.setText(aYs.getContext().getString(C25738R.string.g83) + ' ' + str);
                }
                aYs.jWH.setClickable(true);
                AppMethodBeat.m2505o(15210);
                return;
            }
            acN = c1207m.acN();
            C25052j.m39375o(acN, "scene.reqResp");
            C1929q acN2;
            String str5;
            C2736a c2736a;
            Context context2;
            C20095a c20095a;
            if (acN.getType() == 2866) {
                acN = c1207m.acN();
                if (acN == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                acA = ((C7472b) acN).acz();
                if (acA == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgCommentListReq");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                C15333ed c15333ed = (C15333ed) acA;
                acN2 = c1207m.acN();
                if (acN2 == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                acz = ((C7472b) acN2).acA();
                if (acz == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgCommentListResp");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                C30180ee c30180ee = (C30180ee) acz;
                str5 = this.TAG;
                StringBuilder stringBuilder2 = new StringBuilder("url_info size is ");
                if (c30180ee.vFR != null) {
                    LinkedList linkedList2 = c30180ee.vFR;
                    if (linkedList2 == null) {
                        C25052j.dWJ();
                    }
                    length = linkedList2.size();
                } else {
                    length = 0;
                }
                C4990ab.m7416i(str5, stringBuilder2.append(length).toString());
                LinkedList linkedList3;
                List list;
                if (c15333ed.kdC == 1) {
                    this.jWx.jVx = c30180ee.kKI;
                    MPVideoCommentView aYx = aYx();
                    C25052j.m39376p(c30180ee, "resp");
                    if (!C5046bo.m7548ek(c30180ee.vFR)) {
                        c2736a = aYx.jWM;
                        if (c2736a != null) {
                            linkedList3 = c30180ee.vFR;
                            C25052j.m39375o(linkedList3, "resp.comment");
                            list = linkedList3;
                            C25052j.m39376p(list, "items");
                            C4990ab.m7416i(C2736a.TAG, "update: " + list.size());
                            c2736a.eow.addAll(list);
                            c2736a.notifyDataSetChanged();
                        }
                    }
                    aYx.erD = c30180ee.enabled;
                    aYx.jWO = c30180ee.vFT;
                    aYx.jWP = c30180ee.vFS;
                    Object obj = null;
                    if (aYx.jWM != null) {
                        C2736a c2736a2 = aYx.jWM;
                        Integer valueOf = c2736a2 != null ? Integer.valueOf(c2736a2.getItemCount()) : null;
                        if (valueOf == null) {
                            C25052j.dWJ();
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
                        str2 = aYx.getContext().getString(C25738R.string.g62);
                        Context context3 = aYx.getContext();
                        C25052j.m39375o(context3, "context");
                        Drawable drawable = context3.getResources().getDrawable(C25738R.drawable.axn);
                        size = (int) (((double) aYx.jWK.getTextSize()) * 1.2d);
                        drawable.setBounds(0, 0, size, size);
                        new SpannableString("@").setSpan(new C5664a(drawable), 0, 1, 33);
                        aYx.jWK.setText(TextUtils.concat(new CharSequence[]{r1, " ", str2}));
                        AppMethodBeat.m2505o(15210);
                        return;
                    }
                    aYx.jWK.setText(aYx.getContext().getString(C25738R.string.g84));
                    AppMethodBeat.m2505o(15210);
                    return;
                }
                Object obj2;
                int i3 = this.jWx.jVy;
                this.jWx.jVy = c30180ee.kKI;
                MPVideoWriteCommentLayout aYz = aYz();
                if (i3 == 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                C25052j.m39376p(c30180ee, "resp");
                if (!aYz.jYf) {
                    if (C5046bo.m7548ek(c30180ee.vFR)) {
                        aYz.aYM();
                        AppMethodBeat.m2505o(15210);
                        return;
                    }
                    View view = aYz.jYa;
                    context2 = aYz.getContext();
                    C25052j.m39375o(context2, "context");
                    view.setBackgroundColor(context2.getResources().getColor(C25738R.color.f11776gy));
                    aYz.jYb.setVisibility(0);
                    if (aYz.jYd == null) {
                        Context context4 = aYz.getContext();
                        C25052j.m39375o(context4, "context");
                        linkedList = c30180ee.vFR;
                        C25052j.m39375o(linkedList, "resp.comment");
                        C45767b c45767b = aYz.jWx;
                        if (c45767b == null) {
                            C25052j.avw("controller");
                        }
                        aYz.jYd = new C20095a(context4, linkedList, c45767b);
                        aYz.jXZ.setAdapter(aYz.jYd);
                        AppMethodBeat.m2505o(15210);
                        return;
                    }
                    c20095a = aYz.jYd;
                    if (c20095a != null) {
                        linkedList3 = c30180ee.vFR;
                        C25052j.m39375o(linkedList3, "resp.comment");
                        list = linkedList3;
                        C25052j.m39376p(list, "items");
                        C4990ab.m7416i(C20095a.TAG, "update: " + list.size());
                        if (obj2 != null) {
                            c20095a.eow.clear();
                            c20095a.eow.addAll(list);
                        } else {
                            c20095a.eow.addAll(list);
                        }
                        c20095a.notifyDataSetChanged();
                        AppMethodBeat.m2505o(15210);
                        return;
                    }
                }
                AppMethodBeat.m2505o(15210);
                return;
            }
            acN = c1207m.acN();
            C25052j.m39375o(acN, "scene.reqResp");
            C35931jz c35931jz;
            if (acN.getType() == 2776) {
                if (i == 0 && i2 == 0) {
                    acN = c1207m.acN();
                    if (acN == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                        AppMethodBeat.m2505o(15210);
                        throw c44941v;
                    }
                    acA = ((C7472b) acN).acA();
                    if (acA == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgGetExtResp");
                        AppMethodBeat.m2505o(15210);
                        throw c44941v;
                    }
                    C46536ei c46536ei = (C46536ei) acA;
                    if (c46536ei.vGd != null) {
                        MPVideoHeaderView aYv = aYv();
                        c35931jz = c46536ei.vGd;
                        C25052j.m39375o(c35931jz, "resp.appmsgstat");
                        aYv.mo6811a(c35931jz);
                        C33744g c33744g = this.jWk;
                        c35931jz = c46536ei.vGd;
                        C25052j.m39375o(c35931jz, "resp.appmsgstat");
                        C25052j.m39376p(c35931jz, "appMsgStat");
                        c33744g.jXv = c35931jz;
                        this.jWx.jVA = c46536ei.vGd.jVA;
                    }
                }
                AppMethodBeat.m2505o(15210);
                return;
            }
            acN = c1207m.acN();
            C25052j.m39375o(acN, "scene.reqResp");
            if (acN.getType() == 2691) {
                acN = c1207m.acN();
                if (acN == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                acA = ((C7472b) acN).acz();
                if (acA == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgLikeReq");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                C35914en c35914en = (C35914en) acA;
                acN2 = c1207m.acN();
                if (acN2 == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                acz = ((C7472b) acN2).acA();
                if (acz == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgLikeResp");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                C35915eo c35915eo = (C35915eo) acz;
                if (i == 0 && i2 == 0) {
                    if (c35914en.kdC != 4) {
                        MPVideoHeaderView aYv2 = aYv();
                        c35931jz = aYv2.jXv;
                        if (c35931jz == null) {
                            C25052j.avw("appMsgStat");
                        }
                        if (c35931jz != null) {
                            c35931jz = aYv2.jXv;
                            if (c35931jz == null) {
                                C25052j.avw("appMsgStat");
                            }
                            if (c35931jz.vMP == 1) {
                                c35931jz = aYv2.jXv;
                                if (c35931jz == null) {
                                    C25052j.avw("appMsgStat");
                                }
                                c35931jz.vMP = 0;
                                c35931jz = aYv2.jXv;
                                if (c35931jz == null) {
                                    C25052j.avw("appMsgStat");
                                }
                                c35931jz.vMO--;
                                aYv2.jXG.setVisibility(8);
                            } else {
                                c35931jz = aYv2.jXv;
                                if (c35931jz == null) {
                                    C25052j.avw("appMsgStat");
                                }
                                c35931jz.vMP = 1;
                                c35931jz = aYv2.jXv;
                                if (c35931jz == null) {
                                    C25052j.avw("appMsgStat");
                                }
                                c35931jz.vMO++;
                                if (aYv2.jXu) {
                                    aYv2.jXG.setVisibility(0);
                                    aYv2.jXu = false;
                                    length = (int) aYv2.jXH.getTextSize();
                                    LayoutParams layoutParams = aYv2.jXI.getLayoutParams();
                                    if (layoutParams == null) {
                                        c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                                        AppMethodBeat.m2505o(15210);
                                        throw c44941v;
                                    }
                                    layoutParams.height = (int) (((double) length) * 1.2d);
                                    layoutParams.width = (int) (((double) length) * 1.2d);
                                    aYv2.jXI.setLayoutParams(layoutParams);
                                    str5 = aYv2.getContext().getString(C25738R.string.g61);
                                    context2 = aYv2.getContext();
                                    C25052j.m39375o(context2, "context");
                                    Drawable drawable2 = context2.getResources().getDrawable(C25738R.drawable.axm);
                                    drawable2.setBounds(0, 0, length / 2, length);
                                    new SpannableString("@").setSpan(new C5664a(drawable2), 0, 1, 33);
                                    aYv2.jXH.setText(TextUtils.concat(new CharSequence[]{str5, "  ", r4}));
                                    aYv2.jXH.setOnClickListener(new C2744e(aYv2));
                                    C5018as eg = C5018as.m7465eg("key_webview_menu_haokan", 2);
                                    if (eg == null) {
                                        C25052j.dWJ();
                                    }
                                    if (eg.decodeBool("show_first_tips", true)) {
                                        MPVideoWowEduView mPVideoWowEduView = aYv2.jXK;
                                        if (mPVideoWowEduView == null) {
                                            C25052j.avw("wowEduLayout");
                                        }
                                        if (mPVideoWowEduView != null) {
                                            C45767b c45767b2 = aYv2.jWx;
                                            if (c45767b2 == null) {
                                                C25052j.avw("controller");
                                            }
                                            if (c45767b2.jVA != 1) {
                                                eg.encode("show_first_tips", false);
                                                eg.apply();
                                                MPVideoWowEduView mPVideoWowEduView2 = aYv2.jXK;
                                                if (mPVideoWowEduView2 == null) {
                                                    C25052j.avw("wowEduLayout");
                                                }
                                                mPVideoWowEduView2.setPosition(aYv2.jXJ.getY() + ((float) aYv2.jXJ.getHeight()));
                                            }
                                        }
                                    }
                                }
                            }
                            c35931jz = aYv2.jXv;
                            if (c35931jz == null) {
                                C25052j.avw("appMsgStat");
                            }
                            C35931jz c35931jz2 = aYv2.jXv;
                            if (c35931jz2 == null) {
                                C25052j.avw("appMsgStat");
                            }
                            c35931jz.vMO = Math.max(0, c35931jz2.vMO);
                            c35931jz = aYv2.jXv;
                            if (c35931jz == null) {
                                C25052j.avw("appMsgStat");
                            }
                            aYv2.mo6811a(c35931jz);
                        }
                    } else {
                        aYz().aYN();
                    }
                    if (c35914en.kdC == 1 || c35914en.kdC == 5) {
                        this.jWx.jVC.mo61573sF(9);
                    }
                    if (c35914en.kdC != 2) {
                        C30379h.m48462bN(dxU(), getString(C25738R.string.f9223ti));
                        AppMethodBeat.m2505o(15210);
                        return;
                    } else if (c35915eo.vGw == 1) {
                        C30379h.m48443a((Context) dxU(), dxU().getString(C25738R.string.g81), "", dxU().getString(C25738R.string.f9187s6), null);
                        AppMethodBeat.m2505o(15210);
                        return;
                    } else {
                        C30379h.m48462bN(dxU(), getString(C25738R.string.g80));
                        AppMethodBeat.m2505o(15210);
                        return;
                    }
                }
                C30379h.m48462bN(dxU(), getString(C25738R.string.g5x, new Object[]{Integer.valueOf(i2)}));
                AppMethodBeat.m2505o(15210);
                return;
            }
            acN = c1207m.acN();
            C25052j.m39375o(acN, "scene.reqResp");
            if (acN.getType() == 2617) {
                acN = c1207m.acN();
                if (acN == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                acA = ((C7472b) acN).acz();
                if (acA == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AppMsgOperateCommentReq");
                    AppMethodBeat.m2505o(15210);
                    throw c44941v;
                }
                C46537ep c46537ep = (C46537ep) acA;
                if (i == 0 && i2 == 0) {
                    if (c46537ep.kdC == 1) {
                        C30379h.m48462bN(dxU(), getString(C25738R.string.g65));
                        aYz().aYN();
                        AppMethodBeat.m2505o(15210);
                        return;
                    }
                    C30379h.m48462bN(dxU(), getString(C25738R.string.g5r));
                    MPVideoWriteCommentLayout aYz2 = aYz();
                    C25052j.m39376p(c46537ep, "req");
                    C20095a c20095a2 = aYz2.jYd;
                    str3 = c20095a2 != null ? c20095a2.mo35331b(c46537ep) : null;
                    c20095a = aYz2.jYd;
                    if (c20095a != null && c20095a.getCount() == 0) {
                        aYz2.aYM();
                    }
                    MPVideoCommentView aYx2 = aYx();
                    C25052j.m39376p(c46537ep, "req");
                    c2736a = aYx2.jWM;
                    if (c2736a != null) {
                        c2736a.mo6805a(c46537ep, str3);
                        AppMethodBeat.m2505o(15210);
                        return;
                    }
                    AppMethodBeat.m2505o(15210);
                    return;
                } else if (c46537ep.kdC == 1) {
                    C30379h.m48462bN(dxU(), getString(C25738R.string.g63, new Object[]{Integer.valueOf(i2)}));
                    AppMethodBeat.m2505o(15210);
                    return;
                } else {
                    C30379h.m48462bN(dxU(), getString(C25738R.string.g5q, new Object[]{Integer.valueOf(i2)}));
                    AppMethodBeat.m2505o(15210);
                    return;
                }
            }
            AppMethodBeat.m2505o(15210);
        } else {
            C30379h.m48443a((Context) dxU(), str, "", dxU().getString(C25738R.string.f9187s6), null);
            AppMethodBeat.m2505o(15210);
        }
    }

    /* renamed from: e */
    public static final /* synthetic */ C2751a m13764e(BizVideoDetailUI bizVideoDetailUI) {
        C2751a c2751a;
        AppMethodBeat.m2504i(15215);
        C44941v c44941v;
        if (bizVideoDetailUI.jWn != null) {
            c2751a = bizVideoDetailUI.jWn;
            if (c2751a == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPFullscreenImpl");
                AppMethodBeat.m2505o(15215);
                throw c44941v;
            }
            AppMethodBeat.m2505o(15215);
        } else {
            bizVideoDetailUI.jWn = new C2751a(bizVideoDetailUI.dxU());
            c2751a = bizVideoDetailUI.jWn;
            if (c2751a == null) {
                C25052j.dWJ();
            }
            c2751a.mo6824a(bizVideoDetailUI.jWB);
            c2751a = bizVideoDetailUI.jWn;
            if (c2751a == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPFullscreenImpl");
                AppMethodBeat.m2505o(15215);
                throw c44941v;
            }
            AppMethodBeat.m2505o(15215);
        }
        return c2751a;
    }

    /* renamed from: j */
    public static final /* synthetic */ void m13769j(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.m2504i(15219);
        MPVideoMRecyclerView aYy = bizVideoDetailUI.aYy();
        C25052j.m39375o(aYy, "commentListView");
        float height = ((float) aYy.getHeight()) / bizVideoDetailUI.density;
        FrameLayout aYw = bizVideoDetailUI.aYw();
        C25052j.m39375o(aYw, "adView");
        float top = ((float) (aYw.getTop() - bizVideoDetailUI.aYy().computeVerticalScrollOffset())) / bizVideoDetailUI.density;
        C42831a c42831a = C42831a.jVq;
        C42831a.m75979a(bizVideoDetailUI.aYC(), (int) height, (int) top);
        C4990ab.m7418v(bizVideoDetailUI.TAG, "scroll:" + height + ", " + top + ", " + bizVideoDetailUI.density);
        AppMethodBeat.m2505o(15219);
    }

    /* renamed from: l */
    public static final /* synthetic */ String m13771l(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.m2504i(15221);
        String str = (String) bizVideoDetailUI.jWt.getValue();
        AppMethodBeat.m2505o(15221);
        return str;
    }

    /* renamed from: n */
    public static final /* synthetic */ int m13773n(BizVideoDetailUI bizVideoDetailUI) {
        AppMethodBeat.m2504i(15223);
        int intValue = ((Number) bizVideoDetailUI.jWu.getValue()).intValue();
        AppMethodBeat.m2505o(15223);
        return intValue;
    }
}
