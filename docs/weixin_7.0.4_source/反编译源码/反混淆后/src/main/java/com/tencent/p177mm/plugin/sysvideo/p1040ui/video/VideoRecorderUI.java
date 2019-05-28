package com.tencent.p177mm.plugin.sysvideo.p1040ui.video;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.pluginsdk.p1082i.C30048b;
import com.tencent.p177mm.pluginsdk.p1082i.C40435a;
import com.tencent.p177mm.pluginsdk.p1082i.C44053f;
import com.tencent.p177mm.pluginsdk.p1082i.C44054g;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI */
public class VideoRecorderUI extends MMActivity {
    private static VideoRecorderUI swV;
    private ProgressDialog ehJ = null;
    private long miD = -1;
    private C7564ap miP = new C7564ap(new C223711(), true);
    private C7306ak oHR = new C223769();
    private boolean qhS;
    private String swB = null;
    private SurfaceView swF = null;
    private SurfaceHolder swG = null;
    private C30048b swH;
    private ImageButton swI;
    private boolean swJ = false;
    private boolean swK = false;
    private TextView swL;
    private LinearLayout swM;
    private ImageView swN;
    private ImageButton swO = null;
    private ImageView swP;
    private TextView swQ;
    private TextView swR;
    private TextView swS;
    private int swT = 0;
    private ImageButton swU;
    private boolean swW = false;
    private boolean swX = true;
    private String swY = null;
    private String swZ = null;
    private View sxa;
    private View sxb;
    Callback sxc = new C399443();
    private String talker = null;
    private String videoPath = null;

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$11 */
    class C1392611 implements OnClickListener {
        C1392611() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25656);
            VideoRecorderUI.this.finish();
            AppMethodBeat.m2505o(25656);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$12 */
    class C1392712 implements OnClickListener {
        C1392712() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$1 */
    class C223711 implements C5015a {
        C223711() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25643);
            if (VideoRecorderUI.this.miD == -1) {
                VideoRecorderUI.this.miD = SystemClock.elapsedRealtime();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - VideoRecorderUI.this.miD;
            VideoRecorderUI.this.swQ.setText(C44053f.m79183mK((int) (elapsedRealtime / 1000)));
            if (elapsedRealtime > 30000 || elapsedRealtime < 20000) {
                VideoRecorderUI.this.swL.setVisibility(8);
            } else {
                long j = (30000 - elapsedRealtime) / 1000;
                VideoRecorderUI.this.swL.setVisibility(0);
                VideoRecorderUI.this.swL.setText(VideoRecorderUI.this.getResources().getQuantityString(C25738R.plurals.f9621a8, (int) j, new Object[]{Long.valueOf(j)}));
            }
            if (elapsedRealtime >= 30000) {
                C4990ab.m7418v("MicroMsg.VideoRecorderUI", "record stop on countdown");
                VideoRecorderUI.m78219d(VideoRecorderUI.this);
                VideoRecorderUI.this.miD = -1;
                AppMethodBeat.m2505o(25643);
                return false;
            }
            VideoRecorderUI.this.swT = VideoRecorderUI.this.swT % 2;
            if (VideoRecorderUI.this.swT == 0) {
                VideoRecorderUI.this.swP.setVisibility(4);
            } else {
                VideoRecorderUI.this.swP.setVisibility(0);
            }
            VideoRecorderUI.this.swT = VideoRecorderUI.this.swT + 1;
            AppMethodBeat.m2505o(25643);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$6 */
    class C223726 implements OnMenuItemClickListener {
        C223726() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25650);
            VideoRecorderUI.m78225j(VideoRecorderUI.this);
            AppMethodBeat.m2505o(25650);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$7 */
    class C223737 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$7$2 */
        class C139282 implements OnClickListener {
            C139282() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$7$1 */
        class C223741 implements OnClickListener {
            C223741() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(25651);
                VideoRecorderUI.this.swI.setImageResource(C25738R.drawable.aqo);
                VideoRecorderUI.m78229n(VideoRecorderUI.this);
                AppMethodBeat.m2505o(25651);
            }
        }

        C223737() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25652);
            C9638aw.m17190ZK();
            if (!C18628c.isSDCardAvailable()) {
                C23639t.m36492hO(VideoRecorderUI.this);
                AppMethodBeat.m2505o(25652);
            } else if (VideoRecorderUI.this.swK) {
                VideoRecorderUI.m78219d(VideoRecorderUI.this);
                AppMethodBeat.m2505o(25652);
            } else if (VideoRecorderUI.this.swJ) {
                C30379h.m48440a(VideoRecorderUI.this, VideoRecorderUI.this.getString(C25738R.string.f1o), VideoRecorderUI.this.getString(C25738R.string.f9238tz), new C223741(), new C139282());
                AppMethodBeat.m2505o(25652);
            } else {
                VideoRecorderUI.this.swI.setImageResource(C25738R.drawable.aqo);
                VideoRecorderUI.m78229n(VideoRecorderUI.this);
                AppMethodBeat.m2505o(25652);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$8 */
    class C223758 implements View.OnClickListener {
        C223758() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25653);
            VideoRecorderUI.this.swU.setEnabled(false);
            VideoRecorderUI.this.oHR.sendEmptyMessageDelayed(0, 3000);
            VideoRecorderUI.this.swW = true;
            VideoRecorderUI.this.swH.diG();
            if (!(VideoRecorderUI.this.swH.mo48270b(VideoRecorderUI.this, VideoRecorderUI.this.swW) == 0 && VideoRecorderUI.this.swH.mo48271b(VideoRecorderUI.this.swG) == 0)) {
                VideoRecorderUI.m78234s(VideoRecorderUI.this);
            }
            AppMethodBeat.m2505o(25653);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$9 */
    class C223769 extends C7306ak {
        C223769() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(25654);
            super.handleMessage(message);
            VideoRecorderUI.this.swU.setEnabled(true);
            AppMethodBeat.m2505o(25654);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$3 */
    class C399443 implements Callback {
        C399443() {
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(25645);
            C4990ab.m7410d("MicroMsg.VideoRecorderUI", "surfaceCreated");
            if (VideoRecorderUI.this.swH.mo48270b(VideoRecorderUI.this, VideoRecorderUI.this.swW) != 0) {
                VideoRecorderUI.m78234s(VideoRecorderUI.this);
            }
            AppMethodBeat.m2505o(25645);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(25646);
            C4990ab.m7410d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
            VideoRecorderUI.this.swX = true;
            VideoRecorderUI.this.swH.diG();
            AppMethodBeat.m2505o(25646);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            AppMethodBeat.m2504i(25647);
            C4990ab.m7410d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + i + " w:" + i2 + " h:" + i3);
            if (VideoRecorderUI.this.swH.mo48271b(surfaceHolder) != 0) {
                VideoRecorderUI.m78234s(VideoRecorderUI.this);
            }
            VideoRecorderUI.this.swW = false;
            VideoRecorderUI.this.swX = false;
            VideoRecorderUI.m78239x(VideoRecorderUI.this);
            AppMethodBeat.m2505o(25647);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$4 */
    class C436764 implements OnClickListener {
        C436764() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25648);
            VideoRecorderUI.this.swH.diG();
            VideoRecorderUI.this.finish();
            AppMethodBeat.m2505o(25648);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$5 */
    class C436775 implements OnMenuItemClickListener {
        C436775() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25649);
            Intent intent = new Intent();
            intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.this.swH.filename);
            intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.this.swH.qBs.fXd);
            intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.this.talker);
            VideoRecorderUI.this.setResult(-1, intent);
            VideoRecorderUI.this.finish();
            AppMethodBeat.m2505o(25649);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$10 */
    class C4367810 implements View.OnClickListener {
        C4367810() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(25655);
            Intent intent = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
            intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.this.swH.filename);
            intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.this.swH.qBs.fXd);
            intent.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.this.swH.fileSize);
            intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.this.talker);
            intent.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.this.swB);
            VideoRecorderUI.this.startActivityForResult(intent, 0);
            VideoRecorderUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(25655);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI$2 */
    class C436792 implements OnCancelListener {
        C436792() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(25644);
            C4990ab.m7410d("MicroMsg.VideoRecorderUI", "tipDialog onCancel");
            if (VideoRecorderUI.this.swH != null) {
                VideoRecorderUI.m78236u(VideoRecorderUI.this);
                VideoRecorderUI.this.swM.setVisibility(0);
                VideoRecorderUI.this.swF.setVisibility(0);
            }
            AppMethodBeat.m2505o(25644);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VideoRecorderUI() {
        AppMethodBeat.m2504i(25657);
        AppMethodBeat.m2505o(25657);
    }

    /* renamed from: j */
    static /* synthetic */ void m78225j(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.m2504i(25673);
        videoRecorderUI.cDZ();
        AppMethodBeat.m2505o(25673);
    }

    /* renamed from: s */
    static /* synthetic */ void m78234s(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.m2504i(25675);
        videoRecorderUI.cEa();
        AppMethodBeat.m2505o(25675);
    }

    /* renamed from: u */
    static /* synthetic */ void m78236u(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.m2504i(25676);
        videoRecorderUI.bHM();
        AppMethodBeat.m2505o(25676);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25658);
        super.onCreate(bundle);
        C5536q.initLanguage(this);
        swV = this;
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getSupportActionBar().hide();
        setMMTitle((int) C25738R.string.f1p);
        mo17379a(0, getString(C25738R.string.f9221tf), (OnMenuItemClickListener) new C436775(), C5535b.GREEN);
        setBackBtn(new C223726());
        this.talker = getIntent().getStringExtra("VideoRecorder_ToUser");
        this.videoPath = getIntent().getStringExtra("VideoRecorder_VideoPath");
        this.swB = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        this.swY = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
        this.swZ = getIntent().getStringExtra("VideoRecorder_FileName");
        C4990ab.m7410d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
        C4990ab.m7410d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.swB + " videoThumbPath " + this.swY + " KFileName " + this.swZ);
        initView();
        bHM();
        C9638aw.m17176Cc().mo4649Id();
        AppMethodBeat.m2505o(25658);
    }

    public void onStart() {
        AppMethodBeat.m2504i(25659);
        super.onStart();
        if (this.qhS) {
            setRequestedOrientation(0);
            AppMethodBeat.m2505o(25659);
            return;
        }
        setRequestedOrientation(1);
        AppMethodBeat.m2505o(25659);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25660);
        swV = null;
        C4990ab.m7418v("MicroMsg.VideoRecorderUI", "on destroy");
        C9638aw.m17176Cc().mo4648Ic();
        super.onDestroy();
        AppMethodBeat.m2505o(25660);
    }

    public final void initView() {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(25661);
        this.swF = (SurfaceView) findViewById(2131827545);
        this.swM = (LinearLayout) findViewById(2131821705);
        this.swG = this.swF.getHolder();
        this.swG.addCallback(this.sxc);
        this.swG.setType(3);
        this.swP = (ImageView) findViewById(2131828421);
        this.swU = (ImageButton) findViewById(2131828423);
        this.swQ = (TextView) findViewById(2131828422);
        this.sxa = findViewById(2131828420);
        this.sxb = findViewById(2131828425);
        this.swQ.setText(C44053f.m79183mK(0));
        this.swH = new C30048b();
        this.swL = (TextView) findViewById(2131828424);
        this.swR = (TextView) findViewById(2131828427);
        this.swS = (TextView) findViewById(2131828426);
        this.swI = (ImageButton) findViewById(2131822715);
        this.swI.setOnClickListener(new C223737());
        if (C32468d.getNumberOfCameras() > 1) {
            this.swU.setVisibility(0);
        } else {
            this.swU.setVisibility(4);
        }
        this.swU.setOnClickListener(new C223758());
        this.swO = (ImageButton) findViewById(2131828428);
        this.swN = (ImageView) findViewById(2131828419);
        this.swO.setOnClickListener(new C4367810());
        C30048b c30048b = this.swH;
        if (this.qhS) {
            i = 0;
        } else {
            i = 1;
        }
        String str = this.videoPath;
        String str2 = this.swB;
        String str3 = this.swY;
        String str4 = this.swZ;
        c30048b.fVl = 0;
        if (1 == c30048b.fVl) {
            c30048b.qBs = C40435a.diF();
        } else {
            c30048b.qBs = C40435a.diE();
        }
        if (C1427q.ete.etU) {
            c30048b.qBs.ouT = C1427q.ete.mVideoHeight;
            c30048b.qBs.ouU = C1427q.ete.mVideoWidth;
            c30048b.qBs.ouS = C1427q.ete.etW;
        }
        c30048b.filename = str4;
        c30048b.qBs.ovb = str2;
        c30048b.qBs.ouZ = str3;
        c30048b.qBs.ouY = str + "temp.pcm";
        c30048b.qBs.ouX = str + "temp.yuv";
        c30048b.qBs.ova = str + "temp.vid";
        c30048b.qBs.ovd = C32468d.getNumberOfCameras();
        C40435a c40435a = c30048b.qBs;
        if (i == 0) {
            i2 = 0;
        }
        c40435a.rotate = i2;
        c30048b.qBs.fXd = 0;
        c30048b.vfT = new C44054g();
        AppMethodBeat.m2505o(25661);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(25662);
        C5222ae.m7946h(C5222ae.m7934a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) this.mController.ylv.getParent()).removeView(this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.ylv, 0);
        AppMethodBeat.m2505o(25662);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(25663);
        if (i == 4) {
            C4990ab.m7410d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
            if (this.swK) {
                AppMethodBeat.m2505o(25663);
                return true;
            }
            cDZ();
            AppMethodBeat.m2505o(25663);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(25663);
        return onKeyDown;
    }

    private void cDZ() {
        AppMethodBeat.m2504i(25664);
        if (this.swJ) {
            C30379h.m48440a((Context) this, getString(C25738R.string.f1n), getString(C25738R.string.f9238tz), new C1392611(), new C1392712());
            AppMethodBeat.m2505o(25664);
            return;
        }
        finish();
        AppMethodBeat.m2505o(25664);
    }

    private void bHM() {
        AppMethodBeat.m2504i(25665);
        getSupportActionBar().hide();
        this.swQ.setText(C44053f.m79183mK(0));
        this.sxa.setVisibility(8);
        this.sxb.setVisibility(8);
        this.swP.setVisibility(0);
        this.swJ = false;
        this.swM.setVisibility(0);
        this.swF.setVisibility(0);
        this.swL.setVisibility(8);
        this.swO.setVisibility(8);
        this.swQ.setText(C44053f.m79183mK(0));
        this.swN.setVisibility(8);
        this.swI.setEnabled(true);
        this.swU.setVisibility(0);
        AppMethodBeat.m2505o(25665);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25666);
        if (!(this.swX || (this.swH.mo48270b(this, false) == 0 && this.swH.mo48271b(this.swG) == 0))) {
            cEa();
        }
        this.swX = false;
        C4990ab.m7418v("MicroMsg.VideoRecorderUI", "onResume");
        super.onResume();
        AppMethodBeat.m2505o(25666);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25667);
        if (this.swK) {
            C30048b c30048b = this.swH;
            if (c30048b.owh != null) {
                c30048b.owh.stop();
                c30048b.owh.release();
                c30048b.owh = null;
            }
            bHM();
            this.swK = false;
            releaseWakeLock();
            this.swI.setImageResource(C25738R.drawable.aqn);
            this.miP.stopTimer();
            this.swL.setVisibility(8);
            this.swM.setVisibility(0);
            this.swF.setVisibility(0);
        }
        this.swH.diG();
        C4990ab.m7418v("MicroMsg.VideoRecorderUI", "onPause");
        super.onPause();
        AppMethodBeat.m2505o(25667);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(25668);
        if (i2 != -1) {
            AppMethodBeat.m2505o(25668);
            return;
        }
        if (i == 0) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(25668);
    }

    private void cEa() {
        AppMethodBeat.m2504i(25669);
        C30379h.m48431a((Context) this, (int) C25738R.string.f11, (int) C25738R.string.f9238tz, new C436764());
        AppMethodBeat.m2505o(25669);
    }

    private void releaseWakeLock() {
        AppMethodBeat.m2504i(25670);
        this.swF.setKeepScreenOn(false);
        AppMethodBeat.m2505o(25670);
    }

    public final int getLayoutId() {
        AppMethodBeat.m2504i(25671);
        this.qhS = C32468d.m53154Lt();
        if (this.qhS) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            setRequestedOrientation(0);
            AppMethodBeat.m2505o(25671);
            return 2130970995;
        }
        AppMethodBeat.m2505o(25671);
        return 2130970994;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0206 A:{SYNTHETIC, Splitter:B:63:0x0206} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    static /* synthetic */ void m78219d(VideoRecorderUI videoRecorderUI) {
        int i;
        Bitmap createVideoThumbnail;
        Throwable e;
        String str;
        TextView textView;
        CharSequence charSequence;
        AppMethodBeat.m2504i(25672);
        videoRecorderUI.swK = false;
        videoRecorderUI.releaseWakeLock();
        videoRecorderUI.swI.setImageResource(C25738R.drawable.aqn);
        videoRecorderUI.swI.setEnabled(false);
        videoRecorderUI.getString(C25738R.string.f9238tz);
        videoRecorderUI.ehJ = C30379h.m48458b((Context) videoRecorderUI, videoRecorderUI.getString(C25738R.string.f0z, new Object[]{Integer.valueOf(0)}), true, new C436792());
        long elapsedRealtime = SystemClock.elapsedRealtime() - videoRecorderUI.miD;
        videoRecorderUI.miP.stopTimer();
        videoRecorderUI.swL.setVisibility(8);
        videoRecorderUI.swJ = true;
        C30048b c30048b = videoRecorderUI.swH;
        if (c30048b.owh != null) {
            try {
                c30048b.owh.stop();
                c30048b.owh.release();
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.SceneVideo", "video[tiger] video stop failed");
            }
            c30048b.owh = null;
            c30048b.qBs.fXd = (int) (elapsedRealtime / 1000);
            C40435a c40435a = c30048b.qBs;
            if (c30048b.qBs.fXd > 0) {
                i = c30048b.qBs.fXd;
            } else {
                i = 1;
            }
            c40435a.fXd = i;
            c30048b.qBs.ovc = c30048b.qBs.fXd * c30048b.qBs.fps;
            if (!(!C1173e.m2561ct(c30048b.qBs.ovb) || C1173e.m2561ct(c30048b.qBs.ouZ) || c30048b.context == null)) {
                if (C1443d.m3068iW(8)) {
                    createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(c30048b.qBs.ovb, 1);
                } else {
                    createVideoThumbnail = null;
                }
                if (createVideoThumbnail != null) {
                    try {
                        C4990ab.m7410d("MicroMsg.SceneVideo", "saveBitmapToImage " + c30048b.qBs.ouZ);
                        C44053f.m79182a(createVideoThumbnail, CompressFormat.JPEG, c30048b.qBs.ouZ, true);
                    } catch (Exception e3) {
                        C4990ab.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                    }
                } else {
                    InputStream openRawResource;
                    try {
                        openRawResource = c30048b.context.getResources().openRawResource(C25738R.drawable.ad1);
                        try {
                            C44053f.m79182a(BitmapFactory.decodeStream(openRawResource), CompressFormat.JPEG, c30048b.qBs.ouZ, true);
                            if (openRawResource != null) {
                                try {
                                    openRawResource.close();
                                } catch (Exception e32) {
                                    C4990ab.printErrStackTrace("MicroMsg.SceneVideo", e32, "", new Object[0]);
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            try {
                                C4990ab.printErrStackTrace("MicroMsg.SceneVideo", e, "", new Object[0]);
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Exception e322) {
                                        C4990ab.printErrStackTrace("MicroMsg.SceneVideo", e322, "", new Object[0]);
                                    }
                                }
                                if (C1173e.m2561ct(c30048b.qBs.ovb)) {
                                }
                                str = videoRecorderUI.swH.qBs.ouZ;
                                if (str != null) {
                                }
                                createVideoThumbnail = null;
                                if (createVideoThumbnail != null) {
                                }
                                if (videoRecorderUI.ehJ != null) {
                                }
                                videoRecorderUI.swL.setVisibility(8);
                                videoRecorderUI.sxb.setVisibility(0);
                                textView = videoRecorderUI.swR;
                                elapsedRealtime = (long) videoRecorderUI.swH.fileSize;
                                if ((elapsedRealtime >> 20) <= 0) {
                                }
                                textView.setText(charSequence);
                                videoRecorderUI.swS.setText(C44053f.m79183mK(videoRecorderUI.swH.qBs.fXd));
                                videoRecorderUI.swM.setVisibility(8);
                                videoRecorderUI.swO.setVisibility(0);
                                videoRecorderUI.sxa.setVisibility(8);
                                videoRecorderUI.swU.setVisibility(8);
                                videoRecorderUI.swI.setVisibility(8);
                                videoRecorderUI.swI.setEnabled(true);
                                videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                                videoRecorderUI.getSupportActionBar().show();
                                AppMethodBeat.m2505o(25672);
                            } catch (Throwable th) {
                                e = th;
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Exception e5) {
                                        C4990ab.printErrStackTrace("MicroMsg.SceneVideo", e5, "", new Object[0]);
                                    }
                                }
                                AppMethodBeat.m2505o(25672);
                                throw e;
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        openRawResource = null;
                    } catch (Throwable th2) {
                        e = th2;
                        openRawResource = null;
                        if (openRawResource != null) {
                        }
                        AppMethodBeat.m2505o(25672);
                        throw e;
                    }
                }
            }
            if (C1173e.m2561ct(c30048b.qBs.ovb)) {
                c30048b.fileSize = C1173e.m2560cs(c30048b.qBs.ovb);
            }
        }
        str = videoRecorderUI.swH.qBs.ouZ;
        if (str != null || str.length() <= 0) {
            createVideoThumbnail = null;
        } else {
            Bitmap i2 = C4977b.m7374i(str.trim(), C1338a.getDensity(videoRecorderUI));
            if (i2 != null) {
                i = i2.getWidth();
                int height = i2.getHeight();
                int b = C4977b.m7371b((Context) videoRecorderUI, 224.0f);
                createVideoThumbnail = Bitmap.createScaledBitmap(i2, b, (int) (((float) height) / (((float) i) / ((float) b))), true);
                if (i2 != createVideoThumbnail) {
                    C4990ab.m7417i("MicroMsg.SceneVideo", "recycle bitmap:%s", i2.toString());
                    i2.recycle();
                }
            } else {
                createVideoThumbnail = i2;
            }
        }
        if (createVideoThumbnail != null) {
            videoRecorderUI.swF.setVisibility(8);
            videoRecorderUI.swN.setVisibility(0);
            videoRecorderUI.swN.setImageBitmap(createVideoThumbnail);
        }
        if (videoRecorderUI.ehJ != null) {
            videoRecorderUI.ehJ.dismiss();
            videoRecorderUI.ehJ = null;
        }
        videoRecorderUI.swL.setVisibility(8);
        videoRecorderUI.sxb.setVisibility(0);
        textView = videoRecorderUI.swR;
        elapsedRealtime = (long) videoRecorderUI.swH.fileSize;
        if ((elapsedRealtime >> 20) <= 0) {
            charSequence = (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1048576.0f)) / 10.0f) + "MB";
        } else if ((elapsedRealtime >> 9) > 0) {
            charSequence = (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1024.0f)) / 10.0f) + "KB";
        } else {
            charSequence = elapsedRealtime + "B";
        }
        textView.setText(charSequence);
        videoRecorderUI.swS.setText(C44053f.m79183mK(videoRecorderUI.swH.qBs.fXd));
        videoRecorderUI.swM.setVisibility(8);
        videoRecorderUI.swO.setVisibility(0);
        videoRecorderUI.sxa.setVisibility(8);
        videoRecorderUI.swU.setVisibility(8);
        videoRecorderUI.swI.setVisibility(8);
        videoRecorderUI.swI.setEnabled(true);
        videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        videoRecorderUI.getSupportActionBar().show();
        AppMethodBeat.m2505o(25672);
    }

    /* renamed from: n */
    static /* synthetic */ void m78229n(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.m2504i(25674);
        videoRecorderUI.mController.hideTitleView();
        videoRecorderUI.swM.setVisibility(0);
        videoRecorderUI.swF.setVisibility(0);
        videoRecorderUI.swU.setVisibility(8);
        videoRecorderUI.sxb.setVisibility(8);
        videoRecorderUI.swK = true;
        videoRecorderUI.swN.setVisibility(8);
        videoRecorderUI.swO.setVisibility(8);
        videoRecorderUI.sxa.setVisibility(0);
        videoRecorderUI.swL.setVisibility(0);
        videoRecorderUI.miD = -1;
        videoRecorderUI.miP.mo16770ae(300, 300);
        videoRecorderUI.swF.setKeepScreenOn(true);
        C30048b c30048b = videoRecorderUI.swH;
        SurfaceHolder surfaceHolder = videoRecorderUI.swG;
        if (surfaceHolder == null) {
            C4990ab.m7412e("MicroMsg.SceneVideo", "start fail, holder is null");
            AppMethodBeat.m2505o(25674);
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        c30048b.vfU = 0;
        int i = c30048b.qBs.fps;
        int i2 = 0;
        while (c30048b.vfT != null) {
            Camera camera = c30048b.vfT.erH.etv;
            if (surface == null || camera == null) {
                C4990ab.m7412e("MicroMsg.SceneVideo", "holder or cam is null ");
                AppMethodBeat.m2505o(25674);
                return;
            }
            int i3 = C1427q.etn.esg == -1 ? i : C1427q.etn.esg;
            int cameraId = C44054g.getCameraId();
            try {
                camera.unlock();
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.SceneVideo", "exception in cam.unlock() [%s]", e.getMessage());
            }
            c30048b.owh = new MediaRecorder();
            c30048b.owh.setCamera(camera);
            c30048b.owh.setAudioSource(5);
            c30048b.owh.setVideoSource(1);
            c30048b.owh.setOutputFormat(2);
            c30048b.owh.setVideoSize(c30048b.qBs.lZe, c30048b.qBs.lZf);
            c30048b.owh.setVideoEncoder(2);
            c30048b.owh.setAudioEncoder(3);
            if (VERSION.SDK_INT > 7) {
                c30048b.owh.setVideoEncodingBitRate(c30048b.qBs.ouS);
            }
            try {
                if (C1427q.ete.etU) {
                    c30048b.owh.setVideoFrameRate(C1427q.ete.etV);
                } else {
                    c30048b.owh.setVideoFrameRate(i3);
                }
            } catch (Exception e2) {
                C4990ab.m7410d("MicroMsg.SceneVideo", "try set fps failed: ".concat(String.valueOf(i3)));
            }
            c30048b.owh.setOutputFile(c30048b.qBs.ovb);
            c30048b.owh.setPreviewDisplay(surface);
            C4990ab.m7411d("MicroMsg.SceneVideo", "doStart camid[%s] params:\n%s", Integer.valueOf(cameraId), c30048b.qBs.toString());
            if (cameraId == 0) {
                c30048b.setOrientationHint(C1427q.etn.esa == -1 ? 90 : C1427q.etn.esa);
            } else {
                c30048b.setOrientationHint(C1427q.etn.esb == -1 ? 270 : C1427q.etn.esb);
            }
            try {
                c30048b.owh.prepare();
                c30048b.owh.start();
                AppMethodBeat.m2505o(25674);
                return;
            } catch (Exception e3) {
                C4990ab.m7421w("MicroMsg.SceneVideo", "exception in mediaRecorder[%s] doStartCount[%s]", e3.getMessage(), Integer.valueOf(c30048b.vfU));
                C4990ab.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                c30048b.vfU++;
                if (c30048b.vfU < 5) {
                    C44054g c44054g = c30048b.vfT;
                    if (i2 < 0 || i2 >= c44054g.vgf.size()) {
                        C4990ab.m7410d("MicroMsg.YuvReocrder", "ret fr ".concat(String.valueOf(i)));
                    } else {
                        C4990ab.m7410d("MicroMsg.YuvReocrder", "ret fr " + c44054g.vgf.get(i2));
                        i = ((Integer) c44054g.vgf.get(i2)).intValue();
                    }
                    i2++;
                } else {
                    AppMethodBeat.m2505o(25674);
                    return;
                }
            }
        }
        C4990ab.m7412e("MicroMsg.SceneVideo", "yuvRecoder is null");
        AppMethodBeat.m2505o(25674);
    }

    /* renamed from: x */
    static /* synthetic */ void m78239x(VideoRecorderUI videoRecorderUI) {
        int previewWidth;
        int previewHeight;
        AppMethodBeat.m2504i(25677);
        LayoutParams layoutParams = (LayoutParams) videoRecorderUI.swF.getLayoutParams();
        DisplayMetrics displayMetrics = videoRecorderUI.getResources().getDisplayMetrics();
        if (videoRecorderUI.qhS) {
            previewWidth = videoRecorderUI.swH.getPreviewWidth();
            previewHeight = videoRecorderUI.swH.getPreviewHeight();
        } else {
            previewWidth = videoRecorderUI.swH.getPreviewHeight();
            previewHeight = videoRecorderUI.swH.getPreviewWidth();
        }
        C4990ab.m7417i("MicroMsg.VideoRecorderUI", "resizeLayout priveview[%d, %d], dm[%d, %d]", Integer.valueOf(previewWidth), Integer.valueOf(previewHeight), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        if (((float) previewWidth) / ((float) previewHeight) > ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels)) {
            C4990ab.m7416i("MicroMsg.VideoRecorderUI", "resizeLayout wider");
            previewHeight = (int) (((float) previewHeight) * (((float) displayMetrics.widthPixels) / ((float) previewWidth)));
            previewWidth = displayMetrics.widthPixels;
        } else {
            C4990ab.m7416i("MicroMsg.VideoRecorderUI", "resizeLayout higher");
            previewWidth = (int) ((((float) displayMetrics.heightPixels) / ((float) previewHeight)) * ((float) previewWidth));
            previewHeight = displayMetrics.heightPixels;
        }
        C4990ab.m7417i("MicroMsg.VideoRecorderUI", "resizeLayout width:%d, height:%d", Integer.valueOf(previewWidth), Integer.valueOf(previewHeight));
        layoutParams.width = previewWidth;
        layoutParams.height = previewHeight;
        videoRecorderUI.swF.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(25677);
    }
}
