package com.tencent.p177mm.p612ui.transmit;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.graphics.MMBitmapFactory;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26424ce;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C32845h;
import com.tencent.p177mm.modelvideo.C32845h.C32846a;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C45459n;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C45461f;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1385l.C32722a.C26350a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.p190at.C45161i;
import com.tencent.p177mm.p190at.C6326m;
import com.tencent.p177mm.p190at.C6326m.C6327a;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.p230g.p231a.C18336n;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C18348nt.C18349a;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C26220qn;
import com.tencent.p177mm.p230g.p231a.C26228rf;
import com.tencent.p177mm.p230g.p231a.C9455rg;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C40707a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C23688d;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40706c;
import com.tencent.p177mm.p612ui.chatting.C40788j;
import com.tencent.p177mm.p612ui.chatting.C44312l;
import com.tencent.p177mm.p612ui.chatting.C46660k;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.transmit.C44386c.C159711;
import com.tencent.p177mm.p612ui.transmit.C44386c.C159722;
import com.tencent.p177mm.p612ui.transmit.C44386c.C40895a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.pluginsdk.model.C30076j.C30077a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C44062z;
import com.tencent.p177mm.pluginsdk.model.app.C44062z.C35801a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.protocal.protobuf.clk;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5060h;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI */
public class MsgRetransmitUI extends MMBaseActivity implements C1202f {
    private float cEB;
    public String cJh;
    public long cvx;
    private ProgressDialog ehJ = null;
    private int fDC = 0;
    private C32231g fEW = null;
    private String fFA;
    private float fFz;
    public String fileName;
    private String hcl;
    long jMj;
    private int length;
    private C7306ak mHandler = new C7306ak();
    boolean mgP;
    public int msgType;
    private long startTime = 0;
    private String thumbPath;
    private boolean yFl = false;
    public List<String> zIR;
    private String zIS = null;
    private boolean zIT = true;
    private boolean zIU = false;
    private C5653c zIV;
    private int zIW = 0;
    private int zIX = 0;
    private C9022l zIY = null;
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

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$11 */
    class C1595111 implements Runnable {

        /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$11$1 */
        class C56101 implements C9721a {
            C56101() {
            }

            /* renamed from: a */
            public final void mo11381a(C9718a c9718a) {
                AppMethodBeat.m2504i(35073);
                C26493s ut = C26494u.m42268ut(c9718a.fileName);
                if (ut != null && ut.status == 199) {
                    C36341b c36341b = new C36341b();
                    c36341b.zJI = new LinkedList();
                    c36341b.zJI.addAll(MsgRetransmitUI.this.zIR);
                    for (String str : MsgRetransmitUI.this.zIR) {
                        C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "copy video after download %s", str);
                        MsgRetransmitUI.m59835a(MsgRetransmitUI.this, c36341b, str);
                    }
                }
                AppMethodBeat.m2505o(35073);
            }
        }

