package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C37474b;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.KeyboardLinearLayout.C44246a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.bizui.widget.BizKeyboardLinearLayout;
import com.tencent.p177mm.plugin.brandservice.p349ui.widget.MPSmileyFooter;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35838f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C44136kl;
import com.tencent.p177mm.protocal.protobuf.C46537ep;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Iterator;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001@B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\u0006\u0010*\u001a\u00020%J\b\u0010+\u001a\u00020%H\u0002J\u000e\u0010,\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010-\u001a\u00020\u0019H\u0002J\u0006\u0010.\u001a\u00020%J\u0010\u0010/\u001a\u0004\u0018\u00010\b2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020%J\u0006\u00103\u001a\u00020\u0019J\b\u00104\u001a\u00020%H\u0002J\u0006\u00105\u001a\u00020%J\u0006\u00106\u001a\u00020%J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\u0016H\u0002J\u000e\u00109\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010:\u001a\u00020%H\u0002J\u000e\u0010;\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;", "cancelTv", "Landroid/widget/TextView;", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "currentKbState", "", "fixHeight", "isHaokan", "", "kbLayout", "Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;", "myCommentTitleTv", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "root", "sayFooter", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPSmileyFooter;", "adjustContentHeight", "", "newMarginBottom", "contentEtOnClick", "fixKeyBoardMargin", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "onDestroy", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "saveRootHeight", "height", "setController", "show", "showLayout", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "BizVideoMyCommentItemAdapter", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout */
public final class MPVideoWriteCommentLayout extends RelativeLayout {
    private final String TAG = "MicroMsg.MPVideoWriteCommentLayout";
    private View gtH;
    private View jWH;
    C45767b jWx;
    BizKeyboardLinearLayout jXU;
    MPSmileyFooter jXV;
    private TextView jXW;
    private Button jXX;
    private MMEditText jXY;
    ListView jXZ;
    View jYa;
    TextView jYb;
    private TextView jYc;
    C20095a jYd;
    int jYe = -1;
    boolean jYf;
    private int jYg;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$1 */
    static final class C200931 implements OnClickListener {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        C200931(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(15275);
            MPVideoWriteCommentLayout.m31103d(this.jYh);
            AppMethodBeat.m2505o(15275);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u0003234B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J$\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(J\u001c\u0010)\u001a\u00020\u00152\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060+2\u0006\u0010,\u001a\u00020-J\u001c\u0010.\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010\u00062\n\u00100\u001a\u000601R\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;)V", "getController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "setController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;)V", "deleteStr", "", "getDeleteStr", "()Ljava/lang/CharSequence;", "setDeleteStr", "(Ljava/lang/CharSequence;)V", "clear", "", "getCount", "", "getItem", "position", "getItemId", "", "i", "getView", "Landroid/view/View;", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "initDeleteText", "textView", "Landroid/widget/TextView;", "onDeleteComment", "", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "update", "items", "", "clearUpdate", "", "updateCommentContentView", "info", "itemView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$a */
    public static final class C20095a extends BaseAdapter {
        static final String TAG = TAG;
        private static C25814c jWW = new C17927a().ahE().ahD().mo33448ct(120, 120).mo33441a((C37474b) new C35838f()).mo33453sD(C43217c.bGF()).ahG();
        public static final C20098c jYj = new C20098c();
        private final Context context;
        final LinkedList<C44136kl> eow;
        private CharSequence jWU;
        C45767b jWx;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\"\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;Landroid/view/View;)V", "deleteTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDeleteTv", "()Landroid/widget/TextView;", "setDeleteTv", "(Landroid/widget/TextView;)V", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeTv", "getLikeTv", "setLikeTv", "nickName", "getNickName", "setNickName", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$a$a */
        public final class C20096a {
            TextView jWY;
            TextView jWZ;
            NeatTextView jXa;
            TextView jXb;
            final /* synthetic */ C20095a jYk;

