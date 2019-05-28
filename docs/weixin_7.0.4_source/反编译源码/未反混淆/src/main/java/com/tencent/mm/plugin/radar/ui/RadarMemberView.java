package com.tencent.mm.plugin.radar.ui;

import a.f.b.t;
import a.f.b.v;
import a.f.b.y;
import a.k.u;
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
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import java.util.Arrays;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006*\u00010\u0018\u0000 c2\u00020\u0001:\u0002cdB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010T\u001a\u00020+H\u0002J\u0006\u0010U\u001a\u00020VJ\b\u0010W\u001a\u00020VH\u0002J\u0010\u0010X\u001a\u00020V2\u0006\u00108\u001a\u000209H\u0002J \u0010Y\u001a\u00020V2\u0006\u0010Z\u001a\u00020\u00142\u0006\u00108\u001a\u0002092\b\u0010H\u001a\u0004\u0018\u00010IJ\b\u0010[\u001a\u00020VH\u0002J\u000e\u0010\\\u001a\u00020V2\u0006\u00104\u001a\u000205J\u0010\u0010]\u001a\u00020V2\u0006\u0010^\u001a\u00020_H\u0002J\u001c\u0010`\u001a\u00020V2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0016\u0010a\u001a\u00020V2\u0006\u0010b\u001a\u00020_2\u0006\u0010H\u001a\u00020IR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0019\u0010\u0016R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u0012\u001a\u0004\b-\u0010$R\u0010\u0010/\u001a\u000200X\u0004¢\u0006\u0004\n\u0002\u00101R\u0011\u00102\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b@\u0010\u0012\u001a\u0004\b?\u0010$R\u001b\u0010A\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\bC\u0010\u0012\u001a\u0004\bB\u0010\u001fR\u001b\u0010D\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\bF\u0010\u0012\u001a\u0004\bE\u0010$R\u0010\u0010G\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alert", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "avatarCopy", "Landroid/widget/ImageView;", "getAvatarCopy", "()Landroid/widget/ImageView;", "avatarCopy$delegate", "Lkotlin/Lazy;", "avatarCopyContainer", "Landroid/view/View;", "getAvatarCopyContainer", "()Landroid/view/View;", "avatarCopyContainer$delegate", "avatarHolder", "getAvatarHolder", "avatarHolder$delegate", "avatarItem", "confirmBtn", "Landroid/widget/Button;", "getConfirmBtn", "()Landroid/widget/Button;", "confirmBtn$delegate", "confirmBtnDisabled", "Landroid/widget/TextView;", "getConfirmBtnDisabled", "()Landroid/widget/TextView;", "confirmBtnDisabled$delegate", "contact", "Lcom/tencent/mm/storage/Contact;", "contentET", "Landroid/widget/EditText;", "dismissing", "", "exposeTv", "getExposeTv", "exposeTv$delegate", "handler", "com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1;", "isShowing", "()Z", "listener", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "mOnModifyNameClickListener", "Landroid/view/View$OnClickListener;", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "setMember", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;)V", "memberNameTv", "getMemberNameTv", "memberNameTv$delegate", "modifyNameBtn", "getModifyNameBtn", "modifyNameBtn$delegate", "sayHiTv", "getSayHiTv", "sayHiTv$delegate", "sendDialog", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "setState", "(Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "stranger", "Lcom/tencent/mm/storage/Stranger;", "tipTV", "toPosCache", "", "wordcntTV", "dealModRemarkName", "dismiss", "", "hideAll", "initView", "popup", "view", "reset", "setListener", "showModifyDialog", "name", "", "switchState", "updateState", "username", "Companion", "OnConfirmBtnClickListener", "plugin-radar_release"})
public final class RadarMemberView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(RadarMemberView.class), "avatarHolder", "getAvatarHolder()Landroid/view/View;")), v.a(new t(v.aN(RadarMemberView.class), "avatarCopy", "getAvatarCopy()Landroid/widget/ImageView;")), v.a(new t(v.aN(RadarMemberView.class), "avatarCopyContainer", "getAvatarCopyContainer()Landroid/view/View;")), v.a(new t(v.aN(RadarMemberView.class), "confirmBtn", "getConfirmBtn()Landroid/widget/Button;")), v.a(new t(v.aN(RadarMemberView.class), "confirmBtnDisabled", "getConfirmBtnDisabled()Landroid/widget/TextView;")), v.a(new t(v.aN(RadarMemberView.class), "memberNameTv", "getMemberNameTv()Landroid/widget/TextView;")), v.a(new t(v.aN(RadarMemberView.class), "modifyNameBtn", "getModifyNameBtn()Landroid/widget/Button;")), v.a(new t(v.aN(RadarMemberView.class), "sayHiTv", "getSayHiTv()Landroid/widget/TextView;")), v.a(new t(v.aN(RadarMemberView.class), "exposeTv", "getExposeTv()Landroid/widget/TextView;"))};
    private static final int pCv = 0;
    private static final int pCw = 1;
    public static final a pCx = new a();
    private ad ehM;
    private View gub;
    private com.tencent.mm.ui.widget.a.c gud;
    private TextView mJS;
    private bpb pBK;
    private com.tencent.mm.plugin.radar.b.c.e pBL;
    private View pCe;
    private final a.f pCf = i.aa(this, R.id.dtp);
    private final a.f pCg = i.aa(this, R.id.dtt);
    private final a.f pCh = i.aa(this, R.id.dts);
    private final a.f pCi = i.aa(this, R.id.dto);
    private final a.f pCj = i.aa(this, R.id.dtn);
    private final a.f pCk = i.aa(this, R.id.dtq);
    private final a.f pCl = i.aa(this, R.id.dtr);
    private final a.f pCm = i.aa(this, R.id.dtm);
    private int[] pCn;
    private final a.f pCo = i.aa(this, R.id.dtu);
    private boolean pCp;
    private bv pCq;
    private b pCr;
    private final OnClickListener pCs = new h(this);
    private final d pCt = new d(this);
    private TextView pCu;
    private EditText pwu;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$Companion;", "", "()V", "ANIMATION_DISMISS_END", "", "ANIMATION_POPUP_END", "TAG", "", "showVKB", "", "ac", "Landroid/app/Activity;", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
    public interface b {
        void a(bpb bpb, com.tencent.mm.plugin.radar.b.c.e eVar);

        void b(bpb bpb, com.tencent.mm.plugin.radar.b.c.e eVar);
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$dismiss$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class c implements AnimationListener {
        final /* synthetic */ RadarMemberView pCy;

        c(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(102947);
            a.f.b.j.p(animation, "animation");
            AppMethodBeat.o(102947);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.i(102948);
            a.f.b.j.p(animation, "animation");
            AppMethodBeat.o(102948);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(102949);
            a.f.b.j.p(animation, "animation");
            ab.d(RadarMemberView.TAG, "dismiss animation end");
            this.pCy.pCp = false;
            this.pCy.pCt.sendEmptyMessage(RadarMemberView.pCw);
            AppMethodBeat.o(102949);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$popup$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class i implements AnimationListener {
        final /* synthetic */ RadarMemberView pCy;

        i(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(102955);
            a.f.b.j.p(animation, "animation");
            AppMethodBeat.o(102955);
        }

        public final void onAnimationRepeat(Animation animation) {
            AppMethodBeat.i(102956);
            a.f.b.j.p(animation, "animation");
            AppMethodBeat.o(102956);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(102957);
            a.f.b.j.p(animation, "animation");
            ab.d(RadarMemberView.TAG, "popup animation end");
            this.pCy.pCt.sendEmptyMessage(RadarMemberView.pCv);
            AppMethodBeat.o(102957);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$showModifyDialog$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-radar_release"})
    public static final class j implements TextWatcher {
        final /* synthetic */ RadarMemberView pCy;

        j(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(102958);
            a.f.b.j.p(charSequence, "s");
            AppMethodBeat.o(102958);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(102959);
            a.f.b.j.p(charSequence, "s");
            AppMethodBeat.o(102959);
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = false;
            AppMethodBeat.i(102960);
            a.f.b.j.p(editable, "s");
            int length = 50 - editable.length();
            if (length < 0) {
                length = 0;
            }
            TextView f = this.pCy.pCu;
            if (f != null) {
                f.setText(String.valueOf(length));
            }
            com.tencent.mm.ui.widget.a.c g = this.pCy.gud;
            if (g != null) {
                Button button = g.getButton(-1);
                if (button != null) {
                    if (editable.length() > 0) {
                        z = true;
                    }
                    button.setEnabled(z);
                    AppMethodBeat.o(102960);
                    return;
                }
            }
            AppMethodBeat.o(102960);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class l implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView pCy;

        l(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(102962);
            com.tencent.mm.ui.widget.a.c g = this.pCy.gud;
            if (g != null) {
                g.dismiss();
            }
            this.pCy.gud = null;
            AppMethodBeat.o(102962);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h implements OnClickListener {
        final /* synthetic */ RadarMemberView pCy;

        h(RadarMemberView radarMemberView) {
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
            AppMethodBeat.i(102954);
            String str2 = "";
            if (this.pCy.ehM != null) {
                ad c = this.pCy.ehM;
                String Hv2;
                if (c == null || !c.NX()) {
                    bv RB;
                    com.tencent.mm.kernel.c.a K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                    a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                    com.tencent.mm.plugin.messenger.foundation.a.a.m XN = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XN();
                    c = this.pCy.ehM;
                    bv RB2 = XN.RB(c != null ? c.getUsername() : null);
                    if (RB2 != null) {
                        Hv = RB2.Hv();
                        if (Hv == null || u.ar(Hv)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                    c = this.pCy.ehM;
                    if (c != null) {
                        Hv2 = c.Hv();
                    } else {
                        Hv2 = null;
                    }
                    Hv = Hv2;
                    obj = (Hv == null || u.ar(Hv)) ? 1 : null;
                    if (obj == null) {
                        K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                        a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                        XN = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XN();
                        c = this.pCy.ehM;
                        if (c != null) {
                            Hv2 = c.Hv();
                        } else {
                            Hv2 = null;
                        }
                        RB = XN.RB(Hv2);
                        if (RB != null) {
                            str2 = RB.Hr();
                        }
                    }
                    RB = RB2;
                    if (RB != null) {
                    }
                } else {
                    c = this.pCy.ehM;
                    if (c != null) {
                        Hv2 = c.Hr();
                    } else {
                        Hv2 = null;
                    }
                    str2 = Hv2;
                }
            }
            Hv = str2;
            if (Hv == null || u.ar(Hv)) {
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
            RadarMemberView.a(radarMemberView, str2);
            AppMethodBeat.o(102954);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ RadarMemberView pCy;

        k(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void run() {
            AppMethodBeat.i(102961);
            if (this.pCy.getContext() instanceof Activity) {
                a aVar = RadarMemberView.pCx;
                Context context = this.pCy.getContext();
                if (context == null) {
                    a.v vVar = new a.v("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(102961);
                    throw vVar;
                }
                Activity activity = (Activity) context;
                a.f.b.j.p(activity, "ac");
                Object systemService = activity.getSystemService("input_method");
                if (!(systemService instanceof InputMethodManager)) {
                    systemService = null;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager == null) {
                    AppMethodBeat.o(102961);
                    return;
                }
                View currentFocus = activity.getCurrentFocus();
                if (currentFocus == null) {
                    AppMethodBeat.o(102961);
                    return;
                } else if (currentFocus.getWindowToken() == null) {
                    AppMethodBeat.o(102961);
                    return;
                } else {
                    inputMethodManager.toggleSoftInput(0, 2);
                }
            }
            AppMethodBeat.o(102961);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/ui/RadarMemberView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class d extends ak {
        final /* synthetic */ RadarMemberView pCy;

        d(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(102950);
            a.f.b.j.p(message, "msg");
            if (message.what == RadarMemberView.pCv) {
                RadarMemberView radarMemberView = this.pCy;
                this.pCy.getMember();
                RadarMemberView.a(radarMemberView, this.pCy.getState());
                AppMethodBeat.o(102950);
                return;
            }
            if (message.what == RadarMemberView.pCw) {
                this.pCy.setVisibility(4);
                RadarMemberView.j(this.pCy);
                View k = this.pCy.pCe;
                if (k != null) {
                    k.setVisibility(0);
                }
                b a = this.pCy.pCr;
                if (a != null) {
                    a.b(this.pCy.getMember(), this.pCy.getState());
                    AppMethodBeat.o(102950);
                    return;
                }
            }
            AppMethodBeat.o(102950);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements OnClickListener {
        final /* synthetic */ RadarMemberView pCy;
        final /* synthetic */ bpb pCz;

        e(RadarMemberView radarMemberView, bpb bpb) {
            this.pCy = radarMemberView;
            this.pCz = bpb;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102951);
            if (this.pCy.getState() == null || this.pCy.pCr == null) {
                AppMethodBeat.o(102951);
                return;
            }
            b a = this.pCy.pCr;
            if (a != null) {
                a.a(this.pCz, this.pCy.getState());
            }
            this.pCy.dismiss();
            AppMethodBeat.o(102951);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements OnClickListener {
        final /* synthetic */ RadarMemberView pCy;

        g(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102953);
            Intent intent = new Intent();
            String str = "k_username";
            ad c = this.pCy.ehM;
            intent.putExtra(str, c != null ? c.getUsername() : null);
            intent.putExtra("showShare", false);
            y yVar = y.AVH;
            str = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[]{Integer.valueOf(38)}, 1));
            a.f.b.j.o(str, "java.lang.String.format(format, *args)");
            intent.putExtra("rawUrl", str);
            com.tencent.mm.bp.d.b(this.pCy.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(102953);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class f implements OnTouchListener {
        final /* synthetic */ RadarMemberView pCy;

        f(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(102952);
            if (view != RadarMemberView.b(this.pCy)) {
                a.f.b.j.o(motionEvent, "event");
                if (motionEvent.getAction() == 1 && this.pCy.isShowing()) {
                    this.pCy.dismiss();
                }
            }
            AppMethodBeat.o(102952);
            return true;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class m implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView pCy;

        m(RadarMemberView radarMemberView) {
            this.pCy = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(102963);
            if (this.pCy.gud != null) {
                com.tencent.mm.ui.widget.a.c g = this.pCy.gud;
                if (g != null) {
                    g.dismiss();
                }
                this.pCy.gud = null;
            }
            RadarMemberView.i(this.pCy);
            AppMethodBeat.o(102963);
        }
    }

    private final ImageView getAvatarCopy() {
        AppMethodBeat.i(102966);
        ImageView imageView = (ImageView) this.pCg.getValue();
        AppMethodBeat.o(102966);
        return imageView;
    }

    private final View getAvatarCopyContainer() {
        AppMethodBeat.i(102967);
        View view = (View) this.pCh.getValue();
        AppMethodBeat.o(102967);
        return view;
    }

    private final View getAvatarHolder() {
        AppMethodBeat.i(102965);
        View view = (View) this.pCf.getValue();
        AppMethodBeat.o(102965);
        return view;
    }

    private final Button getConfirmBtn() {
        AppMethodBeat.i(102968);
        Button button = (Button) this.pCi.getValue();
        AppMethodBeat.o(102968);
        return button;
    }

    private final TextView getConfirmBtnDisabled() {
        AppMethodBeat.i(102969);
        TextView textView = (TextView) this.pCj.getValue();
        AppMethodBeat.o(102969);
        return textView;
    }

    private final TextView getExposeTv() {
        AppMethodBeat.i(102973);
        TextView textView = (TextView) this.pCo.getValue();
        AppMethodBeat.o(102973);
        return textView;
    }

    private final TextView getMemberNameTv() {
        AppMethodBeat.i(102970);
        TextView textView = (TextView) this.pCk.getValue();
        AppMethodBeat.o(102970);
        return textView;
    }

    private final Button getModifyNameBtn() {
        AppMethodBeat.i(102971);
        Button button = (Button) this.pCl.getValue();
        AppMethodBeat.o(102971);
        return button;
    }

    private final TextView getSayHiTv() {
        AppMethodBeat.i(102972);
        TextView textView = (TextView) this.pCm.getValue();
        AppMethodBeat.o(102972);
        return textView;
    }

    public static final /* synthetic */ Button b(RadarMemberView radarMemberView) {
        AppMethodBeat.i(102983);
        Button confirmBtn = radarMemberView.getConfirmBtn();
        AppMethodBeat.o(102983);
        return confirmBtn;
    }

    public static final /* synthetic */ void j(RadarMemberView radarMemberView) {
        AppMethodBeat.i(102987);
        radarMemberView.reset();
        AppMethodBeat.o(102987);
    }

    public final com.tencent.mm.plugin.radar.b.c.e getState() {
        return this.pBL;
    }

    public final void setState(com.tencent.mm.plugin.radar.b.c.e eVar) {
        this.pBL = eVar;
    }

    public final bpb getMember() {
        return this.pBK;
    }

    public final void setMember(bpb bpb) {
        this.pBK = bpb;
    }

    public final boolean isShowing() {
        AppMethodBeat.i(102974);
        if (getVisibility() == 0) {
            AppMethodBeat.o(102974);
            return true;
        }
        AppMethodBeat.o(102974);
        return false;
    }

    public RadarMemberView(Context context, AttributeSet attributeSet) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(attributeSet, "attrs");
        super(context, attributeSet);
        AppMethodBeat.i(102981);
        AppMethodBeat.o(102981);
    }

    public RadarMemberView(Context context, AttributeSet attributeSet, int i) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(attributeSet, "attrs");
        super(context, attributeSet, i);
        AppMethodBeat.i(102982);
        AppMethodBeat.o(102982);
    }

    /* JADX WARNING: Missing block: B:14:0x0037, code skipped:
            if (a.f.b.j.j(r4, r1) != false) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        Object obj = null;
        AppMethodBeat.i(102975);
        a.f.b.j.p(str, "username");
        a.f.b.j.p(eVar, "state");
        if (!isShowing() || this.pCp) {
            AppMethodBeat.o(102975);
            return;
        }
        Object obj2;
        bpb bpb = this.pBK;
        if (bpb != null) {
            obj2 = bpb.wfK;
        } else {
            obj2 = null;
        }
        if (!a.f.b.j.j(str, obj2)) {
            bpb = this.pBK;
            if (bpb != null) {
                obj = bpb.jBB;
            }
        }
        a(eVar);
        AppMethodBeat.o(102975);
    }

    private final void a(com.tencent.mm.plugin.radar.b.c.e eVar) {
        AppMethodBeat.i(102976);
        getExposeTv().setVisibility(0);
        if (eVar == null) {
            AppMethodBeat.o(102976);
            return;
        }
        switch (c.eQZ[eVar.ordinal()]) {
            case 1:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtn().setText(R.string.dh8);
                getConfirmBtn().setVisibility(0);
                getConfirmBtnDisabled().setVisibility(8);
                getSayHiTv().setVisibility(8);
                AppMethodBeat.o(102976);
                return;
            case 2:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtnDisabled().setText(R.string.dhe);
                getConfirmBtn().setVisibility(8);
                getConfirmBtnDisabled().setVisibility(0);
                getSayHiTv().setVisibility(8);
                AppMethodBeat.o(102976);
                return;
            case 3:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtnDisabled().setText(R.string.dgv);
                getConfirmBtn().setVisibility(8);
                getConfirmBtnDisabled().setVisibility(0);
                getSayHiTv().setVisibility(8);
                AppMethodBeat.o(102976);
                return;
            case 4:
                getMemberNameTv().setVisibility(0);
                getModifyNameBtn().setVisibility(0);
                getConfirmBtn().setText(R.string.dgu);
                getConfirmBtn().setVisibility(0);
                getConfirmBtnDisabled().setVisibility(8);
                getSayHiTv().setText(getContext().getString(R.string.dh6));
                getSayHiTv().setVisibility(0);
                break;
        }
        AppMethodBeat.o(102976);
    }

    public final void setListener(b bVar) {
        AppMethodBeat.i(102977);
        a.f.b.j.p(bVar, CastExtraArgs.LISTENER);
        this.pCr = bVar;
        AppMethodBeat.o(102977);
    }

    public final void a(View view, bpb bpb, com.tencent.mm.plugin.radar.b.c.e eVar) {
        com.tencent.mm.kernel.c.a K;
        String Hr;
        CharSequence b;
        AppMethodBeat.i(102978);
        a.f.b.j.p(view, "view");
        a.f.b.j.p(bpb, "member");
        ab.d(TAG, "popup");
        this.pBL = eVar;
        this.pBK = bpb;
        Button confirmBtn = getConfirmBtn();
        if (confirmBtn != null) {
            confirmBtn.setOnClickListener(new e(this, bpb));
        }
        getModifyNameBtn().setOnClickListener(this.pCs);
        setOnTouchListener(new f(this));
        getExposeTv().setOnClickListener(new g(this));
        g gVar = g.pDK;
        String b2 = g.b(bpb);
        if (!u.ar(b2)) {
            K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
            this.ehM = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(b2);
        }
        ad adVar = this.ehM;
        if (adVar == null || !adVar.NX()) {
            K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
            this.pCq = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XN().RB(b2);
            bv bvVar = this.pCq;
            Hr = bvVar != null ? bvVar.Hr() : null;
        } else {
            adVar = this.ehM;
            Hr = adVar != null ? adVar.Hr() : null;
        }
        TextView memberNameTv = getMemberNameTv();
        if (this.ehM == null || bo.isNullOrNil(Hr)) {
            b = com.tencent.mm.pluginsdk.ui.e.j.b(getContext(), (CharSequence) bpb.jCH, getMemberNameTv().getTextSize());
        } else {
            b = com.tencent.mm.pluginsdk.ui.e.j.b(getContext(), (CharSequence) Hr, getMemberNameTv().getTextSize());
        }
        memberNameTv.setText(b);
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        reset();
        this.pCe = view;
        View view2 = this.pCe;
        if (view2 == null) {
            a.f.b.j.dWJ();
        }
        view2 = view2.findViewById(R.id.dtx);
        a.f.b.j.o(view2, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
        ImageView imageView = (ImageView) view2;
        View view3 = this.pCe;
        if (view3 == null) {
            a.f.b.j.dWJ();
        }
        view3 = view3.findViewById(R.id.dts);
        a.f.b.j.o(view3, "avatarItem!!.findViewByI…d.radar_avatar_container)");
        View view4 = this.pCe;
        if (view4 == null) {
            a.f.b.j.dWJ();
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
        animationSet.setAnimationListener(new i(this));
        getAvatarCopyContainer().startAnimation(animationSet);
        AppMethodBeat.o(102978);
    }

    public final void dismiss() {
        AppMethodBeat.i(102979);
        ab.d(TAG, "dismiss");
        if (this.pCp) {
            AppMethodBeat.o(102979);
            return;
        }
        this.pCp = true;
        View view = this.pCe;
        if (view == null) {
            a.f.b.j.dWJ();
        }
        view = view.findViewById(R.id.dts);
        a.f.b.j.o(view, "avatarItem!!.findViewByI…d.radar_avatar_container)");
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
            a.f.b.j.dWJ();
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(((float) iArr[0]) - width, (float) iArr2[0], (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(height, 1.0f, height, 1.0f));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new c(this));
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        getConfirmBtn().setVisibility(8);
        getConfirmBtnDisabled().setVisibility(8);
        getSayHiTv().setVisibility(8);
        getExposeTv().setVisibility(8);
        getAvatarCopyContainer().startAnimation(animationSet);
        AppMethodBeat.o(102979);
    }

    private final void reset() {
        AppMethodBeat.i(102980);
        getAvatarCopyContainer().setVisibility(8);
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        getConfirmBtn().setVisibility(8);
        getConfirmBtnDisabled().setVisibility(8);
        getSayHiTv().setVisibility(8);
        getExposeTv().setVisibility(8);
        AppMethodBeat.o(102980);
    }

    static {
        AppMethodBeat.i(102964);
        AppMethodBeat.o(102964);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Missing block: B:44:0x00a8, code skipped:
            if (r0 != null) goto L_0x00aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean i(RadarMemberView radarMemberView) {
        String str = null;
        Object obj = null;
        AppMethodBeat.i(102984);
        if (radarMemberView.pwu == null) {
            AppMethodBeat.o(102984);
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
            g gVar = g.pDK;
            String b = g.b(bpb);
            if (b != null) {
                str2 = b;
                if (bo.isNullOrNil(str2)) {
                    ad adVar = radarMemberView.ehM;
                    com.tencent.mm.kernel.c.a K;
                    if (adVar == null || !adVar.NX()) {
                        adVar = radarMemberView.ehM;
                        if (adVar != null) {
                            adVar.iz(obj4);
                        }
                        K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                        a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                        ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XN().a(new bv(str2, obj4));
                    } else {
                        bv RB;
                        K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                        a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                        com.tencent.mm.plugin.messenger.foundation.a.a.m XN = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XN();
                        adVar = radarMemberView.ehM;
                        bv RB2 = XN.RB(adVar != null ? adVar.getUsername() : null);
                        if (RB2 != null) {
                            valueOf = RB2.Hv();
                            if (valueOf == null || u.ar(valueOf)) {
                                text = 1;
                            } else {
                                text = null;
                            }
                        }
                        adVar = radarMemberView.ehM;
                        if (adVar != null) {
                            b = adVar.Hv();
                        } else {
                            b = null;
                        }
                        valueOf = b;
                        text = (valueOf == null || u.ar(valueOf)) ? 1 : null;
                        if (text == null) {
                            K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                            a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                            com.tencent.mm.plugin.messenger.foundation.a.a.m XN2 = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XN();
                            ad adVar2 = radarMemberView.ehM;
                            if (adVar2 != null) {
                                str = adVar2.Hv();
                            }
                            RB = XN2.RB(str);
                            if (RB != null) {
                                valueOf = RB.Hv();
                                if (valueOf == null || u.ar(valueOf)) {
                                    obj = 1;
                                }
                                if (obj == null) {
                                    K = com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                                    a.f.b.j.o(K, "service(IMessengerStorage::class.java)");
                                    ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XN().RC(RB.Hv());
                                }
                            }
                            adVar = radarMemberView.ehM;
                            if (adVar != null) {
                                adVar.iz(obj4);
                            }
                            com.tencent.mm.model.t.b(radarMemberView.ehM, obj4);
                        }
                        RB = RB2;
                        if (RB != null) {
                        }
                        adVar = radarMemberView.ehM;
                        if (adVar != null) {
                        }
                        com.tencent.mm.model.t.b(radarMemberView.ehM, obj4);
                    }
                    TextView memberNameTv = radarMemberView.getMemberNameTv();
                    if (memberNameTv != null) {
                        memberNameTv.setText(obj4);
                    }
                    AppMethodBeat.o(102984);
                    return true;
                }
                AppMethodBeat.o(102984);
                return false;
            }
        }
        str2 = "";
        if (bo.isNullOrNil(str2)) {
        }
    }
}
