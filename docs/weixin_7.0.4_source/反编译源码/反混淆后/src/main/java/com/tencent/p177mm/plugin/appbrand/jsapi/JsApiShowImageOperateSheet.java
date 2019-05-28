package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.view.MenuItem;
import com.tencent.luggage.p147g.C8873f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.ipcinvoker.type.IPCInteger;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C37774nq;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p329s.C45682b;
import com.tencent.p177mm.plugin.appbrand.p329s.C45682b.C19711a;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.fav.p407a.C6893ad;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet */
public final class JsApiShowImageOperateSheet extends C10296a<C27242w> {
    public static final int CTRL_INDEX = 626;
    public static final String NAME = "showImageOperateSheet";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper */
    static class BottomSheetLogicHelper {
        private static Set<Integer> hyQ;
        private static Set<Integer> hyR;
        private IPCQRCodeRecognizeResult hyS;
        private C36356d hyT;
        private final C27242w hyU;
        private final String hyV;
        private final String hyW;
        private final Rect hyX;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$4 */
        class C21964 implements C15994a {
            C21964() {
            }

            public final void onDismiss() {
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCProcessQRCodeResultRequest */
        static final class IPCProcessQRCodeResultRequest extends ProcessRequest {
            public static final Creator<IPCProcessQRCodeResultRequest> CREATOR = new C21991();
            private IPCQRCodeRecognizeResult hzh;
            private String hzi;
            private String hzj;

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCProcessQRCodeResultRequest$1 */
            static class C21991 implements Creator<IPCProcessQRCodeResultRequest> {
                C21991() {
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new IPCProcessQRCodeResultRequest[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.m2504i(130586);
                    IPCProcessQRCodeResultRequest iPCProcessQRCodeResultRequest = new IPCProcessQRCodeResultRequest(parcel);
                    AppMethodBeat.m2505o(130586);
                    return iPCProcessQRCodeResultRequest;
                }
            }

            protected IPCProcessQRCodeResultRequest() {
            }

            protected IPCProcessQRCodeResultRequest(Parcel parcel) {
                AppMethodBeat.m2504i(130587);
                this.hzh = (IPCQRCodeRecognizeResult) parcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader());
                this.hzi = parcel.readString();
                this.hzj = parcel.readString();
                AppMethodBeat.m2505o(130587);
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.m2504i(130588);
                parcel.writeParcelable(this.hzh, i);
                parcel.writeString(this.hzi);
                parcel.writeString(this.hzj);
                AppMethodBeat.m2505o(130588);
            }

            public final int describeContents() {
                return 0;
            }

            public final boolean aBY() {
                return true;
            }

            static {
                AppMethodBeat.m2504i(130589);
                AppMethodBeat.m2505o(130589);
            }

            public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
                return C10291b.class;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$5 */
        class C102885 implements C19711a {
            C102885() {
            }

            /* renamed from: AN */
            public final void mo21737AN(final String str) {
                AppMethodBeat.m2504i(130578);
                C4990ab.m7417i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend path:%s", str);
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(130578);
                } else if (C5063r.amo(str)) {
                    C4990ab.m7416i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend as emoji");
                    IPCSendToFriendEmojiRequest iPCSendToFriendEmojiRequest = new IPCSendToFriendEmojiRequest();
                    iPCSendToFriendEmojiRequest.hzs = str;
                    C26907a.m42840a(BottomSheetLogicHelper.this.hyU.mContext, iPCSendToFriendEmojiRequest, null);
                    AppMethodBeat.m2505o(130578);
                } else {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(130577);
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", str);
                            intent.putExtra("Retr_Compress_Type", 0);
                            intent.putExtra("Retr_Msg_Type", 0);
                            C25985d.m41473f(BottomSheetLogicHelper.this.hyU.mContext, ".ui.transmit.MsgRetransmitUI", intent);
                            AppMethodBeat.m2505o(130577);
                        }
                    });
                    AppMethodBeat.m2505o(130578);
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$7 */
        class C102907 implements C19711a {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$7$1 */
            class C21971 implements C18507c<IPCInteger> {
                C21971() {
                }

                /* renamed from: ao */
                public final /* synthetic */ void mo5960ao(Object obj) {
                    AppMethodBeat.m2504i(130581);
                    IPCInteger iPCInteger = (IPCInteger) obj;
                    if (iPCInteger == null) {
                        C4990ab.m7412e("MicroMsg.JsApiShowImageOperateSheet", "fav ipc callback data null");
                        AppMethodBeat.m2505o(130581);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.JsApiShowImageOperateSheet", "fav result:%d", Integer.valueOf(iPCInteger.value));
                    final Context context = BottomSheetLogicHelper.this.hyU.mContext;
                    if (iPCInteger.value == 0 && (context instanceof Activity)) {
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(130580);
                                C5670b.m8523i((Activity) context, context.getString(C25738R.string.bpv));
                                AppMethodBeat.m2505o(130580);
                            }
                        });
                    }
                    AppMethodBeat.m2505o(130581);
                }
            }

