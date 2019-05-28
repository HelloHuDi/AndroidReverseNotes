package com.tencent.mm.plugin.account.model;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class ContactsSyncService extends Service implements f {
    private static Account ggY;
    private a gyE = null;
    private Looper gyF;

    class a extends AbstractThreadedSyncAdapter {
        private Context mContext;

        public a(Context context) {
            super(context, true);
            AppMethodBeat.i(124662);
            this.mContext = context;
            ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
            AppMethodBeat.o(124662);
        }

        public final void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            AppMethodBeat.i(124663);
            ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
            if (g.RK()) {
                try {
                    Looper.prepare();
                    ContactsSyncService.this.gyF = Looper.myLooper();
                    ContactsSyncService.a(ContactsSyncService.this, account);
                    Looper.loop();
                    AppMethodBeat.o(124663);
                    return;
                } catch (Exception e) {
                    ContactsSyncService.a(ContactsSyncService.this);
                    ab.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + e.getMessage());
                    AppMethodBeat.o(124663);
                    return;
                }
            }
            ab.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
            AppMethodBeat.o(124663);
        }
    }

    static /* synthetic */ void a(ContactsSyncService contactsSyncService) {
        AppMethodBeat.i(124670);
        contactsSyncService.aqB();
        AppMethodBeat.o(124670);
    }

    public ContactsSyncService() {
        AppMethodBeat.i(124664);
        ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
        AppMethodBeat.o(124664);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(124665);
        IBinder iBinder = null;
        if (b.o(this, "android.permission.READ_CONTACTS")) {
            if (this.gyE == null) {
                this.gyE = new a(getApplicationContext());
            }
            iBinder = this.gyE.getSyncAdapterBinder();
        } else {
            ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
        }
        ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", iBinder);
        AppMethodBeat.o(124665);
        return iBinder;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(124666);
        ab.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + mVar.getType());
        if (mVar.getType() == e.CTRL_INDEX) {
            g.Rg().b((int) e.CTRL_INDEX, (f) this);
            ab.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + i + ", errCode = " + i2);
            long longValue = ((Long) g.RP().Ry().get(327728, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            ab.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + currentTimeMillis + ", lastTime=" + longValue);
            if (i2 == 0 || currentTimeMillis - longValue >= 86400000) {
                g.RP().Ry().set(327728, Long.valueOf(currentTimeMillis));
                g.Rg().a(32, (f) this);
                al alVar = (al) mVar;
                g.Rg().a(new com.tencent.mm.plugin.account.friend.a.ab(alVar.gwp, alVar.gwq), 0);
            } else {
                aqB();
                ab.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
                AppMethodBeat.o(124666);
                return;
            }
        }
        if (mVar.getType() == 32) {
            g.Rg().b(32, (f) this);
            ab.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + i + ", errCode = " + i2);
            if (i == 0 && i2 == 0) {
                d.h(new h(this, ggY), "MMAccountManager_updateLocalContacts").start();
            }
            aqB();
        }
        AppMethodBeat.o(124666);
    }

    private void aqB() {
        AppMethodBeat.i(124667);
        if (this.gyF != null) {
            this.gyF.quit();
        }
        AppMethodBeat.o(124667);
    }

    public void onDestroy() {
        AppMethodBeat.i(124668);
        ab.i("MicroMsg.ContactsSyncService", "contacts sync service destroy");
        super.onDestroy();
        AppMethodBeat.o(124668);
    }
}
