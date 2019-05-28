package com.tencent.p177mm.plugin.forcenotify.p1263b;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C28062a;
import com.tencent.p177mm.plugin.forcenotify.p1613c.C43101b;
import com.tencent.p177mm.plugin.forcenotify.p1648d.C45947a;
import com.tencent.p177mm.plugin.forcenotify.p415ui.ForceNotifyListUI;
import com.tencent.p177mm.plugin.forcenotify.p415ui.ForceNotifyShowUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6976g.C3456a;
import com.tencent.p177mm.protocal.protobuf.C30174cl;
import com.tencent.p177mm.protocal.protobuf.C30235vs;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0018H\u0016J,\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010\u00052\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0007H\u0016J\u0012\u00102\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00103\u001a\u00020\u000fH\u0016J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u00104\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00105\u001a\u000206H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u00067"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyService;", "Lcom/tencent/mm/plugin/forcenotify/core/BaseForceNotifyService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogResult;", "()V", "ForceNotifyTAG", "", "isSound", "", "()Z", "setSound", "(Z)V", "isTestError", "isVibrate", "setVibrate", "delete", "", "username", "scene", "", "getCount", "getExpireTime", "", "getForceNotifyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getForceNotifyStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "hasError", "isNeedNotify", "isNeedShowBanner", "isSilentMode", "context", "Landroid/content/Context;", "isVibrateMode", "notifyShow", "userName", "onModify", "info", "onOpLogResult", "ret", "title", "content", "option", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "onReceive", "isNeedShow", "release", "setCanSoundAndVibrate", "setForTest", "isTest", "setting", "start", "startForceNotifyShowUI", "intent", "Landroid/content/Intent;", "plugin-force-notify_release"})
/* renamed from: com.tencent.mm.plugin.forcenotify.b.c */
public final class C43100c extends C24760a implements C3456a {
    private static boolean mtc;
    private static boolean mtd = true;
    private static boolean mte = true;
    public static final C43100c mtf = new C43100c();

    static {
        AppMethodBeat.m2504i(51050);
        AppMethodBeat.m2505o(51050);
    }

    private C43100c() {
    }

    /* renamed from: hx */
    public final void mo36074hx(boolean z) {
        mtc = z;
    }

    public final C7563j<?> bxV() {
        return C45947a.mth;
    }

