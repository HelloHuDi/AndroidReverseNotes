package com.tencent.mm.plugin.forcenotify.b;

import a.k.u;
import a.l;
import a.v;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.forcenotify.c.b;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyListUI;
import com.tencent.mm.plugin.forcenotify.ui.ForceNotifyShowUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0018H\u0016J,\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0007H\u0016J\u0012\u00102\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00103\u001a\u00020\u000fH\u0016J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u00104\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00105\u001a\u000206H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyTAG", "", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "delete", "", "username", "scene", "", "getCount", "getExpireTime", "", "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isNeedNotify", "isNeedShowBanner", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "notifyShow", "userName", "onModify", "info", "onOpLogResult", "ret", "title", "content", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceive", "isNeedShow", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"})
public final class c extends a implements a {
    private static boolean mtc;
    private static boolean mtd = true;
    private static boolean mte = true;
    public static final c mtf = new c();

    static {
        AppMethodBeat.i(51050);
        AppMethodBeat.o(51050);
    }

    private c() {
    }

    public final void hx(boolean z) {
        mtc = z;
    }

    public final j<?> bxV() {
        return com.tencent.mm.plugin.forcenotify.d.a.mth;
    }

    public static boolean isSilentMode(Context context) {
        AppMethodBeat.i(51036);
        a.f.b.j.p(context, "context");
        Object systemService = context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            v vVar = new v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(51036);
            throw vVar;
        } else if (((AudioManager) systemService).getRingerMode() != 2) {
            AppMethodBeat.o(51036);
            return true;
        } else {
            AppMethodBeat.o(51036);
            return false;
        }
    }

    public static boolean dT(Context context) {
        AppMethodBeat.i(51037);
        a.f.b.j.p(context, "context");
        Object systemService = context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            v vVar = new v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.o(51037);
            throw vVar;
        } else if (((AudioManager) systemService).getRingerMode() > 0) {
            AppMethodBeat.o(51037);
            return true;
        } else {
            AppMethodBeat.o(51037);
            return false;
        }
    }

    public final void start() {
        AppMethodBeat.i(51038);
        super.start();
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.j) K).bOl().a(213, this);
        K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.j) K).bOl().a(214, this);
        AppMethodBeat.o(51038);
    }

    public final void release() {
        AppMethodBeat.i(51039);
        super.release();
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.j) K).bOl().b(213, this);
        K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.j) K).bOl().b(214, this);
        AppMethodBeat.o(51039);
    }

    public static ArrayList<b> bxW() {
        AppMethodBeat.i(51040);
        com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
        ArrayList bxY = com.tencent.mm.plugin.forcenotify.d.a.bxY();
        AppMethodBeat.o(51040);
        return bxY;
    }

    public final long Mo(String str) {
        AppMethodBeat.i(51041);
        a.f.b.j.p(str, "username");
        com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
        a.f.b.j.p(str, "userName");
        b bVar = new b();
        bVar.field_UserName = str;
        if (aVar.b((com.tencent.mm.sdk.e.c) bVar, new String[0])) {
            long j = bVar.field_ExpiredTime;
            AppMethodBeat.o(51041);
            return j;
        }
        AppMethodBeat.o(51041);
        return 0;
    }

    public final void Mn(String str) {
        AppMethodBeat.i(51042);
        if (str == null) {
            AppMethodBeat.o(51042);
        } else if (at.isNetworkConnected(ah.getContext())) {
            boolean z;
            cl clVar = new cl();
            clVar.vEy = str + "@wxcontact";
            clVar.vEz = 10800;
            com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
            ((com.tencent.mm.plugin.messenger.foundation.a.j) K).bOl().a(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(213, clVar));
            com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
            a.f.b.j.p(str, "userName");
            b bVar = new b();
            bVar.field_UserName = str;
            bVar.field_CreateTime = cb.aaE();
            bVar.field_ExpiredTime = bVar.field_CreateTime + 10800000;
            bVar.field_Status = 1;
            if (com.tencent.mm.plugin.forcenotify.d.a.fni.replace("ForceNotifyInfo", "UserName", bVar.Hl()) >= 0) {
                com.tencent.mm.plugin.forcenotify.d.a.mtg.put(str, bVar);
                aVar.doNotify();
                z = true;
            } else {
                z = false;
            }
            ab.i(this.TAG, "[setting] " + str + " ret:%s", Boolean.valueOf(z));
            AppMethodBeat.o(51042);
        } else {
            com.tencent.mm.plugin.forcenotify.d.a.mth.doNotify();
            AppMethodBeat.o(51042);
        }
    }

    public final void am(String str, int i) {
        AppMethodBeat.i(51043);
        if (str == null) {
            AppMethodBeat.o(51043);
        } else if (at.isNetworkConnected(ah.getContext())) {
            vs vsVar = new vs();
            vsVar.vEy = str + "@wxcontact";
            vsVar.scene = i;
            com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
            a.f.b.j.o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
            ((com.tencent.mm.plugin.messenger.foundation.a.j) K).bOl().a(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(214, vsVar));
            ab.i(this.TAG, "[delete] ".concat(String.valueOf(str)));
            AppMethodBeat.o(51043);
        } else {
            com.tencent.mm.plugin.forcenotify.d.a.mth.doNotify();
            AppMethodBeat.o(51043);
        }
    }

    public final void aJ(String str, boolean z) {
        AppMethodBeat.i(51045);
        a.f.b.j.p(str, "userName");
        if (z) {
            Intent intent = new Intent(ah.getContext(), ForceNotifyShowUI.class);
            intent.addFlags(268435456);
            intent.putExtra("userName", str);
            ah.getContext().startActivity(intent);
        }
        AppMethodBeat.o(51045);
    }

    public final boolean bxU() {
        AppMethodBeat.i(51047);
        com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
        if (com.tencent.mm.plugin.forcenotify.d.a.bxZ() > 0) {
            AppMethodBeat.o(51047);
            return true;
        }
        AppMethodBeat.o(51047);
        return false;
    }

    public final boolean hasError() {
        AppMethodBeat.i(51048);
        com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
        if (com.tencent.mm.plugin.forcenotify.d.a.byb() > 0) {
            AppMethodBeat.o(51048);
            return true;
        }
        AppMethodBeat.o(51048);
        return false;
    }

    public final boolean Mp(String str) {
        AppMethodBeat.i(51049);
        a.f.b.j.p(str, "username");
        com.tencent.mm.plugin.forcenotify.d.a aVar = com.tencent.mm.plugin.forcenotify.d.a.mth;
        boolean Mp = com.tencent.mm.plugin.forcenotify.d.a.Mp(str);
        AppMethodBeat.o(51049);
        return Mp;
    }

    public final void a(int i, com.tencent.mm.plugin.messenger.foundation.a.a.j.b bVar) {
        AppMethodBeat.i(51044);
        a.f.b.j.p(bVar, "option");
        ab.i(this.TAG, "[onOpLogResult] ret:%s %s", Integer.valueOf(i), bVar);
        com.tencent.mm.bt.a bOI;
        v vVar;
        String i2;
        if (bVar.getCmdId() == 213) {
            bOI = bVar.bOI();
            if (bOI == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
                AppMethodBeat.o(51044);
                throw vVar;
            }
            String str = ((cl) bOI).vEy;
            a.f.b.j.o(str, "oplog.ForcePushId");
            i2 = u.i(str, "@wxcontact", "", false);
            ab.i(this.TAG, "[onOpLogResult] AddForcePush username:%s", i2);
            if (i != 0 || mtc) {
                com.tencent.mm.plugin.forcenotify.d.a.mth.bW(i2, -1);
                ((com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class)).f(i2, 6, cb.aaE() / 1000);
                AppMethodBeat.o(51044);
                return;
            }
            com.tencent.mm.plugin.forcenotify.d.a.mth.bW(i2, 1);
            ((com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class)).f(i2, 1, cb.aaE() / 1000);
            AppMethodBeat.o(51044);
            return;
        }
        if (bVar.getCmdId() == 214) {
            bOI = bVar.bOI();
            if (bOI == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
                AppMethodBeat.o(51044);
                throw vVar;
            }
            vs vsVar = (vs) bOI;
            i2 = vsVar.vEy;
            a.f.b.j.o(i2, "oplog.ForcePushId");
            i2 = u.i(i2, "@wxcontact", "", false);
            int i3 = vsVar.scene;
            ab.i(this.TAG, "[onOpLogResult] DelForcePush username:%s", i2);
            if (i == 0) {
                ((com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class)).f(i2, i3, cb.aaE() / 1000);
                com.tencent.mm.plugin.forcenotify.d.a.mth.pI(i2);
            }
        }
        AppMethodBeat.o(51044);
    }

    public final void dS(Context context) {
        AppMethodBeat.i(51046);
        a.f.b.j.p(context, "context");
        ab.i(this.TAG, "[startForceNotifyShowUI]");
        context.startActivity(new Intent(context, ForceNotifyListUI.class));
        AppMethodBeat.o(51046);
    }
}
