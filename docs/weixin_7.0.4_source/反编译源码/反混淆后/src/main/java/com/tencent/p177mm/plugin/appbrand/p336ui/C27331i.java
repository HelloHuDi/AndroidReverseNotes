package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.app.Activity;
import android.content.Intent;
import android.support.p057v4.view.C0477s;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.C42625k;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.weishi.C33570d;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.i */
public final class C27331i implements C38565u {
    /* renamed from: b */
    static /* synthetic */ void m43388b(C6750i c6750i, int i, Runnable runnable) {
        AppMethodBeat.m2504i(133163);
        C27331i.m43387a(c6750i, i, runnable);
        AppMethodBeat.m2505o(133163);
    }

    /* renamed from: a */
    private static int m43386a(AppBrandStatObject appBrandStatObject) {
        if (appBrandStatObject == null) {
            return 0;
        }
        return appBrandStatObject.scene;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo32996a(Activity activity, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(133157);
        if (activity == null || activity.getIntent() == null) {
            AppMethodBeat.m2505o(133157);
        } else if (appBrandInitConfig instanceof AppBrandInitConfigWC) {
            AppBrandStatObject appBrandStatObject = ((AppBrandInitConfigWC) appBrandInitConfig).bQn;
            try {
                if (C42625k.m75487a(activity, appBrandInitConfig, appBrandStatObject)) {
                    AppMethodBeat.m2505o(133157);
                    return;
                }
            } catch (Throwable th) {
            }
            if (C33570d.m54820b(activity, appBrandInitConfig)) {
                AppMethodBeat.m2505o(133157);
                return;
            }
            boolean z;
            if (C27331i.m43386a(appBrandStatObject) == FilterEnum4Shaka.MIC_SHAKA_ADD_4) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (C27331i.m43386a(appBrandStatObject) == FaceManager.FACE_ACQUIRED_LEFT || C27331i.m43386a(appBrandStatObject) == FaceManager.FACE_ACQUIRED_RIGHT) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (WXMediaMessage.DESCRIPTION_LENGTH_LIMIT == C27331i.m43386a(appBrandStatObject)) {
                        int i;
                        if (appBrandStatObject == null) {
                            i = 0;
                        } else {
                            i = appBrandStatObject.cOq;
                        }
                        if (6 == i) {
                            z = true;
                            if (z) {
                                Intent intent = activity.getIntent();
                                if (intent == null || !intent.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false)) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    activity.overridePendingTransition(C25738R.anim.f8302a5, C25738R.anim.f8293s);
                                    AppMethodBeat.m2505o(133157);
                                    return;
                                } else if (FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI == C27331i.m43386a(appBrandStatObject)) {
                                    activity.overridePendingTransition(C25738R.anim.f8303a6, C25738R.anim.f8301a4);
                                    AppMethodBeat.m2505o(133157);
                                    return;
                                } else {
                                    activity.overridePendingTransition(C25738R.anim.f8302a5, C25738R.anim.f8301a4);
                                    AppMethodBeat.m2505o(133157);
                                    return;
                                }
                            }
                            activity.overridePendingTransition(C5206a.yne, C5206a.ynf);
                            AppMethodBeat.m2505o(133157);
                            return;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
            }
            activity.overridePendingTransition(C25738R.anim.f8302a5, C25738R.anim.f8293s);
            AppMethodBeat.m2505o(133157);
        } else {
            AppMethodBeat.m2505o(133157);
        }
    }

    /* renamed from: k */
    public final void mo32999k(Activity activity) {
        AppMethodBeat.m2504i(133158);
        activity.overridePendingTransition(C25738R.anim.f8299a2, C25738R.anim.f8300a3);
        AppMethodBeat.m2505o(133158);
    }

    /* renamed from: a */
    public final void mo32997a(C6750i c6750i, C6750i c6750i2) {
        AppMethodBeat.m2504i(133159);
        if (c6750i == null) {
            AppMethodBeat.m2505o(133159);
            return;
        }
        C27331i.m43387a(c6750i, C27331i.m43385D(c6750i) ? C5206a.ync : C25738R.anim.f8302a5, null);
        if (c6750i2 != null) {
            C27331i.m43387a(c6750i2, C27331i.m43385D(c6750i) ? C5206a.ynd : C25738R.anim.f8293s, null);
        }
        AppMethodBeat.m2505o(133159);
    }

    /* renamed from: a */
    public final void mo32998a(C6750i c6750i, C6750i c6750i2, Runnable runnable) {
        AppMethodBeat.m2504i(133160);
        if (c6750i2 == null) {
            AppMethodBeat.m2505o(133160);
            return;
        }
        C27331i.m43387a(c6750i2, C27331i.m43385D(c6750i2) ? C5206a.ynf : C25738R.anim.f8300a3, runnable);
        if (c6750i != null) {
            C27331i.m43387a(c6750i, C27331i.m43385D(c6750i2) ? C5206a.yne : C25738R.anim.f8293s, null);
        }
        AppMethodBeat.m2505o(133160);
    }

    /* renamed from: D */
    public static boolean m43385D(C6750i c6750i) {
        AppMethodBeat.m2504i(133162);
        if (c6750i instanceof C41243o) {
            C41243o c41243o = (C41243o) c6750i;
            if (c41243o.atD() || c41243o.mo43491ya().bQn.scene == FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN) {
                AppMethodBeat.m2505o(133162);
                return true;
            }
            AppMethodBeat.m2505o(133162);
            return false;
        }
        AppMethodBeat.m2505o(133162);
        return false;
    }

    /* renamed from: a */
    private static void m43387a(final C6750i c6750i, final int i, final Runnable runnable) {
        AppMethodBeat.m2504i(133161);
        if (C0477s.m927as(c6750i.gNE)) {
            Animation loadAnimation = AnimationUtils.loadAnimation(c6750i.getContext(), i);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(133155);
                    if (runnable != null) {
                        C5004al.m7441d(runnable);
                    }
                    AppMethodBeat.m2505o(133155);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.m2504i(133156);
                    c6750i.gNE.setWillNotDraw(false);
                    AppMethodBeat.m2505o(133156);
                }
            });
            c6750i.gNE.startAnimation(loadAnimation);
            AppMethodBeat.m2505o(133161);
            return;
        }
        c6750i.gNE.setWillNotDraw(true);
        c6750i.gNE.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(133154);
                C27331i.m43388b(c6750i, i, runnable);
                AppMethodBeat.m2505o(133154);
            }
        });
        AppMethodBeat.m2505o(133161);
    }
}
