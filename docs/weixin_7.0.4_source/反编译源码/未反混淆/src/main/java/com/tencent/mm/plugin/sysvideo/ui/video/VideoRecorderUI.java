package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.i.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.i.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.q;
import java.io.InputStream;

public class VideoRecorderUI extends MMActivity {
    private static VideoRecorderUI swV;
    private ProgressDialog ehJ = null;
    private long miD = -1;
    private ap miP = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(25643);
            if (VideoRecorderUI.this.miD == -1) {
                VideoRecorderUI.this.miD = SystemClock.elapsedRealtime();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - VideoRecorderUI.this.miD;
            VideoRecorderUI.this.swQ.setText(f.mK((int) (elapsedRealtime / 1000)));
            if (elapsedRealtime > 30000 || elapsedRealtime < 20000) {
                VideoRecorderUI.this.swL.setVisibility(8);
            } else {
                long j = (30000 - elapsedRealtime) / 1000;
                VideoRecorderUI.this.swL.setVisibility(0);
                VideoRecorderUI.this.swL.setText(VideoRecorderUI.this.getResources().getQuantityString(R.plurals.a8, (int) j, new Object[]{Long.valueOf(j)}));
            }
            if (elapsedRealtime >= 30000) {
                ab.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
                VideoRecorderUI.d(VideoRecorderUI.this);
                VideoRecorderUI.this.miD = -1;
                AppMethodBeat.o(25643);
                return false;
            }
            VideoRecorderUI.this.swT = VideoRecorderUI.this.swT % 2;
            if (VideoRecorderUI.this.swT == 0) {
                VideoRecorderUI.this.swP.setVisibility(4);
            } else {
                VideoRecorderUI.this.swP.setVisibility(0);
            }
            VideoRecorderUI.this.swT = VideoRecorderUI.this.swT + 1;
            AppMethodBeat.o(25643);
            return true;
        }
    }, true);
    private ak oHR = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25654);
            super.handleMessage(message);
            VideoRecorderUI.this.swU.setEnabled(true);
            AppMethodBeat.o(25654);
        }
    };
    private boolean qhS;
    private String swB = null;
    private SurfaceView swF = null;
    private SurfaceHolder swG = null;
    private b swH;
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
    Callback sxc = new Callback() {
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(25645);
            ab.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
            if (VideoRecorderUI.this.swH.b(VideoRecorderUI.this, VideoRecorderUI.this.swW) != 0) {
                VideoRecorderUI.s(VideoRecorderUI.this);
            }
            AppMethodBeat.o(25645);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(25646);
            ab.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
            VideoRecorderUI.this.swX = true;
            VideoRecorderUI.this.swH.diG();
            AppMethodBeat.o(25646);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            AppMethodBeat.i(25647);
            ab.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + i + " w:" + i2 + " h:" + i3);
            if (VideoRecorderUI.this.swH.b(surfaceHolder) != 0) {
                VideoRecorderUI.s(VideoRecorderUI.this);
            }
            VideoRecorderUI.this.swW = false;
            VideoRecorderUI.this.swX = false;
            VideoRecorderUI.x(VideoRecorderUI.this);
            AppMethodBeat.o(25647);
        }
    };
    private String talker = null;
    private String videoPath = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoRecorderUI() {
        AppMethodBeat.i(25657);
        AppMethodBeat.o(25657);
    }

    static /* synthetic */ void j(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.i(25673);
        videoRecorderUI.cDZ();
        AppMethodBeat.o(25673);
    }

    static /* synthetic */ void s(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.i(25675);
        videoRecorderUI.cEa();
        AppMethodBeat.o(25675);
    }

    static /* synthetic */ void u(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.i(25676);
        videoRecorderUI.bHM();
        AppMethodBeat.o(25676);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25658);
        super.onCreate(bundle);
        q.initLanguage(this);
        swV = this;
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getSupportActionBar().hide();
        setMMTitle((int) R.string.f1p);
        a(0, getString(R.string.tf), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25649);
                Intent intent = new Intent();
                intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.this.swH.filename);
                intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.this.swH.qBs.fXd);
                intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.this.talker);
                VideoRecorderUI.this.setResult(-1, intent);
                VideoRecorderUI.this.finish();
                AppMethodBeat.o(25649);
                return true;
            }
        }, q.b.GREEN);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25650);
                VideoRecorderUI.j(VideoRecorderUI.this);
                AppMethodBeat.o(25650);
                return true;
            }
        });
        this.talker = getIntent().getStringExtra("VideoRecorder_ToUser");
        this.videoPath = getIntent().getStringExtra("VideoRecorder_VideoPath");
        this.swB = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        this.swY = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
        this.swZ = getIntent().getStringExtra("VideoRecorder_FileName");
        ab.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
        ab.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.swB + " videoThumbPath " + this.swY + " KFileName " + this.swZ);
        initView();
        bHM();
        aw.Cc().Id();
        AppMethodBeat.o(25658);
    }

    public void onStart() {
        AppMethodBeat.i(25659);
        super.onStart();
        if (this.qhS) {
            setRequestedOrientation(0);
            AppMethodBeat.o(25659);
            return;
        }
        setRequestedOrientation(1);
        AppMethodBeat.o(25659);
    }

    public void onDestroy() {
        AppMethodBeat.i(25660);
        swV = null;
        ab.v("MicroMsg.VideoRecorderUI", "on destroy");
        aw.Cc().Ic();
        super.onDestroy();
        AppMethodBeat.o(25660);
    }

    public final void initView() {
        int i;
        int i2 = 1;
        AppMethodBeat.i(25661);
        this.swF = (SurfaceView) findViewById(R.id.ed9);
        this.swM = (LinearLayout) findViewById(R.id.a4c);
        this.swG = this.swF.getHolder();
        this.swG.addCallback(this.sxc);
        this.swG.setType(3);
        this.swP = (ImageView) findViewById(R.id.f0x);
        this.swU = (ImageButton) findViewById(R.id.f0z);
        this.swQ = (TextView) findViewById(R.id.f0y);
        this.sxa = findViewById(R.id.f0w);
        this.sxb = findViewById(R.id.f11);
        this.swQ.setText(f.mK(0));
        this.swH = new b();
        this.swL = (TextView) findViewById(R.id.f10);
        this.swR = (TextView) findViewById(R.id.f13);
        this.swS = (TextView) findViewById(R.id.f12);
        this.swI = (ImageButton) findViewById(R.id.aun);
        this.swI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25652);
                aw.ZK();
                if (!c.isSDCardAvailable()) {
                    t.hO(VideoRecorderUI.this);
                    AppMethodBeat.o(25652);
                } else if (VideoRecorderUI.this.swK) {
                    VideoRecorderUI.d(VideoRecorderUI.this);
                    AppMethodBeat.o(25652);
                } else if (VideoRecorderUI.this.swJ) {
                    h.a(VideoRecorderUI.this, VideoRecorderUI.this.getString(R.string.f1o), VideoRecorderUI.this.getString(R.string.tz), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(25651);
                            VideoRecorderUI.this.swI.setImageResource(R.drawable.aqo);
                            VideoRecorderUI.n(VideoRecorderUI.this);
                            AppMethodBeat.o(25651);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(25652);
                } else {
                    VideoRecorderUI.this.swI.setImageResource(R.drawable.aqo);
                    VideoRecorderUI.n(VideoRecorderUI.this);
                    AppMethodBeat.o(25652);
                }
            }
        });
        if (d.getNumberOfCameras() > 1) {
            this.swU.setVisibility(0);
        } else {
            this.swU.setVisibility(4);
        }
        this.swU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25653);
                VideoRecorderUI.this.swU.setEnabled(false);
                VideoRecorderUI.this.oHR.sendEmptyMessageDelayed(0, 3000);
                VideoRecorderUI.this.swW = true;
                VideoRecorderUI.this.swH.diG();
                if (!(VideoRecorderUI.this.swH.b(VideoRecorderUI.this, VideoRecorderUI.this.swW) == 0 && VideoRecorderUI.this.swH.b(VideoRecorderUI.this.swG) == 0)) {
                    VideoRecorderUI.s(VideoRecorderUI.this);
                }
                AppMethodBeat.o(25653);
            }
        });
        this.swO = (ImageButton) findViewById(R.id.f14);
        this.swN = (ImageView) findViewById(R.id.f0v);
        this.swO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(25655);
                Intent intent = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
                intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.this.swH.filename);
                intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.this.swH.qBs.fXd);
                intent.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.this.swH.fileSize);
                intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.this.talker);
                intent.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.this.swB);
                VideoRecorderUI.this.startActivityForResult(intent, 0);
                VideoRecorderUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(25655);
            }
        });
        b bVar = this.swH;
        if (this.qhS) {
            i = 0;
        } else {
            i = 1;
        }
        String str = this.videoPath;
        String str2 = this.swB;
        String str3 = this.swY;
        String str4 = this.swZ;
        bVar.fVl = 0;
        if (1 == bVar.fVl) {
            bVar.qBs = com.tencent.mm.pluginsdk.i.a.diF();
        } else {
            bVar.qBs = com.tencent.mm.pluginsdk.i.a.diE();
        }
        if (com.tencent.mm.compatible.e.q.ete.etU) {
            bVar.qBs.ouT = com.tencent.mm.compatible.e.q.ete.mVideoHeight;
            bVar.qBs.ouU = com.tencent.mm.compatible.e.q.ete.mVideoWidth;
            bVar.qBs.ouS = com.tencent.mm.compatible.e.q.ete.etW;
        }
        bVar.filename = str4;
        bVar.qBs.ovb = str2;
        bVar.qBs.ouZ = str3;
        bVar.qBs.ouY = str + "temp.pcm";
        bVar.qBs.ouX = str + "temp.yuv";
        bVar.qBs.ova = str + "temp.vid";
        bVar.qBs.ovd = d.getNumberOfCameras();
        com.tencent.mm.pluginsdk.i.a aVar = bVar.qBs;
        if (i == 0) {
            i2 = 0;
        }
        aVar.rotate = i2;
        bVar.qBs.fXd = 0;
        bVar.vfT = new g();
        AppMethodBeat.o(25661);
    }

    public final void dealContentView(View view) {
        AppMethodBeat.i(25662);
        ae.h(ae.a(getWindow(), null), this.mController.ylv);
        ((ViewGroup) this.mController.ylv.getParent()).removeView(this.mController.ylv);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.ylv, 0);
        AppMethodBeat.o(25662);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(25663);
        if (i == 4) {
            ab.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
            if (this.swK) {
                AppMethodBeat.o(25663);
                return true;
            }
            cDZ();
            AppMethodBeat.o(25663);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(25663);
        return onKeyDown;
    }

    private void cDZ() {
        AppMethodBeat.i(25664);
        if (this.swJ) {
            h.a((Context) this, getString(R.string.f1n), getString(R.string.tz), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(25656);
                    VideoRecorderUI.this.finish();
                    AppMethodBeat.o(25656);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(25664);
            return;
        }
        finish();
        AppMethodBeat.o(25664);
    }

    private void bHM() {
        AppMethodBeat.i(25665);
        getSupportActionBar().hide();
        this.swQ.setText(f.mK(0));
        this.sxa.setVisibility(8);
        this.sxb.setVisibility(8);
        this.swP.setVisibility(0);
        this.swJ = false;
        this.swM.setVisibility(0);
        this.swF.setVisibility(0);
        this.swL.setVisibility(8);
        this.swO.setVisibility(8);
        this.swQ.setText(f.mK(0));
        this.swN.setVisibility(8);
        this.swI.setEnabled(true);
        this.swU.setVisibility(0);
        AppMethodBeat.o(25665);
    }

    public void onResume() {
        AppMethodBeat.i(25666);
        if (!(this.swX || (this.swH.b(this, false) == 0 && this.swH.b(this.swG) == 0))) {
            cEa();
        }
        this.swX = false;
        ab.v("MicroMsg.VideoRecorderUI", "onResume");
        super.onResume();
        AppMethodBeat.o(25666);
    }

    public void onPause() {
        AppMethodBeat.i(25667);
        if (this.swK) {
            b bVar = this.swH;
            if (bVar.owh != null) {
                bVar.owh.stop();
                bVar.owh.release();
                bVar.owh = null;
            }
            bHM();
            this.swK = false;
            releaseWakeLock();
            this.swI.setImageResource(R.drawable.aqn);
            this.miP.stopTimer();
            this.swL.setVisibility(8);
            this.swM.setVisibility(0);
            this.swF.setVisibility(0);
        }
        this.swH.diG();
        ab.v("MicroMsg.VideoRecorderUI", "onPause");
        super.onPause();
        AppMethodBeat.o(25667);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(25668);
        if (i2 != -1) {
            AppMethodBeat.o(25668);
            return;
        }
        if (i == 0) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(25668);
    }

    private void cEa() {
        AppMethodBeat.i(25669);
        h.a((Context) this, (int) R.string.f11, (int) R.string.tz, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(25648);
                VideoRecorderUI.this.swH.diG();
                VideoRecorderUI.this.finish();
                AppMethodBeat.o(25648);
            }
        });
        AppMethodBeat.o(25669);
    }

    private void releaseWakeLock() {
        AppMethodBeat.i(25670);
        this.swF.setKeepScreenOn(false);
        AppMethodBeat.o(25670);
    }

    public final int getLayoutId() {
        AppMethodBeat.i(25671);
        this.qhS = d.Lt();
        if (this.qhS) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            setRequestedOrientation(0);
            AppMethodBeat.o(25671);
            return R.layout.b1i;
        }
        AppMethodBeat.o(25671);
        return R.layout.b1h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0206 A:{SYNTHETIC, Splitter:B:63:0x0206} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void d(VideoRecorderUI videoRecorderUI) {
        int i;
        Bitmap createVideoThumbnail;
        Throwable e;
        String str;
        TextView textView;
        CharSequence charSequence;
        AppMethodBeat.i(25672);
        videoRecorderUI.swK = false;
        videoRecorderUI.releaseWakeLock();
        videoRecorderUI.swI.setImageResource(R.drawable.aqn);
        videoRecorderUI.swI.setEnabled(false);
        videoRecorderUI.getString(R.string.tz);
        videoRecorderUI.ehJ = h.b((Context) videoRecorderUI, videoRecorderUI.getString(R.string.f0z, new Object[]{Integer.valueOf(0)}), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(25644);
                ab.d("MicroMsg.VideoRecorderUI", "tipDialog onCancel");
                if (VideoRecorderUI.this.swH != null) {
                    VideoRecorderUI.u(VideoRecorderUI.this);
                    VideoRecorderUI.this.swM.setVisibility(0);
                    VideoRecorderUI.this.swF.setVisibility(0);
                }
                AppMethodBeat.o(25644);
            }
        });
        long elapsedRealtime = SystemClock.elapsedRealtime() - videoRecorderUI.miD;
        videoRecorderUI.miP.stopTimer();
        videoRecorderUI.swL.setVisibility(8);
        videoRecorderUI.swJ = true;
        b bVar = videoRecorderUI.swH;
        if (bVar.owh != null) {
            try {
                bVar.owh.stop();
                bVar.owh.release();
            } catch (Exception e2) {
                ab.e("MicroMsg.SceneVideo", "video[tiger] video stop failed");
            }
            bVar.owh = null;
            bVar.qBs.fXd = (int) (elapsedRealtime / 1000);
            com.tencent.mm.pluginsdk.i.a aVar = bVar.qBs;
            if (bVar.qBs.fXd > 0) {
                i = bVar.qBs.fXd;
            } else {
                i = 1;
            }
            aVar.fXd = i;
            bVar.qBs.ovc = bVar.qBs.fXd * bVar.qBs.fps;
            if (!(!e.ct(bVar.qBs.ovb) || e.ct(bVar.qBs.ouZ) || bVar.context == null)) {
                if (com.tencent.mm.compatible.util.d.iW(8)) {
                    createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(bVar.qBs.ovb, 1);
                } else {
                    createVideoThumbnail = null;
                }
                if (createVideoThumbnail != null) {
                    try {
                        ab.d("MicroMsg.SceneVideo", "saveBitmapToImage " + bVar.qBs.ouZ);
                        f.a(createVideoThumbnail, CompressFormat.JPEG, bVar.qBs.ouZ, true);
                    } catch (Exception e3) {
                        ab.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                    }
                } else {
                    InputStream openRawResource;
                    try {
                        openRawResource = bVar.context.getResources().openRawResource(R.drawable.ad1);
                        try {
                            f.a(BitmapFactory.decodeStream(openRawResource), CompressFormat.JPEG, bVar.qBs.ouZ, true);
                            if (openRawResource != null) {
                                try {
                                    openRawResource.close();
                                } catch (Exception e32) {
                                    ab.printErrStackTrace("MicroMsg.SceneVideo", e32, "", new Object[0]);
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            try {
                                ab.printErrStackTrace("MicroMsg.SceneVideo", e, "", new Object[0]);
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Exception e322) {
                                        ab.printErrStackTrace("MicroMsg.SceneVideo", e322, "", new Object[0]);
                                    }
                                }
                                if (e.ct(bVar.qBs.ovb)) {
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
                                videoRecorderUI.swS.setText(f.mK(videoRecorderUI.swH.qBs.fXd));
                                videoRecorderUI.swM.setVisibility(8);
                                videoRecorderUI.swO.setVisibility(0);
                                videoRecorderUI.sxa.setVisibility(8);
                                videoRecorderUI.swU.setVisibility(8);
                                videoRecorderUI.swI.setVisibility(8);
                                videoRecorderUI.swI.setEnabled(true);
                                videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                                videoRecorderUI.getSupportActionBar().show();
                                AppMethodBeat.o(25672);
                            } catch (Throwable th) {
                                e = th;
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Exception e5) {
                                        ab.printErrStackTrace("MicroMsg.SceneVideo", e5, "", new Object[0]);
                                    }
                                }
                                AppMethodBeat.o(25672);
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
                        AppMethodBeat.o(25672);
                        throw e;
                    }
                }
            }
            if (e.ct(bVar.qBs.ovb)) {
                bVar.fileSize = e.cs(bVar.qBs.ovb);
            }
        }
        str = videoRecorderUI.swH.qBs.ouZ;
        if (str != null || str.length() <= 0) {
            createVideoThumbnail = null;
        } else {
            Bitmap i2 = BackwardSupportUtil.b.i(str.trim(), com.tencent.mm.bz.a.getDensity(videoRecorderUI));
            if (i2 != null) {
                i = i2.getWidth();
                int height = i2.getHeight();
                int b = BackwardSupportUtil.b.b((Context) videoRecorderUI, 224.0f);
                createVideoThumbnail = Bitmap.createScaledBitmap(i2, b, (int) (((float) height) / (((float) i) / ((float) b))), true);
                if (i2 != createVideoThumbnail) {
                    ab.i("MicroMsg.SceneVideo", "recycle bitmap:%s", i2.toString());
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
        videoRecorderUI.swS.setText(f.mK(videoRecorderUI.swH.qBs.fXd));
        videoRecorderUI.swM.setVisibility(8);
        videoRecorderUI.swO.setVisibility(0);
        videoRecorderUI.sxa.setVisibility(8);
        videoRecorderUI.swU.setVisibility(8);
        videoRecorderUI.swI.setVisibility(8);
        videoRecorderUI.swI.setEnabled(true);
        videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        videoRecorderUI.getSupportActionBar().show();
        AppMethodBeat.o(25672);
    }

    static /* synthetic */ void n(VideoRecorderUI videoRecorderUI) {
        AppMethodBeat.i(25674);
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
        videoRecorderUI.miP.ae(300, 300);
        videoRecorderUI.swF.setKeepScreenOn(true);
        b bVar = videoRecorderUI.swH;
        SurfaceHolder surfaceHolder = videoRecorderUI.swG;
        if (surfaceHolder == null) {
            ab.e("MicroMsg.SceneVideo", "start fail, holder is null");
            AppMethodBeat.o(25674);
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        bVar.vfU = 0;
        int i = bVar.qBs.fps;
        int i2 = 0;
        while (bVar.vfT != null) {
            Camera camera = bVar.vfT.erH.etv;
            if (surface == null || camera == null) {
                ab.e("MicroMsg.SceneVideo", "holder or cam is null ");
                AppMethodBeat.o(25674);
                return;
            }
            int i3 = com.tencent.mm.compatible.e.q.etn.esg == -1 ? i : com.tencent.mm.compatible.e.q.etn.esg;
            int cameraId = g.getCameraId();
            try {
                camera.unlock();
            } catch (Exception e) {
                ab.w("MicroMsg.SceneVideo", "exception in cam.unlock() [%s]", e.getMessage());
            }
            bVar.owh = new MediaRecorder();
            bVar.owh.setCamera(camera);
            bVar.owh.setAudioSource(5);
            bVar.owh.setVideoSource(1);
            bVar.owh.setOutputFormat(2);
            bVar.owh.setVideoSize(bVar.qBs.lZe, bVar.qBs.lZf);
            bVar.owh.setVideoEncoder(2);
            bVar.owh.setAudioEncoder(3);
            if (VERSION.SDK_INT > 7) {
                bVar.owh.setVideoEncodingBitRate(bVar.qBs.ouS);
            }
            try {
                if (com.tencent.mm.compatible.e.q.ete.etU) {
                    bVar.owh.setVideoFrameRate(com.tencent.mm.compatible.e.q.ete.etV);
                } else {
                    bVar.owh.setVideoFrameRate(i3);
                }
            } catch (Exception e2) {
                ab.d("MicroMsg.SceneVideo", "try set fps failed: ".concat(String.valueOf(i3)));
            }
            bVar.owh.setOutputFile(bVar.qBs.ovb);
            bVar.owh.setPreviewDisplay(surface);
            ab.d("MicroMsg.SceneVideo", "doStart camid[%s] params:\n%s", Integer.valueOf(cameraId), bVar.qBs.toString());
            if (cameraId == 0) {
                bVar.setOrientationHint(com.tencent.mm.compatible.e.q.etn.esa == -1 ? 90 : com.tencent.mm.compatible.e.q.etn.esa);
            } else {
                bVar.setOrientationHint(com.tencent.mm.compatible.e.q.etn.esb == -1 ? 270 : com.tencent.mm.compatible.e.q.etn.esb);
            }
            try {
                bVar.owh.prepare();
                bVar.owh.start();
                AppMethodBeat.o(25674);
                return;
            } catch (Exception e3) {
                ab.w("MicroMsg.SceneVideo", "exception in mediaRecorder[%s] doStartCount[%s]", e3.getMessage(), Integer.valueOf(bVar.vfU));
                ab.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                bVar.vfU++;
                if (bVar.vfU < 5) {
                    g gVar = bVar.vfT;
                    if (i2 < 0 || i2 >= gVar.vgf.size()) {
                        ab.d("MicroMsg.YuvReocrder", "ret fr ".concat(String.valueOf(i)));
                    } else {
                        ab.d("MicroMsg.YuvReocrder", "ret fr " + gVar.vgf.get(i2));
                        i = ((Integer) gVar.vgf.get(i2)).intValue();
                    }
                    i2++;
                } else {
                    AppMethodBeat.o(25674);
                    return;
                }
            }
        }
        ab.e("MicroMsg.SceneVideo", "yuvRecoder is null");
        AppMethodBeat.o(25674);
    }

    static /* synthetic */ void x(VideoRecorderUI videoRecorderUI) {
        int previewWidth;
        int previewHeight;
        AppMethodBeat.i(25677);
        LayoutParams layoutParams = (LayoutParams) videoRecorderUI.swF.getLayoutParams();
        DisplayMetrics displayMetrics = videoRecorderUI.getResources().getDisplayMetrics();
        if (videoRecorderUI.qhS) {
            previewWidth = videoRecorderUI.swH.getPreviewWidth();
            previewHeight = videoRecorderUI.swH.getPreviewHeight();
        } else {
            previewWidth = videoRecorderUI.swH.getPreviewHeight();
            previewHeight = videoRecorderUI.swH.getPreviewWidth();
        }
        ab.i("MicroMsg.VideoRecorderUI", "resizeLayout priveview[%d, %d], dm[%d, %d]", Integer.valueOf(previewWidth), Integer.valueOf(previewHeight), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        if (((float) previewWidth) / ((float) previewHeight) > ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels)) {
            ab.i("MicroMsg.VideoRecorderUI", "resizeLayout wider");
            previewHeight = (int) (((float) previewHeight) * (((float) displayMetrics.widthPixels) / ((float) previewWidth)));
            previewWidth = displayMetrics.widthPixels;
        } else {
            ab.i("MicroMsg.VideoRecorderUI", "resizeLayout higher");
            previewWidth = (int) ((((float) displayMetrics.heightPixels) / ((float) previewHeight)) * ((float) previewWidth));
            previewHeight = displayMetrics.heightPixels;
        }
        ab.i("MicroMsg.VideoRecorderUI", "resizeLayout width:%d, height:%d", Integer.valueOf(previewWidth), Integer.valueOf(previewHeight));
        layoutParams.width = previewWidth;
        layoutParams.height = previewHeight;
        videoRecorderUI.swF.setLayoutParams(layoutParams);
        AppMethodBeat.o(25677);
    }
}
