package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.Settings.Secure;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.i;
import com.tencent.mm.at.l;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;

@a(dFp = aa.class)
public class ah extends a implements i.a, aa {
    private c opc;

    public final boolean a(MenuItem menuItem, bi biVar) {
        AppMethodBeat.i(31667);
        switch (menuItem.getItemId()) {
            case 110:
                r.a(biVar, this.cgL.yTx.getContext(), this.cgL);
                AppMethodBeat.o(31667);
                return true;
            default:
                AppMethodBeat.o(31667);
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x017d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(int i, int i2, Intent intent) {
        int i3 = 1;
        AppMethodBeat.i(31668);
        this.cgL.dismissDialog();
        if (i2 != -1) {
            ab.e("MicroMsg.ChattingUI.SendImgComponent", "[dealWithRequestCode] resultCode:%d", Integer.valueOf(i2));
            AppMethodBeat.o(31668);
            return false;
        }
        Intent intent2;
        String talkerUserName;
        switch (i) {
            case 200:
                if (intent == null) {
                    AppMethodBeat.o(31668);
                    return true;
                }
                boolean z;
                intent2 = new Intent();
                intent2.setClassName(this.cgL.yTx.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                String str = "CropImage_Has_Raw_Img_Btn";
                talkerUserName = this.cgL.getTalkerUserName();
                if (talkerUserName == null || !(ad.aou(talkerUserName) || ad.aow(talkerUserName))) {
                    z = true;
                } else {
                    z = false;
                }
                intent2.putExtra(str, z);
                intent2.putExtra("from_source", 3);
                BaseChattingUIFragment baseChattingUIFragment = this.cgL.yTx;
                aw.ZK();
                str = com.tencent.mm.model.c.XW();
                if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
                    new com.tencent.mm.ui.tools.a.AnonymousClass1(intent, baseChattingUIFragment, str, intent2).execute(new Integer[]{Integer.valueOf(0)});
                } else {
                    str = com.tencent.mm.ui.tools.a.i(baseChattingUIFragment.getContext(), intent, str);
                    if (!bo.isNullOrNil(str)) {
                        intent2.putExtra("CropImage_ImgPath", str);
                        baseChattingUIFragment.startActivityForResult(intent2, 203);
                    }
                }
                AppMethodBeat.o(31668);
                return true;
            case 201:
                Context applicationContext = this.cgL.yTx.getContext().getApplicationContext();
                aw.ZK();
                talkerUserName = n.h(applicationContext, intent, com.tencent.mm.model.c.XW());
                if (talkerUserName == null) {
                    AppMethodBeat.o(31668);
                    return true;
                }
                intent2 = new Intent();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(talkerUserName);
                intent2.putExtra("query_source_type", 3);
                intent2.putExtra("preview_image", true);
                intent2.putExtra("isTakePhoto", true);
                intent2.putExtra("GalleryUI_FromUser", this.cgL.dFu());
                intent2.putExtra("GalleryUI_ToUser", this.cgL.getTalkerUserName());
                intent2.putExtra("is_long_click", true);
                intent2.putStringArrayListExtra("preview_image_list", arrayList);
                intent2.addFlags(67108864);
                d.a(this.cgL.yTx, "gallery", ".ui.GalleryEntryUI", intent2, 217);
                AppMethodBeat.o(31668);
                return true;
            case 203:
                o oVar = (o) this.cgL.aF(o.class);
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                if (stringExtra != null) {
                    boolean g = com.tencent.mm.model.r.g(stringExtra, this.cgL.getTalkerUserName(), intent.getBooleanExtra("CropImage_Compress_Img", true));
                    intent.getIntExtra("from_source", 0);
                    int intExtra = intent.getIntExtra("CropImage_rotateCount", 0);
                    ab.d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + intent.getIntExtra("from_source", 0));
                    if (!g) {
                        i3 = 0;
                    }
                    B(i3, intExtra, stringExtra);
                    oVar.dDX().clearFocus();
                    break;
                }
                oVar.dDX().clearFocus();
                AppMethodBeat.o(31668);
                return true;
            case 217:
                Intent intent3;
                if (intent == null) {
                    ArrayList sq = com.tencent.mm.at.n.ahb().sq(this.cgL.getTalkerUserName());
                    if (sq.size() > 0) {
                        intent = new Intent();
                        intent.putStringArrayListExtra("CropImage_OutputPath_List", sq);
                        sq = new ArrayList();
                        sq.add(Integer.valueOf(-1));
                        intent.putIntegerArrayListExtra("GalleryUI_ImgIdList", sq);
                        h.pYm.a(594, 4, 1, true);
                        intent3 = intent;
                        if (intent3 == null) {
                            talkerUserName = intent3.getStringExtra("GalleryUI_ToUser");
                            final String talkerUserName2 = bo.isNullOrNil(talkerUserName) ? this.cgL.getTalkerUserName() : talkerUserName;
                            ab.i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", talkerUserName, this.cgL.getTalkerUserName());
                            final o oVar2 = (o) this.cgL.aF(o.class);
                            oVar2.dDX().clearFocus();
                            oVar2.dDX().setBottomPanelVisibility(8);
                            DrawnCallBackLinearLayout drawnCallBackLinearLayout = (DrawnCallBackLinearLayout) this.cgL.findViewById(R.id.zd);
                            if (drawnCallBackLinearLayout != null) {
                                final int i4 = i;
                                drawnCallBackLinearLayout.setListener(new DrawnCallBackLinearLayout.a() {
                                    public final void dEX() {
                                        AppMethodBeat.i(31663);
                                        aw.RS().m(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(31662);
                                                aw.RS().Bn();
                                                ah.a(ah.this, intent3, talkerUserName2);
                                                ((ai) ah.this.cgL.aF(ai.class)).aW(intent3);
                                                if (oVar2.dDY() != null) {
                                                    oVar2.dDY().r(i4, intent3);
                                                }
                                                aw.RS().doM();
                                                AppMethodBeat.o(31662);
                                            }
                                        }, 100);
                                        AppMethodBeat.o(31663);
                                    }
                                });
                                break;
                            }
                        }
                        ab.e("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                        AppMethodBeat.o(31668);
                        return true;
                    }
                }
                intent3 = intent;
                if (intent3 == null) {
                }
                break;
        }
        AppMethodBeat.o(31668);
        return false;
    }

