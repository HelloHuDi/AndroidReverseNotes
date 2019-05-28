package com.tencent.mm.plugin.story.ui.sns;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.ui.StoryBrowseUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0003!\"#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0014J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\u001c\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R2\u0010\u000e\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u00120\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0014\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00150\u0015 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00120\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TYPE_TIP", "", "getTYPE_TIP", "()I", "TYPE_USERNAME", "getTYPE_USERNAME", "entranceAdapter", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "entranceRecycler", "Landroid/support/v7/widget/RecyclerView;", "readNameList", "", "", "kotlin.jvm.PlatformType", "", "storyTypeIndex", "userNameList", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "finish", "", "getLayoutId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "Companion", "DataObject", "EntranceAdapter", "plugin-story_release"})
public final class StoryEntranceUI extends MMActivity implements com.tencent.mm.sdk.e.k.a {
    private static final String TAG = TAG;
    public static final a shv = new a();
    private final int sho = 1;
    private final int shp = 2;
    private RecyclerView shq;
    private c shr;
    private int shs = -1;
    private List<b> sht = Collections.synchronizedList(new LinkedList());
    private List<String> shu = Collections.synchronizedList(new LinkedList());

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "", "userName", "", "type", "", "(Ljava/lang/String;I)V", "getType", "()I", "getUserName", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class b {
        final int type;
        final String userName;

        public b(String str, int i) {
            j.p(str, "userName");
            AppMethodBeat.i(110246);
            this.userName = str;
            this.type = i;
            AppMethodBeat.o(110246);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0003\u001f !B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0016\u001a\u00020\r2\u000e\u0010\u0017\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0014\u0010\u001c\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eRL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "userList", "Ljava/util/ArrayList;", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "extinfoList", "", "EntranceViewHolder", "EntranceViewTipHolder", "EntranceViewUserHolder", "plugin-story_release"})
    public final class c extends android.support.v7.widget.RecyclerView.a<a> {
        m<? super Integer, ? super b, y> seN;
        final ArrayList<b> shw = new ArrayList();

        @l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewTipHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
        public final class b extends a {
            private final TextView gKl;
            final /* synthetic */ c shy;

            public b(c cVar, View view) {
                j.p(view, "itemView");
                this.shy = cVar;
                super(cVar, view);
                AppMethodBeat.i(110249);
                View findViewById = view.findViewById(R.id.n0);
                j.o(findViewById, "itemView.findViewById(R.id.tip_tv)");
                this.gKl = (TextView) findViewById;
                view.setOnClickListener(AnonymousClass1.shz);
                AppMethodBeat.o(110249);
            }

