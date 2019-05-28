package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.storage.bi;

public abstract class a<T extends v> {
    protected int Lp;
    protected int alq;
    public bi kua;
    g kuj;
    protected int kuk = 0;

    public abstract int getType();

    public a(g gVar) {
        this.kuj = gVar;
    }

    public a(g gVar, bi biVar) {
        this.kuj = gVar;
        this.kua = biVar;
    }

    public long getTimeStamp() {
        return this.kua.field_createTime;
    }

    public String bfo() {
        return "";
    }

    public String getFileName() {
        return "";
    }

    public int bfp() {
        return 0;
    }

    public final synchronized void bfq() {
        this.kuk = 1;
    }

    public final synchronized void bfr() {
        this.kuk = 3;
    }

    public final synchronized void dM(int i, int i2) {
        this.kuk = 2;
        this.Lp = i;
        this.alq = i2;
    }

    public final synchronized void bfs() {
        this.kuk = 4;
    }

    public final synchronized void bft() {
        this.kuk = 5;
    }

    public final synchronized void bfu() {
        this.kuk = 0;
    }

    public final boolean kq() {
        return this.kuk == 4 || this.kuk == 5;
    }

    public void a(T t, int i) {
    }

    public void T(T t) {
    }

    public void a(View view, a aVar) {
    }

    public String toString() {
        return "MsgItem{msgInfo=" + this.kua.field_msgId + '}';
    }

    public boolean equals(Object obj) {
        if (this.kua == null || !(obj instanceof bi) || obj == null) {
            return super.equals(obj);
        }
        return this.kua.field_msgId == ((bi) obj).field_msgId;
    }

    /* Access modifiers changed, original: protected|final */
    public final Context getContext() {
        return this.kuj.bfy().getContext();
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.choosemsgfile.b.d.a bfn() {
        return this.kuj.bfy().bfn();
    }

    public final void a(boolean z, a aVar, T t) {
        this.kuj.a(z, aVar, t);
    }

    public final boolean isEnable() {
        return !this.kuj.bfy().bfn().kq() || this.kuj.bfy().bfn().gW(this.kua.field_msgId);
    }
}
