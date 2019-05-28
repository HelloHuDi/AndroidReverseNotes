package com.tencent.mm.plugin.story.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@a.l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0005\u001a\u001b\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0014R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"})
public final class StorySettingsUI extends MMActivity {
    private static final String TAG = TAG;
    public static final d sfb = new d();
    private com.tencent.mm.remoteservice.d ext = new com.tencent.mm.remoteservice.d(ah.getContext());
    private ListView gKd;
    private final LinkedList<e> oDp = new LinkedList();
    private a seY;
    private StoryCaptureProxy seZ;
    private com.tencent.mm.ui.base.p sfa;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"})
    public final class b implements e {
        private String oDt;
        private String[] oDu;
        com.tencent.mm.storage.ac.a oDw;
        final /* synthetic */ StorySettingsUI sfc;
        Object sff;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
        static final class a implements com.tencent.mm.ui.base.h.d {
            final /* synthetic */ b sfg;

            a(b bVar) {
                this.sfg = bVar;
            }

            public final void bV(int i, int i2) {
                AppMethodBeat.i(110044);
                try {
                    Object obj = this.sfg.sff;
                    StoryCaptureProxy a;
                    com.tencent.mm.storage.ac.a aVar;
                    a.v vVar;
                    if (obj instanceof long[]) {
                        a = this.sfg.sfc.seZ;
                        if (a == null) {
                            a.f.b.j.dWJ();
                        }
                        aVar = this.sfg.oDw;
                        obj = this.sfg.sff;
                        if (obj == null) {
                            vVar = new a.v("null cannot be cast to non-null type kotlin.LongArray");
                            AppMethodBeat.o(110044);
                            throw vVar;
                        }
                        a.set(aVar, Long.valueOf(((long[]) obj)[i]));
                    } else if (obj instanceof int[]) {
                        a = this.sfg.sfc.seZ;
                        if (a == null) {
                            a.f.b.j.dWJ();
                        }
                        aVar = this.sfg.oDw;
                        obj = this.sfg.sff;
                        if (obj == null) {
                            vVar = new a.v("null cannot be cast to non-null type kotlin.IntArray");
                            AppMethodBeat.o(110044);
                            throw vVar;
                        }
                        a.set(aVar, Integer.valueOf(((int[]) obj)[i]));
                    }
                    StorySettingsUI.b(this.sfg.sfc).notifyDataSetChanged();
                    AppMethodBeat.o(110044);
                } catch (Exception e) {
                    d dVar = StorySettingsUI.sfb;
                    ab.printErrStackTrace(StorySettingsUI.TAG, e, "", new Object[0]);
                    AppMethodBeat.o(110044);
                }
            }
        }

        public b(StorySettingsUI storySettingsUI, String str, com.tencent.mm.storage.ac.a aVar, String[] strArr, Object obj) {
            a.f.b.j.p(str, "_showtitle");
            a.f.b.j.p(aVar, "_key");
            a.f.b.j.p(strArr, "_items");
            a.f.b.j.p(obj, "_vals");
            this.sfc = storySettingsUI;
            AppMethodBeat.i(110048);
            this.oDt = str;
            this.oDw = aVar;
            this.oDu = strArr;
            this.sff = obj;
            AppMethodBeat.o(110048);
        }

        public final String Op() {
            return this.oDt;
        }

        public final void eh(View view) {
            AppMethodBeat.i(110046);
            a.f.b.j.p(view, "view");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            int length = this.oDu.length;
            for (int i = 0; i < length; i++) {
                linkedList.add(this.oDu[i]);
                linkedList2.add(Integer.valueOf(i));
            }
            com.tencent.mm.ui.base.h.a((Context) this.sfc, "", (List) linkedList, (List) linkedList2, "", (com.tencent.mm.ui.base.h.d) new a(this));
            AppMethodBeat.o(110046);
        }

