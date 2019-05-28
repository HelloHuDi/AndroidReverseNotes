package com.tencent.p177mm.plugin.luckymoney.model;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C41963al;
import com.tencent.p177mm.p230g.p231a.C41963al.C37689a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.luckymoney.p449ui.SelectLuckyMoneyContactUI;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.pluginsdk.p1079f.C46486g;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.atm;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.x */
public class C46063x {
    private static C1177f<String, Bitmap> mkq = new C26399b(10, C46063x.class);
    public static int nYd = BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.x$3 */
    static class C460623 implements OnCancelListener {
        C460623() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: j */
    public static String m85820j(Context context, long j) {
        AppMethodBeat.m2504i(42357);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        String str;
        if (j < 3600000) {
            str = "";
            AppMethodBeat.m2505o(42357);
            return str;
        }
        long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > 86400000) {
            Time time = new Time();
            time.set(j);
            str = C46486g.m87705a(context.getString(C25738R.string.bwy, new Object[]{" "}), time).toString();
            AppMethodBeat.m2505o(42357);
            return str;
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(j));
        AppMethodBeat.m2505o(42357);
        return str;
    }

    /* renamed from: a */
    private static void m85803a(ImageView imageView, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(42359);
        C4990ab.m7417i("MicroMsg.LuckyMoneyUtil", "load url: %s", str);
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        if (!C5046bo.isNullOrNil(str)) {
            C17927a c17927a = new C17927a();
            C6964a.bKN();
            c17927a.ePK = C6964a.bKP();
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.eQf = z;
            if (z) {
                c17927a.eQg = 0.0f;
            }
            if (C5046bo.isNullOrNil(str2)) {
                c17927a.ePP = false;
            } else {
                c17927a.cvZ = str2;
                c17927a.ePP = true;
            }
            C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
        }
        AppMethodBeat.m2505o(42359);
    }

    /* renamed from: a */
    public static void m85802a(ImageView imageView, String str, String str2) {
        AppMethodBeat.m2504i(42360);
        C46063x.m85803a(imageView, str, str2, false);
        AppMethodBeat.m2505o(42360);
    }

    /* renamed from: l */
    public static void m85822l(ImageView imageView, String str) {
        AppMethodBeat.m2504i(42362);
        if (imageView == null) {
            AppMethodBeat.m2505o(42362);
            return;
        }
        imageView.setImageBitmap(null);
        if (!C5046bo.isNullOrNil(str)) {
            C17927a c17927a = new C17927a();
            C6964a.bKN();
            c17927a.ePK = C6964a.bKP();
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.eQf = false;
            c17927a.ePT = C25738R.drawable.b9z;
            C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
        }
        AppMethodBeat.m2505o(42362);
    }

    /* renamed from: b */
    public static void m85811b(ImageView imageView, String str, String str2) {
        AppMethodBeat.m2504i(42363);
        if (imageView == null) {
            AppMethodBeat.m2505o(42363);
            return;
        }
        if (C5046bo.isNullOrNil(str2)) {
            str2 = C17884o.acv().mo67497qc(str);
        }
        C40460b.m69433a(imageView, str2, 0.1f, false);
        AppMethodBeat.m2505o(42363);
    }

    /* renamed from: m */
    public static void m85823m(ImageView imageView, String str) {
        AppMethodBeat.m2504i(42364);
        if (imageView == null) {
            AppMethodBeat.m2505o(42364);
            return;
        }
        imageView.setImageBitmap(null);
        if (!C5046bo.isNullOrNil(str)) {
            C17927a c17927a = new C17927a();
            C6964a.bKN();
            c17927a.ePK = C6964a.bKP();
            c17927a.ePH = true;
            c17927a.ePZ = true;
            c17927a.eQf = true;
            c17927a.fHe = 1;
            c17927a.ePT = C25738R.drawable.b8q;
            C32291o.ahp().mo43766a(str, imageView, c17927a.ahG());
        }
        AppMethodBeat.m2505o(42364);
    }

