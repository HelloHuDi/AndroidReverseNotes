package com.tencent.p177mm.plugin.story.p536ui.sns;

import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1677a;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.story.api.C29269k.C29272c;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C39864o;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p534f.C39895a;
import com.tencent.p177mm.plugin.story.p532h.C4119f;
import com.tencent.p177mm.plugin.story.p536ui.StoryBrowseUI;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0003!\"#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0014J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\u001c\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u00120\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00150\u0015 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00120\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TYPE_TIP", "", "getTYPE_TIP", "()I", "TYPE_USERNAME", "getTYPE_USERNAME", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "readNameList", "", "", "kotlin.jvm.PlatformType", "", "storyTypeIndex", "userNameList", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "finish", "", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI */
public final class StoryEntranceUI extends MMActivity implements C4931a {
    private static final String TAG = TAG;
    public static final C13842a shv = new C13842a();
    private final int sho = 1;
    private final int shp = 2;
    private RecyclerView shq;
    private C13836c shr;
    private int shs = -1;
    private List<C13835b> sht = Collections.synchronizedList(new LinkedList());
    private List<String> shu = Collections.synchronizedList(new LinkedList());

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$b */
    public static final class C13835b {
        final int type;
        final String userName;

        public C13835b(String str, int i) {
            C25052j.m39376p(str, "userName");
            AppMethodBeat.m2504i(110246);
            this.userName = str;
            this.type = i;
            AppMethodBeat.m2505o(110246);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0003\u001f !B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0016\u001a\u00020\r2\u000e\u0010\u0017\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0014\u0010\u001c\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eRL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extinfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$c */
    public final class C13836c extends C41523a<C13837a> {
        C31591m<? super Integer, ? super C13835b, C37091y> seN;
        final ArrayList<C13835b> shw = new ArrayList();

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$c$b */
        public final class C13833b extends C13837a {
            private final TextView gKl;
            final /* synthetic */ C13836c shy;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$c$b$1 */
            static final class C138341 implements OnClickListener {
                public static final C138341 shz = new C138341();

                static {
                    AppMethodBeat.m2504i(110247);
                    AppMethodBeat.m2505o(110247);
                }

                C138341() {
                }

                public final void onClick(View view) {
                }
            }

            public C13833b(C13836c c13836c, View view) {
                C25052j.m39376p(view, "itemView");
                this.shy = c13836c;
                super(c13836c, view);
                AppMethodBeat.m2504i(110249);
                View findViewById = view.findViewById(2131821051);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.tip_tv)");
                this.gKl = (TextView) findViewById;
                view.setOnClickListener(C138341.shz);
                AppMethodBeat.m2505o(110249);
            }

            /* renamed from: a */
            public final void mo26007a(C13835b c13835b) {
                AppMethodBeat.m2504i(110248);
                C25052j.m39376p(c13835b, "data");
                this.gKl.setText(C25738R.string.eon);
                AppMethodBeat.m2505o(110248);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$c$a */
        public abstract class C13837a extends C41531v {
            final /* synthetic */ C13836c shy;

            /* renamed from: a */
            public abstract void mo26007a(C13835b c13835b);

            public C13837a(C13836c c13836c, View view) {
                C25052j.m39376p(view, "itemView");
                this.shy = c13836c;
                super(view);
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$c$c */
        public final class C13838c extends C13837a {
            private final TextView gKl;
            private final ImageView gvq;
            final /* synthetic */ C13836c shy;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$c$c$1 */
            static final class C138391 implements OnClickListener {
                final /* synthetic */ C13838c shA;

                C138391(C13838c c13838c) {
                    this.shA = c13838c;
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(110250);
                    int kj = this.shA.mo66454kj();
                    Object obj = this.shA.shy.shw.get(kj);
                    C25052j.m39375o(obj, "userList[position]");
                    C13835b c13835b = (C13835b) obj;
                    C31591m c31591m = this.shA.shy.seN;
                    if (c31591m != null) {
                        c31591m.mo212m(Integer.valueOf(kj), c13835b);
                        AppMethodBeat.m2505o(110250);
                        return;
                    }
                    AppMethodBeat.m2505o(110250);
                }
            }

            public C13838c(C13836c c13836c, View view) {
                C25052j.m39376p(view, "itemView");
                this.shy = c13836c;
                super(c13836c, view);
                AppMethodBeat.m2504i(110252);
                View findViewById = view.findViewById(2131821183);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.avatar_iv)");
                this.gvq = (ImageView) findViewById;
                findViewById = view.findViewById(2131826146);
                C25052j.m39375o(findViewById, "itemView.findViewById(R.id.user_name_tv)");
                this.gKl = (TextView) findViewById;
                view.setOnClickListener(new C138391(this));
                AppMethodBeat.m2505o(110252);
            }

            /* JADX WARNING: Missing block: B:3:0x0031, code skipped:
            if (r0 == null) goto L_0x0033;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public final void mo26007a(C13835b c13835b) {
                String Oj;
                AppMethodBeat.m2504i(110251);
                C25052j.m39376p(c13835b, "data");
                C40460b.m69434b(this.gvq, c13835b.userName);
                C1694a K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                C7616ad aoO = ((C6982j) K).mo15369XM().aoO(c13835b.userName);
                if (aoO != null) {
                    Oj = aoO.mo16707Oj();
                }
                Oj = c13835b.userName;
                SpannableString b = C44089j.m79293b(this.gKl.getContext(), (CharSequence) Oj, this.gKl.getTextSize());
                if (StoryEntranceUI.this.shu.contains(c13835b.userName)) {
                    this.gKl.setTextColor(StoryEntranceUI.this.dxU().getResources().getColor(C25738R.color.f11627l));
                } else {
                    this.gKl.setTextColor(StoryEntranceUI.this.dxU().getResources().getColor(C25738R.color.f11782h4));
                }
                this.gKl.setText(b);
                AppMethodBeat.m2505o(110251);
            }
        }

        public C13836c() {
            AppMethodBeat.m2504i(110257);
            AppMethodBeat.m2505o(110257);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(110253);
            int size = this.shw.size();
            AppMethodBeat.m2505o(110253);
            return size;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(110255);
            int i2 = ((C13835b) this.shw.get(i)).type;
            AppMethodBeat.m2505o(110255);
            return i2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$d */
    static final class C13840d implements OnMenuItemClickListener {
        final /* synthetic */ StoryEntranceUI shx;

        C13840d(StoryEntranceUI storyEntranceUI) {
            this.shx = storyEntranceUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(110258);
            this.shx.finish();
            AppMethodBeat.m2505o(110258);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$e */
    static final class C13841e extends C25053k implements C31591m<Integer, C13835b, C37091y> {
        final /* synthetic */ StoryEntranceUI shx;

        C13841e(StoryEntranceUI storyEntranceUI) {
            this.shx = storyEntranceUI;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            int i;
            AppMethodBeat.m2504i(110259);
            int intValue = ((Number) obj).intValue();
            C25052j.m39376p((C13835b) obj2, "item");
            LinkedList linkedList = new LinkedList();
            if (intValue >= this.shx.shs) {
                i = intValue - 1;
            } else {
                i = intValue;
            }
            List c = this.shx.sht;
            C25052j.m39375o(c, "userNameList");
            Object<C13835b> obj3 = c;
            synchronized (obj3) {
                try {
                    for (C13835b c13835b : obj3) {
                        C13835b c13835b2;
                        if ((c13835b2.type == 1 ? 1 : null) == null) {
                            c13835b2 = null;
                        }
                        if (c13835b2 != null) {
                            linkedList.add(c13835b2.userName);
                        }
                    }
                    C37091y c37091y = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(110259);
                }
            }
            long c2 = C39864o.rQN.mo55836c(linkedList, null);
            C1677a M = C1720g.m3530M(C35168e.class);
            C25052j.m39375o(M, "MMKernel.plugin(IPluginStory::class.java)");
            C29272c contactFetcher = ((C35168e) M).getContactFetcher();
            C25052j.m39375o(contactFetcher, "MMKernel.plugin(IPluginS…lass.java).contactFetcher");
            contactFetcher.cwY();
            Intent intent = new Intent(this.shx.dxU(), StoryBrowseUI.class);
            intent.putExtra("v_position", i);
            intent.putExtra("data_seed_key", c2);
            intent.putExtra("gallery_session_id", "");
            this.shx.dxU().startActivity(intent);
            Object obj4 = C37091y.AUy;
            return obj4;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$a */
    public static final class C13842a {
        private C13842a() {
        }

        public /* synthetic */ C13842a(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public StoryEntranceUI() {
        AppMethodBeat.m2504i(110264);
        AppMethodBeat.m2505o(110264);
    }

    static {
        AppMethodBeat.m2504i(110265);
        AppMethodBeat.m2505o(110265);
    }

    public final void onCreate(Bundle bundle) {
        C37091y c37091y;
        AppMethodBeat.m2504i(110260);
        C4990ab.m7416i(TAG, "StoryEntranceUI create ".concat(String.valueOf(this)));
        supportRequestWindowFeature(1);
        getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        super.onCreate(bundle);
        C4133a c4133a = C43644j.rST;
        C4133a.cxU().mo10116c(this);
        setMMTitle((int) C25738R.string.eol);
        setBackBtn(new C13840d(this), C1318a.actionbar_icon_close_black);
        View findViewById = findViewById(2131828147);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_entrance_recycler)");
        this.shq = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.shq;
        if (recyclerView == null) {
            C25052j.avw("entranceRecycler");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.shr = new C13836c();
        RecyclerView recyclerView2 = this.shq;
        if (recyclerView2 == null) {
            C25052j.avw("entranceRecycler");
        }
        recyclerView2.setItemViewCacheSize(0);
        recyclerView = this.shq;
        if (recyclerView == null) {
            C25052j.avw("entranceRecycler");
        }
        C13836c c13836c = this.shr;
        if (c13836c == null) {
            C25052j.avw("entranceAdapter");
        }
        recyclerView.setAdapter(c13836c);
        C13836c c13836c2 = this.shr;
        if (c13836c2 == null) {
            C25052j.avw("entranceAdapter");
        }
        c13836c2.seN = new C13841e(this);
        List cwY = C39895a.rWL.cwY();
        List cwZ = C39895a.rWL.cwZ();
        C4990ab.m7416i(TAG, "userNames " + cwY.size() + " lastUserNames " + cwZ.size());
        Iterable<String> iterable = cwY;
        synchronized (iterable) {
            try {
                for (String c13835b : iterable) {
                    this.sht.add(new C13835b(c13835b, 1));
                }
                c37091y = C37091y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(110260);
            }
        }
        this.shs = this.sht.size();
        if (cwZ.size() > 0) {
            this.sht.add(new C13835b("", 2));
        }
        iterable = cwZ;
        synchronized (iterable) {
            try {
                for (String c13835b2 : iterable) {
                    this.sht.add(new C13835b(c13835b2, 1));
                }
                c37091y = C37091y.AUy;
            } catch (Throwable th2) {
                AppMethodBeat.m2505o(110260);
            }
        }
        c13836c2 = this.shr;
        if (c13836c2 == null) {
            C25052j.avw("entranceAdapter");
        }
        cwY = this.sht;
        C25052j.m39375o(cwY, "userNameList");
        C25052j.m39376p(cwY, "extinfoList");
        c13836c2.shw.clear();
        c13836c2.shw.addAll(cwY);
        c13836c2.notifyDataSetChanged();
        AppMethodBeat.m2505o(110260);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(110261);
        super.onDestroy();
        C4133a c4133a = C43644j.rST;
        C4133a.cxU().mo10117d(this);
        AppMethodBeat.m2505o(110261);
    }

    public final void finish() {
        AppMethodBeat.m2504i(110262);
        C4990ab.m7416i(TAG, "finish " + this.shu.size());
        if (this.sht.size() > 0) {
            String str = ((C13835b) this.sht.get(0)).userName;
            C4133a c4133a = C43644j.rST;
            C4119f aap = C4133a.cxU().aap(str);
            if (aap != null) {
                long j = aap.field_updateTime;
                if (j == 0) {
                    j = ((long) aap.field_storyPostTime) * 1000;
                }
                C4990ab.m7416i(TAG, "finish updateTime user:" + str + " updateTime: " + j);
                if (j > 0) {
                    C1706e RP = C1720g.m3536RP();
                    C25052j.m39375o(RP, "MMKernel.storage()");
                    RP.mo5239Ry().set(C5127a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, Long.valueOf(j));
                }
            }
        }
        super.finish();
        AppMethodBeat.m2505o(110262);
    }

    public final int getLayoutId() {
        return 2130970883;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(110263);
        if (!(str == null || c4935m == null || !(c4935m.obj instanceof C4119f))) {
            switch (str.hashCode()) {
                case 398324054:
                    if (str.equals("notify_story_read")) {
                        Object obj = c4935m.obj;
                        if (obj == null) {
                            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                            AppMethodBeat.m2505o(110263);
                            throw c44941v;
                        }
                        this.shu.add(((C4119f) obj).getUserName());
                        C13836c c13836c = this.shr;
                        if (c13836c == null) {
                            C25052j.avw("entranceAdapter");
                        }
                        c13836c.notifyDataSetChanged();
                        AppMethodBeat.m2505o(110263);
                        return;
                    }
                    break;
            }
            C4990ab.m7416i(TAG, "unknown event ".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(110263);
    }
}
