package com.tencent.mm.emoji.loader;

import a.f.b.j;
import a.l;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.d;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e.b;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.emoji.loader.e.e;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u001e\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, dWq = {"Lcom/tencent/mm/emoji/loader/EmojiLoader;", "", "()V", "TAG", "", "taskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lkotlin/collections/HashMap;", "addTask", "", "key", "task", "buildCoverTask", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "buildTask", "cancel", "view", "Landroid/view/View;", "load", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiView", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "loadCover", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Landroid/widget/ImageView;", "loadFile", "Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "loadForRemote", "Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "notifyTaskResult", "md5", "success", "", "removeTask", "plugin-emojisdk_release"})
public final class a {
    private static final String TAG = TAG;
    private static final HashMap<String, c> exr = new HashMap();
    public static final a exs = new a();

    static {
        AppMethodBeat.i(63161);
        AppMethodBeat.o(63161);
    }

    private a() {
    }

    public static c a(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63150);
        j.p(emojiInfo, "emojiInfo");
        c cVar = (c) exr.get(emojiInfo.Aq());
        if (cVar == null) {
            g Rn = com.tencent.mm.kernel.g.RM().Rn();
            j.o(Rn, "MMKernel.process().current()");
            if (((h) Rn).SG()) {
                cVar = new b(emojiInfo);
            } else {
                cVar = new e(emojiInfo);
            }
        }
        AppMethodBeat.o(63150);
        return cVar;
    }

    public static c b(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63151);
        j.p(emojiInfo, "emojiInfo");
        c cVar = (c) exr.get(emojiInfo.Aq() + "_cover");
        if (cVar == null) {
            cVar = new com.tencent.mm.emoji.loader.e.a(emojiInfo);
        }
        AppMethodBeat.o(63151);
        return cVar;
    }

    public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo emojiInfo, BaseEmojiView baseEmojiView, com.tencent.mm.emoji.loader.d.h.a aVar) {
        AppMethodBeat.i(63152);
        j.p(emojiInfo, "emojiInfo");
        j.p(baseEmojiView, "emojiView");
        ab.d(TAG, "load emoji " + emojiInfo.Aq());
        com.tencent.mm.emoji.loader.d.e eVar = new com.tencent.mm.emoji.loader.d.e(emojiInfo, baseEmojiView, aVar);
        eVar.start();
        AppMethodBeat.o(63152);
        return eVar;
    }

    public static com.tencent.mm.emoji.loader.d.a a(EmojiInfo emojiInfo, ChattingEmojiView chattingEmojiView, String str) {
        AppMethodBeat.i(63153);
        j.p(emojiInfo, "emojiInfo");
        j.p(chattingEmojiView, "emojiView");
        j.p(str, "cacheKey");
        ab.d(TAG, "load emoji " + emojiInfo.Aq());
        com.tencent.mm.emoji.loader.d.a aVar = new com.tencent.mm.emoji.loader.d.a(emojiInfo, chattingEmojiView, str);
        aVar.start();
        AppMethodBeat.o(63153);
        return aVar;
    }

    public static d a(EmojiInfo emojiInfo, com.tencent.mm.emoji.loader.d.h.a aVar) {
        AppMethodBeat.i(63154);
        j.p(emojiInfo, "emojiInfo");
        d dVar = new d(emojiInfo, aVar);
        dVar.start();
        AppMethodBeat.o(63154);
        return dVar;
    }

    public static com.tencent.mm.emoji.loader.d.b a(EmojiInfo emojiInfo, ImageView imageView) {
        AppMethodBeat.i(63155);
        j.p(emojiInfo, "emojiInfo");
        j.p(imageView, "view");
        com.tencent.mm.emoji.loader.d.b bVar = new com.tencent.mm.emoji.loader.d.b(emojiInfo, imageView);
        bVar.start();
        AppMethodBeat.o(63155);
        return bVar;
    }

    public static com.tencent.mm.emoji.loader.d.g c(EmojiInfo emojiInfo) {
        AppMethodBeat.i(63156);
        j.p(emojiInfo, "emojiInfo");
        com.tencent.mm.emoji.loader.d.g gVar = new com.tencent.mm.emoji.loader.d.g(emojiInfo);
        gVar.start();
        AppMethodBeat.o(63156);
        return gVar;
    }

    public static void q(String str, boolean z) {
        AppMethodBeat.i(63157);
        j.p(str, "md5");
        c cVar = (c) exr.get(str);
        if (cVar != null) {
            cVar.bV(z);
            AppMethodBeat.o(63157);
            return;
        }
        AppMethodBeat.o(63157);
    }

    public static void cf(View view) {
        AppMethodBeat.i(63158);
        j.p(view, "view");
        ab.i(TAG, "cancel: ".concat(String.valueOf(view)));
        com.tencent.mm.emoji.loader.d.i.a aVar = i.eyk;
        com.tencent.mm.emoji.loader.d.h hVar = (com.tencent.mm.emoji.loader.d.h) view.getTag(i.eyj);
        if (hVar != null) {
            hVar.cancel();
            AppMethodBeat.o(63158);
            return;
        }
        AppMethodBeat.o(63158);
    }

    public static void a(String str, c cVar) {
        AppMethodBeat.i(63159);
        j.p(str, "key");
        j.p(cVar, "task");
        exr.put(str, cVar);
        AppMethodBeat.o(63159);
    }

    public static void kP(String str) {
        AppMethodBeat.i(63160);
        j.p(str, "key");
        exr.remove(str);
        AppMethodBeat.o(63160);
    }
}
