package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.s;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.i.b;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(19)
public class AlbumPreviewUI extends MMActivity implements c {
    static long start = 0;
    private String cEV;
    private ProgressDialog ehJ;
    private int ehv;
    private int gLP;
    private ServiceConnection ktl = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(21386);
            ab.i("MicroMsg.AlbumPreviewUI", "onServiceConnected");
            AlbumPreviewUI.this.mOG = com.tencent.mm.plugin.gallery.stub.a.a.B(iBinder);
            if (AlbumPreviewUI.this.mPj != null) {
                AlbumPreviewUI.this.mPj.mOG = AlbumPreviewUI.this.mOG;
            }
            AppMethodBeat.o(21386);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(21387);
            ab.i("MicroMsg.AlbumPreviewUI", "onServiceDisconnected");
            AlbumPreviewUI.this.mOG = null;
            AppMethodBeat.o(21387);
        }
    };
    private boolean kvs = false;
    private double latitude;
    private double longitude;
    private com.tencent.mm.plugin.gallery.stub.a mOG = null;
    private String mOL;
    private int mPA;
    private int mPB;
    boolean mPC = false;
    private int mPD = 0;
    private int mPE = 0;
    private long mPF = 0;
    private long mPG;
    private int mPH = -1;
    private String mPI;
    private b mPJ;
    private long mPK = -1;
    private com.tencent.mm.plugin.gallery.ui.a.a mPL = new com.tencent.mm.plugin.gallery.ui.a.a() {
        private OnClickListener mjE = new OnClickListener() {
            private void bCD() {
                AppMethodBeat.i(21400);
                String stringExtra = AlbumPreviewUI.this.getIntent().getStringExtra("to_user");
                String stringExtra2 = AlbumPreviewUI.this.getIntent().getStringExtra("file_name");
                String stringExtra3 = AlbumPreviewUI.this.getIntent().getStringExtra("video_path");
                String stringExtra4 = AlbumPreviewUI.this.getIntent().getStringExtra("video_full_path");
                String stringExtra5 = AlbumPreviewUI.this.getIntent().getStringExtra("video_thumb_path");
                try {
                    Intent intent = new Intent();
                    intent.setClassName(AlbumPreviewUI.this.mController.ylL.getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
                    intent.putExtra("VideoRecorder_ToUser", stringExtra);
                    intent.putExtra("VideoRecorder_FileName", stringExtra2);
                    intent.putExtra("VideoRecorder_VideoPath", stringExtra3);
                    intent.putExtra("VideoRecorder_VideoFullPath", stringExtra4);
                    intent.putExtra("VideoRecorder_VideoThumbPath", stringExtra5);
                    ab.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", intent);
                    AlbumPreviewUI.this.startActivityForResult(intent, 4371);
                    AppMethodBeat.o(21400);
                } catch (Exception e) {
                    ab.w("MicroMsg.AlbumPreviewUI", e.toString());
                    if (!(com.tencent.mm.r.a.bI(AlbumPreviewUI.this.mController.ylL) || com.tencent.mm.r.a.bH(AlbumPreviewUI.this.mController.ylL))) {
                        com.tencent.mm.compatible.j.b.s(AlbumPreviewUI.this.mController.ylL);
                    }
                    AppMethodBeat.o(21400);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.i(21401);
                ab.d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", Integer.valueOf(AlbumPreviewUI.this.mPD));
                if (AlbumPreviewUI.this.mPz) {
                    ab.w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
                    AppMethodBeat.o(21401);
                    return;
                }
                AlbumPreviewUI.K(AlbumPreviewUI.this);
                AlbumPreviewUI.this.mPz = true;
                if (e.bBZ().mOu != 2 && e.bBZ().hOZ != 13) {
                    if (e.bBZ().mOu == 1 || e.bBZ().mOu == 3) {
                        File file = new File(com.tencent.mm.compatible.util.e.euR);
                        if (file.exists() || file.mkdir()) {
                            ab.i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(AlbumPreviewUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")), bo.dpG(), AlbumPreviewUI.this.mController.ylL);
                            if (com.tencent.mm.pluginsdk.permission.b.a(AlbumPreviewUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                                AlbumPreviewUI.M(AlbumPreviewUI.this);
                            } else {
                                AppMethodBeat.o(21401);
                                return;
                            }
                        }
                        Toast.makeText(AlbumPreviewUI.this.mController.ylL, AlbumPreviewUI.this.getString(R.string.aor), 1).show();
                        AppMethodBeat.o(21401);
                        return;
                    }
                    AppMethodBeat.o(21401);
                } else if (AlbumPreviewUI.this.getIntent().getBooleanExtra("record_video_force_sys_camera", false)) {
                    int intExtra = AlbumPreviewUI.this.getIntent().getIntExtra("record_video_quality", 0);
                    int intExtra2 = AlbumPreviewUI.this.getIntent().getIntExtra("record_video_time_limit", 0);
                    n.a(AlbumPreviewUI.this.mController.ylL, AlbumPreviewUI.this.getIntent().getStringExtra("video_full_path"), 4372, intExtra2, intExtra, false);
                    AppMethodBeat.o(21401);
                } else if (AlbumPreviewUI.this.getIntent().getBooleanExtra("record_video_is_sight_capture", false)) {
                    if (((SightParams) AlbumPreviewUI.this.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS")) == null) {
                        ab.e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
                    }
                    if (e.bBZ().hOZ != 13) {
                        n.a(AlbumPreviewUI.this.mController.ylL, 4375, AlbumPreviewUI.this.getIntent(), 3, 1);
                        AppMethodBeat.o(21401);
                        return;
                    }
                    n.a(AlbumPreviewUI.this.mController.ylL, 4375, AlbumPreviewUI.this.getIntent(), 4, 1);
                    AppMethodBeat.o(21401);
                } else if (q.etn.erY == 2) {
                    bCD();
                    AppMethodBeat.o(21401);
                } else if (q.etn.erY != 1 || com.tencent.mm.r.a.bI(AlbumPreviewUI.this.mController.ylL) || com.tencent.mm.r.a.bH(AlbumPreviewUI.this.mController.ylL)) {
                    bCD();
                    AppMethodBeat.o(21401);
                } else {
                    com.tencent.mm.compatible.j.b.s(AlbumPreviewUI.this.mController.ylL);
                    AppMethodBeat.o(21401);
                }
            }
        };

        {
            AppMethodBeat.i(21402);
            AppMethodBeat.o(21402);
        }

        public final View getView() {
            AppMethodBeat.i(21403);
            View inflate = View.inflate(AlbumPreviewUI.this.mController.ylL, R.layout.ks, null);
            inflate.setOnClickListener(this.mjE);
            TextView textView = (TextView) inflate.findViewById(R.id.akx);
            if (e.bBZ().mOu == 2 || e.bBZ().hOZ == 13) {
                textView.setText(R.string.c4c);
            } else if (e.bBZ().mOu == 1) {
                textView.setText(R.string.c4b);
            }
            inflate.setLayerType(1, null);
            AppMethodBeat.o(21403);
            return inflate;
        }
    };
    private boolean mPM = false;
    private HashMap<String, Integer> mPN = new HashMap();
    private GridView mPe;
    private TextView mPf;
    private boolean mPg;
    private boolean mPh;
    private TextView mPi;
    private a mPj;
    private TextView mPk;
    private TextView mPl;
    private TextView mPm;
    private ImageFolderMgrView mPn;
    private TextView mPo;
    private ImageButton mPp;
    private String mPq;
    private String mPr;
    private int mPs;
    private String mPt;
    private boolean mPu = false;
    private boolean mPv = false;
    private boolean mPw = false;
    private boolean mPx = false;
    private boolean mPy = false;
    private boolean mPz = false;
    private String toUser;

    static class a implements Runnable {
        public WeakReference<a> mPW;
        public WeakReference<ProgressDialog> mPX;
        public WeakReference<TextView> mPY;
        public WeakReference<GridView> mPZ;
        public LinkedList<MediaItem> mQa;
        public WeakReference<String> mQb;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(21415);
            String str = "MicroMsg.AlbumPreviewUI";
            String str2 = "on NotifyMediaItemsChanged, size %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.mQa == null ? -1 : this.mQa.size());
            ab.d(str, str2, objArr);
            if (this.mPW == null) {
                ab.w("MicroMsg.AlbumPreviewUI", "null == adapterRef");
                AppMethodBeat.o(21415);
                return;
            }
            a aVar = (a) this.mPW.get();
            if (aVar == null) {
                ab.w("MicroMsg.AlbumPreviewUI", "null == adapter");
                AppMethodBeat.o(21415);
                return;
            }
            AlbumPreviewUI.W(this.mQa);
            LinkedList linkedList = this.mQa;
            if (aVar.mOO) {
                aVar.mOO = false;
                aVar.mOH.clear();
            }
            aVar.mOH.addAll(linkedList);
            aVar.notifyDataSetChanged();
            if (this.mPX == null) {
                AppMethodBeat.o(21415);
                return;
            }
            ProgressDialog progressDialog = (ProgressDialog) this.mPX.get();
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                ab.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start));
            }
            if (this.mPY == null || this.mPZ == null || this.mQb == null) {
                AppMethodBeat.o(21415);
                return;
            }
            final TextView textView = (TextView) this.mPY.get();
            GridView gridView = (GridView) this.mPZ.get();
            String str3 = (String) this.mQb.get();
            if (!(textView == null || gridView == null || str3 == null)) {
                String wt = aVar.wt(gridView.getFirstVisiblePosition());
                if (!bo.isNullOrNil(wt) && wt.equals("album_business_bubble_media_by_coordinate")) {
                    textView.setVisibility(0);
                    textView.setText(str3 + "附近的照片和视频");
                    textView.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(21414);
                            if (8 == textView.getVisibility()) {
                                AppMethodBeat.o(21414);
                                return;
                            }
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            alphaAnimation.setDuration(300);
                            textView.clearAnimation();
                            textView.startAnimation(alphaAnimation);
                            textView.setVisibility(8);
                            AppMethodBeat.o(21414);
                        }
                    }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                }
            }
            AppMethodBeat.o(21415);
        }

        public final String toString() {
            AppMethodBeat.i(21416);
            String str = super.toString() + "|notifyRunnable";
            AppMethodBeat.o(21416);
            return str;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AlbumPreviewUI() {
        AppMethodBeat.i(21417);
        AppMethodBeat.o(21417);
    }

    static /* synthetic */ int K(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mPD + 1;
        albumPreviewUI.mPD = i;
        return i;
    }

    static /* synthetic */ void M(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.i(21445);
        albumPreviewUI.bCz();
        AppMethodBeat.o(21445);
    }

    static /* synthetic */ int x(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mPE + 1;
        albumPreviewUI.mPE = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21418);
        super.onCreate(bundle);
        this.mPG = System.currentTimeMillis();
        ab.i("MicroMsg.AlbumPreviewUI", "onCreate");
        if (bundle != null) {
            ab.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
            this.mPB = bundle.getInt("constants_key");
            e.bBZ().hOZ = this.mPB;
        }
        Nb(this.mController.ylL.getResources().getColor(R.color.l8));
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        start = System.currentTimeMillis();
        int intExtra = getIntent().getIntExtra("query_source_type", 3);
        int intExtra2 = getIntent().getIntExtra("query_media_type", 1);
        ab.i("MicroMsg.AlbumPreviewUI", "query souce: " + intExtra + ", queryType: " + intExtra2);
        e.bBZ().wq(intExtra2);
        e.bBZ().hOZ = intExtra;
        initView();
        e.bBZ().mOr.add(this);
        this.mPK = System.currentTimeMillis();
        l bBZ = e.bBZ();
        bBZ.g(this.mPr, bBZ.mOu, this.mPK);
        bindService(new Intent(this.mController.ylL, GalleryStubService.class), this.ktl, 1);
        o.JV(1);
        AppMethodBeat.o(21418);
    }

    public void onPause() {
        AppMethodBeat.i(21419);
        super.onPause();
        ab.i("MicroMsg.AlbumPreviewUI", "on resume");
        this.mPz = true;
        ab.d("MicroMsg.AlbumPreviewUI", "shouldSaveLastChoosePath: " + this.mPv);
        if (this.mPv) {
            bCA();
        }
        if (this.mPn.aej) {
            ImageFolderMgrView imageFolderMgrView = this.mPn;
            if (!imageFolderMgrView.aej) {
                ab.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
            } else if (imageFolderMgrView.mQE) {
                ab.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
            } else {
                imageFolderMgrView.mQA.setVisibility(8);
                imageFolderMgrView.aej = false;
            }
        }
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, this.ehv);
        this.ehv = 0;
        AppMethodBeat.o(21419);
    }

    public void onResume() {
        AppMethodBeat.i(21420);
        super.onResume();
        ab.i("MicroMsg.AlbumPreviewUI", "on resume");
        this.mPz = false;
        AppMethodBeat.o(21420);
    }

    public void onDestroy() {
        AppMethodBeat.i(21421);
        super.onDestroy();
        ab.i("MicroMsg.AlbumPreviewUI", "onDestroy");
        e.bBZ().b(this.mPn);
        e.bCa().bCp();
        e.bCa().bCo().removeCallbacksAndMessages(null);
        e.bBZ().mOr.remove(this);
        l bBZ = e.bBZ();
        b bVar = this.mPJ;
        if (bVar != null) {
            bBZ.mOs.remove(bVar);
        }
        if (this.mPD > 0 || this.mPE > 0) {
            ab.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", Integer.valueOf(this.mPD), Integer.valueOf(this.mPE));
            try {
                this.mOG.aK(11187, this.mPD + "," + this.mPE);
            } catch (Exception e) {
                ab.e("MicroMsg.AlbumPreviewUI", "report error, %s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
        } else {
            ab.w("MicroMsg.AlbumPreviewUI", "do not click camera or folder!");
        }
        try {
            boolean z;
            if (this.mPF > 0 || this.mPh) {
                e.a(this.mOG, this.mPt, D(this.mPj.mOI), this.kvs, this.mPg);
            }
            com.tencent.mm.plugin.gallery.stub.a aVar = this.mOG;
            int size = this.mPj.mOI.size();
            boolean z2 = this.kvs;
            if (this.mPF > 0 || this.mPh) {
                z = true;
            } else {
                z = false;
            }
            e.a(aVar, size, z2, z);
        } catch (RemoteException e2) {
            ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
        }
        s.ccQ.Ae().Ad();
        e.bCc().clear();
        e.bCd().clear();
        e.bCe().clear();
        try {
            unbindService(this.ktl);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", th, "Failed to unbindService when Activity.onDestroy is invoked.", new Object[0]);
        }
        o.JV(2);
        e.bBY().b(null);
        AppMethodBeat.o(21421);
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(21422);
        this.mPB = e.bBZ().hOZ;
        bundle.putInt("constants_key", this.mPB);
        AppMethodBeat.o(21422);
    }

    public final int getLayoutId() {
        return R.layout.apm;
    }

    private void updateTitle() {
        AppMethodBeat.i(21423);
        if (e.bBZ().mOu == 3) {
            setMMTitle((int) R.string.c34);
            this.mPi.setText(R.string.c34);
            AppMethodBeat.o(21423);
        } else if (e.bBZ().mOu == 1) {
            setMMTitle((int) R.string.c48);
            this.mPi.setText(R.string.c33);
            AppMethodBeat.o(21423);
        } else {
            setMMTitle((int) R.string.c35);
            this.mPi.setText(R.string.c35);
            AppMethodBeat.o(21423);
        }
    }

    private static int[] D(ArrayList<MediaItem> arrayList) {
        AppMethodBeat.i(21424);
        int[] iArr = new int[4];
        iArr[0] = arrayList.size();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem != null) {
                if (!bo.isNullOrNil(mediaItem.mMimeType) && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                    iArr[2] = iArr[2] + 1;
                } else if (mediaItem.getType() == 2) {
                    iArr[3] = iArr[3] + 1;
                } else if (mediaItem.getType() == 1) {
                    iArr[1] = iArr[1] + 1;
                }
            }
        }
        AppMethodBeat.o(21424);
        return iArr;
    }

    private void a(AlbumItem albumItem) {
        AppMethodBeat.i(21425);
        if (albumItem == null) {
            AppMethodBeat.o(21425);
        } else if (bo.bc(this.mPr, "").equals(albumItem.mOh)) {
            ab.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
            AppMethodBeat.o(21425);
        } else {
            e.bCe().addAll(this.mPj.mOI);
            ab.d("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", albumItem.mOh, albumItem.Wy());
            this.mPq = albumItem.Wy();
            this.mPr = albumItem.mOh;
            if (albumItem.oqq != null) {
                this.mPs = albumItem.oqq.getType();
            }
            if (bo.isNullOrNil(this.mPq)) {
                ab.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
                this.mPq = this.mPr;
            }
            if (bo.isNullOrNil(this.mPr)) {
                if (getIntent().getBooleanExtra("show_header_view", true)) {
                    this.mPj.a(this.mPL);
                }
                updateTitle();
                this.mPs = e.bBZ().mOu;
            } else {
                a aVar = this.mPj;
                com.tencent.mm.plugin.gallery.ui.a.a aVar2 = this.mPL;
                if (aVar2 == null) {
                    ab.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
                } else {
                    aVar.mOM.remove(aVar2);
                }
                this.mPi.setText(this.mPr);
            }
            this.mPj.mOH.clear();
            wu(this.mPj.mOI.size());
            this.mPj.notifyDataSetChanged();
            if (this.ehJ != null) {
                this.ehJ.dismiss();
            }
            getString(R.string.tz);
            this.ehJ = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            start = System.currentTimeMillis();
            String str = this.mPr;
            if (albumItem.oqq == null) {
                AppMethodBeat.o(21425);
                return;
            }
            int type = albumItem.oqq.getType();
            ab.i("MicroMsg.AlbumPreviewUI", "folder type[%d] queryType[%d]", Integer.valueOf(type), Integer.valueOf(e.bBZ().mOu));
            if (e.bBZ().mOu != 2 && albumItem.oqq.getType() == 2) {
                str = "";
            }
            if (bo.isNullOrNil(albumItem.mOh)) {
                type = 3;
            }
            this.mPK = System.currentTimeMillis();
            e.bBZ().g(str, type, this.mPK);
            AppMethodBeat.o(21425);
        }
    }

    public final void V(int i, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(21426);
        switch (e.bBZ().mOu) {
            case 3:
                if (!(bo.isNullOrNil(this.cEV) || "medianote".equals(this.toUser))) {
                    if (bo.yz() - this.mPF >= 1000) {
                        ab.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                        MediaItem mediaItem = (MediaItem) this.mPj.mOH.get(i);
                        if (mediaItem.getType() != 2) {
                            try {
                                com.tencent.mm.plugin.gallery.stub.a aVar = this.mOG;
                                String str = mediaItem.fPT;
                                String str2 = this.toUser;
                                if (!this.mPu) {
                                    if (this.kvs) {
                                        z2 = false;
                                    }
                                }
                                aVar.a(str, str2, z2, 0, z);
                                AppMethodBeat.o(21426);
                                return;
                            } catch (Exception e) {
                                break;
                            }
                        }
                    }
                    ab.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                    AppMethodBeat.o(21426);
                    return;
                }
                break;
        }
        AppMethodBeat.o(21426);
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.i(21427);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                ab.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", str, extras.get(str));
            }
        } else {
            ab.e("MicroMsg.AlbumPreviewUI", "initView, oops! no extras data!");
        }
        this.mOL = getIntent().getStringExtra("album_business_tag");
        this.gLP = getIntent().getIntExtra("album_video_max_duration", 10);
        this.cEV = getIntent().getStringExtra("GalleryUI_FromUser");
        this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
        this.mPA = getIntent().getIntExtra("max_select_count", 9);
        this.mPu = e.bBZ().hOZ == 4;
        if (e.bBZ().hOZ == 5) {
            z = true;
        } else {
            z = false;
        }
        this.mPw = z;
        if (e.bBZ().hOZ == 9) {
            z = true;
        } else {
            z = false;
        }
        this.mPx = z;
        this.mPq = getIntent().getStringExtra("folder_path");
        this.mPr = getIntent().getStringExtra("folder_name");
        if (bo.isNullOrNil(this.mPq)) {
            ab.e("MicroMsg.AlbumPreviewUI", "get folder path failed");
            this.mPq = this.mPr;
        }
        this.kvs = getIntent().getBooleanExtra("key_send_raw_image", false);
        this.mPy = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
        this.mPo = (TextView) findViewById(R.id.avs);
        this.mPp = (ImageButton) findViewById(R.id.avr);
        this.mPo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21408);
                AlbumPreviewUI.this.mPp.performClick();
                AppMethodBeat.o(21408);
            }
        });
        if (e.bBZ().hOZ == 3) {
            this.mPp.setVisibility(0);
            this.mPo.setVisibility(0);
        } else {
            this.mPp.setVisibility(8);
            this.mPo.setVisibility(8);
        }
        if (this.kvs) {
            this.mPp.setImageResource(R.raw.radio_on);
        } else {
            this.mPp.setImageResource(R.raw.radio_off);
        }
        this.mPp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21409);
                AlbumPreviewUI.this.kvs = !AlbumPreviewUI.this.kvs;
                AlbumPreviewUI.e(AlbumPreviewUI.this);
                AlbumPreviewUI.this.mPo.setText(AlbumPreviewUI.this.mController.ylL.getString(R.string.c3i) + "");
                if (AlbumPreviewUI.this.kvs) {
                    AlbumPreviewUI.this.mPp.setImageResource(R.raw.radio_on);
                } else {
                    AlbumPreviewUI.this.mPp.setImageResource(R.raw.radio_off);
                }
                AlbumPreviewUI.g(AlbumPreviewUI.this);
                AppMethodBeat.o(21409);
            }
        });
        this.mPk = (TextView) findViewById(R.id.bqy);
        this.mPl = (TextView) findViewById(R.id.e5q);
        this.mPm = (TextView) findViewById(R.id.e5r);
        this.mPf = (TextView) findViewById(R.id.e5w);
        if (e.bBZ().hOZ == 0 || e.bBZ().hOZ == 5 || e.bBZ().hOZ == 10 || e.bBZ().hOZ == 11 || e.bBZ().hOZ == 14) {
            findViewById(R.id.e5v).setVisibility(8);
            this.mPf.setVisibility(8);
        } else {
            this.mPf.setVisibility(0);
            this.mPf.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(21410);
                    AlbumPreviewUI.this.mPg = true;
                    Intent intent = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                    e.B(AlbumPreviewUI.this.mPj.mOH);
                    intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mPj.bCw());
                    intent.putExtra("max_select_count", AlbumPreviewUI.this.mPA);
                    intent.putExtra("send_raw_img", AlbumPreviewUI.this.kvs);
                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                    AlbumPreviewUI.this.startActivityForResult(intent, 0);
                    AppMethodBeat.o(21410);
                }
            });
            if ((e.bBZ().mOu == 1 || e.bBZ().mOu == 2 || e.bBZ().mOu == 3) && this.mPA > 0) {
                AnonymousClass16 anonymousClass16 = new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        boolean z = false;
                        AppMethodBeat.i(21411);
                        ab.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", Integer.valueOf(e.bCg()), Boolean.valueOf(AlbumPreviewUI.this.mPu));
                        try {
                            AlbumPreviewUI.this.mOG.aK(11610, (AlbumPreviewUI.this.mPu ? 3 : 2) + "," + e.bCg());
                        } catch (Exception e) {
                            ab.e("MicroMsg.AlbumPreviewUI", "report error, %s", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                        }
                        if (AlbumPreviewUI.this.mPH < 0) {
                            try {
                                AlbumPreviewUI.this.mPH = AlbumPreviewUI.this.mOG.Nd();
                            } catch (Exception e2) {
                                AlbumPreviewUI.this.mPH = 26214400;
                                ab.e("MicroMsg.AlbumPreviewUI", "getMaxSendVideoSize error, %s", e2.getMessage());
                                ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
                            }
                        }
                        e.bCf();
                        if (AlbumPreviewUI.this.mPj.bCw().size() == 0) {
                            ab.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
                            AlbumPreviewUI.this.setResult(-2);
                            AlbumPreviewUI.this.finish();
                            AppMethodBeat.o(21411);
                        } else {
                            Intent intent = new Intent();
                            int i = e.bBZ().mOu;
                            if (AlbumPreviewUI.this.mPu) {
                                i = 1;
                            }
                            if (AlbumPreviewUI.this.mPy) {
                                i = 1;
                            }
                            ArrayList arrayList;
                            MediaItem mediaItem;
                            ArrayList arrayList2;
                            ArrayList arrayList3;
                            Iterator it;
                            if (i == 1) {
                                String str = "CropImage_Compress_Img";
                                boolean z2 = AlbumPreviewUI.this.mPu ? true : !AlbumPreviewUI.this.kvs;
                                intent.putExtra(str, z2);
                                arrayList = AlbumPreviewUI.this.mPj.mOI;
                                ArrayList arrayList4 = new ArrayList();
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    mediaItem = (MediaItem) it2.next();
                                    if (!mediaItem.mMimeType.equals("edit") || bo.isNullOrNil(mediaItem.mOj)) {
                                        arrayList4.add(mediaItem.fPT);
                                    } else {
                                        arrayList4.add(mediaItem.mOj);
                                    }
                                }
                                intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList4);
                                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.this.mPG);
                                AlbumPreviewUI.this.mPG = 0;
                                AlbumPreviewUI.this.setResult(-1, intent);
                                AlbumPreviewUI.this.mPv = true;
                                if (bo.isNullOrNil(AlbumPreviewUI.this.cEV) || "medianote".equals(AlbumPreviewUI.this.toUser)) {
                                    AlbumPreviewUI.this.finish();
                                } else if (bo.yz() - AlbumPreviewUI.this.mPF < 1000) {
                                    ab.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                                    AppMethodBeat.o(21411);
                                } else {
                                    ab.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                                    AlbumPreviewUI.this.mPF = bo.yz();
                                    intent.setClassName(AlbumPreviewUI.this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                                    AlbumPreviewUI.this.startActivityForResult(intent, 4373);
                                }
                            } else if (i == 2) {
                                ab.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
                                if (AlbumPreviewUI.this.getIntent().getBooleanExtra("GalleryUI_SkipVideoSizeLimit", false)) {
                                    i = 0;
                                } else {
                                    com.tencent.mm.pluginsdk.ui.c.a ajK = com.tencent.mm.pluginsdk.ui.c.a.ajK((String) AlbumPreviewUI.this.mPj.bCw().get(0));
                                    ajK.mSize = AlbumPreviewUI.this.mPH;
                                    i = ajK.aAa();
                                }
                                if (i == 0) {
                                    intent.setData(Uri.fromFile(new File((String) AlbumPreviewUI.this.mPj.bCw().get(0))));
                                    intent.putStringArrayListExtra("key_select_video_list", AlbumPreviewUI.this.mPj.bCw());
                                    AlbumPreviewUI.this.setResult(-1, intent);
                                    AlbumPreviewUI.this.mPv = true;
                                    AlbumPreviewUI.this.finish();
                                } else if (i == 2) {
                                    AlbumPreviewUI.s(AlbumPreviewUI.this);
                                    AppMethodBeat.o(21411);
                                } else {
                                    AlbumPreviewUI.t(AlbumPreviewUI.this);
                                    AppMethodBeat.o(21411);
                                }
                            } else if (i != 3) {
                                ab.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
                                AlbumPreviewUI.this.setResult(-2);
                                AlbumPreviewUI.this.finish();
                            } else if (!bo.isNullOrNil(AlbumPreviewUI.this.mOL) && AlbumPreviewUI.this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                                arrayList = AlbumPreviewUI.this.mPj.mOI;
                                arrayList2 = new ArrayList();
                                arrayList3 = new ArrayList();
                                it = arrayList.iterator();
                                while (it.hasNext()) {
                                    mediaItem = (MediaItem) it.next();
                                    if (mediaItem.getType() == 1) {
                                        if (!mediaItem.mMimeType.equals("edit") || bo.isNullOrNil(mediaItem.mOj)) {
                                            arrayList3.add(mediaItem.fPT);
                                        } else {
                                            arrayList3.add(mediaItem.mOj);
                                        }
                                    } else if (mediaItem.getType() == 2) {
                                        arrayList2.add(mediaItem.fPT);
                                    }
                                }
                                intent.putExtra("CropImage_Compress_Img", false);
                                intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList3);
                                intent.putStringArrayListExtra("key_select_video_list", arrayList2);
                                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.this.mPG);
                                intent.putExtra("longitude", AlbumPreviewUI.this.longitude);
                                intent.putExtra("latitude", AlbumPreviewUI.this.latitude);
                                AlbumPreviewUI.this.mPG = 0;
                                AlbumPreviewUI.this.setResult(-1, intent);
                                AlbumPreviewUI.this.finish();
                                AppMethodBeat.o(21411);
                            } else if (bo.yz() - AlbumPreviewUI.this.mPF < 1000) {
                                ab.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                                AppMethodBeat.o(21411);
                            } else {
                                AlbumPreviewUI.this.mPF = bo.yz();
                                arrayList = AlbumPreviewUI.this.mPj.mOI;
                                arrayList2 = new ArrayList();
                                arrayList3 = new ArrayList();
                                it = arrayList.iterator();
                                while (it.hasNext()) {
                                    mediaItem = (MediaItem) it.next();
                                    if (mediaItem.getType() == 1) {
                                        if (!mediaItem.mMimeType.equals("edit") || bo.isNullOrNil(mediaItem.mOj)) {
                                            arrayList3.add(mediaItem.fPT);
                                        } else {
                                            arrayList3.add(mediaItem.mOj);
                                        }
                                    } else if (mediaItem.getType() == 2) {
                                        arrayList2.add(mediaItem.fPT);
                                    }
                                }
                                String str2 = "CropImage_Compress_Img";
                                if (AlbumPreviewUI.this.mPu) {
                                    z = true;
                                } else if (!AlbumPreviewUI.this.kvs) {
                                    z = true;
                                }
                                intent.putExtra(str2, z);
                                intent.putStringArrayListExtra("key_select_video_list", arrayList2);
                                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - AlbumPreviewUI.this.mPG);
                                AlbumPreviewUI.this.mPG = 0;
                                if (arrayList3.size() > 0) {
                                    intent.setClassName(AlbumPreviewUI.this, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList3);
                                    intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                                    intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                                    intent.putExtra("CropImage_limit_Img_Size", 26214400);
                                    ab.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                                    AlbumPreviewUI.this.startActivityForResult(intent, 4373);
                                } else {
                                    ab.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
                                    AlbumPreviewUI.this.setResult(-1, intent);
                                    AlbumPreviewUI.this.finish();
                                }
                            }
                            AppMethodBeat.o(21411);
                        }
                        return true;
                    }
                };
                if (!bo.isNullOrNil(this.mPt)) {
                    addTextOptionMenu(0, this.mPt, anonymousClass16);
                } else if (e.bBZ().hOZ != 14) {
                    a(0, wv(0), (OnMenuItemClickListener) anonymousClass16, com.tencent.mm.ui.q.b.GREEN);
                }
            }
        }
        this.mPn = (ImageFolderMgrView) findViewById(R.id.e5x);
        ImageFolderMgrView imageFolderMgrView = this.mPn;
        e.bBZ().b(imageFolderMgrView);
        e.bBZ().a(imageFolderMgrView);
        e.bBZ().bCu();
        this.mPn.setListener(new com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.a() {
            public final void b(AlbumItem albumItem) {
                AppMethodBeat.i(21412);
                AlbumPreviewUI.a(AlbumPreviewUI.this, albumItem);
                AppMethodBeat.o(21412);
            }
        });
        this.mPt = getIntent().getStringExtra("send_btn_string");
        findViewById(R.id.e5t).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21413);
                AlbumPreviewUI.x(AlbumPreviewUI.this);
                AlbumPreviewUI.this.mPn.bCE();
                ab.d("MicroMsg.AlbumPreviewUI", "click folder times[%d]", Integer.valueOf(AlbumPreviewUI.this.mPE));
                AppMethodBeat.o(21413);
            }
        });
        this.mPi = (TextView) findViewById(R.id.e5u);
        if (this.mPw) {
            showOptionMenu(false);
        }
        enableOptionMenu(false);
        this.mPe = (GridView) findViewById(R.id.e5p);
        this.mPe.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                AppMethodBeat.i(21389);
                final MediaItem ws = AlbumPreviewUI.this.mPj.ws(i);
                String str;
                Intent intent;
                Intent intent2;
                ArrayList wr;
                AlbumPreviewUI albumPreviewUI;
                if (ws == null || bo.isNullOrNil(ws.fPT)) {
                    str = "MicroMsg.AlbumPreviewUI";
                    String str2 = "item is null %s, item original path is null";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(ws == null);
                    ab.w(str, str2, objArr);
                    AppMethodBeat.o(21389);
                } else if (e.bBZ().hOZ == 0 || e.bBZ().hOZ == 5 || e.bBZ().hOZ == 10 || e.bBZ().hOZ == 11) {
                    if (e.bBZ().mOu == 2) {
                        h.a(AlbumPreviewUI.this, true, AlbumPreviewUI.this.getString(R.string.c4a), "", AlbumPreviewUI.this.getString(R.string.tf), AlbumPreviewUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(21388);
                                if (ws == null) {
                                    ab.w("MicroMsg.AlbumPreviewUI", "get item for video error, null, position %d", Integer.valueOf(i));
                                    AlbumPreviewUI.this.setResult(0);
                                } else {
                                    ab.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
                                    Intent intent = new Intent();
                                    intent.setData(Uri.parse("file://" + Uri.encode(ws.fPT)));
                                    AlbumPreviewUI.this.setResult(-1, intent);
                                }
                                AlbumPreviewUI.this.finish();
                                AppMethodBeat.o(21388);
                            }
                        }, null);
                        AppMethodBeat.o(21389);
                        return;
                    }
                    if (ws == null) {
                        ab.w("MicroMsg.AlbumPreviewUI", "get item error, null, position %d", Integer.valueOf(i));
                        AlbumPreviewUI.this.setResult(0);
                    } else {
                        intent = new Intent();
                        if (ws.getType() == 2) {
                            intent.putExtra("is_video", true);
                            intent.putExtra("video_full_path", ws.fPT);
                        }
                        if (e.bBZ().hOZ == 10) {
                            intent.putExtra("CropImage_OutputPath", ws.fPT);
                        }
                        intent.setData(Uri.parse(Uri.encode(ws.fPT)));
                        ab.i("MicroMsg.AlbumPreviewUI", "getItem ok");
                        AlbumPreviewUI.this.setResult(-1, intent);
                    }
                    AlbumPreviewUI.this.finish();
                    AppMethodBeat.o(21389);
                } else if (e.bBZ().hOZ != 4) {
                    if (e.bBZ().hOZ == 14) {
                        if (i < AlbumPreviewUI.this.mPj.mOM.size()) {
                            ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                            AppMethodBeat.o(21389);
                            return;
                        } else if (ws == null) {
                            ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                            AppMethodBeat.o(21389);
                            return;
                        } else if (ws.getType() == 2 && AlbumPreviewUI.this.mPj.mOI.size() != 0) {
                            h.bQ(AlbumPreviewUI.this.mController.ylL, com.tencent.mm.bz.a.an(AlbumPreviewUI.this.mController.ylL, R.string.c3b));
                            AppMethodBeat.o(21389);
                            return;
                        } else if (ws instanceof VideoMediaItem) {
                            VideoMediaItem videoMediaItem = (VideoMediaItem) ws;
                            int i2 = videoMediaItem.eXL;
                            if (i2 == 0 || i2 == 180) {
                                if (videoMediaItem.videoWidth >= videoMediaItem.videoHeight) {
                                    ab.i("MicroMsg.AlbumPreviewUI", "select story video, video ratio error, width:%s, height:%s, rotate:%s", Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(i2));
                                    com.tencent.mm.plugin.report.service.h.pYm.k(1005, 52, 1);
                                    h.bQ(AlbumPreviewUI.this.mController.ylL, com.tencent.mm.bz.a.an(AlbumPreviewUI.this.mController.ylL, R.string.c3o));
                                    AppMethodBeat.o(21389);
                                    return;
                                }
                            } else if ((i2 == 270 || i2 == 90) && videoMediaItem.videoHeight >= videoMediaItem.videoWidth) {
                                ab.i("MicroMsg.AlbumPreviewUI", "select story video, video ratio error, width:%s, height:%s, rotate:%s", Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(i2));
                                com.tencent.mm.plugin.report.service.h.pYm.k(1005, 52, 1);
                                h.bQ(AlbumPreviewUI.this.mController.ylL, com.tencent.mm.bz.a.an(AlbumPreviewUI.this.mController.ylL, R.string.c3o));
                                AppMethodBeat.o(21389);
                                return;
                            }
                            if (videoMediaItem.fPW <= 2000) {
                                ab.i("MicroMsg.AlbumPreviewUI", "select story video, duration too long, duration:%s", Integer.valueOf(videoMediaItem.fPW));
                                com.tencent.mm.plugin.report.service.h.pYm.k(1005, 53, 1);
                                h.bQ(AlbumPreviewUI.this.mController.ylL, com.tencent.mm.bz.a.an(AlbumPreviewUI.this.mController.ylL, R.string.c3u));
                                AppMethodBeat.o(21389);
                                return;
                            }
                            if (videoMediaItem.videoFrameRate <= 1 && videoMediaItem.videoFrameRate >= 0) {
                                ab.i("MicroMsg.AlbumPreviewUI", "select story video, videoFrameRate too small:%s, videoPath:%s", Integer.valueOf(videoMediaItem.videoFrameRate), videoMediaItem.fPT);
                                if (videoMediaItem.videoFrameRate == 1) {
                                    try {
                                        str = SightVideoJNI.getSimpleMp4Info(videoMediaItem.fPT);
                                        if (!bo.isNullOrNil(str)) {
                                            double optDouble = new JSONObject(str).optDouble("videoFPS");
                                            ab.i("MicroMsg.AlbumPreviewUI", "update from getSimpleMp4Info videoFPS:%s", Double.valueOf(optDouble));
                                            if (optDouble > 0.0d) {
                                                videoMediaItem.videoFrameRate = (int) optDouble;
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                                if (videoMediaItem.videoFrameRate <= 0) {
                                    ab.i("MicroMsg.AlbumPreviewUI", "final videoFrameRate:%s, too small, videoPath:%s", Integer.valueOf(videoMediaItem.videoFrameRate), videoMediaItem.fPT);
                                    com.tencent.mm.plugin.report.service.h.pYm.k(1005, 54, 1);
                                    h.bQ(AlbumPreviewUI.this.mController.ylL, com.tencent.mm.bz.a.an(AlbumPreviewUI.this.mController.ylL, R.string.c3m));
                                    AppMethodBeat.o(21389);
                                    return;
                                }
                            }
                            if (videoMediaItem.fPW >= 10500) {
                                intent2 = new Intent();
                                intent2.putExtra("key_video_path", videoMediaItem.fPT);
                                intent2.putExtra("key_need_clip_video_first", true);
                                intent2.putExtra("key_need_remux_video", false);
                                intent2.putExtra("key_text_color", AlbumPreviewUI.this.getIntent().getStringExtra("key_edit_text_color"));
                                intent2.putExtra("key_max_duration_seconds", AlbumPreviewUI.this.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
                                d.b(AlbumPreviewUI.this.mController.ylL, "mmsight", ".segment.MMSightEditUI", intent2, 4374);
                                AppMethodBeat.o(21389);
                                return;
                            }
                            intent2 = new Intent();
                            intent2.putExtra("K_SEGMENTVIDEOPATH", videoMediaItem.fPT);
                            intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", videoMediaItem.lZg);
                            AlbumPreviewUI.this.setResult(-1, intent2);
                            AlbumPreviewUI.this.finish();
                            AppMethodBeat.o(21389);
                            return;
                        }
                    } else if (AlbumPreviewUI.this.mPy) {
                        if (i < AlbumPreviewUI.this.mPj.mOM.size()) {
                            ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                            AppMethodBeat.o(21389);
                            return;
                        } else if (ws == null) {
                            ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                            AppMethodBeat.o(21389);
                            return;
                        } else if (ws.getType() != 2 || AlbumPreviewUI.this.mPj.mOI.size() == 0) {
                            wr = AlbumPreviewUI.this.mPj.wr(ws.getType());
                            e.B(wr);
                            intent2 = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                            intent2.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mPj.bCw());
                            intent2.putExtra("preview_all", true);
                            intent2.putExtra("preview_position", wr.indexOf(ws));
                            albumPreviewUI = AlbumPreviewUI.this;
                            albumPreviewUI.V(i - albumPreviewUI.mPj.mOM.size(), true);
                            intent2.putExtra("send_raw_img", AlbumPreviewUI.this.kvs);
                            intent2.putExtra("max_select_count", ws.getType() == 2 ? 1 : AlbumPreviewUI.this.mPA);
                            intent2.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                            intent2.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                            AlbumPreviewUI.this.startActivityForResult(intent2, 0);
                            AppMethodBeat.o(21389);
                            return;
                        } else {
                            h.bQ(AlbumPreviewUI.this.mController.ylL, com.tencent.mm.bz.a.an(AlbumPreviewUI.this.mController.ylL, R.string.c3b));
                            AppMethodBeat.o(21389);
                            return;
                        }
                    } else if (i < AlbumPreviewUI.this.mPj.mOM.size()) {
                        ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                        AppMethodBeat.o(21389);
                        return;
                    } else {
                        e.B(AlbumPreviewUI.this.mPj.mOH);
                        intent = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                        intent.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mPj.bCw());
                        intent.putExtra("preview_all", true);
                        intent.putExtra("preview_position", i - AlbumPreviewUI.this.mPj.mOM.size());
                        AlbumPreviewUI albumPreviewUI2 = AlbumPreviewUI.this;
                        albumPreviewUI2.V(i - albumPreviewUI2.mPj.mOM.size(), true);
                        intent.putExtra("send_raw_img", AlbumPreviewUI.this.kvs);
                        intent.putExtra("max_select_count", AlbumPreviewUI.this.mPA);
                        intent.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                        intent.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                        intent.putExtra("album_business_tag", AlbumPreviewUI.this.mOL);
                        intent.putExtra("album_video_max_duration", AlbumPreviewUI.this.gLP);
                        AlbumPreviewUI.this.startActivityForResult(intent, 0);
                    }
                    AppMethodBeat.o(21389);
                } else if (i < AlbumPreviewUI.this.mPj.mOM.size()) {
                    ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                    AppMethodBeat.o(21389);
                } else if (ws == null) {
                    ab.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                    AppMethodBeat.o(21389);
                } else if (ws.getType() != 2 || AlbumPreviewUI.this.mPj.mOI.size() == 0) {
                    wr = AlbumPreviewUI.this.mPj.wr(ws.getType());
                    e.B(wr);
                    intent2 = new Intent(AlbumPreviewUI.this, ImagePreviewUI.class);
                    intent2.putExtra("key_edit_video_max_time_length", AlbumPreviewUI.this.getIntent().getIntExtra("key_edit_video_max_time_length", 10));
                    intent2.putExtra("key_edit_text_color", AlbumPreviewUI.this.getIntent().getStringExtra("key_edit_text_color"));
                    intent2.putStringArrayListExtra("preview_image_list", AlbumPreviewUI.this.mPj.bCw());
                    intent2.putExtra("preview_all", true);
                    intent2.putExtra("preview_position", wr.indexOf(ws));
                    albumPreviewUI = AlbumPreviewUI.this;
                    albumPreviewUI.V(i - albumPreviewUI.mPj.mOM.size(), true);
                    intent2.putExtra("send_raw_img", AlbumPreviewUI.this.kvs);
                    intent2.putExtra("max_select_count", AlbumPreviewUI.this.mPA);
                    intent2.putExtra("GalleryUI_FromUser", AlbumPreviewUI.this.cEV);
                    intent2.putExtra("GalleryUI_ToUser", AlbumPreviewUI.this.toUser);
                    AlbumPreviewUI.this.startActivityForResult(intent2, 0);
                    AppMethodBeat.o(21389);
                } else {
                    h.bQ(AlbumPreviewUI.this.mController.ylL, com.tencent.mm.bz.a.an(AlbumPreviewUI.this.mController.ylL, R.string.c3b));
                    AppMethodBeat.o(21389);
                }
            }
        });
        this.mPj = new a(this, new a.b() {
            public final void W(int i, int i2, int i3) {
                AppMethodBeat.i(21390);
                MediaItem ws = AlbumPreviewUI.this.mPj.ws(AlbumPreviewUI.this.mPj.mOM.size() + i2);
                if (i3 != 0) {
                    AlbumPreviewUI.b(AlbumPreviewUI.this, i);
                    AlbumPreviewUI.this.V(i2, false);
                } else if (ws != null && ws.getType() == 1) {
                    AlbumPreviewUI.a(AlbumPreviewUI.this, ws);
                    AlbumPreviewUI.b(AlbumPreviewUI.this, i);
                    AlbumPreviewUI.this.V(i2, true);
                } else if (ws == null || ws.getType() != 2) {
                    AlbumPreviewUI.b(AlbumPreviewUI.this, i);
                    AlbumPreviewUI.this.V(i2, true);
                } else if (AlbumPreviewUI.b(AlbumPreviewUI.this, ws)) {
                    AlbumPreviewUI.b(AlbumPreviewUI.this, i);
                    AlbumPreviewUI.this.V(i2, true);
                } else {
                    AlbumPreviewUI.this.mPj.mOI.remove(ws);
                    AlbumPreviewUI.this.mPj.notifyDataSetChanged();
                }
                Iterator it = AlbumPreviewUI.this.mPj.bCw().iterator();
                while (it.hasNext()) {
                    if (!r.amo((String) it.next())) {
                        AppMethodBeat.o(21390);
                        return;
                    }
                }
                AlbumPreviewUI.this.kvs = true;
                AppMethodBeat.o(21390);
            }
        });
        if (!bo.isNullOrNil(this.mOL)) {
            ab.d("MicroMsg.AlbumPreviewUI", "businessTag=%s", this.mOL);
            this.mPj.mOL = this.mOL;
            this.mPj.gLP = this.gLP;
            if (this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                e.bBZ().mOt.bBV();
                this.mPI = getIntent().getStringExtra("album_business_bubble_media_by_coordinate_posname");
                final double doubleExtra = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_distance", -1.0d);
                this.longitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_longitude", 91.0d);
                this.latitude = getIntent().getDoubleExtra("album_business_bubble_media_by_coordinate_latitude", 181.0d);
                if (doubleExtra > 0.0d && com.tencent.mm.modelgeo.a.q(this.longitude) && com.tencent.mm.modelgeo.a.r(this.latitude)) {
                    this.mPJ = new b() {
                        public final void b(LinkedList<MediaItem> linkedList, long j) {
                            AppMethodBeat.i(21391);
                            ab.d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
                            if (j != AlbumPreviewUI.this.mPK) {
                                ab.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", Long.valueOf(j), Long.valueOf(AlbumPreviewUI.this.mPK));
                                ab.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
                                AppMethodBeat.o(21391);
                            } else if (linkedList == null || !linkedList.isEmpty()) {
                                ArrayList arrayList = new ArrayList();
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    MediaItem mediaItem = (MediaItem) it.next();
                                    if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.this.latitude, AlbumPreviewUI.this.longitude, mediaItem.bDG, mediaItem.bDH) <= doubleExtra) {
                                        mediaItem.mOn = "album_business_bubble_media_by_coordinate";
                                        arrayList.add(mediaItem);
                                    }
                                }
                                linkedList.removeAll(arrayList);
                                ab.d("MicroMsg.AlbumPreviewUI", "target media size=%d", Integer.valueOf(arrayList.size()));
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    ab.d("MicroMsg.AlbumPreviewUI", "target media item=%s", ((MediaItem) it2.next()).toString());
                                }
                                if (!(linkedList.isEmpty() || arrayList.isEmpty())) {
                                    linkedList.addAll(0, arrayList);
                                }
                                AppMethodBeat.o(21391);
                            } else {
                                ab.d("MicroMsg.AlbumPreviewUI", "mediaItems is empty.");
                                AppMethodBeat.o(21391);
                            }
                        }
                    };
                    l bBZ = e.bBZ();
                    b bVar = this.mPJ;
                    if (bVar != null) {
                        bBZ.mOs.add(bVar);
                    }
                    this.mPj.mON = false;
                }
            }
        }
        if (this.mPu) {
            this.mPj.mON = true;
        }
        if (this.mPy) {
            this.mPj.mON = true;
        }
        this.mPe.setNumColumns(4);
        this.mPe.setOnScrollListener(new OnScrollListener() {
            private Runnable kvR = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21392);
                    AlbumPreviewUI.this.mPk.startAnimation(AnimationUtils.loadAnimation(AlbumPreviewUI.this.mController.ylL, R.anim.b6));
                    AlbumPreviewUI.this.mPk.setVisibility(8);
                    AppMethodBeat.o(21392);
                }
            };

            {
                AppMethodBeat.i(21393);
                AppMethodBeat.o(21393);
            }

            private String bCC() {
                AppMethodBeat.i(21394);
                String wt = AlbumPreviewUI.this.mPj.wt(AlbumPreviewUI.this.mPe.getFirstVisiblePosition());
                if (bo.isNullOrNil(wt) || !wt.equals("album_business_bubble_media_by_coordinate")) {
                    AppMethodBeat.o(21394);
                    return wt;
                }
                wt = AlbumPreviewUI.this.mPI + "附近的照片和视频";
                AppMethodBeat.o(21394);
                return wt;
            }

            private void hD(boolean z) {
                AppMethodBeat.i(21395);
                if (z) {
                    AlbumPreviewUI.this.mPk.removeCallbacks(this.kvR);
                    if (AlbumPreviewUI.this.mPk.getVisibility() != 0) {
                        AlbumPreviewUI.this.mPe.getFirstVisiblePosition();
                        AlbumPreviewUI.this.mPk.setText(bCC());
                        AlbumPreviewUI.this.mPk.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(AlbumPreviewUI.this.mController.ylL, R.anim.b5);
                        AlbumPreviewUI.this.mPk.setVisibility(0);
                        AlbumPreviewUI.this.mPk.startAnimation(loadAnimation);
                        AppMethodBeat.o(21395);
                        return;
                    }
                }
                AlbumPreviewUI.this.mPk.removeCallbacks(this.kvR);
                AlbumPreviewUI.this.mPk.postDelayed(this.kvR, 256);
                AppMethodBeat.o(21395);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                int i2 = 0;
                AppMethodBeat.i(21396);
                ab.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", Integer.valueOf(i));
                if (1 == i) {
                    hD(true);
                    AlbumPreviewUI.this.mPl.setVisibility(8);
                } else if (i == 0) {
                    hD(false);
                }
                if (2 == i) {
                    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, AlbumPreviewUI.this.ehv);
                    AlbumPreviewUI albumPreviewUI = AlbumPreviewUI.this;
                    boolean z = WXHardCoderJNI.hcAlbumScrollEnable;
                    int i3 = WXHardCoderJNI.hcAlbumScrollDelay;
                    int i4 = WXHardCoderJNI.hcAlbumScrollCPU;
                    int i5 = WXHardCoderJNI.hcAlbumScrollIO;
                    if (WXHardCoderJNI.hcAlbumScrollThr) {
                        i2 = Process.myTid();
                    }
                    albumPreviewUI.ehv = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "MicroMsg.AlbumPreviewUI");
                }
                AppMethodBeat.o(21396);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(21397);
                AlbumPreviewUI.this.mPk.setText(bCC());
                AppMethodBeat.o(21397);
            }
        });
        if (getIntent().getBooleanExtra("show_header_view", true)) {
            this.mPj.a(this.mPL);
        }
        this.mPj.mOK = e.bBZ().mOu;
        this.mPj.mOF = this.mPA;
        ab.i("MicroMsg.AlbumPreviewUI", "limit count = " + getIntent().getIntExtra("max_select_count", 9));
        this.mPe.setAdapter(this.mPj);
        updateTitle();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21398);
                ab.i("MicroMsg.AlbumPreviewUI", "backBtn");
                AlbumPreviewUI.this.setResult(-2);
                if (AlbumPreviewUI.this.mPn.aej) {
                    AlbumPreviewUI.this.mPn.bCE();
                    AppMethodBeat.o(21398);
                } else {
                    AlbumPreviewUI.this.finish();
                    AppMethodBeat.o(21398);
                }
                return true;
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.l_);
        if (viewGroup instanceof DrawedCallBackFrameLayout) {
            ((DrawedCallBackFrameLayout) viewGroup).setListener(new com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a() {
                public final void bCv() {
                    AppMethodBeat.i(21399);
                    try {
                        AlbumPreviewUI.this.mOG.bCv();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                    }
                    if (AlbumPreviewUI.this.mPC) {
                        try {
                            AlbumPreviewUI.this.unbindService(AlbumPreviewUI.this.ktl);
                        } catch (Throwable th) {
                            ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", th, "Failed to unbindService when onViewDrawed is invoked.", new Object[0]);
                        }
                        AlbumPreviewUI.this.mPC = false;
                    }
                    AppMethodBeat.o(21399);
                }
            });
        }
        AppMethodBeat.o(21427);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(21429);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            ab.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
            setResult(-2);
            if (this.mPn.aej) {
                this.mPn.bCE();
                AppMethodBeat.o(21429);
                return true;
            }
            finish();
            AppMethodBeat.o(21429);
            return true;
        } else if (i == 82) {
            this.mPE++;
            this.mPn.bCE();
            AppMethodBeat.o(21429);
            return true;
        } else {
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(21429);
            return onKeyDown;
        }
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(21430);
        ab.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        ArrayList arrayList;
        if (4369 != i) {
            ArrayList stringArrayListExtra;
            if (4370 != i) {
                if (4371 != i) {
                    if (4372 != i) {
                        if (4373 != i) {
                            if (4375 != i) {
                                if (4376 != i) {
                                    switch (i2) {
                                        case -2:
                                            ab.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
                                            finish();
                                            break;
                                        case -1:
                                            if (intent == null) {
                                                intent = new Intent();
                                                intent.putExtra("CropImage_Compress_Img", true);
                                                intent.putStringArrayListExtra("CropImage_OutputPath_List", this.mPj.bCw());
                                            }
                                            ab.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
                                            this.mPh = true;
                                            setResult(-1, intent);
                                            bCA();
                                            finish();
                                            break;
                                        case 0:
                                            if (intent != null) {
                                                boolean z;
                                                stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                                                if (stringArrayListExtra != null) {
                                                    this.mPj.C(stringArrayListExtra);
                                                    this.mPj.notifyDataSetChanged();
                                                    wu(stringArrayListExtra.size());
                                                }
                                                if (intent.getBooleanExtra("CropImage_Compress_Img", true)) {
                                                    z = false;
                                                } else {
                                                    z = true;
                                                }
                                                this.kvs = z;
                                                if (!this.kvs) {
                                                    this.mPp.setImageResource(R.raw.radio_off);
                                                    break;
                                                } else {
                                                    this.mPp.setImageResource(R.raw.radio_on);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else if (-1 != i2) {
                                    ab.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
                                    finish();
                                } else if (intent != null) {
                                    AlbumItem albumItem = (AlbumItem) intent.getParcelableExtra("select_folder_name");
                                    a(albumItem);
                                    setMMTitle(bo.bc(albumItem.mOh, getString(R.string.c34)));
                                }
                            } else if (-1 != i2) {
                                AppMethodBeat.o(21430);
                                return;
                            } else {
                                if (intent == null) {
                                    intent = new Intent();
                                }
                                ab.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", intent);
                                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                                if (sightCaptureResult == null) {
                                    ab.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
                                    setResult(1);
                                    finish();
                                    AppMethodBeat.o(21430);
                                    return;
                                }
                                arrayList = new ArrayList();
                                String str = sightCaptureResult.osC;
                                if (!bo.isNullOrNil(str)) {
                                    arrayList.add(str);
                                    intent.putExtra("key_select_video_list", arrayList);
                                }
                                if (sightCaptureResult.osA && !bo.isNullOrNil(sightCaptureResult.osI)) {
                                    arrayList = new ArrayList();
                                    arrayList.add(sightCaptureResult.osI);
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
                                }
                                setResult(-1, intent);
                                finish();
                            }
                        } else {
                            if (intent != null) {
                                intent.putExtra("GalleryUI_IsSendImgBackground", true);
                                ab.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
                            }
                            ab.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
                            setResult(-1, intent);
                            this.mPC = true;
                            finish();
                        }
                    } else if (-1 != i2) {
                        AppMethodBeat.o(21430);
                        return;
                    } else {
                        if (intent == null) {
                            intent = new Intent();
                        }
                        ab.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", intent);
                        stringArrayListExtra = new ArrayList();
                        String stringExtra = getIntent().getStringExtra("video_full_path");
                        if (!bo.isNullOrNil(stringExtra)) {
                            stringArrayListExtra.add(stringExtra);
                            intent.putExtra("key_select_video_list", stringArrayListExtra);
                            intent.putExtra("key_selected_video_is_from_sys_camera", true);
                        }
                        setResult(-1, intent);
                        finish();
                    }
                } else if (-1 != i2) {
                    AppMethodBeat.o(21430);
                    return;
                } else {
                    if (intent != null) {
                        intent.putExtra("from_record", true);
                    }
                    ab.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", intent);
                    setResult(-1, intent);
                    finish();
                }
            } else if (-1 != i2) {
                AppMethodBeat.o(21430);
                return;
            } else if (intent.getBooleanExtra("GalleryUI_IsSendImgBackground", false)) {
                ab.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(21430);
                return;
            } else {
                stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                    ab.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
                    AppMethodBeat.o(21430);
                    return;
                }
                ab.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", stringArrayListExtra);
                setResult(-1, intent);
                finish();
            }
        } else if (-1 != i2) {
            AppMethodBeat.o(21430);
            return;
        } else {
            String h = n.h(this.mController.ylL.getApplicationContext(), intent, com.tencent.mm.compatible.util.e.euR);
            if (bo.isNullOrNil(h)) {
                ab.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
                AppMethodBeat.o(21430);
                return;
            }
            ab.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", h);
            if (e.bBZ().hOZ == 0 || e.bBZ().hOZ == 5 || e.bBZ().hOZ == 11) {
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse("file://" + Uri.encode(h)));
                ab.i("MicroMsg.AlbumPreviewUI", "take photo finish");
                setResult(-1, intent2);
                finish();
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(h);
                Intent intent3 = new Intent(this, ImagePreviewUI.class);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("max_select_count", 1);
                intent3.putExtra("send_raw_img", this.kvs);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("GalleryUI_FromUser", this.cEV);
                intent3.putExtra("GalleryUI_ToUser", this.toUser);
                startActivityForResult(intent3, 4370);
            }
        }
        if (intent != null && intent.getBooleanExtra("show_photo_edit_tip", false)) {
            SharedPreferences sharedPreferences = getSharedPreferences("photo_edit_pref", 0);
            if (!sharedPreferences.getBoolean("has_show_tip", false)) {
                this.mPm.setVisibility(0);
                this.mPm.setText(getString(R.string.dci));
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mController.ylL, R.anim.b5);
                this.mPm.startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    private Runnable mPU = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(21404);
                            AlbumPreviewUI.this.mPm.startAnimation(AnimationUtils.loadAnimation(AlbumPreviewUI.this.mController.ylL, R.anim.b6));
                            AlbumPreviewUI.this.mPm.setVisibility(8);
                            AppMethodBeat.o(21404);
                        }
                    };

                    {
                        AppMethodBeat.i(21405);
                        AppMethodBeat.o(21405);
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(21406);
                        AlbumPreviewUI.this.mPm.setVisibility(0);
                        AlbumPreviewUI.this.mPm.postDelayed(this.mPU, 4000);
                        AppMethodBeat.o(21406);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                sharedPreferences.edit().putBoolean("has_show_tip", true).commit();
            }
        }
        AppMethodBeat.o(21430);
    }

    private void wu(int i) {
        AppMethodBeat.i(21431);
        if (i == 0) {
            this.mPf.setEnabled(false);
            enableOptionMenu(false);
        } else {
            this.mPf.setEnabled(true);
            enableOptionMenu(true);
        }
        if (i == 0) {
            this.mPf.setText(R.string.c3j);
        } else {
            this.mPf.setText(getString(R.string.c3j) + "(" + i + ")");
        }
        updateOptionMenuText(0, wv(i));
        AppMethodBeat.o(21431);
    }

    private String wv(int i) {
        AppMethodBeat.i(21432);
        String string;
        switch (e.bBZ().hOZ) {
            case 4:
            case 8:
            case 13:
                if (i == 0 || this.mPA <= 1) {
                    string = getString(R.string.c3k);
                    AppMethodBeat.o(21432);
                    return string;
                }
                string = getString(R.string.c3k) + "(" + i + "/" + this.mPA + ")";
                AppMethodBeat.o(21432);
                return string;
            case 7:
                if (bo.isNullOrNil(this.mOL) || !this.mOL.equals("album_business_bubble_media_by_coordinate")) {
                    if (i == 0 || this.mPA <= 1) {
                        string = getString(R.string.c3k);
                        AppMethodBeat.o(21432);
                        return string;
                    }
                    string = getString(R.string.c3k) + "(" + i + "/" + this.mPA + ")";
                    AppMethodBeat.o(21432);
                    return string;
                } else if (i == 0 || this.mPA <= 1) {
                    string = getString(R.string.s1);
                    AppMethodBeat.o(21432);
                    return string;
                } else {
                    string = getString(R.string.s1) + "(" + i + "/" + this.mPA + ")";
                    AppMethodBeat.o(21432);
                    return string;
                }
            default:
                if (i == 0 || this.mPA <= 1) {
                    string = getString(R.string.tf);
                    AppMethodBeat.o(21432);
                    return string;
                }
                string = getString(R.string.c3c, new Object[]{Integer.valueOf(i), Integer.valueOf(this.mPA)});
                AppMethodBeat.o(21432);
                return string;
        }
    }

    public final void c(LinkedList<MediaItem> linkedList, long j) {
        boolean z = true;
        AppMethodBeat.i(21433);
        if (j != this.mPK) {
            ab.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", Long.valueOf(j), Long.valueOf(this.mPK));
            ab.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
            AppMethodBeat.o(21433);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        if (linkedList != null) {
            linkedList2.addAll(linkedList);
        }
        String str = "MicroMsg.AlbumPreviewUI";
        String str2 = "[onQueryMediaFinished] adapter is null?:%s";
        Object[] objArr = new Object[1];
        if (this.mPj != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (this.mPj != null) {
            a aVar = new a();
            aVar.mPW = new WeakReference(this.mPj);
            aVar.mPX = new WeakReference(this.ehJ);
            aVar.mPY = new WeakReference(this.mPl);
            aVar.mPZ = new WeakReference(this.mPe);
            aVar.mQa = linkedList2;
            aVar.mQb = new WeakReference(this.mPI);
            e.bCa().d(aVar);
        }
        AppMethodBeat.o(21433);
    }

    private void bCA() {
        AppMethodBeat.i(21434);
        if (this.mPM) {
            SharedPreferences sharedPreferences = getSharedPreferences("gallery_last_choose_album", 0);
            ab.i("MicroMsg.AlbumPreviewUI", "last selected folderName and path: " + this.mPr + ", " + this.mPq);
            sharedPreferences.edit().putString(e.bBZ().mOu, this.mPr + "|" + this.mPq + "|" + this.mPs).commit();
            AppMethodBeat.o(21434);
            return;
        }
        AppMethodBeat.o(21434);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(21435);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(21435);
            return;
        }
        ab.i("MicroMsg.AlbumPreviewUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.dbs), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(21407);
                            AlbumPreviewUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(21407);
                        }
                    }, null);
                    break;
                }
                bCz();
                AppMethodBeat.o(21435);
                return;
        }
        AppMethodBeat.o(21435);
    }

    private boolean a(MediaItem mediaItem) {
        AppMethodBeat.i(21436);
        if (mediaItem == null) {
            ab.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
            AppMethodBeat.o(21436);
            return false;
        } else if (this.mOG == null) {
            ab.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] invoker is null!");
            AppMethodBeat.o(21436);
            return false;
        } else if (e.bBZ().hOZ != 3) {
            AppMethodBeat.o(21436);
            return true;
        } else if (new File(mediaItem.fPT).exists()) {
            try {
                if (this.mOG.ND(mediaItem.fPT) > 300) {
                    h.bP(this, getString(R.string.c43));
                    AppMethodBeat.o(21436);
                    return false;
                }
            } catch (RemoteException e) {
                ab.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
            AppMethodBeat.o(21436);
            return true;
        } else {
            h.bP(this, getString(R.string.c41));
            AppMethodBeat.o(21436);
            return false;
        }
    }

    private void bCz() {
        AppMethodBeat.i(21428);
        if (n.c(this.mController.ylL, com.tencent.mm.compatible.util.e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 4369)) {
            e.bCa().wp(0);
            System.gc();
            AppMethodBeat.o(21428);
            return;
        }
        Toast.makeText(this.mController.ylL, getString(R.string.e29), 1).show();
        AppMethodBeat.o(21428);
    }

    static /* synthetic */ void e(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.i(21437);
        if (albumPreviewUI.kvs) {
            Iterator it = albumPreviewUI.mPj.mOI.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                MediaItem mediaItem = (MediaItem) it.next();
                if (mediaItem != null && mediaItem.getType() == 1) {
                    if (26214400 < com.tencent.mm.a.e.cs(mediaItem.fPT)) {
                        ab.w("MicroMsg.AlbumPreviewUI", "[onClick] item:%s file size:%s", mediaItem, Integer.valueOf(com.tencent.mm.a.e.cs(mediaItem.fPT)));
                        i2++;
                    }
                    i++;
                }
                i = i;
            }
            if (i2 > 0) {
                if (i == i2) {
                    h.bP(albumPreviewUI, albumPreviewUI.getString(R.string.c40));
                    AppMethodBeat.o(21437);
                    return;
                }
                h.bP(albumPreviewUI, albumPreviewUI.getString(R.string.c3x));
            }
        }
        AppMethodBeat.o(21437);
    }

    static /* synthetic */ void g(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.i(21438);
        if (albumPreviewUI.mPj.mOI.size() > 0) {
            albumPreviewUI.enableOptionMenu(true);
            AppMethodBeat.o(21438);
            return;
        }
        albumPreviewUI.enableOptionMenu(false);
        AppMethodBeat.o(21438);
    }

    static /* synthetic */ void s(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.i(21439);
        h.g(albumPreviewUI, R.string.f15, R.string.c4_);
        ab.w("MicroMsg.AlbumPreviewUI", "video is import error");
        AppMethodBeat.o(21439);
    }

    static /* synthetic */ void t(AlbumPreviewUI albumPreviewUI) {
        AppMethodBeat.i(21440);
        h.g(albumPreviewUI, R.string.c49, R.string.c4_);
        ab.w("MicroMsg.AlbumPreviewUI", "video is over size");
        AppMethodBeat.o(21440);
    }

    static /* synthetic */ void W(LinkedList linkedList) {
        AppMethodBeat.i(21446);
        if (linkedList == null) {
            ab.e("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] mMediaItems is null!");
            AppMethodBeat.o(21446);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] size:%s", Integer.valueOf(linkedList.size()));
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            Iterator it2 = e.bCc().iterator();
            while (it2.hasNext()) {
                MediaItem mediaItem2 = (MediaItem) it2.next();
                if (mediaItem2.mOi.equals(mediaItem.fPT)) {
                    ab.d("MicroMsg.AlbumPreviewUI", "item:%s replace editItem:%s", mediaItem, mediaItem2);
                    linkedList.set(i, mediaItem2);
                }
                if (mediaItem2.fPT.equals(mediaItem.fPT)) {
                    ab.d("MicroMsg.AlbumPreviewUI", "remove editItem:%s", mediaItem2);
                    arrayList.add(Integer.valueOf(i));
                }
            }
            i++;
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            linkedList.remove(((Integer) it3.next()).intValue());
        }
        ab.d("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] cost%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(21446);
    }
}
