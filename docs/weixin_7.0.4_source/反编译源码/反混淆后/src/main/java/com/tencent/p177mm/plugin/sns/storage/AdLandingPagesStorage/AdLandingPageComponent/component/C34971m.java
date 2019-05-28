package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy.C34948e;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy.C3880a;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsTextProgressBar;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29062b;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.C15374qc;
import com.tencent.p177mm.sdk.p602d.C15419b;
import com.tencent.p177mm.sdk.p602d.C4886a;
import com.tencent.p177mm.sdk.p602d.C4887d;
import com.tencent.p177mm.sdk.p602d.C4887d.C4890c;
import com.tencent.p177mm.sdk.p602d.C7292c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m */
public final class C34971m extends C16866j implements Serializable {
    private View qZG;
    private Button qZH;
    private SnsTextProgressBar qZI;
    C34973a qZJ = new C34973a("apkStateMachine", this.qZK.oAl.getLooper());
    private C5004al qZK = new C5004al("apkStateMachine");
    private C34972b qZL;
    private OnClickListener qZM = new C38981();
    C34948e qZN = new C134382();

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$1 */
    class C38981 implements OnClickListener {
        C38981() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37100);
            C34971m.this.qZJ.sendMessage(0);
            C34971m.this.cpH();
            AppMethodBeat.m2505o(37100);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$2 */
    class C134382 implements C34948e {
        C134382() {
        }

        /* renamed from: ao */
        public final void mo25548ao(Object obj) {
        }

        /* renamed from: f */
        public final void mo25549f(int i, int i2, Object obj) {
            AppMethodBeat.m2504i(37101);
            if (i == 0 && i2 == 0) {
                C15374qc c15374qc = new C15374qc();
                try {
                    c15374qc.parseFrom((byte[]) obj);
                } catch (IOException e) {
                    C4990ab.m7412e("MicroMsg.AdLandingPageDownloadApkBtnComp", C5046bo.m7574l(e));
                }
                if (!TextUtils.isEmpty(c15374qc.vGi)) {
                    C4990ab.m7410d("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + c15374qc.vGi);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", c15374qc.vGi);
                    intent.putExtra("showShare", true);
                    C25985d.m41467b(C34971m.this.context, "webview", ".ui.tools.WebViewUI", intent);
                    C34971m.this.qZJ.sendMessage(10);
                    AppMethodBeat.m2505o(37101);
                    return;
                } else if (c15374qc.vXh != null) {
                    ((C29062b) C34971m.this.qZo).qVM = c15374qc.vXh.kKY;
                    ((C29062b) C34971m.this.qZo).cvZ = c15374qc.vXh.kLL;
                    ((C29062b) C34971m.this.qZo).downloadUrl = c15374qc.vXh.vXa;
                    ((C29062b) C34971m.this.qZo).fileSize = (long) c15374qc.vXh.vXd;
                    C34971m.this.qZJ.sendMessage(6);
                    AppMethodBeat.m2505o(37101);
                    return;
                } else {
                    C4990ab.m7416i("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp null");
                    C34971m.this.qZJ.sendMessage(5);
                    AppMethodBeat.m2505o(37101);
                    return;
                }
            }
            C34971m.this.qZJ.sendMessage(5);
            AppMethodBeat.m2505o(37101);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$4 */
    class C349704 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$4$1 */
        class C168671 implements C14875aj {
            C168671() {
            }

            /* renamed from: dR */
            public final void mo6036dR(boolean z) {
                AppMethodBeat.m2504i(37104);
                if (!z) {
                    C29064ad.m46207eQ(C34971m.this.context);
                }
                AppMethodBeat.m2505o(37104);
            }
        }

        C349704() {
        }

        public final void run() {
            AppMethodBeat.m2504i(37105);
            C46494g.m87724a(C34971m.this.context, C34971m.this.context.getPackageManager().getLaunchIntentForPackage(((C29062b) C34971m.this.qZo).f13702Iw), C46494g.m87756t(C34971m.this.context, ((C29062b) C34971m.this.qZo).csB), new C168671());
            AppMethodBeat.m2505o(37105);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$b */
    class C34972b extends BroadcastReceiver implements Serializable {
        private C34972b() {
        }

        /* synthetic */ C34972b(C34971m c34971m, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(37143);
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    action = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(action) && action.equals(((C29062b) C34971m.this.qZo).f13702Iw)) {
                        C34971m.this.qZJ.sendMessage(3);
                    }
                    AppMethodBeat.m2505o(37143);
                    return;
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    action = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(action) && action.equals(((C29062b) C34971m.this.qZo).f13702Iw)) {
                        C34971m.this.qZJ.sendMessage(4);
                    }
                }
            }
            AppMethodBeat.m2505o(37143);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a */
    class C34973a extends C4887d implements Serializable {
        C7292c qZR = new C34977c();
        C7292c qZS = new C21956g();
        C7292c qZT = new C34974e();
        C7292c qZU = new C21958h();
        C7292c qZV = new C21960i();
        C7292c qZW = new C34980f();
        C7292c qZX = new C29075b();
        C7292c qZY = new C29073a();
        C7292c qZZ = new C34979d();

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$g */
        class C21956g extends C15419b {

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$g$2 */
            class C38992 implements Runnable {
                C38992() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37130);
                    C34971m.this.qZI.setVisibility(8);
                    C34971m.this.qZH.setVisibility(0);
                    C34971m.this.qZH.setText(((C29062b) C34971m.this.qZo).title);
                    AppMethodBeat.m2505o(37130);
                }
            }

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$g$3 */
            class C39003 implements Runnable {

