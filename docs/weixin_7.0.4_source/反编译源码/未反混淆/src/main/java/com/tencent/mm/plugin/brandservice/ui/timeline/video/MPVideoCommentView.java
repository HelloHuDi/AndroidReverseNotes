package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.protocal.protobuf.ep;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.Iterator;
import java.util.LinkedList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u001e\u0010 \u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u001cH\u0002J\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0019J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001cR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;", "enable", "", "isFans", "isTmpUrl", "()I", "setTmpUrl", "(I)V", "onlyFansCanComment", "", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "selectedCommentTv", "Landroid/widget/TextView;", "writeCommentLayout", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoWriteCommentLayout;", "writeTv", "onDeleteComment", "", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "openId", "setListView", "header", "Landroid/view/View;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "setWriteComment", "setWriteCommentLayout", "layout", "updateData", "resp", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentListResp;", "updateViewStatus", "BizCommentItemAdapter", "plugin-brandservice_release"})
public final class MPVideoCommentView extends RelativeLayout {
    private final String TAG = "MicroMsg.MPVideoView_back";
    int erD = 1;
    MRecyclerView jWJ;
    TextView jWK;
    TextView jWL;
    a jWM;
    private MPVideoWriteCommentLayout jWN;
    int jWO = 1;
    boolean jWP;
    int jWQ;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003<=>B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u001c\u0010$\u001a\u00020!2\n\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001c\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001dH\u0016J\u0018\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0012J \u0010.\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u001dH\u0002J\u0014\u00102\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000704J$\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u00192\n\u00107\u001a\u000608R\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007J&\u00109\u001a\u00020!2\u0006\u00106\u001a\u00020\u00192\n\u00107\u001a\u000608R\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010:\u001a\u00020!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\u00107\u001a\u000608R\u00020\u0000J\u001e\u0010;\u001a\u00020!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\u00107\u001a\u000608R\u00020\u0000H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentViewHolder;", "context", "Landroid/content/Context;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "(Landroid/content/Context;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;)V", "getController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "setController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;)V", "deleteStr", "", "fromFriend", "", "kotlin.jvm.PlatformType", "getFromFriend", "()Ljava/lang/String;", "setFromFriend", "(Ljava/lang/String;)V", "getCommentReply", "Lcom/tencent/mm/protocal/protobuf/CommentReply;", "info", "getItem", "position", "", "getItemCount", "getItemViewType", "initDeleteText", "", "textView", "Landroid/widget/TextView;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDeleteComment", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "openId", "setGood", "isGood", "", "num", "update", "items", "", "updateAuthorCommentContentView", "reply", "itemView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;", "updateAuthorLikeStatus", "updateCommentContentView", "updateCommentLikeStatus", "BizCommentContent", "BizCommentViewHolder", "Companion", "plugin-brandservice_release"})
    public static final class a extends android.support.v7.widget.RecyclerView.a<b> {
        static final String TAG = TAG;
        private static final int jWV = 1;
        private static com.tencent.mm.at.a.a.c jWW = new com.tencent.mm.at.a.a.c.a().ahE().ahD().ct(120, 120).a((com.tencent.mm.at.a.c.b) new com.tencent.mm.pluginsdk.ui.applet.f()).sD(com.tencent.mm.plugin.i.c.bGF()).ahG();
        public static final c jWX = new c();
        private final Context context;
        final LinkedList<kl> eow;
        private String jWT = this.context.getString(R.string.g82);
        private CharSequence jWU;
        b jWx;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'R\u001e\u0010\u0005\u001a\u00060\u0006R\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\u00140\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n \u000e*\u0004\u0018\u00010\r0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\"\u0010\u0019\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001e\u0010\u001c\u001a\u00060\u0006R\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\"\u0010\u001f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;Landroid/view/View;)V", "authorContent", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;", "getAuthorContent", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;", "setAuthorContent", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;)V", "authorLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getAuthorLayout", "()Landroid/widget/LinearLayout;", "setAuthorLayout", "(Landroid/widget/LinearLayout;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "content", "getContent", "endlineLayout", "getEndlineLayout", "setEndlineLayout", "fansContent", "getFansContent", "setFansContent", "fansLayout", "getFansLayout", "setFansLayout", "update", "", "position", "", "info", "Lcom/tencent/mm/protocal/protobuf/BizComment;", "plugin-brandservice_release"})
        public final class b extends v {
            final ImageView gvq;
            final /* synthetic */ a jXe;
            private final LinearLayout jXf;
            private LinearLayout jXg;
            LinearLayout jXh;
            LinearLayout jXi;
            a jXj;
            a jXk;

            public b(a aVar, View view) {
                j.p(view, "itemView");
                this.jXe = aVar;
                super(view);
                AppMethodBeat.i(15228);
                this.gvq = (ImageView) view.findViewById(R.id.dcq);
                this.jXf = (LinearLayout) view.findViewById(R.id.dcr);
                this.jXg = (LinearLayout) view.findViewById(R.id.dcs);
                this.jXh = (LinearLayout) view.findViewById(R.id.dct);
                this.jXi = (LinearLayout) view.findViewById(R.id.dcu);
                LinearLayout linearLayout = this.jXg;
                j.o(linearLayout, "fansLayout");
                this.jXj = new a(aVar, linearLayout);
                linearLayout = this.jXh;
                j.o(linearLayout, "authorLayout");
                this.jXk = new a(aVar, linearLayout);
                AppMethodBeat.o(15228);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class d implements OnClickListener {
            final /* synthetic */ a jXe;
            final /* synthetic */ tp jXl;
            final /* synthetic */ kl jXm;
            final /* synthetic */ a jXn;

            d(a aVar, tp tpVar, kl klVar, a aVar2) {
                this.jXe = aVar;
                this.jXl = tpVar;
                this.jXm = klVar;
                this.jXn = aVar2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(15229);
                el elVar = new el();
                tp tpVar;
                if (this.jXl.waK == 0) {
                    elVar.vGt = 1;
                    this.jXl.waK = 1;
                    tpVar = this.jXl;
                    tpVar.waJ++;
                } else {
                    elVar.vGt = 0;
                    this.jXl.waK = 0;
                    tpVar = this.jXl;
                    tpVar.waJ--;
                }
                this.jXl.waJ = Math.max(0, this.jXl.waJ);
                elVar.kdC = 2;
                kl klVar = this.jXm;
                if (klVar == null) {
                    j.dWJ();
                }
                elVar.vGs = klVar.vGs;
                klVar = this.jXm;
                if (klVar == null) {
                    j.dWJ();
                }
                elVar.vGr = klVar.vGr;
                elVar.vGu = this.jXl.vGu;
                this.jXe.jWx.a(elVar);
                a.a(this.jXe, this.jXl, this.jXn);
                AppMethodBeat.o(15229);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00130\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010\u001b\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010\u001e\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011¨\u0006!"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$BizCommentContent;", "", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter;Landroid/view/View;)V", "authorPrefixIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAuthorPrefixIv", "()Landroid/widget/ImageView;", "setAuthorPrefixIv", "(Landroid/widget/ImageView;)V", "deleteTv", "Landroid/widget/TextView;", "getDeleteTv", "()Landroid/widget/TextView;", "setDeleteTv", "(Landroid/widget/TextView;)V", "desc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "getDesc", "()Lcom/tencent/neattextview/textview/view/NeatTextView;", "setDesc", "(Lcom/tencent/neattextview/textview/view/NeatTextView;)V", "likeTv", "getLikeTv", "setLikeTv", "nickName", "getNickName", "setNickName", "plactTopTv", "getPlactTopTv", "setPlactTopTv", "plugin-brandservice_release"})
        public final class a {
            TextView jWY;
            TextView jWZ;
            NeatTextView jXa;
            TextView jXb;
            TextView jXc;
            ImageView jXd;
            final /* synthetic */ a jXe;

            public a(a aVar, View view) {
                j.p(view, "itemView");
                this.jXe = aVar;
                AppMethodBeat.i(15227);
                this.jWY = (TextView) view.findViewById(R.id.dcl);
                this.jWZ = (TextView) view.findViewById(R.id.dcn);
                this.jXa = (NeatTextView) view.findViewById(R.id.dco);
                this.jXb = (TextView) view.findViewById(R.id.dcp);
                this.jXc = (TextView) view.findViewById(R.id.dcm);
                this.jXd = (ImageView) view.findViewById(R.id.dck);
                AppMethodBeat.o(15227);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/MPVideoCommentView$BizCommentItemAdapter$Companion;", "", "()V", "TAG", "", "option", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getOption", "()Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "setOption", "(Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;)V", "viewTypeNormal", "", "getViewTypeNormal", "()I", "plugin-brandservice_release"})
        public static final class c {
            private c() {
            }

            public /* synthetic */ c(byte b) {
                this();
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class e implements OnClickListener {
            final /* synthetic */ a jXe;
            final /* synthetic */ kl jXm;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
            static final class a implements DialogInterface.OnClickListener {
                final /* synthetic */ e jXo;

                a(e eVar) {
                    this.jXo = eVar;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(15230);
                    ep epVar = new ep();
                    epVar.vGr = this.jXo.jXm.vGr;
                    epVar.kdC = 2;
                    this.jXo.jXe.jWx.a(epVar);
                    AppMethodBeat.o(15230);
                }
            }

            e(a aVar, kl klVar) {
                this.jXe = aVar;
                this.jXm = klVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(15231);
                new com.tencent.mm.ui.widget.a.c.a(this.jXe.context).asD(this.jXe.context.getString(R.string.g5p)).asE("").Qe(this.jXe.context.getResources().getColor(R.color.cu)).Qc(R.string.s6).a((DialogInterface.OnClickListener) new a(this)).Qd(R.string.abn).aMb().show();
                AppMethodBeat.o(15231);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class f implements OnClickListener {
            final /* synthetic */ a jXe;
            final /* synthetic */ kl jXm;
            final /* synthetic */ a jXn;

            f(a aVar, kl klVar, a aVar2) {
                this.jXe = aVar;
                this.jXm = klVar;
                this.jXn = aVar2;
            }

            public final void onClick(View view) {
                kl klVar;
                AppMethodBeat.i(15232);
                el elVar = new el();
                if (this.jXm.vMP == 0) {
                    elVar.vGt = 1;
                    this.jXm.vMP = 1;
                    klVar = this.jXm;
                    klVar.vMO++;
                } else {
                    elVar.vGt = 0;
                    this.jXm.vMP = 0;
                    klVar = this.jXm;
                    klVar.vMO--;
                }
                this.jXm.vMO = Math.max(0, this.jXm.vMO);
                elVar.kdC = 1;
                klVar = this.jXm;
                if (klVar == null) {
                    j.dWJ();
                }
                elVar.vGs = klVar.vGs;
                klVar = this.jXm;
                if (klVar == null) {
                    j.dWJ();
                }
                elVar.vGr = klVar.vGr;
                this.jXe.jWx.a(elVar);
                a.a(this.jXe, this.jXm, this.jXn);
                AppMethodBeat.o(15232);
            }
        }

        public a(Context context, LinkedList<kl> linkedList, b bVar) {
            j.p(context, "context");
            j.p(linkedList, "list");
            j.p(bVar, "controller");
            AppMethodBeat.i(15240);
            this.context = context;
            this.eow = linkedList;
            this.jWx = bVar;
            AppMethodBeat.o(15240);
        }

        static {
            AppMethodBeat.i(15241);
            AppMethodBeat.o(15241);
        }

        public final void a(ep epVar, String str) {
            AppMethodBeat.i(15233);
            j.p(epVar, "req");
            Iterator it = this.eow.iterator();
            while (it.hasNext()) {
                kl klVar = (kl) it.next();
                if (epVar.vGr == klVar.vGr && (bo.isNullOrNil(str) || bo.isEqual(str, klVar.vGs))) {
                    this.eow.remove(klVar);
                    notifyDataSetChanged();
                    AppMethodBeat.o(15233);
                    return;
                }
            }
            AppMethodBeat.o(15233);
        }

        public final int getItemCount() {
            AppMethodBeat.i(15234);
            int size = this.eow.size();
            AppMethodBeat.o(15234);
            return size;
        }

        public final int getItemViewType(int i) {
            return jWV;
        }

        private final void a(kl klVar, a aVar) {
            boolean z = true;
            AppMethodBeat.i(15237);
            if (klVar == null) {
                AppMethodBeat.o(15237);
                return;
            }
            TextView textView = aVar.jWZ;
            j.o(textView, "itemView.likeTv");
            if (klVar.vMP != 1) {
                z = false;
            }
            a(textView, z, klVar.vMO);
            AppMethodBeat.o(15237);
        }

        private final void a(TextView textView, boolean z, int i) {
            AppMethodBeat.i(15239);
            String str = " " + com.tencent.mm.plugin.brandservice.ui.timeline.video.a.c.G(this.context, i);
            Drawable drawable = this.context.getResources().getDrawable(z ? R.drawable.axr : R.drawable.axq);
            int textSize = (int) textView.getTextSize();
            drawable.setBounds(0, 0, textSize, textSize);
            new SpannableString("@").setSpan(new com.tencent.mm.ui.widget.a(drawable), 0, 1, 33);
            textView.setText(TextUtils.concat(new CharSequence[]{r1, str}));
            AppMethodBeat.o(15239);
        }

        private final void a(tp tpVar, a aVar) {
            boolean z = true;
            AppMethodBeat.i(15238);
            TextView textView = aVar.jWZ;
            j.o(textView, "itemView.likeTv");
            if (tpVar.waK != 1) {
                z = false;
            }
            a(textView, z, tpVar.waJ);
            AppMethodBeat.o(15238);
        }
    }

    public static final /* synthetic */ MPVideoWriteCommentLayout a(MPVideoCommentView mPVideoCommentView) {
        AppMethodBeat.i(15246);
        MPVideoWriteCommentLayout mPVideoWriteCommentLayout = mPVideoCommentView.jWN;
        if (mPVideoWriteCommentLayout == null) {
            j.avw("writeCommentLayout");
        }
        AppMethodBeat.o(15246);
        return mPVideoWriteCommentLayout;
    }

    public MPVideoCommentView(final Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        super(context, attributeSet);
        AppMethodBeat.i(15245);
        View.inflate(context, R.layout.ahi, this);
        View findViewById = findViewById(R.id.dd5);
        j.o(findViewById, "findViewById(R.id.biz_video_write_comment_tv)");
        this.jWK = (TextView) findViewById;
        findViewById = findViewById(R.id.dd4);
        j.o(findViewById, "findViewById(R.id.biz_video_selected_comment_tv)");
        this.jWL = (TextView) findViewById;
        this.jWK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MPVideoCommentView jWR;

            public final void onClick(View view) {
                AppMethodBeat.i(15226);
                if (this.jWR.jWQ == 1) {
                    h.a(context, context.getString(R.string.g85), "", context.getString(R.string.s6), null);
                    AppMethodBeat.o(15226);
                    return;
                }
                if (MPVideoCommentView.a(this.jWR) != null) {
                    MPVideoCommentView.a(this.jWR).fA(false);
                }
                AppMethodBeat.o(15226);
            }
        });
        AppMethodBeat.o(15245);
    }

    public final void setTmpUrl(int i) {
        this.jWQ = i;
    }

    public final void setWriteCommentLayout(MPVideoWriteCommentLayout mPVideoWriteCommentLayout) {
        AppMethodBeat.i(15244);
        j.p(mPVideoWriteCommentLayout, "layout");
        this.jWN = mPVideoWriteCommentLayout;
        AppMethodBeat.o(15244);
    }
}
