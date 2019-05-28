package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.Client;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class zzap extends zzat {
    private final /* synthetic */ zzaj zzhv;
    private final ArrayList<Client> zzib;

    public zzap(zzaj zzaj, ArrayList<Client> arrayList) {
        this.zzhv = zzaj;
        super(zzaj, null);
        this.zzib = arrayList;
    }

    public final void zzaq() {
        AppMethodBeat.m2504i(60755);
        this.zzhv.zzhf.zzfq.zzim = zzaj.zzg(this.zzhv);
        ArrayList arrayList = this.zzib;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Client) obj).getRemoteService(this.zzhv.zzhr, this.zzhv.zzhf.zzfq.zzim);
        }
        AppMethodBeat.m2505o(60755);
    }
}
