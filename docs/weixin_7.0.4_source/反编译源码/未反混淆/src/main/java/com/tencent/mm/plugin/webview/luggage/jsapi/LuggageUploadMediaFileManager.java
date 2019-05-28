package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.KeyEvent;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public final class LuggageUploadMediaFileManager {
    private static ProgressDialog ehJ = null;
    public MMActivity knn;
    public String mAppId;
    public d uiI;
    public String ukB;
    public boolean ukC;
    public b ukD;

    interface a {
        void d(boolean z, String str, String str2);
    }

    public static class UploadMediaFileTask extends MainProcessTask {
        public static final Creator<UploadMediaFileTask> CREATOR = new Creator<UploadMediaFileTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UploadMediaFileTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(GLFormat.GL_ALPHA);
                UploadMediaFileTask uploadMediaFileTask = new UploadMediaFileTask(parcel, (byte) 0);
                AppMethodBeat.o(GLFormat.GL_ALPHA);
                return uploadMediaFileTask;
            }
        };
        public String appId;
        public String cHr;
        public Runnable hww;
        public boolean success;
        private a ukK;
        public String ukN;
        public String ukO;

        /* synthetic */ UploadMediaFileTask(Parcel parcel, byte b) {
            this(parcel);
        }

        static /* synthetic */ boolean a(UploadMediaFileTask uploadMediaFileTask) {
            AppMethodBeat.i(6412);
            boolean aCb = uploadMediaFileTask.aCb();
            AppMethodBeat.o(6412);
            return aCb;
        }

        public final void asP() {
            AppMethodBeat.i(GLFormat.GL_RGB);
            ab.i("MicroMsg.UploadMediaTask", "runInMainProcess");
            if (this.ukK == null) {
                this.ukK = new a() {
                    public final void d(boolean z, String str, String str2) {
                        AppMethodBeat.i(6405);
                        ab.i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", Boolean.valueOf(z), str, str2);
                        UploadMediaFileTask.this.success = z;
                        UploadMediaFileTask.this.cHr = str;
                        UploadMediaFileTask.this.ukO = str2;
                        UploadMediaFileTask.a(UploadMediaFileTask.this);
                        AppMethodBeat.o(6405);
                    }
                };
            }
            WebViewJSSDKFileItem aex = g.cYF().aex(this.ukN);
            if (aex == null) {
                aCb();
                AppMethodBeat.o(GLFormat.GL_RGB);
                return;
            }
            switch (aex.cyQ) {
                case 1:
                    LuggageUploadMediaFileManager.a(ah.getContext(), aex, this.appId, this.ukN, com.tencent.mm.i.a.efJ, false, this.ukK);
                    AppMethodBeat.o(GLFormat.GL_RGB);
                    return;
                case 4:
                    LuggageUploadMediaFileManager.a(ah.getContext(), this.appId, this.ukN, com.tencent.mm.i.a.efK, false, this.ukK);
                    AppMethodBeat.o(GLFormat.GL_RGB);
                    return;
                default:
                    LuggageUploadMediaFileManager.a(ah.getContext(), this.appId, this.ukN, com.tencent.mm.i.a.efK, false, this.ukK);
                    AppMethodBeat.o(GLFormat.GL_RGB);
                    return;
            }
        }

        public final void asQ() {
            AppMethodBeat.i(GLFormat.GL_RGBA);
            if (this.hww != null) {
                this.hww.run();
            }
            AppMethodBeat.o(GLFormat.GL_RGBA);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(6409);
            this.ukN = parcel.readString();
            this.appId = parcel.readString();
            this.cHr = parcel.readString();
            this.ukO = parcel.readString();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
            AppMethodBeat.o(6409);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(6410);
            parcel.writeString(this.ukN);
            parcel.writeString(this.appId);
            parcel.writeString(this.cHr);
            parcel.writeString(this.ukO);
            parcel.writeByte((byte) (this.success ? 1 : 0));
            AppMethodBeat.o(6410);
        }

        private UploadMediaFileTask(Parcel parcel) {
            AppMethodBeat.i(6411);
            g(parcel);
            AppMethodBeat.o(6411);
        }

        static {
            AppMethodBeat.i(6413);
            AppMethodBeat.o(6413);
        }
    }

    public interface b {
        void a(boolean z, HashMap<String, Object> hashMap);
    }

    public static class c implements com.tencent.mm.plugin.webview.luggage.ipc.c {
        private a ukK = new a() {
            public final void d(boolean z, String str, String str2) {
                AppMethodBeat.i(6402);
                if (c.this.ukL != null) {
                    if (z) {
                        Bundle bundle = new Bundle();
                        bundle.putString("media_id", str);
                        bundle.putString("media_url", str2);
                        c.this.ukL.l(bundle);
                        AppMethodBeat.o(6402);
                        return;
                    }
                    c.this.ukL.l(null);
                }
                AppMethodBeat.o(6402);
            }
        };
        private com.tencent.mm.plugin.webview.luggage.ipc.a ukL;

        public c() {
            AppMethodBeat.i(6403);
            AppMethodBeat.o(6403);
        }

        public final void a(Context context, Bundle bundle, com.tencent.mm.plugin.webview.luggage.ipc.a aVar) {
            AppMethodBeat.i(6404);
            this.ukL = aVar;
            String string = bundle.getString("local_id");
            String string2 = bundle.getString("app_id");
            boolean z = bundle.getBoolean("show_progress_tips");
            WebViewJSSDKFileItem aex = g.cYF().aex(string);
            if (aex == null) {
                aVar.l(null);
                AppMethodBeat.o(6404);
                return;
            }
            switch (aex.cyQ) {
                case 1:
                    LuggageUploadMediaFileManager.a(context, aex, string2, string, com.tencent.mm.i.a.efJ, z, this.ukK);
                    AppMethodBeat.o(6404);
                    return;
                case 4:
                    LuggageUploadMediaFileManager.a(context, string2, string, com.tencent.mm.i.a.efK, z, this.ukK);
                    AppMethodBeat.o(6404);
                    return;
                default:
                    LuggageUploadMediaFileManager.a(context, string2, string, com.tencent.mm.i.a.efK, z, this.ukK);
                    AppMethodBeat.o(6404);
                    return;
            }
        }
    }

    static /* synthetic */ void a(LuggageUploadMediaFileManager luggageUploadMediaFileManager) {
        AppMethodBeat.i(6416);
        luggageUploadMediaFileManager.cXp();
        AppMethodBeat.o(6416);
    }

    /* Access modifiers changed, original: final */
    public final void cXp() {
        AppMethodBeat.i(6414);
        if (this.uiI.cWH() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("close_window_confirm_dialog_switch", true);
            bundle.putString("close_window_confirm_dialog_title_cn", this.knn.getString(R.string.fyy));
            bundle.putString("close_window_confirm_dialog_title_eng", this.knn.getString(R.string.fyy));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.knn.getString(R.string.fyu));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.knn.getString(R.string.fyu));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.knn.getString(R.string.fyv));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.knn.getString(R.string.fyv));
            this.uiI.cWH().setCloseWindowConfirmInfo(bundle);
        }
        cXq();
        AppMethodBeat.o(6414);
    }

    /* Access modifiers changed, original: final */
    public final void cXq() {
        AppMethodBeat.i(6415);
        if (this.ukC) {
            Bundle bundle = new Bundle();
            bundle.putString("local_id", this.ukB);
            bundle.putString("app_id", this.mAppId);
            bundle.putBoolean("show_progress_tips", this.ukC);
            com.tencent.mm.plugin.webview.luggage.ipc.b.a(this.knn, bundle, c.class, new com.tencent.mm.plugin.webview.luggage.ipc.a() {
                public final void l(Bundle bundle) {
                    AppMethodBeat.i(6394);
                    if (bundle != null) {
                        HashMap hashMap = new HashMap();
                        String string = bundle.getString("media_id");
                        String string2 = bundle.getString("media_url");
                        hashMap.put("serverId", bo.nullAsNil(string));
                        hashMap.put("mediaUrl", bo.nullAsNil(string2));
                        LuggageUploadMediaFileManager.this.ukD.a(true, hashMap);
                        AppMethodBeat.o(6394);
                        return;
                    }
                    LuggageUploadMediaFileManager.this.ukD.a(false, null);
                    AppMethodBeat.o(6394);
                }
            });
            AppMethodBeat.o(6415);
            return;
        }
        final MainProcessTask uploadMediaFileTask = new UploadMediaFileTask();
        uploadMediaFileTask.ukN = this.ukB;
        uploadMediaFileTask.appId = this.mAppId;
        uploadMediaFileTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(6395);
                uploadMediaFileTask.aBW();
                LuggageUploadMediaFileManager.b(LuggageUploadMediaFileManager.this);
                if (uploadMediaFileTask.success) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("serverId", bo.nullAsNil(uploadMediaFileTask.cHr));
                    hashMap.put("mediaUrl", bo.nullAsNil(uploadMediaFileTask.ukO));
                    LuggageUploadMediaFileManager.this.ukD.a(true, hashMap);
                    AppMethodBeat.o(6395);
                    return;
                }
                LuggageUploadMediaFileManager.this.ukD.a(false, null);
                AppMethodBeat.o(6395);
            }
        };
        uploadMediaFileTask.aBV();
        AppBrandMainProcessService.a(uploadMediaFileTask);
        AppMethodBeat.o(6415);
    }

    static /* synthetic */ void b(LuggageUploadMediaFileManager luggageUploadMediaFileManager) {
        AppMethodBeat.i(6417);
        if (luggageUploadMediaFileManager.uiI.cWH() != null) {
            k cWH = luggageUploadMediaFileManager.uiI.cWH();
            if (cWH.ujd != null) {
                cWH.ujd.dismiss();
                cWH.ujd = null;
            }
            luggageUploadMediaFileManager.uiI.cWH().setCloseWindowConfirmInfo(null);
        }
        AppMethodBeat.o(6417);
    }

    static /* synthetic */ void a(Context context, WebViewJSSDKFileItem webViewJSSDKFileItem, String str, final String str2, int i, boolean z, final a aVar) {
        AppMethodBeat.i(6418);
        final AnonymousClass5 anonymousClass5 = new com.tencent.mm.plugin.webview.model.d.b() {
            public final void b(boolean z, String str, String str2, String str3) {
                AppMethodBeat.i(6396);
                ab.i("MicroMsg.UploadMediaFileHelp", " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (!bo.isNullOrNil(str) && str.equals(str2)) {
                    g.cYE().a((com.tencent.mm.plugin.webview.model.d.b) this);
                    if (LuggageUploadMediaFileManager.ehJ != null) {
                        LuggageUploadMediaFileManager.ehJ.dismiss();
                        LuggageUploadMediaFileManager.ehJ = null;
                    }
                    aVar.d(z, str2, str3);
                }
                AppMethodBeat.o(6396);
            }
        };
        e b = o.ahl().b(Long.valueOf(o.ahl().a(webViewJSSDKFileItem.heo, webViewJSSDKFileItem.hes ? 0 : 1, 0, new PString(), new PInt(), new PInt())));
        String str3 = webViewJSSDKFileItem.heo;
        webViewJSSDKFileItem.heo = o.ahl().q(b.fDz, "", "");
        ab.i("MicroMsg.UploadMediaFileHelp", "Image Inserted: %s", r0);
        ab.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", Boolean.valueOf(g.cYE().a(str, str2, i, 202, 2, anonymousClass5)));
        webViewJSSDKFileItem.heo = str3;
        if (g.cYE().a(str, str2, i, 202, 2, anonymousClass5)) {
            if (z) {
                context.getString(R.string.tz);
                ehJ = h.b(context, context.getString(R.string.g33), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(6397);
                        g.cYE().a(anonymousClass5);
                        g.cYE();
                        aj.yC(str2);
                        aVar.d(false, "", "");
                        AppMethodBeat.o(6397);
                    }
                });
            }
            AppMethodBeat.o(6418);
            return;
        }
        aVar.d(false, "", "");
        AppMethodBeat.o(6418);
    }

    static /* synthetic */ void a(final Context context, String str, final String str2, int i, boolean z, final a aVar) {
        AppMethodBeat.i(6419);
        final AnonymousClass7 anonymousClass7 = new com.tencent.mm.plugin.webview.model.d.b() {
            public final void b(boolean z, String str, String str2, String str3) {
                AppMethodBeat.i(6398);
                ab.i("MicroMsg.UploadMediaFileHelp", "on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (bo.isNullOrNil(str) || !str.equals(str2)) {
                    AppMethodBeat.o(6398);
                    return;
                }
                g.cYE().a((com.tencent.mm.plugin.webview.model.d.b) this);
                if (LuggageUploadMediaFileManager.ehJ != null) {
                    LuggageUploadMediaFileManager.ehJ.dismiss();
                    LuggageUploadMediaFileManager.ehJ = null;
                }
                aVar.d(z, str2, str3);
                AppMethodBeat.o(6398);
            }
        };
        ab.i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", Boolean.valueOf(g.cYE().a(str, str2, i, 202, 2, anonymousClass7)));
        if (g.cYE().a(str, str2, i, 202, 2, anonymousClass7)) {
            if (z) {
                context.getString(R.string.tz);
                p b = h.b(context, context.getString(R.string.g33), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(6399);
                        g.cYE().a(anonymousClass7);
                        g.cYE();
                        aj.yC(str2);
                        aVar.d(false, "", "");
                        AppMethodBeat.o(6399);
                    }
                });
                ehJ = b;
                b.setOnKeyListener(new OnKeyListener() {
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        AppMethodBeat.i(6401);
                        if (i == 4 && keyEvent.getAction() == 1) {
                            h.a(context, true, context.getString(R.string.fyy), "", context.getString(R.string.fyu), context.getString(R.string.fyv), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(6400);
                                    LuggageUploadMediaFileManager.ehJ.cancel();
                                    AppMethodBeat.o(6400);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            AppMethodBeat.o(6401);
                            return true;
                        }
                        AppMethodBeat.o(6401);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(6419);
            return;
        }
        aVar.d(false, "", "");
        AppMethodBeat.o(6419);
    }
}
