package com.tencent.mm.emoji.debug;

import a.a.t;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.z;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J#\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\tH\u0002¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J#\u0010\u0014\u001a\u00020\u0011\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u0002H\tH\u0002¢\u0006\u0002\u0010\u0016R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "ConfigItem", "DebugAdapter", "DebugViewHolder", "plugin-emojisdk_release"})
public final class EmojiDebugUI extends MMActivity {
    private final LinkedList<a> ewZ = new LinkedList();
    private RecyclerView exa;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
    public final class c<T> extends a {
        final /* synthetic */ EmojiDebugUI exb;
        final com.tencent.mm.storage.ac.a exd;
        private final List<String> exe;
        final List<T> exf;
        private final String title;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "T", "whichButton", "", "resultId", "onClick"})
        static final class a implements com.tencent.mm.ui.base.h.d {
            final /* synthetic */ c exg;

            a(c cVar) {
                this.exg = cVar;
            }

            public final void bV(int i, int i2) {
                AppMethodBeat.i(63117);
                EmojiDebugUI.b(this.exg.exd, this.exg.exf.get(i2));
                RecyclerView a = this.exg.exb.exa;
                if (a != null) {
                    android.support.v7.widget.RecyclerView.a adapter = a.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                        AppMethodBeat.o(63117);
                        return;
                    }
                }
                AppMethodBeat.o(63117);
            }
        }

        public c(EmojiDebugUI emojiDebugUI, String str, com.tencent.mm.storage.ac.a aVar, List<String> list, List<? extends T> list2) {
            j.p(str, "title");
            j.p(aVar, "configKey");
            j.p(list, "contentArray");
            j.p(list2, "valueArray");
            this.exb = emojiDebugUI;
            super();
            AppMethodBeat.i(63120);
            this.title = str;
            this.exd = aVar;
            this.exe = list;
            this.exf = list2;
            AppMethodBeat.o(63120);
        }

        public final String Op() {
            return this.title;
        }

        public final String Oq() {
            AppMethodBeat.i(63118);
            int indexOf = this.exf.indexOf(EmojiDebugUI.a(this.exd, this.exf.get(0)));
            String str;
            if (indexOf < 0 || indexOf >= this.exe.size()) {
                str = (String) this.exe.get(0);
                AppMethodBeat.o(63118);
                return str;
            }
            str = (String) this.exe.get(indexOf);
            AppMethodBeat.o(63118);
            return str;
        }

        public final void onClick() {
            AppMethodBeat.i(63119);
            LinkedList linkedList = new LinkedList();
            int size = this.exe.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(Integer.valueOf(i));
            }
            com.tencent.mm.ui.base.h.a((Context) this.exb, "", this.exe, t.m(a.a.l.g(this.exe)), "", (com.tencent.mm.ui.base.h.d) new a(this));
            AppMethodBeat.o(63119);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-emojisdk_release"})
    public final class d extends android.support.v7.widget.RecyclerView.a<e> {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements OnClickListener {
            final /* synthetic */ d exh;
            final /* synthetic */ int exi;

            a(d dVar, int i) {
                this.exh = dVar;
                this.exi = i;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(63121);
                ((a) EmojiDebugUI.this.ewZ.get(this.exi)).onClick();
                AppMethodBeat.o(63121);
            }
        }

        public final int getItemCount() {
            AppMethodBeat.i(63123);
            int size = EmojiDebugUI.this.ewZ.size();
            AppMethodBeat.o(63123);
            return size;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0006\u001a\u00020\bH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "()Ljava/lang/String;", "getValue", "plugin-emojisdk_release"})
    public final class b extends a {
        final /* synthetic */ EmojiDebugUI exb;
        private final a.f.a.a<y> exc;
        private final String title;
        private final String value;

        public b(EmojiDebugUI emojiDebugUI, String str, String str2, a.f.a.a<y> aVar) {
            j.p(str, "title");
            j.p(str2, "value");
            this.exb = emojiDebugUI;
            super();
            AppMethodBeat.i(63116);
            this.title = str;
            this.value = str2;
            this.exc = aVar;
            AppMethodBeat.o(63116);
        }

        public final String Op() {
            return this.title;
        }

        public final String Oq() {
            return this.value;
        }

        public final void onClick() {
            AppMethodBeat.i(63115);
            a.f.a.a aVar = this.exc;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(63115);
                return;
            }
            AppMethodBeat.o(63115);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Landroid/widget/TextView;)V", "textView", "getTextView", "()Landroid/widget/TextView;", "plugin-emojisdk_release"})
    public final class e extends v {
        final /* synthetic */ EmojiDebugUI exb;
        final TextView exj;

        public e(EmojiDebugUI emojiDebugUI, TextView textView) {
            j.p(textView, "itemView");
            this.exb = emojiDebugUI;
            super(textView);
            AppMethodBeat.i(63125);
            this.exj = textView;
            AppMethodBeat.o(63125);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "onClick", "", "title", "", "value", "plugin-emojisdk_release"})
    public abstract class a {
        public abstract String Op();

        public abstract String Oq();

        public abstract void onClick();
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class g extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiDebugUI exb;

        g(EmojiDebugUI emojiDebugUI) {
            this.exb = emojiDebugUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63127);
            com.tencent.mm.m.g.Nu().put("ForbiddenEmotionSpringFestivalMsgTail", "1");
            com.tencent.mm.ui.base.t.makeText(this.exb, "微信重启后，会恢复后台配置", 0).show();
            y yVar = y.AUy;
            AppMethodBeat.o(63127);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class h extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiDebugUI exb;

        h(EmojiDebugUI emojiDebugUI) {
            this.exb = emojiDebugUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63128);
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, Boolean.FALSE);
            com.tencent.mm.ui.base.t.makeText(this.exb, "done", 0).show();
            y yVar = y.AUy;
            AppMethodBeat.o(63128);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class i extends k implements a.f.a.a<y> {
        final /* synthetic */ EmojiDebugUI exb;

        i(EmojiDebugUI emojiDebugUI) {
            this.exb = emojiDebugUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(63129);
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_CAPTURE_TAB_SPRING_FESTIVAL_DOT_BOOLEAN, Boolean.FALSE);
            com.tencent.mm.ui.base.t.makeText(this.exb, "done", 0).show();
            y yVar = y.AUy;
            AppMethodBeat.o(63129);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class f implements OnMenuItemClickListener {
        final /* synthetic */ EmojiDebugUI exb;

        f(EmojiDebugUI emojiDebugUI) {
            this.exb = emojiDebugUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(63126);
            this.exb.finish();
            AppMethodBeat.o(63126);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiDebugUI() {
        AppMethodBeat.i(63131);
        AppMethodBeat.o(63131);
    }

    public final int getLayoutId() {
        return R.layout.tr;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(63130);
        super.onCreate(bundle);
        setBackBtn(new f(this));
        this.exa = (RecyclerView) findViewById(R.id.bdn);
        RecyclerView recyclerView = this.exa;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager());
        }
        recyclerView = this.exa;
        if (recyclerView != null) {
            recyclerView.setAdapter(new d());
        }
        RecyclerView recyclerView2 = this.exa;
        if (recyclerView2 != null) {
            recyclerView2.b((android.support.v7.widget.RecyclerView.h) new z(this));
        }
        RecyclerView recyclerView3 = this.exa;
        if (recyclerView3 != null) {
            android.support.v7.widget.RecyclerView.a adapter = recyclerView3.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        LinkedList linkedList = this.ewZ;
        com.tencent.mm.storage.ac.a aVar = com.tencent.mm.storage.ac.a.USERINFO_EMOJI_SPRING_FESTIVAL_CROP_TYPE_INT;
        List listOf = a.a.l.listOf("GPU", "CPU");
        List listOf2 = a.a.l.listOf(Integer.valueOf(1), Integer.valueOf(0));
        linkedList.add(new c(this, "预览裁剪方式", aVar, listOf, listOf2));
        this.ewZ.add(new b(this, "临时屏蔽小尾巴", "", new g(this)));
        this.ewZ.add(new b(this, "重置自拍更新红点", "", new h(this)));
        this.ewZ.add(new b(this, "重置春节红点", "", new i(this)));
        AppMethodBeat.o(63130);
    }

    public static final /* synthetic */ Object a(com.tencent.mm.storage.ac.a aVar, Object obj) {
        AppMethodBeat.i(63132);
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        j.o(RP, "MMKernel.storage()");
        Object obj2 = RP.Ry().get(aVar, obj);
        AppMethodBeat.o(63132);
        return obj2;
    }

    public static final /* synthetic */ void b(com.tencent.mm.storage.ac.a aVar, Object obj) {
        AppMethodBeat.i(63133);
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        j.o(RP, "MMKernel.storage()");
        RP.Ry().set(aVar, obj);
        AppMethodBeat.o(63133);
    }
}
