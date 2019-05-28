package com.tencent.p177mm.loader.p864g.p1196a;

import com.tencent.p177mm.loader.p1641i.C45424a;
import com.tencent.p177mm.loader.p864g.C26364a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.TimeUnit;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eB5\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016R\u000e\u0010\u0010\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "lightWork", "Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;", "parallelTask", "", "name", "", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "retrySg", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "heavyWork", "ioWork", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "TAG", "createHeavyExecutor", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "createIoExecutor", "createLightExecutor", "retryStrategy", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.g.a.g */
public final class C18536g implements C37883d {
    private final String TAG;
    private final C45422c eRD;
    private final C18537h eRE;
    private final C18537h eRF;
    private final C18537h eRG;
    private final int eRH;
    private final String name;

    public C18536g(C45422c c45422c, C18537h c18537h, C18537h c18537h2, C18537h c18537h3, int i, String str) {
        C25052j.m39376p(c45422c, "retrySg");
        C25052j.m39376p(c18537h, "lightWork");
        C25052j.m39376p(c18537h2, "heavyWork");
        C25052j.m39376p(c18537h3, "ioWork");
        C25052j.m39376p(str, "name");
        this.eRD = c45422c;
        this.eRE = c18537h;
        this.eRF = c18537h2;
        this.eRG = c18537h3;
        this.eRH = i;
        this.name = str;
        this.TAG = "MicroMsg.Loader.TaskLoaderConfiguration";
    }

    public C18536g(C45422c c45422c, C18537h c18537h, String str) {
        C25052j.m39376p(c45422c, "retrySg");
        C25052j.m39376p(c18537h, "lightWork");
        C25052j.m39376p(str, "name");
        this(c45422c, c18537h, c18537h, c18537h, 1, str);
    }

    /* renamed from: TS */
    public final C26364a mo33789TS() {
        C4990ab.m7416i(this.TAG, "pool heavy poolSize " + this.eRF.eRI + " priority " + this.eRF.eRI + " name: " + this.name);
        return new C37882b(this.eRF.eRI, this.eRF.eRI, TimeUnit.MILLISECONDS, new C45424a(), new C18535f(this.eRF.priority, this.name));
    }

    /* renamed from: TR */
    public final C26364a mo33788TR() {
        C4990ab.m7416i(this.TAG, "pool light poolSize " + this.eRE.eRI + " priority " + this.eRE.eRI + " name: " + this.name);
        return new C37882b(this.eRE.eRI, this.eRE.eRI, TimeUnit.MILLISECONDS, new C45424a(), new C18535f(this.eRE.priority, this.name));
    }

    /* renamed from: TT */
    public final int mo33790TT() {
        return this.eRH;
    }

    public final String name() {
        return this.name;
    }

    /* renamed from: TU */
    public final C45422c mo33791TU() {
        return this.eRD;
    }
}
