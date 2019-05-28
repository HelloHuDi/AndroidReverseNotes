package com.tencent.p177mm.emoji.loader;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.p1190d.C18202a;
import com.tencent.p177mm.emoji.loader.p1190d.C18205b;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h.C18208a;
import com.tencent.p177mm.emoji.loader.p1190d.C26080i;
import com.tencent.p177mm.emoji.loader.p1190d.C26080i.C26079a;
import com.tencent.p177mm.emoji.loader.p1190d.C37684e;
import com.tencent.p177mm.emoji.loader.p1190d.C41957d;
import com.tencent.p177mm.emoji.loader.p1190d.C41959g;
import com.tencent.p177mm.emoji.loader.p849e.C37685c;
import com.tencent.p177mm.emoji.loader.p849e.C41209e;
import com.tencent.p177mm.emoji.loader.p849e.C41960b;
import com.tencent.p177mm.emoji.loader.p849e.C9276a;
import com.tencent.p177mm.emoji.view.BaseEmojiView;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.ChattingEmojiView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u001e\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, dWq = {"Lcom/tencent/mm/emoji/loader/EmojiLoader;", "", "()V", "TAG", "", "taskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lkotlin/collections/HashMap;", "addTask", "", "key", "task", "buildCoverTask", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "buildTask", "cancel", "view", "Landroid/view/View;", "load", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiView", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "loadCover", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Landroid/widget/ImageView;", "loadFile", "Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "loadForRemote", "Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "notifyTaskResult", "md5", "success", "", "removeTask", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.a */
public final class C37682a {
    private static final String TAG = TAG;
    private static final HashMap<String, C37685c> exr = new HashMap();
    public static final C37682a exs = new C37682a();

    static {
        AppMethodBeat.m2504i(63161);
        AppMethodBeat.m2505o(63161);
    }

    private C37682a() {
    }

    /* renamed from: a */
    public static C37685c m63724a(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63150);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C37685c c37685c = (C37685c) exr.get(emojiInfo.mo20410Aq());
        if (c37685c == null) {
            C1681g Rn = C1720g.m3533RM().mo5224Rn();
            C25052j.m39375o(Rn, "MMKernel.process().current()");
            if (((C6624h) Rn).mo5181SG()) {
                c37685c = new C41960b(emojiInfo);
            } else {
                c37685c = new C41209e(emojiInfo);
            }
        }
        AppMethodBeat.m2505o(63150);
        return c37685c;
    }

    /* renamed from: b */
    public static C37685c m63726b(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63151);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C37685c c37685c = (C37685c) exr.get(emojiInfo.mo20410Aq() + "_cover");
        if (c37685c == null) {
            c37685c = new C9276a(emojiInfo);
        }
        AppMethodBeat.m2505o(63151);
        return c37685c;
    }

    /* renamed from: a */
    public static C37684e m63723a(EmojiInfo emojiInfo, BaseEmojiView baseEmojiView, C18208a c18208a) {
        AppMethodBeat.m2504i(63152);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(baseEmojiView, "emojiView");
        C4990ab.m7410d(TAG, "load emoji " + emojiInfo.mo20410Aq());
        C37684e c37684e = new C37684e(emojiInfo, baseEmojiView, c18208a);
        c37684e.start();
        AppMethodBeat.m2505o(63152);
        return c37684e;
    }

    /* renamed from: a */
    public static C18202a m63720a(EmojiInfo emojiInfo, ChattingEmojiView chattingEmojiView, String str) {
        AppMethodBeat.m2504i(63153);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(chattingEmojiView, "emojiView");
        C25052j.m39376p(str, "cacheKey");
        C4990ab.m7410d(TAG, "load emoji " + emojiInfo.mo20410Aq());
        C18202a c18202a = new C18202a(emojiInfo, chattingEmojiView, str);
        c18202a.start();
        AppMethodBeat.m2505o(63153);
        return c18202a;
    }

    /* renamed from: a */
    public static C41957d m63722a(EmojiInfo emojiInfo, C18208a c18208a) {
        AppMethodBeat.m2504i(63154);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C41957d c41957d = new C41957d(emojiInfo, c18208a);
        c41957d.start();
        AppMethodBeat.m2505o(63154);
        return c41957d;
    }

    /* renamed from: a */
    public static C18205b m63721a(EmojiInfo emojiInfo, ImageView imageView) {
        AppMethodBeat.m2504i(63155);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(imageView, "view");
        C18205b c18205b = new C18205b(emojiInfo, imageView);
        c18205b.start();
        AppMethodBeat.m2505o(63155);
        return c18205b;
    }

    /* renamed from: c */
    public static C41959g m63727c(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(63156);
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C41959g c41959g = new C41959g(emojiInfo);
        c41959g.start();
        AppMethodBeat.m2505o(63156);
        return c41959g;
    }

    /* renamed from: q */
    public static void m63730q(String str, boolean z) {
        AppMethodBeat.m2504i(63157);
        C25052j.m39376p(str, "md5");
        C37685c c37685c = (C37685c) exr.get(str);
        if (c37685c != null) {
            c37685c.mo20716bV(z);
            AppMethodBeat.m2505o(63157);
            return;
        }
        AppMethodBeat.m2505o(63157);
    }

    /* renamed from: cf */
    public static void m63728cf(View view) {
        AppMethodBeat.m2504i(63158);
        C25052j.m39376p(view, "view");
        C4990ab.m7416i(TAG, "cancel: ".concat(String.valueOf(view)));
        C26079a c26079a = C26080i.eyk;
        C18207h c18207h = (C18207h) view.getTag(C26080i.eyj);
        if (c18207h != null) {
            c18207h.cancel();
            AppMethodBeat.m2505o(63158);
            return;
        }
        AppMethodBeat.m2505o(63158);
    }

    /* renamed from: a */
    public static void m63725a(String str, C37685c c37685c) {
        AppMethodBeat.m2504i(63159);
        C25052j.m39376p(str, "key");
        C25052j.m39376p(c37685c, "task");
        exr.put(str, c37685c);
        AppMethodBeat.m2505o(63159);
    }

    /* renamed from: kP */
    public static void m63729kP(String str) {
        AppMethodBeat.m2504i(63160);
        C25052j.m39376p(str, "key");
        exr.remove(str);
        AppMethodBeat.m2505o(63160);
    }
}
