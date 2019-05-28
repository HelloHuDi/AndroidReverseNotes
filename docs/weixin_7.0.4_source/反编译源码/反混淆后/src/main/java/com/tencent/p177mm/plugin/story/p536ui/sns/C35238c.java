package com.tencent.p177mm.plugin.story.p536ui.sns;

import android.content.Context;
import android.content.Intent;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p230g.p231a.C37795ru;
import com.tencent.p177mm.p230g.p232b.p233a.C32663ao;
import com.tencent.p177mm.p230g.p232b.p233a.C32664ap;
import com.tencent.p177mm.p230g.p232b.p233a.C9502ar;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.story.api.C39864o;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p1035b.C46279b;
import com.tencent.p177mm.plugin.story.model.p533d.C43640g;
import com.tencent.p177mm.plugin.story.model.p534f.C39895a;
import com.tencent.p177mm.plugin.story.p530f.C39876h;
import com.tencent.p177mm.plugin.story.p530f.C39876h.C29290a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p536ui.StoryBrowseUI;
import com.tencent.p177mm.plugin.story.p536ui.view.gallery.C39933n;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C25033k;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0003'()B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00150\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R2\u0010\u001e\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010 0  !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010 0 \u0018\u00010\"0\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/story/ui/sns/DialogLifeStyle;", "context", "Landroid/content/Context;", "click", "Landroid/view/View$OnClickListener;", "(Landroid/content/Context;Landroid/view/View$OnClickListener;)V", "clearTxt", "Landroid/widget/TextView;", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "noDataView", "Landroid/view/View;", "replyToIndexMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldClear", "", "storyClearReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeCleanStruct;", "storyTypeNewIndex", "", "storyTypeOlderIndex", "storyTypeReplyCount", "userNameList", "", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "kotlin.jvm.PlatformType", "", "finish", "", "hideContent", "showContent", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.sns.c */
public final class C35238c extends LinearLayout implements C43650a {
    public static final C35239a shK = new C35239a();
    private C22275c shB;
    private int shC = -1;
    private int shD = -1;
    private int shE = -1;
    private View shF;
    private TextView shG;
    private boolean shH;
    private C32663ao shI = new C32663ao();
    private LinkedHashMap<String, ArrayList<Long>> shJ = new LinkedHashMap();
    private RecyclerView shq;
    private List<C22272b> sht = Collections.synchronizedList(new LinkedList());

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$1 */
    static final class C222711 implements OnClickListener {
        final /* synthetic */ C35238c shL;

        C222711(C35238c c35238c) {
            this.shL = c35238c;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110266);
            this.shL.shH = !this.shL.shH;
            if (this.shL.shH) {
                C35238c.m57851b(this.shL);
                AppMethodBeat.m2505o(110266);
                return;
            }
            C35238c.m57852c(this.shL);
            AppMethodBeat.m2505o(110266);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$b */
    public static final class C22272b {
        final int type;
        final String userName;

        public C22272b(String str, int i) {
            C25052j.m39376p(str, "userName");
            AppMethodBeat.m2504i(110268);
            this.userName = str;
            this.type = i;
            AppMethodBeat.m2505o(110268);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0003 !\"B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0017\u001a\u00020\r2\u000e\u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0019\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0014\u0010\u001d\u001a\u00020\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fRL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extInfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$c */
    public final class C22275c extends C41523a<C22276a> {
        C31591m<? super Integer, ? super C22272b, C37091y> seN;
        final ArrayList<C22272b> shw = new ArrayList();

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "reply", "getReply", "setReply", "(Landroid/widget/TextView;)V", "star", "getStar", "()Landroid/view/View;", "setStar", "(Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$c$c */
        public final class C13845c extends C22276a {
            private final TextView gKl;
            private final ImageView gvq;
            final /* synthetic */ C22275c shN;
            private View shQ;
            private TextView shR;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$c$c$1 */
            static final class C138461 implements OnClickListener {
                final /* synthetic */ C13845c shS;

                C138461(C13845c c13845c) {
                    this.shS = c13845c;
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(110272);
                    int kj = this.shS.mo66454kj();
                    Object obj = this.shS.shN.shw.get(kj);
                    C25052j.m39375o(obj, "userList[position]");
                    C22272b c22272b = (C22272b) obj;
                    C31591m c31591m = this.shS.shN.seN;
                    if (c31591m != null) {
                        c31591m.mo212m(Integer.valueOf(kj), c22272b);
                        AppMethodBeat.m2505o(110272);
                        return;
                    }
                    AppMethodBeat.m2505o(110272);
                }
            }

            public C13845c(C22275c c22275c, View view) {
                C25052j.m39376p(view, "itemView");
                this.shN = c22275c;
                super(c22275c, view);
                AppMethodBeat.m2504i(110274);
                View findViewById = view.findViewById(2131821183);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.avatar_iv)");
                this.gvq = (ImageView) findViewById;
                findViewById = view.findViewById(2131826146);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.user_name_tv)");
                this.gKl = (TextView) findViewById;
                findViewById = view.findViewById(2131828143);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.star)");
                this.shQ = findViewById;
                findViewById = view.findViewById(2131828142);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.reply_icon)");
                this.shR = (TextView) findViewById;
                view.setOnClickListener(new C138461(this));
                AppMethodBeat.m2505o(110274);
            }

