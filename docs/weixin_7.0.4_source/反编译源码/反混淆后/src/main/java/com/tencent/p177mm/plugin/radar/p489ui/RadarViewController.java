package com.tencent.p177mm.plugin.radar.p489ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.radar.p488b.C39550e;
import com.tencent.p177mm.plugin.radar.p488b.C39550e.C21557a;
import com.tencent.p177mm.plugin.radar.p488b.C39550e.C21559c;
import com.tencent.p177mm.plugin.radar.p488b.C39550e.C34765d;
import com.tencent.p177mm.plugin.radar.p488b.C39550e.C39549e;
import com.tencent.p177mm.plugin.radar.p488b.C43413c;
import com.tencent.p177mm.plugin.radar.p488b.C43413c.C21556e;
import com.tencent.p177mm.plugin.radar.p488b.C43413c.C34764m;
import com.tencent.p177mm.plugin.radar.p488b.C43413c.C39547a;
import com.tencent.p177mm.plugin.radar.p488b.C43413c.C39548c;
import com.tencent.p177mm.plugin.radar.p488b.C43416d;
import com.tencent.p177mm.plugin.radar.p489ui.C46915b.C34778a;
import com.tencent.p177mm.plugin.radar.p489ui.RadarMemberView.C3675b;
import com.tencent.p177mm.plugin.radar.p489ui.RadarSpecialGridView.C21561a;
import com.tencent.p177mm.plugin.radar.p489ui.RadarStateView.C12935a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.boy;
import com.tencent.p177mm.protocal.protobuf.boz;
import com.tencent.p177mm.protocal.protobuf.bpb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p005f.p007b.C8001y;
import p000a.p010i.C31815k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b\u0001\u0001\u0001\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ0\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020KH\u0002J\u0006\u0010P\u001a\u00020QJ\u0018\u0010R\u001a\u00020\u00122\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010TH\u0002J4\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u00122\b\u0010X\u001a\u0004\u0018\u00010K2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020Q2\b\u0010\\\u001a\u0004\u0018\u00010]J\u0006\u0010^\u001a\u00020QJ\u0018\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020bH\u0016J\u001a\u0010c\u001a\u00020Q2\u0006\u0010d\u001a\u00020\u00122\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\u0006\u0010g\u001a\u00020QJ0\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010T2\u0006\u0010l\u001a\u00020\nH\u0016J0\u0010m\u001a\u00020Q2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010T2\u0006\u0010l\u001a\u00020\nH\u0016J\u0010\u0010p\u001a\u00020Q2\u0006\u0010q\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020Q2\u0006\u0010q\u001a\u00020rH\u0016J\u0006\u0010t\u001a\u00020QJ,\u0010u\u001a\u00020Q2\u0006\u0010V\u001a\u00020\u00122\b\u0010X\u001a\u0004\u0018\u00010K2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010v\u001a\u00020QH\u0002J\u0018\u0010w\u001a\u00020Q2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010TH\u0002J\b\u0010x\u001a\u00020QH\u0002J\u0006\u0010y\u001a\u00020QJ\u0006\u0010z\u001a\u00020QJ\u0006\u0010{\u001a\u00020QJ\u0006\u0010|\u001a\u00020QJ\u001a\u0010}\u001a\u00020Q2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010~\u001a\u00020H\u0002J\u0012\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u000208H\u0002J\t\u0010\u0001\u001a\u00020QH\u0002R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0018\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u000206X.¢\u0006\u0002\n\u0000R$\u00109\u001a\u0002082\u0006\u00107\u001a\u000208@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u00020?8BX\u0002¢\u0006\f\n\u0004\bB\u0010\u0018\u001a\u0004\b@\u0010AR\u001b\u0010C\u001a\u00020D8BX\u0002¢\u0006\f\n\u0004\bG\u0010\u0018\u001a\u0004\bE\u0010F¨\u0006\u0001"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "setRadarStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;)V", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController */
public final class RadarViewController extends RelativeLayout implements C39548c, C34765d {
    private static final String TAG = TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarViewController.class), "waveView", "getWaveView()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarViewController.class), "memberDetailView", "getMemberDetailView()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarViewController.class), "grid", "getGrid()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarViewController.class), "radarTips", "getRadarTips()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarViewController.class), "newRadarTip", "getNewRadarTip()Landroid/widget/TextView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarViewController.class), "newRadarTipLoading", "getNewRadarTipLoading()Landroid/widget/ProgressBar;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarViewController.class), "quitBtn", "getQuitBtn()Landroid/widget/Button;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarViewController.class), "radarBgMask", "getRadarBgMask()Landroid/view/View;"))};
    public static final C34775b pEc = new C34775b();
    private boolean nPX;
    private final C44856f pDL = C17344i.m26854g(new C36802i(this));
    private final C44856f pDM = C46153i.m86149aa(this, 2131826780);
    private final C44856f pDN = C46153i.m86149aa(this, 2131826810);
    private final C44856f pDO = C46153i.m86149aa(this, 2131826812);
    private final C44856f pDP = C46153i.m86149aa(this, 2131826808);
    private final C44856f pDQ = C46153i.m86149aa(this, 2131826807);
    private final C44856f pDR = C46153i.m86149aa(this, 2131826811);
    private final C44856f pDS = C46153i.m86149aa(this, 2131826802);
    C39550e pDT;
    C43413c pDU;
    C12939c pDV;
    private C39549e pDW = C39549e.SEARCHING;
    private final boolean pDX;
    final OnClickListener pDY = new C12942f(this);
    private final int pDZ = 33554432;
    private final int pEa = (this.pDZ + 1);
    private final int pEb = (this.pDZ + 2);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$e */
    public static final class C7035e implements C3675b {
        final /* synthetic */ RadarViewController pEg;

        C7035e(RadarViewController radarViewController) {
            this.pEg = radarViewController;
        }

        /* renamed from: a */
        public final void mo8283a(bpb bpb, C21556e c21556e) {
            AppMethodBeat.m2504i(103095);
            C25052j.m39376p(bpb, "member");
            C39561g c39561g = C39561g.pDK;
            String b = C39561g.m67618b(bpb);
            if (c21556e == null) {
                AppMethodBeat.m2505o(103095);
                return;
            }
            switch (C39562h.eQZ[c21556e.ordinal()]) {
                case 1:
                    RadarViewController.m61130c(this.pEg).pBy.put(Long.valueOf(this.pEg.pDU.mo68962Vw(b)), new C21559c(bpb, c21556e));
                    RadarViewController.m61125a(this.pEg, b, C21556e.Verifying);
                    AppMethodBeat.m2505o(103095);
                    return;
                case 2:
                    int i;
                    Object obj;
                    String username;
                    int i2;
                    long j;
                    C43413c e = this.pEg.pDU;
                    C25052j.m39376p(b, "username");
                    C1694a K = C1720g.m3528K(C6982j.class);
                    C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                    C7616ad aoO = ((C6982j) K).mo15369XM().aoO(b);
                    C25052j.m39375o(aoO, "contact");
                    CharSequence username2 = aoO.getUsername();
                    if (username2 == null || C6163u.m9837ar(username2)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        obj = b;
                    } else {
                        username = aoO.getUsername();
                        C25052j.m39375o(username, "contact.username");
                        String obj2 = username;
                    }
                    username = (String) e.pAN.get(obj2);
                    CharSequence charSequence = username;
                    if (charSequence == null || C6163u.m9837ar(charSequence)) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        C4990ab.m7413e(C43413c.TAG, "Verify Contact username(%s) error, verifyTicket is null", obj2);
                        e.mo68962Vw(obj2);
                        j = -1;
                    } else {
                        C5138d apF = C5138d.apF(username);
                        long currentTimeMillis = System.currentTimeMillis();
                        C39547a c39547a = new C39547a(new C34764m(e, username, currentTimeMillis));
                        String duc = apF.duc();
                        C25052j.m39375o(duc, "verify.verifyTicket");
                        C25052j.m39376p(duc, "verifyTicket");
                        String str = "username is null";
                        boolean z = obj2 != null && obj2.length() > 0;
                        Assert.assertTrue(str, z);
                        c39547a.onStart();
                        C1720g.m3540Rg().mo14552d((C1207m) new C46498m(obj2, duc, 48, (byte) 0));
                        j = currentTimeMillis;
                    }
                    RadarViewController.m61130c(this.pEg).pBy.put(Long.valueOf(j), new C21559c(bpb, c21556e));
                    RadarViewController.m61125a(this.pEg, b, C21556e.Verifying);
                    break;
            }
            AppMethodBeat.m2505o(103095);
        }

        /* renamed from: b */
        public final void mo8284b(bpb bpb, C21556e c21556e) {
            Object b;
            AppMethodBeat.m2504i(103096);
            if (bpb != null) {
                C39561g c39561g = C39561g.pDK;
                b = C39561g.m67618b(bpb);
            } else {
                b = null;
            }
            View view = (View) RadarViewController.m61131d(this.pEg).pEn.get(b);
            if (view != null) {
                Object tag = view.getTag();
                if (tag == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                    AppMethodBeat.m2505o(103096);
                    throw c44941v;
                }
                C12940a c12940a = (C12940a) tag;
                if (c21556e != C21556e.Stranger) {
                    c12940a.pEr.cdL();
                }
            }
            RadarViewController.m61134f(this.pEg).cdU();
            AppMethodBeat.m2505o(103096);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001DB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001dJ\u0006\u00101\u001a\u00020/J\u0006\u00102\u001a\u00020/J\b\u00103\u001a\u00020/H\u0002J\u0010\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\bH\u0016J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00105\u001a\u00020\bH\u0016J\u001a\u00108\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010+2\u0006\u00105\u001a\u00020\bH\u0016J\u0010\u0010:\u001a\u00020\u00102\b\u0010;\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010<\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010+2\u0006\u00105\u001a\u00020\bH\u0002J\"\u0010=\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010+2\u0006\u00105\u001a\u00020\b2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010A\u001a\u00020/2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010$R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R4\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010$2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010$8F@FX\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020+0\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017¨\u0006E"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$c */
    public final class C12939c extends C43417a {
        private final Context context;
        final /* synthetic */ RadarViewController pEg;
        bpb[] pEi = new bpb[12];
        HashMap<String, String> pEj = new HashMap();
        HashMap<String, Integer> pEk = new HashMap();
        private final C34774a pEl;
        private int pEm;
        HashMap<String, View> pEn = new HashMap();
        private boolean pEo;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$c$a */
        public final class C12940a {
            TextView pEp;
            ImageView pEq;
            RadarStateView pEr;
            RadarStateChooseView pEs;
            ImageView pEt;
            final /* synthetic */ C12939c pEu;

            public C12940a(C12939c c12939c, TextView textView, ImageView imageView, RadarStateView radarStateView, RadarStateChooseView radarStateChooseView, ImageView imageView2) {
                C25052j.m39376p(textView, "tvMemberName");
                C25052j.m39376p(imageView, "ivMemberAvatar");
                C25052j.m39376p(radarStateView, "vMemberState");
                C25052j.m39376p(radarStateChooseView, "vMemberChooseState");
                C25052j.m39376p(imageView2, "ivMemberAvatarMask");
                this.pEu = c12939c;
                AppMethodBeat.m2504i(103086);
                this.pEp = textView;
                this.pEq = imageView;
                this.pEr = radarStateView;
                this.pEs = radarStateChooseView;
                this.pEt = imageView2;
                AppMethodBeat.m2505o(103086);
            }
        }

        public C12939c(RadarViewController radarViewController, RadarSpecialGridView radarSpecialGridView, Context context) {
            C25052j.m39376p(radarSpecialGridView, "radarGridView");
            C25052j.m39376p(context, "context");
            this.pEg = radarViewController;
            super(radarSpecialGridView, context);
            AppMethodBeat.m2504i(103092);
            this.context = context;
            this.pEl = new C34774a();
            AppMethodBeat.m2505o(103092);
        }

        public final int getCount() {
            if (this.pEo) {
                return 0;
            }
            return this.pEi.length;
        }

        /* JADX WARNING: Removed duplicated region for block: B:64:0x0077 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00a2 A:{SYNTHETIC} */
        /* JADX WARNING: Missing block: B:38:0x009d, code skipped:
            if (r1 != 0) goto L_0x009f;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: al */
        public final void mo24971al(LinkedList<bpb> linkedList) {
            AppMethodBeat.m2504i(103087);
            if ((linkedList == null || linkedList.size() != 0) && linkedList != null) {
                int i;
                for (bpb c : this.pEi) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        bpb bpb = (bpb) it.next();
                        C39561g c39561g = C39561g.pDK;
                        String c2 = C39561g.m67619c(bpb);
                        C39561g c39561g2 = C39561g.pDK;
                        if (C25052j.m39373j(c2, C39561g.m67619c(c))) {
                            linkedList.remove(bpb);
                            break;
                        }
                    }
                }
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    bpb bpb2 = (bpb) it2.next();
                    int abs = Math.abs(((int) System.currentTimeMillis()) % 6);
                    int length = this.pEi.length;
                    for (i = 0; i < length; i++) {
                        int i2 = (i + abs) % 12;
                        if (!(i2 == 4 || i2 == 7)) {
                            int i3;
                            bpb bpb3 = this.pEi[i2];
                            if (bpb3 != null) {
                                CharSequence charSequence = bpb3.jBB;
                                if (charSequence == null || C6163u.m9837ar(charSequence)) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                if (i3 != 0) {
                                    charSequence = bpb3.wfK;
                                    if (charSequence == null || C6163u.m9837ar(charSequence)) {
                                        i3 = 1;
                                    } else {
                                        i3 = 0;
                                    }
                                }
                                i3 = 0;
                                if (i3 == 0) {
                                    this.pEi[i2] = bpb2;
                                    HashMap hashMap = this.pEk;
                                    C39561g c39561g3 = C39561g.pDK;
                                    C25052j.m39375o(bpb2, "member");
                                    hashMap.put(C39561g.m67618b(bpb2), Integer.valueOf(0));
                                    break;
                                }
                            }
                            i3 = 1;
                            if (i3 == 0) {
                            }
                        }
                    }
                }
                if (linkedList.size() > 0) {
                    aPw();
                    C43416d c43416d = C43416d.pBq;
                    int size = linkedList.size();
                    if (C43416d.cEX == 0 && size > 0) {
                        float cdz = (((float) (C43416d.cdz() - C43416d.pBm)) * 1.0f) / 1000.0f;
                        C4990ab.m7411d(C43416d.TAG, "FoundFirstFriendTimeSpent %s", Float.valueOf(cdz));
                        C7060h c7060h = C7060h.pYm;
                        C8001y c8001y = C8001y.AVH;
                        String format = String.format("%s", Arrays.copyOf(new Object[]{Float.valueOf(cdz)}, 1));
                        C25052j.m39375o(format, "java.lang.String.format(format, *args)");
                        c7060h.mo8374X(10682, format);
                    }
                    C43416d.cEX += size;
                    C43416d.pBn = size + C43416d.pBn;
                }
                AppMethodBeat.m2505o(103087);
                return;
            }
            AppMethodBeat.m2505o(103087);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
        /* JADX WARNING: Missing block: B:103:0x0372, code skipped:
            if (r1 == null) goto L_0x0374;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: Y */
        public final View mo24970Y(View view, int i) {
            View view2;
            AppMethodBeat.m2504i(103088);
            C4990ab.m7411d(RadarViewController.TAG, "getview RadarStatus%s", this.pEg.getRadarStatus());
            bpb bpb = this.pEi[i];
            if (bpb != null) {
                Object obj;
                CharSequence charSequence = bpb.jBB;
                if (charSequence == null || C6163u.m9837ar(charSequence)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    charSequence = bpb.wfK;
                    if (charSequence == null || C6163u.m9837ar(charSequence)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        obj = 1;
                        if (obj == null) {
                            View inflate;
                            C39561g c39561g = C39561g.pDK;
                            String b = C39561g.m67618b(bpb);
                            C39549e radarStatus = this.pEg.getRadarStatus();
                            if (view == null) {
                                inflate = View.inflate(this.context, 2130970439, null);
                                if (inflate == null) {
                                    C25052j.dWJ();
                                }
                                inflate.setTag(this.pEg.pEa, Integer.valueOf(this.pEl.cdT()));
                                inflate.setTag(this.pEg.pEb, this.pEl.getInAnimation());
                                view2 = inflate;
                            } else {
                                view2 = view;
                            }
                            View findViewById = view2.findViewById(2131826793);
                            C44941v c44941v;
                            if (findViewById == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type android.widget.ImageView");
                                AppMethodBeat.m2505o(103088);
                                throw c44941v;
                            }
                            ImageView imageView = (ImageView) findViewById;
                            View findViewById2 = view2.findViewById(2131826792);
                            if (findViewById2 == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
                                AppMethodBeat.m2505o(103088);
                                throw c44941v;
                            }
                            RadarStateView radarStateView = (RadarStateView) findViewById2;
                            View findViewById3 = view2.findViewById(2131826796);
                            if (findViewById3 == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type android.widget.TextView");
                                AppMethodBeat.m2505o(103088);
                                throw c44941v;
                            }
                            TextView textView = (TextView) findViewById3;
                            View findViewById4 = view2.findViewById(2131826794);
                            if (findViewById4 == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type android.widget.ImageView");
                                AppMethodBeat.m2505o(103088);
                                throw c44941v;
                            }
                            ImageView imageView2 = (ImageView) findViewById4;
                            View findViewById5 = view2.findViewById(2131826795);
                            if (findViewById5 == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
                                AppMethodBeat.m2505o(103088);
                                throw c44941v;
                            }
                            RadarStateChooseView radarStateChooseView = (RadarStateChooseView) findViewById5;
                            imageView.setVisibility(0);
                            radarStateView.setVisibility(0);
                            textView.setVisibility(0);
                            imageView2.setVisibility(0);
                            if (radarStatus == C39549e.SEARCHING || radarStatus == C39549e.SEARCH_RETRUN) {
                                radarStateView.setVisibility(0);
                                radarStateChooseView.setVisibility(8);
                            } else {
                                radarStateView.setVisibility(8);
                                radarStateChooseView.setVisibility(0);
                            }
                            view2.setTag(new C12940a(this, textView, imageView, radarStateView, radarStateChooseView, imageView2));
                            if (i == 7 || i % 3 == 1) {
                                inflate = view2.findViewById(2131826797);
                                C25052j.m39375o(inflate, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                                inflate.setVisibility(0);
                                inflate = view2.findViewById(2131826791);
                                C25052j.m39375o(inflate, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                                inflate.setVisibility(8);
                            } else {
                                inflate = view2.findViewById(2131826791);
                                C25052j.m39375o(inflate, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                                inflate.setVisibility(0);
                                inflate = view2.findViewById(2131826797);
                                C25052j.m39375o(inflate, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                                inflate.setVisibility(8);
                            }
                            if (view == null || view2 != view) {
                                this.pEn.put(b, view2);
                            }
                            obj = view2.getTag();
                            if (obj == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                                AppMethodBeat.m2505o(103088);
                                throw c44941v;
                            }
                            C12940a c12940a = (C12940a) obj;
                            c12940a.pEp.setText(C44089j.m79293b(this.pEg.getContext(), (CharSequence) bpb.jCH, c12940a.pEp.getTextSize()));
                            C34778a c34778a = C34778a.pCd;
                            C34778a.m57122b(c12940a.pEq, b);
                            View findViewById6 = view2.findViewById(2131826788);
                            C25052j.m39375o(findViewById6, "view.findViewById(R.id.radar_avatar_container)");
                            findViewById6.setTag(new C12941d(this.pEg, bpb));
                            RadarStateView radarStateView2;
                            RadarStateChooseView radarStateChooseView2;
                            if (this.pEg.getRadarStatus() == C39549e.SEARCHING || this.pEg.getRadarStatus() == C39549e.SEARCH_RETRUN) {
                                c12940a.pEt.setBackgroundResource(C25738R.drawable.f7042ze);
                                radarStateView2 = c12940a.pEr;
                                radarStateView2.pDb = true;
                                radarStateView2.cdK();
                                radarStateChooseView2 = c12940a.pEs;
                                radarStateChooseView2.pCV = false;
                                radarStateChooseView2.setVisibility(8);
                                C21556e a = C39550e.m67580a(RadarViewController.m61130c(this.pEg), bpb);
                                if (a == null) {
                                    a = this.pEg.pDU.mo68963Vx(b);
                                    C39550e c = RadarViewController.m61130c(this.pEg);
                                    C25052j.m39376p(bpb, "member");
                                    C25052j.m39376p(a, "state");
                                    String str = bpb.jBB;
                                    C25052j.m39375o(str, "member.UserName");
                                    c.mo62507b(str, a);
                                    str = bpb.wfK;
                                    C25052j.m39375o(str, "member.EncodeUserName");
                                    c.mo62507b(str, a);
                                }
                                Object a2 = RadarViewController.m61130c(this.pEg).mo62504a(bpb, true);
                                RadarStateView radarStateView3 = c12940a.pEr;
                                if (a2 == null) {
                                    a2 = C21556e.Stranger;
                                }
                                C25052j.m39376p(a2, "state");
                                radarStateView3.init();
                                radarStateView3.pDc.removeMessages(0);
                                radarStateView3.clearAnimation();
                                radarStateView3.pBL = a2;
                                radarStateView3.pCS = false;
                                radarStateView3.cdK();
                                radarStateView3 = c12940a.pEr;
                                C25052j.m39376p(a, "state");
                                radarStateView3.init();
                                C4990ab.m7410d(RadarStateView.TAG, " turnToState : ".concat(String.valueOf(a)));
                                boolean z = false;
                                if (radarStateView3.pBL == a) {
                                    radarStateView3.cdK();
                                } else {
                                    if (radarStateView3.getVisibility() == 0) {
                                        a2 = 1;
                                    } else {
                                        a2 = null;
                                    }
                                    if (a2 != null) {
                                        radarStateView3.cdM();
                                        z = true;
                                    }
                                    C4990ab.m7410d(RadarStateView.TAG, " delay : ".concat(String.valueOf(z)));
                                    radarStateView3.pBL = a;
                                    if (radarStateView3.pBL != C21556e.Stranger) {
                                        if (z) {
                                            radarStateView3.pDc.sendEmptyMessageDelayed(0, (long) (RadarStateView.pDe + 20));
                                        } else {
                                            radarStateView3.pDc.sendEmptyMessage(0);
                                        }
                                    }
                                }
                                C39550e c2 = RadarViewController.m61130c(this.pEg);
                                C25052j.m39376p(bpb, "member");
                                String str2 = bpb.jBB;
                                C25052j.m39375o(str2, "member.UserName");
                                c2.mo62506a(str2, null);
                                str2 = bpb.wfK;
                                C25052j.m39375o(str2, "member.EncodeUserName");
                                c2.mo62506a(str2, null);
                                if (i == 0) {
                                    this.pEm = this.pEk.size();
                                }
                                if (this.pEk.remove(b) != null) {
                                    this.pEl.mo55391g(this.pEm - this.pEk.size(), view2);
                                }
                                AppMethodBeat.m2505o(103088);
                                return view2;
                            }
                            Map map = RadarViewController.m61130c(this.pEg).pBv;
                            C39561g c39561g2 = C39561g.pDK;
                            if (C5046bo.isNullOrNil((String) map.get(C39561g.m67619c(bpb)))) {
                                view2 = m20917Z(view, i);
                            } else {
                                C21557a c21557a;
                                radarStateView2 = c12940a.pEr;
                                radarStateView2.pDb = false;
                                radarStateView2.setVisibility(8);
                                radarStateChooseView2 = c12940a.pEs;
                                radarStateChooseView2.pCV = true;
                                radarStateChooseView2.cdK();
                                C39550e c3 = RadarViewController.m61130c(this.pEg);
                                if (bpb != null) {
                                    c39561g2 = C39561g.pDK;
                                    c21557a = (C21557a) c3.pBz.get(C39561g.m67618b(bpb));
                                    if (c21557a == null) {
                                        c21557a = C21557a.UnSelected;
                                    }
                                }
                                c21557a = C21557a.UnSelected;
                                if (c21557a != C21557a.UnSelected) {
                                    c12940a.pEt.setBackgroundDrawable(null);
                                }
                                RadarStateChooseView radarStateChooseView3 = c12940a.pEs;
                                C25052j.m39376p(c21557a, "status");
                                if (radarStateChooseView3.pCW != c21557a) {
                                    radarStateChooseView3.pCW = c21557a;
                                    switch (C12944e.pCY[radarStateChooseView3.pCW.ordinal()]) {
                                        case 1:
                                            if (radarStateChooseView3.pCV) {
                                                radarStateChooseView3.cdK();
                                                radarStateChooseView3.pCS = true;
                                                radarStateChooseView3.startAnimation(radarStateChooseView3.getSlideOutAnim());
                                                break;
                                            }
                                            break;
                                        case 2:
                                            if (radarStateChooseView3.pCV) {
                                                radarStateChooseView3.cdK();
                                                radarStateChooseView3.startAnimation(radarStateChooseView3.getSlideInAnim());
                                                break;
                                            }
                                            break;
                                    }
                                }
                                if (i == 0) {
                                    this.pEm = this.pEk.size();
                                }
                                HashMap hashMap = this.pEk;
                                C39561g c39561g3 = C39561g.pDK;
                                if (hashMap.remove(C39561g.m67619c(bpb)) != null) {
                                    this.pEl.mo55391g(this.pEm - this.pEk.size(), view2);
                                }
                            }
                            AppMethodBeat.m2505o(103088);
                            return view2;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                }
            }
            view2 = m20917Z(view, i);
            AppMethodBeat.m2505o(103088);
            return view2;
        }

        public final void clearAll() {
            AppMethodBeat.m2504i(103089);
            this.pEk.clear();
            this.pEn.clear();
            for (String str : this.pEn.keySet()) {
                View view = (View) this.pEn.get(str);
                if (view != null) {
                    C34774a c34774a = this.pEl;
                    C25052j.m39375o(view, "it");
                    c34774a.mo55390cf(view);
                }
            }
            aPw();
            AppMethodBeat.m2505o(103089);
        }

        /* renamed from: Z */
        private final View m20917Z(View view, int i) {
            AppMethodBeat.m2504i(103090);
            if (view == null) {
                view = View.inflate(this.context, 2130970439, null);
                if (view == null) {
                    C25052j.dWJ();
                }
                view.setTag(this.pEg.pEa, Integer.valueOf(this.pEl.cdT()));
                view.setTag(this.pEg.pEb, this.pEl.getInAnimation());
            }
            View findViewById = view.findViewById(2131826793);
            C25052j.m39375o(findViewById, "anotherConvertView.findV…ar_result_item_avatar_iv)");
            findViewById.setVisibility(8);
            findViewById = view.findViewById(2131826794);
            C25052j.m39375o(findViewById, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
            findViewById.setVisibility(8);
            findViewById = view.findViewById(2131826796);
            C25052j.m39375o(findViewById, "anotherConvertView.findV…_result_item_username_tv)");
            findViewById.setVisibility(4);
            findViewById = view.findViewById(2131826792);
            C25052j.m39375o(findViewById, "anotherConvertView.findV….radar_member_state_view)");
            findViewById.setVisibility(4);
            findViewById = view.findViewById(2131826795);
            C25052j.m39375o(findViewById, "anotherConvertView.findV…member_state_choose_view)");
            findViewById.setVisibility(4);
            if (i == 7 || i % 3 == 1) {
                findViewById = view.findViewById(2131826797);
                C25052j.m39375o(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById.setVisibility(0);
                findViewById = view.findViewById(2131826791);
                C25052j.m39375o(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById.setVisibility(8);
            } else {
                findViewById = view.findViewById(2131826791);
                C25052j.m39375o(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById.setVisibility(0);
                findViewById = view.findViewById(2131826797);
                C25052j.m39375o(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById.setVisibility(8);
            }
            AppMethodBeat.m2505o(103090);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
        /* JADX WARNING: Missing block: B:13:0x0026, code skipped:
            if (r0 != null) goto L_0x0028;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: d */
        public final void mo24973d(bpb bpb) {
            Object obj;
            AppMethodBeat.m2504i(103091);
            if (bpb != null) {
                CharSequence charSequence = bpb.jBB;
                if (charSequence == null || C6163u.m9837ar(charSequence)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    charSequence = bpb.wfK;
                    if (charSequence == null || C6163u.m9837ar(charSequence)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                obj = null;
                if (obj == null) {
                    AppMethodBeat.m2505o(103091);
                    return;
                }
                C39561g c39561g = C39561g.pDK;
                if (bpb == null) {
                    C25052j.dWJ();
                }
                obj = C39561g.m67618b(bpb);
                if (RadarViewController.m61130c(this.pEg).pBv.containsKey(obj)) {
                    obj = RadarViewController.m61130c(this.pEg).pBv.get(obj);
                    if (obj == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.m2505o(103091);
                        throw c44941v;
                    }
                    obj = (String) obj;
                }
                this.pEj.put(obj, obj);
                AppMethodBeat.m2505o(103091);
                return;
            }
            obj = 1;
            if (obj == null) {
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$TagItem;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$d */
    public final class C12941d {
        private bpb pBK;
        final /* synthetic */ RadarViewController pEg;

        public C12941d(RadarViewController radarViewController, bpb bpb) {
            C25052j.m39376p(bpb, "member");
            this.pEg = radarViewController;
            AppMethodBeat.m2504i(103093);
            this.pBK = bpb;
            AppMethodBeat.m2505o(103093);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$f */
    static final class C12942f implements OnClickListener {
        final /* synthetic */ RadarViewController pEg;

        C12942f(RadarViewController radarViewController) {
            this.pEg = radarViewController;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(103097);
            if (this.pEg.getRadarStatus() == C39549e.SEARCHING || this.pEg.getRadarStatus() == C39549e.SEARCH_RETRUN) {
                Context context = this.pEg.getContext();
                if (context == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.m2505o(103097);
                    throw c44941v;
                }
                ((Activity) context).finish();
                AppMethodBeat.m2505o(103097);
                return;
            }
            RadarViewController radarViewController = this.pEg;
            C12939c d = RadarViewController.m61131d(this.pEg);
            LinkedList linkedList = new LinkedList();
            for (Object obj : d.pEi) {
                if (obj != null) {
                    linkedList.add(obj);
                }
            }
            if (RadarViewController.m61126a(radarViewController, linkedList)) {
                RadarViewController.m61134f(this.pEg).cdU();
                RadarViewController.m61134f(this.pEg).setVisibility(0);
                RadarViewController.m61130c(this.pEg).cdA();
                RadarViewController.m61124a(this.pEg, C39549e.SEARCH_RETRUN);
            } else {
                RadarViewController.m61124a(this.pEg, C39549e.SEARCHING);
            }
            RadarViewController.m61131d(this.pEg).aPw();
            AppMethodBeat.m2505o(103097);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$a */
    final class C34774a {
        private int pEd;
        final boolean pEe;
        private final C7510a pEf = new C7510a(this);

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$a$a */
        public static final class C7510a extends C7306ak {
            final /* synthetic */ C34774a pEh;

            C7510a(C34774a c34774a) {
                this.pEh = c34774a;
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(103080);
                C25052j.m39376p(message, "msg");
                if (message.obj instanceof View) {
                    Object obj = message.obj;
                    if (obj == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.m2505o(103080);
                        throw c44941v;
                    }
                    View view = (View) obj;
                    view.setVisibility(0);
                    view.clearAnimation();
                    if (!this.pEh.pEe) {
                        Object tag = view.getTag(RadarViewController.this.pEb);
                        if (!(tag instanceof Animation)) {
                            tag = null;
                        }
                        Animation animation = (Animation) tag;
                        if (animation == null) {
                            animation = this.pEh.getInAnimation();
                        }
                        view.startAnimation(animation);
                    }
                }
                AppMethodBeat.m2505o(103080);
            }
        }

        public C34774a() {
            AppMethodBeat.m2504i(103085);
            C39561g c39561g = C39561g.pDK;
            Context context = RadarViewController.this.getContext();
            C25052j.m39375o(context, "context");
            this.pEe = C39561g.m67620eJ(context);
            AppMethodBeat.m2505o(103085);
        }

        public final Animation getInAnimation() {
            AppMethodBeat.m2504i(103081);
            Animation loadAnimation = AnimationUtils.loadAnimation(RadarViewController.this.getContext(), C25738R.anim.f8384cp);
            C25052j.m39375o(loadAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
            AppMethodBeat.m2505o(103081);
            return loadAnimation;
        }

        public final int cdT() {
            this.pEd++;
            return this.pEd;
        }

        /* renamed from: g */
        public final void mo55391g(int i, View view) {
            AppMethodBeat.m2504i(103082);
            C25052j.m39376p(view, "view");
            Message obtainMessage = this.pEf.obtainMessage();
            obtainMessage.what = m57118dr(view);
            obtainMessage.obj = view;
            view.setVisibility(4);
            this.pEf.sendMessageDelayed(obtainMessage, (long) ((i + 1) * 500));
            AppMethodBeat.m2505o(103082);
        }

        /* renamed from: cf */
        public final void mo55390cf(View view) {
            AppMethodBeat.m2504i(103083);
            C25052j.m39376p(view, "view");
            int dr = m57118dr(view);
            if (dr > 0) {
                this.pEf.removeMessages(dr);
            }
            view.clearAnimation();
            AppMethodBeat.m2505o(103083);
        }

        /* renamed from: dr */
        private final int m57118dr(View view) {
            AppMethodBeat.m2504i(103084);
            Object tag = view.getTag(RadarViewController.this.pEa);
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            if (num != null) {
                int intValue = num.intValue();
                AppMethodBeat.m2505o(103084);
                return intValue;
            }
            AppMethodBeat.m2505o(103084);
            return -1;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$b */
    public static final class C34775b {
        private C34775b() {
        }

        public /* synthetic */ C34775b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$h */
    public static final class C36800h implements C21561a {
        final /* synthetic */ RadarViewController pEg;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$h$a */
        static final class C34776a implements Runnable {
            final /* synthetic */ bpb pCz;
            final /* synthetic */ C36800h pEw;
            final /* synthetic */ View pEx;
            final /* synthetic */ C21556e pEy;

            C34776a(C36800h c36800h, View view, bpb bpb, C21556e c21556e) {
                this.pEw = c36800h;
                this.pEx = view;
                this.pCz = bpb;
                this.pEy = c21556e;
            }

            public final void run() {
                AppMethodBeat.m2504i(103099);
                RadarViewController.m61135g(this.pEw.pEg).mo62513a(this.pEx, this.pCz, this.pEy);
                RadarViewController.m61134f(this.pEw.pEg).cdV();
                AppMethodBeat.m2505o(103099);
            }
        }

        C36800h(RadarViewController radarViewController) {
            this.pEg = radarViewController;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x019a  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0171  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x014c  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0103  */
        /* JADX WARNING: Missing block: B:20:0x006d, code skipped:
            if (r1 != 0) goto L_0x006f;
     */
        /* JADX WARNING: Missing block: B:47:0x00fe, code skipped:
            if (r1 != 0) goto L_0x0100;
     */
        /* JADX WARNING: Missing block: B:82:0x0195, code skipped:
            if (r1 != 0) goto L_0x0197;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: f */
        public final void mo37038f(int i, View view) {
            int i2 = 0;
            AppMethodBeat.m2504i(103100);
            C25052j.m39376p(view, "view");
            bpb bpb = RadarViewController.m61131d(this.pEg).pEi[i];
            if (bpb == null) {
                AppMethodBeat.m2505o(103100);
                return;
            }
            C39561g c39561g;
            CharSequence charSequence;
            int i3;
            Object tag;
            C44941v c44941v;
            switch (C39562h.pCY[this.pEg.getRadarStatus().ordinal()]) {
                case 1:
                case 2:
                    c39561g = C39561g.pDK;
                    String b = C39561g.m67618b(bpb);
                    if (bpb != null) {
                        charSequence = bpb.jBB;
                        if (charSequence == null || C6163u.m9837ar(charSequence)) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            charSequence = bpb.wfK;
                            if (charSequence != null && !C6163u.m9837ar(charSequence)) {
                                i3 = 0;
                                break;
                            } else {
                                i3 = 1;
                                break;
                            }
                        }
                        if (i2 == 0) {
                            View view2 = (View) RadarViewController.m61131d(this.pEg).pEn.get(b);
                            C21556e a = C39550e.m67580a(RadarViewController.m61130c(this.pEg), bpb);
                            if (view2 == null || a == C21556e.Stranger) {
                                RadarViewController.m61135g(this.pEg).mo62513a(view, bpb, a);
                                RadarViewController.m61134f(this.pEg).cdV();
                                AppMethodBeat.m2505o(103100);
                                return;
                            }
                            tag = view2.getTag();
                            if (tag == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                                AppMethodBeat.m2505o(103100);
                                throw c44941v;
                            }
                            ((C12940a) tag).pEr.cdM();
                            C7306ak c7306ak = new C7306ak();
                            Runnable c34776a = new C34776a(this, view, bpb, a);
                            C12935a c12935a = RadarStateView.pDf;
                            c7306ak.postDelayed(c34776a, (long) RadarStateView.pDe);
                            AppMethodBeat.m2505o(103100);
                            return;
                        }
                    }
                    i2 = 1;
                    if (i2 == 0) {
                    }
                    break;
                case 3:
                    if (bpb != null) {
                        charSequence = bpb.jBB;
                        if (charSequence == null || C6163u.m9837ar(charSequence)) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            charSequence = bpb.wfK;
                            if (charSequence != null && !C6163u.m9837ar(charSequence)) {
                                i3 = 0;
                                break;
                            } else {
                                i3 = 1;
                                break;
                            }
                        }
                        i3 = 0;
                        if (i3 == 0) {
                            C12939c d = RadarViewController.m61131d(this.pEg);
                            if (bpb != null) {
                                c39561g = C39561g.pDK;
                                tag = C39561g.m67618b(bpb);
                                if (RadarViewController.m61130c(d.pEg).pBv.containsKey(tag)) {
                                    tag = RadarViewController.m61130c(d.pEg).pBv.get(tag);
                                    if (tag == null) {
                                        c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
                                        AppMethodBeat.m2505o(103100);
                                        throw c44941v;
                                    }
                                    tag = (String) tag;
                                }
                                if (d.pEj.containsKey(tag)) {
                                    i3 = 1;
                                    if (i3 != 0) {
                                        RadarViewController.m61131d(this.pEg).mo24973d(bpb);
                                    } else {
                                        d = RadarViewController.m61131d(this.pEg);
                                        if (bpb != null) {
                                            charSequence = bpb.jBB;
                                            if (charSequence == null || C6163u.m9837ar(charSequence)) {
                                                i3 = 1;
                                            } else {
                                                i3 = 0;
                                            }
                                            if (i3 != 0) {
                                                charSequence = bpb.wfK;
                                                if (charSequence != null && !C6163u.m9837ar(charSequence)) {
                                                    i3 = 0;
                                                    break;
                                                } else {
                                                    i3 = 1;
                                                    break;
                                                }
                                            }
                                            i3 = 0;
                                            if (i3 == 0) {
                                                c39561g = C39561g.pDK;
                                                if (bpb == null) {
                                                    C25052j.dWJ();
                                                }
                                                tag = C39561g.m67618b(bpb);
                                                if (RadarViewController.m61130c(d.pEg).pBv.containsKey(tag)) {
                                                    tag = RadarViewController.m61130c(d.pEg).pBv.get(tag);
                                                    if (tag == null) {
                                                        c44941v = new C44941v("null cannot be cast to non-null type kotlin.String");
                                                        AppMethodBeat.m2505o(103100);
                                                        throw c44941v;
                                                    }
                                                    tag = (String) tag;
                                                }
                                                d.pEj.remove(tag);
                                            }
                                        }
                                        i3 = 1;
                                        if (i3 == 0) {
                                        }
                                    }
                                }
                            }
                            i3 = 0;
                            if (i3 != 0) {
                            }
                        }
                        RadarViewController.m61130c(this.pEg).mo62505a(bpb);
                        RadarViewController.cdS();
                        RadarViewController.m61131d(this.pEg).aPw();
                        AppMethodBeat.m2505o(103100);
                        return;
                    }
                    i3 = 1;
                    if (i3 == 0) {
                    }
                    RadarViewController.m61130c(this.pEg).mo62505a(bpb);
                    RadarViewController.cdS();
                    RadarViewController.m61131d(this.pEg).aPw();
                    AppMethodBeat.m2505o(103100);
                    return;
                default:
                    C4990ab.m7411d(RadarViewController.TAG, "unknow status for grid view %s", this.pEg.getRadarStatus());
                    break;
            }
            AppMethodBeat.m2505o(103100);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$g */
    static final class C36801g implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarViewController pEg;

        C36801g(RadarViewController radarViewController) {
            this.pEg = radarViewController;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(103098);
            C26443d.m42103bX(this.pEg.getContext());
            AppMethodBeat.m2505o(103098);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarViewController$i */
    static final class C36802i extends C25053k implements C31214a<RadarWaveView> {
        final /* synthetic */ RadarViewController pEg;

        C36802i(RadarViewController radarViewController) {
            this.pEg = radarViewController;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(103101);
            Context context = this.pEg.getContext();
            if (context == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.m2505o(103101);
                throw c44941v;
            }
            RadarWaveView radarWaveView = (RadarWaveView) ((Activity) context).findViewById(2131826803);
            AppMethodBeat.m2505o(103101);
            return radarWaveView;
        }
    }

    private final TextView getNewRadarTip() {
        AppMethodBeat.m2504i(103107);
        TextView textView = (TextView) this.pDP.getValue();
        AppMethodBeat.m2505o(103107);
        return textView;
    }

    private final ProgressBar getNewRadarTipLoading() {
        AppMethodBeat.m2504i(103108);
        ProgressBar progressBar = (ProgressBar) this.pDQ.getValue();
        AppMethodBeat.m2505o(103108);
        return progressBar;
    }

    private final View getRadarBgMask() {
        AppMethodBeat.m2504i(103110);
        View view = (View) this.pDS.getValue();
        AppMethodBeat.m2505o(103110);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final RadarSpecialGridView getGrid() {
        AppMethodBeat.m2504i(103105);
        RadarSpecialGridView radarSpecialGridView = (RadarSpecialGridView) this.pDN.getValue();
        AppMethodBeat.m2505o(103105);
        return radarSpecialGridView;
    }

    /* Access modifiers changed, original: final */
    public final RadarMemberView getMemberDetailView() {
        AppMethodBeat.m2504i(103104);
        RadarMemberView radarMemberView = (RadarMemberView) this.pDM.getValue();
        AppMethodBeat.m2505o(103104);
        return radarMemberView;
    }

    /* Access modifiers changed, original: final */
    public final Button getQuitBtn() {
        AppMethodBeat.m2504i(103109);
        Button button = (Button) this.pDR.getValue();
        AppMethodBeat.m2505o(103109);
        return button;
    }

    /* Access modifiers changed, original: final */
    public final RadarTipsView getRadarTips() {
        AppMethodBeat.m2504i(103106);
        RadarTipsView radarTipsView = (RadarTipsView) this.pDO.getValue();
        AppMethodBeat.m2505o(103106);
        return radarTipsView;
    }

    /* Access modifiers changed, original: final */
    public final RadarWaveView getWaveView() {
        AppMethodBeat.m2504i(103103);
        RadarWaveView radarWaveView = (RadarWaveView) this.pDL.getValue();
        AppMethodBeat.m2505o(103103);
        return radarWaveView;
    }

    public RadarViewController(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "mContext");
        super(context, attributeSet);
        AppMethodBeat.m2504i(103126);
        C34765d c34765d = this;
        Context applicationContext = context.getApplicationContext();
        C25052j.m39375o(applicationContext, "mContext.getApplicationContext()");
        this.pDT = new C39550e(c34765d, applicationContext);
        this.pDU = new C43413c(this, context);
        AppMethodBeat.m2505o(103126);
    }

    /* renamed from: c */
    public static final /* synthetic */ C39550e m61130c(RadarViewController radarViewController) {
        AppMethodBeat.m2504i(103127);
        C39550e c39550e = radarViewController.pDT;
        if (c39550e == null) {
            C25052j.avw("radarManager");
        }
        AppMethodBeat.m2505o(103127);
        return c39550e;
    }

    public static final /* synthetic */ void cdS() {
    }

    /* renamed from: d */
    public static final /* synthetic */ C12939c m61131d(RadarViewController radarViewController) {
        AppMethodBeat.m2504i(103128);
        C12939c c12939c = radarViewController.pDV;
        if (c12939c == null) {
            C25052j.avw("adapter");
        }
        AppMethodBeat.m2505o(103128);
        return c12939c;
    }

    /* renamed from: f */
    public static final /* synthetic */ RadarWaveView m61134f(RadarViewController radarViewController) {
        AppMethodBeat.m2504i(103130);
        RadarWaveView waveView = radarViewController.getWaveView();
        AppMethodBeat.m2505o(103130);
        return waveView;
    }

    /* renamed from: g */
    public static final /* synthetic */ RadarMemberView m61135g(RadarViewController radarViewController) {
        AppMethodBeat.m2504i(103131);
        RadarMemberView memberDetailView = radarViewController.getMemberDetailView();
        AppMethodBeat.m2505o(103131);
        return memberDetailView;
    }

    private final void setRadarStatus(C39549e c39549e) {
        this.pDW = c39549e;
    }

    public final C39549e getRadarStatus() {
        return this.pDW;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(103111);
        C39550e c39550e = this.pDT;
        if (c39550e == null) {
            C25052j.avw("radarManager");
        }
        c39550e.onResume();
        AppMethodBeat.m2505o(103111);
    }

    public final void cdA() {
        AppMethodBeat.m2504i(103112);
        C39550e c39550e = this.pDT;
        if (c39550e == null) {
            C25052j.avw("radarManager");
        }
        c39550e.cdA();
        AppMethodBeat.m2505o(103112);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(103113);
        C25052j.m39376p(keyEvent, "event");
        if (i == 4 && getMemberDetailView().isShowing()) {
            getMemberDetailView().dismiss();
            AppMethodBeat.m2505o(103113);
            return true;
        }
        AppMethodBeat.m2505o(103113);
        return false;
    }

    /* renamed from: d */
    private final void m61132d(String str, C21556e c21556e) {
        AppMethodBeat.m2504i(103114);
        C39550e c39550e = this.pDT;
        if (c39550e == null) {
            C25052j.avw("radarManager");
        }
        if (str == null) {
            C25052j.dWJ();
        }
        C21556e Vy = c39550e.mo62503Vy(str);
        if (!(Vy == null || Vy == c21556e)) {
            c39550e = this.pDT;
            if (c39550e == null) {
                C25052j.avw("radarManager");
            }
            c39550e.mo62507b(str, c21556e);
            C12939c c12939c = this.pDV;
            if (c12939c == null) {
                C25052j.avw("adapter");
            }
            c12939c.aPw();
        }
        AppMethodBeat.m2505o(103114);
    }

    /* renamed from: a */
    public final void mo58658a(boolean z, boolean z2, String str, String str2, long j) {
        C39550e c39550e;
        AppMethodBeat.m2504i(103115);
        if (z) {
            m61132d(str2, C21556e.Added);
        } else if (z2) {
            m61132d(str2, C21556e.Verifying);
        } else {
            RadarTipsView radarTips = getRadarTips();
            if (str == null) {
                str = "";
            }
            radarTips.mo55378Vz(str);
            c39550e = this.pDT;
            if (c39550e == null) {
                C25052j.avw("radarManager");
            }
            C21559c c21559c = (C21559c) c39550e.pBy.get(Long.valueOf(j));
            if (c21559c != null) {
                C39561g c39561g = C39561g.pDK;
                m61132d(C39561g.m67618b(c21559c.pBK), c21559c.pBL);
                c39561g = C39561g.pDK;
                m61132d(C39561g.m67619c(c21559c.pBK), c21559c.pBL);
            }
        }
        c39550e = this.pDT;
        if (c39550e == null) {
            C25052j.avw("radarManager");
        }
        c39550e.pBy.remove(Long.valueOf(j));
        AppMethodBeat.m2505o(103115);
    }

    /* renamed from: a */
    public final void mo58657a(boolean z, String str, String str2, long j) {
        C39550e c39550e;
        AppMethodBeat.m2504i(103116);
        if (z) {
            m61132d(str2, C21556e.Added);
        } else {
            RadarTipsView radarTips = getRadarTips();
            if (str == null) {
                str = "";
            }
            radarTips.mo55378Vz(str);
            c39550e = this.pDT;
            if (c39550e == null) {
                C25052j.avw("radarManager");
            }
            C21559c c21559c = (C21559c) c39550e.pBy.get(Long.valueOf(j));
            if (c21559c != null) {
                C39561g c39561g = C39561g.pDK;
                m61132d(C39561g.m67618b(c21559c.pBK), c21559c.pBL);
            }
        }
        c39550e = this.pDT;
        if (c39550e == null) {
            C25052j.avw("radarManager");
        }
        c39550e.pBy.remove(Long.valueOf(j));
        AppMethodBeat.m2505o(103116);
    }

    /* renamed from: R */
    public final void mo58656R(C7616ad c7616ad) {
        AppMethodBeat.m2504i(103117);
        C25052j.m39376p(c7616ad, "contact");
        C39550e c39550e = this.pDT;
        if (c39550e == null) {
            C25052j.avw("radarManager");
        }
        String username = c7616ad.getUsername();
        C25052j.m39375o(username, "contact.username");
        if (c39550e.mo62503Vy(username) == null) {
            c39550e = this.pDT;
            if (c39550e == null) {
                C25052j.avw("radarManager");
            }
            username = c7616ad.mo14678Hv();
            C25052j.m39375o(username, "contact.encryptUsername");
            if (c39550e.mo62503Vy(username) == null) {
                LinkedList linkedList = new LinkedList();
                username = c7616ad.getUsername();
                C25052j.m39375o(username, "contact.username");
                String Hv = c7616ad.mo14678Hv();
                C25052j.m39375o(Hv, "contact.encryptUsername");
                String Hs = c7616ad.mo14675Hs();
                C25052j.m39375o(Hs, "contact.nickname");
                bpb bpb = new bpb();
                bpb.wRw = 100;
                bpb.jBB = username;
                bpb.jCH = Hs;
                bpb.SmallImgUrl = "";
                bpb.wfK = Hv;
                linkedList.add(bpb);
                m61127aj(linkedList);
            }
        }
        if (getMemberDetailView().isShowing()) {
            RadarMemberView memberDetailView = getMemberDetailView();
            username = c7616ad.mo14678Hv();
            C25052j.m39375o(username, "contact.encryptUsername");
            memberDetailView.mo62514c(username, C21556e.NeedVerify);
        }
        m61132d(c7616ad.getUsername(), C21556e.NeedVerify);
        m61132d(c7616ad.mo14678Hv(), C21556e.NeedVerify);
        AppMethodBeat.m2505o(103117);
    }

    /* renamed from: Q */
    public final void mo58655Q(C7616ad c7616ad) {
        AppMethodBeat.m2504i(103118);
        C25052j.m39376p(c7616ad, "contact");
        if (getMemberDetailView().isShowing()) {
            RadarMemberView memberDetailView = getMemberDetailView();
            String Hv = c7616ad.mo14678Hv();
            C25052j.m39375o(Hv, "contact.encryptUsername");
            memberDetailView.mo62514c(Hv, C21556e.Added);
        }
        m61132d(c7616ad.getUsername(), C21556e.Added);
        m61132d(c7616ad.mo14678Hv(), C21556e.Added);
        AppMethodBeat.m2505o(103118);
    }

    /* renamed from: ka */
    public final void mo55376ka(boolean z) {
        AppMethodBeat.m2504i(103119);
        if (!z) {
            RadarTipsView radarTips = getRadarTips();
            String string = getContext().getString(C25738R.string.dh_);
            C25052j.m39375o(string, "context.getString(R.stri….radar_tips_location_err)");
            radarTips.mo55378Vz(string);
            if (!(this.nPX || C26443d.agA())) {
                this.nPX = true;
                C30379h.m48445a(getContext(), getContext().getString(C25738R.string.c9z), getContext().getString(C25738R.string.f9238tz), getContext().getString(C25738R.string.ckr), getContext().getString(C25738R.string.f9076or), false, (DialogInterface.OnClickListener) new C36801g(this), null);
            }
        }
        AppMethodBeat.m2505o(103119);
    }

    /* renamed from: a */
    public final void mo55374a(int i, int i2, LinkedList<bpb> linkedList) {
        AppMethodBeat.m2504i(103120);
        if (i == 0 && i2 == 0) {
            m61127aj(linkedList);
            AppMethodBeat.m2505o(103120);
            return;
        }
        C4990ab.m7413e(TAG, "radar member return error : %s, type : %s ", Integer.valueOf(i2), Integer.valueOf(i));
        RadarTipsView radarTips;
        String string;
        if (2 == i) {
            radarTips = getRadarTips();
            string = getContext().getString(C25738R.string.d5l);
            C25052j.m39375o(string, "context.getString(R.string.net_warn_no_network)");
            radarTips.mo55378Vz(string);
            AppMethodBeat.m2505o(103120);
            return;
        }
        radarTips = getRadarTips();
        string = getContext().getString(C25738R.string.dha);
        C25052j.m39375o(string, "context.getString(R.string.radar_tips_network_err)");
        radarTips.mo55378Vz(string);
        AppMethodBeat.m2505o(103120);
    }

    /* renamed from: b */
    public final void mo55375b(int i, int i2, LinkedList<boy> linkedList) {
        int i3 = 0;
        AppMethodBeat.m2504i(103121);
        if (i == 0 && i2 == 0 && linkedList != null) {
            m61123a(C39549e.RALATIONCHAIN_RETRUN);
            C12939c c12939c = this.pDV;
            if (c12939c == null) {
                C25052j.avw("adapter");
            }
            RadarViewController.m61130c(c12939c.pEg).pBz.clear();
            RadarViewController.m61130c(c12939c.pEg).pBv.clear();
            c12939c.pEj.clear();
            c12939c.pEk.clear();
            LinkedList linkedList2 = null;
            if (linkedList != null && linkedList.size() > 0) {
                int i4;
                LinkedList linkedList3 = new LinkedList();
                int size = linkedList.size();
                for (i4 = 0; i4 < size; i4++) {
                    Object obj = linkedList.get(i4);
                    C25052j.m39375o(obj, "radarChatMember[i]");
                    boy boy = (boy) obj;
                    boz boz = new boz();
                    boz.wRv = boy.jBB;
                    linkedList3.add(boz);
                    Map map = RadarViewController.m61130c(c12939c.pEg).pBv;
                    String str = boy.wfK;
                    C25052j.m39375o(str, "radarchatroomMember.EncodeUserName");
                    String str2 = boy.jBB;
                    C25052j.m39375o(str2, "radarchatroomMember.UserName");
                    map.put(str, str2);
                    HashMap hashMap = c12939c.pEk;
                    C39561g c39561g = C39561g.pDK;
                    hashMap.put(C39561g.m67617a(boy), Integer.valueOf(0));
                }
                i4 = c12939c.pEi.length;
                while (i3 < i4) {
                    bpb bpb = c12939c.pEi[i3];
                    Map map2 = RadarViewController.m61130c(c12939c.pEg).pBv;
                    C39561g c39561g2 = C39561g.pDK;
                    if (!C5046bo.isNullOrNil((String) map2.get(C39561g.m67619c(bpb)))) {
                        RadarViewController.m61131d(c12939c.pEg).mo24973d(bpb);
                        RadarViewController.m61130c(c12939c.pEg).mo62505a(bpb);
                    }
                    i3++;
                }
                linkedList2 = linkedList3;
            }
            RadarViewController.m61130c(c12939c.pEg).pBu = linkedList2;
            C12939c c12939c2 = this.pDV;
            if (c12939c2 == null) {
                C25052j.avw("adapter");
            }
            c12939c2.aPw();
            AppMethodBeat.m2505o(103121);
            return;
        }
        m61123a(C39549e.SEARCHING);
        RadarTipsView radarTips = getRadarTips();
        String string = getContext().getString(C25738R.string.dha);
        C25052j.m39375o(string, "context.getString(R.string.radar_tips_network_err)");
        radarTips.mo55378Vz(string);
        AppMethodBeat.m2505o(103121);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aj */
    private final void m61127aj(LinkedList<bpb> linkedList) {
        C12939c c12939c;
        AppMethodBeat.m2504i(103122);
        if (linkedList == null) {
            C25052j.dWJ();
        }
        if (linkedList.size() == 0) {
            C12939c c12939c2 = this.pDV;
            if (c12939c2 == null) {
                C25052j.avw("adapter");
            }
            if (c12939c2.getCount() == 0) {
                getRadarTips().setNoMember(true);
                C4990ab.m7410d(TAG, "members got, size : " + linkedList.size());
                C4990ab.m7411d(TAG, "has friend:%s", String.valueOf(m61128ak(linkedList)));
                c12939c = this.pDV;
                if (c12939c == null) {
                    C25052j.avw("adapter");
                }
                c12939c.mo24971al(linkedList);
                if (this.pDX && r0) {
                    m61123a(C39549e.SEARCH_RETRUN);
                }
                AppMethodBeat.m2505o(103122);
            }
        }
        getRadarTips().setNoMember(false);
        C4990ab.m7410d(TAG, "members got, size : " + linkedList.size());
        C4990ab.m7411d(TAG, "has friend:%s", String.valueOf(m61128ak(linkedList)));
        c12939c = this.pDV;
        if (c12939c == null) {
        }
        c12939c.mo24971al(linkedList);
        m61123a(C39549e.SEARCH_RETRUN);
        AppMethodBeat.m2505o(103122);
    }

    /* renamed from: ak */
    private final boolean m61128ak(LinkedList<bpb> linkedList) {
        AppMethodBeat.m2504i(103123);
        boolean z = false;
        if (linkedList == null) {
            C25052j.dWJ();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C21556e Vx;
            boolean z2;
            bpb bpb = (bpb) it.next();
            C39550e c39550e = this.pDT;
            if (c39550e == null) {
                C25052j.avw("radarManager");
            }
            C25052j.m39375o(bpb, "member");
            C21556e a = C39550e.m67580a(c39550e, bpb);
            if (a == null) {
                C39561g c39561g = C39561g.pDK;
                String b = C39561g.m67618b(bpb);
                Vx = this.pDU.mo68963Vx(b);
                C39550e c39550e2 = this.pDT;
                if (c39550e2 == null) {
                    C25052j.avw("radarManager");
                }
                c39550e2.mo62507b(b, Vx);
            } else {
                Vx = a;
            }
            if (Vx == C21556e.Added) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        AppMethodBeat.m2505o(103123);
        return z;
    }

    /* renamed from: a */
    private final void m61123a(C39549e c39549e) {
        AppMethodBeat.m2504i(103124);
        this.pDW = c39549e;
        C39550e c39550e;
        switch (C39562h.pEv[c39549e.ordinal()]) {
            case 1:
                getRadarBgMask().setVisibility(8);
                getQuitBtn().setText(C25738R.string.dh5);
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText("");
                getWaveView().cdU();
                getWaveView().setVisibility(0);
                c39550e = this.pDT;
                if (c39550e == null) {
                    C25052j.avw("radarManager");
                }
                c39550e.cdA();
                AppMethodBeat.m2505o(103124);
                return;
            case 2:
                getRadarBgMask().setVisibility(8);
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText("");
                AppMethodBeat.m2505o(103124);
                return;
            case 3:
                cdR();
                getQuitBtn().setText(C25738R.string.f9076or);
                c39550e = this.pDT;
                if (c39550e == null) {
                    C25052j.avw("radarManager");
                }
                c39550e.cdB();
                getNewRadarTipLoading().setVisibility(0);
                getNewRadarTip().setText(C25738R.string.dh7);
                getWaveView().cdV();
                getWaveView().setVisibility(4);
                getGrid().setVisibility(4);
                C12939c c12939c = this.pDV;
                if (c12939c == null) {
                    C25052j.avw("adapter");
                }
                c12939c.clearAll();
                AppMethodBeat.m2505o(103124);
                return;
            case 4:
                getRadarBgMask().setVisibility(0);
                c39550e = this.pDT;
                if (c39550e == null) {
                    C25052j.avw("radarManager");
                }
                c39550e.cdB();
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText(C25738R.string.dgw);
                getGrid().setVisibility(0);
                AppMethodBeat.m2505o(103124);
                return;
            case 5:
                getRadarBgMask().setVisibility(8);
                c39550e = this.pDT;
                if (c39550e == null) {
                    C25052j.avw("radarManager");
                }
                c39550e.cdB();
                getNewRadarTipLoading().setVisibility(0);
                getNewRadarTip().setText(C25738R.string.dgx);
                break;
        }
        AppMethodBeat.m2505o(103124);
    }

    private final void cdR() {
        AppMethodBeat.m2504i(103125);
        if (getRadarBgMask().getVisibility() != 0) {
            getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8377ci));
            getRadarBgMask().setVisibility(0);
        }
        AppMethodBeat.m2505o(103125);
    }

    static {
        AppMethodBeat.m2504i(103102);
        AppMethodBeat.m2505o(103102);
    }
}
