package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p181af.C37436r;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.BizVideoDetailUI;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.C45767b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.model.C43915c;
import com.tencent.p177mm.plugin.webview.model.C43915c.C43916a;
import com.tencent.p177mm.plugin.webview.p1068e.C43866c;
import com.tencent.p177mm.protocal.protobuf.C35931jz;
import com.tencent.p177mm.protocal.protobuf.bac;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C30292bc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xwalk.core.XWalkEnvironment;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C8001y;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u001e\u0010&\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010'\u001a\u00020$H\u0002J \u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010,J\u000e\u0010-\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010.\u001a\u00020\u001fH\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0006\u00100\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00061"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "", "()V", "MENU_ID_CANCEL_HAO_KAN", "", "MENU_ID_COPY_LINK", "MENU_ID_EXPOSE", "MENU_ID_FAV", "MENU_ID_HAO_KAN", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_BIZ", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "mmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "context", "copyLink", "", "doExpose", "fav", "goProfile", "hasShowMenuPermission", "", "id", "init", "isFinished", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setAppMsgStat", "shareToTimeline", "shouldDisableMenuItem", "showMenu", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g */
public final class C33744g {
    public final String TAG = "MicroMsg.MpMenuHelper";
    public WeakReference<BizVideoDetailUI> hiC;
    public C36356d iHZ;
    public C37436r jVG;
    public C45767b jWx;
    public C35931jz jXv;
    final int jYN;
    final int jYO = 1;
    final int jYP = 2;
    final int jYQ = 3;
    final int jYR = 4;
    final int jYS = 5;
    final int jYT = 6;
    final int jYU = 7;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g$b */
    public static final class C33745b implements C5279d {
        final /* synthetic */ C33744g jYV;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g$b$1 */
        static final class C201101 implements OnClickListener {
            final /* synthetic */ C33745b jYW;

            C201101(C33745b c33745b) {
                this.jYW = c33745b;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(15338);
                String dKV = dialogInterface == null ? "" : ((C5653c) dialogInterface).dKV();
                C33744g.m55139b(this.jYW.jYV).mo73560ao(C5046bo.isNullOrNil(dKV) ? 1 : 5, dKV);
                AppMethodBeat.m2505o(15338);
            }
        }

        public C33745b(C33744g c33744g) {
            this.jYV = c33744g;
        }

