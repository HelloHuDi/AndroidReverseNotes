package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.f.b.y;
import a.i.k;
import a.k.u;
import a.l;
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
import com.tencent.mm.R;
import com.tencent.mm.plugin.radar.b.c.m;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

@l(dWo = {1, 1, 13}, dWp = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b\u0001\u0001\u0001\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ0\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020K2\u0006\u0010O\u001a\u00020KH\u0002J\u0006\u0010P\u001a\u00020QJ\u0018\u0010R\u001a\u00020\u00122\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010TH\u0002J4\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u00122\b\u0010X\u001a\u0004\u0018\u00010K2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020Q2\b\u0010\\\u001a\u0004\u0018\u00010]J\u0006\u0010^\u001a\u00020QJ\u0018\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020bH\u0016J\u001a\u0010c\u001a\u00020Q2\u0006\u0010d\u001a\u00020\u00122\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\u0006\u0010g\u001a\u00020QJ0\u0010h\u001a\u00020Q2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010T2\u0006\u0010l\u001a\u00020\nH\u0016J0\u0010m\u001a\u00020Q2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010T2\u0006\u0010l\u001a\u00020\nH\u0016J\u0010\u0010p\u001a\u00020Q2\u0006\u0010q\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020Q2\u0006\u0010q\u001a\u00020rH\u0016J\u0006\u0010t\u001a\u00020QJ,\u0010u\u001a\u00020Q2\u0006\u0010V\u001a\u00020\u00122\b\u0010X\u001a\u0004\u0018\u00010K2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010v\u001a\u00020QH\u0002J\u0018\u0010w\u001a\u00020Q2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010TH\u0002J\b\u0010x\u001a\u00020QH\u0002J\u0006\u0010y\u001a\u00020QJ\u0006\u0010z\u001a\u00020QJ\u0006\u0010{\u001a\u00020QJ\u0006\u0010|\u001a\u00020QJ\u001a\u0010}\u001a\u00020Q2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010~\u001a\u00020H\u0002J\u0012\u0010\u0001\u001a\u00020Q2\u0007\u0010\u0001\u001a\u000208H\u0002J\t\u0010\u0001\u001a\u00020QH\u0002R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\u0018\u001a\u0004\b2\u00103R\u000e\u00105\u001a\u000206X.¢\u0006\u0002\n\u0000R$\u00109\u001a\u0002082\u0006\u00107\u001a\u000208@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u00020?8BX\u0002¢\u0006\f\n\u0004\bB\u0010\u0018\u001a\u0004\b@\u0010AR\u001b\u0010C\u001a\u00020D8BX\u0002¢\u0006\f\n\u0004\bG\u0010\u0018\u001a\u0004\bE\u0010F¨\u0006\u0001"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$IOnAddContact;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TagAnimation", "", "TagBase", "TagIndex", "adapter", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "addContact", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact;", "canCreateGroup", "", "grid", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "getGrid", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "grid$delegate", "Lkotlin/Lazy;", "hasShowGpsAlert", "mOnQuitActionButtonListener", "Landroid/view/View$OnClickListener;", "memberDetailView", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "getMemberDetailView", "()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "memberDetailView$delegate", "newRadarTip", "Landroid/widget/TextView;", "getNewRadarTip", "()Landroid/widget/TextView;", "newRadarTip$delegate", "newRadarTipLoading", "Landroid/widget/ProgressBar;", "getNewRadarTipLoading", "()Landroid/widget/ProgressBar;", "newRadarTipLoading$delegate", "quitBtn", "Landroid/widget/Button;", "getQuitBtn", "()Landroid/widget/Button;", "quitBtn$delegate", "radarBgMask", "Landroid/view/View;", "getRadarBgMask", "()Landroid/view/View;", "radarBgMask$delegate", "radarManager", "Lcom/tencent/mm/plugin/radar/model/RadarManager;", "<set-?>", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "radarStatus", "getRadarStatus", "()Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "setRadarStatus", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;)V", "radarTips", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "getRadarTips", "()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "radarTips$delegate", "waveView", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "getWaveView", "()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "waveView$delegate", "buildMember", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "username", "", "encyptUsername", "distance", "nickname", "smallImgUrl", "initView", "", "mapRadarSearchMembersState", "radarSearchMembers", "Ljava/util/LinkedList;", "onAddContactReturn", "ok", "hasSentVerify", "errMsg", "timeStamp", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLocationGot", "isOk", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onPause", "onRadarMemberReturn", "errType", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "onRecvFriendAdded", "contact", "Lcom/tencent/mm/storage/Contact;", "onRecvFriendVerify", "onResume", "onVerifyContactReturn", "prepareGrid", "processRadarSearchMembers", "radarBackgroundFadeIn", "startRadarSearch", "startWaves", "stopRadarSearch", "stopWaves", "switchRadarContactState", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "swithcRadarUI", "status", "updateActionButton", "AvatarAnimator", "Companion", "RadarSearchAdapter", "TagItem", "plugin-radar_release"})
public final class RadarViewController extends RelativeLayout implements com.tencent.mm.plugin.radar.b.c.c, com.tencent.mm.plugin.radar.b.e.d {
    private static final String TAG = TAG;
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(RadarViewController.class), "waveView", "getWaveView()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;")), v.a(new t(v.aN(RadarViewController.class), "memberDetailView", "getMemberDetailView()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;")), v.a(new t(v.aN(RadarViewController.class), "grid", "getGrid()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;")), v.a(new t(v.aN(RadarViewController.class), "radarTips", "getRadarTips()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;")), v.a(new t(v.aN(RadarViewController.class), "newRadarTip", "getNewRadarTip()Landroid/widget/TextView;")), v.a(new t(v.aN(RadarViewController.class), "newRadarTipLoading", "getNewRadarTipLoading()Landroid/widget/ProgressBar;")), v.a(new t(v.aN(RadarViewController.class), "quitBtn", "getQuitBtn()Landroid/widget/Button;")), v.a(new t(v.aN(RadarViewController.class), "radarBgMask", "getRadarBgMask()Landroid/view/View;"))};
    public static final b pEc = new b();
    private boolean nPX;
    private final a.f pDL = a.i.g(new i(this));
    private final a.f pDM = i.aa(this, R.id.dtk);
    private final a.f pDN = i.aa(this, R.id.dud);
    private final a.f pDO = i.aa(this, R.id.duf);
    private final a.f pDP = i.aa(this, R.id.dub);
    private final a.f pDQ = i.aa(this, R.id.dua);
    private final a.f pDR = i.aa(this, R.id.due);
    private final a.f pDS = i.aa(this, R.id.du6);
    com.tencent.mm.plugin.radar.b.e pDT;
    com.tencent.mm.plugin.radar.b.c pDU;
    c pDV;
    private com.tencent.mm.plugin.radar.b.e.e pDW = com.tencent.mm.plugin.radar.b.e.e.SEARCHING;
    private final boolean pDX;
    final OnClickListener pDY = new f(this);
    private final int pDZ = 33554432;
    private final int pEa = (this.pDZ + 1);
    private final int pEb = (this.pDZ + 2);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
    public static final class e implements com.tencent.mm.plugin.radar.ui.RadarMemberView.b {
        final /* synthetic */ RadarViewController pEg;

        e(RadarViewController radarViewController) {
            this.pEg = radarViewController;
        }

        public final void a(bpb bpb, com.tencent.mm.plugin.radar.b.c.e eVar) {
            AppMethodBeat.i(103095);
            j.p(bpb, "member");
            g gVar = g.pDK;
            String b = g.b(bpb);
            if (eVar == null) {
                AppMethodBeat.o(103095);
                return;
            }
            switch (h.eQZ[eVar.ordinal()]) {
                case 1:
                    RadarViewController.c(this.pEg).pBy.put(Long.valueOf(this.pEg.pDU.Vw(b)), new com.tencent.mm.plugin.radar.b.e.c(bpb, eVar));
                    RadarViewController.a(this.pEg, b, com.tencent.mm.plugin.radar.b.c.e.Verifying);
                    AppMethodBeat.o(103095);
                    return;
                case 2:
                    int i;
                    Object obj;
                    String username;
                    int i2;
                    long j;
                    com.tencent.mm.plugin.radar.b.c e = this.pEg.pDU;
                    j.p(b, "username");
                    com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                    j.o(K, "service(IMessengerStorage::class.java)");
                    ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(b);
                    j.o(aoO, "contact");
                    CharSequence username2 = aoO.getUsername();
                    if (username2 == null || u.ar(username2)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        obj = b;
                    } else {
                        username = aoO.getUsername();
                        j.o(username, "contact.username");
                        String obj2 = username;
                    }
                    username = (String) e.pAN.get(obj2);
                    CharSequence charSequence = username;
                    if (charSequence == null || u.ar(charSequence)) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        ab.e(com.tencent.mm.plugin.radar.b.c.TAG, "Verify Contact username(%s) error, verifyTicket is null", obj2);
                        e.Vw(obj2);
                        j = -1;
                    } else {
                        com.tencent.mm.storage.bi.d apF = com.tencent.mm.storage.bi.d.apF(username);
                        long currentTimeMillis = System.currentTimeMillis();
                        com.tencent.mm.plugin.radar.b.c.a aVar = new com.tencent.mm.plugin.radar.b.c.a(new m(e, username, currentTimeMillis));
                        String duc = apF.duc();
                        j.o(duc, "verify.verifyTicket");
                        j.p(duc, "verifyTicket");
                        String str = "username is null";
                        boolean z = obj2 != null && obj2.length() > 0;
                        Assert.assertTrue(str, z);
                        aVar.onStart();
                        com.tencent.mm.kernel.g.Rg().d((com.tencent.mm.ai.m) new com.tencent.mm.pluginsdk.model.m(obj2, duc, 48, (byte) 0));
                        j = currentTimeMillis;
                    }
                    RadarViewController.c(this.pEg).pBy.put(Long.valueOf(j), new com.tencent.mm.plugin.radar.b.e.c(bpb, eVar));
                    RadarViewController.a(this.pEg, b, com.tencent.mm.plugin.radar.b.c.e.Verifying);
                    break;
            }
            AppMethodBeat.o(103095);
        }

        public final void b(bpb bpb, com.tencent.mm.plugin.radar.b.c.e eVar) {
            Object b;
            AppMethodBeat.i(103096);
            if (bpb != null) {
                g gVar = g.pDK;
                b = g.b(bpb);
            } else {
                b = null;
            }
            View view = (View) RadarViewController.d(this.pEg).pEn.get(b);
            if (view != null) {
                Object tag = view.getTag();
                if (tag == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                    AppMethodBeat.o(103096);
                    throw vVar;
                }
                a aVar = (a) tag;
                if (eVar != com.tencent.mm.plugin.radar.b.c.e.Stranger) {
                    aVar.pEr.cdL();
                }
            }
            RadarViewController.f(this.pEg).cdU();
            AppMethodBeat.o(103096);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001DB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001dJ\u0006\u00101\u001a\u00020/J\u0006\u00102\u001a\u00020/J\b\u00103\u001a\u00020/H\u0002J\u0010\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\bH\u0016J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00105\u001a\u00020\bH\u0016J\u001a\u00108\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010+2\u0006\u00105\u001a\u00020\bH\u0016J\u0010\u0010:\u001a\u00020\u00102\b\u0010;\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010<\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010+2\u0006\u00105\u001a\u00020\bH\u0002J\"\u0010=\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010+2\u0006\u00105\u001a\u00020\b2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001dJ\u0016\u0010A\u001a\u00020/2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010$R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R4\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010$2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010$8F@FX\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020+0\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017¨\u0006E"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;", "Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "radarGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "animSize", "", "animator", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController;", "count", "getCount", "()I", "hideView", "", "memberReqMap", "Ljava/util/HashMap;", "", "getMemberReqMap", "()Ljava/util/HashMap;", "setMemberReqMap", "(Ljava/util/HashMap;)V", "needAnim", "getNeedAnim", "setNeedAnim", "radarSearchMember", "", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMember", "()[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setRadarSearchMember", "([Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "[Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "newMembers", "Ljava/util/LinkedList;", "radarSearchMemberList", "getRadarSearchMemberList", "()Ljava/util/LinkedList;", "setRadarSearchMemberList", "(Ljava/util/LinkedList;)V", "viewTable", "Landroid/view/View;", "getViewTable", "setViewTable", "addMemberReq", "", "member", "clearAll", "clearData", "doInit", "getChanged", "position", "getItem", "", "getView", "convertView", "isMemReqContainsSearchMem", "sm", "makePlaceHolderView", "makeView", "radarStatus", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "removeMemberReq", "setRadarChatRoomMemberList", "radarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "ViewHolder", "plugin-radar_release"})
    public final class c extends a {
        private final Context context;
        final /* synthetic */ RadarViewController pEg;
        bpb[] pEi = new bpb[12];
        HashMap<String, String> pEj = new HashMap();
        HashMap<String, Integer> pEk = new HashMap();
        private final a pEl;
        private int pEm;
        HashMap<String, View> pEn = new HashMap();
        private boolean pEo;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter$ViewHolder;", "", "tvMemberName", "Landroid/widget/TextView;", "ivMemberAvatar", "Landroid/widget/ImageView;", "vMemberState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "vMemberChooseState", "Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "ivMemberAvatarMask", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController$RadarSearchAdapter;Landroid/widget/TextView;Landroid/widget/ImageView;Lcom/tencent/mm/plugin/radar/ui/RadarStateView;Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;Landroid/widget/ImageView;)V", "getIvMemberAvatar$plugin_radar_release", "()Landroid/widget/ImageView;", "setIvMemberAvatar$plugin_radar_release", "(Landroid/widget/ImageView;)V", "getIvMemberAvatarMask$plugin_radar_release", "setIvMemberAvatarMask$plugin_radar_release", "getTvMemberName$plugin_radar_release", "()Landroid/widget/TextView;", "setTvMemberName$plugin_radar_release", "(Landroid/widget/TextView;)V", "getVMemberChooseState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;", "setVMemberChooseState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateChooseView;)V", "getVMemberState$plugin_radar_release", "()Lcom/tencent/mm/plugin/radar/ui/RadarStateView;", "setVMemberState$plugin_radar_release", "(Lcom/tencent/mm/plugin/radar/ui/RadarStateView;)V", "plugin-radar_release"})
        public final class a {
            TextView pEp;
            ImageView pEq;
            RadarStateView pEr;
            RadarStateChooseView pEs;
            ImageView pEt;
            final /* synthetic */ c pEu;

            public a(c cVar, TextView textView, ImageView imageView, RadarStateView radarStateView, RadarStateChooseView radarStateChooseView, ImageView imageView2) {
                j.p(textView, "tvMemberName");
                j.p(imageView, "ivMemberAvatar");
                j.p(radarStateView, "vMemberState");
                j.p(radarStateChooseView, "vMemberChooseState");
                j.p(imageView2, "ivMemberAvatarMask");
                this.pEu = cVar;
                AppMethodBeat.i(103086);
                this.pEp = textView;
                this.pEq = imageView;
                this.pEr = radarStateView;
                this.pEs = radarStateChooseView;
                this.pEt = imageView2;
                AppMethodBeat.o(103086);
            }
        }

        public c(RadarViewController radarViewController, RadarSpecialGridView radarSpecialGridView, Context context) {
            j.p(radarSpecialGridView, "radarGridView");
            j.p(context, "context");
            this.pEg = radarViewController;
            super(radarSpecialGridView, context);
            AppMethodBeat.i(103092);
            this.context = context;
            this.pEl = new a();
            AppMethodBeat.o(103092);
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
        public final void al(LinkedList<bpb> linkedList) {
            AppMethodBeat.i(103087);
            if ((linkedList == null || linkedList.size() != 0) && linkedList != null) {
                int i;
                for (bpb c : this.pEi) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        bpb bpb = (bpb) it.next();
                        g gVar = g.pDK;
                        String c2 = g.c(bpb);
                        g gVar2 = g.pDK;
                        if (j.j(c2, g.c(c))) {
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
                                if (charSequence == null || u.ar(charSequence)) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                if (i3 != 0) {
                                    charSequence = bpb3.wfK;
                                    if (charSequence == null || u.ar(charSequence)) {
                                        i3 = 1;
                                    } else {
                                        i3 = 0;
                                    }
                                }
                                i3 = 0;
                                if (i3 == 0) {
                                    this.pEi[i2] = bpb2;
                                    HashMap hashMap = this.pEk;
                                    g gVar3 = g.pDK;
                                    j.o(bpb2, "member");
                                    hashMap.put(g.b(bpb2), Integer.valueOf(0));
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
                    com.tencent.mm.plugin.radar.b.d dVar = com.tencent.mm.plugin.radar.b.d.pBq;
                    int size = linkedList.size();
                    if (com.tencent.mm.plugin.radar.b.d.cEX == 0 && size > 0) {
                        float cdz = (((float) (com.tencent.mm.plugin.radar.b.d.cdz() - com.tencent.mm.plugin.radar.b.d.pBm)) * 1.0f) / 1000.0f;
                        ab.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFirstFriendTimeSpent %s", Float.valueOf(cdz));
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        y yVar = y.AVH;
                        String format = String.format("%s", Arrays.copyOf(new Object[]{Float.valueOf(cdz)}, 1));
                        j.o(format, "java.lang.String.format(format, *args)");
                        hVar.X(10682, format);
                    }
                    com.tencent.mm.plugin.radar.b.d.cEX += size;
                    com.tencent.mm.plugin.radar.b.d.pBn = size + com.tencent.mm.plugin.radar.b.d.pBn;
                }
                AppMethodBeat.o(103087);
                return;
            }
            AppMethodBeat.o(103087);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
        /* JADX WARNING: Missing block: B:103:0x0372, code skipped:
            if (r1 == null) goto L_0x0374;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final View Y(View view, int i) {
            View view2;
            AppMethodBeat.i(103088);
            ab.d(RadarViewController.TAG, "getview RadarStatus%s", this.pEg.getRadarStatus());
            bpb bpb = this.pEi[i];
            if (bpb != null) {
                Object obj;
                CharSequence charSequence = bpb.jBB;
                if (charSequence == null || u.ar(charSequence)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    charSequence = bpb.wfK;
                    if (charSequence == null || u.ar(charSequence)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        obj = 1;
                        if (obj == null) {
                            View inflate;
                            g gVar = g.pDK;
                            String b = g.b(bpb);
                            com.tencent.mm.plugin.radar.b.e.e radarStatus = this.pEg.getRadarStatus();
                            if (view == null) {
                                inflate = View.inflate(this.context, R.layout.ami, null);
                                if (inflate == null) {
                                    j.dWJ();
                                }
                                inflate.setTag(this.pEg.pEa, Integer.valueOf(this.pEl.cdT()));
                                inflate.setTag(this.pEg.pEb, this.pEl.getInAnimation());
                                view2 = inflate;
                            } else {
                                view2 = view;
                            }
                            View findViewById = view2.findViewById(R.id.dtx);
                            a.v vVar;
                            if (findViewById == null) {
                                vVar = new a.v("null cannot be cast to non-null type android.widget.ImageView");
                                AppMethodBeat.o(103088);
                                throw vVar;
                            }
                            ImageView imageView = (ImageView) findViewById;
                            View findViewById2 = view2.findViewById(R.id.dtw);
                            if (findViewById2 == null) {
                                vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
                                AppMethodBeat.o(103088);
                                throw vVar;
                            }
                            RadarStateView radarStateView = (RadarStateView) findViewById2;
                            View findViewById3 = view2.findViewById(R.id.du0);
                            if (findViewById3 == null) {
                                vVar = new a.v("null cannot be cast to non-null type android.widget.TextView");
                                AppMethodBeat.o(103088);
                                throw vVar;
                            }
                            TextView textView = (TextView) findViewById3;
                            View findViewById4 = view2.findViewById(R.id.dty);
                            if (findViewById4 == null) {
                                vVar = new a.v("null cannot be cast to non-null type android.widget.ImageView");
                                AppMethodBeat.o(103088);
                                throw vVar;
                            }
                            ImageView imageView2 = (ImageView) findViewById4;
                            View findViewById5 = view2.findViewById(R.id.dtz);
                            if (findViewById5 == null) {
                                vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
                                AppMethodBeat.o(103088);
                                throw vVar;
                            }
                            RadarStateChooseView radarStateChooseView = (RadarStateChooseView) findViewById5;
                            imageView.setVisibility(0);
                            radarStateView.setVisibility(0);
                            textView.setVisibility(0);
                            imageView2.setVisibility(0);
                            if (radarStatus == com.tencent.mm.plugin.radar.b.e.e.SEARCHING || radarStatus == com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN) {
                                radarStateView.setVisibility(0);
                                radarStateChooseView.setVisibility(8);
                            } else {
                                radarStateView.setVisibility(8);
                                radarStateChooseView.setVisibility(0);
                            }
                            view2.setTag(new a(this, textView, imageView, radarStateView, radarStateChooseView, imageView2));
                            if (i == 7 || i % 3 == 1) {
                                inflate = view2.findViewById(R.id.du1);
                                j.o(inflate, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                                inflate.setVisibility(0);
                                inflate = view2.findViewById(R.id.dtv);
                                j.o(inflate, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                                inflate.setVisibility(8);
                            } else {
                                inflate = view2.findViewById(R.id.dtv);
                                j.o(inflate, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                                inflate.setVisibility(0);
                                inflate = view2.findViewById(R.id.du1);
                                j.o(inflate, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                                inflate.setVisibility(8);
                            }
                            if (view == null || view2 != view) {
                                this.pEn.put(b, view2);
                            }
                            obj = view2.getTag();
                            if (obj == null) {
                                vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                                AppMethodBeat.o(103088);
                                throw vVar;
                            }
                            a aVar = (a) obj;
                            aVar.pEp.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.pEg.getContext(), (CharSequence) bpb.jCH, aVar.pEp.getTextSize()));
                            com.tencent.mm.plugin.radar.ui.b.a aVar2 = com.tencent.mm.plugin.radar.ui.b.a.pCd;
                            com.tencent.mm.plugin.radar.ui.b.a.b(aVar.pEq, b);
                            View findViewById6 = view2.findViewById(R.id.dts);
                            j.o(findViewById6, "view.findViewById(R.id.radar_avatar_container)");
                            findViewById6.setTag(new d(this.pEg, bpb));
                            RadarStateView radarStateView2;
                            RadarStateChooseView radarStateChooseView2;
                            if (this.pEg.getRadarStatus() == com.tencent.mm.plugin.radar.b.e.e.SEARCHING || this.pEg.getRadarStatus() == com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN) {
                                aVar.pEt.setBackgroundResource(R.drawable.ze);
                                radarStateView2 = aVar.pEr;
                                radarStateView2.pDb = true;
                                radarStateView2.cdK();
                                radarStateChooseView2 = aVar.pEs;
                                radarStateChooseView2.pCV = false;
                                radarStateChooseView2.setVisibility(8);
                                com.tencent.mm.plugin.radar.b.c.e a = com.tencent.mm.plugin.radar.b.e.a(RadarViewController.c(this.pEg), bpb);
                                if (a == null) {
                                    a = this.pEg.pDU.Vx(b);
                                    com.tencent.mm.plugin.radar.b.e c = RadarViewController.c(this.pEg);
                                    j.p(bpb, "member");
                                    j.p(a, "state");
                                    String str = bpb.jBB;
                                    j.o(str, "member.UserName");
                                    c.b(str, a);
                                    str = bpb.wfK;
                                    j.o(str, "member.EncodeUserName");
                                    c.b(str, a);
                                }
                                Object a2 = RadarViewController.c(this.pEg).a(bpb, true);
                                RadarStateView radarStateView3 = aVar.pEr;
                                if (a2 == null) {
                                    a2 = com.tencent.mm.plugin.radar.b.c.e.Stranger;
                                }
                                j.p(a2, "state");
                                radarStateView3.init();
                                radarStateView3.pDc.removeMessages(0);
                                radarStateView3.clearAnimation();
                                radarStateView3.pBL = a2;
                                radarStateView3.pCS = false;
                                radarStateView3.cdK();
                                radarStateView3 = aVar.pEr;
                                j.p(a, "state");
                                radarStateView3.init();
                                ab.d(RadarStateView.TAG, " turnToState : ".concat(String.valueOf(a)));
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
                                    ab.d(RadarStateView.TAG, " delay : ".concat(String.valueOf(z)));
                                    radarStateView3.pBL = a;
                                    if (radarStateView3.pBL != com.tencent.mm.plugin.radar.b.c.e.Stranger) {
                                        if (z) {
                                            radarStateView3.pDc.sendEmptyMessageDelayed(0, (long) (RadarStateView.pDe + 20));
                                        } else {
                                            radarStateView3.pDc.sendEmptyMessage(0);
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.radar.b.e c2 = RadarViewController.c(this.pEg);
                                j.p(bpb, "member");
                                String str2 = bpb.jBB;
                                j.o(str2, "member.UserName");
                                c2.a(str2, null);
                                str2 = bpb.wfK;
                                j.o(str2, "member.EncodeUserName");
                                c2.a(str2, null);
                                if (i == 0) {
                                    this.pEm = this.pEk.size();
                                }
                                if (this.pEk.remove(b) != null) {
                                    this.pEl.g(this.pEm - this.pEk.size(), view2);
                                }
                                AppMethodBeat.o(103088);
                                return view2;
                            }
                            Map map = RadarViewController.c(this.pEg).pBv;
                            g gVar2 = g.pDK;
                            if (bo.isNullOrNil((String) map.get(g.c(bpb)))) {
                                view2 = Z(view, i);
                            } else {
                                com.tencent.mm.plugin.radar.b.e.a aVar3;
                                radarStateView2 = aVar.pEr;
                                radarStateView2.pDb = false;
                                radarStateView2.setVisibility(8);
                                radarStateChooseView2 = aVar.pEs;
                                radarStateChooseView2.pCV = true;
                                radarStateChooseView2.cdK();
                                com.tencent.mm.plugin.radar.b.e c3 = RadarViewController.c(this.pEg);
                                if (bpb != null) {
                                    gVar2 = g.pDK;
                                    aVar3 = (com.tencent.mm.plugin.radar.b.e.a) c3.pBz.get(g.b(bpb));
                                    if (aVar3 == null) {
                                        aVar3 = com.tencent.mm.plugin.radar.b.e.a.UnSelected;
                                    }
                                }
                                aVar3 = com.tencent.mm.plugin.radar.b.e.a.UnSelected;
                                if (aVar3 != com.tencent.mm.plugin.radar.b.e.a.UnSelected) {
                                    aVar.pEt.setBackgroundDrawable(null);
                                }
                                RadarStateChooseView radarStateChooseView3 = aVar.pEs;
                                j.p(aVar3, "status");
                                if (radarStateChooseView3.pCW != aVar3) {
                                    radarStateChooseView3.pCW = aVar3;
                                    switch (e.pCY[radarStateChooseView3.pCW.ordinal()]) {
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
                                g gVar3 = g.pDK;
                                if (hashMap.remove(g.c(bpb)) != null) {
                                    this.pEl.g(this.pEm - this.pEk.size(), view2);
                                }
                            }
                            AppMethodBeat.o(103088);
                            return view2;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                }
            }
            view2 = Z(view, i);
            AppMethodBeat.o(103088);
            return view2;
        }

        public final void clearAll() {
            AppMethodBeat.i(103089);
            this.pEk.clear();
            this.pEn.clear();
            for (String str : this.pEn.keySet()) {
                View view = (View) this.pEn.get(str);
                if (view != null) {
                    a aVar = this.pEl;
                    j.o(view, "it");
                    aVar.cf(view);
                }
            }
            aPw();
            AppMethodBeat.o(103089);
        }

        private final View Z(View view, int i) {
            AppMethodBeat.i(103090);
            if (view == null) {
                view = View.inflate(this.context, R.layout.ami, null);
                if (view == null) {
                    j.dWJ();
                }
                view.setTag(this.pEg.pEa, Integer.valueOf(this.pEl.cdT()));
                view.setTag(this.pEg.pEb, this.pEl.getInAnimation());
            }
            View findViewById = view.findViewById(R.id.dtx);
            j.o(findViewById, "anotherConvertView.findV…ar_result_item_avatar_iv)");
            findViewById.setVisibility(8);
            findViewById = view.findViewById(R.id.dty);
            j.o(findViewById, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
            findViewById.setVisibility(8);
            findViewById = view.findViewById(R.id.du0);
            j.o(findViewById, "anotherConvertView.findV…_result_item_username_tv)");
            findViewById.setVisibility(4);
            findViewById = view.findViewById(R.id.dtw);
            j.o(findViewById, "anotherConvertView.findV….radar_member_state_view)");
            findViewById.setVisibility(4);
            findViewById = view.findViewById(R.id.dtz);
            j.o(findViewById, "anotherConvertView.findV…member_state_choose_view)");
            findViewById.setVisibility(4);
            if (i == 7 || i % 3 == 1) {
                findViewById = view.findViewById(R.id.du1);
                j.o(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById.setVisibility(0);
                findViewById = view.findViewById(R.id.dtv);
                j.o(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById.setVisibility(8);
            } else {
                findViewById = view.findViewById(R.id.dtv);
                j.o(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById.setVisibility(0);
                findViewById = view.findViewById(R.id.du1);
                j.o(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById.setVisibility(8);
            }
            AppMethodBeat.o(103090);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
        /* JADX WARNING: Missing block: B:13:0x0026, code skipped:
            if (r0 != null) goto L_0x0028;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(bpb bpb) {
            Object obj;
            AppMethodBeat.i(103091);
            if (bpb != null) {
                CharSequence charSequence = bpb.jBB;
                if (charSequence == null || u.ar(charSequence)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    charSequence = bpb.wfK;
                    if (charSequence == null || u.ar(charSequence)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                obj = null;
                if (obj == null) {
                    AppMethodBeat.o(103091);
                    return;
                }
                g gVar = g.pDK;
                if (bpb == null) {
                    j.dWJ();
                }
                obj = g.b(bpb);
                if (RadarViewController.c(this.pEg).pBv.containsKey(obj)) {
                    obj = RadarViewController.c(this.pEg).pBv.get(obj);
                    if (obj == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(103091);
                        throw vVar;
                    }
                    obj = (String) obj;
                }
                this.pEj.put(obj, obj);
                AppMethodBeat.o(103091);
                return;
            }
            obj = 1;
            if (obj == null) {
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$TagItem;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "plugin-radar_release"})
    public final class d {
        private bpb pBK;
        final /* synthetic */ RadarViewController pEg;

        public d(RadarViewController radarViewController, bpb bpb) {
            j.p(bpb, "member");
            this.pEg = radarViewController;
            AppMethodBeat.i(103093);
            this.pBK = bpb;
            AppMethodBeat.o(103093);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements OnClickListener {
        final /* synthetic */ RadarViewController pEg;

        f(RadarViewController radarViewController) {
            this.pEg = radarViewController;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(103097);
            if (this.pEg.getRadarStatus() == com.tencent.mm.plugin.radar.b.e.e.SEARCHING || this.pEg.getRadarStatus() == com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN) {
                Context context = this.pEg.getContext();
                if (context == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(103097);
                    throw vVar;
                }
                ((Activity) context).finish();
                AppMethodBeat.o(103097);
                return;
            }
            RadarViewController radarViewController = this.pEg;
            c d = RadarViewController.d(this.pEg);
            LinkedList linkedList = new LinkedList();
            for (Object obj : d.pEi) {
                if (obj != null) {
                    linkedList.add(obj);
                }
            }
            if (RadarViewController.a(radarViewController, linkedList)) {
                RadarViewController.f(this.pEg).cdU();
                RadarViewController.f(this.pEg).setVisibility(0);
                RadarViewController.c(this.pEg).cdA();
                RadarViewController.a(this.pEg, com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN);
            } else {
                RadarViewController.a(this.pEg, com.tencent.mm.plugin.radar.b.e.e.SEARCHING);
            }
            RadarViewController.d(this.pEg).aPw();
            AppMethodBeat.o(103097);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator;", "", "(Lcom/tencent/mm/plugin/radar/ui/RadarViewController;)V", "AvatarTagIndex", "", "delayShowHandler", "com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1;", "inAnimation", "Landroid/view/animation/Animation;", "getInAnimation", "()Landroid/view/animation/Animation;", "isNotXHDPI", "", "uniqueTag", "getUniqueTag", "()I", "calcDelay", "index", "cancel", "", "view", "Landroid/view/View;", "getAnimationTag", "init", "show", "plugin-radar_release"})
    final class a {
        private int pEd;
        final boolean pEe;
        private final a pEf = new a(this);

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarViewController$AvatarAnimator$delayShowHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
        public static final class a extends ak {
            final /* synthetic */ a pEh;

            a(a aVar) {
                this.pEh = aVar;
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.i(103080);
                j.p(message, "msg");
                if (message.obj instanceof View) {
                    Object obj = message.obj;
                    if (obj == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(103080);
                        throw vVar;
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
                AppMethodBeat.o(103080);
            }
        }

        public a() {
            AppMethodBeat.i(103085);
            g gVar = g.pDK;
            Context context = RadarViewController.this.getContext();
            j.o(context, "context");
            this.pEe = g.eJ(context);
            AppMethodBeat.o(103085);
        }

        public final Animation getInAnimation() {
            AppMethodBeat.i(103081);
            Animation loadAnimation = AnimationUtils.loadAnimation(RadarViewController.this.getContext(), R.anim.cp);
            j.o(loadAnimation, "AnimationUtils.loadAnima…anim.radar_user_turn_out)");
            AppMethodBeat.o(103081);
            return loadAnimation;
        }

        public final int cdT() {
            this.pEd++;
            return this.pEd;
        }

        public final void g(int i, View view) {
            AppMethodBeat.i(103082);
            j.p(view, "view");
            Message obtainMessage = this.pEf.obtainMessage();
            obtainMessage.what = dr(view);
            obtainMessage.obj = view;
            view.setVisibility(4);
            this.pEf.sendMessageDelayed(obtainMessage, (long) ((i + 1) * 500));
            AppMethodBeat.o(103082);
        }

        public final void cf(View view) {
            AppMethodBeat.i(103083);
            j.p(view, "view");
            int dr = dr(view);
            if (dr > 0) {
                this.pEf.removeMessages(dr);
            }
            view.clearAnimation();
            AppMethodBeat.o(103083);
        }

        private final int dr(View view) {
            AppMethodBeat.i(103084);
            Object tag = view.getTag(RadarViewController.this.pEa);
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            if (num != null) {
                int intValue = num.intValue();
                AppMethodBeat.o(103084);
                return intValue;
            }
            AppMethodBeat.o(103084);
            return -1;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarViewController$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarViewController$prepareGrid$1", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
    public static final class h implements com.tencent.mm.plugin.radar.ui.RadarSpecialGridView.a {
        final /* synthetic */ RadarViewController pEg;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ bpb pCz;
            final /* synthetic */ h pEw;
            final /* synthetic */ View pEx;
            final /* synthetic */ com.tencent.mm.plugin.radar.b.c.e pEy;

            a(h hVar, View view, bpb bpb, com.tencent.mm.plugin.radar.b.c.e eVar) {
                this.pEw = hVar;
                this.pEx = view;
                this.pCz = bpb;
                this.pEy = eVar;
            }

            public final void run() {
                AppMethodBeat.i(103099);
                RadarViewController.g(this.pEw.pEg).a(this.pEx, this.pCz, this.pEy);
                RadarViewController.f(this.pEw.pEg).cdV();
                AppMethodBeat.o(103099);
            }
        }

        h(RadarViewController radarViewController) {
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
        public final void f(int i, View view) {
            int i2 = 0;
            AppMethodBeat.i(103100);
            j.p(view, "view");
            bpb bpb = RadarViewController.d(this.pEg).pEi[i];
            if (bpb == null) {
                AppMethodBeat.o(103100);
                return;
            }
            g gVar;
            CharSequence charSequence;
            int i3;
            Object tag;
            a.v vVar;
            switch (h.pCY[this.pEg.getRadarStatus().ordinal()]) {
                case 1:
                case 2:
                    gVar = g.pDK;
                    String b = g.b(bpb);
                    if (bpb != null) {
                        charSequence = bpb.jBB;
                        if (charSequence == null || u.ar(charSequence)) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            charSequence = bpb.wfK;
                            if (charSequence != null && !u.ar(charSequence)) {
                                i3 = 0;
                                break;
                            } else {
                                i3 = 1;
                                break;
                            }
                        }
                        if (i2 == 0) {
                            View view2 = (View) RadarViewController.d(this.pEg).pEn.get(b);
                            com.tencent.mm.plugin.radar.b.c.e a = com.tencent.mm.plugin.radar.b.e.a(RadarViewController.c(this.pEg), bpb);
                            if (view2 == null || a == com.tencent.mm.plugin.radar.b.c.e.Stranger) {
                                RadarViewController.g(this.pEg).a(view, bpb, a);
                                RadarViewController.f(this.pEg).cdV();
                                AppMethodBeat.o(103100);
                                return;
                            }
                            tag = view2.getTag();
                            if (tag == null) {
                                vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                                AppMethodBeat.o(103100);
                                throw vVar;
                            }
                            ((a) tag).pEr.cdM();
                            ak akVar = new ak();
                            Runnable aVar = new a(this, view, bpb, a);
                            com.tencent.mm.plugin.radar.ui.RadarStateView.a aVar2 = RadarStateView.pDf;
                            akVar.postDelayed(aVar, (long) RadarStateView.pDe);
                            AppMethodBeat.o(103100);
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
                        if (charSequence == null || u.ar(charSequence)) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            charSequence = bpb.wfK;
                            if (charSequence != null && !u.ar(charSequence)) {
                                i3 = 0;
                                break;
                            } else {
                                i3 = 1;
                                break;
                            }
                        }
                        i3 = 0;
                        if (i3 == 0) {
                            c d = RadarViewController.d(this.pEg);
                            if (bpb != null) {
                                gVar = g.pDK;
                                tag = g.b(bpb);
                                if (RadarViewController.c(d.pEg).pBv.containsKey(tag)) {
                                    tag = RadarViewController.c(d.pEg).pBv.get(tag);
                                    if (tag == null) {
                                        vVar = new a.v("null cannot be cast to non-null type kotlin.String");
                                        AppMethodBeat.o(103100);
                                        throw vVar;
                                    }
                                    tag = (String) tag;
                                }
                                if (d.pEj.containsKey(tag)) {
                                    i3 = 1;
                                    if (i3 != 0) {
                                        RadarViewController.d(this.pEg).d(bpb);
                                    } else {
                                        d = RadarViewController.d(this.pEg);
                                        if (bpb != null) {
                                            charSequence = bpb.jBB;
                                            if (charSequence == null || u.ar(charSequence)) {
                                                i3 = 1;
                                            } else {
                                                i3 = 0;
                                            }
                                            if (i3 != 0) {
                                                charSequence = bpb.wfK;
                                                if (charSequence != null && !u.ar(charSequence)) {
                                                    i3 = 0;
                                                    break;
                                                } else {
                                                    i3 = 1;
                                                    break;
                                                }
                                            }
                                            i3 = 0;
                                            if (i3 == 0) {
                                                gVar = g.pDK;
                                                if (bpb == null) {
                                                    j.dWJ();
                                                }
                                                tag = g.b(bpb);
                                                if (RadarViewController.c(d.pEg).pBv.containsKey(tag)) {
                                                    tag = RadarViewController.c(d.pEg).pBv.get(tag);
                                                    if (tag == null) {
                                                        vVar = new a.v("null cannot be cast to non-null type kotlin.String");
                                                        AppMethodBeat.o(103100);
                                                        throw vVar;
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
                        RadarViewController.c(this.pEg).a(bpb);
                        RadarViewController.cdS();
                        RadarViewController.d(this.pEg).aPw();
                        AppMethodBeat.o(103100);
                        return;
                    }
                    i3 = 1;
                    if (i3 == 0) {
                    }
                    RadarViewController.c(this.pEg).a(bpb);
                    RadarViewController.cdS();
                    RadarViewController.d(this.pEg).aPw();
                    AppMethodBeat.o(103100);
                    return;
                default:
                    ab.d(RadarViewController.TAG, "unknow status for grid view %s", this.pEg.getRadarStatus());
                    break;
            }
            AppMethodBeat.o(103100);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    static final class g implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarViewController pEg;

        g(RadarViewController radarViewController) {
            this.pEg = radarViewController;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(103098);
            com.tencent.mm.modelgeo.d.bX(this.pEg.getContext());
            AppMethodBeat.o(103098);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends a.f.b.k implements a.f.a.a<RadarWaveView> {
        final /* synthetic */ RadarViewController pEg;

        i(RadarViewController radarViewController) {
            this.pEg = radarViewController;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(103101);
            Context context = this.pEg.getContext();
            if (context == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(103101);
                throw vVar;
            }
            RadarWaveView radarWaveView = (RadarWaveView) ((Activity) context).findViewById(R.id.du7);
            AppMethodBeat.o(103101);
            return radarWaveView;
        }
    }

    private final TextView getNewRadarTip() {
        AppMethodBeat.i(103107);
        TextView textView = (TextView) this.pDP.getValue();
        AppMethodBeat.o(103107);
        return textView;
    }

    private final ProgressBar getNewRadarTipLoading() {
        AppMethodBeat.i(103108);
        ProgressBar progressBar = (ProgressBar) this.pDQ.getValue();
        AppMethodBeat.o(103108);
        return progressBar;
    }

    private final View getRadarBgMask() {
        AppMethodBeat.i(103110);
        View view = (View) this.pDS.getValue();
        AppMethodBeat.o(103110);
        return view;
    }

    /* Access modifiers changed, original: final */
    public final RadarSpecialGridView getGrid() {
        AppMethodBeat.i(103105);
        RadarSpecialGridView radarSpecialGridView = (RadarSpecialGridView) this.pDN.getValue();
        AppMethodBeat.o(103105);
        return radarSpecialGridView;
    }

    /* Access modifiers changed, original: final */
    public final RadarMemberView getMemberDetailView() {
        AppMethodBeat.i(103104);
        RadarMemberView radarMemberView = (RadarMemberView) this.pDM.getValue();
        AppMethodBeat.o(103104);
        return radarMemberView;
    }

    /* Access modifiers changed, original: final */
    public final Button getQuitBtn() {
        AppMethodBeat.i(103109);
        Button button = (Button) this.pDR.getValue();
        AppMethodBeat.o(103109);
        return button;
    }

    /* Access modifiers changed, original: final */
    public final RadarTipsView getRadarTips() {
        AppMethodBeat.i(103106);
        RadarTipsView radarTipsView = (RadarTipsView) this.pDO.getValue();
        AppMethodBeat.o(103106);
        return radarTipsView;
    }

    /* Access modifiers changed, original: final */
    public final RadarWaveView getWaveView() {
        AppMethodBeat.i(103103);
        RadarWaveView radarWaveView = (RadarWaveView) this.pDL.getValue();
        AppMethodBeat.o(103103);
        return radarWaveView;
    }

    public RadarViewController(Context context, AttributeSet attributeSet) {
        j.p(context, "mContext");
        super(context, attributeSet);
        AppMethodBeat.i(103126);
        com.tencent.mm.plugin.radar.b.e.d dVar = this;
        Context applicationContext = context.getApplicationContext();
        j.o(applicationContext, "mContext.getApplicationContext()");
        this.pDT = new com.tencent.mm.plugin.radar.b.e(dVar, applicationContext);
        this.pDU = new com.tencent.mm.plugin.radar.b.c(this, context);
        AppMethodBeat.o(103126);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.radar.b.e c(RadarViewController radarViewController) {
        AppMethodBeat.i(103127);
        com.tencent.mm.plugin.radar.b.e eVar = radarViewController.pDT;
        if (eVar == null) {
            j.avw("radarManager");
        }
        AppMethodBeat.o(103127);
        return eVar;
    }

    public static final /* synthetic */ void cdS() {
    }

    public static final /* synthetic */ c d(RadarViewController radarViewController) {
        AppMethodBeat.i(103128);
        c cVar = radarViewController.pDV;
        if (cVar == null) {
            j.avw("adapter");
        }
        AppMethodBeat.o(103128);
        return cVar;
    }

    public static final /* synthetic */ RadarWaveView f(RadarViewController radarViewController) {
        AppMethodBeat.i(103130);
        RadarWaveView waveView = radarViewController.getWaveView();
        AppMethodBeat.o(103130);
        return waveView;
    }

    public static final /* synthetic */ RadarMemberView g(RadarViewController radarViewController) {
        AppMethodBeat.i(103131);
        RadarMemberView memberDetailView = radarViewController.getMemberDetailView();
        AppMethodBeat.o(103131);
        return memberDetailView;
    }

    private final void setRadarStatus(com.tencent.mm.plugin.radar.b.e.e eVar) {
        this.pDW = eVar;
    }

    public final com.tencent.mm.plugin.radar.b.e.e getRadarStatus() {
        return this.pDW;
    }

    public final void onResume() {
        AppMethodBeat.i(103111);
        com.tencent.mm.plugin.radar.b.e eVar = this.pDT;
        if (eVar == null) {
            j.avw("radarManager");
        }
        eVar.onResume();
        AppMethodBeat.o(103111);
    }

    public final void cdA() {
        AppMethodBeat.i(103112);
        com.tencent.mm.plugin.radar.b.e eVar = this.pDT;
        if (eVar == null) {
            j.avw("radarManager");
        }
        eVar.cdA();
        AppMethodBeat.o(103112);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(103113);
        j.p(keyEvent, "event");
        if (i == 4 && getMemberDetailView().isShowing()) {
            getMemberDetailView().dismiss();
            AppMethodBeat.o(103113);
            return true;
        }
        AppMethodBeat.o(103113);
        return false;
    }

    private final void d(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        AppMethodBeat.i(103114);
        com.tencent.mm.plugin.radar.b.e eVar2 = this.pDT;
        if (eVar2 == null) {
            j.avw("radarManager");
        }
        if (str == null) {
            j.dWJ();
        }
        com.tencent.mm.plugin.radar.b.c.e Vy = eVar2.Vy(str);
        if (!(Vy == null || Vy == eVar)) {
            eVar2 = this.pDT;
            if (eVar2 == null) {
                j.avw("radarManager");
            }
            eVar2.b(str, eVar);
            c cVar = this.pDV;
            if (cVar == null) {
                j.avw("adapter");
            }
            cVar.aPw();
        }
        AppMethodBeat.o(103114);
    }

    public final void a(boolean z, boolean z2, String str, String str2, long j) {
        com.tencent.mm.plugin.radar.b.e eVar;
        AppMethodBeat.i(103115);
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.Added);
        } else if (z2) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.Verifying);
        } else {
            RadarTipsView radarTips = getRadarTips();
            if (str == null) {
                str = "";
            }
            radarTips.Vz(str);
            eVar = this.pDT;
            if (eVar == null) {
                j.avw("radarManager");
            }
            com.tencent.mm.plugin.radar.b.e.c cVar = (com.tencent.mm.plugin.radar.b.e.c) eVar.pBy.get(Long.valueOf(j));
            if (cVar != null) {
                g gVar = g.pDK;
                d(g.b(cVar.pBK), cVar.pBL);
                gVar = g.pDK;
                d(g.c(cVar.pBK), cVar.pBL);
            }
        }
        eVar = this.pDT;
        if (eVar == null) {
            j.avw("radarManager");
        }
        eVar.pBy.remove(Long.valueOf(j));
        AppMethodBeat.o(103115);
    }

    public final void a(boolean z, String str, String str2, long j) {
        com.tencent.mm.plugin.radar.b.e eVar;
        AppMethodBeat.i(103116);
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.Added);
        } else {
            RadarTipsView radarTips = getRadarTips();
            if (str == null) {
                str = "";
            }
            radarTips.Vz(str);
            eVar = this.pDT;
            if (eVar == null) {
                j.avw("radarManager");
            }
            com.tencent.mm.plugin.radar.b.e.c cVar = (com.tencent.mm.plugin.radar.b.e.c) eVar.pBy.get(Long.valueOf(j));
            if (cVar != null) {
                g gVar = g.pDK;
                d(g.b(cVar.pBK), cVar.pBL);
            }
        }
        eVar = this.pDT;
        if (eVar == null) {
            j.avw("radarManager");
        }
        eVar.pBy.remove(Long.valueOf(j));
        AppMethodBeat.o(103116);
    }

    public final void R(ad adVar) {
        AppMethodBeat.i(103117);
        j.p(adVar, "contact");
        com.tencent.mm.plugin.radar.b.e eVar = this.pDT;
        if (eVar == null) {
            j.avw("radarManager");
        }
        String username = adVar.getUsername();
        j.o(username, "contact.username");
        if (eVar.Vy(username) == null) {
            eVar = this.pDT;
            if (eVar == null) {
                j.avw("radarManager");
            }
            username = adVar.Hv();
            j.o(username, "contact.encryptUsername");
            if (eVar.Vy(username) == null) {
                LinkedList linkedList = new LinkedList();
                username = adVar.getUsername();
                j.o(username, "contact.username");
                String Hv = adVar.Hv();
                j.o(Hv, "contact.encryptUsername");
                String Hs = adVar.Hs();
                j.o(Hs, "contact.nickname");
                bpb bpb = new bpb();
                bpb.wRw = 100;
                bpb.jBB = username;
                bpb.jCH = Hs;
                bpb.SmallImgUrl = "";
                bpb.wfK = Hv;
                linkedList.add(bpb);
                aj(linkedList);
            }
        }
        if (getMemberDetailView().isShowing()) {
            RadarMemberView memberDetailView = getMemberDetailView();
            username = adVar.Hv();
            j.o(username, "contact.encryptUsername");
            memberDetailView.c(username, com.tencent.mm.plugin.radar.b.c.e.NeedVerify);
        }
        d(adVar.getUsername(), com.tencent.mm.plugin.radar.b.c.e.NeedVerify);
        d(adVar.Hv(), com.tencent.mm.plugin.radar.b.c.e.NeedVerify);
        AppMethodBeat.o(103117);
    }

    public final void Q(ad adVar) {
        AppMethodBeat.i(103118);
        j.p(adVar, "contact");
        if (getMemberDetailView().isShowing()) {
            RadarMemberView memberDetailView = getMemberDetailView();
            String Hv = adVar.Hv();
            j.o(Hv, "contact.encryptUsername");
            memberDetailView.c(Hv, com.tencent.mm.plugin.radar.b.c.e.Added);
        }
        d(adVar.getUsername(), com.tencent.mm.plugin.radar.b.c.e.Added);
        d(adVar.Hv(), com.tencent.mm.plugin.radar.b.c.e.Added);
        AppMethodBeat.o(103118);
    }

    public final void ka(boolean z) {
        AppMethodBeat.i(103119);
        if (!z) {
            RadarTipsView radarTips = getRadarTips();
            String string = getContext().getString(R.string.dh_);
            j.o(string, "context.getString(R.stri….radar_tips_location_err)");
            radarTips.Vz(string);
            if (!(this.nPX || com.tencent.mm.modelgeo.d.agA())) {
                this.nPX = true;
                com.tencent.mm.ui.base.h.a(getContext(), getContext().getString(R.string.c9z), getContext().getString(R.string.tz), getContext().getString(R.string.ckr), getContext().getString(R.string.or), false, (DialogInterface.OnClickListener) new g(this), null);
            }
        }
        AppMethodBeat.o(103119);
    }

    public final void a(int i, int i2, LinkedList<bpb> linkedList) {
        AppMethodBeat.i(103120);
        if (i == 0 && i2 == 0) {
            aj(linkedList);
            AppMethodBeat.o(103120);
            return;
        }
        ab.e(TAG, "radar member return error : %s, type : %s ", Integer.valueOf(i2), Integer.valueOf(i));
        RadarTipsView radarTips;
        String string;
        if (2 == i) {
            radarTips = getRadarTips();
            string = getContext().getString(R.string.d5l);
            j.o(string, "context.getString(R.string.net_warn_no_network)");
            radarTips.Vz(string);
            AppMethodBeat.o(103120);
            return;
        }
        radarTips = getRadarTips();
        string = getContext().getString(R.string.dha);
        j.o(string, "context.getString(R.string.radar_tips_network_err)");
        radarTips.Vz(string);
        AppMethodBeat.o(103120);
    }

    public final void b(int i, int i2, LinkedList<boy> linkedList) {
        int i3 = 0;
        AppMethodBeat.i(103121);
        if (i == 0 && i2 == 0 && linkedList != null) {
            a(com.tencent.mm.plugin.radar.b.e.e.RALATIONCHAIN_RETRUN);
            c cVar = this.pDV;
            if (cVar == null) {
                j.avw("adapter");
            }
            c(cVar.pEg).pBz.clear();
            c(cVar.pEg).pBv.clear();
            cVar.pEj.clear();
            cVar.pEk.clear();
            LinkedList linkedList2 = null;
            if (linkedList != null && linkedList.size() > 0) {
                int i4;
                LinkedList linkedList3 = new LinkedList();
                int size = linkedList.size();
                for (i4 = 0; i4 < size; i4++) {
                    Object obj = linkedList.get(i4);
                    j.o(obj, "radarChatMember[i]");
                    boy boy = (boy) obj;
                    boz boz = new boz();
                    boz.wRv = boy.jBB;
                    linkedList3.add(boz);
                    Map map = c(cVar.pEg).pBv;
                    String str = boy.wfK;
                    j.o(str, "radarchatroomMember.EncodeUserName");
                    String str2 = boy.jBB;
                    j.o(str2, "radarchatroomMember.UserName");
                    map.put(str, str2);
                    HashMap hashMap = cVar.pEk;
                    g gVar = g.pDK;
                    hashMap.put(g.a(boy), Integer.valueOf(0));
                }
                i4 = cVar.pEi.length;
                while (i3 < i4) {
                    bpb bpb = cVar.pEi[i3];
                    Map map2 = c(cVar.pEg).pBv;
                    g gVar2 = g.pDK;
                    if (!bo.isNullOrNil((String) map2.get(g.c(bpb)))) {
                        d(cVar.pEg).d(bpb);
                        c(cVar.pEg).a(bpb);
                    }
                    i3++;
                }
                linkedList2 = linkedList3;
            }
            c(cVar.pEg).pBu = linkedList2;
            c cVar2 = this.pDV;
            if (cVar2 == null) {
                j.avw("adapter");
            }
            cVar2.aPw();
            AppMethodBeat.o(103121);
            return;
        }
        a(com.tencent.mm.plugin.radar.b.e.e.SEARCHING);
        RadarTipsView radarTips = getRadarTips();
        String string = getContext().getString(R.string.dha);
        j.o(string, "context.getString(R.string.radar_tips_network_err)");
        radarTips.Vz(string);
        AppMethodBeat.o(103121);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aj(LinkedList<bpb> linkedList) {
        c cVar;
        AppMethodBeat.i(103122);
        if (linkedList == null) {
            j.dWJ();
        }
        if (linkedList.size() == 0) {
            c cVar2 = this.pDV;
            if (cVar2 == null) {
                j.avw("adapter");
            }
            if (cVar2.getCount() == 0) {
                getRadarTips().setNoMember(true);
                ab.d(TAG, "members got, size : " + linkedList.size());
                ab.d(TAG, "has friend:%s", String.valueOf(ak(linkedList)));
                cVar = this.pDV;
                if (cVar == null) {
                    j.avw("adapter");
                }
                cVar.al(linkedList);
                if (this.pDX && r0) {
                    a(com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN);
                }
                AppMethodBeat.o(103122);
            }
        }
        getRadarTips().setNoMember(false);
        ab.d(TAG, "members got, size : " + linkedList.size());
        ab.d(TAG, "has friend:%s", String.valueOf(ak(linkedList)));
        cVar = this.pDV;
        if (cVar == null) {
        }
        cVar.al(linkedList);
        a(com.tencent.mm.plugin.radar.b.e.e.SEARCH_RETRUN);
        AppMethodBeat.o(103122);
    }

    private final boolean ak(LinkedList<bpb> linkedList) {
        AppMethodBeat.i(103123);
        boolean z = false;
        if (linkedList == null) {
            j.dWJ();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.radar.b.c.e Vx;
            boolean z2;
            bpb bpb = (bpb) it.next();
            com.tencent.mm.plugin.radar.b.e eVar = this.pDT;
            if (eVar == null) {
                j.avw("radarManager");
            }
            j.o(bpb, "member");
            com.tencent.mm.plugin.radar.b.c.e a = com.tencent.mm.plugin.radar.b.e.a(eVar, bpb);
            if (a == null) {
                g gVar = g.pDK;
                String b = g.b(bpb);
                Vx = this.pDU.Vx(b);
                com.tencent.mm.plugin.radar.b.e eVar2 = this.pDT;
                if (eVar2 == null) {
                    j.avw("radarManager");
                }
                eVar2.b(b, Vx);
            } else {
                Vx = a;
            }
            if (Vx == com.tencent.mm.plugin.radar.b.c.e.Added) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        AppMethodBeat.o(103123);
        return z;
    }

    private final void a(com.tencent.mm.plugin.radar.b.e.e eVar) {
        AppMethodBeat.i(103124);
        this.pDW = eVar;
        com.tencent.mm.plugin.radar.b.e eVar2;
        switch (h.pEv[eVar.ordinal()]) {
            case 1:
                getRadarBgMask().setVisibility(8);
                getQuitBtn().setText(R.string.dh5);
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText("");
                getWaveView().cdU();
                getWaveView().setVisibility(0);
                eVar2 = this.pDT;
                if (eVar2 == null) {
                    j.avw("radarManager");
                }
                eVar2.cdA();
                AppMethodBeat.o(103124);
                return;
            case 2:
                getRadarBgMask().setVisibility(8);
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText("");
                AppMethodBeat.o(103124);
                return;
            case 3:
                cdR();
                getQuitBtn().setText(R.string.or);
                eVar2 = this.pDT;
                if (eVar2 == null) {
                    j.avw("radarManager");
                }
                eVar2.cdB();
                getNewRadarTipLoading().setVisibility(0);
                getNewRadarTip().setText(R.string.dh7);
                getWaveView().cdV();
                getWaveView().setVisibility(4);
                getGrid().setVisibility(4);
                c cVar = this.pDV;
                if (cVar == null) {
                    j.avw("adapter");
                }
                cVar.clearAll();
                AppMethodBeat.o(103124);
                return;
            case 4:
                getRadarBgMask().setVisibility(0);
                eVar2 = this.pDT;
                if (eVar2 == null) {
                    j.avw("radarManager");
                }
                eVar2.cdB();
                getNewRadarTipLoading().setVisibility(8);
                getNewRadarTip().setText(R.string.dgw);
                getGrid().setVisibility(0);
                AppMethodBeat.o(103124);
                return;
            case 5:
                getRadarBgMask().setVisibility(8);
                eVar2 = this.pDT;
                if (eVar2 == null) {
                    j.avw("radarManager");
                }
                eVar2.cdB();
                getNewRadarTipLoading().setVisibility(0);
                getNewRadarTip().setText(R.string.dgx);
                break;
        }
        AppMethodBeat.o(103124);
    }

    private final void cdR() {
        AppMethodBeat.i(103125);
        if (getRadarBgMask().getVisibility() != 0) {
            getRadarBgMask().setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.ci));
            getRadarBgMask().setVisibility(0);
        }
        AppMethodBeat.o(103125);
    }

    static {
        AppMethodBeat.i(103102);
        AppMethodBeat.o(103102);
    }
}
