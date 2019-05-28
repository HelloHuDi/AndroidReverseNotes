package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import a.f.b.j;
import a.f.b.y;
import a.k.u;
import a.l;
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
import com.tencent.mm.R;
import com.tencent.mm.af.r;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.s;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xwalk.core.XWalkEnvironment;

@l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u001e\u0010&\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010'\u001a\u00020$H\u0002J \u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010,J\u000e\u0010-\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010.\u001a\u00020\u001fH\u0002J\u0010\u0010/\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0006\u00100\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00061"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "", "()V", "MENU_ID_CANCEL_HAO_KAN", "", "MENU_ID_COPY_LINK", "MENU_ID_EXPOSE", "MENU_ID_FAV", "MENU_ID_HAO_KAN", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_BIZ", "TAG", "", "appMsgStat", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgStat;", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "mmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoDetailUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "context", "copyLink", "", "doExpose", "fav", "goProfile", "hasShowMenuPermission", "", "id", "init", "isFinished", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setAppMsgStat", "shareToTimeline", "shouldDisableMenuItem", "showMenu", "plugin-brandservice_release"})
public final class g {
    public final String TAG = "MicroMsg.MpMenuHelper";
    public WeakReference<BizVideoDetailUI> hiC;
    public d iHZ;
    public r jVG;
    public com.tencent.mm.plugin.brandservice.ui.timeline.video.b jWx;
    public jz jXv;
    final int jYN;
    final int jYO = 1;
    final int jYP = 2;
    final int jYQ = 3;
    final int jYR = 4;
    final int jYS = 5;
    final int jYT = 6;
    final int jYU = 7;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
    public static final class b implements n.d {
        final /* synthetic */ g jYV;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.g$b$1 */
        static final class AnonymousClass1 implements OnClickListener {
            final /* synthetic */ b jYW;

            AnonymousClass1(b bVar) {
                this.jYW = bVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(15338);
                String dKV = dialogInterface == null ? "" : ((c) dialogInterface).dKV();
                g.b(this.jYW.jYV).ao(bo.isNullOrNil(dKV) ? 1 : 5, dKV);
                AppMethodBeat.o(15338);
            }
        }

