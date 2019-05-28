package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p057v4.content.C37116d;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C13437h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a */
public abstract class C29060a extends C13437h {
    public boolean qVI;
    private boolean qVJ = true;
    public boolean qVK;
    private BroadcastReceiver receiver = new C290611();

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a$1 */
    class C290611 extends BroadcastReceiver {
        C290611() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(36937);
            if ("com.tencent.mm.adlanding.close_exposure_voice".equals(intent.getAction()) && !C29060a.this.cpv().qWO.equals(intent.getStringExtra("para_id"))) {
                C29060a c29060a = C29060a.this;
                if (c29060a.qVK) {
                    c29060a.coY();
                }
            }
            AppMethodBeat.m2505o(36937);
        }
    }

    public C29060a(Context context, C29086r c29086r, ViewGroup viewGroup) {
        super(context, c29086r, viewGroup);
        C37116d.m62125S(this.context).mo59171a(this.receiver, new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice"));
        C4990ab.m7418v("AbsVideoPlayComp", "register receiver " + this.receiver);
    }

    public void coY() {
        this.qVI = false;
    }

    public void coZ() {
        super.coZ();
        C37116d.m62125S(this.context).unregisterReceiver(this.receiver);
        this.qVK = true;
        C4990ab.m7418v("AbsVideoPlayComp", "unregister receiver " + this.receiver);
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
        C37116d.m62125S(this.context).mo59172c(intent);
    }
}
