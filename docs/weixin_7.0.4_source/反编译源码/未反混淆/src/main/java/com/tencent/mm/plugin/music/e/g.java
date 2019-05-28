package com.tencent.mm.plugin.music.e;

import com.tencent.mm.aw.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URL;
import java.util.List;

public abstract class g implements a {
    protected c oLQ;
    protected e oLR;

    public void init() {
    }

    public final void a(c cVar) {
        this.oLQ = cVar;
    }

    public boolean g(e eVar) {
        this.oLR = eVar;
        return true;
    }

    public e h(e eVar) {
        return eVar;
    }

    public e i(e eVar) {
        return eVar;
    }

    public e m(List<e> list, int i) {
        if (list == null || list.size() == 0 || i >= list.size()) {
            ab.i("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
            return null;
        }
        this.oLR = (e) list.get(i);
        ab.i("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", Integer.valueOf(i));
        return this.oLR;
    }

    public void j(e eVar) {
        this.oLR = eVar;
    }

    public void d(List<e> list, boolean z) {
    }

    public e bTQ() {
        return this.oLR;
    }

    public boolean zF(int i) {
        return true;
    }

    public String Th(String str) {
        return str;
    }

    public URL Ti(String str) {
        return new URL(str);
    }

    public void k(e eVar) {
    }

    public void l(e eVar) {
    }

    public void m(e eVar) {
    }

    public void n(e eVar) {
    }

    public void o(e eVar) {
    }

    public void a(e eVar, int i) {
    }
}
