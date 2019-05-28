package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;

@a(dFp = ai.class)
public class ar extends a implements ai {
    private long yTb = -1;
    private SparseBooleanArray yTc = new SparseBooleanArray();

    public ar() {
        AppMethodBeat.i(31851);
        AppMethodBeat.o(31851);
    }

    private void eC(final String str, final int i) {
        AppMethodBeat.i(31852);
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31846);
                u.ag(str, i);
                AppMethodBeat.o(31846);
            }
        });
        AppMethodBeat.o(31852);
    }

    public final boolean a(MenuItem menuItem, bi biVar) {
        AppMethodBeat.i(31853);
        int i;
        String uu;
        Intent intent;
        switch (menuItem.getItemId()) {
            case 106:
                s uf = o.all().uf(biVar.field_imgPath);
                if (uf == null) {
                    ab.e("MicroMsg.ChattingUI.VideoComponent", "save video but videoInfo is null!");
                } else if (uf.status == 199) {
                    o.all();
                    String uh = t.uh(biVar.field_imgPath);
                    if (uf != null) {
                        i = 0;
                        if (com.tencent.mm.model.t.kH(uf.getUser())) {
                            i = n.mA(uf.getUser());
                        }
                        h.pYm.a(106, 215, 1, false);
                        h.pYm.e(12084, Integer.valueOf(uf.frO), Integer.valueOf(uf.fXd * 1000), Integer.valueOf(0), Integer.valueOf(2), uf.getUser(), Integer.valueOf(i), s.ue(uf.alw()), Long.valueOf(uf.createTime));
                    }
                    uu = u.uu(uh);
                    if (bo.isNullOrNil(uu)) {
                        Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.f1c), 1).show();
                    } else {
                        Toast.makeText(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.f1d, new Object[]{uu}), 1).show();
                        com.tencent.mm.pluginsdk.ui.tools.n.a(uu, this.cgL.yTx.getContext());
                    }
                } else {
                    eC(uf.getFileName(), 6);
                    intent = new Intent(this.cgL.yTx.getContext(), ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", biVar.field_msgId);
                    intent.putExtra("img_gallery_msg_svr_id", biVar.field_msgSvrId);
                    intent.putExtra("img_gallery_talker", biVar.field_talker);
                    intent.putExtra("img_gallery_chatroom_name", biVar.field_talker);
                    intent.putExtra("img_gallery_enter_video_opcode", u.e(biVar.field_msgId, 2));
                    i.a(this.cgL, biVar, intent);
                    this.cgL.yTx.startActivity(intent);
                    this.cgL.yTx.overridePendingTransition(0, 0);
                }
                AppMethodBeat.o(31853);
                return true;
            case 107:
                aw.ZK();
                if (!c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.t.hO(this.cgL.yTx.getContext());
                    break;
                }
                s ut = u.ut(biVar.field_imgPath);
                if (ut == null) {
                    ab.e("MicroMsg.ChattingUI.VideoComponent", "retransmit video but videoInfo is null!");
                    break;
                }
                uu = ut.alv();
                if (!e.ct(uu)) {
                    o.all();
                    uu = t.uh(biVar.field_imgPath);
                }
                if (!biVar.dtH()) {
                    if (!i.e(biVar, uu)) {
                        if (!biVar.bws() && !biVar.bwt()) {
                            ab.w("MicroMsg.ChattingUI.VideoComponent", "retranmist video unknow status.");
                            break;
                        }
                        intent = new Intent(this.cgL.yTx.getContext(), MsgRetransmitUI.class);
                        intent.putExtra("Retr_length", ut.fXd);
                        intent.putExtra("Retr_File_Name", biVar.field_imgPath);
                        intent.putExtra("Retr_video_isexport", ut.fXh);
                        intent.putExtra("Retr_Msg_Id", biVar.field_msgId);
                        intent.putExtra("Retr_From", "chattingui");
                        ab.d("MicroMsg.ChattingUI.VideoComponent", "dkvideo msg.getType():" + biVar.getType());
                        if (biVar.bwt()) {
                            intent.putExtra("Retr_Msg_Type", 11);
                        } else {
                            intent.putExtra("Retr_Msg_Type", 1);
                        }
                        this.cgL.yTx.startActivity(intent);
                        break;
                    }
                    ab.i("MicroMsg.ChattingUI.VideoComponent", "video is expired");
                    eC(ut.getFileName(), 3);
                    intent = new Intent(this.cgL.yTx.getContext(), ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", biVar.field_msgId);
                    intent.putExtra("img_gallery_msg_svr_id", biVar.field_msgSvrId);
                    intent.putExtra("img_gallery_talker", biVar.field_talker);
                    intent.putExtra("img_gallery_chatroom_name", biVar.field_talker);
                    intent.putExtra("img_gallery_enter_video_opcode", u.e(biVar.field_msgId, 1));
                    i.a(this.cgL, biVar, intent);
                    this.cgL.yTx.startActivity(intent);
                    this.cgL.yTx.overridePendingTransition(0, 0);
                    if (!ut.aly()) {
                        ab.i("MicroMsg.ChattingUI.VideoComponent", "start complete offline video");
                        u.up(biVar.field_imgPath);
                        break;
                    }
                    ab.i("MicroMsg.ChattingUI.VideoComponent", "start complete online video");
                    u.uA(biVar.field_imgPath);
                    break;
                }
                ab.i("MicroMsg.ChattingUI.VideoComponent", "video is clean!!!");
                com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getContext().getString(R.string.f0y), this.cgL.yTx.getContext().getString(R.string.tz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                break;
                break;
            case 130:
                Intent intent2 = menuItem.getIntent();
                int i2 = 0;
                i = 0;
                int[] iArr = new int[2];
                if (intent2 == null) {
                    ab.e("MicroMsg.ChattingUI.VideoComponent", "[LONGCLICK_MENU_MUTE_PLAY] intent is null!");
                } else {
                    i2 = intent2.getIntExtra("img_gallery_width", 0);
                    i = intent2.getIntExtra("img_gallery_height", 0);
                    iArr[0] = intent2.getIntExtra("img_gallery_left", 0);
                    iArr[1] = intent2.getIntExtra("img_gallery_top", 0);
                }
                intent2 = new Intent(this.cgL.yTx.getContext(), ImageGalleryUI.class);
                intent2.putExtra("img_gallery_msg_id", biVar.field_msgId);
                intent2.putExtra("img_gallery_msg_svr_id", biVar.field_msgSvrId);
                intent2.putExtra("img_gallery_talker", biVar.field_talker);
                intent2.putExtra("img_gallery_chatroom_name", biVar.field_talker);
                intent2.putExtra("img_gallery_left", iArr[0]);
                intent2.putExtra("img_gallery_top", iArr[1]);
                intent2.putExtra("img_gallery_width", i2);
                intent2.putExtra("img_gallery_height", i);
                intent2.putExtra("img_gallery_enter_video_opcode", u.e(biVar.field_msgId, 3));
                i.a(this.cgL, biVar, intent2);
                this.cgL.yTx.startActivity(intent2);
                this.cgL.yTx.overridePendingTransition(0, 0);
                AppMethodBeat.o(31853);
                return true;
        }
        AppMethodBeat.o(31853);
        return false;
    }

    public final boolean e(bi biVar, boolean z) {
        AppMethodBeat.i(31854);
        if (biVar.bws()) {
            o.all();
            if (!e.ct(t.uh(biVar.field_imgPath))) {
                z = false;
            }
        } else if (biVar.bwt()) {
            o.all();
            if (!e.ct(t.uh(biVar.field_imgPath))) {
                z = false;
            }
        }
        AppMethodBeat.o(31854);
        return z;
    }

    public final void aW(Intent intent) {
        AppMethodBeat.i(31855);
        if (intent == null) {
            AppMethodBeat.o(31855);
            return;
        }
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
        if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
            ab.e("MicroMsg.ChattingUI.VideoComponent", "send video list is null or nil");
            AppMethodBeat.o(31855);
        } else if (com.tencent.mm.network.ab.ch(this.cgL.yTx.getContext())) {
            ap(stringArrayListExtra);
            AppMethodBeat.o(31855);
        } else {
            ap(stringArrayListExtra);
            AppMethodBeat.o(31855);
        }
    }

    private void ap(ArrayList<String> arrayList) {
        AppMethodBeat.i(31856);
        ab.v("MicroMsg.ChattingUI.VideoComponent", "send video path: %s", arrayList.toString());
        final j jVar = new j(this.cgL.yTx.getContext(), arrayList, null, this.cgL.getTalkerUserName(), 2, new j.a() {
            public final void dhi() {
                AppMethodBeat.i(31847);
                ar.this.cgL.dismissDialog();
                AppMethodBeat.o(31847);
            }
        });
        com.tencent.mm.ui.chatting.d.a aVar = this.cgL;
        Activity context = this.cgL.yTx.getContext();
        this.cgL.yTx.getMMResources().getString(R.string.tz);
        aVar.c(context, this.cgL.yTx.getMMResources().getString(R.string.un), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(31848);
                jVar.dhb();
                AppMethodBeat.o(31848);
            }
        });
        d.post(jVar, "ChattingUI_importMultiVideo");
        AppMethodBeat.o(31856);
    }

    public final void ai(final Intent intent) {
        AppMethodBeat.i(31857);
        ab.d("MicroMsg.ChattingUI.VideoComponent", "sendVideo");
        if (com.tencent.mm.network.ab.ch(this.cgL.yTx.getContext())) {
            aj(intent);
            AppMethodBeat.o(31857);
            return;
        }
        com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), (int) R.string.f17, (int) R.string.tz, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(31849);
                ar.a(ar.this, intent);
                AppMethodBeat.o(31849);
            }
        }, null);
        AppMethodBeat.o(31857);
    }

    private void aj(Intent intent) {
        AppMethodBeat.i(31858);
        final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        cVar.a(this.cgL.yTx.getContext(), intent, new com.tencent.mm.modelvideo.c.a() {
            public final void b(int i, String str, String str2, int i2) {
                AppMethodBeat.i(31850);
                if (i == -50002) {
                    Toast.makeText(ar.this.cgL.yTx.getContext(), ar.this.cgL.yTx.getContext().getString(R.string.f16), 0).show();
                } else if (i < 0) {
                    Toast.makeText(ar.this.cgL.yTx.getContext(), ar.this.cgL.yTx.getContext().getString(R.string.f15), 0).show();
                } else {
                    u.c(str, i2, ar.this.cgL.getTalkerUserName(), str2);
                    u.uo(str);
                }
                ar.this.cgL.dismissDialog();
                AppMethodBeat.o(31850);
            }
        });
        com.tencent.mm.ui.chatting.d.a aVar = this.cgL;
        Activity context = this.cgL.yTx.getContext();
        this.cgL.yTx.getMMResources().getString(R.string.tz);
        aVar.c(context, this.cgL.yTx.getMMResources().getString(R.string.un), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                cVar.fUF = null;
            }
        });
        AppMethodBeat.o(31858);
    }

    private void aX(Intent intent) {
        AppMethodBeat.i(31859);
        ab.d("MicroMsg.ChattingUI.VideoComponent", "sendVideoFromCustomRecord");
        if (intent == null) {
            ab.e("MicroMsg.ChattingUI.VideoComponent", "data == null");
            AppMethodBeat.o(31859);
            return;
        }
        String stringExtra = intent.getStringExtra("VideoRecorder_ToUser");
        String stringExtra2 = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        ab.e("MicroMsg.ChattingUI.VideoComponent", "fileName " + stringExtra2 + " length " + intExtra + " user " + stringExtra);
        if (bo.isNullOrNil(stringExtra) || bo.isNullOrNil(stringExtra2) || intExtra < 0) {
            AppMethodBeat.o(31859);
        } else if (stringExtra.equals("medianote") && (r.YD() & 16384) == 0) {
            s sVar = new s();
            sVar.fileName = stringExtra2;
            sVar.fXd = intExtra;
            sVar.cIS = stringExtra;
            sVar.fWW = (String) g.RP().Ry().get(2, (Object) "");
            sVar.createTime = bo.anT();
            sVar.fXb = bo.anT();
            sVar.fWY = intExtra;
            sVar.fVG = intExtra;
            o.all();
            int uj = t.uj(t.uh(stringExtra2));
            if (uj <= 0) {
                ab.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(stringExtra2)));
                AppMethodBeat.o(31859);
                return;
            }
            sVar.frO = uj;
            o.all();
            stringExtra = t.ui(stringExtra2);
            intExtra = t.uj(stringExtra);
            if (intExtra <= 0) {
                ab.e("MicroMsg.VideoLogic", "get Thumb size failed :" + stringExtra + " size:" + intExtra);
                AppMethodBeat.o(31859);
                return;
            }
            sVar.fXa = intExtra;
            ab.d("MicroMsg.VideoLogic", "init record file:" + stringExtra2 + " thumbsize:" + sVar.fXa + " videosize:" + sVar.frO);
            sVar.status = 199;
            bi biVar = new bi();
            biVar.ju(sVar.getUser());
            biVar.setType(43);
            biVar.hO(1);
            biVar.jv(stringExtra2);
            biVar.setStatus(2);
            biVar.eJ(bf.oC(sVar.getUser()));
            sVar.fXe = (int) bf.l(biVar);
            o.all().b(sVar);
            AppMethodBeat.o(31859);
        } else {
            u.c(stringExtra2, intExtra, stringExtra, null);
            u.uo(stringExtra2);
            this.cgL.qp(true);
            AppMethodBeat.o(31859);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31860);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 208:
                ai(intent);
                AppMethodBeat.o(31860);
                return;
            case 215:
                ai(intent);
                AppMethodBeat.o(31860);
                return;
            case 216:
                aX(intent);
                AppMethodBeat.o(31860);
                return;
            case 218:
                if (intent != null) {
                    if (intent.getBooleanExtra("from_record", false)) {
                        aX(intent);
                        AppMethodBeat.o(31860);
                        return;
                    }
                    ai(intent);
                }
                AppMethodBeat.o(31860);
                return;
            case 226:
                if (intent != null) {
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult != null) {
                        if (sightCaptureResult.osA) {
                            ((aa) this.cgL.aF(aa.class)).a(sightCaptureResult);
                            break;
                        }
                        boolean z;
                        ab.i("MicroMsg.ChattingUI.VideoComponent", "video path %s thumb path ", sightCaptureResult.osC, sightCaptureResult.osD);
                        o.all();
                        String uh = t.uh(sightCaptureResult.osE);
                        if (!sightCaptureResult.osC.equals(uh)) {
                            ab.i("MicroMsg.ChattingUI.VideoComponent", "filepath not videopath and move it %s %s", sightCaptureResult.osC, uh);
                            e.aQ(sightCaptureResult.osC, uh);
                        }
                        String str = sightCaptureResult.osE;
                        int i3 = sightCaptureResult.osG;
                        String talkerUserName = this.cgL.getTalkerUserName();
                        baa baa = sightCaptureResult.osH;
                        s sVar = new s();
                        sVar.fileName = str;
                        sVar.fXd = i3;
                        sVar.cIS = talkerUserName;
                        sVar.fWW = (String) g.RP().Ry().get(2, (Object) "");
                        sVar.createTime = bo.anT();
                        sVar.fXb = bo.anT();
                        sVar.fXn = baa;
                        sVar.fXh = 0;
                        sVar.fXk = 1;
                        o.all();
                        i3 = t.uj(t.uh(str));
                        if (i3 <= 0) {
                            ab.e("MicroMsg.VideoLogic", "get Video size failed :".concat(String.valueOf(str)));
                            z = false;
                        } else {
                            sVar.frO = i3;
                            o.all();
                            uh = t.ui(str);
                            int uj = t.uj(uh);
                            if (uj <= 0) {
                                ab.e("MicroMsg.VideoLogic", "get Thumb size failed :" + uh + " size:" + uj);
                                z = false;
                            } else {
                                sVar.fXa = uj;
                                ab.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str + " thumbsize:" + sVar.fXa + " videosize:" + sVar.frO);
                                sVar.status = 102;
                                bi biVar = new bi();
                                biVar.ju(sVar.getUser());
                                biVar.setType(43);
                                biVar.hO(1);
                                biVar.jv(str);
                                biVar.setStatus(1);
                                biVar.eJ(bf.oC(sVar.getUser()));
                                sVar.fXe = (int) bf.l(biVar);
                                z = o.all().b(sVar);
                            }
                        }
                        if (z) {
                            u.uo(sightCaptureResult.osE);
                            AppMethodBeat.o(31860);
                            return;
                        }
                        ab.e("MicroMsg.ChattingUI.VideoComponent", "prepareMMSightRecord failed");
                        AppMethodBeat.o(31860);
                        return;
                    }
                    ab.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == captureResult");
                    AppMethodBeat.o(31860);
                    return;
                }
                ab.w("MicroMsg.ChattingUI.VideoComponent", "[dealWithRequestCode] REQUEST_SIGHT_CAPTURE! null == data");
                AppMethodBeat.o(31860);
                return;
        }
        AppMethodBeat.o(31860);
    }

    public final void dxA() {
        AppMethodBeat.i(31861);
        ab.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingResume]");
        o.all().a(((com.tencent.mm.ui.chatting.c.b.h) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCX(), aw.RS().oAl.getLooper());
        AppMethodBeat.o(31861);
    }

    public final void dxB() {
        AppMethodBeat.i(31862);
        ab.i("MicroMsg.ChattingUI.VideoComponent", "[onChattingPause]");
        o.all().a(((com.tencent.mm.ui.chatting.c.b.h) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dCX());
        AppMethodBeat.o(31862);
    }

    public final void dxC() {
        AppMethodBeat.i(31863);
        b.WY();
        this.yTc.clear();
        AppMethodBeat.o(31863);
    }
}
