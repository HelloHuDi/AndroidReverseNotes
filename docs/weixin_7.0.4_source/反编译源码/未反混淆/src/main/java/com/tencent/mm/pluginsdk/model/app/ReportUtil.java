package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;

public final class ReportUtil {

    public static class ReportArgs implements Parcelable {
        public static final Creator<ReportArgs> CREATOR = new Creator<ReportArgs>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ReportArgs[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(27384);
                ReportArgs reportArgs = new ReportArgs(parcel, (byte) 0);
                AppMethodBeat.o(27384);
                return reportArgs;
            }
        };
        public int Cn;
        public String Iw;
        public int errCode;
        public String openId;
        public String transaction;

        /* synthetic */ ReportArgs(Parcel parcel, byte b) {
            this(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(27385);
            parcel.writeString(this.Iw);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.transaction);
            parcel.writeString(this.openId);
            AppMethodBeat.o(27385);
        }

        static {
            AppMethodBeat.i(27387);
            AppMethodBeat.o(27387);
        }

        private ReportArgs(Parcel parcel) {
            AppMethodBeat.i(27386);
            this.Iw = parcel.readString();
            this.errCode = parcel.readInt();
            this.transaction = parcel.readString();
            this.openId = parcel.readString();
            AppMethodBeat.o(27386);
        }
    }

    public static void F(boolean z, int i) {
        AppMethodBeat.i(27388);
        b y = v.Zp().y("kWXEntryActivity_data_center_session_id", true);
        if (y != null) {
            String string = y.getString("kWXEntryActivity_data_center_app_id", "");
            boolean z2 = y.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
            int i2 = y.getInt("kWXEntryActivity_data_center_msg_type", 0);
            int i3 = y.getInt("kWXEntryActivity_data_center_scene", 0);
            if (z) {
                i = -2;
            }
            int i4 = z2 ? 0 : -1;
            h.pYm.e(15632, string, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4));
        }
        AppMethodBeat.o(27388);
    }

    public static void a(Context context, ReportArgs reportArgs, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(27389);
        b y = v.Zp().y("kWXEntryActivity_data_center_session_id", true);
        if (y != null) {
            z2 = y.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
        }
        F(z, reportArgs.errCode);
        if (z2 && z) {
            reportArgs.errCode = -2;
        }
        a(context, reportArgs);
        AppMethodBeat.o(27389);
    }

    public static void a(Context context, ReportArgs reportArgs) {
        AppMethodBeat.i(27390);
        if (reportArgs.Cn == 1) {
            b(context, reportArgs);
            AppMethodBeat.o(27390);
            return;
        }
        Resp resp = new Resp();
        resp.errCode = reportArgs.errCode;
        resp.transaction = reportArgs.transaction;
        resp.openId = reportArgs.openId;
        Bundle bundle = new Bundle();
        resp.toBundle(bundle);
        p.at(bundle);
        Args args = new Args();
        args.targetPkgName = reportArgs.Iw;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
        AppMethodBeat.o(27390);
    }

    private static void b(Context context, ReportArgs reportArgs) {
        AppMethodBeat.i(27391);
        SendAuth.Resp resp = new SendAuth.Resp();
        resp.transaction = reportArgs.transaction;
        resp.errCode = reportArgs.errCode;
        resp.openId = reportArgs.openId;
        Bundle bundle = new Bundle();
        resp.toBundle(bundle);
        p.at(bundle);
        Args args = new Args();
        args.targetPkgName = reportArgs.Iw;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
        AppMethodBeat.o(27391);
    }

    public static ReportArgs c(Bundle bundle, int i) {
        AppMethodBeat.i(27392);
        String string = bundle.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            String string2 = bundle.getString(ConstantsAPI.CONTENT);
            if (string2 != null) {
                string = Uri.parse(string2).getQueryParameter("appid");
            }
        }
        if (string == null) {
            string = w.l(bundle, "_wxapi_payreq_appid");
            if (string == null) {
                AppMethodBeat.o(27392);
                return null;
            }
        }
        f fVar = new f();
        fVar.field_appId = string;
        if (aw.ZM() && aw.RK()) {
            am.bYJ().b((c) fVar, new String[0]);
        } else {
            fVar.field_packageName = bundle.getString(ConstantsAPI.APP_PACKAGE);
        }
        ReportArgs reportArgs = new ReportArgs();
        reportArgs.Iw = fVar.field_packageName;
        reportArgs.errCode = i;
        reportArgs.transaction = av(bundle);
        reportArgs.openId = fVar.field_openId;
        reportArgs.Cn = bundle.getInt("_wxapi_command_type");
        AppMethodBeat.o(27392);
        return reportArgs;
    }

    private static String av(Bundle bundle) {
        AppMethodBeat.i(27393);
        Req req = new Req();
        req.fromBundle(bundle);
        String str = req.transaction;
        AppMethodBeat.o(27393);
        return str;
    }
}
