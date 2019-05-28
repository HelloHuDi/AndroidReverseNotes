package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class a extends h {
    public boolean qVI;
    private boolean qVJ = true;
    public boolean qVK;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(36937);
            if ("com.tencent.mm.adlanding.close_exposure_voice".equals(intent.getAction()) && !a.this.cpv().qWO.equals(intent.getStringExtra("para_id"))) {
                a aVar = a.this;
                if (aVar.qVK) {
                    aVar.coY();
                }
            }
            AppMethodBeat.o(36937);
        }
    };

    public a(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
        d.S(this.context).a(this.receiver, new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice"));
        ab.v("AbsVideoPlayComp", "register receiver " + this.receiver);
    }

    public void coY() {
        this.qVI = false;
    }

    public void coZ() {
        super.coZ();
        d.S(this.context).unregisterReceiver(this.receiver);
        this.qVK = true;
        ab.v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
    }

    public void cpa() {
        super.cpa();
        this.qVK = true;
    }

    public void cpb() {
        super.cpb();
        this.qVK = false;
    }

    public void cpc() {
        super.cpc();
        if (this.qVJ) {
            this.qVJ = false;
            if (cpC().qXq) {
                cpd();
            } else {
                coY();
            }
        }
    }

    public void cpd() {
        this.qVI = true;
    }

    public final void cpe() {
        Intent intent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
        intent.putExtra("para_id", cpv().qWO);
        d.S(this.context).c(intent);
    }
}
