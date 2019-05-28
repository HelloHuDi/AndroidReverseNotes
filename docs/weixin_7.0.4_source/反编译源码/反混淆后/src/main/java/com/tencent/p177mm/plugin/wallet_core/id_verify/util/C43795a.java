package com.tencent.p177mm.plugin.wallet_core.id_verify.util;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.wallet_core.id_verify.C40105a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C29624e;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C46364a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.bpt;
import com.tencent.p177mm.protocal.protobuf.cgs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p760d.C46722e;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.a */
public final class C43795a implements C1202f {
    int gOW = -1;
    private C43798a tvR = null;
    WeakReference<MMActivity> tvS;
    WeakReference<C46722e> tvT;
    private boolean tvU = false;
    C5653c tvV;

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.util.a$a */
    public interface C43798a {
        /* renamed from: c */
        boolean mo24759c(int i, int i2, String str, boolean z);
    }

    /* renamed from: a */
    public final boolean mo69477a(MMActivity mMActivity, C46722e c46722e, int i) {
        AppMethodBeat.m2504i(46677);
        this.tvU = false;
        C1720g.m3537RQ();
        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            C36391e.m59982a(5, C5046bo.anT(), i);
            if (currentTimeMillis < longValue) {
                C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = ".concat(String.valueOf(longValue)));
                AppMethodBeat.m2505o(46677);
                return false;
            }
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = ".concat(String.valueOf(longValue)));
        }
        if (mMActivity == null) {
            C4990ab.m7412e("MicroMsg.RealnameVerifyUtil", "context is null");
            AppMethodBeat.m2505o(46677);
        } else if (c46722e == null) {
            C4990ab.m7412e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
            AppMethodBeat.m2505o(46677);
        } else {
            AppMethodBeat.m2505o(46677);
        }
        return false;
    }

    private void bLB() {
        AppMethodBeat.m2504i(46678);
        if (!(this.tvT == null || this.tvT.get() == null)) {
            ((C46722e) this.tvT.get()).bLB();
        }
        AppMethodBeat.m2505o(46678);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46679);
        if (c1207m instanceof C29624e) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
            bLB();
            if (i == 0 && i2 == 0) {
                C29624e c29624e = (C29624e) c1207m;
                boolean equals = c29624e.tvB.equals("1");
                if (equals) {
                    C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "user had agreed");
                    mo69478d(0, i2, str, equals);
                    AppMethodBeat.m2505o(46679);
                    return;
                }
                mo69476a((MMActivity) this.tvS.get(), (C46722e) this.tvT.get(), c29624e.title, c29624e.tvC, c29624e.tvD, c29624e.tvE, this.tvR, false, c29624e.tvF);
                AppMethodBeat.m2505o(46679);
                return;
            }
            mo69478d(2, i2, str, false);
            AppMethodBeat.m2505o(46679);
            return;
        }
        if (c1207m instanceof C46364a) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
            bLB();
            if (i == 0 && i2 == 0) {
                mo69478d(0, i2, str, true);
                AppMethodBeat.m2505o(46679);
                return;
            }
            mo69478d(3, i2, str, false);
        }
        AppMethodBeat.m2505o(46679);
    }

    /* renamed from: a */
    public final void mo69476a(final MMActivity mMActivity, C46722e c46722e, String str, String str2, final String str3, String str4, C43798a c43798a, boolean z, int i) {
        AppMethodBeat.m2504i(46680);
        this.tvS = new WeakReference(mMActivity);
        this.tvT = new WeakReference(c46722e);
        this.tvU = z;
        if (!(this.tvS == null || this.tvS.get() == null)) {
            this.tvR = c43798a;
            CharSequence charSequence = str + str2;
            C46373j c46373j = new C46373j(mMActivity);
            final int i2 = i;
            c46373j.tHw = new C29672a() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(46666);
                    C36391e.m59982a(3, C5046bo.anT(), i2);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("showShare", false);
                    C25985d.m41467b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(46666);
                }
            };
            SpannableString b = C44089j.m79292b((Context) mMActivity, charSequence);
            SpannableString spannableString = new SpannableString(b);
            spannableString.setSpan(c46373j, b.length() - str2.length(), b.length(), 33);
            View textView = new TextView(mMActivity);
            textView.setText(spannableString);
            textView.setTextSize(0, (float) C1338a.m2856al(mMActivity, C25738R.dimen.f9936kr));
            textView.setTextColor(mMActivity.getResources().getColorStateList(C25738R.color.f12212w4));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            C36391e.m59982a(0, C5046bo.anT(), i);
            String string = mMActivity.getString(C25738R.string.f9076or);
            i2 = i;
            OnClickListener c401087 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(46672);
                    C36391e.m59982a(2, C5046bo.anT(), i2);
                    if (!(C43795a.this.tvT == null || C43795a.this.tvT.get() == null)) {
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14539a(385, C43795a.this);
                        ((C46722e) C43795a.this.tvT.get()).mo36581a(new C46364a(C43795a.this.gOW), true);
                    }
                    AppMethodBeat.m2505o(46672);
                }
            };
            i2 = i;
            this.tvV = C30379h.m48437a((Context) mMActivity, "", textView, str4, string, c401087, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(46673);
                    C36391e.m59982a(1, C5046bo.anT(), i2);
                    C43795a.this.mo69478d(1, -1, "cancel", false);
                    AppMethodBeat.m2505o(46673);
                }
            });
        }
        AppMethodBeat.m2505o(46680);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo69478d(int i, int i2, String str, boolean z) {
        AppMethodBeat.m2504i(46681);
        C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
        if (this.tvR != null) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_DISCLAIMER_NEED_AGERR_INT_SYNC, Integer.valueOf(z ? 0 : 1));
            this.tvR.mo24759c(i, i2, str, z);
            if (this.tvV != null) {
                this.tvV.dismiss();
            }
            destory();
        }
        AppMethodBeat.m2505o(46681);
    }

    private void destory() {
        AppMethodBeat.m2504i(46682);
        this.tvU = false;
        if (this.tvV != null) {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
            this.tvV = null;
        }
        if (this.tvT != null) {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
            this.tvT.clear();
            this.tvT = null;
        }
        if (this.tvS != null) {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
            this.tvS.clear();
            this.tvS = null;
        }
        C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
        this.tvR = null;
        AppMethodBeat.m2505o(46682);
    }

    /* renamed from: r */
    private static JSONObject m78496r(C1207m c1207m) {
        AppMethodBeat.m2504i(46683);
        if (c1207m != null && (c1207m instanceof C5749m)) {
            C7472b dNN = ((C5749m) c1207m).dNN();
            if (dNN != null) {
                cgs cgs = (cgs) dNN.fsH.fsP;
                if (cgs.wxA != null) {
                    JSONObject jSONObject;
                    try {
                        jSONObject = new JSONObject(C1946aa.m4153b(cgs.wxA));
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("MicroMsg.RealnameVerifyUtil", e, "", new Object[0]);
                        jSONObject = null;
                    }
                    AppMethodBeat.m2505o(46683);
                    return jSONObject;
                }
            }
        }
        AppMethodBeat.m2505o(46683);
        return null;
    }

    /* renamed from: a */
    public static boolean m78490a(Activity activity, int i, C1207m c1207m, Bundle bundle, int i2) {
        AppMethodBeat.m2504i(46684);
        if (i != 416) {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            AppMethodBeat.m2505o(46684);
            return false;
        }
        C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        boolean a = C43795a.m78494a(activity, c1207m, bundle, false, i2);
        AppMethodBeat.m2505o(46684);
        return a;
    }

    /* renamed from: a */
    public static boolean m78494a(Activity activity, C1207m c1207m, Bundle bundle, boolean z, int i) {
        String str;
        AppMethodBeat.m2504i(46685);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        JSONObject r = C43795a.m78496r(c1207m);
        if (r != null) {
            if (r.has("real_name_info")) {
                r = r.optJSONObject("real_name_info");
            }
            str2 = r.optString("guide_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            str3 = r.optString("guide_wording");
            str4 = r.optString("left_button_wording", activity.getString(C25738R.string.f9076or));
            str5 = r.optString("right_button_wording", activity.getString(C25738R.string.f9187s6));
            str6 = r.optString("upload_credit_url", "");
            str = str2;
        } else {
            str = str2;
        }
        C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + str + ";upload_credit_url=" + str6);
        boolean a;
        if ("1".equals(str)) {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            a = C43795a.m78493a(activity, bundle, null, i);
            AppMethodBeat.m2505o(46685);
            return a;
        } else if (!"2".equals(str) || C5046bo.isNullOrNil(str6)) {
            C4990ab.m7412e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + C5046bo.isNullOrNil(str6));
            AppMethodBeat.m2505o(46685);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            a = C43795a.m78495a(activity, str3, str6, str4, str5, z, null);
            AppMethodBeat.m2505o(46685);
            return a;
        }
    }

    /* renamed from: a */
    public static boolean m78491a(Activity activity, int i, bpt bpt, Bundle bundle, int i2) {
        AppMethodBeat.m2504i(46686);
        if (i != 416) {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            AppMethodBeat.m2505o(46686);
            return false;
        }
        C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        if (bpt == null) {
            AppMethodBeat.m2505o(46686);
            return false;
        }
        C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + bpt.vAF + ";upload_credit_url=" + bpt.nZd);
        boolean a;
        if (C5046bo.isEqual("1", bpt.vAF)) {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            a = C43795a.m78493a(activity, bundle, null, i2);
            AppMethodBeat.m2505o(46686);
            return a;
        } else if (!C5046bo.isEqual("2", bpt.vAF) || C5046bo.isNullOrNil(bpt.nZd)) {
            C4990ab.m7412e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + bpt.vAF + ";upload_credit_url=null?" + C5046bo.isNullOrNil(bpt.nZd));
            AppMethodBeat.m2505o(46686);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            a = C43795a.m78495a(activity, bpt.nZa, bpt.nZd, bpt.nZb, bpt.nZc, true, null);
            AppMethodBeat.m2505o(46686);
            return a;
        }
    }

    /* renamed from: a */
    public static boolean m78493a(Activity activity, Bundle bundle, C30857a c30857a, int i) {
        AppMethodBeat.m2504i(46687);
        C4990ab.m7417i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", Integer.valueOf(0));
        C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", i);
        C24143a.m37106a(activity, C40105a.class, bundle, c30857a);
        C36391e.m59982a(19, C5046bo.anT(), i);
        AppMethodBeat.m2505o(46687);
        return true;
    }

    /* renamed from: a */
    public static boolean m78495a(final Activity activity, String str, final String str2, String str3, String str4, final boolean z, OnClickListener onClickListener) {
        String string;
        String string2;
        OnClickListener c401099;
        AppMethodBeat.m2504i(46688);
        if (C5046bo.isNullOrNil(str3)) {
            string = activity.getString(C25738R.string.f9076or);
        } else {
            string = str3;
        }
        if (C5046bo.isNullOrNil(str4)) {
            string2 = activity.getString(C25738R.string.f9187s6);
        } else {
            string2 = str4;
        }
        if (onClickListener == null) {
            C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
            c401099 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(46674);
                    C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
                    dialogInterface.dismiss();
                    if (z) {
                        activity.finish();
                    }
                    AppMethodBeat.m2505o(46674);
                }
            };
        } else {
            c401099 = onClickListener;
        }
        C5653c a = C30379h.m48444a((Context) activity, str, "", string2, string, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(46675);
                C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                C25985d.m41467b(activity, "webview", ".ui.tools.WebViewUI", intent);
                dialogInterface.dismiss();
                if (z) {
                    activity.finish();
                }
                AppMethodBeat.m2505o(46675);
            }
        }, c401099, (int) C25738R.color.a61);
        if (a != null) {
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(46676);
                    if (z) {
                        activity.finish();
                    }
                    AppMethodBeat.m2505o(46676);
                }
            });
            a.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(46667);
                    if (z) {
                        activity.finish();
                    }
                    AppMethodBeat.m2505o(46667);
                }
            });
        }
        AppMethodBeat.m2505o(46688);
        return true;
    }

    /* renamed from: a */
    public static boolean m78492a(final Activity activity, final Bundle bundle, final int i, String str, String str2, String str3, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(46689);
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_SET_PWD_TIP_INT_SYNC, Integer.valueOf(0))).intValue();
        C4990ab.m7417i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", Integer.valueOf(intValue));
        if (intValue >= 3) {
            AppMethodBeat.m2505o(46689);
            return false;
        }
        String string;
        String string2;
        OnClickListener c142283;
        intValue++;
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_SET_PWD_TIP_INT_SYNC, Integer.valueOf(intValue));
        if (C5046bo.isNullOrNil(str2)) {
            string = activity.getString(C25738R.string.f9076or);
        } else {
            string = str2;
        }
        if (C5046bo.isNullOrNil(str3)) {
            string2 = activity.getString(C25738R.string.f9187s6);
        } else {
            string2 = str3;
        }
        if (onClickListener == null) {
            c142283 = new OnClickListener() {
                final /* synthetic */ boolean tvZ = false;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(46668);
                    C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
                    dialogInterface.dismiss();
                    if (this.tvZ) {
                        activity.finish();
                    }
                    AppMethodBeat.m2505o(46668);
                }
            };
        } else {
            c142283 = onClickListener;
        }
        C5653c a = C30379h.m48444a((Context) activity, str, "", string2, string, new OnClickListener() {
            final /* synthetic */ boolean tvZ = false;

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(46669);
                C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
                C4990ab.m7416i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
                Bundle bundle = bundle;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putInt("entry_scene", i);
                bundle.putBoolean("key_from_set_pwd", true);
                C24143a.m37105a(activity, C40105a.class, bundle);
                C36391e.m59982a(19, C5046bo.anT(), i);
                dialogInterface.dismiss();
                if (this.tvZ) {
                    activity.finish();
                }
                AppMethodBeat.m2505o(46669);
            }
        }, c142283, (int) C25738R.color.a61);
        if (a != null) {
            a.setOnCancelListener(new OnCancelListener() {
                final /* synthetic */ boolean tvZ = false;

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(46670);
                    if (this.tvZ) {
                        activity.finish();
                    }
                    AppMethodBeat.m2505o(46670);
                }
            });
            a.setOnDismissListener(new OnDismissListener() {
                final /* synthetic */ boolean tvZ = false;

                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(46671);
                    if (this.tvZ) {
                        activity.finish();
                    }
                    AppMethodBeat.m2505o(46671);
                }
            });
        }
        AppMethodBeat.m2505o(46689);
        return true;
    }
}
