package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.transmit.SelectConversationUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.chatting.e */
public final class C15636e {

    /* renamed from: com.tencent.mm.ui.chatting.e$c */
    public interface C15637c {
        /* renamed from: a */
        boolean mo27871a(String str, Context context, MMFragment mMFragment, String str2);
    }

    /* renamed from: com.tencent.mm.ui.chatting.e$a */
    static final class C15638a implements C15637c {
        C15638a() {
        }

        /* renamed from: a */
        public final boolean mo27871a(String str, Context context, MMFragment mMFragment, String str2) {
            AppMethodBeat.m2504i(30451);
            Intent intent;
            if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendnormalhbrequest")) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_type", 0);
                C25985d.m41467b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent2);
                AppMethodBeat.m2505o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendrandomhbrequest")) {
                intent = new Intent();
                intent.putExtra("key_type", 1);
                C25985d.m41467b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                AppMethodBeat.m2505o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendhblistrequest")) {
                intent = new Intent();
                intent.putExtra("key_type", 1);
                C25985d.m41467b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                AppMethodBeat.m2505o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivehblistrequest")) {
                intent = new Intent();
                intent.putExtra("key_type", 2);
                C25985d.m41467b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                AppMethodBeat.m2505o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/openDetail")) {
                intent = new Intent();
                intent.putExtra("key_native_url", str);
                C25985d.m41467b(context, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent);
                AppMethodBeat.m2505o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                intent = new Intent();
                intent.putExtra("key_way", 5);
                intent.putExtra("key_native_url", str);
                intent.putExtra("key_static_from_scene", 1);
                C25985d.m41467b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                AppMethodBeat.m2505o(30451);
                return true;
            } else {
                AppMethodBeat.m2505o(30451);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.e$b */
    static final class C15639b implements C15637c {
        C15639b() {
        }

        public static boolean ara(String str) {
            AppMethodBeat.m2504i(30452);
            if (str == null || !(str.startsWith("weixin://openNativeUrl/myDeviceList") || str.startsWith("weixin://openNativeUrl/bindMyDevice"))) {
                AppMethodBeat.m2505o(30452);
                return false;
            }
            AppMethodBeat.m2505o(30452);
            return true;
        }

        /* renamed from: a */
        public final boolean mo27871a(String str, Context context, MMFragment mMFragment, String str2) {
            AppMethodBeat.m2504i(30453);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(30453);
                return false;
            } else if (str.startsWith("weixin://openNativeUrl/myDeviceList")) {
                Intent intent = new Intent();
                intent.putExtra("device_brand_name", str2);
                C25985d.m41467b(context, "exdevice", ".ui.ExdeviceManageDeviceUI", intent);
                AppMethodBeat.m2505o(30453);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/bindMyDevice")) {
                AppMethodBeat.m2505o(30453);
                return false;
            } else {
                AppMethodBeat.m2505o(30453);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.e$d */
    static final class C15640d implements C15637c {
        C15640d() {
        }

        public static boolean ara(String str) {
            AppMethodBeat.m2504i(30454);
            if (str == null || !(str.startsWith("weixin://wesport/recommend") || str.startsWith("weixin://openNativeUrl/rankMyHomepage") || str.startsWith("weixin://openNativeUrl/rankSetting"))) {
                AppMethodBeat.m2505o(30454);
                return false;
            }
            AppMethodBeat.m2505o(30454);
            return true;
        }

        /* renamed from: a */
        public final boolean mo27871a(String str, Context context, MMFragment mMFragment, String str2) {
            AppMethodBeat.m2504i(30455);
            Intent intent;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7410d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
                AppMethodBeat.m2505o(30455);
                return false;
            } else if (str.startsWith("weixin://wesport/recommend") && mMFragment != null) {
                intent = new Intent(context, SelectConversationUI.class);
                intent.putExtra("Select_Talker_Name", str2);
                intent.putExtra("Select_block_List", str2);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("Select_Send_Card", true);
                mMFragment.startActivityForResult(intent, 224);
                AppMethodBeat.m2505o(30455);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/rankMyHomepage")) {
                String Yz = C1853r.m3846Yz();
                if (C5046bo.isNullOrNil(Yz)) {
                    C4990ab.m7412e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
                    AppMethodBeat.m2505o(30455);
                    return false;
                }
                intent = new Intent();
                intent.putExtra("username", Yz);
                C25985d.m41467b(context, "exdevice", ".ui.ExdeviceProfileUI", intent);
                C4990ab.m7416i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
                AppMethodBeat.m2505o(30455);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/rankSetting")) {
                C25985d.m41448H(context, "exdevice", ".ui.ExdeviceSettingUI");
                AppMethodBeat.m2505o(30455);
                return true;
            } else {
                AppMethodBeat.m2505o(30455);
                return false;
            }
        }
    }

    /* renamed from: a */
    public static boolean m23923a(String str, Context context, MMFragment mMFragment, String str2) {
        AppMethodBeat.m2504i(30456);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(30456);
            return false;
        }
        C15637c c15637c = null;
        if (str.startsWith("weixin://openNativeUrl/weixinHB")) {
            c15637c = new C15638a();
        } else if (C15639b.ara(str)) {
            c15637c = new C15639b();
        } else if (C15640d.ara(str)) {
            c15637c = new C15640d();
        }
        if (c15637c == null || !c15637c.mo27871a(str, context, mMFragment, str2)) {
            AppMethodBeat.m2505o(30456);
            return false;
        }
        AppMethodBeat.m2505o(30456);
        return true;
    }
}
