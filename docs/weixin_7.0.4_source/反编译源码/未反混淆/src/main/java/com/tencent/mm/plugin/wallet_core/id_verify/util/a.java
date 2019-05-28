package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.wallet_core.d.e;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements f {
    int gOW = -1;
    private a tvR = null;
    WeakReference<MMActivity> tvS;
    WeakReference<e> tvT;
    private boolean tvU = false;
    c tvV;

    public interface a {
        boolean c(int i, int i2, String str, boolean z);
    }

    public final boolean a(MMActivity mMActivity, e eVar, int i) {
        AppMethodBeat.i(46677);
        this.tvU = false;
        g.RQ();
        long longValue = ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.ui.e.a(5, bo.anT(), i);
            if (currentTimeMillis < longValue) {
                ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = ".concat(String.valueOf(longValue)));
                AppMethodBeat.o(46677);
                return false;
            }
            ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = ".concat(String.valueOf(longValue)));
        }
        if (mMActivity == null) {
            ab.e("MicroMsg.RealnameVerifyUtil", "context is null");
            AppMethodBeat.o(46677);
        } else if (eVar == null) {
            ab.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
            AppMethodBeat.o(46677);
        } else {
            AppMethodBeat.o(46677);
        }
        return false;
    }

    private void bLB() {
        AppMethodBeat.i(46678);
        if (!(this.tvT == null || this.tvT.get() == null)) {
            ((e) this.tvT.get()).bLB();
        }
        AppMethodBeat.o(46678);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46679);
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            g.RQ();
            g.RO().eJo.b(385, (f) this);
            bLB();
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.id_verify.model.e eVar = (com.tencent.mm.plugin.wallet_core.id_verify.model.e) mVar;
                boolean equals = eVar.tvB.equals("1");
                if (equals) {
                    ab.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
                    d(0, i2, str, equals);
                    AppMethodBeat.o(46679);
                    return;
                }
                a((MMActivity) this.tvS.get(), (e) this.tvT.get(), eVar.title, eVar.tvC, eVar.tvD, eVar.tvE, this.tvR, false, eVar.tvF);
                AppMethodBeat.o(46679);
                return;
            }
            d(2, i2, str, false);
            AppMethodBeat.o(46679);
            return;
        }
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.a) {
            g.RQ();
            g.RO().eJo.a(385, (f) this);
            bLB();
            if (i == 0 && i2 == 0) {
                d(0, i2, str, true);
                AppMethodBeat.o(46679);
                return;
            }
            d(3, i2, str, false);
        }
        AppMethodBeat.o(46679);
    }

    public final void a(final MMActivity mMActivity, e eVar, String str, String str2, final String str3, String str4, a aVar, boolean z, int i) {
        AppMethodBeat.i(46680);
        this.tvS = new WeakReference(mMActivity);
        this.tvT = new WeakReference(eVar);
        this.tvU = z;
        if (!(this.tvS == null || this.tvS.get() == null)) {
            this.tvR = aVar;
            CharSequence charSequence = str + str2;
            j jVar = new j(mMActivity);
            final int i2 = i;
            jVar.tHw = new com.tencent.mm.plugin.wallet_core.ui.j.a() {
                public final void onClick(View view) {
                    AppMethodBeat.i(46666);
                    com.tencent.mm.wallet_core.ui.e.a(3, bo.anT(), i2);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("showShare", false);
                    d.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(46666);
                }
            };
            SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b((Context) mMActivity, charSequence);
            SpannableString spannableString = new SpannableString(b);
            spannableString.setSpan(jVar, b.length() - str2.length(), b.length(), 33);
            View textView = new TextView(mMActivity);
            textView.setText(spannableString);
            textView.setTextSize(0, (float) com.tencent.mm.bz.a.al(mMActivity, R.dimen.kr));
            textView.setTextColor(mMActivity.getResources().getColorStateList(R.color.w4));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            com.tencent.mm.wallet_core.ui.e.a(0, bo.anT(), i);
            String string = mMActivity.getString(R.string.or);
            i2 = i;
            OnClickListener anonymousClass7 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46672);
                    com.tencent.mm.wallet_core.ui.e.a(2, bo.anT(), i2);
                    if (!(a.this.tvT == null || a.this.tvT.get() == null)) {
                        g.RQ();
                        g.RO().eJo.a(385, a.this);
                        ((e) a.this.tvT.get()).a(new com.tencent.mm.plugin.wallet_core.id_verify.model.a(a.this.gOW), true);
                    }
                    AppMethodBeat.o(46672);
                }
            };
            i2 = i;
            this.tvV = h.a((Context) mMActivity, "", textView, str4, string, anonymousClass7, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46673);
                    com.tencent.mm.wallet_core.ui.e.a(1, bo.anT(), i2);
                    a.this.d(1, -1, "cancel", false);
                    AppMethodBeat.o(46673);
                }
            });
        }
        AppMethodBeat.o(46680);
    }

    /* Access modifiers changed, original: final */
    public final void d(int i, int i2, String str, boolean z) {
        AppMethodBeat.i(46681);
        ab.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
        if (this.tvR != null) {
            g.RQ();
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC, Integer.valueOf(z ? 0 : 1));
            this.tvR.c(i, i2, str, z);
            if (this.tvV != null) {
                this.tvV.dismiss();
            }
            destory();
        }
        AppMethodBeat.o(46681);
    }

    private void destory() {
        AppMethodBeat.i(46682);
        this.tvU = false;
        if (this.tvV != null) {
            ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
            this.tvV = null;
        }
        if (this.tvT != null) {
            ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
            this.tvT.clear();
            this.tvT = null;
        }
        if (this.tvS != null) {
            ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
            this.tvS.clear();
            this.tvS = null;
        }
        ab.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
        this.tvR = null;
        AppMethodBeat.o(46682);
    }

    private static JSONObject r(m mVar) {
        AppMethodBeat.i(46683);
        if (mVar != null && (mVar instanceof com.tencent.mm.wallet_core.tenpay.model.m)) {
            b dNN = ((com.tencent.mm.wallet_core.tenpay.model.m) mVar).dNN();
            if (dNN != null) {
                cgs cgs = (cgs) dNN.fsH.fsP;
                if (cgs.wxA != null) {
                    JSONObject jSONObject;
                    try {
                        jSONObject = new JSONObject(aa.b(cgs.wxA));
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.RealnameVerifyUtil", e, "", new Object[0]);
                        jSONObject = null;
                    }
                    AppMethodBeat.o(46683);
                    return jSONObject;
                }
            }
        }
        AppMethodBeat.o(46683);
        return null;
    }

    public static boolean a(Activity activity, int i, m mVar, Bundle bundle, int i2) {
        AppMethodBeat.i(46684);
        if (i != 416) {
            ab.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            AppMethodBeat.o(46684);
            return false;
        }
        ab.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        boolean a = a(activity, mVar, bundle, false, i2);
        AppMethodBeat.o(46684);
        return a;
    }

    public static boolean a(Activity activity, m mVar, Bundle bundle, boolean z, int i) {
        String str;
        AppMethodBeat.i(46685);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        JSONObject r = r(mVar);
        if (r != null) {
            if (r.has("real_name_info")) {
                r = r.optJSONObject("real_name_info");
            }
            str2 = r.optString("guide_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            str3 = r.optString("guide_wording");
            str4 = r.optString("left_button_wording", activity.getString(R.string.or));
            str5 = r.optString("right_button_wording", activity.getString(R.string.s6));
            str6 = r.optString("upload_credit_url", "");
            str = str2;
        } else {
            str = str2;
        }
        ab.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + str + ";upload_credit_url=" + str6);
        boolean a;
        if ("1".equals(str)) {
            ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            a = a(activity, bundle, null, i);
            AppMethodBeat.o(46685);
            return a;
        } else if (!"2".equals(str) || bo.isNullOrNil(str6)) {
            ab.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bo.isNullOrNil(str6));
            AppMethodBeat.o(46685);
            return false;
        } else {
            ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            a = a(activity, str3, str6, str4, str5, z, null);
            AppMethodBeat.o(46685);
            return a;
        }
    }

    public static boolean a(Activity activity, int i, bpt bpt, Bundle bundle, int i2) {
        AppMethodBeat.i(46686);
        if (i != 416) {
            ab.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            AppMethodBeat.o(46686);
            return false;
        }
        ab.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        if (bpt == null) {
            AppMethodBeat.o(46686);
            return false;
        }
        ab.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + bpt.vAF + ";upload_credit_url=" + bpt.nZd);
        boolean a;
        if (bo.isEqual("1", bpt.vAF)) {
            ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            a = a(activity, bundle, null, i2);
            AppMethodBeat.o(46686);
            return a;
        } else if (!bo.isEqual("2", bpt.vAF) || bo.isNullOrNil(bpt.nZd)) {
            ab.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + bpt.vAF + ";upload_credit_url=null?" + bo.isNullOrNil(bpt.nZd));
            AppMethodBeat.o(46686);
            return false;
        } else {
            ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            a = a(activity, bpt.nZa, bpt.nZd, bpt.nZb, bpt.nZc, true, null);
            AppMethodBeat.o(46686);
            return a;
        }
    }

    public static boolean a(Activity activity, Bundle bundle, com.tencent.mm.wallet_core.c.a aVar, int i) {
        AppMethodBeat.i(46687);
        ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", Integer.valueOf(0));
        ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", i);
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle, aVar);
        com.tencent.mm.wallet_core.ui.e.a(19, bo.anT(), i);
        AppMethodBeat.o(46687);
        return true;
    }

    public static boolean a(final Activity activity, String str, final String str2, String str3, String str4, final boolean z, OnClickListener onClickListener) {
        String string;
        String string2;
        OnClickListener anonymousClass9;
        AppMethodBeat.i(46688);
        if (bo.isNullOrNil(str3)) {
            string = activity.getString(R.string.or);
        } else {
            string = str3;
        }
        if (bo.isNullOrNil(str4)) {
            string2 = activity.getString(R.string.s6);
        } else {
            string2 = str4;
        }
        if (onClickListener == null) {
            ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
            anonymousClass9 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46674);
                    ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
                    dialogInterface.dismiss();
                    if (z) {
                        activity.finish();
                    }
                    AppMethodBeat.o(46674);
                }
            };
        } else {
            anonymousClass9 = onClickListener;
        }
        c a = h.a((Context) activity, str, "", string2, string, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(46675);
                ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                dialogInterface.dismiss();
                if (z) {
                    activity.finish();
                }
                AppMethodBeat.o(46675);
            }
        }, anonymousClass9, (int) R.color.a61);
        if (a != null) {
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(46676);
                    if (z) {
                        activity.finish();
                    }
                    AppMethodBeat.o(46676);
                }
            });
            a.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(46667);
                    if (z) {
                        activity.finish();
                    }
                    AppMethodBeat.o(46667);
                }
            });
        }
        AppMethodBeat.o(46688);
        return true;
    }

    public static boolean a(final Activity activity, final Bundle bundle, final int i, String str, String str2, String str3, OnClickListener onClickListener) {
        AppMethodBeat.i(46689);
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_SET_PWD_TIP_INT_SYNC, Integer.valueOf(0))).intValue();
        ab.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", Integer.valueOf(intValue));
        if (intValue >= 3) {
            AppMethodBeat.o(46689);
            return false;
        }
        String string;
        String string2;
        OnClickListener anonymousClass3;
        intValue++;
        g.RQ();
        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_SET_PWD_TIP_INT_SYNC, Integer.valueOf(intValue));
        if (bo.isNullOrNil(str2)) {
            string = activity.getString(R.string.or);
        } else {
            string = str2;
        }
        if (bo.isNullOrNil(str3)) {
            string2 = activity.getString(R.string.s6);
        } else {
            string2 = str3;
        }
        if (onClickListener == null) {
            anonymousClass3 = new OnClickListener() {
                final /* synthetic */ boolean tvZ = false;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(46668);
                    ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
                    dialogInterface.dismiss();
                    if (this.tvZ) {
                        activity.finish();
                    }
                    AppMethodBeat.o(46668);
                }
            };
        } else {
            anonymousClass3 = onClickListener;
        }
        c a = h.a((Context) activity, str, "", string2, string, new OnClickListener() {
            final /* synthetic */ boolean tvZ = false;

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(46669);
                ab.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
                ab.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
                Bundle bundle = bundle;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putInt("entry_scene", i);
                bundle.putBoolean("key_from_set_pwd", true);
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                com.tencent.mm.wallet_core.ui.e.a(19, bo.anT(), i);
                dialogInterface.dismiss();
                if (this.tvZ) {
                    activity.finish();
                }
                AppMethodBeat.o(46669);
            }
        }, anonymousClass3, (int) R.color.a61);
        if (a != null) {
            a.setOnCancelListener(new OnCancelListener() {
                final /* synthetic */ boolean tvZ = false;

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(46670);
                    if (this.tvZ) {
                        activity.finish();
                    }
                    AppMethodBeat.o(46670);
                }
            });
            a.setOnDismissListener(new OnDismissListener() {
                final /* synthetic */ boolean tvZ = false;

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(46671);
                    if (this.tvZ) {
                        activity.finish();
                    }
                    AppMethodBeat.o(46671);
                }
            });
        }
        AppMethodBeat.o(46689);
        return true;
    }
}
