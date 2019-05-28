package com.tencent.p177mm.plugin.account.model;

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
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.platformtools.C32887h;
import com.tencent.p177mm.plugin.account.friend.p272a.C32956ab;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C9877al;
import com.tencent.p177mm.plugin.account.p765a.p766a.C45491b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
/* renamed from: com.tencent.mm.plugin.account.model.ContactsSyncService */
public class ContactsSyncService extends Service implements C1202f {
    private static Account ggY;
    private C6732a gyE = null;
    private Looper gyF;

    /* renamed from: com.tencent.mm.plugin.account.model.ContactsSyncService$1 */
    class C67311 implements C45491b {
        C67311() {
        }

        /* renamed from: cN */
        public final void mo14963cN(boolean z) {
            AppMethodBeat.m2504i(124661);
            C4990ab.m7417i("MicroMsg.ContactsSyncService", "performSync end, succ:%b", Boolean.valueOf(z));
            if (z) {
                C1720g.m3540Rg().mo14539a((int) C19394e.CTRL_INDEX, ContactsSyncService.this);
                System.currentTimeMillis();
                C38033l.apX();
                C1720g.m3540Rg().mo14541a(new C9877al(C38033l.aqb(), C38033l.aqa()), 0);
                AppMethodBeat.m2505o(124661);
                return;
            }
            ContactsSyncService.m11161a(ContactsSyncService.this);
            AppMethodBeat.m2505o(124661);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.model.ContactsSyncService$a */
    class C6732a extends AbstractThreadedSyncAdapter {
        private Context mContext;

        public C6732a(Context context) {
            super(context, true);
            AppMethodBeat.m2504i(124662);
            this.mContext = context;
            C4990ab.m7416i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
            AppMethodBeat.m2505o(124662);
        }

        public final void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            AppMethodBeat.m2504i(124663);
            C4990ab.m7416i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
            if (C1720g.m3531RK()) {
                try {
                    Looper.prepare();
                    ContactsSyncService.this.gyF = Looper.myLooper();
                    ContactsSyncService.m11162a(ContactsSyncService.this, account);
                    Looper.loop();
                    AppMethodBeat.m2505o(124663);
                    return;
                } catch (Exception e) {
                    ContactsSyncService.m11161a(ContactsSyncService.this);
                    C4990ab.m7412e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + e.getMessage());
                    AppMethodBeat.m2505o(124663);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
            AppMethodBeat.m2505o(124663);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m11161a(ContactsSyncService contactsSyncService) {
        AppMethodBeat.m2504i(124670);
        contactsSyncService.aqB();
        AppMethodBeat.m2505o(124670);
    }

    public ContactsSyncService() {
        AppMethodBeat.m2504i(124664);
        C4990ab.m7416i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
        AppMethodBeat.m2505o(124664);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(124665);
        IBinder iBinder = null;
        if (C35805b.m58714o(this, "android.permission.READ_CONTACTS")) {
            if (this.gyE == null) {
                this.gyE = new C6732a(getApplicationContext());
            }
            iBinder = this.gyE.getSyncAdapterBinder();
        } else {
            C4990ab.m7416i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
        }
        C4990ab.m7417i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", iBinder);
        AppMethodBeat.m2505o(124665);
        return iBinder;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124666);
        C4990ab.m7416i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + c1207m.getType());
        if (c1207m.getType() == C19394e.CTRL_INDEX) {
            C1720g.m3540Rg().mo14546b((int) C19394e.CTRL_INDEX, (C1202f) this);
            C4990ab.m7416i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + i + ", errCode = " + i2);
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(327728, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7410d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + currentTimeMillis + ", lastTime=" + longValue);
            if (i2 == 0 || currentTimeMillis - longValue >= 86400000) {
                C1720g.m3536RP().mo5239Ry().set(327728, Long.valueOf(currentTimeMillis));
                C1720g.m3540Rg().mo14539a(32, (C1202f) this);
                C9877al c9877al = (C9877al) c1207m;
                C1720g.m3540Rg().mo14541a(new C32956ab(c9877al.gwp, c9877al.gwq), 0);
            } else {
                aqB();
                C4990ab.m7412e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
                AppMethodBeat.m2505o(124666);
                return;
            }
        }
        if (c1207m.getType() == 32) {
            C1720g.m3540Rg().mo14546b(32, (C1202f) this);
            C4990ab.m7416i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + i + ", errCode = " + i2);
            if (i == 0 && i2 == 0) {
                C7305d.m12301h(new C32887h(this, ggY), "MMAccountManager_updateLocalContacts").start();
            }
            aqB();
        }
        AppMethodBeat.m2505o(124666);
    }

    private void aqB() {
        AppMethodBeat.m2504i(124667);
        if (this.gyF != null) {
            this.gyF.quit();
        }
        AppMethodBeat.m2505o(124667);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(124668);
        C4990ab.m7416i("MicroMsg.ContactsSyncService", "contacts sync service destroy");
        super.onDestroy();
        AppMethodBeat.m2505o(124668);
    }
}
