package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.a.t;
import a.f.b.j;
import a.l;
import a.v;
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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.bizui.widget.BizKeyboardLinearLayout;
import com.tencent.mm.plugin.brandservice.ui.widget.MPSmileyFooter;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.Iterator;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001@B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\u0006\u0010*\u001a\u00020%J\b\u0010+\u001a\u00020%H\u0002J\u000e\u0010,\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010-\u001a\u00020\u0019H\u0002J\u0006\u0010.\u001a\u00020%J\u0010\u0010/\u001a\u0004\u0018\u00010\b2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020%J\u0006\u00103\u001a\u00020\u0019J\b\u00104\u001a\u00020%H\u0002J\u0006\u00105\u001a\u00020%J\u0006\u00106\u001a\u00020%J\u0010\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\u0016H\u0002J\u000e\u00109\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010:\u001a\u00020%H\u0002J\u000e\u0010;\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "actionView", "Landroid/view/View;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;", "cancelTv", "Landroid/widget/TextView;", "commitBt", "Landroid/widget/Button;", "contentEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "currentKbState", "", "fixHeight", "isHaokan", "", "kbLayout", "Lcom/tencent/mm/plugin/bizui/widget/BizKeyboardLinearLayout;", "myCommentTitleTv", "myCommentTv", "myCommentView", "recyclerView", "Landroid/widget/ListView;", "root", "sayFooter", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPSmileyFooter;", "adjustContentHeight", "", "newMarginBottom", "contentEtOnClick", "fixKeyBoardMargin", "getRootHeight", "hide", "hideAnimation", "initKeyboardListener", "isShow", "onAddCommentSuccess", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "onDestroy", "onKeyBackPress", "onNoComment", "onResume", "onTouchClose", "saveRootHeight", "height", "setController", "show", "showLayout", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "clearUpdate", "BizVideoMyCommentItemAdapter", "plugin-brandservice_release"})
public final class MPVideoWriteCommentLayout extends RelativeLayout {
    private final String TAG = "MicroMsg.MPVideoWriteCommentLayout";
    private View gtH;
    private View jWH;
    b jWx;
    BizKeyboardLinearLayout jXU;
    MPSmileyFooter jXV;
    private TextView jXW;
    private Button jXX;
    private MMEditText jXY;
    ListView jXZ;
    View jYa;
    TextView jYb;
    private TextView jYc;
    a jYd;
    int jYe = -1;
    boolean jYf;
    private int jYg;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        AnonymousClass1(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(15275);
            MPVideoWriteCommentLayout.d(this.jYh);
            AppMethodBeat.o(15275);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u0003234B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J$\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(J\u001c\u0010)\u001a\u00020\u00152\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060+2\u0006\u0010,\u001a\u00020-J\u001c\u0010.\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010\u00062\n\u00100\u001a\u000601R\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;)V", "getController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "setController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;)V", "deleteStr", "", "getDeleteStr", "()Ljava/lang/CharSequence;", "setDeleteStr", "(Ljava/lang/CharSequence;)V", "clear", "", "getCount", "", "getItem", "position", "getItemId", "", "i", "getView", "Landroid/view/View;", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "initDeleteText", "textView", "Landroid/widget/TextView;", "onDeleteComment", "", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "update", "items", "", "clearUpdate", "", "updateCommentContentView", "info", "itemView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-brandservice_release"})
    public static final class a extends BaseAdapter {
        static final String TAG = TAG;
        private static com.tencent.mm.at.a.a.c jWW = new com.tencent.mm.at.a.a.c.a().ahE().ahD().ct(120, 120).a((com.tencent.mm.at.a.c.b) new f()).sD(com.tencent.mm.plugin.i.c.bGF()).ahG();
        public static final c jYj = new c();
        private final Context context;
        final LinkedList<kl> eow;
        private CharSequence jWU;
        b jWx;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\"\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;Landroid/view/View;)V", "deleteTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDeleteTv", "()Landroid/widget/TextView;", "setDeleteTv", "(Landroid/widget/TextView;)V", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeTv", "getLikeTv", "setLikeTv", "nickName", "getNickName", "setNickName", "plugin-brandservice_release"})
        public final class a {
            TextView jWY;
            TextView jWZ;
            NeatTextView jXa;
            TextView jXb;
            final /* synthetic */ a jYk;

            public a(a aVar, View view) {
                j.p(view, "itemView");
                this.jYk = aVar;
                AppMethodBeat.i(15281);
                this.jWY = (TextView) view.findViewById(R.id.dcl);
                this.jWZ = (TextView) view.findViewById(R.id.dcn);
                this.jXa = (NeatTextView) view.findViewById(R.id.dco);
                this.jXb = (TextView) view.findViewById(R.id.dcp);
                this.jWY.setTextColor(aVar.context.getResources().getColor(R.color.rt));
                this.jXa.setTextColor(aVar.context.getResources().getColor(R.color.h3));
                this.jXb.setTextColor(aVar.context.getResources().getColor(R.color.a85));
                AppMethodBeat.o(15281);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00060\u0013R\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u0011¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentViewHolder;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatar", "()Landroid/widget/ImageView;", "content", "Landroid/widget/LinearLayout;", "getContent", "()Landroid/widget/LinearLayout;", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "(Landroid/widget/LinearLayout;)V", "fansContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter;", "getFansContent", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;", "setFansContent", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$BizCommentContent;)V", "fansLayout", "getFansLayout", "setFansLayout", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-brandservice_release"})
        public final class b {
            final ImageView gvq;
            private final LinearLayout jXf;
            private LinearLayout jXg;
            LinearLayout jXi;
            final /* synthetic */ a jYk;
            a jYl;

            public b(a aVar, View view) {
                j.p(view, "itemView");
                this.jYk = aVar;
                AppMethodBeat.i(15282);
                this.gvq = (ImageView) view.findViewById(R.id.dcq);
                this.jXf = (LinearLayout) view.findViewById(R.id.dcr);
                this.jXg = (LinearLayout) view.findViewById(R.id.dcs);
                this.jXi = (LinearLayout) view.findViewById(R.id.dcu);
                LinearLayout linearLayout = this.jXg;
                j.o(linearLayout, "fansLayout");
                this.jYl = new a(aVar, linearLayout);
                AppMethodBeat.o(15282);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$BizVideoMyCommentItemAdapter$Companion;", "", "()V", "TAG", "", "option", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getOption", "()Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "setOption", "(Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;)V", "plugin-brandservice_release"})
        public static final class c {
            private c() {
            }

            public /* synthetic */ c(byte b) {
                this();
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class d implements OnClickListener {
            final /* synthetic */ kl jXm;
            final /* synthetic */ a jYk;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
            static final class a implements DialogInterface.OnClickListener {
                final /* synthetic */ d jYm;

                a(d dVar) {
                    this.jYm = dVar;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(15283);
                    ep epVar = new ep();
                    epVar.vGr = this.jYm.jXm.vGr;
                    epVar.kdC = 2;
                    this.jYm.jYk.jWx.a(epVar);
                    AppMethodBeat.o(15283);
                }
            }

            d(a aVar, kl klVar) {
                this.jYk = aVar;
                this.jXm = klVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(15284);
                new com.tencent.mm.ui.widget.a.c.a(this.jYk.context).asD(this.jYk.context.getString(R.string.g5p)).asE("").Qe(this.jYk.context.getResources().getColor(R.color.cu)).Qc(R.string.s6).a((DialogInterface.OnClickListener) new a(this)).Qd(R.string.abn).aMb().show();
                AppMethodBeat.o(15284);
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(15288);
            kl sC = sC(i);
            AppMethodBeat.o(15288);
            return sC;
        }

        public a(Context context, LinkedList<kl> linkedList, b bVar) {
            j.p(context, "context");
            j.p(linkedList, "list");
            j.p(bVar, "controller");
            AppMethodBeat.i(15291);
            this.context = context;
            this.eow = linkedList;
            this.jWx = bVar;
            AppMethodBeat.o(15291);
        }

        static {
            AppMethodBeat.i(15292);
            AppMethodBeat.o(15292);
        }

        public final void clear() {
            AppMethodBeat.i(15285);
            this.eow.clear();
            notifyDataSetChanged();
            AppMethodBeat.o(15285);
        }

        public final String b(ep epVar) {
            String str;
            AppMethodBeat.i(15286);
            j.p(epVar, "req");
            Iterator it = this.eow.iterator();
            while (it.hasNext()) {
                kl klVar = (kl) it.next();
                if (epVar.vGr == klVar.vGr) {
                    String str2 = klVar.vGs;
                    this.eow.remove(klVar);
                    notifyDataSetChanged();
                    str = str2;
                    break;
                }
            }
            str = null;
            AppMethodBeat.o(15286);
            return str;
        }

        private kl sC(int i) {
            AppMethodBeat.i(15287);
            kl klVar = (kl) t.x(this.eow, i);
            AppMethodBeat.o(15287);
            return klVar;
        }

        public final int getCount() {
            AppMethodBeat.i(15289);
            int size = this.eow.size();
            AppMethodBeat.o(15289);
            return size;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(15290);
            j.p(viewGroup, "viewGroup");
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.layout.ahe, null, false);
                j.o(view, "convertView");
                b bVar2 = new b(this, view);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                Object tag = view.getTag();
                if (tag == null) {
                    v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout.BizVideoMyCommentItemAdapter.BizCommentViewHolder");
                    AppMethodBeat.o(15290);
                    throw vVar;
                }
                bVar = (b) tag;
            }
            kl sC = sC(i);
            if (sC != null) {
                j.p(sC, "info");
                o.ahp().a(sC.kbV, bVar.gvq, jWW);
                a aVar = bVar.jYk;
                a aVar2 = bVar.jYl;
                j.p(aVar2, "itemView");
                if (sC != null) {
                    Context context = aVar.context;
                    CharSequence charSequence = sC.kKw;
                    TextView textView = aVar2.jWY;
                    j.o(textView, "itemView.nickName");
                    SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence, textView.getTextSize());
                    TextView textView2 = aVar2.jWY;
                    j.o(textView2, "itemView.nickName");
                    textView2.setText(b);
                    context = aVar.context;
                    charSequence = sC.content;
                    NeatTextView neatTextView = aVar2.jXa;
                    j.o(neatTextView, "itemView.desc");
                    aVar2.jXa.ah(com.tencent.mm.pluginsdk.ui.e.j.b(context, charSequence, neatTextView.getTextSize()));
                    TextView textView3 = aVar2.jXb;
                    j.o(textView3, "itemView.deleteTv");
                    textView3.setVisibility(0);
                    TextView textView4 = aVar2.jXb;
                    j.o(textView4, "itemView.deleteTv");
                    if (aVar.jWU == null) {
                        int textSize = (int) (((double) textView4.getTextSize()) * 1.2d);
                        String string = aVar.context.getString(R.string.p4);
                        Drawable drawable = aVar.context.getResources().getDrawable(R.drawable.axo);
                        drawable.setBounds(0, 0, textSize, textSize);
                        com.tencent.mm.ui.widget.a aVar3 = new com.tencent.mm.ui.widget.a(drawable);
                        new SpannableString("@").setSpan(aVar3, 0, 1, 33);
                        aVar.jWU = TextUtils.concat(new CharSequence[]{r1, " ", string});
                    }
                    textView4.setText(aVar.jWU);
                    aVar2.jXb.setOnClickListener(new d(aVar, sC));
                    textView3 = aVar2.jWZ;
                    j.o(textView3, "itemView.likeTv");
                    textView3.setVisibility(8);
                }
            }
            LinearLayout linearLayout;
            if (i == getCount() - 1) {
                linearLayout = bVar.jXi;
                j.o(linearLayout, "holder.endlineLayout");
                linearLayout.setVisibility(0);
                this.jWx.sB(2);
            } else {
                linearLayout = bVar.jXi;
                j.o(linearLayout, "holder.endlineLayout");
                linearLayout.setVisibility(8);
            }
            AppMethodBeat.o(15290);
            return view;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "state", "", "onKeyBoardStateChange"})
    static final class c implements com.tencent.mm.ui.KeyboardLinearLayout.a {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;
        final /* synthetic */ BizKeyboardLinearLayout jYn;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$c$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ c jYo;

            AnonymousClass1(c cVar) {
                this.jYo = cVar;
            }

            public final void run() {
                AppMethodBeat.i(15293);
                this.jYo.jYh.jXV.aYS();
                this.jYo.jYh.jXV.postInvalidate();
                this.jYo.jYh.jWH.postInvalidate();
                AppMethodBeat.o(15293);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$c$2 */
        static final class AnonymousClass2 implements Runnable {
            final /* synthetic */ c jYo;

            AnonymousClass2(c cVar) {
                this.jYo = cVar;
            }

            public final void run() {
                AppMethodBeat.i(15294);
                this.jYo.jYh.jXV.aYT();
                this.jYo.jYh.jXV.postInvalidate();
                this.jYo.jYh.jWH.postInvalidate();
                AppMethodBeat.o(15294);
            }
        }

        c(MPVideoWriteCommentLayout mPVideoWriteCommentLayout, BizKeyboardLinearLayout bizKeyboardLinearLayout) {
            this.jYh = mPVideoWriteCommentLayout;
            this.jYn = bizKeyboardLinearLayout;
        }

        public final void sD(int i) {
            AppMethodBeat.i(15295);
            ab.i(this.jYh.TAG, "onKeyBoardStateChange, state = ".concat(String.valueOf(i)));
            if (i == -3) {
                int keyBoardHeight = this.jYn.getKeyBoardHeight();
                if (keyBoardHeight > 0) {
                    MPVideoWriteCommentLayout.a(this.jYh, keyBoardHeight);
                    MPVideoWriteCommentLayout.a(this.jYh, keyBoardHeight);
                }
                new ak().postDelayed(new AnonymousClass1(this), 10);
            } else {
                MPVideoWriteCommentLayout.a(this.jYh, 0);
                MPVideoWriteCommentLayout.a(this.jYh, 0);
                new ak().postDelayed(new AnonymousClass2(this), 10);
            }
            this.jYh.jYe = i;
            AppMethodBeat.o(15295);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$6", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$6 */
    public static final class AnonymousClass6 implements TextWatcher {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        AnonymousClass6(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(15280);
            Button i4 = this.jYh.jXX;
            Editable text = this.jYh.jXY.getText();
            j.o(text, "contentEt.text");
            i4.setEnabled(((CharSequence) text).length() > 0);
            AppMethodBeat.o(15280);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        d(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void run() {
            AppMethodBeat.i(15296);
            MPVideoWriteCommentLayout.d(this.jYh);
            Object systemService = this.jYh.getContext().getSystemService("input_method");
            if (systemService == null) {
                v vVar = new v("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                AppMethodBeat.o(15296);
                throw vVar;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.jYh.jXY, 0);
                AppMethodBeat.o(15296);
                return;
            }
            AppMethodBeat.o(15296);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout$hideAnimation$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "ani", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-brandservice_release"})
    public static final class b implements AnimationListener {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        b(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(138523);
            j.p(animation, "ani");
            MPVideoWriteCommentLayout.f(this.jYh).setVisibility(8);
            this.jYh.jWH.clearAnimation();
            AppMethodBeat.o(138523);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$4 */
    static final class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        AnonymousClass4(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(15278);
            this.jYh.hide();
            AppMethodBeat.o(15278);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoWriteCommentLayout$2 */
    static final class AnonymousClass2 implements OnLongClickListener {
        final /* synthetic */ MPVideoWriteCommentLayout jYh;

        AnonymousClass2(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
            this.jYh = mPVideoWriteCommentLayout;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(15276);
            MPVideoWriteCommentLayout.d(this.jYh);
            AppMethodBeat.o(15276);
            return false;
        }
    }

    public MPVideoWriteCommentLayout(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(15305);
        View.inflate(context, R.layout.ahn, this);
        View findViewById = findViewById(R.id.ddz);
        j.o(findViewById, "findViewById(R.id.biz_video_my_comment_list)");
        this.jXZ = (ListView) findViewById;
        findViewById = findViewById(R.id.ddr);
        j.o(findViewById, "findViewById(R.id.mp_video_comment_root)");
        this.jWH = findViewById;
        findViewById = findViewById(R.id.dds);
        j.o(findViewById, "findViewById(R.id.mp_video_comment_action_layout)");
        this.gtH = findViewById;
        findViewById = findViewById(R.id.ddt);
        j.o(findViewById, "findViewById(R.id.mp_video_comment_cancel)");
        this.jXW = (TextView) findViewById;
        findViewById = findViewById(R.id.ddy);
        j.o(findViewById, "findViewById(R.id.biz_video_my_comment_tv)");
        this.jYb = (TextView) findViewById;
        findViewById = findViewById(R.id.ddu);
        j.o(findViewById, "findViewById(R.id.mp_video_my_comment_title)");
        this.jYc = (TextView) findViewById;
        findViewById = findViewById(R.id.ddw);
        j.o(findViewById, "findViewById(R.id.mp_vid…rite_comment_scroll_view)");
        this.jYa = findViewById;
        findViewById = findViewById(R.id.ddv);
        j.o(findViewById, "findViewById(R.id.mp_video_comment_ok)");
        this.jXX = (Button) findViewById;
        findViewById = findViewById(R.id.ddx);
        j.o(findViewById, "findViewById(R.id.mp_video_comment_et)");
        this.jXY = (MMEditText) findViewById;
        findViewById = findViewById(R.id.de0);
        j.o(findViewById, "findViewById(R.id.mp_smiley_footer)");
        this.jXV = (MPSmileyFooter) findViewById;
        this.jXV.setMMEditText(this.jXY);
        this.jXV.setVisibility(8);
        this.jXY.setOnClickListener(new AnonymousClass1(this));
        this.jXY.setOnLongClickListener(new AnonymousClass2(this));
        this.jWH.setOnClickListener(AnonymousClass3.jYi);
        int rootHeight = getRootHeight();
        if (rootHeight > 0) {
            LayoutParams layoutParams = this.jWH.getLayoutParams();
            if (layoutParams == null) {
                v vVar = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                AppMethodBeat.o(15305);
                throw vVar;
            }
            layoutParams.height = rootHeight;
            this.jWH.setLayoutParams(layoutParams);
        }
        this.jXW.setOnClickListener(new AnonymousClass4(this));
        this.jXX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MPVideoWriteCommentLayout jYh;

            public final void onClick(View view) {
                AppMethodBeat.i(15279);
                if (MPVideoWriteCommentLayout.g(this.jYh) != null) {
                    if (this.jYh.jYf) {
                        MPVideoWriteCommentLayout.g(this.jYh).ao(4, this.jYh.jXY.getText().toString());
                        this.jYh.hide();
                        AppMethodBeat.o(15279);
                        return;
                    }
                    Context context = context;
                    if (context == null) {
                        v vVar = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(15279);
                        throw vVar;
                    }
                    ((MMActivity) context).aqX();
                    if (this.jYh.jXV.aYV()) {
                        this.jYh.jXV.aYW();
                    }
                    ep epVar = new ep();
                    epVar.content = this.jYh.jXY.getText().toString();
                    epVar.kdC = 1;
                    MPVideoWriteCommentLayout.g(this.jYh).a(epVar);
                }
                AppMethodBeat.o(15279);
            }
        });
        this.jXY.addTextChangedListener(new AnonymousClass6(this));
        Button button = this.jXX;
        Editable text = this.jXY.getText();
        j.o(text, "contentEt.text");
        button.setEnabled(((CharSequence) text).length() > 0);
        AppMethodBeat.o(15305);
    }

    public static final /* synthetic */ BizKeyboardLinearLayout f(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.i(138525);
        BizKeyboardLinearLayout bizKeyboardLinearLayout = mPVideoWriteCommentLayout.jXU;
        if (bizKeyboardLinearLayout == null) {
            j.avw("kbLayout");
        }
        AppMethodBeat.o(138525);
        return bizKeyboardLinearLayout;
    }

    public static final /* synthetic */ b g(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.i(15308);
        b bVar = mPVideoWriteCommentLayout.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        AppMethodBeat.o(15308);
        return bVar;
    }

    public final void setController(b bVar) {
        AppMethodBeat.i(15297);
        j.p(bVar, "controller");
        this.jWx = bVar;
        AppMethodBeat.o(15297);
    }

    /* Access modifiers changed, original: final */
    public final void aYM() {
        AppMethodBeat.i(15298);
        View view = this.jYa;
        Context context = getContext();
        j.o(context, "context");
        view.setBackgroundColor(context.getResources().getColor(R.color.gz));
        this.jYb.setVisibility(8);
        AppMethodBeat.o(15298);
    }

    public final void fA(boolean z) {
        AppMethodBeat.i(15299);
        this.jYf = z;
        show();
        postDelayed(new d(this), 10);
        View view = this.jYa;
        Context context = getContext();
        j.o(context, "context");
        view.setBackgroundColor(context.getResources().getColor(R.color.gz));
        Button button;
        if (z) {
            this.jYb.setVisibility(8);
            this.jYc.setText(getContext().getString(R.string.g5w));
            this.jXY.setHint(R.string.g5y);
            this.jXX.setText(R.string.tf);
            button = this.jXX;
            context = getContext();
            j.o(context, "context");
            button.setBackground(context.getResources().getDrawable(R.drawable.f0));
            this.jXY.setFilters(new InputFilter[]{new LengthFilter(200)});
            AppMethodBeat.o(15299);
            return;
        }
        b bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        bVar.sB(2);
        this.jYc.setText(getContext().getString(R.string.g62));
        this.jXY.setHint(R.string.g64);
        this.jXX.setText(R.string.g5o);
        button = this.jXX;
        context = getContext();
        j.o(context, "context");
        button.setBackground(context.getResources().getDrawable(R.drawable.ez));
        this.jXY.setFilters(new InputFilter[]{new LengthFilter(600)});
        AppMethodBeat.o(15299);
    }

    public final void aYN() {
        AppMethodBeat.i(15300);
        this.jXY.setText("");
        b bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        bVar.jVy = 0;
        bVar = this.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        bVar.sB(2);
        AppMethodBeat.o(15300);
    }

    private final int getRootHeight() {
        AppMethodBeat.i(15301);
        as eg = as.eg("brandService", 1);
        if (eg != null) {
            int i = eg.getInt("MPWriteCommentRootHeight", 0);
            AppMethodBeat.o(15301);
            return i;
        }
        AppMethodBeat.o(15301);
        return 0;
    }

    private final void show() {
        AppMethodBeat.i(15302);
        this.jWH.clearAnimation();
        BizKeyboardLinearLayout bizKeyboardLinearLayout = this.jXU;
        if (bizKeyboardLinearLayout == null) {
            j.avw("kbLayout");
        }
        bizKeyboardLinearLayout.setVisibility(0);
        Context context = getContext();
        if (context == null) {
            v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
            AppMethodBeat.o(15302);
            throw vVar;
        }
        ((BizVideoDetailUI) context).fz(false);
        AppMethodBeat.o(15302);
    }

    public final void hide() {
        AppMethodBeat.i(15303);
        if (aFF()) {
            if (this.jXV.aYV()) {
                this.jXV.aYW();
            }
            aYO();
            Context context = getContext();
            v vVar;
            if (context == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(15303);
                throw vVar;
            }
            ((MMActivity) context).aqX();
            b bVar = this.jWx;
            if (bVar == null) {
                j.avw("controller");
            }
            bVar.jVy = 0;
            a aVar = this.jYd;
            if (aVar != null) {
                aVar.clear();
            }
            context = getContext();
            if (context == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
                AppMethodBeat.o(15303);
                throw vVar;
            }
            ((BizVideoDetailUI) context).fz(true);
            AppMethodBeat.o(15303);
            return;
        }
        AppMethodBeat.o(15303);
    }

    private final void aYO() {
        AppMethodBeat.i(138524);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(150);
        translateAnimation.setFillAfter(false);
        translateAnimation.setAnimationListener(new b(this));
        this.jWH.clearAnimation();
        this.jWH.startAnimation(translateAnimation);
        AppMethodBeat.o(138524);
    }

    /* Access modifiers changed, original: final */
    public final boolean aFF() {
        AppMethodBeat.i(15304);
        BizKeyboardLinearLayout bizKeyboardLinearLayout = this.jXU;
        if (bizKeyboardLinearLayout == null) {
            j.avw("kbLayout");
        }
        if (bizKeyboardLinearLayout.getVisibility() == 0) {
            AppMethodBeat.o(15304);
            return true;
        }
        AppMethodBeat.o(15304);
        return false;
    }

    public static final /* synthetic */ void a(MPVideoWriteCommentLayout mPVideoWriteCommentLayout, int i) {
        AppMethodBeat.i(15306);
        int height = mPVideoWriteCommentLayout.jWH.getHeight();
        LayoutParams layoutParams = mPVideoWriteCommentLayout.jWH.getLayoutParams();
        v vVar;
        if (layoutParams == null) {
            vVar = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.o(15306);
            throw vVar;
        }
        int height2 = (mPVideoWriteCommentLayout.jXY.getHeight() + mPVideoWriteCommentLayout.gtH.getHeight()) + com.tencent.mm.bz.a.fromDPToPix(mPVideoWriteCommentLayout.getContext(), 60);
        if (i > 0 && height != mPVideoWriteCommentLayout.jYg) {
            layoutParams.height = i + height2;
            height2 = com.tencent.mm.ui.ak.getStatusBarHeight(mPVideoWriteCommentLayout.getContext());
            int i2 = com.tencent.mm.ui.ak.hy(mPVideoWriteCommentLayout.getContext()).y;
            height = i2 - height2;
            if (layoutParams.height > height) {
                layoutParams.height = height;
            } else {
                Context context = mPVideoWriteCommentLayout.getContext();
                if (context == null) {
                    vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
                    AppMethodBeat.o(15306);
                    throw vVar;
                }
                height = ((BizVideoDetailUI) context).jWw;
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(mPVideoWriteCommentLayout.getContext(), 20);
                if (layoutParams.height < ((i2 - height) - height2) + fromDPToPix) {
                    layoutParams.height = ((i2 - height2) - height) + fromDPToPix;
                }
            }
            mPVideoWriteCommentLayout.jWH.setLayoutParams(layoutParams);
            mPVideoWriteCommentLayout.jYg = layoutParams.height;
            height = layoutParams.height;
            as eg = as.eg("brandService", 1);
            eg.encode("MPWriteCommentRootHeight", height);
            eg.apply();
            height = ((mPVideoWriteCommentLayout.jWH.getHeight() - mPVideoWriteCommentLayout.gtH.getHeight()) - i) - com.tencent.mm.bz.a.fromDPToPix(mPVideoWriteCommentLayout.getContext(), 35);
            if (height > mPVideoWriteCommentLayout.jXY.getHeight()) {
                layoutParams = mPVideoWriteCommentLayout.jXY.getLayoutParams();
                if (layoutParams == null) {
                    vVar = new v("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    AppMethodBeat.o(15306);
                    throw vVar;
                }
                layoutParams.height = height;
                mPVideoWriteCommentLayout.jXY.setLayoutParams(layoutParams);
            }
            mPVideoWriteCommentLayout.jXY.setMaxHeight(mPVideoWriteCommentLayout.jXY.getHeight());
        }
        AppMethodBeat.o(15306);
    }

    public static final /* synthetic */ void d(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.i(15307);
        mPVideoWriteCommentLayout.jXY.requestFocus();
        ab.d(mPVideoWriteCommentLayout.TAG, "request fouces");
        if (mPVideoWriteCommentLayout.jXV.aYV()) {
            mPVideoWriteCommentLayout.jXV.aYW();
        }
        if (!x.gu(mPVideoWriteCommentLayout.getContext())) {
            mPVideoWriteCommentLayout.jXV.aYS();
        }
        mPVideoWriteCommentLayout.jWH.postInvalidate();
        AppMethodBeat.o(15307);
    }
}