    /* renamed from: a */
    public static void m85800a(Context context, TextView textView, String str) {
        AppMethodBeat.m2504i(42365);
        if (textView == null) {
            AppMethodBeat.m2505o(42365);
            return;
        }
        textView.setText(C44089j.m79293b(context, (CharSequence) str, textView.getTextSize()));
        AppMethodBeat.m2505o(42365);
    }

    /* renamed from: a */
    public static void m85804a(MMActivity mMActivity, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(42366);
        if (i != 0 || i2 <= 1) {
            C46063x.m85805a(mMActivity, 2, z);
            AppMethodBeat.m2505o(42366);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(mMActivity, SelectLuckyMoneyContactUI.class);
        intent.putExtra("key_friends_num", i2);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        mMActivity.startActivityForResult(intent, 2);
        AppMethodBeat.m2505o(42366);
    }

    /* renamed from: a */
    public static void m85805a(MMActivity mMActivity, int i, boolean z) {
        AppMethodBeat.m2504i(42367);
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        C25985d.m41466b((Context) mMActivity, ".ui.transmit.SelectConversationUI", intent, i);
        AppMethodBeat.m2505o(42367);
    }

    public static String bLC() {
        AppMethodBeat.m2504i(42368);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SELFINFO_SMALLIMGURL_STRING, null);
        AppMethodBeat.m2505o(42368);
        return str;
    }

