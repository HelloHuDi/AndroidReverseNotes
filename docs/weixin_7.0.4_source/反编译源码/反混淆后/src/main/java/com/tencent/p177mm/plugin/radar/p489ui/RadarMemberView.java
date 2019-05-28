package com.tencent.p177mm.plugin.radar.p489ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6980m;
import com.tencent.p177mm.plugin.radar.p488b.C43413c.C21556e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.bpb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Arrays;
import p000a.C0220l;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p005f.p007b.C8001y;
import p000a.p010i.C31815k;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006*\u00010\u0018\u0000 c2\u00020\u0001:\u0002cdB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010T\u001a\u00020+H\u0002J\u0006\u0010U\u001a\u00020VJ\b\u0010W\u001a\u00020VH\u0002J\u0010\u0010X\u001a\u00020V2\u0006\u00108\u001a\u000209H\u0002J \u0010Y\u001a\u00020V2\u0006\u0010Z\u001a\u00020\u00142\u0006\u00108\u001a\u0002092\b\u0010H\u001a\u0004\u0018\u00010IJ\b\u0010[\u001a\u00020VH\u0002J\u000e\u0010\\\u001a\u00020V2\u0006\u00104\u001a\u000205J\u0010\u0010]\u001a\u00020V2\u0006\u0010^\u001a\u00020_H\u0002J\u001c\u0010`\u001a\u00020V2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0016\u0010a\u001a\u00020V2\u0006\u0010b\u001a\u00020_2\u0006\u0010H\u001a\u00020IR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0019\u0010\u0016R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u0012\u001a\u0004\b-\u0010$R\u0010\u0010/\u001a\u000200X\u0004¢\u0006\u0004\n\u0002\u00101R\u0011\u00102\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b@\u0010\u0012\u001a\u0004\b?\u0010$R\u001b\u0010A\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\bC\u0010\u0012\u001a\u0004\bB\u0010\u001fR\u001b\u0010D\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\bF\u0010\u0012\u001a\u0004\bE\u0010$R\u0010\u0010G\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView */
public final class RadarMemberView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarMemberView.class), "avatarHolder", "getAvatarHolder()Landroid/view/View;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarMemberView.class), "avatarCopy", "getAvatarCopy()Landroid/widget/ImageView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarMemberView.class), "avatarCopyContainer", "getAvatarCopyContainer()Landroid/view/View;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarMemberView.class), "confirmBtn", "getConfirmBtn()Landroid/widget/Button;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarMemberView.class), "confirmBtnDisabled", "getConfirmBtnDisabled()Landroid/widget/TextView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarMemberView.class), "memberNameTv", "getMemberNameTv()Landroid/widget/TextView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarMemberView.class), "modifyNameBtn", "getModifyNameBtn()Landroid/widget/Button;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarMemberView.class), "sayHiTv", "getSayHiTv()Landroid/widget/TextView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(RadarMemberView.class), "exposeTv", "getExposeTv()Landroid/widget/TextView;"))};
    private static final int pCv = 0;
    private static final int pCw = 1;
    public static final C3674a pCx = new C3674a();
    private C7616ad ehM;
    private View gub;
    private C5653c gud;
    private TextView mJS;
    private bpb pBK;
    private C21556e pBL;
    private View pCe;
    private final C44856f pCf = C46153i.m86149aa(this, 2131826785);
    private final C44856f pCg = C46153i.m86149aa(this, 2131826789);
    private final C44856f pCh = C46153i.m86149aa(this, 2131826788);
    private final C44856f pCi = C46153i.m86149aa(this, 2131826784);
    private final C44856f pCj = C46153i.m86149aa(this, 2131826783);
    private final C44856f pCk = C46153i.m86149aa(this, 2131826786);
    private final C44856f pCl = C46153i.m86149aa(this, 2131826787);
    private final C44856f pCm = C46153i.m86149aa(this, 2131826782);
    private int[] pCn;
    private final C44856f pCo = C46153i.m86149aa(this, 2131826790);
    private boolean pCp;
    private C7575bv pCq;
    private C3675b pCr;
    private final OnClickListener pCs = new C28789h(this);
    private final C34767d pCt = new C34767d(this);
    private TextView pCu;
    private EditText pwu;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$Companion;", "", "()V", "ANIMATION_DISMISS_END", "", "ANIMATION_POPUP_END", "TAG", "", "showVKB", "", "ac", "Landroid/app/Activity;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$a */
    public static final class C3674a {
        private C3674a() {
        }

        public /* synthetic */ C3674a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$b */
    public interface C3675b {
        /* renamed from: a */
        void mo8283a(bpb bpb, C21556e c21556e);

        /* renamed from: b */
        void mo8284b(bpb bpb, C21556e c21556e);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$c */
    public static final class C3676c implements AnimationListener {
        final /* synthetic */ RadarMemberView pCy;

        C3676c(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(102947);
            C25052j.m39376p(animation, "animation");
            AppMethodBeat.m2505o(102947);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.m2504i(102948);
            C25052j.m39376p(animation, "animation");
            AppMethodBeat.m2505o(102948);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(102949);
            C25052j.m39376p(animation, "animation");
            C4990ab.m7410d(RadarMemberView.TAG, "dismiss animation end");
            this.pCy.pCp = false;
            this.pCy.pCt.sendEmptyMessage(RadarMemberView.pCw);
            AppMethodBeat.m2505o(102949);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$i */
    public static final class C12931i implements AnimationListener {
        final /* synthetic */ RadarMemberView pCy;

        C12931i(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(102955);
            C25052j.m39376p(animation, "animation");
            AppMethodBeat.m2505o(102955);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.m2504i(102956);
            C25052j.m39376p(animation, "animation");
            AppMethodBeat.m2505o(102956);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(102957);
            C25052j.m39376p(animation, "animation");
            C4990ab.m7410d(RadarMemberView.TAG, "popup animation end");
            this.pCy.pCt.sendEmptyMessage(RadarMemberView.pCv);
            AppMethodBeat.m2505o(102957);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$j */
    public static final class C12932j implements TextWatcher {
        final /* synthetic */ RadarMemberView pCy;

        C12932j(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(102958);
            C25052j.m39376p(charSequence, "s");
            AppMethodBeat.m2505o(102958);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(102959);
            C25052j.m39376p(charSequence, "s");
            AppMethodBeat.m2505o(102959);
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = false;
            AppMethodBeat.m2504i(102960);
            C25052j.m39376p(editable, "s");
            int length = 50 - editable.length();
            if (length < 0) {
                length = 0;
            }
            TextView f = this.pCy.pCu;
            if (f != null) {
                f.setText(String.valueOf(length));
            }
            C5653c g = this.pCy.gud;
            if (g != null) {
                Button button = g.getButton(-1);
                if (button != null) {
                    if (editable.length() > 0) {
                        z = true;
                    }
                    button.setEnabled(z);
                    AppMethodBeat.m2505o(102960);
                    return;
                }
            }
            AppMethodBeat.m2505o(102960);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$l */
    static final class C12933l implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView pCy;

        C12933l(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(102962);
            C5653c g = this.pCy.gud;
            if (g != null) {
                g.dismiss();
            }
            this.pCy.gud = null;
            AppMethodBeat.m2505o(102962);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$h */
    static final class C28789h implements OnClickListener {
        final /* synthetic */ RadarMemberView pCy;

        C28789h(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        /* JADX WARNING: Removed duplicated region for block: B:53:0x00d2  */
        /* JADX WARNING: Missing block: B:38:0x0093, code skipped:
            if (r0 != null) goto L_0x0095;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(View view) {
            CharSequence Hv;
            Object obj;
            String str = null;
            AppMethodBeat.m2504i(102954);
            String str2 = "";
            if (this.pCy.ehM != null) {
                C7616ad c = this.pCy.ehM;
                String Hv2;
                if (c == null || !c.mo16693NX()) {
                    C7575bv RB;
                    C1694a K = C1720g.m3528K(C6982j.class);
                    C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                    C6980m XN = ((C6982j) K).mo15370XN();
                    c = this.pCy.ehM;
                    C7575bv RB2 = XN.mo15364RB(c != null ? c.getUsername() : null);
                    if (RB2 != null) {
                        Hv = RB2.mo16784Hv();
                        if (Hv == null || C6163u.m9837ar(Hv)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                    c = this.pCy.ehM;
                    if (c != null) {
                        Hv2 = c.mo14678Hv();
                    } else {
                        Hv2 = null;
                    }
                    Hv = Hv2;
                    obj = (Hv == null || C6163u.m9837ar(Hv)) ? 1 : null;
                    if (obj == null) {
                        K = C1720g.m3528K(C6982j.class);
                        C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                        XN = ((C6982j) K).mo15370XN();
                        c = this.pCy.ehM;
                        if (c != null) {
                            Hv2 = c.mo14678Hv();
                        } else {
                            Hv2 = null;
                        }
                        RB = XN.mo15364RB(Hv2);
                        if (RB != null) {
                            str2 = RB.mo16783Hr();
                        }
                    }
                    RB = RB2;
                    if (RB != null) {
                    }
                } else {
                    c = this.pCy.ehM;
                    if (c != null) {
                        Hv2 = c.mo14674Hr();
                    } else {
                        Hv2 = null;
                    }
                    str2 = Hv2;
                }
            }
            Hv = str2;
            if (Hv == null || C6163u.m9837ar(Hv)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (!(obj == null || this.pCy.getMember() == null)) {
                bpb member = this.pCy.getMember();
                if (member != null) {
                    str = member.jCH;
                }
                str2 = str;
            }
            RadarMemberView radarMemberView = this.pCy;
            if (str2 == null) {
                str2 = "";
            }
            RadarMemberView.m67604a(radarMemberView, str2);
            AppMethodBeat.m2505o(102954);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$k */
    static final class C28790k implements Runnable {
        final /* synthetic */ RadarMemberView pCy;

        C28790k(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void run() {
            AppMethodBeat.m2504i(102961);
            if (this.pCy.getContext() instanceof Activity) {
                C3674a c3674a = RadarMemberView.pCx;
                Context context = this.pCy.getContext();
                if (context == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.m2505o(102961);
                    throw c44941v;
                }
                Activity activity = (Activity) context;
                C25052j.m39376p(activity, "ac");
                Object systemService = activity.getSystemService("input_method");
                if (!(systemService instanceof InputMethodManager)) {
                    systemService = null;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager == null) {
                    AppMethodBeat.m2505o(102961);
                    return;
                }
                View currentFocus = activity.getCurrentFocus();
                if (currentFocus == null) {
                    AppMethodBeat.m2505o(102961);
                    return;
                } else if (currentFocus.getWindowToken() == null) {
                    AppMethodBeat.m2505o(102961);
                    return;
                } else {
                    inputMethodManager.toggleSoftInput(0, 2);
                }
            }
            AppMethodBeat.m2505o(102961);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$d */
    public static final class C34767d extends C7306ak {
        final /* synthetic */ RadarMemberView pCy;

        C34767d(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(102950);
            C25052j.m39376p(message, "msg");
            if (message.what == RadarMemberView.pCv) {
                RadarMemberView radarMemberView = this.pCy;
                this.pCy.getMember();
                RadarMemberView.m67603a(radarMemberView, this.pCy.getState());
                AppMethodBeat.m2505o(102950);
                return;
            }
            if (message.what == RadarMemberView.pCw) {
                this.pCy.setVisibility(4);
                RadarMemberView.m67613j(this.pCy);
                View k = this.pCy.pCe;
                if (k != null) {
                    k.setVisibility(0);
                }
                C3675b a = this.pCy.pCr;
                if (a != null) {
                    a.mo8284b(this.pCy.getMember(), this.pCy.getState());
                    AppMethodBeat.m2505o(102950);
                    return;
                }
            }
            AppMethodBeat.m2505o(102950);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$e */
    static final class C34768e implements OnClickListener {
        final /* synthetic */ RadarMemberView pCy;
        final /* synthetic */ bpb pCz;

        C34768e(RadarMemberView radarMemberView, bpb bpb) {
            this.pCy = radarMemberView;
            this.pCz = bpb;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(102951);
            if (this.pCy.getState() == null || this.pCy.pCr == null) {
                AppMethodBeat.m2505o(102951);
                return;
            }
            C3675b a = this.pCy.pCr;
            if (a != null) {
                a.mo8283a(this.pCz, this.pCy.getState());
            }
            this.pCy.dismiss();
            AppMethodBeat.m2505o(102951);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$g */
    static final class C39555g implements OnClickListener {
        final /* synthetic */ RadarMemberView pCy;

        C39555g(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(102953);
            Intent intent = new Intent();
            String str = "k_username";
            C7616ad c = this.pCy.ehM;
            intent.putExtra(str, c != null ? c.getUsername() : null);
            intent.putExtra("showShare", false);
            C8001y c8001y = C8001y.AVH;
            str = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[]{Integer.valueOf(38)}, 1));
            C25052j.m39375o(str, "java.lang.String.format(format, *args)");
            intent.putExtra("rawUrl", str);
            C25985d.m41467b(this.pCy.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(102953);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$f */
    static final class C39556f implements OnTouchListener {
        final /* synthetic */ RadarMemberView pCy;

        C39556f(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(102952);
            if (view != RadarMemberView.m67605b(this.pCy)) {
                C25052j.m39375o(motionEvent, "event");
                if (motionEvent.getAction() == 1 && this.pCy.isShowing()) {
                    this.pCy.dismiss();
                }
            }
            AppMethodBeat.m2505o(102952);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.RadarMemberView$m */
    static final class C39557m implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView pCy;

        C39557m(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(102963);
            if (this.pCy.gud != null) {
                C5653c g = this.pCy.gud;
                if (g != null) {
                    g.dismiss();
                }
                this.pCy.gud = null;
            }
            RadarMemberView.m67612i(this.pCy);
            AppMethodBeat.m2505o(102963);
        }
    }

    private final ImageView getAvatarCopy() {
        AppMethodBeat.m2504i(102966);
        ImageView imageView = (ImageView) this.pCg.getValue();
        AppMethodBeat.m2505o(102966);
        return imageView;
    }

    private final View getAvatarCopyContainer() {
        AppMethodBeat.m2504i(102967);
        View view = (View) this.pCh.getValue();
        AppMethodBeat.m2505o(102967);
        return view;
    }

    private final View getAvatarHolder() {
        AppMethodBeat.m2504i(102965);
        View view = (View) this.pCf.getValue();
        AppMethodBeat.m2505o(102965);
        return view;
    }

    private final Button getConfirmBtn() {
        AppMethodBeat.m2504i(102968);
        Button button = (Button) this.pCi.getValue();
        AppMethodBeat.m2505o(102968);
        return button;
    }

    private final TextView getConfirmBtnDisabled() {
        AppMethodBeat.m2504i(102969);
        TextView textView = (TextView) this.pCj.getValue();
        AppMethodBeat.m2505o(102969);
        return textView;
    }

    private final TextView getExposeTv() {
        AppMethodBeat.m2504i(102973);
        TextView textView = (TextView) this.pCo.getValue();
        AppMethodBeat.m2505o(102973);
        return textView;
    }

    private final TextView getMemberNameTv() {
        AppMethodBeat.m2504i(102970);
        TextView textView = (TextView) this.pCk.getValue();
        AppMethodBeat.m2505o(102970);
        return textView;
    }

    private final Button getModifyNameBtn() {
        AppMethodBeat.m2504i(102971);
        Button button = (Button) this.pCl.getValue();
        AppMethodBeat.m2505o(102971);
        return button;
    }

    private final TextView getSayHiTv() {
        AppMethodBeat.m2504i(102972);
        TextView textView = (TextView) this.pCm.getValue();
        AppMethodBeat.m2505o(102972);
        return textView;
    }

    /* renamed from: b */
    public static final /* synthetic */ Button m67605b(RadarMemberView radarMemberView) {
        AppMethodBeat.m2504i(102983);
        Button confirmBtn = radarMemberView.getConfirmBtn();
        AppMethodBeat.m2505o(102983);
        return confirmBtn;
    }

    /* renamed from: j */
    public static final /* synthetic */ void m67613j(RadarMemberView radarMemberView) {
        AppMethodBeat.m2504i(102987);
        radarMemberView.reset();
        AppMethodBeat.m2505o(102987);
    }

    public final C21556e getState() {
        return this.pBL;
    }

    public final void setState(C21556e c21556e) {
        this.pBL = c21556e;
    }

    public final bpb getMember() {
        return this.pBK;
    }

    public final void setMember(bpb bpb) {
        this.pBK = bpb;
    }

    public final boolean isShowing() {
        AppMethodBeat.m2504i(102974);
        if (getVisibility() == 0) {
            AppMethodBeat.m2505o(102974);
            return true;
        }
        AppMethodBeat.m2505o(102974);
        return false;
    }

    public RadarMemberView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.m2504i(102981);
        AppMethodBeat.m2505o(102981);
    }

    public RadarMemberView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(102982);
        AppMethodBeat.m2505o(102982);
    }

    /* JADX WARNING: Missing block: B:14:0x0037, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r4, r1) != false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public final void mo62514c(String str, C21556e c21556e) {
        Object obj = null;
        AppMethodBeat.m2504i(102975);
        C25052j.m39376p(str, "username");
        C25052j.m39376p(c21556e, "state");
        if (!isShowing() || this.pCp) {
            AppMethodBeat.m2505o(102975);
            return;
        }
        Object obj2;
        bpb bpb = this.pBK;
        if (bpb != null) {
            obj2 = bpb.wfK;
        } else {
            obj2 = null;
        }
        if (!C25052j.m39373j(str, obj2)) {
            bpb = this.pBK;
            if (bpb != null) {
                obj = bpb.jBB;
            }
        }
        m67602a(c21556e);
        AppMethodBeat.m2505o(102975);
    }

    /* renamed from: a */
    private final void m67602a(C21556e c21556e) {
        AppMethodBeat.m2504i(102976);
        getExposeTv().setVisibility(0);
        if (c21556e == null) {
            AppMethodBeat.m2505o(102976);
            return;
        }
        switch (C12943c.eQZ[c21556e.ordinal()]) {
            case 1:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtn().setText(C25738R.string.dh8);
                getConfirmBtn().setVisibility(0);
                getConfirmBtnDisabled().setVisibility(8);
                getSayHiTv().setVisibility(8);
                AppMethodBeat.m2505o(102976);
                return;
            case 2:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtnDisabled().setText(C25738R.string.dhe);
                getConfirmBtn().setVisibility(8);
                getConfirmBtnDisabled().setVisibility(0);
                getSayHiTv().setVisibility(8);
                AppMethodBeat.m2505o(102976);
                return;
            case 3:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtnDisabled().setText(C25738R.string.dgv);
                getConfirmBtn().setVisibility(8);
                getConfirmBtnDisabled().setVisibility(0);
                getSayHiTv().setVisibility(8);
                AppMethodBeat.m2505o(102976);
                return;
            case 4:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtn().setText(C25738R.string.dgu);
                getConfirmBtn().setVisibility(0);
                getConfirmBtnDisabled().setVisibility(8);
                getSayHiTv().setText(getContext().getString(C25738R.string.dh6));
                getSayHiTv().setVisibility(0);
                break;
        }
        AppMethodBeat.m2505o(102976);
    }

    public final void setListener(C3675b c3675b) {
        AppMethodBeat.m2504i(102977);
        C25052j.m39376p(c3675b, CastExtraArgs.LISTENER);
        this.pCr = c3675b;
        AppMethodBeat.m2505o(102977);
    }

    /* renamed from: a */
    public final void mo62513a(View view, bpb bpb, C21556e c21556e) {
        C1694a K;
        String Hr;
        CharSequence b;
        AppMethodBeat.m2504i(102978);
        C25052j.m39376p(view, "view");
        C25052j.m39376p(bpb, "member");
        C4990ab.m7410d(TAG, "popup");
        this.pBL = c21556e;
        this.pBK = bpb;
        Button confirmBtn = getConfirmBtn();
        if (confirmBtn != null) {
            confirmBtn.setOnClickListener(new C34768e(this, bpb));
        }
        getModifyNameBtn().setOnClickListener(this.pCs);
        setOnTouchListener(new C39556f(this));
        getExposeTv().setOnClickListener(new C39555g(this));
        C39561g c39561g = C39561g.pDK;
        String b2 = C39561g.m67618b(bpb);
        if (!C6163u.m9837ar(b2)) {
            K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
            this.ehM = ((C6982j) K).mo15369XM().aoO(b2);
        }
        C7616ad c7616ad = this.ehM;
        if (c7616ad == null || !c7616ad.mo16693NX()) {
            K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
            this.pCq = ((C6982j) K).mo15370XN().mo15364RB(b2);
            C7575bv c7575bv = this.pCq;
            Hr = c7575bv != null ? c7575bv.mo16783Hr() : null;
        } else {
            c7616ad = this.ehM;
            Hr = c7616ad != null ? c7616ad.mo14674Hr() : null;
        }
        TextView memberNameTv = getMemberNameTv();
        if (this.ehM == null || C5046bo.isNullOrNil(Hr)) {
            b = C44089j.m79293b(getContext(), (CharSequence) bpb.jCH, getMemberNameTv().getTextSize());
        } else {
            b = C44089j.m79293b(getContext(), (CharSequence) Hr, getMemberNameTv().getTextSize());
        }
        memberNameTv.setText(b);
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        reset();
        this.pCe = view;
        View view2 = this.pCe;
        if (view2 == null) {
            C25052j.dWJ();
        }
        view2 = view2.findViewById(2131826793);
        C25052j.m39375o(view2, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
        ImageView imageView = (ImageView) view2;
        View view3 = this.pCe;
        if (view3 == null) {
            C25052j.dWJ();
        }
        view3 = view3.findViewById(2131826788);
        C25052j.m39375o(view3, "avatarItem!!.findViewByI…d.radar_avatar_container)");
        View view4 = this.pCe;
        if (view4 == null) {
            C25052j.dWJ();
        }
        view4.setVisibility(4);
        getAvatarCopy().setImageDrawable(imageView.getDrawable());
        getAvatarCopyContainer().setVisibility(0);
        int[] iArr = new int[2];
        view3.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        getAvatarHolder().getLocationInWindow(iArr2);
        this.pCn = iArr2;
        setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setDuration(500);
        float height = ((float) getAvatarHolder().getHeight()) / ((float) view3.getHeight());
        TranslateAnimation translateAnimation = new TranslateAnimation((float) iArr[0], ((float) iArr2[0]) - (((float) ((view3.getWidth() - view3.getHeight()) / 2)) * height), (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(1.0f, height, 1.0f, height));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new C12931i(this));
        getAvatarCopyContainer().startAnimation(animationSet);
        AppMethodBeat.m2505o(102978);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(102979);
        C4990ab.m7410d(TAG, "dismiss");
        if (this.pCp) {
            AppMethodBeat.m2505o(102979);
            return;
        }
        this.pCp = true;
        View view = this.pCe;
        if (view == null) {
            C25052j.dWJ();
        }
        view = view.findViewById(2131826788);
        C25052j.m39375o(view, "avatarItem!!.findViewByI…d.radar_avatar_container)");
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setDuration(500);
        int[] iArr = this.pCn;
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        float height = ((float) getAvatarHolder().getHeight()) / ((float) view.getHeight());
        float width = ((float) ((view.getWidth() - view.getHeight()) / 2)) * height;
        if (iArr == null) {
            C25052j.dWJ();
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(((float) iArr[0]) - width, (float) iArr2[0], (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(height, 1.0f, height, 1.0f));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new C3676c(this));
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        getConfirmBtn().setVisibility(8);
        getConfirmBtnDisabled().setVisibility(8);
        getSayHiTv().setVisibility(8);
        getExposeTv().setVisibility(8);
        getAvatarCopyContainer().startAnimation(animationSet);
        AppMethodBeat.m2505o(102979);
    }

    private final void reset() {
        AppMethodBeat.m2504i(102980);
        getAvatarCopyContainer().setVisibility(8);
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        getConfirmBtn().setVisibility(8);
        getConfirmBtnDisabled().setVisibility(8);
        getSayHiTv().setVisibility(8);
        getExposeTv().setVisibility(8);
        AppMethodBeat.m2505o(102980);
    }

    static {
        AppMethodBeat.m2504i(102964);
        AppMethodBeat.m2505o(102964);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Missing block: B:44:0x00a8, code skipped:
            if (r0 != null) goto L_0x00aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public static final /* synthetic */ boolean m67612i(RadarMemberView radarMemberView) {
        String str = null;
        Object obj = null;
        AppMethodBeat.m2504i(102984);
        if (radarMemberView.pwu == null) {
            AppMethodBeat.m2505o(102984);
            return false;
        }
        Object text;
        String str2;
        EditText editText = radarMemberView.pwu;
        if (editText != null) {
            text = editText.getText();
        } else {
            text = null;
        }
        CharSequence valueOf = String.valueOf(text);
        int length = valueOf.length() - 1;
        Object obj2 = null;
        int i = 0;
        while (i <= length) {
            Object obj3;
            if (valueOf.charAt(obj2 == null ? i : length) <= ' ') {
                obj3 = 1;
            } else {
                obj3 = null;
            }
            if (obj2 != null) {
                if (obj3 == null) {
                    break;
                }
                length--;
            } else if (obj3 == null) {
                obj2 = 1;
            } else {
                i++;
            }
        }
        String obj4 = valueOf.subSequence(i, length + 1).toString();
        bpb bpb = radarMemberView.pBK;
        if (bpb != null) {
            C39561g c39561g = C39561g.pDK;
            String b = C39561g.m67618b(bpb);
            if (b != null) {
                str2 = b;
                if (C5046bo.isNullOrNil(str2)) {
                    C7616ad c7616ad = radarMemberView.ehM;
                    C1694a K;
                    if (c7616ad == null || !c7616ad.mo16693NX()) {
                        c7616ad = radarMemberView.ehM;
                        if (c7616ad != null) {
                            c7616ad.mo14729iz(obj4);
                        }
                        K = C1720g.m3528K(C6982j.class);
                        C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                        ((C6982j) K).mo15370XN().mo10099a(new C7575bv(str2, obj4));
                    } else {
                        C7575bv RB;
                        K = C1720g.m3528K(C6982j.class);
                        C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                        C6980m XN = ((C6982j) K).mo15370XN();
                        c7616ad = radarMemberView.ehM;
                        C7575bv RB2 = XN.mo15364RB(c7616ad != null ? c7616ad.getUsername() : null);
                        if (RB2 != null) {
                            valueOf = RB2.mo16784Hv();
                            if (valueOf == null || C6163u.m9837ar(valueOf)) {
                                text = 1;
                            } else {
                                text = null;
                            }
                        }
                        c7616ad = radarMemberView.ehM;
                        if (c7616ad != null) {
                            b = c7616ad.mo14678Hv();
                        } else {
                            b = null;
                        }
                        valueOf = b;
                        text = (valueOf == null || C6163u.m9837ar(valueOf)) ? 1 : null;
                        if (text == null) {
                            K = C1720g.m3528K(C6982j.class);
                            C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                            C6980m XN2 = ((C6982j) K).mo15370XN();
                            C7616ad c7616ad2 = radarMemberView.ehM;
                            if (c7616ad2 != null) {
                                str = c7616ad2.mo14678Hv();
                            }
                            RB = XN2.mo15364RB(str);
                            if (RB != null) {
                                valueOf = RB.mo16784Hv();
                                if (valueOf == null || C6163u.m9837ar(valueOf)) {
                                    obj = 1;
                                }
                                if (obj == null) {
                                    K = C1720g.m3528K(C6982j.class);
                                    C25052j.m39375o(K, "service(IMessengerStorage::class.java)");
                                    ((C6982j) K).mo15370XN().mo15365RC(RB.mo16784Hv());
                                }
                            }
                            c7616ad = radarMemberView.ehM;
                            if (c7616ad != null) {
                                c7616ad.mo14729iz(obj4);
                            }
                            C1855t.m3887b(radarMemberView.ehM, obj4);
                        }
                        RB = RB2;
                        if (RB != null) {
                        }
                        c7616ad = radarMemberView.ehM;
                        if (c7616ad != null) {
                        }
                        C1855t.m3887b(radarMemberView.ehM, obj4);
                    }
                    TextView memberNameTv = radarMemberView.getMemberNameTv();
                    if (memberNameTv != null) {
                        memberNameTv.setText(obj4);
                    }
                    AppMethodBeat.m2505o(102984);
                    return true;
                }
                AppMethodBeat.m2505o(102984);
                return false;
            }
        }
        str2 = "";
        if (C5046bo.isNullOrNil(str2)) {
        }
    }
}
