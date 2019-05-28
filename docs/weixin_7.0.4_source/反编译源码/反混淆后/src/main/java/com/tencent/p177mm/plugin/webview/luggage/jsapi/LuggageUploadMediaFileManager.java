package com.tencent.p177mm.plugin.webview.luggage.jsapi;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.webview.luggage.C22857k;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.ipc.C35590c;
import com.tencent.p177mm.plugin.webview.luggage.ipc.C4541a;
import com.tencent.p177mm.plugin.webview.luggage.ipc.C4542b;
import com.tencent.p177mm.plugin.webview.model.C22881aj;
import com.tencent.p177mm.plugin.webview.model.C22888d.C14515b;
import com.tencent.p177mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager */
public final class LuggageUploadMediaFileManager {
    private static ProgressDialog ehJ = null;
    public MMActivity knn;
    public String mAppId;
    public C24905d uiI;
    public String ukB;
    public boolean ukC;
    public C35594b ukD;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$2 */
    class C228302 implements OnClickListener {
        C228302() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(6393);
            LuggageUploadMediaFileManager.this.ukD.mo48039a(false, null);
            AppMethodBeat.m2505o(6393);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$3 */
    class C297933 implements C4541a {
        C297933() {
        }

        /* renamed from: l */
        public final void mo9613l(Bundle bundle) {
            AppMethodBeat.m2504i(6394);
            if (bundle != null) {
                HashMap hashMap = new HashMap();
                String string = bundle.getString("media_id");
                String string2 = bundle.getString("media_url");
                hashMap.put("serverId", C5046bo.nullAsNil(string));
                hashMap.put("mediaUrl", C5046bo.nullAsNil(string2));
                LuggageUploadMediaFileManager.this.ukD.mo48039a(true, hashMap);
                AppMethodBeat.m2505o(6394);
                return;
            }
            LuggageUploadMediaFileManager.this.ukD.mo48039a(false, null);
            AppMethodBeat.m2505o(6394);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$a */
    interface C29795a {
        /* renamed from: d */
        void mo26725d(boolean z, String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$UploadMediaFileTask */
    public static class UploadMediaFileTask extends MainProcessTask {
        public static final Creator<UploadMediaFileTask> CREATOR = new C314772();
        public String appId;
        public String cHr;
        public Runnable hww;
        public boolean success;
        private C29795a ukK;
        public String ukN;
        public String ukO;

        /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$UploadMediaFileTask$1 */
        class C228321 implements C29795a {
            C228321() {
            }

            /* renamed from: d */
            public final void mo26725d(boolean z, String str, String str2) {
                AppMethodBeat.m2504i(6405);
                C4990ab.m7417i("MicroMsg.UploadMediaTask", "success = %b, mediaId = %s, mediaUrl = %s", Boolean.valueOf(z), str, str2);
                UploadMediaFileTask.this.success = z;
                UploadMediaFileTask.this.cHr = str;
                UploadMediaFileTask.this.ukO = str2;
                UploadMediaFileTask.m50933a(UploadMediaFileTask.this);
                AppMethodBeat.m2505o(6405);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$UploadMediaFileTask$2 */
        static class C314772 implements Creator<UploadMediaFileTask> {
            C314772() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UploadMediaFileTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(GLFormat.GL_ALPHA);
                UploadMediaFileTask uploadMediaFileTask = new UploadMediaFileTask(parcel, (byte) 0);
                AppMethodBeat.m2505o(GLFormat.GL_ALPHA);
                return uploadMediaFileTask;
            }
        }

        /* synthetic */ UploadMediaFileTask(Parcel parcel, byte b) {
            this(parcel);
        }

        /* renamed from: a */
        static /* synthetic */ boolean m50933a(UploadMediaFileTask uploadMediaFileTask) {
            AppMethodBeat.m2504i(6412);
            boolean aCb = uploadMediaFileTask.aCb();
            AppMethodBeat.m2505o(6412);
            return aCb;
        }

        public final void asP() {
            AppMethodBeat.m2504i(GLFormat.GL_RGB);
            C4990ab.m7416i("MicroMsg.UploadMediaTask", "runInMainProcess");
            if (this.ukK == null) {
                this.ukK = new C228321();
            }
            WebViewJSSDKFileItem aex = C29833g.cYF().aex(this.ukN);
            if (aex == null) {
                aCb();
                AppMethodBeat.m2505o(GLFormat.GL_RGB);
                return;
            }
            switch (aex.cyQ) {
                case 1:
                    LuggageUploadMediaFileManager.m58421a(C4996ah.getContext(), aex, this.appId, this.ukN, C42129a.efJ, false, this.ukK);
                    AppMethodBeat.m2505o(GLFormat.GL_RGB);
                    return;
                case 4:
                    LuggageUploadMediaFileManager.m58422a(C4996ah.getContext(), this.appId, this.ukN, C42129a.efK, false, this.ukK);
                    AppMethodBeat.m2505o(GLFormat.GL_RGB);
                    return;
                default:
                    LuggageUploadMediaFileManager.m58422a(C4996ah.getContext(), this.appId, this.ukN, C42129a.efK, false, this.ukK);
                    AppMethodBeat.m2505o(GLFormat.GL_RGB);
                    return;
            }
        }

        public final void asQ() {
            AppMethodBeat.m2504i(GLFormat.GL_RGBA);
            if (this.hww != null) {
                this.hww.run();
            }
            AppMethodBeat.m2505o(GLFormat.GL_RGBA);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(6409);
            this.ukN = parcel.readString();
            this.appId = parcel.readString();
            this.cHr = parcel.readString();
            this.ukO = parcel.readString();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
            AppMethodBeat.m2505o(6409);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(6410);
            parcel.writeString(this.ukN);
            parcel.writeString(this.appId);
            parcel.writeString(this.cHr);
            parcel.writeString(this.ukO);
            parcel.writeByte((byte) (this.success ? 1 : 0));
            AppMethodBeat.m2505o(6410);
        }

        private UploadMediaFileTask(Parcel parcel) {
            AppMethodBeat.m2504i(6411);
            mo6032g(parcel);
            AppMethodBeat.m2505o(6411);
        }

        static {
            AppMethodBeat.m2504i(6413);
            AppMethodBeat.m2505o(6413);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$b */
    public interface C35594b {
        /* renamed from: a */
        void mo48039a(boolean z, HashMap<String, Object> hashMap);
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$1 */
    class C355951 implements OnClickListener {
        C355951() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(6392);
            LuggageUploadMediaFileManager.m58423a(LuggageUploadMediaFileManager.this);
            AppMethodBeat.m2505o(6392);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$c */
    public static class C35598c implements C35590c {
        private C29795a ukK = new C144781();
        private C4541a ukL;

        /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$c$1 */
        class C144781 implements C29795a {
            C144781() {
            }

            /* renamed from: d */
            public final void mo26725d(boolean z, String str, String str2) {
                AppMethodBeat.m2504i(6402);
                if (C35598c.this.ukL != null) {
                    if (z) {
                        Bundle bundle = new Bundle();
                        bundle.putString("media_id", str);
                        bundle.putString("media_url", str2);
                        C35598c.this.ukL.mo9613l(bundle);
                        AppMethodBeat.m2505o(6402);
                        return;
                    }
                    C35598c.this.ukL.mo9613l(null);
                }
                AppMethodBeat.m2505o(6402);
            }
        }

        public C35598c() {
            AppMethodBeat.m2504i(6403);
            AppMethodBeat.m2505o(6403);
        }

        /* renamed from: a */
        public final void mo56317a(Context context, Bundle bundle, C4541a c4541a) {
            AppMethodBeat.m2504i(6404);
            this.ukL = c4541a;
            String string = bundle.getString("local_id");
            String string2 = bundle.getString("app_id");
            boolean z = bundle.getBoolean("show_progress_tips");
            WebViewJSSDKFileItem aex = C29833g.cYF().aex(string);
            if (aex == null) {
                c4541a.mo9613l(null);
                AppMethodBeat.m2505o(6404);
                return;
            }
            switch (aex.cyQ) {
                case 1:
                    LuggageUploadMediaFileManager.m58421a(context, aex, string2, string, C42129a.efJ, z, this.ukK);
                    AppMethodBeat.m2505o(6404);
                    return;
                case 4:
                    LuggageUploadMediaFileManager.m58422a(context, string2, string, C42129a.efK, z, this.ukK);
                    AppMethodBeat.m2505o(6404);
                    return;
                default:
                    LuggageUploadMediaFileManager.m58422a(context, string2, string, C42129a.efK, z, this.ukK);
                    AppMethodBeat.m2505o(6404);
                    return;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m58423a(LuggageUploadMediaFileManager luggageUploadMediaFileManager) {
        AppMethodBeat.m2504i(6416);
        luggageUploadMediaFileManager.cXp();
        AppMethodBeat.m2505o(6416);
    }

    /* Access modifiers changed, original: final */
    public final void cXp() {
        AppMethodBeat.m2504i(6414);
        if (this.uiI.cWH() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("close_window_confirm_dialog_switch", true);
            bundle.putString("close_window_confirm_dialog_title_cn", this.knn.getString(C25738R.string.fyy));
            bundle.putString("close_window_confirm_dialog_title_eng", this.knn.getString(C25738R.string.fyy));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.knn.getString(C25738R.string.fyu));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.knn.getString(C25738R.string.fyu));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.knn.getString(C25738R.string.fyv));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.knn.getString(C25738R.string.fyv));
            this.uiI.cWH().setCloseWindowConfirmInfo(bundle);
        }
        cXq();
        AppMethodBeat.m2505o(6414);
    }

    /* Access modifiers changed, original: final */
    public final void cXq() {
        AppMethodBeat.m2504i(6415);
        if (this.ukC) {
            Bundle bundle = new Bundle();
            bundle.putString("local_id", this.ukB);
            bundle.putString("app_id", this.mAppId);
            bundle.putBoolean("show_progress_tips", this.ukC);
            C4542b.m6919a(this.knn, bundle, C35598c.class, new C297933());
            AppMethodBeat.m2505o(6415);
            return;
        }
        final MainProcessTask uploadMediaFileTask = new UploadMediaFileTask();
        uploadMediaFileTask.ukN = this.ukB;
        uploadMediaFileTask.appId = this.mAppId;
        uploadMediaFileTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(6395);
                uploadMediaFileTask.aBW();
                LuggageUploadMediaFileManager.m58424b(LuggageUploadMediaFileManager.this);
                if (uploadMediaFileTask.success) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("serverId", C5046bo.nullAsNil(uploadMediaFileTask.cHr));
                    hashMap.put("mediaUrl", C5046bo.nullAsNil(uploadMediaFileTask.ukO));
                    LuggageUploadMediaFileManager.this.ukD.mo48039a(true, hashMap);
                    AppMethodBeat.m2505o(6395);
                    return;
                }
                LuggageUploadMediaFileManager.this.ukD.mo48039a(false, null);
                AppMethodBeat.m2505o(6395);
            }
        };
        uploadMediaFileTask.aBV();
        AppBrandMainProcessService.m54349a(uploadMediaFileTask);
        AppMethodBeat.m2505o(6415);
    }

    /* renamed from: b */
    static /* synthetic */ void m58424b(LuggageUploadMediaFileManager luggageUploadMediaFileManager) {
        AppMethodBeat.m2504i(6417);
        if (luggageUploadMediaFileManager.uiI.cWH() != null) {
            C22857k cWH = luggageUploadMediaFileManager.uiI.cWH();
            if (cWH.ujd != null) {
                cWH.ujd.dismiss();
                cWH.ujd = null;
            }
            luggageUploadMediaFileManager.uiI.cWH().setCloseWindowConfirmInfo(null);
        }
        AppMethodBeat.m2505o(6417);
    }

    /* renamed from: a */
    static /* synthetic */ void m58421a(Context context, WebViewJSSDKFileItem webViewJSSDKFileItem, String str, final String str2, int i, boolean z, final C29795a c29795a) {
        AppMethodBeat.m2504i(6418);
        final C297945 c297945 = new C14515b() {
            /* renamed from: b */
            public final void mo26755b(boolean z, String str, String str2, String str3) {
                AppMethodBeat.m2504i(6396);
                C4990ab.m7417i("MicroMsg.UploadMediaFileHelp", " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (!C5046bo.isNullOrNil(str) && str.equals(str2)) {
                    C29833g.cYE().mo38474a((C14515b) this);
                    if (LuggageUploadMediaFileManager.ehJ != null) {
                        LuggageUploadMediaFileManager.ehJ.dismiss();
                        LuggageUploadMediaFileManager.ehJ = null;
                    }
                    c29795a.mo26725d(z, str2, str3);
                }
                AppMethodBeat.m2505o(6396);
            }
        };
        C25822e b = C32291o.ahl().mo73105b(Long.valueOf(C32291o.ahl().mo73079a(webViewJSSDKFileItem.heo, webViewJSSDKFileItem.hes ? 0 : 1, 0, new PString(), new PInt(), new PInt())));
        String str3 = webViewJSSDKFileItem.heo;
        webViewJSSDKFileItem.heo = C32291o.ahl().mo73118q(b.fDz, "", "");
        C4990ab.m7417i("MicroMsg.UploadMediaFileHelp", "Image Inserted: %s", r0);
        C4990ab.m7417i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", Boolean.valueOf(C29833g.cYE().mo38475a(str, str2, i, 202, 2, c297945)));
        webViewJSSDKFileItem.heo = str3;
        if (C29833g.cYE().mo38475a(str, str2, i, 202, 2, c297945)) {
            if (z) {
                context.getString(C25738R.string.f9238tz);
                ehJ = C30379h.m48458b(context, context.getString(C25738R.string.g33), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(6397);
                        C29833g.cYE().mo38474a(c297945);
                        C29833g.cYE();
                        C22881aj.m34725yC(str2);
                        c29795a.mo26725d(false, "", "");
                        AppMethodBeat.m2505o(6397);
                    }
                });
            }
            AppMethodBeat.m2505o(6418);
            return;
        }
        c29795a.mo26725d(false, "", "");
        AppMethodBeat.m2505o(6418);
    }

    /* renamed from: a */
    static /* synthetic */ void m58422a(final Context context, String str, final String str2, int i, boolean z, final C29795a c29795a) {
        AppMethodBeat.m2504i(6419);
        final C355967 c355967 = new C14515b() {
            /* renamed from: b */
            public final void mo26755b(boolean z, String str, String str2, String str3) {
                AppMethodBeat.m2504i(6398);
                C4990ab.m7417i("MicroMsg.UploadMediaFileHelp", "on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", Boolean.valueOf(z), str2, str, str3);
                if (C5046bo.isNullOrNil(str) || !str.equals(str2)) {
                    AppMethodBeat.m2505o(6398);
                    return;
                }
                C29833g.cYE().mo38474a((C14515b) this);
                if (LuggageUploadMediaFileManager.ehJ != null) {
                    LuggageUploadMediaFileManager.ehJ.dismiss();
                    LuggageUploadMediaFileManager.ehJ = null;
                }
                c29795a.mo26725d(z, str2, str3);
                AppMethodBeat.m2505o(6398);
            }
        };
        C4990ab.m7417i("MicroMsg.UploadMediaFileHelp", "add cdn upload task result : %b", Boolean.valueOf(C29833g.cYE().mo38475a(str, str2, i, 202, 2, c355967)));
        if (C29833g.cYE().mo38475a(str, str2, i, 202, 2, c355967)) {
            if (z) {
                context.getString(C25738R.string.f9238tz);
                C44275p b = C30379h.m48458b(context, context.getString(C25738R.string.g33), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(6399);
                        C29833g.cYE().mo38474a(c355967);
                        C29833g.cYE();
                        C22881aj.m34725yC(str2);
                        c29795a.mo26725d(false, "", "");
                        AppMethodBeat.m2505o(6399);
                    }
                });
                ehJ = b;
                b.setOnKeyListener(new OnKeyListener() {

                    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$9$1 */
                    class C144761 implements OnClickListener {
                        C144761() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(6400);
                            LuggageUploadMediaFileManager.ehJ.cancel();
                            AppMethodBeat.m2505o(6400);
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$9$2 */
                    class C144772 implements OnClickListener {
                        C144772() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }

                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        AppMethodBeat.m2504i(6401);
                        if (i == 4 && keyEvent.getAction() == 1) {
                            C30379h.m48453a(context, true, context.getString(C25738R.string.fyy), "", context.getString(C25738R.string.fyu), context.getString(C25738R.string.fyv), new C144761(), new C144772());
                            AppMethodBeat.m2505o(6401);
                            return true;
                        }
                        AppMethodBeat.m2505o(6401);
                        return false;
                    }
                });
            }
            AppMethodBeat.m2505o(6419);
            return;
        }
        c29795a.mo26725d(false, "", "");
        AppMethodBeat.m2505o(6419);
    }
}
