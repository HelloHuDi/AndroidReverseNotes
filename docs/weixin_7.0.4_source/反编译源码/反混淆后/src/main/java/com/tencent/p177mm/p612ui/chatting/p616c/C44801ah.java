package com.tencent.p177mm.p612ui.chatting.p616c;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32290n;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C45161i.C17945a;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.p201az.C32325e;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.BaseChattingUIFragment;
import com.tencent.p177mm.p612ui.chatting.C30576v;
import com.tencent.p177mm.p612ui.chatting.C36121ak;
import com.tencent.p177mm.p612ui.chatting.C44315r;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44296aa;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46641ai;
import com.tencent.p177mm.p612ui.tools.C36338a;
import com.tencent.p177mm.p612ui.tools.C36338a.C363371;
import com.tencent.p177mm.p612ui.widget.DrawnCallBackLinearLayout;
import com.tencent.p177mm.p612ui.widget.DrawnCallBackLinearLayout.C24083a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;

@C15590a(dFp = C44296aa.class)
/* renamed from: com.tencent.mm.ui.chatting.c.ah */
public class C44801ah extends C44291a implements C17945a, C44296aa {
    private C5653c opc;

    /* renamed from: com.tencent.mm.ui.chatting.c.ah$2 */
    class C304602 implements Runnable {
        C304602() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31664);
            C44801ah.this.cgL.aWv();
            AppMethodBeat.m2505o(31664);
        }
    }

    /* renamed from: a */
    public final boolean mo70170a(MenuItem menuItem, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31667);
        switch (menuItem.getItemId()) {
            case 110:
                C44315r.m80104a(c7620bi, this.cgL.yTx.getContext(), this.cgL);
                AppMethodBeat.m2505o(31667);
                return true;
            default:
                AppMethodBeat.m2505o(31667);
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x017d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public final boolean mo70172g(int i, int i2, Intent intent) {
        int i3 = 1;
        AppMethodBeat.m2504i(31668);
        this.cgL.dismissDialog();
        if (i2 != -1) {
            C4990ab.m7413e("MicroMsg.ChattingUI.SendImgComponent", "[dealWithRequestCode] resultCode:%d", Integer.valueOf(i2));
            AppMethodBeat.m2505o(31668);
            return false;
        }
        Intent intent2;
        String talkerUserName;
        switch (i) {
            case 200:
                if (intent == null) {
                    AppMethodBeat.m2505o(31668);
                    return true;
                }
                boolean z;
                intent2 = new Intent();
                intent2.setClassName(this.cgL.yTx.getContext(), "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                String str = "CropImage_Has_Raw_Img_Btn";
                talkerUserName = this.cgL.getTalkerUserName();
                if (talkerUserName == null || !(C7616ad.aou(talkerUserName) || C7616ad.aow(talkerUserName))) {
                    z = true;
                } else {
                    z = false;
                }
                intent2.putExtra(str, z);
                intent2.putExtra("from_source", 3);
                BaseChattingUIFragment baseChattingUIFragment = this.cgL.yTx;
                C9638aw.m17190ZK();
                str = C18628c.m29088XW();
                if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
                    new C363371(intent, baseChattingUIFragment, str, intent2).execute(new Integer[]{Integer.valueOf(0)});
                } else {
                    str = C36338a.m59824i(baseChattingUIFragment.getContext(), intent, str);
                    if (!C5046bo.isNullOrNil(str)) {
                        intent2.putExtra("CropImage_ImgPath", str);
                        baseChattingUIFragment.startActivityForResult(intent2, 203);
                    }
                }
                AppMethodBeat.m2505o(31668);
                return true;
            case 201:
                Context applicationContext = this.cgL.yTx.getContext().getApplicationContext();
                C9638aw.m17190ZK();
                talkerUserName = C14987n.m23320h(applicationContext, intent, C18628c.m29088XW());
                if (talkerUserName == null) {
                    AppMethodBeat.m2505o(31668);
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
                C25985d.m41458a(this.cgL.yTx, "gallery", ".ui.GalleryEntryUI", intent2, 217);
                AppMethodBeat.m2505o(31668);
                return true;
            case 203:
                C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                if (stringExtra != null) {
                    boolean g = C1853r.m3854g(stringExtra, this.cgL.getTalkerUserName(), intent.getBooleanExtra("CropImage_Compress_Img", true));
                    intent.getIntExtra("from_source", 0);
                    int intExtra = intent.getIntExtra("CropImage_rotateCount", 0);
                    C4990ab.m7410d("MicroMsg.ChattingUI.SendImgComponent", "dkimgsource" + intent.getIntExtra("from_source", 0));
                    if (!g) {
                        i3 = 0;
                    }
                    mo70167B(i3, intExtra, stringExtra);
                    c15614o.dDX().clearFocus();
                    break;
                }
                c15614o.dDX().clearFocus();
                AppMethodBeat.m2505o(31668);
                return true;
            case 217:
                Intent intent3;
                if (intent == null) {
                    ArrayList sq = C32290n.ahb().mo53001sq(this.cgL.getTalkerUserName());
                    if (sq.size() > 0) {
                        intent = new Intent();
                        intent.putStringArrayListExtra("CropImage_OutputPath_List", sq);
                        sq = new ArrayList();
                        sq.add(Integer.valueOf(-1));
                        intent.putIntegerArrayListExtra("GalleryUI_ImgIdList", sq);
                        C7060h.pYm.mo8378a(594, 4, 1, true);
                        intent3 = intent;
                        if (intent3 == null) {
                            talkerUserName = intent3.getStringExtra("GalleryUI_ToUser");
                            final String talkerUserName2 = C5046bo.isNullOrNil(talkerUserName) ? this.cgL.getTalkerUserName() : talkerUserName;
                            C4990ab.m7417i("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", talkerUserName, this.cgL.getTalkerUserName());
                            final C15614o c15614o2 = (C15614o) this.cgL.mo74857aF(C15614o.class);
                            c15614o2.dDX().clearFocus();
                            c15614o2.dDX().setBottomPanelVisibility(8);
                            DrawnCallBackLinearLayout drawnCallBackLinearLayout = (DrawnCallBackLinearLayout) this.cgL.findViewById(2131821521);
                            if (drawnCallBackLinearLayout != null) {
                                final int i4 = i;
                                drawnCallBackLinearLayout.setListener(new C24083a() {

                                    /* renamed from: com.tencent.mm.ui.chatting.c.ah$1$1 */
                                    class C249501 implements Runnable {
                                        C249501() {
                                        }

                                        public final void run() {
                                            AppMethodBeat.m2504i(31662);
                                            C9638aw.m17180RS().mo10299Bn();
                                            C44801ah.m81899a(C44801ah.this, intent3, talkerUserName2);
                                            ((C46641ai) C44801ah.this.cgL.mo74857aF(C46641ai.class)).mo72006aW(intent3);
                                            if (c15614o2.dDY() != null) {
                                                c15614o2.dDY().mo64207r(i4, intent3);
                                            }
                                            C9638aw.m17180RS().doM();
                                            AppMethodBeat.m2505o(31662);
                                        }
                                    }

                                    public final void dEX() {
                                        AppMethodBeat.m2504i(31663);
                                        C9638aw.m17180RS().mo10310m(new C249501(), 100);
                                        AppMethodBeat.m2505o(31663);
                                    }
                                });
                                break;
                            }
                        }
                        C4990ab.m7412e("MicroMsg.ChattingUI.SendImgComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                        AppMethodBeat.m2505o(31668);
                        return true;
                    }
                }
                intent3 = intent;
                if (intent3 == null) {
                }
                break;
        }
        AppMethodBeat.m2505o(31668);
        return false;
    }

    /* renamed from: a */
    public final void mo70169a(SightCaptureResult sightCaptureResult) {
        AppMethodBeat.m2504i(31669);
        String str = sightCaptureResult.osI;
        if (!C5046bo.isNullOrNil(str)) {
            try {
                boolean z = sightCaptureResult.osB;
                C4990ab.m7417i("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage, path: %s", str);
                C9638aw.m17182Rg().mo14541a(new C9022l(z ? 2 : 1, C1853r.m3846Yz(), this.cgL.getTalkerUserName(), str, 1, null, 0, "", "", true, C25738R.drawable.b0p), 0);
                AppMethodBeat.m2505o(31669);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ChattingUI.SendImgComponent", "doSendChattingImage error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(31669);
    }

    /* renamed from: B */
    public final void mo70167B(int i, int i2, String str) {
        AppMethodBeat.m2504i(31670);
        if (str == null || str.equals("") || !C5730e.m8628ct(str)) {
            C4990ab.m7410d("MicroMsg.ChattingUI.SendImgComponent", " doSendImage : filePath is null or empty");
            AppMethodBeat.m2505o(31670);
        } else if (C40729i.m70426ad(this.cgL.sRl)) {
            AppMethodBeat.m2505o(31670);
        } else {
            C9638aw.m17182Rg().mo14541a(new C9022l(4, this.cgL.dFu(), this.cgL.getTalkerUserName(), str, i, null, i2, "", "", true, C25738R.drawable.b0p), 0);
            this.cgL.mo74882qp(true);
            AppMethodBeat.m2505o(31670);
        }
    }

    /* renamed from: bb */
    public final boolean mo70171bb(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31671);
        if (c7620bi.drE()) {
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                if (!this.cgL.getTalkerUserName().equals("medianote")) {
                    C9638aw.m17190ZK();
                    C18628c.m29077XL().mo7920c(new C32325e(c7620bi.field_talker, c7620bi.field_msgSvrId));
                }
                C36121ak.m59476aR(c7620bi);
                this.cgL.mo74882qp(true);
                AppMethodBeat.m2505o(31671);
                return true;
            }
            C23639t.m36492hO(this.cgL.yTx.getContext());
            AppMethodBeat.m2505o(31671);
            return true;
        }
        AppMethodBeat.m2505o(31671);
        return false;
    }

    /* renamed from: a */
    public final void mo70168a(ContextMenu contextMenu, int i, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31672);
        contextMenu.add(i, 100, 0, this.cgL.yTx.getMMResources().getString(C25738R.string.am6));
        C25822e c25822e = null;
        if (c7620bi.field_msgId > 0) {
            c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
        }
        if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
            c25822e = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
        }
        if (c7620bi.field_isSend == 1 || (c25822e != null && c7620bi.field_isSend == 0 && c25822e.offset >= c25822e.frO && c25822e.frO != 0)) {
            contextMenu.add(i, 110, 0, this.cgL.yTx.getMMResources().getString(C25738R.string.dr1));
        }
        String q = c25822e == null ? "" : C32291o.ahl().mo73118q(c25822e.fDz, "", "");
        if (c25822e != null && C5730e.m8628ct(q)) {
            contextMenu.add(i, 112, 0, this.cgL.yTx.getMMResources().getString(C25738R.string.akc));
        }
        AppMethodBeat.m2505o(31672);
    }

    /* renamed from: b */
    public final void mo33481b(long j, int i, int i2) {
        AppMethodBeat.m2504i(31673);
        ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27826o(j, i, i2);
        AppMethodBeat.m2505o(31673);
    }

    /* renamed from: k */
    public final void mo33482k(long j, boolean z) {
        AppMethodBeat.m2504i(31674);
        ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27797B(j, z);
        AppMethodBeat.m2505o(31674);
    }

    /* renamed from: z */
    public final void mo70173z(String str, int i, final String str2) {
        AppMethodBeat.m2504i(31675);
        if ((this.opc == null || !this.opc.isShowing()) && !C5046bo.isNullOrNil(str2) && C5063r.amn(str2)) {
            Bitmap d = C5056d.m7659d(str2, 300, 300, false);
            if (d == null) {
                C4990ab.m7412e("MicroMsg.ChattingUI.SendImgComponent", "showAlert fail, bmp is null");
                AppMethodBeat.m2505o(31675);
                return;
            }
            final C15614o c15614o = (C15614o) this.cgL.mo74857aF(C15614o.class);
            View imageView = new ImageView(this.cgL.yTx.getContext());
            int dimensionPixelSize = this.cgL.yTx.getMMResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
            imageView.setImageBitmap(d);
            imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            String string = Secure.getString(this.cgL.yTx.getContentResolver(), "default_input_method");
            final boolean z = C5063r.m7677bS(C5730e.m8632e(str2, 0, -1)) && (string.contains("com.sohu.inputmethod.sogou") || string.contains("com.tencent.qqpinyin"));
            this.opc = C30379h.m48437a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.aoh), imageView, this.cgL.yTx.getMMResources().getString(C25738R.string.f9187s6), this.cgL.yTx.getMMResources().getString(C25738R.string.f9076or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(31665);
                    if (!z || c15614o.dDX() == null || c15614o.dDX().getCallback() == null || !(c15614o.dDX().getCallback() instanceof C30576v)) {
                        C9638aw.m17182Rg().mo14541a(new C9022l(5, C44801ah.this.cgL.dFu(), C44801ah.this.cgL.getTalkerUserName(), str2, 0, null, 0, "", "", true, C25738R.drawable.b0p), 0);
                        AppMethodBeat.m2505o(31665);
                        return;
                    }
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    if ((C5056d.decodeFile(str2, options) == null || options.outHeight <= C42164b.m74339Na()) && options.outWidth <= C42164b.m74339Na()) {
                        String a = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35616a(C44801ah.this.cgL.yTx.getContext(), new WXMediaMessage(new WXEmojiObject(str2)), null);
                        if (a != null) {
                            ((C30576v) c15614o.dDX().getCallback()).mo39017B(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(a));
                        }
                        AppMethodBeat.m2505o(31665);
                        return;
                    }
                    Toast.makeText(C44801ah.this.cgL.yTx.getContext(), C25738R.string.b9x, 0).show();
                    AppMethodBeat.m2505o(31665);
                }
            }, null);
            string = str.substring(0, i);
            c15614o.dDX().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(31666);
                    c15614o.dDX().mo63996u(string, -1, false);
                    AppMethodBeat.m2505o(31666);
                }
            }, 10);
        }
        AppMethodBeat.m2505o(31675);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31676);
        super.onActivityResult(i, i2, intent);
        mo70172g(i, i2, intent);
        AppMethodBeat.m2505o(31676);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31679);
        super.dDh();
        C32291o.ahj().fEN = null;
        AppMethodBeat.m2505o(31679);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31677);
        C32291o.ahj().fEN = this;
        AppMethodBeat.m2505o(31677);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31678);
        C32291o.ahj().fEN = null;
        AppMethodBeat.m2505o(31678);
    }
}