    public static boolean isSilentMode(Context context) {
        AppMethodBeat.m2504i(51036);
        C25052j.m39376p(context, "context");
        Object systemService = context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.m2505o(51036);
            throw c44941v;
        } else if (((AudioManager) systemService).getRingerMode() != 2) {
            AppMethodBeat.m2505o(51036);
            return true;
        } else {
            AppMethodBeat.m2505o(51036);
            return false;
        }
    }

    /* renamed from: dT */
    public static boolean m76620dT(Context context) {
        AppMethodBeat.m2504i(51037);
        C25052j.m39376p(context, "context");
        Object systemService = context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (systemService == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.media.AudioManager");
            AppMethodBeat.m2505o(51037);
            throw c44941v;
        } else if (((AudioManager) systemService).getRingerMode() > 0) {
            AppMethodBeat.m2505o(51037);
            return true;
        } else {
            AppMethodBeat.m2505o(51037);
            return false;
        }
    }

    public final void start() {
        AppMethodBeat.m2504i(51038);
        super.start();
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((C6982j) K).bOl().mo15235a(213, this);
        K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((C6982j) K).bOl().mo15235a(214, this);
        AppMethodBeat.m2505o(51038);
    }

    public final void release() {
        AppMethodBeat.m2504i(51039);
        super.release();
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((C6982j) K).bOl().mo15237b(213, this);
        K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
        ((C6982j) K).bOl().mo15237b(214, this);
        AppMethodBeat.m2505o(51039);
    }

    public static ArrayList<C43101b> bxW() {
        AppMethodBeat.m2504i(51040);
        C45947a c45947a = C45947a.mth;
        ArrayList bxY = C45947a.bxY();
        AppMethodBeat.m2505o(51040);
        return bxY;
    }

    /* renamed from: Mo */
    public final long mo36067Mo(String str) {
        AppMethodBeat.m2504i(51041);
        C25052j.m39376p(str, "username");
        C45947a c45947a = C45947a.mth;
        C25052j.m39376p(str, "userName");
        C43101b c43101b = new C43101b();
        c43101b.field_UserName = str;
        if (c45947a.mo10102b((C4925c) c43101b, new String[0])) {
            long j = c43101b.field_ExpiredTime;
            AppMethodBeat.m2505o(51041);
            return j;
        }
        AppMethodBeat.m2505o(51041);
        return 0;
    }

    /* renamed from: Mn */
    public final void mo36066Mn(String str) {
        AppMethodBeat.m2504i(51042);
        if (str == null) {
            AppMethodBeat.m2505o(51042);
        } else if (C5023at.isNetworkConnected(C4996ah.getContext())) {
            boolean z;
            C30174cl c30174cl = new C30174cl();
            c30174cl.vEy = str + "@wxcontact";
            c30174cl.vEz = 10800;
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
            ((C6982j) K).bOl().mo15236a(new C3465a(213, c30174cl));
            C45947a c45947a = C45947a.mth;
            C25052j.m39376p(str, "userName");
            C43101b c43101b = new C43101b();
            c43101b.field_UserName = str;
            c43101b.field_CreateTime = C1839cb.aaE();
            c43101b.field_ExpiredTime = c43101b.field_CreateTime + 10800000;
            c43101b.field_Status = 1;
            if (C45947a.fni.replace("ForceNotifyInfo", "UserName", c43101b.mo10098Hl()) >= 0) {
                C45947a.mtg.put(str, c43101b);
                c45947a.doNotify();
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7417i(this.TAG, "[setting] " + str + " ret:%s", Boolean.valueOf(z));
            AppMethodBeat.m2505o(51042);
        } else {
            C45947a.mth.doNotify();
            AppMethodBeat.m2505o(51042);
        }
    }

    /* renamed from: am */
    public final void mo36069am(String str, int i) {
        AppMethodBeat.m2504i(51043);
        if (str == null) {
            AppMethodBeat.m2505o(51043);
        } else if (C5023at.isNetworkConnected(C4996ah.getContext())) {
            C30235vs c30235vs = new C30235vs();
            c30235vs.vEy = str + "@wxcontact";
            c30235vs.scene = i;
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "MMKernel.service<IMessen…engerStorage::class.java)");
            ((C6982j) K).bOl().mo15236a(new C3465a(214, c30235vs));
            C4990ab.m7416i(this.TAG, "[delete] ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(51043);
        } else {
            C45947a.mth.doNotify();
            AppMethodBeat.m2505o(51043);
        }
    }

    /* renamed from: aJ */
    public final void mo41624aJ(String str, boolean z) {
        AppMethodBeat.m2504i(51045);
        C25052j.m39376p(str, "userName");
        if (z) {
            Intent intent = new Intent(C4996ah.getContext(), ForceNotifyShowUI.class);
            intent.addFlags(268435456);
            intent.putExtra("userName", str);
            C4996ah.getContext().startActivity(intent);
        }
        AppMethodBeat.m2505o(51045);
    }

    public final boolean bxU() {
        AppMethodBeat.m2504i(51047);
        C45947a c45947a = C45947a.mth;
        if (C45947a.bxZ() > 0) {
            AppMethodBeat.m2505o(51047);
            return true;
        }
        AppMethodBeat.m2505o(51047);
        return false;
    }

    public final boolean hasError() {
        AppMethodBeat.m2504i(51048);
        C45947a c45947a = C45947a.mth;
        if (C45947a.byb() > 0) {
            AppMethodBeat.m2505o(51048);
            return true;
        }
        AppMethodBeat.m2505o(51048);
        return false;
    }

    /* renamed from: Mp */
    public final boolean mo36068Mp(String str) {
        AppMethodBeat.m2504i(51049);
        C25052j.m39376p(str, "username");
        C45947a c45947a = C45947a.mth;
        boolean Mp = C45947a.m85333Mp(str);
        AppMethodBeat.m2505o(51049);
        return Mp;
    }

    /* renamed from: a */
    public final void mo7912a(int i, C3463b c3463b) {
        AppMethodBeat.m2504i(51044);
        C25052j.m39376p(c3463b, "option");
        C4990ab.m7417i(this.TAG, "[onOpLogResult] ret:%s %s", Integer.valueOf(i), c3463b);
        C1331a bOI;
        C44941v c44941v;
        String i2;
        if (c3463b.getCmdId() == 213) {
            bOI = c3463b.bOI();
            if (bOI == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddForcePush");
                AppMethodBeat.m2505o(51044);
                throw c44941v;
            }
            String str = ((C30174cl) bOI).vEy;
            C25052j.m39375o(str, "oplog.ForcePushId");
            i2 = C6163u.m9838i(str, "@wxcontact", "", false);
            C4990ab.m7417i(this.TAG, "[onOpLogResult] AddForcePush username:%s", i2);
            if (i != 0 || mtc) {
                C45947a.mth.mo73803bW(i2, -1);
                ((C28062a) C1720g.m3528K(C28062a.class)).mo36079f(i2, 6, C1839cb.aaE() / 1000);
                AppMethodBeat.m2505o(51044);
                return;
            }
            C45947a.mth.mo73803bW(i2, 1);
            ((C28062a) C1720g.m3528K(C28062a.class)).mo36079f(i2, 1, C1839cb.aaE() / 1000);
            AppMethodBeat.m2505o(51044);
            return;
        }
        if (c3463b.getCmdId() == 214) {
            bOI = c3463b.bOI();
            if (bOI == null) {
                c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.DelForcePush");
                AppMethodBeat.m2505o(51044);
                throw c44941v;
            }
            C30235vs c30235vs = (C30235vs) bOI;
            i2 = c30235vs.vEy;
            C25052j.m39375o(i2, "oplog.ForcePushId");
            i2 = C6163u.m9838i(i2, "@wxcontact", "", false);
            int i3 = c30235vs.scene;
            C4990ab.m7417i(this.TAG, "[onOpLogResult] DelForcePush username:%s", i2);
            if (i == 0) {
                ((C28062a) C1720g.m3528K(C28062a.class)).mo36079f(i2, i3, C1839cb.aaE() / 1000);
                C45947a.mth.mo73804pI(i2);
            }
        }
        AppMethodBeat.m2505o(51044);
    }

    /* renamed from: dS */
    public final void mo36072dS(Context context) {
        AppMethodBeat.m2504i(51046);
        C25052j.m39376p(context, "context");
        C4990ab.m7416i(this.TAG, "[startForceNotifyShowUI]");
        context.startActivity(new Intent(context, ForceNotifyListUI.class));
        AppMethodBeat.m2505o(51046);
    }
}
