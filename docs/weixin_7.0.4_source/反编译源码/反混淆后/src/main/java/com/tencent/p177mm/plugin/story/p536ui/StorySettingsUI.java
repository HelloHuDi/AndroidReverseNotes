package com.tencent.p177mm.plugin.story.p536ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.sns.p520ui.C22067aq;
import com.tencent.p177mm.plugin.story.model.C29309l;
import com.tencent.p177mm.plugin.story.model.C39906h;
import com.tencent.p177mm.plugin.story.model.C43644j;
import com.tencent.p177mm.plugin.story.model.C43644j.C4133a;
import com.tencent.p177mm.plugin.story.model.p534f.C39895a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C39869f.C29278a;
import com.tencent.p177mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0005\u001a\u001b\u001c\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0014R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "mDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "proxy", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "getLayoutId", "", "initOnCreate", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "ChoiceAdapter", "ChoiceItem", "ClickItem", "Companion", "ITestMenu", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI */
public final class StorySettingsUI extends MMActivity {
    private static final String TAG = TAG;
    public static final C13810d sfb = new C13810d();
    private C46607d ext = new C46607d(C4996ah.getContext());
    private ListView gKd;
    private final LinkedList<C13811e> oDp = new LinkedList();
    private C35220a seY;
    private StoryCaptureProxy seZ;
    private C44275p sfa;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$b */
    public final class C4154b implements C13811e {
        private String oDt;
        private String[] oDu;
        C5127a oDw;
        final /* synthetic */ StorySettingsUI sfc;
        Object sff;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$b$a */
        static final class C4155a implements C30382d {
            final /* synthetic */ C4154b sfg;

            C4155a(C4154b c4154b) {
                this.sfg = c4154b;
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(110044);
                try {
                    Object obj = this.sfg.sff;
                    StoryCaptureProxy a;
                    C5127a c5127a;
                    C44941v c44941v;
                    if (obj instanceof long[]) {
                        a = this.sfg.sfc.seZ;
                        if (a == null) {
                            C25052j.dWJ();
                        }
                        c5127a = this.sfg.oDw;
                        obj = this.sfg.sff;
                        if (obj == null) {
                            c44941v = new C44941v("null cannot be cast to non-null type kotlin.LongArray");
                            AppMethodBeat.m2505o(110044);
                            throw c44941v;
                        }
                        a.set(c5127a, Long.valueOf(((long[]) obj)[i]));
                    } else if (obj instanceof int[]) {
                        a = this.sfg.sfc.seZ;
                        if (a == null) {
                            C25052j.dWJ();
                        }
                        c5127a = this.sfg.oDw;
                        obj = this.sfg.sff;
                        if (obj == null) {
                            c44941v = new C44941v("null cannot be cast to non-null type kotlin.IntArray");
                            AppMethodBeat.m2505o(110044);
                            throw c44941v;
                        }
                        a.set(c5127a, Integer.valueOf(((int[]) obj)[i]));
                    }
                    StorySettingsUI.m57835b(this.sfg.sfc).notifyDataSetChanged();
                    AppMethodBeat.m2505o(110044);
                } catch (Exception e) {
                    C13810d c13810d = StorySettingsUI.sfb;
                    C4990ab.printErrStackTrace(StorySettingsUI.TAG, e, "", new Object[0]);
                    AppMethodBeat.m2505o(110044);
                }
            }
        }

        public C4154b(StorySettingsUI storySettingsUI, String str, C5127a c5127a, String[] strArr, Object obj) {
            C25052j.m39376p(str, "_showtitle");
            C25052j.m39376p(c5127a, "_key");
            C25052j.m39376p(strArr, "_items");
            C25052j.m39376p(obj, "_vals");
            this.sfc = storySettingsUI;
            AppMethodBeat.m2504i(110048);
            this.oDt = str;
            this.oDw = c5127a;
            this.oDu = strArr;
            this.sff = obj;
            AppMethodBeat.m2505o(110048);
        }

        /* renamed from: Op */
        public final String mo9035Op() {
            return this.oDt;
        }

        /* renamed from: eh */
        public final void mo9037eh(View view) {
            AppMethodBeat.m2504i(110046);
            C25052j.m39376p(view, "view");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            int length = this.oDu.length;
            for (int i = 0; i < length; i++) {
                linkedList.add(this.oDu[i]);
                linkedList2.add(Integer.valueOf(i));
            }
            C30379h.m48419a((Context) this.sfc, "", (List) linkedList, (List) linkedList2, "", (C30382d) new C4155a(this));
            AppMethodBeat.m2505o(110046);
        }

