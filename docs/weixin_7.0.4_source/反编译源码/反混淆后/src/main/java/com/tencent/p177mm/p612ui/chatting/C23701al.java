package com.tencent.p177mm.p612ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C37781pe;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.gallery.C40775c;
import com.tencent.p177mm.p612ui.chatting.gallery.C40780e;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.ui.chatting.al */
public final class C23701al extends C4884c<C37781pe> {
    private WeakReference<Activity> gWO;
    private C23702a yMa = null;

    /* renamed from: com.tencent.mm.ui.chatting.al$a */
    public enum C23702a {
        CHATTING_ITEM_VIDEO,
        IMAGE_GALLERY_UI,
        VIDEO_GALLERY;

        static {
            AppMethodBeat.m2505o(30993);
        }
    }

    public C23701al(C23702a c23702a, Activity activity) {
        super(0);
        AppMethodBeat.m2504i(30994);
        this.yMa = c23702a;
        this.gWO = new WeakReference(activity);
        this.xxI = C37781pe.class.getName().hashCode();
        AppMethodBeat.m2505o(30994);
    }

    /* renamed from: a */
    private boolean m36543a(C37781pe c37781pe) {
        AppMethodBeat.m2504i(30995);
        final Context context = (Activity) this.gWO.get();
        if (!(this.yMa == null || c37781pe == null || !(c37781pe instanceof C37781pe) || context == null)) {
            C7620bi c7620bi;
            long j = c37781pe.cLt.cvx;
            String str = c37781pe.cLt.cLu;
            C7620bi c7620bi2 = c37781pe.cLt.cLv;
            if (c7620bi2 == null || c7620bi2.field_msgId <= 0) {
                c7620bi = c37781pe.cLt.cLv;
            } else {
                c7620bi = c7620bi2;
            }
            if (c7620bi != null) {
                switch (c7620bi.getType()) {
                    case 3:
                        switch (this.yMa) {
                            case IMAGE_GALLERY_UI:
                                if (c7620bi != null && c7620bi.field_msgId > 0) {
                                    try {
                                        C37461f.afx().mo51228rO(C37458c.m63162a("downimg", c7620bi.field_createTime, c7620bi.field_talker, c7620bi.field_msgId));
                                        C4990ab.m7417i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", Boolean.TRUE);
                                        C9638aw.m17182Rg().cancel(109);
                                        C32291o.ahm().mo33471x(C40780e.m70619d(c7620bi).fDy, j);
                                    } catch (Exception e) {
                                        C4990ab.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgImage] cancel failure:%s", e.getMessage());
                                    }
                                }
                                if (context != null && (context instanceof ImageGalleryUI)) {
                                    C4990ab.m7417i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", Long.valueOf(j), Long.valueOf(((ImageGalleryUI) context).cvx));
                                    if (j == ((ImageGalleryUI) context).cvx) {
                                        C30379h.m48448a(context, str, "", false, new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.m2504i(30988);
                                                dialogInterface.dismiss();
                                                context.finish();
                                                AppMethodBeat.m2505o(30988);
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
                        objArr[1] = Boolean.valueOf(Looper.myLooper() == C9638aw.m17180RS().oAl.getLooper());
                        C4990ab.m7419v(str2, str3, objArr);
                        switch (this.yMa) {
                            case VIDEO_GALLERY:
                                C23701al.m36544aY(c7620bi);
                                if (context instanceof ImageGalleryUI) {
                                    Object obj;
                                    ImageGalleryUI imageGalleryUI = (ImageGalleryUI) context;
                                    if (imageGalleryUI.yTG != null && C40775c.m70574f(c7620bi) && c7620bi.field_msgId == imageGalleryUI.yTG.dFO().field_msgId) {
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                    if (obj != null) {
                                        imageGalleryUI.mo64282Pc(imageGalleryUI.getCurrentItem());
                                        C30379h.m48448a(context, str, "", false, new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.m2504i(30989);
                                                dialogInterface.dismiss();
                                                context.finish();
                                                AppMethodBeat.m2505o(30989);
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                            case CHATTING_ITEM_VIDEO:
                                C23701al.m36544aY(c7620bi);
                                break;
                        }
                        break;
                }
            }
            C4990ab.m7412e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
            AppMethodBeat.m2505o(30995);
            return false;
        }
        AppMethodBeat.m2505o(30995);
        return false;
    }

    /* renamed from: aY */
    private static void m36544aY(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30996);
        C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
        if (ut != null) {
            try {
                C37461f.afx().mo51228rO(C37458c.m63162a("downvideo", ut.createTime, ut.getUser(), ut.getFileName()));
                C4990ab.m7417i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", Boolean.TRUE);
                C37961o.alq().alH();
                C1829bf.m3753m(c7620bi);
                AppMethodBeat.m2505o(30996);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(30996);
    }
}