        private final String cr(Object obj) {
            AppMethodBeat.i(110047);
            Object obj2 = this.sff;
            a.v vVar;
            int length;
            int i;
            String str;
            if (obj2 instanceof long[]) {
                if (obj == null) {
                    vVar = new a.v("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.o(110047);
                    throw vVar;
                }
                long longValue = ((Long) obj).longValue();
                obj2 = this.sff;
                if (obj2 == null) {
                    vVar = new a.v("null cannot be cast to non-null type kotlin.LongArray");
                    AppMethodBeat.o(110047);
                    throw vVar;
                }
                length = ((long[]) obj2).length;
                i = 0;
                while (i < length) {
                    obj2 = this.sff;
                    if (obj2 == null) {
                        vVar = new a.v("null cannot be cast to non-null type kotlin.LongArray");
                        AppMethodBeat.o(110047);
                        throw vVar;
                    } else if (longValue != ((long[]) obj2)[i] || i >= this.oDu.length) {
                        i++;
                    } else {
                        str = this.oDu[i];
                        AppMethodBeat.o(110047);
                        return str;
                    }
                }
                str = this.oDu[0];
                AppMethodBeat.o(110047);
                return str;
            } else if (!(obj2 instanceof int[])) {
                str = "";
                AppMethodBeat.o(110047);
                return str;
            } else if (obj == null) {
                vVar = new a.v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(110047);
                throw vVar;
            } else {
                length = ((Integer) obj).intValue();
                obj2 = this.sff;
                if (obj2 == null) {
                    vVar = new a.v("null cannot be cast to non-null type kotlin.IntArray");
                    AppMethodBeat.o(110047);
                    throw vVar;
                }
                int length2 = ((int[]) obj2).length;
                i = 0;
                while (i < length2) {
                    obj2 = this.sff;
                    if (obj2 == null) {
                        vVar = new a.v("null cannot be cast to non-null type kotlin.IntArray");
                        AppMethodBeat.o(110047);
                        throw vVar;
                    } else if (length != ((int[]) obj2)[i] || i >= this.oDu.length) {
                        i++;
                    } else {
                        str = this.oDu[i];
                        AppMethodBeat.o(110047);
                        return str;
                    }
                }
                str = this.oDu[0];
                AppMethodBeat.o(110047);
                return str;
            }
        }

        public final String Oq() {
            AppMethodBeat.i(110045);
            StoryCaptureProxy a;
            String cr;
            if (this.sff instanceof long[]) {
                a = this.sfc.seZ;
                if (a == null) {
                    a.f.b.j.dWJ();
                }
                cr = cr(a.get(this.oDw, Long.valueOf(0)));
                AppMethodBeat.o(110045);
                return cr;
            }
            a = this.sfc.seZ;
            if (a == null) {
                a.f.b.j.dWJ();
            }
            cr = cr(a.get(this.oDw, Integer.valueOf(0)));
            AppMethodBeat.o(110045);
            return cr;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ClickItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "getValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-story_release"})
    public static final class c implements e {
        private final OnClickListener sfh;
        private final String title;
        private final String value;

        public c(String str, String str2, OnClickListener onClickListener) {
            a.f.b.j.p(str, "title");
            a.f.b.j.p(str2, "value");
            a.f.b.j.p(onClickListener, "clickEvent");
            AppMethodBeat.i(110050);
            this.title = str;
            this.value = str2;
            this.sfh = onClickListener;
            AppMethodBeat.o(110050);
        }

        public final void eh(View view) {
            AppMethodBeat.i(110049);
            a.f.b.j.p(view, "view");
            this.sfh.onClick(view);
            com.tencent.mm.ui.base.t.makeText(ah.getContext(), "ClickItem Done", 1).show();
            AppMethodBeat.o(110049);
        }

        public final String Op() {
            return this.title;
        }

