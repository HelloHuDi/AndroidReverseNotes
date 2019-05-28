package com.tencent.mm.loader.g.a;

import a.f.b.j;
import a.l;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u00060\fR\u00020\u00000\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
public final class a implements c {
    private final d<String, a> eQt;
    private final int eRr;
    private final int eRs;
    private final int retryCount;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"})
    public final class a {
        long eRt;
        int eRu;

        public a(long j, int i) {
            this.eRt = j;
            this.eRu = i;
        }
    }

    public a(int i) {
        this.retryCount = i;
        this.eRs = BaseClientBuilder.API_PRIORITY_OTHER;
        this.eRr = 100;
        this.eQt = new d(this.eRr);
    }

    public a() {
        this(5);
    }

    public final boolean b(c cVar) {
        j.p(cVar, "task");
        if (this.eQt.aj(cVar.Pc())) {
            long anT = bo.anT();
            a aVar = (a) this.eQt.ai(cVar.Pc());
            if (aVar.eRu < this.retryCount || anT - aVar.eRt >= ((long) this.eRs)) {
                if (anT - aVar.eRt > ((long) this.eRs)) {
                    ab.v("DefaultRetrySg", "reset: " + cVar.Pc());
                    aVar = new a(anT, 0);
                }
                aVar.eRu++;
                aVar.eRt = anT;
                this.eQt.put(cVar.Pc(), aVar);
            } else {
                ab.w("DefaultRetrySg", "check block by recentdown: " + cVar.Pc() + " count " + aVar.eRu + "  time: " + (anT - aVar.eRt));
                return false;
            }
        }
        this.eQt.put(cVar.Pc(), new a(bo.anT(), 1));
        return true;
    }
}
