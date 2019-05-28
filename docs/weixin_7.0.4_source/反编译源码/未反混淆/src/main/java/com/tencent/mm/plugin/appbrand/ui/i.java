package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.s;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.weishi.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class i implements u {
    static /* synthetic */ void b(com.tencent.mm.plugin.appbrand.i iVar, int i, Runnable runnable) {
        AppMethodBeat.i(133163);
        a(iVar, i, runnable);
        AppMethodBeat.o(133163);
    }

    private static int a(AppBrandStatObject appBrandStatObject) {
        if (appBrandStatObject == null) {
            return 0;
        }
        return appBrandStatObject.scene;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Activity activity, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(133157);
        if (activity == null || activity.getIntent() == null) {
            AppMethodBeat.o(133157);
        } else if (appBrandInitConfig instanceof AppBrandInitConfigWC) {
            AppBrandStatObject appBrandStatObject = ((AppBrandInitConfigWC) appBrandInitConfig).bQn;
            try {
                if (k.a(activity, appBrandInitConfig, appBrandStatObject)) {
                    AppMethodBeat.o(133157);
                    return;
                }
            } catch (Throwable th) {
            }
            if (d.b(activity, appBrandInitConfig)) {
                AppMethodBeat.o(133157);
                return;
            }
            boolean z;
            if (a(appBrandStatObject) == FilterEnum4Shaka.MIC_SHAKA_ADD_4) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (a(appBrandStatObject) == FaceManager.FACE_ACQUIRED_LEFT || a(appBrandStatObject) == FaceManager.FACE_ACQUIRED_RIGHT) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    if (WXMediaMessage.DESCRIPTION_LENGTH_LIMIT == a(appBrandStatObject)) {
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
                                    activity.overridePendingTransition(R.anim.a5, R.anim.s);
                                    AppMethodBeat.o(133157);
                                    return;
                                } else if (FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI == a(appBrandStatObject)) {
                                    activity.overridePendingTransition(R.anim.a6, R.anim.a4);
                                    AppMethodBeat.o(133157);
                                    return;
                                } else {
                                    activity.overridePendingTransition(R.anim.a5, R.anim.a4);
                                    AppMethodBeat.o(133157);
                                    return;
                                }
                            }
                            activity.overridePendingTransition(a.yne, a.ynf);
                            AppMethodBeat.o(133157);
                            return;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
            }
            activity.overridePendingTransition(R.anim.a5, R.anim.s);
            AppMethodBeat.o(133157);
        } else {
            AppMethodBeat.o(133157);
        }
    }

    public final void k(Activity activity) {
        AppMethodBeat.i(133158);
        activity.overridePendingTransition(R.anim.a2, R.anim.a3);
        AppMethodBeat.o(133158);
    }

    public final void a(com.tencent.mm.plugin.appbrand.i iVar, com.tencent.mm.plugin.appbrand.i iVar2) {
        AppMethodBeat.i(133159);
        if (iVar == null) {
            AppMethodBeat.o(133159);
            return;
        }
        a(iVar, D(iVar) ? a.ync : R.anim.a5, null);
        if (iVar2 != null) {
            a(iVar2, D(iVar) ? a.ynd : R.anim.s, null);
        }
        AppMethodBeat.o(133159);
    }

    public final void a(com.tencent.mm.plugin.appbrand.i iVar, com.tencent.mm.plugin.appbrand.i iVar2, Runnable runnable) {
        AppMethodBeat.i(133160);
        if (iVar2 == null) {
            AppMethodBeat.o(133160);
            return;
        }
        a(iVar2, D(iVar2) ? a.ynf : R.anim.a3, runnable);
        if (iVar != null) {
            a(iVar, D(iVar2) ? a.yne : R.anim.s, null);
        }
        AppMethodBeat.o(133160);
    }

    public static boolean D(com.tencent.mm.plugin.appbrand.i iVar) {
        AppMethodBeat.i(133162);
        if (iVar instanceof o) {
            o oVar = (o) iVar;
            if (oVar.atD() || oVar.ya().bQn.scene == FilterEnum4Shaka.MIC_WEISHI_v4_4_TIANPIN) {
                AppMethodBeat.o(133162);
                return true;
            }
            AppMethodBeat.o(133162);
            return false;
        }
        AppMethodBeat.o(133162);
        return false;
    }

    private static void a(final com.tencent.mm.plugin.appbrand.i iVar, final int i, final Runnable runnable) {
        AppMethodBeat.i(133161);
        if (s.as(iVar.gNE)) {
            Animation loadAnimation = AnimationUtils.loadAnimation(iVar.getContext(), i);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(133155);
                    if (runnable != null) {
                        al.d(runnable);
                    }
                    AppMethodBeat.o(133155);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(133156);
                    iVar.gNE.setWillNotDraw(false);
                    AppMethodBeat.o(133156);
                }
            });
            iVar.gNE.startAnimation(loadAnimation);
            AppMethodBeat.o(133161);
            return;
        }
        iVar.gNE.setWillNotDraw(true);
        iVar.gNE.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(133154);
                i.b(iVar, i, runnable);
                AppMethodBeat.o(133154);
            }
        });
        AppMethodBeat.o(133161);
    }
}