        public final String Oq() {
            return this.value;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-story_release"})
    public interface e {
        String Op();

        String Oq();

        void eh(View view);
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class k implements OnClickListener {
        public static final k sfj = new k();

        static {
            AppMethodBeat.i(110058);
            AppMethodBeat.o(110058);
        }

        k() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110057);
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            AppMethodBeat.o(110057);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class s implements OnClickListener {

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.a<a.y> {
            public static final a sfl = new a();

            static {
                AppMethodBeat.i(110068);
                AppMethodBeat.o(110068);
            }

            a() {
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110067);
                com.tencent.mm.plugin.story.model.f.a.rWL.init();
                a.y yVar = a.y.AUy;
                AppMethodBeat.o(110067);
                return yVar;
            }
        }

        s() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110069);
            com.tencent.mm.plugin.story.model.f.a aVar = com.tencent.mm.plugin.story.model.f.a.rWL;
            com.tencent.mm.plugin.story.model.f.a.czg();
            com.tencent.mm.ab.b.a(5000, (a.f.a.a) a.sfl);
            AppMethodBeat.o(110069);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class t implements OnClickListener {
        t() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110070);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.rSS = 0;
            com.tencent.mm.plugin.story.model.h hVar = new com.tencent.mm.plugin.story.model.h();
            com.tencent.mm.plugin.story.model.h.cxH();
            com.tencent.mm.plugin.story.model.f.a.rWL.init();
            AppMethodBeat.o(110070);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class u implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        u(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110071);
            com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
            com.tencent.mm.ui.base.h.J(this.sfc.dxU(), com.tencent.mm.plugin.story.model.l.cym(), "嗯");
            AppMethodBeat.o(110071);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class v implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        v(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110072);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.vfs.e.cu(com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath());
            com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "ok", "嗯");
            AppMethodBeat.o(110072);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements OnClickListener {
        public static final j sfi = new j();

        static {
            AppMethodBeat.i(110056);
            AppMethodBeat.o(110056);
        }

        j() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110055);
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_BUBBLE_COUNT_INT, Integer.valueOf(0));
            AppMethodBeat.o(110055);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements OnClickListener {
        public static final l sfk = new l();

        static {
            AppMethodBeat.i(110060);
            AppMethodBeat.o(110060);
        }

        l() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110059);
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_MORE_TAB_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            AppMethodBeat.o(110059);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        m(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110061);
            aq.ruz = 1;
            com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "已调整到套图下载，即刻生效！", "");
            AppMethodBeat.o(110061);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0017¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
    public final class a extends BaseAdapter {

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements OnClickListener {
            final /* synthetic */ e sfd;
            final /* synthetic */ TextView sfe;

            a(e eVar, TextView textView) {
                this.sfd = eVar;
                this.sfe = textView;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(110040);
                this.sfd.eh(this.sfe);
                AppMethodBeat.o(110040);
            }
        }

