package com.tencent.p177mm.p612ui.chatting.p616c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C1878c;
import com.tencent.p177mm.modelvideo.C1878c.C1877a;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44296aa;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46641ai;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.pluginsdk.model.C30076j.C30077a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;

@C15590a(dFp = C46641ai.class)
/* renamed from: com.tencent.mm.ui.chatting.c.ar */
public class C44806ar extends C44291a implements C46641ai {
    private long yTb = -1;
    private SparseBooleanArray yTc = new SparseBooleanArray();

    /* renamed from: com.tencent.mm.ui.chatting.c.ar$3 */
    class C407183 implements C30077a {
        C407183() {
        }

        public final void dhi() {
            AppMethodBeat.m2504i(31847);
            C44806ar.this.cgL.dismissDialog();
            AppMethodBeat.m2505o(31847);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ar$6 */
    class C407206 implements C1877a {
        C407206() {
        }

        /* renamed from: b */
        public final void mo5453b(int i, String str, String str2, int i2) {
            AppMethodBeat.m2504i(31850);
            if (i == -50002) {
                Toast.makeText(C44806ar.this.cgL.yTx.getContext(), C44806ar.this.cgL.yTx.getContext().getString(C25738R.string.f16), 0).show();
            } else if (i < 0) {
                Toast.makeText(C44806ar.this.cgL.yTx.getContext(), C44806ar.this.cgL.yTx.getContext().getString(C25738R.string.f15), 0).show();
            } else {
                C26494u.m42246c(str, i2, C44806ar.this.cgL.getTalkerUserName(), str2);
                C26494u.m42263uo(str);
            }
            C44806ar.this.cgL.dismissDialog();
            AppMethodBeat.m2505o(31850);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.ar$2 */
    class C448072 implements OnClickListener {
        C448072() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public C44806ar() {
        AppMethodBeat.m2504i(31851);
        AppMethodBeat.m2505o(31851);
    }

    /* renamed from: eC */
    private void m81925eC(final String str, final int i) {
        AppMethodBeat.m2504i(31852);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(31846);
                C26494u.m42244ag(str, i);
                AppMethodBeat.m2505o(31846);
            }
        });
        AppMethodBeat.m2505o(31852);
    }

    /* renamed from: a */
    public final boolean mo72005a(MenuItem menuItem, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31853);
        int i;
        String uu;
        Intent intent;
        switch (menuItem.getItemId()) {
            case 106:
                C26493s uf = C37961o.all().mo21063uf(c7620bi.field_imgPath);
                if (uf == null) {
                    C4990ab.m7412e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
                } else if (uf.status == 199) {
                    C37961o.all();
                    String uh = C9720t.m17303uh(c7620bi.field_imgPath);
                    if (uf != null) {
                        i = 0;
                        if (C1855t.m3896kH(uf.getUser())) {
                            i = C37921n.m64060mA(uf.getUser());
                        }
                        C7060h.pYm.mo8378a(106, 215, 1, false);
                        C7060h.pYm.mo8381e(12084, Integer.valueOf(uf.frO), Integer.valueOf(uf.fXd * 1000), Integer.valueOf(0), Integer.valueOf(2), uf.getUser(), Integer.valueOf(i), C26493s.m42234ue(uf.alw()), Long.valueOf(uf.createTime));
                    }
                    uu = C26494u.m42269uu(uh);
                    if (C5046bo.isNullOrNil(uu)) {
                        Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.f1c), 1).show();
                    } else {
                        Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.f1d, new Object[]{uu}), 1).show();
                        C14987n.m23300a(uu, this.cgL.yTx.getContext());
                    }
                } else {
                    m81925eC(uf.getFileName(), 6);
                    intent = new Intent(this.cgL.yTx.getContext(), ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", c7620bi.field_msgId);
                    intent.putExtra("img_gallery_msg_svr_id", c7620bi.field_msgSvrId);
                    intent.putExtra("img_gallery_talker", c7620bi.field_talker);
                    intent.putExtra("img_gallery_chatroom_name", c7620bi.field_talker);
                    intent.putExtra("img_gallery_enter_video_opcode", C26494u.m42249e(c7620bi.field_msgId, 2));
                    C40729i.m70425a(this.cgL, c7620bi, intent);
                    this.cgL.yTx.startActivity(intent);
                    this.cgL.yTx.overridePendingTransition(0, 0);
                }
                AppMethodBeat.m2505o(31853);
                return true;
            case 107:
                C9638aw.m17190ZK();
                if (!C18628c.isSDCardAvailable()) {
                    C23639t.m36492hO(this.cgL.yTx.getContext());
                    break;
                }
                C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
                if (ut == null) {
                    C4990ab.m7412e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
                    break;
                }
                uu = ut.alv();
                if (!C5730e.m8628ct(uu)) {
                    C37961o.all();
                    uu = C9720t.m17303uh(c7620bi.field_imgPath);
                }
                if (!c7620bi.dtH()) {
                    if (!C40729i.m70428e(c7620bi, uu)) {
                        if (!c7620bi.bws() && !c7620bi.bwt()) {
                            C4990ab.m7420w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
                            break;
                        }
                        intent = new Intent(this.cgL.yTx.getContext(), MsgRetransmitUI.class);
                        intent.putExtra("Retr_length", ut.fXd);
                        intent.putExtra("Retr_File_Name", c7620bi.field_imgPath);
                        intent.putExtra("Retr_video_isexport", ut.fXh);
                        intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                        intent.putExtra("Retr_From", "chattingui");
                        C4990ab.m7410d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + c7620bi.getType());
                        if (c7620bi.bwt()) {
                            intent.putExtra("Retr_Msg_Type", 11);
                        } else {
                            intent.putExtra("Retr_Msg_Type", 1);
                        }
                        this.cgL.yTx.startActivity(intent);
                        break;
                    }
                    C4990ab.m7416i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
                    m81925eC(ut.getFileName(), 3);
                    intent = new Intent(this.cgL.yTx.getContext(), ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", c7620bi.field_msgId);
                    intent.putExtra("img_gallery_msg_svr_id", c7620bi.field_msgSvrId);
                    intent.putExtra("img_gallery_talker", c7620bi.field_talker);
                    intent.putExtra("img_gallery_chatroom_name", c7620bi.field_talker);
                    intent.putExtra("img_gallery_enter_video_opcode", C26494u.m42249e(c7620bi.field_msgId, 1));
                    C40729i.m70425a(this.cgL, c7620bi, intent);
                    this.cgL.yTx.startActivity(intent);
                    this.cgL.yTx.overridePendingTransition(0, 0);
                    if (!ut.aly()) {
                        C4990ab.m7416i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
                        C26494u.m42264up(c7620bi.field_imgPath);
                        break;
                    }
                    C4990ab.m7416i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
                    C26494u.m42259uA(c7620bi.field_imgPath);
                    break;
                }
                C4990ab.m7416i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
                C30379h.m48438a(this.cgL.yTx.getContext(), this.cgL.yTx.getContext().getString(C25738R.string.f0y), this.cgL.yTx.getContext().getString(C25738R.string.f9238tz), new C448072());
                break;
                break;
            case 130:
                Intent intent2 = menuItem.getIntent();
                int i2 = 0;
                i = 0;
                int[] iArr = new int[2];
                if (intent2 == null) {
                    C4990ab.m7412e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
                } else {
                    i2 = intent2.getIntExtra("img_gallery_width", 0);
                    i = intent2.getIntExtra("img_gallery_height", 0);
                    iArr[0] = intent2.getIntExtra("img_gallery_left", 0);
                    iArr[1] = intent2.getIntExtra("img_gallery_top", 0);
                }
                intent2 = new Intent(this.cgL.yTx.getContext(), ImageGalleryUI.class);
                intent2.putExtra("img_gallery_msg_id", c7620bi.field_msgId);
                intent2.putExtra("img_gallery_msg_svr_id", c7620bi.field_msgSvrId);
                intent2.putExtra("img_gallery_talker", c7620bi.field_talker);
                intent2.putExtra("img_gallery_chatroom_name", c7620bi.field_talker);
                intent2.putExtra("img_gallery_left", iArr[0]);
                intent2.putExtra("img_gallery_top", iArr[1]);
                intent2.putExtra("img_gallery_width", i2);
                intent2.putExtra("img_gallery_height", i);
                intent2.putExtra("img_gallery_enter_video_opcode", C26494u.m42249e(c7620bi.field_msgId, 3));
                C40729i.m70425a(this.cgL, c7620bi, intent2);
                this.cgL.yTx.startActivity(intent2);
                this.cgL.yTx.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(31853);
                return true;
        }
        AppMethodBeat.m2505o(31853);
        return false;
    }

    /* renamed from: e */
    public final boolean mo72008e(C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(31854);
        if (c7620bi.bws()) {
            C37961o.all();
            if (!C5730e.m8628ct(C9720t.m17303uh(c7620bi.field_imgPath))) {
                z = false;
            }
        } else if (c7620bi.bwt()) {
            C37961o.all();
            if (!C5730e.m8628ct(C9720t.m17303uh(c7620bi.field_imgPath))) {
                z = false;
            }
        }
        AppMethodBeat.m2505o(31854);
        return z;
    }

    /* renamed from: aW */
    public final void mo72006aW(Intent intent) {
        AppMethodBeat.m2504i(31855);
        if (intent == null) {
            AppMethodBeat.m2505o(31855);
            return;
        }
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            C4990ab.m7412e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
            AppMethodBeat.m2505o(31855);
        } else if (C32856ab.m53750ch(this.cgL.yTx.getContext())) {
            m81924ap(stringArrayListExtra);
            AppMethodBeat.m2505o(31855);
        } else {
            m81924ap(stringArrayListExtra);
            AppMethodBeat.m2505o(31855);
        }
    }

    /* renamed from: ap */
    private void m81924ap(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(31856);
        C4990ab.m7419v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", arrayList.toString());
        final C30076j c30076j = new C30076j(this.cgL.yTx.getContext(), arrayList, null, this.cgL.getTalkerUserName(), 2, new C407183());
        C46650a c46650a = this.cgL;
        Activity context = this.cgL.yTx.getContext();
        this.cgL.yTx.getMMResources().getString(C25738R.string.f9238tz);
        c46650a.mo74862c(context, this.cgL.yTx.getMMResources().getString(C25738R.string.f9260un), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(31848);
                c30076j.dhb();
                AppMethodBeat.m2505o(31848);
            }
        });
        C7305d.post(c30076j, "ChattingUI_importMultiVideo");
        AppMethodBeat.m2505o(31856);
    }

    /* renamed from: ai */
    public final void mo72007ai(final Intent intent) {
        AppMethodBeat.m2504i(31857);
        C4990ab.m7410d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
        if (C32856ab.m53750ch(this.cgL.yTx.getContext())) {
            m81923aj(intent);
            AppMethodBeat.m2505o(31857);
            return;
        }
        C30379h.m48432a(this.cgL.yTx.getContext(), (int) C25738R.string.f17, (int) C25738R.string.f9238tz, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(31849);
                C44806ar.m81921a(C44806ar.this, intent);
                AppMethodBeat.m2505o(31849);
            }
        }, null);
        AppMethodBeat.m2505o(31857);
    }

    /* renamed from: aj */
    private void m81923aj(Intent intent) {
        AppMethodBeat.m2504i(31858);
        final C1878c c1878c = new C1878c();
        c1878c.mo5454a(this.cgL.yTx.getContext(), intent, new C407206());
        C46650a c46650a = this.cgL;
        Activity context = this.cgL.yTx.getContext();
        this.cgL.yTx.getMMResources().getString(C25738R.string.f9238tz);
        c46650a.mo74862c(context, this.cgL.yTx.getMMResources().getString(C25738R.string.f9260un), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                c1878c.fUF = null;
            }
        });
        AppMethodBeat.m2505o(31858);
    }

    /* renamed from: aX */
    private void m81922aX(Intent intent) {
        AppMethodBeat.m2504i(31859);
        C4990ab.m7410d("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.VideoComponent", "data == null");
            AppMethodBeat.m2505o(31859);
            return;
        }
        String stringExtra = intent.getStringExtra("VideoRecorder_ToUser");
        String stringExtra2 = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        C4990ab.m7412e("MicroMsg.ChattingUI.VideoComponent", "fileName " + stringExtra2 + " length " + intExtra + " user " + stringExtra);
        if (C5046bo.isNullOrNil(stringExtra) || C5046bo.isNullOrNil(stringExtra2) || intExtra < 0) {
            AppMethodBeat.m2505o(31859);
        } else if (stringExtra.equals("medianote") && (C1853r.m3822YD() & 16384) == 0) {
            C26493s c26493s = new C26493s();
            c26493s.fileName = stringExtra2;
            c26493s.fXd = intExtra;
            c26493s.cIS = stringExtra;
            c26493s.fWW = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
            c26493s.createTime = C5046bo.anT();
            c26493s.fXb = C5046bo.anT();
            c26493s.fWY = intExtra;
            c26493s.fVG = intExtra;
            C37961o.all();
            int uj = C9720t.m17305uj(C9720t.m17303uh(stringExtra2));
            if (uj <= 0) {
                C4990ab.m7412e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(stringExtra2)));
                AppMethodBeat.m2505o(31859);
                return;
            }
            c26493s.frO = uj;
            C37961o.all();
            stringExtra = C9720t.m17304ui(stringExtra2);
            intExtra = C9720t.m17305uj(stringExtra);
            if (intExtra <= 0) {
                C4990ab.m7412e("MicroMsg.VideoLogic", "get Thumb size failed :" + stringExtra + " size:" + intExtra);
                AppMethodBeat.m2505o(31859);
                return;
            }
            c26493s.fXa = intExtra;
            C4990ab.m7410d("MicroMsg.VideoLogic", "init record file:" + stringExtra2 + " thumbsize:" + c26493s.fXa + " videosize:" + c26493s.frO);
            c26493s.status = 199;
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo14794ju(c26493s.getUser());
            c7620bi.setType(43);
            c7620bi.mo14781hO(1);
            c7620bi.mo14795jv(stringExtra2);
            c7620bi.setStatus(2);
            c7620bi.mo14775eJ(C1829bf.m3756oC(c26493s.getUser()));
            c26493s.fXe = (int) C1829bf.m3752l(c7620bi);
            C37961o.all().mo21059b(c26493s);
            AppMethodBeat.m2505o(31859);
        } else {
            C26494u.m42246c(stringExtra2, intExtra, stringExtra, null);
            C26494u.m42263uo(stringExtra2);
            this.cgL.mo74882qp(true);
            AppMethodBeat.m2505o(31859);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31860);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 208:
                mo72007ai(intent);
                AppMethodBeat.m2505o(31860);
                return;
            case 215:
                mo72007ai(intent);
                AppMethodBeat.m2505o(31860);
                return;
            case 216:
                m81922aX(intent);
                AppMethodBeat.m2505o(31860);
                return;
            case 218:
                if (intent != null) {
                    if (intent.getBooleanExtra("from_record", false)) {
                        m81922aX(intent);
                        AppMethodBeat.m2505o(31860);
                        return;
                    }
                    mo72007ai(intent);
                }
                AppMethodBeat.m2505o(31860);
                return;
            case 226:
                if (intent != null) {
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult != null) {
                        if (sightCaptureResult.osA) {
                            ((C44296aa) this.cgL.mo74857aF(C44296aa.class)).mo70169a(sightCaptureResult);
                            break;
                        }
                        boolean z;
                        C4990ab.m7417i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path ", sightCaptureResult.osC, sightCaptureResult.osD);
                        C37961o.all();
                        String uh = C9720t.m17303uh(sightCaptureResult.osE);
                        if (!sightCaptureResult.osC.equals(uh)) {
                            C4990ab.m7417i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", sightCaptureResult.osC, uh);
                            C5730e.m8623aQ(sightCaptureResult.osC, uh);
                        }
                        String str = sightCaptureResult.osE;
                        int i3 = sightCaptureResult.osG;
                        String talkerUserName = this.cgL.getTalkerUserName();
                        baa baa = sightCaptureResult.osH;
                        C26493s c26493s = new C26493s();
                        c26493s.fileName = str;
                        c26493s.fXd = i3;
                        c26493s.cIS = talkerUserName;
                        c26493s.fWW = (String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "");
                        c26493s.createTime = C5046bo.anT();
                        c26493s.fXb = C5046bo.anT();
                        c26493s.fXn = baa;
                        c26493s.fXh = 0;
                        c26493s.fXk = 1;
                        C37961o.all();
                        i3 = C9720t.m17305uj(C9720t.m17303uh(str));
                        if (i3 <= 0) {
                            C4990ab.m7412e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
                            z = false;
                        } else {
                            c26493s.frO = i3;
                            C37961o.all();
                            uh = C9720t.m17304ui(str);
                            int uj = C9720t.m17305uj(uh);
                            if (uj <= 0) {
                                C4990ab.m7412e("MicroMsg.VideoLogic", "get Thumb size failed :" + uh + " size:" + uj);
                                z = false;
                            } else {
                                c26493s.fXa = uj;
                                C4990ab.m7416i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + c26493s.fXa + " videosize:" + c26493s.frO);
                                c26493s.status = 102;
                                C7620bi c7620bi = new C7620bi();
                                c7620bi.mo14794ju(c26493s.getUser());
                                c7620bi.setType(43);
                                c7620bi.mo14781hO(1);
                                c7620bi.mo14795jv(str);
                                c7620bi.setStatus(1);
                                c7620bi.mo14775eJ(C1829bf.m3756oC(c26493s.getUser()));
                                c26493s.fXe = (int) C1829bf.m3752l(c7620bi);
                                z = C37961o.all().mo21059b(c26493s);
                            }
                        }
                        if (z) {
                            C26494u.m42263uo(sightCaptureResult.osE);
                            AppMethodBeat.m2505o(31860);
                            return;
                        }
                        C4990ab.m7412e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
                        AppMethodBeat.m2505o(31860);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
                    AppMethodBeat.m2505o(31860);
                    return;
                }
                C4990ab.m7420w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
                AppMethodBeat.m2505o(31860);
                return;
        }
        AppMethodBeat.m2505o(31860);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31861);
        C4990ab.m7416i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
        C37961o.all().mo21053a(((C15612h) this.cgL.mo74857aF(C15612h.class)).dCX(), C9638aw.m17180RS().oAl.getLooper());
        AppMethodBeat.m2505o(31861);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31862);
        C4990ab.m7416i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
        C37961o.all().mo21052a(((C15612h) this.cgL.mo74857aF(C15612h.class)).dCX());
        AppMethodBeat.m2505o(31862);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31863);
        C13303b.m21377WY();
        this.yTc.clear();
        AppMethodBeat.m2505o(31863);
    }
}