        /* renamed from: cr */
        private final String m6482cr(Object obj) {
            AppMethodBeat.m2504i(110047);
            Object obj2 = this.sff;
            C44941v c44941v;
            int length;
            int i;
            String str;
            if (obj2 instanceof long[]) {
                if (obj == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.m2505o(110047);
                    throw c44941v;
                }
                long longValue = ((Long) obj).longValue();
                obj2 = this.sff;
                if (obj2 == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type kotlin.LongArray");
                    AppMethodBeat.m2505o(110047);
                    throw c44941v;
                }
                length = ((long[]) obj2).length;
                i = 0;
                while (i < length) {
                    obj2 = this.sff;
                    if (obj2 == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type kotlin.LongArray");
                        AppMethodBeat.m2505o(110047);
                        throw c44941v;
                    } else if (longValue != ((long[]) obj2)[i] || i >= this.oDu.length) {
                        i++;
                    } else {
                        str = this.oDu[i];
                        AppMethodBeat.m2505o(110047);
                        return str;
                    }
                }
                str = this.oDu[0];
                AppMethodBeat.m2505o(110047);
                return str;
            } else if (!(obj2 instanceof int[])) {
                str = "";
                AppMethodBeat.m2505o(110047);
                return str;
            } else if (obj == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.m2505o(110047);
                throw c44941v;
            } else {
                length = ((Integer) obj).intValue();
                obj2 = this.sff;
                if (obj2 == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type kotlin.IntArray");
                    AppMethodBeat.m2505o(110047);
                    throw c44941v;
                }
                int length2 = ((int[]) obj2).length;
                i = 0;
                while (i < length2) {
                    obj2 = this.sff;
                    if (obj2 == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type kotlin.IntArray");
                        AppMethodBeat.m2505o(110047);
                        throw c44941v;
                    } else if (length != ((int[]) obj2)[i] || i >= this.oDu.length) {
                        i++;
                    } else {
                        str = this.oDu[i];
                        AppMethodBeat.m2505o(110047);
                        return str;
                    }
                }
                str = this.oDu[0];
                AppMethodBeat.m2505o(110047);
                return str;
            }
        }

