package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.p191a.p193c.C37474b;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.C5664a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C11263c;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35838f;
import com.tencent.p177mm.protocal.protobuf.C15335el;
import com.tencent.p177mm.protocal.protobuf.C44136kl;
import com.tencent.p177mm.protocal.protobuf.C44173tp;
import com.tencent.p177mm.protocal.protobuf.C46537ep;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u001e\u0010 \u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u001cH\u0002J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0019J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001cR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;", "enable", "", "isFans", "isTmpUrl", "()I", "setTmpUrl", "(I)V", "onlyFansCanComment", "", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "selectedCommentTv", "Landroid/widget/TextView;", "writeCommentLayout", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "writeTv", "onDeleteComment", "", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "openId", "setListView", "header", "Landroid/view/View;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "setWriteComment", "setWriteCommentLayout", "layout", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "updateViewStatus", "BizCommentItemAdapter", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView */
public final class MPVideoCommentView extends RelativeLayout {
    private final String TAG = "MicroMsg.MPVideoView_back";
    int erD = 1;
    MRecyclerView jWJ;
    TextView jWK;
    TextView jWL;
    C2736a jWM;
    private MPVideoWriteCommentLayout jWN;
    int jWO = 1;
    boolean jWP;
    int jWQ;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003<=>B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u001c\u0010$\u001a\u00020!2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001c\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001dH\u0016J\u0018\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0012J \u0010.\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u001dH\u0002J\u0014\u00102\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000704J$\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u00192\n\u00107\u001a\u000608R\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007J&\u00109\u001a\u00020!2\u0006\u00106\u001a\u00020\u00192\n\u00107\u001a\u000608R\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010:\u001a\u00020!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\u00107\u001a\u000608R\u00020\u0000J\u001e\u0010;\u001a\u00020!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\u00107\u001a\u000608R\u00020\u0000H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentViewHolder;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;)V", "getController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "setController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;)V", "deleteStr", "", "fromFriend", "", "kotlin.jvm.PlatformType", "getFromFriend", "()Ljava/lang/String;", "setFromFriend", "(Ljava/lang/String;)V", "getCommentReply", "Lcom/tencent/mm/protocal/protobuf/CommentReply;", "info", "getItem", "position", "", "getItemCount", "getItemViewType", "initDeleteText", "", "textView", "Landroid/widget/TextView;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "openId", "setGood", "isGood", "", "num", "update", "items", "", "updateAuthorCommentContentView", "reply", "itemView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;", "updateAuthorLikeStatus", "updateCommentContentView", "updateCommentLikeStatus", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView$a */
    public static final class C2736a extends C41523a<C2737b> {
        static final String TAG = TAG;
        private static final int jWV = 1;
        private static C25814c jWW = new C17927a().ahE().ahD().mo33448ct(120, 120).mo33441a((C37474b) new C35838f()).mo33453sD(C43217c.bGF()).ahG();
        public static final C2740c jWX = new C2740c();
        private final Context context;
        final LinkedList<C44136kl> eow;
        private String jWT = this.context.getString(C25738R.string.g82);
        private CharSequence jWU;
        C45767b jWx;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'R\u001e\u0010\u0005\u001a\u00060\u0006R\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\u00140\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\r0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\"\u0010\u0019\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001e\u0010\u001c\u001a\u00060\u0006R\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\"\u0010\u001f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;Landroid/view/View;)V", "authorContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;", "getAuthorContent", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;", "setAuthorContent", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;)V", "authorLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getAuthorLayout", "()Landroid/widget/LinearLayout;", "setAuthorLayout", "(Landroid/widget/LinearLayout;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "getContent", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "fansContent", "getFansContent", "setFansContent", "fansLayout", "getFansLayout", "setFansLayout", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView$a$b */
        public final class C2737b extends C41531v {
            final ImageView gvq;
            final /* synthetic */ C2736a jXe;
            private final LinearLayout jXf;
            private LinearLayout jXg;
            LinearLayout jXh;
            LinearLayout jXi;
            C2739a jXj;
            C2739a jXk;

            public C2737b(C2736a c2736a, View view) {
                C25052j.m39376p(view, "itemView");
                this.jXe = c2736a;
                super(view);
                AppMethodBeat.m2504i(15228);
                this.gvq = (ImageView) view.findViewById(2131826157);
                this.jXf = (LinearLayout) view.findViewById(2131826158);
                this.jXg = (LinearLayout) view.findViewById(2131826159);
                this.jXh = (LinearLayout) view.findViewById(2131826160);
                this.jXi = (LinearLayout) view.findViewById(2131826161);
                LinearLayout linearLayout = this.jXg;
                C25052j.m39375o(linearLayout, "fansLayout");
                this.jXj = new C2739a(c2736a, linearLayout);
                linearLayout = this.jXh;
                C25052j.m39375o(linearLayout, "authorLayout");
                this.jXk = new C2739a(c2736a, linearLayout);
                AppMethodBeat.m2505o(15228);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView$a$d */
        static final class C2738d implements OnClickListener {
            final /* synthetic */ C2736a jXe;
            final /* synthetic */ C44173tp jXl;
            final /* synthetic */ C44136kl jXm;
            final /* synthetic */ C2739a jXn;

            C2738d(C2736a c2736a, C44173tp c44173tp, C44136kl c44136kl, C2739a c2739a) {
                this.jXe = c2736a;
                this.jXl = c44173tp;
                this.jXm = c44136kl;
                this.jXn = c2739a;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(15229);
                C15335el c15335el = new C15335el();
                C44173tp c44173tp;
                if (this.jXl.waK == 0) {
                    c15335el.vGt = 1;
                    this.jXl.waK = 1;
                    c44173tp = this.jXl;
                    c44173tp.waJ++;
                } else {
                    c15335el.vGt = 0;
                    this.jXl.waK = 0;
                    c44173tp = this.jXl;
                    c44173tp.waJ--;
                }
                this.jXl.waJ = Math.max(0, this.jXl.waJ);
                c15335el.kdC = 2;
                C44136kl c44136kl = this.jXm;
                if (c44136kl == null) {
                    C25052j.dWJ();
                }
                c15335el.vGs = c44136kl.vGs;
                c44136kl = this.jXm;
                if (c44136kl == null) {
                    C25052j.dWJ();
                }
                c15335el.vGr = c44136kl.vGr;
                c15335el.vGu = this.jXl.vGu;
                this.jXe.jWx.mo73554a(c15335el);
                C2736a.m4979a(this.jXe, this.jXl, this.jXn);
                AppMethodBeat.m2505o(15229);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00130\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010\u001b\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010\u001e\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;Landroid/view/View;)V", "authorPrefixIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAuthorPrefixIv", "()Landroid/widget/ImageView;", "setAuthorPrefixIv", "(Landroid/widget/ImageView;)V", "deleteTv", "Landroid/widget/TextView;", "getDeleteTv", "()Landroid/widget/TextView;", "setDeleteTv", "(Landroid/widget/TextView;)V", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeTv", "getLikeTv", "setLikeTv", "nickName", "getNickName", "setNickName", "plactTopTv", "getPlactTopTv", "setPlactTopTv", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView$a$a */
        public final class C2739a {
            TextView jWY;
            TextView jWZ;
            NeatTextView jXa;
            TextView jXb;
            TextView jXc;
            ImageView jXd;
            final /* synthetic */ C2736a jXe;

            public C2739a(C2736a c2736a, View view) {
                C25052j.m39376p(view, "itemView");
                this.jXe = c2736a;
                AppMethodBeat.m2504i(15227);
                this.jWY = (TextView) view.findViewById(2131826152);
                this.jWZ = (TextView) view.findViewById(2131826154);
                this.jXa = (NeatTextView) view.findViewById(2131826155);
                this.jXb = (TextView) view.findViewById(2131826156);
                this.jXc = (TextView) view.findViewById(2131826153);
                this.jXd = (ImageView) view.findViewById(2131826151);
                AppMethodBeat.m2505o(15227);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$Companion;", "", "()V", "TAG", "", "option", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getOption", "()Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "setOption", "(Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;)V", "viewTypeNormal", "", "getViewTypeNormal", "()I", "plugin-brandservice_release"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView$a$c */
        public static final class C2740c {
            private C2740c() {
            }

            public /* synthetic */ C2740c(byte b) {
                this();
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView$a$e */
        static final class C2741e implements OnClickListener {
            final /* synthetic */ C2736a jXe;
            final /* synthetic */ C44136kl jXm;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
            /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView$a$e$a */
            static final class C2742a implements DialogInterface.OnClickListener {
                final /* synthetic */ C2741e jXo;

                C2742a(C2741e c2741e) {
                    this.jXo = c2741e;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(15230);
                    C46537ep c46537ep = new C46537ep();
                    c46537ep.vGr = this.jXo.jXm.vGr;
                    c46537ep.kdC = 2;
                    this.jXo.jXe.jWx.mo73555a(c46537ep);
                    AppMethodBeat.m2505o(15230);
                }
            }

            C2741e(C2736a c2736a, C44136kl c44136kl) {
                this.jXe = c2736a;
                this.jXm = c44136kl;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(15231);
                new C5652a(this.jXe.context).asD(this.jXe.context.getString(C25738R.string.g5p)).asE("").mo11455Qe(this.jXe.context.getResources().getColor(C25738R.color.f11672cu)).mo11453Qc(C25738R.string.f9187s6).mo11457a((DialogInterface.OnClickListener) new C2742a(this)).mo11454Qd(C25738R.string.abn).aMb().show();
                AppMethodBeat.m2505o(15231);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoCommentView$a$f */
        static final class C2743f implements OnClickListener {
            final /* synthetic */ C2736a jXe;
            final /* synthetic */ C44136kl jXm;
            final /* synthetic */ C2739a jXn;

            C2743f(C2736a c2736a, C44136kl c44136kl, C2739a c2739a) {
                this.jXe = c2736a;
                this.jXm = c44136kl;
                this.jXn = c2739a;
            }

            public final void onClick(View view) {
                C44136kl c44136kl;
                AppMethodBeat.m2504i(15232);
                C15335el c15335el = new C15335el();
                if (this.jXm.vMP == 0) {
                    c15335el.vGt = 1;
                    this.jXm.vMP = 1;
                    c44136kl = this.jXm;
                    c44136kl.vMO++;
                } else {
                    c15335el.vGt = 0;
                    this.jXm.vMP = 0;
                    c44136kl = this.jXm;
                    c44136kl.vMO--;
                }
                this.jXm.vMO = Math.max(0, this.jXm.vMO);
                c15335el.kdC = 1;
                c44136kl = this.jXm;
                if (c44136kl == null) {
                    C25052j.dWJ();
                }
                c15335el.vGs = c44136kl.vGs;
                c44136kl = this.jXm;
                if (c44136kl == null) {
                    C25052j.dWJ();
                }
                c15335el.vGr = c44136kl.vGr;
                this.jXe.jWx.mo73554a(c15335el);
                C2736a.m4978a(this.jXe, this.jXm, this.jXn);
                AppMethodBeat.m2505o(15232);
            }
        }

        public C2736a(Context context, LinkedList<C44136kl> linkedList, C45767b c45767b) {
            C25052j.m39376p(context, "context");
            C25052j.m39376p(linkedList, "list");
            C25052j.m39376p(c45767b, "controller");
            AppMethodBeat.m2504i(15240);
            this.context = context;
            this.eow = linkedList;
            this.jWx = c45767b;
            AppMethodBeat.m2505o(15240);
        }

        static {
            AppMethodBeat.m2504i(15241);
            AppMethodBeat.m2505o(15241);
        }

        /* renamed from: a */
        public final void mo6805a(C46537ep c46537ep, String str) {
            AppMethodBeat.m2504i(15233);
            C25052j.m39376p(c46537ep, "req");
            Iterator it = this.eow.iterator();
            while (it.hasNext()) {
                C44136kl c44136kl = (C44136kl) it.next();
                if (c46537ep.vGr == c44136kl.vGr && (C5046bo.isNullOrNil(str) || C5046bo.isEqual(str, c44136kl.vGs))) {
                    this.eow.remove(c44136kl);
                    notifyDataSetChanged();
                    AppMethodBeat.m2505o(15233);
                    return;
                }
            }
            AppMethodBeat.m2505o(15233);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(15234);
            int size = this.eow.size();
            AppMethodBeat.m2505o(15234);
            return size;
        }

        public final int getItemViewType(int i) {
            return jWV;
        }

        /* renamed from: a */
        private final void m4980a(C44136kl c44136kl, C2739a c2739a) {
            boolean z = true;
            AppMethodBeat.m2504i(15237);
            if (c44136kl == null) {
                AppMethodBeat.m2505o(15237);
                return;
            }
            TextView textView = c2739a.jWZ;
            C25052j.m39375o(textView, "itemView.likeTv");
            if (c44136kl.vMP != 1) {
                z = false;
            }
            m4977a(textView, z, c44136kl.vMO);
            AppMethodBeat.m2505o(15237);
        }

        /* renamed from: a */
        private final void m4977a(TextView textView, boolean z, int i) {
            AppMethodBeat.m2504i(15239);
            String str = " " + C11263c.m18979G(this.context, i);
            Drawable drawable = this.context.getResources().getDrawable(z ? C25738R.drawable.axr : C25738R.drawable.axq);
            int textSize = (int) textView.getTextSize();
            drawable.setBounds(0, 0, textSize, textSize);
            new SpannableString("@").setSpan(new C5664a(drawable), 0, 1, 33);
            textView.setText(TextUtils.concat(new CharSequence[]{r1, str}));
            AppMethodBeat.m2505o(15239);
        }

        /* renamed from: a */
        private final void m4981a(C44173tp c44173tp, C2739a c2739a) {
            boolean z = true;
            AppMethodBeat.m2504i(15238);
            TextView textView = c2739a.jWZ;
            C25052j.m39375o(textView, "itemView.likeTv");
            if (c44173tp.waK != 1) {
                z = false;
            }
            m4977a(textView, z, c44173tp.waJ);
            AppMethodBeat.m2505o(15238);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ MPVideoWriteCommentLayout m65663a(MPVideoCommentView mPVideoCommentView) {
        AppMethodBeat.m2504i(15246);
        MPVideoWriteCommentLayout mPVideoWriteCommentLayout = mPVideoCommentView.jWN;
        if (mPVideoWriteCommentLayout == null) {
            C25052j.avw("writeCommentLayout");
        }
        AppMethodBeat.m2505o(15246);
        return mPVideoWriteCommentLayout;
    }

    public MPVideoCommentView(final Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.m2504i(15245);
        View.inflate(context, 2130970253, this);
        View findViewById = findViewById(2131826172);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_write_comment_tv)");
        this.jWK = (TextView) findViewById;
        findViewById = findViewById(2131826171);
        C25052j.m39375o(findViewById, "findViewById(R.id.biz_video_selected_comment_tv)");
        this.jWL = (TextView) findViewById;
        this.jWK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MPVideoCommentView jWR;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(15226);
                if (this.jWR.jWQ == 1) {
                    C30379h.m48443a(context, context.getString(C25738R.string.g85), "", context.getString(C25738R.string.f9187s6), null);
                    AppMethodBeat.m2505o(15226);
                    return;
                }
                if (MPVideoCommentView.m65663a(this.jWR) != null) {
                    MPVideoCommentView.m65663a(this.jWR).mo35342fA(false);
                }
                AppMethodBeat.m2505o(15226);
            }
        });
        AppMethodBeat.m2505o(15245);
    }

    public final void setTmpUrl(int i) {
        this.jWQ = i;
    }

    public final void setWriteCommentLayout(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.m2504i(15244);
        C25052j.m39376p(mPVideoWriteCommentLayout, "layout");
        this.jWN = mPVideoWriteCommentLayout;
        AppMethodBeat.m2505o(15244);
    }
}
