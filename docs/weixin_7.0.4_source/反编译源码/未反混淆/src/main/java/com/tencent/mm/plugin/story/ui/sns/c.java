package com.tencent.mm.plugin.story.ui.sns;

import a.a.k;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.g.b.a.ap;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.plugin.story.ui.view.gallery.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

@l(dWo = {1, 1, 13}, dWp = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0003'()B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00150\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R2\u0010\u001e\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010 0  !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010 0 \u0018\u00010\"0\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "finish", "", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class c extends LinearLayout implements a {
    public static final a shK = new a();
    private c shB;
    private int shC = -1;
    private int shD = -1;
    private int shE = -1;
    private View shF;
    private TextView shG;
    private boolean shH;
    private ao shI = new ao();
    private LinkedHashMap<String, ArrayList<Long>> shJ = new LinkedHashMap();
    private RecyclerView shq;
    private List<b> sht = Collections.synchronizedList(new LinkedList());

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$1 */
    static final class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ c shL;

        AnonymousClass1(c cVar) {
            this.shL = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110266);
            this.shL.shH = !this.shL.shH;
            if (this.shL.shH) {
                c.b(this.shL);
                AppMethodBeat.o(110266);
                return;
            }
            c.c(this.shL);
            AppMethodBeat.o(110266);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class b {
        final int type;
        final String userName;

        public b(String str, int i) {
            j.p(str, "userName");
            AppMethodBeat.i(110268);
            this.userName = str;
            this.type = i;
            AppMethodBeat.o(110268);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0003 !\"B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0017\u001a\u00020\r2\u000e\u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0019\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0014\u0010\u001d\u001a\u00020\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fRL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extInfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
    public final class c extends android.support.v7.widget.RecyclerView.a<a> {
        m<? super Integer, ? super b, y> seN;
        final ArrayList<b> shw = new ArrayList();

        @l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "reply", "getReply", "setReply", "(Landroid/widget/TextView;)V", "star", "getStar", "()Landroid/view/View;", "setStar", "(Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
        public final class c extends a {
            private final TextView gKl;
            private final ImageView gvq;
            final /* synthetic */ c shN;
            private View shQ;
            private TextView shR;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$c$c$1 */
            static final class AnonymousClass1 implements OnClickListener {
                final /* synthetic */ c shS;

                AnonymousClass1(c cVar) {
                    this.shS = cVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(110272);
                    int kj = this.shS.kj();
                    Object obj = this.shS.shN.shw.get(kj);
                    j.o(obj, "userList[position]");
                    b bVar = (b) obj;
                    m mVar = this.shS.shN.seN;
                    if (mVar != null) {
                        mVar.m(Integer.valueOf(kj), bVar);
                        AppMethodBeat.o(110272);
                        return;
                    }
                    AppMethodBeat.o(110272);
                }
            }

            public c(c cVar, View view) {
                j.p(view, "itemView");
                this.shN = cVar;
                super(cVar, view);
                AppMethodBeat.i(110274);
                View findViewById = view.findViewById(R.id.qk);
                j.o(findViewById, "itemView.findViewById(R.id.avatar_iv)");
                this.gvq = (ImageView) findViewById;
                findViewById = view.findViewById(R.id.dcf);
                j.o(findViewById, "itemView.findViewById(R.id.user_name_tv)");
                this.gKl = (TextView) findViewById;
                findViewById = view.findViewById(R.id.ete);
                j.o(findViewById, "itemView.findViewById(R.id.star)");
                this.shQ = findViewById;
                findViewById = view.findViewById(R.id.etd);
                j.o(findViewById, "itemView.findViewById(R.id.reply_icon)");
                this.shR = (TextView) findViewById;
                view.setOnClickListener(new AnonymousClass1(this));
                AppMethodBeat.o(110274);
            }

            /* JADX WARNING: Missing block: B:3:0x0032, code skipped:
            if (r0 == null) goto L_0x0034;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(b bVar) {
                String Oj;
                int i = 0;
                AppMethodBeat.i(110273);
                j.p(bVar, "data");
                com.tencent.mm.pluginsdk.ui.a.b.r(this.gvq, bVar.userName);
                com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(bVar.userName);
                if (aoO != null) {
                    Oj = aoO.Oj();
                }
                Oj = bVar.userName;
                SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b(this.gKl.getContext(), (CharSequence) Oj, this.gKl.getTextSize());
                View view = this.shQ;
                j.o(aoO, "contact");
                view.setVisibility(aoO.Oc() ? 0 : 4);
                this.gKl.setText(b);
                TextView textView = this.shR;
                if (bVar.type == 5) {
                    this.shR.setText(String.valueOf(com.tencent.mm.plugin.story.model.f.a.rWL.aaH(bVar.userName)));
                } else {
                    i = 8;
                }
                textView.setVisibility(i);
                AppMethodBeat.o(110273);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "tipId", "", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;I)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "getTipId", "()I", "setTipId", "(I)V", "onBind", "", "position", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
        public final class b extends a {
            private final TextView gKl;
            final /* synthetic */ c shN;
            private int shO;

            public b(c cVar, View view, int i) {
                j.p(view, "itemView");
                this.shN = cVar;
                super(cVar, view);
                AppMethodBeat.i(110271);
                this.shO = i;
                View findViewById = view.findViewById(R.id.n0);
                j.o(findViewById, "itemView.findViewById(R.id.tip_tv)");
                this.gKl = (TextView) findViewById;
                view.setOnClickListener(AnonymousClass1.shP);
                AppMethodBeat.o(110271);
            }

            public final void a(b bVar) {
                AppMethodBeat.i(110270);
                j.p(bVar, "data");
                this.gKl.setText(this.shO);
                AppMethodBeat.o(110270);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
        public abstract class a extends v {
            final /* synthetic */ c shN;

            public abstract void a(b bVar);

            public a(c cVar, View view) {
                j.p(view, "itemView");
                this.shN = cVar;
                super(view);
            }
        }

        public c() {
            AppMethodBeat.i(110279);
            AppMethodBeat.o(110279);
        }

        public final int getItemCount() {
            AppMethodBeat.i(110275);
            int size = this.shw.size();
            AppMethodBeat.o(110275);
            return size;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(110277);
            int i2 = ((b) this.shw.get(i)).type;
            AppMethodBeat.o(110277);
            return i2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$Companion;", "", "()V", "AGO_TYPE_TIP", "", "NEW_TYPE_TIP", "REPLY_TYPE_TIP", "TAG", "", "TYPE_REPLY_USERNAME", "TYPE_USERNAME", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(110282);
        AppMethodBeat.o(110282);
    }

    public c(final Context context, final OnClickListener onClickListener) {
        boolean z;
        y yVar;
        h hVar;
        j.p(context, "context");
        super(context);
        AppMethodBeat.i(110281);
        View inflate = LayoutInflater.from(context).inflate(R.layout.ayj, this, true);
        inflate.findViewById(R.id.etf).setOnClickListener(onClickListener);
        View findViewById = inflate.findViewById(R.id.eth);
        j.o(findViewById, "parent.findViewById<View>(R.id.no_data)");
        this.shF = findViewById;
        findViewById = inflate.findViewById(R.id.etg);
        j.o(findViewById, "parent.findViewById<TextView>(R.id.clear_txt)");
        this.shG = (TextView) findViewById;
        this.shG.setOnClickListener(new AnonymousClass1(this));
        findViewById = inflate.findViewById(R.id.eti);
        j.o(findViewById, "parent.findViewById(R.id.story_entrance_recycler)");
        this.shq = (RecyclerView) findViewById;
        this.shq.setLayoutManager(new LinearLayoutManager());
        this.shB = new c();
        this.shq.setItemViewCacheSize(0);
        this.shq.setAdapter(this.shB);
        this.shB.seN = new m<Integer, b, y>(this) {
            final /* synthetic */ c shL;

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                int i;
                b bVar;
                y yVar;
                AppMethodBeat.i(110267);
                int intValue = ((Number) obj).intValue();
                b bVar2 = (b) obj2;
                j.p(bVar2, "item");
                LinkedList linkedList = new LinkedList();
                HashMap hashMap = new HashMap();
                int i2;
                h hVar;
                if (bVar2.type == 5) {
                    for (Entry entry : this.shL.shJ.entrySet()) {
                        String str = (String) entry.getKey();
                        ArrayList<Number> arrayList = (ArrayList) entry.getValue();
                        ArrayList arrayList2 = new ArrayList();
                        for (Number longValue : arrayList) {
                            arrayList2.add(Long.valueOf(longValue.longValue()));
                        }
                        hashMap.put(str, arrayList2);
                    }
                    if (this.shL.shE != -1) {
                        i2 = intValue - 1;
                    } else {
                        i2 = intValue;
                    }
                    hVar = h.scu;
                    h.cAs().oh(1);
                    i = i2;
                } else if (bVar2.type == 1) {
                    ar cAs;
                    StringBuilder stringBuilder;
                    h hVar2;
                    if (intValue <= this.shL.shE || this.shL.shE == -1) {
                        i2 = intValue;
                    } else {
                        i2 = intValue - this.shL.shE;
                    }
                    if (intValue >= this.shL.shC && this.shL.shC != -1) {
                        i2--;
                        hVar = h.scu;
                        h.cAs().bG(12);
                        hVar = h.scu;
                        cAs = h.cAs();
                        stringBuilder = new StringBuilder("12_");
                        hVar2 = h.scu;
                        cAs.fC(stringBuilder.append(h.cAL()).toString());
                    }
                    if (intValue >= this.shL.shD && this.shL.shD != -1) {
                        i2--;
                        hVar = h.scu;
                        h.cAs().bG(13);
                        hVar = h.scu;
                        cAs = h.cAs();
                        stringBuilder = new StringBuilder("13_");
                        hVar2 = h.scu;
                        cAs.fC(stringBuilder.append(h.cAL()).toString());
                    }
                    i = i2;
                } else {
                    i = intValue;
                }
                List h = this.shL.sht;
                j.o(h, "userNameList");
                Iterable<b> iterable = h;
                synchronized (iterable) {
                    try {
                        for (b bVar3 : iterable) {
                            if ((bVar3.type == bVar2.type ? 1 : null) == null) {
                                bVar3 = null;
                            }
                            if (bVar3 != null) {
                                linkedList.add(bVar3.userName);
                            }
                        }
                        yVar = y.AUy;
                    } catch (Throwable th) {
                        AppMethodBeat.o(110267);
                    }
                }
                com.tencent.mm.plugin.report.service.h.pYm.k(1015, 6, 1);
                h = this.shL.sht;
                j.o(h, "userNameList");
                Iterable iterable2 = h;
                synchronized (iterable2) {
                    try {
                        int i3 = 0;
                        for (Object next : iterable2) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                a.a.l.dWs();
                            }
                            bVar3 = (b) next;
                            Object obj3 = (bVar3.type != bVar2.type || i3 >= intValue) ? null : 1;
                            if (obj3 == null) {
                                bVar3 = null;
                            }
                            if (bVar3 != null) {
                                linkedList.add(bVar3.userName);
                                i3 = i4;
                            } else {
                                i3 = i4;
                            }
                        }
                        yVar = y.AUy;
                    } catch (Throwable th2) {
                        AppMethodBeat.o(110267);
                    }
                }
                h hVar3 = h.scu;
                h.cAs().fA((String) linkedList.get(i));
                long c = o.rQN.c(linkedList, hashMap);
                Intent intent = new Intent(context, StoryBrowseUI.class);
                intent.putExtra("v_position", i);
                intent.putExtra("data_seed_key", c);
                intent.putExtra("gallery_session_id", "");
                intent.putExtra("gallery_is_for_sns", true);
                context.startActivity(intent);
                OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(this.shL);
                }
                y yVar2 = y.AUy;
                AppMethodBeat.o(110267);
                return yVar2;
            }
        };
        List cwY = com.tencent.mm.plugin.story.model.f.a.rWL.cwY();
        List cwZ = com.tencent.mm.plugin.story.model.f.a.rWL.cwZ();
        this.shJ = com.tencent.mm.plugin.story.model.f.a.rWL.cxa();
        if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_preload_with_enter_pop_sns, 1) == 1) {
            com.tencent.mm.plugin.story.f.h.a aVar;
            com.tencent.mm.plugin.story.model.d.g bt;
            n nVar;
            if (!((Collection) cwY).isEmpty()) {
                aVar = com.tencent.mm.plugin.story.f.h.rZx;
                bt = com.tencent.mm.plugin.story.f.h.a.bt((String) cwY.get(0), false);
                if (bt != null) {
                    nVar = n.sqi;
                    n.q(k.listOf(bt.rVZ), 5);
                }
            } else {
                if (cwZ.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    aVar = com.tencent.mm.plugin.story.f.h.rZx;
                    bt = com.tencent.mm.plugin.story.f.h.a.bt((String) cwZ.get(0), false);
                    if (bt != null) {
                        nVar = n.sqi;
                        n.q(k.listOf(bt.rVZ), 5);
                    }
                }
            }
        }
        ab.i("MicroMsg.StoryEntranceView", "userNames " + cwY.size() + " lastUserNames " + cwZ.size());
        if (this.shJ.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.sht.add(new b("", 4));
            this.shE = this.shJ.size() + 1;
        }
        Set entrySet = this.shJ.entrySet();
        j.o(entrySet, "replyToIndexMap.entries");
        a.v<Entry> vVar = entrySet;
        synchronized (vVar) {
            try {
                for (Entry entry : vVar) {
                    List list = this.sht;
                    Object key = entry.getKey();
                    j.o(key, "it.key");
                    list.add(new b((String) key, 5));
                }
                y yVar2 = y.AUy;
            } finally {
                AppMethodBeat.o(110281);
            }
        }
        if (!cwY.isEmpty()) {
            this.shC = this.sht.size();
            this.sht.add(new b("", 3));
        }
        h hVar2 = h.scu;
        h.cAM().gL(cwY.size());
        String str = "";
        Iterable<String> iterable = cwY;
        synchronized (iterable) {
            try {
                for (String str2 : iterable) {
                    this.sht.add(new b(str2, 1));
                    com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                    j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                    ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(str2);
                    j.o(aoO, "contact");
                    if (aoO.Oc()) {
                        h hVar3 = h.scu;
                        ap cAM = h.cAM();
                        cAM.gM(cAM.FC() + 1);
                    }
                    str = str + '|' + str2;
                }
                yVar = y.AUy;
            } finally {
                AppMethodBeat.o(110281);
            }
        }
        if (((CharSequence) str).length() > 0) {
            if (str == null) {
                a.v vVar2 = new a.v("null cannot be cast to non-null type java.lang.String");
                throw vVar2;
            } else {
                str = str.substring(1);
                j.o(str, "(this as java.lang.String).substring(startIndex)");
            }
        }
        hVar2 = h.scu;
        h.cAM().fx(str);
        hVar2 = h.scu;
        h.cAM().gN(cwZ.size());
        this.shD = this.sht.size();
        if (!((Collection) cwZ).isEmpty()) {
            this.sht.add(new b("", 2));
        }
        String str3 = "";
        Iterable<String> iterable2 = cwZ;
        synchronized (iterable2) {
            try {
                for (String str22 : iterable2) {
                    this.sht.add(new b(str22, 1));
                    com.tencent.mm.kernel.c.a K2 = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                    j.o(K2, "MMKernel.service(IMessengerStorage::class.java)");
                    ad aoO2 = ((com.tencent.mm.plugin.messenger.foundation.a.j) K2).XM().aoO(str22);
                    j.o(aoO2, "contact");
                    if (aoO2.Oc()) {
                        hVar = h.scu;
                        ap cAM2 = h.cAM();
                        cAM2.gO(cAM2.FD() + 1);
                    }
                    str3 = str3 + '|' + str22;
                }
                yVar = y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.o(110281);
            }
        }
        if (((CharSequence) str3).length() > 0) {
            if (str3 == null) {
                Object vVar3 = new a.v("null cannot be cast to non-null type java.lang.String");
                throw vVar3;
            } else {
                str3 = str3.substring(1);
                j.o(str3, "(this as java.lang.String).substring(startIndex)");
            }
        }
        hVar2 = h.scu;
        h.cAM().fy(str3);
        hVar2 = h.scu;
        h.cAM().bD((long) this.shJ.size());
        hVar2 = h.scu;
        h.cAN();
        c cVar = this.shB;
        List list2 = this.sht;
        j.o(list2, "userNameList");
        j.p(list2, "extInfoList");
        cVar.shw.clear();
        cVar.shw.addAll(list2);
        cVar.notifyDataSetChanged();
        ao aoVar = this.shI;
        hVar = h.scu;
        aoVar.bz((long) h.cAL());
        AppMethodBeat.o(110281);
    }

    public final void finish() {
        e RP;
        AppMethodBeat.i(110280);
        this.shI.bC(this.shH ? 1 : 0);
        this.shI.ajK();
        if (this.shH) {
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.rSS = cb.aaE() + 10;
            for (Entry entry : this.shJ.entrySet()) {
                entry.getKey();
                for (Number longValue : (ArrayList) entry.getValue()) {
                    long longValue2 = longValue.longValue();
                    com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
                    com.tencent.mm.plugin.story.model.b.b.lc(longValue2);
                }
            }
            RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            z Ry = RP.Ry();
            com.tencent.mm.storage.ac.a aVar2 = com.tencent.mm.storage.ac.a.USERINFO_STORY_SNS_ALL_READ_TIME_LONG;
            com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
            Ry.set(aVar2, Long.valueOf(com.tencent.mm.plugin.story.model.j.a.cyh()));
            ru ruVar = new ru();
            ruVar.cNM.cNN = false;
            com.tencent.mm.sdk.b.a.xxA.m(ruVar);
        }
        ab.i("MicroMsg.StoryEntranceView", "finish");
        if (this.sht.size() > 0) {
            RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, Long.valueOf(cb.aaE()));
        }
        com.tencent.mm.plugin.story.model.f.a aVar4 = com.tencent.mm.plugin.story.model.f.a.rWL;
        com.tencent.mm.plugin.story.model.f.a.czh();
        AppMethodBeat.o(110280);
    }

    public static final /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(110283);
        cVar.shF.setVisibility(0);
        cVar.shq.setVisibility(4);
        cVar.shG.setText(cVar.getResources().getString(R.string.est));
        cVar.shH = true;
        ao aoVar = cVar.shI;
        aoVar.bA(aoVar.Fz() + 1);
        AppMethodBeat.o(110283);
    }

    public static final /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(110284);
        cVar.shF.setVisibility(4);
        cVar.shq.setVisibility(0);
        cVar.shG.setText(cVar.getResources().getString(R.string.esq));
        cVar.shH = false;
        ao aoVar = cVar.shI;
        aoVar.bB(aoVar.FA() + 1);
        AppMethodBeat.o(110284);
    }
}