        /* renamed from: Oq */
        public final String mo9036Oq() {
            AppMethodBeat.m2504i(110045);
            StoryCaptureProxy a;
            String cr;
            if (this.sff instanceof long[]) {
                a = this.sfc.seZ;
                if (a == null) {
                    C25052j.dWJ();
                }
                cr = m6482cr(a.get(this.oDw, Long.valueOf(0)));
                AppMethodBeat.m2505o(110045);
                return cr;
            }
            a = this.sfc.seZ;
            if (a == null) {
                C25052j.dWJ();
            }
            cr = m6482cr(a.get(this.oDw, Integer.valueOf(0)));
            AppMethodBeat.m2505o(110045);
            return cr;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ClickItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "title", "", "value", "clickEvent", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getClickEvent", "()Landroid/view/View$OnClickListener;", "getTitle", "()Ljava/lang/String;", "getValue", "showAlert", "", "view", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$c */
    public static final class C4156c implements C13811e {
        private final OnClickListener sfh;
        private final String title;
        private final String value;

        public C4156c(String str, String str2, OnClickListener onClickListener) {
            C25052j.m39376p(str, "title");
            C25052j.m39376p(str2, "value");
            C25052j.m39376p(onClickListener, "clickEvent");
            AppMethodBeat.m2504i(110050);
            this.title = str;
            this.value = str2;
            this.sfh = onClickListener;
            AppMethodBeat.m2505o(110050);
        }

        /* renamed from: eh */
        public final void mo9037eh(View view) {
            AppMethodBeat.m2504i(110049);
            C25052j.m39376p(view, "view");
            this.sfh.onClick(view);
            C23639t.makeText(C4996ah.getContext(), "ClickItem Done", 1).show();
            AppMethodBeat.m2505o(110049);
        }

        /* renamed from: Op */
        public final String mo9035Op() {
            return this.title;
        }

        /* renamed from: Oq */
        public final String mo9036Oq() {
            return this.value;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$d */
    public static final class C13810d {
        private C13810d() {
        }

        public /* synthetic */ C13810d(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$e */
    public interface C13811e {
        /* renamed from: Op */
        String mo9035Op();

        /* renamed from: Oq */
        String mo9036Oq();

        /* renamed from: eh */
        void mo9037eh(View view);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$k */
    static final class C13812k implements OnClickListener {
        public static final C13812k sfj = new C13812k();

        static {
            AppMethodBeat.m2504i(110058);
            AppMethodBeat.m2505o(110058);
        }

        C13812k() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110057);
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            AppMethodBeat.m2505o(110057);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$5", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$s */
    public static final class C22251s implements OnClickListener {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$s$a */
        static final class C22250a extends C25053k implements C31214a<C37091y> {
            public static final C22250a sfl = new C22250a();

            static {
                AppMethodBeat.m2504i(110068);
                AppMethodBeat.m2505o(110068);
            }

            C22250a() {
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110067);
                C39895a.rWL.init();
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110067);
                return c37091y;
            }
        }

        C22251s() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110069);
            C39895a c39895a = C39895a.rWL;
            C39895a.czg();
            C8902b.m16041a(5000, (C31214a) C22250a.sfl);
            AppMethodBeat.m2505o(110069);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$6", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$t */
    public static final class C22252t implements OnClickListener {
        C22252t() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110070);
            C4133a c4133a = C43644j.rST;
            C43644j.rSS = 0;
            C39906h c39906h = new C39906h();
            C39906h.cxH();
            C39895a.rWL.init();
            AppMethodBeat.m2505o(110070);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$7", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$u */
    public static final class C22253u implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        C22253u(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110071);
            C29309l c29309l = C29309l.rTg;
            C30379h.m48417J(this.sfc.dxU(), C29309l.cym(), "嗯");
            AppMethodBeat.m2505o(110071);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$8", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$v */
    public static final class C22254v implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        C22254v(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110072);
            C4133a c4133a = C43644j.rST;
            C5730e.m8629cu(C4133a.getAccStoryCachePath());
            C30379h.m48417J(this.sfc.dxU(), "ok", "嗯");
            AppMethodBeat.m2505o(110072);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$j */
    static final class C29314j implements OnClickListener {
        public static final C29314j sfi = new C29314j();

        static {
            AppMethodBeat.m2504i(110056);
            AppMethodBeat.m2505o(110056);
        }

        C29314j() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110055);
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_BUBBLE_COUNT_INT, Integer.valueOf(0));
            AppMethodBeat.m2505o(110055);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$l */
    static final class C29315l implements OnClickListener {
        public static final C29315l sfk = new C29315l();

        static {
            AppMethodBeat.m2504i(110060);
            AppMethodBeat.m2505o(110060);
        }

        C29315l() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110059);
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_PULL_DOWN_MORE_TAB_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            AppMethodBeat.m2505o(110059);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$m */
    static final class C29316m implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        C29316m(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110061);
            C22067aq.ruz = 1;
            C30379h.m48417J(this.sfc.dxU(), "已调整到套图下载，即刻生效！", "");
            AppMethodBeat.m2505o(110061);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0017¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$a */
    public final class C35220a extends BaseAdapter {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$a$a */
        static final class C13809a implements OnClickListener {
            final /* synthetic */ C13811e sfd;
            final /* synthetic */ TextView sfe;

            C13809a(C13811e c13811e, TextView textView) {
                this.sfd = c13811e;
                this.sfe = textView;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(110040);
                this.sfd.mo9037eh(this.sfe);
                AppMethodBeat.m2505o(110040);
            }
        }

        public final int getCount() {
            AppMethodBeat.m2504i(110041);
            int size = StorySettingsUI.this.oDp.size();
            AppMethodBeat.m2505o(110041);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(110042);
            Object obj = StorySettingsUI.this.oDp.get(i);
            C25052j.m39375o(obj, "selectsList[position]");
            AppMethodBeat.m2505o(110042);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        @SuppressLint({"SetTextI18n"})
        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(110043);
            C25052j.m39376p(viewGroup, "parent");
            TextView textView = new TextView(StorySettingsUI.this);
            Object item = getItem(i);
            if (item == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StorySettingsUI.ITestMenu");
                AppMethodBeat.m2505o(110043);
                throw c44941v;
            }
            C13811e c13811e = (C13811e) item;
            textView.setText(c13811e.mo9035Op() + "->:" + c13811e.mo9036Oq());
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(C1338a.fromDPToPix(C4996ah.getContext(), 50));
            if (i % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new C13809a(c13811e, textView));
            View view2 = textView;
            AppMethodBeat.m2505o(110043);
            return view2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$f */
    public static final class C35221f implements OnClickListener {
        C35221f() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110051);
            C39906h c39906h = new C39906h();
            C39906h.cxI();
            AppMethodBeat.m2505o(110051);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$10", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$g */
    public static final class C35222g implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        C35222g(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110052);
            C1947ae.gjA = !C1947ae.gjA;
            C30379h.m48417J(this.sfc.dxU(), "ok value Test Fail:" + C1947ae.gjA, "嗯");
            AppMethodBeat.m2505o(110052);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$i */
    static final class C35223i implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        C35223i(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110054);
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            C30379h.m48417J(this.sfc.dxU(), "在群视频，不要上滑，静候5秒", "");
            AppMethodBeat.m2505o(110054);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$p */
    public static final class C35224p implements OnClickListener {
        C35224p() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110064);
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_WHATS_NEW_BOOLEAN_SYNC, Boolean.TRUE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_POST_FIRST_TO_AUTOPLAY_BOOLEAN_SYNC, Boolean.TRUE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_BUBBLE_COUNT_INT, Integer.valueOf(0));
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_PULL_DOWN_MORE_TAB_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_FIRST_PULL_DOWN_BOOLEAN_SYNC, Boolean.TRUE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_PULL_DOWN_COUNT_INT, Integer.valueOf(0));
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, Boolean.TRUE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_EDITOR_SHOW_PRIVACY_TIP_BOOLEAN_SYNC, Boolean.TRUE);
            RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            RP.mo5239Ry().set(C5127a.USERINFO_STORY_EDITOR_SHOW_FAV_TIP_BOOLEAN_SYNC, Boolean.TRUE);
            C23639t.makeText(C4996ah.getContext(), "好了", 1).show();
            AppMethodBeat.m2505o(110064);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$r */
    public static final class C35225r implements OnClickListener {
        C35225r() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110066);
            C4133a c4133a = C43644j.rST;
            C4133a.cxX().cqH();
            c4133a = C43644j.rST;
            C4133a.cxV().cqH();
            c4133a = C43644j.rST;
            C4133a.cxT().cqH();
            c4133a = C43644j.rST;
            C5730e.m8629cu(C4133a.getAccStoryCachePath());
            AppMethodBeat.m2505o(110066);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$y */
    static final class C35226y implements OnMenuItemClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        C35226y(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(110078);
            this.sfc.finish();
            AppMethodBeat.m2505o(110078);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$n */
    static final class C35227n implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        C35227n(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110062);
            C22067aq.ruz = 2;
            C30379h.m48417J(this.sfc.dxU(), "已调整到单图下载，即刻生效！", "");
            AppMethodBeat.m2505o(110062);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$o */
    static final class C35228o implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        C35228o(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            int i = 0;
            AppMethodBeat.m2504i(110063);
            switch (C22067aq.ruz) {
                case 1:
                    C30379h.m48417J(this.sfc.dxU(), "套图下载", "");
                    AppMethodBeat.m2505o(110063);
                    return;
                case 2:
                    C30379h.m48417J(this.sfc.dxU(), "单图下载", "");
                    AppMethodBeat.m2505o(110063);
                    return;
                default:
                    boolean snsImagePrivateProtocolAvalible = CdnLogic.getSnsImagePrivateProtocolAvalible();
                    if (1 == C26373g.m41964Nu().getInt("SnsGroupImageDownloadSwitch", 0)) {
                        i = 1;
                    }
                    if ((!snsImagePrivateProtocolAvalible || i == 0) && !(((C5058f.IS_FLAVOR_RED || C5058f.DEBUG) && -1 == C22067aq.ruz) || 1 == C22067aq.ruA)) {
                        C30379h.m48417J(this.sfc.dxU(), "单图下载", "");
                        AppMethodBeat.m2505o(110063);
                        return;
                    }
                    C30379h.m48417J(this.sfc.dxU(), "套图下载", "");
                    AppMethodBeat.m2505o(110063);
                    return;
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$9", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$w */
    public static final class C35229w implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$w$b */
        static final class C4157b extends C25053k implements C31214a<C37091y> {
            final /* synthetic */ C35229w sfm;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$w$b$1 */
            static final class C41581 extends C25053k implements C31214a<C37091y> {
                final /* synthetic */ C4157b sfn;

                C41581(C4157b c4157b) {
                    this.sfn = c4157b;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(110074);
                    C44275p e = this.sfn.sfm.sfc.sfa;
                    if (e != null) {
                        e.dismiss();
                    }
                    C30379h.m48417J(this.sfn.sfm.sfc.dxU(), "ok", "嗯");
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(110074);
                    return c37091y;
                }
            }

            C4157b(C35229w c35229w) {
                this.sfm = c35229w;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(110075);
                C29309l c29309l = C29309l.rTg;
                StringBuilder stringBuilder = new StringBuilder();
                C4133a c4133a = C43644j.rST;
                C29309l.aax(stringBuilder.append(C4133a.getAccStoryPath()).append("cpdirs").toString());
                stringBuilder = new StringBuilder();
                c4133a = C43644j.rST;
                C5730e.m8629cu(stringBuilder.append(C4133a.getAccStoryPath()).append("cpdirs").toString());
                C4133a c4133a2 = C43644j.rST;
                String accStoryCachePath = C4133a.getAccStoryCachePath();
                StringBuilder stringBuilder2 = new StringBuilder();
                C4133a c4133a3 = C43644j.rST;
                C5730e.m8634is(accStoryCachePath, stringBuilder2.append(C4133a.getAccStoryPath()).append("/cpdirs").toString());
                C8902b.m16042a(new C41581(this));
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110075);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$w$a */
        static final class C13813a implements OnCancelListener {
            final /* synthetic */ C35229w sfm;

            C13813a(C35229w c35229w) {
                this.sfm = c35229w;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(110073);
                this.sfm.sfc.finish();
                AppMethodBeat.m2505o(110073);
            }
        }

        C35229w(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110076);
            StorySettingsUI storySettingsUI = this.sfc;
            Context dxU = this.sfc.dxU();
            this.sfc.getString(C25738R.string.f9238tz);
            storySettingsUI.sfa = C30379h.m48458b(dxU, this.sfc.getString(C25738R.string.f9260un), true, (OnCancelListener) new C13813a(this));
            C8902b.m16044a("cpfiles", (C31214a) new C4157b(this));
            AppMethodBeat.m2505o(110076);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$x */
    static final class C35230x implements Runnable {
        final /* synthetic */ StorySettingsUI sfc;

        C35230x(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(110077);
            C13810d c13810d = StorySettingsUI.sfb;
            C4990ab.m7416i(StorySettingsUI.TAG, "has connect");
            StorySettingsUI.m57837d(this.sfc);
            AppMethodBeat.m2505o(110077);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$11", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$h */
    public static final class C35231h implements OnClickListener {
        final /* synthetic */ StorySettingsUI sfc;

        C35231h(StorySettingsUI storySettingsUI) {
            this.sfc = storySettingsUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110053);
            C1947ae.gjB = !C1947ae.gjB;
            C30379h.m48417J(this.sfc.dxU(), "ok value Test Fail:" + C1947ae.gjB, "嗯");
            AppMethodBeat.m2505o(110053);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StorySettingsUI$initOnCreate$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StorySettingsUI$q */
    public static final class C35232q implements OnClickListener {
        C35232q() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110065);
            C39906h c39906h = new C39906h();
            C39906h.cxG();
            AppMethodBeat.m2505o(110065);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public StorySettingsUI() {
        AppMethodBeat.m2504i(110083);
        AppMethodBeat.m2505o(110083);
    }

    /* renamed from: b */
    public static final /* synthetic */ C35220a m57835b(StorySettingsUI storySettingsUI) {
        AppMethodBeat.m2504i(110085);
        C35220a c35220a = storySettingsUI.seY;
        if (c35220a == null) {
            C25052j.avw("adapter");
        }
        AppMethodBeat.m2505o(110085);
        return c35220a;
    }

    public final int getLayoutId() {
        return 2130970902;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(110079);
        super.onCreate(bundle);
        this.seZ = new StoryCaptureProxy(this.ext);
        this.ext.connect(new C35230x(this));
        setBackBtn(new C35226y(this));
        AppMethodBeat.m2505o(110079);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(110080);
        super.onDestroy();
        this.ext.release();
        AppMethodBeat.m2505o(110080);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(110081);
        super.onResume();
        AppMethodBeat.m2505o(110081);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(110082);
        super.onPause();
        AppMethodBeat.m2505o(110082);
    }

    static {
        AppMethodBeat.m2504i(110084);
        AppMethodBeat.m2505o(110084);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m57837d(StorySettingsUI storySettingsUI) {
        long currentTimeMillis;
        AppMethodBeat.m2504i(110086);
        StorySettingsUI storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new C4154b(storySettingsUI2, "朋友圈入口", C5127a.USERINFO_STORY_SNS_HEADER_TYPE_INT, new String[]{"方案一", "方案二", "关闭", "使用后台动态配置"}, new int[]{1, 2, Downloads.MIN_WAIT_FOR_NETWORK, 0}));
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        long a = RP.mo5239Ry().mo16814a(C5127a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, 0);
        if (a <= 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = a;
        }
        storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new C4154b(storySettingsUI2, "朋友圈入口新动态时间重设", C5127a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, new String[]{"1个小时前", "2个小时前", "4个小时前", "24个小时前"}, new long[]{currentTimeMillis - 3600000, currentTimeMillis - 7200000, currentTimeMillis - 14400000, currentTimeMillis - 86400000}));
        storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new C4154b(storySettingsUI2, "合成方案", C5127a.USERINFO_TOP_STORY_REMUX_TYPE_INT, new String[]{"前台合成", "后台合成"}, new int[]{C29278a.FORWARD.value, C29278a.BACKGROUND.value}));
        storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new C4154b(storySettingsUI2, "裁剪方案", C5127a.USERINFO_TOP_STORY_CROP_TYPE_INT, new String[]{"GPU裁剪", "CPU裁剪"}, new int[]{2, 1}));
        storySettingsUI2 = storySettingsUI;
        storySettingsUI.oDp.add(new C4154b(storySettingsUI2, "编码方案", C5127a.USERINFO_TOP_STORY_ENCODER_TYPE_INT, new String[]{"MediaCodec", "x264"}, new int[]{2, 1}));
        storySettingsUI.oDp.add(new C4156c("一天九张?", "点我", new C35221f()));
        storySettingsUI.oDp.add(new C4156c("新手指引", "点我", new C35224p()));
        storySettingsUI.oDp.add(new C4156c("清空表", "嗯", new C35232q()));
        storySettingsUI.oDp.add(new C4156c("不删除ext, 删除info/room/file", "嗯", new C35225r()));
        storySettingsUI.oDp.add(new C4156c("拉取数据", "嗯", new C22251s()));
        storySettingsUI.oDp.add(new C4156c("所有未读", "嗯", new C22252t()));
        storySettingsUI.oDp.add(new C4156c("查看Story缓存大小", "嗯", new C22253u(storySettingsUI)));
        storySettingsUI.oDp.add(new C4156c("清除Story缓存", "嗯", new C22254v(storySettingsUI)));
        storySettingsUI.oDp.add(new C4156c("同步cache到Sdcard", "嗯", new C35229w(storySettingsUI)));
        storySettingsUI.oDp.add(new C4156c("点我发送后台失败", "嗯 Test", new C35222g(storySettingsUI)));
        storySettingsUI.oDp.add(new C4156c("点我发送超时失败", "嗯 Test", new C35231h(storySettingsUI)));
        storySettingsUI.oDp.add(new C4156c("群视频上拉提示", "再看一下", new C35223i(storySettingsUI)));
        storySettingsUI.oDp.add(new C4156c("冒个泡提示", "再看一次", C29314j.sfi));
        storySettingsUI.oDp.add(new C4156c("首次拍摄", "", C13812k.sfj));
        storySettingsUI.oDp.add(new C4156c("轻触查看", "再来一次", C29315l.sfk));
        storySettingsUI.oDp.add(new C4156c("朋友圈缩略图下载", "进行套图下载", new C29316m(storySettingsUI)));
        storySettingsUI.oDp.add(new C4156c("朋友圈缩略图下载", "进行单图下载", new C35227n(storySettingsUI)));
        storySettingsUI.oDp.add(new C4156c("朋友圈缩略图下载", "目前状态", new C35228o(storySettingsUI)));
        View findViewById = storySettingsUI.findViewById(2131828193);
        if (findViewById == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.widget.ListView");
            AppMethodBeat.m2505o(110086);
            throw c44941v;
        }
        storySettingsUI.gKd = (ListView) findViewById;
        storySettingsUI.seY = new C35220a();
        ListView listView = storySettingsUI.gKd;
        if (listView == null) {
            C25052j.dWJ();
        }
        C35220a c35220a = storySettingsUI.seY;
        if (c35220a == null) {
            C25052j.avw("adapter");
        }
        listView.setAdapter(c35220a);
        AppMethodBeat.m2505o(110086);
    }
}
