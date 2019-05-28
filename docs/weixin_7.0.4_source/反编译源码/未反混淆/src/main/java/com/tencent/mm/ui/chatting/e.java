package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.transmit.SelectConversationUI;

public final class e {

    public interface c {
        boolean a(String str, Context context, MMFragment mMFragment, String str2);
    }

    static final class a implements c {
        a() {
        }

        public final boolean a(String str, Context context, MMFragment mMFragment, String str2) {
            AppMethodBeat.i(30451);
            Intent intent;
            if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendnormalhbrequest")) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_type", 0);
                com.tencent.mm.bp.d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent2);
                AppMethodBeat.o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendrandomhbrequest")) {
                intent = new Intent();
                intent.putExtra("key_type", 1);
                com.tencent.mm.bp.d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                AppMethodBeat.o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendhblistrequest")) {
                intent = new Intent();
                intent.putExtra("key_type", 1);
                com.tencent.mm.bp.d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                AppMethodBeat.o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivehblistrequest")) {
                intent = new Intent();
                intent.putExtra("key_type", 2);
                com.tencent.mm.bp.d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", intent);
                AppMethodBeat.o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/openDetail")) {
                intent = new Intent();
                intent.putExtra("key_native_url", str);
                com.tencent.mm.bp.d.b(context, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent);
                AppMethodBeat.o(30451);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                intent = new Intent();
                intent.putExtra("key_way", 5);
                intent.putExtra("key_native_url", str);
                intent.putExtra("key_static_from_scene", 1);
                com.tencent.mm.bp.d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent);
                AppMethodBeat.o(30451);
                return true;
            } else {
                AppMethodBeat.o(30451);
                return false;
            }
        }
    }

    static final class b implements c {
        b() {
        }

        public static boolean ara(String str) {
            AppMethodBeat.i(30452);
            if (str == null || !(str.startsWith("weixin://openNativeUrl/myDeviceList") || str.startsWith("weixin://openNativeUrl/bindMyDevice"))) {
                AppMethodBeat.o(30452);
                return false;
            }
            AppMethodBeat.o(30452);
            return true;
        }

        public final boolean a(String str, Context context, MMFragment mMFragment, String str2) {
            AppMethodBeat.i(30453);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(30453);
                return false;
            } else if (str.startsWith("weixin://openNativeUrl/myDeviceList")) {
                Intent intent = new Intent();
                intent.putExtra("device_brand_name", str2);
                com.tencent.mm.bp.d.b(context, "exdevice", ".ui.ExdeviceManageDeviceUI", intent);
                AppMethodBeat.o(30453);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/bindMyDevice")) {
                AppMethodBeat.o(30453);
                return false;
            } else {
                AppMethodBeat.o(30453);
                return false;
            }
        }
    }

    static final class d implements c {
        d() {
        }

        public static boolean ara(String str) {
            AppMethodBeat.i(30454);
            if (str == null || !(str.startsWith("weixin://wesport/recommend") || str.startsWith("weixin://openNativeUrl/rankMyHomepage") || str.startsWith("weixin://openNativeUrl/rankSetting"))) {
                AppMethodBeat.o(30454);
                return false;
            }
            AppMethodBeat.o(30454);
            return true;
        }

        public final boolean a(String str, Context context, MMFragment mMFragment, String str2) {
            AppMethodBeat.i(30455);
            Intent intent;
            if (bo.isNullOrNil(str)) {
                ab.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
                AppMethodBeat.o(30455);
                return false;
            } else if (str.startsWith("weixin://wesport/recommend") && mMFragment != null) {
                intent = new Intent(context, SelectConversationUI.class);
                intent.putExtra("Select_Talker_Name", str2);
                intent.putExtra("Select_block_List", str2);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("Select_Send_Card", true);
                mMFragment.startActivityForResult(intent, 224);
                AppMethodBeat.o(30455);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/rankMyHomepage")) {
                String Yz = r.Yz();
                if (bo.isNullOrNil(Yz)) {
                    ab.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
                    AppMethodBeat.o(30455);
                    return false;
                }
                intent = new Intent();
                intent.putExtra("username", Yz);
                com.tencent.mm.bp.d.b(context, "exdevice", ".ui.ExdeviceProfileUI", intent);
                ab.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
                AppMethodBeat.o(30455);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/rankSetting")) {
                com.tencent.mm.bp.d.H(context, "exdevice", ".ui.ExdeviceSettingUI");
                AppMethodBeat.o(30455);
                return true;
            } else {
                AppMethodBeat.o(30455);
                return false;
            }
        }
    }

    public static boolean a(String str, Context context, MMFragment mMFragment, String str2) {
        AppMethodBeat.i(30456);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(30456);
            return false;
        }
        c cVar = null;
        if (str.startsWith("weixin://openNativeUrl/weixinHB")) {
            cVar = new a();
        } else if (b.ara(str)) {
            cVar = new b();
        } else if (d.ara(str)) {
            cVar = new d();
        }
        if (cVar == null || !cVar.a(str, context, mMFragment, str2)) {
            AppMethodBeat.o(30456);
            return false;
        }
        AppMethodBeat.o(30456);
        return true;
    }
}