        public final int getCount() {
            AppMethodBeat.i(110041);
            int size = StorySettingsUI.this.oDp.size();
            AppMethodBeat.o(110041);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(110042);
            Object obj = StorySettingsUI.this.oDp.get(i);
            a.f.b.j.o(obj, "selectsList[position]");
            AppMethodBeat.o(110042);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        @SuppressLint({"SetTextI18n"})
        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(110043);
            a.f.b.j.p(viewGroup, "parent");
            TextView textView = new TextView(StorySettingsUI.this);
            Object item = getItem(i);
            if (item == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StorySettingsUI.ITestMenu");
                AppMethodBeat.o(110043);
                throw vVar;
            }
            e eVar = (e) item;
            textView.setText(eVar.Op() + "->:" + eVar.Oq());
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50));
            if (i % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new a(eVar, textView));
            View view2 = textView;
            AppMethodBeat.o(110043);
            return view2;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class f implements OnClickListener {
        f() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110051);
            com.tencent.mm.plugin.story.model.h hVar = new com.tencent.mm.plugin.story.model.h();
            com.tencent.mm.plugin.story.model.h.cxI();
            AppMethodBeat.o(110051);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class g implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        g(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110052);
            ae.gjA = !ae.gjA;
            com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "ok value Test Fail:" + ae.gjA, "嗯");
            AppMethodBeat.o(110052);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        i(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110054);
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "在群视频，不要上滑，静候5秒", "");
            AppMethodBeat.o(110054);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class p implements OnClickListener {
        p() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110064);
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_WHATS_NEW_BOOLEAN_SYNC, Boolean.TRUE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_TO_AUTOPLAY_BOOLEAN_SYNC, Boolean.TRUE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_BUBBLE_COUNT_INT, Integer.valueOf(0));
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_MORE_TAB_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_FIRST_PULL_DOWN_BOOLEAN_SYNC, Boolean.TRUE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_COUNT_INT, Integer.valueOf(0));
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, Boolean.TRUE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_EDITOR_SHOW_PRIVACY_TIP_BOOLEAN_SYNC, Boolean.TRUE);
            RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_EDITOR_SHOW_FAV_TIP_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.ui.base.t.makeText(ah.getContext(), "好了", 1).show();
            AppMethodBeat.o(110064);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class r implements OnClickListener {
        r() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110066);
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxX().cqH();
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxV().cqH();
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cxT().cqH();
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.vfs.e.cu(com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath());
            AppMethodBeat.o(110066);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class y implements OnMenuItemClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        y(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(110078);
            this.sfc.finish();
            AppMethodBeat.o(110078);
            return false;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class n implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        n(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110062);
            aq.ruz = 2;
            com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "已调整到单图下载，即刻生效！", "");
            AppMethodBeat.o(110062);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class o implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        o(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            int i = 0;
            AppMethodBeat.i(110063);
            switch (aq.ruz) {
                case 1:
                    com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "套图下载", "");
                    AppMethodBeat.o(110063);
                    return;
                case 2:
                    com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "单图下载", "");
                    AppMethodBeat.o(110063);
                    return;
                default:
                    boolean snsImagePrivateProtocolAvalible = CdnLogic.getSnsImagePrivateProtocolAvalible();
                    if (1 == com.tencent.mm.m.g.Nu().getInt("SnsGroupImageDownloadSwitch", 0)) {
                        i = 1;
                    }
                    if ((!snsImagePrivateProtocolAvalible || i == 0) && !(((com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.DEBUG) && -1 == aq.ruz) || 1 == aq.ruA)) {
                        com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "单图下载", "");
                        AppMethodBeat.o(110063);
                        return;
                    }
                    com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "套图下载", "");
                    AppMethodBeat.o(110063);
                    return;
            }
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class w implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        static final class b extends a.f.b.k implements a.f.a.a<a.y> {
            final /* synthetic */ w sfm;

            @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$w$b$1 */
            static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<a.y> {
                final /* synthetic */ b sfn;

                AnonymousClass1(b bVar) {
                    this.sfn = bVar;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(110074);
                    com.tencent.mm.ui.base.p e = this.sfn.sfm.sfc.sfa;
                    if (e != null) {
                        e.dismiss();
                    }
                    com.tencent.mm.ui.base.h.J(this.sfn.sfm.sfc.dxU(), "ok", "嗯");
                    a.y yVar = a.y.AUy;
                    AppMethodBeat.o(110074);
                    return yVar;
                }
            }

            b(w wVar) {
                this.sfm = wVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110075);
                com.tencent.mm.plugin.story.model.l lVar = com.tencent.mm.plugin.story.model.l.rTg;
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.plugin.story.model.l.aax(stringBuilder.append(com.tencent.mm.plugin.story.model.j.a.getAccStoryPath()).append("cpdirs").toString());
                stringBuilder = new StringBuilder();
                aVar = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.vfs.e.cu(stringBuilder.append(com.tencent.mm.plugin.story.model.j.a.getAccStoryPath()).append("cpdirs").toString());
                com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                String accStoryCachePath = com.tencent.mm.plugin.story.model.j.a.getAccStoryCachePath();
                StringBuilder stringBuilder2 = new StringBuilder();
                com.tencent.mm.plugin.story.model.j.a aVar3 = com.tencent.mm.plugin.story.model.j.rST;
                com.tencent.mm.vfs.e.is(accStoryCachePath, stringBuilder2.append(com.tencent.mm.plugin.story.model.j.a.getAccStoryPath()).append("/cpdirs").toString());
                com.tencent.mm.ab.b.a(new AnonymousClass1(this));
                a.y yVar = a.y.AUy;
                AppMethodBeat.o(110075);
                return yVar;
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        static final class a implements OnCancelListener {
            final /* synthetic */ w sfm;

            a(w wVar) {
                this.sfm = wVar;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(110073);
                this.sfm.sfc.finish();
                AppMethodBeat.o(110073);
            }
        }

        w(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110076);
            StorySettingsUI storySettingsUI = this.sfc;
            Context dxU = this.sfc.dxU();
            this.sfc.getString(R.string.tz);
            storySettingsUI.sfa = com.tencent.mm.ui.base.h.b(dxU, this.sfc.getString(R.string.un), true, (OnCancelListener) new a(this));
            com.tencent.mm.ab.b.a("cpfiles", (a.f.a.a) new b(this));
            AppMethodBeat.o(110076);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class x implements Runnable {
        final /* synthetic */ StorySettingsUI sfc;

        x(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void run() {
            AppMethodBeat.i(110077);
            d dVar = StorySettingsUI.sfb;
            ab.i(StorySettingsUI.TAG, "has connect");
            StorySettingsUI.d(this.sfc);
            AppMethodBeat.o(110077);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class h implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        h(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110053);
            ae.gjB = !ae.gjB;
            com.tencent.mm.ui.base.h.J(this.sfc.dxU(), "ok value Test Fail:" + ae.gjB, "嗯");
            AppMethodBeat.o(110053);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    public static final class q implements OnClickListener {
        q() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(110065);
            com.tencent.mm.plugin.story.model.h hVar = new com.tencent.mm.plugin.story.model.h();
            com.tencent.mm.plugin.story.model.h.cxG();
            AppMethodBeat.o(110065);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public StorySettingsUI() {
        AppMethodBeat.i(110083);
        AppMethodBeat.o(110083);
    }

    public static final /* synthetic */ a b(StorySettingsUI storySettingsUI) {
        AppMethodBeat.i(110085);
        a aVar = storySettingsUI.seY;
        if (aVar == null) {
            a.f.b.j.avw("adapter");
        }
        AppMethodBeat.o(110085);
        return aVar;
    }

    public final int getLayoutId() {
        return R.layout.az2;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(110079);
        super.onCreate(bundle);
        this.seZ = new StoryCaptureProxy(this.ext);
        this.ext.connect(new x(this));
        setBackBtn(new y(this));
        AppMethodBeat.o(110079);
    }

    public final void onDestroy() {
        AppMethodBeat.i(110080);
        super.onDestroy();
        this.ext.release();
        AppMethodBeat.o(110080);
    }

    public final void onResume() {
        AppMethodBeat.i(110081);
        super.onResume();
        AppMethodBeat.o(110081);
    }

    public final void onPause() {
        AppMethodBeat.i(110082);
        super.onPause();
        AppMethodBeat.o(110082);
    }

    static {
        AppMethodBeat.i(110084);
        AppMethodBeat.o(110084);
    }

    public static final /* synthetic */ void d(StorySettingsUI storySettingsUI) {
        long currentTimeMillis;
        AppMethodBeat.i(110086);
        StorySettingsUI storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new b(storySettingsUI2, "朋友圈入口", com.tencent.mm.storage.ac.a.USERINFO_STORY_SNS_HEADER_TYPE_INT, new String[]{"方案一", "方案二", "关闭", "使用后台动态配置"}, new int[]{1, 2, Downloads.MIN_WAIT_FOR_NETWORK, 0}));
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        long a = RP.Ry().a(com.tencent.mm.storage.ac.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, 0);
        if (a <= 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = a;
        }
        storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new b(storySettingsUI2, "朋友圈入口新动态时间重设", com.tencent.mm.storage.ac.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, new String[]{"1个小时前", "2个小时前", "4个小时前", "24个小时前"}, new long[]{currentTimeMillis - 3600000, currentTimeMillis - 7200000, currentTimeMillis - 14400000, currentTimeMillis - 86400000}));
        storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new b(storySettingsUI2, "合成方案", com.tencent.mm.storage.ac.a.USERINFO_TOP_STORY_REMUX_TYPE_INT, new String[]{"前台合成", "后台合成"}, new int[]{com.tencent.mm.plugin.story.c.a.f.a.FORWARD.value, com.tencent.mm.plugin.story.c.a.f.a.BACKGROUND.value}));
        storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new b(storySettingsUI2, "裁剪方案", com.tencent.mm.storage.ac.a.USERINFO_TOP_STORY_CROP_TYPE_INT, new String[]{"GPU裁剪", "CPU裁剪"}, new int[]{2, 1}));
        storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new b(storySettingsUI2, "编码方案", com.tencent.mm.storage.ac.a.USERINFO_TOP_STORY_ENCODER_TYPE_INT, new String[]{"MediaCodec", "x264"}, new int[]{2, 1}));
        storySettingsUI.oDp.add(new c("一天九张?", "点我", new f()));
        storySettingsUI.oDp.add(new c("新手指引", "点我", new p()));
        storySettingsUI.oDp.add(new c("清空表", "嗯", new q()));
        storySettingsUI.oDp.add(new c("不删除ext, 删除info/room/file", "嗯", new r()));
        storySettingsUI.oDp.add(new c("拉取数据", "嗯", new s()));
        storySettingsUI.oDp.add(new c("所有未读", "嗯", new t()));
        storySettingsUI.oDp.add(new c("查看Story缓存大小", "嗯", new u(storySettingsUI)));
        storySettingsUI.oDp.add(new c("清除Story缓存", "嗯", new v(storySettingsUI)));
        storySettingsUI.oDp.add(new c("同步cache到Sdcard", "嗯", new w(storySettingsUI)));
        storySettingsUI.oDp.add(new c("点我发送后台失败", "嗯 Test", new g(storySettingsUI)));
        storySettingsUI.oDp.add(new c("点我发送超时失败", "嗯 Test", new h(storySettingsUI)));
        storySettingsUI.oDp.add(new c("群视频上拉提示", "再看一下", new i(storySettingsUI)));
        storySettingsUI.oDp.add(new c("冒个泡提示", "再看一次", j.sfi));
        storySettingsUI.oDp.add(new c("首次拍摄", "", k.sfj));
        storySettingsUI.oDp.add(new c("轻触查看", "再来一次", l.sfk));
        storySettingsUI.oDp.add(new c("朋友圈缩略图下载", "进行套图下载", new m(storySettingsUI)));
        storySettingsUI.oDp.add(new c("朋友圈缩略图下载", "进行单图下载", new n(storySettingsUI)));
        storySettingsUI.oDp.add(new c("朋友圈缩略图下载", "目前状态", new o(storySettingsUI)));
        View findViewById = storySettingsUI.findViewById(R.id.eur);
        if (findViewById == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type android.widget.ListView");
            AppMethodBeat.o(110086);
            throw vVar;
        }
        storySettingsUI.gKd = (ListView) findViewById;
        storySettingsUI.seY = new a();
        ListView listView = storySettingsUI.gKd;
        if (listView == null) {
            a.f.b.j.dWJ();
        }
        a aVar = storySettingsUI.seY;
        if (aVar == null) {
            a.f.b.j.avw("adapter");
        }
        listView.setAdapter(aVar);
        AppMethodBeat.o(110086);
    }
}
