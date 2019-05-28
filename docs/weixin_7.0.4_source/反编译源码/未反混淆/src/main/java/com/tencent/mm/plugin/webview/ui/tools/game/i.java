package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.a.a.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {

    public interface a {
        void d(String str, JSONObject jSONObject);
    }

    public static void a(final Context context, final com.tencent.mm.plugin.downloader_app.b.a aVar, final a aVar2) {
        AppMethodBeat.i(8799);
        if (aVar == null || !aVar.isValid()) {
            aVar2.d("fail", null);
            AppMethodBeat.o(8799);
        } else if (!at.isNetworkConnected(context)) {
            aVar2.d("network_not_connected", null);
            com.tencent.mm.ce.a.q(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8781);
                    Toast.makeText(context, context.getString(R.string.c5d), 0).show();
                    AppMethodBeat.o(8781);
                }
            });
            ab.i("MicroMsg.JsApiGameDownloadManager", " fail, network not ready");
            AppMethodBeat.o(8799);
        } else if (!f.Mn()) {
            aVar2.d("sdcard_not_ready", null);
            com.tencent.mm.ce.a.q(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8791);
                    Toast.makeText(context, context.getString(R.string.c5h), 0).show();
                    AppMethodBeat.o(8791);
                }
            });
            ab.i("MicroMsg.JsApiGameDownloadManager", " fail, sdcard not ready");
            AppMethodBeat.o(8799);
        } else if (aVar.kOC <= 0 || f.eW(aVar.kOC)) {
            com.tencent.mm.plugin.downloader.f.a Iq = c.Iq(aVar.downloadUrl);
            if (Iq != null) {
                FileDownloadTaskInfo hm = d.bij().hm(Iq.field_downloadId);
                if (hm != null) {
                    if (hm.status == 1) {
                        aVar2.d(null, null);
                        AppMethodBeat.o(8799);
                        return;
                    } else if (hm.status == 3) {
                        com.tencent.mm.plugin.downloader.h.a.a(hm.id, false, null);
                        aVar2.d(null, null);
                        AppMethodBeat.o(8799);
                        return;
                    } else if (aVar.kNt && Iq.field_reserveInWifi && !at.isWifi(context)) {
                        a(context, Iq.field_downloadId, aVar2);
                        AppMethodBeat.o(8799);
                        return;
                    }
                }
            }
            if (at.isWifi(context)) {
                a(aVar, aVar2, false);
                AppMethodBeat.o(8799);
            } else if (aVar.kNt) {
                final PBool pBool = new PBool();
                ((com.tencent.mm.plugin.downloader_app.a.c) g.K(com.tencent.mm.plugin.downloader_app.a.c.class)).a(context, aVar.appId, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(8793);
                        pBool.value = true;
                        i.a(aVar, aVar2, false);
                        AppMethodBeat.o(8793);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(8794);
                        pBool.value = true;
                        i.a(aVar, aVar2, true);
                        AppMethodBeat.o(8794);
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(8795);
                        if (pBool.value) {
                            AppMethodBeat.o(8795);
                            return;
                        }
                        aVar2.d("cancel", null);
                        AppMethodBeat.o(8795);
                    }
                });
                AppMethodBeat.o(8799);
            } else {
                h.a(context, context.getString(R.string.fy6), context.getString(R.string.fy7), context.getString(R.string.fy1), context.getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(8796);
                        i.a(aVar, aVar2, false);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(8796);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(8797);
                        dialogInterface.dismiss();
                        aVar2.d("network_not_wifi", null);
                        AppMethodBeat.o(8797);
                    }
                }, (int) R.color.a61);
                AppMethodBeat.o(8799);
            }
        } else {
            aVar2.d("has_not_enough_space", null);
            com.tencent.mm.plugin.webview.luggage.c.c.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8792);
                    Toast.makeText(context, context.getString(R.string.c5e), 0).show();
                    AppMethodBeat.o(8792);
                }
            });
            ab.i("MicroMsg.JsApiGameDownloadManager", "fail, not enough space, require size = " + aVar.kOC);
            AppMethodBeat.o(8799);
        }
    }

    static void a(com.tencent.mm.plugin.downloader_app.b.a aVar, final a aVar2, boolean z) {
        AppMethodBeat.i(8800);
        aVar.kNt = z;
        ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).a(aVar, new b() {
            public final void a(com.tencent.mm.plugin.downloader_app.a.a.a aVar, long j) {
                AppMethodBeat.i(8798);
                JSONObject jSONObject = new JSONObject();
                if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.OK) {
                    com.tencent.mm.modelstat.d.b(10, "LuggageGameWebViewUI_addGameDownloadTask", "JsApiGameDownloadManager".hashCode());
                    try {
                        jSONObject.put("download_id", j);
                        aVar2.d(null, jSONObject);
                        AppMethodBeat.o(8798);
                    } catch (JSONException e) {
                        aVar2.d(null, null);
                        AppMethodBeat.o(8798);
                    }
                } else if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.WAIT_FOR_WIFI) {
                    try {
                        jSONObject.put("download_id", j);
                        jSONObject.put("reserve_for_wifi", 1);
                        aVar2.d(null, jSONObject);
                        AppMethodBeat.o(8798);
                    } catch (JSONException e2) {
                        aVar2.d(null, null);
                        AppMethodBeat.o(8798);
                    }
                } else if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.CANCEL) {
                    aVar2.d("cancel", null);
                    AppMethodBeat.o(8798);
                } else {
                    if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.FAIL) {
                        aVar2.d("fail", null);
                    }
                    AppMethodBeat.o(8798);
                }
            }
        });
        AppMethodBeat.o(8800);
    }

    public static void a(Context context, long j, boolean z, final a aVar) {
        AppMethodBeat.i(8801);
        if (j <= 0) {
            ab.e("MicroMsg.JsApiGameDownloadManager", "fail, invalid downloadId = ".concat(String.valueOf(j)));
            aVar.d("invalid_downloadid", null);
            AppMethodBeat.o(8801);
            return;
        }
        final com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null) {
            aVar.d("fail", null);
            AppMethodBeat.o(8801);
            return;
        }
        FileDownloadTaskInfo hm = d.bij().hm(hv.field_downloadId);
        if (hm != null) {
            if (hm.status == 1) {
                aVar.d(null, null);
                AppMethodBeat.o(8801);
                return;
            } else if (hm.status == 3) {
                com.tencent.mm.plugin.downloader.h.a.a(hm.id, false, null);
                aVar.d(null, null);
                AppMethodBeat.o(8801);
                return;
            }
        }
        if (at.isWifi(context)) {
            a(hv, false, aVar);
            AppMethodBeat.o(8801);
        } else if (!z) {
            if (hv.field_reserveInWifi) {
                hv.field_downloadInWifi = false;
                hv.field_reserveInWifi = false;
                c.e(hv);
            }
            h.a(context, context.getString(R.string.fy6), context.getString(R.string.fy7), context.getString(R.string.fy1), context.getString(R.string.or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(8785);
                    i.a(hv, false, aVar);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(8785);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(8786);
                    dialogInterface.dismiss();
                    aVar.d("fail_network_not_wifi", null);
                    AppMethodBeat.o(8786);
                }
            }, (int) R.color.a61);
            AppMethodBeat.o(8801);
        } else if (hv.field_reserveInWifi) {
            a(context, hv.field_downloadId, aVar);
            AppMethodBeat.o(8801);
        } else {
            final PBool pBool = new PBool();
            ((com.tencent.mm.plugin.downloader_app.a.c) g.K(com.tencent.mm.plugin.downloader_app.a.c.class)).a(context, hv.field_appId, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(8782);
                    pBool.value = true;
                    i.a(hv, false, aVar);
                    AppMethodBeat.o(8782);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(8783);
                    pBool.value = true;
                    i.a(hv, true, aVar);
                    AppMethodBeat.o(8783);
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(8784);
                    if (pBool.value) {
                        AppMethodBeat.o(8784);
                        return;
                    }
                    aVar.d("cancel", null);
                    AppMethodBeat.o(8784);
                }
            });
            AppMethodBeat.o(8801);
        }
    }

    static void a(com.tencent.mm.plugin.downloader.f.a aVar, final boolean z, final a aVar2) {
        AppMethodBeat.i(8802);
        com.tencent.mm.modelstat.d.b(10, "LuggageGameWebViewUI_resumeGameDownloadTask", "JsApiGameDownloadManager".hashCode());
        ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).a(aVar.field_downloadId, z, new b() {
            public final void a(com.tencent.mm.plugin.downloader_app.a.a.a aVar, long j) {
                AppMethodBeat.i(8787);
                if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.OK) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("download_id", j);
                        if (z && !at.isWifi(ah.getContext())) {
                            jSONObject.put("reserve_for_wifi", 1);
                        }
                    } catch (JSONException e) {
                    }
                    aVar2.d(null, jSONObject);
                    AppMethodBeat.o(8787);
                } else if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.CANCEL) {
                    aVar2.d("cancel", null);
                    AppMethodBeat.o(8787);
                } else {
                    aVar2.d("fail", null);
                    AppMethodBeat.o(8787);
                }
            }
        });
        AppMethodBeat.o(8802);
    }

    private static void a(Context context, long j, final a aVar) {
        AppMethodBeat.i(8803);
        final com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null) {
            aVar.d("fail", null);
            AppMethodBeat.o(8803);
            return;
        }
        final PBool pBool = new PBool();
        final JSONObject jSONObject = new JSONObject();
        ((com.tencent.mm.plugin.downloader_app.a.c) g.K(com.tencent.mm.plugin.downloader_app.a.c.class)).b(context, hv.field_appId, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(8788);
                pBool.value = true;
                i.a(hv, false, aVar);
                AppMethodBeat.o(8788);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(8789);
                pBool.value = true;
                try {
                    jSONObject.put("reserve_for_wifi", 0);
                } catch (JSONException e) {
                }
                com.tencent.mm.plugin.downloader.f.a aVar = hv;
                hv.field_downloadInWifi = false;
                aVar.field_reserveInWifi = false;
                c.e(hv);
                if (hv.field_status == 0) {
                    ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).kP(hv.field_appId);
                }
                aVar.d(null, jSONObject);
                AppMethodBeat.o(8789);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(8790);
                if (pBool.value) {
                    AppMethodBeat.o(8790);
                    return;
                }
                aVar.d("cancel", null);
                AppMethodBeat.o(8790);
            }
        });
        AppMethodBeat.o(8803);
    }
}