        /* JADX WARNING: Removed duplicated region for block: B:268:0x0617  */
        /* JADX WARNING: Removed duplicated region for block: B:265:0x0609  */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x07b3  */
        /* JADX WARNING: Removed duplicated region for block: B:302:0x06d6  */
        /* JADX WARNING: Removed duplicated region for block: B:320:0x0776  */
        /* JADX WARNING: Removed duplicated region for block: B:307:0x06ff A:{Catch:{ IOException -> 0x0778 }} */
        /* JADX WARNING: Removed duplicated region for block: B:309:0x0709 A:{Catch:{ IOException -> 0x0778 }} */
        /* JADX WARNING: Removed duplicated region for block: B:311:0x070e A:{Catch:{ IOException -> 0x0778 }} */
        /* JADX WARNING: Removed duplicated region for block: B:315:0x0744  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            String str = null;
            AppMethodBeat.m2504i(15339);
            C25052j.m39375o(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            BizVideoDetailUI aYo;
            C37436r c37436r;
            C45767b c45767b;
            String str2;
            bac bac;
            String str3;
            Object obj;
            C33744g c33744g;
            C45767b c45767b2;
            String str4;
            if (itemId == this.jYV.jYN) {
                C11262a c11262a = C11262a.jYp;
                aYo = this.jYV.aYo();
                if (aYo == null) {
                    C25052j.dWJ();
                }
                C11262a.m18977a(aYo, C33744g.m55137a(this.jYV), C33744g.m55139b(this.jYV));
                AppMethodBeat.m2505o(15339);
            } else if (itemId == this.jYV.jYO) {
                C33744g c33744g2 = this.jYV;
                C4990ab.m7416i(c33744g2.TAG, "doTimeline");
                WeakReference weakReference = c33744g2.hiC;
                if (weakReference == null) {
                    C25052j.avw("ui");
                }
                if (weakReference.get() != null) {
                    Boolean valueOf;
                    weakReference = c33744g2.hiC;
                    if (weakReference == null) {
                        C25052j.avw("ui");
                    }
                    aYo = (BizVideoDetailUI) weakReference.get();
                    if (aYo != null) {
                        valueOf = Boolean.valueOf(aYo.isFinishing());
                    } else {
                        valueOf = null;
                    }
                    if (valueOf == null) {
                        C25052j.dWJ();
                    }
                    if (!valueOf.booleanValue()) {
                        C37436r c37436r2;
                        Intent intent = new Intent();
                        c37436r = c33744g2.jVG;
                        if (c37436r == null) {
                            C25052j.avw("msgInfo");
                        }
                        itemId = c37436r.fjT.videoWidth;
                        if (itemId <= 0) {
                            itemId = 150;
                        }
                        intent.putExtra("Ksnsupload_width", itemId);
                        intent.putExtra("Ksnsupload_height", itemId);
                        c45767b = c33744g2.jWx;
                        if (c45767b == null) {
                            C25052j.avw("controller");
                        }
                        if (c45767b.aYp()) {
                            str2 = "Ksnsupload_title";
                            c45767b = c33744g2.jWx;
                            if (c45767b == null) {
                                C25052j.avw("controller");
                            }
                            bac = c45767b.jVI;
                            intent.putExtra(str2, bac != null ? bac.title : null);
                            str2 = "Ksnsupload_imgurl";
                            c45767b = c33744g2.jWx;
                            if (c45767b == null) {
                                C25052j.avw("controller");
                            }
                            bac = c45767b.jVI;
                            if (bac != null) {
                                str3 = bac.fjx;
                            } else {
                                str3 = null;
                            }
                            intent.putExtra(str2, str3);
                        } else {
                            str3 = "Ksnsupload_title";
                            c37436r2 = c33744g2.jVG;
                            if (c37436r2 == null) {
                                C25052j.avw("msgInfo");
                            }
                            intent.putExtra(str3, c37436r2.fjT.title);
                            str3 = "Ksnsupload_imgurl";
                            c37436r2 = c33744g2.jVG;
                            if (c37436r2 == null) {
                                C25052j.avw("msgInfo");
                            }
                            intent.putExtra(str3, c37436r2.fjT.fjx);
                        }
                        str3 = "Ksnsupload_link";
                        C45767b c45767b3 = c33744g2.jWx;
                        if (c45767b3 == null) {
                            C25052j.avw("controller");
                        }
                        intent.putExtra(str3, c45767b3.url);
                        c37436r = c33744g2.jVG;
                        if (c37436r == null) {
                            C25052j.avw("msgInfo");
                        }
                        str3 = c37436r.fjS;
                        c37436r2 = c33744g2.jVG;
                        if (c37436r2 == null) {
                            C25052j.avw("msgInfo");
                        }
                        C37436r c37436r3;
                        if (C5046bo.isNullOrNil(c37436r2.cwG)) {
                            str2 = "src_username";
                            c37436r3 = c33744g2.jVG;
                            if (c37436r3 == null) {
                                C25052j.avw("msgInfo");
                            }
                            intent.putExtra(str2, c37436r3.mo60325HE());
                            str2 = "src_displayname";
                            c37436r3 = c33744g2.jVG;
                            if (c37436r3 == null) {
                                C25052j.avw("msgInfo");
                            }
                            intent.putExtra(str2, C1854s.m3866mJ(c37436r3.mo60325HE()));
                        } else {
                            str2 = "src_username";
                            c37436r3 = c33744g2.jVG;
                            if (c37436r3 == null) {
                                C25052j.avw("msgInfo");
                            }
                            intent.putExtra(str2, c37436r3.cwG);
                            str2 = "src_displayname";
                            c37436r3 = c33744g2.jVG;
                            if (c37436r3 == null) {
                                C25052j.avw("msgInfo");
                            }
                            intent.putExtra(str2, c37436r3.fjR);
                        }
                        intent.putExtra("Ksnsupload_type", 1);
                        str2 = "ShareUrlOriginal";
                        C45767b c45767b4 = c33744g2.jWx;
                        if (c45767b4 == null) {
                            C25052j.avw("controller");
                        }
                        intent.putExtra(str2, c45767b4.url);
                        intent.putExtra("KPublisherId", str3);
                        intent.putExtra("need_result", true);
                        str2 = C37922v.m64078nW(str3);
                        C32800b y = C37922v.m64076Zp().mo60676y(str2, true);
                        y.mo53356j("sendAppMsgScene", Integer.valueOf(2));
                        str3 = "preChatName";
                        C37436r c37436r4 = c33744g2.jVG;
                        if (c37436r4 == null) {
                            C25052j.avw("msgInfo");
                        }
                        y.mo53356j(str3, c37436r4.mo60325HE());
                        str3 = "preMsgIndex";
                        c37436r4 = c33744g2.jVG;
                        if (c37436r4 == null) {
                            C25052j.avw("msgInfo");
                        }
                        y.mo53356j(str3, Integer.valueOf(c37436r4.fjQ));
                        str3 = "prePublishId";
                        c37436r4 = c33744g2.jVG;
                        if (c37436r4 == null) {
                            C25052j.avw("msgInfo");
                        }
                        y.mo53356j(str3, c37436r4.fjS);
                        str3 = "preUsername";
                        c37436r4 = c33744g2.jVG;
                        if (c37436r4 == null) {
                            C25052j.avw("msgInfo");
                        }
                        y.mo53356j(str3, c37436r4.mo60325HE());
                        str3 = "url";
                        C45767b c45767b5 = c33744g2.jWx;
                        if (c45767b5 == null) {
                            C25052j.avw("controller");
                        }
                        y.mo53356j(str3, c45767b5.url);
                        str3 = "referUrl";
                        c45767b5 = c33744g2.jWx;
                        if (c45767b5 == null) {
                            C25052j.avw("controller");
                        }
                        y.mo53356j(str3, c45767b5.url);
                        c37436r = c33744g2.jVG;
                        if (c37436r == null) {
                            C25052j.avw("msgInfo");
                        }
                        itemId = c37436r.fjT.type;
                        if (itemId != -1) {
                            y.mo53356j("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(itemId));
                            c37436r = c33744g2.jVG;
                            if (c37436r == null) {
                                C25052j.avw("msgInfo");
                            }
                            if (c37436r.fjT.type == 5) {
                                C37436r c37436r5;
                                str3 = "_DATA_CENTER_VID";
                                c37436r4 = c33744g2.jVG;
                                if (c37436r4 == null) {
                                    C25052j.avw("msgInfo");
                                }
                                y.mo53356j(str3, c37436r4.fjT.fgd);
                                str3 = "_DATA_CENTER_PUB_TIME";
                                c37436r4 = c33744g2.jVG;
                                if (c37436r4 == null) {
                                    C25052j.avw("msgInfo");
                                }
                                y.mo53356j(str3, Integer.valueOf((int) c37436r4.fjT.time));
                                str3 = "_DATA_CENTER__DULATION";
                                c37436r4 = c33744g2.jVG;
                                if (c37436r4 == null) {
                                    C25052j.avw("msgInfo");
                                }
                                y.mo53356j(str3, Integer.valueOf(c37436r4.fjT.fjB));
                                c45767b = c33744g2.jWx;
                                if (c45767b == null) {
                                    C25052j.avw("controller");
                                }
                                if (c45767b.aYp()) {
                                    Object obj2;
                                    String str5 = "_DATA_CENTER_DESC";
                                    c45767b = c33744g2.jWx;
                                    if (c45767b == null) {
                                        C25052j.avw("controller");
                                    }
                                    bac = c45767b.jVI;
                                    y.mo53356j(str5, bac != null ? bac.fjz : null);
                                    str3 = "_DATA_CENTER_COVER_URL";
                                    c45767b5 = c33744g2.jWx;
                                    if (c45767b5 == null) {
                                        C25052j.avw("controller");
                                    }
                                    bac bac2 = c45767b5.jVI;
                                    if (bac2 != null) {
                                        obj2 = bac2.fjx;
                                    }
                                    y.mo53356j(str3, obj2);
                                } else {
                                    str3 = "_DATA_CENTER_DESC";
                                    c37436r5 = c33744g2.jVG;
                                    if (c37436r5 == null) {
                                        C25052j.avw("msgInfo");
                                    }
                                    y.mo53356j(str3, c37436r5.fjT.fjz);
                                    str3 = "_DATA_CENTER_COVER_URL";
                                    c37436r5 = c33744g2.jVG;
                                    if (c37436r5 == null) {
                                        C25052j.avw("msgInfo");
                                    }
                                    y.mo53356j(str3, c37436r5.fjT.fjx);
                                }
                                str3 = "_DATA_CENTER_VIDEO_WIDTH";
                                c37436r5 = c33744g2.jVG;
                                if (c37436r5 == null) {
                                    C25052j.avw("msgInfo");
                                }
                                y.mo53356j(str3, Integer.valueOf(c37436r5.fjT.videoWidth));
                                str3 = "_DATA_CENTER_VIDEO_HEIGHT";
                                c37436r5 = c33744g2.jVG;
                                if (c37436r5 == null) {
                                    C25052j.avw("msgInfo");
                                }
                                y.mo53356j(str3, Integer.valueOf(c37436r5.fjT.videoHeight));
                                y.mo53356j("_DATA_SHOW_NATIVE_PAGE", Integer.valueOf(1));
                                str3 = "_DATA_CENTER_FUNC_FLAG";
                                c37436r5 = c33744g2.jVG;
                                if (c37436r5 == null) {
                                    C25052j.avw("msgInfo");
                                }
                                y.mo53356j(str3, Integer.valueOf(c37436r5.fgc));
                            }
                            y.mo53356j("_tmpl_webview_transfer_scene", Integer.valueOf(10));
                        }
                        intent.putExtra("reportSessionId", str2);
                        str = "BizVideoDetailUIExtras";
                        weakReference = c33744g2.hiC;
                        if (weakReference == null) {
                            C25052j.avw("ui");
                        }
                        obj = weakReference.get();
                        if (obj == null) {
                            C25052j.dWJ();
                        }
                        C25052j.m39375o(obj, "ui.get()!!");
                        Intent intent2 = ((BizVideoDetailUI) obj).getIntent();
                        C25052j.m39375o(intent2, "ui.get()!!.intent");
                        intent.putExtra(str, intent2.getExtras());
                        C25985d.m41453a((Context) c33744g2.aYo(), "sns", ".ui.SnsUploadUI", intent, 1, false);
                        AppMethodBeat.m2505o(15339);
                        return;
                    }
                }
                C4990ab.m7416i(c33744g2.TAG, "activity finished");
                AppMethodBeat.m2505o(15339);
            } else if (itemId == this.jYV.jYP) {
                c33744g = this.jYV;
                C45316cl c45316cl = new C45316cl();
                C43916a c43916a = new C43916a();
                c45767b = c33744g.jWx;
                if (c45767b == null) {
                    C25052j.avw("controller");
                }
                c43916a.url = c45767b.url;
                c45767b = c33744g.jWx;
                if (c45767b == null) {
                    C25052j.avw("controller");
                }
                if (c45767b.aYp()) {
                    c45767b = c33744g.jWx;
                    if (c45767b == null) {
                        C25052j.avw("controller");
                    }
                    bac = c45767b.jVI;
                    c43916a.thumbUrl = bac != null ? bac.fjx : null;
                    c45767b = c33744g.jWx;
                    if (c45767b == null) {
                        C25052j.avw("controller");
                    }
                    bac = c45767b.jVI;
                    if (bac != null) {
                        str3 = bac.title;
                    } else {
                        str3 = null;
                    }
                    c43916a.title = str3;
                    c45767b = c33744g.jWx;
                    if (c45767b == null) {
                        C25052j.avw("controller");
                    }
                    bac = c45767b.jVI;
                    if (bac != null) {
                        str = bac.fjz;
                    }
                    c43916a.desc = str;
                } else {
                    c37436r = c33744g.jVG;
                    if (c37436r == null) {
                        C25052j.avw("msgInfo");
                    }
                    c43916a.thumbUrl = c37436r.fjT.fjx;
                    c37436r = c33744g.jVG;
                    if (c37436r == null) {
                        C25052j.avw("msgInfo");
                    }
                    c43916a.title = c37436r.fjT.title;
                    c37436r = c33744g.jVG;
                    if (c37436r == null) {
                        C25052j.avw("msgInfo");
                    }
                    c43916a.desc = c37436r.fjT.fjz;
                }
                c37436r = c33744g.jVG;
                if (c37436r == null) {
                    C25052j.avw("msgInfo");
                }
                C32800b y2 = C37922v.m64076Zp().mo60676y(C37922v.m64078nW(C5046bo.nullAsNil(c37436r.fjS)), true);
                if (y2 == null) {
                    C25052j.dWJ();
                }
                y2.mo53356j("sendAppMsgScene", Integer.valueOf(2));
                str = "preChatName";
                C37436r c37436r6 = c33744g.jVG;
                if (c37436r6 == null) {
                    C25052j.avw("msgInfo");
                }
                y2.mo53356j(str, c37436r6.mo60325HE());
                str = "preMsgIndex";
                c37436r6 = c33744g.jVG;
                if (c37436r6 == null) {
                    C25052j.avw("msgInfo");
                }
                y2.mo53356j(str, Integer.valueOf(c37436r6.fjQ));
                str = "prePublishId";
                c37436r6 = c33744g.jVG;
                if (c37436r6 == null) {
                    C25052j.avw("msgInfo");
                }
                y2.mo53356j(str, c37436r6.fjS);
                str = "preUsername";
                c37436r6 = c33744g.jVG;
                if (c37436r6 == null) {
                    C25052j.avw("msgInfo");
                }
                y2.mo53356j(str, c37436r6.mo60325HE());
                str = "referUrl";
                C45767b c45767b6 = c33744g.jWx;
                if (c45767b6 == null) {
                    C25052j.avw("controller");
                }
                y2.mo53356j(str, c45767b6.url);
                c45316cl.cvA.activity = c33744g.aYo();
                c45316cl.cvA.cvH = 36;
                C43915c.m78771a(c45316cl, c43916a);
                C4879a.xxA.mo10055m(c45316cl);
                c45767b = c33744g.jWx;
                if (c45767b == null) {
                    C25052j.avw("controller");
                }
                c45767b.jVC.mo61573sF(24);
                AppMethodBeat.m2505o(15339);
            } else if (itemId == this.jYV.jYQ) {
                C43866c.m78658a(this.jYV.aYo(), C33744g.m55137a(this.jYV).fjT.title, new C201101(this));
                AppMethodBeat.m2505o(15339);
            } else if (itemId == this.jYV.jYR) {
                C33744g.m55139b(this.jYV).mo73560ao(2, "");
                AppMethodBeat.m2505o(15339);
            } else if (itemId == this.jYV.jYS) {
                C33744g c33744g3 = this.jYV;
                c45767b2 = c33744g3.jWx;
                if (c45767b2 == null) {
                    C25052j.avw("controller");
                }
                if ((c45767b2.fgc & 1) != 0) {
                    str4 = c33744g3.TAG;
                    StringBuilder stringBuilder = new StringBuilder("not allow jump to profile ");
                    c45767b = c33744g3.jWx;
                    if (c45767b == null) {
                        C25052j.avw("controller");
                    }
                    C4990ab.m7420w(str4, stringBuilder.append(c45767b.fgc).toString());
                    AppMethodBeat.m2505o(15339);
                    return;
                }
                Intent intent3 = new Intent();
                str = "Contact_User";
                C45767b c45767b7 = c33744g3.jWx;
                if (c45767b7 == null) {
                    C25052j.avw("controller");
                }
                intent3.putExtra(str, c45767b7.mo73552HE());
                intent3.putExtra("Contact_Scene", XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
                C25985d.m41467b((Context) c33744g3.aYo(), Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                AppMethodBeat.m2505o(15339);
            } else if (itemId == this.jYV.jYT) {
                c33744g = this.jYV;
                if (c33744g.isFinished()) {
                    C4990ab.m7412e(c33744g.TAG, "copyLink fail, is finish");
                    AppMethodBeat.m2505o(15339);
                    return;
                }
                aYo = c33744g.aYo();
                if (aYo != null) {
                    Application application = aYo.getApplication();
                    if (application != null) {
                        obj = application.getSystemService("clipboard");
                        if (obj != null) {
                            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.text.ClipboardManager");
                            AppMethodBeat.m2505o(15339);
                            throw c44941v;
                        }
                        ClipboardManager clipboardManager = (ClipboardManager) obj;
                        if (clipboardManager != null) {
                            try {
                                c45767b2 = c33744g.jWx;
                                if (c45767b2 == null) {
                                    C25052j.avw("controller");
                                }
                                clipboardManager.setText(c45767b2.jVB);
                                Context aYo2 = c33744g.aYo();
                                BizVideoDetailUI aYo3 = c33744g.aYo();
                                Toast.makeText(aYo2, aYo3 != null ? aYo3.getString(C25738R.string.g1w) : null, 0).show();
                                AppMethodBeat.m2505o(15339);
                                return;
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace(c33744g.TAG, e, "clip.setText error", new Object[0]);
                                AppMethodBeat.m2505o(15339);
                                return;
                            }
                        }
                        C4990ab.m7412e(c33744g.TAG, "clipboard manager is null");
                        AppMethodBeat.m2505o(15339);
                        return;
                    }
                }
                obj = null;
                if (obj != null) {
                }
            } else if (itemId == this.jYV.jYU) {
                Intent intent4;
                File dir;
                c33744g = this.jYV;
                c37436r = c33744g.jVG;
                if (c37436r == null) {
                    C25052j.avw("msgInfo");
                }
                str2 = c37436r.fjT.url;
                if (C5046bo.isNullOrNil(str2)) {
                    str3 = null;
                } else {
                    Uri parse = Uri.parse(str2);
                    C25052j.m39375o(parse, ShareConstants.MEDIA_URI);
                    str3 = parse.getHost();
                }
                if (!C5046bo.isNullOrNil(str3)) {
                    if (str3 == null) {
                        C25052j.dWJ();
                    }
                    if (C6163u.m9839jb(str3, "mp.weixin.qq.com")) {
                        C8001y c8001y;
                        try {
                            c8001y = C8001y.AVH;
                            str3 = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", Arrays.copyOf(new Object[]{C18178q.encode(str2, ProtocolPackage.ServerEncoding)}, 1));
                            C25052j.m39375o(str3, "java.lang.String.format(format, *args)");
                        } catch (UnsupportedEncodingException e2) {
                            C4990ab.m7412e(c33744g.TAG, e2.getMessage());
                        }
                        if (C5046bo.isNullOrNil(str3)) {
                            str4 = str3;
                        } else {
                            c8001y = C8001y.AVH;
                            str3 = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[]{Integer.valueOf(34)}, 1));
                            C25052j.m39375o(str3, "java.lang.String.format(format, *args)");
                            str4 = str3;
                        }
                        intent4 = new Intent();
                        aYo = c33744g.aYo();
                        dir = aYo == null ? aYo.getDir("expose", 0) : null;
                        if (dir != null) {
                            dir.mkdirs();
                        }
                        if (dir != null) {
                            str = dir.getAbsolutePath();
                        }
                        str = C25052j.m39377u(str, "/screenshot.jpg");
                        C5056d.m7625a(C30292bc.m48193am(c33744g.aYo()), 75, CompressFormat.JPEG, str, true);
                        intent4.putExtra("k_webview_img", str);
                        intent4.putExtra("rawUrl", str4);
                        intent4.putExtra("k_expose_url", str2);
                        str3 = "k_expose_web_scene";
                        c45767b2 = c33744g.jWx;
                        if (c45767b2 == null) {
                            C25052j.avw("controller");
                        }
                        intent4.putExtra(str3, c45767b2.scene);
                        intent4.putExtra("showShare", false);
                        C25985d.m41467b((Context) c33744g.aYo(), "webview", ".ui.tools.WebViewUI", intent4);
                        AppMethodBeat.m2505o(15339);
                    }
                }
                str3 = null;
                if (C5046bo.isNullOrNil(str3)) {
                }
                intent4 = new Intent();
                try {
                    aYo = c33744g.aYo();
                    if (aYo == null) {
                    }
                    if (dir != null) {
                    }
                    if (dir != null) {
                    }
                    str = C25052j.m39377u(str, "/screenshot.jpg");
                    C5056d.m7625a(C30292bc.m48193am(c33744g.aYo()), 75, CompressFormat.JPEG, str, true);
                    intent4.putExtra("k_webview_img", str);
                } catch (IOException e3) {
                    C4990ab.m7412e(c33744g.TAG, "[oneliang]save screen shot to file error, ex = " + e3.getMessage());
                }
                intent4.putExtra("rawUrl", str4);
                intent4.putExtra("k_expose_url", str2);
                str3 = "k_expose_web_scene";
                c45767b2 = c33744g.jWx;
                if (c45767b2 == null) {
                }
                intent4.putExtra(str3, c45767b2.scene);
                intent4.putExtra("showShare", false);
                C25985d.m41467b((Context) c33744g.aYo(), "webview", ".ui.tools.WebViewUI", intent4);
                AppMethodBeat.m2505o(15339);
            } else {
                C4990ab.m7420w(this.jYV.TAG, "wrong id: " + menuItem.getItemId());
                AppMethodBeat.m2505o(15339);
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g$a */
    public static final class C33746a implements C36073c {
        final /* synthetic */ C33744g jYV;