    public final void a(SightCaptureResult sightCaptureResult) {
        AppMethodBeat.i(31669);
        String str = sightCaptureResult.osI;
        if (!bo.isNullOrNil(str)) {
            try {
                boolean z = sightCaptureResult.osB;
                ab.i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", str);
                aw.Rg().a(new l(z ? 2 : 1, com.tencent.mm.model.r.Yz(), this.cgL.getTalkerUserName(), str, 1, null, 0, "", "", true, R.drawable.b0p), 0);
                AppMethodBeat.o(31669);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(31669);
    }

    public final void B(int i, int i2, String str) {
        AppMethodBeat.i(31670);
        if (str == null || str.equals("") || !e.ct(str)) {
            ab.d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
            AppMethodBeat.o(31670);
        } else if (i.ad(this.cgL.sRl)) {
            AppMethodBeat.o(31670);
        } else {
            aw.Rg().a(new l(4, this.cgL.dFu(), this.cgL.getTalkerUserName(), str, i, null, i2, "", "", true, R.drawable.b0p), 0);
            this.cgL.qp(true);
            AppMethodBeat.o(31670);
        }
    }

    public final boolean bb(bi biVar) {
        AppMethodBeat.i(31671);
        if (biVar.drE()) {
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                if (!this.cgL.getTalkerUserName().equals("medianote")) {
                    aw.ZK();
                    com.tencent.mm.model.c.XL().c(new com.tencent.mm.az.e(biVar.field_talker, biVar.field_msgSvrId));
                }
                ak.aR(biVar);
                this.cgL.qp(true);
                AppMethodBeat.o(31671);
                return true;
            }
            t.hO(this.cgL.yTx.getContext());
            AppMethodBeat.o(31671);
            return true;
        }
        AppMethodBeat.o(31671);
        return false;
    }

    public final void a(ContextMenu contextMenu, int i, bi biVar) {
        AppMethodBeat.i(31672);
        contextMenu.add(i, 100, 0, this.cgL.yTx.getMMResources().getString(R.string.am6));
        com.tencent.mm.at.e eVar = null;
        if (biVar.field_msgId > 0) {
            eVar = com.tencent.mm.at.o.ahl().fJ(biVar.field_msgId);
        }
        if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
            eVar = com.tencent.mm.at.o.ahl().fI(biVar.field_msgSvrId);
        }
        if (biVar.field_isSend == 1 || (eVar != null && biVar.field_isSend == 0 && eVar.offset >= eVar.frO && eVar.frO != 0)) {
            contextMenu.add(i, 110, 0, this.cgL.yTx.getMMResources().getString(R.string.dr1));
        }
        String q = eVar == null ? "" : com.tencent.mm.at.o.ahl().q(eVar.fDz, "", "");
        if (eVar != null && e.ct(q)) {
            contextMenu.add(i, 112, 0, this.cgL.yTx.getMMResources().getString(R.string.akc));
        }
        AppMethodBeat.o(31672);
    }

