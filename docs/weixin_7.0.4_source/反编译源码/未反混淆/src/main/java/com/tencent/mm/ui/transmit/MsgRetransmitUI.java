package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.i;
import com.tencent.mm.at.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.rf;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public class MsgRetransmitUI extends MMBaseActivity implements f {
    private float cEB;
    public String cJh;
    public long cvx;
    private ProgressDialog ehJ = null;
    private int fDC = 0;
    private g fEW = null;
    private String fFA;
    private float fFz;
    public String fileName;
    private String hcl;
    long jMj;
    private int length;
    private ak mHandler = new ak();
    boolean mgP;
    public int msgType;
    private long startTime = 0;
    private String thumbPath;
    private boolean yFl = false;
    public List<String> zIR;
    private String zIS = null;
    private boolean zIT = true;
    private boolean zIU = false;
    private c zIV;
    private int zIW = 0;
    private int zIX = 0;
    private l zIY = null;
    private boolean zIZ = false;
    private List<String> zJa = null;
    private int zJb = 0;
    private int zJc = 0;
    private boolean zJd = false;
    private boolean zJe = false;
    private int zJf;
    private boolean zJg;
    private boolean zJh = true;
    private boolean zJi = true;
    private int zJj = 0;
    private int zJk;
    private String zJl;
    private String zJm;
    private int zJn;
    private int zJo;
    private boolean zJp = true;
    boolean zJq = false;
    private int zeC = -1;

    static final class b {
        boolean cvi;
        public List<String> zJI;

        private b() {
            this.zJI = null;
            this.cvi = true;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public static final class a extends AsyncTask<Object, Object, String> {
        public String cMn;
        public Context context;
        public String dqJ;
        public int fVl;
        public int fXd;
        public String fileName;
        public Dialog gII;
        private ak mHandler = new ak();
        public String userName;
        public boolean zIU = false;
        public int zIW;
        public boolean zJA;
        public String zJB;
        public boolean zJC = true;
        public boolean zJD = false;
        public boolean zJE = true;
        public cfh zJF = null;
        public b zJG = null;

        public a() {
            AppMethodBeat.i(35087);
            AppMethodBeat.o(35087);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            int i = 1;
            AppMethodBeat.i(35088);
            String str = (String) obj;
            if (this.gII != null) {
                this.gII.dismiss();
                this.gII = null;
            }
            o.all();
            boolean ct = e.ct(t.uh(str));
            o.all();
            String ui = t.ui(str);
            boolean ct2 = e.ct(ui);
            if (this.zJA) {
                if (ct) {
                    e.deleteFile(str);
                }
                if (ct2) {
                    e.deleteFile(ui);
                }
                if (this.context instanceof Activity) {
                    ((Activity) this.context).finish();
                }
                AppMethodBeat.o(35088);
                return;
            }
            int i2;
            int i3;
            int i4;
            ab.d("MicroMsg.MsgRetransmitUI", "dkvideo videoIsExport :" + this.zIW + ", videoMsgType :43 videoType : " + this.fVl);
            u.a(str, this.fXd, this.userName, null, this.zIW, "", 43, this.zJF, this.cMn);
            if (u.uo(str) != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            s ut = u.ut(this.fileName);
            if (ut != null && ut.videoFormat == 2) {
                u.uz(str);
            }
            o.all();
            ui = t.uh(str);
            if (bo.isNullOrNil(this.fileName) || !this.fileName.contains("favorite")) {
                i3 = 3;
            } else {
                i3 = 7;
            }
            if (bo.isNullOrNil(this.fileName) || !this.fileName.contains("sns")) {
                i4 = i3;
            } else {
                i4 = 6;
            }
            n.alj().a("", ui, this.userName, this.dqJ, "", i4, 2);
            h.pYm.e(10424, Integer.valueOf(43), Integer.valueOf(8), this.userName);
            if (this.zJG != null) {
                b bVar = this.zJG;
                ui = this.userName;
                if (i2 == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (bVar.zJI == null || !bVar.zJI.contains(ui)) {
                    i3 = 0;
                } else {
                    bVar.zJI.remove(ui);
                    if (i3 == 0) {
                        bVar.cvi = false;
                    }
                    i3 = bVar.zJI.size() == 0 ? 1 : 0;
                }
                if (i3 == 0) {
                    if (this.context instanceof Activity) {
                        ((Activity) this.context).finish();
                    }
                    AppMethodBeat.o(35088);
                    return;
                } else if (this.zJG.cvi) {
                    i = 0;
                }
            } else {
                i = i2;
            }
            if (this.zJC) {
                Intent intent = new Intent(this.context, ChattingUI.class);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", this.userName);
                this.context.startActivity(intent);
            }
            if (this.zIU && (this.context instanceof Activity)) {
                com.tencent.mm.ui.widget.snackbar.b.i((Activity) this.context, this.context.getString(i == 0 ? R.string.cbn : R.string.e3n));
            }
            this.mHandler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(35086);
                    if (a.this.zJD && (a.this.context instanceof Activity)) {
                        ((Activity) a.this.context).finish();
                    }
                    AppMethodBeat.o(35086);
                }
            }, 1800);
            AppMethodBeat.o(35088);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            int i;
            AppMethodBeat.i(35089);
            String ug = t.ug(r.Yz());
            o.all();
            String ui = t.ui(ug);
            if (this.zJE) {
                e.y(t.uh(this.fileName), t.uh(ug));
                e.y(t.ui(this.fileName), ui);
            } else {
                e.y(this.fileName, t.uh(ug));
                e.y(this.zJB, ui);
            }
            s ut = u.ut(this.fileName);
            if (ut != null) {
                i = ut.status;
            } else {
                i = 0;
            }
            ab.i("MicroMsg.MsgRetransmitUI", "CopyVideoTask ori[%s] status[%d] new[%s]", this.fileName, Integer.valueOf(i), ug);
            ab.d("MicroMsg.MsgRetransmitUI", "newfileSize:%s, oldFileSzie: %s", Long.valueOf(e.asZ(t.uh(ug))), Long.valueOf(e.asZ(t.uh(this.fileName))));
            AppMethodBeat.o(35089);
            return ug;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MsgRetransmitUI() {
        AppMethodBeat.i(35090);
        AppMethodBeat.o(35090);
    }

    static /* synthetic */ void a(MsgRetransmitUI msgRetransmitUI, String str, com.tencent.mm.af.j.b bVar, byte[] bArr, bi biVar) {
        AppMethodBeat.i(35113);
        msgRetransmitUI.a(str, bVar, bArr, biVar);
        AppMethodBeat.o(35113);
    }

    static /* synthetic */ void i(MsgRetransmitUI msgRetransmitUI) {
        AppMethodBeat.i(35119);
        msgRetransmitUI.dKh();
        AppMethodBeat.o(35119);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(35091);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ae.a(getWindow());
        ab.i("MicroMsg.MsgRetransmitUI", "on activity create");
        this.startTime = bo.anT();
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.cJh = getIntent().getStringExtra("Retr_Msg_content");
        this.cvx = getIntent().getLongExtra("Retr_Msg_Id", -1);
        this.fileName = getIntent().getStringExtra("Retr_File_Name");
        this.zJa = getIntent().getStringArrayListExtra("Retr_File_Path_List");
        boolean z = this.zJa != null && this.zJa.size() > 0;
        this.zJd = z;
        this.fDC = getIntent().getIntExtra("Retr_Compress_Type", 0);
        this.zIX = getIntent().getIntExtra("Retr_Scene", 0);
        this.length = getIntent().getIntExtra("Retr_length", 0);
        this.zIW = getIntent().getIntExtra("Retr_video_isexport", 0);
        this.zIS = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.zIT = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
        this.zJh = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
        Intent intent = getIntent();
        String str = "Multi_Retr";
        if (this.zIX == 0) {
            z = true;
        } else {
            z = false;
        }
        this.zJi = intent.getBooleanExtra(str, z);
        if (this.zJi) {
            this.zJh = true;
        }
        this.zIU = getIntent().getBooleanExtra("Retr_show_success_tips", this.zJh);
        this.zJe = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
        this.yFl = getIntent().getBooleanExtra("is_group_chat", false);
        this.zeC = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
        this.zJf = getIntent().getIntExtra("Retr_MsgImgScene", 0);
        this.fFz = getIntent().getFloatExtra("Retr_Longtitude", -1000.0f);
        this.cEB = getIntent().getFloatExtra("Retr_Latitude", -1000.0f);
        this.fFA = getIntent().getStringExtra("Retr_AttachedContent");
        this.zJg = "gallery".equals(getIntent().getStringExtra("Retr_From"));
        this.hcl = getIntent().getStringExtra("reportSessionId");
        this.zJk = getIntent().getIntExtra("Retr_MsgFromScene", 0);
        this.zJl = getIntent().getStringExtra("Retr_MsgFromUserName");
        this.zJm = getIntent().getStringExtra("Retr_MsgTalker");
        this.zJn = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
        this.zJo = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
        aw.Rg().a(110, (f) this);
        if (!d.iW(19)) {
            setContentView(R.layout.hk);
        }
        Intent intent2 = new Intent(this, SelectConversationUI.class);
        intent2.putExtra("scene", 8);
        intent2.putExtra("select_is_ret", true);
        if (this.zJi) {
            intent2.putExtra("mutil_select_is_ret", true);
        }
        switch (this.msgType) {
            case 2:
            case 6:
            case 7:
            case 14:
            case 15:
            case 16:
                intent2.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
                if (this.zJk == 3) {
                    intent2.putExtra("scene_from", 3);
                }
                intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.zeC);
                intent2.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
                intent2.putExtra("Select_Conv_Type", 3);
                break;
            case 13:
                intent2.putExtra("Select_Conv_Type", 11);
                break;
            default:
                intent2.putExtra("Select_Conv_Type", 3);
                break;
        }
        intent2.putExtra("Retr_Msg_Type", this.msgType);
        intent2.putExtra("Retr_Msg_Id", this.cvx);
        intent2.putExtra("Retr_Msg_content", this.cJh);
        intent2.putExtra("image_path", this.fileName);
        startActivityForResult(intent2, 0);
        AppMethodBeat.o(35091);
    }

    public void finish() {
        AppMethodBeat.i(35092);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(35092);
    }

    public void onDestroy() {
        AppMethodBeat.i(35093);
        if (!this.zIZ) {
            aw.Rg().b(110, (f) this);
        }
        super.onDestroy();
        AppMethodBeat.o(35093);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dKf() {
        AppMethodBeat.i(35094);
        String str;
        switch (this.zIX) {
            case 0:
                Object obj;
                switch (this.msgType) {
                    case 0:
                    case 1:
                    case 5:
                    case 8:
                    case 11:
                        if (!dKg()) {
                            finish();
                            obj = null;
                            break;
                        }
                    case 4:
                        if (this.cJh == null || this.cJh.equals("")) {
                            ab.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
                            finish();
                            obj = null;
                            break;
                        }
                    case 7:
                        if (dKg()) {
                            if (this.fileName == null) {
                                ab.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
                                finish();
                                obj = null;
                                break;
                            }
                        }
                        finish();
                        obj = null;
                        break;
                    case 9:
                        if (this.cJh == null || this.cJh.equals("")) {
                            ab.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
                            finish();
                            obj = null;
                            break;
                        }
                    case 2:
                    case 6:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 16:
                        obj = 1;
                        break;
                    case 15:
                        finish();
                        obj = null;
                        break;
                    default:
                        ab.e("MicroMsg.MsgRetransmitUI", "unknown type %s", Integer.valueOf(this.msgType));
                }
                obj = 1;
                if (obj != null) {
                    boolean z = true;
                    String str2;
                    if (this.msgType != 11 && this.msgType != 1) {
                        if (this.msgType == 0) {
                            this.zJj = this.zIR.size();
                        }
                        int size = this.zIR.size();
                        int i = size;
                        for (final String str3 : this.zIR) {
                            boolean z2;
                            i--;
                            boolean z3 = i == 0;
                            switch (this.msgType) {
                                case 0:
                                    aw.RS().Bn();
                                    com.tencent.mm.sdk.g.d.xDH.a(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(35061);
                                            ab.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                                            MsgRetransmitUI.a(MsgRetransmitUI.this, str3);
                                            AppMethodBeat.o(35061);
                                        }
                                    }, "MicroMsg.MsgRetransmitUI");
                                    z2 = z;
                                    break;
                                case 2:
                                case 16:
                                    z2 = asn(str3);
                                    break;
                                case 4:
                                    r.Yz();
                                    aw.Rg().a(new com.tencent.mm.modelmulti.h(str3, this.cJh, com.tencent.mm.model.t.nK(str3)), 0);
                                    z2 = true;
                                    break;
                                case 5:
                                    z2 = cj(str3, false);
                                    break;
                                case 6:
                                    com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bo.anj(this.cJh));
                                    if (me != null) {
                                        a(str3, me, null, null);
                                        z2 = true;
                                        break;
                                    }
                                    ab.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
                                    z2 = false;
                                    break;
                                case 7:
                                    aw.Rg().a(new com.tencent.mm.modelvoice.f(q.f(str3, this.fileName, this.length), 1), 0);
                                    z2 = true;
                                    break;
                                case 8:
                                    aw.Rg().a(new com.tencent.mm.modelmulti.h(str3, this.cJh, ad.aox(com.tencent.mm.storage.bi.a.apC(this.cJh).svN) ? 66 : 42), 0);
                                    z2 = z;
                                    break;
                                case 9:
                                    aw.Rg().a(new com.tencent.mm.modelmulti.h(str3, this.cJh, 48), 0);
                                    z2 = true;
                                    break;
                                case 10:
                                    nt ntVar = new nt();
                                    ntVar.cJY.type = 4;
                                    com.tencent.mm.g.a.nt.a aVar = ntVar.cJY;
                                    aw.ZK();
                                    aVar.cKd = com.tencent.mm.model.c.XO().jf(this.cvx);
                                    ntVar.cJY.toUser = str3;
                                    com.tencent.mm.sdk.b.a.xxA.m(ntVar);
                                    z2 = z;
                                    break;
                                case 12:
                                    k.m(this, str3, z3);
                                    z2 = z;
                                    break;
                                case 13:
                                    k.l(this, str3, z3);
                                    z2 = z;
                                    break;
                                case 14:
                                    qn qnVar = new qn();
                                    qnVar.cMG.cuQ = this.cvx;
                                    qnVar.cMG.cDt = this.cJh;
                                    qnVar.cMG.cDu = str3;
                                    com.tencent.mm.sdk.b.a.xxA.m(qnVar);
                                    break;
                            }
                            z2 = z;
                            if (this.zJe) {
                                k.qo(z3);
                            }
                            z = z2;
                        }
                        str3 = (String) this.zIR.get(0);
                        switch (this.msgType) {
                            case 0:
                            case 2:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 13:
                            case 14:
                            case 16:
                                if (this.msgType == 2 || this.msgType == 16) {
                                    com.tencent.mm.af.j.b me2 = com.tencent.mm.af.j.b.me(bo.anj(this.cJh));
                                    if (me2 != null && me2.type == 5 && !bo.isNullOrNil(me2.url)) {
                                        str2 = "";
                                        try {
                                            str2 = URLEncoder.encode(me2.url, "UTF-8");
                                        } catch (UnsupportedEncodingException e) {
                                            ab.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                                        }
                                        if (z) {
                                            i = 1;
                                        } else {
                                            i = 2;
                                        }
                                        ab.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me2.url, Long.valueOf(this.startTime), Integer.valueOf(this.zJk), Integer.valueOf(1), Integer.valueOf(i));
                                        h.pYm.e(13378, str2, Long.valueOf(this.startTime), Integer.valueOf(this.zJk), Integer.valueOf(1), Integer.valueOf(i));
                                    } else if (!(z || me2 == null || me2.type != 33)) {
                                        com.tencent.mm.g.a.n nVar = new com.tencent.mm.g.a.n();
                                        nVar.csr.scene = this.zJn;
                                        nVar.csr.bQe = this.zJo;
                                        if (2 == this.zJn) {
                                            nVar.csr.cst = this.zJm + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.zJl;
                                        } else {
                                            nVar.csr.cst = this.zJm;
                                        }
                                        if (str3.endsWith("@chatroom")) {
                                            nVar.csr.action = 2;
                                        } else {
                                            nVar.csr.action = 1;
                                        }
                                        nVar.csr.css = me2.fiZ + 1;
                                        nVar.csr.csu = me2.fiO;
                                        nVar.csr.csl = me2.fiP;
                                        nVar.csr.appId = me2.fiQ;
                                        nVar.csr.csv = "";
                                        nVar.csr.csw = bo.anT();
                                        nVar.csr.csx = 2;
                                        com.tencent.mm.sdk.b.a.xxA.m(nVar);
                                    }
                                }
                                if (z) {
                                    if (this.zIU) {
                                        com.tencent.mm.ui.widget.snackbar.b.i(this, getString(R.string.cbn));
                                    }
                                    Intent intent = new Intent();
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.addAll(this.zIR);
                                    intent.putStringArrayListExtra("SendMsgUsernames", arrayList);
                                    setResult(-1, intent);
                                    if (this.zJp) {
                                        this.mHandler.postDelayed(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.i(35067);
                                                MsgRetransmitUI.this.finish();
                                                AppMethodBeat.o(35067);
                                            }
                                        }, 1800);
                                    }
                                    if (this.zIT && !this.zJh) {
                                        intent = new Intent(this, ChattingUI.class);
                                        intent.addFlags(67108864);
                                        intent.putExtra("Chat_User", str3);
                                        startActivity(intent);
                                    }
                                    AppMethodBeat.o(35094);
                                    return;
                                }
                                finish();
                                AppMethodBeat.o(35094);
                                return;
                            case 1:
                            case 11:
                                AppMethodBeat.o(35094);
                                return;
                            default:
                                finish();
                                break;
                        }
                    }
                    List<String> list = this.zIR;
                    ab.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
                    if (11 == this.msgType && u.uv(this.fileName)) {
                        com.tencent.mm.ui.widget.snackbar.b.a((Activity) this, getResources().getString(R.string.e3n), "", null);
                        this.mHandler.postDelayed(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(35082);
                                MsgRetransmitUI.this.finish();
                                AppMethodBeat.o(35082);
                            }
                        }, 1800);
                        AppMethodBeat.o(35094);
                        return;
                    }
                    b bVar = new b();
                    bVar.zJI = new LinkedList();
                    bVar.zJI.addAll(list);
                    s ut = u.ut(this.fileName);
                    for (final String str4 : list) {
                        Integer valueOf;
                        String str5 = "MicroMsg.MsgRetransmitUI";
                        String str6 = "info[%s, %s]";
                        Object[] objArr = new Object[2];
                        if (ut != null) {
                            str3 = ut.getFileName();
                        } else {
                            str3 = "";
                        }
                        objArr[0] = str3;
                        if (ut != null) {
                            valueOf = Integer.valueOf(ut.status);
                        } else {
                            valueOf = "";
                        }
                        objArr[1] = valueOf;
                        ab.i(str5, str6, objArr);
                        if (ut == null || ut.status != 199) {
                            if (ut == null) {
                                ab.w("MicroMsg.MsgRetransmitUI", "checkVideoCdnInfo info is null !!!");
                                obj = null;
                            } else {
                                Map z4 = br.z(ut.alw(), "msg");
                                if (z4 == null) {
                                    ab.w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
                                    obj = null;
                                } else {
                                    str6 = (String) z4.get(".msg.videomsg.$cdnvideourl");
                                    if (bo.isNullOrNil(str6)) {
                                        obj = null;
                                    } else {
                                        str2 = (String) z4.get(".msg.videomsg.$aeskey");
                                        final String str7 = (String) z4.get(".msg.videomsg.$md5");
                                        final String str8 = (String) z4.get(".msg.videomsg.$newmd5");
                                        final int intValue = Integer.valueOf((String) z4.get(".msg.videomsg.$length")).intValue();
                                        final int i2 = bo.getInt((String) z4.get(".msg.videomsg.$playlength"), 0);
                                        final int i3 = bo.getInt((String) z4.get(".msg.videomsg.$cdnthumblength"), 0);
                                        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                                        gVar.egl = new com.tencent.mm.i.g.a() {
                                            public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                                                AppMethodBeat.i(35078);
                                                if (dVar != null) {
                                                    if (dVar.field_exist_whencheck) {
                                                        dVar.field_fileId = str6;
                                                        dVar.field_aesKey = str2;
                                                        dVar.field_thumbimgLength = i3;
                                                        dVar.field_fileLength = intValue;
                                                        dVar.field_toUser = str4;
                                                        dVar.field_filemd5 = str7;
                                                        dVar.field_mp4identifymd5 = str8;
                                                        ab.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", dVar);
                                                        final String ug = t.ug(r.Yz());
                                                        o.all();
                                                        String ui = t.ui(ug);
                                                        o.all();
                                                        e.y(t.ui(MsgRetransmitUI.this.fileName), ui);
                                                        ab.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + str2 + "\" cdnthumbaeskey=\"" + str2 + "\" cdnvideourl=\"" + str6 + "\" ") + "cdnthumburl=\"" + str6 + "\" ") + "length=\"" + intValue + "\" ") + "cdnthumblength=\"" + i3 + "\"/></msg>");
                                                        u.d(ug, i2, str4, ui);
                                                        com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.modelvideo.h(ug, 0, dVar, new com.tencent.mm.modelvideo.h.a() {
                                                            public final void cC(int i, int i2) {
                                                                AppMethodBeat.i(35077);
                                                                s ut = u.ut(ug);
                                                                ut.status = 111;
                                                                ut.bJt = 256;
                                                                o.all().c(ut);
                                                                ab.d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
                                                                AppMethodBeat.o(35077);
                                                            }
                                                        }), 0);
                                                        MsgRetransmitUI.this.finish();
                                                    } else {
                                                        ab.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
                                                        MsgRetransmitUI.i(MsgRetransmitUI.this);
                                                    }
                                                }
                                                AppMethodBeat.o(35078);
                                                return 0;
                                            }

                                            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                                            }

                                            public final byte[] l(String str, byte[] bArr) {
                                                return new byte[0];
                                            }
                                        };
                                        gVar.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.anU(), str4, this.cvx);
                                        gVar.field_fileId = str6;
                                        gVar.field_aesKey = str2;
                                        gVar.field_filemd5 = str7;
                                        gVar.field_fileType = 4;
                                        gVar.field_talker = str4;
                                        gVar.field_priority = com.tencent.mm.i.a.efC;
                                        gVar.field_svr_signature = "";
                                        gVar.field_onlycheckexist = true;
                                        gVar.field_trysafecdn = true;
                                        ab.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", str6, str7, str2, ut.alw());
                                        if (com.tencent.mm.al.f.afx().e(gVar)) {
                                            this.zIU = false;
                                            finish();
                                            obj = 1;
                                        } else {
                                            ab.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
                                            finish();
                                            obj = null;
                                        }
                                    }
                                }
                            }
                            if (obj == null) {
                                dKh();
                            }
                        } else {
                            a(bVar, str4);
                        }
                    }
                    AppMethodBeat.o(35094);
                    return;
                }
                AppMethodBeat.o(35094);
                return;
            case 1:
                str3 = (String) this.zIR.get(0);
                if (dKg()) {
                    switch (this.msgType) {
                        case 0:
                            if (this.zJa != null && this.zJa.size() > 0) {
                                this.zJc = this.zJa.size();
                            }
                            this.fEW = new g() {
                                public final void a(int i, int i2, m mVar) {
                                    AppMethodBeat.i(35062);
                                    if (MsgRetransmitUI.this.zIV == null || i2 == 0) {
                                        AppMethodBeat.o(35062);
                                        return;
                                    }
                                    int i3 = (int) ((((long) i) * 100) / ((long) i2));
                                    MsgRetransmitUI.this.zIV.setMessage(MsgRetransmitUI.this.getString(R.string.d1s, new Object[]{Integer.valueOf(MsgRetransmitUI.this.zJb), Integer.valueOf(MsgRetransmitUI.this.zJc), Integer.valueOf(i3)}));
                                    AppMethodBeat.o(35062);
                                }
                            };
                            this.zIV = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.d1s, new Object[]{Integer.valueOf(1), Integer.valueOf(this.zJc), Integer.valueOf(0)}), getString(R.string.tz), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(35063);
                                    if (MsgRetransmitUI.this.zIV != null) {
                                        MsgRetransmitUI.this.zIV.cancel();
                                    }
                                    AppMethodBeat.o(35063);
                                }
                            });
                            this.zIV.setOnCancelListener(new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(35066);
                                    com.tencent.mm.ui.base.h.a(MsgRetransmitUI.this, (int) R.string.d1m, (int) R.string.tz, (int) R.string.up, (int) R.string.s2, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(35064);
                                            if (MsgRetransmitUI.this.zIY != null) {
                                                aw.Rg().c(MsgRetransmitUI.this.zIY);
                                                int i2 = (int) MsgRetransmitUI.this.zIY.fEX;
                                                com.tencent.mm.at.e ly = com.tencent.mm.at.o.ahl().ly(i2);
                                                if (ly != null) {
                                                    com.tencent.mm.at.g ahl = com.tencent.mm.at.o.ahl();
                                                    com.tencent.mm.at.e ly2 = ahl.ly(i2);
                                                    if (ly2 != null && ly2.fDy == ((long) i2)) {
                                                        e.deleteFile(ahl.q(ly2.fDz, "", ""));
                                                        e.deleteFile(ahl.q(ly2.fDE, "", ""));
                                                        e.deleteFile(ahl.q(ly2.fDB, "", ""));
                                                        e.deleteFile(ahl.q(ly2.fDB, "", "") + "hd");
                                                        ahl.fni.delete("ImgInfo2", "id=?", new String[]{String.valueOf(i2)});
                                                        if (ly2.agQ()) {
                                                            com.tencent.mm.at.e ly3 = ahl.ly(ly2.fDJ);
                                                            if (ly3 != null) {
                                                                e.deleteFile(ahl.q(ly3.fDz, "", ""));
                                                                e.deleteFile(ahl.q(ly3.fDE, "", ""));
                                                                e.deleteFile(ahl.q(ly3.fDB, "", ""));
                                                                e.deleteFile(ahl.q(ly3.fDB, "", "") + "hd");
                                                                ahl.fni.delete("ImgInfo2", "id=?", new String[]{ly3.fDy});
                                                            }
                                                        }
                                                    }
                                                    aw.ZK();
                                                    com.tencent.mm.model.c.XO().jg(ly.fDH);
                                                }
                                            }
                                            Toast.makeText(MsgRetransmitUI.this, R.string.d1n, 1).show();
                                            MsgRetransmitUI.this.finish();
                                            AppMethodBeat.o(35064);
                                        }
                                    }, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(35065);
                                            if (MsgRetransmitUI.this.zIV != null) {
                                                MsgRetransmitUI.this.zIV.show();
                                            }
                                            AppMethodBeat.o(35065);
                                        }
                                    });
                                    AppMethodBeat.o(35066);
                                }
                            });
                            this.zIV.setCanceledOnTouchOutside(false);
                            this.zIV.getButton(-1).setText(R.string.or);
                            a(str3, 6, this.fEW);
                            AppMethodBeat.o(35094);
                            return;
                        case 1:
                        case 11:
                            if (com.tencent.mm.network.ab.ch(this)) {
                                s(getIntent(), str3);
                                AppMethodBeat.o(35094);
                                return;
                            }
                            com.tencent.mm.ui.base.h.a((Context) this, (int) R.string.f17, (int) R.string.tz, (int) R.string.s6, (int) R.string.or, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(35080);
                                    MsgRetransmitUI.a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), str3);
                                    AppMethodBeat.o(35080);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(35081);
                                    MsgRetransmitUI.this.finish();
                                    AppMethodBeat.o(35081);
                                }
                            });
                            AppMethodBeat.o(35094);
                            return;
                        case 5:
                            cj(str3, true);
                            AppMethodBeat.o(35094);
                            return;
                        default:
                            ab.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", Integer.valueOf(this.msgType));
                            AppMethodBeat.o(35094);
                            return;
                    }
                }
                finish();
                AppMethodBeat.o(35094);
                return;
            case 2:
                switch (this.msgType) {
                    case 2:
                    case 16:
                        View inflate;
                        this.zIR.get(0);
                        str3 = getIntent().getExtras().getString(ConstantsAPI.APP_PACKAGE);
                        com.tencent.mm.pluginsdk.model.app.f fVar = new com.tencent.mm.pluginsdk.model.app.f();
                        fVar.field_packageName = str3;
                        am.bYJ().b((com.tencent.mm.sdk.e.c) fVar, DownloadInfoColumns.PACKAGENAME);
                        WXMediaMessage wXMediaMessage = new Req(getIntent().getExtras()).message;
                        c cVar = new c(new com.tencent.mm.ui.transmit.c.a() {
                            public final void dKi() {
                                AppMethodBeat.i(35075);
                                MsgRetransmitUI.this.finish();
                                AppMethodBeat.o(35075);
                            }
                        });
                        Bitmap bQ = wXMediaMessage.thumbData == null ? null : com.tencent.mm.sdk.platformtools.d.bQ(wXMediaMessage.thumbData);
                        TextView textView;
                        switch (wXMediaMessage.mediaObject.type()) {
                            case 1:
                                inflate = View.inflate(this, R.layout.es, null);
                                ((TextView) inflate.findViewById(R.id.qm)).setText(wXMediaMessage.title);
                                break;
                            case 2:
                                inflate = View.inflate(this, R.layout.er, null);
                                ((ImageView) inflate.findViewById(R.id.z4)).setImageBitmap(bQ);
                                ((TextView) inflate.findViewById(R.id.qm)).setText(wXMediaMessage.title);
                                break;
                            case 3:
                                inflate = View.inflate(this, R.layout.eq, null);
                                ((ImageView) inflate.findViewById(R.id.z4)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(R.id.ld);
                                ((TextView) inflate.findViewById(R.id.qm)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            case 4:
                                inflate = View.inflate(this, R.layout.eq, null);
                                ((ImageView) inflate.findViewById(R.id.z4)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(R.id.ld);
                                ((TextView) inflate.findViewById(R.id.qm)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            case 5:
                                inflate = View.inflate(this, R.layout.eq, null);
                                ((ImageView) inflate.findViewById(R.id.z4)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(R.id.ld);
                                ((TextView) inflate.findViewById(R.id.qm)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            case 6:
                                inflate = View.inflate(this, R.layout.eq, null);
                                ((ImageView) inflate.findViewById(R.id.z4)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(R.id.ld);
                                ((TextView) inflate.findViewById(R.id.qm)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            case 7:
                                inflate = View.inflate(this, R.layout.eq, null);
                                ((ImageView) inflate.findViewById(R.id.z4)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(R.id.ld);
                                ((TextView) inflate.findViewById(R.id.qm)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            default:
                                ab.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + wXMediaMessage.mediaObject.type());
                                AppMethodBeat.o(35094);
                                return;
                        }
                        ((TextView) inflate.findViewById(R.id.z5)).setText(com.tencent.mm.pluginsdk.model.app.g.b((Context) this, fVar, null));
                        cVar.gud = com.tencent.mm.ui.base.h.a((Context) this, null, inflate, getString(R.string.tf), getString(R.string.or), new com.tencent.mm.ui.transmit.c.AnonymousClass1(cVar), new com.tencent.mm.ui.transmit.c.AnonymousClass2(cVar));
                        break;
                }
                AppMethodBeat.o(35094);
                return;
            default:
                ab.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", Integer.valueOf(this.zIX));
                finish();
                AppMethodBeat.o(35094);
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(35095);
        super.onActivityResult(i, i2, intent);
        String str;
        if (i2 != -1) {
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bo.anj(this.cJh));
            if (me != null && me.type == 5 && me.url != null) {
                ab.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(this.startTime), Integer.valueOf(this.zJk), Integer.valueOf(1), Integer.valueOf(3));
                str = "";
                try {
                    str = URLEncoder.encode(me.url, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                }
                h.pYm.e(13378, str, Long.valueOf(this.startTime), Integer.valueOf(this.zJk), Integer.valueOf(1), Integer.valueOf(3));
            } else if (me != null && me.type == 33) {
                com.tencent.mm.g.a.n nVar = new com.tencent.mm.g.a.n();
                nVar.csr.bQe = this.zJo;
                nVar.csr.scene = this.zJn;
                if (2 == this.zJn) {
                    nVar.csr.cst = this.zJm + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.zJl;
                } else {
                    nVar.csr.cst = this.zJm;
                }
                nVar.csr.css = me.fiZ + 1;
                nVar.csr.csu = me.fiO;
                nVar.csr.csl = me.fiP;
                nVar.csr.appId = me.fiQ;
                nVar.csr.action = 1;
                nVar.csr.csv = "";
                nVar.csr.csw = bo.anT();
                nVar.csr.csx = 3;
                com.tencent.mm.sdk.b.a.xxA.m(nVar);
            }
            finish();
            AppMethodBeat.o(35095);
        } else if (i != 0) {
            ab.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
            AppMethodBeat.o(35095);
        } else {
            this.zIR = bo.P(intent.getStringExtra("Select_Conv_User").split(","));
            String stringExtra = intent.getStringExtra("custom_send_text");
            this.mgP = intent.getBooleanExtra("key_is_biz_chat", false);
            if (this.mgP) {
                this.jMj = intent.getLongExtra("key_biz_chat_id", -1);
            }
            int intExtra = intent.getIntExtra("Retr_Msg_Type", -1);
            if (intExtra != -1) {
                ab.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", Integer.valueOf(this.msgType), Integer.valueOf(intExtra));
                this.msgType = intExtra;
            }
            ab.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", Integer.valueOf(this.msgType), Integer.valueOf(this.zIX), Integer.valueOf(this.zIR.size()));
            dKf();
            if (!TextUtils.isEmpty(stringExtra)) {
                for (String str2 : this.zIR) {
                    qb qbVar = new qb();
                    qbVar.cMq.cMr = str2;
                    qbVar.cMq.content = stringExtra;
                    qbVar.cMq.type = com.tencent.mm.model.t.nK(str2);
                    qbVar.cMq.flags = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                }
            }
            AppMethodBeat.o(35095);
        }
    }

    private boolean asn(String str) {
        AppMethodBeat.i(35096);
        final com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(bo.anj(this.cJh));
        ab.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", this.cJh, me);
        if (me == null) {
            ab.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
            AppMethodBeat.o(35096);
            return false;
        }
        aw.ZK();
        final bi jf = com.tencent.mm.model.c.XO().jf(this.cvx);
        if (!jf.drC()) {
            byte[] bArr = null;
            if (this.zIS != null) {
                try {
                    bArr = e.e(this.zIS, 0, -1);
                    if (!cf(bArr)) {
                        AppMethodBeat.o(35096);
                        return false;
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                    ab.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
                }
            } else if (!(this.zeC >= 0 || jf.field_imgPath == null || jf.field_imgPath.equals(""))) {
                try {
                    bArr = e.e(com.tencent.mm.at.o.ahl().I(jf.field_imgPath, true), 0, -1);
                    if (!cf(bArr)) {
                        AppMethodBeat.o(35096);
                        return false;
                    }
                } catch (Exception e2) {
                    ab.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e2.getLocalizedMessage());
                }
            }
            final String str2 = str;
            com.tencent.mm.sdk.g.d.xDH.a(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(35079);
                    MsgRetransmitUI.a(MsgRetransmitUI.this, str2, me, bArr, jf);
                    AppMethodBeat.o(35079);
                }
            }, "MicroMsg.MsgRetransmitUI");
        } else if (me.type == 33) {
            com.tencent.mm.ui.chatting.l.b(str, me, ce.e(((HashMap) getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
        } else {
            j.a(this, str, this.cJh, jf.field_isSend, this.yFl);
        }
        AppMethodBeat.o(35096);
        return true;
    }

    private void a(String str, com.tencent.mm.af.j.b bVar, byte[] bArr, bi biVar) {
        AppMethodBeat.i(35097);
        ab.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", str, bVar.csD);
        com.tencent.mm.pluginsdk.model.app.b aiM = com.tencent.mm.pluginsdk.model.app.l.aiM(bVar.csD);
        if (!bo.isNullOrNil(bVar.fgu)) {
            aiM = com.tencent.mm.pluginsdk.model.app.l.d(biVar, bVar.csD);
        }
        String str2 = "";
        if (!(aiM == null || aiM.field_fileFullPath == null || aiM.field_fileFullPath.equals(""))) {
            aw.ZK();
            str2 = com.tencent.mm.pluginsdk.model.app.l.X(com.tencent.mm.model.c.Ye(), bVar.title, bVar.fgp);
            e.y(aiM.field_fileFullPath, str2);
            ab.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", aiM.field_fileFullPath, bVar.title, str2, Boolean.valueOf(aiM.bCR()));
        }
        com.tencent.mm.af.j.b a = com.tencent.mm.af.j.b.a(bVar);
        a.fgr = 3;
        if (biVar != null && bVar.type == 6 && !bo.isNullOrNil(bVar.fgu) && aiM != null && (!e.ct(aiM.field_fileFullPath) || e.asZ(aiM.field_fileFullPath) != aiM.field_totalLen)) {
            a(a, aiM, biVar, str, str2, bArr);
            AppMethodBeat.o(35097);
        } else if (!bo.isNullOrNil(str2) || (bVar.fgs == 0 && bVar.fgo <= 26214400)) {
            com.tencent.mm.pluginsdk.model.app.l.a(a, bVar.appId, bVar.appName, str, str2, bArr, this.hcl);
            if (a.type == 36) {
                int i = str.endsWith("chatroom") ? 1 : 0;
                String encode = URLEncoder.encode(bo.nullAsNil(a.url));
                String encode2 = URLEncoder.encode(bo.nullAsNil(a.title));
                String encode3 = URLEncoder.encode(bo.nullAsNil(a.description));
                str2 = URLEncoder.encode(bo.nullAsNil(a.fiO));
                h.pYm.e(14127, a.appId, a.fiP, str2, encode2, encode3, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), str);
            }
            AppMethodBeat.o(35097);
        } else {
            ab.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", Integer.valueOf(bVar.fgs), Integer.valueOf(bVar.fgo));
            final com.tencent.mm.af.j.b bVar2 = bVar;
            final com.tencent.mm.af.j.b bVar3 = a;
            final String str3 = str;
            final byte[] bArr2 = bArr;
            aw.Rg().a(new z(bVar, null, str, new com.tencent.mm.pluginsdk.model.app.z.a() {
                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                    AppMethodBeat.i(35083);
                    ab.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", str, bo.anv(str2), bo.anv(str3), bo.anv(bVar2.eyr), bo.anv(str4), bo.anv(str5));
                    if (bo.isNullOrNil(str3)) {
                        com.tencent.mm.ui.base.h.b(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(R.string.b30), "", true);
                        MsgRetransmitUI.this.finish();
                        AppMethodBeat.o(35083);
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.l.a(bVar3, bVar2.appId, bVar2.appName, str3, "", bArr2, MsgRetransmitUI.this.hcl, str3);
                    AppMethodBeat.o(35083);
                }
            }), 0);
            AppMethodBeat.o(35097);
        }
    }

    private void a(com.tencent.mm.af.j.b bVar, com.tencent.mm.pluginsdk.model.app.b bVar2, bi biVar, String str, String str2, byte[] bArr) {
        AppMethodBeat.i(35098);
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        final com.tencent.mm.pluginsdk.model.app.b bVar3 = bVar2;
        final String str3 = str2;
        final bi biVar2 = biVar;
        final com.tencent.mm.af.j.b bVar4 = bVar;
        final String str4 = str;
        final byte[] bArr2 = bArr;
        gVar.egl = new com.tencent.mm.i.g.a() {
            public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(35084);
                bVar3.field_fileFullPath = str3;
                if (i == 0 && cVar != null) {
                    bVar3.field_offset = (long) cVar.field_finishedLength;
                    am.aUq().a(bVar3, new String[0]);
                }
                if (i == 0 && dVar != null && dVar.field_retCode == 0) {
                    bVar3.field_status = 199;
                    bVar3.field_offset = bVar3.field_totalLen;
                    am.aUq().a(bVar3, new String[0]);
                    biVar2.setStatus(3);
                    aw.ZK();
                    com.tencent.mm.model.c.XO().a(biVar2.field_msgId, biVar2);
                    com.tencent.mm.pluginsdk.model.app.l.a(bVar4, bVar4.appId, bVar4.appName, str4, str3, bArr2, MsgRetransmitUI.this.hcl);
                }
                AppMethodBeat.o(35084);
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] l(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        gVar.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.anU(), biVar.field_talker, biVar.field_msgId);
        gVar.field_aesKey = bVar.eyr;
        gVar.field_fileType = 19;
        gVar.field_authKey = bVar.fgA;
        gVar.egm = bVar.fgu;
        gVar.field_fullpath = str2;
        if (!com.tencent.mm.al.f.afx().b(gVar, -1)) {
            ab.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
        }
        AppMethodBeat.o(35098);
    }

    private boolean cj(String str, boolean z) {
        AppMethodBeat.i(35099);
        if (this.fileName == null) {
            AppMethodBeat.o(35099);
            return false;
        }
        EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(this.fileName);
        long asZ = Jd == null ? e.asZ(this.fileName) : e.asZ(Jd.dve());
        String dve = Jd == null ? this.fileName : Jd.dve();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        int i;
        if ((com.tencent.mm.sdk.platformtools.d.decodeFile(dve, options) == null || options.outHeight <= com.tencent.mm.m.b.Na()) && options.outWidth <= com.tencent.mm.m.b.Na()) {
            i = 0;
        } else {
            i = true;
        }
        Object[] objArr;
        if (asZ > ((long) com.tencent.mm.m.b.Nb()) || i != 0) {
            String str2 = "MicroMsg.MsgRetransmitUI";
            String str3 = "emoji is over size. md5:%s size:%d";
            objArr = new Object[2];
            objArr[0] = Jd == null ? DownloadInfo.FILENAME : Jd.Aq();
            objArr[1] = Integer.valueOf(this.length);
            ab.i(str2, str3, objArr);
            this.zJp = false;
            this.zIU = false;
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.b9x), "", getString(R.string.cd_), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(35085);
                    MsgRetransmitUI.this.finish();
                    AppMethodBeat.o(35085);
                }
            });
            if (this.zJf == 1) {
                h.pYm.e(13459, Long.valueOf(asZ), Integer.valueOf(1), Jd.Aq(), Integer.valueOf(1));
            }
            AppMethodBeat.o(35099);
            return true;
        }
        if (this.zJf == 1) {
            h hVar = h.pYm;
            objArr = new Object[4];
            objArr[0] = Long.valueOf(asZ);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Jd == null ? "" : Jd.Aq();
            objArr[3] = Integer.valueOf(1);
            hVar.e(13459, objArr);
        }
        if (z) {
            EmojiInfo Jd2;
            if (Jd == null) {
                Jd2 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(getApplicationContext(), new WXMediaMessage(new WXEmojiObject(this.fileName)), ""));
            } else {
                Jd2 = Jd;
            }
            h.pYm.e(13459, Long.valueOf(asZ), Integer.valueOf(0), Jd2.Aq(), Integer.valueOf(2));
            j.b(Jd2, str);
            finish();
            AppMethodBeat.o(35099);
            return true;
        } else if (Jd != null && asZ > ((long) ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(Jd, false))) {
            j.b(Jd, str);
            AppMethodBeat.o(35099);
            return true;
        } else if (((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(this, str, this.fileName)) {
            AppMethodBeat.o(35099);
            return true;
        } else {
            ab.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
            AppMethodBeat.o(35099);
            return false;
        }
    }

    private boolean dKg() {
        AppMethodBeat.i(35100);
        aw.ZK();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            AppMethodBeat.o(35100);
            return true;
        }
        ab.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
        com.tencent.mm.ui.base.t.hO(this);
        AppMethodBeat.o(35100);
        return false;
    }

    private void s(Intent intent, String str) {
        AppMethodBeat.i(35101);
        if (this.zJd) {
            this.zJc = this.zJa.size();
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
            if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                finish();
                AppMethodBeat.o(35101);
                return;
            }
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                it.next();
                if (this.zJq) {
                    break;
                }
                aso(str);
            }
            AppMethodBeat.o(35101);
            return;
        }
        this.zJc = 1;
        aso(str);
        AppMethodBeat.o(35101);
    }

    private void aso(String str) {
        AppMethodBeat.i(35102);
        ab.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
        final com.tencent.mm.pluginsdk.model.j jVar = new com.tencent.mm.pluginsdk.model.j(this, null, getIntent(), str, 1, new com.tencent.mm.pluginsdk.model.j.a() {
            public final void dhi() {
                AppMethodBeat.i(35068);
                if (MsgRetransmitUI.this.ehJ != null) {
                    MsgRetransmitUI.this.ehJ.dismiss();
                    MsgRetransmitUI.this.ehJ = null;
                }
                MsgRetransmitUI.this.finish();
                AppMethodBeat.o(35068);
            }
        });
        com.tencent.mm.sdk.g.d.post(jVar, "ChattingUI_importMultiVideo");
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(35069);
                jVar.dhb();
                MsgRetransmitUI.this.zJq = true;
                MsgRetransmitUI.this.finish();
                AppMethodBeat.o(35069);
            }
        });
        AppMethodBeat.o(35102);
    }

    private void a(String str, int i, g gVar) {
        AppMethodBeat.i(35103);
        String Yz = r.Yz();
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(this.cvx);
        if (jf.field_msgId == this.cvx) {
            String str2 = jf.field_content;
            com.tencent.mm.at.e eVar = null;
            if (jf.field_msgId > 0) {
                eVar = com.tencent.mm.at.o.ahl().fJ(jf.field_msgId);
            }
            if ((eVar == null || eVar.fDy <= 0) && jf.field_msgSvrId > 0) {
                eVar = com.tencent.mm.at.o.ahl().fI(jf.field_msgSvrId);
            }
            if (bo.isNullOrNil(str2) && jf.field_msgSvrId > 0) {
                str2 = eVar.fDK;
            }
            if (eVar == null || ((eVar.offset >= eVar.frO && eVar.frO != 0) || this.zJd)) {
                long j;
                if (eVar != null) {
                    j = eVar.fDy;
                } else {
                    j = -1;
                }
                a(str, i, Yz, str2, gVar, j);
                AppMethodBeat.o(35103);
                return;
            }
            com.tencent.mm.at.e fI = com.tencent.mm.at.o.ahl().fI(jf.field_msgSvrId);
            if (!a(fI, jf, str2, i, str, Yz)) {
                b(fI, jf, str2, i, str, Yz);
            }
            AppMethodBeat.o(35103);
            return;
        }
        a(str, i, Yz, "", gVar, -1);
        AppMethodBeat.o(35103);
    }

    private void b(com.tencent.mm.at.e eVar, bi biVar, String str, int i, String str2, String str3) {
        AppMethodBeat.i(35105);
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = this.fileName;
        int i2 = eVar.fDC;
        long a = com.tencent.mm.at.o.ahl().a(this.fileName, i2, i, pString, pInt, pInt2);
        com.tencent.mm.at.e b = com.tencent.mm.at.o.ahl().b(Long.valueOf(a));
        b.lw(1);
        bi biVar2 = new bi();
        biVar2.setType(com.tencent.mm.model.t.nL(str2));
        biVar2.ju(str2);
        biVar2.hO(1);
        biVar2.setStatus(1);
        biVar2.jv(pString.value);
        biVar2.hZ(pInt.value);
        biVar2.ia(pInt2.value);
        biVar2.eJ(bf.oC(biVar2.field_talker));
        if (com.tencent.mm.aj.f.kq(biVar2.field_talker)) {
            biVar.ix(com.tencent.mm.aj.a.e.aae());
        }
        aw.ZK();
        long Z = com.tencent.mm.model.c.XO().Z(biVar2);
        Assert.assertTrue(Z >= 0);
        ab.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(Z)));
        b.fG((long) ((int) Z));
        com.tencent.mm.at.o.ahl().a(Long.valueOf(a), b);
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(Z), eVar);
        final String str4 = str2;
        final int i3 = i;
        final String str5 = str3;
        final String str6 = str;
        com.tencent.mm.at.o.ahm().a(eVar.fDy, biVar.field_msgId, i2, hashMap, R.drawable.b0p, new com.tencent.mm.at.d.a() {
            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
            }

            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
                Object obj2;
                AppMethodBeat.i(35072);
                if (i3 == 0 && i4 == 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj instanceof HashMap) {
                    HashMap hashMap = (HashMap) obj;
                    if (hashMap != null) {
                        for (Entry entry : hashMap.entrySet()) {
                            Long l = (Long) entry.getKey();
                            com.tencent.mm.at.e eVar = (com.tencent.mm.at.e) entry.getValue();
                            MsgRetransmitUI.this.fileName = com.tencent.mm.at.o.ahl().q(com.tencent.mm.at.f.c(eVar), "", "");
                            if (obj2 != null) {
                                aw.ZK();
                                com.tencent.mm.model.c.XO().jg(l.longValue());
                                MsgRetransmitUI.a(MsgRetransmitUI.this, str4, i3, str5, str6, MsgRetransmitUI.this.fEW, j);
                            }
                        }
                    }
                }
                AppMethodBeat.o(35072);
            }

            public final void a(long j, long j2, int i, int i2, Object obj) {
            }
        });
        AppMethodBeat.o(35105);
    }

    private void a(String str, int i, String str2, String str3, g gVar, long j) {
        AppMethodBeat.i(35106);
        if (bo.isNullOrNil(this.fileName)) {
            if (this.zJd) {
                this.zJb++;
                if (asl((String) this.zJa.get(0))) {
                    if (this.fDC == 1 && !r.g((String) this.zJa.get(0), str, false)) {
                        this.fDC = 0;
                    }
                    ab.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", Integer.valueOf(this.fDC));
                    this.zIY = new l(i, str2, str, (String) this.zJa.get(0), this.fDC, gVar, 0, str3, "", true, R.drawable.b0p);
                    if (this.zIX == 1) {
                        this.zIY.aha();
                    }
                    this.zIZ = true;
                    aw.Rg().a(this.zIY, 0);
                    bv.aaq().c(bv.fnv, null);
                } else {
                    AppMethodBeat.o(35106);
                    return;
                }
            }
            AppMethodBeat.o(35106);
            return;
        }
        this.zJb = 1;
        this.zJc = 1;
        if (asl(this.fileName)) {
            if (this.fDC == 1 && !r.g(this.fileName, str, false)) {
                this.fDC = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            h.pYm.a(106, 96, 1, false);
            this.zIY = new l(i, str2, str, this.fileName, this.fDC, gVar, 0, str3, "", true, R.drawable.b0p, this.zJf, this.fFz, this.cEB, j);
            if (this.zIX == 1) {
                this.zIY.aha();
            }
            aw.Rg().a(this.zIY, 0);
            this.zIZ = true;
            ab.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.fDC));
            bv.aaq().c(bv.fnv, null);
            AppMethodBeat.o(35106);
            return;
        }
        AppMethodBeat.o(35106);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050 A:{Splitter:B:1:0x0016, ExcHandler: all (r0_9 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0050, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:16:0x0051, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:22:0x005d, code skipped:
            r0 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean asl(String str) {
        Closeable closeable;
        Closeable closeable2 = null;
        boolean z = true;
        AppMethodBeat.i(35107);
        ab.i("MicroMsg.MsgRetransmitUI", "isImage called, fn:%s", str);
        try {
            InputStream openRead = e.openRead(str);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(openRead, null, options);
            if (options.outWidth < 0 || options.outHeight < 0) {
                z = false;
            }
            bo.b(openRead);
            AppMethodBeat.o(35107);
            return z;
        } catch (FileNotFoundException e) {
            closeable = closeable2;
        } catch (Throwable th) {
        }
        try {
            ab.w("MicroMsg.MsgRetransmitUI", "fn:%s not found.", str);
            bo.b(closeable);
            AppMethodBeat.o(35107);
            return false;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            closeable2 = closeable;
            bo.b(closeable2);
            AppMethodBeat.o(35107);
            throw th3;
        }
    }

    private static boolean cf(byte[] bArr) {
        AppMethodBeat.i(35108);
        ab.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d]", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]));
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (options.outWidth < 0 || options.outHeight < 0) {
            AppMethodBeat.o(35108);
            return false;
        }
        AppMethodBeat.o(35108);
        return true;
    }

    private void dKh() {
        AppMethodBeat.i(35109);
        com.tencent.mm.sdk.g.d.xDH.a(new Runnable() {
            public final void run() {
                AppMethodBeat.i(35074);
                o.alq().a(MsgRetransmitUI.this.fileName, new com.tencent.mm.modelvideo.t.a() {
                    public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
                        AppMethodBeat.i(35073);
                        s ut = u.ut(aVar.fileName);
                        if (ut != null && ut.status == 199) {
                            b bVar = new b();
                            bVar.zJI = new LinkedList();
                            bVar.zJI.addAll(MsgRetransmitUI.this.zIR);
                            for (String str : MsgRetransmitUI.this.zIR) {
                                ab.i("MicroMsg.MsgRetransmitUI", "copy video after download %s", str);
                                MsgRetransmitUI.a(MsgRetransmitUI.this, bVar, str);
                            }
                        }
                        AppMethodBeat.o(35073);
                    }
                });
                AppMethodBeat.o(35074);
            }
        }, "MicroMsg.MsgRetransmitUI");
        this.zIU = false;
        AppMethodBeat.o(35109);
    }

    private void a(b bVar, String str) {
        int i = 0;
        AppMethodBeat.i(35110);
        ab.c("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
        final a aVar = new a();
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.th), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(35076);
                aVar.zJA = true;
                MsgRetransmitUI.this.finish();
                AppMethodBeat.o(35076);
            }
        });
        aVar.context = this;
        aVar.fileName = this.fileName;
        aVar.gII = this.ehJ;
        aVar.zIW = this.zIW;
        aVar.fXd = this.length;
        aVar.fVl = this.msgType;
        aVar.zJC = false;
        aVar.userName = str;
        aVar.zJD = true;
        aVar.zIU = this.zIU;
        aVar.zJG = bVar;
        s ut = u.ut(this.fileName);
        if (!(ut == null || ut.fXm == null)) {
            ab.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
            aVar.zJF = ut.fXm;
            aVar.dqJ = ut.getUser();
        }
        aVar.execute(new Object[0]);
        bv.aaq().c(bv.fnw, null);
        if (this.cvx == -1) {
            AppMethodBeat.o(35110);
            return;
        }
        aw.ZK();
        bi jf = com.tencent.mm.model.c.XO().jf(this.cvx);
        boolean kH = com.tencent.mm.model.t.kH(str);
        com.tencent.mm.ui.chatting.a.c cVar = kH ? com.tencent.mm.ui.chatting.a.c.Chatroom : com.tencent.mm.ui.chatting.a.c.Chat;
        com.tencent.mm.ui.chatting.a.d dVar = this.zJg ? com.tencent.mm.ui.chatting.a.d.Full : com.tencent.mm.ui.chatting.a.d.Samll;
        if (kH) {
            i = com.tencent.mm.model.n.mA(str);
        }
        com.tencent.mm.ui.chatting.a.a(cVar, dVar, jf, i);
        AppMethodBeat.o(35110);
    }

    @com.tencent.mm.sdk.platformtools.h
    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(35111);
        if (mVar.getType() == 110 && (mVar instanceof l)) {
            String stringExtra;
            l lVar = (l) mVar;
            if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false)) {
                stringExtra = getIntent().getStringExtra("Retr_KSnsId");
                if (com.tencent.mm.model.t.kH(lVar.cMr)) {
                    rf rfVar = new rf();
                    rfVar.cNk.cFc = stringExtra;
                    com.tencent.mm.sdk.b.a.xxA.m(rfVar);
                } else {
                    rg rgVar = new rg();
                    rgVar.cNl.cFc = stringExtra;
                    com.tencent.mm.sdk.b.a.xxA.m(rgVar);
                }
            }
            if (this.zJa == null || this.zJa.size() <= 1) {
                if (this.zIV != null) {
                    this.zIV.dismiss();
                    this.zIV = null;
                }
                this.zJj--;
                if (this.zJj <= 0 || !this.zJi) {
                    this.zIZ = false;
                    aw.Rg().b(110, (f) this);
                    if (this.zIX != 0) {
                        finish();
                        if (this.zIT && !this.zJh) {
                            Intent intent = new Intent(this, ChattingUI.class);
                            intent.addFlags(67108864);
                            intent.putExtra("Chat_User", lVar.cMr);
                            startActivity(intent);
                        }
                    }
                }
                AppMethodBeat.o(35111);
                return;
            }
            this.zJa.remove(0);
            stringExtra = lVar.cMr;
            if (bo.isNullOrNil(stringExtra) && this.zIR != null) {
                stringExtra = (String) this.zIR.get(0);
            }
            a(stringExtra, 3, this.fEW);
            AppMethodBeat.o(35111);
            return;
        }
        AppMethodBeat.o(35111);
    }

    private boolean a(com.tencent.mm.at.e eVar, bi biVar, String str, int i, String str2, String str3) {
        AppMethodBeat.i(35104);
        Map z = br.z(eVar.fDK, "msg");
        if (z == null) {
            ab.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", eVar.fDK);
            AppMethodBeat.o(35104);
            return false;
        }
        int i2;
        String str4;
        final int i3 = eVar.fDC;
        if (i3 != 1) {
            i2 = 2;
            str4 = (String) z.get(".msg.img.$cdnmidimgurl");
        } else {
            i2 = 1;
            str4 = (String) z.get(".msg.img.$cdnbigimgurl");
        }
        ab.d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", Integer.valueOf(i3), str4);
        if (bo.isNullOrNil(str4)) {
            ab.e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
            AppMethodBeat.o(35104);
            return false;
        }
        String str5 = (String) z.get(".msg.img.$aeskey");
        if (bo.isNullOrNil(str5)) {
            ab.e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
            AppMethodBeat.o(35104);
            return false;
        } else if (bo.isNullOrNil(com.tencent.mm.al.c.a("downimg", (long) eVar.fDG, biVar.field_talker, biVar.field_msgId))) {
            ab.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(biVar.field_msgSvrId));
            AppMethodBeat.o(35104);
            return false;
        } else {
            final String str6 = (String) z.get(".msg.img.$md5");
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            final bi biVar2 = biVar;
            final int i4 = i;
            final String str7 = str2;
            final String str8 = str3;
            final String str9 = str;
            final com.tencent.mm.at.e eVar2 = eVar;
            gVar.egl = new com.tencent.mm.i.g.a() {
                public final int a(String str, int i, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                    AppMethodBeat.i(35070);
                    if (dVar != null) {
                        if (dVar.field_exist_whencheck) {
                            ab.i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", dVar);
                            MsgRetransmitUI.a(MsgRetransmitUI.this, dVar, biVar2, i4, str7, str8, str9, str6, i3);
                        } else {
                            ab.i("MicroMsg.MsgRetransmitUI", "not support second !! dealDownLoadImg");
                            MsgRetransmitUI.a(MsgRetransmitUI.this, eVar2, biVar2, str9, i4, str7, str8);
                        }
                    }
                    AppMethodBeat.o(35070);
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            gVar.field_mediaId = com.tencent.mm.al.c.a("checkExist", bo.anU(), str2, biVar.field_msgId);
            gVar.field_fileId = str4;
            gVar.field_aesKey = str5;
            gVar.field_filemd5 = str6;
            gVar.field_fileType = i2;
            gVar.field_talker = str2;
            gVar.field_priority = com.tencent.mm.i.a.efC;
            gVar.field_svr_signature = "";
            gVar.field_onlycheckexist = true;
            gVar.field_trysafecdn = true;
            if (com.tencent.mm.al.f.afx().e(gVar)) {
                AppMethodBeat.o(35104);
                return true;
            }
            ab.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
            AppMethodBeat.o(35104);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(MsgRetransmitUI msgRetransmitUI, com.tencent.mm.i.d dVar, bi biVar, int i, String str, String str2, String str3, String str4, int i2) {
        long a;
        int i3;
        com.tencent.mm.at.e b;
        String a2;
        clk clk;
        final long j;
        AppMethodBeat.i(35115);
        String I = com.tencent.mm.at.o.ahl().I(biVar.field_imgPath, true);
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = "";
        cy biVar2 = new bi();
        biVar2.setType(com.tencent.mm.model.t.nL(str));
        biVar2.ju(str);
        biVar2.hO(1);
        biVar2.setStatus(1);
        biVar2.eJ(bf.oC(biVar2.field_talker));
        biVar2.setContent(str3);
        com.tencent.mm.l.a.a.KG().g(biVar2);
        long Z = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar2);
        Assert.assertTrue(Z >= 0);
        ab.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(Z)));
        if (i2 == 1) {
            a = com.tencent.mm.at.o.ahl().a(null, Z, true, biVar2.field_content, pString, pInt, pInt2);
        } else {
            a = 0;
        }
        long a3 = com.tencent.mm.at.o.ahl().a(null, Z, false, biVar2.field_content, pString, pInt, pInt2);
        Map z = br.z(str3, "msg");
        int i4 = bo.getInt((String) z.get(".msg.img.$length"), dVar.field_thumbimgLength);
        com.tencent.mm.at.e b2 = com.tencent.mm.at.o.ahl().b(Long.valueOf(a3));
        b2.fG((long) ((int) Z));
        if (a3 > 0) {
            ab.i("MicroMsg.MsgRetransmitUI", "deal send img for cdn [%s]", com.tencent.mm.at.o.ahl().b(pString.value, "th_", "", false));
            e.y(I, r7);
            biVar2.jv(pString.value);
            biVar2.hZ(biVar.dJw);
            biVar2.ia(biVar.dJx);
            if (a > 0) {
                b2.lx(1);
                b2.lu((int) a);
                i3 = bo.getInt((String) z.get(".msg.img.$hdlength"), dVar.field_thumbimgLength);
                com.tencent.mm.at.o.ahl().a(Long.valueOf(a3), b2);
                if (i2 != 1) {
                    b = com.tencent.mm.at.o.ahl().b(Long.valueOf(a));
                } else {
                    a = a3;
                    b = b2;
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(Z, (bi) biVar2);
                com.tencent.mm.at.o.ahl().a(Long.valueOf(a), b);
                a2 = com.tencent.mm.al.c.a("upimg", biVar2.field_createTime, biVar2.field_talker, biVar2.field_msgId + "_" + a + "_" + i2);
                clk = new clk();
                clk.vEB = new bts().alV(str2);
                clk.vEC = new bts().alV(str);
                clk.nao = biVar2.getType();
                clk.vEG = biVar2.dqJ;
                clk.vRz = b.fDD;
                clk.xja = new bts().alV(a2);
                clk.wqw = i2;
                dVar.field_filemd5 = str4;
                dVar.field_thumbimgLength = (int) e.asZ(I);
                dVar.field_fileLength = i3;
                j = a3;
                a3 = Z;
                com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.at.m(i, clk, b, dVar, new com.tencent.mm.at.m.a() {
                    public final void a(long j, int i, int i2, int i3) {
                        AppMethodBeat.i(35071);
                        ab.i("MicroMsg.MsgRetransmitUI", "cdntra  NetSceneUploadMsgImgForCdn ret:[%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
                        if (i2 == 0 && i3 == 0) {
                            bi jf = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().jf(a3);
                            jf.setStatus(2);
                            jf.eI(j);
                            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(a3, jf);
                            i.lB((int) j);
                            AppMethodBeat.o(35071);
                            return;
                        }
                        i.lC((int) j);
                        i.lB((int) j);
                        AppMethodBeat.o(35071);
                    }
                }), 0);
                AppMethodBeat.o(35115);
            }
        }
        i3 = i4;
        com.tencent.mm.at.o.ahl().a(Long.valueOf(a3), b2);
        if (i2 != 1) {
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(Z, (bi) biVar2);
        com.tencent.mm.at.o.ahl().a(Long.valueOf(a), b);
        a2 = com.tencent.mm.al.c.a("upimg", biVar2.field_createTime, biVar2.field_talker, biVar2.field_msgId + "_" + a + "_" + i2);
        clk = new clk();
        clk.vEB = new bts().alV(str2);
        clk.vEC = new bts().alV(str);
        clk.nao = biVar2.getType();
        clk.vEG = biVar2.dqJ;
        clk.vRz = b.fDD;
        clk.xja = new bts().alV(a2);
        clk.wqw = i2;
        dVar.field_filemd5 = str4;
        dVar.field_thumbimgLength = (int) e.asZ(I);
        dVar.field_fileLength = i3;
        j = a3;
        a3 = Z;
        com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.at.m(i, clk, b, dVar, /* anonymous class already generated */), 0);
        AppMethodBeat.o(35115);
    }
}
