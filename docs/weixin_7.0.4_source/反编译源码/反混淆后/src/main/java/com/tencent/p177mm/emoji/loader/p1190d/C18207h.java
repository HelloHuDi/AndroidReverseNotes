package com.tencent.p177mm.emoji.loader.p1190d;

import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.loader.p849e.C37685c;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0014J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/Request;", "T", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "task", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "getTask", "()Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "setTask", "(Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;)V", "cancel", "", "createTask", "onLoad", "success", "", "reload", "start", "Callback", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.d.h */
public abstract class C18207h<T> {
    final EmojiInfo exP;
    private C37685c eyh;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "", "onResult", "", "success", "", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.loader.d.h$a */
    public interface C18208a {
        /* renamed from: bV */
        void mo33675bV(boolean z);
    }

    /* renamed from: bX */
    public abstract void mo33677bX(boolean z);

    public C18207h(EmojiInfo emojiInfo) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        this.exP = emojiInfo;
    }

    public void start() {
        reload();
    }

    /* Access modifiers changed, original: protected|final */
    public final void reload() {
        C37685c c37685c = this.eyh;
        if (c37685c != null) {
            c37685c.mo60503b(this);
        }
        this.eyh = mo33679Oy();
        c37685c = this.eyh;
        if (c37685c != null) {
            c37685c.mo60502a(this);
        }
        c37685c = this.eyh;
        if (c37685c != null) {
            c37685c.start();
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Oy */
    public C37685c mo33679Oy() {
        C37682a c37682a = C37682a.exs;
        return C37682a.m63724a(this.exP);
    }

    public void cancel() {
        C37685c c37685c = this.eyh;
        if (c37685c != null) {
            c37685c.mo60503b(this);
        }
    }
}