    public final void b(long j, int i, int i2) {
        AppMethodBeat.i(31673);
        ((com.tencent.mm.ui.chatting.c.b.h) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).o(j, i, i2);
        AppMethodBeat.o(31673);
    }

    public final void k(long j, boolean z) {
        AppMethodBeat.i(31674);
        ((com.tencent.mm.ui.chatting.c.b.h) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).B(j, z);
        AppMethodBeat.o(31674);
    }

    public final void z(String str, int i, final String str2) {
        AppMethodBeat.i(31675);
        if ((this.opc == null || !this.opc.isShowing()) && !bo.isNullOrNil(str2) && com.tencent.mm.sdk.platformtools.r.amn(str2)) {
            Bitmap d = com.tencent.mm.sdk.platformtools.d.d(str2, 300, 300, false);
            if (d == null) {
                ab.e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
                AppMethodBeat.o(31675);
                return;
            }
            final o oVar = (o) this.cgL.aF(o.class);
            View imageView = new ImageView(this.cgL.yTx.getContext());
            int dimensionPixelSize = this.cgL.yTx.getMMResources().getDimensionPixelSize(R.dimen.l5);
            imageView.setImageBitmap(d);
            imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            String string = Secure.getString(this.cgL.yTx.getContentResolver(), "default_input_method");
            final boolean z = com.tencent.mm.sdk.platformtools.r.bS(e.e(str2, 0, -1)) && (string.contains("com.sohu.inputmethod.sogou") || string.contains("com.tencent.qqpinyin"));
            this.opc = com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.aoh), imageView, this.cgL.yTx.getMMResources().getString(R.string.s6), this.cgL.yTx.getMMResources().getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(31665);
                    if (!z || oVar.dDX() == null || oVar.dDX().getCallback() == null || !(oVar.dDX().getCallback() instanceof v)) {
                        aw.Rg().a(new l(5, ah.this.cgL.dFu(), ah.this.cgL.getTalkerUserName(), str2, 0, null, 0, "", "", true, R.drawable.b0p), 0);
                        AppMethodBeat.o(31665);
                        return;
                    }
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    if ((com.tencent.mm.sdk.platformtools.d.decodeFile(str2, options) == null || options.outHeight <= b.Na()) && options.outWidth <= b.Na()) {
                        String a = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(ah.this.cgL.yTx.getContext(), new WXMediaMessage(new WXEmojiObject(str2)), null);
                        if (a != null) {
                            ((v) oVar.dDX().getCallback()).B(((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(a));
                        }
                        AppMethodBeat.o(31665);
                        return;
                    }
                    Toast.makeText(ah.this.cgL.yTx.getContext(), R.string.b9x, 0).show();
                    AppMethodBeat.o(31665);
                }
            }, null);
            string = str.substring(0, i);
            oVar.dDX().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31666);
                    oVar.dDX().u(string, -1, false);
                    AppMethodBeat.o(31666);
                }
            }, 10);
        }
        AppMethodBeat.o(31675);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31676);
        super.onActivityResult(i, i2, intent);
        g(i, i2, intent);
        AppMethodBeat.o(31676);
    }

    public final void dDh() {
        AppMethodBeat.i(31679);
        super.dDh();
        com.tencent.mm.at.o.ahj().fEN = null;
        AppMethodBeat.o(31679);
    }

    public final void dxz() {
        AppMethodBeat.i(31677);
        com.tencent.mm.at.o.ahj().fEN = this;
        AppMethodBeat.o(31677);
    }

    public final void dxC() {
        AppMethodBeat.i(31678);
        com.tencent.mm.at.o.ahj().fEN = null;
        AppMethodBeat.o(31678);
    }
}