            /* JADX WARNING: Missing block: B:3:0x0032, code skipped:
            if (r0 == null) goto L_0x0034;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public final void mo26012a(C22272b c22272b) {
                String Oj;
                int i = 0;
                AppMethodBeat.m2504i(110273);
                C25052j.m39376p(c22272b, "data");
                C40460b.m69437r(this.gvq, c22272b.userName);
                C1694a K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                C7616ad aoO = ((C6982j) K).mo15369XM().aoO(c22272b.userName);
                if (aoO != null) {
                    Oj = aoO.mo16707Oj();
                }
                Oj = c22272b.userName;
                SpannableString b = C44089j.m79293b(this.gKl.getContext(), (CharSequence) Oj, this.gKl.getTextSize());
                View view = this.shQ;
                C25052j.m39375o(aoO, "contact");
                view.setVisibility(aoO.mo16700Oc() ? 0 : 4);
                this.gKl.setText(b);
                TextView textView = this.shR;
                if (c22272b.type == 5) {
                    this.shR.setText(String.valueOf(C39895a.rWL.aaH(c22272b.userName)));
                } else {
                    i = 8;
                }
                textView.setVisibility(i);
                AppMethodBeat.m2505o(110273);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView;", "itemView", "Landroid/view/View;", "tipId", "", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;I)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "getTipId", "()I", "setTipId", "(I)V", "onBind", "", "position", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$c$b */
        public final class C22273b extends C22276a {
            private final TextView gKl;
            final /* synthetic */ C22275c shN;
            private int shO;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$c$b$1 */
            static final class C222741 implements OnClickListener {
                public static final C222741 shP = new C222741();

                static {
                    AppMethodBeat.m2504i(110269);
                    AppMethodBeat.m2505o(110269);
                }

                C222741() {
                }

                public final void onClick(View view) {
                }
            }

            public C22273b(C22275c c22275c, View view, int i) {
                C25052j.m39376p(view, "itemView");
                this.shN = c22275c;
                super(c22275c, view);
                AppMethodBeat.m2504i(110271);
                this.shO = i;
                View findViewById = view.findViewById(2131821051);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.tip_tv)");
                this.gKl = (TextView) findViewById;
                view.setOnClickListener(C222741.shP);
                AppMethodBeat.m2505o(110271);
            }