        public b(g gVar) {
            this.jYV = gVar;
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
            AppMethodBeat.i(15339);
            j.o(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            BizVideoDetailUI aYo;
            r rVar;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar;
            String str2;
            bac bac;
            String str3;
            Object obj;
            g gVar;
            com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar2;
            String str4;
            if (itemId == this.jYV.jYN) {
                a aVar = a.jYp;
                aYo = this.jYV.aYo();
                if (aYo == null) {
                    j.dWJ();
                }
                a.a(aYo, g.a(this.jYV), g.b(this.jYV));
                AppMethodBeat.o(15339);
            } else if (itemId == this.jYV.jYO) {
                g gVar2 = this.jYV;
                ab.i(gVar2.TAG, "doTimeline");
                WeakReference weakReference = gVar2.hiC;
                if (weakReference == null) {
                    j.avw("ui");
                }
                if (weakReference.get() != null) {
                    Boolean valueOf;
                    weakReference = gVar2.hiC;
                    if (weakReference == null) {
                        j.avw("ui");
                    }
                    aYo = (BizVideoDetailUI) weakReference.get();
                    if (aYo != null) {
                        valueOf = Boolean.valueOf(aYo.isFinishing());
                    } else {
                        valueOf = null;
                    }
                    if (valueOf == null) {
                        j.dWJ();
                    }
                    if (!valueOf.booleanValue()) {
                        r rVar2;
                        Intent intent = new Intent();
                        rVar = gVar2.jVG;
                        if (rVar == null) {
                            j.avw("msgInfo");
                        }
                        itemId = rVar.fjT.videoWidth;
                        if (itemId <= 0) {
                            itemId = 150;
                        }
                        intent.putExtra("Ksnsupload_width", itemId);
                        intent.putExtra("Ksnsupload_height", itemId);
                        bVar = gVar2.jWx;
                        if (bVar == null) {
                            j.avw("controller");
                        }
                        if (bVar.aYp()) {
                            str2 = "Ksnsupload_title";
                            bVar = gVar2.jWx;
                            if (bVar == null) {
                                j.avw("controller");
                            }
                            bac = bVar.jVI;
                            intent.putExtra(str2, bac != null ? bac.title : null);
                            str2 = "Ksnsupload_imgurl";
                            bVar = gVar2.jWx;
                            if (bVar == null) {
                                j.avw("controller");
                            }
                            bac = bVar.jVI;
                            if (bac != null) {
                                str3 = bac.fjx;
                            } else {
                                str3 = null;
                            }
                            intent.putExtra(str2, str3);
                        } else {
                            str3 = "Ksnsupload_title";
                            rVar2 = gVar2.jVG;
                            if (rVar2 == null) {
                                j.avw("msgInfo");
                            }
                            intent.putExtra(str3, rVar2.fjT.title);
                            str3 = "Ksnsupload_imgurl";
                            rVar2 = gVar2.jVG;
                            if (rVar2 == null) {
                                j.avw("msgInfo");
                            }
                            intent.putExtra(str3, rVar2.fjT.fjx);
                        }
                        str3 = "Ksnsupload_link";
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar3 = gVar2.jWx;
                        if (bVar3 == null) {
                            j.avw("controller");
                        }
                        intent.putExtra(str3, bVar3.url);
                        rVar = gVar2.jVG;
                        if (rVar == null) {
                            j.avw("msgInfo");
                        }
                        str3 = rVar.fjS;
                        rVar2 = gVar2.jVG;
                        if (rVar2 == null) {
                            j.avw("msgInfo");
                        }
                        r rVar3;
                        if (bo.isNullOrNil(rVar2.cwG)) {
                            str2 = "src_username";
                            rVar3 = gVar2.jVG;
                            if (rVar3 == null) {
                                j.avw("msgInfo");
                            }
                            intent.putExtra(str2, rVar3.HE());
                            str2 = "src_displayname";
                            rVar3 = gVar2.jVG;
                            if (rVar3 == null) {
                                j.avw("msgInfo");
                            }
                            intent.putExtra(str2, s.mJ(rVar3.HE()));
                        } else {
                            str2 = "src_username";
                            rVar3 = gVar2.jVG;
                            if (rVar3 == null) {
                                j.avw("msgInfo");
                            }
                            intent.putExtra(str2, rVar3.cwG);
                            str2 = "src_displayname";
                            rVar3 = gVar2.jVG;
                            if (rVar3 == null) {
                                j.avw("msgInfo");
                            }
                            intent.putExtra(str2, rVar3.fjR);
                        }
                        intent.putExtra("Ksnsupload_type", 1);
                        str2 = "ShareUrlOriginal";
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar4 = gVar2.jWx;
                        if (bVar4 == null) {
                            j.avw("controller");
                        }
                        intent.putExtra(str2, bVar4.url);
                        intent.putExtra("KPublisherId", str3);
                        intent.putExtra("need_result", true);
                        str2 = v.nW(str3);
                        com.tencent.mm.model.v.b y = v.Zp().y(str2, true);
                        y.j("sendAppMsgScene", Integer.valueOf(2));
                        str3 = "preChatName";
                        r rVar4 = gVar2.jVG;
                        if (rVar4 == null) {
                            j.avw("msgInfo");
                        }
                        y.j(str3, rVar4.HE());
                        str3 = "preMsgIndex";
                        rVar4 = gVar2.jVG;
                        if (rVar4 == null) {
                            j.avw("msgInfo");
                        }
                        y.j(str3, Integer.valueOf(rVar4.fjQ));
                        str3 = "prePublishId";
                        rVar4 = gVar2.jVG;
                        if (rVar4 == null) {
                            j.avw("msgInfo");
                        }
                        y.j(str3, rVar4.fjS);
                        str3 = "preUsername";
                        rVar4 = gVar2.jVG;
                        if (rVar4 == null) {
                            j.avw("msgInfo");
                        }
                        y.j(str3, rVar4.HE());
                        str3 = "url";
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar5 = gVar2.jWx;
                        if (bVar5 == null) {
                            j.avw("controller");
                        }
                        y.j(str3, bVar5.url);
                        str3 = "referUrl";
                        bVar5 = gVar2.jWx;
                        if (bVar5 == null) {
                            j.avw("controller");
                        }
                        y.j(str3, bVar5.url);
                        rVar = gVar2.jVG;
                        if (rVar == null) {
                            j.avw("msgInfo");
                        }
                        itemId = rVar.fjT.type;
                        if (itemId != -1) {
                            y.j("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(itemId));
                            rVar = gVar2.jVG;
                            if (rVar == null) {
                                j.avw("msgInfo");
                            }
                            if (rVar.fjT.type == 5) {
                                r rVar5;
                                str3 = "_DATA_CENTER_VID";
                                rVar4 = gVar2.jVG;
                                if (rVar4 == null) {
                                    j.avw("msgInfo");
                                }
                                y.j(str3, rVar4.fjT.fgd);
                                str3 = "_DATA_CENTER_PUB_TIME";
                                rVar4 = gVar2.jVG;
                                if (rVar4 == null) {
                                    j.avw("msgInfo");
                                }
                                y.j(str3, Integer.valueOf((int) rVar4.fjT.time));
                                str3 = "_DATA_CENTER__DULATION";
                                rVar4 = gVar2.jVG;
                                if (rVar4 == null) {
                                    j.avw("msgInfo");
                                }
                                y.j(str3, Integer.valueOf(rVar4.fjT.fjB));
                                bVar = gVar2.jWx;
                                if (bVar == null) {
                                    j.avw("controller");
                                }
                                if (bVar.aYp()) {
                                    Object obj2;
                                    String str5 = "_DATA_CENTER_DESC";
                                    bVar = gVar2.jWx;
                                    if (bVar == null) {
                                        j.avw("controller");
                                    }
                                    bac = bVar.jVI;
                                    y.j(str5, bac != null ? bac.fjz : null);
                                    str3 = "_DATA_CENTER_COVER_URL";
                                    bVar5 = gVar2.jWx;
                                    if (bVar5 == null) {
                                        j.avw("controller");
                                    }
                                    bac bac2 = bVar5.jVI;
                                    if (bac2 != null) {
                                        obj2 = bac2.fjx;
                                    }
                                    y.j(str3, obj2);
                                } else {
                                    str3 = "_DATA_CENTER_DESC";
                                    rVar5 = gVar2.jVG;
                                    if (rVar5 == null) {
                                        j.avw("msgInfo");
                                    }
                                    y.j(str3, rVar5.fjT.fjz);
                                    str3 = "_DATA_CENTER_COVER_URL";
                                    rVar5 = gVar2.jVG;
                                    if (rVar5 == null) {
                                        j.avw("msgInfo");
                                    }
                                    y.j(str3, rVar5.fjT.fjx);
                                }
                                str3 = "_DATA_CENTER_VIDEO_WIDTH";
                                rVar5 = gVar2.jVG;
                                if (rVar5 == null) {
                                    j.avw("msgInfo");
                                }
                                y.j(str3, Integer.valueOf(rVar5.fjT.videoWidth));
                                str3 = "_DATA_CENTER_VIDEO_HEIGHT";
                                rVar5 = gVar2.jVG;
                                if (rVar5 == null) {
                                    j.avw("msgInfo");
                                }
                                y.j(str3, Integer.valueOf(rVar5.fjT.videoHeight));
                                y.j("_DATA_SHOW_NATIVE_PAGE", Integer.valueOf(1));
                                str3 = "_DATA_CENTER_FUNC_FLAG";
                                rVar5 = gVar2.jVG;
                                if (rVar5 == null) {
                                    j.avw("msgInfo");
                                }
                                y.j(str3, Integer.valueOf(rVar5.fgc));
                            }
                            y.j("_tmpl_webview_transfer_scene", Integer.valueOf(10));
                        }
                        intent.putExtra("reportSessionId", str2);
                        str = "BizVideoDetailUIExtras";
                        weakReference = gVar2.hiC;
                        if (weakReference == null) {
                            j.avw("ui");
                        }
                        obj = weakReference.get();
                        if (obj == null) {
                            j.dWJ();
                        }
                        j.o(obj, "ui.get()!!");
                        Intent intent2 = ((BizVideoDetailUI) obj).getIntent();
                        j.o(intent2, "ui.get()!!.intent");
                        intent.putExtra(str, intent2.getExtras());
                        com.tencent.mm.bp.d.a((Context) gVar2.aYo(), "sns", ".ui.SnsUploadUI", intent, 1, false);
                        AppMethodBeat.o(15339);
                        return;
                    }
                }
                ab.i(gVar2.TAG, "activity finished");
                AppMethodBeat.o(15339);
            } else if (itemId == this.jYV.jYP) {
                gVar = this.jYV;
                cl clVar = new cl();
                com.tencent.mm.plugin.webview.model.c.a aVar2 = new com.tencent.mm.plugin.webview.model.c.a();
                bVar = gVar.jWx;
                if (bVar == null) {
                    j.avw("controller");
                }
                aVar2.url = bVar.url;
                bVar = gVar.jWx;
                if (bVar == null) {
                    j.avw("controller");
                }
                if (bVar.aYp()) {
                    bVar = gVar.jWx;
                    if (bVar == null) {
                        j.avw("controller");
                    }
                    bac = bVar.jVI;
                    aVar2.thumbUrl = bac != null ? bac.fjx : null;
                    bVar = gVar.jWx;
                    if (bVar == null) {
                        j.avw("controller");
                    }
                    bac = bVar.jVI;
                    if (bac != null) {
                        str3 = bac.title;
                    } else {
                        str3 = null;
                    }
                    aVar2.title = str3;
                    bVar = gVar.jWx;
                    if (bVar == null) {
                        j.avw("controller");
                    }
                    bac = bVar.jVI;
                    if (bac != null) {
                        str = bac.fjz;
                    }
                    aVar2.desc = str;
                } else {
                    rVar = gVar.jVG;
                    if (rVar == null) {
                        j.avw("msgInfo");
                    }
                    aVar2.thumbUrl = rVar.fjT.fjx;
                    rVar = gVar.jVG;
                    if (rVar == null) {
                        j.avw("msgInfo");
                    }
                    aVar2.title = rVar.fjT.title;
                    rVar = gVar.jVG;
                    if (rVar == null) {
                        j.avw("msgInfo");
                    }
                    aVar2.desc = rVar.fjT.fjz;
                }
                rVar = gVar.jVG;
                if (rVar == null) {
                    j.avw("msgInfo");
                }
                com.tencent.mm.model.v.b y2 = v.Zp().y(v.nW(bo.nullAsNil(rVar.fjS)), true);
                if (y2 == null) {
                    j.dWJ();
                }
                y2.j("sendAppMsgScene", Integer.valueOf(2));
                str = "preChatName";
                r rVar6 = gVar.jVG;
                if (rVar6 == null) {
                    j.avw("msgInfo");
                }
                y2.j(str, rVar6.HE());
                str = "preMsgIndex";
                rVar6 = gVar.jVG;
                if (rVar6 == null) {
                    j.avw("msgInfo");
                }
                y2.j(str, Integer.valueOf(rVar6.fjQ));
                str = "prePublishId";
                rVar6 = gVar.jVG;
                if (rVar6 == null) {
                    j.avw("msgInfo");
                }
                y2.j(str, rVar6.fjS);
                str = "preUsername";
                rVar6 = gVar.jVG;
                if (rVar6 == null) {
                    j.avw("msgInfo");
                }
                y2.j(str, rVar6.HE());
                str = "referUrl";
                com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar6 = gVar.jWx;
                if (bVar6 == null) {
                    j.avw("controller");
                }
                y2.j(str, bVar6.url);
                clVar.cvA.activity = gVar.aYo();
                clVar.cvA.cvH = 36;
                com.tencent.mm.plugin.webview.model.c.a(clVar, aVar2);
                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                bVar = gVar.jWx;
                if (bVar == null) {
                    j.avw("controller");
                }
                bVar.jVC.sF(24);
                AppMethodBeat.o(15339);
            } else if (itemId == this.jYV.jYQ) {
                com.tencent.mm.plugin.webview.e.c.a(this.jYV.aYo(), g.a(this.jYV).fjT.title, new AnonymousClass1(this));
                AppMethodBeat.o(15339);
            } else if (itemId == this.jYV.jYR) {
                g.b(this.jYV).ao(2, "");
                AppMethodBeat.o(15339);
            } else if (itemId == this.jYV.jYS) {
                g gVar3 = this.jYV;
                bVar2 = gVar3.jWx;
                if (bVar2 == null) {
                    j.avw("controller");
                }
                if ((bVar2.fgc & 1) != 0) {
                    str4 = gVar3.TAG;
                    StringBuilder stringBuilder = new StringBuilder("not allow jump to profile ");
                    bVar = gVar3.jWx;
                    if (bVar == null) {
                        j.avw("controller");
                    }
                    ab.w(str4, stringBuilder.append(bVar.fgc).toString());
                    AppMethodBeat.o(15339);
                    return;
                }
                Intent intent3 = new Intent();
                str = "Contact_User";
                com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar7 = gVar3.jWx;
                if (bVar7 == null) {
                    j.avw("controller");
                }
                intent3.putExtra(str, bVar7.HE());
                intent3.putExtra("Contact_Scene", XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
                com.tencent.mm.bp.d.b((Context) gVar3.aYo(), Scopes.PROFILE, ".ui.ContactInfoUI", intent3);
                AppMethodBeat.o(15339);
            } else if (itemId == this.jYV.jYT) {
                gVar = this.jYV;
                if (gVar.isFinished()) {
                    ab.e(gVar.TAG, "copyLink fail, is finish");
                    AppMethodBeat.o(15339);
                    return;
                }
                aYo = gVar.aYo();
                if (aYo != null) {
                    Application application = aYo.getApplication();
                    if (application != null) {
                        obj = application.getSystemService("clipboard");
                        if (obj != null) {
                            a.v vVar = new a.v("null cannot be cast to non-null type android.text.ClipboardManager");
                            AppMethodBeat.o(15339);
                            throw vVar;
                        }
                        ClipboardManager clipboardManager = (ClipboardManager) obj;
                        if (clipboardManager != null) {
                            try {
                                bVar2 = gVar.jWx;
                                if (bVar2 == null) {
                                    j.avw("controller");
                                }
                                clipboardManager.setText(bVar2.jVB);
                                Context aYo2 = gVar.aYo();
                                BizVideoDetailUI aYo3 = gVar.aYo();
                                Toast.makeText(aYo2, aYo3 != null ? aYo3.getString(R.string.g1w) : null, 0).show();
                                AppMethodBeat.o(15339);
                                return;
                            } catch (Exception e) {
                                ab.printErrStackTrace(gVar.TAG, e, "clip.setText error", new Object[0]);
                                AppMethodBeat.o(15339);
                                return;
                            }
                        }
                        ab.e(gVar.TAG, "clipboard manager is null");
                        AppMethodBeat.o(15339);
                        return;
                    }
                }
                obj = null;
                if (obj != null) {
                }
            } else if (itemId == this.jYV.jYU) {
                Intent intent4;
                File dir;
                gVar = this.jYV;
                rVar = gVar.jVG;
                if (rVar == null) {
                    j.avw("msgInfo");
                }
                str2 = rVar.fjT.url;
                if (bo.isNullOrNil(str2)) {
                    str3 = null;
                } else {
                    Uri parse = Uri.parse(str2);
                    j.o(parse, ShareConstants.MEDIA_URI);
                    str3 = parse.getHost();
                }
                if (!bo.isNullOrNil(str3)) {
                    if (str3 == null) {
                        j.dWJ();
                    }
                    if (u.jb(str3, "mp.weixin.qq.com")) {
                        y yVar;
                        try {
                            yVar = y.AVH;
                            str3 = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", Arrays.copyOf(new Object[]{q.encode(str2, ProtocolPackage.ServerEncoding)}, 1));
                            j.o(str3, "java.lang.String.format(format, *args)");
                        } catch (UnsupportedEncodingException e2) {
                            ab.e(gVar.TAG, e2.getMessage());
                        }
                        if (bo.isNullOrNil(str3)) {
                            str4 = str3;
                        } else {
                            yVar = y.AVH;
                            str3 = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[]{Integer.valueOf(34)}, 1));
                            j.o(str3, "java.lang.String.format(format, *args)");
                            str4 = str3;
                        }
                        intent4 = new Intent();
                        aYo = gVar.aYo();
                        dir = aYo == null ? aYo.getDir("expose", 0) : null;
                        if (dir != null) {
                            dir.mkdirs();
                        }
                        if (dir != null) {
                            str = dir.getAbsolutePath();
                        }
                        str = j.u(str, "/screenshot.jpg");
                        com.tencent.mm.sdk.platformtools.d.a(bc.am(gVar.aYo()), 75, CompressFormat.JPEG, str, true);
                        intent4.putExtra("k_webview_img", str);
                        intent4.putExtra("rawUrl", str4);
                        intent4.putExtra("k_expose_url", str2);
                        str3 = "k_expose_web_scene";
                        bVar2 = gVar.jWx;
                        if (bVar2 == null) {
                            j.avw("controller");
                        }
                        intent4.putExtra(str3, bVar2.scene);
                        intent4.putExtra("showShare", false);
                        com.tencent.mm.bp.d.b((Context) gVar.aYo(), "webview", ".ui.tools.WebViewUI", intent4);
                        AppMethodBeat.o(15339);
                    }
                }
                str3 = null;
                if (bo.isNullOrNil(str3)) {
                }
                intent4 = new Intent();
                try {
                    aYo = gVar.aYo();
                    if (aYo == null) {
                    }
                    if (dir != null) {
                    }
                    if (dir != null) {
                    }
                    str = j.u(str, "/screenshot.jpg");
                    com.tencent.mm.sdk.platformtools.d.a(bc.am(gVar.aYo()), 75, CompressFormat.JPEG, str, true);
                    intent4.putExtra("k_webview_img", str);
                } catch (IOException e3) {
                    ab.e(gVar.TAG, "[oneliang]save screen shot to file error, ex = " + e3.getMessage());
                }
                intent4.putExtra("rawUrl", str4);
                intent4.putExtra("k_expose_url", str2);
                str3 = "k_expose_web_scene";
                bVar2 = gVar.jWx;
                if (bVar2 == null) {
                }
                intent4.putExtra(str3, bVar2.scene);
                intent4.putExtra("showShare", false);
                com.tencent.mm.bp.d.b((Context) gVar.aYo(), "webview", ".ui.tools.WebViewUI", intent4);
                AppMethodBeat.o(15339);
            } else {
                ab.w(this.jYV.TAG, "wrong id: " + menuItem.getItemId());
                AppMethodBeat.o(15339);
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class a implements n.c {
        final /* synthetic */ g jYV;

        public a(g gVar) {
            this.jYV = gVar;
        }

        public final void a(com.tencent.mm.ui.base.l lVar) {
            String string;
            AppMethodBeat.i(15337);
            h.pYm.a(480, 0, 1, false);
            lVar.clear();
            int i = this.jYV.jYN;
            BizVideoDetailUI aYo = this.jYV.aYo();
            lVar.a(i, aYo != null ? aYo.getString(R.string.dhh) : null, R.raw.bottomsheet_icon_transmit, g.a(this.jYV, this.jYV.jYN));
            i = this.jYV.jYO;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(R.string.dhi);
            } else {
                string = null;
            }
            lVar.a(i, string, R.raw.bottomsheet_icon_moment, g.a(this.jYV, this.jYV.jYO));
            jz jzVar = this.jYV.jXv;
            if (jzVar != null && jzVar.vMQ == 1) {
                jzVar = this.jYV.jXv;
                if (jzVar == null || jzVar.vMP != 0) {
                    i = this.jYV.jYR;
                    aYo = this.jYV.aYo();
                    lVar.a(i, aYo != null ? aYo.getString(R.string.dhj) : null, R.raw.bottomsheet_icon_cancel_hao_kan, g.a(this.jYV, this.jYV.jYR));
                } else {
                    i = this.jYV.jYQ;
                    aYo = this.jYV.aYo();
                    if (aYo != null) {
                        string = aYo.getString(R.string.dhr);
                    } else {
                        string = null;
                    }
                    lVar.a(i, string, R.raw.bottomsheet_icon_hao_kan, g.a(this.jYV, this.jYV.jYQ));
                }
            }
            i = this.jYV.jYP;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(R.string.dcq);
            } else {
                string = null;
            }
            lVar.a(i, string, R.raw.bottomsheet_icon_fav, g.a(this.jYV, this.jYV.jYP));
            i = this.jYV.jYS;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(R.string.g26);
            } else {
                string = null;
            }
            lVar.a(i, string, R.raw.bottomsheet_icon_brand_profile, g.a(this.jYV, this.jYV.jYS));
            i = this.jYV.jYU;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(R.string.a9n);
            } else {
                string = null;
            }
            lVar.a(i, string, R.raw.bottomsheet_icon_complain, g.a(this.jYV, this.jYV.jYU));
            i = this.jYV.jYT;
            aYo = this.jYV.aYo();
            if (aYo != null) {
                string = aYo.getString(R.string.g1v);
            } else {
                string = null;
            }
            lVar.a(i, string, R.raw.bottomsheet_icon_copy, g.a(this.jYV, this.jYV.jYT));
            AppMethodBeat.o(15337);
        }
    }

