package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.e;
import java.lang.ref.WeakReference;

public final class al extends c<pe> {
    private WeakReference<Activity> gWO;
    private a yMa = null;

    public enum a {
        CHATTING_ITEM_VIDEO,
        IMAGE_GALLERY_UI,
        VIDEO_GALLERY;

        static {
            AppMethodBeat.o(30993);
        }
    }

    public al(a aVar, Activity activity) {
        super(0);
        AppMethodBeat.i(30994);
        this.yMa = aVar;
        this.gWO = new WeakReference(activity);
        this.xxI = pe.class.getName().hashCode();
        AppMethodBeat.o(30994);
    }

    private boolean a(pe peVar) {
        AppMethodBeat.i(30995);
        final Context context = (Activity) this.gWO.get();
        if (!(this.yMa == null || peVar == null || !(peVar instanceof pe) || context == null)) {
            bi biVar;
            long j = peVar.cLt.cvx;
            String str = peVar.cLt.cLu;
            bi biVar2 = peVar.cLt.cLv;
            if (biVar2 == null || biVar2.field_msgId <= 0) {
                biVar = peVar.cLt.cLv;
            } else {
                biVar = biVar2;
            }
            if (biVar != null) {
                switch (biVar.getType()) {
                    case 3:
                        switch (this.yMa) {
                            case IMAGE_GALLERY_UI:
                                if (biVar != null && biVar.field_msgId > 0) {
                                    try {
                                        f.afx().rO(com.tencent.mm.al.c.a("downimg", biVar.field_createTime, biVar.field_talker, biVar.field_msgId));
                                        ab.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", Boolean.TRUE);
                                        aw.Rg().cancel(109);
                                        o.ahm().x(e.d(biVar).fDy, j);
                                    } catch (Exception e) {
                                        ab.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgImage] cancel failure:%s", e.getMessage());
                                    }
                                }
                                if (context != null && (context instanceof ImageGalleryUI)) {
                                    ab.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", Long.valueOf(j), Long.valueOf(((ImageGalleryUI) context).cvx));
                                    if (j == ((ImageGalleryUI) context).cvx) {
                                        h.a(context, str, "", false, new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(30988);
                                                dialogInterface.dismiss();
                                                context.finish();
                                                AppMethodBeat.o(30988);
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                        }
                        break;
                    case 43:
                    case 62:
                        String str2 = "MicroMsg.RevokeMsgListener";
                        String str3 = "ashutest::revoke msg, type %s, isWorkerThread %B";
                        Object[] objArr = new Object[2];
                        objArr[0] = this.yMa;
                        objArr[1] = Boolean.valueOf(Looper.myLooper() == aw.RS().oAl.getLooper());
                        ab.v(str2, str3, objArr);
                        switch (this.yMa) {
                            case VIDEO_GALLERY:
                                aY(biVar);
                                if (context instanceof ImageGalleryUI) {
                                    Object obj;
                                    ImageGalleryUI imageGalleryUI = (ImageGalleryUI) context;
                                    if (imageGalleryUI.yTG != null && com.tencent.mm.ui.chatting.gallery.c.f(biVar) && biVar.field_msgId == imageGalleryUI.yTG.dFO().field_msgId) {
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                    if (obj != null) {
                                        imageGalleryUI.Pc(imageGalleryUI.getCurrentItem());
                                        h.a(context, str, "", false, new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(30989);
                                                dialogInterface.dismiss();
                                                context.finish();
                                                AppMethodBeat.o(30989);
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                            case CHATTING_ITEM_VIDEO:
                                aY(biVar);
                                break;
                        }
                        break;
                }
            }
            ab.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
            AppMethodBeat.o(30995);
            return false;
        }
        AppMethodBeat.o(30995);
        return false;
    }

    private static void aY(bi biVar) {
        AppMethodBeat.i(30996);
        s ut = u.ut(biVar.field_imgPath);
        if (ut != null) {
            try {
                f.afx().rO(com.tencent.mm.al.c.a("downvideo", ut.createTime, ut.getUser(), ut.getFileName()));
                ab.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", Boolean.TRUE);
                com.tencent.mm.modelvideo.o.alq().alH();
                bf.m(biVar);
                AppMethodBeat.o(30996);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", e.getMessage());
            }
        }
        AppMethodBeat.o(30996);
    }
}
