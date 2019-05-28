package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

final class zzam extends zzat {
    final /* synthetic */ zzaj zzhv;
    private final Map<Client, zzal> zzhx;

    public zzam(zzaj zzaj, Map<Client, zzal> map) {
        this.zzhv = zzaj;
        super(zzaj, null);
        this.zzhx = map;
    }

    public final void zzaq() {
        int i = 0;
        AppMethodBeat.i(60752);
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(this.zzhv.zzgk);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Client client : this.zzhx.keySet()) {
            if (!client.requiresGooglePlayServices() || ((zzal) this.zzhx.get(client)).zzfo) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i2 = -1;
        ArrayList arrayList3;
        int i3;
        Object obj;
        if (!arrayList.isEmpty()) {
            arrayList3 = arrayList;
            int size = arrayList3.size();
            i3 = 0;
            while (i3 < size) {
                obj = arrayList3.get(i3);
                i3++;
                i2 = googleApiAvailabilityCache.getClientAvailability(this.zzhv.mContext, (Client) obj);
                if (i2 != 0) {
                    break;
                }
            }
        }
        arrayList3 = arrayList2;
        i3 = arrayList3.size();
        while (i < i3) {
            obj = arrayList3.get(i);
            i++;
            i2 = googleApiAvailabilityCache.getClientAvailability(this.zzhv.mContext, (Client) obj);
            if (i2 == 0) {
                break;
            }
        }
        int i4 = i2;
        if (i4 != 0) {
            this.zzhv.zzhf.zza(new zzan(this, this.zzhv, new ConnectionResult(i4, null)));
            AppMethodBeat.o(60752);
            return;
        }
        if (this.zzhv.zzhp) {
            this.zzhv.zzhn.connect();
        }
        for (Client client2 : this.zzhx.keySet()) {
            ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) this.zzhx.get(client2);
            if (!client2.requiresGooglePlayServices() || googleApiAvailabilityCache.getClientAvailability(this.zzhv.mContext, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                this.zzhv.zzhf.zza(new zzao(this, this.zzhv, connectionProgressReportCallbacks));
            }
        }
        AppMethodBeat.o(60752);
    }
}