    /* renamed from: Qj */
    public static String m85798Qj(String str) {
        AppMethodBeat.m2504i(42369);
        C17880h qo = C17884o.act().mo33392qo(str);
        if (qo != null) {
            String acl = qo.acl();
            AppMethodBeat.m2505o(42369);
            return acl;
        }
        C1720g.m3537RQ();
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || !aoO.field_username.equals(str)) {
            AppMethodBeat.m2505o(42369);
            return null;
        } else if (aoO.dtR == 4) {
            AppMethodBeat.m2505o(42369);
            return null;
        } else {
            C1720g.m3537RQ();
            byte[] aoS = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoS(str);
            if (C5046bo.m7540cb(aoS)) {
                AppMethodBeat.m2505o(42369);
                return null;
            }
            String str2;
            try {
                str2 = ((bbv) new bbv().parseFrom(aoS)).vXn;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.LuckyMoneyUtil", "exception:%s", C5046bo.m7574l(e));
                str2 = null;
            }
            AppMethodBeat.m2505o(42369);
            return str2;
        }
    }

    /* renamed from: mI */
    public static String m85824mI(String str) {
        AppMethodBeat.m2504i(42370);
        C1720g.m3537RQ();
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null || !aoO.field_username.equals(str)) {
            AppMethodBeat.m2505o(42370);
            return null;
        }
        String str2 = aoO.field_nickname;
        AppMethodBeat.m2505o(42370);
        return str2;
    }

    static {
        AppMethodBeat.m2504i(42386);
        AppMethodBeat.m2505o(42386);
    }

    /* renamed from: eq */
    public static int m85817eq(Context context) {
        AppMethodBeat.m2504i(42371);
        if (nYd == BaseClientBuilder.API_PRIORITY_OTHER) {
            nYd = context.getResources().getColor(C25738R.color.f12133tk);
        }
        int i = nYd;
        AppMethodBeat.m2505o(42371);
        return i;
    }

    /* renamed from: dn */
    public static void m85815dn(final View view) {
        AppMethodBeat.m2504i(42372);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.4f, 0.96f, 0.4f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(42355);
                view.startAnimation(scaleAnimation2);
                AppMethodBeat.m2505o(42355);
            }
        });
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
        AppMethodBeat.m2505o(42372);
    }

    /* renamed from: a */
    public static void m85801a(final View view, AnimationListener animationListener) {
        AppMethodBeat.m2504i(42373);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(42356);
                view.startAnimation(scaleAnimation2);
                AppMethodBeat.m2505o(42356);
            }
        });
        if (animationListener != null) {
            scaleAnimation2.setAnimationListener(animationListener);
        }
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
        AppMethodBeat.m2505o(42373);
    }

    /* renamed from: b */
    public static void m85810b(Button button) {
        AppMethodBeat.m2504i(42374);
        C46063x.m85812c(button);
        AppMethodBeat.m2505o(42374);
    }

    /* renamed from: c */
    public static void m85812c(Button button) {
        AppMethodBeat.m2504i(42375);
        if (button == null) {
            AppMethodBeat.m2505o(42375);
            return;
        }
        button.setBackgroundResource(C25738R.drawable.f6723o4);
        AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        AppMethodBeat.m2505o(42375);
    }

    /* renamed from: d */
    public static void m85814d(Button button) {
        AppMethodBeat.m2504i(42376);
        if (button == null) {
            AppMethodBeat.m2505o(42376);
        } else if (button.getBackground() instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            AppMethodBeat.m2505o(42376);
        } else {
            AppMethodBeat.m2505o(42376);
        }
    }

    /* renamed from: E */
    public static boolean m85797E(String str, String str2, int i) {
        AppMethodBeat.m2504i(42377);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.LuckyMoneyUtil", C5046bo.nullAsNil(str) + ", " + C5046bo.nullAsNil(str2));
            AppMethodBeat.m2505o(42377);
            return false;
        }
        C7620bi c7620bi = new C7620bi();
        c7620bi.setContent(str);
        c7620bi.setStatus(2);
        c7620bi.mo14794ju(str2);
        c7620bi.mo14775eJ(C1829bf.m3756oC(str2));
        c7620bi.mo14781hO(1);
        if (i == 3) {
            c7620bi.setType(469762097);
        } else {
            c7620bi.setType(436207665);
        }
        long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
        if (Z < 0) {
            C4990ab.m7412e("MicroMsg.LuckyMoneyUtil", C1447g.m3075Mq() + "insert msg failed :" + Z);
            AppMethodBeat.m2505o(42377);
            return false;
        }
        if (c7620bi.bAA()) {
            C45457b.fRa.mo73256a(c7620bi, C1191k.m2615k(c7620bi));
        } else {
            C45457b.fRa.mo73265j(c7620bi);
        }
        c7620bi.setMsgId(Z);
        C8909j c8909j = new C8909j();
        c8909j.field_xml = c7620bi.field_content;
        String anj = C5046bo.anj(str);
        C8910b c8910b = null;
        if (anj != null) {
            c8910b = C8910b.m16058X(anj, c7620bi.field_reserved);
            if (c8910b != null) {
                c8909j.field_title = c8910b.title;
                c8909j.field_description = c8910b.description;
            }
        }
        c8909j.field_type = 2001;
        c8909j.field_msgId = Z;
        if (c8910b != null && c8910b.type == 2001 && c8910b.showType == 1) {
            if (TextUtils.isEmpty(c8910b.fic) || TextUtils.isEmpty(c8910b.fid) || c8910b.fie <= 0) {
                C4990ab.m7412e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
            } else {
                C4990ab.m7416i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
                C41963al c41963al = new C41963al();
                c41963al.ctv = new C37689a();
                c41963al.ctv.cty = c8910b.fid;
                c41963al.ctv.ctw = c8910b.fic;
                c41963al.ctv.ctz = c8910b.fie;
                C4879a.xxA.mo10055m(c41963al);
            }
        }
        C8909j ma = C34832a.bYK().mo27204ma(Z);
        if (ma != null && ma.field_msgId == Z) {
            C34832a.bYK().mo10103c(c8909j, new String[0]);
        } else if (!C34832a.bYK().mo10101b((C4925c) c8909j)) {
            C4990ab.m7412e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(Z)));
        }
        AppMethodBeat.m2505o(42377);
        return true;
    }

    /* renamed from: a */
    public static boolean m85808a(Activity activity, int i, C1207m c1207m, Bundle bundle, boolean z, C30857a c30857a, int i2) {
        AppMethodBeat.m2504i(42378);
        C4990ab.m7416i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
        if (i != 416) {
            C4990ab.m7416i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
            AppMethodBeat.m2505o(42378);
            return false;
        }
        boolean a = C46063x.m85809a(activity, c1207m, bundle, z, c30857a, i2);
        AppMethodBeat.m2505o(42378);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m85809a(Activity activity, C1207m c1207m, Bundle bundle, boolean z, C30857a c30857a, int i) {
        JSONObject jSONObject;
        Object obj;
        AppMethodBeat.m2504i(42379);
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (c1207m != null && (c1207m instanceof C28429z)) {
            C7472b c7472b = ((C28429z) c1207m).ehh;
            if (c7472b != null) {
                atm atm = (atm) c7472b.fsH.fsP;
                if (atm.wxA != null) {
                    try {
                        jSONObject = new JSONObject(C1946aa.m4153b(atm.wxA));
                    } catch (JSONException e) {
                        C4990ab.printErrStackTrace("MicroMsg.LuckyMoneyUtil", e, "", new Object[0]);
                    }
                    if (jSONObject == null) {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
                        if (jSONObject.has("real_name_info")) {
                            jSONObject = jSONObject.optJSONObject("real_name_info");
                        }
                        str = jSONObject.optString("guide_flag", "");
                        str2 = jSONObject.optString("guide_wording");
                        str3 = jSONObject.optString("left_button_wording", activity.getString(C25738R.string.f9076or));
                        str4 = jSONObject.optString("right_button_wording", activity.getString(C25738R.string.f9187s6));
                        str5 = jSONObject.optString("upload_credit_url", "");
                        obj = str;
                    } else {
                        String obj2 = str;
                    }
                    boolean a;
                    if (!"1".equals(obj2)) {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
                        a = C43795a.m78493a(activity, bundle, c30857a, i);
                        AppMethodBeat.m2505o(42379);
                        return a;
                    } else if (!"2".equals(obj2) || C5046bo.isNullOrNil(str5)) {
                        C4990ab.m7412e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + obj2 + ";upload_credit_url=null?" + C5046bo.isNullOrNil(str5));
                        AppMethodBeat.m2505o(42379);
                        return false;
                    } else {
                        C4990ab.m7416i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
                        a = C43795a.m78495a(activity, str2, str5, str3, str4, z, null);
                        AppMethodBeat.m2505o(42379);
                        return a;
                    }
                }
            }
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
        if (!"1".equals(obj2)) {
        }
    }

    /* renamed from: Qk */
    public static String m85799Qk(String str) {
        AppMethodBeat.m2504i(42380);
        String str2;
        if (C5046bo.isNullOrNil(str) || !C1720g.m3531RK()) {
            str2 = "";
            AppMethodBeat.m2505o(42380);
            return str2;
        }
        r2 = new Object[2];
        C1720g.m3537RQ();
        r2[0] = C1720g.m3536RP().eJM;
        r2[1] = "LuckyMoney";
        File file = new File(String.format("%s/%s/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        str2 = new File(file, str).getAbsolutePath();
        AppMethodBeat.m2505o(42380);
        return str2;
    }

    /* renamed from: cl */
    public static String m85813cl(List<C43255as> list) {
        AppMethodBeat.m2504i(42381);
        String str;
        if (list == null || list.size() == 0) {
            C4990ab.m7412e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
            str = "";
            AppMethodBeat.m2505o(42381);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C43255as c43255as = (C43255as) list.get(i2);
                if (c43255as != null) {
                    if (i2 != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(c43255as.type);
                    stringBuilder.append("|");
                    stringBuilder.append(c43255as.name);
                }
                i = i2 + 1;
            } else {
                str = stringBuilder.toString();
                AppMethodBeat.m2505o(42381);
                return str;
            }
        }
    }

    /* renamed from: eV */
    public static void m85816eV(String str, String str2) {
        AppMethodBeat.m2504i(42382);
        if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2))) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo14781hO(0);
            c7620bi.mo14794ju(str2);
            c7620bi.setStatus(3);
            c7620bi.setContent(str);
            c7620bi.mo14775eJ(C1829bf.m3764q(str2, System.currentTimeMillis() / 1000));
            c7620bi.setType(Downloads.MIN_WAIT_FOR_NETWORK);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
        }
        AppMethodBeat.m2505o(42382);
    }

    /* renamed from: a */
    public static void m85806a(StringBuilder stringBuilder, EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(42383);
        C46063x.m85807a(stringBuilder, emojiInfo, 0);
        AppMethodBeat.m2505o(42383);
    }

    /* renamed from: a */
    public static void m85807a(StringBuilder stringBuilder, EmojiInfo emojiInfo, int i) {
        AppMethodBeat.m2504i(42384);
        if (emojiInfo == null) {
            emojiInfo = new EmojiInfo();
        }
        stringBuilder.append("<emoji>");
        stringBuilder.append("<localreceivestatus>").append(i).append("</localreceivestatus>");
        stringBuilder.append("<md5>").append(C8910b.m16065mf(emojiInfo.field_md5)).append("</md5>");
        stringBuilder.append("<type>").append(emojiInfo.field_type).append("</type>");
        stringBuilder.append("<width>").append(emojiInfo.field_width).append("</width>");
        stringBuilder.append("<height>").append(emojiInfo.field_height).append("</height>");
        stringBuilder.append("<len>").append(emojiInfo.field_size).append("</len>");
        stringBuilder.append("<aeskey>").append(C8910b.m16065mf(emojiInfo.field_aeskey)).append("</aeskey>");
        stringBuilder.append("<cdnurl>").append(C8910b.m16065mf(emojiInfo.field_cdnUrl)).append("</cdnurl>");
        stringBuilder.append("<encrypturl>").append(C8910b.m16065mf(emojiInfo.field_encrypturl)).append("</encrypturl>");
        stringBuilder.append("<externurl>").append(C8910b.m16065mf(emojiInfo.field_externUrl)).append("</externurl>");
        stringBuilder.append("<externmd5>").append(C8910b.m16065mf(emojiInfo.field_externMd5)).append("</externmd5>");
        stringBuilder.append("<productid>").append(C8910b.m16065mf(emojiInfo.field_groupId)).append("</productid>");
        stringBuilder.append("<designerid>").append(C8910b.m16065mf(emojiInfo.field_designerID)).append("</designerid>");
        stringBuilder.append("<attachedtext>").append(C8910b.m16065mf(emojiInfo.field_attachedText)).append("</attachedtext>");
        stringBuilder.append("</emoji>");
        AppMethodBeat.m2505o(42384);
    }

    /* renamed from: er */
    public static Dialog m85818er(Context context) {
        AppMethodBeat.m2504i(42385);
        C44275p a = C30379h.m48426a(context, 3, (int) C25738R.style.f10970kd, context.getString(C25738R.string.cn5), false, new C460623());
        AppMethodBeat.m2505o(42385);
        return a;
    }

    /* renamed from: k */
    public static void m85821k(ImageView imageView, String str) {
        AppMethodBeat.m2504i(42358);
        C46063x.m85803a(imageView, str, null, true);
        AppMethodBeat.m2505o(42358);
    }

    /* renamed from: h */
    public static void m85819h(ImageView imageView, String str) {
        AppMethodBeat.m2504i(42361);
        C46063x.m85803a(imageView, str, null, false);
        AppMethodBeat.m2505o(42361);
    }
}
