package com.tencent.p177mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.booter.w */
public final class C41906w {
    Context context;

    /* renamed from: com.tencent.mm.booter.w$1 */
    public class C419071 implements Runnable {
        /* JADX WARNING: Removed duplicated region for block: B:12:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x00bf  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0135  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0135  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            String str;
            Throwable e;
            AppMethodBeat.m2504i(15873);
            long anU = C42252ah.anU();
            Process.setThreadPriority(10);
            C41906w c41906w = C41906w.this;
            int i = C5059g.cdf;
            String LM = C1427q.m3028LM();
            int i2 = C7243d.vxo;
            String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            String dor = C4988aa.dor();
            int i3 = c41906w.context.getSharedPreferences(C4996ah.doA(), 0).getInt("last_reportdevice_channel", 0);
            int i4 = c41906w.context.getSharedPreferences(C4996ah.doA(), 0).getInt("last_reportdevice_clientversion", 0);
            if (i3 == 0 && i4 == 0) {
                i4 = 0;
            } else if (i3 == i && i4 == i2) {
                str = null;
                C4990ab.m7417i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str);
                if (C42252ah.isNullOrNil(str)) {
                    C1936u a;
                    try {
                        a = C1897b.m4020a(str, null);
                        try {
                            a.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                            a.setReadTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                            a.connect();
                            if (a.getResponseCode() == 200) {
                                C41906w c41906w2 = C41906w.this;
                                i2 = C5059g.cdf;
                                int i5 = C7243d.vxo;
                                SharedPreferences sharedPreferences = c41906w2.context.getSharedPreferences(C4996ah.doA(), 0);
                                sharedPreferences.edit().putInt("last_reportdevice_channel", i2).commit();
                                sharedPreferences.edit().putInt("last_reportdevice_clientversion", i5).commit();
                            }
                            C4990ab.m7411d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", Long.valueOf(C42252ah.m74623gb(anU)), Integer.valueOf(r3), str);
                        } catch (Exception e2) {
                            e = e2;
                            C4990ab.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                            C4990ab.m7413e("MicroMsg.StartupReport", "tryReport error url[%s]", str);
                            if (a != null) {
                            }
                            AppMethodBeat.m2505o(15873);
                            return;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        a = null;
                        C4990ab.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                        C4990ab.m7413e("MicroMsg.StartupReport", "tryReport error url[%s]", str);
                        if (a != null) {
                        }
                        AppMethodBeat.m2505o(15873);
                        return;
                    }
                    if (a != null) {
                        a.connection.disconnect();
                    }
                    AppMethodBeat.m2505o(15873);
                    return;
                }
                AppMethodBeat.m2505o(15873);
                return;
            } else {
                i4 = 1;
            }
            str = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/reportdevice?channel=" + C5059g.cdf + "&deviceid=" + LM + "&clientversion=" + i2 + "&platform=" + str2 + "&lang=" + dor + "&installtype=" + i4;
            C4990ab.m7417i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str);
            if (C42252ah.isNullOrNil(str)) {
            }
        }
    }

    public C41906w(Context context) {
        this.context = context;
    }
}
