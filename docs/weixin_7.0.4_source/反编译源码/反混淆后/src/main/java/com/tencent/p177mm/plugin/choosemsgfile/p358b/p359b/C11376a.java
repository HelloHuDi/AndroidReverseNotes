package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42886a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.a */
public abstract class C11376a<T extends C41531v> {
    /* renamed from: Lp */
    protected int f2899Lp;
    protected int alq;
    public C7620bi kua;
    C33817g kuj;
    protected int kuk = 0;

    public abstract int getType();

    public C11376a(C33817g c33817g) {
        this.kuj = c33817g;
    }

    public C11376a(C33817g c33817g, C7620bi c7620bi) {
        this.kuj = c33817g;
        this.kua = c7620bi;
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

    /* renamed from: dM */
    public final synchronized void mo23118dM(int i, int i2) {
        this.kuk = 2;
        this.f2899Lp = i;
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

    /* renamed from: kq */
    public final boolean mo23124kq() {
        return this.kuk == 4 || this.kuk == 5;
    }

    /* renamed from: a */
    public void mo6912a(T t, int i) {
    }

    /* renamed from: T */
    public void mo23108T(T t) {
    }

    /* renamed from: a */
    public void mo6913a(View view, C11376a c11376a) {
    }

    public String toString() {
        return "MsgItem{msgInfo=" + this.kua.field_msgId + '}';
    }

    public boolean equals(Object obj) {
        if (this.kua == null || !(obj instanceof C7620bi) || obj == null) {
            return super.equals(obj);
        }
        return this.kua.field_msgId == ((C7620bi) obj).field_msgId;
    }

    /* Access modifiers changed, original: protected|final */
    public final Context getContext() {
        return this.kuj.bfy().getContext();
    }

    /* Access modifiers changed, original: protected|final */
    public final C42886a bfn() {
        return this.kuj.bfy().bfn();
    }

    /* renamed from: a */
    public final void mo23109a(boolean z, C11376a c11376a, T t) {
        this.kuj.mo54371a(z, c11376a, t);
    }

    public final boolean isEnable() {
        return !this.kuj.bfy().bfn().mo68419kq() || this.kuj.bfy().bfn().mo68413gW(this.kua.field_msgId);
    }
}
