package com.tencent.p177mm.plugin.walletlock.p1623b;

import android.app.Activity;
import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C26255ur;
import com.tencent.p177mm.plugin.walletlock.fingerprint.p1058ui.FingerprintWalletLockUI;
import com.tencent.p177mm.plugin.walletlock.p1319c.C29711d;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40171g;
import com.tencent.p177mm.plugin.walletlock.p1319c.C46387a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C29709a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b.C40168a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b.C40169b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.walletlock.b.a */
public final class C43832a extends C46387a {
    public final void init() {
        AppMethodBeat.m2504i(51445);
        C40171g c40171g = C40171g.tWY;
        C40171g.cTX();
        C40171g.tWY.mo63507HG(3);
        AppMethodBeat.m2505o(51445);
    }

    /* renamed from: a */
    public final void mo38286a(Activity activity, C40169b c40169b) {
        AppMethodBeat.m2504i(51446);
        if (!C1720g.m3532RL().mo5213J(C29709a.class)) {
            C4990ab.m7410d("MicroMsg.FaceIdLockImpl", "Plugin gesture is not installed.");
            AppMethodBeat.m2505o(51446);
        } else if (c40169b == null || c40169b.mo47948ae(activity)) {
            C26255ur c26255ur = new C26255ur();
            c26255ur.cRv.cRx = 0;
            c26255ur.cRv.activity = activity;
            C4879a.xxA.mo10055m(c26255ur);
            switch (((Integer) c26255ur.cRw.data).intValue()) {
                case 17:
                    activity.finish();
                    Intent intent = new Intent(activity, FingerprintWalletLockUI.class);
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, "action.verify_pattern");
                    intent.putExtra("next_action", "next_action.goto_protected_page");
                    intent.putExtra("page_intent", activity.getIntent());
                    intent.putExtra("scene", C46387a.m87240af(activity));
                    intent.setPackage(C4996ah.getPackageName());
                    activity.startActivity(intent);
                    break;
            }
            AppMethodBeat.m2505o(51446);
        } else {
            C4990ab.m7410d("MicroMsg.FaceIdLockImpl", "protectMeOnCreate: still in filter range, do not activate protection.");
            AppMethodBeat.m2505o(51446);
        }
    }

    /* renamed from: a */
    public final void mo38287a(Activity activity, C40169b c40169b, C40168a c40168a) {
        AppMethodBeat.m2504i(51447);
        super.mo38287a(activity, c40169b, c40168a);
        AppMethodBeat.m2505o(51447);
    }

    /* renamed from: b */
    public final void mo38289b(Activity activity, int i, int i2) {
        AppMethodBeat.m2504i(51448);
        super.mo38289b(activity, i, i2);
        AppMethodBeat.m2505o(51448);
    }

    public final C40169b cTi() {
        AppMethodBeat.m2504i(51449);
        C29711d cTU = C29711d.cTU();
        AppMethodBeat.m2505o(51449);
        return cTU;
    }

    public final boolean cTj() {
        AppMethodBeat.m2504i(51450);
        C40171g c40171g = C40171g.tWY;
        boolean cTo = C40171g.cTo();
        AppMethodBeat.m2505o(51450);
        return cTo;
    }
}