            public final void a(b bVar) {
                AppMethodBeat.i(110248);
                j.p(bVar, "data");
                this.gKl.setText(R.string.eon);
                AppMethodBeat.o(110248);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
        public abstract class a extends v {
            final /* synthetic */ c shy;

            public abstract void a(b bVar);

            public a(c cVar, View view) {
                j.p(view, "itemView");
                this.shy = cVar;
                super(view);
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
        public final class c extends a {
            private final TextView gKl;
            private final ImageView gvq;
            final /* synthetic */ c shy;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
            /* renamed from: com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI$c$c$1 */
            static final class AnonymousClass1 implements OnClickListener {
                final /* synthetic */ c shA;

                AnonymousClass1(c cVar) {
                    this.shA = cVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(110250);
                    int kj = this.shA.kj();
                    Object obj = this.shA.shy.shw.get(kj);
                    j.o(obj, "userList[position]");
                    b bVar = (b) obj;
                    m mVar = this.shA.shy.seN;
                    if (mVar != null) {
                        mVar.m(Integer.valueOf(kj), bVar);
                        AppMethodBeat.o(110250);
                        return;
                    }
                    AppMethodBeat.o(110250);
                }
            }

            public c(c cVar, View view) {
                j.p(view, "itemView");
                this.shy = cVar;
                super(cVar, view);
                AppMethodBeat.i(110252);
                View findViewById = view.findViewById(R.id.qk);
                j.o(findViewById, "itemView.findViewById(R.id.avatar_iv)");
                this.gvq = (ImageView) findViewById;
                findViewById = view.findViewById(R.id.dcf);
                j.o(findViewById, "itemView.findViewById(R.id.user_name_tv)");
                this.gKl = (TextView) findViewById;
                view.setOnClickListener(new AnonymousClass1(this));
                AppMethodBeat.o(110252);
            }

            /* JADX WARNING: Missing block: B:3:0x0031, code skipped:
            if (r0 == null) goto L_0x0033;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(b bVar) {
                String Oj;
                AppMethodBeat.i(110251);
                j.p(bVar, "data");
                com.tencent.mm.pluginsdk.ui.a.b.b(this.gvq, bVar.userName);
                com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
                j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM().aoO(bVar.userName);
                if (aoO != null) {
                    Oj = aoO.Oj();
                }
                Oj = bVar.userName;
                SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b(this.gKl.getContext(), (CharSequence) Oj, this.gKl.getTextSize());
                if (StoryEntranceUI.this.shu.contains(bVar.userName)) {
                    this.gKl.setTextColor(StoryEntranceUI.this.dxU().getResources().getColor(R.color.l));
                } else {
                    this.gKl.setTextColor(StoryEntranceUI.this.dxU().getResources().getColor(R.color.h4));
                }
                this.gKl.setText(b);
                AppMethodBeat.o(110251);
            }
        }

        public c() {
            AppMethodBeat.i(110257);
            AppMethodBeat.o(110257);
        }

        public final int getItemCount() {
            AppMethodBeat.i(110253);
            int size = this.shw.size();
            AppMethodBeat.o(110253);
            return size;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(110255);
            int i2 = ((b) this.shw.get(i)).type;
            AppMethodBeat.o(110255);
            return i2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements OnMenuItemClickListener {
        final /* synthetic */ StoryEntranceUI shx;

        d(StoryEntranceUI storyEntranceUI) {
            this.shx = storyEntranceUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(110258);
            this.shx.finish();
            AppMethodBeat.o(110258);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "item", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "invoke"})
    static final class e extends k implements m<Integer, b, y> {
        final /* synthetic */ StoryEntranceUI shx;

        e(StoryEntranceUI storyEntranceUI) {
            this.shx = storyEntranceUI;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            int i;
            AppMethodBeat.i(110259);
            int intValue = ((Number) obj).intValue();
            j.p((b) obj2, "item");
            LinkedList linkedList = new LinkedList();
            if (intValue >= this.shx.shs) {
                i = intValue - 1;
            } else {
                i = intValue;
            }
            List c = this.shx.sht;
            j.o(c, "userNameList");
            Object<b> obj3 = c;
            synchronized (obj3) {
                try {
                    for (b bVar : obj3) {
                        b bVar2;
                        if ((bVar2.type == 1 ? 1 : null) == null) {
                            bVar2 = null;
                        }
                        if (bVar2 != null) {
                            linkedList.add(bVar2.userName);
                        }
                    }
                    y yVar = y.AUy;
                } finally {
                    AppMethodBeat.o(110259);
                }
            }
            long c2 = o.rQN.c(linkedList, null);
            com.tencent.mm.kernel.b.a M = g.M(com.tencent.mm.plugin.story.api.e.class);
            j.o(M, "MMKernel.plugin(IPluginStory::class.java)");
            com.tencent.mm.plugin.story.api.k.c contactFetcher = ((com.tencent.mm.plugin.story.api.e) M).getContactFetcher();
            j.o(contactFetcher, "MMKernel.plugin(IPluginS…lass.java).contactFetcher");
            contactFetcher.cwY();
            Intent intent = new Intent(this.shx.dxU(), StoryBrowseUI.class);
            intent.putExtra("v_position", i);
            intent.putExtra("data_seed_key", c2);
            intent.putExtra("gallery_session_id", "");
            this.shx.dxU().startActivity(intent);
            Object obj4 = y.AUy;
            return obj4;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public StoryEntranceUI() {
        AppMethodBeat.i(110264);
        AppMethodBeat.o(110264);
    }

    static {
        AppMethodBeat.i(110265);
        AppMethodBeat.o(110265);
    }

    public final void onCreate(Bundle bundle) {
        y yVar;
        AppMethodBeat.i(110260);
        ab.i(TAG, "StoryEntranceUI create ".concat(String.valueOf(this)));
        supportRequestWindowFeature(1);
        getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        super.onCreate(bundle);
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxU().c(this);
        setMMTitle((int) R.string.eol);
        setBackBtn(new d(this), R.raw.actionbar_icon_close_black);
        View findViewById = findViewById(R.id.eti);
        j.o(findViewById, "findViewById(R.id.story_entrance_recycler)");
        this.shq = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.shq;
        if (recyclerView == null) {
            j.avw("entranceRecycler");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.shr = new c();
        RecyclerView recyclerView2 = this.shq;
        if (recyclerView2 == null) {
            j.avw("entranceRecycler");
        }
        recyclerView2.setItemViewCacheSize(0);
        recyclerView = this.shq;
        if (recyclerView == null) {
            j.avw("entranceRecycler");
        }
        c cVar = this.shr;
        if (cVar == null) {
            j.avw("entranceAdapter");
        }
        recyclerView.setAdapter(cVar);
        c cVar2 = this.shr;
        if (cVar2 == null) {
            j.avw("entranceAdapter");
        }
        cVar2.seN = new e(this);
        List cwY = com.tencent.mm.plugin.story.model.f.a.rWL.cwY();
        List cwZ = com.tencent.mm.plugin.story.model.f.a.rWL.cwZ();
        ab.i(TAG, "userNames " + cwY.size() + " lastUserNames " + cwZ.size());
        Iterable<String> iterable = cwY;
        synchronized (iterable) {
            try {
                for (String bVar : iterable) {
                    this.sht.add(new b(bVar, 1));
                }
                yVar = y.AUy;
            } catch (Throwable th) {
                AppMethodBeat.o(110260);
            }
        }
        this.shs = this.sht.size();
        if (cwZ.size() > 0) {
            this.sht.add(new b("", 2));
        }
        iterable = cwZ;
        synchronized (iterable) {
            try {
                for (String bVar2 : iterable) {
                    this.sht.add(new b(bVar2, 1));
                }
                yVar = y.AUy;
            } catch (Throwable th2) {
                AppMethodBeat.o(110260);
            }
        }
        cVar2 = this.shr;
        if (cVar2 == null) {
            j.avw("entranceAdapter");
        }
        cwY = this.sht;
        j.o(cwY, "userNameList");
        j.p(cwY, "extinfoList");
        cVar2.shw.clear();
        cVar2.shw.addAll(cwY);
        cVar2.notifyDataSetChanged();
        AppMethodBeat.o(110260);
    }

    public final void onDestroy() {
        AppMethodBeat.i(110261);
        super.onDestroy();
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cxU().d(this);
        AppMethodBeat.o(110261);
    }

    public final void finish() {
        AppMethodBeat.i(110262);
        ab.i(TAG, "finish " + this.shu.size());
        if (this.sht.size() > 0) {
            String str = ((b) this.sht.get(0)).userName;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            f aap = com.tencent.mm.plugin.story.model.j.a.cxU().aap(str);
            if (aap != null) {
                long j = aap.field_updateTime;
                if (j == 0) {
                    j = ((long) aap.field_storyPostTime) * 1000;
                }
                ab.i(TAG, "finish updateTime user:" + str + " updateTime: " + j);
                if (j > 0) {
                    com.tencent.mm.kernel.e RP = g.RP();
                    j.o(RP, "MMKernel.storage()");
                    RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, Long.valueOf(j));
                }
            }
        }
        super.finish();
        AppMethodBeat.o(110262);
    }

    public final int getLayoutId() {
        return R.layout.ayj;
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        AppMethodBeat.i(110263);
        if (!(str == null || mVar == null || !(mVar.obj instanceof f))) {
            switch (str.hashCode()) {
                case 398324054:
                    if (str.equals("notify_story_read")) {
                        Object obj = mVar.obj;
                        if (obj == null) {
                            a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                            AppMethodBeat.o(110263);
                            throw vVar;
                        }
                        this.shu.add(((f) obj).getUserName());
                        c cVar = this.shr;
                        if (cVar == null) {
                            j.avw("entranceAdapter");
                        }
                        cVar.notifyDataSetChanged();
                        AppMethodBeat.o(110263);
                        return;
                    }
                    break;
            }
            ab.i(TAG, "unknown event ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(110263);
    }
}
