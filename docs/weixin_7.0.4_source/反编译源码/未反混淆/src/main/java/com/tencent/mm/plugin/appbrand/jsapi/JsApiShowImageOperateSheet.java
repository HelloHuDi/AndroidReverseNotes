package com.tencent.mm.plugin.appbrand.jsapi;

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
import com.tencent.luggage.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiShowImageOperateSheet extends a<w> {
    public static final int CTRL_INDEX = 626;
    public static final String NAME = "showImageOperateSheet";

    static class BottomSheetLogicHelper {
        private static Set<Integer> hyQ;
        private static Set<Integer> hyR;
        private IPCQRCodeRecognizeResult hyS;
        private com.tencent.mm.ui.widget.a.d hyT;
        private final w hyU;
        private final String hyV;
        private final String hyW;
        private final Rect hyX;

        static final class IPCProcessQRCodeResultRequest extends ProcessRequest {
            public static final Creator<IPCProcessQRCodeResultRequest> CREATOR = new Creator<IPCProcessQRCodeResultRequest>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new IPCProcessQRCodeResultRequest[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(130586);
                    IPCProcessQRCodeResultRequest iPCProcessQRCodeResultRequest = new IPCProcessQRCodeResultRequest(parcel);
                    AppMethodBeat.o(130586);
                    return iPCProcessQRCodeResultRequest;
                }
            };
            private IPCQRCodeRecognizeResult hzh;
            private String hzi;
            private String hzj;

            protected IPCProcessQRCodeResultRequest() {
            }

            protected IPCProcessQRCodeResultRequest(Parcel parcel) {
                AppMethodBeat.i(130587);
                this.hzh = (IPCQRCodeRecognizeResult) parcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader());
                this.hzi = parcel.readString();
                this.hzj = parcel.readString();
                AppMethodBeat.o(130587);
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.i(130588);
                parcel.writeParcelable(this.hzh, i);
                parcel.writeString(this.hzi);
                parcel.writeString(this.hzj);
                AppMethodBeat.o(130588);
            }

            public final int describeContents() {
                return 0;
            }

            public final boolean aBY() {
                return true;
            }

            static {
                AppMethodBeat.i(130589);
                AppMethodBeat.o(130589);
            }

            public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
                return b.class;
            }
        }

        static final class b extends AppBrandProxyUIProcessTask {
            private b() {
            }

            public final void a(ProcessRequest processRequest) {
                AppMethodBeat.i(130590);
                if (processRequest instanceof IPCProcessQRCodeResultRequest) {
                    IPCProcessQRCodeResultRequest iPCProcessQRCodeResultRequest = (IPCProcessQRCodeResultRequest) processRequest;
                    cf cfVar = new cf();
                    cfVar.cvm.activity = aBQ();
                    cfVar.cvm.ctB = iPCProcessQRCodeResultRequest.hzh.result;
                    cfVar.cvm.cvn = iPCProcessQRCodeResultRequest.hzh.cvn;
                    cfVar.cvm.cvo = iPCProcessQRCodeResultRequest.hzh.cvo;
                    cfVar.cvm.scene = 44;
                    Bundle bundle = new Bundle();
                    bundle.putInt("stat_scene", 6);
                    bundle.putString("stat_app_id", iPCProcessQRCodeResultRequest.hzi);
                    bundle.putString("stat_url", iPCProcessQRCodeResultRequest.hzj);
                    cfVar.cvm.cvs = bundle;
                    com.tencent.mm.sdk.b.a.xxA.m(cfVar);
                    AppMethodBeat.o(130590);
                    return;
                }
                ab.e("MicroMsg.JsApiShowImageOperateSheet", "IPCProcessQRCodeResultTask request instance not valid");
                AppMethodBeat.o(130590);
            }
        }

        static final class IPCQRCodeRecognizeParam implements Parcelable {
            public static final Creator<IPCQRCodeRecognizeParam> CREATOR = new Creator<IPCQRCodeRecognizeParam>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new IPCQRCodeRecognizeParam[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(130598);
                    IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam = new IPCQRCodeRecognizeParam(parcel);
                    AppMethodBeat.o(130598);
                    return iPCQRCodeRecognizeParam;
                }
            };
            private String hzq;
            private String hzr;

            protected IPCQRCodeRecognizeParam() {
            }

            protected IPCQRCodeRecognizeParam(Parcel parcel) {
                AppMethodBeat.i(130599);
                this.hzq = parcel.readString();
                this.hzr = parcel.readString();
                AppMethodBeat.o(130599);
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.i(130600);
                parcel.writeString(this.hzq);
                parcel.writeString(this.hzr);
                AppMethodBeat.o(130600);
            }

            static {
                AppMethodBeat.i(130601);
                AppMethodBeat.o(130601);
            }
        }

        static final class a implements com.tencent.mm.ipcinvoker.a<IPCString, IPCInteger> {
            private a() {
            }

            public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
                AppMethodBeat.i(130585);
                IPCString iPCString = (IPCString) obj;
                if (iPCString == null) {
                    ab.e("MicroMsg.JsApiShowImageOperateSheet", "IPCFav data null");
                    AppMethodBeat.o(130585);
                    return;
                }
                cl clVar = new cl();
                ((ad) g.K(ad.class)).a(clVar, 1, iPCString.value);
                clVar.cvA.cvH = 32;
                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                if (cVar != null) {
                    cVar.ao(new IPCInteger(clVar.cvB.ret));
                }
                AppMethodBeat.o(130585);
            }
        }

        static final class IPCQRCodeRecognizeResult implements Parcelable {
            public static final Creator<IPCQRCodeRecognizeResult> CREATOR = new Creator<IPCQRCodeRecognizeResult>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new IPCQRCodeRecognizeResult[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(130602);
                    IPCQRCodeRecognizeResult iPCQRCodeRecognizeResult = new IPCQRCodeRecognizeResult(parcel);
                    AppMethodBeat.o(130602);
                    return iPCQRCodeRecognizeResult;
                }
            };
            private int cvn;
            private int cvo;
            private String filePath;
            private String result;

            protected IPCQRCodeRecognizeResult() {
            }

            protected IPCQRCodeRecognizeResult(Parcel parcel) {
                AppMethodBeat.i(130603);
                this.result = parcel.readString();
                this.filePath = parcel.readString();
                this.cvn = parcel.readInt();
                this.cvo = parcel.readInt();
                AppMethodBeat.o(130603);
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.i(130604);
                parcel.writeString(this.result);
                parcel.writeString(this.filePath);
                parcel.writeInt(this.cvn);
                parcel.writeInt(this.cvo);
                AppMethodBeat.o(130604);
            }

            static {
                AppMethodBeat.i(130605);
                AppMethodBeat.o(130605);
            }
        }

        static final class IPCSendToFriendEmojiRequest extends ProcessRequest {
            public static final Creator<IPCSendToFriendEmojiRequest> CREATOR = new Creator<IPCSendToFriendEmojiRequest>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new IPCSendToFriendEmojiRequest[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(130606);
                    IPCSendToFriendEmojiRequest iPCSendToFriendEmojiRequest = new IPCSendToFriendEmojiRequest(parcel);
                    AppMethodBeat.o(130606);
                    return iPCSendToFriendEmojiRequest;
                }
            };
            private String hzs;

            protected IPCSendToFriendEmojiRequest() {
            }

            protected IPCSendToFriendEmojiRequest(Parcel parcel) {
                AppMethodBeat.i(130607);
                this.hzs = parcel.readString();
                AppMethodBeat.o(130607);
            }

            public final void writeToParcel(Parcel parcel, int i) {
                AppMethodBeat.i(130608);
                parcel.writeString(this.hzs);
                AppMethodBeat.o(130608);
            }

            public final int describeContents() {
                return 0;
            }

            static {
                AppMethodBeat.i(130609);
                AppMethodBeat.o(130609);
            }

            public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
                return d.class;
            }
        }

        static final class d extends AppBrandProxyUIProcessTask {
            private d() {
            }

            public final void a(ProcessRequest processRequest) {
                AppMethodBeat.i(130610);
                if (processRequest instanceof IPCSendToFriendEmojiRequest) {
                    EmojiInfo Jd;
                    String a = ((IPCSendToFriendEmojiRequest) processRequest).hzs;
                    EmojiInfo Jd2 = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(e.atg(a));
                    if (Jd2 == null) {
                        com.tencent.mm.pluginsdk.a.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                        ah.getContext();
                        Jd = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(emojiMgr.Jf(a));
                    } else {
                        Jd = Jd2;
                    }
                    long asZ = Jd == null ? 0 : e.asZ(Jd.dve());
                    String dve = Jd == null ? a : Jd.dve();
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    boolean z;
                    if ((com.tencent.mm.sdk.platformtools.d.decodeFile(dve, options) == null || options.outHeight <= com.tencent.mm.m.b.Na()) && options.outWidth <= com.tencent.mm.m.b.Na()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (asZ > ((long) com.tencent.mm.m.b.Nb()) || z) {
                        h.a(aBQ(), ah.getResources().getString(R.string.b9x), "", ah.getResources().getString(R.string.cd_), null);
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("Retr_File_Name", Jd == null ? "" : Jd.Aq());
                        intent.putExtra("Retr_Msg_Type", 5);
                        intent.putExtra("Retr_MsgImgScene", 1);
                        com.tencent.mm.bp.d.f(aBQ(), ".ui.transmit.MsgRetransmitUI", intent);
                    }
                    a(null);
                    AppMethodBeat.o(130610);
                    return;
                }
                ab.e("MicroMsg.JsApiShowImageOperateSheet", "IPCSendToFriendEmojiRequest request instance not valid");
                AppMethodBeat.o(130610);
            }
        }

        static final class c implements com.tencent.mm.ipcinvoker.a<IPCQRCodeRecognizeParam, IPCQRCodeRecognizeResult> {
            private boolean hzk = false;

            private c() {
            }

            public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
                AppMethodBeat.i(130596);
                IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam = (IPCQRCodeRecognizeParam) obj;
                if (iPCQRCodeRecognizeParam == null) {
                    ab.e("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize data null");
                    AppMethodBeat.o(130596);
                    return;
                }
                a(iPCQRCodeRecognizeParam, cVar, false);
                AppMethodBeat.o(130596);
            }

            private void a(IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam, com.tencent.mm.ipcinvoker.c<IPCQRCodeRecognizeResult> cVar, boolean z) {
                AppMethodBeat.i(130595);
                final String a = z ? iPCQRCodeRecognizeParam.hzr : iPCQRCodeRecognizeParam.hzq;
                ab.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", Boolean.valueOf(this.hzk), Boolean.valueOf(z), a);
                this.hzk = z;
                if (bo.isNullOrNil(a)) {
                    AppMethodBeat.o(130595);
                    return;
                }
                final j jVar = new j();
                final j jVar2 = new j();
                final com.tencent.mm.ipcinvoker.c<IPCQRCodeRecognizeResult> cVar2 = cVar;
                AnonymousClass1 anonymousClass1 = new com.tencent.mm.sdk.b.c<nr>() {
                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(130592);
                        nr nrVar = (nr) bVar;
                        ab.i("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize callback");
                        if (jVar.value != null) {
                            com.tencent.mm.sdk.b.a.xxA.d((com.tencent.mm.sdk.b.c) jVar.value);
                        }
                        if (jVar2.value != null) {
                            com.tencent.mm.sdk.b.a.xxA.d((com.tencent.mm.sdk.b.c) jVar2.value);
                        }
                        if (a.equals(nrVar.cJX.filePath)) {
                            ab.d("MicroMsg.JsApiShowImageOperateSheet", "result: " + nrVar.cJX.result);
                            if (cVar2 != null) {
                                IPCQRCodeRecognizeResult iPCQRCodeRecognizeResult = new IPCQRCodeRecognizeResult();
                                iPCQRCodeRecognizeResult.result = nrVar.cJX.result;
                                iPCQRCodeRecognizeResult.filePath = nrVar.cJX.filePath;
                                iPCQRCodeRecognizeResult.cvn = nrVar.cJX.cvn;
                                iPCQRCodeRecognizeResult.cvo = nrVar.cJX.cvo;
                                cVar2.ao(iPCQRCodeRecognizeResult);
                            }
                        } else {
                            ab.w("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize file path no same recognizeFilePath:%s filePath:%s", a, nrVar.cJX.filePath);
                        }
                        AppMethodBeat.o(130592);
                        return false;
                    }
                };
                jVar.value = anonymousClass1;
                final j jVar3 = jVar;
                final j jVar4 = jVar2;
                final String str = a;
                final IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam2 = iPCQRCodeRecognizeParam;
                final com.tencent.mm.ipcinvoker.c<IPCQRCodeRecognizeResult> cVar3 = cVar;
                AnonymousClass2 anonymousClass2 = new com.tencent.mm.sdk.b.c<nq>() {
                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        AppMethodBeat.i(130594);
                        nq nqVar = (nq) bVar;
                        ab.i("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize failed : mIsBakPathUsed:%b", Boolean.valueOf(c.this.hzk));
                        if (jVar3.value != null) {
                            com.tencent.mm.sdk.b.a.xxA.d((com.tencent.mm.sdk.b.c) jVar3.value);
                        }
                        if (jVar4.value != null) {
                            com.tencent.mm.sdk.b.a.xxA.d((com.tencent.mm.sdk.b.c) jVar4.value);
                        }
                        if (!str.equals(nqVar.cJW.filePath)) {
                            ab.w("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize failed : file path no same recognizeFilePath:%s filePath:%s", str, nqVar.cJW.filePath);
                            AppMethodBeat.o(130594);
                        } else if (c.this.hzk) {
                            AppMethodBeat.o(130594);
                        } else {
                            c.a(c.this, iPCQRCodeRecognizeParam2, cVar3);
                            AppMethodBeat.o(130594);
                        }
                        return false;
                    }
                };
                jVar2.value = anonymousClass2;
                com.tencent.mm.sdk.b.a.xxA.c(anonymousClass1);
                com.tencent.mm.sdk.b.a.xxA.c(anonymousClass2);
                np npVar = new np();
                npVar.cJU.filePath = a;
                npVar.cJU.cJV = BottomSheetLogicHelper.hyQ;
                com.tencent.mm.sdk.b.a.xxA.m(npVar);
                AppMethodBeat.o(130595);
            }
        }

        static {
            AppMethodBeat.i(130619);
            HashSet hashSet = new HashSet();
            hyQ = hashSet;
            hashSet.add(Integer.valueOf(3));
            hashSet = new HashSet();
            hyR = hashSet;
            hashSet.add(Integer.valueOf(22));
            AppMethodBeat.o(130619);
        }

        public BottomSheetLogicHelper(w wVar, String str, String str2, Rect rect) {
            this.hyU = wVar;
            this.hyV = str;
            this.hyW = str2;
            this.hyX = rect;
        }

        public final void aCm() {
            AppMethodBeat.i(130611);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130574);
                    BottomSheetLogicHelper.a(BottomSheetLogicHelper.this);
                    AppMethodBeat.o(130574);
                }
            }, (long) (f.az(this.hyU.mContext) ? 100 : 0));
            AppMethodBeat.o(130611);
        }

        private void a(com.tencent.mm.plugin.appbrand.s.b.a aVar) {
            AppMethodBeat.i(130612);
            if (bo.isNullOrNil(this.hyW)) {
                com.tencent.mm.plugin.appbrand.s.b.a(this.hyU, this.hyV, null, aVar);
                AppMethodBeat.o(130612);
                return;
            }
            com.tencent.mm.vfs.b yh = this.hyU.asE().yh("showSheet_base64_" + System.currentTimeMillis());
            if (yh == null) {
                ab.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
                AppMethodBeat.o(130612);
                return;
            }
            String w = com.tencent.mm.vfs.j.w(yh.dMD());
            byte[] decode = Base64.decode(this.hyW, 0);
            com.tencent.mm.a.e.b(w, decode, decode.length);
            aVar.AN(w);
            AppMethodBeat.o(130612);
        }

        static /* synthetic */ void d(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.i(130615);
            bottomSheetLogicHelper.a(new com.tencent.mm.plugin.appbrand.s.b.a() {
                public final void AN(final String str) {
                    AppMethodBeat.i(130578);
                    ab.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend path:%s", str);
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(130578);
                    } else if (r.amo(str)) {
                        ab.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend as emoji");
                        IPCSendToFriendEmojiRequest iPCSendToFriendEmojiRequest = new IPCSendToFriendEmojiRequest();
                        iPCSendToFriendEmojiRequest.hzs = str;
                        com.tencent.mm.plugin.appbrand.ipc.a.a(BottomSheetLogicHelper.this.hyU.mContext, iPCSendToFriendEmojiRequest, null);
                        AppMethodBeat.o(130578);
                    } else {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(130577);
                                Intent intent = new Intent();
                                intent.putExtra("Retr_File_Name", str);
                                intent.putExtra("Retr_Compress_Type", 0);
                                intent.putExtra("Retr_Msg_Type", 0);
                                com.tencent.mm.bp.d.f(BottomSheetLogicHelper.this.hyU.mContext, ".ui.transmit.MsgRetransmitUI", intent);
                                AppMethodBeat.o(130577);
                            }
                        });
                        AppMethodBeat.o(130578);
                    }
                }
            });
            AppMethodBeat.o(130615);
        }

        static /* synthetic */ void e(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.i(130616);
            bottomSheetLogicHelper.a(new com.tencent.mm.plugin.appbrand.s.b.a() {
                public final void AN(String str) {
                    AppMethodBeat.i(130579);
                    ab.i("MicroMsg.JsApiShowImageOperateSheet", "saveToSDCard localPath:%s", str);
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(130579);
                        return;
                    }
                    n.j(str, BottomSheetLogicHelper.this.hyU.mContext);
                    AppMethodBeat.o(130579);
                }
            });
            AppMethodBeat.o(130616);
        }

        static /* synthetic */ void f(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.i(130617);
            bottomSheetLogicHelper.a(new com.tencent.mm.plugin.appbrand.s.b.a() {
                public final void AN(String str) {
                    AppMethodBeat.i(130582);
                    ab.i("MicroMsg.JsApiShowImageOperateSheet", "fav localPath:%s", str);
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(130582);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", new IPCString(str), a.class, new com.tencent.mm.ipcinvoker.c<IPCInteger>() {
                        public final /* synthetic */ void ao(Object obj) {
                            AppMethodBeat.i(130581);
                            IPCInteger iPCInteger = (IPCInteger) obj;
                            if (iPCInteger == null) {
                                ab.e("MicroMsg.JsApiShowImageOperateSheet", "fav ipc callback data null");
                                AppMethodBeat.o(130581);
                                return;
                            }
                            ab.i("MicroMsg.JsApiShowImageOperateSheet", "fav result:%d", Integer.valueOf(iPCInteger.value));
                            final Context context = BottomSheetLogicHelper.this.hyU.mContext;
                            if (iPCInteger.value == 0 && (context instanceof Activity)) {
                                al.d(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(130580);
                                        com.tencent.mm.ui.widget.snackbar.b.i((Activity) context, context.getString(R.string.bpv));
                                        AppMethodBeat.o(130580);
                                    }
                                });
                            }
                            AppMethodBeat.o(130581);
                        }
                    });
                    AppMethodBeat.o(130582);
                }
            });
            AppMethodBeat.o(130617);
        }

        static /* synthetic */ void g(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.i(130618);
            ab.i("MicroMsg.JsApiShowImageOperateSheet", "processQRCodeResultLogic");
            if (bottomSheetLogicHelper.hyS == null || bo.isNullOrNil(bottomSheetLogicHelper.hyS.result)) {
                ab.w("MicroMsg.JsApiShowImageOperateSheet", "processQRCodeResultLogic result nil");
                AppMethodBeat.o(130618);
                return;
            }
            IPCProcessQRCodeResultRequest iPCProcessQRCodeResultRequest = new IPCProcessQRCodeResultRequest();
            iPCProcessQRCodeResultRequest.hzh = bottomSheetLogicHelper.hyS;
            iPCProcessQRCodeResultRequest.hzi = bottomSheetLogicHelper.hyU.getAppId();
            iPCProcessQRCodeResultRequest.hzj = bottomSheetLogicHelper.hyU.getURL();
            com.tencent.mm.plugin.appbrand.ipc.a.a(bottomSheetLogicHelper.hyU.mContext, iPCProcessQRCodeResultRequest, null);
            AppMethodBeat.o(130618);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130620);
        w wVar = (w) cVar;
        try {
            String string = jSONObject.getString("imageUrl");
            String string2 = jSONObject.getString("imageBase64");
            int qb = com.tencent.mm.plugin.appbrand.r.g.qb(jSONObject.getInt("elementLeft"));
            int qb2 = com.tencent.mm.plugin.appbrand.r.g.qb(jSONObject.getInt("elementTop"));
            new BottomSheetLogicHelper(wVar, string, string2, new Rect(qb, qb2, com.tencent.mm.plugin.appbrand.r.g.qb(jSONObject.getInt("elementWidth")) + qb, com.tencent.mm.plugin.appbrand.r.g.qb(jSONObject.getInt("elementHeight")) + qb2)).aCm();
            wVar.M(i, j("ok", null));
            AppMethodBeat.o(130620);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiShowImageOperateSheet", "fail exp:%s", e.getLocalizedMessage());
            wVar.M(i, j("fail invalid params", null));
            AppMethodBeat.o(130620);
        }
    }
}
