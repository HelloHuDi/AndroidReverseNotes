package com.tencent.mm.plugin.luckymoney.model;

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
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.af.k;
import com.tencent.mm.ah.h;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.al;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.pluginsdk.f.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class x {
    private static f<String, Bitmap> mkq = new b(10, x.class);
    public static int nYd = BaseClientBuilder.API_PRIORITY_OTHER;

    public static String j(Context context, long j) {
        AppMethodBeat.i(42357);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        String str;
        if (j < 3600000) {
            str = "";
            AppMethodBeat.o(42357);
            return str;
        }
        long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > 86400000) {
            Time time = new Time();
            time.set(j);
            str = g.a(context.getString(R.string.bwy, new Object[]{" "}), time).toString();
            AppMethodBeat.o(42357);
            return str;
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(j));
        AppMethodBeat.o(42357);
        return str;
    }

    private static void a(ImageView imageView, String str, String str2, boolean z) {
        AppMethodBeat.i(42359);
        ab.i("MicroMsg.LuckyMoneyUtil", "load url: %s", str);
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        if (!bo.isNullOrNil(str)) {
            a aVar = new a();
            com.tencent.mm.plugin.luckymoney.b.a.bKN();
            aVar.ePK = com.tencent.mm.plugin.luckymoney.b.a.bKP();
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.eQf = z;
            if (z) {
                aVar.eQg = 0.0f;
            }
            if (bo.isNullOrNil(str2)) {
                aVar.ePP = false;
            } else {
                aVar.cvZ = str2;
                aVar.ePP = true;
            }
            o.ahp().a(str, imageView, aVar.ahG());
        }
        AppMethodBeat.o(42359);
    }

    public static void a(ImageView imageView, String str, String str2) {
        AppMethodBeat.i(42360);
        a(imageView, str, str2, false);
        AppMethodBeat.o(42360);
    }

    public static void l(ImageView imageView, String str) {
        AppMethodBeat.i(42362);
        if (imageView == null) {
            AppMethodBeat.o(42362);
            return;
        }
        imageView.setImageBitmap(null);
        if (!bo.isNullOrNil(str)) {
            a aVar = new a();
            com.tencent.mm.plugin.luckymoney.b.a.bKN();
            aVar.ePK = com.tencent.mm.plugin.luckymoney.b.a.bKP();
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.eQf = false;
            aVar.ePT = R.drawable.b9z;
            o.ahp().a(str, imageView, aVar.ahG());
        }
        AppMethodBeat.o(42362);
    }

    public static void b(ImageView imageView, String str, String str2) {
        AppMethodBeat.i(42363);
        if (imageView == null) {
            AppMethodBeat.o(42363);
            return;
        }
        if (bo.isNullOrNil(str2)) {
            str2 = com.tencent.mm.ah.o.acv().qc(str);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str2, 0.1f, false);
        AppMethodBeat.o(42363);
    }

    public static void m(ImageView imageView, String str) {
        AppMethodBeat.i(42364);
        if (imageView == null) {
            AppMethodBeat.o(42364);
            return;
        }
        imageView.setImageBitmap(null);
        if (!bo.isNullOrNil(str)) {
            a aVar = new a();
            com.tencent.mm.plugin.luckymoney.b.a.bKN();
            aVar.ePK = com.tencent.mm.plugin.luckymoney.b.a.bKP();
            aVar.ePH = true;
            aVar.ePZ = true;
            aVar.eQf = true;
            aVar.fHe = 1;
            aVar.ePT = R.drawable.b8q;
            o.ahp().a(str, imageView, aVar.ahG());
        }
        AppMethodBeat.o(42364);
    }

    public static void a(Context context, TextView textView, String str) {
        AppMethodBeat.i(42365);
        if (textView == null) {
            AppMethodBeat.o(42365);
            return;
        }
        textView.setText(j.b(context, (CharSequence) str, textView.getTextSize()));
        AppMethodBeat.o(42365);
    }

    public static void a(MMActivity mMActivity, int i, int i2, boolean z) {
        AppMethodBeat.i(42366);
        if (i != 0 || i2 <= 1) {
            a(mMActivity, 2, z);
            AppMethodBeat.o(42366);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(mMActivity, SelectLuckyMoneyContactUI.class);
        intent.putExtra("key_friends_num", i2);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        mMActivity.startActivityForResult(intent, 2);
        AppMethodBeat.o(42366);
    }

    public static void a(MMActivity mMActivity, int i, boolean z) {
        AppMethodBeat.i(42367);
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        d.b((Context) mMActivity, ".ui.transmit.SelectConversationUI", intent, i);
        AppMethodBeat.o(42367);
    }

    public static String bLC() {
        AppMethodBeat.i(42368);
        com.tencent.mm.kernel.g.RQ();
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_SELFINFO_SMALLIMGURL_STRING, null);
        AppMethodBeat.o(42368);
        return str;
    }

    public static String Qj(String str) {
        AppMethodBeat.i(42369);
        h qo = com.tencent.mm.ah.o.act().qo(str);
        if (qo != null) {
            String acl = qo.acl();
            AppMethodBeat.o(42369);
            return acl;
        }
        com.tencent.mm.kernel.g.RQ();
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
        if (aoO == null || !aoO.field_username.equals(str)) {
            AppMethodBeat.o(42369);
            return null;
        } else if (aoO.dtR == 4) {
            AppMethodBeat.o(42369);
            return null;
        } else {
            com.tencent.mm.kernel.g.RQ();
            byte[] aoS = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoS(str);
            if (bo.cb(aoS)) {
                AppMethodBeat.o(42369);
                return null;
            }
            String str2;
            try {
                str2 = ((bbv) new bbv().parseFrom(aoS)).vXn;
            } catch (Exception e) {
                ab.e("MicroMsg.LuckyMoneyUtil", "exception:%s", bo.l(e));
                str2 = null;
            }
            AppMethodBeat.o(42369);
            return str2;
        }
    }

    public static String mI(String str) {
        AppMethodBeat.i(42370);
        com.tencent.mm.kernel.g.RQ();
        ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str);
        if (aoO == null || !aoO.field_username.equals(str)) {
            AppMethodBeat.o(42370);
            return null;
        }
        String str2 = aoO.field_nickname;
        AppMethodBeat.o(42370);
        return str2;
    }

    static {
        AppMethodBeat.i(42386);
        AppMethodBeat.o(42386);
    }

    public static int eq(Context context) {
        AppMethodBeat.i(42371);
        if (nYd == BaseClientBuilder.API_PRIORITY_OTHER) {
            nYd = context.getResources().getColor(R.color.tk);
        }
        int i = nYd;
        AppMethodBeat.o(42371);
        return i;
    }

    public static void dn(final View view) {
        AppMethodBeat.i(42372);
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
                AppMethodBeat.i(42355);
                view.startAnimation(scaleAnimation2);
                AppMethodBeat.o(42355);
            }
        });
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
        AppMethodBeat.o(42372);
    }

    public static void a(final View view, AnimationListener animationListener) {
        AppMethodBeat.i(42373);
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
                AppMethodBeat.i(42356);
                view.startAnimation(scaleAnimation2);
                AppMethodBeat.o(42356);
            }
        });
        if (animationListener != null) {
            scaleAnimation2.setAnimationListener(animationListener);
        }
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
        AppMethodBeat.o(42373);
    }

    public static void b(Button button) {
        AppMethodBeat.i(42374);
        c(button);
        AppMethodBeat.o(42374);
    }

    public static void c(Button button) {
        AppMethodBeat.i(42375);
        if (button == null) {
            AppMethodBeat.o(42375);
            return;
        }
        button.setBackgroundResource(R.drawable.o4);
        AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        AppMethodBeat.o(42375);
    }

    public static void d(Button button) {
        AppMethodBeat.i(42376);
        if (button == null) {
            AppMethodBeat.o(42376);
        } else if (button.getBackground() instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            AppMethodBeat.o(42376);
        } else {
            AppMethodBeat.o(42376);
        }
    }

    public static boolean E(String str, String str2, int i) {
        AppMethodBeat.i(42377);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.LuckyMoneyUtil", bo.nullAsNil(str) + ", " + bo.nullAsNil(str2));
            AppMethodBeat.o(42377);
            return false;
        }
        bi biVar = new bi();
        biVar.setContent(str);
        biVar.setStatus(2);
        biVar.ju(str2);
        biVar.eJ(bf.oC(str2));
        biVar.hO(1);
        if (i == 3) {
            biVar.setType(469762097);
        } else {
            biVar.setType(436207665);
        }
        long Z = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar);
        if (Z < 0) {
            ab.e("MicroMsg.LuckyMoneyUtil", com.tencent.mm.compatible.util.g.Mq() + "insert msg failed :" + Z);
            AppMethodBeat.o(42377);
            return false;
        }
        if (biVar.bAA()) {
            com.tencent.mm.modelstat.b.fRa.a(biVar, k.k(biVar));
        } else {
            com.tencent.mm.modelstat.b.fRa.j(biVar);
        }
        biVar.setMsgId(Z);
        com.tencent.mm.af.j jVar = new com.tencent.mm.af.j();
        jVar.field_xml = biVar.field_content;
        String anj = bo.anj(str);
        com.tencent.mm.af.j.b bVar = null;
        if (anj != null) {
            bVar = com.tencent.mm.af.j.b.X(anj, biVar.field_reserved);
            if (bVar != null) {
                jVar.field_title = bVar.title;
                jVar.field_description = bVar.description;
            }
        }
        jVar.field_type = 2001;
        jVar.field_msgId = Z;
        if (bVar != null && bVar.type == 2001 && bVar.showType == 1) {
            if (TextUtils.isEmpty(bVar.fic) || TextUtils.isEmpty(bVar.fid) || bVar.fie <= 0) {
                ab.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
            } else {
                ab.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
                al alVar = new al();
                alVar.ctv = new al.a();
                alVar.ctv.cty = bVar.fid;
                alVar.ctv.ctw = bVar.fic;
                alVar.ctv.ctz = bVar.fie;
                com.tencent.mm.sdk.b.a.xxA.m(alVar);
            }
        }
        com.tencent.mm.af.j ma = com.tencent.mm.plugin.s.a.bYK().ma(Z);
        if (ma != null && ma.field_msgId == Z) {
            com.tencent.mm.plugin.s.a.bYK().c(jVar, new String[0]);
        } else if (!com.tencent.mm.plugin.s.a.bYK().b((c) jVar)) {
            ab.e("MicroMsg.LuckyMoneyUtil", "PinOpenApi.getAppMessageStorage().insert msg failed id:".concat(String.valueOf(Z)));
        }
        AppMethodBeat.o(42377);
        return true;
    }

    public static boolean a(Activity activity, int i, m mVar, Bundle bundle, boolean z, com.tencent.mm.wallet_core.c.a aVar, int i2) {
        AppMethodBeat.i(42378);
        ab.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
        if (i != 416) {
            ab.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
            AppMethodBeat.o(42378);
            return false;
        }
        boolean a = a(activity, mVar, bundle, z, aVar, i2);
        AppMethodBeat.o(42378);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(Activity activity, m mVar, Bundle bundle, boolean z, com.tencent.mm.wallet_core.c.a aVar, int i) {
        JSONObject jSONObject;
        Object obj;
        AppMethodBeat.i(42379);
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (mVar != null && (mVar instanceof z)) {
            com.tencent.mm.ai.b bVar = ((z) mVar).ehh;
            if (bVar != null) {
                atm atm = (atm) bVar.fsH.fsP;
                if (atm.wxA != null) {
                    try {
                        jSONObject = new JSONObject(aa.b(atm.wxA));
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.LuckyMoneyUtil", e, "", new Object[0]);
                    }
                    if (jSONObject == null) {
                        ab.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
                        if (jSONObject.has("real_name_info")) {
                            jSONObject = jSONObject.optJSONObject("real_name_info");
                        }
                        str = jSONObject.optString("guide_flag", "");
                        str2 = jSONObject.optString("guide_wording");
                        str3 = jSONObject.optString("left_button_wording", activity.getString(R.string.or));
                        str4 = jSONObject.optString("right_button_wording", activity.getString(R.string.s6));
                        str5 = jSONObject.optString("upload_credit_url", "");
                        obj = str;
                    } else {
                        String obj2 = str;
                    }
                    boolean a;
                    if (!"1".equals(obj2)) {
                        ab.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
                        a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, aVar, i);
                        AppMethodBeat.o(42379);
                        return a;
                    } else if (!"2".equals(obj2) || bo.isNullOrNil(str5)) {
                        ab.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + obj2 + ";upload_credit_url=null?" + bo.isNullOrNil(str5));
                        AppMethodBeat.o(42379);
                        return false;
                    } else {
                        ab.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
                        a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, str2, str5, str3, str4, z, null);
                        AppMethodBeat.o(42379);
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

    public static String Qk(String str) {
        AppMethodBeat.i(42380);
        String str2;
        if (bo.isNullOrNil(str) || !com.tencent.mm.kernel.g.RK()) {
            str2 = "";
            AppMethodBeat.o(42380);
            return str2;
        }
        r2 = new Object[2];
        com.tencent.mm.kernel.g.RQ();
        r2[0] = com.tencent.mm.kernel.g.RP().eJM;
        r2[1] = "LuckyMoney";
        File file = new File(String.format("%s/%s/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        str2 = new File(file, str).getAbsolutePath();
        AppMethodBeat.o(42380);
        return str2;
    }

    public static String cl(List<as> list) {
        AppMethodBeat.i(42381);
        String str;
        if (list == null || list.size() == 0) {
            ab.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
            str = "";
            AppMethodBeat.o(42381);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                as asVar = (as) list.get(i2);
                if (asVar != null) {
                    if (i2 != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(asVar.type);
                    stringBuilder.append("|");
                    stringBuilder.append(asVar.name);
                }
                i = i2 + 1;
            } else {
                str = stringBuilder.toString();
                AppMethodBeat.o(42381);
                return str;
            }
        }
    }

    public static void eV(String str, String str2) {
        AppMethodBeat.i(42382);
        if (!(bo.isNullOrNil(str) || bo.isNullOrNil(str2))) {
            bi biVar = new bi();
            biVar.hO(0);
            biVar.ju(str2);
            biVar.setStatus(3);
            biVar.setContent(str);
            biVar.eJ(bf.q(str2, System.currentTimeMillis() / 1000));
            biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar);
        }
        AppMethodBeat.o(42382);
    }

    public static void a(StringBuilder stringBuilder, EmojiInfo emojiInfo) {
        AppMethodBeat.i(42383);
        a(stringBuilder, emojiInfo, 0);
        AppMethodBeat.o(42383);
    }

    public static void a(StringBuilder stringBuilder, EmojiInfo emojiInfo, int i) {
        AppMethodBeat.i(42384);
        if (emojiInfo == null) {
            emojiInfo = new EmojiInfo();
        }
        stringBuilder.append("<emoji>");
        stringBuilder.append("<localreceivestatus>").append(i).append("</localreceivestatus>");
        stringBuilder.append("<md5>").append(com.tencent.mm.af.j.b.mf(emojiInfo.field_md5)).append("</md5>");
        stringBuilder.append("<type>").append(emojiInfo.field_type).append("</type>");
        stringBuilder.append("<width>").append(emojiInfo.field_width).append("</width>");
        stringBuilder.append("<height>").append(emojiInfo.field_height).append("</height>");
        stringBuilder.append("<len>").append(emojiInfo.field_size).append("</len>");
        stringBuilder.append("<aeskey>").append(com.tencent.mm.af.j.b.mf(emojiInfo.field_aeskey)).append("</aeskey>");
        stringBuilder.append("<cdnurl>").append(com.tencent.mm.af.j.b.mf(emojiInfo.field_cdnUrl)).append("</cdnurl>");
        stringBuilder.append("<encrypturl>").append(com.tencent.mm.af.j.b.mf(emojiInfo.field_encrypturl)).append("</encrypturl>");
        stringBuilder.append("<externurl>").append(com.tencent.mm.af.j.b.mf(emojiInfo.field_externUrl)).append("</externurl>");
        stringBuilder.append("<externmd5>").append(com.tencent.mm.af.j.b.mf(emojiInfo.field_externMd5)).append("</externmd5>");
        stringBuilder.append("<productid>").append(com.tencent.mm.af.j.b.mf(emojiInfo.field_groupId)).append("</productid>");
        stringBuilder.append("<designerid>").append(com.tencent.mm.af.j.b.mf(emojiInfo.field_designerID)).append("</designerid>");
        stringBuilder.append("<attachedtext>").append(com.tencent.mm.af.j.b.mf(emojiInfo.field_attachedText)).append("</attachedtext>");
        stringBuilder.append("</emoji>");
        AppMethodBeat.o(42384);
    }

    public static Dialog er(Context context) {
        AppMethodBeat.i(42385);
        p a = com.tencent.mm.ui.base.h.a(context, 3, (int) R.style.kd, context.getString(R.string.cn5), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(42385);
        return a;
    }

    public static void k(ImageView imageView, String str) {
        AppMethodBeat.i(42358);
        a(imageView, str, null, true);
        AppMethodBeat.o(42358);
    }

    public static void h(ImageView imageView, String str) {
        AppMethodBeat.i(42361);
        a(imageView, str, null, false);
        AppMethodBeat.o(42361);
    }
}