        C1595111() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35074);
            C37961o.alq().mo44278a(MsgRetransmitUI.this.fileName, new C56101());
            AppMethodBeat.m2505o(35074);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$21 */
    class C1595221 implements OnClickListener {
        C1595221() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(35085);
            MsgRetransmitUI.this.finish();
            AppMethodBeat.m2505o(35085);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$17 */
    class C2405617 implements OnClickListener {
        C2405617() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(35081);
            MsgRetransmitUI.this.finish();
            AppMethodBeat.m2505o(35081);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$18 */
    class C2405718 implements Runnable {
        C2405718() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35082);
            MsgRetransmitUI.this.finish();
            AppMethodBeat.m2505o(35082);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$2 */
    class C240592 implements C32231g {
        C240592() {
        }

        /* renamed from: a */
        public final void mo8280a(int i, int i2, C1207m c1207m) {
            AppMethodBeat.m2504i(35062);
            if (MsgRetransmitUI.this.zIV == null || i2 == 0) {
                AppMethodBeat.m2505o(35062);
                return;
            }
            int i3 = (int) ((((long) i) * 100) / ((long) i2));
            MsgRetransmitUI.this.zIV.setMessage(MsgRetransmitUI.this.getString(C25738R.string.d1s, new Object[]{Integer.valueOf(MsgRetransmitUI.this.zJb), Integer.valueOf(MsgRetransmitUI.this.zJc), Integer.valueOf(i3)}));
            AppMethodBeat.m2505o(35062);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$3 */
    class C240603 implements OnClickListener {
        C240603() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(35063);
            if (MsgRetransmitUI.this.zIV != null) {
                MsgRetransmitUI.this.zIV.cancel();
            }
            AppMethodBeat.m2505o(35063);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$4 */
    class C240614 implements OnCancelListener {

        /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$4$1 */
        class C159531 implements OnClickListener {
            C159531() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(35064);
                if (MsgRetransmitUI.this.zIY != null) {
                    C9638aw.m17182Rg().mo14547c(MsgRetransmitUI.this.zIY);
                    int i2 = (int) MsgRetransmitUI.this.zIY.fEX;
                    C25822e ly = C32291o.ahl().mo73116ly(i2);
                    if (ly != null) {
                        C45160g ahl = C32291o.ahl();
                        C25822e ly2 = ahl.mo73116ly(i2);
                        if (ly2 != null && ly2.fDy == ((long) i2)) {
                            C5730e.deleteFile(ahl.mo73118q(ly2.fDz, "", ""));
                            C5730e.deleteFile(ahl.mo73118q(ly2.fDE, "", ""));
                            C5730e.deleteFile(ahl.mo73118q(ly2.fDB, "", ""));
                            C5730e.deleteFile(ahl.mo73118q(ly2.fDB, "", "") + "hd");
                            ahl.fni.delete("ImgInfo2", "id=?", new String[]{String.valueOf(i2)});
                            if (ly2.agQ()) {
                                C25822e ly3 = ahl.mo73116ly(ly2.fDJ);
                                if (ly3 != null) {
                                    C5730e.deleteFile(ahl.mo73118q(ly3.fDz, "", ""));
                                    C5730e.deleteFile(ahl.mo73118q(ly3.fDE, "", ""));
                                    C5730e.deleteFile(ahl.mo73118q(ly3.fDB, "", ""));
                                    C5730e.deleteFile(ahl.mo73118q(ly3.fDB, "", "") + "hd");
                                    ahl.fni.delete("ImgInfo2", "id=?", new String[]{ly3.fDy});
                                }
                            }
                        }
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15341jg(ly.fDH);
                    }
                }
                Toast.makeText(MsgRetransmitUI.this, C25738R.string.d1n, 1).show();
                MsgRetransmitUI.this.finish();
                AppMethodBeat.m2505o(35064);
            }
        }

        /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$4$2 */
        class C240622 implements OnClickListener {
            C240622() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(35065);
                if (MsgRetransmitUI.this.zIV != null) {
                    MsgRetransmitUI.this.zIV.show();
                }
                AppMethodBeat.m2505o(35065);
            }
        }

        C240614() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(35066);
            C30379h.m48428a(MsgRetransmitUI.this, (int) C25738R.string.d1m, (int) C25738R.string.f9238tz, (int) C25738R.string.f9262up, (int) C25738R.string.f9183s2, new C159531(), new C240622());
            AppMethodBeat.m2505o(35066);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$b */
    static final class C36341b {
        boolean cvi;
        public List<String> zJI;

        private C36341b() {
            this.zJI = null;
            this.cvi = true;
        }

        /* synthetic */ C36341b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$5 */
    class C363435 implements Runnable {
        C363435() {
        }

        public final void run() {
            AppMethodBeat.m2504i(35067);
            MsgRetransmitUI.this.finish();
            AppMethodBeat.m2505o(35067);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$6 */
    class C363456 implements C30077a {
        C363456() {
        }

        public final void dhi() {
            AppMethodBeat.m2504i(35068);
            if (MsgRetransmitUI.this.ehJ != null) {
                MsgRetransmitUI.this.ehJ.dismiss();
                MsgRetransmitUI.this.ehJ = null;
            }
            MsgRetransmitUI.this.finish();
            AppMethodBeat.m2505o(35068);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$12 */
    class C3634612 implements C40895a {
        C3634612() {
        }

        public final void dKi() {
            AppMethodBeat.m2504i(35075);
            MsgRetransmitUI.this.finish();
            AppMethodBeat.m2505o(35075);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$a */
    public static final class C36349a extends AsyncTask<Object, Object, String> {
        public String cMn;
        public Context context;
        public String dqJ;
        public int fVl;
        public int fXd;
        public String fileName;
        public Dialog gII;
        private C7306ak mHandler = new C7306ak();
        public String userName;
        public boolean zIU = false;
        public int zIW;
        public boolean zJA;
        public String zJB;
        public boolean zJC = true;
        public boolean zJD = false;
        public boolean zJE = true;
        public cfh zJF = null;
        public C36341b zJG = null;

        /* renamed from: com.tencent.mm.ui.transmit.MsgRetransmitUI$a$1 */
        class C363501 implements Runnable {
            C363501() {
            }

            public final void run() {
                AppMethodBeat.m2504i(35086);
                if (C36349a.this.zJD && (C36349a.this.context instanceof Activity)) {
                    ((Activity) C36349a.this.context).finish();
                }
                AppMethodBeat.m2505o(35086);
            }
        }

        public C36349a() {
            AppMethodBeat.m2504i(35087);
            AppMethodBeat.m2505o(35087);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            int i = 1;
            AppMethodBeat.m2504i(35088);
            String str = (String) obj;
            if (this.gII != null) {
                this.gII.dismiss();
                this.gII = null;
            }
            C37961o.all();
            boolean ct = C5730e.m8628ct(C9720t.m17303uh(str));
            C37961o.all();
            String ui = C9720t.m17304ui(str);
            boolean ct2 = C5730e.m8628ct(ui);
            if (this.zJA) {
                if (ct) {
                    C5730e.deleteFile(str);
                }
                if (ct2) {
                    C5730e.deleteFile(ui);
                }
                if (this.context instanceof Activity) {
                    ((Activity) this.context).finish();
                }
                AppMethodBeat.m2505o(35088);
                return;
            }
            int i2;
            int i3;
            int i4;
            C4990ab.m7410d("MicroMsg.MsgRetransmitUI", "dkvideo videoIsExport :" + this.zIW + ", videoMsgType :43 videoType : " + this.fVl);
            C26494u.m42240a(str, this.fXd, this.userName, null, this.zIW, "", 43, this.zJF, this.cMn);
            if (C26494u.m42263uo(str) != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            C26493s ut = C26494u.m42268ut(this.fileName);
            if (ut != null && ut.videoFormat == 2) {
                C26494u.m42274uz(str);
            }
            C37961o.all();
            ui = C9720t.m17303uh(str);
            if (C5046bo.isNullOrNil(this.fileName) || !this.fileName.contains("favorite")) {
                i3 = 3;
            } else {
                i3 = 7;
            }
            if (C5046bo.isNullOrNil(this.fileName) || !this.fileName.contains("sns")) {
                i4 = i3;
            } else {
                i4 = 6;
            }
            C45459n.alj().mo73267a("", ui, this.userName, this.dqJ, "", i4, 2);
            C7060h.pYm.mo8381e(10424, Integer.valueOf(43), Integer.valueOf(8), this.userName);
            if (this.zJG != null) {
                C36341b c36341b = this.zJG;
                ui = this.userName;
                if (i2 == 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (c36341b.zJI == null || !c36341b.zJI.contains(ui)) {
                    i3 = 0;
                } else {
                    c36341b.zJI.remove(ui);
                    if (i3 == 0) {
                        c36341b.cvi = false;
                    }
                    i3 = c36341b.zJI.size() == 0 ? 1 : 0;
                }
                if (i3 == 0) {
                    if (this.context instanceof Activity) {
                        ((Activity) this.context).finish();
                    }
                    AppMethodBeat.m2505o(35088);
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
                C5670b.m8523i((Activity) this.context, this.context.getString(i == 0 ? C25738R.string.cbn : C25738R.string.e3n));
            }
            this.mHandler.postDelayed(new C363501(), 1800);
            AppMethodBeat.m2505o(35088);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            int i;
            AppMethodBeat.m2504i(35089);
            String ug = C9720t.m17302ug(C1853r.m3846Yz());
            C37961o.all();
            String ui = C9720t.m17304ui(ug);
            if (this.zJE) {
                C5730e.m8644y(C9720t.m17303uh(this.fileName), C9720t.m17303uh(ug));
                C5730e.m8644y(C9720t.m17304ui(this.fileName), ui);
            } else {
                C5730e.m8644y(this.fileName, C9720t.m17303uh(ug));
                C5730e.m8644y(this.zJB, ui);
            }
            C26493s ut = C26494u.m42268ut(this.fileName);
            if (ut != null) {
                i = ut.status;
            } else {
                i = 0;
            }
            C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "CopyVideoTask ori[%s] status[%d] new[%s]", this.fileName, Integer.valueOf(i), ug);
            C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "newfileSize:%s, oldFileSzie: %s", Long.valueOf(C5730e.asZ(C9720t.m17303uh(ug))), Long.valueOf(C5730e.asZ(C9720t.m17303uh(this.fileName))));
            AppMethodBeat.m2505o(35089);
            return ug;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MsgRetransmitUI() {
        AppMethodBeat.m2504i(35090);
        AppMethodBeat.m2505o(35090);
    }

    /* renamed from: a */
    static /* synthetic */ void m59838a(MsgRetransmitUI msgRetransmitUI, String str, C8910b c8910b, byte[] bArr, C7620bi c7620bi) {
        AppMethodBeat.m2504i(35113);
        msgRetransmitUI.m59841a(str, c8910b, bArr, c7620bi);
        AppMethodBeat.m2505o(35113);
    }

    /* renamed from: i */
    static /* synthetic */ void m59853i(MsgRetransmitUI msgRetransmitUI) {
        AppMethodBeat.m2504i(35119);
        msgRetransmitUI.dKh();
        AppMethodBeat.m2505o(35119);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(35091);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        C5222ae.m7935a(getWindow());
        C4990ab.m7416i("MicroMsg.MsgRetransmitUI", "on activity create");
        this.startTime = C5046bo.anT();
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
        C9638aw.m17182Rg().mo14539a(110, (C1202f) this);
        if (!C1443d.m3068iW(19)) {
            setContentView(2130968882);
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
        AppMethodBeat.m2505o(35091);
    }

    public void finish() {
        AppMethodBeat.m2504i(35092);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(35092);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(35093);
        if (!this.zIZ) {
            C9638aw.m17182Rg().mo14546b(110, (C1202f) this);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(35093);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dKf() {
        AppMethodBeat.m2504i(35094);
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
                            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
                            finish();
                            obj = null;
                            break;
                        }
                    case 7:
                        if (dKg()) {
                            if (this.fileName == null) {
                                C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
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
                            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
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
                        C4990ab.m7413e("MicroMsg.MsgRetransmitUI", "unknown type %s", Integer.valueOf(this.msgType));
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
                                    C9638aw.m17180RS().mo10299Bn();
                                    C7305d.xDH.mo10140a(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(35061);
                                            C4990ab.m7416i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                                            MsgRetransmitUI.m59836a(MsgRetransmitUI.this, str3);
                                            AppMethodBeat.m2505o(35061);
                                        }
                                    }, "MicroMsg.MsgRetransmitUI");
                                    z2 = z;
                                    break;
                                case 2:
                                case 16:
                                    z2 = asn(str3);
                                    break;
                                case 4:
                                    C1853r.m3846Yz();
                                    C9638aw.m17182Rg().mo14541a(new C26451h(str3, this.cJh, C1855t.m3925nK(str3)), 0);
                                    z2 = true;
                                    break;
                                case 5:
                                    z2 = m59847cj(str3, false);
                                    break;
                                case 6:
                                    C8910b me = C8910b.m16064me(C5046bo.anj(this.cJh));
                                    if (me != null) {
                                        m59841a(str3, me, null, null);
                                        z2 = true;
                                        break;
                                    }
                                    C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
                                    z2 = false;
                                    break;
                                case 7:
                                    C9638aw.m17182Rg().mo14541a(new C45461f(C32850q.m53721f(str3, this.fileName, this.length), 1), 0);
                                    z2 = true;
                                    break;
                                case 8:
                                    C9638aw.m17182Rg().mo14541a(new C26451h(str3, this.cJh, C7616ad.aox(C5135a.apC(this.cJh).svN) ? 66 : 42), 0);
                                    z2 = z;
                                    break;
                                case 9:
                                    C9638aw.m17182Rg().mo14541a(new C26451h(str3, this.cJh, 48), 0);
                                    z2 = true;
                                    break;
                                case 10:
                                    C18348nt c18348nt = new C18348nt();
                                    c18348nt.cJY.type = 4;
                                    C18349a c18349a = c18348nt.cJY;
                                    C9638aw.m17190ZK();
                                    c18349a.cKd = C18628c.m29080XO().mo15340jf(this.cvx);
                                    c18348nt.cJY.toUser = str3;
                                    C4879a.xxA.mo10055m(c18348nt);
                                    z2 = z;
                                    break;
                                case 12:
                                    C46660k.m88365m(this, str3, z3);
                                    z2 = z;
                                    break;
                                case 13:
                                    C46660k.m88364l(this, str3, z3);
                                    z2 = z;
                                    break;
                                case 14:
                                    C26220qn c26220qn = new C26220qn();
                                    c26220qn.cMG.cuQ = this.cvx;
                                    c26220qn.cMG.cDt = this.cJh;
                                    c26220qn.cMG.cDu = str3;
                                    C4879a.xxA.mo10055m(c26220qn);
                                    break;
                            }
                            z2 = z;
                            if (this.zJe) {
                                C46660k.m88366qo(z3);
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
                                    C8910b me2 = C8910b.m16064me(C5046bo.anj(this.cJh));
                                    if (me2 != null && me2.type == 5 && !C5046bo.isNullOrNil(me2.url)) {
                                        str2 = "";
                                        try {
                                            str2 = URLEncoder.encode(me2.url, "UTF-8");
                                        } catch (UnsupportedEncodingException e) {
                                            C4990ab.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                                        }
                                        if (z) {
                                            i = 1;
                                        } else {
                                            i = 2;
                                        }
                                        C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me2.url, Long.valueOf(this.startTime), Integer.valueOf(this.zJk), Integer.valueOf(1), Integer.valueOf(i));
                                        C7060h.pYm.mo8381e(13378, str2, Long.valueOf(this.startTime), Integer.valueOf(this.zJk), Integer.valueOf(1), Integer.valueOf(i));
                                    } else if (!(z || me2 == null || me2.type != 33)) {
                                        C18336n c18336n = new C18336n();
                                        c18336n.csr.scene = this.zJn;
                                        c18336n.csr.bQe = this.zJo;
                                        if (2 == this.zJn) {
                                            c18336n.csr.cst = this.zJm + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.zJl;
                                        } else {
                                            c18336n.csr.cst = this.zJm;
                                        }
                                        if (str3.endsWith("@chatroom")) {
                                            c18336n.csr.action = 2;
                                        } else {
                                            c18336n.csr.action = 1;
                                        }
                                        c18336n.csr.css = me2.fiZ + 1;
                                        c18336n.csr.csu = me2.fiO;
                                        c18336n.csr.csl = me2.fiP;
                                        c18336n.csr.appId = me2.fiQ;
                                        c18336n.csr.csv = "";
                                        c18336n.csr.csw = C5046bo.anT();
                                        c18336n.csr.csx = 2;
                                        C4879a.xxA.mo10055m(c18336n);
                                    }
                                }
                                if (z) {
                                    if (this.zIU) {
                                        C5670b.m8523i(this, getString(C25738R.string.cbn));
                                    }
                                    Intent intent = new Intent();
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.addAll(this.zIR);
                                    intent.putStringArrayListExtra("SendMsgUsernames", arrayList);
                                    setResult(-1, intent);
                                    if (this.zJp) {
                                        this.mHandler.postDelayed(new C363435(), 1800);
                                    }
                                    if (this.zIT && !this.zJh) {
                                        intent = new Intent(this, ChattingUI.class);
                                        intent.addFlags(67108864);
                                        intent.putExtra("Chat_User", str3);
                                        startActivity(intent);
                                    }
                                    AppMethodBeat.m2505o(35094);
                                    return;
                                }
                                finish();
                                AppMethodBeat.m2505o(35094);
                                return;
                            case 1:
                            case 11:
                                AppMethodBeat.m2505o(35094);
                                return;
                            default:
                                finish();
                                break;
                        }
                    }
                    List<String> list = this.zIR;
                    C4990ab.m7416i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
                    if (11 == this.msgType && C26494u.m42270uv(this.fileName)) {
                        C5670b.m8517a((Activity) this, getResources().getString(C25738R.string.e3n), "", null);
                        this.mHandler.postDelayed(new C2405718(), 1800);
                        AppMethodBeat.m2505o(35094);
                        return;
                    }
                    C36341b c36341b = new C36341b();
                    c36341b.zJI = new LinkedList();
                    c36341b.zJI.addAll(list);
                    C26493s ut = C26494u.m42268ut(this.fileName);
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
                        C4990ab.m7417i(str5, str6, objArr);
                        if (ut == null || ut.status != 199) {
                            if (ut == null) {
                                C4990ab.m7420w("MicroMsg.MsgRetransmitUI", "checkVideoCdnInfo info is null !!!");
                                obj = null;
                            } else {
                                Map z4 = C5049br.m7595z(ut.alw(), "msg");
                                if (z4 == null) {
                                    C4990ab.m7420w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
                                    obj = null;
                                } else {
                                    str6 = (String) z4.get(".msg.videomsg.$cdnvideourl");
                                    if (C5046bo.isNullOrNil(str6)) {
                                        obj = null;
                                    } else {
                                        str2 = (String) z4.get(".msg.videomsg.$aeskey");
                                        final String str7 = (String) z4.get(".msg.videomsg.$md5");
                                        final String str8 = (String) z4.get(".msg.videomsg.$newmd5");
                                        final int intValue = Integer.valueOf((String) z4.get(".msg.videomsg.$length")).intValue();
                                        final int i2 = C5046bo.getInt((String) z4.get(".msg.videomsg.$playlength"), 0);
                                        final int i3 = C5046bo.getInt((String) z4.get(".msg.videomsg.$cdnthumblength"), 0);
                                        C42130g c42130g = new C42130g();
                                        c42130g.egl = new C1628a() {
                                            /* renamed from: a */
                                            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                                                AppMethodBeat.m2504i(35078);
                                                if (c9545d != null) {
                                                    if (c9545d.field_exist_whencheck) {
                                                        c9545d.field_fileId = str6;
                                                        c9545d.field_aesKey = str2;
                                                        c9545d.field_thumbimgLength = i3;
                                                        c9545d.field_fileLength = intValue;
                                                        c9545d.field_toUser = str4;
                                                        c9545d.field_filemd5 = str7;
                                                        c9545d.field_mp4identifymd5 = str8;
                                                        C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", c9545d);
                                                        final String ug = C9720t.m17302ug(C1853r.m3846Yz());
                                                        C37961o.all();
                                                        String ui = C9720t.m17304ui(ug);
                                                        C37961o.all();
                                                        C5730e.m8644y(C9720t.m17304ui(MsgRetransmitUI.this.fileName), ui);
                                                        C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + str2 + "\" cdnthumbaeskey=\"" + str2 + "\" cdnvideourl=\"" + str6 + "\" ") + "cdnthumburl=\"" + str6 + "\" ") + "length=\"" + intValue + "\" ") + "cdnthumblength=\"" + i3 + "\"/></msg>");
                                                        C26494u.m42248d(ug, i2, str4, ui);
                                                        C1720g.m3540Rg().mo14541a(new C32845h(ug, 0, c9545d, new C32846a() {
                                                            /* renamed from: cC */
                                                            public final void mo39619cC(int i, int i2) {
                                                                AppMethodBeat.m2504i(35077);
                                                                C26493s ut = C26494u.m42268ut(ug);
                                                                ut.status = 111;
                                                                ut.bJt = 256;
                                                                C37961o.all().mo21060c(ut);
                                                                C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
                                                                AppMethodBeat.m2505o(35077);
                                                            }
                                                        }), 0);
                                                        MsgRetransmitUI.this.finish();
                                                    } else {
                                                        C4990ab.m7416i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
                                                        MsgRetransmitUI.m59853i(MsgRetransmitUI.this);
                                                    }
                                                }
                                                AppMethodBeat.m2505o(35078);
                                                return 0;
                                            }

                                            /* renamed from: a */
                                            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                                            }

                                            /* renamed from: l */
                                            public final byte[] mo5084l(String str, byte[] bArr) {
                                                return new byte[0];
                                            }
                                        };
                                        c42130g.field_mediaId = C37458c.m63162a("checkExist", C5046bo.anU(), str4, this.cvx);
                                        c42130g.field_fileId = str6;
                                        c42130g.field_aesKey = str2;
                                        c42130g.field_filemd5 = str7;
                                        c42130g.field_fileType = 4;
                                        c42130g.field_talker = str4;
                                        c42130g.field_priority = C42129a.efC;
                                        c42130g.field_svr_signature = "";
                                        c42130g.field_onlycheckexist = true;
                                        c42130g.field_trysafecdn = true;
                                        C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", str6, str7, str2, ut.alw());
                                        if (C37461f.afx().mo51225e(c42130g)) {
                                            this.zIU = false;
                                            finish();
                                            obj = 1;
                                        } else {
                                            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
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
                            m59831a(c36341b, str4);
                        }
                    }
                    AppMethodBeat.m2505o(35094);
                    return;
                }
                AppMethodBeat.m2505o(35094);
                return;
            case 1:
                str3 = (String) this.zIR.get(0);
                if (dKg()) {
                    switch (this.msgType) {
                        case 0:
                            if (this.zJa != null && this.zJa.size() > 0) {
                                this.zJc = this.zJa.size();
                            }
                            this.fEW = new C240592();
                            this.zIV = C30379h.m48438a((Context) this, getString(C25738R.string.d1s, new Object[]{Integer.valueOf(1), Integer.valueOf(this.zJc), Integer.valueOf(0)}), getString(C25738R.string.f9238tz), new C240603());
                            this.zIV.setOnCancelListener(new C240614());
                            this.zIV.setCanceledOnTouchOutside(false);
                            this.zIV.getButton(-1).setText(C25738R.string.f9076or);
                            m59839a(str3, 6, this.fEW);
                            AppMethodBeat.m2505o(35094);
                            return;
                        case 1:
                        case 11:
                            if (C32856ab.m53750ch(this)) {
                                m59854s(getIntent(), str3);
                                AppMethodBeat.m2505o(35094);
                                return;
                            }
                            C30379h.m48428a((Context) this, (int) C25738R.string.f17, (int) C25738R.string.f9238tz, (int) C25738R.string.f9187s6, (int) C25738R.string.f9076or, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(35080);
                                    MsgRetransmitUI.m59832a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), str3);
                                    AppMethodBeat.m2505o(35080);
                                }
                            }, new C2405617());
                            AppMethodBeat.m2505o(35094);
                            return;
                        case 5:
                            m59847cj(str3, true);
                            AppMethodBeat.m2505o(35094);
                            return;
                        default:
                            C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", Integer.valueOf(this.msgType));
                            AppMethodBeat.m2505o(35094);
                            return;
                    }
                }
                finish();
                AppMethodBeat.m2505o(35094);
                return;
            case 2:
                switch (this.msgType) {
                    case 2:
                    case 16:
                        View inflate;
                        this.zIR.get(0);
                        str3 = getIntent().getExtras().getString(ConstantsAPI.APP_PACKAGE);
                        C40439f c40439f = new C40439f();
                        c40439f.field_packageName = str3;
                        C14877am.bYJ().mo10102b((C4925c) c40439f, DownloadInfoColumns.PACKAGENAME);
                        WXMediaMessage wXMediaMessage = new Req(getIntent().getExtras()).message;
                        C44386c c44386c = new C44386c(new C3634612());
                        Bitmap bQ = wXMediaMessage.thumbData == null ? null : C5056d.m7652bQ(wXMediaMessage.thumbData);
                        TextView textView;
                        switch (wXMediaMessage.mediaObject.type()) {
                            case 1:
                                inflate = View.inflate(this, 2130968779, null);
                                ((TextView) inflate.findViewById(2131821185)).setText(wXMediaMessage.title);
                                break;
                            case 2:
                                inflate = View.inflate(this, 2130968778, null);
                                ((ImageView) inflate.findViewById(2131821511)).setImageBitmap(bQ);
                                ((TextView) inflate.findViewById(2131821185)).setText(wXMediaMessage.title);
                                break;
                            case 3:
                                inflate = View.inflate(this, 2130968777, null);
                                ((ImageView) inflate.findViewById(2131821511)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(2131820991);
                                ((TextView) inflate.findViewById(2131821185)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            case 4:
                                inflate = View.inflate(this, 2130968777, null);
                                ((ImageView) inflate.findViewById(2131821511)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(2131820991);
                                ((TextView) inflate.findViewById(2131821185)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            case 5:
                                inflate = View.inflate(this, 2130968777, null);
                                ((ImageView) inflate.findViewById(2131821511)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(2131820991);
                                ((TextView) inflate.findViewById(2131821185)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            case 6:
                                inflate = View.inflate(this, 2130968777, null);
                                ((ImageView) inflate.findViewById(2131821511)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(2131820991);
                                ((TextView) inflate.findViewById(2131821185)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            case 7:
                                inflate = View.inflate(this, 2130968777, null);
                                ((ImageView) inflate.findViewById(2131821511)).setImageBitmap(bQ);
                                textView = (TextView) inflate.findViewById(2131820991);
                                ((TextView) inflate.findViewById(2131821185)).setText(wXMediaMessage.title);
                                textView.setText(wXMediaMessage.description);
                                break;
                            default:
                                C4990ab.m7412e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + wXMediaMessage.mediaObject.type());
                                AppMethodBeat.m2505o(35094);
                                return;
                        }
                        ((TextView) inflate.findViewById(2131821512)).setText(C46494g.m87733b((Context) this, c40439f, null));
                        c44386c.gud = C30379h.m48437a((Context) this, null, inflate, getString(C25738R.string.f9221tf), getString(C25738R.string.f9076or), new C159711(c44386c), new C159722(c44386c));
                        break;
                }
                AppMethodBeat.m2505o(35094);
                return;
            default:
                C4990ab.m7413e("MicroMsg.MsgRetransmitUI", "unknown scene %s", Integer.valueOf(this.zIX));
                finish();
                AppMethodBeat.m2505o(35094);
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(35095);
        super.onActivityResult(i, i2, intent);
        String str;
        if (i2 != -1) {
            C8910b me = C8910b.m16064me(C5046bo.anj(this.cJh));
            if (me != null && me.type == 5 && me.url != null) {
                C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(this.startTime), Integer.valueOf(this.zJk), Integer.valueOf(1), Integer.valueOf(3));
                str = "";
                try {
                    str = URLEncoder.encode(me.url, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                }
                C7060h.pYm.mo8381e(13378, str, Long.valueOf(this.startTime), Integer.valueOf(this.zJk), Integer.valueOf(1), Integer.valueOf(3));
            } else if (me != null && me.type == 33) {
                C18336n c18336n = new C18336n();
                c18336n.csr.bQe = this.zJo;
                c18336n.csr.scene = this.zJn;
                if (2 == this.zJn) {
                    c18336n.csr.cst = this.zJm + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.zJl;
                } else {
                    c18336n.csr.cst = this.zJm;
                }
                c18336n.csr.css = me.fiZ + 1;
                c18336n.csr.csu = me.fiO;
                c18336n.csr.csl = me.fiP;
                c18336n.csr.appId = me.fiQ;
                c18336n.csr.action = 1;
                c18336n.csr.csv = "";
                c18336n.csr.csw = C5046bo.anT();
                c18336n.csr.csx = 3;
                C4879a.xxA.mo10055m(c18336n);
            }
            finish();
            AppMethodBeat.m2505o(35095);
        } else if (i != 0) {
            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(35095);
        } else {
            this.zIR = C5046bo.m7508P(intent.getStringExtra("Select_Conv_User").split(","));
            String stringExtra = intent.getStringExtra("custom_send_text");
            this.mgP = intent.getBooleanExtra("key_is_biz_chat", false);
            if (this.mgP) {
                this.jMj = intent.getLongExtra("key_biz_chat_id", -1);
            }
            int intExtra = intent.getIntExtra("Retr_Msg_Type", -1);
            if (intExtra != -1) {
                C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", Integer.valueOf(this.msgType), Integer.valueOf(intExtra));
                this.msgType = intExtra;
            }
            C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", Integer.valueOf(this.msgType), Integer.valueOf(this.zIX), Integer.valueOf(this.zIR.size()));
            dKf();
            if (!TextUtils.isEmpty(stringExtra)) {
                for (String str2 : this.zIR) {
                    C18372qb c18372qb = new C18372qb();
                    c18372qb.cMq.cMr = str2;
                    c18372qb.cMq.content = stringExtra;
                    c18372qb.cMq.type = C1855t.m3925nK(str2);
                    c18372qb.cMq.flags = 0;
                    C4879a.xxA.mo10055m(c18372qb);
                }
            }
            AppMethodBeat.m2505o(35095);
        }
    }

    private boolean asn(String str) {
        AppMethodBeat.m2504i(35096);
        final C8910b me = C8910b.m16064me(C5046bo.anj(this.cJh));
        C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", this.cJh, me);
        if (me == null) {
            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
            AppMethodBeat.m2505o(35096);
            return false;
        }
        C9638aw.m17190ZK();
        final C7620bi jf = C18628c.m29080XO().mo15340jf(this.cvx);
        if (!jf.drC()) {
            byte[] bArr = null;
            if (this.zIS != null) {
                try {
                    bArr = C5730e.m8632e(this.zIS, 0, -1);
                    if (!MsgRetransmitUI.m59846cf(bArr)) {
                        AppMethodBeat.m2505o(35096);
                        return false;
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MsgRetransmitUI", e, "", new Object[0]);
                    C4990ab.m7413e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
                }
            } else if (!(this.zeC >= 0 || jf.field_imgPath == null || jf.field_imgPath.equals(""))) {
                try {
                    bArr = C5730e.m8632e(C32291o.ahl().mo73074I(jf.field_imgPath, true), 0, -1);
                    if (!MsgRetransmitUI.m59846cf(bArr)) {
                        AppMethodBeat.m2505o(35096);
                        return false;
                    }
                } catch (Exception e2) {
                    C4990ab.m7413e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e2.getLocalizedMessage());
                }
            }
            final String str2 = str;
            C7305d.xDH.mo10140a(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(35079);
                    MsgRetransmitUI.m59838a(MsgRetransmitUI.this, str2, me, bArr, jf);
                    AppMethodBeat.m2505o(35079);
                }
            }, "MicroMsg.MsgRetransmitUI");
        } else if (me.type == 33) {
            C44312l.m80096b(str, me, C26424ce.m42081e(((HashMap) getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
        } else {
            C40788j.m70650a(this, str, this.cJh, jf.field_isSend, this.yFl);
        }
        AppMethodBeat.m2505o(35096);
        return true;
    }

    /* renamed from: a */
    private void m59841a(String str, C8910b c8910b, byte[] bArr, C7620bi c7620bi) {
        AppMethodBeat.m2504i(35097);
        C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", str, c8910b.csD);
        C30065b aiM = C4733l.aiM(c8910b.csD);
        if (!C5046bo.isNullOrNil(c8910b.fgu)) {
            aiM = C4733l.m7101d(c7620bi, c8910b.csD);
        }
        String str2 = "";
        if (!(aiM == null || aiM.field_fileFullPath == null || aiM.field_fileFullPath.equals(""))) {
            C9638aw.m17190ZK();
            str2 = C4733l.m7083X(C18628c.m29096Ye(), c8910b.title, c8910b.fgp);
            C5730e.m8644y(aiM.field_fileFullPath, str2);
            C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", aiM.field_fileFullPath, c8910b.title, str2, Boolean.valueOf(aiM.bCR()));
        }
        C8910b a = C8910b.m16060a(c8910b);
        a.fgr = 3;
        if (c7620bi != null && c8910b.type == 6 && !C5046bo.isNullOrNil(c8910b.fgu) && aiM != null && (!C5730e.m8628ct(aiM.field_fileFullPath) || C5730e.asZ(aiM.field_fileFullPath) != aiM.field_totalLen)) {
            m59830a(a, aiM, c7620bi, str, str2, bArr);
            AppMethodBeat.m2505o(35097);
        } else if (!C5046bo.isNullOrNil(str2) || (c8910b.fgs == 0 && c8910b.fgo <= 26214400)) {
            C4733l.m7088a(a, c8910b.appId, c8910b.appName, str, str2, bArr, this.hcl);
            if (a.type == 36) {
                int i = str.endsWith("chatroom") ? 1 : 0;
                String encode = URLEncoder.encode(C5046bo.nullAsNil(a.url));
                String encode2 = URLEncoder.encode(C5046bo.nullAsNil(a.title));
                String encode3 = URLEncoder.encode(C5046bo.nullAsNil(a.description));
                str2 = URLEncoder.encode(C5046bo.nullAsNil(a.fiO));
                C7060h.pYm.mo8381e(14127, a.appId, a.fiP, str2, encode2, encode3, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i), str);
            }
            AppMethodBeat.m2505o(35097);
        } else {
            C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", Integer.valueOf(c8910b.fgs), Integer.valueOf(c8910b.fgo));
            final C8910b c8910b2 = c8910b;
            final C8910b c8910b3 = a;
            final String str3 = str;
            final byte[] bArr2 = bArr;
            C9638aw.m17182Rg().mo14541a(new C44062z(c8910b, null, str, new C35801a() {
                /* renamed from: a */
                public final void mo9874a(String str, String str2, String str3, String str4, String str5, long j) {
                    AppMethodBeat.m2504i(35083);
                    C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", str, C5046bo.anv(str2), C5046bo.anv(str3), C5046bo.anv(c8910b2.eyr), C5046bo.anv(str4), C5046bo.anv(str5));
                    if (C5046bo.isNullOrNil(str3)) {
                        C30379h.m48461b(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(C25738R.string.b30), "", true);
                        MsgRetransmitUI.this.finish();
                        AppMethodBeat.m2505o(35083);
                        return;
                    }
                    C4733l.m7089a(c8910b3, c8910b2.appId, c8910b2.appName, str3, "", bArr2, MsgRetransmitUI.this.hcl, str3);
                    AppMethodBeat.m2505o(35083);
                }
            }), 0);
            AppMethodBeat.m2505o(35097);
        }
    }

    /* renamed from: a */
    private void m59830a(C8910b c8910b, C30065b c30065b, C7620bi c7620bi, String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(35098);
        C42130g c42130g = new C42130g();
        final C30065b c30065b2 = c30065b;
        final String str3 = str2;
        final C7620bi c7620bi2 = c7620bi;
        final C8910b c8910b2 = c8910b;
        final String str4 = str;
        final byte[] bArr2 = bArr;
        c42130g.egl = new C1628a() {
            /* renamed from: a */
            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                AppMethodBeat.m2504i(35084);
                c30065b2.field_fileFullPath = str3;
                if (i == 0 && c18496c != null) {
                    c30065b2.field_offset = (long) c18496c.field_finishedLength;
                    C14877am.aUq().mo48326a(c30065b2, new String[0]);
                }
                if (i == 0 && c9545d != null && c9545d.field_retCode == 0) {
                    c30065b2.field_status = 199;
                    c30065b2.field_offset = c30065b2.field_totalLen;
                    C14877am.aUq().mo48326a(c30065b2, new String[0]);
                    c7620bi2.setStatus(3);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c7620bi2.field_msgId, c7620bi2);
                    C4733l.m7088a(c8910b2, c8910b2.appId, c8910b2.appName, str4, str3, bArr2, MsgRetransmitUI.this.hcl);
                }
                AppMethodBeat.m2505o(35084);
                return 0;
            }

            /* renamed from: a */
            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            /* renamed from: l */
            public final byte[] mo5084l(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        c42130g.field_mediaId = C37458c.m63162a("checkExist", C5046bo.anU(), c7620bi.field_talker, c7620bi.field_msgId);
        c42130g.field_aesKey = c8910b.eyr;
        c42130g.field_fileType = 19;
        c42130g.field_authKey = c8910b.fgA;
        c42130g.egm = c8910b.fgu;
        c42130g.field_fullpath = str2;
        if (!C37461f.afx().mo51222b(c42130g, -1)) {
            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
        }
        AppMethodBeat.m2505o(35098);
    }

    /* renamed from: cj */
    private boolean m59847cj(String str, boolean z) {
        AppMethodBeat.m2504i(35099);
        if (this.fileName == null) {
            AppMethodBeat.m2505o(35099);
            return false;
        }
        EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(this.fileName);
        long asZ = Jd == null ? C5730e.asZ(this.fileName) : C5730e.asZ(Jd.dve());
        String dve = Jd == null ? this.fileName : Jd.dve();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        int i;
        if ((C5056d.decodeFile(dve, options) == null || options.outHeight <= C42164b.m74339Na()) && options.outWidth <= C42164b.m74339Na()) {
            i = 0;
        } else {
            i = true;
        }
        Object[] objArr;
        if (asZ > ((long) C42164b.m74340Nb()) || i != 0) {
            String str2 = "MicroMsg.MsgRetransmitUI";
            String str3 = "emoji is over size. md5:%s size:%d";
            objArr = new Object[2];
            objArr[0] = Jd == null ? DownloadInfo.FILENAME : Jd.mo20410Aq();
            objArr[1] = Integer.valueOf(this.length);
            C4990ab.m7417i(str2, str3, objArr);
            this.zJp = false;
            this.zIU = false;
            C30379h.m48443a((Context) this, getString(C25738R.string.b9x), "", getString(C25738R.string.cd_), new C1595221());
            if (this.zJf == 1) {
                C7060h.pYm.mo8381e(13459, Long.valueOf(asZ), Integer.valueOf(1), Jd.mo20410Aq(), Integer.valueOf(1));
            }
            AppMethodBeat.m2505o(35099);
            return true;
        }
        if (this.zJf == 1) {
            C7060h c7060h = C7060h.pYm;
            objArr = new Object[4];
            objArr[0] = Long.valueOf(asZ);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Jd == null ? "" : Jd.mo20410Aq();
            objArr[3] = Integer.valueOf(1);
            c7060h.mo8381e(13459, objArr);
        }
        if (z) {
            EmojiInfo Jd2;
            if (Jd == null) {
                Jd2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35616a(getApplicationContext(), new WXMediaMessage(new WXEmojiObject(this.fileName)), ""));
            } else {
                Jd2 = Jd;
            }
            C7060h.pYm.mo8381e(13459, Long.valueOf(asZ), Integer.valueOf(0), Jd2.mo20410Aq(), Integer.valueOf(2));
            C40788j.m70669b(Jd2, str);
            finish();
            AppMethodBeat.m2505o(35099);
            return true;
        } else if (Jd != null && asZ > ((long) ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35643d(Jd, false))) {
            C40788j.m70669b(Jd, str);
            AppMethodBeat.m2505o(35099);
            return true;
        } else if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35663r(this, str, this.fileName)) {
            AppMethodBeat.m2505o(35099);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
            AppMethodBeat.m2505o(35099);
            return false;
        }
    }

    private boolean dKg() {
        AppMethodBeat.m2504i(35100);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            AppMethodBeat.m2505o(35100);
            return true;
        }
        C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
        C23639t.m36492hO(this);
        AppMethodBeat.m2505o(35100);
        return false;
    }

    /* renamed from: s */
    private void m59854s(Intent intent, String str) {
        AppMethodBeat.m2504i(35101);
        if (this.zJd) {
            this.zJc = this.zJa.size();
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
            if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                finish();
                AppMethodBeat.m2505o(35101);
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
            AppMethodBeat.m2505o(35101);
            return;
        }
        this.zJc = 1;
        aso(str);
        AppMethodBeat.m2505o(35101);
    }

    private void aso(String str) {
        AppMethodBeat.m2504i(35102);
        C4990ab.m7416i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
        final C30076j c30076j = new C30076j(this, null, getIntent(), str, 1, new C363456());
        C7305d.post(c30076j, "ChattingUI_importMultiVideo");
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(35069);
                c30076j.dhb();
                MsgRetransmitUI.this.zJq = true;
                MsgRetransmitUI.this.finish();
                AppMethodBeat.m2505o(35069);
            }
        });
        AppMethodBeat.m2505o(35102);
    }

    /* renamed from: a */
    private void m59839a(String str, int i, C32231g c32231g) {
        AppMethodBeat.m2504i(35103);
        String Yz = C1853r.m3846Yz();
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(this.cvx);
        if (jf.field_msgId == this.cvx) {
            String str2 = jf.field_content;
            C25822e c25822e = null;
            if (jf.field_msgId > 0) {
                c25822e = C32291o.ahl().mo73113fJ(jf.field_msgId);
            }
            if ((c25822e == null || c25822e.fDy <= 0) && jf.field_msgSvrId > 0) {
                c25822e = C32291o.ahl().mo73112fI(jf.field_msgSvrId);
            }
            if (C5046bo.isNullOrNil(str2) && jf.field_msgSvrId > 0) {
                str2 = c25822e.fDK;
            }
            if (c25822e == null || ((c25822e.offset >= c25822e.frO && c25822e.frO != 0) || this.zJd)) {
                long j;
                if (c25822e != null) {
                    j = c25822e.fDy;
                } else {
                    j = -1;
                }
                m59840a(str, i, Yz, str2, c32231g, j);
                AppMethodBeat.m2505o(35103);
                return;
            }
            C25822e fI = C32291o.ahl().mo73112fI(jf.field_msgSvrId);
            if (!m59842a(fI, jf, str2, i, str, Yz)) {
                m59844b(fI, jf, str2, i, str, Yz);
            }
            AppMethodBeat.m2505o(35103);
            return;
        }
        m59840a(str, i, Yz, "", c32231g, -1);
        AppMethodBeat.m2505o(35103);
    }

    /* renamed from: b */
    private void m59844b(C25822e c25822e, C7620bi c7620bi, String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(35105);
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = this.fileName;
        int i2 = c25822e.fDC;
        long a = C32291o.ahl().mo73079a(this.fileName, i2, i, pString, pInt, pInt2);
        C25822e b = C32291o.ahl().mo73105b(Long.valueOf(a));
        b.mo43800lw(1);
        C7620bi c7620bi2 = new C7620bi();
        c7620bi2.setType(C1855t.m3926nL(str2));
        c7620bi2.mo14794ju(str2);
        c7620bi2.mo14781hO(1);
        c7620bi2.setStatus(1);
        c7620bi2.mo14795jv(pString.value);
        c7620bi2.mo14784hZ(pInt.value);
        c7620bi2.mo14786ia(pInt2.value);
        c7620bi2.mo14775eJ(C1829bf.m3756oC(c7620bi2.field_talker));
        if (C17903f.m28103kq(c7620bi2.field_talker)) {
            c7620bi.mo14791ix(C25754e.aae());
        }
        C9638aw.m17190ZK();
        long Z = C18628c.m29080XO().mo15281Z(c7620bi2);
        Assert.assertTrue(Z >= 0);
        C4990ab.m7416i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(Z)));
        b.mo43793fG((long) ((int) Z));
        C32291o.ahl().mo73077a(Long.valueOf(a), b);
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(Z), c25822e);
        final String str4 = str2;
        final int i3 = i;
        final String str5 = str3;
        final String str6 = str;
        C32291o.ahm().mo33467a(c25822e.fDy, c7620bi.field_msgId, i2, hashMap, C25738R.drawable.b0p, new C9017a() {
            /* renamed from: a */
            public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
            }

            /* renamed from: a */
            public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
                Object obj2;
                AppMethodBeat.m2504i(35072);
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
                            C25822e c25822e = (C25822e) entry.getValue();
                            MsgRetransmitUI.this.fileName = C32291o.ahl().mo73118q(C37478f.m63227c(c25822e), "", "");
                            if (obj2 != null) {
                                C9638aw.m17190ZK();
                                C18628c.m29080XO().mo15341jg(l.longValue());
                                MsgRetransmitUI.m59837a(MsgRetransmitUI.this, str4, i3, str5, str6, MsgRetransmitUI.this.fEW, j);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(35072);
            }

            /* renamed from: a */
            public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
            }
        });
        AppMethodBeat.m2505o(35105);
    }

    /* renamed from: a */
    private void m59840a(String str, int i, String str2, String str3, C32231g c32231g, long j) {
        AppMethodBeat.m2504i(35106);
        if (C5046bo.isNullOrNil(this.fileName)) {
            if (this.zJd) {
                this.zJb++;
                if (MsgRetransmitUI.asl((String) this.zJa.get(0))) {
                    if (this.fDC == 1 && !C1853r.m3854g((String) this.zJa.get(0), str, false)) {
                        this.fDC = 0;
                    }
                    C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", Integer.valueOf(this.fDC));
                    this.zIY = new C9022l(i, str2, str, (String) this.zJa.get(0), this.fDC, c32231g, 0, str3, "", true, C25738R.drawable.b0p);
                    if (this.zIX == 1) {
                        this.zIY.aha();
                    }
                    this.zIZ = true;
                    C9638aw.m17182Rg().mo14541a(this.zIY, 0);
                    C37907bv.aaq().mo60662c(C37907bv.fnv, null);
                } else {
                    AppMethodBeat.m2505o(35106);
                    return;
                }
            }
            AppMethodBeat.m2505o(35106);
            return;
        }
        this.zJb = 1;
        this.zJc = 1;
        if (MsgRetransmitUI.asl(this.fileName)) {
            if (this.fDC == 1 && !C1853r.m3854g(this.fileName, str, false)) {
                this.fDC = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C7060h.pYm.mo8378a(106, 96, 1, false);
            this.zIY = new C9022l(i, str2, str, this.fileName, this.fDC, c32231g, 0, str3, "", true, C25738R.drawable.b0p, this.zJf, this.fFz, this.cEB, j);
            if (this.zIX == 1) {
                this.zIY.aha();
            }
            C9638aw.m17182Rg().mo14541a(this.zIY, 0);
            this.zIZ = true;
            C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.fDC));
            C37907bv.aaq().mo60662c(C37907bv.fnv, null);
            AppMethodBeat.m2505o(35106);
            return;
        }
        AppMethodBeat.m2505o(35106);
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
        AppMethodBeat.m2504i(35107);
        C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "isImage called, fn:%s", str);
        try {
            InputStream openRead = C5730e.openRead(str);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeStream(openRead, null, options);
            if (options.outWidth < 0 || options.outHeight < 0) {
                z = false;
            }
            C5046bo.m7527b(openRead);
            AppMethodBeat.m2505o(35107);
            return z;
        } catch (FileNotFoundException e) {
            closeable = closeable2;
        } catch (Throwable th) {
        }
        try {
            C4990ab.m7421w("MicroMsg.MsgRetransmitUI", "fn:%s not found.", str);
            C5046bo.m7527b(closeable);
            AppMethodBeat.m2505o(35107);
            return false;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            closeable2 = closeable;
            C5046bo.m7527b(closeable2);
            AppMethodBeat.m2505o(35107);
            throw th3;
        }
    }

    /* renamed from: cf */
    private static boolean m59846cf(byte[] bArr) {
        AppMethodBeat.m2504i(35108);
        C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d]", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]));
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (options.outWidth < 0 || options.outHeight < 0) {
            AppMethodBeat.m2505o(35108);
            return false;
        }
        AppMethodBeat.m2505o(35108);
        return true;
    }

    private void dKh() {
        AppMethodBeat.m2504i(35109);
        C7305d.xDH.mo10140a(new C1595111(), "MicroMsg.MsgRetransmitUI");
        this.zIU = false;
        AppMethodBeat.m2505o(35109);
    }

    /* renamed from: a */
    private void m59831a(C36341b c36341b, String str) {
        int i = 0;
        AppMethodBeat.m2504i(35110);
        C4990ab.m7409c("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
        final C36349a c36349a = new C36349a();
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9222th), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(35076);
                c36349a.zJA = true;
                MsgRetransmitUI.this.finish();
                AppMethodBeat.m2505o(35076);
            }
        });
        c36349a.context = this;
        c36349a.fileName = this.fileName;
        c36349a.gII = this.ehJ;
        c36349a.zIW = this.zIW;
        c36349a.fXd = this.length;
        c36349a.fVl = this.msgType;
        c36349a.zJC = false;
        c36349a.userName = str;
        c36349a.zJD = true;
        c36349a.zIU = this.zIU;
        c36349a.zJG = c36341b;
        C26493s ut = C26494u.m42268ut(this.fileName);
        if (!(ut == null || ut.fXm == null)) {
            C4990ab.m7410d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
            c36349a.zJF = ut.fXm;
            c36349a.dqJ = ut.getUser();
        }
        c36349a.execute(new Object[0]);
        C37907bv.aaq().mo60662c(C37907bv.fnw, null);
        if (this.cvx == -1) {
            AppMethodBeat.m2505o(35110);
            return;
        }
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(this.cvx);
        boolean kH = C1855t.m3896kH(str);
        C40706c c40706c = kH ? C40706c.Chatroom : C40706c.Chat;
        C23688d c23688d = this.zJg ? C23688d.Full : C23688d.Samll;
        if (kH) {
            i = C37921n.m64060mA(str);
        }
        C40707a.m70380a(c40706c, c23688d, jf, i);
        AppMethodBeat.m2505o(35110);
    }

    @C5060h
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(35111);
        if (c1207m.getType() == 110 && (c1207m instanceof C9022l)) {
            String stringExtra;
            C9022l c9022l = (C9022l) c1207m;
            if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false)) {
                stringExtra = getIntent().getStringExtra("Retr_KSnsId");
                if (C1855t.m3896kH(c9022l.cMr)) {
                    C26228rf c26228rf = new C26228rf();
                    c26228rf.cNk.cFc = stringExtra;
                    C4879a.xxA.mo10055m(c26228rf);
                } else {
                    C9455rg c9455rg = new C9455rg();
                    c9455rg.cNl.cFc = stringExtra;
                    C4879a.xxA.mo10055m(c9455rg);
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
                    C9638aw.m17182Rg().mo14546b(110, (C1202f) this);
                    if (this.zIX != 0) {
                        finish();
                        if (this.zIT && !this.zJh) {
                            Intent intent = new Intent(this, ChattingUI.class);
                            intent.addFlags(67108864);
                            intent.putExtra("Chat_User", c9022l.cMr);
                            startActivity(intent);
                        }
                    }
                }
                AppMethodBeat.m2505o(35111);
                return;
            }
            this.zJa.remove(0);
            stringExtra = c9022l.cMr;
            if (C5046bo.isNullOrNil(stringExtra) && this.zIR != null) {
                stringExtra = (String) this.zIR.get(0);
            }
            m59839a(stringExtra, 3, this.fEW);
            AppMethodBeat.m2505o(35111);
            return;
        }
        AppMethodBeat.m2505o(35111);
    }

    /* renamed from: a */
    private boolean m59842a(C25822e c25822e, C7620bi c7620bi, String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(35104);
        Map z = C5049br.m7595z(c25822e.fDK, "msg");
        if (z == null) {
            C4990ab.m7413e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", c25822e.fDK);
            AppMethodBeat.m2505o(35104);
            return false;
        }
        int i2;
        String str4;
        final int i3 = c25822e.fDC;
        if (i3 != 1) {
            i2 = 2;
            str4 = (String) z.get(".msg.img.$cdnmidimgurl");
        } else {
            i2 = 1;
            str4 = (String) z.get(".msg.img.$cdnbigimgurl");
        }
        C4990ab.m7411d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", Integer.valueOf(i3), str4);
        if (C5046bo.isNullOrNil(str4)) {
            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
            AppMethodBeat.m2505o(35104);
            return false;
        }
        String str5 = (String) z.get(".msg.img.$aeskey");
        if (C5046bo.isNullOrNil(str5)) {
            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
            AppMethodBeat.m2505o(35104);
            return false;
        } else if (C5046bo.isNullOrNil(C37458c.m63162a("downimg", (long) c25822e.fDG, c7620bi.field_talker, c7620bi.field_msgId))) {
            C4990ab.m7421w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(c7620bi.field_msgSvrId));
            AppMethodBeat.m2505o(35104);
            return false;
        } else {
            final String str6 = (String) z.get(".msg.img.$md5");
            C42130g c42130g = new C42130g();
            final C7620bi c7620bi2 = c7620bi;
            final int i4 = i;
            final String str7 = str2;
            final String str8 = str3;
            final String str9 = str;
            final C25822e c25822e2 = c25822e;
            c42130g.egl = new C1628a() {
                /* renamed from: a */
                public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                    AppMethodBeat.m2504i(35070);
                    if (c9545d != null) {
                        if (c9545d.field_exist_whencheck) {
                            C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", c9545d);
                            MsgRetransmitUI.m59834a(MsgRetransmitUI.this, c9545d, c7620bi2, i4, str7, str8, str9, str6, i3);
                        } else {
                            C4990ab.m7416i("MicroMsg.MsgRetransmitUI", "not support second !! dealDownLoadImg");
                            MsgRetransmitUI.m59833a(MsgRetransmitUI.this, c25822e2, c7620bi2, str9, i4, str7, str8);
                        }
                    }
                    AppMethodBeat.m2505o(35070);
                    return 0;
                }

                /* renamed from: a */
                public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                /* renamed from: l */
                public final byte[] mo5084l(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            c42130g.field_mediaId = C37458c.m63162a("checkExist", C5046bo.anU(), str2, c7620bi.field_msgId);
            c42130g.field_fileId = str4;
            c42130g.field_aesKey = str5;
            c42130g.field_filemd5 = str6;
            c42130g.field_fileType = i2;
            c42130g.field_talker = str2;
            c42130g.field_priority = C42129a.efC;
            c42130g.field_svr_signature = "";
            c42130g.field_onlycheckexist = true;
            c42130g.field_trysafecdn = true;
            if (C37461f.afx().mo51225e(c42130g)) {
                AppMethodBeat.m2505o(35104);
                return true;
            }
            C4990ab.m7412e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
            AppMethodBeat.m2505o(35104);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m59834a(MsgRetransmitUI msgRetransmitUI, C9545d c9545d, C7620bi c7620bi, int i, String str, String str2, String str3, String str4, int i2) {
        long a;
        int i3;
        C25822e b;
        String a2;
        clk clk;
        final long j;
        AppMethodBeat.m2504i(35115);
        String I = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = "";
        C6575cy c7620bi2 = new C7620bi();
        c7620bi2.setType(C1855t.m3926nL(str));
        c7620bi2.mo14794ju(str);
        c7620bi2.mo14781hO(1);
        c7620bi2.setStatus(1);
        c7620bi2.mo14775eJ(C1829bf.m3756oC(c7620bi2.field_talker));
        c7620bi2.setContent(str3);
        C26350a.m41930KG().mo35238g(c7620bi2);
        long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi2);
        Assert.assertTrue(Z >= 0);
        C4990ab.m7416i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(Z)));
        if (i2 == 1) {
            a = C32291o.ahl().mo73082a(null, Z, true, c7620bi2.field_content, pString, pInt, pInt2);
        } else {
            a = 0;
        }
        long a3 = C32291o.ahl().mo73082a(null, Z, false, c7620bi2.field_content, pString, pInt, pInt2);
        Map z = C5049br.m7595z(str3, "msg");
        int i4 = C5046bo.getInt((String) z.get(".msg.img.$length"), c9545d.field_thumbimgLength);
        C25822e b2 = C32291o.ahl().mo73105b(Long.valueOf(a3));
        b2.mo43793fG((long) ((int) Z));
        if (a3 > 0) {
            C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "deal send img for cdn [%s]", C32291o.ahl().mo73106b(pString.value, "th_", "", false));
            C5730e.m8644y(I, r7);
            c7620bi2.mo14795jv(pString.value);
            c7620bi2.mo14784hZ(c7620bi.dJw);
            c7620bi2.mo14786ia(c7620bi.dJx);
            if (a > 0) {
                b2.mo43801lx(1);
                b2.mo43798lu((int) a);
                i3 = C5046bo.getInt((String) z.get(".msg.img.$hdlength"), c9545d.field_thumbimgLength);
                C32291o.ahl().mo73077a(Long.valueOf(a3), b2);
                if (i2 != 1) {
                    b = C32291o.ahl().mo73105b(Long.valueOf(a));
                } else {
                    a = a3;
                    b = b2;
                }
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(Z, (C7620bi) c7620bi2);
                C32291o.ahl().mo73077a(Long.valueOf(a), b);
                a2 = C37458c.m63162a("upimg", c7620bi2.field_createTime, c7620bi2.field_talker, c7620bi2.field_msgId + "_" + a + "_" + i2);
                clk = new clk();
                clk.vEB = new bts().alV(str2);
                clk.vEC = new bts().alV(str);
                clk.nao = c7620bi2.getType();
                clk.vEG = c7620bi2.dqJ;
                clk.vRz = b.fDD;
                clk.xja = new bts().alV(a2);
                clk.wqw = i2;
                c9545d.field_filemd5 = str4;
                c9545d.field_thumbimgLength = (int) C5730e.asZ(I);
                c9545d.field_fileLength = i3;
                j = a3;
                a3 = Z;
                C1720g.m3540Rg().mo14541a(new C6326m(i, clk, b, c9545d, new C6327a() {
                    /* renamed from: a */
                    public final void mo4586a(long j, int i, int i2, int i3) {
                        AppMethodBeat.m2504i(35071);
                        C4990ab.m7417i("MicroMsg.MsgRetransmitUI", "cdntra  NetSceneUploadMsgImgForCdn ret:[%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
                        if (i2 == 0 && i3 == 0) {
                            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(a3);
                            jf.setStatus(2);
                            jf.mo14774eI(j);
                            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(a3, jf);
                            C45161i.m83148lB((int) j);
                            AppMethodBeat.m2505o(35071);
                            return;
                        }
                        C45161i.m83149lC((int) j);
                        C45161i.m83148lB((int) j);
                        AppMethodBeat.m2505o(35071);
                    }
                }), 0);
                AppMethodBeat.m2505o(35115);
            }
        }
        i3 = i4;
        C32291o.ahl().mo73077a(Long.valueOf(a3), b2);
        if (i2 != 1) {
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(Z, (C7620bi) c7620bi2);
        C32291o.ahl().mo73077a(Long.valueOf(a), b);
        a2 = C37458c.m63162a("upimg", c7620bi2.field_createTime, c7620bi2.field_talker, c7620bi2.field_msgId + "_" + a + "_" + i2);
        clk = new clk();
        clk.vEB = new bts().alV(str2);
        clk.vEC = new bts().alV(str);
        clk.nao = c7620bi2.getType();
        clk.vEG = c7620bi2.dqJ;
        clk.vRz = b.fDD;
        clk.xja = new bts().alV(a2);
        clk.wqw = i2;
        c9545d.field_filemd5 = str4;
        c9545d.field_thumbimgLength = (int) C5730e.asZ(I);
        c9545d.field_fileLength = i3;
        j = a3;
        a3 = Z;
        C1720g.m3540Rg().mo14541a(new C6326m(i, clk, b, c9545d, /* anonymous class already generated */), 0);
        AppMethodBeat.m2505o(35115);
    }
}