            public C20096a(C20095a c20095a, View view) {
                C25052j.m39376p(view, "itemView");
                this.jYk = c20095a;
                AppMethodBeat.m2504i(15281);
                this.jWY = (TextView) view.findViewById(2131826152);
                this.jWZ = (TextView) view.findViewById(2131826154);
                this.jXa = (NeatTextView) view.findViewById(2131826155);
                this.jXb = (TextView) view.findViewById(2131826156);
                this.jWY.setTextColor(c20095a.context.getResources().getColor(C25738R.color.f12085rt));
                this.jXa.setTextColor(c20095a.context.getResources().getColor(C25738R.color.f11781h3));
                this.jXb.setTextColor(c20095a.context.getResources().getColor(C25738R.color.a85));
                AppMethodBeat.m2505o(15281);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00060\u0013R\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u0011¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$a$b */
        public final class C20097b {
            final ImageView gvq;
            private final LinearLayout jXf;
            private LinearLayout jXg;
            LinearLayout jXi;
            final /* synthetic */ C20095a jYk;
            C20096a jYl;

            public C20097b(C20095a c20095a, View view) {
                C25052j.m39376p(view, "itemView");
                this.jYk = c20095a;
                AppMethodBeat.m2504i(15282);
                this.gvq = (ImageView) view.findViewById(2131826157);
                this.jXf = (LinearLayout) view.findViewById(2131826158);
                this.jXg = (LinearLayout) view.findViewById(2131826159);
                this.jXi = (LinearLayout) view.findViewById(2131826161);
                LinearLayout linearLayout = this.jXg;
                C25052j.m39375o(linearLayout, "fansLayout");
                this.jYl = new C20096a(c20095a, linearLayout);
                AppMethodBeat.m2505o(15282);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$Companion;", "", "()V", "TAG", "", "option", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getOption", "()Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "setOption", "(Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;)V", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$a$c */
        public static final class C20098c {
            private C20098c() {
            }

            public /* synthetic */ C20098c(byte b) {
                this();
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$a$d */
        static final class C20099d implements OnClickListener {
            final /* synthetic */ C44136kl jXm;
            final /* synthetic */ C20095a jYk;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
            /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$a$d$a */
            static final class C20094a implements DialogInterface.OnClickListener {
                final /* synthetic */ C20099d jYm;

                C20094a(C20099d c20099d) {
                    this.jYm = c20099d;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(15283);
                    C46537ep c46537ep = new C46537ep();
                    c46537ep.vGr = this.jYm.jXm.vGr;
                    c46537ep.kdC = 2;
                    this.jYm.jYk.jWx.mo73555a(c46537ep);
                    AppMethodBeat.m2505o(15283);
                }
            }

            C20099d(C20095a c20095a, C44136kl c44136kl) {
                this.jYk = c20095a;
                this.jXm = c44136kl;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(15284);
                new C5652a(this.jYk.context).asD(this.jYk.context.getString(C25738R.string.g5p)).asE("").mo11455Qe(this.jYk.context.getResources().getColor(C25738R.color.f11672cu)).mo11453Qc(C25738R.string.f9187s6).mo11457a((DialogInterface.OnClickListener) new C20094a(this)).mo11454Qd(C25738R.string.abn).aMb().show();
                AppMethodBeat.m2505o(15284);
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(15288);
            C44136kl sC = m31095sC(i);
            AppMethodBeat.m2505o(15288);
            return sC;
        }

        public C20095a(Context context, LinkedList<C44136kl> linkedList, C45767b c45767b) {
            C25052j.m39376p(context, "context");
            C25052j.m39376p(linkedList, "list");
            C25052j.m39376p(c45767b, "controller");
            AppMethodBeat.m2504i(15291);
            this.context = context;
            this.eow = linkedList;
            this.jWx = c45767b;
            AppMethodBeat.m2505o(15291);
        }

        static {
            AppMethodBeat.m2504i(15292);
            AppMethodBeat.m2505o(15292);
        }

        public final void clear() {
            AppMethodBeat.m2504i(15285);
            this.eow.clear();
            notifyDataSetChanged();
            AppMethodBeat.m2505o(15285);
        }

        /* renamed from: b */
        public final String mo35331b(C46537ep c46537ep) {
            String str;
            AppMethodBeat.m2504i(15286);
            C25052j.m39376p(c46537ep, "req");
            Iterator it = this.eow.iterator();
            while (it.hasNext()) {
                C44136kl c44136kl = (C44136kl) it.next();
                if (c46537ep.vGr == c44136kl.vGr) {
                    String str2 = c44136kl.vGs;
                    this.eow.remove(c44136kl);
                    notifyDataSetChanged();
                    str = str2;
                    break;
                }
            }
            str = null;
            AppMethodBeat.m2505o(15286);
            return str;
        }

        /* renamed from: sC */
        private C44136kl m31095sC(int i) {
            AppMethodBeat.m2504i(15287);
            C44136kl c44136kl = (C44136kl) C25035t.m39361x(this.eow, i);
            AppMethodBeat.m2505o(15287);
            return c44136kl;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(15289);
            int size = this.eow.size();
            AppMethodBeat.m2505o(15289);
            return size;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C20097b c20097b;
            AppMethodBeat.m2504i(15290);
            C25052j.m39376p(viewGroup, "viewGroup");
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(2130970249, null, false);
                C25052j.m39375o(view, "convertView");
                C20097b c20097b2 = new C20097b(this, view);
                view.setTag(c20097b2);
                c20097b = c20097b2;
            } else {
                Object tag = view.getTag();
                if (tag == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout.BizVideoMyCommentItemAdapter.BizCommentViewHolder");
                    AppMethodBeat.m2505o(15290);
                    throw c44941v;
                }
                c20097b = (C20097b) tag;
            }
            C44136kl sC = m31095sC(i);
            if (sC != null) {
                C25052j.m39376p(sC, "info");
                C32291o.ahp().mo43766a(sC.kbV, c20097b.gvq, jWW);
                C20095a c20095a = c20097b.jYk;
                C20096a c20096a = c20097b.jYl;
                C25052j.m39376p(c20096a, "itemView");
                if (sC != null) {
                    Context context = c20095a.context;
                    CharSequence charSequence = sC.kKw;
                    TextView textView = c20096a.jWY;
                    C25052j.m39375o(textView, "itemView.nickName");
                    SpannableString b = C44089j.m79293b(context, charSequence, textView.getTextSize());
                    TextView textView2 = c20096a.jWY;
                    C25052j.m39375o(textView2, "itemView.nickName");
                    textView2.setText(b);
                    context = c20095a.context;
                    charSequence = sC.content;
                    NeatTextView neatTextView = c20096a.jXa;
                    C25052j.m39375o(neatTextView, "itemView.desc");
                    c20096a.jXa.mo15921ah(C44089j.m79293b(context, charSequence, neatTextView.getTextSize()));
                    TextView textView3 = c20096a.jXb;
                    C25052j.m39375o(textView3, "itemView.deleteTv");
                    textView3.setVisibility(0);
                    TextView textView4 = c20096a.jXb;
                    C25052j.m39375o(textView4, "itemView.deleteTv");
                    if (c20095a.jWU == null) {
                        int textSize = (int) (((double) textView4.getTextSize()) * 1.2d);
                        String string = c20095a.context.getString(C25738R.string.f9088p4);
                        Drawable drawable = c20095a.context.getResources().getDrawable(C25738R.drawable.axo);
                        drawable.setBounds(0, 0, textSize, textSize);
                        C5664a c5664a = new C5664a(drawable);
                        new SpannableString("@").setSpan(c5664a, 0, 1, 33);
                        c20095a.jWU = TextUtils.concat(new CharSequence[]{r1, " ", string});
                    }
                    textView4.setText(c20095a.jWU);
                    c20096a.jXb.setOnClickListener(new C20099d(c20095a, sC));
                    textView3 = c20096a.jWZ;
                    C25052j.m39375o(textView3, "itemView.likeTv");
                    textView3.setVisibility(8);
                }
            }
            LinearLayout linearLayout;
            if (i == getCount() - 1) {
                linearLayout = c20097b.jXi;
                C25052j.m39375o(linearLayout, "holder.endlineLayout");
                linearLayout.setVisibility(0);
                this.jWx.mo73562sB(2);
            } else {
                linearLayout = c20097b.jXi;
                C25052j.m39375o(linearLayout, "holder.endlineLayout");
                linearLayout.setVisibility(8);
            }
            AppMethodBeat.m2505o(15290);
            return view;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "state", "", "onKeyBoardStateChange"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$c */
    static final class C20100c implements C44246a {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;
        final /* synthetic */ BizKeyboardLinearLayout jYn;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$c$1 */
        static final class C27501 implements Runnable {
            final /* synthetic */ C20100c jYo;

            C27501(C20100c c20100c) {
                this.jYo = c20100c;
            }

            public final void run() {
                AppMethodBeat.m2504i(15293);
                this.jYo.jYh.jXV.aYS();
                this.jYo.jYh.jXV.postInvalidate();
                this.jYo.jYh.jWH.postInvalidate();
                AppMethodBeat.m2505o(15293);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$c$2 */
        static final class C201012 implements Runnable {
            final /* synthetic */ C20100c jYo;

            C201012(C20100c c20100c) {
                this.jYo = c20100c;
            }

            public final void run() {
                AppMethodBeat.m2504i(15294);
                this.jYo.jYh.jXV.aYT();
                this.jYo.jYh.jXV.postInvalidate();
                this.jYo.jYh.jWH.postInvalidate();
                AppMethodBeat.m2505o(15294);
            }
        }

        C20100c(MPVideoWriteCommentLayout mPVideoWriteCommentLayout, BizKeyboardLinearLayout bizKeyboardLinearLayout) {
            this.jYh = mPVideoWriteCommentLayout;
            this.jYn = bizKeyboardLinearLayout;
        }

        /* renamed from: sD */
        public final void mo7486sD(int i) {
            AppMethodBeat.m2504i(15295);
            C4990ab.m7416i(this.jYh.TAG, "onKeyBoardStateChange, state = ".concat(String.valueOf(i)));
            if (i == -3) {
                int keyBoardHeight = this.jYn.getKeyBoardHeight();
                if (keyBoardHeight > 0) {
                    MPVideoWriteCommentLayout.m31099a(this.jYh, keyBoardHeight);
                    MPVideoWriteCommentLayout.m31099a(this.jYh, keyBoardHeight);
                }
                new C7306ak().postDelayed(new C27501(this), 10);
            } else {
                MPVideoWriteCommentLayout.m31099a(this.jYh, 0);
                MPVideoWriteCommentLayout.m31099a(this.jYh, 0);
                new C7306ak().postDelayed(new C201012(this), 10);
            }
            this.jYh.jYe = i;
            AppMethodBeat.m2505o(15295);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$6", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$6 */
    public static final class C201026 implements TextWatcher {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        C201026(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(15280);
            Button i4 = this.jYh.jXX;
            Editable text = this.jYh.jXY.getText();
            C25052j.m39375o(text, "contentEt.text");
            i4.setEnabled(((CharSequence) text).length() > 0);
            AppMethodBeat.m2505o(15280);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$d */
    static final class C20103d implements Runnable {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        C20103d(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void run() {
            AppMethodBeat.m2504i(15296);
            MPVideoWriteCommentLayout.m31103d(this.jYh);
            Object systemService = this.jYh.getContext().getSystemService("input_method");
            if (systemService == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                AppMethodBeat.m2505o(15296);
                throw c44941v;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.jYh.jXY, 0);
                AppMethodBeat.m2505o(15296);
                return;
            }
            AppMethodBeat.m2505o(15296);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$b */
    public static final class C20104b implements AnimationListener {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        C20104b(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(138523);
            C25052j.m39376p(animation, "ani");
            MPVideoWriteCommentLayout.m31105f(this.jYh).setVisibility(8);
            this.jYh.jWH.clearAnimation();
            AppMethodBeat.m2505o(138523);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$3 */
    static final class C201053 implements OnClickListener {
        public static final C201053 jYi = new C201053();

        static {
            AppMethodBeat.m2504i(15277);
            AppMethodBeat.m2505o(15277);
        }

        C201053() {
        }

        public final void onClick(View view) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$4 */
    static final class C201064 implements OnClickListener {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        C201064(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(15278);
            this.jYh.hide();
            AppMethodBeat.m2505o(15278);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$2 */
    static final class C201082 implements OnLongClickListener {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        C201082(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(15276);
            MPVideoWriteCommentLayout.m31103d(this.jYh);
            AppMethodBeat.m2505o(15276);
            return false;
        }
    }

    public MPVideoWriteCommentLayout(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(15305);
        View.inflate(context, 2130970258, this);
        View findViewById = findViewById(2131826203);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_my_comment_list)");
        this.jXZ = (ListView) findViewById;
        findViewById = findViewById(2131826195);
        C25052j.m39375o(findViewById, "findViewById(R.id.mp_video_comment_root)");
        this.jWH = findViewById;
        findViewById = findViewById(2131826196);
        C25052j.m39375o(findViewById, "findViewById(R.id.mp_video_comment_action_layout)");
        this.gtH = findViewById;
        findViewById = findViewById(2131826197);
        C25052j.m39375o(findViewById, "findViewById(R.id.mp_video_comment_cancel)");
        this.jXW = (TextView) findViewById;
        findViewById = findViewById(2131826202);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_my_comment_tv)");
        this.jYb = (TextView) findViewById;
        findViewById = findViewById(2131826198);
        C25052j.m39375o(findViewById, "findViewById(R.id.mp_video_my_comment_title)");
        this.jYc = (TextView) findViewById;
        findViewById = findViewById(2131826200);
        C25052j.m39375o(findViewById, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
        this.jYa = findViewById;
        findViewById = findViewById(2131826199);
        C25052j.m39375o(findViewById, "findViewById(R.id.mp_video_comment_ok)");
        this.jXX = (Button) findViewById;
        findViewById = findViewById(2131826201);
        C25052j.m39375o(findViewById, "findViewById(R.id.mp_video_comment_et)");
        this.jXY = (MMEditText) findViewById;
        findViewById = findViewById(2131826204);
        C25052j.m39375o(findViewById, "findViewById(R.id.mp_smiley_footer)");
        this.jXV = (MPSmileyFooter) findViewById;
        this.jXV.setMMEditText(this.jXY);
        this.jXV.setVisibility(8);
        this.jXY.setOnClickListener(new C200931(this));
        this.jXY.setOnLongClickListener(new C201082(this));
        this.jWH.setOnClickListener(C201053.jYi);
        int rootHeight = getRootHeight();
        if (rootHeight > 0) {
            LayoutParams layoutParams = this.jWH.getLayoutParams();
            if (layoutParams == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                AppMethodBeat.m2505o(15305);
                throw c44941v;
            }
            layoutParams.height = rootHeight;
            this.jWH.setLayoutParams(layoutParams);
        }
        this.jXW.setOnClickListener(new C201064(this));
        this.jXX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MPVideoWriteCommentLayout jYh;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(15279);
                if (MPVideoWriteCommentLayout.m31106g(this.jYh) != null) {
                    if (this.jYh.jYf) {
                        MPVideoWriteCommentLayout.m31106g(this.jYh).mo73560ao(4, this.jYh.jXY.getText().toString());
                        this.jYh.hide();
                        AppMethodBeat.m2505o(15279);
                        return;
                    }
                    Context context = context;
                    if (context == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.m2505o(15279);
                        throw c44941v;
                    }
                    ((MMActivity) context).aqX();
                    if (this.jYh.jXV.aYV()) {
                        this.jYh.jXV.aYW();
                    }
                    C46537ep c46537ep = new C46537ep();
                    c46537ep.content = this.jYh.jXY.getText().toString();
                    c46537ep.kdC = 1;
                    MPVideoWriteCommentLayout.m31106g(this.jYh).mo73555a(c46537ep);
                }
                AppMethodBeat.m2505o(15279);
            }
        });
        this.jXY.addTextChangedListener(new C201026(this));
        Button button = this.jXX;
        Editable text = this.jXY.getText();
        C25052j.m39375o(text, "contentEt.text");
        button.setEnabled(((CharSequence) text).length() > 0);
        AppMethodBeat.m2505o(15305);
    }

    /* renamed from: f */
    public static final /* synthetic */ BizKeyboardLinearLayout m31105f(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.m2504i(138525);
        BizKeyboardLinearLayout bizKeyboardLinearLayout = mPVideoWriteCommentLayout.jXU;
        if (bizKeyboardLinearLayout == null) {
            C25052j.avw("kbLayout");
        }
        AppMethodBeat.m2505o(138525);
        return bizKeyboardLinearLayout;
    }

    /* renamed from: g */
    public static final /* synthetic */ C45767b m31106g(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.m2504i(15308);
        C45767b c45767b = mPVideoWriteCommentLayout.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        AppMethodBeat.m2505o(15308);
        return c45767b;
    }

    public final void setController(C45767b c45767b) {
        AppMethodBeat.m2504i(15297);
        C25052j.m39376p(c45767b, "controller");
        this.jWx = c45767b;
        AppMethodBeat.m2505o(15297);
    }

    /* Access modifiers changed, original: final */
    public final void aYM() {
        AppMethodBeat.m2504i(15298);
        View view = this.jYa;
        Context context = getContext();
        C25052j.m39375o(context, "context");
        view.setBackgroundColor(context.getResources().getColor(C25738R.color.f11777gz));
        this.jYb.setVisibility(8);
        AppMethodBeat.m2505o(15298);
    }

    /* renamed from: fA */
    public final void mo35342fA(boolean z) {
        AppMethodBeat.m2504i(15299);
        this.jYf = z;
        show();
        postDelayed(new C20103d(this), 10);
        View view = this.jYa;
        Context context = getContext();
        C25052j.m39375o(context, "context");
        view.setBackgroundColor(context.getResources().getColor(C25738R.color.f11777gz));
        Button button;
        if (z) {
            this.jYb.setVisibility(8);
            this.jYc.setText(getContext().getString(C25738R.string.g5w));
            this.jXY.setHint(C25738R.string.g5y);
            this.jXX.setText(C25738R.string.f9221tf);
            button = this.jXX;
            context = getContext();
            C25052j.m39375o(context, "context");
            button.setBackground(context.getResources().getDrawable(C25738R.drawable.f6463f0));
            this.jXY.setFilters(new InputFilter[]{new LengthFilter(200)});
            AppMethodBeat.m2505o(15299);
            return;
        }
        C45767b c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        c45767b.mo73562sB(2);
        this.jYc.setText(getContext().getString(C25738R.string.g62));
        this.jXY.setHint(C25738R.string.g64);
        this.jXX.setText(C25738R.string.g5o);
        button = this.jXX;
        context = getContext();
        C25052j.m39375o(context, "context");
        button.setBackground(context.getResources().getDrawable(C25738R.drawable.f6462ez));
        this.jXY.setFilters(new InputFilter[]{new LengthFilter(600)});
        AppMethodBeat.m2505o(15299);
    }

    public final void aYN() {
        AppMethodBeat.m2504i(15300);
        this.jXY.setText("");
        C45767b c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        c45767b.jVy = 0;
        c45767b = this.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        c45767b.mo73562sB(2);
        AppMethodBeat.m2505o(15300);
    }

    private final int getRootHeight() {
        AppMethodBeat.m2504i(15301);
        C5018as eg = C5018as.m7465eg("brandService", 1);
        if (eg != null) {
            int i = eg.getInt("MPWriteCommentRootHeight", 0);
            AppMethodBeat.m2505o(15301);
            return i;
        }
        AppMethodBeat.m2505o(15301);
        return 0;
    }

    private final void show() {
        AppMethodBeat.m2504i(15302);
        this.jWH.clearAnimation();
        BizKeyboardLinearLayout bizKeyboardLinearLayout = this.jXU;
        if (bizKeyboardLinearLayout == null) {
            C25052j.avw("kbLayout");
        }
        bizKeyboardLinearLayout.setVisibility(0);
        Context context = getContext();
        if (context == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
            AppMethodBeat.m2505o(15302);
            throw c44941v;
        }
        ((BizVideoDetailUI) context).mo17555fz(false);
        AppMethodBeat.m2505o(15302);
    }

    public final void hide() {
        AppMethodBeat.m2504i(15303);
        if (aFF()) {
            if (this.jXV.aYV()) {
                this.jXV.aYW();
            }
            aYO();
            Context context = getContext();
            C44941v c44941v;
            if (context == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.m2505o(15303);
                throw c44941v;
            }
            ((MMActivity) context).aqX();
            C45767b c45767b = this.jWx;
            if (c45767b == null) {
                C25052j.avw("controller");
            }
            c45767b.jVy = 0;
            C20095a c20095a = this.jYd;
            if (c20095a != null) {
                c20095a.clear();
            }
            context = getContext();
            if (context == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
                AppMethodBeat.m2505o(15303);
                throw c44941v;
            }
            ((BizVideoDetailUI) context).mo17555fz(true);
            AppMethodBeat.m2505o(15303);
            return;
        }
        AppMethodBeat.m2505o(15303);
    }

    private final void aYO() {
        AppMethodBeat.m2504i(138524);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(150);
        translateAnimation.setFillAfter(false);
        translateAnimation.setAnimationListener(new C20104b(this));
        this.jWH.clearAnimation();
        this.jWH.startAnimation(translateAnimation);
        AppMethodBeat.m2505o(138524);
    }

    /* Access modifiers changed, original: final */
    public final boolean aFF() {
        AppMethodBeat.m2504i(15304);
        BizKeyboardLinearLayout bizKeyboardLinearLayout = this.jXU;
        if (bizKeyboardLinearLayout == null) {
            C25052j.avw("kbLayout");
        }
        if (bizKeyboardLinearLayout.getVisibility() == 0) {
            AppMethodBeat.m2505o(15304);
            return true;
        }
        AppMethodBeat.m2505o(15304);
        return false;
    }

    /* renamed from: a */
    public static final /* synthetic */ void m31099a(MPVideoWriteCommentLayout mPVideoWriteCommentLayout, int i) {
        AppMethodBeat.m2504i(15306);
        int height = mPVideoWriteCommentLayout.jWH.getHeight();
        LayoutParams layoutParams = mPVideoWriteCommentLayout.jWH.getLayoutParams();
        C44941v c44941v;
        if (layoutParams == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.m2505o(15306);
            throw c44941v;
        }
        int height2 = (mPVideoWriteCommentLayout.jXY.getHeight() + mPVideoWriteCommentLayout.gtH.getHeight()) + C1338a.fromDPToPix(mPVideoWriteCommentLayout.getContext(), 60);
        if (i > 0 && height != mPVideoWriteCommentLayout.jYg) {
            layoutParams.height = i + height2;
            height2 = C5230ak.getStatusBarHeight(mPVideoWriteCommentLayout.getContext());
            int i2 = C5230ak.m7993hy(mPVideoWriteCommentLayout.getContext()).y;
            height = i2 - height2;
            if (layoutParams.height > height) {
                layoutParams.height = height;
            } else {
                Context context = mPVideoWriteCommentLayout.getContext();
                if (context == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
                    AppMethodBeat.m2505o(15306);
                    throw c44941v;
                }
                height = ((BizVideoDetailUI) context).jWw;
                int fromDPToPix = C1338a.fromDPToPix(mPVideoWriteCommentLayout.getContext(), 20);
                if (layoutParams.height < ((i2 - height) - height2) + fromDPToPix) {
                    layoutParams.height = ((i2 - height2) - height) + fromDPToPix;
                }
            }
            mPVideoWriteCommentLayout.jWH.setLayoutParams(layoutParams);
            mPVideoWriteCommentLayout.jYg = layoutParams.height;
            height = layoutParams.height;
            C5018as eg = C5018as.m7465eg("brandService", 1);
            eg.encode("MPWriteCommentRootHeight", height);
            eg.apply();
            height = ((mPVideoWriteCommentLayout.jWH.getHeight() - mPVideoWriteCommentLayout.gtH.getHeight()) - i) - C1338a.fromDPToPix(mPVideoWriteCommentLayout.getContext(), 35);
            if (height > mPVideoWriteCommentLayout.jXY.getHeight()) {
                layoutParams = mPVideoWriteCommentLayout.jXY.getLayoutParams();
                if (layoutParams == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    AppMethodBeat.m2505o(15306);
                    throw c44941v;
                }
                layoutParams.height = height;
                mPVideoWriteCommentLayout.jXY.setLayoutParams(layoutParams);
            }
            mPVideoWriteCommentLayout.jXY.setMaxHeight(mPVideoWriteCommentLayout.jXY.getHeight());
        }
        AppMethodBeat.m2505o(15306);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m31103d(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.m2504i(15307);
        mPVideoWriteCommentLayout.jXY.requestFocus();
        C4990ab.m7410d(mPVideoWriteCommentLayout.TAG, "request fouces");
        if (mPVideoWriteCommentLayout.jXV.aYV()) {
            mPVideoWriteCommentLayout.jXV.aYW();
        }
        if (!C40619x.m70075gu(mPVideoWriteCommentLayout.getContext())) {
            mPVideoWriteCommentLayout.jXV.aYS();
        }
        mPVideoWriteCommentLayout.jWH.postInvalidate();
        AppMethodBeat.m2505o(15307);
    }
}