    public static final /* synthetic */ r a(g gVar) {
        AppMethodBeat.i(15343);
        r rVar = gVar.jVG;
        if (rVar == null) {
            j.avw("msgInfo");
        }
        AppMethodBeat.o(15343);
        return rVar;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.brandservice.ui.timeline.video.b b(g gVar) {
        AppMethodBeat.i(15344);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar = gVar.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        AppMethodBeat.o(15344);
        return bVar;
    }

    public final BizVideoDetailUI aYo() {
        AppMethodBeat.i(15340);
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            j.avw("ui");
        }
        if (weakReference.get() == null) {
            AppMethodBeat.o(15340);
            return null;
        }
        weakReference = this.hiC;
        if (weakReference == null) {
            j.avw("ui");
        }
        Object obj = weakReference.get();
        if (obj == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
            AppMethodBeat.o(15340);
            throw vVar;
        }
        BizVideoDetailUI bizVideoDetailUI = (BizVideoDetailUI) obj;
        AppMethodBeat.o(15340);
        return bizVideoDetailUI;
    }

    public final boolean isFinished() {
        AppMethodBeat.i(15341);
        WeakReference weakReference = this.hiC;
        if (weakReference == null) {
            j.avw("ui");
        }
        if (weakReference.get() != null) {
            weakReference = this.hiC;
            if (weakReference == null) {
                j.avw("ui");
            }
            Object obj = weakReference.get();
            if (obj == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI");
                AppMethodBeat.o(15341);
                throw vVar;
            } else if (!((BizVideoDetailUI) obj).isFinishing()) {
                AppMethodBeat.o(15341);
                return false;
            }
        }
        AppMethodBeat.o(15341);
        return true;
    }

    public static final /* synthetic */ boolean a(g gVar, int i) {
        AppMethodBeat.i(15342);
        com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar = gVar.jWx;
        if (bVar == null) {
            j.avw("controller");
        }
        if ((bVar.fgc & 2) == 0 || !(i == gVar.jYN || i == gVar.jYO || i == gVar.jYP || i == gVar.jYT)) {
            AppMethodBeat.o(15342);
            return false;
        }
        AppMethodBeat.o(15342);
        return true;
    }
}