            /* renamed from: a */
            public final void mo26012a(C22272b c22272b) {
                AppMethodBeat.m2504i(110270);
                C25052j.m39376p(c22272b, "data");
                this.gKl.setText(this.shO);
                AppMethodBeat.m2505o(110270);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$DataObject;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$c$a */
        public abstract class C22276a extends C41531v {
            final /* synthetic */ C22275c shN;

            /* renamed from: a */
            public abstract void mo26012a(C22272b c22272b);

            public C22276a(C22275c c22275c, View view) {
                C25052j.m39376p(view, "itemView");
                this.shN = c22275c;
                super(view);
            }
        }

        public C22275c() {
            AppMethodBeat.m2504i(110279);
            AppMethodBeat.m2505o(110279);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(110275);
            int size = this.shw.size();
            AppMethodBeat.m2505o(110275);
            return size;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(110277);
            int i2 = ((C22272b) this.shw.get(i)).type;
            AppMethodBeat.m2505o(110277);
            return i2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceView$Companion;", "", "()V", "AGO_TYPE_TIP", "", "NEW_TYPE_TIP", "REPLY_TYPE_TIP", "TAG", "", "TYPE_REPLY_USERNAME", "TYPE_USERNAME", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.c$a */
    public static final class C35239a {
        private C35239a() {
        }

        public /* synthetic */ C35239a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(110282);
        AppMethodBeat.m2505o(110282);
    }

    public C35238c(final Context context, final OnClickListener onClickListener) {
        boolean z;
        C37091y c37091y;
        C22212h c22212h;
        C25052j.m39376p(context, "context");
        super(context);
        AppMethodBeat.m2504i(110281);
        View inflate = LayoutInflater.from(context).inflate(2130970883, this, true);
        inflate.findViewById(2131828144).setOnClickListener(onClickListener);
        View findViewById = inflate.findViewById(2131828146);
        C25052j.m39375o(findViewById, "parent.findViewById<View>(R.id.no_data)");
        this.shF = findViewById;
        findViewById = inflate.findViewById(2131828145);
        C25052j.m39375o(findViewById, "parent.findViewById<TextView>(R.id.clear_txt)");
        this.shG = (TextView) findViewById;
        this.shG.setOnClickListener(new C222711(this));
        findViewById = inflate.findViewById(2131828147);
        C25052j.m39375o(findViewById, "parent.findViewById(R.id.story_entrance_recycler)");
        this.shq = (RecyclerView) findViewById;
        this.shq.setLayoutManager(new LinearLayoutManager());
        this.shB = new C22275c();
        this.shq.setItemViewCacheSize(0);
        this.shq.setAdapter(this.shB);
        this.shB.seN = new C31591m<Integer, C22272b, C37091y>(this) {
            final /* synthetic */ C35238c shL;

            /* renamed from: m */
            public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
                int i;
                C22272b c22272b;
                C37091y c37091y;
                AppMethodBeat.m2504i(110267);
                int intValue = ((Number) obj).intValue();
                C22272b c22272b2 = (C22272b) obj2;
                C25052j.m39376p(c22272b2, "item");
                LinkedList linkedList = new LinkedList();
                HashMap hashMap = new HashMap();
                int i2;
                C22212h c22212h;
                if (c22272b2.type == 5) {
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
                    c22212h = C22212h.scu;
                    C22212h.cAs().mo20759oh(1);
                    i = i2;
                } else if (c22272b2.type == 1) {
                    C9502ar cAs;
                    StringBuilder stringBuilder;
                    C22212h c22212h2;
                    if (intValue <= this.shL.shE || this.shL.shE == -1) {
                        i2 = intValue;
                    } else {
                        i2 = intValue - this.shL.shE;
                    }
                    if (intValue >= this.shL.shC && this.shL.shC != -1) {
                        i2--;
                        c22212h = C22212h.scu;
                        C22212h.cAs().mo20743bG(12);
                        c22212h = C22212h.scu;
                        cAs = C22212h.cAs();
                        stringBuilder = new StringBuilder("12_");
                        c22212h2 = C22212h.scu;
                        cAs.mo20757fC(stringBuilder.append(C22212h.cAL()).toString());
                    }
                    if (intValue >= this.shL.shD && this.shL.shD != -1) {
                        i2--;
                        c22212h = C22212h.scu;
                        C22212h.cAs().mo20743bG(13);
                        c22212h = C22212h.scu;
                        cAs = C22212h.cAs();
                        stringBuilder = new StringBuilder("13_");
                        c22212h2 = C22212h.scu;
                        cAs.mo20757fC(stringBuilder.append(C22212h.cAL()).toString());
                    }
                    i = i2;
                } else {
                    i = intValue;
                }
                List h = this.shL.sht;
                C25052j.m39375o(h, "userNameList");
                Iterable<C22272b> iterable = h;
                synchronized (iterable) {
                    try {
                        for (C22272b c22272b3 : iterable) {
                            if ((c22272b3.type == c22272b2.type ? 1 : null) == null) {
                                c22272b3 = null;
                            }
                            if (c22272b3 != null) {
                                linkedList.add(c22272b3.userName);
                            }
                        }
                        c37091y = C37091y.AUy;
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(110267);
                    }
                }
                C7060h.pYm.mo15419k(1015, 6, 1);
                h = this.shL.sht;
                C25052j.m39375o(h, "userNameList");
                Iterable iterable2 = h;
                synchronized (iterable2) {
                    try {
                        int i3 = 0;
                        for (Object next : iterable2) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                C7987l.dWs();
                            }
                            c22272b3 = (C22272b) next;
                            Object obj3 = (c22272b3.type != c22272b2.type || i3 >= intValue) ? null : 1;
                            if (obj3 == null) {
                                c22272b3 = null;
                            }
                            if (c22272b3 != null) {
                                linkedList.add(c22272b3.userName);
                                i3 = i4;
                            } else {
                                i3 = i4;
                            }
                        }
                        c37091y = C37091y.AUy;
                    } catch (Throwable th2) {
                        AppMethodBeat.m2505o(110267);
                    }
                }
                C22212h c22212h3 = C22212h.scu;
                C22212h.cAs().mo20755fA((String) linkedList.get(i));
                long c = C39864o.rQN.mo55836c(linkedList, hashMap);
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
                C37091y c37091y2 = C37091y.AUy;
                AppMethodBeat.m2505o(110267);
                return c37091y2;
            }
        };
        List cwY = C39895a.rWL.cwY();
        List cwZ = C39895a.rWL.cwZ();
        this.shJ = C39895a.rWL.cxa();
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_preload_with_enter_pop_sns, 1) == 1) {
            C29290a c29290a;
            C43640g bt;
            C39933n c39933n;
            if (!((Collection) cwY).isEmpty()) {
                c29290a = C39876h.rZx;
                bt = C29290a.m46505bt((String) cwY.get(0), false);
                if (bt != null) {
                    c39933n = C39933n.sqi;
                    C39933n.m68391q(C25033k.listOf(bt.rVZ), 5);
                }
            } else {
                if (cwZ.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    c29290a = C39876h.rZx;
                    bt = C29290a.m46505bt((String) cwZ.get(0), false);
                    if (bt != null) {
                        c39933n = C39933n.sqi;
                        C39933n.m68391q(C25033k.listOf(bt.rVZ), 5);
                    }
                }
            }
        }
        C4990ab.m7416i("MicroMsg.StoryEntranceView", "userNames " + cwY.size() + " lastUserNames " + cwZ.size());
        if (this.shJ.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.sht.add(new C22272b("", 4));
            this.shE = this.shJ.size() + 1;
        }
        Set entrySet = this.shJ.entrySet();
        C25052j.m39375o(entrySet, "replyToIndexMap.entries");
        C44941v<Entry> c44941v = entrySet;
        synchronized (c44941v) {
            try {
                for (Entry entry : c44941v) {
                    List list = this.sht;
                    Object key = entry.getKey();
                    C25052j.m39375o(key, "it.key");
                    list.add(new C22272b((String) key, 5));
                }
                C37091y c37091y2 = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(110281);
            }
        }
        if (!cwY.isEmpty()) {
            this.shC = this.sht.size();
            this.sht.add(new C22272b("", 3));
        }
        C22212h c22212h2 = C22212h.scu;
        C22212h.cAM().mo53182gL(cwY.size());
        String str = "";
        Iterable<String> iterable = cwY;
        synchronized (iterable) {
            try {
                for (String str2 : iterable) {
                    this.sht.add(new C22272b(str2, 1));
                    C1694a K = C1720g.m3528K(C6982j.class);
                    C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                    C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str2);
                    C25052j.m39375o(aoO, "contact");
                    if (aoO.mo16700Oc()) {
                        C22212h c22212h3 = C22212h.scu;
                        C32664ap cAM = C22212h.cAM();
                        cAM.mo53183gM(cAM.mo53174FC() + 1);
                    }
                    str = str + '|' + str2;
                }
                c37091y = C37091y.AUy;
            } finally {
                AppMethodBeat.m2505o(110281);
            }
        }
        if (((CharSequence) str).length() > 0) {
            if (str == null) {
                C44941v c44941v2 = new C44941v("null cannot be cast to non-null type java.lang.String");
                throw c44941v2;
            } else {
                str = str.substring(1);
                C25052j.m39375o(str, "(this as java.lang.String).substring(startIndex)");
            }
        }
        c22212h2 = C22212h.scu;
        C22212h.cAM().mo53178fx(str);
        c22212h2 = C22212h.scu;
        C22212h.cAM().mo53184gN(cwZ.size());
        this.shD = this.sht.size();
        if (!((Collection) cwZ).isEmpty()) {
            this.sht.add(new C22272b("", 2));
        }
        String str3 = "";
        Iterable<String> iterable2 = cwZ;
        synchronized (iterable2) {
            try {
                for (String str22 : iterable2) {
                    this.sht.add(new C22272b(str22, 1));
                    C1694a K2 = C1720g.m3528K(C6982j.class);
                    C25052j.m39375o(K2, "MMKernel.service(IMessengerStorage::class.java)");
                    C7616ad aoO2 = ((C6982j) K2).mo15369XM().aoO(str22);
                    C25052j.m39375o(aoO2, "contact");
                    if (aoO2.mo16700Oc()) {
                        c22212h = C22212h.scu;
                        C32664ap cAM2 = C22212h.cAM();
                        cAM2.mo53185gO(cAM2.mo53175FD() + 1);
                    }
                    str3 = str3 + '|' + str22;
                }
                c37091y = C37091y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(110281);
            }
        }
        if (((CharSequence) str3).length() > 0) {
            if (str3 == null) {
                Object c44941v3 = new C44941v("null cannot be cast to non-null type java.lang.String");
                throw c44941v3;
            } else {
                str3 = str3.substring(1);
                C25052j.m39375o(str3, "(this as java.lang.String).substring(startIndex)");
            }
        }
        c22212h2 = C22212h.scu;
        C22212h.cAM().mo53179fy(str3);
        c22212h2 = C22212h.scu;
        C22212h.cAM().mo53176bD((long) this.shJ.size());
        c22212h2 = C22212h.scu;
        C22212h.cAN();
        C22275c c22275c = this.shB;
        List list2 = this.sht;
        C25052j.m39375o(list2, "userNameList");
        C25052j.m39376p(list2, "extInfoList");
        c22275c.shw.clear();
        c22275c.shw.addAll(list2);
        c22275c.notifyDataSetChanged();
        C32663ao c32663ao = this.shI;
        c22212h = C22212h.scu;
        c32663ao.mo53172bz((long) C22212h.cAL());
        AppMethodBeat.m2505o(110281);
    }

    public final void finish() {
        C1706e RP;
        AppMethodBeat.m2504i(110280);
        this.shI.mo53171bC(this.shH ? 1 : 0);
        this.shI.ajK();
        if (this.shH) {
            C4133a c4133a = C43644j.rST;
            C43644j.rSS = C1839cb.aaE() + 10;
            for (Entry entry : this.shJ.entrySet()) {
                entry.getKey();
                for (Number longValue : (ArrayList) entry.getValue()) {
                    long longValue2 = longValue.longValue();
                    C46279b c46279b = C46279b.rVw;
                    C46279b.m86768lc(longValue2);
                }
            }
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            C7580z Ry = RP.mo5239Ry();
            C5127a c5127a = C5127a.USERINFO_STORY_SNS_ALL_READ_TIME_LONG;
            C4133a c4133a2 = C43644j.rST;
            Ry.set(c5127a, Long.valueOf(C4133a.cyh()));
            C37795ru c37795ru = new C37795ru();
            c37795ru.cNM.cNN = false;
            C4879a.xxA.mo10055m(c37795ru);
        }
        C4990ab.m7416i("MicroMsg.StoryEntranceView", "finish");
        if (this.sht.size() > 0) {
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, Long.valueOf(C1839cb.aaE()));
        }
        C39895a c39895a = C39895a.rWL;
        C39895a.czh();
        AppMethodBeat.m2505o(110280);
    }

    /* renamed from: b */
    public static final /* synthetic */ void m57851b(C35238c c35238c) {
        AppMethodBeat.m2504i(110283);
        c35238c.shF.setVisibility(0);
        c35238c.shq.setVisibility(4);
        c35238c.shG.setText(c35238c.getResources().getString(C25738R.string.est));
        c35238c.shH = true;
        C32663ao c32663ao = c35238c.shI;
        c32663ao.mo53169bA(c32663ao.mo53168Fz() + 1);
        AppMethodBeat.m2505o(110283);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m57852c(C35238c c35238c) {
        AppMethodBeat.m2504i(110284);
        c35238c.shF.setVisibility(4);
        c35238c.shq.setVisibility(0);
        c35238c.shG.setText(c35238c.getResources().getString(C25738R.string.esq));
        c35238c.shH = false;
        C32663ao c32663ao = c35238c.shI;
        c32663ao.mo53170bB(c32663ao.mo53167FA() + 1);
        AppMethodBeat.m2505o(110284);
    }
}
