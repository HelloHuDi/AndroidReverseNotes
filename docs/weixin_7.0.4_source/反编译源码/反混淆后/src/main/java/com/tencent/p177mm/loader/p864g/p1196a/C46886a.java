package com.tencent.p177mm.loader.p864g.p1196a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.p177mm.loader.p1197h.C42160d;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u00060\fR\u00020\u00000\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.g.a.a */
public final class C46886a implements C45422c {
    private final C42160d<String, C26363a> eQt;
    private final int eRr;
    private final int eRs;
    private final int retryCount;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.g.a.a$a */
    public final class C26363a {
        long eRt;
        int eRu;

        public C26363a(long j, int i) {
            this.eRt = j;
            this.eRu = i;
        }
    }

    public C46886a(int i) {
        this.retryCount = i;
        this.eRs = BaseClientBuilder.API_PRIORITY_OTHER;
        this.eRr = 100;
        this.eQt = new C42160d(this.eRr);
    }

    public C46886a() {
        this(5);
    }

    /* renamed from: b */
    public final boolean mo73213b(C26365c c26365c) {
        C25052j.m39376p(c26365c, "task");
        if (this.eQt.mo67701aj(c26365c.mo9027Pc())) {
            long anT = C5046bo.anT();
            C26363a c26363a = (C26363a) this.eQt.mo67700ai(c26365c.mo9027Pc());
            if (c26363a.eRu < this.retryCount || anT - c26363a.eRt >= ((long) this.eRs)) {
                if (anT - c26363a.eRt > ((long) this.eRs)) {
                    C4990ab.m7418v("DefaultRetrySg", "reset: " + c26365c.mo9027Pc());
                    c26363a = new C26363a(anT, 0);
                }
                c26363a.eRu++;
                c26363a.eRt = anT;
                this.eQt.put(c26365c.mo9027Pc(), c26363a);
            } else {
                C4990ab.m7420w("DefaultRetrySg", "check block by recentdown: " + c26365c.mo9027Pc() + " count " + c26363a.eRu + "  time: " + (anT - c26363a.eRt));
                return false;
            }
        }
        this.eQt.put(c26365c.mo9027Pc(), new C26363a(C5046bo.anT(), 1));
        return true;
    }
}
