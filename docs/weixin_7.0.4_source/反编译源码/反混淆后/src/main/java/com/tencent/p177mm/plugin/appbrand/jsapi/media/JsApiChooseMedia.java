package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p057v4.app.C6184a.C0315a;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19247b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p290g.C2154b;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.mmsight.SightParams;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.p878a.C42258c;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5062q;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONStringer;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia */
public final class JsApiChooseMedia extends C10296a {
    public static final int CTRL_INDEX = 193;
    public static final String NAME = "chooseMedia";
    private static volatile boolean hPi = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$ChooseResult */
    static final class ChooseResult extends ProcessResult {
        public static final Creator<ChooseResult> CREATOR = new C194311();
        int bFZ;
        String hPo;
        String type;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$ChooseResult$1 */
        static class C194311 implements Creator<ChooseResult> {
            C194311() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseResult[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131163);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.m2505o(131163);
                return chooseResult;
            }
        }

        /* renamed from: k */
        public final void mo6045k(Parcel parcel) {
            AppMethodBeat.m2504i(131164);
            this.bFZ = parcel.readInt();
            this.type = parcel.readString();
            this.hPo = parcel.readString();
            AppMethodBeat.m2505o(131164);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131165);
            parcel.writeInt(this.bFZ);
            parcel.writeString(this.type);
            parcel.writeString(this.hPo);
            AppMethodBeat.m2505o(131165);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            AppMethodBeat.m2504i(131166);
            mo6045k(parcel);
            AppMethodBeat.m2505o(131166);
        }

        static {
            AppMethodBeat.m2504i(131167);
            AppMethodBeat.m2505o(131167);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$ChooseRequest */
    static final class ChooseRequest extends ProcessRequest {
        public static final Creator<ChooseRequest> CREATOR = new C383441();
        String appId;
        int count;
        boolean hOU;
        boolean hOV;
        boolean hPk;
        boolean hPl;
        boolean hPm;
        boolean hPn;
        boolean isFront;
        int maxDuration;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$ChooseRequest$1 */
        static class C383441 implements Creator<ChooseRequest> {
            C383441() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ChooseRequest[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131158);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.m2505o(131158);
                return chooseRequest;
            }
        }

        public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
            return C38347a.class;
        }

        public final String aBZ() {
            return "GalleryChooseMedia";
        }

        /* renamed from: k */
        public final void mo6049k(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(131159);
            this.appId = parcel.readString();
            this.hPk = parcel.readByte() != (byte) 0;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hPl = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hPm = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hPn = z;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.isFront = z;
            this.maxDuration = parcel.readInt();
            this.count = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hOU = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.hOV = z2;
            AppMethodBeat.m2505o(131159);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.m2504i(131160);
            parcel.writeString(this.appId);
            parcel.writeByte(this.hPk ? (byte) 1 : (byte) 0);
            if (this.hPl) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.hPm) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.hPn) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (this.isFront) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            parcel.writeInt(this.maxDuration);
            parcel.writeInt(this.count);
            if (this.hOU) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.hOV) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            AppMethodBeat.m2505o(131160);
        }

        public final boolean aBY() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.m2504i(131161);
            mo6049k(parcel);
            AppMethodBeat.m2505o(131161);
        }

        static {
            AppMethodBeat.m2504i(131162);
            AppMethodBeat.m2505o(131162);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$a */
    static final class C38347a extends AppBrandProxyUIProcessTask {
        private C44275p ejZ;
        int hOZ;
        private OnCancelListener hPa;
        private ChooseResult hPp = new ChooseResult();
        private ChooseRequest hPq;
        private String hPr;
        private C46696j hPs;
        private String mVideoFilePath;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$a$3 */
        class C23153 implements OnCancelListener {
            C23153() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(131170);
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "cancel chooseMedia, and finish process!");
                C38347a.this.hPp.bFZ = 0;
                C38347a.m64891a(C38347a.this, C38347a.this.hPp);
                AppMethodBeat.m2505o(131170);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$a$1 */
        class C104691 implements OnCreateContextMenuListener {
            C104691() {
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(131168);
                contextMenu.add(0, 1, 0, C38347a.m64890a(C38347a.this).getString(C25738R.string.f9121q4));
                contextMenu.add(0, 2, 1, C38347a.m64892b(C38347a.this).getString(C25738R.string.f9126qa));
                AppMethodBeat.m2505o(131168);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$a$2 */
        class C104702 implements C5279d {
            C104702() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(131169);
                switch (menuItem.getItemId()) {
                    case 1:
                        C38347a.m64898c(C38347a.this);
                        AppMethodBeat.m2505o(131169);
                        return;
                    case 2:
                        C38347a.m64901d(C38347a.this);
                        break;
                }
                AppMethodBeat.m2505o(131169);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$a$4 */
        class C333574 implements Runnable {
            C333574() {
            }

            public final void run() {
                AppMethodBeat.m2504i(131171);
                if (new File(C38347a.this.mVideoFilePath).exists()) {
                    C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
                    C38347a.this.hPp.bFZ = -1;
                    C38347a.this.hPp.type = "video";
                    AppBrandLocalVideoObject a = C38347a.m64889a(C38347a.this, C38347a.this.mVideoFilePath);
                    if (a == null) {
                        C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", C38347a.this.mVideoFilePath);
                        C38347a.this.hPp.bFZ = -2;
                        C38347a.m64894b(C38347a.this, C38347a.this.hPp);
                        AppMethodBeat.m2505o(131171);
                        return;
                    }
                    C38347a.m64895b(C38347a.this, C38347a.this.mVideoFilePath);
                    String g = C38347a.m64907g(C38347a.this);
                    C38347a.this.hPp.hPo = C38347a.m64900d(a.czD, g, a.duration, a.height, a.width, a.size);
                    C38347a.m64899c(C38347a.this, C38347a.this.hPp);
                    AppMethodBeat.m2505o(131171);
                    return;
                }
                C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", C38347a.this.mVideoFilePath);
                C38347a.this.hPp.bFZ = -2;
                C38347a.m64902d(C38347a.this, C38347a.this.hPp);
                AppMethodBeat.m2505o(131171);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$a$8 */
        class C333588 implements OnCancelListener {
            C333588() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(131177);
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "cancel show the progress dialog and finish progress");
                C38347a.this.hPp.bFZ = 0;
                C38347a.m64914l(C38347a.this, C38347a.this.hPp);
                AppMethodBeat.m2505o(131177);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia$a$7 */
        class C383467 implements Runnable {
            C383467() {
            }

            public final void run() {
                AppMethodBeat.m2504i(131176);
                if (new File(C38347a.this.mVideoFilePath).exists()) {
                    C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                    C38347a.this.hPp.bFZ = -1;
                    C38347a.this.hPp.type = "video";
                    AppBrandLocalVideoObject a = C38347a.m64889a(C38347a.this, C38347a.this.mVideoFilePath);
                    if (a == null) {
                        C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", C38347a.this.mVideoFilePath);
                        C38347a.this.hPp.bFZ = -2;
                        C38347a.m64911i(C38347a.this, C38347a.this.hPp);
                        AppMethodBeat.m2505o(131176);
                        return;
                    }
                    C38347a.m64895b(C38347a.this, C38347a.this.mVideoFilePath);
                    String g = C38347a.m64907g(C38347a.this);
                    C38347a.this.hPp.hPo = C38347a.m64900d(a.czD, g, a.duration, a.height, a.width, a.size);
                    C38347a.m64912j(C38347a.this, C38347a.this.hPp);
                    AppMethodBeat.m2505o(131176);
                    return;
                }
                C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", C38347a.this.mVideoFilePath);
                C38347a.this.hPp.bFZ = -2;
                C38347a.m64913k(C38347a.this, C38347a.this.hPp);
                AppMethodBeat.m2505o(131176);
            }
        }

        private C38347a() {
            AppMethodBeat.m2504i(131178);
            AppMethodBeat.m2505o(131178);
        }

        static /* synthetic */ String access$1500(String str) {
            AppMethodBeat.m2504i(131203);
            String Bo = C38347a.m64886Bo(str);
            AppMethodBeat.m2505o(131203);
            return Bo;
        }

        /* renamed from: b */
        static /* synthetic */ MMActivity m64892b(C38347a c38347a) {
            AppMethodBeat.m2504i(131192);
            MMActivity aBQ = c38347a.aBQ();
            AppMethodBeat.m2505o(131192);
            return aBQ;
        }

        /* renamed from: c */
        static /* synthetic */ void m64898c(C38347a c38347a) {
            AppMethodBeat.m2504i(131193);
            c38347a.aEg();
            AppMethodBeat.m2505o(131193);
        }

        /* renamed from: d */
        static /* synthetic */ String m64900d(String str, String str2, int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(131200);
            String c = C38347a.m64896c(str, str2, i, i2, i3, i4);
            AppMethodBeat.m2505o(131200);
            return c;
        }

        /* renamed from: d */
        static /* synthetic */ void m64901d(C38347a c38347a) {
            AppMethodBeat.m2504i(131194);
            c38347a.aEh();
            AppMethodBeat.m2505o(131194);
        }

        /* renamed from: d */
        static /* synthetic */ void m64902d(C38347a c38347a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131202);
            c38347a.mo34449a(processResult);
            AppMethodBeat.m2505o(131202);
        }

        /* renamed from: e */
        static /* synthetic */ void m64904e(C38347a c38347a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131204);
            c38347a.mo34449a(processResult);
            AppMethodBeat.m2505o(131204);
        }

        /* renamed from: f */
        static /* synthetic */ void m64906f(C38347a c38347a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131206);
            c38347a.mo34449a(processResult);
            AppMethodBeat.m2505o(131206);
        }

        /* renamed from: g */
        static /* synthetic */ void m64908g(C38347a c38347a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131207);
            c38347a.mo34449a(processResult);
            AppMethodBeat.m2505o(131207);
        }

        /* renamed from: h */
        static /* synthetic */ void m64910h(C38347a c38347a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131208);
            c38347a.mo34449a(processResult);
            AppMethodBeat.m2505o(131208);
        }

        /* renamed from: i */
        static /* synthetic */ void m64911i(C38347a c38347a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131209);
            c38347a.mo34449a(processResult);
            AppMethodBeat.m2505o(131209);
        }

        /* renamed from: j */
        static /* synthetic */ void m64912j(C38347a c38347a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131210);
            c38347a.mo34449a(processResult);
            AppMethodBeat.m2505o(131210);
        }

        /* renamed from: k */
        static /* synthetic */ void m64913k(C38347a c38347a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131211);
            c38347a.mo34449a(processResult);
            AppMethodBeat.m2505o(131211);
        }

        /* renamed from: l */
        static /* synthetic */ void m64914l(C38347a c38347a, ProcessResult processResult) {
            AppMethodBeat.m2504i(131212);
            c38347a.mo34449a(processResult);
            AppMethodBeat.m2505o(131212);
        }

        /* renamed from: a */
        public final void mo6047a(ProcessRequest processRequest) {
            int i;
            AppMethodBeat.m2504i(131179);
            this.hPq = (ChooseRequest) processRequest;
            if ((this.hPq.hOU & this.hPq.hOV) != 0) {
                i = 8;
            } else {
                i = 7;
            }
            this.hOZ = i;
            if (C5046bo.m7553gO(aBQ()) > 200) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
                C23639t.makeText(aBQ(), C4996ah.getResources().getString(C25738R.string.f8857ha), 1).show();
            }
            C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "goVideo");
            aBQ().ifE = this;
            if (this.hPq.hPk && this.hPq.hPl) {
                this.hPs = new C46696j(aBQ());
                this.hPs.mo75009b(null, new C104691(), new C104702());
                this.hPs.mo75012e(new C23153());
                this.hPs.cuu();
                AppMethodBeat.m2505o(131179);
            } else if (this.hPq.hPk) {
                aEh();
                AppMethodBeat.m2505o(131179);
            } else if (this.hPq.hPl) {
                aEg();
                AppMethodBeat.m2505o(131179);
            } else {
                this.hPp.bFZ = -2;
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
                mo34449a((ProcessResult) this.hPp);
                AppMethodBeat.m2505o(131179);
            }
        }

        public final void aBX() {
            AppMethodBeat.m2504i(131180);
            super.aBX();
            if (this.ejZ != null) {
                this.ejZ.dismiss();
                this.ejZ = null;
            }
            if (this.hPs != null) {
                this.hPs.dismiss();
                this.hPs = null;
            }
            AppMethodBeat.m2505o(131180);
        }

        private void aEg() {
            int i = 0;
            AppMethodBeat.m2504i(131181);
            C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
            if (!(this.hPq.hPn && this.hPq.hPm)) {
                if (this.hPq.hPn) {
                    i = 1;
                } else if (this.hPq.hPm) {
                    i = 2;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("KEY_SIGHT_PARAMS", m64915os(i));
            C14987n.m23302a(aBQ(), 7, intent, 3, i);
            AppMethodBeat.m2505o(131181);
        }

        /* renamed from: os */
        private SightParams m64915os(int i) {
            AppMethodBeat.m2504i(131182);
            String str = "microMsg_" + System.currentTimeMillis();
            this.mVideoFilePath = C6457e.euR + "microMsg." + str + VideoMaterialUtil.MP4_SUFFIX;
            this.hPr = C6457e.euR + "microMsg." + str + ".jpeg";
            int i2 = this.hPq.maxDuration;
            SightParams sightParams = new SightParams(3, 1);
            sightParams.osJ = this.hPq.isFront ? 1 : 2;
            sightParams.mode = i;
            if (sightParams.fcY == null) {
                sightParams.fcY = new VideoTransPara();
            }
            sightParams.fcY.duration = i2;
            sightParams.osQ = false;
            sightParams.mo36644q(str, this.mVideoFilePath, this.hPr, C6457e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
            AppMethodBeat.m2505o(131182);
            return sightParams;
        }

        private void aEh() {
            int i = 3;
            boolean z = true;
            AppMethodBeat.m2504i(131183);
            C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
            if (!(this.hPq.hPm && this.hPq.hPn)) {
                if (this.hPq.hPm) {
                    i = 1;
                } else if (this.hPq.hPn) {
                    i = 2;
                }
            }
            Intent intent = new Intent();
            intent.putExtra("key_can_select_video_and_pic", true);
            String str = "key_send_raw_image";
            if (this.hPq.hOU) {
                z = false;
            }
            intent.putExtra(str, z);
            C14987n.m23295a(aBQ(), 8, this.hPq.count, this.hOZ, i, intent);
            AppMethodBeat.m2505o(131183);
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(131184);
            if (i2 == 0) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
                this.hPp.bFZ = 0;
                mo34449a((ProcessResult) this.hPp);
                AppMethodBeat.m2505o(131184);
            } else if (-1 != i2) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
                this.hPp.bFZ = -2;
                mo34449a((ProcessResult) this.hPp);
                AppMethodBeat.m2505o(131184);
            } else {
                boolean booleanExtra;
                boolean z;
                switch (i) {
                    case 7:
                        C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                        if (intent == null) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "data is null!");
                            break;
                        }
                        C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "data is valid!");
                        SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                        if (sightCaptureResult == null) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
                            this.hPp.bFZ = -2;
                            mo34449a((ProcessResult) this.hPp);
                            AppMethodBeat.m2505o(131184);
                            return;
                        } else if (sightCaptureResult.osA) {
                            final String str = sightCaptureResult.osI;
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", str);
                                this.hPp.bFZ = -2;
                                mo34449a((ProcessResult) this.hPp);
                                AppMethodBeat.m2505o(131184);
                                return;
                            }
                            booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                            if (((!this.hPq.hOV ? 1 : 0) & this.hPq.hOU) == 0 && ((this.hPq.hOU & this.hPq.hOV) & booleanExtra) == 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            C4990ab.m7411d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.TRUE, Boolean.valueOf(this.hPq.hOU), Boolean.valueOf(this.hPq.hOV), Boolean.valueOf(booleanExtra), Boolean.valueOf(z));
                            if (z) {
                                aEi();
                            }
                            C45673m.aNS().mo10302aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(131175);
                                    String access$1500 = z ? C38347a.access$1500(str) : str;
                                    final ArrayList arrayList = new ArrayList();
                                    final ArrayList arrayList2 = new ArrayList();
                                    AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.m29651j(C38347a.this.hPq.appId, access$1500, z | 1);
                                    if (j != null) {
                                        arrayList.add(Long.valueOf(j.gjQ));
                                        arrayList2.add(j.czD);
                                        C5004al.m7441d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.m2504i(131174);
                                                C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                                                C38347a.this.hPp.bFZ = -1;
                                                C38347a.this.hPp.type = "image";
                                                C38347a.this.hPp.hPo = C38347a.m64897c(arrayList2, arrayList);
                                                C38347a.m64908g(C38347a.this, C38347a.this.hPp);
                                                AppMethodBeat.m2505o(131174);
                                            }
                                        });
                                        AppMethodBeat.m2505o(131175);
                                        return;
                                    }
                                    C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", str);
                                    C38347a.this.hPp.bFZ = -2;
                                    C38347a.m64910h(C38347a.this, C38347a.this.hPp);
                                    AppMethodBeat.m2505o(131175);
                                }
                            });
                            AppMethodBeat.m2505o(131184);
                            return;
                        } else {
                            this.mVideoFilePath = sightCaptureResult.osC;
                            if (C5046bo.isNullOrNil(this.mVideoFilePath)) {
                                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
                                break;
                            }
                            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", this.mVideoFilePath);
                            if (!C38347a.m64888Bs(this.hPr) && C38347a.m64888Bs(sightCaptureResult.osD)) {
                                this.hPr = sightCaptureResult.osD;
                            }
                            aEi();
                            C45673m.aNS().mo10302aa(new C383467());
                            AppMethodBeat.m2505o(131184);
                            return;
                        }
                        break;
                    case 8:
                        C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                            final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                            if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
                                this.hPp.bFZ = -2;
                                mo34449a((ProcessResult) this.hPp);
                                AppMethodBeat.m2505o(131184);
                                return;
                            }
                            booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                            if (((!this.hPq.hOV ? 1 : 0) & this.hPq.hOU) == 0 && ((this.hPq.hOU & this.hPq.hOV) & booleanExtra) == 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", Boolean.FALSE, Boolean.valueOf(this.hPq.hOU), Boolean.valueOf(this.hPq.hOV), Boolean.valueOf(booleanExtra), Boolean.valueOf(z));
                            if (z) {
                                aEi();
                            }
                            C45673m.aNS().mo10302aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(131173);
                                    final ArrayList arrayList = new ArrayList(stringArrayListExtra2.size());
                                    final ArrayList arrayList2 = new ArrayList(stringArrayListExtra2.size());
                                    for (String str : stringArrayListExtra2) {
                                        String str2;
                                        if (z) {
                                            str2 = C38347a.access$1500(str2);
                                        }
                                        AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.m29651j(C38347a.this.hPq.appId, str2, z | 0);
                                        if (j != null) {
                                            arrayList.add(Long.valueOf(j.gjQ));
                                            arrayList2.add(j.czD);
                                        } else {
                                            C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", str2);
                                        }
                                    }
                                    if (arrayList2.size() == 0) {
                                        C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                                        C38347a.this.hPp.bFZ = -2;
                                        C38347a.m64904e(C38347a.this, C38347a.this.hPp);
                                        AppMethodBeat.m2505o(131173);
                                        return;
                                    }
                                    C5004al.m7441d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(131172);
                                            C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
                                            C38347a.this.hPp.bFZ = -1;
                                            C38347a.this.hPp.type = "image";
                                            C38347a.this.hPp.hPo = C38347a.m64897c(arrayList2, arrayList);
                                            C38347a.m64906f(C38347a.this, C38347a.this.hPp);
                                            AppMethodBeat.m2505o(131172);
                                        }
                                    });
                                    AppMethodBeat.m2505o(131173);
                                }
                            });
                            AppMethodBeat.m2505o(131184);
                            return;
                        }
                        this.mVideoFilePath = (String) stringArrayListExtra.get(0);
                        if (C5046bo.isNullOrNil(this.mVideoFilePath)) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
                            break;
                        }
                        aEi();
                        C42677e.aNS().mo10302aa(new C333574());
                        AppMethodBeat.m2505o(131184);
                        return;
                        break;
                }
                this.hPp.bFZ = -2;
                mo34449a((ProcessResult) this.hPp);
                AppMethodBeat.m2505o(131184);
            }
        }

        private void aEi() {
            AppMethodBeat.m2504i(131185);
            this.hPa = new C333588();
            Context aBQ = aBQ();
            C4996ah.getResources().getString(C25738R.string.f9238tz);
            this.ejZ = C30379h.m48458b(aBQ, C4996ah.getResources().getString(C25738R.string.f8858hb), true, this.hPa);
            AppMethodBeat.m2505o(131185);
        }

        /* renamed from: Bo */
        private static String m64886Bo(String str) {
            AppMethodBeat.m2504i(131186);
            String str2 = C6457e.euR + "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG;
            try {
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str);
                if (decodeFile == null) {
                    C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp return null");
                    AppMethodBeat.m2505o(131186);
                    return null;
                }
                long anU = C5046bo.anU();
                int b = C5062q.m7676b(decodeFile, 70, str2);
                C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "doCompressImage, ret = %d, cost = %d, %s (%d) -> %s (%d)", Integer.valueOf(b), Long.valueOf(C5046bo.anU() - anU), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length()));
                if (b == 1) {
                    try {
                        C2154b.m4366bY(str, str2);
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "doCompressImage, duplicateExif e = %s", e);
                    }
                }
                if (b == 1) {
                    AppMethodBeat.m2505o(131186);
                    return str2;
                }
                AppMethodBeat.m2505o(131186);
                return str;
            } catch (OutOfMemoryError e2) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp oom");
                AppMethodBeat.m2505o(131186);
                return null;
            }
        }

        /* renamed from: Bs */
        private static boolean m64888Bs(String str) {
            AppMethodBeat.m2504i(131188);
            if (TextUtils.isEmpty(str)) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
                AppMethodBeat.m2505o(131188);
                return false;
            }
            File file = new File(str);
            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", str);
            if (file.exists()) {
                C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
                AppMethodBeat.m2505o(131188);
                return true;
            }
            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
            AppMethodBeat.m2505o(131188);
            return false;
        }

        /* renamed from: b */
        private static String m64893b(ArrayList<String> arrayList, ArrayList<Long> arrayList2) {
            AppMethodBeat.m2504i(131189);
            String str;
            if (arrayList == null || arrayList.size() == 0) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
                str = "";
                AppMethodBeat.m2505o(131189);
                return str;
            }
            C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.array();
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONStringer.object();
                    str = (String) arrayList.get(i);
                    Long l = (Long) arrayList2.get(i);
                    jSONStringer.key("tempFilePath");
                    jSONStringer.value(str);
                    jSONStringer.key("size");
                    jSONStringer.value(String.valueOf(l.longValue()));
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                str = jSONStringer.toString();
                AppMethodBeat.m2505o(131189);
                return str;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
                str = "";
                AppMethodBeat.m2505o(131189);
                return str;
            }
        }

        /* renamed from: c */
        private static String m64896c(String str, String str2, int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(131190);
            String str3;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
                str3 = "";
                AppMethodBeat.m2505o(131190);
                return str3;
            }
            C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.array();
                jSONStringer.object();
                jSONStringer.key("tempFilePath");
                jSONStringer.value(str);
                jSONStringer.key("thumbTempFilePath");
                jSONStringer.value(str2);
                jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                jSONStringer.value(String.valueOf(i));
                jSONStringer.key("height");
                jSONStringer.value(String.valueOf(i2));
                jSONStringer.key("width");
                jSONStringer.value(String.valueOf(i3));
                jSONStringer.key("size");
                jSONStringer.value(String.valueOf(i4));
                jSONStringer.endObject();
                jSONStringer.endArray();
                str3 = jSONStringer.toString();
                AppMethodBeat.m2505o(131190);
                return str3;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
                str3 = "";
                AppMethodBeat.m2505o(131190);
                return str3;
            }
        }

        /* renamed from: Br */
        private AppBrandLocalVideoObject m64887Br(String str) {
            int i;
            int i2;
            MediaMetadataRetriever mediaMetadataRetriever;
            AppMethodBeat.m2504i(131187);
            try {
                boolean vC = C42258c.m74643vC(str);
                C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "checkRemux, isMp4 = %b", Boolean.valueOf(vC));
                int i3 = -10000;
                if (vC) {
                    i3 = SightVideoJNI.shouldRemuxing(str, 660, 500, 26214400, 300000.0d, 1000000);
                    C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "checkRemux, ret = %d", Integer.valueOf(i3));
                }
                if (i3 == -1 || !vC) {
                    C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "fileLength = %d", Integer.valueOf(C1173e.m2560cs(str)));
                    if (C1173e.m2560cs(str) > 26214400) {
                        i3 = -1;
                    } else {
                        i3 = 1;
                    }
                }
                switch (i3) {
                    case -6:
                    case -5:
                    case -4:
                    case -3:
                    case -2:
                    case -1:
                        i3 = -50002;
                        break;
                    case 0:
                        i3 = -50006;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        i3 = 1;
                        break;
                    default:
                        C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "unknown check type");
                        i3 = -50001;
                        break;
                }
                if (i3 == -50006) {
                    int[] iArr = new int[2];
                    C30076j.m47631c(str, iArr);
                    i = iArr[0];
                    i2 = iArr[1];
                    String str2 = C6457e.euR + "microMsg." + System.currentTimeMillis() + VideoMaterialUtil.MP4_SUFFIX;
                    i3 = SightVideoJNI.remuxing(str, str2, i, i2, C29014b.qwZ, C29014b.qwY, 8, 2, 25.0f, C29014b.qxa, null, 0, false);
                    C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                    str = str2;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", C5046bo.m7574l(e));
            }
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e2);
                mediaMetadataRetriever = null;
            }
            if (mediaMetadataRetriever == null) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
                AppMethodBeat.m2505o(131187);
                return null;
            }
            int i4 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            i = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
            mediaMetadataRetriever.release();
            AppBrandLocalVideoObject bs = AppBrandLocalMediaObjectManager.m29646bs(this.hPq.appId, str);
            if (bs == null) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
                AppMethodBeat.m2505o(131187);
                return null;
            }
            bs.duration = (i2 + 500) / 1000;
            bs.width = i4;
            bs.height = i;
            bs.size = C1173e.m2560cs(str);
            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", bs);
            AppMethodBeat.m2505o(131187);
            return bs;
        }

        /* renamed from: g */
        static /* synthetic */ String m64907g(C38347a c38347a) {
            String str;
            AppMethodBeat.m2504i(131199);
            if (!TextUtils.isEmpty(c38347a.hPr)) {
                AppBrandLocalMediaObject j = AppBrandLocalMediaObjectManager.m29651j(c38347a.hPq.appId, c38347a.hPr, true);
                if (j == null || C5046bo.isNullOrNil(j.czD)) {
                    C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "addThumbItem error, localId is null");
                } else {
                    str = j.czD;
                    AppMethodBeat.m2505o(131199);
                    return str;
                }
            }
            str = "";
            AppMethodBeat.m2505o(131199);
            return str;
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131213);
        if (hPi) {
            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
            c2241c.mo6107M(i, mo73394j("cancel", null));
            AppMethodBeat.m2505o(131213);
            return;
        }
        Context context = c2241c.getContext();
        if (context == null || !(context instanceof Activity)) {
            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
            c2241c.mo6107M(i, mo73394j("fail:page context is null", null));
            AppMethodBeat.m2505o(131213);
        } else if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(131213);
        } else {
            String str;
            String str2;
            int i2;
            String str3;
            String str4;
            boolean z;
            C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + jSONObject.toString());
            String str5 = "";
            if (jSONObject.optJSONArray("sourceType") == null || jSONObject.optJSONArray("sourceType").length() <= 0) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
            } else {
                str5 = jSONObject.optJSONArray("sourceType").toString();
            }
            if (C5046bo.isNullOrNil(str5)) {
                str = "camera|album";
            } else {
                str = str5;
            }
            str5 = "";
            if (jSONObject.optJSONArray("mediaType") == null || jSONObject.optJSONArray("mediaType").length() <= 0) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
            } else {
                str5 = jSONObject.optJSONArray("mediaType").toString();
            }
            if (C5046bo.isNullOrNil(str5)) {
                str2 = "video|image";
            } else {
                str2 = str5;
            }
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            if (min < 3 || min > 10) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "maxDuration is invalid");
                i2 = 10;
            } else {
                i2 = min;
            }
            str5 = jSONObject.optString("camera");
            if (C5046bo.isNullOrNil(str5)) {
                str3 = "back";
            } else {
                str3 = str5;
            }
            int min2 = Math.min(jSONObject.optInt("count", 9), 9);
            str5 = "";
            if (jSONObject.optJSONArray("sizeType") == null || jSONObject.optJSONArray("sizeType").length() <= 0) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
            } else {
                str5 = jSONObject.optJSONArray("sizeType").toString();
            }
            if (C5046bo.isNullOrNil(str5)) {
                str4 = "original|compressed";
            } else {
                str4 = str5;
            }
            C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", str, str2, Integer.valueOf(i2), str3, Integer.valueOf(min2), str4);
            C19663n.m30463b(c2241c.getAppId(), new C0315a() {
                public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    AppMethodBeat.m2504i(131156);
                    if (i != 120) {
                        C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "requestAudioPermission requestCode is not for choose media");
                        AppMethodBeat.m2505o(131156);
                    } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "requestAudioPermission sys perm denied for choose media");
                        c2241c.mo6107M(i, JsApiChooseMedia.this.mo73394j("fail:system permission denied", null));
                        AppMethodBeat.m2505o(131156);
                    } else {
                        C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "requestAudioPermission permission is grant for choose media");
                        JsApiChooseMedia.this.mo5994a(c2241c, jSONObject, i);
                        AppMethodBeat.m2505o(131156);
                    }
                }
            });
            Context context2 = c2241c.getContext();
            if (context2 == null || !(context2 instanceof Activity)) {
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
                c2241c.mo6107M(i, mo73394j("fail", null));
                z = false;
            } else {
                z = C35805b.m58707a((Activity) context2, "android.permission.RECORD_AUDIO", 120, "", "");
                if (z) {
                    C19663n.m30460Dr(c2241c.getAppId());
                }
            }
            if (z) {
                C19663n.m30463b(c2241c.getAppId(), new C0315a() {
                    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                        AppMethodBeat.m2504i(131157);
                        if (i != C31128d.MIC_AVROUND_BLUR) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
                            AppMethodBeat.m2505o(131157);
                        } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
                            c2241c.mo6107M(i, JsApiChooseMedia.this.mo73394j("fail:system permission denied", null));
                            AppMethodBeat.m2505o(131157);
                        } else {
                            C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
                            JsApiChooseMedia.this.mo5994a(c2241c, jSONObject, i);
                            AppMethodBeat.m2505o(131157);
                        }
                    }
                });
                context2 = c2241c.getContext();
                if (context2 == null || !(context2 instanceof Activity)) {
                    C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
                    c2241c.mo6107M(i, mo73394j("fail", null));
                    z = false;
                } else {
                    z = C35805b.m58707a((Activity) context2, "android.permission.CAMERA", C31128d.MIC_AVROUND_BLUR, "", "");
                    if (z) {
                        C19663n.m30460Dr(c2241c.getAppId());
                    }
                }
                if (z) {
                    C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
                    hPi = true;
                    C33183g.m54274a(c2241c.getAppId(), new C33186c() {
                        public final void onResume() {
                            AppMethodBeat.m2504i(131154);
                            C4990ab.m7416i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
                            JsApiChooseMedia.hPi = false;
                            C33183g.m54276b(c2241c.getAppId(), this);
                            AppMethodBeat.m2505o(131154);
                        }
                    });
                    ChooseRequest chooseRequest = new ChooseRequest();
                    chooseRequest.appId = c2241c.getAppId();
                    chooseRequest.hPk = str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                    chooseRequest.hPl = str.contains("camera");
                    chooseRequest.hPm = str2.contains("image");
                    chooseRequest.hPn = str2.contains("video");
                    if (str3.contains("back") || !str3.contains("front")) {
                        chooseRequest.isFront = false;
                    } else {
                        chooseRequest.isFront = true;
                    }
                    chooseRequest.maxDuration = i2;
                    chooseRequest.count = min2;
                    chooseRequest.hOU = str4.contains("compressed");
                    chooseRequest.hOV = str4.contains("original");
                    C26907a.m42840a(context, chooseRequest, new C19247b<ChooseResult>() {
                        /* renamed from: c */
                        public final /* synthetic */ void mo6053c(ProcessResult processResult) {
                            AppMethodBeat.m2504i(131155);
                            ChooseResult chooseResult = (ChooseResult) processResult;
                            JsApiChooseMedia.hPi = false;
                            if (chooseResult == null) {
                                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult result is null");
                                c2241c.mo6107M(i, JsApiChooseMedia.this.mo73394j("fail", null));
                                AppMethodBeat.m2505o(131155);
                                return;
                            }
                            switch (chooseResult.bFZ) {
                                case -1:
                                    String str = chooseResult.type;
                                    String str2 = chooseResult.hPo;
                                    if (C5046bo.isNullOrNil(str2)) {
                                        C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult localIds is null");
                                        c2241c.mo6107M(i, JsApiChooseMedia.this.mo73394j("fail", null));
                                        AppMethodBeat.m2505o(131155);
                                        return;
                                    }
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("type", str);
                                    hashMap.put("tempFiles", str2);
                                    C4990ab.m7417i("MicroMsg.JsApiChooseMedia", "chooseMedia ok, type:%s, localIds:%s", str, str2);
                                    c2241c.mo6107M(i, JsApiChooseMedia.this.mo73394j("ok", hashMap));
                                    AppMethodBeat.m2505o(131155);
                                    return;
                                case 0:
                                    C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult user cancel");
                                    c2241c.mo6107M(i, JsApiChooseMedia.this.mo73394j("fail:cancel", null));
                                    AppMethodBeat.m2505o(131155);
                                    return;
                                default:
                                    C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult");
                                    c2241c.mo6107M(i, JsApiChooseMedia.this.mo73394j("fail", null));
                                    AppMethodBeat.m2505o(131155);
                                    return;
                            }
                        }
                    });
                    AppMethodBeat.m2505o(131213);
                    return;
                }
                C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
                AppMethodBeat.m2505o(131213);
                return;
            }
            C4990ab.m7412e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
            AppMethodBeat.m2505o(131213);
        }
    }
}
