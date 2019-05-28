package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsMediaFactory {
    /* renamed from: a */
    private Context f4498a = null;
    /* renamed from: b */
    private C30947bi f4499b = null;
    /* renamed from: c */
    private DexLoader f4500c = null;

    public TbsMediaFactory(Context context) {
        AppMethodBeat.m2504i(64518);
        this.f4498a = context.getApplicationContext();
        m37416a();
        AppMethodBeat.m2505o(64518);
    }

    /* renamed from: a */
    private void m37416a() {
        AppMethodBeat.m2504i(64519);
        if (this.f4498a == null) {
            AppMethodBeat.m2505o(64519);
            return;
        }
        if (this.f4499b == null) {
            C5818o.m8863a(true).mo12196a(this.f4498a, false, false, null);
            this.f4499b = C5818o.m8863a(true).mo12195a();
            if (this.f4499b != null) {
                this.f4500c = this.f4499b.mo50067b();
            }
        }
        if (this.f4499b == null || this.f4500c == null) {
            RuntimeException runtimeException = new RuntimeException("tbs core dex(s) load failure !!!");
            AppMethodBeat.m2505o(64519);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(64519);
    }

    public TbsMediaPlayer createPlayer() {
        AppMethodBeat.m2504i(64520);
        if (this.f4499b == null || this.f4500c == null) {
            RuntimeException runtimeException = new RuntimeException("tbs core dex(s) did not loaded !!!");
            AppMethodBeat.m2505o(64520);
            throw runtimeException;
        }
        TbsMediaPlayer tbsMediaPlayer = new TbsMediaPlayer(new C30945ba(this.f4500c, this.f4498a));
        AppMethodBeat.m2505o(64520);
        return tbsMediaPlayer;
    }
}
