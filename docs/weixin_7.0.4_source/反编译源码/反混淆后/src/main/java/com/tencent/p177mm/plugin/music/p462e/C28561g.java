package com.tencent.p177mm.plugin.music.p462e;

import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.net.URL;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.music.e.g */
public abstract class C28561g implements C46096a {
    protected C46097c oLQ;
    protected C9058e oLR;

    public void init() {
    }

    /* renamed from: a */
    public final void mo46655a(C46097c c46097c) {
        this.oLQ = c46097c;
    }

    /* renamed from: g */
    public boolean mo46658g(C9058e c9058e) {
        this.oLR = c9058e;
        return true;
    }

    /* renamed from: h */
    public C9058e mo46659h(C9058e c9058e) {
        return c9058e;
    }

    /* renamed from: i */
    public C9058e mo46660i(C9058e c9058e) {
        return c9058e;
    }

    /* renamed from: m */
    public C9058e mo46665m(List<C9058e> list, int i) {
        if (list == null || list.size() == 0 || i >= list.size()) {
            C4990ab.m7416i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
            return null;
        }
        this.oLR = (C9058e) list.get(i);
        C4990ab.m7417i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", Integer.valueOf(i));
        return this.oLR;
    }

    /* renamed from: j */
    public void mo46662j(C9058e c9058e) {
        this.oLR = c9058e;
    }

    /* renamed from: d */
    public void mo46657d(List<C9058e> list, boolean z) {
    }

    public C9058e bTQ() {
        return this.oLR;
    }

    /* renamed from: zF */
    public boolean mo46669zF(int i) {
        return true;
    }

    /* renamed from: Th */
    public String mo46652Th(String str) {
        return str;
    }

    /* renamed from: Ti */
    public URL mo46653Ti(String str) {
        return new URL(str);
    }

    /* renamed from: k */
    public void mo46663k(C9058e c9058e) {
    }

    /* renamed from: l */
    public void mo46664l(C9058e c9058e) {
    }

    /* renamed from: m */
    public void mo46666m(C9058e c9058e) {
    }

    /* renamed from: n */
    public void mo46667n(C9058e c9058e) {
    }

    /* renamed from: o */
    public void mo46668o(C9058e c9058e) {
    }

    /* renamed from: a */
    public void mo46654a(C9058e c9058e, int i) {
    }
}
