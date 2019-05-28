package com.tencent.mm.emoji.loader.e;

import a.f.b.j;
import a.l;
import a.y;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.emoji.loader.a;
import com.tencent.mm.emoji.loader.d.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\tJ\b\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\tJ\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006RB\u0010\u0007\u001a6\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \n*\b\u0012\u0002\b\u0003\u0018\u00010\t0\t \n*\u001a\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \n*\b\u0012\u0002\b\u0003\u0018\u00010\t0\t\u0018\u00010\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "running", "", "started", "addRequest", "", "request", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "plugin-emojisdk_release"})
public abstract class c implements Runnable {
    final EmojiInfo exP;
    private final List<h<?>> requests = Collections.synchronizedList(new LinkedList());
    private boolean running;
    private boolean started;

    public abstract String OA();

    public c(EmojiInfo emojiInfo) {
        j.p(emojiInfo, "emojiInfo");
        this.exP = emojiInfo;
    }

    public final void start() {
        if (!this.started) {
            this.started = true;
            a aVar = a.exs;
            a.a(OA(), this);
            d.xDG.execute(this);
        }
    }

    public void run() {
        this.running = true;
    }

    public final void a(h<?> hVar) {
        j.p(hVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (!this.requests.contains(hVar)) {
            this.requests.add(hVar);
        }
    }

    public final void b(h<?> hVar) {
        j.p(hVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        this.requests.remove(hVar);
        if (this.requests.size() == 0) {
            ab.i(d.TAG, "cancel " + OA() + ", " + this.running);
            if (!this.running) {
                d.xDG.remove((Runnable) this);
                bV(false);
            }
        }
    }

    public void bV(boolean z) {
        a aVar = a.exs;
        a.kP(OA());
        LinkedList<h> linkedList = new LinkedList();
        List list = this.requests;
        j.o(list, "requests");
        synchronized (list) {
            linkedList.addAll(this.requests);
            this.requests.clear();
            y yVar = y.AUy;
        }
        for (h bX : linkedList) {
            bX.bX(z);
        }
    }
}
