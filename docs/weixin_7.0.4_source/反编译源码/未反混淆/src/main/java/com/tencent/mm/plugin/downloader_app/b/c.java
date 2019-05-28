package com.tencent.mm.plugin.downloader_app.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.c.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static void a(Context context, i iVar) {
        AppMethodBeat.i(138734);
        a(context, iVar, false);
        AppMethodBeat.o(138734);
    }

    public static void a(Context context, i iVar, boolean z) {
        AppMethodBeat.i(136099);
        if (!z) {
            a.a(10, a.tQ(iVar.type), iVar.position, 23, iVar.appId, "", "");
        }
        b(context, iVar, z);
        AppMethodBeat.o(136099);
    }

    private static void b(Context context, i iVar, boolean z) {
        AppMethodBeat.i(138735);
        if (context == null || iVar == null) {
            AppMethodBeat.o(138735);
            return;
        }
        final a aVar = new a();
        aVar.downloadUrl = iVar.kPc.egm;
        aVar.kOB = iVar.kPc.kKV;
        aVar.appId = iVar.appId;
        aVar.appName = iVar.appName;
        aVar.kOC = iVar.kPc.kKP;
        aVar.kOD = iVar.kPc.kKQ;
        aVar.packageName = iVar.kPc.kKO;
        aVar.cBA = iVar.kPc.kKR;
        aVar.extInfo = biI();
        aVar.scene = z ? 6003 : 6002;
        aVar.kNt = iVar.kPc.kKX;
        aVar.fileType = 1;
        b.eBF.a(aVar.appId, aVar.scene, 9, -1, "", null);
        if (at.isConnected(context)) {
            a(context, aVar, null);
            AppMethodBeat.o(138735);
            return;
        }
        h.a(context, context.getString(R.string.d5t), context.getString(R.string.d5u), context.getString(R.string.ckt), false, new OnClickListener() {
            final /* synthetic */ com.tencent.mm.plugin.downloader_app.a.a.b kOH = null;

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(136085);
                com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(aVar.appId);
                if (In != null) {
                    In.field_status = 4;
                    com.tencent.mm.plugin.downloader.model.c.e(In);
                } else {
                    In = new com.tencent.mm.plugin.downloader.f.a();
                    In.field_downloadId = System.currentTimeMillis();
                    In.field_appId = aVar.appId;
                    In.field_downloadUrl = aVar.downloadUrl;
                    In.field_status = 4;
                    com.tencent.mm.plugin.downloader.model.c.d(In);
                }
                d.hD(In.field_downloadId);
                if (this.kOH != null) {
                    this.kOH.a(com.tencent.mm.plugin.downloader_app.a.a.a.FAIL, In.field_downloadId);
                }
                AppMethodBeat.o(136085);
            }
        });
        AppMethodBeat.o(138735);
    }

    public static void a(Context context, final a aVar, final com.tencent.mm.plugin.downloader_app.a.a.b bVar) {
        AppMethodBeat.i(136100);
        if (context == null || !aVar.isValid()) {
            AppMethodBeat.o(136100);
        } else if (at.isWifi(context)) {
            d.IF(aVar.appId);
            aVar.kNt = false;
            a(aVar, bVar);
            AppMethodBeat.o(136100);
        } else if (aVar.kNt) {
            ((com.tencent.mm.plugin.downloader_app.a.c) g.K(com.tencent.mm.plugin.downloader_app.a.c.class)).a(context, aVar.appId, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136092);
                    aVar.kNt = false;
                    c.a(aVar, bVar);
                    AppMethodBeat.o(136092);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136093);
                    c.a(aVar, bVar);
                    AppMethodBeat.o(136093);
                }
            }, null);
            AppMethodBeat.o(136100);
        } else {
            h.a(context, context.getString(R.string.fy6), context.getString(R.string.fy7), context.getString(R.string.fy1), context.getString(R.string.or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136094);
                    d.IF(aVar.appId);
                    aVar.kNt = false;
                    c.a(aVar, bVar);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(136094);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136095);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(136095);
                }
            }, (int) R.color.a61);
            AppMethodBeat.o(136100);
        }
    }

    public static long a(a aVar, com.tencent.mm.plugin.downloader_app.a.a.b bVar) {
        long b;
        AppMethodBeat.i(136101);
        if (!j.contains(aVar.appId)) {
            LinkedList biP = j.biP();
            biP.add(aVar.appId);
            g.a(biP, new g.a() {
                public final void gd(boolean z) {
                }
            });
            j.Iz(aVar.appId);
        }
        e.a aVar2 = new e.a();
        aVar2.It(aVar.downloadUrl);
        aVar2.Iu(aVar.kOB);
        aVar2.hA(aVar.kOC);
        aVar2.Iv(aVar.appName);
        aVar2.setAppId(aVar.appId);
        aVar2.Iw(aVar.kOD);
        aVar2.ga(true);
        aVar2.gb(false);
        aVar2.tN(aVar.fileType == 0 ? 1 : aVar.fileType);
        aVar2.cY(aVar.packageName);
        aVar2.bis();
        aVar2.setScene(aVar.scene);
        aVar2.Ix(aVar.extInfo);
        aVar2.gc(aVar.kNt);
        if (aVar.cBA == 1) {
            b = d.bij().b(aVar2.kNl);
        } else {
            b = d.bij().a(aVar2.kNl);
        }
        ab.i("MicroMsg.DownloadPluginUtil", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(b), aVar.appId, Integer.valueOf(aVar.cBA));
        if (bVar != null) {
            com.tencent.mm.plugin.downloader_app.a.a.a aVar3 = (!aVar.kNt || at.isWifi(ah.getContext())) ? b > 0 ? com.tencent.mm.plugin.downloader_app.a.a.a.OK : com.tencent.mm.plugin.downloader_app.a.a.a.FAIL : com.tencent.mm.plugin.downloader_app.a.a.a.WAIT_FOR_WIFI;
            bVar.a(aVar3, b);
        }
        if (aVar.kNt && !at.isWifi(ah.getContext())) {
            d.IG(aVar.appId);
        }
        com.tencent.mm.modelstat.d.b(10, "DownloadPluginUtil_downloadTaskStraight", c.class.hashCode());
        AppMethodBeat.o(136101);
        return b;
    }

    public static void a(Context context, i iVar, com.tencent.mm.plugin.downloader_app.a.a.b bVar) {
        AppMethodBeat.i(138736);
        a(context, iVar, true, bVar);
        AppMethodBeat.o(138736);
    }

    public static void a(Context context, i iVar, boolean z, com.tencent.mm.plugin.downloader_app.a.a.b bVar) {
        AppMethodBeat.i(136102);
        com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(iVar.appId);
        if (In != null) {
            In.field_extInfo = IE(In.field_extInfo);
            a(context, In, iVar, bVar);
            b.eBF.a(In.field_appId, In.field_scene, 10, In.field_startSize, In.field_downloadedSize - In.field_startSize, In.field_totalSize, In.field_downloadUrl, In.field_errCode, In.field_downloaderType, In.field_channelId, (System.currentTimeMillis() - In.field_startTime) / 1000, In.field_startState, In.field_downloadId, In.field_extInfo, 0);
        }
        if (z) {
            a.a(10, a.tQ(iVar.type), iVar.position, 6, iVar.appId, "", "");
        }
        AppMethodBeat.o(136102);
    }

    public static void a(Context context, final com.tencent.mm.plugin.downloader.f.a aVar, final i iVar, final com.tencent.mm.plugin.downloader_app.a.a.b bVar) {
        AppMethodBeat.i(136103);
        if (!at.isConnected(context)) {
            h.a(context, context.getString(R.string.d5t), context.getString(R.string.d5u), context.getString(R.string.ckt), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136096);
                    aVar.field_status = 4;
                    com.tencent.mm.plugin.downloader.model.c.e(aVar);
                    d.hD(aVar.field_downloadId);
                    if (bVar != null) {
                        bVar.a(com.tencent.mm.plugin.downloader_app.a.a.a.FAIL, aVar.field_downloadId);
                    }
                    if (bVar != null) {
                        bVar.a(com.tencent.mm.plugin.downloader_app.a.a.a.FAIL, aVar.field_downloadId);
                    }
                    AppMethodBeat.o(136096);
                }
            });
            AppMethodBeat.o(136103);
        } else if (at.isWifi(context)) {
            d.IF(aVar.field_appId);
            a(aVar, false, bVar);
            AppMethodBeat.o(136103);
        } else if (iVar.kPc.kKX) {
            ((com.tencent.mm.plugin.downloader_app.a.c) g.K(com.tencent.mm.plugin.downloader_app.a.c.class)).a(context, aVar.field_appId, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136097);
                    d.IF(aVar.field_appId);
                    c.a(aVar, false, bVar);
                    AppMethodBeat.o(136097);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136098);
                    if (!(aVar.field_reserveInWifi && aVar.field_downloadInWifi)) {
                        com.tencent.mm.plugin.downloader.f.a aVar = aVar;
                        aVar.field_downloadInWifi = true;
                        aVar.field_reserveInWifi = true;
                        com.tencent.mm.plugin.downloader.model.c.e(aVar);
                    }
                    bVar.a(com.tencent.mm.plugin.downloader_app.a.a.a.WAIT_FOR_WIFI, aVar.field_downloadId);
                    AppMethodBeat.o(136098);
                }
            }, null);
            AppMethodBeat.o(136103);
        } else {
            if (aVar.field_reserveInWifi) {
                aVar.field_downloadInWifi = false;
                aVar.field_reserveInWifi = false;
                com.tencent.mm.plugin.downloader.model.c.e(aVar);
            }
            h.a(context, context.getString(R.string.fy6), context.getString(R.string.fy7), context.getString(R.string.fy1), context.getString(R.string.or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136086);
                    d.IF(aVar.field_appId);
                    c.a(aVar, false, bVar);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(136086);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136087);
                    if (iVar != null) {
                        a.a(10, a.tQ(iVar.type), iVar.position, 4, iVar.appId, "", "");
                    }
                    dialogInterface.dismiss();
                    AppMethodBeat.o(136087);
                }
            }, (int) R.color.a61);
            AppMethodBeat.o(136103);
        }
    }

    public static boolean a(com.tencent.mm.plugin.downloader.f.a aVar, boolean z, com.tencent.mm.plugin.downloader_app.a.a.b bVar) {
        AppMethodBeat.i(136104);
        if (!j.contains(aVar.field_appId)) {
            LinkedList biP = j.biP();
            biP.add(aVar.field_appId);
            g.a(biP, null);
            j.Iz(aVar.field_appId);
        }
        aVar.field_showNotification = false;
        aVar.field_fromDownloadApp = true;
        aVar.field_downloadInWifi = z;
        aVar.field_reserveInWifi = z;
        com.tencent.mm.plugin.downloader.model.c.e(aVar);
        boolean ho = d.bij().ho(aVar.field_downloadId);
        if (bVar != null) {
            bVar.a(ho ? com.tencent.mm.plugin.downloader_app.a.a.a.OK : com.tencent.mm.plugin.downloader_app.a.a.a.FAIL, aVar.field_downloadId);
        }
        com.tencent.mm.modelstat.d.b(10, "DownloadPluginUtil_resumeDownloadTaskStraight", c.class.hashCode());
        AppMethodBeat.o(136104);
        return ho;
    }

    public static void a(i iVar) {
        AppMethodBeat.i(136105);
        com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(iVar.appId);
        if (In != null) {
            d.bij().hn(In.field_downloadId);
            a.a(10, a.tQ(iVar.type), iVar.position, 5, In.field_appId, "", "");
        }
        AppMethodBeat.o(136105);
    }

    public static void b(i iVar) {
        AppMethodBeat.i(138737);
        com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(iVar.appId);
        if (In != null) {
            d.bij().hl(In.field_downloadId);
        }
        a.a(11, a.tQ(iVar.type), iVar.position, 81, iVar.appId, "", "");
        AppMethodBeat.o(138737);
    }

    public static void a(Context context, final long j, final com.tencent.mm.plugin.downloader_app.a.a.b bVar) {
        AppMethodBeat.i(138738);
        final com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
        if (hv == null) {
            bVar.a(com.tencent.mm.plugin.downloader_app.a.a.a.FAIL, -1);
            AppMethodBeat.o(138738);
            return;
        }
        ((com.tencent.mm.plugin.downloader_app.a.c) g.K(com.tencent.mm.plugin.downloader_app.a.c.class)).b(context, hv.field_appId, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(136088);
                d.IF(hv.field_appId);
                c.a(hv, false, bVar);
                AppMethodBeat.o(136088);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(136089);
                com.tencent.mm.plugin.downloader.f.a aVar = hv;
                hv.field_downloadInWifi = false;
                aVar.field_reserveInWifi = false;
                com.tencent.mm.plugin.downloader.model.c.e(hv);
                if (hv.field_status == 0) {
                    d.IH(hv.field_appId);
                }
                if (bVar != null) {
                    bVar.a(com.tencent.mm.plugin.downloader_app.a.a.a.CANCEL, j);
                }
                AppMethodBeat.o(136089);
            }
        }, null);
        AppMethodBeat.o(138738);
    }

    public static boolean b(final Context context, final i iVar) {
        AppMethodBeat.i(136106);
        com.tencent.mm.plugin.downloader.f.a In = com.tencent.mm.plugin.downloader.model.c.In(iVar.appId);
        if (In == null) {
            AppMethodBeat.o(136106);
            return false;
        } else if (com.tencent.mm.vfs.e.ct(In.field_filePath)) {
            com.tencent.mm.plugin.downloader.h.a.a(In.field_downloadId, false, null);
            a.a(10, a.tQ(iVar.type), iVar.position, 44, iVar.appId, "", "");
            AppMethodBeat.o(136106);
            return true;
        } else {
            h.a(context, context.getString(R.string.db4), context.getString(R.string.db5), context.getString(R.string.dr0), context.getString(R.string.ev9), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136090);
                    c.a(context, iVar);
                    AppMethodBeat.o(136090);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(136106);
            return false;
        }
    }

    public static void c(final Context context, final i iVar) {
        AppMethodBeat.i(138739);
        if (p.u(context, iVar.kPc.kKO)) {
            com.tencent.mm.plugin.downloader.h.a.a(context, iVar.appId, null);
            a.a(10, a.tQ(iVar.type), iVar.position, 22, iVar.appId, "", "");
            AppMethodBeat.o(138739);
            return;
        }
        h.a(context, context.getString(R.string.u4), context.getString(R.string.u5), context.getString(R.string.dr0), context.getString(R.string.ev9), false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(136091);
                c.a(context, iVar);
                AppMethodBeat.o(136091);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(138739);
    }

    private static String biI() {
        AppMethodBeat.i(136107);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("DownloadInWidget", 1);
            jSONObject.put("OpInWidget", 1);
        } catch (JSONException e) {
        }
        String str = null;
        try {
            str = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e2) {
        }
        AppMethodBeat.o(136107);
        return str;
    }

    private static String IE(String str) {
        AppMethodBeat.i(136108);
        if (str == null || !str.contains("OpInWidget")) {
            JSONObject jSONObject;
            String str2;
            if (bo.isNullOrNil(str)) {
                jSONObject = null;
                str2 = str;
            } else {
                try {
                    str2 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding);
                } catch (UnsupportedEncodingException e) {
                    str2 = str;
                }
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Exception e2) {
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("OpInWidget", 1);
            } catch (JSONException e3) {
            }
            try {
                str2 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e4) {
            }
            AppMethodBeat.o(136108);
            return str2;
        }
        AppMethodBeat.o(136108);
        return str;
    }
}