        public C33746a(C33744g c33744g) {
            this.jYV = c33744g;
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            String string;
            AppMethodBeat.m2504i(15337);
            C7060h.pYm.mo8378a(480, 0, 1, false);
            c44273l.clear();
            int i = this.jYV.jYN;
            BizVideoDetailUI aYo = this.jYV.aYo();
            c44273l.mo70050a(i, aYo != null ? aYo.getString(C25738R.string.dhh) : null, C1318a.bottomsheet_icon_transmit, C33744g.m55138a(this.jYV, this.jYV.jYN));
            i = this.jYV.jYO;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(C25738R.string.dhi);
            } else {
                string = null;
            }
            c44273l.mo70050a(i, string, C1318a.bottomsheet_icon_moment, C33744g.m55138a(this.jYV, this.jYV.jYO));
            C35931jz c35931jz = this.jYV.jXv;
            if (c35931jz != null && c35931jz.vMQ == 1) {
                c35931jz = this.jYV.jXv;
                if (c35931jz == null || c35931jz.vMP != 0) {
                    i = this.jYV.jYR;
                    aYo = this.jYV.aYo();
                    c44273l.mo70050a(i, aYo != null ? aYo.getString(C25738R.string.dhj) : null, C1318a.bottomsheet_icon_cancel_hao_kan, C33744g.m55138a(this.jYV, this.jYV.jYR));
                } else {
                    i = this.jYV.jYQ;
                    aYo = this.jYV.aYo();
                    if (aYo != null) {
                        string = aYo.getString(C25738R.string.dhr);
                    } else {
                        string = null;
                    }
                    c44273l.mo70050a(i, string, C1318a.bottomsheet_icon_hao_kan, C33744g.m55138a(this.jYV, this.jYV.jYQ));
                }
            }
            i = this.jYV.jYP;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(C25738R.string.dcq);
            } else {
                string = null;
            }
            c44273l.mo70050a(i, string, C1318a.bottomsheet_icon_fav, C33744g.m55138a(this.jYV, this.jYV.jYP));
            i = this.jYV.jYS;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(C25738R.string.g26);
            } else {
                string = null;
            }
            c44273l.mo70050a(i, string, C1318a.bottomsheet_icon_brand_profile, C33744g.m55138a(this.jYV, this.jYV.jYS));
            i = this.jYV.jYU;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(C25738R.string.a9n);
            } else {
                string = null;
            }
            c44273l.mo70050a(i, string, C1318a.bottomsheet_icon_complain, C33744g.m55138a(this.jYV, this.jYV.jYU));
            i = this.jYV.jYT;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(C25738R.string.g1v);
            } else {
                string = null;
            }
            c44273l.mo70050a(i, string, C1318a.bottomsheet_icon_copy, C33744g.m55138a(this.jYV, this.jYV.jYT));
            AppMethodBeat.m2505o(15337);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ C37436r m55137a(C33744g c33744g) {
        AppMethodBeat.m2504i(15343);
        C37436r c37436r = c33744g.jVG;
        if (c37436r == null) {
            C25052j.avw("msgInfo");
        }
        AppMethodBeat.m2505o(15343);
        return c37436r;
    }

    /* renamed from: b */
    public static final /* synthetic */ C45767b m55139b(C33744g c33744g) {
        AppMethodBeat.m2504i(15344);
        C45767b c45767b = c33744g.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        AppMethodBeat.m2505o(15344);
        return c45767b;
    }

    public final BizVideoDetailUI aYo() {
        AppMethodBeat.m2504i(15340);
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            C25052j.avw("ui");
        }
        if (weakReference.get() == null) {
            AppMethodBeat.m2505o(15340);
            return null;
        }
        weakReference = this.hiC;
        if (weakReference == null) {
            C25052j.avw("ui");
        }
        Object obj = weakReference.get();
        if (obj == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
            AppMethodBeat.m2505o(15340);
            throw c44941v;
        }
        BizVideoDetailUI bizVideoDetailUI = (BizVideoDetailUI) obj;
        AppMethodBeat.m2505o(15340);
        return bizVideoDetailUI;
    }

    public final boolean isFinished() {
        AppMethodBeat.m2504i(15341);
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            C25052j.avw("ui");
        }
        if (weakReference.get() != null) {
            weakReference = this.hiC;
            if (weakReference == null) {
                C25052j.avw("ui");
            }
            Object obj = weakReference.get();
            if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
                AppMethodBeat.m2505o(15341);
                throw c44941v;
            } else if (!((BizVideoDetailUI) obj).isFinishing()) {
                AppMethodBeat.m2505o(15341);
                return false;
            }
        }
        AppMethodBeat.m2505o(15341);
        return true;
    }

    /* renamed from: a */
    public static final /* synthetic */ boolean m55138a(C33744g c33744g, int i) {
        AppMethodBeat.m2504i(15342);
        C45767b c45767b = c33744g.jWx;
        if (c45767b == null) {
            C25052j.avw("controller");
        }
        if ((c45767b.fgc & 2) == 0 || !(i == c33744g.jYN || i == c33744g.jYO || i == c33744g.jYP || i == c33744g.jYT)) {
            AppMethodBeat.m2505o(15342);
            return false;
        }
        AppMethodBeat.m2505o(15342);
        return true;
    }
}
