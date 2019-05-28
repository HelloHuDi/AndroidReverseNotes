package com.tencent.p177mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendAuth;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Resp;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C5068w;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ReportUtil */
public final class ReportUtil {

    /* renamed from: com.tencent.mm.pluginsdk.model.app.ReportUtil$ReportArgs */
    public static class ReportArgs implements Parcelable {
        public static final Creator<ReportArgs> CREATOR = new C148701();
        /* renamed from: Cn */
        public int f2971Cn;
        /* renamed from: Iw */
        public String f2972Iw;
        public int errCode;
        public String openId;
        public String transaction;

        /* renamed from: com.tencent.mm.pluginsdk.model.app.ReportUtil$ReportArgs$1 */
        static class C148701 implements Creator<ReportArgs> {
            C148701() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ReportArgs[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(27384);
                ReportArgs reportArgs = new ReportArgs(parcel, (byte) 0);
                AppMethodBeat.m2505o(27384);
                return reportArgs;
            }
        }

        /* synthetic */ ReportArgs(Parcel parcel, byte b) {
            this(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(27385);
            parcel.writeString(this.f2972Iw);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.transaction);
            parcel.writeString(this.openId);
            AppMethodBeat.m2505o(27385);
        }

        static {
            AppMethodBeat.m2504i(27387);
            AppMethodBeat.m2505o(27387);
        }

        private ReportArgs(Parcel parcel) {
            AppMethodBeat.m2504i(27386);
            this.f2972Iw = parcel.readString();
            this.errCode = parcel.readInt();
            this.transaction = parcel.readString();
            this.openId = parcel.readString();
            AppMethodBeat.m2505o(27386);
        }
    }

    /* renamed from: F */
    public static void m79190F(boolean z, int i) {
        AppMethodBeat.m2504i(27388);
        C32800b y = C37922v.m64076Zp().mo60676y("kWXEntryActivity_data_center_session_id", true);
        if (y != null) {
            String string = y.getString("kWXEntryActivity_data_center_app_id", "");
            boolean z2 = y.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
            int i2 = y.getInt("kWXEntryActivity_data_center_msg_type", 0);
            int i3 = y.getInt("kWXEntryActivity_data_center_scene", 0);
            if (z) {
                i = -2;
            }
            int i4 = z2 ? 0 : -1;
            C7060h.pYm.mo8381e(15632, string, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4));
        }
        AppMethodBeat.m2505o(27388);
    }

    /* renamed from: a */
    public static void m79192a(Context context, ReportArgs reportArgs, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(27389);
        C32800b y = C37922v.m64076Zp().mo60676y("kWXEntryActivity_data_center_session_id", true);
        if (y != null) {
            z2 = y.getBoolean("kWXEntryActivity_data_center_can_return_cancel", false);
        }
        ReportUtil.m79190F(z, reportArgs.errCode);
        if (z2 && z) {
            reportArgs.errCode = -2;
        }
        ReportUtil.m79191a(context, reportArgs);
        AppMethodBeat.m2505o(27389);
    }

    /* renamed from: a */
    public static void m79191a(Context context, ReportArgs reportArgs) {
        AppMethodBeat.m2504i(27390);
        if (reportArgs.f2971Cn == 1) {
            ReportUtil.m79194b(context, reportArgs);
            AppMethodBeat.m2505o(27390);
            return;
        }
        Resp resp = new Resp();
        resp.errCode = reportArgs.errCode;
        resp.transaction = reportArgs.transaction;
        resp.openId = reportArgs.openId;
        Bundle bundle = new Bundle();
        resp.toBundle(bundle);
        C35799p.m58687at(bundle);
        Args args = new Args();
        args.targetPkgName = reportArgs.f2972Iw;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
        AppMethodBeat.m2505o(27390);
    }

    /* renamed from: b */
    private static void m79194b(Context context, ReportArgs reportArgs) {
        AppMethodBeat.m2504i(27391);
        SendAuth.Resp resp = new SendAuth.Resp();
        resp.transaction = reportArgs.transaction;
        resp.errCode = reportArgs.errCode;
        resp.openId = reportArgs.openId;
        Bundle bundle = new Bundle();
        resp.toBundle(bundle);
        C35799p.m58687at(bundle);
        Args args = new Args();
        args.targetPkgName = reportArgs.f2972Iw;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
        AppMethodBeat.m2505o(27391);
    }

    /* renamed from: c */
    public static ReportArgs m79195c(Bundle bundle, int i) {
        AppMethodBeat.m2504i(27392);
        String string = bundle.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            String string2 = bundle.getString(ConstantsAPI.CONTENT);
            if (string2 != null) {
                string = Uri.parse(string2).getQueryParameter("appid");
            }
        }
        if (string == null) {
            string = C5068w.m7687l(bundle, "_wxapi_payreq_appid");
            if (string == null) {
                AppMethodBeat.m2505o(27392);
                return null;
            }
        }
        C40439f c40439f = new C40439f();
        c40439f.field_appId = string;
        if (C9638aw.m17192ZM() && C9638aw.m17179RK()) {
            C14877am.bYJ().mo10102b((C4925c) c40439f, new String[0]);
        } else {
            c40439f.field_packageName = bundle.getString(ConstantsAPI.APP_PACKAGE);
        }
        ReportArgs reportArgs = new ReportArgs();
        reportArgs.f2972Iw = c40439f.field_packageName;
        reportArgs.errCode = i;
        reportArgs.transaction = ReportUtil.m79193av(bundle);
        reportArgs.openId = c40439f.field_openId;
        reportArgs.f2971Cn = bundle.getInt("_wxapi_command_type");
        AppMethodBeat.m2505o(27392);
        return reportArgs;
    }

    /* renamed from: av */
    private static String m79193av(Bundle bundle) {
        AppMethodBeat.m2504i(27393);
        Req req = new Req();
        req.fromBundle(bundle);
        String str = req.transaction;
        AppMethodBeat.m2505o(27393);
        return str;
    }
}
