package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20331a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20332b;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C45832c;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45833a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.i */
public final class C35675i {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.i$a */
    public interface C4624a {
        /* renamed from: d */
        void mo9715d(String str, JSONObject jSONObject);
    }

    /* renamed from: a */
    public static void m58527a(final Context context, final C45833a c45833a, final C4624a c4624a) {
        AppMethodBeat.m2504i(8799);
        if (c45833a == null || !c45833a.isValid()) {
            c4624a.mo9715d("fail", null);
            AppMethodBeat.m2505o(8799);
        } else if (!C5023at.isNetworkConnected(context)) {
            c4624a.mo9715d("network_not_connected", null);
            C26006a.m41506q(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8781);
                    Toast.makeText(context, context.getString(C25738R.string.c5d), 0).show();
                    AppMethodBeat.m2505o(8781);
                }
            });
            C4990ab.m7416i("MicroMsg.JsApiGameDownloadManager", " fail, network not ready");
            AppMethodBeat.m2505o(8799);
        } else if (!C1445f.m3070Mn()) {
            c4624a.mo9715d("sdcard_not_ready", null);
            C26006a.m41506q(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8791);
                    Toast.makeText(context, context.getString(C25738R.string.c5h), 0).show();
                    AppMethodBeat.m2505o(8791);
                }
            });
            C4990ab.m7416i("MicroMsg.JsApiGameDownloadManager", " fail, sdcard not ready");
            AppMethodBeat.m2505o(8799);
        } else if (c45833a.kOC <= 0 || C1445f.m3072eW(c45833a.kOC)) {
            C42911a Iq = C2895c.m5143Iq(c45833a.downloadUrl);
            if (Iq != null) {
                FileDownloadTaskInfo hm = C2896d.bij().mo7048hm(Iq.field_downloadId);
                if (hm != null) {
                    if (hm.status == 1) {
                        c4624a.mo9715d(null, null);
                        AppMethodBeat.m2505o(8799);
                        return;
                    } else if (hm.status == 3) {
                        C33913a.m55499a(hm.f16167id, false, null);
                        c4624a.mo9715d(null, null);
                        AppMethodBeat.m2505o(8799);
                        return;
                    } else if (c45833a.kNt && Iq.field_reserveInWifi && !C5023at.isWifi(context)) {
                        C35675i.m58525a(context, Iq.field_downloadId, c4624a);
                        AppMethodBeat.m2505o(8799);
                        return;
                    }
                }
            }
            if (C5023at.isWifi(context)) {
                C35675i.m58529a(c45833a, c4624a, false);
                AppMethodBeat.m2505o(8799);
            } else if (c45833a.kNt) {
                final PBool pBool = new PBool();
                ((C45832c) C1720g.m3528K(C45832c.class)).mo68447a(context, c45833a.appId, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(8793);
                        pBool.value = true;
                        C35675i.m58529a(c45833a, c4624a, false);
                        AppMethodBeat.m2505o(8793);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(8794);
                        pBool.value = true;
                        C35675i.m58529a(c45833a, c4624a, true);
                        AppMethodBeat.m2505o(8794);
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(8795);
                        if (pBool.value) {
                            AppMethodBeat.m2505o(8795);
                            return;
                        }
                        c4624a.mo9715d("cancel", null);
                        AppMethodBeat.m2505o(8795);
                    }
                });
                AppMethodBeat.m2505o(8799);
            } else {
                C30379h.m48446a(context, context.getString(C25738R.string.fy6), context.getString(C25738R.string.fy7), context.getString(C25738R.string.fy1), context.getString(C25738R.string.f9076or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(8796);
                        C35675i.m58529a(c45833a, c4624a, false);
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(8796);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(8797);
                        dialogInterface.dismiss();
                        c4624a.mo9715d("network_not_wifi", null);
                        AppMethodBeat.m2505o(8797);
                    }
                }, (int) C25738R.color.a61);
                AppMethodBeat.m2505o(8799);
            }
        } else {
            c4624a.mo9715d("has_not_enough_space", null);
            C29782c.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8792);
                    Toast.makeText(context, context.getString(C25738R.string.c5e), 0).show();
                    AppMethodBeat.m2505o(8792);
                }
            });
            C4990ab.m7416i("MicroMsg.JsApiGameDownloadManager", "fail, not enough space, require size = " + c45833a.kOC);
            AppMethodBeat.m2505o(8799);
        }
    }

    /* renamed from: a */
    static void m58529a(C45833a c45833a, final C4624a c4624a, boolean z) {
        AppMethodBeat.m2504i(8800);
        c45833a.kNt = z;
        ((C38855d) C1720g.m3528K(C38855d.class)).mo61726a(c45833a, new C20332b() {
            /* renamed from: a */
            public final void mo9713a(C20331a c20331a, long j) {
                AppMethodBeat.m2504i(8798);
                JSONObject jSONObject = new JSONObject();
                if (c20331a == C20331a.OK) {
                    C26483d.m42196b(10, "LuggageGameWebViewUI_addGameDownloadTask", "JsApiGameDownloadManager".hashCode());
                    try {
                        jSONObject.put("download_id", j);
                        c4624a.mo9715d(null, jSONObject);
                        AppMethodBeat.m2505o(8798);
                    } catch (JSONException e) {
                        c4624a.mo9715d(null, null);
                        AppMethodBeat.m2505o(8798);
                    }
                } else if (c20331a == C20331a.WAIT_FOR_WIFI) {
                    try {
                        jSONObject.put("download_id", j);
                        jSONObject.put("reserve_for_wifi", 1);
                        c4624a.mo9715d(null, jSONObject);
                        AppMethodBeat.m2505o(8798);
                    } catch (JSONException e2) {
                        c4624a.mo9715d(null, null);
                        AppMethodBeat.m2505o(8798);
                    }
                } else if (c20331a == C20331a.CANCEL) {
                    c4624a.mo9715d("cancel", null);
                    AppMethodBeat.m2505o(8798);
                } else {
                    if (c20331a == C20331a.FAIL) {
                        c4624a.mo9715d("fail", null);
                    }
                    AppMethodBeat.m2505o(8798);
                }
            }
        });
        AppMethodBeat.m2505o(8800);
    }

    /* renamed from: a */
    public static void m58526a(Context context, long j, boolean z, final C4624a c4624a) {
        AppMethodBeat.m2504i(8801);
        if (j <= 0) {
            C4990ab.m7412e("MicroMsg.JsApiGameDownloadManager", "fail, invalid downloadId = ".concat(String.valueOf(j)));
            c4624a.mo9715d("invalid_downloadid", null);
            AppMethodBeat.m2505o(8801);
            return;
        }
        final C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            c4624a.mo9715d("fail", null);
            AppMethodBeat.m2505o(8801);
            return;
        }
        FileDownloadTaskInfo hm = C2896d.bij().mo7048hm(hv.field_downloadId);
        if (hm != null) {
            if (hm.status == 1) {
                c4624a.mo9715d(null, null);
                AppMethodBeat.m2505o(8801);
                return;
            } else if (hm.status == 3) {
                C33913a.m55499a(hm.f16167id, false, null);
                c4624a.mo9715d(null, null);
                AppMethodBeat.m2505o(8801);
                return;
            }
        }
        if (C5023at.isWifi(context)) {
            C35675i.m58528a(hv, false, c4624a);
            AppMethodBeat.m2505o(8801);
        } else if (!z) {
            if (hv.field_reserveInWifi) {
                hv.field_downloadInWifi = false;
                hv.field_reserveInWifi = false;
                C2895c.m5146e(hv);
            }
            C30379h.m48446a(context, context.getString(C25738R.string.fy6), context.getString(C25738R.string.fy7), context.getString(C25738R.string.fy1), context.getString(C25738R.string.f9076or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(8785);
                    C35675i.m58528a(hv, false, c4624a);
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(8785);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(8786);
                    dialogInterface.dismiss();
                    c4624a.mo9715d("fail_network_not_wifi", null);
                    AppMethodBeat.m2505o(8786);
                }
            }, (int) C25738R.color.a61);
            AppMethodBeat.m2505o(8801);
        } else if (hv.field_reserveInWifi) {
            C35675i.m58525a(context, hv.field_downloadId, c4624a);
            AppMethodBeat.m2505o(8801);
        } else {
            final PBool pBool = new PBool();
            ((C45832c) C1720g.m3528K(C45832c.class)).mo68447a(context, hv.field_appId, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(8782);
                    pBool.value = true;
                    C35675i.m58528a(hv, false, c4624a);
                    AppMethodBeat.m2505o(8782);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(8783);
                    pBool.value = true;
                    C35675i.m58528a(hv, true, c4624a);
                    AppMethodBeat.m2505o(8783);
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(8784);
                    if (pBool.value) {
                        AppMethodBeat.m2505o(8784);
                        return;
                    }
                    c4624a.mo9715d("cancel", null);
                    AppMethodBeat.m2505o(8784);
                }
            });
            AppMethodBeat.m2505o(8801);
        }
    }

    /* renamed from: a */
    static void m58528a(C42911a c42911a, final boolean z, final C4624a c4624a) {
        AppMethodBeat.m2504i(8802);
        C26483d.m42196b(10, "LuggageGameWebViewUI_resumeGameDownloadTask", "JsApiGameDownloadManager".hashCode());
        ((C38855d) C1720g.m3528K(C38855d.class)).mo61728a(c42911a.field_downloadId, z, new C20332b() {
            /* renamed from: a */
            public final void mo9713a(C20331a c20331a, long j) {
                AppMethodBeat.m2504i(8787);
                if (c20331a == C20331a.OK) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("download_id", j);
                        if (z && !C5023at.isWifi(C4996ah.getContext())) {
                            jSONObject.put("reserve_for_wifi", 1);
                        }
                    } catch (JSONException e) {
                    }
                    c4624a.mo9715d(null, jSONObject);
                    AppMethodBeat.m2505o(8787);
                } else if (c20331a == C20331a.CANCEL) {
                    c4624a.mo9715d("cancel", null);
                    AppMethodBeat.m2505o(8787);
                } else {
                    c4624a.mo9715d("fail", null);
                    AppMethodBeat.m2505o(8787);
                }
            }
        });
        AppMethodBeat.m2505o(8802);
    }

    /* renamed from: a */
    private static void m58525a(Context context, long j, final C4624a c4624a) {
        AppMethodBeat.m2504i(8803);
        final C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            c4624a.mo9715d("fail", null);
            AppMethodBeat.m2505o(8803);
            return;
        }
        final PBool pBool = new PBool();
        final JSONObject jSONObject = new JSONObject();
        ((C45832c) C1720g.m3528K(C45832c.class)).mo68448b(context, hv.field_appId, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(8788);
                pBool.value = true;
                C35675i.m58528a(hv, false, c4624a);
                AppMethodBeat.m2505o(8788);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(8789);
                pBool.value = true;
                try {
                    jSONObject.put("reserve_for_wifi", 0);
                } catch (JSONException e) {
                }
                C42911a c42911a = hv;
                hv.field_downloadInWifi = false;
                c42911a.field_reserveInWifi = false;
                C2895c.m5146e(hv);
                if (hv.field_status == 0) {
                    ((C38855d) C1720g.m3528K(C38855d.class)).mo61734kP(hv.field_appId);
                }
                c4624a.mo9715d(null, jSONObject);
                AppMethodBeat.m2505o(8789);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(8790);
                if (pBool.value) {
                    AppMethodBeat.m2505o(8790);
                    return;
                }
                c4624a.mo9715d("cancel", null);
                AppMethodBeat.m2505o(8790);
            }
        });
        AppMethodBeat.m2505o(8803);
    }
}
