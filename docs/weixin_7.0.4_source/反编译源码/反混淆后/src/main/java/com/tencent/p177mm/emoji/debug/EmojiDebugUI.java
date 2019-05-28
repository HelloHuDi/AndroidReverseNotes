package com.tencent.p177mm.emoji.debug;

import android.content.Context;
import android.os.Bundle;
import android.support.p069v7.widget.C31899z;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J#\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\tH\u0002¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J#\u0010\u0014\u001a\u00020\u0011\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u0002H\tH\u0002¢\u0006\u0002\u0010\u0016R\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getConfig", "T", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defVal", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)Ljava/lang/Object;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setConfig", "value", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/lang/Object;)V", "AbsItem", "ClickItem", "ConfigItem", "DebugAdapter", "DebugViewHolder", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI */
public final class EmojiDebugUI extends MMActivity {
    private final LinkedList<C32499a> ewZ = new LinkedList();
    private RecyclerView exa;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ConfigItem;", "T", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "configKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "contentArray", "", "valueArray", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;Ljava/util/List;Ljava/util/List;)V", "getConfigKey", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "getContentArray", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getValueArray", "onClick", "", "value", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$c */
    public final class C1514c<T> extends C32499a {
        final /* synthetic */ EmojiDebugUI exb;
        final C5127a exd;
        private final List<String> exe;
        final List<T> exf;
        private final String title;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "T", "whichButton", "", "resultId", "onClick"})
        /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$c$a */
        static final class C1515a implements C30382d {
            final /* synthetic */ C1514c exg;

            C1515a(C1514c c1514c) {
                this.exg = c1514c;
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(63117);
                EmojiDebugUI.m63716b(this.exg.exd, this.exg.exf.get(i2));
                RecyclerView a = this.exg.exb.exa;
                if (a != null) {
                    C41523a adapter = a.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                        AppMethodBeat.m2505o(63117);
                        return;
                    }
                }
                AppMethodBeat.m2505o(63117);
            }
        }

        public C1514c(EmojiDebugUI emojiDebugUI, String str, C5127a c5127a, List<String> list, List<? extends T> list2) {
            C25052j.m39376p(str, "title");
            C25052j.m39376p(c5127a, "configKey");
            C25052j.m39376p(list, "contentArray");
            C25052j.m39376p(list2, "valueArray");
            this.exb = emojiDebugUI;
            super();
            AppMethodBeat.m2504i(63120);
            this.title = str;
            this.exd = c5127a;
            this.exe = list;
            this.exf = list2;
            AppMethodBeat.m2505o(63120);
        }

        /* renamed from: Op */
        public final String mo4972Op() {
            return this.title;
        }

        /* renamed from: Oq */
        public final String mo4973Oq() {
            AppMethodBeat.m2504i(63118);
            int indexOf = this.exf.indexOf(EmojiDebugUI.m63714a(this.exd, this.exf.get(0)));
            String str;
            if (indexOf < 0 || indexOf >= this.exe.size()) {
                str = (String) this.exe.get(0);
                AppMethodBeat.m2505o(63118);
                return str;
            }
            str = (String) this.exe.get(indexOf);
            AppMethodBeat.m2505o(63118);
            return str;
        }

        public final void onClick() {
            AppMethodBeat.m2504i(63119);
            LinkedList linkedList = new LinkedList();
            int size = this.exe.size();
            for (int i = 0; i < size; i++) {
                linkedList.add(Integer.valueOf(i));
            }
            C30379h.m48419a((Context) this.exb, "", this.exe, C25035t.m39352m(C7987l.m14174g(this.exe)), "", (C30382d) new C1515a(this));
            AppMethodBeat.m2505o(63119);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$d */
    public final class C1516d extends C41523a<C18194e> {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$d$a */
        static final class C1517a implements OnClickListener {
            final /* synthetic */ C1516d exh;
            final /* synthetic */ int exi;

            C1517a(C1516d c1516d, int i) {
                this.exh = c1516d;
                this.exi = i;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(63121);
                ((C32499a) EmojiDebugUI.this.ewZ.get(this.exi)).onClick();
                AppMethodBeat.m2505o(63121);
            }
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(63123);
            int size = EmojiDebugUI.this.ewZ.size();
            AppMethodBeat.m2505o(63123);
            return size;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0006\u001a\u00020\bH\u0016J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$ClickItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "Lcom/tencent/mm/emoji/debug/EmojiDebugUI;", "title", "", "value", "onClick", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTitle", "()Ljava/lang/String;", "getValue", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$b */
    public final class C9272b extends C32499a {
        final /* synthetic */ EmojiDebugUI exb;
        private final C31214a<C37091y> exc;
        private final String title;
        private final String value;

        public C9272b(EmojiDebugUI emojiDebugUI, String str, String str2, C31214a<C37091y> c31214a) {
            C25052j.m39376p(str, "title");
            C25052j.m39376p(str2, "value");
            this.exb = emojiDebugUI;
            super();
            AppMethodBeat.m2504i(63116);
            this.title = str;
            this.value = str2;
            this.exc = c31214a;
            AppMethodBeat.m2505o(63116);
        }

        /* renamed from: Op */
        public final String mo4972Op() {
            return this.title;
        }

        /* renamed from: Oq */
        public final String mo4973Oq() {
            return this.value;
        }

        public final void onClick() {
            AppMethodBeat.m2504i(63115);
            C31214a c31214a = this.exc;
            if (c31214a != null) {
                c31214a.invoke();
                AppMethodBeat.m2505o(63115);
                return;
            }
            AppMethodBeat.m2505o(63115);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$DebugViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/widget/TextView;", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;Landroid/widget/TextView;)V", "textView", "getTextView", "()Landroid/widget/TextView;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$e */
    public final class C18194e extends C41531v {
        final /* synthetic */ EmojiDebugUI exb;
        final TextView exj;

        public C18194e(EmojiDebugUI emojiDebugUI, TextView textView) {
            C25052j.m39376p(textView, "itemView");
            this.exb = emojiDebugUI;
            super(textView);
            AppMethodBeat.m2504i(63125);
            this.exj = textView;
            AppMethodBeat.m2505o(63125);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, dWq = {"Lcom/tencent/mm/emoji/debug/EmojiDebugUI$AbsItem;", "", "(Lcom/tencent/mm/emoji/debug/EmojiDebugUI;)V", "onClick", "", "title", "", "value", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$a */
    public abstract class C32499a {
        /* renamed from: Op */
        public abstract String mo4972Op();

        /* renamed from: Oq */
        public abstract String mo4973Oq();

        public abstract void onClick();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$g */
    static final class C32500g extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiDebugUI exb;

        C32500g(EmojiDebugUI emojiDebugUI) {
            this.exb = emojiDebugUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63127);
            C26373g.m41964Nu().put("ForbiddenEmotionSpringFestivalMsgTail", "1");
            C23639t.makeText(this.exb, "微信重启后，会恢复后台配置", 0).show();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63127);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$h */
    static final class C32501h extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiDebugUI exb;

        C32501h(EmojiDebugUI emojiDebugUI) {
            this.exb = emojiDebugUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63128);
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, Boolean.FALSE);
            C23639t.makeText(this.exb, "done", 0).show();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63128);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$i */
    static final class C32502i extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ EmojiDebugUI exb;

        C32502i(EmojiDebugUI emojiDebugUI) {
            this.exb = emojiDebugUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(63129);
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_TAB_SPRING_FESTIVAL_DOT_BOOLEAN, Boolean.FALSE);
            C23639t.makeText(this.exb, "done", 0).show();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(63129);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.emoji.debug.EmojiDebugUI$f */
    static final class C37679f implements OnMenuItemClickListener {
        final /* synthetic */ EmojiDebugUI exb;

        C37679f(EmojiDebugUI emojiDebugUI) {
            this.exb = emojiDebugUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(63126);
            this.exb.finish();
            AppMethodBeat.m2505o(63126);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiDebugUI() {
        AppMethodBeat.m2504i(63131);
        AppMethodBeat.m2505o(63131);
    }

    public final int getLayoutId() {
        return 2130969335;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(63130);
        super.onCreate(bundle);
        setBackBtn(new C37679f(this));
        this.exa = (RecyclerView) findViewById(2131823454);
        RecyclerView recyclerView = this.exa;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager());
        }
        recyclerView = this.exa;
        if (recyclerView != null) {
            recyclerView.setAdapter(new C1516d());
        }
        RecyclerView recyclerView2 = this.exa;
        if (recyclerView2 != null) {
            recyclerView2.mo66346b((C25373h) new C31899z(this));
        }
        RecyclerView recyclerView3 = this.exa;
        if (recyclerView3 != null) {
            C41523a adapter = recyclerView3.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        LinkedList linkedList = this.ewZ;
        C5127a c5127a = C5127a.USERINFO_EMOJI_SPRING_FESTIVAL_CROP_TYPE_INT;
        List listOf = C7987l.listOf("GPU", "CPU");
        List listOf2 = C7987l.listOf(Integer.valueOf(1), Integer.valueOf(0));
        linkedList.add(new C1514c(this, "预览裁剪方式", c5127a, listOf, listOf2));
        this.ewZ.add(new C9272b(this, "临时屏蔽小尾巴", "", new C32500g(this)));
        this.ewZ.add(new C9272b(this, "重置自拍更新红点", "", new C32501h(this)));
        this.ewZ.add(new C9272b(this, "重置春节红点", "", new C32502i(this)));
        AppMethodBeat.m2505o(63130);
    }

    /* renamed from: a */
    public static final /* synthetic */ Object m63714a(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(63132);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        Object obj2 = RP.mo5239Ry().get(c5127a, obj);
        AppMethodBeat.m2505o(63132);
        return obj2;
    }

    /* renamed from: b */
    public static final /* synthetic */ void m63716b(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(63133);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        RP.mo5239Ry().set(c5127a, obj);
        AppMethodBeat.m2505o(63133);
    }
}