            C102907() {
            }

            /* renamed from: AN */
            public final void mo21737AN(String str) {
                AppMethodBeat.m2504i(130582);
                C4990ab.m7417i("MicroMsg.JsApiShowImageOperateSheet", "fav localPath:%s", str);
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(130582);
                    return;
                }
                C9549f.m17012a("com.tencent.mm", new IPCString(str), C16621a.class, new C21971());
                AppMethodBeat.m2505o(130582);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$b */
        static final class C10291b extends AppBrandProxyUIProcessTask {
            private C10291b() {
            }

            /* renamed from: a */
            public final void mo6047a(ProcessRequest processRequest) {
                AppMethodBeat.m2504i(130590);
                if (processRequest instanceof IPCProcessQRCodeResultRequest) {
                    IPCProcessQRCodeResultRequest iPCProcessQRCodeResultRequest = (IPCProcessQRCodeResultRequest) processRequest;
                    C26102cf c26102cf = new C26102cf();
                    c26102cf.cvm.activity = aBQ();
                    c26102cf.cvm.ctB = iPCProcessQRCodeResultRequest.hzh.result;
                    c26102cf.cvm.cvn = iPCProcessQRCodeResultRequest.hzh.cvn;
                    c26102cf.cvm.cvo = iPCProcessQRCodeResultRequest.hzh.cvo;
                    c26102cf.cvm.scene = 44;
                    Bundle bundle = new Bundle();
                    bundle.putInt("stat_scene", 6);
                    bundle.putString("stat_app_id", iPCProcessQRCodeResultRequest.hzi);
                    bundle.putString("stat_url", iPCProcessQRCodeResultRequest.hzj);
                    c26102cf.cvm.cvs = bundle;
                    C4879a.xxA.mo10055m(c26102cf);
                    AppMethodBeat.m2505o(130590);
                    return;
                }
                C4990ab.m7412e("MicroMsg.JsApiShowImageOperateSheet", "IPCProcessQRCodeResultTask request instance not valid");
                AppMethodBeat.m2505o(130590);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeParam */
        static final class IPCQRCodeRecognizeParam implements Parcelable {
            public static final Creator<IPCQRCodeRecognizeParam> CREATOR = new C22001();
            private String hzq;
            private String hzr;

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeParam$1 */
            static class C22001 implements Creator<IPCQRCodeRecognizeParam> {
                C22001() {
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new IPCQRCodeRecognizeParam[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.m2504i(130598);
                    IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam = new IPCQRCodeRecognizeParam(parcel);
                    AppMethodBeat.m2505o(130598);
                    return iPCQRCodeRecognizeParam;
                }
            }

            protected IPCQRCodeRecognizeParam() {
            }

            protected IPCQRCodeRecognizeParam(Parcel parcel) {
                AppMethodBeat.m2504i(130599);
                this.hzq = parcel.readString();
                this.hzr = parcel.readString();
                AppMethodBeat.m2505o(130599);
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.m2504i(130600);
                parcel.writeString(this.hzq);
                parcel.writeString(this.hzr);
                AppMethodBeat.m2505o(130600);
            }

            static {
                AppMethodBeat.m2504i(130601);
                AppMethodBeat.m2505o(130601);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$6 */
        class C166206 implements C19711a {
            C166206() {
            }

            /* renamed from: AN */
            public final void mo21737AN(String str) {
                AppMethodBeat.m2504i(130579);
                C4990ab.m7417i("MicroMsg.JsApiShowImageOperateSheet", "saveToSDCard localPath:%s", str);
                if (C5046bo.isNullOrNil(str)) {
                    AppMethodBeat.m2505o(130579);
                    return;
                }
                C14987n.m23321j(str, BottomSheetLogicHelper.this.hyU.mContext);
                AppMethodBeat.m2505o(130579);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$a */
        static final class C16621a implements C37866a<IPCString, IPCInteger> {
            private C16621a() {
            }

            /* renamed from: a */
            public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
                AppMethodBeat.m2504i(130585);
                IPCString iPCString = (IPCString) obj;
                if (iPCString == null) {
                    C4990ab.m7412e("MicroMsg.JsApiShowImageOperateSheet", "IPCFav data null");
                    AppMethodBeat.m2505o(130585);
                    return;
                }
                C45316cl c45316cl = new C45316cl();
                ((C6893ad) C1720g.m3528K(C6893ad.class)).mo15151a(c45316cl, 1, iPCString.value);
                c45316cl.cvA.cvH = 32;
                C4879a.xxA.mo10055m(c45316cl);
                if (c18507c != null) {
                    c18507c.mo5960ao(new IPCInteger(c45316cl.cvB.ret));
                }
                AppMethodBeat.m2505o(130585);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$1 */
        class C166221 implements Runnable {
            C166221() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130574);
                BottomSheetLogicHelper.m25562a(BottomSheetLogicHelper.this);
                AppMethodBeat.m2505o(130574);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$3 */
        class C166233 implements C5279d {
            C166233() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(130576);
                switch (menuItem.getItemId()) {
                    case 1:
                        BottomSheetLogicHelper.m25567d(BottomSheetLogicHelper.this);
                        AppMethodBeat.m2505o(130576);
                        return;
                    case 2:
                        BottomSheetLogicHelper.m25568e(BottomSheetLogicHelper.this);
                        AppMethodBeat.m2505o(130576);
                        return;
                    case 3:
                        BottomSheetLogicHelper.m25569f(BottomSheetLogicHelper.this);
                        AppMethodBeat.m2505o(130576);
                        return;
                    case 4:
                        BottomSheetLogicHelper.m25570g(BottomSheetLogicHelper.this);
                        break;
                }
                AppMethodBeat.m2505o(130576);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeResult */
        static final class IPCQRCodeRecognizeResult implements Parcelable {
            public static final Creator<IPCQRCodeRecognizeResult> CREATOR = new C166251();
            private int cvn;
            private int cvo;
            private String filePath;
            private String result;

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCQRCodeRecognizeResult$1 */
            static class C166251 implements Creator<IPCQRCodeRecognizeResult> {
                C166251() {
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new IPCQRCodeRecognizeResult[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.m2504i(130602);
                    IPCQRCodeRecognizeResult iPCQRCodeRecognizeResult = new IPCQRCodeRecognizeResult(parcel);
                    AppMethodBeat.m2505o(130602);
                    return iPCQRCodeRecognizeResult;
                }
            }

            protected IPCQRCodeRecognizeResult() {
            }

            protected IPCQRCodeRecognizeResult(Parcel parcel) {
                AppMethodBeat.m2504i(130603);
                this.result = parcel.readString();
                this.filePath = parcel.readString();
                this.cvn = parcel.readInt();
                this.cvo = parcel.readInt();
                AppMethodBeat.m2505o(130603);
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.m2504i(130604);
                parcel.writeString(this.result);
                parcel.writeString(this.filePath);
                parcel.writeInt(this.cvn);
                parcel.writeInt(this.cvo);
                AppMethodBeat.m2505o(130604);
            }

            static {
                AppMethodBeat.m2504i(130605);
                AppMethodBeat.m2505o(130605);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCSendToFriendEmojiRequest */
        static final class IPCSendToFriendEmojiRequest extends ProcessRequest {
            public static final Creator<IPCSendToFriendEmojiRequest> CREATOR = new C166261();
            private String hzs;

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$IPCSendToFriendEmojiRequest$1 */
            static class C166261 implements Creator<IPCSendToFriendEmojiRequest> {
                C166261() {
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new IPCSendToFriendEmojiRequest[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.m2504i(130606);
                    IPCSendToFriendEmojiRequest iPCSendToFriendEmojiRequest = new IPCSendToFriendEmojiRequest(parcel);
                    AppMethodBeat.m2505o(130606);
                    return iPCSendToFriendEmojiRequest;
                }
            }

            protected IPCSendToFriendEmojiRequest() {
            }

            protected IPCSendToFriendEmojiRequest(Parcel parcel) {
                AppMethodBeat.m2504i(130607);
                this.hzs = parcel.readString();
                AppMethodBeat.m2505o(130607);
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.m2504i(130608);
                parcel.writeString(this.hzs);
                AppMethodBeat.m2505o(130608);
            }

            public final int describeContents() {
                return 0;
            }

            static {
                AppMethodBeat.m2504i(130609);
                AppMethodBeat.m2505o(130609);
            }

            public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
                return C16627d.class;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$d */
        static final class C16627d extends AppBrandProxyUIProcessTask {
            private C16627d() {
            }

            /* renamed from: a */
            public final void mo6047a(ProcessRequest processRequest) {
                AppMethodBeat.m2504i(130610);
                if (processRequest instanceof IPCSendToFriendEmojiRequest) {
                    EmojiInfo Jd;
                    String a = ((IPCSendToFriendEmojiRequest) processRequest).hzs;
                    EmojiInfo Jd2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(C5730e.atg(a));
                    if (Jd2 == null) {
                        C44795d emojiMgr = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr();
                        C4996ah.getContext();
                        Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(emojiMgr.mo35598Jf(a));
                    } else {
                        Jd = Jd2;
                    }
                    long asZ = Jd == null ? 0 : C5730e.asZ(Jd.dve());
                    String dve = Jd == null ? a : Jd.dve();
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    boolean z;
                    if ((C5056d.decodeFile(dve, options) == null || options.outHeight <= C42164b.m74339Na()) && options.outWidth <= C42164b.m74339Na()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (asZ > ((long) C42164b.m74340Nb()) || z) {
                        C30379h.m48443a(aBQ(), C4996ah.getResources().getString(C25738R.string.b9x), "", C4996ah.getResources().getString(C25738R.string.cd_), null);
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("Retr_File_Name", Jd == null ? "" : Jd.mo20410Aq());
                        intent.putExtra("Retr_Msg_Type", 5);
                        intent.putExtra("Retr_MsgImgScene", 1);
                        C25985d.m41473f(aBQ(), ".ui.transmit.MsgRetransmitUI", intent);
                    }
                    mo34449a(null);
                    AppMethodBeat.m2505o(130610);
                    return;
                }
                C4990ab.m7412e("MicroMsg.JsApiShowImageOperateSheet", "IPCSendToFriendEmojiRequest request instance not valid");
                AppMethodBeat.m2505o(130610);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet$BottomSheetLogicHelper$c */
        static final class C16630c implements C37866a<IPCQRCodeRecognizeParam, IPCQRCodeRecognizeResult> {
            private boolean hzk = false;

            private C16630c() {
            }

            /* renamed from: a */
            public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
                AppMethodBeat.m2504i(130596);
                IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam = (IPCQRCodeRecognizeParam) obj;
                if (iPCQRCodeRecognizeParam == null) {
                    C4990ab.m7412e("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize data null");
                    AppMethodBeat.m2505o(130596);
                    return;
                }
                m25589a(iPCQRCodeRecognizeParam, c18507c, false);
                AppMethodBeat.m2505o(130596);
            }

            /* renamed from: a */
            private void m25589a(IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam, C18507c<IPCQRCodeRecognizeResult> c18507c, boolean z) {
                AppMethodBeat.m2504i(130595);
                final String a = z ? iPCQRCodeRecognizeParam.hzr : iPCQRCodeRecognizeParam.hzq;
                C4990ab.m7417i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", Boolean.valueOf(this.hzk), Boolean.valueOf(z), a);
                this.hzk = z;
                if (C5046bo.isNullOrNil(a)) {
                    AppMethodBeat.m2505o(130595);
                    return;
                }
                final C19681j c19681j = new C19681j();
                final C19681j c19681j2 = new C19681j();
                final C18507c<IPCQRCodeRecognizeResult> c18507c2 = c18507c;
                C166321 c166321 = new C4884c<C18346nr>() {
                    /* renamed from: a */
                    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                        AppMethodBeat.m2504i(130592);
                        C18346nr c18346nr = (C18346nr) c4883b;
                        C4990ab.m7416i("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize callback");
                        if (c19681j.value != null) {
                            C4879a.xxA.mo10053d((C4884c) c19681j.value);
                        }
                        if (c19681j2.value != null) {
                            C4879a.xxA.mo10053d((C4884c) c19681j2.value);
                        }
                        if (a.equals(c18346nr.cJX.filePath)) {
                            C4990ab.m7410d("MicroMsg.JsApiShowImageOperateSheet", "result: " + c18346nr.cJX.result);
                            if (c18507c2 != null) {
                                IPCQRCodeRecognizeResult iPCQRCodeRecognizeResult = new IPCQRCodeRecognizeResult();
                                iPCQRCodeRecognizeResult.result = c18346nr.cJX.result;
                                iPCQRCodeRecognizeResult.filePath = c18346nr.cJX.filePath;
                                iPCQRCodeRecognizeResult.cvn = c18346nr.cJX.cvn;
                                iPCQRCodeRecognizeResult.cvo = c18346nr.cJX.cvo;
                                c18507c2.mo5960ao(iPCQRCodeRecognizeResult);
                            }
                        } else {
                            C4990ab.m7421w("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize file path no same recognizeFilePath:%s filePath:%s", a, c18346nr.cJX.filePath);
                        }
                        AppMethodBeat.m2505o(130592);
                        return false;
                    }
                };
                c19681j.value = c166321;
                final C19681j c19681j3 = c19681j;
                final C19681j c19681j4 = c19681j2;
                final String str = a;
                final IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam2 = iPCQRCodeRecognizeParam;
                final C18507c<IPCQRCodeRecognizeResult> c18507c3 = c18507c;
                C166312 c166312 = new C4884c<C37774nq>() {
                    /* renamed from: a */
                    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                        AppMethodBeat.m2504i(130594);
                        C37774nq c37774nq = (C37774nq) c4883b;
                        C4990ab.m7417i("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize failed : mIsBakPathUsed:%b", Boolean.valueOf(C16630c.this.hzk));
                        if (c19681j3.value != null) {
                            C4879a.xxA.mo10053d((C4884c) c19681j3.value);
                        }
                        if (c19681j4.value != null) {
                            C4879a.xxA.mo10053d((C4884c) c19681j4.value);
                        }
                        if (!str.equals(c37774nq.cJW.filePath)) {
                            C4990ab.m7421w("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize failed : file path no same recognizeFilePath:%s filePath:%s", str, c37774nq.cJW.filePath);
                            AppMethodBeat.m2505o(130594);
                        } else if (C16630c.this.hzk) {
                            AppMethodBeat.m2505o(130594);
                        } else {
                            C16630c.m25590a(C16630c.this, iPCQRCodeRecognizeParam2, c18507c3);
                            AppMethodBeat.m2505o(130594);
                        }
                        return false;
                    }
                };
                c19681j2.value = c166312;
                C4879a.xxA.mo10052c(c166321);
                C4879a.xxA.mo10052c(c166312);
                C45347np c45347np = new C45347np();
                c45347np.cJU.filePath = a;
                c45347np.cJU.cJV = BottomSheetLogicHelper.hyQ;
                C4879a.xxA.mo10055m(c45347np);
                AppMethodBeat.m2505o(130595);
            }
        }

        static {
            AppMethodBeat.m2504i(130619);
            HashSet hashSet = new HashSet();
            hyQ = hashSet;
            hashSet.add(Integer.valueOf(3));
            hashSet = new HashSet();
            hyR = hashSet;
            hashSet.add(Integer.valueOf(22));
            AppMethodBeat.m2505o(130619);
        }

        public BottomSheetLogicHelper(C27242w c27242w, String str, String str2, Rect rect) {
            this.hyU = c27242w;
            this.hyV = str;
            this.hyW = str2;
            this.hyX = rect;
        }

        public final void aCm() {
            AppMethodBeat.m2504i(130611);
            C5004al.m7442n(new C166221(), (long) (C8873f.m15846az(this.hyU.mContext) ? 100 : 0));
            AppMethodBeat.m2505o(130611);
        }

        /* renamed from: a */
        private void m25564a(C19711a c19711a) {
            AppMethodBeat.m2504i(130612);
            if (C5046bo.isNullOrNil(this.hyW)) {
                C45682b.m84381a(this.hyU, this.hyV, null, c19711a);
                AppMethodBeat.m2505o(130612);
                return;
            }
            C5728b yh = this.hyU.asE().mo34315yh("showSheet_base64_" + System.currentTimeMillis());
            if (yh == null) {
                C4990ab.m7412e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
                AppMethodBeat.m2505o(130612);
                return;
            }
            String w = C5736j.m8649w(yh.dMD());
            byte[] decode = Base64.decode(this.hyW, 0);
            C1173e.m2559b(w, decode, decode.length);
            c19711a.mo21737AN(w);
            AppMethodBeat.m2505o(130612);
        }

        /* renamed from: d */
        static /* synthetic */ void m25567d(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.m2504i(130615);
            bottomSheetLogicHelper.m25564a(new C102885());
            AppMethodBeat.m2505o(130615);
        }

        /* renamed from: e */
        static /* synthetic */ void m25568e(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.m2504i(130616);
            bottomSheetLogicHelper.m25564a(new C166206());
            AppMethodBeat.m2505o(130616);
        }

        /* renamed from: f */
        static /* synthetic */ void m25569f(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.m2504i(130617);
            bottomSheetLogicHelper.m25564a(new C102907());
            AppMethodBeat.m2505o(130617);
        }

        /* renamed from: g */
        static /* synthetic */ void m25570g(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.m2504i(130618);
            C4990ab.m7416i("MicroMsg.JsApiShowImageOperateSheet", "processQRCodeResultLogic");
            if (bottomSheetLogicHelper.hyS == null || C5046bo.isNullOrNil(bottomSheetLogicHelper.hyS.result)) {
                C4990ab.m7420w("MicroMsg.JsApiShowImageOperateSheet", "processQRCodeResultLogic result nil");
                AppMethodBeat.m2505o(130618);
                return;
            }
            IPCProcessQRCodeResultRequest iPCProcessQRCodeResultRequest = new IPCProcessQRCodeResultRequest();
            iPCProcessQRCodeResultRequest.hzh = bottomSheetLogicHelper.hyS;
            iPCProcessQRCodeResultRequest.hzi = bottomSheetLogicHelper.hyU.getAppId();
            iPCProcessQRCodeResultRequest.hzj = bottomSheetLogicHelper.hyU.getURL();
            C26907a.m42840a(bottomSheetLogicHelper.hyU.mContext, iPCProcessQRCodeResultRequest, null);
            AppMethodBeat.m2505o(130618);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130620);
        C27242w c27242w = (C27242w) c2241c;
        try {
            String string = jSONObject.getString("imageUrl");
            String string2 = jSONObject.getString("imageBase64");
            int qb = C42668g.m75571qb(jSONObject.getInt("elementLeft"));
            int qb2 = C42668g.m75571qb(jSONObject.getInt("elementTop"));
            new BottomSheetLogicHelper(c27242w, string, string2, new Rect(qb, qb2, C42668g.m75571qb(jSONObject.getInt("elementWidth")) + qb, C42668g.m75571qb(jSONObject.getInt("elementHeight")) + qb2)).aCm();
            c27242w.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(130620);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.JsApiShowImageOperateSheet", "fail exp:%s", e.getLocalizedMessage());
            c27242w.mo6107M(i, mo73394j("fail invalid params", null));
            AppMethodBeat.m2505o(130620);
        }
    }
}