                /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$g$3$1 */
                class C39011 implements DialogInterface.OnClickListener {
                    C39011() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(37131);
                        C34971m.this.qZJ.sendMessage(12);
                        C26483d.m42196b(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", C21956g.this.hashCode());
                        AppMethodBeat.m2505o(37131);
                    }
                }

                C39003() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37132);
                    if (NetStatusUtil.isWifi(C34971m.this.context)) {
                        C34971m.this.qZJ.sendMessage(12);
                        AppMethodBeat.m2505o(37132);
                        return;
                    }
                    C4990ab.m7416i("LogStateTransitionState", "download not in wifi!");
                    C30379h.m48432a(C34971m.this.context, (int) C25738R.string.fy6, (int) C25738R.string.fy7, new C39011(), null);
                    AppMethodBeat.m2505o(37132);
                }
            }

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$g$1 */
            class C219571 implements Runnable {
                C219571() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37129);
                    if (C34971m.this.qZL == null) {
                        C34971m.this.qZL = new C34972b(C34971m.this, (byte) 0);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                        intentFilter.addDataScheme("package");
                        C34971m.this.context.registerReceiver(C34971m.this.qZL, intentFilter);
                    }
                    AppMethodBeat.m2505o(37129);
                }
            }

            C21956g() {
            }

            public final void enter() {
                AppMethodBeat.m2504i(37133);
                super.enter();
                C5004al.m7441d(new C219571());
                if (AdLandingPagesProxy.getInstance().isPkgInstalled(((C29062b) C34971m.this.qZo).f13702Iw)) {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZV);
                    AppMethodBeat.m2505o(37133);
                } else if (AdLandingPagesProxy.getInstance().isApkExist(((C29062b) C34971m.this.qZo).csB)) {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZU);
                    AppMethodBeat.m2505o(37133);
                } else if (AdLandingPagesProxy.getInstance().isDownloading(((C29062b) C34971m.this.qZo).csB)) {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZR);
                    AppMethodBeat.m2505o(37133);
                } else if (AdLandingPagesProxy.getInstance().isPaused(((C29062b) C34971m.this.qZo).csB)) {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZT);
                    AppMethodBeat.m2505o(37133);
                } else {
                    C5004al.m7441d(new C38992());
                    AppMethodBeat.m2505o(37133);
                }
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(37134);
                C4990ab.m7416i("LogStateTransitionState", hashCode() + "[ToDownloadState]recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().isDownloading(((C29062b) C34971m.this.qZo).csB)) {
                            C34973a.m57449a(C34973a.this, C34971m.this.context.getString(C25738R.string.eiz));
                        } else {
                            C5004al.m7441d(new C39003());
                        }
                        AppMethodBeat.m2505o(37134);
                        return true;
                    case 3:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZV);
                        AppMethodBeat.m2505o(37134);
                        return true;
                    case 11:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZS);
                        AppMethodBeat.m2505o(37134);
                        return true;
                    case 12:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZR);
                        AppMethodBeat.m2505o(37134);
                        return true;
                    default:
                        AppMethodBeat.m2505o(37134);
                        return false;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$h */
        class C21958h extends C15419b {
            private boolean rai;

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$h$1 */
            class C134421 implements Runnable {
                C134421() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37135);
                    C34971m.this.qZI.setVisibility(8);
                    C34971m.this.qZH.setVisibility(0);
                    C34971m.this.qZH.setText(C25738R.string.ej2);
                    AppMethodBeat.m2505o(37135);
                }
            }

            C21958h() {
            }

            public final void enter() {
                AppMethodBeat.m2504i(37136);
                super.enter();
                if (AdLandingPagesProxy.getInstance().isApkExist(((C29062b) C34971m.this.qZo).csB)) {
                    C5004al.m7441d(new C134421());
                    this.rai = true;
                    AppMethodBeat.m2505o(37136);
                    return;
                }
                C34973a.this.mo10075b((C4886a) C34973a.this.qZS);
                AppMethodBeat.m2505o(37136);
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(37137);
                C4990ab.m7416i("LogStateTransitionState", hashCode() + "[ToInstallState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().installApp(C34971m.this.context, ((C29062b) C34971m.this.qZo).csB, ((C29062b) C34971m.this.qZo).f13702Iw, ((C29062b) C34971m.this.qZo).cvZ, ((C29062b) C34971m.this.qZo).downloadUrl)) {
                            this.rai = true;
                            AppMethodBeat.m2505o(37137);
                            return true;
                        }
                        C34973a.m57449a(C34973a.this, C34971m.this.context.getString(C25738R.string.ej3));
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZW);
                        AppMethodBeat.m2505o(37137);
                        return true;
                    case 2:
                        if (!AdLandingPagesProxy.getInstance().isApkExist(((C29062b) C34971m.this.qZo).csB)) {
                            C34973a.this.mo10075b((C4886a) C34973a.this.qZS);
                        }
                        AppMethodBeat.m2505o(37137);
                        return true;
                    case 3:
                        if (this.rai) {
                            this.rai = false;
                        }
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZV);
                        AppMethodBeat.m2505o(37137);
                        return true;
                    default:
                        AppMethodBeat.m2505o(37137);
                        return false;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$i */
        class C21960i extends C15419b {

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$i$1 */
            class C219591 implements Runnable {
                C219591() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37138);
                    C34971m.this.qZI.setVisibility(8);
                    C34971m.this.qZH.setVisibility(0);
                    C34971m.this.qZH.setText(C25738R.string.ej4);
                    AppMethodBeat.m2505o(37138);
                }
            }

            C21960i() {
            }

            public final void enter() {
                AppMethodBeat.m2504i(37139);
                super.enter();
                if (AdLandingPagesProxy.getInstance().isPkgInstalled(((C29062b) C34971m.this.qZo).f13702Iw)) {
                    C5004al.m7441d(new C219591());
                    AppMethodBeat.m2505o(37139);
                    return;
                }
                C34973a.this.mo10075b((C4886a) C34973a.this.qZU);
                AppMethodBeat.m2505o(37139);
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(37140);
                C4990ab.m7416i("LogStateTransitionState", hashCode() + "[ToOpenState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (C34971m.this.cpK()) {
                            AppMethodBeat.m2505o(37140);
                            return true;
                        }
                        C34973a.m57449a(C34973a.this, C34971m.this.context.getString(C25738R.string.ej5));
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZV);
                        AppMethodBeat.m2505o(37140);
                        return true;
                    case 4:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZS);
                        AppMethodBeat.m2505o(37140);
                        return true;
                    default:
                        AppMethodBeat.m2505o(37140);
                        return false;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$a */
        class C29073a extends C15419b {

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$a$1 */
            class C290741 implements Runnable {
                C290741() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37107);
                    C34971m.this.qZI.setVisibility(8);
                    C34971m.this.qZH.setEnabled(false);
                    C34971m.this.qZH.setText(!TextUtils.isEmpty(((C29062b) C34971m.this.qZo).qVP) ? ((C29062b) C34971m.this.qZo).qVP : "暂不支持安卓手机");
                    C34971m.this.qZH.setVisibility(0);
                    AppMethodBeat.m2505o(37107);
                }
            }

            C29073a() {
            }

            public final void enter() {
                AppMethodBeat.m2504i(37108);
                super.enter();
                C5004al.m7441d(new C290741());
                AppMethodBeat.m2505o(37108);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$b */
        class C29075b extends C15419b {
            C29075b() {
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(37109);
                C4990ab.m7416i("LogStateTransitionState", hashCode() + "[DoNetSceneState]recv msg.what " + message.what);
                if (AdLandingPagesProxy.getInstance().isApkExist(((C29062b) C34971m.this.qZo).csB)) {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZU);
                    AppMethodBeat.m2505o(37109);
                    return true;
                }
                switch (message.what) {
                    case 5:
                        C34973a.m57449a(C34973a.this, C34971m.this.context.getString(C25738R.string.ej1));
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZW);
                        AppMethodBeat.m2505o(37109);
                        return true;
                    case 6:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZS);
                        AppMethodBeat.m2505o(37109);
                        return true;
                    case 10:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZS);
                        AppMethodBeat.m2505o(37109);
                        return true;
                    default:
                        AppMethodBeat.m2505o(37109);
                        return false;
                }
            }

            public final void enter() {
                AppMethodBeat.m2504i(37110);
                super.enter();
                AdLandingPagesProxy.getInstance().doAdChannelScene(((C29062b) C34971m.this.qZo).f13702Iw, ((C29062b) C34971m.this.qZo).channelId, C34971m.this.qZN);
                C4990ab.m7417i("LogStateTransitionState", hashCode() + "[DoNetSceneState] appid %s, channelId %s", ((C29062b) C34971m.this.qZo).f13702Iw, ((C29062b) C34971m.this.qZo).channelId);
                AppMethodBeat.m2505o(37110);
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$e */
        class C34974e extends C15419b {

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$e$1 */
            class C134411 implements Runnable {
                C134411() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37122);
                    C34971m.this.qZI.setVisibility(8);
                    C34971m.this.qZH.setVisibility(0);
                    C34971m.this.qZH.setText(C25738R.string.ej0);
                    AppMethodBeat.m2505o(37122);
                }
            }

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$e$2 */
            class C349752 implements DialogInterface.OnClickListener {
                C349752() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(37123);
                    C34973a.this.sendMessage(12);
                    C26483d.m42196b(10, "AdLandingPageDownloadApkBtnComp_PAUSE_MSG_BTN_CLICK", C34974e.this.hashCode());
                    AppMethodBeat.m2505o(37123);
                }
            }

            C34974e() {
            }

            public final void enter() {
                AppMethodBeat.m2504i(37124);
                super.enter();
                C5004al.m7441d(new C134411());
                AppMethodBeat.m2505o(37124);
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(37125);
                C4990ab.m7416i("LogStateTransitionState", hashCode() + "[PauseState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().isDownloading(((C29062b) C34971m.this.qZo).csB)) {
                            C34973a.m57449a(C34973a.this, C34971m.this.context.getString(C25738R.string.eiz));
                        } else if (NetStatusUtil.isWifi(C34971m.this.context)) {
                            C34973a.this.sendMessage(12);
                        } else {
                            C4990ab.m7416i("LogStateTransitionState", "download not in wifi!");
                            C30379h.m48432a(C34971m.this.context, (int) C25738R.string.fy6, (int) C25738R.string.fy7, new C349752(), null);
                        }
                        AppMethodBeat.m2505o(37125);
                        return true;
                    case 3:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZV);
                        AppMethodBeat.m2505o(37125);
                        return true;
                    case 8:
                        C34973a.m57449a(C34973a.this, C34971m.this.context.getString(C25738R.string.ej1));
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZW);
                        AppMethodBeat.m2505o(37125);
                        return true;
                    case 12:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZR);
                        AppMethodBeat.m2505o(37125);
                        return true;
                    default:
                        AppMethodBeat.m2505o(37125);
                        return false;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$c */
        class C34977c extends C15419b {
            C3880a rac;

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$c$1 */
            class C219531 implements Runnable {
                C219531() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37111);
                    C34971m.this.qZH.setVisibility(8);
                    C34971m.this.qZI.setVisibility(0);
                    AppMethodBeat.m2505o(37111);
                }
            }

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$c$2 */
            class C219542 implements Runnable {
                C219542() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37112);
                    C34971m.this.qZI.setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(((C29062b) C34971m.this.qZo).csB));
                    AppMethodBeat.m2505o(37112);
                }
            }

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$c$3 */
            class C219553 implements Runnable {
                C219553() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37113);
                    C34971m.this.qZI.setProgress(100);
                    AppMethodBeat.m2505o(37113);
                }
            }

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$c$a */
            class C34978a implements C3880a {
                private C34978a() {
                }

                /* synthetic */ C34978a(C34977c c34977c, byte b) {
                    this();
                }

                /* renamed from: CP */
                public final void mo8596CP(int i) {
                    AppMethodBeat.m2504i(37115);
                    C34973a a = C34971m.this.qZJ;
                    C4890c c4890c = a.xCt;
                    if (c4890c != null) {
                        c4890c.sendMessage(Message.obtain(a.xCt, 1, i, 0));
                    }
                    AppMethodBeat.m2505o(37115);
                }

                public final void cmA() {
                    AppMethodBeat.m2504i(37116);
                    C4990ab.m7416i("LogStateTransitionState", "paused");
                    C34971m.this.qZJ.sendMessage(7);
                    AppMethodBeat.m2505o(37116);
                }

                public final void cmB() {
                    AppMethodBeat.m2504i(37117);
                    C34971m.this.qZJ.sendMessage(9);
                    AppMethodBeat.m2505o(37117);
                }

                public final void cmC() {
                    AppMethodBeat.m2504i(37118);
                    C34971m.this.qZJ.sendMessage(8);
                    AppMethodBeat.m2505o(37118);
                }
            }

            C34977c() {
            }

            public final void enter() {
                AppMethodBeat.m2504i(37119);
                super.enter();
                C5004al.m7441d(new C219531());
                if (AdLandingPagesProxy.getInstance().isPaused(((C29062b) C34971m.this.qZo).csB) || AdLandingPagesProxy.getInstance().isDownloading(((C29062b) C34971m.this.qZo).csB)) {
                    if (this.rac == null) {
                        this.rac = new C34978a(this, (byte) 0);
                    }
                    C5004al.m7441d(new C219542());
                    if (!AdLandingPagesProxy.getInstance().resumeTask(((C29062b) C34971m.this.qZo).csB, this.rac, C34971m.this.cpC().qTL, C34971m.this.cpC().hcx)) {
                        AdLandingPagesProxy.getInstance().stopTask(((C29062b) C34971m.this.qZo).csB);
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZR);
                        AppMethodBeat.m2505o(37119);
                        return;
                    }
                } else if (TextUtils.isEmpty(((C29062b) C34971m.this.qZo).downloadUrl)) {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZX);
                    AppMethodBeat.m2505o(37119);
                    return;
                } else if (AdLandingPagesProxy.getInstance().isApkExist(((C29062b) C34971m.this.qZo).csB)) {
                    C5004al.m7441d(new C219553());
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZU);
                    AppMethodBeat.m2505o(37119);
                    return;
                } else {
                    AdLandingPagesProxy.getInstance().stopTask(((C29062b) C34971m.this.qZo).csB);
                    this.rac = new C34978a(this, (byte) 0);
                    AdLandingPagesProxy.getInstance().startDownload(((C29062b) C34971m.this.qZo).csB, ((C29062b) C34971m.this.qZo).f13702Iw, ((C29062b) C34971m.this.qZo).cvZ, ((C29062b) C34971m.this.qZo).downloadUrl, ((C29062b) C34971m.this.qZo).qVM, ((C29062b) C34971m.this.qZo).qVN, this.rac, C34971m.this.cpC().qTL, C34971m.this.cpC().hcx);
                }
                AppMethodBeat.m2505o(37119);
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(37120);
                C4990ab.m7416i("LogStateTransitionState", hashCode() + "[DownloadingState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().pauseTask(((C29062b) C34971m.this.qZo).csB) && AdLandingPagesProxy.getInstance().isPaused(((C29062b) C34971m.this.qZo).csB)) {
                            C34973a.this.mo10075b((C4886a) C34973a.this.qZT);
                        }
                        AppMethodBeat.m2505o(37120);
                        return true;
                    case 1:
                        final int i = message.arg1;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(37114);
                                if (i >= 0) {
                                    C34971m.this.qZI.setProgress(i);
                                }
                                AppMethodBeat.m2505o(37114);
                            }
                        });
                        AppMethodBeat.m2505o(37120);
                        return true;
                    case 3:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZV);
                        AppMethodBeat.m2505o(37120);
                        return true;
                    case 7:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZT);
                        AppMethodBeat.m2505o(37120);
                        return true;
                    case 8:
                        C34973a.m57449a(C34973a.this, C34971m.this.context.getString(C25738R.string.ej1));
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZW);
                        AppMethodBeat.m2505o(37120);
                        return true;
                    case 9:
                        C34971m.this.cpL();
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZU);
                        AppMethodBeat.m2505o(37120);
                        return true;
                    default:
                        AppMethodBeat.m2505o(37120);
                        return false;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$d */
        class C34979d extends C15419b {
            C34979d() {
            }

            public final void enter() {
                Object obj;
                AppMethodBeat.m2504i(37121);
                super.enter();
                C29062b b = ((C29062b) C34971m.this.qZo);
                if (b.qVO == 0 || b.qVO == 2) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZY);
                    AppMethodBeat.m2505o(37121);
                } else if (AdLandingPagesProxy.getInstance().isApkExist(((C29062b) C34971m.this.qZo).csB)) {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZU);
                    AppMethodBeat.m2505o(37121);
                } else if (AdLandingPagesProxy.getInstance().isPkgInstalled(((C29062b) C34971m.this.qZo).f13702Iw)) {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZV);
                    AppMethodBeat.m2505o(37121);
                } else {
                    C34973a.this.mo10075b((C4886a) C34973a.this.qZX);
                    AppMethodBeat.m2505o(37121);
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$f */
        class C34980f extends C15419b {

            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$a$f$1 */
            class C349811 implements Runnable {
                C349811() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(37126);
                    C34971m.this.qZI.setVisibility(8);
                    C34971m.this.qZH.setVisibility(0);
                    C34971m.this.qZH.setText(C25738R.string.ej6);
                    AppMethodBeat.m2505o(37126);
                }
            }

            C34980f() {
            }

            public final void enter() {
                AppMethodBeat.m2504i(37127);
                super.enter();
                C5004al.m7441d(new C349811());
                AppMethodBeat.m2505o(37127);
            }

            /* renamed from: k */
            public final boolean mo10090k(Message message) {
                AppMethodBeat.m2504i(37128);
                C4990ab.m7416i("LogStateTransitionState", hashCode() + "[ReDownloadState] recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        C34973a.this.mo10075b((C4886a) C34973a.this.qZX);
                        AppMethodBeat.m2505o(37128);
                        return true;
                    default:
                        AppMethodBeat.m2505o(37128);
                        return false;
                }
            }
        }

        protected C34973a(String str, Looper looper) {
            super(str, looper);
            AppMethodBeat.m2504i(37141);
            mo10073a(this.qZS);
            mo10073a(this.qZR);
            mo10073a(this.qZT);
            mo10073a(this.qZU);
            mo10073a(this.qZV);
            mo10073a(this.qZW);
            mo10073a(this.qZX);
            mo10073a(this.qZY);
            mo10073a(this.qZZ);
            mo10076b(this.qZZ);
            AppMethodBeat.m2505o(37141);
        }

        /* renamed from: a */
        static /* synthetic */ void m57449a(C34973a c34973a, final String str) {
            AppMethodBeat.m2504i(37142);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(37106);
                    C30379h.m48465bQ(C34971m.this.context, str);
                    AppMethodBeat.m2505o(37106);
                }
            });
            AppMethodBeat.m2505o(37142);
        }
    }

    public C34971m(Context context, C29062b c29062b, ViewGroup viewGroup) {
        super(context, c29062b, viewGroup);
        AppMethodBeat.m2504i(37144);
        AppMethodBeat.m2505o(37144);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970714;
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37147);
        super.cpa();
        this.qZJ.sendMessage(2);
        AdLandingPagesProxy.getInstance().addReportInfo(((C29062b) this.qZo).csB, cpC().qTL, cpC().hcx);
        AppMethodBeat.m2505o(37147);
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37148);
        super.coZ();
        C4990ab.m7416i("MicroMsg.AdLandingPageDownloadApkBtnComp", "view destroy");
        this.qZK.oAl.quit();
        if (this.qZL != null) {
            this.context.unregisterReceiver(this.qZL);
            this.qZL = null;
        }
        AppMethodBeat.m2505o(37148);
    }

    public final boolean cpK() {
        AppMethodBeat.m2504i(37149);
        if (this.context == null || TextUtils.isEmpty(((C29062b) this.qZo).csB) || TextUtils.isEmpty(((C29062b) this.qZo).f13702Iw)) {
            AppMethodBeat.m2505o(37149);
            return false;
        }
        if (TextUtils.isEmpty(((C29062b) this.qZo).qVZ)) {
            C26006a.post(new C349704());
        } else {
            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((C29062b) this.qZo).qVZ));
            intent.addFlags(268435456);
            List H = C5046bo.m7502H(this.context, intent);
            if (!(H == null || H.isEmpty())) {
                Object b;
                if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
                    b = C46494g.m87734b((ResolveInfo) H.get(0));
                } else {
                    b = intent.getPackage();
                }
                if (!C5046bo.nullAsNil(C4996ah.getPackageName()).equals(b)) {
                    C26006a.post(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m$3$1 */
                        class C134401 implements C14875aj {
                            C134401() {
                            }

                            /* renamed from: dR */
                            public final void mo6036dR(boolean z) {
                                AppMethodBeat.m2504i(37102);
                                if (!z) {
                                    C29064ad.m46207eQ(C34971m.this.context);
                                }
                                AppMethodBeat.m2505o(37102);
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(37103);
                            C46494g.m87724a(C34971m.this.context, intent, C46494g.m87756t(C34971m.this.context, ((C29062b) C34971m.this.qZo).csB), new C134401());
                            AppMethodBeat.m2505o(37103);
                        }
                    });
                }
            }
        }
        AdLandingPagesProxy.getInstance().reportDownloadInfo(9, ((C29062b) this.qZo).csB);
        AppMethodBeat.m2505o(37149);
        return true;
    }

    public final void cpL() {
        AppMethodBeat.m2504i(37150);
        C4990ab.m7410d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
        AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((C29062b) this.qZo).f13702Iw, ((C29062b) this.qZo).qVZ);
        AppMethodBeat.m2505o(37150);
    }

    /* renamed from: gi */
    private static String m57448gi(String str, String str2) {
        AppMethodBeat.m2504i(37151);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(37151);
            return str2;
        } else if (str.matches("#[0-9A-Fa-f]{6}([0-9A-Fa-f]{2})?")) {
            AppMethodBeat.m2505o(37151);
            return str;
        } else {
            AppMethodBeat.m2505o(37151);
            return str2;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37145);
        HashMap hashMap = new HashMap();
        hashMap.put("fontNormalColor", C34971m.m57448gi(((C29062b) this.qZo).qVW, "#FFFFFF"));
        hashMap.put("fontDisableColor", C34971m.m57448gi(((C29062b) this.qZo).qVX, "#4CFFFFFF"));
        hashMap.put("fontPressedColor", C34971m.m57448gi(((C29062b) this.qZo).qVY, "#99FFFFFF"));
        hashMap.put("NormalColor", C34971m.m57448gi(((C29062b) this.qZo).qVQ, "#1AAD19"));
        hashMap.put("PressedColor", C34971m.m57448gi(((C29062b) this.qZo).qVS, "#179B16"));
        hashMap.put("DisableColor", C34971m.m57448gi(((C29062b) this.qZo).qVR, "#661AAD19"));
        hashMap.put("borderNormalColor", C34971m.m57448gi(((C29062b) this.qZo).qVT, "#179E16"));
        hashMap.put("borderPressedColor", C34971m.m57448gi(((C29062b) this.qZo).qVV, "#158E14"));
        hashMap.put("borderDisableColor", C34971m.m57448gi(((C29062b) this.qZo).qVU, "#00179E16"));
        int parseColor = Color.parseColor((String) hashMap.get("fontNormalColor"));
        int parseColor2 = Color.parseColor((String) hashMap.get("fontDisableColor"));
        int parseColor3 = Color.parseColor((String) hashMap.get("fontPressedColor"));
        int parseColor4 = Color.parseColor((String) hashMap.get("NormalColor"));
        int parseColor5 = Color.parseColor((String) hashMap.get("PressedColor"));
        int parseColor6 = Color.parseColor((String) hashMap.get("DisableColor"));
        int i = (int) ((C29062b) this.qZo).qWo;
        int parseColor7 = Color.parseColor((String) hashMap.get("borderNormalColor"));
        int parseColor8 = Color.parseColor((String) hashMap.get("borderPressedColor"));
        int parseColor9 = Color.parseColor((String) hashMap.get("borderDisableColor"));
        int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(C25738R.dimen.f9740e6);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable.setColor(parseColor6);
        gradientDrawable.setStroke(i, parseColor9);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable2.setColor(parseColor5);
        gradientDrawable2.setStroke(i, parseColor8);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable3.setColor(parseColor4);
        gradientDrawable3.setStroke(i, parseColor7);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable3);
        this.qZH.setBackground(stateListDrawable);
        int[] iArr = new int[]{parseColor2, parseColor3, parseColor};
        r2 = new int[3][];
        r2[0] = new int[]{-16842910};
        r2[1] = new int[]{16842919};
        r2[2] = new int[]{16842910};
        this.qZH.setTextColor(new ColorStateList(r2, iArr));
        gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable2.setColor(parseColor5);
        gradientDrawable2.setStroke(i, parseColor8);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable4.setColor(parseColor4);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable4, 3, 1);
        gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius((float) dimensionPixelSize);
        gradientDrawable4.setColor(parseColor4);
        ClipDrawable clipDrawable2 = new ClipDrawable(gradientDrawable4, 3, 1);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable2, clipDrawable, clipDrawable2});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.qZI.setProgressDrawable(layerDrawable);
        this.qZI.setPaintColor(((C29062b) this.qZo).qVY);
        if (((C29062b) this.qZo).height > 0.0f) {
            LayoutParams layoutParams = (LayoutParams) this.qZG.getLayoutParams();
            layoutParams.height = (int) ((C29062b) this.qZo).height;
            this.qZG.setLayoutParams(layoutParams);
        }
        this.qZH.setText(((C29062b) this.qZo).title);
        this.qZJ.sendMessage(11);
        AppMethodBeat.m2505o(37145);
    }

    @TargetApi(17)
    public final void cpk() {
        AppMethodBeat.m2504i(37146);
        this.clickCount = 0;
        View view = this.contentView;
        this.qZG = view.findViewById(2131827615);
        this.qZH = (Button) view.findViewById(2131822658);
        this.qZH.setOnClickListener(this.qZM);
        this.qZI = (SnsTextProgressBar) view.findViewById(2131827616);
        this.qZI.setProgress(0);
        this.qZI.setVisibility(8);
        this.qZI.setOnClickListener(this.qZM);
        this.qZJ.start();
        AppMethodBeat.m2505o(37146);
    }
}
