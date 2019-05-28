package com.tencent.p177mm.emoji.loader.p849e;

import com.facebook.share.internal.ShareConstants;
import com.tencent.p177mm.emoji.loader.C37682a;
import com.tencent.p177mm.emoji.loader.p1190d.C18207h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\tJ\b\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\tJ\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006RB\u0010\u0007\u001a6\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \n*\b\u0012\u0002\b\u0003\u0018\u00010\t0\t \n*\u001a\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \n*\b\u0012\u0002\b\u0003\u0018\u00010\t0\t\u0018\u00010\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "running", "", "started", "addRequest", "", "request", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.e.c */
public abstract class C37685c implements Runnable {
    final EmojiInfo exP;
    private final List<C18207h<?>> requests = Collections.synchronizedList(new LinkedList());
    private boolean running;
    private boolean started;

    /* renamed from: OA */
    public abstract String mo20715OA();

    public C37685c(EmojiInfo emojiInfo) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        this.exP = emojiInfo;
    }

    public final void start() {
        if (!this.started) {
            this.started = true;
            C37682a c37682a = C37682a.exs;
            C37682a.m63725a(mo20715OA(), this);
            C7305d.xDG.execute(this);
        }
    }

    public void run() {
        this.running = true;
    }

    /* renamed from: a */
    public final void mo60502a(C18207h<?> c18207h) {
        C25052j.m39376p(c18207h, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (!this.requests.contains(c18207h)) {
            this.requests.add(c18207h);
        }
    }

    /* renamed from: b */
    public final void mo60503b(C18207h<?> c18207h) {
        C25052j.m39376p(c18207h, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        this.requests.remove(c18207h);
        if (this.requests.size() == 0) {
            C4990ab.m7416i(C45308d.TAG, "cancel " + mo20715OA() + ", " + this.running);
            if (!this.running) {
                C7305d.xDG.remove((Runnable) this);
                mo20716bV(false);
            }
        }
    }

    /* renamed from: bV */
    public void mo20716bV(boolean z) {
        C37682a c37682a = C37682a.exs;
        C37682a.m63729kP(mo20715OA());
        LinkedList<C18207h> linkedList = new LinkedList();
        List list = this.requests;
        C25052j.m39375o(list, "requests");
        synchronized (list) {
            linkedList.addAll(this.requests);
            this.requests.clear();
            C37091y c37091y = C37091y.AUy;
        }
        for (C18207h bX : linkedList) {
            bX.mo33677bX(z);
        }
    }
}
